// Time Complexity: O(n log n) this is the average case complexity. If all our pivot elements are positioned in the end that is, if array is in descending order time complexity is O(n)
// Space Complexity: O(1)

class QuickSort 
{ 
    /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
    void swap(int arr[],int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    int partition(int arr[], int low, int high) 
    { 
   	    //Write code here for Partition and Swap 
        int i = low-1;
        int pivot = arr[high];
        
        
        // moving all smaller elements to the left of the pivot
        for (int j=low; j<high; j++) {
            if (arr[j] < pivot) {
                i++; 
                swap(arr, i, j);
            }
        }
        
        // moving the pivot element after all smaller elements are moved. i+1 is the correct position for arr[high]
        swap(arr, i+1, high);
        
        // index of the correctly positioned pivot
        return i+1;
    } 
    
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(int arr[], int low, int high) 
    {  
            // Recursively sort elements before 
            // partition and after partition
        
        if (low <= high) {
            int partitionIndex = partition(arr, low, high);
            sort(arr, 0, partitionIndex - 1);
            sort(arr, partitionIndex + 1, high);
        }
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
    // Driver program 
    public static void main(String args[]) 
    { 
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
  
        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        printArray(arr); 
    } 
} 
