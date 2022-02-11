package racingcar.domain;

import java.util.Objects;

public class Position {

    public static final int MIN_POSITION = 0;
    private final int pos;

    public Position() {
        this(0);
    }

    public Position(int pos) {
        if (pos < MIN_POSITION) {
            throw new IllegalArgumentException("위치값은 0 이상입니다.");
        }
        this.pos = pos;
    }

    public int increment() {
        return this.pos + 1;
    }

    public boolean isMoreThan(Position other) {
        return this.pos > other.pos;
    }

    public boolean isSame(Position other) {
        return this.pos == other.pos;
    }

    public int getPosition() {
        return this.pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return pos == position.pos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos);
    }

}
