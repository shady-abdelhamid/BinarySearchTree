/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

/**
 *
 * @author AbdElHamidS2
 */
public class BST {

    private Node root;

    void insert(int key, String value) {

        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
        } else {

            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.leftChild;
                    if (current == null) { // It's parent the leaf node
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) { // It's parent the leaf node
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findMin() {
        Node current = root;
        Node previous = null;

        while (current != null) {
            previous = current;
            current = current.leftChild;
        }
        return previous;
    }

    public Node findMax() {
        Node current = root;
        Node previous = null;

        while (current != null) {
            previous = current;
            current = current.rightChild;
        }
        return previous;
    }

    public boolean remove(int key) {
        Node current = root;
        Node parent = root;

        boolean isLeftChild = false;

        // search for an item
        while (current.key != key) {
            parent = current;
            if (key < current.key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }

        }

        // if node is a leaf
        Node nodeToDelete = current;
        if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
            if (nodeToDelete == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } // if node has one child that is on the left
        else if (nodeToDelete.rightChild == null) {
            if (nodeToDelete == root) {
                root = nodeToDelete.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = nodeToDelete.leftChild;
            } else {
                parent.rightChild = nodeToDelete.leftChild;
            }
        } // if node has one child that is on the right
        else if (nodeToDelete.leftChild == null) {
            if (nodeToDelete == root) {
                root = nodeToDelete.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = nodeToDelete.rightChild;
            } else {
                parent.rightChild = nodeToDelete.rightChild;
            }
        } // if node has two children (tricky)
        else {
            Node successor = getSuccessor(nodeToDelete);

            // connect parent nodeToDelete to successor instead
            if (nodeToDelete == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }

            successor.leftChild = nodeToDelete.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node nodeToDelete) {
        Node successorParent = nodeToDelete;
        Node successor = nodeToDelete;

        Node current = nodeToDelete.rightChild;  // go to the right child

        while (current != null) { // start going down the tree untill the node hase no left child
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        // if the successor is not the right child
        if (successor != nodeToDelete.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = nodeToDelete.rightChild;
        }

        return successor;
    }

}
