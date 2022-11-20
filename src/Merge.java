public class Merge extends Thread{
    //sort by queue data structure.
     private ArrayQueue arrays;

     public Merge(ArrayQueue arrays){
         this.arrays = arrays;
     }

     public void run(){
         //Run merge sort until stays one array (sorted of course) there.
         while (arrays.getSize() > 1){
             try {
                 int[][] toMerge = arrays.doubleDequeue();
                 int[] array1 = toMerge[0];
                 int[] array2 = toMerge[1];
                 arrays.enqueue(merging(array1, array2));
             }
             catch (Exception e){
                 continue;
             }

         }
    }

    private int[] merging(int[] one, int[] two){

         int[] sorted = new int[(one.length + two.length)];//Size of merged array as size of two sorted arrays.
         int oneIndex = 0, twoIndex = 0;//index in each sorted arrays.
        //Merging
         for (int i = 0; i < sorted.length; i++){
             //If all numbers in 'one' enters to 'sorted' array.
             if (oneIndex >= one.length) {
                 for (int j = twoIndex; j< two.length; j++) {
                     sorted[i] = two[j];
                     i++;
                 }
                 break;
             }
             //If all numbers in 'two' enters to 'sorted' array.
             if (twoIndex >= two.length) {
                 for (int j = oneIndex; j< one.length; j++) {
                     sorted[i] = one[j];
                     i++;
                 }
                 break;
             }
             //Entrance in combination
             if (one[oneIndex] <= two[twoIndex]) {
                 sorted[i] = one[oneIndex];
                 oneIndex++;
             }
             else {
                 sorted[i] = two[twoIndex];
                 twoIndex++;
             }
         }
         return sorted;
    }
}
