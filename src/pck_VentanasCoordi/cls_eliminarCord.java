package pck_VentanasCoordi;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import pck_coordinador.cls_coordinador;

public class cls_eliminarCord extends JFrame{
    public JPanel panelElimCoord;
    public cls_eliminarCord(){
            this.setSize(730, 500);//se stablece el tamaño de la ventana
            setDefaultCloseOperation(EXIT_ON_CLOSE);//metodo para poder cerrar proceso de ventana
            setTitle("TuriPop/Eliminar Sitio Turistico");//titulo de la ventana
            setLocationRelativeTo(null);//se establece la posicion incial de la ventana en el centro
            inciarComponentes();
            setResizable(false); 
            panelElimCoord.setLayout(new GridLayout(2, 1));
        }
    private void inciarComponentes(){
     colocarPanelesElemCoord(); 
     ColocarEtiqueta();
     colocarBotones();
    }
    public void colocarPanelesElemCoord(){
        panelElimCoord = new JPanel();//creacion panel 
      panelElimCoord.setBackground(Color.WHITE);
      this.getContentPane().add(panelElimCoord);//se enlaza con la ventana
      //creacion de etiqueta
      panelElimCoord.setLayout(null);
    }
    
    public void ColocarEtiqueta(){
        JLabel etiqueta = new JLabel();//instancia de etiqueta
      etiqueta.setText("Eliminar S.T");//se establece el text de la etiqueta
      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etiqueta.setBounds(200,10,345,37);//donde se va a ubicar
      etiqueta.setForeground(Color.BLACK);//color de texto
      etiqueta.setBackground(Color.WHITE);//para el fondo de la etiqueta
      etiqueta.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etiqueta.setFont(new Font("arial",1,30));//estabecemos la fuente del txt
      panelElimCoord.add(etiqueta);
    }
    
    public void colocarBotones(){
        //btn borrar sitio
        JButton btnEliminar = new JButton("Eliminar Sitio");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este sitio turístico?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // Aquí iría el código para eliminar el sitio turístico
                    JOptionPane.showMessageDialog(null, "Sitio turístico eliminado exitosamente.");
                }
            }
        });

        panelElimCoord.add(new JLabel("Aquí iría la lista de sitios turísticos a elegir para eliminar."));
        panelElimCoord.add(btnEliminar);

        add(panelElimCoord);
        //
        JButton botonVolver = new JButton();
        botonVolver.setBounds(645,390,60,60);
        botonVolver.setEnabled(true);//habilita la interaccion con el boton
        botonVolver.setForeground(Color.BLUE);//color letra
        botonVolver.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);//color de fondo del boton
        panelElimCoord.add(botonVolver);
        //accion boton volver
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_coordinador vElimiCoord = new cls_coordinador(); 
                vElimiCoord.setVisible(true);
            }
        });
    }
}
