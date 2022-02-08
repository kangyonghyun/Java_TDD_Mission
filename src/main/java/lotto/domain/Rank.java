package lotto.domain;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int match, boolean matchBonus) {
        if (match < 3) {
            return MISS;
        }

        Rank rank = valueOf(match);

        if (SECOND.matchCount(match)) {
            if (matchBonus) {
                return SECOND;
            }
            return THIRD;
        }
        return rank;
    }

    private static Rank valueOf(int match) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount(match)) {
                return rank;
            }
        }
        throw new IllegalArgumentException(match + " 유효하지 않는 값입니다");
    }

    private boolean matchCount(int match) {
        return this.countOfMatch == match;
    }

    public Money prize(int countOfMatch) {
        return new Money(countOfMatch * winningMoney);
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

}
