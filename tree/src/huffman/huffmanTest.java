package huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类 描 述：数据压缩（创建和文本字符串对应的哈夫曼树）
 * 创建时间：2020-04-15 20:14
 * 创 建 人：t4ki
 */
public class huffmanTest {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        System.out.println(bytes.length);

        List<Node2> list = getNodes(bytes);
        //System.out.println(list);

        System.out.println("创建的哈夫曼树如下：");
        Node2 root = createHuffman(list);
        root.preOrder();

        //测试是否生成了对应的哈夫曼编码
        setHuffmanCodes(root);
        System.out.println("生成的哈夫曼编码表如下：" + huffmanCodes);

    }


    //接收字节数组，返回list
    private static List<Node2> getNodes(byte[] bytes){
        ArrayList<Node2> list = new ArrayList<>();
        HashMap<Byte, Integer> map = new HashMap<>();
        for(byte b : bytes){
            Integer count = map.get(b);
            if(count == null){
                map.put(b, 1);
            } else {
                map.put(b, count + 1);
            }
        }

        //把每个键值对转化成node对象并且加入到list中
        for(Map.Entry<Byte, Integer> entry : map.entrySet()){
            list.add(new Node2(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    //创建哈夫曼树
    private static Node2 createHuffman(List<Node2> list){
        while (list.size() > 1){
            Collections.sort(list);
            Node2 leftNode = list.get(0);
            Node2 rightNode = list.get(1);

            //创建一个新的二叉树，他的节点没有data只有权值
            Node2 parent = new Node2(null, (leftNode.weight + rightNode.weight));
            parent.left = leftNode;
            parent.right = rightNode;

            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parent);
        }
        return list.get(0);
    }

    //前序遍历
    private static void preOrder(Node2 root){
        System.out.println(root);
        if(root.left != null){
            root.left.preOrder();
        }
        if(root.right != null){
            root.right.preOrder();
        }
    }

    //生成huffman树对应的编码表
    //1.将哈夫曼编码表存放在map中比较合适<byte, string>
    //2在生成哈夫曼编码表，需要拼接路径，定义一个stringBuilder,存储某个节点的路径
    static StringBuilder stringBuilder = new StringBuilder();
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();

    /*
     * @description:将传入的节点的所有叶子节点的转成哈夫曼编码，并放入huffmanCodes集合中
     * @param: root 传入的结点
     * @param: code 路径 左边是0 右边是1
     * @param: stringBuild 用于拼接路径
     * @return:
     * @date: 2020-04-16
    */
    private static void setHuffmanCodes(Node2 node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if(code != null){ //node==null 不处理
            //判断当前node是叶子结点还是非叶子结点
            if(node.data == null){//非叶子节点：递归处理
                //向左递归
                setHuffmanCodes(node.left, "0", stringBuilder2);
                //向右递归
                setHuffmanCodes(node.right, "1", stringBuilder2);
            } else { //叶子结点
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    /*
     * @description: 将传入的哈夫曼树的根节点装成huffman编码表（便于调用）
     * @param: root 根节点
     * @return: huffmanCodes:生成的哈夫曼编码表
    */
    private static Map<Byte, String> setHuffmanCodes(Node2 root){
        if (root == null){
            return null;
        }
        //处理root的左子树
        setHuffmanCodes(root.left, "0", stringBuilder);
        setHuffmanCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }


}

class Node2 implements Comparable<Node2> {
    Byte data;
    int weight;
    Node2 left;
    Node2 right;

    public Node2(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node2 o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}
