package pck_VentanasTurista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import pck_Turista.cls_Turista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pck_connection.cls_db;

public class cls_Museos extends JFrame {
    public JPanel panelMuseo;
    private JTextField searchField;
    private JList<String> resultList;
    private DefaultListModel<String> listModel;

    public cls_Museos() {
        this.setSize(730, 525); // Se establece el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Método para poder cerrar proceso de ventana
        setTitle("TuriPop/Museos"); // Título de la ventana
        setLocationRelativeTo(null); // Se establece la posición inicial de la ventana en el centro
        inciarComponentes();
        setResizable(false); 
    }

    private void inciarComponentes() {
        colocarPanelesMuseo(); 
        colocarEtiquetas();
        colocarBarraDeBusqueda();
        colocarBotones();
    }

    public void colocarPanelesMuseo() {
        panelMuseo = new JPanel(); // Creación panel 
        panelMuseo.setBackground(Color.WHITE);
        this.getContentPane().add(panelMuseo); // Se enlaza con la ventana
        panelMuseo.setLayout(null);
    }

    public void colocarEtiquetas() {
        JLabel etiqueta = new JLabel(); // Instancia de etiqueta
        etiqueta.setText("¡Museos de Popayan!"); // Se establece el texto de la etiqueta
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Alinear el texto en el margen de la etiqueta en el centro
        etiqueta.setBounds(200, 10, 345, 37); // Donde se va a ubicar
        etiqueta.setForeground(Color.BLACK); // Color de texto
        etiqueta.setBackground(Color.WHITE); // Para el fondo de la etiqueta
        etiqueta.setOpaque(true); // Se requiere este método para poder modificar los parámetros de la etiqueta que vienen por default
        etiqueta.setFont(new Font("arial", Font.BOLD, 30)); // Establecemos la fuente del texto
        panelMuseo.add(etiqueta);
    }

    public void colocarBarraDeBusqueda() {
        JLabel searchLabel = new JLabel("Buscar Museo:");
        searchLabel.setBounds(20, 60, 150, 30);
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panelMuseo.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(170, 60, 400, 30);
        panelMuseo.add(searchField);

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
        panelMuseo.add(searchButton);

        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(resultList);
        scrollPane.setBounds(20, 100, 660, 300);
        panelMuseo.add(scrollPane);

        // Agregar el MouseListener a resultList
        resultList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String selectedMuseo = resultList.getSelectedValue();
                    mostrarInformacionMuseo(selectedMuseo);
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
                String consulta = "SELECT NOMBRE FROM SITIO_TURISTICO WHERE CATEGORÍA = 'Museo' AND LOWER(NOMBRE) LIKE ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, "%" + searchText + "%");
                ResultSet resultSet = statement.executeQuery();
                
                while (resultSet.next()) {
                    String nombreMuseo = resultSet.getString("NOMBRE");
                    listModel.addElement(nombreMuseo);
                }
                
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al obtener los museos desde la base de datos: " + e.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }

    // Modifica el método mostrarInformacionMuseo y mostrarInformacionIglesia
private void mostrarInformacionMuseo(String nombreMuseo) {
    Connection conexion = cls_db.conectar();
    if (conexion != null) {
        try {
            String consulta = "SELECT NOMBRE, DESCRIPCION, HORARIO, COSTO_ENTRADA, IMAGEN FROM SITIO_TURISTICO WHERE NOMBRE = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombreMuseo);
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
            System.out.println("Error al obtener la información del museo desde la base de datos: " + e.getMessage());
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
        panelMuseo.add(botonVolver);

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

    /*public static void main(String[] args) {
        cls_Museos ventana = new cls_Museos();
        ventana.setVisible(true);
    }*/
}
