import java.util.Scanner;

public class UserInterface {
    private Cart userCart;
    private boolean manager = false;

    public UserInterface(){
        this.userCart = new Cart();
    }

    public void welcome(){
        userCart.getStock().writeProductsToCSV("stock.csv");
        System.out.println("\r\n" + //
                "            ____    __    ____  _______  __        ______   ______   .___  ___.  _______                                                       \r\n" + //
                "            \\   \\  /  \\  /   / |   ____||  |      /      | /  __  \\  |   \\/   | |   ____|                                                      \r\n" + //
                "             \\   \\/    \\/   /  |  |__   |  |     |  ,----'|  |  |  | |  \\  /  | |  |__                                                         \r\n" + //
                "              \\            /   |   __|  |  |     |  |     |  |  |  | |  |\\/|  | |   __|                                                        \r\n" + //
                "               \\    /\\    /    |  |____ |  `----.|  `----.|  `--'  | |  |  |  | |  |____                                                       \r\n" + //
                "                \\__/  \\__/     |_______||_______| \\______| \\______/  |__|  |__| |_______|                                                      \r\n" + //
                "                                                                                                                                               \r\n" + //
                "                     .___________. ______                                                                                                      \r\n" + //
                "                     |           |/  __  \\                                                                                                     \r\n" + //
                "                     `---|  |----|  |  |  |                                                                                                    \r\n" + //
                "                         |  |    |  |  |  |                                                                                                    \r\n" + //
                "                         |  |    |  `--'  |                                                                                                    \r\n" + //
                "                         |__|     \\______/                                                                                                     \r\n" + //
                "                                                                                                                                               \r\n" + //
                " _______  __       _______   ______ .___________.______       ______   .__   __.  __    ______         _______. __    __    ______   .______   \r\n" + //
                "|   ____||  |     |   ____| /      ||           |   _  \\     /  __  \\  |  \\ |  | |  |  /      |       /       ||  |  |  |  /  __  \\  |   _  \\  \r\n" + //
                "|  |__   |  |     |  |__   |  ,----'`---|  |----|  |_)  |   |  |  |  | |   \\|  | |  | |  ,----'      |   (----`|  |__|  | |  |  |  | |  |_)  | \r\n" + //
                "|   __|  |  |     |   __|  |  |         |  |    |      /    |  |  |  | |  . `  | |  | |  |            \\   \\    |   __   | |  |  |  | |   ___/  \r\n" + //
                "|  |____ |  `----.|  |____ |  `----.    |  |    |  |\\  \\----|  `--'  | |  |\\   | |  | |  `----.   .----)   |   |  |  |  | |  `--'  | |  |      \r\n" + //
                "|_______||_______||_______| \\______|    |__|    | _| `._____|\\______/  |__| \\__| |__|  \\______|   |_______/    |__|  |__|  \\______/  | _|      \r\n" + //
                "                                                                                                                                               \r\n" + //
                "");
                this.userCart.getStock().displayProduct();
    }


