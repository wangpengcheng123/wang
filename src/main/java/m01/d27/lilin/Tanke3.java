/**
 * Project Name:lession
 * File Name:Tanke3.java
 * Package Name:day20180127tank
 * Date:2018��1��27������4:41:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

pacm01.d27.lilin7tank;

import java.util.Vector;

/**
 * Description:   <br/>
 * Date:     2018��1��27�� ����4:41:09 <br/>
 * @author   11324
 * @version
 * @see
 */
public class Tanke3 extends Taikei{
    private int direct;//����
    private int speed=6;//�ٶ�
    private Shot shot = null;
    Vector<Shot> vct = new Vector<Shot>();
    
    Vector<MyTaikei> v = new Vector<MyTaikei>();
    
    public Shot getShot() {
        return shot;
    }
    public void setShot(Shot shot) {
        this.shot = shot;
    }
    public Vector<Shot> getVct() {
        return vct;
    }
    public void setVct(Vector<Shot> vct) {
        this.vct = vct;
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
    public Tanke3(){
        super();
    }
    public Tanke3(int x,int y){
        super(x,y);
    }
}

