package com.github.itsAkshayDubey.aopwithspringpart1.error;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

}
