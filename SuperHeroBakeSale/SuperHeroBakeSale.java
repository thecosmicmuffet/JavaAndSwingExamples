import Ingredients.IngredientType;

class Ingredient {
    // How will we characterize ingredients?
    int uses;
    IngredientType ingredientTypes; // starchy (2) AND salty(32) 0010 0010

}

class Recipe {
    Ingredient[] ingredients;
    int[] quantities;
}

class SuperHeroBakeSale {
    public static void main(String args[]) 
    {
        System.out.println("Welcome to Program");
            byte someNumber = 103;
            Recipe test;
            // 8 bits 0000 0000
            //        0110 0111
            while(someNumber != 0) // 0000 0000
            {
                                                //      0110 0111 : someNumber
                System.out.print(someNumber & 1); //    0000 0001
                someNumber = (byte)(someNumber >> 1);// 00110 011
            }
            System.out.println();
            System.out.println("Program Done");
    }
}

// 0000 0000 0000 0000 0000 0000 0000 0001  1
// 1111 1111 1111 1111 1111 1111 1111 1111  -1