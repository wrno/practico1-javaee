package tse2023.grupo16.practico1.data;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import tse2023.grupo16.practico1.datatypes.DtCiudadano;
import tse2023.grupo16.practico1.entidades.Ciudadano;

/**
 * Session Bean implementation class Ciudadanos
 */
@Singleton
@LocalBean
public class Ciudadanos implements CiudadanosRemote, CiudadanosLocal {
	ArrayList<Ciudadano> ciudadanos;

    /**
     * Default constructor. 
     */
    public Ciudadanos() {
        // TODO Auto-generated constructor stub
    	this.ciudadanos = new ArrayList<>();
    }
    
    public boolean existeCiudadanoEmail(String email) {
    	boolean existe = false;
    	for(Ciudadano it : this.ciudadanos) {
    		if(email.equals(it.getEmail())) {
    			existe = true;
    			break;
    		}
    	}
    	return existe;
    }
    
    public boolean existeCiudadanoCi(int ci) {
    	boolean existe = false;
    	for(Ciudadano it : this.ciudadanos) {
    		if(ci == it.getCi()) {
    			existe = true;
    			break;
    		}
    	}
    	return existe;
    }

    public void registrarCiudadano(String email, int ci) {
    	this.ciudadanos.add(new Ciudadano(email, ci));
    }
    
    public void modificarEmail(String emailOriginal, String emailNuevo) {
    	for(Ciudadano ciudadano : this.ciudadanos) {
    		if(ciudadano.getEmail().equals(emailOriginal)) {
    			ciudadano.setEmail(emailNuevo);
    			break;
    		}
    	}
    }
    
    public void modificarCi(int ciOriginal, int ciNueva) {
    	for(Ciudadano ciudadano : this.ciudadanos) {
    		if(ciudadano.getCi() == ciOriginal) {
    			ciudadano.setCi(ciNueva);
    			break;
    		}
    	}
    }
    
    public void eliminarCiudadano(String email) {
    	for(Ciudadano ciudadano : this.ciudadanos) {
    		if(ciudadano.getEmail().equals(email)) {
    			this.ciudadanos.remove(ciudadano);
    			break;
    		}
    	}
    }
    
    public void eliminarCiudadano(int ci) {
    	for(Ciudadano ciudadano : this.ciudadanos) {
    		if(ciudadano.getCi() == ci) {
    			this.ciudadanos.remove(ciudadano);
    			break;
    		}
    	}
    }
    
    public ArrayList<DtCiudadano> listarCiudadanos() throws Exception{
    	if(this.ciudadanos.isEmpty()){
    		throw new Exception("No hay ciudadanos registrados.");
    	}else {
        	ArrayList<DtCiudadano> aRetornar = new ArrayList<>();
	    	for(Ciudadano c : this.ciudadanos) {
	    		aRetornar.add(new DtCiudadano(c.getEmail(), c.getCi(), c.getFechaAlta()));
	    	}
	    	return aRetornar;
    	}
    }
    
    public DtCiudadano buscarCiudadanoEmail(String email) throws Exception{
    	for(Ciudadano it : this.ciudadanos) {
    		if(email.equals(it.getEmail())) {
    			return new DtCiudadano(it.getEmail(), it.getCi(), it.getFechaAlta());
    		}
    	}
    	throw new Exception("No existe un ciudadano con ese e-mail.");
    }
    
    public DtCiudadano buscarCiudadanoCi(int ci) throws Exception{
    	for(Ciudadano it : this.ciudadanos) {
    		if(ci == it.getCi()) {
    			return new DtCiudadano(it.getEmail(), it.getCi(), it.getFechaAlta());
    		}
    	}
    	throw new Exception("No existe un ciudadano con esa cédula.");
    }
}
