package com.rah.demo.crudrepaso.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class UserModel {

	private Integer index;
	private Integer documento;
	private String nombre;
	private String apellido;
	private Integer edad;

	private List<DireccionModel> direcciones;
}
