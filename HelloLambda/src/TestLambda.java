import java.util.*;
import java.util.function.Supplier;

public class TestLambda {


    static Random random = new Random();

    public static void main(String[] args) {
        List<Hero> heroes = new ArrayList<>();
        shengcheng(heroes);
        System.out.println("普通类");
        putong(heroes);
        System.out.println("匿名类");
        niming(heroes);
        System.out.println("Lambda");
        lambdatest(heroes);
        System.out.println("lambda简化");
        ComparatorHero(heroes);
    }


    public static void shengcheng(List<Hero> heroes) {
        for (int i = 0; i <= 99; i++) {
            Hero hero = new Hero();
            heroes.add(new Hero("tzy" + i, random.nextInt(99), random.nextInt(99)));
        }
    }


    /*普通类筛选*/
    public static void putong(List<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero.damage < 50 && hero.hp > 80) {
                System.out.println(hero);
            }
        }
    }


    /*匿名类*/
    public static void niming(List<Hero> heroes) {
        HeroChecker heroChecker = new HeroChecker() {
            @Override
            public boolean test(Hero hero) {
                return hero.damage < 50 && hero.hp > 80;
            }
        };
        fitler(heroes, heroChecker);
    }


    /*Lambda*/
    public static void lambdatest(List<Hero> heroes) {
        fitler(heroes, hero -> hero.hp > 80 && hero.damage < 50);
    }

    public static void fitler(List<Hero> heroes, HeroChecker heroChecker) {
        for (Hero hero : heroes)
            if (heroChecker.test(hero))
                System.out.println(hero);

        //使用聚合操作输出
        heroes
                .stream()//管道源
                .filter(p -> p.damage < 30 && p.hp > 90)//中间操作
                .forEach(p -> System.out.println(p));//结束操作

    }

    /*lambda简化过程*/
    public static void ComparatorHero(List<Hero> heroes) {

        Comparator<Hero> comparator = new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                if (o1.damage > o2.damage)
                    return 1;
                return -1;
            }
        };
        Comparator<Hero> comparator1 = (Hero o1, Hero o2) -> {
            if (o1.damage > o2.damage)
                return 1;
            return -1;
        };
        Collections.sort(heroes, (o1, o2) -> o1.damage > o2.damage ? 1 : -1);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    /*引用静态方法*/
    public static void jingtai(List<Hero> heroes) {
        fitler(heroes, TestLambda::testHero);
    }

    /*静态方法只要和接口中的方法一致,接口中只能有一个方法*/
    public static boolean testHero(Hero hero) {
        return hero.hp > 80 && hero.hp < 50;
    }

    /*引入对象方法*/
    public static void duixiangfangfa(List<Hero> heroes) {
        TestLambda testLambda = new TestLambda();
        fitler(heroes, testLambda::testHero2);
    }

    /*和引入静态方法相似*/
    public boolean testHero2(Hero hero) {
        return hero.hp > 80 && hero.hp < 50;
    }

    /*引入容器中对象的方法*/
    public static void rongqi(List<Hero> heroes) {
        fitler(heroes, p -> p.matched());
        fitler(heroes, Hero::matched);
    }


    /*引用构造器*/
    public static void gouzhaoqi() {
        Supplier<List> supplier = new Supplier<List>() {
            @Override
            public List get() {
                return new ArrayList<String>();
            }
        };
        List list1 = getList(supplier);

        List list2 = getList(() -> new ArrayList());

        List list3 = getList(LinkedList::new);
    }

    public static List getList(Supplier<List> s) {
        return s.get();
    }

}
