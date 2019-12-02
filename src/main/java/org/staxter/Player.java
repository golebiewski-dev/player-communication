package org.staxter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {

    Logger playerLogger;
    String name;
    Mediator mediator;

    public Player(String name) {
        this.name = name;
        playerLogger = Logger.getLogger(this.getClass().getName());
    }

    public String getName() {
        return this.name;
    }

    public void registerMediator(PlayerMediator playerMediator) {
        this.mediator = playerMediator;
    }

    public void unregisterMediator() {
        this.mediator = null;
    }

    public void sendMessage(String receiverName, String message) {
        playerLogger.log(Level.INFO, () -> this.getName() + " sent message to " + receiverName + ": " + message);
        mediator.send(new Message(this.getName(), receiverName, message));
    }

    public void receiveMessage(Message message) {
        playerLogger.log(Level.INFO, () -> this.getName() + " has received a message from " + message.getSender() + ": " + message.getContent());
        reply(message);
    }

    public void reply(Message message) {
        this.sendMessage(message.getSender(), message.getContent());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (playerLogger != null ? !playerLogger.equals(player.playerLogger) : player.playerLogger != null)
            return false;
        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        return mediator != null ? mediator.equals(player.mediator) : player.mediator == null;
    }

    @Override
    public int hashCode() {
        int result = playerLogger != null ? playerLogger.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mediator != null ? mediator.hashCode() : 0);
        return result;
    }
}
