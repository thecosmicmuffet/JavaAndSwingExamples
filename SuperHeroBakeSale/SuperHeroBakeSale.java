enum IngredientType
{
    Starch,
    Fat,
    Sweet,
    Salty
}

class Ingredient {
    // How will we characterize ingredients?
}

class Recipe {
    Ingredient[] ingredients;
}

class SuperHeroBakeSale {
    public static void main(String args[]) 
    {
            byte someNumber = 3; // 8 bits 
            System.out.println(~someNumber);
            boolean isGreaterThanZero = someNumber > 0;
            boolean isWiderThanOneBit = someNumber >= 2;
            boolean isWiderThanTwoBits = someNumber >= 4;
            boolean isWiderThanThreeBits = someNumber >= 8;

            if(isGreaterThanZero)
            {
                if(isWiderThanOneBit)
                {
                    System.out.println("the number is wider than 1 bit");
                    if(isWiderThanTwoBits)
                    {
                        System.out.println("the number is wider than 2 bits");
                        
                        if(isWiderThanThreeBits)
                        {
                            // fill in
                        }
                    } 
                    else
                    {
                        if((someNumber & 1) == 1) // 11 & 1 == 01
                        {
                            System.out.println("the number is 3");
                        }
                        else
                        {
                            System.out.println("the number is 2");
                        }
                    }
                } 
                else
                {
                    System.out.println("the number is 1");
                }
            } 
            else
            {
                System.out.println("the number is 0");
            }

    }
}