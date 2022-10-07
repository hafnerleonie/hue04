import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Integer> numbers = new ArrayList<>();
    public void readCSV(){
        File file = new File("numbers.csv");
        try {
            Scanner scanner = new Scanner(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
