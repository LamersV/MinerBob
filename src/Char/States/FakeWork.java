package Char.States;

import Char.EntityManager;
import Char.Farmer;
import Char.Messages.Message;
import Char.Messages.MessageDispatcher;

import java.util.Random;

public class FakeWork implements State<Farmer>{

    private static FakeWork instance = null;

    private FakeWork(){};

    public static FakeWork getInstance(){
        if(instance == null){
            instance = new FakeWork();
        }
        return instance;
    }

    @Override
    public void Execute(Farmer e) throws InterruptedException {
        System.out.println("Pretending to work...");
        System.out.println("I'm mean working on the Farm!");

        int rand = new Random().nextInt(2);
        if(rand == 1){

        }else{
            Exit(e);
        }
    }

    @Override
    public void Enter(Farmer e) throws InterruptedException {

    }

    @Override
    public void Exit(Farmer e) throws InterruptedException {
        MessageDispatcher.getInstance().DispatchMessage(e, EntityManager.getInstance().getEntity("Bob"), "JobsDone!", null);
        e.SetDestination("Weather");
        e.getStateMachine().ChangeState(LookingWeather.getInstance());
    }

    @Override
    public boolean OnMessage(Farmer e, Message m) {
        return false;
    }
}
