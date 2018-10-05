package six;

/**
 * @version V1.0.0
 * @Description
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2018/10/5 19:06
 */
public class SinglyLinkedLRU extends SinglyLinkedList{
    private int size = 0;
    private final int capacity;

    public SinglyLinkedLRU(int capacity) {
        this.capacity = capacity;
    }

    public void access(Node p){
        if (p == null) return;

        Node node = findByValue(p.data);
        if (node == null){
            insertToHead(p.data);
            size++;
            if (size > capacity) deleteLast();
        }else {
            deleteByValue(p.data);
            insertToHead(p.data);
        }
    }

    public void deleteLast(){
        if (head == null)return;
        Node p = head;
        Node q = null;
        while (p != null){
            q = p;
            p = p.next;
        }
        q.next = null;
    }

}
