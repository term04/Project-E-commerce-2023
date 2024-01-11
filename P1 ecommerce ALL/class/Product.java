public class Product {
    private int ID; //product id
    private String Name; //product name
    private String Desc; //product description
    private double Price; //product price
    private int Quantity; //product quantity
    

    //constructor for product
    public Product(int id,String name,String desc,double price,int quantity){
        this.ID = id;
        this.Name = name;
        this.Desc = desc;
        this.Price = price;
        this.setQuantity(quantity);
    }

    //If  Manager dont put quantity set it to 1
    public Product(int id,String name,String desc,double price){
        this.ID = id;
        this.Name = name;
        this.Desc = desc;
        this.Price = price;
         this.setQuantity(1);
    }
    //parameter amount
    //set qunatity to this amount
    public void setQuantity(int amount){
        this.Quantity = amount;
    }
    //return this id
    public int getId(){
        return this.ID;
    }

    //return this name
    public String getName(){
        return this.Name;
    }

    public double getPrice(){
        return this.Price;
    }

    //return this quantity
    public int getQuantity(){
        return this.Quantity;
    }
    //return this description
    public String getDesc(){
        return this.Desc;
    }
    //return total price of this product
    public double getTotal(){
        return this.Price*this.Quantity;
    }

    //this method is arrange text to be in the center
    public String centerText(String text, int width) {
        int spaces = (width - text.length()) / 2;
        String paddedText = String.format("%" + (text.length() + spaces) + "s", text);
        return String.format("%-" + width + "s", paddedText);
    }
   

    
    //print format for cart
    public String toString(){
        return String.format("| %2s | %20s  | %15s| %12s | %-75s |",
                centerText(String.valueOf(ID), 2),
                centerText(Name, 20),
                centerText(String.format("%.2f", this.getTotal()), 15),
                centerText(String.valueOf(Quantity), 12),
                centerText(this.Desc, 55));
    }

    //print format for stock in store
    public String toStringForManager(){
         return String.format("| %2s | %20s  | %15s| %12s | %-75s |",
                centerText(String.valueOf(ID), 2),
                centerText(Name, 20),
                centerText(String.format("%.2f", Price), 15),
                centerText(String.valueOf(Quantity), 12),
                centerText(this.Desc, 55));
    }
    

    
}
