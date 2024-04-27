public class MyApplication {
    public static void main(String[] args) {
        MyArrayList <Integer> arr = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        System.out.println(arr.getFirst());
        System.out.println(arr.getLast());
        arr.printArray();
        arr.addLast(1);
        arr.printArray();
    }
}