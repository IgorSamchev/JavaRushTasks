package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private final static int SIDE = 9;
    private int countClosedTiles = SIDE * SIDE;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private boolean isGameStopped;
    private final static String MINE = "\uD83D\uDCA3";
    private final static String FLAG = "\uD83D\uDEA9";
    private int score = 0;

    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped){
            restart();
            return;
        }
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void markTile(int x, int y){
        if (gameField[x][y].isOpen || countFlags == 0 && !gameField[x][y].isFlag || isGameStopped) return;
        if (!gameField[x][y].isFlag) {
            gameField[x][y].isFlag = true;
            countFlags--;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        } else {
            gameField[x][y].isFlag = false;
            countFlags++;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        }

    }

    private void openTile(int x, int y) {
        if (gameField[x][y].isOpen || gameField[x][y].isFlag || isGameStopped) return;
        GameObject tmp_go = gameField[x][y];
        if (tmp_go.isOpen || tmp_go.isFlag) {
            return;
        }
        tmp_go.isOpen = true;
        countClosedTiles--;


        if (tmp_go.isMine) {
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else {
            if (tmp_go.countMineNeighbors == 0) {
                setCellValue(x, y, "");
                for (GameObject go:getNeighbors(tmp_go)) {
                    if (!go.isOpen) {
                        openTile(go.y, go.x);
                        score += 5;
                        setScore(score);
                    }
                }
            } else {
                setCellNumber(x, y, tmp_go.countMineNeighbors);
                score += 5;
                setScore(score);

            }
            if (countClosedTiles == countMinesOnField) win();
        }
        setCellColor(x, y, Color.GREEN);

    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (!gameField[y][x].isMine) {
                    List<GameObject> list = getNeighbors(gameField[y][x]);
                    for (GameObject go : list) {
                        if (go.isMine) gameField[y][x].countMineNeighbors++;
                    }
                }

            }
        }
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.AZURE, "Game Over", Color.BLACK, 24);
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.AZURE, "You Win", Color.BLACK, 24);
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        setScore(score);
        countMinesOnField = 0;
        createGame();


    }

    private void createGame() {
        int counter = 0;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                setCellValue(x, y, "");
                boolean isMine = getRandomNumber(10) == 1;
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                if (isMine) counter++;
            }
        }
        countMinesOnField = counter;
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> list = new ArrayList<>();
        int x = gameObject.x;
        int y = gameObject.y;
        if (x == 0) {
            if (y == 0) {
                list.add(gameField[y][x + 1]);
                list.add(gameField[y + 1][0]);
                list.add(gameField[y + 1][x + 1]);
            } else if (y == SIDE - 1) {
                list.add(gameField[y][x + 1]);
                list.add(gameField[y - 1][x]);
                list.add(gameField[y - 1][x + 1]);
            } else {
                list.add(gameField[y - 1][x]);
                list.add(gameField[y - 1][x + 1]);
                list.add(gameField[y][x + 1]);
                list.add(gameField[y + 1][x]);
                list.add(gameField[y + 1][x + 1]);
            }
        } else if (x == SIDE - 1) {
            if (y == 0) {
                list.add(gameField[y][x - 1]);
                list.add(gameField[y + 1][x - 1]);
                list.add(gameField[y + 1][x]);
            } else if (y == SIDE - 1) {
                list.add(gameField[y - 1][x - 1]);
                list.add(gameField[y - 1][x]);
                list.add(gameField[y][x - 1]);
            } else {
                list.add(gameField[y - 1][x - 1]);
                list.add(gameField[y - 1][x]);
                list.add(gameField[y][x - 1]);
                list.add(gameField[y + 1][x]);
                list.add(gameField[y + 1][x - 1]);
            }
        }
        if (y == 0) {
            if (x != 0 && x != SIDE - 1) {
                list.add(gameField[y][x - 1]);
                list.add(gameField[y][x + 1]);
                list.add(gameField[y + 1][x - 1]);
                list.add(gameField[y + 1][x]);
                list.add(gameField[y + 1][x + 1]);
            }
        } else if (y == SIDE - 1) {
            if (x != 0 && x != SIDE - 1) {
                list.add(gameField[y - 1][x - 1]);
                list.add(gameField[y - 1][x]);
                list.add(gameField[y - 1][x + 1]);
                list.add(gameField[y][x - 1]);
                list.add(gameField[y][x + 1]);
            }
        }
        if (x != 0 && x != SIDE - 1 && y != 0 && y != SIDE - 1) {
            list.add(gameField[y - 1][x - 1]);
            list.add(gameField[y - 1][x]);
            list.add(gameField[y - 1][x + 1]);
            list.add(gameField[y][x - 1]);
            list.add(gameField[y][x + 1]);
            list.add(gameField[y + 1][x - 1]);
            list.add(gameField[y + 1][x]);
            list.add(gameField[y + 1][x + 1]);
        }
        return list;
    }
}