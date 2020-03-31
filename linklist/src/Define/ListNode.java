package Define;

public class ListNode {
    int data;

    //下一个节点,这里为啥要定义成Node类型？
    // next 存贮的是下一个节点的对象地址，找到了对象地址，则就找到了下一个data的数据
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode() {
    }






}
