package tse2023.grupo16.practico1.cliente;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tse2023.grupo16.practico1.datatypes.DtCiudadano;
import tse2023.grupo16.practico1.negocios.CiudadanoNegocioRemote;

public class Main {

	public static void main(String[] args) throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		props.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
		
		Context ctx = new InitialContext(props);
		String jndiName = "ejb:practico1/practico1-ejb/CiudadanoNegocio!tse2023.grupo16.practico1.negocios.CiudadanoNegocioRemote";
		
		CiudadanoNegocioRemote ciudadanos = (CiudadanoNegocioRemote) ctx.lookup(jndiName);
		
		int op = 0;
		Scanner in = new Scanner(System.in);
		
		do {
			clear();
			System.out.println("1- Registrar ciudadano");
			System.out.println("2- Listar usuarios");
			System.out.println("3- Modificar usuario");
			System.out.println("4- Eliminar usuario");
			System.out.println("-----------------------");
			System.out.println("0- Salir");
		    System.out.println("");
			System.out.print("Ingrese opción: ");
			try {
				op = Integer.parseInt(in.nextLine());
				switch(op) {
				case 1:
					clear();
					System.out.println("REGISTRO DE CIUDADANO:");
					System.out.print("Cédula de identidad: ");
					try {
						int ci = Integer.parseInt(in.nextLine());
						System.out.print("E-mail: ");
						String email = in.nextLine();
						try {
							ciudadanos.registrarCiudadano(email, ci);
							System.out.println("Ciudadano registrado con éxito.");
							sleep();
						}catch(Exception e) {
							clear();
							System.out.println(e.getMessage());
							sleep();
						}
					}catch(Exception e){
						clear();
						System.out.println("Cédula inválida.");
						sleep();
					}
					break;
				case 2:
					clear();
					System.out.println("LISTA DE USUARIOS:");
					try {
						ArrayList<DtCiudadano> ciudadanosList = ciudadanos.listarCiudadanos();
						for(DtCiudadano ciudadano : ciudadanosList) {
							System.out.println("Cédula: " + ciudadano.getCi() + " | E-mail: " + ciudadano.getEmail());
						}
						sleep();
					}catch(Exception e) {
						System.out.println(e.getMessage());
						sleep();
					}
					break;
				case 3:
					clear();
					System.out.println("MODIFICACIÓN DE CIUDADANO:");
					System.out.print("Cédula de usuario a modificar: ");
					try {
						int ci = Integer.parseInt(in.nextLine());
						try {
							DtCiudadano ciudadano = ciudadanos.buscarCiudadanoCi(ci);
							clear();
							System.out.println("1- Modificar cédula");
							System.out.println("2- Modificar e-mail");
							System.out.println("-------------------");
							System.out.print("Ingrese opción: ");
							try {
								int op2 = Integer.parseInt(in.nextLine());
								switch(op2) {
								case 1:
									clear();
									System.out.println("Cédula actual: " + ciudadano.getCi());
									System.out.print("Nueva cédula: ");
									try {
										int ciNueva = Integer.parseInt(in.nextLine());
										try {
											ciudadanos.modificarCi(ciudadano.getCi(), ciNueva);
											System.out.println("Cédula modificada. Nueva cédula: " + ciNueva);
											sleep();
										}catch(Exception e) {
											clear();
											System.out.println(e.getMessage());
											sleep();
										}
									}catch(Exception e) {
										clear();
										System.out.println("Cédula inválida.");
										sleep();
									}
									break;
								case 2:
									clear();
									System.out.println("E-mail actual: " + ciudadano.getEmail());
									System.out.print("Nuevo e-mail: ");
									String emailNuevo = in.nextLine();
									try {
										ciudadanos.modificarEmail(ciudadano.getEmail(), emailNuevo);
										System.out.println("E-mail modificado. Nuevo e-mail: " + emailNuevo);
										sleep();
									}catch(Exception e) {
										clear();
										System.out.println(e.getMessage());
										sleep();
									}
									break;
								default:
									clear();
									System.out.println("Opción inválida.");
									sleep();
								}
							}catch(Exception e) {
								clear();
								System.out.println("Opción inválida.");
								sleep();
							}
						}catch(Exception e) {
							clear();
							System.out.println(e.getMessage());
							sleep();
						}
					}catch(Exception e) {
						clear();
						System.out.println("Cédula inválida.");
						sleep();
					}
					break;
				case 4:
					clear();
					System.out.println("ELIMINAR USUARIO:");
					System.out.print("Cédula del usuario a eliminar: ");
					try {
						int ci = Integer.parseInt(in.nextLine());
						try {
							ciudadanos.eliminarCiudadanoCi(ci);
							System.out.println("Ciudadano con cédula " + ci + " eliminado con éxito.");
							sleep();
						}catch(Exception e) {
							clear();
							System.out.println(e.getMessage());
							sleep();
						}
					}catch(Exception e) {
						clear();
						System.out.println("Cédula inválida.");
						sleep();
					}
					break;
				case 0:
					break;
				default:
					clear();
					System.out.println("Opción inválida.");
					sleep();
				}
			}catch(Exception e) {
				clear();
				System.out.println("Opción inválida.");
				sleep();
			}
		}while(op != 0);
		in.close();
	}

	public static void clear() {
		for(int i = 0; i < 20; i++)
		{
		    System.out.println("");
		}
	}
	
	public static void sleep() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e1) {
		}
	}
}
