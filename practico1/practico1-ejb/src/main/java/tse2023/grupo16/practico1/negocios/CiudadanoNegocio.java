package tse2023.grupo16.practico1.negocios;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tse2023.grupo16.practico1.data.CiudadanosLocal;
import tse2023.grupo16.practico1.datatypes.DtCiudadano;

/**
 * Session Bean implementation class CiudadanoNegocio
 */
@Stateless
@LocalBean
public class CiudadanoNegocio implements CiudadanoNegocioRemote, CiudadanoNegocioLocal {
	@EJB CiudadanosLocal ciudadanos;
	
    /**
     * Default constructor. 
     */
    public CiudadanoNegocio() {
        // TODO Auto-generated constructor stub
    }

    public void registrarCiudadano(String email, int ci) throws Exception{
    	if(!(email.isEmpty()) && ci > 0) {
    		if(email.contains("@") && email.indexOf("@") > 0 && email.substring(email.indexOf("@"), email.length()).contains(".com")) {
    			if(ci >= 10000000) {
    				if(!(ciudadanos.existeCiudadanoEmail(email)) && !(ciudadanos.existeCiudadanoCi(ci))) {
    					ciudadanos.registrarCiudadano(email, ci);
    				}else {
    					throw new Exception("Ya existe alguien registrado con ese e-mail o cédula.");
    				}
    			}else {
    				throw new Exception("Cédula no válida.");
    			}
    		}else {
    			throw new Exception("E-mail no válido.");
    		}
    	}else {
    		throw new Exception("Debe ingresar e-mail y cédula.");
    	}
    }
    
    public void modificarEmail(String emailOriginal, String emailNuevo) throws Exception{
    	if(ciudadanos.existeCiudadanoEmail(emailOriginal)) {
    		if(!(emailNuevo.isEmpty())){
    			if(emailNuevo.contains("@") && emailNuevo.indexOf("@") > 0 && emailNuevo.substring(emailNuevo.indexOf("@"), emailNuevo.length()).contains(".com")) {
    				ciudadanos.modificarEmail(emailOriginal, emailNuevo);
    			}else {
    				throw new Exception("E-mail no válido.");
    			}
    		}else {
    			throw new Exception("Debe ingresar un e-mail.");
    		}
    	}else {
    		throw new Exception("No existen ciudadanos registrados con ese e-mail.");
    	}
    }
    
    public void modificarCi(int ciOriginal, int ciNueva) throws Exception{
    	if(ciudadanos.existeCiudadanoCi(ciOriginal)) {
    		if(ciNueva > 0) {
    			if(ciNueva >= 10000000) {
    				ciudadanos.modificarCi(ciOriginal, ciNueva);
    			}else {
    				throw new Exception("Cédula no válida.");
    			}
    		}else {
    			throw new Exception("Debe ingresar una cédula.");
    		}
    	}else {
    		throw new Exception("No existen ciudadanos registrados con esa cédula.");
    	}
    }
    
    public void eliminarCiudadanoEmail(String email) throws Exception{
    	if(ciudadanos.existeCiudadanoEmail(email)) {
    		ciudadanos.eliminarCiudadano(email);
    	}else {
    		throw new Exception("No existen ciudadanos registrados con ese e-mail.");
    	}
    }
    
    public void eliminarCiudadanoCi(int ci) throws Exception{
    	if(ciudadanos.existeCiudadanoCi(ci)) {
    		ciudadanos.eliminarCiudadano(ci);
    	}else {
    		throw new Exception("No existen ciudadanos registrados con esa cédula.");
    	}
    }
    
    public ArrayList<DtCiudadano> listarCiudadanos() throws Exception{
    	return ciudadanos.listarCiudadanos();
    }
    
    public DtCiudadano buscarCiudadanoCi(int ci) throws Exception{
    	return ciudadanos.buscarCiudadanoCi(ci);
    }
    
    public DtCiudadano buscarCiudadanoEmail(String email) throws Exception{
    	return ciudadanos.buscarCiudadanoEmail(email);
    }
}
