public class Driver{

	public static void main(String[] args){
		Barcode b = new Barcode("83157");
		Barcode c = new Barcode("19201");
		System.out.println(Barcode.toCode("83157"));
		System.out.println(Barcode.toZip("||::|:::||::::||:|:|:|:::|:|::||"));
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(b.compareTo(c));
		System.out.println(c.compareTo(b)); // should be negative of the last line
		Barcode cloned = b.clone();
		System.out.println(b.compareTo(cloned));
		// Barcode too_long = new Barcode("18298930"); // should throw a runtime exception
		// Barcode wrong_chars = new Barcode("819a8"); // should throw a runtime exception
		String[] tryingThings = {"639184", "sjdb9", "||::|:::||::::||:|:|:|:::|||:::|", "||||||||||||||||||||||||||||||||", "|:|", "||::|:::||::::||:|:|:|:::|:|::|:", "||::|:::||::::||:|:|:|::a|:|::||"};
		for (int i = 0; i < tryingThings.length; i ++){
		    if (i < 2){
			try{
			    Barcode.toCode(tryingThings[i]);
			}
			catch (IllegalArgumentException e){
			    System.out.println("got ya!");
			}
		    }
		    else{
			try{
			    Barcode.toZip(tryingThings[i]);
			}
			catch (IllegalArgumentException e){
			    System.out.println("bleh");
			}
		    }
		}
	}

}
