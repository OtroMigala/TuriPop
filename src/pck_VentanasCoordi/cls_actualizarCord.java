
package pck_VentanasCoordi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import pck_coordinador.cls_coordinador;
import pck_connection.cls_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//imports para gestin de la imagen

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class cls_actualizarCord extends JFrame {

    private File imagenSeleccionada;


    private JList<String> listResultados;
    private DefaultListModel<String> modeloResultados;
    public JPanel panelActualizarCord;
    public JTextField txtBusqueda;
    private JTextArea txtNombreSitio;
    private JTextArea txtDescripcion;
    private JTextArea txtHorario;
    private JTextArea txtCostoEntrada;
    private JCheckBox checkMuseo;
    private JCheckBox checkIglesia;
    private JCheckBox checkSitioInteres;
    private String nombreSitioActual;

    public cls_actualizarCord() {
        this.setSize(800, 630);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TuriPop/Editar Sitio Turistico");
        setLocationRelativeTo(null);
        inciarComponentes();
        setResizable(false);
    }

    private void inciarComponentes() {
        colocarPanelesActuaCoord();
        colocarEtiqueta();
        colocarCampoBusqueda();
        colocarCampos();
        colocarBotones();
    }

    public void colocarPanelesActuaCoord() {
        panelActualizarCord = new JPanel();
        panelActualizarCord.setBackground(Color.WHITE);
        this.getContentPane().add(panelActualizarCord);
        panelActualizarCord.setLayout(null);

        modeloResultados = new DefaultListModel<>();
        listResultados = new JList<>(modeloResultados);
        JScrollPane scrollPane = new JScrollPane(listResultados);
        scrollPane.setBounds(50, 120, 680, 100);
        panelActualizarCord.add(scrollPane);
    }

    public void colocarEtiqueta() {
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Editar Sitio Turístico");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(250, 20, 300, 40);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setBackground(Color.WHITE);
        etiqueta.setOpaque(true);
        etiqueta.setFont(new Font("arial", Font.BOLD, 24));
        panelActualizarCord.add(etiqueta);
    }

    public void colocarCampoBusqueda() {
        JLabel lblBusqueda = new JLabel("Buscar:");
        lblBusqueda.setBounds(50, 80, 100, 25);
        lblBusqueda.setFont(new Font("arial", Font.PLAIN, 16));
        panelActualizarCord.add(lblBusqueda);

        txtBusqueda = new JTextField();
        txtBusqueda.setBounds(150, 80, 400, 25);
        txtBusqueda.setFont(new Font("arial", Font.PLAIN, 16));
        panelActualizarCord.add(txtBusqueda);

        txtBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarSitiosTuristicos();
            }
        });

        listResultados.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String nombreSitio = listResultados.getSelectedValue();
                    buscarSitioTuristico(nombreSitio);
                }
            }
        });
    }

    public void colocarCampos() {
        JLabel etiquetaNombreSitio = new JLabel("Nombre del Sitio:*");
        etiquetaNombreSitio.setBounds(50, 240, 150, 20);
        panelActualizarCord.add(etiquetaNombreSitio);

        txtNombreSitio = new JTextArea();
        txtNombreSitio.setBounds(200, 240, 400, 30);
        txtNombreSitio.setFont(new Font("arial", Font.PLAIN, 15));
        panelActualizarCord.add(txtNombreSitio);

        JLabel etiquetaDescripcion = new JLabel("Descripción:*");
        etiquetaDescripcion.setBounds(50, 280, 150, 20);
        panelActualizarCord.add(etiquetaDescripcion);

        txtDescripcion = new JTextArea();
        txtDescripcion.setBounds(200, 280, 400, 100);
        txtDescripcion.setFont(new Font("arial", Font.PLAIN, 15));
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
        scrollDescripcion.setBounds(200, 280, 400, 100);
        panelActualizarCord.add(scrollDescripcion);

        JLabel etiquetaHorario = new JLabel("Horario:*");
        etiquetaHorario.setBounds(50, 390, 150, 20);
        panelActualizarCord.add(etiquetaHorario);

        txtHorario = new JTextArea();
        txtHorario.setBounds(200, 390, 400, 30);
        txtHorario.setFont(new Font("arial", Font.PLAIN, 15));
        panelActualizarCord.add(txtHorario);

        JLabel etiquetaCategoria = new JLabel("Categoría:*");
        etiquetaCategoria.setBounds(50, 430, 150, 20);
        panelActualizarCord.add(etiquetaCategoria);

        checkMuseo = new JCheckBox("Museo");
        checkMuseo.setBounds(200, 430, 80, 20);
        checkMuseo.setBackground(Color.WHITE);
        panelActualizarCord.add(checkMuseo);

        checkIglesia = new JCheckBox("Iglesia");
        checkIglesia.setBounds(290, 430, 80, 20);
        checkIglesia.setBackground(Color.WHITE);
        panelActualizarCord.add(checkIglesia);

        checkSitioInteres = new JCheckBox("Sitio de Interés");
        checkSitioInteres.setBounds(380, 430, 120, 20);
        checkSitioInteres.setBackground(Color.WHITE);
        panelActualizarCord.add(checkSitioInteres);

        ButtonGroup grupoCategoria = new ButtonGroup();
        grupoCategoria.add(checkMuseo);
        grupoCategoria.add(checkIglesia);
        grupoCategoria.add(checkSitioInteres);

        JLabel etiquetaCostoEntrada = new JLabel("Costo de Entrada:*");
        etiquetaCostoEntrada.setBounds(50, 460, 150, 20);
        panelActualizarCord.add(etiquetaCostoEntrada);

        txtCostoEntrada = new JTextArea();
        txtCostoEntrada.setBounds(200, 460, 300, 30);
        txtCostoEntrada.setFont(new Font("arial", Font.PLAIN, 15));
        panelActualizarCord.add(txtCostoEntrada);

        txtCostoEntrada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == '$')) {
                    e.consume();
                } else if (txtCostoEntrada.getText().equals("0") && Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    JButton btnSeleccionarImagen = new JButton("Seleccionar Imagen*");
    btnSeleccionarImagen.setBounds(520, 460, 150, 30);
    panelActualizarCord.add(btnSeleccionarImagen);

    // Agregar el ActionListener al botón de seleccionar imagen
    btnSeleccionarImagen.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lógica para seleccionar la imagen
            // ...
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png");
            fileChooser.setFileFilter(filter);
            int resultado = fileChooser.showOpenDialog(cls_actualizarCord.this);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                imagenSeleccionada = fileChooser.getSelectedFile();
            }
        }
    });

    }

    public void colocarBotones() {

    
        //
        JButton botonActualizar = new JButton("Actualizar");
    botonActualizar.setBounds(300, 520, 150, 30);
    botonActualizar.setForeground(Color.WHITE);
    botonActualizar.setBackground(new Color(59, 89, 182));
    botonActualizar.setFont(new Font("Arial", Font.BOLD, 14));
    botonActualizar.setFocusPainted(false);
    panelActualizarCord.add(botonActualizar);

        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSitio = txtNombreSitio.getText();
                String descripcion = txtDescripcion.getText();
                String horario = txtHorario.getText();
                String categoria = obtenerCategoriaSeleccionada();
                String costoEntrada = txtCostoEntrada.getText();

                actualizarSitioTuristico(nombreSitio, descripcion, horario, categoria, costoEntrada);
            }
        });

        JButton botonVolver = new JButton();
        botonVolver.setBounds(720, 520, 60, 60);
        botonVolver.setEnabled(true);
        botonVolver.setForeground(Color.BLUE);
        botonVolver.setFont(new Font("arial", Font.BOLD, 15));
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);
        panelActualizarCord.add(botonVolver);

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_coordinador vActuaCoord = new cls_coordinador();
                vActuaCoord.setVisible(true);
            }
        });
    }

    private void buscarSitiosTuristicos() {
        String textoBusqueda = txtBusqueda.getText().toLowerCase();
        modeloResultados.clear();

        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "SELECT NOMBRE FROM SITIO_TURISTICO WHERE LOWER(NOMBRE) LIKE ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, "%" + textoBusqueda + "%");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String nombreSitio = resultSet.getString("NOMBRE");
                    modeloResultados.addElement(nombreSitio);
                }

                statement.close();
            } catch (SQLException e) {
                System.out.println("Error al buscar sitios turísticos: " + e.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }

    private void buscarSitioTuristico(String nombreSitio) {
        if (nombreSitio != null && !nombreSitio.isEmpty()) {
            Connection conexion = cls_db.conectar();
            if (conexion != null) {
                try {
                    String consulta = "SELECT NOMBRE, DESCRIPCION, HORARIO, \"CATEGORÍA\", COSTO_ENTRADA FROM SITIO_TURISTICO WHERE LOWER(NOMBRE) = ?";
                    PreparedStatement statement = conexion.prepareStatement(consulta);
                    statement.setString(1, nombreSitio.toLowerCase());

                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        String descripcion = resultSet.getString("DESCRIPCION");
                        String horario = resultSet.getString("HORARIO");
                        String categoria = resultSet.getString("CATEGORÍA");
                        String costoEntrada = resultSet.getString("COSTO_ENTRADA");
                        mostrarResultadoBusqueda(nombreSitio, descripcion, horario, categoria, costoEntrada);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el sitio turístico", "Error", JOptionPane.ERROR_MESSAGE);
                        limpiarCampos();
                    }

                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Error al buscar el sitio turístico: " + e.getMessage());
                } finally {
                    cls_db.desconectar(conexion);
                }
            }
        }
    }

    // Agrega los imports necesarios y el botón para seleccionar la imagen

