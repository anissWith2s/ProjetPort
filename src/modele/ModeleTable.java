package modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

import constantes.ConstantesPorts;

/**
 * ModelTable est la classe permet de definir un modele a une JTable
 * @see DefaultTableModel
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */
public class ModeleTable  extends DefaultTableModel implements ConstantesPorts {
	
	private Date date;
	/** 
    * Constructeur de ModelTable 
    * ModelTable construit la JTable avec les information de la date et de marreJour
    * @param parDate correspond à la date selectionné
    * @param mareeJour correspond à l'hashmap ayant une collection de marée
    */ 
	public ModeleTable (Date parDate, MareeJour mareeJour) {
		
		String entete [] = new String [3];
		for (int i = 0; i < 3;i++) {
			entete[i] = INFO[i] ;
		}
		this.setColumnCount(10);
		
		if (parDate.getMois() < 6) {
			this.setRowCount(25);
		}
		else 
			this.setRowCount(4);

		this.setColumnIdentifiers(entete);

		int indice = 0;
		
       
		if (mareeJour.getEvenementsjour(parDate.getJour())!= null) {
			
			//parcourir les marrés dans la collection pour le jour de la date 
			for (Maree marre : mareeJour.getEvenementsjour(parDate.getJour())) {
				//ajouter les informations des marées dans la table 
				ajouterMarre(marre);

		    }
	    }
	    
	}
	
	/** 
	* Méthode ajouterMarre
	* @param maree correspond a l'objet Marre
    * Ajoute à la JTable une maree en fonction de ces champs
	*/ 
    public void ajouterMarre( Maree marre) {
		
		int ligne = 0;
		
		while (ligne < getRowCount() && getValueAt(ligne, 1)!= null) {
			ligne ++;
		}

		//ajoute les informations de la marré dans une ligne et sur les colonne indiqués 
		this.setValueAt(marre.hauteur, ligne, 1);
		this.setValueAt(marre.coef, ligne , 2);
		this.setValueAt(marre.heureminute, ligne , 0);
	}
    
	public Class getColumnClass (int indiceColonne) {
		
		return Maree.class;
	}// ModeleTableDeserts


}
