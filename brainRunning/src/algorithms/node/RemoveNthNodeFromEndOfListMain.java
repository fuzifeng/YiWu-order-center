package algorithms.node;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: fuzf
 * @Date: 2021/2/28 0:14
 */
public class RemoveNthNodeFromEndOfListMain {

    public static void main(String[] args) {
        Node node = Node.getInstance(new int[]{1, 2});
        Node.printNode(remove(node, 2));
    }

    public static Node remove(Node head, int n) {
        if (head.next == null) {
            return null;
        }
        Node newNode = new Node(-1, head);
        int cha = 0;
        Node fast = newNode;
        Node slow = newNode;
        while (fast != null && fast.next != null) {
            if (cha != n) {
                cha++;
                fast = fast.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }

        slow.next = slow.next.next;
        return newNode.next;
    }
}
