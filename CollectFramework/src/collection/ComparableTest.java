package collection;

import java.util.*;

public class ComparableTest {

    public static List<Hero> heros=new ArrayList<>();

    public static Random random=new Random();
    public static void main(String[] args){
        for(int i=0;i<=10;i++){
            heros.add(new Hero("hero+"+i, random.nextInt(100),random.nextInt(100)));
        }

        //ComparatorHero();
        ComparableHero();
    }

    public static void ComparatorHero(){

        Comparator<Hero> comparator=new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                if(o1.damage>o2.damage)
                    return 1;
                return -1;
            }
        };

        Collections.sort(heros,comparator);
        for (Hero hero:heros){
            System.out.println(hero);
        }
    }

    public static void ComparableHero(){
        Collections.sort(heros);
        for (Hero hero:heros){
            System.out.println(hero);
        }
    }

}
