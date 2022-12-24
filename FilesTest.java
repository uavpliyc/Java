import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
}