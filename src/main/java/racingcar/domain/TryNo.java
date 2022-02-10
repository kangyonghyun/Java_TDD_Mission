package racingcar.domain;

import java.util.Objects;

public class TryNo {

    private final int no;

    public TryNo(int tryNo) {
        if (tryNo < 0) {
            throw new IllegalArgumentException("게임을 시작할 수 없습니다");
        }
        this.no = tryNo;
    }

    public int race() {
        return this.no - 1;
    }

    public boolean isZero() {
        return this.no == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TryNo tryNo = (TryNo) o;
        return no == tryNo.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

}
