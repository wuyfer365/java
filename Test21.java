//合并两个有序链表
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
// 输入：l1 = [1,2,4], l2 = [1,3,4]
// 输出：[1,1,2,3,4,4]

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

public class Test21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);//创建一个头节点，用于返回
        ListNode cur = head;//创建一个指针，用于遍历
        while (list1 != null && list2 != null) {//判断两个链表是否都为空
            if (list1.val < list2.val) {//判断两个链表的值，较小的放入新链表
                cur.next = list1;//指针指向新链表的下一个节点
                list1 = list1.next;//指针指向下一个节点
            } else {//较大的放入新链表
                cur.next = list2;//指针指向新链表的下一个节点
                list2 = list2.next;//指针指向下一个节点
            }
            cur = cur.next;//指针指向新链表的下一个节点
        }
        if (list1 != null) {//判断链表1是否为空
            cur.next = list1;//指针指向新链表的下一个节点
        }
        if (list2 != null) {//判断链表2是否为空
            cur.next = list2;//指针指向新链表的下一个节点
        }
        return head.next;//返回新链表的头节点
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        Test21 test21 = new Test21();
        ListNode list = test21.mergeTwoLists(list1, list2);
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

}
