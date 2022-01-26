package JavaGold;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OutputName {

  FirstNameBean firstName = new FirstNameBean();
  FamilyNameBean familyName = new FamilyNameBean();

  public void OutputFirstName() {

    try (
      BufferedReader br = new BufferedReader(new FileReader("JavaGold/FirstName.csv"));
      ) {
        String currentContent;
        int row = 0;
        String[] arrayColumnName = null;
        while((currentContent = br.readLine()) != null) {
          System.out.println(row + "行目のデータ");
          if(row == 0) {
            arrayColumnName = currentContent.split(",");
          } else {
            int arrayNumber = 0;
            String[] arrayColumnData = currentContent.split(",");
            for(String columnName : arrayColumnName) {
              // カラム名と該当行のデータをコンソール出力
              System.out.println(columnName + " = " + arrayColumnData[arrayNumber]);
              arrayNumber++;
            }
          }
          row++;
        }
    } catch (FileNotFoundException e) {
        System.out.println("ファイルがありません");
    } catch (IOException e) {
        System.out.println("IO Error");
    }
  }

  public void OutputFamilyName() {

    try (
      BufferedReader br = new BufferedReader(new FileReader("JavaGold/FirstName.csv"));
      ) {
        String currentContent;
        int row = 0;
        String[] arrayColumnName = null;
        while((currentContent = br.readLine()) != null) {
          System.out.println(row + "行目のデータ");
          if(row == 0) {
            arrayColumnName = currentContent.split(",");
          } else {
            int arrayNumber = 0;
            String[] arrayColumnData = currentContent.split(",");
            for(String columnName : arrayColumnName) {
              // カラム名と該当行のデータをコンソール出力
              System.out.println(columnName + " = " + arrayColumnData[arrayNumber]);
              arrayNumber++;
            }
          }
          row++;
        }
    } catch (FileNotFoundException e) {
        System.out.println("ファイルがありません");
    } catch (IOException e) {
        System.out.println("IO Error");
    }
  }

}