import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, ans;
    static int[] a;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void rec(int depth, int value) {
        if (depth == N) {
            if (value == S) {
                ans++;
            }
        } else {
            rec(depth + 1, value + a[depth]); // 해당 값을 부분수열에 포함시키는 경우
            rec(depth + 1, value); // 부분수열에 포함시키지 않는 경우
        }
    }

    static void pro() {
        ans = 0;
        rec(0, 0);
        if (S == 0) {
            ans--;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

}
