package bowling.domain.state;

import java.util.Objects;

public class FirstBowl implements State {

    private final int firstPins;

    public FirstBowl(int downOfPins) {
        this.firstPins = downOfPins;
    }

    @Override
    public State bowl(int downOfPins) {
        return null;
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FirstBowl firstBowl = (FirstBowl) o;
        return firstPins == firstBowl.firstPins;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPins);
    }

}
