// Time Complexity: O(n log n) this is the average case complexity. If all our pivot elements are positioned in the end that is, if array is in descending order time complexity is O(n)
// Space Complexity: O(log n) we may have to store log n pair of low, high


class IterativeQuickSort { 
    void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int low, int high) 
    { 
   	    //Write code here for Partition and Swap 
        int i = low-1;
        int pivot = arr[high];
        
        
        // moving all smaller elements to the left of the pivot
        for (int j=low; j<high; j++) {
            if (arr[j] <= pivot) {
                i++; 
                swap(arr, i, j);
            }
        }
        
        // moving the pivot element after all smaller elements are moved. i+1 is the correct position for arr[high]
        swap(arr, i+1, high);
        
        // index of the correctly positioned pivot
        return i+1;
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        //Try using Stack Data Structure to remove recursion.
        
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(l, h));
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            int low = pair.getKey();
            int high = pair.getValue();
            int partitionIndex = partition(arr, low, high);
            
            if (partitionIndex - 1 > low)
                stack.push(new Pair<>(low, partitionIndex - 1));
            if (partitionIndex + 1 < high)
                stack.push(new Pair<>(partitionIndex + 1, high));
            
        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 
