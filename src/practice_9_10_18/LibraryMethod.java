package practice_9_10_18;

import java.io.IOException;
import java.util.Arrays;

public class LibraryMethod extends Template {

    @Override
    public void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int[] b = Arrays.copyOf(a, a.length);

        sortOther(b);
    }

    private void sortOther(int[] a){
        int tmp;
        for (int i = 1; i < a.length; i++) {
            boolean wasSwap = false;
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--){
                wasSwap = true;
                tmp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = tmp;
            }
            if (wasSwap){
                for (int k = 0; k < a.length - 1; k++){
                    System.out.print(a[k] + " ");
                }
                System.out.println(a[a.length - 1]);
            }
        }
    }

    public static void main(String[] args) {
        new LibraryMethod().run();
    }
}
