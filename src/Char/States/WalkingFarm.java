package Char.States;

import Char.Farmer;
import Char.Messages.Message;
import Char.Miner;

import java.util.Random;

public class WalkingFarm implements State<Farmer>{

    private static WalkingFarm instance = null;

    public static WalkingFarm getInstance(){
        if(instance == null){
            instance = new WalkingFarm();
        }
        return instance;
    }

    @Override
    public void Execute(Farmer m) throws InterruptedException {
        while (true){
            int rand = new Random().nextInt(100);
            System.out.print("Walk!");
            Thread.sleep(1000);
            if(rand <= 25){
                break;
            }
        }
        Exit(m);
    }

    @Override
    public void Exit(Farmer m) throws InterruptedException {
        System.out.println("\nTime to go back!");
        m.SetDestination("Weather");
        m.getStateMachine().ChangeState(GoingState.getInstance());
    }

    @Override
    public boolean OnMessage(Farmer c, Message m) {
        return false;
    }

    @Override
    public void Enter(Farmer m) throws InterruptedException {
        System.out.println("\n" + m.getName() + " started to walk around the farm!");
        m.SetArriveTime();
        //Execute(m);
    }
}
