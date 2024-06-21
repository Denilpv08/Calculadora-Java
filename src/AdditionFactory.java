public class AdditionFactory implements OperationFactory{
    @Override
    public Operation createOperation(double num1, double num2) {
        return new Addition(num1, num2);
    }
}
