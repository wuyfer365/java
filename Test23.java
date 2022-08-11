//合并K个升序链表
// 给你一个链表数组，每个链表都已经按升序排列。

// 请你将所有链表合并到一个升序链表中，返回合并后的链表。

//  

// 示例 1：

// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
// 输出：[1,1,2,3,4,4,5,6]
// 解释：链表数组如下：
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// 将它们合并到一个有序链表中得到。
// 1->1->2->3->4->4->5->6
// 示例 2：

// 输入：lists = []
// 输出：[]
// 示例 3：

// 输入：lists = [[]]
// 输出：[]
//  

// 提示：

// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode next) { val = x; this.next = next; }
}
public class Test23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {//判断是否为空
            return null;//返回空
        }
        return merge(lists, 0, lists.length - 1);//调用递归函数 将数组中的链表合并成一个有序链表 并返回 有序链表的头结点 
    }

    private ListNode merge(ListNode[] lists, int i, int j) {//递归函数 将数组中的链表合并成一个有序链表 并返回 有序链表的头结点 
        if (i == j) {//判断是否为最后一个链表
            return lists[i];//返回最后一个链表的头结点
        }
        int mid = (i + j) / 2;//计算中间索引
        ListNode l1 = merge(lists, i, mid);//调用递归函数 将数组中的链表合并成一个有序链表 并返回 有序链表的头结点
        ListNode l2 = merge(lists, mid + 1, j);//调用递归函数 将数组中的链表合并成一个有序链表 并返回 有序链表的头结点
        return mergeTwoLists(l1, l2);//调用合并两个有序链表的函数 并返回合并后的链表的头结点
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {//合并两个有序链表的函数 并返回合并后的链表的头结点
        if (l1 == null) {//判断l1是否为空 如果为空返回l2
            return l2;//返回l2
        }
        if (l2 == null) {//判断l2是否为空 如果为空返回l1
            return l1;//返回l1
        }
        ListNode dummy = new ListNode(0);//创建一个虚拟头结点
        ListNode cur = dummy;//创建一个指针指向虚拟头结点
        while (l1 != null && l2 != null) {//判断l1和l2是否为空 如果都不为空 则继续循环 
            if (l1.val < l2.val) {//判断l1的值是否小于l2的值 如果小于 则将l1的值放入虚拟头结点的下一个结点中 并将l1的下一个结点赋值给l1
                cur.next = l1;
                l1 = l1.next;
            } else {//如果l1的值大于等于l2的值 则将l2的值放入虚拟头结点的下一个结点中 并将l2的下一个结点赋值给l2
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;//将指针指向虚拟头结点的下一个结点
        }
        if (l1 != null) {//判断l1是否为空 如果不为空 则将l1的值放入虚拟头结点的下一个结点中
            cur.next = l1;
        }
        if (l2 != null) {//判断l2是否为空 如果不为空 则将l2的值放入虚拟头结点的下一个结点中
            cur.next = l2;
        }
        return dummy.next;//返回虚拟头结点的下一个结点
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);
        ListNode[] lists = new ListNode[]{l1, l2, l3};
        Test23 test = new Test23();
        ListNode l = test.mergeKLists(lists);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}