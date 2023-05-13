package kodlamaio.HMRS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hmrs_auths")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "employer", "hmrsEmployee"})
public class HmrsAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(hidden = true)
    private int id;
    @Column(name = "verified_date")
    private Date verified_date;
    @Column(name = "is_verified")
    private boolean isVerified;
    @OneToOne(mappedBy = "hmrsAuth")
    private Employer employer;
    @ManyToOne()
    @JoinColumn(name = "verified_employee")
    private HmrsEmployee hmrsEmployee;
}
