import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class FolderFile {
  public static void main(String[] args) {

    FolderFile f = new FolderFile();
    System.out.println(f.concatPath("c:", "index.html"));

    Path path = Paths.get("c:index.html");
    try {
      DosFileAttributes att = Files.readAttributes(path, DosFileAttributes.class);
      System.out.println(att.isDirectory());
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