package com.webApp.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * Created by connected on 2/6/17.
 */
public class Message {

    private final UUID guid;
    private final String owner;
    private final String recipient;
    private final String text;
    private final LocalDateTime dateTimeOfSend;

    public Message(final UUID guid, String owner, final String recipient, final LocalDateTime dateTimeOfSend, final String text) {
        this.guid = guid;
        this.owner = owner;
        this.recipient = recipient;
        this.dateTimeOfSend = dateTimeOfSend;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Message message = (Message) o;

        if (guid != null ? !guid.equals(message.guid) : message.guid != null) {
            return false;
        }
        if (owner != null ? !owner.equals(message.owner) : message.owner != null) {
            return false;
        }
        if (recipient != null ? !recipient.equals(message.recipient) : message.recipient != null) {
            return false;
        }
        return dateTimeOfSend != null ? dateTimeOfSend.equals(message.dateTimeOfSend) : message.dateTimeOfSend == null;
    }

    @Override
    public int hashCode() {
        int result = guid != null ? guid.hashCode() : 0;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (recipient != null ? recipient.hashCode() : 0);
        result = 31 * result + (dateTimeOfSend != null ? dateTimeOfSend.hashCode() : 0);
        return result;
    }

    public UUID getGuid() {
        return guid;
    }

    public String getOwner() {
        return owner;
    }

    public String getRecipient() {
        return recipient;
    }

    public LocalDateTime getDateTimeOfSend() {
        return dateTimeOfSend;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public static Message generateMessage() {
        final String[] person = {"Pedro", "Bruna", "Ana", "Candice", "Paulo", "Eduardo", ""};
        final String[] pronouns = {"Eu", "Tu", "Ele", "Nos", "Vos", "Eles"};
        final String[] action = {"comi", "nadei", "surfei", "morei", "imaginei", "boiei", "gamei"};
        final String[] on = {"casa", "mar", "bacon", "de baixo da ponte", "na agua", "com veneno"};

        final Random random = new Random();

        final StringBuilder phrase = new StringBuilder();

        phrase.append(person[random.nextInt(person.length - 1)]);
        phrase.append(", ");
        phrase.append(pronouns[random.nextInt(pronouns.length - 1)]);
        phrase.append(" ");
        phrase.append(action[random.nextInt(action.length - 1)]);
        phrase.append(" ");
        phrase.append(on[random.nextInt(on.length - 1)]);


        return new Message(UUID.randomUUID(), person[random.nextInt(person.length - 2)], person[random.nextInt(person.length - 2)], LocalDateTime.now(), phrase.toString());
    }
}

