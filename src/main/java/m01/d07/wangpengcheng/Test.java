/**
 * Project Name:ClassTest
 * File Name:Test.java
 * Package Name:com.function
 * Date:2018年1月9日上午10:50:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d07.wangpengcheng;

/**
 * Description: <br/>
 * Date: 2018年1月9日 上午10:50:11 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
class Buyer {
    private String name;

    private int num = 0;

    public Buyer(String name) {
        this.name = name;
        // Auto-generated constructor stub

    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}

class Box {
    private int number;

    public Box(int number) {

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}

class Ticket extends Thread {
    private Buyer buyer;

    private Box box;

    public Ticket(Buyer buyer, Box box) {
        this.buyer = buyer;
        this.box = box;

        // Auto-generated constructor stub

    }

    @Override
    public void run() {
        show();
    }

    public void show() {

        while (true) {
            synchronized (box) {
                if (box.getNumber() > 0) {
                    buyer.setNum(buyer.getNum() + 1);

                    System.out.println(buyer.getName() + "抢到的票数是:" + buyer.getNum());
                    box.setNumber(box.getNumber() - 1);
                }
                if (box.getNumber() == 0) {
                    break;
                }

            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Buyer buyer = new Buyer("汪鹏程");
        Buyer buyer1 = new Buyer("叶新童");
        Buyer buyer2 = new Buyer("黄磊");
        Box box = new Box(10);
        Ticket ticket = new Ticket(buyer, box);
        ticket.start();
        Ticket ticket1 = new Ticket(buyer1, box);
        ticket1.start();
        Ticket ticket2 = new Ticket(buyer2, box);
        ticket2.start();

    }

}
