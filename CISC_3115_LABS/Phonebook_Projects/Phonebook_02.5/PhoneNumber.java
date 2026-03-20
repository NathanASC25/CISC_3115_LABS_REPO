import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;
public class PhoneNumber {
        private static int numbersRead = 0; 
        private String number = "";
        private static ArrayList<String> numbers = new ArrayList<>();
        private static ArrayList<String> duplicates = new ArrayList<>();
        public PhoneNumber(int areaCode, int exchange, int lineNumber) {
                String areaCodeStr = String.valueOf(areaCode);
                String exchangeStr = String.valueOf(exchange);
                String lineNumberStr = String.valueOf(lineNumber);
                number += "(" + areaCodeStr + ")" + exchangeStr + "-" + lineNumberStr;
        }
        public PhoneNumber(int exchange, int lineNumber) {
                String areaCodeStr = "800";
                String exchangeStr = String.valueOf(exchange);
                String lineNumberStr = String.valueOf(lineNumber);
                number += "(" + areaCodeStr + ")" + exchangeStr + "-" + lineNumberStr;
        }
        public PhoneNumber(String number) {
                this.number = number;
        }
        public String getAreaCode() {
                return number.substring(1, 4);
        }
        public String getExchange() {
                return number.substring(5, 8);
        }
	public String getLineNumber() {
                return number.substring(9);
        }
        public boolean isTollFree() {
                return number.substring(1,2).equals("8");
        }
        public String toString() {
                return number;
        }
        public boolean equals(PhoneNumber phoneNumber) {
                if (number.compareTo(phoneNumber.toString()) == 0) return true;
                return false;
        }
        public static PhoneNumber read(Scanner sc) {
                try {
		        String num = sc.next();
                        numbers.add(num);
                        int index1 = numbers.indexOf(num);
                        if (index1 < numbers.size() - 1) {
                                duplicates.add(num + " at lines " + (index1 + 1) + " and " + numbers.size());
                        }
                        for (int n = 0; n < numbers.size(); n += 1) {
                                if (n != index1 && numbers.get(n).equals(num) && n != numbers.lastIndexOf(num)) {
                                        duplicates.add(num + " at lines " + (n + 1) + " and " + numbers.size());
                                }
                        }
                        numbersRead += 1;
                        return new PhoneNumber(num);
                }
                catch (NoSuchElementException e) {
                        System.out.println("---");
                        System.out.printf("%d phone numbers input.\n", numbersRead);
                        System.out.println("Duplicates found in file: ");
                        for (String num : duplicates) {
                                System.out.printf("%s\n", num);
                        }
                        throw new NoSuchElementException();
                }
                
        }
}
