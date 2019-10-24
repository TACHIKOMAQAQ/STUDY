package study.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author ：mmzs
 * @date ：Created in 2019/10/23 14:12
 */
public class LogTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.info("TEST ");
    }
}
