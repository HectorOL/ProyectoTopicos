package Gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import Controlador.Controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiResultados extends JDialog implements ActionListener {
    private JPanel contenedorGrafica;
    private JPanel contenedorControles;
    private int aciertos;
    private int total;
    private JTextArea lblAciertos;
    private JButton reiniciar;
    private JButton salir;
    private Controlador padre;

    public GuiResultados(int aciertos, int total, Controlador padre) {
        super();
        this.aciertos = aciertos;
        this.total = total;
        this.padre = padre;
        setTitle("Resultados");
        setSize(500, 500);
        inicializaComponentes();
        setModal(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void inicializaComponentes() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        contenedorGrafica = new JPanel();
        contenedorControles = new JPanel();
        contenedorGrafica.setPreferredSize(new Dimension(500, (int)(500 * 0.8)));
        contenedorControles.setPreferredSize(new Dimension(500, (int)(500 * 0.2)));
        contenedorGrafica.setBackground(Color.WHITE);
        contenedorControles.setBackground(Color.WHITE);

        lblAciertos = new JTextArea("Has obtenido " + aciertos + " de " + total + " aciertos.\nTu porcentaje es de " + (aciertos * 100) / total + " % de acietos.");
        lblAciertos.setEditable(false);
        lblAciertos.setFont(new Font("Roboto", Font.BOLD, 20));
        contenedorGrafica.add(creaGrafica());
        contenedorGrafica.add(lblAciertos);


        reiniciar = new JButton("Intentar de nuevo");
        reiniciar.addActionListener(this);
        salir = new JButton("Salir");
        salir.addActionListener(this);

        contenedorControles.setLayout(new BoxLayout(contenedorControles, BoxLayout.X_AXIS));
        contenedorControles.add(Box.createVerticalGlue());
        contenedorControles.add(reiniciar);
        contenedorControles.add(Box.createHorizontalStrut(50));
        contenedorControles.add(salir);
        contenedorControles.add(Box.createVerticalGlue());

        add(contenedorGrafica);
        add(contenedorControles);
    }

    private ChartPanel creaGrafica() {
        float porcentajeAciertos =  (aciertos * 100) / total;
        float porcentajeErrores = (100-porcentajeAciertos);

        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Errores", porcentajeErrores);
        datos.setValue("Aciertos", porcentajeAciertos);

        JFreeChart grafica = ChartFactory.createPieChart("Resultados", datos, true, true, false);
        grafica.getPlot().setBackgroundPaint(Color.WHITE);
        grafica.getPlot().setOutlinePaint(Color.WHITE);

        ChartPanel panel = new ChartPanel(grafica);
        panel.setPreferredSize(new Dimension(450, (int)(500 * 0.6)));
        return panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reiniciar) {
            dispose();
            padre.reiniciar();
        } else if (e.getSource() == salir) {
            System.exit(0);
        }
        
    }
}
