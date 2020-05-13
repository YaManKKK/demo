package tree;

/**
 * 树节点
 *
 * @author xb41101
 * @version Id: BinaryTreeNode, v 0.1 2020/5/9 5:28 下午 yaman Exp $
 */
public class BinaryTreeNode<T> {

    public BinaryTreeNode() {
        this.data = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryTreeNode(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /** 数据 */
    private T                 data;

    /** 左节点 */
    private BinaryTreeNode<T> leftChild;

    /** 右节点 */
    private BinaryTreeNode<T> rightChild;

    /**
     * Getter method for property <tt>data</tt>.
     *
     * @return property value of data
     */
    public T getData() {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     *
     * @param data value to be assigned to property data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Getter method for property <tt>leftChild</tt>.
     *
     * @return property value of leftChild
     */
    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Setter method for property <tt>leftChild</tt>.
     *
     * @param leftChild value to be assigned to property leftChild
     */
    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Getter method for property <tt>rightChild</tt>.
     *
     * @return property value of rightChild
     */
    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    /**
     * Setter method for property <tt>rightChild</tt>.
     *
     * @param rightChild value to be assigned to property rightChild
     */
    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * 是否是叶子节点
     * @return
     */
    public boolean isLeaf() {
        if (this.leftChild == null && this.rightChild == null) {
            return true;
        }
        return false;
    }
}
