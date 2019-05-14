package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private final static int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (!gameField[y][x].isMine){
                    List<GameObject> list = getNeighbors(gameField[y][x]);
                    for (GameObject go : list){
                        if (go.isMine) gameField[y][x].countMineNeighbors++;
                    }
                }

            }
        }
    }

    private void createGame() {
        int counter = 0;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) == 1;
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                if (isMine) counter++;
            }
        }
        countMinesOnField = counter;
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