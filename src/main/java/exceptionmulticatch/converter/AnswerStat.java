package exceptionmulticatch.converter;

public class AnswerStat {
    BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        if (binaryStringConverter == null) {
            throw new InvalidBinaryStringException("binaryString null", new NullPointerException());
        }
        this.binaryStringConverter = binaryStringConverter;
    }


    public boolean[] convert(String str) {
        try {
            return binaryStringConverter.binaryStringToBooleanArray(str);
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException("EZ MOST NEM KELL SEMMIRE", ex);
        }
    }


    public int answerTruePercent(String answers) {
        int trues = 0;
        boolean[] boo = binaryStringConverter.binaryStringToBooleanArray(answers);
        for (boolean b : boo){
            if ( b ){
                trues++;
            }
        }
        if ( boo.length == 0){
            return 0;
        }
        return trues * 100 / boo.length;
    }
}
