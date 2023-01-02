import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q2164 {
    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // 2. �� �տ� ���ڸ� �����, ���� ���� �� �� �� ���ڸ� �� �ڷ� ������ �ٽ� �� ���� ����.
        int first = 0;

        for (int i = 0; i < n - 1; i++) {
            queue.pop();
            first = queue.getFirst();
            queue.offer(first);
            queue.pop();
        }

        System.out.println(queue.getFirst());
    }
}