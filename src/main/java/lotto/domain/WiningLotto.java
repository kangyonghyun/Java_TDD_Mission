package lotto.domain;

public class WiningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WiningLotto(Lotto lotto, LottoNumber bonusNo) {
        if (lotto.containBonusNo(bonusNo)) {
            throw new IllegalArgumentException("당첨번호와 보너스번호는 달라야 합니다");
        }
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int match = lotto.match(userLotto);
        boolean matchBonus = userLotto.containBonusNo(bonusNo);
        return Rank.valueOf(match, matchBonus);
    }

}
