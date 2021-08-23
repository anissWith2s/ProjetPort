package vue;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import constantes.ConstantesCouleursFontes;
import controleur.Controleur;
import modele.CelluleRenderer;
import modele.Date;
import modele.MareeJour;
import modele.Maree;
import modele.ModeleTable;

/**
 * PanelAffichage est un JPanel contenant une JTable
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */

public class PanelAffichage extends JPanel implements ConstantesCouleursFontes {
	
	ModeleTable modele;
	JTable tableMarre;
	MareeJour marreJour;
    Date today;
    static final long serialVersionUID = -6269912554833473967L;
    
    /**
	 * Constructeur de la classe PanelAffichage
	 * @param marreJour objet de la classe MareeJour
	 */
    
	public PanelAffichage (MareeJour marreJour) {
		
		this.marreJour = marreJour ;
		today = marreJour.getMarreDate();

		modele = new ModeleTable (today,marreJour);
		
		tableMarre = new JTable (modele);
		JTableHeader Header = tableMarre.getTableHeader();
		
		
		Header.setBackground(CHARRETTE);
		Header.setFont(FONT_12);
		
		tableMarre.setDefaultRenderer(Maree.class, new CelluleRenderer());
		
		JScrollPane scrollPane = new JScrollPane (tableMarre,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
	    this.add(scrollPane);
		
	   

		
	}
	
	/**
	 * Méthode qui met à jour le modele de la table 
	 * @param date 
	 * @param marreJour
	 */
	public void update(Date date, MareeJour marreJour) {
		tableMarre.setModel(new ModeleTable (date,marreJour));
		
	}

	



}