package Lab10;

public class HeapSort   {

    static class MaxHeap {
        int[] arr;
        int size;

        MaxHeap(int capacity) {
            arr = new int[capacity];
            size = 0;
        }

        void insert(int value) {
            arr[size] = value;
            int i = size;
            size++;

            while (i > 0) {
                int p = (i - 1) / 2;
                if (arr[p] < arr[i]) {
                    int t = arr[p];
                    arr[p] = arr[i];
                    arr[i] = t;
                    i = p;
                } else break;
            }
        }

        int extractMax() {
            if (size == 0) return -1;

            int max = arr[0];
            arr[0] = arr[size - 1];
            size--;

            int i = 0;

            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int largest = i;

                if (left < size && arr[left] > arr[largest]) largest = left;
                if (right < size && arr[right] > arr[largest]) largest = right;

                if (largest != i) {
                    int t = arr[i];
                    arr[i] = arr[largest];
                    arr[largest] = t;
                    i = largest;
                } else break;
            }

            return max;
        }

        void heapsort(int[] a) {
            for (int x : a) insert(x);

            for (int i = a.length - 1; i >= 0; i--)
                a[i] = extractMax();
        }

        void display() {
            for (int i = 0; i < size; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] a = {40, 10, 50, 20, 60, 30};

        System.out.print("Before sorting: ");
        for (int x : a) System.out.print(x + " ");
        System.out.println();

        MaxHeap h = new MaxHeap(50);
        h.heapsort(a);

        System.out.print("After sorting:  ");
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}

/*
EXPLANATION:

heapsort(int[] a):
    1. Insert all array elements into the max-heap.
    2. Repeatedly extractMax and place values from end of array backward.
    This produces ascending sorted order.

In main():
    Array a[] = {40,10,50,20,60,30}
    Printed before sorting.
    heapsort is called.
    Sorted array is printed:
    Output: 10 20 30 40 50 60

This demonstrates how heapsort works using the MaxHeap class.
*/
