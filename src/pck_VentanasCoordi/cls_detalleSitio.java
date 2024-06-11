package pck_VentanasCoordi;
import javax.swing.*;
import java.awt.*;
public class cls_detalleSitio extends JFrame {
    private JLabel lblNombre;
    private JLabel lblDescripcion;
    private JLabel lblHorario;
    private JLabel lblCosto;

    public cls_detalleSitio(String nombre, String descripcion, String horario, String costo) {
        super("Detalle del Sitio Turístico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents(nombre, descripcion, horario, costo);
    }

    private void initComponents(String nombre, String descripcion, String horario, String costo) {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        lblNombre = new JLabel("Nombre:");
        lblDescripcion = new JLabel("Descripción:");
        lblHorario = new JLabel("Horario:");
        lblCosto = new JLabel("Costo:");

        JLabel lblNombreValor = new JLabel(nombre);
        JLabel lblDescripcionValor = new JLabel(descripcion);
        JLabel lblHorarioValor = new JLabel(horario);
        JLabel lblCostoValor = new JLabel(costo);

        panel.add(lblNombre);
        panel.add(lblNombreValor);
        panel.add(lblDescripcion);
        panel.add(lblDescripcionValor);
        panel.add(lblHorario);
        panel.add(lblHorarioValor);
        panel.add(lblCosto);
        panel.add(lblCostoValor);

        add(panel);
    }
}