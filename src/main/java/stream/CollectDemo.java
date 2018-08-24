package stream;

import model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by kai.zhu on 2018/8/7/007.
 */
public class CollectDemo {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 45));
        list.add(new Person("tom", 30));
        list.add(new Person("jack", 30));

        //1.filter(T -> boolean)
        List<Person> list1 = list.stream().filter(person -> person.getAge() == 20).collect(Collectors.toList());
        System.out.println(list1);

        //2.distinct()
        List<Person> list2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list2);

        //3.sorted() / sorted((T, T) -> int)
        List<Person> list3 = list.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).collect(Collectors.toList());
        System.out.println(list3);

        //4.limit(long n):返回前 n 个元素
        List<Person> list4 = list.stream().limit(2).collect(Collectors.toList());
        System.out.println(list4);

        //5.skip(long n):去除前 n 个元素
        List<Person> list5 = list.stream().skip(2).collect(Collectors.toList());
        System.out.println(list5);

        //6.map(T -> R):将流中的每一个元素 T 映射为 R（类似类型转换
        List<String> list6 = list.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(list6);

        //7.flatMap(T -> Stream):将流中的每一个元素 T 映射为一个流，再把每一个流连接成为一个流
        List<String> stringlist = new ArrayList<>();
        stringlist.add("aaa bbb ccc");
        stringlist.add("ddd eee fff");
        stringlist.add("ggg hhh iii");
        List<String> list7 = stringlist.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(list7);

        //8.anyMatch(T -> boolean):流中是否有一个元素匹配给定的 T -> boolean 条件
        boolean b = list.stream().anyMatch(person -> person.getAge() == 20);
        System.out.println(b);

        //9.allMatch(T -> boolean):流中是否所有元素都匹配给定的 T -> boolean 条件
        boolean b1 = list.stream().allMatch(person -> person.getAge() == 20);
        System.out.println(b1);

        //10.noneMatch(T -> boolean):流中是否没有元素匹配给定的 T -> boolean 条件
        boolean b2 = list.stream().noneMatch(person -> person.getAge() == 20);
        System.out.println(b2);

        //11.findAny() 和 findFirst()
        //findAny()：找到其中一个元素 （使用 stream() 时找到的是第一个元素；使用 parallelStream() 并行时找到的是其中一个元素）
        //findFirst()：找到第一个元素
        Person person1 = list.stream().findFirst().get();
        System.out.println(person1);
        Person person2 = list.stream().findAny().get();
        System.out.println(person2);

        //12.reduce((T, T) -> T) 和 reduce(T, (T, T) -> T):用于组合流中的元素，如求和，求积，求最大值等
//        Integer reduce = list.stream().map(Person::getAge).reduce(0, Integer::sum);
//        int sum = list.stream().map(Person::getAge).reduce(1, (a, b) -> a * b);
//        System.out.println(reduce);

        //list --> map
        Map<String, List<Person>> collect = list.stream().collect(Collectors.groupingBy(Person::getName));
        System.out.println(collect);
    }
}
