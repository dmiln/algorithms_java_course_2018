package practice_16_10_18;

import practice_9_10_18.Template;

import java.io.IOException;

public class IsHeap extends Template {

    @Override
    public void solve() throws IOException {
        int n = in.nextInt();
        long[] heap = new long[n];

        for (int i = 0; i < n; i++) {
            heap[i] = in.nextLong();
        }

        boolean b = true;
        for (int i = 0; i < n; i++) {
            if (2 * i + 1 < n && heap[i] >= heap[2 * i + 1]) {
                System.out.println("NO");
                b = false;
                break;
            }
            if (2 * i + 2 < n && heap[i] >= heap[2 * i + 2]) {
                System.out.println("NO");
                b = false;
                break;
            }
        }

        if (b) {
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        new IsHeap().run();
    }
}
