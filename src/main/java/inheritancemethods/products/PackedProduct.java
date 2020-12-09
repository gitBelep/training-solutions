package inheritancemethods.products;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PackedProduct extends Product{
    int packingUnit;
    BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces){
        BigDecimal a = null;
        if ( pieces % packingUnit == 0) {
            a = weightOfBox.multiply(new BigDecimal(pieces / packingUnit));
        } else {
            a = weightOfBox.multiply(new BigDecimal(pieces / packingUnit + 1));
        }
        a = a.add(super.totalWeight(pieces));
        a.setScale(super.getNumberOfDecimals(), RoundingMode.HALF_UP);
        return a;
    }

    public int getPackingUnit() {
        return packingUnit;
    }
    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }
}
