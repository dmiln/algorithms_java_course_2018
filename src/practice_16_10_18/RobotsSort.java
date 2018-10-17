package practice_16_10_18;

import java.util.Scanner;

public class RobotsSort {

    public void solve() {
        StringBuilder sB = new StringBuilder();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] robots = new int[n][];
        int[][] tmp = new int[n][];
        for (int i = 0; i < n; i++) {
            robots[i] = new int[2];
            robots[i][0] = in.nextInt();
            robots[i][1] = in.nextInt();
        }

        sort(robots, tmp, 0, robots.length - 1);

        for (int i = 0; i < robots.length; i++) {
            sB.append(robots[i][0]).append(' ').append(robots[i][1]);
            if (i != robots.length - 1) {
                sB.append('\n');
            }
        }

        System.out.println(sB.toString());
    }

    private void sort(int[][] a, int[][] t, int l, int r) {

        if (r > l) {
            int mid = (l + r) / 2;
            sort(a, t, l, mid);
            sort(a, t, mid + 1, r);
            merge(a, t, l, mid, r);
        }
    }

    private void merge(int[][] a, int[][] t, int l, int mid, int r) {
        if (r + 1 - l >= 0) {
            System.arraycopy(a, l, t, l, r + 1 - l);
        }

        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                a[k] = t[j++];
            } else if (j > r) {
                a[k] = t[i++];
            } else if (t[j][0] < t[i][0]) {
                a[k] = t[j++];
            } else {
                a[k] = t[i++];
            }
        }
    }

    public static void main(String[] args) {
        new RobotsSort().solve();
    }
}
