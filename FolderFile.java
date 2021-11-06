public class FolderFile {
  public static void main(String[] args) {
    
    FolderFile f = new FolderFile();
    System.out.println(f.concatPath("c:", "index.html"));
  }
  public String concatPath(String folder, String file){
    if (!folder.endsWith("¥¥")){
      folder += "¥";
    }
    return folder + file;
  }
}