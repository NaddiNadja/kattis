public class Drinkingsong {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int N = io.getInt();
        String s = io.getWord();
        StringBuilder sb = new StringBuilder();

        for (int i = N; i>0; i--) {
            if (i!=N) sb.append("\n\n");
            sb.append(verse(i,s));
        }

        System.out.println(sb.toString());
    }

    static String verse(int i, String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        if (i!=1) sb.append(" bottles of ");
        else sb.append(" bottle of ");
        sb.append(s);
        sb.append(" on the wall, ");
        sb.append(i);
        if (i!=1) sb.append(" bottles of ");
        else sb.append(" bottle of ");
        sb.append(s);
        if (i!=1) sb.append(".\nTake one down, pass it around, ");
        else sb.append(".\nTake it down, pass it around, ");
        if (i!=1) sb.append(i-1);
        else sb.append ("no more");
        if (i-1!=1) sb.append(" bottles of ");
        else sb.append(" bottle of ");
        sb.append(s);
        if (i-1>0) sb.append(" on the wall");
        sb.append(".");

        return(sb.toString());
    }
}

/*
3 bottles of milk on the wall, 3 bottles of milk.
Take one down, pass it around, 2 bottles of milk on the wall.

2 bottles of milk on the wall, 2 bottles of milk.
Take one down, pass it around, 1 bottle of milk on the wall.

1 bottle of milk on the wall, 1 bottle of milk.
Take it down, pass it around, no more bottles of milk.
*/