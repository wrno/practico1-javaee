package tse2023.grupo16.practico1.negocios;

import java.util.ArrayList;

import javax.ejb.Remote;

import tse2023.grupo16.practico1.datatypes.DtCiudadano;

@Remote
public interface CiudadanoNegocioRemote {
	public void registrarCiudadano(String email, int ci) throws Exception;
	public void modificarEmail(String emailOriginal, String emailNuevo) throws Exception;
	public void modificarCi(int ciOriginal, int ciNueva) throws Exception;
	public void eliminarCiudadanoEmail(String email) throws Exception;
	public void eliminarCiudadanoCi(int ci) throws Exception;
	public ArrayList<DtCiudadano> listarCiudadanos() throws Exception;
	public DtCiudadano buscarCiudadanoCi(int ci) throws Exception;
	public DtCiudadano buscarCiudadanoEmail(String email) throws Exception;
}
