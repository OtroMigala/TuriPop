package pck_VentanasTurista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import pck_Turista.cls_Turista;
import pck_connection.*;

public class cls_SitioInteres extends JFrame {
    public JPanel panelSitioInteres;
    private JTextField searchField;
    private JList<String> resultList;
    private DefaultListModel<String> listModel;
    //private String[] sitios = {"Parque Caldas", "Puente del Humilladero", "Iglesia de San Francisco"};

    public cls_SitioInteres() {
        this.setSize(730, 525); // Se establece el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Método para poder cerrar proceso de ventana
        setTitle("TuriPop/SitiosInteres"); // Título de la ventana
        setLocationRelativeTo(null); // Se establece la posición inicial de la ventana en el centro
        inciarComponentes();
        setResizable(false); 
    }

    private void inciarComponentes() {
        colocarPanelesSitioInteres(); 
        colocarEtiquetas();
        colocarBarraDeBusqueda();
        colocarBotones();
    }

    public void colocarPanelesSitioInteres() {
        panelSitioInteres = new JPanel(); // Creación panel 
        panelSitioInteres.setBackground(Color.WHITE);
        this.getContentPane().add(panelSitioInteres); // Se enlaza con la ventana
        panelSitioInteres.setLayout(null);
    }

    public void colocarEtiquetas() {
        JLabel etiqueta = new JLabel(); // Instancia de etiqueta
        etiqueta.setText("¡Sitios de Popayan!"); // Se establece el texto de la etiqueta
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Alinear el texto en el margen de la etiqueta en el centro
        etiqueta.setBounds(200, 10, 345, 37); // Donde se va a ubicar
        etiqueta.setForeground(Color.BLACK); // Color de texto
        etiqueta.setBackground(Color.WHITE); // Para el fondo de la etiqueta
        etiqueta.setOpaque(true); // Se requiere este método para poder modificar los parámetros de la etiqueta que vienen por default
        etiqueta.setFont(new Font("Arial", Font.BOLD, 30)); // Establecemos la fuente del texto
        panelSitioInteres.add(etiqueta);
    }


    public void colocarBarraDeBusqueda() {
        JLabel searchLabel = new JLabel("Buscar Sitio:");
        searchLabel.setBounds(20, 60, 150, 30);
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panelSitioInteres.add(searchLabel);
    
        searchField = new JTextField();
        searchField.setBounds(170, 60, 400, 30);
        panelSitioInteres.add(searchField);
    
        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(580, 60, 100, 30);
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));
        searchButton.setBackground(new Color(59, 89, 182));
        searchButton.setForeground(Color.WHITE);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarBusqueda();
            }
        });
        panelSitioInteres.add(searchButton);
    
        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(resultList);
        scrollPane.setBounds(20, 100, 660, 300);
        panelSitioInteres.add(scrollPane);
    
        // Agregar el MouseListener a resultList
        resultList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String selectedSitio = resultList.getSelectedValue();
                    mostrarInformacionSitio(selectedSitio);
                }
            }
        });
    }


   private void realizarBusqueda() {
    String searchText = searchField.getText().toLowerCase();
    listModel.clear();
    
    Connection conexion = cls_db.conectar();
    if (conexion != null) {
        try {
            String consulta = "SELECT NOMBRE FROM SITIO_TURISTICO WHERE CATEGORÍA = 'Sitio de Interés' AND LOWER(NOMBRE) LIKE ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, "%" + searchText + "%");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String nombreSitio = resultSet.getString("NOMBRE");
                listModel.addElement(nombreSitio);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los sitios de interés desde la base de datos: " + e.getMessage());
        } finally {
            cls_db.desconectar(conexion);
        }
    }
}

    public void colocarBotones() {
        JButton botonVolver = new JButton();
        botonVolver.setBounds(645, 420, 60, 60);
        botonVolver.setEnabled(true); // Habilita la interacción con el botón
        botonVolver.setForeground(Color.BLUE); // Color letra
        botonVolver.setFont(new Font("Arial", Font.BOLD, 15)); // Establecemos la fuente del texto
        ImageIcon volverIcon = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(volverIcon.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE); // Color de fondo del botón
        panelSitioInteres.add(botonVolver);

        // Acción botón volver
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual
                dispose();
                cls_Turista vTurista = new cls_Turista(); 
                vTurista.setVisible(true);
            }
        });


    }

    private void mostrarInformacionSitio(String nombreSitio) {
        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "SELECT NOMBRE, DESCRIPCION, HORARIO, COSTO_ENTRADA, IMAGEN FROM SITIO_TURISTICO WHERE NOMBRE = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, nombreSitio);
                ResultSet resultSet = statement.executeQuery();
                
                if (resultSet.next()) {
                    String nombre = resultSet.getString("NOMBRE");
                    String descripcion = resultSet.getString("DESCRIPCION");
                    String horario = resultSet.getString("HORARIO");
                    String costo = resultSet.getString("COSTO_ENTRADA");
                    byte[] imagenBytes = resultSet.getBytes("IMAGEN");
                    
                    cls_mostrarInfoST ventanaInfo = new cls_mostrarInfoST();
                    ventanaInfo.actualizarInfoSitio(nombre, descripcion, horario, costo, imagenBytes);
                    ventanaInfo.setVisible(true);
                }
                
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al obtener la información del sitio desde la base de datos: " + e.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }

    public static void main(String[] args) {
        cls_SitioInteres ventana = new cls_SitioInteres();
        ventana.setVisible(true);
    }
}