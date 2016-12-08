public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{

    private String callNumber;

    public LibraryBook(String a, String t, String i, String n){
        super(a, t, i);
        callNumber = n;
    }

    public void setCallNumber(String neww){
        callNumber = neww;
    }

    public void helloWorld(){
        System.out.println("hello world");
    }

    public String getCallNumber(){
        return callNumber;
    }

    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();

    public int compareTo(LibraryBook b){
        return callNumber.compareTo(b.getCallNumber());
    }

    public String toString(){
        return super.toString() + "\nCall Number: " + callNumber;
    }

}