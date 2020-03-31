import java.util.Stack;

/**
 * 项目名称：DBAl
 * 类 名 称：BinaryTree
 * 类 描 述：TODO
 * 创建时间：2020-03-05 21:01
 * 创 建 人：t4ki
 */
public class BinaryTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    //根的前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("根节点为空");
        }
    }

    //根的中序遍历
    public void inOrder(){
        if (this.root != null){
            this.root.inOrder();
        }else {
            System.out.println("根节点为空");
        }
    }

    //根的后序遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("根节点为空");
        }
    }

    public void inOrder2(){
        Stack<TreeNode> s= new Stack<>();
        TreeNode node = root;
        while (!s.isEmpty() || node != null){
            if (node != null){
                s.push(node);
                node = node.getLnode();
            }

            node = s.pop();
            System.out.println(node.toString());
            if(node.getRnode()!=null){
                node = node.getRnode();
            }else {
                node = null;
            }
        }

    }

}
