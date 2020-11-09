package finalmodifier;

public class TaxCalculator {
    final static int AFA = 27;

    public double tax(double price){
        return price * AFA /100;
    }

    public double priceWithTax(double price){
        return price + tax(price);
    }

    public static void main(String[] args) {
        TaxCalculator tCalc = new TaxCalculator();
        System.out.println("ÁFA-s ár: " + tCalc.priceWithTax(10_000.00) +" HUF");
    }
}