// Modifica el método actualizarSitioTuristico para incluir la imagen
private void actualizarSitioTuristico(String nombreSitio, String descripcion, String horario, String categoria, String costoEntrada) {
    if (nombreSitioActual != null && nombreSitioActual.equals(nombreSitio)) {
        Connection conexion = cls_db.conectar();
        if (conexion != null) {
            try {
                String consulta = "UPDATE SITIO_TURISTICO SET DESCRIPCION = ?, HORARIO = ?, \"CATEGORÍA\" = ?, COSTO_ENTRADA = ?, IMAGEN = ? WHERE NOMBRE = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, descripcion);
                statement.setString(2, horario);
                statement.setString(3, categoria);
                statement.setString(4, costoEntrada);
                
                if (imagenSeleccionada != null) {
                    FileInputStream fis = new FileInputStream(imagenSeleccionada);
                    statement.setBinaryStream(5, fis, (int) imagenSeleccionada.length());
                } else {
                    statement.setNull(5, java.sql.Types.BLOB);
                }
                
                statement.setString(6, nombreSitioActual);

                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Sitio turístico actualizado exitosamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el sitio turístico", "Error", JOptionPane.ERROR_MESSAGE);
                }

                statement.close();
            } catch (SQLException | IOException e) {
                System.out.println("Error al actualizar el sitio turístico: " + e.getMessage());
            } finally {
                cls_db.desconectar(conexion);
            }
        }
    }
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

    private void seleccionarCategoria(String categoria) {
        switch (categoria) {
            case "Museo":
                checkMuseo.setSelected(true);
                break;
            case "Iglesia":
                checkIglesia.setSelected(true);
                break;
            case "Sitio de Interés":
                checkSitioInteres.setSelected(true);
                break;
            default:
                break;
        }
    }
    
    private void mostrarResultadoBusqueda(String nombreSitio, String descripcion, String horario, String categoria, String costoEntrada) {
        nombreSitioActual = nombreSitio;
        txtNombreSitio.setText(nombreSitio);
        txtDescripcion.setText(descripcion);
        txtHorario.setText(horario);
        seleccionarCategoria(categoria);
        txtCostoEntrada.setText(costoEntrada);
    }

    

    

    

    

    private void limpiarCampos() {
        txtNombreSitio.setText("");
        txtDescripcion.setText("");
        txtHorario.setText("");
        txtCostoEntrada.setText("");
        checkMuseo.setSelected(false);
        checkIglesia.setSelected(false);
        checkSitioInteres.setSelected(false);
        nombreSitioActual = null;
    }
}
