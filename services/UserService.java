package services;

import data.models.Email;
import data.models.User;
import dtos.requests.RegisterRequest;
import dtos.responses.SignUpResponse;

public interface UserService {

    User register(RegisterRequest registerRequest);

    SignUpResponse signUp(SignUpResponse signUpResponse);

}
