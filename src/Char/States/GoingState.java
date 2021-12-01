package Char.States;

import Char.*;
import Char.Messages.Message;

public class GoingState implements State<Entity>{

    private static GoingState instance = null;

    public static GoingState getInstance(){
        if(instance == null){
            instance = new GoingState();
        }
        return instance;
    }

    @Override
    public void Execute(Entity e) throws InterruptedException {
        for (int a = 0; a < e.GetArriveTime(); a++){
            System.out.print(".");
            Thread.sleep(1000);
        }
        Exit(e);
    }

    @Override
    public void Exit(Entity e) throws InterruptedException {
        System.out.println("\nArrived!");
        switch (e.GetDestination()){
            case "Mine" -> e.getStateMachine().ChangeState(MiningState.getInstance());
            case "Bar" -> e.getStateMachine().ChangeState(DrinkingState.getInstance());
            case "Bank" -> e.getStateMachine().ChangeState(BankingState.getInstance());
            case "House" -> e.getStateMachine().ChangeState(SleepingState.getInstance());
            case "Farm" -> e.getStateMachine().ChangeState(WalkingFarm.getInstance());
            case "Weather" -> e.getStateMachine().ChangeState(LookingWeather.getInstance());
        }
    }

    @Override
    public void Enter(Entity e) throws InterruptedException {
        System.out.println("\n" + e.getName() + " is going to " + e.GetDestination() + "!");
        e.SetArriveTime();

        //Execute(m);
    }

    @Override
    public boolean OnMessage(Entity e, Message m) {
        return false;
    }
}
