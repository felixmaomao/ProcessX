package primative;/**
 * Created by shenwei on 2018/1/16.
 */

import json.GfJsonUtil;

/**
 * @author shenwei
 * @create 2018-01-16
 */
public class BooleanTest {
    public static void main(String[] args) {
        User user = new User();
        if(!user.getRich()){
            System.out.print("false");
        }
        System.out.println(GfJsonUtil.toJSONString(user));
    }
}

class User {
    private Integer age;
    private Boolean rich;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getRich() {
        return rich;
    }

    public void setRich(Boolean rich) {
        this.rich = rich;
    }
}
