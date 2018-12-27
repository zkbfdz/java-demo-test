package guava;

import com.google.common.base.Optional;

/**
 * Created by kai.zhu on 2018/8/24/024.
 * Optional用于包含非空对象的不可变对象。
 * Optional对象，用于不存在值表示null。这个类有各种实用的方法，以方便代码来处理为可用或不可用，而不是检查null值。
 */
public class OptionalDemo {

    public static void main(String[] args) {
        OptionalDemo optionalDemo = new OptionalDemo();

        Integer value1 =  null;
        Integer value2 =  new Integer(10);
        //Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1);
        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);

        System.out.println(optionalDemo.sum(a,b));
    }


    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.or(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }
}
