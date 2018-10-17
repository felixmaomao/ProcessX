package entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    static Person person;

    @Before
    public void setUp(){
        person=new Person("felix","male",30000);
    }

    @After
    public void printInfo(){
        System.out.println(person.getName()+" "+person.getSex());
    }

    @Test
    public void getName() {
        person.setName("felix shen");
    }

    @Test
    public void setName() {
    }

    @Test
    public void getSex() {
    }

    @Test
    public void setSex() {
    }

    @Test
    public void getSalary() {
    }

    @Test
    public void setSalary() {
    }
}