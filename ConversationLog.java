import java.util.Scanner;

public class ConversationLog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());

        for (int i = 0; i<m; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 1; j<input.length; j++) {

            }
            
        }
        sc.close();
    }
    static class Word implements Comparable<Word>{
        String word;
        int count;

        public Word(String s) {
            this.word = s;
            this.count = 1;
        }

        public void oneup() {
            count++;
        }

        public int compareTo(Word that) {
            if (this.count == that.count) return this.word.compareTo(that.word);
            else return this.count - that.count;
        }
    }
}
