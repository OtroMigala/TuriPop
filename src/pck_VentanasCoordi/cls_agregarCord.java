package pck_VentanasCoordi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import pck_coordinador.cls_coordinador;

public class cls_agregarCord extends JFrame {
    public JPanel panelAgregarCoord;
    //private static final Font TEXT_AREA_FONT = new Font("Arial", Font.PLAIN, 15);
    public cls_agregarCord() {
        this.setSize(780, 600); // se establece el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // metodo para poder cerrar proceso de ventana
        setTitle("TuriPop/Logeado/Añadir Sitios Turisticos"); // titulo de la ventana
        setLocationRelativeTo(null); // se establece la posicion incial de la ventana en el centro
        inciarComponentes();
        setResizable(false);
    }

    private void inciarComponentes() {
        colocarPanelesIglesia();
        ColocarEtiqueta();
        colocarBotones();
        ponerTxt();
        ponerCheck();
    }

    public void colocarPanelesIglesia() {

        panelAgregarCoord = new JPanel(); // creacion panel
        panelAgregarCoord.setBackground(Color.WHITE);
        this.getContentPane().add(panelAgregarCoord); // se enlaza con la ventana
        // creacion de etiqueta
        panelAgregarCoord.setLayout(null);
    }

    public void ColocarEtiqueta() {
     //etiqueta titulo   
     JLabel etiqueta = new JLabel();//instancia de etiqueta
    etiqueta.setText("Añade un Sitio Turistico");//se establece el text de la etiqueta
    etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
    etiqueta.setBounds(200,10,345,70);//donde se va a ubicar
    etiqueta.setForeground(Color.BLACK);//color de texto
    etiqueta.setBackground(Color.WHITE);//para el fondo de la etiqueta
    etiqueta.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
    etiqueta.setFont(new Font("arial",1,30));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiqueta);
    //etiqueta para nombre Sitio
    JLabel etiquetaNombre = new JLabel();//instancia de etiqueta
    etiquetaNombre.setText("Nombre Sitio Turistico");//se establece el text de la etiqueta
    etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
    etiquetaNombre.setBounds(50,100,160,20);//donde se va a ubicar
    etiquetaNombre.setForeground(Color.BLACK);//color de texto
    etiquetaNombre.setBackground(Color.WHITE);//para el fondo de la etiqueta
    etiquetaNombre.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
    etiquetaNombre.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiquetaNombre);
    //etiqueta para descrip. del sitio
    JLabel etiquetaDescripcion = new JLabel("Descripción:");
    etiquetaDescripcion.setBounds(50, 200, 100, 20); // Ajusta las coordenadas y dimensiones
    etiquetaDescripcion.setForeground(Color.BLACK);//color de texto
    etiquetaDescripcion.setBackground(Color.WHITE);
    etiquetaDescripcion.setOpaque(true);
    etiquetaDescripcion.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiquetaDescripcion);
    
    JLabel etiquetaHorario = new JLabel("Horario de Atención:");
    etiquetaHorario.setBounds(50, 300, 150, 20); // Ajusta las coordenadas y dimensiones
    etiquetaHorario.setForeground(Color.BLACK);//color de texto
    etiquetaHorario.setBackground(Color.WHITE);
    etiquetaHorario.setOpaque(true);
    etiquetaHorario.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiquetaHorario);
    
    JLabel etiquetaEdad = new JLabel("Mayores de Edad:");
    etiquetaEdad.setBounds(50, 360, 150, 20); // Ajusta las coordenadas y dimensiones
    etiquetaEdad.setForeground(Color.BLACK);//color de texto
    etiquetaEdad.setBackground(Color.WHITE);
    etiquetaEdad.setOpaque(true);
    etiquetaEdad.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiquetaEdad);
    
    JLabel etiquetaCosto = new JLabel("Costo de Entrada:");
    etiquetaCosto.setBounds(50, 420, 150, 20); // Ajusta las coordenadas y dimensiones
    etiquetaCosto.setForeground(Color.BLACK);//color de texto
    etiquetaCosto.setBackground(Color.WHITE);
    etiquetaCosto.setOpaque(true);
    etiquetaCosto.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
    panelAgregarCoord.add(etiquetaCosto);
    }

    public void colocarBotones() {
        JButton botonVolver = new JButton();
        botonVolver.setBounds(700, 490, 60, 60);
        botonVolver.setEnabled(true);//habilita la interaccion con el boton
        botonVolver.setForeground(Color.BLUE);//color letra
        botonVolver.setFont(new Font("arial", 1, 15));//establecemos la funte del texto
        ImageIcon clicAqui4 = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(clicAqui4.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setBackground(Color.WHITE);//color de fondo del boton
        panelAgregarCoord.add(botonVolver);
        //accion boton volver
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                cls_coordinador vAgregarCoord = new cls_coordinador();
                vAgregarCoord.setVisible(true);
            }
        });
        //btn añadir
        JButton addButton = new JButton("Añadir"); // Crear el botón con el texto "Añadir"
        addButton.setBounds(300, 500, 100, 40); // Establecer posición y tamaño del botón
        addButton.setForeground(Color.WHITE); // Cambiar color del texto
        addButton.setBackground(new Color(59, 89, 182)); // Cambiar color de fondo
        addButton.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y el tamaño del texto
        addButton.setFocusPainted(false); // Eliminar el borde de enfoque al hacer clic
        panelAgregarCoord.add(addButton);
        addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }
    });
    }
    public void ponerTxt(){
    //txt nombre
    JTextArea areaNombre = new JTextArea();
    areaNombre.setBounds(300, 100, 400, 80); // Ajusta las coordenadas y dimensiones
    areaNombre.setForeground(Color.BLACK);//color de texto
    areaNombre.setBackground(Color.GRAY);
    areaNombre.setText("Escribe aqui el nombre del sitio turistico");
    areaNombre.setFont(new Font("arial", Font.PLAIN, 15));//estabecemos la fuente del txt
    areaNombre.setLineWrap(true); // Hace que el texto se ajuste automáticamente a las dimensiones del área
    panelAgregarCoord.add(areaNombre);
    
areaNombre.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaNombre.getText().equals("Escribe aqui el nombre del sitio turistico")) {
                    areaNombre.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaNombre.getText().isEmpty()) {
                    areaNombre.setText("Escribe aqui el nombre del sitio turistico");
                }
            }
        });
    //txt descripc
    JTextArea areaDescripcion = new JTextArea();
    areaDescripcion.setBounds(300, 200, 400, 80); // Ajusta las coordenadas y dimensiones
    areaDescripcion.setForeground(Color.BLACK);//color de texto
    areaDescripcion.setBackground(Color.GRAY);
    areaDescripcion.setText("Escribe aqui el sitio turistico");
    areaDescripcion.setFont(new Font("arial", Font.PLAIN, 15));//estabecemos la fuente del txt
    areaDescripcion.setLineWrap(true); // Hace que el texto se ajuste automáticamente a las dimensiones del área
    panelAgregarCoord.add(areaDescripcion);
    
