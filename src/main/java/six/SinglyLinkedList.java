package six;

/**
 * @version V1.0.0
 * @Description 1) 单链表的插入、删除、查找操作
 *               2) 链表中存储的是 int 类型的数据
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2018/10/5 18:28
 */
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value){
        Node p = head;
        while (p != null && p.data != value){
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while (p != null && pos != index){
            p = p.next;
            ++pos;
        }
        return p;
    }

    public void insertToHead(int value){
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode){
        if (head == null){
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertToAfter(Node p, int value){
        Node newNode = new Node(value, null);
        insertToAfter(p, newNode);
    }

    public void insertToAfter(Node p, Node newNode){
        if (p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value){
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode){
        if (p == null) return;
        if (head == p){
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while (q != null && q.next != p){
            q = q.next;
        }
        if (q == null){
            return;
        }
        q.next = newNode;
        newNode.next = p;
    }

    public void deleteByNode(Node p){
        if (head == null || p == null) return;

        if (p == head){
            head = head.next;
        }

        Node q = head;
        while (q != null && q.next != p){
            q = q.next;
        }
        if (q == null) return;

        q.next = p.next;
    }

    public void deleteByValue(int value){
        if (head == null) return;

        Node p = head;
        Node q = null;
        while (p != null && p.data != value){
            q = p;
            p = p.next;
        }

        if (p == null) return;

        if (q == null){
            head = head.next;
        }else {
            q.next = q.next.next;
        }
    }

    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value){
        return new Node(value, null);
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
