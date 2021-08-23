package modele;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import constantes.ConstantesCouleursFontes;

/**
 * CelluleRenderer est la classe permet de mettre un TableCellRenderer sur une JTable
 * cette classe implement @see TableCellRenderer, @see ConstantesCouleursFontes et extend de @see JLabel
 * 
 * @author Thevakumaran Krishnath et Hassan Aniss 
 * 
 */
public class CelluleRenderer extends JLabel implements TableCellRenderer, ConstantesCouleursFontes{

	/** 
	 * Constructeur de CelluleRenderer
	 * Ne prend aucun parametre
	 */ 
	
	public CelluleRenderer (){
		super();
		setOpaque (true);
		setHorizontalAlignment(JLabel.CENTER);
		
		
	}
	
	/** 
	 * méthode getTableCellRendererComponent de la classe CelluleRenderer
	 * La methode permet de donné un aspect specifique a la cellule de la JTable en fonction de sont contenue
	 * @param table Objet de la classe JTable
	 * @param cellValue Objet dans la cellule
	 * @param isSelected true ou false si la cellule est selectionné
	 * @param hasFocus true ou false si la cellule est focus
	 * @param row numéraux de la ligne de la cellule
	 * @param col numéraux de colonne de la cellule
	 */ 
	
	
	public Component getTableCellRendererComponent(JTable table, Object
			cellValue, boolean isSelected, boolean hasFocus, int row, int col) {
	    if(cellValue != null){
	    	
	    	//forme du texte
            setText(cellValue.toString());
            setFont(new Font("Ariat", Font.BOLD,12));
            setForeground(new Color(60,60,60));
            setHorizontalAlignment(JLabel.CENTER); 
            
            //mettre les valeurs indisponibles
            if (cellValue.equals(-1)) {
            	setText("--");
            }
            
            if (col == 0) {
            	HeureMinute hM = (HeureMinute) cellValue;
            	if (hM.getHeure()==0 && hM.getMinute()==0) {
            		setText("--:--");
            	}
            }
            
            if (col == 1) {
            	float hauteur = (float) cellValue;
            	if (hauteur == -1.0) {
            		setText("--.--");
            	}
            }
            
            if (col == 2) {
            	int coef = (int) cellValue;
            	if (coef == 0) {
            		setText("---");
            	}
            }
            
            //couleur pour différencier les plaines mer et basse mer  
            if (table.getRowCount()<5) {
            	if (row == 0) 
                    setBackground(BLEU_CLAIRE);
             	
                 if (row == 1) 
                    setBackground(BLEU_CLAIRE);
                
                 if (row == 2)
                    setBackground(WHITE);
                  
                 if (row == 3)
                    setBackground(WHITE);
            }
        	
            
           
        }
	    
        else
            setText("");
        return this;
    }

}
