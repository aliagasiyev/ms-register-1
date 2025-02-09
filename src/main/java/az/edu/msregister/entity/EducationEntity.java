//package az.edu.msregister.entity;
//
//import az.edu.msregister.enums.EducationLevel;
//import az.edu.msregister.enums.SpecializationType;
//import az.edu.msregister.enums.University;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@Entity
//@Table(name = "education")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class EducationEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ElementCollection
//    @CollectionTable(name = "education_universities", joinColumns = @JoinColumn(name = "education_id"))
//    @Enumerated(EnumType.STRING)
//    @Column(name = "university")
//    private List<University> universities;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private SpecializationType specialization;
//
//    @Column(nullable = false)
//    private String course;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private EducationLevel level;
//
//    @Column(nullable = false)
//    private Double totalPayment;
//
//    @Column(nullable = false)
//    private Integer paymentMonths;
//}
