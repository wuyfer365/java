//K 个一组翻转链表
// 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
// 输入：head = [1,2,3,4,5], k = 2
// 输出：[2,1,4,3,5]
// 输入：head = [1,2,3,4,5], k = 3
// 输出：[3,2,1,4,5]

// 提示：
// 链表中的节点数目为 n
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode next) { val = x; this.next = next; }
}
public class Test25 {
    public ListNode reverseKGroup(ListNode head, int k) {//递归 每次翻转k个节点 然后把翻转后的链表接在原链表后面 再把原链表接在翻转后的链表后面 这样就可以翻转k个节点了 直到翻转完成
        if (head == null || head.next == null || k == 1) {//如果链表为空或者只有一个节点或者k=1 那么直接返回原链表
            return head;
        }
        ListNode dummy = new ListNode(0);//创建一个虚拟头节点
        dummy.next = head;//虚拟头节点指向原链表的头节点
        ListNode pre = dummy;//pre指向虚拟头节点
        ListNode cur = head;//cur指向原链表的头节点
        int count = 0;//计数器
        while (cur != null) {//当cur不为空时 就翻转k个节点
            count++;//计数器加1
            if (count % k == 0) {//如果计数器能被k整除时 即每k个节点翻转一次 
                pre = reverse(pre, cur.next);//翻转前k个节点 并把翻转后的链表接在原链表后面 这样就可以翻转k个节点了 这里的pre指向的是虚拟头节点 因为虚拟头节点指向原链表的头节点
                cur = pre.next;//cur指向翻转后的链表的头节点
            } else {
                cur = cur.next;//cur指向原链表的下一个节点
            }
        }
        return dummy.next;//返回虚拟头节点的下一个节点即为翻转后的链表的头节点

    }

    private ListNode reverse(ListNode pre, ListNode next) {//翻转前k个节点 并把翻转后的链表接在原链表后面 这样就可以翻转k个节点了
        ListNode p = pre.next;//p指向原链表的头节点
        ListNode q = p.next;//q指向原链表的下一个节点
        while (q != next) {//当q不等于next时 即每次翻转k个节点
            p.next = q.next;//p指向q的下一个节点
            q.next = pre.next;//q指向pre的下一个节点
            pre.next = q;//pre指向q
            q = p.next;//q指向p的下一个节点
        }
        return p;//返回p 指向翻转后的链表的头节点
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        Test25 test25 = new Test25();
        ListNode listNode = test25.reverseKGroup(head, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}