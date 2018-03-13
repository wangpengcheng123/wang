/**
 * Project Name:dt59.java
 * File Name:MyTanke.java
 * Package Name:c1.d27
 * Date:2018-1-27����2:13:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.yexintong;

import java.util.Vector;

/**
 * Description: <br/>
 * Date: 2018-1-27 ����2:13:12 <br/>
 * 
 * @author LangWang
 * @version
 * @see
 */
public class MyTanke extends Tanke {
    private int direction;

    private int speed = 5;

    private Shot shot = null;

    Vector<Shot> vector = new Vector<Shot>();

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

    public MyTanke() {
        super();
    }

    public MyTanke(int x, int y) {
        super(x, y);
    }

    /* ���𷽷� */
    public void tkFile() {
        
        if (vector.size() < 5) {
            if (this.direction == 0) {
                /* ���� */
                shot = new Shot(this.getX() + 35, this.getY() - 3, this.direction);
                vector.add(shot);
            } else if (this.direction == 1) {
                /* ���� */
                shot = new Shot(this.getX() + 35, this.getY() + 58, this.direction);
                vector.add(shot);
            } else if (this.direction == 2) {
                /* ���� */
                shot = new Shot(this.getX() - 3, this.getY() + 35, this.direction);
                vector.add(shot);
            } else if (this.direction == 3) {
                /* ���� */
                shot = new Shot(this.getX() + 58, this.getY() + 35, this.direction);
                vector.add(shot);
            }
            
            
            Thread th = new Thread(shot);
            th.start();
        }

    }
}
