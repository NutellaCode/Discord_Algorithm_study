import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q15828 {
    public static void main(String[] args) throws IOException {
        // 1. input �ޱ� n => ����Ϳ� �����ϴ� ������ ũ��
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        // 2. -1�� �Է��ϸ� ����
        int result = 0;

        // 3. ��° �ٺ��� ����Ͱ� ó���ؾ� �� ���� �Է�
        while (result != -1) {
            result = Integer.parseInt(br.readLine());

            if (result == 0) {
                queue.pop();
            } else if (result > 0 && queue.size() < n) {
                queue.offer(result);
            }
        }

        int size = queue.size();
        if (size == 0) {
            System.out.println("empty");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print(queue.pop() + " ");
            }
        }
    }
}