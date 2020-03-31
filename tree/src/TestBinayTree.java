/**
 * 项目名称：DBAl
 * 类 名 称：TestBinayTree
 * 类 描 述：TODO
 * 创建时间：2020-03-05 21:02
 * 创 建 人：t4ki
 */
public class TestBinayTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        tree.setRoot(root);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.setLnode(node1);
        root.setRnode(node2);
        node1.setLnode(node3);
        node1.setRnode(node4);
        node2.setLnode(node5);
        node3.setLnode(node6);

//        System.out.println("前序遍历：");
//        tree.preOrder();
        System.out.println("中序遍历");
        tree.inOrder2();
//        System.out.println("后序遍历");
//        tree.postOrder();

    }
}
