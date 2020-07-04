package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.atomic.AtomicBoolean;

public class TCPListener extends Thread implements IListener {
    String address;
    int port;
    IChatHelper chatHelper;
    ServerSocket serverSocket;
    AtomicBoolean runListener = new AtomicBoolean(true);
    AtomicBoolean pauseListener = new AtomicBoolean(false);
    Object monitor = new Object();

    public TCPListener(String address, int port) {
        this.address = address;
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listen() {
        start();
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void pauseListen() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pauseListener.set(true);
    }

    @Override
    public void stopListen() {
        pauseListener.set(false);
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        runListener.set(false);
    }

    @Override
    public void resumeListen() { // возобновить, продолжить.
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        monitor.notify();
    }

    @Override
    public void setChatHelper(IChatHelper chatHelper) {
        this.chatHelper = chatHelper;
    }

}
