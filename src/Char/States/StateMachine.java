package Char.States;

import Char.Messages.Message;

public class StateMachine<IntelliChar> {
    private IntelliChar character;
    private State<IntelliChar> currentState;
    private State<IntelliChar> previousState;
    private State<IntelliChar> globalState;

    public StateMachine(IntelliChar myOwner) {
        character = myOwner;
        currentState = null;
        previousState = null;
        globalState = null;
    }

    public void setCurrentState(State<IntelliChar> currentState) {
        this.currentState = currentState;
    }

    public void setPreviousState(State<IntelliChar> previousState) {
        this.previousState = previousState;
    }

    public void setGlobalState(State<IntelliChar> globalState) {
        this.globalState = globalState;
    }

    public void Update() throws InterruptedException {
        if(globalState != null){
            globalState.Execute(character);
        }
        if(currentState != null){
            currentState.Execute(character);
        }
    }

    public void ChangeState(State<IntelliChar> newState) throws InterruptedException {
        previousState = currentState;
        //currentState.Exit(character);
        currentState = newState;
        currentState.Enter(character);
    }

    public void RevertState() throws InterruptedException {
        ChangeState(previousState);
    }

    public State<IntelliChar> getCurrentState() {
        return currentState;
    }

    public State<IntelliChar> getPreviousState() {
        return previousState;
    }

    public State<IntelliChar> getGlobalState() {
        return globalState;
    }

    public boolean HandleMessage(Message msg) throws InterruptedException {

        //Verifica se o estado atual é capaz de lidar com a mensagem recebida
        if(currentState.OnMessage(character, msg)){
            return true;
        }

        //Se o estado atual não sabe lidar com a mensagem, verificamos se existe um estado
        //global e se ele sabe lidar com a mensagem

        if(globalState != null && globalState.OnMessage(character, msg)){
            return true;
        }
        return false;
    }
}
