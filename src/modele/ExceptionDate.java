package modele;

/**
 * ExceptionDate est la classe qui lève une exception si le mois est supérieur au 9 ème mois
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */

public class ExceptionDate extends Exception {
	public ExceptionDate (String parMessage) {	
		super (parMessage) ; // appel du constructeur de la classe mère
	
	}
} // classe
