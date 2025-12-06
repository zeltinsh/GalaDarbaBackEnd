package org.kaspars.pasakumaBE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class PasakumaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long id;
    String pasakumaNosaukums;
    String pasakumaDatums;
    String pasakumaVieta;
    String pasakumaApraksts;
    String pasakumaLaiks;
    Integer dalibniekuSkaits;

}
