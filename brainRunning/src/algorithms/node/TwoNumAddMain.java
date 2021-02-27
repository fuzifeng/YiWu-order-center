package algorithms.node;

/**
 * @author fuzf
 */
public class TwoNumAddMain {

    public static void main(String[] args) {
        Node node1 = Node.getInstance(new int[]{2, 4, 3});
        Node node2 = Node.getInstance(new int[]{5, 6, 4});
        Node.printNode(solution(node1, node2));
    }

    private static Node solution(Node node1, Node node2) {
        Node head = null, tail = null;

        int addOne = 0;
        while (node1 != null || node2 != null || addOne != 0) {

            int v1 = node1 == null ? 0 : node1.val;
            int v2 = node2 == null ? 0 : node2.val;

            int gewei = (v1 + v2 + addOne) % 10;
            addOne = (v1 + v2 + addOne) / 10;
            if (head == null) {
                head = tail = new Node(gewei, null);
            } else {
                tail.next = new Node(gewei, null);
                tail = tail.next;
            }
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        return head;
    }
}
