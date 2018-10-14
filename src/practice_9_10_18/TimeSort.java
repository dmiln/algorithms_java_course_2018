package practice_9_10_18;

import java.io.IOException;

public class TimeSort extends Template {

    @Override
    public void solve() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int n = in.nextInt();
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
            a[i][2] = in.nextInt();
        }

        sortTime(a);

        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                stringBuilder.append(a[i][0]).append(" ").append(a[i][1]).append(" ").append(a[i][2]);
            } else {
                stringBuilder.append(a[i][0]).append(" ").append(a[i][1]).append(" ").append(a[i][2]).append(" ").append("\n");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private void sortTime(int[][] a) {
        int[] tmp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j][0] < a[j - 1][0]) {
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                } else if (a[j][0] == a[j - 1][0] && a[j][1] < a[j - 1][1]) {
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                } else if (a[j][0] == a[j - 1][0] && a[j][1] == a[j - 1][1] && a[j][2] < a[j - 1][2]) {
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }

    }

    public static void main(String[] args) {
        new TimeSort().run();
    }
}
