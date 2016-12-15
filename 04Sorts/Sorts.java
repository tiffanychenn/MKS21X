public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "06.Chen.Tiffany"; 
    }

    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){  
	for (int i = 0; i < data.length - 1; i ++){
	    int index = i;
	    for (int j = i; j < data.length; j ++){
		if (data[j] < data[i]){
		    index = j;
		}
	    }
	    int temp = data[index];
	    data[index] = data[i];
	    data[i] = temp;
	}
    }

    public static void insertionSort(int[] data){
	for (int i = 1; i < data.length; i ++){
	    int temp = data[i];
	    int counter = i;
	    while (counter > 0 && temp < data[counter - 1]){
		data[counter] = data[counter - 1];
		counter --;
	    }
	    data[counter] = temp;
	}
    }

    public static void bubbleSort(int[] data){
	boolean benchmark = true;
	for (int counter = data.length; counter > 0; counter --){
	    for (int i = 0; i < counter - 1; i ++){
	        if (data[i] > data[i + 1]){
		    int temp = data[i];
		    data[i] = data[i + 1];
		    data[i + 1] = temp;
		    benchmark = false;
		}
	    }
	    if (benchmark){
		return;
	    }
	    else{
		benchmark = true;
	    }
	}
    }

    public static void main(String[] args){
	System.out.println(name());
	int[] ary = {182, 10, 38, 1, 5, 2, 479, 290, 100, 64, 28, 28, 2780};
	long start = System.currentTimeMillis();
	bubbleSort(ary);
	long end = System.currentTimeMillis();
	for (int i = 0; i < ary.length; i ++){
	    System.out.println(ary[i]);
	}
	//	System.out.println("\nTIME:\n" + end + "\n" + start);
    }
}

