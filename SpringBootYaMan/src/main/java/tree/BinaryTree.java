package tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 *
 * @author xb41101
 * @version Id: BinaryTree, v 0.1 2020/5/10 8:43 下午 yaman Exp $
 */
public class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    /**
     * 创建节点
     *
     * @param node
     * @param data
     */
    public void createTree(BinaryTreeNode<T> node, T data) {
        if (root == null) {
            root = new BinaryTreeNode<T>();
            root.setData(data);
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
     *
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
     *
     * @param root
     */
    public void preOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        visit(root);
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    /**
     * 前序遍历 非递归 根-》左-》右
     *
     * @param root
     */
    public void preOrder2(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> pointer = root;
        while (!stack.isEmpty() || pointer != null) {
            // 当前节点不为空
            if (pointer != null) {
                // 输出根节点
                visit(pointer);
                // 先保存右节点
                if (pointer.rightChild != null) {
                    stack.add(pointer.rightChild);
                }
                // 左节点作为根节点
                pointer = pointer.leftChild;
            } else {
                // 获取之前保存的右节点
                pointer = stack.peek();
                // 删除保存的右节点
                stack.pop();
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftChild);
        visit(root);
        inOrder(root.rightChild);
    }

    /**
     * 中序遍历 非递归 左-》根-》右
     *
     * @param root
     */
    public void inOrder2(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> pointer = root;
        while (!stack.isEmpty() || pointer != null) {
            if (pointer != null) {
                stack.add(pointer);
                pointer = pointer.leftChild;
            } else {
                pointer = stack.peek();
                visit(pointer);
                pointer = pointer.rightChild;
                stack.pop();
            }
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        visit(root);
    }

    /**
     * 后序遍历 非递归 左-》右-》根
     *
     * @param root
     */
    public void postOrder2(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        Stack<BinaryTreeNode<T>> subStack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            subStack.add(root);
            if (root.getLeftChild() != null) {
                stack.push(root.getLeftChild());
            }
            if (root.getRightChild() != null) {
                stack.add(root.getRightChild());
            }
        }
        while (!subStack.isEmpty()) {
            visit(subStack.pop());
        }
    }

    /**
     * 广度优先遍历
     * 首节点-》左节点-》右节点
     *
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
