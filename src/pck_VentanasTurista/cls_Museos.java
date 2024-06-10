package pck_VentanasTurista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import pck_Turista.cls_Turista;

public class cls_Museos extends JFrame{
    public JPanel panelMuseo;
    public cls_Museos(){
            this.setSize(730, 500);//se stablece el tamaño de la ventana
            setDefaultCloseOperation(EXIT_ON_CLOSE);//metodo para poder cerrar proceso de ventana
            setTitle("TuriPop/Museos");//titulo de la ventana
            setLocationRelativeTo(null);//se establece la posicion incial de la ventana en el centro
            inciarComponentes();
            setResizable(false); 
        }
    private void inciarComponentes(){
     colocarPanelesIglesia(); 
     ColocarEtiqueta();
     colocarBotones();
    }
    public void colocarPanelesIglesia(){
        
        panelMuseo = new JPanel();//creacion panel 
      panelMuseo.setBackground(Color.WHITE);
      this.getContentPane().add(panelMuseo);//se enlaza con la ventana
      //creacion de etiqueta
      panelMuseo.setLayout(null);
    }
    
    public void ColocarEtiqueta(){
        JLabel etiqueta = new JLabel();//instancia de etiqueta
      etiqueta.setText("¡Museos de Popayan!");//se establece el text de la etiqueta
      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etiqueta.setBounds(200,10,345,37);//donde se va a ubicar
      etiqueta.setForeground(Color.BLACK);//color de texto
      etiqueta.setBackground(Color.WHITE);//para el fondo de la etiqueta
      etiqueta.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etiqueta.setFont(new Font("arial",1,30));//estabecemos la fuente del txt
      panelMuseo.add(etiqueta);
    }
    
    public void colocarBotones(){
        JButton botonVolver = new JButton();
        botonVolver.setBounds(645,390,60,60);
        botonVolver.setEnabled(true);//habilita la interaccion con el boton
        botonVolver.setForeground(Color.BLUE);//color letra
        botonVolver.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);//color de fondo del boton
        panelMuseo.add(botonVolver);
        //accion boton volver
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_Turista vTurista = new cls_Turista(); 
                vTurista.setVisible(true);
            }
        });
    }
}
