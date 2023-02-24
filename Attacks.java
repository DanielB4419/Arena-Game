import java.util.Random;

public class Attacks
{

    public static void spearAttackPreFight() //no effects
    {

    }
    public static int spearAttack(Character user)
    {
        int damage = 0;
        Random rndSpearAttack = new Random();
        damage = rndSpearAttack.nextInt(6+1)+ user.strength;
        System.out.printf("%s attacks with their spear. ", user.name);
        return damage;
    }
    public static void spearAttackPostFight(Character user, Character enemy) //no effects
    {

    }

    public static void shieldBashPreFight() //no effects
    {

    }
    public static int shieldBash(Character user)
    {
        int damage = 0;
        Random rndShieldBash = new Random();
        damage = rndShieldBash.nextInt(4+1)+ user.strength;
        System.out.printf("%s attacks with their shield. ", user.name);
        return damage;
    }
    public static void shieldBashPostFight(Character user, Character enemy) //no effects
    {
        System.out.println("User blocking pre attack: " + user.isBlocking());
        System.out.println("Enemy blocking pre attack: " + enemy.isBlocking());
        user.setToBlock();
        System.out.println("User blocking post attack: " + user.isBlocking());
        System.out.println("Enemy blocking post attack: " + enemy.isBlocking());
    }

    public static void doubleAttackPreFight() //no effects
    {

    }
    public static int doubleAttack(Character user)
    {
        int damage = 0;
        Random rndDoubleAttack1 = new Random();
        int attack1 = rndDoubleAttack1.nextInt(6+1) +user.strength;
        Random rndDoubleAttack2 = new Random();
        int attack2 = rndDoubleAttack2.nextInt(6+1) +user.strength;
        damage = attack1 + attack2;
        System.out.printf("%s attacks twice. ", user.name);
        return damage;
    }
    public static void doubleAttackPostFight(Character user, Character enemy) //no effects
    {

    }

}
