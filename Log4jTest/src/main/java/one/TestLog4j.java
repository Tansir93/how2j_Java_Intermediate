package one;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TestLog4j {



    public static void main(String[] args) throws InterruptedException {
        test1();
        System.out.println("-------------------------------------");
        test2();
    }
    //基于类的名称获取日志对象
    static Logger logger=Logger.getLogger(TestLog4j.class.getName());
    public static void test1() throws InterruptedException {
        //进行默认配置
        BasicConfigurator.configure();
        //设置日志输出级别
        logger.setLevel(Level.DEBUG);
        //进行不同级别的日志输出
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        Thread.sleep(1000);
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");
    }

    public static void test2() throws InterruptedException {
        //进行默认配置
        PropertyConfigurator.configure("/Users/tanzhenyu/Documents/java/workspace/study/how2j/how2j_Java_Intermediate/Log4jTest/src/main/resources/log4j.properties");
        //设置日志输出级别
        logger.setLevel(Level.DEBUG);
        //进行不同级别的日志输出
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        Thread.sleep(1000);
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");
    }

}
