package Server;
// Непосредственно сообщение, получаемое от пользователя. У нас будут и служеьные сообщения, которые воспринимаются по-другому.
// поэтому класс MsgBuilder -будет парсить(вытаскивать нужное инфо- служебную часть сообщения и слать ее серверу\понимать какой вид сообщения
// пришел), а так же он будет формировать сообщения для отправления
public class Msg {
    private TypeMsg type;
    private String text;

    Msg(TypeMsg type, String text) {
        this.type = type;
        this.text = text;
    }

    public TypeMsg getType(){
        return type;
    }

    public String getText(){
        return text;
    }

    public void setTypeMsg(TypeMsg type) {
        this.type = type;
    }

    public void setText(String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "type=" + type +
                ", text='" + text + '\'' +
                '}';
    }
}
