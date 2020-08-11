package main.java.learning;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class FlyPig implements Serializable {
    //private static final long serialVersionUID = 1L;//(版本一致性，如果代码进行了微调，这个值默认生成的值会发生变化导致无法识别旧数据)
    private static Integer AGE  = 0 ;
    private Integer test;
    private String name;
    private String color;
    transient private String car;//transient修饰的属性不会被序列化

    public FlyPig() {
        this.test = AGE ++;
    }

    @Override
    public String toString() {
        return "FlyPig{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                ", AGE='" + AGE.toString() + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlyPig flyPig = (FlyPig) o;
        return Objects.equals(name, flyPig.name) &&
                Objects.equals(color, flyPig.color) &&
                Objects.equals(car, flyPig.car);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, car);
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }
}
