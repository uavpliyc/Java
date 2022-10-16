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

  // ファイル属性変更
  public void alterFileAttr() {

  }

}