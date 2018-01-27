/**
 * Project Name:shopping
 * File Name:TanKe.java
 * Package Name:com.frame
 * Date:2018年1月27日下午1:25:18
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.wangpengcheng;

/**
 * 需求：创建一个坦克，实现坦克可以移动，可以发子弹<br/>
 * 1.坦克有好的和坏的，有初始的坐标值，在初始的坐标值的基础上进行改变，所以要定义一个坦克的父类，所有坦克都可以继承该坦克类----1<br/>
 * 2.创建自己的坦克继承父类，初始化成员坐标，坦克可以移动，所以有移动速度的属性-----2<br/>
 * 3.创建一个画板，在画板上画出初始坦克，因为要画当前的坦克所以要引入自己的坦克的对象，并且附上实参，坦克移动方向分为四个方向----3<br/>
 * 所以要定义四个方向的坦克，一次只画一个,先将坦克定死<br/>
 * 4.因为要通过键盘控制坦克的方向和移动速度，所以要在画出的坦克上加上键盘监听事件，当键盘点击时，坦克发生改变，要重新画坦克<br/>
 * 5。画板需要放在窗体中，所以要创建一个窗体，在窗体中引入画板的对象，将对象放在该窗体中----4<br/>
 * 6.要使坦克可以发射子弹，需要用到多线程，用不同的线程控制不同的子弹<br/>
 * 7.因为会创建很多线程，所以要用到集合用来存储子弹<br/>
 * 8.子弹有方向，速度,初始坐标值，和生命周期<br/>
 * 9.子弹在发射时是根据坦克的方向进行发射的，坦克对准哪边子弹就发哪边<br/>
 * Description: <br/>
 * Date: 2018年1月27日 下午1:25:18 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class TanKe {
    private int x;

    private int y;

    public TanKe() {

    }

    public TanKe(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
