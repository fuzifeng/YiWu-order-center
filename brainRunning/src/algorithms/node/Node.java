package algorithms.node;

import java.util.List;

/**
 * @author fuzf
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public static Node getInstance() {
        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        return n1;
    }

    public static Node getInstance(int[] nums){
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i], null);
            nodes[i] = node;
        }
        for (int i = 0; i < nums.length-1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 12, 3};
        Node node = Node.getInstance(a);
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
