package bowling.domain.state;

import java.util.Objects;

public class Strike implements State {

    private final int downOfPins;

    public Strike(int firstPins) {
        this.downOfPins = firstPins;
    }

    @Override
    public State bowl(int downOfPins) {
        return null;
    }

    @Override
    public boolean isFinal() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Strike strike = (Strike) o;
        return downOfPins == strike.downOfPins;
    }

    @Override
    public int hashCode() {
        return Objects.hash(downOfPins);
    }
}
