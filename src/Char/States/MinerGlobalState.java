package Char.States;

import Char.Messages.Message;
import Char.Miner;

import java.util.Random;

public class MinerGlobalState implements State<Miner>{

    private static MinerGlobalState instance = null;

    private MinerGlobalState(){};

    public static MinerGlobalState getInstance(){
        if(instance == null){
            instance = new MinerGlobalState();
        }
        return instance;
    }

    @Override
    public void Execute(Miner m) throws InterruptedException {
        int rand = new Random().nextInt(100);
        if(rand <= 30){
            Exit(m);
        }
    }

    @Override
    public void Enter(Miner m) throws InterruptedException {

    }

    @Override
    public void Exit(Miner m) throws InterruptedException {
        m.getStateMachine().ChangeState(VisitBathroom.getInstance());
    }

    @Override
    public boolean OnMessage(Miner m, Message msg) {
        if(msg.getMessage().equals("JobsDone!")){
            m.SetFarmerWorked(true);
            return true;
        }else{
            return false;
        }
    }
}
