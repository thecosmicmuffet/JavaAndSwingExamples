import Ingredients.IngredientType;

class Ingredient {
    // How will we characterize ingredients?
    int uses;
    IngredientType ingredientTypes; // starchy (2) AND salty(32) 0010 0010

}

class Recipe {
    Ingredient[] ingredients;
    int[] quantities;

    Recipe(){
        ingredients[0] = new Ingredient();
    }
}

class SuperHeroBakeSale {
    public static void main(String args[]) 
    {
        // The current goal of this program is to print a value out in binary
        System.out.println("Welcome to Program");
        byte someNumber = 103;//      0110 0111 This is what we should print out

        // 8 bits 0000 0000
        //        0110 0111
        String output = "";
        while(someNumber != 0) // 0000 0000
        {
                                              // 0110 0111 : someNumber initial value
            var bitwiseTest = someNumber & 1; // 0000 0001 : binary representation of 1
            // Take result of bitwise test and add it to the end of the output
            output = output.concat(Integer.toString(bitwiseTest));
            System.out.println(output); 
            someNumber = (byte)(someNumber >> 1);// 00110 011
        }
        System.out.println();
        System.out.println("Program Done");
    }
}

// 0000 0000 0000 0000 0000 0000 0000 0001  1
// 1111 1111 1111 1111 1111 1111 1111 1111  -1