package huffman;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 类 描 述：哈夫曼树的创建
 * 创建时间：2020-04-15 17:05
 * 创 建 人：t4ki
 */
public class huffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);

        proOrder(root);

    }

    public static void proOrder(Node root){
        if(root != null){
            root.proOrder();
        }else {
            System.out.println("该树是颗空树.");
        }
    }

    //构建哈夫曼树
    public static Node createHuffmanTree(int[] arr){
        //将n个节点作为n颗仅含有一个根节点的二叉树，构成森林f
        ArrayList<Node> list = new ArrayList<>();
        for(int value : arr){
            list.add(new Node(value));
        }

        //直到f只有一棵树
        while (list.size() > 1){
            //从小到大排序
            Collections.sort(list);
            //System.out.println("nodes = " + list);

            //取根节点权值最小的两颗二叉树
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);

            //生成一个节点，将权值最小的两颗树作为他的左右子树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //从森林中删除这两颗树
            list.remove(leftNode);
            list.remove(rightNode);

            //并将新生成的树加入到森林中中
            list.add(parent);
        }

        //返回根节点
        return list.get(0);
    }
}

//节点类
//为了让node对象持续排序，使用collections集合排序，让node实现comparable接口
class Node implements Comparable< Node >{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大进行排序
        return this.value - o.value;
    }

    //前序遍历
    public void proOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.proOrder();
        }
        if(this.right != null){
            this.right.proOrder();
        }

    }
}
