/*
    - 루트 없는 트리가 주어질 때, 트리의 루틑 1이라고 정하고 각 노드의 부모를 구하기
 */

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<Integer>[] adj;
    static int[] parent;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
        }

        parent = new int[N + 1];
        visit = new boolean[N + 1];
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int y : adj[x]) {
                if (visit[y]) {
                    continue;
                }
                parent[y] = x; // 부모 표시
                q.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro() {
        // 시작점은 1, bfs를 활용해 트리의 level을 1씩 늘려가며 부모를 저장
        bfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

}
