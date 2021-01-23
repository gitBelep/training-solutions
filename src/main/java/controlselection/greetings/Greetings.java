package controlselection.greetings;

public class Greetings {
    public String sayGreeting(int hour, int min){
        if (hour<5){
            return "Good night";
        }else if(hour <9){
            return  "Good morning";
        }else if (hour <= 17 || hour == 18 && min <= 30){
            return "Good afternoon";
        }else if(hour < 20){
            return  "Good evening";
        }else{
            return "Good night";
        }
    }
}
