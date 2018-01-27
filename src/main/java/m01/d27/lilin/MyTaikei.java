package m01.d27.lilin;

import java.util.Vector;

public class MyTaikei extends Taikei{
	private int direct;//����
	private int speed=6;//�ٶ�
	private Shot shot = null;
	private int i=0;
	private int j=10;
	Vector<Shot> vct = new Vector<Shot>();
	
	Vector<MyTaikei> v = new Vector<MyTaikei>();
	
	public Shot getShot() {
        return shot;
    }
    public void setShot(Shot shot) {
        this.shot = shot;
    }
    public Vector<Shot> getVct() {
        return vct;
    }
    public void setVct(Vector<Shot> vct) {
        this.vct = vct;
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
	public MyTaikei(){
		super();
	}
	public MyTaikei(int x,int y){
		super(x,y);
	}
	
	//�ӵ���������仯
	public void tkFire(){
	    if(i<10){
	    if(this.direct==0){//����
	        shot = new Shot(this.getX()+35,this.getY()-10, this.direct);
	        vct.add(shot);
	        i++;
	        j--;
	        System.out.println("ʣ���ӵ�����"+j);
	    }else if(this.direct==1){//����
	        shot = new Shot(this.getX()+60,this.getY()+35,this.direct);
	        vct.add(shot);
	        i++;
	        j--;
	        System.out.println("ʣ���ӵ�����"+j);
	    }else if(this.direct==2){//����
	        shot = new Shot(this.getX()+35,this.getY()+60,this.direct);
            vct.add(shot);
            i++;
            j--;
            System.out.println("ʣ���ӵ�����"+j);
        }else if(this.direct==3){//����
            shot = new Shot(this.getX()-10,this.getY()+35,this.direct);
            vct.add(shot);
            i++;
            j--;
            System.out.println("ʣ���ӵ�����"+j);
        }
	    System.out.println("�ӵ���ǰx="+shot.getX()+" y="+shot.getY());
	        Thread td = new Thread(shot);
	        td.start();//�����߳�
	    }
	}
}
