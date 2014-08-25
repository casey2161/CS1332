import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * These are the test cases we will use to grade your regex assignment.
 * 
 * Each test is worth 2 points for a total of 100 points.
 *
 * There are no retakes for this assignment even though it is counted as a quiz grade.
 *  
 * We will be checking that you used actual regex and didn't just hard code the test cases.
 * 
 * @author jack
 */
public class TestRegexPatterns{

	/*
	 * TEST PHONE NUMBER
	 */
	
	@Test
	public void testPNumber0() {
		assertFalse("Failed phone number case 1",RegexAssignment.testPhoneNumber("6784444444"));
	}

	@Test
	public void testPNumber1() {
		assertFalse("Failed phone number case 2",RegexAssignment.testPhoneNumber("404-444-4444"));
	}

	@Test
	public void testPNumber2() {
		assertTrue("Failed phone number case 3",RegexAssignment.testPhoneNumber("(404)444-4444"));
	}

	@Test
	public void testPNumber3() {
		assertTrue("Failed phone number case 4",RegexAssignment.testPhoneNumber("(678)444-4444"));
	}

	@Test
	public void testPNumber4() {
		assertTrue("Failed phone number case 5",RegexAssignment.testPhoneNumber("(770)444-4444"));
	}

	@Test
	public void testPNumber5() {
		assertFalse("Failed phone number case 6",RegexAssignment.testPhoneNumber("(202)444-4444"));
	}

	@Test
	public void testPNumber6() {
		assertFalse("Failed phone number case 7",RegexAssignment.testPhoneNumber("(404) 444-4444"));
	}

	/*
	 * TEST EMAIL
	 */

	@Test
	public void testEmail0() {
		assertTrue("Failed email case 1",RegexAssignment.testEmail("email@email.com"));
	}

	@Test
	public void testEmail1() {
		assertTrue("Failed email case 2",RegexAssignment.testEmail("email.email@email.com"));
	}

	@Test
	public void testEmail2() {
		assertTrue("Failed email case 3",RegexAssignment.testEmail("email-email_email@email.net"));
	}

	@Test
	public void testEmail3() {
		assertFalse("Failed email case 4",RegexAssignment.testEmail("email@email@email.com"));
	}

	@Test
	public void testEmail4() {
		assertFalse("Failed email case 5",RegexAssignment.testEmail("email&email@email.com"));
	}

	@Test
	public void testEmail5() {
		assertTrue("Failed email case 6",RegexAssignment.testEmail("e______________________mail@email.com"));
	}

	@Test
	public void testEmail6() {
		assertTrue("Failed email case 7",RegexAssignment.testEmail("email@email.org"));
	}

	@Test
	public void testEmail7() {
		assertTrue("Failed email case 8",RegexAssignment.testEmail("email@email.net"));
	}

	@Test
	public void testEmail8() {
		assertTrue("Failed email case 9",RegexAssignment.testEmail("email@ema____il.net"));
	}

	@Test
	public void testEmail9() {
		assertTrue("Failed email case 10",RegexAssignment.testEmail("ema1234il@email.net"));
	}

	@Test
	public void testEmail10() {
		assertTrue("Failed email case 11",RegexAssignment.testEmail("email@ema1234il.net"));
	}

	@Test
	public void testEmail11() {
		assertFalse("Failed email case 12",RegexAssignment.testEmail("email@email.it"));
	}

	@Test
	public void testEmail12() {
		assertFalse("Failed email case 13",RegexAssignment.testEmail("4email@email.com"));
	}

	@Test
	public void testEmail13() {
		assertFalse("Failed email case 14",RegexAssignment.testEmail("email@4email.com"));
	}

    /*
	 * TEST NAME
	 */

    @Test
    public void testName0() {
        assertTrue("Failed name case 1",RegexAssignment.testName("Peter Griffin"));
    }

    @Test
    public void testName1() {
        assertTrue("Failed name case 2",RegexAssignment.testName("Anna-Kate Smith"));
    }

    @Test
    public void testName2() {
        assertTrue("Failed name case 3",RegexAssignment.testName("Mark ONeill"));
    }

    @Test
    public void testName3() {
        assertTrue("Failed name case 4",RegexAssignment.testName("Mark O'Neill"));
    }

    @Test
    public void testName4() {
        assertTrue("Failed name case 5",RegexAssignment.testName("Anna-Kate O'Neill"));
    }

    @Test
    public void testName5() {
        assertFalse("Failed name case 5",RegexAssignment.testName("homer Simpson"));
    }

