package data.repositories;

import data.models.Email;
import data.models.User;
import dtos.responses.SignUpResponse;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private int count;
    ArrayList<User> users = new ArrayList<>();

    public UserRepositoryImpl() {

    }


    @Override
    public User create(User user) {
        if (user.getUserId() == 0) {
            user.setUserId(generateUserId());
            users.add(user);
            count++;
        }
        return user;
    }



    private int generateUserId() {
        return count + 1;
    }

    @Override
    public void delete(User user) {
        for (User user1 : users) {
            if (user1.toString().equals(user.getFirstName())) {
                users.remove(user);
                break;
                }
        }
        count--;

    }


    @Override
    public long count() {
        return count;
    }

    @Override
    public void deleteAll() {
        for (int i = 0; i < users.size(); i++) {
            users.remove(users.get(i));
        }
        count = 0;

    }

    @Override
    public User findEmailAddress(String emailAddress) {
        for (User user: users) {
            if (user.getEmailAddress().equalsIgnoreCase(emailAddress)) return user;
        }
        return null;
    }

    @Override
    public User findAccount(SignUpResponse signUpResponse) {
        for (User user: users)
            if (user.getEmailAddress().equalsIgnoreCase(signUpResponse.getEmailAddress()) &&
                    user.getPassword().equals(signUpResponse.getPassword())) return user;

        throw new IllegalArgumentException("Invalid Argument");
    }

}

