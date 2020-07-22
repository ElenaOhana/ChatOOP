package Server;

public class ThreadReceiveMsg extends Thread {
    Client client;
    Msg msg;

    public ThreadReceiveMsg(Client client) {
        this.client = client;
    }

    public Msg getMsg(){
        return msg;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public void run() {
        if (client != null) {
            msg = client.rcvData();
            System.out.println("ThreadReceiveMsg");
        } else {
            System.out.println("Null thread rcv");
        }
    }
}
