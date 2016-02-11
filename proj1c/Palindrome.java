public class Palindrome {
	public static Deque<Character> wordToDeque(String word) {
		LinkedListDequeSolution<Character> converted = new LinkedListDequeSolution<Character>();
		for (int i = 0; i < word.length(); i++) {
			converted.addLast(word.charAt(i));
		}
		return converted;
	}

	public static boolean isPalindrome(String word) {
		LinkedListDequeSolution<Character> forward = new LinkedListDequeSolution<Character>();
		LinkedListDequeSolution<Character> backward = new LinkedListDequeSolution<Character>();
		if (word.length() <= 1) {
			return true;
		}
		else {
			for (int i = 0; i < word.length(); i++) {
				forward.addLast(word.charAt(i));
			}
			for (int i = 0; i < word.length(); i++) {
				backward.addFirst(word.charAt(i));
			}
			for (int i = 0; i < word.length(); i++) {
				if (forward.get(i) != backward.get(i)) {
					return false;
				}
			}
			return true;
		}
	}

	public static boolean isPalindrome(String word, CharacterComparator cc) {
		String reverse = "";
		if (word.length() <= 1) {
			return true;
		}
		else {
			for (int i = word.length() - 1; i >= 0; i--) {
				reverse += word.charAt(i);
			}
			
			int track = 0;
			while (track < (word.length() / 2)) {
				if (!cc.equalChars(word.charAt(track), reverse.charAt(track))){
					return false;
				}
				track++;
			}
	 	return true;
		}
	}

	private static void main(String[] args) {
		wordToDeque("word").printDeque(); // w o r d
		System.out.println(isPalindrome("racecar")); // true
		System.out.println(isPalindrome("notAPalindrome")); // false
		System.out.println(isPalindrome("a")); // true
	}
}