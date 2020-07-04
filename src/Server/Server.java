package Server;

public class Server implements IServer{
    IListener listener;
    IChatHelper chatHelper;

    public Server(IListener listener, IChatHelper chatHelper) {
        this.listener = listener;
        this.chatHelper = chatHelper;
        this.listener.setChatHelper(chatHelper);
    }

    @Override
    public void start() {
        listener.listen();
        chatHelper.startChatMaster();
    }
}
