import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= N; i++)
            list.add(i);

        for(int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int j = y; j > x; j--) {
                if(list.contains(j))
                    list.remove(list.indexOf(j));
            }
        }

        System.out.println(list.size());
    }
}
