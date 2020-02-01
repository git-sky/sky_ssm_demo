package cn.com.sky.spring.ioc.aggregate_collection;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/**
 * <pre>
 *
 * 集合元素	用途
 * <list>	装配list类型的值，允许重复。
 * <set>	装配set类型的值，不允许重复。
 * <map>	装配map类型的值，名称和值可以使任意类型。
 * <props>	装配properties类型的值，名称和值必须都是String类型。
 *
 *
 * <map> 和<props> 这两个元素分别对应java.util.Map 和java.util.Properties。当我们需要由键-值对组成的集合时，这两种配置元素非常有用。
 * 关键区别在于，<props> 要求键和值都必须为String 类型，而<map> 允许键和值可以是任意类型。
 *
 *
 * <entry> 元素共有四个属性，分别可以用来指定entry 的键和值：
 * 属性	用途
 * Key	指定map中entry的键为String。
 * Key-ref	指定map中entry的键为Spring上下文中其他Bean的引用。
 * Value	指定map中entry的值为String。
 * Value-ref	指定map中entry的值为Spring上下文中其他Bean的引用。
 *
 *
 * 无论<list> 还是<set> 都可以用来装配类型为java.util.Collection的任意实现或者数组的属性。
 * 但是<set>必须确保List中的每一个成员都必须是唯一的。
 *
 * <list> 与 <set> 配置下面三种情况都可以使用。
 *
 * private Collection<Book> books;
 * private List<Book> books;
 * private Book[] books;
 *
 * </pre>
 */
public class Bookstore {
    private String name;
    private Collection<Book> books;
    private Map<String, Table> tables;
    private Properties computers;

    // private List<Book> books;

    // private Book[] books;

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public void setTables(Map<String, Table> tables) {
        this.tables = tables;
    }

    public void setComputers(Properties computers) {
        this.computers = computers;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public void setBooks(List<Book> books) {
    // this.books = books;
    // }

    // public void setBooks(Book[] books) {
    // this.books = books;
    // }

    public void listAllBook() {
        System.out.println("[" + name + "]书籍：");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listAllTable() {
        System.out.println("[" + name + "]桌子：");
        for (String key : tables.keySet()) {
            System.out.println(key + "->" + tables.get(key));
        }
    }

    public void listAllComputer() {
        System.out.println("[" + name + "]电脑：");
        for (Object key : computers.keySet()) {
            System.out.println(key + "->" + computers.get(key));
        }
    }

}