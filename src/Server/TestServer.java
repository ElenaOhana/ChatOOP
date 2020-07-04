package Server;

public class TestServer {
    public static void main(String[] args) {
        IListener listener = new TCPListener("127.0.0.1", 8001);
        IChatHelper chatHelper = new TCPChatHelper();
        IServer server = new Server(listener, chatHelper);
        server.start();
    }
}
