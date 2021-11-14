package project1.example.myThreads.threadLocalTest;

import java.util.UUID;

public class UserRepository {
    String getUserNameForUserId(Integer userId) {
        return UUID.randomUUID().toString();
    }
}
