import java.util.Iterator;

public class SuperArray implements Iterable<String>{

    private int size;
    private String[] data;

    // constructors
    public SuperArray(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = new String[initialCapacity];
	size = 0;
    }

    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }

    public SuperArray(){
	this(10);
    }

    // 1. add (with one parameter)
    public boolean add(String element){
	if (size + 1 == data.length){
	    grow();
	}
	data[size] = element;
	size += 1;
	return true;
    }

    private void grow(){
	String[] temp = new String[data.length * 2];
	for (int i = 0; i < data.length; i ++){
	    temp[i] = data[i];
	}
	data = temp;
    }

    // 2. get
    public String get(int index){
	if ((index >= size && (size != 0)) || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    // 3. size
    public int size(){
	return size;
    }

    // 4. toString
    public String toString(){
	String end = "[";
	for (int i = 0; i < size; i ++){
	    if (i == size - 1){
		end += data[i];
	    }
	    else{
		end += data[i] + ", ";
	    }
	}
	return end + "]";
    }

    // 5. toStringDebug
    public String toStringDebug(){
	String end = "[";
	for (int i = 0; i < size; i ++){
	    end += data[i] + ", ";
	}
	for (int i = size; i < data.length; i ++){
	    if (i == data.length - 1){
		end += "_";
	    }
	    else{
		end += "_, ";
	    }
	}
	return end + "]";
    }

    // 6. clear
    public void clear(){
	data = new String[10];
	size = 0;
    }

    // 7. isEmpty
    public boolean isEmpty(){
	return size == 0;
    }

    // 8. set
    public String set(int index, String element){
	if (index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	String x = data[index];
	data[index] = element;
	return x;
    }

    // 9. add (with two parameters)
    public void add(int index, String element){
	if (index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	if (size + 1 == data.length){
	    grow();
	}
	String[] temp = new String[data.length + 1];
	for (int i = 0; i < temp.length; i ++){
	    if (i == index){
		temp[i] = element;
	    }
	    else if (i < index){
		temp[i] = data[i];
	    }
	    else{
		temp[i] = data[i - 1];
	    }
	}
	data = temp;
	size += 1;
    }

    // 10. remove
    public String remove(int index){
	if (index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	String[] temp = new String[data.length - 1];
	String x = "";
	for (int i = 0; i < temp.length; i ++){
	    if (i < index){
		temp[i] = data[i];
	    }
	    else{
		if (i == index){
		    x = data[i];
		}
		temp[i] = data[i - 1];
	    }
	}
	data = temp;
	size --;
	return x;
    }

    // 11. toArray  
    public void trimToSize(){
        data = toArray();
    }

    public String[] toArray(){
	String[] temp = new String[size];
	for (int i = 0; i < size; i ++){
	    temp[i] = data[i];
	}
	return temp;
    }

    // 12. indexOf
    public int indexOf(String i){
	for (int n = 0; n < data.length; n ++){
	    if (data[n] == i){
		return n;
	    }
	}
	return -1;
    }

    // 13. lastIndexOf
    public int lastIndexOf(String i){
	int x = -1;
	for (int n = 0; n < data.length; n ++){
	    if (data[n] == i){
		x = n;
	    }
	}
	return x;
    }
}
