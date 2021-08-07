public class MultiTable {
  public static void main(String[] args){
    int [][] table = new int [9][9];
    for(int y = 0; y < table.length; y++ ){
      for(int x = 0; x < table[y].length; x++){
        System.out.println((y + 1) + " × " + (x + 1) + " = " + (y + 1) * (x + 1));
      }
    }
  }
}
