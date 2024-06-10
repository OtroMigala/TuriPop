package pck_configuracion;

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
import pck_Admin.cls_ventanaAdmin;
import pck_Login.cls_Login;
import pck_Turista.cls_Turista;

public class cls_Configuracion extends JFrame{
        public JPanel panelConfiguracion;//se crea un atributo de tipo panel, esto se hizo para independencia de metodos en etiquetas
        public cls_Configuracion(){
            this.setSize(730, 500);//ee stablece el tamaño de la ventana
            setDefaultCloseOperation(EXIT_ON_CLOSE);//metodo para poder cerrar proceso de ventana
            setTitle("TuriPop/Configuracion");//titulo de la ventana
            setLocationRelativeTo(null);//se establece la posicion incial de la ventana en el centro
            //setLocation(500, 500); para poder ponerlo en una localizacion exacata
            //setBounds(700,200, 600, 600);//sirve para poner los parametors de la posicion y tamaño inciales
            //this.getContentPane().setBackground(Color.CYAN);
            inciarComponentes();
            setResizable(false); 
        }
    private void inciarComponentes(){
      colocarPaneles();
      colocarEtiquetas();
      colocarBotones();
      //colocarRadioBotones();
      //colocarBotonesDeActivacion();
      //colocarCajasDeTexto();
      //colocarAreasDeTexto();
      //colocarListaDesplegable();
    }
    private void colocarPaneles(){
    panelConfiguracion = new JPanel();//solo se crea el panel y se instancia
      panelConfiguracion.setBackground(Color.WHITE);
      this.getContentPane().add(panelConfiguracion);//se enlaza con la ventana
      //creacion de etiqueta
      panelConfiguracion.setLayout(null);
    }
    private void colocarEtiquetas(){
        JLabel etiqueta = new JLabel();//instancia de etiqueta
      etiqueta.setText("Ingresar a Configuracion");//se establece el text de la etiqueta
      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etiqueta.setBounds(200,10,380,40);//donde se va a ubicar
      etiqueta.setForeground(Color.BLACK);//color de texto
      Color colorPersonalizado1 = new Color(60, 135, 208);//aqui va el RGB
        etiqueta.setBackground(colorPersonalizado1);
        etiqueta.setOpaque(true);//para el fondo de la etiqueta
      etiqueta.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etiqueta.setFont(new Font("arial",1,30));//estabecemos la fuente del txt
      panelConfiguracion.add(etiqueta);//agregamos la etiqueta a el panel
      
      //ETIQEUTA 2
      ImageIcon imagen = new ImageIcon("confis.png");
      JLabel etiqueta2=new JLabel();
      etiqueta2.setBounds(320,80,256,256);//parametros de la etiqueta
      //setIcon permite concatenar el ancho de la etiqueta al ancho de la imagen
      etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(),//recoge el ancho
              etiqueta2.getHeight(),//recoge el alto
              Image.SCALE_SMOOTH)));//pone el tipo de imagen en smooth
      panelConfiguracion.add(etiqueta2);
      etiqueta2.setBounds(450,90,256,256);//editar aqui
      //ETIQUETA 5 INGRESAR COMO ADMIN
      JLabel etiqueta5=new JLabel();
      etiqueta5.setText("Ingresar como admin:");
      etiqueta5.setHorizontalAlignment(SwingConstants.CENTER);
      etiqueta5.setBackground(Color.GRAY);
      etiqueta5.setForeground(Color.BLACK);
      etiqueta5.setBounds(80,240,300,80);
      etiqueta5.setFont(new Font("arial",1,20));
      panelConfiguracion.add(etiqueta5);
      //Etiqueta de btn para coordi
      JLabel etiqueta1=new JLabel();
      etiqueta1.setText("Ingresar como coord:");
      etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
      etiqueta1.setBackground(Color.GRAY);
      etiqueta1.setForeground(Color.BLACK);
      etiqueta1.setBounds(80,80,300,80);
      etiqueta1.setFont(new Font("arial",1,20));
      panelConfiguracion.add(etiqueta1);
        }
    private void colocarBotones() {
        //boton coord
        JButton boton2 = new JButton();
        boton2.setBounds(170,140,110,110);
        boton2.setEnabled(true);//habilita la interaccion con el boton
        ImageIcon clicAqui2 = new ImageIcon("coord.png");
        boton2.setIcon(new ImageIcon(clicAqui2.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setBackground(Color.WHITE);//color de fondo del boton
        panelConfiguracion.add(boton2);
        //boton admin
        JButton boton3 = new JButton();
        boton3.setBounds(170,300,110,110);
        boton3.setEnabled(true);//habilita la interaccion con el boton
        ImageIcon clicAqui3 = new ImageIcon("administrador.png");
        boton3.setIcon(new ImageIcon(clicAqui3.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));
        boton3.setBackground(Color.WHITE);//color de fondo del boton
        panelConfiguracion.add(boton3);
        //btn volver
        JButton botonVolver = new JButton();
        botonVolver.setBounds(645,390,60,60);
        botonVolver.setEnabled(true);//habilita la interaccion con el boton
        botonVolver.setForeground(Color.BLUE);//color letra
        botonVolver.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);//color de fondo del boton
        panelConfiguracion.add(botonVolver);
        //accion boton volver
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_Turista vTurista = new cls_Turista(); 
                vTurista.setVisible(true);
            }
        });
        ActionListener accionUser = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                        cls_Login ventanaLogIn =new cls_Login();
                        ventanaLogIn.setVisible(true);
                        dispose();//cierra la ventana anterior
            }
        };
        boton2.addActionListener(accionUser);
        ActionListener accionAdminLogeo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                        cls_ventanaAdmin ventanaAdmin =new cls_ventanaAdmin();
                        ventanaAdmin.setVisible(true);
                        dispose();//cierra la ventana anterior
            }
        };
        boton3.addActionListener(accionAdminLogeo);
    }
}
