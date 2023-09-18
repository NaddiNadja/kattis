public class Cup implements Comparable<Cup> {
    double radius;
    String colour;

    public Cup(String colour, double radius) {
        this.colour = colour;
        this.radius = radius;
    }

    public int compareTo(Cup that) {
        if (this.radius > that.radius) return 1;
        else if (this.radius < that.radius) return -1;
        else return 0;
    }

    public String getColour() {
        return colour;
    }
}
