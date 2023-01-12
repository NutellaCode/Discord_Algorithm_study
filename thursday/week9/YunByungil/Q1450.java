import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q1450 {
    public static int[] arr;
    public static int n, c;
    public static List<Integer> a, b;
    public static int index;

    public static void main(String[] args) throws IOException {

        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // n���� ����
        c = Integer.parseInt(st.nextToken()); // c��ŭ ���� �� �ִ� ���� ( ���� )

        arr = new int[n]; // n���� ������ ��� �迭
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. ������ �����, ���� �� �ִ� ��� ����� ���� ����.
            /*
            ���� ���, 1 2 3 4�� ������ (1, 2) (3, 4)�� ������
            (0), (1), (2), (3) �̷������� ��´�. ( ���ο� �迭�� ) => ��͸� �̿�����
             */

        a = new ArrayList<>(); // ���� �� �ִ� ��� ����� �� (half)
        b = new ArrayList<>();

        dfsA(0, 0);
        dfsB(n / 2, 0);


        Collections.sort(b);

        // ����� ���� �ʹ� ���� ������ �̺� Ž������ ���� Ȯ���Ѵ�. ���?
            /*
            List<Integer> a �� ���� a.get(0, 1, 2, .... a.size)���� �����鼭
            List<Integer> b �� �� �� ���� �� �迭 �ȿ��� �̺� Ž�� �˰����� ����Ѵ�.
            a.get(0)�� ���� 0�̶�� �����ϸ� b�� ������ ���� ������ �� c���� �۰ų� ����?
            �׷��� �� �ε��� + 1�� �ϸ� ������ ���� �� �ִ�.
             */

        int answer = 0;
        for (int i = 0; i < a.size(); i++) {
            index = -1;
            binarySearch(0, b.size() - 1, a.get(i));
            answer += index + 1;
        }

        System.out.println(answer);
    }

    public static void binarySearch(int l, int r, int aValue) {

        while (l <= r) {
            int mid = (l + r) / 2;

            if (b.get(mid) + aValue <= c) {
                index = mid;
                l = mid + 1;
            } else if (b.get(mid) + aValue > c) {
                r = mid - 1;
            }
        }
    }


    // ��͸� �̿��ؼ� ��� ���� ��� �޼���
    public static void dfsA(int i, int sum) {
        if (sum > c) {
            return;
        }


        if (i == n / 2) {
            if (sum <= c) {
                a.add(sum);
            }
            return;
        }

        dfsA(i + 1, sum);
        dfsA(i + 1, sum + arr[i]);
    }

    public static void dfsB(int i, int sum) {
        if (sum > c) {
            return;
        }

        if (i == n) {
            if (sum <= c) {
                b.add(sum);
                return;
            }
        }

        dfsB(i + 1, sum);
        dfsB(i + 1, sum + arr[i]);
    }
}
