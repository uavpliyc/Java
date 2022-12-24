import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

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

    void read() throws IOException {
        Path p = Paths.get("test1.txt");
        List<String> lines = Files.readAllLines(p);
        for (String s : lines) {
            System.out.println(s);
        }
    
        System.out.println(Files.lines(p).collect(Collectors.toList()));
    }

    void attribute() throws IOException {
        Path path = Paths.get("test1.txt");
    
        Object o1 = Files.getAttribute(path, "lastModifiedTime");
        Object o2 = Files.getAttribute(path, "size");
        System.out.println(o1.toString());
        System.out.println(o2.toString());
        
        BasicFileAttributes battr = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println(battr.lastModifiedTime());
        System.out.println(battr.size());
        
        DosFileAttributes dattr = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(dattr.isArchive());
        System.out.println(dattr.isDirectory());
    }

    void findTxt() throws IOException {
        Path dir = Paths.get("tmp/");

        BiPredicate<Path, BasicFileAttributes> matcher = (path, attr) -> {
            if (attr.isRegularFile() && path.getFileName().toString().endsWith(".txt")) {
                return true;
            }
            return false;
        };
    
        Files.find(dir, 10, matcher).forEach(System.out::println);
    }
}