package main.java.learning;

import java.io.Serializable;

public class FlyPig implements Serializable {
    //private static final long serialVersionUID = 1L;//(版本一致性，如果代码进行了微调，这个值默认生成的值会发生变化导致无法识别旧数据)
    private static String AGE = "269";
    private String name;
    private String color;
    transient private String car;//transient修饰的属性不会被序列化

    @Override
    public String toString() {
        return "FlyPig{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                ", AGE='" + AGE + '\'' +
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

}
