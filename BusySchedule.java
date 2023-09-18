import java.util.Arrays;
import java.util.Scanner;

public class BusySchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(sc.nextLine());
        
        while (n > 0) {
            Time[] times = new Time[n];
            for (int i = 0; i<n; i++) times[i] = new Time(sc.nextLine());
            Arrays.sort(times);
            for (int i = 0; i<n; i++) {
                sb.append(times[i].toString());
                sb.append("\n");
            }
            n = Integer.parseInt(sc.nextLine());
            if (n > 0) sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        sc.close();
    }

    static class Time implements Comparable<Time> {
        int h;
        int m;
        boolean morning;

        public Time(String s) {
            String[] in1 = s.split(" ");
            if (in1[1].equals("a.m.")) this.morning = true;
            else this.morning = false;
            String[] in2 = in1[0].split(":");
            this.h = Integer.parseInt(in2[0]);
            this.m = Integer.parseInt(in2[1]);
        }

        public int compareTo(Time that) {
            if (this.morning && !that.morning) return -1;
            else if (that.morning && !this.morning) return 1;
            else {
                if (this.h % 12 < that.h % 12) return -1;
                else if (that.h % 12 < this.h % 12) return 1;
                else {
                    if (this.m < that.m) return -1;
                    else if (that.m < this.m) return 1;
                    else return 0;
                }
            }
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(h + ":");
            if (m<10) sb.append("0" + m + " ");
            else sb.append(m + " ");
            if (morning) sb.append("a.m.");
            else sb.append("p.m.");
            return sb.toString();

        }
    }
}
