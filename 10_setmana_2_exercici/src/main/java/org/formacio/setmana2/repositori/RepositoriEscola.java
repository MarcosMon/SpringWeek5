package org.formacio.setmana2.repositori;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.formacio.setmana2.domini.Alumne;
import org.formacio.setmana2.domini.Curs;
import org.formacio.setmana2.domini.Matricula;
import org.springframework.stereotype.Repository;

/**
 * Modifica aquesta classe per tal que sigui un component Spring que realitza les 
 * operacions de persistencia tal com indiquen les firmes dels metodes
 */
@Repository
public class RepositoriEscola {

	@PersistenceContext
	private EntityManager entityManager = null;
	
	public Curs carregaCurs(String nom) {
		
		Curs curs = entityManager.find(Curs.class, nom);
		
		return curs;
	}
	
	
	public Matricula apunta (String alumne, String curs) throws EdatIncorrecteException {
		
		Alumne alumno = entityManager.find(Alumne.class, alumne);
	    Curs curso = this.carregaCurs(curs);
	    
	    
	    Matricula matricula = new Matricula();
	    matricula.setAlumne(alumno);
    	matricula.setCurs(curso);
    	entityManager.persist(matricula);
	    return matricula;	
	}
	
	
}
