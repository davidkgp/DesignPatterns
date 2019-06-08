import com.patterns.flyweight.data.implementation.Player;
import com.patterns.flyweight.data.implementation.PlayerFactory;
import com.patterns.flyweight.data.interfaces.IPlayer;

import java.util.Random;

public class TriggerClass {


    private static Player[] playerTypes =
            {Player.SpecialForce, Player.Terrorist};
    private static String[] weapons =
            {"AK-47", "Maverick", "Gut Knife", "Desert Eagle"};


    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {

            IPlayer player = PlayerFactory.getPlayer(getRandPlayerType());
            System.out.println(player);
            player.assignWeapon(getRandWeapon());
            player.performMission();

        }

    }

    public static Player getRandPlayerType() {
        Random r = new Random();

        // Will return an integer between [0,2)
        int randInt = r.nextInt(playerTypes.length);

        // return the player stored at index 'randInt'
        return playerTypes[randInt];
    }

    public static String getRandWeapon() {
        Random r = new Random();

        // Will return an integer between [0,5)
        int randInt = r.nextInt(weapons.length);

        // Return the weapon stored at index 'randInt'
        return weapons[randInt];
    }


}
