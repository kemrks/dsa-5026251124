package lw06.prelab;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main {

    // Insert secara rekursif, duplikat diabaikan
    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // Search secara rekursif
    static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }
        if (target == root.data) {
            return true;
        }
        if (target < root.data) {
            return search(root.left, target);
        }
        return search(root.right, target);
    }

    // Root -> Left -> Right
    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(" " + root.data);
        preorder(root.left);
        preorder(root.right);
    }

    // Left -> Root -> Right
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(" " + root.data);
        inorder(root.right);
    }

    // Left -> Right -> Root
    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(" " + root.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumber.txt"));

        // baris pertama: nilai-nilai yang di-insert
        Scanner line = new Scanner(sc.nextLine());
        Node root = null;
        while (line.hasNextInt()) {
            root = insert(root, line.nextInt());
        }
        line.close();

        // baris kedua: target pencarian
        int target = sc.nextInt();
        sc.close();

        System.out.print("Preorder :");
        preorder(root);
        System.out.println();

        System.out.print("Inorder :");
        inorder(root);
        System.out.println();

        System.out.print("Postorder :");
        postorder(root);
        System.out.println();

        System.out.println("Search " + target + " : " + search(root, target));
    }
}