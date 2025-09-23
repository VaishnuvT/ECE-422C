// Code.java
package assignment2;

public class Code {
    private String code;
    
    public Code(String code) {
        this.code = code;
    }
    
    public String toString() {
        return code;
    }
    
    public char getPegAt(int position) {
        return code.charAt(position);
    }
    
    public int getLength() {
        return code.length();
    }
}