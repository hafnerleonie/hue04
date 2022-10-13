import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.io.File.separator;

public class JavaStreamsTester {

    private static List<String> stringList = new ArrayList<>();
    private static List<Integer> intsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if(line != null){
            switch(line){
                case "Maximum":
                    System.out.println("maximum:");
                    System.out.println(getMax());
                case "Minimum":
                    System.out.println("minimum:");
                    System.out.println(getMin());
                case "Sum":
                    System.out.println("sum:");
                    System.out.println(getSum());
                case "Durchschnitt":
                    System.out.println("average:");
                    System.out.println(getAverage());
                default:
                    System.out.println("Eingabe ist ungültig");
            }
        }
    }
    private static int getCountEmptyString(List<String> strings) {
        return (int) stringList.stream().filter(m -> m.isEmpty()).count();
    }

    public static int getCountLength3(List<String> strings) {
        return (int) stringList.stream().filter(m -> m.length()<=3).count();
    }

    public static List<String> deleteEmptyStrings(List<String> strings) {
        stringList.removeIf(String::isEmpty);
        return stringList;
    }

    public static String getMergedString(List<String> strings, String seperator) {
        String result = stringList.stream().collect(Collectors.joining(separator));
        return result;
    }
    public static List<Integer> getSquares(List<Integer> numbers){
        return intsList.stream().map(m->m*m).toList();
    }
    private static int getMax(){
        return intsList.stream().mapToInt(m -> m).max().orElseThrow(NoSuchElementException::new);
    }
    private static int getMin()
    {
        return intsList.stream().mapToInt(m -> m).min().orElseThrow(NoSuchElementException::new);
    }
    private static int getSum()
    {
        return intsList.stream().mapToInt(m -> m).sum();
    }
    private static int getAverage()
    {
        int[] array = new int[intsList.size()];
        for(int i = 0; i < intsList.size(); i++) array[i] = intsList.get(i);
        IntStream stream = Arrays.stream(array);
        return (int) stream.average().getAsDouble();
    }

}
