import java.util.Random;

public class Names
{

    public static String randomOrcName()
    {
        String nameArray [] = {"Ogrul","Vrikdarok","Yadba","Inkathu",
                "Magra","Gutjja","Sargulg","Xurug","Smaghed","Dubok"};
        Random rnd = new Random();
        int rndArrayName = rnd.nextInt(nameArray.length);
        String rndName = nameArray[rndArrayName];
        return rndName;
    }

    public static String randomGoblinNames()
    {
        String nameArray [] = {"Snot","Stuchuk","Mudrok","Dillelk","Krug",
                "Sickfoot","Moldteeth","Birdbrain","Maggot","Shrillmug"};
        Random rnd = new Random();
        int rndArrayName = rnd.nextInt(nameArray.length);
        String rndName = nameArray[rndArrayName];
        return rndName;
    }


}
