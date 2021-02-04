package util;

public class UtilMethod {
    public void quickSort(int[] array, int low, int high){
        if (low < high){
            int pivot = partition(array, low, high);
            quickSort(array,low,pivot-1);
            quickSort(array,pivot+1,high);
        }
    }
    private int partition(int[] array, int low, int high){
        int pivot = array[low];
        while(low<high){
            while(low<high&&array[high]>=pivot) --high;
            array[low] = array[high];
            while(low<high&&array[low]<=pivot) ++low;
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }
}
