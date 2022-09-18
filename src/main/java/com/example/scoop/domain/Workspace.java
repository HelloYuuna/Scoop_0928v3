package com.example.scoop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workspace {

	int wsid;
	String wsname;
	String wsowner;
	String lately;
}
