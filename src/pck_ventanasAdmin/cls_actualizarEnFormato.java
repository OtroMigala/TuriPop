package pck_ventanasAdmin;

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
//import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import pck_Admin.cls_ventanaAdmin;

public class cls_actualizarEnFormato extends JFrame{
    public JPanel panelRegisAdmin2;
    public cls_actualizarEnFormato(){
            this.setSize(730, 500);//se stablece el tamaño de la ventana
            setDefaultCloseOperation(EXIT_ON_CLOSE);//metodo para poder cerrar proceso de ventana
            setTitle("TuriPop/Logeado/Actualizar_Coordinador");//titulo de la ventana
            setLocationRelativeTo(null);//se establece la posicion incial de la ventana en el centro
            inciarComponentes();
            setResizable(false); 
        }
    private void inciarComponentes(){
     colocarPanelesIglesia(); 
     ColocarEtiqueta();
     colocarBotones();
     ponerTxt();
    }
    public void colocarPanelesIglesia(){
        
        panelRegisAdmin2 = new JPanel();//creacion panel 
      panelRegisAdmin2.setBackground(Color.WHITE);
      this.getContentPane().add(panelRegisAdmin2);//se enlaza con la ventana
      //creacion de etiqueta
      panelRegisAdmin2.setLayout(null);
    }
    
    public void ColocarEtiqueta(){
        JLabel etiqueta = new JLabel();//instancia de etiqueta
      etiqueta.setText("Registrar coord");//se establece el text de la etiqueta
      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etiqueta.setBounds(200,10,345,37);//donde se va a ubicar
      etiqueta.setForeground(Color.BLACK);//color de texto
      etiqueta.setBackground(Color.WHITE);//para el fondo de la etiqueta
      etiqueta.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etiqueta.setFont(new Font("arial",1,30));//estabecemos la fuente del txt
      panelRegisAdmin2.add(etiqueta);
      //etiquetas campos:
      JLabel etiquetaNombre = new JLabel();//instancia de etiqueta
    etiquetaNombre.setText("Nombre: ");//se establece el text de la etiqueta
    //etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
    etiquetaNombre.setBounds(100,100,100,20);//donde se va a ubicar
    etiquetaNombre.setForeground(Color.BLACK);//color de texto
    etiquetaNombre.setBackground(Color.WHITE);//para el fondo de la etiqueta
    etiquetaNombre.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
    etiquetaNombre.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelRegisAdmin2.add(etiquetaNombre);
    //etiqueta para descrip. del sitio
    JLabel etiquetaDescripcion = new JLabel("Apellido: ");
    etiquetaDescripcion.setBounds(100, 140, 100, 20); // Ajusta las coordenadas y dimensiones
    etiquetaDescripcion.setForeground(Color.BLACK);//color de texto
    etiquetaDescripcion.setBackground(Color.WHITE);
    etiquetaDescripcion.setOpaque(true);
    etiquetaDescripcion.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelRegisAdmin2.add(etiquetaDescripcion);
    
    JLabel etiquetaHorario = new JLabel("Cedula: ");
    etiquetaHorario.setBounds(100, 180, 100, 20); // Ajusta las coordenadas y dimensiones
    etiquetaHorario.setForeground(Color.BLACK);//color de texto
    etiquetaHorario.setBackground(Color.WHITE);
    etiquetaHorario.setOpaque(true);
    etiquetaHorario.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelRegisAdmin2.add(etiquetaHorario);
    
    JLabel etiquetaEdad = new JLabel("Usuario: ");
    etiquetaEdad.setBounds(100, 220, 100, 20); // Ajusta las coordenadas y dimensiones
    etiquetaEdad.setForeground(Color.BLACK);//color de texto
    etiquetaEdad.setBackground(Color.WHITE);
    etiquetaEdad.setOpaque(true);
    etiquetaEdad.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelRegisAdmin2.add(etiquetaEdad);
    
    JLabel etiquetaCosto = new JLabel("Contraseña: ");
    etiquetaCosto.setBounds(100, 260, 100, 20); // Ajusta las coordenadas y dimensiones
    etiquetaCosto.setForeground(Color.BLACK);//color de texto
    etiquetaCosto.setBackground(Color.WHITE);
    etiquetaCosto.setOpaque(true);
    etiquetaCosto.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelRegisAdmin2.add(etiquetaCosto);
    }
    
