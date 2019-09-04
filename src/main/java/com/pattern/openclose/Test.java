package com.pattern.openclose;

/**
 * @Author: xue0601
 * @Date: 2019/3/22 11:21
 */
public class Test {

    /**
     * 开闭原则
     * @param args
     */
    public static void main(String[] args) {
        ChartDisplay chartDisplay = new ChartDisplay();
        chartDisplay.setAbstractChart(new PieChar());
        chartDisplay.setAbstractChart(new BarChart());
        chartDisplay.display();
    }

}
