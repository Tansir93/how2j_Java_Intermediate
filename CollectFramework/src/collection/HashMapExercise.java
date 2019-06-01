package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class HashMapExercise {

    public static void main(String[] args){
        randomNumber();
        System.out.println(forNumber());
        System.out.println(forHashMap());
    }


  static   ArrayList arrayList=new ArrayList();

    public static void randomNumber(){
        for (int i=0;i<=1000000;i++){
            Random random=new Random();
            arrayList.add("tzy+"+random.nextInt(9999));
        }
    }


    public static long forNumber(){

        int i=0;
        long start =System.currentTimeMillis();
        for (Object obj:arrayList
             ) {
            if(obj.toString().equals("tzy+55"))
                i++;
        }
        long end =System.currentTimeMillis();
        return end-start;
    }


    public static long forHashMap(){
        HashMap<String, List<String>> hashMap=new HashMap<>();
        long start =System.currentTimeMillis();
        for (Object obj:
             arrayList) {
            List<String> list=hashMap.get(obj.toString());
            if(list==null){
                list= new ArrayList<String>();
                hashMap.put(obj.toString(),list);
            }
            list.add(obj.toString());
        }
        long end =System.currentTimeMillis();
        return end-start;
    }

}
