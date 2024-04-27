import java.util.Comparator;

// A generic class implementing a min-heap data structure
public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap; // The underlying array-based structure to hold the heap elements
    private Comparator<T> comparator; // Comparator to allow custom comparison logic

    // Constructor to create a min-heap without a custom comparator
    public MyMinHeap() {
        this(null); // Calls the overloaded constructor with null argument
    }

    // Constructor to create a min-heap with a custom comparator
    public MyMinHeap(Comparator<T> comparator) {
        this.heap = new MyArrayList<>(); // Initializes the heap as an empty array list
        this.comparator = comparator; // Sets the comparator for custom comparison logic
    }

    // Checks if the heap is empty
    public boolean empty() {
        return heap.size() == 0;
    }

    // Returns the size of the heap
    public int size() {
        return heap.size();
    }

    // Returns the minimum element in the heap
    public T getMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    // Extracts and returns the minimum element from the heap
    public T extractMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = getMin(); // Retrieves the minimum element
        heap.set(0, heap.get(heap.size() - 1)); // Replaces the root with the last element
        heap.remove(heap.size() - 1); // Removes the last element (previously the minimum)
        heapify(0); // Restores the heap property by heapifying the root
        return min;
    }

    // Inserts a new element into the heap
    public void insert(T element) {
        heap.add(element); // Adds the new element to the end of the heap
        traverseUp(heap.size() - 1); // Moves the element up to its correct position to maintain the heap property
    }

    // Restores the heap property starting from the given index
    private void heapify(int index) {
        int left = leftChildOf(index); // Calculates the index of the left child
        int right = rightChildOf(index); // Calculates the index of the right child
        int smallest = index; // Initializes the index of the smallest element as the current index

        // Compares the current element with its left child and updates smallest if necessary
        if (left < heap.size() && compare(heap.get(left), heap.get(index)) < 0) {
            smallest = left;
        }

        // Compares the current element with its right child and updates smallest if necessary
        if (right < heap.size() && compare(heap.get(right), heap.get(smallest)) < 0) {
            smallest = right;
        }

        // If the current element is not the smallest, swaps it with the smallest child and recursively heapifies
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    // Moves the element at the given index up to its correct position in the heap
    private void traverseUp(int index) {
        while (index != 0 && compare(heap.get(index), heap.get(parentOf(index))) < 0) {
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    // Calculates the index of the left child of the element at the given index
    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    // Calculates the index of the right child of the element at the given index
    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    // Calculates the index of the parent of the element at the given index
    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    // Swaps the elements at the given indices in the heap
    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    // Compares two elements using the comparator if present, otherwise uses natural ordering
    private int compare(T first, T second) {
        if (comparator != null) {
            return comparator.compare(first, second);
        } else {
            return first.compareTo(second);
        }

    }
}