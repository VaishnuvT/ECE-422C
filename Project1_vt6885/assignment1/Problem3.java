package assignment1;
import java.util.*;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class Problem3 {
    /* Student Name: Vaishnuv Thiagarajan, Lab Section: 18550 */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        sc.close();

        // Load the POS tagger model (adjust path to where the model is stored)
        String modelPath = "models/english-left3words-distsim.tagger";
        MaxentTagger tagger = new MaxentTagger(modelPath);

        String tagged = tagger.tagString(sentence);
        System.out.println(tagged);
    }
}
