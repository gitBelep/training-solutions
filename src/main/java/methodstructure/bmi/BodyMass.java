package methodstructure.bmi;

public class BodyMass {
    private double weight;
    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public BmiCategory body(){
        if (this.bodyMassIndex() < 18.5) {
            return BmiCategory.UNDERWEIGHT;
        } else if (this.bodyMassIndex() <= 25){
            return BmiCategory.NORMAL;
        } else {
            return BmiCategory.OVERWEIGHT;
        }
    }

    public boolean isThinnerThan(BodyMass bm){
        return (this.bodyMassIndex() < bm.bodyMassIndex());
    }

    public double bodyMassIndex(){
        return weight / (height * height);
    }

    public double getWeight() {
        return weight;
    }
    public double getHeight() {
        return height;
    }
}
