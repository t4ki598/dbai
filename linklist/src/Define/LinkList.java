package Define;

public class LinkList {
    ListNode head = null;

    public ListNode getHead() {
        return head;
    }

    /*
     * @description: 链表的显示
     * @param: []
     * @return: void
     * @date: 2020-02-17
    */
    public void show(){
        ListNode cur = head;
        if(head == null){
            System.out.println("该链表为空链表");
        }else {
            while (cur != null){
                System.out.print(cur.data + "->");
                cur = cur.next;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-----------------------");
    }

    /* 
     * @description:  获取链表长度
     * @param: []
     * @return: int 返回链表长度
     * @date: 2020-02-16 
    */
    public int getLength(){
        ListNode cur = head;
        int length = 0;
        while (cur != null){
            cur = cur.next;
            length++;
        }
        return length;
    }

    /*
     * @description: 根据给定的值找到它在链表中的位置
     * @param: [val] 要查找到值
     * @return: int 返回要查找的值在链表中的位置
     * @date: 2020-02-17
    */
    public int get(int val){
        ListNode cur = head;
        int length = getLength();
        if(cur == null || val > length - 1 || val < 0 ){
            return -1;
        }else {
            for (int i = 0; i < val ; i++) {
                cur = cur.next;
            }
            return cur.data;
        }
    }

    /*
     * @description: 头插法
     * @param: [val] 要插入链表元素的值
     * @return: Define.ListNode 返回链表头节点
     * @date: 2020-02-17
    */
    public ListNode addAtHead(int val){
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
            return head;
        }
        node.next = head;
        head = node;
        return head;
    }

    /*
     * @description: 在链表末尾添加元素
     * @param: [val] 要插入的链表元素的值
     * @return: Define.ListNode 插入后链表的头节点
     * @date: 2020-02-17
    */
    public ListNode addAtTail(int val) {
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
            return head;
        }
        ListNode tail = head;
        while (tail.next!= null){
            tail = tail.next;
        }
        tail.next = node;
        tail = node;
        return head;
    }

    /*
     * @description: 按照索引插入链表元素
     * @param: [index, val] 要插入的位置， 要插入的链表元素的值
     * @return: Define.ListNode
     * @date: 2020-02-17
    */
    public ListNode addAtIndex(int index, int val){
        ListNode tail = head;
        int length = 0;
        while (tail != null){
            tail = tail.next;
            length++;
        }
        if(index == length){
            addAtTail(val);
        }else if (index <= 0){
            addAtHead(val);
        }else if (index > length){
            return head;
        }else {
            ListNode cur = head;
            ListNode node = new ListNode(val);
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return head;
    }

    /*
     * @description: 按照索引删除链表元素
     * @param: [index] 要删除元素的位置索引
     * @return: Define.ListNode 删除后的链表头节点
     * @date: 2020-02-17
    */
    public ListNode deleteAtIndex(int index){
        ListNode node = head;
        ListNode pre = head;
        ListNode cur = pre.next;
        int length = 0;
        while (node != null){
            node = node.next;
            length++;
        }
        if (index == 0){
            head = head.next;
        }
        if (index < length && index > 0){
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            cur = pre.next;
            pre.next = cur.next;
            cur.next = null;
        }
        return head;
    }

    public boolean hasCycle(){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
