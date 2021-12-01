package Char;

import Char.States.*;

public class Farmer extends Entity{

    public Farmer(String s){
        super(s);

        stateMachine = new StateMachine<Farmer>(this);
        stateMachine.setCurrentState(LookingWeather.getInstance());
        stateMachine.setGlobalState(FarmerGlobalState.getInstance());
    }

    @Override
    public void Update() throws InterruptedException {
        stateMachine.Update();
    }
}
