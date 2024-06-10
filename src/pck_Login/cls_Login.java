package pck_Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import pck_configuracion.cls_Configuracion;
import pck_coordinador.cls_coordinador;

public class cls_Login extends JFrame{
         public JPanel panelLogIn;//se crea un atributo de tipo panel, esto se hizo para independencia de metodos en etiquetas
        public cls_Login(){
            this.setSize(730, 500);//se stablece el tamaño de la ventana
            setDefaultCloseOperation(EXIT_ON_CLOSE);//metodo para poder cerrar proceso de ventana
            setTitle("TuriPop/LogIn");//titulo de la ventana
            setLocationRelativeTo(null);//se establece la posicion incial de la ventana en el centro
            inciarComponentes();
            setResizable(false); 
        }
    private void inciarComponentes(){
      colocarPanelesLogIn();
      colocarEtiquetasLogIn();
      colocarBotonesLogIn();
      colocarCajasDeTexto();
      colocarCajasDePass();
    }

    private void colocarPanelesLogIn() {
        panelLogIn = new JPanel();//creacion panel 
      panelLogIn.setBackground(Color.WHITE);
      this.getContentPane().add(panelLogIn);//se enlaza con la ventana
      //creacion de etiqueta
      panelLogIn.setLayout(null);
    }

    private void colocarEtiquetasLogIn() {
        //etiqueta boton iniciar sesion
        JLabel etiqueta = new JLabel();//instancia de etiqueta
      etiqueta.setText("Iniciar Sesión");//se establece el text de la etiqueta
      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etiqueta.setBounds(200,10,345,37);//donde se va a ubicar
      etiqueta.setForeground(Color.BLACK);//color de texto
      etiqueta.setBackground(Color.WHITE);//para el fondo de la etiqueta
      etiqueta.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etiqueta.setFont(new Font("arial",1,30));//estabecemos la fuente del txt
      panelLogIn.add(etiqueta);//agregamos la etiqueta a el panel
      //etiqueta LOGIN
      JLabel etiqueta_LogIn = new JLabel();//instancia de etiqueta
      etiqueta_LogIn.setText("click para ingresar:");//se establece el text de la etiqueta
      etiqueta_LogIn.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etiqueta_LogIn.setBounds(120,288,150,35);//donde se va a ubicar
      etiqueta_LogIn.setForeground(Color.BLACK);//color de texto
      etiqueta_LogIn.setBackground(Color.white);//para el fondo de la etiqueta
      etiqueta_LogIn.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etiqueta_LogIn.setFont(new Font("arial",1,14));//estabecemos la fuente del txt
      panelLogIn.add(etiqueta_LogIn);
      //etiqueta caja usuario
      JLabel etq_Usuario = new JLabel();//instancia de etiqueta
      etq_Usuario.setText("Digite su usuario: ");//se establece el text de la etiqueta
      etq_Usuario.setHorizontalAlignment(SwingConstants.LEFT);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etq_Usuario.setBounds(100,100,140,30);//donde se va a ubicar
      etq_Usuario.setForeground(Color.BLACK);//color de texto
      etq_Usuario.setBackground(Color.WHITE);//para el fondo de la etiqueta
      etq_Usuario.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etq_Usuario.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
      panelLogIn.add(etq_Usuario);
      
      // Etiqueta para la contraseña
        JLabel etiqueta_Contrasena = new JLabel();
        etiqueta_Contrasena.setText("Digite su contraseña:");
        etiqueta_Contrasena.setHorizontalAlignment(SwingConstants.LEFT);
        etiqueta_Contrasena.setBounds(100, 150, 150, 28);
        etiqueta_Contrasena.setForeground(Color.BLACK);
        etiqueta_Contrasena.setFont(new Font("arial", 1, 14));
        panelLogIn.add(etiqueta_Contrasena);
        // Etiqueta para imagen inicio sesion admin
        ImageIcon imagenLogIn = new ImageIcon("LogIn.png");
      JLabel label_imagenLogIn=new JLabel();
      label_imagenLogIn.setBounds(320,70,246,246);//parametros de la etiqueta
      //setIcon permite concatenar el ancho de la etiqueta al ancho de la imagen
      label_imagenLogIn.setIcon(new ImageIcon(imagenLogIn.getImage().getScaledInstance(label_imagenLogIn.getWidth(),//recoge el ancho
              label_imagenLogIn.getHeight(),//recoge el alto
              Image.SCALE_SMOOTH)));//pone el tipo de imagen en smooth
      panelLogIn.add(label_imagenLogIn);
      label_imagenLogIn.setBounds(440,70,256,256);//editar aqui
    }

