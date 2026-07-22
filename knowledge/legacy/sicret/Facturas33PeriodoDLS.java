/*      */ package sicret;
/*      */ 
/*      */ import java.awt.Toolkit;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.TreeSet;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
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
/*      */ import javax.swing.table.TableColumnModel;
/*      */ import javax.swing.table.TableModel;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import utilerias.Utilerias;
/*      */ 
/*      */ public class Facturas33PeriodoDLS
/*      */   extends JDialog {
/*   32 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   33 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   34 */   Consultas2 con = new Consultas2();
/*      */   Date fecha1;
/*      */   Date fecha2;
/*      */   String MONEDA;
/*      */   String TIPO;
/*   39 */   Utilerias utilerias = new Utilerias();
/*      */   String[] LISTAFACTURAS;
/*      */   String[] LISTAFACTURAS2;
/*   42 */   double FLETESCR = 0.0D;
/*   43 */   double FLETESSR = 0.0D;
/*   44 */   double FLETESO = 0.0D;
/*   45 */   double FLETESSUB = 0.0D;
/*   46 */   double FLETESANTICIPO = 0.0D;
/*   47 */   double INGRESOSACTIVOFIJO = 0.0D;
/*   48 */   String CONSULTARLISTARPRODUCTOS = "";
/*      */   Map<String, String> CAMPOSGENERALES;
/*   50 */   int multiplo = 28; JComboBox MES; JComboBox AÑO; JTable TablitaSinAfectacion; private JEditorPane jEditorPane1;
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel2;
/*   53 */   String etiquetaFecha = ""; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3;
/*      */   private JScrollPane jScrollPane4;
/*      */   
/*      */   public Facturas33PeriodoDLS(Map<String, String> CAMPOSGENERALES, Consultas2 con, Date fecha1, Date fecha2, String MONEDA, String TIPO, JComboBox MES, JComboBox AÑO) {
/*   57 */     initComponents();
/*   58 */     System.out.println("*** ACTIVAS DLS **** ");
/*   59 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   60 */     this.con = con;
/*   61 */     this.fecha1 = fecha1;
/*   62 */     this.fecha2 = fecha2;
/*   63 */     this.MONEDA = MONEDA;
/*   64 */     this.TIPO = TIPO;
/*   65 */     this.MES = MES;
/*   66 */     this.AÑO = AÑO;
/*      */     
/*   68 */     this.utilerias.vaciarTabla(this.jTable1);
/*   69 */     this.utilerias.vaciarTabla(this.jTable2);
/*   70 */     this.utilerias.vaciarTabla(this.jTable3);
/*   71 */     this.utilerias.vaciarTabla(this.jTable4);
/*   72 */     this.utilerias.vaciarTabla(this.jTable5);
/*   73 */     this.utilerias.vaciarTabla(this.jTable6);
/*   74 */     consultarFacturasGral();
/*      */     
/*   76 */     this.jLabel2.setText("Lineas en jTable2: " + this.jTable2.getRowCount());
/*      */   }
/*      */   private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JTable jTable1; private JTable jTable2; private JTable jTable3;
/*      */   private JTable jTable4;
/*      */   private JTable jTable5;
/*      */   private JTable jTable6;
/*      */   
/*      */   private void initComponents() {
/*   84 */     this.jScrollPane1 = new JScrollPane();
/*   85 */     this.jTable1 = new JTable();
/*   86 */     this.jScrollPane2 = new JScrollPane();
/*   87 */     this.jTable2 = new JTable();
/*   88 */     this.jScrollPane3 = new JScrollPane();
/*   89 */     this.jTable3 = new JTable();
/*   90 */     this.jScrollPane4 = new JScrollPane();
/*   91 */     this.jEditorPane1 = new JEditorPane();
/*   92 */     this.jLabel1 = new JLabel();
/*   93 */     this.jScrollPane5 = new JScrollPane();
/*   94 */     this.jTable4 = new JTable();
/*   95 */     this.jScrollPane6 = new JScrollPane();
/*   96 */     this.jTable5 = new JTable();
/*   97 */     this.jScrollPane7 = new JScrollPane();
/*   98 */     this.jTable6 = new JTable();
/*   99 */     this.jLabel2 = new JLabel();
/*      */     
/*  101 */     setDefaultCloseOperation(2);
/*      */     
/*  103 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  114 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  116 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  127 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/*  129 */     this.jTable3.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  140 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/*  142 */     this.jScrollPane4.setViewportView(this.jEditorPane1);
/*      */     
/*  144 */     this.jLabel1.setText("Total de datos:");
/*      */     
/*  146 */     this.jTable4.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  157 */     this.jScrollPane5.setViewportView(this.jTable4);
/*      */     
/*  159 */     this.jTable5.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  170 */     this.jScrollPane6.setViewportView(this.jTable5);
/*      */     
/*  172 */     this.jTable6.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  183 */     this.jScrollPane7.setViewportView(this.jTable6);
/*      */     
/*  185 */     this.jLabel2.setText("Total de datos:");
/*      */     
/*  187 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  188 */     getContentPane().setLayout(layout);
/*  189 */     layout.setHorizontalGroup(layout
/*  190 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  191 */         .addComponent(this.jScrollPane1)
/*  192 */         .addComponent(this.jScrollPane5, -1, 1167, 32767)
/*  193 */         .addComponent(this.jScrollPane6, -1, 1167, 32767)
/*  194 */         .addGroup(layout.createSequentialGroup()
/*  195 */           .addContainerGap()
/*  196 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  197 */             .addGroup(layout.createSequentialGroup()
/*  198 */               .addComponent(this.jLabel1, -2, 397, -2)
/*  199 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  200 */               .addComponent(this.jLabel2, -2, 397, -2))
/*  201 */             .addComponent(this.jScrollPane4, -2, 0, 32767))
/*  202 */           .addContainerGap())
/*  203 */         .addComponent(this.jScrollPane3)
/*  204 */         .addComponent(this.jScrollPane7, -1, 1167, 32767)
/*  205 */         .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING));
/*      */     
/*  207 */     layout.setVerticalGroup(layout
/*  208 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  209 */         .addGroup(layout.createSequentialGroup()
/*  210 */           .addContainerGap()
/*  211 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  212 */             .addComponent(this.jLabel1)
/*  213 */             .addComponent(this.jLabel2))
/*  214 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  215 */           .addComponent(this.jScrollPane1, -2, 100, -2)
/*  216 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  217 */           .addComponent(this.jScrollPane2, -2, 126, -2)
/*  218 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  219 */           .addComponent(this.jScrollPane3, -2, 153, -2)
/*  220 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  221 */           .addComponent(this.jScrollPane5, -2, 100, -2)
/*  222 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  223 */           .addComponent(this.jScrollPane6, -2, 88, -2)
/*  224 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  225 */           .addComponent(this.jScrollPane7, -1, 136, 32767)
/*  226 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  227 */           .addComponent(this.jScrollPane4, -2, 81, -2)
/*  228 */           .addContainerGap()));
/*      */ 
/*      */     
/*  231 */     pack();
/*      */   }
/*      */   
/*      */   public void consultarFacturasGral() {
/*  235 */     String fechaCompleta1 = "";
/*  236 */     String fechaCompleta2 = "";
/*  237 */     String consultaFecha = "";
/*  238 */     if (this.MES.getSelectedIndex() != 0) {
/*  239 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*      */       
/*  241 */       int aa = Integer.parseInt(this.AÑO.getSelectedItem().toString());
/*  242 */       consultaFecha = " and  date_format( fecha, '%m-%Y') = '" + mes[this.MES.getSelectedIndex()] + "-" + aa + "' ";
/*  243 */       this.etiquetaFecha = this.MES.getSelectedItem().toString() + "/" + this.MES.getSelectedItem().toString();
/*      */     } else {
/*  245 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  246 */       String cadenaFecha = "";
/*  247 */       cadenaFecha = formato.format(this.fecha1);
/*  248 */       String AÑO = cadenaFecha.substring(0, 4);
/*  249 */       String MES = cadenaFecha.substring(4, 6);
/*  250 */       String DIA = cadenaFecha.substring(6, 8);
/*  251 */       fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*  252 */       this.etiquetaFecha = DIA + "/" + DIA + "/" + MES;
/*  253 */       cadenaFecha = formato.format(this.fecha2);
/*  254 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/*  255 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/*  256 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/*  257 */       this.etiquetaFecha = this.etiquetaFecha + " AL " + this.etiquetaFecha + "/" + dd + "/" + mm;
/*  258 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/*  259 */       consultaFecha = " and fecha between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     } 
/*      */     
/*  262 */     this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Núm", "Tipo", "Folio", "Fecha", "Cliente", "Subtotal", "Iva", "Retención", "Total", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo", "tipoCambio", "TipoCambioReal" }, "numFactura,tipo,folio,fecha,cliente,subtotal,iva,retencion,total, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura, tipoCambio, tipoCambioReal", "facturas33", "WHERE tipo = '" + this.TIPO + "' and  moneda = '" + this.MONEDA + "'" + consultaFecha + " and folio <>'PR46073' and estatus not like '%intercance%'");
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
/*  274 */     if (this.jTable1.getRowCount() < 1) {
/*  275 */       JOptionPane.showMessageDialog(this, "No existen datos en ese periodo seleccionado", "No hay datos", 0, this.ADVER);
/*      */       
/*      */       return;
/*      */     } 
/*  279 */     Facturas33CanceladasInternas canceladasInternas = new Facturas33CanceladasInternas(this.con, new String[] { "Núm", "Tipo", "Folio", "Fecha", "Cliente", "Subtotal", "Iva", "Retención", "Total", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo", "tipoCambio", "TipoCambioReal" }, "numFactura,tipo,folio,fecha,cliente,subtotal,iva,retencion,total, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura, tipoCambio, tipoCambioReal", "facturas33, polizascanceladas", "WHERE facturas33.folio = polizascanceladas.folioInterno and tipo = '" + this.TIPO + "' and  moneda = '" + this.MONEDA + "'" + consultaFecha + " and estatus like '%intercance%'");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  287 */     this.TablitaSinAfectacion = canceladasInternas.regresaTabla();
/*      */     
/*  289 */     this.jLabel1.setText("Total de datos: " + this.jTable1.getRowCount());
/*  290 */     DefaultTableModel model = (DefaultTableModel)this.jTable1.getModel();
/*  291 */     model.addColumn("tipoCambioActualizado"); int i;
/*  292 */     for (i = 0; i < model.getRowCount(); i++) {
/*  293 */       model.setValueAt(Integer.valueOf(i + 1), i, 0);
/*      */       
/*  295 */       String tipoCambio = model.getValueAt(i, 10).toString();
/*  296 */       String tipoCambioReal = model.getValueAt(i, 15).toString();
/*      */       
/*  298 */       if (!tipoCambioReal.equals("")) {
/*  299 */         model.setValueAt(tipoCambioReal, i, 16);
/*      */       } else {
/*  301 */         model.setValueAt(tipoCambio, i, 16);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  306 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Folio", "Fecha", "Cliente", "Sub", "Iva", "Ret", "Tot", "Cambio", "Tipo", "Met" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  313 */     this.utilerias.vaciarTabla(this.jTable3);
/*  314 */     this.LISTAFACTURAS = new String[this.jTable1.getRowCount()];
/*      */     
/*  316 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/*  317 */       String persona = this.jTable1.getValueAt(i, 11).toString();
/*  318 */       if (persona.equals("PERSONA_FISICA")) {
/*  319 */         persona = "PF";
/*  320 */       } else if (persona.equals("PERSONA_MORAL")) {
/*  321 */         persona = "PM";
/*  322 */       } else if (persona.equals("EXTRANJERO")) {
/*  323 */         persona = "EXT";
/*      */       } else {
/*  325 */         persona = "INV";
/*      */       } 
/*  327 */       this.utilerias.agregarCampoTablas(new String[] { this.jTable1
/*      */             
/*  329 */             .getValueAt(i, 0).toString(), this.jTable1
/*  330 */             .getValueAt(i, 2).toString(), 
/*      */             
/*  332 */             convertirFechaATexto(this.jTable1.getValueAt(i, 3).toString()), this.jTable1
/*  333 */             .getValueAt(i, 4).toString(), this.jTable1
/*  334 */             .getValueAt(i, 5).toString(), this.jTable1
/*  335 */             .getValueAt(i, 6).toString(), this.jTable1
/*  336 */             .getValueAt(i, 7).toString(), this.jTable1
/*  337 */             .getValueAt(i, 8).toString(), this.jTable1
/*  338 */             .getValueAt(i, 10).toString(), persona, this.jTable1
/*      */             
/*  340 */             .getValueAt(i, 12).toString().substring(0, 3), this.jTable1
/*  341 */             .getValueAt(i, 16).toString() }this.jTable2);
/*      */ 
/*      */       
/*  344 */       this.LISTAFACTURAS[i] = this.jTable1.getValueAt(i, 2).toString();
/*      */     } 
/*      */     
/*  347 */     agregarColumnasMXN();
/*  348 */     llenarPesos();
/*  349 */     ordenarColumnas();
/*      */     
/*  351 */     double sub = this.utilerias.sumarColumnaTabla(this.jTable2, 4);
/*  352 */     double iva = this.utilerias.sumarColumnaTabla(this.jTable2, 5);
/*  353 */     double ret = this.utilerias.sumarColumnaTabla(this.jTable2, 6);
/*  354 */     double tot = this.utilerias.sumarColumnaTabla(this.jTable2, 7);
/*      */     
/*  356 */     double subMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 9);
/*  357 */     double ivaMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 10);
/*  358 */     double retMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 11);
/*  359 */     double totMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 12);
/*      */     
/*  361 */     if (this.jTable2.getRowCount() > 0) {
/*  362 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  363 */       this.utilerias.agregarCampoTablas(new String[] { "", "", "", 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  368 */             String.valueOf(this.jTable2.getValueAt(0, 1)) + " / " + String.valueOf(this.jTable2.getValueAt(0, 1)), "", "", "", "", "", "", "", "", "", "", "" }this.jTable2);
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
/*  381 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     } 
/*  383 */     insertarRenglonLineas();
/*  384 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  390 */           .convertirDoublePesos(sub), this.utilerias
/*  391 */           .convertirDoublePesos(iva), this.utilerias
/*  392 */           .convertirDoublePesos(ret), this.utilerias
/*  393 */           .convertirDoublePesos(tot), "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */           
/*  397 */           .convertirDoublePesos(subMXN), this.utilerias
/*  398 */           .convertirDoublePesos(ivaMXN), this.utilerias
/*  399 */           .convertirDoublePesos(retMXN), this.utilerias
/*  400 */           .convertirDoublePesos(totMXN) }, this.jTable2);
/*      */ 
/*      */ 
/*      */     
/*  404 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  406 */     int registrosParaAgregar = calcularRegistrosParaMultiplo(this.jTable2.getRowCount(), this.multiplo);
/*  407 */     int reg = registrosParaAgregar;
/*  408 */     for (int j = 0; j < reg; j++) {
/*  409 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     }
/*      */     
/*  412 */     sacarListaProductos();
/*  413 */     sacarPrimeroVentasFletes();
/*  414 */     sacarSegundoVentasFletes();
/*  415 */     sacarTerceroVentasFletes();
/*  416 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  417 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  419 */     double sumaClientesDLS = 0.0D;
/*  420 */     ArrayList<String> clientes = obtenerClientesUnicos();
/*  421 */     for (String cliente : clientes) {
/*  422 */       double res = this.utilerias.sumarColumnaTablaSiCondicion(this.jTable2, 4, "IGUAL", cliente, 3);
/*      */       
/*  424 */       sumaClientesDLS += res;
/*  425 */       this.utilerias.agregarCampoTablas(new String[] { "", "", "CLIENTE ", cliente, "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  432 */             .convertirDoublePesos(res), "", "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */     } 
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
/*  446 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "ANTICIPOS ", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  453 */           .convertirDoublePesos(sacarSumaTipoAnticipo()), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  466 */     double complementaria = totMXN - sumaClientesDLS - sacarSumaTipoAnticipo();
/*  467 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "COMPLEMENTARIA", "DLS ", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  474 */           .convertirDoublePesos(complementaria), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  487 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "IVA", "TRASLADADO P/COBRAR", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  495 */           .convertirDoublePesos(ivaMXN), "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  507 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "FLETES", "C/RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  515 */           .convertirDoublePesos(this.FLETESCR), "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  526 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "FLETES", "SIN/RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  534 */           .convertirDoublePesos(this.FLETESSR), "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  546 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTROS", "INGRESOS", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  554 */           .convertirDoublePesos(this.FLETESO), "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  565 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "INGRESOS POR", "VENTA DE ACTIVO FIJO", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  573 */           .convertirDoublePesos(this.INGRESOSACTIVOFIJO), "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  585 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "RETENCIÓN", "DE IVA", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  592 */           .convertirDoublePesos(retMXN), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  604 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*      */ 
/*      */     
/*  623 */     double sumasDLS = subMXN + ivaMXN;
/*  624 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "SUMAS", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  631 */           .convertirDoublePesos(sumasDLS), this.utilerias
/*  632 */           .convertirDoublePesos(sumasDLS), "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  644 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  646 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "****** PRODUCTOS ******", "", "", "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*      */ 
/*      */ 
/*      */     
/*  666 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "| CLAVE |", "| DESCRIPCIÓN |", "| SUB |", "| TRAS ", "| RETENIDO |", "| TOTAL |", "", "", "", "| SUB MXN |", "| TRAS MXN |", "| RETENIDO MXN |", "| TOTAL MXN |" }, this.jTable2);
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
/*      */ 
/*      */ 
/*      */     
/*  686 */     consultarProductosDif();
/*      */ 
/*      */     
/*  689 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  695 */           .convertirDoublePesos(sub), this.utilerias
/*  696 */           .convertirDoublePesos(iva), this.utilerias
/*  697 */           .convertirDoublePesos(ret), this.utilerias
/*  698 */           .convertirDoublePesos(tot), "", "", "", this.utilerias
/*      */           
/*  700 */           .convertirDoublePesos(subMXN), this.utilerias
/*  701 */           .convertirDoublePesos(ivaMXN), this.utilerias
/*  702 */           .convertirDoublePesos(retMXN), this.utilerias
/*  703 */           .convertirDoublePesos(totMXN) }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  708 */     if (this.TablitaSinAfectacion.getRowCount() > 0) {
/*  709 */       insertarFacturasSinAfectaciones();
/*      */     }
/*      */     
/*  712 */     imprimirReportePolizas();
/*      */   }
/*      */   
/*      */   public void insertarFacturasSinAfectaciones() {
/*  716 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  717 */     this.utilerias.agregarCampoTablas(new String[] { "", "*** INF", "DE VENTAS", "SIN AFECTACIONES", " ***", "", "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*      */ 
/*      */ 
/*      */     
/*  737 */     for (int i = 0; i < this.TablitaSinAfectacion.getRowCount(); i++) {
/*  738 */       double dolar = this.utilerias.convertirCantTexto(this.TablitaSinAfectacion.getValueAt(i, 10).toString());
/*  739 */       this.utilerias.agregarCampoTablas(new String[] { "", this.TablitaSinAfectacion
/*      */ 
/*      */             
/*  742 */             .getValueAt(i, 2).toString(), this.utilerias
/*  743 */             .convertirFechaDateStringBarras(this.utilerias.convertirFechaStringADate(this.TablitaSinAfectacion.getValueAt(i, 3).toString())), this.TablitaSinAfectacion
/*  744 */             .getValueAt(i, 4).toString(), this.TablitaSinAfectacion
/*  745 */             .getValueAt(i, 5).toString(), this.TablitaSinAfectacion
/*  746 */             .getValueAt(i, 6).toString(), this.TablitaSinAfectacion
/*  747 */             .getValueAt(i, 7).toString(), this.TablitaSinAfectacion
/*  748 */             .getValueAt(i, 8).toString(), this.TablitaSinAfectacion
/*  749 */             .getValueAt(i, 10).toString(), "", "", this.utilerias
/*      */ 
/*      */             
/*  752 */             .convertirDoublePesos(this.utilerias.convertirCantTexto(this.TablitaSinAfectacion.getValueAt(i, 5).toString()) * dolar), this.utilerias
/*  753 */             .convertirDoublePesos(this.utilerias.convertirCantTexto(this.TablitaSinAfectacion.getValueAt(i, 6).toString()) * dolar), this.utilerias
/*  754 */             .convertirDoublePesos(this.utilerias.convertirCantTexto(this.TablitaSinAfectacion.getValueAt(i, 7).toString()) * dolar), this.utilerias
/*  755 */             .convertirDoublePesos(this.utilerias.convertirCantTexto(this.TablitaSinAfectacion.getValueAt(i, 8).toString()) * dolar) }this.jTable2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int calcularRegistrosParaMultiplo(int registros, int multiplo) {
/*  762 */     int residuo = registros % multiplo;
/*  763 */     return (residuo == 0) ? 0 : (multiplo - residuo);
/*      */   }
/*      */   
/*      */   public ArrayList<String> obtenerClientesUnicos() {
/*  767 */     Set<String> clientesUnicosOrdenados = new TreeSet<>();
/*  768 */     TableModel model = this.jTable1.getModel();
/*      */ 
/*      */     
/*  771 */     int columnaCliente = 4;
/*      */ 
/*      */     
/*  774 */     for (int i = 0; i < model.getRowCount(); i++) {
/*  775 */       String cliente = model.getValueAt(i, columnaCliente).toString();
/*  776 */       clientesUnicosOrdenados.add(cliente);
/*      */     } 
/*      */ 
/*      */     
/*  780 */     return new ArrayList<>(clientesUnicosOrdenados);
/*      */   }
/*      */   
/*      */   public void ordenarColumnas() {
/*  784 */     TableColumnModel columnModel = this.jTable2.getColumnModel();
/*      */     
/*  786 */     columnModel.moveColumn(11, 9);
/*  787 */     columnModel.moveColumn(12, 10);
/*  788 */     columnModel.moveColumn(13, 11);
/*  789 */     columnModel.moveColumn(14, 12);
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarPesos() {
/*  794 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/*  795 */       this.jTable2.setValueAt(this.utilerias
/*  796 */           .convertirDoublePesos(
/*  797 */             multiplicar(this.jTable2
/*  798 */               .getValueAt(i, 4).toString(), this.jTable2
/*  799 */               .getValueAt(i, 8).toString())), i, 11);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  804 */       this.jTable2.setValueAt(this.utilerias
/*  805 */           .convertirDoublePesos(
/*  806 */             multiplicar(this.jTable2
/*  807 */               .getValueAt(i, 5).toString(), this.jTable2
/*  808 */               .getValueAt(i, 8).toString())), i, 12);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  813 */       this.jTable2.setValueAt(this.utilerias
/*  814 */           .convertirDoublePesos(
/*  815 */             multiplicar(this.jTable2
/*  816 */               .getValueAt(i, 6).toString(), this.jTable2
/*  817 */               .getValueAt(i, 8).toString())), i, 13);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  822 */       this.jTable2.setValueAt(this.utilerias
/*  823 */           .convertirDoublePesos(
/*  824 */             multiplicar(this.jTable2
/*  825 */               .getValueAt(i, 7).toString(), this.jTable2
/*  826 */               .getValueAt(i, 8).toString())), i, 14);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double multiplicar(String cant, String cambio) {
/*  834 */     double resul = 0.0D;
/*  835 */     double c1 = this.utilerias.convertirCantTexto(cant);
/*  836 */     double c2 = Double.parseDouble(cambio);
/*  837 */     resul = c1 * c2;
/*      */     
/*  839 */     return resul;
/*      */   }
/*      */   
/*      */   public void agregarColumnasMXN() {
/*  843 */     DefaultTableModel modelo = (DefaultTableModel)this.jTable2.getModel();
/*  844 */     modelo.addColumn("SubMXN");
/*  845 */     modelo.addColumn("IvaMXN");
/*  846 */     modelo.addColumn("RetMXN");
/*  847 */     modelo.addColumn("TotMXN");
/*      */     
/*  849 */     this.jTable2.setModel(modelo);
/*      */   }
/*      */   
/*      */   public double sacarSumaTipoAnticipo() {
/*  853 */     double sum = 0.0D;
/*  854 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/*  855 */       String col = this.jTable1.getValueAt(i, 13).toString();
/*  856 */       if (col.equals("ANTICIPO")) {
/*  857 */         sum += this.utilerias.convertirCantTexto(this.jTable2.getValueAt(i, 4).toString());
/*      */       }
/*      */     } 
/*  860 */     return sum;
/*      */   }
/*      */   
/*      */   public void consultarProductosDif() {
/*  864 */     Map<String, String> CantProdIva = new HashMap<>();
/*  865 */     Map<String, String> CantProdRet = new HashMap<>();
/*  866 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/*  867 */           .buscarDatos(1, "DISTINCT claveproducto", " facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and claveproducto<>'' and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.claveproducto asc"), (Object[])new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  875 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  879 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  883 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/*  884 */       CantProdIva.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*  885 */       CantProdRet.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*      */     } 
/*      */     
/*  888 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/*  889 */           .buscarDatos("claveProducto, tipoImpuesto, totalImpuesto, facturas33.folio, facturas33.fecha ,facturas33.estatus ", "facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.num asc"), (Object[])new String[] { "Clave Prod", "Tipo", "Total", "Factura", "Fecha", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  896 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  900 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  904 */     double valor1 = 0.0D;
/*  905 */     double valor2 = 0.0D;
/*      */     
/*  907 */     double retenidoPrueba = 0.0D;
/*  908 */     for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/*  909 */       if (((String)this.CAMPOSGENERALES.get("sucursal")).equals("POZA RICA") || ((String)this.CAMPOSGENERALES.get("sucursal")).equals("CADEREYTA")) {
/*  910 */         String folio = this.jTable5.getValueAt(j, 3).toString();
/*  911 */         for (int i1 = 0; i1 < this.jTable6.getRowCount(); i1++) {
/*  912 */           String folio2 = this.jTable6.getValueAt(i1, 2).toString();
/*      */ 
/*      */           
/*  915 */           if (folio.equals(folio2) && this.jTable6.getValueAt(i1, 18).equals("USD") && !this.jTable5.getValueAt(j, 2).toString().equals("")) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  925 */       String cod = this.jTable5.getValueAt(j, 0).toString();
/*  926 */       if (!cod.equals("")) {
/*      */         
/*  928 */         String[] dat = regresaTipoImpuesto(j);
/*  929 */         if (dat != null && 
/*  930 */           dat[0].equals("TRASLADO")) {
/*  931 */           double cantAnt = this.utilerias.convertirCantTexto(CantProdIva.get(cod));
/*  932 */           double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  933 */           CantProdIva.put(cod, "" + v2);
/*  934 */           valor1 += this.utilerias.convertirCantTexto(dat[1]);
/*      */         } 
/*      */ 
/*      */         
/*  938 */         if (j < this.jTable5.getRowCount() - 1 && dat != null) {
/*      */           
/*  940 */           dat = regresaTipoImpuesto(j + 1);
/*  941 */           if (dat != null && 
/*  942 */             dat[0].equals("RETENIDO")) {
/*  943 */             double cantAnt = this.utilerias.convertirCantTexto(CantProdRet.get(cod));
/*  944 */             double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  945 */             CantProdRet.put(cod, "" + v2);
/*  946 */             valor2 += this.utilerias.convertirCantTexto(dat[1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  954 */     DefaultTableModel model = (DefaultTableModel)this.jTable4.getModel();
/*  955 */     model.addColumn("Descripcion");
/*  956 */     model.fireTableDataChanged();
/*  957 */     for (int k = 0; k < this.jTable4.getRowCount(); k++) {
/*  958 */       this.con.consultar("descripcion", "catproductos", "where clave = " + String.valueOf(this.jTable4.getValueAt(k, 0)));
/*  959 */       this.jTable4.setValueAt(this.con.Campo, k, 1);
/*      */     } 
/*      */     
/*  962 */     double[] cantidades = new double[this.jTable4.getRowCount()];
/*  963 */     double totalProd = 0.0D;
/*  964 */     for (int m = 0; m < this.jTable4.getRowCount(); m++) {
/*  965 */       String[] cant = this.con.regresaColIndex("importe", "facturas33, conceptosfacturas33", "where claveproducto='" + 
/*      */ 
/*      */           
/*  968 */           String.valueOf(this.jTable4.getValueAt(m, 0)) + "' and folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ")");
/*  969 */       for (int i1 = 0; i1 < cant.length; i1++) {
/*  970 */         cantidades[m] = cantidades[m] + this.utilerias.convertirCantTexto(cant[i1]);
/*  971 */         totalProd += this.utilerias.convertirCantTexto(cant[i1]);
/*      */       } 
/*      */     } 
/*      */     
/*  975 */     convertirProductosPesos();
/*      */     
/*  977 */     double iva = 0.0D;
/*  978 */     double ret = 0.0D;
/*  979 */     double tot = 0.0D;
/*      */     int n;
/*  981 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/*  982 */       String cod = CantProdIva.get(this.jTable4.getValueAt(n, 0).toString());
/*  983 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod)), n, 2);
/*      */       
/*  985 */       String cod2 = CantProdRet.get(this.jTable4.getValueAt(n, 0).toString());
/*  986 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod2)), n, 3);
/*      */     } 
/*      */     
/*  989 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/*  990 */       double suma = cantidades[n] + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 2).toString()) - this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 3).toString());
/*  991 */       double sumaMXN = this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 5).toString()) + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 6).toString()) - this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 7).toString());
/*  992 */       this.utilerias.agregarCampoTablas(new String[] { "", "", this.jTable4
/*      */ 
/*      */ 
/*      */             
/*  996 */             .getValueAt(n, 0).toString(), this.jTable4
/*  997 */             .getValueAt(n, 1).toString(), this.utilerias
/*  998 */             .convertirDoublePesos(cantidades[n]), this.jTable4
/*  999 */             .getValueAt(n, 2).toString(), this.jTable4
/* 1000 */             .getValueAt(n, 3).toString(), this.utilerias
/* 1001 */             .convertirDoublePesos(suma), "", "", "", this.jTable4
/*      */ 
/*      */ 
/*      */             
/* 1005 */             .getValueAt(n, 5).toString(), this.jTable4
/* 1006 */             .getValueAt(n, 6).toString(), this.jTable4
/* 1007 */             .getValueAt(n, 7).toString(), this.utilerias
/* 1008 */             .convertirDoublePesos(sumaMXN) }this.jTable2);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1013 */     insertarRenglonLineas();
/* 1014 */     double totGral = totalProd + iva - ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public void convertirProductosPesos() {
/* 1019 */     Map<String, String> CantProdIva = new HashMap<>();
/* 1020 */     Map<String, String> CantProdRet = new HashMap<>();
/*      */     
/* 1022 */     double valor1 = 0.0D;
/* 1023 */     double valor2 = 0.0D;
/*      */     
/* 1025 */     DefaultTableModel newModel = new DefaultTableModel();
/* 1026 */     DefaultTableModel originalModel = (DefaultTableModel)this.jTable5.getModel(); int i;
/* 1027 */     for (i = 0; i < originalModel.getColumnCount(); i++) {
/* 1028 */       newModel.addColumn(originalModel.getColumnName(i));
/*      */     }
/*      */     
/* 1031 */     for (i = 0; i < originalModel.getRowCount(); i++) {
/* 1032 */       Object[] rowData = new Object[originalModel.getColumnCount()];
/* 1033 */       for (int k = 0; k < originalModel.getColumnCount(); k++) {
/* 1034 */         rowData[k] = originalModel.getValueAt(i, k);
/*      */       }
/* 1036 */       newModel.addRow(rowData);
/*      */     } 
/* 1038 */     this.jTable6.setModel(newModel);
/* 1039 */     for (i = 0; i < this.jTable6.getRowCount(); i++) {
/* 1040 */       String importe = this.jTable6.getValueAt(i, 2).toString();
/* 1041 */       String folio1 = this.jTable6.getValueAt(i, 3).toString();
/*      */       
/* 1043 */       if (!importe.equals("")) {
/* 1044 */         for (int k = 0; k < this.jTable2.getRowCount(); k++) {
/* 1045 */           String folio2 = this.jTable2.getValueAt(k, 1).toString();
/* 1046 */           if (folio1.equals(folio2)) {
/* 1047 */             String tipoCambio = this.jTable2.getValueAt(k, 8).toString();
/* 1048 */             String nuevo = convertirDLSaPESOS(tipoCambio, importe);
/* 1049 */             this.jTable6.setValueAt(nuevo, i, 2);
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/* 1056 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 1057 */       String cod = this.jTable4.getValueAt(i, 0).toString();
/* 1058 */       double suma = this.utilerias.sumarColumnaTablaSiCondicion(this.jTable3, 1, "IGUAL", cod, 0);
/* 1059 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(suma), i, 5);
/*      */     } 
/*      */     
/* 1062 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 1063 */       CantProdIva.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/* 1064 */       CantProdRet.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*      */     } 
/* 1066 */     for (i = 0; i < this.jTable6.getRowCount(); i++) {
/* 1067 */       String cod = this.jTable6.getValueAt(i, 0).toString();
/* 1068 */       if (!cod.equals("")) {
/*      */         
/* 1070 */         String[] dat = regresaTipoImpuesto2(i);
/* 1071 */         if (dat != null && 
/* 1072 */           dat[0].equals("TRASLADO")) {
/* 1073 */           double cantAnt = this.utilerias.convertirCantTexto(CantProdIva.get(cod));
/* 1074 */           double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/* 1075 */           CantProdIva.put(cod, "" + v2);
/* 1076 */           valor1 += this.utilerias.convertirCantTexto(dat[1]);
/*      */         } 
/*      */ 
/*      */         
/* 1080 */         if (i < this.jTable5.getRowCount() - 1 && dat != null) {
/*      */           
/* 1082 */           dat = regresaTipoImpuesto2(i + 1);
/* 1083 */           if (dat != null && 
/* 1084 */             dat[0].equals("RETENIDO")) {
/* 1085 */             double cantAnt = this.utilerias.convertirCantTexto(CantProdRet.get(cod));
/* 1086 */             double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/* 1087 */             CantProdRet.put(cod, "" + v2);
/* 1088 */             valor2 += this.utilerias.convertirCantTexto(dat[1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1096 */     i = 0;
/* 1097 */     for (Map.Entry<String, String> entry : CantProdIva.entrySet()) {
/* 1098 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(entry.getValue())), i, 6);
/* 1099 */       i++;
/*      */     } 
/*      */     
/* 1102 */     i = 0;
/* 1103 */     for (Map.Entry<String, String> entry : CantProdRet.entrySet()) {
/* 1104 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(entry.getValue())), i, 7);
/* 1105 */       i++;
/*      */     } 
/*      */     
/* 1108 */     for (int j = 0; j < this.jTable4.getRowCount(); j++) {
/* 1109 */       double d = this.utilerias.convertirCantTexto(this.jTable4.getValueAt(j, 5).toString()) + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(j, 6).toString());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] regresaTipoImpuesto(int reg) {
/* 1116 */     String[] datos = { "", "" };
/* 1117 */     String cant = "";
/*      */     
/* 1119 */     if (reg < this.jTable5.getRowCount() - 1) {
/* 1120 */       String tipo = this.jTable5.getValueAt(reg + 1, 1).toString();
/*      */       
/* 1122 */       if (!tipo.equals("")) {
/* 1123 */         cant = this.jTable5.getValueAt(reg + 1, 2).toString();
/* 1124 */         datos[0] = tipo;
/* 1125 */         datos[1] = cant;
/*      */       } else {
/*      */         
/* 1128 */         return null;
/*      */       } 
/*      */     } 
/* 1131 */     return datos;
/*      */   }
/*      */   
/*      */   public String[] regresaTipoImpuesto2(int reg) {
/* 1135 */     String[] datos = { "", "" };
/* 1136 */     String cant = "";
/*      */     
/* 1138 */     if (reg < this.jTable6.getRowCount() - 1) {
/* 1139 */       String tipo = this.jTable6.getValueAt(reg + 1, 1).toString();
/*      */       
/* 1141 */       if (!tipo.equals("")) {
/* 1142 */         cant = this.jTable6.getValueAt(reg + 1, 2).toString();
/* 1143 */         datos[0] = tipo;
/* 1144 */         datos[1] = cant;
/*      */       } else {
/* 1146 */         return null;
/*      */       } 
/*      */     } 
/* 1149 */     return datos;
/*      */   }
/*      */   
/*      */   public void insertarRenglonLineas() {
/* 1153 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————" }, this.jTable2);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String convertirDLSaPESOS(String tipoCambio, String montoDLS) {
/* 1175 */     double cambio = this.utilerias.convertirCantTexto(tipoCambio);
/* 1176 */     double monto = this.utilerias.convertirCantTexto(montoDLS);
/* 1177 */     double resultado = cambio * monto;
/*      */     
/* 1179 */     return this.utilerias.convertirDoublePesos(resultado);
/*      */   }
/*      */   
/*      */   public void sacarListaProductos() {
/* 1183 */     String consulta = ""; int i;
/* 1184 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1185 */       consulta = consulta + " conceptosfacturas33.numfactura = '" + consulta + "' ";
/* 1186 */       if (i + 1 < this.LISTAFACTURAS.length) {
/* 1187 */         consulta = consulta + " || ";
/*      */       }
/*      */     } 
/* 1190 */     this.CONSULTARLISTARPRODUCTOS = consulta;
/* 1191 */     this.utilerias.consultaGralTabla(this.con, this.jTable3, new String[] { "clave", "importe", "numFactura" }, "claveproducto, importe, numfactura", "conceptosfacturas33", "where (" + consulta + ") and claveproducto <>'' ");
/*      */     
/* 1193 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 1194 */       String folio = this.jTable3.getValueAt(i, 2).toString();
/* 1195 */       for (int j = 0; j < this.jTable2.getRowCount(); j++) {
/* 1196 */         String folio2 = this.jTable2.getValueAt(j, 1).toString();
/* 1197 */         String tipoCambio = this.jTable2.getValueAt(j, 8).toString();
/* 1198 */         if (folio.equals(folio2)) {
/*      */           
/* 1200 */           String nuevo = convertirDLSaPESOS(tipoCambio, this.jTable3.getValueAt(i, 1).toString());
/* 1201 */           this.jTable3.setValueAt(nuevo, i, 1);
/*      */         } 
/*      */       } 
/*      */     } 
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
/*      */     
/* 1222 */     this.jEditorPane1.setText("select claveproducto, importe, numfactura from  conceptosfacturas33 where (" + consulta + ") and claveproducto <>'' order by numFactura desc");
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarPrimeroVentasFletes() {
/* 1227 */     double fletesRetencion = 0.0D;
/* 1228 */     int cont = 0;
/* 1229 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1230 */       String folio = this.jTable2.getValueAt(i, 1).toString();
/* 1231 */       String iva = this.jTable2.getValueAt(i, 10).toString();
/* 1232 */       String ret = this.jTable2.getValueAt(i, 11).toString();
/* 1233 */       String tipo = this.jTable2.getValueAt(i, 13).toString();
/*      */       
/* 1235 */       if (!iva.equals("$0.00") && !ret.equals("$0.00") && tipo.equals("PM")) {
/* 1236 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 1237 */           String codigo = this.jTable3.getValueAt(j, 0).toString();
/* 1238 */           String fact = this.jTable3.getValueAt(j, 2).toString();
/* 1239 */           if ((fact.equals(folio) && codigo.equals("78101800")) || (fact.equals(folio) && codigo.equals("78101801")) || (fact.equals(folio) && codigo.equals("78101802"))) {
/* 1240 */             cont++;
/*      */             
/* 1242 */             fletesRetencion += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/* 1248 */     this.FLETESCR = fletesRetencion;
/* 1249 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS ", "FLETES C/RETENCIÓN", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1256 */           .convertirDoublePesos(fletesRetencion), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*      */   public void sacarSegundoVentasFletes() {
/* 1271 */     double fletesSinRetencion = 0.0D;
/* 1272 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1273 */       String folio = this.jTable2.getValueAt(i, 1).toString();
/* 1274 */       String iva = this.jTable2.getValueAt(i, 10).toString();
/* 1275 */       String ret = this.jTable2.getValueAt(i, 11).toString();
/*      */ 
/*      */       
/* 1278 */       String cliente = this.jTable2.getValueAt(i, 3).toString();
/*      */       
/* 1280 */       if ((cliente.equals("GSM - BRONCO S. A. DE C. V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1281 */         .equals("DOWELL SCHLUMBERGER DE MEXICO, S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1282 */         .equals("BAKER HUGHES OPERATIONS MEXICO S. DE R.L. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1283 */         .equals("CLEANMEX ENERGY SERVICES S DE RL DE CV") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1284 */         .equals("CAPITAL CARGO DEL GOLFO S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1285 */         .equals("ENERGY DRILLING MARINE SERVICES S.A.P. DE I. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || ret
/*      */         
/* 1287 */         .equals("$0.00")) {
/* 1288 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 1289 */           String codigo = this.jTable3.getValueAt(j, 0).toString();
/* 1290 */           String fact = this.jTable3.getValueAt(j, 2).toString();
/* 1291 */           if (fact.equals(folio) && (codigo.equals("78101800") || codigo.equals("78101801") || codigo.equals("78101802") || codigo.equals("76122401")))
/*      */           {
/* 1293 */             fletesSinRetencion += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
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
/* 1304 */     this.FLETESSR = fletesSinRetencion;
/* 1305 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS ", "FLETES SIN/RETENCIÓN", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1312 */           .convertirDoublePesos(fletesSinRetencion), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*      */   public void sacarTerceroVentasFletes() {
/* 1328 */     this.INGRESOSACTIVOFIJO = 0.0D;
/* 1329 */     for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 1330 */       String codigo = this.jTable3.getValueAt(j, 0).toString();
/* 1331 */       String fact = this.jTable3.getValueAt(j, 2).toString();
/* 1332 */       if (codigo.equals("25101600") || codigo.equals("25101503") || codigo.equals("25101500"))
/*      */       {
/*      */         
/* 1335 */         this.INGRESOSACTIVOFIJO += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1340 */     this.FLETESO = this.FLETESSUB - this.FLETESCR + this.FLETESSR + this.INGRESOSACTIVOFIJO;
/*      */     
/* 1342 */     if (this.FLETESO < 2.0D) {
/* 1343 */       this.FLETESO = 0.0D;
/*      */     }
/*      */     
/* 1346 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTRAS ", "VENTAS", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1353 */           .convertirDoublePesos(this.FLETESO), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/* 1366 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "INRGESOS POR", "VENTA DE ACTIVO FIJO", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1373 */           .convertirDoublePesos(this.INGRESOSACTIVOFIJO), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*      */   public void imprimirReportePolizas() {
/* 1389 */     String cliente = "GENERAL";
/*      */ 
/*      */     
/* 1392 */     formatearTabla();
/*      */     
/* 1394 */     Map<Object, Object> datos = new HashMap<>();
/* 1395 */     this.utilerias.cargarImagenesAReporte(datos);
/* 1396 */     datos.put("sucursal", ((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 1397 */     datos.put("periodo", this.etiquetaFecha);
/* 1398 */     datos.put("cliente", "TODOS");
/* 1399 */     datos.put("estado", "VENTAS");
/* 1400 */     datos.put("titulo", "REPORTE DE PÓLIZAS " + this.MONEDA);
/* 1401 */     datos.put("documento", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/*      */     
/*      */     try {
/* 1404 */       this.utilerias.verImpresion("/Reportes/Facturacion/PolizasPeriodoDLS.jasper", this.jTable2, datos, "REPORTE DE PÓLIZAS " + this.MONEDA);
/* 1405 */     } catch (JRException ex) {
/* 1406 */       Logger.getLogger(Facturas33PeriodoDLS.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String convertirFechaATexto(String fecha) {
/* 1411 */     String fechaCorta = fecha.substring(0, 10);
/* 1412 */     String año = fechaCorta.substring(0, 4);
/* 1413 */     String mes = fechaCorta.substring(5, 7);
/* 1414 */     String dia = fechaCorta.substring(8, 10);
/* 1415 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 1416 */     return strFecha;
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 1420 */     String canti = cant;
/* 1421 */     String valorP = "";
/* 1422 */     for (int j = 0; j < canti.length(); j++) {
/* 1423 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 1424 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 1427 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public void formatearTabla() {
/* 1431 */     for (int i = 0; i < this.jTable2.getRowCount(); i++);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JTable crearTablaAux2(JTable Original, Object[] columnas) {
/* 1485 */     Object[] Columnas = columnas;
/* 1486 */     Object[][] registros = new Object[Original.getRowCount()][columnas.length];
/* 1487 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 1488 */       registros[i][0] = Integer.valueOf(i + 1);
/* 1489 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 1490 */         if (j == 0) {
/* 1491 */           registros[i][0] = Original.getValueAt(i, j);
/*      */         }
/* 1493 */         if (j == 1) {
/* 1494 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 1496 */         if (j == 2) {
/* 1497 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/*      */         
/* 1500 */         if (j == 3) {
/* 1501 */           if (!Original.getValueAt(i, j).toString().equals("")) {
/* 1502 */             registros[i][3] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */           } else {
/* 1504 */             registros[i][3] = "";
/*      */           } 
/*      */         }
/* 1507 */         if (j == 4) {
/*      */           try {
/* 1509 */             registros[i][4] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1510 */           } catch (NumberFormatException e) {
/* 1511 */             registros[i][4] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */         
/* 1515 */         if (j == 5) {
/*      */           try {
/* 1517 */             registros[i][5] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1518 */           } catch (NumberFormatException e) {
/* 1519 */             registros[i][5] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1522 */         if (j == 6) {
/*      */           try {
/* 1524 */             registros[i][6] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1525 */           } catch (NumberFormatException e) {
/* 1526 */             registros[i][6] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1529 */         if (j == 7) {
/*      */           try {
/* 1531 */             registros[i][7] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1532 */           } catch (NumberFormatException e) {
/* 1533 */             registros[i][7] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1536 */         if (j == 8) {
/*      */           try {
/* 1538 */             registros[i][8] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1539 */           } catch (NumberFormatException e) {
/* 1540 */             registros[i][8] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1543 */         if (j == 9) {
/*      */           try {
/* 1545 */             registros[i][9] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1546 */           } catch (NumberFormatException e) {
/* 1547 */             registros[i][9] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1550 */         if (j == 10) {
/*      */           try {
/* 1552 */             registros[i][10] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1553 */           } catch (NumberFormatException e) {
/* 1554 */             registros[i][10] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1559 */     JTable aux = new JTable(registros, Columnas);
/* 1560 */     return aux;
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Facturas33PeriodoDLS.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */