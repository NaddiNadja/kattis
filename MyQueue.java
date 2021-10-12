public class MyQueue<Item> {
    private Node<Item> front;
    private Node<Item> back;
    private int size;

    public MyQueue() {
        front = null;
        back = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void enqueue(Item item) {
        Node<Item> oldback = back;
        back = new Node<>();
        back.item = item;
        back.next = null;
        if (isEmpty()) front = back;
        else oldback.next = back;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NullPointerException("Queue empty");
        Item item = front.item;
        front = front.next;
        size--;
        return item;
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
}
