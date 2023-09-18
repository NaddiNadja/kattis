import java.util.ArrayList;
import java.util.Collections;

public class AddEmUp {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int sum = io.getInt();
        ArrayList<tal> arr = new ArrayList<>();
        String print = "NO";

        for (int i = 0; i<n; i++) {
            tal x = new tal(io.getWord());
            arr.add(x);
            if (x.rev!=null) arr.add(x.rev);
        }
        
        Collections.sort(arr);
        int l = 0;
        int r = arr.size()-1;
        while (l<r) {
            if (arr.get(l).rev != arr.get(r) || arr.get(l).rev==null || arr.get(r).rev==null) {
                if (Integer.parseInt(arr.get(l).s) + Integer.parseInt(arr.get(r).s) == sum) { print = "YES"; break; }
                else if (Integer.parseInt(arr.get(l).s) + Integer.parseInt(arr.get(r).s) < sum) l++;
                else r--; 
            } else {
                if (Integer.parseInt(arr.get(l).s) + Integer.parseInt(arr.get(r).s) < sum) l++;
                else r--; 
            }
        }
        io.print(print);
        io.close();
    }

    static class tal implements Comparable<tal> {
        String s;
        tal rev;
        public tal(String s) {
            this.s = s;
            if (reverse(s)!=null) this.rev = new tal(reverse(s), this);
        }
        public tal(String s, tal rev) {
            this.s = s;
            this.rev = rev;
        }
        public int compareTo(tal that) {
            if (Integer.parseInt(this.s)<Integer.parseInt(that.s)) return -1;
            else if (Integer.parseInt(this.s)>Integer.parseInt(that.s)) return 1;
            else return 0;
        }
    }

    static String reverse(String s){
        if (s.contains("3") || s.contains("4") || s.contains("7")) {
            return null;
        } else {
            StringBuilder s1 = new StringBuilder();
            for (int i = s.length()-1; i>=0; i--) {
                if (s.charAt(i)=='6') s1.append('9');
                else if (s.charAt(i)=='9') s1.append('6');
                else s1.append(s.charAt(i));
            }
            if (s.compareTo(s1.toString())!=0) return s1.toString();
            else return null;
        }
    }
}
