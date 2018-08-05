package cn.com.sky.spring.applicationContext;

import com.google.common.base.Splitter;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Testxx {




        @Test
        public void test() {
            String poiList = "a,b ,c , d ,           f,,";
        List<String> mtIds = Splitter.on(",").trimResults().splitToList(poiList);

//        List<String> mtIds = Arrays.asList(poiList.split(","));

//            List<String> mtIds = Arrays.asList(StringUtils.split(poiList,","));

//            List<String> mtIds = Arrays.asList(StringUtils.commaDelimitedListToStringArray(poiList));



            System.out.println(mtIds);
            for (String id : mtIds) {
                System.out.println("|" + id + "|");
            }



    }
}
