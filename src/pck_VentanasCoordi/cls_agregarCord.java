package pck_VentanasCoordi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
//import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import pck_coordinador.cls_coordinador;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//import para gestion de imagenes

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//imports para la conexión a la BD:

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import pck_connection.cls_db;

public class cls_agregarCord extends JFrame {  
    //variables para la obtención de datos de la BD:
    
    private JTextArea areaNombre;
    private JTextArea areaDescripcion;
    private JTextArea areaHorario;
    private JTextArea areaCosto;
    private File imagenSeleccionada;


    //Variables para las cajas de check

    private JCheckBox checkMuseo;
    private JCheckBox checkIglesia;
    private JCheckBox checkSitioInteres;

    public JPanel panelAgregarCoord;
    //private static final Font TEXT_AREA_FONT = new Font("Arial", Font.PLAIN, 15);
    public cls_agregarCord() {
        this.setSize(780, 600); // se establece el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // metodo para poder cerrar proceso de ventana
        setTitle("TuriPop/Logeado/Añadir Sitios Turisticos"); // titulo de la ventana  
        setLocationRelativeTo(null); // se establece la posicion incial de la ventana en el centro
        inciarComponentes();
        setResizable(false);
    }

    private void inciarComponentes() {
        colocarPanelesIglesia();
        ColocarEtiqueta();
        colocarBotones();
        ponerTxt();
        agregarCheckbox();
    }

    public void colocarPanelesIglesia() {

        panelAgregarCoord = new JPanel(); // creacion panel
        panelAgregarCoord.setBackground(Color.WHITE);
        this.getContentPane().add(panelAgregarCoord); // se enlaza con la ventana
        // creacion de etiqueta
        panelAgregarCoord.setLayout(null);
    }

