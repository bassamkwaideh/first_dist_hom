public class Tools {
	
	
	public static String getCountLetterAndDigit(String s) {
		int numL = 0;
		int numD = 0;
		int rest = 0;
		char[] ch = s.toCharArray();
		for (char c : ch) {
			if (Character.isLetter(c)) {
				numL++;
			} else if (Character.isDigit(c)) {
				numD++;
			} else
				rest++;
		}
		String p = String.format(numL + "ofleters" + numD + "ofdigits" + rest + "rest");
		return p;

	}

}
