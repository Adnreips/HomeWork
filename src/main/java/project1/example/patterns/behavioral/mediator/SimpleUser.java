package project1.example.patterns.behavioral.mediator;

/**
 * SimpleUser
 *
 * @author "Andrei Prokofiev"
 */
public class SimpleUser implements User {
    Chat chat;
    String name;

    public SimpleUser(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public String toString() {
        return "SimpleUser{" +
                "chat=" + chat +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.name + " receiving message: " + message + ".");
    }
}
