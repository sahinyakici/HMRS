package kodlamaio.HMRS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(hidden = true)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @OneToMany(mappedBy = "cv", targetEntity = School.class, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<School> schools;

    @OneToMany(mappedBy = "cv", targetEntity = Job.class, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Job> jobs;

    @OneToMany(mappedBy = "cv", targetEntity = ForeignLanguage.class, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ForeignLanguage> foreignLanguages;

    @Column(name = "photo_link")
    private String photoLink;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "technologie")
    private String technologies;

    @Column(name = "resume")
    private String resume;
}
