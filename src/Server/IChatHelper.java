package Server;

public interface IChatHelper {
    void startChatMaster();

    void addClientToQueue(Client client);

    void pause();
    void restart();
}
