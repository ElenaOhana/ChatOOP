package Server;

public class TCPChatHelper extends Thread implements IChatHelper {
    @Override
    public void startChatMaster() {
        start();
    }
}
