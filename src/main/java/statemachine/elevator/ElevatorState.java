package statemachine.elevator;
//nem osztályt vár a konstruktor, ill nem áll meg, hanem minden műveletet végrehajt.

public enum ElevatorState {

    GF_OPEN("Ground Floor Open"){
        ElevatorState next(){
            return ElevatorState.GF_CLOSED_UP;
        }
        },
    GF_CLOSED_UP("Ground Floor Closed"){
        ElevatorState next(){
            return ElevatorState.FF_CLOSED_UP;
        }
    },
    GF_CLOSED_DOWN("Ground Floor Closed"){
        ElevatorState next(){
            return ElevatorState.GF_OPEN;
        }
    },
    FF_CLOSED_UP("First Floor Closed"){
        ElevatorState next(){
            return ElevatorState.FF_OPEN;
        }
    },
    FF_CLOSED_DOWN("First Floor Closed"){
        ElevatorState next(){
            return ElevatorState.GF_CLOSED_DOWN;
        }
    },
    FF_OPEN("First Floor Open"){
        ElevatorState next(){
            return ElevatorState.FF_CLOSED_DOWN;
        }
    };

    final String name;

    ElevatorState(String name) {
        this.name = name;
    }

    abstract ElevatorState next();

    public String getName() {
        return name;
    }
}
