import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProductManager {
    //this class is for manager to add, remove and set product in their store.

    private ArrayList<Product> store ; //product in store
    private ArrayList<Integer> Id; // id of procuct in store
    private int size ; //size of all product
    


    //constructor
    //initiate store, id arraylist
    //size = 0
    // add all stock in store
    public ProductManager(){
        
        this.store = new ArrayList<>();
        this.Id = new ArrayList<>();
        this.size  = 0;
        
        try{
            this.add(new Product(1, "Laptop", "High-performance laptop", 1200.00, 20));
            this.add(new Product(2, "Smartphone", "Latest smartphone model", 800.00, 15));
            this.add(new Product(3, "Headphones", "Noise-canceling headphones", 150.00, 30));
            this.add(new Product(4, "Tablet", "10-inch tablet", 400.00, 10));
            this.add(new Product(5, "Keyboard", "Mechanical gaming keyboard", 80.00, 35));
            this.add(new Product(6, "Mouse", "Gaming mouse", 80.00, 35));
            this.add(new Product(7, "Monitor", "27-inch 4K monitor", 500.00, 20));
            this.add(new Product(8, "Gaming Console", "Next-gen gaming console", 400.00, 30));

        }catch(Exception e){
            e.printStackTrace();
        }


    }
    //parameter Product
    //add product in to store list
    public void add(Product item) throws Exception{
        
        if(size == 0){
            this.store.add(item);
            this.Id.add(item.getId());
            this.size++;
        }else if(this.Id.contain(item.getId())){
            System.out.println("Can not add this product because it's already exist.");
        }else{
            this.store.add(item);
            this.Id.add(item.getId());
            this.size++;
        }

        

        
    }
    //parameter id, quantity
    //add stock/quantity to product that contain in list
    public void add(int id,int quantity) throws Exception{
        if(!this.Id.contain(id)){
            System.out.println("Id product not exist");
        }
        int index = this.IdtoIndex(id);
        store.get(index).setQuantity(store.get(index).getQuantity()+quantity);
    }

    //parameter id of product
    //return index of that id
    public int IdtoIndex(int id) throws Exception {
        
        if(size==0){
            System.out.println("Your Store is Empty!");
        }
        if(!this.Id.contain(id)){
            System.out.println("Id product not exist");
        }
        int index = -1;
        for(int i = 0;i<size;i++){
            if(this.Id.get(i).equals(id)){
                index = i;
            }
        }
        return index;
    }
    //return list of product
    public ArrayList<Product> getItemList(){
        return this.store;
    }
    //return list of id
    public ArrayList<Integer> getIdList(){
        return this.Id;
    }

    //display all product in store
    public void displayProduct(){

        
        System.out.println("============================================================================================================================================");
        System.out.println("| ID |     Product Name      |     Price      |   Quantity   |                       Description                                           |");
        System.out.println("============================================================================================================================================");

        
        for(int i = 0 ; i< this.store.size();i++){
            System.out.println(this.store.get(i).toStringForManager());
        }
        System.out.println("============================================================================================================================================\n");
        
        
    }

    //parameter ID
    //remove product with that ID
    public void remove(int id) throws Exception{
        if(this.store.size() == 0){
            System.out.println("YOUR STORE IS ALREADY EMPTY!");
            throw new Exception("YOUR STORE IS ALREADY EMPTY!");
        }
        if(!this.Id.contain(id)){
            System.out.println("INVALID ID OR DO NOT HAVE PRODUCT!");
            throw new Exception("INVALID ID OR DO NOT HAVE PRODUCT!");
            
        }
        this.store.remove(this.IdtoIndex(id));
        this.Id.remove(this.IdtoIndex(id));
        this.size--;
    }

    public void reduce(int id,int quantity) throws Exception{
        if(this.store.size() == 0){
            System.out.println("YOUR STORE IS ALREADY EMPTY!");
            throw new Exception("YOUR STORE IS ALREADY EMPTY!");
        }
        if(!this.Id.contain(id)){
            System.out.println("INVALID ID OR DO NOT HAVE PRODUCT!");
            throw new Exception("INVALID ID OR DO NOT HAVE PRODUCT!");
        }
        if(quantity > this.get(id).getQuantity()){
            System.out.println("REDUCE QUANTITY IS MORE THAN OUR STOCK!");
            throw new Exception("REDUCE QUANTITY IS MORE THAN OUR STOCK!");
        }
        if(quantity <= 0){
            System.out.println("INVALID QUANTITY");
            throw new Exception("INVALID QUANTITY");
        }
        this.get(id).setQuantity(this.get(id).getQuantity()- quantity);

    }
    

    //parameter ID, PRODUCT
    //change value of that id to new product
    public void set(int id, Product item) throws Exception{
        if(!this.Id.contain(id)){
            System.out.println("Invalid ID or Do not have product.");
            
        }else if(this.size == 0){
            System.out.println("You did not add any product yet.");
        }

        this.store.set(this.IdtoIndex(id),item);
        this.Id.set(this.IdtoIndex(id),item.getId());
        
       
    }

    //get product in stock with ID
    public Product get(int id) throws Exception{
        if(!this.Id.contain(id)){
           
            System.out.println("INVALID ID OR DO NOT HAVE PRODUCT."); 
            return null;
        }else{
            return this.store.get(this.IdtoIndex(id));
        }
    }

    //parameter ID,Quantity
    //Return new Item with ID,Quantity
    public Product get(int id,int quantity) throws Exception {
        if(!this.Id.contain(id)){
            System.out.println("INVALID ID OR DO NOT HAVE PRODUCT1.");
            return null;
        }
        if(this.store.get(this.IdtoIndex(id)).getQuantity()< quantity){
            System.out.println("Input quantity more than store have.");
            return null;
        }

        return new Product(id,store.get(this.IdtoIndex(id)).getName(),store.get(this.IdtoIndex(id)).getDesc(),store.get(this.IdtoIndex(id)).getPrice(),quantity);
    }

    //return size of all product
    public int size(){
        return this.size;
    }
    //parameter = file name
    //return .csv file of stock in store
    public void writeProductsToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write header
            writer.write("ID,Name,Price,Quantity,Description\n");

            // Write each product to the CSV file
            for (int i = 0 ; i < store.size() ;i++) {
                writer.write(String.format("%d,%s,%.2f,%d,%s\n",
                        store.get(i).getId(),
                        store.get(i).getName(),
                        store.get(i).getPrice(),
                        store.get(i).getQuantity(),
                        store.get(i).getDesc()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     
    
}


    
    

    


 
