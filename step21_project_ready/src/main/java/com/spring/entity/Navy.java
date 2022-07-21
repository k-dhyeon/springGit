package com.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.dto.TestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor

@EntityListeners(AuditingEntityListener.class) // 생성일/수정일/생성자를 자동화할 때 사용하는게 바로 JPA Auditing 
@ToString
@Builder
public class Navy {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long number;

@Column(name = "name")
private String name;

private String sign;

private String classes;

//@CreatedDate
//private LocalDateTime createdDate;



public TestDTO toDTO(Navy te) {
	TestDTO td = TestDTO.builder()
			.number(te.getNumber())
			.name(te.getName())
			.sign(te.getSign())
			.classes(te.getClasses())
			.build();
	return td;
}

}

