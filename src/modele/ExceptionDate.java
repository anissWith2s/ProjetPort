package modele;

/**
 * ExceptionDate est la classe qui l�ve une exception si le mois est sup�rieur au 9 �me mois
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */

public class ExceptionDate extends Exception {
	public ExceptionDate (String parMessage) {	
		super (parMessage) ; // appel du constructeur de la classe m�re
	
	}
} // classe
