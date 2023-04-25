package tse2023.grupo16.practico1.entidades;

import java.time.LocalDate;

public class Ciudadano {
	String email;
	int ci;
	LocalDate fechaAlta;
	
	public Ciudadano(String email, int ci) {
		this.email = email;
		this.ci = ci;
		this.fechaAlta = LocalDate.now();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
