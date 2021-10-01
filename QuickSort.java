public class QuickSort {
  void printArray(int arr[]) {
    int n = arr.length;
    for (int i=0; i<n; ++i)
        System.out.print(arr[i] + " ");
    System.out.println();
}
  static int partition(int array[], int left, int right) {
    
    int pivot = array[right];
    int i = (left - 1);

    for (int j = left; j < right; j++) {
      if (array[j] <= pivot) {
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    int temp = array[i + 1];
    array[i + 1] = array[right];
    array[right] = temp;
    return (i + 1);
  }

  public void quickSort(int array[], int left, int right) {
    if (left < right) {

      int prt = partition(array, left, right);
      
      quickSort(array, left, prt - 1);
      quickSort(array, prt + 1, right);
    }
}
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] array = {9, 8, 3, 7, 5, 6, 4, 1};
        System.out.println("Elements before sorting:");
        qs.printArray(array);
        
        qs.quickSort(array,0,array.length - 1);
        System.out.println("Elements after sorting:");
        qs.printArray(array);
    }
}
