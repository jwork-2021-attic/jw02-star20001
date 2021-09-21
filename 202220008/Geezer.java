package hw02;

public class Geezer {
    private static Geezer theGeezer;

    public static Geezer getTheGeezer() {
        if (theGeezer == null) {
            theGeezer = new Geezer();
        }
        return theGeezer;
    }

    private Geezer() {

    }
    
    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String lineUp(Line line) {
        String log = new String();

        if (sorter == null) {
            System.out.println("sort is null");
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
            //System.out.println(ranks[i]);
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            String[] couple = step.split("<->");
            int a, b;
            Linable x, y;
            a = Integer.parseInt(couple[0]);
            b = Integer.parseInt(couple[1]);
            x = line.get(a);
            y = line.get(b);
            //System.out.print(line.get(a) + " and " + line.get(b) + "  <->  ");
            line.put(x, b);
            line.put(y, a);
            //System.out.print(line.get(a) + " and " + line.get(b) + "\n");
            log += line.toString();
            log += "\n[frame]\n";

            //System.out.println(line.toString() + "\n");
        }

        return log;
    }
    
    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

}
