package bowling.domain.state;

public class StateFactory {

    private static final State ready = new Ready();

    public static State ready() {
        return ready;
    }

    public static State firstBowl(int downOfPins) {
        return ready().bowl(downOfPins);
    }

}
