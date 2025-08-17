package com.it.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor   // it will give parameterized and defualt constructor
public class Responses {
	private Integer id;
	private String Response;
}
