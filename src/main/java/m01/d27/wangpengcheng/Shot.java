/**
 * Project Name:shopping
 * File Name:Shot.java
 * Package Name:com.frame
 * Date:2018年1月27日下午3:34:08
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.wangpengcheng;

/**
 * 6.要使坦克可以发射子弹，需要用到多线程，用不同的线程控制不同的子弹<br/>
 * Description: <br/>
 * Date: 2018年1月27日 下午3:34:08 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
// 子弹类
public class Shot implements Runnable {
    private int x;

    private int y;

    private int direction;// 要和坦克的方向同步；

    private int speen = 3;

    private boolean flag = true;

    public Shot() {
    }

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeen() {
        return speen;
    }

    public void setSpeen(int speen) {
        this.speen = speen;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            try {
                switch (this.direction) {
                case 0:// 上
                    this.y = this.y - this.speen;
                    break;

                case 1:// 右
                    this.x = this.x + this.speen;
                    System.out.println("子弹的横坐标：" + this.x + "子弹的纵坐标" + this.y);

                    break;
                case 2:// 下
                    this.y = this.y + this.speen;
                    break;
                case 3:// 左
                    this.x = this.x - this.speen;
                    break;
                }
                Thread.sleep(20);
            } catch (Exception e) {
                // TODO: handle exception
            }
            if (this.y <= 0 || this.y >= 1000 || this.x <= 0 || this.x >= 1000) {
                this.flag = false;
                break;
            }
        }

    }
}
