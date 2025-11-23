package org.kaspars.pasakumaBE.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok anotacija, kas izveido visus geterus, seterus, toString, equals,
@AllArgsConstructor // Lombok anotacija, kas izveido visus geterus, seterus, toString, equals,
@Entity // Lai spring boot zinatu ka tas ir entitets. Entity nāk no jpa
@Table(name = "users") // Nosaucam tabulu users
@NoArgsConstructor // Lombok anotacija, kas izveido bezargumentu konstruktoru

public class UserModel { // Sis ir domens. UserModel
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Lai id butu auto increment
    @Column(name = "id")
    private Long id; // Long ir wrapper klase, jo var buti null
    @Column(name = "name") // Lietotāja vārds
    @NotBlank(message = "Name cannot be blank") // Validācijas anotācija, kas nodrošina, ka lauks nav tukšs
    private String name; // String ir reference klase, jo nevar buti null
    @Column(name = "password")
    @NotBlank(message = "Password cannot be blank")
    private String password; // String ir reference klase, jo nevar buti null
}
