package collection;/**
 * Created by shenwei on 2017/2/16.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenwei
 * @create 2017-02-16
 */
public class MapTest {
    public static void main(String[] args){
        Map<String,String> map=new HashMap<String, String>();
        map.put("1","jiangsu");
        map.put("2","anhui");
        map.put("3","zhejiang");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"  value:"+entry.getValue());
        }
    }
}
