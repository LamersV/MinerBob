package Char.States;
import Char.*;
import Char.Messages.Message;

public class FarmerGlobalState implements State<Farmer> {

    private static FarmerGlobalState instance = null;

    private FarmerGlobalState(){};

    public static FarmerGlobalState getInstance(){
        if(instance == null){
            instance = new FarmerGlobalState();
        }
        return instance;
    }

    @Override
    public void Execute(Farmer e) throws InterruptedException {

    }

    @Override
    public void Enter(Farmer e) throws InterruptedException {

    }

    @Override
    public void Exit(Farmer e) throws InterruptedException {

    }

    @Override
    public boolean OnMessage(Farmer e, Message msg) throws InterruptedException {
        if(msg.getMessage().equals("Get to Work!")){
            e.getStateMachine().ChangeState(FakeWork.getInstance());
            return true;
        }else {
            return false;
        }
    }
}
