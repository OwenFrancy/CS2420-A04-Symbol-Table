package a04_Tree;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

/**
 * Represents a binary tree with unique integer values. Provides various methods to
 * manipulate and analyze the tree structure, including doubling even numbers, counting
 * specific types of nodes, and calculating differences between values.
 * 
 * The tree data is represented as a list of integer arrays, where each array contains
 * the value of a node and the indices of its left and right children. For example:
 *
 * [node_value, left_child_index, right_child_index]
 *
 * The root node is at index 0. A left or right child index of null indicates that
 * the node does not have a corresponding child.
 * 
 * @author CS Starter Code + Ash Bullock + Owen Francy
 */
public class UniqueTree {
	 
    private Node root;
    private Set<Integer> elements = new HashSet<>();  // To ensure uniqueness
 
    // Inner class representing a node in the tree
    private class Node {
        int val;
        Node left, right;
 
        Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
 
    /**
     * Constructs a UniqueTree from a list of integer arrays.
     * Each array contains: [node_value, left_child_index, right_child_index]
     *
     * @param treeData the list representing the tree structure
     * @throws IllegalArgumentException if the tree data is null or empty, or if the
     *         tree contains duplicate values
     */
    public UniqueTree(List<Integer[]> treeData) {
        if (treeData == null || treeData.isEmpty()) {
            throw new IllegalArgumentException("Tree data cannot be null or empty.");
        }
        this.root = buildTree(treeData, 0);  // Start building from the root (index 0)
    }
 
    /**
     * Recursively builds the subtree whose root is stored at the given index of the
     * tree data list. Each value is checked against the set of values already seen
     * so that every value in the tree is unique.
     *
     * @param data  the list representing the tree structure
     * @param index the index in {@code data} of the node to build, or -1 for no node
     * @return the root of the subtree built from {@code index}, or {@code null} if
     *         there is no node at that index
     * @throws IllegalArgumentException if a duplicate value is found
     */
    private Node buildTree(List<Integer[]> data, int index) {
        if (index == -1 || index >= data.size() || data.get(index) == null) {
            return null;
        }
 
        Integer[] nodeData = data.get(index);
        int value = nodeData[0];
 
        // Check for uniqueness
        if (!elements.add(value)) {
            throw new IllegalArgumentException("Duplicate value found: " + value);
        }
 
        Node node = new Node(value);
 
        // Build the left and right subtrees using the provided indices
        node.left = buildTree(data, nodeData[1] != null ? nodeData[1] : -1);
        node.right = buildTree(data, nodeData[2] != null ? nodeData[2] : -1);
 
        return node;
    }
 
    /**
     * Doubles the value of all even numbers in the tree. Odd values are left
     * unchanged.
     * 
     * Note: the uniqueness check only happens when the tree is constructed, so
     * doubling a value that then matches another value in the tree is not detected.
     */
    public void doubleEvenNumbers() {
        doubleEvenNumbers(root);
    }
 
    /**
     * Recursively doubles every even value in the subtree rooted at {@code node}.
     * Visits the node itself, then its left subtree, then its right subtree.
     *
     * @param node the root of the subtree to process; may be {@code null}
     */
    private void doubleEvenNumbers(Node node) {
        if (node == null) {
            return;
        }
        if (node.val % 2 == 0) {
            node.val *= 2;
        }
        doubleEvenNumbers(node.left);
        doubleEvenNumbers(node.right);
    }
 
    /**
     * Calculates the sum of all right children.
     * Reminder: The root is not a right child because it has no parent.
     * 
     * @return the sum of all right children, or 0 if the tree has none
     */
    public int sumOfRightChildren() {
        return sumOfRightChildren(root);
    }
 
    /**
     * Recursively sums the values of all right children in the subtree rooted at
     * {@code node}. Each node adds the value of its own right child (if it has one)
     * to the totals from its left and right subtrees. The given {@code node} itself
     * is never counted, since this method does not know whether it is a right child.
     *
     * @param node the root of the subtree to process; may be {@code null}
     * @return the sum of all right children within the subtree, or 0 if there are none
     */
    private int sumOfRightChildren(Node node) {
        if (node == null) {
            return 0;
        }
        int sum = sumOfRightChildren(node.left) + sumOfRightChildren(node.right);
        if (node.right != null) {
            sum += node.right.val;
        }
        return sum;
    }
 
