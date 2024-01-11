

public class LinkedList<T> {
    
    private ListNode<T> front; //first node in list
    private int size; //list size


    //initialize front = null
    //           size = 0 
    public LinkedList(){
        this.front = null;
        this.size = 0;
    }
    
    //return true if front ==   null
    public boolean isEmpty(){
        return this.front == null;
    }



    //parameter item
    //add item in list
    public void add(T item){

        ListNode<T> Node = new ListNode<T>(item);

        if(this.isEmpty()){
            this.front = Node;
        }else{
            ListNode<T> last = this.front;
            while(last.getNext()!=null){
            last = last.getNext();
                }
            last.setNext(Node);
        }
        this.size++;

    }
    //remove last index in list
    public void remove(){
        if(this.isEmpty()){
            throw new NullPointerException("No item exist in list.");
        }
        ListNode<T> temp = this.front;

       for(ListNode<T> node = this.front; node != null; node = node.getNext()){
            temp = node;
        }
        temp.setNext(null);
        this.size--;
        
    }

    //parameter index
    //remove value in list with specific index
    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        
        if(index == 0){
            this.front = front.getNext();
        }else{
            ListNode<T> node = this.front;
            for(int i = 0 ; i < index-1;i++){
                node = node.getNext();
           
                }
            node.setNext(node.getNext().getNext());
        }
        size--;

    }
    //return this size
    public int size(){
        return this.size;
    }


    //parameter index
    //return value in that index
    public T get (int index){
        
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        
        ListNode<T> node = this.front;
        for(int i = 0 ; i < index;i++){
            node = node.getNext();
        }
        return node.getItem();
    }


    //parameter item
    //return true if item is in the list
    public boolean contain(T item){
        ListNode<T> node = this.front;
        for(int i = 0; i<this.size;i++){
            if(node.getItem().equals(item)){
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    
    //print all item in list
    public String toString (){
        String result = "[";
        int n = 0;
        ListNode<T> node = this.front;
        while( n < this.size){
            result += node.getItem();
            
            if(node.getNext()!= null&&n<size-1){
                result += ',';
            }
            node = node.getNext();
            n++;
        }
        
        result += "]";

        return result;
    }

}
