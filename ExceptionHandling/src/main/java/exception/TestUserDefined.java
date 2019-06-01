package exception;

public class TestUserDefined {

    public static void main(String[] args){
        try{
            testExceptionThrows(0);
        }
        catch (UserDefinedException ex){
            ex.printStackTrace();
        }
    }


    public static void testExceptionThrows (int i) throws UserDefinedException{
        if(i==0)
            throw new UserDefinedException("自定义异常");
    }
}

class UserDefinedException extends Exception {

    public UserDefinedException(){
    }
    public UserDefinedException(String msg){
        super(msg);
    }
}
