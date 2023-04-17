package services;
import data.models.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.requests.RegisterRequest;
import dtos.responses.SignUpResponse;
import org.jetbrains.annotations.NotNull;
import utils.Mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl();
    User user = new User();


    @Override
    public User register(RegisterRequest registerRequest) {
        emailAddressExist(registerRequest.getEmailAddress());
        phoneNumberExist(registerRequest.getPhoneNumber());
        validatePasswordForEmailRegistration(registerRequest.getPassword());

        return userRepository.create(Mapper.map(registerRequest));
    }



    private boolean registrationSuccessful(RegisterRequest registerRequest) {

        //validateDateOfBirth(registerRequest);
        return true;
    }

    private void validateDateOfBirth(RegisterRequest registerRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime dateOfBirth = LocalDateTime.parse(registerRequest.getDateOfBirth(),formatter);

        if (dateOfBirth.isAfter(currentDate))
            System.out.println("Date of Birth can not be in the future");
    }



    private boolean thisUserExist(String emailAddress) {
        User foundUser = userRepository.findEmailAddress(emailAddress);
        if (foundUser != null) return true;
        return false;
    }

    @Override
    public SignUpResponse signUp(SignUpResponse signUpResponse) {
        User foundAccount = userRepository.findAccount(signUpResponse);
        SignUpResponse response = new SignUpResponse();
        Mapper.map(foundAccount, response);
        return response;

    }

    private void passwordExist(String password) {
        if (Objects.equals(password, user.getEmailAddress()))
            throw new IllegalArgumentException("Email Address Exist");
    }

    private void validatePasswordForEmailRegistration(@NotNull String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{6,}$";
        if (!password.matches(passwordRegex))
            throw new IllegalArgumentException("""
                    ** Password must contain uppercase
                    ** Password must contain lowercase
                    ** Password must contain letter
                    ** Password must be length 8
                    ** At least 1 special character from the set !@#$%^&*""");
    }

    private void phoneNumberExist(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty())
            throw new IllegalArgumentException("Phone number can not be empty");

        if (phoneNumber.length() != 11)
            throw new IllegalArgumentException("Length 11 required for phone number");

        if (Objects.equals(phoneNumber, user.getPhoneNumber()))
            throw new IllegalArgumentException(phoneNumber + "already exist");
    }


    private void emailAddressExist(String emailAddress) {
        if (emailAddress == null || emailAddress.isEmpty()) {
            throw new IllegalArgumentException("Email address cannot be null or empty");
        }

        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (!emailAddress.matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email address format");
        }

        if (Objects.equals(emailAddress, user.getEmailAddress()))
            throw new IllegalArgumentException("Email Address Exist");
    }
}
