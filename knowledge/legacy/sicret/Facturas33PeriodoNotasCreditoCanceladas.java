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
/*      */ public class Facturas33PeriodoNotasCreditoCanceladas extends JDialog {
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
/*      */   public Facturas33PeriodoNotasCreditoCanceladas(Map<String, String> CAMPOSGENERALES, Consultas2 con, Date fecha1, Date fecha2, String MONEDA, String TIPO, JComboBox MES, JComboBox AÑO) {
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
/*  390 */       String aa = cadenaFecha.substring(0, 4);
/*  391 */       String mm = cadenaFecha.substring(4, 6);
/*  392 */       String dd = cadenaFecha.substring(6, 8);
/*  393 */       this.etiquetaFecha = this.etiquetaFecha + " AL " + this.etiquetaFecha + "/" + dd + "/" + mm;
/*  394 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/*  395 */       consultaFecha = " and fecha between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     } 
/*  397 */     System.out.println("Periodo " + String.valueOf(this.MES.getSelectedItem()));
/*  398 */     String motivo = " and motivo!=''";
/*  399 */     this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo" }, "numFactura,tipo,folio,folioFiscal,fecha,cliente,suPedido,equipo,subtotal,descMonto,iva,retencion,total,totalDebe,estatus,usuario, cartaporte, version, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura ", "facturas33", "WHERE tipo = '" + this.TIPO + "' and  moneda = '" + this.MONEDA + "'" + consultaFecha + " " + motivo);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  410 */     this.utilerias.consultaGralTabla(this.con, this.jTable7, new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo" }, "numFactura,tipo,folio,folioFiscal,fecha,cliente,suPedido,equipo,subtotal,descMonto,iva,retencion,total,totalDebe,estatus,usuario, cartaporte, version, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura ", "facturas33", "f JOIN relacion r ON f.folio = r.folioRelacionado WHERE r.folioRelacionado IN ( SELECT r.folioRelacionado FROM facturas33 f JOIN relacion r ON f.folio = r.folioRelacion WHERE f.tipo = 'NC' " + motivo + " AND r.folioRelacionado LIKE '" + (String)this.CAMPOSGENERALES
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  422 */         .get("folioFacturas") + "%' " + consultaFecha + ") ORDER BY f.folio DESC");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  428 */     if (this.jTable1.getRowCount() < 1) {
/*  429 */       JOptionPane.showMessageDialog(this, "No existen datos en ese periodo seleccionado", "No hay datos", 0, this.ADVER);
/*      */       
/*      */       return;
/*      */     } 
/*  433 */     this.jLabel1.setText("Total de datos: " + this.jTable1.getRowCount());
/*  434 */     DefaultTableModel model = (DefaultTableModel)this.jTable1.getModel(); int i;
/*  435 */     for (i = 0; i < model.getRowCount(); i++) {
/*  436 */       model.setValueAt(Integer.valueOf(i + 1), i, 0);
/*      */     }
/*      */     
/*  439 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "folio", "fiscal", "fecha", "cliente", "sub", "iva", "ret", "total", "Tipo", "Metodo" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  446 */     this.utilerias.vaciarTabla(this.jTable3);
/*  447 */     this.LISTAFACTURAS = new String[this.jTable1.getRowCount()];
/*  448 */     this.LISTAFACTURAS2 = new String[this.jTable7.getRowCount()];
/*      */     
/*  450 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/*  451 */       String persona = this.jTable1.getValueAt(i, 20).toString();
/*  452 */       if (persona.equals("PERSONA_FISICA")) {
/*  453 */         persona = "PF";
/*  454 */       } else if (persona.equals("PERSONA_MORAL")) {
/*  455 */         persona = "PM";
/*  456 */       } else if (persona.equals("EXTRANJERO")) {
/*  457 */         persona = "EXT";
/*      */       } else {
/*  459 */         persona = "INV";
/*      */       } 
/*  461 */       this.utilerias.agregarCampoTablas(new String[] { this.jTable1
/*      */             
/*  463 */             .getValueAt(i, 0).toString(), this.jTable1
/*  464 */             .getValueAt(i, 2).toString(), this.jTable1
/*  465 */             .getValueAt(i, 3).toString(), this.jTable1
/*  466 */             .getValueAt(i, 4).toString(), this.jTable1
/*  467 */             .getValueAt(i, 5).toString(), this.jTable1
/*  468 */             .getValueAt(i, 8).toString(), this.jTable1
/*  469 */             .getValueAt(i, 10).toString(), this.jTable1
/*  470 */             .getValueAt(i, 11).toString(), this.jTable1
/*  471 */             .getValueAt(i, 12).toString(), persona, this.jTable1
/*      */             
/*  473 */             .getValueAt(i, 21).toString().substring(0, 3) }this.jTable2);
/*      */ 
/*      */       
/*  476 */       this.LISTAFACTURAS[i] = this.jTable1.getValueAt(i, 2).toString();
/*      */     } 
/*      */     
/*  479 */     llenarSegundaTabla();
/*      */     
/*  481 */     double sub = this.utilerias.sumarColumnaTabla(this.jTable2, 5);
/*  482 */     double iva = this.utilerias.sumarColumnaTabla(this.jTable2, 6);
/*  483 */     double ret = this.utilerias.sumarColumnaTabla(this.jTable2, 7);
/*  484 */     double tot = this.utilerias.sumarColumnaTabla(this.jTable2, 8);
/*      */     
/*  486 */     if (this.jTable2.getRowCount() > 0) {
/*  487 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  488 */       this.utilerias.agregarCampoTablas(new String[] { "", "", "FOLIO INICIAL: " + 
/*      */ 
/*      */ 
/*      */             
/*  492 */             String.valueOf(this.jTable2.getValueAt(0, 1)), "", "FOLIO FINAL: " + 
/*      */             
/*  494 */             String.valueOf(this.jTable2.getValueAt(this.jTable2.getRowCount() - 2, 1)), "", "", "", "", "", "", "", "" }this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  503 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     } 
/*  505 */     insertarRenglonLineas();
/*  506 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  513 */           .convertirDoublePesos(sub), this.utilerias
/*  514 */           .convertirDoublePesos(iva), this.utilerias
/*  515 */           .convertirDoublePesos(ret), this.utilerias
/*  516 */           .convertirDoublePesos(tot), "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  521 */     this.FLETESSUB = sub;
/*      */     
/*  523 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  525 */     int registrosParaAgregar = calcularRegistrosParaMultiplo(this.jTable2.getRowCount(), this.multiplo);
/*  526 */     int reg = registrosParaAgregar;
/*  527 */     for (int j = 0; j < reg; j++) {
/*  528 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     }
/*      */     
/*  531 */     sacarListaProductos();
/*  532 */     sacarPrimeroVentasFletes();
/*  533 */     sacarSegundoVentasFletes();
/*  534 */     sacarTerceroVentasFletes();
/*  535 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  536 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  538 */     double sumaSub = this.utilerias.sumarColumnaTabla(this.jTable1, 8);
/*  539 */     double otrasVentas = this.utilerias.sumarColumnaTablaSiCondicion(this.jTable1, 8, "IGUAL", "ANTICIPO", 22);
/*  540 */     double sumaIva = this.utilerias.sumarColumnaTabla(this.jTable1, 10);
/*  541 */     double sumaTotalAnticipo = this.utilerias.sumarColumnaTablaSiCondicion(this.jTable1, 12, "IGUAL", "ANTICIPO", 22);
/*  542 */     double sumaRet = this.utilerias.sumarColumnaTabla(this.jTable1, 11);
/*  543 */     double sumaTotal = this.utilerias.sumarColumnaTabla(this.jTable1, 12);
/*      */     
/*  545 */     double totG1 = sumaSub - otrasVentas + otrasVentas + sumaIva;
/*      */     
/*  547 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "DEV, DESC, BON", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  555 */           .convertirDoublePesos(sumaSub - otrasVentas), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  563 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTRAS VENTAS", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  571 */           .convertirDoublePesos(otrasVentas), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  579 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "IVA", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  587 */           .convertirDoublePesos(sumaIva), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  595 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  602 */           .convertirDoublePesos(sumaRet), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  611 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "CLIENTES", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  618 */           .convertirDoublePesos(sumaTotal - sumaTotalAnticipo), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  627 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "    CLIENTES ANTICIPO", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  634 */           .convertirDoublePesos(sumaTotalAnticipo), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  643 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  659 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  666 */           .convertirDoublePesos(totG1), this.utilerias
/*  667 */           .convertirDoublePesos(totG1), "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  675 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  676 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  677 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "****** INFORMACIÓN DE PRODUCTOS ******", "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  693 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "| CLAVE DE PRODUCTO |", "", "| DESCRIPCIÓN DE PRODUCTO |", "| SUB |", "| TRAS ", "| RETENIDO |", "| TOTAL |", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  709 */     consultarProductosDif();
/*      */ 
/*      */     
/*  712 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  719 */           .convertirDoublePesos(sub), this.utilerias
/*  720 */           .convertirDoublePesos(iva), this.utilerias
/*  721 */           .convertirDoublePesos(ret), this.utilerias
/*  722 */           .convertirDoublePesos(tot), "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  727 */     imprimirReportePolizas();
/*      */   }
/*      */   
/*      */   public void llenarSegundaTabla() {
/*  731 */     this.jTable8.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "folio", "fiscal", "fecha", "cliente", "sub", "iva", "ret", "total", "Tipo", "Metodo" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  738 */     this.utilerias.vaciarTabla(this.jTable9);
/*  739 */     this.LISTAFACTURAS2 = new String[this.jTable7.getRowCount()];
/*      */     
/*  741 */     for (int i = 0; i < this.jTable7.getRowCount(); i++) {
/*  742 */       String persona = this.jTable7.getValueAt(i, 20).toString();
/*  743 */       if (persona.equals("PERSONA_FISICA")) {
/*  744 */         persona = "PF";
/*  745 */       } else if (persona.equals("PERSONA_MORAL")) {
/*  746 */         persona = "PM";
/*  747 */       } else if (persona.equals("EXTRANJERO")) {
/*  748 */         persona = "EXT";
/*      */       } else {
/*  750 */         persona = "INV";
/*      */       } 
/*  752 */       this.utilerias.agregarCampoTablas(new String[] { this.jTable7
/*      */             
/*  754 */             .getValueAt(i, 0).toString(), this.jTable7
/*  755 */             .getValueAt(i, 2).toString(), this.jTable7
/*  756 */             .getValueAt(i, 3).toString(), this.jTable7
/*  757 */             .getValueAt(i, 4).toString(), this.jTable7
/*  758 */             .getValueAt(i, 5).toString(), this.jTable7
/*  759 */             .getValueAt(i, 8).toString(), this.jTable7
/*  760 */             .getValueAt(i, 10).toString(), this.jTable7
/*  761 */             .getValueAt(i, 11).toString(), this.jTable7
/*  762 */             .getValueAt(i, 12).toString(), persona, this.jTable7
/*      */             
/*  764 */             .getValueAt(i, 21).toString().substring(0, 3) }this.jTable8);
/*      */ 
/*      */       
/*  767 */       this.LISTAFACTURAS2[i] = this.jTable7.getValueAt(i, 2).toString();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarProductosDif() {
/*  772 */     Map<String, String> CantProdIva = new HashMap<>();
/*  773 */     Map<String, String> CantProdRet = new HashMap<>();
/*  774 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/*  775 */           .buscarDatos(1, "DISTINCT claveproducto", " facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and claveproducto<>'' and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.claveproducto asc"), (Object[])new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  783 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  787 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  791 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/*  792 */       CantProdIva.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*  793 */       CantProdRet.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*      */     } 
/*      */     
/*  796 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/*  797 */           .buscarDatos("claveProducto, tipoImpuesto, totalImpuesto, facturas33.folio, facturas33.fecha ,facturas33.estatus ", "facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.num asc"), (Object[])new String[] { "Clave Prod", "Tipo", "Total", "Factura", "Fecha", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  804 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  808 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/*  812 */     double valor1 = 0.0D;
/*  813 */     double valor2 = 0.0D;
/*      */     
/*  815 */     double retenidoPrueba = 0.0D;
/*  816 */     for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/*  817 */       if (((String)this.CAMPOSGENERALES.get("sucursal")).equals("POZA RICA") || ((String)this.CAMPOSGENERALES.get("sucursal")).equals("CADEREYTA")) {
/*  818 */         String folio = this.jTable5.getValueAt(j, 3).toString();
/*  819 */         for (int i1 = 0; i1 < this.jTable6.getRowCount(); i1++) {
/*  820 */           String folio2 = this.jTable6.getValueAt(i1, 2).toString();
/*  821 */           if (folio.equals(folio2) && this.jTable6.getValueAt(i1, 18).equals("USD") && !this.jTable5.getValueAt(j, 2).toString().equals("")) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  827 */       String cod = this.jTable5.getValueAt(j, 0).toString();
/*  828 */       if (!cod.equals("")) {
/*      */         
/*  830 */         String[] dat = regresaTipoImpuesto(j);
/*  831 */         if (dat != null && 
/*  832 */           dat[0].equals("TRASLADO")) {
/*  833 */           double cantAnt = this.utilerias.convertirCantTexto(CantProdIva.get(cod));
/*  834 */           double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  835 */           CantProdIva.put(cod, "" + v2);
/*  836 */           valor1 += this.utilerias.convertirCantTexto(dat[1]);
/*      */         } 
/*      */ 
/*      */         
/*  840 */         if (j < this.jTable5.getRowCount() - 1 && dat != null) {
/*      */           
/*  842 */           dat = regresaTipoImpuesto(j + 1);
/*  843 */           if (dat != null && 
/*  844 */             dat[0].equals("RETENIDO")) {
/*  845 */             double cantAnt = this.utilerias.convertirCantTexto(CantProdRet.get(cod));
/*  846 */             double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/*  847 */             CantProdRet.put(cod, "" + v2);
/*  848 */             valor2 += this.utilerias.convertirCantTexto(dat[1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  856 */     DefaultTableModel model = (DefaultTableModel)this.jTable4.getModel();
/*  857 */     model.addColumn("Descripcion");
/*  858 */     model.fireTableDataChanged();
/*  859 */     for (int k = 0; k < this.jTable4.getRowCount(); k++) {
/*  860 */       this.con.consultar("descripcion", "catproductos", "where clave = " + String.valueOf(this.jTable4.getValueAt(k, 0)));
/*  861 */       this.jTable4.setValueAt(this.con.Campo, k, 1);
/*      */     } 
/*      */     
/*  864 */     double[] cantidades = new double[this.jTable4.getRowCount()];
/*  865 */     double totalProd = 0.0D;
/*  866 */     for (int m = 0; m < this.jTable4.getRowCount(); m++) {
/*  867 */       String[] cant = this.con.regresaColIndex("importe", "facturas33, conceptosfacturas33", "where claveproducto='" + 
/*      */ 
/*      */           
/*  870 */           String.valueOf(this.jTable4.getValueAt(m, 0)) + "' and folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ")");
/*  871 */       for (int i1 = 0; i1 < cant.length; i1++) {
/*  872 */         cantidades[m] = cantidades[m] + this.utilerias.convertirCantTexto(cant[i1]);
/*  873 */         totalProd += this.utilerias.convertirCantTexto(cant[i1]);
/*      */       } 
/*      */     } 
/*      */     
/*  877 */     double iva = 0.0D;
/*  878 */     double ret = 0.0D;
/*  879 */     double tot = 0.0D;
/*      */     int n;
/*  881 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/*  882 */       String cod = CantProdIva.get(this.jTable4.getValueAt(n, 0).toString());
/*  883 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod)), n, 2);
/*      */       
/*  885 */       String cod2 = CantProdRet.get(this.jTable4.getValueAt(n, 0).toString());
/*  886 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod2)), n, 3);
/*      */     } 
/*      */     
/*  889 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/*  890 */       double suma = cantidades[n] + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 2).toString()) - this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 3).toString());
/*      */       
/*  892 */       this.utilerias.agregarCampoTablas(new String[] { "", "", this.jTable4
/*      */ 
/*      */ 
/*      */             
/*  896 */             .getValueAt(n, 0).toString(), "", this.jTable4
/*      */             
/*  898 */             .getValueAt(n, 1).toString(), this.utilerias
/*  899 */             .convertirDoublePesos(cantidades[n]), this.jTable4
/*  900 */             .getValueAt(n, 2).toString(), this.jTable4
/*  901 */             .getValueAt(n, 3).toString(), this.utilerias
/*  902 */             .convertirDoublePesos(suma), "", "" }this.jTable2);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  909 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  925 */     double totGral = totalProd + iva - ret;
/*      */   }
/*      */   
/*      */   public double sacarSumaTipoAnticipo() {
/*  929 */     double sum = 0.0D;
/*  930 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/*  931 */       String col = this.jTable1.getValueAt(i, 22).toString();
/*  932 */       if (col.equals("ANTICIPO")) {
/*  933 */         sum += this.utilerias.convertirCantTexto(this.jTable1.getValueAt(i, 12).toString());
/*      */       }
/*      */     } 
/*  936 */     return sum;
/*      */   }
/*      */   
/*      */   public String[] regresaTipoImpuesto(int reg) {
/*  940 */     String[] datos = { "", "" };
/*  941 */     String cant = "";
/*      */     
/*  943 */     if (reg < this.jTable5.getRowCount() - 1) {
/*  944 */       String tipo = this.jTable5.getValueAt(reg + 1, 1).toString();
/*      */       
/*  946 */       if (!tipo.equals("")) {
/*  947 */         cant = this.jTable5.getValueAt(reg + 1, 2).toString();
/*  948 */         datos[0] = tipo;
/*  949 */         datos[1] = cant;
/*      */       } else {
/*  951 */         return null;
/*      */       } 
/*      */     } 
/*  954 */     return datos;
/*      */   }
/*      */   
/*      */   public void insertarRenglonLineas() {
/*  958 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "" }, this.jTable2);
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
/*  976 */     String consulta = ""; int i;
/*  977 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/*  978 */       consulta = consulta + " conceptosfacturas33.numfactura = '" + consulta + "' ";
/*  979 */       if (i + 1 < this.LISTAFACTURAS.length) {
/*  980 */         consulta = consulta + " || ";
/*      */       }
/*      */     } 
/*  983 */     this.CONSULTARLISTARPRODUCTOS = consulta;
/*  984 */     this.utilerias.consultaGralTabla(this.con, this.jTable3, new String[] { "clave", "importe", "numFactura" }, "claveproducto, importe, numfactura", "conceptosfacturas33", "where (" + consulta + ") and claveproducto <>'' ");
/*      */     
/*  986 */     consulta = "";
/*  987 */     for (i = 0; i < this.jTable7.getRowCount(); i++) {
/*  988 */       consulta = consulta + " conceptosfacturas33.numfactura = '" + consulta + "' ";
/*  989 */       if (i + 1 < this.LISTAFACTURAS2.length) {
/*  990 */         consulta = consulta + " || ";
/*      */       }
/*      */     } 
/*      */     
/*  994 */     this.utilerias.consultaGralTabla(this.con, this.jTable9, new String[] { "clave", "importe", "numFactura" }, "claveproducto, importe, numfactura", "conceptosfacturas33", "where (" + consulta + ") and claveproducto <>'' ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1012 */     this.jEditorPane1.setText("select claveproducto, importe, numfactura from  conceptosfacturas33 where (" + consulta + ") and claveproducto <>'' order by numFactura desc");
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarPrimeroVentasFletes() {
/* 1017 */     double fletesRetencion = 0.0D;
/* 1018 */     int cont = 0;
/* 1019 */     for (int i = 0; i < this.jTable8.getRowCount(); i++) {
/* 1020 */       String folio = this.jTable8.getValueAt(i, 1).toString();
/* 1021 */       String iva = this.jTable8.getValueAt(i, 6).toString();
/* 1022 */       String ret = this.jTable8.getValueAt(i, 7).toString();
/* 1023 */       String tipo = this.jTable8.getValueAt(i, 9).toString();
/*      */       
/* 1025 */       if (!iva.equals("$0.00") && !ret.equals("$0.00") && tipo.equals("PM")) {
/* 1026 */         for (int j = 0; j < this.jTable9.getRowCount(); j++) {
/* 1027 */           String codigo = this.jTable9.getValueAt(j, 0).toString();
/* 1028 */           String fact = this.jTable9.getValueAt(j, 2).toString();
/* 1029 */           if ((fact.equals(folio) && codigo.equals("78101800")) || (fact.equals(folio) && codigo.equals("78101801")) || (fact.equals(folio) && codigo.equals("78101802"))) {
/* 1030 */             cont++;
/* 1031 */             fletesRetencion += this.utilerias.convertirCantTexto(this.jTable9.getValueAt(j, 1).toString());
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1038 */     this.FLETESCR = fletesRetencion;
/*      */     
/* 1040 */     System.out.println("entra primer");
/* 1041 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS FLETES C/RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1048 */           .convertirDoublePesos(fletesRetencion), "", "", "", "", "" }, this.jTable2);
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
/* 1060 */     double fletesSinRetencion = 0.0D;
/* 1061 */     for (int i = 0; i < this.jTable8.getRowCount(); i++) {
/* 1062 */       String folio = this.jTable8.getValueAt(i, 1).toString();
/* 1063 */       String iva = this.jTable8.getValueAt(i, 6).toString();
/* 1064 */       String ret = this.jTable8.getValueAt(i, 7).toString();
/* 1065 */       String tipo = this.jTable8.getValueAt(i, 9).toString();
/*      */       
/* 1067 */       String cliente = this.jTable8.getValueAt(i, 4).toString();
/*      */       
/* 1069 */       if ((cliente.equals("GSM - BRONCO S. A. DE C. V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1070 */         .equals("DOWELL SCHLUMBERGER DE MEXICO, S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1071 */         .equals("BAKER HUGHES OPERATIONS MEXICO S. DE R.L. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1072 */         .equals("CLEANMEX ENERGY SERVICES S DE RL DE CV") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1073 */         .equals("CAPITAL CARGO DEL GOLFO S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1074 */         .equals("ENERGY DRILLING MARINE SERVICES S.A.P. DE I. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || ret
/*      */         
/* 1076 */         .equals("$0.00")) {
/* 1077 */         for (int j = 0; j < this.jTable9.getRowCount(); j++) {
/* 1078 */           String codigo = this.jTable9.getValueAt(j, 0).toString();
/* 1079 */           String fact = this.jTable9.getValueAt(j, 2).toString();
/* 1080 */           if (fact.equals(folio) && (codigo.equals("78101800") || codigo.equals("78101801") || codigo.equals("78101802") || codigo.equals("76122401")))
/*      */           {
/* 1082 */             fletesSinRetencion += this.utilerias.convertirCantTexto(this.jTable9.getValueAt(j, 1).toString());
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
/* 1093 */     this.FLETESSR = fletesSinRetencion;
/* 1094 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS FLETES SIN/RETENCIÓN", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1101 */           .convertirDoublePesos(fletesSinRetencion), "", "", "", "", "" }, this.jTable2);
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
/* 1113 */     this.INGRESOSACTIVOFIJO = 0.0D;
/* 1114 */     for (int j = 0; j < this.jTable9.getRowCount(); j++) {
/* 1115 */       String codigo = this.jTable9.getValueAt(j, 0).toString();
/* 1116 */       String fact = this.jTable9.getValueAt(j, 2).toString();
/* 1117 */       if (codigo.equals("25101600") || codigo.equals("25101503") || codigo.equals("25101500"))
/*      */       {
/*      */         
/* 1120 */         this.INGRESOSACTIVOFIJO += this.utilerias.convertirCantTexto(this.jTable9.getValueAt(j, 1).toString());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1125 */     this.FLETESO = this.FLETESSUB - this.FLETESCR + this.FLETESSR + this.INGRESOSACTIVOFIJO;
/*      */     
/* 1127 */     if (this.FLETESO < 2.0D) {
/* 1128 */       this.FLETESO = 0.0D;
/*      */     }
/*      */     
/* 1131 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTRAS VENTAS", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1138 */           .convertirDoublePesos(this.FLETESO), "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1147 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "INRGESOS POR VENTA DE ACTIVO FIJO", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1154 */           .convertirDoublePesos(this.INGRESOSACTIVOFIJO), "", "", "", "", "" }, this.jTable2);
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
/* 1166 */     JTable aux = crearTablaAux2(this.jTable2, new Object[] { "cont", "Folio", "Fiscal", "Fecha", "Cliente", "Sub", "Iva", "Ret", "Tot", "Tipo", "Met" });
/* 1167 */     this.utilerias.quitarSignoPesosTabla(aux);
/* 1168 */     Map<Object, Object> datos = new HashMap<>();
/* 1169 */     this.utilerias.cargarImagenesAReporte(datos);
/* 1170 */     datos.put("sucursal", ((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 1171 */     datos.put("periodo", this.etiquetaFecha);
/* 1172 */     datos.put("cliente", "TODOS");
/* 1173 */     datos.put("estado", "CANCELADAS");
/* 1174 */     datos.put("titulo", "REPORTE DE PÓLIZAS PARA NOTAS DE CRÉDITO CANCELADAS " + this.MONEDA);
/* 1175 */     datos.put("documento", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/*      */     
/*      */     try {
/* 1178 */       this.utilerias.verImpresion("/Reportes/Facturacion/PolizasPeriodo.jasper", aux, datos, "REPORTE DE PÓLIZAS - NOTAS DE CŔEDITO" + this.MONEDA);
/* 1179 */     } catch (JRException ex) {
/* 1180 */       Logger.getLogger(Facturas33PeriodoNotasCreditoCanceladas.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String convertirFechaATexto(String fecha) {
/* 1185 */     String fechaCorta = fecha.substring(0, 10);
/* 1186 */     String año = fechaCorta.substring(0, 4);
/* 1187 */     String mes = fechaCorta.substring(5, 7);
/* 1188 */     String dia = fechaCorta.substring(8, 10);
/* 1189 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 1190 */     return strFecha;
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 1194 */     String canti = cant;
/* 1195 */     String valorP = "";
/* 1196 */     for (int j = 0; j < canti.length(); j++) {
/* 1197 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 1198 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 1201 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public static int calcularRegistrosParaMultiplo(int registros, int multiplo) {
/* 1205 */     int residuo = registros % multiplo;
/* 1206 */     return (residuo == 0) ? 0 : (multiplo - residuo);
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux2(JTable Original, Object[] columnas) {
/* 1210 */     Object[] Columnas = columnas;
/* 1211 */     Object[][] registros = new Object[Original.getRowCount()][columnas.length];
/* 1212 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 1213 */       registros[i][0] = Integer.valueOf(i + 1);
/* 1214 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 1215 */         if (j == 0) {
/* 1216 */           registros[i][0] = Original.getValueAt(i, j);
/*      */         }
/* 1218 */         if (j == 1) {
/* 1219 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 1221 */         if (j == 2) {
/* 1222 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/*      */         
/* 1225 */         if (j == 3) {
/* 1226 */           if (!Original.getValueAt(i, j).toString().equals("")) {
/* 1227 */             registros[i][3] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */           } else {
/* 1229 */             registros[i][3] = "";
/*      */           } 
/*      */         }
/* 1232 */         if (j == 4) {
/*      */           
/*      */           try {
/* 1235 */             registros[i][4] = Original.getValueAt(i, j);
/* 1236 */           } catch (NumberFormatException e) {
/* 1237 */             registros[i][4] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */         
/* 1241 */         if (j == 5) {
/*      */           
/*      */           try {
/* 1244 */             registros[i][5] = Original.getValueAt(i, j);
/* 1245 */           } catch (NumberFormatException e) {
/* 1246 */             registros[i][5] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1249 */         if (j == 6) {
/*      */           
/*      */           try {
/* 1252 */             registros[i][6] = Original.getValueAt(i, j);
/* 1253 */           } catch (NumberFormatException e) {
/* 1254 */             registros[i][6] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1257 */         if (j == 7) {
/*      */           
/*      */           try {
/* 1260 */             registros[i][7] = Original.getValueAt(i, j);
/* 1261 */           } catch (NumberFormatException e) {
/* 1262 */             registros[i][7] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1265 */         if (j == 8) {
/*      */           
/*      */           try {
/* 1268 */             registros[i][8] = Original.getValueAt(i, j);
/* 1269 */           } catch (NumberFormatException e) {
/* 1270 */             registros[i][8] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1273 */         if (j == 9) {
/*      */           
/*      */           try {
/* 1276 */             registros[i][9] = Original.getValueAt(i, j);
/* 1277 */           } catch (NumberFormatException e) {
/* 1278 */             registros[i][9] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1281 */         if (j == 10) {
/*      */           
/*      */           try {
/* 1284 */             registros[i][10] = Original.getValueAt(i, j);
/* 1285 */           } catch (NumberFormatException e) {
/* 1286 */             registros[i][10] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1291 */     JTable aux = new JTable(registros, Columnas);
/* 1292 */     return aux;
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Facturas33PeriodoNotasCreditoCanceladas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */