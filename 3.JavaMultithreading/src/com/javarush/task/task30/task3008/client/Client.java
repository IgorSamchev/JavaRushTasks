package com.javarush.task.task30.task3008.client;


import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client extends Thread {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress(){
        String serverAddress;
        ConsoleHelper.writeMessage("Enter server address");
        serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Enter port number");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Enter Nickname");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error with connection");
            clientConnected = false;
        }
    }

    @Override
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Stream error");
                System.exit(1);
            }
            if (clientConnected){
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
                while (clientConnected){
                    String message = ConsoleHelper.readString();
                    if (message.equalsIgnoreCase("exit")){
                        break;
                    }else {
                        if (shouldSendTextFromConsole()){
                            sendTextMessage(message);
                        }
                    }
                }
            }else{
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("New user in the chat: " + userName);
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("User left the chat: " + userName);
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            synchronized (Client.this){
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            Message message;

            while (!clientConnected){
                try {
                    message = connection.receive();
                } catch (ClassNotFoundException e) {
                    throw new IOException("Unexpected MessageType");
                } if (message.getType() == MessageType.NAME_REQUEST){
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else {
                    if (message.getType() == MessageType.NAME_ACCEPTED) {
                        notifyConnectionStatusChanged(true);
                    } else throw new IOException("Unexpected MessageType");
                }
            }
        }



        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            Message message;

            while (true){
                try {
                    message = connection.receive();
                } catch (Exception e) {
                    break;
                }
                if (message.getType() == MessageType.TEXT){
                    processIncomingMessage(message.getData());
                }else {
                    if (message.getType() == MessageType.USER_ADDED){
                        informAboutAddingNewUser(message.getData());
                    }else{
                        if (message.getType() == MessageType.USER_REMOVED){
                            informAboutDeletingNewUser(message.getData());
                        } else break;
                    }
                }
            }
            throw new IOException("Unexpected MessageType");
        }

        @Override
        public void run() {
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();

            try {
                Socket socket = new Socket(serverAddress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();

            } catch (IOException  | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
