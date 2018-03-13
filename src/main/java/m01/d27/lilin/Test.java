package m01.d27.lilin;

import javax.swing.JFrame;

public class Test extends JFrame{

	/**
	 * ̹��
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test tt=new Test();
	}
	public Test(){
		MyPanel mp=new MyPanel();//����������ʼ����mp
		this.addKeyListener(mp);
		
		Thread th = new Thread(mp);
		th.start();
		
		this.add(mp);
		this.setTitle("̹��");
		this.setBounds(200, 200, 1000, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
