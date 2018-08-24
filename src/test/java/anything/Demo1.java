package anything;

import model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kai.zhu on 2018/8/22/022.
 */
public class Demo1 {

    List<Person> personList;

    @Before
    public void init() {
        personList = new ArrayList<Person>();
        personList.add(new Person("zhangsan", 23));
        personList.add(new Person("lisi", 25));
        personList.add(new Person("liuyifei", 18));
    }

    @Test
    public void testIterator() {
        for (int i = 0; i < personList.size(); i++) {
            printElement(personList);
        }

    }


    private void printElement(List<Person> list) {
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person next = iterator.next();
            System.out.println(next);
            return;
        }
    }
}
