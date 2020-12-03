package staticattrmeth.bank;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankTransaction {
    private static int numberOfTransaktions;
//  private static long trxSumValue;
    private static BigDecimal trxSumValue = new BigDecimal(0);
    private static long min;
    private static long max;
    private static long currentMinValue;
    private static long currentMaxValue;
    private long trxValue;

    public BankTransaction(long trxValue) {
        revise(trxValue);
        this.trxValue = trxValue;
        numberOfTransaktions++;
        giveCurrentValues(trxValue);
        trxSumValue = trxSumValue.add(new BigDecimal(trxValue));
    }

    public static void initTheDay(){
        numberOfTransaktions = 0;
        trxSumValue = new BigDecimal(0);
        min = 1L;
        max = 10_000_000L;
        currentMinValue = 10_000_000L;
        currentMaxValue = 0L;
     }

    public static BigDecimal averageOfTransaction(){
        return trxSumValue.divide(new BigDecimal(numberOfTransaktions), 0, RoundingMode.HALF_UP);
//      return new BigDecimal(T_T_trxSumValue / numberOfTransaktions);
    }

    public static BigDecimal getSumOfTrxs(){
        return trxSumValue;
    }

    private void giveCurrentValues(long amount){
        if (amount < currentMinValue){
            currentMinValue = amount;
        }
        if (currentMaxValue < amount){
            currentMaxValue = amount;
        }
    }

    public static int getNumberOfTransaktions() {
        return numberOfTransaktions;
    }
    public static BigDecimal getTrxSumValue() {
        return trxSumValue;
    }
    public long getTrxValue() {
        return trxValue;
    }
    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }
    public static long getCurrentMinValue() {
        return max == currentMinValue ? 0L : currentMinValue;
    }

    private void revise(long amount){
        if (amount < min || max < amount ) {
            throw new IllegalArgumentException("Amount is not acceptable");
        }
    }
}
