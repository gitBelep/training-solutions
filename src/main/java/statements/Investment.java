package statements;

public class Investment {
    private boolean active = true;
    private double cost = 0.25;
    private double interestRate;
    private double fund;

    public Investment(double interestRate, double fund){
        this.interestRate = interestRate;
        this.fund = fund;
            }

     public double getFund(){
        return fund;
    }

    public double close(int day){
        double payedAmount;
        double amount = getFund() - getYield(day)*cost +getYield(day);
        payedAmount = active == true ? amount : 0;
        this.active = false;
        return payedAmount;
    }

    public double getYield(int day){
        return fund * day/365 * (interestRate/100);
    }
}
