package practice_9_10_18;

import java.io.IOException;

public class MinimumMethod extends Template {

    @Override
    public void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        System.out.println(minimumSort(a));
    }

    private int minimumSort(int[] a){
        int shifts = 0;
        int currentIndex = 0;

        for (int i = 0; i < a.length; i++) {
            int indexOfMin = i;

            for (int j = i + 1; j < a.length; j++) {
                indexOfMin = a[j] < a[indexOfMin] ? j : indexOfMin;
            }
            if (i == indexOfMin){
                continue;
            }

            int tmp = a[i];
            a[i] = a[indexOfMin];
            a[indexOfMin] = tmp;

            if (i == currentIndex){
                currentIndex = indexOfMin;
                shifts++;
            }else if(indexOfMin == currentIndex){
                currentIndex = i;
                shifts++;
            }
        }
        return shifts;
    }


    public static void main(String[] args) {
        new MinimumMethod().run();
    }
}
