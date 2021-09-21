package hw02;
import java.util.Random;

public class RandomArray {
    public int[] a;

    public RandomArray(int n) {
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
    }
    
    public void getRandom() {
        int i, k;
        Random rand = new Random();
        for (i = 0; i < a.length; i++) {
            k = rand.nextInt(a.length) % (a.length - i) + i;
            int temp;
            temp = a[i];
            a[i] = a[k];
            a[k] = temp;
        }
    }
    
}
