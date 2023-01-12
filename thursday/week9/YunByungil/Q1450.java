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

        n = Integer.parseInt(st.nextToken()); // n개의 물건
        c = Integer.parseInt(st.nextToken()); // c만큼 ?�을 ???�는 가�?( 무게 )

        arr = new int[n]; // n개의 물건???�는 배열
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 반으�??�누?�서, ?�을 ???�는 모든 경우???��? ?�다.
            /*
            ?��? ?�면, 1 2 3 4가 ?�으�?(1, 2) (3, 4)�??�누�?
            (0), (1), (2), (3) ?�런?�으�??�는?? ( ?�로??배열??) => ?��?�??�용?�자
             */

        a = new ArrayList<>(); // ?�을 ???�는 모든 경우????(half)
        b = new ArrayList<>();

        dfsA(0, 0);
        dfsB(n / 2, 0);


        Collections.sort(b);

        // 경우???��? ?�무 많기 ?�문???�분 ?�색?�로 값을 ?�인?�다. ?�떻�?
            /*
            List<Integer> a ??값을 a.get(0, 1, 2, .... a.size)까�? ?�으면서
            List<Integer> b ??�?�??�렬 ??배열 ?�에???�분 ?�색 ?�고리즘???�용?�다.
            a.get(0)??값이 0?�라�?가?�하�?b???�반??값을 ?�했????c보다 ?�거??같다?
            그러�?�??�덱??+ 1???�면 개수�?구할 ???�다.
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


    // ?��?�??�용?�서 모든 ?�을 ?�는 메서??
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
