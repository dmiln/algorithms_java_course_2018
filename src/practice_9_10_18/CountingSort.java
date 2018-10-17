package practice_9_10_18;

import java.io.IOException;

public class CountingSort extends Template{

    @Override
    public void solve() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        countingSort(a);

        for (int i = 0; i < a.length; i++){
            stringBuilder.append(a[i]);
            if (i < a.length - 1){
                stringBuilder.append(" ");
            }
        }

        System.out.println(stringBuilder.toString());
    }

    private void countingSort(int[] a){
        int max = findMax(a);
        int[] count = new int[max + 1];
        for (int x : a){
            count[x]++;
        }

        int pos = 0;
        for (int k = 0; k <= max; k++){
            for (int i = 0; i < count[k]; i++){
                a[pos++] = k;
            }
        }
    }

    private int findMax(int[] a){
        int max = 0;
        for (int x : a){
            max = Math.max(max,x);
        }
        return max;
    }

    public static void main(String[] args) {
        new CountingSort().run();
    }
}
