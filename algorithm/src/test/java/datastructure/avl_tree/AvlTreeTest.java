package datastructure.avl_tree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AvlTreeTest {

    @Test
    void avl_tree_test() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        addData(avlTree);

        assertThat(avlTree.root.data).isEqualTo(22);
        assertThat(avlTree.currentSize).isEqualTo(12);
        assertThat(avlTree.root.left.data).isEqualTo(18);
        assertThat(avlTree.root.right.data).isEqualTo(50);
        assertThat(avlTree.root.left.right.left.data).isEqualTo(20);
        assertThat(avlTree.root.right.right.left.data).isEqualTo(51);
        assertThat(avlTree.root.left.left.left.data).isEqualTo(6);
        assertThat(avlTree.root.right.right.right.data).isEqualTo(63);
    }

    /*
             22
           /    \
          18     50
          /\     /\
         8  21  43 62
        /\  /      /\
       6  9 20    51 63

     */
    private void addData(final AvlTree<Integer> avlTree) {
        avlTree.add(43);
        avlTree.add(18);
        avlTree.add(22);
        avlTree.add(9);
        avlTree.add(21);
        avlTree.add(6);
        avlTree.add(8);
        avlTree.add(20);
        avlTree.add(63);
        avlTree.add(50);
        avlTree.add(62);
        avlTree.add(51);
    }

}
