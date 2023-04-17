package Gui;

import EntradaSalida.ListaAlumnos;
import TDA.Alumno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui12 extends JFrame implements ActionListener {

    private JLabel numCtrl, nombre, semestre, edad, total;
    private JTextField campoNumero, campoNombre, campoSemeste, campoEdad, campoTotal;
    private JButton añadir, eliminar, eliminarTodo;
    private ListaAlumnos lista;
    private Container contenedor;
    private JList listaNombres;
    private DefaultListModel modelo;
    private JScrollPane scrollLista;

    public Gui12() {
        lista = new ListaAlumnos();
        inicio();
        setTitle("Practica 12");
        setSize(362,375);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicio () {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        numCtrl = new JLabel("No. Control: ");
        numCtrl.setBounds(10,10,150,30);
        campoNumero = new JTextField();
        campoNumero.setBounds(90,10,250,30);

        nombre = new JLabel("Nombre: ");
        nombre.setBounds(10,50,100,30);
        campoNombre = new JTextField();
        campoNombre.setBounds(90,50,250,30);

        semestre = new JLabel("Semestre: ");
        semestre.setBounds(10,90,100,30);
        campoSemeste = new JTextField();
        campoSemeste.setBounds(90,90,250,30);

        edad = new JLabel("Edad: ");
        edad.setBounds(10,130,100,30);
        campoEdad = new JTextField();
        campoEdad.setBounds(90,130,250,30);

        total = new JLabel("No. Registro: ");
        total.setBounds(10,270,100,30);

        añadir = new JButton("Alta");
        añadir.setBounds(10,300,55,25);
        añadir.addActionListener(this);

        eliminar = new JButton("Eliminar");
        eliminar.setBounds(111,300,80,25);
        eliminar.addActionListener(this);

        eliminarTodo = new JButton("Limpia lista");
        eliminarTodo.setBounds(238,300,100,25);
        eliminarTodo.addActionListener(this);

        //Lista grafica de Alumnos
        listaNombres = new JList<>();
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo = new DefaultListModel();

        //Barra de desplazamiento
        scrollLista = new JScrollPane();
        scrollLista.setBounds(10,170,330,100);

        //Asociar el scroll con la lista
        scrollLista.setViewportView(listaNombres);

        //Añadimos
        contenedor.add(numCtrl);
        contenedor.add(campoNumero);
        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(semestre);
        contenedor.add(campoSemeste);
        contenedor.add(edad);
        contenedor.add(campoEdad);
        contenedor.add(total);
        contenedor.add(añadir);
        contenedor.add(eliminar);
        contenedor.add(eliminarTodo);
        contenedor.add(scrollLista);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == añadir) {
            añadirAlumno();
        }
        if (e.getSource() == eliminar) {
            eliminarAlumno(listaNombres.getSelectedIndex());
        }
        if (e.getSource() == eliminarTodo) {
            eliminarTodo();
        }
    }

    private void añadirAlumno () {
        Alumno p = new Alumno(campoNumero.getText(),campoNombre.getText(),Byte.parseByte(campoSemeste.getText()),Byte.parseByte(campoEdad.getText()));
        lista.añadir(p);
        String cad = campoNombre.getText() + "   " + campoNumero.getText() + "   " + campoSemeste.getText() + "  " + campoEdad.getText();
        modelo.addElement(cad);
        listaNombres.setModel(modelo);
        int x = modelo.getSize();
        total.setText("No. Registro: " + x);

        campoNumero.setText("");
        campoNombre.setText("");
        campoSemeste.setText("");
        campoEdad.setText("");
        //campoTotal.setText("");
    }

    private void eliminarAlumno (int indice) {
        if (indice >= 0) {
            modelo.removeElementAt(indice);
            lista.eliminar(indice);
            int x = modelo.getSize();
            total.setText("No. Registro: " + x);
        } else {
            JOptionPane.showMessageDialog(null,"Debe seleccionar un elemento","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarTodo () {
        lista.eliminarTodos();
        modelo.clear();
        int x = modelo.getSize();
        total.setText("No. Registro: " + x);

    }
}
