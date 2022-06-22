package thread.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author by Administrator on 2022/6/9.
 */
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("aa=>" + list.get(0));
        ForkJoinTask<Integer> res = forkJoinPool.submit(new ForkJoinInner(list));
        System.out.println(res.get());
        forkJoinPool.shutdownNow();
        forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> res2 = forkJoinPool.submit(new ForkJoinInner(list));
        System.out.println("res2 ==> " + res2.get());

    }
}
class ForkJoinInner extends RecursiveTask<Integer> {
    List<Integer> arrI;

    public ForkJoinInner(List<Integer> arrI){
        this.arrI = arrI;
    }


    @Override
    protected Integer compute() {
        if (arrI.size() == 1) {
            return 2;
        } else {
            int middle = arrI.size()/2;
            ForkJoinInner fj1 = new ForkJoinInner(arrI.subList(0,middle));
            ForkJoinInner fj2 = new ForkJoinInner(arrI.subList(middle,arrI.size()));
            fj1.fork();
            fj2.fork();
            fj1.join();
            fj2.join();
            return 1;
        }
    }
}
