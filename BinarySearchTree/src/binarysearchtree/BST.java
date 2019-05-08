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
    
    public Node findMin () {
        Node current = root;
        Node previous = null;
        
        while(current != null) {
            previous = current;
            current = current.leftChild;
        }
        return previous;
    }
    
    public Node findMax () {
        Node current = root;
        Node previous = null;
        
        while(current != null) {
            previous = current;
            current = current.rightChild;
        }
        return previous;
    }
    
}
