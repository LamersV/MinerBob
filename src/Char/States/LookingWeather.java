package Char.States;

import Char.Farmer;
import Char.Messages.Message;
import Char.Miner;

import java.util.Random;

public class LookingWeather implements State<Farmer>{

    private static LookingWeather instance = null;

    public static LookingWeather getInstance(){
        if(instance == null){
            instance = new LookingWeather();
        }
        return instance;
    }

    @Override
    public void Execute(Farmer m) throws InterruptedException {
        while (true){
            int rand = new Random().nextInt(100);
            System.out.print("Look!");
            Thread.sleep(1000);
            if(rand <= 75){
                break;
            }
        }
        Exit(m);
    }

    @Override
    public void Exit(Farmer m) throws InterruptedException {
        System.out.println("\nI'm full! Let's walk around the farm!");
        m.SetDestination("Farm");
        m.getStateMachine().ChangeState(GoingState.getInstance());
    }

    @Override
    public void Enter(Farmer m) throws InterruptedException {
        System.out.println("\n" + m.getName() + " started to look the weather!");
        //Execute(m);
    }

    @Override
    public boolean OnMessage(Farmer e, Message m) {
        return false;
    }
}
