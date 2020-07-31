import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = new int[3];
        
        for(int i = 0; i < 3; i++)
            input[i] = sc.nextInt();
        
        Arrays.sort(input);

        System.out.println(input[1]);

        sc.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = new int[3];
        int min = 101, max = 0;
        int min_index = 0, max_index = 0;

        for(int i = 0; i < 3; i++) {
            input[i] = sc.nextInt();
            if(input[i] < min) {
                min = input[i];
                min_index = i;
            }
            if(input[i] > max) {
                max = input[i];
                max_index = i;
            }
        }

        for(int i = 0; i < 3; i++)
            if(i != min_index && i != max_index) {
                System.out.println(input[i]);
                break;
            }

        sc.close();
    }
}
