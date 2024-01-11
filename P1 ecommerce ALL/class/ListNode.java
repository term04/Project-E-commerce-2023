public class ListNode <T> {
    private T item; //node value
    private ListNode<T> next; // next node


    //constructor
    //parameter item
    //next = null
    public ListNode(T item){
        this.item = item;
        this.next = null;
    }
    //constructor
    //parameter item
    //next = nextNode
    public ListNode(T item, ListNode<T> next){
        this.item = item;
        this.next = next;
    }

    //return node value
    public T getItem(){
        return this.item;
    }

    //return next node
    public ListNode<T> getNext(){
        return this.next;
    }

    //parameter item
    //set node value equal this item
    public void setItem(T item){
        this.item = item;
    }

    //paremeter next
    //set next node to next
    public void setNext(ListNode<T> next){
        this.next = next;
    }

    
    //format when print node
    public String toString(){
        String a = "";
        a+= this.item;
        return a;
    }

    
}
