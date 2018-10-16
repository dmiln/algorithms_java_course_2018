package practice_16_10_18;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().solve();
    }

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
        for (int i = 0; i < other.size(); i++) {
            sB.append(other.get(i));
            if (i != other.size() - 1){
                sB.append('\n');
            }
        }
        System.out.println(sB.toString());
    }

    public ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> other = new ArrayList<>();
    public StringBuilder sB = new StringBuilder();

    public void insertX(int x) {
        list.add(x);
        swiftUp();
    }

    public void extract() {
        other.add(list.get(0));
        swiftDown();
    }
    public void swiftDown(){
        list.set(0,list.get(list.size() - 1));
        list.remove(list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            if(2 * i + 2 < list.size()) {
                if (list.get(2 * i + 1) < list.get(2 * i + 2)) {
                    if (list.get(2 * i + 2) > list.get(i)) {
                        int tmp = list.get(i);
                        list.set(i, list.get(2 * i + 2));
                        list.set(2 * i + 1, tmp);
                    }
                } else {
                    if (list.get(2 * i + 1) > list.get(i)) {
                        int tmp = list.get(i);
                        list.set(i, list.get(2 * i + 1));
                        list.set(2 * i + 1, tmp);
                    }
                }
            }else if(2 * i + 1 < list.size()){
                if (list.get(2 * i + 1) > list.get(i)) {
                    int tmp = list.get(i);
                    list.set(i, list.get(2 * i + 1));
                    list.set(2 * i + 1, tmp);
                }
            }
        }
    }

    public void swiftUp() {
        for (int i = list.size() - 1; i > 0; ) {
            if (i % 2 == 0) {
                if (list.get(i) > list.get((i - 2) / 2)) {
                    int tmp = list.get(i);
                    list.set(i, list.get((i - 2) / 2));
                    list.set((i - 2) / 2, tmp);
                    i = (i - 2) / 2;
                } else {
                    i = 0;
                }
            } else {
                if (list.get(i) > list.get((i - 1) / 2)) {
                    int tmp = list.get(i);
                    list.set(i, list.get((i - 1) / 2));
                    list.set((i - 1) / 2, tmp);
                    i = (i - 1) / 2;
                } else {
                    i = 0;
                }
            }
        }
    }
}
