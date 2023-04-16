package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import EntradaSalida.Calcular;
import EntradaSalida.Graficar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.jfree.chart.JFreeChart;

public class GuiEstadisticas extends JFrame implements ActionListener {
    private JPanel contenedor;
    private JPanel statsEdad;
    private JPanel statsSexo;
    private JPanel statsEstadoCivil;
    private JPanel statsDatos;
    private JTextArea tdatos;

    private Calcular tool = new Calcular(Gui.getLista().getLista());
    private JFreeChart graficaEdad;
    private JFreeChart graficaSexo;
    private JFreeChart graficaEstadoCivil;
    private JButton btnPdfSexo;
    private JButton btnPdfEstadoCivil;
    private JButton btnPdfEdad;

    public GuiEstadisticas() {
        super("Fiesta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(1000, 600);
        inicializaComponentes();
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void inicializaComponentes() {
        //usando un GridBagLayout vamos a colocar los 4 layouts de forma que queden 3 en la parte superior y uno en la parte inferior ocupnado todo el ancho del Jframe
        GridBagLayout layout = new GridBagLayout();
        contenedor = new JPanel();
        contenedor.setLayout(layout);
        GridBagConstraints restricciones = new GridBagConstraints();

        //creamos los 4 layouts
        statsEdad = new JPanel();
        statsSexo = new JPanel();
        statsEstadoCivil = new JPanel();
        statsDatos = new JPanel();

        crearGraficas();
        //colocamos los 4 l5ayouts en el contenedor
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 2;
        restricciones.fill = GridBagConstraints.BOTH;
        restricciones.weightx = 1;
        restricciones.weighty = 15;
        layout.setConstraints(statsEdad, restricciones);

        btnPdfEdad = new JButton("Generar PDF");
        btnPdfEdad.addActionListener(this);
        statsEdad.add(btnPdfEdad);
        contenedor.add(statsEdad);

        restricciones.gridx = 1;
        restricciones.gridy = 0;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 2;
        restricciones.fill = GridBagConstraints.BOTH;
        restricciones.weightx = 1;
        restricciones.weighty = 15;
        layout.setConstraints(statsSexo, restricciones);

        btnPdfSexo = new JButton("Generar PDF");
        btnPdfSexo.addActionListener(this);
        statsSexo.add(btnPdfSexo);
        contenedor.add(statsSexo);

        restricciones.gridx = 2;
        restricciones.gridy = 0;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 2;
        restricciones.fill = GridBagConstraints.BOTH;
        restricciones.weightx = 1;
        restricciones.weighty = 15;
        layout.setConstraints(statsEstadoCivil, restricciones);

        btnPdfEstadoCivil = new JButton("Generar PDF");
        btnPdfEstadoCivil.addActionListener(this);;
        statsEstadoCivil.add(btnPdfEstadoCivil);
        contenedor.add(statsEstadoCivil);

        restricciones.gridx = 0;
        restricciones.gridy = 2;
        restricciones.gridwidth = 3;
        restricciones.gridheight = 1;
        restricciones.fill = GridBagConstraints.BOTH;
        restricciones.weightx = 1;
        restricciones.weighty = 1;
        layout.setConstraints(statsDatos, restricciones);
        contenedor.add(statsDatos);

        tdatos = new JTextArea();
        tdatos.setPreferredSize(new Dimension(500, 175));
        tdatos.setText(tool.estadisticas());
        tdatos.setEditable(false);
        statsDatos.add(tdatos);



        //agregamos el contenedor al JFrame
        add(contenedor);
    }

    public void crearGraficas() {
        ArrayList<Integer> valores = new ArrayList();
        ArrayList<String> nombres = new ArrayList();

        //Creamos la grafica para mostrar la edad de los asistentes
        valores.add(tool.mayorEdad());
        valores.add(tool.menorEdad());
        nombres.add("Mayores de edad");
        nombres.add("Menores de edad");
        graficaEdad = Graficar.graficaPastel("Edad de los asistentes", Graficar.creaDatosPie(valores, nombres));
        statsEdad.add(Graficar.panelGrafica(graficaEdad));

        //Creamos la grafica para mostrar el sexo de los asistentes
        valores.removeAll(valores);
        nombres.removeAll(nombres);

        valores.add(tool.totalHombres());
        valores.add(tool.totalMujeres());
        nombres.add("Hombres");
        nombres.add("Mujeres");
        graficaSexo = Graficar.graficaPastel("Sexo de los asistentes", Graficar.creaDatosPie(valores, nombres));
        statsSexo.add(Graficar.panelGrafica(graficaSexo));

        //Creamos la grafica para mostrar el estado civil de los asistentes
        valores.removeAll(valores);
        nombres.removeAll(nombres);

        valores.add(tool.totalCasados());
        valores.add(tool.totalSolteros());
        valores.add(tool.totalDivorciados());
        valores.add(tool.totalViudos());
        
        nombres.add("Casados");
        nombres.add("Solteros");
        nombres.add("Divorciados");
        nombres.add("Viudos");
        graficaEstadoCivil = Graficar.graficaBarra("Estado civil de los asistentes", Graficar.creaDatosCategory(valores, nombres));
        statsEstadoCivil.add(Graficar.panelGrafica(graficaEstadoCivil));
    }

    public void actualizarComponentes(){
        statsEdad.removeAll();
        statsSexo.removeAll();
        statsEstadoCivil.removeAll();
        crearGraficas();
        statsEdad.add(btnPdfEdad);
        statsSexo.add(btnPdfSexo);
        statsEstadoCivil.add(btnPdfEstadoCivil);

        tdatos.setText(tool.estadisticas());
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource() == btnPdfEdad) {
            Graficar.grabaFilePDF("Grafica de Edad de los asistentes",graficaEdad);
        }
        if(e.getSource() == btnPdfSexo) {
            Graficar.grabaFilePDF("Grafica de Sexo de los asistentes",graficaSexo);
        }
        if(e.getSource() == btnPdfEstadoCivil) {
            Graficar.grabaFilePDF("Grafica de Estado civil de los asistentes",graficaEstadoCivil);
        }

        //Operaciones basicas con objeto
        //Guis
    }
}
