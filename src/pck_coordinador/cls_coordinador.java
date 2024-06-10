package pck_coordinador;

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
import pck_VentanasCoordi.cls_actualizarCord;
import pck_VentanasCoordi.cls_agregarCord;
import pck_VentanasCoordi.cls_eliminarCord;
import pck_configuracion.cls_Configuracion;

public class cls_coordinador extends JFrame{
         public JPanel panelCoordi;//se crea un atributo de tipo panel, esto se hizo para independencia de metodos en etiquetas
        public cls_coordinador(){
            this.setSize(730, 500);//se stablece el tamaño de la ventana
            setDefaultCloseOperation(EXIT_ON_CLOSE);//metodo para poder cerrar proceso de ventana
            setTitle("TuriPop/Logeado/Coordinador");//titulo de la ventana
            setLocationRelativeTo(null);//se establece la posicion incial de la ventana en el centro
            inciarComponentes();
            setResizable(false); 
        }
    private void inciarComponentes(){
      colocarPanelesCoordi();
      colocarEtiquetasCoordi();
      colocarBotonesCoordi();
    }

    private void colocarPanelesCoordi() {
        panelCoordi = new JPanel();//creacion panel 
      panelCoordi.setBackground(Color.WHITE);
      this.getContentPane().add(panelCoordi);//se enlaza con la ventana
      //creacion de etiqueta
      panelCoordi.setLayout(null);
    }

    private void colocarEtiquetasCoordi() {
        JLabel etiqueta = new JLabel();//instancia de etiqueta
      etiqueta.setText("¿Que deseas hacer?");//se establece el text de la etiqueta
      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etiqueta.setBounds(200,10,345,40);//donde se va a ubicar
      etiqueta.setForeground(Color.BLACK);//color de texto
      Color colorPersonalizado1 = new Color(60, 135, 208);//aqui va el RGB
        etiqueta.setBackground(colorPersonalizado1);
        etiqueta.setOpaque(true);//para el fondo de la etiqueta
      etiqueta.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etiqueta.setFont(new Font("arial",1,30));//estabecemos la fuente del txt
      panelCoordi.add(etiqueta);
      //etiquetas acciones
      JLabel etq_iglesia = new JLabel();//instancia de etiqueta
      etq_iglesia.setText("Eliminar S.T");//se establece el text de la etiqueta
      etq_iglesia.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etq_iglesia.setBounds(410,70,100,20);//donde se va a ubicar
      etq_iglesia.setForeground(Color.BLACK);//color de texto
      etq_iglesia.setBackground(Color.WHITE);//para el fondo de la etiqueta
      etq_iglesia.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etq_iglesia.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
      panelCoordi.add(etq_iglesia);
        //etiqueta monumento
        JLabel etq_Monumento = new JLabel();//instancia de etiqueta
      etq_Monumento.setText("Añadir S.T");//se establece el text de la etiqueta
      etq_Monumento.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etq_Monumento.setBounds(210,70,100,20);//donde se va a ubicar
      etq_Monumento.setForeground(Color.BLACK);//color de texto
      etq_Monumento.setBackground(Color.WHITE);//para el fondo de la etiqueta
      etq_Monumento.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etq_Monumento.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
      panelCoordi.add(etq_Monumento);
        //etiqueta iglesia
        JLabel etq_SitioTuristico = new JLabel();//instancia de etiqueta
      etq_SitioTuristico.setText("Editar S.T");//se establece el text de la etiqueta
      etq_SitioTuristico.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etq_SitioTuristico.setBounds(210,230,100,20);//donde se va a ubicar
      etq_SitioTuristico.setForeground(Color.BLACK);//color de texto
      etq_SitioTuristico.setBackground(Color.WHITE);//para el fondo de la etiqueta
      etq_SitioTuristico.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etq_SitioTuristico.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
      panelCoordi.add(etq_SitioTuristico);
    }

    private void colocarBotonesCoordi() {
        JButton btn_AgregarCoord = new JButton();
        btn_AgregarCoord.setBounds(200,90,120,120);
        btn_AgregarCoord.setEnabled(true);//habilita la interaccion con el boton
        btn_AgregarCoord.setForeground(Color.BLUE);//color letra
        btn_AgregarCoord.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui = new ImageIcon("agregar.png");
        //btn_Museo.setBorder(BorderFactory.createRoundedBorder(10));
        btn_AgregarCoord.setIcon(new ImageIcon(clicAqui.getImage().getScaledInstance(btn_AgregarCoord.getWidth(), btn_AgregarCoord.getHeight(), Image.SCALE_SMOOTH)));
        btn_AgregarCoord.setBackground(Color.WHITE);//color de fondo del boton
        panelCoordi.add(btn_AgregarCoord);
    //accion Boton
    btn_AgregarCoord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cls_agregarCord vAñadir =new cls_agregarCord();
                        vAñadir.setVisible(true);
                        dispose();
                // Aquí podrías realizar otras acciones, como mostrar la ventana anterior
            }
        });
    //Boton Eliminar
    JButton btn_EliminarCoord = new JButton();
        btn_EliminarCoord.setBounds(400,90,120,120);
        btn_EliminarCoord.setEnabled(true);//habilita la interaccion con el boton
        btn_EliminarCoord.setForeground(Color.BLUE);//color letra
        btn_EliminarCoord.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui2 = new ImageIcon("eliminar.png");
        btn_EliminarCoord.setIcon(new ImageIcon(clicAqui2.getImage().getScaledInstance(btn_EliminarCoord.getWidth(), btn_EliminarCoord.getHeight(), Image.SCALE_SMOOTH)));
        btn_EliminarCoord.setBackground(Color.WHITE);//color de fondo del boton
        panelCoordi.add(btn_EliminarCoord);
        //accion boton eliminar
        btn_EliminarCoord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cls_eliminarCord vEliminar =new cls_eliminarCord();
                        vEliminar.setVisible(true);
                        dispose();
                // Aquí podrías realizar otras acciones, como mostrar la ventana anterior
            }
        });
    //Boton actualizar
    JButton btn_ActuaST = new JButton();
        btn_ActuaST.setBounds(200,250,120,120);
        btn_ActuaST.setEnabled(true);//habilita la interaccion con el boton
        btn_ActuaST.setForeground(Color.BLUE);//color letra
        btn_ActuaST.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui3 = new ImageIcon("editar.png");
        btn_ActuaST.setIcon(new ImageIcon(clicAqui3.getImage().getScaledInstance(btn_ActuaST.getWidth(), btn_ActuaST.getHeight(), Image.SCALE_SMOOTH)));
        btn_ActuaST.setBackground(Color.WHITE);//color de fondo del boton
        panelCoordi.add(btn_ActuaST);
    //accion sitioInteres
    btn_ActuaST.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cls_actualizarCord vActuaCoord =new cls_actualizarCord();
                        vActuaCoord.setVisible(true);
                        dispose();
            }
        });
     JButton botonVolver = new JButton();
        botonVolver.setBounds(645, 390, 60, 60);
        botonVolver.setEnabled(true);//habilita la interaccion con el boton
        botonVolver.setForeground(Color.BLUE);//color letra
        botonVolver.setFont(new Font("arial", 1, 15));//establecemos la funte del texto
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);//color de fondo del boton
        panelCoordi.add(botonVolver);
        

//accion boton volver
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_Configuracion btnVolv = new cls_Configuracion();
                btnVolv.setVisible(true);
            }
        });
    }
    }