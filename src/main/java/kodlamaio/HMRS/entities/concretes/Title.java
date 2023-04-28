package kodlamaio.HMRS.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "titles")
public class Title {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int Id;
    @Column(name = "title")
    private String Title;
}
