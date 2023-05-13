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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "foreign_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cv"})
public class ForeignLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private int id;

    @ManyToOne()
    @JoinColumn(name = "cv_id", referencedColumnName = "id")
    @JsonBackReference
    private Cv cv;

    @Column(name = "language_name")
    @NotBlank
    @NotNull
    private String languageName;

    @Column(name = "level")
    @NotBlank
    @NotNull
    private int level;
}
