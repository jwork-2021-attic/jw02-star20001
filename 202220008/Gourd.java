package hw02;
import hw02.Line.Position;
import java.util.Random;

public class Gourd implements Linable {

    public int rank;
    private int r;
    private int g;
    private int b;

    private Position position;

    Gourd(int rank) {
        Random rand = new Random();
        this.r = rand.nextInt(256);
        this.g = rand.nextInt(256);
        this.b = rand.nextInt(256);
        this.rank = rank;
    }

    @Override
    public String toString() {
        if (this.rank > 9) {
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank + "  \033[0m";
        }
        else if (this.rank < 99) {
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m     " + this.rank + "  \033[0m";
        }
        else {
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank + "  \033[0m";
        }
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public int getValue() {
        return (this.rank);
    }
}
