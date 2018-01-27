/**
 * Project Name:dt59.java
 * File Name:TankeJpanl.java
 * Package Name:c1.d27
 * Date:2018-1-27����2:14:49
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.yexintong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * Description: <br/>
 * Date: 2018-1-27 ����2:14:49 <br/>
 * 
 * @author LangWang
 * @version
 * @see
 */
public class TankeJpanl extends JPanel implements KeyListener, Runnable {
    MyTanke mt = null;

    public TankeJpanl() {
        mt = new MyTanke(20, 20);
    }

    @Override
    public void paint(Graphics g) {

        // Auto-generated method stub
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 400, 400);
        drawingTanke(mt.getX(), mt.getY(), 0, mt.getDirection(), g);
        for (int i = 0; i < mt.vector.size(); i++) {
            Shot st = mt.vector.get(i);
            if (st.isLive() == true && mt.vector != null) {
                g.fill3DRect(st.getX(), st.getY(), 3, 3, false);
                this.repaint();
            }
            if (st.isLive() == false) {
                mt.vector.remove(st);
            }
        }
    }

    public void drawingTanke(int x, int y, int type, int direction, Graphics g) {
        switch (type) {// ̹������
        case 0:// ����̹��
            g.setColor(Color.blue);
            break;
        case 1: // �ط�̹��
            g.setColor(Color.yellow);
            break;
        }
        switch (direction) {
        case 0: // ����
            g.fill3DRect(x, y, 20, 50, false);
            g.fill3DRect(x + 20, y + 10, 30, 30, false);
            g.fill3DRect(x + 50, y, 20, 50, false);
            g.fillOval(x + 25, y + 15, 20, 20);
            g.drawLine(x + 34, y + 25, x + 34, y - 5);
            g.drawLine(x + 35, y + 25, x + 35, y - 3);
            g.drawLine(x + 36, y + 25, x + 36, y - 5);
            break;
        case 1:// ����
            g.fill3DRect(x, y, 20, 50, false);
            g.fill3DRect(x + 20, y + 10, 30, 30, false);
            g.fill3DRect(x + 50, y, 20, 50, false);
            g.fillOval(x + 25, y + 15, 20, 20);
            g.drawLine(x + 34, y + 35, x + 34, y + 60);
            g.drawLine(x + 35, y + 35, x + 35, y + 58);
            g.drawLine(x + 36, y + 35, x + 36, y + 60);
            break;
        case 2:// ����
            g.fill3DRect(x, y, 50, 20, false);
            g.fill3DRect(x + 10, y + 20, 30, 30, false);
            g.fill3DRect(x, y + 50, 50, 20, false);
            g.fillOval(x + 15, y + 25, 20, 20);
            g.drawLine(x + 15, y + 34, x - 5, y + 34);
            g.drawLine(x + 15, y + 35, x - 3, y + 35);
            g.drawLine(x + 15, y + 36, x - 5, y + 36);
            break;
        case 3:// ����
            g.fill3DRect(x, y, 50, 20, false);
            g.fill3DRect(x + 10, y + 20, 30, 30, false);
            g.fill3DRect(x, y + 50, 50, 20, false);
            g.fillOval(x + 15, y + 25, 20, 20);
            g.drawLine(x + 35, y + 34, x + 60, y + 34);
            g.drawLine(x + 35, y + 35, x + 58, y + 35);
            g.drawLine(x + 35, y + 36, x + 60, y + 36);
            break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        // Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {

        // Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_W) {
            mt.setDirection(0);
            top();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            mt.setDirection(1);
            bottom();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            mt.setDirection(2);
            left();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            mt.setDirection(3);
            right();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            mt.tkFile();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

        // Auto-generated method stub

    }

    public void top() {
        int speed = mt.getSpeed();
        int y = mt.getY() - speed;
        if (y <= 5) {
            y = 5;
        }
        mt.setY(y);
    }

    public void bottom() {
        int speed = mt.getSpeed();
        int y = mt.getY() + speed;
        if (y >= 335) {
            y = 335;
        }
        mt.setY(y);
    }

    public void left() {
        int speed = mt.getSpeed();
        int x = mt.getX() - speed;
        if (x <= 5) {
            x = 5;
        }
        mt.setX(x);
    }

    public void right() {
        int speed = mt.getSpeed();
        int x = mt.getX() + speed;
        if (x >= 335) {
            x = 335;
        }
        mt.setX(x);
    }

    @Override
    public void run() {

        // Auto-generated method stub
        try {
            Thread.sleep(50);
            this.repaint();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
