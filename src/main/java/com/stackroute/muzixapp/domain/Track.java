package com.stackroute.muzixapp.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//make this class as hibernate entity
public class Track {
@Id
	private int id;

	private String name;

	private String comment;


}