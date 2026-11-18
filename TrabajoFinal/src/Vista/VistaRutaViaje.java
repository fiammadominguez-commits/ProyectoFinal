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

        setBackground(new java.awt.Color(204, 204, 255));
        setTitle("Gestion de Rutas");

        lblIdRuta.setBackground(new java.awt.Color(255, 204, 204));
        lblIdRuta.setText("ID Ruta:");
        lblIdRuta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblOrigen.setBackground(new java.awt.Color(255, 204, 204));
        lblOrigen.setText("Origen:");
        lblOrigen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDestino.setBackground(new java.awt.Color(255, 204, 204));
        lblDestino.setText("Destino:");
        lblDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblHoraSalida.setBackground(new java.awt.Color(255, 204, 204));
        lblHoraSalida.setText("Hora Salida:");
        lblHoraSalida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblHoraLlegada.setBackground(new java.awt.Color(255, 204, 204));
        lblHoraLlegada.setText("Hora Llegada:");
        lblHoraLlegada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblColectivo.setBackground(new java.awt.Color(255, 204, 204));
        lblColectivo.setText("Colectivo:");
        lblColectivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblPrecio.setBackground(new java.awt.Color(255, 204, 204));
        lblPrecio.setText("Precio:");
        lblPrecio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblEstado.setBackground(new java.awt.Color(255, 204, 204));
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
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Ruta", "Origen", "Destino", "Hora Salida", "Hora Llegada", "Colectivo", "Precio", "Estado"
            }
        ));
        jspRutas.setViewportView(jtRutas);

        lblHoraS.setText("HH: mm");

        jblHoraLl.setText("HH: mm");

        btnRutasDisponibles.setText("Rutas Disponibles");
        btnRutasDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutasDisponiblesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(27, 27, 27)
                                .addComponent(chkEstado))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jblHoraLl))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblHoraS))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtIDRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(79, 79, 79)
                                                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGap(58, 58, 58)
                                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(btnGuardar)
                                                            .addComponent(btnEliminar)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGap(27, 27, 27)
                                                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(btnRutasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jcbColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(360, 360, 360)))))
                        .addGap(0, 42, Short.MAX_VALUE)))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHoraS))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir)
                    .addComponent(jblHoraLl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRutasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkEstado))
                .addGap(18, 18, 18)
                .addComponent(jspRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRutasDisponibles;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chkEstado;
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
