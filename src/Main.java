import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int sizeOfArray;
    private static int numOfThreads;

    public static void main(String[] arg) {
        //Initialize sizes of arrays and threads.
        initialize();
        int[] arrayToSort = new int[sizeOfArray];
        for (int i = 0; i < arrayToSort.length; i++){
            //Initialize values to all elements in the array.
            arrayToSort[i] = (int)(Math.random()*100)+1;
        }

        //Divide non-sorted array to one value arrays and push them to the queue.
        int[] tmp = new int[1];
        ArrayQueue poolArray = new ArrayQueue();
        for (int i = 0; i<arrayToSort.length; i++){
            tmp[0] = arrayToSort[i];
            poolArray.enqueue(tmp);
        }

        //Initialize threads for sort array.
        Merge[] threadList = new Merge[numOfThreads];
        for (int i = 0; i < numOfThreads; i++){
            threadList[i] = new Merge(poolArray);
        }
        //Run threads concurrency
        for (int i = 0; i < numOfThreads; i++){
            threadList[i].start();
        }
        //Wait to end of all threads.
        try {
            for (int i = 0; i < numOfThreads; i++){
                threadList[i].join();
            }
        }
        catch (InterruptedException e){
            System.out.println("main interrupted");
        }

        System.out.println(poolArray);
    }

    //Initialize number of numbers in array and number of threads to sort them from the user.
    private static void initialize(){
        System.out.println("Please enter number for size of array to sort it.");
        sizeOfArray = getNum();
        System.out.println("Please enter number for number of threads to make a sort.");
        numOfThreads = getNum();
    }

    //Function to get number (for numbers/threads) from user.
    private static int getNum(){
        Scanner s = new Scanner(System.in);
        while (!s.hasNextInt()) {
            System.out.println("This is not a correct value, please enter number only.");
            s = new Scanner(System.in);
        }
        return s.nextInt();
    }

}
