package JavaGold;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileInfo {

  FileSystem fileSystem = FileSystems.getDefault();

  Path path = fileSystem.getPath("");
  
}