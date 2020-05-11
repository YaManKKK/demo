package tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 *
 * @author xb41101
 * @version Id: BinaryTree, v 0.1 2020/5/10 8:43 下午 yaman Exp $
 */
public class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    public BinaryTree() {
        BinaryTreeNode<T> node = new BinaryTreeNode<>();
        this.root = node;
    }

    /**
     * 创建节点
     * @param node
     * @param data
     */
    public void createTree(BinaryTreeNode<T> node, T data) {
        if (root == null) {
            root = new BinaryTreeNode<T>();
        } else {
            if (Math.random() > 0.5) {
                if (node.leftChild == null) {
                    node.leftChild = new BinaryTreeNode<T>(data);
                } else {
                    createTree(node.leftChild, data);
                }
            } else {
                if (node.rightChild == null) {
                    node.rightChild = new BinaryTreeNode<T>(data);
                } else {
                    createTree(node.rightChild, data);
                }
            }
        }
    }

    /**
     * 获取当前节点数据
     * @param current
     */
    public void visit(BinaryTreeNode<T> current) {
        if (current != null && current.getData() != null) {
            System.out.println(current.getData());
        } else {
            System.out.println("null");
        }
    }

    /**
     * 前序遍历
     * @param root
     */
    public void preOrder(BinaryTreeNode<T> root) {
        visit(root);
        if (root != null) {
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(BinaryTreeNode<T> root) {
        if (root != null) {
            inOrder(root.leftChild);
        }
        visit(root);
        if (root != null) {
            inOrder(root.rightChild);
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(BinaryTreeNode<T> root) {
        if(root!=null) {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
        }
        visit(root);
    }

    /**
     * 广度优先遍历
     * 首节点-》左节点-》右节点
     * @param root
     */
    public void levelOrder(BinaryTreeNode<T> root) {
        Queue<BinaryTreeNode<T>> queue = new LinkedBlockingQueue<BinaryTreeNode<T>>();
        BinaryTreeNode<T> pointer = root;
        if (pointer != null) {
            queue.add(pointer);
        }

        while (!queue.isEmpty()) {
            pointer = queue.peek();
            visit(pointer);
            queue.remove();
            if (pointer.leftChild != null) {
                queue.add(pointer.leftChild);
            }
            if (pointer.rightChild != null) {
                queue.add(pointer.rightChild);
            }
        }
    }

    /**
     * Getter method for property <tt>root</tt>.
     *
     * @return property value of root
     */
    public BinaryTreeNode<T> getRoot() {
        return root;
    }
}
