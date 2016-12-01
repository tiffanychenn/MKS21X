public class ReferenceBook extends LibraryBook{

	private String collection;

	public ReferenceBook(String a, String t, String i, String n, String c){
		super(a, t, i, n);
		collection = c;
	}

	public void setCollection(String neww){
        collection = neww;
    }

    public String getCollection(){
    	return collection;
    }

    public void checkout(String patron, String due){
    	System.out.println(patron + " cannot check out a reference book");
    }

    public void returned(){
        System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
        return "non-circulating reference book";
    }

    public String toString(){
        return super.toString() + "\nCollection: " + collection;
    }

}
