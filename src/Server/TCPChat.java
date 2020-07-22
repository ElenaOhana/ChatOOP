package Server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TCPChat extends Thread implements IChat {
    String chatName;
    IChatHelper chatHelper;
    List<Client> clientsList = new ArrayList<>();
    ConcurrentLinkedQueue<Client> qClients = new ConcurrentLinkedQueue();
    ConcurrentLinkedQueue<RcvMsgClient> waitMsg = new ConcurrentLinkedQueue();

    public TCPChat(String name) {
        this.chatName = name;
    }

    public TCPChat(String name,  IChatHelper chatHelper) {
        this.chatName=name;
        this.chatHelper=chatHelper;
    }

    @Override
    public void startChat() {
        start();
    }

    class RcvMsgClient {
        Client client;
        ThreadReceiveMsg thread;

        public Client getClient() {
            return client;
        }
        public void setClient(Client client) {
            this.client = client;
        }

        public ThreadReceiveMsg getThread() {
            return thread;
        }

        public void setThread(ThreadReceiveMsg thread) {
            this.thread = thread;
        }
    }
}
