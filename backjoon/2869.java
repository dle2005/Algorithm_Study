import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int day = (v - b) / (a - b);
        
        if((v - b) % (a - b) != 0) day++;

        System.out.println(day);

        sc.close();
    }
}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        int index = 0, day = 0;

        while(true) {
            index += a;

            if(index >= v) {
                System.out.println(day);
                break;
            }
            else {
                index -= b;
                day++;
            }
        }

        sc.close();
    }
}
