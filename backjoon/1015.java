import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        int num[][] = new int[N][2];
        int index[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            num[i][0] = i;
            num[i][1] = n;
        }

        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) return -1;
                else if (o1[1] > o2[1]) return 1;
                else {
                    if (o1[0] < o2[0])
                        return -1;
                    else
                        return 1;
                }
            }
        });

        for (int i = 0; i < N; i++)
            index[num[i][0]] = i;
        

        for (int j = 0; j < index.length; j++)
            sb.append(index[j]).append(" ");
        
        System.out.println(sb);
    }
}
