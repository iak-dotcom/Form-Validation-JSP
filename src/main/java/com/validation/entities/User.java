package com.validation.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;



import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter @Setter @NoArgsConstructor
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "must not be empty")
	@Size(min = 3, max = 50)
	private String name;

	@NotNull
	@Email(message = "Please enter a valid e-mail address")
	private String email;
	
	@NotBlank
	private String gender;
	
	@Size(min = 8, max = 15)
	private String password;
	
	@NotBlank
	private String profession;
	
	@Size(max = 100)
	private String note;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birthday;
	
	@AssertTrue
	private boolean married;
	
	@Min(value = 20_000)
	@Max(value = 300_000)
	private long income;
	
}
