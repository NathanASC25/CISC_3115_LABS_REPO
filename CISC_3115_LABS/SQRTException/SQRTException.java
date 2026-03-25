public class SQRTException extends Exception {
	private double originalArgument;
	public SQRTException(double originalArgument) {
		this.originalArgument = originalArgument;
		if (this.originalArgument < 0) {
			System.out.printf("Bad argument to sqrt: %f\n", this.originalArgument);
		}
	}
}
