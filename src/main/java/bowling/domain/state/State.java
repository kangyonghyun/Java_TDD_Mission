package bowling.domain.state;

public interface State {

    State bowl(int downOfPins);

    boolean isFinal();

}
