package com.patterns.flyweight.data.implementation;

import com.patterns.flyweight.data.interfaces.IPlayer;

import java.util.HashMap;


public class PlayerFactory {


    private static HashMap<Player, IPlayer> players = new HashMap<>();

    public static IPlayer getPlayer(Player playerType) {

        System.err.println("Player pool size " + players.size());

        if (players.containsKey(playerType)) {
            return players.get(playerType);
        } else {

            if (Player.SpecialForce.equals(playerType)) {

                System.err.println("Creating Special Force");
                SpecialForce player = new SpecialForce();
                players.put(Player.SpecialForce, player);
                return player;
            } else if (Player.Terrorist.equals(playerType)) {

                System.err.println("Creating Terrorist");
                Terrorist player = new Terrorist();
                players.put(Player.Terrorist, player);

                return player;
            } else {
                throw new RuntimeException("Invalid Player Type");
            }

        }

    }

}

class SpecialForce implements IPlayer {

    private String TASK;

    private String weapon;

    public SpecialForce() {
        this.TASK = "diffuse the bomb";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void performMission() {

        System.out.println("With " + this.weapon + " I complete " + this.TASK);

    }
}

class Terrorist implements IPlayer {

    private String TASK;

    private String weapon;

    public Terrorist() {
        this.TASK = "Plant the Bomb";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void performMission() {

        System.out.println("With " + this.weapon + " I " + this.TASK);

    }
}
