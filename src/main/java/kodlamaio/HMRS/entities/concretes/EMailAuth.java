package kodlamaio.HMRS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Table(name = "e_mail_auths")
@AllArgsConstructor
@NoArgsConstructor
public class EMailAuth {
    @Id
    @Column(name = "id")
    @Schema(hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "is_verified")
    private boolean isVerified;
    @Column(name = "verified_date")
    private Date verifiedDate;
    @OneToOne(mappedBy = "eMailAuth")
    @JsonIgnore
    private Candidate candidate;
}
