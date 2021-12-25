package nazeem.web.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="staff")
public class Staff {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
	private Long staffId;
	
	@Column(name = "staff_name")
	private String staffName;
	
	@Column(name = "staff_skills")
	private String staffSkills;
	
	@Column(name = "staff_status")
	private String staffStatus; //E.g Intern, Staff
	
//	@Column(name = "product_id")
//    @NotNull(message = "Select Item!")
//    private Integer product_id;
	
	@Column(name = "jobs_assigned")
	private int jobsAssigned;
	
	@Column(name = "contact")
	private String contact;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)         
	@Column(name = "dateAssigned")
	private LocalDateTime dateAssigned;

}
