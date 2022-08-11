//两两交换链表中的节点
// 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
// 示例 1：


// 输入：head = [1,2,3,4]
// 输出：[2,1,4,3]
// 示例 2：

// 输入：head = []
// 输出：[]
// 示例 3：

// 输入：head = [1]
// 输出：[1]
//  

// 提示：

// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode next) { val = x; this.next = next; }
}
public class Test24 {

    public ListNode swapPairs(ListNode head) {
        //定义是否偶数变量
        boolean isEven = true;
        int length = getLength(head);//获取链表长度
        int changeCount=length/2;//计算需要交换的次数
        int currCount=0;//计算当前交换的次数
        if(length%2!=0){//设置奇数情况
            isEven = false;
        }
        if (head == null || head.next == null) {//判断是否为空 或者只有一个节点 如果是返回自身
            return head;
        }
        ListNode newHead = head.next;//新的头节点
        ListNode pre = head;//前一个节点
        ListNode cur = head.next;//当前节点
        while (cur != null) {//判断当前节点是否为空 如果为空则跳出循环
            currCount++;//当前节点计数+1
            ListNode next = cur.next;//下一个节点.
            cur.next = pre;//当前节点的下一个节点指向前一个节点.
            pre.next = next;//前一个节点的下一个节点指向下一个节点.
            if (currCount==changeCount && !isEven) {//如果当前节点计数等于交换次数且不是偶数情况
                break;
            }
            if (next!=null){//如果下一个节点不为空
                pre.next=next.next;//前一个节点的下一个节点指向下一个节点的下一个节点.
            }else{//如果下一个节点为空
                pre.next=null;//前一个节点的下一个节点指向空.
            }
            pre = next;//前一个节点指向下一个节点.
            cur = next;//当前节点指向下一个节点.
            if (cur != null && cur.next != null) {//判断当前节点是否不为空且下一个节点不为空 如果是则当前节点指向下个节点
                cur = cur.next;     //当前节点指向下个节点.    
            }
        }
        return newHead;//返回新的头节点
    }
    //取得节点数
    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        // ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        Test24 test24 = new Test24();
        ListNode newHead = test24.swapPairs(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}

