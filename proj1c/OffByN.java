import java.lang.Math;

public class OffByN implements CharacterComparator{
	private int n;
	public OffByN(int n) {
		this.n = n;
	}

	@Override
	public boolean equalChars(char x, char y) {
		if (Math.abs((x - y)) == n) {
			return true;
		}
		else {
			return false;
		}
	}

	/*public static void main(String[] args) {
    	OffByN test = new OffByN(2);
    	System.out.println(test.equalChars('b', 'd')); // true
    	System.out.println(test.equalChars('b', 'e')); // false
  }*/

}