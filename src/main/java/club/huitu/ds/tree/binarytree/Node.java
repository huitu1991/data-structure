package club.huitu.ds.tree.binarytree;

/**
 * @author hiutu
 * Created by huitu on 2019/9/20.
 */
public class Node<T extends Comparable<T>> {

    private T data;

    private Node<T> leftChild;

    private Node<T> rightChild;

    public Node(T data, Node<T> leftChild, Node<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }


    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

}
