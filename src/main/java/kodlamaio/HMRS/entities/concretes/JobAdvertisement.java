package kodlamaio.HMRS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne()
    @JoinColumn(name = "title")
    private Title title;
    @ManyToOne()
    @JoinColumn(name = "city")
    private City city;
    @Column(name = "min_salary")
    private BigDecimal minSalary;
    @Column(name = "max_salary")
    private BigDecimal maxSalary;
    @Column(name = "open_position")
    private int openPosition;
    @Column(name = "application_deadline")
    private Date applicationDeadline;
    @Column(name = "is_open")
    private boolean isOpen;
    @Column(name = "job_desc")
    private String jobDesc;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "employer")
    private Employer employer;
}