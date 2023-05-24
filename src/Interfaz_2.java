import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.lang.*;

public class Interfaz_2 extends JFrame implements ActionListener {
    // Icono
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Recursos/IconBiblioteca.png")));
    // panel
    JPanel panel;
    // Botones
    JButton bCrearCuentas;
    JButton bPrestarLibro;
    JButton bRetornarLibro;
    JButton bInfo;
    JButton bVolver;
    // JMenuBar
    JMenuBar menuBar;
    JMenu estadoLibro;
    JMenu personasMora;
    JMenuItem mostrar;
    JMenuItem terror;
    JMenuItem novela;
    JMenuItem inge;
    // JLabel
    JLabel lCrearCuenta;

    // Variable para la cantidad de días prestado

    // Crear un modelo de tabla y agregar los datos
    DefaultTableModel model = new DefaultTableModel(Libros.getData(), Libros.getNomColumnas()) {
        // Se deshabilita la opción de modificar las filas y las columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    // Crear un componente JTable con el modelo de tabla
    JTable table = new JTable(model);

    // creo una lista con los datos prorcionados en la clase Libros para poder modificarlos
    Object[][] datos = Libros.getData();

    public Interfaz_2() {

        // Configuración Panel
        panel = new JPanel();
        panel.setBounds(40, 120, 600, 350);
        add(panel);

        // Configuración Jmenubar
        menuBar = new JMenuBar();

        estadoLibro = new JMenu("Estado Libros");
        personasMora = new JMenu("Personas en Mora");

        mostrar = new JMenuItem("Mostrar");
        mostrar.addActionListener(Action2);

        terror = new JMenuItem("Terror");
        terror.addActionListener(Action2);
        novela = new JMenuItem("Novela Clásica");
        novela.addActionListener(Action2);
        inge = new JMenuItem("Ingeniería");
        inge.addActionListener(Action2);

        personasMora.add(mostrar);

        estadoLibro.add(terror);
        estadoLibro.add(novela);
        estadoLibro.add(inge);

        menuBar.add(estadoLibro);
        menuBar.add(personasMora);

        this.setJMenuBar(menuBar);

        // Configuración Label
        lCrearCuenta = new JLabel("Crear Cuenta:");
        lCrearCuenta.setBounds(40, 480, 100, 20);
        lCrearCuenta.setVisible(false);
        add(lCrearCuenta);

        // Configuración Botones
        bCrearCuentas = new JButton("Crear");
        bCrearCuentas.setBounds(40, 500, 100, 20);
        bCrearCuentas.setBackground(Color.green);
        bCrearCuentas.setVisible(false);
        bCrearCuentas.addActionListener(this);
        add(bCrearCuentas);

        bPrestarLibro = new JButton("Prestar");
        bPrestarLibro.setBounds(100, 60, 100, 40);
        bPrestarLibro.setBackground(Color.RED);
        bPrestarLibro.addActionListener(this);
        add(bPrestarLibro);

        bRetornarLibro = new JButton("Retornar");
        bRetornarLibro.setBounds(240, 60, 100, 40);
        bRetornarLibro.setBackground(Color.RED);
        bRetornarLibro.addActionListener(this);
        add(bRetornarLibro);

        bInfo = new JButton("Información");
        bInfo.setBounds(380, 60, 100, 40);
        bInfo.setBackground(Color.RED);
        add(bInfo);

        bVolver = new JButton("Volver");
        bVolver.setBounds(10, 10, 75, 30);
        bVolver.setBackground(Color.green);
        bVolver.addActionListener(this);
        add(bVolver);

        // Configuración Ventana
        setLayout(null);
        setSize(700, 600);
        setTitle("Biblioteca");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(img.getImage());
        setVisible(true);


        // Se le dan las dimensiones
        table.setPreferredScrollableViewportSize(new Dimension(600, 300));
        // se añade al panel y además se le agrega el método JScroll para que se visualice de forma correcta
        panel.add(new JScrollPane(table));

    }

    public void Prestarlibro() {
        int indexRow = table.getSelectedRow();
        boolean data = (boolean) model.getValueAt(indexRow, 2);

        for (int i = 0; i <= table.getRowCount(); i++) {
            if (data && indexRow == i) {
                model.setValueAt(false, indexRow, 2);
                datos[i][2] = false;
                break;

            }
        }
        System.out.print(datos[0][2]);//******************
        model.fireTableDataChanged();
    }

    // ActionListener para los Jmenuitem
    ActionListener Action2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Se crea un jmenuitem al cual se le asigna el jmenuitem presionado
            JMenuItem jm = (JMenuItem) e.getSource();

            System.out.print(datos[0][2]); // *****************

            // Sí se presiona el jmenuitem mostrar del jmenu personasMora
            // mostrar un cuadro de texto con las personas en mora
            if (jm == mostrar) {
                // Print de prueba (Luego se cambiara)
                System.out.println("Presionado mostrar");
            }

            // Al presionar el jmenuitem terror este mostrará un cuadro de txt donde
            // apareceran los nombre y el estado de cada libro de terror
            if (jm == terror) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + datos[0][0] + "    Estado: " + datos[0][2] + "\n" +
                                "Nombre: " + datos[1][0] + "    Estado: " + datos[1][2] + "\n" +
                                "Nombre: " + datos[2][0] + "    Estado: " + datos[2][2] + "\n" +
                                "Nombre: " + datos[3][0] + "    Estado: " + datos[3][2] + "\n" +
                                "Nombre: " + datos[4][0] + "    Estado: " + datos[4][2] + "\n", "Estado Libros Terror", JOptionPane.PLAIN_MESSAGE);
            }

            // Al presionar el jmenuitem novela este mostrará un cuadro de txt donde
            // apareceran los nombre y el estado de cada libro de novels Classics
            if (jm == novela) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + datos[5][0] + "    Estado: " + datos[5][2] + "\n" +
                                "Nombre: " + datos[6][0] + "    Estado: " + datos[6][2] + "\n" +
                                "Nombre: " + datos[7][0] + "    Estado: " + datos[7][2] + "\n" +
                                "Nombre: " + datos[8][0] + "    Estado: " + datos[8][2] + "\n" +
                                "Nombre: " + datos[9][0] + "    Estado: " + datos[9][2] + "\n", "Estado Libros Novela", JOptionPane.INFORMATION_MESSAGE);
            }

            // Al presionar el jmenuitem inge este mostrará un cuadro de txt donde
            // apareceran los nombre y el estado de cada libro de engineering
            if (jm == inge) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + datos[10][0] + "    Estado: " + datos[10][2] + "\n" +
                                "Nombre: " + datos[11][0] + "    Estado: " + datos[11][2] + "\n" +
                                "Nombre: " + datos[12][0] + "    Estado: " + datos[12][2] + "\n" +
                                "Nombre: " + datos[13][0] + "    Estado: " + datos[13][2] + "\n" +
                                "Nombre: " + datos[14][0] + "    Estado: " + datos[14][2] + "\n", "Estado Libros Ingeniería", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {     // ActionListener para los botones
        JButton jb = (JButton) e.getSource();
        if (jb == bCrearCuentas) {
            setVisible(false);
            new Interfaz_3();
        }
        if (jb == bPrestarLibro) {
            Prestarlibro();
        }
        if (jb == bVolver) {
            setVisible(false);
            new Interfaz_1();
        }
        if (jb == bRetornarLibro) {
            int dias = Integer.parseInt(JOptionPane.showInputDialog(null, "Dias que fue prestado el libro", "Retornar Libro"));
            int diasAtraso = dias - 7;

            if (diasAtraso > 0) {
                int multa = diasAtraso * 1000; // Calcular la multa
                JOptionPane.showMessageDialog(null, "Se debe cobrar una multa de " + multa + " pesos.");
            } else {
                JOptionPane.showMessageDialog(null, "No se debe cobrar ninguna multa.");
            }
        }
    }
}

