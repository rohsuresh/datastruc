import static org.junit.Assert.*;
import org.junit.Test;

public class TestLinkedListDeque1B {

	@Test
	public void testIsEmpty() {
		StudentLinkedListDeque<Integer> testLink = new StudentLinkedListDeque<Integer>();
		assertEquals(true, testLink.isEmpty());
		testLink.addFirst(2);
		assertEquals(false, testLink.isEmpty());
		testLink.removeFirst();
		assertEquals(true, testLink.isEmpty());
	}

	@Test
	public void testAdd() {
		StudentLinkedListDeque<Integer> testLink = new StudentLinkedListDeque<Integer>();
		testLink.addFirst(0);
		testLink.addLast(8);
		testLink.addFirst(5);
		testLink.addFirst(2);
		testLink.addLast(6);
		// 2 5 0 8 6
		assertEquals(new Integer(0), (Integer) testLink.get(2));
		assertEquals(new Integer(8), (Integer) testLink.get(3));
	}

	@Test
	public void testSize() {
		StudentLinkedListDeque<Integer> testLink = new StudentLinkedListDeque<Integer>();
		assertEquals(new Integer(0), (Integer) testLink.size());
		testLink.removeFirst();
		assertEquals(new Integer(0), (Integer) testLink.size());
		testLink.addFirst(0);
		testLink.addLast(1);
		testLink.addLast(1);
		testLink.addLast(1);
		testLink.addLast(1);
		testLink.addLast(1);
		testLink.addLast(1);
		testLink.addLast(1);
		testLink.addLast(1);
		// 0 1 1 1 1 1 1 1 1
		assertEquals(new Integer(9), (Integer) testLink.size());
		testLink.removeLast();
		testLink.removeFirst();
		// 1 1 1 1 1 1 1
		assertEquals(new Integer(7), (Integer) testLink.size());
	}

	@Test
	public void TestRemove() {
		StudentLinkedListDeque<Integer> testLink = new StudentLinkedListDeque<Integer>();
		testLink.addFirst(0);
		testLink.addLast(1);
		testLink.addLast(2);
		testLink.addLast(3);
		testLink.addLast(4);
		testLink.addLast(5);
		testLink.addLast(6);
		testLink.addLast(7);
		testLink.addLast(8);
		// 0 1 2 3 4 5 6 7 8
		assertEquals(new Integer(0), (Integer) testLink.removeFirst());
		assertEquals(new Integer(8), (Integer) testLink.removeLast());
		assertEquals(new Integer(7), (Integer) testLink.removeLast());
		assertEquals(new Integer(6), (Integer) testLink.removeLast());
		assertEquals(new Integer(5), (Integer) testLink.removeLast());
		assertEquals(new Integer(1), (Integer) testLink.removeFirst());
		assertEquals(new Integer(2), (Integer) testLink.removeFirst());
		// 3 4
		assertEquals(new Integer(2), (Integer) testLink.size());
	}

	@Test
	public void getTest() {
		StudentLinkedListDeque<Integer> testLink = new StudentLinkedListDeque<Integer>();
		testLink.addFirst(0);
		testLink.addLast(1);
		testLink.addLast(2);
		testLink.addLast(3);
		assertEquals(null, testLink.get(4));
		assertEquals(new Integer(0), (Integer) testLink.get(0));
		testLink.addFirst(8);
		testLink.addLast(4);
		// 8 0 1 2 3 4
		assertEquals(new Integer(8), (Integer) testLink.get(0));
		assertEquals(new Integer(0), (Integer) testLink.get(1));
		assertEquals(new Integer(2), (Integer) testLink.get(3));
		testLink.removeFirst();
		testLink.removeFirst();
		testLink.removeFirst();
		testLink.removeLast();
		// 2 3
		assertEquals(new Integer(2), (Integer) testLink.get(0));
		assertEquals(null, testLink.get(5));
		assertEquals(new Integer(3), (Integer) testLink.get(1));
	}

	@Test
	public void getRecursiveTest() {
		StudentLinkedListDeque<Integer> testLink = new StudentLinkedListDeque<Integer>();
		testLink.addFirst(0);
		testLink.addLast(1);
		testLink.addLast(2);
		testLink.addLast(3);
		assertEquals(null, testLink.getRecursive(4));
		assertEquals(new Integer(0), (Integer) testLink.getRecursive(0));
		testLink.addFirst(8);
		testLink.addLast(4);
		// 8 0 1 2 3 4
		assertEquals(new Integer(8), (Integer) testLink.getRecursive(0));
		assertEquals(new Integer(0), (Integer) testLink.getRecursive(1));
		assertEquals(new Integer(2), (Integer) testLink.getRecursive(3));
		testLink.removeFirst();
		testLink.removeFirst();
		testLink.removeFirst();
		testLink.removeLast();
		// 2 3
		assertEquals(new Integer(2), (Integer) testLink.getRecursive(0));
		assertEquals(null, testLink.getRecursive(5));
		assertEquals(new Integer(3), (Integer) testLink.getRecursive(1));
	}
	
	public static void main(String... args) {        
        jh61b.junit.TestRunner.runTests("failed", TestLinkedListDeque1B.class);
    }
}