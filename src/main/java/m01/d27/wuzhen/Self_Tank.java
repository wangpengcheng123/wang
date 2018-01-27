/**
 * Project Name:Jenny
 * File Name:Self_Tank.java
 * Package Name:game
 * Date:2018年1月27日上午9:24:21
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.wuzhen;

import java.util.Vector;

/**
 * Description:   <br/>
 * Date:     2018年1月27日 上午9:24:21 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class Self_Tank extends Tank{
    private int direct;//设置坦克方向
    private int speed=5;//设置坦克移动速度；
    Vector<Shot> vector=new Vector<Shot>(10);
    Shot shot=null;
    public void fire(){
        if(vector.size()<10){
        if(this.direct==0){
           shot=new Shot(this.getX()+35,this.getY()-10,this.direct) ;//将坦克的方向和子弹的方向关联起来；
            vector.add(shot);
        }else if(this.direct==1){
            shot=new Shot(this.getX()+60,this.getY()+35,this.direct) ;
            vector.add(shot);
        }else if(this.direct==2){
            shot=new Shot(this.getX()+35,this.getY()+60,this.direct) ;
            vector.add(shot);
        }else if(this.direct==3){
            shot=new Shot(this.getX()-10,this.getY()+35,this.direct) ;
            vector.add(shot);
        }
        Thread t=new Thread(shot);
        
        t.start();
    }
    }
    

    public int getDirect() {
        return direct;
    }
    public void setDirect(int direct) {
        this.direct = direct;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //继承了父类，将设置的坐标关联到父类
    public Self_Tank(int x,int y){
        super(x,y);
    }
    
}

