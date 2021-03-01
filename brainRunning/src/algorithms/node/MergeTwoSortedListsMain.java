package algorithms.node;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fuzf
 */
public class MergeTwoSortedListsMain {

    public static void main(String[] args) {
        Node node1 = Node.getInstance(new int[]{2, 3,7});
        Node node2 = Node.getInstance(new int[]{1, 5, 6});
        Node.printNode(merge(node1, node2));
    }

    public static Node merge(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        Node preNode = new Node(-1, null);
        Node temp = preNode;

        while (node1 != null || node2 != null) {

            if (node1 == null) {
                Node node = new Node(node2.val, null);
                temp.next = node;
                temp = node;
                node2 = node2.next;
                continue;
            }

            if (node2 == null) {
                Node node = new Node(node1.val, null);
                temp.next = node;
                temp = node;
                node1 = node1.next;
                continue;
            }
            int n1v = node1.val;
            int n2v = node2.val;
            if (n1v > n2v) {
                Node node = new Node(n2v, null);
                temp.next = node;
                temp = node;
                node2 = node2.next;
            } else {
                Node node = new Node(n1v, null);
                temp.next = node;
                temp = node;
                node1 = node1.next;
            }

        }
        return preNode.next;
    }
}
