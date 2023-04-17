package data.repositories;

import data.models.Email;
import data.models.User;
import dtos.responses.SignUpResponse;

import java.util.List;

public interface UserRepository {

    User create(User user);
    void delete(User user);
    long count();
    void deleteAll();
    User findEmailAddress(String emailAddress);
    User findAccount(SignUpResponse signUpResponse);

}
