package hw02;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {
    public static void main(String[] args) throws IOException {

        Line line = new Line(64);
        RandomArray arr = new RandomArray(64);
        arr.getRandom();
        for (int i = 0; i < arr.a.length; i++) {
            Gourd gourd = new Gourd(arr.a[i]);
            //System.out.println(arr.a[i]);
            line.put(gourd, i);
        }

        Geezer theGeezer = Geezer.getTheGeezer();

        Sorter sorter = new BubbleSorter();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();
    }
}
