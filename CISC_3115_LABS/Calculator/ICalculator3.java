public class ICalculator3 extends ICalculator {
        public ICalculator3(int arg) {
                super(arg);
	}
	@Override
	public int div(int arg) {
		if (arg == 0) {
			System.out.println("ZERO DIVIDE ATTEMPTED");
			return getCurrentValue();
		}
		int result = super.div(arg);
		return result;
	}
}
