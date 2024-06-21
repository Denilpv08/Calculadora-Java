public class MultiplicationFactory implements OperationFactory{
    @Override
    public Operation createOperation(double num1, double num2) {
        return new Multiplication(num1, num2);
    }
}
