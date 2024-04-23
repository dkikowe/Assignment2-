import java.util.Iterator;

public class MyArrayList <T> implements MyList <T> {
    private T[] arr;
    private int size;

    public MyArrayList() {
        arr = (T[]) new Object[5];
        size = 0;
    }


    @Override
    public void add(T item) {
        if (size >= arr.length) {
            increaseBuffer();
        }
        arr[size++] = item;
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public void set(int index, T item) {
        try {
            arr[index] = item;
        } catch (Exception e) {
            System.out.println("Wrong index");
        } finally {
            System.out.println("New value was successfully set");
        }
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index >= arr.length)  {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        T[] newArr = (T[]) new Object[arr.length + 1];
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        newArr[index] = item;
        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {
        T[] newArr = (T[]) new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = item;
        arr = newArr;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= arr.length)  {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        return arr[index];
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println('\n');
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}