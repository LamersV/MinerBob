package Char.States;

import Char.*;
import Char.Messages.Message;
import Char.Messages.MessageDispatcher;

public class SleepingState implements State<Miner>{

    private static SleepingState instance = null;

    public static SleepingState getInstance(){
        if(instance == null){
            instance = new SleepingState();
        }
        return instance;
    }

    @Override
    public void Execute(Miner e) throws InterruptedException {
        while (e.Sleeping()){
            System.out.print("z");
            e.IncreaseStamina(6);
            Thread.sleep(1000);
        }
        if(!e.FarmerWorked()){
            System.out.println("Waiting for my lazy brother to finish his work...");
            while (!e.FarmerWorked()){
                //Do nothing
            }
        }
        Exit(e);
    }

    @Override
    public void Exit(Miner e) throws InterruptedException {
        System.out.println("\nI'm rested! Let's go back to mine!");
        e.SetDestination("Mine");
        e.getStateMachine().ChangeState(GoingState.getInstance());
    }

    @Override
    public void Enter(Miner e) throws InterruptedException {
        e.SetFarmerWorked(false);

        Entity f = EntityManager.getInstance().getEntity("Billy");

        MessageDispatcher.getInstance().DispatchMessage(e, f, "Get to Work!", null);

        System.out.println("\n" + e.getName() + " started to sleep!");
        //Execute(m);
    }

    @Override
    public boolean OnMessage(Miner c, Message m) {
        return false;
    }
}
