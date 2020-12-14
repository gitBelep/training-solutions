package week08d01;

public class Robot {
    private String str;
    private Coordinate coo;

    public Robot() {
        this.coo = new Coordinate(0,0);
    }

    public String move(String str){
        str = str + " ";
        String way = "";
        for (int i = 0; i < str.length(); i++){
            way= str.substring(i, i+1);
            switch (way) {
                case "F":
                    coo.setY(coo.getY()+1);
                    break;
                case "L":
                    coo.setY(coo.getY()-1);
                    break;
                case "J":
                    coo.setX(coo.getX()+1);
                    break;
                case "B":
                    coo.setX(coo.getX()-1);
                    break;
            }
        }
        return "X="+ coo.getX() +", Y="+ coo.getY();
    }
}
