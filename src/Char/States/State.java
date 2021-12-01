package Char.States;

import Char.Messages.Message;

public interface State<IntelliChar> {

    public void Execute(IntelliChar m) throws InterruptedException;
    public void Enter(IntelliChar m) throws InterruptedException;
    public void Exit(IntelliChar m) throws InterruptedException;
    public boolean OnMessage(IntelliChar c, Message m) throws InterruptedException;
}
