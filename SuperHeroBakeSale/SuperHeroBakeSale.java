class Ingredient {

}

class Recipe {

}

class SuperHeroBakeSale {
    public static void main(String args[]) {
            int someNumber = 3;

            boolean isGreaterThanZero = someNumber > 0;
            boolean isGreaterThanOne = someNumber > 1;
            boolean isGreaterThanThree = someNumber > 3;
            //boolean isGreaterThan...

            if(isGreaterThanZero)
            {
                if(isGreaterThanOne)
                {
                    System.out.println("the number is wider than 1 bit");
                    if(isGreaterThanThree)
                    {
                        System.out.println("the number is wider than 2 bits");
                    } 
                    else
                    {
                        if(someNumber > 2)
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