import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class FolderFile {
  public static void main(String[] args) {

    try (BufferedReader br = new BufferedReader(new FileReader("test2.txt"))) {
      br.skip(4);
      System.out.println((char)br.read());
      br.mark(5);
      System.out.println(br.readLine());
      br.reset();
      System.out.println((char)br.read());
    } catch (IOException e) {
      e.printStackTrace();
    }
    

    FolderFile f = new FolderFile();
    System.out.println(f.concatPath("c:", "index.html"));

    Path path = Paths.get("c:index.html");
    // toFile
    File file = path.toFile();
    // toPath
    Path path2 = file.toPath();
    try {
      DosFileAttributes att = Files.readAttributes(path2, DosFileAttributes.class);
      System.out.println(att.isDirectory());
      System.out.println(att.isHidden());
      String s = file.getAbsolutePath();
      System.out.println(s);
      String s1 = file.getName();
      System.out.println(s1);
      boolean s2 = file.isFile();
      System.out.println(s2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String concatPath(String folder, String file){
    if (!folder.endsWith("¥¥")){
      folder += "¥";
    }
    return folder + file;
  }

}