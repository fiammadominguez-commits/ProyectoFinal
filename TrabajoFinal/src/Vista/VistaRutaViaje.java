/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import AccesoDatos.ColectivoData;
import javax.swing.table.DefaultTableModel;
import AccesoDatos.RutaViajeData;
import Entidades.Colectivo;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author LAURA TELLO
 */
public class VistaRutaViaje extends javax.swing.JInternalFrame {
private RutaViajeData rutaData;
private ColectivoData colectivoData;
private DefaultTableModel modelo;
  
    public VistaRutaViaje() {
        initComponents();
         rutaData = new RutaViajeData();
         colectivoData = new ColectivoData();
         
        modelo = (DefaultTableModel) jtRutas.getModel();
        
        cargarColectivos ();
        limpiarCampos();
        cargarTabla();
    }
    private void cargarTabla() {

    modelo.setRowCount(0);

    for (Entidades.RutaViaje ruta : rutaData.listarRutas()) {

        modelo.addRow(new Object[]{
            ruta.getIdRuta(),
            ruta.getOrigen(),
            ruta.getDestino(),
            ruta.getHoraSalida(),
            ruta.getHoraLlegada(),
            ruta.getColectivo().getMarca(),
            ruta.getPrecio(),
            ruta.isEstado() ? "Activa" : "Inactiva"
        });
    }
}
    private void cargarColectivos() {

    jcbColectivo.removeAllItems();

    for(Colectivo c : colectivoData.listarColectivos()){

        if(c.isEstado()){

            jcbColectivo.addItem(
                    c.getIdColectivo() + " - " +
                    c.getMarca() + " - " +
                    c.getMatricula());
        }
    }
}
    private void limpiarCampos() {

    jtIDRuta.setText("");
    jtOrigen.setText("");
    jtDestino.setText("");
    jtHoraSalida.setText("");
    jtHoraLlegada.setText("");
    jtPrecio.setText("");

    chkEstado.setSelected(false);

   if(jcbColectivo.getItemCount() > 0){
    jcbColectivo.setSelectedIndex(0);
}

    jtIDRuta.requestFocus();
}
    



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdRuta = new javax.swing.JLabel();
        lblOrigen = new javax.swing.JLabel();
        lblDestino = new javax.swing.JLabel();
        lblHoraSalida = new javax.swing.JLabel();
        lblHoraLlegada = new javax.swing.JLabel();
        lblColectivo = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        chkEstado = new javax.swing.JCheckBox();
        jcbColectivo = new javax.swing.JComboBox<>();
        jtIDRuta = new javax.swing.JTextField();
        jtOrigen = new javax.swing.JTextField();
        jtDestino = new javax.swing.JTextField();
        jtHoraSalida = new javax.swing.JTextField();
        jtHoraLlegada = new javax.swing.JTextField();
        jtPrecio = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jspRutas = new javax.swing.JScrollPane();
        jtRutas = new javax.swing.JTable();
        lblHoraS = new javax.swing.JLabel();
        jblHoraLl = new javax.swing.JLabel();
        btnRutasDisponibles = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setTitle("Gestion de Rutas");

