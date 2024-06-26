/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import java.io.*;
import javax.swing.JOptionPane;
import metromendeley.*;


/**
 *
 * @author VivianaPetit
 */
public class Inicio extends javax.swing.JFrame {
    
    public static Lista<Resumen> resumenes;
    public static Lista<String> rutas;
    public static HashTable tabla;
    public static Lista<String> palabrasClavesBD; 
    public static Lista<String> titulos; 
    public static Lista<String> autores;
    Fuentes tipoFuente;

    /**
     * Creates new form Ventana2
     */
    public Inicio() {
        initComponents();
        resumenes = new Lista<>();
        rutas = new Lista<>();
        tabla = new HashTable();
        palabrasClavesBD = new Lista<>();
        titulos = new Lista<>();
        autores = new Lista<>();
        tipoFuente = new Fuentes();
        jLabel1.setFont(tipoFuente.fuente(tipoFuente.nombre, 0, 22));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void crearResumenes(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            Resumen resumen;
            String titulo = "";
            Lista<String> autoresDelResumen = new Lista<>(); // Lista local de autores LS
            String cuerpo = "";
            String palabrasClave = "";
            String linea;

            boolean aux = false;
            int contador = 0;
            while((linea = br.readLine()) != null){
                if (contador == 0){
                    titulo += linea;
                    titulos.insertFinal(linea);
                    contador ++;
                }
                else if (linea.contains("Autores")) {
                    aux = true;
                }
                else if (linea.contains("Resumen")){
                    cuerpo += br.readLine();
                    aux = false;
                }
                else if (aux) {
                    autoresDelResumen.insertFinal(linea);
                }
                else if (linea.startsWith("Palabras claves: ")){
                    String palabra = linea.replaceAll("Palabras claves: ", "").replaceAll("\\.", "");
                    palabrasClave += palabra;
                }
                else if (linea.startsWith("Palabras Claves: ")){
                    String palabra = linea.replaceAll("Palabras Claves: ", "").replaceAll("\\.", "");
                    palabrasClave += palabra;
                }
            }
            String[] palabrasDivididas = palabrasClave.split(",");
            Lista<String> palabrasClaves = new Lista();
            for (String palabra : palabrasDivididas) {
                palabrasClavesBD.insertFinal(palabra.trim().toLowerCase());
                palabrasClaves.insertFinal(palabra);
            }
            
            // Verificación y agregado de autores únicos a la lista global
            Nodo<String> nodoAutor = autoresDelResumen.getFirst();
            while (nodoAutor != null) {
                String autor = nodoAutor.getValor();
                boolean encontrado = false;

                // Recorremos la lista global para verificar existencia manualmente
                Nodo<String> nodoGlobal = autores.getFirst();
                while (nodoGlobal != null) {
                    if (nodoGlobal.getValor().equals(autor)) {
                        encontrado = true;
                        break; // Si encontramos el autor, no necesitamos seguir buscando
                    }
                    nodoGlobal = nodoGlobal.getSiguiente();
                }

                // Si no se encontró el autor en la lista global, lo agregamos
                if (!encontrado) {
                    autores.insertFinal(autor); // Agregar el autor a la lista global
                }

                nodoAutor = nodoAutor.getSiguiente();
            }
            
            resumen = new Resumen(titulo, autores, cuerpo, palabrasClaves);

            resumenes.insertFinal(resumen);
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void obtenerRutaArchivos(){
        Lista<String> nombreArchivos = new Lista<>();

        nombreArchivos.insertFinal("\\src\\Resumenes\\resumen1.txt");
        nombreArchivos.insertFinal("\\src\\Resumenes\\resumen2.txt");
        nombreArchivos.insertFinal("\\src\\Resumenes\\resumen3.txt");
        nombreArchivos.insertFinal("\\src\\Resumenes\\resumen4.txt");

        Nodo<String> nombre = nombreArchivos.getFirst();
        String rutaBaseProyecto = System.getProperty("user.dir");
        
        for (int i = 0; i < nombreArchivos.getLenght(); i++) {
            String rutaRelativa = nombre.getValor();
            String rutaAbsoluta = rutaBaseProyecto + rutaRelativa;
            rutas.insertFinal(rutaAbsoluta);
            nombre = nombre.getSiguiente();
        }
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        panelRound2 = new Interfaz.PanelRound();
        panelRound1 = new Interfaz.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(213, 228, 207));
        panelRound2.setRoundBottomLeft(10);
        panelRound2.setRoundBottomRight(10);
        panelRound2.setRoundTopLeft(10);
        panelRound2.setRoundTopRight(10);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(2, 64, 83));
        panelRound1.setRoundBottomLeft(10);
        panelRound1.setRoundBottomRight(10);
        panelRound1.setRoundTopLeft(10);
        panelRound1.setRoundTopRight(10);
        panelRound1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelRound1MousePressed(evt);
            }
        });
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(213, 228, 207));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Iniciar");
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 60, 30));

        panelRound2.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 100, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/background1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        panelRound2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 460, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título.png"))); // NOI18N
        panelRound2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 220, 150, 160));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título.png"))); // NOI18N
        panelRound2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, -80, 150, 160));

        getContentPane().add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelRound1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound1MousePressed
        obtenerRutaArchivos();
        Nodo<String> aux = rutas.getFirst();
        for (int i = 0; i < rutas.getLenght(); i++){
            crearResumenes(aux.getValor());
            aux = aux.getSiguiente();
        }
        Nodo<Resumen> nodoResumen = resumenes.getFirst();
        for (int i = 0; i<resumenes.getLenght(); i++) {
            tabla.insertar(nodoResumen.getValor());
            nodoResumen = nodoResumen.getSiguiente();
        }
        
        //verificar si los autores se cargaron correctamente LS
        Nodo<String> nodoAutor = autores.getFirst();
        while (nodoAutor != null) {
            System.out.println(nodoAutor.getValor());
            nodoAutor = nodoAutor.getSiguiente();
        }
        
        Menu v2 = new Menu();
        this.setVisible(false);
        v2.setVisible(true);
    }//GEN-LAST:event_panelRound1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private Interfaz.PanelRound panelRound1;
    private Interfaz.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
