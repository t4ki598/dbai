/**
 * 项目名称：DBAl
 * 类 名 称：TreeNode
 * 类 描 述：TODO
 * 创建时间：2020-03-05 21:07
 * 创 建 人：t4ki
 */
public class TreeNode {
    private int value;
    private TreeNode lnode;
    private TreeNode rnode;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLnode() {
        return lnode;
    }

    public void setLnode(TreeNode lnode) {
        this.lnode = lnode;
    }

    public TreeNode getRnode() {
        return rnode;
    }

    public void setRnode(TreeNode rnode) {
        this.rnode = rnode;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.lnode != null){
            this.lnode.preOrder();
        }
        if (this.rnode != null){
            this.rnode.preOrder();
        }
    }

    //中序遍历
    public void inOrder(){
        if(this.lnode != null){
            this.lnode.inOrder();
        }
        System.out.println(this);
        if(this.rnode != null){
            this.rnode.inOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if(this.lnode != null){
            this.lnode.postOrder();
        }
        if(this.rnode != null){
            this.rnode.postOrder();
        }
        System.out.println(this);
    }
}
