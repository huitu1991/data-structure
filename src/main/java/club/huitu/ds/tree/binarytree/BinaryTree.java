package club.huitu.ds.tree.binarytree;


/**
 * @author hiutu
 * Created by huitu on 2019/9/20.
 */
public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> insert(T data) {
        Node<T> node = doInsert(root, data);
        if(root == null) { root = node; }
        return node;
    }

    private Node<T> doInsert(Node<T> currentNode, T data) {
        if(currentNode == null) { return new Node<>(data, null, null); }
        int compare = compare(currentNode.getData(), data);
        if(compare == 0) { return currentNode; }
        if(compare > 0) {
            currentNode.setLeftChild(doInsert(currentNode.getLeftChild(), data));
        }
        else {
            currentNode.setRightChild(doInsert(currentNode.getRightChild(), data));
        }
        return currentNode;
    }


    public boolean contains(T data) {
        Node<T> node = doSearch(root, data);
        return node != null;
    }

    public Node<T> search(T data) {
        return doSearch(root, data);
    }

    private Node<T> doSearch(Node<T> currentNode, T data) {
        if(currentNode == null) { return null; }
        int compare = compare(currentNode.getData(), data);
        if(compare == 0) { return currentNode; }
        return doSearch(compare > 0 ? currentNode.getLeftChild() : currentNode.getRightChild(), data);
    }


    public Node<T> findMin() {
        return findMin(root);
    }

    public Node<T> findMax() {
        return findMax(root);
    }

    private Node<T> findMin(Node currentNode) {
        if(currentNode == null) { return null; }
        Node leftChild = currentNode.getLeftChild();
        return leftChild == null ? currentNode : findMin(leftChild);
    }

    private Node<T> findMax(Node currentNode) {
        if(currentNode == null) { return null; }
        Node rightChild = currentNode.getRightChild();
        return rightChild == null ? currentNode : findMax(rightChild);
    }


    public Node<T> remove(T data) {
        return remove(root, data);
    }

    private Node<T> remove(Node<T> currentNode, T data) {
        if(currentNode == null) { return null; }
        int compare = compare(currentNode.getData(), data);
        if(compare == 0) {
            Node<T> replaceNode = findMin(currentNode.getRightChild());
            if(replaceNode == null) {
                replaceNode = currentNode.getLeftChild();
            }
            else {
                remove(currentNode.getRightChild(), replaceNode.getData());
                replaceNode.setLeftChild(currentNode.getLeftChild());
            }
            return replaceNode;
        }
        else if(compare > 0) {
            currentNode.setLeftChild(remove(currentNode.getLeftChild(), data));
        }
        else {
            currentNode.setRightChild(remove(currentNode.getRightChild(), data));
        }
        return currentNode;
    }


    /**
     * 打印整棵树
     * @param sequence 遍历方式,-1:先序遍历/0:中序遍历/1:后序遍历
     */
    public void printAll(int sequence) {
        if(sequence != -1 && sequence != 0 && sequence != 1) {
            sequence = 0;
        }
        doPrint(root, sequence);
    }


    /**
     * 打印节点，由{@link BinaryTree#printAll } 调用
     * @param node 节点
     */
    private void doPrint(Node<T> node, int sequence) {
        if(node == null) { return; }
        if(sequence == -1) {
            printNodeData(node);
            doPrint(node.getLeftChild(), sequence);
            doPrint(node.getRightChild(), sequence);
        }
        else if(sequence == 0) {
            doPrint(node.getLeftChild(), sequence);
            printNodeData(node);
            doPrint(node.getRightChild(), sequence);
        }
        else if(sequence == 1) {
            doPrint(node.getLeftChild(), sequence);
            doPrint(node.getRightChild(), sequence);
            printNodeData(node);
        }
        else {
            throw new RuntimeException("sequence不支持");
        }
    }


    private int compare(T from, T to) {
        if(from == null && to == null) { return 0; }
        if(from == null && to != null) { return -1; }
        if(from != null && to == null) { return 1; }
        //都不为空
        return from.compareTo(to);
    }


    /**
     * 打印节点数据
     * @param node 节点
     */
    private void printNodeData(Node<T> node) {
        System.out.println(node.getData());
    }


}
