package com.pattern.prototype;

import javax.swing.*;

/**
 * @Author: xue0601
 * @Date: 2019-12-05 17:58
 */
public class Prototype extends JPanel implements Cloneable {

    public Prototype(){
        JLabel ll = new JLabel(new ImageIcon("D:\\workspace\\my-springboot\\src\\main\\resources\\image\\Wukong.jpg"));
        this.add(ll);
    }
    public Object clone(){
        Prototype p = null;
        try {
            p=(Prototype)super.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("拷贝悟空失败!");
        }
        return p;
    }

}
