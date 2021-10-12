public class MyResizingIntArray<Item> {
    private int[] array;
    private int size;

    public MyResizingIntArray() {
        array = new int[4];
        size = 0;
    }

    public void insert(int i) {
        if (size == array.length) resize(size*2);
        array[size] = i;
        size++;
    }

    public void insertAt(int i, int pos) {
        if (pos>size || pos<0) throw new IllegalArgumentException("Out of bounds");
        array[pos] = i;
    }

    public int get(int pos) {
        if (pos>size || pos<0) throw new IllegalArgumentException("Out of bounds");
        return array[pos];
    }

    public int remove() {
        int x = array[size];
        size--;
        if (size < 0.25*array.length) resize(2*size);
        return x;
    }

    private void resize(int n) {
        int[] temp = new int[n];
        for (int i = 0; i<size; i++) temp[i] = array[i];
        array = temp;
    }
}
