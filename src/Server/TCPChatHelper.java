package Server;

import sun.awt.Mutex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class TCPChatHelper extends Thread implements IChatHelper {
    List<IChat> chatList = Collections.synchronizedList(new ArrayList<>());
    ConcurrentLinkedDeque<Client> qClients = new ConcurrentLinkedDeque();
    ConcurrentLinkedDeque<TRM> qThRecMsg = new ConcurrentLinkedDeque<TRM>();
    AtomicBoolean runMaster = new AtomicBoolean(true);
    Mutex pause = new Mutex();

    @Override
    public void startChatMaster() {
        start();
    }

    @Override
    public void pause() {
        pause.lock();
    }
    @Override
    public void restart() {
        pause.unlock();
    }

    @Override
    public void run() {
        System.out.println("run() from TCPChatHelper is started.");
        IChat chat = new TCPChat("global_chat");
        chatList.add(chat);
        chat.startChat();
        runMaster = new AtomicBoolean(true);
        while (runMaster.get()) {
            pause.lock()  ;
            while (!qClients.isEmpty()) {

            }
        }

    }

    @Override
    public void addClientToQueue(Client client) {
        qClients.add(client);
    }

}
