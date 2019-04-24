public class Program {
    public static void main(String[] args) {
        FoodUtilities fd = new FoodUtilities();
        
        // Loop for the input
        while ( true ) {
            fd.readVect();
            fd.printResult();
        }
    }
}