        lblIdRuta.setBackground(new java.awt.Color(0, 0, 102));
        lblIdRuta.setText("ID Ruta:");
        lblIdRuta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblOrigen.setBackground(new java.awt.Color(0, 0, 102));
        lblOrigen.setText("Origen:");
        lblOrigen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDestino.setBackground(new java.awt.Color(0, 0, 102));
        lblDestino.setText("Destino:");
        lblDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblHoraSalida.setBackground(new java.awt.Color(0, 0, 102));
        lblHoraSalida.setText("Hora Salida:");
        lblHoraSalida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblHoraLlegada.setBackground(new java.awt.Color(0, 0, 102));
        lblHoraLlegada.setText("Hora Llegada:");
        lblHoraLlegada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblColectivo.setBackground(new java.awt.Color(0, 0, 102));
        lblColectivo.setText("Colectivo:");
        lblColectivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblPrecio.setBackground(new java.awt.Color(0, 0, 102));
        lblPrecio.setText("Precio:");
        lblPrecio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblEstado.setBackground(new java.awt.Color(0, 0, 102));
        lblEstado.setText("Estado");
        lblEstado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        chkEstado.setText("Ruta activa");
        chkEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEstadoActionPerformed(evt);
            }
        });

        jtIDRuta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtOrigen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtHoraSalida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtHoraLlegada.setToolTipText("");
        jtHoraLlegada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtPrecio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 3, true));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 3, true));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 3, true));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 3, true));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 3, true));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jtRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ruta", "Origen", "Destino", "Hora Salida", "Hora Llegada", "Colectivo", "Precio", "Estado"
            }
        ));
        jtRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtRutasMouseClicked(evt);
            }
        });
        jspRutas.setViewportView(jtRutas);

        lblHoraS.setText("HH: mm");

        jblHoraLl.setText("HH: mm");

        btnRutasDisponibles.setText("Rutas Disponibles");
        btnRutasDisponibles.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 3, true));
        btnRutasDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutasDisponiblesActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Flecha-Flash");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspRutas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblIdRuta, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                            .addComponent(lblOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblHoraLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                            .addComponent(lblColectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(lblHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jtOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                                    .addComponent(jtDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                                    .addComponent(jtIDRuta))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(73, 73, 73)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(btnRutasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(0, 105, Short.MAX_VALUE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblHoraS))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(jcbColectivo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jtHoraLlegada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jblHoraLl)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(58, 58, 58))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(chkEstado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtIDRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHoraS))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblHoraLl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRutasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkEstado)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jspRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEstadoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try{

        int id = Integer.parseInt(jtIDRuta.getText());

        Entidades.RutaViaje ruta =
                rutaData.buscarRutaPorID(id);

        if(ruta != null){

            jtOrigen.setText(ruta.getOrigen());
            jtDestino.setText(ruta.getDestino());

            jtHoraSalida.setText(
                    ruta.getHoraSalida().toString());

            jtHoraLlegada.setText(
                    ruta.getHoraLlegada().toString());

            jtPrecio.setText(
                    String.valueOf(ruta.getPrecio()));

            chkEstado.setSelected(
                    ruta.isEstado());
            int idColectivo = ruta.getColectivo().getIdColectivo();

for (int i = 0; i < jcbColectivo.getItemCount(); i++) {

    String item = jcbColectivo.getItemAt(i);

    if(item.startsWith(idColectivo + " -")){

        jcbColectivo.setSelectedIndex(i);

        break;
    }
}

        }else{

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Ruta no encontrada");
        }

    }catch(NumberFormatException ex){

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Ingrese un ID válido");
    
}
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {

    if(jtOrigen.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this,
                "Debe ingresar el origen");
        return;
    }

    if(jtDestino.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this,
                "Debe ingresar el destino");
        return;
    }

    if(jtOrigen.getText().equalsIgnoreCase(jtDestino.getText())){
        JOptionPane.showMessageDialog(this,
                "Origen y destino no pueden ser iguales");
        return;
    }

    if(jtPrecio.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this,
                "Debe ingresar el precio");
        return;
    }
    
    try{
    Double.parseDouble(jtPrecio.getText());
}catch(NumberFormatException ex){
    JOptionPane.showMessageDialog(this,
            "El precio debe ser un número válido");
    return;
}
    
    if(Double.parseDouble(jtPrecio.getText()) <= 0){
    JOptionPane.showMessageDialog(this,
            "El precio debe ser mayor a cero");
    return;
}
    if(jtHoraSalida.getText().trim().isEmpty()
        || jtHoraLlegada.getText().trim().isEmpty()){

    JOptionPane.showMessageDialog(this,
            "Debe ingresar las horas");
    return;
}
    java.time.LocalTime salida =
        java.time.LocalTime.parse(
                jtHoraSalida.getText());

java.time.LocalTime llegada =
        java.time.LocalTime.parse(
                jtHoraLlegada.getText());