    private void colocarBotonesLogIn() {
        //botton con imagen:
        JButton btn_LogIn = new JButton();
        btn_LogIn.setBounds(300,270,80,80);
        btn_LogIn.setEnabled(true);//habilita la interaccion con el boton
        btn_LogIn.setForeground(Color.BLUE);//color letra
        btn_LogIn.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui = new ImageIcon("acceso.png");
        btn_LogIn.setIcon(new ImageIcon(clicAqui.getImage().getScaledInstance(btn_LogIn.getWidth(), btn_LogIn.getHeight(), Image.SCALE_SMOOTH)));
        btn_LogIn.setBackground(Color.WHITE);//color de fondo del boton
        panelLogIn.add(btn_LogIn);
        btn_LogIn.requestFocusInWindow();//enfoca al boton en vez de señalar el textfield
        ActionListener accionUser = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                        cls_coordinador ventanaCoordi =new cls_coordinador();
                        ventanaCoordi.setVisible(true);
                        dispose();//cierra la ventana anterior
            }
        };
        btn_LogIn.addActionListener(accionUser);
    
        //BOTON VOLVER
        JButton botonVolver = new JButton();
        //boton1.setText("Agregar");//agregar txt al boton
        botonVolver.setBounds(645,390,60,60);
        botonVolver.setEnabled(true);//habilita la interaccion con el boton
        botonVolver.setMnemonic('d');//establecemos que la interaccion del boton sea alt + "letra añadida"
        botonVolver.setForeground(Color.BLUE);//color letra
        botonVolver.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);//color de fondo del boton
        panelLogIn.add(botonVolver);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual
                dispose();
                cls_Configuracion v1 = new cls_Configuracion(); 
                v1.setVisible(true);
                // Aquí podrías realizar otras acciones, como mostrar la ventana anterior
            }
        });
        panelLogIn.add(botonVolver);
    }
    private void colocarCajasDeTexto() {
        JTextField cajatextoAdmin = new JTextField();
        cajatextoAdmin.setBounds(250, 100, 140, 28);
        cajatextoAdmin.setText("Escribe aquí tu usuario");
        panelLogIn.add(cajatextoAdmin);
        cajatextoAdmin.setFont(new Font("arial",1,12));
        //System.out.println("txt en la caja:"+cajatextoAdmin.getText());
        // Agregar FocusListener para borrar el texto cuando se selecciona la caja de texto
        cajatextoAdmin.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cajatextoAdmin.getText().equals("Escribe aquí tu usuario")) {
                    cajatextoAdmin.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (cajatextoAdmin.getText().isEmpty()) {
                    cajatextoAdmin.setText("Escribe aquí tu usuario");
                }
            }
        });
        
    }
     private void colocarCajasDePass() {
        // Caja de texto para la contraseña
        JPasswordField contrasenaField = new JPasswordField();
        contrasenaField.setBounds(250, 150, 140, 28);
        panelLogIn.add(contrasenaField);
        contrasenaField.setFont(new Font("arial", 1, 12));
        contrasenaField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            // No hacer nada al ganar el foco
        }

        @Override
        public void focusLost(FocusEvent e) {
            // Verificar si el texto actual es igual al texto predeterminado
            if (String.valueOf(contrasenaField.getPassword()).equals("Digite su contraseña:")) {
                // Limpiar el campo de contraseña
                contrasenaField.setText("");
            }
        }
    });
   }
}
