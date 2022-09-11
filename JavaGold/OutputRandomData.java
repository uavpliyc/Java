package JavaGold;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import gold8.data.RandomData;

public class OutputRandomData {

  public static void main(String[] args) {

    System.out.println(RandomData.getIndex(100));
    System.out.println(RandomData.getIntList(0, 100, 1, 10));

    LocalDateTime now = LocalDateTime.now();

    People tanaka = new People(
      RandomData.getIndex(100),
      "田中",
      "たなか",
      "tanaka",
      "男"
      ,RandomData.getDate(LocalDate.of(1900, 1, 1), LocalDate.of(2004, 1, 1), 5),
      now,
      RandomData.getLong(1000000, 100000000, 10000),
      RandomData.getInt(10000, 1000000, 1000)
    );

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

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("task1.csv"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("task1.csv"))) {
      // 書き出し
      oos.writeObject(tanaka);
      // 読み込み(戻り値：Object型)
      People readTanaka = (People)ois.readObject();
      System.out.println(readTanaka.getId());
      System.out.println(readTanaka.getKanji());
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }

    // try (
    //     FileOutputStream fos = new FileOutputStream(new File(Logging.getProperty("OutputDirectory") + "Contractor_" + nowFormat + ".csv"));
    //     OutputStreamWriter osw = new OutputStreamWriter(fos);
    // ) {
    //   osw.write(1);
    // } catch (FileNotFoundException e) {
    //   System.out.println("ファイルがありません");
    // } catch (IOException e) {
    //   System.out.println("IO Error");
    // }

  }

}