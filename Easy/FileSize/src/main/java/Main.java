import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // setup input
        File input = new File(args[0]);
        System.out.println(input.length());

    }
}
