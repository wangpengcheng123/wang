package m01.d27.lilin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;
/**
 * ���������� ���̳�jdk�ṩ��ĳ���� ��ʵ��ĳ���ӿ�  ��Ҫ�ø����ӿڸ�����Ա�����ķ���
 * ʵ��KeyListener�ӿ�
 * 
 * �ѵ�ǰ�Ļ��嵱��һ���߳���?
 * */
public class MyPanel extends JPanel implements KeyListener,Runnable{
	MyTaikei mt=null;//���� ���ڴ���ռλ�ã�����û�������飨�������ռ䣩
	
	Tanke2 mt1=null;
	
	Tanke3 mt2 = null;
	public MyPanel(){
		mt=new MyTaikei(40,50);//������λ��
		
		mt1= new Tanke2(700,700);//̹��2
		
		mt2 = new Tanke3(400,400);//̹��3
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 800);
		//���ĸ�����
		drawtaikei(mt.getX(),mt.getY(),0,mt.getDirect(),g);
		
		drawtaikei(mt1.getX(),mt1.getY(),1,mt1.getDirect(),g);//̹��2
		
		drawtaikei(mt2.getX(),mt2.getY(),1,mt2.getDirect(),g);// ̹��3
		//��λ���̹���ӵ�?���ݼ��ϵĴ�С���л���
		for(int i=0;i<mt.vct.size();i++){
		    Shot st = mt.vct.get(i);
		    
		    if(st.isLive()==true&&mt.vct!=null){//����ӵ�����
		        g.fill3DRect(st.getX(), st.getY(), 3, 3, false);//�����ӵ�
		        
		        if((mt1.getX()-st.getX())<20&&(mt1.getX()-st.getX())>-80&&(mt1.getY()-st.getY())<20&&(mt1.getY()-st.getY())>-60){ 
		            mt1.setX(2000);
		            mt1.setY(2000);
		            mt.vct.remove(st);
		            System.out.println("�ɹ���������"+st.getX()+","+st.getY()+"�ĵ���̹��");
		        }
		        
		        if((mt2.getX()-st.getX())<20&&(mt2.getX()-st.getX())>-80&&(mt2.getY()-st.getY())<20&&(mt2.getY()-st.getY())>-60){ 
                    mt2.setX(2000);
                    mt2.setY(2000);
                    mt.vct.remove(st);
                    System.out.println("�ɹ���������"+st.getX()+","+st.getY()+"�ĵ���̹��");
                }
		        
		        
		    }
		    if(st.isLive()==false){//����ӵ�����
		        mt.vct.remove(st);//�Ƴ��ӵ�
		    }
		}
	}
	/**
	 * @param x,y:���� direct:����0��1��2��3�� g:���� type:����
	 * @see ���Ʋ�ͬ�����̹�� ��װ����
	 * 1:�Ȼ�һ�����Ϸ����̹��
	 * */
	public void drawtaikei(int x,int y,int type,int direct,Graphics g){
		switch(type){
			case 0://����
				g.setColor(Color.cyan);
				break;
			case 1://�з�
				g.setColor(Color.yellow);
				break;
		}
		switch(direct){
			case 0://����
				//��ߵľ���
				//g.fillRect(x, y, 20, 50);
				g.fill3DRect(x, y, 20, 50, false);
				//�м�ľ���
				g.fill3DRect(x+20, y+10, 30, 30, false);
				//�ұߵľ���
				g.fill3DRect(x+50, y, 20, 50, false);
				//�м����̨
				g.fillOval(x+25, y+15, 20, 20);
				//�м����
				g.drawLine(x+35, y+15, x+35, y-10);
				break;
			case 1://����
				//�ϱߵľ���
				g.fill3DRect(x, y, 50, 20, false);
				//�м�ľ���
				g.fill3DRect(x+10, y+20, 30, 30, false);
				//�ұߵľ���
				g.fill3DRect(x, y+50, 50, 20, false);
				//�м����̨
				g.fillOval(x+15, y+25, 20, 20);
				//�м����
				g.drawLine(x+35, y+35, x+60, y+35);
				break;
			case 2://����
				//��ߵľ���
				//g.fillRect(x, y, 20, 50);
				g.fill3DRect(x, y, 20, 50, false);
				//�м�ľ���
				g.fill3DRect(x+20, y+10, 30, 30, false);
				//�ұߵľ���
				g.fill3DRect(x+50, y, 20, 50, false);
				//�м����̨
				g.fillOval(x+25, y+15, 20, 20);
				//�м����
				g.drawLine(x+35, y+35, x+35, y+60);
				break;
			case 3://����
				//�ϱߵľ���
				g.fill3DRect(x, y, 50, 20, false);
				//�м�ľ���
				g.fill3DRect(x+10, y+20, 30, 30, false);
				//�ұߵľ���
				g.fill3DRect(x, y+50, 50, 20, false);
				//�м����̨
				g.fillOval(x+15, y+25, 20, 20);
				//�м����
				g.drawLine(x+15, y+35, x-10, y+35);
				break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//��ͷ
		if(e.getKeyCode()==KeyEvent.VK_UP){
			//����
			mt.setDirect(0);
			//�ƶ�
			moveup();
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			//����
			mt.setDirect(1);
			moveright();
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			//����
			mt.setDirect(2);
			movedown();
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			//����
			mt.setDirect(3);
			moveleft();
		}else if(e.getKeyCode()==KeyEvent.VK_J){//����
		    mt.tkFire();
		}
		//�ػ�
		this.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @see:�����ƶ�
	 * ���ɣ�y�ı�  ����
	 * */
	public void moveup(){
		
		int speed= mt.getSpeed();//�Ȼ�ȡ�ٶ�
		int y=mt.getY()-speed;//����
		if(y<0){
			y=0;
		}
		mt.setY(y);
		System.out.println("��ǰy="+y);
	}
	//����
	public void moveright(){
		
		int speed= mt.getSpeed();//�Ȼ�ȡ�ٶ�
		int x=mt.getX()+speed;//����
		if(x>950){
		    x=950;
		}
		mt.setX(x);
		System.out.println("��ǰx="+x);
	}
	//����
	public void moveleft(){
		
		int speed= mt.getSpeed();//�Ȼ�ȡ�ٶ�
		int x=mt.getX()-speed;//����
		if(x<0){
		    x=0;
		}
		mt.setX(x);
		System.out.println("��ǰx="+x);
	}
	public void movedown(){
		
		int speed= mt.getSpeed();//�Ȼ�ȡ�ٶ�
		int y=mt.getY()+speed;//����
		if(y>750){
			y=750;
		}
		mt.setY(y);
		System.out.println("��ǰy="+y);
	}
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
                this.repaint();//�ػ�
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        
        
    }
	
}
