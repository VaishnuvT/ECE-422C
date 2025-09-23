package assignment1;
import java.util.*;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class Problem3 {
    /* Student Name: Vaishnuv Thiagarajan, Lab Section: 18550 */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        sc.close();

        MaxentTagger tagger = new MaxentTagger("english-caseless-left3words-distsim.tagger");

        String tagged = tagger.tagString(sentence);
        System.out.println(tagged);
    }
}
