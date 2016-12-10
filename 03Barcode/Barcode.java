public class Barcode implements Comparable<Barcode>{
    
    // instance variables
    private String _zip;
    private int _checkDigit;

    // here's to the code!!
    private static final String[] codes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};

    // constructors
    // precondition: zip.length() = 5 and zip contains only digits.
    // postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    
    public Barcode(String zip){
        _zip = toCode(zip);
        _checkDigit = findIndex(_zip.substring(26, 31));
    }

    // bunch of private methods
    private static int findIndex(String bleh){
        for (int i = 0; i < codes.length; i ++){
            if (bleh.equals(codes[i])){
		return i;
            }
        }
        return -1;
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
        return new Barcode(toZip(_zip));
    }

    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(String zip){
        int temp = 0;
        for (int i = 1; i < 26; i += 5){
	    temp += findIndex(zip.substring(i, i + 5));
	}
	return temp % 10;
    }

    //postcondition: format zip + check digit + barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
        return toZip(_zip) + _checkDigit + " " +  _zip;
    }


    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
        return Integer.compare(Integer.parseInt(toZip(_zip)) + _checkDigit, Integer.parseInt(toZip(other._zip)) + other._checkDigit);
    }

    public static String toCode(String zip){
	String temp = "|";
	if (zip.length() != 5){
            throw new IllegalArgumentException("The length of the inputted string is not equal to 5.");
        }
        for (int i = 0; i < 5; i ++){
            if (!((int)(zip.charAt(i)) >= 48 && (int)(zip.charAt(i)) <= 57)){
                throw new IllegalArgumentException("The string inputted has non-numerical characters.");
            }
            else{
                temp += codes[(int)(zip.charAt(i)) - 48];
            }
        }
	return temp + codes[checkSum(temp)]  + "|";
    }

    public static String toZip(String code){
	if (code.length() != 32){
	    throw new IllegalArgumentException("The barcode is not the corrent length.");
	}
	if (code.charAt(0) != '|' || code.charAt(31) != '|'){
	    throw new IllegalArgumentException("The barcode does not begin and end in |.");
	}
	for (int i = 1; i < code.length() - 1; i ++){
	    if (code.charAt(i) != '|' && code.charAt(i) != ':'){
		throw new IllegalArgumentException("The barcode has invalid characters (characters that are not | or :).");
	    }
	}
	for (int i = 1; i < code.length() - 6; i += 5){
	    if (findIndex(code.substring(i, i + 5)) == -1){
		throw new IllegalArgumentException("The barcode has invalid encoded integers.");
	    }
	}
	int check_sum = checkSum(code);
	if (findIndex(code.substring(26, 31)) != check_sum){
	    throw new IllegalArgumentException("The sixth digit does not match the sum of the first five digits modulo 10.");
	}
	int temp = 0;
	int counter = 0;
	for (int i = 1; i < code.length() - 3; i += 5){
	    temp += findIndex(code.substring(i, i + 5)) * Math.pow(10, 4 - counter);
	    counter ++;
	}
	return String.valueOf(temp);
    }
    
}