areaDescripcion.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaDescripcion.getText().equals("Escribe aqui el sitio turistico")) {
                    areaDescripcion.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaDescripcion.getText().isEmpty()) {
                    areaDescripcion.setText("Escribe aqui el sitio turistico");
                }
            }
        });
    //texto Horario
    JTextArea areaHorario = new JTextArea();
    areaHorario.setBounds(300, 300, 400, 40); // Ajusta las coordenadas y dimensiones
    areaHorario.setForeground(Color.BLACK);//color de texto
    areaHorario.setBackground(Color.GRAY);
    areaHorario.setText("Escribe aqui el Hoario de atencion");
    areaHorario.setFont(new Font("arial", Font.PLAIN, 15));//estabecemos la fuente del txt
    areaHorario.setLineWrap(true); // Hace que el texto se ajuste automáticamente a las dimensiones del área
    panelAgregarCoord.add(areaHorario);
    areaHorario.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaHorario.getText().equals("Escribe aqui el Hoario de atencion")) {
                    areaHorario.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaHorario.getText().isEmpty()) {
                    areaHorario.setText("Escribe aqui el Hoario de atencion");
                }
            }
        });
    //text de mayoria de edad
    /*JTextArea areaEdad = new JTextArea();
    areaEdad.setBounds(500, 460, 190, 20); // Ajusta las coordenadas y dimensiones
    areaEdad.setForeground(Color.BLACK);//color de texto
    areaEdad.setBackground(Color.GRAY);
    areaEdad.setText("Escribe aqui la edad minima");
    areaEdad.setFont(new Font("arial", Font.PLAIN, 15));//estabecemos la fuente del txt
    areaEdad.setLineWrap(true); // Hace que el texto se ajuste automáticamente a las dimensiones del área
    panelAgregarCoord.add(areaEdad);
    areaEdad.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaEdad.getText().equals("Escribe aqui la edad minima")) {
                    areaEdad.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaEdad.getText().isEmpty()) {
                    areaEdad.setText("Escribe aqui la edad minima");
                }
            }
        });*/
    //txt de costo
    JTextArea areaCosto= new JTextArea();
    areaCosto.setBounds(300, 420, 400, 40); // Ajusta las coordenadas y dimensiones
    areaCosto.setForeground(Color.BLACK);//color de texto
    areaCosto.setBackground(Color.GRAY);
    areaCosto.setText("Escribe aqui el costo de la entrada");
    areaCosto.setFont(new Font("arial", Font.PLAIN, 15));//estabecemos la fuente del txt
    areaCosto.setLineWrap(true); // Hace que el texto se ajuste automáticamente a las dimensiones del área
    panelAgregarCoord.add(areaCosto);
    areaCosto.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (areaCosto.getText().equals("Escribe aqui el costo de la entrada")) {
                    areaCosto.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (areaCosto.getText().isEmpty()) {
                    areaCosto.setText("Escribe aqui el costo de la entrada");
                }
            }
        });
        /*String[] defaultTexts = {"Escribe aquí el sitio turístico", "Escribe aquí el horario de atención", "Escribe aquí si tiene restricción de edad", "Escribe aquí el costo de la entrada"};
        int[] textAreaYPositions = {100, 200, 260, 320};

        for (int i = 0; i < defaultTexts.length; i++) {
            JTextArea textArea = new JTextArea();
            textArea.setBounds(300, textAreaYPositions[i], 400, 40);
            textArea.setForeground(Color.BLACK);
            textArea.setBackground(Color.GRAY);
            textArea.setText(defaultTexts[i]);
            textArea.setFont(TEXT_AREA_FONT);
            textArea.setLineWrap(true);
            panelAgregarCoord.add(textArea);*/
        }
    public void ponerCheck(){
    JCheckBox checkBoxEdad = new JCheckBox("¿Mayores de Edad?");
    checkBoxEdad.setBounds(300, 360, 150, 20); // Ajusta las coordenadas y dimensiones
    panelAgregarCoord.add(checkBoxEdad);

   }
}
