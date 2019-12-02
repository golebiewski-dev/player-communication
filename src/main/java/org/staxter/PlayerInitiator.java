package org.staxter;

import java.util.logging.Level;

public class PlayerInitiator extends Player {

    private int counter = 0;

    public PlayerInitiator(String name) {
        super(name);
    }

    @Override
    public void receiveMessage(Message message) {
        playerLogger.log(Level.INFO, () -> this.getName() + " has received a message from " + message.getSender() + ": " + message.getContent());
        if (this.shouldStop()) {
            mediator.unregisterPlayer(this);
        } else {
            reply(message);
        }
    }

    private boolean shouldStop() {
        counter++;
        return counter == 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PlayerInitiator that = (PlayerInitiator) o;

        return counter == that.counter;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + counter;
        return result;
    }
}
