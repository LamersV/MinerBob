package Char;

import Char.Messages.Message;
import Char.States.StateMachine;

public abstract class Entity {
    private String name;
    protected StateMachine stateMachine;
    protected String destination;
    protected int arriveTime;

    public Entity(String name){
        this.name = name;
        EntityManager.getInstance().registerEntity(this);
    }

    public String getName(){ return name;}

    public boolean HandleMessage(Message msg) throws InterruptedException {
        return stateMachine.HandleMessage(msg);
    }

    //Destinations Config

    public String GetDestination(){
        return destination;
    }

    public void SetDestination(String s){
        destination = s;
    }

    //Arrive Time

    public int GetArriveTime(){
        return arriveTime;
    }

    public void SetArriveTime(){
        switch (destination){
            case "Bar" -> arriveTime = 5;
            case "Home" -> arriveTime = 6;
            case "Bank" -> arriveTime = 4;
            case "Farm" -> arriveTime = 3;
        }
    }

    //State Machine

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public abstract void Update() throws InterruptedException;
}
