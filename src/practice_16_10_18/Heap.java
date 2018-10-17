package practice_16_10_18;

import java.util.ArrayList;
import java.util.Scanner;

public class Heap {

    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> out = new ArrayList<>();
    StringBuilder sB = new StringBuilder();

    public void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            if (k == 0) {
                insertX(scanner.nextInt());
            } else {
                extract();
            }
        }

        for (int i = 0; i < out.size(); i++) {
            sB.append(out.get(i));
            if (i < out.size() - 1){
                sB.append('\n');
            }
        }

        System.out.println(sB.toString());
    }

    public void swiftDown(int i) {

        int leftInd = 2 * i + 1;
        int rightInd = 2 * i + 2;

        if (leftInd < list.size()) {
            int leftValue = list.get(leftInd);
            if (rightInd < list.size()) {
                int rightValue = list.get(rightInd);
                if (leftValue >= rightValue) {
                    if (leftValue > list.get(i)) {
                        list.set(leftInd, list.get(i));
                        list.set(i, leftValue);
                        swiftDown(leftInd);
                    }
                } else if (rightValue > list.get(i)) {
                    list.set(rightInd, list.get(i));
                    list.set(i, rightValue);
                    swiftDown(rightInd);

                }
            } else if (leftValue > list.get(i)) {
                list.set(leftInd, list.get(i));
                list.set(i, leftValue);
                swiftDown(leftInd);
            }
        }
    }

    public void swiftUp(int i){
        int parentInd = (i % 2 == 0) ? (i - 2) / 2 : (i - 1) / 2;
        if (parentInd >= 0){
            int parentValue = list.get(parentInd);
            if (list.get(i) > list.get(parentInd)) {
                list.set(parentInd, list.get(i));
                list.set(i, parentValue);
                swiftUp(parentInd);
            }
        }
    }

    private void extract() {
        out.add(list.get(0));
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        swiftDown(0);
    }

    private void insertX(int nextInt) {
        list.add(nextInt);
        swiftUp(list.size() - 1);
    }

    public static void main(String[] args) {
        new Heap().solve();
    }

}
