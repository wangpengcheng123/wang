/**
 * Project Name:lession
 * File Name:Shot.java
 * Package Name:day20180127tank
 * Date:2018��1��27������2:20:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

pacm01.d27.lilin7tank;
/**
 * Description:   <br/>
 * Date:     2018��1��27�� ����2:20:56 <br/>
 * @author   11324
 * @version
 * @see
 */
public class Shot implements Runnable{
    private int x;
    private int y;
    private int direct;//����
    private int speed=10;//�ٶ�
    private boolean isLive = true;//�Ƿ񻹻���
    
    public Shot(int x,int y,int direct){
        this.x = x;
        this.y = y;
        this.direct = direct;
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
        while(true){
            try {
            switch(this.direct){//�ӵ��ڸ������������ٶ�
                case 0:
                    this.y-=this.speed;//����
                    break;
                case 1:
                    this.x+=this.speed;//����
                    break;
                case 2:
                    this.y+=this.speed;//����
                    break;
                case 3:
                    this.x-=this.speed;//����
                    break;    
            }
                Thread.sleep(50);
            } catch (InterruptedException e) {                
                //  Auto-generated catch block
                e.printStackTrace();               
            }
            if(this.x<=0||this.x>=1000||this.y<=0||this.y>=800){
                this.isLive = false;
                break;
            }
        }
    }

}