    @Test
    public void testName6() {
        assertFalse("Failed name case 7",RegexAssignment.testName("Homer simpson"));
    }

	/*
	 * TEST ADDRESS
	 */

	@Test
	public void testAddress0() {
		assertTrue("Failed address case 1",RegexAssignment
				.testAddress("1 Atlantic Ave.\nAtlanta, GA 30313"));
	}

	@Test
	public void testAddress1() {
		assertTrue("Failed address case 2",RegexAssignment
				.testAddress("12 Atlantic Ave.\nAtlanta, GA 30313"));
	}

	@Test
	public void testAddress2() {
		assertTrue("Failed address case 3",RegexAssignment
				.testAddress("123 Atlantic Ave.\nAtlanta, GA 30313"));
	}

	@Test
	public void testAddress3() {
		assertTrue("Failed address case 4",RegexAssignment
				.testAddress("1234 Atlantic Ave.\nAtlanta, GA 30313"));
	}

	@Test
	public void testAddress4() {
		assertTrue("Failed address case 5",RegexAssignment
				.testAddress("12345 Atlantic Ave.\nAtlanta, GA 30313"));
	}

	@Test
	public void testAddress5() {
		assertFalse("Failed address case 6",RegexAssignment
				.testAddress("123456 Atlantic Ave.\nAtlanta, GA 30313"));//6 leading digits
	}

	@Test
	public void testAddress6() {
		assertTrue("Failed address case 7",RegexAssignment
				.testAddress("123 A\nAtlanta, GA 30313-3333"));
	}

	@Test
	public void testAddress7() {
		assertTrue("Failed address case 8",RegexAssignment
				.testAddress("123 lowercase\nAtlanta, GA 30313"));
	}

	@Test
	public void testAddress8() {
		assertFalse("Failed address case 9",RegexAssignment.testAddress("123\nAtlanta, GA 30313"));//no street
	}

	@Test
	public void testAddress9() {
		assertFalse("Failed address case 10",RegexAssignment
				.testAddress("123 Atlantic Ave.\natlanta, GA 30313-2444"));
	}

	@Test
	public void testAddress10() {
		assertTrue("Failed address case 11",RegexAssignment
				.testAddress("123 Atlantic Ave.\nAtlanta GA 30313"));
	}

	@Test
	public void testAddress11() {
		assertFalse("Failed address case 12",RegexAssignment
				.testAddress("123 Atlantic Ave.\nAtlanta, Ga 30313"));//state should be caps
	}

	@Test
	public void testAddress12() {
		assertFalse("Failed address case 13",RegexAssignment
				.testAddress("123 Atlantic Ave.\nAtlanta, ga 30313"));//state should be caps
	}

	@Test
	public void testAddress13() {
		assertFalse("Failed address case 14",RegexAssignment
				.testAddress("123 Atlantic Ave.\nAtlanta, GA 30"));//invalid zip code
	}

	@Test
	public void testAddress14() {
		assertTrue("Failed address case 15",RegexAssignment
				.testAddress("123 Atlantic Ave.\nAtlanta, GA 30313-5124"));
	}

	@Test
	public void testAddress15() {
		assertTrue("Failed address case 16",RegexAssignment
				.testAddress("100 The Moon\nCity, NA 00000-0000"));
	}

	@Test
	public void testAddress16() {
		assertTrue("Failed address case 17",RegexAssignment
				.testAddress("100 First-Street Cir.\nSt. Lewis, NA 00000-0000"));
	}

	@Test
	public void testAddress17() {
		assertTrue("Failed address case 18",RegexAssignment
				.testAddress("100 First-Street Cir.\nNorth-Ridge, NA 00000-9999"));
	}

	/*
	 * TEST JAVA EXECUTABLE
	 */

	@Test
	public void testJavaExec0() {
		assertTrue("Failed Java method case 1",RegexAssignment
				.testJavaExecutable("public static void main(String[] aBcDeFgHiJkLmNoPqRsTuVwXyZ123456789_$)"));
	}

	@Test
	public void testJavaExec1() {
		assertTrue("Failed Java method case 2",RegexAssignment
				.testJavaExecutable("\n //  ///*\"public static void main(String[] _variablename)\"*/ \n "));
	}

	@Test
	public void testJavaExec2() {
		assertFalse("Failed Java method case 3",RegexAssignment
				.testJavaExecutable("\n  public void main(String[] $$$$$$$$$$)  \n"));
	}

    @Test
    public void testJavaExec3() {
        assertTrue("Failed Java method case 1",RegexAssignment
                .testJavaExecutable("public static void main(String[] $$$$$$$$$$)"));
    }
}