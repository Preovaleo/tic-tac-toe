public class plateau {

    private pion[][] plateau;

    public plateau() {
        this.plateau = new pion[3][3];
    }

    public boolean playPion(int color, coordinates c) {
        if (this.plateau[c.getX()][c.getY()] != null) {
            return false;
        }

        this.plateau[c.getX()][c.getY()] = new pion(color);
        return true;
    }

    public String toString() {
        String ret;
        ret = "=============\n";
        for (int i = 0; i < this.plateau.length; i++) {
            ret += String.format("| %s | %s | %s |\n",
                    this.affichePion(new coordinates(i, 0)),
                    this.affichePion(new coordinates(i, 1)),
                    this.affichePion(new coordinates(i, 2)));
            ret += "=============\n";
        }
        return ret;
    }

    public boolean canPlayPion(coordinates c) {
        if (this.plateau[c.getX()][c.getY()] != null) {
            return false;
        }
        return true;
    }

    public boolean checkVictory(coordinates c) {
        boolean ret = false;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    ret = this.checkLigne(c, i, j);
                    if (ret) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkCase(int color, coordinates c) {
        if (!c.isRealCoordinates()) {
            return false;
        }

        if (this.plateau[c.getX()][c.getY()] == null) {
            return false;
        }

        if (this.plateau[c.getX()][c.getY()].equals(new pion(color))) {
            return true;
        }
        return false;
    }

    public boolean checkLigne(coordinates c, int modx, int mody) {

        int color = this.plateau[c.getX()][c.getY()].getColor();
        coordinates c1 = c.clone().addX(modx).addY(mody);
        coordinates c2 = c.clone().addX(2 * modx).addY(2 * mody);

        if (this.checkCase(color, c1) && this.checkCase(color, c2)) {
            return true;
        }

        return false;
    }

    public String affichePion(coordinates c) {
        if (this.plateau[c.getX()][c.getY()] == null)
            return " ";
        return this.plateau[c.getX()][c.getY()].toString();
    }
}
