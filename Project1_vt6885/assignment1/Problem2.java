package assignment1;
import java.util.*;

public class Problem2 {
    /* Student Name: Vaishnuv Thiagarajan, Lab Section: 18550 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String paragraph = sc.nextLine();
        sc.close();

        findDollarWords(paragraph);
    }

    public static void findDollarWords(String paragraph) {
        String[] words = paragraph.split(" ");
        for (String word : words) {
            if (wordValue(word) == 100) {
                System.out.println(word);
            }
        }
    }

    public static int wordValue(String word) {
        int total = 0;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                total += Character.toLowerCase(c) - 'a' + 1;
            }
        }
        return total;
    }
}
