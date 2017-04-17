public class coordinates {

    private int x;
    private int y;

    public coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isRealCoordinates() {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        }

        return true;
    }

    public coordinates addX(int modX) {
        this.x += modX;
        return this;
    }

    public coordinates addY(int modY) {
        this.y += modY;
        return this;
    }

    public coordinates clone(){
        return new coordinates(this.x, this.y);
    }

    public String toString(){
        return String.format("%1$d,%2$d ", this.x, this.y);
    }
}
