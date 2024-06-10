package pck_Turista;
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
import javax.swing.SwingConstants;
import pck_VentanasTurista.cls_Iglesias;
import pck_VentanasTurista.cls_Museos;
import pck_VentanasTurista.cls_SitioInteres;
import pck_configuracion.cls_Configuracion;

public class cls_Turista extends JFrame {
    public JPanel panelTurista;
    public cls_Turista(){
            this.setSize(730, 500);//se stablece el tamaño de la ventana
            setDefaultCloseOperation(EXIT_ON_CLOSE);//metodo para poder cerrar proceso de ventana
            setTitle("TuriPop/Usuario/Busqueda");//titulo de la ventana
            setResizable(false); 
            setLocationRelativeTo(null);//se establece la posicion incial de la ventana en el centro
            inciarComponentes();
        }
    private void inciarComponentes(){
     colocarPanelesUser(); 
     ColocarEtiqueta();
     colocarBotones();
    }
    private void colocarPanelesUser() {
        panelTurista = new JPanel();//creacion panel 
      panelTurista.setBackground(Color.WHITE);
      this.getContentPane().add(panelTurista);//se enlaza con la ventana
      //creacion de etiqueta
      panelTurista.setLayout(null);
    }

    private void ColocarEtiqueta() {
        //etiqueta Museo
        JLabel etq_iglesia = new JLabel();//instancia de etiqueta
      etq_iglesia.setText("Iglesia");//se establece el text de la etiqueta
      etq_iglesia.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etq_iglesia.setBounds(410,30,100,20);//donde se va a ubicar
      etq_iglesia.setForeground(Color.BLACK);//color de texto
      etq_iglesia.setBackground(Color.WHITE);//para el fondo de la etiqueta
      etq_iglesia.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etq_iglesia.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
      panelTurista.add(etq_iglesia);
        //etiqueta monumento
        JLabel etq_Monumento = new JLabel();//instancia de etiqueta
      etq_Monumento.setText("Museo");//se establece el text de la etiqueta
      etq_Monumento.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etq_Monumento.setBounds(210,30,100,20);//donde se va a ubicar
      etq_Monumento.setForeground(Color.BLACK);//color de texto
      etq_Monumento.setBackground(Color.WHITE);//para el fondo de la etiqueta
      etq_Monumento.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etq_Monumento.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
      panelTurista.add(etq_Monumento);
        //etiqueta iglesia
        JLabel etq_SitioTuristico = new JLabel();//instancia de etiqueta
      etq_SitioTuristico.setText("Sitio Interes");//se establece el text de la etiqueta
      etq_SitioTuristico.setHorizontalAlignment(SwingConstants.CENTER);//alinear el texto(horizontal) en el margen de la etiqueta en el centro
      etq_SitioTuristico.setBounds(210,230,100,20);//donde se va a ubicar
      etq_SitioTuristico.setForeground(Color.BLACK);//color de texto
      etq_SitioTuristico.setBackground(Color.WHITE);//para el fondo de la etiqueta
      etq_SitioTuristico.setOpaque(true);//se requiere de este metodo para poder modificar los parametros de la etiqueta que vienen por default
      etq_SitioTuristico.setFont(new Font("arial",1,15));//estabecemos la fuente del txt
      panelTurista.add(etq_SitioTuristico);
    }
    private void colocarBotones(){
    //Boton Museo
    JButton btn_Museo = new JButton();
        btn_Museo.setBounds(200,50,120,120);
        btn_Museo.setEnabled(true);//habilita la interaccion con el boton
        btn_Museo.setForeground(Color.BLUE);//color letra
        btn_Museo.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui = new ImageIcon("museoArte.png");
        //btn_Museo.setBorder(BorderFactory.createRoundedBorder(10));
        btn_Museo.setIcon(new ImageIcon(clicAqui.getImage().getScaledInstance(btn_Museo.getWidth(), btn_Museo.getHeight(), Image.SCALE_SMOOTH)));
        btn_Museo.setBackground(Color.WHITE);//color de fondo del boton
        panelTurista.add(btn_Museo);
    //accion Boton
    btn_Museo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cls_Museos vMuseos =new cls_Museos();
                        vMuseos.setVisible(true);
                        dispose();
                // Aquí podrías realizar otras acciones, como mostrar la ventana anterior
            }
        });
    //Boton Iglesia
    JButton btn_Iglesia = new JButton();
        btn_Iglesia.setBounds(400,50,120,120);
        btn_Iglesia.setEnabled(true);//habilita la interaccion con el boton
        btn_Iglesia.setForeground(Color.BLUE);//color letra
        btn_Iglesia.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui2 = new ImageIcon("iglesia.png");
        btn_Iglesia.setIcon(new ImageIcon(clicAqui2.getImage().getScaledInstance(btn_Iglesia.getWidth(), btn_Iglesia.getHeight(), Image.SCALE_SMOOTH)));
        btn_Iglesia.setBackground(Color.WHITE);//color de fondo del boton
        panelTurista.add(btn_Iglesia);
        //accion boton iglesia
        btn_Iglesia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cls_Iglesias vIglesias =new cls_Iglesias();
                        vIglesias.setVisible(true);
                        dispose();
                // Aquí podrías realizar otras acciones, como mostrar la ventana anterior
            }
        });
    //Boton SitioInteres
    JButton btn_SitioInteres = new JButton();
        btn_SitioInteres.setBounds(200,250,120,120);
        btn_SitioInteres.setEnabled(true);//habilita la interaccion con el boton
        btn_SitioInteres.setForeground(Color.BLUE);//color letra
        btn_SitioInteres.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon clicAqui3 = new ImageIcon("sitioInteres.png");
        btn_SitioInteres.setIcon(new ImageIcon(clicAqui3.getImage().getScaledInstance(btn_SitioInteres.getWidth(), btn_SitioInteres.getHeight(), Image.SCALE_SMOOTH)));
        btn_SitioInteres.setBackground(Color.WHITE);//color de fondo del boton
        panelTurista.add(btn_SitioInteres);
    //accion sitioInteres
    btn_SitioInteres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cls_SitioInteres vInteres =new cls_SitioInteres();
                        vInteres.setVisible(true);
                        dispose();
                // Aquí podrías realizar otras acciones, como mostrar la ventana anterior
            }
        });
    //boton configuraciones admins/coordinadores
    JButton botonConfiguracion = new JButton();
        //boton1.setText("Agregar");//agregar txt al boton
        botonConfiguracion.setBounds(645,390,60,60);
        botonConfiguracion.setEnabled(true);//habilita la interaccion con el boton
        botonConfiguracion.setForeground(Color.BLUE);//color letra
        botonConfiguracion.setFont(new Font("arial",1, 15));//establecemos la funte del texto
        ImageIcon btnConfig = new ImageIcon("configuracion.png");
        botonConfiguracion.setIcon(new ImageIcon(btnConfig.getImage().getScaledInstance(botonConfiguracion.getWidth(), botonConfiguracion.getHeight(), Image.SCALE_SMOOTH)));
        botonConfiguracion.setBackground(Color.WHITE);//color de fondo del boton
        panelTurista.add(botonConfiguracion);
        //accion boton config
        botonConfiguracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual
                dispose();
                cls_Configuracion v2 = new cls_Configuracion(); 
                v2.setVisible(true);
                // Aquí podrías realizar otras acciones, como mostrar la ventana anterior
            }
        });
    }
}
