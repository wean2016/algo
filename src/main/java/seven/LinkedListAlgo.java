package seven;

/**
 * @version V1.0.0
 * @Description 1) 单链表反转
 *               2) 链表中环的检测
 *               3) 两个有序链表合并
 *               4) 删除链表倒数第 n 个结点
 *               5) 求链表的中间结点
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2018/10/5 23:51
 */
public class LinkedListAlgo {

    // 单链表反转
    public static Node reverse(Node list){
        Node head = null;
        Node previousNode = null;
        Node currentNode = list;
        while (currentNode != null){
            Node nextNode = currentNode.next;
            if (head == null) head = currentNode;

            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return head;
    }

    // 检测环
    public static boolean checkCircle(Node list){
        if (list == null) return false;

        Node fast = list.next;
        Node slow = list;
        while (fast != null && fast.next != null){
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    // 有序链表合并
    public static Node mergeSortedLists(Node la, Node lb){
        if (la == null) return lb;
        if (lb == null) return la;

        Node p = la;
        Node q = lb;
        Node head = null;
        Node r = null;

        if (p.data > q.data){
            head = p;
            p = p.next;
        }else {
            head = q;
            q = q.next;
        }

        while (p != null && q != null){
            if (p.data > q.data){
                r.next = p;
                p = p.next;
            }else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        while (p != null){
            r.next = p;
            r = r.next;
            p = r.next;
        }
        while (q != null){
            r.next = q;
            r = r.next;
            q = q.next;
        }
        return head;
    }

    // 删除倒数第 K 个节点
    public static Node deleteLastKth(Node list, int k){
        Node fast = list;
        int i = 1;
        while (fast != null && i < k){
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;

        Node slow = list;
        Node previousNode = null;

        while (fast.next != null){
            fast = fast.next;
            previousNode = slow;
            slow = slow.next;
        }

        if (previousNode == null){
            list = list.next;
        }else {
            previousNode.next = previousNode.next.next;
        }
        return list;
    }

    // 求中间节点
    public static Node findMiddleNode(Node list){
        if (list == null) return null;
        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printAll(Node list){
        Node p = list;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

}
