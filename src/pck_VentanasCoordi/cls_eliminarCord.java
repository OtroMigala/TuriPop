package pck_VentanasCoordi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import pck_coordinador.cls_coordinador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import pck_connection.cls_db;

public class cls_eliminarCord extends JFrame {

    private JList<String> listSitiosTuristicos;
    private DefaultListModel<String> listModel;
    public JPanel panelElimCoord;
    private JTextField txtBusqueda;

    public cls_eliminarCord() {
        this.setSize(730, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TuriPop/Eliminar Sitio Turistico");
        setLocationRelativeTo(null);
        inciarComponentes();
        cargarSitiosTuristicos();
        setResizable(false);
    }

    private void inciarComponentes() {
        colocarPanelesElemCoord();
        colocarEtiqueta();
        colocarCampoBusqueda();
        colocarBotones();
    }

    public void colocarPanelesElemCoord() {
        panelElimCoord = new JPanel();
        panelElimCoord.setBackground(Color.WHITE);
        this.getContentPane().add(panelElimCoord);
        panelElimCoord.setLayout(null);

        listModel = new DefaultListModel<>();
        listSitiosTuristicos = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listSitiosTuristicos);
        scrollPane.setBounds(50, 120, 600, 200);
        panelElimCoord.add(scrollPane);
    }

    public void colocarEtiqueta() {
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Eliminar Sitio Turístico");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(200, 20, 345, 37);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setBackground(Color.WHITE);
        etiqueta.setOpaque(true);
        etiqueta.setFont(new Font("arial", Font.BOLD, 24));
        panelElimCoord.add(etiqueta);
    }

    public void colocarCampoBusqueda() {
        JLabel lblBusqueda = new JLabel("Buscar:");
        lblBusqueda.setBounds(50, 80, 100, 25);
        lblBusqueda.setFont(new Font("arial", Font.PLAIN, 16));
        panelElimCoord.add(lblBusqueda);

        txtBusqueda = new JTextField();
        txtBusqueda.setBounds(150, 80, 400, 25);
        txtBusqueda.setFont(new Font("arial", Font.PLAIN, 16));
        panelElimCoord.add(txtBusqueda);

        txtBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarSitiosTuristicos();
            }
        });
    }

    public void colocarBotones() {
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(50, 350, 100, 30);
        btnEliminar.setFont(new Font("arial", Font.PLAIN, 14));
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sitioSeleccionado = listSitiosTuristicos.getSelectedValue();
                if (sitioSeleccionado != null) {
                    int option = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este sitio turístico?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        eliminarSitioTuristico(sitioSeleccionado);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un sitio turístico para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panelElimCoord.add(btnEliminar);

        JButton botonVolver = new JButton();
        botonVolver.setBounds(645, 410, 60, 60);
        botonVolver.setEnabled(true);
        botonVolver.setForeground(Color.BLUE);
        botonVolver.setFont(new Font("arial", Font.BOLD, 15));
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);
        panelElimCoord.add(botonVolver);

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_coordinador vElimiCoord = new cls_coordinador();
                vElimiCoord.setVisible(true);
            }
        });
    }

    private void cargarSitiosTuristicos() {
        listModel.clear();

        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "SELECT NOMBRE FROM SITIO_TURISTICO";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String nombreSitio = resultSet.getString("NOMBRE");
                    listModel.addElement(nombreSitio);
                }

                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al obtener los sitios turísticos desde la base de datos: " + e.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }

    private void buscarSitiosTuristicos() {
        String textoBusqueda = txtBusqueda.getText().toLowerCase();
        listModel.clear();

        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "SELECT NOMBRE FROM SITIO_TURISTICO WHERE LOWER(NOMBRE) LIKE ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, "%" + textoBusqueda + "%");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String nombreSitio = resultSet.getString("NOMBRE");
                    listModel.addElement(nombreSitio);
                }

                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al buscar sitios turísticos: " + e.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }

    private void eliminarSitioTuristico(String nombreSitio) {
        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "DELETE FROM SITIO_TURISTICO WHERE NOMBRE = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, nombreSitio);

                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Sitio turístico eliminado exitosamente.");
                    cargarSitiosTuristicos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el sitio turístico.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al eliminar el sitio turístico: " + e.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }
}