/**
 * Project Name:Jenny
 * File Name:Tank.java
 * Package Name:game
 * Date:2018骞�鏈�7鏃ヤ笂鍗�:23:30
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.wuzhen;
/**
 * Description:   <br/>
 * Date:     2018骞�鏈�7鏃�涓婂崍9:23:30 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class Tank {

    //坦克初始化位置;需要传入设置的坐标，就得定义一个有参构造；
    private int x,y;
    public Tank(int x,int y){
        this.x=x;
        this.y=y;
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

