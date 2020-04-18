package binarytree;

/**
 * 类 描 述：TODO
 * 创建时间：2020-04-16 09:51
 * 创 建 人：t4ki
 */
public class binaryTreeDemo {
    public static void main(String[] args) {
        binaryTree tree = new binaryTree();

        treeNode root = new treeNode(1, "t4ki");
        treeNode node1 = new treeNode(2, "a");
        treeNode node2 = new treeNode(3, "b");
        treeNode node3 = new treeNode(4, "c");
        treeNode node4 = new treeNode(5, "d");

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        tree.setRoot(root);


        //tree.postOrder();

        //删除节点
        tree.preOrder();
        tree.delNode(4);
        tree.preOrder();



    }
}

//定义一颗二叉树
class binaryTree{
    private treeNode root;

    public void setRoot(treeNode root) {
        this.root = root;
    }

    public void preOrder(){
        if (this.root != null){
            this.root.rec_preOrder();
        }else {
            System.out.println("当前二叉树为空");
        }
    }

    public void inOrder(){
        if (this.root != null){
            this.root.rec_inOrder();
        }else {
            System.out.println("当前二叉树为空");
        }
    }

    public void postOrder(){
        if (this.root != null){
            this.root.rec_postOrder();
        }else {
            System.out.println("当前二叉树为空");
        }
    }

    //删除节点
    public void delNode(int id){
        if (root != null){
            if(root.getId() == id){
                root = null;
            } else {
                root.delNode(id);
            }
        } else {
            System.out.println("该树为一颗空树");
        }
    }
}


//定义树节点
class treeNode{
    private int id;
    private String name;
    private treeNode left;
    private treeNode right;

    public treeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "treeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public treeNode getLeft() {
        return left;
    }

    public void setLeft(treeNode left) {
        this.left = left;
    }

    public treeNode getRight() {
        return right;
    }

    public void setRight(treeNode right) {
        this.right = right;
    }

    public void rec_preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.rec_preOrder();
        }
        if(this.right != null){
            this.right.rec_preOrder();
        }
    }

    public void rec_inOrder(){
        if(this.left != null){
            this.left.rec_preOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.rec_preOrder();
        }
    }

    public void rec_postOrder(){
        if(this.left != null){
            this.left.rec_preOrder();
        }
        if(this.right != null){
            this.right.rec_preOrder();
        }
        System.out.println(this);
    }

    /*
     * @description: 递归删除节点，如果节点是叶子节点直接删除，是非叶子结点删除该子树
     * @param:  id 要删除的节点
     * @return:
    */
    public void delNode(int id){
        if(this.left != null && this.left.id == id){
            this.left = null;
            return;
        }

        if(this.right != null && this.right.id == id){
            this.right = null;
            return;
        }

        if(this.left != null){
            this.left.delNode(id);
            return;
        }

        if(this.right != null){
            this.right.delNode(id);
        }
    }
}
