package kodlamaio.HMRS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cv"})
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private int id;

    @ManyToOne()
    @JoinColumn(name = "cv_id", referencedColumnName = "id")
    @JsonBackReference
    private Cv cv;

    @Column(name = "company_name")
    @NotBlank
    @NotNull
    private String companyName;

    @Column(name = "position")
    @NotBlank
    @NotNull
    private String position;

    @Column(name = "entry_date")
    @NotBlank
    @NotNull
    private Date entryDate;

    @Column(name = "quit_date")
    private Date quitDate;
}
