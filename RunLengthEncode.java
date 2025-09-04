public class RunLengthEncode {
	public static String runLengthEncode(String input) {
		StringBuffer output = new StringBuffer();
		int i = 0;
		while (i < input.length()) {
			int count = 1;
			while (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
				i++;
				count++;
			}
			output.append(count);
			output.append(input.charAt(i));
			i++;
		}
		return output.toString();
	}

    public static void main(String[] args) {
        String input = "aaabbbccdaa";
        String encoded = runLengthEncode(input);
        System.out.println("Input: " + input);
        System.out.println("Encoded: " + encoded);

        String input2 = "AAAAABBBCCDAA";
        String encoded2 = runLengthEncode(input2);
        System.out.println("Input: " + input2);
        System.out.println("Encoded: " + encoded2);
    }
}
