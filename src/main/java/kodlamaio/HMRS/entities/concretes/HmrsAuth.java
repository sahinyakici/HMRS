package kodlamaio.HMRS.entities.concretes;

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
public class HmrsAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "verified_date")
    private Date verified_date;
    @Column(name = "verified_employee")
    private int verifiedEmployee;
    @Column(name = "is_verified")
    private boolean isVerified;
}
