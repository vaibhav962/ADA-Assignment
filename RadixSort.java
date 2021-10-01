public class RadixSort {
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void countingSort(int array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
          if (array[i] > max)
            max = array[i];
        }
        int[] count = new int[max + 1];
    
        for (int i = 0; i < max; ++i)
          count[i] = 0;
    
        for (int i = 0; i < size; i++)
          count[(array[i] / place) % 10]++;
    
        for (int i = 1; i < 10; i++)
          count[i] += count[i - 1];
    
        for (int i = size - 1; i >= 0; i--) {
          output[count[(array[i] / place) % 10] - 1] = array[i];
          count[(array[i] / place) % 10]--;
        }
    
        for (int i = 0; i < size; i++)
          array[i] = output[i];
      }

    int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
            max = array[i];
        return max;
      }
    void radixSort(int arr[]) {
        int size = arr.length;
        int max = getMax(arr, size);
        for (int place = 1; max / place > 0; place *= 10)
        countingSort(arr, size, place);
    }

    public static void main(String[] args) {
        RadixSort rs = new RadixSort();
        int[] array = {121, 432, 564, 23, 1, 45, 788};
        System.out.println("Elements before sorting:");
        rs.printArray(array);
        
        rs.radixSort(array);
        System.out.println("Elements after sorting:");
        rs.printArray(array);
        
    }
}
