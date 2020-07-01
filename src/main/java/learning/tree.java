package main.java.learning;

import java.util.Scanner;

public class tree {

    public static void main(String[] args) {
        tree tempTree = new tree();//实例化本类
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            Node rootNode = null; //根节点
            for (int i = 0; i < num; i++) {
                Integer name = sc.nextInt(); //String.valueOf(sc.nextInt());
                if(i == 0){//实例化树的根节点
                    rootNode = tempTree.new Node(name);
                }else{//添加至树
                    rootNode.addNode(tempTree.new Node(name));
                }
            }
            if(rootNode != null){
//                System.out.println(rootNode.name);
                rootNode.preOrder(rootNode);
                System.out.printf("\n");
                rootNode.inOrder(rootNode);
                System.out.printf("\n");
                rootNode.postOrder(rootNode);
                System.out.printf("\n");
            }
        }

    }

    class Node{
        private Integer name;//不能用string，不然插入节点是反的
        private Node left;
        private Node right;

        public Node (Integer name){
            this.name = name;
        }

    /**
     * 为子树添加节点
     * @param newNode
     */
     void addNode(Node newNode){
            if(newNode.name.compareTo(this.name) < 0){//左子树
                if(this.left == null){
                    this.left = newNode;
                }else{
                    this.left.addNode(newNode);
                }
            }else if (newNode.name.compareTo(this.name) > 0){//右子树
                if(this.right == null){
                    this.right = newNode;
                }else{
                    this.right.addNode(newNode);
                }
            }
     }

    /**
     * 先序遍历输出
     * @param node
     */
    void preOrder(Node node){
         if(node == null)
             return;
         System.out.printf("%s" + " ", node.name);
         node.preOrder(node.left);
         node.preOrder(node.right);
    }

    /**
     * 中序遍历输出
     * @param node
     */
     void inOrder(Node node){
         if(node == null)
             return;
         node.inOrder(node.left);
         System.out.printf("%s" + " ", node.name);
         node.inOrder(node.right);
     }

    /**
     * 后续遍历输出
     * @param node
     */
     void postOrder(Node node){
         if(node == null)
             return;
         node.postOrder(node.left);
         node.postOrder(node.right);
         System.out.printf("%s" + " ", node.name);
     }
    }
}
