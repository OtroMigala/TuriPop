package pck_VentanasCoordi;

import java.awt.Color;
import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
//import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/*import pck_connection.cls_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;*/

//import pck_VentanasCoordi.*;
public class cls_buscarSitio extends JFrame {
    public JPanel panelBuscarSitio;
    public JTextField txtNombreSitio;

    public cls_buscarSitio() {
        this.setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TuriPop/Buscar Sitio Turistico");
        setLocationRelativeTo(null);
        iniciarComponentes();
        setResizable(false);
    }

    private void iniciarComponentes() {
        colocarPaneles();
        colocarEtiquetas();
        colocarCampos();
        colocarBotones();
    }

    private void colocarPaneles() {
        panelBuscarSitio = new JPanel();
        panelBuscarSitio.setBackground(Color.WHITE);
        this.getContentPane().add(panelBuscarSitio);
        panelBuscarSitio.setLayout(null);
    }

    private void colocarEtiquetas() {
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Buscar Sitio Turístico");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(0, 20, 400, 30);
        etiqueta.setFont(new Font("arial", Font.BOLD, 20));
        panelBuscarSitio.add(etiqueta);

        JLabel etiquetaNombreSitio = new JLabel("Nombre del Sitio:");
        etiquetaNombreSitio.setBounds(20, 60, 150, 20);
        panelBuscarSitio.add(etiquetaNombreSitio);
    }

    private void colocarCampos() {
        txtNombreSitio = new JTextField();
        txtNombreSitio.setBounds(150, 60, 200, 25);
        panelBuscarSitio.add(txtNombreSitio);
    }

    private void colocarBotones() {
        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(150, 100, 100, 30);
        botonBuscar.setBackground(new Color(59, 89, 182));
        botonBuscar.setForeground(Color.WHITE);
        botonBuscar.setFont(new Font("Arial", Font.BOLD, 14));
        botonBuscar.setFocusPainted(false);
        panelBuscarSitio.add(botonBuscar);

       /* *botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSitio = txtNombreSitio.getText();
                buscarSitioTuristico(nombreSitio);
            }
        });*/
    }

   /*  private void buscarSitioTuristico(String nombreSitio) {
        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "SELECT NOMBRE, UBICACION, CATEGORÍA, COSTO_ENTRADA FROM SITIO_TURISTICO WHERE NOMBRE = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, nombreSitio);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String nombre = resultSet.getString("NOMBRE");
                    String descripcion = resultSet.getString("UBICACION");
                    String categoria = resultSet.getString("CATEGORÍA");
                    String costoEntrada = resultSet.getString("COSTO_ENTRADA");

                  //  cls_actualizarCord ventanaActualizar = new cls_actualizarCord(nombre, descripcion, categoria, costoEntrada);
                 //   ventanaActualizar.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el sitio turístico", "Error", JOptionPane.ERROR_MESSAGE);
                }

                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al buscar el sitio turístico: " + e.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }*/
}