    public void interactLogin(){
        this.manager = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("LOGIN COMMAND");
        System.out.println("=============================================================================================================================================");
        System.out.println("'0' : EXIT FROM THE SYSTEM \r\n" +
                           "'1' : LOGIN AS A CUSTOMER \r\n" + //
                           "'2' : LOGIN AS AN ADMIN ");
        System.out.println("=============================================================================================================================================\n");
        
        int key = -1; //initialize value to go in do-wkile loop;
        do{
            try {
                System.out.print("INPUT>>> ");
                String skey = sc.nextLine();
                key = Integer.parseInt(skey);
                System.out.println();
                
                switch(key){
                    case 0:
                        System.out.println("\n/////////////////////////////////////////////////////EXITING PROGRAM/////////////////////////////////////////////////////////////////////////");
                        break;
                        
                    case 1:
                        this.customerInstruction();
                        break;
                    case 2:
                        this.manager = true;
                        this.adminInstruction();
                        break;

                    default:
                        System.out.println("\nINVALID INPUT PLEASE TRY AGAIN...\n");
                        break;

                        
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT PLEASE TRY AGAIN...\n");
                
            }
            
        }while(key!=0 && key != 1 && key != 2);

    }


    public void customerInstruction(){
        System.out.println("\nINSTRUCTION COMMAND\r\n" + //
                           "=============================================================================================================================================\r\n" + //
                           "'0' : BACK TO LOGIN MENU\r\n" + //
                           "'1' : ADDING PRODUCT TO YOUR CART\r\n" + //
                           "'2' : REMOVING/REDUCING PRODUCT IN YOUR CART\r\n" + //
                           "'3' : VIEWING YOUR CART\r\n" + //
                           "=============================================================================================================================================\n");
    Scanner sc = new Scanner(System.in);
    int key = -1; //initialize value to go in do-wkile loop;
        do{
            try {
                System.out.print("INPUT>>> ");
                String skey = sc.nextLine();
                key = Integer.parseInt(skey);
                
                switch(key){
                    case 0:
                        this.interactLogin();
                        break;
                        
                    case 1:
                        this.addingSession();
                        break;

                        
                    case 2:
                        this.removingSession();
                        break;

                    case 3:
                        this.viewingCart();
                        break;
                    default:
                        System.out.println("\nINVALID INPUT PLEASE TRY AGAIN...\n");
                        break;

                        
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT PLEASE TRY AGAIN...");
            }
    
        }while(key!=0 && key != 1 && key != 2 && key!= 3);

    }

    public void addingSession(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++ADDING SESSION++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        
        userCart.getStock().displayProduct();

        System.out.println("ADDING INSTRUCTION COMMAND\r\n" + //
                           "=============================================================================================================================================\r\n" + //
                           "'0' : EXIT TO MENU\r\n" + //
                           "'1' : ADDING PRODUCT\r\n" + //
                           "=============================================================================================================================================\n");
        Scanner sc = new Scanner(System.in);
        int key = -1; //initialize value to go in do-while loop;
        do{
            try {

                System.out.print("INPUT>>> ");
                String skey = sc.nextLine();
                key = Integer.parseInt(skey);
                
                switch(key){
                    case 0:

                        if(manager){
                            this.adminInstruction();
                        }else{
                            this.customerInstruction();
                        }
                        break;
                        
                    case 1:
                        this.addProcess();
                        break;
                    
                    default:
                        System.out.println("\nINVALID INPUT PLEASE TRY AGAIN...\n");
                        break;

                        
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT PLEASE TRY AGAIN...");
            }
    
        }while(key!=0 && key != 1 );
        
    
    
    }
    public void addProcess(){
        Scanner sc = new Scanner(System.in);
         System.out.println("YOU CAN TYPE '0' TO EXIT. \n");
        do{
        try{


            System.out.print("ID>>> ");
            String s1key = sc.nextLine();
            int id = Integer.parseInt(s1key);
            if(id == 0){
                System.out.println("/////////////////////////////////////////////////////EXITING ADDING PRODUCT/////////////////////////////////////////////////////////////////////////\n");
                break;
            }
            System.out.print("QUANTITY>>> ");
            String s2key = sc.nextLine();
            int quantity = Integer.parseInt(s2key);

            

            if(manager){

                if(userCart.getStock().getIdList().contain(id)){
                    userCart.getStock().add(id,quantity);
                    break;
                }

                System.out.print("NAME>>> ");
                String s3key = sc.nextLine();

                System.out.print("DESCRIPTION>>> ");
                String s4key = sc.nextLine();

                System.out.print("PRICE FOR EACH ITEM>>> ");
                String s5key = sc.nextLine();
                double price =  Double.parseDouble(s5key);

                userCart.getStock().add(new Product(id, s3key, s4key, price,quantity));
                break;
            }

            userCart.add(id,quantity);
            break;
        
        }catch(Exception e){
            System.out.println("INPUT INVALID PLEASE TRY AGAIN...\n");
        }
    }while(true);

    this.addingSession();

    }

    public void removingSession(){
        if(manager){
            userCart.getStock().displayProduct();
        }else{
        userCart.getCart();
        }
        System.out.println("-----------------------------------------------------REMOVING SESSION------------------------------------------------------------------------\n");
        System.out.println("REMOVING INSTRUCTION COMMAND\r\n" + //
                           "=============================================================================================================================================\r\n" + //
                           "'0' : EXIT TO MENU\r\n" + //
                           "'1' : REMOVING PRODUCT\r\n" + //
                           "'2' : REDUCE PRODUCT QUANTITY\r\n" + //
                           "=============================================================================================================================================\r\n" );
        Scanner sc = new Scanner(System.in);
        int key = -1; //initialize value to go in do-wkile loop;
        do{
            try {
                System.out.print("INPUT>>> ");
                String skey = sc.nextLine();
                key = Integer.parseInt(skey);
                
                switch(key){
                    case 0:
                    if(manager){
                        this.adminInstruction();
                    }else{
                        this.customerInstruction();
                    }
                        break;
                        
                    case 1:
                        this.removingProcess();
                        break;

                        
                    case 2:
                        this.reduceProcess();
                        break;

                    default:
                        System.out.println("\nINVALID INPUT PLEASE TRY AGAIN...\n");
                        break;     
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT PLEASE TRY AGAIN...");
            }
    
        }while(key!=0 && key != 1 && key != 2 );
    }

    public void removingProcess(){
        Scanner sc = new Scanner(System.in);
        System.out.println("YOU CAN TYPE '0' TO EXIT. \n");
            do{
                try{
                    System.out.print("ID>>> ");
                    String skey = sc.nextLine();
                    int id = Integer.parseInt(skey);
                    if(id == 0){
                        System.out.println("/////////////////////////////////////////////////////EXITING REMOVING PRODUCT/////////////////////////////////////////////////////////////////////////\n");
                        break;
                    }
                    if(manager){
                        userCart.getStock().remove(id);
                        break;
                    }

                    userCart.remove(id);
                    break;
                    }catch(Exception e){
                        System.out.println("INPUT INVALID PLEASE TRY AGAIN...\n");
                    }
                }while(true);
                this.removingSession();
                }
    public void reduceProcess(){
        Scanner sc = new Scanner(System.in);
         System.out.println("YOU CAN TYPE '0' TO EXIT. \n");
        do{
        try{
            System.out.print("ID>>> ");
            String s1key = sc.nextLine();
            int id = Integer.parseInt(s1key);
            if(id == 0){
                System.out.println("/////////////////////////////////////////////////////EXITING REDUCING PRODUCT/////////////////////////////////////////////////////////////////////////\n");
                break;
            }
            System.out.print("QUANTITY>>> ");
            String s2key = sc.nextLine();
            int quantity = Integer.parseInt(s2key);

            if(manager){
                userCart.getStock().reduce(id,quantity);
                break;
            }

            userCart.reduceQuantity(id,quantity);
            break;
        }catch(Exception e){
            System.out.println("INPUT INVALID PLEASE TRY AGAIN...\n");
        }
    }while(true);
        this.removingSession();
    }

    public void viewingCart(){
        userCart.getCart();
        System.out.println("CART INSTRUCTION COMMAND\r\n" + //
                         "=============================================================================================================================================\r\n" + //
                         "'0' : EXIT TO MENU\r\n" + //
                         "'1' : CHECKING OUT\r\n" + //
                         "=============================================================================================================================================");
        
        Scanner sc = new Scanner(System.in);
        int key = -1; //initialize value to go in do-wkile loop;
            do{
                try {
                    System.out.print("INPUT>>> ");
                    String skey = sc.nextLine();
                    key = Integer.parseInt(skey);
                
                    switch(key){
                        case 0:
                            this.customerInstruction();;
                            break;
                        
                        case 1:
                            this.checkingoutSession();
                            break;


                        default:
                            System.out.println("\nINVALID INPUT PLEASE TRY AGAIN...\n");
                            break;     
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT PLEASE TRY AGAIN...");
            }
    
        }while(key!=0 && key != 1 );
         

    }

    public void checkingoutSession(){
        if(userCart.cartEmpty()){
            System.out.println("CANNOT CHECKOUT BECAUSE YOU DONT HAVE ANY ITEM IN CART!\n");
            System.out.println("/////////////////////////////////////////////////////GOING BACK TO MENU/////////////////////////////////////////////////////////////////////////\n");
            customerInstruction();
            
        }       
        
        System.out.println("\nCHECKOUT COMMAND\r\n" + //
                           "=============================================================================================================================================\r\n" + //
                           "'0' : EXIT TO MENU\r\n" + //
                           "'1' : CONFIRM\r\n" + //
                           "'2' : ADDING DISCOUNT CODE\r\n" + //
                           "=============================================================================================================================================\n");

        Scanner sc = new Scanner(System.in);
        int key = -1; //initialize value to go in do-wkile loop;
            do{
                try {
                    System.out.print("INPUT>>> ");
                    String skey = sc.nextLine();
                    key = Integer.parseInt(skey);
                
                    switch(key){
                        case 0:
                            this.customerInstruction();;
                            break;
                        
                        case 1:
                            this.confirmProcess();
                            break;
                        
                        case 2:
                        this.discountProcess();
                            break;


                        default:
                            System.out.println("\nINVALID INPUT PLEASE TRY AGAIN...\n");
                            break;     
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT PLEASE TRY AGAIN...");
            }
    
        }while(key!=0 && key != 1 &&  key != 2);       
            
    }


    public void confirmProcess(){
        System.out.println("CHOOSE METHOD TO PAY\r\n" + //
                           "=============================================================================================================================================\r\n" + //
                           "'0' : GO BACK\r\n" + //
                           "'1' : CASH\r\n" + //
                           "'2' : MOBILE BANKING\r\n" + //
                           "=============================================================================================================================================");

        Scanner sc = new Scanner(System.in);
        int key = -1; //initialize value to go in do-wkile loop;
            do{
                try {
                    System.out.print("INPUT>>> ");
                    String skey = sc.nextLine();
                    key = Integer.parseInt(skey);
                
                    switch(key){
                        case 0:
                            this.checkingoutSession();;
                            break;
                        
                        case 1:
                            
                            System.out.println("//////////////////////////////////////////////////YOUR ORDER HAVE BEEN CONFIRM////////////////////////////////////////////////////////////////\n");
                            userCart.getReceipt();
                            userCart.getStock().writeProductsToCSV("stock.csv");
                            break;
                        
                        case 2:
                            System.out.println("//////////////////////////////////////////////////YOUR ORDER HAVE BEEN CONFIRM////////////////////////////////////////////////////////////////\n");
                            userCart.getReceipt();
                            userCart.getStock().writeProductsToCSV("stock.csv");
                            break;


                        default:
                            System.out.println("\nINVALID INPUT PLEASE TRY AGAIN...\n");
                            break;     
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT PLEASE TRY AGAIN...");
            }
    
        }while(key!=0 && key != 1 &&  key != 2);           
    }


    //dicount
    public void discountProcess(){
        Scanner sc = new Scanner(System.in);
         System.out.println("YOU CAN TYPE '0' TO EXIT. \n");
        do{
        try{
            System.out.print("DISCOUNT CODE HERE>>> ");
            String key = sc.nextLine();

            if(key.equals("0")){
                System.out.println("///////////////////////////////////////////////////////////////EXITING////////////////////////////////////////////////////////////////////////////\n");
                checkingoutSession();
                break;
            }

            if(userCart.isdiscountValid(key)){
                System.out.println("\n////////////////////////////////////////////////////SUCCESFULLY USE DISCOUNT CODE/////////////////////////////////////////////////////////////////\n");
                this.confirmProcess();
                break;
            }
            


        }catch(Exception e){
            System.out.println("INPUT INVALID PLEASE TRY AGAIN...\n");
        }
    }while(true);

    }

    public void adminInstruction(){
        System.out.println("\nINSTRUCTION COMMAND\r\n" + //
                           "=============================================================================================================================================\r\n" + //
                           "'0' : BACK TO LOGIN MENU\r\n" + //
                           "'1' : ADDING PRODUCT TO STORE\r\n" + //
                           "'2' : REMOVING/REDUCING PRODUCT IN STORE\r\n" + //
                           "=============================================================================================================================================\n");
    Scanner sc = new Scanner(System.in);
    int key = -1; //initialize value to go in do-wkile loop;
        do{
            try {
                System.out.print("INPUT>>> ");
                String skey = sc.nextLine();
                key = Integer.parseInt(skey);
                
                switch(key){
                    case 0:
                        this.interactLogin();
                        break;
                        
                    case 1:
                        this.addingSession();
                        break;

                        
                    case 2:
                        this.removingSession();
                        break;

                    default:
                        System.out.println("\nINVALID INPUT PLEASE TRY AGAIN...\n");
                        break;
 
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT PLEASE TRY AGAIN...");
            }
    
        }while(key!=0 && key != 1 && key != 2);
    }

    




}
