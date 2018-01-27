/**
 * Project Name:Jenny
 * File Name:Shot.java
 * Package Name:game
 * Date:2018年1月27日下午4:07:26
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.wuzhen;
/**
 * Description:   <br/>
 * Date:     2018年1月27日 下午4:07:26 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class Shot implements Runnable{
    //子弹也有坐标和不同的方向；
    private int x;
    private int y;
    private int direct; 
    private int speed=5;
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }


    boolean islive=true;
    
    public Shot(int x,int y,int direct){
        this.x=x;
        this.y=y;
        this.direct=direct;
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


    public int getDirect() {
        return direct;
    }


    public void setDirect(int direct) {
        this.direct = direct;
    }


    @Override
    public void run() {
        while(true){
            if(this.x<=0||this.x>=500||this.y<=0||this.y>=400){
                islive=false;
                break;
            }
            try {
                switch(this.direct){
                case 0://子弹向上发射；
                    this.y-=this.speed;
                    break;
                case 1://向右；
                    this.x+=this.speed;
                    break;
                case 2://向下；
                    this.y+=this.speed;
                    break;
                case 3://向左；
                    this.x-=this.speed;
                    break;
                }
                Thread.sleep(100);//
            } catch (InterruptedException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }
        }
        
        
    }

}

