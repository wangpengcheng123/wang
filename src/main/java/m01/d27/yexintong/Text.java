/**
 * Project Name:dt59.java
 * File Name:Text.java
 * Package Name:c1.d27
 * Date:2018-1-27����2:18:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.yexintong;

import javax.swing.JFrame;

/**
 * Description:   <br/>
 * Date:     2018-1-27 ����2:18:56 <br/>
 * @author   LangWang
 * @version
 * @see
 */
public class Text extends JFrame{
    public static void main(String[] args) {
        Text tt=new Text();
    }
    public Text(){
        TankeJpanl tj=new TankeJpanl();
        this.addKeyListener(tj);
        Thread td=new Thread(tj);
        td.start();
        this.add(tj);
        this.setTitle("̹�˴�ս");
        this.setBounds(100, 100, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

