public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;

    // constructors
    //precondition: zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public BarCode(String zip){
	_zip = "";
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	for (int i = 0; i < zip.length(); i ++){
	    if (zip.charAt(i) >= 48 && zip.charAt(i) <= 57){
		throw new IllegalArgumentException();
	    }
	    else{
		_zip += key((int)(zip.charAt(i)) - 48);
	    }
	}
	_checkDigit = checkSum();
    }

    // bunch of private methods
    private String key(int index){
	String[] codes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	return codes[index];
    }

    private int findIndex(String bleh){
	String[] codes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	for (int i = 0; i < codes.length; i ++){
	    if (bleh.equals(codes[i])){
		return i;
	    }
	}
	return -1;
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	String temp = "";
	for (int i = 0; i < _zip.length(); i += 5){
	    temp += valueOf(findIndex(_zip.substring(i, i + 5)));
	}
	return new Barcode(temp);
    }

    private String otherThing(){
	String temp = "";
	for (int i = 0; i < _zip.length(); i += 5){
	    temp += valueOf(findIndex(_zip.substring(i, i + 5)));
	}
	return new Barcode(temp);
    }


    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
        int temp = 0;
	for (int i = 0; i < _zip.length(); i += 5){
	    temp += findIndex(_zip.substring(i, i + 5));
	}
	return temp;
    }

    //postcondition: format zip + check digit + barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String temp = "";
	
	temp += checkSum();
	return temp + _zip;
    }


    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){

    }
    
}
