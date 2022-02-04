package lotto.domain;

public class Money {

    private final int orderPrice;

    public Money(int orderPrice) {
        if (orderPrice < 1000) {
            throw new IllegalArgumentException("1000원 이상을 입력해주세요");
        }
        this.orderPrice = orderPrice;
    }

    public int countOfBuyingLotto() {
        return this.orderPrice / 1000;
    }

}
