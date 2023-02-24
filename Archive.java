import java.util.Random;

public class Archive
{

    /*

    player.displayInfo();
        enemy.displayInfo();
        Formatting.printSeparator(30);
        while (true)    //loop until player.isDead() or enemy.isDead()
    {
        player.showHealth();
        enemy.showHealth();
        System.out.println();
        int option = Formatting.inFightOptions();
        if (option == 1)    //FIGHT
        {

            if (player.preFightStatusCheck() && enemy.preFightStatusCheck())
            {
                player.pickAndPrepAttack(player);
                enemy.pickAndPrepAttack(enemy);
                turnOrder(enemy);
            } else if (player.preFightStatusCheck() && !enemy.preFightStatusCheck())
            {
                player.pickAndPrepAttack(player);
            } else
            {
                enemy.pickAndPrepAttack(enemy);
            }


            System.out.println();
            Formatting.typeToContinue();
        }
        if (option == 2)    //POTION
        {
            //add 50 to health
            System.out.println("You drink a potion restoring: " + " health.");
        }
        if (option == 3)     //RUN AWAY
        {
            if (act == 5)       //cannot run if in act 5
            {
                System.out.println("You cannot run away from the final boss!");
                Formatting.typeToContinue();
            } else                //attempt to flee
            {
                Random rnd = new Random();
                int rndEscape = rnd.nextInt(100) + 1;
                if (rndEscape <= escapeChance)  //successful escape chance
                {
                    System.out.println("You successfully ran away from " + enemy.name + "!");
                    Formatting.typeToContinue();
                    break;
                } else                      //or take damage
                {
                    System.out.println("You did not escape from " + enemy.name);
                    int damage = enemy.pickAndPrepAttack(enemy);
                    enemy.attack(player, enemy, damage);
                    System.out.println("You took damage trying to run away.");
                    if (player.isDead())    //exit game/loop
                    {
                        System.out.println("You died.");
                        gameRunning = false;
                    }
                }
            }
        }
    }*/
}
