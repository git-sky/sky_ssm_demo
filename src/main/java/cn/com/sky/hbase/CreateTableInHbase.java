package cn.com.sky.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;


/**
 * Hbase 创建表
 */
public class CreateTableInHbase {
    // create 'test1', 'colfam1' #创建表名为test1的表, 指明列名, 为colfam1
    // list
    // desc 'test1'

    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(conf);
        //管理员对象
        Admin admin = connection.getAdmin();
        //表名
        TableName tableName = TableName.valueOf("test1");
        //表描述
        HTableDescriptor desc = new HTableDescriptor(tableName);
        //列族描述
        HColumnDescriptor coldef = new HColumnDescriptor(Bytes.toBytes("colfam1"));
        //表加入列族
        desc.addFamily(coldef);
        //创建表
        admin.createTable(desc);
        //校验表是否可用
        boolean avail = admin.isTableAvailable(tableName);
        System.out.println("Table available: " + avail);
    }

}

