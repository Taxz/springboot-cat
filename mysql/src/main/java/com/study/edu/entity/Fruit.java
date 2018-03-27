package com.study.edu.entity;

import com.study.edu.annotation.FruitAnnotation;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2018/3/16.
 */
public class Fruit {
    @FruitAnnotation(name = "apple",color="red")
    private String name;
    private String color;

    public Fruit() {
    }

    public static void testFruitAnnota(){
        Fruit fruit = new Fruit();
        Field[] field = Fruit.class.getDeclaredFields();
        System.out.println(field.toString()+";"+field.length);
        for (Field f:field){
            boolean flag = f.isAnnotationPresent(FruitAnnotation.class);
            if (flag){
                FruitAnnotation anno = f.getAnnotation(FruitAnnotation.class);
                fruit.setColor(anno.color());
                fruit.setName(anno.name());
                System.out.println("Field name:"+f.getName()+",name:"+anno.name()+",color:"+anno.color());
            }
        }
        System.out.println(fruit.toString());
    }
    public static void main(String args[]){
        testFruitAnnota();
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

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
