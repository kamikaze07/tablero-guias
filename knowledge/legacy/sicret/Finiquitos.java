/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.Image;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.GregorianCalendar;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ 
/*      */ public class Finiquitos extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   41 */   Date fechaActual = new Date();
/*   42 */   Date fechaInicio = null;
/*   43 */   Date fecha = new Date();
/*   44 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   45 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   46 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   47 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   48 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   49 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   50 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   51 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   52 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   53 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   54 */   JFrame padre = null;
/*   55 */   JTabbedPane fichas = null;
/*   56 */   String[] CLAVES = null;
/*   57 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*   59 */   DefaultTableModel modelo = new DefaultTableModel();
/*   60 */   CeldaRender celda = new CeldaRender();
/*   61 */   CeldaRender2 celda2 = new CeldaRender2();
/*   62 */   CeldaRender3 celda3 = new CeldaRender3();
/*   63 */   CeldaRender4 celda4 = new CeldaRender4();
/*   64 */   String[] CLAVESOP = null;
/*   65 */   String[] CLAVESEM = null;
/*   66 */   String[] NOMBRESOP = null;
/*   67 */   String[] NOMBRESEM = null;
/*   68 */   String[] DATOS = null;
/*      */   boolean ACTIVO = false;
/*   70 */   double TOTAL1 = 0.0D;
/*   71 */   double TOTAL2 = 0.0D;
/*   72 */   NumerosALetras numLetra = null;
/*   73 */   int DIAS = 0;
/*   74 */   String DIRECTIVA = "";
/*   75 */   String CLAVE = "";
/*   76 */   String base = "";
/*   77 */   String[] CONFIG = null;
/*      */   EscribirReporte esc;
/*   79 */   Date FECHAFINAL = null;
/*   80 */   String PRIVILEGIOS = ""; private JFormattedTextField aux; private ButtonGroup buttonGroup1; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton29; private JButton jButton3; private JButton jButton33; private JButton jButton34; private JButton jButton35; private JButton jButton36; private JButton jButton37; private JButton jButton38; private JButton jButton39; private JButton jButton4; private JButton jButton40; private JButton jButton44; private JButton jButton45; private JButton jButton5; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JDateChooser jDateChooser10; private JDateChooser jDateChooser11; private JDateChooser jDateChooser12; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser7;
/*   81 */   String CLAVEOP = ""; private JDateChooser jDateChooser8; private JDateChooser jDateChooser9; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JFormattedTextField jFormattedTextField5; private JFormattedTextField jFormattedTextField6; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel116; private JLabel jLabel117; private JLabel jLabel118; private JLabel jLabel119; private JLabel jLabel12; private JLabel jLabel120; private JLabel jLabel121; private JLabel jLabel122; private JLabel jLabel123; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel127; private JLabel jLabel128; private JLabel jLabel129; private JLabel jLabel13; private JLabel jLabel130; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel24; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30;
/*      */   
/*      */   public Finiquitos(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*   84 */     String año = "2010";
/*   85 */     String mes = "10";
/*   86 */     String dia = "10";
/*   87 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   88 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   90 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   91 */     } catch (ParseException ex) {
/*   92 */       ex.printStackTrace();
/*      */     } 
/*   94 */     this.padre = padre;
/*   95 */     fichas = fichas;
/*   96 */     initComponents();
/*   97 */     this.USUARIO = USUARIO;
/*   98 */     panelito.setViewportView(this);
/*   99 */     this.panel = panelito;
/*      */     
/*  101 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  102 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  103 */     editFormat.setGroupingUsed(false);
/*  104 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  105 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  106 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  107 */     enFormat.setAllowsInvalid(true);
/*  108 */     this.cantidad.setFormatterFactory(currFactory);
/*  109 */     this.aux.setFormatterFactory(currFactory);
/*  110 */     this.jFormattedTextField3.setFormatterFactory(currFactory);
/*  111 */     this.jFormattedTextField4.setFormatterFactory(currFactory);
/*  112 */     this.jFormattedTextField5.setFormatterFactory(currFactory);
/*  113 */     this.jFormattedTextField6.setFormatterFactory(currFactory);
/*  114 */     this.cantidad.setValue(Integer.valueOf(0));
/*  115 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*  116 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/*  117 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/*  118 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*      */     
/*  120 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  121 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  122 */     this.jLabel5.setCursor(micursor);
/*  123 */     this.jLabel6.setCursor(micursor);
/*  124 */     this.jLabel7.setCursor(micursor);
/*      */     
/*  126 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  127 */     Cursor micursor2 = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  128 */     this.jDialog1.setCursor(micursor2);
/*  129 */     this.jDialog2.setCursor(micursor2);
/*  130 */     this.jDialog3.setCursor(micursor2);
/*  131 */     this.jDialog4.setCursor(micursor2);
/*  132 */     this.jDialog5.setCursor(micursor2);
/*  133 */     this.jDialog6.setCursor(micursor2);
/*  134 */     this.jDialog7.setCursor(micursor2);
/*      */     
/*  136 */     this.buttonGroup1.add(this.jRadioButton1);
/*  137 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*  139 */     int w = this.tama.width;
/*  140 */     int h = this.tama.height;
/*  141 */     int rw = (w - 920) / 2;
/*  142 */     int rh = 10;
/*  143 */     this.jDialog1.setLocation(rw, rh);
/*  144 */     this.jDialog1.setSize(940, 710);
/*  145 */     this.jDialog1.setResizable(false);
/*  146 */     this.jDialog1.setVisible(false);
/*      */     
/*  148 */     rw = (w - 807) / 2;
/*  149 */     rh = (h - 393) / 2;
/*  150 */     this.jDialog2.setLocation(rw, rh);
/*  151 */     this.jDialog2.setSize(807, 393);
/*  152 */     this.jDialog2.setVisible(false);
/*  153 */     this.jDialog2.setResizable(false);
/*      */     
/*  155 */     rw = (w - 570) / 2;
/*  156 */     rh = (h - 175) / 2;
/*  157 */     this.jDialog3.setLocation(rw, rh);
/*  158 */     this.jDialog3.setSize(570, 175);
/*  159 */     this.jDialog3.setVisible(false);
/*  160 */     this.jDialog3.setResizable(false);
/*      */     
/*  162 */     rw = (w - 570) / 2;
/*  163 */     rh = (h - 175) / 2;
/*  164 */     this.jDialog4.setLocation(rw, rh);
/*  165 */     this.jDialog4.setSize(570, 175);
/*  166 */     this.jDialog4.setVisible(false);
/*  167 */     this.jDialog4.setResizable(false);
/*      */     
/*  169 */     rw = (w - 570) / 2;
/*  170 */     rh = (h - 175) / 2;
/*  171 */     this.jDialog5.setLocation(rw, rh);
/*  172 */     this.jDialog5.setSize(570, 175);
/*  173 */     this.jDialog5.setVisible(false);
/*  174 */     this.jDialog5.setResizable(false);
/*      */     
/*  176 */     rw = (w - 570) / 2;
/*  177 */     rh = (h - 175) / 2;
/*  178 */     this.jDialog6.setLocation(rw, rh);
/*  179 */     this.jDialog6.setSize(570, 175);
/*  180 */     this.jDialog6.setVisible(false);
/*  181 */     this.jDialog6.setResizable(false);
/*      */     
/*  183 */     rw = (w - 390) / 2;
/*  184 */     rh = (h - 230) / 2;
/*  185 */     this.jDialog7.setLocation(rw, rh);
/*  186 */     this.jDialog7.setSize(390, 230);
/*  187 */     this.jDialog7.setVisible(false);
/*  188 */     this.jDialog7.setResizable(false);
/*      */     
/*  190 */     rw = (w - 890) / 2;
/*  191 */     rh = (h - 400) / 2;
/*  192 */     this.jDialog8.setLocation(rw, rh);
/*  193 */     this.jDialog8.setSize(890, 400);
/*  194 */     this.jDialog8.setVisible(false);
/*  195 */     this.jDialog8.setResizable(false);
/*      */     
/*  197 */     rw = (w - 375) / 2;
/*  198 */     rh = (h - 590) / 2;
/*  199 */     this.jDialog9.setLocation(rw, rh);
/*  200 */     this.jDialog9.setSize(375, 457);
/*  201 */     this.jDialog9.setVisible(false);
/*  202 */     this.jDialog9.setResizable(false);
/*      */     
/*  204 */     llenarCombos();
/*  205 */     colorear();
/*      */     
/*  207 */     this.con.consultar("sucursal", "configuraciones", "");
/*  208 */     this.base = this.con.Campo;
/*  209 */     this.CONFIG = this.con.regresaReg("fotosEmpleados,fotosOperadores", "configuraciones", "", 2);
/*  210 */     this.jButton14.setVisible(false);
/*      */     
/*  212 */     this.con.consultar("directiva", "configuraciones", "");
/*  213 */     this.DIRECTIVA = this.con.Campo;
/*      */     
/*  215 */     privilegios();
/*  216 */     consultar2();
/*      */   }
/*      */   private JLabel jLabel4; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JScrollPane jScrollPane1; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JScrollPane jScrollPane8; private JSeparator jSeparator1; private JSeparator jSeparator10; private JSeparator jSeparator2; private JSeparator jSeparator24; private JSeparator jSeparator25; private JSeparator jSeparator26; private JSeparator jSeparator27; private JSeparator jSeparator28; private JSeparator jSeparator29; private JSeparator jSeparator30; private JSeparator jSeparator31; private JSeparator jSeparator32; private JSeparator jSeparator8; private JSeparator jSeparator9; private JTabbedPane jTabbedPane1; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTable jTable4; private JTable jTable5; private JTable jTable6; private JTable jTable7; private JTextArea jTextArea1; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField2; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField30; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8;
/*      */   private JTextField jTextField9;
/*      */   
/*      */   private void initComponents() {
/*  222 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  223 */     this.jPanel3 = new JPanel();
/*  224 */     this.jLabel3 = new JLabel();
/*  225 */     this.jSeparator1 = new JSeparator();
/*  226 */     this.jRadioButton1 = new JRadioButton();
/*  227 */     this.jRadioButton2 = new JRadioButton();
/*  228 */     this.jLabel8 = new JLabel();
/*  229 */     this.jTabbedPane1 = new JTabbedPane();
/*  230 */     this.jPanel6 = new JPanel();
/*  231 */     this.jScrollPane1 = new JScrollPane();
/*  232 */     this.jTable1 = new JTable();
/*  233 */     this.jLabel16 = new JLabel();
/*  234 */     this.jLabel18 = new JLabel();
/*  235 */     this.jLabel19 = new JLabel();
/*  236 */     this.jScrollPane4 = new JScrollPane();
/*  237 */     this.jTable4 = new JTable();
/*  238 */     this.jButton7 = new JButton();
/*  239 */     this.jButton8 = new JButton();
/*  240 */     this.jButton9 = new JButton();
/*  241 */     this.jButton15 = new JButton();
/*  242 */     this.jPanel7 = new JPanel();
/*  243 */     this.jPanel9 = new JPanel();
/*  244 */     this.jScrollPane2 = new JScrollPane();
/*  245 */     this.jTable2 = new JTable();
/*  246 */     this.jLabel17 = new JLabel();
/*  247 */     this.jLabel20 = new JLabel();
/*  248 */     this.jLabel21 = new JLabel();
/*  249 */     this.jScrollPane5 = new JScrollPane();
/*  250 */     this.jTable5 = new JTable();
/*  251 */     this.jButton10 = new JButton();
/*  252 */     this.jButton11 = new JButton();
/*  253 */     this.jButton16 = new JButton();
/*  254 */     this.jButton17 = new JButton();
/*  255 */     this.jLabel13 = new JLabel();
/*  256 */     this.jTextField3 = new JTextField();
/*  257 */     this.jSeparator2 = new JSeparator();
/*  258 */     this.jButton3 = new JButton();
/*  259 */     this.jButton4 = new JButton();
/*  260 */     this.jTextField5 = new JTextField();
/*  261 */     this.jButton12 = new JButton();
/*  262 */     this.jLabel22 = new JLabel();
/*  263 */     this.jTextField6 = new JTextField();
/*  264 */     this.jPanel8 = new JPanel();
/*  265 */     this.jLabel10 = new JLabel();
/*  266 */     this.jComboBox6 = new JComboBox();
/*  267 */     this.jLabel14 = new JLabel();
/*  268 */     this.jDateChooser9 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  269 */     this.jLabel30 = new JLabel();
/*  270 */     this.jDateChooser10 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  271 */     this.jButton13 = new JButton();
/*  272 */     this.jPanel13 = new JPanel();
/*  273 */     this.jLabel9 = new JLabel();
/*  274 */     this.jComboBox5 = new JComboBox();
/*  275 */     this.jLabel11 = new JLabel();
/*  276 */     this.jDateChooser7 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  277 */     this.jLabel12 = new JLabel();
/*  278 */     this.jDateChooser8 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  279 */     this.jLabel24 = new JLabel();
/*  280 */     this.jTextField4 = new JTextField();
/*  281 */     this.jPanel10 = new JPanel();
/*  282 */     this.jLabel27 = new JLabel();
/*  283 */     this.jDateChooser11 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  284 */     this.jLabel28 = new JLabel();
/*  285 */     this.jDateChooser12 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  286 */     this.jLabel29 = new JLabel();
/*  287 */     this.jTextField7 = new JTextField();
/*  288 */     this.jButton14 = new JButton();
/*  289 */     this.jButton5 = new JButton();
/*  290 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  291 */     this.jPanel11 = new JPanel();
/*  292 */     this.jLabel60 = new JLabel();
/*  293 */     this.jPanel36 = new JPanel();
/*  294 */     this.jScrollPane6 = new JScrollPane();
/*  295 */     this.jTable6 = new JTable();
/*  296 */     this.jButton20 = new JButton();
/*  297 */     this.jButton21 = new JButton();
/*  298 */     this.jLabel61 = new JLabel();
/*  299 */     this.jTextField9 = new JTextField();
/*  300 */     this.jLabel62 = new JLabel();
/*  301 */     this.jTextField10 = new JTextField();
/*  302 */     this.jLabel63 = new JLabel();
/*  303 */     this.jComboBox7 = new JComboBox();
/*  304 */     this.jLabel64 = new JLabel();
/*  305 */     this.jComboBox8 = new JComboBox();
/*  306 */     this.jSeparator8 = new JSeparator();
/*  307 */     this.buttonGroup1 = new ButtonGroup();
/*  308 */     this.cantidad = new JFormattedTextField();
/*  309 */     this.aux = new JFormattedTextField();
/*  310 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  311 */     this.jPanel31 = new JPanel();
/*  312 */     this.jLabel116 = new JLabel();
/*  313 */     this.jSeparator24 = new JSeparator();
/*  314 */     this.jLabel118 = new JLabel();
/*  315 */     this.jTextField27 = new JTextField();
/*  316 */     this.jLabel119 = new JLabel();
/*  317 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  318 */     this.jSeparator25 = new JSeparator();
/*  319 */     this.jButton33 = new JButton();
/*  320 */     this.jButton34 = new JButton();
/*  321 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  322 */     this.jPanel32 = new JPanel();
/*  323 */     this.jLabel117 = new JLabel();
/*  324 */     this.jSeparator26 = new JSeparator();
/*  325 */     this.jLabel120 = new JLabel();
/*  326 */     this.jTextField28 = new JTextField();
/*  327 */     this.jLabel121 = new JLabel();
/*  328 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  329 */     this.jSeparator27 = new JSeparator();
/*  330 */     this.jButton35 = new JButton();
/*  331 */     this.jButton36 = new JButton();
/*  332 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  333 */     this.jPanel33 = new JPanel();
/*  334 */     this.jLabel126 = new JLabel();
/*  335 */     this.jSeparator31 = new JSeparator();
/*  336 */     this.jLabel127 = new JLabel();
/*  337 */     this.jButton44 = new JButton();
/*  338 */     this.jButton45 = new JButton();
/*  339 */     this.jScrollPane18 = new JScrollPane();
/*  340 */     this.jTextArea5 = new JTextArea();
/*  341 */     this.jLabel128 = new JLabel();
/*  342 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  343 */     this.jPanel34 = new JPanel();
/*  344 */     this.jLabel122 = new JLabel();
/*  345 */     this.jSeparator28 = new JSeparator();
/*  346 */     this.jLabel123 = new JLabel();
/*  347 */     this.jTextField29 = new JTextField();
/*  348 */     this.jLabel124 = new JLabel();
/*  349 */     this.jFormattedTextField5 = new JFormattedTextField();
/*  350 */     this.jSeparator29 = new JSeparator();
/*  351 */     this.jButton37 = new JButton();
/*  352 */     this.jButton38 = new JButton();
/*  353 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  354 */     this.jPanel35 = new JPanel();
/*  355 */     this.jLabel125 = new JLabel();
/*  356 */     this.jSeparator30 = new JSeparator();
/*  357 */     this.jLabel129 = new JLabel();
/*  358 */     this.jTextField30 = new JTextField();
/*  359 */     this.jLabel130 = new JLabel();
/*  360 */     this.jFormattedTextField6 = new JFormattedTextField();
/*  361 */     this.jSeparator32 = new JSeparator();
/*  362 */     this.jButton39 = new JButton();
/*  363 */     this.jButton40 = new JButton();
/*  364 */     this.jDialog8 = new CerrarVentana(this.padre);
/*  365 */     this.jPanel12 = new JPanel();
/*  366 */     this.jLabel65 = new JLabel();
/*  367 */     this.jSeparator9 = new JSeparator();
/*  368 */     this.jScrollPane7 = new JScrollPane();
/*  369 */     this.jTable7 = new JTable();
/*  370 */     this.jTextField8 = new JTextField();
/*  371 */     this.jLabel50 = new JLabel();
/*  372 */     this.jButton19 = new JButton();
/*  373 */     this.jDialog9 = new CerrarVentana(this.padre);
/*  374 */     this.jPanel14 = new JPanel();
/*  375 */     this.jLabel66 = new JLabel();
/*  376 */     this.jSeparator10 = new JSeparator();
/*  377 */     this.jLabel67 = new JLabel();
/*  378 */     this.jTextField11 = new JTextField();
/*  379 */     this.jLabel68 = new JLabel();
/*  380 */     this.jTextField12 = new JTextField();
/*  381 */     this.jButton29 = new JButton();
/*  382 */     this.jLabel53 = new JLabel();
/*  383 */     this.jPanel4 = new JPanel();
/*  384 */     this.jLabel55 = new JLabel();
/*  385 */     this.jLabel69 = new JLabel();
/*  386 */     this.jLabel70 = new JLabel();
/*  387 */     this.jLabel56 = new JLabel();
/*  388 */     this.jLabel73 = new JLabel();
/*  389 */     this.jLabel74 = new JLabel();
/*  390 */     this.jLabel75 = new JLabel();
/*  391 */     this.jLabel76 = new JLabel();
/*  392 */     this.jPanel15 = new JPanel();
/*  393 */     this.jLabel77 = new JLabel();
/*  394 */     this.jScrollPane8 = new JScrollPane();
/*  395 */     this.jTextArea1 = new JTextArea();
/*  396 */     this.jPanel1 = new JPanel();
/*  397 */     this.jLabel54 = new JLabel();
/*  398 */     this.jPanel5 = new JPanel();
/*  399 */     this.jLabel48 = new JLabel();
/*  400 */     this.jScrollPane3 = new JScrollPane();
/*  401 */     this.jTable3 = new JTable();
/*  402 */     this.jButton23 = new JButton();
/*  403 */     this.jButton24 = new JButton();
/*  404 */     this.jButton25 = new JButton();
/*  405 */     this.jButton26 = new JButton();
/*  406 */     this.jButton2 = new JButton();
/*  407 */     this.jButton27 = new JButton();
/*  408 */     this.jButton28 = new JButton();
/*  409 */     this.jPanel17 = new JPanel();
/*  410 */     this.jTextField1 = new JTextField();
/*  411 */     this.jLabel15 = new JLabel();
/*  412 */     this.jComboBox1 = new JComboBox();
/*  413 */     this.jLabel46 = new JLabel();
/*  414 */     this.jTextField2 = new JTextField();
/*  415 */     this.jLabel2 = new JLabel();
/*  416 */     this.jComboBox2 = new JComboBox();
/*  417 */     this.jLabel47 = new JLabel();
/*  418 */     this.jComboBox3 = new JComboBox();
/*  419 */     this.jLabel49 = new JLabel();
/*  420 */     this.jPanel2 = new JPanel();
/*  421 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  422 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  423 */     this.jLabel5 = new JLabel();
/*  424 */     this.jLabel6 = new JLabel();
/*  425 */     this.jLabel7 = new JLabel();
/*  426 */     this.jLabel1 = new JLabel();
/*  427 */     this.jLabel4 = new JLabel();
/*  428 */     this.jButton1 = new JButton();
/*      */     
/*  430 */     this.jDialog1.setTitle("Pago de Finiquitos");
/*  431 */     this.jDialog1.setModal(true);
/*      */     
/*  433 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*      */     
/*  435 */     this.jLabel3.setFont(new Font("Tahoma", 1, 15));
/*  436 */     this.jLabel3.setHorizontalAlignment(0);
/*  437 */     this.jLabel3.setText("FINIQUITOS");
/*      */     
/*  439 */     this.jRadioButton1.setSelected(true);
/*  440 */     this.jRadioButton1.setText("Administrativos");
/*  441 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  443 */             Finiquitos.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  447 */     this.jRadioButton2.setText("Operadores");
/*  448 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  450 */             Finiquitos.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  454 */     this.jLabel8.setHorizontalAlignment(4);
/*  455 */     this.jLabel8.setText("Trabajador:");
/*      */     
/*  457 */     this.jTabbedPane1.setTabPlacement(3);
/*      */     
/*  459 */     this.jPanel6.setBackground(new Color(255, 255, 255));
/*      */     
/*  461 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null },  }, (Object[])new String[] { "Concepto", "Días Ley", "Días del Año", "Factor en Días", "SubTotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  472 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  477 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  480 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  482 */     this.jLabel16.setText("Cálculo Básico:");
/*      */     
/*  484 */     this.jLabel18.setText("- Descuentos");
/*      */     
/*  486 */     this.jLabel19.setFont(new Font("Tahoma", 1, 15));
/*  487 */     this.jLabel19.setHorizontalAlignment(4);
/*  488 */     this.jLabel19.setText("$0.0");
/*      */     
/*  490 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  498 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  503 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  506 */     this.jScrollPane4.setViewportView(this.jTable4);
/*      */     
/*  508 */     this.jButton7.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/eliminar.png")));
/*  509 */     this.jButton7.setToolTipText("Eliminar");
/*  510 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  512 */             Finiquitos.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  516 */     this.jButton8.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/agregar (2).png")));
/*  517 */     this.jButton8.setToolTipText("Agregar");
/*  518 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  520 */             Finiquitos.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  524 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/agregar (2).png")));
/*  525 */     this.jButton9.setToolTipText("Agregar");
/*  526 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  528 */             Finiquitos.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  532 */     this.jButton15.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/eliminar.png")));
/*  533 */     this.jButton15.setToolTipText("Eliminar");
/*  534 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  536 */             Finiquitos.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  540 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  541 */     this.jPanel6.setLayout(jPanel6Layout);
/*  542 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  543 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  544 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  545 */           .addContainerGap()
/*  546 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  547 */             .addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 859, 32767)
/*  548 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/*  549 */               .addComponent(this.jLabel16, -2, 152, -2)
/*  550 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 585, 32767)
/*  551 */               .addComponent(this.jButton9, -2, 58, -2)
/*  552 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  553 */               .addComponent(this.jButton15, -2, 58, -2))
/*  554 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  555 */               .addComponent(this.jLabel18, -2, 152, -2)
/*  556 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 585, 32767)
/*  557 */               .addComponent(this.jButton8, -2, 58, -2)
/*  558 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  559 */               .addComponent(this.jButton7, -2, 58, -2))
/*  560 */             .addComponent(this.jLabel19, GroupLayout.Alignment.TRAILING, -2, 140, -2)
/*  561 */             .addComponent(this.jScrollPane4, -1, 859, 32767))
/*  562 */           .addContainerGap()));
/*      */     
/*  564 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  565 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  566 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  567 */           .addContainerGap()
/*  568 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  569 */             .addComponent(this.jButton15)
/*  570 */             .addComponent(this.jButton9)
/*  571 */             .addComponent(this.jLabel16))
/*  572 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  573 */           .addComponent(this.jScrollPane1, -2, 108, -2)
/*  574 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  575 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  576 */             .addComponent(this.jLabel18)
/*  577 */             .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  578 */               .addComponent(this.jButton7)
/*  579 */               .addComponent(this.jButton8)))
/*  580 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  581 */           .addComponent(this.jScrollPane4, -2, 78, -2)
/*  582 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  583 */           .addComponent(this.jLabel19)
/*  584 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  587 */     this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/*      */     
/*  589 */     this.jPanel9.setBackground(new Color(255, 255, 255));
/*      */     
/*  591 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null },  }, (Object[])new String[] { "Concepto", "Días Ley", "Días del Año", "Factor en Días", "SubTotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  602 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  607 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  610 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/*  612 */     this.jLabel17.setText("Cálculo Básico:");
/*      */     
/*  614 */     this.jLabel20.setText("- Descuentos");
/*      */     
/*  616 */     this.jLabel21.setFont(new Font("Tahoma", 1, 15));
/*  617 */     this.jLabel21.setHorizontalAlignment(4);
/*  618 */     this.jLabel21.setText("$0.0");
/*      */     
/*  620 */     this.jTable5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  628 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  633 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  636 */     this.jScrollPane5.setViewportView(this.jTable5);
/*      */     
/*  638 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/eliminar.png")));
/*  639 */     this.jButton10.setToolTipText("Eliminar");
/*  640 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  642 */             Finiquitos.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  646 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/agregar (2).png")));
/*  647 */     this.jButton11.setToolTipText("Agregar");
/*  648 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  650 */             Finiquitos.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  654 */     this.jButton16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/agregar (2).png")));
/*  655 */     this.jButton16.setToolTipText("Agregar");
/*  656 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  658 */             Finiquitos.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  662 */     this.jButton17.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/eliminar.png")));
/*  663 */     this.jButton17.setToolTipText("Eliminar");
/*  664 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  666 */             Finiquitos.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  670 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  671 */     this.jPanel9.setLayout(jPanel9Layout);
/*  672 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  673 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  674 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  675 */           .addContainerGap()
/*  676 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  677 */             .addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 859, 32767)
/*  678 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  679 */               .addComponent(this.jLabel17, -2, 152, -2)
/*  680 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 585, 32767)
/*  681 */               .addComponent(this.jButton16, -2, 58, -2)
/*  682 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  683 */               .addComponent(this.jButton17, -2, 58, -2))
/*  684 */             .addComponent(this.jScrollPane5, GroupLayout.Alignment.LEADING, -1, 859, 32767)
/*  685 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  686 */               .addComponent(this.jLabel20, -2, 152, -2)
/*  687 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 585, 32767)
/*  688 */               .addComponent(this.jButton11, -2, 58, -2)
/*  689 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  690 */               .addComponent(this.jButton10, -2, 58, -2))
/*  691 */             .addComponent(this.jLabel21, -2, 140, -2))
/*  692 */           .addContainerGap()));
/*      */     
/*  694 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  695 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  696 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  697 */           .addContainerGap()
/*  698 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  699 */             .addComponent(this.jButton17)
/*  700 */             .addComponent(this.jButton16)
/*  701 */             .addComponent(this.jLabel17))
/*  702 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  703 */           .addComponent(this.jScrollPane2, -2, 111, -2)
/*  704 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  705 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  706 */             .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  707 */               .addComponent(this.jButton10)
/*  708 */               .addComponent(this.jButton11))
/*  709 */             .addComponent(this.jLabel20))
/*  710 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  711 */           .addComponent(this.jScrollPane5, -2, 81, -2)
/*  712 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  713 */           .addComponent(this.jLabel21)
/*  714 */           .addContainerGap()));
/*      */ 
/*      */     
/*  717 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  718 */     this.jPanel7.setLayout(jPanel7Layout);
/*  719 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  720 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  721 */         .addGap(0, 879, 32767)
/*  722 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  723 */           .addComponent(this.jPanel9, -1, -1, 32767)));
/*      */     
/*  725 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  726 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  727 */         .addGap(0, 301, 32767)
/*  728 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  729 */           .addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767)));
/*      */ 
/*      */     
/*  732 */     this.jTabbedPane1.addTab("Imss", this.jPanel7);
/*      */     
/*  734 */     this.jLabel13.setFont(new Font("Tahoma", 1, 15));
/*  735 */     this.jLabel13.setHorizontalAlignment(4);
/*  736 */     this.jLabel13.setText("$0.0");
/*      */     
/*  738 */     this.jTextField3.setEditable(false);
/*  739 */     this.jTextField3.setFont(new Font("Tahoma", 1, 15));
/*  740 */     this.jTextField3.setText("Cero pesos  M.N.");
/*      */     
/*  742 */     this.jButton3.setText("Cerrar");
/*  743 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  745 */             Finiquitos.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  749 */     this.jButton4.setText("Guardar");
/*  750 */     this.jButton4.setToolTipText("");
/*  751 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  753 */             Finiquitos.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  757 */     this.jTextField5.setEditable(false);
/*      */     
/*  759 */     this.jButton12.setMnemonic('B');
/*  760 */     this.jButton12.setText("Buscar");
/*  761 */     this.jButton12.setToolTipText("Buscar (Alt+B)");
/*  762 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  764 */             Finiquitos.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  768 */     this.jLabel22.setText("Folio:");
/*      */     
/*  770 */     this.jTextField6.setFont(new Font("Tahoma", 1, 11));
/*  771 */     this.jTextField6.setEnabled(false);
/*      */     
/*  773 */     this.jPanel8.setBackground(new Color(255, 255, 255));
/*  774 */     this.jPanel8.setBorder(BorderFactory.createTitledBorder("Información del reporte"));
/*      */     
/*  776 */     this.jLabel10.setText("Departamento");
/*      */     
/*  778 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*      */     
/*  780 */     this.jLabel14.setText("Ingreso:");
/*      */     
/*  782 */     this.jDateChooser9.setDate(this.fechaActual);
/*  783 */     this.jDateChooser9.setDateFormatString("dd/MM/yyyy");
/*  784 */     this.jDateChooser9.setEnabled(false);
/*  785 */     this.jDateChooser9.setIcon(this.icon);
/*  786 */     this.jDateChooser9.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/*  788 */     this.jLabel30.setText("Fecha del finiquito");
/*      */     
/*  790 */     this.jDateChooser10.setDate(this.fechaActual);
/*  791 */     this.jDateChooser10.setDateFormatString("dd/MM/yyyy");
/*  792 */     this.jDateChooser10.setIcon(this.icon);
/*  793 */     this.jDateChooser10.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/*  795 */     this.jButton13.setMnemonic('L');
/*  796 */     this.jButton13.setText("Calcular");
/*  797 */     this.jButton13.setToolTipText("Calcular Días (Alt+L)");
/*  798 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  800 */             Finiquitos.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  804 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  805 */     this.jPanel8.setLayout(jPanel8Layout);
/*  806 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  807 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  808 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/*  809 */           .addContainerGap()
/*  810 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  811 */             .addComponent(this.jLabel14, -1, 105, 32767)
/*  812 */             .addComponent(this.jLabel30, -2, 102, -2)
/*  813 */             .addComponent(this.jLabel10, -2, 91, -2))
/*  814 */           .addGap(18, 18, 18)
/*  815 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  816 */             .addComponent(this.jButton13, -2, 85, -2)
/*  817 */             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  818 */               .addComponent((Component)this.jDateChooser10, -1, -1, 32767)
/*  819 */               .addComponent((Component)this.jDateChooser9, -1, -1, 32767)
/*  820 */               .addComponent(this.jComboBox6, 0, 133, 32767)))
/*  821 */           .addGap(12, 12, 12)));
/*      */     
/*  823 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  824 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  825 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  826 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  827 */             .addComponent(this.jLabel10)
/*  828 */             .addComponent(this.jComboBox6, -2, -1, -2))
/*  829 */           .addGap(8, 8, 8)
/*  830 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  831 */             .addComponent(this.jLabel14, -1, -1, 32767)
/*  832 */             .addComponent((Component)this.jDateChooser9, -1, -1, 32767))
/*  833 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  834 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  835 */             .addComponent(this.jLabel30, -1, -1, 32767)
/*  836 */             .addComponent((Component)this.jDateChooser10, -1, -1, 32767))
/*  837 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  838 */           .addComponent(this.jButton13)
/*  839 */           .addContainerGap()));
/*      */ 
/*      */     
/*  842 */     this.jPanel13.setBackground(new Color(255, 255, 255));
/*  843 */     this.jPanel13.setBorder(BorderFactory.createTitledBorder("Información de las vacaciones"));
/*      */     
/*  845 */     this.jLabel9.setText("Selecciona el periodo:");
/*      */     
/*  847 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  848 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "1 AÑO (12 Días)", "2 AÑOS (14 Días)", "3 AÑOS (16 Días)", "4 AÑOS (18 Días)", "5 AÑOS (20 Días)", "6 AÑOS (22 Días)", "7 AÑOS (22Días)", "8 AÑOS (22 Días)", "9 AÑOS (22 Días)", "10 AÑOS (22 Días)", "11 AÑOS (24 Días)", "12 AÑOS (24 Días)", "13 AÑOS (24 Días)", "14 AÑOS (24 Días)", "15 AÑOS (24 Días)", "16 AÑOS (26 Días)", "17 AÑOS (26 Días)", "18 AÑOS (26 Días)", "19 AÑOS (26 Días)", "20 AÑOS (26 Días)", "21 AÑOS (28 Días)", "22 AÑOS (28 Días)", "23 AÑOS (28 Días)", "24 AÑOS (28 Días)", "25 AÑOS (28 Días)", "26 AÑOS (30 Días)", "27 AÑOS (30 Días)", "28 AÑOS (30 Días)", "29 AÑOS (30 Días)", "30 AÑOS (30 Días)", "31 AÑOS (32 Días)", "32 AÑOS (32 Días)", "33 AÑOS (32 Días)", "34 AÑOS (32 Días)", "35 AÑOS (32 Días)", "36 AÑOS (34 Días)", "37 AÑOS (34 Días)", "38 AÑOS (34 Días)", "39 AÑOS (34 Días)", "40 AÑOS (34 Días)" }));
/*  849 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  851 */             Finiquitos.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  855 */     this.jLabel11.setText("Fecha de inicio");
/*      */     
/*  857 */     this.jDateChooser7.setDate(this.fechaActual);
/*  858 */     this.jDateChooser7.setDateFormatString("dd/MM/yyyy");
/*  859 */     this.jDateChooser7.setIcon(this.icon);
/*  860 */     this.jDateChooser7.setMinSelectableDate(new Date(631177262000L));
/*      */     
/*  862 */     this.jLabel12.setText("Fecha final");
/*      */     
/*  864 */     this.jDateChooser8.setDate(this.fechaActual);
/*  865 */     this.jDateChooser8.setDateFormatString("dd/MM/yyyy");
/*  866 */     this.jDateChooser8.setIcon(this.icon);
/*  867 */     this.jDateChooser8.setMinSelectableDate(new Date(631177262000L));
/*      */     
/*  869 */     this.jLabel24.setText("Días");
/*      */     
/*  871 */     this.jTextField4.setHorizontalAlignment(0);
/*  872 */     this.jTextField4.setEnabled(false);
/*      */     
/*  874 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/*  875 */     this.jPanel13.setLayout(jPanel13Layout);
/*  876 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/*  877 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  878 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  879 */           .addContainerGap()
/*  880 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  881 */             .addGroup(jPanel13Layout.createSequentialGroup()
/*  882 */               .addComponent(this.jLabel24, -2, 115, -2)
/*  883 */               .addGap(22, 22, 22))
/*  884 */             .addGroup(jPanel13Layout.createSequentialGroup()
/*  885 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  886 */                 .addComponent(this.jLabel12, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  887 */                 .addComponent(this.jLabel11, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  888 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/*  889 */                   .addComponent(this.jLabel9, -2, 133, -2)
/*  890 */                   .addGap(0, 0, 32767)))
/*  891 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
/*  892 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  893 */             .addComponent(this.jComboBox5, 0, 141, 32767)
/*  894 */             .addGroup(jPanel13Layout.createSequentialGroup()
/*  895 */               .addComponent(this.jTextField4, -2, 57, -2)
/*  896 */               .addGap(0, 0, 32767))
/*  897 */             .addComponent((Component)this.jDateChooser8, GroupLayout.Alignment.TRAILING, -1, 141, 32767)
/*  898 */             .addComponent((Component)this.jDateChooser7, GroupLayout.Alignment.TRAILING, -1, -1, 32767))
/*  899 */           .addContainerGap()));
/*      */     
/*  901 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/*  902 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  903 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  904 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  905 */             .addComponent(this.jLabel9)
/*  906 */             .addComponent(this.jComboBox5, -2, -1, -2))
/*  907 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  908 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  909 */             .addComponent(this.jLabel11, -1, -1, 32767)
/*  910 */             .addComponent((Component)this.jDateChooser7, -1, -1, 32767))
/*  911 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  912 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  913 */             .addComponent(this.jLabel12, -1, -1, 32767)
/*  914 */             .addComponent((Component)this.jDateChooser8, -1, -1, 32767))
/*  915 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  916 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  917 */             .addComponent(this.jTextField4, -2, -1, -2)
/*  918 */             .addComponent(this.jLabel24))
/*  919 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  922 */     this.jPanel10.setBackground(new Color(255, 255, 255));
/*  923 */     this.jPanel10.setBorder(BorderFactory.createTitledBorder("Información del aguinaldo"));
/*      */     
/*  925 */     this.jLabel27.setText("Fecha de inicio");
/*      */     
/*  927 */     this.jDateChooser11.setDate(this.fechaActual);
/*  928 */     this.jDateChooser11.setDateFormatString("dd/MM/yyyy");
/*  929 */     this.jDateChooser11.setIcon(this.icon);
/*  930 */     this.jDateChooser11.setMinSelectableDate(new Date(631177262000L));
/*      */     
/*  932 */     this.jLabel28.setText("Fecha final");
/*      */     
/*  934 */     this.jDateChooser12.setDate(this.fechaActual);
/*  935 */     this.jDateChooser12.setDateFormatString("dd/MM/yyyy");
/*  936 */     this.jDateChooser12.setIcon(this.icon);
/*  937 */     this.jDateChooser12.setMinSelectableDate(new Date(631177262000L));
/*      */     
/*  939 */     this.jLabel29.setText("Días");
/*      */     
/*  941 */     this.jTextField7.setHorizontalAlignment(0);
/*  942 */     this.jTextField7.setEnabled(false);
/*      */     
/*  944 */     this.jButton14.setMnemonic('L');
/*  945 */     this.jButton14.setText("Calcular");
/*  946 */     this.jButton14.setToolTipText("Calcular Días (Alt+L)");
/*  947 */     this.jButton14.setEnabled(false);
/*  948 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  950 */             Finiquitos.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  954 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  955 */     this.jPanel10.setLayout(jPanel10Layout);
/*  956 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/*  957 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  958 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  959 */           .addContainerGap()
/*  960 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  961 */             .addComponent(this.jLabel28, -1, -1, 32767)
/*  962 */             .addComponent(this.jLabel29, -1, -1, 32767)
/*  963 */             .addComponent(this.jLabel27, -2, 98, -2))
/*  964 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  965 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  966 */             .addGroup(jPanel10Layout.createSequentialGroup()
/*  967 */               .addComponent(this.jTextField7, -2, 51, -2)
/*  968 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  969 */               .addComponent(this.jButton14))
/*  970 */             .addComponent((Component)this.jDateChooser11, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  971 */             .addComponent((Component)this.jDateChooser12, GroupLayout.Alignment.TRAILING, -1, -1, 32767))
/*  972 */           .addContainerGap()));
/*      */     
/*  974 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/*  975 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  976 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  977 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  978 */             .addGroup(jPanel10Layout.createSequentialGroup()
/*  979 */               .addComponent(this.jLabel27, -2, 19, -2)
/*  980 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  981 */               .addComponent(this.jLabel28, -1, -1, 32767))
/*  982 */             .addGroup(jPanel10Layout.createSequentialGroup()
/*  983 */               .addComponent((Component)this.jDateChooser11, -2, -1, -2)
/*  984 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  985 */               .addComponent((Component)this.jDateChooser12, -2, -1, -2)))
/*  986 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  987 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  988 */             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  989 */               .addComponent(this.jTextField7, -2, -1, -2)
/*  990 */               .addComponent(this.jButton14))
/*  991 */             .addComponent(this.jLabel29))
/*  992 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  995 */     this.jButton5.setMnemonic('T');
/*  996 */     this.jButton5.setText("Consultar T.D.");
/*  997 */     this.jButton5.setToolTipText("Consultar T.D. (Alt+T)");
/*  998 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1000 */             Finiquitos.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1004 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1005 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1006 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 1007 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1008 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1009 */           .addContainerGap()
/* 1010 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1011 */             .addGroup(jPanel3Layout.createSequentialGroup()
/* 1012 */               .addComponent(this.jLabel22, -2, 54, -2)
/* 1013 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1014 */               .addComponent(this.jTextField6, -2, 145, -2)
/* 1015 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1016 */               .addComponent(this.jLabel3, -2, 430, -2))
/* 1017 */             .addGroup(jPanel3Layout.createSequentialGroup()
/* 1018 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1019 */                 .addComponent(this.jTabbedPane1)
/* 1020 */                 .addComponent(this.jSeparator1)
/* 1021 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/* 1022 */                   .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1023 */                     .addGroup(jPanel3Layout.createSequentialGroup()
/* 1024 */                       .addGap(10, 10, 10)
/* 1025 */                       .addComponent(this.jRadioButton1, -2, 129, -2)
/* 1026 */                       .addGap(8, 8, 8)
/* 1027 */                       .addComponent(this.jRadioButton2, -2, 129, -2))
/* 1028 */                     .addComponent(this.jPanel8, -2, -1, -2))
/* 1029 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1030 */                   .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1031 */                     .addGroup(jPanel3Layout.createSequentialGroup()
/* 1032 */                       .addGap(10, 10, 10)
/* 1033 */                       .addComponent(this.jLabel8, -2, 72, -2)
/* 1034 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1035 */                       .addComponent(this.jTextField5, -2, 234, -2)
/* 1036 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1037 */                       .addComponent(this.jButton12))
/* 1038 */                     .addGroup(jPanel3Layout.createSequentialGroup()
/* 1039 */                       .addComponent(this.jPanel13, -2, -1, -2)
/* 1040 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1041 */                       .addComponent(this.jPanel10, -1, -1, 32767))))
/* 1042 */                 .addGroup(jPanel3Layout.createSequentialGroup()
/* 1043 */                   .addComponent(this.jTextField3)
/* 1044 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1045 */                   .addComponent(this.jLabel13, -2, 119, -2)
/* 1046 */                   .addGap(14, 14, 14))
/* 1047 */                 .addComponent(this.jSeparator2)
/* 1048 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/* 1049 */                   .addComponent(this.jButton5, -2, 120, -2)
/* 1050 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1051 */                   .addComponent(this.jButton4, -2, 97, -2)
/* 1052 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1053 */                   .addComponent(this.jButton3, -2, 97, -2)))
/* 1054 */               .addContainerGap()))));
/*      */     
/* 1056 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 1057 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1058 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1059 */           .addContainerGap()
/* 1060 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1061 */             .addComponent(this.jLabel3)
/* 1062 */             .addComponent(this.jTextField6, -2, -1, -2)
/* 1063 */             .addComponent(this.jLabel22))
/* 1064 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1065 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 1066 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1067 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1068 */             .addComponent(this.jRadioButton2, -1, 30, 32767)
/* 1069 */             .addComponent(this.jLabel8)
/* 1070 */             .addComponent(this.jTextField5, -2, -1, -2)
/* 1071 */             .addComponent(this.jButton12)
/* 1072 */             .addComponent(this.jRadioButton1, -2, 28, -2))
/* 1073 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1074 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1075 */             .addComponent(this.jPanel10, -1, -1, 32767)
/* 1076 */             .addComponent(this.jPanel8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1077 */             .addComponent(this.jPanel13, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1078 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1079 */           .addComponent(this.jTabbedPane1, -2, 329, -2)
/* 1080 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1081 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1082 */             .addComponent(this.jTextField3, -2, -1, -2)
/* 1083 */             .addComponent(this.jLabel13, -1, -1, 32767))
/* 1084 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1085 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 1086 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1087 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1088 */             .addComponent(this.jButton3)
/* 1089 */             .addComponent(this.jButton4)
/* 1090 */             .addComponent(this.jButton5))
/* 1091 */           .addGap(23, 23, 23)));
/*      */ 
/*      */     
/* 1094 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 1095 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 1096 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 1097 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1098 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/* 1100 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 1101 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1102 */         .addComponent(this.jPanel3, -2, -1, -2));
/*      */ 
/*      */     
/* 1105 */     this.jDialog2.setTitle("Búsqueda de Operadores");
/* 1106 */     this.jDialog2.setModal(true);
/*      */     
/* 1108 */     this.jPanel11.setBackground(new Color(146, 193, 134));
/*      */     
/* 1110 */     this.jLabel60.setFont(new Font("Tahoma", 1, 16));
/* 1111 */     this.jLabel60.setForeground(new Color(0, 102, 102));
/* 1112 */     this.jLabel60.setHorizontalAlignment(0);
/* 1113 */     this.jLabel60.setText("Busqueda de Empleados");
/*      */     
/* 1115 */     this.jPanel36.setBackground(new Color(146, 193, 134));
/* 1116 */     this.jPanel36.setBorder(BorderFactory.createTitledBorder(null, "Listado de Empleados", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1118 */     this.jTable6.setFont(new Font("Tahoma", 0, 10));
/* 1119 */     this.jTable6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1127 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1132 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1135 */     this.jTable6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1137 */             Finiquitos.this.jTable6MouseClicked(evt);
/*      */           }
/*      */         });
/* 1140 */     this.jScrollPane6.setViewportView(this.jTable6);
/*      */     
/* 1142 */     this.jButton20.setMnemonic('A');
/* 1143 */     this.jButton20.setText("Asignar");
/* 1144 */     this.jButton20.setToolTipText("Asignar (Alt+A)");
/* 1145 */     this.jButton20.setEnabled(false);
/* 1146 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1148 */             Finiquitos.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1152 */     this.jButton21.setMnemonic('C');
/* 1153 */     this.jButton21.setText("Cerrar");
/* 1154 */     this.jButton21.setToolTipText("Cerrar (Alt+C)");
/* 1155 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1157 */             Finiquitos.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1161 */     this.jLabel61.setFont(new Font("Tahoma", 2, 11));
/* 1162 */     this.jLabel61.setForeground(new Color(15, 87, 51));
/* 1163 */     this.jLabel61.setHorizontalAlignment(4);
/* 1164 */     this.jLabel61.setText("Clave");
/*      */     
/* 1166 */     this.jTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1168 */             Finiquitos.this.jTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1172 */     this.jLabel62.setFont(new Font("Tahoma", 2, 11));
/* 1173 */     this.jLabel62.setForeground(new Color(15, 87, 51));
/* 1174 */     this.jLabel62.setHorizontalAlignment(4);
/* 1175 */     this.jLabel62.setText("Nombre");
/*      */     
/* 1177 */     this.jTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1179 */             Finiquitos.this.jTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1183 */     this.jLabel63.setFont(new Font("Tahoma", 2, 11));
/* 1184 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/* 1185 */     this.jLabel63.setHorizontalAlignment(4);
/* 1186 */     this.jLabel63.setText("Tipo");
/*      */     
/* 1188 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 1189 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "TRABAJADOR", "FUNCIONARIO", "TODOS" }));
/* 1190 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1192 */             Finiquitos.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1196 */     this.jLabel64.setFont(new Font("Tahoma", 2, 11));
/* 1197 */     this.jLabel64.setForeground(new Color(15, 87, 51));
/* 1198 */     this.jLabel64.setHorizontalAlignment(4);
/* 1199 */     this.jLabel64.setText("Depto");
/*      */     
/* 1201 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 1202 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "TRABAJADOR", "FUNCIONARIO", "TODOS" }));
/* 1203 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1205 */             Finiquitos.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1209 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 1210 */     this.jPanel36.setLayout(jPanel36Layout);
/* 1211 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 1212 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1213 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 1214 */           .addContainerGap()
/* 1215 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1216 */             .addComponent(this.jScrollPane6, -1, 693, 32767)
/* 1217 */             .addGroup(jPanel36Layout.createSequentialGroup()
/* 1218 */               .addComponent(this.jLabel61, -2, 32, -2)
/* 1219 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1220 */               .addComponent(this.jTextField9, -2, 46, -2)
/* 1221 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1222 */               .addComponent(this.jLabel62, -2, 46, -2)
/* 1223 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1224 */               .addComponent(this.jTextField10, -2, 148, -2)
/* 1225 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1226 */               .addComponent(this.jLabel63, -2, 37, -2)
/* 1227 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1228 */               .addComponent(this.jComboBox7, -2, 162, -2)
/* 1229 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1230 */               .addComponent(this.jLabel64, -2, 38, -2)
/* 1231 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1232 */               .addComponent(this.jComboBox8, -2, 156, -2))
/* 1233 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/* 1234 */               .addComponent(this.jButton20, -2, 92, -2)
/* 1235 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1236 */               .addComponent(this.jButton21, -2, 83, -2)))
/* 1237 */           .addContainerGap()));
/*      */     
/* 1239 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 1240 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1241 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 1242 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1243 */             .addComponent(this.jLabel61)
/* 1244 */             .addComponent(this.jTextField9, -2, -1, -2)
/* 1245 */             .addComponent(this.jLabel62)
/* 1246 */             .addComponent(this.jTextField10, -2, -1, -2)
/* 1247 */             .addComponent(this.jLabel63)
/* 1248 */             .addComponent(this.jComboBox7, -2, -1, -2)
/* 1249 */             .addComponent(this.jLabel64)
/* 1250 */             .addComponent(this.jComboBox8, -2, -1, -2))
/* 1251 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1252 */           .addComponent(this.jScrollPane6, -1, 210, 32767)
/* 1253 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1254 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1255 */             .addComponent(this.jButton21)
/* 1256 */             .addComponent(this.jButton20))
/* 1257 */           .addGap(13, 13, 13)));
/*      */ 
/*      */     
/* 1260 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1261 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1262 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1263 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1264 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1265 */           .addContainerGap()
/* 1266 */           .addComponent(this.jSeparator8, -1, 723, 32767)
/* 1267 */           .addContainerGap())
/* 1268 */         .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1269 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 1270 */             .addGap(8, 8, 8)
/* 1271 */             .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1272 */               .addComponent(this.jPanel36, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1273 */               .addComponent(this.jLabel60, GroupLayout.Alignment.LEADING, -1, 725, 32767))
/* 1274 */             .addGap(10, 10, 10))));
/*      */     
/* 1276 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1277 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1278 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1279 */           .addGap(31, 31, 31)
/* 1280 */           .addComponent(this.jSeparator8, -2, 10, -2)
/* 1281 */           .addContainerGap(322, 32767))
/* 1282 */         .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1283 */           .addGroup(jPanel11Layout.createSequentialGroup()
/* 1284 */             .addContainerGap()
/* 1285 */             .addComponent(this.jLabel60)
/* 1286 */             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1287 */             .addComponent(this.jPanel36, -2, -1, -2)
/* 1288 */             .addContainerGap(-1, 32767))));
/*      */ 
/*      */     
/* 1291 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1292 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1293 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1294 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1295 */         .addComponent(this.jPanel11, -1, -1, 32767));
/*      */     
/* 1297 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1298 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1299 */         .addComponent(this.jPanel11, -1, -1, 32767));
/*      */ 
/*      */     
/* 1302 */     this.cantidad.setText("jFormattedTextField1");
/*      */     
/* 1304 */     this.aux.setText("jFormattedTextField1");
/*      */     
/* 1306 */     this.jDialog3.setTitle("Agrega conceptos");
/*      */     
/* 1308 */     this.jPanel31.setBackground(new Color(255, 255, 255));
/*      */     
/* 1310 */     this.jLabel116.setFont(new Font("Times New Roman", 1, 14));
/* 1311 */     this.jLabel116.setHorizontalAlignment(0);
/* 1312 */     this.jLabel116.setText("Coloca el descuento");
/*      */     
/* 1314 */     this.jLabel118.setFont(new Font("Tahoma", 1, 11));
/* 1315 */     this.jLabel118.setHorizontalAlignment(0);
/* 1316 */     this.jLabel118.setText("Concepto");
/*      */     
/* 1318 */     this.jLabel119.setFont(new Font("Tahoma", 1, 11));
/* 1319 */     this.jLabel119.setHorizontalAlignment(0);
/* 1320 */     this.jLabel119.setText("P Unitario");
/*      */     
/* 1322 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/*      */     
/* 1324 */     this.jButton33.setMnemonic('C');
/* 1325 */     this.jButton33.setText("Cerrar");
/* 1326 */     this.jButton33.setToolTipText("Cerrar (Alt+C)");
/* 1327 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1329 */             Finiquitos.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1333 */     this.jButton34.setMnemonic('A');
/* 1334 */     this.jButton34.setText("Agregar");
/* 1335 */     this.jButton34.setToolTipText("Agregar (Alt+A)");
/* 1336 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1338 */             Finiquitos.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1342 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 1343 */     this.jPanel31.setLayout(jPanel31Layout);
/* 1344 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 1345 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1346 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
/* 1347 */           .addContainerGap()
/* 1348 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1349 */             .addComponent(this.jLabel116, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1350 */             .addComponent(this.jSeparator24, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1351 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel31Layout.createSequentialGroup()
/* 1352 */               .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1353 */                 .addComponent(this.jTextField27, GroupLayout.Alignment.LEADING, -1, 432, 32767)
/* 1354 */                 .addComponent(this.jLabel118, GroupLayout.Alignment.LEADING, -1, 432, 32767))
/* 1355 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1356 */               .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1357 */                 .addComponent(this.jFormattedTextField3, 0, 0, 32767)
/* 1358 */                 .addComponent(this.jLabel119, -2, 97, -2)))
/* 1359 */             .addComponent(this.jSeparator25, -1, 535, 32767)
/* 1360 */             .addGroup(jPanel31Layout.createSequentialGroup()
/* 1361 */               .addComponent(this.jButton34, -2, 83, -2)
/* 1362 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1363 */               .addComponent(this.jButton33, -2, 83, -2)))
/* 1364 */           .addContainerGap()));
/*      */     
/* 1366 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 1367 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1368 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1369 */           .addComponent(this.jLabel116)
/* 1370 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1371 */           .addComponent(this.jSeparator24, -2, 10, -2)
/* 1372 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1373 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1374 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
/* 1375 */               .addComponent(this.jLabel118)
/* 1376 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1377 */               .addComponent(this.jTextField27, -2, -1, -2))
/* 1378 */             .addGroup(jPanel31Layout.createSequentialGroup()
/* 1379 */               .addComponent(this.jLabel119)
/* 1380 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1381 */               .addComponent(this.jFormattedTextField3, -2, -1, -2)))
/* 1382 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1383 */           .addComponent(this.jSeparator25, -2, 10, -2)
/* 1384 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1385 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1386 */             .addComponent(this.jButton33)
/* 1387 */             .addComponent(this.jButton34))
/* 1388 */           .addContainerGap(22, 32767)));
/*      */ 
/*      */     
/* 1391 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1392 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1393 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1394 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1395 */         .addComponent(this.jPanel31, -2, -1, -2));
/*      */     
/* 1397 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1398 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1399 */         .addComponent(this.jPanel31, -2, -1, -2));
/*      */ 
/*      */     
/* 1402 */     this.jDialog4.setTitle("Agrega conceptos");
/*      */     
/* 1404 */     this.jPanel32.setBackground(new Color(255, 255, 255));
/*      */     
/* 1406 */     this.jLabel117.setFont(new Font("Times New Roman", 1, 14));
/* 1407 */     this.jLabel117.setHorizontalAlignment(0);
/* 1408 */     this.jLabel117.setText("Coloca el descuento");
/*      */     
/* 1410 */     this.jLabel120.setFont(new Font("Tahoma", 1, 11));
/* 1411 */     this.jLabel120.setHorizontalAlignment(0);
/* 1412 */     this.jLabel120.setText("Concepto");
/*      */     
/* 1414 */     this.jLabel121.setFont(new Font("Tahoma", 1, 11));
/* 1415 */     this.jLabel121.setHorizontalAlignment(0);
/* 1416 */     this.jLabel121.setText("P Unitario");
/*      */     
/* 1418 */     this.jFormattedTextField4.setHorizontalAlignment(4);
/*      */     
/* 1420 */     this.jButton35.setMnemonic('C');
/* 1421 */     this.jButton35.setText("Cerrar");
/* 1422 */     this.jButton35.setToolTipText("Cerrar (Alt+C)");
/* 1423 */     this.jButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1425 */             Finiquitos.this.jButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1429 */     this.jButton36.setMnemonic('A');
/* 1430 */     this.jButton36.setText("Agregar");
/* 1431 */     this.jButton36.setToolTipText("Agregar (Alt+A)");
/* 1432 */     this.jButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1434 */             Finiquitos.this.jButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1438 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/* 1439 */     this.jPanel32.setLayout(jPanel32Layout);
/* 1440 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/* 1441 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1442 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 1443 */           .addContainerGap()
/* 1444 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1445 */             .addComponent(this.jLabel117, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1446 */             .addComponent(this.jSeparator26, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1447 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel32Layout.createSequentialGroup()
/* 1448 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1449 */                 .addComponent(this.jTextField28, GroupLayout.Alignment.LEADING, -1, 432, 32767)
/* 1450 */                 .addComponent(this.jLabel120, GroupLayout.Alignment.LEADING, -1, 432, 32767))
/* 1451 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1452 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1453 */                 .addComponent(this.jFormattedTextField4, 0, 0, 32767)
/* 1454 */                 .addComponent(this.jLabel121, -2, 97, -2)))
/* 1455 */             .addComponent(this.jSeparator27, -1, 535, 32767)
/* 1456 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 1457 */               .addComponent(this.jButton36, -2, 83, -2)
/* 1458 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1459 */               .addComponent(this.jButton35, -2, 83, -2)))
/* 1460 */           .addContainerGap()));
/*      */     
/* 1462 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/* 1463 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1464 */         .addGroup(jPanel32Layout.createSequentialGroup()
/* 1465 */           .addComponent(this.jLabel117)
/* 1466 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1467 */           .addComponent(this.jSeparator26, -2, 10, -2)
/* 1468 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1469 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1470 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 1471 */               .addComponent(this.jLabel120)
/* 1472 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1473 */               .addComponent(this.jTextField28, -2, -1, -2))
/* 1474 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 1475 */               .addComponent(this.jLabel121)
/* 1476 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1477 */               .addComponent(this.jFormattedTextField4, -2, -1, -2)))
/* 1478 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1479 */           .addComponent(this.jSeparator27, -2, 10, -2)
/* 1480 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1481 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1482 */             .addComponent(this.jButton35)
/* 1483 */             .addComponent(this.jButton36))
/* 1484 */           .addContainerGap(22, 32767)));
/*      */ 
/*      */     
/* 1487 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1488 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1489 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1490 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1491 */         .addComponent(this.jPanel32, -2, -1, -2));
/*      */     
/* 1493 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1494 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1495 */         .addComponent(this.jPanel32, -2, -1, -2));
/*      */ 
/*      */     
/* 1498 */     this.jDialog7.setTitle("Cancelar Finiquitos");
/* 1499 */     this.jDialog7.setModal(true);
/*      */     
/* 1501 */     this.jPanel33.setBackground(new Color(146, 193, 134));
/*      */     
/* 1503 */     this.jLabel126.setFont(new Font("Tahoma", 1, 14));
/* 1504 */     this.jLabel126.setForeground(new Color(0, 102, 102));
/* 1505 */     this.jLabel126.setHorizontalAlignment(0);
/* 1506 */     this.jLabel126.setText("Motivo de la Cancelación");
/*      */     
/* 1508 */     this.jLabel127.setFont(new Font("Tahoma", 3, 11));
/* 1509 */     this.jLabel127.setForeground(new Color(15, 87, 51));
/* 1510 */     this.jLabel127.setHorizontalAlignment(4);
/* 1511 */     this.jLabel127.setText("Motivo");
/*      */     
/* 1513 */     this.jButton44.setMnemonic('A');
/* 1514 */     this.jButton44.setText("Cancelar Finiquitos");
/* 1515 */     this.jButton44.setToolTipText("Cancelar Vacaciones (Alt+A)");
/* 1516 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1518 */             Finiquitos.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1522 */     this.jButton45.setMnemonic('C');
/* 1523 */     this.jButton45.setText("Cerrar");
/* 1524 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 1525 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1527 */             Finiquitos.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1531 */     this.jTextArea5.setColumns(20);
/* 1532 */     this.jTextArea5.setLineWrap(true);
/* 1533 */     this.jTextArea5.setRows(5);
/* 1534 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 1536 */     this.jLabel128.setText("Ingresa el motivo por el cual deseas cancelar el pago de finiquitos");
/*      */     
/* 1538 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/* 1539 */     this.jPanel33.setLayout(jPanel33Layout);
/* 1540 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/* 1541 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1542 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 1543 */           .addContainerGap()
/* 1544 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1545 */             .addComponent(this.jLabel128, -1, -1, 32767)
/* 1546 */             .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1547 */               .addGroup(jPanel33Layout.createSequentialGroup()
/* 1548 */                 .addComponent(this.jButton44, -2, 153, -2)
/* 1549 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1550 */                 .addComponent(this.jButton45, -2, 84, -2))
/* 1551 */               .addGroup(jPanel33Layout.createSequentialGroup()
/* 1552 */                 .addComponent(this.jLabel127, -2, 43, -2)
/* 1553 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1554 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/* 1555 */             .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1556 */               .addComponent(this.jLabel126, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1557 */               .addComponent(this.jSeparator31, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/* 1558 */           .addContainerGap()));
/*      */     
/* 1560 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/* 1561 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1562 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 1563 */           .addComponent(this.jLabel126)
/* 1564 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1565 */           .addComponent(this.jSeparator31, -2, 10, -2)
/* 1566 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1567 */           .addComponent(this.jLabel128)
/* 1568 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1569 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1570 */             .addComponent(this.jLabel127)
/* 1571 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 1572 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1573 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1574 */             .addComponent(this.jButton45)
/* 1575 */             .addComponent(this.jButton44))
/* 1576 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1579 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 1580 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 1581 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 1582 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1583 */         .addComponent(this.jPanel33, -2, -1, -2));
/*      */     
/* 1585 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 1586 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1587 */         .addComponent(this.jPanel33, -2, -1, -2));
/*      */ 
/*      */     
/* 1590 */     this.jDialog5.setTitle("Gratificaciones");
/*      */     
/* 1592 */     this.jPanel34.setBackground(new Color(255, 255, 255));
/*      */     
/* 1594 */     this.jLabel122.setFont(new Font("Times New Roman", 1, 14));
/* 1595 */     this.jLabel122.setHorizontalAlignment(0);
/* 1596 */     this.jLabel122.setText("Coloca la Gratificación");
/*      */     
/* 1598 */     this.jLabel123.setFont(new Font("Tahoma", 1, 11));
/* 1599 */     this.jLabel123.setHorizontalAlignment(0);
/* 1600 */     this.jLabel123.setText("Concepto");
/*      */     
/* 1602 */     this.jLabel124.setFont(new Font("Tahoma", 1, 11));
/* 1603 */     this.jLabel124.setHorizontalAlignment(0);
/* 1604 */     this.jLabel124.setText("P Unitario");
/*      */     
/* 1606 */     this.jFormattedTextField5.setHorizontalAlignment(4);
/*      */     
/* 1608 */     this.jButton37.setMnemonic('C');
/* 1609 */     this.jButton37.setText("Cerrar");
/* 1610 */     this.jButton37.setToolTipText("Cerrar (Alt+C)");
/* 1611 */     this.jButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1613 */             Finiquitos.this.jButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1617 */     this.jButton38.setMnemonic('A');
/* 1618 */     this.jButton38.setText("Agregar");
/* 1619 */     this.jButton38.setToolTipText("Agregar (Alt+A)");
/* 1620 */     this.jButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1622 */             Finiquitos.this.jButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1626 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 1627 */     this.jPanel34.setLayout(jPanel34Layout);
/* 1628 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 1629 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1630 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
/* 1631 */           .addContainerGap()
/* 1632 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1633 */             .addComponent(this.jLabel122, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1634 */             .addComponent(this.jSeparator28, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1635 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
/* 1636 */               .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1637 */                 .addComponent(this.jTextField29, GroupLayout.Alignment.LEADING, -1, 432, 32767)
/* 1638 */                 .addComponent(this.jLabel123, GroupLayout.Alignment.LEADING, -1, 432, 32767))
/* 1639 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1640 */               .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1641 */                 .addComponent(this.jFormattedTextField5, 0, 0, 32767)
/* 1642 */                 .addComponent(this.jLabel124, -2, 97, -2)))
/* 1643 */             .addComponent(this.jSeparator29, -1, 535, 32767)
/* 1644 */             .addGroup(jPanel34Layout.createSequentialGroup()
/* 1645 */               .addComponent(this.jButton38, -2, 83, -2)
/* 1646 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1647 */               .addComponent(this.jButton37, -2, 83, -2)))
/* 1648 */           .addContainerGap()));
/*      */     
/* 1650 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 1651 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1652 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 1653 */           .addComponent(this.jLabel122)
/* 1654 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1655 */           .addComponent(this.jSeparator28, -2, 10, -2)
/* 1656 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1657 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1658 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
/* 1659 */               .addComponent(this.jLabel123)
/* 1660 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1661 */               .addComponent(this.jTextField29, -2, -1, -2))
/* 1662 */             .addGroup(jPanel34Layout.createSequentialGroup()
/* 1663 */               .addComponent(this.jLabel124)
/* 1664 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1665 */               .addComponent(this.jFormattedTextField5, -2, -1, -2)))
/* 1666 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1667 */           .addComponent(this.jSeparator29, -2, 10, -2)
/* 1668 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1669 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1670 */             .addComponent(this.jButton37)
/* 1671 */             .addComponent(this.jButton38))
/* 1672 */           .addContainerGap(22, 32767)));
/*      */ 
/*      */     
/* 1675 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1676 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1677 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1678 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1679 */         .addComponent(this.jPanel34, -2, -1, -2));
/*      */     
/* 1681 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1682 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1683 */         .addComponent(this.jPanel34, -2, -1, -2));
/*      */ 
/*      */     
/* 1686 */     this.jDialog6.setTitle("Gratificaciones");
/*      */     
/* 1688 */     this.jPanel35.setBackground(new Color(255, 255, 255));
/*      */     
/* 1690 */     this.jLabel125.setFont(new Font("Times New Roman", 1, 14));
/* 1691 */     this.jLabel125.setHorizontalAlignment(0);
/* 1692 */     this.jLabel125.setText("Coloca la Gratificación");
/*      */     
/* 1694 */     this.jLabel129.setFont(new Font("Tahoma", 1, 11));
/* 1695 */     this.jLabel129.setHorizontalAlignment(0);
/* 1696 */     this.jLabel129.setText("Concepto");
/*      */     
/* 1698 */     this.jLabel130.setFont(new Font("Tahoma", 1, 11));
/* 1699 */     this.jLabel130.setHorizontalAlignment(0);
/* 1700 */     this.jLabel130.setText("P Unitario");
/*      */     
/* 1702 */     this.jFormattedTextField6.setHorizontalAlignment(4);
/*      */     
/* 1704 */     this.jButton39.setMnemonic('C');
/* 1705 */     this.jButton39.setText("Cerrar");
/* 1706 */     this.jButton39.setToolTipText("Cerrar (Alt+C)");
/* 1707 */     this.jButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1709 */             Finiquitos.this.jButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1713 */     this.jButton40.setMnemonic('A');
/* 1714 */     this.jButton40.setText("Agregar");
/* 1715 */     this.jButton40.setToolTipText("Agregar (Alt+A)");
/* 1716 */     this.jButton40.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1718 */             Finiquitos.this.jButton40ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1722 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/* 1723 */     this.jPanel35.setLayout(jPanel35Layout);
/* 1724 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/* 1725 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1726 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
/* 1727 */           .addContainerGap()
/* 1728 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1729 */             .addComponent(this.jLabel125, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1730 */             .addComponent(this.jSeparator30, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1731 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel35Layout.createSequentialGroup()
/* 1732 */               .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1733 */                 .addComponent(this.jTextField30, GroupLayout.Alignment.LEADING, -1, 432, 32767)
/* 1734 */                 .addComponent(this.jLabel129, GroupLayout.Alignment.LEADING, -1, 432, 32767))
/* 1735 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1736 */               .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1737 */                 .addComponent(this.jFormattedTextField6, 0, 0, 32767)
/* 1738 */                 .addComponent(this.jLabel130, -2, 97, -2)))
/* 1739 */             .addComponent(this.jSeparator32, -1, 535, 32767)
/* 1740 */             .addGroup(jPanel35Layout.createSequentialGroup()
/* 1741 */               .addComponent(this.jButton40, -2, 83, -2)
/* 1742 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1743 */               .addComponent(this.jButton39, -2, 83, -2)))
/* 1744 */           .addContainerGap()));
/*      */     
/* 1746 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/* 1747 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1748 */         .addGroup(jPanel35Layout.createSequentialGroup()
/* 1749 */           .addComponent(this.jLabel125)
/* 1750 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1751 */           .addComponent(this.jSeparator30, -2, 10, -2)
/* 1752 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1753 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1754 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
/* 1755 */               .addComponent(this.jLabel129)
/* 1756 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1757 */               .addComponent(this.jTextField30, -2, -1, -2))
/* 1758 */             .addGroup(jPanel35Layout.createSequentialGroup()
/* 1759 */               .addComponent(this.jLabel130)
/* 1760 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1761 */               .addComponent(this.jFormattedTextField6, -2, -1, -2)))
/* 1762 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1763 */           .addComponent(this.jSeparator32, -2, 10, -2)
/* 1764 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1765 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1766 */             .addComponent(this.jButton39)
/* 1767 */             .addComponent(this.jButton40))
/* 1768 */           .addContainerGap(22, 32767)));
/*      */ 
/*      */     
/* 1771 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1772 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1773 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1774 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1775 */         .addComponent(this.jPanel35, -2, -1, -2));
/*      */     
/* 1777 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1778 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1779 */         .addComponent(this.jPanel35, -2, -1, -2));
/*      */ 
/*      */     
/* 1782 */     this.jDialog8.setTitle("Administrar Tarjetas de Deudor");
/* 1783 */     this.jDialog8.setModal(true);
/*      */     
/* 1785 */     this.jPanel12.setBackground(new Color(146, 193, 134));
/*      */     
/* 1787 */     this.jLabel65.setFont(new Font("Tahoma", 1, 16));
/* 1788 */     this.jLabel65.setHorizontalAlignment(0);
/* 1789 */     this.jLabel65.setText("Tarjeta de ");
/*      */     
/* 1791 */     this.jTable7.setFont(new Font("Tahoma", 0, 10));
/* 1792 */     this.jTable7.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Mov.", "Fecha", "Concepto", "Referencia", "Cargo", "Abono", "Saldo", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1800 */     this.jTable7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1802 */             Finiquitos.this.jTable7MouseClicked(evt);
/*      */           }
/*      */         });
/* 1805 */     this.jScrollPane7.setViewportView(this.jTable7);
/*      */     
/* 1807 */     this.jTextField8.setEditable(false);
/* 1808 */     this.jTextField8.setFont(new Font("Tahoma", 1, 14));
/* 1809 */     this.jTextField8.setForeground(Color.darkGray);
/* 1810 */     this.jTextField8.setHorizontalAlignment(4);
/* 1811 */     this.jTextField8.setText("$ 10000.00");
/*      */     
/* 1813 */     this.jLabel50.setFont(new Font("Tahoma", 1, 14));
/* 1814 */     this.jLabel50.setForeground(Color.darkGray);
/* 1815 */     this.jLabel50.setHorizontalAlignment(4);
/* 1816 */     this.jLabel50.setText("Saldo Actual");
/*      */     
/* 1818 */     this.jButton19.setMnemonic('C');
/* 1819 */     this.jButton19.setText("Cerrar");
/* 1820 */     this.jButton19.setToolTipText("Cerrar (Alt+C)");
/* 1821 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1823 */             Finiquitos.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1827 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1828 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1829 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1830 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1831 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1832 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1833 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1834 */               .addContainerGap()
/* 1835 */               .addComponent(this.jScrollPane7, -1, 704, 32767))
/* 1836 */             .addComponent(this.jSeparator9, -1, 714, 32767)
/* 1837 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1838 */               .addContainerGap()
/* 1839 */               .addComponent(this.jLabel65, -1, 704, 32767))
/* 1840 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 1841 */               .addGap(476, 476, 476)
/* 1842 */               .addComponent(this.jLabel50, -1, 114, 32767)
/* 1843 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1844 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1845 */                 .addComponent(this.jButton19, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1846 */                 .addComponent(this.jTextField8, GroupLayout.Alignment.TRAILING, -1, 120, 32767))))
/* 1847 */           .addContainerGap()));
/*      */     
/* 1849 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1850 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1851 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1852 */           .addComponent(this.jLabel65, -2, 20, -2)
/* 1853 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1854 */           .addComponent(this.jSeparator9, -2, 10, -2)
/* 1855 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1856 */           .addComponent(this.jScrollPane7, -2, 248, -2)
/* 1857 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1858 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1859 */             .addComponent(this.jTextField8, -2, 33, -2)
/* 1860 */             .addComponent(this.jLabel50, -2, 25, -2))
/* 1861 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1862 */           .addComponent(this.jButton19)
/* 1863 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1866 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 1867 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 1868 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 1869 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1870 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/* 1872 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 1873 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1874 */         .addComponent(this.jPanel12, -2, -1, -2));
/*      */ 
/*      */     
/* 1877 */     this.jDialog9.setTitle("Vale de Caja Chica");
/* 1878 */     this.jDialog9.setModal(true);
/*      */     
/* 1880 */     this.jPanel14.setBackground(new Color(146, 193, 134));
/*      */     
/* 1882 */     this.jLabel66.setFont(new Font("Tahoma", 1, 14));
/* 1883 */     this.jLabel66.setForeground(Color.blue);
/* 1884 */     this.jLabel66.setHorizontalAlignment(0);
/* 1885 */     this.jLabel66.setText("CONSULTA DEL MOVIMIENTO");
/*      */     
/* 1887 */     this.jLabel67.setFont(new Font("Tahoma", 3, 11));
/* 1888 */     this.jLabel67.setForeground(new Color(15, 87, 51));
/* 1889 */     this.jLabel67.setHorizontalAlignment(4);
/* 1890 */     this.jLabel67.setText("Mov ");
/*      */     
/* 1892 */     this.jTextField11.setEditable(false);
/* 1893 */     this.jTextField11.setFont(new Font("Tahoma", 1, 11));
/* 1894 */     this.jTextField11.setForeground(Color.red);
/* 1895 */     this.jTextField11.setHorizontalAlignment(4);
/* 1896 */     this.jTextField11.setText("PR-00001");
/*      */     
/* 1898 */     this.jLabel68.setFont(new Font("Tahoma", 3, 11));
/* 1899 */     this.jLabel68.setForeground(new Color(15, 87, 51));
/* 1900 */     this.jLabel68.setHorizontalAlignment(4);
/* 1901 */     this.jLabel68.setText("Fecha ");
/*      */     
/* 1903 */     this.jTextField12.setEditable(false);
/* 1904 */     this.jTextField12.setFont(new Font("Tahoma", 1, 11));
/* 1905 */     this.jTextField12.setForeground(Color.red);
/* 1906 */     this.jTextField12.setText("26/04/2010");
/*      */     
/* 1908 */     this.jButton29.setMnemonic('C');
/* 1909 */     this.jButton29.setText("Cerrar");
/* 1910 */     this.jButton29.setToolTipText("Cerrar (Alt+C)");
/* 1911 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1913 */             Finiquitos.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1917 */     this.jLabel53.setFont(new Font("Tahoma", 3, 11));
/* 1918 */     this.jLabel53.setForeground(Color.red);
/* 1919 */     this.jLabel53.setText("<html><u>Click para ver el Estado</u></html>");
/* 1920 */     this.jLabel53.addMouseListener(new MouseAdapter() {
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1922 */             Finiquitos.this.jLabel53MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1925 */             Finiquitos.this.jLabel53MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1929 */     this.jPanel4.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1931 */     this.jLabel55.setFont(new Font("Tahoma", 1, 11));
/* 1932 */     this.jLabel55.setText("CARGO");
/*      */     
/* 1934 */     this.jLabel69.setFont(new Font("Tahoma", 3, 11));
/* 1935 */     this.jLabel69.setForeground(new Color(15, 87, 51));
/* 1936 */     this.jLabel69.setHorizontalAlignment(2);
/* 1937 */     this.jLabel69.setText("Tipo");
/*      */     
/* 1939 */     this.jLabel70.setFont(new Font("Tahoma", 3, 11));
/* 1940 */     this.jLabel70.setForeground(new Color(15, 87, 51));
/* 1941 */     this.jLabel70.setHorizontalAlignment(2);
/* 1942 */     this.jLabel70.setText("Concepto ");
/*      */     
/* 1944 */     this.jLabel56.setFont(new Font("Tahoma", 1, 11));
/* 1945 */     this.jLabel56.setText("GASTOS POR COMPROBAR");
/*      */     
/* 1947 */     this.jLabel73.setFont(new Font("Tahoma", 3, 11));
/* 1948 */     this.jLabel73.setForeground(new Color(15, 87, 51));
/* 1949 */     this.jLabel73.setHorizontalAlignment(2);
/* 1950 */     this.jLabel73.setText("Referencia ");
/*      */     
/* 1952 */     this.jLabel74.setFont(new Font("Tahoma", 1, 11));
/* 1953 */     this.jLabel74.setText("VALE: PR-00001");
/*      */     
/* 1955 */     this.jLabel75.setFont(new Font("Tahoma", 3, 11));
/* 1956 */     this.jLabel75.setForeground(new Color(15, 87, 51));
/* 1957 */     this.jLabel75.setHorizontalAlignment(2);
/* 1958 */     this.jLabel75.setText("Cantidad ");
/*      */     
/* 1960 */     this.jLabel76.setFont(new Font("Tahoma", 1, 11));
/* 1961 */     this.jLabel76.setHorizontalAlignment(0);
/* 1962 */     this.jLabel76.setText("$200.00");
/*      */     
/* 1964 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1965 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1966 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 1967 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1968 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1969 */           .addContainerGap()
/* 1970 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1971 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 1972 */               .addComponent(this.jLabel69, -2, 36, -2)
/* 1973 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1974 */               .addComponent(this.jLabel55, -2, 233, -2))
/* 1975 */             .addComponent(this.jLabel70)
/* 1976 */             .addComponent(this.jLabel56, -2, 286, -2)
/* 1977 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 1978 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1979 */                 .addComponent(this.jLabel74, -2, 184, -2)
/* 1980 */                 .addComponent(this.jLabel73))
/* 1981 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767)
/* 1982 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1983 */                 .addComponent(this.jLabel76, -2, 88, -2)
/* 1984 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 1985 */                   .addGap(20, 20, 20)
/* 1986 */                   .addComponent(this.jLabel75)))))
/* 1987 */           .addContainerGap()));
/*      */     
/* 1989 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 1990 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1991 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1992 */           .addContainerGap()
/* 1993 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1994 */             .addComponent(this.jLabel69)
/* 1995 */             .addComponent(this.jLabel55))
/* 1996 */           .addGap(18, 18, 18)
/* 1997 */           .addComponent(this.jLabel70)
/* 1998 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1999 */           .addComponent(this.jLabel56)
/* 2000 */           .addGap(18, 18, 18)
/* 2001 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2002 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 2003 */               .addComponent(this.jLabel73)
/* 2004 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2005 */               .addComponent(this.jLabel74))
/* 2006 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 2007 */               .addComponent(this.jLabel75)
/* 2008 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2009 */               .addComponent(this.jLabel76)))
/* 2010 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2013 */     this.jPanel15.setBorder(BorderFactory.createEtchedBorder(0));
/*      */     
/* 2015 */     this.jLabel77.setForeground(Color.darkGray);
/* 2016 */     this.jLabel77.setHorizontalAlignment(0);
/* 2017 */     this.jLabel77.setText("Observaciones:");
/*      */     
/* 2019 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 2020 */     this.jPanel15.setLayout(jPanel15Layout);
/* 2021 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/* 2022 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2023 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 2024 */           .addComponent(this.jLabel77, -1, 309, 32767)
/* 2025 */           .addContainerGap()));
/*      */     
/* 2027 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/* 2028 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2029 */         .addComponent(this.jLabel77));
/*      */ 
/*      */     
/* 2032 */     this.jTextArea1.setColumns(20);
/* 2033 */     this.jTextArea1.setFont(new Font("Tahoma", 0, 11));
/* 2034 */     this.jTextArea1.setLineWrap(true);
/* 2035 */     this.jTextArea1.setRows(5);
/* 2036 */     this.jTextArea1.setText("GASTOS PARA LA GUÍA PR-00001");
/* 2037 */     this.jTextArea1.setEnabled(false);
/* 2038 */     this.jScrollPane8.setViewportView(this.jTextArea1);
/*      */     
/* 2040 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 2041 */     this.jPanel14.setLayout(jPanel14Layout);
/* 2042 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 2043 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2044 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 2045 */           .addContainerGap()
/* 2046 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2047 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 2048 */               .addComponent(this.jLabel67, -2, 34, -2)
/* 2049 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2050 */               .addComponent(this.jTextField11, -2, 74, -2)
/* 2051 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 80, 32767)
/* 2052 */               .addComponent(this.jLabel68, -2, 42, -2)
/* 2053 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2054 */               .addComponent(this.jTextField12, -2, 82, -2)
/* 2055 */               .addGap(21, 21, 21))
/* 2056 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/* 2057 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2058 */                 .addComponent(this.jSeparator10, GroupLayout.Alignment.LEADING, -1, 331, 32767)
/* 2059 */                 .addComponent(this.jLabel66, GroupLayout.Alignment.LEADING, -1, 331, 32767)
/* 2060 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2061 */                   .addComponent(this.jScrollPane8, GroupLayout.Alignment.LEADING)
/* 2062 */                   .addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 2063 */               .addContainerGap())
/* 2064 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 2065 */               .addComponent(this.jLabel53, -2, 143, -2)
/* 2066 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, 32767)
/* 2067 */               .addComponent(this.jButton29, -2, 102, -2)
/* 2068 */               .addGap(18, 18, 18))))
/* 2069 */         .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2070 */           .addGroup(jPanel14Layout.createSequentialGroup()
/* 2071 */             .addContainerGap()
/* 2072 */             .addComponent(this.jPanel15, -2, -1, -2)
/* 2073 */             .addContainerGap(18, 32767))));
/*      */     
/* 2075 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 2076 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2077 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 2078 */           .addComponent(this.jLabel66)
/* 2079 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2080 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2081 */             .addComponent(this.jLabel67)
/* 2082 */             .addComponent(this.jTextField11, -2, -1, -2)
/* 2083 */             .addComponent(this.jLabel68)
/* 2084 */             .addComponent(this.jTextField12, -2, -1, -2))
/* 2085 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2086 */           .addComponent(this.jSeparator10, -2, 10, -2)
/* 2087 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2088 */           .addComponent(this.jPanel4, -2, -1, -2)
/* 2089 */           .addGap(36, 36, 36)
/* 2090 */           .addComponent(this.jScrollPane8, -2, 136, -2)
/* 2091 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2092 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2093 */             .addComponent(this.jLabel53, -2, -1, -2)
/* 2094 */             .addComponent(this.jButton29))
/* 2095 */           .addContainerGap(24, 32767))
/* 2096 */         .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2097 */           .addGroup(jPanel14Layout.createSequentialGroup()
/* 2098 */             .addGap(221, 221, 221)
/* 2099 */             .addComponent(this.jPanel15, -2, -1, -2)
/* 2100 */             .addContainerGap(195, 32767))));
/*      */ 
/*      */     
/* 2103 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 2104 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 2105 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 2106 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2107 */         .addComponent(this.jPanel14, -2, -1, -2));
/*      */     
/* 2109 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 2110 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2111 */         .addComponent(this.jPanel14, -2, -1, -2));
/*      */ 
/*      */     
/* 2114 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 2115 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 2117 */     this.jLabel54.setFont(new Font("Times New Roman", 1, 24));
/* 2118 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 2119 */     this.jLabel54.setText("FINIQUITOS");
/*      */     
/* 2121 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 2122 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2124 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 2125 */     this.jLabel48.setForeground(Color.red);
/* 2126 */     this.jLabel48.setHorizontalAlignment(0);
/* 2127 */     this.jLabel48.setText("t");
/* 2128 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 2130 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 2131 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Cliente", "Equipo", "Plataforma", "Pozo", "Subtotal", "Iva", "Ret", "Total", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2139 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2141 */             Finiquitos.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 2144 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/* 2146 */     this.jButton23.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 2147 */     this.jButton23.setMnemonic('V');
/* 2148 */     this.jButton23.setText("Ver");
/* 2149 */     this.jButton23.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 2150 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2152 */             Finiquitos.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2156 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 2157 */     this.jButton24.setMnemonic('V');
/* 2158 */     this.jButton24.setText("Nueva");
/* 2159 */     this.jButton24.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 2160 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2162 */             Finiquitos.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2166 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 2167 */     this.jButton25.setMnemonic('V');
/* 2168 */     this.jButton25.setText("Cancelar");
/* 2169 */     this.jButton25.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 2170 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2172 */             Finiquitos.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2176 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 2177 */     this.jButton26.setMnemonic('V');
/* 2178 */     this.jButton26.setText("Guardar Reporte");
/* 2179 */     this.jButton26.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 2180 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2182 */             Finiquitos.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2186 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 2187 */     this.jButton2.setMnemonic('I');
/* 2188 */     this.jButton2.setText("Imprimir");
/* 2189 */     this.jButton2.setToolTipText("Imprimir (Alt+I)");
/* 2190 */     this.jButton2.setEnabled(false);
/*      */     
/* 2192 */     this.jButton27.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 2193 */     this.jButton27.setMnemonic('V');
/* 2194 */     this.jButton27.setText("Modificar");
/* 2195 */     this.jButton27.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 2196 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2198 */             Finiquitos.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2202 */     this.jButton28.setMnemonic('R');
/* 2203 */     this.jButton28.setText("Autorizar");
/* 2204 */     this.jButton28.setToolTipText("Autorizar (Alt+R)");
/* 2205 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2207 */             Finiquitos.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2211 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 2212 */     this.jPanel5.setLayout(jPanel5Layout);
/* 2213 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 2214 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2215 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2216 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 2217 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2218 */           .addComponent(this.jButton24, -2, 119, -2)
/* 2219 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2220 */           .addComponent(this.jButton27, -2, 119, -2)
/* 2221 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2222 */           .addComponent(this.jButton23, -2, 119, -2)
/* 2223 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2224 */           .addComponent(this.jButton25, -2, 119, -2)
/* 2225 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2226 */           .addComponent(this.jButton28, -2, 119, -2)
/* 2227 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2228 */           .addComponent(this.jButton26)
/* 2229 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 151, 32767)
/* 2230 */           .addComponent(this.jButton2, -2, 124, -2))
/* 2231 */         .addComponent(this.jScrollPane3, -1, 1218, 32767));
/*      */     
/* 2233 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 2234 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2235 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2236 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2237 */             .addComponent(this.jLabel48)
/* 2238 */             .addComponent(this.jButton24, -2, 28, -2)
/* 2239 */             .addComponent(this.jButton27, -2, 28, -2)
/* 2240 */             .addComponent(this.jButton23, -2, 28, -2)
/* 2241 */             .addComponent(this.jButton25, -2, 28, -2)
/* 2242 */             .addComponent(this.jButton28, -2, 28, -2)
/* 2243 */             .addComponent(this.jButton26, -2, 28, -2)
/* 2244 */             .addComponent(this.jButton2))
/* 2245 */           .addGap(7, 7, 7)
/* 2246 */           .addComponent(this.jScrollPane3, -1, 141, 32767)));
/*      */ 
/*      */     
/* 2249 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 2250 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Finiquitos", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2252 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2254 */             Finiquitos.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2258 */     this.jLabel15.setFont(new Font("Tahoma", 3, 11));
/* 2259 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 2260 */     this.jLabel15.setHorizontalAlignment(0);
/* 2261 */     this.jLabel15.setText("Folio");
/*      */     
/* 2263 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 2264 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVOS", "TODOS", "<Por Pagar>", "<Autorizado>", "<Cancelado>" }));
/* 2265 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2267 */             Finiquitos.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2271 */     this.jLabel46.setFont(new Font("Tahoma", 3, 11));
/* 2272 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 2273 */     this.jLabel46.setHorizontalAlignment(0);
/* 2274 */     this.jLabel46.setText("Estatus");
/*      */     
/* 2276 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2278 */             Finiquitos.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2282 */     this.jLabel2.setFont(new Font("Tahoma", 3, 11));
/* 2283 */     this.jLabel2.setForeground(new Color(15, 87, 51));
/* 2284 */     this.jLabel2.setHorizontalAlignment(0);
/* 2285 */     this.jLabel2.setText("Nombre del Trabajador");
/*      */     
/* 2287 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 2288 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Pagar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 2289 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2291 */             Finiquitos.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2295 */     this.jLabel47.setFont(new Font("Tahoma", 3, 11));
/* 2296 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/* 2297 */     this.jLabel47.setHorizontalAlignment(0);
/* 2298 */     this.jLabel47.setText("Departamento");
/*      */     
/* 2300 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 2301 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Pagar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 2302 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2304 */             Finiquitos.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2308 */     this.jLabel49.setFont(new Font("Tahoma", 3, 11));
/* 2309 */     this.jLabel49.setForeground(new Color(15, 87, 51));
/* 2310 */     this.jLabel49.setHorizontalAlignment(0);
/* 2311 */     this.jLabel49.setText("Responsable");
/*      */     
/* 2313 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 2314 */     this.jPanel17.setLayout(jPanel17Layout);
/* 2315 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 2316 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2317 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2318 */           .addContainerGap()
/* 2319 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2320 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 2321 */             .addComponent(this.jTextField1, -2, 81, -2))
/* 2322 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2323 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2324 */             .addComponent(this.jLabel46, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2325 */             .addComponent(this.jComboBox1, GroupLayout.Alignment.TRAILING, 0, 104, 32767))
/* 2326 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2327 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2328 */             .addComponent(this.jLabel2, -1, -1, 32767)
/* 2329 */             .addComponent(this.jTextField2, -1, 212, 32767))
/* 2330 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2331 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2332 */             .addComponent(this.jLabel47, -1, -1, 32767)
/* 2333 */             .addComponent(this.jComboBox2, 0, 183, 32767))
/* 2334 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2335 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2336 */             .addComponent(this.jComboBox3, 0, -1, 32767)
/* 2337 */             .addComponent(this.jLabel49, -1, 143, 32767))
/* 2338 */           .addContainerGap(461, 32767)));
/*      */     
/* 2340 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 2341 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2342 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2343 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2344 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2345 */               .addComponent(this.jTextField1, -2, -1, -2)
/* 2346 */               .addGap(8, 8, 8)
/* 2347 */               .addComponent(this.jLabel15, -1, -1, 32767))
/* 2348 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2349 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2350 */                 .addComponent(this.jComboBox1, -2, -1, -2)
/* 2351 */                 .addComponent(this.jTextField2, -2, -1, -2))
/* 2352 */               .addGap(8, 8, 8)
/* 2353 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2354 */                 .addComponent(this.jLabel46, -1, -1, 32767)
/* 2355 */                 .addComponent(this.jLabel2)))
/* 2356 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2357 */               .addComponent(this.jComboBox2, -2, -1, -2)
/* 2358 */               .addGap(8, 8, 8)
/* 2359 */               .addComponent(this.jLabel47, -1, -1, 32767))
/* 2360 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2361 */               .addComponent(this.jComboBox3, -2, -1, -2)
/* 2362 */               .addGap(8, 8, 8)
/* 2363 */               .addComponent(this.jLabel49, -1, -1, 32767)))
/* 2364 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2367 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 2368 */     this.jPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 2370 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2371 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 2372 */     this.jDateChooser4.setIcon(this.icon);
/* 2373 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 2374 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2376 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2377 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 2378 */     this.jDateChooser5.setIcon(this.icon);
/* 2379 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2381 */     this.jLabel5.setFont(new Font("Tahoma", 2, 12));
/* 2382 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/* 2383 */     this.jLabel5.setText("<html><u>Todos </u></html>");
/* 2384 */     this.jLabel5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2386 */             Finiquitos.this.jLabel5MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2389 */             Finiquitos.this.jLabel5MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2392 */             Finiquitos.this.jLabel5MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2396 */     this.jLabel6.setFont(new Font("Tahoma", 2, 12));
/* 2397 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/* 2398 */     this.jLabel6.setHorizontalAlignment(0);
/* 2399 */     this.jLabel6.setText("<html><u>Hoy</u></html>");
/* 2400 */     this.jLabel6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2402 */             Finiquitos.this.jLabel6MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2405 */             Finiquitos.this.jLabel6MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2408 */             Finiquitos.this.jLabel6MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2412 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/* 2413 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/* 2414 */     this.jLabel7.setText("<html><u>Ayer</u></html>");
/* 2415 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2417 */             Finiquitos.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2420 */             Finiquitos.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2423 */             Finiquitos.this.jLabel7MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2427 */     this.jLabel1.setFont(new Font("Tahoma", 1, 15));
/* 2428 */     this.jLabel1.setForeground(Color.red);
/* 2429 */     this.jLabel1.setHorizontalAlignment(4);
/* 2430 */     this.jLabel1.setText("REPORTE DEL");
/*      */     
/* 2432 */     this.jLabel4.setFont(new Font("Tahoma", 1, 15));
/* 2433 */     this.jLabel4.setForeground(Color.red);
/* 2434 */     this.jLabel4.setHorizontalAlignment(0);
/* 2435 */     this.jLabel4.setText("AL");
/*      */     
/* 2437 */     this.jButton1.setMnemonic('F');
/* 2438 */     this.jButton1.setText("Filtrar");
/* 2439 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 2440 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2442 */             Finiquitos.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2446 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 2447 */     this.jPanel2.setLayout(jPanel2Layout);
/* 2448 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 2449 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2450 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 2451 */           .addContainerGap()
/* 2452 */           .addComponent(this.jLabel1, -2, 130, -2)
/* 2453 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2454 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 2455 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2456 */           .addComponent(this.jLabel4)
/* 2457 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2458 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 2459 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2460 */           .addComponent(this.jButton1)
/* 2461 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2462 */           .addComponent(this.jLabel5, -2, -1, -2)
/* 2463 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2464 */           .addComponent(this.jLabel6, -2, 31, -2)
/* 2465 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2466 */           .addComponent(this.jLabel7, -2, 31, -2)
/* 2467 */           .addContainerGap(21, 32767)));
/*      */     
/* 2469 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 2470 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2471 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 2472 */           .addContainerGap()
/* 2473 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2474 */             .addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2475 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 2476 */               .addGap(1, 1, 1)
/* 2477 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2478 */                 .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.TRAILING, -2, -1, -2)
/* 2479 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2480 */                   .addComponent(this.jLabel5, -2, 19, -2)
/* 2481 */                   .addComponent(this.jLabel6, -2, 15, -2)
/* 2482 */                   .addComponent(this.jLabel7, -2, -1, -2)
/* 2483 */                   .addComponent(this.jButton1))
/* 2484 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 2485 */                   .addComponent(this.jLabel4, -2, 19, -2)
/* 2486 */                   .addGap(1, 1, 1))
/* 2487 */                 .addComponent((Component)this.jDateChooser5, GroupLayout.Alignment.TRAILING, -2, -1, -2))))));
/*      */ 
/*      */     
/* 2490 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 2491 */     this.jPanel1.setLayout(jPanel1Layout);
/* 2492 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 2493 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2494 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 2495 */           .addContainerGap()
/* 2496 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2497 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 2498 */               .addComponent(this.jPanel2, -2, -1, -2)
/* 2499 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2500 */               .addComponent(this.jLabel54, -1, 625, 32767))
/* 2501 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 2502 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2503 */                 .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2504 */                 .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2505 */               .addGap(7, 7, 7)))
/* 2506 */           .addContainerGap()));
/*      */     
/* 2508 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 2509 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2510 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 2511 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2512 */             .addComponent(this.jPanel2, -1, -1, 32767)
/* 2513 */             .addComponent(this.jLabel54, -1, -1, 32767))
/* 2514 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2515 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 2516 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2517 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 2518 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2521 */     GroupLayout layout = new GroupLayout(this);
/* 2522 */     setLayout(layout);
/* 2523 */     layout.setHorizontalGroup(layout
/* 2524 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2525 */         .addGap(0, 1274, 32767)
/* 2526 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2527 */           .addGroup(layout.createSequentialGroup()
/* 2528 */             .addGap(10, 10, 10)
/* 2529 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 2530 */             .addGap(10, 10, 10))));
/*      */     
/* 2532 */     layout.setVerticalGroup(layout
/* 2533 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2534 */         .addGap(0, 355, 32767)
/* 2535 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2536 */           .addGroup(layout.createSequentialGroup()
/* 2537 */             .addGap(10, 10, 10)
/* 2538 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 2539 */             .addGap(10, 10, 10))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 2544 */     this.jRadioButton1.setSelected(true);
/* 2545 */     this.jTabbedPane1.removeAll();
/* 2546 */     this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 2547 */     this.jTabbedPane1.addTab("Imss", this.jPanel9);
/* 2548 */     sacarMayor();
/* 2549 */     deshabilitar();
/* 2550 */     this.jRadioButton1.setEnabled(true);
/* 2551 */     this.jRadioButton2.setEnabled(true);
/* 2552 */     this.jButton4.setText("Guardar");
/* 2553 */     this.jButton4.setMnemonic('G');
/* 2554 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 2558 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2562 */     consultar();
/* 2563 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField9KeyReleased(KeyEvent evt) {
/* 2567 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField10KeyReleased(KeyEvent evt) {
/* 2571 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 2575 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 2579 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 2583 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTable6MouseClicked(MouseEvent evt) {
/* 2587 */     if (evt.getClickCount() == 2) {
/* 2588 */       cargarTrabajador();
/*      */     } else {
/*      */       
/* 2591 */       int ind = this.jTable6.getSelectedRow();
/* 2592 */       String nombre = String.valueOf(this.jTable6.getValueAt(ind, 0));
/* 2593 */       this.jButton20.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 2598 */     this.jComboBox8.setSelectedIndex(0);
/* 2599 */     this.jComboBox8.setEnabled(false);
/* 2600 */     this.jTabbedPane1.removeAll();
/* 2601 */     this.jTabbedPane1.addTab("Imss", this.jPanel9);
/* 2602 */     deshabilitar();
/* 2603 */     this.jRadioButton1.setEnabled(true);
/* 2604 */     this.jRadioButton2.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 2608 */     if (this.ACTIVO) {
/* 2609 */       contarDias();
/* 2610 */       calcularVaca();
/* 2611 */       sacarTotalComp();
/* 2612 */       sacarTotalImss();
/* 2613 */       sacarTotalNeto();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 2618 */     cargarTrabajador();
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 2622 */     this.jDateChooser8.setDate(this.jDateChooser10.getDate());
/* 2623 */     this.jDateChooser12.setDate(this.jDateChooser10.getDate());
/*      */     
/* 2625 */     restarFechasAgui();
/* 2626 */     restarFechas();
/* 2627 */     calcularVaca();
/* 2628 */     sacarTotalComp();
/* 2629 */     sacarTotalImss();
/* 2630 */     sacarTotalNeto();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 2636 */     restarFechasAgui();
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2640 */     this.jTextField28.setText("");
/* 2641 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 2642 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 2646 */     if (this.jButton4.getText().equals("Imprimir")) {
/* 2647 */       if (this.jRadioButton1.isSelected()) {
/* 2648 */         ImprimirFiniquitos imp = new ImprimirFiniquitos();
/* 2649 */         imp.recibeDatos();
/*      */       } else {
/*      */         
/* 2652 */         ImprimirFiniquitos2 imp = new ImprimirFiniquitos2();
/* 2653 */         imp.recibeDatos();
/*      */       } 
/*      */     } else {
/*      */       
/* 2657 */       this.jDateChooser8.setDate(this.jDateChooser10.getDate());
/* 2658 */       this.jDateChooser12.setDate(this.jDateChooser10.getDate());
/*      */       
/* 2660 */       restarFechasAgui();
/* 2661 */       restarFechas();
/* 2662 */       calcularVaca();
/* 2663 */       sacarTotalComp();
/* 2664 */       sacarTotalImss();
/* 2665 */       sacarTotalNeto();
/* 2666 */       String tipoTrabajador = "";
/* 2667 */       if (this.jRadioButton1.isSelected()) {
/* 2668 */         tipoTrabajador = "ADMINISTRATIVO";
/*      */       } else {
/*      */         
/* 2671 */         tipoTrabajador = "OPERADOR";
/*      */       } 
/*      */       
/* 2674 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2675 */       String cadenaFecha1 = formato.format(this.jDateChooser9.getDate());
/* 2676 */       String año = cadenaFecha1.substring(0, 4);
/* 2677 */       String mes = cadenaFecha1.substring(4, 6);
/* 2678 */       String dia = cadenaFecha1.substring(6, 8);
/* 2679 */       String fechaIngreso = "'" + año + "-" + mes + "-" + dia + "'";
/*      */       
/* 2681 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 2682 */       cadenaFecha1 = formato.format(this.jDateChooser7.getDate());
/* 2683 */       año = cadenaFecha1.substring(0, 4);
/* 2684 */       mes = cadenaFecha1.substring(4, 6);
/* 2685 */       dia = cadenaFecha1.substring(6, 8);
/* 2686 */       String fecha1 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */       
/* 2688 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 2689 */       cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 2690 */       año = cadenaFecha1.substring(0, 4);
/* 2691 */       mes = cadenaFecha1.substring(4, 6);
/* 2692 */       dia = cadenaFecha1.substring(6, 8);
/* 2693 */       String fecha2 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */       
/* 2695 */       String fecha3 = "";
/* 2696 */       String fecha4 = "";
/* 2697 */       if (this.jDateChooser11.getDate() == null) {
/* 2698 */         fecha3 = "NULL";
/* 2699 */         fecha4 = "NULL";
/*      */       } else {
/*      */         
/* 2702 */         formato = new SimpleDateFormat("yyyyMMdd");
/* 2703 */         cadenaFecha1 = formato.format(this.jDateChooser11.getDate());
/* 2704 */         año = cadenaFecha1.substring(0, 4);
/* 2705 */         mes = cadenaFecha1.substring(4, 6);
/* 2706 */         dia = cadenaFecha1.substring(6, 8);
/* 2707 */         fecha3 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */         
/* 2709 */         formato = new SimpleDateFormat("yyyyMMdd");
/* 2710 */         cadenaFecha1 = formato.format(this.jDateChooser12.getDate());
/* 2711 */         año = cadenaFecha1.substring(0, 4);
/* 2712 */         mes = cadenaFecha1.substring(4, 6);
/* 2713 */         dia = cadenaFecha1.substring(6, 8);
/* 2714 */         fecha4 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */       } 
/*      */       
/* 2717 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 2718 */       cadenaFecha1 = formato.format(this.jDateChooser10.getDate());
/* 2719 */       año = cadenaFecha1.substring(0, 4);
/* 2720 */       mes = cadenaFecha1.substring(4, 6);
/* 2721 */       dia = cadenaFecha1.substring(6, 8);
/* 2722 */       String fechaFiniquito = "'" + año + "-" + mes + "-" + dia + "'";
/*      */       
/* 2724 */       if (this.jButton4.getText().equals("Modificar")) {
/* 2725 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar el documento?", "Modificar Finiquitos", 0, 3, this.PREG);
/* 2726 */         if (res == 0) {
/* 2727 */           this.con.eliminar2("finiquitos_desc", "where folio_fini='" + this.jTextField6.getText() + "'");
/* 2728 */           this.con.eliminar2("finiquitos_concep", "where folio_fini='" + this.jTextField6.getText() + "'");
/* 2729 */           this.con.inserSinMsj("update finiquitos_regis set fecha=" + fechaFiniquito + ", fecha_vac_inicio=" + fecha1 + ", fecha_vac_final=" + fecha2 + ", fecha_agui_inicio=" + fecha3 + ",fecha_agui_final=" + fecha4 + ",periodo='" + String.valueOf(this.jComboBox5.getSelectedItem()) + "',total_comp='" + this.jLabel19.getText() + "',total_imss='" + this.jLabel21.getText() + "', total='" + this.jLabel13.getText() + "',documento='" + this.USUARIO + "' where folio_fini='" + this.jTextField6.getText() + "'"); int i;
/* 2730 */           for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2731 */             this.con.inserSinMsj("insert into finiquitos_concep(concepto,diasLey,diasAnual,FactorDias,diasDer,SubtotalDias,Salario,total,tipo,folio_fini) values('" + String.valueOf(this.jTable1.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 6)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 7)) + "',0,'" + this.jTextField6.getText() + "')");
/*      */           }
/* 2733 */           for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2734 */             this.con.inserSinMsj("insert into finiquitos_concep(concepto,diasLey,diasAnual,FactorDias,diasDer,SubtotalDias,Salario,total,tipo,folio_fini) values('" + String.valueOf(this.jTable2.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 6)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 7)) + "',1,'" + this.jTextField6.getText() + "')");
/*      */           }
/*      */           
/* 2737 */           for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 2738 */             this.con.inserSinMsj("insert into finiquitos_desc(concepto,total,tipo,folio_fini) values('" + String.valueOf(this.jTable4.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable4.getValueAt(i, 1)) + "',0,'" + this.jTextField6.getText() + "')");
/*      */           }
/*      */           
/* 2741 */           for (i = 0; i < this.jTable5.getRowCount(); i++) {
/* 2742 */             this.con.inserSinMsj("insert into finiquitos_desc(concepto,total,tipo,folio_fini)  values('" + String.valueOf(this.jTable5.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable5.getValueAt(i, 1)) + "',1,'" + this.jTextField6.getText() + "')");
/*      */           }
/* 2744 */           if (this.jRadioButton1.isSelected()) {
/* 2745 */             ImprimirFiniquitos imp = new ImprimirFiniquitos();
/* 2746 */             imp.recibeDatos();
/*      */           } else {
/*      */             
/* 2749 */             ImprimirFiniquitos2 imp = new ImprimirFiniquitos2();
/* 2750 */             imp.recibeDatos();
/*      */           } 
/* 2752 */           consultar2();
/* 2753 */           this.jDialog1.setVisible(false);
/*      */         }
/*      */       
/* 2756 */       } else if (this.jButton4.getText().equals("Guardar")) {
/* 2757 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas guardar el pago del finiquito?", "Guardar Finiquito", 0, 3, this.PREG);
/* 2758 */         if (res == 0) {
/* 2759 */           sacarMayor();
/* 2760 */           this.con.inserSinMsj("insert into finiquitos_regis(folio_fini,           fecha,              fecha_Ingreso,   fecha_vac_inicio,  fecha_vac_final,    fecha_agui_inicio,fecha_agui_final,clave,empleado,                                  depa,                     Periodo,                                  tipo,           total_Comp,       total_Imss,total,estatus,documento) values('" + this.jTextField6
/* 2761 */               .getText() + "'," + fechaFiniquito + "," + fechaIngreso + "," + fecha1 + ",              " + fecha2 + ",    " + fecha3 + ",        " + fecha4 + ", " + this.CLAVE + ",'" + this.jTextField5.getText() + "',  '" + String.valueOf(this.jComboBox6.getSelectedItem()) + "','" + String.valueOf(this.jComboBox5.getSelectedItem()) + "','" + tipoTrabajador + "','" + this.jLabel19.getText() + "','" + this.jLabel21.getText() + "','" + this.jLabel13.getText() + "','<Por Pagar>','" + this.USUARIO + "')");
/*      */           int i;
/* 2763 */           for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2764 */             this.con.inserSinMsj("insert into finiquitos_concep(concepto,diasLey,diasAnual,FactorDias,diasDer,SubtotalDias,Salario,total,tipo,folio_fini) values('" + String.valueOf(this.jTable1.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 6)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 7)) + "',0,'" + this.jTextField6.getText() + "')");
/*      */           }
/* 2766 */           for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2767 */             this.con.inserSinMsj("insert into finiquitos_concep(concepto,diasLey,diasAnual,FactorDias,diasDer,SubtotalDias,Salario,total,tipo,folio_fini) values('" + String.valueOf(this.jTable2.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 6)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 7)) + "',1,'" + this.jTextField6.getText() + "')");
/*      */           }
/*      */           
/* 2770 */           for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 2771 */             this.con.inserSinMsj("insert into finiquitos_desc(concepto,total,tipo,folio_fini) values('" + String.valueOf(this.jTable4.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable4.getValueAt(i, 1)) + "',0,'" + this.jTextField6.getText() + "')");
/*      */           }
/*      */           
/* 2774 */           for (i = 0; i < this.jTable5.getRowCount(); i++) {
/* 2775 */             this.con.inserSinMsj("insert into finiquitos_desc(concepto,total,tipo,folio_fini)  values('" + String.valueOf(this.jTable5.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable5.getValueAt(i, 1)) + "',1,'" + this.jTextField6.getText() + "')");
/*      */           }
/* 2777 */           if (this.jRadioButton1.isSelected()) {
/* 2778 */             ImprimirFiniquitos imp = new ImprimirFiniquitos();
/* 2779 */             imp.recibeDatos();
/*      */           } else {
/*      */             
/* 2782 */             ImprimirFiniquitos2 imp = new ImprimirFiniquitos2();
/* 2783 */             imp.recibeDatos();
/*      */           } 
/* 2785 */           consultar2();
/* 2786 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 2793 */     String cant = this.jFormattedTextField3.getText();
/*      */     
/* 2795 */     boolean correcto = false;
/* 2796 */     String[] nombres = null;
/* 2797 */     int esp = 0;
/* 2798 */     String texto = this.jTextField27.getText(); int i;
/* 2799 */     for (i = 0; i < texto.length(); i++) {
/* 2800 */       if (texto.charAt(i) == ' ') {
/* 2801 */         esp++;
/*      */       }
/*      */     } 
/* 2804 */     nombres = new String[esp + 1];
/* 2805 */     for (i = 0; i <= esp; i++) {
/* 2806 */       nombres[i] = "";
/*      */     }
/* 2808 */     esp = 0;
/* 2809 */     for (i = 0; i < texto.length(); i++) {
/* 2810 */       if (texto.charAt(i) == ' ') {
/* 2811 */         esp++;
/*      */       } else {
/*      */         
/* 2814 */         nombres[esp] = nombres[esp] + nombres[esp];
/*      */       } 
/*      */     } 
/* 2817 */     for (i = 0; i < nombres.length; i++) {
/* 2818 */       if (nombres[i].length() == 0) {
/* 2819 */         this.jTextField27.setBackground(Color.RED);
/* 2820 */         JOptionPane.showMessageDialog(this.jDialog3, "Tienes un espacio de más en la descripción del concepto", "Error 031 - Espacio", 0, this.ERROR);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 2825 */     if (cant.equals("$0.00")) {
/* 2826 */       this.jFormattedTextField3.setBackground(Color.RED);
/* 2827 */       JOptionPane.showMessageDialog(this.jDialog3, "No puedes colocar cantidad menores a cero", "Cantidad pequeña", 0, this.ERROR);
/*      */     }
/* 2829 */     else if (this.jTextField27.getText().equals("")) {
/* 2830 */       this.jTextField27.setBackground(Color.RED);
/* 2831 */       JOptionPane.showMessageDialog(this.jDialog3, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/*      */     
/*      */     }
/* 2834 */     else if (this.jTextField27.getText().length() > 999) {
/* 2835 */       this.jTextField27.setBackground(Color.RED);
/* 2836 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes agregar más 999 caracteres en el concepto", "Concepto muy largo", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 2839 */       String desc = this.jTextField27.getText().toUpperCase();
/* 2840 */       String valor = String.valueOf(this.jFormattedTextField3.getValue());
/*      */       
/* 2842 */       String valorP = "";
/* 2843 */       for (int j = 0; j < valor.length(); j++) {
/* 2844 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',') {
/* 2845 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 2849 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Deseas agregar el nuevo concepto?", "Agregar concepto", 0, 3, this.PREG);
/* 2850 */       if (res == 0) {
/* 2851 */         DefaultTableModel temp = (DefaultTableModel)this.jTable4.getModel();
/* 2852 */         Object[] nuevo = { desc, this.jFormattedTextField3.getText() };
/* 2853 */         temp.addRow(nuevo);
/* 2854 */         this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 2855 */         this.jTextField27.setText("");
/* 2856 */         this.jTable4.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 2857 */         sacarTotalComp();
/* 2858 */         sacarTotalNeto();
/* 2859 */         this.jDialog3.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {
/* 2865 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton36ActionPerformed(ActionEvent evt) {
/* 2869 */     String cant = this.jFormattedTextField4.getText();
/*      */     
/* 2871 */     boolean correcto = false;
/* 2872 */     String[] nombres = null;
/* 2873 */     int esp = 0;
/* 2874 */     String texto = this.jTextField28.getText(); int i;
/* 2875 */     for (i = 0; i < texto.length(); i++) {
/* 2876 */       if (texto.charAt(i) == ' ') {
/* 2877 */         esp++;
/*      */       }
/*      */     } 
/* 2880 */     nombres = new String[esp + 1];
/* 2881 */     for (i = 0; i <= esp; i++) {
/* 2882 */       nombres[i] = "";
/*      */     }
/* 2884 */     esp = 0;
/* 2885 */     for (i = 0; i < texto.length(); i++) {
/* 2886 */       if (texto.charAt(i) == ' ') {
/* 2887 */         esp++;
/*      */       } else {
/*      */         
/* 2890 */         nombres[esp] = nombres[esp] + nombres[esp];
/*      */       } 
/*      */     } 
/* 2893 */     for (i = 0; i < nombres.length; i++) {
/* 2894 */       if (nombres[i].length() == 0) {
/* 2895 */         this.jTextField28.setBackground(Color.RED);
/* 2896 */         JOptionPane.showMessageDialog(this.jDialog3, "Tienes un espacio de más en la descripción del concepto", "Error 031 - Espacio", 0, this.ERROR);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 2901 */     if (cant.equals("$0.00")) {
/* 2902 */       this.jFormattedTextField4.setBackground(Color.RED);
/* 2903 */       JOptionPane.showMessageDialog(this.jDialog3, "No puedes colocar cantidad menores a cero", "Cantidad pequeña", 0, this.ERROR);
/*      */     }
/* 2905 */     else if (this.jTextField28.getText().equals("")) {
/* 2906 */       this.jTextField28.setBackground(Color.RED);
/* 2907 */       JOptionPane.showMessageDialog(this.jDialog3, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/*      */     
/*      */     }
/* 2910 */     else if (this.jTextField28.getText().length() > 999) {
/* 2911 */       this.jTextField28.setBackground(Color.RED);
/* 2912 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes agregar más 999 caracteres en el concepto", "Concepto muy largo", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 2915 */       String desc = this.jTextField28.getText().toUpperCase();
/* 2916 */       String valor = String.valueOf(this.jFormattedTextField4.getValue());
/*      */       
/* 2918 */       String valorP = "";
/* 2919 */       for (int j = 0; j < valor.length(); j++) {
/* 2920 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',') {
/* 2921 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 2925 */       int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Deseas agregar el nuevo concepto?", "Agregar concepto", 0, 3, this.PREG);
/* 2926 */       if (res == 0) {
/* 2927 */         DefaultTableModel temp = (DefaultTableModel)this.jTable5.getModel();
/* 2928 */         Object[] nuevo = { desc, this.jFormattedTextField4.getText() };
/* 2929 */         temp.addRow(nuevo);
/* 2930 */         this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 2931 */         this.jTextField28.setText("");
/* 2932 */         this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 2933 */         sacarTotalComp();
/* 2934 */         sacarTotalImss();
/* 2935 */         sacarTotalNeto();
/* 2936 */         this.jDialog4.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton35ActionPerformed(ActionEvent evt) {
/* 2942 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 2946 */     this.jTextField27.setText("");
/* 2947 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 2948 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 2952 */     if (this.jTable4.getSelectedRow() < 0) {
/* 2953 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un dato para quitar el descuento", "Selecciona un descuento", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 2956 */       DefaultTableModel temp = (DefaultTableModel)this.jTable4.getModel();
/* 2957 */       temp.removeRow(this.jTable4.getSelectedRow());
/* 2958 */       sacarTotalComp();
/* 2959 */       sacarTotalNeto();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2964 */     if (this.jTable5.getSelectedRow() < 0) {
/* 2965 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un dato para quitar el descuento", "Selecciona un descuento", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 2968 */       DefaultTableModel temp = (DefaultTableModel)this.jTable5.getModel();
/* 2969 */       temp.removeRow(this.jTable5.getSelectedRow());
/* 2970 */       sacarTotalImss();
/* 2971 */       sacarTotalNeto();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 2976 */     this.jComboBox8.setEnabled(false);
/* 2977 */     this.jTabbedPane1.removeAll();
/* 2978 */     this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 2979 */     this.jTabbedPane1.addTab("Imss", this.jPanel9);
/* 2980 */     deshabilitar();
/* 2981 */     this.jRadioButton1.setEnabled(true);
/* 2982 */     this.jRadioButton2.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void jLabel5MouseClicked(MouseEvent evt) {
/* 2986 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 2987 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2988 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jLabel6MouseClicked(MouseEvent evt) {
/* 2992 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2993 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2994 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 2998 */     Calendar ca = Calendar.getInstance();
/* 2999 */     Calendar fecha = Calendar.getInstance();
/* 3000 */     int aa = fecha.get(1);
/* 3001 */     int mm = fecha.get(2);
/* 3002 */     int dd = fecha.get(5);
/* 3003 */     if (dd == 1) {
/* 3004 */       if (mm == 0) {
/* 3005 */         mm = 11;
/* 3006 */         aa--;
/*      */       } else {
/* 3008 */         mm--;
/*      */       } 
/* 3010 */       int diasTotal = diasDelMes(mm, aa);
/* 3011 */       dd = diasTotal;
/*      */     } else {
/* 3013 */       dd--;
/*      */     } 
/* 3015 */     mm++;
/* 3016 */     String año = "" + aa;
/* 3017 */     String mes = "" + mm;
/* 3018 */     String dia = "" + dd;
/* 3019 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3020 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 3022 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 3023 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 3024 */     } catch (ParseException ex) {
/* 3025 */       ex.printStackTrace();
/*      */     } 
/* 3027 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseEntered(MouseEvent evt) {
/* 3031 */     this.jLabel5.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel5MouseExited(MouseEvent evt) {
/* 3035 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseEntered(MouseEvent evt) {
/* 3039 */     this.jLabel6.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseExited(MouseEvent evt) {
/* 3043 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 3047 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/* 3051 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 3055 */     int ind = this.jTable3.getSelectedRow();
/* 3056 */     if (ind < 0) {
/* 3057 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una valor para modificar los datos", "Selecciona una formato", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 3060 */       String estatus = String.valueOf(this.jTable3.getValueAt(ind, 9));
/* 3061 */       if (!estatus.contains("<Por Pagar>")) {
/* 3062 */         JOptionPane.showMessageDialog(this.padre, "No puedes modificar el documento porque su estatus no es '<Por Pagar>'", "No se puede modificar", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 3065 */         String tipo = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 5));
/* 3066 */         if (tipo.equals("OPERADOR")) {
/* 3067 */           this.encontrado = this.con.consultar("tarjeta", "tarjeta_deudor", "where num_ope=" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3)));
/* 3068 */           if (this.encontrado) {
/* 3069 */             this.CLAVEOP = this.con.Campo;
/*      */           } else {
/*      */             
/* 3072 */             this.CLAVEOP = "0";
/*      */           } 
/* 3074 */           this.jRadioButton2.setSelected(true);
/* 3075 */           this.jTabbedPane1.removeAll();
/* 3076 */           this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */         } else {
/*      */           
/* 3079 */           this.encontrado = this.con.consultar("tarjeta", "tarjeta_deudor", "where clave_emp=" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3)));
/* 3080 */           if (this.encontrado) {
/* 3081 */             this.CLAVEOP = this.con.Campo;
/*      */           } else {
/*      */             
/* 3084 */             this.CLAVEOP = "0";
/*      */           } 
/* 3086 */           this.jRadioButton1.setSelected(true);
/* 3087 */           this.jTabbedPane1.removeAll();
/* 3088 */           this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 3089 */           this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */         } 
/* 3091 */         verFiniquitos();
/* 3092 */         this.jButton5.setEnabled(true);
/* 3093 */         this.jButton4.setText("Modificar");
/* 3094 */         this.jButton4.setMnemonic('M');
/* 3095 */         this.jRadioButton1.setEnabled(false);
/* 3096 */         this.jRadioButton2.setEnabled(false);
/* 3097 */         this.jButton12.setEnabled(false);
/* 3098 */         this.jButton4.setEnabled(true);
/* 3099 */         this.jButton12.setEnabled(false);
/*      */         
/* 3101 */         this.jButton8.setEnabled(true);
/* 3102 */         this.jButton7.setEnabled(true);
/* 3103 */         this.jButton11.setEnabled(true);
/* 3104 */         this.jButton10.setEnabled(true);
/*      */         
/* 3106 */         this.jButton16.setEnabled(true);
/* 3107 */         this.jButton17.setEnabled(true);
/*      */         
/* 3109 */         this.jButton13.setEnabled(true);
/* 3110 */         this.jDateChooser10.setEnabled(true);
/*      */         
/* 3112 */         if (this.PRIVILEGIOS.equals("SUPER USUARIO")) {
/* 3113 */           this.jComboBox5.setEnabled(true);
/* 3114 */           this.jDateChooser7.setEnabled(true);
/* 3115 */           this.jDateChooser8.setEnabled(true);
/* 3116 */           this.jDateChooser11.setEnabled(true);
/* 3117 */           this.jDateChooser12.setEnabled(true);
/*      */         } else {
/*      */           
/* 3120 */           this.jComboBox5.setEnabled(false);
/* 3121 */           this.jDateChooser7.setEnabled(false);
/* 3122 */           this.jDateChooser8.setEnabled(false);
/* 3123 */           this.jDateChooser11.setEnabled(false);
/* 3124 */           this.jDateChooser12.setEnabled(false);
/*      */         } 
/* 3126 */         this.jDialog1.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 3132 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 3136 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 3140 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 3144 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 3148 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 3152 */     String[] datos = { "NÚM", "FOLIO", "FECHA", "CLAVE EMP", "EMPLEADO", "DEPARTAMENTO", "TOTAL COMP", "TOTAL IMSS", "TOTAL", "ESTATUS", "DOCUMENTO" };
/* 3153 */     this.esc = new EscribirReporte("FINIQUITOS", this.jTable3, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 3157 */     if (evt.getClickCount() == 2) {
/* 3158 */       String tipo = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 5));
/* 3159 */       if (tipo.equals("OPERADOR")) {
/* 3160 */         this.jRadioButton2.setSelected(true);
/* 3161 */         this.jTabbedPane1.removeAll();
/* 3162 */         this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */       } else {
/*      */         
/* 3165 */         this.jRadioButton1.setSelected(true);
/* 3166 */         this.jTabbedPane1.removeAll();
/* 3167 */         this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 3168 */         this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */       } 
/* 3170 */       verFiniquitos();
/* 3171 */       this.jButton5.setEnabled(false);
/* 3172 */       this.jButton9.setEnabled(false);
/* 3173 */       this.jButton15.setEnabled(false);
/* 3174 */       this.jButton16.setEnabled(false);
/* 3175 */       this.jButton17.setEnabled(false);
/* 3176 */       this.jDateChooser10.setEnabled(false);
/* 3177 */       this.jButton4.setText("Imprimir");
/* 3178 */       this.jButton4.setMnemonic('I');
/* 3179 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 3184 */     int ind = this.jTable3.getSelectedRow();
/* 3185 */     if (ind < 0) {
/* 3186 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un valor para ver los datos", "Selecciona un formato", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 3189 */       String tipo = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 5));
/* 3190 */       if (tipo.equals("OPERADOR")) {
/* 3191 */         this.jRadioButton2.setSelected(true);
/* 3192 */         this.jTabbedPane1.removeAll();
/* 3193 */         this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */       } else {
/*      */         
/* 3196 */         this.jRadioButton1.setSelected(true);
/* 3197 */         this.jTabbedPane1.removeAll();
/* 3198 */         this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 3199 */         this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */       } 
/* 3201 */       verFiniquitos();
/* 3202 */       this.jButton5.setEnabled(false);
/* 3203 */       this.jButton9.setEnabled(false);
/* 3204 */       this.jButton15.setEnabled(false);
/* 3205 */       this.jButton16.setEnabled(false);
/* 3206 */       this.jButton17.setEnabled(false);
/* 3207 */       this.jDateChooser10.setEnabled(false);
/* 3208 */       this.jButton4.setText("Imprimir");
/* 3209 */       this.jButton4.setMnemonic('I');
/* 3210 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 3215 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 3219 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 3223 */     this.jTextArea5.setText("");
/* 3224 */     int ind = this.jTable3.getSelectedRow();
/* 3225 */     if (ind < 0) {
/* 3226 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una valor para modificar los datos", "Selecciona una formato", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 3229 */       String estatus = String.valueOf(this.jTable3.getValueAt(ind, 9));
/* 3230 */       if (!estatus.contains("<Por Pagar>")) {
/* 3231 */         JOptionPane.showMessageDialog(this.padre, "No puedes cancelar el documento porque su estatus no es '<Por Pagar>'", "No se puede cancelar", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 3234 */         this.jDialog7.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 3240 */     int ind = this.jTable3.getSelectedRow();
/* 3241 */     String estatus = String.valueOf(this.jTable3.getValueAt(ind, 9));
/* 3242 */     if (ind < 0) {
/* 3243 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un valor para ver los datos", "Selecciona un formato", 0, this.ADVER);
/*      */     }
/* 3245 */     else if (!estatus.contains("<Por Pagar>")) {
/* 3246 */       JOptionPane.showMessageDialog(this.padre, "No puedes autorizar el documento porque su estatus no es '<Por Pagar>'", "Finiquito Autorizado", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 3249 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas autorizar el pago del finiquito?", "Autorizar Finiquito", 0, 3, this.PREG);
/* 3250 */       if (res == 0) {
/* 3251 */         this.con.inserSinMsj("update finiquitos_regis set estatus='<Autorizado: " + this.USUARIO + " " + cargarFechaHoy() + ">' where folio_fini='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "'");
/* 3252 */         consultar2();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 3258 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 3262 */     this.jTextField29.setText("");
/* 3263 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 3264 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 3268 */     if (this.jTable1.getSelectedRow() < 0) {
/* 3269 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un dato para quitar la gratificación", "Selecciona una gratificación", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 3272 */       String dato = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/* 3273 */       if (dato.charAt(0) == '*') {
/* 3274 */         DefaultTableModel temp = (DefaultTableModel)this.jTable1.getModel();
/* 3275 */         temp.removeRow(this.jTable1.getSelectedRow());
/* 3276 */         sacarTotalComp();
/* 3277 */         sacarTotalNeto();
/*      */       } else {
/*      */         
/* 3280 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar una gratificación, recuerda que los valores del cálculo no se pueden omitir", "Selecciona una gratficación", 0, this.ERROR);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 3286 */     this.jTextField30.setText("");
/* 3287 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/* 3288 */     this.jDialog6.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 3292 */     if (this.jTable2.getSelectedRow() < 0) {
/* 3293 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un dato para quitar la gratificación", "Selecciona una gratificación", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 3296 */       String dato = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0));
/* 3297 */       if (dato.charAt(0) == '*') {
/* 3298 */         DefaultTableModel temp = (DefaultTableModel)this.jTable2.getModel();
/* 3299 */         temp.removeRow(this.jTable2.getSelectedRow());
/* 3300 */         sacarTotalImss();
/* 3301 */         sacarTotalNeto();
/*      */       } else {
/*      */         
/* 3304 */         JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar una gratificación, recuerda que los valores del cálculo no se pueden omitir", "Selecciona una gratficación", 0, this.ERROR);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton37ActionPerformed(ActionEvent evt) {
/* 3310 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton38ActionPerformed(ActionEvent evt) {
/* 3314 */     String cant = this.jFormattedTextField5.getText();
/*      */     
/* 3316 */     boolean correcto = false;
/* 3317 */     String[] nombres = null;
/* 3318 */     int esp = 0;
/* 3319 */     String texto = this.jTextField29.getText(); int i;
/* 3320 */     for (i = 0; i < texto.length(); i++) {
/* 3321 */       if (texto.charAt(i) == ' ') {
/* 3322 */         esp++;
/*      */       }
/*      */     } 
/* 3325 */     nombres = new String[esp + 1];
/* 3326 */     for (i = 0; i <= esp; i++) {
/* 3327 */       nombres[i] = "";
/*      */     }
/* 3329 */     esp = 0;
/* 3330 */     for (i = 0; i < texto.length(); i++) {
/* 3331 */       if (texto.charAt(i) == ' ') {
/* 3332 */         esp++;
/*      */       } else {
/*      */         
/* 3335 */         nombres[esp] = nombres[esp] + nombres[esp];
/*      */       } 
/*      */     } 
/* 3338 */     for (i = 0; i < nombres.length; i++) {
/* 3339 */       if (nombres[i].length() == 0) {
/* 3340 */         this.jTextField29.setBackground(Color.RED);
/* 3341 */         JOptionPane.showMessageDialog(this.jDialog3, "Tienes un espacio de más en la descripción del concepto", "Error 031 - Espacio", 0, this.ERROR);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 3346 */     if (cant.equals("$0.00")) {
/* 3347 */       this.jFormattedTextField5.setBackground(Color.RED);
/* 3348 */       JOptionPane.showMessageDialog(this.jDialog5, "No puedes colocar cantidad menores a cero", "Cantidad pequeña", 0, this.ERROR);
/*      */     }
/* 3350 */     else if (this.jTextField29.getText().equals("")) {
/* 3351 */       this.jTextField29.setBackground(Color.RED);
/* 3352 */       JOptionPane.showMessageDialog(this.jDialog5, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/*      */     
/*      */     }
/* 3355 */     else if (this.jTextField29.getText().length() > 999) {
/* 3356 */       this.jTextField29.setBackground(Color.RED);
/* 3357 */       JOptionPane.showMessageDialog(this.jDialog5, "No puedes agregar más 999 caracteres en el concepto", "Concepto muy largo", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 3360 */       String desc = this.jTextField29.getText().toUpperCase();
/* 3361 */       String valor = String.valueOf(this.jFormattedTextField5.getValue());
/*      */       
/* 3363 */       String valorP = "";
/* 3364 */       for (int j = 0; j < valor.length(); j++) {
/* 3365 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',') {
/* 3366 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 3370 */       int res = JOptionPane.showConfirmDialog(this.jDialog5, "¿Deseas agregar el nuevo concepto?", "Agregar concepto", 0, 3, this.PREG);
/* 3371 */       if (res == 0) {
/* 3372 */         DefaultTableModel temp = (DefaultTableModel)this.jTable1.getModel();
/* 3373 */         Object[] nuevo = { "*" + desc, "", "", "", "", "", "", this.jFormattedTextField5.getText() };
/* 3374 */         temp.addRow(nuevo);
/* 3375 */         this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 3376 */         this.jTextField29.setText("");
/*      */         
/* 3378 */         sacarTotalComp();
/* 3379 */         sacarTotalImss();
/* 3380 */         sacarTotalNeto();
/* 3381 */         this.jDialog5.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton39ActionPerformed(ActionEvent evt) {
/* 3387 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton40ActionPerformed(ActionEvent evt) {
/* 3391 */     String cant = this.jFormattedTextField6.getText();
/*      */     
/* 3393 */     boolean correcto = false;
/* 3394 */     String[] nombres = null;
/* 3395 */     int esp = 0;
/* 3396 */     String texto = this.jTextField30.getText(); int i;
/* 3397 */     for (i = 0; i < texto.length(); i++) {
/* 3398 */       if (texto.charAt(i) == ' ') {
/* 3399 */         esp++;
/*      */       }
/*      */     } 
/* 3402 */     nombres = new String[esp + 1];
/* 3403 */     for (i = 0; i <= esp; i++) {
/* 3404 */       nombres[i] = "";
/*      */     }
/* 3406 */     esp = 0;
/* 3407 */     for (i = 0; i < texto.length(); i++) {
/* 3408 */       if (texto.charAt(i) == ' ') {
/* 3409 */         esp++;
/*      */       } else {
/*      */         
/* 3412 */         nombres[esp] = nombres[esp] + nombres[esp];
/*      */       } 
/*      */     } 
/* 3415 */     for (i = 0; i < nombres.length; i++) {
/* 3416 */       if (nombres[i].length() == 0) {
/* 3417 */         this.jTextField30.setBackground(Color.RED);
/* 3418 */         JOptionPane.showMessageDialog(this.jDialog6, "Tienes un espacio de más en la descripción del concepto", "Error 031 - Espacio", 0, this.ERROR);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 3423 */     if (cant.equals("$0.00")) {
/* 3424 */       this.jFormattedTextField6.setBackground(Color.RED);
/* 3425 */       JOptionPane.showMessageDialog(this.jDialog6, "No puedes colocar cantidad menores a cero", "Cantidad pequeña", 0, this.ERROR);
/*      */     }
/* 3427 */     else if (this.jTextField30.getText().equals("")) {
/* 3428 */       this.jTextField30.setBackground(Color.RED);
/* 3429 */       JOptionPane.showMessageDialog(this.jDialog6, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/*      */     
/*      */     }
/* 3432 */     else if (this.jTextField30.getText().length() > 999) {
/* 3433 */       this.jTextField30.setBackground(Color.RED);
/* 3434 */       JOptionPane.showMessageDialog(this.jDialog6, "No puedes agregar más 999 caracteres en el concepto", "Concepto muy largo", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 3437 */       String desc = this.jTextField30.getText().toUpperCase();
/* 3438 */       String valor = String.valueOf(this.jFormattedTextField6.getValue());
/*      */       
/* 3440 */       String valorP = "";
/* 3441 */       for (int j = 0; j < valor.length(); j++) {
/* 3442 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',') {
/* 3443 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 3447 */       int res = JOptionPane.showConfirmDialog(this.jDialog6, "¿Deseas agregar el nuevo concepto?", "Agregar concepto", 0, 3, this.PREG);
/* 3448 */       if (res == 0) {
/* 3449 */         DefaultTableModel temp = (DefaultTableModel)this.jTable2.getModel();
/* 3450 */         Object[] nuevo = { "*" + desc, "", "", "", "", "", "", this.jFormattedTextField6.getText() };
/* 3451 */         temp.addRow(nuevo);
/* 3452 */         this.jFormattedTextField6.setValue(Integer.valueOf(0));
/* 3453 */         this.jTextField30.setText("");
/*      */         
/* 3455 */         sacarTotalComp();
/* 3456 */         sacarTotalImss();
/* 3457 */         sacarTotalNeto();
/* 3458 */         this.jDialog6.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 3466 */     this.jDialog8.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTable7MouseClicked(MouseEvent evt) {
/* 3470 */     if (evt.getClickCount() == 2) {
/* 3471 */       cargarMov();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel53MouseEntered(MouseEvent evt) {
/* 3477 */     this.jLabel53.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel53MouseExited(MouseEvent evt) {
/* 3481 */     this.jLabel53.setForeground(Color.RED);
/*      */   }
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 3484 */     this.jDialog9.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 3488 */     this.jDialog8.setVisible(false);
/*      */   }
/*      */   
/*      */   public void cargarMov() {
/* 3492 */     int indice = this.jTable7.getSelectedRow();
/* 3493 */     this.jTextField11.setText(String.valueOf(this.jTable7.getValueAt(indice, 0)));
/* 3494 */     this.jDialog9.setTitle("Movimiento - " + String.valueOf(this.jTable7.getValueAt(indice, 0)));
/* 3495 */     String fecha = String.valueOf(this.jTable7.getValueAt(indice, 1));
/* 3496 */     String año = fecha.substring(0, 4);
/* 3497 */     String mes = fecha.substring(5, 7);
/* 3498 */     String dia = fecha.substring(8, 10);
/* 3499 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 3500 */     String cargo = String.valueOf(this.jTable7.getValueAt(indice, 6));
/* 3501 */     this.jTextField12.setText(strFecha);
/* 3502 */     if (!cargo.equals("")) {
/* 3503 */       cargo = "ABONO";
/* 3504 */       this.jLabel56.setText(String.valueOf(this.jTable7.getValueAt(indice, 2)));
/* 3505 */       this.jLabel76.setText(String.valueOf(this.jTable7.getValueAt(indice, 6)));
/*      */     } else {
/*      */       
/* 3508 */       cargo = "CARGO";
/* 3509 */       this.jLabel56.setText(String.valueOf(this.jTable7.getValueAt(indice, 2)));
/* 3510 */       this.jLabel76.setText(String.valueOf(this.jTable7.getValueAt(indice, 5)));
/*      */     } 
/* 3512 */     this.jLabel54.setText(cargo);
/* 3513 */     this.jLabel74.setText(String.valueOf(this.jTable7.getValueAt(indice, 3)));
/* 3514 */     String estatus = String.valueOf(this.jTable7.getValueAt(indice, 8));
/* 3515 */     this.con.consultar("observaciones", "tarjeta_contenido", "where mov = " + String.valueOf(this.jTable7.getValueAt(indice, 0)));
/* 3516 */     this.jTextArea1.setText(this.con.Campo);
/* 3517 */     if (estatus.equals("<Cancelado>")) {
/* 3518 */       this.jLabel53.setVisible(true);
/*      */     } else {
/*      */       
/* 3521 */       this.jLabel53.setVisible(false);
/*      */     } 
/* 3523 */     this.jDialog9.setVisible(true);
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 3527 */     String motivo = this.jTextArea5.getText();
/* 3528 */     if (motivo.equals("")) {
/* 3529 */       this.jTextArea5.setBackground(Color.RED);
/* 3530 */       JOptionPane.showMessageDialog(this.jDialog7, "Necesitas colocar el motivo por el cual se cancela el pago del finiquito", "Coloca un comentario", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 3533 */       int res = JOptionPane.showConfirmDialog(this.jDialog7, "¿Estás seguro que deseas cancelar el pago del finiquito que seleccionaste?", "Cancelar Finiquito", 0, 3, this.PREG);
/* 3534 */       if (res == 0) {
/* 3535 */         String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/* 3536 */         this.con.inserSinMsj("update finiquitos_regis set estatus='<Cancelado: " + this.USUARIO + " " + cargarFechaHoy() + "-" + this.jTextArea5.getText().toUpperCase() + "' where folio_fini='" + num + "'");
/* 3537 */         consultar2();
/* 3538 */         this.jDialog7.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 3544 */     Calendar ahoraCal = Calendar.getInstance();
/* 3545 */     ahoraCal.setTime(this.fecha);
/* 3546 */     String mesesito = "";
/* 3547 */     String hoy = "";
/* 3548 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 3549 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 3551 */     if (ahoraCal.get(2) + 1 < 10) {
/* 3552 */       mesesito = "0" + mesesito;
/*      */     }
/* 3554 */     if (ahoraCal.get(5) < 10) {
/* 3555 */       hoy = "0" + hoy;
/*      */     }
/* 3557 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void verFiniquitos() {
/* 3561 */     this.jButton4.setText("Guardar");
/* 3562 */     this.jButton4.setMnemonic('G');
/* 3563 */     this.jRadioButton1.setEnabled(false);
/* 3564 */     this.jRadioButton2.setEnabled(false);
/* 3565 */     this.jButton12.setEnabled(false);
/* 3566 */     this.jButton13.setEnabled(false);
/* 3567 */     this.jButton8.setEnabled(false);
/* 3568 */     this.jButton7.setEnabled(false);
/* 3569 */     this.jButton11.setEnabled(false);
/* 3570 */     this.jButton10.setEnabled(false);
/* 3571 */     this.jDateChooser7.setEnabled(false);
/* 3572 */     this.jDateChooser8.setEnabled(false);
/* 3573 */     this.jDateChooser11.setEnabled(false);
/* 3574 */     this.jDateChooser12.setEnabled(false);
/* 3575 */     this.jComboBox5.setEnabled(false);
/* 3576 */     this.jComboBox6.setEnabled(false);
/* 3577 */     this.jButton9.setEnabled(true);
/* 3578 */     this.jButton15.setEnabled(true);
/* 3579 */     this.jButton16.setEnabled(true);
/* 3580 */     this.jButton17.setEnabled(true);
/*      */     
/* 3582 */     this.jTextField6.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)));
/* 3583 */     this.jTextField5.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4)));
/* 3584 */     this.jComboBox6.removeAllItems();
/* 3585 */     this.jComboBox6.addItem(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 5)));
/* 3586 */     this.jLabel13.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7)));
/*      */     
/* 3588 */     String[] regis = this.con.regresaReg("fecha_Ingreso,fecha_vac_inicio,fecha_vac_final,diasDer,periodo,fecha_agui_inicio,fecha_agui_final", "finiquitos_regis,finiquitos_concep", "where finiquitos_regis.folio_fini = finiquitos_concep.folio_fini and finiquitos_regis.folio_fini = '" + this.jTextField6.getText() + "' and concepto='VACACIONES'", 7);
/* 3589 */     this.jComboBox5.setSelectedItem(regis[4]);
/*      */     
/* 3591 */     this.con.consultar("count(num)", "finiquitos_concep", "where folio_fini='" + this.jTextField6.getText() + "' and tipo=0");
/* 3592 */     int totreg = Integer.parseInt(this.con.Campo);
/* 3593 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 3594 */           .buscarReg(8, totreg, "concepto,diasLey,diasAnual,FactorDias,diasDer,subtotalDias,salario,total", "finiquitos_concep", "where folio_fini='" + this.jTextField6.getText() + "' and tipo=0 order by num asc"), (Object[])new String[] { "Concepto", "Dias Ley", "Dias del Año", "Factor en Días", "Días con Derecho", "Subtotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */           
/* 3598 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3602 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3605 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 3606 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(160);
/* 3607 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(160);
/* 3608 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(80);
/* 3609 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
/* 3610 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3611 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3612 */     this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3613 */     this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 3614 */     this.jTable1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 3615 */     this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 3616 */     this.jTable1.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/*      */     
/* 3618 */     this.con.consultar("count(num)", "finiquitos_concep", "where folio_fini='" + this.jTextField6.getText() + "' and tipo=1");
/* 3619 */     totreg = Integer.parseInt(this.con.Campo);
/* 3620 */     this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 3621 */           .buscarReg(8, totreg, "concepto,diasLey,diasAnual,FactorDias,diasDer,subtotalDias,salario,total", "finiquitos_concep", "where folio_fini='" + this.jTextField6.getText() + "' and tipo=1 order by num asc"), (Object[])new String[] { "Concepto", "Dias Ley", "Dias del Año", "Factor en Días", "Días con Derecho", "Subtotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */           
/* 3625 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3629 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3632 */     this.jScrollPane2.setViewportView(this.jTable2);
/* 3633 */     this.jTable2.getColumnModel().getColumn(0).setMinWidth(160);
/* 3634 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(160);
/* 3635 */     this.jTable2.getColumnModel().getColumn(1).setMinWidth(80);
/* 3636 */     this.jTable2.getColumnModel().getColumn(1).setMaxWidth(80);
/* 3637 */     this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3638 */     this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3639 */     this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3640 */     this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 3641 */     this.jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 3642 */     this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 3643 */     this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/*      */     
/* 3645 */     this.con.consultar("count(num)", "finiquitos_desc", "where folio_fini='" + this.jTextField6.getText() + "' and tipo =0");
/* 3646 */     totreg = Integer.parseInt(this.con.Campo);
/* 3647 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 3648 */           .buscarReg(2, totreg, "concepto,total", "finiquitos_desc", "where folio_fini='" + this.jTextField6.getText() + "' and tipo=0"), (Object[])new String[] { "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */           
/* 3652 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3656 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3659 */     this.jScrollPane4.setViewportView(this.jTable4);
/* 3660 */     this.jTable4.getColumnModel().getColumn(1).setMinWidth(180);
/* 3661 */     this.jTable4.getColumnModel().getColumn(1).setMaxWidth(180);
/* 3662 */     this.jTable4.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */     
/* 3664 */     this.con.consultar("count(num)", "finiquitos_desc", "where folio_fini='" + this.jTextField6.getText() + "' and tipo =1");
/* 3665 */     totreg = Integer.parseInt(this.con.Campo);
/* 3666 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/* 3667 */           .buscarReg(2, totreg, "concepto,total", "finiquitos_desc", "where folio_fini='" + this.jTextField6.getText() + "' and tipo=1"), (Object[])new String[] { "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */           
/* 3671 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3675 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3678 */     this.jScrollPane5.setViewportView(this.jTable5);
/* 3679 */     this.jTable5.getColumnModel().getColumn(1).setMinWidth(180);
/* 3680 */     this.jTable5.getColumnModel().getColumn(1).setMaxWidth(180);
/* 3681 */     this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */     
/* 3683 */     this.jTextField7.setText(String.valueOf(this.jTable1.getValueAt(0, 4)));
/* 3684 */     this.jTextField4.setText(String.valueOf(this.jTable2.getValueAt(1, 4)));
/*      */     
/* 3686 */     String fecha = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2));
/* 3687 */     String fechaCorta = fecha.substring(0, 10);
/* 3688 */     String año = fechaCorta.substring(0, 4);
/* 3689 */     String mes = fechaCorta.substring(5, 7);
/* 3690 */     String dia = fechaCorta.substring(8, 10);
/* 3691 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 3692 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 3694 */       Date fechaT = formatoDelTexto.parse(strFecha);
/* 3695 */       this.jDateChooser10.setDate(fechaT);
/*      */     }
/* 3697 */     catch (ParseException ex) {
/* 3698 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 3701 */     fecha = regis[0];
/* 3702 */     fechaCorta = fecha.substring(0, 10);
/* 3703 */     año = fechaCorta.substring(0, 4);
/* 3704 */     mes = fechaCorta.substring(5, 7);
/* 3705 */     dia = fechaCorta.substring(8, 10);
/* 3706 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 3707 */     strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 3709 */       Date fechaT = formatoDelTexto.parse(strFecha);
/* 3710 */       this.jDateChooser9.setDate(fechaT);
/*      */     }
/* 3712 */     catch (ParseException ex) {
/* 3713 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 3716 */     fecha = regis[1];
/* 3717 */     fechaCorta = fecha.substring(0, 10);
/* 3718 */     año = fechaCorta.substring(0, 4);
/* 3719 */     mes = fechaCorta.substring(5, 7);
/* 3720 */     dia = fechaCorta.substring(8, 10);
/* 3721 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 3722 */     strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 3724 */       Date fechaT = formatoDelTexto.parse(strFecha);
/* 3725 */       this.jDateChooser7.setDate(fechaT);
/*      */     }
/* 3727 */     catch (ParseException ex) {
/* 3728 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 3731 */     fecha = regis[2];
/* 3732 */     fechaCorta = fecha.substring(0, 10);
/* 3733 */     año = fechaCorta.substring(0, 4);
/* 3734 */     mes = fechaCorta.substring(5, 7);
/* 3735 */     dia = fechaCorta.substring(8, 10);
/* 3736 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 3737 */     strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 3739 */       Date fechaT = formatoDelTexto.parse(strFecha);
/* 3740 */       this.jDateChooser8.setDate(fechaT);
/*      */     }
/* 3742 */     catch (ParseException ex) {
/* 3743 */       ex.printStackTrace();
/*      */     } 
/*      */ 
/*      */     
/* 3747 */     String fechita = regis[5];
/* 3748 */     System.out.println("fechita " + fechita);
/* 3749 */     if (fechita.equals("null")) {
/* 3750 */       System.out.println("Entraa");
/* 3751 */       this.jDateChooser11.setDate(null);
/* 3752 */       this.jDateChooser12.setDate(null);
/*      */     } else {
/*      */       
/* 3755 */       fecha = regis[5];
/* 3756 */       fechaCorta = fecha.substring(0, 10);
/* 3757 */       año = fechaCorta.substring(0, 4);
/* 3758 */       mes = fechaCorta.substring(5, 7);
/* 3759 */       dia = fechaCorta.substring(8, 10);
/* 3760 */       formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 3761 */       strFecha = dia + "-" + dia + "-" + mes;
/*      */       try {
/* 3763 */         Date fechaT = formatoDelTexto.parse(strFecha);
/* 3764 */         this.jDateChooser11.setDate(fechaT);
/*      */       }
/* 3766 */       catch (ParseException ex) {
/* 3767 */         ex.printStackTrace();
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3785 */       fecha = regis[6];
/* 3786 */       System.out.println("FEchaaaaa " + fecha);
/* 3787 */       fechaCorta = fecha.substring(0, 10);
/* 3788 */       año = fechaCorta.substring(0, 4);
/* 3789 */       mes = fechaCorta.substring(5, 7);
/* 3790 */       dia = fechaCorta.substring(8, 10);
/* 3791 */       formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 3792 */       strFecha = dia + "-" + dia + "-" + mes;
/*      */       try {
/* 3794 */         Date fechaT = formatoDelTexto.parse(strFecha);
/* 3795 */         this.jDateChooser12.setDate(fechaT);
/*      */       }
/* 3797 */       catch (ParseException ex) {
/* 3798 */         ex.printStackTrace();
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
/* 3817 */     this.con.consultar("clave", "finiquitos_regis", "where folio_fini='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "'");
/* 3818 */     this.CLAVE = this.con.Campo;
/* 3819 */     if (this.jRadioButton1.isSelected()) {
/* 3820 */       this.DATOS = this.con.regresaReg("ultimoIngreso,SalarioReal,salarioimss", "empleados", "where clave_emp=" + this.con.Campo, 3);
/*      */     } else {
/*      */       
/* 3823 */       this.jComboBox6.addItem("OPERADOR");
/* 3824 */       this.DATOS = new String[] { "", "", "" };
/* 3825 */       String[] AUX = this.con.regresaReg("ultimaFechaIngreso,SalarioImssLetra", "operadores", "where num_ope=" + this.con.Campo, 2);
/* 3826 */       this.DATOS[0] = AUX[0];
/* 3827 */       this.DATOS[1] = "0";
/* 3828 */       this.DATOS[2] = AUX[1];
/*      */     } 
/* 3830 */     this.DIAS = Integer.parseInt(String.valueOf(this.jTable1.getValueAt(1, 1)));
/* 3831 */     sacarTotalComp();
/* 3832 */     sacarTotalImss();
/* 3833 */     sacarTotalNeto();
/* 3834 */     this.ACTIVO = true;
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 3838 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 3846 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 3852 */         return 30;
/*      */       
/*      */       case 1:
/* 3855 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 3857 */           return 29;
/*      */         }
/* 3859 */         return 28;
/*      */     } 
/*      */     
/* 3862 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void restarFechasAgui() {
/* 3867 */     if (this.jDateChooser11.getDate() == null) {
/* 3868 */       this.jTextField7.setText("0");
/* 3869 */       this.jTable1.setValueAt(Integer.valueOf(0), 0, 4);
/* 3870 */       this.jTable2.setValueAt(Integer.valueOf(0), 0, 4);
/*      */     } else {
/*      */       
/* 3873 */       int dias = 0;
/* 3874 */       int rangoAnyos = 0;
/* 3875 */       int diasAnyo = 0;
/*      */       
/* 3877 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3878 */       String cadenaFecha1 = formato.format(this.jDateChooser12.getDate());
/* 3879 */       String año = cadenaFecha1.substring(0, 4);
/* 3880 */       String mes = cadenaFecha1.substring(4, 6);
/* 3881 */       String dia = cadenaFecha1.substring(6, 8);
/*      */       
/* 3883 */       Date fecha1 = this.jDateChooser11.getDate();
/* 3884 */       Date fecha2 = this.jDateChooser12.getDate();
/*      */       
/* 3886 */       long fechaInicialMs = fecha1.getTime();
/* 3887 */       long fechaFinalMs = fecha2.getTime();
/* 3888 */       long diferencia = fechaFinalMs - fechaInicialMs;
/* 3889 */       dias = (int)Math.floor((diferencia / 86400000L));
/* 3890 */       dias++;
/*      */       
/* 3892 */       int mesI = Integer.parseInt(mes);
/* 3893 */       int diaI = Integer.parseInt(dia);
/*      */       
/* 3895 */       Date fechaC = null;
/* 3896 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*      */       try {
/* 3898 */         fechaC = formatoDelTexto.parse("28-02-" + año);
/*      */       }
/* 3900 */       catch (ParseException ex) {
/* 3901 */         ex.printStackTrace();
/*      */       } 
/*      */       
/* 3904 */       if (fecha2.after(fechaC) && 
/* 3905 */         Integer.parseInt(año) % 4 == 0) {
/* 3906 */         dias--;
/*      */       }
/*      */       
/* 3909 */       this.jTable1.setValueAt(Integer.valueOf(dias), 0, 4);
/* 3910 */       this.jTable2.setValueAt(Integer.valueOf(dias), 0, 4);
/* 3911 */       this.jTextField7.setText("" + dias);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarTotalNeto() {
/* 3916 */     double valor1 = 0.0D;
/* 3917 */     String canti = this.jLabel19.getText();
/* 3918 */     String valorP = "";
/* 3919 */     for (int j = 0; j < canti.length(); j++) {
/* 3920 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3921 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3924 */     valor1 += Double.parseDouble(valorP);
/*      */     
/* 3926 */     double valor2 = 0.0D;
/* 3927 */     canti = this.jLabel21.getText();
/* 3928 */     valorP = "";
/* 3929 */     for (int i = 0; i < canti.length(); i++) {
/* 3930 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 3931 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3934 */     valor2 += Double.parseDouble(valorP);
/* 3935 */     valor1 += valor2;
/* 3936 */     this.cantidad.setValue(Double.valueOf(valor1));
/* 3937 */     this.jLabel13.setText(this.cantidad.getText());
/*      */     
/* 3939 */     this.numLetra = new NumerosALetras(valor1, "MXN");
/* 3940 */     this.jTextField3.setText(this.numLetra.regresaNumero());
/*      */   }
/*      */   
/*      */   public void sacarTotalImss() {
/* 3944 */     double complemento = 0.0D;
/* 3945 */     double descuentos = 0.0D; int i;
/* 3946 */     for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 3947 */       String canti = String.valueOf(this.jTable2.getValueAt(i, 7));
/* 3948 */       String valorP = "";
/* 3949 */       for (int j = 0; j < canti.length(); j++) {
/* 3950 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3951 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3954 */       complemento += Double.parseDouble(valorP);
/*      */     } 
/*      */     
/* 3957 */     for (i = 0; i < this.jTable5.getRowCount(); i++) {
/* 3958 */       String canti = String.valueOf(this.jTable5.getValueAt(i, 1));
/* 3959 */       String valorP = "";
/* 3960 */       for (int j = 0; j < canti.length(); j++) {
/* 3961 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3962 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3965 */       descuentos += Double.parseDouble(valorP);
/*      */     } 
/* 3967 */     complemento -= descuentos;
/* 3968 */     this.TOTAL2 = complemento;
/* 3969 */     this.cantidad.setValue(Double.valueOf(complemento));
/* 3970 */     this.jLabel21.setText(this.cantidad.getText());
/*      */   }
/*      */   
/*      */   public void sacarTotalComp() {
/* 3974 */     double complemento = 0.0D;
/* 3975 */     double descuentos = 0.0D; int i;
/* 3976 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 3977 */       String canti = String.valueOf(this.jTable1.getValueAt(i, 7));
/* 3978 */       String valorP = "";
/* 3979 */       for (int j = 0; j < canti.length(); j++) {
/* 3980 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3981 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3984 */       complemento += Double.parseDouble(valorP);
/*      */     } 
/*      */     
/* 3987 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 3988 */       String canti = String.valueOf(this.jTable4.getValueAt(i, 1));
/* 3989 */       String valorP = "";
/* 3990 */       for (int j = 0; j < canti.length(); j++) {
/* 3991 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3992 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3995 */       descuentos += Double.parseDouble(valorP);
/*      */     } 
/* 3997 */     complemento -= descuentos;
/* 3998 */     this.TOTAL1 = complemento;
/* 3999 */     this.cantidad.setValue(Double.valueOf(complemento));
/* 4000 */     this.jLabel19.setText(this.cantidad.getText());
/*      */   }
/*      */   public void calcularAguinaldo() {
/* 4003 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4004 */     String cadenaFecha1 = formato.format(this.jDateChooser10.getDate());
/* 4005 */     String año = cadenaFecha1.substring(0, 4);
/*      */     
/* 4007 */     formato = new SimpleDateFormat("yyyyMMdd");
/* 4008 */     cadenaFecha1 = formato.format(this.jDateChooser9.getDate());
/* 4009 */     String año2 = cadenaFecha1.substring(0, 4);
/*      */     
/* 4011 */     String tipo = "Administrativo";
/* 4012 */     if (this.jRadioButton2.isSelected()) {
/* 4013 */       tipo = "Operativo";
/*      */     }
/* 4015 */     String Anual = "";
/* 4016 */     this.encontrado = this.con.consultar("folio_agui", "aguinaldos", "where anual = " + año + " and tipo='" + tipo + "'");
/* 4017 */     if (this.encontrado) {
/* 4018 */       Anual = this.con.Campo;
/* 4019 */       this.encontrado = this.con.consultar("clave", "aguinaldos_contenido", "where folio_agui='" + Anual + "' and clave='" + this.CLAVE + "'");
/* 4020 */       if (this.encontrado) {
/* 4021 */         this.jDateChooser11.setDate(null);
/* 4022 */         this.jDateChooser12.setDate(null);
/* 4023 */         JOptionPane.showMessageDialog(this.jDialog1, "Al empleado ya se le ha pagado un aguinaldo\nNecesitas descontarle los días ya pagados.", "Aguinaldo pagado", 0, this.INFO);
/*      */       } 
/*      */     } 
/* 4026 */     if (!this.encontrado)
/* 4027 */       if (año.equals(año2)) {
/* 4028 */         this.jDateChooser11.setDate(this.jDateChooser7.getDate());
/*      */       } else {
/*      */         
/* 4031 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*      */         try {
/* 4033 */           this.jDateChooser11.setDate(formatoDelTexto.parse("01-01-" + año));
/*      */         }
/* 4035 */         catch (ParseException ex) {
/* 4036 */           ex.printStackTrace();
/*      */         } 
/*      */       }  
/*      */   }
/*      */   
/*      */   public void cargarTrabajador() {
/* 4042 */     this.FECHAFINAL = new Date();
/* 4043 */     this.CLAVE = String.valueOf(this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 0));
/* 4044 */     deshabilitar();
/* 4045 */     this.jRadioButton1.setEnabled(true);
/* 4046 */     this.jRadioButton2.setEnabled(true);
/* 4047 */     contarDias();
/* 4048 */     String clave = String.valueOf(this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 0));
/* 4049 */     this.jComboBox5.setSelectedIndex(0);
/* 4050 */     this.jTextField5.setText(String.valueOf(this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 1)));
/* 4051 */     String fecha = String.valueOf(this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 2));
/* 4052 */     this.jButton14.setEnabled(true);
/* 4053 */     this.jButton4.setEnabled(true);
/* 4054 */     this.jButton9.setEnabled(true);
/* 4055 */     this.jButton15.setEnabled(true);
/* 4056 */     this.jButton16.setEnabled(true);
/* 4057 */     this.jButton17.setEnabled(true);
/* 4058 */     this.jButton5.setEnabled(true);
/* 4059 */     this.ACTIVO = true;
/* 4060 */     this.jComboBox6.removeAllItems();
/* 4061 */     String[] periodo = null;
/* 4062 */     this.jDateChooser10.setEnabled(true);
/*      */     
/* 4064 */     if (this.PRIVILEGIOS.equals("SUPER USUARIO")) {
/* 4065 */       this.jComboBox5.setEnabled(true);
/* 4066 */       this.jDateChooser7.setEnabled(true);
/* 4067 */       this.jDateChooser8.setEnabled(true);
/* 4068 */       this.jDateChooser11.setEnabled(true);
/* 4069 */       this.jDateChooser12.setEnabled(true);
/*      */     } else {
/*      */       
/* 4072 */       this.jComboBox5.setEnabled(false);
/* 4073 */       this.jDateChooser7.setEnabled(false);
/* 4074 */       this.jDateChooser8.setEnabled(false);
/* 4075 */       this.jDateChooser11.setEnabled(false);
/* 4076 */       this.jDateChooser12.setEnabled(false);
/*      */     } 
/* 4078 */     if (this.jRadioButton1.isSelected()) {
/* 4079 */       this.encontrado = this.con.consultar("tarjeta", "tarjeta_deudor", "where clave_emp=" + clave);
/* 4080 */       if (this.encontrado) {
/* 4081 */         this.CLAVEOP = this.con.Campo;
/*      */       } else {
/*      */         
/* 4084 */         this.CLAVEOP = "0";
/*      */       } 
/*      */       
/* 4087 */       this.con.consultar("departamentos.nombre", "empleados,departamentos", "where empleados.clave_depa = departamentos.clave_depa and clave_emp = " + clave);
/* 4088 */       this.jComboBox6.addItem(this.con.Campo);
/* 4089 */       this.DATOS = this.con.regresaReg("ultimoIngreso,SalarioReal,salarioimss", "empleados", "where clave_emp=" + clave, 3);
/* 4090 */       this.encontrado = this.con.consultar("tipoAnual", "vacaciones_regis", "where clave=" + clave + " and tipoTrabajador='administrativo' and (estatus ='<Por Pagar>' || estatus like '%Autorizada%') order by num_vaca desc");
/* 4091 */       if (this.encontrado) {
/* 4092 */         periodo = this.con.regresaReg("tipoAnual,fecha2", "vacaciones_regis", "where clave=" + clave + " and tipoTrabajador='administrativo' and (estatus ='<Por Pagar>' || estatus like '%Autorizada%') order by num_vaca desc", 2);
/*      */       }
/*      */     } else {
/* 4095 */       this.encontrado = this.con.consultar("tarjeta", "tarjeta_deudor", "where num_ope=" + clave);
/* 4096 */       if (this.encontrado) {
/* 4097 */         this.CLAVEOP = this.con.Campo;
/*      */       } else {
/*      */         
/* 4100 */         this.CLAVEOP = "0";
/*      */       } 
/* 4102 */       this.jComboBox6.addItem("OPERADOR");
/* 4103 */       this.DATOS = new String[] { "", "", "" };
/* 4104 */       System.out.println("Fechas --->");
/* 4105 */       String[] AUX = this.con.regresaReg("ultimaFechaIngreso,SalarioImssLetra", "operadores", "where num_ope=" + clave, 2);
/* 4106 */       this.DATOS[0] = AUX[0];
/* 4107 */       this.DATOS[1] = "0";
/* 4108 */       this.DATOS[2] = AUX[1];
/* 4109 */       System.out.println("Vacaciones ---->");
/* 4110 */       this.encontrado = this.con.consultar("tipoAnual", "vacaciones_regis", "where clave=" + clave + " and tipoTrabajador='operador' order by num_vaca desc");
/* 4111 */       if (this.encontrado)
/* 4112 */         periodo = this.con.regresaReg("tipoAnual,fecha2", "vacaciones_regis", "where clave=" + clave + " and tipoTrabajador='operador' order by num_vaca asc", 2); 
/*      */     } 
/* 4114 */     String año = this.DATOS[0].substring(0, 4);
/* 4115 */     String mes = this.DATOS[0].substring(5, 7);
/* 4116 */     String dia = this.DATOS[0].substring(8, 10);
/*      */     
/* 4118 */     int añito = Integer.parseInt(año);
/* 4119 */     añito++;
/* 4120 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 4121 */     String strFecha = dia + "-" + dia + "-" + mes;
/* 4122 */     String strFecha2 = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 4124 */       Date fechaT = formatoDelTexto.parse(strFecha);
/* 4125 */       this.jDateChooser9.setDate(fechaT);
/* 4126 */       this.jDateChooser7.setDate(fechaT);
/* 4127 */       fechaT = formatoDelTexto.parse(strFecha2);
/* 4128 */       this.jDateChooser8.setDate(fechaT);
/*      */     }
/* 4130 */     catch (ParseException ex) {
/* 4131 */       ex.printStackTrace();
/*      */     } 
/* 4133 */     this.jButton13.setEnabled(true);
/*      */     
/* 4135 */     this.jTextField4.setText("365");
/* 4136 */     this.jButton7.setEnabled(true);
/* 4137 */     this.jButton8.setEnabled(true);
/*      */     
/* 4139 */     this.jButton10.setEnabled(true);
/* 4140 */     this.jButton11.setEnabled(true);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4145 */     if (this.encontrado) {
/* 4146 */       System.out.println("Entraaaa   --->>>> " + periodo[1]);
/* 4147 */       String per = periodo[0];
/* 4148 */       desglozarDias(per);
/* 4149 */       año = periodo[1].substring(0, 4);
/* 4150 */       mes = periodo[1].substring(5, 7);
/* 4151 */       dia = periodo[1].substring(8, 10);
/* 4152 */       formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 4153 */       strFecha = dia + "-" + dia + "-" + mes;
/* 4154 */       Date fechaT = null;
/*      */       try {
/* 4156 */         fechaT = formatoDelTexto.parse(strFecha);
/* 4157 */         this.jDateChooser7.setDate(fechaT);
/* 4158 */         this.jDateChooser8.setDate(this.FECHAFINAL);
/*      */       }
/* 4160 */       catch (ParseException ex) {
/* 4161 */         ex.printStackTrace();
/*      */       } 
/*      */     } else {
/*      */       
/* 4165 */       int dias = 0;
/* 4166 */       int rangoAnyos = 0;
/* 4167 */       int diasAnyo = 0;
/*      */       
/* 4169 */       GregorianCalendar date1 = new GregorianCalendar();
/* 4170 */       año = this.DATOS[0].substring(0, 4);
/* 4171 */       mes = this.DATOS[0].substring(5, 7);
/* 4172 */       dia = this.DATOS[0].substring(8, 10);
/* 4173 */       formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 4174 */       strFecha = dia + "-" + dia + "-" + mes;
/* 4175 */       Date fechaT = null;
/*      */       try {
/* 4177 */         fechaT = formatoDelTexto.parse(strFecha);
/* 4178 */         date1.setTime(fechaT);
/*      */       }
/* 4180 */       catch (ParseException ex) {
/* 4181 */         ex.printStackTrace();
/*      */       } 
/*      */       
/* 4184 */       GregorianCalendar date2 = new GregorianCalendar();
/* 4185 */       date2.setTime(new Date());
/*      */       
/* 4187 */       if (date1.get(1) == date2.get(1)) {
/* 4188 */         dias = Integer.parseInt(String.valueOf(date2.get(6) - date1.get(6)));
/*      */       } else {
/*      */         
/* 4191 */         diasAnyo = date1.isLeapYear(date1.get(1)) ? 365 : 365;
/* 4192 */         rangoAnyos = date2.get(1) - date1.get(1);
/* 4193 */         dias = rangoAnyos * diasAnyo + date2.get(6) - date1.get(6);
/*      */       } 
/*      */       
/* 4196 */       if (date1.get(1) % 4 == 0) {
/* 4197 */         dias++;
/*      */       }
/* 4199 */       if (date2.get(1) % 4 == 0) {
/* 4200 */         dias--;
/*      */       }
/* 4202 */       double val = Double.parseDouble("" + dias) / Double.parseDouble("365");
/* 4203 */       restarFechas();
/* 4204 */       if (val > 0.0D && val <= 1.0D) {
/* 4205 */         this.jComboBox5.setSelectedIndex(0);
/*      */       }
/* 4207 */       else if (val > 1.0D && val <= 2.0D) {
/* 4208 */         this.jComboBox5.setSelectedIndex(1);
/*      */       }
/* 4210 */       else if (val > 2.0D && val <= 3.0D) {
/* 4211 */         this.jComboBox5.setSelectedIndex(2);
/*      */       }
/* 4213 */       else if (val > 3.0D && val <= 4.0D) {
/* 4214 */         this.jComboBox5.setSelectedIndex(3);
/*      */       }
/* 4216 */       else if (val > 4.0D && val <= 5.0D) {
/* 4217 */         this.jComboBox5.setSelectedIndex(4);
/*      */       }
/* 4219 */       else if (val > 5.0D && val <= 6.0D) {
/* 4220 */         this.jComboBox5.setSelectedIndex(5);
/*      */       }
/* 4222 */       else if (val > 6.0D && val <= 7.0D) {
/* 4223 */         this.jComboBox5.setSelectedIndex(6);
/*      */       }
/* 4225 */       else if (val > 8.0D && val <= 9.0D) {
/* 4226 */         this.jComboBox5.setSelectedIndex(7);
/*      */       }
/* 4228 */       else if (val > 10.0D && val <= 11.0D) {
/* 4229 */         this.jComboBox5.setSelectedIndex(8);
/*      */       }
/* 4231 */       else if (val > 12.0D && val <= 13.0D) {
/* 4232 */         this.jComboBox5.setSelectedIndex(9);
/*      */       }
/* 4234 */       else if (val > 14.0D && val <= 15.0D) {
/* 4235 */         this.jComboBox5.setSelectedIndex(10);
/*      */       }
/* 4237 */       else if (val > 16.0D && val <= 17.0D) {
/* 4238 */         this.jComboBox5.setSelectedIndex(11);
/*      */       }
/* 4240 */       else if (val > 17.0D && val <= 18.0D) {
/* 4241 */         this.jComboBox5.setSelectedIndex(12);
/*      */       }
/* 4243 */       else if (val > 18.0D && val <= 19.0D) {
/* 4244 */         this.jComboBox5.setSelectedIndex(13);
/*      */       }
/* 4246 */       else if (val > 14.0D && val <= 15.0D) {
/* 4247 */         this.jComboBox5.setSelectedIndex(14);
/*      */       }
/* 4249 */       else if (val > 15.0D && val <= 16.0D) {
/* 4250 */         this.jComboBox5.setSelectedIndex(15);
/*      */       }
/* 4252 */       else if (val > 16.0D && val <= 17.0D) {
/* 4253 */         this.jComboBox5.setSelectedIndex(16);
/*      */       }
/* 4255 */       else if (val > 17.0D && val <= 18.0D) {
/* 4256 */         this.jComboBox5.setSelectedIndex(17);
/*      */       }
/* 4258 */       else if (val > 18.0D && val <= 19.0D) {
/* 4259 */         this.jComboBox5.setSelectedIndex(18);
/*      */       }
/* 4261 */       else if (val > 19.0D && val <= 20.0D) {
/* 4262 */         this.jComboBox5.setSelectedIndex(19);
/*      */       }
/* 4264 */       else if (val > 20.0D && val <= 21.0D) {
/* 4265 */         this.jComboBox5.setSelectedIndex(20);
/*      */       }
/* 4267 */       else if (val > 21.0D && val <= 22.0D) {
/* 4268 */         this.jComboBox5.setSelectedIndex(21);
/*      */       }
/* 4270 */       else if (val > 22.0D && val <= 23.0D) {
/* 4271 */         this.jComboBox5.setSelectedIndex(22);
/*      */       }
/* 4273 */       else if (val > 23.0D && val <= 24.0D) {
/* 4274 */         this.jComboBox5.setSelectedIndex(23);
/*      */       }
/* 4276 */       else if (val > 24.0D && val <= 25.0D) {
/* 4277 */         this.jComboBox5.setSelectedIndex(24);
/*      */       }
/* 4279 */       else if (val > 25.0D && val <= 26.0D) {
/* 4280 */         this.jComboBox5.setSelectedIndex(25);
/*      */       }
/* 4282 */       else if (val > 26.0D && val <= 27.0D) {
/* 4283 */         this.jComboBox5.setSelectedIndex(26);
/*      */       }
/* 4285 */       else if (val > 27.0D && val <= 28.0D) {
/* 4286 */         this.jComboBox5.setSelectedIndex(27);
/*      */       }
/* 4288 */       else if (val > 28.0D && val <= 29.0D) {
/* 4289 */         this.jComboBox5.setSelectedIndex(28);
/*      */       }
/* 4291 */       else if (val > 29.0D && val <= 30.0D) {
/* 4292 */         this.jComboBox5.setSelectedIndex(29);
/*      */       }
/* 4294 */       else if (val > 30.0D && val <= 31.0D) {
/* 4295 */         this.jComboBox5.setSelectedIndex(30);
/*      */       }
/* 4297 */       else if (val > 31.0D && val <= 32.0D) {
/* 4298 */         this.jComboBox5.setSelectedIndex(31);
/*      */       }
/* 4300 */       else if (val > 32.0D && val <= 33.0D) {
/* 4301 */         this.jComboBox5.setSelectedIndex(32);
/*      */       }
/* 4303 */       else if (val > 33.0D && val <= 34.0D) {
/* 4304 */         this.jComboBox5.setSelectedIndex(33);
/*      */       }
/* 4306 */       else if (val > 34.0D && val <= 35.0D) {
/* 4307 */         this.jComboBox5.setSelectedIndex(34);
/*      */       }
/* 4309 */       else if (val > 35.0D && val <= 36.0D) {
/* 4310 */         this.jComboBox5.setSelectedIndex(35);
/*      */       }
/* 4312 */       else if (val > 36.0D && val <= 37.0D) {
/* 4313 */         this.jComboBox5.setSelectedIndex(36);
/*      */       }
/* 4315 */       else if (val > 37.0D && val <= 38.0D) {
/* 4316 */         this.jComboBox5.setSelectedIndex(37);
/*      */       }
/* 4318 */       else if (val > 38.0D && val <= 39.0D) {
/* 4319 */         this.jComboBox5.setSelectedIndex(38);
/*      */       }
/* 4321 */       else if (val > 39.0D && val <= 40.0D) {
/* 4322 */         this.jComboBox5.setSelectedIndex(39);
/*      */       }
/* 4324 */       else if (val > 40.0D && val <= 15.0D) {
/* 4325 */         this.jComboBox5.setSelectedIndex(40);
/*      */       } 
/*      */     } 
/*      */     
/* 4329 */     this.jLabel65.setText("TARJETA DE " + this.jTextField5.getText());
/* 4330 */     consultar3();
/*      */     
/* 4332 */     this.jDateChooser8.setDate(new Date());
/* 4333 */     calcularAguinaldo();
/*      */     
/* 4335 */     restarFechasAgui();
/* 4336 */     restarFechas();
/* 4337 */     calcularVaca();
/*      */     
/* 4339 */     sacarTotalComp();
/* 4340 */     sacarTotalImss();
/* 4341 */     sacarTotalNeto();
/*      */     
/* 4343 */     if (this.jRadioButton1.isSelected()) {
/* 4344 */       if (!this.jTextField8.getText().equals("$0.00")) {
/* 4345 */         String canti = this.jTextField8.getText();
/* 4346 */         double dCargo = 0.0D;
/*      */         
/* 4348 */         String valorP = "";
/* 4349 */         for (int j = 0; j < canti.length(); j++) {
/* 4350 */           if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4351 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 4354 */         dCargo = Double.parseDouble(valorP);
/*      */         
/* 4356 */         if (dCargo > this.TOTAL1) {
/* 4357 */           this.aux.setValue(Double.valueOf(this.TOTAL1));
/*      */           
/* 4359 */           DefaultTableModel temp = (DefaultTableModel)this.jTable4.getModel();
/* 4360 */           Object[] nuevo = { "ADEUDO EN LA TARJETA DEUDOR", this.aux.getText() };
/* 4361 */           temp.addRow(nuevo);
/* 4362 */           this.jTable4.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */           
/* 4364 */           double desc = dCargo - this.TOTAL1;
/* 4365 */           this.aux.setValue(Double.valueOf(desc));
/*      */           
/* 4367 */           temp = (DefaultTableModel)this.jTable5.getModel();
/* 4368 */           Object[] nuevo2 = { "ADEUDO EN LA TARJETA DEUDOR", this.aux.getText() };
/* 4369 */           temp.addRow(nuevo2);
/* 4370 */           this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */         } else {
/*      */           
/* 4373 */           DefaultTableModel temp = (DefaultTableModel)this.jTable4.getModel();
/* 4374 */           Object[] nuevo = { "ADEUDO EN LA TARJETA DEUDOR", this.jTextField8.getText() };
/* 4375 */           temp.addRow(nuevo);
/* 4376 */           this.jTable4.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */         }
/*      */       
/*      */       }
/*      */     
/* 4381 */     } else if (!this.jTextField8.getText().equals("$0.00")) {
/* 4382 */       DefaultTableModel temp = (DefaultTableModel)this.jTable5.getModel();
/* 4383 */       Object[] nuevo = { "ADEUDO EN LA TARJETA DEUDOR", this.jTextField8.getText() };
/* 4384 */       temp.addRow(nuevo);
/* 4385 */       this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */     } 
/*      */ 
/*      */     
/* 4389 */     sacarTotalComp();
/* 4390 */     sacarTotalImss();
/* 4391 */     sacarTotalNeto();
/*      */     
/* 4393 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   public void consultar2() {
/* 4397 */     Date fecha1 = this.jDateChooser4.getDate();
/* 4398 */     Date fecha2 = this.jDateChooser5.getDate();
/*      */     
/* 4400 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4401 */     String cadenaFecha = "";
/* 4402 */     cadenaFecha = formato.format(fecha1);
/* 4403 */     String AÑO = cadenaFecha.substring(0, 4);
/* 4404 */     String MES = cadenaFecha.substring(4, 6);
/* 4405 */     String DIA = cadenaFecha.substring(6, 8);
/* 4406 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + " 00:00:00'";
/*      */     
/* 4408 */     cadenaFecha = formato.format(fecha2);
/* 4409 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 4410 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 4411 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/*      */     
/* 4413 */     String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59'";
/*      */ 
/*      */     
/* 4416 */     String estatus = "";
/* 4417 */     String departamento = "";
/* 4418 */     String usuario = "";
/*      */     
/* 4420 */     if (this.jComboBox1.getSelectedIndex() == 0) {
/* 4421 */       estatus = " estatus='<Por Pagar>' || estatus like '%<Pagado%' || estatus like '%<Abono%' || estatus like '%<Autorizado%'";
/*      */     }
/* 4423 */     else if (this.jComboBox1.getSelectedIndex() == 1) {
/* 4424 */       estatus = " estatus like '%%'";
/*      */     }
/* 4426 */     else if (this.jComboBox1.getSelectedIndex() == 2) {
/* 4427 */       estatus = " estatus ='<Por Pagar>'";
/*      */     }
/* 4429 */     else if (this.jComboBox1.getSelectedIndex() == 3) {
/* 4430 */       estatus = " estatus like '%<Autorizado%'";
/*      */     }
/* 4432 */     else if (this.jComboBox1.getSelectedIndex() == 4) {
/* 4433 */       estatus = " estatus like '%<Cancelado%'";
/*      */     } 
/*      */     
/* 4436 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 4437 */       departamento = String.valueOf(this.jComboBox2.getSelectedItem());
/*      */     }
/* 4439 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 4440 */       usuario = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/*      */     
/* 4443 */     this.con.consultar("count(num)", "finiquitos_regis", "where folio_fini like '%" + this.jTextField1.getText() + "%' and empleado like '%" + this.jTextField2.getText() + "%' and depa like '%" + departamento + "%' and documento like '%" + usuario + "%' and (" + estatus + ") and fecha between " + fechaCompleta1 + " and " + fechaCompleta2);
/* 4444 */     int totreg = Integer.parseInt(this.con.Campo);
/* 4445 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + totreg + "</HTML>");
/* 4446 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 4447 */           .buscarReg(11, totreg, "num,folio_fini,fecha,clave,empleado,depa,total_Comp,total_imss,total,estatus,documento", "finiquitos_regis", "where folio_fini like '%" + this.jTextField1.getText() + "%' and empleado like '%" + this.jTextField2.getText() + "%' and depa like '%" + departamento + "%' and documento like '%" + usuario + "%' and (" + estatus + ") and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by num desc"), (Object[])new String[] { "Núm", "Folio", "Fecha", "Clave Emp", "Empleado", "Departamento", "Total Comp", "Total Imss", "Total", "Estatus", "Documento" })
/*      */         {
/*      */ 
/*      */           
/* 4451 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4455 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 4459 */     this.con.consultar("count(folio_fini)", "finiquitos_regis", "where estatus ='<Por Pagar>' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2);
/* 4460 */     String[] arre = this.con.regresaCol("folio_fini", "finiquitos_regis", "where estatus ='<Por Pagar>' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2, Integer.parseInt(this.con.Campo));
/* 4461 */     this.celda3.pasarInd3(arre);
/*      */     
/* 4463 */     this.con.consultar("count(folio_fini)", "finiquitos_regis", "where estatus like '%<Cancelado%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2);
/* 4464 */     arre = this.con.regresaCol("folio_fini", "finiquitos_regis", "where estatus like '%<Cancelado%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2, Integer.parseInt(this.con.Campo));
/* 4465 */     this.celda3.pasarInd5(arre);
/*      */     
/* 4467 */     this.jTable3.setSelectionMode(0);
/* 4468 */     this.jTable3.setAutoCreateRowSorter(true);
/* 4469 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 4471 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 4472 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(50);
/* 4473 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 4474 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(80);
/* 4475 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(70);
/* 4476 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(70);
/* 4477 */     this.jTable3.getColumnModel().getColumn(3).setMaxWidth(70);
/* 4478 */     this.jTable3.getColumnModel().getColumn(3).setPreferredWidth(70);
/*      */     
/* 4480 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(90);
/* 4481 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(90);
/* 4482 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(90);
/* 4483 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(90);
/* 4484 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(90);
/* 4485 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(90);
/*      */     
/* 4487 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 4488 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 4489 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda3);
/* 4490 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda3);
/* 4491 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda3);
/* 4492 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda3);
/* 4493 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda3);
/* 4494 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda3);
/* 4495 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda3);
/* 4496 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda3);
/* 4497 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda3);
/*      */   }
/*      */   
/*      */   public void desglozarDias(String periodo) {
/* 4501 */     if (periodo.contains("1 AÑO")) {
/* 4502 */       this.jComboBox5.setSelectedIndex(1);
/*      */     }
/* 4504 */     else if (periodo.contains("2 AÑOS")) {
/* 4505 */       this.jComboBox5.setSelectedIndex(2);
/*      */     }
/* 4507 */     else if (periodo.contains("3 AÑOS")) {
/* 4508 */       this.jComboBox5.setSelectedIndex(3);
/*      */     }
/* 4510 */     else if (periodo.contains("4 AÑOS")) {
/* 4511 */       this.jComboBox5.setSelectedIndex(4);
/*      */     }
/* 4513 */     else if (periodo.contains("5 AÑOS")) {
/* 4514 */       this.jComboBox5.setSelectedIndex(5);
/*      */     }
/* 4516 */     else if (periodo.contains("6 AÑOS")) {
/* 4517 */       this.jComboBox5.setSelectedIndex(6);
/*      */     }
/* 4519 */     else if (periodo.contains("7 AÑOS")) {
/* 4520 */       this.jComboBox5.setSelectedIndex(7);
/*      */     }
/* 4522 */     else if (periodo.contains("8 AÑOS")) {
/* 4523 */       this.jComboBox5.setSelectedIndex(8);
/*      */     }
/* 4525 */     else if (periodo.contains("9 AÑOS")) {
/* 4526 */       this.jComboBox5.setSelectedIndex(9);
/*      */     }
/* 4528 */     else if (periodo.contains("10 AÑOS")) {
/* 4529 */       this.jComboBox5.setSelectedIndex(10);
/*      */     }
/* 4531 */     else if (periodo.contains("11 AÑOS")) {
/* 4532 */       this.jComboBox5.setSelectedIndex(11);
/*      */     }
/* 4534 */     else if (periodo.contains("12 AÑOS")) {
/* 4535 */       this.jComboBox5.setSelectedIndex(12);
/*      */     }
/* 4537 */     else if (periodo.contains("13 AÑOS")) {
/* 4538 */       this.jComboBox5.setSelectedIndex(13);
/*      */     }
/* 4540 */     else if (periodo.contains("14 AÑOS")) {
/* 4541 */       this.jComboBox5.setSelectedIndex(14);
/*      */     }
/* 4543 */     else if (periodo.contains("15 AÑOS")) {
/* 4544 */       this.jComboBox5.setSelectedIndex(15);
/*      */     }
/* 4546 */     else if (periodo.contains("16 AÑOS")) {
/* 4547 */       this.jComboBox5.setSelectedIndex(16);
/*      */     }
/* 4549 */     else if (periodo.contains("17 AÑOS")) {
/* 4550 */       this.jComboBox5.setSelectedIndex(17);
/*      */     }
/* 4552 */     else if (periodo.contains("18 AÑOS")) {
/* 4553 */       this.jComboBox5.setSelectedIndex(18);
/*      */     }
/* 4555 */     else if (periodo.contains("19 AÑOS")) {
/* 4556 */       this.jComboBox5.setSelectedIndex(19);
/*      */     }
/* 4558 */     else if (periodo.contains("20 AÑOS")) {
/* 4559 */       this.jComboBox5.setSelectedIndex(20);
/*      */     }
/* 4561 */     else if (periodo.contains("21 AÑOS")) {
/* 4562 */       this.jComboBox5.setSelectedIndex(21);
/*      */     }
/* 4564 */     else if (periodo.contains("22 AÑOS")) {
/* 4565 */       this.jComboBox5.setSelectedIndex(22);
/*      */     }
/* 4567 */     else if (periodo.contains("23 AÑOS")) {
/* 4568 */       this.jComboBox5.setSelectedIndex(23);
/*      */     }
/* 4570 */     else if (periodo.contains("24 AÑOS")) {
/* 4571 */       this.jComboBox5.setSelectedIndex(24);
/*      */     }
/* 4573 */     else if (periodo.contains("25 AÑOS")) {
/* 4574 */       this.jComboBox5.setSelectedIndex(25);
/*      */     }
/* 4576 */     else if (periodo.contains("26 AÑOS")) {
/* 4577 */       this.jComboBox5.setSelectedIndex(26);
/*      */     }
/* 4579 */     else if (periodo.contains("27 AÑOS")) {
/* 4580 */       this.jComboBox5.setSelectedIndex(27);
/*      */     }
/* 4582 */     else if (periodo.contains("28 AÑOS")) {
/* 4583 */       this.jComboBox5.setSelectedIndex(28);
/*      */     }
/* 4585 */     else if (periodo.contains("29 AÑOS")) {
/* 4586 */       this.jComboBox5.setSelectedIndex(29);
/*      */     }
/* 4588 */     else if (periodo.contains("30 AÑOS")) {
/* 4589 */       this.jComboBox5.setSelectedIndex(31);
/*      */     }
/* 4591 */     else if (periodo.contains("31 AÑOS")) {
/* 4592 */       this.jComboBox5.setSelectedIndex(31);
/*      */     }
/* 4594 */     else if (periodo.contains("32 AÑOS")) {
/* 4595 */       this.jComboBox5.setSelectedIndex(32);
/*      */     }
/* 4597 */     else if (periodo.contains("33 AÑOS")) {
/* 4598 */       this.jComboBox5.setSelectedIndex(33);
/*      */     }
/* 4600 */     else if (periodo.contains("34 AÑOS")) {
/* 4601 */       this.jComboBox5.setSelectedIndex(35);
/*      */     }
/* 4603 */     else if (periodo.contains("36 AÑOS")) {
/* 4604 */       this.jComboBox5.setSelectedIndex(36);
/*      */     }
/* 4606 */     else if (periodo.contains("37 AÑOS")) {
/* 4607 */       this.jComboBox5.setSelectedIndex(37);
/*      */     }
/* 4609 */     else if (periodo.contains("38 AÑOS")) {
/* 4610 */       this.jComboBox5.setSelectedIndex(38);
/*      */     }
/* 4612 */     else if (periodo.contains("39 AÑOS")) {
/* 4613 */       this.jComboBox5.setSelectedIndex(39);
/*      */     }
/* 4615 */     else if (periodo.contains("40 AÑOS")) {
/* 4616 */       this.jComboBox5.setSelectedIndex(40);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void deshabilitar() {
/* 4622 */     this.jRadioButton1.setEnabled(false);
/* 4623 */     this.jRadioButton2.setEnabled(false);
/* 4624 */     this.jButton5.setEnabled(false);
/* 4625 */     this.jTextField5.setText("");
/* 4626 */     this.jComboBox6.setEnabled(false);
/* 4627 */     this.jButton7.setEnabled(false);
/* 4628 */     this.jButton8.setEnabled(false);
/* 4629 */     this.jButton10.setEnabled(false);
/* 4630 */     this.jButton11.setEnabled(false);
/* 4631 */     this.jButton9.setEnabled(false);
/* 4632 */     this.jButton15.setEnabled(false);
/* 4633 */     this.jButton16.setEnabled(false);
/* 4634 */     this.jButton17.setEnabled(false);
/* 4635 */     this.jButton12.setEnabled(true);
/* 4636 */     this.jLabel19.setText("$0.0");
/* 4637 */     this.jLabel13.setText("$0.0");
/* 4638 */     this.jLabel21.setText("$0.0");
/* 4639 */     this.jComboBox5.setSelectedIndex(0);
/* 4640 */     this.jComboBox6.removeAllItems();
/* 4641 */     this.jDateChooser9.setDate(new Date());
/* 4642 */     this.jComboBox5.setEnabled(false);
/* 4643 */     this.jDateChooser7.setDate(new Date());
/* 4644 */     this.jDateChooser8.setDate(new Date());
/* 4645 */     this.jDateChooser11.setDate(new Date());
/* 4646 */     this.jDateChooser12.setDate(new Date());
/* 4647 */     this.jButton14.setEnabled(false);
/* 4648 */     this.jDateChooser7.setEnabled(false);
/* 4649 */     this.jDateChooser8.setEnabled(false);
/* 4650 */     this.jDateChooser10.setEnabled(false);
/* 4651 */     this.jDateChooser11.setEnabled(false);
/* 4652 */     this.jDateChooser12.setEnabled(false);
/* 4653 */     this.jButton13.setEnabled(false);
/*      */     
/* 4655 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { "AGUINALDO", "0", "0", "0", "0", "0", "0", "$0.0" }, , { "VACACIONES", "0", "0", "0", "0", "0", "0", "$0.0" }, , { "PRIMA VACACIONAL (25%)", "", "", "", "", "", "", "" },  }, (Object[])new String[] { "Concepto", "Días Ley", "Días del Año", "Factor en Días", "Días con Derecho", "SubTotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4665 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4670 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4673 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 4674 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(160);
/* 4675 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(160);
/* 4676 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(80);
/* 4677 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
/* 4678 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 4679 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 4680 */     this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 4681 */     this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 4682 */     this.jTable1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 4683 */     this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 4684 */     this.jTable1.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/*      */     
/* 4686 */     this.jTable4 = new JTable();
/* 4687 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4694 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4699 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4702 */     this.jScrollPane4.setViewportView(this.jTable4);
/* 4703 */     this.jTable4.getColumnModel().getColumn(1).setMinWidth(180);
/* 4704 */     this.jTable4.getColumnModel().getColumn(1).setMaxWidth(180);
/*      */     
/* 4706 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { "AGUINALDO", "0", "0", "0", "0", "0", "0", "$0.0" }, , { "VACACIONES", "0", "0", "0", "0", "0", "0", "$0.0" }, , { "PRIMA VACACIONAL (25%)", "", "", "", "", "", "", "" },  }, (Object[])new String[] { "Concepto", "Días Ley", "Días del Año", "Factor en Días", "Días con Derecho", "SubTotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4716 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4721 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4724 */     this.jScrollPane2.setViewportView(this.jTable2);
/* 4725 */     this.jTable2.getColumnModel().getColumn(0).setMinWidth(160);
/* 4726 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(160);
/* 4727 */     this.jTable2.getColumnModel().getColumn(1).setMinWidth(80);
/* 4728 */     this.jTable2.getColumnModel().getColumn(1).setMaxWidth(80);
/* 4729 */     this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 4730 */     this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 4731 */     this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 4732 */     this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 4733 */     this.jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 4734 */     this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 4735 */     this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/*      */     
/* 4737 */     this.jTable5 = new JTable();
/* 4738 */     this.jTable5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4745 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4749 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4752 */     this.jScrollPane5.setViewportView(this.jTable5);
/* 4753 */     this.jTable5.getColumnModel().getColumn(1).setMinWidth(180);
/* 4754 */     this.jTable5.getColumnModel().getColumn(1).setMaxWidth(180);
/*      */     
/* 4756 */     this.jLabel21.setText("$0.00");
/* 4757 */     this.jLabel13.setText("$0.00");
/* 4758 */     this.jLabel19.setText("$0.00");
/*      */     
/* 4760 */     this.jButton7.setEnabled(false);
/* 4761 */     this.jButton8.setEnabled(false);
/* 4762 */     this.jButton10.setEnabled(false);
/* 4763 */     this.jButton11.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void contarDias() {
/* 4767 */     if (this.jComboBox5.getSelectedIndex() == 0) {
/* 4768 */       this.DIAS = 12;
/*      */       
/* 4770 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4771 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4772 */       cal1.add(1, 0);
/* 4773 */       cal2.add(1, 1);
/* 4774 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4775 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4777 */     else if (this.jComboBox5.getSelectedIndex() == 1) {
/* 4778 */       this.DIAS = 14;
/* 4779 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4780 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4781 */       cal1.add(1, 1);
/* 4782 */       cal2.add(1, 2);
/* 4783 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4784 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4786 */     else if (this.jComboBox5.getSelectedIndex() == 2) {
/* 4787 */       this.DIAS = 16;
/*      */       
/* 4789 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4790 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4791 */       cal1.add(1, 2);
/* 4792 */       cal2.add(1, 3);
/* 4793 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4794 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     
/*      */     }
/* 4797 */     else if (this.jComboBox5.getSelectedIndex() == 3) {
/* 4798 */       this.DIAS = 18;
/*      */       
/* 4800 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4801 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4802 */       cal1.add(1, 3);
/* 4803 */       cal2.add(1, 4);
/* 4804 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4805 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4807 */     else if (this.jComboBox5.getSelectedIndex() == 4) {
/* 4808 */       this.DIAS = 20;
/*      */       
/* 4810 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4811 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4812 */       cal1.add(1, 4);
/* 4813 */       cal2.add(1, 5);
/* 4814 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4815 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4817 */     else if (this.jComboBox5.getSelectedIndex() == 5) {
/* 4818 */       this.DIAS = 22;
/*      */       
/* 4820 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4821 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4822 */       cal1.add(1, 5);
/* 4823 */       cal2.add(1, 6);
/* 4824 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4825 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4827 */     else if (this.jComboBox5.getSelectedIndex() == 6) {
/* 4828 */       this.DIAS = 22;
/*      */       
/* 4830 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4831 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4832 */       cal1.add(1, 6);
/* 4833 */       cal2.add(1, 7);
/* 4834 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4835 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4837 */     else if (this.jComboBox5.getSelectedIndex() == 7) {
/* 4838 */       this.DIAS = 22;
/*      */       
/* 4840 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4841 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4842 */       cal1.add(1, 7);
/* 4843 */       cal2.add(1, 8);
/* 4844 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4845 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4847 */     else if (this.jComboBox5.getSelectedIndex() == 8) {
/* 4848 */       this.DIAS = 22;
/*      */       
/* 4850 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4851 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4852 */       cal1.add(1, 8);
/* 4853 */       cal2.add(1, 9);
/* 4854 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4855 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4857 */     else if (this.jComboBox5.getSelectedIndex() == 9) {
/* 4858 */       this.DIAS = 22;
/*      */       
/* 4860 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4861 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4862 */       cal1.add(1, 9);
/* 4863 */       cal2.add(1, 10);
/* 4864 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4865 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4867 */     else if (this.jComboBox5.getSelectedIndex() == 10) {
/* 4868 */       this.DIAS = 24;
/*      */       
/* 4870 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4871 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4872 */       cal1.add(1, 10);
/* 4873 */       cal2.add(1, 11);
/* 4874 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4875 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4877 */     else if (this.jComboBox5.getSelectedIndex() == 11) {
/* 4878 */       this.DIAS = 24;
/*      */       
/* 4880 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4881 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4882 */       cal1.add(1, 11);
/* 4883 */       cal2.add(1, 12);
/* 4884 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4885 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4887 */     else if (this.jComboBox5.getSelectedIndex() == 12) {
/* 4888 */       this.DIAS = 24;
/*      */       
/* 4890 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4891 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4892 */       cal1.add(1, 12);
/* 4893 */       cal2.add(1, 13);
/* 4894 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4895 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4897 */     else if (this.jComboBox5.getSelectedIndex() == 13) {
/* 4898 */       this.DIAS = 24;
/*      */       
/* 4900 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4901 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4902 */       cal1.add(1, 13);
/* 4903 */       cal2.add(1, 14);
/* 4904 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4905 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4907 */     else if (this.jComboBox5.getSelectedIndex() == 14) {
/* 4908 */       this.DIAS = 24;
/*      */       
/* 4910 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4911 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4912 */       cal1.add(1, 14);
/* 4913 */       cal2.add(1, 15);
/* 4914 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4915 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4917 */     else if (this.jComboBox5.getSelectedIndex() == 15) {
/* 4918 */       this.DIAS = 26;
/*      */       
/* 4920 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4921 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4922 */       cal1.add(1, 15);
/* 4923 */       cal2.add(1, 16);
/* 4924 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4925 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4927 */     else if (this.jComboBox5.getSelectedIndex() == 16) {
/* 4928 */       this.DIAS = 26;
/*      */       
/* 4930 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4931 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4932 */       cal1.add(1, 16);
/* 4933 */       cal2.add(1, 17);
/* 4934 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4935 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4937 */     else if (this.jComboBox5.getSelectedIndex() == 17) {
/* 4938 */       this.DIAS = 26;
/*      */       
/* 4940 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4941 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4942 */       cal1.add(1, 17);
/* 4943 */       cal2.add(1, 18);
/* 4944 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4945 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4947 */     else if (this.jComboBox5.getSelectedIndex() == 18) {
/* 4948 */       this.DIAS = 26;
/*      */       
/* 4950 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4951 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4952 */       cal1.add(1, 18);
/* 4953 */       cal2.add(1, 19);
/* 4954 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4955 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4957 */     else if (this.jComboBox5.getSelectedIndex() == 19) {
/* 4958 */       this.DIAS = 26;
/*      */       
/* 4960 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4961 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4962 */       cal1.add(1, 19);
/* 4963 */       cal2.add(1, 20);
/* 4964 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4965 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4967 */     else if (this.jComboBox5.getSelectedIndex() == 20) {
/* 4968 */       this.DIAS = 28;
/*      */       
/* 4970 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4971 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4972 */       cal1.add(1, 20);
/* 4973 */       cal2.add(1, 21);
/* 4974 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4975 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4977 */     else if (this.jComboBox5.getSelectedIndex() == 21) {
/* 4978 */       this.DIAS = 28;
/*      */       
/* 4980 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4981 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4982 */       cal1.add(1, 21);
/* 4983 */       cal2.add(1, 22);
/* 4984 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4985 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4987 */     else if (this.jComboBox5.getSelectedIndex() == 22) {
/* 4988 */       this.DIAS = 28;
/*      */       
/* 4990 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 4991 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 4992 */       cal1.add(1, 22);
/* 4993 */       cal2.add(1, 23);
/* 4994 */       this.jDateChooser7.setDate(cal1.getTime());
/* 4995 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 4997 */     else if (this.jComboBox5.getSelectedIndex() == 23) {
/* 4998 */       this.DIAS = 28;
/*      */       
/* 5000 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5001 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5002 */       cal1.add(1, 23);
/* 5003 */       cal2.add(1, 24);
/* 5004 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5005 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5007 */     else if (this.jComboBox5.getSelectedIndex() == 24) {
/* 5008 */       this.DIAS = 28;
/*      */       
/* 5010 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5011 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5012 */       cal1.add(1, 24);
/* 5013 */       cal2.add(1, 25);
/* 5014 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5015 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5017 */     else if (this.jComboBox5.getSelectedIndex() == 25) {
/* 5018 */       this.DIAS = 30;
/*      */       
/* 5020 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5021 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5022 */       cal1.add(1, 25);
/* 5023 */       cal2.add(1, 26);
/* 5024 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5025 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5027 */     else if (this.jComboBox5.getSelectedIndex() == 26) {
/* 5028 */       this.DIAS = 30;
/*      */       
/* 5030 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5031 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5032 */       cal1.add(1, 26);
/* 5033 */       cal2.add(1, 27);
/* 5034 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5035 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5037 */     else if (this.jComboBox5.getSelectedIndex() == 27) {
/* 5038 */       this.DIAS = 30;
/*      */       
/* 5040 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5041 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5042 */       cal1.add(1, 27);
/* 5043 */       cal2.add(1, 28);
/* 5044 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5045 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5047 */     else if (this.jComboBox5.getSelectedIndex() == 28) {
/* 5048 */       this.DIAS = 30;
/*      */       
/* 5050 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5051 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5052 */       cal1.add(1, 28);
/* 5053 */       cal2.add(1, 29);
/* 5054 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5055 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5057 */     else if (this.jComboBox5.getSelectedIndex() == 29) {
/* 5058 */       this.DIAS = 30;
/*      */       
/* 5060 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5061 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5062 */       cal1.add(1, 29);
/* 5063 */       cal2.add(1, 30);
/* 5064 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5065 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5067 */     else if (this.jComboBox5.getSelectedIndex() == 30) {
/* 5068 */       this.DIAS = 32;
/*      */       
/* 5070 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5071 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5072 */       cal1.add(1, 30);
/* 5073 */       cal2.add(1, 31);
/* 5074 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5075 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5077 */     else if (this.jComboBox5.getSelectedIndex() == 31) {
/* 5078 */       this.DIAS = 32;
/*      */       
/* 5080 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5081 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5082 */       cal1.add(1, 31);
/* 5083 */       cal2.add(1, 32);
/* 5084 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5085 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5087 */     else if (this.jComboBox5.getSelectedIndex() == 32) {
/* 5088 */       this.DIAS = 32;
/*      */       
/* 5090 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5091 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5092 */       cal1.add(1, 32);
/* 5093 */       cal2.add(1, 33);
/* 5094 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5095 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5097 */     else if (this.jComboBox5.getSelectedIndex() == 33) {
/* 5098 */       this.DIAS = 32;
/*      */       
/* 5100 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5101 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5102 */       cal1.add(1, 33);
/* 5103 */       cal2.add(1, 34);
/* 5104 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5105 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5107 */     else if (this.jComboBox5.getSelectedIndex() == 34) {
/* 5108 */       this.DIAS = 32;
/*      */       
/* 5110 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5111 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5112 */       cal1.add(1, 34);
/* 5113 */       cal2.add(1, 35);
/* 5114 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5115 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5117 */     else if (this.jComboBox5.getSelectedIndex() == 35) {
/* 5118 */       this.DIAS = 34;
/*      */       
/* 5120 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5121 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5122 */       cal1.add(1, 35);
/* 5123 */       cal2.add(1, 36);
/* 5124 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5125 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5127 */     else if (this.jComboBox5.getSelectedIndex() == 36) {
/* 5128 */       this.DIAS = 34;
/*      */       
/* 5130 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5131 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5132 */       cal1.add(1, 36);
/* 5133 */       cal2.add(1, 37);
/* 5134 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5135 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5137 */     else if (this.jComboBox5.getSelectedIndex() == 37) {
/* 5138 */       this.DIAS = 34;
/*      */       
/* 5140 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5141 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5142 */       cal1.add(1, 37);
/* 5143 */       cal2.add(1, 38);
/* 5144 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5145 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 5147 */     else if (this.jComboBox5.getSelectedIndex() == 38) {
/* 5148 */       this.DIAS = 34;
/*      */       
/* 5150 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 5151 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 5152 */       cal1.add(1, 38);
/* 5153 */       cal2.add(1, 39);
/* 5154 */       this.jDateChooser7.setDate(cal1.getTime());
/* 5155 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 5160 */     this.con.consultar("max(num)", "finiquitos_regis", "");
/* 5161 */     String mayor = this.con.Campo;
/* 5162 */     int MAYOR = 0;
/*      */     try {
/* 5164 */       MAYOR = Integer.parseInt(mayor);
/*      */     }
/* 5166 */     catch (NumberFormatException e) {
/* 5167 */       MAYOR = 0;
/*      */     } 
/* 5169 */     MAYOR++;
/* 5170 */     if (MAYOR < 10) {
/* 5171 */       this.jTextField6.setText(this.DIRECTIVA + "-0000" + this.DIRECTIVA);
/*      */     }
/* 5173 */     else if (MAYOR < 100) {
/* 5174 */       this.jTextField6.setText(this.DIRECTIVA + "-000" + this.DIRECTIVA);
/*      */     }
/* 5176 */     else if (MAYOR < 1000) {
/* 5177 */       this.jTextField6.setText(this.DIRECTIVA + "-00" + this.DIRECTIVA);
/*      */     }
/* 5179 */     else if (MAYOR < 10000) {
/* 5180 */       this.jTextField6.setText(this.DIRECTIVA + "-0" + this.DIRECTIVA);
/*      */     } else {
/*      */       
/* 5183 */       this.jTextField6.setText(this.DIRECTIVA + "-" + this.DIRECTIVA);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 5188 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5190 */             Finiquitos.this.jTextGanado(Finiquitos.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5193 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 5196 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5198 */             Finiquitos.this.jTextGanado(Finiquitos.this.jTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5201 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 5204 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5206 */             Finiquitos.this.jTextGanado(Finiquitos.this.jTextField9, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5209 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jTextField9, evt);
/*      */           }
/*      */         });
/* 5212 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5214 */             Finiquitos.this.jTextGanado(Finiquitos.this.jTextField10, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5217 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jTextField10, evt);
/*      */           }
/*      */         });
/* 5220 */     this.jTextField27.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5222 */             Finiquitos.this.jTextGanado(Finiquitos.this.jTextField27, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5225 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jTextField27, evt);
/*      */           }
/*      */         });
/* 5228 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5230 */             Finiquitos.this.jTextGanado(Finiquitos.this.jTextArea5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5233 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jTextArea5, evt);
/*      */           }
/*      */         });
/* 5236 */     this.jTextField28.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5238 */             Finiquitos.this.jTextGanado(Finiquitos.this.jTextField28, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5241 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jTextField28, evt);
/*      */           }
/*      */         });
/* 5244 */     this.jTextField29.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5246 */             Finiquitos.this.jTextGanado(Finiquitos.this.jTextField29, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5249 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jTextField29, evt);
/*      */           }
/*      */         });
/* 5252 */     this.jTextField30.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5254 */             Finiquitos.this.jTextGanado(Finiquitos.this.jTextField30, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5257 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jTextField30, evt);
/*      */           }
/*      */         });
/* 5260 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5262 */             Finiquitos.this.jTextGanado(Finiquitos.this.jFormattedTextField3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5265 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jFormattedTextField3, evt);
/*      */           }
/*      */         });
/* 5268 */     this.jFormattedTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5270 */             Finiquitos.this.jTextGanado(Finiquitos.this.jFormattedTextField4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5273 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jFormattedTextField4, evt);
/*      */           }
/*      */         });
/* 5276 */     this.jFormattedTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5278 */             Finiquitos.this.jTextGanado(Finiquitos.this.jFormattedTextField5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5281 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jFormattedTextField5, evt);
/*      */           }
/*      */         });
/* 5284 */     this.jFormattedTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5286 */             Finiquitos.this.jTextGanado(Finiquitos.this.jFormattedTextField6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5289 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jFormattedTextField6, evt);
/*      */           }
/*      */         });
/* 5292 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5294 */             Finiquitos.this.jTextGanado(Finiquitos.this.jComboBox1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5297 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 5300 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5302 */             Finiquitos.this.jTextGanado(Finiquitos.this.jComboBox2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5305 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 5308 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5310 */             Finiquitos.this.jTextGanado(Finiquitos.this.jComboBox3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5313 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 5316 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5318 */             Finiquitos.this.jTextGanado(Finiquitos.this.jComboBox7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5321 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jComboBox7, evt);
/*      */           }
/*      */         });
/* 5324 */     this.jComboBox8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5326 */             Finiquitos.this.jTextGanado(Finiquitos.this.jComboBox8, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5329 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jComboBox8, evt);
/*      */           }
/*      */         });
/* 5332 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 5334 */             Finiquitos.this.jTextGanado(Finiquitos.this.jComboBox5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 5337 */             Finiquitos.this.jTextPerdido(Finiquitos.this.jComboBox5, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 5343 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 5346 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 5350 */     this.con.consultar("priv", "usuarios", "where nombre_usu ='" + this.USUARIO + "'");
/* 5351 */     this.PRIVILEGIOS = this.con.Campo;
/*      */   }
/*      */   public void finiquitos(String usu) {
/* 5354 */     this.ACTIVO = false;
/* 5355 */     this.USUARIO = usu;
/* 5356 */     this.panel.setViewportView(this);
/* 5357 */     privilegios();
/* 5358 */     consultar2();
/*      */   }
/*      */   
/*      */   public void consultar3() {
/* 5362 */     this.encontrado = this.con.consultar("count(tarjeta)", "tarjeta_contenido", "where tarjeta=" + this.CLAVEOP);
/* 5363 */     int tot = Integer.parseInt(this.con.Campo);
/* 5364 */     this.jTable7.setModel(new DefaultTableModel((Object[][])this.con
/* 5365 */           .buscarReg(9, tot, "mov,fecha,concepto,referencia,repuesto,importeLetra,abonoLetra,saldoFinalLetra,estatus", "tarjeta_contenido", "where tarjeta=" + this.CLAVEOP + " order by mov desc"), (Object[])new String[] { "Mov.", "Fecha", "Concepto", "Referencia", "Rep", "Importe", "Abono", "Saldo", "Estatus" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 5370 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 5374 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 5377 */     if (this.jTable7.getRowCount() > 0) {
/* 5378 */       this.jTextField8.setText(String.valueOf(this.jTable7.getValueAt(0, 7)));
/*      */     } else {
/*      */       
/* 5381 */       this.jTextField8.setText("$0.00");
/*      */     } 
/* 5383 */     this.con.consultar("count(mov)", "tarjeta_contenido", "where estatus ='<Por Pagar>' and tarjeta = " + this.CLAVEOP);
/* 5384 */     String[] arre = this.con.regresaCol("mov", "tarjeta_contenido", "where estatus = '<Por Pagar>' and tarjeta = " + this.CLAVEOP, Integer.parseInt(this.con.Campo));
/* 5385 */     this.celda4.pasarInd(arre);
/*      */     
/* 5387 */     this.con.consultar("count(mov)", "tarjeta_contenido", "where estatus='<Cancelado>' AND TARJETA = " + this.CLAVEOP);
/* 5388 */     arre = this.con.regresaCol("mov", "tarjeta_contenido", "where estatus='<Cancelado>' AND TARJETA= " + this.CLAVEOP, Integer.parseInt(this.con.Campo));
/* 5389 */     this.celda4.pasarInd2(arre);
/*      */     
/* 5391 */     this.con.consultar("count(mov)", "tarjeta_contenido", "where estatus <>'<Cancelado>' && estatus<>'<Por Pagar>' && estatus<>'<Aplicado>' and estatus not like '<pagado%' AND TARJETA=" + this.CLAVEOP);
/* 5392 */     arre = this.con.regresaCol("mov", "tarjeta_contenido", "where estatus <>'<Cancelado>' && estatus<>'<Por Pagar>' && estatus<>'<Aplicado>'and estatus not like '<pagado%' AND TARJETA=" + this.CLAVEOP, Integer.parseInt(this.con.Campo));
/* 5393 */     this.celda4.pasarInd3(arre);
/*      */     
/* 5395 */     this.jTable7.setShowVerticalLines(false);
/* 5396 */     this.jScrollPane7.setViewportView(this.jTable7);
/* 5397 */     this.jTable7.setSelectionMode(0);
/*      */ 
/*      */ 
/*      */     
/* 5401 */     this.jTable7.setAutoCreateRowSorter(true);
/*      */     
/* 5403 */     this.jTable7.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 5404 */     this.jTable7.getColumnModel().getColumn(0).setMaxWidth(50);
/* 5405 */     this.jTable7.getColumnModel().getColumn(1).setPreferredWidth(110);
/* 5406 */     this.jTable7.getColumnModel().getColumn(1).setMaxWidth(110);
/* 5407 */     this.jTable7.getColumnModel().getColumn(4).setPreferredWidth(30);
/* 5408 */     this.jTable7.getColumnModel().getColumn(4).setMaxWidth(30);
/* 5409 */     this.jTable7.getColumnModel().getColumn(5).setPreferredWidth(70);
/* 5410 */     this.jTable7.getColumnModel().getColumn(5).setMaxWidth(70);
/* 5411 */     this.jTable7.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 5412 */     this.jTable7.getColumnModel().getColumn(6).setMaxWidth(70);
/* 5413 */     this.jTable7.getColumnModel().getColumn(7).setPreferredWidth(70);
/* 5414 */     this.jTable7.getColumnModel().getColumn(7).setMaxWidth(70);
/* 5415 */     this.jTable7.getColumnModel().getColumn(8).setPreferredWidth(130);
/* 5416 */     this.jTable7.getColumnModel().getColumn(8).setMaxWidth(130);
/*      */     
/* 5418 */     this.jTable7.getColumnModel().getColumn(0).setCellRenderer(this.celda4);
/* 5419 */     this.jTable7.getColumnModel().getColumn(1).setCellRenderer(this.celda4);
/* 5420 */     this.jTable7.getColumnModel().getColumn(2).setCellRenderer(this.celda4);
/* 5421 */     this.jTable7.getColumnModel().getColumn(3).setCellRenderer(this.celda4);
/* 5422 */     this.jTable7.getColumnModel().getColumn(4).setCellRenderer(this.celda4);
/* 5423 */     this.jTable7.getColumnModel().getColumn(5).setCellRenderer(this.celda4);
/* 5424 */     this.jTable7.getColumnModel().getColumn(6).setCellRenderer(this.celda4);
/* 5425 */     this.jTable7.getColumnModel().getColumn(7).setCellRenderer(this.celda4);
/* 5426 */     this.jTable7.getColumnModel().getColumn(8).setCellRenderer(this.celda4);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 5430 */     String consulta = "";
/* 5431 */     String campos = "";
/* 5432 */     String tabla = "";
/* 5433 */     String num_ope = this.jTextField9.getText();
/* 5434 */     int nCampos = 0;
/* 5435 */     String[] visualizar = null;
/* 5436 */     this.jButton20.setEnabled(false);
/* 5437 */     String tipo = "";
/* 5438 */     String depa = "";
/* 5439 */     if (this.jRadioButton1.isSelected()) {
/* 5440 */       if (this.jComboBox7.getSelectedIndex() == 0) {
/* 5441 */         tipo = "EMPLEADO";
/*      */       }
/* 5443 */       else if (this.jComboBox7.getSelectedIndex() == 1) {
/* 5444 */         tipo = "FUNCIONARIO";
/*      */       } else {
/*      */         
/* 5447 */         tipo = "";
/*      */       } 
/*      */       
/* 5450 */       if (this.jComboBox8.getSelectedIndex() != 0) {
/* 5451 */         depa = String.valueOf(this.jComboBox8.getSelectedItem());
/*      */       }
/*      */       
/* 5454 */       nCampos = 6;
/* 5455 */       consulta = "where empleados.clave_depa = departamentos.clave_depa and tipoEmp like '%" + tipo + "%' and departamentos.nombre like '%" + depa + "%' and clave_emp like '%" + num_ope + "%' and empleados.nombre like '%" + this.jTextField10.getText() + "%' and actual=0 and clave_emp<>0 order by empleados.nombre";
/* 5456 */       campos = "clave_emp,empleados.nombre,ap_pat,ap_mat,Ultimoingreso,departamentos.nombre";
/* 5457 */       tabla = "empleados,departamentos";
/* 5458 */       visualizar = new String[] { "Clave", "Nombre Completo", "Paterno", "Materno", "Fecha de Ingreso", "Departamento" };
/*      */     } else {
/*      */       
/* 5461 */       nCampos = 5;
/* 5462 */       this.jComboBox8.setSelectedIndex(0);
/* 5463 */       this.jComboBox8.setEnabled(true);
/*      */       
/* 5465 */       if (this.jComboBox7.getSelectedIndex() == 0) {
/* 5466 */         tipo = "OPERADOR";
/*      */       }
/* 5468 */       else if (this.jComboBox7.getSelectedIndex() == 1) {
/* 5469 */         tipo = "FUNCIONARIO";
/*      */       } else {
/*      */         
/* 5472 */         tipo = "";
/*      */       } 
/*      */       
/* 5475 */       consulta = "where tipoTrabajador like '%" + tipo + "%' and num_ope like '%" + num_ope + "%' and nombre like '%" + this.jTextField10.getText() + "%' and actual=0 and num_ope<>0 order by nombre";
/* 5476 */       campos = "num_ope,nombre,ap_pat,ap_mat,UltimaFechaIngreso";
/* 5477 */       tabla = "operadores";
/* 5478 */       visualizar = new String[] { "Clave", "Nombre Completo", "Paterno", "Materno", "Fecha de Ingreso" };
/*      */     } 
/*      */     
/* 5481 */     this.encontrado = this.con.consultar("count(ap_pat)", tabla, consulta);
/* 5482 */     int tot = Integer.parseInt(this.con.Campo);
/* 5483 */     this.jTable6.setModel(new DefaultTableModel((Object[][])this.con
/* 5484 */           .buscarReg(nCampos, tot, campos, tabla, consulta), (Object[])visualizar)
/*      */         {
/*      */           
/* 5487 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 5491 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 5494 */     eliminarColumna(2, 1, "Paterno");
/* 5495 */     eliminarColumna(2, 1, "Materno");
/*      */     
/* 5497 */     this.jTable6.setShowVerticalLines(false);
/* 5498 */     this.jScrollPane6.setViewportView(this.jTable6);
/* 5499 */     this.jTable6.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 5500 */     this.jTable6.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     
/* 5502 */     this.jTable6.setSelectionMode(0);
/* 5503 */     this.jTable6.setAutoCreateRowSorter(true);
/* 5504 */     this.jTable6.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 5506 */     this.jTable6.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 5507 */     this.jTable6.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 5508 */     this.jTable6.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 5509 */     if (this.jRadioButton1.isSelected()) {
/* 5510 */       this.jTable6.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/*      */     }
/*      */   }
/*      */   
/*      */   public synchronized void eliminarColumna(int origen, int destino, String nombreCol) {
/* 5515 */     int cont = this.jTable6.getRowCount();
/* 5516 */     String[] registros = new String[cont]; int i;
/* 5517 */     for (i = 0; i < cont; i++) {
/* 5518 */       registros[i] = this.jTable6.getValueAt(i, destino).toString();
/*      */     }
/* 5520 */     for (i = 0; i < cont; i++) {
/* 5521 */       registros[i] = registros[i] + " " + registros[i];
/* 5522 */       this.jTable6.setValueAt(registros[i], i, destino);
/*      */     } 
/* 5524 */     TableColumn columna = this.jTable6.getColumn(nombreCol);
/* 5525 */     this.jTable6.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void llenarCombos() {
/* 5529 */     this.con.consultar("count(nombre)", "departamentos", "");
/* 5530 */     String[] datos = this.con.regresaCol("nombre", "departamentos", "order by nombre", Integer.parseInt(this.con.Campo));
/* 5531 */     this.jComboBox2.removeAllItems();
/* 5532 */     this.jComboBox8.removeAllItems();
/* 5533 */     this.jComboBox2.addItem("<GENERAL>");
/* 5534 */     this.jComboBox8.addItem("<GENERAL>"); int i;
/* 5535 */     for (i = 0; i < datos.length; i++) {
/* 5536 */       this.jComboBox2.addItem(datos[i]);
/* 5537 */       this.jComboBox8.addItem(datos[i]);
/*      */     } 
/*      */     
/* 5540 */     this.con.consultar("count(nombre_usu)", "usuarios", "");
/* 5541 */     datos = this.con.regresaCol("nombre_usu", "usuarios", "order by nombre_usu", Integer.parseInt(this.con.Campo));
/* 5542 */     this.jComboBox3.removeAllItems();
/* 5543 */     this.jComboBox3.addItem("<GENERAL>");
/* 5544 */     for (i = 0; i < datos.length; i++) {
/* 5545 */       this.jComboBox3.addItem(datos[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void calcularVaca() {
/* 5550 */     String canti = this.DATOS[1];
/* 5551 */     String valorP = "";
/* 5552 */     for (int j = 0; j < canti.length(); j++) {
/* 5553 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 5554 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 5557 */     double salarioReal = Double.parseDouble(valorP);
/* 5558 */     double diario = salarioReal / 7.0D;
/*      */     
/* 5560 */     canti = this.DATOS[2];
/* 5561 */     valorP = "";
/* 5562 */     for (int i = 0; i < canti.length(); i++) {
/* 5563 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 5564 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 5567 */     double salarioImss = Double.parseDouble(valorP);
/* 5568 */     double complemento = 0.0D;
/*      */     
/* 5570 */     if (this.jRadioButton1.isSelected()) {
/* 5571 */       complemento = diario - salarioImss;
/*      */     }
/* 5573 */     this.cantidad.setValue(Double.valueOf(complemento));
/* 5574 */     String diarioL = this.cantidad.getText();
/*      */     
/* 5576 */     restarFechas();
/* 5577 */     double FACTORDIAS = Double.parseDouble("" + this.DIAS) / Double.parseDouble("365");
/* 5578 */     String s1 = "" + FACTORDIAS;
/* 5579 */     double SUBTOTALDIAS = Double.parseDouble(s1.substring(0, 6)) * Integer.parseInt(this.jTextField4.getText());
/* 5580 */     double SUBTOTAL1 = SUBTOTALDIAS * complemento;
/* 5581 */     this.cantidad.setValue(Double.valueOf(SUBTOTAL1));
/*      */     
/* 5583 */     String s2 = "" + SUBTOTALDIAS + "0000000";
/*      */     
/* 5585 */     this.jTable1.setValueAt("AGUINALDO", 0, 0);
/* 5586 */     this.jTable1.setValueAt("15", 0, 1);
/* 5587 */     this.jTable1.setValueAt("365", 0, 2);
/* 5588 */     this.jTable1.setValueAt("0.0411", 0, 3);
/* 5589 */     double SUBAGUI = Double.parseDouble("0.0411") * Double.parseDouble(String.valueOf(this.jTable1.getValueAt(0, 4)));
/* 5590 */     String decimales = "" + SUBAGUI + "0000000";
/* 5591 */     double TOTAGUI = SUBAGUI * complemento;
/* 5592 */     this.aux.setValue(Double.valueOf(TOTAGUI));
/* 5593 */     this.jTable1.setValueAt(decimales.substring(0, 6), 0, 5);
/* 5594 */     this.jTable1.setValueAt(diarioL, 0, 6);
/* 5595 */     this.jTable1.setValueAt(this.aux.getText(), 0, 7);
/*      */     
/* 5597 */     this.jTable1.setValueAt("VACACIONES", 1, 0);
/* 5598 */     this.jTable1.setValueAt(Integer.valueOf(this.DIAS), 1, 1);
/* 5599 */     this.jTable1.setValueAt("365", 1, 2);
/* 5600 */     this.jTable1.setValueAt(s1.substring(0, 6), 1, 3);
/* 5601 */     this.jTable1.setValueAt(s2.substring(0, 6), 1, 5);
/* 5602 */     this.jTable1.setValueAt(diarioL, 1, 6);
/* 5603 */     this.jTable1.setValueAt(this.cantidad.getText(), 1, 7);
/*      */     
/* 5605 */     double PRIMA = SUBTOTAL1 * 0.25D;
/* 5606 */     this.cantidad.setValue(Double.valueOf(PRIMA));
/* 5607 */     this.jTable1.setValueAt("PRIMA VACACIONAL (25%)", 2, 0);
/* 5608 */     this.jTable1.setValueAt(this.cantidad.getText(), 2, 7);
/*      */     
/* 5610 */     System.out.println("Tabla 1 " + s2.substring(0, 6));
/*      */ 
/*      */ 
/*      */     
/* 5614 */     FACTORDIAS = Double.parseDouble("" + this.DIAS) / Double.parseDouble("365");
/* 5615 */     s1 = "" + FACTORDIAS;
/* 5616 */     SUBTOTALDIAS = Double.parseDouble(s1.substring(0, 6)) * Integer.parseInt(this.jTextField4.getText());
/*      */     
/* 5618 */     SUBTOTAL1 = SUBTOTALDIAS * salarioImss;
/* 5619 */     this.cantidad.setValue(Double.valueOf(SUBTOTAL1));
/*      */     
/* 5621 */     s2 = "" + SUBTOTALDIAS + "0000000";
/*      */     
/* 5623 */     this.jTable2.setValueAt("AGUINALDO", 0, 0);
/* 5624 */     this.jTable2.setValueAt("15", 0, 1);
/* 5625 */     this.jTable2.setValueAt("365", 0, 2);
/* 5626 */     this.jTable2.setValueAt("0.0411", 0, 3);
/* 5627 */     SUBAGUI = Double.parseDouble("0.0411") * Double.parseDouble(String.valueOf(this.jTable2.getValueAt(0, 4)));
/* 5628 */     decimales = "" + SUBAGUI + "0000000";
/* 5629 */     TOTAGUI = SUBAGUI * salarioImss;
/* 5630 */     this.aux.setValue(Double.valueOf(TOTAGUI));
/*      */     
/* 5632 */     this.jTable2.setValueAt(decimales.substring(0, 6), 0, 5);
/* 5633 */     this.jTable2.setValueAt(this.DATOS[2], 0, 6);
/* 5634 */     this.jTable2.setValueAt(this.aux.getText(), 0, 7);
/*      */     
/* 5636 */     this.jTable2.setValueAt("VACACIONES", 1, 0);
/* 5637 */     this.jTable2.setValueAt(Integer.valueOf(this.DIAS), 1, 1);
/* 5638 */     this.jTable2.setValueAt("365", 1, 2);
/* 5639 */     this.jTable2.setValueAt(s1.substring(0, 6), 1, 3);
/* 5640 */     this.jTable2.setValueAt(s2.substring(0, 6), 1, 5);
/* 5641 */     this.jTable2.setValueAt(this.DATOS[2], 1, 6);
/* 5642 */     this.jTable2.setValueAt(this.cantidad.getText(), 1, 7);
/*      */     
/* 5644 */     PRIMA = SUBTOTAL1 * 0.25D;
/* 5645 */     this.cantidad.setValue(Double.valueOf(PRIMA));
/* 5646 */     this.jTable2.setValueAt("PRIMA VACACIONAL (25%)", 2, 0);
/* 5647 */     this.jTable2.setValueAt(this.cantidad.getText(), 2, 7);
/*      */     
/* 5649 */     System.out.println("Tabla 2 " + s2.substring(0, 6));
/*      */   }
/*      */ 
/*      */   
/*      */   public void restarFechas() {
/* 5654 */     int dias = 0;
/* 5655 */     int rangoAnyos = 0;
/* 5656 */     int diasAnyo = 0;
/*      */     
/* 5658 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5659 */     String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 5660 */     String año = cadenaFecha1.substring(0, 4);
/* 5661 */     String mes = cadenaFecha1.substring(4, 6);
/* 5662 */     String dia = cadenaFecha1.substring(6, 8);
/*      */     
/* 5664 */     Date fecha1 = this.jDateChooser7.getDate();
/* 5665 */     Date fecha2 = this.jDateChooser8.getDate();
/*      */     
/* 5667 */     long fechaInicialMs = fecha1.getTime();
/* 5668 */     long fechaFinalMs = fecha2.getTime();
/* 5669 */     long diferencia = fechaFinalMs - fechaInicialMs;
/* 5670 */     dias = (int)Math.floor((diferencia / 86400000L));
/* 5671 */     dias++;
/*      */     
/* 5673 */     int mesI = Integer.parseInt(mes);
/* 5674 */     int diaI = Integer.parseInt(dia);
/*      */     
/* 5676 */     Date fechaC = null;
/* 5677 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*      */     try {
/* 5679 */       fechaC = formatoDelTexto.parse("28-02-" + año);
/*      */     }
/* 5681 */     catch (ParseException ex) {
/* 5682 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 5685 */     if (fecha2.after(fechaC) && 
/* 5686 */       Integer.parseInt(año) % 4 == 0) {
/* 5687 */       dias--;
/*      */     }
/*      */ 
/*      */     
/* 5691 */     this.jTable1.setValueAt(Integer.valueOf(dias), 1, 4);
/* 5692 */     this.jTable2.setValueAt(Integer.valueOf(dias), 1, 4);
/* 5693 */     this.jTextField4.setText("" + dias);
/*      */   }
/*      */   
/*      */   public class CeldaRender extends DefaultTableCellRenderer {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5698 */       setEnabled((table == null || table.isEnabled()));
/* 5699 */       if (row % 2 == 0) {
/* 5700 */         setBackground(new Color(194, 213, 151));
/* 5701 */         setForeground(Color.black);
/*      */       } else {
/*      */         
/* 5704 */         setForeground(Color.black);
/* 5705 */         setBackground((Color)null);
/*      */       } 
/* 5707 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5708 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5714 */       setEnabled((table == null || table.isEnabled()));
/* 5715 */       setHorizontalAlignment(4);
/* 5716 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5717 */       return this;
/*      */     } }
/*      */   public class CeldaRender3 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2; String[] indices3; String[] indices4; String[] indices5;
/*      */     
/*      */     public CeldaRender3() {
/* 5722 */       this.otro = -1;
/* 5723 */       this.indices = new String[0];
/* 5724 */       this.indices2 = new String[0];
/* 5725 */       this.indices3 = new String[0];
/* 5726 */       this.indices4 = new String[0];
/* 5727 */       this.indices5 = new String[0];
/*      */     } public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5729 */       setEnabled((table == null || table.isEnabled()));
/* 5730 */       String comp = String.valueOf(table.getValueAt(row, 1));
/* 5731 */       if (comparar2(comp)) {
/* 5732 */         setBackground(new Color(153, 102, 0));
/* 5733 */         setForeground(Color.WHITE);
/*      */       }
/* 5735 */       else if (comparar3(comp)) {
/* 5736 */         setBackground(new Color(102, 153, 255));
/* 5737 */         setForeground(Color.BLUE);
/*      */       }
/* 5739 */       else if (comparar4(comp)) {
/* 5740 */         setBackground(Color.LIGHT_GRAY);
/* 5741 */         setForeground(Color.RED);
/*      */       }
/* 5743 */       else if (comparar5(comp)) {
/* 5744 */         setBackground(Color.RED);
/* 5745 */         setForeground(Color.WHITE);
/*      */       } else {
/*      */         
/* 5748 */         setBackground((Color)null);
/* 5749 */         setForeground(Color.black);
/*      */       } 
/* 5751 */       if (column == 6 || column == 7 || column == 8) {
/* 5752 */         setHorizontalAlignment(4);
/*      */       } else {
/*      */         
/* 5755 */         setHorizontalAlignment(10);
/*      */       } 
/*      */       
/* 5758 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5759 */       return this;
/*      */     }
/*      */     public void pasarInd(String[] ind) {
/* 5762 */       this.indices = ind;
/*      */     }
/*      */     public void pasarInd2(String[] ind) {
/* 5765 */       this.indices2 = ind;
/*      */     }
/*      */     public void pasarInd3(String[] ind) {
/* 5768 */       this.indices3 = ind;
/*      */     }
/*      */     public void pasarInd4(String[] ind) {
/* 5771 */       this.indices4 = ind;
/*      */     }
/*      */     public void pasarInd5(String[] ind) {
/* 5774 */       this.indices5 = ind;
/*      */     }
/*      */     public boolean comparar(String reg) {
/* 5777 */       for (int i = 0; i < this.indices.length; i++) {
/* 5778 */         if (this.indices[i].equals(reg)) {
/* 5779 */           return true;
/*      */         }
/*      */       } 
/* 5782 */       return false;
/*      */     }
/*      */     public boolean comparar2(String reg) {
/* 5785 */       for (int i = 0; i < this.indices2.length; i++) {
/* 5786 */         if (this.indices2[i].equals(reg)) {
/* 5787 */           return true;
/*      */         }
/*      */       } 
/* 5790 */       return false;
/*      */     }
/*      */     public boolean comparar3(String reg) {
/* 5793 */       for (int i = 0; i < this.indices3.length; i++) {
/* 5794 */         if (this.indices3[i].equals(reg)) {
/* 5795 */           return true;
/*      */         }
/*      */       } 
/* 5798 */       return false;
/*      */     }
/*      */     public boolean comparar4(String reg) {
/* 5801 */       for (int i = 0; i < this.indices4.length; i++) {
/* 5802 */         if (this.indices4[i].equals(reg)) {
/* 5803 */           return true;
/*      */         }
/*      */       } 
/* 5806 */       return false;
/*      */     }
/*      */     public boolean comparar5(String reg) {
/* 5809 */       for (int i = 0; i < this.indices5.length; i++) {
/* 5810 */         if (this.indices5[i].equals(reg)) {
/* 5811 */           return true;
/*      */         }
/*      */       } 
/* 5814 */       return false;
/*      */     } }
/*      */   class CeldaRender4 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2; String[] indices3;
/*      */     
/*      */     CeldaRender4() {
/* 5819 */       this.otro = -1;
/* 5820 */       this.indices = new String[0];
/* 5821 */       this.indices2 = new String[0];
/* 5822 */       this.indices3 = new String[0];
/*      */     } public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5824 */       setEnabled((table == null || table.isEnabled()));
/* 5825 */       String comp = String.valueOf(table.getValueAt(row, 0));
/*      */       
/* 5827 */       if (comparar(comp)) {
/* 5828 */         setBackground((Color)null);
/* 5829 */         setForeground(Color.BLUE);
/* 5830 */         setHorizontalAlignment(2);
/*      */       }
/* 5832 */       else if (comparar2(comp)) {
/* 5833 */         setBackground(Color.LIGHT_GRAY);
/* 5834 */         setForeground(Color.red);
/* 5835 */         setHorizontalAlignment(2);
/*      */       }
/* 5837 */       else if (comparar3(comp)) {
/* 5838 */         setBackground((Color)null);
/* 5839 */         setForeground(Color.RED);
/* 5840 */         setHorizontalAlignment(2);
/*      */       } else {
/*      */         
/* 5843 */         setBackground((Color)null);
/* 5844 */         setForeground(Color.black);
/* 5845 */         setHorizontalAlignment(2);
/*      */       } 
/* 5847 */       if (column == 5 || column == 6 || column == 7) {
/* 5848 */         setHorizontalAlignment(4);
/*      */       }
/* 5850 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5851 */       return this;
/*      */     }
/*      */     public void pasarInd(String[] ind) {
/* 5854 */       this.indices = ind;
/*      */     }
/*      */     public void pasarInd2(String[] ind) {
/* 5857 */       this.indices2 = ind;
/*      */     }
/*      */     public void pasarInd3(String[] ind) {
/* 5860 */       this.indices3 = ind;
/*      */     }
/*      */     public boolean comparar(String reg) {
/* 5863 */       for (int i = 0; i < this.indices.length; i++) {
/* 5864 */         if (this.indices[i].equals(reg)) {
/* 5865 */           return true;
/*      */         }
/*      */       } 
/* 5868 */       return false;
/*      */     }
/*      */     public boolean comparar2(String reg) {
/* 5871 */       for (int i = 0; i < this.indices2.length; i++) {
/* 5872 */         if (this.indices2[i].equals(reg)) {
/* 5873 */           return true;
/*      */         }
/*      */       } 
/* 5876 */       return false;
/*      */     }
/*      */     public boolean comparar3(String reg) {
/* 5879 */       for (int i = 0; i < this.indices3.length; i++) {
/* 5880 */         if (this.indices3[i].equals(reg)) {
/* 5881 */           return true;
/*      */         }
/*      */       } 
/* 5884 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   public int alinearDer(int x, int letras) {
/* 5889 */     int quitar = 4 * letras;
/* 5890 */     x -= quitar;
/* 5891 */     return x;
/*      */   }
/*      */   public class ImprimirFiniquitos implements Printable { String[] DATOS; int opc; Graphics2D g2; NumerosALetras letras;
/*      */     public ImprimirFiniquitos() {
/* 5895 */       this.DATOS = new String[] { "Datos1", "Datos2", "Datos3", "Datos4", "Datos5", "Datos6", "Datos7", "Datos8", "Datos9", "Datos10", "Datos11", "Datos12", "Datos13" };
/* 5896 */       this.opc = 0;
/* 5897 */       this.g2 = null;
/* 5898 */       this.letras = null;
/*      */     } public void titulo() {
/* 5900 */       Font fuente = new Font("Dialog", 1, 11);
/* 5901 */       this.g2.setFont(fuente);
/*      */     }
/*      */     public void subtitulo() {
/* 5904 */       Font fuente = new Font("Dialog", 1, 9);
/* 5905 */       this.g2.setFont(fuente);
/*      */     }
/*      */     public void contenido() {
/* 5908 */       Font fuente = new Font("Dialog", 0, 9);
/* 5909 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/* 5912 */     public String dameMes(String mes) { String mesLetra = "";
/* 5913 */       if (mes.equals("01")) {
/* 5914 */         mesLetra = "Enero";
/*      */       }
/* 5916 */       else if (mes.equals("02")) {
/* 5917 */         mesLetra = "Febrero";
/*      */       }
/* 5919 */       else if (mes.equals("03")) {
/* 5920 */         mesLetra = "Marzo";
/*      */       }
/* 5922 */       else if (mes.equals("04")) {
/* 5923 */         mesLetra = "Abril";
/*      */       }
/* 5925 */       else if (mes.equals("05")) {
/* 5926 */         mesLetra = "Mayo";
/*      */       }
/* 5928 */       else if (mes.equals("06")) {
/* 5929 */         mesLetra = "Junio";
/*      */       }
/* 5931 */       else if (mes.equals("07")) {
/* 5932 */         mesLetra = "Julio";
/*      */       }
/* 5934 */       else if (mes.equals("08")) {
/* 5935 */         mesLetra = "Agosto";
/*      */       }
/* 5937 */       else if (mes.equals("09")) {
/* 5938 */         mesLetra = "Septiembre";
/*      */       }
/* 5940 */       else if (mes.equals("10")) {
/* 5941 */         mesLetra = "Octubre";
/*      */       }
/* 5943 */       else if (mes.equals("11")) {
/* 5944 */         mesLetra = "Noviembre";
/*      */       }
/* 5946 */       else if (mes.equals("12")) {
/* 5947 */         mesLetra = "Diciembre";
/*      */       } 
/* 5949 */       return mesLetra; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen; Image img; SimpleDateFormat formato; String cadenaFecha1, año, mes, dia, mesLetra; ImageIcon tmpIcon; String datos[], domicilio; int y; double sumas, TOTAL; int i; boolean entra;
/*      */       String totalL;
/*      */       int j;
/* 5952 */       this.g2 = (Graphics2D)g;
/* 5953 */       f.setOrientation(0);
/* 5954 */       switch (pageIndex) {
/*      */         case 0:
/* 5956 */           fuente = new Font("Dialog", 0, 8);
/* 5957 */           this.g2.setFont(fuente);
/* 5958 */           this.g2.setColor(Color.BLACK);
/* 5959 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 5960 */           img = imagen.getImage();
/* 5961 */           this.g2.drawImage(img, 690, 17, 60, 60, null);
/*      */           
/* 5963 */           fuente = new Font("Times New Roman", 1, 16);
/* 5964 */           this.g2.setFont(fuente);
/* 5965 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 225, 30);
/* 5966 */           fuente = new Font("Dialog", 0, 11);
/* 5967 */           this.g2.setFont(fuente);
/* 5968 */           this.g2.drawString("AUTOPISTA MONTERREY CADEREYTA KM 32.5, C.P. 67450", 240, 44);
/* 5969 */           this.g2.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN", 298, 58);
/*      */           
/* 5971 */           fuente = new Font("Dialog", 1, 13);
/* 5972 */           this.g2.setFont(fuente);
/* 5973 */           this.g2.drawString("FINIQUITO", 360, 76);
/* 5974 */           this.g2.drawLine(25, 78, 760, 78);
/*      */           
/* 5976 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 5977 */           cadenaFecha1 = formato.format(new Date());
/*      */           
/* 5979 */           año = cadenaFecha1.substring(0, 4);
/* 5980 */           mes = cadenaFecha1.substring(4, 6);
/* 5981 */           dia = cadenaFecha1.substring(6, 8);
/* 5982 */           mesLetra = dameMes(mes);
/*      */           
/* 5984 */           fuente = new Font("Dialog", 0, 11);
/* 5985 */           this.g2.setFont(fuente);
/* 5986 */           this.g2.drawString("IMPRESIÓN:", 50, 76);
/* 5987 */           this.g2.drawString("BASE:", 580, 76);
/*      */           
/* 5989 */           fuente = new Font("Dialog", 1, 11);
/* 5990 */           this.g2.setFont(fuente);
/* 5991 */           this.g2.drawString(dia + "/" + dia + "/" + mesLetra, 129, 76);
/* 5992 */           this.g2.drawString(Finiquitos.this.base, 630, 76);
/*      */ 
/*      */           
/* 5995 */           this.g2.setColor(new Color(56, 93, 138));
/* 5996 */           this.g2.drawRoundRect(25, 110, 57, 71, 10, 10);
/*      */           
/* 5998 */           tmpIcon = null;
/* 5999 */           if (Finiquitos.this.jRadioButton1.isSelected()) {
/* 6000 */             tmpIcon = new ImageIcon(Finiquitos.this.CONFIG[0] + "/" + Finiquitos.this.CONFIG[0] + ".png");
/*      */           } else {
/*      */             
/* 6003 */             tmpIcon = new ImageIcon(Finiquitos.this.CONFIG[1] + "/" + Finiquitos.this.CONFIG[1] + ".png");
/*      */           } 
/*      */           
/* 6006 */           img = tmpIcon.getImage();
/* 6007 */           this.g2.drawImage(img, 27, 113, 53, 65, null);
/*      */           
/* 6009 */           datos = Finiquitos.this.con.regresaReg("calle,num,col,cp,ciudad", "empleados", "where clave_emp=" + Finiquitos.this.CLAVE, 5);
/* 6010 */           domicilio = "";
/* 6011 */           if (!datos[0].equals("")) {
/* 6012 */             domicilio = "CALLE " + datos[0];
/*      */           }
/* 6014 */           if (!datos[1].equals("")) {
/* 6015 */             domicilio = domicilio + ", NÚM. " + domicilio;
/*      */           }
/* 6017 */           if (!datos[2].equals("")) {
/* 6018 */             domicilio = domicilio + ", COL. " + domicilio;
/*      */           }
/* 6020 */           if (!datos[3].equals("")) {
/* 6021 */             domicilio = domicilio + ", C.P. " + domicilio;
/*      */           }
/* 6023 */           if (!datos[4].equals("")) {
/* 6024 */             domicilio = domicilio + ", CIUDAD " + domicilio;
/*      */           }
/*      */           
/* 6027 */           this.g2.setColor(Color.BLACK);
/* 6028 */           contenido();
/* 6029 */           this.g2.drawString("CVE EMP: ", 25, 90);
/* 6030 */           this.g2.drawString("NOMBRE: ", 110, 90);
/* 6031 */           this.g2.drawString("DOMICILIO: ", 103, 102);
/*      */           
/* 6033 */           subtitulo();
/* 6034 */           this.g2.drawString(Finiquitos.this.CLAVE, 70, 90);
/* 6035 */           this.g2.drawString(Finiquitos.this.jTextField5.getText(), 155, 90);
/* 6036 */           this.g2.drawString(domicilio, 155, 102);
/*      */           
/* 6038 */           this.g2.drawRoundRect(95, 108, 250, 80, 10, 10);
/* 6039 */           this.g2.drawRoundRect(362, 108, 190, 80, 10, 10);
/* 6040 */           this.g2.drawRoundRect(570, 108, 190, 80, 10, 10);
/*      */           
/* 6042 */           this.g2.drawLine(95, 118, 345, 118);
/* 6043 */           this.g2.drawLine(362, 118, 552, 118);
/* 6044 */           this.g2.drawLine(570, 118, 760, 118);
/*      */           
/* 6046 */           fuente = new Font("Dialog", 0, 6);
/* 6047 */           this.g2.setFont(fuente);
/* 6048 */           this.g2.drawString("Información del Reporte", 190, 115);
/* 6049 */           this.g2.drawString("Información de Vacaciones", 419, 115);
/* 6050 */           this.g2.drawString("Información del Aguinaldo", 630, 115);
/*      */           
/* 6052 */           contenido();
/* 6053 */           this.g2.drawString("DEPARTAMENTO: ", 105, 132);
/* 6054 */           this.g2.drawString("INGRESO: ", 105, 147);
/* 6055 */           this.g2.drawString("FECHA DEL FINIQUITO: ", 105, 162);
/*      */           
/* 6057 */           this.g2.drawString("PERIODO: ", 372, 132);
/* 6058 */           this.g2.drawString("FECHA DE INICIO: ", 372, 147);
/* 6059 */           this.g2.drawString("FECHA FINAL: ", 372, 162);
/* 6060 */           this.g2.drawString("DÍAS: ", 372, 177);
/*      */           
/* 6062 */           this.g2.drawString("FECHA DE INICIO:", 580, 132);
/* 6063 */           this.g2.drawString("FECHA FINAL:", 580, 147);
/* 6064 */           this.g2.drawString("DÍAS:", 580, 162);
/*      */           
/* 6066 */           subtitulo();
/* 6067 */           this.g2.drawString(String.valueOf(Finiquitos.this.jComboBox6.getSelectedItem()), 213, 132);
/* 6068 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 6069 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser9.getDate());
/* 6070 */           año = cadenaFecha1.substring(0, 4);
/* 6071 */           mes = cadenaFecha1.substring(4, 6);
/* 6072 */           dia = cadenaFecha1.substring(6, 8);
/* 6073 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 213, 147);
/*      */           
/* 6075 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser10.getDate());
/* 6076 */           año = cadenaFecha1.substring(0, 4);
/* 6077 */           mes = cadenaFecha1.substring(4, 6);
/* 6078 */           dia = cadenaFecha1.substring(6, 8);
/* 6079 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 213, 162);
/*      */ 
/*      */           
/* 6082 */           this.g2.drawString(String.valueOf(Finiquitos.this.jComboBox5.getSelectedItem()), 460, 132);
/* 6083 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser7.getDate());
/* 6084 */           año = cadenaFecha1.substring(0, 4);
/* 6085 */           mes = cadenaFecha1.substring(4, 6);
/* 6086 */           dia = cadenaFecha1.substring(6, 8);
/* 6087 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 460, 147);
/*      */           
/* 6089 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser8.getDate());
/* 6090 */           año = cadenaFecha1.substring(0, 4);
/* 6091 */           mes = cadenaFecha1.substring(4, 6);
/* 6092 */           dia = cadenaFecha1.substring(6, 8);
/* 6093 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 460, 162);
/* 6094 */           this.g2.drawString(Finiquitos.this.jTextField4.getText(), 460, 177);
/*      */ 
/*      */           
/* 6097 */           if (Finiquitos.this.jDateChooser11.getDate() == null) {
/* 6098 */             this.g2.drawString("-----", 670, 132);
/* 6099 */             this.g2.drawString("-----", 670, 147);
/*      */           } else {
/*      */             
/* 6102 */             cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser11.getDate());
/* 6103 */             año = cadenaFecha1.substring(0, 4);
/* 6104 */             mes = cadenaFecha1.substring(4, 6);
/* 6105 */             dia = cadenaFecha1.substring(6, 8);
/* 6106 */             this.g2.drawString(dia + "/" + dia + "/" + mes, 670, 132);
/*      */             
/* 6108 */             cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser12.getDate());
/* 6109 */             año = cadenaFecha1.substring(0, 4);
/* 6110 */             mes = cadenaFecha1.substring(4, 6);
/* 6111 */             dia = cadenaFecha1.substring(6, 8);
/* 6112 */             this.g2.drawString(dia + "/" + dia + "/" + mes, 670, 147);
/*      */           } 
/* 6114 */           this.g2.drawString(Finiquitos.this.jTextField7.getText(), 670, 162);
/*      */           
/* 6116 */           fuente = new Font("Dialog", 2, 8);
/* 6117 */           this.g2.setFont(fuente);
/* 6118 */           this.g2.setColor(new Color(204, 0, 0));
/* 6119 */           this.g2.fillRect(25, 192, 735, 10);
/* 6120 */           this.g2.drawRect(25, 202, 734, 25);
/* 6121 */           this.g2.drawLine(155, 193, 155, 227);
/* 6122 */           this.g2.drawLine(235, 193, 235, 227);
/* 6123 */           this.g2.drawLine(315, 193, 315, 227);
/* 6124 */           this.g2.drawLine(395, 193, 395, 227);
/* 6125 */           this.g2.drawLine(475, 193, 475, 227);
/* 6126 */           this.g2.drawLine(555, 193, 555, 227);
/* 6127 */           this.g2.drawLine(635, 193, 635, 227);
/* 6128 */           this.g2.setColor(Color.BLACK);
/* 6129 */           this.g2.drawString("CONCEPTO", 70, 218);
/* 6130 */           this.g2.drawString("DÍAS POR LEY", 170, 218);
/* 6131 */           this.g2.drawString("DÍAS DEL AÑO", 247, 218);
/* 6132 */           this.g2.drawString("FACTOR EN DÍAS", 320, 218);
/* 6133 */           this.g2.drawString("DÍAS C/DERECHO", 400, 218);
/* 6134 */           this.g2.drawString("SUBTOTAL", 495, 212);
/* 6135 */           this.g2.drawString("EN DÍAS", 500, 224);
/* 6136 */           this.g2.drawString("SALARIO DIARIO", 562, 218);
/* 6137 */           this.g2.drawString("IMPORTE", 672, 218);
/*      */           
/* 6139 */           subtitulo();
/* 6140 */           y = 239;
/* 6141 */           sumas = 0.0D;
/* 6142 */           TOTAL = 0.0D;
/* 6143 */           for (i = 0; i < Finiquitos.this.jTable1.getRowCount(); i++) {
/* 6144 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable1.getValueAt(i, 0)), 27, y);
/* 6145 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable1.getValueAt(i, 1)), 195, y);
/* 6146 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable1.getValueAt(i, 2)), 268, y);
/* 6147 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable1.getValueAt(i, 3)), 343, y);
/* 6148 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable1.getValueAt(i, 4)), Finiquitos.this.alinearDer(440, Finiquitos.this.jTable1.getValueAt(i, 4).toString().length()), y);
/* 6149 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable1.getValueAt(i, 5)), Finiquitos.this.alinearDer(532, Finiquitos.this.jTable1.getValueAt(i, 5).toString().length()), y);
/* 6150 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable1.getValueAt(i, 6)), 577, y);
/* 6151 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable1.getValueAt(i, 7)), Finiquitos.this.alinearDer(720, Finiquitos.this.jTable1.getValueAt(i, 7).toString().length()), y);
/*      */             
/* 6153 */             String canti = String.valueOf(Finiquitos.this.jTable1.getValueAt(i, 7));
/* 6154 */             String valorP = "";
/* 6155 */             for (int k = 0; k < canti.length(); k++) {
/* 6156 */               if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 6157 */                 valorP = valorP + valorP;
/*      */               }
/*      */             } 
/* 6160 */             sumas += Double.parseDouble(valorP);
/* 6161 */             y += 14;
/*      */           } 
/* 6163 */           TOTAL = sumas;
/* 6164 */           this.g2.setColor(Color.WHITE);
/* 6165 */           fuente = new Font("Dialog", 1, 8);
/* 6166 */           this.g2.setFont(fuente);
/* 6167 */           this.g2.drawString("CÁLCULO DEL FINIQUITO", 340, 200);
/*      */           
/* 6169 */           this.g2.setColor(Color.BLACK);
/* 6170 */           subtitulo();
/* 6171 */           Finiquitos.this.cantidad.setValue(Double.valueOf(sumas));
/* 6172 */           this.g2.drawString(Finiquitos.this.cantidad.getText(), Finiquitos.this.alinearDer(720, Finiquitos.this.cantidad.getText().length()), y);
/*      */           
/* 6174 */           contenido();
/* 6175 */           this.g2.drawString("__________________", 640, y - 11);
/* 6176 */           this.g2.drawString("__________________", 640, y - 10);
/* 6177 */           this.g2.drawString("SUBTOTAL FINIQUITO", 515, y);
/*      */           
/* 6179 */           this.g2.setColor(new Color(204, 0, 0));
/* 6180 */           this.g2.fillRect(25, 325, 735, 10);
/* 6181 */           this.g2.drawRect(25, 335, 734, 25);
/* 6182 */           this.g2.drawLine(70, 326, 70, 360);
/* 6183 */           this.g2.drawLine(635, 326, 635, 360);
/*      */           
/* 6185 */           this.g2.setColor(Color.BLACK);
/* 6186 */           fuente = new Font("Dialog", 2, 8);
/* 6187 */           this.g2.setFont(fuente);
/* 6188 */           this.g2.drawString("NÚM", 35, 351);
/* 6189 */           this.g2.drawString("CONCEPTO", 340, 351);
/* 6190 */           this.g2.drawString("IMPORTE", 672, 351);
/*      */           
/* 6192 */           this.g2.setColor(Color.WHITE);
/* 6193 */           fuente = new Font("Dialog", 1, 8);
/* 6194 */           this.g2.setFont(fuente);
/* 6195 */           this.g2.drawString("DESCUENTOS", 368, 333);
/* 6196 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 6198 */           subtitulo();
/* 6199 */           y = 372;
/* 6200 */           sumas = 0.0D;
/* 6201 */           entra = false;
/* 6202 */           if (Finiquitos.this.jTable4.getRowCount() > 0) {
/* 6203 */             for (int k = 0; k < Finiquitos.this.jTable4.getRowCount(); k++) {
/* 6204 */               this.g2.drawString("" + k + 1, 45, y);
/* 6205 */               this.g2.drawString(String.valueOf(Finiquitos.this.jTable4.getValueAt(k, 0)), 75, y);
/* 6206 */               this.g2.drawString(String.valueOf(Finiquitos.this.jTable4.getValueAt(k, 1)), Finiquitos.this.alinearDer(720, Finiquitos.this.jTable4.getValueAt(k, 1).toString().length()), y);
/*      */               
/* 6208 */               String canti = String.valueOf(Finiquitos.this.jTable4.getValueAt(k, 1));
/* 6209 */               String valorP = "";
/* 6210 */               for (int m = 0; m < canti.length(); m++) {
/* 6211 */                 if (canti.charAt(m) != '$' && canti.charAt(m) != ',') {
/* 6212 */                   valorP = valorP + valorP;
/*      */                 }
/*      */               } 
/* 6215 */               sumas += Double.parseDouble(valorP);
/* 6216 */               y += 14;
/* 6217 */               entra = true;
/*      */             } 
/*      */           } else {
/*      */             
/* 6221 */             this.g2.drawString("NO SE REGISTRARON DESCUENTOS PARA ESTE CÁLCULO...", 30, y);
/*      */           } 
/* 6223 */           if (entra) {
/* 6224 */             y -= 14;
/*      */           }
/* 6226 */           TOTAL -= sumas;
/* 6227 */           contenido();
/* 6228 */           Finiquitos.this.cantidad.setValue(Double.valueOf(sumas));
/* 6229 */           this.g2.drawString("__________________", 640, y + 2);
/* 6230 */           this.g2.drawString("__________________", 640, y + 3);
/* 6231 */           this.g2.drawString("SUBTOTAL DESCUENTOS", 515, y + 13);
/*      */           
/* 6233 */           subtitulo();
/* 6234 */           this.g2.drawString(Finiquitos.this.cantidad.getText(), Finiquitos.this.alinearDer(720, Finiquitos.this.cantidad.getText().length()), y + 13);
/*      */           
/* 6236 */           this.g2.setColor(new Color(204, 0, 0));
/* 6237 */           this.g2.fillRect(690, 450, 70, 10);
/* 6238 */           this.g2.drawRect(25, 460, 734, 35);
/*      */           
/* 6240 */           this.g2.setColor(Color.WHITE);
/* 6241 */           fuente = new Font("Dialog", 0, 7);
/* 6242 */           this.g2.setFont(fuente);
/* 6243 */           this.g2.drawString("TOTAL EN LETRA", 695, 458);
/*      */           
/* 6245 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 6247 */           Finiquitos.this.numLetra = new NumerosALetras(TOTAL, "MXN");
/* 6248 */           subtitulo();
/* 6249 */           totalL = "  (" + Finiquitos.this.numLetra.regresaNumero() + ")";
/* 6250 */           this.g2.drawString(totalL, Finiquitos.this.alinearDer(680, totalL.length()), 490);
/* 6251 */           this.g2.drawString(Finiquitos.this.jLabel19.getText(), Finiquitos.this.alinearDer(720, Finiquitos.this.jLabel19.getText().length()), 475);
/*      */           
/* 6253 */           this.g2.drawRect(25, 500, 734, 10);
/* 6254 */           this.g2.drawRect(25, 510, 734, 50);
/* 6255 */           this.g2.drawLine(460, 500, 460, 560);
/* 6256 */           this.g2.drawLine(610, 500, 610, 560);
/*      */           
/* 6258 */           fuente = new Font("Dialog", 1, 9);
/* 6259 */           this.g2.setFont(fuente);
/* 6260 */           this.g2.drawString("Firma y Huellas del Trabajador", 175, 508);
/* 6261 */           this.g2.drawString("Firma de Testigos", 494, 508);
/* 6262 */           this.g2.drawString("Firma de Autorizado", 642, 508);
/*      */           
/* 6264 */           fuente = new Font("Dialog", 0, 7);
/* 6265 */           this.g2.setFont(fuente);
/* 6266 */           this.g2.drawString("COMPLEMENTO", 25, 570);
/* 6267 */           this.g2.drawString(Finiquitos.this.jTextField6.getText(), 727, 570);
/*      */           
/* 6269 */           return 0;
/*      */         case 1:
/* 6271 */           fuente = new Font("Dialog", 0, 8);
/* 6272 */           this.g2.setFont(fuente);
/* 6273 */           this.g2.setColor(Color.BLACK);
/* 6274 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 6275 */           img = imagen.getImage();
/* 6276 */           this.g2.drawImage(img, 690, 17, 60, 60, null);
/*      */           
/* 6278 */           fuente = new Font("Times New Roman", 1, 16);
/* 6279 */           this.g2.setFont(fuente);
/* 6280 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 225, 30);
/* 6281 */           fuente = new Font("Dialog", 0, 11);
/* 6282 */           this.g2.setFont(fuente);
/* 6283 */           this.g2.drawString("AUTOPISTA MONTERREY CADEREYTA KM 32.5, C.P. 67450", 240, 44);
/* 6284 */           this.g2.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN", 298, 58);
/*      */           
/* 6286 */           fuente = new Font("Dialog", 1, 13);
/* 6287 */           this.g2.setFont(fuente);
/* 6288 */           this.g2.drawString("FINIQUITO", 360, 76);
/* 6289 */           this.g2.drawLine(25, 78, 760, 78);
/*      */           
/* 6291 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 6292 */           cadenaFecha1 = formato.format(new Date());
/*      */           
/* 6294 */           año = cadenaFecha1.substring(0, 4);
/* 6295 */           mes = cadenaFecha1.substring(4, 6);
/* 6296 */           dia = cadenaFecha1.substring(6, 8);
/* 6297 */           mesLetra = dameMes(mes);
/*      */           
/* 6299 */           fuente = new Font("Dialog", 0, 11);
/* 6300 */           this.g2.setFont(fuente);
/* 6301 */           this.g2.drawString("IMPRESIÓN:", 50, 76);
/* 6302 */           this.g2.drawString("BASE:", 580, 76);
/*      */           
/* 6304 */           fuente = new Font("Dialog", 1, 11);
/* 6305 */           this.g2.setFont(fuente);
/* 6306 */           this.g2.drawString(dia + "/" + dia + "/" + mesLetra, 129, 76);
/* 6307 */           this.g2.drawString(Finiquitos.this.base, 630, 76);
/*      */ 
/*      */           
/* 6310 */           this.g2.setColor(new Color(56, 93, 138));
/* 6311 */           this.g2.drawRoundRect(25, 110, 57, 71, 10, 10);
/*      */           
/* 6313 */           tmpIcon = null;
/* 6314 */           if (Finiquitos.this.jRadioButton1.isSelected()) {
/* 6315 */             tmpIcon = new ImageIcon(Finiquitos.this.CONFIG[0] + "/" + Finiquitos.this.CONFIG[0] + ".png");
/*      */           } else {
/*      */             
/* 6318 */             tmpIcon = new ImageIcon(Finiquitos.this.CONFIG[1] + "/" + Finiquitos.this.CONFIG[1] + ".png");
/*      */           } 
/*      */           
/* 6321 */           datos = Finiquitos.this.con.regresaReg("calle,num,col,cp,ciudad", "empleados", "where clave_emp=" + Finiquitos.this.CLAVE, 5);
/* 6322 */           domicilio = "";
/* 6323 */           if (!datos[0].equals("")) {
/* 6324 */             domicilio = "CALLE " + datos[0];
/*      */           }
/* 6326 */           if (!datos[1].equals("")) {
/* 6327 */             domicilio = domicilio + ", NÚM. " + domicilio;
/*      */           }
/* 6329 */           if (!datos[2].equals("")) {
/* 6330 */             domicilio = domicilio + ", COL. " + domicilio;
/*      */           }
/* 6332 */           if (!datos[3].equals("")) {
/* 6333 */             domicilio = domicilio + ", C.P. " + domicilio;
/*      */           }
/* 6335 */           if (!datos[4].equals("")) {
/* 6336 */             domicilio = domicilio + ", CIUDAD " + domicilio;
/*      */           }
/*      */           
/* 6339 */           img = tmpIcon.getImage();
/* 6340 */           this.g2.drawImage(img, 27, 113, 53, 65, null);
/*      */           
/* 6342 */           this.g2.setColor(Color.BLACK);
/* 6343 */           contenido();
/* 6344 */           this.g2.drawString("CVE EMP: ", 25, 90);
/* 6345 */           this.g2.drawString("NOMBRE: ", 110, 90);
/* 6346 */           this.g2.drawString("DOMICILIO: ", 103, 102);
/*      */           
/* 6348 */           subtitulo();
/* 6349 */           this.g2.drawString(Finiquitos.this.CLAVE, 70, 90);
/* 6350 */           this.g2.drawString(Finiquitos.this.jTextField5.getText(), 155, 90);
/* 6351 */           this.g2.drawString(domicilio, 155, 102);
/*      */           
/* 6353 */           this.g2.drawRoundRect(95, 108, 250, 80, 10, 10);
/* 6354 */           this.g2.drawRoundRect(362, 108, 190, 80, 10, 10);
/* 6355 */           this.g2.drawRoundRect(570, 108, 190, 80, 10, 10);
/*      */           
/* 6357 */           this.g2.drawLine(95, 118, 345, 118);
/* 6358 */           this.g2.drawLine(362, 118, 552, 118);
/* 6359 */           this.g2.drawLine(570, 118, 760, 118);
/*      */           
/* 6361 */           fuente = new Font("Dialog", 0, 6);
/* 6362 */           this.g2.setFont(fuente);
/* 6363 */           this.g2.drawString("Información del Reporte", 190, 115);
/* 6364 */           this.g2.drawString("Información de Vacaciones", 419, 115);
/* 6365 */           this.g2.drawString("Información del Aguinaldo", 630, 115);
/*      */           
/* 6367 */           contenido();
/* 6368 */           this.g2.drawString("DEPARTAMENTO: ", 105, 132);
/* 6369 */           this.g2.drawString("INGRESO: ", 105, 147);
/* 6370 */           this.g2.drawString("FECHA DEL FINIQUITO: ", 105, 162);
/*      */           
/* 6372 */           this.g2.drawString("PERIODO: ", 372, 132);
/* 6373 */           this.g2.drawString("FECHA DE INICIO: ", 372, 147);
/* 6374 */           this.g2.drawString("FECHA FINAL: ", 372, 162);
/* 6375 */           this.g2.drawString("DÍAS: ", 372, 177);
/*      */           
/* 6377 */           this.g2.drawString("FECHA DE INICIO:", 580, 132);
/* 6378 */           this.g2.drawString("FECHA FINAL:", 580, 147);
/* 6379 */           this.g2.drawString("DÍAS:", 580, 162);
/*      */           
/* 6381 */           subtitulo();
/* 6382 */           this.g2.drawString(String.valueOf(Finiquitos.this.jComboBox6.getSelectedItem()), 213, 132);
/* 6383 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 6384 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser9.getDate());
/* 6385 */           año = cadenaFecha1.substring(0, 4);
/* 6386 */           mes = cadenaFecha1.substring(4, 6);
/* 6387 */           dia = cadenaFecha1.substring(6, 8);
/* 6388 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 213, 147);
/*      */           
/* 6390 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser10.getDate());
/* 6391 */           año = cadenaFecha1.substring(0, 4);
/* 6392 */           mes = cadenaFecha1.substring(4, 6);
/* 6393 */           dia = cadenaFecha1.substring(6, 8);
/* 6394 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 213, 162);
/*      */ 
/*      */           
/* 6397 */           this.g2.drawString(String.valueOf(Finiquitos.this.jComboBox5.getSelectedItem()), 460, 132);
/* 6398 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser7.getDate());
/* 6399 */           año = cadenaFecha1.substring(0, 4);
/* 6400 */           mes = cadenaFecha1.substring(4, 6);
/* 6401 */           dia = cadenaFecha1.substring(6, 8);
/* 6402 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 460, 147);
/*      */           
/* 6404 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser8.getDate());
/* 6405 */           año = cadenaFecha1.substring(0, 4);
/* 6406 */           mes = cadenaFecha1.substring(4, 6);
/* 6407 */           dia = cadenaFecha1.substring(6, 8);
/* 6408 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 460, 162);
/* 6409 */           this.g2.drawString(Finiquitos.this.jTextField4.getText(), 460, 177);
/*      */ 
/*      */           
/* 6412 */           if (Finiquitos.this.jDateChooser11.getDate() == null) {
/* 6413 */             this.g2.drawString("-----", 670, 132);
/* 6414 */             this.g2.drawString("-----", 670, 147);
/*      */           } else {
/*      */             
/* 6417 */             cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser11.getDate());
/* 6418 */             año = cadenaFecha1.substring(0, 4);
/* 6419 */             mes = cadenaFecha1.substring(4, 6);
/* 6420 */             dia = cadenaFecha1.substring(6, 8);
/* 6421 */             this.g2.drawString(dia + "/" + dia + "/" + mes, 670, 132);
/*      */             
/* 6423 */             cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser12.getDate());
/* 6424 */             año = cadenaFecha1.substring(0, 4);
/* 6425 */             mes = cadenaFecha1.substring(4, 6);
/* 6426 */             dia = cadenaFecha1.substring(6, 8);
/* 6427 */             this.g2.drawString(dia + "/" + dia + "/" + mes, 670, 147);
/*      */           } 
/* 6429 */           this.g2.drawString(Finiquitos.this.jTextField7.getText(), 670, 162);
/*      */           
/* 6431 */           fuente = new Font("Dialog", 2, 8);
/* 6432 */           this.g2.setFont(fuente);
/* 6433 */           this.g2.setColor(new Color(204, 0, 0));
/* 6434 */           this.g2.fillRect(25, 192, 735, 10);
/* 6435 */           this.g2.drawRect(25, 202, 734, 25);
/* 6436 */           this.g2.drawLine(155, 193, 155, 227);
/* 6437 */           this.g2.drawLine(235, 193, 235, 227);
/* 6438 */           this.g2.drawLine(315, 193, 315, 227);
/* 6439 */           this.g2.drawLine(395, 193, 395, 227);
/* 6440 */           this.g2.drawLine(475, 193, 475, 227);
/* 6441 */           this.g2.drawLine(555, 193, 555, 227);
/* 6442 */           this.g2.drawLine(635, 193, 635, 227);
/* 6443 */           this.g2.setColor(Color.BLACK);
/* 6444 */           this.g2.drawString("CONCEPTO", 70, 218);
/* 6445 */           this.g2.drawString("DÍAS POR LEY", 170, 218);
/* 6446 */           this.g2.drawString("DÍAS DEL AÑO", 247, 218);
/* 6447 */           this.g2.drawString("FACTOR EN DÍAS", 320, 218);
/* 6448 */           this.g2.drawString("DÍAS C/DERECHO", 400, 218);
/* 6449 */           this.g2.drawString("SUBTOTAL", 495, 212);
/* 6450 */           this.g2.drawString("EN DÍAS", 500, 224);
/* 6451 */           this.g2.drawString("SALARIO DIARIO", 562, 218);
/* 6452 */           this.g2.drawString("IMPORTE", 672, 218);
/*      */           
/* 6454 */           subtitulo();
/* 6455 */           y = 239;
/* 6456 */           sumas = 0.0D;
/* 6457 */           TOTAL = 0.0D;
/* 6458 */           for (j = 0; j < Finiquitos.this.jTable2.getRowCount(); j++) {
/* 6459 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(j, 0)), 27, y);
/* 6460 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(j, 1)), 195, y);
/* 6461 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(j, 2)), 268, y);
/* 6462 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(j, 3)), 343, y);
/* 6463 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(j, 4)), Finiquitos.this.alinearDer(440, Finiquitos.this.jTable2.getValueAt(j, 4).toString().length()), y);
/* 6464 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(j, 5)), Finiquitos.this.alinearDer(532, Finiquitos.this.jTable2.getValueAt(j, 5).toString().length()), y);
/* 6465 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(j, 6)), 577, y);
/* 6466 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(j, 7)), Finiquitos.this.alinearDer(720, Finiquitos.this.jTable2.getValueAt(j, 7).toString().length()), y);
/*      */             
/* 6468 */             String canti = String.valueOf(Finiquitos.this.jTable2.getValueAt(j, 7));
/* 6469 */             String valorP = "";
/* 6470 */             for (int k = 0; k < canti.length(); k++) {
/* 6471 */               if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 6472 */                 valorP = valorP + valorP;
/*      */               }
/*      */             } 
/* 6475 */             sumas += Double.parseDouble(valorP);
/* 6476 */             y += 14;
/*      */           } 
/* 6478 */           TOTAL = sumas;
/* 6479 */           this.g2.setColor(Color.WHITE);
/* 6480 */           fuente = new Font("Dialog", 1, 8);
/* 6481 */           this.g2.setFont(fuente);
/* 6482 */           this.g2.drawString("CÁLCULO DEL FINIQUITO", 340, 200);
/*      */           
/* 6484 */           this.g2.setColor(Color.BLACK);
/* 6485 */           subtitulo();
/* 6486 */           Finiquitos.this.cantidad.setValue(Double.valueOf(sumas));
/* 6487 */           this.g2.drawString(Finiquitos.this.cantidad.getText(), Finiquitos.this.alinearDer(720, Finiquitos.this.cantidad.getText().length()), y);
/*      */           
/* 6489 */           contenido();
/* 6490 */           this.g2.drawString("__________________", 640, y - 10);
/* 6491 */           this.g2.drawString("__________________", 640, y - 11);
/* 6492 */           this.g2.drawString("SUBTOTAL FINIQUITO", 515, y);
/*      */           
/* 6494 */           this.g2.setColor(new Color(204, 0, 0));
/* 6495 */           this.g2.fillRect(25, 325, 735, 10);
/* 6496 */           this.g2.drawRect(25, 335, 734, 25);
/* 6497 */           this.g2.drawLine(70, 326, 70, 360);
/* 6498 */           this.g2.drawLine(635, 326, 635, 360);
/*      */           
/* 6500 */           this.g2.setColor(Color.BLACK);
/* 6501 */           fuente = new Font("Dialog", 2, 8);
/* 6502 */           this.g2.setFont(fuente);
/* 6503 */           this.g2.drawString("NÚM", 35, 351);
/* 6504 */           this.g2.drawString("CONCEPTO", 340, 351);
/* 6505 */           this.g2.drawString("IMPORTE", 672, 351);
/*      */           
/* 6507 */           this.g2.setColor(Color.WHITE);
/* 6508 */           fuente = new Font("Dialog", 1, 8);
/* 6509 */           this.g2.setFont(fuente);
/* 6510 */           this.g2.drawString("DESCUENTOS", 368, 333);
/* 6511 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 6513 */           subtitulo();
/* 6514 */           y = 372;
/* 6515 */           sumas = 0.0D;
/* 6516 */           entra = false;
/* 6517 */           if (Finiquitos.this.jTable5.getRowCount() > 0) {
/* 6518 */             for (j = 0; j < Finiquitos.this.jTable5.getRowCount(); j++) {
/* 6519 */               this.g2.drawString("" + j + 1, 45, y);
/* 6520 */               this.g2.drawString(String.valueOf(Finiquitos.this.jTable5.getValueAt(j, 0)), 75, y);
/* 6521 */               this.g2.drawString(String.valueOf(Finiquitos.this.jTable5.getValueAt(j, 1)), Finiquitos.this.alinearDer(720, Finiquitos.this.jTable5.getValueAt(j, 1).toString().length()), y);
/*      */               
/* 6523 */               String canti = String.valueOf(Finiquitos.this.jTable5.getValueAt(j, 1));
/* 6524 */               String valorP = "";
/* 6525 */               for (int k = 0; k < canti.length(); k++) {
/* 6526 */                 if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 6527 */                   valorP = valorP + valorP;
/*      */                 }
/*      */               } 
/* 6530 */               sumas += Double.parseDouble(valorP);
/* 6531 */               y += 14;
/* 6532 */               entra = true;
/*      */             } 
/*      */           } else {
/*      */             
/* 6536 */             this.g2.drawString("NO SE REGISTRARON DESCUENTOS PARA ESTE CÁLCULO...", 30, y);
/*      */           } 
/* 6538 */           if (entra) {
/* 6539 */             y -= 14;
/*      */           }
/* 6541 */           TOTAL -= sumas;
/* 6542 */           contenido();
/* 6543 */           Finiquitos.this.cantidad.setValue(Double.valueOf(sumas));
/* 6544 */           this.g2.drawString("__________________", 640, y + 2);
/* 6545 */           this.g2.drawString("__________________", 640, y + 3);
/* 6546 */           this.g2.drawString("SUBTOTAL DESCUENTOS", 515, y + 13);
/*      */           
/* 6548 */           subtitulo();
/* 6549 */           this.g2.drawString(Finiquitos.this.cantidad.getText(), Finiquitos.this.alinearDer(720, Finiquitos.this.cantidad.getText().length()), y + 13);
/*      */           
/* 6551 */           this.g2.setColor(new Color(204, 0, 0));
/* 6552 */           this.g2.fillRect(690, 450, 70, 10);
/* 6553 */           this.g2.drawRect(25, 460, 734, 35);
/*      */           
/* 6555 */           this.g2.setColor(Color.WHITE);
/* 6556 */           fuente = new Font("Dialog", 0, 7);
/* 6557 */           this.g2.setFont(fuente);
/* 6558 */           this.g2.drawString("TOTAL EN LETRA", 695, 458);
/*      */           
/* 6560 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 6562 */           Finiquitos.this.numLetra = new NumerosALetras(TOTAL, "MXN");
/* 6563 */           subtitulo();
/* 6564 */           totalL = "  (" + Finiquitos.this.numLetra.regresaNumero() + ")";
/* 6565 */           this.g2.drawString(totalL, Finiquitos.this.alinearDer(680, totalL.length()), 490);
/* 6566 */           this.g2.drawString(Finiquitos.this.jLabel21.getText(), Finiquitos.this.alinearDer(720, Finiquitos.this.jLabel21.getText().length()), 475);
/*      */           
/* 6568 */           this.g2.drawRect(25, 500, 734, 10);
/* 6569 */           this.g2.drawRect(25, 510, 734, 50);
/* 6570 */           this.g2.drawLine(460, 500, 460, 560);
/* 6571 */           this.g2.drawLine(610, 500, 610, 560);
/*      */           
/* 6573 */           fuente = new Font("Dialog", 1, 9);
/* 6574 */           this.g2.setFont(fuente);
/* 6575 */           this.g2.drawString("Firma y Huellas del Trabajador", 175, 508);
/* 6576 */           this.g2.drawString("Firma de Testigos", 494, 508);
/* 6577 */           this.g2.drawString("Firma de Autorizado", 642, 508);
/*      */           
/* 6579 */           fuente = new Font("Dialog", 0, 7);
/* 6580 */           this.g2.setFont(fuente);
/*      */           
/* 6582 */           this.g2.drawString(Finiquitos.this.jTextField6.getText(), 727, 570);
/* 6583 */           return 0;
/* 6584 */       }  return 1; }
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 6588 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 6589 */       job.setPrintable(this);
/*      */       
/* 6591 */       PageFormat pf = job.defaultPage();
/* 6592 */       Paper papel = pf.getPaper();
/* 6593 */       papel.setSize(612.0D, 792.0D);
/* 6594 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 6595 */       pf.setPaper(papel);
/* 6596 */       pf.setOrientation(0);
/* 6597 */       ImprimirFiniquitos im = new ImprimirFiniquitos();
/* 6598 */       job.setPrintable(im, pf);
/* 6599 */       job.defaultPage(pf);
/*      */       
/* 6601 */       boolean ok = job.printDialog();
/* 6602 */       if (ok)
/*      */         try {
/* 6604 */           job.print();
/*      */         }
/* 6606 */         catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirFiniquitos2 implements Printable { String[] DATOS; int opc;
/*      */     Graphics2D g2;
/*      */     NumerosALetras letras;
/*      */     
/*      */     public ImprimirFiniquitos2() {
/* 6613 */       this.DATOS = new String[] { "Datos1", "Datos2", "Datos3", "Datos4", "Datos5", "Datos6", "Datos7", "Datos8", "Datos9", "Datos10", "Datos11", "Datos12", "Datos13" };
/* 6614 */       this.opc = 0;
/* 6615 */       this.g2 = null;
/* 6616 */       this.letras = null;
/*      */     } public void titulo() {
/* 6618 */       Font fuente = new Font("Dialog", 1, 11);
/* 6619 */       this.g2.setFont(fuente);
/*      */     }
/*      */     public void subtitulo() {
/* 6622 */       Font fuente = new Font("Dialog", 1, 9);
/* 6623 */       this.g2.setFont(fuente);
/*      */     }
/*      */     public void contenido() {
/* 6626 */       Font fuente = new Font("Dialog", 0, 9);
/* 6627 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/* 6630 */     public String dameMes(String mes) { String mesLetra = "";
/* 6631 */       if (mes.equals("01")) {
/* 6632 */         mesLetra = "Enero";
/*      */       }
/* 6634 */       else if (mes.equals("02")) {
/* 6635 */         mesLetra = "Febrero";
/*      */       }
/* 6637 */       else if (mes.equals("03")) {
/* 6638 */         mesLetra = "Marzo";
/*      */       }
/* 6640 */       else if (mes.equals("04")) {
/* 6641 */         mesLetra = "Abril";
/*      */       }
/* 6643 */       else if (mes.equals("05")) {
/* 6644 */         mesLetra = "Mayo";
/*      */       }
/* 6646 */       else if (mes.equals("06")) {
/* 6647 */         mesLetra = "Junio";
/*      */       }
/* 6649 */       else if (mes.equals("07")) {
/* 6650 */         mesLetra = "Julio";
/*      */       }
/* 6652 */       else if (mes.equals("08")) {
/* 6653 */         mesLetra = "Agosto";
/*      */       }
/* 6655 */       else if (mes.equals("09")) {
/* 6656 */         mesLetra = "Septiembre";
/*      */       }
/* 6658 */       else if (mes.equals("10")) {
/* 6659 */         mesLetra = "Octubre";
/*      */       }
/* 6661 */       else if (mes.equals("11")) {
/* 6662 */         mesLetra = "Noviembre";
/*      */       }
/* 6664 */       else if (mes.equals("12")) {
/* 6665 */         mesLetra = "Diciembre";
/*      */       } 
/* 6667 */       return mesLetra; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen; Image img; SimpleDateFormat formato; String cadenaFecha1, año, mes, dia, mesLetra; ImageIcon tmpIcon; String datos[], domicilio; int y; double sumas, TOTAL; int i;
/*      */       boolean entra;
/*      */       String totalL;
/* 6670 */       this.g2 = (Graphics2D)g;
/* 6671 */       f.setOrientation(0);
/* 6672 */       switch (pageIndex) {
/*      */         case 0:
/* 6674 */           fuente = new Font("Dialog", 0, 8);
/* 6675 */           this.g2.setFont(fuente);
/* 6676 */           this.g2.setColor(Color.BLACK);
/* 6677 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 6678 */           img = imagen.getImage();
/* 6679 */           this.g2.drawImage(img, 690, 17, 60, 60, null);
/*      */           
/* 6681 */           fuente = new Font("Times New Roman", 1, 16);
/* 6682 */           this.g2.setFont(fuente);
/* 6683 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 225, 30);
/* 6684 */           fuente = new Font("Dialog", 0, 11);
/* 6685 */           this.g2.setFont(fuente);
/* 6686 */           this.g2.drawString("AUTOPISTA MONTERREY CADEREYTA KM 32.5, C.P. 67450", 240, 44);
/* 6687 */           this.g2.drawString("CADEREYTA JIMENEZ, NUEVO LEÓN", 298, 58);
/*      */           
/* 6689 */           fuente = new Font("Dialog", 1, 13);
/* 6690 */           this.g2.setFont(fuente);
/* 6691 */           this.g2.drawString("FINIQUITO", 360, 76);
/* 6692 */           this.g2.drawLine(25, 78, 760, 78);
/*      */           
/* 6694 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 6695 */           cadenaFecha1 = formato.format(new Date());
/*      */           
/* 6697 */           año = cadenaFecha1.substring(0, 4);
/* 6698 */           mes = cadenaFecha1.substring(4, 6);
/* 6699 */           dia = cadenaFecha1.substring(6, 8);
/* 6700 */           mesLetra = dameMes(mes);
/*      */           
/* 6702 */           fuente = new Font("Dialog", 0, 11);
/* 6703 */           this.g2.setFont(fuente);
/* 6704 */           this.g2.drawString("IMPRESIÓN:", 50, 76);
/* 6705 */           this.g2.drawString("BASE:", 580, 76);
/*      */           
/* 6707 */           fuente = new Font("Dialog", 1, 11);
/* 6708 */           this.g2.setFont(fuente);
/* 6709 */           this.g2.drawString(dia + "/" + dia + "/" + mesLetra, 125, 76);
/* 6710 */           this.g2.drawString(Finiquitos.this.base, 630, 76);
/*      */ 
/*      */           
/* 6713 */           this.g2.setColor(new Color(56, 93, 138));
/* 6714 */           this.g2.drawRoundRect(25, 110, 57, 71, 10, 10);
/*      */           
/* 6716 */           tmpIcon = null;
/* 6717 */           if (Finiquitos.this.jRadioButton1.isSelected()) {
/* 6718 */             tmpIcon = new ImageIcon(Finiquitos.this.CONFIG[0] + "/" + Finiquitos.this.CONFIG[0] + ".png");
/*      */           } else {
/*      */             
/* 6721 */             tmpIcon = new ImageIcon(Finiquitos.this.CONFIG[1] + "/" + Finiquitos.this.CONFIG[1] + ".png");
/*      */           } 
/*      */           
/* 6724 */           img = tmpIcon.getImage();
/* 6725 */           this.g2.drawImage(img, 27, 113, 53, 65, null);
/*      */           
/* 6727 */           datos = Finiquitos.this.con.regresaReg("calle,num,col,cp,ciudad", "operadores", "where num_ope=" + Finiquitos.this.CLAVE, 5);
/* 6728 */           domicilio = "";
/* 6729 */           if (!datos[0].equals("")) {
/* 6730 */             domicilio = "CALLE " + datos[0];
/*      */           }
/* 6732 */           if (!datos[1].equals("")) {
/* 6733 */             domicilio = domicilio + ", NÚM. " + domicilio;
/*      */           }
/* 6735 */           if (!datos[2].equals("")) {
/* 6736 */             domicilio = domicilio + ", COL. " + domicilio;
/*      */           }
/* 6738 */           if (!datos[3].equals("")) {
/* 6739 */             domicilio = domicilio + ", C.P. " + domicilio;
/*      */           }
/* 6741 */           if (!datos[4].equals("")) {
/* 6742 */             domicilio = domicilio + ", CIUDAD " + domicilio;
/*      */           }
/*      */           
/* 6745 */           this.g2.setColor(Color.BLACK);
/* 6746 */           contenido();
/* 6747 */           this.g2.drawString("CVE EMP: ", 25, 90);
/* 6748 */           this.g2.drawString("NOMBRE: ", 110, 90);
/* 6749 */           this.g2.drawString("DOMICILIO: ", 103, 102);
/*      */           
/* 6751 */           subtitulo();
/* 6752 */           this.g2.drawString(Finiquitos.this.CLAVE, 70, 90);
/* 6753 */           this.g2.drawString(Finiquitos.this.jTextField5.getText(), 155, 90);
/* 6754 */           this.g2.drawString(domicilio, 155, 102);
/*      */           
/* 6756 */           this.g2.drawRoundRect(95, 108, 250, 80, 10, 10);
/* 6757 */           this.g2.drawRoundRect(362, 108, 190, 80, 10, 10);
/* 6758 */           this.g2.drawRoundRect(570, 108, 190, 80, 10, 10);
/*      */           
/* 6760 */           this.g2.drawLine(95, 118, 345, 118);
/* 6761 */           this.g2.drawLine(362, 118, 552, 118);
/* 6762 */           this.g2.drawLine(570, 118, 760, 118);
/*      */           
/* 6764 */           fuente = new Font("Dialog", 0, 6);
/* 6765 */           this.g2.setFont(fuente);
/* 6766 */           this.g2.drawString("Información del Reporte", 190, 115);
/* 6767 */           this.g2.drawString("Información de Vacaciones", 419, 115);
/* 6768 */           this.g2.drawString("Información del Aguinaldo", 630, 115);
/*      */           
/* 6770 */           contenido();
/* 6771 */           this.g2.drawString("DEPARTAMENTO: ", 105, 132);
/* 6772 */           this.g2.drawString("INGRESO: ", 105, 147);
/* 6773 */           this.g2.drawString("FECHA DEL FINIQUITO: ", 105, 162);
/*      */           
/* 6775 */           this.g2.drawString("PERIODO: ", 372, 132);
/* 6776 */           this.g2.drawString("FECHA DE INICIO: ", 372, 147);
/* 6777 */           this.g2.drawString("FECHA FINAL: ", 372, 162);
/* 6778 */           this.g2.drawString("DÍAS: ", 372, 177);
/*      */           
/* 6780 */           this.g2.drawString("FECHA DE INICIO:", 580, 132);
/* 6781 */           this.g2.drawString("FECHA FINAL:", 580, 147);
/* 6782 */           this.g2.drawString("DÍAS:", 580, 162);
/*      */           
/* 6784 */           subtitulo();
/* 6785 */           this.g2.drawString(String.valueOf(Finiquitos.this.jComboBox6.getSelectedItem()), 213, 132);
/* 6786 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 6787 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser9.getDate());
/* 6788 */           año = cadenaFecha1.substring(0, 4);
/* 6789 */           mes = cadenaFecha1.substring(4, 6);
/* 6790 */           dia = cadenaFecha1.substring(6, 8);
/* 6791 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 213, 147);
/*      */           
/* 6793 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser10.getDate());
/* 6794 */           año = cadenaFecha1.substring(0, 4);
/* 6795 */           mes = cadenaFecha1.substring(4, 6);
/* 6796 */           dia = cadenaFecha1.substring(6, 8);
/* 6797 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 213, 162);
/*      */ 
/*      */           
/* 6800 */           this.g2.drawString(String.valueOf(Finiquitos.this.jComboBox5.getSelectedItem()), 460, 132);
/* 6801 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser7.getDate());
/* 6802 */           año = cadenaFecha1.substring(0, 4);
/* 6803 */           mes = cadenaFecha1.substring(4, 6);
/* 6804 */           dia = cadenaFecha1.substring(6, 8);
/* 6805 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 460, 147);
/*      */           
/* 6807 */           cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser8.getDate());
/* 6808 */           año = cadenaFecha1.substring(0, 4);
/* 6809 */           mes = cadenaFecha1.substring(4, 6);
/* 6810 */           dia = cadenaFecha1.substring(6, 8);
/* 6811 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 460, 162);
/* 6812 */           this.g2.drawString(Finiquitos.this.jTextField4.getText(), 460, 177);
/*      */ 
/*      */           
/* 6815 */           if (Finiquitos.this.jDateChooser11.getDate() == null) {
/* 6816 */             this.g2.drawString("-----", 670, 132);
/* 6817 */             this.g2.drawString("-----", 670, 147);
/*      */           } else {
/*      */             
/* 6820 */             cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser11.getDate());
/* 6821 */             año = cadenaFecha1.substring(0, 4);
/* 6822 */             mes = cadenaFecha1.substring(4, 6);
/* 6823 */             dia = cadenaFecha1.substring(6, 8);
/* 6824 */             this.g2.drawString(dia + "/" + dia + "/" + mes, 670, 132);
/*      */             
/* 6826 */             cadenaFecha1 = formato.format(Finiquitos.this.jDateChooser12.getDate());
/* 6827 */             año = cadenaFecha1.substring(0, 4);
/* 6828 */             mes = cadenaFecha1.substring(4, 6);
/* 6829 */             dia = cadenaFecha1.substring(6, 8);
/* 6830 */             this.g2.drawString(dia + "/" + dia + "/" + mes, 670, 147);
/*      */           } 
/* 6832 */           this.g2.drawString(Finiquitos.this.jTextField7.getText(), 670, 162);
/*      */           
/* 6834 */           fuente = new Font("Dialog", 2, 8);
/* 6835 */           this.g2.setFont(fuente);
/* 6836 */           this.g2.setColor(new Color(204, 0, 0));
/* 6837 */           this.g2.fillRect(25, 192, 735, 10);
/* 6838 */           this.g2.drawRect(25, 202, 734, 25);
/* 6839 */           this.g2.drawLine(155, 193, 155, 227);
/* 6840 */           this.g2.drawLine(235, 193, 235, 227);
/* 6841 */           this.g2.drawLine(315, 193, 315, 227);
/* 6842 */           this.g2.drawLine(395, 193, 395, 227);
/* 6843 */           this.g2.drawLine(475, 193, 475, 227);
/* 6844 */           this.g2.drawLine(555, 193, 555, 227);
/* 6845 */           this.g2.drawLine(635, 193, 635, 227);
/* 6846 */           this.g2.setColor(Color.BLACK);
/* 6847 */           this.g2.drawString("CONCEPTO", 70, 218);
/* 6848 */           this.g2.drawString("DÍAS POR LEY", 170, 218);
/* 6849 */           this.g2.drawString("DÍAS DEL AÑO", 247, 218);
/* 6850 */           this.g2.drawString("FACTOR EN DÍAS", 320, 218);
/* 6851 */           this.g2.drawString("DÍAS C/DERECHO", 400, 218);
/* 6852 */           this.g2.drawString("SUBTOTAL", 495, 212);
/* 6853 */           this.g2.drawString("EN DÍAS", 500, 224);
/* 6854 */           this.g2.drawString("SALARIO DIARIO", 562, 218);
/* 6855 */           this.g2.drawString("IMPORTE", 672, 218);
/*      */           
/* 6857 */           subtitulo();
/* 6858 */           y = 239;
/* 6859 */           sumas = 0.0D;
/* 6860 */           TOTAL = 0.0D;
/* 6861 */           for (i = 0; i < Finiquitos.this.jTable2.getRowCount(); i++) {
/* 6862 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(i, 0)), 27, y);
/* 6863 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(i, 1)), 195, y);
/* 6864 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(i, 2)), 268, y);
/* 6865 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(i, 3)), 343, y);
/* 6866 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(i, 4)), Finiquitos.this.alinearDer(440, Finiquitos.this.jTable2.getValueAt(i, 4).toString().length()), y);
/* 6867 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(i, 5)), Finiquitos.this.alinearDer(532, Finiquitos.this.jTable2.getValueAt(i, 5).toString().length()), y);
/* 6868 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(i, 6)), 577, y);
/* 6869 */             this.g2.drawString(String.valueOf(Finiquitos.this.jTable2.getValueAt(i, 7)), Finiquitos.this.alinearDer(720, Finiquitos.this.jTable2.getValueAt(i, 7).toString().length()), y);
/*      */             
/* 6871 */             String canti = String.valueOf(Finiquitos.this.jTable2.getValueAt(i, 7));
/* 6872 */             String valorP = "";
/* 6873 */             for (int j = 0; j < canti.length(); j++) {
/* 6874 */               if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 6875 */                 valorP = valorP + valorP;
/*      */               }
/*      */             } 
/* 6878 */             sumas += Double.parseDouble(valorP);
/* 6879 */             y += 14;
/*      */           } 
/* 6881 */           TOTAL = sumas;
/* 6882 */           this.g2.setColor(Color.WHITE);
/* 6883 */           fuente = new Font("Dialog", 1, 8);
/* 6884 */           this.g2.setFont(fuente);
/* 6885 */           this.g2.drawString("CÁLCULO DEL FINIQUITO", 340, 200);
/*      */           
/* 6887 */           this.g2.setColor(Color.BLACK);
/* 6888 */           subtitulo();
/* 6889 */           Finiquitos.this.cantidad.setValue(Double.valueOf(sumas));
/* 6890 */           this.g2.drawString(Finiquitos.this.cantidad.getText(), Finiquitos.this.alinearDer(720, Finiquitos.this.cantidad.getText().length()), y);
/*      */           
/* 6892 */           contenido();
/* 6893 */           this.g2.drawString("__________________", 640, y - 10);
/* 6894 */           this.g2.drawString("__________________", 640, y - 11);
/* 6895 */           this.g2.drawString("SUBTOTAL FINIQUITO", 515, y);
/*      */           
/* 6897 */           this.g2.setColor(new Color(204, 0, 0));
/* 6898 */           this.g2.fillRect(25, 325, 735, 10);
/* 6899 */           this.g2.drawRect(25, 335, 734, 25);
/* 6900 */           this.g2.drawLine(70, 326, 70, 360);
/* 6901 */           this.g2.drawLine(635, 326, 635, 360);
/*      */           
/* 6903 */           this.g2.setColor(Color.BLACK);
/* 6904 */           fuente = new Font("Dialog", 2, 8);
/* 6905 */           this.g2.setFont(fuente);
/* 6906 */           this.g2.drawString("NÚM", 35, 351);
/* 6907 */           this.g2.drawString("CONCEPTO", 340, 351);
/* 6908 */           this.g2.drawString("IMPORTE", 672, 351);
/*      */           
/* 6910 */           this.g2.setColor(Color.WHITE);
/* 6911 */           fuente = new Font("Dialog", 1, 8);
/* 6912 */           this.g2.setFont(fuente);
/* 6913 */           this.g2.drawString("DESCUENTOS", 358, 333);
/* 6914 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 6916 */           subtitulo();
/* 6917 */           y = 372;
/* 6918 */           sumas = 0.0D;
/* 6919 */           entra = false;
/* 6920 */           if (Finiquitos.this.jTable5.getRowCount() > 0) {
/* 6921 */             for (int j = 0; j < Finiquitos.this.jTable5.getRowCount(); j++) {
/* 6922 */               this.g2.drawString("" + j + 1, 45, y);
/* 6923 */               this.g2.drawString(String.valueOf(Finiquitos.this.jTable5.getValueAt(j, 0)), 75, y);
/* 6924 */               this.g2.drawString(String.valueOf(Finiquitos.this.jTable5.getValueAt(j, 1)), Finiquitos.this.alinearDer(720, Finiquitos.this.jTable5.getValueAt(j, 1).toString().length()), y);
/*      */               
/* 6926 */               String canti = String.valueOf(Finiquitos.this.jTable5.getValueAt(j, 1));
/* 6927 */               String valorP = "";
/* 6928 */               for (int k = 0; k < canti.length(); k++) {
/* 6929 */                 if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 6930 */                   valorP = valorP + valorP;
/*      */                 }
/*      */               } 
/* 6933 */               sumas += Double.parseDouble(valorP);
/* 6934 */               y += 14;
/* 6935 */               entra = true;
/*      */             } 
/*      */           } else {
/*      */             
/* 6939 */             this.g2.drawString("NO SE REGISTRARON DESCUENTOS PARA ESTE CÁLCULO...", 30, y);
/*      */           } 
/* 6941 */           if (entra) {
/* 6942 */             y -= 14;
/*      */           }
/* 6944 */           TOTAL -= sumas;
/* 6945 */           contenido();
/* 6946 */           Finiquitos.this.cantidad.setValue(Double.valueOf(sumas));
/* 6947 */           this.g2.drawString("__________________", 640, y + 2);
/* 6948 */           this.g2.drawString("__________________", 640, y + 3);
/* 6949 */           this.g2.drawString("SUBTOTAL DESCUENTOS", 515, y + 13);
/*      */           
/* 6951 */           subtitulo();
/* 6952 */           this.g2.drawString(Finiquitos.this.cantidad.getText(), Finiquitos.this.alinearDer(720, Finiquitos.this.cantidad.getText().length()), y + 13);
/*      */           
/* 6954 */           this.g2.setColor(new Color(204, 0, 0));
/* 6955 */           this.g2.fillRect(690, 450, 70, 10);
/* 6956 */           this.g2.drawRect(25, 460, 734, 35);
/*      */           
/* 6958 */           this.g2.setColor(Color.WHITE);
/* 6959 */           fuente = new Font("Dialog", 0, 7);
/* 6960 */           this.g2.setFont(fuente);
/* 6961 */           this.g2.drawString("TOTAL EN LETRA", 695, 458);
/*      */           
/* 6963 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 6965 */           Finiquitos.this.numLetra = new NumerosALetras(TOTAL, "MXN");
/* 6966 */           subtitulo();
/* 6967 */           totalL = "  (" + Finiquitos.this.numLetra.regresaNumero() + ")";
/* 6968 */           this.g2.drawString(totalL, Finiquitos.this.alinearDer(680, totalL.length()), 490);
/* 6969 */           this.g2.drawString(Finiquitos.this.jLabel21.getText(), Finiquitos.this.alinearDer(720, Finiquitos.this.jLabel21.getText().length()), 475);
/*      */           
/* 6971 */           this.g2.drawRect(25, 500, 734, 10);
/* 6972 */           this.g2.drawRect(25, 510, 734, 50);
/* 6973 */           this.g2.drawLine(460, 500, 460, 560);
/* 6974 */           this.g2.drawLine(610, 500, 610, 560);
/*      */           
/* 6976 */           fuente = new Font("Dialog", 1, 9);
/* 6977 */           this.g2.setFont(fuente);
/* 6978 */           this.g2.drawString("Firma y Huellas del Trabajador", 175, 508);
/* 6979 */           this.g2.drawString("Firma de Testigos", 494, 508);
/* 6980 */           this.g2.drawString("Firma de Autorizado", 642, 508);
/*      */           
/* 6982 */           fuente = new Font("Dialog", 0, 7);
/* 6983 */           this.g2.setFont(fuente);
/*      */           
/* 6985 */           this.g2.drawString(Finiquitos.this.jTextField6.getText(), 727, 570);
/* 6986 */           return 0;
/* 6987 */       }  return 1; }
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 6991 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 6992 */       job.setPrintable(this);
/*      */       
/* 6994 */       PageFormat pf = job.defaultPage();
/* 6995 */       Paper papel = pf.getPaper();
/* 6996 */       papel.setSize(612.0D, 792.0D);
/* 6997 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 6998 */       pf.setPaper(papel);
/* 6999 */       pf.setOrientation(0);
/* 7000 */       ImprimirFiniquitos2 im = new ImprimirFiniquitos2();
/* 7001 */       job.setPrintable(im, pf);
/* 7002 */       job.defaultPage(pf);
/*      */       
/* 7004 */       boolean ok = job.printDialog();
/* 7005 */       if (ok)
/*      */         try {
/* 7007 */           job.print();
/*      */         }
/* 7009 */         catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Finiquitos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */