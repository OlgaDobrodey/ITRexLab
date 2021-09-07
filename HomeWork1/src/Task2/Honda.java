package Task2;

public class Honda extends Car{

    public Honda(String kind, String model, int year, String color, int maxSpeed) {
        super(kind, model, year, color, maxSpeed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Honda car = (Honda) o;
        return  getYear() == car.getYear() && getMaxSpeed() == car.getMaxSpeed()
                && getKind().equals(car.getKind()) && getModel().equals(car.getModel()) && getColor().equals(car.getColor());

    }

    @Override
    public int hashCode() {
        return 41*super.hashCode();
    }

    @Override
    public String toString() {
        return "Honda {"+getKind()+", "+ getModel()+", " +getYear()+", "+getColor()+", " +getMaxSpeed()+'}';
    }
}
