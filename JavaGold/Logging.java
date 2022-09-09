package JavaGold;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import gold8.ruledLineG.LayoutUtil;
import gold8.ruledLineG.LayoutUtil.Align;

public class Logging {

    private static final String LOGGING_PROPERTIES = "JavaGold/task2.properties";
    private static final Properties properties = new Properties();
    static LocalDateTime now = LocalDateTime.now();


    private Logging() throws Exception {};

    // 課題2-1：staticイニシャライザでプロパティファイル読み込み
    static {
        try {
            properties.load(Files.newBufferedReader(Paths.get(LOGGING_PROPERTIES), StandardCharsets.UTF_8));
        } catch (IOException e) {
            // ファイル読み込みに失敗
            System.out.println(String.format("ファイルの読み込みに失敗しました。ファイル名:%s", LOGGING_PROPERTIES));
        }
    }

    /**
     * プロパティ値を取得する
     *
     * @param key キー
     * @return 値
     */
    public static String getProperty(final String key) {
        return getProperty(key, "");
    }

    /**
     * プロパティ値を取得する
     *
     * @param key          キー
     * @param defaultValue デフォルト値
     * @return キーが存在しない場合、デフォルト値 存在する場合、値
     */
    public static String getProperty(final String key, final String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * 課題1-1：プログラムからの出力(ファイルに書き込み)
     */
    public static void outputToLog() {

        // 課題3-1：ログファイル名に日時
        File file = new File(Logging.getProperty("OutputDirectory") + Logging.getProperty("LogFileName") + "-" + now.toString() + ".log");

        try (
            // バイト単位でデータ書き込み（trueで追記）
            FileOutputStream fos = new FileOutputStream(file, true);
            // 文字コード指定
            OutputStreamWriter osw = new OutputStreamWriter(fos, Logging.getProperty("CharacterCode"));
            ) {
            osw.write(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        } catch (FileNotFoundException e) {
            System.out.println("ファイルがありません");
        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }

    /**
     * 課題1-2：プログラムへの入力(ファイル読み込み、コンソールに出力)
     */
    public static void inputFromFile(File file) {
        try (
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Logging.getProperty("CharacterCode"));
            BufferedReader br = new BufferedReader(isr);) {
            String text;
            while ((text = br.readLine()) != null) {
                System.out.println(text);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ファイルがありません");
        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }

    // 課題1-3：データファイルを読み込み、編集してファイルに出力する
    public static void ReadAndWriteLog(File file){
        File logFile = new File(Logging.getProperty("OutputDirectory") + Logging.getProperty("LogFileName") + "-" + now.toString() + ".log");
        try (
            // 読み込み
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Logging.getProperty("CharacterCode"));
            BufferedReader br = new BufferedReader(isr);
            // ログファイルへ書き込み
            FileOutputStream fos = new FileOutputStream(logFile, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, Logging.getProperty("CharacterCode"));
            ) {
                String text;
                while ((text = br.readLine()) != null) {
                    String shapingText = LayoutUtil.fillBlank(text, 150, true, Align.LEFT);
                    osw.write(shapingText);
                }
        } catch (FileNotFoundException e) {
            System.out.println("ファイルがありません");
        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }

    public static void ReadAndWrite(){
        File dir = new File("/Users/user/Desktop/JavaGold");
        File[] list = dir.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isFile()) {
                    System.out.println("[File] : " + list[i].toString());
                    String fileName = list[i].getName();
                    // 拡張子取得
                    String extension = fileName.substring(fileName.lastIndexOf("."));
                    switch(extension) {
                        case ".txt":
                            ReadAndWriteLog(list[i]);
                            break;
                        case ".ssv":
                            ReadAndWriteLog(list[i]);
                            break;
                        case ".tsv":
                            ReadAndWriteLog(list[i]);
                            break;
                        case ".csv":
                            ReadAndWriteLog(list[i]);
                            break;
                    }
                } else if (list[i].isDirectory()) {
                    System.out.println("[Directory] : " + list[i].toString());
                }
            }
        } else {
            System.out.println("null");
        }
    }

    /**
     * 課題3-2：開始日時出力メソッド
     */
    public static long startTime() {
        long start = System.currentTimeMillis();
        System.out.println(start);
        return start;
    }

     /**
     * 課題3-2：終了日時出力メソッド
     */
    public static long endTime() {
        long end = System.currentTimeMillis();
        long progress = end - (startTime());
        System.out.println(end);
        System.out.println(progress);
        return progress;
    }



}