package org.kaspars.pasakumaBE.repository;

import org.kaspars.pasakumaBE.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Lai spring boot zinatu ka tas ir repository interface un vispār redzētu šo
            // interfeisu
public interface PasakumaInterface extends JpaRepository<UserModel, Long> { // RepositoryInterface komunicēs pa tiešo ar
                                                                            // datubāzi. Kvēriji nav jāraksta, to dara
                                                                            // springboot

}
