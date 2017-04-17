import java.util.Scanner;

public class partie {

    private plateau plateau;

    private int turnToPlay;

    public partie() {
        this.plateau = new plateau();
    }

    public void launch() {
        boolean finish = true;

        this.turnToPlay = pion.BLANC;
        System.out.println("White start");

        while (finish) {

            Scanner s = new Scanner(System.in);
            System.out.println(this.plateau.toString());

            coordinates c = new coordinates(0,0);
            boolean play = true;
            while (play) {
                c = this.askCase(s);
                if (this.plateau.canPlayPion(c)) {
                    play = false;
                } else {
                    System.out.println("Can't play ir");
                }
            }

            this.plateau.playPion(turnToPlay, c);

            if (this.plateau.checkVictory(c)) {
                finish = false;

                if (this.turnToPlay == pion.BLANC) {
                    System.out.println("White WIN");
                } else {
                    System.out.println("Black WIN");
                }

                System.out.println(this.plateau.toString());
            } else {
                if (this.turnToPlay == pion.BLANC)
                    this.turnToPlay = pion.NOIR;
                else
                    this.turnToPlay = pion.BLANC;
            }
        }
    }

    public coordinates askCase(Scanner s) {
        System.out.println("Select where to play");
        System.out.print("x: ");
        int x = s.nextInt();
        System.out.print("y: ");
        int y = s.nextInt();
        return new coordinates(y, x);
    }

}
