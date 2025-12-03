package Lab10;

public class MaxHeaP {

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
                int parent = (i - 1) / 2;
                if (arr[parent] < arr[i]) {
                    int temp = arr[parent];
                    arr[parent] = arr[i];
                    arr[i] = temp;
                    i = parent;
                } else {
                    break;
                }
            }
        }

        int getMax() {
            if (size == 0) return -1;
            return arr[0];
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
                    int temp = arr[i];
                    arr[i] = arr[largest];
                    arr[largest] = temp;
                    i = largest;
                } else {
                    break;
                }
            }

            return max;
        }

        void display() {
            for (int i = 0; i < size; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(20);

        heap.insert(50);
        heap.insert(30);
        heap.insert(40);
        heap.insert(10);
        heap.insert(20);
        heap.insert(60);

        System.out.print("Heap elements: ");
        heap.display();

        System.out.println("Max value: " + heap.getMax());

        System.out.println("Extracted max: " + heap.extractMax());

        System.out.print("Heap after extraction: ");
        heap.display();

        heap.insert(70);

        System.out.print("Heap after inserting 70: ");
        heap.display();
    }
}

/*
EXPLANATION:

MaxHeap uses an array to store values.
'insert' adds an element at the end, then moves it up until the heap property is restored.
'getMax' returns the root at index 0.
'extractMax' removes the root, replaces it with the last element, then moves it down to restore order.
'display' prints the heap in top-to-bottom, left-to-right array order.

In main():
Values are inserted.
Heap is displayed.
Max is retrieved.
Max is extracted.
Heap is displayed again.
70 is added and displayed.

This demonstrates full heap functionality.
*/

