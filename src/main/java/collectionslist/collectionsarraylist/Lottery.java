package collectionslist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount){
        if (ballCount <= lotteryType){
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        List<Integer> balls = makeBallList(ballCount);
        List<Integer> selectedBalls = balls.subList(0, lotteryType);
        Collections.sort(selectedBalls);
        return selectedBalls;
    }

    private List<Integer> makeBallList(int ballCount){
        List<Integer> balls = new ArrayList<>();
        for (int i = 1; i <= ballCount; i++){
            balls.add(i);
        }
        Collections.shuffle(balls);
        return balls;
    }
}
