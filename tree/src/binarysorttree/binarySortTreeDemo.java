package binarysorttree;

/**
 * 类 描 述：bst的建立
 * 创建时间：2020-04-18 17:12
 * 创 建 人：t4ki
 */
public class binarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        binarySortTree tree = new binarySortTree();

        //创建二叉排序树
        for (int i = 0; i < arr.length; i++) {
            tree.add(new bstNode(arr[i]));
        }

        //遍历二叉排序树
        tree.inOrder(); //1, 3, 5, 7, 9, 10, 12


    }
}

class binarySortTree{
    private bstNode root;
    public void add(bstNode node){
        if(root == null){
            root = node;
        } else {
            root.add(node);
        }
    }

    public void inOrder(){
        if (root == null){
            System.out.println("二叉排序树为空");
        } else {
            root.inOrder();
        }
    }

    /*
     * @description: 查找节点
     * @param:  value: 根据值来查找
     * @return: 找到结点返回结点，没找到返回为空
    */
    public bstNode search(int value){
        if(root == null){
            System.out.println("当前bst为空");
            return null;
        } else {
            return root.search(value);
        }
    }

    /*
     * @description: bst的删除
     * 三种情况：
     *      1.删除叶子结点
     *      2.删除只有一颗子树的结点
     *      3.删除有两颗子树的节点
     * @param:
     * @return:
    */
    public void del(bstNode node){

    }
}

class bstNode{
    int value;
    bstNode left;
    bstNode right;

    /*
     * @description: 查找某个节点
     * @param: value:根据值查找
     * @return: null:没有找到 返回找到的节点
    */
    public bstNode search(int value){
        if(value == this.value){
            return this;
        } else if (value < this.value){
            if(this.left == null){
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    /*
     * @description:
     * @param:
     * @return: 返回所需要对象的父节点，没有就返回null
    */
    public bstNode searchParent(int value){
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)){
            return this;
        } else {
            //如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if (value < this.value && this.left != null){
                //向左子树递归查找
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null){
                //向右子树递归查找
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }


    /*
     * @description: 递归添加结点
     * @param: node 添加的节点
     * @return:
    */
    public void add(bstNode node){
        if (node == null){
            return;
        }

        //传入节点的值和当前子树的根节点的值的关系

        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        }

        if(node.value >= this.value){
            if(this.right == null){
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void inOrder(){
        if(this.left != null){
            this.left.inOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.inOrder();
        }
    }

    @Override
    public String toString() {
        return "bstNode{" +
                "value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public bstNode getLeft() {
        return left;
    }

    public void setLeft(bstNode left) {
        this.left = left;
    }

    public bstNode getRight() {
        return right;
    }

    public void setRight(bstNode right) {
        this.right = right;
    }

    public bstNode(int value) {
        this.value = value;
    }
}
