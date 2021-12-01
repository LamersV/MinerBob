package Char.States;

import Char.Messages.Message;
import Char.Miner;

public class DrinkingState implements State<Miner>{

    private static DrinkingState instance = null;

    public static DrinkingState getInstance(){
        if(instance == null){
            instance = new DrinkingState();
        }
        return instance;
    }

    @Override
    public void Execute(Miner m) throws InterruptedException {
        int i = 0;
        while (m.Drinking()){
            i++;
            System.out.print("Slurp!");
            m.IncreaseThirst(4);
            m.IncreaseStamina(1);
            Thread.sleep(1000);
        }
        float beerCost = i * 0.8f;
        m.Spend(beerCost);
        System.out.println("\nCost: $" + String.format("%.2f", beerCost) + " (Money in Bank: $" + String.format("%.2f", m.GetMoneyInBank()) + ")");
        Thread.sleep(1000);
        Exit(m);
    }

    @Override
    public void Exit(Miner m) throws InterruptedException {
        System.out.println("\nI'm full! Let's go back to mine!");
        m.SetDestination("Mine");
        m.getStateMachine().ChangeState(GoingState.getInstance());
    }

    @Override
    public void Enter(Miner m) throws InterruptedException {
        System.out.println("\n" + m.getName() + " started to drink some beer!");
        //Execute(m);
    }

    @Override
    public boolean OnMessage(Miner c, Message m) {
        return false;
    }
}
