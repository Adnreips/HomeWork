package project1.example.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * SimpleTextChat
 *
 * @author "Andrei Prokofiev"
 */
public class SimpleTextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    @Override
    public void sendMessage(String message, User user) {
        for(User u : users){
            if(u != user){
                u.getMessage(message);
            }
        }
        admin.getMessage(message);
    }

    public void addUserToChat(User user) {
        this.users.add(user);
    }
}
