import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesTest {
public static void main(String[] args) throws IOException {

}


    void createDelete() throws IOException {
        Files.createDirectories(Paths.get("tmp"));
        Files.createFile(Paths.get("tmp/test.txt"));
        
        // Files.delete(Paths.get("nullDir"));
        Files.deleteIfExists(Paths.get("nullDir"));
        
        // Files.deleteIfExists(Paths.get("tmp"));
    }

    void copyMove() throws IOException {
        Path p1 = Paths.get("test1.txt");
        Path p2 = Paths.get("test2.txt");
        Path p3 = Paths.get("test3.txt");
        Path p4 = Paths.get("test4.txt");
    
        Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
        Files.move(p3, p4, StandardCopyOption.REPLACE_EXISTING);
    }
}