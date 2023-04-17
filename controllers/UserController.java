package controllers;

import dtos.requests.RegisterRequest;
import dtos.responses.SignUpResponse;
import services.UserService;
import services.UserServiceImpl;

public class UserController {
    private UserService userService = new UserServiceImpl();

    public Object register(RegisterRequest registerRequest) {
        try {
            return userService.register(registerRequest);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Object signUp(SignUpResponse signUpResponse) {
        try {
            return userService.signUp(signUpResponse);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
