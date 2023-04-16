package EntradaSalida;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Graficar {
    private static Color fondo = new Color(27, 21, 41);
    private static Color fondoCuadrosTexto = new Color(36, 28, 51);

    
    public static CategoryDataset creaDatosCategory(ArrayList valores, ArrayList nombres) {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for (int i = 0; i < valores.size(); i++) {
            datos.setValue(Integer.parseInt(valores.get(i).toString()), "Estado Civil", nombres.get(i).toString());
        }
        return datos;
    }

    public static PieDataset creaDatosPie(ArrayList valores, ArrayList nombres) {
        DefaultPieDataset datos = new DefaultPieDataset();
        for (int i = 0; i < valores.size(); i++) {
            datos.setValue(nombres.get(i).toString(), Integer.parseInt(valores.get(i).toString()));
        }
        return datos;
    }

    public static ChartPanel panelGrafica(JFreeChart grafica) {
        ChartPanel panel = new ChartPanel(grafica);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(300, 300));
        return panel;
    }

    public static void grabaFilePDF(String titulo, JFreeChart grafica) {
        // Se crea un archivo para guardar el grafico llamado grafica_barras
        try {
            PDFDocument pdfDoc = new PDFDocument();
            pdfDoc.setTitle(titulo);
            pdfDoc.setAuthor("Huwur");

            Page page = pdfDoc.createPage(new Rectangle(612, 468));
            PDFGraphics2D g2 = page.getGraphics2D();

            grafica.draw(g2, new Rectangle(0, 0, 612, 468));

            pdfDoc.writeToFile(new File("C:\\Users\\hecto\\OneDrive\\Documentos\\Graficas\\" + titulo + "(" + System.currentTimeMillis() + ")" + ".pdf"));
            JOptionPane.showMessageDialog(null, "PDF Exportando exitosamente");
        } catch (Exception e) {
            System.err.println("Error creando grafico." + e.getMessage());
        }
    }

    public static JFreeChart graficaBarra(String titulo, CategoryDataset datos) {
        JFreeChart grafico;
        grafico = ChartFactory.createBarChart(titulo, "Estado civil",
                "Cantidad de personas",
                datos,
        PlotOrientation.VERTICAL, true, true, false);
        return grafico;
    }

    public static JFreeChart graficaPastel(String titulo, PieDataset datos) {
        JFreeChart grafico;
        
        grafico = ChartFactory.createPieChart(
                titulo, // nombre del grafico
                datos, // datos del grafico
                true, // leyenda de barras individuales por columna
                true, // herramientas
                false// url del grafico
        );
        return (grafico);
    }  
}
