public class CirculatingBook extends LibraryBook{

	private String currentHolder, dueDate;

	public CirculatingBook(String a, String t, String i, String n){
		super(a, t, i, n);
		currentHolder = null;
		dueDate = null;
	}

	public void setDueDate(String neww){
        dueDate = neww;
    }

    public void setCurrentHolder(String neww){
        currentHolder = neww;
    }

    public String getDueDate(){
    	return dueDate;
    }

    public String getCurrentHolder(){
    	return currentHolder;
    }

    public void checkout(String patron, String due){
    	currentHolder = patron;
    	dueDate = due;
    }

    public void returned(){
    	currentHolder = null;
    	dueDate = null;
    }

    public String circulationStatus(){
    	if (dueDate.equals(null)){
    		return "book available on shelves";
    	}
    	else{
    		return "book is currently checked out by " + currentHolder + " and is due on " + dueDate;
    	}
    }

    public String toString(){
    	String temp = super.toString();
    	if (!(dueDate == null)){
    		temp = temp + "\nCurrent Holder: " + currentHolder + "\nDue Date: " + dueDate;
    	}
    	return temp;
    }

}
