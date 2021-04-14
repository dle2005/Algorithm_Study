import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Person implements Comparable<Person> {
        int start;
        int end;

        public Person(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Person o) {
            if(this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }

    public static class Computer implements Comparable<Computer> {
        int end;
        int index;

        public Computer(int end, int index) {
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Computer o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 사람의 수
        Person[] people = new Person[N];

        for(int i = 0; i < N; i++) { // 컴퓨터 이용시간, 종료시간 입력
            st = new StringTokenizer(br.readLine()," ");
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            people[i] = new Person(P, Q);
        }

        Arrays.sort(people); // 시작 시간으로 정렬

        int[] cnt = new int[100001]; // 사용 횟수 저장
        int index = 0; // 첫번째 사람이 0을 사용

        PriorityQueue<Computer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
//        queue.add(new Computer(people[0].end, 0));

        for(int i = 0; i < N; i++) {
            while(!queue.isEmpty() && people[i].start >= queue.peek().end)
                endTime.add(queue.poll().index);

            if(!endTime.isEmpty()) {
                int n = endTime.poll();
                cnt[n]++;
                queue.offer(new Computer(people[i].end, n));
            }
            else {
                cnt[index]++;
                queue.add(new Computer(people[i].end, index++));
            }
        }

        for(int i = 0; i < 100001; i++) {
            if(cnt[i] == 0) {
                System.out.println(i);
                break;
            }
            sb.append(cnt[i]).append(" ");
        }

        System.out.println(sb);
    }
}
