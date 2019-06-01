package collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StackRealize  {

    private List<String> linkedList=new LinkedList();

    public void push(String msg){
        linkedList.add(msg);
    }


    public String pull(){
      String temp=  linkedList.get(linkedList.size()-1);
      linkedList.remove(temp);
      return temp;
    }


    public String peek(){
        return linkedList.get(linkedList.size()-1);
    }
}
