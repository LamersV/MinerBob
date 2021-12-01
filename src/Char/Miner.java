package Char;

import Char.States.MinerGlobalState;
import Char.States.MiningState;
import Char.States.StateMachine;

import java.util.Random;

public class Miner extends Entity {
    private int nuggets;
    private final int maxNuggets;
    private int thirst;
    private final int minThirst, maxThirst;
    private int stamina;
    private final int minStamina, maxStamina;
    private float moneyInBank;

    private boolean farmerWorked;

    public Miner(String s) {
        super(s);
        nuggets = 0;
        maxNuggets = 10;
        thirst = maxThirst = 30;
        minThirst = 0;
        stamina = maxStamina = 50;
        minStamina = 0;
        moneyInBank = 5f;

        stateMachine = new StateMachine<Miner>(this);
        stateMachine.setCurrentState(MiningState.getInstance());
        stateMachine.setGlobalState(MinerGlobalState.getInstance());
    }

    @Override
    public void Update() throws InterruptedException {
        stateMachine.Update();
    }

    //Gains Config

    public void GainGold(int value){
        int rand = new Random().nextInt(6);
        if(rand != 1) nuggets += value;
    }

    public void IncreaseThirst(int value){
        thirst += value;
    }

    public void IncreaseStamina(int value){
        stamina += value;
    }

    //Status Config

    public boolean isThirsty() {
        return thirst <= minThirst;
    }

    public boolean isTired(){
        return stamina <= minStamina;
    }

    public boolean isPocketsFull() {
        return nuggets >= maxNuggets;
    }

    public boolean Drinking(){
        return thirst <= maxThirst;
    }

    public boolean Sleeping(){
        return stamina <= maxStamina;
    }

    //Money Config

    public void Trade(){
        float depositedMoney = nuggets * 2.5f;
        moneyInBank += depositedMoney;
        System.out.println("Deposit: $" + String.format("%.2f", depositedMoney) + " ($" + String.format("%.2f", moneyInBank) + ")");
        nuggets = 0;
    }

    public float GetMoneyInBank(){
        return moneyInBank;
    }

    public void Spend(float value){
        moneyInBank -= value;
    }

    //Verify Farmer Work

    public void SetFarmerWorked(boolean b){
        farmerWorked = b;
    }

    public boolean FarmerWorked(){
        return farmerWorked;
    }

    //ToString

    @Override
    public String toString() {
        return getName() + " ["+
                "Gold = " + nuggets +
                " - Thirst = " + thirst +
                " - Stamina = " + stamina +
                " - Money = $" + String.format("%.2f", moneyInBank) +
                "]";
    }
}
