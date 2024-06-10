package pck_VentanasCoordi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import pck_coordinador.cls_coordinador;

public class cls_actualizarCord extends JFrame {
    public JPanel panelActualizarCord;
    public JTextField txtNombreSitio;
    private String descripcion;
    private String horario;
    private String edad;
    private String costo;// Campo para ingresar el nuevo nombre del sitio turístico

    public cls_actualizarCord() {
        this.setSize(730, 500); // se establece el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // metodo para poder cerrar proceso de ventana
        setTitle("TuriPop/Editar Sitio Turistico"); // titulo de la ventana
        setLocationRelativeTo(null); // se establece la posicion incial de la ventana en el centro
        inciarComponentes();
        setResizable(false);
    }

    private void inciarComponentes() {
        colocarPanelesActuaCoord();
        ColocarEtiqueta();
        colocarCampos();
        colocarBotones();
    }

    public void colocarPanelesActuaCoord() {
        panelActualizarCord = new JPanel(); // creacion panel
        panelActualizarCord.setBackground(Color.WHITE);
        this.getContentPane().add(panelActualizarCord); // se enlaza con la ventana
        // creacion de etiqueta
        panelActualizarCord.setLayout(null);
    }

    public void ColocarEtiqueta() {
        JLabel etiqueta = new JLabel();//instancia de etiqueta
        etiqueta.setText("Editar S.T");//se establece el text de la etiqueta
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
        etiqueta.setBounds(200,10,345,37);//donde se va a ubicar
        etiqueta.setForeground(Color.BLACK);//color de texto
        etiqueta.setBackground(Color.WHITE);//para el fondo de la etiqueta
        etiqueta.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
        etiqueta.setFont(new Font("arial",1,30));//estabecemos la fuente del txt
        panelActualizarCord.add(etiqueta);
    }

    public void colocarCampos() {
        // Etiqueta y campo para el nuevo nombre del sitio turístico
        JLabel etiquetaNombreSitio = new JLabel("Nombre del Sitio:");
        etiquetaNombreSitio.setBounds(50, 100, 150, 20);
        panelActualizarCord.add(etiquetaNombreSitio);

        txtNombreSitio = new JTextField();
        txtNombreSitio.setBounds(200, 100, 400, 20);
        panelActualizarCord.add(txtNombreSitio);
    }

    public void colocarBotones() {
        JButton botonActualizar = new JButton("Editar Sitio");
    botonActualizar.setBounds(300, 150, 150, 30);
        botonActualizar.setForeground(Color.WHITE); // Cambiar color del texto
        botonActualizar.setBackground(new Color(59, 89, 182)); // Cambiar color de fondo
        botonActualizar.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y el tamaño del texto
        botonActualizar.setFocusPainted(false); // Eliminar el borde de enfoque al hacer clic
        panelActualizarCord.add(botonActualizar);
    botonActualizar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreSitio = txtNombreSitio.getText();
            // Obtener los otros campos necesarios para mostrar en la ventana de detalle

            // Aquí iría el código para obtener la información actualizada del sitio turístico
            // Puedes modificar o agregar los campos necesarios según sea necesario

            // Crear una instancia de VentanaDetalleSitio con la información actualizada
            cls_detalleSitio ventanaDetalle = new cls_detalleSitio(nombreSitio, descripcion, horario, edad, costo);
            ventanaDetalle.setVisible(true);
        }
    });
    panelActualizarCord.add(botonActualizar);

        JButton botonVolver = new JButton();
        botonVolver.setBounds(645,390,60,60);
        botonVolver.setEnabled(true);//habilita la interaccion con el boton
        botonVolver.setForeground(Color.BLUE);//color letra
        botonVolver.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);//color de fondo del boton
        panelActualizarCord.add(botonVolver);

        //accion boton volver
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_coordinador vActuaCoord = new cls_coordinador();
                vActuaCoord.setVisible(true);
            }
        });
    }
}
