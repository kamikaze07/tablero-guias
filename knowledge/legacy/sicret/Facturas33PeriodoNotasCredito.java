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
/*      */ public class Facturas33PeriodoNotasCredito extends JDialog {
/*   24 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   25 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   26 */   Consultas2 con = new Consultas2();
/*      */   Date fecha1;
/*      */   Date fecha2;
/*      */   String MONEDA;
/*      */   String TIPO;
/*   31 */   Utilerias utilerias = new Utilerias();
/*      */   String[] LISTAFACTURAS;
/*      */   String[] LISTAFACTURAS2;
/*   34 */   double FLETESCR = 0.0D;
/*   35 */   double FLETESSR = 0.0D;
/*   36 */   double FLETESO = 0.0D;
/*   37 */   double FLETESSUB = 0.0D;
/*   38 */   double INGRESOSACTIVOFIJO = 0.0D;
/*   39 */   String CONSULTARLISTARPRODUCTOS = "";
/*      */   Map<String, String> CAMPOSGENERALES;
/*   41 */   int multiplo = 28; JComboBox MES; JComboBox AÑO; private JDialog jDialog1; private JEditorPane jEditorPane1; private JEditorPane jEditorPane2; private JLabel jLabel1; private JLabel jLabel2; private JLabel jLabel3;
/*      */   private JLabel jLabel4;
/*      */   private JScrollPane jScrollPane1;
/*   44 */   String etiquetaFecha = ""; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane12; private JScrollPane jScrollPane13; private JScrollPane jScrollPane14; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4;
/*      */   
/*      */   public Facturas33PeriodoNotasCredito(Map<String, String> CAMPOSGENERALES, Consultas2 con, Date fecha1, Date fecha2, String MONEDA, String TIPO, JComboBox MES, JComboBox AÑO) {
/*   47 */     initComponents();
/*   48 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   49 */     this.con = con;
/*   50 */     this.fecha1 = fecha1;
/*   51 */     this.fecha2 = fecha2;
/*   52 */     this.MONEDA = MONEDA;
/*   53 */     this.TIPO = TIPO;
/*   54 */     this.MES = MES;
/*   55 */     this.AÑO = AÑO;
/*   56 */     System.out.println("*** NOTAS DE CRÉDITO (ACTIVAS) **** " + String.valueOf(this.MES.getSelectedItem()));
/*      */     
/*   58 */     this.utilerias.vaciarTabla(this.jTable1);
/*   59 */     this.utilerias.vaciarTabla(this.jTable2);
/*   60 */     this.utilerias.vaciarTabla(this.jTable3);
/*   61 */     this.utilerias.vaciarTabla(this.jTable4);
/*   62 */     this.utilerias.vaciarTabla(this.jTable5);
/*   63 */     this.utilerias.vaciarTabla(this.jTable6);
/*   64 */     consultarFacturasGral();
/*   65 */     this.utilerias.activarVentanajDialog(this.jDialog1, 1100, 800);
/*      */   }
/*      */   private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JTable jTable1; private JTable jTable10; private JTable jTable11; private JTable jTable12; private JTable jTable2; private JTable jTable3; private JTable jTable4; private JTable jTable5; private JTable jTable6;
/*      */   private JTable jTable7;
/*      */   private JTable jTable8;
/*      */   private JTable jTable9;
/*      */   
/*      */   private void initComponents() {
/*   73 */     this.jDialog1 = new JDialog();
/*   74 */     this.jScrollPane8 = new JScrollPane();
/*   75 */     this.jTable7 = new JTable();
/*   76 */     this.jScrollPane9 = new JScrollPane();
/*   77 */     this.jTable8 = new JTable();
/*   78 */     this.jScrollPane10 = new JScrollPane();
/*   79 */     this.jTable9 = new JTable();
/*   80 */     this.jScrollPane11 = new JScrollPane();
/*   81 */     this.jEditorPane2 = new JEditorPane();
/*   82 */     this.jLabel3 = new JLabel();
/*   83 */     this.jScrollPane12 = new JScrollPane();
/*   84 */     this.jTable10 = new JTable();
/*   85 */     this.jScrollPane13 = new JScrollPane();
/*   86 */     this.jTable11 = new JTable();
/*   87 */     this.jScrollPane14 = new JScrollPane();
/*   88 */     this.jTable12 = new JTable();
/*   89 */     this.jLabel4 = new JLabel();
/*   90 */     this.jScrollPane1 = new JScrollPane();
/*   91 */     this.jTable1 = new JTable();
/*   92 */     this.jScrollPane2 = new JScrollPane();
/*   93 */     this.jTable2 = new JTable();
/*   94 */     this.jScrollPane3 = new JScrollPane();
/*   95 */     this.jTable3 = new JTable();
/*   96 */     this.jScrollPane4 = new JScrollPane();
/*   97 */     this.jEditorPane1 = new JEditorPane();
/*   98 */     this.jLabel1 = new JLabel();
/*   99 */     this.jScrollPane5 = new JScrollPane();
/*  100 */     this.jTable4 = new JTable();
/*  101 */     this.jScrollPane6 = new JScrollPane();
/*  102 */     this.jTable5 = new JTable();
/*  103 */     this.jScrollPane7 = new JScrollPane();
/*  104 */     this.jTable6 = new JTable();
/*  105 */     this.jLabel2 = new JLabel();
/*      */     
/*  107 */     this.jDialog1.setDefaultCloseOperation(2);
/*      */     
/*  109 */     this.jTable7.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  120 */     this.jScrollPane8.setViewportView(this.jTable7);
/*      */     
/*  122 */     this.jTable8.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  133 */     this.jScrollPane9.setViewportView(this.jTable8);
/*      */     
/*  135 */     this.jTable9.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  146 */     this.jScrollPane10.setViewportView(this.jTable9);
/*      */     
/*  148 */     this.jScrollPane11.setViewportView(this.jEditorPane2);
/*      */     
/*  150 */     this.jLabel3.setText("Total de datos:");
/*      */     
/*  152 */     this.jTable10.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  163 */     this.jScrollPane12.setViewportView(this.jTable10);
/*      */     
/*  165 */     this.jTable11.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  176 */     this.jScrollPane13.setViewportView(this.jTable11);
/*      */     
/*  178 */     this.jTable12.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  189 */     this.jScrollPane14.setViewportView(this.jTable12);
/*      */     
/*  191 */     this.jLabel4.setText("Total de datos:");
/*      */     
/*  193 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  194 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  195 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  196 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  197 */         .addComponent(this.jScrollPane8)
/*  198 */         .addComponent(this.jScrollPane12, -1, 1167, 32767)
/*  199 */         .addComponent(this.jScrollPane13, -1, 1167, 32767)
/*  200 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  201 */           .addContainerGap()
/*  202 */           .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  203 */             .addGroup(jDialog1Layout.createSequentialGroup()
/*  204 */               .addComponent(this.jLabel3, -2, 397, -2)
/*  205 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  206 */               .addComponent(this.jLabel4, -2, 397, -2))
/*  207 */             .addComponent(this.jScrollPane11, -2, 0, 32767))
/*  208 */           .addContainerGap())
/*  209 */         .addComponent(this.jScrollPane10)
/*  210 */         .addComponent(this.jScrollPane14, -1, 1167, 32767)
/*  211 */         .addComponent(this.jScrollPane9, GroupLayout.Alignment.TRAILING));
/*      */     
/*  213 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  214 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  215 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  216 */           .addContainerGap()
/*  217 */           .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  218 */             .addComponent(this.jLabel3)
/*  219 */             .addComponent(this.jLabel4))
/*  220 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  221 */           .addComponent(this.jScrollPane8, -2, 100, -2)
/*  222 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  223 */           .addComponent(this.jScrollPane9, -2, 126, -2)
/*  224 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  225 */           .addComponent(this.jScrollPane10, -2, 153, -2)
/*  226 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  227 */           .addComponent(this.jScrollPane12, -2, 100, -2)
/*  228 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  229 */           .addComponent(this.jScrollPane13, -2, 88, -2)
/*  230 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  231 */           .addComponent(this.jScrollPane14, -1, 136, 32767)
/*  232 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  233 */           .addComponent(this.jScrollPane11, -2, 81, -2)
/*  234 */           .addContainerGap()));
/*      */ 
/*      */     
/*  237 */     setDefaultCloseOperation(2);
/*      */     
/*  239 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },  }, (Object[])new String[] { "num", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retencion", "Total", "Debe", "Estatus", "Documento", "Version", "Meneda", "Tipo Cambio", "persona", "Pago", "Tipo" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  250 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  252 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  263 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/*  265 */     this.jTable3.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  276 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/*  278 */     this.jScrollPane4.setViewportView(this.jEditorPane1);
/*      */     
/*  280 */     this.jLabel1.setText("Total de datos:");
/*      */     
/*  282 */     this.jTable4.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  293 */     this.jScrollPane5.setViewportView(this.jTable4);
/*      */     
/*  295 */     this.jTable5.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  306 */     this.jScrollPane6.setViewportView(this.jTable5);
/*      */     
/*  308 */     this.jTable6.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  319 */     this.jScrollPane7.setViewportView(this.jTable6);
/*      */     
/*  321 */     this.jLabel2.setText("Total de datos:");
/*      */     
/*  323 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  324 */     getContentPane().setLayout(layout);
/*  325 */     layout.setHorizontalGroup(layout
/*  326 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  327 */         .addComponent(this.jScrollPane1)
/*  328 */         .addComponent(this.jScrollPane5, -1, 1167, 32767)
/*  329 */         .addComponent(this.jScrollPane6, -1, 1167, 32767)
/*  330 */         .addGroup(layout.createSequentialGroup()
/*  331 */           .addContainerGap()
/*  332 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  333 */             .addGroup(layout.createSequentialGroup()
/*  334 */               .addComponent(this.jLabel1, -2, 397, -2)
/*  335 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  336 */               .addComponent(this.jLabel2, -2, 397, -2))
/*  337 */             .addComponent(this.jScrollPane4, -2, 0, 32767))
/*  338 */           .addContainerGap())
/*  339 */         .addComponent(this.jScrollPane3)
/*  340 */         .addComponent(this.jScrollPane7, -1, 1167, 32767)
/*  341 */         .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING));
/*      */     
/*  343 */     layout.setVerticalGroup(layout
/*  344 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  345 */         .addGroup(layout.createSequentialGroup()
/*  346 */           .addContainerGap()
/*  347 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  348 */             .addComponent(this.jLabel1)
/*  349 */             .addComponent(this.jLabel2))
/*  350 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  351 */           .addComponent(this.jScrollPane1, -2, 100, -2)
/*  352 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  353 */           .addComponent(this.jScrollPane2, -2, 126, -2)
/*  354 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  355 */           .addComponent(this.jScrollPane3, -2, 153, -2)
/*  356 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  357 */           .addComponent(this.jScrollPane5, -2, 100, -2)
/*  358 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  359 */           .addComponent(this.jScrollPane6, -2, 88, -2)
/*  360 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  361 */           .addComponent(this.jScrollPane7, -1, 136, 32767)
/*  362 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  363 */           .addComponent(this.jScrollPane4, -2, 81, -2)
/*  364 */           .addContainerGap()));
/*      */ 
/*      */     
/*  367 */     pack();
/*      */   }
/*      */   
/*      */   public void consultarFacturasGral() {
/*  371 */     String fechaCompleta1 = "";
/*  372 */     String fechaCompleta2 = "";
/*  373 */     String consultaFecha = "";
/*  374 */     if (this.MES.getSelectedIndex() != 0) {
/*  375 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*      */       
/*  377 */       int aa = Integer.parseInt(this.AÑO.getSelectedItem().toString());
/*  378 */       consultaFecha = " and  date_format( fecha, '%m-%Y') = '" + mes[this.MES.getSelectedIndex()] + "-" + aa + "' ";
/*  379 */       this.etiquetaFecha = this.MES.getSelectedItem().toString();
/*      */     } else {
/*  381 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  382 */       String cadenaFecha = "";
/*  383 */       cadenaFecha = formato.format(this.fecha1);
/*  384 */       String AÑO = cadenaFecha.substring(0, 4);
/*  385 */       String MES = cadenaFecha.substring(4, 6);
/*  386 */       String DIA = cadenaFecha.substring(6, 8);
/*  387 */       fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*  388 */       this.etiquetaFecha = DIA + "/" + DIA + "/" + MES;
/*  389 */       cadenaFecha = formato.format(this.fecha2);
/*  390 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/*  391 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/*  392 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/*  393 */       this.etiquetaFecha = this.etiquetaFecha + " AL " + this.etiquetaFecha + "/" + dd + "/" + mm;
/*  394 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/*  395 */       consultaFecha = " and fecha between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     } 
/*  397 */     System.out.println("Periodo " + String.valueOf(this.MES.getSelectedItem()));
/*  398 */     String motivo = "";
/*  399 */     if (!this.MES.getSelectedItem().toString().equals("PERIODO LIBRE")) {
/*  400 */       motivo = " and motivo = ''";
/*      */     }
/*      */     
/*  403 */     this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo" }, "numFactura,tipo,folio,folioFiscal,fecha,cliente,suPedido,equipo,subtotal,descMonto,iva,retencion,total,totalDebe,estatus,usuario, cartaporte, version, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura ", "facturas33", "WHERE tipo = '" + this.TIPO + "' and  moneda = '" + this.MONEDA + "'" + consultaFecha + " " + motivo);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  414 */     this.utilerias.consultaGralTabla(this.con, this.jTable7, new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo" }, "numFactura,tipo,folio,folioFiscal,fecha,cliente,suPedido,equipo,subtotal,descMonto,iva,retencion,total,totalDebe,estatus,usuario, cartaporte, version, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura ", "facturas33", "f JOIN relacion r ON f.folio = r.folioRelacionado WHERE r.folioRelacionado IN ( SELECT r.folioRelacionado FROM facturas33 f JOIN relacion r ON f.folio = r.folioRelacion WHERE f.tipo = 'NC' " + motivo + " AND r.folioRelacionado LIKE '" + (String)this.CAMPOSGENERALES
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  426 */         .get("folioFacturas") + "%' " + consultaFecha + ") ORDER BY f.folio DESC");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  431 */     if (this.jTable1.getRowCount() < 1) {
/*  432 */       JOptionPane.showMessageDialog(this, "No existen datos en ese periodo seleccionado", "No hay datos", 0, this.ADVER);
/*      */       return;
/*      */     } 
/*  435 */     this.jLabel1.setText("Total de datos: " + this.jTable1.getRowCount());
/*  436 */     DefaultTableModel model = (DefaultTableModel)this.jTable1.getModel(); int i;
/*  437 */     for (i = 0; i < model.getRowCount(); i++) {
/*  438 */       model.setValueAt(Integer.valueOf(i + 1), i, 0);
/*      */     }
/*      */     
/*  441 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "folio", "fiscal", "fecha", "cliente", "sub", "iva", "ret", "total", "Tipo", "Metodo" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  448 */     this.utilerias.vaciarTabla(this.jTable3);
/*  449 */     this.LISTAFACTURAS = new String[this.jTable1.getRowCount()];
/*  450 */     this.LISTAFACTURAS2 = new String[this.jTable7.getRowCount()];
/*      */     
/*  452 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/*  453 */       String persona = this.jTable1.getValueAt(i, 20).toString();
/*  454 */       if (persona.equals("PERSONA_FISICA")) {
/*  455 */         persona = "PF";
/*  456 */       } else if (persona.equals("PERSONA_MORAL")) {
/*  457 */         persona = "PM";
/*  458 */       } else if (persona.equals("EXTRANJERO")) {
/*  459 */         persona = "EXT";
/*      */       } else {
/*  461 */         persona = "INV";
/*      */       } 
/*  463 */       this.utilerias.agregarCampoTablas(new String[] { this.jTable1
/*      */             
/*  465 */             .getValueAt(i, 0).toString(), this.jTable1
/*  466 */             .getValueAt(i, 2).toString(), this.jTable1
/*  467 */             .getValueAt(i, 3).toString(), this.jTable1
/*  468 */             .getValueAt(i, 4).toString(), this.jTable1
/*  469 */             .getValueAt(i, 5).toString(), this.jTable1
/*  470 */             .getValueAt(i, 8).toString(), this.jTable1
/*  471 */             .getValueAt(i, 10).toString(), this.jTable1
/*  472 */             .getValueAt(i, 11).toString(), this.jTable1
/*  473 */             .getValueAt(i, 12).toString(), persona, this.jTable1
/*      */             
/*  475 */             .getValueAt(i, 21).toString().substring(0, 3) }this.jTable2);
/*      */ 
/*      */       
/*  478 */       this.LISTAFACTURAS[i] = this.jTable1.getValueAt(i, 2).toString();
/*      */     } 
/*      */     
/*  481 */     llenarSegundaTabla();
/*      */     
/*  483 */     double sub = this.utilerias.sumarColumnaTabla(this.jTable2, 5);
/*  484 */     double iva = this.utilerias.sumarColumnaTabla(this.jTable2, 6);
/*  485 */     double ret = this.utilerias.sumarColumnaTabla(this.jTable2, 7);
/*  486 */     double tot = this.utilerias.sumarColumnaTabla(this.jTable2, 8);
/*      */     
/*  488 */     if (this.jTable2.getRowCount() > 0) {
/*  489 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  490 */       this.utilerias.agregarCampoTablas(new String[] { "", "", "FOLIO INICIAL: " + 
/*      */ 
/*      */ 
/*      */             
/*  494 */             String.valueOf(this.jTable2.getValueAt(0, 1)), "", "FOLIO FINAL: " + 
/*      */             
/*  496 */             String.valueOf(this.jTable2.getValueAt(this.jTable2.getRowCount() - 2, 1)), "", "", "", "", "", "", "", "" }this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  505 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     } 
/*  507 */     insertarRenglonLineas();
/*  508 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  515 */           .convertirDoublePesos(sub), this.utilerias
/*  516 */           .convertirDoublePesos(iva), this.utilerias
/*  517 */           .convertirDoublePesos(ret), this.utilerias
/*  518 */           .convertirDoublePesos(tot), "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  523 */     this.FLETESSUB = sub;
/*      */     
/*  525 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  527 */     int registrosParaAgregar = calcularRegistrosParaMultiplo(this.jTable2.getRowCount(), this.multiplo);
/*  528 */     int reg = registrosParaAgregar;
/*  529 */     for (int j = 0; j < reg; j++) {
/*  530 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     }
/*      */     
/*  533 */     sacarListaProductos();
/*  534 */     sacarPrimeroVentasFletes();
/*  535 */     sacarSegundoVentasFletes();
/*  536 */     sacarTerceroVentasFletes();
/*  537 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  538 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  540 */     double sumaSub = this.utilerias.sumarColumnaTabla(this.jTable1, 8);
/*  541 */     double otrasVentas = this.utilerias.sumarColumnaTablaSiCondicion(this.jTable1, 8, "IGUAL", "ANTICIPO", 22);
/*  542 */     double sumaIva = this.utilerias.sumarColumnaTabla(this.jTable1, 10);
/*  543 */     double sumaTotalAnticipo = this.utilerias.sumarColumnaTablaSiCondicion(this.jTable1, 12, "IGUAL", "ANTICIPO", 22);
/*  544 */     double sumaRet = this.utilerias.sumarColumnaTabla(this.jTable1, 11);
/*  545 */     double sumaTotal = this.utilerias.sumarColumnaTabla(this.jTable1, 12);
/*      */     
/*  547 */     double totG1 = sumaSub - otrasVentas + otrasVentas + sumaIva;
/*      */     
/*  549 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "DEV, DESC, BON", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  556 */           .convertirDoublePesos(sumaSub - otrasVentas), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  565 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTRAS VENTAS", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  572 */           .convertirDoublePesos(otrasVentas), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  581 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "IVA", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  588 */           .convertirDoublePesos(sumaIva), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  597 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "RETENCIÓN", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  605 */           .convertirDoublePesos(sumaRet), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  613 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "CLIENTES", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  621 */           .convertirDoublePesos(sumaTotal - sumaTotalAnticipo), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  629 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "    CLIENTES ANTICIPO", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  637 */           .convertirDoublePesos(sumaTotalAnticipo), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  648 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  667 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  674 */           .convertirDoublePesos(totG1), this.utilerias
/*  675 */           .convertirDoublePesos(totG1), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  683 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  684 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  685 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "****** INFORMACIÓN DE PRODUCTOS ******", "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  701 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "| CLAVE DE PRODUCTO |", "", "| DESCRIPCIÓN DE PRODUCTO |", "| SUB |", "| TRAS ", "| RETENIDO |", "| TOTAL |", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  717 */     consultarProductosDif();
/*      */ 
/*      */     
/*  720 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  727 */           .convertirDoublePesos(sub), this.utilerias
/*  728 */           .convertirDoublePesos(iva), this.utilerias
/*  729 */           .convertirDoublePesos(ret), this.utilerias
/*  730 */           .convertirDoublePesos(tot), "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  735 */     imprimirReportePolizas();
/*      */   }
/*      */   
/*      */   public void llenarSegundaTabla() {
/*  739 */     this.jTable8.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "folio", "fiscal", "fecha", "cliente", "sub", "iva", "ret", "total", "Tipo", "Metodo" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  746 */     this.utilerias.vaciarTabla(this.jTable9);
/*  747 */     this.LISTAFACTURAS2 = new String[this.jTable7.getRowCount()];
/*      */     
/*  749 */     for (int i = 0; i < this.jTable7.getRowCount(); i++) {
/*  750 */       String persona = this.jTable7.getValueAt(i, 20).toString();
/*  751 */       if (persona.equals("PERSONA_FISICA")) {
/*  752 */         persona = "PF";
/*  753 */       } else if (persona.equals("PERSONA_MORAL")) {
/*  754 */         persona = "PM";
/*  755 */       } else if (persona.equals("EXTRANJERO")) {
/*  756 */         persona = "EXT";
/*      */       } else {
/*  758 */         persona = "INV";
/*      */       } 
/*  760 */       this.utilerias.agregarCampoTablas(new String[] { this.jTable7
/*      */             
/*  762 */             .getValueAt(i, 0).toString(), this.jTable7
/*  763 */             .getValueAt(i, 2).toString(), this.jTable7
/*  764 */             .getValueAt(i, 3).toString(), this.jTable7
/*  765 */             .getValueAt(i, 4).toString(), this.jTable7
/*  766 */             .getValueAt(i, 5).toString(), this.jTable7
/*  767 */             .getValueAt(i, 8).toString(), this.jTable7
/*  768 */             .getValueAt(i, 10).toString(), this.jTable7
/*  769 */             .getValueAt(i, 11).toString(), this.jTable7
/*  770 */             .getValueAt(i, 12).toString(), persona, this.jTable7
/*      */             
/*  772 */             .getValueAt(i, 21).toString().substring(0, 3) }this.jTable8);
/*      */ 
/*      */       
/*  775 */       this.LISTAFACTURAS2[i] = this.jTable7.getValueAt(i, 2).toString();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarProductosDif() {
/*  780 */     Map<String, String> CantProdIva = new HashMap<>();
/*  781 */     Map<String, String> CantProdRet = new HashMap<>();
/*  782 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/*  783 */           .buscarDatos(1, "DISTINCT claveproducto", " facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and claveproducto<>'' and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.claveproducto asc"), (Object[])new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  791 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  795 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  799 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/*  800 */       CantProdIva.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*  801 */       CantProdRet.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*      */     } 
/*      */     
/*  804 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/*  805 */           .buscarDatos("claveProducto, tipoImpuesto, totalImpuesto, facturas33.folio, facturas33.fecha ,facturas33.estatus ", "facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.num asc"), (Object[])new String[] { "Clave Prod", "Tipo", "Total", "Factura", "Fecha", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  812 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  816 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  820 */     double valor1 = 0.0D;
/*  821 */     double valor2 = 0.0D;
/*      */     
/*  823 */     double retenidoPrueba = 0.0D;
/*  824 */     for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/*  825 */       if (((String)this.CAMPOSGENERALES.get("sucursal")).equals("POZA RICA") || ((String)this.CAMPOSGENERALES.get("sucursal")).equals("CADEREYTA")) {
/*  826 */         String folio = this.jTable5.getValueAt(j, 3).toString();
/*  827 */         for (int i1 = 0; i1 < this.jTable6.getRowCount(); i1++) {
/*  828 */           String folio2 = this.jTable6.getValueAt(i1, 2).toString();
/*  829 */           if (folio.equals(folio2) && this.jTable6.getValueAt(i1, 18).equals("USD") && !this.jTable5.getValueAt(j, 2).toString().equals("")) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  835 */       String cod = this.jTable5.getValueAt(j, 0).toString();
/*  836 */       if (!cod.equals("")) {
/*      */         
/*  838 */         String[] dat = regresaTipoImpuesto(j);
/*  839 */         if (dat != null && 
/*  840 */           dat[0].equals("TRASLADO")) {
/*  841 */           double cantAnt = this.utilerias.convertirCantTexto(CantProdIva.get(cod));
/*  842 */           double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  843 */           CantProdIva.put(cod, "" + v2);
/*  844 */           valor1 += this.utilerias.convertirCantTexto(dat[1]);
/*      */         } 
/*      */ 
/*      */         
/*  848 */         if (j < this.jTable5.getRowCount() - 1 && dat != null) {
/*      */           
/*  850 */           dat = regresaTipoImpuesto(j + 1);
/*  851 */           if (dat != null && 
/*  852 */             dat[0].equals("RETENIDO")) {
/*  853 */             double cantAnt = this.utilerias.convertirCantTexto(CantProdRet.get(cod));
/*  854 */             double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  855 */             CantProdRet.put(cod, "" + v2);
/*  856 */             valor2 += this.utilerias.convertirCantTexto(dat[1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  864 */     DefaultTableModel model = (DefaultTableModel)this.jTable4.getModel();
/*  865 */     model.addColumn("Descripcion");
/*  866 */     model.fireTableDataChanged();
/*  867 */     for (int k = 0; k < this.jTable4.getRowCount(); k++) {
/*  868 */       this.con.consultar("descripcion", "catproductos", "where clave = " + String.valueOf(this.jTable4.getValueAt(k, 0)));
/*  869 */       this.jTable4.setValueAt(this.con.Campo, k, 1);
/*      */     } 
/*      */     
/*  872 */     double[] cantidades = new double[this.jTable4.getRowCount()];
/*  873 */     double totalProd = 0.0D;
/*  874 */     for (int m = 0; m < this.jTable4.getRowCount(); m++) {
/*  875 */       String[] cant = this.con.regresaColIndex("importe", "facturas33, conceptosfacturas33", "where claveproducto='" + 
/*      */ 
/*      */           
/*  878 */           String.valueOf(this.jTable4.getValueAt(m, 0)) + "' and folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ")");
/*  879 */       for (int i1 = 0; i1 < cant.length; i1++) {
/*  880 */         cantidades[m] = cantidades[m] + this.utilerias.convertirCantTexto(cant[i1]);
/*  881 */         totalProd += this.utilerias.convertirCantTexto(cant[i1]);
/*      */       } 
/*      */     } 
/*      */     
/*  885 */     double iva = 0.0D;
/*  886 */     double ret = 0.0D;
/*  887 */     double tot = 0.0D;
/*      */     int n;
/*  889 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/*  890 */       String cod = CantProdIva.get(this.jTable4.getValueAt(n, 0).toString());
/*  891 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod)), n, 2);
/*      */       
/*  893 */       String cod2 = CantProdRet.get(this.jTable4.getValueAt(n, 0).toString());
/*  894 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod2)), n, 3);
/*      */     } 
/*      */     
/*  897 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/*  898 */       double suma = cantidades[n] + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 2).toString()) - this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 3).toString());
/*      */       
/*  900 */       this.utilerias.agregarCampoTablas(new String[] { "", "", this.jTable4
/*      */ 
/*      */ 
/*      */             
/*  904 */             .getValueAt(n, 0).toString(), "", this.jTable4
/*      */             
/*  906 */             .getValueAt(n, 1).toString(), this.utilerias
/*  907 */             .convertirDoublePesos(cantidades[n]), this.jTable4
/*  908 */             .getValueAt(n, 2).toString(), this.jTable4
/*  909 */             .getValueAt(n, 3).toString(), this.utilerias
/*  910 */             .convertirDoublePesos(suma), "", "" }this.jTable2);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  917 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  933 */     double totGral = totalProd + iva - ret;
/*      */   }
/*      */   
/*      */   public double sacarSumaTipoAnticipo() {
/*  937 */     double sum = 0.0D;
/*  938 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/*  939 */       String col = this.jTable1.getValueAt(i, 22).toString();
/*  940 */       if (col.equals("ANTICIPO")) {
/*  941 */         sum += this.utilerias.convertirCantTexto(this.jTable1.getValueAt(i, 12).toString());
/*      */       }
/*      */     } 
/*  944 */     return sum;
/*      */   }
/*      */   
/*      */   public String[] regresaTipoImpuesto(int reg) {
/*  948 */     String[] datos = { "", "" };
/*  949 */     String cant = "";
/*      */     
/*  951 */     if (reg < this.jTable5.getRowCount() - 1) {
/*  952 */       String tipo = this.jTable5.getValueAt(reg + 1, 1).toString();
/*      */       
/*  954 */       if (!tipo.equals("")) {
/*  955 */         cant = this.jTable5.getValueAt(reg + 1, 2).toString();
/*  956 */         datos[0] = tipo;
/*  957 */         datos[1] = cant;
/*      */       } else {
/*  959 */         return null;
/*      */       } 
/*      */     } 
/*  962 */     return datos;
/*      */   }
/*      */   
/*      */   public void insertarRenglonLineas() {
/*  966 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "" }, this.jTable2);
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
/*  984 */     String consulta = ""; int i;
/*  985 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/*  986 */       consulta = consulta + " conceptosfacturas33.numfactura = '" + consulta + "' ";
/*  987 */       if (i + 1 < this.LISTAFACTURAS.length) {
/*  988 */         consulta = consulta + " || ";
/*      */       }
/*      */     } 
/*  991 */     this.CONSULTARLISTARPRODUCTOS = consulta;
/*  992 */     this.utilerias.consultaGralTabla(this.con, this.jTable3, new String[] { "clave", "importe", "numFactura" }, "claveproducto, importe, numfactura", "conceptosfacturas33", "where (" + consulta + ") and claveproducto <>'' ");
/*      */     
/*  994 */     consulta = "";
/*  995 */     for (i = 0; i < this.jTable7.getRowCount(); i++) {
/*  996 */       consulta = consulta + " conceptosfacturas33.numfactura = '" + consulta + "' ";
/*  997 */       if (i + 1 < this.LISTAFACTURAS2.length) {
/*  998 */         consulta = consulta + " || ";
/*      */       }
/*      */     } 
/*      */     
/* 1002 */     this.utilerias.consultaGralTabla(this.con, this.jTable9, new String[] { "clave", "importe", "numFactura" }, "claveproducto, importe, numfactura", "conceptosfacturas33", "where (" + consulta + ") and claveproducto <>'' ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1020 */     this.jEditorPane1.setText("select claveproducto, importe, numfactura from  conceptosfacturas33 where (" + consulta + ") and claveproducto <>'' order by numFactura desc");
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarPrimeroVentasFletes() {
/* 1025 */     double fletesRetencion = 0.0D;
/* 1026 */     int cont = 0;
/* 1027 */     for (int i = 0; i < this.jTable8.getRowCount(); i++) {
/* 1028 */       String folio = this.jTable8.getValueAt(i, 1).toString();
/* 1029 */       String iva = this.jTable8.getValueAt(i, 6).toString();
/* 1030 */       String ret = this.jTable8.getValueAt(i, 7).toString();
/* 1031 */       String tipo = this.jTable8.getValueAt(i, 9).toString();
/*      */       
/* 1033 */       if (!iva.equals("$0.00") && !ret.equals("$0.00") && tipo.equals("PM")) {
/* 1034 */         for (int j = 0; j < this.jTable9.getRowCount(); j++) {
/* 1035 */           String codigo = this.jTable9.getValueAt(j, 0).toString();
/* 1036 */           String fact = this.jTable9.getValueAt(j, 2).toString();
/* 1037 */           if ((fact.equals(folio) && codigo.equals("78101800")) || (fact.equals(folio) && codigo.equals("78101801")) || (fact.equals(folio) && codigo.equals("78101802"))) {
/* 1038 */             cont++;
/* 1039 */             fletesRetencion += this.utilerias.convertirCantTexto(this.jTable9.getValueAt(j, 1).toString());
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1046 */     this.FLETESCR = fletesRetencion;
/*      */     
/* 1048 */     System.out.println("entra primer");
/* 1049 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS FLETES C/RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1056 */           .convertirDoublePesos(fletesRetencion), "", "", "", "", "" }, this.jTable2);
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
/* 1068 */     double fletesSinRetencion = 0.0D;
/* 1069 */     for (int i = 0; i < this.jTable8.getRowCount(); i++) {
/* 1070 */       String folio = this.jTable8.getValueAt(i, 1).toString();
/* 1071 */       String iva = this.jTable8.getValueAt(i, 6).toString();
/* 1072 */       String ret = this.jTable8.getValueAt(i, 7).toString();
/* 1073 */       String tipo = this.jTable8.getValueAt(i, 9).toString();
/*      */       
/* 1075 */       String cliente = this.jTable8.getValueAt(i, 4).toString();
/*      */       
/* 1077 */       if ((cliente.equals("GSM - BRONCO S. A. DE C. V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1078 */         .equals("DOWELL SCHLUMBERGER DE MEXICO, S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1079 */         .equals("BAKER HUGHES OPERATIONS MEXICO S. DE R.L. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1080 */         .equals("CLEANMEX ENERGY SERVICES S DE RL DE CV") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1081 */         .equals("CAPITAL CARGO DEL GOLFO S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1082 */         .equals("ENERGY DRILLING MARINE SERVICES S.A.P. DE I. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || ret
/*      */         
/* 1084 */         .equals("$0.00")) {
/* 1085 */         for (int j = 0; j < this.jTable9.getRowCount(); j++) {
/* 1086 */           String codigo = this.jTable9.getValueAt(j, 0).toString();
/* 1087 */           String fact = this.jTable9.getValueAt(j, 2).toString();
/* 1088 */           if (fact.equals(folio) && (codigo.equals("78101800") || codigo.equals("78101801") || codigo.equals("78101802") || codigo.equals("76122401")))
/*      */           {
/* 1090 */             fletesSinRetencion += this.utilerias.convertirCantTexto(this.jTable9.getValueAt(j, 1).toString());
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
/* 1101 */     this.FLETESSR = fletesSinRetencion;
/* 1102 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS FLETES SIN/RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1109 */           .convertirDoublePesos(fletesSinRetencion), "", "", "", "", "" }, this.jTable2);
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
/* 1121 */     this.INGRESOSACTIVOFIJO = 0.0D;
/* 1122 */     for (int j = 0; j < this.jTable9.getRowCount(); j++) {
/* 1123 */       String codigo = this.jTable9.getValueAt(j, 0).toString();
/* 1124 */       String fact = this.jTable9.getValueAt(j, 2).toString();
/* 1125 */       if (codigo.equals("25101600") || codigo.equals("25101503") || codigo.equals("25101500"))
/*      */       {
/*      */         
/* 1128 */         this.INGRESOSACTIVOFIJO += this.utilerias.convertirCantTexto(this.jTable9.getValueAt(j, 1).toString());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1133 */     this.FLETESO = this.FLETESSUB - this.FLETESCR + this.FLETESSR + this.INGRESOSACTIVOFIJO;
/*      */     
/* 1135 */     if (this.FLETESO < 2.0D) {
/* 1136 */       this.FLETESO = 0.0D;
/*      */     }
/*      */     
/* 1139 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTRAS VENTAS", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1146 */           .convertirDoublePesos(this.FLETESO), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1155 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "INRGESOS POR VENTA DE ACTIVO FIJO", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1162 */           .convertirDoublePesos(this.INGRESOSACTIVOFIJO), "", "", "", "", "" }, this.jTable2);
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
/* 1174 */     JTable aux = crearTablaAux2(this.jTable2, new Object[] { "cont", "Folio", "Fiscal", "Fecha", "Cliente", "Sub", "Iva", "Ret", "Tot", "Tipo", "Met" });
/* 1175 */     this.utilerias.quitarSignoPesosTabla(aux);
/* 1176 */     Map<Object, Object> datos = new HashMap<>();
/* 1177 */     this.utilerias.cargarImagenesAReporte(datos);
/* 1178 */     datos.put("sucursal", ((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 1179 */     datos.put("periodo", this.etiquetaFecha);
/* 1180 */     datos.put("cliente", "TODOS");
/* 1181 */     datos.put("estado", "NOTAS DE CRÉDITO ( EGRESOS )");
/* 1182 */     datos.put("titulo", "REPORTE DE PÓLIZAS PARA NOTAS DE CRÉDITO " + this.MONEDA);
/* 1183 */     datos.put("documento", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/*      */     
/*      */     try {
/* 1186 */       this.utilerias.verImpresion("/Reportes/Facturacion/PolizasPeriodo.jasper", aux, datos, "REPORTE DE PÓLIZAS - NOTAS DE CŔEDITO" + this.MONEDA);
/* 1187 */     } catch (JRException ex) {
/* 1188 */       Logger.getLogger(Facturas33PeriodoNotasCredito.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String convertirFechaATexto(String fecha) {
/* 1193 */     String fechaCorta = fecha.substring(0, 10);
/* 1194 */     String año = fechaCorta.substring(0, 4);
/* 1195 */     String mes = fechaCorta.substring(5, 7);
/* 1196 */     String dia = fechaCorta.substring(8, 10);
/* 1197 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 1198 */     return strFecha;
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 1202 */     String canti = cant;
/* 1203 */     String valorP = "";
/* 1204 */     for (int j = 0; j < canti.length(); j++) {
/* 1205 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 1206 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 1209 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public static int calcularRegistrosParaMultiplo(int registros, int multiplo) {
/* 1213 */     int residuo = registros % multiplo;
/* 1214 */     return (residuo == 0) ? 0 : (multiplo - residuo);
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux2(JTable Original, Object[] columnas) {
/* 1218 */     Object[] Columnas = columnas;
/* 1219 */     Object[][] registros = new Object[Original.getRowCount()][columnas.length];
/* 1220 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 1221 */       registros[i][0] = Integer.valueOf(i + 1);
/* 1222 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 1223 */         if (j == 0) {
/* 1224 */           registros[i][0] = Original.getValueAt(i, j);
/*      */         }
/* 1226 */         if (j == 1) {
/* 1227 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 1229 */         if (j == 2) {
/* 1230 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/*      */         
/* 1233 */         if (j == 3) {
/* 1234 */           if (!Original.getValueAt(i, j).toString().equals("")) {
/* 1235 */             registros[i][3] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */           } else {
/* 1237 */             registros[i][3] = "";
/*      */           } 
/*      */         }
/* 1240 */         if (j == 4) {
/*      */           
/*      */           try {
/* 1243 */             registros[i][4] = Original.getValueAt(i, j);
/* 1244 */           } catch (NumberFormatException e) {
/* 1245 */             registros[i][4] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */         
/* 1249 */         if (j == 5) {
/*      */           
/*      */           try {
/* 1252 */             registros[i][5] = Original.getValueAt(i, j);
/* 1253 */           } catch (NumberFormatException e) {
/* 1254 */             registros[i][5] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1257 */         if (j == 6) {
/*      */           
/*      */           try {
/* 1260 */             registros[i][6] = Original.getValueAt(i, j);
/* 1261 */           } catch (NumberFormatException e) {
/* 1262 */             registros[i][6] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1265 */         if (j == 7) {
/*      */           
/*      */           try {
/* 1268 */             registros[i][7] = Original.getValueAt(i, j);
/* 1269 */           } catch (NumberFormatException e) {
/* 1270 */             registros[i][7] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1273 */         if (j == 8) {
/*      */           
/*      */           try {
/* 1276 */             registros[i][8] = Original.getValueAt(i, j);
/* 1277 */           } catch (NumberFormatException e) {
/* 1278 */             registros[i][8] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1281 */         if (j == 9) {
/*      */           
/*      */           try {
/* 1284 */             registros[i][9] = Original.getValueAt(i, j);
/* 1285 */           } catch (NumberFormatException e) {
/* 1286 */             registros[i][9] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1289 */         if (j == 10) {
/*      */           
/*      */           try {
/* 1292 */             registros[i][10] = Original.getValueAt(i, j);
/* 1293 */           } catch (NumberFormatException e) {
/* 1294 */             registros[i][10] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1299 */     JTable aux = new JTable(registros, Columnas);
/* 1300 */     return aux;
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Facturas33PeriodoNotasCredito.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */