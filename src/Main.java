/* Java program to search an element
   in a sorted and pivoted array*/

import java.util.Scanner;

class Main {

    /* Searches an element key in a
       pivoted sorted array arrp[]
       of size n */
    static int pivotBinarySearch(int arr[], int n, int key)
    {
        int pivot = findPivot(arr, 0, n - 1);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n - 1, key);

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
    }

    /* Function to get pivot. For array
       3, 4, 5, 6, 1, 2 it returns
       3 (index of 6) */
    static int findPivot(int arr[], int low, int high)
    {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }

    /* Standard Binary Search function */
    static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    // main function
    public static void main(String args[])
    {
// Here we take in the number of elements to be accepted into the array
        System.out.println("Enter number of elements");
        Scanner sc = new Scanner(System.in);
        int elementNumber = sc.nextInt();
        //We declare the array here with the size as the initial input
        int[] arr1 = new int[elementNumber];
        //we take in each element and store it into the array
        for (int i=0;i<elementNumber; i++){
            System.out.println("Enter element");
           int element = sc.nextInt();
            arr1[i] = element;
        }
//We enter the key we need to find and initiate the search function
        System.out.println("Enter the element to find");
        int key= sc.nextInt();
        System.out.println("Index of the element is : "
                + pivotBinarySearch(arr1, elementNumber, key));
    }
}