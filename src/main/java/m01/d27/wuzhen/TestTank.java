/**
 * Project Name:Jenny
 * File Name:TestTank.java
 * Package Name:game
 * Date:2018年1月27日上午9:28:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.wuzhen;

import javax.swing.JFrame;

/**
 * Description:   <br/>
 * Date:     2018年1月27日 上午9:28:34 <br/>
 * @author   Wu zhen
 * @version
 * @see
 */
public class TestTank extends JFrame{
    
    public TestTank(){//窗体初始化；
        this.setBounds(200, 200, 500,500 );
        this.setTitle("坦克大战");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//窗体可视化；
        
        MyJpanel mj=new MyJpanel();
        this.addKeyListener(mj);       
        Thread t=new Thread(mj);
        t.start();
        this.add(mj);//将面板添加到窗体中；

    }
    

    public static void main(String[] args) {

        /**
         * 坦克大战：
         * 1.有我方坦克，也有敌方坦克，----坦克类（父类），继承父类，初始坦克（位置，颜色等），先设置坦克
         *   大小一定，只是颜色不一样，那么可以只定义一个子类。
         * 2.创建一个窗体；即这个类要继承JFrame这个类；
         * 3.创建一个面板，并在面板里面画坦克，即要继承面板Jpanel这个类；
         * 4.要通过键使坦克移动，则需要对坦克进行监听；此时就要实现KeyListener这个接口；
         */
        new TestTank();

    }

}

