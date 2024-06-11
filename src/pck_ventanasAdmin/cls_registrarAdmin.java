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

import pck_connection.cls_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author chami
 */
public class cls_registrarAdmin extends JFrame{
    public JPanel panelRegisAdmin;
    private JTextArea areaNombre;
    private JTextArea areaApellido;
    private JTextArea areaCedula;
    private JTextArea areaUsuario;
    private JTextArea areaPassword;

    public cls_registrarAdmin(){
            this.setSize(730, 500);//se stablece el tamaño de la ventana
            setDefaultCloseOperation(EXIT_ON_CLOSE);//metodo para poder cerrar proceso de ventana
            setTitle("TuriPop/Logeado/Añadir_Coordinador");//titulo de la ventana
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
        
        panelRegisAdmin = new JPanel();//creacion panel 
      panelRegisAdmin.setBackground(Color.WHITE);
      this.getContentPane().add(panelRegisAdmin);//se enlaza con la ventana
      //creacion de etiqueta
      panelRegisAdmin.setLayout(null);
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
      panelRegisAdmin.add(etiqueta);
      //etiquetas campos:
      JLabel etiquetaNombre = new JLabel();//instancia de etiqueta
    etiquetaNombre.setText("Nombre: ");//se establece el text de la etiqueta
    //etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
    etiquetaNombre.setBounds(100,100,100,20);//donde se va a ubicar
    etiquetaNombre.setForeground(Color.BLACK);//color de texto
    etiquetaNombre.setBackground(Color.WHITE);//para el fondo de la etiqueta
    etiquetaNombre.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
    etiquetaNombre.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelRegisAdmin.add(etiquetaNombre);
    //etiqueta para descrip. del sitio
    JLabel etiquetaDescripcion = new JLabel("Apellido: ");
    etiquetaDescripcion.setBounds(100, 140, 100, 20); // Ajusta las coordenadas y dimensiones
    etiquetaDescripcion.setForeground(Color.BLACK);//color de texto
    etiquetaDescripcion.setBackground(Color.WHITE);
    etiquetaDescripcion.setOpaque(true);
    etiquetaDescripcion.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelRegisAdmin.add(etiquetaDescripcion);
    
    JLabel etiquetaHorario = new JLabel("Cedula: ");
    etiquetaHorario.setBounds(100, 180, 100, 20); // Ajusta las coordenadas y dimensiones
    etiquetaHorario.setForeground(Color.BLACK);//color de texto
    etiquetaHorario.setBackground(Color.WHITE);
    etiquetaHorario.setOpaque(true);
    etiquetaHorario.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelRegisAdmin.add(etiquetaHorario);
    
    JLabel etiquetaEdad = new JLabel("Usuario: ");
    etiquetaEdad.setBounds(100, 220, 100, 20); // Ajusta las coordenadas y dimensiones
    etiquetaEdad.setForeground(Color.BLACK);//color de texto
    etiquetaEdad.setBackground(Color.WHITE);
    etiquetaEdad.setOpaque(true);
    etiquetaEdad.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelRegisAdmin.add(etiquetaEdad);
    
    JLabel etiquetaCosto = new JLabel("Contraseña: ");
    etiquetaCosto.setBounds(100, 260, 100, 20); // Ajusta las coordenadas y dimensiones
    etiquetaCosto.setForeground(Color.BLACK);//color de texto
    etiquetaCosto.setBackground(Color.WHITE);
    etiquetaCosto.setOpaque(true);
    etiquetaCosto.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelRegisAdmin.add(etiquetaCosto);
    }
    
    public void colocarBotones(){
        //boton registrar:
        //btn añadir
        JButton addButton = new JButton("Añadir"); // Crear el botón con el texto "Añadir"


        addButton.setBounds(300, 400, 100, 40); // Establecer posición y tamaño del botón
        addButton.setForeground(Color.WHITE); // Cambiar color del texto
        addButton.setBackground(new Color(59, 89, 182)); // Cambiar color de fondo
        addButton.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y el tamaño del texto
        addButton.setFocusPainted(false); // Eliminar el borde de enfoque al hacer clic
        panelRegisAdmin.add(addButton);


        addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            registrarCoordinador();
            
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
        panelRegisAdmin.add(botonVolver);
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
        areaNombre = new JTextArea();
        areaNombre.setBounds(300, 100, 300, 20);
        areaNombre.setForeground(Color.BLACK);
        areaNombre.setBackground(Color.GRAY);
        areaNombre.setText("Escribe aqui el nombre");
        areaNombre.setFont(new Font("arial", Font.PLAIN, 15));
        areaNombre.setLineWrap(true);
        panelRegisAdmin.add(areaNombre);
    
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
     areaApellido = new JTextArea();
    areaApellido.setBounds(300, 140, 300, 20);
    areaApellido.setForeground(Color.BLACK);
    areaApellido.setBackground(Color.GRAY);
    areaApellido.setText("Escribe aqui el apellido");
    areaApellido.setFont(new Font("arial", Font.PLAIN, 15));
    areaApellido.setLineWrap(true);
    panelRegisAdmin.add(areaApellido);
    
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
    areaCedula = new JTextArea();
    areaCedula.setBounds(300, 180, 300, 20);
    areaCedula.setForeground(Color.BLACK);
    areaCedula.setBackground(Color.GRAY);
    areaCedula.setText("Escribe aqui la cedula");
    areaCedula.setFont(new Font("arial", Font.PLAIN, 15));
    areaCedula.setLineWrap(true);
    panelRegisAdmin.add(areaCedula);

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
    areaUsuario = new JTextArea();
    areaUsuario.setBounds(300, 220, 300, 20);
    areaUsuario.setForeground(Color.BLACK);
    areaUsuario.setBackground(Color.GRAY);
    areaUsuario.setText("Escribe aqui el usuario");
    areaUsuario.setFont(new Font("arial", Font.PLAIN, 15));
    areaUsuario.setLineWrap(true);
    panelRegisAdmin.add(areaUsuario);

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
    
    areaPassword = new JTextArea();
    areaPassword.setBounds(300, 260, 300, 20);
    areaPassword.setForeground(Color.BLACK);
    areaPassword.setBackground(Color.GRAY);
    areaPassword.setText("Escribe aqui la contraseña");
    areaPassword.setFont(new Font("arial", Font.PLAIN, 15));
    areaPassword.setLineWrap(true);
    panelRegisAdmin.add(areaPassword);

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

    private void registrarCoordinador() {
        String nombre = areaNombre.getText().trim();
        String apellido = areaApellido.getText().trim();
        String cedula = areaCedula.getText().trim();
        String usuario = areaUsuario.getText().trim();
        String password = areaPassword.getText().trim();
    
        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            return;
        }
    
        // Validar que la cédula sea un número entero válido
        try {
            //int cedulaNumero = Integer.parseInt(cedula);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cédula debe ser un número entero válido");
            return;
        }
    
        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "INSERT INTO coordinador (nombre, apellido, cedula, usuario, password) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(2, apellido);
                statement.setString(3, cedula);
                statement.setString(1, nombre);
                statement.setString(4, usuario);
                statement.setString(5, password);
    
                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Coordinador registrado exitosamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar el coordinador");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al registrar el coordinador: " + ex.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }

    private void limpiarCampos() {
        areaNombre.setText("");
        areaApellido.setText("");
        areaCedula.setText("");
        areaUsuario.setText("");
        areaPassword.setText("");
    }
    
}