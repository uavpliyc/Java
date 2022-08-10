import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class FolderFile {
  public static void main(String[] args) {

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