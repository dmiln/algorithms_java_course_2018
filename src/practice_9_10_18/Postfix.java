package practice_9_10_18;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Postfix extends Template {

    @Override
    public void solve() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String strings = scanner.nextLine();
        String input[] = strings.split(" ");

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (String s : input) {
            if (isNumber(s)) {
                queue.addLast(Integer.parseInt(s));
            } else if (("+").equals(s)) {
                int b = queue.pollLast();
                int a = queue.pollLast();
                queue.addLast(a + b);
            } else if (("-").equals(s)) {
                int b = queue.pollLast();
                int a = queue.pollLast();
                queue.addLast(a - b);
            } else if (("*").equals(s)) {
                int b = queue.pollLast();
                int a = queue.pollLast();
                queue.addLast(a * b);
            }
        }

        System.out.println(queue.getFirst());

    }

    private boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Postfix().run();
    }
}