if(salida.equals(llegada)){

    JOptionPane.showMessageDialog(this,
            "La hora de salida y llegada no pueden ser iguales");

    return;
}

if(llegada.isBefore(salida)){

    JOptionPane.showMessageDialog(this,
            "La hora de llegada debe ser posterior a la hora de salida");

    return;
}

        Entidades.RutaViaje ruta = new Entidades.RutaViaje();

        ruta.setOrigen(jtOrigen.getText());
        ruta.setDestino(jtDestino.getText());

        ruta.setHoraSalida(
                java.time.LocalTime.parse(
                        jtHoraSalida.getText()));

        ruta.setHoraLlegada(
                java.time.LocalTime.parse(
                        jtHoraLlegada.getText()));

        String seleccionado = jcbColectivo.getSelectedItem().toString();

        int idColectivo = Integer.parseInt(
                seleccionado.split("-")[0].trim());

        Colectivo colectivo =
                colectivoData.buscarColectivoPorID(idColectivo);

        if(rutaData.colectivoOcupado(
        idColectivo,
        salida,
        llegada)){

    JOptionPane.showMessageDialog(
            this,
            "El colectivo ya tiene un viaje asignado en ese horario");

    return;
}
        ruta.setColectivo(colectivo);

        ruta.setPrecio(
                Double.parseDouble(jtPrecio.getText()));

        ruta.setEstado(chkEstado.isSelected());

        rutaData.guardarRuta(ruta);
            cargarTabla();
            
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Ruta guardada correctamente");

        limpiarCampos();

    } catch (Exception ex) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
          try {

    if(jtOrigen.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this,
                "Debe ingresar el origen");
        return;
    }

    if(jtDestino.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this,
                "Debe ingresar el destino");
        return;
    }
    
    if(jtOrigen.getText().equalsIgnoreCase(jtDestino.getText())){
    JOptionPane.showMessageDialog(this,
            "Origen y destino no pueden ser iguales");
    return;
}
    if(jtPrecio.getText().trim().isEmpty()){
    JOptionPane.showMessageDialog(this,
            "Debe ingresar el precio");
    return;
}
    
    try{
    Double.parseDouble(jtPrecio.getText());
}catch(NumberFormatException ex){
    JOptionPane.showMessageDialog(this,
            "El precio debe ser un número válido");
    return;
} 
    
    if(Double.parseDouble(jtPrecio.getText()) <= 0){
    JOptionPane.showMessageDialog(this,
            "El precio debe ser mayor a cero");
    return;
}
    
    if(jtHoraSalida.getText().trim().isEmpty()
        || jtHoraLlegada.getText().trim().isEmpty()){

    JOptionPane.showMessageDialog(this,
            "Debe ingresar las horas");
    return;
}
    try{
    LocalTime.parse(jtHoraSalida.getText());
    LocalTime.parse(jtHoraLlegada.getText());
}catch(Exception ex){
    JOptionPane.showMessageDialog(this,
            "El formato de hora debe ser HH:mm");
    return;
}
    
    java.time.LocalTime salida =
        java.time.LocalTime.parse(
                jtHoraSalida.getText());

java.time.LocalTime llegada =
        java.time.LocalTime.parse(
                jtHoraLlegada.getText());

if(salida.equals(llegada)){

    JOptionPane.showMessageDialog(this,
            "La hora de salida y llegada no pueden ser iguales");

    return;
}

