package pck_Inicio;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pck_connection.*;*/

import javax.swing.ImageIcon;
import javax.swing.JButton;
//import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import pck_Turista.cls_Turista;
//import javax.swing.DefaultListModel; // Import the DefaultListModel class

    public class cls_Ventana extends JFrame {
      public JPanel panel; //se crea un atributo de tipo panel, esto se hizo para independencia de metodos en etiquetas

      public cls_Ventana() {
        this.setSize(800, 500);//ee stablece el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);//metodo para poder cerrar proceso de ventana
        setTitle("TuriPop/Inicio");//titulo de la ventana
        setLocationRelativeTo(null);//se establece la posicion incial de la ventana en el centro
        //setLocation(500, 500); para poder ponerlo en una localizacion exacata
        //setBounds(700,200, 600, 600);//sirve para poner los parametors de la posicion y tamaño inciales
        //this.getContentPane().setBackground(Color.CYAN);
        inciarComponentes();
        setResizable(false);
      }

      private void inciarComponentes() {
        colocarPaneles();
        colocarEtiquetas();
        colocarBotones();
      }

      private void colocarPaneles() {
        panel = new JPanel();//solo se crea el panel y se instancia
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);//se enlaza con la ventana
        //creacion de etiqueta
        panel.setLayout(null);
      }

      private void colocarEtiquetas() {
        JLabel etiqueta = new JLabel();//instancia de etiqueta
        etiqueta.setText("¡Bienvenido a TuriPop!");//se establece el text de la etiqueta
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
        etiqueta.setBounds(200, 10, 345, 40);//donde se va a ubicar
        etiqueta.setForeground(Color.BLACK);//color de texto
        Color colorPersonalizado1 = new Color(60, 135, 208);//aqui va el RGB
        etiqueta.setBackground(colorPersonalizado1);
        etiqueta.setOpaque(true);//para el fondo de la etiqueta
        etiqueta.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
        etiqueta.setFont(new Font("arial", 1, 30));//estabecemos la fuente del txt
        panel.add(etiqueta);//agregamos la etiqueta a el panel

        //ETIQEUTA 2
        ImageIcon imagen = new ImageIcon("turismo.png");
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setBounds(320, 70, 256, 256);//parametros de la etiqueta
        //setIcon permite concatenar el ancho de la etiqueta al ancho de la imagen
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(),//recoge el ancho
            etiqueta2.getHeight(),//recoge el alto
            Image.SCALE_SMOOTH)));//pone el tipo de imagen en smooth
        panel.add(etiqueta2);
        etiqueta2.setBounds(450, 70, 256, 256);//editar aqui

        //ETIQUETA 3
        JLabel etiqueta3 = new JLabel();
        etiqueta3.setText("Da click para turistear:");
        etiqueta3.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta3.setForeground(Color.BLACK);
        // Define un color personalizado usando RGB
        Color colorPersonalizado = new Color(60, 135, 208);//aqui va el RGB
        etiqueta3.setBackground(colorPersonalizado);
        etiqueta3.setOpaque(true);
        etiqueta3.setBounds(60, 100, 300, 50);
        etiqueta3.setFont(new Font("arial", 1, 25));
        panel.add(etiqueta3);
        /*ETIQUETA 5 INGRESAR COMO ADMIN
        JLabel etiqueta5=new JLabel();
        etiqueta5.setText("Ingresar como admin:");
        etiqueta5.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta5.setBackground(Color.GRAY);
        etiqueta5.setForeground(Color.BLACK);
        etiqueta5.setBounds(5,270,300,80);
        etiqueta5.setFont(new Font("arial",1,20));
        panel.add(etiqueta5);*/
      }

      private void colocarBotones() {
        //BOTON INGRESAR A PLATAFORMA
        JButton boton2 = new JButton();
        boton2.setBounds(160, 170, 150, 150);
        boton2.setEnabled(true);//habilita la interaccion con el boton
        ImageIcon clicAqui2 = new ImageIcon("entrar.png");
        boton2.setIcon(new ImageIcon(clicAqui2.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setBackground(Color.WHITE);//color de fondo del boton
        panel.add(boton2);
        //ACCIONES DE BOTONES
        //BOTON ADMIN
        /*ActionListener accionAdmin = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
                cls_ventanaAdmin v2 =new cls_ventanaAdmin();
                v2.setVisible(true);
                dispose();//cierra la ventana anterior
          }
        };
        //boton2.addActionListener(accionAdmin);*/
        //BOTON TURISTEAR:
        ActionListener accionUser = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
            cls_Turista ventanaTurista = new cls_Turista();
            ventanaTurista.setVisible(true);
            dispose();//cierra la ventana anterior
          }
        };
        boton2.addActionListener(accionUser);
      }

      /* 
      private void obtenerIglesiasDesdeBaseDeDatos() {
        Connection conexion = cls_db.conectar();
        if (conexion != null) {
          DefaultListModel<String> listModel = new DefaultListModel<>(); // Declare and initialize the listModel variable
          try {
            String consulta = "SELECT NOMBRE FROM SITIO_TURISTICO WHERE CATEGORÍA = 'Iglesia'";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            listModel.clear();
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
      }*/
    }
