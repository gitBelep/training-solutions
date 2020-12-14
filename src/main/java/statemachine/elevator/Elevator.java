package statemachine.elevator;
import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private ElevatorState state;
    private List<String> history = new ArrayList<>();

    Elevator(ElevatorState state) {
        this.state = state;
        history.add(this.state.getName());
    }

    Elevator() {
        state = ElevatorState.GF_OPEN;
        history.add(this.state.getName());
    }

    public void pushCallButtonOnFirstFloor() {
        while (state.next() != ElevatorState.FF_OPEN){
            state = state.next();
            history.add(state.getName());
        }
        state = state.next();
        history.add(ElevatorState.FF_OPEN.getName());
    }

    public void pushCallButtonOnGroundFloor() {
        while (state.next() != ElevatorState.GF_OPEN){
            state = state.next();
            history.add(state.getName());
        }
        state = state.next();
        history.add(ElevatorState.GF_OPEN.getName());
    }

    public void pushButtonToGoToGroundFloor() {
        while (state.next() != ElevatorState.GF_OPEN){
            state = state.next();
            history.add(state.getName());
        }
        state = state.next();
        history.add(ElevatorState.GF_OPEN.getName());
    }

    public void pushButtonToGoToFirstFloor() {
        while (state.next() != ElevatorState.FF_OPEN){
            state = state.next();
            history.add(state.getName());
        }
        state = state.next();
        history.add(ElevatorState.FF_OPEN.getName());
    }

    public void work() {

    }

    public String getHistory() {
        return history.toString();
    }
}
