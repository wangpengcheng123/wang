/**
 * Project Name:shopping
 * File Name:MyTanKe.java
 * Package Name:com.frame
 * Date:2018年1月27日下午1:28:06
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.wangpengcheng;

import java.util.Vector;

/**
 * 2.创建自己的坦克继承父类，初始化成员坐标，坦克可以移动，所以有移动速度的属性-----2<br/>
 * Description: <br/>
 * Date: 2018年1月27日 下午1:28:06 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class MyTanKe extends TanKe {
    private int direction;

    private int speed = 4;

    private int type = 0;

    private Shot shot = null;

    private Vector<Shot> vector = new Vector<Shot>();

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    public Vector<Shot> getVector() {
        return vector;
    }

    public void setVector(Vector<Shot> vector) {
        this.vector = vector;
    }

    public MyTanKe() {

    }

    public MyTanKe(int x, int y) {
        super(x, y);
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    // 9.子弹在发射时是根据坦克的方向进行发射的，坦克对准哪边子弹就发哪边<br/>
    public void show() {

        if (this.direction == 0) {
            System.out.println(this.direction);
            shot = new Shot(this.getX() + 40, this.getY() - 10, this.direction);
            vector.add(shot);
        } else if (this.direction == 1) {
            shot = new Shot(this.getX() + 70, this.getY() + 40, this.direction);
            vector.add(shot);
        } else if (this.direction == 2) {
            shot = new Shot(this.getX() + 40, this.getY() + 70, this.direction);
            vector.add(shot);
        } else if (this.direction == 3) {
            shot = new Shot(this.getX() - 10, this.getY() + 40, this.direction);
            vector.add(shot);
        }

        Thread thread = new Thread(shot);

        thread.start();

    }
}
