// Result.java
package assignment2;

public class Result {
    private int blackPegs;
    private int whitePegs;
    
    public Result(int blackPegs, int whitePegs) {
        this.blackPegs = blackPegs;
        this.whitePegs = whitePegs;
    }
    
    public int getBlackPegs() {
        return blackPegs;
    }
    
    public int getWhitePegs() {
        return whitePegs;
    }
    
    public String toString() {
        return blackPegs + "B_" + whitePegs + "W";
    }
}