import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Bis wohin wollen Sie die Summe bilden?");
        Scanner sc = new Scanner(System.in);
        int line = Integer.parseInt(sc.nextLine());
        ExecutorService executor = Executors. newFixedThreadPool(line);
        int num = 0;
        int num2 = 100;
        for (int i = 0; i < line; i++) {
            Future<Integer> result = executor.submit(new Sum(line, numbers));
            num =  num + result.get();
            num2 += 100;
        }
        System.out.println(num);
        executor.shutdown();
    }
    public List<Integer> readCSV(){
        String line;
        String[] parts;
        List<Integer> integerList = new ArrayList<>();
        try{
            Scanner s = new Scanner(new File("src/numbers.csv"));
            while (s.hasNextLine())
            {
                line = s.nextLine();
                parts = line.split(":");
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i] != null)
                    {
                        if (isNumeric(parts[i]))
                        {
                            integerList.add(Integer.parseInt(parts[i]));
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return integerList;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    }
