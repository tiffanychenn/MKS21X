public class Barcode implements Comparable<Barcode>{
    
    // instance variables
    private String _zip;
    private int _checkDigit;

    // constructors
    //precondition: zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    
    public Barcode(String zip){
        _zip = "";
        if (zip.length() != 5){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 5; i ++){
            if (!((int)(zip.charAt(i)) >= 48 && (int)(zip.charAt(i)) <= 57)){
                throw new IllegalArgumentException();
            }
            else{
                _zip += key((int)(zip.charAt(i)) - 48);
            }
        }
        _checkDigit = checkSum() % 10;
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

    private int otherThingForInt(){
        int temp = 0;
        for (int i = 0; i < _zip.length(); i += 5){
            temp += findIndex(_zip.substring(i, i + 5));
        }
        return temp;
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
        return new Barcode(otherThing());
    }

    private String otherThing(){
        String temp = "";
        for (int i = 0; i < _zip.length(); i += 5){
            temp += String.valueOf(findIndex(_zip.substring(i, i + 5)));
        }
        return temp;
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
        temp += otherThing();
        temp += _checkDigit;
        return temp + " " + _zip;
    }


    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
        return Integer.compare(otherThingForInt() + _checkDigit, other.otherThingForInt() + other.checkSum() % 10);
    }
    
}
