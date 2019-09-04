package com.pattern.openclose;

/**
 * @Author: xue0601
 * @Date: 2019/3/22 11:16
 */
public class ChartDisplay {

    private AbstractChart abstractChart;

    public void setAbstractChart(AbstractChart abstractChart) {
        this.abstractChart = abstractChart;
    }

    public void display(){
        abstractChart.display();
    }

}
