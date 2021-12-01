package Game;

import Char.Entity;
import Char.Farmer;
import Char.Miner;
import Char.States.LookingWeather;
import Char.States.MiningState;

public class Game {
    public static Miner m1;
    public static Farmer m2;

    public static void main(String[] args) {
        m1 = new Miner("Bob");
        m2 = new Farmer("Billy");

        PlayGame();
    }

    public static void PlayGame() {
        try {
            while (true){
                m1.getStateMachine().Update();
                m2.getStateMachine().Update();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}