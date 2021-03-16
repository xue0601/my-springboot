package com.pattern.prototype;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: xue0601
 * @Date: 2019-12-05 18:01
 */
public class ProtoTypeTest {
    public static void main(String[] args)
    {
        JFrame jf=new JFrame("原型模式测试");
        jf.setLayout(new GridLayout(1,2));
        Container contentPane=jf.getContentPane();
        Prototype obj1=new Prototype();
        contentPane.add(obj1);
        Prototype obj2=(Prototype)obj1.clone();
        contentPane.add(obj2);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}