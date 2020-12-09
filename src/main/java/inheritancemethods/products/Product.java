package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String name;
    private BigDecimal unitWeight;
    private int numberOfDecimals;

    public Product(String name, BigDecimal unitWeight, int numberOfDecimals) {
        this.name = name;
        this.unitWeight = unitWeight;
        this.numberOfDecimals = numberOfDecimals;
    }

    public Product(String name, BigDecimal unitWeight) {
        this.name = name;
        this.unitWeight = unitWeight;
        this.numberOfDecimals = 2;
    }

    public BigDecimal totalWeight(int pieces){
        BigDecimal a = null;
        a = unitWeight.multiply(new BigDecimal(pieces) );
        a.setScale(numberOfDecimals, RoundingMode.HALF_UP);
//rég:        a.setScale(2, BigDecimal.ROUND_UP);
        return a;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }
}
