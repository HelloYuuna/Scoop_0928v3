package com.example.scoop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {
	String title;
	String text;
	String star;
	String end;
	String allday;
	int wsid;
}