if(llegada.isBefore(salida)){

    JOptionPane.showMessageDialog(this,
            "La hora de llegada debe ser posterior a la hora de salida");

    return;
}

        Entidades.RutaViaje ruta = new Entidades.RutaViaje();

        ruta.setIdRuta(
                Integer.parseInt(jtIDRuta.getText()));

        ruta.setOrigen(jtOrigen.getText());

        ruta.setDestino(jtDestino.getText());

        
        ruta.setHoraSalida(
                java.time.LocalTime.parse(
                        jtHoraSalida.getText()));
        
        ruta.setHoraLlegada(
                java.time.LocalTime.parse(
                        jtHoraLlegada.getText()));

        String seleccionado =
                jcbColectivo.getSelectedItem().toString();

        int idColectivo =
                Integer.parseInt(
                        seleccionado.split("-")[0].trim());

        Colectivo colectivo =
                colectivoData.buscarColectivoPorID(
                        idColectivo);

        if(rutaData.colectivoOcupado(
        idColectivo,
        salida,
        llegada)){

    JOptionPane.showMessageDialog(
            this,
            "El colectivo ya tiene un viaje asignado en ese horario");

    return;
}
        ruta.setColectivo(colectivo);

        ruta.setPrecio(
                Double.parseDouble(
                        jtPrecio.getText()));

        ruta.setEstado(
                chkEstado.isSelected());

        rutaData.modificarRuta(ruta);
            cargarTabla();

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Ruta modificada correctamente");

    } catch (Exception ex) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
            try {

        int id = Integer.parseInt(jtIDRuta.getText());

        Entidades.RutaViaje ruta =
                rutaData.buscarRutaPorID(id);

        if (ruta != null) {

            rutaData.darDeBajaRuta(ruta);
                 cargarTabla();

            JOptionPane.showMessageDialog(
                    this,
                    "Ruta dada de baja correctamente");

            limpiarCampos();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Ruta no encontrada");
        }

    } catch (NumberFormatException ex) {

        JOptionPane.showMessageDialog(
                this,
                "Ingrese un ID válido");
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRutasDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutasDisponiblesActionPerformed
        VistaRutasDisponibles vista =
            new VistaRutasDisponibles();

             getDesktopPane().add(vista);

                 vista.setVisible(true);
    }//GEN-LAST:event_btnRutasDisponiblesActionPerformed

    private void jtRutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtRutasMouseClicked
        int fila = jtRutas.getSelectedRow();

    if (fila != -1) {

        jtIDRuta.setText(
                jtRutas.getValueAt(fila, 0).toString());

        jtOrigen.setText(
                jtRutas.getValueAt(fila, 1).toString());

        jtDestino.setText(
                jtRutas.getValueAt(fila, 2).toString());

        jtHoraSalida.setText(
                jtRutas.getValueAt(fila, 3).toString());

        jtHoraLlegada.setText(
                jtRutas.getValueAt(fila, 4).toString());

        jtPrecio.setText(
                jtRutas.getValueAt(fila, 6).toString());

        chkEstado.setSelected(
                jtRutas.getValueAt(fila, 7)
                        .toString()
                        .equals("Activa"));

        int idRuta = Integer.parseInt(
                jtIDRuta.getText());

        Entidades.RutaViaje ruta =
                rutaData.buscarRutaPorID(idRuta);

        int idColectivo =
                ruta.getColectivo().getIdColectivo();

        for (int i = 0;
             i < jcbColectivo.getItemCount();
             i++) {

            String item =
                    jcbColectivo.getItemAt(i);

            if (item.startsWith(
                    idColectivo + " -")) {

                jcbColectivo.setSelectedIndex(i);

                break;
            }
        }
    }
    }//GEN-LAST:event_jtRutasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRutasDisponibles;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jblHoraLl;
    private javax.swing.JComboBox<String> jcbColectivo;
    private javax.swing.JScrollPane jspRutas;
    private javax.swing.JTextField jtDestino;
    private javax.swing.JTextField jtHoraLlegada;
    private javax.swing.JTextField jtHoraSalida;
    private javax.swing.JTextField jtIDRuta;
    private javax.swing.JTextField jtOrigen;
    private javax.swing.JTextField jtPrecio;
    private javax.swing.JTable jtRutas;
    private javax.swing.JLabel lblColectivo;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblHoraLlegada;
    private javax.swing.JLabel lblHoraS;
    private javax.swing.JLabel lblHoraSalida;
    private javax.swing.JLabel lblIdRuta;
    private javax.swing.JLabel lblOrigen;
    private javax.swing.JLabel lblPrecio;
    // End of variables declaration//GEN-END:variables
}
