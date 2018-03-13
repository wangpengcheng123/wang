/**
 * Project Name:shopping
 * File Name:MyPanel.java
 * Package Name:com.frame
 * Date:2018年1月27日下午1:32:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.wangpengcheng;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * 3.创建一个画板，在画板上画出初始坦克，因为要画当前的坦克所以要引入自己的坦克的对象，并且附上实参，坦克移动方向分为四个方向----3<br/>
 * Description: <br/>
 * Date: 2018年1月27日 下午1:32:09 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    private MyTanKe myTanKe = null;

    public MyPanel() {
        myTanKe = new MyTanKe(60, 60);
    }

    @Override
    // 重写该方法，画出坦克
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 1000);
        paintDemo(myTanKe.getX(), myTanKe.getY(), g, myTanKe.getDirection(), myTanKe.getType());
        for (int i = 0; i < myTanKe.getVector().size(); i++) {

            Shot shot = myTanKe.getVector().get(i);
            if (shot.isFlag() && myTanKe.getVector() != null) {

                g.fill3DRect(myTanKe.getShot().getX(), myTanKe.getShot().getY(), 3, 3, false);

            }
            if (shot.isFlag() == false) {

                myTanKe.getVector().remove(shot);
            }

        }
    }

    // 坦克分为四个方向将四个方向的坦克先画好在封装起来
    public void paintDemo(int x, int y, Graphics g, int direction, int type) {
        if (type == 0) {
            g.setColor(Color.CYAN);
        } else if (type == 1) {
            g.setColor(Color.BLUE);
        }
        switch (direction) {
        case 0:// 上
            g.fill3DRect(x, y, 20, 60, true);
            g.fill3DRect(x + 20, y + 10, 40, 40, true);
            g.fill3DRect(x + 60, y, 20, 60, true);
            g.setColor(Color.green);
            g.fillOval(x + 25, y + 15, 30, 30);
            g.drawLine(x + 40, y + 15, x + 40, y - 10);
            break;
        case 1:// 右
            g.fill3DRect(x, y, 60, 20, true);
            g.fill3DRect(x + 10, y + 20, 40, 40, true);
            g.fill3DRect(x, y + 60, 60, 20, true);
            g.setColor(Color.green);
            g.fillOval(x + 15, y + 25, 30, 30);
            g.drawLine(x + 45, y + 40, x + 70, y + 40);
            break;
        case 2:// 下
            g.fill3DRect(x, y, 20, 60, true);
            g.fill3DRect(x + 20, y + 10, 40, 40, true);
            g.fill3DRect(x + 60, y, 20, 60, true);
            g.setColor(Color.green);
            g.fillOval(x + 25, y + 15, 30, 30);
            g.drawLine(x + 40, y + 45, x + 40, y + 70);
            break;
        case 3:// 左
            g.fill3DRect(x, y, 60, 20, true);
            g.fill3DRect(x + 10, y + 20, 40, 40, true);
            g.fill3DRect(x, y + 60, 60, 20, true);
            g.setColor(Color.green);
            g.fillOval(x + 15, y + 25, 30, 30);
            g.drawLine(x + 15, y + 40, x - 10, y + 40);
            break;
        default:
            break;
        }

    }

    // 4.因为要通过键盘控制坦克的方向和移动速度，所以要在画出的坦克上加上键盘监听事件，当键盘点击时，坦克发生改变，要重新画坦克<br/>
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            setChange1();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            setChange2();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            setChange3();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            setChange4();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            myTanKe.show();
        }

        this.repaint();// 重新画坦克，想要在界面上看到坦克不停的移动，只有重新画

    }

    @Override
    public void keyReleased(KeyEvent e) {

        // Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {

        // Auto-generated method stub

    }

    public void setChange1() {// 坦克向上
        myTanKe.setDirection(0);
        int index = myTanKe.getY();
        int num = myTanKe.getX();
        if (index - 10 <= 0) {
            myTanKe.setY(10);
        }
        if (num + 80 >= 1000) {
            myTanKe.setX(920);
        }
        index = myTanKe.getY() - myTanKe.getSpeed();
        myTanKe.setY(index);
    }

    public void setChange2() {// 坦克向右
        myTanKe.setDirection(1);
        int index = myTanKe.getX();
        int num = myTanKe.getY();
        if (index + 70 >= 1000) {
            myTanKe.setX(930);
        }
        if (num + 80 >= 1000) {
            myTanKe.setY(920);
        }
        index = myTanKe.getX() + myTanKe.getSpeed();
        myTanKe.setX(index);
        System.out.println(myTanKe.getX() + "---" + myTanKe.getY());
    }

    public void setChange3() {// 坦克向下
        myTanKe.setDirection(2);
        int index = myTanKe.getY();
        int num = myTanKe.getX();
        if (index + 70 >= 1000) {
            myTanKe.setY(930);// 当下一次按下时使坦克在原有的基础上改变
        }
        if (num + 80 >= 1000) {
            myTanKe.setX(920);
        }
        index = myTanKe.getY() + myTanKe.getSpeed();
        myTanKe.setY(index);
    }

    public void setChange4() {// 坦克向左
        myTanKe.setDirection(3);
        int index = myTanKe.getX();
        int num = myTanKe.getY();
        if (index - 10 <= 0) {
            myTanKe.setX(10);
        }
        if (num + 80 >= 1000) {
            myTanKe.setY(920);
        }
        index = myTanKe.getX() - myTanKe.getSpeed();
        myTanKe.setX(index);
    }

    @Override
    public void run() {// 定义线程，重画子弹，因为子弹在不停的变化，所以需要重画让它显示为动态效果

        while (true) {
            try {
                Thread.sleep(30);
                this.repaint();
            } catch (Exception e) {
                // TODO: handle exception
            }

        }

    }
}
