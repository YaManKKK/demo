package tree;

/**
 * 二叉搜索树
 *
 * @author xb41101
 * @version Id: BinarySearchTree, v 0.1 2020/5/12 9:06 下午 yaman Exp $
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree {

    /**
     * 插入节点
     * @param data
     */
    public void insert(T data) {
        BinaryTreeNode<T> node = new BinaryTreeNode<>();
        node.setData(data);
        if (getRoot() == null) {
            setRoot(node);
        } else {
            BinaryTreeNode<T> currentNode = getRoot();
            BinaryTreeNode<T> parent;
            while (true) {
                parent = currentNode;
                if (data.compareTo(currentNode.getData()) < 0) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parent.setLeftChild(node);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parent.setRightChild(node);
                        return;
                    }
                }
            }
        }
    }

    /**
     * 查找节点
     * @param data
     * @return
     */
    public BinaryTreeNode find(T data) {
        BinaryTreeNode<T> current = getRoot();
        while (current.getData() != data) {
            if (current.getData().compareTo(data) < 0) {
                current = current.getLeftChild();
            }

            if (current.getData().compareTo(data) > 0) {
                current = current.getRightChild();
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * 删除
     * 分三种情况
     * 1.叶子节点 直接删除
     * 2.存在单个子节点 赋值给自己的父节点
     * 3.存在左右两个子节点 需要将左节点赋值给自己右节点最小的左节点
     * @param data
     */
    public boolean delete(T data) {
        BinaryTreeNode<T> current = getRoot();
        BinaryTreeNode<T> parent = getRoot();
        boolean isLeft = false;
        boolean isRight = false;
        // 遍历查找值
        while (current != null && current.getData() != data) {
            parent = current;
            isLeft = false;
            isRight = false;
            if (data.compareTo(current.getData()) < 0) {
                current = current.getLeftChild();
                isLeft = true;
            } else {
                current = current.getRightChild();
                isRight = true;
            }
        }

        // 没有对应节点
        if (current == null) {
            return false;
        }

        // 叶子节点
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (isLeft) {
                parent.setLeftChild(null);
            } else if (isRight) {
                parent.setRightChild(null);
            }
            return true;
        } else if (current.getLeftChild() != null && current.getRightChild() == null) {
            if (isLeft) {
                parent.setLeftChild(current.getLeftChild());
            } else if (isRight) {
                parent.setRightChild(current.getLeftChild());
            }
            return true;
        } else if (current.getLeftChild() == null && current.getRightChild() != null) {
            if (isLeft) {
                parent.setLeftChild(current.getRightChild());
            } else if (isRight) {
                parent.setRightChild(current.getRightChild());
            }
            return true;
        } else {
            if (isLeft) {
                parent.setLeftChild(current.getRightChild());
                BinaryTreeNode currentNode = current.getRightChild();
                BinaryTreeNode parentNode = currentNode;
                while (parentNode.getLeftChild() != null) {
                    parentNode = parentNode.getLeftChild();
                }
                parentNode.setLeftChild(current.getLeftChild());
            } else if (isRight) {
                parent.setRightChild(current.getRightChild());
                BinaryTreeNode currentNode = current.getRightChild();
                BinaryTreeNode parentNode = currentNode;
                while (parentNode.getLeftChild() != null) {
                    parentNode = parentNode.getLeftChild();
                }
                parentNode.setLeftChild(current.getLeftChild());
            }
            return true;
        }
    }
}
