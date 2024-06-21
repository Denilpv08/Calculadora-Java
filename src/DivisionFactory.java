public class DivisionFactory implements OperationFactory{
    @Override
    public Operation createOperation(double num1, double num2) {
        return new Division(num1, num2);
    }
}
