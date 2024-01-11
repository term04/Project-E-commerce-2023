public class Cart {
    private LinkedList<Product> cart; //cart
    private LinkedList<Integer> idInCart; //id in cart
    private ProductManager stock; //store stock
    private String[] coupon = new String[] {"9ARM","LnwZA"}; //discount code
    public String discount = ""; //default discount = null
    public double discountPrice = 0;; // default discount price = 0

    //constructor
    public Cart(){
        this.cart = new LinkedList<>();
        this.idInCart = new LinkedList<>();
        this.stock = new ProductManager();
    }

    public int IdtoIndex(int id) throws Exception{
        if(cart.size()==0){
            throw new Exception();
        }
        for(int i = 0 ; i < cart.size() ; i++){
            if(cart.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    public Product get(int id) throws Exception{
        if(!this.idInCart.contain(id)){
            System.out.println("Invalid ID or Do not have product."); 
            return null;
        }else{
            //System.out.println(this.IdtoIndex(id)); 
            return this.cart.get(this.IdtoIndex(id));
        }
    }


    public void add(int id,int quantity) throws Exception{
        
        if(!this.stock.getIdList().contain(id)){
            System.out.println("INVALID ID INPUT");
            throw new Exception("Invalid ID input!");
        }
        if(this.stock.get(id).getQuantity()<quantity){
            System.out.println("INPUT QUANTITY MORE THAN OUR STOCK.");
            throw new Exception("Input quantity more than our stock.");
        }

        if(quantity <= 0){
            System.out.println("INVALID QUANTITY");
            throw new Exception("Invalid ID input!");
        }
        //fixing add message not shown
        if(!this.idInCart.contain(id) ){

            this.idInCart.add(id);
            this.cart.add(this.stock.get(id, quantity));
            this.stock.get(id).setQuantity(this.stock.get(id).getQuantity()-quantity);
            System.out.println("\n///////////////////////////////////////SUCESSFULLY ADD PRODUCT ID: "+id+ " QUANTITY: "+ quantity+ " TO YOUR CART./////////////////////////////////////////////\n");
            
        }else{
            this.get(id).setQuantity(this.get(id).getQuantity()+quantity);
            this.stock.get(id).setQuantity(this.stock.get(id).getQuantity()-quantity);
            System.out.println("\n///////////////////////////////////////SUCESSFULLY ADD QUANTITY: "+quantity+ " PRODUCT ID: "+ id+ " IN YOUR CART./////////////////////////////////////////////\n");
        }
        
    }

    public void add(int id) throws Exception{
        if(!this.stock.getIdList().contain(id)){
            System.out.println("INVALID ID INPUT");
            throw new Exception("Invalid ID input!");
        }
        if(this.stock.get(id).getQuantity()<1){
           System.out.println("INPUT QUANTITY MORE THAN OUR STOCK.");
            throw new Exception("Input quantity more than our stock.");
        }
 
    
        //fixing add message not shown
        if(!this.idInCart.contain(id) ){

            this.idInCart.add(id);
            this.cart.add(this.stock.get(id, 1));
            this.stock.get(id).setQuantity(this.stock.get(id).getQuantity()-1);
            System.out.println("\n///////////////////////////////////////SUCESSFULLY ADD PRODUCT ID: "+id+ " QUANTITY: "+ 1+ " TO YOUR CART./////////////////////////////////////////////\n");
            
        }else{
            this.get(id).setQuantity(this.get(id).getQuantity()+1);
            this.stock.get(id).setQuantity(this.stock.get(id).getQuantity()-1);
            System.out.println("\n///////////////////////////////////////SUCESSFULLY ADD QUANTITY: "+1+ " PRODUCT ID: "+ id+ " IN YOUR CART./////////////////////////////////////////////\n");
        }
        
    }

    public void remove(int id) throws Exception{
        if(cart.size()==0){
            System.out.println("YOUR CART IS ALREADY EMPTY!");
            throw new Exception("YOUR CART IS ALREADY EMPTY!");
            
        }
        
        if(!this.idInCart.contain(id)){
            System.out.println("INVALID ID INPUT!");
            throw new Exception("INVALID ID INPUT!");
        }

        this.stock.get(id).setQuantity(this.stock.get(id).getQuantity()+this.get(id).getQuantity());
        this.idInCart.remove(this.IdtoIndex(id));
        this.cart.remove(this.IdtoIndex(id));
        System.out.println("\n////////////////////////////////////////////SUCESSFULLY REMOVE PRODUCT ID: "+id+ " IN YOUR CART.//////////////////////////////////////////////////\n");

    }

    public void reduceQuantity(int id,int quantity) throws Exception{
        if(cart.size()==0){
            System.out.println("CANNOT REDUCE ANYTHING BECAUSE YOUR CART IS EMPTY.");
        }
        if(quantity > this.get(id).getQuantity()){
            System.out.println("CANNOT REDUCE PRODUCT QUANTITY MORE THAN QUANTITY IN CART.");
        }
        if(quantity <= 0){
            System.out.println("INVALID QUANTITY");
        }
        if(!this.idInCart.contain(id)){
            System.out.println("INVALID ID INPUT!\n");
        }
       
        if(this.idInCart.contain(id)){
            this.stock.get(id).setQuantity(this.stock.get(id).getQuantity()+quantity);
            this.get(id).setQuantity(this.get(id).getQuantity()-quantity);
        }
       
        if(this.get(id).getQuantity()<=0){
            idInCart.remove(this.IdtoIndex(id));
            cart.remove(this.IdtoIndex(id));
        }

        System.out.println("\n////////////////////////////////////////SUCESSFULLY REDUCE PRODUCT ID: "+id+" QUANTITY "+quantity+  " IN YOUR CART.///////////////////////////////////////////////\n");
        
    }

    public double getTotalPrice(){
        double total = 0;
        for(int i = 0 ; i < this.cart.size();i++){
            total += (this.cart.get(i).getTotal());
        }
        if(discount!= null){
            total -= this.discountPrice;
        }

        //add if have discount -10% from total
        
        return total;
    }

    public void getCart(){
        
        if(this.cart.size()==0){
        System.out.println("====================================================YOUR CART IS EMPTY======================================================================\n\n");
            return;
        }
        System.out.println("YOUR CART");
        System.out.println("============================================================================================================================================");
        System.out.println("| ID |     Product Name      |     Price      |   Quantity   |                       Description                                           |");
        System.out.println("============================================================================================================================================");
        for(int i = 0; i< cart.size();i++){
            System.out.println(cart.get(i));
        }

        System.out.println("============================================================================================================================================\n");

    }

    public void getReceipt() throws Exception{
        if(cart.size() == 0){
            throw new Exception("NO ITEM IN YOUR CART.");
        }
        System.out.println("********************************************************************************************************************************************");
        System.out.println("*                                                         RECEIPT                                                                          *");
        System.out.println("*                                                     ELECTRONIC STORE                                                                     *");
        System.out.println("*                                                                                                                                          *");
        System.out.println("********************************************************************************************************************************************");
        System.out.println("*    QUANTITY         ID            NAME                                                                      AMOUNT                       *");
        System.out.println();
        
        for(int i = 0;i<cart.size();i++){
            System.out.printf("* %16s   %4s  %16s                                                           %15s                  *\n",centerText(String.valueOf(cart.get(i).getQuantity()),16),centerText(String.valueOf(cart.get(i).getId()),6),centerText(cart.get(i).getName(),18),centerText(String.format("%.2f", cart.get(i).getTotal()), 15));
        }
        if(isdiscountValid(discount)){
        System.out.println("*                                                                                                                                          *");
            System.out.printf("*       DISCOUNT COUPON %20s           %30s              *\n",centerText(discount, 60),centerText(String.format("%.2f", discountPrice),30));
        }                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                                                                
        System.out.printf("*                                                                                                                                          *%n");
        System.out.printf("*             TOTAL                                                                                           %.2f                      *%n",this.getTotalPrice());
        System.out.println("********************************************************************************************************************************************");
        System.out.println("                                                   THANK YOU FOR PURCHASING");
    
    }
    private String centerText(String text, int width) {
        int spaces = (width - text.length()) / 2;
        String paddedText = String.format("%" + (text.length() + spaces) + "s", text);
        return String.format("%-" + width + "s", paddedText);
    }

    public boolean isdiscountValid(String code){
        for(int i =0 ;i < coupon.length;i++){
            if(code.equals(coupon[i])){
                this.discount = code;
                this.discountPrice += getTotalPrice()*0.10;
                return true;
                
            }
        }
        return false;
    }



    public boolean cartEmpty (){
        return this.cart.size() == 0;
    }

    public LinkedList<Product> getList(){
        return this.cart;
    }

    public ProductManager getStock(){
        return this.stock;
    }





}
