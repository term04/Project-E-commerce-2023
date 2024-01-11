

public class ArrayList<T>{

    private Object[] array; //Array to store object data type.
    private final int defaultSize =10; //set default size to be 10
    private int Tsize; //initialize size;
    private int size; //this current size;
    

    //constructor
    //initialize
    //size = 0
    public ArrayList(){
        this.size = 0; 
        this.Tsize = this.defaultSize;
        this.array = new Object[this.defaultSize];
    }

    //return this array size
    public int size(){
        return this.size;
    }


    //return true if this array is empty else return false.
    public boolean isEmpty(){
        return size==0;
    }

    //return true if array is full else return false.
    private boolean checkFull(){
        return this.size==this.Tsize;
    }


    //parameter : T item
    //return true if that item is in array else return false.
    public boolean contain(T item) throws Exception{
        
        if(isEmpty()){
            throw new Exception("No element in array!");
            //System.out.println("Don't have element in ArrayList");
        }
        
        for(int i = 0 ; i<this.size; i++){
            if(this.array[i].equals(item)){
                return true;
            }
        }
        return false;
    }


    //parameter index and item
    //change value in arr at index to be item 
    public void set(int index, T item) throws Exception{
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if(isEmpty()){
            throw new Exception("No element in array!");
            //System.out.println("Don't have element in ArrayList");
        }

        this.get(index);
        this.array[index] = item;
        
    }

    

    //parameter index that exist in array
    //return that arr[index] value
    public T get(int index){
        
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return    (T) array[index];
    }

    //parameter item
    //add item in arr
    //size+1
    public void add(T item) {
        if(this.checkFull()){

            Object[] temporary = new Object[this.size];

            System.arraycopy(array, 0, temporary, 0, size);

            this.Tsize = this.defaultSize*2;
            this.array = new Object[this.Tsize];
            System.arraycopy(temporary, 0, array, 0, size);
            
        }

        this.array[size]= item;
        this.size++;
        
    }
    //remove lastest index in array
    public void remove(){
        if(this.isEmpty()){
            System.out.println("Cannot remove");
        }
        
        this.size--;
        Object[] temporary = new Object[this.size];
        System.arraycopy(array, 0, temporary, 0, size);
        this.array = new Object[this.size];
        System.arraycopy(temporary, 0, array, 0, size);


    }

    //parameter index
    //remove value in that index
    public void remove(int index ){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Object[] temporary = new Object[this.size-1];

        int j=0;
        for(int i = 0 ; i < array.length ;i++){
            if(i == index ){
                i++;
            }
            temporary[j] = this.array[i];
            j++;
            if(j==temporary.length){
                break;
            }
        }
        this.size--;
        this.array = new Object[this.size];
        System.arraycopy(temporary, 0, array, 0, size);
        

    }

    //print all item item in array
    public String toString(){
        String result = "";
        result += "[";


        for(int i = 0 ; i<this.size; i++){
            result += this.array[i] ;
            if(i != this.size-1){
                result += ",";
            }
        }
        
        result += "]";

        return result;
    }
    
}
