public class CountDigits {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            int num = i;
            while (num > 0) {
                if (num % 10 == 8) {
                    count++;
                }
                num /= 10;
            }
        }
        System.out.println("The digit 8 appears " + count + " times from 0 to 100.");
    }
}