public class ICalculator {
    private int currentValue;
    public ICalculator(int currentValue) {
	this.currentValue = currentValue;
    }
    public int add(int arg) {
        return currentValue += arg;
    }
    public int sub(int arg) {
        return currentValue -= arg;
    }
    public int mul(int arg) {
        return currentValue *= arg;
    }
    public int div(int arg) {
        return currentValue /= arg;
    }
    public int getCurrentValue() {
        return currentValue;
    }
}
