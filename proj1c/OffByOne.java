import java.lang.Math;

public class OffByOne implements CharacterComparator {
	@Override
	public boolean equalChars(char x, char y) {
		if (Math.abs((x - y)) == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	/*public static void main(String[] args) {
		OffByOne test = new OffByOne();
		System.out.println(test.equalChars('a', 'b')); // true
		System.out.println(test.equalChars('a', 'a')); // false
		System.out.println(test.equalChars('a', 'c')); // false
	}*/
}