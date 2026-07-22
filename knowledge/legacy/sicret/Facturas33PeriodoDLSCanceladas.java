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
/*      */ public class Facturas33PeriodoDLSCanceladas
/*      */   extends JDialog {
/*   32 */   Consultas2 con = new Consultas2();
/*   33 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   34 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
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
/*   46 */   double INGRESOSACTIVOFIJO = 0.0D;
/*   47 */   String CONSULTARLISTARPRODUCTOS = "";
/*      */   Map<String, String> CAMPOSGENERALES;
/*   49 */   int multiplo = 28; JComboBox MES; JComboBox AÑO; JTable TablitaSinAfectacion; private JEditorPane jEditorPane1;
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel2;
/*   52 */   String etiquetaFecha = ""; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3;
/*      */   private JScrollPane jScrollPane4;
/*      */   
/*      */   public Facturas33PeriodoDLSCanceladas(Map<String, String> CAMPOSGENERALES, Consultas2 con, Date fecha1, Date fecha2, String MONEDA, String TIPO, JComboBox MES, JComboBox AÑO) {
/*   56 */     initComponents();
/*   57 */     System.out.println("*** CANCELADAS DLS **** ");
/*   58 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   59 */     this.con = con;
/*   60 */     this.fecha1 = fecha1;
/*   61 */     this.fecha2 = fecha2;
/*   62 */     this.MONEDA = MONEDA;
/*   63 */     this.TIPO = TIPO;
/*   64 */     this.MES = MES;
/*   65 */     this.AÑO = AÑO;
/*      */     
/*   67 */     this.utilerias.vaciarTabla(this.jTable1);
/*   68 */     this.utilerias.vaciarTabla(this.jTable2);
/*   69 */     this.utilerias.vaciarTabla(this.jTable3);
/*   70 */     this.utilerias.vaciarTabla(this.jTable4);
/*   71 */     this.utilerias.vaciarTabla(this.jTable5);
/*   72 */     this.utilerias.vaciarTabla(this.jTable6);
/*   73 */     consultarFacturasGral();
/*      */     
/*   75 */     this.jLabel2.setText("Lineas en jTable2: " + this.jTable2.getRowCount());
/*      */   }
/*      */   private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JTable jTable1; private JTable jTable2; private JTable jTable3;
/*      */   private JTable jTable4;
/*      */   private JTable jTable5;
/*      */   private JTable jTable6;
/*      */   
/*      */   private void initComponents() {
/*   83 */     this.jScrollPane1 = new JScrollPane();
/*   84 */     this.jTable1 = new JTable();
/*   85 */     this.jScrollPane2 = new JScrollPane();
/*   86 */     this.jTable2 = new JTable();
/*   87 */     this.jScrollPane3 = new JScrollPane();
/*   88 */     this.jTable3 = new JTable();
/*   89 */     this.jScrollPane4 = new JScrollPane();
/*   90 */     this.jEditorPane1 = new JEditorPane();
/*   91 */     this.jLabel1 = new JLabel();
/*   92 */     this.jScrollPane5 = new JScrollPane();
/*   93 */     this.jTable4 = new JTable();
/*   94 */     this.jScrollPane6 = new JScrollPane();
/*   95 */     this.jTable5 = new JTable();
/*   96 */     this.jScrollPane7 = new JScrollPane();
/*   97 */     this.jTable6 = new JTable();
/*   98 */     this.jLabel2 = new JLabel();
/*      */     
/*  100 */     setDefaultCloseOperation(2);
/*      */     
/*  102 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  113 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  115 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  126 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/*  128 */     this.jTable3.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  139 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/*  141 */     this.jScrollPane4.setViewportView(this.jEditorPane1);
/*      */     
/*  143 */     this.jLabel1.setText("Total de datos:");
/*      */     
/*  145 */     this.jTable4.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  156 */     this.jScrollPane5.setViewportView(this.jTable4);
/*      */     
/*  158 */     this.jTable5.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  169 */     this.jScrollPane6.setViewportView(this.jTable5);
/*      */     
/*  171 */     this.jTable6.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  182 */     this.jScrollPane7.setViewportView(this.jTable6);
/*      */     
/*  184 */     this.jLabel2.setText("Total de datos:");
/*      */     
/*  186 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  187 */     getContentPane().setLayout(layout);
/*  188 */     layout.setHorizontalGroup(layout
/*  189 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  190 */         .addComponent(this.jScrollPane1)
/*  191 */         .addComponent(this.jScrollPane5, -1, 1167, 32767)
/*  192 */         .addComponent(this.jScrollPane6, -1, 1167, 32767)
/*  193 */         .addGroup(layout.createSequentialGroup()
/*  194 */           .addContainerGap()
/*  195 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  196 */             .addGroup(layout.createSequentialGroup()
/*  197 */               .addComponent(this.jLabel1, -2, 397, -2)
/*  198 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  199 */               .addComponent(this.jLabel2, -2, 397, -2))
/*  200 */             .addComponent(this.jScrollPane4, -2, 0, 32767))
/*  201 */           .addContainerGap())
/*  202 */         .addComponent(this.jScrollPane3)
/*  203 */         .addComponent(this.jScrollPane7, -1, 1167, 32767)
/*  204 */         .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING));
/*      */     
/*  206 */     layout.setVerticalGroup(layout
/*  207 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  208 */         .addGroup(layout.createSequentialGroup()
/*  209 */           .addContainerGap()
/*  210 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  211 */             .addComponent(this.jLabel1)
/*  212 */             .addComponent(this.jLabel2))
/*  213 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  214 */           .addComponent(this.jScrollPane1, -2, 100, -2)
/*  215 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  216 */           .addComponent(this.jScrollPane2, -2, 126, -2)
/*  217 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  218 */           .addComponent(this.jScrollPane3, -2, 153, -2)
/*  219 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  220 */           .addComponent(this.jScrollPane5, -2, 100, -2)
/*  221 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  222 */           .addComponent(this.jScrollPane6, -2, 88, -2)
/*  223 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  224 */           .addComponent(this.jScrollPane7, -1, 136, 32767)
/*  225 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  226 */           .addComponent(this.jScrollPane4, -2, 81, -2)
/*  227 */           .addContainerGap()));
/*      */ 
/*      */     
/*  230 */     pack();
/*      */   }
/*      */   
/*      */   public void consultarFacturasGral() {
/*  234 */     String fechaCompleta1 = "";
/*  235 */     String fechaCompleta2 = "";
/*  236 */     String consultaFecha = "";
/*  237 */     if (this.MES.getSelectedIndex() != 0) {
/*  238 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*      */       
/*  240 */       int aa = Integer.parseInt(this.AÑO.getSelectedItem().toString());
/*  241 */       consultaFecha = " and  date_format( fechaCancelacion, '%m-%Y') = '" + mes[this.MES.getSelectedIndex()] + "-" + aa + "' ";
/*  242 */       this.etiquetaFecha = this.MES.getSelectedItem().toString() + "/" + this.MES.getSelectedItem().toString();
/*      */     } else {
/*  244 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  245 */       String cadenaFecha = "";
/*  246 */       cadenaFecha = formato.format(this.fecha1);
/*  247 */       String AÑO = cadenaFecha.substring(0, 4);
/*  248 */       String MES = cadenaFecha.substring(4, 6);
/*  249 */       String DIA = cadenaFecha.substring(6, 8);
/*  250 */       fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*  251 */       this.etiquetaFecha = DIA + "/" + DIA + "/" + MES;
/*  252 */       cadenaFecha = formato.format(this.fecha2);
/*      */ 
/*      */ 
/*      */       
/*  256 */       String aa = cadenaFecha.substring(0, 4);
/*  257 */       String mm = cadenaFecha.substring(4, 6);
/*  258 */       String dd = cadenaFecha.substring(6, 8);
/*  259 */       this.etiquetaFecha = this.etiquetaFecha + " AL " + this.etiquetaFecha + "/" + dd + "/" + mm;
/*  260 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/*  261 */       consultaFecha = " and fechaCancelacion between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     } 
/*  263 */     System.out.println("Periodo " + String.valueOf(this.MES.getSelectedItem()));
/*      */     
/*  265 */     this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Núm", "Tipo", "Folio", "Fecha", "Cliente", "Subtotal", "Iva", "Retención", "Total", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo", "tipoCambio", "TipoCambioReal" }, "numFactura,tipo,folio,fecha,cliente,subtotal,iva,retencion,total, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura, tipoCambio, tipoCambioReal", "facturas33, polizascanceladas", "WHERE facturas33.folio = polizascanceladas.folioInterno and tipo = '" + this.TIPO + "' and  moneda = '" + this.MONEDA + "'" + consultaFecha + " and estatus not like '%intercance%'");
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
/*  276 */     Facturas33CanceladasInternas canceladasInternas = new Facturas33CanceladasInternas(this.con, new String[] { "Núm", "Tipo", "Folio", "Fecha", "Cliente", "Subtotal", "Iva", "Retención", "Total", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo", "tipoCambio", "TipoCambioReal" }, "numFactura,tipo,folio,fecha,cliente,subtotal,iva,retencion,total, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura, tipoCambio, tipoCambioReal", "facturas33, polizascanceladas", "WHERE facturas33.folio = polizascanceladas.folioInterno and tipo = '" + this.TIPO + "' and  moneda = '" + this.MONEDA + "'" + consultaFecha + " and estatus like '%intercance%'");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  284 */     this.TablitaSinAfectacion = canceladasInternas.regresaTabla();
/*      */     
/*  286 */     this.jLabel1.setText("Total de datos: " + this.jTable1.getRowCount());
/*  287 */     DefaultTableModel model = (DefaultTableModel)this.jTable1.getModel();
/*  288 */     model.addColumn("tipoCambioActualizado"); int i;
/*  289 */     for (i = 0; i < model.getRowCount(); i++) {
/*  290 */       model.setValueAt(Integer.valueOf(i + 1), i, 0);
/*      */       
/*  292 */       String tipoCambio = model.getValueAt(i, 10).toString();
/*  293 */       String tipoCambioReal = model.getValueAt(i, 15).toString();
/*      */       
/*  295 */       if (!tipoCambioReal.equals("")) {
/*  296 */         model.setValueAt(tipoCambioReal, i, 16);
/*      */       } else {
/*  298 */         model.setValueAt(tipoCambio, i, 16);
/*      */       } 
/*      */     } 
/*      */     
/*  302 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Folio", "Fecha", "Cliente", "Sub", "Iva", "Ret", "Tot", "Cambio", "Tipo", "Met" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  309 */     this.utilerias.vaciarTabla(this.jTable3);
/*  310 */     this.LISTAFACTURAS = new String[this.jTable1.getRowCount()];
/*      */     
/*  312 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/*  313 */       String persona = this.jTable1.getValueAt(i, 11).toString();
/*  314 */       if (persona.equals("PERSONA_FISICA")) {
/*  315 */         persona = "PF";
/*  316 */       } else if (persona.equals("PERSONA_MORAL")) {
/*  317 */         persona = "PM";
/*  318 */       } else if (persona.equals("EXTRANJERO")) {
/*  319 */         persona = "EXT";
/*      */       } else {
/*  321 */         persona = "INV";
/*      */       } 
/*  323 */       this.utilerias.agregarCampoTablas(new String[] { this.jTable1
/*      */             
/*  325 */             .getValueAt(i, 0).toString(), this.jTable1
/*  326 */             .getValueAt(i, 2).toString(), 
/*      */             
/*  328 */             convertirFechaATexto(this.jTable1.getValueAt(i, 3).toString()), this.jTable1
/*  329 */             .getValueAt(i, 4).toString(), this.jTable1
/*  330 */             .getValueAt(i, 5).toString(), this.jTable1
/*  331 */             .getValueAt(i, 6).toString(), this.jTable1
/*  332 */             .getValueAt(i, 7).toString(), this.jTable1
/*  333 */             .getValueAt(i, 8).toString(), this.jTable1
/*  334 */             .getValueAt(i, 10).toString(), persona, this.jTable1
/*      */             
/*  336 */             .getValueAt(i, 12).toString().substring(0, 3), this.jTable1
/*  337 */             .getValueAt(i, 16).toString() }this.jTable2);
/*      */ 
/*      */       
/*  340 */       this.LISTAFACTURAS[i] = this.jTable1.getValueAt(i, 2).toString();
/*      */     } 
/*      */     
/*  343 */     agregarColumnasMXN();
/*  344 */     llenarPesos();
/*  345 */     ordenarColumnas();
/*      */     
/*  347 */     double sub = this.utilerias.sumarColumnaTabla(this.jTable2, 4);
/*  348 */     double iva = this.utilerias.sumarColumnaTabla(this.jTable2, 5);
/*  349 */     double ret = this.utilerias.sumarColumnaTabla(this.jTable2, 6);
/*  350 */     double tot = this.utilerias.sumarColumnaTabla(this.jTable2, 7);
/*      */     
/*  352 */     double subMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 9);
/*  353 */     double ivaMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 10);
/*  354 */     double retMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 11);
/*  355 */     double totMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 12);
/*      */     
/*  357 */     if (this.jTable2.getRowCount() > 0) {
/*  358 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  359 */       this.utilerias.agregarCampoTablas(new String[] { "", "", "", 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  365 */             String.valueOf(this.jTable2.getValueAt(0, 1)) + " / " + String.valueOf(this.jTable2.getValueAt(0, 1)), "", "", "", "", "", "", "", "", "", "", "" }this.jTable2);
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
/*  378 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     } 
/*  380 */     insertarRenglonLineas();
/*  381 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  387 */           .convertirDoublePesos(sub), this.utilerias
/*  388 */           .convertirDoublePesos(iva), this.utilerias
/*  389 */           .convertirDoublePesos(ret), this.utilerias
/*  390 */           .convertirDoublePesos(tot), "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */           
/*  394 */           .convertirDoublePesos(subMXN), this.utilerias
/*  395 */           .convertirDoublePesos(ivaMXN), this.utilerias
/*  396 */           .convertirDoublePesos(retMXN), this.utilerias
/*  397 */           .convertirDoublePesos(totMXN) }, this.jTable2);
/*      */ 
/*      */ 
/*      */     
/*  401 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  403 */     int registrosParaAgregar = calcularRegistrosParaMultiplo(this.jTable2.getRowCount(), this.multiplo);
/*  404 */     int reg = registrosParaAgregar;
/*  405 */     for (int j = 0; j < reg; j++) {
/*  406 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     }
/*      */     
/*  409 */     if (this.jTable1.getRowCount() < 1) {
/*  410 */       JOptionPane.showMessageDialog(this, "No existen datos en ese periodo seleccionado", "No hay datos", 0, this.ADVER);
/*      */       
/*      */       return;
/*      */     } 
/*  414 */     sacarListaProductos();
/*  415 */     sacarPrimeroVentasFletes();
/*  416 */     sacarSegundoVentasFletes();
/*  417 */     sacarTerceroVentasFletes();
/*  418 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  419 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  421 */     double sumaClientesDLS = 0.0D;
/*  422 */     ArrayList<String> clientes = obtenerClientesUnicos();
/*  423 */     for (String cliente : clientes) {
/*  424 */       double res = this.utilerias.sumarColumnaTablaSiCondicion(this.jTable2, 4, "IGUAL", cliente, 3);
/*  425 */       sumaClientesDLS += res;
/*  426 */       this.utilerias.agregarCampoTablas(new String[] { "", "", "CLIENTE ", cliente, "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  434 */             .convertirDoublePesos(res), "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  447 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "ANTICIPOS ", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  455 */           .convertirDoublePesos(sacarSumaTipoAnticipo()), "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  467 */     double complementaria = totMXN - sumaClientesDLS;
/*  468 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "COMPLEMENTARIA", "DLS ", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  476 */           .convertirDoublePesos(complementaria), "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  507 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "IVA", "TRASLADADO P/COBRAR", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  514 */           .convertirDoublePesos(ivaMXN), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  527 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "FLETES", "C/RETENCIÓN", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  534 */           .convertirDoublePesos(this.FLETESCR), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  546 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "FLETES", "SIN/RETENCIÓN", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  553 */           .convertirDoublePesos(this.FLETESSR), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  566 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTROS", "INGRESOS", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  573 */           .convertirDoublePesos(this.FLETESO), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  585 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "INGRESOS POR", "VENTA DE ACTIVO FIJO", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  592 */           .convertirDoublePesos(this.INGRESOSACTIVOFIJO), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  605 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "RETENCIÓN", "DE IVA", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  613 */           .convertirDoublePesos(retMXN), "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  624 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  643 */     double sumasDLS = subMXN + ivaMXN;
/*  644 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "SUMAS", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  651 */           .convertirDoublePesos(sumasDLS), this.utilerias
/*  652 */           .convertirDoublePesos(sumasDLS), "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  664 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  665 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  666 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "****** PRODUCTOS ******", "", "", "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  686 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "| CLAVE |", "| DESCRIPCIÓN |", "| SUB |", "| TRAS ", "| RETENIDO |", "| TOTAL |", "", "", "", "| SUB MXN |", "| TRAS MXN |", "| RETENIDO MXN |", "| TOTAL MXN |" }, this.jTable2);
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
/*  706 */     consultarProductosDif();
/*      */ 
/*      */     
/*  709 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  715 */           .convertirDoublePesos(sub), this.utilerias
/*  716 */           .convertirDoublePesos(iva), this.utilerias
/*  717 */           .convertirDoublePesos(ret), this.utilerias
/*  718 */           .convertirDoublePesos(tot), "", "", "", this.utilerias
/*      */           
/*  720 */           .convertirDoublePesos(subMXN), this.utilerias
/*  721 */           .convertirDoublePesos(ivaMXN), this.utilerias
/*  722 */           .convertirDoublePesos(retMXN), this.utilerias
/*  723 */           .convertirDoublePesos(totMXN) }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  728 */     if (this.TablitaSinAfectacion.getRowCount() > 0) {
/*  729 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  730 */       this.utilerias.agregarCampoTablas(new String[] { "", "*** INF", "DE VENTAS", "SIN AFECTACIONES", " ***", "", "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*  750 */       for (int k = 0; k < this.TablitaSinAfectacion.getRowCount(); k++) {
/*  751 */         double dolar = this.utilerias.convertirCantTexto(this.TablitaSinAfectacion.getValueAt(k, 10).toString());
/*  752 */         this.utilerias.agregarCampoTablas(new String[] { "", this.TablitaSinAfectacion
/*      */ 
/*      */               
/*  755 */               .getValueAt(k, 2).toString(), this.utilerias
/*  756 */               .convertirFechaDateStringBarras(this.utilerias.convertirFechaStringADate(this.TablitaSinAfectacion.getValueAt(k, 3).toString())), this.TablitaSinAfectacion
/*  757 */               .getValueAt(k, 4).toString(), this.TablitaSinAfectacion
/*  758 */               .getValueAt(k, 5).toString(), this.TablitaSinAfectacion
/*  759 */               .getValueAt(k, 6).toString(), this.TablitaSinAfectacion
/*  760 */               .getValueAt(k, 7).toString(), this.TablitaSinAfectacion
/*  761 */               .getValueAt(k, 8).toString(), this.TablitaSinAfectacion
/*  762 */               .getValueAt(k, 10).toString(), "", "", this.utilerias
/*      */ 
/*      */               
/*  765 */               .convertirDoublePesos(this.utilerias.convertirCantTexto(this.TablitaSinAfectacion.getValueAt(k, 5).toString()) * dolar), this.utilerias
/*  766 */               .convertirDoublePesos(this.utilerias.convertirCantTexto(this.TablitaSinAfectacion.getValueAt(k, 6).toString()) * dolar), this.utilerias
/*  767 */               .convertirDoublePesos(this.utilerias.convertirCantTexto(this.TablitaSinAfectacion.getValueAt(k, 7).toString()) * dolar), this.utilerias
/*  768 */               .convertirDoublePesos(this.utilerias.convertirCantTexto(this.TablitaSinAfectacion.getValueAt(k, 8).toString()) * dolar) }this.jTable2);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  775 */     imprimirReportePolizas();
/*      */   }
/*      */ 
/*      */   
/*      */   public static int calcularRegistrosParaMultiplo(int registros, int multiplo) {
/*  780 */     int residuo = registros % multiplo;
/*  781 */     return (residuo == 0) ? 0 : (multiplo - residuo);
/*      */   }
/*      */   
/*      */   public ArrayList<String> obtenerClientesUnicos() {
/*  785 */     Set<String> clientesUnicosOrdenados = new TreeSet<>();
/*  786 */     TableModel model = this.jTable1.getModel();
/*      */ 
/*      */     
/*  789 */     int columnaCliente = 4;
/*      */ 
/*      */     
/*  792 */     for (int i = 0; i < model.getRowCount(); i++) {
/*  793 */       String cliente = model.getValueAt(i, columnaCliente).toString();
/*  794 */       clientesUnicosOrdenados.add(cliente);
/*      */     } 
/*      */ 
/*      */     
/*  798 */     return new ArrayList<>(clientesUnicosOrdenados);
/*      */   }
/*      */   
/*      */   public void ordenarColumnas() {
/*  802 */     TableColumnModel columnModel = this.jTable2.getColumnModel();
/*      */     
/*  804 */     columnModel.moveColumn(11, 9);
/*  805 */     columnModel.moveColumn(12, 10);
/*  806 */     columnModel.moveColumn(13, 11);
/*  807 */     columnModel.moveColumn(14, 12);
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarPesos() {
/*  812 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/*  813 */       this.jTable2.setValueAt(this.utilerias
/*  814 */           .convertirDoublePesos(
/*  815 */             multiplicar(this.jTable2
/*  816 */               .getValueAt(i, 4).toString(), this.jTable2
/*  817 */               .getValueAt(i, 8).toString())), i, 11);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  822 */       this.jTable2.setValueAt(this.utilerias
/*  823 */           .convertirDoublePesos(
/*  824 */             multiplicar(this.jTable2
/*  825 */               .getValueAt(i, 5).toString(), this.jTable2
/*  826 */               .getValueAt(i, 8).toString())), i, 12);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  831 */       this.jTable2.setValueAt(this.utilerias
/*  832 */           .convertirDoublePesos(
/*  833 */             multiplicar(this.jTable2
/*  834 */               .getValueAt(i, 6).toString(), this.jTable2
/*  835 */               .getValueAt(i, 8).toString())), i, 13);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  840 */       this.jTable2.setValueAt(this.utilerias
/*  841 */           .convertirDoublePesos(
/*  842 */             multiplicar(this.jTable2
/*  843 */               .getValueAt(i, 7).toString(), this.jTable2
/*  844 */               .getValueAt(i, 8).toString())), i, 14);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double multiplicar(String cant, String cambio) {
/*  852 */     double resul = 0.0D;
/*  853 */     double c1 = this.utilerias.convertirCantTexto(cant);
/*  854 */     double c2 = Double.parseDouble(cambio);
/*  855 */     resul = c1 * c2;
/*      */     
/*  857 */     return resul;
/*      */   }
/*      */   
/*      */   public void agregarColumnasMXN() {
/*  861 */     DefaultTableModel modelo = (DefaultTableModel)this.jTable2.getModel();
/*  862 */     modelo.addColumn("SubMXN");
/*  863 */     modelo.addColumn("IvaMXN");
/*  864 */     modelo.addColumn("RetMXN");
/*  865 */     modelo.addColumn("TotMXN");
/*      */     
/*  867 */     this.jTable2.setModel(modelo);
/*      */   }
/*      */   
/*      */   public double sacarSumaTipoAnticipo() {
/*  871 */     double sum = 0.0D;
/*  872 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/*  873 */       String col = this.jTable1.getValueAt(i, 13).toString();
/*  874 */       if (col.equals("ANTICIPO")) {
/*  875 */         sum += this.utilerias.convertirCantTexto(this.jTable2.getValueAt(i, 4).toString());
/*      */       }
/*      */     } 
/*  878 */     return sum;
/*      */   }
/*      */   
/*      */   public void consultarProductosDif() {
/*  882 */     Map<String, String> CantProdIva = new HashMap<>();
/*  883 */     Map<String, String> CantProdRet = new HashMap<>();
/*  884 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/*  885 */           .buscarDatos(1, "DISTINCT claveproducto", " facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and claveproducto<>'' and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.claveproducto asc"), (Object[])new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  893 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  897 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  901 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/*  902 */       CantProdIva.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*  903 */       CantProdRet.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*      */     } 
/*      */     
/*  906 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/*  907 */           .buscarDatos("claveProducto, tipoImpuesto, totalImpuesto, facturas33.folio, facturas33.fecha ,facturas33.estatus ", "facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.num asc"), (Object[])new String[] { "Clave Prod", "Tipo", "Total", "Factura", "Fecha", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  914 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  918 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  922 */     double valor1 = 0.0D;
/*  923 */     double valor2 = 0.0D;
/*      */     
/*  925 */     double retenidoPrueba = 0.0D;
/*  926 */     for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/*  927 */       if (((String)this.CAMPOSGENERALES.get("sucursal")).equals("POZA RICA") || ((String)this.CAMPOSGENERALES.get("sucursal")).equals("CADEREYTA")) {
/*  928 */         String folio = this.jTable5.getValueAt(j, 3).toString();
/*  929 */         for (int i1 = 0; i1 < this.jTable6.getRowCount(); i1++) {
/*  930 */           String folio2 = this.jTable6.getValueAt(i1, 2).toString();
/*      */ 
/*      */           
/*  933 */           if (folio.equals(folio2) && this.jTable6.getValueAt(i1, 18).equals("USD") && !this.jTable5.getValueAt(j, 2).toString().equals("")) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  943 */       String cod = this.jTable5.getValueAt(j, 0).toString();
/*  944 */       if (!cod.equals("")) {
/*      */         
/*  946 */         String[] dat = regresaTipoImpuesto(j);
/*  947 */         if (dat != null && 
/*  948 */           dat[0].equals("TRASLADO")) {
/*  949 */           double cantAnt = this.utilerias.convertirCantTexto(CantProdIva.get(cod));
/*  950 */           double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  951 */           CantProdIva.put(cod, "" + v2);
/*  952 */           valor1 += this.utilerias.convertirCantTexto(dat[1]);
/*      */         } 
/*      */ 
/*      */         
/*  956 */         if (j < this.jTable5.getRowCount() - 1 && dat != null) {
/*      */           
/*  958 */           dat = regresaTipoImpuesto(j + 1);
/*  959 */           if (dat != null && 
/*  960 */             dat[0].equals("RETENIDO")) {
/*  961 */             double cantAnt = this.utilerias.convertirCantTexto(CantProdRet.get(cod));
/*  962 */             double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  963 */             CantProdRet.put(cod, "" + v2);
/*  964 */             valor2 += this.utilerias.convertirCantTexto(dat[1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  972 */     DefaultTableModel model = (DefaultTableModel)this.jTable4.getModel();
/*  973 */     model.addColumn("Descripcion");
/*  974 */     model.fireTableDataChanged();
/*  975 */     for (int k = 0; k < this.jTable4.getRowCount(); k++) {
/*  976 */       this.con.consultar("descripcion", "catproductos", "where clave = " + String.valueOf(this.jTable4.getValueAt(k, 0)));
/*  977 */       this.jTable4.setValueAt(this.con.Campo, k, 1);
/*      */     } 
/*      */     
/*  980 */     double[] cantidades = new double[this.jTable4.getRowCount()];
/*  981 */     double totalProd = 0.0D;
/*  982 */     for (int m = 0; m < this.jTable4.getRowCount(); m++) {
/*  983 */       String[] cant = this.con.regresaColIndex("importe", "facturas33, conceptosfacturas33", "where claveproducto='" + 
/*      */ 
/*      */           
/*  986 */           String.valueOf(this.jTable4.getValueAt(m, 0)) + "' and folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ")");
/*  987 */       for (int i1 = 0; i1 < cant.length; i1++) {
/*  988 */         cantidades[m] = cantidades[m] + this.utilerias.convertirCantTexto(cant[i1]);
/*  989 */         totalProd += this.utilerias.convertirCantTexto(cant[i1]);
/*      */       } 
/*      */     } 
/*      */     
/*  993 */     convertirProductosPesos();
/*      */     
/*  995 */     double iva = 0.0D;
/*  996 */     double ret = 0.0D;
/*  997 */     double tot = 0.0D;
/*      */     int n;
/*  999 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/* 1000 */       String cod = CantProdIva.get(this.jTable4.getValueAt(n, 0).toString());
/* 1001 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod)), n, 2);
/*      */       
/* 1003 */       String cod2 = CantProdRet.get(this.jTable4.getValueAt(n, 0).toString());
/* 1004 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod2)), n, 3);
/*      */     } 
/*      */     
/* 1007 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/* 1008 */       double suma = cantidades[n] + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 2).toString()) - this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 3).toString());
/* 1009 */       double sumaMXN = this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 5).toString()) + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 6).toString()) - this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 7).toString());
/* 1010 */       this.utilerias.agregarCampoTablas(new String[] { "", "", this.jTable4
/*      */ 
/*      */ 
/*      */             
/* 1014 */             .getValueAt(n, 0).toString(), this.jTable4
/* 1015 */             .getValueAt(n, 1).toString(), this.utilerias
/* 1016 */             .convertirDoublePesos(cantidades[n]), this.jTable4
/* 1017 */             .getValueAt(n, 2).toString(), this.jTable4
/* 1018 */             .getValueAt(n, 3).toString(), this.utilerias
/* 1019 */             .convertirDoublePesos(suma), "", "", "", this.jTable4
/*      */ 
/*      */ 
/*      */             
/* 1023 */             .getValueAt(n, 5).toString(), this.jTable4
/* 1024 */             .getValueAt(n, 6).toString(), this.jTable4
/* 1025 */             .getValueAt(n, 7).toString(), this.utilerias
/* 1026 */             .convertirDoublePesos(sumaMXN) }this.jTable2);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1031 */     insertarRenglonLineas();
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
/* 1048 */     double totGral = totalProd + iva - ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public void convertirProductosPesos() {
/* 1053 */     Map<String, String> CantProdIva = new HashMap<>();
/* 1054 */     Map<String, String> CantProdRet = new HashMap<>();
/*      */     
/* 1056 */     double valor1 = 0.0D;
/* 1057 */     double valor2 = 0.0D;
/*      */     
/* 1059 */     DefaultTableModel newModel = new DefaultTableModel();
/* 1060 */     DefaultTableModel originalModel = (DefaultTableModel)this.jTable5.getModel(); int i;
/* 1061 */     for (i = 0; i < originalModel.getColumnCount(); i++) {
/* 1062 */       newModel.addColumn(originalModel.getColumnName(i));
/*      */     }
/*      */     
/* 1065 */     for (i = 0; i < originalModel.getRowCount(); i++) {
/* 1066 */       Object[] rowData = new Object[originalModel.getColumnCount()];
/* 1067 */       for (int k = 0; k < originalModel.getColumnCount(); k++) {
/* 1068 */         rowData[k] = originalModel.getValueAt(i, k);
/*      */       }
/* 1070 */       newModel.addRow(rowData);
/*      */     } 
/* 1072 */     this.jTable6.setModel(newModel);
/* 1073 */     for (i = 0; i < this.jTable6.getRowCount(); i++) {
/* 1074 */       String importe = this.jTable6.getValueAt(i, 2).toString();
/* 1075 */       String folio1 = this.jTable6.getValueAt(i, 3).toString();
/*      */       
/* 1077 */       if (!importe.equals("")) {
/* 1078 */         for (int k = 0; k < this.jTable2.getRowCount(); k++) {
/* 1079 */           String folio2 = this.jTable2.getValueAt(k, 1).toString();
/* 1080 */           if (folio1.equals(folio2)) {
/* 1081 */             String tipoCambio = this.jTable2.getValueAt(k, 8).toString();
/* 1082 */             String nuevo = convertirDLSaPESOS(tipoCambio, importe);
/* 1083 */             this.jTable6.setValueAt(nuevo, i, 2);
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/* 1090 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 1091 */       String cod = this.jTable4.getValueAt(i, 0).toString();
/* 1092 */       double suma = this.utilerias.sumarColumnaTablaSiCondicion(this.jTable3, 1, "IGUAL", cod, 0);
/* 1093 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(suma), i, 5);
/*      */     } 
/*      */     
/* 1096 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 1097 */       CantProdIva.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/* 1098 */       CantProdRet.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*      */     } 
/* 1100 */     for (i = 0; i < this.jTable6.getRowCount(); i++) {
/* 1101 */       String cod = this.jTable6.getValueAt(i, 0).toString();
/* 1102 */       if (!cod.equals("")) {
/*      */         
/* 1104 */         String[] dat = regresaTipoImpuesto2(i);
/* 1105 */         if (dat != null && 
/* 1106 */           dat[0].equals("TRASLADO")) {
/* 1107 */           double cantAnt = this.utilerias.convertirCantTexto(CantProdIva.get(cod));
/* 1108 */           double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/* 1109 */           CantProdIva.put(cod, "" + v2);
/* 1110 */           valor1 += this.utilerias.convertirCantTexto(dat[1]);
/*      */         } 
/*      */ 
/*      */         
/* 1114 */         if (i < this.jTable5.getRowCount() - 1 && dat != null) {
/*      */           
/* 1116 */           dat = regresaTipoImpuesto2(i + 1);
/* 1117 */           if (dat != null && 
/* 1118 */             dat[0].equals("RETENIDO")) {
/* 1119 */             double cantAnt = this.utilerias.convertirCantTexto(CantProdRet.get(cod));
/* 1120 */             double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/* 1121 */             CantProdRet.put(cod, "" + v2);
/* 1122 */             valor2 += this.utilerias.convertirCantTexto(dat[1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1130 */     i = 0;
/* 1131 */     for (Map.Entry<String, String> entry : CantProdIva.entrySet()) {
/* 1132 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(entry.getValue())), i, 6);
/* 1133 */       i++;
/*      */     } 
/*      */     
/* 1136 */     i = 0;
/* 1137 */     for (Map.Entry<String, String> entry : CantProdRet.entrySet()) {
/* 1138 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(entry.getValue())), i, 7);
/* 1139 */       i++;
/*      */     } 
/*      */     
/* 1142 */     for (int j = 0; j < this.jTable4.getRowCount(); j++) {
/* 1143 */       double d = this.utilerias.convertirCantTexto(this.jTable4.getValueAt(j, 5).toString()) + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(j, 6).toString());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] regresaTipoImpuesto(int reg) {
/* 1150 */     String[] datos = { "", "" };
/* 1151 */     String cant = "";
/*      */     
/* 1153 */     if (reg < this.jTable5.getRowCount() - 1) {
/* 1154 */       String tipo = this.jTable5.getValueAt(reg + 1, 1).toString();
/*      */       
/* 1156 */       if (!tipo.equals("")) {
/* 1157 */         cant = this.jTable5.getValueAt(reg + 1, 2).toString();
/* 1158 */         datos[0] = tipo;
/* 1159 */         datos[1] = cant;
/*      */       } else {
/*      */         
/* 1162 */         return null;
/*      */       } 
/*      */     } 
/* 1165 */     return datos;
/*      */   }
/*      */   
/*      */   public String[] regresaTipoImpuesto2(int reg) {
/* 1169 */     String[] datos = { "", "" };
/* 1170 */     String cant = "";
/*      */     
/* 1172 */     if (reg < this.jTable6.getRowCount() - 1) {
/* 1173 */       String tipo = this.jTable6.getValueAt(reg + 1, 1).toString();
/*      */       
/* 1175 */       if (!tipo.equals("")) {
/* 1176 */         cant = this.jTable6.getValueAt(reg + 1, 2).toString();
/* 1177 */         datos[0] = tipo;
/* 1178 */         datos[1] = cant;
/*      */       } else {
/* 1180 */         return null;
/*      */       } 
/*      */     } 
/* 1183 */     return datos;
/*      */   }
/*      */   
/*      */   public void insertarRenglonLineas() {
/* 1187 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————" }, this.jTable2);
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
/* 1209 */     double cambio = this.utilerias.convertirCantTexto(tipoCambio);
/* 1210 */     double monto = this.utilerias.convertirCantTexto(montoDLS);
/* 1211 */     double resultado = cambio * monto;
/*      */     
/* 1213 */     return this.utilerias.convertirDoublePesos(resultado);
/*      */   }
/*      */   
/*      */   public void sacarListaProductos() {
/* 1217 */     String consulta = ""; int i;
/* 1218 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1219 */       consulta = consulta + " conceptosfacturas33.numfactura = '" + consulta + "' ";
/* 1220 */       if (i + 1 < this.LISTAFACTURAS.length) {
/* 1221 */         consulta = consulta + " || ";
/*      */       }
/*      */     } 
/* 1224 */     this.CONSULTARLISTARPRODUCTOS = consulta;
/* 1225 */     this.utilerias.consultaGralTabla(this.con, this.jTable3, new String[] { "clave", "importe", "numFactura" }, "claveproducto, importe, numfactura", "conceptosfacturas33", "where (" + consulta + ") and claveproducto <>'' ");
/*      */     
/* 1227 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 1228 */       String folio = this.jTable3.getValueAt(i, 2).toString();
/* 1229 */       for (int j = 0; j < this.jTable2.getRowCount(); j++) {
/* 1230 */         String folio2 = this.jTable2.getValueAt(j, 1).toString();
/* 1231 */         String tipoCambio = this.jTable2.getValueAt(j, 8).toString();
/* 1232 */         if (folio.equals(folio2)) {
/*      */           
/* 1234 */           String nuevo = convertirDLSaPESOS(tipoCambio, this.jTable3.getValueAt(i, 1).toString());
/* 1235 */           this.jTable3.setValueAt(nuevo, i, 1);
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
/* 1256 */     this.jEditorPane1.setText("select claveproducto, importe, numfactura from  conceptosfacturas33 where (" + consulta + ") and claveproducto <>'' order by numFactura desc");
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarPrimeroVentasFletes() {
/* 1261 */     double fletesRetencion = 0.0D;
/* 1262 */     int cont = 0;
/* 1263 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1264 */       String folio = this.jTable2.getValueAt(i, 1).toString();
/* 1265 */       String iva = this.jTable2.getValueAt(i, 10).toString();
/* 1266 */       String ret = this.jTable2.getValueAt(i, 11).toString();
/* 1267 */       String tipo = this.jTable2.getValueAt(i, 13).toString();
/*      */       
/* 1269 */       if (!iva.equals("$0.00") && !ret.equals("$0.00") && tipo.equals("PM")) {
/* 1270 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 1271 */           String codigo = this.jTable3.getValueAt(j, 0).toString();
/* 1272 */           String fact = this.jTable3.getValueAt(j, 2).toString();
/* 1273 */           if ((fact.equals(folio) && codigo.equals("78101800")) || (fact.equals(folio) && codigo.equals("78101801")) || (fact.equals(folio) && codigo.equals("78101802"))) {
/* 1274 */             cont++;
/*      */             
/* 1276 */             fletesRetencion += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/* 1282 */     this.FLETESCR = fletesRetencion;
/* 1283 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS ", "FLETES C/RETENCIÓN", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1290 */           .convertirDoublePesos(fletesRetencion), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/* 1305 */     double fletesSinRetencion = 0.0D;
/* 1306 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1307 */       String folio = this.jTable2.getValueAt(i, 1).toString();
/* 1308 */       String iva = this.jTable2.getValueAt(i, 10).toString();
/* 1309 */       String ret = this.jTable2.getValueAt(i, 11).toString();
/*      */ 
/*      */       
/* 1312 */       String cliente = this.jTable2.getValueAt(i, 3).toString();
/*      */       
/* 1314 */       if ((cliente.equals("GSM - BRONCO S. A. DE C. V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1315 */         .equals("DOWELL SCHLUMBERGER DE MEXICO, S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1316 */         .equals("BAKER HUGHES OPERATIONS MEXICO S. DE R.L. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1317 */         .equals("CLEANMEX ENERGY SERVICES S DE RL DE CV") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1318 */         .equals("CAPITAL CARGO DEL GOLFO S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1319 */         .equals("ENERGY DRILLING MARINE SERVICES S.A.P. DE I. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || ret
/*      */         
/* 1321 */         .equals("$0.00")) {
/* 1322 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 1323 */           String codigo = this.jTable3.getValueAt(j, 0).toString();
/* 1324 */           String fact = this.jTable3.getValueAt(j, 2).toString();
/* 1325 */           if (fact.equals(folio) && (codigo.equals("78101800") || codigo.equals("78101801") || codigo.equals("78101802") || codigo.equals("76122401")))
/*      */           {
/* 1327 */             fletesSinRetencion += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
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
/* 1338 */     this.FLETESSR = fletesSinRetencion;
/* 1339 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS ", "FLETES SIN/RETENCIÓN", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1346 */           .convertirDoublePesos(fletesSinRetencion), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/* 1362 */     this.INGRESOSACTIVOFIJO = 0.0D;
/* 1363 */     for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 1364 */       String codigo = this.jTable3.getValueAt(j, 0).toString();
/* 1365 */       String fact = this.jTable3.getValueAt(j, 2).toString();
/* 1366 */       if (codigo.equals("25101600") || codigo.equals("25101503") || codigo.equals("25101500"))
/*      */       {
/*      */         
/* 1369 */         this.INGRESOSACTIVOFIJO += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1374 */     this.FLETESO = this.FLETESSUB - this.FLETESCR + this.FLETESSR + this.INGRESOSACTIVOFIJO;
/*      */     
/* 1376 */     if (this.FLETESO < 2.0D) {
/* 1377 */       this.FLETESO = 0.0D;
/*      */     }
/*      */     
/* 1380 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTRAS ", "VENTAS", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1387 */           .convertirDoublePesos(this.FLETESO), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/* 1400 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "INRGESOS POR", "VENTA DE ACTIVO FIJO", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1407 */           .convertirDoublePesos(this.INGRESOSACTIVOFIJO), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/* 1423 */     String cliente = "GENERAL";
/*      */ 
/*      */     
/* 1426 */     formatearTabla();
/* 1427 */     this.utilerias.quitarSignoPesosTabla(this.jTable2);
/* 1428 */     Map<Object, Object> datos = new HashMap<>();
/* 1429 */     this.utilerias.cargarImagenesAReporte(datos);
/* 1430 */     datos.put("sucursal", ((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 1431 */     datos.put("periodo", this.etiquetaFecha);
/* 1432 */     datos.put("cliente", "TODOS");
/* 1433 */     datos.put("estado", "CANCELADAS");
/* 1434 */     datos.put("titulo", "REPORTE DE PÓLIZAS CANCELADAS " + this.MONEDA);
/* 1435 */     datos.put("documento", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/*      */     
/*      */     try {
/* 1438 */       this.utilerias.verImpresion("/Reportes/Facturacion/PolizasPeriodoDLS.jasper", this.jTable2, datos, "REPORTE DE PÓLIZAS CANCELADAS" + this.MONEDA);
/* 1439 */     } catch (JRException ex) {
/* 1440 */       Logger.getLogger(Facturas33PeriodoDLSCanceladas.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String convertirFechaATexto(String fecha) {
/* 1445 */     String fechaCorta = fecha.substring(0, 10);
/* 1446 */     String año = fechaCorta.substring(0, 4);
/* 1447 */     String mes = fechaCorta.substring(5, 7);
/* 1448 */     String dia = fechaCorta.substring(8, 10);
/* 1449 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 1450 */     return strFecha;
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 1454 */     String canti = cant;
/* 1455 */     String valorP = "";
/* 1456 */     for (int j = 0; j < canti.length(); j++) {
/* 1457 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 1458 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 1461 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public void formatearTabla() {
/* 1465 */     for (int i = 0; i < this.jTable2.getRowCount(); i++);
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
/* 1519 */     Object[] Columnas = columnas;
/* 1520 */     Object[][] registros = new Object[Original.getRowCount()][columnas.length];
/* 1521 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 1522 */       registros[i][0] = Integer.valueOf(i + 1);
/* 1523 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 1524 */         if (j == 0) {
/* 1525 */           registros[i][0] = Original.getValueAt(i, j);
/*      */         }
/* 1527 */         if (j == 1) {
/* 1528 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 1530 */         if (j == 2) {
/* 1531 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/*      */         
/* 1534 */         if (j == 3) {
/* 1535 */           if (!Original.getValueAt(i, j).toString().equals("")) {
/* 1536 */             registros[i][3] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */           } else {
/* 1538 */             registros[i][3] = "";
/*      */           } 
/*      */         }
/* 1541 */         if (j == 4) {
/*      */           try {
/* 1543 */             registros[i][4] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1544 */           } catch (NumberFormatException e) {
/* 1545 */             registros[i][4] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */         
/* 1549 */         if (j == 5) {
/*      */           try {
/* 1551 */             registros[i][5] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1552 */           } catch (NumberFormatException e) {
/* 1553 */             registros[i][5] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1556 */         if (j == 6) {
/*      */           try {
/* 1558 */             registros[i][6] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1559 */           } catch (NumberFormatException e) {
/* 1560 */             registros[i][6] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1563 */         if (j == 7) {
/*      */           try {
/* 1565 */             registros[i][7] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1566 */           } catch (NumberFormatException e) {
/* 1567 */             registros[i][7] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1570 */         if (j == 8) {
/*      */           try {
/* 1572 */             registros[i][8] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1573 */           } catch (NumberFormatException e) {
/* 1574 */             registros[i][8] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1577 */         if (j == 9) {
/*      */           try {
/* 1579 */             registros[i][9] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1580 */           } catch (NumberFormatException e) {
/* 1581 */             registros[i][9] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1584 */         if (j == 10) {
/*      */           try {
/* 1586 */             registros[i][10] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1587 */           } catch (NumberFormatException e) {
/* 1588 */             registros[i][10] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1593 */     JTable aux = new JTable(registros, Columnas);
/* 1594 */     return aux;
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Facturas33PeriodoDLSCanceladas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */