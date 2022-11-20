import java.util.ArrayList;
import java.util.Arrays;

public class ArrayQueue {
    ArrayList<int[]> poolArrays;
    int size = 0;

    public ArrayQueue(){
        poolArrays = new ArrayList<int[]>();
    }


    //update queue in synchronize way.
    public synchronized void enqueue(int[] array){
        poolArrays.add(array.clone());
        size++;
    }

    //Pop two arrays from queue to merge them, and return the by Two-dimensional array.
    public synchronized int[][] doubleDequeue() throws Exception {
        if (getSize()<2) throw new Exception();
        int[][] toMerge = new int[2][];
        for (int i = 0; i<2; i++){
            toMerge[i] = poolArrays.get(0);
            poolArrays.remove(0);
            size--;
        }
        return toMerge;
    }

    public synchronized int getSize(){
        return size;
    }

    @Override
    //Print final queue( one sorted array) as list.
    public String toString() {
        String toPrint = Arrays.toString(poolArrays.get(0));

        return toPrint;
    }
}
