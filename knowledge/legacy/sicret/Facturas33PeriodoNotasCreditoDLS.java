/*      */ package sicret;
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
/*      */ public class Facturas33PeriodoNotasCreditoDLS extends JDialog {
/*   29 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   30 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   31 */   Consultas2 con = new Consultas2();
/*      */   Date fecha1;
/*      */   Date fecha2;
/*      */   String MONEDA;
/*      */   String TIPO;
/*   36 */   Utilerias utilerias = new Utilerias();
/*      */   String[] LISTAFACTURAS;
/*      */   String[] LISTAFACTURAS2;
/*   39 */   double FLETESCR = 0.0D;
/*   40 */   double FLETESSR = 0.0D;
/*   41 */   double FLETESO = 0.0D;
/*   42 */   double FLETESSUB = 0.0D;
/*   43 */   double INGRESOSACTIVOFIJO = 0.0D;
/*   44 */   String CONSULTARLISTARPRODUCTOS = "";
/*      */   Map<String, String> CAMPOSGENERALES;
/*   46 */   int multiplo = 28; JComboBox MES; JComboBox AÑO; private JDialog jDialog1; private JEditorPane jEditorPane1; private JEditorPane jEditorPane2; private JLabel jLabel1; private JLabel jLabel2; private JLabel jLabel3;
/*      */   private JLabel jLabel4;
/*      */   private JScrollPane jScrollPane1;
/*   49 */   String etiquetaFecha = ""; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane12; private JScrollPane jScrollPane13; private JScrollPane jScrollPane14; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4;
/*      */   
/*      */   public Facturas33PeriodoNotasCreditoDLS(Map<String, String> CAMPOSGENERALES, Consultas2 con, Date fecha1, Date fecha2, String MONEDA, String TIPO, JComboBox MES, JComboBox AÑO) {
/*   52 */     initComponents();
/*   53 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   54 */     this.con = con;
/*   55 */     this.fecha1 = fecha1;
/*   56 */     this.fecha2 = fecha2;
/*   57 */     this.MONEDA = MONEDA;
/*   58 */     this.TIPO = TIPO;
/*   59 */     this.MES = MES;
/*   60 */     this.AÑO = AÑO;
/*   61 */     System.out.println("*** NOTAS DE CRÉDITO (ACTIVAS) DLS **** " + String.valueOf(this.MES.getSelectedItem()));
/*      */     
/*   63 */     this.utilerias.vaciarTabla(this.jTable1);
/*   64 */     this.utilerias.vaciarTabla(this.jTable2);
/*   65 */     this.utilerias.vaciarTabla(this.jTable3);
/*   66 */     this.utilerias.vaciarTabla(this.jTable4);
/*   67 */     this.utilerias.vaciarTabla(this.jTable5);
/*   68 */     this.utilerias.vaciarTabla(this.jTable6);
/*   69 */     consultarFacturasGral();
/*   70 */     this.utilerias.activarVentanajDialog(this.jDialog1, 1100, 800);
/*      */   }
/*      */   private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JTable jTable1; private JTable jTable10; private JTable jTable11; private JTable jTable12; private JTable jTable2; private JTable jTable3; private JTable jTable4; private JTable jTable5;
/*      */   private JTable jTable6;
/*      */   private JTable jTable7;
/*      */   private JTable jTable8;
/*      */   private JTable jTable9;
/*      */   
/*      */   private void initComponents() {
/*   79 */     this.jDialog1 = new JDialog();
/*   80 */     this.jScrollPane8 = new JScrollPane();
/*   81 */     this.jTable7 = new JTable();
/*   82 */     this.jScrollPane9 = new JScrollPane();
/*   83 */     this.jTable8 = new JTable();
/*   84 */     this.jScrollPane10 = new JScrollPane();
/*   85 */     this.jTable9 = new JTable();
/*   86 */     this.jScrollPane11 = new JScrollPane();
/*   87 */     this.jEditorPane2 = new JEditorPane();
/*   88 */     this.jLabel3 = new JLabel();
/*   89 */     this.jScrollPane12 = new JScrollPane();
/*   90 */     this.jTable10 = new JTable();
/*   91 */     this.jScrollPane13 = new JScrollPane();
/*   92 */     this.jTable11 = new JTable();
/*   93 */     this.jScrollPane14 = new JScrollPane();
/*   94 */     this.jTable12 = new JTable();
/*   95 */     this.jLabel4 = new JLabel();
/*   96 */     this.jScrollPane1 = new JScrollPane();
/*   97 */     this.jTable1 = new JTable();
/*   98 */     this.jScrollPane2 = new JScrollPane();
/*   99 */     this.jTable2 = new JTable();
/*  100 */     this.jScrollPane3 = new JScrollPane();
/*  101 */     this.jTable3 = new JTable();
/*  102 */     this.jScrollPane4 = new JScrollPane();
/*  103 */     this.jEditorPane1 = new JEditorPane();
/*  104 */     this.jLabel1 = new JLabel();
/*  105 */     this.jScrollPane5 = new JScrollPane();
/*  106 */     this.jTable4 = new JTable();
/*  107 */     this.jScrollPane6 = new JScrollPane();
/*  108 */     this.jTable5 = new JTable();
/*  109 */     this.jScrollPane7 = new JScrollPane();
/*  110 */     this.jTable6 = new JTable();
/*  111 */     this.jLabel2 = new JLabel();
/*      */     
/*  113 */     this.jDialog1.setDefaultCloseOperation(2);
/*      */     
/*  115 */     this.jTable7.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  126 */     this.jScrollPane8.setViewportView(this.jTable7);
/*      */     
/*  128 */     this.jTable8.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  139 */     this.jScrollPane9.setViewportView(this.jTable8);
/*      */     
/*  141 */     this.jTable9.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  152 */     this.jScrollPane10.setViewportView(this.jTable9);
/*      */     
/*  154 */     this.jScrollPane11.setViewportView(this.jEditorPane2);
/*      */     
/*  156 */     this.jLabel3.setText("Total de datos:");
/*      */     
/*  158 */     this.jTable10.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  169 */     this.jScrollPane12.setViewportView(this.jTable10);
/*      */     
/*  171 */     this.jTable11.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  182 */     this.jScrollPane13.setViewportView(this.jTable11);
/*      */     
/*  184 */     this.jTable12.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  195 */     this.jScrollPane14.setViewportView(this.jTable12);
/*      */     
/*  197 */     this.jLabel4.setText("Total de datos:");
/*      */     
/*  199 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  200 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  201 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  202 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  203 */         .addComponent(this.jScrollPane8)
/*  204 */         .addComponent(this.jScrollPane12, -1, 1167, 32767)
/*  205 */         .addComponent(this.jScrollPane13, -1, 1167, 32767)
/*  206 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  207 */           .addContainerGap()
/*  208 */           .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  209 */             .addGroup(jDialog1Layout.createSequentialGroup()
/*  210 */               .addComponent(this.jLabel3, -2, 397, -2)
/*  211 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  212 */               .addComponent(this.jLabel4, -2, 397, -2))
/*  213 */             .addComponent(this.jScrollPane11, -2, 0, 32767))
/*  214 */           .addContainerGap())
/*  215 */         .addComponent(this.jScrollPane10)
/*  216 */         .addComponent(this.jScrollPane14, -1, 1167, 32767)
/*  217 */         .addComponent(this.jScrollPane9, GroupLayout.Alignment.TRAILING));
/*      */     
/*  219 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  220 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  221 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  222 */           .addContainerGap()
/*  223 */           .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  224 */             .addComponent(this.jLabel3)
/*  225 */             .addComponent(this.jLabel4))
/*  226 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  227 */           .addComponent(this.jScrollPane8, -2, 100, -2)
/*  228 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  229 */           .addComponent(this.jScrollPane9, -2, 126, -2)
/*  230 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  231 */           .addComponent(this.jScrollPane10, -2, 153, -2)
/*  232 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  233 */           .addComponent(this.jScrollPane12, -2, 100, -2)
/*  234 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  235 */           .addComponent(this.jScrollPane13, -2, 88, -2)
/*  236 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  237 */           .addComponent(this.jScrollPane14, -1, 136, 32767)
/*  238 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  239 */           .addComponent(this.jScrollPane11, -2, 81, -2)
/*  240 */           .addContainerGap()));
/*      */ 
/*      */     
/*  243 */     setDefaultCloseOperation(2);
/*      */     
/*  245 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },  }, (Object[])new String[] { "num", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retencion", "Total", "Debe", "Estatus", "Documento", "Version", "Meneda", "Tipo Cambio", "persona", "Pago", "Tipo" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  256 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  258 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  269 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/*  271 */     this.jTable3.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  282 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/*  284 */     this.jScrollPane4.setViewportView(this.jEditorPane1);
/*      */     
/*  286 */     this.jLabel1.setText("Total de datos:");
/*      */     
/*  288 */     this.jTable4.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  299 */     this.jScrollPane5.setViewportView(this.jTable4);
/*      */     
/*  301 */     this.jTable5.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  312 */     this.jScrollPane6.setViewportView(this.jTable5);
/*      */     
/*  314 */     this.jTable6.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  325 */     this.jScrollPane7.setViewportView(this.jTable6);
/*      */     
/*  327 */     this.jLabel2.setText("Total de datos:");
/*      */     
/*  329 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  330 */     getContentPane().setLayout(layout);
/*  331 */     layout.setHorizontalGroup(layout
/*  332 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  333 */         .addComponent(this.jScrollPane1)
/*  334 */         .addComponent(this.jScrollPane5, -1, 1167, 32767)
/*  335 */         .addComponent(this.jScrollPane6, -1, 1167, 32767)
/*  336 */         .addGroup(layout.createSequentialGroup()
/*  337 */           .addContainerGap()
/*  338 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  339 */             .addGroup(layout.createSequentialGroup()
/*  340 */               .addComponent(this.jLabel1, -2, 397, -2)
/*  341 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  342 */               .addComponent(this.jLabel2, -2, 397, -2))
/*  343 */             .addComponent(this.jScrollPane4, -2, 0, 32767))
/*  344 */           .addContainerGap())
/*  345 */         .addComponent(this.jScrollPane3)
/*  346 */         .addComponent(this.jScrollPane7, -1, 1167, 32767)
/*  347 */         .addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING));
/*      */     
/*  349 */     layout.setVerticalGroup(layout
/*  350 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  351 */         .addGroup(layout.createSequentialGroup()
/*  352 */           .addContainerGap()
/*  353 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  354 */             .addComponent(this.jLabel1)
/*  355 */             .addComponent(this.jLabel2))
/*  356 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  357 */           .addComponent(this.jScrollPane1, -2, 100, -2)
/*  358 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  359 */           .addComponent(this.jScrollPane2, -2, 126, -2)
/*  360 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  361 */           .addComponent(this.jScrollPane3, -2, 153, -2)
/*  362 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  363 */           .addComponent(this.jScrollPane5, -2, 100, -2)
/*  364 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  365 */           .addComponent(this.jScrollPane6, -2, 88, -2)
/*  366 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  367 */           .addComponent(this.jScrollPane7, -1, 136, 32767)
/*  368 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  369 */           .addComponent(this.jScrollPane4, -2, 81, -2)
/*  370 */           .addContainerGap()));
/*      */ 
/*      */     
/*  373 */     pack();
/*      */   }
/*      */   
/*      */   public void consultarFacturasGral() {
/*  377 */     String fechaCompleta1 = "";
/*  378 */     String fechaCompleta2 = "";
/*  379 */     String consultaFecha = "";
/*  380 */     if (this.MES.getSelectedIndex() != 0) {
/*  381 */       String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*      */       
/*  383 */       int aa = Integer.parseInt(this.AÑO.getSelectedItem().toString());
/*  384 */       consultaFecha = " and  date_format( fecha, '%m-%Y') = '" + mes[this.MES.getSelectedIndex()] + "-" + aa + "' ";
/*  385 */       this.etiquetaFecha = this.MES.getSelectedItem().toString();
/*      */     } else {
/*  387 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  388 */       String cadenaFecha = "";
/*  389 */       cadenaFecha = formato.format(this.fecha1);
/*  390 */       String AÑO = cadenaFecha.substring(0, 4);
/*  391 */       String MES = cadenaFecha.substring(4, 6);
/*  392 */       String DIA = cadenaFecha.substring(6, 8);
/*  393 */       fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*  394 */       this.etiquetaFecha = DIA + "/" + DIA + "/" + MES;
/*  395 */       cadenaFecha = formato.format(this.fecha2);
/*  396 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/*  397 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/*  398 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/*  399 */       this.etiquetaFecha = this.etiquetaFecha + " AL " + this.etiquetaFecha + "/" + dd + "/" + mm;
/*  400 */       fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/*  401 */       consultaFecha = " and fecha between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     } 
/*  403 */     System.out.println("Periodo " + String.valueOf(this.MES.getSelectedItem()));
/*  404 */     String motivo = "";
/*  405 */     if (!this.MES.getSelectedItem().toString().equals("PERIODO LIBRE")) {
/*  406 */       motivo = " and motivo = ''";
/*      */     }
/*      */     
/*  409 */     this.utilerias.consultaGralTabla(this.con, this.jTable1, new String[] { "Núm", "Tipo", "Folio", "Fecha", "Cliente", "Subtotal", "Iva", "Retención", "Total", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo", "tipoCambio", "TipoCambioReal" }, "numFactura,tipo,folio,fecha,cliente,subtotal,iva,retencion,total, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura, tipoCambio, tipoCambioReal", "facturas33", "WHERE tipo = '" + this.TIPO + "' and  moneda = '" + this.MONEDA + "'" + consultaFecha + " " + motivo);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  420 */     this.utilerias.consultaGralTabla(this.con, this.jTable7, new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "", "Moneda", "Tipo Camboio", "personaTipo", "pagoMetodo", "Tipo" }, "numFactura,tipo,folio,fecha,cliente,subtotal,iva,retencion,total, moneda, tipoCambio,personaTipo, pagoMetodo, tipoFactura, tipoCambio, tipoCambioReal", "facturas33", "f JOIN relacion r ON f.folio = r.folioRelacionado WHERE r.folioRelacionado IN ( SELECT r.folioRelacionado FROM facturas33 f JOIN relacion r ON f.folio = r.folioRelacion WHERE f.tipo = 'NC' " + motivo + " AND r.folioRelacionado LIKE '" + (String)this.CAMPOSGENERALES
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  433 */         .get("folioFacturas") + "%' " + consultaFecha + ") ORDER BY f.folio DESC");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  438 */     if (this.jTable1.getRowCount() < 1) {
/*  439 */       JOptionPane.showMessageDialog(this, "No existen datos en ese periodo seleccionado", "No hay datos", 0, this.ADVER);
/*      */       
/*      */       return;
/*      */     } 
/*  443 */     this.jLabel1.setText("Total de datos: " + this.jTable1.getRowCount());
/*  444 */     DefaultTableModel model = (DefaultTableModel)this.jTable1.getModel();
/*  445 */     DefaultTableModel model1 = (DefaultTableModel)this.jTable7.getModel();
/*  446 */     model.addColumn("tipoCambioActualizado"); int i;
/*  447 */     for (i = 0; i < model.getRowCount(); i++) {
/*  448 */       model.setValueAt(Integer.valueOf(i + 1), i, 0);
/*      */       
/*  450 */       String tipoCambio = model.getValueAt(i, 10).toString();
/*  451 */       String tipoCambioReal = model.getValueAt(i, 15).toString();
/*      */       
/*  453 */       if (!tipoCambioReal.equals("")) {
/*  454 */         model.setValueAt(tipoCambioReal, i, 16);
/*  455 */         model1.setValueAt(tipoCambioReal, i, 16);
/*      */       } else {
/*  457 */         model.setValueAt(tipoCambio, i, 16);
/*  458 */         model1.setValueAt(tipoCambio, i, 16);
/*      */       } 
/*      */     } 
/*      */     
/*  462 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Folio", "Fecha", "Cliente", "Sub", "Iva", "Ret", "Tot", "Cambio", "Tipo", "Met" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  469 */     this.utilerias.vaciarTabla(this.jTable3);
/*  470 */     this.LISTAFACTURAS = new String[this.jTable1.getRowCount()];
/*  471 */     this.LISTAFACTURAS2 = new String[this.jTable7.getRowCount()];
/*      */     
/*  473 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/*  474 */       String persona = this.jTable1.getValueAt(i, 11).toString();
/*  475 */       if (persona.equals("PERSONA_FISICA")) {
/*  476 */         persona = "PF";
/*  477 */       } else if (persona.equals("PERSONA_MORAL")) {
/*  478 */         persona = "PM";
/*  479 */       } else if (persona.equals("EXTRANJERO")) {
/*  480 */         persona = "EXT";
/*      */       } else {
/*  482 */         persona = "INV";
/*      */       } 
/*  484 */       this.utilerias.agregarCampoTablas(new String[] { this.jTable1
/*      */             
/*  486 */             .getValueAt(i, 0).toString(), this.jTable1
/*  487 */             .getValueAt(i, 2).toString(), 
/*      */             
/*  489 */             convertirFechaATexto(this.jTable1.getValueAt(i, 3).toString()), this.jTable1
/*  490 */             .getValueAt(i, 4).toString(), this.jTable1
/*  491 */             .getValueAt(i, 5).toString(), this.jTable1
/*  492 */             .getValueAt(i, 6).toString(), this.jTable1
/*  493 */             .getValueAt(i, 7).toString(), this.jTable1
/*  494 */             .getValueAt(i, 8).toString(), this.jTable1
/*  495 */             .getValueAt(i, 10).toString(), persona, this.jTable1
/*      */             
/*  497 */             .getValueAt(i, 12).toString().substring(0, 3), this.jTable1
/*  498 */             .getValueAt(i, 16).toString() }this.jTable2);
/*      */ 
/*      */       
/*  501 */       this.LISTAFACTURAS[i] = this.jTable1.getValueAt(i, 2).toString();
/*      */     } 
/*      */     
/*  504 */     llenarSegundaTabla();
/*  505 */     agregarColumnasMXN();
/*  506 */     llenarPesos();
/*  507 */     ordenarColumnas();
/*      */     
/*  509 */     double sub = this.utilerias.sumarColumnaTabla(this.jTable2, 4);
/*  510 */     double iva = this.utilerias.sumarColumnaTabla(this.jTable2, 5);
/*  511 */     double ret = this.utilerias.sumarColumnaTabla(this.jTable2, 6);
/*  512 */     double tot = this.utilerias.sumarColumnaTabla(this.jTable2, 7);
/*      */     
/*  514 */     double subMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 9);
/*  515 */     double ivaMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 10);
/*  516 */     double retMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 11);
/*  517 */     double totMXN = this.utilerias.sumarColumnaTabla(this.jTable2, 12);
/*      */ 
/*      */ 
/*      */     
/*  521 */     double otrasVentas = sumarColumnaTablaSiCondicion(this.jTable1, 9, "IGUAL", "ANTICIPO", 13);
/*  522 */     double sumaIva = this.utilerias.sumarColumnaTabla(this.jTable1, 10);
/*  523 */     double sumaTotalAnticipo = this.utilerias.sumarColumnaTablaSiCondicion(this.jTable1, 8, "IGUAL", "ANTICIPO", 13);
/*  524 */     double sumaRet = this.utilerias.sumarColumnaTabla(this.jTable1, 7);
/*  525 */     double sumaTotal = this.utilerias.sumarColumnaTabla(this.jTable1, 8);
/*      */     
/*  527 */     if (this.jTable2.getRowCount() > 0) {
/*  528 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  529 */       this.utilerias.agregarCampoTablas(new String[] { "", "", "", 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  534 */             String.valueOf(this.jTable2.getValueAt(0, 1)) + " / " + String.valueOf(this.jTable2.getValueAt(0, 1)), "", "", "", "", "", "", "", "", "", "", "" }this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  547 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     } 
/*  549 */     insertarRenglonLineas();
/*  550 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "SUMAS: ", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  556 */           .convertirDoublePesos(sub), this.utilerias
/*  557 */           .convertirDoublePesos(iva), this.utilerias
/*  558 */           .convertirDoublePesos(ret), this.utilerias
/*  559 */           .convertirDoublePesos(tot), "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */           
/*  563 */           .convertirDoublePesos(subMXN), this.utilerias
/*  564 */           .convertirDoublePesos(ivaMXN), this.utilerias
/*  565 */           .convertirDoublePesos(retMXN), this.utilerias
/*  566 */           .convertirDoublePesos(totMXN) }, this.jTable2);
/*      */ 
/*      */ 
/*      */     
/*  570 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  572 */     int registrosParaAgregar = calcularRegistrosParaMultiplo(this.jTable2.getRowCount(), this.multiplo);
/*  573 */     int reg = registrosParaAgregar;
/*  574 */     for (int j = 0; j < reg; j++) {
/*  575 */       this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     }
/*      */     
/*  578 */     sacarListaProductos();
/*  579 */     sacarPrimeroVentasFletes();
/*  580 */     sacarSegundoVentasFletes();
/*  581 */     sacarTerceroVentasFletes();
/*      */     
/*  583 */     double sumaClientesDLS = 0.0D;
/*  584 */     ArrayList<String> clientes = obtenerClientesUnicos();
/*      */     
/*  586 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*  587 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  589 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "DEV, DESC, BON", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  596 */           .convertirDoublePesos(subMXN - otrasVentas), "", "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  608 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTRAS VENTAS", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  615 */           .convertirDoublePesos(otrasVentas), "", "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  628 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "IVA", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  635 */           .convertirDoublePesos(ivaMXN), "", "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  648 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "RETENCIÓN", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  656 */           .convertirDoublePesos(retMXN), "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  668 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "CLIENTES", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  676 */           .convertirDoublePesos(sumaTotal - sumaTotalAnticipo), "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  688 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "CLIENTES ANTICIPO", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  696 */           .convertirDoublePesos(sumaTotalAnticipo), "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  708 */     double complementaria = totMXN - sumaTotal - sumaTotalAnticipo - sacarSumaTipoAnticipo();
/*  709 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "COMPLEMENTARIA DLS", "", "", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  717 */           .convertirDoublePesos(complementaria), "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  729 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  748 */     double sumasDLS = subMXN + ivaMXN;
/*  749 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "SUMAS", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  756 */           .convertirDoublePesos(sumasDLS), this.utilerias
/*  757 */           .convertirDoublePesos(sumasDLS), "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  769 */     this.utilerias.agregarCampoTablasVacios(this.jTable2);
/*      */     
/*  771 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "****** PRODUCTOS ******", "", "", "", "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  791 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "| CLAVE |", "| DESCRIPCIÓN |", "| SUB |", "| TRAS ", "| RETENIDO |", "| TOTAL |", "", "", "", "| SUB MXN |", "| TRAS MXN |", "| RETENIDO MXN |", "| TOTAL MXN |" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  811 */     consultarProductosDif();
/*      */ 
/*      */     
/*  814 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "SUMAS: ", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  820 */           .convertirDoublePesos(sub), this.utilerias
/*  821 */           .convertirDoublePesos(iva), this.utilerias
/*  822 */           .convertirDoublePesos(ret), this.utilerias
/*  823 */           .convertirDoublePesos(tot), "", "", "", this.utilerias
/*      */           
/*  825 */           .convertirDoublePesos(subMXN), this.utilerias
/*  826 */           .convertirDoublePesos(ivaMXN), this.utilerias
/*  827 */           .convertirDoublePesos(retMXN), this.utilerias
/*  828 */           .convertirDoublePesos(totMXN) }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  833 */     imprimirReportePolizas();
/*      */   }
/*      */   
/*      */   public ArrayList<String> obtenerClientesUnicos() {
/*  837 */     Set<String> clientesUnicosOrdenados = new TreeSet<>();
/*  838 */     TableModel model = this.jTable1.getModel();
/*      */ 
/*      */     
/*  841 */     int columnaCliente = 4;
/*      */ 
/*      */     
/*  844 */     for (int i = 0; i < model.getRowCount(); i++) {
/*  845 */       String cliente = model.getValueAt(i, columnaCliente).toString();
/*  846 */       clientesUnicosOrdenados.add(cliente);
/*      */     } 
/*      */     
/*  849 */     return new ArrayList<>(clientesUnicosOrdenados);
/*      */   }
/*      */   
/*      */   public double sumarOtrasVentas(JTable Tabla, int Col) {
/*  853 */     double suma = 0.0D;
/*  854 */     for (int i = 0; i < Tabla.getRowCount(); i++) {
/*  855 */       suma += convertirCantTexto(this.jTable2.getValueAt(i, Col).toString());
/*      */     }
/*  857 */     return suma;
/*      */   }
/*      */ 
/*      */   
/*      */   public double sumarColumnaTablaSiCondicion(JTable Tabla, int ColSuma, String Condicion, String Valor, int ColBuscar) {
/*  862 */     double suma = 0.0D;
/*  863 */     for (int i = 0; i < Tabla.getRowCount(); i++) {
/*  864 */       if (Condicion.equals("IGUAL")) {
/*  865 */         String contenido = Tabla.getValueAt(i, ColBuscar).toString();
/*      */         
/*  867 */         if (contenido.equals(Valor))
/*      */         {
/*  869 */           suma += convertirCantTexto(this.jTable2.getValueAt(i, ColSuma).toString());
/*      */         }
/*      */       } 
/*      */     } 
/*  873 */     return suma;
/*      */   }
/*      */   
/*      */   public void agregarColumnasMXN() {
/*  877 */     DefaultTableModel modelo = (DefaultTableModel)this.jTable2.getModel();
/*  878 */     modelo.addColumn("SubMXN");
/*  879 */     modelo.addColumn("IvaMXN");
/*  880 */     modelo.addColumn("RetMXN");
/*  881 */     modelo.addColumn("TotMXN");
/*      */     
/*  883 */     this.jTable2.setModel(modelo);
/*      */   }
/*      */   
/*      */   public void llenarPesos() {
/*  887 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/*  888 */       this.jTable2.setValueAt(this.utilerias
/*  889 */           .convertirDoublePesos(
/*  890 */             multiplicar(this.jTable2
/*  891 */               .getValueAt(i, 4).toString(), this.jTable2
/*  892 */               .getValueAt(i, 8).toString())), i, 11);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  897 */       this.jTable2.setValueAt(this.utilerias
/*  898 */           .convertirDoublePesos(
/*  899 */             multiplicar(this.jTable2
/*  900 */               .getValueAt(i, 5).toString(), this.jTable2
/*  901 */               .getValueAt(i, 8).toString())), i, 12);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  906 */       this.jTable2.setValueAt(this.utilerias
/*  907 */           .convertirDoublePesos(
/*  908 */             multiplicar(this.jTable2
/*  909 */               .getValueAt(i, 6).toString(), this.jTable2
/*  910 */               .getValueAt(i, 8).toString())), i, 13);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  915 */       this.jTable2.setValueAt(this.utilerias
/*  916 */           .convertirDoublePesos(
/*  917 */             multiplicar(this.jTable2
/*  918 */               .getValueAt(i, 7).toString(), this.jTable2
/*  919 */               .getValueAt(i, 8).toString())), i, 14);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double multiplicar(String cant, String cambio) {
/*  927 */     double resul = 0.0D;
/*  928 */     double c1 = this.utilerias.convertirCantTexto(cant);
/*  929 */     double c2 = Double.parseDouble(cambio);
/*  930 */     resul = c1 * c2;
/*      */     
/*  932 */     return resul;
/*      */   }
/*      */   
/*      */   public void ordenarColumnas() {
/*  936 */     TableColumnModel columnModel = this.jTable2.getColumnModel();
/*      */     
/*  938 */     columnModel.moveColumn(11, 9);
/*  939 */     columnModel.moveColumn(12, 10);
/*  940 */     columnModel.moveColumn(13, 11);
/*  941 */     columnModel.moveColumn(14, 12);
/*      */   }
/*      */ 
/*      */   
/*      */   public void llenarSegundaTabla() {
/*  946 */     this.jTable8.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Folio", "Fecha", "Cliente", "Sub", "Iva", "Ret", "Tot", "Cambio", "Tipo", "Met" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  954 */     this.utilerias.vaciarTabla(this.jTable9);
/*  955 */     this.LISTAFACTURAS2 = new String[this.jTable7.getRowCount()];
/*      */     
/*  957 */     for (int i = 0; i < this.jTable7.getRowCount(); i++) {
/*  958 */       String persona = this.jTable7.getValueAt(i, 11).toString();
/*  959 */       if (persona.equals("PERSONA_FISICA")) {
/*  960 */         persona = "PF";
/*  961 */       } else if (persona.equals("PERSONA_MORAL")) {
/*  962 */         persona = "PM";
/*  963 */       } else if (persona.equals("EXTRANJERO")) {
/*  964 */         persona = "EXT";
/*      */       } else {
/*  966 */         persona = "INV";
/*      */       } 
/*  968 */       this.utilerias.agregarCampoTablas(new String[] { this.jTable7
/*      */             
/*  970 */             .getValueAt(i, 0).toString(), this.jTable7
/*  971 */             .getValueAt(i, 2).toString(), 
/*  972 */             convertirFechaATexto(this.jTable7.getValueAt(i, 3).toString()), this.jTable7
/*  973 */             .getValueAt(i, 4).toString(), this.jTable7
/*  974 */             .getValueAt(i, 5).toString(), this.jTable7
/*  975 */             .getValueAt(i, 6).toString(), this.jTable7
/*  976 */             .getValueAt(i, 7).toString(), this.jTable7
/*  977 */             .getValueAt(i, 8).toString(), this.jTable7
/*  978 */             .getValueAt(i, 10).toString(), persona, this.jTable7
/*      */             
/*  980 */             .getValueAt(i, 12).toString().substring(0, 3), this.jTable7
/*  981 */             .getValueAt(i, 16).toString() }this.jTable8);
/*      */ 
/*      */       
/*  984 */       this.LISTAFACTURAS2[i] = this.jTable7.getValueAt(i, 2).toString();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarProductosDif() {
/*  989 */     Map<String, String> CantProdIva = new HashMap<>();
/*  990 */     Map<String, String> CantProdRet = new HashMap<>();
/*  991 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/*  992 */           .buscarDatos(1, "DISTINCT claveproducto", " facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and claveproducto<>'' and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.claveproducto asc"), (Object[])new String[] { "Núm", "Tipo", "Folio", "FolioFiscal", "Fecha", "Cliente", "Su pedido", "Equipo", "Subtotal", "Descuento", "Iva", "Retención", "Total", "Debe", "Estatus", "Documentó", "Carta Porte", "" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1000 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1004 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 1008 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 1009 */       CantProdIva.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/* 1010 */       CantProdRet.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*      */     } 
/*      */     
/* 1013 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/* 1014 */           .buscarDatos("claveProducto, tipoImpuesto, totalImpuesto, facturas33.folio, facturas33.fecha ,facturas33.estatus ", "facturas33, conceptosfacturas33", "where folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ") order by conceptosfacturas33.num asc"), (Object[])new String[] { "Clave Prod", "Tipo", "Total", "Factura", "Fecha", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1021 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1025 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 1029 */     double valor1 = 0.0D;
/* 1030 */     double valor2 = 0.0D;
/*      */     
/* 1032 */     double retenidoPrueba = 0.0D;
/* 1033 */     for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/* 1034 */       if (((String)this.CAMPOSGENERALES.get("sucursal")).equals("POZA RICA") || ((String)this.CAMPOSGENERALES.get("sucursal")).equals("CADEREYTA")) {
/* 1035 */         String folio = this.jTable5.getValueAt(j, 3).toString();
/* 1036 */         for (int i1 = 0; i1 < this.jTable6.getRowCount(); i1++) {
/* 1037 */           String folio2 = this.jTable6.getValueAt(i1, 2).toString();
/* 1038 */           if (folio.equals(folio2) && this.jTable6.getValueAt(i1, 18).equals("USD") && !this.jTable5.getValueAt(j, 2).toString().equals("")) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 1044 */       String cod = this.jTable5.getValueAt(j, 0).toString();
/* 1045 */       if (!cod.equals("")) {
/*      */         
/* 1047 */         String[] dat = regresaTipoImpuesto(j);
/* 1048 */         if (dat != null && 
/* 1049 */           dat[0].equals("TRASLADO")) {
/* 1050 */           double cantAnt = this.utilerias.convertirCantTexto(CantProdIva.get(cod));
/* 1051 */           double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/* 1052 */           CantProdIva.put(cod, "" + v2);
/* 1053 */           valor1 += this.utilerias.convertirCantTexto(dat[1]);
/*      */         } 
/*      */ 
/*      */         
/* 1057 */         if (j < this.jTable5.getRowCount() - 1 && dat != null) {
/*      */           
/* 1059 */           dat = regresaTipoImpuesto(j + 1);
/* 1060 */           if (dat != null && 
/* 1061 */             dat[0].equals("RETENIDO")) {
/* 1062 */             double cantAnt = this.utilerias.convertirCantTexto(CantProdRet.get(cod));
/* 1063 */             double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/* 1064 */             CantProdRet.put(cod, "" + v2);
/* 1065 */             valor2 += this.utilerias.convertirCantTexto(dat[1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1073 */     DefaultTableModel model = (DefaultTableModel)this.jTable4.getModel();
/* 1074 */     model.addColumn("Descripcion");
/* 1075 */     model.fireTableDataChanged();
/* 1076 */     for (int k = 0; k < this.jTable4.getRowCount(); k++) {
/* 1077 */       this.con.consultar("descripcion", "catproductos", "where clave = " + String.valueOf(this.jTable4.getValueAt(k, 0)));
/* 1078 */       this.jTable4.setValueAt(this.con.Campo, k, 1);
/*      */     } 
/*      */     
/* 1081 */     double[] cantidades = new double[this.jTable4.getRowCount()];
/* 1082 */     double totalProd = 0.0D;
/* 1083 */     for (int m = 0; m < this.jTable4.getRowCount(); m++) {
/* 1084 */       String[] cant = this.con.regresaColIndex("importe", "facturas33, conceptosfacturas33", "where claveproducto='" + 
/*      */ 
/*      */           
/* 1087 */           String.valueOf(this.jTable4.getValueAt(m, 0)) + "' and folio = conceptosfacturas33.numfactura and (" + this.CONSULTARLISTARPRODUCTOS + ")");
/* 1088 */       for (int i1 = 0; i1 < cant.length; i1++) {
/* 1089 */         cantidades[m] = cantidades[m] + this.utilerias.convertirCantTexto(cant[i1]);
/* 1090 */         totalProd += this.utilerias.convertirCantTexto(cant[i1]);
/*      */       } 
/*      */     } 
/*      */     
/* 1094 */     convertirProductosPesos();
/*      */     
/* 1096 */     double iva = 0.0D;
/* 1097 */     double ret = 0.0D;
/* 1098 */     double tot = 0.0D;
/*      */     int n;
/* 1100 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/* 1101 */       String cod = CantProdIva.get(this.jTable4.getValueAt(n, 0).toString());
/* 1102 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod)), n, 2);
/*      */       
/* 1104 */       String cod2 = CantProdRet.get(this.jTable4.getValueAt(n, 0).toString());
/* 1105 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(cod2)), n, 3);
/*      */     } 
/*      */     
/* 1108 */     for (n = 0; n < this.jTable4.getRowCount(); n++) {
/* 1109 */       double suma = cantidades[n] + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 2).toString()) - this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 3).toString());
/* 1110 */       double sumaMXN = this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 5).toString()) + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 6).toString()) - this.utilerias.convertirCantTexto(this.jTable4.getValueAt(n, 7).toString());
/* 1111 */       this.utilerias.agregarCampoTablas(new String[] { "", "", this.jTable4
/*      */ 
/*      */ 
/*      */             
/* 1115 */             .getValueAt(n, 0).toString(), this.jTable4
/* 1116 */             .getValueAt(n, 1).toString(), this.utilerias
/* 1117 */             .convertirDoublePesos(cantidades[n]), this.jTable4
/* 1118 */             .getValueAt(n, 2).toString(), this.jTable4
/* 1119 */             .getValueAt(n, 3).toString(), this.utilerias
/* 1120 */             .convertirDoublePesos(suma), "", "", "", this.jTable4
/*      */ 
/*      */ 
/*      */             
/* 1124 */             .getValueAt(n, 5).toString(), this.jTable4
/* 1125 */             .getValueAt(n, 6).toString(), this.jTable4
/* 1126 */             .getValueAt(n, 7).toString(), this.utilerias
/* 1127 */             .convertirDoublePesos(sumaMXN) }this.jTable2);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1132 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1152 */     double totGral = totalProd + iva - ret;
/*      */   }
/*      */   
/*      */   public double sacarSumaTipoAnticipo() {
/* 1156 */     double sum = 0.0D;
/* 1157 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1158 */       String col = this.jTable1.getValueAt(i, 13).toString();
/* 1159 */       if (col.equals("ANTICIPO")) {
/* 1160 */         sum += this.utilerias.convertirCantTexto(this.jTable2.getValueAt(i, 4).toString());
/*      */       }
/*      */     } 
/* 1163 */     return sum;
/*      */   }
/*      */ 
/*      */   
/*      */   public String[] regresaTipoImpuesto2(int reg) {
/* 1168 */     String[] datos = { "", "" };
/* 1169 */     String cant = "";
/*      */     
/* 1171 */     if (reg < this.jTable6.getRowCount() - 1) {
/* 1172 */       String tipo = this.jTable6.getValueAt(reg + 1, 1).toString();
/*      */       
/* 1174 */       if (!tipo.equals("")) {
/* 1175 */         cant = this.jTable6.getValueAt(reg + 1, 2).toString();
/* 1176 */         datos[0] = tipo;
/* 1177 */         datos[1] = cant;
/*      */       } else {
/* 1179 */         return null;
/*      */       } 
/*      */     } 
/* 1182 */     return datos;
/*      */   }
/*      */   
/*      */   public void convertirProductosPesos() {
/* 1186 */     Map<String, String> CantProdIva = new HashMap<>();
/* 1187 */     Map<String, String> CantProdRet = new HashMap<>();
/*      */     
/* 1189 */     double valor1 = 0.0D;
/* 1190 */     double valor2 = 0.0D;
/*      */     
/* 1192 */     DefaultTableModel newModel = new DefaultTableModel();
/* 1193 */     DefaultTableModel originalModel = (DefaultTableModel)this.jTable5.getModel(); int i;
/* 1194 */     for (i = 0; i < originalModel.getColumnCount(); i++) {
/* 1195 */       newModel.addColumn(originalModel.getColumnName(i));
/*      */     }
/*      */     
/* 1198 */     for (i = 0; i < originalModel.getRowCount(); i++) {
/* 1199 */       Object[] rowData = new Object[originalModel.getColumnCount()];
/* 1200 */       for (int k = 0; k < originalModel.getColumnCount(); k++) {
/* 1201 */         rowData[k] = originalModel.getValueAt(i, k);
/*      */       }
/* 1203 */       newModel.addRow(rowData);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1208 */     this.jTable6.setModel(newModel);
/* 1209 */     for (i = 0; i < this.jTable6.getRowCount(); i++) {
/* 1210 */       String importe = this.jTable6.getValueAt(i, 2).toString();
/* 1211 */       String folio1 = this.jTable6.getValueAt(i, 3).toString();
/*      */       
/* 1213 */       if (!importe.equals("")) {
/* 1214 */         for (int k = 0; k < this.jTable2.getRowCount(); k++) {
/* 1215 */           String folio2 = this.jTable2.getValueAt(k, 1).toString();
/* 1216 */           if (folio1.equals(folio2)) {
/* 1217 */             String tipoCambio = this.jTable2.getValueAt(k, 8).toString();
/* 1218 */             String nuevo = convertirDLSaPESOS(tipoCambio, importe);
/* 1219 */             this.jTable6.setValueAt(nuevo, i, 2);
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/* 1226 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 1227 */       String cod = this.jTable4.getValueAt(i, 0).toString();
/* 1228 */       double suma = this.utilerias.sumarColumnaTablaSiCondicion(this.jTable3, 1, "IGUAL", cod, 0);
/* 1229 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(suma), i, 5);
/*      */     } 
/*      */     
/* 1232 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 1233 */       CantProdIva.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/* 1234 */       CantProdRet.put(this.jTable4.getValueAt(i, 0).toString(), "0");
/*      */     } 
/* 1236 */     for (i = 0; i < this.jTable6.getRowCount(); i++) {
/* 1237 */       String cod = this.jTable6.getValueAt(i, 0).toString();
/* 1238 */       if (!cod.equals("")) {
/*      */         
/* 1240 */         String[] dat = regresaTipoImpuesto2(i);
/* 1241 */         if (dat != null && 
/* 1242 */           dat[0].equals("TRASLADO")) {
/* 1243 */           double cantAnt = this.utilerias.convertirCantTexto(CantProdIva.get(cod));
/* 1244 */           double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/* 1245 */           CantProdIva.put(cod, "" + v2);
/* 1246 */           valor1 += this.utilerias.convertirCantTexto(dat[1]);
/*      */         } 
/*      */ 
/*      */         
/* 1250 */         if (i < this.jTable5.getRowCount() - 1 && dat != null) {
/* 1251 */           dat = regresaTipoImpuesto2(i + 1);
/* 1252 */           if (dat != null && 
/* 1253 */             dat[0].equals("RETENIDO")) {
/* 1254 */             double cantAnt = this.utilerias.convertirCantTexto(CantProdRet.get(cod));
/* 1255 */             double v2 = cantAnt + this.utilerias.convertirCantTexto(dat[1]);
/* 1256 */             CantProdRet.put(cod, "" + v2);
/* 1257 */             valor2 += this.utilerias.convertirCantTexto(dat[1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1265 */     i = 0;
/* 1266 */     for (Map.Entry<String, String> entry : CantProdIva.entrySet()) {
/* 1267 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(entry.getValue())), i, 6);
/* 1268 */       i++;
/*      */     } 
/*      */     
/* 1271 */     i = 0;
/* 1272 */     for (Map.Entry<String, String> entry : CantProdRet.entrySet()) {
/* 1273 */       this.jTable4.setValueAt(this.utilerias.convertirDoublePesos(Double.parseDouble(entry.getValue())), i, 7);
/* 1274 */       i++;
/*      */     } 
/*      */     
/* 1277 */     for (int j = 0; j < this.jTable4.getRowCount(); j++) {
/* 1278 */       double d = this.utilerias.convertirCantTexto(this.jTable4.getValueAt(j, 5).toString()) + this.utilerias.convertirCantTexto(this.jTable4.getValueAt(j, 6).toString());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String convertirDLSaPESOS(String tipoCambio, String montoDLS) {
/* 1284 */     double cambio = this.utilerias.convertirCantTexto(tipoCambio);
/* 1285 */     double monto = this.utilerias.convertirCantTexto(montoDLS);
/* 1286 */     double resultado = cambio * monto;
/*      */     
/* 1288 */     return this.utilerias.convertirDoublePesos(resultado);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] regresaTipoImpuesto(int reg) {
/* 1294 */     String[] datos = { "", "" };
/* 1295 */     String cant = "";
/*      */     
/* 1297 */     if (reg < this.jTable5.getRowCount() - 1) {
/* 1298 */       String tipo = this.jTable5.getValueAt(reg + 1, 1).toString();
/*      */       
/* 1300 */       if (!tipo.equals("")) {
/* 1301 */         cant = this.jTable5.getValueAt(reg + 1, 2).toString();
/* 1302 */         datos[0] = tipo;
/* 1303 */         datos[1] = cant;
/*      */       } else {
/* 1305 */         return null;
/*      */       } 
/*      */     } 
/* 1308 */     return datos;
/*      */   }
/*      */   
/*      */   public void insertarRenglonLineas() {
/* 1312 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "", "", "", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————", "——————————————————————————————————————————————————" }, this.jTable2);
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
/*      */   public void sacarListaProductos() {
/* 1334 */     String consulta = ""; int i;
/* 1335 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1336 */       consulta = consulta + " conceptosfacturas33.numfactura = '" + consulta + "' ";
/* 1337 */       if (i + 1 < this.LISTAFACTURAS.length) {
/* 1338 */         consulta = consulta + " || ";
/*      */       }
/*      */     } 
/* 1341 */     this.CONSULTARLISTARPRODUCTOS = consulta;
/* 1342 */     this.utilerias.consultaGralTabla(this.con, this.jTable3, new String[] { "clave", "importe", "numFactura" }, "claveproducto, importe, numfactura", "conceptosfacturas33", "where (" + consulta + ") and claveproducto <>'' ");
/*      */     
/* 1344 */     for (i = 0; i < this.jTable3.getRowCount(); i++) {
/* 1345 */       String folio = this.jTable3.getValueAt(i, 2).toString();
/* 1346 */       for (int j = 0; j < this.jTable2.getRowCount(); j++) {
/* 1347 */         String folio2 = this.jTable2.getValueAt(j, 1).toString();
/* 1348 */         String tipoCambio = this.jTable2.getValueAt(j, 8).toString();
/* 1349 */         if (folio.equals(folio2)) {
/*      */           
/* 1351 */           String nuevo = convertirDLSaPESOS(tipoCambio, this.jTable3.getValueAt(i, 1).toString());
/* 1352 */           this.jTable3.setValueAt(nuevo, i, 1);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1357 */     this.jEditorPane1.setText("select claveproducto, importe, numfactura from  conceptosfacturas33 where (" + consulta + ") and claveproducto <>'' order by numFactura desc");
/*      */   }
/*      */   
/*      */   public void sacarPrimeroVentasFletes() {
/* 1361 */     double fletesRetencion = 0.0D;
/* 1362 */     int cont = 0;
/* 1363 */     for (int i = 0; i < this.jTable8.getRowCount(); i++) {
/* 1364 */       String folio = this.jTable8.getValueAt(i, 1).toString();
/* 1365 */       String iva = this.jTable8.getValueAt(i, 5).toString();
/* 1366 */       String ret = this.jTable8.getValueAt(i, 6).toString();
/* 1367 */       String tipo = this.jTable8.getValueAt(i, 9).toString();
/*      */       
/* 1369 */       if (!iva.equals("$0.00") && !ret.equals("$0.00") && tipo.equals("PM")) {
/* 1370 */         for (int j = 0; j < this.jTable9.getRowCount(); j++) {
/* 1371 */           String codigo = this.jTable9.getValueAt(j, 0).toString();
/* 1372 */           String fact = this.jTable9.getValueAt(j, 2).toString();
/* 1373 */           if ((fact.equals(folio) && codigo.equals("78101800")) || (fact.equals(folio) && codigo.equals("78101801")) || (fact.equals(folio) && codigo.equals("78101802"))) {
/* 1374 */             cont++;
/* 1375 */             fletesRetencion += this.utilerias.convertirCantTexto(this.jTable9.getValueAt(j, 1).toString());
/*      */             
/* 1377 */             System.out.println("Folio Primera Seccion " + cont + " : " + folio + " - " + String.valueOf(this.jTable3.getValueAt(j, 1)) + " " + iva + " tipo " + tipo + " " + ret + " " + fletesRetencion);
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/* 1382 */     this.FLETESCR = fletesRetencion;
/*      */     
/* 1384 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS", "FLETES C/RETENCIÓN", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1391 */           .convertirDoublePesos(fletesRetencion), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/*      */   public void sacarSegundoVentasFletes() {
/* 1407 */     double fletesSinRetencion = 0.0D;
/* 1408 */     for (int i = 0; i < this.jTable8.getRowCount(); i++) {
/* 1409 */       String folio = this.jTable8.getValueAt(i, 1).toString();
/* 1410 */       String iva = this.jTable8.getValueAt(i, 5).toString();
/* 1411 */       String ret = this.jTable8.getValueAt(i, 6).toString();
/* 1412 */       String tipo = this.jTable8.getValueAt(i, 9).toString();
/*      */       
/* 1414 */       String cliente = this.jTable8.getValueAt(i, 4).toString();
/*      */       
/* 1416 */       if ((cliente.equals("GSM - BRONCO S. A. DE C. V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1417 */         .equals("DOWELL SCHLUMBERGER DE MEXICO, S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1418 */         .equals("BAKER HUGHES OPERATIONS MEXICO S. DE R.L. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1419 */         .equals("CLEANMEX ENERGY SERVICES S DE RL DE CV") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1420 */         .equals("CAPITAL CARGO DEL GOLFO S.A. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || (cliente
/* 1421 */         .equals("ENERGY DRILLING MARINE SERVICES S.A.P. DE I. DE C.V.") && ret.equals("$0.00") && !iva.equals("$0.00")) || ret
/*      */         
/* 1423 */         .equals("$0.00")) {
/* 1424 */         for (int j = 0; j < this.jTable9.getRowCount(); j++) {
/* 1425 */           String codigo = this.jTable9.getValueAt(j, 0).toString();
/* 1426 */           String fact = this.jTable9.getValueAt(j, 2).toString();
/* 1427 */           if (fact.equals(folio) && (codigo.equals("78101800") || codigo.equals("78101801") || codigo.equals("78101802") || codigo.equals("76122401")))
/*      */           {
/* 1429 */             fletesSinRetencion += this.utilerias.convertirCantTexto(this.jTable9.getValueAt(j, 1).toString());
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
/* 1440 */     this.FLETESSR = fletesSinRetencion;
/* 1441 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "VENTAS", "FLETES SIN/RETENCIÓN", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1448 */           .convertirDoublePesos(fletesSinRetencion), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/* 1464 */     this.INGRESOSACTIVOFIJO = 0.0D;
/* 1465 */     for (int j = 0; j < this.jTable9.getRowCount(); j++) {
/* 1466 */       String codigo = this.jTable9.getValueAt(j, 0).toString();
/* 1467 */       String fact = this.jTable9.getValueAt(j, 2).toString();
/* 1468 */       if (codigo.equals("25101600") || codigo.equals("25101503") || codigo.equals("25101500"))
/*      */       {
/*      */         
/* 1471 */         this.INGRESOSACTIVOFIJO += this.utilerias.convertirCantTexto(this.jTable9.getValueAt(j, 1).toString());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1476 */     this.FLETESO = this.FLETESSUB - this.FLETESCR + this.FLETESSR + this.INGRESOSACTIVOFIJO;
/*      */     
/* 1478 */     if (this.FLETESO < 2.0D) {
/* 1479 */       this.FLETESO = 0.0D;
/*      */     }
/*      */     
/* 1482 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "OTRAS", "VENTAS", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1489 */           .convertirDoublePesos(this.FLETESO), "", "", "", "", "", "", "", "", "" }, this.jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1502 */     this.utilerias.agregarCampoTablas(new String[] { "", "", "INRGESOS POR", "VENTA DE ACTIVO FIJO", "", this.utilerias
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1509 */           .convertirDoublePesos(this.INGRESOSACTIVOFIJO), "", "", "", "", "", "", "", "", "" }, this.jTable2);
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
/* 1525 */     String cliente = "GENERAL";
/*      */ 
/*      */ 
/*      */     
/* 1529 */     this.utilerias.quitarSignoPesosTabla(this.jTable2);
/* 1530 */     Map<Object, Object> datos = new HashMap<>();
/* 1531 */     this.utilerias.cargarImagenesAReporte(datos);
/* 1532 */     datos.put("sucursal", ((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 1533 */     datos.put("periodo", this.etiquetaFecha);
/* 1534 */     datos.put("cliente", "TODOS");
/* 1535 */     datos.put("estado", "NOTAS DE CRÉDITO (EGRESOS)");
/* 1536 */     datos.put("titulo", "REPORTE DE PÓLIZAS PARA NOTAS DE CRÉDITO " + this.MONEDA);
/* 1537 */     datos.put("documento", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/*      */     
/*      */     try {
/* 1540 */       this.utilerias.verImpresion("/Reportes/Facturacion/PolizasPeriodoDLS.jasper", this.jTable2, datos, "REPORTE DE PÓLIZAS PARA NOTAS DE CREDITO" + this.MONEDA);
/* 1541 */     } catch (JRException ex) {
/* 1542 */       Logger.getLogger(Facturas33PeriodoDLS.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String convertirFechaATexto(String fecha) {
/* 1547 */     String fechaCorta = fecha.substring(0, 10);
/* 1548 */     String año = fechaCorta.substring(0, 4);
/* 1549 */     String mes = fechaCorta.substring(5, 7);
/* 1550 */     String dia = fechaCorta.substring(8, 10);
/* 1551 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 1552 */     return strFecha;
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 1556 */     String canti = cant;
/* 1557 */     String valorP = "";
/* 1558 */     for (int j = 0; j < canti.length(); j++) {
/* 1559 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 1560 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 1563 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public static int calcularRegistrosParaMultiplo(int registros, int multiplo) {
/* 1567 */     int residuo = registros % multiplo;
/* 1568 */     return (residuo == 0) ? 0 : (multiplo - residuo);
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux2(JTable Original, Object[] columnas) {
/* 1572 */     Object[] Columnas = columnas;
/* 1573 */     Object[][] registros = new Object[Original.getRowCount()][columnas.length];
/* 1574 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 1575 */       registros[i][0] = Integer.valueOf(i + 1);
/* 1576 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 1577 */         if (j == 0) {
/* 1578 */           registros[i][0] = Original.getValueAt(i, j);
/*      */         }
/* 1580 */         if (j == 1) {
/* 1581 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 1583 */         if (j == 2) {
/* 1584 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/*      */         
/* 1587 */         if (j == 3) {
/* 1588 */           if (!Original.getValueAt(i, j).toString().equals("")) {
/* 1589 */             registros[i][3] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*      */           } else {
/* 1591 */             registros[i][3] = "";
/*      */           } 
/*      */         }
/* 1594 */         if (j == 4) {
/*      */           try {
/* 1596 */             registros[i][4] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1597 */           } catch (NumberFormatException e) {
/* 1598 */             registros[i][4] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */         
/* 1602 */         if (j == 5) {
/*      */           try {
/* 1604 */             registros[i][5] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1605 */           } catch (NumberFormatException e) {
/* 1606 */             registros[i][5] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1609 */         if (j == 6) {
/*      */           try {
/* 1611 */             registros[i][6] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1612 */           } catch (NumberFormatException e) {
/* 1613 */             registros[i][6] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1616 */         if (j == 7) {
/*      */           try {
/* 1618 */             registros[i][7] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1619 */           } catch (NumberFormatException e) {
/* 1620 */             registros[i][7] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1623 */         if (j == 8) {
/*      */           try {
/* 1625 */             registros[i][8] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1626 */           } catch (NumberFormatException e) {
/* 1627 */             registros[i][8] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1630 */         if (j == 9) {
/*      */           try {
/* 1632 */             registros[i][9] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1633 */           } catch (NumberFormatException e) {
/* 1634 */             registros[i][9] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/* 1637 */         if (j == 10) {
/*      */           try {
/* 1639 */             registros[i][10] = this.utilerias.quitarDecimalesAEnteros("" + convertirCantTexto(Original.getValueAt(i, j).toString()));
/* 1640 */           } catch (NumberFormatException e) {
/* 1641 */             registros[i][10] = Original.getValueAt(i, j);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1646 */     JTable aux = new JTable(registros, Columnas);
/* 1647 */     return aux;
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Facturas33PeriodoNotasCreditoDLS.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */