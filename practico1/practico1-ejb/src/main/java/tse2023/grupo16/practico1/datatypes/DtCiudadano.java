package tse2023.grupo16.practico1.datatypes;

import java.io.Serializable;
import java.time.LocalDate;

public class DtCiudadano implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String email;
	int ci;
	LocalDate fechaAlta;

	public DtCiudadano(String email, int ci, LocalDate fechaAlta) {
		super();
		this.email = email;
		this.ci = ci;
		this.fechaAlta = fechaAlta;
	}

	public String getEmail() {
		return email;
	}

	public int getCi() {
		return ci;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
}
