package week08d01;
//Coordinate-ben lehetne változtatni x és y-t pl: increase()
//Nem szerencsés Stringgel visszatérni
//  Lehet kétdimenziós tömb is, hisz koordináta.
//Kicit hosszú a method, ketté lehetne venni:
//  str értelmezés
//  switch
//moveOneStep(str.charAt(i)) is lehet

 class Robot {
    private String str;
    private Coordinate coo;

    public Robot() {
        this.coo = new Coordinate(0,0);
    }

    public Coordinate move(String str){
        str = str.toUpperCase() + " ";
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
                default:
                    throw new IllegalArgumentException("Non existing direction");
            }
        }
        return coo;
    }
}
