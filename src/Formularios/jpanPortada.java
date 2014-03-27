
package Formularios;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class jpanPortada extends jpanFondo{
        
        private JLabel jlblFondo;
        private jpanFondo jpanelFondo;
        
	public jpanPortada(jpanFondo jpanelFondo) {
            this.jpanelFondo=jpanelFondo;
            
            jlblFondo = new JLabel();
            jlblFondo.setIcon(imagen("fondo.png"));
            jlblFondo.setBounds(0,0,874,612);
            this.add(jlblFondo);
	}


}
