package Char.Messages;

import Char.Entity;

public class MessageDispatcher {
    private static MessageDispatcher instance = null;

    private MessageDispatcher(){

    }

    public static MessageDispatcher getInstance(){
        if (instance == null) {
            instance = new MessageDispatcher();
        }
        return instance;
    }

    public void DispatchMessage(Entity msgSender, Entity msgReceiver, String message, Object extraInfo) throws InterruptedException {
        Message msg = new Message(msgSender, msgReceiver, message, extraInfo);

        DeliverMessage(msgReceiver, msg);
    }

    private void DeliverMessage(Entity msgReceiver, Message msg) throws InterruptedException {
        if(!msgReceiver.HandleMessage(msg)){
            System.out.println("ERROR 404! Cannot handle message!");
        }
    }
}
