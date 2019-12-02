package org.staxter;

import java.util.HashMap;
import java.util.Map;

public class PlayerMediator implements Mediator {

    Map<String, Player> players = new HashMap<>();

    @Override
    public void send(Message message) {
        players.get(message.getReceiver()).receiveMessage(message);
    }

    public void registerPlayer(Player player){
        players.put(player.getName(), player);
        player.registerMediator(this);
    }

    public void unregisterPlayer(Player player){
        player.unregisterMediator();
        players.remove(player);
    }

}