    public void ColocarEtiqueta() {
     //etiqueta titulo   
     JLabel etiqueta = new JLabel();//instancia de etiqueta
    etiqueta.setText("Añade un Sitio Turistico");//se establece el text de la etiqueta
    etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
    etiqueta.setBounds(200,10,370,70);//donde se va a ubicar
    etiqueta.setForeground(Color.BLACK);//color de texto
    etiqueta.setBackground(Color.WHITE);//para el fondo de la etiqueta
    etiqueta.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
    etiqueta.setFont(new Font("arial",1,30));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiqueta);
    //etiqueta para nombre Sitio
    JLabel etiquetaNombre = new JLabel();//instancia de etiqueta
    etiquetaNombre.setText("Nombre Sitio Turistico:*");//se establece el text de la etiqueta
    etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
    etiquetaNombre.setBounds(50,100,180,20);//donde se va a ubicar
    etiquetaNombre.setForeground(Color.BLACK);//color de texto
    etiquetaNombre.setBackground(Color.WHITE);//para el fondo de la etiqueta
    etiquetaNombre.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
    etiquetaNombre.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiquetaNombre);
    //etiqueta para descrip. del sitio
    JLabel etiquetaDescripcion = new JLabel("Descripción:*");
    etiquetaDescripcion.setBounds(50, 200, 120, 20); // Ajusta las coordenadas y dimensiones
    etiquetaDescripcion.setForeground(Color.BLACK);//color de texto
    etiquetaDescripcion.setBackground(Color.WHITE);
    etiquetaDescripcion.setOpaque(true);
    etiquetaDescripcion.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiquetaDescripcion);
    
    JLabel etiquetaHorario = new JLabel("Horario de Atención:*");
    etiquetaHorario.setBounds(50, 300, 160, 20); // Ajusta las coordenadas y dimensiones
    etiquetaHorario.setForeground(Color.BLACK);//color de texto
    etiquetaHorario.setBackground(Color.WHITE);
    etiquetaHorario.setOpaque(true);
    etiquetaHorario.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiquetaHorario);
    //etiqueta para tipo
    JLabel etiquetaTipo = new JLabel("Categoria:* ");
    etiquetaTipo.setBounds(50, 360, 150, 20); // Ajusta las coordenadas y dimensiones
    etiquetaTipo.setForeground(Color.BLACK);//color de texto
    etiquetaTipo.setBackground(Color.WHITE);
    etiquetaTipo.setOpaque(true);
    etiquetaTipo.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiquetaTipo);
    
    JLabel etiquetaCosto = new JLabel("Costo de Entrada:*");
    etiquetaCosto.setBounds(50, 400, 160, 20); // Ajusta las coordenadas y dimensiones
    etiquetaCosto.setForeground(Color.BLACK);//color de texto
    etiquetaCosto.setBackground(Color.WHITE);
    etiquetaCosto.setOpaque(true);
    etiquetaCosto.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiquetaCosto);
    }

    public void colocarBotones() {
        JButton botonVolver = new JButton();
        botonVolver.setBounds(700, 490, 60, 60);
        botonVolver.setEnabled(true);//habilita la interaccion con el boton
        botonVolver.setForeground(Color.BLUE);//color letra
        botonVolver.setFont(new Font("arial", 1, 15));//establecemos la funte del texto
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);//color de fondo del boton
        panelAgregarCoord.add(botonVolver);
        //accion boton volver
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_coordinador vAgregarCoord = new cls_coordinador();
                vAgregarCoord.setVisible(true);
            }
        });
        //btn añadir
        JButton addButton = new JButton("Añadir"); // Crear el botón con el texto "Añadir"
        addButton.setBounds(300, 500, 100, 40); // Establecer posición y tamaño del botón
        addButton.setForeground(Color.WHITE); // Cambiar color del texto
        addButton.setBackground(new Color(59, 89, 182)); // Cambiar color de fondo
        addButton.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y el tamaño del texto
        addButton.setFocusPainted(false); // Eliminar el borde de enfoque al hacer clic
        panelAgregarCoord.add(addButton);
        //btn imagen
        JButton btnSeleccionarImagen = new JButton("Seleccionar Imagen");
        btnSeleccionarImagen.setBounds(300, 450, 150, 30);
        panelAgregarCoord.add(btnSeleccionarImagen);

        btnSeleccionarImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png");
                fileChooser.setFileFilter(filter);
                int resultado = fileChooser.showOpenDialog(cls_agregarCord.this);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    imagenSeleccionada = fileChooser.getSelectedFile();
                }
            }
        });
        
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = areaNombre.getText();
                String descripcion = areaDescripcion.getText();
                String horario = areaHorario.getText();
                String categoria = obtenerCategoriaSeleccionada();
                String costo = areaCosto.getText();
        
                if (validarCampos(nombre, descripcion, horario, categoria, costo)) {
                    if (nombreSitioExiste(nombre)) {
                        JOptionPane.showMessageDialog(null, "El nombre del sitio turístico ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String idSitio = generarIdSitio();
                        String ubicacion = "-"; // Valor por defecto para el campo ubicacion
        
                        if ((insertarSitioTuristico(idSitio, nombre, descripcion, ubicacion, categoria, costo, horario))) {
                            JOptionPane.showMessageDialog(null, "Sitio turístico agregado exitosamente");
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al agregar el sitio turístico", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    };

    
    public void ponerTxt(){
    //txt nombre
    areaNombre = new JTextArea();
    areaNombre.setBounds(300, 100, 400, 80);
    areaNombre.setForeground(Color.BLACK);
    areaNombre.setBackground(Color.GRAY);
    areaNombre.setText("Escribe aqui el nombre del sitio turistico");
    areaNombre.setFont(new Font("arial", Font.PLAIN, 15));
    areaNombre.setLineWrap(true);
    panelAgregarCoord.add(areaNombre);

    
    
areaNombre.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaNombre.getText().equals("Escribe aqui el nombre del sitio turistico")) {
                    areaNombre.setText("Escribe aqui el nombre del sitio turistico");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaNombre.getText().isEmpty()) {
                    areaNombre.setText("Escribe aqui el nombre del sitio turistico");
                }
            }
        });
    //txt descripc
    areaDescripcion = new JTextArea();
    areaDescripcion.setBounds(300, 200, 400, 80);
    areaDescripcion.setForeground(Color.BLACK);
    areaDescripcion.setBackground(Color.GRAY);
    areaDescripcion.setText("Escribe aqui la descripcion del sitio turistico");
    areaDescripcion.setFont(new Font("arial", Font.PLAIN, 15));
    areaDescripcion.setLineWrap(true);
    panelAgregarCoord.add(areaDescripcion);
    
areaDescripcion.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaDescripcion.getText().equals("Escribe aqui el sitio turistico")) {
                    areaDescripcion.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaDescripcion.getText().isEmpty()) {
                    areaDescripcion.setText("Escribe aqui el sitio turistico");
                }
            }
        });
    //texto Horario
    areaHorario = new JTextArea();
    areaHorario.setBounds(300, 300, 400, 40);
    areaHorario.setForeground(Color.BLACK);
    areaHorario.setBackground(Color.GRAY);
    areaHorario.setText("Escribe aqui el Horario de atencion");
    areaHorario.setFont(new Font("arial", Font.PLAIN, 15));
    areaHorario.setLineWrap(true);
    panelAgregarCoord.add(areaHorario);


    areaHorario.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaHorario.getText().equals("Escribe aqui el Horario de atencion")) {
                    areaHorario.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaHorario.getText().isEmpty()) {
                    areaHorario.setText("Escribe aqui el Hoario de atencion");
                }
            }
        });
    //txt de costo
    areaCosto = new JTextArea();
    areaCosto.setBounds(300, 400, 400, 40);
    areaCosto.setForeground(Color.BLACK);
    areaCosto.setBackground(Color.GRAY);
    areaCosto.setText("Escribe aqui el costo de la entrada");
    areaCosto.setFont(new Font("arial", Font.PLAIN, 15));
    areaCosto.setLineWrap(true);
    panelAgregarCoord.add(areaCosto);

    areaCosto.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c)) {
                e.consume();
            }
        }
    });


    areaCosto.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaCosto.getText().equals("Escribe aqui el costo de la entrada")) {
                    areaCosto.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaCosto.getText().isEmpty()) {
                    areaCosto.setText("Escribe aqui el costo de la entrada");
                }
            }
        });
        }
