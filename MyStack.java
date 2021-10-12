public class MyStack<Item> {
    private Node<Item> top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void push(Item item) {
        Node<Item> newtop = new Node<>();
        newtop.item = item;
        newtop.next = top;
        top = newtop;
        size++;
    }

    public Item pop() {
        if (isEmpty()) throw new NullPointerException("Stack empty");
        Item item = top.item;
        top = top.next;
        size--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NullPointerException("Stack empty");
        Item item = top.item;
        return item;
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
}
