package org.kaspars.pasakumaBE.Services;

import java.util.List;
import java.util.Optional;

import org.kaspars.pasakumaBE.interfaces.UserServiceInterface;
import org.kaspars.pasakumaBE.model.UserDTO;
import org.kaspars.pasakumaBE.model.UserModel;
import org.kaspars.pasakumaBE.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class UserServices implements UserServiceInterface {
    private final UserRepository userRepository;

    public UserDTO findOrSaveUser(UserModel user) {
        try {
            Optional<UserModel> existingUser = userRepository.findByNameAndPassword(user.getName(), user.getPassword());
            if (existingUser.isPresent()) {
                return new UserDTO(existingUser.get().getId(), existingUser.get().getBookedEvents());

            } else {
                UserModel savedUser = userRepository.save(user);
                if (savedUser != null && savedUser.getId() != null) {
                    return new UserDTO(savedUser.getId(), 0);
                }
            }
        } catch (Exception e) {

        }
        return null; // Return null if user cannot be found or saved
    }

}
