package JavaGold;

import java.io.File;
import java.nio.file.Path;

public abstract class AbstractClassA implements InterfaceB {

  Path[] path;

  public void set(File file) {
    if(file != null) {
      
    }
  }

  public void set2(Path path) {
    if(path != null) {

    }
  }

  // ファイルパスをコンソールに出力
  public void display(File file) {
    System.out.println(file.getPath());
  }

  // ファイルパスリストを削除
  public void clear(File file) {
    File[] list = file.listFiles();
    if(list != null) {
      for(File f : list) {
        f.delete();
      }
    }
  }

  // ファイルパスリストを返す
  protected Path[] getPathList() {
    return path;
  }
  
}