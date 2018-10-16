package practice_16_10_18;

import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strs = s.split(" ");
        int[] a = new int[strs.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(strs[i]);
        }

        quickSort(a,0,a.length - 1);
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]);
            if (i != a.length - 1){
                System.out.print(" ");
            }
        }
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int idx = partition(a, left, right);
        quickSort(a, left, idx);
        quickSort(a, idx + 1, right);
    }

    public static int partition(int[] a, int left, int right) {
        int p = a[left + (right - left + 1) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (a[i] < p) {
                i++;
            }
            while (a[j] > p) {
                j--;
            }
            if (i <= j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }
        return j;
    }
}
