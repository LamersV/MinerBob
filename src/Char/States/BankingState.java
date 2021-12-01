package Char.States;

import Char.Messages.Message;
import Char.Miner;

public class BankingState implements State<Miner>{

    private static BankingState instance = null;

    public static BankingState getInstance(){
        if(instance == null){
            instance = new BankingState();
        }
        return instance;
    }

    @Override
    public void Execute(Miner m) throws InterruptedException {
        Thread.sleep(1000);
        m.Trade();
        Thread.sleep(1000);
        Exit(m);
    }

    @Override
    public void Exit(Miner m) throws InterruptedException {
        if(m.isTired()) m.SetDestination("House");
        else m.SetDestination("Mine");

        System.out.println("\nI'm traded all nuggets! Let's go to " + m.GetDestination() + "!");

        m.getStateMachine().ChangeState(GoingState.getInstance());
    }

    @Override
    public void Enter(Miner m) throws InterruptedException {
        System.out.println("\n" + m.getName() + " started trading gold nuggets into cash!");
        //Execute(m);
    }

    @Override
    public boolean OnMessage(Miner c, Message m) {
        return false;
    }
}
