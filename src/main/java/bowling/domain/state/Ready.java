package bowling.domain.state;

public class Ready extends Running {

    @Override
    public State bowl(int firstPins) {
        Pins downOfPins = new Pins(firstPins);
        if (downOfPins.isStrike()) {
            return new Strike();
        }
        return new FirstBowl(downOfPins);
    }

}
