import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{

    private int element;
    private SuperArray iterated;

    public SuperArrayIterator(SuperArray a){
	element = 0;
	iterated = a;
    }
    
    public boolean hasNext(){
        return element < iterated.size();
    }

    public String next(){
	String temp = iterated.get(element);
	element ++;
	return temp;
    }

    public void remove(){}

}
