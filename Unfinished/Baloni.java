package Unfinished;

public class Baloni {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int[] input = new int[n];
        for (int i = 0; i<n; i++) input[i] = io.getInt();

        boolean[] popped = new boolean[n];
        int firstNotPopped = 0;
        int popsum = 0;
        int arrows = 0;
        while (popsum<n) {
            int curheight = input[firstNotPopped];
            popped[firstNotPopped] = true;
            popsum++;
            boolean nextfound = false;
            for (int i = firstNotPopped+1; i<n; i++) {
                if (!popped[i]) {
                    if (input[i] == curheight-1) {
                        popped[i] = true;
                        popsum++;
                        curheight--;
                    } else if (!nextfound) {
                        nextfound = true;
                        firstNotPopped = i;
                    }
                }
                if (curheight < 1) break;
            }
            arrows++;
        }

        System.out.println(arrows);
    }
}
