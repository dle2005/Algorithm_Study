import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (true) {
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();

            if(L == 0 && P == 0 && V == 0)
                break;

            i++;
            int a = V / P;
            int b = V % P;

            if(b >= L) b = L;

            sb.append("Case " + i + ": " + (a*L + b)).append("\n");
        }

        System.out.println(sb);
    }
}
