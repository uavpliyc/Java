package JavaGold;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import gold8.data.RandomData;

public class OutputRandomData {

  public static void main(String[] args) {

    System.out.println(RandomData.getIndex(100));
    System.out.println(RandomData.getIntList(0, 100, 1, 10)
    );

    
    LocalDateTime now = LocalDateTime.now();
    String nowFormat = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    
    People tanaka = new People(1,"田中","たなか","tanaka","男","1993/03/26",now.toString(),10000000,10000);

    ArrayList<People> peopleList = new ArrayList<>();

    peopleList.add(tanaka);

    for(People list: peopleList){
      System.out.println(list.getId());
      System.out.println(list.getKanji());
      System.out.println(list.getYomi());
      System.out.println(list.getRomaji());
      System.out.println(list.getSex());
      System.out.println(list.getBirthday());
      System.out.println(list.getRegisterDate());
      System.out.println(list.getInsurance());
      System.out.println(list.getPremium());
    }

    try (
        FileOutputStream fos = new FileOutputStream(new File(Logging.getProperty("OutputDirectory") + "Contractor_" + nowFormat + ".csv"));
        OutputStreamWriter osw = new OutputStreamWriter(fos);
    ) {
      osw.write(1);
    } catch (FileNotFoundException e) {
      System.out.println("ファイルがありません");
    } catch (IOException e) {
      System.out.println("IO Error");
    }

  }

}