package Server;

public interface IListener {
    void listen();
    void pauseListen();
    void stopListen();
    void resumeListen();
    void setChatHelper(IChatHelper chatHelper);
}

