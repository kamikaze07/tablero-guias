/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Image;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.InputMethodEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.JTextPane;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import javax.swing.text.SimpleAttributeSet;
/*      */ import org.jfree.chart.ChartPanel;
/*      */ import org.jfree.chart.JFreeChart;
/*      */ import org.jfree.chart.block.BlockContainer;
/*      */ import org.jfree.chart.plot.CategoryPlot;
/*      */ import org.jfree.chart.renderer.category.LineAndShapeRenderer;
/*      */ import org.jfree.chart.title.LegendTitle;
/*      */ import org.jfree.data.category.CategoryDataset;
/*      */ import org.jfree.data.category.DefaultCategoryDataset;
/*      */ 
/*      */ public class Reseteos extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   60 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   61 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   62 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   63 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   64 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   65 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   66 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   67 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   String USUARIO;
/*   69 */   Validaciones val = new Validaciones();
/*   70 */   Consultas con = new Consultas();
/*   71 */   Errores error = new Errores(false);
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   AltaOperador operador;
/*   75 */   int contador = 0;
/*      */   JFrame padre;
/*      */   EscribirReporte esc;
/*   78 */   Date fechaActual = new Date();
/*   79 */   Date fecha = new Date();
/*   80 */   Date fechaInicio = null;
/*   81 */   Date fechaTermino = null;
/*   82 */   Date fechaMinimo = null;
/*   83 */   CeldaRender celda = new CeldaRender();
/*   84 */   String CLAVEOP = "";
/*      */   String[] operadores;
/*   86 */   String NOMBRE = "";
/*   87 */   String[] GUIAS = new String[10];
/*   88 */   String CLAVE = "";
/*      */   boolean CONCEPTO = false;
/*   90 */   int INDICE = 0;
/*   91 */   String[] DATOS = null;
/*   92 */   String TIPOTRACTOR = "";
/*   93 */   Presionado presionado = null;
/*   94 */   String[] CLAVEOPERADOR = null;
/*   95 */   String DIRECTIVA = "";
/*   96 */   String base = "";
/*   97 */   double REN = 0.0D;
/*   98 */   double KM = 0.0D;
/*   99 */   double LTSCONSUM = 0.0D;
/*  100 */   double LTSCONTRA = 0.0D;
/*  101 */   double CMFAL1 = 0.0D;
/*  102 */   double CMFAL2 = 0.0D; boolean MODIFICAR = false; boolean primera = false; private ButtonGroup buttonGroup1; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton2; private JButton jButton3; private JButton jButton4; private JButton jButton44; private JButton jButton45; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JComboBox jComboBox2; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser9; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField10; private JFormattedTextField jFormattedTextField11; private JFormattedTextField jFormattedTextField12; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JFormattedTextField jFormattedTextField5; private JFormattedTextField jFormattedTextField6; private JFormattedTextField jFormattedTextField7; private JFormattedTextField jFormattedTextField8; private JFormattedTextField jFormattedTextField9; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30;
/*      */   private JLabel jLabel31;
/*      */   private JLabel jLabel32;
/*      */   private JLabel jLabel33;
/*      */   private JLabel jLabel34;
/*      */   private JLabel jLabel35;
/*      */   
/*      */   public Reseteos(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*  110 */     initComponents();
/*  111 */     String año = "2010";
/*  112 */     String mes = "03";
/*  113 */     String dia = "01";
/*  114 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  115 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  117 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  118 */     } catch (ParseException ex) {
/*  119 */       ex.printStackTrace();
/*      */     } 
/*  121 */     this.padre = padre;
/*  122 */     this.fichas = fichas;
/*  123 */     initComponents();
/*      */     
/*  125 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  126 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  127 */     this.jLabel7.setCursor(micursor);
/*  128 */     this.jLabel8.setCursor(micursor);
/*  129 */     this.jLabel9.setCursor(micursor);
/*      */     
/*  131 */     int w = this.tama.width;
/*  132 */     int h = this.tama.height;
/*  133 */     int rw = (w - 795) / 2;
/*  134 */     int rh = (h - 610) / 2;
/*  135 */     this.jDialog1.setLocation(rw, rh);
/*  136 */     this.jDialog1.setSize(795, 610);
/*  137 */     this.jDialog1.setVisible(false);
/*  138 */     this.jDialog1.setResizable(false);
/*      */     
/*  140 */     rw = (w - 795) / 2;
/*  141 */     rh = (h - 610) / 2;
/*  142 */     this.jDialog2.setLocation(rw, rh);
/*  143 */     this.jDialog2.setSize(795, 610);
/*  144 */     this.jDialog2.setVisible(false);
/*  145 */     this.jDialog2.setResizable(false);
/*      */     
/*  147 */     rw = (w - 390) / 2;
/*  148 */     rh = (h - 230) / 2;
/*  149 */     this.jDialog3.setLocation(rw, rh);
/*  150 */     this.jDialog3.setSize(390, 230);
/*  151 */     this.jDialog3.setVisible(false);
/*  152 */     this.jDialog3.setResizable(false);
/*      */     
/*  154 */     this.USUARIO = USUARIO;
/*  155 */     panelito.setViewportView(this);
/*  156 */     this.panel = panelito;
/*  157 */     consultar();
/*  158 */     colorear();
/*  159 */     llenarCombos();
/*  160 */     this.primera = true;
/*      */     
/*  162 */     String[] datos = this.con.regresaReg("directiva,sucursal", "configuraciones", "", 2);
/*  163 */     this.DIRECTIVA = datos[0];
/*      */     
/*  165 */     this.base = datos[1];
/*  166 */     this.buttonGroup1.add(this.jRadioButton3);
/*  167 */     this.buttonGroup1.add(this.jRadioButton4);
/*      */   }
/*      */   private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel46; private JLabel jLabel48; private JLabel jLabel5; private JLabel jLabel56; private JLabel jLabel6; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel2; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9;
/*      */   private JRadioButton jRadioButton3;
/*      */   private JRadioButton jRadioButton4;
/*      */   private JScrollPane jScrollPane10;
/*      */   
/*      */   private void initComponents() {
/*  175 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  176 */     this.jPanel1 = new JPanel();
/*  177 */     this.jLabel66 = new JLabel();
/*  178 */     this.jSeparator1 = new JSeparator();
/*  179 */     this.jLabel1 = new JLabel();
/*  180 */     this.jTextField4 = new JTextField();
/*  181 */     this.jLabel2 = new JLabel();
/*  182 */     this.jDateChooser9 = new JDateChooser();
/*  183 */     this.jLabel6 = new JLabel();
/*  184 */     this.jComboBox2 = new JComboBox();
/*  185 */     this.jSeparator2 = new JSeparator();
/*  186 */     this.jPanel3 = new JPanel();
/*  187 */     this.jTextField5 = new JTextField();
/*  188 */     this.jLabel10 = new JLabel();
/*  189 */     this.jLabel18 = new JLabel();
/*  190 */     this.jLabel19 = new JLabel();
/*  191 */     this.jScrollPane3 = new JScrollPane();
/*  192 */     this.jTextArea1 = new JTextArea();
/*  193 */     this.jScrollPane5 = new JScrollPane();
/*  194 */     this.jTextArea2 = new JTextArea();
/*  195 */     this.jPanel5 = new JPanel();
/*  196 */     this.jLabel11 = new JLabel();
/*  197 */     this.jLabel12 = new JLabel();
/*  198 */     this.jLabel13 = new JLabel();
/*  199 */     this.jLabel14 = new JLabel();
/*  200 */     this.jLabel16 = new JLabel();
/*  201 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  202 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  203 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  204 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  205 */     this.jFormattedTextField5 = new JFormattedTextField();
/*  206 */     this.jLabel22 = new JLabel();
/*  207 */     this.jFormattedTextField6 = new JFormattedTextField();
/*  208 */     this.jLabel20 = new JLabel();
/*  209 */     this.jSeparator3 = new JSeparator();
/*  210 */     this.jButton4 = new JButton();
/*  211 */     this.jButton7 = new JButton();
/*  212 */     this.jScrollPane4 = new JScrollPane();
/*  213 */     this.jTextPane1 = new JTextPane();
/*  214 */     this.jLabel21 = new JLabel();
/*  215 */     this.jScrollPane6 = new JScrollPane();
/*  216 */     this.jTextPane2 = new JTextPane();
/*  217 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  218 */     this.jPanel4 = new JPanel();
/*  219 */     this.jLabel67 = new JLabel();
/*  220 */     this.jSeparator4 = new JSeparator();
/*  221 */     this.jLabel23 = new JLabel();
/*  222 */     this.jTextField6 = new JTextField();
/*  223 */     this.jLabel25 = new JLabel();
/*  224 */     this.jSeparator5 = new JSeparator();
/*  225 */     this.jPanel7 = new JPanel();
/*  226 */     this.jTextField7 = new JTextField();
/*  227 */     this.jLabel26 = new JLabel();
/*  228 */     this.jLabel27 = new JLabel();
/*  229 */     this.jLabel28 = new JLabel();
/*  230 */     this.jScrollPane7 = new JScrollPane();
/*  231 */     this.jTextArea3 = new JTextArea();
/*  232 */     this.jScrollPane8 = new JScrollPane();
/*  233 */     this.jTextArea4 = new JTextArea();
/*  234 */     this.jPanel8 = new JPanel();
/*  235 */     this.jLabel29 = new JLabel();
/*  236 */     this.jLabel30 = new JLabel();
/*  237 */     this.jLabel31 = new JLabel();
/*  238 */     this.jLabel32 = new JLabel();
/*  239 */     this.jLabel33 = new JLabel();
/*  240 */     this.jFormattedTextField7 = new JFormattedTextField();
/*  241 */     this.jFormattedTextField8 = new JFormattedTextField();
/*  242 */     this.jFormattedTextField9 = new JFormattedTextField();
/*  243 */     this.jFormattedTextField10 = new JFormattedTextField();
/*  244 */     this.jFormattedTextField11 = new JFormattedTextField();
/*  245 */     this.jLabel34 = new JLabel();
/*  246 */     this.jFormattedTextField12 = new JFormattedTextField();
/*  247 */     this.jLabel35 = new JLabel();
/*  248 */     this.jSeparator6 = new JSeparator();
/*  249 */     this.jButton8 = new JButton();
/*  250 */     this.jScrollPane9 = new JScrollPane();
/*  251 */     this.jTextPane3 = new JTextPane();
/*  252 */     this.jLabel36 = new JLabel();
/*  253 */     this.jScrollPane10 = new JScrollPane();
/*  254 */     this.jTextPane4 = new JTextPane();
/*  255 */     this.jTextField8 = new JTextField();
/*  256 */     this.jButton2 = new JButton();
/*  257 */     this.jLabel37 = new JLabel();
/*  258 */     this.jTextField9 = new JTextField();
/*  259 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  260 */     this.jPanel29 = new JPanel();
/*  261 */     this.jLabel124 = new JLabel();
/*  262 */     this.jSeparator29 = new JSeparator();
/*  263 */     this.jLabel125 = new JLabel();
/*  264 */     this.jButton44 = new JButton();
/*  265 */     this.jButton45 = new JButton();
/*  266 */     this.jScrollPane18 = new JScrollPane();
/*  267 */     this.jTextArea5 = new JTextArea();
/*  268 */     this.jLabel126 = new JLabel();
/*  269 */     this.cantidad = new JFormattedTextField();
/*  270 */     this.jPanel9 = new JPanel();
/*  271 */     this.jLabel24 = new JLabel();
/*  272 */     this.jRadioButton3 = new JRadioButton();
/*  273 */     this.jRadioButton4 = new JRadioButton();
/*  274 */     this.jSeparator7 = new JSeparator();
/*  275 */     this.buttonGroup1 = new ButtonGroup();
/*  276 */     this.jPanel6 = new JPanel();
/*  277 */     this.jLabel3 = new JLabel();
/*  278 */     this.jPanel2 = new JPanel();
/*  279 */     this.jButton3 = new JButton();
/*  280 */     this.jLabel4 = new JLabel();
/*  281 */     this.jLabel5 = new JLabel();
/*  282 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  283 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  284 */     this.jLabel7 = new JLabel();
/*  285 */     this.jLabel8 = new JLabel();
/*  286 */     this.jLabel9 = new JLabel();
/*  287 */     this.jPanel17 = new JPanel();
/*  288 */     this.jTextField1 = new JTextField();
/*  289 */     this.jLabel15 = new JLabel();
/*  290 */     this.jLabel56 = new JLabel();
/*  291 */     this.jTextField3 = new JTextField();
/*  292 */     this.jComboBox1 = new JComboBox();
/*  293 */     this.jLabel46 = new JLabel();
/*  294 */     this.jLabel17 = new JLabel();
/*  295 */     this.jTextField2 = new JTextField();
/*  296 */     this.jPanel18 = new JPanel();
/*  297 */     this.jScrollPane2 = new JScrollPane();
/*  298 */     jTable2 = new JTable();
/*  299 */     this.jLabel48 = new JLabel();
/*  300 */     this.jButton5 = new JButton();
/*  301 */     this.jButton11 = new JButton();
/*  302 */     this.jButton6 = new JButton();
/*  303 */     this.jButton1 = new JButton();
/*  304 */     this.jButton9 = new JButton();
/*  305 */     this.jButton10 = new JButton();
/*  306 */     this.jButton12 = new JButton();
/*  307 */     this.jLabel38 = new JLabel();
/*  308 */     this.jLabel39 = new JLabel();
/*  309 */     this.jLabel40 = new JLabel();
/*  310 */     this.jLabel41 = new JLabel();
/*  311 */     this.jLabel42 = new JLabel();
/*  312 */     this.jLabel43 = new JLabel();
/*  313 */     this.jLabel44 = new JLabel();
/*      */     
/*  315 */     this.jDialog1.setTitle("Información del reseteo");
/*  316 */     this.jDialog1.setModal(true);
/*      */     
/*  318 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/*      */     
/*  320 */     this.jLabel66.setFont(new Font("Tahoma", 1, 18));
/*  321 */     this.jLabel66.setForeground(new Color(0, 102, 102));
/*  322 */     this.jLabel66.setHorizontalAlignment(0);
/*  323 */     this.jLabel66.setText("GENERAR NUEVA ORDEN DE RESETEO");
/*      */     
/*  325 */     this.jLabel1.setText("Folio:");
/*      */     
/*  327 */     this.jTextField4.setEnabled(false);
/*      */     
/*  329 */     this.jLabel2.setText("Fecha:");
/*      */     
/*  331 */     this.jDateChooser9.setDate(this.fechaActual);
/*  332 */     this.jDateChooser9.setDateFormatString("dd-MM-yyyy");
/*  333 */     this.jDateChooser9.setEnabled(false);
/*  334 */     this.jDateChooser9.setMaxSelectableDate(this.fechaActual);
/*      */     
/*  336 */     this.jLabel6.setText("Eco:");
/*      */     
/*  338 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/*  339 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  341 */             Reseteos.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  345 */     this.jPanel3.setBackground(new Color(146, 193, 134));
/*      */     
/*  347 */     this.jTextField5.setNextFocusableComponent(this.jFormattedTextField1);
/*      */     
/*  349 */     this.jLabel10.setText("Operador");
/*      */     
/*  351 */     this.jLabel18.setText("Vales asignados");
/*      */     
/*  353 */     this.jLabel19.setText("Guias asignadas");
/*      */     
/*  355 */     this.jTextArea1.setColumns(20);
/*  356 */     this.jTextArea1.setRows(3);
/*  357 */     this.jTextArea1.setEnabled(false);
/*  358 */     this.jScrollPane3.setViewportView(this.jTextArea1);
/*      */     
/*  360 */     this.jTextArea2.setColumns(20);
/*  361 */     this.jTextArea2.setRows(3);
/*  362 */     this.jTextArea2.setEnabled(false);
/*  363 */     this.jScrollPane5.setViewportView(this.jTextArea2);
/*      */     
/*  365 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  366 */     this.jPanel3.setLayout(jPanel3Layout);
/*  367 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  368 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  369 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  370 */           .addContainerGap()
/*  371 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  372 */             .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  373 */               .addComponent(this.jLabel18, -2, 95, -2)
/*  374 */               .addComponent(this.jLabel19, GroupLayout.Alignment.TRAILING, -2, 95, -2))
/*  375 */             .addComponent(this.jLabel10, -2, 95, -2))
/*  376 */           .addGap(10, 10, 10)
/*  377 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  378 */             .addComponent(this.jTextField5)
/*  379 */             .addComponent(this.jScrollPane3, GroupLayout.Alignment.TRAILING)
/*  380 */             .addComponent(this.jScrollPane5))
/*  381 */           .addContainerGap()));
/*      */     
/*  383 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  384 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  385 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  386 */           .addContainerGap()
/*  387 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  388 */             .addComponent(this.jLabel10)
/*  389 */             .addComponent(this.jTextField5, -2, -1, -2))
/*  390 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  391 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  392 */             .addComponent(this.jLabel18)
/*  393 */             .addComponent(this.jScrollPane5, -2, 62, -2))
/*  394 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  395 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  396 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  397 */               .addGap(0, 0, 32767)
/*  398 */               .addComponent(this.jLabel19)
/*  399 */               .addGap(60, 60, 60))
/*  400 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  401 */               .addComponent(this.jScrollPane3)
/*  402 */               .addContainerGap()))));
/*      */ 
/*      */     
/*  405 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*      */     
/*  407 */     this.jLabel11.setText("Km Recorridos");
/*      */     
/*  409 */     this.jLabel12.setText("Rendimiento");
/*      */     
/*  411 */     this.jLabel13.setText("Lts consumidos");
/*      */     
/*  413 */     this.jLabel14.setText("Lts en contra");
/*      */     
/*  415 */     this.jLabel16.setText("Cm Faltantes 1");
/*  416 */     this.jLabel16.setToolTipText("Lado Izquierdo");
/*      */     
/*  418 */     this.jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*      */     
/*  420 */     this.jFormattedTextField2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*      */     
/*  422 */     this.jFormattedTextField3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*      */     
/*  424 */     this.jFormattedTextField4.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*      */     
/*  426 */     this.jFormattedTextField5.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*      */     
/*  428 */     this.jLabel22.setHorizontalAlignment(4);
/*  429 */     this.jLabel22.setText("Cm faltantes 2");
/*  430 */     this.jLabel22.setToolTipText("Lado Derecho");
/*      */     
/*  432 */     this.jFormattedTextField6.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*      */     
/*  434 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  435 */     this.jPanel5.setLayout(jPanel5Layout);
/*  436 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  437 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  438 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  439 */           .addContainerGap()
/*  440 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  441 */             .addComponent(this.jLabel16, -2, 95, -2)
/*  442 */             .addComponent(this.jLabel14, -2, 95, -2)
/*  443 */             .addComponent(this.jLabel13, -2, 95, -2)
/*  444 */             .addComponent(this.jLabel12, -2, 95, -2)
/*  445 */             .addComponent(this.jLabel11, -2, 95, -2))
/*  446 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  447 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  448 */             .addComponent(this.jFormattedTextField1)
/*  449 */             .addComponent(this.jFormattedTextField2)
/*  450 */             .addComponent(this.jFormattedTextField3)
/*  451 */             .addComponent(this.jFormattedTextField4)
/*  452 */             .addGroup(jPanel5Layout.createSequentialGroup()
/*  453 */               .addComponent(this.jFormattedTextField5, -2, 57, -2)
/*  454 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  455 */               .addComponent(this.jLabel22, -2, 95, -2)
/*  456 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  457 */               .addComponent(this.jFormattedTextField6, -2, 57, -2)))
/*  458 */           .addContainerGap()));
/*      */     
/*  460 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/*  461 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  462 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  463 */           .addContainerGap()
/*  464 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  465 */             .addComponent(this.jLabel11)
/*  466 */             .addComponent(this.jFormattedTextField1, -2, -1, -2))
/*  467 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  468 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  469 */             .addComponent(this.jLabel12)
/*  470 */             .addComponent(this.jFormattedTextField2, -2, -1, -2))
/*  471 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  472 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  473 */             .addComponent(this.jLabel13)
/*  474 */             .addComponent(this.jFormattedTextField3, -2, -1, -2))
/*  475 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  476 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  477 */             .addComponent(this.jLabel14)
/*  478 */             .addComponent(this.jFormattedTextField4, -2, -1, -2))
/*  479 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  480 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  481 */             .addComponent(this.jLabel16)
/*  482 */             .addComponent(this.jFormattedTextField5, -2, -1, -2)
/*  483 */             .addComponent(this.jLabel22)
/*  484 */             .addComponent(this.jFormattedTextField6, -2, -1, -2))
/*  485 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  488 */     this.jLabel20.setText("Información del reseteo anterior:");
/*      */     
/*  490 */     this.jButton4.setText("Cerrar");
/*  491 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  493 */             Reseteos.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  497 */     this.jButton7.setText("Guardar");
/*  498 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  500 */             Reseteos.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  504 */     this.jTextPane1.setEnabled(false);
/*  505 */     this.jScrollPane4.setViewportView(this.jTextPane1);
/*      */     
/*  507 */     this.jLabel21.setText("Comentario para este reseteo:");
/*      */     
/*  509 */     this.jScrollPane6.setViewportView(this.jTextPane2);
/*      */     
/*  511 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  512 */     this.jPanel1.setLayout(jPanel1Layout);
/*  513 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  514 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  515 */         .addComponent(this.jLabel66, -1, -1, 32767)
/*  516 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  517 */           .addContainerGap()
/*  518 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  519 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/*  520 */               .addComponent(this.jPanel3, -1, -1, 32767)
/*  521 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  522 */               .addComponent(this.jPanel5, -2, -1, -2))
/*  523 */             .addComponent(this.jScrollPane4, GroupLayout.Alignment.TRAILING)
/*  524 */             .addComponent(this.jSeparator1)
/*  525 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  526 */               .addComponent(this.jLabel1, -2, 61, -2)
/*  527 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  528 */               .addComponent(this.jTextField4, -2, 153, -2)
/*  529 */               .addGap(71, 71, 71)
/*  530 */               .addComponent(this.jLabel2, -2, 61, -2)
/*  531 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  532 */               .addComponent((Component)this.jDateChooser9, -2, 112, -2)
/*  533 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 114, 32767)
/*  534 */               .addComponent(this.jLabel6, -2, 56, -2)
/*  535 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  536 */               .addComponent(this.jComboBox2, -2, 99, -2))
/*  537 */             .addComponent(this.jSeparator2)
/*  538 */             .addComponent(this.jSeparator3, GroupLayout.Alignment.TRAILING)
/*  539 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/*  540 */               .addGap(0, 0, 32767)
/*  541 */               .addComponent(this.jButton7, -2, 111, -2)
/*  542 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  543 */               .addComponent(this.jButton4, -2, 111, -2))
/*  544 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  545 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  546 */                 .addComponent(this.jLabel20, -2, 183, -2)
/*  547 */                 .addComponent(this.jLabel21, -2, 183, -2))
/*  548 */               .addGap(0, 0, 32767))
/*  549 */             .addComponent(this.jScrollPane6))
/*  550 */           .addContainerGap()));
/*      */     
/*  552 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  553 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  554 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  555 */           .addComponent(this.jLabel66)
/*  556 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  557 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  558 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  559 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  560 */             .addComponent(this.jLabel2, -1, -1, 32767)
/*  561 */             .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  562 */               .addComponent(this.jLabel1)
/*  563 */               .addComponent(this.jTextField4, -2, -1, -2))
/*  564 */             .addComponent((Component)this.jDateChooser9, -2, -1, -2)
/*  565 */             .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  566 */               .addComponent(this.jLabel6)
/*  567 */               .addComponent(this.jComboBox2, -2, -1, -2)))
/*  568 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  569 */           .addComponent(this.jSeparator2, -2, 10, -2)
/*  570 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  571 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  572 */             .addComponent(this.jPanel3, -1, -1, 32767)
/*  573 */             .addComponent(this.jPanel5, -1, -1, 32767))
/*  574 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  575 */           .addComponent(this.jLabel21)
/*  576 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  577 */           .addComponent(this.jScrollPane6, -2, 87, -2)
/*  578 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767)
/*  579 */           .addComponent(this.jLabel20)
/*  580 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  581 */           .addComponent(this.jScrollPane4, -2, 87, -2)
/*  582 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  583 */           .addComponent(this.jSeparator3, -2, 10, -2)
/*  584 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  585 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  586 */             .addComponent(this.jButton4)
/*  587 */             .addComponent(this.jButton7))
/*  588 */           .addContainerGap()));
/*      */ 
/*      */     
/*  591 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  592 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  593 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  594 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  595 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */     
/*  597 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  598 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  599 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  600 */           .addComponent(this.jPanel1, -2, -1, -2)
/*  601 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  604 */     this.jDialog2.setTitle("Información del reseteo");
/*  605 */     this.jDialog2.setModal(true);
/*      */     
/*  607 */     this.jPanel4.setBackground(new Color(146, 193, 134));
/*      */     
/*  609 */     this.jLabel67.setFont(new Font("Tahoma", 1, 18));
/*  610 */     this.jLabel67.setForeground(new Color(0, 102, 102));
/*  611 */     this.jLabel67.setHorizontalAlignment(0);
/*  612 */     this.jLabel67.setText("RESETEO");
/*      */     
/*  614 */     this.jLabel23.setText("Folio:");
/*      */     
/*  616 */     this.jTextField6.setEnabled(false);
/*      */     
/*  618 */     this.jLabel25.setText("Eco:");
/*      */     
/*  620 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/*      */     
/*  622 */     this.jTextField7.setEnabled(false);
/*  623 */     this.jTextField7.setNextFocusableComponent(this.jFormattedTextField1);
/*      */     
/*  625 */     this.jLabel26.setText("Operador");
/*      */     
/*  627 */     this.jLabel27.setText("Vales asignados");
/*      */     
/*  629 */     this.jLabel28.setText("Guias asignadas");
/*      */     
/*  631 */     this.jTextArea3.setColumns(20);
/*  632 */     this.jTextArea3.setRows(3);
/*  633 */     this.jTextArea3.setEnabled(false);
/*  634 */     this.jScrollPane7.setViewportView(this.jTextArea3);
/*      */     
/*  636 */     this.jTextArea4.setColumns(20);
/*  637 */     this.jTextArea4.setRows(3);
/*  638 */     this.jTextArea4.setEnabled(false);
/*  639 */     this.jScrollPane8.setViewportView(this.jTextArea4);
/*      */     
/*  641 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  642 */     this.jPanel7.setLayout(jPanel7Layout);
/*  643 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  644 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  645 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  646 */           .addContainerGap()
/*  647 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  648 */             .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  649 */               .addComponent(this.jLabel27, -2, 95, -2)
/*  650 */               .addComponent(this.jLabel28, GroupLayout.Alignment.TRAILING, -2, 95, -2))
/*  651 */             .addComponent(this.jLabel26, -2, 95, -2))
/*  652 */           .addGap(10, 10, 10)
/*  653 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  654 */             .addComponent(this.jTextField7)
/*  655 */             .addComponent(this.jScrollPane7, GroupLayout.Alignment.TRAILING, -1, 258, 32767)
/*  656 */             .addComponent(this.jScrollPane8))
/*  657 */           .addContainerGap()));
/*      */     
/*  659 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  660 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  661 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  662 */           .addContainerGap()
/*  663 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  664 */             .addComponent(this.jLabel26)
/*  665 */             .addComponent(this.jTextField7, -2, -1, -2))
/*  666 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  667 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  668 */             .addComponent(this.jLabel27)
/*  669 */             .addComponent(this.jScrollPane8, -2, 62, -2))
/*  670 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  671 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  672 */             .addGroup(jPanel7Layout.createSequentialGroup()
/*  673 */               .addGap(0, 0, 32767)
/*  674 */               .addComponent(this.jLabel28)
/*  675 */               .addGap(60, 60, 60))
/*  676 */             .addGroup(jPanel7Layout.createSequentialGroup()
/*  677 */               .addComponent(this.jScrollPane7)
/*  678 */               .addContainerGap()))));
/*      */ 
/*      */     
/*  681 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*      */     
/*  683 */     this.jLabel29.setText("Km Recorridos");
/*      */     
/*  685 */     this.jLabel30.setText("Rendimiento");
/*      */     
/*  687 */     this.jLabel31.setText("Lts consumidos");
/*      */     
/*  689 */     this.jLabel32.setText("Lts en contra");
/*      */     
/*  691 */     this.jLabel33.setText("Cm Faltantes 1");
/*  692 */     this.jLabel33.setToolTipText("Lado Izquierdo");
/*      */     
/*  694 */     this.jFormattedTextField7.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  695 */     this.jFormattedTextField7.setEnabled(false);
/*      */     
/*  697 */     this.jFormattedTextField8.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  698 */     this.jFormattedTextField8.setEnabled(false);
/*      */     
/*  700 */     this.jFormattedTextField9.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  701 */     this.jFormattedTextField9.setEnabled(false);
/*      */     
/*  703 */     this.jFormattedTextField10.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  704 */     this.jFormattedTextField10.setEnabled(false);
/*      */     
/*  706 */     this.jFormattedTextField11.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  707 */     this.jFormattedTextField11.setEnabled(false);
/*      */     
/*  709 */     this.jLabel34.setHorizontalAlignment(4);
/*  710 */     this.jLabel34.setText("Cm faltantes 2");
/*  711 */     this.jLabel34.setToolTipText("Lado Derecho");
/*      */     
/*  713 */     this.jFormattedTextField12.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  714 */     this.jFormattedTextField12.setEnabled(false);
/*      */     
/*  716 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  717 */     this.jPanel8.setLayout(jPanel8Layout);
/*  718 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  719 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  720 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  721 */           .addContainerGap()
/*  722 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  723 */             .addComponent(this.jLabel33, -2, 95, -2)
/*  724 */             .addComponent(this.jLabel32, -2, 95, -2)
/*  725 */             .addComponent(this.jLabel31, -2, 95, -2)
/*  726 */             .addComponent(this.jLabel30, -2, 95, -2)
/*  727 */             .addComponent(this.jLabel29, -2, 95, -2))
/*  728 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  729 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  730 */             .addComponent(this.jFormattedTextField7)
/*  731 */             .addComponent(this.jFormattedTextField8)
/*  732 */             .addComponent(this.jFormattedTextField9)
/*  733 */             .addComponent(this.jFormattedTextField10)
/*  734 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  735 */               .addComponent(this.jFormattedTextField11, -2, 57, -2)
/*  736 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  737 */               .addComponent(this.jLabel34, -2, 95, -2)
/*  738 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  739 */               .addComponent(this.jFormattedTextField12, -2, 57, -2)))
/*  740 */           .addContainerGap()));
/*      */     
/*  742 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  743 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  744 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  745 */           .addContainerGap()
/*  746 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  747 */             .addComponent(this.jLabel29)
/*  748 */             .addComponent(this.jFormattedTextField7, -2, -1, -2))
/*  749 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  750 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  751 */             .addComponent(this.jLabel30)
/*  752 */             .addComponent(this.jFormattedTextField8, -2, -1, -2))
/*  753 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  754 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  755 */             .addComponent(this.jLabel31)
/*  756 */             .addComponent(this.jFormattedTextField9, -2, -1, -2))
/*  757 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  758 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  759 */             .addComponent(this.jLabel32)
/*  760 */             .addComponent(this.jFormattedTextField10, -2, -1, -2))
/*  761 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  762 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  763 */             .addComponent(this.jLabel33)
/*  764 */             .addComponent(this.jFormattedTextField11, -2, -1, -2)
/*  765 */             .addComponent(this.jLabel34)
/*  766 */             .addComponent(this.jFormattedTextField12, -2, -1, -2))
/*  767 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  770 */     this.jLabel35.setText("Información del reseteo anterior:");
/*      */     
/*  772 */     this.jButton8.setText("Cerrar");
/*  773 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  775 */             Reseteos.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  779 */     this.jTextPane3.setEnabled(false);
/*  780 */     this.jScrollPane9.setViewportView(this.jTextPane3);
/*      */     
/*  782 */     this.jLabel36.setText("Comentario para este reseteo:");
/*      */     
/*  784 */     this.jTextPane4.setEnabled(false);
/*  785 */     this.jScrollPane10.setViewportView(this.jTextPane4);
/*      */     
/*  787 */     this.jTextField8.setEnabled(false);
/*      */     
/*  789 */     this.jButton2.setMnemonic('I');
/*  790 */     this.jButton2.setText("Imprimir");
/*  791 */     this.jButton2.setToolTipText("Imprimir (Alt+I)");
/*      */     
/*  793 */     this.jLabel37.setHorizontalAlignment(4);
/*  794 */     this.jLabel37.setText("Fecha:");
/*      */     
/*  796 */     this.jTextField9.setEnabled(false);
/*      */     
/*  798 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  799 */     this.jPanel4.setLayout(jPanel4Layout);
/*  800 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  801 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  802 */         .addComponent(this.jLabel67, -1, -1, 32767)
/*  803 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  804 */           .addContainerGap()
/*  805 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  806 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/*  807 */               .addComponent(this.jPanel7, -1, -1, 32767)
/*  808 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  809 */               .addComponent(this.jPanel8, -2, -1, -2))
/*  810 */             .addComponent(this.jScrollPane9, GroupLayout.Alignment.TRAILING)
/*  811 */             .addComponent(this.jSeparator4)
/*  812 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  813 */               .addComponent(this.jLabel23, -2, 61, -2)
/*  814 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  815 */               .addComponent(this.jTextField6, -2, 153, -2)
/*  816 */               .addGap(77, 77, 77)
/*  817 */               .addComponent(this.jLabel37, -2, 56, -2)
/*  818 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  819 */               .addComponent(this.jTextField9, -2, 143, -2)
/*  820 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  821 */               .addComponent(this.jLabel25, -2, 56, -2)
/*  822 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  823 */               .addComponent(this.jTextField8, -2, 99, -2))
/*  824 */             .addComponent(this.jSeparator5)
/*  825 */             .addComponent(this.jSeparator6, GroupLayout.Alignment.TRAILING)
/*  826 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/*  827 */               .addGap(0, 0, 32767)
/*  828 */               .addComponent(this.jButton2, -2, 109, -2)
/*  829 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  830 */               .addComponent(this.jButton8, -2, 111, -2))
/*  831 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  832 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  833 */                 .addComponent(this.jLabel35, -2, 183, -2)
/*  834 */                 .addComponent(this.jLabel36, -2, 183, -2))
/*  835 */               .addGap(0, 0, 32767))
/*  836 */             .addComponent(this.jScrollPane10))
/*  837 */           .addContainerGap()));
/*      */     
/*  839 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  840 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  841 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  842 */           .addComponent(this.jLabel67)
/*  843 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  844 */           .addComponent(this.jSeparator4, -2, 10, -2)
/*  845 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  846 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  847 */             .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  848 */               .addComponent(this.jLabel23)
/*  849 */               .addComponent(this.jTextField6, -2, -1, -2)
/*  850 */               .addComponent(this.jLabel37)
/*  851 */               .addComponent(this.jTextField9, -2, -1, -2))
/*  852 */             .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  853 */               .addComponent(this.jLabel25)
/*  854 */               .addComponent(this.jTextField8, -2, -1, -2)))
/*  855 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  856 */           .addComponent(this.jSeparator5, -2, 10, -2)
/*  857 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  858 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  859 */             .addComponent(this.jPanel7, -1, -1, 32767)
/*  860 */             .addComponent(this.jPanel8, -1, -1, 32767))
/*  861 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  862 */           .addComponent(this.jLabel36)
/*  863 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  864 */           .addComponent(this.jScrollPane10, -2, 87, -2)
/*  865 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767)
/*  866 */           .addComponent(this.jLabel35)
/*  867 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  868 */           .addComponent(this.jScrollPane9, -2, 87, -2)
/*  869 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  870 */           .addComponent(this.jSeparator6, -2, 10, -2)
/*  871 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  872 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  873 */             .addComponent(this.jButton8)
/*  874 */             .addComponent(this.jButton2))
/*  875 */           .addContainerGap()));
/*      */ 
/*      */     
/*  878 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  879 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  880 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  881 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  882 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*      */     
/*  884 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  885 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  886 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  887 */           .addComponent(this.jPanel4, -2, -1, -2)
/*  888 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  891 */     this.jDialog3.setTitle("Cancelar Reseteo");
/*  892 */     this.jDialog3.setModal(true);
/*      */     
/*  894 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*      */     
/*  896 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/*  897 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/*  898 */     this.jLabel124.setHorizontalAlignment(0);
/*  899 */     this.jLabel124.setText("Motivo de la Cancelación");
/*      */     
/*  901 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/*  902 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/*  903 */     this.jLabel125.setHorizontalAlignment(4);
/*  904 */     this.jLabel125.setText("Motivo");
/*      */     
/*  906 */     this.jButton44.setMnemonic('A');
/*  907 */     this.jButton44.setText("Cancelar Reseteo");
/*  908 */     this.jButton44.setToolTipText("Cancelar reseteo (Alt+A)");
/*  909 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  911 */             Reseteos.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  915 */     this.jButton45.setMnemonic('C');
/*  916 */     this.jButton45.setText("Cerrar");
/*  917 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/*  918 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  920 */             Reseteos.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  924 */     this.jTextArea5.setColumns(20);
/*  925 */     this.jTextArea5.setLineWrap(true);
/*  926 */     this.jTextArea5.setRows(5);
/*  927 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/*  929 */     this.jLabel126.setText("Ingresa el motivo por el cual deseas cancelar el reseteo");
/*      */     
/*  931 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/*  932 */     this.jPanel29.setLayout(jPanel29Layout);
/*  933 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/*  934 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  935 */         .addGroup(jPanel29Layout.createSequentialGroup()
/*  936 */           .addContainerGap()
/*  937 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  938 */             .addComponent(this.jLabel126, -1, -1, 32767)
/*  939 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  940 */               .addGroup(jPanel29Layout.createSequentialGroup()
/*  941 */                 .addComponent(this.jButton44, -2, 137, -2)
/*  942 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  943 */                 .addComponent(this.jButton45, -2, 84, -2))
/*  944 */               .addGroup(jPanel29Layout.createSequentialGroup()
/*  945 */                 .addComponent(this.jLabel125, -2, 43, -2)
/*  946 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  947 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/*  948 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  949 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  950 */               .addComponent(this.jSeparator29, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/*  951 */           .addContainerGap()));
/*      */     
/*  953 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/*  954 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  955 */         .addGroup(jPanel29Layout.createSequentialGroup()
/*  956 */           .addComponent(this.jLabel124)
/*  957 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  958 */           .addComponent(this.jSeparator29, -2, 10, -2)
/*  959 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  960 */           .addComponent(this.jLabel126)
/*  961 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  962 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  963 */             .addComponent(this.jLabel125)
/*  964 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/*  965 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  966 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  967 */             .addComponent(this.jButton45)
/*  968 */             .addComponent(this.jButton44))
/*  969 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  972 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/*  973 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/*  974 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/*  975 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  976 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */     
/*  978 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/*  979 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  980 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */ 
/*      */     
/*  983 */     this.cantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*      */     
/*  985 */     this.jLabel24.setText("Selecciona los datos que deseas graficar:");
/*      */     
/*  987 */     this.jRadioButton3.setSelected(true);
/*  988 */     this.jRadioButton3.setText("Económico");
/*      */     
/*  990 */     this.jRadioButton4.setText("Periodo");
/*      */     
/*  992 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  993 */     this.jPanel9.setLayout(jPanel9Layout);
/*  994 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  995 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  996 */         .addComponent(this.jSeparator7)
/*  997 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  998 */           .addGap(10, 10, 10)
/*  999 */           .addComponent(this.jRadioButton3, -2, 126, -2)
/* 1000 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1001 */           .addComponent(this.jRadioButton4, -2, 111, -2)
/* 1002 */           .addContainerGap(-1, 32767))
/* 1003 */         .addComponent(this.jLabel24, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 1005 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1006 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1007 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1008 */           .addComponent(this.jLabel24)
/* 1009 */           .addGap(1, 1, 1)
/* 1010 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 1011 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1012 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1013 */             .addComponent(this.jRadioButton3)
/* 1014 */             .addComponent(this.jRadioButton4))
/* 1015 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1018 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/* 1019 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1021 */     this.jLabel3.setFont(new Font("Tahoma", 1, 18));
/* 1022 */     this.jLabel3.setForeground(new Color(10, 126, 68));
/* 1023 */     this.jLabel3.setText("RESETEOS");
/*      */     
/* 1025 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 1026 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/*      */     
/* 1028 */     this.jButton3.setMnemonic('F');
/* 1029 */     this.jButton3.setText("Filtrar");
/* 1030 */     this.jButton3.setToolTipText("Filtrar (Alt +F)");
/* 1031 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1033 */             Reseteos.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1037 */     this.jLabel4.setFont(new Font("Tahoma", 1, 14));
/* 1038 */     this.jLabel4.setForeground(Color.red);
/* 1039 */     this.jLabel4.setHorizontalAlignment(0);
/* 1040 */     this.jLabel4.setText("AL");
/*      */     
/* 1042 */     this.jLabel5.setFont(new Font("Tahoma", 1, 14));
/* 1043 */     this.jLabel5.setForeground(Color.red);
/* 1044 */     this.jLabel5.setText(" REPORTE DE RESETEO");
/*      */     
/* 1046 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1047 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 1048 */     this.jDateChooser4.setIcon(this.icon);
/* 1049 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 1050 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1052 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1053 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1054 */     this.jDateChooser5.setIcon(this.icon);
/* 1055 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 1056 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1058 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/* 1059 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/* 1060 */     this.jLabel7.setText("<html><u>Todos </u></html>");
/* 1061 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1063 */             Reseteos.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1066 */             Reseteos.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1069 */             Reseteos.this.jLabel7MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1073 */     this.jLabel8.setFont(new Font("Tahoma", 2, 12));
/* 1074 */     this.jLabel8.setForeground(new Color(15, 87, 51));
/* 1075 */     this.jLabel8.setHorizontalAlignment(0);
/* 1076 */     this.jLabel8.setText("<html><u>Hoy</u></html>");
/* 1077 */     this.jLabel8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1079 */             Reseteos.this.jLabel8MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1082 */             Reseteos.this.jLabel8MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1085 */             Reseteos.this.jLabel8MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1089 */     this.jLabel9.setFont(new Font("Tahoma", 2, 12));
/* 1090 */     this.jLabel9.setForeground(new Color(15, 87, 51));
/* 1091 */     this.jLabel9.setText("<html><u>Ayer</u></html>");
/* 1092 */     this.jLabel9.addMouseListener(new MouseAdapter() {
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1094 */             Reseteos.this.jLabel9MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1097 */             Reseteos.this.jLabel9MouseExited(evt);
/*      */           }
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1100 */             Reseteos.this.jLabel9MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/* 1104 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1105 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1106 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1107 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1108 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1109 */           .addComponent(this.jLabel5, -2, 190, -2)
/* 1110 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1111 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 1112 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1113 */           .addComponent(this.jLabel4, -2, 20, -2)
/* 1114 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1115 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 1116 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1117 */           .addComponent(this.jButton3)
/* 1118 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1119 */           .addComponent(this.jLabel7, -2, -1, -2)
/* 1120 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1121 */           .addComponent(this.jLabel8, -2, 31, -2)
/* 1122 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1123 */           .addComponent(this.jLabel9, -2, 31, -2)
/* 1124 */           .addContainerGap(17, 32767)));
/*      */     
/* 1126 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1127 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1128 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1129 */           .addContainerGap()
/* 1130 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1131 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1132 */               .addComponent(this.jButton3)
/* 1133 */               .addComponent(this.jLabel7)
/* 1134 */               .addComponent(this.jLabel8)
/* 1135 */               .addComponent(this.jLabel9, -2, 15, -2))
/* 1136 */             .addComponent(this.jLabel4, -1, -1, 32767)
/* 1137 */             .addComponent((Component)this.jDateChooser5, -2, -1, -2)
/* 1138 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1139 */               .addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1140 */               .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 1141 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1144 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 1145 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Reseteos", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1147 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1149 */             Reseteos.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1152 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1154 */             Reseteos.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1158 */     this.jLabel15.setFont(new Font("Tahoma", 3, 12));
/* 1159 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 1160 */     this.jLabel15.setHorizontalAlignment(0);
/* 1161 */     this.jLabel15.setText("Folio");
/*      */     
/* 1163 */     this.jLabel56.setFont(new Font("Tahoma", 3, 12));
/* 1164 */     this.jLabel56.setForeground(new Color(15, 87, 51));
/* 1165 */     this.jLabel56.setHorizontalAlignment(0);
/* 1166 */     this.jLabel56.setText("Operador");
/*      */     
/* 1168 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1170 */             Reseteos.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1173 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1175 */             Reseteos.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1179 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1180 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 1181 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "<ACTIVO>", "<CANCELADO>", "TODOS" }));
/* 1182 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1184 */             Reseteos.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1188 */     this.jLabel46.setFont(new Font("Tahoma", 3, 12));
/* 1189 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 1190 */     this.jLabel46.setHorizontalAlignment(0);
/* 1191 */     this.jLabel46.setText("Estatus");
/*      */     
/* 1193 */     this.jLabel17.setFont(new Font("Tahoma", 3, 12));
/* 1194 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/* 1195 */     this.jLabel17.setHorizontalAlignment(0);
/* 1196 */     this.jLabel17.setText("Eco");
/*      */     
/* 1198 */     this.jTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1200 */             Reseteos.this.jTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1203 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1205 */             Reseteos.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1209 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 1210 */     this.jPanel17.setLayout(jPanel17Layout);
/* 1211 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 1212 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1213 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1214 */           .addContainerGap()
/* 1215 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1216 */             .addComponent(this.jLabel46, -1, -1, 32767)
/* 1217 */             .addComponent(this.jComboBox1, 0, 114, 32767))
/* 1218 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1219 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1220 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 1221 */             .addComponent(this.jTextField1, -2, 82, -2))
/* 1222 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1223 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1224 */             .addComponent(this.jLabel17, -1, -1, 32767)
/* 1225 */             .addComponent(this.jTextField2, -2, 82, -2))
/* 1226 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1227 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1228 */             .addComponent(this.jTextField3)
/* 1229 */             .addComponent(this.jLabel56, -1, 193, 32767))
/* 1230 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1232 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 1233 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1234 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1235 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1236 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1237 */               .addComponent(this.jComboBox1, -2, -1, -2)
/* 1238 */               .addGap(8, 8, 8)
/* 1239 */               .addComponent(this.jLabel46))
/* 1240 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1241 */               .addComponent(this.jTextField1, -2, -1, -2)
/* 1242 */               .addGap(8, 8, 8)
/* 1243 */               .addComponent(this.jLabel15))
/* 1244 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1245 */               .addComponent(this.jTextField2, -2, -1, -2)
/* 1246 */               .addGap(8, 8, 8)
/* 1247 */               .addComponent(this.jLabel17))
/* 1248 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1249 */               .addComponent(this.jTextField3, -2, -1, -2)
/* 1250 */               .addGap(8, 8, 8)
/* 1251 */               .addComponent(this.jLabel56)))
/* 1252 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1255 */     this.jPanel18.setBackground(new Color(146, 193, 134));
/* 1256 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder(null, "Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1258 */     this.jScrollPane2.addInputMethodListener(new InputMethodListener() {
/*      */           public void inputMethodTextChanged(InputMethodEvent evt) {}
/*      */           
/*      */           public void caretPositionChanged(InputMethodEvent evt) {
/* 1262 */             Reseteos.this.jScrollPane2CaretPositionChanged(evt);
/*      */           }
/*      */         });
/*      */     
/* 1266 */     jTable2.setFont(new Font("Tahoma", 0, 10));
/* 1267 */     jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Ruta", "Operador", "Eco", "Guías", "Autorizó" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1275 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1280 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1283 */     jTable2.setShowVerticalLines(false);
/* 1284 */     jTable2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1286 */             Reseteos.this.jTable2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1289 */     this.jScrollPane2.setViewportView(jTable2);
/*      */     
/* 1291 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1292 */     this.jLabel48.setForeground(Color.red);
/* 1293 */     this.jLabel48.setHorizontalAlignment(2);
/* 1294 */     this.jLabel48.setText("t");
/* 1295 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1297 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1298 */     this.jButton5.setMnemonic('U');
/* 1299 */     this.jButton5.setText("Modificar");
/* 1300 */     this.jButton5.setToolTipText("Cargar Vale Utilitario (Alt+U)");
/* 1301 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1303 */             Reseteos.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1307 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1308 */     this.jButton11.setMnemonic('C');
/* 1309 */     this.jButton11.setText("Cancelar");
/* 1310 */     this.jButton11.setToolTipText("Cancelar (Alt+C)");
/* 1311 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1313 */             Reseteos.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1317 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1318 */     this.jButton6.setMnemonic('G');
/* 1319 */     this.jButton6.setText("Guardar Reporte");
/* 1320 */     this.jButton6.setToolTipText("Guardar Reporte (Alt+G)");
/* 1321 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1323 */             Reseteos.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1327 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1328 */     this.jButton1.setMnemonic('N');
/* 1329 */     this.jButton1.setText("Nuevo");
/* 1330 */     this.jButton1.setToolTipText("Nuevo (Alt+N)");
/* 1331 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1333 */             Reseteos.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1337 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Refresh.png")));
/* 1338 */     this.jButton9.setMnemonic('A');
/* 1339 */     this.jButton9.setText("Autorizar");
/* 1340 */     this.jButton9.setToolTipText("Autorizar Liquidación (Alt+A)");
/* 1341 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1343 */             Reseteos.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1347 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Bar Chart.png")));
/* 1348 */     this.jButton10.setMnemonic('A');
/* 1349 */     this.jButton10.setText("Graficar");
/* 1350 */     this.jButton10.setToolTipText("Autorizar Liquidación (Alt+A)");
/* 1351 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1353 */             Reseteos.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1357 */     this.jButton12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1358 */     this.jButton12.setMnemonic('A');
/* 1359 */     this.jButton12.setText("Imprimir");
/* 1360 */     this.jButton12.setToolTipText("Autorizar Liquidación (Alt+A)");
/* 1361 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1363 */             Reseteos.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1367 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 1368 */     this.jPanel18.setLayout(jPanel18Layout);
/* 1369 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 1370 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1371 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1372 */           .addContainerGap()
/* 1373 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1374 */             .addComponent(this.jScrollPane2)
/* 1375 */             .addGroup(jPanel18Layout.createSequentialGroup()
/* 1376 */               .addComponent(this.jLabel48, -2, 163, -2)
/* 1377 */               .addGap(18, 18, 18)
/* 1378 */               .addComponent(this.jButton1, -2, 121, -2)
/* 1379 */               .addGap(18, 18, 18)
/* 1380 */               .addComponent(this.jButton11, -2, 122, -2)
/* 1381 */               .addGap(18, 18, 18)
/* 1382 */               .addComponent(this.jButton5, -2, 117, -2)
/* 1383 */               .addGap(18, 18, 18)
/* 1384 */               .addComponent(this.jButton9, -2, 118, -2)
/* 1385 */               .addGap(18, 18, 18)
/* 1386 */               .addComponent(this.jButton12, -2, 118, -2)
/* 1387 */               .addGap(18, 18, 18)
/* 1388 */               .addComponent(this.jButton10, -2, 120, -2)
/* 1389 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, 32767)
/* 1390 */               .addComponent(this.jButton6, -2, 162, -2)))
/* 1391 */           .addContainerGap()));
/*      */     
/* 1393 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 1394 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1395 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1396 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1397 */             .addComponent(this.jLabel48)
/* 1398 */             .addComponent(this.jButton11)
/* 1399 */             .addComponent(this.jButton5)
/* 1400 */             .addComponent(this.jButton6)
/* 1401 */             .addComponent(this.jButton1)
/* 1402 */             .addComponent(this.jButton9, -2, 29, -2)
/* 1403 */             .addComponent(this.jButton10, -2, 29, -2)
/* 1404 */             .addComponent(this.jButton12, -2, 29, -2))
/* 1405 */           .addGap(4, 4, 4)
/* 1406 */           .addComponent(this.jScrollPane2, -1, 164, 32767)));
/*      */ 
/*      */     
/* 1409 */     this.jLabel38.setFont(new Font("Tahoma", 1, 10));
/* 1410 */     this.jLabel38.setHorizontalAlignment(4);
/* 1411 */     this.jLabel38.setText("0.0");
/*      */     
/* 1413 */     this.jLabel39.setFont(new Font("Tahoma", 1, 10));
/* 1414 */     this.jLabel39.setHorizontalAlignment(4);
/* 1415 */     this.jLabel39.setText("0.0");
/*      */     
/* 1417 */     this.jLabel40.setFont(new Font("Tahoma", 1, 10));
/* 1418 */     this.jLabel40.setHorizontalAlignment(4);
/* 1419 */     this.jLabel40.setText("0.0");
/*      */     
/* 1421 */     this.jLabel41.setFont(new Font("Tahoma", 1, 10));
/* 1422 */     this.jLabel41.setHorizontalAlignment(4);
/* 1423 */     this.jLabel41.setText("0.0");
/*      */     
/* 1425 */     this.jLabel42.setFont(new Font("Tahoma", 1, 10));
/* 1426 */     this.jLabel42.setHorizontalAlignment(4);
/* 1427 */     this.jLabel42.setText("0.0");
/*      */     
/* 1429 */     this.jLabel43.setFont(new Font("Tahoma", 1, 10));
/* 1430 */     this.jLabel43.setHorizontalAlignment(4);
/* 1431 */     this.jLabel43.setText("0.0");
/*      */     
/* 1433 */     this.jLabel44.setFont(new Font("Tahoma", 1, 11));
/* 1434 */     this.jLabel44.setText("TOTALES:");
/*      */     
/* 1436 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1437 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1438 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1439 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1440 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1441 */           .addContainerGap()
/* 1442 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1443 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1444 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1445 */                 .addComponent(this.jPanel18, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1446 */                 .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1447 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
/* 1448 */                   .addComponent(this.jPanel2, -2, -1, -2)
/* 1449 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1450 */                   .addComponent(this.jLabel3, -1, -1, 32767)))
/* 1451 */               .addContainerGap())
/* 1452 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1453 */               .addComponent(this.jLabel44, -2, 127, -2)
/* 1454 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1455 */               .addComponent(this.jLabel43, -2, 91, -2)
/* 1456 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1457 */               .addComponent(this.jLabel42, -2, 91, -2)
/* 1458 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1459 */               .addComponent(this.jLabel38, -2, 91, -2)
/* 1460 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1461 */               .addComponent(this.jLabel40, -2, 91, -2)
/* 1462 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1463 */               .addComponent(this.jLabel41, -2, 91, -2)
/* 1464 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1465 */               .addComponent(this.jLabel39, -2, 89, -2)
/* 1466 */               .addGap(218, 218, 218)))));
/*      */     
/* 1468 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1469 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1470 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1471 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1472 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1473 */               .addContainerGap()
/* 1474 */               .addComponent(this.jPanel2, -2, 44, -2))
/* 1475 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1476 */               .addGap(21, 21, 21)
/* 1477 */               .addComponent(this.jLabel3)))
/* 1478 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1479 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 1480 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1481 */           .addComponent(this.jPanel18, -1, -1, 32767)
/* 1482 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1483 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1484 */             .addComponent(this.jLabel38)
/* 1485 */             .addComponent(this.jLabel39)
/* 1486 */             .addComponent(this.jLabel40)
/* 1487 */             .addComponent(this.jLabel41)
/* 1488 */             .addComponent(this.jLabel42)
/* 1489 */             .addComponent(this.jLabel43)
/* 1490 */             .addComponent(this.jLabel44))
/* 1491 */           .addGap(6, 6, 6)));
/*      */ 
/*      */     
/* 1494 */     GroupLayout layout = new GroupLayout(this);
/* 1495 */     setLayout(layout);
/* 1496 */     layout.setHorizontalGroup(layout
/* 1497 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1498 */         .addGap(0, 1309, 32767)
/* 1499 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1500 */           .addGroup(layout.createSequentialGroup()
/* 1501 */             .addContainerGap()
/* 1502 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 1503 */             .addContainerGap())));
/*      */     
/* 1505 */     layout.setVerticalGroup(layout
/* 1506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1507 */         .addGap(0, 398, 32767)
/* 1508 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1509 */           .addGroup(layout.createSequentialGroup()
/* 1510 */             .addGap(6, 6, 6)
/* 1511 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 1512 */             .addGap(6, 6, 6))));
/*      */   }
/*      */   private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JSeparator jSeparator1; private JSeparator jSeparator2; private JSeparator jSeparator29; private JSeparator jSeparator3; private JSeparator jSeparator4; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator7; private static JTable jTable2; private JTextArea jTextArea1; private JTextArea jTextArea2; private JTextArea jTextArea3; private JTextArea jTextArea4; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private JTextPane jTextPane1; private JTextPane jTextPane2; private JTextPane jTextPane3; private JTextPane jTextPane4;
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1517 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 1521 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 1522 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1523 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 1527 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/* 1531 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel8MouseClicked(MouseEvent evt) {
/* 1535 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1536 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1537 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel8MouseEntered(MouseEvent evt) {
/* 1541 */     this.jLabel8.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel8MouseExited(MouseEvent evt) {
/* 1545 */     this.jLabel8.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel9MouseClicked(MouseEvent evt) {
/* 1549 */     Calendar ca = Calendar.getInstance();
/* 1550 */     Calendar fecha = Calendar.getInstance();
/* 1551 */     int aa = fecha.get(1);
/* 1552 */     int mm = fecha.get(2);
/* 1553 */     int dd = fecha.get(5);
/* 1554 */     if (dd == 1) {
/* 1555 */       if (mm == 0) {
/* 1556 */         mm = 11;
/* 1557 */         aa--;
/*      */       } else {
/* 1559 */         mm--;
/*      */       } 
/* 1561 */       int diasTotal = diasDelMes(mm, aa);
/* 1562 */       dd = diasTotal;
/*      */     } else {
/* 1564 */       dd--;
/*      */     } 
/* 1566 */     mm++;
/* 1567 */     String año = "" + aa;
/* 1568 */     String mes = "" + mm;
/* 1569 */     String dia = "" + dd;
/* 1570 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1571 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 1573 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 1574 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 1575 */     } catch (ParseException ex) {
/* 1576 */       ex.printStackTrace();
/*      */     } 
/* 1578 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel9MouseEntered(MouseEvent evt) {
/* 1582 */     this.jLabel9.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel9MouseExited(MouseEvent evt) {
/* 1586 */     this.jLabel9.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1590 */     String cadena = this.jTextField1.getText();
/* 1591 */     if (!cadena.equals("")) {
/* 1592 */       if (this.presionado == null) {
/* 1593 */         this.presionado = new Presionado();
/* 1594 */         this.presionado.start();
/*      */       } else {
/* 1596 */         this.presionado.detenerFuera();
/* 1597 */         this.presionado = new Presionado();
/* 1598 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 1601 */       this.jTextField1.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 1606 */     String cadena = this.jTextField3.getText();
/* 1607 */     if (!cadena.equals("")) {
/* 1608 */       if (this.presionado == null) {
/* 1609 */         this.presionado = new Presionado();
/* 1610 */         this.presionado.start();
/*      */       } else {
/* 1612 */         this.presionado.detenerFuera();
/* 1613 */         this.presionado = new Presionado();
/* 1614 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 1617 */       this.jTextField3.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1622 */     if (this.jComboBox1.getItemCount() > 0) {
/* 1623 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 1628 */     String cadena = this.jTextField2.getText();
/* 1629 */     if (!cadena.equals("")) {
/* 1630 */       if (this.presionado == null) {
/* 1631 */         this.presionado = new Presionado();
/* 1632 */         this.presionado.start();
/*      */       } else {
/* 1634 */         this.presionado.detenerFuera();
/* 1635 */         this.presionado = new Presionado();
/* 1636 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 1639 */       this.jTextField2.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable2MouseClicked(MouseEvent evt) {
/* 1644 */     if (evt.getClickCount() == 2) {
/* 1645 */       String[] reg = this.con.regresaReg("comentario,valesAsignados,viajeAnterior,viajesAsignados", "reseteos", "where folio='" + String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 0)) + "'", 4);
/* 1646 */       this.jTextField6.setText(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 0)));
/* 1647 */       this.jTextField9.setText(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 1)));
/* 1648 */       this.jTextField8.setText(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 2)));
/* 1649 */       this.jTextField7.setText(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 3)));
/*      */       
/* 1651 */       this.jFormattedTextField7.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 4)))));
/* 1652 */       this.jFormattedTextField8.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 5)))));
/* 1653 */       this.jFormattedTextField9.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 6)))));
/* 1654 */       this.jFormattedTextField10.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 7)))));
/* 1655 */       this.jFormattedTextField11.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 8)))));
/* 1656 */       this.jFormattedTextField12.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 9)))));
/*      */       
/* 1658 */       this.jTextArea4.setText(reg[1]);
/* 1659 */       this.jTextArea3.setText(reg[3]);
/* 1660 */       this.jTextPane4.setText(reg[0]);
/* 1661 */       this.jTextPane3.setText(reg[2]);
/*      */       
/* 1663 */       this.jDialog2.setVisible(true);
/*      */     } 
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
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1677 */     String[] datos = { "FOLIO", "FECHA", "ECO", "OPERADOR", "KM", "RENDIMIENTO", "LTS CONSUMIDOS", "LTS CONTRA", "CM FALTANTES 1", "CM FALTANTES 2", "RESPONSABLE", "ESTATUS" };
/* 1678 */     this.esc = new EscribirReporte("RESETEOS", jTable2, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1682 */     this.MODIFICAR = true;
/* 1683 */     int selec = jTable2.getSelectedRow();
/* 1684 */     if (selec > -1) {
/* 1685 */       String num = String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 0));
/* 1686 */       this.CLAVE = num;
/* 1687 */       String estado = String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 11));
/* 1688 */       if (estado.equals("<Por Autorizar>")) {
/* 1689 */         String[] datos = this.con.regresaReg("valesAsignados,viajesAsignados,comentario,viajeAnterior", "reseteos", "where folio ='" + String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 0)) + "'", 4);
/*      */         
/* 1691 */         this.jTextField4.setText(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 0)));
/* 1692 */         this.jFormattedTextField1.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 4)))));
/* 1693 */         this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 5)))));
/* 1694 */         this.jFormattedTextField3.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 6)))));
/* 1695 */         this.jFormattedTextField4.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 7)))));
/* 1696 */         this.jFormattedTextField5.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 8)))));
/* 1697 */         this.jFormattedTextField6.setValue(Double.valueOf(Double.parseDouble(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 9)))));
/*      */         
/* 1699 */         this.jTextArea2.setText(datos[0]);
/* 1700 */         this.jTextArea1.setText(datos[1]);
/* 1701 */         this.jTextPane2.setText(datos[2]);
/* 1702 */         this.jTextPane1.setText(datos[3]);
/* 1703 */         this.jTextField5.setText(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 3)));
/* 1704 */         this.jComboBox2.setSelectedItem(jTable2.getValueAt(jTable2.getSelectedRow(), 2));
/*      */         
/* 1706 */         this.jComboBox2.setEnabled(false);
/* 1707 */         this.jFormattedTextField1.setEnabled(true);
/* 1708 */         this.jFormattedTextField2.setEnabled(true);
/* 1709 */         this.jFormattedTextField3.setEnabled(true);
/* 1710 */         this.jFormattedTextField4.setEnabled(true);
/* 1711 */         this.jFormattedTextField5.setEnabled(true);
/* 1712 */         this.jFormattedTextField6.setEnabled(true);
/* 1713 */         this.jTextPane2.setEnabled(true);
/*      */         
/* 1715 */         this.jButton7.setText("Modificar");
/* 1716 */         this.jDialog1.setVisible(true);
/*      */       } else {
/* 1718 */         JOptionPane.showMessageDialog(this.padre, "No puedes modificar este reseteo porque ya se encuentra autorizado", "Reseteo Autorizado", 0, this.ERROR);
/*      */       } 
/*      */     } else {
/* 1721 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar un reseteo para poder cancelarlo", "Selecciona un dato", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 1726 */     this.error.pasarModal(true);
/* 1727 */     this.val.pasarModal(Boolean.valueOf(true));
/* 1728 */     int selec = jTable2.getSelectedRow();
/* 1729 */     if (selec > -1) {
/* 1730 */       String num = String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 0));
/* 1731 */       this.CLAVE = num;
/* 1732 */       String estado = String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 11));
/* 1733 */       if (estado.equals("<Por Autorizar>")) {
/* 1734 */         this.jDialog3.setVisible(true);
/*      */       } else {
/* 1736 */         JOptionPane.showMessageDialog(this.padre, "No puedes cancelar este reseteo porque no se encuentra activo", "Reseteo Cancelado", 0, this.ERROR);
/*      */       } 
/*      */     } else {
/* 1739 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar un reseteo para poder cancelarlo", "Selecciona un dato", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1744 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1748 */     this.jButton7.setText("Guardar");
/* 1749 */     this.jComboBox2.setEnabled(true);
/* 1750 */     this.MODIFICAR = false;
/* 1751 */     sacarMayor();
/* 1752 */     this.jTextArea1.setText("");
/* 1753 */     this.jTextArea2.setText("");
/* 1754 */     this.jTextPane1.setText("");
/* 1755 */     this.jTextPane2.setText("");
/* 1756 */     this.jTextField5.setText("");
/* 1757 */     this.jDateChooser9.setDate(new Date());
/* 1758 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 1759 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 1760 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 1761 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 1762 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 1763 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/* 1764 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 1768 */     if (!this.MODIFICAR && this.primera == true) {
/* 1769 */       this.encontrado = this.con.consultar("num", "reseteos", "where eco ='" + String.valueOf(this.jComboBox2.getSelectedItem()) + "' and (estatus like '%por autorizar%' or estatus like '%autorizado%')");
/* 1770 */       if (this.encontrado) {
/* 1771 */         this.jTextPane1.setText("");
/* 1772 */         String[] arrayOfString = this.con.regresaReg("folio,fecha,eco,operador,kmRecorridos,rendimiento,ltsConsumidos,ltsContra,cmFaltantes1,cmFaltantes2,usuario", "reseteos", "where eco='" + String.valueOf(this.jComboBox2.getSelectedItem()) + "' and (estatus like '%por autorizar%' or estatus like '%autorizado%') order by fecha desc", 11);
/* 1773 */         SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 1774 */         StyleConstants.setBold(attrs, true);
/*      */         
/* 1776 */         SimpleAttributeSet cursiva = new SimpleAttributeSet();
/* 1777 */         StyleConstants.setItalic(cursiva, true);
/*      */         try {
/* 1779 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Folio:                                                                Fecha:                                                Eco: ", attrs);
/* 1780 */           this.jTextPane1.getStyledDocument().insertString(7, arrayOfString[0], cursiva);
/* 1781 */           this.jTextPane1.getStyledDocument().insertString(88, arrayOfString[1], cursiva);
/* 1782 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), arrayOfString[2], cursiva);
/*      */           
/* 1784 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "\nOperador: ", attrs);
/* 1785 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), arrayOfString[3], cursiva);
/*      */           
/* 1787 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "\nkm Recorridos:                                                                 Rendimiento: ", attrs);
/* 1788 */           this.jTextPane1.getStyledDocument().insertString(218, arrayOfString[4], cursiva);
/* 1789 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), arrayOfString[5], cursiva);
/*      */           
/* 1791 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "\nLts Consumidos:                                                               Lts en Contra: ", attrs);
/* 1792 */           this.jTextPane1.getStyledDocument().insertString(318, arrayOfString[6], cursiva);
/* 1793 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), arrayOfString[7], cursiva);
/*      */           
/* 1795 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "\nCm Faltantes 1:                                                                  Cm Faltantes 2: ", attrs);
/* 1796 */           this.jTextPane1.getStyledDocument().insertString(416, arrayOfString[8], cursiva);
/* 1797 */           this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), arrayOfString[9], cursiva);
/*      */           
/* 1799 */           System.out.println("Total: " + this.jTextPane1.getStyledDocument().getLength());
/* 1800 */         } catch (BadLocationException ex) {
/* 1801 */           Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */         } 
/*      */       } else {
/* 1804 */         this.jTextPane1.setText("");
/*      */       } 
/*      */       
/* 1807 */       this.encontrado = this.con.consultar("guias.operador", "guias,llamadas_historicas", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_tracto and llamadas_historicas.num_tracto ='" + String.valueOf(this.jComboBox2.getSelectedItem()) + "' order by fecha desc");
/* 1808 */       if (this.encontrado) {
/* 1809 */         this.jTextField5.setText(this.con.Campo);
/*      */       } else {
/* 1811 */         this.jTextField5.setText("");
/*      */       } 
/*      */ 
/*      */       
/* 1815 */       String[] guias = this.con.regresaColIndex("guias.num_guia", "guias,vales_diesel", "where guias.diesel=vales_diesel.folio and eco ='" + String.valueOf(this.jComboBox2.getSelectedItem()) + "' and vales_diesel.estado='ACTIVO' and folio_liq = '' and guias.estado='ACTIVA'");
/* 1816 */       if (guias.length > 0) {
/*      */         
/* 1818 */         for (int i = 0; i < guias.length; i++) {
/* 1819 */           this.jTextArea1.setText(this.jTextArea1.getText() + "\nGuia: " + this.jTextArea1.getText());
/*      */         }
/*      */       } else {
/* 1822 */         this.jTextArea1.setText("");
/*      */       } 
/*      */ 
/*      */       
/* 1826 */       String[] datos = this.con.regresaColIndex("folio", "vales_diesel", "where eco = " + String.valueOf(this.jComboBox2.getSelectedItem()) + " and folio_liq='' and estado='ACTIVO'");
/* 1827 */       if (datos.length > 0) {
/*      */         
/* 1829 */         for (int i = 0; i < datos.length; i++) {
/* 1830 */           this.jTextArea2.setText(this.jTextArea2.getText() + "\nVale : " + this.jTextArea2.getText());
/*      */         }
/*      */       } else {
/* 1833 */         this.jTextArea2.setText("");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 1839 */     if (this.jTextField5.getText().equals("")) {
/* 1840 */       this.jTextField5.setBackground(Color.red);
/* 1841 */       JOptionPane.showMessageDialog(this.jDialog1, "La información del operador es necesaria, por favor verifica tu información", "Falta Información", 0, this.ERROR);
/* 1842 */     } else if (this.jButton7.getText().equals("Guardar")) {
/* 1843 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas generar un nuevo deporte de reseteo?", "Nuevo Reseteo", 0, 3, this.PREG);
/* 1844 */       if (res == 0) {
/* 1845 */         this.con.inserSinMsj("insert into reseteos (folio,fecha,eco,operador,kmRecorridos,rendimiento,ltsConsumidos,ltsContra,cmFaltantes1,cmFaltantes2,comentario,valesAsignados,viajesAsignados,viajeAnterior,usuario,estatus) values('" + this.jTextField4.getText().toUpperCase() + "',now(),'" + String.valueOf(this.jComboBox2.getSelectedItem()) + "','" + this.jTextField5.getText() + "'," + this.jFormattedTextField1.getText() + "," + this.jFormattedTextField2.getText() + "," + this.jFormattedTextField3.getText() + "," + this.jFormattedTextField4.getText() + "," + this.jFormattedTextField5.getText() + "," + this.jFormattedTextField6.getText() + ",'" + this.jTextPane2.getText().toUpperCase() + "','" + this.jTextArea2.getText().toUpperCase() + "','" + this.jTextArea1.getText().toUpperCase() + "','" + this.jTextPane1.getText() + "','" + this.USUARIO + "','<Por Autorizar>')");
/* 1846 */         this.jDialog1.setVisible(false);
/* 1847 */         consultar();
/*      */       } 
/*      */     } else {
/* 1850 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modeificar el reporte del reseteo?", "Modificar Reseteo", 0, 3, this.PREG);
/* 1851 */       if (res == 0) {
/* 1852 */         this.con.inserSinMsj("update reseteos set operador = '" + this.jTextField5.getText().toUpperCase() + "', kmRecorridos = " + String.valueOf(this.jFormattedTextField1.getValue()) + ", rendimiento=" + String.valueOf(this.jFormattedTextField2.getValue()) + ", ltsConsumidos =" + String.valueOf(this.jFormattedTextField3.getValue()) + ", ltsContra=" + String.valueOf(this.jFormattedTextField4.getValue()) + ",cmFaltantes1=" + String.valueOf(this.jFormattedTextField5.getValue()) + ",cmFaltantes2=" + String.valueOf(this.jFormattedTextField6.getValue()) + ", comentario='" + this.jTextPane2.getText().toUpperCase() + "' where folio='" + this.jTextField4.getText() + "'");
/* 1853 */         this.jDialog1.setVisible(false);
/* 1854 */         consultar();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 1860 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 1864 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 1868 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 1872 */     String folio = String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 0));
/* 1873 */     this.con.consultar("estatus", "reseteos", "where folio ='" + folio + "'");
/* 1874 */     if (this.con.Campo.equals("<Por Autorizar>")) {
/* 1875 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas autorizar el reseteo que seleccionaste?", "Autorizar Reseteo", 0, 3, this.PREG);
/* 1876 */       if (res == 0) {
/* 1877 */         this.con.inserSinMsj("update reseteos set estatus='<Autorizado>' where folio ='" + folio + "'");
/* 1878 */         consultar();
/*      */       } 
/*      */     } else {
/* 1881 */       JOptionPane.showMessageDialog(this.padre, "El registro que seleccionaste ya se encuentra autorizado por favor selecciona otro reseteo\nNOTA: actualiza los datos para ver los registros completos.", "Reseteo ya autorizado", 0, this.INFO);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 1886 */     JOptionPane.showMessageDialog(this.padre, this.jPanel9, "Tipo de Gráfica", 0, this.INFO);
/* 1887 */     if (this.jRadioButton3.isSelected()) {
/* 1888 */       JFreeChart jfreechart = createChart();
/* 1889 */       ChartPanel chartpanel = new ChartPanel(jfreechart);
/* 1890 */       chartpanel.setPreferredSize(new Dimension(500, 270));
/*      */       
/* 1892 */       JFrame frame = new JFrame("Grafica por eonómicos");
/* 1893 */       frame.getContentPane().add((Component)chartpanel);
/* 1894 */       frame.pack();
/* 1895 */       frame.setSize(800, 500);
/* 1896 */       frame.setVisible(true);
/*      */     } else {
/* 1898 */       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
/*      */       
/* 1900 */       dataset.setValue(this.KM, "Km", "Km");
/* 1901 */       dataset.setValue(this.REN, "Ren", "Ren");
/* 1902 */       dataset.setValue(this.LTSCONSUM, "Lts Consum", "Lts Consum");
/* 1903 */       dataset.setValue(this.LTSCONTRA, "Lts Contra", "Lts Contra");
/* 1904 */       dataset.setValue(this.CMFAL1, "Cm Faltantes 1", "Cm Faltantes 1");
/* 1905 */       dataset.setValue(this.CMFAL2, "Cm Faltantes 2", "Cm Faltantes 2");
/*      */       
/* 1907 */       JFreeChart chart = ChartFactory.createStackedBarChart3D("GRAFICA POR PERIODO", "Reseteos", "Valores", (CategoryDataset)dataset, PlotOrientation.VERTICAL, true, true, true);
/* 1908 */       chart.fireChartChanged();
/* 1909 */       chart.setNotify(true);
/* 1910 */       chart.setAntiAlias(true);
/* 1911 */       chart.setBorderVisible(true);
/*      */       
/* 1913 */       chart.setTextAntiAlias(true);
/* 1914 */       ChartPanel panel = new ChartPanel(chart);
/*      */       
/* 1916 */       JFrame frame = new JFrame("Grafica por periodo");
/* 1917 */       frame.getContentPane().add((Component)panel);
/* 1918 */       frame.pack();
/* 1919 */       frame.setSize(800, 500);
/* 1920 */       frame.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 1925 */     ImprimirFacturas imprimir = new ImprimirFacturas();
/* 1926 */     imprimir.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 1930 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField2ActionPerformed(ActionEvent evt) {
/* 1934 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {
/* 1938 */     consultar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jScrollPane2CaretPositionChanged(InputMethodEvent evt) {}
/*      */ 
/*      */   
/*      */   static CategoryDataset createDataset1() {
/* 1946 */     DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
/* 1947 */     String cat1 = "Km";
/* 1948 */     String cat3 = "Lts Consum";
/* 1949 */     String cat4 = "Lts Contra";
/* 1950 */     String cat5 = "Cm Falt 1";
/* 1951 */     String cat6 = "Cm Falt 2";
/*      */     
/* 1953 */     String[] fechas = new String[jTable2.getRowCount()];
/*      */     int i;
/* 1955 */     for (i = 0; i < jTable2.getRowCount(); i++) {
/* 1956 */       String fecha = String.valueOf(jTable2.getValueAt(i, 1));
/* 1957 */       fechas[i] = String.valueOf(jTable2.getValueAt(i, 2)) + " - " + String.valueOf(jTable2.getValueAt(i, 2));
/*      */     } 
/* 1959 */     for (i = 0; i < jTable2.getRowCount(); i++) {
/* 1960 */       defaultcategorydataset.addValue(Double.parseDouble(String.valueOf(jTable2.getValueAt(i, 4))), cat1, fechas[i]);
/* 1961 */       defaultcategorydataset.addValue(Double.parseDouble(String.valueOf(jTable2.getValueAt(i, 6))), cat3, fechas[i]);
/* 1962 */       defaultcategorydataset.addValue(Double.parseDouble(String.valueOf(jTable2.getValueAt(i, 7))), cat4, fechas[i]);
/* 1963 */       defaultcategorydataset.addValue(Double.parseDouble(String.valueOf(jTable2.getValueAt(i, 8))), cat5, fechas[i]);
/* 1964 */       defaultcategorydataset.addValue(Double.parseDouble(String.valueOf(jTable2.getValueAt(i, 9))), cat6, fechas[i]);
/*      */     } 
/* 1966 */     return (CategoryDataset)defaultcategorydataset;
/*      */   }
/*      */   
/*      */   private static CategoryDataset createDataset2() {
/* 1970 */     DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
/* 1971 */     String s = "Rendimiento";
/*      */     
/* 1973 */     String[] fechas = new String[jTable2.getRowCount()];
/*      */     int i;
/* 1975 */     for (i = 0; i < jTable2.getRowCount(); i++) {
/* 1976 */       String fecha = String.valueOf(jTable2.getValueAt(i, 1));
/* 1977 */       fechas[i] = String.valueOf(jTable2.getValueAt(i, 2)) + " - " + String.valueOf(jTable2.getValueAt(i, 2));
/*      */     } 
/*      */     
/* 1980 */     for (i = 0; i < jTable2.getRowCount(); i++) {
/* 1981 */       defaultcategorydataset.addValue(Double.parseDouble(String.valueOf(jTable2.getValueAt(i, 5))), s, fechas[i]);
/*      */     }
/* 1983 */     return (CategoryDataset)defaultcategorydataset;
/*      */   }
/*      */   
/*      */   private static JFreeChart createChart() {
/* 1987 */     JFreeChart jfreechart = ChartFactory.createBarChart("GRÁFICA POR ECONÓMICOS", "Reseteos", "Valores", createDataset1(), PlotOrientation.VERTICAL, false, true, false);
/* 1988 */     jfreechart.setBackgroundPaint(Color.WHITE);
/* 1989 */     CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
/*      */     
/* 1991 */     categoryplot.setBackgroundPaint(Color.DARK_GRAY);
/* 1992 */     CategoryDataset categorydataset = createDataset2();
/* 1993 */     categoryplot.setDataset(1, categorydataset);
/* 1994 */     categoryplot.mapDatasetToRangeAxis(1, 1);
/* 1995 */     CategoryAxis categoryaxis = categoryplot.getDomainAxis();
/* 1996 */     categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
/* 1997 */     NumberAxis numberaxis = new NumberAxis("Rendimiento");
/* 1998 */     categoryplot.setRangeAxis(1, (ValueAxis)numberaxis);
/* 1999 */     LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
/* 2000 */     lineandshaperenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator());
/* 2001 */     categoryplot.setRenderer(1, (CategoryItemRenderer)lineandshaperenderer);
/* 2002 */     categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
/* 2003 */     LegendTitle legendtitle = new LegendTitle((LegendItemSource)categoryplot.getRenderer(0));
/* 2004 */     legendtitle.setMargin(new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D));
/* 2005 */     legendtitle.setFrame((BlockFrame)new BlockBorder());
/* 2006 */     LegendTitle legendtitle1 = new LegendTitle((LegendItemSource)categoryplot.getRenderer(1));
/* 2007 */     legendtitle1.setMargin(new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D));
/* 2008 */     legendtitle1.setFrame((BlockFrame)new BlockBorder());
/* 2009 */     BlockContainer blockcontainer = new BlockContainer((Arrangement)new BorderArrangement());
/* 2010 */     blockcontainer.add((Block)legendtitle, RectangleEdge.LEFT);
/* 2011 */     blockcontainer.add((Block)legendtitle1, RectangleEdge.RIGHT);
/* 2012 */     blockcontainer.add((Block)new EmptyBlock(2000.0D, 0.0D));
/* 2013 */     CompositeTitle compositetitle = new CompositeTitle(blockcontainer);
/* 2014 */     compositetitle.setPosition(RectangleEdge.BOTTOM);
/* 2015 */     jfreechart.addSubtitle((Title)compositetitle);
/* 2016 */     return jfreechart;
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 2020 */     Calendar ahoraCal = Calendar.getInstance();
/* 2021 */     ahoraCal.setTime(this.fecha);
/* 2022 */     String mesesito = "";
/* 2023 */     String hoy = "";
/* 2024 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 2025 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 2027 */     if (ahoraCal.get(2) + 1 < 10) {
/* 2028 */       mesesito = "0" + mesesito;
/*      */     }
/* 2030 */     if (ahoraCal.get(5) < 10) {
/* 2031 */       hoy = "0" + hoy;
/*      */     }
/* 2033 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 2037 */     String motivo = this.jTextArea5.getText();
/* 2038 */     if (motivo.equals("")) {
/* 2039 */       this.jTextArea5.setBackground(Color.RED);
/* 2040 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas colocar el motivo por el cual se cancela el reseteo", "Coloca un comentario", 0, this.ERROR);
/*      */     } else {
/* 2042 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas cancelar el reseteo que seleccionaste?", "Cancelar Reseteo", 0, 3, this.PREG);
/* 2043 */       if (res == 0) {
/* 2044 */         String num = String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 0));
/* 2045 */         this.con.inserSinMsj("update reseteos set estatus='<Cancelado: " + this.USUARIO + " " + cargarFechaHoy() + "> " + this.jTextArea5.getText().toUpperCase() + "' where folio='" + num + "'");
/* 2046 */         consultar();
/* 2047 */         this.jDialog3.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void reseteos(String usu) {
/* 2053 */     this.USUARIO = usu;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2061 */     this.fecha = new Date();
/* 2062 */     this.fechaActual = new Date();
/* 2063 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2064 */     this.jDateChooser4.setMaxSelectableDate(this.fechaActual);
/* 2065 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2066 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 2067 */     consultar();
/* 2068 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 2072 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 2080 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 2086 */         return 30;
/*      */       
/*      */       case 1:
/* 2089 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 2091 */           return 29;
/*      */         }
/* 2093 */         return 28;
/*      */     } 
/*      */ 
/*      */     
/* 2097 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void colorear() {
/* 2102 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2104 */             Reseteos.this.jTextGanado(Reseteos.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2108 */             Reseteos.this.jTextPerdido(Reseteos.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 2111 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2113 */             Reseteos.this.jTextGanado(Reseteos.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2117 */             Reseteos.this.jTextPerdido(Reseteos.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 2120 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2122 */             Reseteos.this.jTextGanado(Reseteos.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2126 */             Reseteos.this.jTextPerdido(Reseteos.this.jTextField1, evt);
/*      */           }
/*      */         });
/*      */     
/* 2130 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2132 */             Reseteos.this.jTextGanado(Reseteos.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2136 */             Reseteos.this.jTextPerdido(Reseteos.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 2139 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2141 */             Reseteos.this.jTextGanado(Reseteos.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2145 */             Reseteos.this.jTextPerdido(Reseteos.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 2148 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2150 */             Reseteos.this.jTextGanado(Reseteos.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2154 */             Reseteos.this.jTextPerdido(Reseteos.this.jTextField4, evt);
/*      */           }
/*      */         });
/*      */     
/* 2158 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2160 */             Reseteos.this.jTextGanado(Reseteos.this.jTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2164 */             Reseteos.this.jTextPerdido(Reseteos.this.jTextField5, evt);
/*      */           }
/*      */         });
/*      */     
/* 2168 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2170 */             Reseteos.this.jTextGanado(Reseteos.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2174 */             Reseteos.this.jTextPerdido(Reseteos.this.jTextArea5, evt);
/*      */           }
/*      */         });
/*      */     
/* 2178 */     this.jTextArea2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2180 */             Reseteos.this.jTextGanado(Reseteos.this.jTextArea2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2184 */             Reseteos.this.jTextPerdido(Reseteos.this.jTextArea2, evt);
/*      */           }
/*      */         });
/*      */     
/* 2188 */     this.jTextPane2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2190 */             Reseteos.this.jTextGanado(Reseteos.this.jTextPane2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2194 */             Reseteos.this.jTextPerdido(Reseteos.this.jTextPane2, evt);
/*      */           }
/*      */         });
/*      */     
/* 2198 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2200 */             Reseteos.this.jTextGanado(Reseteos.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2204 */             Reseteos.this.jTextPerdido(Reseteos.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 2207 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2209 */             Reseteos.this.jTextGanado(Reseteos.this.jFormattedTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2213 */             Reseteos.this.jTextPerdido(Reseteos.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/* 2216 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2218 */             Reseteos.this.jTextGanado(Reseteos.this.jFormattedTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2222 */             Reseteos.this.jTextPerdido(Reseteos.this.jFormattedTextField3, evt);
/*      */           }
/*      */         });
/* 2225 */     this.jFormattedTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2227 */             Reseteos.this.jTextGanado(Reseteos.this.jFormattedTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2231 */             Reseteos.this.jTextPerdido(Reseteos.this.jFormattedTextField4, evt);
/*      */           }
/*      */         });
/* 2234 */     this.jFormattedTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2236 */             Reseteos.this.jTextGanado(Reseteos.this.jFormattedTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2240 */             Reseteos.this.jTextPerdido(Reseteos.this.jFormattedTextField5, evt);
/*      */           }
/*      */         });
/* 2243 */     this.jFormattedTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2245 */             Reseteos.this.jTextGanado(Reseteos.this.jFormattedTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2249 */             Reseteos.this.jTextPerdido(Reseteos.this.jFormattedTextField6, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 2255 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 2259 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 2263 */     boolean correcto = true;
/* 2264 */     if (this.jDateChooser4.getDate() == null) {
/* 2265 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 2266 */       if (res == 0) {
/* 2267 */         this.jDateChooser4.setDate(this.fechaActual);
/* 2268 */         correcto = true;
/*      */       } else {
/* 2270 */         correcto = false;
/*      */       } 
/* 2272 */     } else if (this.jDateChooser5.getDate() == null) {
/* 2273 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 2274 */       if (res == 0) {
/* 2275 */         this.jDateChooser5.setDate(this.fechaActual);
/* 2276 */         correcto = true;
/*      */       } else {
/* 2278 */         correcto = false;
/*      */       } 
/* 2280 */     } else if (correcto) {
/* 2281 */       Date fecha1 = this.jDateChooser4.getDate();
/* 2282 */       Date fecha2 = this.jDateChooser5.getDate();
/*      */       
/* 2284 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2285 */       String cadenaFecha = "";
/* 2286 */       cadenaFecha = formato.format(fecha1);
/* 2287 */       String AÑO = cadenaFecha.substring(0, 4);
/* 2288 */       String MES = cadenaFecha.substring(4, 6);
/* 2289 */       String DIA = cadenaFecha.substring(6, 8);
/* 2290 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 2292 */       cadenaFecha = formato.format(fecha2);
/* 2293 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 2294 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 2295 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 2296 */       int diasTotal = diasDelMes(mm - 1, aa);
/* 2297 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2298 */       String strFecha = "";
/* 2299 */       if (diasTotal == dd) {
/* 2300 */         dd = 1;
/* 2301 */         if (mm == 11) {
/* 2302 */           aa++;
/* 2303 */           mm = 0;
/*      */         } else {
/* 2305 */           mm++;
/*      */         } 
/*      */       } else {
/* 2308 */         dd++;
/*      */       } 
/* 2310 */       String año = "" + aa;
/* 2311 */       String mes = "" + mm;
/* 2312 */       String dia = "" + dd;
/* 2313 */       formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2314 */       strFecha = dia + "-" + dia + "-" + mes;
/* 2315 */       String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */       
/* 2317 */       String estatus = " estatus like '%%'";
/*      */       
/* 2319 */       if (this.jComboBox1.getSelectedIndex() == 0) {
/* 2320 */         estatus = "(estatus like '%por autorizar%' or estatus like '%autorizado%')";
/* 2321 */       } else if (this.jComboBox1.getSelectedIndex() == 1) {
/* 2322 */         estatus = "estatus like '%cancelado%'";
/*      */       } 
/*      */       
/* 2325 */       jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 2326 */             .buscarDatos(12, "folio,fecha,eco,operador,kmRecorridos,rendimiento,ltsConsumidos,ltsContra,cmFaltantes1,cmFaltantes2,usuario,estatus", "reseteos", "where fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and folio like '%" + this.jTextField1.getText() + "%' and eco like '%" + this.jTextField2.getText() + "%' and operador like '%" + this.jTextField3.getText() + "%' and " + estatus + " order by fecha desc"), (Object[])new String[] { "Folio", "Fecha", "Eco", "Operador", "Km", "Rendimiento", "Lts Consum", "Lts Contra", "Cm Faltantes 1", "Cm Faltantes 2", "Reseteo", "Estatus" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 2331 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false };
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2336 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 2339 */       this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + jTable2.getRowCount() + "</HTML>");
/* 2340 */       jTable2.setShowVerticalLines(false);
/* 2341 */       this.jScrollPane2.setViewportView(jTable2);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2346 */       this.celda.pasarInd(this.con.revisarCol(jTable2, "<Cancelado", 0, 11, 2));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2351 */       this.celda.pasarInd2(this.con.revisarCol(jTable2, "<Por Autorizar", 0, 11, 2));
/*      */       
/* 2353 */       double km = 0.0D;
/* 2354 */       double ren = 0.0D;
/* 2355 */       double ltsConsum = 0.0D;
/* 2356 */       double ltsContra = 0.0D;
/* 2357 */       double cm1 = 0.0D;
/* 2358 */       double cm2 = 0.0D;
/*      */       
/* 2360 */       for (int i = 0; i < jTable2.getRowCount(); i++) {
/* 2361 */         String canti = String.valueOf(jTable2.getValueAt(i, 4));
/* 2362 */         km += Double.parseDouble(canti);
/* 2363 */         this.cantidad.setValue(Double.valueOf(km));
/* 2364 */         this.jLabel43.setText(this.cantidad.getText() + " km");
/*      */         
/* 2366 */         canti = String.valueOf(jTable2.getValueAt(i, 5));
/* 2367 */         ren += Double.parseDouble(canti);
/* 2368 */         this.cantidad.setValue(Double.valueOf(ren));
/* 2369 */         this.jLabel42.setText(this.cantidad.getText() + " ren");
/*      */         
/* 2371 */         canti = String.valueOf(jTable2.getValueAt(i, 6));
/* 2372 */         ltsConsum += Double.parseDouble(canti);
/* 2373 */         this.cantidad.setValue(Double.valueOf(ltsConsum));
/* 2374 */         this.jLabel38.setText(this.cantidad.getText() + " lts");
/*      */         
/* 2376 */         canti = String.valueOf(jTable2.getValueAt(i, 7));
/* 2377 */         ltsContra += Double.parseDouble(canti);
/* 2378 */         this.cantidad.setValue(Double.valueOf(ltsContra));
/* 2379 */         this.jLabel40.setText(this.cantidad.getText() + " lts");
/*      */         
/* 2381 */         canti = String.valueOf(jTable2.getValueAt(i, 8));
/* 2382 */         cm1 += Double.parseDouble(canti);
/* 2383 */         this.cantidad.setValue(Double.valueOf(cm1));
/* 2384 */         this.jLabel41.setText(this.cantidad.getText() + " cm");
/*      */         
/* 2386 */         canti = String.valueOf(jTable2.getValueAt(i, 9));
/* 2387 */         cm2 += Double.parseDouble(canti);
/* 2388 */         this.cantidad.setValue(Double.valueOf(cm2));
/* 2389 */         this.jLabel39.setText(this.cantidad.getText() + " cm");
/*      */       } 
/*      */       
/* 2392 */       this.KM = km;
/* 2393 */       this.REN = ren;
/* 2394 */       this.LTSCONSUM = ltsConsum;
/* 2395 */       this.LTSCONTRA = ltsContra;
/* 2396 */       this.CMFAL1 = cm1;
/* 2397 */       this.CMFAL2 = cm2;
/*      */       
/* 2399 */       jTable2.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 2400 */       jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 2401 */       jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 2402 */       jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2403 */       jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2404 */       jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 2405 */       jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 2406 */       jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 2407 */       jTable2.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 2408 */       jTable2.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 2409 */       jTable2.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 2410 */       jTable2.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/*      */       
/* 2412 */       jTable2.getColumnModel().getColumn(0).setMinWidth(80);
/* 2413 */       jTable2.getColumnModel().getColumn(0).setMaxWidth(80);
/* 2414 */       jTable2.getColumnModel().getColumn(1).setMinWidth(110);
/* 2415 */       jTable2.getColumnModel().getColumn(1).setMaxWidth(110);
/* 2416 */       jTable2.getColumnModel().getColumn(2).setMinWidth(80);
/* 2417 */       jTable2.getColumnModel().getColumn(2).setMaxWidth(80);
/* 2418 */       jTable2.getColumnModel().getColumn(3).setMinWidth(280);
/* 2419 */       jTable2.getColumnModel().getColumn(3).setMaxWidth(280);
/* 2420 */       jTable2.getColumnModel().getColumn(10).setMinWidth(110);
/* 2421 */       jTable2.getColumnModel().getColumn(10).setMaxWidth(110);
/*      */       
/* 2423 */       jTable2.setSelectionMode(0);
/* 2424 */       jTable2.setAutoCreateRowSorter(true);
/* 2425 */       jTable2.getTableHeader().setReorderingAllowed(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarCombos() {
/* 2430 */     String[] datos = this.con.regresaColIndex("num_tracto", "tracto", "where num_tracto>1 order by num_tracto");
/* 2431 */     this.jComboBox2.removeAllItems();
/* 2432 */     for (int i = 0; i < datos.length; i++) {
/* 2433 */       this.jComboBox2.addItem(datos[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 2438 */     this.encontrado = this.con.consultar("num", "reseteos", "");
/* 2439 */     String mayor = "";
/* 2440 */     int MAYOR = 0;
/* 2441 */     if (this.encontrado) {
/* 2442 */       this.con.consultar("max(num)", "reseteos", "");
/* 2443 */       mayor = this.con.Campo;
/* 2444 */       MAYOR = Integer.parseInt(mayor);
/*      */     } else {
/* 2446 */       MAYOR = 0;
/*      */     } 
/* 2448 */     MAYOR++;
/* 2449 */     if (MAYOR < 10) {
/* 2450 */       this.jTextField4.setText(this.DIRECTIVA + "-RS-0000" + this.DIRECTIVA);
/*      */     }
/* 2452 */     if (MAYOR < 100) {
/* 2453 */       this.jTextField4.setText(this.DIRECTIVA + "-RS-000" + this.DIRECTIVA);
/* 2454 */     } else if (MAYOR < 1000) {
/* 2455 */       this.jTextField4.setText(this.DIRECTIVA + "-RS-00" + this.DIRECTIVA);
/* 2456 */     } else if (MAYOR < 10000) {
/* 2457 */       this.jTextField4.setText(this.DIRECTIVA + "-RS-0" + this.DIRECTIVA);
/*      */     } else {
/* 2459 */       this.jTextField4.setText(this.DIRECTIVA + "-RS-" + this.DIRECTIVA);
/*      */     } 
/*      */   }
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 2465 */     int otro = -1;
/* 2466 */     String[] indices = new String[0];
/* 2467 */     String[] indices2 = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2470 */       setEnabled((table == null || table.isEnabled()));
/* 2471 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 2472 */       if (comparar(comp)) {
/* 2473 */         setBackground(Color.RED);
/* 2474 */         setForeground(Color.white);
/* 2475 */       } else if (comparar2(comp)) {
/* 2476 */         setBackground(new Color(102, 153, 255));
/* 2477 */         setForeground(Color.BLUE);
/*      */       } else {
/* 2479 */         setBackground((Color)null);
/* 2480 */         setForeground(Color.black);
/*      */       } 
/*      */       
/* 2483 */       if (column == 4 || column == 5 || column == 6 || column == 7 || column == 8 || column == 9) {
/* 2484 */         setHorizontalAlignment(4);
/*      */       } else {
/* 2486 */         setHorizontalAlignment(2);
/*      */       } 
/* 2488 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2489 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 2493 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 2497 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 2501 */       for (int i = 0; i < this.indices.length; i++) {
/* 2502 */         if (this.indices[i].equals(reg)) {
/* 2503 */           return true;
/*      */         }
/*      */       } 
/* 2506 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 2510 */       for (int i = 0; i < this.indices2.length; i++) {
/* 2511 */         if (this.indices2[i].equals(reg)) {
/* 2512 */           return true;
/*      */         }
/*      */       } 
/* 2515 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable {
/*      */     Thread t;
/* 2522 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 2525 */       this.t = new Thread(this);
/* 2526 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 2534 */         Thread.currentThread(); Thread.sleep(1000L);
/* 2535 */         detener();
/* 2536 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 2541 */       Reseteos.this.consultar();
/* 2542 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 2546 */       this.t.stop();
/*      */     } }
/*      */   public class ImprimirFacturas implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirFacturas() {
/* 2554 */       this.g2 = null;
/* 2555 */       this.Pag = 0;
/*      */       
/* 2557 */       this.linesPerPage = 50;
/* 2558 */       this.orientacion = 0;
/* 2559 */       this.X = 0.0D;
/* 2560 */       this.Y = 0.0D;
/* 2561 */       this.YINICIA = 75;
/* 2562 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 2563 */       this.NumLineas = 0;
/* 2564 */       this.numBreaks = 0;
/*      */     }
/*      */ 
/*      */     
/*      */     private void initTextLines() {
/* 2569 */       if (this.textLines == null) {
/*      */ 
/*      */         
/* 2572 */         int numLines = Reseteos.jTable2.getRowCount();
/*      */         
/* 2574 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 2579 */       Font font = new Font("Serif", 0, 8);
/* 2580 */       FontMetrics metrics = g.getFontMetrics(font);
/* 2581 */       int lineHeight = metrics.getHeight();
/* 2582 */       if (this.pageBreaks == null) {
/* 2583 */         initTextLines();
/* 2584 */         this.orientacion = pf.getOrientation();
/* 2585 */         if (pf.getOrientation() == 1) {
/* 2586 */           this.linesPerPage = 46;
/* 2587 */           this.X = pf.getWidth();
/* 2588 */           this.Y = pf.getHeight();
/*      */         } else {
/* 2590 */           this.linesPerPage = 38;
/* 2591 */           this.X = pf.getWidth();
/* 2592 */           this.Y = pf.getHeight();
/*      */         } 
/* 2594 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 2595 */         this.Pag = this.numBreaks;
/* 2596 */         this.pageBreaks = new int[this.numBreaks];
/* 2597 */         for (int b = 0; b < this.numBreaks; b++) {
/* 2598 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 2601 */       if (pageIndex > this.pageBreaks.length) {
/* 2602 */         return 1;
/*      */       }
/* 2604 */       Graphics2D g2d = (Graphics2D)g;
/* 2605 */       this.g2 = g;
/* 2606 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 2607 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 2608 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 2609 */       encabezado();
/* 2610 */       int y = this.YINICIA;
/* 2611 */       int lineas = 0;
/*      */       
/* 2613 */       this.g2.drawRect(25, 150, 550, 12);
/* 2614 */       this.g2.setColor(new Color(204, 0, 0));
/* 2615 */       this.g2.fillRect(25, 151, 550, 10);
/*      */       
/* 2617 */       Font fuente = new Font("Dialog", 0, 7);
/* 2618 */       this.g2.setFont(fuente);
/* 2619 */       this.g2.setColor(Color.WHITE);
/* 2620 */       int[] valores = { 29, 75, 120, 150, 310, 340, 365, 425, 480, 525 };
/* 2621 */       this.g2.drawString("FOLIO", valores[0], 159);
/* 2622 */       this.g2.drawString("FECHA", valores[1], 159);
/* 2623 */       this.g2.drawString("ECO", valores[2], 159);
/* 2624 */       this.g2.drawString("OPERADOR", valores[3], 159);
/* 2625 */       this.g2.drawString("KM", valores[4], 159);
/* 2626 */       this.g2.drawString("REN", valores[5], 159);
/* 2627 */       this.g2.drawString("LTS CONSUM", valores[6], 159);
/* 2628 */       this.g2.drawString("LTS CONTRA", valores[7], 159);
/* 2629 */       this.g2.drawString("CM FALT 1", valores[8], 159);
/* 2630 */       this.g2.drawString("CM FALT 2", valores[9], 159);
/*      */       
/* 2632 */       this.g2.setColor(Color.BLACK);
/* 2633 */       y = 160;
/* 2634 */       for (int line = start; line < end; line++) {
/* 2635 */         y += 12;
/*      */         
/* 2637 */         String valor = "";
/* 2638 */         if (line < 9) {
/* 2639 */           valor = "0" + line + 1;
/*      */         } else {
/* 2641 */           valor = "" + line + 1;
/*      */         } 
/* 2643 */         fuente = new Font("Dialog", 1, 7);
/* 2644 */         this.g2.setFont(fuente);
/* 2645 */         this.g2.drawString(valor, alinearDer(20, valor.length()), y - 2);
/*      */         
/* 2647 */         fuente = new Font("Dialog", 0, 6);
/* 2648 */         this.g2.setFont(fuente);
/*      */         
/* 2650 */         this.g2.drawString(String.valueOf(Reseteos.jTable2.getValueAt(line, 0)), valores[0], y - 2);
/*      */         
/* 2652 */         String fecha = String.valueOf(Reseteos.jTable2.getValueAt(line, 1));
/* 2653 */         String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 2654 */         this.g2.drawString(col, valores[1], y - 2);
/*      */         
/* 2656 */         this.g2.drawString(String.valueOf(Reseteos.jTable2.getValueAt(line, 2)), valores[2], y - 2);
/* 2657 */         this.g2.drawString(String.valueOf(Reseteos.jTable2.getValueAt(line, 3)), valores[3], y - 2);
/* 2658 */         this.g2.drawString(String.valueOf(Reseteos.jTable2.getValueAt(line, 4)), alinearDer(valores[4] + 10, Reseteos.jTable2.getValueAt(line, 4).toString().length()), y - 2);
/* 2659 */         this.g2.drawString(String.valueOf(Reseteos.jTable2.getValueAt(line, 5)), alinearDer(valores[5] + 10, Reseteos.jTable2.getValueAt(line, 5).toString().length()), y - 2);
/* 2660 */         this.g2.drawString(String.valueOf(Reseteos.jTable2.getValueAt(line, 6)), alinearDer(valores[6] + 40, Reseteos.jTable2.getValueAt(line, 6).toString().length()), y - 2);
/* 2661 */         this.g2.drawString(String.valueOf(Reseteos.jTable2.getValueAt(line, 7)), alinearDer(valores[7] + 40, Reseteos.jTable2.getValueAt(line, 7).toString().length()), y - 2);
/* 2662 */         this.g2.drawString(String.valueOf(Reseteos.jTable2.getValueAt(line, 8)), alinearDer(valores[8] + 40, Reseteos.jTable2.getValueAt(line, 8).toString().length()), y - 2);
/* 2663 */         this.g2.drawString(String.valueOf(Reseteos.jTable2.getValueAt(line, 9)), alinearDer(valores[9] + 40, Reseteos.jTable2.getValueAt(line, 9).toString().length()), y - 2);
/*      */       } 
/*      */       
/* 2666 */       g.drawString("Página " + pageIndex + 1, 540, 749);
/* 2667 */       if (this.Pag == pageIndex) {
/* 2668 */         this.g2.drawLine(20, y, 90, y);
/* 2669 */         this.g2.drawLine(290, y, 575, y);
/*      */         
/* 2671 */         fuente = new Font("Dialog", 1, 6);
/* 2672 */         this.g2.setFont(fuente);
/* 2673 */         g.drawString("TOTALES", 41, y + 10);
/*      */ 
/*      */         
/* 2676 */         Reseteos.this.cantidad.setValue(Double.valueOf(Reseteos.this.KM));
/* 2677 */         String km = Reseteos.this.cantidad.getText();
/* 2678 */         Reseteos.this.cantidad.setValue(Double.valueOf(Reseteos.this.REN));
/* 2679 */         String ren = Reseteos.this.cantidad.getText();
/* 2680 */         Reseteos.this.cantidad.setValue(Double.valueOf(Reseteos.this.LTSCONSUM));
/* 2681 */         String ltsConsum = Reseteos.this.cantidad.getText();
/* 2682 */         Reseteos.this.cantidad.setValue(Double.valueOf(Reseteos.this.LTSCONTRA));
/* 2683 */         String ltsContra = Reseteos.this.cantidad.getText();
/* 2684 */         Reseteos.this.cantidad.setValue(Double.valueOf(Reseteos.this.CMFAL1));
/* 2685 */         String cmFal1 = Reseteos.this.cantidad.getText();
/* 2686 */         Reseteos.this.cantidad.setValue(Double.valueOf(Reseteos.this.CMFAL2));
/* 2687 */         String cmFal2 = Reseteos.this.cantidad.getText();
/*      */         
/* 2689 */         this.g2.drawString(km, alinearDer(valores[4] + 10, km.length()), y + 10);
/* 2690 */         this.g2.drawString(ren, alinearDer(valores[5] + 10, ren.length()), y + 10);
/* 2691 */         this.g2.drawString(ltsConsum, alinearDer(valores[6] + 40, ltsConsum.length()), y + 10);
/* 2692 */         this.g2.drawString(ltsContra, alinearDer(valores[7] + 40, ltsContra.length()), y + 10);
/* 2693 */         this.g2.drawString(cmFal1, alinearDer(valores[8] + 40, cmFal1.length()), y + 10);
/* 2694 */         this.g2.drawString(cmFal2, alinearDer(valores[9] + 40, cmFal2.length()), y + 10);
/*      */         
/* 2696 */         fuente = new Font("Dialog", 1, 7);
/* 2697 */         this.g2.setFont(fuente);
/* 2698 */         this.g2.drawString("ELABORÓ", 190, 720);
/* 2699 */         this.g2.drawString("_____________________________________", 140, 752);
/* 2700 */         this.g2.drawString("NOMBRE Y FIRMA", 178, 765);
/*      */         
/* 2702 */         this.g2.drawString("RECIBE", 390, 720);
/* 2703 */         this.g2.drawString("_____________________________________", 340, 752);
/* 2704 */         this.g2.drawString("NOMBRE Y FIRMA", 378, 765);
/*      */       } 
/* 2706 */       return 0;
/*      */     }
/*      */     
/*      */     public int alinearDer(int x, int letras) {
/* 2710 */       int quitar = 3 * letras;
/* 2711 */       x -= quitar;
/* 2712 */       return x;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 2716 */       Font fuente = new Font("Dialog", 0, 8);
/* 2717 */       this.g2.setFont(fuente);
/* 2718 */       this.g2.setColor(Color.BLACK);
/* 2719 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 2720 */       Image img = imagen.getImage();
/* 2721 */       this.g2.drawImage(img, 518, 1, 57, 57, null);
/*      */       
/* 2723 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 2724 */       img = imagen.getImage();
/* 2725 */       this.g2.drawImage(img, 27, 8, 60, 50, null);
/*      */       
/* 2727 */       fuente = new Font("Times New Roman", 1, 16);
/* 2728 */       this.g2.setFont(fuente);
/* 2729 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 20);
/*      */ 
/*      */       
/* 2732 */       fuente = new Font("Dialog", 0, 12);
/* 2733 */       this.g2.setFont(fuente);
/* 2734 */       this.g2.drawString("RESETEOS", 280, 37);
/* 2735 */       this.g2.drawLine(25, 60, 575, 60);
/*      */       
/* 2737 */       this.g2.setColor(Color.BLACK);
/* 2738 */       this.g2.drawLine(25, 83, 220, 83);
/* 2739 */       this.g2.drawLine(25, 130, 220, 130);
/*      */       
/* 2741 */       fuente = new Font("Dialog", 1, 8);
/* 2742 */       this.g2.setFont(fuente);
/* 2743 */       this.g2.setColor(Color.BLACK);
/* 2744 */       this.g2.drawString("INFORMACIÓN DEL REPORTE", 25, 80);
/*      */       
/* 2746 */       fuente = new Font("Dialog", 1, 7);
/* 2747 */       this.g2.setFont(fuente);
/* 2748 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 2750 */       this.g2.drawString("ESTATUS: ", 27, 93);
/* 2751 */       this.g2.drawString("Total de Reseteos: ", 27, 104);
/* 2752 */       this.g2.drawString("Documentó: ", 27, 115);
/* 2753 */       this.g2.drawString("Fecha de Impresión: ", 27, 126);
/*      */       
/* 2755 */       fuente = new Font("Dialog", 0, 7);
/* 2756 */       this.g2.setFont(fuente);
/* 2757 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 2759 */       this.g2.drawString(String.valueOf(Reseteos.this.jComboBox1.getSelectedItem()), 100, 93);
/* 2760 */       this.g2.drawString("" + Reseteos.jTable2.getRowCount(), 100, 104);
/* 2761 */       this.g2.drawString(Reseteos.this.USUARIO, 100, 115);
/*      */       
/* 2763 */       Date fecha1 = new Date();
/* 2764 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2765 */       String cadenaFecha = "";
/* 2766 */       cadenaFecha = formato.format(fecha1);
/* 2767 */       String AÑO = cadenaFecha.substring(0, 4);
/* 2768 */       String MES = cadenaFecha.substring(4, 6);
/* 2769 */       String DIA = cadenaFecha.substring(6, 8);
/* 2770 */       this.g2.drawString(DIA + "/" + DIA + "/" + MES, 100, 126);
/*      */       
/* 2772 */       fuente = new Font("Dialog", 0, 7);
/* 2773 */       this.g2.setFont(fuente);
/* 2774 */       this.g2.drawString("A continuación se enlistan todos los reseteos en este periodo:", 25, 148);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 2778 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 2779 */       job.setPrintable(this);
/*      */       
/* 2781 */       PageFormat pf = job.defaultPage();
/* 2782 */       Paper papel = pf.getPaper();
/* 2783 */       papel.setSize(612.0D, 792.0D);
/* 2784 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 2785 */       pf.setPaper(papel);
/* 2786 */       pf.setOrientation(1);
/* 2787 */       job.setPrintable(new ImprimirFacturas(), pf);
/* 2788 */       job.defaultPage(pf);
/*      */       
/* 2790 */       boolean ok = job.printDialog();
/* 2791 */       if (ok)
/*      */         try {
/* 2793 */           job.print();
/* 2794 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Reseteos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */