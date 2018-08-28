package cn.com.sky.hbase;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 *
 */
public class ShowTableInHbase {

//hbase shell  #启动HBase Shell
//
//#创建表
// create 'student', 'description', 'course'  #创建表名为student的表, 指明两个列名, 分别为description和course
//
//#信息明细
// list 'student'  #列出list表信息
//
//#插入数据
// put 'student', 'row1', 'description:age', '18'  #意思为在student表row1处插入description:age的数据为18
// put 'student', 'row1', 'description:name', 'liu'
//    put 'student', 'row1', 'course:chinese', '100'


    public static void main(String args[]) throws IOException {
        Connection connection = ConnectionFactory.createConnection();
        Admin admin = connection.getAdmin();
//        HTableDescriptor[] htds = admin.listTables();
//        for (HTableDescriptor htd : htds) {
//            System.out.println(htd);
//        }
        HTableDescriptor htd1 = admin.getTableDescriptor(TableName.valueOf("student"));
        System.out.println(htd1);

        HTableDescriptor htd2 = admin.getTableDescriptor(TableName.valueOf("counters"));
        System.out.println(htd2);

//        HTableDescriptor[] htdsall = admin.listTables(".*");
//        htds = admin.listTables(".*", true);
//        htds = admin.listTables("hbase:.*", true);
//        htds = admin.listTables("def.*:.*", true);
//        htds = admin.listTables("test.*");
//        Pattern pattern = Pattern.compile(".*2");
//        htds = admin.listTables(pattern);
//        htds = admin.listTableDescriptorsByNamespace("testspace1");

    }
}

