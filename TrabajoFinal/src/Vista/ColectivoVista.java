
package Vista;

import AccesoDatos.ColectivoData;
import Entidades.Colectivo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ColectivoVista extends javax.swing.JInternalFrame {

   private final ColectivoData colectivoData = new ColectivoData();
    private Colectivo seleccionado = null;
    private DefaultTableModel modeloTabla;

    public ColectivoVista() {
        initComponents();
        armarTabla();
        conectarEventos();
        cargarTabla();
        nuevo();
    }

    private void conectarEventos() {
        btnBuscar.addActionListener(e -> buscar());
        btnVerTodos.addActionListener(e -> {
            txtBuscar.setText("");
            cargarTabla();
        });
        btnNuevo.addActionListener(e -> nuevo());
        btnGuardar.addActionListener(e -> guardar());
        btnActualizar.addActionListener(e -> actualizar());
        btnBaja.addActionListener(e -> cambiarEstado(false));
        btnAlta.addActionListener(e -> cambiarEstado(true));
        btnEliminar.addActionListener(e -> eliminar());
        btnSalir.addActionListener(e -> dispose());
    }

    private void armarTabla() {
        modeloTabla = new DefaultTableModel(
                new Object[]{"ID", "Matricula", "Marca", "Modelo", "Capacidad", "Chofer", "Estado"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.setModel(modeloTabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setFillsViewportHeight(true);
        tabla.getTableHeader().setReorderingAllowed(false);
        int[] anchos = {40, 100, 100, 90, 80, 200, 70};
        for (int i = 0; i < anchos.length; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabla.getSelectedRow() >= 0) {
                int id = (Integer) modeloTabla.getValueAt(tabla.getSelectedRow(), 0);
                seleccionar(colectivoData.buscarColectivoPorID(id));
            }
        });
    }

    // ------------------------------------------------------------ acciones

    private void nuevo() {
        seleccionado = null;
        txtId.setText("");
        txtMatricula.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtCapacidad.setText("");
        txtChofer.setText("");
        chkActivo.setSelected(true);
        if (tabla != null) {
            tabla.clearSelection();
        }
        actualizarBotones();
        txtMatricula.requestFocusInWindow();
    }

    private void seleccionar(Colectivo c) {
        seleccionado = c;
        if (c == null) {
            return;
        }
        txtId.setText(String.valueOf(c.getIdColectivo()));
        txtMatricula.setText(c.getMatricula());
        txtMarca.setText(c.getMarca());
        txtModelo.setText(c.getModelo());
        txtCapacidad.setText(String.valueOf(c.getCapacidad()));
        txtChofer.setText(c.getChofer());
        chkActivo.setSelected(c.isEstado());
        actualizarBotones();
    }

    private void guardar() {
        Colectivo colectivo = leerFormulario();
        if (colectivo == null) {
            return;
        }
        if (colectivoData.buscarColectivoPorMatricula(colectivo.getMatricula()) != null) {
            mostrarError("Ya existe un colectivo con la matricula " + colectivo.getMatricula() + ".");
            return;
        }

        colectivoData.guardarColectivo(colectivo);

        if (colectivoData.buscarColectivoPorMatricula(colectivo.getMatricula()) == null) {
            mostrarError("No se pudo guardar el colectivo.");
            return;
        }
        cargarTabla();
        nuevo();
        mostrarInfo("Colectivo guardado con exito.");
    }

    private void actualizar() {
        if (seleccionado == null) {
            mostrarError("Seleccione un colectivo de la tabla.");
            return;
        }
        Colectivo editado = leerFormulario();
        if (editado == null) {
            return;
        }
        editado.setIdColectivo(seleccionado.getIdColectivo());

        Colectivo otro = colectivoData.buscarColectivoPorMatricula(editado.getMatricula());
        if (otro != null && otro.getIdColectivo() != editado.getIdColectivo()) {
            mostrarError("Otro colectivo ya usa la matricula " + editado.getMatricula() + ".");
            return;
        }

        colectivoData.modificarColectivo(editado);
        cargarTabla();
        nuevo();
        mostrarInfo("Colectivo actualizado con exito.");
    }

    private void cambiarEstado(boolean activar) {
        if (seleccionado == null) {
            mostrarError("Seleccione un colectivo de la tabla.");
            return;
        }
        if (activar) {
            colectivoData.darDeAltaColectivo(seleccionado);
        } else {
            colectivoData.darDeBajaColectivo(seleccionado);
        }
        cargarTabla();
        nuevo();
    }

    private void eliminar() {
        if (seleccionado == null) {
            mostrarError("Seleccione un colectivo de la tabla.");
            return;
        }
        int resp = JOptionPane.showConfirmDialog(this,
                "Eliminar definitivamente el colectivo " + seleccionado.getMatricula() + "?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resp != JOptionPane.YES_OPTION) {
            return;
        }

        int id = seleccionado.getIdColectivo();
        colectivoData.eliminarColectivo(seleccionado);

        if (colectivoData.buscarColectivoPorID(id) != null) {
            mostrarError("No se pudo eliminar. Puede tener rutas asociadas: use Baja logica.");
            return;
        }
        cargarTabla();
        nuevo();
    }

    private void buscar() {
        String matricula = txtBuscar.getText().trim();
        if (matricula.isEmpty()) {
            cargarTabla();
            return;
        }
        Colectivo c = colectivoData.buscarColectivoPorMatricula(matricula);
        if (c == null) {
            mostrarError("No se encontro ningun colectivo con la matricula " + matricula + ".");
            return;
        }
        modeloTabla.setRowCount(0);
        agregarFila(c);
        tabla.setRowSelectionInterval(0, 0);
    }

    // ------------------------------------------------------------ apoyo

    /** Lee y valida el formulario. Devuelve null (y avisa) si hay un dato invalido. */
    private Colectivo leerFormulario() {
        String matricula = txtMatricula.getText().trim();
        String marca = txtMarca.getText().trim();
        String modelo = txtModelo.getText().trim();
        String chofer = txtChofer.getText().trim();

        if (matricula.isEmpty() || marca.isEmpty() || modelo.isEmpty()
                || chofer.isEmpty() || txtCapacidad.getText().trim().isEmpty()) {
            mostrarError("Complete todos los campos.");
            return null;
        }

        int capacidad;
        try {
            capacidad = Integer.parseInt(txtCapacidad.getText().trim());
        } catch (NumberFormatException ex) {
            mostrarError("La capacidad debe ser un numero entero.");
            return null;
        }
        if (capacidad <= 0) {
            mostrarError("La capacidad debe ser mayor a 0.");
            return null;
        }

        return new Colectivo(matricula, marca, modelo, capacidad, chofer, chkActivo.isSelected());
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        List<Colectivo> lista = colectivoData.listarColectivos();
        for (Colectivo c : lista) {
            agregarFila(c);
        }
    }

    private void agregarFila(Colectivo c) {
        modeloTabla.addRow(new Object[]{
            c.getIdColectivo(),
            c.getMatricula(),
            c.getMarca(),
            c.getModelo(),
            c.getCapacidad(),
            c.getChofer(),
            c.isEstado() ? "Activo" : "Baja"
        });
    }

    private void actualizarBotones() {
        boolean haySeleccion = seleccionado != null;
        btnGuardar.setEnabled(!haySeleccion);
        btnActualizar.setEnabled(haySeleccion);
        btnEliminar.setEnabled(haySeleccion);
        btnBaja.setEnabled(haySeleccion && seleccionado.isEstado());
        btnAlta.setEnabled(haySeleccion && !seleccionado.isEstado());
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Atencion", JOptionPane.WARNING_MESSAGE);
    }

    private void mostrarInfo(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Listo", JOptionPane.INFORMATION_MESSAGE);
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnVerTodos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chkActivo = new javax.swing.JCheckBox();
        txtId = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtCapacidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtChofer = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setTitle("Colectivos");

        jLabel1.setText("Buscar por Matricula");

        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnVerTodos.setText("Ver todos");
        btnVerTodos.addActionListener(this::btnVerTodosActionPerformed);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("ID:");

        jLabel4.setText("Marca:");

        jLabel5.setText("Capacidad:");

        chkActivo.setSelected(true);
        chkActivo.setText("Activo");
        chkActivo.addActionListener(this::chkActivoActionPerformed);

        txtId.setEditable(false);
        txtId.addActionListener(this::txtIdActionPerformed);

        txtMarca.addActionListener(this::txtMarcaActionPerformed);

        txtCapacidad.addActionListener(this::txtCapacidadActionPerformed);

        jLabel6.setText("Matricula:");

        jLabel7.setText("Modelo:");

        jLabel8.setText("Chofer:");

        txtMatricula.addActionListener(this::txtMatriculaActionPerformed);

        txtModelo.addActionListener(this::txtModeloActionPerformed);

        txtChofer.addActionListener(this::txtChoferActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtMarca)
                            .addComponent(txtCapacidad))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(txtModelo)
                            .addComponent(txtChofer)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(chkActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(chkActivo)
                .addContainerGap())
        );

        jLabel2.setText("Datos del colectivo");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Matricula", "Marca", "Modelo", "Capacidad", "Chofer", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnBaja.setText("Baja Logica");
        btnBaja.addActionListener(this::btnBajaActionPerformed);

        btnAlta.setText("Alta Logica");
        btnAlta.addActionListener(this::btnAltaActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnVerTodos))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(btnNuevo)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(btnBaja)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlta)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir)))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnVerTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnBaja)
                    .addComponent(btnAlta)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerTodosActionPerformed

    private void chkActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkActivoActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacidadActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChoferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChoferActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtChofer;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}
