package exceptions.polinom;

public class Polynomial {
    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        this.coefficients = setUpPolynomial(coefficients);
    }

    private double[] setUpPolynomial(String[] coefficients) {
        double[] values = new double[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {
            try {
                values[i] = Double.parseDouble(coefficients[i]);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Illegal coefficients, not a number", ex);
            }
        }
        return values;
    }

    public double evaluate (double x){
        double result = 0;
        int l = coefficients.length;
        for (int i = 0; i < l; i++){
            result += coefficients[i] * Math.pow(x, l-i-1.0);
        }
        return result;
    }

    public double[] getCoefficients() {
        return coefficients;
    }
}
