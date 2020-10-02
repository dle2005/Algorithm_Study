import java.util.Scanner;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sb.append((int)(Math.pow(2, n) -1) + "\n");

        hanoi(n,1, 2, 3);
        System.out.println(sb);

        sc.close();
    }
    public static void hanoi(int n, int start, int mid, int end) {
        if(n == 1) {
            sb.append(start + " " + end + "\n");
        } else {
            hanoi(n - 1, start, end, mid);

            sb.append(start + " " + end +"\n");

            hanoi(n - 1, mid, start, end);
        }
    }
}
