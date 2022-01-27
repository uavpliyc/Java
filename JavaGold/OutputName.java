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
        String line;
        final String delimiter = ",";
        while ((line = br.readLine()) != null) {
          String[] token = line.split(delimiter);
          System.out.println(token[0] + " | "+ token[1]+ " | "+ token[2]+ " | "+ token[3]);
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
        String line;
        final String delimiter = ",";
        while ((line = br.readLine()) != null) {
          String[] token = line.split(delimiter);
          System.out.println(token[0] + " | "+ token[1]+ " | "+ token[2]);
        }
    } catch (FileNotFoundException e) {
        System.out.println("ファイルがありません");
    } catch (IOException e) {
        System.out.println("IO Error");
    }
  }

}