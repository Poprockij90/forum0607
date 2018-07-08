package myObjects;

public class Message {
    private String nick="";
    private String text="";

    public Message(String nick, String text) {
        this.nick = nick;
        this.text = text;
    }

    public Message() {
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return nick + "          :                " + text ;
    }
}
