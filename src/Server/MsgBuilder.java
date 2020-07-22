package Server;

public class MsgBuilder {
    public static Msg parserMsgText(String massage) {
        if(massage!=null && massage.length()!=0 && massage.charAt(0)=='[')
        {
            int closing = massage.indexOf(']');
            if(closing!=-1 && closing>1) {
                String  type = massage.substring(1, closing ).toUpperCase();
                switch (type)
                {
                    case "NAME":
                        return new Msg(TypeMsg.NAME, massage.length()-1 != closing ? massage.substring(closing+1): "name");
                    case "OUT":
                        return new Msg(TypeMsg.OUT, null);
                    case "JOIN":
                        System.out.println("msgBuilderJOIN");
                        return new Msg(TypeMsg.JOIN, massage.substring(closing+1));
                    case "NEWCHAT":
                        return new Msg(TypeMsg.NEWCHAT, massage.substring(closing+1));
                    case "LISTCHATS":
                        System.out.println("msgBuilderLISTCHATS");
                        return new Msg(TypeMsg.LISTCHATS, massage);

                    default:
                        System.out.println("defULT OPTION FROM CHEK MASEGE ");
                        System.out.println(type);
                        System.out.println(type);
                        System.out.println(type);

                        return new Msg(TypeMsg.TXT, massage.substring(closing+1));
                }
            }
            else
            {
                return new Msg(TypeMsg.TXT, massage);
            }
        }
        else if(massage!=null && massage.length()!=0)
        {
            return new Msg(TypeMsg.TXT, massage);
        }

        return null;
    }//todo
}
