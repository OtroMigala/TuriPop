package pck_ventanasAdmin;

import javax.swing.JTextArea;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import pck_Admin.cls_ventanaAdmin;
import pck_connection.cls_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class cls_actualizarAdmin extends JFrame {
    private JList<String> listaCoordinadores;
    public JPanel panelActuaAdmin;
    private JTextArea areaCedula;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtUsuario;
    private JTextField txtPassword;

    public cls_actualizarAdmin() {
        this.setSize(730, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TuriPop/Logeado/Actualizar_Coordinador");
        setLocationRelativeTo(null);
        inciarComponentes();
        setResizable(false);
    }

    private void inciarComponentes() {
        colocarPanelesIglesia();
        colocarTitulo(); // Método para colocar el título
        ColocarEtiqueta();
        colocarBotones();
        ponertxt();
        cargarListaCoordinadores();

        JButton botonVolver = new JButton();
        botonVolver.setBounds(645, 390, 60, 60);
        botonVolver.setEnabled(true);
        botonVolver.setForeground(Color.BLUE);
        botonVolver.setFont(new Font("arial", 1, 15));
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);
        panelActuaAdmin.add(botonVolver);

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_ventanaAdmin vAdmin = new cls_ventanaAdmin();
                vAdmin.setVisible(true);
            }
        });

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_ventanaAdmin ventanaAdmin = new cls_ventanaAdmin();
                ventanaAdmin.setVisible(true);
            }
        });
    }

    private void colocarTitulo() {
        JLabel titulo = new JLabel("Editar Coordinador");
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(200, 10, 345, 37);
        panelActuaAdmin.add(titulo);
    }

    private void cargarListaCoordinadores() {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "SELECT nombre, cedula FROM coordinador";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String cedula = resultSet.getString("cedula");
                    String elemento = nombre + " - " + cedula;
                    modeloLista.addElement(elemento);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los coordinadores: " + ex.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }

        listaCoordinadores = new JList<>(modeloLista);
        listaCoordinadores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(listaCoordinadores);
        scrollPane.setBounds(50, 180, 600, 200);
        panelActuaAdmin.add(scrollPane);
    }

    public void colocarPanelesIglesia() {
        panelActuaAdmin = new JPanel();
        panelActuaAdmin.setBackground(Color.WHITE);
        this.getContentPane().add(panelActuaAdmin);
        panelActuaAdmin.setLayout(null);
    }

    public void ColocarEtiqueta() {
        JLabel etiquetaCedula = new JLabel();
        etiquetaCedula.setText("Digite la cedula de un coordinador:");
        etiquetaCedula.setHorizontalAlignment(SwingConstants.LEFT);
        etiquetaCedula.setBounds(50, 107, 280, 20);
        etiquetaCedula.setForeground(Color.BLACK);
        etiquetaCedula.setBackground(Color.WHITE);
        etiquetaCedula.setOpaque(true);
        etiquetaCedula.setFont(new Font("arial", 1, 15));
        panelActuaAdmin.add(etiquetaCedula);
    }

    public void colocarBotones() {
        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBounds(60, 400, 100, 40);
        buscarButton.setForeground(Color.WHITE);
        buscarButton.setBackground(new Color(59, 89, 182));
        buscarButton.setFont(new Font("Arial", Font.BOLD, 14));
        buscarButton.setFocusPainted(false);
        panelActuaAdmin.add(buscarButton);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCoordinador();
            }
        });
    }

    void ponertxt() {
        areaCedula = new JTextArea();
        areaCedula.setBounds(330, 100, 300, 40);
        areaCedula.setForeground(Color.BLACK);
        areaCedula.setBackground(Color.LIGHT_GRAY);
        areaCedula.setText("Escribe aqui la cedula del usuario a Buscar");
        areaCedula.setFont(new Font("arial", Font.PLAIN, 14));
        areaCedula.setLineWrap(true);
        panelActuaAdmin.add(areaCedula);

        areaCedula.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaCedula.getText().equals("Escribe aqui la cedula del usuario a Buscar")) {
                    areaCedula.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaCedula.getText().isEmpty()) {
                    areaCedula.setText("Escribe aqui la cedula del usuario a Buscar");
                }
            }
        });
    }

    private void buscarCoordinador() {
        String coordinadorSeleccionado = listaCoordinadores.getSelectedValue();

        if (coordinadorSeleccionado != null) {
            String[] datos = coordinadorSeleccionado.split(" - ");
            String cedula = datos[1];

            Connection conexion = cls_db.conectar();
            if (conexion != null) {
                try {
                    String consulta = "SELECT nombre, apellido, usuario, password FROM coordinador WHERE cedula = ?";
                    PreparedStatement statement = conexion.prepareStatement(consulta);
                    statement.setString(1, cedula);

                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        String apellido = resultSet.getString("apellido");
                        String usuario = resultSet.getString("usuario");
                        String password = resultSet.getString("password");

                        mostrarFormularioActualizacion(cedula, nombre, apellido, usuario, password);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún coordinador con la cédula seleccionada");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al buscar el coordinador: " + ex.getMessage());
                } finally {
                    cls_db.desconectar(conexion);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un coordinador de la lista");
        }
    }

    private void mostrarFormularioActualizacion(String cedula, String nombre, String apellido, String usuario, String password) {
        // Remover los componentes existentes en el panel
        panelActuaAdmin.removeAll();

        JLabel etiqueta = new JLabel();
        etiqueta.setText("Editar Coordinador");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(200, 10, 345, 37);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setBackground(Color.WHITE);
        etiqueta.setOpaque(true);
        etiqueta.setFont(new Font("arial", 1, 30));
        panelActuaAdmin.add(etiqueta);

        // Crear campos de texto para los datos del coordinador
        txtNombre = new JTextField(nombre);
        txtNombre.setBounds(200, 100, 300, 40);
        txtNombre.setForeground(Color.BLACK);
        txtNombre.setBackground(Color.LIGHT_GRAY);
        txtNombre.setFont(new Font("arial", Font.PLAIN, 15));
        panelActuaAdmin.add(txtNombre);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(100, 100, 100, 40);
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setFont(new Font("arial", Font.PLAIN, 15));
        panelActuaAdmin.add(lblNombre);

        txtApellido = new JTextField(apellido);
        txtApellido.setBounds(200, 160, 300, 40);
        txtApellido.setForeground(Color.BLACK);
        txtApellido.setBackground(Color.LIGHT_GRAY);
        txtApellido.setFont(new Font("arial", Font.PLAIN, 15));
        panelActuaAdmin.add(txtApellido);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(100, 160, 100, 40);
        lblApellido.setForeground(Color.BLACK);
        lblApellido.setFont(new Font("arial", Font.PLAIN, 15));
        panelActuaAdmin.add(lblApellido);

        txtUsuario = new JTextField(usuario);
        txtUsuario.setBounds(200, 220, 300, 40);
        txtUsuario.setForeground(Color.BLACK);
        txtUsuario.setBackground(Color.LIGHT_GRAY);
        txtUsuario.setFont(new Font("arial", Font.PLAIN, 15));
        panelActuaAdmin.add(txtUsuario);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(100, 220, 100, 40);
        lblUsuario.setForeground(Color.BLACK);
        lblUsuario.setFont(new Font("arial", Font.PLAIN, 15));
        panelActuaAdmin.add(lblUsuario);

        txtPassword = new JTextField(password);
        txtPassword.setBounds(200, 280, 300, 40);
        txtPassword.setForeground(Color.BLACK);
        txtPassword.setBackground(Color.LIGHT_GRAY);
        txtPassword.setFont(new Font("arial", Font.PLAIN, 15));
        panelActuaAdmin.add(txtPassword);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(100, 280, 100, 40);
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("arial", Font.PLAIN, 15));
        panelActuaAdmin.add(lblPassword);

        // Crear botón para actualizar los datos
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(300, 400, 100, 40);
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setBackground(new Color(59, 89, 182));
        btnActualizar.setFont(new Font("Arial", Font.BOLD, 14));
        btnActualizar.setFocusPainted(false);
        panelActuaAdmin.add(btnActualizar);

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCoordinador(cedula);
            }
        });
        JButton botonVolver = new JButton();
        botonVolver.setBounds(645, 390, 60, 60);
        botonVolver.setEnabled(true);
        botonVolver.setForeground(Color.BLUE);
        botonVolver.setFont(new Font("arial", 1, 15));
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);
        panelActuaAdmin.add(botonVolver);

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_ventanaAdmin vAdmin = new cls_ventanaAdmin();
                vAdmin.setVisible(true);
            }
        });

        // Repintar el panel para reflejar los cambios
        panelActuaAdmin.revalidate();
        panelActuaAdmin.repaint();
    }

    private void actualizarCoordinador(String cedula) {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "UPDATE coordinador SET nombre = ?, apellido = ?, usuario = ?, password = ? WHERE cedula = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setString(3, usuario);
                statement.setString(4, password);
                statement.setString(5, cedula);

                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Coordinador actualizado exitosamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el coordinador");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar el coordinador: " + ex.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }

    private void limpiarCampos() {
        areaCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtUsuario.setText("");
        txtPassword.setText("");
    }
}
