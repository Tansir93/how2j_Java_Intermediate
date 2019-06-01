package collection;

public class test {


    public static void main(String[] args){
        testStackRealize();
    }

    public static void testStackRealize(){
        StackRealize stackRealize=new StackRealize();
        stackRealize.push("我是1");
        stackRealize.push("我是2");
        stackRealize.push("我是3");

        System.out.println(stackRealize.peek());
        System.out.println(stackRealize.pull());
        System.out.println(stackRealize.peek());


    }
}
