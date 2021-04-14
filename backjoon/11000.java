import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Class implements Comparable<Class> {
        int start; // 시작시간
        int end; // 종료시간

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 시작 시간 빠른순으로 정렬
        // 시작 시간이 같다면 그 중 종료시간이 빠른것으로
        @Override
        public int compareTo(Class o) {
            if(this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Class> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Class(start, end));
        }

        Collections.sort(list); // 시작시간을 기준으로 정렬

        // 종료시간만 추가 할 것이므로 Integer 타입으로 선언
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 첫 번째 강의를 큐에 추가
        queue.add(list.get(0).end);

        // 다음 강의의 시작시간이 queue peek의 종료시간 보다 크면 queue에 종료시간을 추가
        // 시작시간이 queue peek의 종료시간 보다 작으면 queue에서 poll을 하고 종료시간을 추가
        // list 전체를 순회하며 같은 동작을 반복하고 마지막에 queue에 남은 갯수 만큼 강의실이 필요
        for(int i = 1; i < N; i++) {
            if(queue.peek() <= list.get(i).start)
                queue.poll();
            queue.add(list.get(i).end);
        }

        System.out.println(queue.size());
    }
}
