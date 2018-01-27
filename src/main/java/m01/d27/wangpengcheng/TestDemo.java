/**
 * Project Name:shopping
 * File Name:TestDemo.java
 * Package Name:com.frame
 * Date:2018年1月27日下午1:33:59
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.wangpengcheng;

import javax.swing.JFrame;

/**
 * 5。画板需要放在窗体中，所以要创建一个窗体，在窗体中引入画板的对象，将对象放在该窗体中----4<br/>
 * Description: <br/>
 * Date: 2018年1月27日 下午1:33:59 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class TestDemo extends JFrame {
    public TestDemo() {
        MyPanel myPanel = new MyPanel();
        this.addKeyListener(myPanel);// 里面的实参的类型是keyListener类型
        this.add(myPanel);
        Thread thread = new Thread(myPanel);
        thread.start();

        this.setBounds(200, 200, 1000, 1000);
        this.setTitle("坦克大战");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
    }
}
