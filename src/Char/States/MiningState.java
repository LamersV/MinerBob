package Char.States;

import Char.Messages.Message;
import Char.Miner;

public class MiningState implements State<Miner>{

    private static MiningState instance = null;

    public static MiningState getInstance(){
        if(instance == null){
            instance = new MiningState();
        }
        return instance;
    }

    @Override
    public void Execute(Miner m) throws InterruptedException {
        while (!m.isThirsty() && !m.isTired() && !m.isPocketsFull()){
            m.GainGold(1);
            m.IncreaseStamina(-3);
            m.IncreaseThirst(-4);

            System.out.println(m);
            Thread.sleep(1000);
        }
        Exit(m);
    }

    @Override
    public void Exit(Miner m) throws InterruptedException {
        if(m.isPocketsFull() || m.isTired()){
            m.SetDestination("Bank");
        }
        else if(m.isThirsty()) m.SetDestination("Bar");

        m.getStateMachine().ChangeState(GoingState.getInstance());
    }

    @Override
    public void Enter(Miner m) throws InterruptedException {
        System.out.println("\n" + m.getName() + " started mining!");
        //Execute(m);
    }

    @Override
    public boolean OnMessage(Miner c, Message m) {
        return false;
    }
}
