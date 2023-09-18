package Unfinished;
import java.util.Arrays;
import java.util.Scanner;

public class Warehouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i<T; i++) {
            int n = Integer.parseInt(sc.nextLine());
            Whouse w = new Whouse();
            for (int j = 0; j<n; j++) {
                String[] in = sc.nextLine().split(" ");
                w.add(new Item(in[0], Integer.parseInt(in[1])));
            }
            w.show();
        }
        sc.close();
    }

    static class Item implements Comparable<Item> {
        String name;
        int stock;

        public int compareTo(Item that) {
            if (this.stock == that.stock) return this.name.compareTo(that.name);
            else return that.stock-this.stock;
        }

        public Item(String name, int stock) {
            this.name = name;
            this.stock = stock;
        }

        public void show() {
            System.out.println(name + " " + stock);
        }

        public void addStock(int extra) {
            stock += extra;
        }
    }

    static class Whouse {
        int k;
        Item[] items;

        public Whouse() {
            k = 0;
            items = new Item[30];
        }

        public void add(Item item) {
            boolean exists = false;
            Item temp = items[0];
            for (int i = 0; i<k; i++) {
                if (items[i].name.equals(item.name)) {
                    exists = true;
                    temp = items[i];
                    break;
                }
            }
            if (exists) temp.addStock(item.stock);
            else { 
                items[k] = item; 
                k++; 
            }
        }

        public void show() {
            Item[] temp = new Item[k];
            for (int i = 0; i<k; i++) temp[i] = items[i];
            Arrays.sort(temp);
            System.out.println(k);
            for (int i = 0; i<k; i++) {
                temp[i].show();
            }
        }
    }
}