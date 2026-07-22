/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ 
/*      */ public class TarjetasDeudoras extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   33 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   34 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   35 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   36 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   37 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   38 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   39 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   40 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   41 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   String USUARIO;
/*   43 */   Validaciones val = new Validaciones();
/*   44 */   Consultas con = new Consultas();
/*   45 */   Errores error = new Errores(false);
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   JFrame padre;
/*      */   EscribirReporte esc;
/*   50 */   Date fechaActual = new Date();
/*   51 */   Date fecha = new Date();
/*   52 */   Date fechaInicio = null;
/*   53 */   CeldaRender celda = new CeldaRender();
/*   54 */   CeldaRender2 celda2 = new CeldaRender2();
/*   55 */   CeldaRender3 celda3 = new CeldaRender3();
/*   56 */   String CLAVEOP = "";
/*   57 */   String NOMBRE = "";
/*   58 */   DefaultTableModel modelo = new DefaultTableModel();
/*   59 */   String PRIVILEGIOS = "";
/*      */   String DIRECTIVAS;
/*   61 */   NumerosALetras aLetra = null; boolean ACTIVARCONSULTA = false; Map<String, String> CAMPOSGENERALES; boolean entraDepa = false; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private ButtonGroup buttonGroup3; private ButtonGroup buttonGroup4; private ButtonGroup buttonGroup5; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton3; private JButton jButton30; private JButton jButton31; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JDateChooser jDateChooser2; private JDateChooser jDateChooser3; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDialog jDialog1;
/*      */   private JDialog jDialog2;
/*   63 */   MensajePop mensajeTry = null; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel3; private JLabel jLabel4; private JLabel jLabel48; private JLabel jLabel5; private JLabel jLabel6; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7;
/*      */   private JLabel jLabel70;
/*      */   private JLabel jLabel71;
/*      */   private JLabel jLabel72;
/*      */   private JLabel jLabel73;
/*      */   private JLabel jLabel74;
/*      */   private JLabel jLabel75;
/*      */   
/*      */   public TarjetasDeudoras(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*   72 */     this.mensajeTry = mensajeTry;
/*   73 */     this.padre = padre;
/*   74 */     this.fichas = fichas;
/*   75 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   76 */     initComponents();
/*   77 */     this.USUARIO = USUARIO;
/*   78 */     panelito.setViewportView(this);
/*      */     
/*   80 */     this.panel = panelito;
/*   81 */     initComponents();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   87 */     this.buttonGroup1.add(this.jRadioButton1);
/*   88 */     this.buttonGroup1.add(this.jRadioButton2);
/*   89 */     this.buttonGroup2.add(this.jRadioButton3);
/*   90 */     this.buttonGroup2.add(this.jRadioButton4);
/*   91 */     this.buttonGroup3.add(this.jRadioButton6);
/*   92 */     this.buttonGroup3.add(this.jRadioButton7);
/*      */     
/*   94 */     this.buttonGroup4.add(this.jRadioButton5);
/*   95 */     this.buttonGroup4.add(this.jRadioButton8);
/*   96 */     this.buttonGroup4.add(this.jRadioButton9);
/*      */     
/*   98 */     int w = this.tama.width;
/*   99 */     int h = this.tama.height;
/*  100 */     int rw = (w - 820) / 2;
/*  101 */     int rh = (h - 380) / 2;
/*  102 */     this.jDialog2.setLocation(rw, rh);
/*  103 */     this.jDialog2.setSize(820, 380);
/*  104 */     this.jDialog2.setVisible(false);
/*  105 */     this.jDialog2.setResizable(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  111 */     rw = (w - this.tama.width + 200) / 2;
/*  112 */     rh = (h - this.tama.height + 200) / 2;
/*  113 */     this.jDialog1.setLocation(rw, rh);
/*  114 */     this.jDialog1.setSize(this.tama.width - 200, this.tama.height - 200);
/*  115 */     this.jDialog1.setVisible(false);
/*  116 */     this.jDialog1.setResizable(false);
/*      */     
/*  118 */     rw = (w - 290) / 2;
/*  119 */     rh = (h - 135) / 2;
/*  120 */     this.jDialog3.setLocation(rw, rh);
/*  121 */     this.jDialog3.setSize(290, 135);
/*  122 */     this.jDialog3.setVisible(false);
/*  123 */     this.jDialog3.setResizable(false);
/*      */     
/*  125 */     rw = (w - 365) / 2;
/*  126 */     rh = (h - 590) / 2;
/*  127 */     this.jDialog4.setLocation(rw, rh);
/*  128 */     this.jDialog4.setSize(365, 457);
/*  129 */     this.jDialog4.setVisible(false);
/*  130 */     this.jDialog4.setResizable(false);
/*      */     
/*  132 */     rw = (w - 365) / 2;
/*  133 */     rh = (h - 535) / 2;
/*  134 */     this.jDialog5.setLocation(rw, rh);
/*  135 */     this.jDialog5.setSize(365, 535);
/*  136 */     this.jDialog5.setVisible(false);
/*  137 */     this.jDialog5.setResizable(false);
/*      */     
/*  139 */     rw = (w - 350) / 2;
/*  140 */     rh = (h - 510) / 2;
/*  141 */     this.jDialog6.setLocation(rw, rh);
/*  142 */     this.jDialog6.setSize(350, 510);
/*  143 */     this.jDialog6.setVisible(false);
/*  144 */     this.jDialog6.setResizable(false);
/*      */     
/*  146 */     rw = (w - 390) / 2;
/*  147 */     rh = (h - 230) / 2;
/*  148 */     this.jDialog7.setLocation(rw, rh);
/*  149 */     this.jDialog7.setSize(390, 230);
/*  150 */     this.jDialog7.setVisible(false);
/*  151 */     this.jDialog7.setResizable(false);
/*      */     
/*  153 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  154 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  155 */     this.jDialog1.setCursor(micursor);
/*  156 */     this.jDialog2.setCursor(micursor);
/*  157 */     this.jDialog3.setCursor(micursor);
/*  158 */     this.jDialog4.setCursor(micursor);
/*  159 */     this.jDialog5.setCursor(micursor);
/*  160 */     this.jDialog6.setCursor(micursor);
/*  161 */     this.jDialog7.setCursor(micursor);
/*      */     
/*  163 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  164 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  165 */     this.jLabel8.setCursor(micursor);
/*      */     
/*  167 */     colorear();
/*  168 */     llenarCombo();
/*      */     
/*  170 */     if (!entradaPrincipal) {
/*  171 */       consultar();
/*  172 */       extraerUsuario(USUARIO);
/*      */     } 
/*      */     
/*  175 */     this.jTable5.setModel(this.modelo);
/*  176 */     this.modelo.addColumn("Clave");
/*  177 */     this.modelo.addColumn("Nombre Completo");
/*      */     
/*  179 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  180 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  181 */     editFormat.setGroupingUsed(false);
/*  182 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  183 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  184 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  185 */     enFormat.setAllowsInvalid(true);
/*  186 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  187 */     this.jFormattedTextField2.setFormatterFactory(currFactory);
/*  188 */     this.jFormattedTextField3.setFormatterFactory(currFactory);
/*      */     
/*  190 */     this.jTable5.setSelectionMode(0);
/*  191 */     this.jTable5.setAutoCreateRowSorter(true);
/*  192 */     this.jTable5.getTableHeader().setReorderingAllowed(false);
/*  193 */     this.jTable5.getColumnModel().getColumn(0).setPreferredWidth(60);
/*  194 */     this.jTable5.getColumnModel().getColumn(0).setMaxWidth(60);
/*  195 */     this.jTable5.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/*  196 */     this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */ 
/*      */     
/*  199 */     this.DIRECTIVAS = CAMPOSGENERALES.get("directiva").toString();
/*  200 */     cargarFechaHoy();
/*      */     
/*  202 */     desactivarFiltroOperadores();
/*      */   }
/*      */   private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel9; private JLabel jLabel92; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5; private JRadioButton jRadioButton6; private JRadioButton jRadioButton7; private JRadioButton jRadioButton8; private JRadioButton jRadioButton9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JScrollPane jScrollPane8; private JSeparator jSeparator1; private JSeparator jSeparator11; private JSeparator jSeparator3; private JSeparator jSeparator4; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator7; private JSeparator jSeparator8; private JTable jTable1; private JTable jTable2; private JTable jTable4; private JTable jTable5; private JTextArea jTextArea1; private JTextArea jTextArea2; private JTextArea jTextArea3; private JTextArea jTextArea4; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13;
/*      */   private JTextField jTextField14;
/*      */   private JTextField jTextField2;
/*      */   private JTextField jTextField3;
/*      */   private JTextField jTextField4;
/*      */   private JTextField jTextField5;
/*      */   private JTextField jTextField6;
/*      */   private JTextField jTextField7;
/*      */   private JTextField jTextField8;
/*      */   private JTextField jTextField9;
/*      */   
/*      */   private void initComponents() {
/*  216 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  217 */     this.jPanel5 = new JPanel();
/*  218 */     this.jLabel62 = new JLabel();
/*  219 */     this.jSeparator3 = new JSeparator();
/*  220 */     this.jPanel15 = new JPanel();
/*  221 */     this.jLabel13 = new JLabel();
/*  222 */     this.jComboBox4 = new JComboBox();
/*  223 */     this.jLabel14 = new JLabel();
/*  224 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  225 */     this.jLabel21 = new JLabel();
/*  226 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  227 */     this.jScrollPane2 = new JScrollPane();
/*  228 */     this.jTable2 = new JTable();
/*  229 */     this.jPanel16 = new JPanel();
/*  230 */     this.jButton5 = new JButton();
/*  231 */     this.jButton6 = new JButton();
/*  232 */     this.jButton7 = new JButton();
/*  233 */     this.jPanel18 = new JPanel();
/*  234 */     this.jButton17 = new JButton();
/*  235 */     this.jPanel19 = new JPanel();
/*  236 */     this.jPanel20 = new JPanel();
/*  237 */     this.jPanel21 = new JPanel();
/*  238 */     this.jPanel22 = new JPanel();
/*  239 */     this.jButton8 = new JButton();
/*  240 */     this.jPanel17 = new JPanel();
/*  241 */     this.jLabel1 = new JLabel();
/*  242 */     this.jTextField2 = new JTextField();
/*  243 */     this.buttonGroup1 = new ButtonGroup();
/*  244 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  245 */     this.jPanel9 = new JPanel();
/*  246 */     this.jLabel63 = new JLabel();
/*  247 */     this.jSeparator4 = new JSeparator();
/*  248 */     this.jScrollPane4 = new JScrollPane();
/*  249 */     this.jTable4 = new JTable();
/*  250 */     this.jButton11 = new JButton();
/*  251 */     this.jButton12 = new JButton();
/*  252 */     this.jButton13 = new JButton();
/*  253 */     this.jButton14 = new JButton();
/*  254 */     this.jScrollPane5 = new JScrollPane();
/*  255 */     this.jTable5 = new JTable();
/*  256 */     this.jButton15 = new JButton();
/*  257 */     this.jComboBox1 = new JComboBox();
/*  258 */     this.jLabel78 = new JLabel();
/*  259 */     this.jLabel79 = new JLabel();
/*  260 */     this.jButton16 = new JButton();
/*  261 */     this.jLabel17 = new JLabel();
/*  262 */     this.jTextField3 = new JTextField();
/*  263 */     this.jLabel18 = new JLabel();
/*  264 */     this.jTextField4 = new JTextField();
/*  265 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  266 */     this.jPanel11 = new JPanel();
/*  267 */     this.jLabel92 = new JLabel();
/*  268 */     this.jSeparator11 = new JSeparator();
/*  269 */     this.jButton30 = new JButton();
/*  270 */     this.jButton31 = new JButton();
/*  271 */     this.jRadioButton1 = new JRadioButton();
/*  272 */     this.jRadioButton2 = new JRadioButton();
/*  273 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  274 */     this.jPanel10 = new JPanel();
/*  275 */     this.jLabel64 = new JLabel();
/*  276 */     this.jSeparator5 = new JSeparator();
/*  277 */     this.jLabel65 = new JLabel();
/*  278 */     this.jTextField5 = new JTextField();
/*  279 */     this.jLabel66 = new JLabel();
/*  280 */     this.jTextField6 = new JTextField();
/*  281 */     this.jButton19 = new JButton();
/*  282 */     this.jLabel8 = new JLabel();
/*  283 */     this.jPanel1 = new JPanel();
/*  284 */     this.jLabel2 = new JLabel();
/*  285 */     this.jLabel67 = new JLabel();
/*  286 */     this.jLabel68 = new JLabel();
/*  287 */     this.jLabel4 = new JLabel();
/*  288 */     this.jLabel69 = new JLabel();
/*  289 */     this.jLabel5 = new JLabel();
/*  290 */     this.jLabel70 = new JLabel();
/*  291 */     this.jLabel6 = new JLabel();
/*  292 */     this.jPanel4 = new JPanel();
/*  293 */     this.jLabel20 = new JLabel();
/*  294 */     this.jScrollPane3 = new JScrollPane();
/*  295 */     this.jTextArea1 = new JTextArea();
/*  296 */     this.jButton25 = new JButton();
/*  297 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  298 */     this.jPanel12 = new JPanel();
/*  299 */     this.jLabel71 = new JLabel();
/*  300 */     this.jSeparator6 = new JSeparator();
/*  301 */     this.jLabel73 = new JLabel();
/*  302 */     this.jTextField8 = new JTextField();
/*  303 */     this.jButton20 = new JButton();
/*  304 */     this.jLabel74 = new JLabel();
/*  305 */     this.jLabel7 = new JLabel();
/*  306 */     this.jPanel2 = new JPanel();
/*  307 */     this.jRadioButton6 = new JRadioButton();
/*  308 */     this.jRadioButton7 = new JRadioButton();
/*  309 */     this.jRadioButton3 = new JRadioButton();
/*  310 */     this.jRadioButton4 = new JRadioButton();
/*  311 */     this.jTextField9 = new JTextField();
/*  312 */     this.jLabel9 = new JLabel();
/*  313 */     this.jDateChooser2 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  314 */     this.jLabel10 = new JLabel();
/*  315 */     this.jDateChooser3 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  316 */     this.jLabel75 = new JLabel();
/*  317 */     this.jTextField7 = new JTextField();
/*  318 */     this.jLabel76 = new JLabel();
/*  319 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  320 */     this.jLabel77 = new JLabel();
/*  321 */     this.jScrollPane6 = new JScrollPane();
/*  322 */     this.jTextArea2 = new JTextArea();
/*  323 */     this.jButton21 = new JButton();
/*  324 */     this.jLabel80 = new JLabel();
/*  325 */     this.jTextField10 = new JTextField();
/*  326 */     this.buttonGroup2 = new ButtonGroup();
/*  327 */     this.buttonGroup3 = new ButtonGroup();
/*  328 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  329 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  330 */     this.jPanel13 = new JPanel();
/*  331 */     this.jLabel72 = new JLabel();
/*  332 */     this.jSeparator7 = new JSeparator();
/*  333 */     this.jLabel81 = new JLabel();
/*  334 */     this.jTextField11 = new JTextField();
/*  335 */     this.jButton22 = new JButton();
/*  336 */     this.jLabel82 = new JLabel();
/*  337 */     this.jLabel11 = new JLabel();
/*  338 */     this.jLabel83 = new JLabel();
/*  339 */     this.jTextField13 = new JTextField();
/*  340 */     this.jLabel84 = new JLabel();
/*  341 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  342 */     this.jLabel85 = new JLabel();
/*  343 */     this.jScrollPane7 = new JScrollPane();
/*  344 */     this.jTextArea3 = new JTextArea();
/*  345 */     this.jButton23 = new JButton();
/*  346 */     this.jLabel86 = new JLabel();
/*  347 */     this.jTextField14 = new JTextField();
/*  348 */     this.jPanel3 = new JPanel();
/*  349 */     this.jRadioButton5 = new JRadioButton();
/*  350 */     this.jRadioButton8 = new JRadioButton();
/*  351 */     this.jRadioButton9 = new JRadioButton();
/*  352 */     this.jTextField12 = new JTextField();
/*  353 */     this.buttonGroup4 = new ButtonGroup();
/*  354 */     this.buttonGroup5 = new ButtonGroup();
/*  355 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  356 */     this.jPanel14 = new JPanel();
/*  357 */     this.jLabel87 = new JLabel();
/*  358 */     this.jSeparator8 = new JSeparator();
/*  359 */     this.jLabel88 = new JLabel();
/*  360 */     this.jButton18 = new JButton();
/*  361 */     this.jButton24 = new JButton();
/*  362 */     this.jScrollPane8 = new JScrollPane();
/*  363 */     this.jTextArea4 = new JTextArea();
/*  364 */     this.jLabel12 = new JLabel();
/*  365 */     this.jPanel8 = new JPanel();
/*  366 */     this.jPanel7 = new JPanel();
/*  367 */     this.jPanel6 = new JPanel();
/*  368 */     this.jLabel3 = new JLabel();
/*  369 */     this.jSeparator1 = new JSeparator();
/*  370 */     this.jScrollPane1 = new JScrollPane();
/*  371 */     this.jTable1 = new JTable();
/*  372 */     this.jTextField1 = new JTextField();
/*  373 */     this.jButton1 = new JButton();
/*  374 */     this.jButton2 = new JButton();
/*  375 */     this.jLabel15 = new JLabel();
/*  376 */     this.jButton3 = new JButton();
/*  377 */     this.jButton10 = new JButton();
/*  378 */     this.jLabel48 = new JLabel();
/*  379 */     this.jLabel16 = new JLabel();
/*  380 */     this.jComboBox2 = new JComboBox();
/*  381 */     this.jButton9 = new JButton();
/*  382 */     this.jLabel19 = new JLabel();
/*  383 */     this.jComboBox3 = new JComboBox();
/*      */     
/*  385 */     this.jDialog1.setTitle("Administrar Tarjetas de Deudor");
/*  386 */     this.jDialog1.setModal(true);
/*      */     
/*  388 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/*      */     
/*  390 */     this.jLabel62.setFont(new Font("Tahoma", 1, 16));
/*  391 */     this.jLabel62.setHorizontalAlignment(0);
/*  392 */     this.jLabel62.setText("Tarjeta de ");
/*      */     
/*  394 */     this.jPanel15.setBackground(new Color(146, 193, 134));
/*  395 */     this.jPanel15.setBorder(BorderFactory.createTitledBorder("Búsqueda por concepto"));
/*      */     
/*  397 */     this.jLabel13.setFont(new Font("Tahoma", 2, 11));
/*  398 */     this.jLabel13.setForeground(new Color(15, 87, 51));
/*  399 */     this.jLabel13.setText("Ingresa el concepto");
/*      */     
/*  401 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  402 */     this.jComboBox4.setEditable(true);
/*  403 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "GASTOS", "INFONAVIT", "LIQUIDACIÓN", "NEXTEL", "NÓMINA", "PRÉSTAMO" }));
/*  404 */     this.jComboBox4.setToolTipText("Enter para establecer la consulta");
/*  405 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  407 */             TarjetasDeudoras.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  411 */     this.jLabel14.setFont(new Font("Tahoma", 2, 11));
/*  412 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/*  413 */     this.jLabel14.setText("de");
/*      */     
/*  415 */     this.jDateChooser4.setDate(this.fechaActual);
/*  416 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/*  417 */     this.jDateChooser4.setIcon(this.icon);
/*  418 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/*  419 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/*  421 */     this.jLabel21.setFont(new Font("Tahoma", 2, 11));
/*  422 */     this.jLabel21.setForeground(new Color(15, 87, 51));
/*  423 */     this.jLabel21.setText("Hasta");
/*      */     
/*  425 */     this.jDateChooser5.setDate(this.fechaActual);
/*  426 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/*  427 */     this.jDateChooser5.setIcon(this.icon);
/*  428 */     this.jDateChooser5.setMaxSelectableDate(this.fecha);
/*  429 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/*  431 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/*  432 */     this.jPanel15.setLayout(jPanel15Layout);
/*  433 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/*  434 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  435 */         .addGroup(jPanel15Layout.createSequentialGroup()
/*  436 */           .addComponent(this.jLabel13, -2, 165, -2)
/*  437 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  438 */           .addComponent(this.jComboBox4, -2, 133, -2)
/*  439 */           .addGap(40, 40, 40)
/*  440 */           .addComponent(this.jLabel14)
/*  441 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  442 */           .addComponent((Component)this.jDateChooser4, -2, 135, -2)
/*  443 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  444 */           .addComponent(this.jLabel21)
/*  445 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  446 */           .addComponent((Component)this.jDateChooser5, -2, 135, -2)
/*  447 */           .addContainerGap(-1, 32767)));
/*      */     
/*  449 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/*  450 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  451 */         .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  452 */           .addComponent(this.jLabel13, -1, -1, 32767)
/*  453 */           .addComponent(this.jComboBox4)
/*  454 */           .addComponent(this.jLabel14, -2, 17, -2))
/*  455 */         .addComponent(this.jLabel21, -1, -1, 32767)
/*  456 */         .addComponent((Component)this.jDateChooser4, -1, -1, 32767)
/*  457 */         .addComponent((Component)this.jDateChooser5, -1, -1, 32767));
/*      */ 
/*      */     
/*  460 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/*  461 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Mov.", "Fecha", "Concepto", "Referencia", "Cargo", "Abono", "Saldo", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  469 */     this.jTable2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  471 */             TarjetasDeudoras.this.jTable2MouseClicked(evt);
/*      */           }
/*      */         });
/*  474 */     this.jScrollPane2.setViewportView(this.jTable2);
/*  475 */     if (this.jTable2.getColumnModel().getColumnCount() > 0) {
/*  476 */       this.jTable2.getColumnModel().getColumn(0).setMinWidth(50);
/*  477 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/*  478 */       this.jTable2.getColumnModel().getColumn(1).setMinWidth(120);
/*  479 */       this.jTable2.getColumnModel().getColumn(1).setMaxWidth(120);
/*  480 */       this.jTable2.getColumnModel().getColumn(3).setMinWidth(140);
/*  481 */       this.jTable2.getColumnModel().getColumn(3).setMaxWidth(140);
/*      */     } 
/*      */     
/*  484 */     this.jPanel16.setBackground(new Color(146, 193, 134));
/*  485 */     this.jPanel16.setLayout(new GridLayout(2, 5, 6, 6));
/*      */     
/*  487 */     this.jButton5.setMnemonic('R');
/*  488 */     this.jButton5.setText("Cargo Directo");
/*  489 */     this.jButton5.setToolTipText("Cargo Directo (Alt+R)");
/*  490 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  492 */             TarjetasDeudoras.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*  495 */     this.jPanel16.add(this.jButton5);
/*      */     
/*  497 */     this.jButton6.setMnemonic('A');
/*  498 */     this.jButton6.setText("Abono");
/*  499 */     this.jButton6.setToolTipText("Nuevo Abono (Alt+A)");
/*  500 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  502 */             TarjetasDeudoras.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*  505 */     this.jPanel16.add(this.jButton6);
/*      */     
/*  507 */     this.jButton7.setMnemonic('L');
/*  508 */     this.jButton7.setText("Cancelar");
/*  509 */     this.jButton7.setToolTipText("Cancelar (Alt+L)");
/*  510 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  512 */             TarjetasDeudoras.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*  515 */     this.jPanel16.add(this.jButton7);
/*      */     
/*  517 */     this.jPanel18.setBackground(new Color(146, 193, 134));
/*      */     
/*  519 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/*  520 */     this.jPanel18.setLayout(jPanel18Layout);
/*  521 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/*  522 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  523 */         .addGap(0, 144, 32767));
/*      */     
/*  525 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/*  526 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  527 */         .addGap(0, 28, 32767));
/*      */ 
/*      */     
/*  530 */     this.jPanel16.add(this.jPanel18);
/*      */     
/*  532 */     this.jButton17.setMnemonic('G');
/*  533 */     this.jButton17.setText("Guardar Reporte");
/*  534 */     this.jButton17.setToolTipText("Guardar Reporte (Alt+G)");
/*  535 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  537 */             TarjetasDeudoras.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*  540 */     this.jPanel16.add(this.jButton17);
/*      */     
/*  542 */     this.jPanel19.setBackground(new Color(146, 193, 134));
/*      */     
/*  544 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/*  545 */     this.jPanel19.setLayout(jPanel19Layout);
/*  546 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/*  547 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  548 */         .addGap(0, 144, 32767));
/*      */     
/*  550 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/*  551 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  552 */         .addGap(0, 28, 32767));
/*      */ 
/*      */     
/*  555 */     this.jPanel16.add(this.jPanel19);
/*      */     
/*  557 */     this.jPanel20.setBackground(new Color(146, 193, 134));
/*      */     
/*  559 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/*  560 */     this.jPanel20.setLayout(jPanel20Layout);
/*  561 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/*  562 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  563 */         .addGap(0, 144, 32767));
/*      */     
/*  565 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/*  566 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  567 */         .addGap(0, 28, 32767));
/*      */ 
/*      */     
/*  570 */     this.jPanel16.add(this.jPanel20);
/*      */     
/*  572 */     this.jPanel21.setBackground(new Color(146, 193, 134));
/*      */     
/*  574 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/*  575 */     this.jPanel21.setLayout(jPanel21Layout);
/*  576 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/*  577 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  578 */         .addGap(0, 144, 32767));
/*      */     
/*  580 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/*  581 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  582 */         .addGap(0, 28, 32767));
/*      */ 
/*      */     
/*  585 */     this.jPanel16.add(this.jPanel21);
/*      */     
/*  587 */     this.jPanel22.setBackground(new Color(146, 193, 134));
/*      */     
/*  589 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/*  590 */     this.jPanel22.setLayout(jPanel22Layout);
/*  591 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/*  592 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  593 */         .addGap(0, 144, 32767));
/*      */     
/*  595 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/*  596 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  597 */         .addGap(0, 28, 32767));
/*      */ 
/*      */     
/*  600 */     this.jPanel16.add(this.jPanel22);
/*      */     
/*  602 */     this.jButton8.setMnemonic('C');
/*  603 */     this.jButton8.setText("Cerrar");
/*  604 */     this.jButton8.setToolTipText("Cerrar (Alt+C)");
/*  605 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  607 */             TarjetasDeudoras.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*  610 */     this.jPanel16.add(this.jButton8);
/*      */     
/*  612 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*  613 */     this.jPanel17.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  615 */     this.jLabel1.setFont(new Font("Tahoma", 1, 16));
/*  616 */     this.jLabel1.setForeground(new Color(15, 87, 51));
/*  617 */     this.jLabel1.setHorizontalAlignment(4);
/*  618 */     this.jLabel1.setText("Saldo Actual");
/*  619 */     this.jPanel17.add(this.jLabel1);
/*      */     
/*  621 */     this.jTextField2.setEditable(false);
/*  622 */     this.jTextField2.setFont(new Font("Tahoma", 1, 22));
/*  623 */     this.jTextField2.setForeground(Color.darkGray);
/*  624 */     this.jTextField2.setHorizontalAlignment(4);
/*  625 */     this.jTextField2.setText("$ 10000.00");
/*  626 */     this.jPanel17.add(this.jTextField2);
/*      */     
/*  628 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  629 */     this.jPanel5.setLayout(jPanel5Layout);
/*  630 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  631 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  632 */         .addComponent(this.jLabel62, -1, -1, 32767)
/*  633 */         .addComponent(this.jSeparator3, GroupLayout.Alignment.TRAILING)
/*  634 */         .addComponent(this.jPanel15, -1, -1, 32767)
/*  635 */         .addComponent(this.jScrollPane2)
/*  636 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  637 */           .addComponent(this.jPanel16, -1, 746, 32767)
/*  638 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  639 */           .addComponent(this.jPanel17, -1, 245, 32767)));
/*      */     
/*  641 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/*  642 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  643 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  644 */           .addComponent(this.jLabel62, -2, 20, -2)
/*  645 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  646 */           .addComponent(this.jSeparator3, -2, 10, -2)
/*  647 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  648 */           .addComponent(this.jPanel15, -2, -1, -2)
/*  649 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  650 */           .addComponent(this.jScrollPane2, -1, 214, 32767)
/*  651 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  652 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  653 */             .addComponent(this.jPanel16, -2, 62, -2)
/*  654 */             .addComponent(this.jPanel17, -1, -1, 32767))
/*  655 */           .addContainerGap()));
/*      */ 
/*      */     
/*  658 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  659 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  660 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  661 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  662 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  663 */           .addComponent(this.jPanel5, -1, -1, 32767)
/*  664 */           .addGap(0, 0, 0)));
/*      */     
/*  666 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  667 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  668 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  669 */           .addComponent(this.jPanel5, -1, -1, 32767)
/*  670 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/*  673 */     this.jDialog2.setTitle("Administrar Tarjetas de Deudor");
/*  674 */     this.jDialog2.setModal(true);
/*      */     
/*  676 */     this.jPanel9.setBackground(new Color(146, 193, 134));
/*      */     
/*  678 */     this.jLabel63.setFont(new Font("Tahoma", 1, 16));
/*  679 */     this.jLabel63.setForeground(new Color(0, 102, 102));
/*  680 */     this.jLabel63.setHorizontalAlignment(0);
/*  681 */     this.jLabel63.setText("ADMINISTRAR TARJETAS DEUDOR");
/*      */     
/*  683 */     this.jTable4.setFont(new Font("Tahoma", 0, 10));
/*  684 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  692 */     this.jTable4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  694 */             TarjetasDeudoras.this.jTable4MouseClicked(evt);
/*      */           }
/*      */         });
/*  697 */     this.jScrollPane4.setViewportView(this.jTable4);
/*  698 */     if (this.jTable4.getColumnModel().getColumnCount() > 0) {
/*  699 */       this.jTable4.getColumnModel().getColumn(0).setMinWidth(50);
/*  700 */       this.jTable4.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     } 
/*      */     
/*  703 */     this.jButton11.setText(">>");
/*  704 */     this.jButton11.setToolTipText("Mover Todos");
/*  705 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  707 */             TarjetasDeudoras.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  711 */     this.jButton12.setText(">");
/*  712 */     this.jButton12.setToolTipText("Mover Seleccionado");
/*  713 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  715 */             TarjetasDeudoras.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  719 */     this.jButton13.setText("<");
/*  720 */     this.jButton13.setToolTipText("Quitar Seleccionado");
/*  721 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  723 */             TarjetasDeudoras.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  727 */     this.jButton14.setText("<<");
/*  728 */     this.jButton14.setToolTipText("Quitar Todos");
/*  729 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  731 */             TarjetasDeudoras.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  735 */     this.jTable5.setFont(new Font("Tahoma", 0, 10));
/*  736 */     this.jTable5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  744 */     this.jTable5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  746 */             TarjetasDeudoras.this.jTable5MouseClicked(evt);
/*      */           }
/*      */         });
/*  749 */     this.jScrollPane5.setViewportView(this.jTable5);
/*  750 */     if (this.jTable5.getColumnModel().getColumnCount() > 0) {
/*  751 */       this.jTable5.getColumnModel().getColumn(0).setMinWidth(50);
/*  752 */       this.jTable5.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     } 
/*      */     
/*  755 */     this.jButton15.setMnemonic('C');
/*  756 */     this.jButton15.setText("Cerrar");
/*  757 */     this.jButton15.setToolTipText("Cerrar Ventana (Alt+C)");
/*  758 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  760 */             TarjetasDeudoras.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  764 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  765 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/*  766 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Departamento" }));
/*  767 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  769 */             TarjetasDeudoras.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  773 */     this.jLabel78.setFont(new Font("Tahoma", 3, 11));
/*  774 */     this.jLabel78.setForeground(Color.darkGray);
/*  775 */     this.jLabel78.setHorizontalAlignment(0);
/*  776 */     this.jLabel78.setText("Lista de Operadores");
/*  777 */     this.jLabel78.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  779 */     this.jLabel79.setFont(new Font("Tahoma", 3, 11));
/*  780 */     this.jLabel79.setForeground(Color.darkGray);
/*  781 */     this.jLabel79.setHorizontalAlignment(0);
/*  782 */     this.jLabel79.setText("Crear Nueva Tarjeta Deudor");
/*  783 */     this.jLabel79.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  785 */     this.jButton16.setMnemonic('G');
/*  786 */     this.jButton16.setText("Guardar");
/*  787 */     this.jButton16.setToolTipText("Guardar Tarjetas(Alt+G)");
/*  788 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  790 */             TarjetasDeudoras.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  794 */     this.jLabel17.setFont(new Font("Tahoma", 3, 12));
/*  795 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/*  796 */     this.jLabel17.setText("Clave");
/*      */     
/*  798 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  800 */             TarjetasDeudoras.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  804 */     this.jLabel18.setFont(new Font("Tahoma", 3, 12));
/*  805 */     this.jLabel18.setForeground(new Color(15, 87, 51));
/*  806 */     this.jLabel18.setText("Nombre");
/*      */     
/*  808 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  810 */             TarjetasDeudoras.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  814 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  815 */     this.jPanel9.setLayout(jPanel9Layout);
/*  816 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  817 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  818 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  819 */           .addContainerGap()
/*  820 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  821 */             .addComponent(this.jLabel63, -1, 795, 32767)
/*  822 */             .addComponent(this.jSeparator4, -1, 795, 32767)
/*  823 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  824 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  825 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
/*  826 */                   .addComponent(this.jLabel17, -2, 44, -2)
/*  827 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  828 */                   .addComponent(this.jTextField3, -2, 55, -2)
/*  829 */                   .addGap(18, 18, 18)
/*  830 */                   .addComponent(this.jLabel18, -2, 58, -2)
/*  831 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  832 */                   .addComponent(this.jTextField4))
/*  833 */                 .addComponent(this.jLabel78, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  834 */                 .addComponent(this.jScrollPane4, GroupLayout.Alignment.LEADING, -1, 341, 32767))
/*  835 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  836 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  837 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  838 */                   .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  839 */                     .addComponent(this.jButton16, -2, 87, -2)
/*  840 */                     .addComponent(this.jButton15, -2, 87, -2)
/*  841 */                     .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  842 */                       .addComponent(this.jButton11, -2, 87, -2)
/*  843 */                       .addComponent(this.jButton14, -2, 87, -2)
/*  844 */                       .addComponent(this.jButton13, -2, 87, -2)
/*  845 */                       .addComponent(this.jButton12, -2, 87, -2)))
/*  846 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  847 */                   .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  848 */                     .addComponent(this.jLabel79, -1, 351, 32767)
/*  849 */                     .addComponent(this.jScrollPane5, -1, 351, 32767)))
/*  850 */                 .addComponent(this.jComboBox1, -2, 168, -2))))
/*  851 */           .addContainerGap()));
/*      */     
/*  853 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  854 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  855 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  856 */           .addComponent(this.jLabel63, -2, 20, -2)
/*  857 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  858 */           .addComponent(this.jSeparator4, -2, 10, -2)
/*  859 */           .addGap(6, 6, 6)
/*  860 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  861 */             .addComponent(this.jLabel17)
/*  862 */             .addComponent(this.jTextField3, -2, -1, -2)
/*  863 */             .addComponent(this.jLabel18)
/*  864 */             .addComponent(this.jTextField4, -2, -1, -2)
/*  865 */             .addComponent(this.jComboBox1, -2, -1, -2))
/*  866 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  867 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
/*  868 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  869 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  870 */                 .addComponent(this.jScrollPane4, -2, 244, -2)
/*  871 */                 .addComponent(this.jScrollPane5, -2, 244, -2))
/*  872 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  873 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  874 */                 .addComponent(this.jLabel79)
/*  875 */                 .addComponent(this.jLabel78)))
/*  876 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
/*  877 */               .addGap(31, 31, 31)
/*  878 */               .addComponent(this.jButton11)
/*  879 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  880 */               .addComponent(this.jButton12)
/*  881 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  882 */               .addComponent(this.jButton13)
/*  883 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  884 */               .addComponent(this.jButton14)
/*  885 */               .addGap(36, 36, 36)
/*  886 */               .addComponent(this.jButton16)
/*  887 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  888 */               .addComponent(this.jButton15)))
/*  889 */           .addContainerGap()));
/*      */ 
/*      */     
/*  892 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  893 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  894 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  895 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  896 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/*  898 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  899 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  900 */         .addComponent(this.jPanel9, -2, -1, -2));
/*      */ 
/*      */     
/*  903 */     this.jDialog3.setTitle("Tipo de Deudor");
/*  904 */     this.jDialog3.setModal(true);
/*      */     
/*  906 */     this.jPanel11.setBackground(new Color(146, 193, 134));
/*      */     
/*  908 */     this.jLabel92.setFont(new Font("Tahoma", 1, 14));
/*  909 */     this.jLabel92.setForeground(new Color(0, 102, 102));
/*  910 */     this.jLabel92.setHorizontalAlignment(0);
/*  911 */     this.jLabel92.setText("SELECCIONA UNA OPCIÓN");
/*      */     
/*  913 */     this.jButton30.setMnemonic('I');
/*  914 */     this.jButton30.setText("Ir");
/*  915 */     this.jButton30.setToolTipText("Ir a Tarjetas (Alt+I)");
/*  916 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  918 */             TarjetasDeudoras.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  922 */     this.jButton31.setMnemonic('C');
/*  923 */     this.jButton31.setText("Cerrar");
/*  924 */     this.jButton31.setToolTipText("Cerrar (Alt+C)");
/*  925 */     this.jButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  927 */             TarjetasDeudoras.this.jButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  931 */     this.jRadioButton1.setSelected(true);
/*  932 */     this.jRadioButton1.setText("Operadores");
/*  933 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  935 */             TarjetasDeudoras.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  939 */     this.jRadioButton2.setText("Empleados");
/*  940 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  942 */             TarjetasDeudoras.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  946 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/*  947 */     this.jPanel11.setLayout(jPanel11Layout);
/*  948 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/*  949 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  950 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  951 */           .addContainerGap()
/*  952 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  953 */             .addGroup(jPanel11Layout.createSequentialGroup()
/*  954 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  955 */                 .addComponent(this.jLabel92, -1, -1, 32767)
/*  956 */                 .addGroup(jPanel11Layout.createSequentialGroup()
/*  957 */                   .addComponent(this.jRadioButton1, -2, 128, -2)
/*  958 */                   .addGap(18, 18, 18)
/*  959 */                   .addComponent(this.jRadioButton2, -2, 120, -2))
/*  960 */                 .addComponent(this.jSeparator11))
/*  961 */               .addGap(0, 0, 32767))
/*  962 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/*  963 */               .addGap(0, 0, 32767)
/*  964 */               .addComponent(this.jButton30, -2, 84, -2)
/*  965 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  966 */               .addComponent(this.jButton31, -2, 79, -2)))
/*  967 */           .addContainerGap()));
/*      */     
/*  969 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/*  970 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  971 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  972 */           .addComponent(this.jLabel92)
/*  973 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  974 */           .addComponent(this.jSeparator11, -2, 10, -2)
/*  975 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  976 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  977 */             .addComponent(this.jRadioButton1)
/*  978 */             .addComponent(this.jRadioButton2))
/*  979 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  980 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  981 */             .addComponent(this.jButton31)
/*  982 */             .addComponent(this.jButton30))
/*  983 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  986 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/*  987 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/*  988 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/*  989 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  990 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */     
/*  992 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/*  993 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  994 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */ 
/*      */     
/*  997 */     this.jDialog4.setTitle("Vale de Caja Chica");
/*  998 */     this.jDialog4.setModal(true);
/*      */     
/* 1000 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*      */     
/* 1002 */     this.jLabel64.setFont(new Font("Tahoma", 1, 14));
/* 1003 */     this.jLabel64.setForeground(Color.blue);
/* 1004 */     this.jLabel64.setHorizontalAlignment(0);
/* 1005 */     this.jLabel64.setText("CONSULTA DEL MOVIMIENTO");
/*      */     
/* 1007 */     this.jLabel65.setFont(new Font("Tahoma", 3, 11));
/* 1008 */     this.jLabel65.setForeground(new Color(15, 87, 51));
/* 1009 */     this.jLabel65.setHorizontalAlignment(4);
/* 1010 */     this.jLabel65.setText("Mov ");
/*      */     
/* 1012 */     this.jTextField5.setEditable(false);
/* 1013 */     this.jTextField5.setFont(new Font("Tahoma", 1, 11));
/* 1014 */     this.jTextField5.setForeground(Color.red);
/* 1015 */     this.jTextField5.setHorizontalAlignment(4);
/* 1016 */     this.jTextField5.setText("PR-00001");
/*      */     
/* 1018 */     this.jLabel66.setFont(new Font("Tahoma", 3, 11));
/* 1019 */     this.jLabel66.setForeground(new Color(15, 87, 51));
/* 1020 */     this.jLabel66.setHorizontalAlignment(4);
/* 1021 */     this.jLabel66.setText("Fecha ");
/*      */     
/* 1023 */     this.jTextField6.setEditable(false);
/* 1024 */     this.jTextField6.setFont(new Font("Tahoma", 1, 11));
/* 1025 */     this.jTextField6.setForeground(Color.red);
/* 1026 */     this.jTextField6.setText("26/04/2010");
/*      */     
/* 1028 */     this.jButton19.setMnemonic('C');
/* 1029 */     this.jButton19.setText("Cerrar");
/* 1030 */     this.jButton19.setToolTipText("Cerrar (Alt+C)");
/* 1031 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1033 */             TarjetasDeudoras.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1037 */     this.jLabel8.setFont(new Font("Tahoma", 3, 11));
/* 1038 */     this.jLabel8.setForeground(Color.red);
/* 1039 */     this.jLabel8.setText("<html><u>Click para ver el Estado</u></html>");
/* 1040 */     this.jLabel8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1042 */             TarjetasDeudoras.this.jLabel8MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1045 */             TarjetasDeudoras.this.jLabel8MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1048 */             TarjetasDeudoras.this.jLabel8MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1052 */     this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1054 */     this.jLabel2.setFont(new Font("Tahoma", 1, 11));
/* 1055 */     this.jLabel2.setText("CARGO");
/*      */     
/* 1057 */     this.jLabel67.setFont(new Font("Tahoma", 3, 11));
/* 1058 */     this.jLabel67.setForeground(new Color(15, 87, 51));
/* 1059 */     this.jLabel67.setHorizontalAlignment(2);
/* 1060 */     this.jLabel67.setText("Tipo");
/*      */     
/* 1062 */     this.jLabel68.setFont(new Font("Tahoma", 3, 11));
/* 1063 */     this.jLabel68.setForeground(new Color(15, 87, 51));
/* 1064 */     this.jLabel68.setHorizontalAlignment(2);
/* 1065 */     this.jLabel68.setText("Concepto ");
/*      */     
/* 1067 */     this.jLabel4.setFont(new Font("Tahoma", 1, 11));
/* 1068 */     this.jLabel4.setText("GASTOS POR COMPROBAR");
/*      */     
/* 1070 */     this.jLabel69.setFont(new Font("Tahoma", 3, 11));
/* 1071 */     this.jLabel69.setForeground(new Color(15, 87, 51));
/* 1072 */     this.jLabel69.setHorizontalAlignment(2);
/* 1073 */     this.jLabel69.setText("Referencia ");
/*      */     
/* 1075 */     this.jLabel5.setFont(new Font("Tahoma", 1, 11));
/* 1076 */     this.jLabel5.setText("VALE: PR-00001");
/*      */     
/* 1078 */     this.jLabel70.setFont(new Font("Tahoma", 3, 11));
/* 1079 */     this.jLabel70.setForeground(new Color(15, 87, 51));
/* 1080 */     this.jLabel70.setHorizontalAlignment(2);
/* 1081 */     this.jLabel70.setText("Cantidad ");
/*      */     
/* 1083 */     this.jLabel6.setFont(new Font("Tahoma", 1, 11));
/* 1084 */     this.jLabel6.setHorizontalAlignment(0);
/* 1085 */     this.jLabel6.setText("$200.00");
/*      */     
/* 1087 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1088 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1089 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1090 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1091 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1092 */           .addContainerGap()
/* 1093 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1094 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1095 */               .addComponent(this.jLabel67, -2, 36, -2)
/* 1096 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1097 */               .addComponent(this.jLabel2, -2, 233, -2))
/* 1098 */             .addComponent(this.jLabel68)
/* 1099 */             .addComponent(this.jLabel4, -2, 286, -2)
/* 1100 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1101 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1102 */                 .addComponent(this.jLabel5, -2, 184, -2)
/* 1103 */                 .addComponent(this.jLabel69))
/* 1104 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767)
/* 1105 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1106 */                 .addComponent(this.jLabel6, -2, 88, -2)
/* 1107 */                 .addGroup(jPanel1Layout.createSequentialGroup()
/* 1108 */                   .addGap(20, 20, 20)
/* 1109 */                   .addComponent(this.jLabel70)))))
/* 1110 */           .addContainerGap()));
/*      */     
/* 1112 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1113 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1114 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1115 */           .addContainerGap()
/* 1116 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1117 */             .addComponent(this.jLabel67)
/* 1118 */             .addComponent(this.jLabel2))
/* 1119 */           .addGap(18, 18, 18)
/* 1120 */           .addComponent(this.jLabel68)
/* 1121 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1122 */           .addComponent(this.jLabel4)
/* 1123 */           .addGap(18, 18, 18)
/* 1124 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1125 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1126 */               .addComponent(this.jLabel69)
/* 1127 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1128 */               .addComponent(this.jLabel5))
/* 1129 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1130 */               .addComponent(this.jLabel70)
/* 1131 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1132 */               .addComponent(this.jLabel6)))
/* 1133 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1136 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder(0));
/*      */     
/* 1138 */     this.jLabel20.setForeground(Color.darkGray);
/* 1139 */     this.jLabel20.setHorizontalAlignment(0);
/* 1140 */     this.jLabel20.setText("Observaciones:");
/*      */     
/* 1142 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1143 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1144 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 1145 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1146 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1147 */           .addComponent(this.jLabel20, -1, 308, 32767)
/* 1148 */           .addContainerGap()));
/*      */     
/* 1150 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 1151 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1152 */         .addComponent(this.jLabel20));
/*      */ 
/*      */     
/* 1155 */     this.jTextArea1.setColumns(20);
/* 1156 */     this.jTextArea1.setFont(new Font("Tahoma", 0, 11));
/* 1157 */     this.jTextArea1.setLineWrap(true);
/* 1158 */     this.jTextArea1.setRows(5);
/* 1159 */     this.jTextArea1.setText("GASTOS PARA LA GUÍA PR-00001");
/* 1160 */     this.jTextArea1.setEnabled(false);
/* 1161 */     this.jScrollPane3.setViewportView(this.jTextArea1);
/*      */     
/* 1163 */     this.jButton25.setMnemonic('I');
/* 1164 */     this.jButton25.setText("Imprimir");
/* 1165 */     this.jButton25.setToolTipText("Imprimir (Alt+I)");
/* 1166 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1168 */             TarjetasDeudoras.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1172 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1173 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1174 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1175 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1176 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1177 */           .addContainerGap()
/* 1178 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1179 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 1180 */               .addComponent(this.jLabel65, -2, 34, -2)
/* 1181 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1182 */               .addComponent(this.jTextField5, -2, 74, -2)
/* 1183 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 80, 32767)
/* 1184 */               .addComponent(this.jLabel66, -2, 42, -2)
/* 1185 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1186 */               .addComponent(this.jTextField6, -2, 82, -2)
/* 1187 */               .addGap(21, 21, 21))
/* 1188 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/* 1189 */               .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1190 */                 .addComponent(this.jSeparator5, GroupLayout.Alignment.LEADING, -1, 331, 32767)
/* 1191 */                 .addComponent(this.jLabel64, GroupLayout.Alignment.LEADING, -1, 331, 32767)
/* 1192 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1193 */                   .addComponent(this.jScrollPane3, GroupLayout.Alignment.LEADING)
/* 1194 */                   .addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 1195 */               .addContainerGap())
/* 1196 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 1197 */               .addComponent(this.jLabel8, -2, 141, -2)
/* 1198 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767)
/* 1199 */               .addComponent(this.jButton25, -2, 79, -2)
/* 1200 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1201 */               .addComponent(this.jButton19, -2, 78, -2)
/* 1202 */               .addContainerGap())))
/* 1203 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1204 */           .addGroup(jPanel10Layout.createSequentialGroup()
/* 1205 */             .addContainerGap()
/* 1206 */             .addComponent(this.jPanel4, -2, -1, -2)
/* 1207 */             .addContainerGap(19, 32767))));
/*      */     
/* 1209 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1210 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1211 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1212 */           .addComponent(this.jLabel64)
/* 1213 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1214 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1215 */             .addComponent(this.jLabel65)
/* 1216 */             .addComponent(this.jTextField5, -2, -1, -2)
/* 1217 */             .addComponent(this.jLabel66)
/* 1218 */             .addComponent(this.jTextField6, -2, -1, -2))
/* 1219 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1220 */           .addComponent(this.jSeparator5, -2, 10, -2)
/* 1221 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1222 */           .addComponent(this.jPanel1, -2, -1, -2)
/* 1223 */           .addGap(36, 36, 36)
/* 1224 */           .addComponent(this.jScrollPane3, -2, 136, -2)
/* 1225 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1226 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1227 */             .addComponent(this.jLabel8, -2, -1, -2)
/* 1228 */             .addComponent(this.jButton19)
/* 1229 */             .addComponent(this.jButton25))
/* 1230 */           .addContainerGap(24, 32767))
/* 1231 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1232 */           .addGroup(jPanel10Layout.createSequentialGroup()
/* 1233 */             .addGap(221, 221, 221)
/* 1234 */             .addComponent(this.jPanel4, -2, -1, -2)
/* 1235 */             .addContainerGap(195, 32767))));
/*      */ 
/*      */     
/* 1238 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1239 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1240 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1241 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1242 */         .addComponent(this.jPanel10, -2, -1, -2));
/*      */     
/* 1244 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1245 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1246 */         .addComponent(this.jPanel10, -2, -1, -2));
/*      */ 
/*      */     
/* 1249 */     this.jDialog5.setTitle("Nuevo Cargo Directo");
/* 1250 */     this.jDialog5.setModal(true);
/*      */     
/* 1252 */     this.jPanel12.setBackground(new Color(146, 193, 134));
/*      */     
/* 1254 */     this.jLabel71.setFont(new Font("Tahoma", 1, 14));
/* 1255 */     this.jLabel71.setForeground(Color.blue);
/* 1256 */     this.jLabel71.setHorizontalAlignment(0);
/* 1257 */     this.jLabel71.setText("CARGO DIRECTO");
/*      */     
/* 1259 */     this.jLabel73.setFont(new Font("Tahoma", 3, 11));
/* 1260 */     this.jLabel73.setForeground(new Color(15, 87, 51));
/* 1261 */     this.jLabel73.setHorizontalAlignment(4);
/* 1262 */     this.jLabel73.setText("Fecha ");
/*      */     
/* 1264 */     this.jTextField8.setEditable(false);
/* 1265 */     this.jTextField8.setFont(new Font("Tahoma", 1, 11));
/* 1266 */     this.jTextField8.setForeground(Color.red);
/* 1267 */     this.jTextField8.setText("26/04/2010");
/*      */     
/* 1269 */     this.jButton20.setMnemonic('C');
/* 1270 */     this.jButton20.setText("Cerrar");
/* 1271 */     this.jButton20.setToolTipText("Cerrar (Alt+C)");
/* 1272 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1274 */             TarjetasDeudoras.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1278 */     this.jLabel74.setFont(new Font("Tahoma", 3, 11));
/* 1279 */     this.jLabel74.setForeground(new Color(15, 87, 51));
/* 1280 */     this.jLabel74.setHorizontalAlignment(4);
/* 1281 */     this.jLabel74.setText("A cargo de ");
/*      */     
/* 1283 */     this.jLabel7.setFont(new Font("Tahoma", 1, 11));
/* 1284 */     this.jLabel7.setText("jLabel7");
/*      */     
/* 1286 */     this.jPanel2.setBackground(new Color(146, 193, 134));
/* 1287 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder("Concepto del Cargo"));
/*      */     
/* 1289 */     this.jRadioButton6.setSelected(true);
/* 1290 */     this.jRadioButton6.setText("Cargo Directo");
/* 1291 */     this.jRadioButton6.setEnabled(false);
/*      */     
/* 1293 */     this.jRadioButton7.setText("Cargo a T.D.");
/* 1294 */     this.jRadioButton7.setEnabled(false);
/*      */     
/* 1296 */     this.jRadioButton3.setSelected(true);
/* 1297 */     this.jRadioButton3.setText("INFONAVIT (cargo Directo)");
/* 1298 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1300 */             TarjetasDeudoras.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1304 */     this.jRadioButton4.setText("Otro");
/* 1305 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1307 */             TarjetasDeudoras.this.jRadioButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1311 */     this.jTextField9.setEnabled(false);
/*      */     
/* 1313 */     this.jLabel9.setFont(new Font("Tahoma", 3, 11));
/* 1314 */     this.jLabel9.setForeground(new Color(15, 87, 51));
/* 1315 */     this.jLabel9.setText("De");
/*      */     
/* 1317 */     this.jDateChooser2.setDate(this.fechaActual);
/* 1318 */     this.jDateChooser2.setDateFormatString("dd/MM/yyyy");
/* 1319 */     this.jDateChooser2.setIcon(this.icon);
/*      */     
/* 1321 */     this.jLabel10.setFont(new Font("Tahoma", 3, 11));
/* 1322 */     this.jLabel10.setForeground(new Color(15, 87, 51));
/* 1323 */     this.jLabel10.setHorizontalAlignment(0);
/* 1324 */     this.jLabel10.setText("Al");
/*      */     
/* 1326 */     this.jDateChooser3.setDate(this.fechaActual);
/* 1327 */     this.jDateChooser3.setDateFormatString("dd/MM/yyyy");
/* 1328 */     this.jDateChooser3.setIcon(this.icon);
/*      */     
/* 1330 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1331 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1332 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1333 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1334 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1335 */           .addContainerGap()
/* 1336 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1337 */             .addComponent(this.jRadioButton4, GroupLayout.Alignment.LEADING, -1, 275, 32767)
/* 1338 */             .addComponent(this.jRadioButton3, -1, 275, 32767))
/* 1339 */           .addGap(19, 19, 19))
/* 1340 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1341 */           .addGap(27, 27, 27)
/* 1342 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1343 */             .addGroup(jPanel2Layout.createSequentialGroup()
/* 1344 */               .addComponent(this.jRadioButton6, -2, 116, -2)
/* 1345 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, 32767)
/* 1346 */               .addComponent(this.jRadioButton7, -2, 116, -2))
/* 1347 */             .addComponent(this.jTextField9, -1, 263, 32767))
/* 1348 */           .addContainerGap())
/* 1349 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 1350 */           .addContainerGap(22, 32767)
/* 1351 */           .addComponent(this.jLabel9, -2, 23, -2)
/* 1352 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1353 */           .addComponent((Component)this.jDateChooser2, -2, 102, -2)
/* 1354 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1355 */           .addComponent(this.jLabel10, -2, 17, -2)
/* 1356 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1357 */           .addComponent((Component)this.jDateChooser3, -2, 102, -2)
/* 1358 */           .addContainerGap()));
/*      */     
/* 1360 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1361 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1362 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1363 */           .addComponent(this.jRadioButton3)
/* 1364 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1365 */           .addComponent(this.jRadioButton4)
/* 1366 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1367 */           .addComponent(this.jTextField9, -2, -1, -2)
/* 1368 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1369 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1370 */             .addComponent(this.jRadioButton6)
/* 1371 */             .addComponent(this.jRadioButton7))
/* 1372 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1373 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1374 */             .addComponent((Component)this.jDateChooser3, -1, -1, 32767)
/* 1375 */             .addComponent(this.jLabel10, -1, -1, 32767)
/* 1376 */             .addComponent(this.jLabel9, -1, -1, 32767)
/* 1377 */             .addComponent((Component)this.jDateChooser2, -2, -1, -2))));
/*      */ 
/*      */     
/* 1380 */     this.jLabel75.setFont(new Font("Tahoma", 3, 11));
/* 1381 */     this.jLabel75.setForeground(new Color(15, 87, 51));
/* 1382 */     this.jLabel75.setText("No. ó Referencia ");
/*      */     
/* 1384 */     this.jLabel76.setFont(new Font("Tahoma", 3, 11));
/* 1385 */     this.jLabel76.setForeground(new Color(15, 87, 51));
/* 1386 */     this.jLabel76.setHorizontalAlignment(0);
/* 1387 */     this.jLabel76.setText("Cantidad ");
/*      */     
/* 1389 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/* 1390 */     this.jFormattedTextField1.setText("$0.0");
/* 1391 */     this.jFormattedTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1393 */             TarjetasDeudoras.this.jFormattedTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1397 */     this.jLabel77.setFont(new Font("Tahoma", 3, 11));
/* 1398 */     this.jLabel77.setForeground(new Color(15, 87, 51));
/* 1399 */     this.jLabel77.setText("Observaciones");
/*      */     
/* 1401 */     this.jTextArea2.setColumns(20);
/* 1402 */     this.jTextArea2.setFont(new Font("Tahoma", 0, 11));
/* 1403 */     this.jTextArea2.setLineWrap(true);
/* 1404 */     this.jTextArea2.setRows(5);
/* 1405 */     this.jScrollPane6.setViewportView(this.jTextArea2);
/*      */     
/* 1407 */     this.jButton21.setMnemonic('I');
/* 1408 */     this.jButton21.setText("Imprimir");
/* 1409 */     this.jButton21.setToolTipText("Imprimir (Alt+I)");
/* 1410 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1412 */             TarjetasDeudoras.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1416 */     this.jLabel80.setFont(new Font("Tahoma", 3, 11));
/* 1417 */     this.jLabel80.setForeground(new Color(15, 87, 51));
/* 1418 */     this.jLabel80.setHorizontalAlignment(4);
/* 1419 */     this.jLabel80.setText("MOV ");
/*      */     
/* 1421 */     this.jTextField10.setEditable(false);
/* 1422 */     this.jTextField10.setFont(new Font("Tahoma", 1, 11));
/* 1423 */     this.jTextField10.setForeground(Color.red);
/* 1424 */     this.jTextField10.setText("PR-00001");
/*      */     
/* 1426 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1427 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1428 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1429 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1430 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 1431 */           .addContainerGap()
/* 1432 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1433 */             .addComponent(this.jScrollPane6, GroupLayout.Alignment.LEADING, -1, 312, 32767)
/* 1434 */             .addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1435 */             .addComponent(this.jLabel71, GroupLayout.Alignment.LEADING, -1, 312, 32767)
/* 1436 */             .addComponent(this.jLabel74, GroupLayout.Alignment.LEADING, -2, 70, -2)
/* 1437 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
/* 1438 */               .addGap(31, 31, 31)
/* 1439 */               .addComponent(this.jLabel7, -2, 271, -2))
/* 1440 */             .addComponent(this.jSeparator6, GroupLayout.Alignment.LEADING, -1, 312, 32767)
/* 1441 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1442 */               .addComponent(this.jButton21, -2, 81, -2)
/* 1443 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1444 */               .addComponent(this.jButton20, -2, 81, -2))
/* 1445 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1446 */               .addComponent(this.jLabel80, -2, 42, -2)
/* 1447 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1448 */               .addComponent(this.jTextField10, -2, 93, -2)
/* 1449 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, 32767)
/* 1450 */               .addComponent(this.jLabel73, -2, 42, -2)
/* 1451 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1452 */               .addComponent(this.jTextField8, -2, 82, -2))
/* 1453 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
/* 1454 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1455 */                 .addComponent(this.jTextField7, -2, 190, -2)
/* 1456 */                 .addComponent(this.jLabel75, -2, 158, -2))
/* 1457 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, 32767)
/* 1458 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1459 */                 .addComponent(this.jFormattedTextField1)
/* 1460 */                 .addComponent(this.jLabel76, -2, 105, -2)))
/* 1461 */             .addComponent(this.jLabel77, GroupLayout.Alignment.LEADING, -2, 96, -2))
/* 1462 */           .addContainerGap()));
/*      */     
/* 1464 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1465 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1466 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1467 */           .addComponent(this.jLabel71)
/* 1468 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1469 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1470 */             .addComponent(this.jLabel73)
/* 1471 */             .addComponent(this.jTextField8, -2, -1, -2)
/* 1472 */             .addComponent(this.jLabel80)
/* 1473 */             .addComponent(this.jTextField10, -2, -1, -2))
/* 1474 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1475 */           .addComponent(this.jSeparator6, -2, 10, -2)
/* 1476 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1477 */           .addComponent(this.jLabel74)
/* 1478 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1479 */           .addComponent(this.jLabel7)
/* 1480 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1481 */           .addComponent(this.jPanel2, -2, -1, -2)
/* 1482 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1483 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1484 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1485 */               .addComponent(this.jLabel75)
/* 1486 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1487 */               .addComponent(this.jTextField7, -2, -1, -2))
/* 1488 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1489 */               .addComponent(this.jLabel76)
/* 1490 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1491 */               .addComponent(this.jFormattedTextField1, -2, -1, -2)))
/* 1492 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1493 */           .addComponent(this.jLabel77)
/* 1494 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1495 */           .addComponent(this.jScrollPane6, -1, 89, 32767)
/* 1496 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1497 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1498 */             .addComponent(this.jButton20)
/* 1499 */             .addComponent(this.jButton21))
/* 1500 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1503 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1504 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1505 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1507 */         .addComponent(this.jPanel12, -2, -1, -2));
/*      */     
/* 1509 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1510 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1511 */         .addComponent(this.jPanel12, -2, -1, -2));
/*      */ 
/*      */     
/* 1514 */     this.jDialog6.setTitle("Nuevo Abono");
/* 1515 */     this.jDialog6.setModal(true);
/*      */     
/* 1517 */     this.jPanel13.setBackground(new Color(146, 193, 134));
/*      */     
/* 1519 */     this.jLabel72.setFont(new Font("Tahoma", 1, 14));
/* 1520 */     this.jLabel72.setForeground(Color.blue);
/* 1521 */     this.jLabel72.setHorizontalAlignment(0);
/* 1522 */     this.jLabel72.setText("ABONO");
/*      */     
/* 1524 */     this.jLabel81.setFont(new Font("Tahoma", 3, 11));
/* 1525 */     this.jLabel81.setForeground(new Color(15, 87, 51));
/* 1526 */     this.jLabel81.setHorizontalAlignment(4);
/* 1527 */     this.jLabel81.setText("Fecha ");
/*      */     
/* 1529 */     this.jTextField11.setEditable(false);
/* 1530 */     this.jTextField11.setFont(new Font("Tahoma", 1, 11));
/* 1531 */     this.jTextField11.setForeground(Color.red);
/* 1532 */     this.jTextField11.setText("26/04/2010");
/*      */     
/* 1534 */     this.jButton22.setMnemonic('C');
/* 1535 */     this.jButton22.setText("Cerrar");
/* 1536 */     this.jButton22.setToolTipText("Cerrar (Alt+C)");
/* 1537 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1539 */             TarjetasDeudoras.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1543 */     this.jLabel82.setFont(new Font("Tahoma", 3, 11));
/* 1544 */     this.jLabel82.setForeground(new Color(15, 87, 51));
/* 1545 */     this.jLabel82.setText("Abono a ");
/*      */     
/* 1547 */     this.jLabel11.setFont(new Font("Tahoma", 1, 11));
/* 1548 */     this.jLabel11.setText("jLabel7");
/*      */     
/* 1550 */     this.jLabel83.setFont(new Font("Tahoma", 3, 11));
/* 1551 */     this.jLabel83.setForeground(new Color(15, 87, 51));
/* 1552 */     this.jLabel83.setText("No. ó Referencia ");
/*      */     
/* 1554 */     this.jLabel84.setFont(new Font("Tahoma", 3, 11));
/* 1555 */     this.jLabel84.setForeground(new Color(15, 87, 51));
/* 1556 */     this.jLabel84.setHorizontalAlignment(0);
/* 1557 */     this.jLabel84.setText("Cantidad ");
/*      */     
/* 1559 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/* 1560 */     this.jFormattedTextField3.setText("$0.0");
/* 1561 */     this.jFormattedTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1563 */             TarjetasDeudoras.this.jFormattedTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1567 */     this.jLabel85.setFont(new Font("Tahoma", 3, 11));
/* 1568 */     this.jLabel85.setForeground(new Color(15, 87, 51));
/* 1569 */     this.jLabel85.setText("Observaciones");
/*      */     
/* 1571 */     this.jTextArea3.setColumns(20);
/* 1572 */     this.jTextArea3.setFont(new Font("Tahoma", 0, 11));
/* 1573 */     this.jTextArea3.setLineWrap(true);
/* 1574 */     this.jTextArea3.setRows(5);
/* 1575 */     this.jScrollPane7.setViewportView(this.jTextArea3);
/*      */     
/* 1577 */     this.jButton23.setMnemonic('G');
/* 1578 */     this.jButton23.setText("Guardar");
/* 1579 */     this.jButton23.setToolTipText("Guardar (Alt+G)");
/* 1580 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1582 */             TarjetasDeudoras.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1586 */     this.jLabel86.setFont(new Font("Tahoma", 3, 11));
/* 1587 */     this.jLabel86.setForeground(new Color(15, 87, 51));
/* 1588 */     this.jLabel86.setHorizontalAlignment(4);
/* 1589 */     this.jLabel86.setText("MOV ");
/*      */     
/* 1591 */     this.jTextField14.setEditable(false);
/* 1592 */     this.jTextField14.setFont(new Font("Tahoma", 1, 11));
/* 1593 */     this.jTextField14.setForeground(Color.red);
/* 1594 */     this.jTextField14.setText("PR-00001");
/*      */     
/* 1596 */     this.jPanel3.setBackground(new Color(146, 193, 134));
/* 1597 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder("Concepto del Vale"));
/*      */     
/* 1599 */     this.jRadioButton5.setSelected(true);
/* 1600 */     this.jRadioButton5.setText("Abono a Gastos por Comprobar");
/* 1601 */     this.jRadioButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1603 */             TarjetasDeudoras.this.jRadioButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1607 */     this.jRadioButton8.setText("Abono a Préstamo Personal");
/* 1608 */     this.jRadioButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1610 */             TarjetasDeudoras.this.jRadioButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1614 */     this.jRadioButton9.setText("Otro Concepto");
/* 1615 */     this.jRadioButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1617 */             TarjetasDeudoras.this.jRadioButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1621 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1622 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1623 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 1624 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1625 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1626 */           .addContainerGap()
/* 1627 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1628 */             .addComponent(this.jRadioButton9, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1629 */             .addComponent(this.jRadioButton8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1630 */             .addComponent(this.jRadioButton5, GroupLayout.Alignment.LEADING, -1, 275, 32767)
/* 1631 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
/* 1632 */               .addGap(21, 21, 21)
/* 1633 */               .addComponent(this.jTextField12)))
/* 1634 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1636 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 1637 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1638 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1639 */           .addComponent(this.jRadioButton5)
/* 1640 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1641 */           .addComponent(this.jRadioButton8)
/* 1642 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1643 */           .addComponent(this.jRadioButton9)
/* 1644 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1645 */           .addComponent(this.jTextField12, -2, -1, -2)));
/*      */ 
/*      */     
/* 1648 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 1649 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1650 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 1651 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1652 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1653 */           .addContainerGap()
/* 1654 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1655 */             .addComponent(this.jPanel3, -2, -1, -2)
/* 1656 */             .addComponent(this.jLabel72, -1, -1, 32767)
/* 1657 */             .addComponent(this.jLabel82, -2, 70, -2)
/* 1658 */             .addGroup(jPanel13Layout.createSequentialGroup()
/* 1659 */               .addGap(31, 31, 31)
/* 1660 */               .addComponent(this.jLabel11, -2, 271, -2))
/* 1661 */             .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1662 */               .addComponent(this.jSeparator7, GroupLayout.Alignment.LEADING)
/* 1663 */               .addGroup(GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
/* 1664 */                 .addComponent(this.jLabel86, -2, 42, -2)
/* 1665 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1666 */                 .addComponent(this.jTextField14, -2, 93, -2)
/* 1667 */                 .addGap(36, 36, 36)
/* 1668 */                 .addComponent(this.jLabel81, -2, 42, -2)
/* 1669 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1670 */                 .addComponent(this.jTextField11, -2, 82, -2)))
/* 1671 */             .addComponent(this.jScrollPane7)
/* 1672 */             .addGroup(jPanel13Layout.createSequentialGroup()
/* 1673 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1674 */                 .addComponent(this.jTextField13, -2, 190, -2)
/* 1675 */                 .addComponent(this.jLabel83, -2, 158, -2))
/* 1676 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1677 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1678 */                 .addComponent(this.jFormattedTextField3)
/* 1679 */                 .addComponent(this.jLabel84, -2, 105, -2)))
/* 1680 */             .addComponent(this.jLabel85, -2, 96, -2)
/* 1681 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/* 1682 */               .addComponent(this.jButton23, -2, 81, -2)
/* 1683 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1684 */               .addComponent(this.jButton22, -2, 81, -2)))
/* 1685 */           .addContainerGap()));
/*      */     
/* 1687 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 1688 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1689 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1690 */           .addComponent(this.jLabel72)
/* 1691 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1692 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1693 */             .addComponent(this.jLabel86)
/* 1694 */             .addComponent(this.jTextField14, -2, -1, -2)
/* 1695 */             .addComponent(this.jLabel81)
/* 1696 */             .addComponent(this.jTextField11, -2, -1, -2))
/* 1697 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1698 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 1699 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1700 */           .addComponent(this.jLabel82)
/* 1701 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1702 */           .addComponent(this.jLabel11)
/* 1703 */           .addGap(4, 4, 4)
/* 1704 */           .addComponent(this.jPanel3, -2, -1, -2)
/* 1705 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1706 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1707 */             .addGroup(jPanel13Layout.createSequentialGroup()
/* 1708 */               .addComponent(this.jLabel83)
/* 1709 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1710 */               .addComponent(this.jTextField13, -2, -1, -2))
/* 1711 */             .addGroup(jPanel13Layout.createSequentialGroup()
/* 1712 */               .addComponent(this.jLabel84)
/* 1713 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1714 */               .addComponent(this.jFormattedTextField3, -2, -1, -2)))
/* 1715 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1716 */           .addComponent(this.jLabel85)
/* 1717 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1718 */           .addComponent(this.jScrollPane7, -1, 109, 32767)
/* 1719 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1720 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1721 */             .addComponent(this.jButton22)
/* 1722 */             .addComponent(this.jButton23))
/* 1723 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1726 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1727 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1728 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1729 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1730 */         .addComponent(this.jPanel13, -2, -1, -2));
/*      */     
/* 1732 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1733 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1734 */         .addComponent(this.jPanel13, -2, -1, -2));
/*      */ 
/*      */     
/* 1737 */     this.jDialog7.setTitle("Cancelar Vale");
/* 1738 */     this.jDialog7.setModal(true);
/*      */     
/* 1740 */     this.jPanel14.setBackground(new Color(146, 193, 134));
/*      */     
/* 1742 */     this.jLabel87.setFont(new Font("Tahoma", 1, 14));
/* 1743 */     this.jLabel87.setForeground(new Color(0, 102, 102));
/* 1744 */     this.jLabel87.setHorizontalAlignment(0);
/* 1745 */     this.jLabel87.setText("Motivo de la Cancelación");
/*      */     
/* 1747 */     this.jLabel88.setFont(new Font("Tahoma", 3, 11));
/* 1748 */     this.jLabel88.setForeground(new Color(15, 87, 51));
/* 1749 */     this.jLabel88.setHorizontalAlignment(4);
/* 1750 */     this.jLabel88.setText("Motivo");
/*      */     
/* 1752 */     this.jButton18.setMnemonic('A');
/* 1753 */     this.jButton18.setText("Cancelar Movimiento");
/* 1754 */     this.jButton18.setToolTipText("Cancelar Movimiento (Alt+A)");
/* 1755 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1757 */             TarjetasDeudoras.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1761 */     this.jButton24.setMnemonic('C');
/* 1762 */     this.jButton24.setText("Cerrar");
/* 1763 */     this.jButton24.setToolTipText("Cerrar (Alt+C)");
/* 1764 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1766 */             TarjetasDeudoras.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1770 */     this.jTextArea4.setColumns(20);
/* 1771 */     this.jTextArea4.setLineWrap(true);
/* 1772 */     this.jTextArea4.setRows(5);
/* 1773 */     this.jScrollPane8.setViewportView(this.jTextArea4);
/*      */     
/* 1775 */     this.jLabel12.setText("Ingresa el motivo por el cual deseas cancelar el movimiento");
/*      */     
/* 1777 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1778 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1779 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1780 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1781 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1782 */           .addContainerGap()
/* 1783 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1784 */             .addComponent(this.jLabel12, -1, -1, 32767)
/* 1785 */             .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1786 */               .addGroup(jPanel14Layout.createSequentialGroup()
/* 1787 */                 .addComponent(this.jButton18)
/* 1788 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1789 */                 .addComponent(this.jButton24, -2, 84, -2))
/* 1790 */               .addGroup(jPanel14Layout.createSequentialGroup()
/* 1791 */                 .addComponent(this.jLabel88, -2, 43, -2)
/* 1792 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1793 */                 .addComponent(this.jScrollPane8, -2, 302, -2)))
/* 1794 */             .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1795 */               .addComponent(this.jLabel87, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1796 */               .addComponent(this.jSeparator8, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/* 1797 */           .addContainerGap()));
/*      */     
/* 1799 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1800 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1801 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1802 */           .addComponent(this.jLabel87)
/* 1803 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1804 */           .addComponent(this.jSeparator8, -2, 10, -2)
/* 1805 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1806 */           .addComponent(this.jLabel12)
/* 1807 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1808 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1809 */             .addComponent(this.jLabel88)
/* 1810 */             .addComponent(this.jScrollPane8, -2, 96, -2))
/* 1811 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1812 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1813 */             .addComponent(this.jButton24)
/* 1814 */             .addComponent(this.jButton18))
/* 1815 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1818 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 1819 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 1820 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 1821 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1822 */         .addComponent(this.jPanel14, -2, -1, -2));
/*      */     
/* 1824 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 1825 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1826 */         .addComponent(this.jPanel14, -2, -1, -2));
/*      */ 
/*      */     
/* 1829 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*      */     
/* 1831 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/*      */     
/* 1833 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1834 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1835 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1836 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1837 */         .addGap(0, 562, 32767));
/*      */     
/* 1839 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1840 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1841 */         .addGap(0, 41, 32767));
/*      */ 
/*      */     
/* 1844 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1845 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1846 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1847 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1848 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 1849 */           .addContainerGap()
/* 1850 */           .addComponent(this.jPanel7, -2, -1, -2)
/* 1851 */           .addContainerGap(337, 32767)));
/*      */     
/* 1853 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1854 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1855 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1856 */           .addGap(335, 335, 335)
/* 1857 */           .addComponent(this.jPanel7, 0, -1, 32767)
/* 1858 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1861 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/* 1862 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1864 */     this.jLabel3.setFont(new Font("Tahoma", 1, 18));
/* 1865 */     this.jLabel3.setForeground(new Color(10, 126, 68));
/* 1866 */     this.jLabel3.setHorizontalAlignment(0);
/* 1867 */     this.jLabel3.setText("ORGANIZAR TARJETAS DEUDOR");
/*      */     
/* 1869 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/* 1870 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo", "Fecha de Creación", "Autorizó", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1878 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1880 */             TarjetasDeudoras.this.jTable1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1883 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 1884 */     if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/* 1885 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(60);
/* 1886 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
/* 1887 */       this.jTable1.getColumnModel().getColumn(2).setMinWidth(120);
/* 1888 */       this.jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
/* 1889 */       this.jTable1.getColumnModel().getColumn(3).setMinWidth(180);
/* 1890 */       this.jTable1.getColumnModel().getColumn(3).setMaxWidth(180);
/* 1891 */       this.jTable1.getColumnModel().getColumn(4).setMinWidth(100);
/* 1892 */       this.jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
/*      */     } 
/*      */     
/* 1895 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1897 */             TarjetasDeudoras.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1900 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1902 */             TarjetasDeudoras.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1906 */     this.jButton1.setMnemonic('C');
/* 1907 */     this.jButton1.setText("Congelar");
/* 1908 */     this.jButton1.setToolTipText("Congelar Tarjeta(Alt+C)");
/* 1909 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1911 */             TarjetasDeudoras.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1915 */     this.jButton2.setMnemonic('N');
/* 1916 */     this.jButton2.setText("Nueva");
/* 1917 */     this.jButton2.setToolTipText("Nueva Tarjeta (Alt+N)");
/* 1918 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1920 */             TarjetasDeudoras.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1924 */     this.jLabel15.setFont(new Font("Tahoma", 3, 12));
/* 1925 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 1926 */     this.jLabel15.setText("Búsqueda por nombre");
/*      */     
/* 1928 */     this.jButton3.setMnemonic('A');
/* 1929 */     this.jButton3.setText("Activar");
/* 1930 */     this.jButton3.setToolTipText("Activar Tarjeta (Alt+A)");
/* 1931 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1933 */             TarjetasDeudoras.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1937 */     this.jButton10.setMnemonic('N');
/* 1938 */     this.jButton10.setText("Ver Detalle");
/* 1939 */     this.jButton10.setToolTipText("Nueva Tarjeta (Alt+N)");
/* 1940 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1942 */             TarjetasDeudoras.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1946 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1947 */     this.jLabel48.setForeground(Color.red);
/* 1948 */     this.jLabel48.setHorizontalAlignment(0);
/* 1949 */     this.jLabel48.setText("t");
/* 1950 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1952 */     this.jLabel16.setFont(new Font("Tahoma", 3, 12));
/* 1953 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/* 1954 */     this.jLabel16.setHorizontalAlignment(4);
/* 1955 */     this.jLabel16.setText("Búsqueda por Estatus ");
/*      */     
/* 1957 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 1958 */     this.jComboBox2.setFont(new Font("Tahoma", 1, 11));
/* 1959 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "<ACTIVA>", "<BAJA>", "<CONGELADA>", "<TODOS>" }));
/* 1960 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1962 */             TarjetasDeudoras.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1966 */     this.jButton9.setMnemonic('N');
/* 1967 */     this.jButton9.setText("Guardar Reporte");
/* 1968 */     this.jButton9.setToolTipText("Nueva Tarjeta (Alt+N)");
/* 1969 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1971 */             TarjetasDeudoras.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1975 */     this.jLabel19.setFont(new Font("Tahoma", 3, 12));
/* 1976 */     this.jLabel19.setForeground(new Color(15, 87, 51));
/* 1977 */     this.jLabel19.setHorizontalAlignment(4);
/* 1978 */     this.jLabel19.setText("Búsqueda por Tipo ");
/*      */     
/* 1980 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 1981 */     this.jComboBox3.setFont(new Font("Tahoma", 1, 11));
/* 1982 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "OPERADORES", "EMPLEADOS" }));
/* 1983 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1985 */             TarjetasDeudoras.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1989 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1990 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1991 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1992 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1993 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1994 */           .addContainerGap()
/* 1995 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1996 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1997 */               .addComponent(this.jScrollPane1, -1, 1049, 32767)
/* 1998 */               .addContainerGap())
/* 1999 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 2000 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2001 */                 .addComponent(this.jSeparator1, GroupLayout.Alignment.TRAILING, -1, 1049, 32767)
/* 2002 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 2003 */                   .addComponent(this.jLabel48, -2, 171, -2)
/* 2004 */                   .addGap(58, 58, 58)
/* 2005 */                   .addComponent(this.jButton9, -2, 129, -2)
/* 2006 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2007 */                   .addComponent(this.jButton10, -2, 127, -2)
/* 2008 */                   .addGap(95, 95, 95)
/* 2009 */                   .addComponent(this.jButton2, -2, 119, -2)
/* 2010 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 116, 32767)
/* 2011 */                   .addComponent(this.jButton3, -2, 118, -2)
/* 2012 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2013 */                   .addComponent(this.jButton1, -2, 126, -2))
/* 2014 */                 .addComponent(this.jLabel3, -1, 1049, 32767))
/* 2015 */               .addContainerGap())
/* 2016 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 2017 */               .addComponent(this.jLabel15, -2, 149, -2)
/* 2018 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2019 */               .addComponent(this.jTextField1, -2, 187, -2)
/* 2020 */               .addGap(64, 64, 64)
/* 2021 */               .addComponent(this.jLabel19, -2, 149, -2)
/* 2022 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2023 */               .addComponent(this.jComboBox3, -2, 148, -2)
/* 2024 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2025 */               .addComponent(this.jLabel16, -2, 149, -2)
/* 2026 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2027 */               .addComponent(this.jComboBox2, -2, 118, -2)
/* 2028 */               .addGap(41, 41, 41)))));
/*      */     
/* 2030 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 2031 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2032 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 2033 */           .addContainerGap()
/* 2034 */           .addComponent(this.jLabel3)
/* 2035 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2036 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 2037 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2038 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2039 */             .addComponent(this.jLabel15)
/* 2040 */             .addComponent(this.jTextField1, -2, -1, -2)
/* 2041 */             .addComponent(this.jLabel16)
/* 2042 */             .addComponent(this.jComboBox2, -2, -1, -2)
/* 2043 */             .addComponent(this.jLabel19)
/* 2044 */             .addComponent(this.jComboBox3, -2, -1, -2))
/* 2045 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2046 */           .addComponent(this.jScrollPane1, -1, 187, 32767)
/* 2047 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2048 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2049 */             .addComponent(this.jButton1)
/* 2050 */             .addComponent(this.jLabel48)
/* 2051 */             .addComponent(this.jButton9)
/* 2052 */             .addComponent(this.jButton10)
/* 2053 */             .addComponent(this.jButton3)
/* 2054 */             .addComponent(this.jButton2))
/* 2055 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2058 */     GroupLayout layout = new GroupLayout(this);
/* 2059 */     setLayout(layout);
/* 2060 */     layout.setHorizontalGroup(layout
/* 2061 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2062 */         .addGap(0, 1093, 32767)
/* 2063 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2064 */           .addGroup(layout.createSequentialGroup()
/* 2065 */             .addGap(10, 10, 10)
/* 2066 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 2067 */             .addGap(10, 10, 10))));
/*      */     
/* 2069 */     layout.setVerticalGroup(layout
/* 2070 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2071 */         .addGap(0, 332, 32767)
/* 2072 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2073 */           .addGroup(layout.createSequentialGroup()
/* 2074 */             .addGap(10, 10, 10)
/* 2075 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 2076 */             .addGap(10, 10, 10))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 2081 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2085 */     verTarjeta();
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 2089 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 2093 */     if (this.entraDepa && 
/* 2094 */       this.jComboBox1.getSelectedIndex() > 0) {
/* 2095 */       System.out.println("entra");
/* 2096 */       consultar2();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 2102 */     if (this.jTable5.getRowCount() == 0) {
/* 2103 */       JOptionPane.showMessageDialog(this.jDialog2, "No existe ninguna persona para crear nuevas Tarjetas", "No hay Personas", 0, this.ERROR);
/*      */     } else {
/* 2105 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas crear las nuevas cuentas de tarjeta deudor?", "Agregar Tarjetas", 0, 3, this.PREG);
/* 2106 */       if (res == 0) {
/* 2107 */         for (int i = 0; i < this.jTable5.getRowCount(); i++) {
/* 2108 */           String clave = String.valueOf(this.jTable5.getValueAt(i, 0));
/* 2109 */           String nombre = String.valueOf(this.jTable5.getValueAt(i, 1));
/* 2110 */           String tipo = "OPERADOR";
/* 2111 */           if (!this.jRadioButton1.isSelected()) {
/* 2112 */             this.encontrado = this.con.consultar("clave_emp", "tarjeta_deudor", "where clave_emp = " + clave);
/* 2113 */             if (this.encontrado) {
/* 2114 */               JOptionPane.showMessageDialog(this.jDialog2, "No se pudo insertar el siguiente empleado porque ya tiene una tarjeta asignada\n<html><b><font color = red>" + nombre + "</font></b></html>", "Nombre Ya Asignado", 0, this.ERROR);
/* 2115 */               consultar();
/*      */               return;
/*      */             } 
/* 2118 */             tipo = "EMPLEADO";
/* 2119 */             this.con.consultar("departamentos.nombre", "empleados,departamentos", "where empleados.clave_depa = departamentos.clave_depa and empleados.clave_emp = " + clave);
/* 2120 */             this.con.inserSinMsj("insert into tarjeta_deudor(f_creacion,tipo,clave_emp,num_ope,nombrecompleto,usuario_creo,estatus,SALDO) values(now(),'" + tipo + "-" + this.con.Campo + "'," + clave + ",0,'" + nombre + "','" + this.NOMBRE + "','<ACTIVA>','$0.00')");
/*      */           }
/*      */           else {
/*      */             
/* 2124 */             this.encontrado = this.con.consultar("num_ope", "tarjeta_deudor", "where num_ope = " + clave);
/* 2125 */             if (this.encontrado) {
/* 2126 */               JOptionPane.showMessageDialog(this.jDialog2, "No se pudo insertar el siguiente operador porque ya tiene una tarjeta asignada\n<html><b><font color = red>" + nombre + "</font></b></html>", "Nombre Ya Asignado", 0, this.ERROR);
/*      */               return;
/*      */             } 
/* 2129 */             this.con.inserSinMsj("insert into tarjeta_deudor(f_creacion,tipo,clave_emp,num_ope,nombrecompleto,usuario_creo,estatus,saldo) values(now(),'" + tipo + "',0," + clave + ",'" + nombre + "','" + this.NOMBRE + "','<ACTIVA>','$0.00')");
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 2134 */         consultar();
/* 2135 */         this.jDialog2.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 2141 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTable4MouseClicked(MouseEvent evt) {
/* 2145 */     if (evt.getClickCount() == 2) {
/* 2146 */       String valor = String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0));
/* 2147 */       for (int i = 0; i < this.jTable5.getRowCount(); i++) {
/* 2148 */         String valor2 = String.valueOf(this.jTable5.getValueAt(i, 0));
/* 2149 */         if (valor2.equals(valor)) {
/* 2150 */           JOptionPane.showMessageDialog(this.jDialog2, "No puedes agregar a la siguiente persona porque ya se encuentra en la tabla de la derecha\n<html><b><font color = blue>" + String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 1)) + "</font><b></html>", "Persona Duplicada", 0, this.ADVER);
/*      */           return;
/*      */         } 
/*      */       } 
/* 2154 */       Object[] reg = { this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0), this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 1) };
/* 2155 */       this.modelo.addRow(reg);
/*      */     } else {
/* 2157 */       this.jButton11.setEnabled(true);
/* 2158 */       this.jButton12.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2163 */     String valor = String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0));
/* 2164 */     for (int i = 0; i < this.jTable5.getRowCount(); i++) {
/* 2165 */       String valor2 = String.valueOf(this.jTable5.getValueAt(i, 0));
/* 2166 */       if (valor2.equals(valor)) {
/* 2167 */         JOptionPane.showMessageDialog(this.jDialog2, "No puedes agregar a la siguiente persona porque ya se encuentra en la tabla de la derecha\n<html><b><font color = blue>" + String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 1)) + "</font><b></html>", "Persona Duplicada", 0, this.ADVER);
/*      */         return;
/*      */       } 
/*      */     } 
/* 2171 */     Object[] reg = { this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0), this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 1) };
/* 2172 */     this.modelo.addRow(reg);
/*      */   }
/*      */   
/*      */   private void jTable5MouseClicked(MouseEvent evt) {
/* 2176 */     if (evt.getClickCount() == 2) {
/* 2177 */       if (this.jTable5.getRowCount() > 0) {
/* 2178 */         this.modelo.removeRow(this.jTable5.getSelectedRow());
/*      */       }
/*      */     } else {
/* 2181 */       this.jButton13.setEnabled(true);
/* 2182 */       this.jButton14.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 2187 */     if (this.jTable5.getRowCount() > 0) {
/* 2188 */       this.modelo.removeRow(this.jTable5.getSelectedRow());
/*      */     } else {
/* 2190 */       JOptionPane.showMessageDialog(this.jDialog2, "No existe ningún registro para quitarlo", "No hay Registros", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 2195 */     if (this.jTable5.getRowCount() > 0) {
/* 2196 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas quitar todas las cuentas a la tabla de la derecha?", "Quitar Todos", 0, 3, this.PREG);
/* 2197 */       if (res == 0) {
/* 2198 */         this.modelo = new DefaultTableModel();
/* 2199 */         this.jTable5.setModel(this.modelo);
/* 2200 */         this.modelo.addColumn("Clave");
/* 2201 */         this.modelo.addColumn("Nombre Completo");
/* 2202 */         this.jTable5.setShowVerticalLines(false);
/* 2203 */         this.jTable5.setSelectionMode(0);
/* 2204 */         this.jTable5.setAutoCreateRowSorter(true);
/* 2205 */         this.jTable5.getTableHeader().setReorderingAllowed(false);
/* 2206 */         this.jTable5.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 2207 */         this.jTable5.getColumnModel().getColumn(0).setMaxWidth(60);
/* 2208 */         this.jTable5.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 2209 */         this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/*      */       } 
/*      */     } else {
/* 2212 */       JOptionPane.showMessageDialog(this.jDialog2, "No existe ningún registro para quitarlo", "No hay Registros", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2217 */     int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas mover todas las cuentas a la tabla de la derecha?", "Mover Todos", 0, 3, this.PREG);
/* 2218 */     if (res == 0) {
/* 2219 */       this.modelo = new DefaultTableModel();
/* 2220 */       this.jTable5.setModel(this.modelo);
/* 2221 */       this.modelo.addColumn("Clave");
/* 2222 */       this.modelo.addColumn("Nombre Completo");
/* 2223 */       this.jTable5.setShowVerticalLines(false);
/* 2224 */       this.jTable5.setSelectionMode(0);
/* 2225 */       this.jTable5.setAutoCreateRowSorter(true);
/* 2226 */       this.jTable5.getTableHeader().setReorderingAllowed(false);
/* 2227 */       this.jTable5.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 2228 */       this.jTable5.getColumnModel().getColumn(0).setMaxWidth(60);
/* 2229 */       this.jTable5.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 2230 */       this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 2231 */       for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 2232 */         Object[] reg = { this.jTable4.getValueAt(i, 0), this.jTable4.getValueAt(i, 1) };
/* 2233 */         this.modelo.addRow(reg);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 2239 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 2243 */     consultar();
/*      */   }
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 2247 */     this.jComboBox1.setEnabled(false);
/* 2248 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 2252 */     this.jComboBox1.setEnabled(true);
/* 2253 */     this.jComboBox1.setSelectedIndex(0);
/*      */   }
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {
/* 2257 */     if (!this.jRadioButton1.isSelected()) {
/* 2258 */       this.jComboBox1.setSelectedIndex(0);
/* 2259 */       this.jComboBox1.setEnabled(true);
/* 2260 */       this.jTextField3.setText("");
/* 2261 */       this.jTextField4.setText("");
/* 2262 */       this.jComboBox1.setEnabled(true);
/*      */     } else {
/* 2264 */       this.jComboBox1.setSelectedIndex(0);
/* 2265 */       this.jComboBox1.setEnabled(false);
/* 2266 */       this.jComboBox1.setEnabled(false);
/* 2267 */       this.jTextField3.setText("");
/* 2268 */       this.jTextField4.setText("");
/*      */     } 
/* 2270 */     this.modelo = new DefaultTableModel();
/* 2271 */     this.jTable5.setModel(this.modelo);
/* 2272 */     this.modelo.addColumn("Clave");
/* 2273 */     this.modelo.addColumn("Nombre Completo");
/* 2274 */     this.jTable5.setShowVerticalLines(false);
/* 2275 */     this.jTable5.setSelectionMode(0);
/* 2276 */     this.jTable5.setAutoCreateRowSorter(true);
/* 2277 */     this.jTable5.getTableHeader().setReorderingAllowed(false);
/* 2278 */     this.jTable5.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 2279 */     this.jTable5.getColumnModel().getColumn(0).setMaxWidth(60);
/* 2280 */     this.jTable5.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 2281 */     this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 2282 */     consultar2();
/* 2283 */     this.jDialog3.setVisible(false);
/* 2284 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton31ActionPerformed(ActionEvent evt) {
/* 2288 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 2292 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 2296 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jTable1MouseClicked(MouseEvent evt) {
/* 2300 */     if (evt.getClickCount() == 2) {
/* 2301 */       verTarjeta();
/* 2302 */     } else if (this.PRIVILEGIOS.equals("JEFE DE LIQUIDACIONES") || this.PRIVILEGIOS.equals("SUPER USUARIO") || this.PRIVILEGIOS.equals("LIQUIDACIONES")) {
/* 2303 */       this.jButton3.setEnabled(true);
/* 2304 */       this.jButton1.setEnabled(true);
/* 2305 */       this.jButton25.setEnabled(true);
/*      */     } 
/* 2307 */     this.jButton10.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2311 */     String estatus = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6));
/* 2312 */     if (!estatus.equals("<ACTIVA>")) {
/* 2313 */       JOptionPane.showMessageDialog(this.padre, "No puedes congelar la tarjeta del deudor porque no se encuentra activa", "Tarjeta No Activada", 0, this.ERROR);
/*      */     } else {
/* 2315 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas congelar la tarjeta de la siguiente persona?\n<html><b><font color=blue>" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1)) + "</font></b></html>", "Agregar Tarjetas", 0, 3, this.PREG);
/* 2316 */       if (res == 0) {
/* 2317 */         this.con.inserSinMsj("update tarjeta_deudor set estatus = '<CONGELADA>' where tarjeta = " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/*      */         
/* 2319 */         consultar();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 2326 */     String valor = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6));
/* 2327 */     if (valor.equals("<CONGELADA>")) {
/* 2328 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas activar la tarjeta de la siguiente persona?\n<html><b><font color=red>" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1)) + "</font></b></html>", "Activar Tarjeta", 0, 3, this.PREG);
/* 2329 */       if (res == 0) {
/* 2330 */         this.con.inserSinMsj("update tarjeta_deudor set estatus = '<ACTIVA>' where tarjeta = " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/*      */         
/* 2332 */         consultar();
/*      */       } 
/*      */     } else {
/* 2335 */       JOptionPane.showMessageDialog(this.padre, "No puedes activar la tarjeta porque no se encuentra en estado <CONGELADA>", "Tarjeta no Congelada", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 2340 */     String[] datos = { "FOLIO", "A NOMBRE DE", "FECHA", "TIPO", "DOCUMENTÓ", "SALDO", "ESTATUS" };
/* 2341 */     this.esc = new EscribirReporte("TARJETAS DEUDOR", this.jTable1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 2345 */     String[] datos = { "MOV.", "FECHA", "CONCEPTO", "REFERENCIA", "REPUESTO", "CARGO", "ABONO", "SALDO", "ESTATUS" };
/* 2346 */     this.esc = new EscribirReporte(this.jLabel62.getText().toUpperCase(), this.jTable2, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jTable2MouseClicked(MouseEvent evt) {
/* 2350 */     if (evt.getClickCount() == 2) {
/* 2351 */       cargarMov();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 2356 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel8MouseClicked(MouseEvent evt) {
/* 2360 */     this.con.consultar("motivo", "tarjeta_contenido", "where mov=" + this.jTextField5.getText());
/* 2361 */     if (this.con.Campo.equals("")) {
/* 2362 */       JOptionPane.showMessageDialog(this.jDialog1, "Este vale se encuentra totalmente activo", "Vale Activo", 0, this.INFO);
/*      */     } else {
/* 2364 */       JOptionPane.showMessageDialog(this.jDialog1, "Este es el motivo por el cual está cancelado el vale:\n<html><font color = red>" + this.con.Campo + "</font></html>", "Motivo de Cancelación", 0, this.INFO);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel8MouseEntered(MouseEvent evt) {
/* 2369 */     this.jLabel8.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel8MouseExited(MouseEvent evt) {
/* 2373 */     this.jLabel8.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 2377 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jFormattedTextField1ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 2383 */     this.error.pasarModal(true);
/* 2384 */     this.val.pasarModal(Boolean.valueOf(true));
/* 2385 */     if (this.jRadioButton4.isSelected() && this.jTextField9.getText().equals("")) {
/* 2386 */       this.error.cargarError(this.jTextField9, "050");
/* 2387 */     } else if (this.jDateChooser2.getDate() == null) {
/* 2388 */       JOptionPane.showMessageDialog(this.jDialog5, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr></html>", "Fecha Inicio Vacía", 0, this.ERROR);
/* 2389 */     } else if (this.jDateChooser3.getDate() == null) {
/* 2390 */       JOptionPane.showMessageDialog(this.jDialog5, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr></html>", "Fecha de Término Vacía", 0, this.ERROR);
/* 2391 */     } else if (this.jDateChooser2.getDate().after(this.jDateChooser3.getDate())) {
/* 2392 */       JOptionPane.showMessageDialog(this.jDialog5, "La fecha de inicio no puede ser mayor a la fecha de término\nPor favor verifica tus fechas", "Fechas Incorrectas", 0, this.ADVER);
/* 2393 */     } else if (this.jTextField7.getText().equals("")) {
/* 2394 */       this.error.cargarError(this.jTextField7, "050");
/* 2395 */     } else if (this.jFormattedTextField1.getText().equals("$0.00")) {
/* 2396 */       this.error.cargarError(this.jFormattedTextField1, "050");
/* 2397 */     } else if (Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue())) < 0.001D) {
/* 2398 */       this.jFormattedTextField1.setBackground(new Color(255, 51, 51));
/* 2399 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes agregar cargos por una cantidad menor de $.001, Verifica tu información", "Cantidad Pequeña", 0, this.ERROR);
/* 2400 */     } else if (this.jTextArea2.getText().equals("")) {
/* 2401 */       this.error.cargarError(this.jTextArea2, "050");
/* 2402 */     } else if (!this.val.validarApostrofe(this.jTextField9, this.jTextField9.getText(), "020") && 
/* 2403 */       !this.val.validarTexto(this.jTextField7, this.jTextField7.getText(), "020") && 
/* 2404 */       !this.val.validarTexto(this.jTextArea2, this.jTextArea2.getText(), "020")) {
/* 2405 */       String concep = "";
/* 2406 */       int cargo = 1;
/* 2407 */       if (this.jRadioButton7.isSelected()) {
/* 2408 */         cargo = 2;
/*      */       }
/* 2410 */       if (this.jRadioButton3.isSelected()) {
/* 2411 */         concep = "PAGO INFONAVIT";
/*      */       } else {
/* 2413 */         concep = this.jTextField9.getText().toUpperCase();
/*      */       } 
/* 2415 */       double total = 0.0D;
/* 2416 */       String cant = this.jFormattedTextField1.getValue().toString();
/* 2417 */       this.encontrado = this.con.consultar("saldoFinal", "tarjeta_contenido", "where tarjeta = " + this.CLAVEOP);
/* 2418 */       if (this.encontrado) {
/* 2419 */         this.encontrado = this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + this.CLAVEOP);
/* 2420 */         String saldoFinal = this.con.Campo;
/* 2421 */         total = Double.parseDouble(saldoFinal) + Double.parseDouble(cant);
/*      */       } else {
/* 2423 */         total = Double.parseDouble(cant);
/*      */       } 
/* 2425 */       this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 2426 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2427 */       String cadenaFecha = formato.format(this.jDateChooser2.getDate());
/* 2428 */       String AÑO = cadenaFecha.substring(0, 4);
/* 2429 */       String MES = cadenaFecha.substring(4, 6);
/* 2430 */       String DIA = cadenaFecha.substring(6, 8);
/* 2431 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/* 2432 */       String fecha1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 2434 */       cadenaFecha = formato.format(this.jDateChooser3.getDate());
/* 2435 */       AÑO = cadenaFecha.substring(0, 4);
/* 2436 */       MES = cadenaFecha.substring(4, 6);
/* 2437 */       DIA = cadenaFecha.substring(6, 8);
/* 2438 */       String fechaCompleta2 = DIA + "/" + DIA + "/" + MES;
/* 2439 */       String fecha2 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */ 
/*      */       
/* 2442 */       String[] campos = { "Folio", "Fecha", "A cargo de", "Concepto", "No. Referencia", "Cantidad", "Observaciones" };
/* 2443 */       String[] info = { this.jTextField10.getText(), this.jTextField8.getText(), this.jLabel7.getText(), concep, this.jTextField7.getText().toUpperCase(), this.jFormattedTextField1.getText(), this.jTextArea2.getText().toUpperCase() };
/* 2444 */       int res = this.error.cargarDatos(campos, info);
/* 2445 */       if (res == 0) {
/* 2446 */         String[] reg; this.jTextArea2.setText(this.jTextArea2.getText() + "\n");
/* 2447 */         this.jTextArea2.setText(this.jTextArea2.getText() + "__________________________\n");
/* 2448 */         this.jTextArea2.setText(this.jTextArea2.getText() + " Del " + this.jTextArea2.getText() + " al " + fechaCompleta1 + "\n");
/* 2449 */         this.jTextArea2.setText(this.jTextArea2.getText() + "__________________________");
/* 2450 */         sacarMayor();
/* 2451 */         this.con.inserSinMsj("insert into tarjeta_contenido(fecha1,fecha2,fecha,tipoConcep,concepto,referencia,importe,importeLetra,abono,abonoLetra,importeSaldado,importeRestante,observaciones,estatus,motivo,tipo,folio_Vale,repuesto,saldoFinal,saldoFinalLetra,tarjeta)values(" + fecha1 + "," + fecha2 + ",now()," + cargo + ",'" + concep + "','" + this.jTextField7
/* 2452 */             .getText().toUpperCase() + "'," + cant + ",'" + this.jFormattedTextField1.getText() + "',0,'',0," + cant + ",'" + this.jTextArea2.getText().toUpperCase() + "','<Por Pagar>','',2,'',''," + total + ",'" + this.jFormattedTextField2.getText() + "'," + this.CLAVEOP + ")");
/*      */         
/* 2454 */         this.con.inserSinMsj("update tarjeta_deudor set f_creacion = now(), usuario_creo='" + this.USUARIO + "', SALDO='" + this.jFormattedTextField2.getText() + "' where tarjeta= " + this.CLAVEOP);
/*      */         
/* 2456 */         this.encontrado = this.con.consultar("nombre", "operadores,tarjeta_deudor", "where operadores.num_ope = tarjeta_deudor.num_ope and tarjeta=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 2457 */         if (!this.con.Campo.equals("")) {
/* 2458 */           reg = this.con.regresaReg("nombre,ap_pat,ap_mat,nss", "operadores,tarjeta_deudor", "where operadores.num_ope = tarjeta_deudor.num_ope and tarjeta=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)), 4);
/*      */         } else {
/* 2460 */           reg = this.con.regresaReg("nombre,ap_pat,ap_mat,nss", "empleados,tarjeta_deudor", "where empleados.clave_emp = tarjeta_deudor.clave_emp and tarjeta=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)), 4);
/*      */         } 
/*      */         
/* 2463 */         this.aLetra = new NumerosALetras(Double.parseDouble(cant), "MXN");
/* 2464 */         String letra = this.aLetra.regresaNumero();
/* 2465 */         Calendar hoy = Calendar.getInstance();
/* 2466 */         hoy.setTime(this.jDateChooser3.getDate());
/* 2467 */         Calendar c = this.jDateChooser3.getCalendar();
/* 2468 */         int semana = c.get(3);
/* 2469 */         semana--;
/* 2470 */         ImprimirCargo im = new ImprimirCargo();
/* 2471 */         String[] datos = { this.jTextField10.getText(), this.jTextField8.getText(), reg[0], reg[1] + " " + reg[1], reg[3], this.jFormattedTextField1.getText(), letra, fechaCompleta1, fechaCompleta2, "SEM " + semana, concep, this.jTextField7.getText().toUpperCase() };
/* 2472 */         im.recibeDatos(datos);
/* 2473 */         res = JOptionPane.showConfirmDialog(this.jDialog5, "¿Se imprimió correctamente el vale del cargo directo?", "Impresión de Cargo", 0, 3, this.PREG);
/* 2474 */         if (res == 1) {
/* 2475 */           im.recibeDatos(datos);
/*      */         }
/* 2477 */         consultar3();
/* 2478 */         this.jDialog5.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 2485 */     sacarMayor();
/* 2486 */     this.jLabel7.setText(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1)));
/* 2487 */     this.jRadioButton3.setSelected(true);
/* 2488 */     this.jRadioButton6.setSelected(true);
/* 2489 */     this.jRadioButton6.setEnabled(false);
/* 2490 */     this.jRadioButton7.setEnabled(false);
/* 2491 */     this.jTextField9.setEnabled(false);
/* 2492 */     this.jTextField7.setText("");
/* 2493 */     this.jTextField9.setText("");
/* 2494 */     this.jTextArea2.setText("");
/* 2495 */     this.jDateChooser2.setDate(new Date());
/* 2496 */     this.jDateChooser3.setDate(new Date());
/*      */     
/* 2498 */     String puesto = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3));
/*      */     
/* 2500 */     if (puesto.equals("OPERADOR")) {
/* 2501 */       this.con.consultar("numInfo", "operadores,tarjeta_deudor", "where operadores.num_ope = tarjeta_deudor.num_ope and tarjeta=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 2502 */       if (!this.con.Campo.equals("")) {
/* 2503 */         String[] reg = this.con.regresaReg("numInfo,infonavit", "operadores,tarjeta_deudor", "where operadores.num_ope = tarjeta_deudor.num_ope and tarjeta=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)), 2);
/* 2504 */         this.jTextField7.setText(reg[0]);
/* 2505 */         double valor = Double.parseDouble(reg[1]);
/* 2506 */         this.jFormattedTextField1.setValue(Double.valueOf(valor));
/*      */       } else {
/* 2508 */         this.jTextField7.setText("");
/* 2509 */         this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*      */       } 
/*      */     } else {
/* 2512 */       this.con.consultar("numInfo", "empleados,tarjeta_deudor", "where empleados.clave_emp = tarjeta_deudor.clave_emp and tarjeta=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 2513 */       if (!this.con.Campo.equals("")) {
/* 2514 */         String[] reg = this.con.regresaReg("numInfo,infonavit", "empleados,tarjeta_deudor", "where empleados.clave_emp = tarjeta_deudor.clave_emp and tarjeta=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)), 2);
/* 2515 */         this.jTextField7.setText(reg[0]);
/* 2516 */         double valor = Double.parseDouble(reg[1]);
/* 2517 */         this.jFormattedTextField1.setValue(Double.valueOf(valor));
/*      */       } else {
/* 2519 */         this.jTextField7.setText("");
/* 2520 */         this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*      */       } 
/*      */     } 
/* 2523 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {
/* 2526 */     this.jTextField9.setText("");
/* 2527 */     this.jTextField9.setEnabled(false);
/* 2528 */     this.jRadioButton6.setSelected(true);
/* 2529 */     this.jRadioButton6.setEnabled(false);
/* 2530 */     this.jRadioButton7.setEnabled(false);
/*      */   }
/*      */   private void jRadioButton4ActionPerformed(ActionEvent evt) {
/* 2533 */     this.jTextField9.setEnabled(true);
/* 2534 */     this.jRadioButton6.setEnabled(true);
/* 2535 */     this.jRadioButton7.setEnabled(true);
/* 2536 */     this.jTextField7.setText("");
/* 2537 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 2541 */     this.error.pasarModal(true);
/* 2542 */     this.val.pasarModal(Boolean.valueOf(true));
/* 2543 */     this.con.consultar("saldoFinal", "tarjeta_Contenido", "where tarjeta = " + this.CLAVEOP + " order by mov desc");
/* 2544 */     this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(this.con.Campo)));
/* 2545 */     double monto = Double.parseDouble(String.valueOf(this.jFormattedTextField2.getValue()));
/* 2546 */     if (this.jRadioButton9.isSelected() && this.jTextField12.getText().equals("")) {
/* 2547 */       this.error.cargarError(this.jTextField12, "050");
/* 2548 */     } else if (this.jTextField13.getText().equals("")) {
/* 2549 */       this.error.cargarError(this.jTextField13, "050");
/* 2550 */     } else if (this.jFormattedTextField3.getText().equals("$0.00")) {
/* 2551 */       this.error.cargarError(this.jFormattedTextField3, "050");
/* 2552 */     } else if (Double.parseDouble(String.valueOf(this.jFormattedTextField3.getValue())) < 0.001D) {
/* 2553 */       this.jFormattedTextField3.setBackground(new Color(255, 51, 51));
/* 2554 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes agregar abonos por una cantidad menor de $0.001, Verifica tu información", "Cantidad Pequeña", 0, this.ERROR);
/* 2555 */     } else if (monto < Double.parseDouble(String.valueOf(this.jFormattedTextField3.getValue()))) {
/* 2556 */       JOptionPane.showMessageDialog(this.jDialog6, "No puedes abonar la cantidad porque es mayor de la que tiene en la tarjeta deudor", "Cantidad Grande", 0, this.ADVER);
/* 2557 */     } else if (this.jTextArea3.getText().equals("")) {
/* 2558 */       this.error.cargarError(this.jTextArea3, "050");
/* 2559 */     } else if (!this.val.validarApostrofe(this.jTextField12, this.jTextField12.getText(), "020") && 
/* 2560 */       !this.val.validarTexto(this.jTextField13, this.jTextField13.getText(), "020") && 
/* 2561 */       !this.val.validarTexto(this.jTextArea3, this.jTextArea3.getText(), "020")) {
/* 2562 */       String concep = "";
/* 2563 */       int cargo = 4;
/* 2564 */       if (this.jRadioButton5.isSelected()) {
/* 2565 */         concep = "ABONO A GASTOS POR COMPROBAR";
/* 2566 */         cargo = 4;
/* 2567 */       } else if (this.jRadioButton8.isSelected()) {
/* 2568 */         concep = "ABONO A PRÉSTAMO PERSONAL";
/*      */       } else {
/* 2570 */         concep = this.jTextField12.getText().toUpperCase();
/*      */       } 
/* 2572 */       double total = 0.0D;
/* 2573 */       String cant = this.jFormattedTextField3.getValue().toString();
/* 2574 */       total = Double.parseDouble(cant);
/*      */       
/* 2576 */       String[] campos = { "Folio", "Fecha", "A cargo de", "Concepto", "No. Referencia", "Cantidad", "Observaciones" };
/* 2577 */       String[] info = { this.jTextField14.getText(), this.jTextField11.getText(), this.jLabel11.getText(), concep, this.jTextField13.getText().toUpperCase(), this.jFormattedTextField3.getText(), this.jTextArea3.getText().toUpperCase() };
/* 2578 */       int res = this.error.cargarDatos(campos, info);
/* 2579 */       if (res == 0) {
/* 2580 */         String[][] datosR = this.con.buscarDatos(3, "mov,importeRestante,importeSaldado", "tarjeta_contenido", "where tarjeta =" + this.CLAVEOP + " and importeRestante>0 order by mov");
/* 2581 */         String[] movi = new String[datosR.length];
/* 2582 */         String[] restan = new String[datosR.length];
/* 2583 */         String[] saldado = new String[datosR.length];
/*      */         int i;
/* 2585 */         for (i = 0; i < datosR.length; i++) {
/* 2586 */           for (int k = 0; k < (datosR[i]).length; k++) {
/* 2587 */             if (k == 0) {
/* 2588 */               movi[i] = datosR[i][k];
/*      */             }
/* 2590 */             if (k == 1) {
/* 2591 */               restan[i] = datosR[i][k];
/*      */             }
/* 2593 */             if (k == 2) {
/* 2594 */               saldado[i] = datosR[i][k];
/*      */             }
/*      */           } 
/*      */         } 
/*      */         
/* 2599 */         for (i = 0; i < restan.length && 
/* 2600 */           total > 0.0D; i++)
/*      */         {
/*      */           
/* 2603 */           total = saldar(total, Double.parseDouble(restan[i]), Double.parseDouble(saldado[i]), movi[i]).doubleValue();
/*      */         }
/*      */         
/* 2606 */         this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + this.CLAVEOP);
/* 2607 */         total = Double.parseDouble(this.con.Campo);
/* 2608 */         this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 2609 */         sacarMayor();
/* 2610 */         this.con.inserSinMsj("insert into tarjeta_contenido(fecha1,fecha2,fecha,tipoConcep,concepto,referencia,importe,importeLetra,abono,abonoLetra,importeSaldado,importeRestante,observaciones,estatus,motivo,tipo,folio_Vale,repuesto,saldoFinal,saldoFinalLetra,tarjeta)values(now(),now(),now(),4,'" + concep + "','" + this.jTextField13
/* 2611 */             .getText().toUpperCase() + "',0,''," + cant + ",'" + this.jFormattedTextField3.getText() + "',0,0,'" + this.jTextArea3.getText().toUpperCase() + "','<Aplicado>','',3,'',''," + total + ",'" + this.jFormattedTextField2.getText() + "'," + this.CLAVEOP + ")");
/*      */         
/* 2613 */         this.con.inserSinMsj("update tarjeta_deudor set f_creacion = now(), usuario_creo='" + this.USUARIO + "', SALDO='" + this.jFormattedTextField2.getText() + "' where tarjeta= " + this.CLAVEOP);
/*      */         
/* 2615 */         consultar3();
/* 2616 */         this.jDialog6.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jFormattedTextField3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 2628 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton5ActionPerformed(ActionEvent evt) {
/* 2632 */     this.jTextField12.setEditable(false);
/* 2633 */     this.jTextField12.setText("");
/*      */   }
/*      */   
/*      */   private void jRadioButton8ActionPerformed(ActionEvent evt) {
/* 2637 */     this.jTextField12.setEditable(false);
/* 2638 */     this.jTextField12.setText("");
/*      */   }
/*      */   
/*      */   private void jRadioButton9ActionPerformed(ActionEvent evt) {
/* 2642 */     this.jTextField12.setEditable(true);
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 2646 */     sacarMayor();
/* 2647 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 2648 */     this.jLabel11.setText(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1)));
/* 2649 */     this.jRadioButton5.setSelected(true);
/* 2650 */     this.jTextField12.setEditable(false);
/* 2651 */     this.jTextField13.setText("");
/* 2652 */     this.jTextField12.setText("");
/* 2653 */     this.jTextArea3.setText("");
/*      */ 
/*      */     
/* 2656 */     this.jDialog6.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 2660 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 2664 */     this.jTextArea4.setText("");
/* 2665 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 2669 */     int selec = this.jTable2.getSelectedRow();
/* 2670 */     if (selec < 0) {
/* 2671 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder cancelar el movimiento", "Selecciona un Movimiento", 0, this.ADVER);
/* 2672 */     } else if (this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 8).toString().equals("<Cancelado>")) {
/* 2673 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes cancelar este movimiento porque ya ha sido cancelado con anterioridad", "Movimiento Ya Cancelado", 0, this.ADVER);
/*      */     } else {
/* 2675 */       String rep = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 4));
/* 2676 */       if (rep.equals("SI")) {
/* 2677 */         JOptionPane.showMessageDialog(this.jDialog1, "No puedes cancelar este vale porque ya ha sido repuesto\nNecesitas seleccionar otro vale.", "Vale Repuesto", 0, this.ERROR);
/*      */       } else {
/* 2679 */         String[] datos = this.con.regresaReg("tipoConcep,abono,abonoLetra", "tarjeta_contenido", "where mov= " + String.valueOf(this.jTable2.getValueAt(selec, 0)), 3);
/* 2680 */         String estatus = this.jTable2.getValueAt(selec, 8).toString();
/* 2681 */         System.out.println("conceptos " + datos[0] + " " + datos[1]);
/* 2682 */         if (datos[0].equals("1") || datos[0].equals("2")) {
/* 2683 */           if (estatus.equals("<Por Pagar>")) {
/* 2684 */             this.jDialog7.setVisible(true);
/*      */           } else {
/* 2686 */             JOptionPane.showMessageDialog(this.jDialog1, "No puedes cancelar este movimiento, ya que tiene abonos aplicados. Su estatus es:\n" + estatus, "Concepto con importes abonados", 0, this.ERROR);
/*      */           }
/*      */         
/* 2689 */         } else if (this.jTable2.getValueAt(selec, 6).toString().equals("----")) {
/* 2690 */           JOptionPane.showMessageDialog(this.jDialog1, "No puedes cancelar este movimiento, ya que es una liquidación autorizada. Su estatus es:\n" + estatus, "Liquidación Autorizada", 0, this.ERROR);
/* 2691 */         } else if (datos[0].equals("4")) {
/* 2692 */           JOptionPane.showMessageDialog(this.jDialog1, "<html> <font color = blue><b> ¡ADVERTENCIA!</b></font> El movimiento que deseas cancelar es un abono, se cargará un nuevo concepto por la misma cantidad<html>", "Cancelar abono", 0, this.ADVER);
/* 2693 */           int res = JOptionPane.showConfirmDialog(this.jDialog2, "<html>¿Estás seguro que deseas realizar un cargo por la cantidad por: <b>" + datos[2] + "?</b></html>", "Agregar Movimiento", 0, 3, this.PREG);
/* 2694 */           if (res == 0) {
/* 2695 */             String v = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 6).toString();
/* 2696 */             double cant = convertirTextoADouble(v);
/* 2697 */             double total = 0.0D;
/* 2698 */             this.encontrado = this.con.consultar("saldoFinal", "tarjeta_contenido", "where tarjeta = " + this.CLAVEOP);
/* 2699 */             if (this.encontrado) {
/* 2700 */               this.encontrado = this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + this.CLAVEOP);
/* 2701 */               String saldoFinal = this.con.Campo;
/* 2702 */               total = Double.parseDouble(saldoFinal) + cant;
/*      */             } else {
/* 2704 */               total = cant;
/*      */             } 
/* 2706 */             this.jFormattedTextField2.setValue(Double.valueOf(total));
/*      */             
/* 2708 */             this.con.inserSinMsj("insert into tarjeta_contenido(fecha1,fecha2,fecha,tipoConcep,concepto,referencia,importe,importeLetra,abono,abonoLetra,importeSaldado,importeRestante,observaciones,estatus,motivo,tipo,folio_Vale,repuesto,saldoFinal,saldoFinalLetra,tarjeta)values(now(),now(),now(),1,'CARGO POR CANCELACIÓN','CARGO POR: " + 
/* 2709 */                 String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 3)) + "'," + cant + ",'" + v + "',0,'',0," + cant + ",'ESTE MOVIMIENTO SE CREÓ AUTOMATICAMENTE POR UN ABONO CANCELADO','<Por Pagar>',''    ,2,    ''      ,''," + total + ",'" + this.jFormattedTextField2.getText() + "'," + this.CLAVEOP + ")");
/*      */             
/* 2711 */             this.con.inserSinMsj("update tarjeta_deudor set f_creacion = now(), usuario_creo='" + this.USUARIO + "', SALDO='" + this.jFormattedTextField2.getText() + "' where tarjeta= " + this.CLAVEOP);
/* 2712 */             consultar3();
/*      */           } 
/*      */         } 
/*      */       } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 2735 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 2739 */     if (this.ACTIVARCONSULTA)
/* 2740 */       consultar3(); 
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/*      */     String[] reg;
/* 2745 */     double cant = 0.0D;
/*      */ 
/*      */     
/* 2748 */     String valor = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString();
/* 2749 */     if (valor.contains("OPERADOR")) {
/* 2750 */       reg = this.con.regresaReg("nombre,ap_pat,ap_mat,nss", "operadores,tarjeta_deudor", "where operadores.num_ope = tarjeta_deudor.num_ope and tarjeta=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)), 4);
/*      */     } else {
/*      */       
/* 2753 */       reg = this.con.regresaReg("nombre,ap_pat,ap_mat,nss", "empleados,tarjeta_deudor", "where empleados.clave_emp = tarjeta_deudor.clave_emp and tarjeta=" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)), 4);
/*      */     } 
/*      */     
/* 2756 */     String[] FECHAS = this.con.regresaReg("fecha1,fecha2", "tarjeta_contenido", "where mov=" + this.jTextField5.getText(), 2);
/*      */     
/* 2758 */     String canti = this.jLabel6.getText();
/* 2759 */     String valorP = "";
/* 2760 */     for (int i = 0; i < canti.length(); i++) {
/* 2761 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 2762 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 2765 */     cant = Double.parseDouble(valorP);
/*      */     
/* 2767 */     this.aLetra = new NumerosALetras(cant, "MXN");
/* 2768 */     String letra = this.aLetra.regresaNumero();
/* 2769 */     Calendar hoy = Calendar.getInstance();
/* 2770 */     hoy.setTime(this.jDateChooser3.getDate());
/* 2771 */     Calendar c = this.jDateChooser3.getCalendar();
/* 2772 */     int semana = c.get(3);
/* 2773 */     semana--;
/* 2774 */     ImprimirCargo im = new ImprimirCargo();
/*      */     
/* 2776 */     String fechaCompleta1 = FECHAS[0].substring(8, 10) + "/" + FECHAS[0].substring(8, 10) + "/" + FECHAS[0].substring(5, 7);
/* 2777 */     String fechaCompleta2 = FECHAS[1].substring(8, 10) + "/" + FECHAS[1].substring(8, 10) + "/" + FECHAS[1].substring(5, 7);
/* 2778 */     String[] datos = { this.DIRECTIVAS + "-" + this.DIRECTIVAS, this.jTextField6.getText(), reg[0], reg[1] + " " + reg[1], reg[3], this.jLabel6.getText(), letra, fechaCompleta1, fechaCompleta2, "SEM " + semana, this.jLabel4.getText(), this.jLabel5.getText() };
/* 2779 */     im.recibeDatos(datos);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   public double convertirTextoADouble(String texto) {
/* 2787 */     String canti = texto;
/* 2788 */     String valorP = "";
/* 2789 */     for (int i = 0; i < canti.length(); i++) {
/* 2790 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 2791 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 2794 */     double cant = Double.parseDouble(valorP);
/* 2795 */     return cant;
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 2799 */     this.error.pasarModal(true);
/* 2800 */     this.val.pasarModal(Boolean.valueOf(true));
/* 2801 */     String motivo = this.jTextArea4.getText();
/* 2802 */     if (motivo.equals("")) {
/* 2803 */       this.error.cargarError(this.jTextArea4, "050");
/* 2804 */     } else if (!this.val.validarApostrofe(this.jTextArea4, motivo, "020")) {
/* 2805 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas cancelar el movimiento que se seleccionaste?", "Cancelar Movimiento", 0, 3, this.PREG);
/* 2806 */       if (res == 0) {
/* 2807 */         this.con.inserSinMsj("update tarjeta_contenido set importeRestante=0, estatus = '<Cancelado>', motivo = '" + this.jTextArea4.getText().toUpperCase() + "' where mov=" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)));
/* 2808 */         this.con.consultar("folio_vale", "tarjeta_contenido", "where mov=" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0)));
/* 2809 */         this.con.inserSinMsj("update valesgastos set estatus = '<Cancelado>', motivo = '" + this.jTextArea4.getText().toUpperCase() + "',monto=0.0, montoLetra ='$0.00' where folio_valegastos='" + this.con.Campo + "'");
/* 2810 */         String valor = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 3));
/* 2811 */         if (valor.contains("")) {
/* 2812 */           String[] datosVale = this.con.regresaReg("unidad,nombre_usu", "valesGastos", "where folio_ValeGastos='" + this.con.Campo + "'", 2);
/* 2813 */           this.con.inserSinMsj("insert into vales_cancelados (folio,fecha_vale,fecha_cancel,nombre,concepto,unidad,cargoLetra,nombre_usu,cancelo,motivo) values ('" + this.con.Campo + "','" + 
/* 2814 */               String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1)) + "',now(),'" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1)) + "','" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 2)) + "','" + datosVale[0] + "','" + String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 5)) + "','" + datosVale[1] + "','" + this.USUARIO + "','" + this.jTextArea4.getText().toUpperCase() + "')");
/*      */         } 
/*      */         
/* 2817 */         this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + this.CLAVEOP);
/* 2818 */         double total = Double.parseDouble(this.con.Campo);
/* 2819 */         this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 2820 */         this.con.consultar("max(mov)", "tarjeta_contenido", "where tarjeta = " + this.CLAVEOP);
/* 2821 */         this.con.inserSinMsj("update tarjeta_contenido set saldoFinal = " + total + ",saldoFinalLetra = '" + this.jFormattedTextField2.getText() + "' where mov=" + this.con.Campo);
/* 2822 */         this.con.inserSinMsj("update tarjeta_deudor set f_creacion = now(), usuario_creo='" + this.USUARIO + "', SALDO='" + this.jFormattedTextField2.getText() + "' where tarjeta= " + this.CLAVEOP);
/*      */         
/* 2824 */         consultar3();
/* 2825 */         this.jTextArea4.setText("");
/* 2826 */         this.jDialog7.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void cargarMov() {
/* 2832 */     int indice = this.jTable2.getSelectedRow();
/* 2833 */     this.jTextField5.setText(String.valueOf(this.jTable2.getValueAt(indice, 0)));
/* 2834 */     this.jDialog4.setTitle("Movimiento - " + String.valueOf(this.jTable2.getValueAt(indice, 0)));
/* 2835 */     String fecha = String.valueOf(this.jTable2.getValueAt(indice, 1));
/* 2836 */     String año = fecha.substring(0, 4);
/* 2837 */     String mes = fecha.substring(5, 7);
/* 2838 */     String dia = fecha.substring(8, 10);
/* 2839 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 2840 */     String cargo = String.valueOf(this.jTable2.getValueAt(indice, 6));
/* 2841 */     this.jTextField6.setText(strFecha);
/* 2842 */     if (!cargo.equals("")) {
/* 2843 */       cargo = "ABONO";
/* 2844 */       this.jLabel4.setText(String.valueOf(this.jTable2.getValueAt(indice, 2)));
/* 2845 */       this.jLabel6.setText(String.valueOf(this.jTable2.getValueAt(indice, 6)));
/*      */     } else {
/* 2847 */       cargo = "CARGO";
/* 2848 */       this.jLabel4.setText(String.valueOf(this.jTable2.getValueAt(indice, 2)));
/* 2849 */       this.jLabel6.setText(String.valueOf(this.jTable2.getValueAt(indice, 5)));
/*      */     } 
/* 2851 */     this.jLabel2.setText(cargo);
/* 2852 */     this.jLabel5.setText(String.valueOf(this.jTable2.getValueAt(indice, 3)));
/* 2853 */     String estatus = String.valueOf(this.jTable2.getValueAt(indice, 8));
/* 2854 */     this.con.consultar("observaciones", "tarjeta_contenido", "where mov = " + String.valueOf(this.jTable2.getValueAt(indice, 0)));
/* 2855 */     this.jTextArea1.setText(this.con.Campo);
/* 2856 */     if (estatus.equals("<Cancelado>")) {
/* 2857 */       this.jLabel8.setVisible(true);
/*      */     } else {
/* 2859 */       this.jLabel8.setVisible(false);
/*      */     } 
/* 2861 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   public Double saldar(double valor, double res, double saldado, String mov) {
/* 2865 */     double restante = 0.0D;
/* 2866 */     if (res > valor) {
/* 2867 */       res -= valor;
/* 2868 */       saldado += valor;
/* 2869 */       this.jFormattedTextField2.setValue(Double.valueOf(saldado));
/* 2870 */       this.con.inserSinMsj("update tarjeta_contenido set importesaldado = " + saldado + ", estatus='<Abono:" + this.jFormattedTextField2.getText() + ">',importeRestante = " + res + " where mov=" + mov);
/* 2871 */       restante = 0.0D;
/*      */     } else {
/* 2873 */       restante = valor - res;
/* 2874 */       saldado += res;
/* 2875 */       this.jFormattedTextField2.setValue(Double.valueOf(saldado));
/* 2876 */       Date fecha = new Date();
/* 2877 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2878 */       String cadenaFecha = "";
/* 2879 */       cadenaFecha = formato.format(fecha);
/* 2880 */       String AÑO = cadenaFecha.substring(0, 4);
/* 2881 */       String MES = cadenaFecha.substring(4, 6);
/* 2882 */       String DIA = cadenaFecha.substring(6, 8);
/* 2883 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/* 2884 */       this.con.inserSinMsj("update tarjeta_contenido set estatus = '<Pagado:" + fechaCompleta1 + ">', importeSaldado = " + saldado + ",importeRestante =0 where mov=" + mov);
/*      */     } 
/* 2886 */     return Double.valueOf(restante);
/*      */   }
/*      */   
/*      */   public void tarjetas(String usu) {
/* 2890 */     cargarFechaHoy();
/* 2891 */     this.USUARIO = usu;
/* 2892 */     extraerUsuario(this.USUARIO);
/* 2893 */     consultar();
/* 2894 */     this.modelo = new DefaultTableModel();
/* 2895 */     this.jTable5.setModel(this.modelo);
/* 2896 */     this.modelo.addColumn("Clave");
/* 2897 */     this.modelo.addColumn("Nombre Completo");
/* 2898 */     this.jTable5.setShowVerticalLines(false);
/* 2899 */     this.jTable5.setSelectionMode(0);
/* 2900 */     this.jTable5.setAutoCreateRowSorter(true);
/* 2901 */     this.jTable5.getTableHeader().setReorderingAllowed(false);
/* 2902 */     this.jTable5.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 2903 */     this.jTable5.getColumnModel().getColumn(0).setMaxWidth(60);
/* 2904 */     this.jTable5.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 2905 */     this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */     
/* 2907 */     this.PRIVILEGIOS = this.CAMPOSGENERALES.get("priv");
/* 2908 */     desactivarFiltroOperadores();
/* 2909 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 2913 */     this.jButton10.setEnabled(false);
/* 2914 */     this.jButton3.setEnabled(false);
/* 2915 */     this.jButton1.setEnabled(false);
/* 2916 */     this.jButton25.setEnabled(false);
/* 2917 */     String tipo = "";
/* 2918 */     String nombre = "";
/* 2919 */     String actual = "";
/* 2920 */     if (this.jComboBox3.getSelectedIndex() == 1) {
/* 2921 */       tipo = "and clave_emp=0";
/* 2922 */     } else if (this.jComboBox3.getSelectedIndex() == 2) {
/* 2923 */       tipo = "and clave_emp<>0";
/*      */     } 
/* 2925 */     if (!this.jTextField1.getText().equals("")) {
/* 2926 */       nombre = this.jTextField1.getText();
/*      */     }
/* 2928 */     if (this.jComboBox2.getSelectedIndex() != 3) {
/* 2929 */       actual = String.valueOf(this.jComboBox2.getSelectedItem());
/*      */     }
/* 2931 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2932 */           .buscarDatos(7, "tarjeta,nombreCompleto,f_creacion,tipo,usuario_creo,saldo,estatus", "tarjeta_deudor", "where nombrecompleto like '%" + nombre + "%' and estatus like '%" + actual + "%' " + tipo + " and tarjeta<>0 order by nombreCompleto"), (Object[])new String[] { "Folio", "A Nombre de", "Actualización", "Tipo", "Responsable", "Saldo", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 2937 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2942 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2945 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable1.getRowCount() + "</HTML>");
/* 2946 */     this.celda.pasarInd(this.con.revisarCol(this.jTable1, "<CONGELADA>", 0, 6, 0));
/* 2947 */     this.celda.pasarInd2(this.con.revisarCol(this.jTable1, "<BAJA>", 0, 6, 0));
/*      */     
/* 2949 */     this.jTable1.setSelectionMode(0);
/* 2950 */     this.jTable1.setAutoCreateRowSorter(true);
/* 2951 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/* 2952 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 2953 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 2954 */     this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
/* 2955 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
/* 2956 */     this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(210);
/* 2957 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(210);
/* 2958 */     this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(210);
/* 2959 */     this.jTable1.getColumnModel().getColumn(4).setMaxWidth(210);
/* 2960 */     this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
/* 2961 */     this.jTable1.getColumnModel().getColumn(5).setMaxWidth(100);
/*      */     
/* 2963 */     this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 2964 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 2965 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 2966 */     this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2967 */     this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2968 */     this.jTable1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 2969 */     this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void extraerUsuario(String nombre) {
/* 2973 */     this.USUARIO = nombre;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2981 */     this.NOMBRE = (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat");
/*      */     
/* 2983 */     this.PRIVILEGIOS = this.CAMPOSGENERALES.get("priv");
/* 2984 */     if (this.PRIVILEGIOS.equals("JEFE DE LIQUIDACIONES") || this.PRIVILEGIOS.equals("SUPER USUARIO")) {
/* 2985 */       this.jButton2.setEnabled(true);
/*      */     } else {
/* 2987 */       this.jButton2.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultar2() {
/* 2992 */     this.entraDepa = true;
/* 2993 */     this.jButton12.setEnabled(false);
/* 2994 */     this.jButton13.setEnabled(false);
/* 2995 */     String tipo = "operador";
/* 2996 */     String nombre = "";
/* 2997 */     String clave = "";
/* 2998 */     String depa = "";
/* 2999 */     if (!this.jRadioButton1.isSelected()) {
/* 3000 */       this.jLabel78.setText("Lista de Empleados");
/* 3001 */       tipo = "empleado";
/* 3002 */       if (this.jComboBox1.getSelectedIndex() != 0) {
/* 3003 */         depa = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */       }
/* 3005 */       if (!this.jTextField3.getText().equals("")) {
/* 3006 */         clave = this.jTextField3.getText();
/*      */       }
/* 3008 */       if (!this.jTextField4.getText().equals("")) {
/* 3009 */         nombre = this.jTextField4.getText();
/*      */       }
/* 3011 */       this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 3012 */             .buscarDatos(4, "clave_emp,empleados.nombre,ap_pat,ap_mat", "empleados,departamentos", "where empleados.clave_depa = departamentos.clave_depa and departamentos.nombre like '%" + depa + "%' and empleados.nombre like '%" + nombre + "%' and empleados.clave_emp like '%" + clave + "%' and actual=0 order by empleados.nombre"), (Object[])new String[] { "Clave", "Nombre Completo", "Paterno", "Materno" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 3017 */             boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3022 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/*      */     } else {
/* 3026 */       this.jLabel78.setText("Lista de Operadores");
/* 3027 */       if (!this.jTextField3.getText().equals("")) {
/* 3028 */         clave = this.jTextField3.getText();
/*      */       }
/* 3030 */       if (!this.jTextField4.getText().equals("")) {
/* 3031 */         nombre = this.jTextField4.getText();
/*      */       }
/* 3033 */       this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 3034 */             .buscarDatos(4, "num_ope,nombre,ap_pat,ap_mat", "operadores", "where num_ope<>0 and actual=0 and nombre like '%" + nombre + "%' and num_ope like '%" + clave + "%' order by nombre"), (Object[])new String[] { "Clave", "Nombre Completo", "Paterno", "Materno" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 3039 */             boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3044 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/*      */     } 
/* 3048 */     eliminarColumna(2, 1, "Paterno");
/* 3049 */     eliminarColumna(2, 1, "Materno");
/* 3050 */     this.jTable4.setShowVerticalLines(false);
/* 3051 */     this.jTable4.setSelectionMode(0);
/* 3052 */     this.jTable4.setAutoCreateRowSorter(true);
/* 3053 */     this.jTable4.getTableHeader().setReorderingAllowed(false);
/* 3054 */     this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 3055 */     this.jTable4.getColumnModel().getColumn(0).setMaxWidth(60);
/*      */     
/* 3057 */     this.jTable4.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 3058 */     this.jTable4.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */   }
/*      */   
/*      */   public void consultar3() {
/* 3062 */     String consulta = "";
/*      */     
/* 3064 */     Date fechaI = this.jDateChooser4.getDate();
/* 3065 */     Date fechaT = this.jDateChooser5.getDate();
/*      */     
/* 3067 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3068 */     String cadenaFecha = "";
/* 3069 */     cadenaFecha = formato.format(fechaI);
/* 3070 */     String AÑO = cadenaFecha.substring(0, 4);
/* 3071 */     String MES = cadenaFecha.substring(4, 6);
/* 3072 */     String DIA = cadenaFecha.substring(6, 8);
/* 3073 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/* 3075 */     formato = new SimpleDateFormat("yyyyMMdd");
/* 3076 */     cadenaFecha = formato.format(fechaT);
/* 3077 */     AÑO = cadenaFecha.substring(0, 4);
/* 3078 */     MES = cadenaFecha.substring(4, 6);
/* 3079 */     DIA = cadenaFecha.substring(6, 8);
/* 3080 */     String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + " 23:59:59'";
/* 3081 */     String concepto = String.valueOf(this.jComboBox4.getSelectedItem());
/* 3082 */     if (concepto.equals("TODOS") || concepto.equals("todos")) {
/* 3083 */       this.ACTIVARCONSULTA = false;
/*      */     }
/* 3085 */     if (this.ACTIVARCONSULTA) {
/* 3086 */       consulta = " and concepto like '%" + String.valueOf(this.jComboBox4.getSelectedItem()) + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2;
/*      */     }
/* 3088 */     this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 3089 */           .buscarDatos(9, "mov,fecha,concepto,referencia,repuesto,importeLetra,abonoLetra,saldoFinalLetra,estatus", "tarjeta_contenido", "where tarjeta=" + this.CLAVEOP + " " + consulta + " order by mov desc"), (Object[])new String[] { "Mov.", "Fecha", "Concepto", "Referencia", "Rep", "Importe", "Abono", "Saldo", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 3094 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3099 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3102 */     if (this.jTable2.getRowCount() > 0) {
/* 3103 */       this.jTextField2.setText(String.valueOf(this.jTable2.getValueAt(0, 7)));
/*      */     } else {
/* 3105 */       this.jTextField2.setText("$0.00");
/*      */     } 
/* 3107 */     this.celda3.pasarInd(this.con.revisarCol(this.jTable2, "<Por Pagar>", 0, 8, 0));
/* 3108 */     this.celda3.pasarInd2(this.con.revisarCol(this.jTable2, "<Cancelado>", 0, 8, 0));
/* 3109 */     this.celda3.pasarInd3(this.con.revisarCol(this.jTable2, "<Abono", 0, 8, 2));
/*      */ 
/*      */ 
/*      */     
/* 3113 */     this.jTable2.setShowVerticalLines(false);
/* 3114 */     this.jTable2.setSelectionMode(0);
/* 3115 */     this.jTable2.setAutoCreateRowSorter(true);
/*      */     
/* 3117 */     this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 3118 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 3119 */     this.jTable2.getColumnModel().getColumn(1).setPreferredWidth(110);
/* 3120 */     this.jTable2.getColumnModel().getColumn(1).setMaxWidth(110);
/* 3121 */     this.jTable2.getColumnModel().getColumn(4).setPreferredWidth(30);
/* 3122 */     this.jTable2.getColumnModel().getColumn(4).setMaxWidth(30);
/* 3123 */     this.jTable2.getColumnModel().getColumn(5).setPreferredWidth(70);
/* 3124 */     this.jTable2.getColumnModel().getColumn(5).setMaxWidth(70);
/* 3125 */     this.jTable2.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 3126 */     this.jTable2.getColumnModel().getColumn(6).setMaxWidth(70);
/* 3127 */     this.jTable2.getColumnModel().getColumn(7).setPreferredWidth(70);
/* 3128 */     this.jTable2.getColumnModel().getColumn(7).setMaxWidth(70);
/* 3129 */     this.jTable2.getColumnModel().getColumn(8).setPreferredWidth(130);
/* 3130 */     this.jTable2.getColumnModel().getColumn(8).setMaxWidth(130);
/*      */     
/* 3132 */     this.jTable2.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 3133 */     this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 3134 */     this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda3);
/* 3135 */     this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda3);
/* 3136 */     this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda3);
/* 3137 */     this.jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda3);
/* 3138 */     this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda3);
/* 3139 */     this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda3);
/* 3140 */     this.jTable2.getColumnModel().getColumn(8).setCellRenderer(this.celda3);
/*      */     
/* 3142 */     if (!this.ACTIVARCONSULTA) {
/* 3143 */       String fecha1 = "";
/* 3144 */       String fecha2 = "";
/* 3145 */       if (this.jTable2.getRowCount() > 0) {
/* 3146 */         fecha1 = String.valueOf(this.jTable2.getValueAt(this.jTable2.getRowCount() - 1, 1));
/* 3147 */         fecha2 = String.valueOf(this.jTable2.getValueAt(0, 1));
/*      */         
/* 3149 */         String año = fecha1.substring(0, 4);
/* 3150 */         String mes = fecha1.substring(5, 7);
/* 3151 */         String dia = fecha1.substring(8, 10);
/* 3152 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3153 */         String strFecha = año + "-" + año + "-" + mes;
/* 3154 */         Date fecha = null;
/*      */         try {
/* 3156 */           fecha = formatoDelTexto.parse(strFecha);
/* 3157 */         } catch (ParseException ex) {
/* 3158 */           ex.printStackTrace();
/*      */         } 
/* 3160 */         this.jDateChooser4.setDate(fecha);
/*      */         
/* 3162 */         año = fecha2.substring(0, 4);
/* 3163 */         mes = fecha2.substring(5, 7);
/* 3164 */         dia = fecha2.substring(8, 10);
/* 3165 */         formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3166 */         strFecha = año + "-" + año + "-" + mes;
/* 3167 */         fecha = null;
/*      */         try {
/* 3169 */           fecha = formatoDelTexto.parse(strFecha);
/* 3170 */         } catch (ParseException ex) {
/* 3171 */           ex.printStackTrace();
/*      */         } 
/* 3173 */         this.jDateChooser5.setDate(fecha);
/*      */       } else {
/*      */         
/* 3176 */         this.jDateChooser4.setDate(new Date());
/* 3177 */         this.jDateChooser5.setDate(new Date());
/*      */       } 
/*      */ 
/*      */       
/* 3181 */       this.jComboBox4.setSelectedIndex(0);
/* 3182 */       this.ACTIVARCONSULTA = true;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 3187 */     int cont = this.jTable4.getRowCount();
/* 3188 */     String[] registros = new String[cont]; int i;
/* 3189 */     for (i = 0; i < cont; i++) {
/* 3190 */       registros[i] = this.jTable4.getValueAt(i, destino).toString();
/*      */     }
/* 3192 */     for (i = 0; i < cont; i++) {
/* 3193 */       registros[i] = registros[i] + " " + registros[i];
/* 3194 */       this.jTable4.setValueAt(registros[i], i, destino);
/*      */     } 
/* 3196 */     TableColumn columna = this.jTable4.getColumn(nombreCol);
/* 3197 */     this.jTable4.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 3201 */     this.jComboBox1.removeAllItems();
/* 3202 */     String[] depa = this.con.regresaColIndex("departamentos.nombre", "departamentos", "order by nombre");
/* 3203 */     this.jComboBox1.addItem("DEPARTAMENTO");
/* 3204 */     for (int i = 0; i < depa.length; i++) {
/* 3205 */       this.jComboBox1.addItem(depa[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 3210 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3212 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3216 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 3219 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3221 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3225 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 3228 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3230 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3234 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 3237 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3239 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3243 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 3246 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3248 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3252 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 3255 */     this.jTextArea2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3257 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jTextArea2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3261 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jTextArea2, evt);
/*      */           }
/*      */         });
/* 3264 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3266 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3270 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jTextField9, evt);
/*      */           }
/*      */         });
/* 3273 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3275 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3279 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jTextField12, evt);
/*      */           }
/*      */         });
/* 3282 */     this.jTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3284 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jTextField13, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3288 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jTextField13, evt);
/*      */           }
/*      */         });
/* 3291 */     this.jTextArea3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3293 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jTextArea3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3297 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jTextArea3, evt);
/*      */           }
/*      */         });
/* 3300 */     this.jTextArea4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3302 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jTextArea4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3306 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jTextArea4, evt);
/*      */           }
/*      */         });
/* 3309 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3311 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3315 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/*      */     
/* 3319 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3321 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jFormattedTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3325 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jFormattedTextField3, evt);
/*      */           }
/*      */         });
/* 3328 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3330 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3334 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 3337 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3339 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3343 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 3346 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3348 */             TarjetasDeudoras.this.jTextGanado(TarjetasDeudoras.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3352 */             TarjetasDeudoras.this.jTextPerdido(TarjetasDeudoras.this.jComboBox3, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 3358 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 3362 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 3367 */     int otro = -1;
/* 3368 */     String[] indices = new String[0];
/* 3369 */     String[] indices2 = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3372 */       setEnabled((table == null || table.isEnabled()));
/* 3373 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 3374 */       if (comparar(comp)) {
/* 3375 */         setBackground(new Color(102, 153, 255));
/* 3376 */         setForeground(Color.BLUE);
/* 3377 */         setHorizontalAlignment(2);
/* 3378 */       } else if (comparar2(comp)) {
/* 3379 */         setBackground(Color.RED);
/* 3380 */         setForeground(Color.WHITE);
/* 3381 */         setHorizontalAlignment(2);
/* 3382 */       } else if (row % 2 == 0 && column == 5) {
/* 3383 */         setBackground(new Color(120, 200, 104));
/* 3384 */         setForeground(Color.black);
/* 3385 */       } else if (row % 2 == 0) {
/* 3386 */         setBackground(new Color(194, 213, 151));
/* 3387 */         setForeground(Color.black);
/* 3388 */         setHorizontalAlignment(2);
/*      */       } else {
/* 3390 */         setBackground((Color)null);
/* 3391 */         setForeground(Color.black);
/* 3392 */         setHorizontalAlignment(2);
/*      */       } 
/* 3394 */       if (column == 5) {
/* 3395 */         setHorizontalAlignment(4);
/*      */       }
/*      */       
/* 3398 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3399 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 3403 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 3407 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 3411 */       for (int i = 0; i < this.indices.length; i++) {
/* 3412 */         if (this.indices[i].equals(reg)) {
/* 3413 */           return true;
/*      */         }
/*      */       } 
/* 3416 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 3420 */       for (int i = 0; i < this.indices2.length; i++) {
/* 3421 */         if (this.indices2[i].equals(reg)) {
/* 3422 */           return true;
/*      */         }
/*      */       } 
/* 3425 */       return false;
/*      */     } }
/*      */   class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*      */     String[] indices;
/*      */     
/*      */     CeldaRender2() {
/* 3431 */       this.otro = -1;
/* 3432 */       this.indices = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3435 */       setEnabled((table == null || table.isEnabled()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3444 */       if (row % 2 == 0) {
/* 3445 */         setBackground(new Color(194, 213, 151));
/* 3446 */         setForeground(Color.black);
/*      */       } else {
/* 3448 */         setBackground((Color)null);
/* 3449 */         setForeground(Color.black);
/*      */       } 
/* 3451 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3452 */       return this;
/*      */     } }
/*      */   class CeldaRender3 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2;
/*      */     String[] indices3;
/*      */     
/*      */     CeldaRender3() {
/* 3458 */       this.otro = -1;
/* 3459 */       this.indices = new String[0];
/* 3460 */       this.indices2 = new String[0];
/* 3461 */       this.indices3 = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3464 */       setEnabled((table == null || table.isEnabled()));
/* 3465 */       String comp = String.valueOf(table.getValueAt(row, 0));
/*      */       
/* 3467 */       if (comparar(comp)) {
/* 3468 */         setBackground((Color)null);
/* 3469 */         setForeground(Color.BLUE);
/* 3470 */         setHorizontalAlignment(2);
/* 3471 */       } else if (comparar2(comp)) {
/* 3472 */         setBackground(Color.LIGHT_GRAY);
/* 3473 */         setForeground(Color.red);
/* 3474 */         setHorizontalAlignment(2);
/* 3475 */       } else if (comparar3(comp)) {
/* 3476 */         setBackground((Color)null);
/* 3477 */         setForeground(Color.RED);
/* 3478 */         setHorizontalAlignment(2);
/*      */       } else {
/* 3480 */         setBackground((Color)null);
/* 3481 */         setForeground(Color.black);
/* 3482 */         setHorizontalAlignment(2);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3489 */       if (column == 5 || column == 6 || column == 7) {
/* 3490 */         setHorizontalAlignment(4);
/*      */       }
/* 3492 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3493 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 3497 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 3501 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 3505 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 3509 */       for (int i = 0; i < this.indices.length; i++) {
/* 3510 */         if (this.indices[i].equals(reg)) {
/* 3511 */           return true;
/*      */         }
/*      */       } 
/* 3514 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 3518 */       for (int i = 0; i < this.indices2.length; i++) {
/* 3519 */         if (this.indices2[i].equals(reg)) {
/* 3520 */           return true;
/*      */         }
/*      */       } 
/* 3523 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 3527 */       for (int i = 0; i < this.indices3.length; i++) {
/* 3528 */         if (this.indices3[i].equals(reg)) {
/* 3529 */           return true;
/*      */         }
/*      */       } 
/* 3532 */       return false;
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   public void desactivarFiltroOperadores() {
/* 3538 */     if (this.PRIVILEGIOS.equals("SUPER USUARIO") || this.USUARIO.equals("PILAR1196") || this.USUARIO.equals("UZZIEL")) {
/* 3539 */       this.jComboBox3.setSelectedIndex(0);
/* 3540 */       this.jComboBox3.setEnabled(true);
/*      */     } else {
/*      */       
/* 3543 */       this.jComboBox3.setSelectedIndex(1);
/* 3544 */       this.jComboBox3.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verTarjeta() {
/* 3549 */     String estatus = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6));
/* 3550 */     if (!estatus.equals("<ACTIVA>")) {
/* 3551 */       this.jButton5.setEnabled(false);
/* 3552 */       this.jButton6.setEnabled(false);
/* 3553 */       this.jButton7.setEnabled(false);
/*      */     } else {
/* 3555 */       this.jButton5.setEnabled(true);
/* 3556 */       this.jButton6.setEnabled(true);
/* 3557 */       this.jButton7.setEnabled(true);
/* 3558 */       if (this.PRIVILEGIOS.equals("JEFE DE FACTURACIÓN") || this.PRIVILEGIOS.equals("SUPER USUARIO")) {
/* 3559 */         this.jButton5.setEnabled(true);
/* 3560 */         this.jButton6.setEnabled(true);
/* 3561 */         this.jButton7.setEnabled(true);
/*      */       } else {
/* 3563 */         this.jButton6.setEnabled(false);
/* 3564 */         this.jButton7.setEnabled(false);
/*      */       } 
/*      */     } 
/* 3567 */     this.CLAVEOP = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/* 3568 */     this.jLabel62.setText("TARJETA DE " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1)));
/* 3569 */     this.ACTIVARCONSULTA = false;
/* 3570 */     consultar3();
/* 3571 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 3575 */     this.con.consultar("max(mov)", "tarjeta_contenido", "");
/* 3576 */     String mayor = this.con.Campo;
/* 3577 */     int MAYOR = 0;
/*      */     try {
/* 3579 */       MAYOR = Integer.parseInt(mayor);
/* 3580 */     } catch (NumberFormatException e) {
/* 3581 */       MAYOR = 0;
/*      */     } 
/* 3583 */     MAYOR++;
/* 3584 */     if (MAYOR < 10) {
/* 3585 */       this.jTextField10.setText(this.DIRECTIVAS + "-0000" + this.DIRECTIVAS);
/* 3586 */       this.jTextField14.setText(this.DIRECTIVAS + "-0000" + this.DIRECTIVAS);
/* 3587 */     } else if (MAYOR < 100) {
/* 3588 */       this.jTextField10.setText(this.DIRECTIVAS + "-000" + this.DIRECTIVAS);
/* 3589 */       this.jTextField14.setText(this.DIRECTIVAS + "-000" + this.DIRECTIVAS);
/* 3590 */     } else if (MAYOR < 1000) {
/* 3591 */       this.jTextField10.setText(this.DIRECTIVAS + "-00" + this.DIRECTIVAS);
/* 3592 */       this.jTextField14.setText(this.DIRECTIVAS + "-00" + this.DIRECTIVAS);
/* 3593 */     } else if (MAYOR < 10000) {
/* 3594 */       this.jTextField10.setText(this.DIRECTIVAS + "-0" + this.DIRECTIVAS);
/* 3595 */       this.jTextField14.setText(this.DIRECTIVAS + "-0" + this.DIRECTIVAS);
/*      */     } else {
/* 3597 */       this.jTextField10.setText(this.DIRECTIVAS + "-" + this.DIRECTIVAS);
/* 3598 */       this.jTextField14.setText(this.DIRECTIVAS + "-" + this.DIRECTIVAS);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void cargarFechaHoy() {
/* 3603 */     Calendar ahoraCal = Calendar.getInstance();
/* 3604 */     ahoraCal.setTime(this.fecha);
/* 3605 */     String mesesito = "";
/* 3606 */     String hoy = "";
/* 3607 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 3608 */     hoy = "" + ahoraCal.get(5);
/* 3609 */     if (ahoraCal.get(2) + 1 < 10) {
/* 3610 */       mesesito = "0" + mesesito;
/*      */     }
/* 3612 */     if (ahoraCal.get(5) < 10) {
/* 3613 */       hoy = "0" + hoy;
/*      */     }
/* 3615 */     this.jTextField8.setText(hoy + "/" + hoy + "/" + mesesito);
/* 3616 */     this.jTextField11.setText(hoy + "/" + hoy + "/" + mesesito);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public class ImprimirCargo
/*      */     implements Printable
/*      */   {
/*      */     String[] DATOS;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int opc;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ImprimirCargo()
/*      */     {
/* 3862 */       this.DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/* 3863 */       this.opc = 0; } public int print(Graphics g, PageFormat f, int pageIndex) {
/*      */       Font fuente;
/* 3865 */       Graphics2D g2 = (Graphics2D)g;
/* 3866 */       f.setOrientation(0);
/* 3867 */       switch (pageIndex) {
/*      */         case 0:
/* 3869 */           fuente = new Font("Dialog", 1, 12);
/* 3870 */           g.setFont(fuente);
/* 3871 */           g2.drawString("FLETES Y MATERIALES", 74, 35);
/* 3872 */           g2.drawString("GRUPO FORSIS S.A. DE C.V.", 61, 49);
/* 3873 */           fuente = new Font("Dialog", 1, 9);
/* 3874 */           g.setFont(fuente);
/* 3875 */           g2.drawString("FOLIO", 82, 67);
/* 3876 */           g2.drawString("FECHA", 175, 67);
/* 3877 */           fuente = new Font("Dialog", 1, 11);
/* 3878 */           g.setFont(fuente);
/* 3879 */           g2.drawString("ACUSE DE RECIBIDO", 90, 115);
/*      */           
/* 3881 */           g2.drawRect(20, 20, 750, 360);
/* 3882 */           g2.drawLine(270, 20, 270, 380);
/* 3883 */           g2.drawLine(519, 20, 519, 380);
/* 3884 */           g2.drawRect(52, 57, 90, 33);
/* 3885 */           g2.drawRect(146, 57, 90, 33);
/* 3886 */           g2.drawLine(52, 70, 142, 70);
/* 3887 */           g2.drawLine(147, 70, 236, 70);
/* 3888 */           g2.drawLine(23, 125, 266, 125);
/* 3889 */           g2.drawLine(23, 128, 266, 128);
/* 3890 */           fuente = new Font("Dialog", 0, 8);
/* 3891 */           g.setFont(fuente);
/* 3892 */           g2.drawString("Recibí de _______________________________________________", 23, 150);
/* 3893 */           g2.drawString("_______________________________________________________", 23, 170);
/* 3894 */           g2.drawString("N.S.S. _________________________________________________", 23, 190);
/* 3895 */           g2.drawString("Cantidad _______________________________________________", 23, 210);
/* 3896 */           g2.drawString("(______________________________________________________)", 23, 230);
/*      */ 
/*      */           
/* 3899 */           g2.drawString("                 Como retención para su abono en su crédito de", 23, 265);
/* 3900 */           g2.drawString("             __________________________________", 85, 280);
/*      */           
/* 3902 */           g2.drawString("               Recibido                                               Documentó        ", 23, 315);
/* 3903 */           g2.drawString("  _____________________                     _____________________", 23, 350);
/* 3904 */           fuente = new Font("Dialog", 0, 7);
/* 3905 */           g2.setFont(fuente);
/* 3906 */           g2.drawString("ARCHIVO", 229, 375);
/*      */           
/* 3908 */           fuente = new Font("Dialog", 1, 12);
/* 3909 */           g.setFont(fuente);
/* 3910 */           g2.drawString(this.DATOS[0], 70, 84);
/* 3911 */           g2.drawString(this.DATOS[1], 161, 84);
/* 3912 */           fuente = new Font("Dialog", 0, 9);
/* 3913 */           g.setFont(fuente);
/* 3914 */           g2.drawString("                " + this.DATOS[2], 23, 150);
/* 3915 */           g2.drawString(" " + this.DATOS[3], 23, 170);
/* 3916 */           g2.drawString("           " + this.DATOS[4], 23, 190);
/* 3917 */           g2.drawString("               " + this.DATOS[5], 23, 210);
/*      */           
/* 3919 */           g2.drawString("                     Pago de " + this.DATOS[7] + " al " + this.DATOS[8], 23, 245);
/*      */           
/* 3921 */           g2.drawString(this.DATOS[10], 23, 280);
/* 3922 */           g2.drawString("             " + this.DATOS[11], 85, 280);
/* 3923 */           fuente = new Font("Dialog", 0, 8);
/* 3924 */           g.setFont(fuente);
/* 3925 */           g2.drawString("  " + this.DATOS[6], 23, 230);
/*      */ 
/*      */           
/* 3928 */           fuente = new Font("Dialog", 1, 12);
/* 3929 */           g.setFont(fuente);
/* 3930 */           g2.drawString("FLETES Y MATERIALES", 324, 35);
/* 3931 */           g2.drawString("GRUPO FORSIS S.A. DE C.V.", 311, 49);
/* 3932 */           fuente = new Font("Dialog", 1, 9);
/* 3933 */           g.setFont(fuente);
/* 3934 */           g2.drawString("FOLIO", 332, 67);
/* 3935 */           g2.drawString("FECHA", 425, 67);
/* 3936 */           fuente = new Font("Dialog", 1, 11);
/* 3937 */           g.setFont(fuente);
/* 3938 */           g2.drawString("ACUSE DE RECIBIDO", 340, 115);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3943 */           g2.drawRect(302, 57, 90, 33);
/* 3944 */           g2.drawRect(396, 57, 90, 33);
/* 3945 */           g2.drawLine(302, 70, 392, 70);
/* 3946 */           g2.drawLine(397, 70, 486, 70);
/* 3947 */           g2.drawLine(273, 125, 516, 125);
/* 3948 */           g2.drawLine(273, 128, 516, 128);
/* 3949 */           fuente = new Font("Dialog", 0, 8);
/* 3950 */           g.setFont(fuente);
/* 3951 */           g2.drawString("Recibí de _______________________________________________", 273, 150);
/* 3952 */           g2.drawString("_______________________________________________________", 273, 170);
/* 3953 */           g2.drawString("N.S.S. _________________________________________________", 273, 190);
/* 3954 */           g2.drawString("Cantidad _______________________________________________", 273, 210);
/* 3955 */           g2.drawString("(______________________________________________________)", 273, 230);
/*      */           
/* 3957 */           g2.drawString("                 Como retención para su abono en su crédito de", 273, 265);
/* 3958 */           g2.drawString("             __________________________________", 335, 280);
/*      */           
/* 3960 */           g2.drawString("               Recibido                                               Documentó        ", 273, 315);
/* 3961 */           g2.drawString("  _____________________                     _____________________", 273, 350);
/* 3962 */           fuente = new Font("Dialog", 0, 7);
/* 3963 */           g2.setFont(fuente);
/* 3964 */           g2.drawString("EXPEDIENTE", 469, 375);
/*      */ 
/*      */           
/* 3967 */           fuente = new Font("Dialog", 1, 12);
/* 3968 */           g.setFont(fuente);
/* 3969 */           g2.drawString(this.DATOS[0], 320, 84);
/* 3970 */           g2.drawString(this.DATOS[1], 411, 84);
/* 3971 */           fuente = new Font("Dialog", 0, 9);
/* 3972 */           g.setFont(fuente);
/* 3973 */           g2.drawString("                " + this.DATOS[2], 273, 150);
/* 3974 */           g2.drawString(" " + this.DATOS[3], 273, 170);
/* 3975 */           g2.drawString("           " + this.DATOS[4], 273, 190);
/* 3976 */           g2.drawString("               " + this.DATOS[5], 273, 210);
/*      */           
/* 3978 */           g2.drawString("                     Pago de " + this.DATOS[7] + " al " + this.DATOS[8], 273, 245);
/*      */           
/* 3980 */           g2.drawString(this.DATOS[10], 273, 280);
/* 3981 */           g2.drawString("             " + this.DATOS[11], 335, 280);
/* 3982 */           fuente = new Font("Dialog", 0, 8);
/* 3983 */           g.setFont(fuente);
/* 3984 */           g2.drawString("  " + this.DATOS[6], 273, 230);
/*      */ 
/*      */           
/* 3987 */           fuente = new Font("Dialog", 1, 12);
/* 3988 */           g.setFont(fuente);
/* 3989 */           g2.drawString("FLETES Y MATERIALES", 574, 35);
/* 3990 */           g2.drawString("GRUPO FORSIS S.A. DE C.V.", 561, 49);
/* 3991 */           fuente = new Font("Dialog", 1, 9);
/* 3992 */           g.setFont(fuente);
/* 3993 */           g2.drawString("FOLIO", 582, 67);
/* 3994 */           g2.drawString("FECHA", 675, 67);
/* 3995 */           fuente = new Font("Dialog", 1, 11);
/* 3996 */           g.setFont(fuente);
/* 3997 */           g2.drawString("ACUSE DE RECIBIDO", 590, 115);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4002 */           g2.drawRect(552, 57, 90, 33);
/* 4003 */           g2.drawRect(646, 57, 90, 33);
/* 4004 */           g2.drawLine(552, 70, 642, 70);
/* 4005 */           g2.drawLine(647, 70, 736, 70);
/* 4006 */           g2.drawLine(523, 125, 766, 125);
/* 4007 */           g2.drawLine(523, 128, 766, 128);
/* 4008 */           fuente = new Font("Dialog", 0, 8);
/* 4009 */           g.setFont(fuente);
/* 4010 */           g2.drawString("Recibí de _______________________________________________", 523, 150);
/* 4011 */           g2.drawString("_______________________________________________________", 523, 170);
/* 4012 */           g2.drawString("N.S.S. _________________________________________________", 523, 190);
/* 4013 */           g2.drawString("Cantidad _______________________________________________", 523, 210);
/* 4014 */           g2.drawString("(______________________________________________________)", 523, 230);
/*      */ 
/*      */           
/* 4017 */           g2.drawString("                 Como retención para su abono en su crédito de", 523, 265);
/* 4018 */           g2.drawString("             __________________________________", 585, 280);
/*      */           
/* 4020 */           g2.drawString("               Recibido                                               Documentó        ", 523, 315);
/* 4021 */           g2.drawString("  _____________________                     _____________________", 523, 350);
/* 4022 */           fuente = new Font("Dialog", 0, 7);
/* 4023 */           g2.setFont(fuente);
/* 4024 */           g2.drawString("TRABAJADOR", 717, 375);
/*      */ 
/*      */           
/* 4027 */           fuente = new Font("Dialog", 1, 12);
/* 4028 */           g.setFont(fuente);
/* 4029 */           g2.drawString(this.DATOS[0], 570, 84);
/* 4030 */           g2.drawString(this.DATOS[1], 661, 84);
/* 4031 */           fuente = new Font("Dialog", 0, 9);
/* 4032 */           g.setFont(fuente);
/* 4033 */           g2.drawString("                " + this.DATOS[2], 523, 150);
/* 4034 */           g2.drawString(" " + this.DATOS[3], 523, 170);
/* 4035 */           g2.drawString("           " + this.DATOS[4], 523, 190);
/* 4036 */           g2.drawString("               " + this.DATOS[5], 523, 210);
/*      */           
/* 4038 */           g2.drawString("                     Pago de " + this.DATOS[7] + " al " + this.DATOS[8], 523, 245);
/*      */           
/* 4040 */           g2.drawString(this.DATOS[10], 523, 280);
/* 4041 */           g2.drawString("             " + this.DATOS[11], 585, 280);
/* 4042 */           fuente = new Font("Dialog", 0, 8);
/* 4043 */           g.setFont(fuente);
/* 4044 */           g2.drawString("  " + this.DATOS[6], 523, 230);
/*      */           
/* 4046 */           return 0;
/* 4047 */       }  return 1;
/*      */     }
/*      */     
/*      */     public void recibeDatos(String[] datos) {
/* 4051 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 4052 */       job.setPrintable(this);
/*      */       
/* 4054 */       PageFormat pf = job.defaultPage();
/* 4055 */       Paper papel = pf.getPaper();
/* 4056 */       papel.setSize(612.0D, 792.0D);
/* 4057 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 4058 */       pf.setPaper(papel);
/* 4059 */       pf.setOrientation(0);
/* 4060 */       ImprimirCargo im = new ImprimirCargo();
/* 4061 */       im.DATOS = datos;
/* 4062 */       job.setPrintable(im, pf);
/* 4063 */       job.defaultPage(pf);
/*      */       
/* 4065 */       boolean ok = job.printDialog();
/* 4066 */       if (ok)
/*      */         try {
/* 4068 */           job.print();
/*      */         }
/* 4070 */         catch (PrinterException printerException) {} 
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/TarjetasDeudoras.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */