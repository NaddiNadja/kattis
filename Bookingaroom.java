public class Bookingaroom {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int r = io.getInt(); // number of rooms
        int n = io.getInt(); // number of rooms already booked
        Boolean[] rooms = new Boolean[r+1]; // array of rooms (we won't use index 0)

        // set all booked rooms as true
        for (int i = 0; i<n; i++) {
            int x = io.getInt();
            rooms[x] = true;
        }

        // check for rooms that aren't booked yet, simple loop
        for (int i = 1; i<=r; i++) {
            if (rooms[i] == null) {
                System.out.println(i);
                return;
            }
        }

        System.out.println("too late");
    }
}

/*
Sample input:

100 5
42
3
2
99
1

3 3
2
3
1


6 5
4
3
2
1
5

*/