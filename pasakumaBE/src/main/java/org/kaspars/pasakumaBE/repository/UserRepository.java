package org.kaspars.pasakumaBE.repository;

import java.util.Optional;

import org.kaspars.pasakumaBE.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Lai spring boot zinatu ka tas ir repository interface un vispār redzētu šo
            // interfeisu
public interface UserRepository extends JpaRepository<UserModel, Long> { // RepositoryInterface komunicēs pa tiešo ar
                                                                         // datubāzi.
    Optional<UserModel> findByNameAndPassword(String name, String password); // Meklē lietotāju pēc vārda un paroles

}
