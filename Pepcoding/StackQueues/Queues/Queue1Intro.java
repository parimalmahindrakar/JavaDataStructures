import java.util.*;

public class Queue1Intro {

    public static void main(String[] args) {

        Queue<Integer> que = new ArrayDeque<>();
        que.add(10);
        System.out.println(que);

        que.add(20);
        System.out.println(que);

        que.add(30);
        System.out.println(que);

        que.add(100);
        System.out.println(que);

        que.remove();
        System.out.println(que);

        que.remove();
        System.out.println(que);



    }

}
