import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            String s = br.readLine();

            int result = 0;
            boolean flag = true;

            int left = 0, right = s.length()-1;
            while(left <= right) {
                if(s.charAt(left) == s.charAt(right)) {
                    left++; right--;
                }
                else {
                    int t_left = left;
                    int t_right = right;

                    t_left++;
                    while(t_left <= t_right) {
                        if(s.charAt(t_left) == s.charAt(t_right)) {
                            t_left++; t_right--;
                        }
                        else {
                            result++;
                            break;
                        }
                    }

                    t_left = left;
                    t_right = right;

                    t_right--;
                    while(t_left <= t_right) {
                        if(s.charAt(t_left) == s.charAt(t_right)) {
                            t_left++; t_right--;
                        }
                        else {
                            result++;
                            break;
                        }
                    }

                    break;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