    public void colocarBotones(){
        //boton regisrar:
        //btn añadir
        JButton addButton = new JButton("Añadir"); // Crear el botón con el texto "Añadir"
        addButton.setBounds(300, 400, 100, 40); // Establecer posición y tamaño del botón
        addButton.setForeground(Color.WHITE); // Cambiar color del texto
        addButton.setBackground(new Color(59, 89, 182)); // Cambiar color de fondo
        addButton.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y el tamaño del texto
        addButton.setFocusPainted(false); // Eliminar el borde de enfoque al hacer clic
        panelRegisAdmin2.add(addButton);
        addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }
    });
        JButton botonVolver = new JButton();
        botonVolver.setBounds(645,390,60,60);
        botonVolver.setEnabled(true);//habilita la interaccion con el boton
        botonVolver.setForeground(Color.BLUE);//color letra
        botonVolver.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);//color de fondo del boton
        panelRegisAdmin2.add(botonVolver);
        //accion boton volver
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_ventanaAdmin vAdmin = new cls_ventanaAdmin(); 
                vAdmin.setVisible(true);
            }
        });
    }
    public void ponerTxt(){
        //txt nombre
    JTextArea areaNombre = new JTextArea();
    areaNombre.setBounds(300,100,300,20); // Ajusta las coordenadas y dimensiones
    areaNombre.setForeground(Color.BLACK);//color de texto
    areaNombre.setBackground(Color.GRAY);
    areaNombre.setText("Escribe aqui el nombre");
    areaNombre.setFont(new Font("arial", Font.PLAIN, 15));//estabecemos la fuente del txt
    areaNombre.setLineWrap(true); // Hace que el texto se ajuste automáticamente a las dimensiones del área
    panelRegisAdmin2.add(areaNombre);
    
areaNombre.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaNombre.getText().equals("Escribe aqui el nombre")) {
                    areaNombre.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaNombre.getText().isEmpty()) {
                    areaNombre.setText("Escribe aqui el nombre");
                }
            }
        });
    //txt apellido
    JTextArea areaApellido = new JTextArea();
    areaApellido.setBounds(300,140,300,20); // Ajusta las coordenadas y dimensiones
    areaApellido.setForeground(Color.BLACK);//color de texto
    areaApellido.setBackground(Color.GRAY);
    areaApellido.setText("Escribe aqui el apellido");
    areaApellido.setFont(new Font("arial", Font.PLAIN, 15));//estabecemos la fuente del txt
    areaApellido.setLineWrap(true); // Hace que el texto se ajuste automáticamente a las dimensiones del área
    panelRegisAdmin2.add(areaApellido);
    
areaApellido.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaApellido.getText().equals("Escribe aqui el apellido")) {
                    areaApellido.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaApellido.getText().isEmpty()) {
                    areaApellido.setText("Escribe aqui el apellido");
                }
            }
        });
    //texto Cedula
    JTextArea areaCedula = new JTextArea();
    areaCedula.setBounds(300,180,300,20); // Ajusta las coordenadas y dimensiones
    areaCedula.setForeground(Color.BLACK);//color de texto
    areaCedula.setBackground(Color.GRAY);
    areaCedula.setText("Escribe aqui la cedula");
    areaCedula.setFont(new Font("arial", Font.PLAIN, 15));//estabecemos la fuente del txt
    areaCedula.setLineWrap(true); // Hace que el texto se ajuste automáticamente a las dimensiones del área
    panelRegisAdmin2.add(areaCedula);
    areaCedula.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaCedula.getText().equals("Escribe aqui la cedula")) {
                    areaCedula.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaCedula.getText().isEmpty()) {
                    areaCedula.setText("Escribe aqui la cedula");
                }
            }
        });
    //txt de usuario
    JTextArea areaUsuario= new JTextArea();
    areaUsuario.setBounds(300,220,300,20); // Ajusta las coordenadas y dimensiones
    areaUsuario.setForeground(Color.BLACK);//color de texto
    areaUsuario.setBackground(Color.GRAY);
    areaUsuario.setText("Escribe aqui el usuario");
    areaUsuario.setFont(new Font("arial", Font.PLAIN, 15));//estabecemos la fuente del txt
    areaUsuario.setLineWrap(true); // Hace que el texto se ajuste automáticamente a las dimensiones del área
    panelRegisAdmin2.add(areaUsuario);
    areaUsuario.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaUsuario.getText().equals("Escribe aqui el usuario")) {
                    areaUsuario.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaUsuario.getText().isEmpty()) {
                    areaUsuario.setText("Escribe aqui el usuario");
                }
            }
        });
    //txt contraseña:
    JTextArea areaConstrasenia= new JTextArea();
    areaConstrasenia.setBounds(300,260,300,20); // Ajusta las coordenadas y dimensiones
    areaConstrasenia.setForeground(Color.BLACK);//color de texto
    areaConstrasenia.setBackground(Color.GRAY);
    areaConstrasenia.setText("Escribe aqui la contraseña");
    areaConstrasenia.setFont(new Font("arial", Font.PLAIN, 15));//estabecemos la fuente del txt
    areaConstrasenia.setLineWrap(true); // Hace que el texto se ajuste automáticamente a las dimensiones del área
    panelRegisAdmin2.add(areaConstrasenia);
    areaConstrasenia.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaConstrasenia.getText().equals("Escribe aqui la contraseña")) {
                    areaConstrasenia.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaConstrasenia.getText().isEmpty()) {
                    areaConstrasenia.setText("Escribe aqui la contraseña");
                }
            }
        });
    }
}
