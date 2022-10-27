public enum StopLight2 {
  GREEN("緑"),RED("赤"),YELLOW("黄");

  private String s;

  // コンストラクタ(publicだとコンパイルエラー、何もなしでも暗黙でprivate)
  private StopLight2(String s) {
    this.s = s;
   }

   public String getString(){
     return s;
   }

}