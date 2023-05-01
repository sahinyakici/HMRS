package kodlamaio.HMRS.entities.concretes;

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
public class MernisAuth {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "is_verified")
    private boolean isVerified;
    @Column(name = "auth_date")
    private Date auth_date;
}
