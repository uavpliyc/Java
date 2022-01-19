package JavaGold;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Logging {

  /**
    * ログ設定プロパティファイルのファイル内容
    */
    protected static final String LOGGING_PROPERTIES_DATA
        = "handlers=java.util.logging.ConsoleHandler\n"
        + ".level=FINEST\n"
        + "java.util.logging.ConsoleHandler.level=FINEST\n"
        + "java.util.logging.ConsoleHandler.formatter"
        + "=java.util.logging.SimpleFormatter";

     /**
    * ログ設定プロパティファイルのファイル名
    */
    protected static final String LOGGING_PROPERTIES
        = "task2.properties";

    /**
    * static initializer によるログ設定の初期化
    */
    static {
        final Logger logger = Logger.getLogger("Logging");
        // クラスパスの中から ログ設定プロパティファイルを取得
        logger.fine("ログ設定: " + LOGGING_PROPERTIES
            + " をもとにログを設定します。");
        final InputStream inStream = Logging.class
            .getClassLoader().getResourceAsStream(
            LOGGING_PROPERTIES);
        if (inStream == null) {
            logger.info("ログ設定: " + LOGGING_PROPERTIES
                 + " はクラスパス上に見つかりませんでした。");
        } else {
            try {
                LogManager.getLogManager().readConfiguration(inStream);
                logger.config("ログ設定: LogManagerを設定しました。");
            } catch (IOException e) {
                logger.warning("ログ設定: LogManager設定の際に"
                    +"例外が発生しました。:"+ e.toString());
            } finally {
                try {
                    if (inStream != null) inStream.close();
                } catch (IOException e) {
                    logger.warning("ログ設定: ログ設定プロパティ"
                        +"ファイルのストリームクローズ時に例外が"
                        +"発生しました。:"+ e.toString());
                }
            }
        }
    }
}