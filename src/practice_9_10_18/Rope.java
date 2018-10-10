package practice_9_10_18;

import java.io.IOException;
import java.util.Arrays;

public class Rope extends Template {

    @Override
    public void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] robes = new int[n];
        for (int i = 0; i < n; i++) {
            robes[i] = in.nextInt();
        }

        Arrays.sort(robes);

        System.out.println(binarySearch(robes, k));

    }

    private int binSeaLeft(int[] a, int key){
        int left = -1;
        int right = a.length;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (a[mid] < key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right == key ? right : -1;
    }

    private int binSeaRight(int[] a, int key){
        int left = -1;
        int right = a.length;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (a[mid] <= key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left == key ? left : -1;
    }

    private int binarySearch(int[] a, int key) {
        int left = 0;
        int right = a[a.length - 1] + 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            int target = forAll(a, mid);
            if (target < key) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return  left;
    }

    private int forAll(int[] a, int m) {
        int result = 0;
        for (int i : a) {
            result += i / m;
        }
        return result;
    }

    public static void main(String[] args) {
        new Rope().run();
    }
}
