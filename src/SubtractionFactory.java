public class SubtractionFactory implements OperationFactory{
    @Override
    public Operation createOperation(double num1, double num2) {
        return new Subtraction(num1, num2);
    }
}
