package org.kaspars.pasakumaBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.kaspars.pasakumaBE.model.PasakumaModel;

@Repository
public interface PasakumaRepository extends JpaRepository<PasakumaModel, Long> {

}
