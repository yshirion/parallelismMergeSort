import java.util.ArrayList;

public class Queue{
    private ArrayList<int[]> poolArrays;
    int size;

    public Queue(){
        poolArrays = new ArrayList<int[]>();
    }

    public void enqueue(int[] array){
        poolArrays.add(size, array);
    }
}
