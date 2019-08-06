package aleaSoftware;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileUtil {


    public static void writeToFile(Path fileName, IntStream fileDataStream ) {

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(fileName))){
            fileDataStream.forEach(pw::print);
        }
        catch (Exception e){
            System.out.println("writeToFile() Exception : " + e.getMessage());
        }
    }

}
