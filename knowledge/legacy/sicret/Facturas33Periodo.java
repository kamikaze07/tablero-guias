/*      */ package sicret;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.logging.Level;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JEditorPane;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import utilerias.Utilerias;
/*      */ 
/*      */ public class Facturas33Periodo extends JDialog {
/*   19 */   Consultas2 con = new Consultas2();
/*      */   Date fecha1;
/*      */   Date fecha2;
/*      */   String MONEDA;
/*      */   String TIPO;
/*   24 */   Utilerias utilerias = new Utilerias();
/*      */   String[] LISTAFACTURAS;
/*   26 */   double FLETESCR = 0.0D;
/*   27 */   double FLETESSR = 0.0D;
/*   28 */   double FLETESO = 0.0D;
/*   29 */   double FLETESSUB = 0.0D;
/*   30 */   double INGRESOSACTIVOFIJO = 0.0D;
/*   31 */   double FLETESANTICIPO = 0.0D;
/*   32 */   String CONSULTARLISTARPRODUCTOS = ""; Map<String, String> CAMPOSGENERALES; private JEditorPane jEditorPane1; private JLabel jLabel1; private JLabel jLabel2;
/*      */   private JScrollPane jScrollPane1;
/*   34 */   int multiplo = 28; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5;
/*      */   
/*      */   public Facturas33Periodo(Map<String, String> CAMPOSGENERALES, Consultas2 con, Date fecha1, Date fecha2, String MONEDA, String TIPO) {
/*   37 */     initComponents();
/*   38 */     System.out.println("*** ACTIVAS **** ");
/*   39 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   40 */     this.con = con;
/*   41 */     this.fecha1 = fecha1;
/*   42 */     this.fecha2 = fecha2;
/*   43 */     this.MONEDA = MONEDA;
/*   44 */     this.TIPO = TIPO;
/*      */     
/*   46 */     this.utilerias.vaciarTabla(this.jTable1);
/*   47 */     this.utilerias.vaciarTabla(this.jTable2);
/*   48 */     this.utilerias.vaciarTabla(this.jTable3);
/*   49 */     this.utilerias.vaciarTabla(this.jTable4);
/*   50 */     this.utilerias.vaciarTabla(this.jTable5);
/*   51 */     this.utilerias.vaciarTabla(this.jTable6);
/*   52 */     consultarFacturasGral();
/*      */     
/*   54 */     this.jLabel2.setText("Lineas en jTable2: " + this.jTable2.getRowCount());
/*      */   }
/*      */   private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JTable jTable1; private JTable jTable2; private JTable jTable3;
/*      */   private JTable jTable4;
/*      */   private JTable jTable5;
/*      */   private JTable jTable6;
/*      */   
/*      */   private void initComponents() {
/*   62 */     this.jScrollPane1 = new JScrollPane();
/*   63 */     this.jTable1 = new JTable();
/*   64 */     this.jScrollPane2 = new JScrollPane();
/*   65 */     this.jTable2 = new JTable();
/*   66 */     this.jScrollPane3 = new JScrollPane();
/*   67 */     this.jTable3 = new JTable();
/*   68 */     this.jScrollPane4 = new JScrollPane();
/*   69 */     this.jEditorPane1 = new JEditorPane();
/*   70 */     this.jLabel1 = new JLabel();
/*   71 */     this.jScrollPane5 = new JScrollPane();
/*   72 */     this.jTable4 = new JTable();
/*   73 */     this.jScrollPane6 = new JScrollPane();
/*   74 */     this.jTable5 = new JTable();
/*   75 */     this.jScrollPane7 = new JScrollPane();
/*   76 */     this.jTable6 = new JTable();
/*   77 */     this.jLabel2 = new JLabel();
/*      */     
/*   79 */     setDefaultCloseOperation(2);
/*      */     
/*   81 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   92 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*   94 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  105 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/*  107 */     this.jTable3.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  118 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/*  120 */     this.jScrollPane4.setViewportView(this.jEditorPane1);
/*      */     
/*  122 */     this.jLabel1.setText("Total de datos:");
/*      */     
/*  124 */     this.jTable4.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  135 */     this.jScrollPane5.setViewportView(this.jTable4);
/*      */     
/*  137 */     this.jTable5.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  148 */     this.jScrollPane6.setViewportView(this.jTable5);
/*      */     
/*  150 */     this.jTable6.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  161 */     this.jScrollPane7.setViewportView(this.jTable6);
/*      */     
/*  163 */     this.jLabel2.setText("Total de datos:");
/*      */     
/*  165 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  166 */     getContentPane().setLayout(layout);
/*  167 */     layout.setHorizontalGroup(layout
/*  168 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  169 */         .addComponent(this.jScrollPane1)
/*  170 */         .addComponent(this.jScrollPane5, -1, 1167, 32767)
/*  171 */         .addComponent(this.jScrollPane6, -1, 1167, 32767)
/*  172 */         .addGroup(layout.createSequentialGroup()
/*  173 */           .addContainerGap()
/*  174 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  175 */             .addGroup(layout.createSequentialGroup()
/*  176 */               .addComponent(this.jLabel1, -2, 397, -2)
/*  177 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  178 */               .addComponent(this.jLabel2, -2, 397, -2))
/*  179 */             .addComponent(this.jScrollPane4, -2, 0, 32767))
/*  180 */           .addContainerGap())
/*  181 */         .addComponent(this.jScrollPane3)
/*  182 */         .addComponent(this.jScrollPane7, -1, 1167, 32767)
/*  183 */         .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING));
/*      */     
/*  185 */     layout.setVerticalGroup(layout
/*  186 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  187 */         .addGroup(layout.createSequentialGroup()
/*  188 */           .addContainerGap()
/*  189 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  190 */             .addComponent(this.jLabel1)
/*  191 */             .addComponent(this.jLabel2))
/*  192 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  193 */           .addComponent(this.jScrollPane1, -2, 100, -2)
/*  194 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  195 */           .addComponent(this.jScrollPane2, -2, 126, -2)
/*  196 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  197 */           .addComponent(this.jScrollPane3, -2, 153, -2)
/*  198 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  199 */           .addComponent(this.jScrollPane5, -2, 100, -2)
/*  200 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  201 */           .addComponent(this.jScrollPane6, -2, 88, -2)
/*  202 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  203 */           .addComponent(this.jScrollPane7, -1, 136, 32767)
/*  204 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  205 */           .addComponent(this.jScrollPane4, -2, 81, -2)
/*  206 */           .addContainerGap()));
/*      */ 
/*      */     
/*  209 */     pack();
/*      */   }
/*      */   
/*      */   public void consultarFacturasGral() {
/*  213 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  214 */     String cadenaFecha = "";
/*  215 */     cadenaFecha = formato.format(this.fecha1);
/*  216 */     String AÑO = cadenaFecha.substring(0, 4);
/*  217 */     String MES = cadenaFecha.substring(4, 6);
/*  218 */     String DIA = cadenaFecha.substring(6, 8);
/*  219 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*  220 */     cadenaFecha = formato.format(this.fecha2);
/*  221 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/*  222 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/*  223 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/*  224 */     String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59'";
/*  225 */     String consultaFecha = " and fecha between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     
/*  227 */     this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo" }, "numFactura,tipo,folio,folioFiscal,fecha,cliente,suPedido,equipo,subtotal,descMonto,iva,retencion,total,totalDebe,estatus,usuario, cartaporte, version, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura", "facturas33", "WHERE tipo = '" + this.TIPO + "' and  moneda = '" + this.MONEDA + "'" + consultaFecha + " and folio <>'PR46073' and estatus not like '%intercance%'");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  237 */     this.jLabel1.setText("Total de datos: " + this.jTable1.getRowCount());
/*  238 */     DefaultTableModel model = (DefaultTableModel)this.jTable1.getModel(); int i;
/*  239 */     for (i = 0; i < model.getRowCount(); i++) {
/*  240 */       model.setValueAt(Integer.valueOf(i + 1), i, 0);
/*      */     }
/*      */     
/*  243 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "folio", "fiscal", "fecha", "cliente", "sub", "iva", "ret", "total", "Tipo", "Metodo" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  250 */     this.utilerias.vaciarTabla(this.jTable3);
/*  251 */     this.LISTAFACTURAS = new String[this.jTable1.getRowCount()];
/*      */     
/*  253 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/*  254 */       String persona = this.jTable1.getValueAt(i, 20).toString();
/*  255 */       if (persona.equals("PERSONA_FISICA")) {
/*  256 */         persona = "PF";
/*  257 */       } else if (persona.equals("PERSONA_MORAL")) {
/*  258 */         persona = "PM";
/*  259 */       } else if (persona.equals("EXTRANJERO")) {
/*  260 */         persona = "EXT";
/*      */       } else {
/*  262 */         persona = "INV";
/*      */       } 
/*  264 */       this.utilerias.agregarCampoTablas(new String[] { this.jTable1
/*      */             
/*  266 */             .getValueAt(i, 0).toString(), this.jTable1
/*  267 */             .getValueAt(i, 2).toString(), this.jTable1
/*  268 */             .getValueAt(i, 3).toString(), this.jTable1
/*  269 */             .getValueAt(i, 4).toString(), this.jTable1
/*  270 */             .getValueAt(i, 5).toString(), this.jTable1
/*  271 */             .getValueAt(i, 8).toString(), this.jTable1
/*  272 */             .getValueAt(i, 10).toString(), this.jTable1
/*  273 */             .getValueAt(i, 11).toString(), this.jTable1
/*  274 */             .getValueAt(i, 12).toString(), persona, this.jTable1
/*      */             
/*  276 */             .getValueAt(i, 21).toString().substring(0, 3) }this.jTable2);
/*      */ 
/*      */       
/*  279 */       this.LISTAFACTURAS[i] = this.jTable1.getValueAt(i, 2).toString();
/*      */     } 
/*      */     
/*  282 */     double sub = this.utilerias.sumarColumnaTabla(this.jTable2, 5);
/*  283 */     double iva = this.utilerias.sumarColumnaTabla(this.jTable2, 6);
/*  284 */     double ret = this.utilerias.sumarColumnaTabla(this.jTable2, 7);
/*  285 */     double tot = this.utilerias.sumarColumnaTabla(this.jTable2, 8);
/*      */     
/*  287 */     if (this.jTable2.getRowCount() > 0) {
/*  288 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  289 */       this.utilerias.agregarCampoTablas(new String[] { "", "", "FOLIO INICIAL: " + 
/*      */ 
/*      */ 
/*      */             
/*  293 */             String.valueOf(this.jTable2.getValueAt(0, 1)), "", "FOLIO FINAL: " + 
/*      */             
/*  295 */             String.valueOf(this.jTable2.getValueAt(this.jTable2.getRowCount() - 2, 1)), "", "", "", "", "", "", "", "" }this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  304 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     } 
/*  306 */     insertarRenglonLineas();
/*  307 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  314 */           .convertirDoublePesos(sub), this.utilerias
/*  315 */           .convertirDoublePesos(iva), this.utilerias
/*  316 */           .convertirDoublePesos(ret), this.utilerias
/*  317 */           .convertirDoublePesos(tot), "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  322 */     this.FLETESSUB = sub;
/*      */     
/*  324 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  326 */     int registrosParaAgregar = calcularRegistrosParaMultiplo(this.jTable2.getRowCount(), this.multiplo);
/*  327 */     int reg = registrosParaAgregar;
/*  328 */     for (int j = 0; j < reg; j++) {
/*  329 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  335 */     sacarListaProductos();
/*  336 */     sacarPrimeroVentasFletes();
/*  337 */     sacarSegundoVentasFletes();
/*  338 */     sacarTerceroVentasFletes();
/*  339 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  340 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  341 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  343 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "CLIENTES " + (String)this.CAMPOSGENERALES
/*      */ 
/*      */ 
/*      */           
/*  347 */           .get("sucursal"), "", "", this.utilerias
/*      */ 
/*      */           
/*  350 */           .convertirDoublePesos(tot - sacarSumaTipoAnticipo()), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  358 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "ANTICIPOS ", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  365 */           .convertirDoublePesos(sacarSumaTipoAnticipo()), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  374 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "IVA TRASLADADO P/ COBRAR", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  382 */           .convertirDoublePesos(iva), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  390 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "FLETES CON RETENCIÓN", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  398 */           .convertirDoublePesos(this.FLETESCR), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  406 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "FLETES SIN RETENCIÓN", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  414 */           .convertirDoublePesos(this.FLETESSR), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  422 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTROS INGRESOS POR VENTAS", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  430 */           .convertirDoublePesos(this.FLETESO), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  438 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "INGRESOS POR VENTA DE ACTIVO FIJO", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  446 */           .convertirDoublePesos(this.INGRESOSACTIVOFIJO), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  454 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "RETENCIÓN DE IVA", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  461 */           .convertirDoublePesos(ret), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  470 */     double totG1 = tot + ret;
/*  471 */     double totG2 = iva + this.FLETESCR + this.FLETESSR + this.FLETESO;
/*      */     
/*  473 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  489 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  496 */           .convertirDoublePesos(totG1), this.utilerias
/*  497 */           .convertirDoublePesos(totG1), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  505 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  506 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  507 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "****** INFORMACIÓN DE PRODUCTOS ******", "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  523 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "| CLAVE DE PRODUCTO |", "", "| DESCRIPCIÓN DE PRODUCTO |", "| SUB |", "| TRAS ", "| RETENIDO |", "| TOTAL |", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  539 */     consultarProductosDif();
/*      */ 
/*      */     
/*  542 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  549 */           .convertirDoublePesos(sub), this.utilerias
/*  550 */           .convertirDoublePesos(iva), this.utilerias
/*  551 */           .convertirDoublePesos(ret), this.utilerias
/*  552 */           .convertirDoublePesos(tot), "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  557 */     imprimirReportePolizas();
/*      */   }
/*      */   
/*      */   public double sacarSumaTipoAnticipo() {
/*  561 */     double sum = 0.0D;
/*  562 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/*  563 */       String col = this.jTable1.getValueAt(i, 22).toString();
/*  564 */       if (col.equals("ANTICIPO")) {
/*  565 */         sum += this.utilerias.convertirCantTexto(this.jTable1.getValueAt(i, 12).toString());
/*      */       }
/*      */     } 
/*  568 */     return sum;
/*      */   }
/*      */   
/*      */   public void consultarProductosDif() {
/*  572 */     Map<String, String> CantProdIva = new HashMap<>();
/*  573 */     Map<String, String> CantProdRet = new HashMap<>();
/*  574 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/*  575 */           .buscarDatos(1, "DISTINCT claveproducto", " facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and claveproducto<>'' and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.claveproducto asc"), (Object[])new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  583 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  587 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  591 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/*  592 */       CantProdIva.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*  593 */       CantProdRet.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*      */     } 
/*      */     
/*  596 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/*  597 */           .buscarDatos("claveProducto, tipoImpuesto, totalImpuesto, facturas33.folio, facturas33.fecha ,facturas33.estatus ", "facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.num asc"), (Object[])new String[] { "Clave Prod", "Tipo", "Total", "Factura", "Fecha", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  604 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  608 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  612 */     double valor1 = 0.0D;
/*  613 */     double valor2 = 0.0D;
/*      */     
/*  615 */     double retenidoPrueba = 0.0D;
/*  616 */     for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/*  617 */       if (((String)this.CAMPOSGENERALES.get("sucursal")).equals("POZA RICA") || ((String)this.CAMPOSGENERALES.get("sucursal")).equals("CADEREYTA")) {
/*  618 */         String folio = this.jTable5.getValueAt(j, 3).toString();
/*  619 */         for (int i1 = 0; i1 < this.jTable6.getRowCount(); i1++) {
/*  620 */           String folio2 = this.jTable6.getValueAt(i1, 2).toString();
/*      */ 
/*      */           
/*  623 */           if (folio.equals(folio2) && this.jTable6.getValueAt(i1, 18).equals("USD") && !this.jTable5.getValueAt(j, 2).toString().equals("")) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  633 */       String cod = this.jTable5.getValueAt(j, 0).toString();
/*  634 */       if (!cod.equals("")) {
/*      */         
/*  636 */         String[] dat = regresaTipoImpuesto(j);
/*  637 */         if (dat != null && 
/*  638 */           dat[0].equals("TRASLADO")) {
/*  639 */           double cantAnt = this.utilerias.convertirCantTexto(CantProdIva.get(cod));
/*  640 */           double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  641 */           CantProdIva.put(cod, "" + v2);
/*  642 */           valor1 += this.utilerias.convertirCantTexto(dat[1]);
/*      */         } 
/*      */ 
/*      */         
/*  646 */         if (j < this.jTable5.getRowCount() - 1 && dat != null) {
/*      */           
/*  648 */           dat = regresaTipoImpuesto(j + 1);
/*  649 */           if (dat != null && 
/*  650 */             dat[0].equals("RETENIDO")) {
/*  651 */             double cantAnt = this.utilerias.convertirCantTexto(CantProdRet.get(cod));
/*  652 */             double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  653 */             CantProdRet.put(cod, "" + v2);
/*  654 */             valor2 += this.utilerias.convertirCantTexto(dat[1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  662 */     DefaultTableModel model = (DefaultTableModel)this.jTable4.getModel();
/*  663 */     model.addColumn("Descripcion");
/*  664 */     model.fireTableDataChanged();
/*  665 */     for (int k = 0; k < this.jTable4.getRowCount(); k++) {
/*  666 */       this.con.consultar("descripcion", "catproductos", "where clave = " + String.valueOf(this.jTable4.getValueAt(k, 0)));
/*  667 */       this.jTable4.setValueAt(this.con.Campo, k, 1);
/*      */     } 
/*      */     
/*  670 */     double[] cantidades = new double[this.jTable4.getRowCount()];
/*  671 */     double totalProd = 0.0D;
/*  672 */     for (int m = 0; m < this.jTable4.getRowCount(); m++) {
/*  673 */       String[] cant = this.con.regresaColIndex("importe", "facturas33, conceptosfacturas33", "where claveproducto='" + 
/*      */ 
/*      */           
/*  676 */           String.valueOf(this.jTable4.getValueAt(m, 0)) + "' and folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ")");
/*  677 */       for (int i1 = 0; i1 < cant.length; i1++) {
/*  678 */         cantidades[m] = cantidades[m] + this.utilerias.convertirCantTexto(cant[i1]);
/*  679 */         totalProd += this.utilerias.convertirCantTexto(cant[i1]);
/*      */       } 
/*      */     } 
/*      */     
/*  683 */     double iva = 0.0D;
/*  684 */     double ret = 0.0D;
/*  685 */     double tot = 0.0D;
/*      */     int n;
/*  687 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/*  688 */       String cod = CantProdIva.get(this.jTable4.getValueAt(n, 0).toString());
/*  689 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod)), n, 2);
/*      */       
/*  691 */       String cod2 = CantProdRet.get(this.jTable4.getValueAt(n, 0).toString());
/*  692 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod2)), n, 3);
/*      */     } 
/*      */     
/*  695 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/*  696 */       double suma = cantidades[n] + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 2).toString()) - this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 3).toString());
/*      */       
/*  698 */       this.utilerias.agregarCampoTablas(new String[] { "", "", this.jTable4
/*      */ 
/*      */ 
/*      */             
/*  702 */             .getValueAt(n, 0).toString(), "", this.jTable4
/*      */             
/*  704 */             .getValueAt(n, 1).toString(), this.utilerias
/*  705 */             .convertirDoublePesos(cantidades[n]), this.jTable4
/*  706 */             .getValueAt(n, 2).toString(), this.jTable4
/*  707 */             .getValueAt(n, 3).toString(), this.utilerias
/*  708 */             .convertirDoublePesos(suma), "", "" }this.jTable2);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  715 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  731 */     double totGral = totalProd + iva - ret;
/*      */   }
/*      */   
/*      */   public String[] regresaTipoImpuesto(int reg) {
/*  735 */     String[] datos = { "", "" };
/*  736 */     String cant = "";
/*      */     
/*  738 */     if (reg < this.jTable5.getRowCount() - 1) {
/*  739 */       String tipo = this.jTable5.getValueAt(reg + 1, 1).toString();
/*      */       
/*  741 */       if (!tipo.equals("")) {
/*  742 */         cant = this.jTable5.getValueAt(reg + 1, 2).toString();
/*  743 */         datos[0] = tipo;
/*  744 */         datos[1] = cant;
/*      */       } else {
/*  746 */         return null;
/*      */       } 
/*      */     } 
/*  749 */     return datos;
/*      */   }
/*      */   
/*      */   public void insertarRenglonLineas() {
/*  753 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "" }, this.jTable2);
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
/*  771 */     String consulta = "";
/*  772 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/*  773 */       consulta = consulta + " conceptosfacturas33.numfactura = '" + consulta + "' ";
/*  774 */       if (i + 1 < this.LISTAFACTURAS.length) {
/*  775 */         consulta = consulta + " || ";
/*      */       }
/*      */     } 
/*  778 */     this.CONSULTARLISTARPRODUCTOS = consulta;
/*  779 */     this.utilerias.consultaGralTabla(this.con, this.jTable3, new String[] { "clave", "importe", "numFactura" }, "claveproducto, importe, numfactura", "conceptosfacturas33", "where (" + consulta + ") and claveproducto <>'' ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  796 */     this.jEditorPane1.setText("select claveproducto, importe, numfactura from  conceptosfacturas33 where (" + consulta + ") and claveproducto <>'' order by numFactura desc");
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarPrimeroVentasFletes() {
/*  801 */     double fletesRetencion = 0.0D;
/*  802 */     int cont = 0;
/*  803 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/*  804 */       String folio = this.jTable2.getValueAt(i, 1).toString();
/*  805 */       String iva = this.jTable2.getValueAt(i, 6).toString();
/*  806 */       String ret = this.jTable2.getValueAt(i, 7).toString();
/*  807 */       String tipo = this.jTable2.getValueAt(i, 9).toString();
/*      */       
/*  809 */       if (!iva.equals("$0.00") && !ret.equals("$0.00") && tipo.equals("PM")) {
/*  810 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/*  811 */           String codigo = this.jTable3.getValueAt(j, 0).toString();
/*  812 */           String fact = this.jTable3.getValueAt(j, 2).toString();
/*  813 */           if ((fact.equals(folio) && codigo.equals("78101800")) || (fact.equals(folio) && codigo.equals("78101801")) || (fact.equals(folio) && codigo.equals("78101802"))) {
/*  814 */             cont++;
/*  815 */             fletesRetencion += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  822 */     this.FLETESCR = fletesRetencion;
/*      */     
/*  824 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS FLETES C/RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  831 */           .convertirDoublePesos(fletesRetencion), "", "", "", "", "" }, this.jTable2);
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
/*  843 */     double fletesSinRetencion = 0.0D;
/*  844 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/*  845 */       String folio = this.jTable2.getValueAt(i, 1).toString();
/*  846 */       String iva = this.jTable2.getValueAt(i, 6).toString();
/*  847 */       String ret = this.jTable2.getValueAt(i, 7).toString();
/*  848 */       String tipo = this.jTable2.getValueAt(i, 9).toString();
/*      */       
/*  850 */       String cliente = this.jTable2.getValueAt(i, 4).toString();
/*      */       
/*  852 */       if ((cliente.equals("GSM - BRONCO S. A. DE C. V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/*  853 */         .equals("DOWELL SCHLUMBERGER DE MEXICO, S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/*  854 */         .equals("BAKER HUGHES OPERATIONS MEXICO S. DE R.L. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/*  855 */         .equals("CLEANMEX ENERGY SERVICES S DE RL DE CV") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/*  856 */         .equals("CAPITAL CARGO DEL GOLFO S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/*  857 */         .equals("ENERGY DRILLING MARINE SERVICES S.A.P. DE I. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || ret
/*      */         
/*  859 */         .equals("$0.00")) {
/*  860 */         for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/*  861 */           String codigo = this.jTable3.getValueAt(j, 0).toString();
/*  862 */           String fact = this.jTable3.getValueAt(j, 2).toString();
/*  863 */           if (fact.equals(folio) && (codigo.equals("78101800") || codigo.equals("78101801") || codigo.equals("78101802") || codigo.equals("76122401")))
/*      */           {
/*  865 */             fletesSinRetencion += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
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
/*  876 */     this.FLETESSR = fletesSinRetencion;
/*  877 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS FLETES SIN/RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  884 */           .convertirDoublePesos(fletesSinRetencion), "", "", "", "", "" }, this.jTable2);
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
/*  896 */     this.INGRESOSACTIVOFIJO = 0.0D;
/*  897 */     for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/*  898 */       String codigo = this.jTable3.getValueAt(j, 0).toString();
/*  899 */       String fact = this.jTable3.getValueAt(j, 2).toString();
/*  900 */       if (codigo.equals("25101600") || codigo.equals("25101503") || codigo.equals("25101500"))
/*      */       {
/*      */         
/*  903 */         this.INGRESOSACTIVOFIJO += this.utilerias.convertirCantTexto(this.jTable3.getValueAt(j, 1).toString());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  908 */     this.FLETESO = this.FLETESSUB - this.FLETESCR + this.FLETESSR + this.INGRESOSACTIVOFIJO;
/*      */     
/*  910 */     if (this.FLETESO < 2.0D) {
/*  911 */       this.FLETESO = 0.0D;
/*      */     }
/*      */     
/*  914 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTRAS VENTAS", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  921 */           .convertirDoublePesos(this.FLETESO), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  930 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "INRGESOS POR VENTA DE ACTIVO FIJO", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  937 */           .convertirDoublePesos(this.INGRESOSACTIVOFIJO), "", "", "", "", "" }, this.jTable2);
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
/*  949 */     String fechaCompleta = this.utilerias.convertirFechaDateStringBarras(this.fecha1) + " AL " + this.utilerias.convertirFechaDateStringBarras(this.fecha1);
/*  950 */     String cliente = "GENERAL";
/*      */     
/*  952 */     JTable aux = crearTablaAux2(this.jTable2, new Object[] { "cont", "Folio", "Fiscal", "Fecha", "Cliente", "Sub", "Iva", "Ret", "Tot", "Tipo", "Met" });
/*  953 */     this.utilerias.quitarSignoPesosTabla(aux);
/*  954 */     Map<Object, Object> datos = new HashMap<>();
/*  955 */     this.utilerias.cargarImagenesAReporte(datos);
/*  956 */     datos.put("sucursal", ((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/*  957 */     datos.put("periodo", fechaCompleta);
/*  958 */     datos.put("cliente", "TODOS");
/*  959 */     datos.put("estado", "VENTAS");
/*  960 */     datos.put("titulo", "REPORTE DE PÓLIZAS " + this.MONEDA);
/*  961 */     datos.put("documento", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/*      */     
/*      */     try {
/*  964 */       this.utilerias.verImpresion("/Reportes/Facturacion/PolizasPeriodo.jasper", aux, datos, "REPORTE DE PÓLIZAS " + this.MONEDA);
/*  965 */     } catch (JRException ex) {
/*  966 */       Logger.getLogger(Facturas33Periodo.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String convertirFechaATexto(String fecha) {
/*  971 */     String fechaCorta = fecha.substring(0, 10);
/*  972 */     String año = fechaCorta.substring(0, 4);
/*  973 */     String mes = fechaCorta.substring(5, 7);
/*  974 */     String dia = fechaCorta.substring(8, 10);
/*  975 */     String strFecha = dia + "/" + dia + "/" + mes;
/*  976 */     return strFecha;
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/*  980 */     String canti = cant;
/*  981 */     String valorP = "";
/*  982 */     for (int j = 0; j < canti.length(); j++) {
/*  983 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/*  984 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/*  987 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public static int calcularRegistrosParaMultiplo(int registros, int multiplo) {
/*  991 */     int residuo = registros % multiplo;
/*  992 */     return (residuo == 0) ? 0 : (multiplo - residuo);
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux2(JTable Original, Object[] columnas) {
/*  996 */     Object[] Columnas = columnas;
/*  997 */     Object[][] registros = new Object[Original.getRowCount()][columnas.length];
/*  998 */     for (int i = 0; i < Original.getRowCount(); i++) {
/*  999 */       registros[i][0] = Integer.valueOf(i + 1);
/* 1000 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 1001 */         if (j == 0) {
/* 1002 */           registros[i][0] = Original.getValueAt(i, j);
/*      */         }
/* 1004 */         if (j == 1) {
/* 1005 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 1007 */         if (j == 2) {
/* 1008 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/*      */         
/* 1011 */         if (j == 3) {
/* 1012 */           if (!Original.getValueAt(i, j).toString().equals("")) {
/* 1013 */             registros[i][3] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */           } else {
/* 1015 */             registros[i][3] = "";
/*      */           } 
/*      */         }
/* 1018 */         if (j == 4) {
/*      */           try {
/* 1020 */             registros[i][4] = Original.getValueAt(i, j);
/*      */           }
/* 1022 */           catch (NumberFormatException e) {
/* 1023 */             registros[i][4] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */         
/* 1027 */         if (j == 5) {
/*      */           try {
/* 1029 */             registros[i][5] = Original.getValueAt(i, j);
/*      */           }
/* 1031 */           catch (NumberFormatException e) {
/* 1032 */             registros[i][5] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1035 */         if (j == 6) {
/*      */           try {
/* 1037 */             registros[i][6] = Original.getValueAt(i, j);
/*      */           }
/* 1039 */           catch (NumberFormatException e) {
/* 1040 */             registros[i][6] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1043 */         if (j == 7) {
/*      */           try {
/* 1045 */             registros[i][7] = Original.getValueAt(i, j);
/*      */           }
/* 1047 */           catch (NumberFormatException e) {
/* 1048 */             registros[i][7] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1051 */         if (j == 8) {
/*      */           try {
/* 1053 */             registros[i][8] = Original.getValueAt(i, j);
/*      */           }
/* 1055 */           catch (NumberFormatException e) {
/* 1056 */             registros[i][8] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1059 */         if (j == 9) {
/*      */           try {
/* 1061 */             registros[i][9] = Original.getValueAt(i, j);
/*      */           }
/* 1063 */           catch (NumberFormatException e) {
/* 1064 */             registros[i][9] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1067 */         if (j == 10) {
/*      */           try {
/* 1069 */             registros[i][10] = Original.getValueAt(i, j);
/*      */           }
/* 1071 */           catch (NumberFormatException e) {
/* 1072 */             registros[i][10] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1077 */     JTable aux = new JTable(registros, Columnas);
/* 1078 */     return aux;
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Facturas33Periodo.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */