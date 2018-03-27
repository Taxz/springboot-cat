package com.study.edu;

/**
 * Created by Administrator on 2018/3/7.
 */
public enum Color implements draw{
    Green("绿色",1){
        @Override
        public void toDraw() {
            System.out.println("是绿色");
        }
    },Blue("蓝色",2){
        @Override
        public void toDraw() {
            System.out.println("是蓝色");
        }
    },Yellow("黄色",3){

        public void toDraw() {
            System.out.println("是蓝色");
        }
    };
    private String name;
    private int value;
    private Color(String name,int i){
        this.name = name;
        this.value = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String args[]){
        Color c = Color.Blue;
        c.setValue(14);
        //c.toDraw();
        System.out.println(c.getValue());
    }

    /*@Override
    public void toDraw() {

    }*/
}
interface draw{
    // TODO: 2018/3/7
    void toDraw();
}