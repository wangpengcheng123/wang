/**
 * Project Name:Jenny
 * File Name:MyJpanel.java
 * Package Name:game
 * Date:2018年1月27日上午9:27:55
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.wuzhen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * Description:   <br/>
 * Date:     2018年1月27日 上午9:27:55 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */

public class MyJpanel extends JPanel implements KeyListener,Runnable{
   
    Self_Tank st=null;
    //创建一个面板；在面板里面画坦克；
    public MyJpanel(){
       st=new Self_Tank(40,40);//定义坦克坐标在面板中的初始位置；
    }
    public void paint(Graphics g){//画坦克；     
       super.paint(g);
       g.setColor(Color.black);//设画笔颜色；
       g.fillRect(0, 0, 500, 400);  //设置黑色固定大小的矩形；
       drawTank(st.getX(),st.getY(),0,st.getDirect(),g);
       //绘制子弹，子弹的个数
      for(int i=0;i<st.vector.size();i++){
          
         Shot shot=st.vector.get(i);
         if(shot.islive==true&&st.vector!=null){
             g.fillRect(shot.getX(),shot.getY(),3,3);
         }
         if(shot.islive==false){
             st.vector.remove(shot);
         }
      }
      }
    
    public void drawTank(int x,int y,int type,int direct,Graphics g){
       switch(type){//坦克颜色；
       case 0:
           g.setColor(Color.cyan);//我方坦克颜色
           break;
       case 1:
           g.setColor(Color.yellow);//敌方坦克颜色；
           break;
       }
       switch(direct){
       case 0://向上；
           g.fill3DRect(x,y,20,50,false);
           g.fill3DRect(x+20,y+10,30,30,false);
           g.fill3DRect(x+50,y,20,50,false);
           g.fillOval(x+25, y+15, 20, 20);
           g.drawLine(x+35, y+15, x+35, y-10);
           break;
       case 1://向右；
           g.fill3DRect(x,y,50,20,false);
           g.fill3DRect(x+10,y+20,30,30,false);
           g.fill3DRect(x,y+50,50,20,false);
           g.fillOval(x+15, y+25, 20, 20);
           g.drawLine(x+35, y+35, x+60, y+35);
           break;
       case 2://向下；
           g.fill3DRect(x,y,20,50,false);
           g.fill3DRect(x+20,y+10,30,30,false);
           g.fill3DRect(x+50,y,20,50,false);
           g.fillOval(x+25, y+15, 20, 20);
           g.drawLine(x+35, y+35, x+35, y+60);
           break;
       case 3://向左；
           g.fill3DRect(x,y,50,20,false);
           g.fill3DRect(x+10,y+20,30,30,false);
           g.fill3DRect(x,y+50,50,20,false);
           g.fillOval(x+15, y+25, 20, 20);
           g.drawLine(x+15, y+35, x-10, y+35);           
           break;
       }
       }
    //接着就是通过按键对坦克移动进行监听，需要实现KeyListener接口；
    @Override
    public void keyTyped(KeyEvent e) {                     
    }
    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode()==KeyEvent.VK_UP){
            st.setDirect(0);//按上键时，设置坦克的方向向上；
            moveUp();
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            st.setDirect(1);//向右；
            moveRight();
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            st.setDirect(2);//向下 ；
            moveDown();
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            st.setDirect(3);//向左；
            moveLeft();
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
          
          st.fire();
       
        }
        this.repaint();//移动坦克意味着重绘一次
        
    }
    public void moveUp(){//包装向上移动的方法；
        int y=st.getY()-st.getSpeed();
        if(y<=10){
            y=10;
        }
        st.setY(y);
    }
    public void moveRight(){
        int x=st.getX()+st.getSpeed();
        if(x>=440){
           x=440;
    }
        st.setX(x);
    }
    public void moveDown(){
        int y=st.getY()+st.getSpeed();
        if(y>=340){
            y=340;
        }
        st.setY(y);
    }
    public void moveLeft(){
        int x=st.getX()-st.getSpeed();
        if(x<=10){
          x=10;
        }
        st.setX(x);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
        //  Auto-generated method stub
        
    }
    @Override
    public void run() {
        
        while(true){
            
            this.repaint();
        }
        
    }
    }



