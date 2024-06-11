package pck_VentanasTurista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import pck_Turista.cls_Turista;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class cls_mostrarInfoST extends JFrame {

    private JLabel lblImagen;

    private JPanel panelInfo;
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JLabel lblDescripcion;
    private JLabel lblHorario;
    private JLabel lblCosto;

    private JTextArea txtNombre;
    private JTextArea txtDescripcion;
    private JTextArea txtHorario;
    private JTextArea txtCosto;

    public cls_mostrarInfoST() {
        this.setSize(800, 600); // Se establece el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Método para poder cerrar proceso de ventana
        setTitle("TURIPOP"); // Título de la ventana
        setLocationRelativeTo(null); // Se establece la posición inicial de la ventana en el centro
        initComponents();
        setResizable(false); 
    }

    public void initComponents() {
        colocarPaneles(); 
        colocarEtiquetas();
        colocarCampos();
        colocarBotones();
        lblImagen = new JLabel();
        lblImagen.setBounds(250, 360, 300, 200);
        panelInfo.add(lblImagen);

        
    
    }

    private void colocarPaneles() {
        panelInfo = new JPanel();
        panelInfo.setBackground(Color.WHITE);
        panelInfo.setLayout(null);
        this.getContentPane().add(panelInfo);
    }

    private void colocarEtiquetas() {
        lblTitulo = new JLabel("Información del Sitio Turístico");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(100, 10, 530, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.BLACK);
        panelInfo.add(lblTitulo);

        // Etiquetas
        lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Arial", Font.BOLD, 18));
        lblNombre.setBounds(50, 60, 150, 30);
        panelInfo.add(lblNombre);

        lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setFont(new Font("Arial", Font.BOLD, 18));
        lblDescripcion.setBounds(50, 120, 150, 30);
        panelInfo.add(lblDescripcion);

        lblHorario = new JLabel("Horario de Atención:");
        lblHorario.setFont(new Font("Arial", Font.BOLD, 18));
        lblHorario.setBounds(50, 250, 200, 80);
        panelInfo.add(lblHorario);

        lblCosto = new JLabel("Costo:");
        lblCosto.setFont(new Font("Arial", Font.BOLD, 18));
        lblCosto.setBounds(50, 310, 150, 30);
        panelInfo.add(lblCosto);
    }

    private void colocarCampos() {
        // Campos de texto
        txtNombre = new JTextArea();
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        txtNombre.setBounds(250, 60, 430, 40);
        txtNombre.setLineWrap(true);
        txtNombre.setWrapStyleWord(true);
        txtNombre.setEditable(false);
        panelInfo.add(txtNombre);
    
        txtDescripcion = new JTextArea();
        txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 18));
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setEditable(false);
    
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
        scrollDescripcion.setBounds(250, 120, 430, 120);
        panelInfo.add(scrollDescripcion);
    
        txtHorario = new JTextArea();
        txtHorario.setFont(new Font("Arial", Font.PLAIN, 18));
        txtHorario.setBounds(250, 250, 430, 50);
        txtHorario.setLineWrap(true);
        txtHorario.setWrapStyleWord(true);
        txtHorario.setEditable(false);
        panelInfo.add(txtHorario);
    
        txtCosto = new JTextArea();
        txtCosto.setFont(new Font("Arial", Font.PLAIN, 18));
        txtCosto.setBounds(250, 310, 430, 30);
        txtCosto.setLineWrap(true);
        txtCosto.setWrapStyleWord(true);
        txtCosto.setEditable(false);
        panelInfo.add(txtCosto);
    }

    private void colocarBotones() {
        JButton btnVolver = new JButton();
        btnVolver.setBounds(721, 500, 60, 60);
        btnVolver.setEnabled(true);
        btnVolver.setForeground(Color.BLUE);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 15));
        ImageIcon volverIcon = new ImageIcon("volver.png");
        btnVolver.setIcon(new ImageIcon(volverIcon.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH)));
        btnVolver.setBackground(Color.WHITE);
        panelInfo.add(btnVolver);

        // Acción del botón volver
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_Turista vTurista = new cls_Turista(); 
                vTurista.setVisible(true);
            }
        });
    }

    // Método para actualizar la información del sitio turístico
    public void actualizarInfoSitio(String nombre, String descripcion, String horario, String costo, byte[] imagenBytes) {
    txtNombre.setText(nombre);
    txtDescripcion.setText(descripcion);
    txtHorario.setText(horario);
    txtCosto.setText(costo);
    
    if (imagenBytes != null) {
        try {
            BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(imagenBytes));
            ImageIcon imagenIcon = new ImageIcon(imagen.getScaledInstance(300, 200, Image.SCALE_SMOOTH));
            lblImagen.setIcon(imagenIcon);
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    } else {
        lblImagen.setIcon(null);
    }
}

    public static void main(String[] args) {
        cls_mostrarInfoST ventana = new cls_mostrarInfoST();
        ventana.setVisible(true);
    }
}