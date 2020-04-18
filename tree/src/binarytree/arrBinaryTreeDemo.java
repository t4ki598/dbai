package binarytree;

/**
 * 类 描 述：TODO
 * 创建时间：2020-04-16 19:30
 * 创 建 人：t4ki
 */
public class arrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        arrBinaryTree tree = new arrBinaryTree(arr);
        tree.preOrder(0);
        System.out.println();

        tree.inOrder(0);
        System.out.println();

        tree.postOrder(0);


    }
}

class arrBinaryTree{
    private int[] arr;

    public arrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //编写一个方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树前序遍历");
        }

        //输出当前元素
        System.out.print(arr[index] + " ");

        //向左递归
        if(index * 2 + 1 < arr.length){
            preOrder(2 * index + 1);
        }

        //向右递归
        if(index * 2 + 1 < arr.length){
            preOrder(2 * index + 2);
        }
    }

    //编写一个方法，完成顺序存储二叉树的中序遍历
    public void inOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树中序遍历");
        }

        //向左递归
        if(index * 2 + 1 < arr.length){
            preOrder(2 * index + 1);
        }

        //输出当前元素
        System.out.print(arr[index] + " ");

        //向右递归
        if(index * 2 + 1 < arr.length){
            preOrder(2 * index + 2);
        }
    }

    //编写一个方法，完成顺序存储二叉树的后序遍历
    public void postOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树后序遍历");
        }

        //向左递归
        if(index * 2 + 1 < arr.length){
            preOrder(2 * index + 1);
        }

        //向右递归
        if(index * 2 + 1 < arr.length){
            preOrder(2 * index + 2);
        }

        //输出当前元素
        System.out.print(arr[index] + " ");
    }

}