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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Logging {

    private static final String LOGGING_PROPERTIES = "JavaGold/task2.properties";
    private static final Properties properties = new Properties();
    static LocalDateTime now = LocalDateTime.now();


    private Logging() throws Exception {};

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
     * プログラムからの出力(ファイルに書き込み)
     */
    public static void outputToLog() {
        // File fileName = new File(Logging.getProperty("OutputDirectory") + Logging.getProperty("LogFileName") + ".log");

        try (
            FileOutputStream fos = new FileOutputStream(Logging.getProperty("OutputDirectory") + Logging.getProperty("LogFileName") + "-" + now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) + ".log", true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, Logging.getProperty("CharacterCode"));) {
            osw.write(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        } catch (FileNotFoundException e) {
            Path filePath = Paths.get(Logging.getProperty("OutputDirectory") + Logging.getProperty("LogFileName") + "-" + now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) + ".log");
            System.out.println("ファイルがありません");
        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }

    /**
     * プログラムへの入力(ファイル読み込み)
     */
    public static void inputFromFile() {
        try (FileInputStream fis = new FileInputStream("/Users/user/Desktop/JavaGold/Task1.txt");
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

}