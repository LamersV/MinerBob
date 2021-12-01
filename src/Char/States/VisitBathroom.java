package Char.States;
import Char.Messages.Message;
import Char.Miner;

public class VisitBathroom implements State<Miner> {

    private static VisitBathroom instance = null;

    private VisitBathroom(){};

    public static VisitBathroom getInstance(){
        if(instance == null){
            instance = new VisitBathroom();
        }
        return instance;
    }

    @Override
    public void Execute(Miner m) throws InterruptedException {
        for (int i = 0; i < 3; i++){
            System.out.print("pi");
            Thread.sleep(1000);
        }
        System.out.print("\n");
        Exit(m);
    }

    @Override
    public void Enter(Miner m) throws InterruptedException {
        System.out.println("\nDamn! I need to pee! It's bathroom time!");
        Thread.sleep(1000);
        //Execute(m);
    }

    @Override
    public void Exit(Miner m) throws InterruptedException {
        m.getStateMachine().RevertState();
    }

    @Override
    public boolean OnMessage(Miner c, Message m) {
        return false;
    }
}
