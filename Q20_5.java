class Q20_5{
	public static void main(String[] args){

	}
	int shortest(String[] words, String word1, String word2) {
		int pos = 0;
		int min = Integer.MAX_VALUE / 2;
		int word1_pos = -min;
		int word2_pos = -min;
		for (int i = 0; i < words.length; i++) {
			String current_word = words[i];
			if (current_word.equals(word1)) {
				word1_pos = pos;
				// Comment following 3 lines if word order matters
				int distance = word1_pos - word2_pos;
				if (min > distance)
				min = distance;
			} else if (current_word.equals(word2)) {
				word2_pos = pos;
				int distance = word2_pos - word1_pos;
				if (min > distance) min = distance;
			}
			++pos;
		}
	    return min;
	}

}
