/**
 * Project Name:dt59.java
 * File Name:Shot.java
 * Package Name:c1.d27
 * Date:2018-1-27����3:12:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.yexintong;

/**
 * Description: <br/>
 * Date: 2018-1-27 ����3:12:53 <br/>
 * 
 * @author LangWang
 * @version
 * @see
 */
public class Shot implements Runnable {
    private int x;

    private int y;

    private int direction;

    private int speed = 5;

    private boolean isLive = true;

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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }

    @Override
    public void run() {

        // Auto-generated method stub
        while (true) {
            try {
                switch (this.direction) {
                case 0:
                    // ����
                    this.y -= this.speed;
                    break;
                case 1:
                    // ����
                    this.y += this.speed;
                    break;
                case 2:
                    // ����
                    this.x -= this.speed;
                    break;
                case 3:
                    this.x += this.speed;
                    break;
                }
                Thread.sleep(50);
            } catch (InterruptedException e) {

                // Auto-generated catch block
                e.printStackTrace();
            }
            if(this.x<0||this.x>400||this.y<0||this.y>400){
                this.isLive=false;
                break;
            }
        }
    }

}
