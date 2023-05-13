package kodlamaio.HMRS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Table(name = "mernis_auths")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "candidate", "id"})
public class MernisAuth {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "is_verified")
    private boolean isVerified;
    @Column(name = "auth_date")
    private Date authDate;
    @OneToOne(mappedBy = "mernisAuth")
    @Schema(hidden = true)
    private Candidate candidate;
}
