package practice_9_10_18;

import java.io.IOException;
import java.util.ArrayList;

public class TestCustomQueue extends Template {

    public static void main(String[] args) {
        new TestCustomQueue().run();
    }

    @Override
    public void solve() throws IOException {
        CustomQueue customQueue = new CustomQueue();
        boolean wasTrue = true;
        while (wasTrue) {
            String s = in.next();
            switch (s) {
            case "push":
                customQueue.push(in.nextInt());
                break;
            case "pop":
                customQueue.pop();
                break;
            case "front":
                customQueue.front();
                break;
            case "size":
                customQueue.size();
                break;
            case "clear":
                customQueue.clear();
                break;
            case "exit":
                wasTrue = false;
                customQueue.exit();
            }
        }
    }

    class CustomQueue {
        private ArrayList<Integer> queue = new ArrayList<>();

        void push(int n) {
            queue.add(n);
            System.out.println("ok");
        }

        void pop() {
            if (queue.size() > 0) {
                System.out.println(queue.get(0));
                queue.remove(0);
            }
        }

        void front() {
            if (queue.size() > 0) {
                System.out.println(queue.get(0));
            }
        }

        void size() {
            System.out.println(queue.size());
        }

        void clear() {
            queue.clear();
            System.out.println("ok");
        }

        void exit() {
            System.out.println("bye");
        }
    }
}
