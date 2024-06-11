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
import pck_connection.*;
import pck_Turista.*;

public class cls_Iglesias extends JFrame {
    public JPanel panelIglesia;
    private JTextField searchField;
    private JList<String> resultList;
    private DefaultListModel<String> listModel;

    public cls_Iglesias() {
        this.setSize(730, 525); // Se establece el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Método para poder cerrar proceso de ventana
        setTitle("TuriPop/Iglesias"); // Título de la ventana
        setLocationRelativeTo(null); // Se establece la posición inicial de la ventana en el centro
        inciarComponentes();
        setResizable(false);
    }

    private void inciarComponentes() {
        colocarPanelesIglesia();
        colocarEtiquetas();
        colocarBarraDeBusqueda();
        colocarBotones();
    }

    public void colocarPanelesIglesia() {
        panelIglesia = new JPanel(); // Creación panel
        panelIglesia.setBackground(Color.WHITE);
        this.getContentPane().add(panelIglesia); // Se enlaza con la ventana
        panelIglesia.setLayout(null);
    }

    public void colocarEtiquetas() {
        JLabel etiqueta = new JLabel(); // Instancia de etiqueta
        etiqueta.setText("¡Iglesias de Popayan!"); // Se establece el texto de la etiqueta
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); // Alinear el texto en el margen de la etiqueta en el centro
        etiqueta.setBounds(200, 10, 345, 37); // Donde se va a ubicar
        etiqueta.setForeground(Color.BLACK); // Color de texto
        etiqueta.setBackground(Color.WHITE); // Para el fondo de la etiqueta
        etiqueta.setOpaque(true); // Se requiere este método para poder modificar los parámetros de la etiqueta que vienen por default
        etiqueta.setFont(new Font("arial", Font.BOLD, 30)); // Establecemos la fuente del texto
        panelIglesia.add(etiqueta);
    }

    public void colocarBarraDeBusqueda() {
        JLabel searchLabel = new JLabel("Buscar Iglesia:");
        searchLabel.setBounds(20, 60, 150, 30);
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panelIglesia.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(170, 60, 400, 30);
        panelIglesia.add(searchField);

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
        panelIglesia.add(searchButton);

        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(resultList);
        scrollPane.setBounds(20, 100, 660, 300);
        panelIglesia.add(scrollPane);

        resultList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String selectedIglesia = resultList.getSelectedValue();
                    mostrarInformacionIglesia(selectedIglesia);
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
                String consulta = "SELECT NOMBRE FROM SITIO_TURISTICO WHERE \"CATEGORÍA\" = 'Iglesia' AND LOWER(NOMBRE) LIKE ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, "%" + searchText + "%");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String nombreIglesia = resultSet.getString("NOMBRE");
                    listModel.addElement(nombreIglesia);
                }

                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al obtener las iglesias desde la base de datos: " + e.getMessage());
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
        panelIglesia.add(botonVolver);

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

    private void mostrarInformacionIglesia(String nombreIglesia) {
        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "SELECT NOMBRE, DESCRIPCION, HORARIO, COSTO_ENTRADA, IMAGEN FROM SITIO_TURISTICO WHERE NOMBRE = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, nombreIglesia);
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
                System.out.println("Error al obtener la información de la iglesia desde la base de datos: " + e.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }

    public static void main(String[] args) {
        cls_Iglesias ventana = new cls_Iglesias();
        ventana.setVisible(true);
    }
}
