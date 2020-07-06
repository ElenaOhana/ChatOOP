package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
        runListener.set(true);
        while (runListener.get() && chatHelper != null) {
            if (pauseListener.get()){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            TCPClient tcpClient = new TCPClient(socket);
            chatHelper.addClientToQueue(tcpClient);
        }
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
