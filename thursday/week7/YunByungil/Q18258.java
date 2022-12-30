import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q18258 {
    static StringBuilder sb = new StringBuilder();
    static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // 1. input �ޱ�
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 2. �� 6���� ��ɾ� �Լ�ȭ
        String str = "";
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            if (str.substring(0,3).equals("pus")) {
                int num = Integer.parseInt(str.substring(5, str.length()));
                push(num);
            } else if (str.equals("pop")) {
                pop();
            } else if (str.equals("size")) {
                getSize();
            } else if (str.equals("empty")) {
                getEmpty();
            } else if (str.equals("front")) {
                getFront();
            } else if (str.equals("back")) {
                getBack();
            }
        }
        System.out.println(sb);
    }

    // push ��ɾ�
    public static void push(int num) {
        queue.offer(num);
    }

    // pop ��ɾ�
    // ť���� ���� �տ� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
    public static void pop() {
        if (queue.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue.poll()).append("\n");
        }
    }

    // size ��ɾ�
    // ť�� ����ִ� ������ ������ ����Ѵ�.
    public static void getSize() {
        sb.append(queue.size()).append("\n");
    }

    // empty ��ɾ�
    // ť�� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
    public static void getEmpty() {
        if (queue.isEmpty()) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    // front ��ɾ�
    // ť�� ���� �տ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
    public static void getFront() {
        if (queue.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue.peek()).append("\n");
        }
    }

    // back ��ɾ�
    // ť�� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
    public static void getBack() {
        if (queue.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue.getLast()).append("\n");
        }
    }
}