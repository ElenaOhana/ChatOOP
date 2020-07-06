package Server;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class TCPChatHelper extends Thread implements IChatHelper {
    ConcurrentLinkedDeque<Client> qClients = new ConcurrentLinkedDeque();
    ConcurrentLinkedDeque<TRM> qThRecMsg = new ConcurrentLinkedDeque<TRM>();
    AtomicBoolean runMaster = new AtomicBoolean(true);
    Mutex pause = new Mutex();

    @Override
    public void startChatMaster() {
        start();
    }

    @Override
    public void run() {

    }

    @Override
    public void addClientToQueue(Client client) {
        qClients.add(client);
    }
}
