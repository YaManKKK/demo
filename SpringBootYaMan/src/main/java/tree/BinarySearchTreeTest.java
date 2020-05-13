package tree;

/**
 *
 *
 * @author xb41101
 * @version Id: BinarySearchTreeTest, v 0.1 2020/5/12 9:40 下午 yaman Exp $
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();
        searchTree.insert(10);
        searchTree.insert(2);
        searchTree.insert(8);
        searchTree.insert(1);
        searchTree.insert(34);
        searchTree.insert(178);
        searchTree.insert(99);
        searchTree.insert(22);

        System.out.println("===========前序============");
        searchTree.preOrder(searchTree.getRoot());
        System.out.println("===========中序============");
        searchTree.inOrder(searchTree.getRoot());
        System.out.println("===========后序============");
        searchTree.postOrder(searchTree.getRoot());

        TreePrintUtil.show(searchTree.getRoot());
    }
}
