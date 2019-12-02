package org.staxter;

public class App {

    public static void main(String[] args) {

        Mediator playerMediator = new PlayerMediator();

        Player player1 = new PlayerInitiator("Player1");
        playerMediator.registerPlayer(player1);

        Player player2 = new Player("Player2");
        playerMediator.registerPlayer(player2);

        player1.sendMessage("Player2", "Whats Up?");
    }

}