void agregarCheckbox(){
    // Checkboxes de categoría
    checkMuseo = new JCheckBox("Museo");
    checkMuseo.setBounds(300, 360, 80, 20);
    checkMuseo.setBackground(Color.WHITE);
    panelAgregarCoord.add(checkMuseo);


    checkIglesia = new JCheckBox("Iglesia");
    checkIglesia.setBounds(390, 360, 80, 20);
    checkIglesia.setBackground(Color.WHITE);
    panelAgregarCoord.add(checkIglesia);

    checkSitioInteres = new JCheckBox("Sitio de Interés");
    checkSitioInteres.setBounds(480, 360, 120, 20);
    checkSitioInteres.setBackground(Color.WHITE);
    panelAgregarCoord.add(checkSitioInteres);

// Agrupa los checkboxes para que solo uno pueda ser seleccionado a la vez
ButtonGroup grupoCategoria = new ButtonGroup();
grupoCategoria.add(checkMuseo);
grupoCategoria.add(checkIglesia);
grupoCategoria.add(checkSitioInteres);
    }

    private String obtenerCategoriaSeleccionada() {
    if (checkMuseo.isSelected()) {
        return "Museo";
    } else if (checkIglesia.isSelected()) {
        return "Iglesia";
    } else if (checkSitioInteres.isSelected()) {
        return "Sitio de Interés";
    } else {
        return "";
    }
}

private boolean validarCampos(String nombre, String descripcion, String horario, String categoria, String costo) {
    if (nombre.isEmpty() || nombre.equals("Escribe aqui el nombre del sitio turistico")) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del sitio turístico", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    if (descripcion.isEmpty() || descripcion.equals("Escribe aqui la descripcion del sitio turistico")) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese la descripción del sitio turístico", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    if (horario.isEmpty() || horario.equals("Escribe aqui el Horario de atencion")) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese el horario de atención", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    if (categoria.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, seleccione una categoría", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    if (costo.isEmpty() || costo.equals("Escribe aqui el costo de la entrada")) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese el costo de entrada", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    return true;
}

private String generarIdSitio() {
    int randomNum = ThreadLocalRandom.current().nextInt(1000, 10000);
    return Integer.toString(randomNum);
}


private boolean insertarSitioTuristico(String idSitio, String nombre, String descripcion, String ubicacion, String categoria, String costo, String horario) {
    Connection conexion = cls_db.conectar();
    if (conexion != null) {
        try {
            String consulta = "INSERT INTO SITIO_TURISTICO (ID_SITIO, NOMBRE, DESCRIPCION, UBICACION, CATEGORÍA, COSTO_ENTRADA, HORARIO, IMAGEN) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, idSitio);
            statement.setString(2, nombre);
            statement.setString(3, descripcion);
            statement.setString(4, ubicacion);
            statement.setString(5, categoria);
            statement.setString(6, costo);
            statement.setString(7, horario);
            
            if (imagenSeleccionada != null) {
                FileInputStream fis = new FileInputStream(imagenSeleccionada);
                statement.setBinaryStream(8, fis, (int) imagenSeleccionada.length());
            } else {
                statement.setNull(8, java.sql.Types.BLOB);
            }

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException | IOException e) {
            System.out.println("Error al insertar el sitio turístico: " + e.getMessage());
        } finally {
            cls_db.desconectar(conexion);
        }
    }
    return false;
}

private boolean nombreSitioExiste(String nombre) {
    Connection conexion = cls_db.conectar();
    if (conexion != null) {
        try {
            String consulta = "SELECT COUNT(*) FROM SITIO_TURISTICO WHERE NOMBRE = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar si el nombre del sitio existe: " + e.getMessage());
        } finally {
            cls_db.desconectar(conexion);
        }
    }
    return false;
}

private void limpiarCampos() {
    areaNombre.setText("");
    areaDescripcion.setText("");
    areaHorario.setText("");
    areaCosto.setText("");
    ButtonGroup grupoCategoria = new ButtonGroup();
    grupoCategoria.clearSelection();
} 
}