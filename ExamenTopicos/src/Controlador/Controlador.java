package Controlador;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import Gui.GuiResultados;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Controlador extends JPanel implements ActionListener{
    private JPanel contenedorPreguntas;
    private JPanel contenedorImagen;
    private JPanel contenedorPregunta;
    private JPanel contenedorRespuestas;
    private JPanel contenedorControles;
    private ImageIcon imagen;
    private Icon icon;
    private JLabel cImagen;
    private JTextArea cPregunta;
    private ButtonGroup gRespuestas;
    private JButton evaluar;
    private ArrayList<JRadioButton> cRespuestas;
    private String preguntas[] = {"¿A qué clase pertenecen los componentes de Menú y Texto?",
                                 "¿Cómo se llama el componente que se encuentra en casi todos los menús?",
                                 "¿Con qué componente se ingresan contraseñas?",
                                 "¿Los menús pueden tener iconos?",
                                 "¿En que componente se puede implementar HTML para dar estilos?",
                                 "¿Qué componente permite ingresar múltiples líneas de texto?",
                                 "¿Qué menú se abre al presionar click derecho?",
                                 "¿Qué componente permite la entrada de texto con un formato en específico?",
                                 "Un menú de RadioButton tiene que agruparlos ya que no se hace de forma automática:",
                                 "¿Qué componente de menú puede seleccionar y deseleccionar opciones?"
                                };
    private String respuestas[][] = {{"AWT", "Swing", "Graphics", "ActionListener"},
                                    {"JMenu", "menuItem", "barMenu", "radioMenu"},
                                    {"JTextArea", "JTextFieldHide", "JTextField", "JPasswordField"},
                                    {"Verdadero", "Falso"},
                                    {"JTextArea", "JTextFieldHide", "JEditorPane", "JTextField"},
                                    {"JEditorPane", "JTextField", "JTextPane", "JTextArea"},
                                    {"JMenu", "JPopupMenu", "menuItem", "JRadioMenu"},
                                    {"JEditorTextPane", "JTextArea", "JFormateTextField", "JMataJevers"},
                                    {"Verdadero", "Falso"},
                                    {"JCheckBox", "JRadioButton", "JMenuItem", "JMenu"}};

    private String respuestasCorrectas[] = {"Swing", "menuItem", "JPasswordField", "Verdadero", "JEditorPane", "JTextArea", "JPopupMenu", "JFormateTextField", "Falso", "JCheckBox"};
    private Font fuenteRes = new Font("Roboto", Font.ITALIC, 20);
    private int w, h;
    private int i = 0, j = 0;
    private int aciertos = 0;

    public Controlador(int w, int h) {
        super();
        this.w = w;
        this.h = h;
        setSize(w, h);
        inicializaComponentes();
    }

    public void reiniciar(){
        i = 0;
        j = 0;
        aciertos = 0;
        generarPregunta();
        evaluar.setText("Listo");
    }

    private void inicializaComponentes() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        contenedorPreguntas = new JPanel();
        contenedorControles = new JPanel();
        contenedorPreguntas.setPreferredSize(new Dimension(w, (int)(h * 0.8)));
        contenedorControles.setPreferredSize(new Dimension(w, (int)(h * 0.2)));
        contenedorPreguntas.setBackground(Color.WHITE);
        contenedorControles.setBackground(Color.WHITE);

        contenedorImagen = new JPanel();
        contenedorPregunta = new JPanel();
        contenedorRespuestas = new JPanel();
        contenedorImagen.setBackground(Color.WHITE);
        contenedorPregunta.setBackground(Color.WHITE);
        contenedorRespuestas.setBackground(Color.WHITE);

        
        contenedorPreguntas.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Se asignan la posicion de el contendor que tendra la imagen
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 4;
        gbc.weightx = 0;
        gbc.weighty = 0;
        contenedorPreguntas.add(contenedorImagen, gbc);

        //Se asignan la posicion de el contendor que tendra la pregunta
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        contenedorPreguntas.add(contenedorPregunta, gbc);

        //Se asignan la posicion de el contendor que tendra las respuestas
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 3;
        gbc.weightx = 0;
        gbc.weighty = 0;
        contenedorPreguntas.add(contenedorRespuestas, gbc);


        contenedorImagen.setLayout(new BoxLayout(contenedorImagen, BoxLayout.X_AXIS));
        contenedorImagen.add(Box.createVerticalGlue());
        cImagen = new JLabel();
        imagen = new ImageIcon("src\\Img\\p1.jpg");
        icon = new ImageIcon(imagen.getImage().getScaledInstance(300, 250, java.awt.Image.SCALE_AREA_AVERAGING));
        cImagen.setIcon(icon);
        contenedorImagen.add(cImagen);
        contenedorImagen.add(Box.createVerticalGlue());
        
        contenedorPregunta.add(Box.createHorizontalStrut(30));
        cPregunta = new JTextArea();
        cPregunta.setPreferredSize(new Dimension(450, 600));
        cPregunta.setBackground(null);
        cPregunta.setLineWrap(true);
        cPregunta.setWrapStyleWord(true);
        cPregunta.setEditable(false);
        cPregunta.setFont(new Font("Roboto", Font.BOLD, 30));
        cPregunta.setText(preguntas[i]);
        contenedorPregunta.add(cPregunta);

        gRespuestas = new ButtonGroup();
        cRespuestas = new ArrayList<JRadioButton>();

        contenedorRespuestas.setLayout(new BoxLayout(contenedorRespuestas, BoxLayout.Y_AXIS));
        contenedorRespuestas.add(Box.createVerticalGlue());
        contenedorRespuestas.add(Box.createHorizontalStrut(30));

        for (int j = 0; j < respuestas[i].length; j++) {    
            cRespuestas.add(new JRadioButton(respuestas[i][j]));
            cRespuestas.get(j).setFont(fuenteRes);
            cRespuestas.get(j).setBackground(Color.WHITE);
            cRespuestas.get(j).setActionCommand(respuestas[i][j]);
            gRespuestas.add(cRespuestas.get(j));
            contenedorRespuestas.add(cRespuestas.get(j));
            contenedorRespuestas.add(Box.createVerticalStrut(20));
        }

        contenedorRespuestas.add(Box.createVerticalGlue());

        evaluar = new JButton("Listo");
        evaluar.setPreferredSize(new Dimension(100, 50));
        evaluar.setFont(new Font("Roboto", Font.BOLD, 20));
        evaluar.addActionListener(this);
        
        contenedorControles.add(evaluar);

        add(contenedorPreguntas);
        add(contenedorControles);
    }

    public void generarPregunta(){
        contenedorRespuestas.removeAll();
        repaint();
        cRespuestas.clear();
        gRespuestas.clearSelection();
        cPregunta.setText(preguntas[i]);
        contenedorRespuestas.add(Box.createVerticalGlue());
        contenedorRespuestas.add(Box.createHorizontalStrut(30));
        for (j = 0; j < respuestas[i].length; j++) {
            cRespuestas.add(new JRadioButton(respuestas[i][j]));
            cRespuestas.get(j).setFont(fuenteRes);
            cRespuestas.get(j).setBackground(Color.WHITE);
            gRespuestas.add(cRespuestas.get(j));
            contenedorRespuestas.add(cRespuestas.get(j));
            contenedorRespuestas.add(Box.createVerticalStrut(20));
            cRespuestas.get(j).setActionCommand(respuestas[i][j]);
        }
        contenedorRespuestas.add(Box.createVerticalGlue());
        imagen = new ImageIcon("src\\Img\\p" + (i + 1) + ".jpg");
        icon = new ImageIcon(imagen.getImage().getScaledInstance(300, 250, java.awt.Image.SCALE_AREA_AVERAGING));
        cImagen.setIcon(icon);
        j = 0;

    }

    private void evaluarRespuesta(){
        if(gRespuestas.getSelection().getActionCommand().equals(respuestasCorrectas[i])){
            aciertos++;
            JOptionPane.showMessageDialog(null, "Respuesta correcta");
        }else{
            JOptionPane.showMessageDialog(null, "Respuesta incorrecta");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == evaluar) {
            if (i < preguntas.length - 1) {
                if(gRespuestas.getSelection() == null){
                    JOptionPane.showMessageDialog(null, "Selecciona una respuesta");
                } else {
                    evaluarRespuesta();
                    i++;
                    generarPregunta();
                    if (i == preguntas.length - 1) {
                        evaluar.setText("Terminar");
                        evaluar.setPreferredSize(new Dimension(150, 50));
                    }
                }
            } else {
                if(gRespuestas.getSelection() == null){
                    JOptionPane.showMessageDialog(null, "Selecciona una respuesta");
                } else {
                    evaluarRespuesta();
                    new GuiResultados(aciertos, preguntas.length, this);
                }
            }
        }
    }
}