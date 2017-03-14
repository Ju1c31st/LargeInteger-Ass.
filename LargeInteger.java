public class LargeInteger {
	private String number; //stores the absolute value
	private boolean negative; //stores if the number is negative or not

	/**
	 * DO NOT MODIFY
	 * @param s: assumed to be a valid integer stored in a string
	 * @return the number without leading zeroes (zeroes at the front)
	 */
	public static String getWithoutLeadingZeroes(String s) {
		return ""; //to be completed
	}

	/**
	 * DO NOT MODIFY
	 * @param ch
	 * @return true if ch is a digit ('0' to '9') false otherwise
	 */
	private static boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}

	/**
	 * DO NOT MODIFY
	 * @param ch
	 * @return true if ch is a sign ('-' or '+') false otherwise
	 */
	private static boolean isSign(char ch) {
		return ch == '-' || ch == '+';
	}


	/**
	 * 
	 * @param n
	 * @return true if n is a valid integer.
	 * Rules: besides the first character, 
	 * which can *also* be '-' or '+', 
	 * all other characters must be a digit
	 * string must have at least one digit
	 * 
	 * some examples of valid integers:
	 * "-347"
	 * "+43"
	 * "7987"
	 * "00000423"
	 * "-053"
	 * My notes: 
	 * nonInt is counting the non-ints like "+2" "-2"  are valid.
	 * whereas "+++---2" is not valid
	 */
	public static boolean isInteger(String n) {
		public static boolean isInteger(String n) {	
		int nonInt = 0;
		  if (n != null && !n.isEmpty()) {
		        for (char c : n.toCharArray()) {
		            if (Character.isDigit(c) && nonInt < 2 ) {
		                return true;
		            } else{
		            	 nonInt++;
		            }
		        }
		    }
		    return false; //passes test
		}
	}

	/**
	 * parameter may have leading zeroes.
	 * these must be removed first.
	 * @param n
	 * @return true if the parameter is a valid integer
	 * in this case, copy absolute value into instance variable number
	 * and set negative flag accordingly.
	 * For example 
	 * if n = "-425", number should become 425
	 * and negative should become true
	 * if n = "546", number should become 546
	 * and negative should become false
	 * 
	 * return false if the parameter is not a valid integer,
	 * in this case, set number to "0", negative to false
	 */
	public boolean setNumber(String n) {
		public boolean setNumber(String n) {
		boolean nFlag = false; //assumes number is positive
		if( n != null && !n.isEmpty()){
	 	}
		
		number = "0"; 
		return flag; //to be completed
	}

	/**
	 * DO NOT MODIFY
	 * @return the number stored
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * DO NOT MODIFY
	 * set the number to the parameter 
	 * (parameter doesn't need to be a valid
	 * integer in a string. setter should take
	 * care of that) 
	 * @param n
	 */
	public LargeInteger(String n) {
		setNumber(n);
	}
	
	/**
	 * DO NOT MODIFY
	 * @return
	 */
	private int nDigits() {
		return number.length();
	}

	/**
	 * DO NOT MODIFY
	 * @return string representation
	 */
	public String toString() {
		if(negative)
			return '-'+number;
		else
			return number;
	}

	/**
	 * DO NOT MODIFY
	 * @return true if the number represented is negative
	 * so if instance variable negative is true, it should return true
	 * and if instance variable negative is false, it should return false
	 */
	public boolean isNegative() {
		return negative;
	}

	/**
	 * return false if o is not an instance of LargeInteger
	 * 
	 * if o *is* an instance of LargeInteger, return
	 * true if the calling object and the parameter object
	 * represent the same integer, false otherwise
	 */
	public boolean equals(Object o) {
		return false; //to be completed
	}

	/**
	 *
	 * @param other
	 * @return
	 * 1 if calling object represents a 
	 * larger integer than that represented by the 
	 * parameter object
	 *  (a is larger than b if a - b > 0)
	 * -1 if calling object represents a 
	 * smaller integer than that represented by the 
	 * parameter object
	 *  (a is smaller than b if a - b < 0)
	 * 0 if calling object and parameter object
	 * both represent the same integer
	 */
	public int compareTo(LargeInteger other) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @return a LargeInteger object representing the
	 * negative of the integer represented by calling object
	 */
	public LargeInteger negate() {
		return new LargeInteger("0"); //to be completed
	}

	/**
	 * 
	 * @return a LargeInteger object representing the
	 * absolute value of the integer represented by
	 * the calling object
	 */
	public LargeInteger absolute() {
		return new LargeInteger("0"); //to be completed
	}

	/**
	 * 
	 * @param other
	 * @return comparison of the absolute values
	 * of the calling object and the parameter objects
	 */
	public int compareAbsolutes(LargeInteger other) {
		return 0; //to be completed
	}

	/**
	 * DO NOT MODIFY
	 * @param ch1: assumed to be a digit ('0' to '9')
	 * @param ch2: assumed to be a digit ('0' to '9')
	 * @param carryDigit: assumed to be a digit ('0' to '9')
	 * @return the last digit when ch1, ch2 and carryDigit are added
	 */
	private static char add(char ch1, char ch2, char carryDigit) {
		int result = (int)ch1 - '0' + (int)ch2 - '0' + (int)carryDigit - '0';
		if(result >= 10) {
			return (char)(result%10 + '0');
		}
		else {
			return (char)(result+'0');
		}
	}

	/**
	 * DO NOT MODIFY
	 * @param ch1: assumed to be a digit ('0' to '9')
	 * @param ch2: assumed to be a digit ('0' to '9')
	 * @param carryDigit: assumed to be a digit ('0' to '9')
	 * @return carry over digit (first digit) when ch1, ch2 and carryDigit are added
	 */
	private static char carry(char ch1, char ch2, char carryDigit) {
		int result = (char)(((int)ch1 - '0') + ((int)ch2 - '0') + ((int)carryDigit - '0'));
		if(result >= 10) {
			return (char)(result / 10 + '0');
		}
		else {
			return '0';
		}
	}

	/**
	 * 
	 * @param other
	 * @return result of adding calling object 
	 * and parameter object
	 */
	public LargeInteger add(LargeInteger other) {
		return new LargeInteger("0"); //to be completed
	}

	/**
	 * 
	 * @param other
	 * @return result of subtracting parameter object 
	 * from calling object
	 */
	public LargeInteger subtract(LargeInteger other) {
		return new LargeInteger("0"); //to be completed
	}
}
