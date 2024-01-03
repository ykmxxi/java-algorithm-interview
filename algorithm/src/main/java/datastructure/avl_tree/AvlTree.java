package datastructure.avl_tree;

public class AvlTree<E> {

    Node<E> root;
    int currentSize;

    public AvlTree() {
        this.root = null;
        this.currentSize = 0;
    }

    public void add(E elem) {
        Node<E> node = new Node<>(elem);
        if (root == null) { // root node가 비어있다면 root로 설정
            root = node;
            currentSize++;
            return;
        }

        // root node가 존재한다면
        add(root, node);
    }

    private void add(Node<E> parent, Node<E> newNode) {
        // newNode의 값이 parent의 값보다 크면 트리의 오른쪽에 추가
        if (((Comparable<E>) newNode.data).compareTo(parent.data) > 0) {
            if (parent.right == null) { // 부모 노드의 오른쪽이 비어있으면
                parent.right = newNode;
                newNode.parent = parent;
                currentSize++;
            } else { // 부모 노드의 오른쪽이 존재하면
                add(parent.right, newNode); // 부모 노드의 오른쪽 노드와 새로운 노드 비교후 추가
            }
        } else { // newNode의 값이 parent의 값보다 작아 트리의 왼쪽에 추가
            if (parent.left == null) { // 부모 노드의 왼쪽이 비어있으면
                parent.left = newNode;
                newNode.parent = parent;
                currentSize++;
            } else { // 부모 노드의 왼쪽이 존재하면
                add(parent.left, newNode);
            }
        }

        // AVL 트리의 균형을 체크
        checkBalance(newNode);
    }

    /**
     * AVL 트리의 왼쪽과 오른쪽의 높이 차이는 1이하
     */
    private void checkBalance(Node<E> node) {
        if (height(node.left) - height(node.right) > 1 ||
                height(node.left) - height(node.right) < -1
        ) {
            rebalance(node);
        }

        // 부모 노드를 계속 확인해서 루트까지 체크
        if (node.parent == null) {
            return;
        }
        checkBalance(node.parent);
    }

    private void rebalance(Node<E> node) {
        // 왼쪽 서브 트리가 오른쪽 서브 트리보다 긴 경우
        if (height(node.left) - height(node.right) > 1) {
            // 노드의 왼쪽 자식의 왼쪽 서브 트리에서 문제 발생
            if (height(node.left.left) >= height(node.left.right)) {
                node = rightRotate(node); // 우측 회전
            } else { // 노드의 왼쪽 자식의 오른쪽 서브 트리에서 문제 발생
                node = leftRightRotate(node); // 좌측-우측 회전
            }
        } else if (height(node.right) - height(node.left) > 1) { // 오른쪽 서브 트리가 왼쪽 서브 트리보다 긴 경우
            if (height(node.right.right) >= height(node.right.left)) { // 오른쪽 서브 트리 > 왼쪽 서브 트리
                node = leftRotate(node); // 좌측 회전
            } else { // 오른쪽 서브 트리 < 왼쪽 서브 트리
                node = rightLeftRotate(node); // 우측-좌측 회전
            }
        }

        if (node.parent == null) {
            root = node;
        }
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    // root 노드를 기준으로 왼쪽 회전
    private Node<E> leftRotate(Node<E> root) {
        Node<E> temp = root.right;

        root.right = temp.left;
        if (temp.left != null) {
            temp.left.parent = root;
        }

        temp.left = root;
        temp.parent = root.parent;

        if (root.parent != null) {
            if (root.parent.left == root) {
                root.parent.left = temp;
            } else {
                root.parent.right = temp;
            }
        }

        root.parent = temp;

        return temp;
    }

    // root 노드를 기준으로 오른쪽 회전
    private Node<E> rightRotate(Node<E> root) {
        Node<E> temp = root.left;

        root.left = temp.right;
        if (temp.right != null) {
            temp.right.parent = root;
        }

        temp.right = root;
        temp.parent = root.parent;

        if (root.parent != null) {
            if (root.parent.left == root) {
                root.parent.left = temp;
            } else {
                root.parent.right = temp;
            }
        }

        root.parent = temp;

        return temp;
    }

    // root 노드를 기준으로 왼쪽-오른쪽 회전
    private Node<E> leftRightRotate(Node<E> root) {
        root.left = leftRotate(root.left);

        return rightRotate(root);
    }

    // root 노드를 기준으로 오른쪽-왼쪽 회전
    private Node<E> rightLeftRotate(Node<E> root) {
        root.right = rightRotate(root.right);

        return leftRotate(root);
    }

}

class Node<T> {

    T data; // 노드 안에 저장하려는 내용

    Node<T> left; // 왼쪽 자식 노드
    Node<T> right; // 오른쪽 자식 노드
    Node<T> parent; // 부모 노드

    public Node(T data) {
        this.data = data;
        parent = left = right = null;
    }

}
