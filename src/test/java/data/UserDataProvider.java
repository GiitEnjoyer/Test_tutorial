package data;

import model.User;
import java.util.Arrays;
import java.util.List;

public class UserDataProvider {
    public static List<User> getTestUsers() {
        return Arrays.asList(
                new User("technopol38", "technopolisPassword"),
                new User("invalid_user", "wrongpass")
        );
    }
}