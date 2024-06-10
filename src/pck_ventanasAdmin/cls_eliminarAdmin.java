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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
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

public class cls_eliminarAdmin extends JFrame {
    public JPanel panelEliminAdmin;
    private JTextArea areaCedula;

    public cls_eliminarAdmin() {
        this.setSize(730, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TuriPop/Logeo/Eliminar_Coordinador");
        setLocationRelativeTo(null);
        inciarComponentes();
        setResizable(false);
    }

    private void inciarComponentes() {
        colocarPanelesIglesia();
        ColocarEtiqueta();
        colocarBotones();
        ponertxt();
    }

    public void colocarPanelesIglesia() {
        panelEliminAdmin = new JPanel();
        panelEliminAdmin.setBackground(Color.WHITE);
        this.getContentPane().add(panelEliminAdmin);
        panelEliminAdmin.setLayout(null);
    }

    public void ColocarEtiqueta() {
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Eliminar coord");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(200, 10, 345, 37);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setBackground(Color.WHITE);
        etiqueta.setOpaque(true);
        etiqueta.setFont(new Font("arial", 1, 30));
        panelEliminAdmin.add(etiqueta);

        JLabel etiquetaCedula = new JLabel();
        etiquetaCedula.setText("Cedula: ");
        etiquetaCedula.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaCedula.setBounds(150, 100, 100, 20);
        etiquetaCedula.setForeground(Color.BLACK);
        etiquetaCedula.setBackground(Color.WHITE);
        etiquetaCedula.setOpaque(true);
        etiquetaCedula.setFont(new Font("arial", 1, 15));
        panelEliminAdmin.add(etiquetaCedula);
    }

    public void colocarBotones() {
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.setBounds(300, 200, 100, 40);
        eliminarButton.setForeground(Color.WHITE);
        eliminarButton.setBackground(new Color(59, 89, 182));
        eliminarButton.setFont(new Font("Arial", Font.BOLD, 14));
        eliminarButton.setFocusPainted(false);
        panelEliminAdmin.add(eliminarButton);

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCoordinador();
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
        panelEliminAdmin.add(botonVolver);

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_ventanaAdmin vAdmin = new cls_ventanaAdmin();
                vAdmin.setVisible(true);
            }
        });
    }

    void ponertxt() {
        areaCedula = new JTextArea();
        areaCedula.setBounds(300, 100, 200, 40);
        areaCedula.setForeground(Color.BLACK);
        areaCedula.setBackground(Color.GRAY);
        areaCedula.setText("Escribe aqui la cedula del usuario a eliminar");
        areaCedula.setFont(new Font("arial", Font.PLAIN, 15));
        areaCedula.setLineWrap(true);
        panelEliminAdmin.add(areaCedula);

        areaCedula.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaCedula.getText().equals("Escribe aqui la cedula del usuario a eliminar")) {
                    areaCedula.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaCedula.getText().isEmpty()) {
                    areaCedula.setText("Escribe aqui la cedula del usuario a eliminar");
                }
            }
        });
    }

    private void eliminarCoordinador() {
        String cedula = areaCedula.getText().trim();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una cédula válida");
            return;
        }

        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "DELETE FROM coordinador WHERE cedula = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, cedula);

                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Coordinador eliminado exitosamente");
                    areaCedula.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún coordinador con la cédula ingresada");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el coordinador: " + ex.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }
}