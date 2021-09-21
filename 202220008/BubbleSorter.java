package hw02;
import java.util.Random;

public class BubbleSorter implements Sorter {
    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }


    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + i + "<->" + j + "\n";
    }
    
    private String plan = "";

    @Override
    public void sort() {
        Random rand = new Random(100);
        int k;
        k = rand.nextInt(128) % 2;
        k=1;
        if (k == 0) {
            System.out.println("BubbleSorter");
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < a.length - 1; i++) {
                    if (a[i] > a[i + 1]) {
                        swap(i, i + 1);
                        sorted = false;
                    }
                }
            }
        }
        else {
            System.out.println("SelectSortr");
            sortSelect();
        }
    }

    public void sortSelect() {
        for (int i = 0; i < a.length - 1; i++) {
            int k;
            k = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[k]) {
                    k = j;
                }
            }
            if (k != i) {
                swap(i, k);
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}