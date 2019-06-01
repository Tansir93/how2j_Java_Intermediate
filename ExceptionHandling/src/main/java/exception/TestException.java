package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestException {

    public static void main(String[] args){

        //exception1();
        //method1();（
        error();
    }

    public static void exception1(){
        File f=new File("my.exe");
        try{
            int i=1/0;
            /*需要处理FileNotFoundException异常*/
            new FileInputStream(f);
        }

/*        //1 使用try catch捕捉异常
        catch (FileNotFoundException ex){
            System.out.println("未找到文件");
            ex.printStackTrace();
        }

        //3 多异常捕捉办法
        catch (ArithmeticException ex){
            System.out.println("0不能为除数");
            ex.printStackTrace();
        }*/

        /*4 多异常捕捉  JDK7以上*/
        catch(FileNotFoundException|ArithmeticException ex){
            if(ex instanceof FileNotFoundException)
                System.out.println("未找到文件");
            if(ex instanceof ArithmeticException)
                System.out.println("0不能为除数");
        }

        /*2 使用异常的父类捕捉异常*/
        /*使用Exception异常后，下面就不能继续使用它的子类来捕捉异常，否则会报错*/
        catch (Exception ex){
            System.out.println("我是父类异常");
            ex.printStackTrace();
        }
        /*finally*/
        finally {
            System.out.println("始终都会被执行");
        }
    }
    public static void method1(){
        try{
            method2();
        }
        /*5 需要捕捉method2的ParseException异常*/
        catch (ParseException ex){
            ex.printStackTrace();
        }

    }
    public static void method2() throws  ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse("2016-06-03");
    }

    /*验证error异常被捕捉*/
    public static void error(){

        String str = null;
        try {
            str.toString();
        } catch (NullPointerException e) {
            System.out.println("捕捉到运行时异常: NullPointerException ");
        }

        StringBuffer sb = new StringBuffer("1234567890");
        try {
            for (int i = 0; i < 100; i++) {
                sb.append(sb.toString());
            }
        } catch (OutOfMemoryError e) {
            System.out.println("捕捉到内存用光错误:  OutOfMemoryError");
        }
    }
}
