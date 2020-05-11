package tree;

/**
 *
 *
 * @author xb41101
 * @version Id: BinaryTreeTest, v 0.1 2020/5/11 12:42 上午 yaman Exp $
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        for (int i = 1; i < 10; i++) {
            tree.createTree(tree.getRoot(), i);
        }
        System.out.println("-----------下面是广度优先遍历二叉树--------------");
        tree.levelOrder(tree.getRoot());
        System.out.println("-----------下面是前序遍历方式-------------");
        tree.preOrder(tree.getRoot());
        System.out.println("-----------下面是中序遍历方式-------------");
        tree.inOrder(tree.getRoot());
        System.out.println("-----------下面是后序遍历方式-------------");
        tree.postOrder(tree.getRoot());
    }
}
