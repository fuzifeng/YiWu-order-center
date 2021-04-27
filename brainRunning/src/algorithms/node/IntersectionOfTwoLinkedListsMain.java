package algorithms.node;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fuzf
 */
public class IntersectionOfTwoLinkedListsMain {
    public static void main(String[] args) {
        Node node1 = Node.getInstance(new int[]{4,1,8,4,5});
        Node node2 = Node.getInstance(new int[]{5,6,1,8,4,5});
        Node xNode = xNode(node1, node2);
        int i = 0;
    }

    public static Node xNode2(Node node1, Node node2) {
        Set<Node> set = new HashSet<>();
        while (node1 != null) {
            set.add(node1);
            node1 = node1.next;
        }

        while (node2 != null) {
            if (!set.add(node2)) {
                return node2;
            }
            node2 = node2.next;
        }
        return null;

    }

    public static Node xNode(Node node1, Node node2) {
        int length1 = length(node1);
        int length2 = length(node2);

        int cha = Math.abs(length1 - length2);
        if (cha != 0) {
            if (length1 < length2) {
                while (cha > 0) {
                    node2 = node2.next;
                    cha--;
                }
            } else {
                while (cha > 0) {
                    node1 = node1.next;
                    cha--;
                }
            }
        }
        while (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }

    public static int length(Node node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
