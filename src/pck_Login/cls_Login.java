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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import pck_Admin.cls_ventanaAdmin;
import pck_configuracion.cls_Configuracion;
import pck_coordinador.cls_coordinador;
import pck_connection.cls_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class cls_Login extends JFrame {
    private JButton btn_LogIn;
    private JLabel etiqueta_LogIn;
    private boolean esLoginAdministrador;
    public JPanel panelLogIn;
    private JTextField cajatextoAdmin;
    private JPasswordField contrasenaField;

    public cls_Login(boolean esLoginAdministrador) {
        this.esLoginAdministrador = esLoginAdministrador;
        this.setSize(730, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TuriPop/LogIn");
        setLocationRelativeTo(null);
        inciarComponentes();
        setResizable(false);
    }

    private void inciarComponentes() {
        colocarPanelesLogIn();
        colocarEtiquetasLogIn();
        colocarBotonesLogIn();
        colocarCajasDeTexto();
        colocarCajasDePass();

        if (esLoginAdministrador) {
            btn_LogIn.setVisible(false);
            etiqueta_LogIn.setVisible(false);
        }
    }

    private void colocarPanelesLogIn() {
        panelLogIn = new JPanel();
        panelLogIn.setBackground(Color.WHITE);
        this.getContentPane().add(panelLogIn);
        panelLogIn.setLayout(null);
    }

    private void colocarEtiquetasLogIn() {
        etiqueta_LogIn = new JLabel();
        etiqueta_LogIn.setText("click para ingresar:");
        etiqueta_LogIn.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta_LogIn.setBounds(120, 288, 150, 35);
        etiqueta_LogIn.setForeground(Color.BLACK);
        etiqueta_LogIn.setBackground(Color.white);
        etiqueta_LogIn.setOpaque(true);
        etiqueta_LogIn.setFont(new Font("arial", 1, 14));
        panelLogIn.add(etiqueta_LogIn);

        JLabel etiqueta = new JLabel();
        etiqueta.setText("Iniciar Sesión");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(200, 10, 345, 37);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setBackground(Color.WHITE);
        etiqueta.setOpaque(true);
        etiqueta.setFont(new Font("arial", 1, 30));
        panelLogIn.add(etiqueta);

        JLabel etq_Usuario = new JLabel();
        etq_Usuario.setText("Digite su usuario: ");
        etq_Usuario.setHorizontalAlignment(SwingConstants.LEFT);
        etq_Usuario.setBounds(100, 100, 140, 30);
        etq_Usuario.setForeground(Color.BLACK);
        etq_Usuario.setBackground(Color.WHITE);
        etq_Usuario.setOpaque(true);
        etq_Usuario.setFont(new Font("arial", 1, 15));
        panelLogIn.add(etq_Usuario);

        JLabel etiqueta_Contrasena = new JLabel();
        etiqueta_Contrasena.setText("Digite su contraseña:");
        etiqueta_Contrasena.setHorizontalAlignment(SwingConstants.LEFT);
        etiqueta_Contrasena.setBounds(100, 150, 150, 28);
        etiqueta_Contrasena.setForeground(Color.BLACK);
        etiqueta_Contrasena.setFont(new Font("arial", 1, 14));
        panelLogIn.add(etiqueta_Contrasena);

        ImageIcon imagenLogIn = new ImageIcon("LogIn.png");
        JLabel label_imagenLogIn = new JLabel();
        label_imagenLogIn.setBounds(320, 70, 246, 246);
        label_imagenLogIn.setIcon(new ImageIcon(imagenLogIn.getImage().getScaledInstance(label_imagenLogIn.getWidth(), label_imagenLogIn.getHeight(), Image.SCALE_SMOOTH)));
        panelLogIn.add(label_imagenLogIn);
        label_imagenLogIn.setBounds(440, 70, 256, 256);
    }

    private void colocarBotonesLogIn() {
        ImageIcon clicAqui = new ImageIcon("acceso.png");

    btn_LogIn = new JButton();
    btn_LogIn.setBounds(300, 270, 80, 80);
    btn_LogIn.setEnabled(true);
    btn_LogIn.setForeground(Color.BLUE);
    btn_LogIn.setFont(new Font("arial", 1, 15));
    btn_LogIn.setIcon(new ImageIcon(clicAqui.getImage().getScaledInstance(btn_LogIn.getWidth(), btn_LogIn.getHeight(), Image.SCALE_SMOOTH)));
    btn_LogIn.setBackground(Color.WHITE);
    panelLogIn.add(btn_LogIn);
    btn_LogIn.requestFocusInWindow();

    JButton btn_LogInAdmin = new JButton();

    if (esLoginAdministrador) {
        btn_LogInAdmin.setBounds(300, 270, 80, 80);
        btn_LogInAdmin.setEnabled(true);
        btn_LogInAdmin.setForeground(Color.BLUE);
        btn_LogInAdmin.setFont(new Font("arial", 1, 15));
        btn_LogInAdmin.setIcon(new ImageIcon(clicAqui.getImage().getScaledInstance(btn_LogInAdmin.getWidth(), btn_LogInAdmin.getHeight(), Image.SCALE_SMOOTH)));
        btn_LogInAdmin.setBackground(Color.WHITE);
        panelLogIn.add(btn_LogInAdmin);

        btn_LogInAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String usuario = cajatextoAdmin.getText();
                String contrasena = new String(contrasenaField.getPassword());

                if (validarAdministrador(usuario, contrasena)) {
                    cls_ventanaAdmin ventanaAdmin = new cls_ventanaAdmin();
                    ventanaAdmin.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

        ActionListener accionUser = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String usuario = cajatextoAdmin.getText();
                String contrasena = new String(contrasenaField.getPassword());
                
                if (validarUsuario(usuario, contrasena)) {
                    dispose(); // Cierra la ventana de login
                    cls_coordinador ventanaCoordi = new cls_coordinador();
                    ventanaCoordi.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        btn_LogIn.addActionListener(accionUser);

        JButton botonVolver = new JButton();
        botonVolver.setBounds(645, 390, 60, 60);
        botonVolver.setEnabled(true);
        botonVolver.setMnemonic('d');
        botonVolver.setForeground(Color.BLUE);
        botonVolver.setFont(new Font("arial", 1, 15));
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);
        panelLogIn.add(botonVolver);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_Configuracion v1 = new cls_Configuracion();
                v1.setVisible(true);
            }
        });
    }

    private void colocarCajasDeTexto() {
        cajatextoAdmin = new JTextField();
        cajatextoAdmin.setBounds(250, 100, 140, 28);
        cajatextoAdmin.setText("Escribe aquí tu usuario");
        panelLogIn.add(cajatextoAdmin);
        cajatextoAdmin.setFont(new Font("arial", 1, 12));

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
        contrasenaField = new JPasswordField();
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
                if (String.valueOf(contrasenaField.getPassword()).equals("Digite su contraseña:")) {
                    contrasenaField.setText("");
                }
            }
        });
    }

    private boolean validarUsuario(String usuario, String contrasena) {
        boolean usuarioValido = false;

        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "SELECT COUNT(*) FROM coordinador WHERE usuario = ? AND password = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, usuario);
                statement.setString(2, contrasena);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    usuarioValido = count > 0;
                }

                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al validar el usuario: " + e.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }

        return usuarioValido;
    }

    private boolean validarAdministrador(String usuario, String contrasena) {
        boolean administradorValido = false;

        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "SELECT COUNT(*) FROM ADMINISTRADOR WHERE USUARIO = ? AND PASSWORD = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, usuario);
                statement.setString(2, contrasena);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    administradorValido = count > 0;
                }

                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al validar el administrador: " + e.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }

        return administradorValido;
    }
}