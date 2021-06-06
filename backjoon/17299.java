import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] F = new int[1_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            F[A[i]]++;
        }

        Stack<Integer> answer = new Stack<>();

        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && F[A[i]] >= F[stack.peek()])
                stack.pop();

            if (stack.isEmpty()) {
                answer.push(-1);
                stack.push(A[i]);
            } else {
                answer.push(stack.peek());
                stack.push(A[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!answer.isEmpty()) sb.append(answer.pop()).append(" ");

        System.out.println(sb);
    }
}
