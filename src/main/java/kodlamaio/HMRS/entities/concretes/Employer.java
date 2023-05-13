package kodlamaio.HMRS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(hidden = true)
    private int id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "web_site")
    private String webSite;
    @Column(name = "e_mail")
    private String eMail;
    @Column(name = "telephone")
    private String telephoneNumber;
    @Column(name = "password")
    private String password;
    @Column(name = "re_password")
    private String rePassword;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "e_mail_auth", referencedColumnName = "id")
    @JsonIgnore
    private EMailAuth eMailAuth;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hmrs_auth", referencedColumnName = "id")
    @Schema(hidden = true)
    private HmrsAuth hmrsAuth;
    @JsonManagedReference
    @OneToMany(mappedBy = "employer")
    @Schema(hidden = true)
    private List<JobAdvertisement> jobAdvertisements;
}
