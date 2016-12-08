public class Driver{

	public static void main(String[] args){
		Barcode b = new Barcode("83157");
		Barcode c = new Barcode("19201");
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(b.compareTo(c));
		System.out.println(c.compareTo(b)); // should be negative of the last line
		System.out.println(d.compareTo(b));
		Barcode cloned = b.clone();
		System.out.println(b.compareTo(cloned));
		// Barcode too_long = new Barcode("18298930"); // should throw a runtime exception
		// Barcode wrong_chars = new Barcode("819a8"); // should throw a runtime exception
	}

}
