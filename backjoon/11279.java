import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(0);

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0)
                sb.append(pop()).append("\n");
            else
                push(n);
        }

        System.out.println(sb);
    }

    public static void push(int n) {
        list.add(n);
        int index = list.size() - 1;

        while(index > 1 && list.get(index/2) < list.get(index)) {
            swap(index, index/2);
            index /= 2;
        }
    }

    public static int pop() {
        if(list.size()-1 < 1) {
            return 0;
        }

        int top = list.get(1);

        list.set(1, list.get(list.size()-1));
        list.remove(list.size()-1);

        int index = 1;
        while(index * 2 < list.size()) {
            int max = list.get(index * 2);
            int maxPos = index * 2;

            if(index*2+1 < list.size() && max < list.get(index*2+1)) {
                max = list.get(index * 2 + 1);
                maxPos = index * 2 + 1;
            }

            if(list.get(index) > max)
                break;

            swap(index, maxPos);
            index = maxPos;
        }

        return top;

    }

    public static void swap(int from, int to) {
        int temp = list.get(to);
        list.set(to, list.get(from));
        list.set(from, temp);
    }
}