    /**
     * Counts how many nodes have at least one child that is a leaf.
     * A leaf is a node with no children. A node with two leaf children and a node
     * with only one leaf child are each counted once.
     * 
     * @return the count of nodes that have at least one leaf child
     */
    public int countLeafParents() {
        return countLeafParents(root);
    }
 
    /**
     * Recursively counts the nodes in the subtree rooted at {@code node} that have
     * at least one leaf child. The node itself is counted if its left or right
     * child is a leaf; the counts from both subtrees are then added.
     *
     * @param node the root of the subtree to process; may be {@code null}
     * @return the number of nodes in the subtree with at least one leaf child
     */
    private int countLeafParents(Node node) {
        if (node == null) {
            return 0;
        }
        int count = countLeafParents(node.left) + countLeafParents(node.right);
        if (isLeaf(node.left) || isLeaf(node.right)) {
            count++;
        }
        return count;
    }
 
    /**
     * Determines whether a node is a leaf, meaning it exists and has no children.
     *
     * @param node the node to check; may be {@code null}
     * @return {@code true} if {@code node} is non-null and has no left or right
     *         child; {@code false} otherwise
     */
    private boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }
 
    /**
     * Calculates the average of all odd numbers in the tree.
     * 
     * @return the average of all odd numbers, or 0 if there are no odd numbers
     */
    public double averageOfOddNumbers() {
        int count = countOdds(root);
        if (count == 0) {
            return 0.0;
        }
        return (double) sumOdds(root) / count;
    }
 
    /**
     * Recursively adds up all odd values in the subtree rooted at {@code node}.
     *
     * @param node the root of the subtree to process; may be {@code null}
     * @return the sum of all odd values in the subtree, or 0 if there are none
     */
    private int sumOdds(Node node) {
        if (node == null) {
            return 0;
        }
        int sum = sumOdds(node.left) + sumOdds(node.right);
        if (node.val % 2 != 0) {
            sum += node.val;
        }
        return sum;
    }
 
    /**
     * Recursively counts the odd values in the subtree rooted at {@code node}.
     *
     * @param node the root of the subtree to process; may be {@code null}
     * @return the number of odd values in the subtree
     */
    private int countOdds(Node node) {
        if (node == null) {
            return 0;
        }
        int count = countOdds(node.left) + countOdds(node.right);
        if (node.val % 2 != 0) {
            count++;
        }
        return count;
    }
 
    /**
     * Finds the difference between the largest and smallest elements in the tree.
     * 
     * @return the difference between the largest and smallest values, or 0 if the
     *         tree is empty
     */
    public int greatestDifference() {
        if (root == null) {
            return 0;
        }
        return max(root) - min(root);
    }
 
    /**
     * Recursively finds the largest value in the subtree rooted at {@code node}.
     * Compares the node's own value with the largest values of its left and right
     * subtrees.
     *
     * @param node the root of the subtree to search; must not be {@code null}
     * @return the largest value in the subtree
     */
    private int max(Node node) {
        int result = node.val;
        if (node.left != null) {
            result = Math.max(result, max(node.left));
        }
        if (node.right != null) {
            result = Math.max(result, max(node.right));
        }
        return result;
    }
 
    /**
     * Recursively finds the smallest value in the subtree rooted at {@code node}.
     * Compares the node's own value with the smallest values of its left and right
     * subtrees.
     *
     * @param node the root of the subtree to search; must not be {@code null}
     * @return the smallest value in the subtree
     */
    private int min(Node node) {
        int result = node.val;
        if (node.left != null) {
            result = Math.min(result, min(node.left));
        }
        if (node.right != null) {
            result = Math.min(result, min(node.right));
        }
        return result;
    }
}
