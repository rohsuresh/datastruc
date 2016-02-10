import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

	@Test
	public void testIsEmpty() {
		StudentArrayDeque<Integer> testArray = new StudentArrayDeque<Integer>();
		assertEquals(true, testArray.isEmpty());
		testArray.addFirst(2);
		assertEquals(false, testArray.isEmpty());
		testArray.removeLast();
		assertEquals(true, testArray.isEmpty());
	}

	@Test
	public void testAdd() {
		StudentArrayDeque<Integer> testArray = new StudentArrayDeque<Integer>();
		testArray.addFirst(2);
		testArray.addLast(3);
		testArray.addFirst(6);
		testArray.addLast(8);
		testArray.addLast(10);
		testArray.addFirst(1);
		testArray.addFirst(0);
		testArray.addLast(12);
		testArray.addLast(15);
		testArray.addLast(20);
		// 0 1 6 2 3 8 10 12 15 20
		//Integer zeroeth = testArray.get(0);
		assertEquals(new Integer(0), (Integer) testArray.get(0));
		Integer fifth = testArray.get(5);
		assertEquals(new Integer(8), fifth);
		Integer eighth = testArray.get(8);
		assertEquals(new Integer(15), eighth);
		Integer ninth = testArray.get(9);
		assertEquals(new Integer(20), ninth);
	}

	@Test
	public void testSize() {
		StudentArrayDeque<Integer> testArray = new StudentArrayDeque<Integer>();
		testArray.addFirst(0);
		testArray.addLast(8);
		testArray.addFirst(1);
		assertEquals(new Integer(3), (Integer) testArray.size());
		testArray.removeFirst();
		testArray.removeFirst();
		Integer sizeCheck3 = testArray.size();
		assertEquals(new Integer(1), sizeCheck3);
	}

	@Test
	public void testSizeEdge() {
		StudentArrayDeque<Integer> testArray = new StudentArrayDeque<Integer>();
		testArray.removeLast();
		// size cannot be -1
		FailureSequence fs = new FailureSequence();
        DequeOperation dequeOp1 = new DequeOperation("removeLast");
        DequeOperation dequeOp2 = new DequeOperation("size");
       
        fs.addOperation(dequeOp1);
        fs.addOperation(dequeOp2);

        assertEquals(fs.toString(), new Integer(0), (Integer) testArray.size());

	}
	
	@Test
	public void testRemove() {
		StudentArrayDeque<Integer> testArray = new StudentArrayDeque<Integer>();
		testArray.addFirst(0);
		testArray.addLast(1);
		testArray.addLast(2);
		testArray.addLast(3);
		testArray.addLast(4);
		testArray.addLast(5);
		testArray.addLast(6);
		testArray.addLast(7);
		// 0 1 2 3 4 5 6 7
		assertEquals(new Integer(0), (Integer) testArray.removeFirst());
		// should be 0
	}
	
	@Test
	public void testUpsize() {
		StudentArrayDeque<Integer> testArray = new StudentArrayDeque<Integer>();
		testArray.addFirst(1);
		testArray.addFirst(0);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		testArray.addLast(2);
		assertEquals(new Integer(20), (Integer) testArray.size());
		assertEquals(new Integer(1), (Integer) testArray.get(1));
	}

	public static void main(String... args) {        
        jh61b.junit.TestRunner.runTests("failed", TestArrayDeque1B.class);
    }
}