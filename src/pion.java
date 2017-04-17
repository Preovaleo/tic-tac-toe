public class pion {

    public final static int BLANC = 1;
    public final static int NOIR = 2;

    private int color;

    public pion(int color) {
        this.color = color;
    }

    public String toString() {
        if (color == pion.BLANC) {
            return "W";
        } else {
            return "B";
        }
    }

    public boolean equals(pion other) {
        if (this.color == other.color) {
            return true;
        }
        return false;
    }

    public int getColor() {
        return this.color;
    }
}
