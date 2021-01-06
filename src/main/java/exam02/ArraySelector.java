package exam02;

public class ArraySelector {

    public String selectEvens(int[] incomingList) {
        String result = "[";
        if (incomingList.length == 0){
            return new String("");
        }

        for (int i = 0; i < incomingList.length; i=i+2){
            result = result + incomingList[i] +", ";
        }
        result = result.substring(0, result.length()-2) + "]";
        return result;
    }

}
