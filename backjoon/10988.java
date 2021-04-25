import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int low = 0, high = s.length()-1;
        boolean flag = true;

        while(low <= high) {
            if(s.charAt(low) != s.charAt(high)) {
                flag = false;
                break;
            }

            low++; high--;
        }

        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}
