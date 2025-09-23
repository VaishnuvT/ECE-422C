package assignment1;
import java.util.*;

public class Problem1 {
    /* Student Name: Vaishnuv Thiagarajan, Lab Section: 18550 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String s = sc.nextLine().trim();
        sc.close();

        System.out.println(findGreatestProduct(n, s));
    }

    public static long findGreatestProduct(int n, String s) {
        long maxProduct = 0;
        for (int k = 1; k <= n; k++) {  // check all lengths from 1..n
            for (int i = 0; i <= s.length() - k; i++) {
                long product = 1;
                for (int j = 0; j < k; j++) {
                    int digit = s.charAt(i + j) - '0';
                    product *= digit;
                }
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }
}
