public class MyLinkedList {
    private class MyNode<T> {
        T data;
        MyNode next;

        public MyNode(T data) {
            this.data = data;
            this.next = null;
        }
    }
}