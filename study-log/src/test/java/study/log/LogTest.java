package study.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

import java.net.URL;

/**
 * @author ：mmzs
 * @date ：Created in 2019/10/23 14:12
 */
public class LogTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.info("TEST ");
//        org.slf4j.spi.LocationAwareLogger
        if(logger instanceof LocationAwareLogger){
            System.out.println("11111111");
        }
        URL urlOfClass = LogTest.class.getClassLoader().getResource("org/slf4j/spi/LocationAwareLogger.class");
        System.out.println(urlOfClass);
    }
}
