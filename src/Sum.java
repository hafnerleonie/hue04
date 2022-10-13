import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Sum implements Callable<Integer> {
    private int limit;
    private List<Integer> integerList;

    public Sum(int limit, List<Integer> integerList) {
        this.limit = limit;
        this.integerList = integerList;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = limit-100; i < limit; i++) {
            sum = sum+ integerList.get(i);
        }
        return sum;
    }
}
