package bowling.domain.state;

public class Ready implements State {

    @Override
    public State bowl(int firstPins) {
        if (firstPins == 10) {
            return new Strike(firstPins);
        }
        return new FirstBowl(firstPins);
    }

    @Override
    public boolean isFinal() {
        return false;
    }

}
