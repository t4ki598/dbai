package binarytree;

/**
 * 类 描 述：线索化二叉树的实现
 * 创建时间：2020-04-17 11:16
 * 创 建 人：t4ki
 */
public class threadedBinaryTreeDemo {
    public static void main(String[] args) {

        threadNode root = new threadNode(1);
        threadNode node1 = new threadNode(3);
        threadNode node2 = new threadNode(6);
        threadNode node3 = new threadNode(8);
        threadNode node4 = new threadNode(10);
        threadNode node5 = new threadNode(14);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);

        //测试中序线索遍历二叉树
        threadedBinaryTree tree = new threadedBinaryTree();
        tree.setRoot(root);
        tree.thrededNodes();

        //node4测试
        System.out.println("10结点的前驱节点为：" + node4.getLeft()); //3
        System.out.println("10结点的后继节点为：" + node4.getRight()); //1

        //线索化二叉树的遍历测试
        System.out.println("线索化二叉树的遍历如下：");
        tree.threadedList(); //8 3 10 1 14 6
    }
}

class threadedBinaryTree{
    private threadNode root;

    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化的时候， pre总是要保留前一个节点
    private threadNode pre = null;

    public void setRoot(threadNode root) {
        this.root = root;
    }

    /*
     * @description: 重载线索化二叉树的方法
     * @param:
     * @return:
    */
    public void thrededNodes(){
        this.threadedNodes(root);
    }

    /*
     * @description:  实现对二叉树中序线索化的方法
     * @param: [node] 当前需要线索化的节点
     * @return: void
    */
    public void threadedNodes(threadNode node){
        //如果node == null, 不能线索话
        if (node == null){
            return;
        }

        //先线索化左子树
        threadedNodes(node.getLeft());

        //再线索化当前节点：
        //1.先处理当前结点的前驱节点，如果为空，让当前结点的左指针指向前驱节点，然后修改当前节点的左指针类型。
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }

        //2.先处理当前结点的后继节点,让前驱节点的右指针指向当前节点，修改前驱节点的右指针
        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        //每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        //再线索化右子树
        threadedNodes(node.getRight());
    }

    /*
     * @description: 线索化二叉树的遍历
     * 对于遍历线索化二叉树，因为线索化后各个结点的指向有变化，
     * 所以不能使用原来的递归遍历的方法。
     * 这时候可以通过线性方式遍历，遍历的次序应当和中序遍历保持一致
     * @param:
     * @return:
    */
    public void threadedList(){
        //定义变量，存储当前遍历的节点，从root开始
        threadNode node = root;
        while (node != null){
            //循环的找到leftType == 1 的结点，第一个找到的应该是8结点
            //后面随着遍历而变化，因为当leftType==1的时候，说明该节点是按照线索化处理后的有效节点
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }

            //打印当前节点
            System.out.println(node);

            //如果当前节点的右指针指向的是后继结点就一直输出
            while (node.getRightType() == 1){
                //获取到当前节点的后继结点
                node = node.getRight();
                System.out.println(node);
            }

            //替换这个遍历的结点
            node = node.getRight();
        }
    }
}

class threadNode{
    private int value;
    private threadNode left;
    private threadNode right;
    //如果leftType = 0 说明指向的是左子树，如果 = 1 表示指向前驱节点。rightType同理
    private int leftType;
    private int rightType;

    public threadNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "threadNode{" +
                "value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public threadNode getLeft() {
        return left;
    }

    public void setLeft(threadNode left) {
        this.left = left;
    }

    public threadNode getRight() {
        return right;
    }

    public void setRight(threadNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
}
