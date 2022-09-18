package com.example.scoop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	int pnum;
	String uemail;
	int wsid;
	int key;
	String pnotice;
	String ptext;
	String pname;
	String powner;
	String pmember;
}
