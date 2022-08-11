// // 旋转链表
// 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

// 示例 1：

// 输入：head = [1,2,3,4,5], k = 2
// 输出：[4,5,1,2,3]
// 示例 2：

// 输入：head = [0,1,2], k = 4
// 输出：[2,0,1]
//  

// 提示：

// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 10^9
//取消多行/**/注释快捷键  Ctrl+K,C

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Test61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {//判断链表是否为空 为空返回空
            return null;
        }
        ListNode cur = head;//定义一个指针指向链表的头节点
        int len = 1;//定义一个计数器 计算链表的长度
        while (cur.next != null) {//遍历链表
            len++;//计数器加1
            cur = cur.next;//指针向下移动
        }
        cur.next = head;//将链表的最后一个节点的next指向链表的头节点
        k = k % len;//将k取余链表的长度
        for (int i = 0; i < len - k; i++) {//循环len-k次
            cur = cur.next;//指针向下移动
        }
        head=cur.next;//将head指向cur的下一个节点
        cur.next = null;//将cur的next指向空
        return head;//返回head

    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Test61 test61 = new Test61();
        ListNode listNode = test61.rotateRight(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
