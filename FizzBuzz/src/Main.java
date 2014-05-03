import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(new FileReader(args[0]));
        while (console.hasNext()) {
            int first = console.nextInt();
            int second = console.nextInt();
            int third = console.nextInt();

            for (int i = 1; i <= third; i++) {
                if (i % first == 0 && i % second == 0) {
                    System.out.printf("FB ");
                } else if (i % first == 0) {
                    System.out.printf("F ");
                } else if (i % second == 0) {
                    System.out.printf("B ");
                } else {
                    System.out.printf("%d ", i);
                }
            }
            System.out.println();
        }
        console.close();
    }
}