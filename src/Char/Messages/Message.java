package Char.Messages;

import Char.Entity;

public class Message {
    private Entity sender;
    private Entity receiver;
    private String msg;
    private Object extraInfo;

    public Message(Entity sender, Entity receiver, String msg, Object extraInfo) {
        this.sender = sender;
        this.receiver = receiver;
        this.msg = msg;
        this.extraInfo = extraInfo;
    }

    public String getMessage(){
        return msg;
    }
}
