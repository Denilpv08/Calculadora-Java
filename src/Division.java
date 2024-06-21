public class Division extends Operation{
    public Division(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    public double calculate() {
        if (num2 == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        return num1 / num2;
    }
}
