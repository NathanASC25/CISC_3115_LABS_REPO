import java.util.Scanner;
public class PhoneNumber2 {
        private String number = "";
        public PhoneNumber2(int areaCode, int exchange, int lineNumber) {
                String areaCodeStr = String.valueOf(areaCode);
                String exchangeStr = String.valueOf(exchange);
                String lineNumberStr = String.valueOf(lineNumber);
                number += "(" + areaCodeStr + ")" + exchangeStr + "-" + lineNumberStr;
        }
        public PhoneNumber2(int exchange, int lineNumber) {
                String areaCodeStr = "800";
                String exchangeStr = String.valueOf(exchange);
                String lineNumberStr = String.valueOf(lineNumber);
                number += "(" + areaCodeStr + ")" + exchangeStr + "-" + lineNumberStr;
        }
        public PhoneNumber2(String number) {
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
        public boolean equals(PhoneNumber2 phoneNumber) {
                if (number.compareTo(phoneNumber.toString()) == 0) return true;
                return false;
        }
        public static PhoneNumber2 read(Scanner sc) {
                if (sc.hasNext()) {
                        String num = sc.next();
                        return new PhoneNumber2(num);
                }
                return null;
        }
}
