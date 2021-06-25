package com.skcc.parkingsk.review.domain.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skcc.parkingsk.review.domain.enums.StarPoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="review")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "review_date")
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    private LocalDateTime reviewDate = LocalDateTime.now();

//	@Embedded
//	private Reviewer reviewer;	
	@Column(name = "reviwer_id")	
	//private Long reviewerId;
	private String reviewerId;
	
	@Column(name = "reviewer_name")
	private String reviewerName;

	@Column(name = "parking_lot_id")
	private Long parkingLotId;
	
	@Column(name = "parking_lot_name")
	private String parkingLotName;
	
	@Column(name = "contents")
	private String contents;
	
	@Column(name = "star_point")
	@Enumerated(EnumType.STRING)
	private StarPoint starPoint;
        
 }

	
