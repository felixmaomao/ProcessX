package Entity;/**
 * Created by shenwei on 2017/2/23.
 */

/**
 * @author shenwei
 * @create 2017-02-23
 */
public class Person {
    private String name;
    private String sex;
    private Integer salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Person() {
    }

    public Person(String name, String sex) {
        this.setName(name);
        this.setSex(sex);
    }

    public Person(String name,String sex,Integer salary){
        this.setName(name);
        this.setSex(sex);
        this.setSalary(salary);
    }
}
