package Test;

import Define.LinkList;



public class CreateTest {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        //list.show();



        //-------AtHeat-------

        list.addAtHead(4);
        list.addAtHead(1);
        list.addAtHead(6);
//        list.addAtHead(3);
//        list.addAtHead(8);
//        list.show();



//        //获取第i个链表元素的值
//        System.out.println("获取第i个链表元素的值Test:");
//        System.out.print(" 请输入想要查询第几个链表元素：");
//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        System.out.println("第" + a + "个链表元素的值为：" + list.get(a));


        //-------AtTail-------

        list.addAtTail(7);
        list.show();



        //-------get-------

        int val = list.get(3);
        System.out.println("返回的值为：" + val);

        //System.out.println("");
        //System.out.println("-----------------------");


        //-------addAtIndex-------

        //list.addAtIndex(2, 2);
        //list.addAtIndex(0, 2);
        //list.addAtIndex(-1, 2);
        //list.addAtIndex(4, 2);
        //list.show();


        //-------delete-------

        //list.deleteAtIndex(-1);
        //list.deleteAtIndex(0);
        //list.deleteAtIndex(2);
        //list.show();


    }
}
