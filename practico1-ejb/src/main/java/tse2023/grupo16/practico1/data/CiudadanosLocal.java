package tse2023.grupo16.practico1.data;

import java.util.ArrayList;

import javax.ejb.Local;

import tse2023.grupo16.practico1.datatypes.DtCiudadano;

@Local
public interface CiudadanosLocal {
	public boolean existeCiudadanoEmail(String email);
	public boolean existeCiudadanoCi(int ci);
	public void registrarCiudadano(String email, int ci);
	public void modificarEmail(String emailOriginal, String emailNuevo);
	public void modificarCi(int ciOriginal, int ciNueva);
	public void eliminarCiudadano(String email);
	public void eliminarCiudadano(int ci);
	public ArrayList<DtCiudadano> listarCiudadanos() throws Exception;
	public DtCiudadano buscarCiudadanoEmail(String email) throws Exception;
	public DtCiudadano buscarCiudadanoCi(int ci) throws Exception;
}
