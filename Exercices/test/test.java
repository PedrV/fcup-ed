package test;

import java.util.ArrayList;

class Triple<K,V,D> {
    private K key;
    private V value;
    private D distinct;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public D getDistinct() {
        return distinct;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setDistinct(D distinct) {
        this.distinct = distinct;
    }
}

/* class Pair<K,V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
 */


class Person {
    private String name;
    private Integer age;

    Person (String name, Integer age) {
        this.age = age;
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String gretings() {
        return "Hello kind person, my name is " + name + " I'm " + age + " glad to meet you!";
    }
}

class Student extends Person {
    private Integer number;
    private String institution;

    Student (Integer number, String name, Integer age, String institution) {
        super(name, age);
        this.number = number;
        this.institution = institution;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String gretings() {
        return "Hello kind person, my name is " + super.getName() + " I'm " + super.getAge() + " I study at " + institution
        + " glad to meet you!";
    }
}


class Worker extends Person {
    private Integer salary;
    private String company;

    Worker (Integer salary, String name, Integer age, String company) {
        super(name, age);
        this.company = company;
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public String gretings() {
        return "Hello kind person, my name is " + super.getName() + " I'm " + super.getAge() + " I proudly work at " + company
        + " and my salary is none of your business," + " glad to meet you!";
    }
}

/* class StudentWorker extends Student {
    private class StudentWorker4real extends Worker {
        StudentWorker4real (Integer salary, String name, Integer age, String company) {
            super(salary, name, age, company);
        }
    }

} */





public class test {
    
}