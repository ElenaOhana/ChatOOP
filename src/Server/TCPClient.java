package Server;

import java.io.*;
import java.io.IOException;
import java.net.Socket;

public class TCPClient extends Client {
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public TCPClient(Socket socket) {
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Msg rcvData() {
        //return null;
    }

    @Override
    public boolean sendData(Msg msg) {
        return false;
    }
}
