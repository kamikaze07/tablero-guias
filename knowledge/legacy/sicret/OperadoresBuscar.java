/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Image;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.Paper;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ 
/*      */ public class OperadoresBuscar extends JPanel {
/*      */   Color color;
/*      */   JFrame frame;
/*      */   JScrollPane panel;
/*   41 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   42 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   43 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   44 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   45 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*   46 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   47 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   48 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   49 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*      */   JTabbedPane fichas;
/*      */   String USUARIO;
/*      */   JTable tabla;
/*      */   EscribirReporte esc;
/*      */   ReporteIndividual indi;
/*   56 */   CeldaRender celda = new CeldaRender();
/*   57 */   CeldaRender2 celda2 = new CeldaRender2();
/*      */   
/*      */   JFrame padre;
/*   60 */   String FOTO = "";
/*      */   
/*   62 */   cargarFoto cargar = null;
/*   63 */   fotoIndividual ind = null;
/*   64 */   fotoCredencial fotoC = null;
/*   65 */   String NOMBRECOMPLETO = "";
/*   66 */   String VIGENCIA = "";
/*   67 */   String CLAVEOP = "";
/*   68 */   String AGENTE = "VACJ 710806 TU8 0013";
/*   69 */   String[] DIRECTIVA = null;
/*   70 */   fotoFirmas fotoF = null;
/*   71 */   SColores lc = new SColores();
/*   72 */   Fuentes fuentes = new Fuentes(); Map<String, String> CAMPOSGENERALES; private ButtonGroup buttonGroup1; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton3; private JButton jButton4; private JButton jButton44; private JButton jButton45; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox5; private JDateChooser jDateChooser1; private JDateChooser jDateChooser5; private JDialog jDialog1; private JDialog jDialog10; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel11; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel112; private JLabel jLabel113; private JLabel jLabel114; private JLabel jLabel115; private JLabel jLabel116; private JLabel jLabel117; private JLabel jLabel118; private JLabel jLabel119; private JLabel jLabel12; private JLabel jLabel120; private JLabel jLabel121; private JLabel jLabel122; private JLabel jLabel123; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel127; private JLabel jLabel128; private JLabel jLabel129; private JLabel jLabel13; private JLabel jLabel130; private JLabel jLabel131; private JLabel jLabel132; private JLabel jLabel133; private JLabel jLabel134; private JLabel jLabel135; private JLabel jLabel136; private JLabel jLabel137; private JLabel jLabel138; private JLabel jLabel139; private JLabel jLabel14; private JLabel jLabel140; private JLabel jLabel141; private JLabel jLabel142; private JLabel jLabel143; private JLabel jLabel144; private JLabel jLabel145; private JLabel jLabel146; private JLabel jLabel147; private JLabel jLabel148; private JLabel jLabel149; private JLabel jLabel15; private JLabel jLabel150; private JLabel jLabel151; private JLabel jLabel152; private JLabel jLabel153; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54;
/*      */   private JLabel jLabel55;
/*      */   
/*      */   public OperadoresBuscar(JFrame padre, JScrollPane panelito, String usua, JTabbedPane fichas, Map<String, String> CAMPOSGENERALES, boolean entradaPrincipal) {
/*   76 */     this.fichas = fichas;
/*   77 */     this.frame = padre;
/*   78 */     this.padre = padre;
/*   79 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   80 */     initComponents();
/*   81 */     this.USUARIO = usua;
/*   82 */     panelito.setViewportView(this);
/*   83 */     this.panel = panelito;
/*   84 */     colorear();
/*   85 */     consultar();
/*   86 */     this.buttonGroup1.add(this.jRadioButton1);
/*   87 */     this.buttonGroup1.add(this.jRadioButton2);
/*   88 */     if (fichas != null) {
/*   89 */       fichas.addTab("Operadores - [Buscar Actores]", panelito);
/*   90 */       if (fichas != null) {
/*   91 */         fichas.addTab("Operadores - [Buscar Operadores]", this.panel);
/*   92 */         this.jButton5.setText("Asignar");
/*      */       } 
/*      */     } 
/*   95 */     int w = this.tama.width;
/*   96 */     int h = this.tama.height;
/*   97 */     this.jDialog1.setLocation(w - 255, 5);
/*   98 */     this.jDialog1.setSize(250, 365);
/*   99 */     this.jDialog1.setVisible(false);
/*  100 */     this.jDialog1.setResizable(false);
/*      */     
/*  102 */     int rw = (w - 730) / 2;
/*  103 */     int rh = (h - 695) / 2;
/*  104 */     this.jDialog2.setLocation(rw, rh);
/*  105 */     this.jDialog2.setSize(730, 695);
/*  106 */     this.jDialog2.setVisible(false);
/*  107 */     this.jDialog2.setResizable(false);
/*      */     
/*  109 */     rw = (w - 420) / 2;
/*  110 */     rh = (h - 230) / 2;
/*  111 */     this.jDialog3.setLocation(rw, rh);
/*  112 */     this.jDialog3.setSize(420, 230);
/*  113 */     this.jDialog3.setVisible(false);
/*  114 */     this.jDialog3.setResizable(false);
/*      */     
/*  116 */     rw = (w - 617) / 2;
/*  117 */     rh = (h - 433) / 2;
/*  118 */     this.jDialog4.setLocation(rw, rh);
/*  119 */     this.jDialog4.setSize(617, 433);
/*  120 */     this.jDialog4.setVisible(false);
/*  121 */     this.jDialog4.setResizable(false);
/*      */     
/*  123 */     rw = (w - 378) / 2;
/*  124 */     rh = (h - 225) / 2;
/*  125 */     this.jDialog5.setLocation(rw, rh);
/*  126 */     this.jDialog5.setSize(378, 225);
/*  127 */     this.jDialog5.setVisible(false);
/*  128 */     this.jDialog5.setResizable(false);
/*      */     
/*  130 */     rw = (w - 443) / 2;
/*  131 */     rh = (h - 615) / 2;
/*  132 */     this.jDialog6.setLocation(rw, rh);
/*  133 */     this.jDialog6.setSize(443, 640);
/*  134 */     this.jDialog6.setVisible(false);
/*  135 */     this.jDialog6.setResizable(false);
/*      */     
/*  137 */     rw = (w - 475) / 2;
/*  138 */     rh = (h - 690) / 2;
/*  139 */     this.jDialog7.setLocation(rw, rh);
/*  140 */     this.jDialog7.setSize(475, 690);
/*  141 */     this.jDialog7.setVisible(false);
/*  142 */     this.jDialog7.setResizable(false);
/*      */     
/*  144 */     this.jDialog8.setLocation(w - 605, 5);
/*  145 */     this.jDialog8.setSize(598, 350);
/*  146 */     this.jDialog8.setVisible(false);
/*  147 */     this.jDialog8.setResizable(false);
/*      */     
/*  149 */     rw = (w - 765) / 2;
/*  150 */     rh = (h - 550) / 2;
/*  151 */     this.jDialog9.setLocation(rw, rh);
/*  152 */     this.jDialog9.setSize(765, 565);
/*  153 */     this.jDialog9.setVisible(false);
/*  154 */     this.jDialog9.setResizable(false);
/*      */     
/*  156 */     rw = (w - 650) / 2;
/*  157 */     rh = (h - 750) / 2;
/*  158 */     this.jDialog10.setLocation(rw, rh);
/*  159 */     this.jDialog10.setSize(650, 750);
/*  160 */     this.jDialog10.setVisible(false);
/*  161 */     this.jDialog10.setResizable(false);
/*      */     
/*  163 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  164 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  165 */     this.jLabel34.setCursor(micursor);
/*  166 */     this.jLabel37.setCursor(micursor);
/*  167 */     this.jLabel60.setCursor(micursor);
/*  168 */     this.jLabel51.setCursor(micursor);
/*  169 */     this.jLabel52.setCursor(micursor);
/*  170 */     this.jLabel86.setCursor(micursor);
/*  171 */     this.jLabel81.setCursor(micursor);
/*  172 */     this.jLabel36.setCursor(micursor);
/*  173 */     this.jLabel136.setCursor(micursor);
/*      */     
/*  175 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  176 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  177 */     this.jDialog1.setCursor(micursor);
/*  178 */     this.jDialog2.setCursor(micursor);
/*  179 */     this.jDialog3.setCursor(micursor);
/*  180 */     this.jDialog4.setCursor(micursor);
/*  181 */     this.jDialog5.setCursor(micursor);
/*  182 */     this.jDialog6.setCursor(micursor);
/*  183 */     this.jDialog7.setCursor(micursor);
/*  184 */     this.jDialog8.setCursor(micursor);
/*  185 */     this.jDialog9.setCursor(micursor);
/*  186 */     this.jDialog10.setCursor(micursor);
/*      */     
/*  188 */     if (!entradaPrincipal) {
/*  189 */       privilegios();
/*  190 */       this.NOMBRECOMPLETO = CAMPOSGENERALES.get("empleados.nombre").toString() + " " + CAMPOSGENERALES.get("empleados.nombre").toString() + " " + CAMPOSGENERALES.get("empleados.ap_pat").toString();
/*  191 */       privilegios();
/*  192 */       consultar();
/*      */     } 
/*  194 */     this
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  199 */       .DIRECTIVA = new String[] { CAMPOSGENERALES.get("fotosOperadores").toString(), CAMPOSGENERALES.get("directiva").toString(), CAMPOSGENERALES.get("capacitadorQHSE").toString(), CAMPOSGENERALES.get("nombreCapacitador").toString(), CAMPOSGENERALES.get("sucursal").toString() };
/*      */     
/*  201 */     this.AGENTE = this.DIRECTIVA[2];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  209 */     this.jLabel122.setVisible(false);
/*      */   }
/*      */   private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JMenuItem jMenuItem1; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel64; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JPopupMenu jPopupMenu1; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JScrollPane jScrollPane1; private JScrollPane jScrollPane18; private JScrollPane jScrollPane3; private JScrollPane jScrollPane32; private JScrollPane jScrollPane8; private JSeparator jSeparator1; private JSeparator jSeparator13; private JSeparator jSeparator2; private JSeparator jSeparator27; private JSeparator jSeparator3; private JSeparator jSeparator4; private JSeparator jSeparator6; private JSeparator jSeparator7; private JSpinner jSpinner1; private JTable jTable3; private JTextArea jTextArea1; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField25; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private JTextPane jTextPane1; private MaterialButton materialButton42; private RSTableMetro rSTableMetro2;
/*      */   
/*      */   private void initComponents() {
/*  214 */     this.jDialog1 = new JDialog(this.padre);
/*  215 */     this.jPanel2 = new JPanel();
/*  216 */     this.jLabel122 = new JLabel();
/*  217 */     this.jLabel1 = new JLabel();
/*  218 */     this.jLabel2 = new JLabel();
/*  219 */     this.jSeparator1 = new JSeparator();
/*  220 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  221 */     this.jPanel3 = new JPanel();
/*  222 */     this.jLabel3 = new JLabel();
/*  223 */     this.jLabel4 = new JLabel();
/*  224 */     this.jLabel5 = new JLabel();
/*  225 */     this.jLabel6 = new JLabel();
/*  226 */     this.jLabel7 = new JLabel();
/*  227 */     this.jLabel8 = new JLabel();
/*  228 */     this.jLabel9 = new JLabel();
/*  229 */     this.jLabel10 = new JLabel();
/*  230 */     this.jLabel21 = new JLabel();
/*  231 */     this.jLabel23 = new JLabel();
/*  232 */     this.jLabel24 = new JLabel();
/*  233 */     this.jLabel25 = new JLabel();
/*  234 */     this.jLabel26 = new JLabel();
/*  235 */     this.jLabel27 = new JLabel();
/*  236 */     this.jLabel34 = new JLabel();
/*  237 */     this.jLabel35 = new JLabel();
/*  238 */     this.jLabel36 = new JLabel();
/*  239 */     this.jLabel37 = new JLabel();
/*  240 */     this.jLabel40 = new JLabel();
/*  241 */     this.jLabel41 = new JLabel();
/*  242 */     this.jLabel43 = new JLabel();
/*  243 */     this.jLabel45 = new JLabel();
/*  244 */     this.jLabel50 = new JLabel();
/*  245 */     this.jLabel53 = new JLabel();
/*  246 */     this.jLabel56 = new JLabel();
/*  247 */     this.jScrollPane1 = new JScrollPane();
/*  248 */     this.jTextArea1 = new JTextArea();
/*  249 */     this.jLabel57 = new JLabel();
/*  250 */     this.jLabel60 = new JLabel();
/*  251 */     this.jLabel61 = new JLabel();
/*  252 */     this.jPanel4 = new JPanel();
/*  253 */     this.jLabel47 = new JLabel();
/*  254 */     this.jLabel62 = new JLabel();
/*  255 */     this.jLabel64 = new JLabel();
/*  256 */     this.jLabel66 = new JLabel();
/*  257 */     this.jLabel68 = new JLabel();
/*  258 */     this.jTextField24 = new JTextField();
/*  259 */     this.jTextField25 = new JTextField();
/*  260 */     this.jTextField26 = new JTextField();
/*  261 */     this.jTextField27 = new JTextField();
/*  262 */     this.jTextField28 = new JTextField();
/*  263 */     this.jTextField7 = new JTextField();
/*  264 */     this.jTextField8 = new JTextField();
/*  265 */     this.jTextField9 = new JTextField();
/*  266 */     this.jTextField10 = new JTextField();
/*  267 */     this.jTextField11 = new JTextField();
/*  268 */     this.jTextField12 = new JTextField();
/*  269 */     this.jTextField13 = new JTextField();
/*  270 */     this.jTextField14 = new JTextField();
/*  271 */     this.jTextField15 = new JTextField();
/*  272 */     this.jTextField16 = new JTextField();
/*  273 */     this.jTextField17 = new JTextField();
/*  274 */     this.jTextField18 = new JTextField();
/*  275 */     this.jTextField19 = new JTextField();
/*  276 */     this.jTextField20 = new JTextField();
/*  277 */     this.jTextField21 = new JTextField();
/*  278 */     this.jTextField22 = new JTextField();
/*  279 */     this.jTextField23 = new JTextField();
/*  280 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  281 */     this.jPanel29 = new JPanel();
/*  282 */     this.jLabel124 = new JLabel();
/*  283 */     this.jSeparator27 = new JSeparator();
/*  284 */     this.jLabel125 = new JLabel();
/*  285 */     this.jButton44 = new JButton();
/*  286 */     this.jButton45 = new JButton();
/*  287 */     this.jScrollPane18 = new JScrollPane();
/*  288 */     this.jTextArea5 = new JTextArea();
/*  289 */     this.jLabel126 = new JLabel();
/*  290 */     this.jPopupMenu1 = new JPopupMenu();
/*  291 */     this.jMenuItem1 = new JMenuItem();
/*  292 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  293 */     this.jPanel12 = new JPanel();
/*  294 */     this.jLabel93 = new JLabel();
/*  295 */     this.jSeparator13 = new JSeparator();
/*  296 */     this.jLabel13 = new JLabel();
/*  297 */     this.jLabel18 = new JLabel();
/*  298 */     this.jLabel19 = new JLabel();
/*  299 */     this.jLabel20 = new JLabel();
/*  300 */     this.jLabel22 = new JLabel();
/*  301 */     this.jLabel51 = new JLabel();
/*  302 */     this.jLabel55 = new JLabel();
/*  303 */     this.jLabel98 = new JLabel();
/*  304 */     this.jLabel101 = new JLabel();
/*  305 */     this.jScrollPane8 = new JScrollPane();
/*  306 */     this.jTextPane1 = new JTextPane();
/*  307 */     this.jLabel59 = new JLabel();
/*  308 */     this.jLabel52 = new JLabel();
/*  309 */     this.jLabel63 = new JLabel();
/*  310 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  311 */     this.jPanel6 = new JPanel();
/*  312 */     this.jLabel127 = new JLabel();
/*  313 */     this.jSeparator2 = new JSeparator();
/*  314 */     this.jLabel11 = new JLabel();
/*  315 */     this.jRadioButton1 = new JRadioButton();
/*  316 */     this.jRadioButton2 = new JRadioButton();
/*  317 */     this.jSeparator3 = new JSeparator();
/*  318 */     this.jButton7 = new JButton();
/*  319 */     this.jButton8 = new JButton();
/*  320 */     this.buttonGroup1 = new ButtonGroup();
/*  321 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  322 */     this.jPanel10 = new JPanel();
/*  323 */     this.jLabel30 = new JLabel();
/*  324 */     this.jSeparator6 = new JSeparator();
/*  325 */     this.jLabel31 = new JLabel();
/*  326 */     this.jLabel33 = new JLabel();
/*  327 */     this.jButton12 = new JButton();
/*  328 */     this.jButton13 = new JButton();
/*  329 */     this.jButton14 = new JButton();
/*  330 */     this.jPanel18 = new JPanel();
/*  331 */     this.jLabel107 = new JLabel();
/*  332 */     this.jLabel108 = new JLabel();
/*  333 */     this.jLabel109 = new JLabel();
/*  334 */     this.jLabel111 = new JLabel();
/*  335 */     this.jLabel112 = new JLabel();
/*  336 */     this.jLabel113 = new JLabel();
/*  337 */     this.jLabel114 = new JLabel();
/*  338 */     this.jLabel116 = new JLabel();
/*  339 */     this.jLabel117 = new JLabel();
/*  340 */     this.jLabel110 = new JLabel();
/*  341 */     this.jLabel115 = new JLabel();
/*  342 */     this.jLabel120 = new JLabel();
/*  343 */     this.jPanel19 = new JPanel();
/*  344 */     this.jLabel121 = new JLabel();
/*  345 */     this.jLabel129 = new JLabel();
/*  346 */     this.jLabel130 = new JLabel();
/*  347 */     this.jLabel131 = new JLabel();
/*  348 */     this.jLabel132 = new JLabel();
/*  349 */     this.jLabel133 = new JLabel();
/*  350 */     this.jLabel134 = new JLabel();
/*  351 */     this.jLabel135 = new JLabel();
/*  352 */     this.jLabel136 = new JLabel();
/*  353 */     this.jLabel42 = new JLabel();
/*  354 */     this.jLabel137 = new JLabel();
/*  355 */     this.jLabel118 = new JLabel();
/*  356 */     this.jLabel138 = new JLabel();
/*  357 */     this.jLabel139 = new JLabel();
/*  358 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  359 */     this.jPanel14 = new JPanel();
/*  360 */     this.jLabel44 = new JLabel();
/*  361 */     this.jSeparator7 = new JSeparator();
/*  362 */     this.jLabel46 = new JLabel();
/*  363 */     this.jPanel15 = new JPanel();
/*  364 */     this.jLabel12 = new JLabel();
/*  365 */     this.jLabel28 = new JLabel();
/*  366 */     this.jLabel29 = new JLabel();
/*  367 */     this.jLabel67 = new JLabel();
/*  368 */     this.jLabel80 = new JLabel();
/*  369 */     this.jLabel82 = new JLabel();
/*  370 */     this.jLabel83 = new JLabel();
/*  371 */     this.jLabel84 = new JLabel();
/*  372 */     this.jLabel85 = new JLabel();
/*  373 */     this.jLabel86 = new JLabel();
/*  374 */     this.jPanel8 = new JPanel();
/*  375 */     this.jLabel81 = new JLabel();
/*  376 */     this.jLabel87 = new JLabel();
/*  377 */     this.jPanel7 = new JPanel();
/*  378 */     this.jLabel88 = new JLabel();
/*  379 */     this.jLabel89 = new JLabel();
/*  380 */     this.jLabel49 = new JLabel();
/*  381 */     this.jButton16 = new JButton();
/*  382 */     this.jButton17 = new JButton();
/*  383 */     this.jButton18 = new JButton();
/*  384 */     this.jPanel16 = new JPanel();
/*  385 */     this.jLabel65 = new JLabel();
/*  386 */     this.jLabel90 = new JLabel();
/*  387 */     this.jLabel91 = new JLabel();
/*  388 */     this.jLabel94 = new JLabel();
/*  389 */     this.jLabel95 = new JLabel();
/*  390 */     this.jLabel96 = new JLabel();
/*  391 */     this.jLabel97 = new JLabel();
/*  392 */     this.jLabel99 = new JLabel();
/*  393 */     this.jLabel100 = new JLabel();
/*  394 */     this.jLabel102 = new JLabel();
/*  395 */     this.jLabel103 = new JLabel();
/*  396 */     this.jLabel104 = new JLabel();
/*  397 */     this.jLabel105 = new JLabel();
/*  398 */     this.jLabel92 = new JLabel();
/*  399 */     this.jLabel106 = new JLabel();
/*  400 */     this.jPanel20 = new JPanel();
/*  401 */     this.jLabel119 = new JLabel();
/*  402 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  403 */     this.jDialog8 = new CerrarVentana(this.padre);
/*  404 */     this.jPanel9 = new JPanel();
/*  405 */     this.jLabel69 = new JLabel();
/*  406 */     this.jLabel70 = new JLabel();
/*  407 */     this.jSeparator4 = new JSeparator();
/*  408 */     this.jDialog9 = new CerrarVentana(this.padre);
/*  409 */     this.jPanel13 = new JPanel();
/*  410 */     this.jPanel33 = new JPanel();
/*  411 */     this.jPanel11 = new JPanel();
/*  412 */     this.jPanel21 = new JPanel();
/*  413 */     this.jLabel71 = new JLabel();
/*  414 */     this.jLabel72 = new JLabel();
/*  415 */     this.jPanel22 = new JPanel();
/*  416 */     this.jLabel73 = new JLabel();
/*  417 */     this.jPanel23 = new JPanel();
/*  418 */     this.jPanel24 = new JPanel();
/*  419 */     this.jLabel74 = new JLabel();
/*  420 */     this.jPanel25 = new JPanel();
/*  421 */     this.jPanel26 = new JPanel();
/*  422 */     this.jLabel75 = new JLabel();
/*  423 */     this.jLabel76 = new JLabel();
/*  424 */     this.jPanel27 = new JPanel();
/*  425 */     this.jLabel77 = new JLabel();
/*  426 */     this.jPanel28 = new JPanel();
/*  427 */     this.jLabel78 = new JLabel();
/*  428 */     this.jPanel30 = new JPanel();
/*  429 */     this.jLabel79 = new JLabel();
/*  430 */     this.jPanel31 = new JPanel();
/*  431 */     this.jSpinner1 = new JSpinner();
/*  432 */     this.jLabel146 = new JLabel();
/*  433 */     this.jLabel140 = new JLabel();
/*  434 */     this.jDateChooser1 = new JDateChooser();
/*  435 */     this.jLabel142 = new JLabel();
/*  436 */     this.jLabel143 = new JLabel();
/*  437 */     this.jLabel144 = new JLabel();
/*  438 */     this.jTextField29 = new JTextField();
/*  439 */     this.jPanel35 = new JPanel();
/*  440 */     this.jPanel36 = new JPanel();
/*  441 */     this.jLabel128 = new JLabel();
/*  442 */     this.jLabel141 = new JLabel();
/*  443 */     this.jPanel37 = new JPanel();
/*  444 */     this.jLabel145 = new JLabel();
/*  445 */     this.jPanel38 = new JPanel();
/*  446 */     this.jLabel150 = new JLabel();
/*  447 */     this.jPanel39 = new JPanel();
/*  448 */     this.jPanel34 = new JPanel();
/*  449 */     this.jPanel40 = new JPanel();
/*  450 */     this.jPanel41 = new JPanel();
/*  451 */     this.jLabel148 = new JLabel();
/*  452 */     this.jLabel149 = new JLabel();
/*  453 */     this.jPanel42 = new JPanel();
/*  454 */     this.jPanel43 = new JPanel();
/*  455 */     this.jLabel151 = new JLabel();
/*  456 */     this.jLabel147 = new JLabel();
/*  457 */     this.jPanel32 = new JPanel();
/*  458 */     this.jButton10 = new JButton();
/*  459 */     this.jButton11 = new JButton();
/*  460 */     this.jButton15 = new JButton();
/*  461 */     this.jDialog10 = new CerrarVentana(this.padre);
/*  462 */     this.materialButton42 = new MaterialButton();
/*  463 */     this.jScrollPane32 = new JScrollPane();
/*  464 */     this.rSTableMetro2 = new RSTableMetro();
/*  465 */     this.jPanel64 = new JPanel();
/*  466 */     this.jLabel152 = new JLabel();
/*  467 */     this.jLabel153 = new JLabel();
/*  468 */     this.jPanel1 = new JPanel();
/*  469 */     this.jLabel54 = new JLabel();
/*  470 */     this.jPanel5 = new JPanel();
/*  471 */     this.jScrollPane3 = new JScrollPane();
/*  472 */     this.jTable3 = new JTable();
/*  473 */     this.jButton5 = new JButton();
/*  474 */     this.jButton1 = new JButton();
/*  475 */     this.jButton2 = new JButton();
/*  476 */     this.jLabel48 = new JLabel();
/*  477 */     this.jButton3 = new JButton();
/*  478 */     this.jButton4 = new JButton();
/*  479 */     this.jButton6 = new JButton();
/*  480 */     this.jButton9 = new JButton();
/*  481 */     this.jButton19 = new JButton();
/*  482 */     this.jPanel17 = new JPanel();
/*  483 */     this.jLabel14 = new JLabel();
/*  484 */     this.jLabel32 = new JLabel();
/*  485 */     this.jLabel38 = new JLabel();
/*  486 */     this.jTextField1 = new JTextField();
/*  487 */     this.jTextField2 = new JTextField();
/*  488 */     this.jTextField3 = new JTextField();
/*  489 */     this.jTextField4 = new JTextField();
/*  490 */     this.jLabel15 = new JLabel();
/*  491 */     this.jComboBox1 = new JComboBox();
/*  492 */     this.jLabel39 = new JLabel();
/*  493 */     this.jComboBox2 = new JComboBox();
/*  494 */     this.jLabel58 = new JLabel();
/*  495 */     this.jTextField5 = new JTextField();
/*  496 */     this.jLabel16 = new JLabel();
/*  497 */     this.jLabel17 = new JLabel();
/*  498 */     this.jTextField6 = new JTextField();
/*  499 */     this.jComboBox5 = new JComboBox();
/*  500 */     this.jLabel123 = new JLabel();
/*  501 */     this.jCheckBox1 = new JCheckBox();
/*      */     
/*  503 */     this.jDialog1.setTitle("FOTOS");
/*  504 */     this.jDialog1.setAlwaysOnTop(true);
/*  505 */     this.jDialog1.setFocusable(false);
/*  506 */     this.jDialog1.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/*  508 */             OperadoresBuscar.this.jDialog1WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/*  512 */     this.jPanel2.setBackground(new Color(146, 193, 134));
/*  513 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/*  514 */     this.jPanel2.setLayout((LayoutManager)null);
/*      */     
/*  516 */     this.jLabel122.setFont(new Font("Calibri", 1, 36));
/*  517 */     this.jLabel122.setForeground(Color.orange);
/*  518 */     this.jLabel122.setHorizontalAlignment(0);
/*  519 */     this.jLabel122.setText("SICRET");
/*  520 */     this.jPanel2.add(this.jLabel122);
/*  521 */     this.jLabel122.setBounds(10, 14, 220, 230);
/*      */     
/*  523 */     this.jLabel1.setHorizontalAlignment(0);
/*  524 */     this.jPanel2.add(this.jLabel1);
/*  525 */     this.jLabel1.setBounds(2, 2, 235, 251);
/*      */     
/*  527 */     this.jLabel2.setFont(new Font("Times New Roman", 1, 23));
/*  528 */     this.jLabel2.setForeground(Color.blue);
/*  529 */     this.jLabel2.setHorizontalAlignment(0);
/*  530 */     this.jLabel2.setText("<HTML><CENTER>VISUALIZADOR DE IMÁGENES</CENTER></HTML>");
/*  531 */     this.jPanel2.add(this.jLabel2);
/*  532 */     this.jLabel2.setBounds(2, 275, 235, 46);
/*      */     
/*  534 */     this.jSeparator1.setBackground(new Color(0, 0, 0));
/*  535 */     this.jPanel2.add(this.jSeparator1);
/*  536 */     this.jSeparator1.setBounds(12, 264, 215, 5);
/*      */     
/*  538 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  539 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  540 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  541 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  542 */         .addComponent(this.jPanel2, -1, 242, 32767));
/*      */     
/*  544 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  545 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  546 */         .addComponent(this.jPanel2, -1, 339, 32767));
/*      */ 
/*      */     
/*  549 */     this.jDialog2.setTitle("Reporte Individual");
/*  550 */     this.jDialog2.setModal(true);
/*      */     
/*  552 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*      */     
/*  554 */     this.jLabel3.setHorizontalAlignment(0);
/*  555 */     this.jLabel3.setBorder(BorderFactory.createTitledBorder(null, "Fotografía", 2, 6, new Font("Tahoma", 1, 12)));
/*      */     
/*  557 */     this.jLabel4.setFont(new Font("Tahoma", 1, 15));
/*  558 */     this.jLabel4.setForeground(Color.red);
/*  559 */     this.jLabel4.setHorizontalAlignment(0);
/*  560 */     this.jLabel4.setText("HISTORIAL DE");
/*      */     
/*  562 */     this.jLabel5.setFont(new Font("Tahoma", 1, 11));
/*  563 */     this.jLabel5.setText("Nombre:");
/*      */     
/*  565 */     this.jLabel6.setFont(new Font("Tahoma", 1, 11));
/*  566 */     this.jLabel6.setText("Apellidos:");
/*      */     
/*  568 */     this.jLabel7.setFont(new Font("Tahoma", 1, 11));
/*  569 */     this.jLabel7.setText("Calle:");
/*      */     
/*  571 */     this.jLabel8.setFont(new Font("Tahoma", 1, 11));
/*  572 */     this.jLabel8.setText("Núm.");
/*      */     
/*  574 */     this.jLabel9.setFont(new Font("Tahoma", 1, 11));
/*  575 */     this.jLabel9.setText("Colonia:");
/*      */     
/*  577 */     this.jLabel10.setFont(new Font("Tahoma", 1, 11));
/*  578 */     this.jLabel10.setText("C.P.");
/*      */     
/*  580 */     this.jLabel21.setFont(new Font("Tahoma", 1, 11));
/*  581 */     this.jLabel21.setText("Ciudad");
/*      */     
/*  583 */     this.jLabel23.setFont(new Font("Tahoma", 1, 11));
/*  584 */     this.jLabel23.setText("Teléfono");
/*      */     
/*  586 */     this.jLabel24.setFont(new Font("Tahoma", 1, 11));
/*  587 */     this.jLabel24.setText("Celular");
/*      */     
/*  589 */     this.jLabel25.setFont(new Font("Tahoma", 1, 11));
/*  590 */     this.jLabel25.setText("Fecha de Nac");
/*      */     
/*  592 */     this.jLabel26.setFont(new Font("Tahoma", 1, 11));
/*  593 */     this.jLabel26.setText("Venc Licencia");
/*      */     
/*  595 */     this.jLabel27.setFont(new Font("Tahoma", 1, 11));
/*  596 */     this.jLabel27.setText("Licen. Tipo");
/*      */     
/*  598 */     this.jLabel34.setFont(new Font("Tahoma", 1, 12));
/*  599 */     this.jLabel34.setForeground(Color.red);
/*  600 */     this.jLabel34.setHorizontalAlignment(0);
/*  601 */     this.jLabel34.setText("Cerrar");
/*  602 */     this.jLabel34.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  604 */             OperadoresBuscar.this.jLabel34MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  607 */             OperadoresBuscar.this.jLabel34MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  610 */             OperadoresBuscar.this.jLabel34MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  614 */     this.jLabel35.setFont(new Font("Tahoma", 1, 12));
/*  615 */     this.jLabel35.setText("|");
/*      */     
/*  617 */     this.jLabel36.setFont(new Font("Tahoma", 1, 12));
/*  618 */     this.jLabel36.setText("|");
/*      */     
/*  620 */     this.jLabel37.setFont(new Font("Tahoma", 1, 12));
/*  621 */     this.jLabel37.setForeground(Color.red);
/*  622 */     this.jLabel37.setHorizontalAlignment(0);
/*  623 */     this.jLabel37.setText("Guardar");
/*  624 */     this.jLabel37.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  626 */             OperadoresBuscar.this.jLabel37MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  629 */             OperadoresBuscar.this.jLabel37MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  632 */             OperadoresBuscar.this.jLabel37MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  636 */     this.jLabel40.setFont(new Font("Tahoma", 1, 12));
/*  637 */     this.jLabel40.setText("|");
/*      */     
/*  639 */     this.jLabel41.setFont(new Font("Tahoma", 1, 11));
/*  640 */     this.jLabel41.setText("Núm. Licen.");
/*      */     
/*  642 */     this.jLabel43.setFont(new Font("Tahoma", 1, 11));
/*  643 */     this.jLabel43.setText("N.s.s.");
/*      */     
/*  645 */     this.jLabel45.setFont(new Font("Tahoma", 1, 11));
/*  646 */     this.jLabel45.setText("CURP");
/*      */     
/*  648 */     this.jLabel50.setFont(new Font("Tahoma", 1, 11));
/*  649 */     this.jLabel50.setText("Infonavit");
/*      */     
/*  651 */     this.jLabel53.setFont(new Font("Tahoma", 1, 11));
/*  652 */     this.jLabel53.setText("Cantidad");
/*      */     
/*  654 */     this.jLabel56.setFont(new Font("Tahoma", 2, 11));
/*  655 */     this.jLabel56.setForeground(Color.blue);
/*  656 */     this.jLabel56.setText("Aquí se muestra todo su historial hasta la fecha actual");
/*      */     
/*  658 */     this.jTextArea1.setColumns(20);
/*  659 */     this.jTextArea1.setEditable(false);
/*  660 */     this.jTextArea1.setRows(5);
/*  661 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*      */     
/*  663 */     this.jLabel57.setFont(new Font("Tahoma", 1, 12));
/*  664 */     this.jLabel57.setText("|");
/*      */     
/*  666 */     this.jLabel60.setFont(new Font("Tahoma", 1, 12));
/*  667 */     this.jLabel60.setForeground(Color.red);
/*  668 */     this.jLabel60.setHorizontalAlignment(0);
/*  669 */     this.jLabel60.setText("Agregar Comentario");
/*  670 */     this.jLabel60.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  672 */             OperadoresBuscar.this.jLabel60MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  675 */             OperadoresBuscar.this.jLabel60MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  678 */             OperadoresBuscar.this.jLabel60MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  682 */     this.jLabel61.setFont(new Font("Tahoma", 1, 12));
/*  683 */     this.jLabel61.setText("|");
/*      */     
/*  685 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  687 */     this.jLabel47.setFont(new Font("Tahoma", 1, 11));
/*  688 */     this.jLabel47.setHorizontalAlignment(4);
/*  689 */     this.jLabel47.setText("Ingreso");
/*      */     
/*  691 */     this.jLabel62.setFont(new Font("Tahoma", 1, 11));
/*  692 */     this.jLabel62.setText("Tractor");
/*      */     
/*  694 */     this.jLabel64.setFont(new Font("Tahoma", 1, 11));
/*  695 */     this.jLabel64.setText("Rem");
/*      */     
/*  697 */     this.jLabel66.setFont(new Font("Tahoma", 1, 11));
/*  698 */     this.jLabel66.setText("Tipo");
/*      */     
/*  700 */     this.jLabel68.setFont(new Font("Tahoma", 1, 11));
/*  701 */     this.jLabel68.setText("Estatus");
/*      */     
/*  703 */     this.jTextField24.setEditable(false);
/*      */     
/*  705 */     this.jTextField25.setEditable(false);
/*      */     
/*  707 */     this.jTextField26.setEditable(false);
/*      */     
/*  709 */     this.jTextField27.setEditable(false);
/*      */     
/*  711 */     this.jTextField28.setEditable(false);
/*      */     
/*  713 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  714 */     this.jPanel4.setLayout(jPanel4Layout);
/*  715 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  716 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  717 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  718 */           .addComponent(this.jLabel47, -2, 48, -2)
/*  719 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  720 */           .addComponent(this.jTextField24, -2, 84, -2)
/*  721 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  722 */           .addComponent(this.jLabel62, -2, 48, -2)
/*  723 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  724 */           .addComponent(this.jTextField25, -2, 58, -2)
/*  725 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  726 */           .addComponent(this.jLabel64, -2, 34, -2)
/*  727 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  728 */           .addComponent(this.jTextField26, -2, 57, -2)
/*  729 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  730 */           .addComponent(this.jLabel66, -2, 34, -2)
/*  731 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  732 */           .addComponent(this.jTextField27, -2, 81, -2)
/*  733 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  734 */           .addComponent(this.jLabel68, -2, 46, -2)
/*  735 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  736 */           .addComponent(this.jTextField28, -2, 76, -2)
/*  737 */           .addContainerGap(55, 32767)));
/*      */     
/*  739 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  740 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  741 */         .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  742 */           .addComponent(this.jLabel47)
/*  743 */           .addComponent(this.jTextField24, -2, -1, -2)
/*  744 */           .addComponent(this.jLabel62)
/*  745 */           .addComponent(this.jTextField25, -2, -1, -2)
/*  746 */           .addComponent(this.jLabel64)
/*  747 */           .addComponent(this.jTextField26, -2, -1, -2)
/*  748 */           .addComponent(this.jLabel66)
/*  749 */           .addComponent(this.jTextField27, -2, -1, -2)
/*  750 */           .addComponent(this.jLabel68)
/*  751 */           .addComponent(this.jTextField28, -2, -1, -2)));
/*      */ 
/*      */     
/*  754 */     this.jTextField7.setEditable(false);
/*      */     
/*  756 */     this.jTextField8.setEditable(false);
/*      */     
/*  758 */     this.jTextField9.setEditable(false);
/*      */     
/*  760 */     this.jTextField10.setEditable(false);
/*      */     
/*  762 */     this.jTextField11.setEditable(false);
/*      */     
/*  764 */     this.jTextField12.setEditable(false);
/*      */     
/*  766 */     this.jTextField13.setEditable(false);
/*      */     
/*  768 */     this.jTextField14.setEditable(false);
/*      */     
/*  770 */     this.jTextField15.setEditable(false);
/*      */     
/*  772 */     this.jTextField16.setEditable(false);
/*      */     
/*  774 */     this.jTextField17.setEditable(false);
/*      */     
/*  776 */     this.jTextField18.setEditable(false);
/*      */     
/*  778 */     this.jTextField19.setEditable(false);
/*      */     
/*  780 */     this.jTextField20.setEditable(false);
/*      */     
/*  782 */     this.jTextField21.setEditable(false);
/*      */     
/*  784 */     this.jTextField22.setEditable(false);
/*      */     
/*  786 */     this.jTextField23.setEditable(false);
/*      */     
/*  788 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  789 */     this.jPanel3.setLayout(jPanel3Layout);
/*  790 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  791 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  792 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  793 */           .addContainerGap()
/*  794 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  795 */             .addComponent(this.jPanel4, -1, -1, 32767)
/*  796 */             .addComponent(this.jScrollPane1, -1, 661, 32767)
/*  797 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  798 */               .addComponent(this.jLabel3, -2, 209, -2)
/*  799 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  800 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  801 */                 .addGroup(jPanel3Layout.createSequentialGroup()
/*  802 */                   .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  803 */                     .addComponent(this.jLabel50, -1, 77, 32767)
/*  804 */                     .addComponent(this.jLabel43, GroupLayout.Alignment.TRAILING, -1, 77, 32767))
/*  805 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  806 */                   .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  807 */                     .addComponent(this.jTextField22, -1, 122, 32767)
/*  808 */                     .addComponent(this.jTextField20, -1, 122, 32767))
/*  809 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  810 */                   .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  811 */                     .addComponent(this.jLabel53)
/*  812 */                     .addComponent(this.jLabel45, -1, -1, 32767))
/*  813 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  814 */                   .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  815 */                     .addComponent(this.jTextField23)
/*  816 */                     .addComponent(this.jTextField21, -1, 179, 32767)))
/*  817 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  818 */                   .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  819 */                     .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  820 */                       .addComponent(this.jLabel26, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  821 */                       .addComponent(this.jLabel23, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  822 */                       .addComponent(this.jLabel10, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  823 */                       .addComponent(this.jLabel25, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  824 */                       .addComponent(this.jLabel41, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  825 */                     .addComponent(this.jLabel9, -1, 77, 32767)
/*  826 */                     .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  827 */                       .addComponent(this.jLabel7, GroupLayout.Alignment.LEADING, -1, 77, 32767)
/*  828 */                       .addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -1, 77, 32767)
/*  829 */                       .addComponent(this.jLabel6, GroupLayout.Alignment.LEADING, -1, 77, 32767)))
/*  830 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  831 */                   .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  832 */                     .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  833 */                       .addComponent(this.jTextField9, -1, 228, 32767)
/*  834 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  835 */                       .addComponent(this.jLabel8, -2, 39, -2)
/*  836 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  837 */                       .addComponent(this.jTextField10, -2, 84, -2))
/*  838 */                     .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  839 */                       .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  840 */                         .addComponent(this.jTextField14)
/*  841 */                         .addComponent(this.jTextField16)
/*  842 */                         .addComponent(this.jTextField19)
/*  843 */                         .addComponent(this.jTextField17)
/*  844 */                         .addComponent(this.jTextField12, -2, 124, -2))
/*  845 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  846 */                       .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  847 */                         .addGroup(jPanel3Layout.createSequentialGroup()
/*  848 */                           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  849 */                             .addComponent(this.jLabel24, -1, -1, 32767)
/*  850 */                             .addComponent(this.jLabel21, -2, 55, -2))
/*  851 */                           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  852 */                           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  853 */                             .addComponent(this.jTextField15, -1, 178, 32767)
/*  854 */                             .addComponent(this.jTextField13, -1, 178, 32767)))
/*  855 */                         .addGroup(jPanel3Layout.createSequentialGroup()
/*  856 */                           .addComponent(this.jLabel27)
/*  857 */                           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  858 */                           .addComponent(this.jTextField18, -1, 174, 32767))))
/*  859 */                     .addComponent(this.jTextField11, GroupLayout.Alignment.TRAILING, -1, 365, 32767)
/*  860 */                     .addComponent(this.jTextField8, GroupLayout.Alignment.TRAILING, -1, 365, 32767)
/*  861 */                     .addComponent(this.jTextField7, GroupLayout.Alignment.TRAILING, -1, 365, 32767)))))
/*  862 */             .addComponent(this.jLabel4, -1, 661, 32767)
/*  863 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  864 */               .addComponent(this.jLabel56, -2, 321, -2)
/*  865 */               .addGap(322, 322, 322))
/*  866 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  867 */               .addComponent(this.jLabel57)
/*  868 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  869 */               .addComponent(this.jLabel60, -2, 144, -2)
/*  870 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  871 */               .addComponent(this.jLabel61)
/*  872 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 324, 32767)
/*  873 */               .addComponent(this.jLabel40)
/*  874 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  875 */               .addComponent(this.jLabel37, -2, 62, -2)
/*  876 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  877 */               .addComponent(this.jLabel36, -2, 11, -2)
/*  878 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  879 */               .addComponent(this.jLabel34, -2, 56, -2)
/*  880 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  881 */               .addComponent(this.jLabel35)))
/*  882 */           .addContainerGap()));
/*      */     
/*  884 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  885 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  886 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  887 */           .addComponent(this.jLabel4, -2, 30, -2)
/*  888 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  889 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  890 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  891 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  892 */                 .addComponent(this.jLabel5)
/*  893 */                 .addComponent(this.jTextField7, -2, -1, -2))
/*  894 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  895 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  896 */                 .addComponent(this.jLabel6)
/*  897 */                 .addComponent(this.jTextField8, -2, -1, -2))
/*  898 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  899 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  900 */                 .addComponent(this.jLabel7)
/*  901 */                 .addComponent(this.jTextField9, -2, -1, -2)
/*  902 */                 .addComponent(this.jTextField10, -2, -1, -2)
/*  903 */                 .addComponent(this.jLabel8))
/*  904 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  905 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  906 */                 .addComponent(this.jLabel9)
/*  907 */                 .addComponent(this.jTextField11, -2, -1, -2))
/*  908 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  909 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  910 */                 .addComponent(this.jLabel10)
/*  911 */                 .addComponent(this.jTextField12, -2, -1, -2)
/*  912 */                 .addComponent(this.jTextField13, -2, -1, -2)
/*  913 */                 .addComponent(this.jLabel21))
/*  914 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  915 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  916 */                 .addComponent(this.jLabel23)
/*  917 */                 .addComponent(this.jTextField14, -2, -1, -2)
/*  918 */                 .addComponent(this.jLabel24)
/*  919 */                 .addComponent(this.jTextField15, -2, -1, -2))
/*  920 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  921 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  922 */                 .addComponent(this.jLabel25)
/*  923 */                 .addComponent(this.jTextField16, -2, -1, -2))
/*  924 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  925 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  926 */                 .addComponent(this.jLabel26)
/*  927 */                 .addComponent(this.jTextField17, -2, -1, -2)
/*  928 */                 .addComponent(this.jLabel27)
/*  929 */                 .addComponent(this.jTextField18, -2, -1, -2))
/*  930 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  931 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  932 */                 .addComponent(this.jLabel41)
/*  933 */                 .addComponent(this.jTextField19, -2, -1, -2))
/*  934 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  935 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  936 */                 .addComponent(this.jLabel43)
/*  937 */                 .addComponent(this.jTextField20, -2, -1, -2)
/*  938 */                 .addComponent(this.jLabel45)
/*  939 */                 .addComponent(this.jTextField21, -2, -1, -2))
/*  940 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  941 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  942 */                 .addComponent(this.jLabel50)
/*  943 */                 .addComponent(this.jTextField22, -2, -1, -2)
/*  944 */                 .addComponent(this.jTextField23, -2, -1, -2)
/*  945 */                 .addComponent(this.jLabel53)))
/*  946 */             .addComponent(this.jLabel3, -1, -1, 32767))
/*  947 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  948 */           .addComponent(this.jPanel4, -2, -1, -2)
/*  949 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  950 */           .addComponent(this.jLabel56)
/*  951 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  952 */           .addComponent(this.jScrollPane1, -2, 187, -2)
/*  953 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  954 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  955 */             .addComponent(this.jLabel60)
/*  956 */             .addComponent(this.jLabel57)
/*  957 */             .addComponent(this.jLabel61)
/*  958 */             .addComponent(this.jLabel35)
/*  959 */             .addComponent(this.jLabel34)
/*  960 */             .addComponent(this.jLabel36)
/*  961 */             .addComponent(this.jLabel37)
/*  962 */             .addComponent(this.jLabel40))
/*  963 */           .addContainerGap(19, 32767)));
/*      */ 
/*      */     
/*  966 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  967 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  968 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  969 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  970 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/*  972 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  973 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  974 */         .addComponent(this.jPanel3, -2, -1, -2));
/*      */ 
/*      */     
/*  977 */     this.jDialog3.setTitle("Agregar Comentario");
/*  978 */     this.jDialog3.setModal(true);
/*      */     
/*  980 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*      */     
/*  982 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/*  983 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/*  984 */     this.jLabel124.setHorizontalAlignment(0);
/*  985 */     this.jLabel124.setText("Agregar Comentarios");
/*      */     
/*  987 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/*  988 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/*  989 */     this.jLabel125.setHorizontalAlignment(4);
/*  990 */     this.jLabel125.setText("Comentario");
/*      */     
/*  992 */     this.jButton44.setMnemonic('G');
/*  993 */     this.jButton44.setText("Guardar");
/*  994 */     this.jButton44.setToolTipText("Guardar (Alt+G)");
/*  995 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  997 */             OperadoresBuscar.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1001 */     this.jButton45.setMnemonic('C');
/* 1002 */     this.jButton45.setText("Cerrar");
/* 1003 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 1004 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1006 */             OperadoresBuscar.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1010 */     this.jTextArea5.setColumns(20);
/* 1011 */     this.jTextArea5.setLineWrap(true);
/* 1012 */     this.jTextArea5.setRows(5);
/* 1013 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 1015 */     this.jLabel126.setText("Ingresa el nuevo comentario para este operador");
/*      */     
/* 1017 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1018 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1019 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1020 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1021 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1022 */           .addContainerGap()
/* 1023 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1024 */             .addComponent(this.jLabel126, -1, -1, 32767)
/* 1025 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
/* 1026 */               .addComponent(this.jButton44, -2, 89, -2)
/* 1027 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1028 */               .addComponent(this.jButton45, -2, 84, -2))
/* 1029 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
/* 1030 */               .addComponent(this.jLabel125, -2, 74, -2)
/* 1031 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1032 */               .addComponent(this.jScrollPane18, -2, 302, -2))
/* 1033 */             .addComponent(this.jSeparator27)
/* 1034 */             .addComponent(this.jLabel124, -1, -1, 32767))
/* 1035 */           .addContainerGap()));
/*      */     
/* 1037 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1038 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1039 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1040 */           .addComponent(this.jLabel124)
/* 1041 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1042 */           .addComponent(this.jSeparator27, -2, 10, -2)
/* 1043 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1044 */           .addComponent(this.jLabel126)
/* 1045 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1046 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1047 */             .addGroup(jPanel29Layout.createSequentialGroup()
/* 1048 */               .addComponent(this.jScrollPane18, -2, 96, -2)
/* 1049 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1050 */               .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1051 */                 .addComponent(this.jButton45)
/* 1052 */                 .addComponent(this.jButton44)))
/* 1053 */             .addComponent(this.jLabel125))
/* 1054 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1057 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1058 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1059 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1060 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1061 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */     
/* 1063 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1064 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1065 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */ 
/*      */     
/* 1068 */     this.jMenuItem1.setText("Copiar");
/* 1069 */     this.jPopupMenu1.add(this.jMenuItem1);
/*      */     
/* 1071 */     this.jDialog4.setTitle("Detalles del Vale");
/* 1072 */     this.jDialog4.setModal(true);
/*      */     
/* 1074 */     this.jPanel12.setBackground(new Color(255, 255, 255));
/*      */     
/* 1076 */     this.jLabel93.setFont(new Font("Times New Roman", 1, 25));
/* 1077 */     this.jLabel93.setForeground(new Color(102, 102, 102));
/* 1078 */     this.jLabel93.setHorizontalAlignment(0);
/* 1079 */     this.jLabel93.setText("Detalles del Operador");
/*      */     
/* 1081 */     this.jLabel13.setText("Clave");
/*      */     
/* 1083 */     this.jLabel18.setFont(new Font("Tahoma", 1, 11));
/* 1084 */     this.jLabel18.setText("OPE-0001");
/*      */     
/* 1086 */     this.jLabel19.setText("Actualizó");
/*      */     
/* 1088 */     this.jLabel20.setFont(new Font("Tahoma", 1, 11));
/* 1089 */     this.jLabel20.setText("Kofuz01");
/*      */     
/* 1091 */     this.jLabel22.setFont(new Font("Tahoma", 3, 11));
/* 1092 */     this.jLabel22.setForeground(Color.red);
/* 1093 */     this.jLabel22.setText("A continuación se muestra toda la información del operador  hasta el momento");
/*      */     
/* 1095 */     this.jLabel51.setFont(new Font("Tahoma", 1, 11));
/* 1096 */     this.jLabel51.setForeground(Color.red);
/* 1097 */     this.jLabel51.setHorizontalAlignment(0);
/* 1098 */     this.jLabel51.setText("<html><u>Cerrar</u></html>");
/* 1099 */     this.jLabel51.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1101 */             OperadoresBuscar.this.jLabel51MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1104 */             OperadoresBuscar.this.jLabel51MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1107 */             OperadoresBuscar.this.jLabel51MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1111 */     this.jLabel55.setFont(new Font("Tahoma", 1, 11));
/* 1112 */     this.jLabel55.setText("|");
/*      */     
/* 1114 */     this.jLabel98.setFont(new Font("Times New Roman", 1, 12));
/* 1115 */     this.jLabel98.setText("ESTATUS:");
/*      */     
/* 1117 */     this.jLabel101.setFont(new Font("Times New Roman", 1, 12));
/* 1118 */     this.jLabel101.setForeground(new Color(0, 0, 102));
/* 1119 */     this.jLabel101.setText("jLabel99");
/*      */     
/* 1121 */     this.jTextPane1.setEditable(false);
/* 1122 */     this.jScrollPane8.setViewportView(this.jTextPane1);
/*      */     
/* 1124 */     this.jLabel59.setFont(new Font("Tahoma", 1, 11));
/* 1125 */     this.jLabel59.setText("|");
/*      */     
/* 1127 */     this.jLabel52.setFont(new Font("Tahoma", 1, 11));
/* 1128 */     this.jLabel52.setForeground(Color.red);
/* 1129 */     this.jLabel52.setHorizontalAlignment(0);
/* 1130 */     this.jLabel52.setText("<html><u>Imprimir</u></html>");
/* 1131 */     this.jLabel52.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1133 */             OperadoresBuscar.this.jLabel52MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1136 */             OperadoresBuscar.this.jLabel52MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1139 */             OperadoresBuscar.this.jLabel52MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1143 */     this.jLabel63.setFont(new Font("Tahoma", 1, 11));
/* 1144 */     this.jLabel63.setText("|");
/*      */     
/* 1146 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1147 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1148 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1149 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1150 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1151 */           .addContainerGap()
/* 1152 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1153 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1154 */               .addComponent(this.jLabel13, -2, 36, -2)
/* 1155 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1156 */               .addComponent(this.jLabel18, -2, 227, -2))
/* 1157 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1158 */               .addComponent(this.jLabel19, -2, 48, -2)
/* 1159 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1160 */               .addComponent(this.jLabel20, -1, 530, 32767))
/* 1161 */             .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1162 */               .addComponent(this.jSeparator13, GroupLayout.Alignment.LEADING)
/* 1163 */               .addComponent(this.jLabel93, GroupLayout.Alignment.LEADING, -1, 584, 32767))
/* 1164 */             .addComponent(this.jScrollPane8, -1, 584, 32767)
/* 1165 */             .addComponent(this.jLabel22, -1, 584, 32767)
/* 1166 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 1167 */               .addComponent(this.jLabel98, -2, 69, -2)
/* 1168 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1169 */               .addComponent(this.jLabel101, -1, 174, 32767)
/* 1170 */               .addGap(204, 204, 204)
/* 1171 */               .addComponent(this.jLabel63)
/* 1172 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1173 */               .addComponent(this.jLabel52, -2, -1, -2)
/* 1174 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1175 */               .addComponent(this.jLabel59)
/* 1176 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1177 */               .addComponent(this.jLabel51, -2, -1, -2)
/* 1178 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1179 */               .addComponent(this.jLabel55)))
/* 1180 */           .addContainerGap()));
/*      */     
/* 1182 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1183 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1184 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1185 */           .addComponent(this.jLabel93)
/* 1186 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1187 */           .addComponent(this.jSeparator13, -2, 10, -2)
/* 1188 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1189 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1190 */             .addComponent(this.jLabel13)
/* 1191 */             .addComponent(this.jLabel18))
/* 1192 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1193 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1194 */             .addComponent(this.jLabel19)
/* 1195 */             .addComponent(this.jLabel20))
/* 1196 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1197 */           .addComponent(this.jLabel22)
/* 1198 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1199 */           .addComponent(this.jScrollPane8, -2, 258, -2)
/* 1200 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1201 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1202 */             .addComponent(this.jLabel55)
/* 1203 */             .addComponent(this.jLabel51, -2, -1, -2)
/* 1204 */             .addComponent(this.jLabel98)
/* 1205 */             .addComponent(this.jLabel101)
/* 1206 */             .addComponent(this.jLabel59)
/* 1207 */             .addComponent(this.jLabel52, -2, -1, -2)
/* 1208 */             .addComponent(this.jLabel63))
/* 1209 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1212 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1213 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1214 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1215 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1216 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/* 1218 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1219 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1220 */         .addComponent(this.jPanel12, -2, -1, -2));
/*      */ 
/*      */     
/* 1223 */     this.jDialog5.setTitle("Impresión de Gafetes");
/* 1224 */     this.jDialog5.setModal(true);
/*      */     
/* 1226 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/*      */     
/* 1228 */     this.jLabel127.setFont(new Font("Tahoma", 1, 14));
/* 1229 */     this.jLabel127.setForeground(new Color(0, 102, 102));
/* 1230 */     this.jLabel127.setHorizontalAlignment(0);
/* 1231 */     this.jLabel127.setText("Tipo de Gafete");
/*      */     
/* 1233 */     this.jLabel11.setText("<html>Selecciona el tipo de gafete que deseas crear y a continuación pulsa el botón siguiente</html>");
/*      */     
/* 1235 */     this.jRadioButton1.setBackground(new Color(146, 193, 134));
/* 1236 */     this.jRadioButton1.setSelected(true);
/* 1237 */     this.jRadioButton1.setText("Credencial Forsis");
/*      */     
/* 1239 */     this.jRadioButton2.setBackground(new Color(146, 193, 134));
/* 1240 */     this.jRadioButton2.setText("Curso Básico");
/* 1241 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1243 */             OperadoresBuscar.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1247 */     this.jButton7.setMnemonic('C');
/* 1248 */     this.jButton7.setText("Cancelar");
/* 1249 */     this.jButton7.setToolTipText("Cancelar (Alt+C)");
/* 1250 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1252 */             OperadoresBuscar.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1256 */     this.jButton8.setMnemonic('S');
/* 1257 */     this.jButton8.setText("Siguiente >");
/* 1258 */     this.jButton8.setToolTipText("Siguiente (Alt+S)");
/* 1259 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1261 */             OperadoresBuscar.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1265 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1266 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1267 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1268 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1269 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1270 */           .addContainerGap()
/* 1271 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1272 */             .addComponent(this.jLabel11, -1, 351, 32767)
/* 1273 */             .addComponent(this.jSeparator2, -1, 351, 32767)
/* 1274 */             .addComponent(this.jLabel127, -1, 351, 32767)
/* 1275 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1276 */               .addComponent(this.jRadioButton1, -2, 139, -2)
/* 1277 */               .addGap(40, 40, 40)
/* 1278 */               .addComponent(this.jRadioButton2, -2, 141, -2)
/* 1279 */               .addGap(0, 0, 32767))
/* 1280 */             .addComponent(this.jSeparator3, -1, 351, 32767)
/* 1281 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 1282 */               .addGap(0, 0, 32767)
/* 1283 */               .addComponent(this.jButton8, -2, 96, -2)
/* 1284 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1285 */               .addComponent(this.jButton7, -2, 96, -2)))
/* 1286 */           .addContainerGap()));
/*      */     
/* 1288 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1289 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1290 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1291 */           .addContainerGap()
/* 1292 */           .addComponent(this.jLabel127)
/* 1293 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1294 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 1295 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1296 */           .addComponent(this.jLabel11, -2, 42, -2)
/* 1297 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1298 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1299 */             .addComponent(this.jRadioButton1)
/* 1300 */             .addComponent(this.jRadioButton2))
/* 1301 */           .addGap(18, 18, 18)
/* 1302 */           .addComponent(this.jSeparator3, -2, 10, -2)
/* 1303 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1304 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1305 */             .addComponent(this.jButton7)
/* 1306 */             .addComponent(this.jButton8))
/* 1307 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1310 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1311 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1312 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1313 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1314 */         .addComponent(this.jPanel6, -2, -1, -2));
/*      */     
/* 1316 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1317 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1318 */         .addComponent(this.jPanel6, -2, -1, -2));
/*      */ 
/*      */     
/* 1321 */     this.jDialog7.setTitle("Impresión de Gafetes");
/* 1322 */     this.jDialog7.setModal(true);
/*      */     
/* 1324 */     this.jPanel10.setBackground(new Color(255, 255, 255));
/*      */     
/* 1326 */     this.jLabel30.setFont(new Font("Times New Roman", 1, 20));
/* 1327 */     this.jLabel30.setHorizontalAlignment(0);
/* 1328 */     this.jLabel30.setText("Credencial RigPass para Locaciones");
/*      */     
/* 1330 */     this.jLabel31.setFont(new Font("Tahoma", 1, 12));
/* 1331 */     this.jLabel31.setForeground(new Color(153, 153, 153));
/* 1332 */     this.jLabel31.setText("Frente       Frente       Frente       Frente       Frente       Frente       Frente");
/*      */     
/* 1334 */     this.jLabel33.setFont(new Font("Tahoma", 1, 12));
/* 1335 */     this.jLabel33.setForeground(new Color(153, 153, 153));
/* 1336 */     this.jLabel33.setText("Reverso      Reverso      Reverso      Reverso      Reverso      Reverso ");
/*      */     
/* 1338 */     this.jButton12.setMnemonic('C');
/* 1339 */     this.jButton12.setText("Cancelar");
/* 1340 */     this.jButton12.setToolTipText("Cancelar (Alt+C)");
/* 1341 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1343 */             OperadoresBuscar.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1347 */     this.jButton13.setMnemonic('I');
/* 1348 */     this.jButton13.setText("Imprimir");
/* 1349 */     this.jButton13.setToolTipText("Imprimir (Alt+I)");
/* 1350 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1352 */             OperadoresBuscar.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1356 */     this.jButton14.setMnemonic('R');
/* 1357 */     this.jButton14.setText("< Regresar");
/* 1358 */     this.jButton14.setToolTipText("Regresar (Alt+R)");
/* 1359 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1361 */             OperadoresBuscar.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1365 */     this.jPanel18.setBackground(new Color(255, 255, 255));
/* 1366 */     this.jPanel18.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1367 */     this.jPanel18.setLayout((LayoutManager)null);
/*      */     
/* 1369 */     this.jLabel107.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis50.png")));
/* 1370 */     this.jPanel18.add(this.jLabel107);
/* 1371 */     this.jLabel107.setBounds(10, 10, 50, 50);
/*      */     
/* 1373 */     this.jLabel108.setFont(new Font("Tahoma", 1, 13));
/* 1374 */     this.jLabel108.setForeground(new Color(0, 51, 204));
/* 1375 */     this.jLabel108.setHorizontalAlignment(0);
/* 1376 */     this.jLabel108.setText("<html><u>CURSO DE SEGURIDAD BÁSICA</u></html>");
/* 1377 */     this.jPanel18.add(this.jLabel108);
/* 1378 */     this.jLabel108.setBounds(110, 120, 300, 20);
/*      */     
/* 1380 */     this.jLabel109.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/icoBarra.png")));
/* 1381 */     this.jPanel18.add(this.jLabel109);
/* 1382 */     this.jLabel109.setBounds(70, 30, 350, 40);
/*      */     
/* 1384 */     this.jLabel111.setFont(new Font("Tahoma", 1, 14));
/* 1385 */     this.jLabel111.setForeground(new Color(0, 51, 204));
/* 1386 */     this.jLabel111.setHorizontalAlignment(0);
/* 1387 */     this.jLabel111.setText("FLETES Y MATERIALES FORSIS S.A. DE C.V.");
/* 1388 */     this.jPanel18.add(this.jLabel111);
/* 1389 */     this.jLabel111.setBounds(60, 10, 340, 17);
/*      */     
/* 1391 */     this.jLabel112.setFont(new Font("Tahoma", 1, 11));
/* 1392 */     this.jLabel112.setHorizontalAlignment(0);
/* 1393 */     this.jLabel112.setText("ACREDITA A:");
/* 1394 */     this.jPanel18.add(this.jLabel112);
/* 1395 */     this.jLabel112.setBounds(110, 70, 290, 14);
/*      */     
/* 1397 */     this.jLabel113.setFont(new Font("Tahoma", 1, 11));
/* 1398 */     this.jLabel113.setForeground(new Color(0, 51, 204));
/* 1399 */     this.jLabel113.setHorizontalAlignment(0);
/* 1400 */     this.jLabel113.setText("UZZIEL CONTRERAS PORTILLA");
/* 1401 */     this.jPanel18.add(this.jLabel113);
/* 1402 */     this.jLabel113.setBounds(110, 90, 300, 14);
/*      */     
/* 1404 */     this.jLabel114.setHorizontalAlignment(0);
/* 1405 */     this.jLabel114.setText("DE HABER:");
/* 1406 */     this.jPanel18.add(this.jLabel114);
/* 1407 */     this.jLabel114.setBounds(110, 110, 290, 15);
/*      */     
/* 1409 */     this.jLabel116.setHorizontalAlignment(0);
/* 1410 */     this.jLabel116.setText("<html><center>Certificado por:<br>SECRETARÍA DEL TRABAJO Y PREVISION SOCIAL\n</center></html>");
/* 1411 */     this.jPanel18.add(this.jLabel116);
/* 1412 */     this.jLabel116.setBounds(110, 190, 300, 30);
/*      */     
/* 1414 */     this.jLabel117.setHorizontalAlignment(0);
/* 1415 */     this.jLabel117.setText("VACJ 710806 TU8 ");
/* 1416 */     this.jLabel117.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1418 */             OperadoresBuscar.this.jLabel117MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1421 */             OperadoresBuscar.this.jLabel117MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1424 */             OperadoresBuscar.this.jLabel117MouseExited(evt);
/*      */           }
/*      */         });
/* 1427 */     this.jPanel18.add(this.jLabel117);
/* 1428 */     this.jLabel117.setBounds(110, 150, 300, 40);
/*      */     
/* 1430 */     this.jLabel110.setFont(new Font("Tahoma", 0, 10));
/* 1431 */     this.jLabel110.setText("<html><center><font color=Black>|</font>Carretera México - Tuxpan Km. 8.5<font color=Black>|</font>Ejido Lázaro Cárdenas<font color=Black>|</font>Tihuatlán, Veracruz<font color=Black>|</font>México<font color=Black>|</font>C.P. 92901<font color=Black>|</font>(01 782)-825-6455 al 58<font color=Black>|</font></center></html>");
/* 1432 */     this.jPanel18.add(this.jLabel110);
/* 1433 */     this.jLabel110.setBounds(0, 220, 450, 30);
/*      */     
/* 1435 */     this.jLabel115.setHorizontalAlignment(0);
/* 1436 */     this.jLabel115.setText("sin foto");
/* 1437 */     this.jLabel115.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
/* 1438 */     this.jPanel18.add(this.jLabel115);
/* 1439 */     this.jLabel115.setBounds(10, 80, 110, 130);
/*      */     
/* 1441 */     this.jLabel120.setHorizontalAlignment(0);
/* 1442 */     this.jLabel120.setText("AGENTE CAPACITADOR");
/* 1443 */     this.jPanel18.add(this.jLabel120);
/* 1444 */     this.jLabel120.setBounds(110, 140, 300, 15);
/*      */     
/* 1446 */     this.jPanel19.setBackground(new Color(255, 255, 255));
/* 1447 */     this.jPanel19.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1448 */     this.jPanel19.setLayout((LayoutManager)null);
/*      */     
/* 1450 */     this.jLabel121.setFont(new Font("Tahoma", 1, 14));
/* 1451 */     this.jLabel121.setForeground(new Color(0, 51, 204));
/* 1452 */     this.jLabel121.setHorizontalAlignment(0);
/* 1453 */     this.jLabel121.setText("CURSO DE SEGURIDAD BÁSICA");
/* 1454 */     this.jPanel19.add(this.jLabel121);
/* 1455 */     this.jLabel121.setBounds(60, 10, 340, 17);
/*      */     
/* 1457 */     this.jLabel129.setFont(new Font("Tahoma", 0, 12));
/* 1458 */     this.jLabel129.setForeground(new Color(0, 51, 153));
/* 1459 */     this.jLabel129.setText("COPU01087464");
/* 1460 */     this.jPanel19.add(this.jLabel129);
/* 1461 */     this.jLabel129.setBounds(160, 70, 260, 15);
/*      */     
/* 1463 */     this.jLabel130.setFont(new Font("Tahoma", 1, 11));
/* 1464 */     this.jLabel130.setText("CURP:");
/* 1465 */     this.jPanel19.add(this.jLabel130);
/* 1466 */     this.jLabel130.setBounds(10, 70, 140, 14);
/*      */     
/* 1468 */     this.jLabel131.setFont(new Font("Tahoma", 1, 11));
/* 1469 */     this.jLabel131.setText("NOMBRE DEL EMPLEADO:");
/* 1470 */     this.jPanel19.add(this.jLabel131);
/* 1471 */     this.jLabel131.setBounds(10, 40, 140, 14);
/*      */     
/* 1473 */     this.jLabel132.setFont(new Font("Tahoma", 0, 12));
/* 1474 */     this.jLabel132.setForeground(new Color(0, 51, 153));
/* 1475 */     this.jLabel132.setText("NOMBRE DEL EMPLEADO:");
/* 1476 */     this.jPanel19.add(this.jLabel132);
/* 1477 */     this.jLabel132.setBounds(160, 40, 260, 15);
/*      */     
/* 1479 */     this.jLabel133.setFont(new Font("Tahoma", 1, 11));
/* 1480 */     this.jLabel133.setText("IMSS:");
/* 1481 */     this.jPanel19.add(this.jLabel133);
/* 1482 */     this.jLabel133.setBounds(10, 100, 140, 14);
/*      */     
/* 1484 */     this.jLabel134.setFont(new Font("Tahoma", 0, 12));
/* 1485 */     this.jLabel134.setForeground(new Color(0, 51, 153));
/* 1486 */     this.jLabel134.setText("9837476276343");
/* 1487 */     this.jPanel19.add(this.jLabel134);
/* 1488 */     this.jLabel134.setBounds(160, 100, 260, 15);
/*      */     
/* 1490 */     this.jLabel135.setFont(new Font("Tahoma", 1, 11));
/* 1491 */     this.jLabel135.setForeground(new Color(0, 51, 153));
/* 1492 */     this.jLabel135.setText("00001");
/* 1493 */     this.jPanel19.add(this.jLabel135);
/* 1494 */     this.jLabel135.setBounds(380, 220, 60, 14);
/*      */     
/* 1496 */     this.jLabel136.setFont(new Font("Tahoma", 0, 12));
/* 1497 */     this.jLabel136.setForeground(new Color(0, 51, 153));
/* 1498 */     this.jLabel136.setText("ENERO 2011");
/* 1499 */     this.jLabel136.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1501 */             OperadoresBuscar.this.jLabel136MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1504 */             OperadoresBuscar.this.jLabel136MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1507 */             OperadoresBuscar.this.jLabel136MouseExited(evt);
/*      */           }
/*      */         });
/* 1510 */     this.jPanel19.add(this.jLabel136);
/* 1511 */     this.jLabel136.setBounds(160, 130, 260, 15);
/*      */     
/* 1513 */     this.jLabel42.setFont(new Font("Tahoma", 1, 11));
/* 1514 */     this.jLabel42.setHorizontalAlignment(0);
/* 1515 */     this.jLabel42.setText("<html><center>DE ACUERDO A LOS LINEAMIENTOS DE:<br>\"INTERNATIONAL ASSOCIATION OF DRILLI NG CONTRACTORS\"</center></html>");
/* 1516 */     this.jPanel19.add(this.jLabel42);
/* 1517 */     this.jLabel42.setBounds(10, 150, 420, 40);
/*      */     
/* 1519 */     this.jLabel137.setFont(new Font("Tahoma", 1, 11));
/* 1520 */     this.jLabel137.setText("VIGENCIA:");
/* 1521 */     this.jPanel19.add(this.jLabel137);
/* 1522 */     this.jLabel137.setBounds(10, 130, 140, 14);
/*      */     
/* 1524 */     this.jLabel118.setText("__________________");
/* 1525 */     this.jPanel19.add(this.jLabel118);
/* 1526 */     this.jLabel118.setBounds(60, 220, 160, 15);
/*      */     
/* 1528 */     this.jLabel138.setFont(new Font("Tahoma", 1, 11));
/* 1529 */     this.jLabel138.setText("Firma:");
/* 1530 */     this.jPanel19.add(this.jLabel138);
/* 1531 */     this.jLabel138.setBounds(10, 220, 50, 14);
/*      */     
/* 1533 */     this.jLabel139.setFont(new Font("Tahoma", 1, 11));
/* 1534 */     this.jLabel139.setHorizontalAlignment(4);
/* 1535 */     this.jLabel139.setText("FPR-");
/* 1536 */     this.jPanel19.add(this.jLabel139);
/* 1537 */     this.jLabel139.setBounds(320, 220, 50, 14);
/*      */     
/* 1539 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1540 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1541 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1542 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1543 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1544 */           .addContainerGap()
/* 1545 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1546 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 1547 */               .addComponent(this.jButton14, -2, 97, -2)
/* 1548 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1549 */               .addComponent(this.jButton13, -2, 97, -2)
/* 1550 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1551 */               .addComponent(this.jButton12, -2, 97, -2))
/* 1552 */             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1553 */               .addComponent(this.jPanel19, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1554 */               .addComponent(this.jLabel33, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1555 */               .addComponent(this.jLabel30, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1556 */               .addComponent(this.jSeparator6, GroupLayout.Alignment.LEADING)
/* 1557 */               .addComponent(this.jPanel18, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1558 */               .addComponent(this.jLabel31, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 1559 */           .addContainerGap(23, 32767)));
/*      */     
/* 1561 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1562 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1563 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1564 */           .addComponent(this.jLabel30, -2, 34, -2)
/* 1565 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1566 */           .addComponent(this.jSeparator6, -2, 10, -2)
/* 1567 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1568 */           .addComponent(this.jLabel31)
/* 1569 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1570 */           .addComponent(this.jPanel18, -2, 248, -2)
/* 1571 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1572 */           .addComponent(this.jLabel33)
/* 1573 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1574 */           .addComponent(this.jPanel19, -2, 248, -2)
/* 1575 */           .addGap(18, 18, 18)
/* 1576 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1577 */             .addComponent(this.jButton12)
/* 1578 */             .addComponent(this.jButton13)
/* 1579 */             .addComponent(this.jButton14))
/* 1580 */           .addContainerGap(23, 32767)));
/*      */ 
/*      */     
/* 1583 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 1584 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 1585 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 1586 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1587 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */     
/* 1589 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 1590 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1591 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */ 
/*      */     
/* 1594 */     this.jDialog6.setTitle("Impresión de Gafetes");
/* 1595 */     this.jDialog6.setModal(true);
/*      */     
/* 1597 */     this.jPanel14.setBackground(new Color(255, 255, 255));
/*      */     
/* 1599 */     this.jLabel44.setFont(new Font("Times New Roman", 1, 20));
/* 1600 */     this.jLabel44.setHorizontalAlignment(0);
/* 1601 */     this.jLabel44.setText("Gafette para empleados");
/*      */     
/* 1603 */     this.jLabel46.setFont(new Font("Tahoma", 1, 12));
/* 1604 */     this.jLabel46.setForeground(new Color(153, 153, 153));
/* 1605 */     this.jLabel46.setText("Frente        Frente        Frente        Frente        Frente        Frente    ");
/*      */     
/* 1607 */     this.jPanel15.setBackground(new Color(255, 255, 255));
/* 1608 */     this.jPanel15.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1609 */     this.jPanel15.setLayout((LayoutManager)null);
/*      */     
/* 1611 */     this.jLabel12.setFont(new Font("Times New Roman", 0, 19));
/* 1612 */     this.jLabel12.setForeground(new Color(153, 0, 0));
/* 1613 */     this.jLabel12.setText("Fletes y Materiales Forsis S.A. de C.V.");
/* 1614 */     this.jPanel15.add(this.jLabel12);
/* 1615 */     this.jLabel12.setBounds(40, 0, 330, 23);
/*      */     
/* 1617 */     this.jLabel28.setText("____________________________________________________");
/* 1618 */     this.jPanel15.add(this.jLabel28);
/* 1619 */     this.jLabel28.setBounds(40, 20, 370, 15);
/*      */     
/* 1621 */     this.jLabel29.setText("___________________________________________________");
/* 1622 */     this.jPanel15.add(this.jLabel29);
/* 1623 */     this.jLabel29.setBounds(20, 10, 370, 15);
/*      */     
/* 1625 */     this.jLabel67.setHorizontalAlignment(0);
/* 1626 */     this.jLabel67.setText("sin foto");
/* 1627 */     this.jLabel67.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
/* 1628 */     this.jPanel15.add(this.jLabel67);
/* 1629 */     this.jLabel67.setBounds(10, 40, 110, 130);
/*      */     
/* 1631 */     this.jLabel80.setFont(new Font("Tahoma", 1, 11));
/* 1632 */     this.jLabel80.setHorizontalAlignment(0);
/* 1633 */     this.jLabel80.setText("OP-00001");
/* 1634 */     this.jPanel15.add(this.jLabel80);
/* 1635 */     this.jLabel80.setBounds(10, 170, 110, 14);
/*      */     
/* 1637 */     this.jLabel82.setFont(new Font("Tahoma", 1, 10));
/* 1638 */     this.jLabel82.setText("Nombre Completo");
/* 1639 */     this.jPanel15.add(this.jLabel82);
/* 1640 */     this.jLabel82.setBounds(130, 40, 280, 13);
/*      */     
/* 1642 */     this.jLabel83.setText("Núm de Licen");
/* 1643 */     this.jPanel15.add(this.jLabel83);
/* 1644 */     this.jLabel83.setBounds(130, 70, 230, 15);
/*      */     
/* 1646 */     this.jLabel84.setText("Tipo");
/* 1647 */     this.jPanel15.add(this.jLabel84);
/* 1648 */     this.jLabel84.setBounds(130, 90, 230, 15);
/*      */     
/* 1650 */     this.jLabel85.setText("Nss");
/* 1651 */     this.jPanel15.add(this.jLabel85);
/* 1652 */     this.jLabel85.setBounds(130, 110, 230, 15);
/*      */     
/* 1654 */     this.jLabel86.setText("Vigencia");
/* 1655 */     this.jLabel86.setToolTipText("Clic para cambiar la vigencia");
/* 1656 */     this.jLabel86.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1658 */             OperadoresBuscar.this.jLabel86MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1661 */             OperadoresBuscar.this.jLabel86MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1664 */             OperadoresBuscar.this.jLabel86MouseExited(evt);
/*      */           }
/*      */         });
/* 1667 */     this.jPanel15.add(this.jLabel86);
/* 1668 */     this.jLabel86.setBounds(130, 150, 230, 15);
/*      */     
/* 1670 */     this.jPanel8.setBackground(new Color(247, 150, 70));
/*      */     
/* 1672 */     this.jLabel81.setFont(new Font("Tahoma", 1, 11));
/* 1673 */     this.jLabel81.setHorizontalAlignment(0);
/* 1674 */     this.jLabel81.setText("Categoría del Empleado");
/* 1675 */     this.jLabel81.setToolTipText("Clic para cambiar la categoría");
/*      */     
/* 1677 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1678 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1679 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1680 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1681 */         .addComponent(this.jLabel81, -1, 280, 32767));
/*      */     
/* 1683 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1684 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1685 */         .addComponent(this.jLabel81, -1, 20, 32767));
/*      */ 
/*      */     
/* 1688 */     this.jPanel15.add(this.jPanel8);
/* 1689 */     this.jPanel8.setBounds(130, 170, 280, 20);
/*      */     
/* 1691 */     this.jLabel87.setHorizontalAlignment(0);
/* 1692 */     this.jLabel87.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsisCreden.png")));
/* 1693 */     this.jPanel15.add(this.jLabel87);
/* 1694 */     this.jLabel87.setBounds(230, 40, 220, 150);
/*      */     
/* 1696 */     this.jPanel7.setBackground(new Color(153, 0, 0));
/*      */     
/* 1698 */     this.jLabel88.setFont(new Font("Tahoma", 0, 10));
/* 1699 */     this.jLabel88.setForeground(new Color(255, 255, 255));
/* 1700 */     this.jLabel88.setText("<html><center><font color=Black>|</font>Carretera México - Tuxpan Km. 8.5<font color=Black>|</font>Ejido Lázaro Cárdenas<font color=Black>|</font>Tihuatlán, Veracruz<font color=Black>|</font>México<font color=Black>|</font>C.P. 92901<font color=Black>|</font>(01 782)-825-6455 al 58<font color=Black>|</font></center></html>");
/*      */     
/* 1702 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1703 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1704 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1705 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1706 */         .addComponent(this.jLabel88, -1, 400, 32767));
/*      */     
/* 1708 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1709 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1710 */         .addComponent(this.jLabel88, -1, 30, 32767));
/*      */ 
/*      */     
/* 1713 */     this.jPanel15.add(this.jPanel7);
/* 1714 */     this.jPanel7.setBounds(10, 200, 400, 30);
/*      */     
/* 1716 */     this.jLabel89.setText("Curp");
/* 1717 */     this.jPanel15.add(this.jLabel89);
/* 1718 */     this.jLabel89.setBounds(130, 130, 230, 15);
/*      */     
/* 1720 */     this.jLabel49.setFont(new Font("Tahoma", 1, 12));
/* 1721 */     this.jLabel49.setForeground(new Color(153, 153, 153));
/* 1722 */     this.jLabel49.setHorizontalAlignment(0);
/* 1723 */     this.jLabel49.setText("Reverso        Reverso        Reverso        Reverso        Reverso        ");
/*      */     
/* 1725 */     this.jButton16.setMnemonic('C');
/* 1726 */     this.jButton16.setText("Cancelar");
/* 1727 */     this.jButton16.setToolTipText("Cancelar (Alt+C)");
/* 1728 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1730 */             OperadoresBuscar.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1734 */     this.jButton17.setMnemonic('I');
/* 1735 */     this.jButton17.setText("Imprimir");
/* 1736 */     this.jButton17.setToolTipText("Imprimir (Alt+I)");
/* 1737 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1739 */             OperadoresBuscar.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1743 */     this.jButton18.setMnemonic('R');
/* 1744 */     this.jButton18.setText("< Regresar");
/* 1745 */     this.jButton18.setToolTipText("Regresar (Alt+R)");
/* 1746 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1748 */             OperadoresBuscar.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1752 */     this.jPanel16.setBackground(new Color(255, 255, 255));
/* 1753 */     this.jPanel16.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1754 */     this.jPanel16.setLayout((LayoutManager)null);
/*      */     
/* 1756 */     this.jLabel65.setFont(new Font("Times New Roman", 0, 19));
/* 1757 */     this.jLabel65.setForeground(new Color(153, 0, 0));
/* 1758 */     this.jLabel65.setHorizontalAlignment(0);
/* 1759 */     this.jLabel65.setText("Políticas de la empresa");
/* 1760 */     this.jPanel16.add(this.jLabel65);
/* 1761 */     this.jLabel65.setBounds(40, 0, 330, 23);
/*      */     
/* 1763 */     this.jLabel90.setText("____________________________________________________");
/* 1764 */     this.jPanel16.add(this.jLabel90);
/* 1765 */     this.jLabel90.setBounds(40, 20, 370, 15);
/*      */     
/* 1767 */     this.jLabel91.setText("___________________________________________________");
/* 1768 */     this.jPanel16.add(this.jLabel91);
/* 1769 */     this.jLabel91.setBounds(20, 10, 370, 15);
/*      */     
/* 1771 */     this.jLabel94.setFont(new Font("Tahoma", 0, 8));
/* 1772 */     this.jLabel94.setText("<html>•  Brindar  trato justo y esmerado a todos los clientes, en sus solicitudes y reclamos considerando que el fin de la empresa es el servicio del cliente.</html>");
/* 1773 */     this.jPanel16.add(this.jLabel94);
/* 1774 */     this.jLabel94.setBounds(20, 40, 380, 20);
/*      */     
/* 1776 */     this.jLabel95.setFont(new Font("Tahoma", 0, 8));
/* 1777 */     this.jLabel95.setText("<html>• Definir por escrito, los tiempos de respuesta de todo requerimiento interno o externo, es mi responsabilidad.</html>");
/* 1778 */     this.jPanel16.add(this.jLabel95);
/* 1779 */     this.jLabel95.setBounds(20, 60, 400, 30);
/*      */     
/* 1781 */     this.jLabel96.setFont(new Font("Tahoma", 0, 8));
/* 1782 */     this.jLabel96.setText("<html>• Como integrante de la empresa debo mantener un comportamiento ético, desterrar toda forma de paternalismo y favoritismo, cumpliendo el reglamento vigente de FORSIS y de todos los clientes.</html>");
/* 1783 */     this.jPanel16.add(this.jLabel96);
/* 1784 */     this.jLabel96.setBounds(20, 90, 390, 20);
/*      */     
/* 1786 */     this.jLabel97.setFont(new Font("Tahoma", 0, 10));
/* 1787 */     this.jLabel97.setHorizontalAlignment(0);
/* 1788 */     this.jLabel97.setText("Roger Garza Cantú");
/* 1789 */     this.jPanel16.add(this.jLabel97);
/* 1790 */     this.jLabel97.setBounds(300, 170, 110, 13);
/*      */     
/* 1792 */     this.jLabel99.setHorizontalAlignment(0);
/* 1793 */     this.jLabel99.setText("_______________");
/* 1794 */     this.jPanel16.add(this.jLabel99);
/* 1795 */     this.jLabel99.setBounds(300, 200, 110, 15);
/*      */     
/* 1797 */     this.jLabel100.setFont(new Font("Tahoma", 0, 10));
/* 1798 */     this.jLabel100.setHorizontalAlignment(0);
/* 1799 */     this.jLabel100.setText("Director");
/* 1800 */     this.jPanel16.add(this.jLabel100);
/* 1801 */     this.jLabel100.setBounds(310, 210, 100, 14);
/*      */     
/* 1803 */     this.jLabel102.setFont(new Font("Tahoma", 0, 10));
/* 1804 */     this.jLabel102.setHorizontalAlignment(0);
/* 1805 */     this.jLabel102.setText("Nombre Completo");
/* 1806 */     this.jPanel16.add(this.jLabel102);
/* 1807 */     this.jLabel102.setBounds(10, 170, 170, 13);
/*      */     
/* 1809 */     this.jLabel103.setHorizontalAlignment(0);
/* 1810 */     this.jLabel103.setText("_________________");
/* 1811 */     this.jPanel16.add(this.jLabel103);
/* 1812 */     this.jLabel103.setBounds(10, 200, 150, 15);
/*      */     
/* 1814 */     this.jLabel104.setFont(new Font("Tahoma", 0, 10));
/* 1815 */     this.jLabel104.setHorizontalAlignment(0);
/* 1816 */     this.jLabel104.setText("Categoría");
/* 1817 */     this.jPanel16.add(this.jLabel104);
/* 1818 */     this.jLabel104.setBounds(10, 210, 160, 14);
/*      */     
/* 1820 */     this.jLabel105.setFont(new Font("Tahoma", 0, 8));
/* 1821 */     this.jLabel105.setText("<html>• Como operador capacitado atender al cliente es mi responsabilidad, para lo cual debo conocer los procedimientos a fin de realizarlos con excelencia..</html>");
/* 1822 */     this.jPanel16.add(this.jLabel105);
/* 1823 */     this.jLabel105.setBounds(20, 120, 390, 20);
/* 1824 */     this.jPanel16.add(this.jLabel92);
/* 1825 */     this.jLabel92.setBounds(330, 170, 50, 60);
/*      */     
/* 1827 */     this.jLabel106.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/fondoTrac.png")));
/* 1828 */     this.jLabel106.setText("l");
/* 1829 */     this.jPanel16.add(this.jLabel106);
/* 1830 */     this.jLabel106.setBounds(10, 60, 400, 120);
/*      */     
/* 1832 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1833 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1834 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1835 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1836 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1837 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1838 */             .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1839 */               .addGroup(GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
/* 1840 */                 .addContainerGap()
/* 1841 */                 .addComponent(this.jSeparator7))
/* 1842 */               .addComponent(this.jLabel44, GroupLayout.Alignment.LEADING, -2, 423, -2))
/* 1843 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 1844 */               .addContainerGap()
/* 1845 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1846 */                 .addComponent(this.jPanel15, -2, 419, -2)
/* 1847 */                 .addComponent(this.jLabel46, -1, -1, 32767)
/* 1848 */                 .addComponent(this.jPanel16, -2, 419, -2)
/* 1849 */                 .addComponent(this.jLabel49, -1, -1, 32767)
/* 1850 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/* 1851 */                   .addGap(0, 0, 32767)
/* 1852 */                   .addComponent(this.jButton18, -2, 97, -2)
/* 1853 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1854 */                   .addComponent(this.jButton17, -2, 97, -2)
/* 1855 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1856 */                   .addComponent(this.jButton16, -2, 97, -2)))))
/* 1857 */           .addContainerGap()));
/*      */     
/* 1859 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1860 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1861 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1862 */           .addComponent(this.jLabel44, -2, 22, -2)
/* 1863 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1864 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 1865 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1866 */           .addComponent(this.jLabel46)
/* 1867 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1868 */           .addComponent(this.jPanel15, -2, 235, -2)
/* 1869 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1870 */           .addComponent(this.jLabel49)
/* 1871 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1872 */           .addComponent(this.jPanel16, -2, 235, -2)
/* 1873 */           .addGap(18, 18, 18)
/* 1874 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1875 */             .addComponent(this.jButton16)
/* 1876 */             .addComponent(this.jButton17)
/* 1877 */             .addComponent(this.jButton18))
/* 1878 */           .addContainerGap(19, 32767)));
/*      */ 
/*      */     
/* 1881 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1882 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1883 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1884 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1885 */         .addComponent(this.jPanel14, -2, 437, -2));
/*      */     
/* 1887 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1888 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1889 */         .addComponent(this.jPanel14, -2, -1, -2));
/*      */ 
/*      */     
/* 1892 */     this.jLabel119.setText("Coloca la vigencia");
/*      */     
/* 1894 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1895 */     this.jDateChooser5.setIcon(this.icon);
/*      */     
/* 1897 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 1898 */     this.jPanel20.setLayout(jPanel20Layout);
/* 1899 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 1900 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1901 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1902 */           .addContainerGap()
/* 1903 */           .addComponent(this.jLabel119, -1, 115, 32767)
/* 1904 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1905 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 1906 */           .addContainerGap()));
/*      */     
/* 1908 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 1909 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1910 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1911 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1912 */             .addComponent((Component)this.jDateChooser5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1913 */             .addComponent(this.jLabel119, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1914 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1917 */     this.jDialog8.setTitle("Firmas");
/* 1918 */     this.jDialog8.setModal(true);
/*      */     
/* 1920 */     this.jPanel9.setBackground(new Color(146, 193, 134));
/* 1921 */     this.jPanel9.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 1922 */     this.jPanel9.setLayout((LayoutManager)null);
/*      */     
/* 1924 */     this.jLabel69.setHorizontalAlignment(0);
/* 1925 */     this.jPanel9.add(this.jLabel69);
/* 1926 */     this.jLabel69.setBounds(2, 2, 580, 251);
/*      */     
/* 1928 */     this.jLabel70.setFont(new Font("Times New Roman", 1, 23));
/* 1929 */     this.jLabel70.setForeground(Color.blue);
/* 1930 */     this.jLabel70.setHorizontalAlignment(0);
/* 1931 */     this.jLabel70.setText("<HTML><CENTER>FIRMA</CENTER></HTML>");
/* 1932 */     this.jPanel9.add(this.jLabel70);
/* 1933 */     this.jLabel70.setBounds(2, 275, 580, 46);
/*      */     
/* 1935 */     this.jSeparator4.setBackground(new Color(0, 0, 0));
/* 1936 */     this.jPanel9.add(this.jSeparator4);
/* 1937 */     this.jSeparator4.setBounds(12, 264, 570, 10);
/*      */     
/* 1939 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 1940 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 1941 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 1942 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1943 */         .addGroup(jDialog8Layout.createSequentialGroup()
/* 1944 */           .addComponent(this.jPanel9, -2, 592, -2)
/* 1945 */           .addGap(0, 0, 32767)));
/*      */     
/* 1947 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 1948 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1949 */         .addComponent(this.jPanel9, -1, 339, 32767));
/*      */ 
/*      */     
/* 1952 */     this.jDialog9.setTitle("Curso Básico de Seguridad");
/* 1953 */     this.jDialog9.setModal(true);
/*      */     
/* 1955 */     this.jPanel13.setBackground(new Color(146, 193, 134));
/*      */     
/* 1957 */     this.jPanel33.setBackground(new Color(146, 193, 134));
/* 1958 */     this.jPanel33.setLayout(new GridLayout(1, 2, 10, 0));
/*      */     
/* 1960 */     this.jPanel11.setBackground(Color.white);
/* 1961 */     this.jPanel11.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
/*      */     
/* 1963 */     this.jPanel21.setBackground(Color.white);
/*      */     
/* 1965 */     this.jLabel71.setHorizontalAlignment(0);
/* 1966 */     this.jLabel71.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis100x.png")));
/*      */     
/* 1968 */     this.jLabel72.setText("<html><center><b>FLETES Y MATERIALES FORSIS, SA DE CV</b><p>Carretera México-Tuxpan Km 8.5, Ejido Lázaro Cárdenas, Tihuatlán México <p>Tel: (01 782) 825 6455 al 58</center></html>");
/*      */     
/* 1970 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 1971 */     this.jPanel21.setLayout(jPanel21Layout);
/* 1972 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 1973 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1974 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 1975 */           .addComponent(this.jLabel71, -2, 127, -2)
/* 1976 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1977 */           .addComponent(this.jLabel72, -1, 239, 32767)));
/*      */     
/* 1979 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 1980 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1981 */         .addComponent(this.jLabel72)
/* 1982 */         .addComponent(this.jLabel71, -1, -1, 32767));
/*      */ 
/*      */     
/* 1985 */     this.jPanel22.setBackground(new Color(255, 0, 0));
/*      */     
/* 1987 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 1988 */     this.jPanel22.setLayout(jPanel22Layout);
/* 1989 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 1990 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1991 */         .addGap(0, 0, 32767));
/*      */     
/* 1993 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 1994 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1995 */         .addGap(0, 8, 32767));
/*      */ 
/*      */     
/* 1998 */     this.jLabel73.setHorizontalAlignment(0);
/* 1999 */     this.jLabel73.setText("FOLIO");
/*      */     
/* 2001 */     this.jPanel23.setBackground(Color.white);
/* 2002 */     this.jPanel23.setLayout((LayoutManager)null);
/*      */     
/* 2004 */     this.jPanel24.setBackground(new Color(255, 0, 0));
/*      */     
/* 2006 */     this.jLabel74.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2007 */     this.jLabel74.setForeground(Color.white);
/* 2008 */     this.jLabel74.setHorizontalAlignment(0);
/* 2009 */     this.jLabel74.setText("<html><center>EL PORTADOR DE ESTA TARJETA A ACREDITADO UN CURSO DE ORIENTACIÓN BÁSICA DE SEGURIDAD PARA INGRESAR A INSTALACIONES PETROLERAS</center></html>");
/*      */     
/* 2011 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/* 2012 */     this.jPanel24.setLayout(jPanel24Layout);
/* 2013 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/* 2014 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2015 */         .addComponent(this.jLabel74, -1, 340, 32767));
/*      */     
/* 2017 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/* 2018 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2019 */         .addComponent(this.jLabel74, -1, 100, 32767));
/*      */ 
/*      */     
/* 2022 */     this.jPanel23.add(this.jPanel24);
/* 2023 */     this.jPanel24.setBounds(20, 10, 340, 100);
/*      */     
/* 2025 */     this.jPanel25.setBackground(new Color(177, 189, 188));
/*      */     
/* 2027 */     this.jPanel26.setBackground(new Color(177, 189, 188));
/* 2028 */     this.jPanel26.setLayout(new GridLayout(2, 0, 0, 10));
/*      */     
/* 2030 */     this.jLabel75.setForeground(new Color(0, 0, 0));
/* 2031 */     this.jLabel75.setHorizontalAlignment(0);
/* 2032 */     this.jLabel75.setText("NOMBRE:");
/* 2033 */     this.jPanel26.add(this.jLabel75);
/*      */     
/* 2035 */     this.jLabel76.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2036 */     this.jLabel76.setForeground(new Color(0, 0, 0));
/* 2037 */     this.jLabel76.setHorizontalAlignment(0);
/* 2038 */     this.jLabel76.setText("NOMBRE DEL EMPLEADO");
/* 2039 */     this.jPanel26.add(this.jLabel76);
/*      */     
/* 2041 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/* 2042 */     this.jPanel25.setLayout(jPanel25Layout);
/* 2043 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/* 2044 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2045 */         .addComponent(this.jPanel26, -1, -1, 32767));
/*      */     
/* 2047 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/* 2048 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2049 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
/* 2050 */           .addContainerGap(64, 32767)
/* 2051 */           .addComponent(this.jPanel26, -2, -1, -2)
/* 2052 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2055 */     this.jPanel23.add(this.jPanel25);
/* 2056 */     this.jPanel25.setBounds(0, 60, 370, 120);
/*      */     
/* 2058 */     this.jPanel27.setBackground(new Color(177, 189, 188));
/* 2059 */     this.jPanel27.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 2060 */     this.jPanel27.setLayout(new GridLayout(1, 0));
/*      */     
/* 2062 */     this.jLabel77.setHorizontalAlignment(0);
/* 2063 */     this.jPanel27.add(this.jLabel77);
/*      */     
/* 2065 */     this.jPanel28.setBackground(Color.white);
/*      */     
/* 2067 */     this.jLabel78.setBackground(new Color(255, 0, 0));
/* 2068 */     this.jLabel78.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2069 */     this.jLabel78.setForeground(new Color(255, 0, 0));
/* 2070 */     this.jLabel78.setText("CURSO BÁSICO DE SEGURIDAD");
/*      */     
/* 2072 */     this.jPanel30.setBackground(Color.white);
/* 2073 */     this.jPanel30.setLayout(new GridLayout(4, 2, 6, 6));
/*      */     
/* 2075 */     this.jLabel79.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2076 */     this.jLabel79.setText("DURACIÓN:");
/* 2077 */     this.jPanel30.add(this.jLabel79);
/*      */     
/* 2079 */     this.jPanel31.setBackground(Color.white);
/* 2080 */     this.jPanel31.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2082 */     this.jSpinner1.setModel(new SpinnerNumberModel(8, 1, 480, 1));
/* 2083 */     this.jPanel31.add(this.jSpinner1);
/*      */     
/* 2085 */     this.jLabel146.setText("hrs.");
/* 2086 */     this.jPanel31.add(this.jLabel146);
/*      */     
/* 2088 */     this.jPanel30.add(this.jPanel31);
/*      */     
/* 2090 */     this.jLabel140.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2091 */     this.jLabel140.setText("VIGENCIA:");
/* 2092 */     this.jPanel30.add(this.jLabel140);
/*      */     
/* 2094 */     this.jDateChooser1.setIcon(this.icon);
/* 2095 */     this.jPanel30.add((Component)this.jDateChooser1);
/*      */     
/* 2097 */     this.jLabel142.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2098 */     this.jLabel142.setText("FECHA:");
/* 2099 */     this.jPanel30.add(this.jLabel142);
/*      */     
/* 2101 */     this.jLabel143.setText("jLabel143");
/* 2102 */     this.jPanel30.add(this.jLabel143);
/*      */     
/* 2104 */     this.jLabel144.setFont(new Font("Ubuntu Semi-Light", 1, 11));
/* 2105 */     this.jLabel144.setText("CATEGORÍA:");
/* 2106 */     this.jPanel30.add(this.jLabel144);
/*      */     
/* 2108 */     this.jTextField29.setText("jTextField29");
/* 2109 */     this.jPanel30.add(this.jTextField29);
/*      */     
/* 2111 */     GroupLayout jPanel28Layout = new GroupLayout(this.jPanel28);
/* 2112 */     this.jPanel28.setLayout(jPanel28Layout);
/* 2113 */     jPanel28Layout.setHorizontalGroup(jPanel28Layout
/* 2114 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2115 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
/* 2116 */           .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2117 */             .addComponent(this.jPanel30, GroupLayout.Alignment.LEADING, -2, 0, 32767)
/* 2118 */             .addComponent(this.jLabel78, -1, -1, 32767))
/* 2119 */           .addContainerGap()));
/*      */     
/* 2121 */     jPanel28Layout.setVerticalGroup(jPanel28Layout
/* 2122 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2123 */         .addGroup(jPanel28Layout.createSequentialGroup()
/* 2124 */           .addComponent(this.jLabel78)
/* 2125 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2126 */           .addComponent(this.jPanel30, -1, 124, 32767)));
/*      */ 
/*      */     
/* 2129 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 2130 */     this.jPanel11.setLayout(jPanel11Layout);
/* 2131 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 2132 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2133 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 2134 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2135 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 2136 */               .addComponent(this.jPanel27, -2, 114, -2)
/* 2137 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2138 */               .addComponent(this.jPanel28, -1, -1, 32767))
/* 2139 */             .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2140 */               .addComponent(this.jPanel22, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2141 */               .addComponent(this.jPanel21, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2142 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 2143 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2144 */                 .addComponent(this.jPanel23, GroupLayout.Alignment.LEADING, -1, 369, 32767)
/* 2145 */                 .addComponent(this.jLabel73, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2146 */               .addGap(3, 3, 3)))
/* 2147 */           .addGap(12, 12, 12)));
/*      */     
/* 2149 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 2150 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2151 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 2152 */           .addComponent(this.jPanel21, -2, -1, -2)
/* 2153 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2154 */           .addComponent(this.jPanel22, -2, -1, -2)
/* 2155 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2156 */           .addComponent(this.jLabel73)
/* 2157 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2158 */           .addComponent(this.jPanel23, -2, 178, -2)
/* 2159 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2160 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2161 */             .addComponent(this.jPanel28, -1, -1, 32767)
/* 2162 */             .addComponent(this.jPanel27, -1, -1, 32767))
/* 2163 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2166 */     this.jPanel33.add(this.jPanel11);
/*      */     
/* 2168 */     this.jPanel35.setBackground(Color.white);
/* 2169 */     this.jPanel35.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
/*      */     
/* 2171 */     this.jPanel36.setBackground(Color.white);
/*      */     
/* 2173 */     this.jLabel128.setHorizontalAlignment(0);
/* 2174 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis100x.png")));
/*      */     
/* 2176 */     this.jLabel141.setText("<html><center><b>FLETES Y MATERIALES FORSIS, SA DE CV</b><p>Carretera México-Tuxpan Km 8.5, Ejido Lázaro Cárdenas, Tihuatlán México <p>Tel: (01 782) 825 6455 al 58</center></html>");
/*      */     
/* 2178 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 2179 */     this.jPanel36.setLayout(jPanel36Layout);
/* 2180 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 2181 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2182 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 2183 */           .addComponent(this.jLabel128, -2, 127, -2)
/* 2184 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2185 */           .addComponent(this.jLabel141, -1, 238, 32767)));
/*      */     
/* 2187 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 2188 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2189 */         .addComponent(this.jLabel141)
/* 2190 */         .addComponent(this.jLabel128, -1, -1, 32767));
/*      */ 
/*      */     
/* 2193 */     this.jPanel37.setBackground(new Color(255, 0, 0));
/*      */     
/* 2195 */     GroupLayout jPanel37Layout = new GroupLayout(this.jPanel37);
/* 2196 */     this.jPanel37.setLayout(jPanel37Layout);
/* 2197 */     jPanel37Layout.setHorizontalGroup(jPanel37Layout
/* 2198 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2199 */         .addGap(0, 0, 32767));
/*      */     
/* 2201 */     jPanel37Layout.setVerticalGroup(jPanel37Layout
/* 2202 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2203 */         .addGap(0, 8, 32767));
/*      */ 
/*      */     
/* 2206 */     this.jLabel145.setHorizontalAlignment(0);
/* 2207 */     this.jLabel145.setText("FOLIO");
/*      */     
/* 2209 */     this.jPanel38.setBackground(Color.white);
/* 2210 */     this.jPanel38.setLayout((LayoutManager)null);
/*      */     
/* 2212 */     this.jLabel150.setHorizontalAlignment(0);
/* 2213 */     this.jLabel150.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/FirmaQHSE.jpg")));
/* 2214 */     this.jPanel38.add(this.jLabel150);
/* 2215 */     this.jLabel150.setBounds(20, 10, 340, 90);
/*      */     
/* 2217 */     this.jPanel39.setBackground(new Color(255, 0, 0));
/*      */     
/* 2219 */     this.jPanel34.setBackground(Color.white);
/*      */     
/* 2221 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 2222 */     this.jPanel34.setLayout(jPanel34Layout);
/* 2223 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 2224 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2225 */         .addGap(0, 316, 32767));
/*      */     
/* 2227 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 2228 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2229 */         .addGap(0, 76, 32767));
/*      */ 
/*      */     
/* 2232 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/* 2233 */     this.jPanel39.setLayout(jPanel39Layout);
/* 2234 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/* 2235 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2236 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 2237 */           .addContainerGap()
/* 2238 */           .addComponent(this.jPanel34, -1, -1, 32767)
/* 2239 */           .addContainerGap()));
/*      */     
/* 2241 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/* 2242 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2243 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 2244 */           .addContainerGap()
/* 2245 */           .addComponent(this.jPanel34, -1, -1, 32767)
/* 2246 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2249 */     this.jPanel38.add(this.jPanel39);
/* 2250 */     this.jPanel39.setBounds(20, 10, 340, 88);
/*      */     
/* 2252 */     this.jPanel40.setBackground(new Color(177, 189, 188));
/*      */     
/* 2254 */     this.jPanel41.setBackground(new Color(177, 189, 188));
/* 2255 */     this.jPanel41.setLayout(new GridLayout(2, 0, 0, 10));
/*      */     
/* 2257 */     this.jLabel148.setForeground(new Color(0, 0, 0));
/* 2258 */     this.jLabel148.setHorizontalAlignment(0);
/* 2259 */     this.jLabel148.setText("AGENTE CAPACITADOR:");
/* 2260 */     this.jPanel41.add(this.jLabel148);
/*      */     
/* 2262 */     this.jLabel149.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2263 */     this.jLabel149.setForeground(new Color(0, 0, 0));
/* 2264 */     this.jLabel149.setHorizontalAlignment(0);
/* 2265 */     this.jLabel149.setText("NOMBRE DEL EMPLEADO");
/* 2266 */     this.jPanel41.add(this.jLabel149);
/*      */     
/* 2268 */     GroupLayout jPanel40Layout = new GroupLayout(this.jPanel40);
/* 2269 */     this.jPanel40.setLayout(jPanel40Layout);
/* 2270 */     jPanel40Layout.setHorizontalGroup(jPanel40Layout
/* 2271 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2272 */         .addGroup(jPanel40Layout.createSequentialGroup()
/* 2273 */           .addContainerGap()
/* 2274 */           .addComponent(this.jPanel41, -1, 358, 32767)
/* 2275 */           .addContainerGap()));
/*      */     
/* 2277 */     jPanel40Layout.setVerticalGroup(jPanel40Layout
/* 2278 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2279 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
/* 2280 */           .addContainerGap(60, 32767)
/* 2281 */           .addComponent(this.jPanel41, -2, -1, -2)
/* 2282 */           .addGap(16, 16, 16)));
/*      */ 
/*      */     
/* 2285 */     this.jPanel38.add(this.jPanel40);
/* 2286 */     this.jPanel40.setBounds(0, 60, 370, 120);
/*      */     
/* 2288 */     this.jPanel42.setBackground(new Color(177, 189, 188));
/* 2289 */     this.jPanel42.setLayout(new GridLayout(1, 0));
/*      */     
/* 2291 */     this.jPanel43.setBackground(Color.white);
/*      */     
/* 2293 */     this.jLabel151.setBackground(new Color(255, 0, 0));
/* 2294 */     this.jLabel151.setText("<html><b><center>CAPACITACIÓN ACREDITADA ANTE LA SECRETARÍA DEL TRABAJO Y PREVISIÓN SOCIAL CON EL NÚMERO DE REGISTRO:</center><b></html>");
/*      */     
/* 2296 */     this.jLabel147.setFont(new Font("Ubuntu Semi-Light", 1, 13));
/* 2297 */     this.jLabel147.setHorizontalAlignment(0);
/* 2298 */     this.jLabel147.setText("jLabel147");
/*      */     
/* 2300 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 2301 */     this.jPanel43.setLayout(jPanel43Layout);
/* 2302 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 2303 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2304 */         .addComponent(this.jLabel147, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2305 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 2306 */           .addComponent(this.jLabel151, -2, 248, -2)
/* 2307 */           .addGap(0, 0, 32767)));
/*      */     
/* 2309 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 2310 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2311 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 2312 */           .addComponent(this.jLabel151, -2, 103, -2)
/* 2313 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2314 */           .addComponent(this.jLabel147)
/* 2315 */           .addGap(0, 21, 32767)));
/*      */ 
/*      */     
/* 2318 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/* 2319 */     this.jPanel35.setLayout(jPanel35Layout);
/* 2320 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/* 2321 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2322 */         .addGroup(jPanel35Layout.createSequentialGroup()
/* 2323 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2324 */             .addGroup(jPanel35Layout.createSequentialGroup()
/* 2325 */               .addComponent(this.jPanel42, -2, 114, -2)
/* 2326 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2327 */               .addComponent(this.jPanel43, -1, -1, 32767))
/* 2328 */             .addGroup(jPanel35Layout.createSequentialGroup()
/* 2329 */               .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2330 */                 .addComponent(this.jPanel38, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2331 */                 .addComponent(this.jLabel145, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2332 */                 .addComponent(this.jPanel37, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2333 */                 .addComponent(this.jPanel36, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2334 */               .addGap(0, 0, 32767)))
/* 2335 */           .addGap(11, 11, 11)));
/*      */     
/* 2337 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/* 2338 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2339 */         .addGroup(jPanel35Layout.createSequentialGroup()
/* 2340 */           .addComponent(this.jPanel36, -2, -1, -2)
/* 2341 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2342 */           .addComponent(this.jPanel37, -2, -1, -2)
/* 2343 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2344 */           .addComponent(this.jLabel145)
/* 2345 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2346 */           .addComponent(this.jPanel38, -2, 178, -2)
/* 2347 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2348 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2349 */             .addComponent(this.jPanel43, -1, -1, 32767)
/* 2350 */             .addComponent(this.jPanel42, -1, -1, 32767))
/* 2351 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2354 */     this.jPanel33.add(this.jPanel35);
/*      */     
/* 2356 */     this.jPanel32.setBackground(new Color(146, 193, 134));
/*      */     
/* 2358 */     this.jButton10.setText("Cancelar");
/* 2359 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2361 */             OperadoresBuscar.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2365 */     this.jButton11.setText("Imprimir");
/* 2366 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2368 */             OperadoresBuscar.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2372 */     this.jButton15.setText("< Regresar");
/* 2373 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2375 */             OperadoresBuscar.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2379 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/* 2380 */     this.jPanel32.setLayout(jPanel32Layout);
/* 2381 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/* 2382 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2383 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 2384 */           .addContainerGap(-1, 32767)
/* 2385 */           .addComponent(this.jButton15, -2, 102, -2)
/* 2386 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2387 */           .addComponent(this.jButton11, -2, 102, -2)
/* 2388 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2389 */           .addComponent(this.jButton10, -2, 102, -2)
/* 2390 */           .addContainerGap()));
/*      */     
/* 2392 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/* 2393 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2394 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 2395 */           .addGap(0, 0, 32767)
/* 2396 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2397 */             .addComponent(this.jButton10)
/* 2398 */             .addComponent(this.jButton11)
/* 2399 */             .addComponent(this.jButton15))));
/*      */ 
/*      */     
/* 2402 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 2403 */     this.jPanel13.setLayout(jPanel13Layout);
/* 2404 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 2405 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2406 */         .addComponent(this.jPanel32, -1, -1, 32767)
/* 2407 */         .addComponent(this.jPanel33, -2, 763, 32767));
/*      */     
/* 2409 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 2410 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2411 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 2412 */           .addComponent(this.jPanel33, -1, -1, 32767)
/* 2413 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2414 */           .addComponent(this.jPanel32, -1, -1, 32767)
/* 2415 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2418 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 2419 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 2420 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 2421 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2422 */         .addComponent(this.jPanel13, -1, -1, 32767));
/*      */     
/* 2424 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 2425 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2426 */         .addComponent(this.jPanel13, -1, -1, 32767));
/*      */ 
/*      */     
/* 2429 */     this.jDialog10.setTitle("Lista de cumpleaños");
/* 2430 */     this.jDialog10.setModal(true);
/*      */     
/* 2432 */     this.materialButton42.setBackground(this.lc.SECUNDARIO1);
/* 2433 */     this.materialButton42.setForeground(new Color(255, 255, 255));
/* 2434 */     this.materialButton42.setMnemonic('C');
/* 2435 */     this.materialButton42.setText("Cerrar");
/* 2436 */     this.materialButton42.setToolTipText("Cerrar (Alt+C)");
/* 2437 */     this.materialButton42.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/* 2438 */     this.materialButton42.setHorizontalTextPosition(0);
/* 2439 */     this.materialButton42.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2441 */             OperadoresBuscar.this.materialButton42ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2445 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, , { null, null, null },  }, (Object[])new String[] { "Clave", "Nombre completo", "Fecha" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2454 */     this.rSTableMetro2.setAltoHead(25);
/* 2455 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2456 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 2457 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 2458 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2459 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 2460 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 2461 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 2462 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 2463 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2464 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2465 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 2466 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 2467 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 2468 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 2469 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2471 */             OperadoresBuscar.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 2474 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2476 */             OperadoresBuscar.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 2479 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/*      */     
/* 2481 */     this.jPanel64.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2483 */     this.jLabel152.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*      */     
/* 2485 */     this.jLabel152.setForeground(this.lc.SECUNDARIO1);
/* 2486 */     this.jLabel152.setHorizontalAlignment(4);
/* 2487 */     this.jLabel152.setText("Total ");
/* 2488 */     this.jPanel64.add(this.jLabel152);
/*      */     
/* 2490 */     this.jLabel153.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*      */     
/* 2492 */     this.jLabel153.setForeground(this.lc.PRIMARIO1);
/* 2493 */     this.jLabel153.setHorizontalAlignment(0);
/* 2494 */     this.jLabel153.setText("t");
/* 2495 */     this.jPanel64.add(this.jLabel153);
/*      */     
/* 2497 */     GroupLayout jDialog10Layout = new GroupLayout(this.jDialog10.getContentPane());
/* 2498 */     this.jDialog10.getContentPane().setLayout(jDialog10Layout);
/* 2499 */     jDialog10Layout.setHorizontalGroup(jDialog10Layout
/* 2500 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2501 */         .addGroup(jDialog10Layout.createSequentialGroup()
/* 2502 */           .addContainerGap()
/* 2503 */           .addGroup(jDialog10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2504 */             .addGroup(GroupLayout.Alignment.TRAILING, jDialog10Layout.createSequentialGroup()
/* 2505 */               .addComponent(this.jPanel64, -2, 132, -2)
/* 2506 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2507 */               .addComponent((Component)this.materialButton42, -2, 105, -2))
/* 2508 */             .addComponent(this.jScrollPane32, -1, 656, 32767))
/* 2509 */           .addContainerGap()));
/*      */     
/* 2511 */     jDialog10Layout.setVerticalGroup(jDialog10Layout
/* 2512 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2513 */         .addGroup(jDialog10Layout.createSequentialGroup()
/* 2514 */           .addContainerGap()
/* 2515 */           .addComponent(this.jScrollPane32, -1, 300, 32767)
/* 2516 */           .addGroup(jDialog10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2517 */             .addGroup(jDialog10Layout.createSequentialGroup()
/* 2518 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2519 */               .addComponent((Component)this.materialButton42, -2, 38, -2))
/* 2520 */             .addGroup(jDialog10Layout.createSequentialGroup()
/* 2521 */               .addGap(16, 16, 16)
/* 2522 */               .addComponent(this.jPanel64, -2, -1, -2)))
/* 2523 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2526 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 2527 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 2529 */     this.jLabel54.setFont(new Font("Tahoma", 1, 20));
/* 2530 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 2531 */     this.jLabel54.setHorizontalAlignment(0);
/* 2532 */     this.jLabel54.setText("Buscar Operadores");
/*      */     
/* 2534 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 2535 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2537 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 2538 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm.", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P.", "Ciudad", "Estado", "Sexo", "Teléfono 1", "Teléfono 2", "Correo", "Abogado" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2546 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2548 */             OperadoresBuscar.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 2551 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2553 */             OperadoresBuscar.this.jTable3KeyReleased(evt);
/*      */           }
/*      */         });
/* 2556 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 2557 */     if (this.jTable3.getColumnModel().getColumnCount() > 0) {
/* 2558 */       this.jTable3.getColumnModel().getColumn(0).setMinWidth(50);
/* 2559 */       this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 2560 */       this.jTable3.getColumnModel().getColumn(0).setMaxWidth(50);
/* 2561 */       this.jTable3.getColumnModel().getColumn(5).setMinWidth(60);
/* 2562 */       this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(60);
/* 2563 */       this.jTable3.getColumnModel().getColumn(5).setMaxWidth(60);
/* 2564 */       this.jTable3.getColumnModel().getColumn(7).setMinWidth(40);
/* 2565 */       this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(40);
/* 2566 */       this.jTable3.getColumnModel().getColumn(7).setMaxWidth(40);
/* 2567 */       this.jTable3.getColumnModel().getColumn(10).setMinWidth(60);
/* 2568 */       this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(60);
/* 2569 */       this.jTable3.getColumnModel().getColumn(10).setMaxWidth(60);
/* 2570 */       this.jTable3.getColumnModel().getColumn(14).setMinWidth(60);
/* 2571 */       this.jTable3.getColumnModel().getColumn(14).setPreferredWidth(60);
/* 2572 */       this.jTable3.getColumnModel().getColumn(14).setMaxWidth(60);
/*      */     } 
/*      */     
/* 2575 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 2576 */     this.jButton5.setMnemonic('G');
/* 2577 */     this.jButton5.setText("Guardar Reporte");
/* 2578 */     this.jButton5.setToolTipText("Guardar Reporte (Alt+G)");
/* 2579 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2581 */             OperadoresBuscar.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2585 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 2586 */     this.jButton1.setMnemonic('D');
/* 2587 */     this.jButton1.setText("Lista");
/* 2588 */     this.jButton1.setToolTipText("Imprimir Datos (Alt+D)");
/* 2589 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2591 */             OperadoresBuscar.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2595 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 2596 */     this.jButton2.setMnemonic('V');
/* 2597 */     this.jButton2.setText("Ver Detalle");
/* 2598 */     this.jButton2.setToolTipText("Ver a Detalle datos del Operador (Alt+V)");
/* 2599 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2601 */             OperadoresBuscar.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2605 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 2606 */     this.jLabel48.setForeground(Color.red);
/* 2607 */     this.jLabel48.setHorizontalAlignment(0);
/* 2608 */     this.jLabel48.setText("t");
/* 2609 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 2611 */     this.jButton3.setText("Actualizar Unidades");
/* 2612 */     this.jButton3.setToolTipText("Actualiza información de tractor y remolque");
/* 2613 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2615 */             OperadoresBuscar.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2619 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 2620 */     this.jButton4.setMnemonic('I');
/* 2621 */     this.jButton4.setText("Informe Completo");
/* 2622 */     this.jButton4.setToolTipText("Informe Completo (Alt+I)");
/* 2623 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2625 */             OperadoresBuscar.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2629 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 2630 */     this.jButton6.setMnemonic('G');
/* 2631 */     this.jButton6.setText("Gafetes");
/* 2632 */     this.jButton6.setToolTipText("Imprimir Gafetes (Alt+G)");
/* 2633 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2635 */             OperadoresBuscar.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2639 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Good-Shield.png")));
/* 2640 */     this.jButton9.setMnemonic('V');
/* 2641 */     this.jButton9.setText("Ver Firma");
/* 2642 */     this.jButton9.setToolTipText("Ver a Detalle datos del Operador (Alt+V)");
/* 2643 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2645 */             OperadoresBuscar.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2649 */     this.jButton19.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2650 */     this.jButton19.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 2651 */     this.jButton19.setText("Cumpleaños");
/* 2652 */     this.jButton19.setToolTipText("Imprimir lista de cumpleaños (Alt+C)");
/* 2653 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2655 */             OperadoresBuscar.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2659 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 2660 */     this.jPanel5.setLayout(jPanel5Layout);
/* 2661 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 2662 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2663 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2664 */           .addGap(10, 10, 10)
/* 2665 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 2666 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2667 */           .addComponent(this.jButton1, -2, 147, -2)
/* 2668 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2669 */           .addComponent(this.jButton2, -2, 120, -2)
/* 2670 */           .addGap(82, 82, 82)
/* 2671 */           .addComponent(this.jButton19, -2, 158, -2)
/* 2672 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2673 */           .addComponent(this.jButton4, -2, 163, -2)
/* 2674 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2675 */           .addComponent(this.jButton6, -2, 153, -2)
/* 2676 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2677 */           .addComponent(this.jButton9, -2, 120, -2)
/* 2678 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2679 */           .addComponent(this.jButton5, -2, 150, -2)
/* 2680 */           .addGap(67, 67, 67)
/* 2681 */           .addComponent(this.jButton3)
/* 2682 */           .addContainerGap(-1, 32767))
/* 2683 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2684 */           .addContainerGap()
/* 2685 */           .addComponent(this.jScrollPane3)));
/*      */     
/* 2687 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 2688 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2689 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2690 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2691 */             .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2692 */               .addComponent(this.jLabel48)
/* 2693 */               .addComponent(this.jButton1)
/* 2694 */               .addComponent(this.jButton4)
/* 2695 */               .addComponent(this.jButton2)
/* 2696 */               .addComponent(this.jButton6)
/* 2697 */               .addComponent(this.jButton3, -2, 28, -2)
/* 2698 */               .addComponent(this.jButton5)
/* 2699 */               .addComponent(this.jButton9))
/* 2700 */             .addComponent(this.jButton19, -1, -1, 32767))
/* 2701 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2702 */           .addComponent(this.jScrollPane3, -1, 153, 32767)));
/*      */ 
/*      */     
/* 2705 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 2706 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Operadores ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2708 */     this.jLabel14.setFont(new Font("Tahoma", 2, 11));
/* 2709 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/* 2710 */     this.jLabel14.setHorizontalAlignment(0);
/* 2711 */     this.jLabel14.setText("Nombre (s)");
/*      */     
/* 2713 */     this.jLabel32.setFont(new Font("Tahoma", 2, 11));
/* 2714 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/* 2715 */     this.jLabel32.setText("Apellido Paterno");
/*      */     
/* 2717 */     this.jLabel38.setFont(new Font("Tahoma", 2, 11));
/* 2718 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/* 2719 */     this.jLabel38.setHorizontalAlignment(0);
/* 2720 */     this.jLabel38.setText("Apellido Materno");
/*      */     
/* 2722 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2724 */             OperadoresBuscar.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2728 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2730 */             OperadoresBuscar.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2734 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2736 */             OperadoresBuscar.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2740 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2742 */             OperadoresBuscar.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2746 */     this.jLabel15.setFont(new Font("Tahoma", 2, 11));
/* 2747 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 2748 */     this.jLabel15.setHorizontalAlignment(0);
/* 2749 */     this.jLabel15.setText("Clave");
/*      */     
/* 2751 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 2752 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 2753 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "CUALQUIERA", "PIPA", "GÓNDOLA" }));
/* 2754 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2756 */             OperadoresBuscar.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2760 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/* 2761 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 2762 */     this.jLabel39.setHorizontalAlignment(0);
/* 2763 */     this.jLabel39.setText("Puesto");
/*      */     
/* 2765 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 2766 */     this.jComboBox2.setFont(new Font("Tahoma", 1, 11));
/* 2767 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Activos", "Eliminados", "Todos" }));
/* 2768 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2770 */             OperadoresBuscar.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2774 */     this.jLabel58.setFont(new Font("Tahoma", 2, 11));
/* 2775 */     this.jLabel58.setForeground(new Color(15, 87, 51));
/* 2776 */     this.jLabel58.setHorizontalAlignment(0);
/* 2777 */     this.jLabel58.setText("Datos");
/*      */     
/* 2779 */     this.jTextField5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2781 */             OperadoresBuscar.this.jTextField5KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2785 */     this.jLabel16.setFont(new Font("Tahoma", 2, 11));
/* 2786 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/* 2787 */     this.jLabel16.setHorizontalAlignment(0);
/* 2788 */     this.jLabel16.setText("Tracto");
/*      */     
/* 2790 */     this.jLabel17.setFont(new Font("Tahoma", 2, 11));
/* 2791 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/* 2792 */     this.jLabel17.setHorizontalAlignment(0);
/* 2793 */     this.jLabel17.setText("Remolque");
/*      */     
/* 2795 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2797 */             OperadoresBuscar.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2801 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 2802 */     this.jComboBox5.setFont(new Font("Tahoma", 1, 11));
/* 2803 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "OPERADOR", "FUNCIONARIO", "TODOS" }));
/* 2804 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2806 */             OperadoresBuscar.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2810 */     this.jLabel123.setFont(new Font("Tahoma", 2, 11));
/* 2811 */     this.jLabel123.setForeground(new Color(15, 87, 51));
/* 2812 */     this.jLabel123.setHorizontalAlignment(0);
/* 2813 */     this.jLabel123.setText("Tipo de Trabajador");
/*      */     
/* 2815 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 2816 */     this.jPanel17.setLayout(jPanel17Layout);
/* 2817 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 2818 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2819 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2820 */           .addGap(20, 20, 20)
/* 2821 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2822 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2823 */               .addComponent(this.jLabel15, -2, 49, -2)
/* 2824 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2825 */               .addComponent(this.jLabel14, -1, -1, 32767))
/* 2826 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2827 */               .addComponent(this.jTextField4, -2, 49, -2)
/* 2828 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2829 */               .addComponent(this.jTextField1, -2, 155, -2)))
/* 2830 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2831 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2832 */             .addComponent(this.jTextField2, -2, 151, -2)
/* 2833 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2834 */               .addGap(34, 34, 34)
/* 2835 */               .addComponent(this.jLabel32, -2, 90, -2)))
/* 2836 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2837 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2838 */             .addComponent(this.jTextField3, -2, 163, -2)
/* 2839 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2840 */               .addGap(43, 43, 43)
/* 2841 */               .addComponent(this.jLabel38)))
/* 2842 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2843 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2844 */             .addComponent(this.jLabel123, -1, -1, 32767)
/* 2845 */             .addComponent(this.jComboBox5, -2, 131, -2))
/* 2846 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2847 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2848 */             .addComponent(this.jLabel39, -1, -1, 32767)
/* 2849 */             .addComponent(this.jComboBox1, -2, 131, -2))
/* 2850 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2851 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2852 */             .addComponent(this.jLabel58, -1, -1, 32767)
/* 2853 */             .addComponent(this.jComboBox2, -2, 108, -2))
/* 2854 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2855 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2856 */             .addComponent(this.jLabel16, -2, 49, -2)
/* 2857 */             .addComponent(this.jTextField5, -2, 49, -2))
/* 2858 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2859 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2860 */             .addComponent(this.jLabel17, -2, 49, -2)
/* 2861 */             .addComponent(this.jTextField6, -2, 49, -2))
/* 2862 */           .addGap(2020, 2020, 2020)));
/*      */     
/* 2864 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 2865 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2866 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2867 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2868 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2869 */               .addComponent(this.jTextField3, -2, -1, -2)
/* 2870 */               .addGap(8, 8, 8)
/* 2871 */               .addComponent(this.jLabel38))
/* 2872 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2873 */               .addComponent(this.jTextField2, -2, -1, -2)
/* 2874 */               .addGap(8, 8, 8)
/* 2875 */               .addComponent(this.jLabel32))
/* 2876 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2877 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2878 */                 .addComponent(this.jTextField1, -2, -1, -2)
/* 2879 */                 .addComponent(this.jTextField4, -2, -1, -2))
/* 2880 */               .addGap(8, 8, 8)
/* 2881 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2882 */                 .addComponent(this.jLabel14)
/* 2883 */                 .addComponent(this.jLabel15)))
/* 2884 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2885 */               .addComponent(this.jComboBox5, -2, -1, -2)
/* 2886 */               .addGap(8, 8, 8)
/* 2887 */               .addComponent(this.jLabel123))
/* 2888 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2889 */               .addComponent(this.jComboBox1, -2, -1, -2)
/* 2890 */               .addGap(8, 8, 8)
/* 2891 */               .addComponent(this.jLabel39))
/* 2892 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2893 */               .addComponent(this.jComboBox2, -2, -1, -2)
/* 2894 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2895 */               .addComponent(this.jLabel58))
/* 2896 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2897 */               .addComponent(this.jTextField5, -2, -1, -2)
/* 2898 */               .addGap(8, 8, 8)
/* 2899 */               .addComponent(this.jLabel16))
/* 2900 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2901 */               .addComponent(this.jTextField6, -2, -1, -2)
/* 2902 */               .addGap(8, 8, 8)
/* 2903 */               .addComponent(this.jLabel17)))
/* 2904 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2907 */     this.jCheckBox1.setText("Activar el Visulizador de imágenes");
/* 2908 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2910 */             OperadoresBuscar.this.jCheckBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2914 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 2915 */     this.jPanel1.setLayout(jPanel1Layout);
/* 2916 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 2917 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2918 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 2919 */           .addContainerGap()
/* 2920 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2921 */             .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2922 */             .addComponent(this.jPanel17, -1, -1, 32767)
/* 2923 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
/* 2924 */               .addComponent(this.jCheckBox1, -2, 234, -2)
/* 2925 */               .addGap(67, 67, 67)
/* 2926 */               .addComponent(this.jLabel54, -2, 883, -2)))
/* 2927 */           .addContainerGap()));
/*      */     
/* 2929 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 2930 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2931 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 2932 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2933 */             .addComponent(this.jLabel54, -2, 22, -2)
/* 2934 */             .addComponent(this.jCheckBox1))
/* 2935 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2936 */           .addComponent(this.jPanel17, -2, 68, -2)
/* 2937 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2938 */           .addComponent(this.jPanel5, -1, -1, 32767)));
/*      */ 
/*      */     
/* 2941 */     GroupLayout layout = new GroupLayout(this);
/* 2942 */     setLayout(layout);
/* 2943 */     layout.setHorizontalGroup(layout
/* 2944 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2945 */         .addGap(0, 3255, 32767)
/* 2946 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2947 */           .addGroup(layout.createSequentialGroup()
/* 2948 */             .addContainerGap()
/* 2949 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 2950 */             .addContainerGap())));
/*      */     
/* 2952 */     layout.setVerticalGroup(layout
/* 2953 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2954 */         .addGap(0, 347, 32767)
/* 2955 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2956 */           .addGroup(layout.createSequentialGroup()
/* 2957 */             .addGap(15, 15, 15)
/* 2958 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 2959 */             .addGap(15, 15, 15))));
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 2963 */     String[] datos = { "CLAVE", "NOMBRE COMPLETO", "DIRECCIÓN", "TELÉFONO", "CELULAR", "NEXTEL", "CANT", "AUTOMATICO", "FECHA DE NACIMIENTO", "VENC. DE LICENCIA", "# LICENCIA", "TIPO", "NSS", "RFC", "CURP", "NÚM INFONAVIT", "CANT INFONAVIT", "AUTOM", "ESTADO CIVIL", "NÚM DE HIJOS", "CONTRATADOR POR", "TESTIGO 1", "TESTIGO 2", "RECOMENDADO POR", "SALARIO IMSS", "ESPECIALIZADO EN", "TRACTOR", "REM", "DISTINTIVO", "CONTRATADO(DÍAS)", "PRIMER INGRESO", "ÚLTIMO INGRESO", "ÚLTIMA ACTUALIZACIÓN", "RESPONSABLE", "LUGAR DE NAC", "OTROS DATOS", "COMENTARIOS", "TIPO" };
/* 2964 */     this.esc = new EscribirReporte("OPERADORES", this.jTable3, datos, this.USUARIO);
/*      */   }
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 2967 */     consultar();
/*      */   }
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 2970 */     consultar();
/*      */   }
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 2973 */     consultar();
/*      */   }
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 2976 */     consultar();
/*      */   }
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 2979 */     consultar();
/*      */   }
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 2982 */     consultar();
/*      */   }
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2985 */     ImprimirLista imp = new ImprimirLista();
/* 2986 */     imp.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jTextField5KeyReleased(KeyEvent evt) {
/* 2990 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 2994 */     consultar();
/*      */   }
/*      */   
/*      */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 2998 */     if (this.jCheckBox1.isSelected()) {
/* 2999 */       this.jLabel122.setVisible(false);
/* 3000 */       this.jDialog1.setVisible(true);
/* 3001 */       this.jLabel1.setIcon((Icon)null);
/*      */     } else {
/* 3003 */       this.jLabel1.setIcon((Icon)null);
/* 3004 */       this.jDialog1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 3009 */     if (evt.getClickCount() == 2) {
/* 3010 */       cargarOperador();
/* 3011 */       this.jDialog4.setVisible(true);
/*      */     } else {
/* 3013 */       this.jLabel122.setVisible(false);
/* 3014 */       this.jButton2.setEnabled(true);
/* 3015 */       verFotos();
/* 3016 */       privilegios();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable3KeyReleased(KeyEvent evt) {
/* 3021 */     this.jLabel122.setVisible(false);
/* 3022 */     verFotos();
/* 3023 */     privilegios();
/*      */   }
/*      */   
/*      */   private void jDialog1WindowClosing(WindowEvent evt) {
/* 3027 */     this.jCheckBox1.setSelected(false);
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 3031 */     cargarPerfil();
/*      */   }
/*      */   
/*      */   private void jLabel34MouseClicked(MouseEvent evt) {
/* 3035 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel60MouseEntered(MouseEvent evt) {
/* 3039 */     this.jLabel60.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel60MouseExited(MouseEvent evt) {
/* 3043 */     this.jLabel60.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel60MouseClicked(MouseEvent evt) {
/* 3047 */     this.jTextArea5.setText("");
/* 3048 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel37MouseEntered(MouseEvent evt) {
/* 3052 */     this.jLabel37.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel37MouseExited(MouseEvent evt) {
/* 3056 */     this.jLabel37.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel37MouseClicked(MouseEvent evt) {
/* 3060 */     int indice = this.jTable3.getSelectedRow();
/* 3061 */     String num = String.valueOf(this.jTable3.getValueAt(indice, 0));
/* 3062 */     String[] datos = { this.jTextField28.getText().toUpperCase(), num, this.jTextField7.getText(), this.jTextField8.getText(), this.jTextField9.getText(), this.jTextField10.getText(), this.jTextField11.getText(), this.jTextField12.getText(), this.jTextField13.getText(), this.jTextField14.getText(), this.jTextField15.getText(), this.jTextField16.getText(), this.jTextField17.getText(), this.jTextField18.getText(), this.jTextField19.getText(), this.jTextField20.getText(), this.jTextField21.getText(), this.jTextField22.getText(), this.jTextField23.getText(), this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField26.getText(), this.jTextField27.getText(), this.jTextArea1.getText(), this.FOTO };
/* 3063 */     this.indi = new ReporteIndividual("REPORTE INDIVIDUAL DE OPERADORES", datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jLabel34MouseEntered(MouseEvent evt) {
/* 3067 */     this.jLabel34.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel34MouseExited(MouseEvent evt) {
/* 3071 */     this.jLabel34.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 3075 */     if (this.jTextArea5.getText().equals("")) {
/* 3076 */       this.jTextArea5.setBackground(Color.red);
/* 3077 */       JOptionPane.showMessageDialog(this.jDialog3, "No puedes dejar el campo vacío, por favor completa tu información", "Campo Vacío", 0, this.ERROR);
/*      */     } else {
/* 3079 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas agregar un nuevo comentario a este operador?", "Grabar Comentario", 0, 3, this.PREG);
/* 3080 */       if (res == 0) {
/* 3081 */         String var = this.jTextArea1.getText();
/* 3082 */         String nuevo = this.jTextArea5.getText();
/* 3083 */         this.con.inserSinMsj("update operadores set comentarios = '" + var + "\n" + cargarFechaHoy() + nuevo + "' where num_ope = " + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)));
/* 3084 */         this.jTextArea1.setText(var + "\n" + var + cargarFechaHoy());
/* 3085 */         this.jDialog3.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 3091 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 3095 */     int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas actualizar la información de los operadores?", "Actualizar Información", 0, 3, this.PREG);
/* 3096 */     if (res == 0) {
/*      */       
/* 3098 */       for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 3099 */         String clave = String.valueOf(this.jTable3.getValueAt(i, 0));
/* 3100 */         this.encontrado = this.con.consultar("tracto.num_tracto", "guias,llamadas_historicas,operadores,REMOLQUE,tracto", "where llamadas_historicas.num_rem=remolque.num_rem and llamadas_historicas.num_tracto=tracto.num_tracto and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_ope = operadores.num_ope and operadores.num_ope = " + clave + " order by guias.num_guia ASC");
/*      */ 
/*      */         
/* 3103 */         if (this.encontrado) {
/* 3104 */           String[] datos = this.con.regresaReg("tracto.num_tracto,remolque.num_rem,guias.tipo", "guias,llamadas_historicas,operadores,REMOLQUE,tracto", "where llamadas_historicas.num_rem=remolque.num_rem and llamadas_historicas.num_tracto=tracto.num_tracto and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_ope = operadores.num_ope and operadores.num_ope = " + clave + " order by guias.num_guia ASC", 3);
/*      */ 
/*      */           
/* 3107 */           this.con.inserSinMsj("update operadores set num_tracto = " + datos[0] + ", num_rem = " + datos[1] + ", tipo = '" + datos[2] + "' where num_ope = " + clave);
/*      */         } 
/*      */       } 
/* 3110 */       consultar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 3115 */     int ind = this.jTable3.getSelectedRow();
/* 3116 */     if (ind >= 0) {
/* 3117 */       ImprimirDatos imp = new ImprimirDatos();
/* 3118 */       imp.recibeDatos();
/*      */     } else {
/* 3120 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para poder observar los datos", "Selecciona un registro", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 3125 */     int ind = this.jTable3.getSelectedRow();
/* 3126 */     if (ind >= 0) {
/* 3127 */       this.jDialog5.setVisible(true);
/*      */     } else {
/* 3129 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para poder observar los datos", "Selecciona un registro", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel51MouseClicked(MouseEvent evt) {
/* 3134 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel51MouseEntered(MouseEvent evt) {
/* 3138 */     this.jLabel51.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel51MouseExited(MouseEvent evt) {
/* 3142 */     this.jLabel51.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel52MouseClicked(MouseEvent evt) {
/* 3146 */     ImprimirDatos imp = new ImprimirDatos();
/* 3147 */     imp.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jLabel52MouseEntered(MouseEvent evt) {
/* 3151 */     this.jLabel52.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel52MouseExited(MouseEvent evt) {
/* 3155 */     this.jLabel52.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 3159 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 3163 */     this.jDialog5.setVisible(false);
/* 3164 */     int ind = this.jTable3.getSelectedRow();
/* 3165 */     this.jDateChooser5.setDate(new Date());
/* 3166 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3167 */     String cadenaFecha1 = formato.format(this.jDateChooser5.getDate());
/* 3168 */     String año = cadenaFecha1.substring(0, 4);
/* 3169 */     if (this.jRadioButton1.isSelected()) {
/* 3170 */       String clave = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 3171 */       String nombre = String.valueOf(this.jTable3.getValueAt(ind, 1));
/* 3172 */       String licen = String.valueOf(this.jTable3.getValueAt(ind, 10));
/* 3173 */       String tipo = String.valueOf(this.jTable3.getValueAt(ind, 11));
/* 3174 */       String nss = String.valueOf(this.jTable3.getValueAt(ind, 12));
/* 3175 */       String curp = String.valueOf(this.jTable3.getValueAt(ind, 14));
/* 3176 */       this.jLabel82.setText(nombre);
/* 3177 */       this.jLabel83.setText("<html><b>Licencia: </b>" + licen + "</html>");
/* 3178 */       this.jLabel84.setText("<html><b>Tipo: </b>" + tipo + "</html>");
/* 3179 */       this.jLabel85.setText("<html><b>NSS: </b>" + nss + "</html>");
/* 3180 */       this.jLabel89.setText("<html><b>CURP: </b>" + curp + "</html>");
/* 3181 */       this.jLabel102.setText(nombre);
/* 3182 */       this.jLabel81.setText("Operador de Quinta Rueda");
/* 3183 */       this.VIGENCIA = "DICIEMBRE " + año;
/* 3184 */       this.jLabel86.setText("<html><b>Vigencia: </b>DICIEMBRE " + año + "</html>");
/* 3185 */       String claveOp = sacarClave(clave);
/* 3186 */       this.jLabel80.setText("OP-" + claveOp);
/* 3187 */       this.CLAVEOP = (String)this.CAMPOSGENERALES.get("directiva") + "-OP-" + (String)this.CAMPOSGENERALES.get("directiva");
/* 3188 */       verFotos2();
/*      */ 
/*      */       
/* 3191 */       this.jDialog5.setVisible(false);
/* 3192 */       Gafete2020 gafete2020 = new Gafete2020(this.padre, true, this.CAMPOSGENERALES, new String[] { String.valueOf(this.jTable3.getValueAt(ind, 0)), this.CLAVEOP, nombre, this.VIGENCIA, nss, curp, "OPERADOR DE QUINTA RUEDA" });
/*      */     } else {
/*      */       
/* 3195 */       this.jLabel73.setText("<html><center>FOLIO: <b>" + this.DIRECTIVA[1] + "-OP" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)) + "-" + año + "</b></center></html>");
/* 3196 */       this.jLabel145.setText("<html><center>FOLIO: <b>" + this.DIRECTIVA[1] + "-OP" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)) + "-" + año + "</b></center></html>");
/* 3197 */       this.jLabel76.setText(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1).toString());
/* 3198 */       this.jSpinner1.setValue(Integer.valueOf(8));
/* 3199 */       String mes = cadenaFecha1.substring(4, 6);
/* 3200 */       String dia = cadenaFecha1.substring(6, 8);
/* 3201 */       String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */       
/* 3203 */       int aa = Integer.parseInt(año);
/* 3204 */       aa++;
/* 3205 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3206 */       String strFecha = "" + aa + "-" + aa + "-01";
/* 3207 */       Date fecha = null;
/*      */       try {
/* 3209 */         fecha = formatoDelTexto.parse(strFecha);
/* 3210 */       } catch (ParseException ex) {
/* 3211 */         ex.printStackTrace();
/*      */       } 
/* 3213 */       this.jDateChooser1.setDate(fecha);
/*      */       
/* 3215 */       this.jLabel143.setText(fechaCompleta);
/* 3216 */       this.jTextField29.setText("OPERADOR");
/* 3217 */       this.jLabel149.setText(this.DIRECTIVA[3]);
/* 3218 */       this.jLabel147.setText(this.DIRECTIVA[2]);
/* 3219 */       verFotos2();
/* 3220 */       this.jDialog9.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 3225 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 3228 */     this.jDialog7.setVisible(false);
/* 3229 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 3233 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 3237 */     this.jDialog6.setVisible(false);
/* 3238 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel86MouseClicked(MouseEvent evt) {
/* 3242 */     this.jDateChooser5.setDate(new Date());
/* 3243 */     int res = JOptionPane.showConfirmDialog(this.jDialog6, this.jPanel20, "Coloca la vigencia de la credencial", 0, 3, this.PREG);
/* 3244 */     if (res == 0) {
/* 3245 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3246 */       String cadenaFecha1 = formato.format(this.jDateChooser5.getDate());
/* 3247 */       String año = cadenaFecha1.substring(0, 4);
/* 3248 */       String mes = cadenaFecha1.substring(4, 6);
/* 3249 */       String dia = cadenaFecha1.substring(6, 8);
/* 3250 */       String mm = dameMes(mes);
/* 3251 */       this.jLabel86.setText("<html><b>Vigencia: </b>" + mm + " " + año + "</html>");
/* 3252 */       this.VIGENCIA = mm + " " + mm;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel86MouseEntered(MouseEvent evt) {
/* 3257 */     this.jLabel86.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel86MouseExited(MouseEvent evt) {
/* 3261 */     this.jLabel86.setForeground(Color.BLACK);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel117MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel117MouseExited(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel136MouseEntered(MouseEvent evt) {
/* 3273 */     this.jLabel136.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel136MouseExited(MouseEvent evt) {
/* 3277 */     this.jLabel136.setForeground(new Color(0, 51, 153));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel117MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel136MouseClicked(MouseEvent evt) {
/* 3289 */     this.jDateChooser5.setDate(new Date());
/* 3290 */     int res = JOptionPane.showConfirmDialog(this.jDialog6, this.jPanel20, "Coloca la vigencia de la credencial", 0, 3, this.PREG);
/* 3291 */     if (res == 0) {
/* 3292 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3293 */       String cadenaFecha1 = formato.format(this.jDateChooser5.getDate());
/* 3294 */       String año = cadenaFecha1.substring(0, 4);
/* 3295 */       String mes = cadenaFecha1.substring(4, 6);
/* 3296 */       String dia = cadenaFecha1.substring(6, 8);
/* 3297 */       String mm = dameMes(mes);
/* 3298 */       this.jLabel136.setText(mm + " " + mm);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 3303 */     ImprimirCredencial imp = new ImprimirCredencial();
/* 3304 */     imp.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 3308 */     ImprimirRigPass rig = new ImprimirRigPass();
/* 3309 */     rig.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 3313 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 3317 */     if (this.jTable3.getSelectedRow() < 0) {
/* 3318 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un operador para que se visualice la firma", "Selecciona un operador", 0, this.ERROR);
/*      */     } else {
/* 3320 */       verFirmas();
/* 3321 */       this.jDialog8.setTitle("Firma de: " + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)));
/* 3322 */       this.jDialog8.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 3327 */     this.jDialog9.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 3331 */     this.jDialog9.setVisible(false);
/* 3332 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 3336 */     Date fecha = this.jDateChooser1.getDate();
/* 3337 */     if (fecha == null) {
/* 3338 */       JOptionPane.showMessageDialog(this, "Ingresa la fecha de la vigencia", "Falta la fecha de vigencia", 0, this.ERROR);
/* 3339 */     } else if (this.jTextField29.getText().equals("")) {
/* 3340 */       this.jTextField29.setBackground(Color.RED);
/* 3341 */       JOptionPane.showMessageDialog(this.jDialog9, "Falta ingresar la categoría de la persona, no la puedes dejar vacía", "Falta la categoria", 0, this.ERROR);
/*      */     } else {
/* 3343 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3344 */       String cadenaFecha1 = formato.format(new Date());
/*      */       try {
/* 3346 */         String foto = this.DIRECTIVA[0] + "/" + this.DIRECTIVA[0] + ".png";
/* 3347 */         String año = cadenaFecha1.substring(0, 4);
/* 3348 */         String mes = cadenaFecha1.substring(4, 6);
/* 3349 */         String dia = cadenaFecha1.substring(6, 8);
/* 3350 */         String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */         
/* 3352 */         Date fecha1 = this.jDateChooser1.getDate();
/* 3353 */         formato = new SimpleDateFormat("yyyyMMdd");
/* 3354 */         String cadenaFecha = "";
/* 3355 */         cadenaFecha = formato.format(fecha1);
/* 3356 */         String AÑO = cadenaFecha.substring(0, 4);
/* 3357 */         String MES = cadenaFecha.substring(4, 6);
/* 3358 */         String DIA = cadenaFecha.substring(6, 8);
/* 3359 */         String fechaCompleta1 = dameMes(MES).toUpperCase() + " " + dameMes(MES).toUpperCase();
/* 3360 */         Map<Object, Object> datos = new HashMap<>();
/*      */         
/* 3362 */         datos.put("folio", this.DIRECTIVA[1] + "-OP" + this.DIRECTIVA[1] + "-" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)));
/* 3363 */         datos.put("nombre", this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/* 3364 */         datos.put("vigencia", fechaCompleta1);
/* 3365 */         datos.put("fecha", fechaCompleta);
/* 3366 */         datos.put("capacitador", this.DIRECTIVA[3]);
/* 3367 */         datos.put("registro", this.DIRECTIVA[2]);
/*      */         
/* 3369 */         datos.put("foto", foto);
/* 3370 */         datos.put("categoria", this.jTextField29.getText().toUpperCase());
/* 3371 */         datos.put("horas", String.valueOf(this.jSpinner1.getValue()) + " HRS.");
/* 3372 */         JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/qhse/curso_basico.jasper"), datos, (JRDataSource)new JREmptyDataSource());
/* 3373 */         JasperViewer visor = new JasperViewer(print, false);
/* 3374 */         visor.setTitle("Gafete " + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)));
/* 3375 */         visor.setIconImage(this.iconoImprimir);
/* 3376 */         this.jDialog9.setVisible(false);
/* 3377 */         visor.setVisible(true);
/*      */       }
/* 3379 */       catch (JRException e) {
/* 3380 */         System.out.println(e.getMessage());
/* 3381 */         Logger.getLogger(Cotizaciones.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/* 3382 */         JOptionPane.showMessageDialog(this, "No se ha podido cargar la foto del empleado correctamente, verifica que tenga el formato adecuado", "No se puede cargar la foto", 0, this.ADVER);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 3392 */     Map<String, String> FECHANAC = new TreeMap<>();
/* 3393 */     Map<String, String> ordenado = new LinkedHashMap<>();
/* 3394 */     Map<String, String> nombres = new TreeMap<>();
/* 3395 */     Map<String, String> departamentos = new TreeMap<>();
/*      */     
/* 3397 */     for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 3398 */       String clave = this.jTable3.getValueAt(i, 0).toString();
/* 3399 */       String nombre = this.jTable3.getValueAt(i, 1).toString();
/* 3400 */       String depa = "OEPRADOR";
/* 3401 */       String f = this.jTable3.getValueAt(i, 8).toString();
/* 3402 */       String mes = f.substring(5, 7);
/* 3403 */       String dia = f.substring(8, 10);
/* 3404 */       String fecha = mes + "/" + mes;
/* 3405 */       FECHANAC.put(clave, fecha);
/* 3406 */       nombres.put(clave, nombre);
/* 3407 */       departamentos.put(clave, depa);
/*      */     } 
/* 3409 */     FECHANAC.entrySet()
/* 3410 */       .stream()
/* 3411 */       .sorted(Map.Entry.comparingByValue()).forEach(k -> ordenado.put((String)k.getKey(), (String)k.getValue()));
/*      */     
/* 3413 */     String[] mesNum = (String[])ordenado.values().toArray((Object[])new String[0]);
/* 3414 */     ordenado.forEach((k, v) -> {
/*      */           String mes = v.substring(0, 2);
/*      */           String mesLetra = "";
/*      */           switch (mes) {
/*      */             case "01":
/*      */               mesLetra = "ENERO";
/*      */               break;
/*      */             
/*      */             case "02":
/*      */               mesLetra = "FEBRERO";
/*      */               break;
/*      */             case "03":
/*      */               mesLetra = "MARZO";
/*      */               break;
/*      */             case "04":
/*      */               mesLetra = "ABRIL";
/*      */               break;
/*      */             case "05":
/*      */               mesLetra = "MAYO";
/*      */               break;
/*      */             case "06":
/*      */               mesLetra = "JUNIO";
/*      */               break;
/*      */             case "07":
/*      */               mesLetra = "JULIO";
/*      */               break;
/*      */             case "08":
/*      */               mesLetra = "AGOSTO";
/*      */               break;
/*      */             case "09":
/*      */               mesLetra = "SEPTIEMBRE";
/*      */               break;
/*      */             case "10":
/*      */               mesLetra = "OCTUBRE";
/*      */               break;
/*      */             case "11":
/*      */               mesLetra = "NOVIEMBRE";
/*      */               break;
/*      */             case "12":
/*      */               mesLetra = "DICIEMBRE";
/*      */               break;
/*      */           } 
/*      */           ordenado.put(k, mesLetra + "/" + mesLetra);
/*      */         });
/* 3458 */     String[] key = (String[])ordenado.keySet().toArray((Object[])new String[0]);
/* 3459 */     String[] value = (String[])ordenado.values().toArray((Object[])new String[0]);
/* 3460 */     Object[][] datos = new Object[this.jTable3.getRowCount()][4];
/* 3461 */     for (int j = 0; j < datos.length; j++) {
/* 3462 */       datos[j][0] = key[j];
/* 3463 */       datos[j][1] = nombres.get(key[j]);
/* 3464 */       datos[j][2] = value[j];
/* 3465 */       datos[j][3] = departamentos.get(key[j]);
/*      */     } 
/*      */     
/* 3468 */     this.jLabel58.setText("" + ordenado.size());
/* 3469 */     Object[] titulos = { "Clave", "Nombre", "Cumpleaños", "Departamento" };
/* 3470 */     this.rSTableMetro2.setModel(new DefaultTableModel(datos, titulos));
/*      */ 
/*      */ 
/*      */     
/* 3474 */     this.rSTableMetro2.setAltoHead(25);
/* 3475 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3476 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/* 3477 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 3478 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 3479 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 3480 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 3481 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 3482 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 3483 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 3484 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3485 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 3486 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 3487 */     this.rSTableMetro2.setShowHorizontalLines(false);
/* 3488 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 3489 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 3490 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 3491 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3493 */             OperadoresBuscar.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 3496 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3498 */             OperadoresBuscar.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 3501 */     this.jScrollPane32.setViewportView((Component)this.rSTableMetro2);
/* 3502 */     DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/* 3503 */     LocalDate fechaHoy = LocalDate.now();
/* 3504 */     fechaHoy.format(formatoFecha);
/* 3505 */     int mesHoy = fechaHoy.getMonthValue();
/* 3506 */     int diaHoy = fechaHoy.getDayOfMonth();
/* 3507 */     int pintar = 0;
/* 3508 */     for (int k = 0; k < mesNum.length; k++) {
/* 3509 */       String m = mesNum[k].substring(0, 2);
/* 3510 */       String d = mesNum[k].substring(3, 5);
/* 3511 */       if (mesHoy <= Integer.parseInt(m) && diaHoy <= Integer.parseInt(d)) {
/* 3512 */         pintar = k;
/*      */         break;
/*      */       } 
/*      */     } 
/* 3516 */     this.celda2.setPintar(pintar);
/* 3517 */     this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 3518 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(60);
/* 3519 */     this.rSTableMetro2.getColumnModel().getColumn(2).setPreferredWidth(100);
/* 3520 */     this.rSTableMetro2.getColumnModel().getColumn(2).setMaxWidth(100);
/* 3521 */     this.rSTableMetro2.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 3522 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3523 */     this.rSTableMetro2.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3524 */     this.rSTableMetro2.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3525 */     this.jDialog10.setVisible(true);
/*      */   }
/*      */   
/*      */   private void materialButton42ActionPerformed(ActionEvent evt) {
/* 3529 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   public void verFirmas() {
/* 3541 */     int ind = this.jTable3.getSelectedRow();
/* 3542 */     String nombre = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 3543 */     String ap = String.valueOf(this.jTable3.getValueAt(ind, 1));
/* 3544 */     String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/*      */     
/* 3546 */     this.jLabel69.setText("Cargando...");
/* 3547 */     this.jLabel69.setIcon((Icon)null);
/* 3548 */     this.fotoF = new fotoFirmas(num);
/*      */   }
/*      */   
/*      */   public String sacarClave(String clave) {
/* 3552 */     String mayor = clave;
/* 3553 */     int MAYOR = Integer.parseInt(mayor);
/* 3554 */     String clave1 = "";
/* 3555 */     if (MAYOR < 10) {
/* 3556 */       clave1 = "0000" + MAYOR;
/* 3557 */     } else if (MAYOR < 100) {
/* 3558 */       clave1 = "000" + MAYOR;
/* 3559 */     } else if (MAYOR < 1000) {
/* 3560 */       clave1 = "00" + MAYOR;
/* 3561 */     } else if (MAYOR < 10000) {
/* 3562 */       clave1 = "0" + MAYOR;
/*      */     } else {
/* 3564 */       clave1 = "OP-" + MAYOR;
/*      */     } 
/* 3566 */     return clave1;
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 3570 */     this.con.consultar("priv", "usuarios", "where nombre_usu ='" + this.USUARIO + "'");
/* 3571 */     if (this.con.Campo.equals("ADMINISTRADOR") || this.con.Campo.equals("SUPER USUARIO") || this.con.Campo.equals("RECURSOS HUMANOS") || this.con.Campo.equals("CAPTURISTA") || this.USUARIO.equals("CESAR01")) {
/* 3572 */       this.jButton4.setEnabled(true);
/* 3573 */       this.jButton1.setEnabled(true);
/* 3574 */       this.jButton6.setEnabled(true);
/* 3575 */       this.jButton3.setEnabled(true);
/*      */     } else {
/* 3577 */       this.jButton1.setEnabled(false);
/* 3578 */       this.jButton4.setEnabled(false);
/* 3579 */       this.jButton6.setEnabled(false);
/* 3580 */       this.jButton3.setEnabled(false);
/*      */     } 
/* 3582 */     if (this.con.Campo.equals("SUPER USUARIO") || this.con.Campo.equals("LIQUIDACIONES") || this.con.Campo.equals("RECURSOS HUMANOS")) {
/* 3583 */       this.jButton9.setEnabled(true);
/*      */     } else {
/* 3585 */       this.jButton9.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public int alinearDer(int x, int letras) {
/* 3590 */     int quitar = 4 * letras;
/* 3591 */     x -= quitar;
/* 3592 */     return x;
/*      */   }
/*      */   
/*      */   public void verFotos2() {
/* 3596 */     int ind = this.jTable3.getSelectedRow();
/* 3597 */     String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 3598 */     this.jLabel67.setText("Cargando...");
/* 3599 */     this.jLabel115.setText("Cargando...");
/* 3600 */     this.jLabel77.setText("Cargando...");
/* 3601 */     this.jLabel67.setIcon((Icon)null);
/* 3602 */     this.jLabel115.setIcon((Icon)null);
/* 3603 */     this.jLabel77.setIcon((Icon)null);
/* 3604 */     this.fotoC = new fotoCredencial(num);
/*      */   }
/*      */   
/*      */   public void verFotos() {
/* 3608 */     int ind = this.jTable3.getSelectedRow();
/* 3609 */     String nombre = String.valueOf(this.jTable3.getValueAt(ind, 0));
/* 3610 */     String ap = String.valueOf(this.jTable3.getValueAt(ind, 1));
/* 3611 */     this.jButton5.setEnabled(true);
/*      */     
/* 3613 */     String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 3614 */     if (this.jCheckBox1.isSelected()) {
/* 3615 */       this.jLabel1.setText("Cargando...");
/* 3616 */       this.jLabel1.setIcon((Icon)null);
/* 3617 */       this.ind = new fotoIndividual(num);
/*      */     } else {
/* 3619 */       this.jDialog1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public String dameValor(int reg, int col) {
/* 3624 */     String valor = String.valueOf(this.jTable3.getValueAt(reg, col));
/* 3625 */     return valor;
/*      */   }
/*      */   
/*      */   public void cargarOperador() {
/* 3629 */     this.jTextPane1.setEditable(false);
/* 3630 */     this.jTextPane1.setText("");
/* 3631 */     int ind = this.jTable3.getSelectedRow();
/* 3632 */     this.jDialog4.setTitle("Operador - " + dameValor(ind, 1));
/* 3633 */     this.jLabel18.setText("OP-" + dameValor(ind, 0));
/* 3634 */     this.jLabel20.setText(dameValor(ind, 30));
/* 3635 */     this.con.consultar("actual", "operadores", "where num_ope=" + dameValor(ind, 0));
/* 3636 */     if (this.con.Campo.equals("0")) {
/* 3637 */       this.jLabel101.setText("ACTIVO");
/*      */     } else {
/* 3639 */       this.jLabel101.setText("BAJA");
/*      */     } 
/* 3641 */     SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 3642 */     StyleConstants.setBold(attrs, true);
/*      */     try {
/* 3644 */       for (int i = 0; i < this.jTable3.getColumnCount(); i++) {
/* 3645 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), this.jTable3.getColumnName(i) + ": ", attrs);
/* 3646 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), " " + dameValor(ind, i) + "\n", null);
/*      */       } 
/* 3648 */     } catch (BadLocationException ex) {
/* 3649 */       Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void cargarPerfil() {
/* 3654 */     setCursor(Cursor.getPredefinedCursor(3));
/* 3655 */     int indice = this.jTable3.getSelectedRow();
/* 3656 */     String num = String.valueOf(this.jTable3.getValueAt(indice, 0));
/* 3657 */     String[] campos = this.con.regresaReg("nombre,ap_pat,ap_mat,calle,num,col,cp,ciudad,tel_casa,celular,fecha_nac,fecha_licen,tipo_licen,num_licen,nss,ingreso,infonavitLetra,numInfo,num_rem,actual,comentarios,tipo,comentarios,rfc,num_tracto", "operadores", "where num_ope = " + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)), 25);
/* 3658 */     this.jLabel4.setText(String.valueOf(this.jTable3.getValueAt(indice, 1)));
/* 3659 */     this.jDialog2.setTitle(String.valueOf(this.jTable3.getValueAt(indice, 1)));
/*      */     
/* 3661 */     this.jLabel3.setIcon((Icon)null);
/* 3662 */     this.jLabel3.setText("Cargando...");
/* 3663 */     this.cargar = new cargarFoto(num);
/*      */     
/* 3665 */     this.jTextField7.setText(campos[0]);
/* 3666 */     this.jTextField8.setText(campos[1] + " " + campos[1]);
/* 3667 */     if (campos[3].equals("")) {
/* 3668 */       this.jTextField9.setText("No Disponible");
/*      */     } else {
/* 3670 */       this.jTextField9.setText(campos[3]);
/*      */     } 
/* 3672 */     if (campos[3].equals("")) {
/* 3673 */       this.jTextField10.setText("No Disponible");
/*      */     } else {
/* 3675 */       this.jTextField10.setText(campos[4]);
/*      */     } 
/* 3677 */     if (campos[3].equals("")) {
/* 3678 */       this.jTextField11.setText("No Disponible");
/*      */     } else {
/* 3680 */       this.jTextField11.setText(campos[5]);
/*      */     } 
/* 3682 */     this.jTextField12.setText(campos[6]);
/* 3683 */     if (campos[7].equals("")) {
/* 3684 */       this.jTextField13.setText("No Disponible");
/*      */     } else {
/* 3686 */       this.jTextField13.setText(campos[7]);
/*      */     } 
/*      */     
/* 3689 */     if (campos[8].equals("")) {
/* 3690 */       this.jTextField14.setText("No Disponible");
/*      */     } else {
/* 3692 */       this.jTextField14.setText(campos[8]);
/*      */     } 
/* 3694 */     if (campos[9].equals("")) {
/* 3695 */       this.jTextField15.setText("No Disponible");
/*      */     } else {
/* 3697 */       this.jTextField15.setText(campos[9]);
/*      */     } 
/* 3699 */     if (campos[10] != null) {
/* 3700 */       String str1 = campos[10].substring(0, 4);
/* 3701 */       String str2 = campos[10].substring(5, 7);
/* 3702 */       String str3 = campos[10].substring(8, 10);
/* 3703 */       String str4 = str3 + "/" + str3 + "/" + str2;
/* 3704 */       this.jTextField16.setText(str4);
/*      */     } else {
/* 3706 */       this.jTextField16.setText("");
/*      */     } 
/*      */     
/* 3709 */     String año = campos[11].substring(0, 4);
/* 3710 */     String mes = campos[11].substring(5, 7);
/* 3711 */     String dia = campos[11].substring(8, 10);
/* 3712 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 3713 */     this.jTextField17.setText(strFecha);
/*      */     
/* 3715 */     this.jTextField18.setText(campos[12]);
/*      */     
/* 3717 */     this.jTextField19.setText(campos[13]);
/* 3718 */     this.jTextField20.setText(campos[14]);
/* 3719 */     this.jTextField21.setText(campos[23]);
/*      */     
/* 3721 */     this.jTextField22.setText(campos[17]);
/* 3722 */     this.jTextField23.setText(campos[16]);
/*      */     
/* 3724 */     if (this.jTextField22.getText().equals("")) {
/* 3725 */       this.jTextField22.setText("No Disponible");
/*      */     }
/* 3727 */     if (this.jTextField23.getText().equals("")) {
/* 3728 */       this.jTextField23.setText("No Disponible");
/*      */     }
/* 3730 */     this.jTextArea1.setText(campos[20]);
/*      */     
/* 3732 */     año = campos[15].substring(0, 4);
/* 3733 */     mes = campos[15].substring(5, 7);
/* 3734 */     dia = campos[15].substring(8, 10);
/* 3735 */     strFecha = dia + "/" + dia + "/" + mes;
/* 3736 */     this.jTextField24.setText(strFecha);
/*      */     
/* 3738 */     this.jTextField25.setText(campos[24]);
/* 3739 */     this.jTextField26.setText(campos[18]);
/* 3740 */     this.jTextField27.setText(campos[21]);
/* 3741 */     if (campos[19].equals("0")) {
/* 3742 */       this.jTextField28.setText("Activo");
/*      */     } else {
/* 3744 */       this.jTextField28.setText("Baja");
/*      */     } 
/* 3746 */     this.jDialog2.setVisible(true);
/*      */     
/* 3748 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 3749 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 3750 */     this.jDialog2.setCursor(micursor);
/* 3751 */     setCursor(micursor);
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 3755 */     Date fecha = new Date();
/* 3756 */     Calendar ahoraCal = Calendar.getInstance();
/* 3757 */     ahoraCal.setTime(fecha);
/* 3758 */     String mesesito = "";
/* 3759 */     String hoy = "";
/* 3760 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 3761 */     hoy = "" + ahoraCal.get(5);
/* 3762 */     if (ahoraCal.get(2) + 1 < 10) {
/* 3763 */       mesesito = "0" + mesesito;
/*      */     }
/* 3765 */     if (ahoraCal.get(5) < 10) {
/* 3766 */       hoy = "0" + hoy;
/*      */     }
/* 3768 */     return "(" + hoy + "/" + mesesito + "/" + ahoraCal.get(1) + "): ";
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy2() {
/* 3772 */     Date fecha = new Date();
/* 3773 */     Calendar ahoraCal = Calendar.getInstance();
/* 3774 */     ahoraCal.setTime(fecha);
/* 3775 */     String mesesito = "";
/* 3776 */     String hoy = "";
/* 3777 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 3778 */     hoy = "" + ahoraCal.get(5);
/* 3779 */     if (ahoraCal.get(2) + 1 < 10) {
/* 3780 */       mesesito = "0" + mesesito;
/*      */     }
/* 3782 */     if (ahoraCal.get(5) < 10) {
/* 3783 */       hoy = "0" + hoy;
/*      */     }
/* 3785 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void operadores(String usu) {
/* 3789 */     if (this.fichas != null) {
/* 3790 */       this.fichas.addTab("Demandas - [Buscar Actores]", this.panel);
/* 3791 */       this.jButton5.setText("Asignar");
/*      */     } 
/* 3793 */     this.USUARIO = usu;
/* 3794 */     this.panel.setViewportView(this);
/* 3795 */     privilegios();
/* 3796 */     consultar();
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 3800 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3802 */             OperadoresBuscar.this.jTextGanado(OperadoresBuscar.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3806 */             OperadoresBuscar.this.jTextPerdido(OperadoresBuscar.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 3809 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3811 */             OperadoresBuscar.this.jTextGanado(OperadoresBuscar.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3815 */             OperadoresBuscar.this.jTextPerdido(OperadoresBuscar.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 3818 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3820 */             OperadoresBuscar.this.jTextGanado(OperadoresBuscar.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3824 */             OperadoresBuscar.this.jTextPerdido(OperadoresBuscar.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 3827 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3829 */             OperadoresBuscar.this.jTextGanado(OperadoresBuscar.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3833 */             OperadoresBuscar.this.jTextPerdido(OperadoresBuscar.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 3836 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3838 */             OperadoresBuscar.this.jTextGanado(OperadoresBuscar.this.jTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3842 */             OperadoresBuscar.this.jTextPerdido(OperadoresBuscar.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 3845 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3847 */             OperadoresBuscar.this.jTextGanado(OperadoresBuscar.this.jTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3851 */             OperadoresBuscar.this.jTextPerdido(OperadoresBuscar.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 3854 */     this.jTextField29.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3856 */             OperadoresBuscar.this.jTextGanado(OperadoresBuscar.this.jTextField29, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3860 */             OperadoresBuscar.this.jTextPerdido(OperadoresBuscar.this.jTextField29, evt);
/*      */           }
/*      */         });
/* 3863 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3865 */             OperadoresBuscar.this.jTextGanado(OperadoresBuscar.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3869 */             OperadoresBuscar.this.jTextPerdido(OperadoresBuscar.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 3872 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3874 */             OperadoresBuscar.this.jTextGanado(OperadoresBuscar.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3878 */             OperadoresBuscar.this.jTextPerdido(OperadoresBuscar.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 3881 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3883 */             OperadoresBuscar.this.jTextGanado(OperadoresBuscar.this.jComboBox5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3887 */             OperadoresBuscar.this.jTextPerdido(OperadoresBuscar.this.jComboBox5, evt);
/*      */           }
/*      */         });
/* 3890 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3892 */             OperadoresBuscar.this.jTextGanado(OperadoresBuscar.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3896 */             OperadoresBuscar.this.jTextPerdido(OperadoresBuscar.this.jTextArea5, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 3902 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 3906 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public String dameMes(String mes) {
/* 3910 */     String mesLetra = "";
/* 3911 */     if (mes.equals("01")) {
/* 3912 */       mesLetra = "Enero";
/* 3913 */     } else if (mes.equals("02")) {
/* 3914 */       mesLetra = "Febrero";
/* 3915 */     } else if (mes.equals("03")) {
/* 3916 */       mesLetra = "Marzo";
/* 3917 */     } else if (mes.equals("04")) {
/* 3918 */       mesLetra = "Abril";
/* 3919 */     } else if (mes.equals("05")) {
/* 3920 */       mesLetra = "Mayo";
/* 3921 */     } else if (mes.equals("06")) {
/* 3922 */       mesLetra = "Junio";
/* 3923 */     } else if (mes.equals("07")) {
/* 3924 */       mesLetra = "Julio";
/* 3925 */     } else if (mes.equals("08")) {
/* 3926 */       mesLetra = "Agosto";
/* 3927 */     } else if (mes.equals("09")) {
/* 3928 */       mesLetra = "Septiembre";
/* 3929 */     } else if (mes.equals("10")) {
/* 3930 */       mesLetra = "Octubre";
/* 3931 */     } else if (mes.equals("11")) {
/* 3932 */       mesLetra = "Noviembre";
/* 3933 */     } else if (mes.equals("12")) {
/* 3934 */       mesLetra = "Diciembre";
/*      */     } 
/* 3936 */     return mesLetra;
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 3940 */     this.jButton2.setEnabled(false);
/* 3941 */     String datos = "0";
/* 3942 */     String tipo = "";
/* 3943 */     String actual = "0";
/* 3944 */     String trabajador = "";
/* 3945 */     if (this.jComboBox2.getSelectedIndex() == 1) {
/* 3946 */       actual = "1";
/* 3947 */     } else if (this.jComboBox2.getSelectedIndex() == 2) {
/* 3948 */       actual = "";
/*      */     } 
/* 3950 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 3951 */       tipo = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     }
/* 3953 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 3954 */       datos = "1";
/*      */     }
/* 3956 */     if (this.jComboBox5.getSelectedIndex() != 2) {
/* 3957 */       trabajador = this.jComboBox5.getSelectedItem().toString();
/*      */     }
/*      */     
/* 3960 */     this.jButton2.setEnabled(false);
/* 3961 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 3962 */           .buscarDatos(45, "num_ope,ap_pat,ap_mat,NOMBRE,calle,num,col,cp,ciudad,estados.estado,tel_casa,celular,nextel,cantNextel,cargoNextel,fecha_nac,fecha_licen,num_licen,tipo_licen,nss,rfcOriginal,rfc,numInfo,infonavitLetra,cargoInfo,estadocivil,hijos,personaContrato,testigo1,testigo2,recomendado,salarioImssLetra,tipo,num_tracto,num_rem,etiqueta,diasContrato,ingreso,ultimaFechaIngreso,ultimaActualizacion,usuario,lugarnacimiento,otrosDatos,comentarios,tipoTrabajador", "operadores,estados", "where num_ope like '%" + this.jTextField4.getText() + "%' and nombre like '%" + this.jTextField1.getText() + "%' and ap_pat like '%" + this.jTextField2.getText() + "%' and ap_mat like '%" + this.jTextField3.getText() + "%' and operadores.id_edo=estados.id_edo and operadores.tipo like '%" + tipo + "%' and num_tracto like '%" + this.jTextField5.getText() + "%' and num_rem like '%" + this.jTextField6.getText() + "%' and tipoTrabajador like '%" + trabajador + "%' and actual like '%" + actual + "%' order by ap_pat"), (Object[])new String[] { "Núm", "Nombre Completo", "Apellido Materno", "Nombre", "Dirección", "Número", "Colonia", "CP", "Ciudad", "Estado", "Teléfono", "Celular", "Nextel", "Cantidad", "Autom", "Nacimiento", "Venc. Licen.", "# Licencia", "Tipo", "NSS", "RFC", "CURP", "Infonavit", "Infonavit $", "Autom", "Estado Civil", "Hijos", "Contratado Por", "Testigo 1", "Testigo 2", "Recomendado Por", "Salario Imss", "Especializado", "T", "C", "Distintivo", "Contrato(Días)", "P. Ingreso", "U. Ingreso", "Actualización", "Responsable", "Lugar de Nacimiento", "Otros Datos", "Comentarios", "Tipo" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 3967 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/* 3972 */               false, false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) { return this.canEdit[columnIndex]; }
/*      */         
/*      */         });
/* 3975 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable3.getRowCount() + "</HTML>");
/* 3976 */     this.jTable3.setShowVerticalLines(false);
/* 3977 */     eliminarColumna(2, 1, "Apellido Materno");
/* 3978 */     eliminarColumna(2, 1, "Nombre");
/*      */     
/* 3980 */     eliminarColumna(3, 2, "Número");
/* 3981 */     eliminarColumna(3, 2, "Colonia");
/* 3982 */     eliminarColumna(3, 2, "CP");
/* 3983 */     eliminarColumna(3, 2, "Ciudad");
/* 3984 */     eliminarColumna(3, 2, "Estado");
/*      */     
/* 3986 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 3987 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 3988 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
/* 3989 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(270);
/* 3990 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(270);
/* 3991 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(390);
/* 3992 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(390);
/* 3993 */     this.jTable3.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 3994 */     this.jTable3.getColumnModel().getColumn(3).setMaxWidth(70);
/* 3995 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(70);
/* 3996 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(70);
/* 3997 */     this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(80);
/* 3998 */     this.jTable3.getColumnModel().getColumn(5).setMaxWidth(80);
/* 3999 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 4000 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(70);
/* 4001 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(45);
/* 4002 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(45);
/* 4003 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(65);
/* 4004 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(65);
/* 4005 */     this.jTable3.getColumnModel().getColumn(11).setPreferredWidth(45);
/* 4006 */     this.jTable3.getColumnModel().getColumn(11).setMaxWidth(45);
/* 4007 */     this.jTable3.getColumnModel().getColumn(12).setPreferredWidth(65);
/* 4008 */     this.jTable3.getColumnModel().getColumn(12).setMaxWidth(65);
/*      */     
/* 4010 */     this.jTable3.getColumnModel().getColumn(15).setPreferredWidth(70);
/* 4011 */     this.jTable3.getColumnModel().getColumn(15).setMaxWidth(70);
/* 4012 */     this.jTable3.getColumnModel().getColumn(16).setPreferredWidth(70);
/* 4013 */     this.jTable3.getColumnModel().getColumn(16).setMaxWidth(70);
/* 4014 */     this.jTable3.getColumnModel().getColumn(17).setPreferredWidth(45);
/* 4015 */     this.jTable3.getColumnModel().getColumn(17).setMaxWidth(45);
/* 4016 */     this.jTable3.getColumnModel().getColumn(19).setPreferredWidth(40);
/* 4017 */     this.jTable3.getColumnModel().getColumn(19).setMaxWidth(40);
/* 4018 */     this.jTable3.getColumnModel().getColumn(26).setPreferredWidth(40);
/* 4019 */     this.jTable3.getColumnModel().getColumn(26).setMaxWidth(40);
/* 4020 */     this.jTable3.getColumnModel().getColumn(27).setPreferredWidth(40);
/* 4021 */     this.jTable3.getColumnModel().getColumn(27).setMaxWidth(40);
/* 4022 */     this.jTable3.getColumnModel().getColumn(32).setPreferredWidth(120);
/* 4023 */     this.jTable3.getColumnModel().getColumn(32).setMaxWidth(120);
/*      */     
/* 4025 */     if (this.jComboBox2.getSelectedIndex() == 2) {
/* 4026 */       String[] arre = this.con.regresaColIndex("num_ope", "operadores", "where actual =1");
/* 4027 */       this.celda.pasarInd(arre);
/*      */     } else {
/* 4029 */       String[] arre = new String[0];
/* 4030 */       this.celda.pasarInd(arre);
/*      */     } 
/* 4032 */     this.jTable3.setSelectionMode(0);
/* 4033 */     this.jTable3.setAutoCreateRowSorter(true);
/* 4034 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/* 4035 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 4036 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 4037 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 4038 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 4039 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 4040 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 4041 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 4042 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 4043 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 4044 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 4045 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 4046 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 4047 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 4048 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 4049 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 4050 */     this.jTable3.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/* 4051 */     this.jTable3.getColumnModel().getColumn(16).setCellRenderer(this.celda);
/* 4052 */     this.jTable3.getColumnModel().getColumn(17).setCellRenderer(this.celda);
/* 4053 */     this.jTable3.getColumnModel().getColumn(18).setCellRenderer(this.celda);
/* 4054 */     this.jTable3.getColumnModel().getColumn(19).setCellRenderer(this.celda);
/* 4055 */     this.jTable3.getColumnModel().getColumn(20).setCellRenderer(this.celda);
/* 4056 */     this.jTable3.getColumnModel().getColumn(21).setCellRenderer(this.celda);
/* 4057 */     this.jTable3.getColumnModel().getColumn(22).setCellRenderer(this.celda);
/* 4058 */     this.jTable3.getColumnModel().getColumn(23).setCellRenderer(this.celda);
/* 4059 */     this.jTable3.getColumnModel().getColumn(24).setCellRenderer(this.celda);
/* 4060 */     this.jTable3.getColumnModel().getColumn(25).setCellRenderer(this.celda);
/* 4061 */     this.jTable3.getColumnModel().getColumn(26).setCellRenderer(this.celda);
/* 4062 */     this.jTable3.getColumnModel().getColumn(27).setCellRenderer(this.celda);
/* 4063 */     this.jTable3.getColumnModel().getColumn(28).setCellRenderer(this.celda);
/* 4064 */     this.jTable3.getColumnModel().getColumn(29).setCellRenderer(this.celda);
/* 4065 */     this.jTable3.getColumnModel().getColumn(30).setCellRenderer(this.celda);
/* 4066 */     this.jTable3.getColumnModel().getColumn(31).setCellRenderer(this.celda);
/* 4067 */     this.jTable3.getColumnModel().getColumn(32).setCellRenderer(this.celda);
/* 4068 */     this.jTable3.getColumnModel().getColumn(33).setCellRenderer(this.celda);
/* 4069 */     this.jTable3.getColumnModel().getColumn(34).setCellRenderer(this.celda);
/* 4070 */     this.jTable3.getColumnModel().getColumn(35).setCellRenderer(this.celda);
/* 4071 */     this.jTable3.getColumnModel().getColumn(36).setCellRenderer(this.celda);
/* 4072 */     this.jTable3.getColumnModel().getColumn(37).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 4076 */     int cont = this.jTable3.getRowCount();
/* 4077 */     String[] registros = new String[cont]; int i;
/* 4078 */     for (i = 0; i < cont; i++) {
/* 4079 */       registros[i] = this.jTable3.getValueAt(i, destino).toString();
/*      */     }
/* 4081 */     for (i = 0; i < cont; i++) {
/* 4082 */       registros[i] = registros[i] + " " + registros[i];
/* 4083 */       this.jTable3.setValueAt(registros[i], i, destino);
/*      */     } 
/* 4085 */     TableColumn columna = this.jTable3.getColumn(nombreCol);
/* 4086 */     this.jTable3.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void pasarTabla(JTable tabla) {
/* 4090 */     this.tabla = tabla;
/*      */   }
/*      */   
/*      */   class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 4095 */     int otro = -1;
/* 4096 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4099 */       setEnabled((table == null || table.isEnabled()));
/* 4100 */       String valor = String.valueOf(value);
/* 4101 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 4102 */       if (comparar(comp)) {
/* 4103 */         setBackground(Color.red);
/* 4104 */         setForeground(Color.white);
/* 4105 */       } else if (comparar(valor)) {
/* 4106 */         setBackground(Color.red);
/* 4107 */         setForeground(Color.black);
/* 4108 */       } else if (row % 2 == 0) {
/* 4109 */         setBackground(new Color(194, 213, 151));
/* 4110 */         setForeground(Color.black);
/*      */       } else {
/* 4112 */         setBackground((Color)null);
/* 4113 */         setForeground(Color.black);
/*      */       } 
/* 4115 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4116 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 4120 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 4124 */       for (int i = 0; i < this.indices.length; i++) {
/* 4125 */         if (this.indices[i].equals(reg)) {
/* 4126 */           return true;
/*      */         }
/*      */       } 
/* 4129 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   class cargarFoto
/*      */     implements Runnable {
/*      */     Thread t;
/* 4136 */     String num = "";
/*      */     
/*      */     cargarFoto(String valor) {
/* 4139 */       this.t = new Thread(this);
/* 4140 */       this.num = valor;
/* 4141 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 4148 */       ImageIcon tmpIcon = new ImageIcon(OperadoresBuscar.this.DIRECTIVA[0] + "/" + OperadoresBuscar.this.DIRECTIVA[0] + ".png");
/* 4149 */       OperadoresBuscar.this.FOTO = OperadoresBuscar.this.DIRECTIVA[0] + "/" + OperadoresBuscar.this.DIRECTIVA[0] + ".png";
/* 4150 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(185, -1, 1));
/* 4151 */       OperadoresBuscar.this.jLabel3.setText("");
/* 4152 */       if (temporal.getImageLoadStatus() == 4) {
/* 4153 */         OperadoresBuscar.this.jLabel3.setText("Sin Foto");
/*      */       } else {
/* 4155 */         OperadoresBuscar.this.jLabel3.setIcon(temporal);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public class fotoCredencial
/*      */     implements Runnable {
/*      */     Thread t;
/* 4163 */     String num = "";
/*      */     
/*      */     fotoCredencial(String valor) {
/* 4166 */       this.t = new Thread(this);
/* 4167 */       this.num = valor;
/* 4168 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 4175 */       ImageIcon tmpIcon = new ImageIcon(OperadoresBuscar.this.DIRECTIVA[0] + "/" + OperadoresBuscar.this.DIRECTIVA[0] + ".png");
/* 4176 */       OperadoresBuscar.this.FOTO = OperadoresBuscar.this.DIRECTIVA[0] + "/" + OperadoresBuscar.this.DIRECTIVA[0] + ".png";
/* 4177 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(98, -1, 1));
/* 4178 */       OperadoresBuscar.this.jLabel67.setText("");
/* 4179 */       OperadoresBuscar.this.jLabel115.setText("");
/* 4180 */       OperadoresBuscar.this.jLabel77.setText("");
/* 4181 */       if (temporal.getImageLoadStatus() == 4) {
/* 4182 */         OperadoresBuscar.this.jLabel67.setText("Sin fotografía");
/* 4183 */         OperadoresBuscar.this.jLabel115.setText("Sin fotografía");
/* 4184 */         OperadoresBuscar.this.jLabel77.setText("Sin fotografía");
/*      */       } else {
/* 4186 */         OperadoresBuscar.this.jLabel67.setText("");
/* 4187 */         OperadoresBuscar.this.jLabel115.setText("");
/* 4188 */         OperadoresBuscar.this.jLabel77.setText("");
/* 4189 */         OperadoresBuscar.this.jLabel67.setIcon(temporal);
/* 4190 */         OperadoresBuscar.this.jLabel115.setIcon(temporal);
/* 4191 */         OperadoresBuscar.this.jLabel77.setIcon(temporal);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   class fotoIndividual
/*      */     implements Runnable {
/*      */     Thread t;
/* 4199 */     String num = "";
/*      */     
/*      */     fotoIndividual(String valor) {
/* 4202 */       this.t = new Thread(this);
/* 4203 */       this.num = valor;
/* 4204 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 4211 */       ImageIcon tmpIcon = new ImageIcon(OperadoresBuscar.this.DIRECTIVA[0] + "/" + OperadoresBuscar.this.DIRECTIVA[0] + ".png");
/* 4212 */       OperadoresBuscar.this.FOTO = OperadoresBuscar.this.DIRECTIVA[0] + "/" + OperadoresBuscar.this.DIRECTIVA[0] + ".png";
/* 4213 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(190, -1, 1));
/* 4214 */       OperadoresBuscar.this.jLabel1.setText("");
/* 4215 */       if (temporal.getImageLoadStatus() == 4) {
/* 4216 */         OperadoresBuscar.this.jLabel1.setText("Sin Fotogafía");
/*      */       } else {
/* 4218 */         OperadoresBuscar.this.jLabel1.setText("");
/* 4219 */         OperadoresBuscar.this.jLabel1.setIcon(temporal);
/*      */       } 
/* 4221 */       String valor = String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(OperadoresBuscar.this.jTable3.getSelectedRow(), 28));
/* 4222 */       if (!valor.equals("VACÍO")) {
/* 4223 */         OperadoresBuscar.this.jLabel122.setVisible(true);
/* 4224 */         OperadoresBuscar.this.jLabel122.setText("<html><center>" + valor + "</center></html>");
/*      */       } else {
/* 4226 */         OperadoresBuscar.this.jLabel122.setVisible(false);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public class ImprimirDatos
/*      */     implements Printable
/*      */   {
/* 4234 */     String[] DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/* 4235 */     int opc = 0;
/* 4236 */     Graphics g2 = null; public int print(Graphics g, PageFormat f, int pageIndex) { int ind; Font fuente; ImageIcon imagen; Image img; ImageIcon tmpIcon; String op, fecha, fecha1, datos[], valor; int inicia, lineas;
/*      */       String[] DES;
/*      */       int i, cont, l, j;
/* 4239 */       this.g2 = g;
/* 4240 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 4245 */           ind = OperadoresBuscar.this.jTable3.getSelectedRow();
/* 4246 */           fuente = new Font("Dialog", 1, 7);
/* 4247 */           g.setFont(fuente);
/* 4248 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 15, 25);
/* 4249 */           fuente = new Font("Dialog", 0, 7);
/* 4250 */           g.setFont(fuente);
/* 4251 */           this.g2.drawString("AUTOPISTA MONTERREY-CADEREYTA, KM 32.5", 15, 35);
/* 4252 */           this.g2.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN 67451", 15, 45);
/* 4253 */           this.g2.drawString("FMF901004UZ9", 15, 55);
/* 4254 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 4255 */           img = imagen.getImage();
/* 4256 */           this.g2.drawImage(img, 64, 52, 55, 55, null);
/*      */           
/* 4258 */           tmpIcon = new ImageIcon(OperadoresBuscar.this.DIRECTIVA[0] + "/" + OperadoresBuscar.this.DIRECTIVA[0] + ".png");
/* 4259 */           img = tmpIcon.getImage();
/* 4260 */           this.g2.drawImage(img, 522, 17, 68, 90, null);
/* 4261 */           this.g2.drawLine(192, 17, 192, 105);
/* 4262 */           fuente = new Font("Dialog", 1, 11);
/* 4263 */           this.g2.setFont(fuente);
/* 4264 */           this.g2.drawString("OP-" + OperadoresBuscar.this.dameValor(ind, 0) + ": " + OperadoresBuscar.this.dameValor(ind, 1), 205, 25);
/*      */           
/* 4266 */           this.g2.setColor(Color.RED);
/* 4267 */           this.g2.drawRect(205, 30, 300, 60);
/* 4268 */           this.g2.setColor(new Color(204, 0, 0));
/* 4269 */           this.g2.fillRect(206, 31, 90, 58);
/*      */           
/* 4271 */           fuente = new Font("Dialog", 1, 9);
/* 4272 */           this.g2.setFont(fuente);
/* 4273 */           this.g2.setColor(Color.WHITE);
/* 4274 */           this.g2.drawString("TELÉFONO", 207, 42);
/* 4275 */           this.g2.drawString("LICENCIA", 207, 56);
/* 4276 */           this.g2.drawString("CATEGORÍA", 207, 69);
/* 4277 */           this.g2.drawString("FECHA", 207, 82);
/*      */           
/* 4279 */           fuente = new Font("Dialog", 0, 9);
/* 4280 */           this.g2.setFont(fuente);
/* 4281 */           this.g2.setColor(Color.BLACK);
/* 4282 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 3), 305, 42);
/* 4283 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 10), 305, 56);
/*      */           
/* 4285 */           op = OperadoresBuscar.this.dameValor(ind, 36);
/* 4286 */           System.out.println("valores " + op);
/* 4287 */           if (op.equals("OPERADOR")) {
/* 4288 */             this.g2.drawString("OPERADOR DE QUINTA RUEDA", 305, 69);
/*      */           } else {
/* 4290 */             this.g2.drawString("OPERADOR (FUNCIONARIO)", 305, 69);
/*      */           } 
/*      */           
/* 4293 */           this.g2.drawString(OperadoresBuscar.this.cargarFechaHoy2(), 305, 82);
/*      */           
/* 4295 */           this.g2.setColor(new Color(56, 93, 138));
/* 4296 */           this.g2.drawRoundRect(518, 15, 76, 94, 10, 10);
/*      */           
/* 4298 */           this.g2.setColor(Color.RED);
/* 4299 */           this.g2.fill3DRect(15, 112, 580, 7, true);
/*      */           
/* 4301 */           this.g2.setColor(Color.RED);
/* 4302 */           this.g2.drawLine(125, 136, 125, 239);
/* 4303 */           this.g2.drawRect(15, 135, 285, 105);
/* 4304 */           this.g2.setColor(Color.GRAY);
/* 4305 */           this.g2.fillRect(16, 136, 18, 103);
/* 4306 */           this.g2.setColor(Color.WHITE);
/* 4307 */           this.g2.fillRect(34, 136, 85, 103);
/* 4308 */           this.g2.fillRect(119, 136, 180, 103);
/* 4309 */           fuente = new Font("Dialog", 1, 5);
/* 4310 */           this.g2.setFont(fuente);
/* 4311 */           this.g2.setColor(Color.WHITE);
/* 4312 */           this.g2.drawString("D", 19, 177);
/* 4313 */           this.g2.drawString("A", 19, 184);
/* 4314 */           this.g2.drawString("T", 19, 191);
/* 4315 */           this.g2.drawString("O", 19, 198);
/* 4316 */           this.g2.drawString("S", 19, 205);
/*      */           
/* 4318 */           this.g2.drawString("P", 26, 158);
/* 4319 */           this.g2.drawString("E", 26, 165);
/* 4320 */           this.g2.drawString("R", 26, 172);
/* 4321 */           this.g2.drawString("S", 26, 179);
/* 4322 */           this.g2.drawString("O", 26, 186);
/* 4323 */           this.g2.drawString("N", 26, 193);
/* 4324 */           this.g2.drawString("A", 26, 200);
/* 4325 */           this.g2.drawString("L", 26, 207);
/* 4326 */           this.g2.drawString("E", 26, 214);
/* 4327 */           this.g2.drawString("S", 26, 221);
/*      */           
/* 4329 */           fuente = new Font("Dialog", 1, 7);
/* 4330 */           this.g2.setFont(fuente);
/* 4331 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 4333 */           this.g2.drawString("FECHA DE NAC", 37, 145);
/* 4334 */           this.g2.drawString("LUGAR DE NACIMIENTO", 37, 158);
/* 4335 */           this.g2.drawString("NÚM DE SEG SOCIAL", 37, 171);
/* 4336 */           this.g2.drawString("RFC", 200, 171);
/* 4337 */           this.g2.drawString("CURP", 37, 184);
/*      */           
/* 4339 */           this.g2.drawString("CARGO AUTOM NEXTEL", 37, 197);
/* 4340 */           this.g2.drawString("NEXTEL", 37, 210);
/* 4341 */           this.g2.drawString("CARGO", 200, 210);
/* 4342 */           this.g2.drawString("CARGO AUTOM INFON", 37, 223);
/* 4343 */           this.g2.drawString("INFONAVIT", 37, 236);
/* 4344 */           this.g2.drawString("CARGO", 200, 236);
/*      */           
/* 4346 */           fuente = new Font("Dialog", 0, 8);
/* 4347 */           this.g2.setFont(fuente);
/* 4348 */           fecha = OperadoresBuscar.this.dameValor(ind, 8);
/* 4349 */           fecha1 = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4350 */           this.g2.drawString(fecha1, 130, 145);
/* 4351 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 34), 130, 158);
/* 4352 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 12), 130, 171);
/* 4353 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 14), 130, 184);
/* 4354 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 7), 130, 197);
/*      */           
/* 4356 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 13), 233, 171);
/*      */           
/* 4358 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 5), 130, 210);
/* 4359 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 6), 233, 210);
/* 4360 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 17), 130, 223);
/* 4361 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 15), 130, 236);
/* 4362 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 16), 233, 236);
/*      */           
/* 4364 */           this.g2.setColor(Color.RED);
/* 4365 */           this.g2.drawLine(125, 136, 125, 239);
/*      */           
/* 4367 */           this.g2.setColor(Color.WHITE);
/* 4368 */           this.g2.fillRect(301, 130, 80, 190);
/*      */ 
/*      */           
/* 4371 */           this.g2.setColor(Color.RED);
/* 4372 */           this.g2.drawRect(310, 135, 285, 80);
/* 4373 */           this.g2.setColor(Color.GRAY);
/* 4374 */           this.g2.fillRect(311, 136, 18, 78);
/* 4375 */           this.g2.setColor(Color.WHITE);
/* 4376 */           this.g2.fillRect(329, 136, 85, 78);
/* 4377 */           this.g2.fillRect(414, 136, 180, 78);
/* 4378 */           fuente = new Font("Dialog", 1, 5);
/* 4379 */           this.g2.setFont(fuente);
/* 4380 */           this.g2.setColor(Color.WHITE);
/* 4381 */           this.g2.drawString("D", 318, 144);
/* 4382 */           this.g2.drawString("O", 318, 152);
/* 4383 */           this.g2.drawString("M", 318, 160);
/* 4384 */           this.g2.drawString("I", 318, 168);
/* 4385 */           this.g2.drawString("C", 318, 176);
/* 4386 */           this.g2.drawString("I", 318, 184);
/* 4387 */           this.g2.drawString("L", 318, 192);
/* 4388 */           this.g2.drawString("I", 318, 200);
/* 4389 */           this.g2.drawString("O", 318, 208);
/*      */           
/* 4391 */           fuente = new Font("Dialog", 1, 7);
/* 4392 */           this.g2.setFont(fuente);
/* 4393 */           this.g2.setColor(Color.BLACK);
/* 4394 */           this.g2.drawString("CALLE", 332, 145);
/* 4395 */           this.g2.drawString("NÚMERO", 332, 158);
/* 4396 */           this.g2.drawString("COLONIA", 332, 171);
/* 4397 */           this.g2.drawString("CIUDAD", 332, 184);
/* 4398 */           this.g2.drawString("CÓDIGO POSTAL", 332, 197);
/* 4399 */           this.g2.drawString("ESTADO", 332, 210);
/*      */           
/* 4401 */           datos = OperadoresBuscar.this.con.regresaReg("calle,num,col,cp,ciudad,estado", "operadores,estados", "where operadores.id_edo=estados.id_edo and num_ope=" + OperadoresBuscar.this.dameValor(ind, 0), 6);
/* 4402 */           fuente = new Font("Dialog", 0, 8);
/* 4403 */           this.g2.setFont(fuente);
/* 4404 */           this.g2.setColor(Color.BLACK);
/* 4405 */           this.g2.drawString(datos[0], 425, 145);
/* 4406 */           this.g2.drawString(datos[1], 425, 158);
/* 4407 */           this.g2.drawString(datos[2], 425, 171);
/* 4408 */           this.g2.drawString(datos[4], 425, 184);
/* 4409 */           this.g2.drawString(datos[3], 425, 197);
/* 4410 */           this.g2.drawString(datos[5], 425, 210);
/* 4411 */           this.g2.setColor(Color.RED);
/* 4412 */           this.g2.drawLine(420, 136, 420, 215);
/*      */           
/* 4414 */           this.g2.setColor(Color.RED);
/* 4415 */           this.g2.drawRect(15, 250, 285, 28);
/* 4416 */           this.g2.setColor(Color.GRAY);
/* 4417 */           this.g2.fillRect(16, 251, 18, 26);
/* 4418 */           this.g2.setColor(Color.WHITE);
/* 4419 */           this.g2.fillRect(34, 251, 85, 26);
/* 4420 */           this.g2.fillRect(119, 251, 180, 26);
/* 4421 */           this.g2.fillRect(210, 251, 35, 26);
/* 4422 */           fuente = new Font("Dialog", 1, 5);
/* 4423 */           this.g2.setFont(fuente);
/* 4424 */           this.g2.setColor(Color.WHITE);
/* 4425 */           this.g2.drawString("L", 19, 257);
/* 4426 */           this.g2.drawString("I", 19, 263);
/* 4427 */           this.g2.drawString("C", 19, 269);
/* 4428 */           this.g2.drawString("E", 19, 275);
/*      */           
/* 4430 */           this.g2.drawString("N", 26, 257);
/* 4431 */           this.g2.drawString("C", 26, 263);
/* 4432 */           this.g2.drawString("I", 26, 269);
/* 4433 */           this.g2.drawString("A", 26, 275);
/*      */           
/* 4435 */           fuente = new Font("Dialog", 1, 7);
/* 4436 */           this.g2.setFont(fuente);
/* 4437 */           this.g2.setColor(Color.BLACK);
/* 4438 */           this.g2.drawString("VENCIMIENTO", 37, 260);
/* 4439 */           this.g2.drawString("NÚM DE LICENCIA", 37, 273);
/* 4440 */           this.g2.drawString("TIPO", 217, 266);
/*      */           
/* 4442 */           fuente = new Font("Dialog", 0, 8);
/* 4443 */           this.g2.setFont(fuente);
/* 4444 */           this.g2.setColor(Color.BLACK);
/* 4445 */           fecha = OperadoresBuscar.this.dameValor(ind, 9);
/* 4446 */           fecha1 = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4447 */           this.g2.drawString(fecha1, 130, 260);
/* 4448 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 10), 130, 273);
/*      */           
/* 4450 */           fuente = new Font("Dialog", 0, 12);
/* 4451 */           this.g2.setFont(fuente);
/* 4452 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 11), 265, 269);
/*      */           
/* 4454 */           this.g2.setColor(Color.RED);
/* 4455 */           this.g2.drawLine(125, 250, 125, 278);
/* 4456 */           this.g2.drawLine(245, 250, 245, 278);
/* 4457 */           this.g2.drawLine(207, 250, 207, 278);
/*      */ 
/*      */           
/* 4460 */           this.g2.setColor(Color.RED);
/* 4461 */           this.g2.drawRect(310, 225, 285, 132);
/* 4462 */           this.g2.setColor(Color.GRAY);
/* 4463 */           this.g2.fillRect(311, 226, 18, 130);
/* 4464 */           this.g2.setColor(Color.WHITE);
/* 4465 */           this.g2.fillRect(329, 226, 85, 130);
/* 4466 */           this.g2.fillRect(414, 226, 180, 130);
/* 4467 */           fuente = new Font("Dialog", 1, 5);
/* 4468 */           this.g2.setFont(fuente);
/* 4469 */           this.g2.drawString("D", 314, 260);
/* 4470 */           this.g2.drawString("A", 314, 268);
/* 4471 */           this.g2.drawString("T", 314, 276);
/* 4472 */           this.g2.drawString("O", 314, 284);
/* 4473 */           this.g2.drawString("S", 314, 292);
/*      */           
/* 4475 */           this.g2.drawString("D", 314, 308);
/* 4476 */           this.g2.drawString("E", 314, 316);
/* 4477 */           this.g2.drawString("L", 314, 324);
/*      */           
/* 4479 */           this.g2.drawString("C", 321, 262);
/* 4480 */           this.g2.drawString("O", 321, 270);
/* 4481 */           this.g2.drawString("N", 321, 278);
/* 4482 */           this.g2.drawString("T", 321, 289);
/* 4483 */           this.g2.drawString("R", 321, 297);
/* 4484 */           this.g2.drawString("A", 321, 305);
/* 4485 */           this.g2.drawString("T", 321, 313);
/* 4486 */           this.g2.drawString("O", 321, 321);
/*      */           
/* 4488 */           fuente = new Font("Dialog", 1, 7);
/* 4489 */           this.g2.setFont(fuente);
/* 4490 */           this.g2.setColor(Color.BLACK);
/* 4491 */           this.g2.drawString("FECHA DE INGRESO", 332, 235);
/* 4492 */           this.g2.drawString("DÍAS DEL CONTRATO", 332, 248);
/* 4493 */           this.g2.drawString("DISTINTIVO", 332, 261);
/* 4494 */           this.g2.drawString("CONTRATADO POR", 332, 274);
/* 4495 */           this.g2.drawString("TESTIGO 1", 332, 287);
/* 4496 */           this.g2.drawString("TESTIGO 2", 332, 300);
/* 4497 */           this.g2.drawString("RECOMENDADO POR", 332, 313);
/* 4498 */           this.g2.drawString("SALARIO NOMINAL", 332, 326);
/* 4499 */           this.g2.drawString("TELÉFONO", 332, 339);
/* 4500 */           this.g2.drawString("CELULAR", 495, 339);
/* 4501 */           this.g2.drawString("ÚLTIMO INGRESO", 332, 352);
/*      */           
/* 4503 */           fuente = new Font("Dialog", 0, 8);
/* 4504 */           this.g2.setFont(fuente);
/* 4505 */           this.g2.setColor(Color.BLACK);
/* 4506 */           fecha = OperadoresBuscar.this.dameValor(ind, 30);
/* 4507 */           fecha1 = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4508 */           this.g2.drawString(fecha1, 425, 235);
/* 4509 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 29), 425, 248);
/* 4510 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 28), 425, 261);
/* 4511 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 20), 425, 274);
/* 4512 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 21), 425, 287);
/* 4513 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 22), 425, 300);
/* 4514 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 23), 425, 313);
/* 4515 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 24), 425, 326);
/* 4516 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 3), 425, 339);
/* 4517 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 4), 532, 339);
/* 4518 */           fecha = OperadoresBuscar.this.dameValor(ind, 31);
/* 4519 */           fecha1 = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4520 */           this.g2.drawString(fecha1, 425, 352);
/* 4521 */           this.g2.setColor(Color.RED);
/* 4522 */           this.g2.drawLine(420, 225, 420, 357);
/*      */ 
/*      */           
/* 4525 */           this.g2.setColor(Color.RED);
/* 4526 */           this.g2.drawRect(15, 288, 285, 69);
/* 4527 */           this.g2.setColor(Color.GRAY);
/* 4528 */           this.g2.fillRect(16, 289, 18, 67);
/* 4529 */           this.g2.setColor(Color.WHITE);
/* 4530 */           this.g2.fillRect(34, 289, 85, 67);
/* 4531 */           this.g2.fillRect(119, 289, 180, 67);
/* 4532 */           fuente = new Font("Dialog", 1, 5);
/* 4533 */           this.g2.setFont(fuente);
/* 4534 */           this.g2.setColor(Color.WHITE);
/* 4535 */           this.g2.drawString("O", 19, 311);
/* 4536 */           this.g2.drawString("T", 19, 318);
/* 4537 */           this.g2.drawString("R", 19, 325);
/* 4538 */           this.g2.drawString("O", 19, 332);
/* 4539 */           this.g2.drawString("S", 19, 339);
/*      */           
/* 4541 */           this.g2.drawString("D", 26, 311);
/* 4542 */           this.g2.drawString("A", 26, 318);
/* 4543 */           this.g2.drawString("T", 26, 325);
/* 4544 */           this.g2.drawString("O", 26, 332);
/* 4545 */           this.g2.drawString("S", 26, 339);
/*      */           
/* 4547 */           fuente = new Font("Dialog", 1, 7);
/* 4548 */           this.g2.setFont(fuente);
/* 4549 */           this.g2.setColor(Color.BLACK);
/* 4550 */           this.g2.drawString("NÚMERO DE HIJOS", 37, 298);
/* 4551 */           this.g2.drawString("ESTADO CIVIL", 37, 311);
/* 4552 */           this.g2.drawString("TRACTOR", 37, 324);
/* 4553 */           this.g2.drawString("REMOLQUE", 37, 337);
/* 4554 */           this.g2.drawString("ESPECIALIZADO EN", 37, 351);
/*      */           
/* 4556 */           fuente = new Font("Dialog", 0, 8);
/* 4557 */           this.g2.setFont(fuente);
/* 4558 */           this.g2.setColor(Color.BLACK);
/* 4559 */           fecha = OperadoresBuscar.this.dameValor(ind, 8);
/* 4560 */           fecha1 = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4561 */           this.g2.drawString(fecha1, 130, 145);
/* 4562 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 19), 130, 298);
/* 4563 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 18), 130, 311);
/* 4564 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 26), 130, 324);
/* 4565 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 27), 130, 337);
/* 4566 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 25), 130, 351);
/* 4567 */           this.g2.setColor(Color.RED);
/* 4568 */           this.g2.drawLine(125, 288, 125, 357);
/*      */ 
/*      */           
/* 4571 */           this.g2.setColor(Color.RED);
/* 4572 */           this.g2.drawRect(15, 367, 580, 140);
/* 4573 */           this.g2.setColor(Color.GRAY);
/* 4574 */           this.g2.fillRect(16, 368, 18, 138);
/* 4575 */           this.g2.setColor(Color.WHITE);
/* 4576 */           this.g2.fillRect(34, 368, 560, 138);
/*      */           
/* 4578 */           fuente = new Font("Dialog", 1, 5);
/* 4579 */           this.g2.setFont(fuente);
/* 4580 */           this.g2.setColor(Color.WHITE);
/*      */           
/* 4582 */           this.g2.drawString("A", 19, 417);
/* 4583 */           this.g2.drawString("L", 19, 424);
/* 4584 */           this.g2.drawString("G", 19, 431);
/* 4585 */           this.g2.drawString("U", 19, 438);
/* 4586 */           this.g2.drawString("N", 19, 445);
/* 4587 */           this.g2.drawString("A", 19, 452);
/* 4588 */           this.g2.drawString("S", 19, 459);
/*      */           
/* 4590 */           this.g2.drawString("R", 26, 403);
/* 4591 */           this.g2.drawString("E", 26, 410);
/* 4592 */           this.g2.drawString("F", 26, 417);
/* 4593 */           this.g2.drawString("E", 26, 424);
/* 4594 */           this.g2.drawString("R", 26, 431);
/* 4595 */           this.g2.drawString("E", 26, 438);
/* 4596 */           this.g2.drawString("N", 26, 445);
/* 4597 */           this.g2.drawString("C", 26, 452);
/* 4598 */           this.g2.drawString("I", 26, 459);
/* 4599 */           this.g2.drawString("A", 26, 466);
/* 4600 */           this.g2.drawString("S", 26, 473);
/*      */           
/* 4602 */           fuente = new Font("Dialog", 0, 7);
/* 4603 */           this.g2.setFont(fuente);
/* 4604 */           this.g2.setColor(Color.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4611 */           valor = OperadoresBuscar.this.dameValor(ind, 35);
/* 4612 */           inicia = 377;
/* 4613 */           lineas = valor.length() / 150;
/* 4614 */           lineas += 2;
/* 4615 */           DES = new String[lineas];
/* 4616 */           for (i = 0; i < DES.length; i++) {
/* 4617 */             DES[i] = new String("");
/*      */           }
/* 4619 */           cont = 0;
/* 4620 */           l = 0;
/* 4621 */           for (j = 0; j < valor.length(); j++) {
/* 4622 */             if (cont <= 150) {
/* 4623 */               DES[l] = DES[l] + DES[l];
/* 4624 */               cont++;
/*      */             } else {
/* 4626 */               DES[l] = DES[l] + DES[l];
/* 4627 */               cont = 0;
/* 4628 */               l++;
/*      */             } 
/*      */           } 
/* 4631 */           for (j = 0; j < DES.length; j++) {
/* 4632 */             g.drawString(DES[j], 37, inicia);
/* 4633 */             inicia += 8;
/*      */           } 
/*      */           
/* 4636 */           this.g2.drawString("_________________________________________", 15, 565);
/* 4637 */           this.g2.drawString(OperadoresBuscar.this.dameValor(ind, 1), 15, 575);
/* 4638 */           this.g2.drawString("EMPLEADO", 15, 585);
/*      */           
/* 4640 */           this.DATOS = OperadoresBuscar.this.con.regresaReg("ap_pat,ap_mat,nombre", "empleados,usuarios", "where clave_emp = num_emp and nombre_usu = '" + OperadoresBuscar.this.USUARIO + "'", 3);
/* 4641 */           this.g2.drawString("_________________________________________", 15, 645);
/* 4642 */           this.g2.drawString(this.DATOS[0] + " " + this.DATOS[0] + " " + this.DATOS[1], 15, 655);
/* 4643 */           this.g2.drawString("EMPRESA", 15, 665);
/*      */ 
/*      */           
/* 4646 */           this.g2.setColor(Color.RED);
/* 4647 */           this.g2.drawRect(310, 517, 285, 150);
/* 4648 */           this.g2.setColor(Color.GRAY);
/* 4649 */           this.g2.fillRect(311, 518, 18, 148);
/* 4650 */           this.g2.setColor(Color.WHITE);
/* 4651 */           this.g2.fillRect(329, 517, 85, 148);
/* 4652 */           this.g2.fillRect(414, 517, 180, 148);
/*      */           
/* 4654 */           this.g2.setColor(Color.RED);
/* 4655 */           this.g2.drawLine(310, 592, 595, 592);
/*      */           
/* 4657 */           fuente = new Font("Dialog", 1, 7);
/* 4658 */           this.g2.setFont(fuente);
/* 4659 */           this.g2.setColor(Color.WHITE);
/*      */           
/* 4661 */           this.g2.drawString("A", 318, 539);
/* 4662 */           this.g2.drawString("L", 318, 552);
/* 4663 */           this.g2.drawString("T", 318, 565);
/* 4664 */           this.g2.drawString("A", 318, 578);
/*      */           
/* 4666 */           this.g2.drawString("B", 318, 612);
/* 4667 */           this.g2.drawString("A", 318, 625);
/* 4668 */           this.g2.drawString("J", 318, 638);
/* 4669 */           this.g2.drawString("A", 318, 651);
/*      */           
/* 4671 */           fuente = new Font("Dialog", 1, 7);
/* 4672 */           this.g2.setFont(fuente);
/* 4673 */           this.g2.setColor(Color.BLACK);
/* 4674 */           this.g2.drawString("_____________________________________", 390, 567);
/* 4675 */           this.g2.drawString("NOMBRE Y FIRMA", 430, 580);
/*      */           
/* 4677 */           this.g2.drawString("_____________________________________", 390, 640);
/* 4678 */           this.g2.drawString("NOMBRE Y FIRMA", 430, 653);
/*      */ 
/*      */           
/* 4681 */           this.g2.setColor(new Color(56, 93, 138));
/* 4682 */           this.g2.drawRect(15, 730, 580, 40);
/* 4683 */           fuente = new Font("Dialog", 1, 6);
/* 4684 */           this.g2.setFont(fuente);
/* 4685 */           this.g2.setColor(Color.BLACK);
/* 4686 */           this.g2.drawString("          EN COMPLETO USO DE MIS FACULTADES DECLARO BAJO PROTESTA DECIR VERDAD QUE LA INFORMACIÓN PROPORCIONADA EN EL PRESENTE ES CORRECTA Y ESTOY CONFORME", 17, 747);
/* 4687 */           this.g2.drawString("                                                                     CON LAS POLÍTICAS DE LA EMPRESA. QUEDANDO A SUS ÓRDENES DESDE EL PRIMER DÍA DEL CONTRATO", 26, 759);
/*      */           
/* 4689 */           return 0;
/*      */       } 
/* 4691 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 4696 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 4697 */       job.setPrintable(this);
/*      */       
/* 4699 */       PageFormat pf = job.defaultPage();
/* 4700 */       Paper papel = pf.getPaper();
/* 4701 */       papel.setSize(612.0D, 792.0D);
/* 4702 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 4703 */       pf.setPaper(papel);
/* 4704 */       pf.setOrientation(1);
/* 4705 */       job.setPrintable(new ImprimirDatos(), pf);
/* 4706 */       job.defaultPage(pf);
/*      */       
/* 4708 */       boolean ok = job.printDialog();
/* 4709 */       if (ok)
/*      */         try {
/* 4711 */           job.print();
/* 4712 */         } catch (PrinterException printerException) {} 
/*      */     }
/*      */   }
/*      */   
/*      */   public class ImprimirCredencial implements Printable {
/*      */     int opc;
/*      */     Graphics2D g2;
/*      */     
/* 4720 */     public ImprimirCredencial() { this.opc = 0;
/* 4721 */       this.g2 = null; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen; Image img; ImageIcon tmpIcon; String nombre;
/*      */       int cuenta, esp3;
/*      */       String nombre1, nombre2;
/* 4724 */       this.g2 = (Graphics2D)g;
/* 4725 */       f.setOrientation(1);
/* 4726 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 4731 */           fuente = new Font("Dialog", 1, 12);
/* 4732 */           this.g2.setFont(fuente);
/* 4733 */           this.g2.setColor(Color.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4741 */           this.g2.setColor(Color.BLACK);
/* 4742 */           this.g2.drawRect(30, 45, 244, 154);
/* 4743 */           this.g2.drawRect(280, 45, 244, 154);
/*      */           
/* 4745 */           fuente = new Font("Times New Roman", 1, 11);
/* 4746 */           this.g2.setFont(fuente);
/* 4747 */           this.g2.setColor(new Color(153, 0, 0));
/* 4748 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 34, 57);
/*      */           
/* 4750 */           fuente = new Font("Dialog", 1, 9);
/* 4751 */           this.g2.setFont(fuente);
/* 4752 */           this.g2.setColor(Color.BLACK);
/* 4753 */           this.g2.drawLine(35, 60, 255, 60);
/* 4754 */           this.g2.drawLine(45, 63, 265, 63);
/* 4755 */           this.g2.drawRect(32, 69, 68, 90);
/*      */           
/* 4757 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/mosaico.png"));
/* 4758 */           img = imagen.getImage();
/* 4759 */           this.g2.drawImage(img, 193, 80, 80, 85, null);
/*      */           
/* 4761 */           tmpIcon = new ImageIcon(OperadoresBuscar.this.DIRECTIVA[0] + "/" + OperadoresBuscar.this.DIRECTIVA[0] + ".png");
/* 4762 */           img = tmpIcon.getImage();
/* 4763 */           this.g2.drawImage(img, 33, 70, 66, 88, null);
/*      */           
/* 4765 */           fuente = new Font("Dialog", 1, 9);
/* 4766 */           this.g2.setFont(fuente);
/* 4767 */           this.g2.setColor(Color.BLACK);
/* 4768 */           nombre = String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(OperadoresBuscar.this.jTable3.getSelectedRow(), 1));
/* 4769 */           cuenta = 0;
/* 4770 */           esp3 = 0;
/* 4771 */           nombre1 = "";
/* 4772 */           nombre2 = "";
/* 4773 */           if (nombre.length() > 26) {
/* 4774 */             for (int i = 0; i < nombre.length(); i++) {
/* 4775 */               if (nombre.charAt(i) == ' ') {
/* 4776 */                 cuenta++;
/*      */               }
/* 4778 */               if (cuenta < 3) {
/* 4779 */                 nombre1 = nombre1 + nombre1;
/*      */               } else {
/* 4781 */                 nombre2 = nombre2 + nombre2;
/*      */               } 
/*      */             } 
/*      */           } else {
/* 4785 */             nombre1 = nombre;
/*      */           } 
/* 4787 */           this.g2.drawString(nombre1, 105, 77);
/* 4788 */           this.g2.drawString(nombre2, 103, 88);
/*      */           
/* 4790 */           fuente = new Font("Dialog", 1, 8);
/* 4791 */           this.g2.setFont(fuente);
/* 4792 */           this.g2.drawString("LICENCIA:", 105, 102);
/* 4793 */           this.g2.drawString("TIPO:", 105, 114);
/* 4794 */           this.g2.drawString("NSS:", 105, 126);
/* 4795 */           this.g2.drawString("CURP:", 105, 138);
/* 4796 */           this.g2.drawString("VIGENCIA:", 105, 150);
/*      */           
/* 4798 */           fuente = new Font("Dialog", 0, 9);
/* 4799 */           this.g2.setFont(fuente);
/* 4800 */           this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(OperadoresBuscar.this.jTable3.getSelectedRow(), 10)), 149, 102);
/* 4801 */           this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(OperadoresBuscar.this.jTable3.getSelectedRow(), 11)), 130, 114);
/* 4802 */           this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(OperadoresBuscar.this.jTable3.getSelectedRow(), 12)), 127, 126);
/* 4803 */           this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(OperadoresBuscar.this.jTable3.getSelectedRow(), 14)), 134, 138);
/* 4804 */           this.g2.drawString(OperadoresBuscar.this.VIGENCIA, 105, 161);
/*      */           
/* 4806 */           fuente = new Font("DialogInput", 1, 10);
/* 4807 */           this.g2.setFont(fuente);
/* 4808 */           this.g2.drawString(OperadoresBuscar.this.CLAVEOP, 42, 173);
/*      */           
/* 4810 */           this.g2.setColor(new Color(247, 150, 70));
/* 4811 */           this.g2.fill3DRect(102, 164, 170, 12, true);
/*      */           
/* 4813 */           this.g2.setColor(Color.BLACK);
/* 4814 */           this.g2.drawString(OperadoresBuscar.this.jLabel81.getText(), 114, 173);
/*      */           
/* 4816 */           this.g2.setColor(new Color(153, 0, 0));
/* 4817 */           this.g2.fill3DRect(32, 180, 240, 18, true);
/*      */           
/* 4819 */           fuente = new Font("Dialog", 0, 7);
/* 4820 */           this.g2.setColor(Color.WHITE);
/* 4821 */           this.g2.setFont(fuente);
/* 4822 */           this.g2.drawString("Carretera México - Tuxpan Km. 8.5  Ejido Lázaro Cárdenas", 60, 187);
/* 4823 */           this.g2.drawString(" Tihuatlán, Veracruz México C.P. 92901 (01 782)-825-6455 al 58 ", 53, 195);
/*      */           
/* 4825 */           fuente = new Font("Dialog", 1, 10);
/* 4826 */           this.g2.setColor(Color.BLACK);
/* 4827 */           this.g2.drawString("|                                                         |", 58, 187);
/* 4828 */           this.g2.drawString("|                               |            |                  |                                       |", 53, 195);
/*      */ 
/*      */           
/* 4831 */           fuente = new Font("Times New Roman", 1, 11);
/* 4832 */           this.g2.setFont(fuente);
/* 4833 */           this.g2.setColor(new Color(153, 0, 0));
/* 4834 */           this.g2.drawString("POLÍTICAS DE LA EMPRESA", 325, 57);
/*      */           
/* 4836 */           fuente = new Font("Dialog", 1, 9);
/* 4837 */           this.g2.setFont(fuente);
/* 4838 */           this.g2.setColor(Color.BLACK);
/* 4839 */           this.g2.drawLine(285, 60, 505, 60);
/* 4840 */           this.g2.drawLine(290, 63, 515, 63);
/*      */ 
/*      */           
/* 4843 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/codigoBarras.png"));
/* 4844 */           img = imagen.getImage();
/* 4845 */           this.g2.drawImage(img, 492, 70, 30, 120, null);
/*      */           
/* 4847 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/fondoTrac.png"));
/* 4848 */           img = imagen.getImage();
/*      */           
/* 4850 */           this.g2.drawImage(img, 281, 100, 211, 60, null);
/*      */           
/* 4852 */           fuente = new Font("Dialog", 0, 5);
/* 4853 */           this.g2.setFont(fuente);
/* 4854 */           this.g2.drawString("•   Brindar trato justo y esmerado a todos los clientes, en sus solicitudes y reclamos", 282, 73);
/* 4855 */           this.g2.drawString("     considerando que el fin de la empresa es el servicio del cliente.", 282, 79);
/* 4856 */           this.g2.drawString("•   Definir por escrito, los tiempos de respuesta de todo requerimiento interno o externo", 282, 88);
/* 4857 */           this.g2.drawString("     es mi responsabilidad.", 282, 94);
/* 4858 */           this.g2.drawString("•   Como integrante de la empresa debo mantener un comportamiento ético, desterrar", 282, 103);
/* 4859 */           this.g2.drawString("     toda forma de paternalismo y favoritismo, cumpliendo el reglamento vigente de", 282, 109);
/* 4860 */           this.g2.drawString("     FORSIS y de todos los clientes.", 282, 115);
/* 4861 */           this.g2.drawString("•   Realizar evaluaciones periódicas, permanentes a todos los procesos donde se está", 282, 124);
/* 4862 */           this.g2.drawString("     involucrado mi desempeño.", 282, 130);
/* 4863 */           this.g2.drawString("•   Preservar el entorno ambiental y la seguridad de la comunidad en todo trabajo.", 282, 139);
/* 4864 */           this.g2.drawString("•   Difundir permanentemente la gestión de la empresa en forma interna y externa.", 282, 145);
/*      */           
/* 4866 */           fuente = new Font("Dialog", 1, 5);
/* 4867 */           this.g2.setFont(fuente);
/* 4868 */           this.g2.drawString(OperadoresBuscar.this.jLabel82.getText(), 290, 165);
/* 4869 */           this.g2.drawString("ROGER GARZA CANTÚ", 420, 165);
/* 4870 */           this.g2.drawString("____________________________", 295, 185);
/* 4871 */           this.g2.drawString("____________________________", 410, 185);
/* 4872 */           this.g2.drawString(OperadoresBuscar.this.jLabel81.getText().toUpperCase(), 295, 195);
/* 4873 */           this.g2.drawString("DIRECTOR", 438, 195);
/*      */           
/* 4875 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/firma.png"));
/* 4876 */           img = imagen.getImage();
/* 4877 */           this.g2.drawImage(img, 432, 159, 38, 38, null);
/*      */           
/* 4879 */           return 0;
/*      */       } 
/* 4881 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 4886 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 4887 */       job.setPrintable(this);
/*      */       
/* 4889 */       PageFormat pf = job.defaultPage();
/* 4890 */       Paper papel = pf.getPaper();
/* 4891 */       papel.setSize(612.0D, 792.0D);
/* 4892 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 4893 */       pf.setPaper(papel);
/* 4894 */       pf.setOrientation(1);
/* 4895 */       ImprimirCredencial im = new ImprimirCredencial();
/* 4896 */       job.setPrintable(im, pf);
/* 4897 */       job.defaultPage(pf);
/*      */       
/* 4899 */       boolean ok = job.printDialog();
/* 4900 */       if (ok)
/*      */         try {
/* 4902 */           job.print();
/* 4903 */         } catch (PrinterException printerException) {} 
/*      */     }
/*      */   }
/*      */   
/*      */   public class ImprimirRigPass implements Printable
/*      */   {
/*      */     int opc;
/*      */     Graphics2D g2;
/*      */     
/* 4912 */     public ImprimirRigPass() { this.opc = 0;
/* 4913 */       this.g2 = null; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen;
/*      */       Image img;
/*      */       ImageIcon tmpIcon;
/* 4916 */       this.g2 = (Graphics2D)g;
/* 4917 */       f.setOrientation(1);
/* 4918 */       switch (pageIndex) {
/*      */ 
/*      */ 
/*      */         
/*      */         case 0:
/* 4923 */           fuente = new Font("Dialog", 1, 12);
/* 4924 */           this.g2.setFont(fuente);
/* 4925 */           this.g2.setColor(Color.BLACK);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4933 */           this.g2.setColor(Color.BLUE);
/* 4934 */           this.g2.drawRect(30, 45, 244, 154);
/* 4935 */           this.g2.drawRect(280, 45, 244, 154);
/*      */           
/* 4937 */           fuente = new Font("Times New Roman", 1, 8);
/* 4938 */           this.g2.setFont(fuente);
/* 4939 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 82, 61);
/* 4940 */           this.g2.drawRoundRect(34, 49, 237, 147, 10, 10);
/* 4941 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsisOriginal.png"));
/* 4942 */           img = imagen.getImage();
/* 4943 */           this.g2.drawImage(img, 37, 52, 36, 38, null);
/*      */           
/* 4945 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/icoBarra.png"));
/* 4946 */           img = imagen.getImage();
/* 4947 */           this.g2.drawImage(img, 78, 65, 177, 19, null);
/*      */           
/* 4949 */           tmpIcon = new ImageIcon(OperadoresBuscar.this.DIRECTIVA[0] + "/" + OperadoresBuscar.this.DIRECTIVA[0] + ".png");
/* 4950 */           img = tmpIcon.getImage();
/* 4951 */           this.g2.drawImage(img, 39, 94, 56, 78, null);
/*      */           
/* 4953 */           this.g2.setColor(Color.BLACK);
/* 4954 */           this.g2.drawRect(38, 93, 58, 80);
/*      */           
/* 4956 */           fuente = new Font("Dialog", 0, 6);
/* 4957 */           this.g2.setFont(fuente);
/* 4958 */           this.g2.drawString("ACREDITA  A:", 155, 95);
/* 4959 */           this.g2.drawString("DE HABER TENIDO EL:", 150, 120);
/*      */           
/* 4961 */           this.g2.setColor(Color.BLUE);
/* 4962 */           fuente = new Font("Dialog", 1, 7);
/* 4963 */           this.g2.setFont(fuente);
/* 4964 */           this.g2.drawString(OperadoresBuscar.this.jLabel113.getText(), 125, 105);
/* 4965 */           fuente = new Font("Dialog", 1, 8);
/* 4966 */           this.g2.setFont(fuente);
/* 4967 */           this.g2.drawString("CURSO DE SEGURIDAD BÁSICA", 114, 130);
/* 4968 */           this.g2.drawString("____________________________", 114, 131);
/*      */           
/* 4970 */           fuente = new Font("Dialog", 1, 5);
/* 4971 */           this.g2.setFont(fuente);
/* 4972 */           this.g2.setColor(Color.BLACK);
/* 4973 */           this.g2.drawString("POR EL AGENTE CAPACITADOR", 140, 138);
/* 4974 */           this.g2.drawString(OperadoresBuscar.this.DIRECTIVA[3], 135, 145);
/* 4975 */           this.g2.drawString(OperadoresBuscar.this.AGENTE, 150, 152);
/*      */           
/* 4977 */           this.g2.drawString("Certificado por:", 160, 163);
/* 4978 */           this.g2.drawString("SECRETARÍA DEL TRABAJO Y PREVISIÓN SOCIAL", 114, 170);
/*      */           
/* 4980 */           fuente = new Font("Dialog", 0, 6);
/* 4981 */           this.g2.setFont(fuente);
/* 4982 */           this.g2.drawString("|Carretera México - Tuxpan Km. 8.5|Ejido Lázaro Cárdenas|", 70, 183);
/* 4983 */           this.g2.drawString("|Tihuatlán, Veracruz|México|C.P. 92901|(01 782)-825-6455 al 58|", 64, 192);
/*      */ 
/*      */           
/* 4986 */           this.g2.setColor(Color.BLUE);
/* 4987 */           this.g2.drawRoundRect(284, 49, 237, 147, 10, 10);
/* 4988 */           fuente = new Font("Dialog", 1, 8);
/* 4989 */           this.g2.setFont(fuente);
/* 4990 */           this.g2.drawString("CURSO DE SEGURIDAD BÁSICA", 340, 61);
/* 4991 */           this.g2.drawString("____________________________", 340, 62);
/*      */           
/* 4993 */           this.g2.setColor(Color.BLACK);
/* 4994 */           fuente = new Font("Dialog", 0, 6);
/* 4995 */           this.g2.setFont(fuente);
/* 4996 */           this.g2.drawString("NOMBRE DEL EMPLEADO:", 290, 80);
/* 4997 */           this.g2.drawString("CURP:", 290, 95);
/* 4998 */           this.g2.drawString("IMSS:", 290, 110);
/* 4999 */           this.g2.drawString("VIGENCIA:", 290, 125);
/*      */           
/* 5001 */           this.g2.setColor(Color.BLUE);
/* 5002 */           fuente = new Font("Dialog", 1, 7);
/* 5003 */           this.g2.setFont(fuente);
/* 5004 */           this.g2.drawString(OperadoresBuscar.this.jLabel113.getText(), 370, 80);
/* 5005 */           this.g2.drawString(OperadoresBuscar.this.jLabel129.getText(), 370, 95);
/* 5006 */           this.g2.drawString(OperadoresBuscar.this.jLabel134.getText(), 370, 110);
/* 5007 */           this.g2.drawString(OperadoresBuscar.this.jLabel136.getText().toUpperCase(), 370, 125);
/*      */           
/* 5009 */           this.g2.setColor(Color.BLACK);
/* 5010 */           this.g2.drawString("DE ACUERDO A LOS LINEAMIENTOS DE:", 333, 147);
/* 5011 */           this.g2.drawString("'INTERNATIONAL ASSOCIATION OF DRILLING CONTRACTORS'", 296, 157);
/*      */           
/* 5013 */           fuente = new Font("Dialog", 1, 5);
/* 5014 */           this.g2.setFont(fuente);
/* 5015 */           this.g2.drawString("Firma:______________________", 290, 188);
/*      */           
/* 5017 */           fuente = new Font("Dialog", 1, 8);
/* 5018 */           this.g2.setFont(fuente);
/* 5019 */           this.g2.drawString("F" + OperadoresBuscar.this.DIRECTIVA[1] + "-", 470, 190);
/*      */           
/* 5021 */           this.g2.setColor(Color.BLUE);
/* 5022 */           this.g2.drawString(OperadoresBuscar.this.jLabel135.getText(), 490, 190);
/*      */           
/* 5024 */           return 0;
/*      */       } 
/* 5026 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 5031 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 5032 */       job.setPrintable(this);
/*      */       
/* 5034 */       PageFormat pf = job.defaultPage();
/* 5035 */       Paper papel = pf.getPaper();
/* 5036 */       papel.setSize(612.0D, 792.0D);
/* 5037 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 5038 */       pf.setPaper(papel);
/* 5039 */       pf.setOrientation(1);
/* 5040 */       ImprimirRigPass im = new ImprimirRigPass();
/* 5041 */       job.setPrintable(im, pf);
/* 5042 */       job.defaultPage(pf);
/*      */       
/* 5044 */       boolean ok = job.printDialog();
/* 5045 */       if (ok)
/*      */         try {
/* 5047 */           job.print();
/* 5048 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirLista implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirLista() {
/* 5058 */       this.g2 = null;
/* 5059 */       this.Pag = 0;
/*      */       
/* 5061 */       this.linesPerPage = 50;
/* 5062 */       this.orientacion = 0;
/* 5063 */       this.X = 0.0D;
/* 5064 */       this.Y = 0.0D;
/* 5065 */       this.YINICIA = 75;
/* 5066 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 5067 */       this.NumLineas = 0;
/* 5068 */       this.numBreaks = 0;
/*      */     }
/*      */     private void initTextLines() {
/* 5071 */       if (this.textLines == null) {
/* 5072 */         int numLines = OperadoresBuscar.this.jTable3.getRowCount();
/* 5073 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 5078 */       Font font = new Font("Serif", 0, 8);
/* 5079 */       FontMetrics metrics = g.getFontMetrics(font);
/* 5080 */       int lineHeight = metrics.getHeight();
/* 5081 */       if (this.pageBreaks == null) {
/* 5082 */         initTextLines();
/* 5083 */         this.orientacion = pf.getOrientation();
/* 5084 */         if (pf.getOrientation() == 1) {
/* 5085 */           this.linesPerPage = 46;
/* 5086 */           this.X = pf.getWidth();
/* 5087 */           this.Y = pf.getHeight();
/*      */         } else {
/* 5089 */           this.linesPerPage = 38;
/* 5090 */           this.X = pf.getWidth();
/* 5091 */           this.Y = pf.getHeight();
/*      */         } 
/* 5093 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 5094 */         this.Pag = this.numBreaks;
/* 5095 */         this.pageBreaks = new int[this.numBreaks];
/* 5096 */         for (int b = 0; b < this.numBreaks; b++) {
/* 5097 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 5100 */       if (pageIndex > this.pageBreaks.length) {
/* 5101 */         return 1;
/*      */       }
/* 5103 */       Graphics2D g2d = (Graphics2D)g;
/* 5104 */       this.g2 = g;
/* 5105 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 5106 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 5107 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 5108 */       encabezado();
/* 5109 */       int y = this.YINICIA;
/* 5110 */       int lineas = 0;
/*      */       
/* 5112 */       this.g2.drawRect(25, 140, 550, 12);
/* 5113 */       this.g2.setColor(new Color(204, 0, 0));
/* 5114 */       this.g2.fillRect(26, 141, 548, 10);
/*      */       
/* 5116 */       Font fuente = new Font("Dialog", 1, 8);
/* 5117 */       this.g2.setFont(fuente);
/* 5118 */       this.g2.setColor(Color.WHITE);
/* 5119 */       this.g2.drawString("CLAVE", 29, 149);
/* 5120 */       this.g2.drawString("NOMBRE", 100, 149);
/* 5121 */       this.g2.drawString("CELULAR", 208, 149);
/* 5122 */       this.g2.drawString("NEXTEL", 260, 149);
/* 5123 */       this.g2.drawString("V LICE", 305, 149);
/* 5124 */       this.g2.drawString("LICENCIA", 347, 149);
/* 5125 */       this.g2.drawString("NSS", 408, 149);
/* 5126 */       this.g2.drawString("INFONAVIT", 450, 149);
/* 5127 */       this.g2.drawString("INGRESO", 522, 149);
/*      */       
/* 5129 */       this.g2.setColor(Color.BLACK);
/* 5130 */       y = 150;
/* 5131 */       for (int line = start; line < end; line++) {
/* 5132 */         y += 12;
/* 5133 */         this.g2.drawLine(25, y, 575, y);
/*      */         
/* 5135 */         String valor = "";
/* 5136 */         if (line < 9) {
/* 5137 */           valor = "0" + line + 1;
/*      */         } else {
/* 5139 */           valor = "" + line + 1;
/*      */         } 
/* 5141 */         fuente = new Font("Dialog", 1, 7);
/* 5142 */         this.g2.setFont(fuente);
/* 5143 */         this.g2.drawString(valor, OperadoresBuscar.this.alinearDer(23, valor.toString().length()), y - 2);
/*      */         
/* 5145 */         fuente = new Font("Dialog", 0, 6);
/* 5146 */         this.g2.setFont(fuente);
/*      */         
/* 5148 */         this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(line, 0)), OperadoresBuscar.this.alinearDer(45, OperadoresBuscar.this.jTable3.getValueAt(line, 0).toString().length()), y - 2);
/* 5149 */         this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(line, 1)), 60, y - 2);
/* 5150 */         this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(line, 4)), 207, y - 2);
/* 5151 */         this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(line, 5)), 260, y - 2);
/* 5152 */         this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(line, 9)), 302, y - 2);
/* 5153 */         this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(line, 10)), 347, y - 2);
/* 5154 */         this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(line, 12)), 400, y - 2);
/* 5155 */         this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(line, 15)), 455, y - 2);
/* 5156 */         this.g2.drawString(String.valueOf(OperadoresBuscar.this.jTable3.getValueAt(line, 31)), 525, y - 2);
/*      */       } 
/* 5158 */       this.g2.drawLine(25, 151, 25, y);
/* 5159 */       this.g2.drawLine(575, 151, 575, y);
/* 5160 */       fuente = new Font("Dialog", 0, 7);
/* 5161 */       this.g2.setFont(fuente);
/* 5162 */       g.drawString("Página " + pageIndex + 1, 548, 755);
/* 5163 */       this.g2.setColor(Color.WHITE);
/* 5164 */       this.g2.fillRect((int)this.X - 46, 0, (int)this.X - 46, lineas);
/*      */       
/* 5166 */       if (this.Pag == pageIndex) {
/* 5167 */         fuente = new Font("Dialog", 1, 7);
/* 5168 */         this.g2.setFont(fuente);
/* 5169 */         this.g2.setColor(Color.BLACK);
/* 5170 */         this.g2.drawString("ELABORÓ", 300, 720);
/* 5171 */         this.g2.drawString("_____________________________________", 250, 752);
/* 5172 */         this.g2.drawString("NOMBRE Y FIRMA", 288, 765);
/*      */       } 
/* 5174 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 5178 */       Font fuente = new Font("Dialog", 0, 8);
/* 5179 */       this.g2.setFont(fuente);
/* 5180 */       this.g2.setColor(Color.BLACK);
/* 5181 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 5182 */       Image img = imagen.getImage();
/* 5183 */       this.g2.drawImage(img, 518, 9, 60, 60, null);
/*      */       
/* 5185 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 5186 */       img = imagen.getImage();
/* 5187 */       this.g2.drawImage(img, 27, 16, 60, 50, null);
/*      */       
/* 5189 */       fuente = new Font("Times New Roman", 1, 16);
/* 5190 */       this.g2.setFont(fuente);
/* 5191 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 30);
/* 5192 */       fuente = new Font("Dialog", 0, 11);
/* 5193 */       this.g2.setFont(fuente);
/* 5194 */       this.g2.drawString("LISTA DE OPERADORES", 223, 47);
/* 5195 */       this.g2.drawLine(25, 71, 575, 71);
/*      */       
/* 5197 */       fuente = new Font("Dialog", 1, 8);
/* 5198 */       this.g2.setFont(fuente);
/*      */       
/* 5200 */       fuente = new Font("Dialog", 0, 8);
/* 5201 */       this.g2.setFont(fuente);
/*      */       
/* 5203 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5204 */       String cadenaFecha1 = formato.format(new Date());
/* 5205 */       String año = cadenaFecha1.substring(0, 4);
/* 5206 */       String mes = cadenaFecha1.substring(4, 6);
/* 5207 */       String dia = cadenaFecha1.substring(6, 8);
/*      */       
/* 5209 */       this.g2.drawRect(25, 77, 550, 50);
/*      */       
/* 5211 */       this.g2.setColor(new Color(204, 0, 0));
/* 5212 */       this.g2.fillRect(25, 78, 550, 12);
/*      */       
/* 5214 */       this.g2.setColor(Color.BLACK);
/* 5215 */       this.g2.drawLine(25, 90, 575, 90);
/*      */       
/* 5217 */       this.g2.drawLine(287, 90, 287, 127);
/*      */       
/* 5219 */       fuente = new Font("Dialog", 0, 8);
/* 5220 */       this.g2.setFont(fuente);
/* 5221 */       this.g2.setColor(Color.WHITE);
/* 5222 */       this.g2.drawString("INFORMACIÓN DEL REPORTE", 235, 87);
/*      */       
/* 5224 */       fuente = new Font("Dialog", 0, 7);
/* 5225 */       this.g2.setFont(fuente);
/* 5226 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 5228 */       this.g2.drawString("RESPONSABLE: ", 27, 100);
/* 5229 */       this.g2.drawString("REPORTE DE: ", 27, 111);
/* 5230 */       this.g2.drawString("FECHA DE IMP: ", 27, 122);
/*      */       
/* 5232 */       this.g2.drawString("ESPECIALIZADOS EN: ", 292, 100);
/* 5233 */       this.g2.drawString("ESTATUS:", 292, 111);
/* 5234 */       this.g2.drawString("BASE:", 292, 122);
/*      */       
/* 5236 */       fuente = new Font("Dialog", 1, 7);
/* 5237 */       this.g2.setFont(fuente);
/*      */       
/* 5239 */       String tipo = "";
/* 5240 */       if (OperadoresBuscar.this.jComboBox5.getSelectedIndex() == 0) {
/* 5241 */         tipo = "OPERADORES";
/* 5242 */       } else if (OperadoresBuscar.this.jComboBox5.getSelectedIndex() == 1) {
/* 5243 */         tipo = "FUNCIONARIOS";
/*      */       } else {
/* 5245 */         tipo = "GENERAL";
/*      */       } 
/*      */       
/* 5248 */       String[] USU = OperadoresBuscar.this.con.regresaReg("nombre,ap_pat,ap_mat", "empleados,usuarios", "where clave_emp = num_emp and nombre_usu = '" + OperadoresBuscar.this.USUARIO + "'", 3);
/*      */       
/* 5250 */       this.g2.drawString(USU[1] + " " + USU[1] + " " + USU[2], 95, 100);
/* 5251 */       this.g2.drawString(tipo, 95, 111);
/* 5252 */       this.g2.drawString(dia + "/" + dia + "/" + mes, 95, 122);
/*      */       
/* 5254 */       OperadoresBuscar.this.con.consultar("sucursal", "configuraciones", "");
/* 5255 */       String espe = "GENERAL";
/* 5256 */       if (OperadoresBuscar.this.jComboBox1.getSelectedIndex() != 0) {
/* 5257 */         espe = String.valueOf(OperadoresBuscar.this.jComboBox1.getSelectedItem());
/*      */       }
/* 5259 */       String estatus = String.valueOf(OperadoresBuscar.this.jComboBox2.getSelectedItem());
/* 5260 */       this.g2.drawString(espe.toUpperCase(), 375, 100);
/* 5261 */       this.g2.drawString(estatus.toUpperCase(), 375, 111);
/* 5262 */       this.g2.drawString(OperadoresBuscar.this.con.Campo, 375, 122);
/*      */     }
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 5267 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 5268 */       job.setPrintable(this);
/*      */       
/* 5270 */       PageFormat pf = job.defaultPage();
/* 5271 */       Paper papel = pf.getPaper();
/* 5272 */       papel.setSize(612.0D, 792.0D);
/* 5273 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 5274 */       pf.setPaper(papel);
/* 5275 */       pf.setOrientation(1);
/* 5276 */       job.setPrintable(new ImprimirLista(), pf);
/* 5277 */       job.defaultPage(pf);
/*      */       
/* 5279 */       boolean ok = job.printDialog();
/* 5280 */       if (ok) {
/*      */         try {
/* 5282 */           job.print();
/* 5283 */         } catch (PrinterException printerException) {}
/*      */       }
/*      */     } }
/*      */ 
/*      */   
/*      */   public class fotoFirmas
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 5292 */     String num = "";
/*      */     
/*      */     fotoFirmas(String valor) {
/* 5295 */       this.t = new Thread(this);
/* 5296 */       this.num = valor;
/* 5297 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 5304 */       ImageIcon tmpIcon = new ImageIcon(OperadoresBuscar.this.DIRECTIVA[0] + "/Firmas/" + OperadoresBuscar.this.DIRECTIVA[0] + ".png");
/* 5305 */       OperadoresBuscar.this.FOTO = OperadoresBuscar.this.DIRECTIVA[0] + "/Firmas/" + OperadoresBuscar.this.DIRECTIVA[0] + ".png";
/* 5306 */       System.out.println(OperadoresBuscar.this.FOTO);
/* 5307 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(550, -1, 1));
/* 5308 */       OperadoresBuscar.this.jLabel69.setText("");
/* 5309 */       if (temporal.getImageLoadStatus() == 4) {
/* 5310 */         OperadoresBuscar.this.jLabel69.setText("Sin Firma");
/*      */       } else {
/* 5312 */         OperadoresBuscar.this.jLabel69.setText("");
/* 5313 */         OperadoresBuscar.this.jLabel69.setIcon(temporal);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   class CeldaRender2
/*      */     extends DefaultTableCellRenderer
/*      */   {
/*      */     int otro;
/*      */     
/*      */     int pintar;
/*      */     
/*      */     CeldaRender2() {
/* 5327 */       this.otro = -1;
/* 5328 */       this.pintar = 0;
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5331 */       setEnabled((table == null || table.isEnabled()));
/* 5332 */       if (row < this.pintar) {
/* 5333 */         setBackground(OperadoresBuscar.this.lc.FONDOTABLA);
/*      */       } else {
/*      */         
/* 5336 */         setBackground((Color)null);
/*      */       } 
/* 5338 */       setForeground(OperadoresBuscar.this.lc.SECUNDARIO1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 5347 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5348 */       return this;
/*      */     }
/*      */     public void setPintar(int indicePintar) {
/* 5351 */       this.pintar = indicePintar;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/OperadoresBuscar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */