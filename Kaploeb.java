import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Kaploeb {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int l = io.getInt();
        int k = io.getInt();
        io.getInt(); // s

        HashMap<Integer, Person> runners = new HashMap<>();
        ArrayList<Person> finishers = new ArrayList<>();

        for (int i = 0; i<l; i++) {
            int runner = io.getInt();
            String time = io.getWord();
            String[] t = time.split("[.]");

            Person p = runners.get(runner);
            if (p == null) {
                p = new Person(runner);
                runners.put(runner,p);
            }
            p.minutes += Integer.parseInt(t[0]);
            p.seconds += Integer.parseInt(t[1]);
            p.laps++;
            if (p.laps == k) finishers.add(p);
        }

        Collections.sort(finishers);
        for (Person person : finishers) {
            System.out.println(person.number);
        }
    }

    private static class Person implements Comparable<Person> {
        int number;
        int minutes = 0;
        int seconds = 0;
        int laps = 0;

        Person(int n) {
            number = n;
        }

        @Override
        public int compareTo(Person that) {
            int temp1 = seconds + minutes * 60;
            int temp2 = that.seconds + that.minutes * 60;
            if (temp1 < temp2) return -1;
            if (temp1 > temp2) return 1;
            return this.number-that.number;
        }

    }
}
