package org.kaspars.pasakumaBE.Services;

import java.util.List;

import org.kaspars.pasakumaBE.model.UserModel;
import org.kaspars.pasakumaBE.repository.PasakumaInterface;
import org.springframework.stereotype.Service;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class UserServices {
    private final PasakumaInterface repository;

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    public List<UserModel> getAllUsers() {
        return repository.findAll();
    }

    public int addUser(UserModel user) {
        repository.save(user);
        return Math.toIntExact(user.getId());
    }

}
