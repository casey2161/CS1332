/**
 * 
 * Regex Assignment
 * 
 * @author jack
 *
 */
public class RegexAssignment{
	
	/**
     * Match a phone number.
     *
     * Provide a Regex pattern that matches Atlanta phone numbers. The format
     * should be "(###)###-####" and the only valid area codes are 404, 678 and
     * 770.
     *
     * @param phoneNumber the phone number
     * @return true if it is a match, otherwise false
     */
    public static boolean testPhoneNumber(String phoneNumber){
       return phoneNumber.matches("\\((404|678|770)\\)[0-9]{3}-[0-9]{4}");
    }

    /**
     * Match an email address.
     *
     * Provide a Regex pattern that validates an email address. The email address should be
     * broken up into the following sections:
     *
     * 1) any combination of letters, digits, underscores, dashes, and periods,
     *    starting with a letter
     * 2) the @ symbol
     * 3) any combination of letters, digits, underscores, dashes, and periods,
     *    starting with a letter
     * 4) a single period
     * 5) one of the following strings : com, org, net
     *
     * @param email the email address
     * @return true if it is a match, otherwise false
     */
    public static boolean testEmail(String email){
        return email.matches("[A-Za-z]([A-Za-z0-9]|_|-|\\.)*\\@[A-Za-z]([A-Za-z0-9]|_|-|\\.)*\\.(com|org|net)");
    }

    /**
     * Match a name.
     *
     * Provide a regex pattern that validates a person's first and last name.
     * Each name should be capitalized and should not contain any punctuation
     * characters except "-" (hyphen), "'" (apostrophe), or " " (space). You should limit the
     * pattern to only two names.
     *
     * Notes:
     *  - A name can contain a hyphen or an apostrophe, but not both.
     * 	- Hyphenated names (up to two names) count as one name.
     * 	- If a name contains an apostrophe, the apostrophe must be immediately followed by a
     * 	  capital letter.
     *
     * @param name the name
     * @return true if it is a match, otherwise false
     */
    public static boolean testName(String name){
        return name.matches("[A-Z][A-Za-z]*((\\-|')[A-Z])?[A-Za-z]*\\s[A-Z][A-Za-z]*((\\-|')[A-Z])?[A-Za-z]*");
    }

    /**
     * Match an address.
     *
     * Provide a regex pattern to validate a mailing address. The address should be of the form:
     * 1) a number, 1-5 digits in length
     * 2) whitespace
     * 3) the street -  some combination of letters, numbers, spaces, periods, and hyphens
     * 4) a newline
     * 5) the city - some combination of letters, spaces, periods, and hyphens, starting
     *    with a capital letter
     * 6) optional - comma
     * 7) whitespace
     * 8) the state - 2 capital characters
     * 9) whitespace
     * 10) the zip code - 5 digits
     * 11) optional - hyphen followed by 4 more digits
     *
     * NOTE: The state characters can be any 2 capital letters, they do not need to
     * actually match a real state.
     *
     * @param address the address
     * @return true if it is a match, otherwise false
     */
    public static boolean testAddress(String address){
        return address.matches("[0-9]{1,5}\\s+([A-Za-z0-9)|\\s|\\.|-])*\n[A-Z]([A-Za-z0-9)|\\s|\\.|-])+,?\\s*[A-Z]{2}\\s+[0-9]{5}(-[0-9]{4})?");
    }

    /**
     * Match a java executable.
     *
     * Provide a regex pattern that will check a string of text (presumably
     * from a .java file, but that is not important here) to see if it contains
     * "public static void main(String[] args)", where "args" can be replaced with any valid
     * Java variable name.
     *
     * A Java variable name is any combination of letters, digits, dollar signs ("$"), and
     * underscores ("_") that does not begin with a digit.
     *
     * NOTE: The regex pattern does not need to check if the variable name is a Java keyword.
     *
     * @param java the Java string
     * @return true if it is a match, otherwise false
     */
    public static boolean testJavaExecutable(String java){
        return java.matches("(.|\n)*public(\\s|\n)+static(\\s|\n)+void(\\s|\n)+main(\\s|\n)*\\((\\s|\n)*String(\\s|\n)*\\[(\\s|\n)*\\](\\s|\n)+([A-Za-z]|\\$|_)([A-Za-z0-9]|\\$|_)*(\\s|\n)*\\)(.|\n)*");
    }
}