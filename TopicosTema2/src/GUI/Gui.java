package GUI;
import javax.swing.*;
import EntradaSalida.Calcular;
import Main.Asistente;
import Main.ListaInvitados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import EntradaSalida.Tools;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Gui extends JFrame implements ActionListener{
    private JLabel lNombre;
    private JLabel lSexo;
    private JLabel lEdad;
    private JLabel lEstadoCivil;
    private JLabel lNoRegistro;

    private JTextField tNombre;
    private JTextField tEdad;

    private JRadioButton rCasado;
    private JRadioButton rSoltero;
    private JRadioButton rDivorciado;
    private JRadioButton rViudo;

    private JCheckBox sexoM;
    private JCheckBox sexoF;

    //Declaracion de un Objeto de tipo JList y DefaultListModel sin tipo de dato definido
    private JList jlista;
    private DefaultListModel modelo;
    private JScrollPane scrollLista;

    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnLimpiar;
    private JButton btnEstadisticas;

    private ButtonGroup btnsSexo;
    private ButtonGroup btnsEstadoCivil;
    private GuiEstadisticas estadisticas  = new GuiEstadisticas();

    private char sexoEleccion;
    private String estadoEleccion;

    private static ListaInvitados lista = new ListaInvitados();
    private JPanel panel;
    
    public static ListaInvitados getLista(){
        return lista;
    }

    public Gui(){
        super("Fiesta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        inicializaComponentes();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void inicializaComponentes() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(300, 400));

        lNombre = new JLabel("Nombre:");
        lNombre.setBounds(15, 10, 70, 40);
        panel.add(lNombre);

        lEdad = new JLabel("Edad:");
        lEdad.setBounds(15, 40, 70, 40);
        panel.add(lEdad);

        lSexo = new JLabel("Sexo:");
        lSexo.setBounds(15, 70, 70, 40);
        panel.add(lSexo);

        lEstadoCivil = new JLabel("Estado Civil:");
        lEstadoCivil.setBounds(15, 117, 70, 40);
        panel.add(lEstadoCivil);

        lNoRegistro = new JLabel("No. de registros: 0");
        lNoRegistro.setBounds(20, 260, 200, 40);
        panel.add(lNoRegistro);

        tNombre = new JTextField();
        tNombre.setBounds(70, 20, 200, 25);
        panel.add(tNombre);

        tEdad = new JTextField();
        tEdad.setBounds(70, 50, 200, 25);
        panel.add(tEdad);

        btnsSexo = new ButtonGroup();
        btnsEstadoCivil = new ButtonGroup();

        sexoM = new JCheckBox("Masculino");
        sexoM.setBounds(65, 80, 100, 25);
        sexoM.addActionListener(this);    
        btnsSexo.add(sexoM);
        panel.add(sexoM);

        sexoF = new JCheckBox("Femenino");
        sexoF.setBounds(190, 80, 100, 25);
        sexoF.addActionListener(this);
        btnsSexo.add(sexoF);
        panel.add(sexoF);
        btnsSexo.add(sexoF);

        rSoltero = new JRadioButton("Soltero");
        rSoltero.setBounds(100, 110, 70, 25);
        rSoltero.addActionListener(this);
        btnsEstadoCivil.add(rSoltero);
        panel.add(rSoltero);

        rCasado = new JRadioButton("Casado");
        rCasado.setBounds(190, 110, 70, 25);
        rCasado.addActionListener(this);
        btnsEstadoCivil.add(rCasado);
        panel.add(rCasado);

        rDivorciado = new JRadioButton("Divorciado");
        rDivorciado.setBounds(100, 140, 90, 25);
        rDivorciado.addActionListener(this);
        btnsEstadoCivil.add(rDivorciado);
        panel.add(rDivorciado);

        rViudo = new JRadioButton("Viudo");
        rViudo.setBounds(190, 140, 70, 25);
        rViudo.addActionListener(this);
        btnsEstadoCivil.add(rViudo);
        panel.add(rViudo);

        jlista = new JList<>();
        jlista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        modelo = new DefaultListModel<>();

        scrollLista = new JScrollPane();
        scrollLista.setBorder(null);
        scrollLista.setBounds(15, 170, 270, 100);
        scrollLista.setViewportView(jlista);
        panel.add(scrollLista);

        btnAgregar = new JButton("Añadir");
        btnAgregar.setBounds(15, 300, 130, 40);
        btnAgregar.addActionListener(this);
        panel.add(btnAgregar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(155, 300,130, 40);
        btnEliminar.addActionListener(this);
        panel.add(btnEliminar);
        
        btnLimpiar = new JButton("Eliminar Todos");
        btnLimpiar.setBounds(15, 350, 130, 40);
        btnLimpiar.addActionListener(this);
        panel.add(btnLimpiar);

        btnEstadisticas = new JButton("Estadisticas");
        btnEstadisticas.setBounds(155, 350, 130, 40);
        btnEstadisticas.addActionListener(this);
        panel.add(btnEstadisticas);
        
        add(panel);
    }


    public void agregar() {
        if(validadFormulario()){
            Asistente persona = new Asistente(tNombre.getText(), sexoEleccion, Integer.parseInt(tEdad.getText()), estadoEleccion);
            lista.añadir(persona);

            String cadena = persona.getDatos();
            modelo.addElement(cadena);
            jlista.setModel(modelo);
            lNoRegistro.setText("No. de resgitros: " + modelo.getSize());
            estadisticas.actualizarComponentes();
            if(estadisticas.isVisible())
                estadisticas.setVisible(true);
            limpiarFormulario();
            
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, llene de manera correcta el formulario");
        }
    }

    public void eliminar(int index){
        if(index >= 0){            
            lista.eliminar(index);
            modelo.removeElementAt(index);
            lNoRegistro.setText("No. Registros: " + modelo.getSize());
            estadisticas.actualizarComponentes();
            if(estadisticas.isVisible())
                estadisticas.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarTodo(){
        lista.eliminarTodos();;
        modelo.clear();
        lNoRegistro.setText("No. Registros: " + modelo.getSize());
        estadisticas.actualizarComponentes();
        if(estadisticas.isVisible())
            estadisticas.setVisible(true);
    }

    private boolean validadFormulario(){
        boolean val = Tools.validaNombre(tNombre.getText()) 
                    && Tools.validaEdad(tEdad.getText())
                    && Tools.validarSeleccion(btnsSexo, "sexo")
                    && Tools.validarSeleccion(btnsEstadoCivil, "Estado Civil");
        return val;
    }

    public void limpiarFormulario(){
        tNombre.setText("");
        tEdad.setText("");
        btnsSexo.clearSelection();
        btnsEstadoCivil.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == sexoM){
            sexoEleccion = 'M';
            rCasado.setText("Casado");
            rSoltero.setText("Soltero");
            rDivorciado.setText("Divorciado");
            rViudo.setText("Viudo");
        }
        if(e.getSource() == sexoF){
            sexoEleccion = 'F';
            rCasado.setText("Casada");
            rSoltero.setText("Soltera");
            rDivorciado.setText("Divorciada");
            rViudo.setText("Viuda");
        }
        if(e.getSource() == rSoltero){
            estadoEleccion = "soltero";
        }
        if(e.getSource() == rCasado){
            estadoEleccion = "casado";
        }
        if(e.getSource() == rDivorciado){
            estadoEleccion = "divorciado";
        }
        if(e.getSource() == rViudo){
            estadoEleccion = "viudo";
        }
        if(e.getSource() == btnAgregar){
            agregar();
        }
        if(e.getSource() == btnEliminar){
            eliminar(jlista.getSelectedIndex());
        }
        if(e.getSource() == btnLimpiar){
            eliminarTodo();
        }
        if(e.getSource() == btnEstadisticas){
            estadisticas.actualizarComponentes();
            estadisticas.setVisible(true);
        }
    }
}
