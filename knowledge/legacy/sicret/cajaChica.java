/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JDialog;
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
/*      */ import javax.swing.text.NumberFormatter;
/*      */ 
/*      */ public class cajaChica extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   42 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   43 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   44 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   45 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   46 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   47 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   48 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   49 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   50 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   String USUARIO;
/*   52 */   Validaciones val = new Validaciones();
/*   53 */   Consultas con = new Consultas();
/*   54 */   Errores error = new Errores(false);
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   AltaOperador operador;
/*   58 */   int contador = 0;
/*      */   JFrame padre;
/*      */   EscribirReporte esc;
/*   61 */   Date fechaActual = new Date();
/*   62 */   Date fecha = new Date();
/*   63 */   Date fechaInicio = null;
/*   64 */   Date fechaTermino = null;
/*   65 */   Date fechaMinimo = null;
/*   66 */   String FECHAIMP = "";
/*   67 */   CeldaRender celda = new CeldaRender();
/*   68 */   CeldaRender2 celda2 = new CeldaRender2();
/*      */   
/*   70 */   String CLAVEOP = "";
/*      */   String[] operadores;
/*   72 */   String NOMBRE = "";
/*   73 */   String[] GUIAS = new String[10];
/*   74 */   String CLAVE = "";
/*      */   boolean CONCEPTO = false;
/*   76 */   int INDICE = 0;
/*      */   String[] DIRECTIVAS;
/*      */   String[] NOMBRES;
/*   79 */   NumerosALetras numLetra = null;
/*   80 */   int VALOR = 0;
/*   81 */   double SALDOACTUAL = 0.0D;
/*   82 */   String FOLIOREPO = "";
/*   83 */   double MONTO = 0.0D;
/*   84 */   String USUARIOIMP = "";
/*   85 */   String USUARIOCHEQUE = "";
/*   86 */   String fechaCompleta1 = "";
/*   87 */   int vecesMal = 0;
/*   88 */   String DEPARTAMENTO = "";
/*   89 */   MensajePop mensajeTry = null;
/*   90 */   String USUARIOCANCEL = ""; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private ButtonGroup buttonGroup3; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton26; private JButton jButton27; private JButton jButton29; private JButton jButton3; private JButton jButton30; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JComboBox jComboBox2; private JDateChooser jDateChooser5; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5;
/*      */   private JLabel jLabel50;
/*      */   private JLabel jLabel51;
/*      */   private JLabel jLabel52;
/*      */   
/*      */   public cajaChica(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*   96 */     this.mensajeTry = mensajeTry;
/*   97 */     String año = "2010";
/*   98 */     String mes = "03";
/*   99 */     String dia = "01";
/*  100 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  101 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  103 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  104 */     } catch (ParseException ex) {
/*  105 */       ex.printStackTrace();
/*      */     } 
/*  107 */     this.padre = padre;
/*  108 */     this.fichas = fichas;
/*  109 */     initComponents();
/*  110 */     this.USUARIO = USUARIO;
/*  111 */     panelito.setViewportView(this);
/*  112 */     this.panel = panelito;
/*  113 */     initComponents();
/*      */     
/*  115 */     this.buttonGroup1.add(this.jRadioButton1);
/*  116 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*  118 */     this.buttonGroup2.add(this.jRadioButton3);
/*  119 */     this.buttonGroup2.add(this.jRadioButton4);
/*  120 */     this.buttonGroup2.add(this.jRadioButton5);
/*      */     
/*  122 */     this.buttonGroup3.add(this.jRadioButton6);
/*  123 */     this.buttonGroup3.add(this.jRadioButton7);
/*  124 */     int w = this.tama.width;
/*  125 */     int h = this.tama.height;
/*  126 */     int rw = (w - 390) / 2;
/*  127 */     int rh = (h - 535) / 2;
/*  128 */     this.jDialog1.setLocation(rw, rh);
/*  129 */     this.jDialog1.setSize(390, 535);
/*  130 */     this.jDialog1.setVisible(false);
/*  131 */     this.jDialog1.setResizable(false);
/*      */     
/*  133 */     rw = (w - 420) / 2;
/*  134 */     rh = (h - 390) / 2;
/*  135 */     this.jDialog2.setLocation(rw, rh);
/*  136 */     this.jDialog2.setSize(420, 370);
/*  137 */     this.jDialog2.setVisible(false);
/*  138 */     this.jDialog2.setResizable(false);
/*  139 */     colorear();
/*      */     
/*  141 */     rw = (w - 780) / 2;
/*  142 */     rh = (h - 410) / 2;
/*  143 */     this.jDialog3.setLocation(rw, rh);
/*  144 */     this.jDialog3.setSize(780, 410);
/*  145 */     this.jDialog3.setVisible(false);
/*  146 */     this.jDialog3.setResizable(false);
/*      */     
/*  148 */     rw = (w - 300) / 2;
/*  149 */     rh = (h - 135) / 2;
/*  150 */     this.jDialog4.setLocation(rw, rh);
/*  151 */     this.jDialog4.setSize(300, 135);
/*  152 */     this.jDialog4.setVisible(false);
/*  153 */     this.jDialog4.setResizable(false);
/*      */     
/*  155 */     rw = (w - 460) / 2;
/*  156 */     rh = (h - 355) / 2;
/*      */     
/*  158 */     this.jDialog5.setLocation(rw, rh);
/*  159 */     this.jDialog5.setSize(460, 355);
/*  160 */     this.jDialog5.setVisible(false);
/*  161 */     this.jDialog5.setResizable(false);
/*      */     
/*  163 */     rw = (w - 920) / 2;
/*  164 */     rh = (h - 555) / 2;
/*  165 */     this.jDialog6.setLocation(rw, rh);
/*  166 */     this.jDialog6.setSize(920, 555);
/*  167 */     this.jDialog6.setVisible(false);
/*  168 */     this.jDialog6.setResizable(false);
/*      */     
/*  170 */     rw = (w - 300) / 2;
/*  171 */     rh = (h - 290) / 2;
/*  172 */     this.jDialog7.setLocation(rw, rh);
/*  173 */     this.jDialog7.setSize(300, 280);
/*  174 */     this.jDialog7.setResizable(false);
/*      */     
/*  176 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  177 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  178 */     editFormat.setGroupingUsed(false);
/*  179 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  180 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  181 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  182 */     enFormat.setAllowsInvalid(true);
/*  183 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  184 */     this.jFormattedTextField2.setFormatterFactory(currFactory);
/*      */     
/*  186 */     this.USUARIO = USUARIO;
/*  187 */     String[] dat = this.con.regresaReg("empleados.nombre,empleados.ap_pat,empleados.ap_mat,usuarios.priv", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + USUARIO + "'", 4);
/*  188 */     this.NOMBRE = dat[0] + " " + dat[0] + " " + dat[1];
/*  189 */     this.DEPARTAMENTO = dat[3];
/*      */     
/*  191 */     consultar();
/*  192 */     llenarCombos();
/*  193 */     sacarSaldos();
/*      */     
/*  195 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  196 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  197 */     this.jLabel8.setCursor(micursor);
/*  198 */     this.jLabel40.setCursor(micursor);
/*  199 */     this.jLabel37.setCursor(micursor);
/*  200 */     this.jLabel44.setCursor(micursor);
/*      */     
/*  202 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  203 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  204 */     this.jDialog1.setCursor(micursor);
/*  205 */     this.jDialog2.setCursor(micursor);
/*  206 */     this.jDialog3.setCursor(micursor);
/*  207 */     this.jDialog4.setCursor(micursor);
/*  208 */     this.jDialog5.setCursor(micursor);
/*  209 */     this.jDialog6.setCursor(micursor);
/*  210 */     this.jDialog7.setCursor(micursor);
/*      */     
/*  212 */     this.DIRECTIVAS = this.con.regresaReg("directiva,gastosLetra,gastos", "configuraciones", "", 3);
/*  213 */     this.VALOR = Integer.parseInt(this.DIRECTIVAS[2]);
/*  214 */     this.jFormattedTextField1.setValue(Integer.valueOf(this.VALOR));
/*      */ 
/*      */     
/*  217 */     if (this.con.Campo.equals("LIQUIDACIONES")) {
/*  218 */       this.jComboBox2.setSelectedItem(this.NOMBRE);
/*  219 */       this.jComboBox2.setEnabled(false);
/*      */     } else {
/*  221 */       this.jComboBox2.setSelectedIndex(0);
/*  222 */       this.jComboBox2.setEnabled(true);
/*      */     } 
/*  224 */     cargarFechaHoy();
/*      */   }
/*      */   private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel15; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JPasswordField jPasswordField1; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5; private JRadioButton jRadioButton6; private JRadioButton jRadioButton7; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JSeparator jSeparator1; private JSeparator jSeparator10; private JSeparator jSeparator11; private JSeparator jSeparator12; private JSeparator jSeparator13; private JSeparator jSeparator2; private JSeparator jSeparator3; private JSeparator jSeparator4; private JSeparator jSeparator5; private JSeparator jSeparator7; private JSeparator jSeparator8; private JSeparator jSeparator9; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTable jTable4; private JTextArea jTextArea1; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9;
/*      */   
/*      */   private void initComponents() {
/*  229 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  230 */     this.jPanel8 = new JPanel();
/*  231 */     this.jSeparator3 = new JSeparator();
/*  232 */     this.jLabel63 = new JLabel();
/*  233 */     this.jTextField4 = new JTextField();
/*  234 */     this.jLabel64 = new JLabel();
/*  235 */     this.jTextField5 = new JTextField();
/*  236 */     this.jLabel65 = new JLabel();
/*  237 */     this.jTextField6 = new JTextField();
/*  238 */     this.jButton5 = new JButton();
/*  239 */     this.jPanel3 = new JPanel();
/*  240 */     this.jRadioButton3 = new JRadioButton();
/*  241 */     this.jRadioButton4 = new JRadioButton();
/*  242 */     this.jRadioButton5 = new JRadioButton();
/*  243 */     this.jTextField7 = new JTextField();
/*  244 */     this.jRadioButton6 = new JRadioButton();
/*  245 */     this.jRadioButton7 = new JRadioButton();
/*  246 */     this.jLabel66 = new JLabel();
/*  247 */     this.jLabel67 = new JLabel();
/*  248 */     this.jTextField9 = new JTextField();
/*  249 */     this.jLabel68 = new JLabel();
/*  250 */     this.jScrollPane2 = new JScrollPane();
/*  251 */     this.jTextArea1 = new JTextArea();
/*  252 */     this.jButton7 = new JButton();
/*  253 */     this.jButton8 = new JButton();
/*  254 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  255 */     this.jLabel8 = new JLabel();
/*  256 */     this.jTextField13 = new JTextField();
/*  257 */     this.jLabel72 = new JLabel();
/*  258 */     this.jTextField15 = new JTextField();
/*  259 */     this.jLabel73 = new JLabel();
/*  260 */     this.buttonGroup1 = new ButtonGroup();
/*  261 */     this.buttonGroup2 = new ButtonGroup();
/*  262 */     this.buttonGroup3 = new ButtonGroup();
/*  263 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  264 */     this.jPanel7 = new JPanel();
/*  265 */     this.jPanel36 = new JPanel();
/*  266 */     this.jScrollPane3 = new JScrollPane();
/*  267 */     this.jTable3 = new JTable();
/*  268 */     this.jButton20 = new JButton();
/*  269 */     this.jButton21 = new JButton();
/*  270 */     this.jLabel58 = new JLabel();
/*  271 */     this.jTextField10 = new JTextField();
/*  272 */     this.jLabel61 = new JLabel();
/*  273 */     this.jTextField11 = new JTextField();
/*  274 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  275 */     this.jPanel9 = new JPanel();
/*  276 */     this.jLabel59 = new JLabel();
/*  277 */     this.jPanel37 = new JPanel();
/*  278 */     this.jScrollPane4 = new JScrollPane();
/*  279 */     this.jTable4 = new JTable();
/*  280 */     this.jLabel60 = new JLabel();
/*  281 */     this.jTextField12 = new JTextField();
/*  282 */     this.jLabel69 = new JLabel();
/*  283 */     this.jComboBox2 = new JComboBox();
/*  284 */     this.jSeparator7 = new JSeparator();
/*  285 */     this.jButton22 = new JButton();
/*  286 */     this.jButton23 = new JButton();
/*  287 */     this.jButton27 = new JButton();
/*  288 */     this.jButton26 = new JButton();
/*  289 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  290 */     this.jPanel10 = new JPanel();
/*  291 */     this.jLabel70 = new JLabel();
/*  292 */     this.jSeparator4 = new JSeparator();
/*  293 */     this.jLabel71 = new JLabel();
/*  294 */     this.jTextField14 = new JTextField();
/*  295 */     this.jButton11 = new JButton();
/*  296 */     this.jButton12 = new JButton();
/*  297 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  298 */     this.jPanel11 = new JPanel();
/*  299 */     this.jLabel74 = new JLabel();
/*  300 */     this.jSeparator5 = new JSeparator();
/*  301 */     this.jPanel2 = new JPanel();
/*  302 */     this.jLabel10 = new JLabel();
/*  303 */     this.jLabel11 = new JLabel();
/*  304 */     this.jLabel12 = new JLabel();
/*  305 */     this.jLabel13 = new JLabel();
/*  306 */     this.jLabel14 = new JLabel();
/*  307 */     this.jLabel18 = new JLabel();
/*  308 */     this.jSeparator8 = new JSeparator();
/*  309 */     this.jLabel23 = new JLabel();
/*  310 */     this.jLabel24 = new JLabel();
/*  311 */     this.jLabel9 = new JLabel();
/*  312 */     this.jPanel4 = new JPanel();
/*  313 */     this.jLabel19 = new JLabel();
/*  314 */     this.jLabel20 = new JLabel();
/*  315 */     this.jLabel21 = new JLabel();
/*  316 */     this.jLabel22 = new JLabel();
/*  317 */     this.jButton6 = new JButton();
/*  318 */     this.jButton10 = new JButton();
/*  319 */     this.jPanel5 = new JPanel();
/*  320 */     this.jLabel25 = new JLabel();
/*  321 */     this.jTextField2 = new JTextField();
/*  322 */     this.jLabel26 = new JLabel();
/*  323 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  324 */     this.jLabel27 = new JLabel();
/*  325 */     this.jTextField8 = new JTextField();
/*  326 */     this.jLabel33 = new JLabel();
/*  327 */     this.jLabel28 = new JLabel();
/*  328 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  329 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  330 */     this.jPanel12 = new JPanel();
/*  331 */     this.jLabel75 = new JLabel();
/*  332 */     this.jLabel29 = new JLabel();
/*  333 */     this.jSeparator9 = new JSeparator();
/*  334 */     this.jLabel30 = new JLabel();
/*  335 */     this.jLabel31 = new JLabel();
/*  336 */     this.jLabel32 = new JLabel();
/*  337 */     this.jLabel34 = new JLabel();
/*  338 */     this.jLabel35 = new JLabel();
/*  339 */     this.jLabel36 = new JLabel();
/*  340 */     this.jSeparator10 = new JSeparator();
/*  341 */     this.jScrollPane5 = new JScrollPane();
/*  342 */     this.jTable2 = new JTable();
/*  343 */     this.jLabel37 = new JLabel();
/*  344 */     this.jLabel38 = new JLabel();
/*  345 */     this.jLabel39 = new JLabel();
/*  346 */     this.jLabel40 = new JLabel();
/*  347 */     this.jLabel41 = new JLabel();
/*  348 */     this.jSeparator11 = new JSeparator();
/*  349 */     this.jLabel42 = new JLabel();
/*  350 */     this.jSeparator12 = new JSeparator();
/*  351 */     this.jLabel43 = new JLabel();
/*  352 */     this.jLabel44 = new JLabel();
/*  353 */     this.jLabel45 = new JLabel();
/*  354 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  355 */     this.jPanel15 = new JPanel();
/*  356 */     this.jLabel46 = new JLabel();
/*  357 */     this.jLabel47 = new JLabel();
/*  358 */     this.jLabel49 = new JLabel();
/*  359 */     this.jPanel13 = new JPanel();
/*  360 */     this.jLabel50 = new JLabel();
/*  361 */     this.jTextField16 = new JTextField();
/*  362 */     this.jLabel51 = new JLabel();
/*  363 */     this.jPasswordField1 = new JPasswordField();
/*  364 */     this.jButton30 = new JButton();
/*  365 */     this.jButton29 = new JButton();
/*  366 */     this.jLabel52 = new JLabel();
/*  367 */     this.jSeparator13 = new JSeparator();
/*  368 */     this.jPanel6 = new JPanel();
/*  369 */     this.jLabel3 = new JLabel();
/*  370 */     this.jSeparator1 = new JSeparator();
/*  371 */     this.jScrollPane1 = new JScrollPane();
/*  372 */     this.jTable1 = new JTable();
/*  373 */     this.jRadioButton1 = new JRadioButton();
/*  374 */     this.jRadioButton2 = new JRadioButton();
/*  375 */     this.jLabel15 = new JLabel();
/*  376 */     this.jTextField1 = new JTextField();
/*  377 */     this.jLabel16 = new JLabel();
/*  378 */     this.jLabel17 = new JLabel();
/*  379 */     this.jTextField3 = new JTextField();
/*  380 */     this.jPanel1 = new JPanel();
/*  381 */     this.jLabel1 = new JLabel();
/*  382 */     this.jLabel2 = new JLabel();
/*  383 */     this.jSeparator2 = new JSeparator();
/*  384 */     this.jLabel4 = new JLabel();
/*  385 */     this.jLabel5 = new JLabel();
/*  386 */     this.jLabel6 = new JLabel();
/*  387 */     this.jLabel7 = new JLabel();
/*  388 */     this.jButton1 = new JButton();
/*  389 */     this.jButton2 = new JButton();
/*  390 */     this.jButton3 = new JButton();
/*  391 */     this.jLabel48 = new JLabel();
/*  392 */     this.jButton4 = new JButton();
/*  393 */     this.jComboBox1 = new JComboBox();
/*  394 */     this.jButton9 = new JButton();
/*      */     
/*  396 */     this.jDialog1.setTitle("Vale de Caja Chica");
/*  397 */     this.jDialog1.setModal(true);
/*      */     
/*  399 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*      */     
/*  401 */     this.jLabel63.setFont(new Font("Tahoma", 3, 11));
/*  402 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/*  403 */     this.jLabel63.setHorizontalAlignment(4);
/*  404 */     this.jLabel63.setText("Folio");
/*      */     
/*  406 */     this.jTextField4.setEditable(false);
/*  407 */     this.jTextField4.setFont(new Font("Tahoma", 1, 11));
/*  408 */     this.jTextField4.setForeground(Color.red);
/*  409 */     this.jTextField4.setText("PR-00001");
/*      */     
/*  411 */     this.jLabel64.setFont(new Font("Tahoma", 3, 11));
/*  412 */     this.jLabel64.setForeground(new Color(15, 87, 51));
/*  413 */     this.jLabel64.setHorizontalAlignment(4);
/*  414 */     this.jLabel64.setText("Fecha");
/*      */     
/*  416 */     this.jTextField5.setEditable(false);
/*  417 */     this.jTextField5.setFont(new Font("Tahoma", 1, 11));
/*  418 */     this.jTextField5.setForeground(Color.red);
/*  419 */     this.jTextField5.setText("26/04/2010");
/*      */     
/*  421 */     this.jLabel65.setFont(new Font("Tahoma", 3, 11));
/*  422 */     this.jLabel65.setForeground(new Color(15, 87, 51));
/*  423 */     this.jLabel65.setHorizontalAlignment(2);
/*  424 */     this.jLabel65.setText("A nombre de");
/*      */     
/*  426 */     this.jTextField6.setEditable(false);
/*  427 */     this.jTextField6.setFont(new Font("Tahoma", 1, 11));
/*  428 */     this.jTextField6.setForeground(Color.blue);
/*  429 */     this.jTextField6.setText("Hernández Hernández Aguilar");
/*      */     
/*  431 */     this.jButton5.setMnemonic('A');
/*  432 */     this.jButton5.setText("Cargar");
/*  433 */     this.jButton5.setToolTipText("Cargar Operador (Alt+A)");
/*  434 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  436 */             cajaChica.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  440 */     this.jPanel3.setBackground(new Color(146, 193, 134));
/*  441 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder("Concepto del Vale"));
/*      */     
/*  443 */     this.jRadioButton3.setSelected(true);
/*  444 */     this.jRadioButton3.setText("Gastos por Comprobar    (con cargo Directo)");
/*  445 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  447 */             cajaChica.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  451 */     this.jRadioButton4.setText("Préstamo Personal    (con cargo a T.D.)");
/*  452 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  454 */             cajaChica.this.jRadioButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  458 */     this.jRadioButton5.setText("Otro Concepto");
/*  459 */     this.jRadioButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  461 */             cajaChica.this.jRadioButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  465 */     this.jTextField7.setEditable(false);
/*      */     
/*  467 */     this.jRadioButton6.setSelected(true);
/*  468 */     this.jRadioButton6.setText("Cargo Directo");
/*  469 */     this.jRadioButton6.setEnabled(false);
/*      */     
/*  471 */     this.jRadioButton7.setText("Sin Cargo a T.D.");
/*  472 */     this.jRadioButton7.setEnabled(false);
/*      */     
/*  474 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  475 */     this.jPanel3.setLayout(jPanel3Layout);
/*  476 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  477 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  478 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  479 */           .addContainerGap()
/*  480 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  481 */             .addComponent(this.jRadioButton5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  482 */             .addComponent(this.jRadioButton4, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  483 */             .addComponent(this.jRadioButton3, GroupLayout.Alignment.LEADING, -2, 0, 32767)
/*  484 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
/*  485 */               .addGap(21, 21, 21)
/*  486 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  487 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  488 */                   .addComponent(this.jRadioButton6, -1, -1, 32767)
/*  489 */                   .addGap(18, 18, 18)
/*  490 */                   .addComponent(this.jRadioButton7, -2, 123, -2))
/*  491 */                 .addComponent(this.jTextField7))))
/*  492 */           .addContainerGap(-1, 32767)));
/*      */     
/*  494 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  495 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  496 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  497 */           .addComponent(this.jRadioButton3)
/*  498 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  499 */           .addComponent(this.jRadioButton4)
/*  500 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  501 */           .addComponent(this.jRadioButton5)
/*  502 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  503 */           .addComponent(this.jTextField7, -2, -1, -2)
/*  504 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  505 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  506 */             .addComponent(this.jRadioButton7)
/*  507 */             .addComponent(this.jRadioButton6))
/*  508 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  511 */     this.jLabel66.setFont(new Font("Tahoma", 3, 11));
/*  512 */     this.jLabel66.setForeground(new Color(15, 87, 51));
/*  513 */     this.jLabel66.setHorizontalAlignment(0);
/*  514 */     this.jLabel66.setText("Monto $");
/*      */     
/*  516 */     this.jLabel67.setFont(new Font("Tahoma", 2, 11));
/*  517 */     this.jLabel67.setForeground(new Color(15, 87, 51));
/*  518 */     this.jLabel67.setHorizontalAlignment(0);
/*  519 */     this.jLabel67.setText("Unidad");
/*      */     
/*  521 */     this.jTextField9.setFont(new Font("Tahoma", 1, 11));
/*  522 */     this.jTextField9.setForeground(Color.blue);
/*  523 */     this.jTextField9.setHorizontalAlignment(4);
/*  524 */     this.jTextField9.setText("399");
/*      */     
/*  526 */     this.jLabel68.setFont(new Font("Tahoma", 3, 11));
/*  527 */     this.jLabel68.setForeground(new Color(15, 87, 51));
/*  528 */     this.jLabel68.setText("Observaciones");
/*      */     
/*  530 */     this.jTextArea1.setColumns(10);
/*  531 */     this.jTextArea1.setFont(new Font("Tahoma", 0, 11));
/*  532 */     this.jTextArea1.setLineWrap(true);
/*  533 */     this.jTextArea1.setRows(5);
/*  534 */     this.jScrollPane2.setViewportView(this.jTextArea1);
/*      */     
/*  536 */     this.jButton7.setMnemonic('C');
/*  537 */     this.jButton7.setText("Cerrar");
/*  538 */     this.jButton7.setToolTipText("Cerrar (Alt+C)");
/*  539 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  541 */             cajaChica.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  545 */     this.jButton8.setMnemonic('I');
/*  546 */     this.jButton8.setText("Imprimir");
/*  547 */     this.jButton8.setToolTipText("Imprimir (Alt+I)");
/*  548 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  550 */             cajaChica.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  554 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/*  555 */     this.jFormattedTextField1.setText("$0.0");
/*      */     
/*  557 */     this.jLabel8.setFont(new Font("Tahoma", 3, 11));
/*  558 */     this.jLabel8.setForeground(Color.red);
/*  559 */     this.jLabel8.setText("<html><u>Click para ver el Estado</u></html>");
/*  560 */     this.jLabel8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  562 */             cajaChica.this.jLabel8MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  565 */             cajaChica.this.jLabel8MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  568 */             cajaChica.this.jLabel8MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  572 */     this.jTextField13.setFont(new Font("Tahoma", 1, 11));
/*  573 */     this.jTextField13.setForeground(Color.blue);
/*  574 */     this.jTextField13.setHorizontalAlignment(4);
/*  575 */     this.jTextField13.setText("399");
/*      */     
/*  577 */     this.jLabel72.setFont(new Font("Tahoma", 2, 11));
/*  578 */     this.jLabel72.setForeground(new Color(15, 87, 51));
/*  579 */     this.jLabel72.setHorizontalAlignment(0);
/*  580 */     this.jLabel72.setText("Rem 1");
/*      */     
/*  582 */     this.jTextField15.setFont(new Font("Tahoma", 1, 11));
/*  583 */     this.jTextField15.setForeground(Color.blue);
/*  584 */     this.jTextField15.setHorizontalAlignment(4);
/*  585 */     this.jTextField15.setText("399");
/*      */     
/*  587 */     this.jLabel73.setFont(new Font("Tahoma", 2, 11));
/*  588 */     this.jLabel73.setForeground(new Color(15, 87, 51));
/*  589 */     this.jLabel73.setHorizontalAlignment(0);
/*  590 */     this.jLabel73.setText("Rem 2");
/*      */     
/*  592 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  593 */     this.jPanel8.setLayout(jPanel8Layout);
/*  594 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  595 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  596 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  597 */           .addContainerGap()
/*  598 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  599 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  600 */               .addComponent(this.jScrollPane2)
/*  601 */               .addContainerGap())
/*  602 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  603 */               .addComponent(this.jPanel3, -1, -1, 32767)
/*  604 */               .addContainerGap())
/*  605 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  606 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  607 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
/*  608 */                   .addComponent(this.jLabel63, -2, 34, -2)
/*  609 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  610 */                   .addComponent(this.jTextField4, -2, 96, -2)
/*  611 */                   .addGap(18, 18, 18)
/*  612 */                   .addComponent(this.jLabel64, -2, 48, -2)
/*  613 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  614 */                   .addComponent(this.jTextField5, -2, 96, -2))
/*  615 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
/*  616 */                   .addComponent(this.jLabel65, -2, 75, -2)
/*  617 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  618 */                   .addComponent(this.jTextField6, -2, 202, -2)
/*  619 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  620 */                   .addComponent(this.jButton5))
/*  621 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
/*  622 */                   .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  623 */                     .addComponent(this.jLabel66, -2, 100, -2)
/*  624 */                     .addComponent(this.jFormattedTextField1, -2, 100, -2))
/*  625 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  626 */                   .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  627 */                     .addComponent(this.jLabel67, -1, -1, 32767)
/*  628 */                     .addComponent(this.jTextField9, -1, 71, 32767))
/*  629 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  630 */                   .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  631 */                     .addComponent(this.jLabel72, -1, -1, 32767)
/*  632 */                     .addComponent(this.jTextField13, -2, 71, -2))
/*  633 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  634 */                   .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  635 */                     .addComponent(this.jLabel73, -1, -1, 32767)
/*  636 */                     .addComponent(this.jTextField15, -2, 71, -2)))
/*  637 */                 .addComponent(this.jSeparator3, GroupLayout.Alignment.LEADING))
/*  638 */               .addContainerGap())
/*  639 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  640 */               .addComponent(this.jLabel68, -1, -1, 32767)
/*  641 */               .addGap(272, 272, 272))
/*  642 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/*  643 */               .addComponent(this.jLabel8)
/*  644 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  645 */               .addComponent(this.jButton8, -2, 86, -2)
/*  646 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  647 */               .addComponent(this.jButton7, -2, 86, -2)
/*  648 */               .addContainerGap()))));
/*      */     
/*  650 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  651 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  652 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  653 */           .addGap(23, 23, 23)
/*  654 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  655 */             .addComponent(this.jLabel63)
/*  656 */             .addComponent(this.jTextField4, -2, -1, -2)
/*  657 */             .addComponent(this.jLabel64)
/*  658 */             .addComponent(this.jTextField5, -2, -1, -2))
/*  659 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  660 */           .addComponent(this.jSeparator3, -2, 10, -2)
/*  661 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  662 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  663 */             .addComponent(this.jLabel65)
/*  664 */             .addComponent(this.jTextField6, -2, -1, -2)
/*  665 */             .addComponent(this.jButton5))
/*  666 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  667 */           .addComponent(this.jPanel3, -2, -1, -2)
/*  668 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  669 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  670 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  671 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  672 */                 .addGroup(jPanel8Layout.createSequentialGroup()
/*  673 */                   .addComponent(this.jLabel66)
/*  674 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  675 */                   .addComponent(this.jFormattedTextField1, -2, -1, -2))
/*  676 */                 .addGroup(jPanel8Layout.createSequentialGroup()
/*  677 */                   .addComponent(this.jLabel67)
/*  678 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  679 */                   .addComponent(this.jTextField9, -2, -1, -2)))
/*  680 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  681 */               .addComponent(this.jLabel68))
/*  682 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  683 */               .addComponent(this.jLabel72)
/*  684 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  685 */               .addComponent(this.jTextField13, -2, -1, -2))
/*  686 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  687 */               .addComponent(this.jLabel73)
/*  688 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  689 */               .addComponent(this.jTextField15, -2, -1, -2)))
/*  690 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  691 */           .addComponent(this.jScrollPane2, -1, 99, 32767)
/*  692 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  693 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  694 */             .addComponent(this.jButton7)
/*  695 */             .addComponent(this.jButton8)
/*  696 */             .addComponent(this.jLabel8, -2, -1, -2))
/*  697 */           .addContainerGap()));
/*      */ 
/*      */     
/*  700 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  701 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  702 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  703 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  704 */         .addComponent(this.jPanel8, -2, -1, -2));
/*      */     
/*  706 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  707 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  708 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */ 
/*      */     
/*  711 */     this.jDialog2.setTitle("Búsqueda de Deudores");
/*  712 */     this.jDialog2.setModal(true);
/*      */     
/*  714 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/*      */     
/*  716 */     this.jPanel36.setBackground(new Color(146, 193, 134));
/*  717 */     this.jPanel36.setBorder(BorderFactory.createTitledBorder(null, "Listado de Operadores ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  719 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/*  720 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  728 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  733 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  736 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  738 */             cajaChica.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/*  741 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/*  743 */     this.jButton20.setMnemonic('A');
/*  744 */     this.jButton20.setText("Asignar");
/*  745 */     this.jButton20.setToolTipText("Asignar (Alt+A)");
/*  746 */     this.jButton20.setEnabled(false);
/*  747 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  749 */             cajaChica.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  753 */     this.jButton21.setMnemonic('C');
/*  754 */     this.jButton21.setText("Cerrar");
/*  755 */     this.jButton21.setToolTipText("Cerrar (Alt+C)");
/*  756 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  758 */             cajaChica.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  762 */     this.jLabel58.setFont(new Font("Tahoma", 2, 11));
/*  763 */     this.jLabel58.setForeground(new Color(15, 87, 51));
/*  764 */     this.jLabel58.setHorizontalAlignment(4);
/*  765 */     this.jLabel58.setText("Clave");
/*      */     
/*  767 */     this.jTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  769 */             cajaChica.this.jTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  773 */     this.jLabel61.setFont(new Font("Tahoma", 2, 11));
/*  774 */     this.jLabel61.setForeground(new Color(15, 87, 51));
/*  775 */     this.jLabel61.setHorizontalAlignment(4);
/*  776 */     this.jLabel61.setText("Nombre");
/*      */     
/*  778 */     this.jTextField11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  780 */             cajaChica.this.jTextField11ActionPerformed(evt);
/*      */           }
/*      */         });
/*  783 */     this.jTextField11.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  785 */             cajaChica.this.jTextField11KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  789 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/*  790 */     this.jPanel36.setLayout(jPanel36Layout);
/*  791 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/*  792 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  793 */         .addGroup(jPanel36Layout.createSequentialGroup()
/*  794 */           .addContainerGap()
/*  795 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  796 */             .addComponent(this.jScrollPane3, -1, 353, 32767)
/*  797 */             .addGroup(jPanel36Layout.createSequentialGroup()
/*  798 */               .addComponent(this.jLabel58, -2, 40, -2)
/*  799 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  800 */               .addComponent(this.jTextField10, -2, 52, -2)
/*  801 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  802 */               .addComponent(this.jLabel61, -2, 57, -2)
/*  803 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  804 */               .addComponent(this.jTextField11, -2, 162, -2))
/*  805 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/*  806 */               .addGap(0, 0, 32767)
/*  807 */               .addComponent(this.jButton20, -2, 92, -2)
/*  808 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  809 */               .addComponent(this.jButton21, -2, 83, -2)))
/*  810 */           .addContainerGap()));
/*      */     
/*  812 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/*  813 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  814 */         .addGroup(jPanel36Layout.createSequentialGroup()
/*  815 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  816 */             .addComponent(this.jLabel58)
/*  817 */             .addComponent(this.jTextField10, -2, -1, -2)
/*  818 */             .addComponent(this.jLabel61)
/*  819 */             .addComponent(this.jTextField11, -2, -1, -2))
/*  820 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  821 */           .addComponent(this.jScrollPane3, -1, 222, 32767)
/*  822 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  823 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  824 */             .addComponent(this.jButton21)
/*  825 */             .addComponent(this.jButton20))
/*  826 */           .addGap(5, 5, 5)));
/*      */ 
/*      */     
/*  829 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  830 */     this.jPanel7.setLayout(jPanel7Layout);
/*  831 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  832 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  833 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/*  834 */           .addGap(8, 8, 8)
/*  835 */           .addComponent(this.jPanel36, -1, -1, 32767)
/*  836 */           .addGap(10, 10, 10)));
/*      */     
/*  838 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  839 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  840 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  841 */           .addContainerGap()
/*  842 */           .addComponent(this.jPanel36, -2, -1, -2)
/*  843 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  846 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  847 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  848 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  849 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  850 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */     
/*  852 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  853 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  854 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */ 
/*      */     
/*  857 */     this.jDialog3.setTitle("Lista de Reposiciones");
/*  858 */     this.jDialog3.setModal(true);
/*      */     
/*  860 */     this.jPanel9.setBackground(new Color(146, 193, 134));
/*      */     
/*  862 */     this.jLabel59.setFont(new Font("Tahoma", 1, 16));
/*  863 */     this.jLabel59.setForeground(new Color(0, 102, 102));
/*  864 */     this.jLabel59.setHorizontalAlignment(0);
/*  865 */     this.jLabel59.setText("Lista de Reposiciones");
/*      */     
/*  867 */     this.jPanel37.setBackground(new Color(146, 193, 134));
/*  868 */     this.jPanel37.setBorder(BorderFactory.createTitledBorder(null, "Lista de Reposiciones", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  870 */     this.jTable4.setFont(new Font("Tahoma", 0, 10));
/*  871 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Documentó", "Importe", "Vales", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  879 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  884 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  887 */     this.jTable4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  889 */             cajaChica.this.jTable4MouseClicked(evt);
/*      */           }
/*      */         });
/*  892 */     this.jScrollPane4.setViewportView(this.jTable4);
/*  893 */     if (this.jTable4.getColumnModel().getColumnCount() > 0) {
/*  894 */       this.jTable4.getColumnModel().getColumn(0).setMinWidth(60);
/*  895 */       this.jTable4.getColumnModel().getColumn(0).setMaxWidth(60);
/*  896 */       this.jTable4.getColumnModel().getColumn(1).setMinWidth(100);
/*  897 */       this.jTable4.getColumnModel().getColumn(1).setMaxWidth(100);
/*  898 */       this.jTable4.getColumnModel().getColumn(3).setMinWidth(70);
/*  899 */       this.jTable4.getColumnModel().getColumn(3).setMaxWidth(70);
/*  900 */       this.jTable4.getColumnModel().getColumn(4).setMinWidth(50);
/*  901 */       this.jTable4.getColumnModel().getColumn(4).setMaxWidth(50);
/*  902 */       this.jTable4.getColumnModel().getColumn(5).setMinWidth(100);
/*  903 */       this.jTable4.getColumnModel().getColumn(5).setMaxWidth(100);
/*      */     } 
/*      */     
/*  906 */     this.jLabel60.setFont(new Font("Tahoma", 3, 11));
/*  907 */     this.jLabel60.setForeground(new Color(15, 87, 51));
/*  908 */     this.jLabel60.setHorizontalAlignment(4);
/*  909 */     this.jLabel60.setText("Clave ");
/*      */     
/*  911 */     this.jTextField12.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  913 */             cajaChica.this.jTextField12KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  917 */     this.jLabel69.setFont(new Font("Tahoma", 3, 11));
/*  918 */     this.jLabel69.setForeground(new Color(15, 87, 51));
/*  919 */     this.jLabel69.setHorizontalAlignment(4);
/*  920 */     this.jLabel69.setText("Reposiciones de ");
/*      */     
/*  922 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/*  923 */     this.jComboBox2.setFont(new Font("Tahoma", 1, 11));
/*  924 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  926 */             cajaChica.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  930 */     GroupLayout jPanel37Layout = new GroupLayout(this.jPanel37);
/*  931 */     this.jPanel37.setLayout(jPanel37Layout);
/*  932 */     jPanel37Layout.setHorizontalGroup(jPanel37Layout
/*  933 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  934 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
/*  935 */           .addContainerGap()
/*  936 */           .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  937 */             .addComponent(this.jScrollPane4, GroupLayout.Alignment.LEADING, -1, 617, 32767)
/*  938 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel37Layout.createSequentialGroup()
/*  939 */               .addComponent(this.jLabel60, -2, 40, -2)
/*  940 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  941 */               .addComponent(this.jTextField12, -2, 92, -2)
/*  942 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  943 */               .addComponent(this.jLabel69, -2, 121, -2)
/*  944 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  945 */               .addComponent(this.jComboBox2, -2, 255, -2)))
/*  946 */           .addContainerGap()));
/*      */     
/*  948 */     jPanel37Layout.setVerticalGroup(jPanel37Layout
/*  949 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  950 */         .addGroup(jPanel37Layout.createSequentialGroup()
/*  951 */           .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  952 */             .addComponent(this.jLabel60)
/*  953 */             .addComponent(this.jTextField12, -2, -1, -2)
/*  954 */             .addComponent(this.jLabel69)
/*  955 */             .addComponent(this.jComboBox2, -2, -1, -2))
/*  956 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  957 */           .addComponent(this.jScrollPane4, -1, 210, 32767)));
/*      */ 
/*      */     
/*  960 */     this.jButton22.setMnemonic('N');
/*  961 */     this.jButton22.setText("Nueva Solicitud");
/*  962 */     this.jButton22.setToolTipText("Asignar (Alt+N)");
/*  963 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  965 */             cajaChica.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  969 */     this.jButton23.setMnemonic('C');
/*  970 */     this.jButton23.setText("Cerrar");
/*  971 */     this.jButton23.setToolTipText("Cerrar (Alt+C)");
/*  972 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  974 */             cajaChica.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  978 */     this.jButton27.setMnemonic('G');
/*  979 */     this.jButton27.setText("Guardar Reporte");
/*  980 */     this.jButton27.setToolTipText("Guardar Reporte (Alt+G)");
/*  981 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  983 */             cajaChica.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  987 */     this.jButton26.setMnemonic('V');
/*  988 */     this.jButton26.setText("Ver");
/*  989 */     this.jButton26.setToolTipText("Ver Reposición (Alt+V)");
/*  990 */     this.jButton26.setEnabled(false);
/*  991 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  993 */             cajaChica.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  997 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  998 */     this.jPanel9.setLayout(jPanel9Layout);
/*  999 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1000 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1001 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1002 */           .addContainerGap()
/* 1003 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1004 */             .addComponent(this.jSeparator7, -1, 647, 32767)
/* 1005 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/* 1006 */               .addComponent(this.jButton22)
/* 1007 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1008 */               .addComponent(this.jButton26, -2, 119, -2)
/* 1009 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 300, 32767)
/* 1010 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1011 */                 .addComponent(this.jButton23, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1012 */                 .addComponent(this.jButton27, GroupLayout.Alignment.TRAILING, -1, -1, 32767))))
/* 1013 */           .addContainerGap())
/* 1014 */         .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1015 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/* 1016 */             .addGap(8, 8, 8)
/* 1017 */             .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1018 */               .addComponent(this.jPanel37, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1019 */               .addComponent(this.jLabel59, GroupLayout.Alignment.LEADING, -1, 649, 32767))
/* 1020 */             .addGap(10, 10, 10))));
/*      */     
/* 1022 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1023 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1024 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1025 */           .addGap(31, 31, 31)
/* 1026 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 1027 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 291, 32767)
/* 1028 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1029 */             .addComponent(this.jButton22)
/* 1030 */             .addComponent(this.jButton27)
/* 1031 */             .addComponent(this.jButton26))
/* 1032 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1033 */           .addComponent(this.jButton23)
/* 1034 */           .addContainerGap())
/* 1035 */         .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1036 */           .addGroup(jPanel9Layout.createSequentialGroup()
/* 1037 */             .addComponent(this.jLabel59, -2, 31, -2)
/* 1038 */             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1039 */             .addComponent(this.jPanel37, -2, -1, -2)
/* 1040 */             .addContainerGap(90, 32767))));
/*      */ 
/*      */     
/* 1043 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1044 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1045 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1046 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1047 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/* 1049 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1050 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1051 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */ 
/*      */     
/* 1054 */     this.jDialog4.setTitle("Cancelar Viaje");
/* 1055 */     this.jDialog4.setModal(true);
/*      */     
/* 1057 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*      */     
/* 1059 */     this.jLabel70.setFont(new Font("Tahoma", 1, 14));
/* 1060 */     this.jLabel70.setForeground(new Color(0, 102, 102));
/* 1061 */     this.jLabel70.setHorizontalAlignment(0);
/* 1062 */     this.jLabel70.setText("Motivo de la Cancelación");
/*      */     
/* 1064 */     this.jLabel71.setFont(new Font("Tahoma", 3, 11));
/* 1065 */     this.jLabel71.setForeground(new Color(15, 87, 51));
/* 1066 */     this.jLabel71.setHorizontalAlignment(4);
/* 1067 */     this.jLabel71.setText("Motivo");
/*      */     
/* 1069 */     this.jTextField14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1071 */             cajaChica.this.jTextField14ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1074 */     this.jTextField14.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1076 */             cajaChica.this.jTextField14KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1080 */     this.jButton11.setMnemonic('V');
/* 1081 */     this.jButton11.setText("Cancelar Vale");
/* 1082 */     this.jButton11.setToolTipText("Cancelar Vale (Alt+V)");
/* 1083 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1085 */             cajaChica.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1089 */     this.jButton12.setMnemonic('C');
/* 1090 */     this.jButton12.setText("Cerrar");
/* 1091 */     this.jButton12.setToolTipText("Cerrar (Alt+C)");
/* 1092 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1094 */             cajaChica.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1098 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1099 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1100 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1101 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1102 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1103 */           .addContainerGap()
/* 1104 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1105 */             .addComponent(this.jLabel70, -1, 279, 32767)
/* 1106 */             .addComponent(this.jSeparator4, -1, 279, 32767)
/* 1107 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 1108 */               .addComponent(this.jLabel71, -2, 57, -2)
/* 1109 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1110 */               .addComponent(this.jTextField14, -1, 218, 32767))
/* 1111 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/* 1112 */               .addComponent(this.jButton11)
/* 1113 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1114 */               .addComponent(this.jButton12, -2, 84, -2)))
/* 1115 */           .addContainerGap()));
/*      */     
/* 1117 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1118 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1119 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1120 */           .addComponent(this.jLabel70)
/* 1121 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1122 */           .addComponent(this.jSeparator4, -2, 10, -2)
/* 1123 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1124 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1125 */             .addComponent(this.jLabel71)
/* 1126 */             .addComponent(this.jTextField14, -2, -1, -2))
/* 1127 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1128 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1129 */             .addComponent(this.jButton12)
/* 1130 */             .addComponent(this.jButton11))
/* 1131 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1134 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1135 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1136 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1137 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1138 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */     
/* 1140 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1141 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1142 */         .addComponent(this.jPanel10, -2, -1, -2));
/*      */ 
/*      */     
/* 1145 */     this.jDialog5.setTitle("Reponer Caja");
/* 1146 */     this.jDialog5.setModal(true);
/*      */     
/* 1148 */     this.jPanel11.setBackground(new Color(146, 193, 134));
/*      */     
/* 1150 */     this.jLabel74.setFont(new Font("Tahoma", 1, 14));
/* 1151 */     this.jLabel74.setForeground(Color.blue);
/* 1152 */     this.jLabel74.setHorizontalAlignment(0);
/* 1153 */     this.jLabel74.setText("Reponer Caja De");
/*      */     
/* 1155 */     this.jPanel2.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1157 */     this.jLabel10.setText("Vales a reponer:");
/*      */     
/* 1159 */     this.jLabel11.setFont(new Font("Tahoma", 1, 12));
/* 1160 */     this.jLabel11.setHorizontalAlignment(2);
/* 1161 */     this.jLabel11.setText("150");
/*      */     
/* 1163 */     this.jLabel12.setText("Importe a reponer:");
/*      */     
/* 1165 */     this.jLabel13.setFont(new Font("Tahoma", 1, 12));
/* 1166 */     this.jLabel13.setHorizontalAlignment(4);
/* 1167 */     this.jLabel13.setText("150");
/*      */     
/* 1169 */     this.jLabel14.setFont(new Font("Tahoma", 1, 12));
/* 1170 */     this.jLabel14.setHorizontalAlignment(4);
/* 1171 */     this.jLabel14.setText("150");
/*      */     
/* 1173 */     this.jLabel18.setText("Importe actual en caja");
/*      */     
/* 1175 */     this.jLabel23.setText("Importe total de caja");
/*      */     
/* 1177 */     this.jLabel24.setFont(new Font("Tahoma", 1, 12));
/* 1178 */     this.jLabel24.setHorizontalAlignment(4);
/* 1179 */     this.jLabel24.setText("150");
/*      */     
/* 1181 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1182 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1183 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1184 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1185 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1186 */           .addContainerGap()
/* 1187 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1188 */             .addGroup(jPanel2Layout.createSequentialGroup()
/* 1189 */               .addComponent(this.jLabel10, -2, 101, 32767)
/* 1190 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1191 */               .addComponent(this.jLabel11, -2, 43, -2)
/* 1192 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1193 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1194 */                 .addComponent(this.jLabel18, -2, 122, 32767)
/* 1195 */                 .addComponent(this.jLabel12))
/* 1196 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1197 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1198 */                 .addComponent(this.jLabel13, -1, -1, 32767)
/* 1199 */                 .addComponent(this.jLabel14, -1, 111, 32767)))
/* 1200 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1201 */               .addComponent(this.jSeparator8, GroupLayout.Alignment.TRAILING)
/* 1202 */               .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 1203 */                 .addComponent(this.jLabel23, -2, 130, -2)
/* 1204 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1205 */                 .addComponent(this.jLabel24, -2, 107, -2))))
/* 1206 */           .addContainerGap()));
/*      */     
/* 1208 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1209 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1210 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1211 */           .addContainerGap()
/* 1212 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1213 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1214 */               .addComponent(this.jLabel10)
/* 1215 */               .addComponent(this.jLabel11))
/* 1216 */             .addGroup(jPanel2Layout.createSequentialGroup()
/* 1217 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1218 */                 .addComponent(this.jLabel13)
/* 1219 */                 .addComponent(this.jLabel12))
/* 1220 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1221 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1222 */                 .addComponent(this.jLabel14, -2, 15, -2)
/* 1223 */                 .addComponent(this.jLabel18, -2, 14, -2))))
/* 1224 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1225 */           .addComponent(this.jSeparator8, -2, 10, -2)
/* 1226 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1227 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1228 */             .addComponent(this.jLabel24)
/* 1229 */             .addComponent(this.jLabel23, -2, 14, -2))
/* 1230 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1233 */     this.jLabel9.setFont(new Font("Tahoma", 1, 11));
/* 1234 */     this.jLabel9.setText("Datos de la solicitud");
/*      */     
/* 1236 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder(0));
/*      */     
/* 1238 */     this.jLabel19.setForeground(Color.darkGray);
/* 1239 */     this.jLabel19.setText("Vale Inicial:");
/*      */     
/* 1241 */     this.jLabel20.setFont(new Font("Tahoma", 1, 12));
/* 1242 */     this.jLabel20.setForeground(Color.darkGray);
/* 1243 */     this.jLabel20.setHorizontalAlignment(2);
/* 1244 */     this.jLabel20.setText("PR-00001");
/*      */     
/* 1246 */     this.jLabel21.setForeground(Color.darkGray);
/* 1247 */     this.jLabel21.setText("Vale Final:");
/*      */     
/* 1249 */     this.jLabel22.setFont(new Font("Tahoma", 1, 12));
/* 1250 */     this.jLabel22.setForeground(Color.darkGray);
/* 1251 */     this.jLabel22.setHorizontalAlignment(2);
/* 1252 */     this.jLabel22.setText("PR-00002");
/*      */     
/* 1254 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1255 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1256 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 1257 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1258 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1259 */           .addContainerGap()
/* 1260 */           .addComponent(this.jLabel19, -2, 67, -2)
/* 1261 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1262 */           .addComponent(this.jLabel20, -2, 88, -2)
/* 1263 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 77, 32767)
/* 1264 */           .addComponent(this.jLabel21, -2, 67, -2)
/* 1265 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1266 */           .addComponent(this.jLabel22, -2, 88, -2)
/* 1267 */           .addContainerGap()));
/*      */     
/* 1269 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 1270 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1271 */         .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1272 */           .addComponent(this.jLabel19)
/* 1273 */           .addComponent(this.jLabel20)
/* 1274 */           .addComponent(this.jLabel21)
/* 1275 */           .addComponent(this.jLabel22)));
/*      */ 
/*      */     
/* 1278 */     this.jButton6.setMnemonic('C');
/* 1279 */     this.jButton6.setText("Cerrar");
/* 1280 */     this.jButton6.setToolTipText("Cerrar (Alt+C)");
/* 1281 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1283 */             cajaChica.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1287 */     this.jButton10.setMnemonic('G');
/* 1288 */     this.jButton10.setText("Generar Solicitud");
/* 1289 */     this.jButton10.setToolTipText("Generar Solicitud (Alt+G)");
/* 1290 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1292 */             cajaChica.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1296 */     this.jPanel5.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1298 */     this.jLabel25.setText("Cheque");
/*      */     
/* 1300 */     this.jLabel26.setHorizontalAlignment(4);
/* 1301 */     this.jLabel26.setText("Fecha");
/*      */     
/* 1303 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1304 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1305 */     this.jDateChooser5.setIcon(this.icon);
/* 1306 */     this.jDateChooser5.setMinSelectableDate(this.fechaActual);
/*      */     
/* 1308 */     this.jLabel27.setText("Banco");
/*      */     
/* 1310 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1311 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1312 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1313 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1314 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1315 */           .addContainerGap()
/* 1316 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1317 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1318 */               .addComponent(this.jLabel25, -2, 49, -2)
/* 1319 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1320 */               .addComponent(this.jTextField2, -2, 133, -2)
/* 1321 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767)
/* 1322 */               .addComponent(this.jLabel26, -2, 43, -2)
/* 1323 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1324 */               .addComponent((Component)this.jDateChooser5, -2, 134, -2))
/* 1325 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1326 */               .addComponent(this.jLabel27, -2, 43, -2)
/* 1327 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1328 */               .addComponent(this.jTextField8, -1, 346, 32767)))
/* 1329 */           .addContainerGap()));
/*      */     
/* 1331 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1332 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1333 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1334 */           .addContainerGap()
/* 1335 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1336 */             .addComponent((Component)this.jDateChooser5, -2, -1, -2)
/* 1337 */             .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1338 */               .addComponent(this.jLabel25)
/* 1339 */               .addComponent(this.jTextField2, -2, -1, -2)
/* 1340 */               .addComponent(this.jLabel26)))
/* 1341 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1342 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1343 */             .addComponent(this.jLabel27)
/* 1344 */             .addComponent(this.jTextField8, -2, -1, -2))
/* 1345 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1348 */     this.jLabel33.setFont(new Font("Tahoma", 1, 11));
/* 1349 */     this.jLabel33.setText("Datos de la Reposición");
/*      */     
/* 1351 */     this.jLabel28.setFont(new Font("Tahoma", 1, 11));
/* 1352 */     this.jLabel28.setForeground(Color.red);
/* 1353 */     this.jLabel28.setHorizontalAlignment(4);
/* 1354 */     this.jLabel28.setText("FOLIO:");
/*      */     
/* 1356 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1357 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1358 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1359 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1360 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1361 */           .addContainerGap()
/* 1362 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1363 */             .addComponent(this.jPanel5, -1, -1, 32767)
/* 1364 */             .addComponent(this.jSeparator5, -1, 423, 32767)
/* 1365 */             .addComponent(this.jPanel4, -1, -1, 32767)
/* 1366 */             .addComponent(this.jPanel2, -1, -1, 32767)
/* 1367 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 1368 */               .addComponent(this.jLabel9, -2, 140, -2)
/* 1369 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, 32767)
/* 1370 */               .addComponent(this.jLabel28, -2, 229, -2))
/* 1371 */             .addComponent(this.jLabel74, -1, 423, 32767)
/* 1372 */             .addComponent(this.jLabel33, -2, 159, -2)
/* 1373 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 1374 */               .addComponent(this.jButton10, -2, 134, -2)
/* 1375 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1376 */               .addComponent(this.jButton6, -2, 96, -2)))
/* 1377 */           .addContainerGap()));
/*      */     
/* 1379 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1380 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1381 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1382 */           .addComponent(this.jLabel74)
/* 1383 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1384 */           .addComponent(this.jSeparator5, -2, 10, -2)
/* 1385 */           .addGap(3, 3, 3)
/* 1386 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1387 */             .addComponent(this.jLabel9)
/* 1388 */             .addComponent(this.jLabel28))
/* 1389 */           .addGap(1, 1, 1)
/* 1390 */           .addComponent(this.jPanel2, -2, -1, -2)
/* 1391 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1392 */           .addComponent(this.jPanel4, -2, -1, -2)
/* 1393 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1394 */           .addComponent(this.jLabel33)
/* 1395 */           .addGap(1, 1, 1)
/* 1396 */           .addComponent(this.jPanel5, -2, -1, -2)
/* 1397 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1398 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1399 */             .addComponent(this.jButton6)
/* 1400 */             .addComponent(this.jButton10))
/* 1401 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1404 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1405 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1406 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1407 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1408 */         .addComponent(this.jPanel11, -1, -1, 32767));
/*      */     
/* 1410 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1411 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1412 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */ 
/*      */     
/* 1415 */     this.jDialog6.setTitle("Ver Reposicion");
/* 1416 */     this.jDialog6.setModal(true);
/*      */     
/* 1418 */     this.jPanel12.setBackground(new Color(255, 255, 255));
/*      */     
/* 1420 */     this.jLabel75.setFont(new Font("Tahoma", 3, 20));
/* 1421 */     this.jLabel75.setForeground(Color.red);
/* 1422 */     this.jLabel75.setText("FLETES Y MATERIALES GRUPO FORSIS S.A. DE C.V.");
/*      */     
/* 1424 */     this.jLabel29.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis75.png")));
/*      */     
/* 1426 */     this.jLabel30.setFont(new Font("Tahoma", 2, 16));
/* 1427 */     this.jLabel30.setText("Reposición de UZZIEL CONTRERAS PORTILLA");
/*      */     
/* 1429 */     this.jLabel31.setFont(new Font("Tahoma", 0, 15));
/* 1430 */     this.jLabel31.setForeground(Color.blue);
/* 1431 */     this.jLabel31.setText("Folio Reposición: PR-00001");
/*      */     
/* 1433 */     this.jLabel32.setFont(new Font("Tahoma", 0, 15));
/* 1434 */     this.jLabel32.setForeground(Color.blue);
/* 1435 */     this.jLabel32.setText("Fecha: 13/05/2010");
/*      */     
/* 1437 */     this.jLabel34.setFont(new Font("Tahoma", 0, 15));
/* 1438 */     this.jLabel34.setForeground(Color.blue);
/* 1439 */     this.jLabel34.setText("Estatus: <Repuesta>");
/*      */     
/* 1441 */     this.jLabel35.setText("13/05/2010");
/*      */     
/* 1443 */     this.jLabel36.setText("Pág. 1");
/*      */     
/* 1445 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/* 1446 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null },  }, (Object[])new String[] { "Folio", "Fecha", "Nombre", "Concepto", "Cargo", "Eco", "Monto" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1457 */     this.jScrollPane5.setViewportView(this.jTable2);
/*      */     
/* 1459 */     this.jLabel37.setFont(new Font("Tahoma", 1, 11));
/* 1460 */     this.jLabel37.setForeground(Color.red);
/* 1461 */     this.jLabel37.setHorizontalAlignment(0);
/* 1462 */     this.jLabel37.setText("<html><u>Cerrar</u></html>");
/* 1463 */     this.jLabel37.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1465 */             cajaChica.this.jLabel37MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1468 */             cajaChica.this.jLabel37MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1471 */             cajaChica.this.jLabel37MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1475 */     this.jLabel38.setFont(new Font("Tahoma", 1, 11));
/* 1476 */     this.jLabel38.setText("|");
/*      */     
/* 1478 */     this.jLabel39.setFont(new Font("Tahoma", 1, 11));
/* 1479 */     this.jLabel39.setText("|");
/*      */     
/* 1481 */     this.jLabel40.setFont(new Font("Tahoma", 1, 11));
/* 1482 */     this.jLabel40.setForeground(Color.red);
/* 1483 */     this.jLabel40.setHorizontalAlignment(0);
/* 1484 */     this.jLabel40.setText("<html><U>Imprimir</u></html>");
/* 1485 */     this.jLabel40.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1487 */             cajaChica.this.jLabel40MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1490 */             cajaChica.this.jLabel40MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1493 */             cajaChica.this.jLabel40MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1497 */     this.jLabel41.setFont(new Font("Tahoma", 1, 11));
/* 1498 */     this.jLabel41.setText("|");
/*      */     
/* 1500 */     this.jSeparator11.setBackground(new Color(0, 0, 0));
/*      */     
/* 1502 */     this.jLabel42.setFont(new Font("Tahoma", 1, 11));
/* 1503 */     this.jLabel42.setText("50 Vales");
/*      */     
/* 1505 */     this.jSeparator12.setBackground(new Color(0, 0, 0));
/*      */     
/* 1507 */     this.jLabel43.setFont(new Font("Tahoma", 1, 11));
/* 1508 */     this.jLabel43.setText("$20,000.00");
/*      */     
/* 1510 */     this.jLabel44.setFont(new Font("Tahoma", 1, 11));
/* 1511 */     this.jLabel44.setForeground(Color.red);
/* 1512 */     this.jLabel44.setHorizontalAlignment(0);
/* 1513 */     this.jLabel44.setText("<html><U>Guardar</u></html>");
/* 1514 */     this.jLabel44.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1516 */             cajaChica.this.jLabel44MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1519 */             cajaChica.this.jLabel44MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1522 */             cajaChica.this.jLabel44MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1526 */     this.jLabel45.setFont(new Font("Tahoma", 1, 11));
/* 1527 */     this.jLabel45.setText("|");
/*      */     
/* 1529 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1530 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1531 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1532 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1533 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1534 */           .addContainerGap()
/* 1535 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1536 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1537 */               .addComponent(this.jLabel29, -2, 75, -2)
/* 1538 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1539 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1540 */                 .addGroup(jPanel12Layout.createSequentialGroup()
/* 1541 */                   .addComponent(this.jSeparator9, -2, 800, -2)
/* 1542 */                   .addContainerGap())
/* 1543 */                 .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1544 */                   .addComponent(this.jLabel75, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1545 */                   .addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
/* 1546 */                     .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1547 */                       .addComponent(this.jLabel30, -2, 489, -2)
/* 1548 */                       .addGroup(jPanel12Layout.createSequentialGroup()
/* 1549 */                         .addComponent(this.jLabel31, -2, 202, -2)
/* 1550 */                         .addGap(36, 36, 36)
/* 1551 */                         .addComponent(this.jLabel32, -2, 168, -2)
/* 1552 */                         .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1553 */                         .addComponent(this.jLabel34, -2, 168, -2)))
/* 1554 */                     .addGap(123, 123, 123)
/* 1555 */                     .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1556 */                       .addComponent(this.jLabel36, -2, 82, -2)
/* 1557 */                       .addComponent(this.jLabel35, -2, 82, -2))
/* 1558 */                     .addGap(49, 49, 49)))))
/* 1559 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1560 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1561 */                 .addComponent(this.jScrollPane5, GroupLayout.Alignment.LEADING)
/* 1562 */                 .addComponent(this.jSeparator10, GroupLayout.Alignment.LEADING, -1, 878, 32767))
/* 1563 */               .addContainerGap(-1, 32767))
/* 1564 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 1565 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1566 */                 .addComponent(this.jSeparator11, -2, 82, -2)
/* 1567 */                 .addGroup(jPanel12Layout.createSequentialGroup()
/* 1568 */                   .addGap(38, 38, 38)
/* 1569 */                   .addComponent(this.jLabel42, -2, 71, -2)))
/* 1570 */               .addGap(56, 56, 56)
/* 1571 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1572 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 1573 */                   .addComponent(this.jSeparator12, -2, 129, -2)
/* 1574 */                   .addGap(281, 281, 281))
/* 1575 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 1576 */                   .addComponent(this.jLabel43, -2, 138, -2)
/* 1577 */                   .addGap(187, 187, 187)))
/* 1578 */               .addComponent(this.jLabel45)
/* 1579 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1580 */               .addComponent(this.jLabel44, -2, 78, -2)
/* 1581 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1582 */               .addComponent(this.jLabel41)
/* 1583 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1584 */               .addComponent(this.jLabel40, -2, 78, -2)
/* 1585 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1586 */               .addComponent(this.jLabel38)
/* 1587 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1588 */               .addComponent(this.jLabel37, -2, 78, -2)
/* 1589 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1590 */               .addComponent(this.jLabel39)
/* 1591 */               .addGap(46, 46, 46)))));
/*      */     
/* 1593 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1594 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1595 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1596 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1597 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1598 */               .addComponent(this.jLabel75, -2, 25, -2)
/* 1599 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1600 */               .addComponent(this.jSeparator9, -2, 2, -2)
/* 1601 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1602 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1603 */                 .addComponent(this.jLabel30)
/* 1604 */                 .addComponent(this.jLabel35))
/* 1605 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1606 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1607 */                 .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1608 */                   .addComponent(this.jLabel32, -1, 22, 32767)
/* 1609 */                   .addComponent(this.jLabel34, -1, 22, 32767)
/* 1610 */                   .addComponent(this.jLabel31, -1, 22, 32767))
/* 1611 */                 .addComponent(this.jLabel36)))
/* 1612 */             .addComponent(this.jLabel29, -1, 95, 32767))
/* 1613 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1614 */           .addComponent(this.jSeparator10, -2, 10, -2)
/* 1615 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1616 */           .addComponent(this.jScrollPane5, -2, 373, -2)
/* 1617 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1618 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1619 */             .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1620 */               .addComponent(this.jLabel37, -2, -1, -2)
/* 1621 */               .addComponent(this.jLabel38)
/* 1622 */               .addComponent(this.jLabel39)
/* 1623 */               .addComponent(this.jLabel40, -2, -1, -2)
/* 1624 */               .addComponent(this.jLabel41)
/* 1625 */               .addComponent(this.jLabel44, -2, -1, -2)
/* 1626 */               .addComponent(this.jLabel45))
/* 1627 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1628 */               .addComponent(this.jSeparator11, -2, -1, -2)
/* 1629 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1630 */               .addComponent(this.jLabel42))
/* 1631 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1632 */               .addComponent(this.jSeparator12, -2, 2, -2)
/* 1633 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1634 */               .addComponent(this.jLabel43)))
/* 1635 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1638 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1639 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1640 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1641 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1642 */         .addComponent(this.jPanel12, -1, 905, 32767));
/*      */     
/* 1644 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1645 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1646 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */ 
/*      */     
/* 1649 */     this.jDialog7.setTitle("Iniciar Sesión");
/* 1650 */     this.jDialog7.setModal(true);
/*      */     
/* 1652 */     this.jPanel15.setBackground(new Color(255, 255, 255));
/*      */     
/* 1654 */     this.jLabel46.setFont(new Font("Tahoma", 1, 14));
/* 1655 */     this.jLabel46.setForeground(new Color(51, 102, 255));
/* 1656 */     this.jLabel46.setText("Fletes y Materiales Forsis S.A. de C.V.");
/*      */     
/* 1658 */     this.jLabel49.setFont(new Font("Tahoma", 1, 11));
/* 1659 */     this.jLabel49.setText("Cancelación de vales");
/*      */     
/* 1661 */     this.jPanel13.setBackground(new Color(255, 255, 255));
/*      */     
/* 1663 */     this.jLabel50.setText("Nombre:");
/*      */     
/* 1665 */     this.jTextField16.setFont(new Font("Tahoma", 1, 12));
/* 1666 */     this.jTextField16.setToolTipText("Nombre de usuario");
/* 1667 */     this.jTextField16.setOpaque(false);
/* 1668 */     this.jTextField16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1670 */             cajaChica.this.jTextField16ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1673 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/* 1675 */             cajaChica.this.jTextField16FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/* 1679 */     this.jLabel51.setText("Contraseña:");
/*      */     
/* 1681 */     this.jPasswordField1.setToolTipText("Contraseña");
/* 1682 */     this.jPasswordField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1684 */             cajaChica.this.jPasswordField1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1688 */     this.jButton30.setMnemonic('E');
/* 1689 */     this.jButton30.setText("Entrar");
/* 1690 */     this.jButton30.setToolTipText("Entrar (Alt+E)");
/* 1691 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1693 */             cajaChica.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1697 */     this.jButton29.setMnemonic('C');
/* 1698 */     this.jButton29.setText("Cerrar");
/* 1699 */     this.jButton29.setToolTipText("Cerrar (Alt+C)");
/* 1700 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1702 */             cajaChica.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1706 */     this.jLabel52.setFont(new Font("Arial", 0, 11));
/* 1707 */     this.jLabel52.setForeground(Color.darkGray);
/* 1708 */     this.jLabel52.setText("<html>NOTA: Sólo pueden entrar usuarios administradores a éste módulo.</html>");
/*      */     
/* 1710 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 1711 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1712 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 1713 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1714 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1715 */           .addContainerGap()
/* 1716 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1717 */             .addGroup(jPanel13Layout.createSequentialGroup()
/* 1718 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1719 */                 .addComponent(this.jLabel50, GroupLayout.Alignment.LEADING, -2, 130, -2)
/* 1720 */                 .addComponent(this.jLabel51, GroupLayout.Alignment.LEADING, -1, 244, 32767)
/* 1721 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/* 1722 */                   .addComponent(this.jButton30, -2, 77, -2)
/* 1723 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1724 */                   .addComponent(this.jButton29, -2, 81, -2))
/* 1725 */                 .addComponent(this.jPasswordField1, GroupLayout.Alignment.LEADING, -1, 244, 32767)
/* 1726 */                 .addComponent(this.jTextField16, GroupLayout.Alignment.LEADING, -1, 244, 32767))
/* 1727 */               .addGap(19, 19, 19))
/* 1728 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/* 1729 */               .addComponent(this.jLabel52, -1, 253, 32767)
/* 1730 */               .addContainerGap())))
/* 1731 */         .addComponent(this.jSeparator13, -1, 273, 32767));
/*      */     
/* 1733 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 1734 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1735 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/* 1736 */           .addComponent(this.jSeparator13, -2, 10, -2)
/* 1737 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1738 */           .addComponent(this.jLabel50)
/* 1739 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1740 */           .addComponent(this.jTextField16, -2, -1, -2)
/* 1741 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1742 */           .addComponent(this.jLabel51)
/* 1743 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1744 */           .addComponent(this.jPasswordField1, -2, -1, -2)
/* 1745 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1746 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1747 */             .addComponent(this.jButton29)
/* 1748 */             .addComponent(this.jButton30))
/* 1749 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1750 */           .addComponent(this.jLabel52, -2, 36, -2)));
/*      */ 
/*      */     
/* 1753 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 1754 */     this.jPanel15.setLayout(jPanel15Layout);
/* 1755 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/* 1756 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1757 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 1758 */           .addComponent(this.jLabel47)
/* 1759 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1760 */           .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1761 */             .addComponent(this.jLabel46, -2, 279, -2)
/* 1762 */             .addComponent(this.jLabel49, -2, 251, -2)
/* 1763 */             .addComponent(this.jPanel13, -2, -1, -2))
/* 1764 */           .addContainerGap()));
/*      */     
/* 1766 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/* 1767 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1768 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 1769 */           .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1770 */             .addComponent(this.jLabel47, -2, 64, -2)
/* 1771 */             .addGroup(jPanel15Layout.createSequentialGroup()
/* 1772 */               .addContainerGap()
/* 1773 */               .addComponent(this.jLabel46)
/* 1774 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1775 */               .addComponent(this.jLabel49)
/* 1776 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1777 */               .addComponent(this.jPanel13, -2, -1, -2)))
/* 1778 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1781 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 1782 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 1783 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 1784 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1785 */         .addComponent(this.jPanel15, -2, -1, -2));
/*      */     
/* 1787 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 1788 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1789 */         .addComponent(this.jPanel15, -2, -1, -2));
/*      */ 
/*      */     
/* 1792 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/* 1793 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1795 */     this.jLabel3.setFont(new Font("Tahoma", 1, 18));
/* 1796 */     this.jLabel3.setForeground(new Color(10, 126, 68));
/* 1797 */     this.jLabel3.setHorizontalAlignment(0);
/* 1798 */     this.jLabel3.setText("Movimientos de Caja Chica");
/*      */     
/* 1800 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/* 1801 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha de Creación", "Nombre Completo", "Concepto", "Autorizó", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1809 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1814 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1817 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1819 */             cajaChica.this.jTable1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1822 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 1823 */     if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/* 1824 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(70);
/* 1825 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
/* 1826 */       this.jTable1.getColumnModel().getColumn(5).setMinWidth(120);
/* 1827 */       this.jTable1.getColumnModel().getColumn(5).setMaxWidth(120);
/*      */     } 
/*      */     
/* 1830 */     this.jRadioButton1.setSelected(true);
/* 1831 */     this.jRadioButton1.setText("Mostrar vales por Reponer");
/* 1832 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1834 */             cajaChica.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1838 */     this.jRadioButton2.setText("Mostrar todos los vales");
/* 1839 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1841 */             cajaChica.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1845 */     this.jLabel15.setFont(new Font("Tahoma", 3, 12));
/* 1846 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 1847 */     this.jLabel15.setHorizontalAlignment(4);
/* 1848 */     this.jLabel15.setText("Folio");
/*      */     
/* 1850 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1852 */             cajaChica.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1856 */     this.jLabel16.setFont(new Font("Tahoma", 3, 12));
/* 1857 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/* 1858 */     this.jLabel16.setHorizontalAlignment(4);
/* 1859 */     this.jLabel16.setText("Nombre de ");
/*      */     
/* 1861 */     this.jLabel17.setFont(new Font("Tahoma", 3, 12));
/* 1862 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/* 1863 */     this.jLabel17.setHorizontalAlignment(4);
/* 1864 */     this.jLabel17.setText("Concepto ");
/*      */     
/* 1866 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1868 */             cajaChica.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1872 */     this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1874 */     this.jLabel1.setFont(new Font("Tahoma", 1, 12));
/* 1875 */     this.jLabel1.setText("Total de la Caja");
/*      */     
/* 1877 */     this.jLabel2.setFont(new Font("Tahoma", 1, 12));
/* 1878 */     this.jLabel2.setText("Importe Gastado");
/*      */     
/* 1880 */     this.jLabel4.setFont(new Font("Tahoma", 1, 12));
/* 1881 */     this.jLabel4.setText("Saldo Actual");
/*      */     
/* 1883 */     this.jLabel5.setFont(new Font("Tahoma", 1, 12));
/* 1884 */     this.jLabel5.setForeground(Color.darkGray);
/* 1885 */     this.jLabel5.setHorizontalAlignment(4);
/* 1886 */     this.jLabel5.setText("$ 10000.00");
/*      */     
/* 1888 */     this.jLabel6.setFont(new Font("Tahoma", 1, 12));
/* 1889 */     this.jLabel6.setForeground(Color.darkGray);
/* 1890 */     this.jLabel6.setHorizontalAlignment(4);
/* 1891 */     this.jLabel6.setText("$ 10000.00");
/*      */     
/* 1893 */     this.jLabel7.setFont(new Font("Tahoma", 1, 12));
/* 1894 */     this.jLabel7.setForeground(Color.darkGray);
/* 1895 */     this.jLabel7.setHorizontalAlignment(4);
/* 1896 */     this.jLabel7.setText("$ 10000.00");
/*      */     
/* 1898 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1899 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1900 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1901 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1902 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1903 */           .addContainerGap()
/* 1904 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1905 */             .addComponent(this.jSeparator2, -1, 234, 32767)
/* 1906 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1907 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1908 */                 .addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1909 */                 .addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1910 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1911 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1912 */                 .addComponent(this.jLabel5, -1, 112, 32767)
/* 1913 */                 .addComponent(this.jLabel6, -1, 112, 32767)))
/* 1914 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1915 */               .addComponent(this.jLabel4, -2, 106, -2)
/* 1916 */               .addGap(16, 16, 16)
/* 1917 */               .addComponent(this.jLabel7, -1, 112, 32767)))
/* 1918 */           .addContainerGap()));
/*      */     
/* 1920 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1921 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1922 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1923 */           .addContainerGap()
/* 1924 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1925 */             .addComponent(this.jLabel1)
/* 1926 */             .addComponent(this.jLabel5))
/* 1927 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1928 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1929 */             .addComponent(this.jLabel2)
/* 1930 */             .addComponent(this.jLabel6))
/* 1931 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1932 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 1933 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1934 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1935 */             .addComponent(this.jLabel4)
/* 1936 */             .addComponent(this.jLabel7))
/* 1937 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1940 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1941 */     this.jButton1.setMnemonic('N');
/* 1942 */     this.jButton1.setText("Nuevo Vale");
/* 1943 */     this.jButton1.setToolTipText("Nuevo Vale (Alt+N)");
/* 1944 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1946 */             cajaChica.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1950 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1951 */     this.jButton2.setMnemonic('C');
/* 1952 */     this.jButton2.setText("Consultar Vale");
/* 1953 */     this.jButton2.setToolTipText("Consultar Vale(Alt+C)");
/* 1954 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1956 */             cajaChica.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1960 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1961 */     this.jButton3.setText("Cancelar Vale");
/* 1962 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1964 */             cajaChica.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1968 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1969 */     this.jLabel48.setForeground(Color.red);
/* 1970 */     this.jLabel48.setHorizontalAlignment(0);
/* 1971 */     this.jLabel48.setText("t");
/* 1972 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1974 */     this.jButton4.setMnemonic('R');
/* 1975 */     this.jButton4.setText("Reposiciones");
/* 1976 */     this.jButton4.setToolTipText("Reposiciones (Alt+R)");
/* 1977 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1979 */             cajaChica.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1983 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1984 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 1985 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1987 */             cajaChica.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1991 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1992 */     this.jButton9.setMnemonic('G');
/* 1993 */     this.jButton9.setText("Guardar Reporte");
/* 1994 */     this.jButton9.setToolTipText("Guardar Reporte (Alt+G)");
/* 1995 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1997 */             cajaChica.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2001 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 2002 */     this.jPanel6.setLayout(jPanel6Layout);
/* 2003 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 2004 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2005 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 2006 */           .addContainerGap()
/* 2007 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2008 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 2009 */               .addComponent(this.jButton1, -2, 124, -2)
/* 2010 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2011 */               .addComponent(this.jButton2)
/* 2012 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2013 */               .addComponent(this.jButton3)
/* 2014 */               .addGap(59, 59, 59)
/* 2015 */               .addComponent(this.jLabel48, -2, 163, -2)
/* 2016 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 83, 32767)
/* 2017 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2018 */                 .addComponent(this.jButton4, -1, -1, 32767)
/* 2019 */                 .addComponent(this.jButton9))
/* 2020 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2021 */               .addComponent(this.jPanel1, -2, -1, -2))
/* 2022 */             .addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 1096, 32767)
/* 2023 */             .addComponent(this.jSeparator1, -1, 1096, 32767)
/* 2024 */             .addComponent(this.jLabel3, GroupLayout.Alignment.LEADING, -1, 1096, 32767))
/* 2025 */           .addContainerGap())
/* 2026 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 2027 */           .addGap(11, 11, 11)
/* 2028 */           .addComponent(this.jRadioButton1, -2, 185, -2)
/* 2029 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2030 */           .addComponent(this.jRadioButton2, -2, 162, -2)
/* 2031 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2032 */           .addComponent(this.jLabel15, -2, 36, -2)
/* 2033 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2034 */           .addComponent(this.jTextField1, -2, 65, -2)
/* 2035 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2036 */           .addComponent(this.jLabel16, -2, 77, -2)
/* 2037 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2038 */           .addComponent(this.jComboBox1, 0, 260, 32767)
/* 2039 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2040 */           .addComponent(this.jLabel17, -2, 77, -2)
/* 2041 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2042 */           .addComponent(this.jTextField3, -2, 152, -2)
/* 2043 */           .addGap(29, 29, 29)));
/*      */     
/* 2045 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 2046 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2047 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 2048 */           .addContainerGap()
/* 2049 */           .addComponent(this.jLabel3)
/* 2050 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2051 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 2052 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2053 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2054 */             .addComponent(this.jRadioButton1)
/* 2055 */             .addComponent(this.jRadioButton2)
/* 2056 */             .addComponent(this.jLabel15)
/* 2057 */             .addComponent(this.jTextField1, -2, -1, -2)
/* 2058 */             .addComponent(this.jLabel16)
/* 2059 */             .addComponent(this.jLabel17)
/* 2060 */             .addComponent(this.jTextField3, -2, -1, -2)
/* 2061 */             .addComponent(this.jComboBox1, -2, -1, -2))
/* 2062 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2063 */           .addComponent(this.jScrollPane1, -1, 159, 32767)
/* 2064 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2065 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2066 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 2067 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 2068 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2069 */                 .addComponent(this.jButton1)
/* 2070 */                 .addComponent(this.jButton2)
/* 2071 */                 .addComponent(this.jButton3)
/* 2072 */                 .addComponent(this.jLabel48)
/* 2073 */                 .addComponent(this.jButton9))
/* 2074 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2075 */               .addComponent(this.jButton4, -2, 32, -2)))
/* 2076 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2079 */     GroupLayout layout = new GroupLayout(this);
/* 2080 */     setLayout(layout);
/* 2081 */     layout.setHorizontalGroup(layout
/* 2082 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2083 */         .addGap(0, 1140, 32767)
/* 2084 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2085 */           .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/* 2086 */             .addContainerGap(-1, 32767)
/* 2087 */             .addComponent(this.jPanel6, -2, -1, -2)
/* 2088 */             .addContainerGap(-1, 32767))));
/*      */     
/* 2090 */     layout.setVerticalGroup(layout
/* 2091 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2092 */         .addGap(0, 389, 32767)
/* 2093 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2094 */           .addGroup(layout.createSequentialGroup()
/* 2095 */             .addGap(13, 13, 13)
/* 2096 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 2097 */             .addContainerGap())));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2102 */     this.jTextField6.setText("");
/* 2103 */     this.jTextField7.setText("");
/* 2104 */     this.jTextField13.setText("");
/* 2105 */     this.jTextField15.setText("");
/* 2106 */     this.jRadioButton3.setSelected(true);
/* 2107 */     this.jTextField7.setEditable(false);
/* 2108 */     this.jFormattedTextField1.setValue(Integer.valueOf(this.VALOR));
/* 2109 */     this.jTextField9.setText("");
/* 2110 */     this.jTextArea1.setText("");
/* 2111 */     sacarMayor();
/* 2112 */     this.jButton5.setEnabled(true);
/* 2113 */     this.jRadioButton3.setEnabled(true);
/* 2114 */     this.jRadioButton4.setEnabled(true);
/* 2115 */     this.jRadioButton5.setEnabled(true);
/* 2116 */     this.jFormattedTextField1.setEnabled(true);
/* 2117 */     this.jTextArea1.setEnabled(true);
/* 2118 */     this.jButton8.setEnabled(true);
/* 2119 */     this.jRadioButton3.setSelected(true);
/* 2120 */     this.jRadioButton6.setSelected(true);
/* 2121 */     this.jLabel8.setVisible(false);
/* 2122 */     this.jTextField9.setEnabled(true);
/* 2123 */     this.jTextField13.setEnabled(true);
/* 2124 */     this.jTextField15.setEnabled(true);
/* 2125 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 2129 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton5ActionPerformed(ActionEvent evt) {
/* 2133 */     if (this.jRadioButton5.isSelected()) {
/* 2134 */       this.jTextField7.setEditable(true);
/* 2135 */       this.jRadioButton6.setEnabled(true);
/* 2136 */       this.jRadioButton7.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 2140 */     consultar2();
/* 2141 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 2144 */     if (evt.getClickCount() == 2) {
/* 2145 */       cargarDeudor();
/*      */     } else {
/* 2147 */       this.jButton20.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 2151 */     cargarDeudor();
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 2155 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTextField10KeyReleased(KeyEvent evt) {
/* 2159 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jTextField11KeyReleased(KeyEvent evt) {
/* 2163 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {
/* 2167 */     this.jTextField7.setEditable(false);
/* 2168 */     this.jRadioButton6.setEnabled(false);
/* 2169 */     this.jRadioButton7.setEnabled(false);
/* 2170 */     this.jTextField7.setText("");
/* 2171 */     this.jRadioButton6.setSelected(true);
/*      */   }
/*      */   
/*      */   private void jRadioButton4ActionPerformed(ActionEvent evt) {
/* 2175 */     this.jTextField7.setEditable(false);
/* 2176 */     this.jRadioButton6.setEnabled(false);
/* 2177 */     this.jRadioButton7.setEnabled(false);
/* 2178 */     this.jTextField7.setText("");
/* 2179 */     this.jRadioButton6.setSelected(true);
/*      */   }
/*      */   
/*      */   private void jTable4MouseClicked(MouseEvent evt) {
/* 2183 */     if (evt.getClickCount() == 2) {
/* 2184 */       verRepo();
/*      */     } else {
/* 2186 */       this.jButton26.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 2191 */     int indice = this.jComboBox2.getSelectedIndex();
/* 2192 */     this.error.pasarModal(true);
/* 2193 */     this.val.pasarModal(Boolean.valueOf(true));
/* 2194 */     String eje = String.valueOf(this.jComboBox2.getSelectedItem());
/* 2195 */     this.jTextField2.setText("");
/* 2196 */     this.jTextField8.setText("");
/* 2197 */     if (indice == 0) {
/* 2198 */       this.error.cargarError(this.jComboBox2, "050");
/* 2199 */     } else if (!eje.equals(this.NOMBRE)) {
/* 2200 */       this.jComboBox2.setBackground(new Color(255, 51, 51));
/* 2201 */       JOptionPane.showMessageDialog(this.jDialog3, "Para realizar una nueva solicitud es necesario seleccionar tu nombre personal", "Selecciona Usuario", 0, this.ERROR);
/*      */     } else {
/* 2203 */       this.jLabel74.setText("Reponer Caja de " + String.valueOf(this.jComboBox2.getSelectedItem()));
/* 2204 */       this.encontrado = this.con.consultar("count(nombre_usu)", "valesgastos", "where nombre_usu = '" + this.NOMBRES[indice - 1] + "' and (estatus = '<por reponer>' || estatus='<cancelado>')");
/* 2205 */       this.jLabel11.setText(this.con.Campo);
/* 2206 */       if (Integer.parseInt(this.con.Campo) != 0) {
/* 2207 */         this.con.consultar("min(folio_valegastos)", "valesgastos", "where nombre_usu = '" + this.NOMBRES[indice - 1] + "' and (estatus = '<por reponer>' || estatus='<cancelado>')");
/* 2208 */         this.jLabel20.setText(this.con.Campo);
/* 2209 */         this.con.consultar("max(folio_valegastos)", "valesgastos", "where nombre_usu = '" + this.NOMBRES[indice - 1] + "' and (estatus = '<por reponer>' || estatus='<cancelado>')");
/* 2210 */         this.jLabel22.setText(this.con.Campo);
/* 2211 */         this.con.consultar("sum(monto)", "valesgastos", "where nombre_usu = '" + this.NOMBRES[indice - 1] + "' and (estatus = '<por reponer>' || estatus='<cancelado>')");
/* 2212 */         float cant = Float.parseFloat(this.con.Campo);
/* 2213 */         this.jFormattedTextField2.setValue(Float.valueOf(cant));
/* 2214 */         this.jLabel13.setText(this.jFormattedTextField2.getText());
/* 2215 */         this.jLabel14.setText(this.jLabel7.getText());
/* 2216 */         this.jLabel24.setText(this.jLabel5.getText());
/*      */       } else {
/* 2218 */         this.jLabel13.setText("$0.00");
/* 2219 */         this.jLabel20.setText("PR-00000");
/* 2220 */         this.jLabel22.setText("PR-00000");
/* 2221 */         this.jLabel14.setText("$0.00");
/* 2222 */         this.jLabel24.setText("$0.00");
/*      */       } 
/* 2224 */       sacarMayor2();
/* 2225 */       this.jDialog5.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 2230 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTextField12KeyReleased(KeyEvent evt) {
/* 2234 */     consultar3();
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 2238 */     if (this.jComboBox2.getSelectedIndex() == 0) {
/* 2239 */       this.jLabel59.setText("Lista de Reposiciones");
/*      */     } else {
/* 2241 */       this.jLabel59.setText("Lista de Reposiciones de " + String.valueOf(this.jComboBox2.getSelectedItem()));
/*      */     } 
/* 2243 */     consultar3();
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 2247 */     if (this.jComboBox2.getSelectedIndex() == 0) {
/* 2248 */       this.jLabel59.setText("Lista de Reposiciones");
/*      */     } else {
/* 2250 */       this.jLabel59.setText("Lista de Reposiciones de " + String.valueOf(this.jComboBox2.getSelectedItem()));
/*      */     } 
/* 2252 */     consultar3();
/* 2253 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 2257 */     this.error.pasarModal(true);
/* 2258 */     this.val.pasarModal(Boolean.valueOf(true));
/* 2259 */     String cant = this.jFormattedTextField1.getValue().toString();
/* 2260 */     if (this.SALDOACTUAL < Double.parseDouble(cant)) {
/* 2261 */       this.jFormattedTextField1.setBackground(new Color(255, 51, 51));
/* 2262 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes dar el vale por la cantidad que tecleaste, tu saldo es insuficiente\nVerifica tus saldos por favor.", "Saldo Insuficiente", 0, this.ADVER);
/*      */     }
/* 2264 */     else if (this.jTextField6.getText().equals("")) {
/* 2265 */       JOptionPane.showMessageDialog(this.jDialog1, "Te falta agregar la información del deudor por favor verifica tu información", "Falta Deudor", 0, this.ADVER);
/* 2266 */     } else if (this.jRadioButton5.isSelected() && this.jTextField7.getText().equals("")) {
/* 2267 */       this.error.cargarError(this.jTextField7, "050");
/* 2268 */     } else if (this.jFormattedTextField1.getText().equals("$0.00")) {
/* 2269 */       this.error.cargarError(this.jFormattedTextField1, "050");
/* 2270 */     } else if (Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue())) < 5.0D) {
/* 2271 */       this.jFormattedTextField1.setBackground(new Color(255, 51, 51));
/* 2272 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes dar vales por una cantidad menor de $5.00, Verifica tu información", "Cantidad Pequeña", 0, this.ERROR);
/* 2273 */     } else if (!this.val.validarApostrofe(this.jTextField7, this.jTextField7.getText(), "020") && 
/* 2274 */       !this.val.validarSoloNum(this.jTextField9, this.jTextField9.getText()) && 
/* 2275 */       !this.val.validarSoloNum(this.jTextField13, this.jTextField13.getText()) && 
/* 2276 */       !this.val.validarSoloNum(this.jTextField15, this.jTextField15.getText())) {
/* 2277 */       if (this.jTextArea1.getText().equals("")) {
/* 2278 */         this.error.cargarError(this.jTextArea1, "050");
/* 2279 */       } else if (!this.val.validarTexto(this.jTextArea1, this.jTextArea1.getText(), "020")) {
/* 2280 */         String concep = "";
/* 2281 */         int Tconcep = 0;
/* 2282 */         int cargo = 0;
/* 2283 */         String cargoLetra = "";
/* 2284 */         if (this.jRadioButton3.isSelected()) {
/* 2285 */           concep = "GASTOS POR COMPROBAR";
/* 2286 */           Tconcep = 1;
/* 2287 */           cargo = 1;
/* 2288 */           cargoLetra = "Cargo a T.D.";
/* 2289 */         } else if (this.jRadioButton4.isSelected()) {
/* 2290 */           concep = "PRÉSTAMO PERSONAL";
/* 2291 */           Tconcep = 2;
/* 2292 */           cargo = 2;
/* 2293 */           cargoLetra = "Cargo a T.D.";
/*      */         } else {
/* 2295 */           concep = this.jTextField7.getText().toUpperCase();
/* 2296 */           Tconcep = 1;
/*      */         } 
/* 2298 */         boolean entra = false;
/*      */         
/* 2300 */         if (this.jRadioButton5.isSelected()) {
/* 2301 */           if (this.jRadioButton6.isSelected()) {
/* 2302 */             cargo = 1;
/* 2303 */             Tconcep = 1;
/* 2304 */             cargoLetra = "Cargo a T.D.";
/* 2305 */           } else if (this.jRadioButton7.isSelected()) {
/* 2306 */             cargo = 2;
/* 2307 */             cargoLetra = "Sin Cargo";
/* 2308 */             entra = true;
/*      */           } 
/*      */         }
/*      */         
/* 2312 */         if (entra) {
/* 2313 */           JOptionPane.showMessageDialog(this.jDialog1, "<html>Al seleccionar <font color = blue><b>sin cargo a T.D.</b></font> los saldos de la tarjeta deudor no se modificarán<html>", "Movimiento Sin Cargo", 0, this.ADVER);
/*      */         }
/* 2315 */         String[] campos = { "Folio", "Fecha", "Nombre", "Concepto", "Monto", "Unidad", "Remolque 1", "Remolque 2", "Observaciones" };
/* 2316 */         String[] info = { this.jTextField4.getText(), this.jTextField5.getText(), this.jTextField6.getText(), concep, this.jFormattedTextField1.getText(), this.jTextField9.getText(), this.jTextField13.getText(), this.jTextField15.getText(), this.jTextArea1.getText() };
/* 2317 */         int res = this.error.cargarDatos(campos, info);
/* 2318 */         if (res == 0) {
/* 2319 */           String importeL = this.jFormattedTextField1.getText();
/* 2320 */           double total = 0.0D;
/* 2321 */           this.encontrado = this.con.consultar("saldoFinal", "tarjeta_contenido", "where tarjeta = " + this.CLAVEOP);
/* 2322 */           if (this.encontrado) {
/* 2323 */             this.encontrado = this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + this.CLAVEOP);
/* 2324 */             String saldoFinal = this.con.Campo;
/* 2325 */             total = Double.parseDouble(saldoFinal) + Double.parseDouble(cant);
/*      */           } else {
/* 2327 */             total = Double.parseDouble(cant);
/*      */           } 
/* 2329 */           cant = this.jFormattedTextField1.getValue().toString();
/* 2330 */           this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 2331 */           String saldoFinalL = this.jFormattedTextField2.getText();
/* 2332 */           sacarMayor();
/* 2333 */           this.con.inserSinMsj("insert into valesgastos(folio_valegastos,fecha,tipoConcepto,concepto,montoletra,monto,unidad,rem1,rem2,cargoLetra,cargo,obser,repuesto,estatus,tarjeta,usuario,nombre_usu,motivo,folio_repo)values('" + this.jTextField4.getText() + "',now()," + Tconcep + ",'" + concep + "','" + this.jFormattedTextField1.getText() + "'," + cant + ",'" + this.jTextField9.getText() + "','" + this.jTextField13.getText() + "','" + this.jTextField15.getText() + "','" + cargoLetra + "'," + cargo + ",'" + this.jTextArea1.getText().toUpperCase() + "',1,'<Por Reponer>'," + this.CLAVEOP + ",'" + this.NOMBRE + "','" + this.USUARIO + "','',0)");
/* 2334 */           if (!entra) {
/* 2335 */             this.con.inserSinMsj("insert into tarjeta_contenido(fecha1,fecha2,fecha,tipoConcep,concepto,referencia,importe,importeLetra,abono,abonoLetra,importeSaldado,importeRestante,observaciones,estatus,MOTIVO,tipo,folio_vale,repuesto,saldoFinal,saldoFinalLetra,TARJETA) values(now(),now(),now()," + Tconcep + ",'" + concep + "','VALE: " + this.jTextField4
/* 2336 */                 .getText() + "'," + cant + ",'" + this.jFormattedTextField1.getText() + "',0,'',0," + cant + ",'" + this.jTextArea1.getText().toUpperCase() + "','<Por Pagar>','',1,'" + this.jTextField4.getText() + "','NO'," + total + ",'" + saldoFinalL + "'," + this.CLAVEOP + ")");
/*      */             
/* 2338 */             this.con.inserSinMsj("update tarjeta_deudor set f_creacion=now(), usuario_creo='" + this.USUARIO + "', saldo ='" + saldoFinalL + "' where tarjeta = " + this.CLAVEOP);
/*      */           } 
/* 2340 */           sacarSaldos();
/*      */           
/* 2342 */           this.numLetra = new NumerosALetras(Double.parseDouble(cant), "MXN");
/* 2343 */           String letra = this.numLetra.regresaNumero();
/* 2344 */           String[] campos1 = { this.jTextField4.getText(), this.jTextField5.getText(), this.jTextField6.getText(), this.jFormattedTextField1.getText(), letra, cargoLetra, concep, this.NOMBRE, this.jTextField9.getText(), this.jTextField13.getText(), this.jTextField15.getText() };
/* 2345 */           ImprimirVale imp = new ImprimirVale();
/* 2346 */           imp.recibeDatos(campos1);
/* 2347 */           consultar();
/* 2348 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField11ActionPerformed(ActionEvent evt) {
/* 2359 */     this.jTable3.selectAll();
/* 2360 */     cargarDeudor();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 2364 */     if (this.jComboBox1.getItemCount() > 0) {
/* 2365 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 2370 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 2374 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 2378 */     String[] datos = { "FOLIO", "FECHA", "A NOMBRE DE", "CONCEPTO", "CARGO", "ECO", "MONTO", "DOCUMENTÓ", "ESTATUS" };
/* 2379 */     this.esc = new EscribirReporte("VALES DE GASTOS", this.jTable1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jTable1MouseClicked(MouseEvent evt) {
/* 2383 */     if (evt.getClickCount() == 2) {
/* 2384 */       verVale();
/*      */     } else {
/* 2386 */       this.jButton2.setEnabled(true);
/* 2387 */       this.jButton3.setEnabled(true);
/* 2388 */       if (this.jRadioButton2.isSelected()) {
/* 2389 */         this.jButton3.setEnabled(false);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 2395 */     verVale();
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 2399 */     this.jButton4.setEnabled(false);
/* 2400 */     consultar();
/*      */   }
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 2404 */     this.jButton4.setEnabled(true);
/* 2405 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel8MouseClicked(MouseEvent evt) {
/* 2409 */     this.con.consultar("motivo", "valesgastos", "where folio_valegastos = '" + this.jTextField4.getText() + "'");
/* 2410 */     if (this.con.Campo.equals("")) {
/* 2411 */       JOptionPane.showMessageDialog(this.jDialog1, "Este vale se encuentra totalmente activo", "Vale Activo", 0, this.INFO);
/*      */     } else {
/* 2413 */       JOptionPane.showMessageDialog(this.jDialog1, "Este es el motivo por el cual está cancelado el vale:\n<html><font color = red>" + this.con.Campo + "</font></html>", "Motivo de Cancelación", 0, this.INFO);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 2418 */     this.jTextField16.setText("");
/* 2419 */     this.jPasswordField1.setText("");
/* 2420 */     this.error.pasarModal(true);
/* 2421 */     this.val.pasarModal(Boolean.valueOf(true));
/* 2422 */     String num = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/* 2423 */     this.CLAVE = num;
/* 2424 */     this.con.consultar("tarjeta", "valesgastos", "where folio_valegastos = '" + this.CLAVE + "'");
/* 2425 */     this.CLAVEOP = this.con.Campo;
/* 2426 */     String estado = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 8));
/* 2427 */     if (!estado.equals("<Cancelado>")) {
/* 2428 */       int vecesMal = 0;
/* 2429 */       if (this.DEPARTAMENTO.equals("SUPER USUARIO")) {
/* 2430 */         this.USUARIOCANCEL = this.USUARIO;
/* 2431 */         this.jDialog4.setVisible(true);
/*      */       } else {
/* 2433 */         this.jDialog7.setVisible(true);
/*      */       } 
/*      */     } else {
/* 2436 */       JOptionPane.showMessageDialog(this.padre, "No puedes cancelar este vale porque ya se encuentra cancelado", "Vale Cancelado", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField14ActionPerformed(ActionEvent evt) {
/* 2441 */     cancelar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField14KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2449 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2453 */     this.jTextField14.setText("");
/* 2454 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 2458 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 2462 */     String[] datos = { "FOLIO", "FECHA", "CHEQUE", "BANCO", "IMPORTE", "NÚMVALES", "ESTATUS" };
/* 2463 */     this.esc = new EscribirReporte("REPOSICIONES", this.jTable4, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2467 */     int vales = Integer.parseInt(this.jLabel11.getText());
/* 2468 */     if (vales == 0) {
/* 2469 */       JOptionPane.showMessageDialog(this.jDialog5, "No puedes generar la solicitud porque no tienes vales asignados a la reposición", "Ningún Vale", 0, this.ERROR);
/* 2470 */     } else if (this.jTextField2.getText().equals("")) {
/* 2471 */       this.error.cargarError(this.jTextField2, "050");
/* 2472 */     } else if (this.jDateChooser5.getDate() == null) {
/* 2473 */       JOptionPane.showMessageDialog(this.jDialog5, "La fecha no la puedes dejar vacía por favor verifica tu información", "Falta Fecha", 0, this.ERROR);
/* 2474 */     } else if (this.jTextField8.getText().equals("")) {
/* 2475 */       this.error.cargarError(this.jTextField8, "050");
/* 2476 */     } else if (!this.val.validarApostrofe(this.jTextField2, this.jTextField2.getText(), "020") && 
/* 2477 */       !this.val.validarApostrofe(this.jTextField8, this.jTextField8.getText(), "020")) {
/* 2478 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas generar la nueva solicitud de reposición?", "Soliticar Reposición", 0, 3, this.PREG);
/* 2479 */       if (res == 0) {
/* 2480 */         Date fecha1 = this.jDateChooser5.getDate();
/* 2481 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2482 */         String cadenaFecha = "";
/* 2483 */         cadenaFecha = formato.format(fecha1);
/* 2484 */         String AÑO = cadenaFecha.substring(0, 4);
/* 2485 */         String MES = cadenaFecha.substring(4, 6);
/* 2486 */         String DIA = cadenaFecha.substring(6, 8);
/* 2487 */         this.fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 2488 */         sacarMayor2();
/* 2489 */         this.con.inserSinMsj("insert into reposiciones(folio_repo,fecha,cheque,fechacheque,banco,importe,importeLetra,cantVales,estatus,nombre_usu,motivo)values('" + this.FOLIOREPO + "',now(),'" + this.jTextField2.getText().toUpperCase() + "'," + this.fechaCompleta1 + ",'" + this.jTextField8.getText().toUpperCase() + "'," + this.MONTO + ",'" + this.jLabel13.getText() + "'," + this.jLabel11.getText() + ",'<Repuesta>','" + this.USUARIO.toUpperCase() + "','')");
/* 2490 */         this.fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/* 2491 */         String[] valesR = new String[this.jTable1.getRowCount()];
/* 2492 */         for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2493 */           valesR[i] = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 2494 */           this.con.inserSinMsj("update valesgastos set folio_repo = '" + this.FOLIOREPO + "', estatus='<Repuesto>' where folio_valegastos = '" + valesR[i] + "'");
/* 2495 */           this.con.inserSinMsj("update tarjeta_contenido set repuesto = 'SI' where folio_vale = '" + valesR[i] + "'");
/*      */         } 
/* 2497 */         JTable tabla = new JTable(this.jTable1.getRowCount(), 8);
/* 2498 */         for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 2499 */           tabla.setValueAt(this.jTable1.getValueAt(j, 0), j, 0);
/* 2500 */           tabla.setValueAt(this.jTable1.getValueAt(j, 1), j, 1);
/* 2501 */           tabla.setValueAt(this.jTable1.getValueAt(j, 2), j, 2);
/* 2502 */           tabla.setValueAt(this.jTable1.getValueAt(j, 3), j, 3);
/* 2503 */           String val = String.valueOf(this.jTable1.getValueAt(j, 4));
/* 2504 */           if (val.equals("Cargo a T.D.")) {
/* 2505 */             tabla.setValueAt("SI", j, 4);
/*      */           } else {
/* 2507 */             tabla.setValueAt("NO", j, 4);
/*      */           } 
/* 2509 */           tabla.setValueAt(this.jTable1.getValueAt(j, 5), j, 5);
/* 2510 */           tabla.setValueAt(this.jTable1.getValueAt(j, 6), j, 6);
/*      */         } 
/* 2512 */         Calendar ahoraCal = Calendar.getInstance();
/* 2513 */         ahoraCal.setTime(this.fecha);
/* 2514 */         String mesesito = "";
/* 2515 */         String hoy = "";
/* 2516 */         mesesito = "" + ahoraCal.get(2) + 1;
/* 2517 */         hoy = "" + ahoraCal.get(5);
/* 2518 */         if (ahoraCal.get(2) + 1 < 10) {
/* 2519 */           mesesito = "0" + mesesito;
/*      */         }
/* 2521 */         if (ahoraCal.get(5) < 10) {
/* 2522 */           hoy = "0" + hoy;
/*      */         }
/*      */         
/* 2525 */         this.FECHAIMP = hoy + "/" + hoy + "/" + mesesito;
/* 2526 */         this.USUARIOIMP = "Reposición de " + String.valueOf(this.jComboBox2.getSelectedItem());
/* 2527 */         this.USUARIOCHEQUE = String.valueOf(this.jComboBox2.getSelectedItem());
/* 2528 */         ImprimirRepo imp = new ImprimirRepo();
/* 2529 */         imp.recibeDatos(tabla);
/* 2530 */         this.jTextField2.setText("");
/* 2531 */         this.jTextField8.setText("");
/* 2532 */         sacarSaldos();
/* 2533 */         this.jDialog5.setVisible(false);
/* 2534 */         consultar();
/* 2535 */         consultar3();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 2542 */     verRepo();
/*      */   }
/*      */   
/*      */   private void jLabel8MouseEntered(MouseEvent evt) {
/* 2546 */     this.jLabel8.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel8MouseExited(MouseEvent evt) {
/* 2550 */     this.jLabel8.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel37MouseEntered(MouseEvent evt) {
/* 2554 */     this.jLabel37.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel37MouseExited(MouseEvent evt) {
/* 2558 */     this.jLabel37.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel40MouseEntered(MouseEvent evt) {
/* 2562 */     this.jLabel40.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel40MouseExited(MouseEvent evt) {
/* 2566 */     this.jLabel40.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel37MouseClicked(MouseEvent evt) {
/* 2570 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel44MouseEntered(MouseEvent evt) {
/* 2574 */     this.jLabel44.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel44MouseExited(MouseEvent evt) {
/* 2578 */     this.jLabel44.setForeground(Color.red);
/*      */   }
/*      */   
/*      */   private void jLabel44MouseClicked(MouseEvent evt) {
/* 2582 */     String[] datos = { "FOLIO", "FECHA", "A NOMBRE DE", "CONCEPTO", "CARGO", "ECO", "MONTO" };
/* 2583 */     this.esc = new EscribirReporte(this.jLabel31.getText().toUpperCase(), this.jTable2, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jLabel40MouseClicked(MouseEvent evt) {
/* 2587 */     JTable tabla = new JTable(this.jTable2.getRowCount(), 7);
/* 2588 */     for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2589 */       tabla.setValueAt(this.jTable2.getValueAt(i, 0), i, 0);
/* 2590 */       tabla.setValueAt(this.jTable2.getValueAt(i, 1), i, 1);
/* 2591 */       tabla.setValueAt(this.jTable2.getValueAt(i, 2), i, 2);
/* 2592 */       tabla.setValueAt(this.jTable2.getValueAt(i, 3), i, 3);
/* 2593 */       String val = String.valueOf(this.jTable2.getValueAt(i, 4));
/* 2594 */       if (val.equals("Cargo a T.D.")) {
/* 2595 */         tabla.setValueAt("SI", i, 4);
/*      */       } else {
/* 2597 */         tabla.setValueAt("NO", i, 4);
/*      */       } 
/* 2599 */       tabla.setValueAt(this.jTable2.getValueAt(i, 5), i, 5);
/* 2600 */       tabla.setValueAt(this.jTable2.getValueAt(i, 6), i, 6);
/*      */     } 
/* 2602 */     this.USUARIOIMP = "REIMPRESIÓN - " + this.jLabel30.getText();
/* 2603 */     this.jLabel13.setText(this.jLabel43.getText());
/* 2604 */     this.jLabel11.setText(this.jLabel42.getText());
/* 2605 */     this.jLabel28.setText(this.jLabel31.getText());
/* 2606 */     ImprimirRepo imp = new ImprimirRepo();
/* 2607 */     imp.recibeDatos(tabla);
/* 2608 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField16FocusLost(FocusEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 2616 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {
/* 2620 */     ventana();
/*      */   }
/*      */   
/*      */   private void jTextField16ActionPerformed(ActionEvent evt) {
/* 2624 */     ventana();
/*      */   }
/*      */   
/*      */   private void jPasswordField1ActionPerformed(ActionEvent evt) {
/* 2628 */     ventana();
/*      */   }
/*      */   public void ventana() {
/* 2631 */     boolean encontrado = false;
/* 2632 */     String nombre = this.jTextField16.getText().toUpperCase();
/* 2633 */     String contra = this.jPasswordField1.getText().toUpperCase();
/* 2634 */     if (nombre.equals("") || contra.equals("")) {
/* 2635 */       JOptionPane.showMessageDialog(this, "Dejaste información sin contestar, por favor verifícala.", "Información Incompleta", 2, this.ADVER);
/*      */     } else {
/* 2637 */       boolean n1 = false;
/* 2638 */       boolean n2 = false;
/* 2639 */       encontrado = this.con.consultar("num_emp", "usuarios", " where nombre_usu = '" + nombre + "' and contra = '" + contra + "'");
/* 2640 */       if (this.con.Campo.equals("0")) {
/* 2641 */         this.jDialog7.setVisible(false);
/* 2642 */         this.jDialog4.setVisible(true);
/* 2643 */       } else if (encontrado == true) {
/* 2644 */         String depa = this.con.Campo;
/* 2645 */         this.con.consultar("priv", "usuarios", "where nombre_usu = '" + nombre + "'");
/* 2646 */         depa = this.con.Campo;
/* 2647 */         if (depa.equals("SUPER USUARIO")) {
/*      */           
/* 2649 */           this.USUARIOCANCEL = nombre;
/* 2650 */           setVisible(true);
/* 2651 */           this.jDialog7.setVisible(false);
/* 2652 */           this.jDialog4.setVisible(true);
/*      */         } else {
/* 2654 */           JOptionPane.showMessageDialog(this.jDialog7, "No puedes entrar a este módulo, ya que está restringido para todo personal\n que no tenga privilegios de super usuario.", "No Tiene Privilegios", 0, this.ERROR);
/*      */         } 
/*      */       } else {
/* 2657 */         n1 = this.con.consultar("nombre_usu", "usuarios", "where nombre_usu='" + nombre + "'");
/* 2658 */         n2 = this.con.consultar("nombre_usu", "usuarios", "where nombre_usu = '" + nombre + "' and contra='" + contra + "'");
/* 2659 */         if (!n1) {
/* 2660 */           JOptionPane.showMessageDialog(this.jDialog7, "El nombre de usuario no se encuentra registrado en la base de datos\nVerifica tu Información", "Usuario Incorrecto", 0, this.ERROR);
/* 2661 */           this.jTextField1.setText("");
/* 2662 */           this.vecesMal++;
/* 2663 */           if (this.vecesMal >= 4) {
/* 2664 */             JOptionPane.showMessageDialog(this.jDialog7, "Has intentado entrar al sistema con una información incorrecta en más de tres\nocasiones, el sistema se cerrará por seguridad.", "El sistema se cerrará", 0, this.ERROR);
/* 2665 */             System.exit(0);
/*      */           } 
/* 2667 */         } else if (!n2) {
/* 2668 */           JOptionPane.showMessageDialog(this.jDialog7, "La contraseña no coincide con el nombre de usuario.\nVerifica tu Información", "Usuario Incorrecto", 0, this.ERROR);
/* 2669 */           this.jPasswordField1.setText("");
/* 2670 */           this.vecesMal++;
/* 2671 */           if (this.vecesMal >= 4) {
/* 2672 */             JOptionPane.showMessageDialog(this, "Has intentado entrar al sistema con una información incorrecta en más de tres\nocasiones, el sistema se cerrará por seguridad.", "El sistema se cerrará", 0, this.ERROR);
/* 2673 */             System.exit(0);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Float redondear(float pasar) {
/* 2681 */     NumberFormat nf = NumberFormat.getInstance();
/* 2682 */     nf.setMaximumFractionDigits(2);
/* 2683 */     String st = nf.format(pasar);
/* 2684 */     return Float.valueOf(Float.parseFloat(st));
/*      */   }
/*      */   
/*      */   public void verRepo() {
/* 2688 */     Calendar ahoraCal = Calendar.getInstance();
/* 2689 */     ahoraCal.setTime(this.fecha);
/* 2690 */     String mesesito = "";
/* 2691 */     String hoy = "";
/* 2692 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 2693 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 2695 */     if (ahoraCal.get(2) + 1 < 10) {
/* 2696 */       mesesito = "0" + mesesito;
/*      */     }
/* 2698 */     if (ahoraCal.get(5) < 10) {
/* 2699 */       hoy = "0" + hoy;
/*      */     }
/* 2701 */     String folio = String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0));
/* 2702 */     this.jLabel31.setText("Folio Reposición: " + folio);
/* 2703 */     this.jLabel35.setText(hoy + "/" + hoy + "/" + mesesito);
/* 2704 */     this.jDialog6.setTitle("Reposición - " + folio);
/* 2705 */     String[] campos = this.con.regresaReg("nombre,ap_pat,ap_mat,fecha,cantVales,importeLetra,cheque,banco,fechaCheque", "usuarios,empleados,reposiciones", "where reposiciones.nombre_usu = usuarios.nombre_usu and usuarios.num_emp = empleados.clave_emp and reposiciones.folio_repo = '" + folio + "'", 9);
/* 2706 */     this.jLabel30.setText("Reposición de " + campos[0] + " " + campos[1] + " " + campos[2]);
/* 2707 */     String año = campos[3].substring(0, 4);
/* 2708 */     String mes = campos[3].substring(5, 7);
/* 2709 */     String dia = campos[3].substring(8, 10);
/* 2710 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 2711 */     this.jTextField2.setText(campos[6]);
/* 2712 */     this.jTextField8.setText(campos[7]);
/* 2713 */     this.USUARIOCHEQUE = campos[0] + " " + campos[0] + " " + campos[1];
/* 2714 */     this.FECHAIMP = strFecha;
/* 2715 */     this.jLabel32.setText("Fecha: " + strFecha);
/* 2716 */     this.jLabel42.setText(campos[4] + " vales");
/* 2717 */     this.jLabel43.setText(campos[5]);
/* 2718 */     this.fechaCompleta1 = campos[8].substring(8, 10) + "/" + campos[8].substring(8, 10) + "/" + campos[8].substring(5, 7);
/*      */     
/* 2720 */     this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 2721 */           .buscarDatos(7, "folio_valegastos,fecha,nombreCompleto,concepto,cargoLetra,unidad,montoLetra", "valesgastos,tarjeta_deudor", "where tarjeta_deudor.tarjeta = valesgastos.tarjeta and folio_repo = '" + folio + "' order by folio_valegastos desc"), (Object[])new String[] { "Folio", "Fecha", "Nombre", "Concepto", "Cargo", "Eco", "Monto" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 2726 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2731 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2734 */     this.jTable2.setShowVerticalLines(false);
/* 2735 */     this.jScrollPane5.setViewportView(this.jTable2);
/* 2736 */     this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(70);
/* 2737 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(70);
/* 2738 */     this.jTable2.getColumnModel().getColumn(1).setPreferredWidth(110);
/* 2739 */     this.jTable2.getColumnModel().getColumn(1).setMaxWidth(110);
/* 2740 */     this.jTable2.getColumnModel().getColumn(4).setPreferredWidth(75);
/* 2741 */     this.jTable2.getColumnModel().getColumn(4).setMaxWidth(75);
/* 2742 */     this.jTable2.getColumnModel().getColumn(5).setPreferredWidth(40);
/* 2743 */     this.jTable2.getColumnModel().getColumn(5).setMaxWidth(40);
/* 2744 */     this.jTable2.getColumnModel().getColumn(6).setPreferredWidth(90);
/* 2745 */     this.jTable2.getColumnModel().getColumn(6).setMaxWidth(90);
/*      */     
/* 2747 */     this.jTable2.setSelectionMode(0);
/* 2748 */     this.jTable2.setAutoCreateRowSorter(true);
/* 2749 */     this.jTable2.getTableHeader().setReorderingAllowed(false);
/* 2750 */     this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 2751 */     this.jDialog6.setVisible(true);
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 2755 */     String motivo = this.jTextField14.getText();
/* 2756 */     if (motivo.equals("")) {
/* 2757 */       this.error.cargarError(this.jTextField14, "050");
/* 2758 */     } else if (!this.val.validarApostrofe(this.jTextField14, motivo, "020")) {
/* 2759 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas cancelar el vale que seleccionaste?", "Cancelar Vale", 0, 3, this.PREG);
/* 2760 */       if (res == 0) {
/* 2761 */         this.con.inserSinMsj("update valesgastos set estatus = '<Cancelado>', motivo = '" + this.jTextField16.getText().toUpperCase() + ": " + cargarFechaHoy2() + " - " + this.jTextField14.getText().toUpperCase() + "', monto=0.0, montoLetra ='$0.00' where folio_valegastos = '" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)) + "'");
/* 2762 */         this.con.inserSinMsj("update tarjeta_contenido set importeRestante=0, estatus = '<Cancelado>', motivo = '" + this.jTextField16.getText().toUpperCase() + ": " + cargarFechaHoy2() + " - " + this.jTextField14.getText().toUpperCase() + "' where folio_vale = '" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)) + "'");
/* 2763 */         this.con.consultar("sum(importeRestante)", "tarjeta_contenido", "where tarjeta = " + this.CLAVEOP);
/* 2764 */         double total = Double.parseDouble(this.con.Campo);
/* 2765 */         this.jFormattedTextField2.setValue(Double.valueOf(total));
/* 2766 */         this.con.consultar("max(mov)", "tarjeta_contenido", "where tarjeta = " + this.CLAVEOP);
/* 2767 */         this.con.inserSinMsj("update tarjeta_contenido set saldoFinal = " + total + ",saldoFinalLetra = '" + this.jFormattedTextField2.getText() + "' where mov = " + this.con.Campo);
/* 2768 */         this.con.inserSinMsj("update tarjeta_deudor set f_creacion=now(), usuario_creo='" + this.USUARIO + "', saldo ='" + this.jFormattedTextField2.getText() + "' where tarjeta = " + this.CLAVEOP);
/*      */         
/* 2770 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Canceló un Vale','Se ha cancelado el vale No: " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)) + "')");
/* 2771 */         this.con.inserSinMsj("insert into vales_cancelados (folio,fecha_vale,fecha_cancel,nombre,concepto,unidad,cargoLetra, nombre_usu,cancelo,motivo) values ('" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)) + "', '" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1)) + "',now(),'" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2)) + "','" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3)) + "','" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5)) + "','" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6)) + "','" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 7)) + "','" + this.USUARIOCANCEL + "','" + this.jTextField14.getText().toUpperCase() + "')");
/*      */         
/* 2773 */         consultar();
/* 2774 */         this.jDialog4.setVisible(false);
/* 2775 */         this.jTextField14.setText("");
/* 2776 */         sacarSaldos();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verVale() {
/* 2782 */     this.jRadioButton6.setSelected(true);
/* 2783 */     String folio = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/* 2784 */     int indice = this.jTable1.getSelectedRow();
/* 2785 */     String fecha = String.valueOf(this.jTable1.getValueAt(indice, 1));
/*      */     
/* 2787 */     String FechaNormal = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 2788 */     String[] reg = this.con.regresaReg("tipoConcepto,cargo,monto,obser,rem1,rem2", "valesgastos", "where folio_valegastos = '" + folio + "'", 6);
/* 2789 */     this.jTextField4.setText(folio);
/* 2790 */     this.jTextField5.setText(FechaNormal);
/* 2791 */     this.jTextField6.setText(String.valueOf(this.jTable1.getValueAt(indice, 2)));
/* 2792 */     this.jTextField7.setText("");
/* 2793 */     System.out.println("folio " + reg[1]);
/*      */     
/* 2795 */     if (reg[0].equals("1")) {
/* 2796 */       this.jRadioButton3.setSelected(true);
/* 2797 */       this.jRadioButton6.setSelected(true);
/* 2798 */     } else if (reg[0].equals("2")) {
/* 2799 */       this.jRadioButton4.setSelected(true);
/* 2800 */       this.jRadioButton7.setSelected(true);
/*      */     } else {
/* 2802 */       this.jRadioButton5.setSelected(true);
/* 2803 */       this.jTextField7.setText(String.valueOf(this.jTable1.getValueAt(indice, 3)));
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
/* 2822 */     this.jFormattedTextField1.setText(String.valueOf(this.jTable1.getValueAt(indice, 6)));
/* 2823 */     this.jTextField9.setText(String.valueOf(this.jTable1.getValueAt(indice, 5)));
/* 2824 */     this.jTextArea1.setText(reg[3]);
/* 2825 */     this.jTextField13.setText(reg[4]);
/* 2826 */     this.jTextField15.setText(reg[5]);
/* 2827 */     this.jLabel8.setVisible(true);
/* 2828 */     this.jTextField7.setEditable(false);
/* 2829 */     this.jButton5.setEnabled(false);
/* 2830 */     this.jRadioButton3.setEnabled(false);
/* 2831 */     this.jRadioButton4.setEnabled(false);
/* 2832 */     this.jRadioButton5.setEnabled(false);
/* 2833 */     this.jFormattedTextField1.setEnabled(false);
/* 2834 */     this.jTextArea1.setEnabled(false);
/* 2835 */     this.jTextField9.setEnabled(false);
/* 2836 */     this.jTextField13.setEnabled(false);
/* 2837 */     this.jTextField15.setEnabled(false);
/* 2838 */     this.jButton8.setEnabled(false);
/* 2839 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 2843 */     this.jButton2.setEnabled(false);
/* 2844 */     this.jButton3.setEnabled(false);
/* 2845 */     String repuesto = "";
/* 2846 */     String clave = this.jTextField1.getText();
/* 2847 */     String nombre = "";
/* 2848 */     String concep = this.jTextField3.getText();
/* 2849 */     String usuario = " and nombre_usu like '%%'";
/* 2850 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 2851 */       nombre = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     }
/* 2853 */     if (this.jRadioButton1.isSelected()) {
/* 2854 */       repuesto = "<Por Reponer>";
/* 2855 */       usuario = " and nombre_usu = '" + this.USUARIO + "'";
/*      */     } 
/* 2857 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2858 */           .buscarDatos(9, "folio_valegastos,fecha,nombreCompleto,concepto,cargoLetra,Unidad,montoLetra,usuario,valesgastos.estatus", "valesgastos,tarjeta_deudor", "where tarjeta_deudor.tarjeta = valesgastos.tarjeta and folio_valegastos like '%" + clave + "%' and concepto like '%" + this.jTextField3.getText() + "%' and nombreCompleto like '%" + nombre + "%' and (valesgastos.estatus like '%" + repuesto + "%' || valesgastos.estatus = '<cancelado>') " + usuario + " order by num desc"), (Object[])new String[] { "Folio", "Fecha", "A Nombre De", "Concepto", "Cargo", "Eco", "Monto", "Documentó", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 2863 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2868 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2871 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable1.getRowCount() + "</HTML>");
/* 2872 */     this.celda.pasarInd(this.con.revisarCol(this.jTable1, "<Cancelado>", 0, 8, 0));
/* 2873 */     this.celda.pasarInd2(this.con.revisarCol(this.jTable1, "<Por Reponer>", 0, 8, 0));
/*      */     
/* 2875 */     this.jTable1.setShowVerticalLines(false);
/* 2876 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/* 2878 */     this.jTable1.setSelectionMode(0);
/* 2879 */     this.jTable1.setAutoCreateRowSorter(true);
/* 2880 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 2882 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 2883 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
/* 2884 */     this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(110);
/* 2885 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(110);
/* 2886 */     this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(65);
/* 2887 */     this.jTable1.getColumnModel().getColumn(4).setMaxWidth(65);
/* 2888 */     this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
/* 2889 */     this.jTable1.getColumnModel().getColumn(5).setMaxWidth(40);
/* 2890 */     this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);
/* 2891 */     this.jTable1.getColumnModel().getColumn(6).setMaxWidth(80);
/* 2892 */     this.jTable1.getColumnModel().getColumn(7).setPreferredWidth(170);
/* 2893 */     this.jTable1.getColumnModel().getColumn(7).setMaxWidth(170);
/* 2894 */     this.jTable1.getColumnModel().getColumn(8).setPreferredWidth(80);
/* 2895 */     this.jTable1.getColumnModel().getColumn(8).setMaxWidth(80);
/*      */     
/* 2897 */     this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 2898 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 2899 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 2900 */     this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2901 */     this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2902 */     this.jTable1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 2903 */     this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 2904 */     this.jTable1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 2905 */     this.jTable1.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void cajaChica(String usu) {
/* 2909 */     this.USUARIO = usu;
/* 2910 */     this.con.consultar("nombre", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + this.USUARIO + "'");
/* 2911 */     this.NOMBRE = this.con.Campo;
/* 2912 */     this.con.consultar("ap_pat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + this.USUARIO + "'");
/* 2913 */     this.NOMBRE = this.NOMBRE + " " + this.NOMBRE;
/* 2914 */     this.con.consultar("ap_mat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + this.USUARIO + "'");
/* 2915 */     this.NOMBRE = this.NOMBRE + " " + this.NOMBRE;
/* 2916 */     llenarCombos();
/* 2917 */     consultar();
/* 2918 */     this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 2919 */     this.DEPARTAMENTO = this.con.Campo;
/* 2920 */     if (this.con.Campo.equals("LIQUIDACIONES")) {
/* 2921 */       this.jComboBox2.setSelectedItem(this.NOMBRE);
/* 2922 */       this.jComboBox2.setEnabled(false);
/*      */     } else {
/* 2924 */       this.jComboBox2.setSelectedIndex(0);
/* 2925 */       this.jComboBox2.setEnabled(true);
/*      */     } 
/* 2927 */     sacarSaldos();
/* 2928 */     cargarFechaHoy();
/* 2929 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public void sacarSaldos() {
/* 2933 */     this.con.consultar("cajaChica", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 2934 */     this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(this.con.Campo)));
/* 2935 */     this.jLabel5.setText(this.jFormattedTextField2.getText());
/* 2936 */     double caja = Double.parseDouble(this.con.Campo);
/* 2937 */     this.encontrado = this.con.consultar("monto", "valesgastos", "where estatus='<por reponer>' and nombre_usu = '" + this.USUARIO + "'");
/* 2938 */     if (this.encontrado) {
/* 2939 */       this.con.consultar("sum(monto)", "valesgastos", "where estatus='<por reponer>' and nombre_usu = '" + this.USUARIO + "'");
/* 2940 */       this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(this.con.Campo)));
/* 2941 */       this.jLabel6.setText(this.jFormattedTextField2.getText());
/* 2942 */       this.MONTO = Double.parseDouble(this.con.Campo);
/* 2943 */       this.SALDOACTUAL = caja - this.MONTO;
/* 2944 */       this.jFormattedTextField2.setValue(Double.valueOf(this.SALDOACTUAL));
/* 2945 */       this.jLabel7.setText(this.jFormattedTextField2.getText());
/*      */     } else {
/* 2947 */       this.jLabel6.setText("$0.00");
/* 2948 */       this.jLabel7.setText(this.jFormattedTextField2.getText());
/* 2949 */       this.SALDOACTUAL = caja;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void llenarCombos() {
/* 2954 */     this.jComboBox1.removeAllItems();
/* 2955 */     this.jComboBox2.removeAllItems();
/* 2956 */     String[] datos = this.con.regresaColIndex("nombreCompleto", "tarjeta_deudor", "where tarjeta<>0 order by nombrecompleto");
/* 2957 */     this.jComboBox1.removeAllItems();
/* 2958 */     this.jComboBox1.addItem("TODOS");
/* 2959 */     for (int i = 0; i < datos.length; i++) {
/* 2960 */       this.jComboBox1.addItem(datos[i]);
/*      */     }
/*      */     
/* 2963 */     String[][] temp = this.con.buscarDatos(4, "nombre_usu,nombre,ap_pat,ap_mat", "usuarios,empleados", "where usuarios.num_emp = empleados.clave_emp and (priv = 'LIQUIDACIONES' || PRIV = 'JEFE DE LIQUIDACIONES' || priv ='SUPER USUARIO') and nombre_usu<>'usuarioadmin1' ORDER BY NOMBRE");
/* 2964 */     this.NOMBRES = new String[temp.length];
/* 2965 */     datos = new String[temp.length];
/* 2966 */     String[] datos1 = new String[temp.length];
/* 2967 */     String[] datos2 = new String[temp.length];
/*      */     int j;
/* 2969 */     for (j = 0; j < temp.length; j++) {
/* 2970 */       for (int k = 0; k < (temp[j]).length; k++) {
/* 2971 */         if (k == 0) {
/* 2972 */           this.NOMBRES[j] = temp[j][k];
/*      */         }
/* 2974 */         if (k == 1) {
/* 2975 */           datos[j] = temp[j][k];
/*      */         }
/* 2977 */         if (k == 2) {
/* 2978 */           datos1[j] = temp[j][k];
/*      */         }
/* 2980 */         if (k == 3) {
/* 2981 */           datos2[j] = temp[j][k];
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2986 */     this.jComboBox2.removeAllItems();
/* 2987 */     this.jComboBox2.addItem("TODOS");
/* 2988 */     for (j = 0; j < temp.length; j++) {
/* 2989 */       this.jComboBox2.addItem(datos[j] + " " + datos[j] + " " + datos1[j]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void consultar2() {
/* 2994 */     this.jButton20.setEnabled(false);
/* 2995 */     String num_ope = this.jTextField10.getText();
/* 2996 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 2997 */           .buscarDatos(2, "tarjeta,nombreCompleto", "tarjeta_deudor", "where tarjeta like '%" + num_ope + "%' and nombreCompleto like '%" + this.jTextField11.getText() + "%' AND ESTATUS ='<ACTIVA>' order by nombreCompleto"), (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 3002 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3007 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3010 */     this.jTable3.setShowVerticalLines(false);
/* 3011 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 3012 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 3013 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     
/* 3015 */     this.jTable3.setSelectionMode(0);
/* 3016 */     this.jTable3.setAutoCreateRowSorter(true);
/* 3017 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 3019 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 3020 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */   }
/*      */   
/*      */   public void consultar3() {
/* 3024 */     this.jButton26.setEnabled(false);
/* 3025 */     String clave = this.jTextField12.getText();
/* 3026 */     String nombre = "";
/* 3027 */     int indice = 0;
/* 3028 */     if (this.jComboBox2.getSelectedIndex() > 0) {
/* 3029 */       nombre = this.NOMBRES[this.jComboBox2.getSelectedIndex() - 1];
/*      */     }
/* 3031 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 3032 */           .buscarDatos(8, "folio_repo,fecha,cheque,banco,cantVales,nombre_usu,importeLetra,estatus", "reposiciones", "where folio_repo like '%" + clave + "%' and nombre_usu like '%" + nombre + "%' order by folio_repo desc"), (Object[])new String[] { "Folio", "Fecha", "Cheque", "Banco", "Vales", "Usuario", "Importe", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 3037 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3042 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3045 */     this.jTable4.setShowVerticalLines(false);
/* 3046 */     this.jScrollPane4.setViewportView(this.jTable4);
/* 3047 */     this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 3048 */     this.jTable4.getColumnModel().getColumn(0).setMaxWidth(60);
/* 3049 */     this.jTable4.getColumnModel().getColumn(1).setPreferredWidth(110);
/* 3050 */     this.jTable4.getColumnModel().getColumn(1).setMaxWidth(110);
/* 3051 */     this.jTable4.getColumnModel().getColumn(4).setPreferredWidth(45);
/* 3052 */     this.jTable4.getColumnModel().getColumn(4).setMaxWidth(45);
/* 3053 */     this.jTable4.getColumnModel().getColumn(5).setPreferredWidth(100);
/* 3054 */     this.jTable4.getColumnModel().getColumn(5).setMaxWidth(100);
/* 3055 */     this.jTable4.getColumnModel().getColumn(6).setPreferredWidth(80);
/* 3056 */     this.jTable4.getColumnModel().getColumn(6).setMaxWidth(80);
/* 3057 */     this.jTable4.getColumnModel().getColumn(7).setPreferredWidth(80);
/* 3058 */     this.jTable4.getColumnModel().getColumn(7).setMaxWidth(80);
/*      */     
/* 3060 */     this.jTable4.setSelectionMode(0);
/* 3061 */     this.jTable4.setAutoCreateRowSorter(true);
/* 3062 */     this.jTable4.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 3064 */     this.jTable4.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 3065 */     this.jTable4.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 3066 */     this.jTable4.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 3067 */     this.jTable4.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 3068 */     this.jTable4.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 3069 */     this.jTable4.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 3070 */     this.jTable4.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 3071 */     this.jTable4.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 3075 */     int cont = this.jTable3.getRowCount();
/* 3076 */     String[] registros = new String[cont]; int i;
/* 3077 */     for (i = 0; i < cont; i++) {
/* 3078 */       registros[i] = this.jTable3.getValueAt(i, destino).toString();
/*      */     }
/* 3080 */     for (i = 0; i < cont; i++) {
/* 3081 */       registros[i] = registros[i] + " " + registros[i];
/* 3082 */       this.jTable3.setValueAt(registros[i], i, destino);
/*      */     } 
/* 3084 */     TableColumn columna = this.jTable3.getColumn(nombreCol);
/* 3085 */     this.jTable3.removeColumn(columna);
/*      */   }
/*      */   
/*      */   class CeldaRender2
/*      */     extends DefaultTableCellRenderer {
/* 3090 */     int otro = -1;
/* 3091 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3094 */       setEnabled((table == null || table.isEnabled()));
/* 3095 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 3096 */       if (comparar(comp)) {
/* 3097 */         setBackground(Color.red);
/* 3098 */         setForeground(Color.white);
/* 3099 */       } else if (row % 2 == 0) {
/* 3100 */         setBackground(new Color(194, 213, 151));
/*      */       } else {
/* 3102 */         setBackground((Color)null);
/*      */       } 
/* 3104 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3105 */       return this;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 3109 */       for (int i = 0; i < this.indices.length; i++) {
/* 3110 */         if (this.indices[i].equals(reg)) {
/* 3111 */           return true;
/*      */         }
/*      */       } 
/* 3114 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 3120 */     int otro = -1;
/* 3121 */     String[] indices = new String[0];
/* 3122 */     String[] indices2 = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3125 */       setEnabled((table == null || table.isEnabled()));
/* 3126 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 3127 */       if (comparar(comp)) {
/* 3128 */         setBackground(Color.red);
/* 3129 */         setForeground(Color.white);
/* 3130 */         setHorizontalAlignment(2);
/* 3131 */       } else if (comparar2(comp)) {
/* 3132 */         setBackground(new Color(102, 153, 255));
/* 3133 */         setForeground(Color.BLUE);
/* 3134 */         setHorizontalAlignment(2);
/* 3135 */       } else if (row % 2 == 0 && column == 6) {
/* 3136 */         setBackground(new Color(120, 200, 104));
/* 3137 */       } else if (row % 2 == 0) {
/* 3138 */         setBackground(new Color(194, 213, 151));
/* 3139 */         setForeground(Color.black);
/* 3140 */         setHorizontalAlignment(2);
/* 3141 */         setForeground(Color.BLACK);
/*      */       } else {
/* 3143 */         setHorizontalAlignment(2);
/* 3144 */         setBackground((Color)null);
/* 3145 */         setForeground(Color.BLACK);
/*      */       } 
/* 3147 */       if (column == 6) {
/* 3148 */         setHorizontalAlignment(4);
/*      */       }
/*      */       
/* 3151 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3152 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 3156 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 3160 */       for (int i = 0; i < this.indices.length; i++) {
/* 3161 */         if (this.indices[i].equals(reg)) {
/* 3162 */           return true;
/*      */         }
/*      */       } 
/* 3165 */       return false;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 3169 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 3173 */       for (int i = 0; i < this.indices2.length; i++) {
/* 3174 */         if (this.indices2[i].equals(reg)) {
/* 3175 */           return true;
/*      */         }
/*      */       } 
/* 3178 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 3183 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3185 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3189 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 3192 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3194 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3198 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 3201 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3203 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3207 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 3210 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3212 */             cajaChica.this.jTextGanado(cajaChica.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3216 */             cajaChica.this.jTextPerdido(cajaChica.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 3219 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3221 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3225 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 3228 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3230 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3234 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField8, evt);
/*      */           }
/*      */         });
/* 3237 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3239 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3243 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField9, evt);
/*      */           }
/*      */         });
/* 3246 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3248 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3252 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField10, evt);
/*      */           }
/*      */         });
/* 3255 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3257 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField11, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3261 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField11, evt);
/*      */           }
/*      */         });
/* 3264 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3266 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3270 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField12, evt);
/*      */           }
/*      */         });
/* 3273 */     this.jTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3275 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField13, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3279 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField13, evt);
/*      */           }
/*      */         });
/* 3282 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3284 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField15, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3288 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField15, evt);
/*      */           }
/*      */         });
/* 3291 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3293 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField16, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3297 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField16, evt);
/*      */           }
/*      */         });
/* 3300 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3302 */             cajaChica.this.jTextGanado(cajaChica.this.jTextField14, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3306 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextField14, evt);
/*      */           }
/*      */         });
/* 3309 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3311 */             cajaChica.this.jTextGanado(cajaChica.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3315 */             cajaChica.this.jTextPerdido(cajaChica.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 3318 */     this.jTextArea1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3320 */             cajaChica.this.jTextGanado(cajaChica.this.jTextArea1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3324 */             cajaChica.this.jTextPerdido(cajaChica.this.jTextArea1, evt);
/*      */           }
/*      */         });
/* 3327 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3329 */             cajaChica.this.jTextGanado(cajaChica.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3333 */             cajaChica.this.jTextPerdido(cajaChica.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 3336 */     this.jPasswordField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3338 */             cajaChica.this.jTextGanado(cajaChica.this.jPasswordField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3342 */             cajaChica.this.jTextPerdido(cajaChica.this.jPasswordField1, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 3348 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 3352 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void cargarDeudor() {
/* 3356 */     int ind = this.jTable3.getSelectedRow();
/* 3357 */     this.CLAVEOP = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 3358 */     this.jTextField6.setText(String.valueOf(this.jTable3.getValueAt(ind, 1)));
/* 3359 */     String[] reg = this.con.regresaReg("tipo,num_ope", "tarjeta_deudor", "where tarjeta = " + this.CLAVEOP, 2);
/* 3360 */     if (reg[0].equals("OPERADOR")) {
/* 3361 */       this.encontrado = this.con.consultar("num_tracto", "llamadas_historicas,tarjeta_deudor", "where llamadas_historicas.num_ope = tarjeta_deudor.num_ope and tarjeta = " + this.CLAVEOP);
/* 3362 */       String[] campos = this.con.regresaReg("num_tracto,num_rem", "llamadas_historicas,tarjeta_deudor", "where llamadas_historicas.num_ope = tarjeta_deudor.num_ope and tarjeta = " + this.CLAVEOP, 2);
/* 3363 */       if (this.encontrado) {
/* 3364 */         this.jTextField9.setText(campos[0]);
/* 3365 */         this.jTextField13.setText(campos[1]);
/* 3366 */         this.jTextField15.setText("");
/*      */       } else {
/* 3368 */         this.jTextField13.setText("");
/* 3369 */         this.jTextField9.setText("");
/* 3370 */         this.jTextField15.setText("");
/*      */       } 
/* 3372 */       this.encontrado = this.con.consultar("guias.num_guia", "guias,llamadas_historicas,plataformas,operadores,emp_generadora", "where llamadas_historicas.num_ope = operadores.num_ope and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.clave_gene = emp_generadora.clave_gene and operadores.num_ope = " + reg[1] + " and num_vale='' and fecha>'2010-04-01' and guias.estado = 'ACTIVA' order by guias.num_guia desc");
/* 3373 */       this.jTextArea1.setText("");
/* 3374 */       if (this.encontrado) {
/* 3375 */         String[] regi = this.con.regresaReg("guias.num_guia,emp_generadora.empresa,plataforma,guias.tipo", "guias,llamadas_historicas,plataformas,operadores,emp_generadora", "where llamadas_historicas.num_ope = operadores.num_ope and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.clave_gene = emp_generadora.clave_gene and operadores.num_ope = " + reg[1] + " and num_vale='' and fecha>'2010-04-01' and guias.estado = 'activa' order by guias.num_guia desc", 4);
/* 3376 */         this.jTextArea1.setText("GUÍA: " + regi[0] + "\nCLIENTE: " + regi[1] + "\nORIGEN: " + regi[2] + "\nTIPO: " + regi[3]);
/*      */       } 
/*      */     } else {
/* 3379 */       this.jTextArea1.setText("");
/* 3380 */       this.jTextField9.setText("");
/* 3381 */       this.jTextField13.setText("");
/* 3382 */       this.jTextField15.setText("");
/*      */     } 
/* 3384 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   public void cargarFechaHoy() {
/* 3388 */     Calendar ahoraCal = Calendar.getInstance();
/* 3389 */     ahoraCal.setTime(this.fecha);
/* 3390 */     String mesesito = "";
/* 3391 */     String hoy = "";
/* 3392 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 3393 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 3395 */     if (ahoraCal.get(2) + 1 < 10) {
/* 3396 */       mesesito = "0" + mesesito;
/*      */     }
/* 3398 */     if (ahoraCal.get(5) < 10) {
/* 3399 */       hoy = "0" + hoy;
/*      */     }
/* 3401 */     this.jTextField5.setText(hoy + "/" + hoy + "/" + mesesito);
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy2() {
/* 3405 */     Calendar ahoraCal = Calendar.getInstance();
/* 3406 */     ahoraCal.setTime(this.fecha);
/* 3407 */     String mesesito = "";
/* 3408 */     String hoy = "";
/* 3409 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 3410 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 3412 */     if (ahoraCal.get(2) + 1 < 10) {
/* 3413 */       mesesito = "0" + mesesito;
/*      */     }
/* 3415 */     if (ahoraCal.get(5) < 10) {
/* 3416 */       hoy = "0" + hoy;
/*      */     }
/* 3418 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 3422 */     this.con.consultar("max(num)", "valesgastos", "");
/* 3423 */     String mayor = this.con.Campo;
/* 3424 */     int MAYOR = 0;
/*      */     try {
/* 3426 */       MAYOR = Integer.parseInt(mayor);
/* 3427 */     } catch (NumberFormatException e) {
/* 3428 */       MAYOR = 0;
/*      */     } 
/* 3430 */     MAYOR++;
/* 3431 */     if (MAYOR < 10) {
/* 3432 */       this.jTextField4.setText(this.DIRECTIVAS[0] + "-0000" + this.DIRECTIVAS[0]);
/* 3433 */     } else if (MAYOR < 100) {
/* 3434 */       this.jTextField4.setText(this.DIRECTIVAS[0] + "-000" + this.DIRECTIVAS[0]);
/* 3435 */     } else if (MAYOR < 1000) {
/* 3436 */       this.jTextField4.setText(this.DIRECTIVAS[0] + "-00" + this.DIRECTIVAS[0]);
/* 3437 */     } else if (MAYOR < 10000) {
/* 3438 */       this.jTextField4.setText(this.DIRECTIVAS[0] + "-0" + this.DIRECTIVAS[0]);
/*      */     } else {
/* 3440 */       this.jTextField4.setText(this.DIRECTIVAS[0] + "-" + this.DIRECTIVAS[0]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarMayor2() {
/* 3445 */     this.con.consultar("max(num)", "reposiciones", "");
/* 3446 */     String mayor = this.con.Campo;
/* 3447 */     int MAYOR = 0;
/*      */     try {
/* 3449 */       MAYOR = Integer.parseInt(mayor);
/* 3450 */     } catch (NumberFormatException e) {
/* 3451 */       MAYOR = 0;
/*      */     } 
/* 3453 */     MAYOR++;
/* 3454 */     if (MAYOR < 10) {
/* 3455 */       this.jLabel28.setText("Folio Reposición: " + this.DIRECTIVAS[0] + "-0000" + MAYOR);
/* 3456 */       this.FOLIOREPO = this.DIRECTIVAS[0] + "-0000" + this.DIRECTIVAS[0];
/* 3457 */     } else if (MAYOR < 100) {
/* 3458 */       this.jLabel28.setText("Folio Reposición: " + this.DIRECTIVAS[0] + "-000" + MAYOR);
/* 3459 */       this.FOLIOREPO = this.DIRECTIVAS[0] + "-000" + this.DIRECTIVAS[0];
/* 3460 */     } else if (MAYOR < 1000) {
/* 3461 */       this.jLabel28.setText("Folio Reposición: " + this.DIRECTIVAS[0] + "-00" + MAYOR);
/* 3462 */       this.FOLIOREPO = this.DIRECTIVAS[0] + "-00" + this.DIRECTIVAS[0];
/* 3463 */     } else if (MAYOR < 10000) {
/* 3464 */       this.jLabel28.setText("Folio Reposición: " + this.DIRECTIVAS[0] + "-0" + MAYOR);
/* 3465 */       this.FOLIOREPO = this.DIRECTIVAS[0] + "-0" + this.DIRECTIVAS[0];
/*      */     } else {
/* 3467 */       this.jLabel28.setText("Folio Reposición: " + this.DIRECTIVAS[0] + "-" + MAYOR);
/* 3468 */       this.FOLIOREPO = this.DIRECTIVAS[0] + "-" + this.DIRECTIVAS[0];
/*      */     } 
/*      */   }
/*      */   class ImprimirVale implements Printable { String[] DATOS;
/*      */     
/*      */     ImprimirVale() {
/* 3474 */       this.DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/*      */     } public int print(Graphics g, PageFormat f, int pageIndex) {
/*      */       Font fuente;
/* 3477 */       Graphics2D g2 = (Graphics2D)g;
/* 3478 */       switch (pageIndex) {
/*      */         case 0:
/* 3480 */           g.setColor(Color.black);
/* 3481 */           g2 = (Graphics2D)g;
/* 3482 */           fuente = new Font("ARIAL", 0, 11);
/* 3483 */           g.setFont(fuente);
/* 3484 */           g.drawString("FOLIO: " + this.DATOS[0], 25, 40);
/* 3485 */           g.drawString("FECHA: " + this.DATOS[1], 170, 40);
/* 3486 */           fuente = new Font("ARIAL", 0, 12);
/* 3487 */           g.setFont(fuente);
/* 3488 */           g.drawString(this.DATOS[2], 25, 90);
/* 3489 */           fuente = new Font("ARIAL", 0, 13);
/* 3490 */           g.setFont(fuente);
/* 3491 */           g.drawString("CANT. " + this.DATOS[3], 12, 140);
/* 3492 */           g.drawString("TIPO: " + this.DATOS[5], 164, 140);
/* 3493 */           fuente = new Font("ARIAL", 0, 9);
/* 3494 */           g.setFont(fuente);
/* 3495 */           g.drawString("(" + this.DATOS[4] + ")", 30, 160);
/* 3496 */           fuente = new Font("ARIAL", 0, 11);
/* 3497 */           g.setFont(fuente);
/* 3498 */           g.drawString(this.DATOS[6], 65, 250);
/* 3499 */           g.drawString(this.DATOS[7], 50, 345);
/*      */           
/* 3501 */           g.drawString("Tractor: " + this.DATOS[8], 30, 180);
/* 3502 */           g.drawString("Rem1: " + this.DATOS[9], 120, 180);
/* 3503 */           g.drawString("Rem2: " + this.DATOS[10], 210, 180);
/* 3504 */           return 0;
/*      */       } 
/* 3506 */       return 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public void recibeDatos(String[] datos) {
/* 3511 */       ImprimirVale im = new ImprimirVale();
/* 3512 */       im.DATOS = datos;
/* 3513 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 3514 */       job.setPrintable(im);
/* 3515 */       if (job.printDialog())
/*      */         try {
/* 3517 */           job.print();
/* 3518 */         } catch (PrinterException e) {
/* 3519 */           JOptionPane.showMessageDialog(null, "Error al imprimir " + e.getMessage());
/*      */         }  
/*      */     } }
/*      */   class ImprimirRepo implements Printable { String[] DATOS; int INDICE; int opc; Graphics2D g2; JTable tabla; int REG;
/*      */     int REGPIE;
/*      */     int contador;
/*      */     
/*      */     ImprimirRepo() {
/* 3527 */       this.DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/* 3528 */       this.INDICE = 0;
/* 3529 */       this.opc = -1;
/*      */       
/* 3531 */       this.tabla = new JTable(49, 7);
/* 3532 */       this.REG = 0;
/* 3533 */       this.REGPIE = 0;
/* 3534 */       this.contador = 0;
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat f, int pageIndex) {
/* 3538 */       this.g2 = (Graphics2D)g;
/* 3539 */       System.out.println("valor " + this.opc + " " + pageIndex);
/* 3540 */       if (this.opc == 0) {
/* 3541 */         switch (pageIndex) {
/*      */           case 0:
/* 3543 */             encabezado(1);
/* 3544 */             contenido(0);
/* 3545 */             return 0;
/*      */         } 
/* 3547 */       } else if (this.opc == 1) {
/* 3548 */         switch (pageIndex) {
/*      */           case 0:
/* 3550 */             encabezado(1);
/* 3551 */             contenido(0);
/* 3552 */             return 0;
/*      */           case 1:
/* 3554 */             encabezado(2);
/* 3555 */             contenido(1);
/* 3556 */             return 0;
/*      */         } 
/* 3558 */       } else if (this.opc == 2) {
/* 3559 */         switch (pageIndex) {
/*      */           case 0:
/* 3561 */             encabezado(1);
/* 3562 */             contenido(0);
/* 3563 */             return 0;
/*      */           case 1:
/* 3565 */             encabezado(2);
/* 3566 */             contenido(1);
/* 3567 */             return 0;
/*      */           case 2:
/* 3569 */             encabezado(3);
/* 3570 */             contenido(2);
/* 3571 */             return 0;
/*      */         } 
/* 3573 */       } else if (this.opc == 3) {
/* 3574 */         switch (pageIndex) {
/*      */           case 0:
/* 3576 */             encabezado(1);
/* 3577 */             contenido(0);
/* 3578 */             return 0;
/*      */           case 1:
/* 3580 */             encabezado(2);
/* 3581 */             contenido(1);
/* 3582 */             return 0;
/*      */           case 2:
/* 3584 */             encabezado(3);
/* 3585 */             contenido(2);
/* 3586 */             return 0;
/*      */           case 3:
/* 3588 */             encabezado(4);
/* 3589 */             contenido(3);
/* 3590 */             return 0;
/*      */         } 
/* 3592 */       } else if (this.opc == 4) {
/* 3593 */         switch (pageIndex) {
/*      */           case 0:
/* 3595 */             encabezado(1);
/* 3596 */             contenido(0);
/* 3597 */             return 0;
/*      */           case 1:
/* 3599 */             encabezado(2);
/* 3600 */             contenido(1);
/* 3601 */             return 0;
/*      */           case 2:
/* 3603 */             encabezado(3);
/* 3604 */             contenido(2);
/* 3605 */             return 0;
/*      */           case 3:
/* 3607 */             encabezado(4);
/* 3608 */             contenido(3);
/* 3609 */             return 0;
/*      */           case 4:
/* 3611 */             encabezado(5);
/* 3612 */             contenido(4);
/* 3613 */             return 0;
/*      */           case 5:
/* 3615 */             encabezado(6);
/* 3616 */             contenido(5);
/* 3617 */             return 0;
/*      */         } 
/* 3619 */       } else if (this.opc == 5) {
/* 3620 */         switch (pageIndex) {
/*      */           case 0:
/* 3622 */             encabezado(1);
/* 3623 */             contenido(0);
/* 3624 */             return 0;
/*      */           case 1:
/* 3626 */             encabezado(2);
/* 3627 */             contenido(1);
/* 3628 */             return 0;
/*      */           case 2:
/* 3630 */             encabezado(3);
/* 3631 */             contenido(2);
/* 3632 */             return 0;
/*      */           case 3:
/* 3634 */             encabezado(4);
/* 3635 */             contenido(3);
/* 3636 */             return 0;
/*      */           case 4:
/* 3638 */             encabezado(5);
/* 3639 */             contenido(4);
/* 3640 */             return 0;
/*      */           case 5:
/* 3642 */             encabezado(6);
/* 3643 */             contenido(5);
/* 3644 */             return 0;
/*      */         } 
/* 3646 */       } else if (this.opc == 6) {
/* 3647 */         switch (pageIndex) {
/*      */           case 0:
/* 3649 */             encabezado(1);
/* 3650 */             contenido(0);
/* 3651 */             return 0;
/*      */           case 1:
/* 3653 */             encabezado(2);
/* 3654 */             contenido(1);
/* 3655 */             return 0;
/*      */           case 2:
/* 3657 */             encabezado(3);
/* 3658 */             contenido(2);
/* 3659 */             return 0;
/*      */           case 3:
/* 3661 */             encabezado(4);
/* 3662 */             contenido(3);
/* 3663 */             return 0;
/*      */           case 4:
/* 3665 */             encabezado(5);
/* 3666 */             contenido(4);
/* 3667 */             return 0;
/*      */           case 5:
/* 3669 */             encabezado(6);
/* 3670 */             contenido(5);
/* 3671 */             return 0;
/*      */           case 6:
/* 3673 */             encabezado(7);
/* 3674 */             contenido(6);
/* 3675 */             return 0;
/*      */         } 
/* 3677 */       } else if (this.opc == 7) {
/* 3678 */         switch (pageIndex) {
/*      */           case 0:
/* 3680 */             encabezado(1);
/* 3681 */             contenido(0);
/* 3682 */             return 0;
/*      */           case 1:
/* 3684 */             encabezado(2);
/* 3685 */             contenido(1);
/* 3686 */             return 0;
/*      */           case 2:
/* 3688 */             encabezado(3);
/* 3689 */             contenido(2);
/* 3690 */             return 0;
/*      */           case 3:
/* 3692 */             encabezado(4);
/* 3693 */             contenido(3);
/* 3694 */             return 0;
/*      */           case 4:
/* 3696 */             encabezado(5);
/* 3697 */             contenido(4);
/* 3698 */             return 0;
/*      */           case 5:
/* 3700 */             encabezado(6);
/* 3701 */             contenido(5);
/* 3702 */             return 0;
/*      */           case 6:
/* 3704 */             encabezado(7);
/* 3705 */             contenido(6);
/* 3706 */             return 0;
/*      */           case 7:
/* 3708 */             encabezado(8);
/* 3709 */             contenido(7);
/* 3710 */             return 0;
/*      */         } 
/* 3712 */       } else if (this.opc == 8) {
/* 3713 */         switch (pageIndex) {
/*      */           case 0:
/* 3715 */             encabezado(1);
/* 3716 */             contenido(0);
/* 3717 */             return 0;
/*      */           
/*      */           case 1:
/* 3720 */             encabezado(2);
/* 3721 */             contenido(1);
/* 3722 */             return 0;
/*      */           case 2:
/* 3724 */             encabezado(3);
/* 3725 */             contenido(2);
/* 3726 */             return 0;
/*      */           case 3:
/* 3728 */             encabezado(4);
/* 3729 */             contenido(3);
/* 3730 */             return 0;
/*      */           case 4:
/* 3732 */             encabezado(5);
/* 3733 */             contenido(4);
/* 3734 */             return 0;
/*      */           case 5:
/* 3736 */             encabezado(6);
/* 3737 */             contenido(5);
/* 3738 */             return 0;
/*      */           case 6:
/* 3740 */             encabezado(7);
/* 3741 */             contenido(6);
/* 3742 */             return 0;
/*      */           case 7:
/* 3744 */             encabezado(8);
/* 3745 */             contenido(7);
/* 3746 */             return 0;
/*      */           case 8:
/* 3748 */             encabezado(9);
/* 3749 */             contenido(8);
/* 3750 */             return 0;
/*      */         } 
/*      */       } 
/* 3753 */       return 1;
/*      */     }
/*      */     
/*      */     public void encabezado(int pag) {
/* 3757 */       int PAG = pag;
/* 3758 */       Font fuente = new Font("Dialog", 0, 8);
/* 3759 */       this.g2.setFont(fuente);
/* 3760 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 3761 */       Image img = imagen.getImage();
/*      */       
/* 3763 */       this.g2.drawImage(img, 10, 12, 62, 62, null);
/* 3764 */       fuente = new Font("Dialog", 2, 16);
/* 3765 */       this.g2.setFont(fuente);
/* 3766 */       this.g2.drawString("FLETES Y MATERIALES GRUPO FORSIS S.A. DE C.V.", 78, 26);
/* 3767 */       this.g2.drawLine(78, 35, 585, 35);
/* 3768 */       fuente = new Font("Dialog", 2, 13);
/* 3769 */       this.g2.setFont(fuente);
/* 3770 */       this.g2.drawString(cajaChica.this.USUARIOIMP, 78, 48);
/* 3771 */       fuente = new Font("Dialog", 0, 13);
/* 3772 */       this.g2.setFont(fuente);
/* 3773 */       this.g2.drawString(cajaChica.this.jLabel28.getText(), 78, 65);
/* 3774 */       this.g2.drawString("Fecha: " + cajaChica.this.FECHAIMP, 275, 65);
/* 3775 */       this.g2.drawString("Estatus: <Repuesta>", 405, 65);
/* 3776 */       fuente = new Font("Dialog", 0, 9);
/* 3777 */       this.g2.setFont(fuente);
/* 3778 */       this.g2.drawString("Pág. " + PAG, 540, 65);
/* 3779 */       this.g2.drawString(cajaChica.this.jTextField5.getText(), 540, 55);
/* 3780 */       this.g2.drawLine(10, 75, 585, 75);
/* 3781 */       this.g2.drawLine(10, 76, 585, 76);
/* 3782 */       fuente = new Font("Dialog", 1, 9);
/* 3783 */       this.g2.setFont(fuente);
/* 3784 */       this.g2.drawString("Folio", 20, 88);
/* 3785 */       this.g2.drawString("Fecha", 75, 88);
/* 3786 */       this.g2.drawString("Nombre", 175, 88);
/* 3787 */       this.g2.drawString("Concepto", 350, 88);
/* 3788 */       this.g2.drawString("Cargo", 458, 88);
/* 3789 */       this.g2.drawString("Eco", 495, 88);
/* 3790 */       this.g2.drawString("Monto", 545, 88);
/* 3791 */       this.g2.drawLine(10, 94, 585, 94);
/* 3792 */       this.g2.drawLine(10, 95, 585, 95);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void piePag() {
/* 3800 */       this.REGPIE += 30;
/* 3801 */       this.g2.drawRect(15, this.REGPIE, 565, 55);
/* 3802 */       Font fuente = new Font("Dialog", 1, 9);
/* 3803 */       this.g2.setFont(fuente);
/* 3804 */       this.g2.drawString("Datos de la Reposición:", 18, this.REGPIE + 14);
/* 3805 */       fuente = new Font("Dialog", 0, 9);
/* 3806 */       this.g2.setFont(fuente);
/*      */       
/* 3808 */       this.g2.drawString("Cheque No:", 18, this.REGPIE + 39);
/* 3809 */       this.g2.drawString("Fecha:", 210, this.REGPIE + 39);
/* 3810 */       this.g2.drawString("Banco:", 382, this.REGPIE + 39);
/* 3811 */       this.g2.drawLine(70, this.REGPIE + 40, 200, this.REGPIE + 40);
/* 3812 */       this.g2.drawLine(242, this.REGPIE + 40, 372, this.REGPIE + 40);
/* 3813 */       this.g2.drawLine(413, this.REGPIE + 40, 567, this.REGPIE + 40);
/* 3814 */       this.g2.drawString(cajaChica.this.jTextField2.getText().toUpperCase(), 75, this.REGPIE + 37);
/* 3815 */       this.g2.drawString(cajaChica.this.fechaCompleta1, 247, this.REGPIE + 37);
/* 3816 */       this.g2.drawString(cajaChica.this.jTextField8.getText().toUpperCase(), 418, this.REGPIE + 37);
/*      */       
/* 3818 */       this.g2.drawLine(20, this.REGPIE + 56, 582, this.REGPIE + 56);
/* 3819 */       this.g2.drawLine(581, this.REGPIE + 2, 581, this.REGPIE + 57);
/* 3820 */       this.g2.drawLine(20, this.REGPIE + 57, 582, this.REGPIE + 57);
/* 3821 */       this.g2.drawLine(582, this.REGPIE + 2, 582, this.REGPIE + 57);
/*      */       
/* 3823 */       this.g2.drawString("Elaborado por", 80, this.REGPIE + 90);
/* 3824 */       this.g2.drawString("Revisado por", 280, this.REGPIE + 90);
/* 3825 */       this.g2.drawString("Autorizado por", 468, this.REGPIE + 90);
/* 3826 */       this.g2.drawLine(30, this.REGPIE + 140, 180, this.REGPIE + 140);
/* 3827 */       this.g2.drawLine(232, this.REGPIE + 140, 382, this.REGPIE + 140);
/* 3828 */       this.g2.drawLine(423, this.REGPIE + 140, 573, this.REGPIE + 140);
/* 3829 */       this.g2.drawString(cajaChica.this.USUARIOCHEQUE, 30, this.REGPIE + 130);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void contenido(int opcion) {
/* 3836 */       Font fuente = new Font("Dialog", 0, 8);
/* 3837 */       this.g2.setFont(fuente);
/* 3838 */       this.g2.setColor(Color.BLACK);
/* 3839 */       int renglon = 105;
/* 3840 */       if (opcion == 0) {
/* 3841 */         for (int i = 0; i < this.tabla.getRowCount(); i++) {
/* 3842 */           if (i > 64) {
/* 3843 */             this.REG = i;
/* 3844 */             this.g2.drawString(".....", 540, renglon);
/*      */             return;
/*      */           } 
/* 3847 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 0)), 13, renglon);
/* 3848 */           String fecha = String.valueOf(this.tabla.getValueAt(i, 1));
/* 3849 */           String fechaC = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3850 */           this.g2.drawString(fechaC, 65, renglon);
/* 3851 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 2)), 120, renglon);
/* 3852 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 3)), 320, renglon);
/* 3853 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 4)), 465, renglon);
/* 3854 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 5)), 497, renglon);
/* 3855 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 6)), 540, renglon);
/* 3856 */           renglon += 10;
/* 3857 */           this.REG = i;
/*      */         } 
/*      */         
/* 3860 */         if (this.opc == 0) {
/* 3861 */           this.g2.drawString("________", 10, renglon);
/* 3862 */           this.g2.drawString("" + this.REG + 1 + " vales", 26, renglon + 10);
/* 3863 */           this.g2.drawString("_____________", 520, renglon);
/* 3864 */           this.g2.drawString(cajaChica.this.jLabel13.getText(), 520, renglon + 10);
/* 3865 */           this.REGPIE = renglon;
/* 3866 */           piePag();
/*      */         } else {
/* 3868 */           this.g2.drawString(".....", 540, renglon);
/*      */         } 
/* 3870 */       } else if (opcion == 1) {
/* 3871 */         for (int i = 65; i < this.tabla.getRowCount(); i++) {
/* 3872 */           if (i > 129) {
/* 3873 */             this.REG = i;
/* 3874 */             this.g2.drawString(".....", 540, renglon);
/*      */             return;
/*      */           } 
/* 3877 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 0)), 13, renglon);
/* 3878 */           String fecha = String.valueOf(this.tabla.getValueAt(i, 1));
/* 3879 */           String fechaC = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3880 */           this.g2.drawString(fechaC, 65, renglon);
/* 3881 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 2)), 120, renglon);
/* 3882 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 3)), 320, renglon);
/* 3883 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 4)), 465, renglon);
/* 3884 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 5)), 497, renglon);
/* 3885 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 6)), 540, renglon);
/* 3886 */           renglon += 10;
/* 3887 */           this.REG = i;
/*      */         } 
/*      */         
/* 3890 */         if (this.opc == 1) {
/* 3891 */           this.g2.drawString("________", 10, renglon);
/* 3892 */           this.g2.drawString("" + this.REG + 1 + " vales", 26, renglon + 10);
/* 3893 */           this.g2.drawString("_____________", 520, renglon);
/* 3894 */           this.g2.drawString(cajaChica.this.jLabel13.getText(), 520, renglon + 10);
/* 3895 */           this.REGPIE = renglon;
/* 3896 */           piePag();
/*      */         } else {
/* 3898 */           this.g2.drawString(".....", 540, renglon);
/*      */         } 
/* 3900 */       } else if (opcion == 2) {
/* 3901 */         for (int i = 130; i < this.tabla.getRowCount(); i++) {
/* 3902 */           if (i > 194) {
/* 3903 */             this.REG = i;
/* 3904 */             this.g2.drawString(".....", 540, renglon);
/*      */             return;
/*      */           } 
/* 3907 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 0)), 13, renglon);
/* 3908 */           String fecha = String.valueOf(this.tabla.getValueAt(i, 1));
/* 3909 */           String fechaC = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3910 */           this.g2.drawString(fechaC, 65, renglon);
/* 3911 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 2)), 120, renglon);
/* 3912 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 3)), 320, renglon);
/* 3913 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 4)), 465, renglon);
/* 3914 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 5)), 497, renglon);
/* 3915 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 6)), 540, renglon);
/* 3916 */           renglon += 10;
/* 3917 */           this.REG = i;
/*      */         } 
/*      */         
/* 3920 */         if (this.opc == 2) {
/* 3921 */           this.g2.drawString("________", 10, renglon);
/* 3922 */           this.g2.drawString("" + this.REG + 1 + " vales", 26, renglon + 10);
/* 3923 */           this.g2.drawString("_____________", 520, renglon);
/* 3924 */           this.g2.drawString(cajaChica.this.jLabel13.getText(), 520, renglon + 10);
/* 3925 */           this.REGPIE = renglon;
/* 3926 */           piePag();
/*      */         } else {
/* 3928 */           this.g2.drawString(".....", 540, renglon);
/*      */         } 
/* 3930 */       } else if (opcion == 3) {
/* 3931 */         for (int i = 195; i < this.tabla.getRowCount(); i++) {
/* 3932 */           if (i > 259) {
/* 3933 */             this.REG = i;
/* 3934 */             this.g2.drawString(".....", 540, renglon);
/*      */             return;
/*      */           } 
/* 3937 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 0)), 13, renglon);
/* 3938 */           String fecha = String.valueOf(this.tabla.getValueAt(i, 1));
/* 3939 */           String fechaC = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3940 */           this.g2.drawString(fechaC, 65, renglon);
/* 3941 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 2)), 120, renglon);
/* 3942 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 3)), 320, renglon);
/* 3943 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 4)), 465, renglon);
/* 3944 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 5)), 497, renglon);
/* 3945 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 6)), 540, renglon);
/* 3946 */           renglon += 10;
/* 3947 */           this.REG = i;
/*      */         } 
/*      */         
/* 3950 */         if (this.opc == 3) {
/* 3951 */           this.g2.drawString("________", 10, renglon);
/* 3952 */           this.g2.drawString("" + this.REG + 1 + " vales", 26, renglon + 10);
/* 3953 */           this.g2.drawString("_____________", 520, renglon);
/* 3954 */           this.g2.drawString(cajaChica.this.jLabel13.getText(), 520, renglon + 10);
/* 3955 */           this.REGPIE = renglon;
/* 3956 */           piePag();
/*      */         } else {
/* 3958 */           this.g2.drawString(".....", 540, renglon);
/*      */         } 
/* 3960 */       } else if (opcion == 4) {
/* 3961 */         for (int i = 260; i < this.tabla.getRowCount(); i++) {
/* 3962 */           if (i > 324) {
/* 3963 */             this.REG = i;
/* 3964 */             this.g2.drawString(".....", 540, renglon);
/*      */             return;
/*      */           } 
/* 3967 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 0)), 13, renglon);
/* 3968 */           String fecha = String.valueOf(this.tabla.getValueAt(i, 1));
/* 3969 */           String fechaC = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3970 */           this.g2.drawString(fechaC, 65, renglon);
/* 3971 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 2)), 120, renglon);
/* 3972 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 3)), 320, renglon);
/* 3973 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 4)), 465, renglon);
/* 3974 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 5)), 497, renglon);
/* 3975 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 6)), 540, renglon);
/* 3976 */           renglon += 10;
/* 3977 */           this.REG = i;
/*      */         } 
/*      */         
/* 3980 */         if (this.opc == 4) {
/* 3981 */           this.g2.drawString("________", 10, renglon);
/* 3982 */           this.g2.drawString("" + this.REG + 1 + " vales", 26, renglon + 10);
/* 3983 */           this.g2.drawString("_____________", 520, renglon);
/* 3984 */           this.g2.drawString(cajaChica.this.jLabel13.getText(), 520, renglon + 10);
/* 3985 */           this.REGPIE = renglon;
/* 3986 */           piePag();
/*      */         } else {
/* 3988 */           this.g2.drawString(".....", 540, renglon);
/*      */         } 
/* 3990 */       } else if (opcion == 5) {
/* 3991 */         for (int i = 325; i < this.tabla.getRowCount(); i++) {
/* 3992 */           if (i > 389) {
/* 3993 */             this.REG = i;
/* 3994 */             this.g2.drawString(".....", 540, renglon);
/*      */             return;
/*      */           } 
/* 3997 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 0)), 13, renglon);
/* 3998 */           String fecha = String.valueOf(this.tabla.getValueAt(i, 1));
/* 3999 */           String fechaC = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4000 */           this.g2.drawString(fechaC, 65, renglon);
/* 4001 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 2)), 120, renglon);
/* 4002 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 3)), 320, renglon);
/* 4003 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 4)), 465, renglon);
/* 4004 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 5)), 497, renglon);
/* 4005 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 6)), 540, renglon);
/* 4006 */           renglon += 10;
/* 4007 */           this.REG = i;
/*      */         } 
/*      */         
/* 4010 */         if (this.opc == 5) {
/* 4011 */           this.g2.drawString("________", 10, renglon);
/* 4012 */           this.g2.drawString("" + this.REG + 1 + " vales", 26, renglon + 10);
/* 4013 */           this.g2.drawString("_____________", 520, renglon);
/* 4014 */           this.g2.drawString(cajaChica.this.jLabel13.getText(), 520, renglon + 10);
/* 4015 */           this.REGPIE = renglon;
/* 4016 */           piePag();
/*      */         } else {
/* 4018 */           this.g2.drawString(".....", 540, renglon);
/*      */         } 
/* 4020 */       } else if (opcion == 6) {
/* 4021 */         for (int i = 390; i < this.tabla.getRowCount(); i++) {
/* 4022 */           if (i > 454) {
/* 4023 */             this.REG = i;
/* 4024 */             this.g2.drawString(".....", 540, renglon);
/*      */             return;
/*      */           } 
/* 4027 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 0)), 13, renglon);
/* 4028 */           String fecha = String.valueOf(this.tabla.getValueAt(i, 1));
/* 4029 */           String fechaC = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4030 */           this.g2.drawString(fechaC, 65, renglon);
/* 4031 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 2)), 120, renglon);
/* 4032 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 3)), 320, renglon);
/* 4033 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 4)), 465, renglon);
/* 4034 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 5)), 497, renglon);
/* 4035 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 6)), 540, renglon);
/* 4036 */           renglon += 10;
/* 4037 */           this.REG = i;
/*      */         } 
/*      */         
/* 4040 */         if (this.opc == 6) {
/* 4041 */           this.g2.drawString("________", 10, renglon);
/* 4042 */           this.g2.drawString("" + this.REG + 1 + " vales", 26, renglon + 10);
/* 4043 */           this.g2.drawString("_____________", 520, renglon);
/* 4044 */           this.g2.drawString(cajaChica.this.jLabel13.getText(), 520, renglon + 10);
/* 4045 */           this.REGPIE = renglon;
/* 4046 */           piePag();
/*      */         } else {
/* 4048 */           this.g2.drawString(".....", 540, renglon);
/*      */         } 
/* 4050 */       } else if (opcion == 7) {
/* 4051 */         for (int i = 455; i < this.tabla.getRowCount(); i++) {
/* 4052 */           if (i > 519) {
/* 4053 */             this.REG = i;
/* 4054 */             this.g2.drawString(".....", 540, renglon);
/*      */             return;
/*      */           } 
/* 4057 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 0)), 13, renglon);
/* 4058 */           String fecha = String.valueOf(this.tabla.getValueAt(i, 1));
/* 4059 */           String fechaC = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4060 */           this.g2.drawString(fechaC, 65, renglon);
/* 4061 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 2)), 120, renglon);
/* 4062 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 3)), 320, renglon);
/* 4063 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 4)), 465, renglon);
/* 4064 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 5)), 497, renglon);
/* 4065 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 6)), 540, renglon);
/* 4066 */           renglon += 10;
/* 4067 */           this.REG = i;
/*      */         } 
/*      */         
/* 4070 */         if (this.opc == 7) {
/* 4071 */           this.g2.drawString("________", 10, renglon);
/* 4072 */           this.g2.drawString("" + this.REG + 1 + " vales", 26, renglon + 10);
/* 4073 */           this.g2.drawString("_____________", 520, renglon);
/* 4074 */           this.g2.drawString(cajaChica.this.jLabel13.getText(), 520, renglon + 10);
/* 4075 */           this.REGPIE = renglon;
/* 4076 */           piePag();
/*      */         } else {
/* 4078 */           this.g2.drawString(".....", 540, renglon);
/*      */         } 
/* 4080 */       } else if (opcion == 8) {
/* 4081 */         for (int i = 520; i < this.tabla.getRowCount(); i++) {
/* 4082 */           if (i > 584) {
/* 4083 */             this.REG = i;
/* 4084 */             this.g2.drawString(".....", 540, renglon);
/*      */             return;
/*      */           } 
/* 4087 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 0)), 13, renglon);
/* 4088 */           String fecha = String.valueOf(this.tabla.getValueAt(i, 1));
/* 4089 */           String fechaC = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4090 */           this.g2.drawString(fechaC, 65, renglon);
/* 4091 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 2)), 120, renglon);
/* 4092 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 3)), 320, renglon);
/* 4093 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 4)), 465, renglon);
/* 4094 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 5)), 497, renglon);
/* 4095 */           this.g2.drawString(String.valueOf(this.tabla.getValueAt(i, 6)), 540, renglon);
/* 4096 */           renglon += 10;
/* 4097 */           this.REG = i;
/*      */         } 
/*      */         
/* 4100 */         if (this.opc == 8) {
/* 4101 */           this.g2.drawString("________", 10, renglon);
/* 4102 */           this.g2.drawString("" + this.REG + 1 + " vales", 26, renglon + 10);
/* 4103 */           this.g2.drawString("_____________", 520, renglon);
/* 4104 */           this.g2.drawString(cajaChica.this.jLabel13.getText(), 520, renglon + 10);
/* 4105 */           this.REGPIE = renglon;
/* 4106 */           piePag();
/*      */         } else {
/* 4108 */           this.g2.drawString(".....", 540, renglon);
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
/*      */     public void recibeDatos(JTable tabla) {
/* 4120 */       ImprimirRepo im = new ImprimirRepo();
/* 4121 */       int opcion = 0;
/* 4122 */       im.tabla = tabla;
/* 4123 */       if (im.tabla.getRowCount() <= 50) {
/* 4124 */         opcion = 0;
/* 4125 */       } else if (im.tabla.getRowCount() < 115) {
/* 4126 */         opcion = 1;
/* 4127 */       } else if (im.tabla.getRowCount() <= 180) {
/* 4128 */         opcion = 2;
/* 4129 */       } else if (im.tabla.getRowCount() <= 245) {
/* 4130 */         opcion = 3;
/* 4131 */       } else if (im.tabla.getRowCount() <= 310) {
/* 4132 */         opcion = 4;
/* 4133 */       } else if (im.tabla.getRowCount() <= 375) {
/* 4134 */         opcion = 5;
/* 4135 */       } else if (im.tabla.getRowCount() <= 440) {
/* 4136 */         opcion = 6;
/* 4137 */       } else if (im.tabla.getRowCount() <= 505) {
/* 4138 */         opcion = 7;
/* 4139 */       } else if (im.tabla.getRowCount() <= 570) {
/* 4140 */         opcion = 8;
/*      */       } 
/* 4142 */       im.opc = opcion;
/* 4143 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 4144 */       job.setPrintable(im);
/* 4145 */       if (job.printDialog())
/*      */         try {
/* 4147 */           job.print();
/* 4148 */         } catch (PrinterException e) {
/* 4149 */           JOptionPane.showMessageDialog(null, "Error al imprimir " + e.getMessage());
/*      */         }  
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/cajaChica.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */