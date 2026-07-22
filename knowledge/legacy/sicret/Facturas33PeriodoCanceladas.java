/*      */ package sicret;
/*      */ import java.awt.Toolkit;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JEditorPane;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import utilerias.Utilerias;
/*      */ 
/*      */ public class Facturas33PeriodoCanceladas extends JDialog {
/*   24 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   25 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   26 */   Consultas2 con = new Consultas2();
/*      */   Date fecha1;
/*      */   Date fecha2;
/*      */   String MONEDA;
/*      */   String TIPO;
/*   31 */   Utilerias utilerias = new Utilerias();
/*      */   String[] LISTAFACTURAS;
/*   33 */   double FLETESCR = 0.0D;
/*   34 */   double FLETESSR = 0.0D;
/*   35 */   double FLETESO = 0.0D;
/*   36 */   double FLETESSUB = 0.0D;
/*   37 */   double INGRESOSACTIVOFIJO = 0.0D;
/*   38 */   String CONSULTARLISTARPRODUCTOS = "";
/*      */   Map<String, String> CAMPOSGENERALES;
/*   40 */   int multiplo = 28; JComboBox MES; JComboBox AÑO; JTable TablitaSinAfectacion; private JEditorPane jEditorPane1;
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel2;
/*   43 */   String etiquetaFecha = ""; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3;
/*      */   private JScrollPane jScrollPane4;
/*      */   
/*      */   public Facturas33PeriodoCanceladas(Map<String, String> CAMPOSGENERALES, Consultas2 con, Date fecha1, Date fecha2, String MONEDA, String TIPO, JComboBox MES, JComboBox AÑO) {
/*   47 */     initComponents();
/*   48 */     System.out.println("*** CANCELADAS **** " + String.valueOf(this.MES));
/*   49 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   50 */     this.con = con;
/*   51 */     this.fecha1 = fecha1;
/*   52 */     this.fecha2 = fecha2;
/*   53 */     this.MONEDA = MONEDA;
/*   54 */     this.TIPO = TIPO;
/*   55 */     this.MES = MES;
/*   56 */     this.AÑO = AÑO;
/*      */     
/*   58 */     this.utilerias.vaciarTabla(this.jTable1);
/*   59 */     this.utilerias.vaciarTabla(this.jTable2);
/*   60 */     this.utilerias.vaciarTabla(this.jTable3);
/*   61 */     this.utilerias.vaciarTabla(this.jTable4);
/*   62 */     this.utilerias.vaciarTabla(this.jTable5);
/*   63 */     this.utilerias.vaciarTabla(this.jTable6);
/*   64 */     consultarFacturasGral();
/*      */   }
/*      */   private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JTable jTable1; private JTable jTable2; private JTable jTable3;
/*      */   private JTable jTable4;
/*      */   private JTable jTable5;
/*      */   private JTable jTable6;
/*      */   
/*      */   private void initComponents() {
/*   72 */     this.jScrollPane1 = new JScrollPane();
/*   73 */     this.jTable1 = new JTable();
/*   74 */     this.jScrollPane2 = new JScrollPane();
/*   75 */     this.jTable2 = new JTable();
/*   76 */     this.jScrollPane3 = new JScrollPane();
/*   77 */     this.jTable3 = new JTable();
/*   78 */     this.jScrollPane4 = new JScrollPane();
/*   79 */     this.jEditorPane1 = new JEditorPane();
/*   80 */     this.jLabel1 = new JLabel();
/*   81 */     this.jScrollPane5 = new JScrollPane();
/*   82 */     this.jTable4 = new JTable();
/*   83 */     this.jScrollPane6 = new JScrollPane();
/*   84 */     this.jTable5 = new JTable();
/*   85 */     this.jScrollPane7 = new JScrollPane();
/*   86 */     this.jTable6 = new JTable();
/*   87 */     this.jLabel2 = new JLabel();
/*      */     
/*   89 */     setDefaultCloseOperation(2);
/*      */     
/*   91 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  102 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  104 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  115 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/*  117 */     this.jTable3.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  128 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/*  130 */     this.jScrollPane4.setViewportView(this.jEditorPane1);
/*      */     
/*  132 */     this.jLabel1.setText("Total de datos:");
/*      */     
/*  134 */     this.jTable4.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  145 */     this.jScrollPane5.setViewportView(this.jTable4);
/*      */     
/*  147 */     this.jTable5.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  158 */     this.jScrollPane6.setViewportView(this.jTable5);
/*      */     
/*  160 */     this.jTable6.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  171 */     this.jScrollPane7.setViewportView(this.jTable6);
/*      */     
/*  173 */     this.jLabel2.setText("Total de datos:");
/*      */     
/*  175 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  176 */     getContentPane().setLayout(layout);
/*  177 */     layout.setHorizontalGroup(layout
/*  178 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  179 */         .addComponent(this.jScrollPane1)
/*  180 */         .addComponent(this.jScrollPane5, -1, 1167, 32767)
/*  181 */         .addComponent(this.jScrollPane6, -1, 1167, 32767)
/*  182 */         .addGroup(layout.createSequentialGroup()
/*  183 */           .addContainerGap()
/*  184 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  185 */             .addGroup(layout.createSequentialGroup()
/*  186 */               .addComponent(this.jLabel1, -2, 397, -2)
/*  187 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  188 */               .addComponent(this.jLabel2, -2, 397, -2))
/*  189 */             .addComponent(this.jScrollPane4, -2, 0, 32767))
/*  190 */           .addContainerGap())
/*  191 */         .addComponent(this.jScrollPane3)
/*  192 */         .addComponent(this.jScrollPane7, -1, 1167, 32767)
/*  193 */         .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING));
/*      */     
/*  195 */     layout.setVerticalGroup(layout
/*  196 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  197 */         .addGroup(layout.createSequentialGroup()
/*  198 */           .addContainerGap()
/*  199 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  200 */             .addComponent(this.jLabel1)
/*  201 */             .addComponent(this.jLabel2))
/*  202 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  203 */           .addComponent(this.jScrollPane1, -2, 100, -2)
/*  204 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  205 */           .addComponent(this.jScrollPane2, -2, 126, -2)
/*  206 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  207 */           .addComponent(this.jScrollPane3, -2, 153, -2)
/*  208 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  209 */           .addComponent(this.jScrollPane5, -2, 100, -2)
/*  210 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  211 */           .addComponent(this.jScrollPane6, -2, 88, -2)
/*  212 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  213 */           .addComponent(this.jScrollPane7, -1, 136, 32767)
/*  214 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  215 */           .addComponent(this.jScrollPane4, -2, 81, -2)
/*  216 */           .addContainerGap()));
/*      */ 
/*      */     
/*  219 */     pack();
/*      */   }
/*      */   
/*      */   public void consultarFacturasGral() {
/*  223 */     String fechaCompleta1 = "";
/*  224 */     String fechaCompleta2 = "";
/*  225 */     String consultaFecha = "";
/*  226 */     if (this.MES.getSelectedIndex() != 0) {
/*  227 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*      */       
/*  229 */       int aa = Integer.parseInt(this.AÑO.getSelectedItem().toString());
/*  230 */       consultaFecha = " and  date_format( fechaCancelacion, '%m-%Y') = '" + mes[this.MES.getSelectedIndex()] + "-" + aa + "' ";
/*  231 */       this.etiquetaFecha = this.MES.getSelectedItem().toString();
/*      */     } else {
/*  233 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  234 */       String cadenaFecha = "";
/*  235 */       cadenaFecha = formato.format(this.fecha1);
/*  236 */       String AÑO = cadenaFecha.substring(0, 4);
/*  237 */       String MES = cadenaFecha.substring(4, 6);
/*  238 */       String DIA = cadenaFecha.substring(6, 8);
/*  239 */       fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*  240 */       this.etiquetaFecha = DIA + "/" + DIA + "/" + MES;
/*      */       
/*  242 */       cadenaFecha = formato.format(this.fecha2);
/*      */ 
/*      */ 
/*      */       
/*  246 */       String aa = cadenaFecha.substring(0, 4);
/*  247 */       String mm = cadenaFecha.substring(4, 6);
/*  248 */       String dd = cadenaFecha.substring(6, 8);
/*  249 */       this.etiquetaFecha = this.etiquetaFecha + " AL " + this.etiquetaFecha + "/" + dd + "/" + mm;
/*  250 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/*  251 */       consultaFecha = " and fechaCancelacion between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     } 
/*      */     
/*  254 */     this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo" }, "numFactura,tipo,folio,folioFiscal,fecha,cliente,suPedido,equipo,subtotal,descMonto,iva,retencion,total,totalDebe,estatus,usuario, cartaporte, version, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura ", "facturas33, polizascanceladas", "WHERE estatus like '%Cancelada%' and  facturas33.folio = polizascanceladas.folioInterno and tipo = '" + this.TIPO + "' and  moneda = '" + this.MONEDA + "'" + consultaFecha + " and motivo!=''");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  265 */     if (this.jTable1.getRowCount() < 1) {
/*  266 */       JOptionPane.showMessageDialog(this, "No existen datos en ese periodo seleccionado", "No hay datos", 0, this.ADVER);
/*      */       
/*      */       return;
/*      */     } 
/*  270 */     Facturas33CanceladasInternas canceladasInternas = new Facturas33CanceladasInternas(this.con, new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo" }, "numFactura,tipo,folio,folioFiscal,fecha,cliente,suPedido,equipo,subtotal,descMonto,iva,retencion,total,totalDebe,estatus,usuario, cartaporte, version, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura ", "facturas33, polizascanceladas", "WHERE estatus like '%Cancelada%' and  facturas33.folio = polizascanceladas.folioInterno and tipo = '" + this.TIPO + "' and  moneda = '" + this.MONEDA + "'" + consultaFecha + " and motivo!=''");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  279 */     this.TablitaSinAfectacion = canceladasInternas.regresaTabla();
/*      */     
/*  281 */     this.jLabel1.setText("Total de datos: " + this.jTable1.getRowCount());
/*  282 */     DefaultTableModel model = (DefaultTableModel)this.jTable1.getModel(); int i;
/*  283 */     for (i = 0; i < model.getRowCount(); i++) {
/*  284 */       model.setValueAt(Integer.valueOf(i + 1), i, 0);
/*      */     }
/*      */     
/*  287 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "folio", "fiscal", "fecha", "cliente", "sub", "iva", "ret", "total", "Tipo", "Metodo" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  294 */     this.utilerias.vaciarTabla(this.jTable3);
/*  295 */     this.LISTAFACTURAS = new String[this.jTable1.getRowCount()];
/*      */     
/*  297 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/*  298 */       String persona = this.jTable1.getValueAt(i, 20).toString();
/*  299 */       if (persona.equals("PERSONA_FISICA")) {
/*  300 */         persona = "PF";
/*  301 */       } else if (persona.equals("PERSONA_MORAL")) {
/*  302 */         persona = "PM";
/*  303 */       } else if (persona.equals("EXTRANJERO")) {
/*  304 */         persona = "EXT";
/*      */       } else {
/*  306 */         persona = "INV";
/*      */       } 
/*  308 */       this.utilerias.agregarCampoTablas(new String[] { this.jTable1
/*      */             
/*  310 */             .getValueAt(i, 0).toString(), this.jTable1
/*  311 */             .getValueAt(i, 2).toString(), this.jTable1
/*  312 */             .getValueAt(i, 3).toString(), this.jTable1
/*  313 */             .getValueAt(i, 4).toString(), this.jTable1
/*  314 */             .getValueAt(i, 5).toString(), this.jTable1
/*  315 */             .getValueAt(i, 8).toString(), this.jTable1
/*  316 */             .getValueAt(i, 10).toString(), this.jTable1
/*  317 */             .getValueAt(i, 11).toString(), this.jTable1
/*  318 */             .getValueAt(i, 12).toString(), persona, this.jTable1
/*      */             
/*  320 */             .getValueAt(i, 21).toString().substring(0, 3) }this.jTable2);
/*      */ 
/*      */       
/*  323 */       this.LISTAFACTURAS[i] = this.jTable1.getValueAt(i, 2).toString();
/*      */     } 
/*      */     
/*  326 */     double sub = this.utilerias.sumarColumnaTabla(this.jTable2, 5);
/*  327 */     double iva = this.utilerias.sumarColumnaTabla(this.jTable2, 6);
/*  328 */     double ret = this.utilerias.sumarColumnaTabla(this.jTable2, 7);
/*  329 */     double tot = this.utilerias.sumarColumnaTabla(this.jTable2, 8);
/*      */     
/*  331 */     if (this.jTable2.getRowCount() > 0) {
/*  332 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  333 */       this.utilerias.agregarCampoTablas(new String[] { "", "", "FOLIO INICIAL: " + 
/*      */ 
/*      */ 
/*      */             
/*  337 */             String.valueOf(this.jTable2.getValueAt(0, 1)), "", "FOLIO FINAL: " + 
/*      */             
/*  339 */             String.valueOf(this.jTable2.getValueAt(this.jTable2.getRowCount() - 2, 1)), "", "", "", "", "", "", "", "" }this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  348 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     } 
/*  350 */     insertarRenglonLineas();
/*  351 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  358 */           .convertirDoublePesos(sub), this.utilerias
/*  359 */           .convertirDoublePesos(iva), this.utilerias
/*  360 */           .convertirDoublePesos(ret), this.utilerias
/*  361 */           .convertirDoublePesos(tot), "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  366 */     this.FLETESSUB = sub;
/*      */     
/*  368 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */ 
/*      */     
/*  371 */     int registrosParaAgregar = calcularRegistrosParaMultiplo(this.jTable2.getRowCount(), this.multiplo);
/*  372 */     int reg = registrosParaAgregar;
/*  373 */     for (int j = 0; j < reg; j++) {
/*  374 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     }
/*      */     
/*  377 */     sacarListaProductos();
/*  378 */     sacarPrimeroVentasFletes();
/*  379 */     sacarSegundoVentasFletes();
/*  380 */     sacarTerceroVentasFletes();
/*  381 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  382 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  383 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  385 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "CLIENTES " + (String)this.CAMPOSGENERALES
/*      */ 
/*      */ 
/*      */           
/*  389 */           .get("sucursal"), "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */           
/*  393 */           .convertirDoublePesos(tot - sacarSumaTipoAnticipo()), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  401 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "ANTICIPOS ", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  409 */           .convertirDoublePesos(sacarSumaTipoAnticipo()), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  417 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "IVA TRASLADADO P/ COBRAR", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  424 */           .convertirDoublePesos(iva), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  433 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "FLETES CON RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  440 */           .convertirDoublePesos(this.FLETESCR), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  449 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "FLETES SIN RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  456 */           .convertirDoublePesos(this.FLETESSR), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  465 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTROS INGRESOS POR VENTAS", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  472 */           .convertirDoublePesos(this.FLETESO), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  481 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "INGRESOS POR VENTA DE ACTIVO FIJO", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  488 */           .convertirDoublePesos(this.INGRESOSACTIVOFIJO), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  497 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "RETENCIÓN DE IVA", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  505 */           .convertirDoublePesos(ret), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  513 */     double totG1 = tot + ret;
/*  514 */     double totG2 = iva + this.FLETESCR + this.FLETESSR + this.FLETESO;
/*      */     
/*  516 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  532 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  539 */           .convertirDoublePesos(totG1), this.utilerias
/*  540 */           .convertirDoublePesos(totG1), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  548 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  549 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  550 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "****** INFORMACIÓN DE PRODUCTOS ******", "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  566 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "| CLAVE DE PRODUCTO |", "", "| DESCRIPCIÓN DE PRODUCTO |", "| SUB |", "| TRAS ", "| RETENIDO |", "| TOTAL |", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  582 */     consultarProductosDif();
/*      */ 
/*      */     
/*  585 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  592 */           .convertirDoublePesos(sub), this.utilerias
/*  593 */           .convertirDoublePesos(iva), this.utilerias
/*  594 */           .convertirDoublePesos(ret), this.utilerias
/*  595 */           .convertirDoublePesos(tot), "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  601 */     if (this.TablitaSinAfectacion.getRowCount() > 0) {
/*  602 */       insertarFacturasSinAfectaciones();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  611 */     imprimirReportePolizas();
/*      */   }
/*      */   
/*      */   public void insertarFacturasSinAfectaciones() {
/*  615 */     this.utilerias.agregarCampoTablasVacios(this.jTable3);
/*  616 */     this.utilerias.agregarCampoTablasVacios(this.jTable3);
/*  617 */     this.utilerias.agregarCampoTablasVacios(this.jTable3);
/*      */     
/*  619 */     this.utilerias.agregarCampoTablas(new String[] { "", "*** INF DE VENTAS SIN AFECTACIONES ***", "", "", "", "", "", "", "", "", "" }, this.jTable3);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  635 */     for (int i = 0; i < this.TablitaSinAfectacion.getRowCount(); i++) {
/*  636 */       this.utilerias.agregarCampoTablas(new String[] { this.TablitaSinAfectacion
/*      */ 
/*      */             
/*  639 */             .getValueAt(i, 2).toString(), this.TablitaSinAfectacion
/*  640 */             .getValueAt(i, 3).toString(), this.TablitaSinAfectacion
/*  641 */             .getValueAt(i, 4).toString(), this.TablitaSinAfectacion
/*  642 */             .getValueAt(i, 5).toString(), this.TablitaSinAfectacion
/*  643 */             .getValueAt(i, 8).toString(), this.TablitaSinAfectacion
/*  644 */             .getValueAt(i, 9).toString(), this.TablitaSinAfectacion
/*  645 */             .getValueAt(i, 10).toString(), this.TablitaSinAfectacion
/*  646 */             .getValueAt(i, 11).toString(), this.TablitaSinAfectacion
/*  647 */             .getValueAt(i, 12).toString(), this.TablitaSinAfectacion
/*  648 */             .getValueAt(i, 13).toString(), this.TablitaSinAfectacion
/*  649 */             .getValueAt(i, 14).toString() }this.jTable3);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void consultarProductosDif() {
/*  657 */     Map<String, String> CantProdIva = new HashMap<>();
/*  658 */     Map<String, String> CantProdRet = new HashMap<>();
/*  659 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/*  660 */           .buscarDatos(1, "DISTINCT claveproducto", " facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and claveproducto<>'' and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.claveproducto asc"), (Object[])new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  668 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  672 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  676 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/*  677 */       CantProdIva.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*  678 */       CantProdRet.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*      */     } 
/*      */     
/*  681 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/*  682 */           .buscarDatos("claveProducto, tipoImpuesto, totalImpuesto, facturas33.folio, facturas33.fecha ,facturas33.estatus ", "facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.num asc"), (Object[])new String[] { "Clave Prod", "Tipo", "Total", "Factura", "Fecha", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  689 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  693 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  697 */     double valor1 = 0.0D;
/*  698 */     double valor2 = 0.0D;
/*      */     
/*  700 */     double retenidoPrueba = 0.0D;
/*  701 */     for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/*  702 */       if (((String)this.CAMPOSGENERALES.get("sucursal")).equals("POZA RICA") || ((String)this.CAMPOSGENERALES.get("sucursal")).equals("CADEREYTA")) {
/*  703 */         String folio = this.jTable5.getValueAt(j, 3).toString();
/*  704 */         for (int i1 = 0; i1 < this.jTable6.getRowCount(); i1++) {
/*  705 */           String folio2 = this.jTable6.getValueAt(i1, 2).toString();
/*  706 */           if (folio.equals(folio2) && this.jTable6.getValueAt(i1, 18).equals("USD") && !this.jTable5.getValueAt(j, 2).toString().equals("")) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  712 */       String cod = this.jTable5.getValueAt(j, 0).toString();
/*  713 */       if (!cod.equals("")) {
/*      */         
/*  715 */         String[] dat = regresaTipoImpuesto(j);
/*  716 */         if (dat != null && 
/*  717 */           dat[0].equals("TRASLADO")) {
/*  718 */           double cantAnt = this.utilerias.convertirCantTexto(CantProdIva.get(cod));
/*  719 */           double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  720 */           CantProdIva.put(cod, "" + v2);
/*  721 */           valor1 += this.utilerias.convertirCantTexto(dat[1]);
/*      */         } 
/*      */ 
/*      */         
/*  725 */         if (j < this.jTable5.getRowCount() - 1 && dat != null) {
/*      */           
/*  727 */           dat = regresaTipoImpuesto(j + 1);
/*  728 */           if (dat != null && 
/*  729 */             dat[0].equals("RETENIDO")) {
/*  730 */             double cantAnt = this.utilerias.convertirCantTexto(CantProdRet.get(cod));
/*  731 */             double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  732 */             CantProdRet.put(cod, "" + v2);
/*  733 */             valor2 += this.utilerias.convertirCantTexto(dat[1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  741 */     DefaultTableModel model = (DefaultTableModel)this.jTable4.getModel();
/*  742 */     model.addColumn("Descripcion");
/*  743 */     model.fireTableDataChanged();
/*  744 */     for (int k = 0; k < this.jTable4.getRowCount(); k++) {
/*  745 */       this.con.consultar("descripcion", "catproductos", "where clave = " + String.valueOf(this.jTable4.getValueAt(k, 0)));
/*  746 */       this.jTable4.setValueAt(this.con.Campo, k, 1);
/*      */     } 
/*      */     
/*  749 */     double[] cantidades = new double[this.jTable4.getRowCount()];
/*  750 */     double totalProd = 0.0D;
/*  751 */     for (int m = 0; m < this.jTable4.getRowCount(); m++) {
/*  752 */       String[] cant = this.con.regresaColIndex("importe", "facturas33, conceptosfacturas33", "where claveproducto='" + 
/*      */ 
/*      */           
/*  755 */           String.valueOf(this.jTable4.getValueAt(m, 0)) + "' and folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ")");
/*  756 */       for (int i1 = 0; i1 < cant.length; i1++) {
/*  757 */         cantidades[m] = cantidades[m] + this.utilerias.convertirCantTexto(cant[i1]);
/*  758 */         totalProd += this.utilerias.convertirCantTexto(cant[i1]);
/*      */       } 
/*      */     } 
/*      */     
/*  762 */     double iva = 0.0D;
/*  763 */     double ret = 0.0D;
/*  764 */     double tot = 0.0D;
/*      */     int n;
/*  766 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/*  767 */       String cod = CantProdIva.get(this.jTable4.getValueAt(n, 0).toString());
/*  768 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod)), n, 2);
/*      */       
/*  770 */       String cod2 = CantProdRet.get(this.jTable4.getValueAt(n, 0).toString());
/*  771 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod2)), n, 3);
/*      */     } 
/*      */     
/*  774 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/*  775 */       double suma = cantidades[n] + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 2).toString()) - this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 3).toString());
/*      */       
/*  777 */       this.utilerias.agregarCampoTablas(new String[] { "", "", this.jTable4
/*      */ 
/*      */ 
/*      */             
/*  781 */             .getValueAt(n, 0).toString(), "", this.jTable4
/*      */             
/*  783 */             .getValueAt(n, 1).toString(), this.utilerias
/*  784 */             .convertirDoublePesos(cantidades[n]), this.jTable4
/*  785 */             .getValueAt(n, 2).toString(), this.jTable4
/*  786 */             .getValueAt(n, 3).toString(), this.utilerias
/*  787 */             .convertirDoublePesos(suma), "", "" }this.jTable2);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  794 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  810 */     double totGral = totalProd + iva - ret;
/*      */   }
/*      */   
/*      */   public double sacarSumaTipoAnticipo() {
/*  814 */     double sum = 0.0D;
/*  815 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/*  816 */       String col = this.jTable1.getValueAt(i, 22).toString();
/*  817 */       if (col.equals("ANTICIPO")) {
/*  818 */         sum += this.utilerias.convertirCantTexto(this.jTable1.getValueAt(i, 12).toString());
/*      */       }
/*      */     } 
/*  821 */     return sum;
/*      */   }
/*      */   
/*      */   public String[] regresaTipoImpuesto(int reg) {
/*  825 */     String[] datos = { "", "" };
/*  826 */     String cant = "";
/*      */     
/*  828 */     if (reg < this.jTable5.getRowCount() - 1) {
/*  829 */       String tipo = this.jTable5.getValueAt(reg + 1, 1).toString();
/*      */       
/*  831 */       if (!tipo.equals("")) {
/*  832 */         cant = this.jTable5.getValueAt(reg + 1, 2).toString();
/*  833 */         datos[0] = tipo;
/*  834 */         datos[1] = cant;
/*      */       } else {
/*  836 */         return null;
/*      */       } 
/*      */     } 
/*  839 */     return datos;
/*      */   }
/*      */   
/*      */   public void insertarRenglonLineas() {
/*  843 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "" }, this.jTable2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sacarListaProductos() {
/*  861 */     String consulta = "";
/*  862 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/*  863 */       consulta = consulta + " conceptosfacturas33.numfactura = '" + consulta + "' ";
/*  864 */       if (i + 1 < this.LISTAFACTURAS.length) {
/*  865 */         consulta = consulta + " || ";
/*      */       }
/*      */     } 
/*  868 */     this.CONSULTARLISTARPRODUCTOS = consulta;
/*  869 */     this.utilerias.consultaGralTabla(this.con, this.jTable3, new String[] { "clave", "importe", "numFactura" }, "claveproducto, importe, numfactura", "conceptosfacturas33", "where (" + consulta + ") and claveproducto <>'' ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  886 */     this.jEditorPane1.setText("select claveproducto, importe, numfactura from  conceptosfacturas33 where (" + consulta + ") and claveproducto <>'' order by numFactura desc");
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarPrimeroVentasFletes() {
/*  891 */     double fletesRetencion = 0.0D;
/*  892 */     int cont = 0;
/*  893 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/*  894 */       String folio = this.jTable2.getValueAt(i, 1).toString();
/*  895 */       String iva = this.jTable2.getValueAt(i, 6).toString();
/*  896 */       String ret = this.jTable2.getValueAt(i, 7).toString();
/*  897 */       String tipo = this.jTable2.getValueAt(i, 9).toString();
/*      */       
/*  899 */       if (!iva.equals("$0.00") && !ret.equals("$0.00") && tipo.equals("PM")) {
/*  900 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/*  901 */           String codigo = this.jTable3.getValueAt(j, 0).toString();
/*  902 */           String fact = this.jTable3.getValueAt(j, 2).toString();
/*  903 */           if ((fact.equals(folio) && codigo.equals("78101800")) || (fact.equals(folio) && codigo.equals("78101801")) || (fact.equals(folio) && codigo.equals("78101802"))) {
/*  904 */             cont++;
/*  905 */             fletesRetencion += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  912 */     this.FLETESCR = fletesRetencion;
/*      */     
/*  914 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS FLETES C/RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  921 */           .convertirDoublePesos(fletesRetencion), "", "", "", "", "" }, this.jTable2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sacarSegundoVentasFletes() {
/*  933 */     double fletesSinRetencion = 0.0D;
/*  934 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/*  935 */       String folio = this.jTable2.getValueAt(i, 1).toString();
/*  936 */       String iva = this.jTable2.getValueAt(i, 6).toString();
/*  937 */       String ret = this.jTable2.getValueAt(i, 7).toString();
/*  938 */       String tipo = this.jTable2.getValueAt(i, 9).toString();
/*      */       
/*  940 */       String cliente = this.jTable2.getValueAt(i, 4).toString();
/*      */       
/*  942 */       if ((cliente.equals("GSM - BRONCO S. A. DE C. V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/*  943 */         .equals("DOWELL SCHLUMBERGER DE MEXICO, S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/*  944 */         .equals("BAKER HUGHES OPERATIONS MEXICO S. DE R.L. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/*  945 */         .equals("CLEANMEX ENERGY SERVICES S DE RL DE CV") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/*  946 */         .equals("CAPITAL CARGO DEL GOLFO S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/*  947 */         .equals("ENERGY DRILLING MARINE SERVICES S.A.P. DE I. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || ret
/*      */         
/*  949 */         .equals("$0.00")) {
/*  950 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/*  951 */           String codigo = this.jTable3.getValueAt(j, 0).toString();
/*  952 */           String fact = this.jTable3.getValueAt(j, 2).toString();
/*  953 */           if (fact.equals(folio) && (codigo.equals("78101800") || codigo.equals("78101801") || codigo.equals("78101802") || codigo.equals("76122401")))
/*      */           {
/*  955 */             fletesSinRetencion += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  966 */     this.FLETESSR = fletesSinRetencion;
/*  967 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS FLETES SIN/RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  974 */           .convertirDoublePesos(fletesSinRetencion), "", "", "", "", "" }, this.jTable2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sacarTerceroVentasFletes() {
/*  986 */     this.INGRESOSACTIVOFIJO = 0.0D;
/*  987 */     for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/*  988 */       String codigo = this.jTable3.getValueAt(j, 0).toString();
/*  989 */       String fact = this.jTable3.getValueAt(j, 2).toString();
/*  990 */       if (codigo.equals("25101600") || codigo.equals("25101503") || codigo.equals("25101500"))
/*      */       {
/*      */         
/*  993 */         this.INGRESOSACTIVOFIJO += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  998 */     this.FLETESO = this.FLETESSUB - this.FLETESCR + this.FLETESSR + this.INGRESOSACTIVOFIJO;
/*      */     
/* 1000 */     if (this.FLETESO < 2.0D) {
/* 1001 */       this.FLETESO = 0.0D;
/*      */     }
/*      */     
/* 1004 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTRAS VENTAS", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1011 */           .convertirDoublePesos(this.FLETESO), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1020 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "INRGESOS POR VENTA DE ACTIVO FIJO", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1027 */           .convertirDoublePesos(this.INGRESOSACTIVOFIJO), "", "", "", "", "" }, this.jTable2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void imprimirReportePolizas() {
/* 1039 */     JTable aux = crearTablaAux2(this.jTable2, new Object[] { "cont", "Folio", "Fiscal", "Fecha", "Cliente", "Sub", "Iva", "Ret", "Tot", "Tipo", "Met" });
/* 1040 */     this.utilerias.quitarSignoPesosTabla(aux);
/* 1041 */     Map<Object, Object> datos = new HashMap<>();
/* 1042 */     this.utilerias.cargarImagenesAReporte(datos);
/* 1043 */     datos.put("sucursal", ((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 1044 */     datos.put("periodo", this.etiquetaFecha);
/* 1045 */     datos.put("cliente", "TODOS");
/* 1046 */     datos.put("estado", "CANCELADAS");
/* 1047 */     datos.put("titulo", "REPORTE DE PÓLIZAS CANCELADAS " + this.MONEDA);
/* 1048 */     datos.put("documento", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/*      */     
/*      */     try {
/* 1051 */       this.utilerias.verImpresion("/Reportes/Facturacion/PolizasPeriodo.jasper", aux, datos, "REPORTE DE PÓLIZAS CANCELADAS" + this.MONEDA);
/* 1052 */     } catch (JRException ex) {
/* 1053 */       Logger.getLogger(Facturas33PeriodoCanceladas.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String convertirFechaATexto(String fecha) {
/* 1058 */     String fechaCorta = fecha.substring(0, 10);
/* 1059 */     String año = fechaCorta.substring(0, 4);
/* 1060 */     String mes = fechaCorta.substring(5, 7);
/* 1061 */     String dia = fechaCorta.substring(8, 10);
/* 1062 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 1063 */     return strFecha;
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 1067 */     String canti = cant;
/* 1068 */     String valorP = "";
/* 1069 */     for (int j = 0; j < canti.length(); j++) {
/* 1070 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 1071 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 1074 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public static int calcularRegistrosParaMultiplo(int registros, int multiplo) {
/* 1078 */     int residuo = registros % multiplo;
/* 1079 */     return (residuo == 0) ? 0 : (multiplo - residuo);
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux2(JTable Original, Object[] columnas) {
/* 1083 */     Object[] Columnas = columnas;
/* 1084 */     Object[][] registros = new Object[Original.getRowCount()][columnas.length];
/* 1085 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 1086 */       registros[i][0] = Integer.valueOf(i + 1);
/* 1087 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 1088 */         if (j == 0) {
/* 1089 */           registros[i][0] = Original.getValueAt(i, j);
/*      */         }
/* 1091 */         if (j == 1) {
/* 1092 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 1094 */         if (j == 2) {
/* 1095 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/*      */         
/* 1098 */         if (j == 3) {
/* 1099 */           if (!Original.getValueAt(i, j).toString().equals("")) {
/* 1100 */             registros[i][3] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */           } else {
/* 1102 */             registros[i][3] = "";
/*      */           } 
/*      */         }
/* 1105 */         if (j == 4) {
/*      */           try {
/* 1107 */             registros[i][4] = Original.getValueAt(i, j);
/*      */           }
/* 1109 */           catch (NumberFormatException e) {
/* 1110 */             registros[i][4] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */         
/* 1114 */         if (j == 5) {
/*      */           try {
/* 1116 */             registros[i][5] = Original.getValueAt(i, j);
/*      */           }
/* 1118 */           catch (NumberFormatException e) {
/* 1119 */             registros[i][5] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1122 */         if (j == 6) {
/*      */           try {
/* 1124 */             registros[i][6] = Original.getValueAt(i, j);
/*      */           }
/* 1126 */           catch (NumberFormatException e) {
/* 1127 */             registros[i][6] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1130 */         if (j == 7) {
/*      */           try {
/* 1132 */             registros[i][7] = Original.getValueAt(i, j);
/*      */           }
/* 1134 */           catch (NumberFormatException e) {
/* 1135 */             registros[i][7] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1138 */         if (j == 8) {
/*      */           try {
/* 1140 */             registros[i][8] = Original.getValueAt(i, j);
/*      */           }
/* 1142 */           catch (NumberFormatException e) {
/* 1143 */             registros[i][8] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1146 */         if (j == 9) {
/*      */           try {
/* 1148 */             registros[i][9] = Original.getValueAt(i, j);
/*      */           }
/* 1150 */           catch (NumberFormatException e) {
/* 1151 */             registros[i][9] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1154 */         if (j == 10) {
/*      */           try {
/* 1156 */             registros[i][10] = Original.getValueAt(i, j);
/*      */           }
/* 1158 */           catch (NumberFormatException e) {
/* 1159 */             registros[i][10] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1164 */     JTable aux = new JTable(registros, Columnas);
/* 1165 */     return aux;
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Facturas33PeriodoCanceladas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */