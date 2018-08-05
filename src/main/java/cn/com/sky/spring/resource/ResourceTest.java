package cn.com.sky.spring.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

/**
 * 在Spring内部，针对于资源文件有一个统一的接口Resource表示。
 */
public class ResourceTest {

    /**
     * ClassPathResource可以用来获取类路径下的资源
     */
    @Test
    public void testClassPath() throws IOException {
        Resource resource = new ClassPathResource("test.txt");
        String fileName = resource.getFilename();
        System.out.println(fileName);
        // resource.getFile(); //获取资源对应的文件
        // resource.getURL(); //获取资源对应的URL
        if (resource.isReadable()) {
            // 每次都会打开一个新的流
            InputStream is = resource.getInputStream();
            this.printContent(is);
        }
    }

    /**
     * FileSystemResource可以用来获取文件系统里面的资源，对于FileSystemResource而言我们 可以获取到其对应的输出流。
     */
    @Test
    public void testFileSystem() throws IOException {
        FileSystemResource resource = new FileSystemResource("test.txt");
        if (resource.isReadable()) {
            // FileInputStream
            printContent(resource.getInputStream());
        }
        if (resource.isWritable()) {
            // 每次都会获取到一个新的输出流
            OutputStream os = resource.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            bw.write("你好，中国！");
            bw.flush();
            if (os != null) {
                os.close();
            }
            if (bw != null) {
                bw.close();
            }
        }
    }

    /**
     * 针对于URL进行封装的Resource，可用来从URL获取资源内容
     */
    @Test
    public void testURL() throws Exception {
        UrlResource resource = new UrlResource("http://www.google.com.hk");
        if (resource.isReadable()) {
            // URLConnection对应的getInputStream()。
            printContent(resource.getInputStream());
        }
    }

    /**
     * 针对于字节数组封装的Resource，用来从字节数组获取资源内容
     */
    @Test
    public void testByteArray() throws IOException {
        ByteArrayResource resource = new ByteArrayResource("Hello".getBytes());
        // ByteArrayInputStream()
        printContent(resource.getInputStream());
    }

    /**
     * 针对于输入流的Resource，其getInputStream()方法只能被调用一次。
     */
    @Test
    public void testInputStream() throws Exception {
        InputStream is = new FileInputStream("D:\\test.txt");
        InputStreamResource resource = new InputStreamResource(is);
        // 对于InputStreamResource而言，其getInputStream()方法只能调用一次，继续调用将抛出异常。
        InputStream target = resource.getInputStream(); // 返回的就是构件时的那个InputStream
        // is将在printContent方法里面进行关闭
        printContent(target);
    }

    /**
     * 输出输入流的内容
     */
    private void printContent(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        if (is != null) {
            is.close();
        }
        if (br != null) {
            br.close();
        }
    }

    /**
     * 通过ResourceLoader获取资源
     */
    @Test
    public void testResourceLoader() {
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("http://www.google.com.hk");
        System.out.println(resource instanceof UrlResource); // true
        // 注意这里前缀不能使用“classpath*:”，这样不能真正访问到对应的资源，exists()返回false
        resource = loader.getResource("classpath:test.txt");
        System.out.println(resource instanceof ClassPathResource); // true
        resource = loader.getResource("test.txt");
        System.out.println(resource instanceof ClassPathResource); // true
    }

}