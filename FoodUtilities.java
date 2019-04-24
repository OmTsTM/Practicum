/* 
    This class was made to facilitate and reduce the 
    processes that are used in Main.java
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class FoodUtilities {
    // Class Attributes
    private final ArrayList<Integer> values; // data structure used to manipulate the input
    private String str; // used for the input
    private String op; // op = morning or night
    private final Scanner sc; // used to read input data
    
    // Class Constructor
    public FoodUtilities() {
         this.values = new ArrayList<>();
         this.str = "";
         this.op = "";
         this.sc = new Scanner(System.in);
    }
    
    // Read the input from console
    public void readVect() {
        this.str = sc.nextLine();
		
		if ( this.str.equals("-1") ) {
			System.exit(0);
		}
		
        orderVect();
    }
    
    // Print the final answer
    public void printResult() {
        // Setup
        boolean error = false, m = false, n = false;
        boolean aux = false, aux2 = false;
        int count_err = 0, count_err2 = 0;
        int count_err3 = 0, count_err4 = 0;
      
        String [] morning_menu = {"eggs", "toast", "coffee"};
        String [] night_menu = {"steak", "potato", "wine", "cake"};
        m = this.op.toLowerCase().equals("morning");
        n = this.op.toLowerCase().equals("night");
        
        for (Integer v : this.values) {
            if ( (m) && ( (v >= 4) || count_err > 1 || (count_err2 > 1)) ) {
                error = true;
            } 
            else if ( (n) && ( (v > 4) || (count_err > 1) || 
                    (count_err3 > 1)  || (count_err4 > 1) )) {
                error = true;
                break;
            } else if ( (n) && (v >= 3) ) {
                if( v == 3 ) {
                    aux = true;
                    printPotato(count_err, count_err2, night_menu[1]);
 
                    if ( count_err2 == 0 ) {
                        System.out.print(night_menu[2]);
                    } else {
                        System.out.print(", " + night_menu[2]);
                    }
                } else if ( v == 4 ) {
                    if(!aux) {
                        aux2 = true;
                        printPotato(count_err, count_err2, night_menu[1]);
                    }
                    
                    if ( (count_err == 0) && (count_err2 == 0) && (count_err3 == 0) ) {
                        System.out.print(night_menu[3]);
                    } else {
                        System.out.print(", " + night_menu[3]);
                    } 

                    count_err4++;
                }
            }
            else {
                switch( v ) {
                    case 1:
                        if ( m ) {
                            System.out.print(morning_menu[0]);
                        } else if ( (n) && (count_err == 0) ) {
                            System.out.print(night_menu[0]);
                        }
                        
                        count_err++;
                    break;

                    case 2:
                        if ( m ) {
                            if ( count_err == 0 ) {
                                System.out.print(morning_menu[1]);
                            } else {
                                System.out.print(", " + morning_menu[1]);
                            }
                        }
   
                        count_err2++;
                    break;

                    case 3:
                        if ( m ) {
                            count_err3++;
                        }
                    break;
                    
                    case 4:
                    break;
        
                    default:
                        System.out.println("Something went wrong!");
                }
            }
        }
        
        if ( (n) && !(aux) && !(aux2) ) {
            printPotato(count_err, count_err2, night_menu[1]);
        }

        if ( m ) {
            if( (count_err > 0) || (count_err2 > 0) ) {
                if ( count_err3 == 1 ) {
                    System.out.print(", " + morning_menu[2]);
                } else if ( count_err3 > 1 ) {
                    System.out.print(", " + morning_menu[2] + "(x" + count_err3 + ")");
                }
            } else {
                if ( count_err3 == 1 ) {
                    System.out.print(morning_menu[2]);
                } else if ( count_err3 > 1 ) {
                    System.out.print(morning_menu[2] + "(x" + count_err3 + ")");
                }
            }
            
            if ( error ) {
                if ( (count_err > 0) || (count_err2 > 0) ) {
                    System.out.print(", error");
                }
                else {
                    System.out.print("error");
                }
            }
        } else { 
            if ( error ) {
                if( count_err > 0 ) {
                    System.out.print(", error");
                } else {
                    System.out.print("error");
                }
            }
        }

        System.out.print("\n");
    }
    
    /*
        An ordered Arraylist is generated containing all the input 
        splited by "," (separator used between items)
    
         **This array will be used for the final solution**
    */
    private void orderVect() {
        String [] values_s = this.str.replace(" ", "").split(",");
        this.op = values_s[0];
        
        /* 
            Here I'm using quicksort gived by "Array.sort" to sort the values 
            * ?(n log(n)) best case
            * O(n^2) worst case
        */
        Arrays.sort(values_s);
        
        this.values.clear();
        
        for (String v : values_s) {
            if( v.matches("-?\\d+(\\.\\d+)?") ) {
                this.values.add(Integer.parseInt(v));
            }
        }
    }
    
    /*
        This function is used in order to reduce the lines of code 
        I needed to use 3x the code block below
    */
    private void printPotato(int count_err, int count_err2, String night_menu) {
        if( count_err > 0 ) {
            if ( count_err2 == 1 ) {
                System.out.print(", " + night_menu);
            } else if ( count_err2 > 1 ) {
                System.out.print(", " + night_menu + "(x" + count_err2 + ")");
            }
        } else {
            if ( count_err2 == 1 ) {
                System.out.print(night_menu);
            } else if ( count_err2 > 1 ) {
                System.out.print(night_menu + "(x" + count_err2 + ")");
            }
        }
    }
}
