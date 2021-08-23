package vue;

import javax.swing.JButton;

import modele.Date;

/**
 * BoutonDate est la classe qui d�finit un bouton pour un jour 
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */
public class BoutonDate extends JButton {

	private Date date;
	
	/** 
	 * Constructeur de BoutonDate 
	 * @param date 
	 */ 
	public BoutonDate(Date date) {
		super (Integer.toString(date.getJour()));
		this.date= date;
	}

	/**
	 * m�thode getDate de la classe BoutonDate 
	 * Accede � la Date
	 * @return la Date
	 */
	public Date getDate() {		 
		return date;
	}

}
