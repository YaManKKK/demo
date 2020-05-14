package tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树
 *
 * @author xb41101
 * @version Id: BinaryTree, v 0.1 2020/5/10 8:43 下午 yaman Exp $
 */
public class BinaryTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;

    /**
     * 创建节点
     * @param node
     * @param data
     */
    public void createTree(BinaryTreeNode<T> node, T data) {
        if (root == null) {
            root = new BinaryTreeNode<>();
            root.setData(data);
        } else {
            if (Math.random() > 0.5) {
                if (node.getLeftChild() == null) {
                    node.setLeftChild(new BinaryTreeNode<T>(data));
                } else {
                    createTree(node.getLeftChild(), data);
                }
            } else {
                if (node.getRightChild() == null) {
                    node.setRightChild(new BinaryTreeNode<T>(data));
                } else {
                    createTree(node.getRightChild(), data);
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
        if (root == null) {
            return;
        }
        visit(root);
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    /**
     * 前序遍历 非递归 根-》左-》右
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
                if (pointer.getRightChild() != null) {
                    stack.add(pointer.getRightChild());
                }
                // 左节点作为根节点
                pointer = pointer.getLeftChild();
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
     * @param root
     */
    public void inOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeftChild());
        visit(root);
        inOrder(root.getRightChild());
    }

    /**
     * 中序遍历 非递归 左-》根-》右
     * @param root
     */
    public void inOrder2(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> pointer = root;
        while (!stack.isEmpty() || pointer != null) {
            if (pointer != null) {
                stack.add(pointer);
                pointer = pointer.getLeftChild();
            } else {
                pointer = stack.peek();
                visit(pointer);
                pointer = pointer.getRightChild();
                stack.pop();
            }
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        visit(root);
    }

    /**
     * 后序遍历 非递归 左-》右-》根
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
                stack.add(root.getLeftChild());
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
            if (pointer.getLeftChild() != null) {
                queue.add(pointer.getLeftChild());
            }
            if (pointer.getRightChild() != null) {
                queue.add(pointer.getRightChild());
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

    /**
     * Setter method for property <tt>root</tt>.
     *
     * @param root value to be assigned to property root
     */
    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }
}
