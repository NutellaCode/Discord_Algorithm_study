import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1021 {
    static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // ������ ��
        int m = Integer.parseInt(st.nextToken()); // ���� ã�� ���� ���� ���� 3�̸� 3�� ã�� ����

        // queue �� n��ŭ ����, (n = 10�̸� 1~10����)
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        /*
        1. ù ��° ���Ҹ� �̾Ƴ���. �� ������ �����ϸ�, ���� ť�� ���Ұ� a1, ..., ak�̾��� ���� a2, ..., ak�� ���� �ȴ�.
        2. �������� �� ĭ �̵���Ų��. �� ������ �����ϸ�, a1, ..., ak�� a2, ..., ak, a1�� �ȴ�.
        3. ���������� �� ĭ �̵���Ų��. �� ������ �����ϸ�, a1, ..., ak�� ak, a1, ..., ak-1�� �ȴ�.

        2, 3�� �ּ�ȭ�� �� �־�� ��.
         */
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            count = checkQueuePeekNumberSameInputNumber(number);
            answer += count;
        }

        System.out.println(answer);

    }

    static int checkQueuePeekNumberSameInputNumber(int inputNumber) {
        if (queue.peek() == inputNumber) {
            popNumber();
            return 0;
        }

        LinkedList<Integer> secondQ = new LinkedList<>(queue);
        LinkedList<Integer> thirdQ = new LinkedList<>(queue);
        int second = popAndOffer(secondQ, inputNumber);
        int third = popLastAndOfferFirst(thirdQ, inputNumber);

        if (second <= third) {
            popAndOffer(queue, inputNumber);
            queue.poll();
        } else {
            popLastAndOfferFirst(queue, inputNumber);
            queue.poll();
        }

        return Math.min(second, third);
    }

    // 1. �޼���
    static void popNumber() { // ���� �Է��� ���ڿ� ť�� �� �� ���ڰ� ��ġ�� ��, ����
        queue.poll();
    }

    // 2. �޼���
    static int popAndOffer(LinkedList<Integer> q, int inputNumber) { // ó�� ���� �� �ڷ� �ѱ�� ����
        int count = 0;
        while (q.peek() != inputNumber) {
            count++;
            q.offer(q.pop());
        }
        return count;
    }

    // 3. �޼���
    static int popLastAndOfferFirst(LinkedList<Integer> q, int inputNumber) { // �� ���� ���� ó������ �ѱ�� ����
        int count = 0;

        while (q.peek() != inputNumber) {
            count++;

            q.offerFirst(q.pollLast());
        }
        return count;
    }
}