import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * These are the test cases we will use to grade your dynamic programming assignment.
 * 
 * Each test is worth 5 points for a total of 100 points.
 * There are no re-takes for this assignment even though it is counted as a quiz grade.
 *  
 * We will be checking that you actually implemented the dynamic programming algorithms and
 * didn't just hard code the test cases.
 * 
 * @author Naomi Robert
 */
public class DynamicProgrammingTests {

	/*
	 * TEST FIBONACCI
	 */
	@Test
	public void testFib0() {
		assertEquals("Failed fibonacci test case 0", 0, DynamicProgramming.fib(0));
	}

	@Test
	public void testFib1() {
		assertEquals("Failed fibonacci test case 1", 1, DynamicProgramming.fib(1));
	}
	
	@Test
	public void testFib2() {
		assertEquals("Failed fibonacci test case 2", 8, DynamicProgramming.fib(6));
	}
	
	@Test
	public void testFib3() {
		assertEquals("Failed fibonacci test case 3", 144, DynamicProgramming.fib(12));
	}
	
	@Test
	public void testFib4() {
		assertEquals("Failed fibonacci test case 4", 6765, DynamicProgramming.fib(20));
	}
	
	@Test
	public void testFib5() {
		assertEquals("Failed fibonacci test case 5", 75025, DynamicProgramming.fib(25));
	}

	/*
	 * TEST LONGEST COMMON SUBSEQUENCE
	 */

	@Test
	public void testLCS0() {
		assertEquals("Failed lcs test case 0", 3, DynamicProgramming.lcs("abba", "abbc"));
	}
	
	@Test
	public void testLCS1() {
		assertEquals("Failed lcs test case 1", 4, DynamicProgramming.lcs("apple cider", "please"));
	}

	@Test
	public void testLCS2() {
		assertEquals("Failed lcs test case 2", 3, DynamicProgramming.lcs("sharpie", "grape"));
	}
	
	@Test
	public void testLCS3() {
		assertEquals("Failed lcs test case 3", 0, DynamicProgramming.lcs("six", "Seven"));
	}
	
	@Test
	public void testLCS4() {
		assertEquals("Failed lcs test case 4", 14, DynamicProgramming.lcs("The brown dog ate an apple yesterday.", "Once upon a time, the end."));
	}	
	
	@Test
	public void testLCS5() {
		assertEquals("Failed lcs test case 5", 6, DynamicProgramming.lcs("an apple a day", "keeps the doctor away"));
	}
	
	@Test
	public void testLCS6() {
		assertEquals("Failed lcs test case 6", 8, DynamicProgramming.lcs("winter is coming", "coming around the mountain"));
	}
	
    /*
	 * TEST EDIT DISTANCE
	 */
    @Test
    public void testEdit0() {
    	assertEquals("Failed edit distance test case 0", 1, DynamicProgramming.edit("hello", "jello"));
    }
    
    @Test
    public void testEdit1() {
    	assertEquals("Failed edit distance test case 1", 2, DynamicProgramming.edit("ababb", "bbab"));
    }
    
    @Test
    public void testEdit2() {
    	assertEquals("Failed edit distance test case 2", 13, DynamicProgramming.edit("sally sells seashells", "by the seashore"));
    }
    
    @Test
    public void testEdit3() {
    	assertEquals("Failed edit distance test case 3", 0, DynamicProgramming.edit("happy", "happy"));
    }
    
    @Test
    public void testEdit4() {
    	assertEquals("Failed edit distance test case 4", 13, DynamicProgramming.edit("John Watson", "Sherlock Holmes"));
    }
    
    @Test
    public void testEdit5() {
    	assertEquals("Failed edit distance test case 5", 2, DynamicProgramming.edit("which", "witch"));
    }
    
    @Test
    public void testEdit6() {
    	assertEquals("Failed edit distance test case 6", 19, DynamicProgramming.edit("winter is coming", "coming around the mountain"));
    } 
}