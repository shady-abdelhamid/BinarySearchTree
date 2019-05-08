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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10, "Ten");
        tree.insert(20, "Twenty");
        tree.insert(15, "Fifteen");
        
        System.out.println(tree.findMin().key);
    }
    
}
