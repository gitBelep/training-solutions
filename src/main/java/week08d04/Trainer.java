package week08d04;

public class Trainer {
    private CanMark canMark;

    public Trainer(CanMark canMark) {
        this.canMark = canMark;
    }

    public int giveMark(){
        return canMark.giveMark();
    }

    public static void main(String[] args) {
        Trainer trainerInGoodMood = new Trainer(new GoodMood());
        Trainer trainerInBadMood = new Trainer(new BadMood());

        System.out.println(trainerInBadMood.giveMark());
        System.out.println(trainerInGoodMood.giveMark());
    }
}
