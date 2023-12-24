import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Principal;
    private JTabbedPane tabbedPane1;
    private JTextField txtID;
    private JTextField txtNombre;
    private JTextField txtEDAD;
    private JTextField txtRendimineto;
    private JComboBox cboPosicion;
    private JButton btnRegistar;
    private JTextArea txtListar;
    private JTextField txtNuevoNombre;
    private JTextField txtNuevaEdad;
    private JTextField txtNuevoRendimiento;
    private JComboBox cboNuevaPosicion;
    private JButton btnActualizarJugador;
    private JButton btnListar;
    private JTextField txtNuevoID;
    private JList listListarJugadores;
    private JComboBox cboSuma;
    private JLabel sumaLabel;
    private JButton btnSumar;
    Lista lista=new Lista();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Ventana() {
        btnRegistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(txtID.getText());
                int edad=Integer.parseInt(txtEDAD.getText());
                String nombre=txtNombre.getText();
                float rendimiento=Integer.parseInt(txtRendimineto.getText());
                String posicion=cboPosicion.getSelectedItem().toString();
                Jugadores jugadorNuevo=new Jugadores(id,edad,nombre,rendimiento,posicion);
                lista.ingresar(jugadorNuevo);
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarYllenarJList();
            }
        });

        btnActualizarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(txtNuevoID.getText());
                int edad=Integer.parseInt(txtNuevaEdad.getText());
                String nombre=txtNuevoNombre.getText();
                float rendimiento=Float.parseFloat(txtNuevoRendimiento.getText());
                String posicion=cboNuevaPosicion.getSelectedItem().toString();
                Jugadores jugadorNuevo=new Jugadores(id,edad,nombre,rendimiento,posicion);
                if (lista.actualizar(jugadorNuevo)){
                    JOptionPane.showMessageDialog(null,"ACTUALIZACION EXITOSA");
                }else {
                    JOptionPane.showMessageDialog(null,"NO HAY NADIE CON ESA ID");
                }
            }
        });

        listListarJugadores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (listListarJugadores.getSelectedIndex()!=-1){
                    int indice=listListarJugadores.getSelectedIndex();
                    Jugadores j=lista.getEquipo().get(indice);
                    txtNuevoID.setText(""+j.getId());
                    txtNuevoNombre.setText(j.getNombre());
                    txtNuevaEdad.setText(""+j.getEdad());
                    txtNuevoRendimiento.setText(""+j.getRendimineto());
                    cboNuevaPosicion.setSelectedItem(j.getPosicion());
                }
            }
        });
        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String posicion=cboSuma.getSelectedItem().toString();
                sumaLabel.setText("La suma es: "+lista.suma(posicion));
            }
        });
    }
    public void llenarJList(){
        DefaultListModel dlm=new DefaultListModel<>();
        for(Jugadores j:lista.getEquipo()){
            dlm.addElement(j.toString());
            listListarJugadores.setModel(dlm);
        }

    }
    public void ordenarYllenarJList() {
        lista.ordenarPorRendimiento(); // Ordenar la lista por rendimiento
        llenarJList();
    }
}
