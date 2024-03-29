package JavaGold;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInfo {

  FileSystem fileSystem = FileSystems.getDefault();

  Path path = fileSystem.getPath("");

  public void getFileAttr() {
    try {
      System.out.println(Files.readAttributes(path, "*"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // ファイル属性変更1
  public void alterFileAttr() {
    try {
      Files.setAttribute(path, "dos", true);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // ファイル属性変更2
  public void alterFileAttrPos() {
    try {
      Files.setAttribute(path, "posix", true);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 課題6-4：ファイルサイズ取得
  public void getFileSize() {
    
  }

}