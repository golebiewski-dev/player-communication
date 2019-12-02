package org.staxter;

public interface Mediator {

    void send(Message message);

    void registerPlayer(Player player);

    void unregisterPlayer(Player player);

}
