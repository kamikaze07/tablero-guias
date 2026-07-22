/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
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
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
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
/*      */ public class Vacaciones extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   40 */   Date fechaActual = new Date();
/*   41 */   Date fechaInicio = null;
/*   42 */   Date fecha = new Date();
/*   43 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   44 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   45 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   46 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   47 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   48 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   49 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   50 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   51 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   52 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   53 */   JFrame padre = null;
/*   54 */   JTabbedPane fichas = null;
/*   55 */   String[] CLAVES = null;
/*   56 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*   58 */   DefaultTableModel modelo = new DefaultTableModel();
/*   59 */   CeldaRender celda = new CeldaRender();
/*   60 */   CeldaRender2 celda2 = new CeldaRender2();
/*   61 */   CeldaRender3 celda3 = new CeldaRender3();
/*   62 */   String[] CLAVESOP = null;
/*   63 */   String[] CLAVESEM = null;
/*   64 */   String[] NOMBRESOP = null;
/*   65 */   String[] NOMBRESEM = null;
/*   66 */   String[] DATOS = null;
/*      */   boolean ACTIVO = false;
/*   68 */   double TOTAL1 = 0.0D;
/*   69 */   double TOTAL2 = 0.0D;
/*   70 */   NumerosALetras numLetra = null;
/*   71 */   int DIAS = 0;
/*   72 */   String DIRECTIVA = "";
/*   73 */   String CLAVE = "";
/*   74 */   String base = ""; EscribirReporte esc; private ButtonGroup buttonGroup1; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton3; private JButton jButton33; private JButton jButton34; private JButton jButton35; private JButton jButton36; private JButton jButton4; private JButton jButton44; private JButton jButton45; private JButton jButton7; private JButton jButton8; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JDateChooser jDateChooser10;
/*   75 */   String[] CONFIG = null; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser7; private JDateChooser jDateChooser8; private JDateChooser jDateChooser9; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel116; private JLabel jLabel117; private JLabel jLabel118; private JLabel jLabel119; private JLabel jLabel12; private JLabel jLabel120; private JLabel jLabel121; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21;
/*      */   
/*      */   public Vacaciones(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*   78 */     String año = "2010";
/*   79 */     String mes = "10";
/*   80 */     String dia = "10";
/*   81 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   82 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   84 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   85 */     } catch (ParseException ex) {
/*   86 */       ex.printStackTrace();
/*      */     } 
/*   88 */     this.padre = padre;
/*   89 */     fichas = fichas;
/*   90 */     initComponents();
/*   91 */     this.USUARIO = USUARIO;
/*   92 */     panelito.setViewportView(this);
/*   93 */     this.panel = panelito;
/*   94 */     colorear();
/*      */     
/*   96 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*   97 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   98 */     this.jLabel5.setCursor(micursor);
/*   99 */     this.jLabel6.setCursor(micursor);
/*  100 */     this.jLabel7.setCursor(micursor);
/*  101 */     llenarCombos();
/*      */     
/*  103 */     this.buttonGroup1.add(this.jRadioButton1);
/*  104 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*  106 */     int w = this.tama.width;
/*  107 */     int h = this.tama.height;
/*  108 */     int rw = (w - 920) / 2;
/*  109 */     int rh = (h - 630) / 2;
/*  110 */     this.jDialog1.setLocation(rw, rh);
/*  111 */     this.jDialog1.setSize(920, 630);
/*  112 */     this.jDialog1.setResizable(false);
/*  113 */     this.jDialog1.setVisible(false);
/*      */     
/*  115 */     rw = (w - 807) / 2;
/*  116 */     rh = (h - 393) / 2;
/*  117 */     this.jDialog2.setLocation(rw, rh);
/*  118 */     this.jDialog2.setSize(807, 393);
/*  119 */     this.jDialog2.setVisible(false);
/*  120 */     this.jDialog2.setResizable(false);
/*      */     
/*  122 */     rw = (w - 570) / 2;
/*  123 */     rh = (h - 175) / 2;
/*  124 */     this.jDialog3.setLocation(rw, rh);
/*  125 */     this.jDialog3.setSize(570, 175);
/*  126 */     this.jDialog3.setVisible(false);
/*  127 */     this.jDialog3.setResizable(false);
/*      */     
/*  129 */     rw = (w - 570) / 2;
/*  130 */     rh = (h - 175) / 2;
/*  131 */     this.jDialog4.setLocation(rw, rh);
/*  132 */     this.jDialog4.setSize(570, 175);
/*  133 */     this.jDialog4.setVisible(false);
/*  134 */     this.jDialog4.setResizable(false);
/*      */     
/*  136 */     rw = (w - 390) / 2;
/*  137 */     rh = (h - 230) / 2;
/*  138 */     this.jDialog5.setLocation(rw, rh);
/*  139 */     this.jDialog5.setSize(390, 230);
/*  140 */     this.jDialog5.setVisible(false);
/*  141 */     this.jDialog5.setResizable(false);
/*      */     
/*  143 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  144 */     Cursor micursor2 = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  145 */     this.jDialog1.setCursor(micursor2);
/*  146 */     this.jDialog2.setCursor(micursor2);
/*  147 */     this.jDialog3.setCursor(micursor2);
/*  148 */     this.jDialog4.setCursor(micursor2);
/*      */     
/*  150 */     deshabilitar();
/*      */     
/*  152 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  153 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  154 */     editFormat.setGroupingUsed(false);
/*  155 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  156 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  157 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  158 */     enFormat.setAllowsInvalid(true);
/*  159 */     this.cantidad.setFormatterFactory(currFactory);
/*  160 */     this.jFormattedTextField3.setFormatterFactory(currFactory);
/*  161 */     this.jFormattedTextField4.setFormatterFactory(currFactory);
/*  162 */     this.cantidad.setValue(Integer.valueOf(0));
/*  163 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*  164 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/*      */     
/*  166 */     this.con.consultar("directiva", "configuraciones", "");
/*  167 */     this.DIRECTIVA = this.con.Campo;
/*      */     
/*  169 */     consultar2();
/*  170 */     this.con.consultar("sucursal", "configuraciones", "");
/*  171 */     this.base = this.con.Campo;
/*  172 */     this.CONFIG = this.con.regresaReg("fotosEmpleados,fotosOperadores", "configuraciones", "", 2);
/*      */   }
/*      */   private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel3; private JLabel jLabel4; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel54; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel36; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JScrollPane jScrollPane1; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JSeparator jSeparator1; private JSeparator jSeparator2; private JSeparator jSeparator24; private JSeparator jSeparator25; private JSeparator jSeparator26; private JSeparator jSeparator27; private JSeparator jSeparator29; private JSeparator jSeparator8; private JTabbedPane jTabbedPane1; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTable jTable4; private JTable jTable5; private JTable jTable6; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField2; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6;
/*      */   private JTextField jTextField9;
/*      */   
/*      */   private void initComponents() {
/*  178 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  179 */     this.jPanel3 = new JPanel();
/*  180 */     this.jLabel3 = new JLabel();
/*  181 */     this.jSeparator1 = new JSeparator();
/*  182 */     this.jRadioButton1 = new JRadioButton();
/*  183 */     this.jRadioButton2 = new JRadioButton();
/*  184 */     this.jLabel8 = new JLabel();
/*  185 */     this.jPanel4 = new JPanel();
/*  186 */     this.jLabel9 = new JLabel();
/*  187 */     this.jComboBox5 = new JComboBox();
/*  188 */     this.jLabel10 = new JLabel();
/*  189 */     this.jComboBox6 = new JComboBox();
/*  190 */     this.jLabel11 = new JLabel();
/*  191 */     this.jDateChooser7 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  192 */     this.jLabel12 = new JLabel();
/*  193 */     this.jDateChooser8 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  194 */     this.jTextField4 = new JTextField();
/*  195 */     this.jLabel24 = new JLabel();
/*  196 */     this.jButton13 = new JButton();
/*  197 */     this.jTabbedPane1 = new JTabbedPane();
/*  198 */     this.jPanel6 = new JPanel();
/*  199 */     this.jScrollPane1 = new JScrollPane();
/*  200 */     this.jTable1 = new JTable();
/*  201 */     this.jLabel16 = new JLabel();
/*  202 */     this.jLabel18 = new JLabel();
/*  203 */     this.jLabel19 = new JLabel();
/*  204 */     this.jScrollPane4 = new JScrollPane();
/*  205 */     this.jTable4 = new JTable();
/*  206 */     this.jButton7 = new JButton();
/*  207 */     this.jButton8 = new JButton();
/*  208 */     this.jPanel7 = new JPanel();
/*  209 */     this.jPanel9 = new JPanel();
/*  210 */     this.jScrollPane2 = new JScrollPane();
/*  211 */     this.jTable2 = new JTable();
/*  212 */     this.jLabel17 = new JLabel();
/*  213 */     this.jLabel20 = new JLabel();
/*  214 */     this.jLabel21 = new JLabel();
/*  215 */     this.jScrollPane5 = new JScrollPane();
/*  216 */     this.jTable5 = new JTable();
/*  217 */     this.jButton10 = new JButton();
/*  218 */     this.jButton11 = new JButton();
/*  219 */     this.jLabel13 = new JLabel();
/*  220 */     this.jTextField3 = new JTextField();
/*  221 */     this.jSeparator2 = new JSeparator();
/*  222 */     this.jButton3 = new JButton();
/*  223 */     this.jButton4 = new JButton();
/*  224 */     this.jDateChooser9 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  225 */     this.jLabel14 = new JLabel();
/*  226 */     this.jTextField5 = new JTextField();
/*  227 */     this.jButton12 = new JButton();
/*  228 */     this.jLabel22 = new JLabel();
/*  229 */     this.jTextField6 = new JTextField();
/*  230 */     this.jLabel23 = new JLabel();
/*  231 */     this.jDateChooser10 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  232 */     this.buttonGroup1 = new ButtonGroup();
/*  233 */     this.jPanel8 = new JPanel();
/*  234 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  235 */     this.jPanel10 = new JPanel();
/*  236 */     this.jLabel60 = new JLabel();
/*  237 */     this.jPanel36 = new JPanel();
/*  238 */     this.jScrollPane6 = new JScrollPane();
/*  239 */     this.jTable6 = new JTable();
/*  240 */     this.jButton20 = new JButton();
/*  241 */     this.jButton21 = new JButton();
/*  242 */     this.jLabel61 = new JLabel();
/*  243 */     this.jTextField9 = new JTextField();
/*  244 */     this.jLabel62 = new JLabel();
/*  245 */     this.jTextField10 = new JTextField();
/*  246 */     this.jLabel63 = new JLabel();
/*  247 */     this.jComboBox7 = new JComboBox();
/*  248 */     this.jLabel64 = new JLabel();
/*  249 */     this.jComboBox8 = new JComboBox();
/*  250 */     this.jSeparator8 = new JSeparator();
/*  251 */     this.cantidad = new JFormattedTextField();
/*  252 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  253 */     this.jPanel31 = new JPanel();
/*  254 */     this.jLabel116 = new JLabel();
/*  255 */     this.jSeparator24 = new JSeparator();
/*  256 */     this.jLabel118 = new JLabel();
/*  257 */     this.jTextField27 = new JTextField();
/*  258 */     this.jLabel119 = new JLabel();
/*  259 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  260 */     this.jSeparator25 = new JSeparator();
/*  261 */     this.jButton33 = new JButton();
/*  262 */     this.jButton34 = new JButton();
/*  263 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  264 */     this.jPanel32 = new JPanel();
/*  265 */     this.jLabel117 = new JLabel();
/*  266 */     this.jSeparator26 = new JSeparator();
/*  267 */     this.jLabel120 = new JLabel();
/*  268 */     this.jTextField28 = new JTextField();
/*  269 */     this.jLabel121 = new JLabel();
/*  270 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  271 */     this.jSeparator27 = new JSeparator();
/*  272 */     this.jButton35 = new JButton();
/*  273 */     this.jButton36 = new JButton();
/*  274 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  275 */     this.jPanel29 = new JPanel();
/*  276 */     this.jLabel124 = new JLabel();
/*  277 */     this.jSeparator29 = new JSeparator();
/*  278 */     this.jLabel125 = new JLabel();
/*  279 */     this.jButton44 = new JButton();
/*  280 */     this.jButton45 = new JButton();
/*  281 */     this.jScrollPane18 = new JScrollPane();
/*  282 */     this.jTextArea5 = new JTextArea();
/*  283 */     this.jLabel126 = new JLabel();
/*  284 */     this.jPanel1 = new JPanel();
/*  285 */     this.jLabel54 = new JLabel();
/*  286 */     this.jPanel5 = new JPanel();
/*  287 */     this.jLabel48 = new JLabel();
/*  288 */     this.jScrollPane3 = new JScrollPane();
/*  289 */     this.jTable3 = new JTable();
/*  290 */     this.jButton23 = new JButton();
/*  291 */     this.jButton24 = new JButton();
/*  292 */     this.jButton25 = new JButton();
/*  293 */     this.jButton26 = new JButton();
/*  294 */     this.jButton2 = new JButton();
/*  295 */     this.jButton27 = new JButton();
/*  296 */     this.jButton28 = new JButton();
/*  297 */     this.jPanel17 = new JPanel();
/*  298 */     this.jTextField1 = new JTextField();
/*  299 */     this.jLabel15 = new JLabel();
/*  300 */     this.jComboBox1 = new JComboBox();
/*  301 */     this.jLabel46 = new JLabel();
/*  302 */     this.jTextField2 = new JTextField();
/*  303 */     this.jLabel2 = new JLabel();
/*  304 */     this.jComboBox2 = new JComboBox();
/*  305 */     this.jLabel47 = new JLabel();
/*  306 */     this.jComboBox3 = new JComboBox();
/*  307 */     this.jLabel49 = new JLabel();
/*  308 */     this.jPanel2 = new JPanel();
/*  309 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  310 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  311 */     this.jLabel5 = new JLabel();
/*  312 */     this.jLabel6 = new JLabel();
/*  313 */     this.jLabel7 = new JLabel();
/*  314 */     this.jLabel1 = new JLabel();
/*  315 */     this.jLabel4 = new JLabel();
/*  316 */     this.jButton1 = new JButton();
/*      */     
/*  318 */     this.jDialog1.setTitle("Pago de Vacaciones");
/*  319 */     this.jDialog1.setModal(true);
/*      */     
/*  321 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*      */     
/*  323 */     this.jLabel3.setFont(new Font("Tahoma", 1, 15));
/*  324 */     this.jLabel3.setHorizontalAlignment(0);
/*  325 */     this.jLabel3.setText("VACACIONES");
/*      */     
/*  327 */     this.jRadioButton1.setSelected(true);
/*  328 */     this.jRadioButton1.setText("Administrativos");
/*  329 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  331 */             Vacaciones.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  335 */     this.jRadioButton2.setText("Operadores");
/*  336 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  338 */             Vacaciones.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  342 */     this.jLabel8.setHorizontalAlignment(4);
/*  343 */     this.jLabel8.setText("Trabajador:");
/*      */     
/*  345 */     this.jPanel4.setBackground(new Color(255, 255, 255));
/*  346 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder("Información del reporte"));
/*      */     
/*  348 */     this.jLabel9.setText("Selecciona el periodo:");
/*      */     
/*  350 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  351 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "1 AÑO (12 Días)", "2 AÑOS (14 Días)", "3 AÑOS (16 Días)", "4 AÑOS (18 Días)", "5 AÑOS (20 Días)", "6 AÑOS (22 Días)", "7 AÑOS (22Días)", "8 AÑOS (22 Días)", "9 AÑOS (22 Días)", "10 AÑOS (22 Días)", "11 AÑOS (24 Días)", "12 AÑOS (24 Días)", "13 AÑOS (24 Días)", "14 AÑOS (24 Días)", "15 AÑOS (24 Días)", "16 AÑOS (26 Días)", "17 AÑOS (26 Días)", "18 AÑOS (26 Días)", "19 AÑOS (26 Días)", "20 AÑOS (26 Días)", "21 AÑOS (28 Días)", "22 AÑOS (28 Días)", "23 AÑOS (28 Días)", "24 AÑOS (28 Días)", "25 AÑOS (28 Días)", "26 AÑOS (30 Días)", "27 AÑOS (30 Días)", "28 AÑOS (30 Días)", "29 AÑOS (30 Días)", "30 AÑOS (30 Días)", "31 AÑOS (32 Días)", "32 AÑOS (32 Días)", "33 AÑOS (32 Días)", "34 AÑOS (32 Días)", "35 AÑOS (32 Días)", "36 AÑOS (34 Días)", "37 AÑOS (34 Días)", "38 AÑOS (34 Días)", "39 AÑOS (34 Días)", "40 AÑOS (34 Días)" }));
/*  352 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  354 */             Vacaciones.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  358 */     this.jLabel10.setHorizontalAlignment(4);
/*  359 */     this.jLabel10.setText("Departamento");
/*      */     
/*  361 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*      */     
/*  363 */     this.jLabel11.setText("Fecha de inicio");
/*      */     
/*  365 */     this.jDateChooser7.setDate(this.fechaActual);
/*  366 */     this.jDateChooser7.setDateFormatString("dd/MM/yyyy");
/*  367 */     this.jDateChooser7.setIcon(this.icon);
/*  368 */     this.jDateChooser7.setMinSelectableDate(new Date(631177262000L));
/*      */     
/*  370 */     this.jLabel12.setHorizontalAlignment(4);
/*  371 */     this.jLabel12.setText("Fecha final");
/*      */     
/*  373 */     this.jDateChooser8.setDate(this.fechaActual);
/*  374 */     this.jDateChooser8.setDateFormatString("dd/MM/yyyy");
/*  375 */     this.jDateChooser8.setIcon(this.icon);
/*  376 */     this.jDateChooser8.setMinSelectableDate(new Date(631177262000L));
/*      */     
/*  378 */     this.jTextField4.setHorizontalAlignment(0);
/*  379 */     this.jTextField4.setEnabled(false);
/*      */     
/*  381 */     this.jLabel24.setText("Días");
/*      */     
/*  383 */     this.jButton13.setMnemonic('L');
/*  384 */     this.jButton13.setText("Calcular");
/*  385 */     this.jButton13.setToolTipText("Calcular Días (Alt+L)");
/*  386 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  388 */             Vacaciones.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  392 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  393 */     this.jPanel4.setLayout(jPanel4Layout);
/*  394 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  395 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  396 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  397 */           .addContainerGap()
/*  398 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  399 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  400 */               .addComponent(this.jLabel11, -1, -1, 32767)
/*  401 */               .addGap(18, 18, 18))
/*  402 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  403 */               .addComponent(this.jLabel9, -2, 133, -2)
/*  404 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)))
/*  405 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  406 */             .addComponent(this.jComboBox5, -2, 164, -2)
/*  407 */             .addComponent((Component)this.jDateChooser7, -2, 141, -2))
/*  408 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  409 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  410 */             .addComponent(this.jLabel12)
/*  411 */             .addComponent(this.jLabel10, -2, 111, -2))
/*  412 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  413 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  414 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  415 */               .addComponent((Component)this.jDateChooser8, -2, 141, -2)
/*  416 */               .addGap(48, 48, 48)
/*  417 */               .addComponent(this.jLabel24)
/*  418 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  419 */               .addComponent(this.jTextField4, -2, 74, -2)
/*  420 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  421 */               .addComponent(this.jButton13, -2, 89, -2))
/*  422 */             .addComponent(this.jComboBox6, -2, 169, -2))
/*  423 */           .addContainerGap()));
/*      */     
/*  425 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  426 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  427 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  428 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  429 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  430 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  431 */                 .addComponent(this.jLabel9)
/*  432 */                 .addComponent(this.jLabel10)
/*  433 */                 .addComponent(this.jComboBox6, -2, -1, -2))
/*  434 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  435 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  436 */                 .addComponent(this.jLabel12, -1, 25, 32767)
/*  437 */                 .addComponent(this.jLabel11, -1, 25, 32767)
/*  438 */                 .addComponent((Component)this.jDateChooser8, -1, 25, 32767)
/*  439 */                 .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  440 */                   .addComponent(this.jTextField4, -2, -1, -2)
/*  441 */                   .addComponent(this.jLabel24)
/*  442 */                   .addComponent(this.jButton13))))
/*  443 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  444 */               .addComponent(this.jComboBox5, -2, -1, -2)
/*  445 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  446 */               .addComponent((Component)this.jDateChooser7, -1, 25, 32767)))
/*  447 */           .addContainerGap()));
/*      */ 
/*      */     
/*  450 */     this.jTabbedPane1.setTabPlacement(3);
/*      */     
/*  452 */     this.jPanel6.setBackground(new Color(255, 255, 255));
/*      */     
/*  454 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null },  }, (Object[])new String[] { "Concepto", "Días Ley", "Días del Año", "Factor en Días", "SubTotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  463 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  468 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  471 */     this.jScrollPane1.setViewportView(this.jTable1);
/*  472 */     if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/*  473 */       this.jTable1.getColumnModel().getColumn(1).setMinWidth(80);
/*  474 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
/*  475 */       this.jTable1.getColumnModel().getColumn(2).setMinWidth(80);
/*  476 */       this.jTable1.getColumnModel().getColumn(2).setMaxWidth(80);
/*  477 */       this.jTable1.getColumnModel().getColumn(3).setMinWidth(110);
/*  478 */       this.jTable1.getColumnModel().getColumn(3).setMaxWidth(110);
/*      */     } 
/*      */     
/*  481 */     this.jLabel16.setText("Cálculo Básico:");
/*      */     
/*  483 */     this.jLabel18.setText("- Descuentos");
/*      */     
/*  485 */     this.jLabel19.setFont(new Font("Tahoma", 1, 15));
/*  486 */     this.jLabel19.setHorizontalAlignment(4);
/*  487 */     this.jLabel19.setText("$0.0");
/*      */     
/*  489 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  497 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  502 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  505 */     this.jScrollPane4.setViewportView(this.jTable4);
/*  506 */     if (this.jTable4.getColumnModel().getColumnCount() > 0) {
/*  507 */       this.jTable4.getColumnModel().getColumn(0).setMinWidth(60);
/*  508 */       this.jTable4.getColumnModel().getColumn(0).setMaxWidth(60);
/*  509 */       this.jTable4.getColumnModel().getColumn(2).setMinWidth(100);
/*  510 */       this.jTable4.getColumnModel().getColumn(2).setMaxWidth(100);
/*      */     } 
/*      */     
/*  513 */     this.jButton7.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/eliminar.png")));
/*  514 */     this.jButton7.setToolTipText("Eliminar");
/*  515 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  517 */             Vacaciones.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  521 */     this.jButton8.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/agregar (2).png")));
/*  522 */     this.jButton8.setToolTipText("Agregar");
/*  523 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  525 */             Vacaciones.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  529 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  530 */     this.jPanel6.setLayout(jPanel6Layout);
/*  531 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  532 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  533 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/*  534 */           .addContainerGap()
/*  535 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  536 */             .addComponent(this.jScrollPane4, GroupLayout.Alignment.LEADING, -1, 826, 32767)
/*  537 */             .addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 842, 32767)
/*  538 */             .addComponent(this.jLabel19, -2, 140, -2)
/*  539 */             .addComponent(this.jLabel16, GroupLayout.Alignment.LEADING, -2, 152, -2)
/*  540 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  541 */               .addComponent(this.jLabel18, -2, 152, -2)
/*  542 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 568, 32767)
/*  543 */               .addComponent(this.jButton8, -2, 58, -2)
/*  544 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  545 */               .addComponent(this.jButton7, -2, 58, -2)))
/*  546 */           .addContainerGap()));
/*      */     
/*  548 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  549 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  550 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  551 */           .addComponent(this.jLabel16)
/*  552 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  553 */           .addComponent(this.jScrollPane1, -2, 83, -2)
/*  554 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  555 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  556 */             .addComponent(this.jLabel18)
/*  557 */             .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  558 */               .addComponent(this.jButton7)
/*  559 */               .addComponent(this.jButton8)))
/*  560 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  561 */           .addComponent(this.jScrollPane4, -1, 124, 32767)
/*  562 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  563 */           .addComponent(this.jLabel19)
/*  564 */           .addGap(8, 8, 8)));
/*      */ 
/*      */     
/*  567 */     this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/*      */     
/*  569 */     this.jPanel9.setBackground(new Color(255, 255, 255));
/*      */     
/*  571 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null },  }, (Object[])new String[] { "Concepto", "Días Ley", "Días del Año", "Factor en Días", "SubTotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  580 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  585 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  588 */     this.jScrollPane2.setViewportView(this.jTable2);
/*  589 */     if (this.jTable2.getColumnModel().getColumnCount() > 0) {
/*  590 */       this.jTable2.getColumnModel().getColumn(1).setMinWidth(80);
/*  591 */       this.jTable2.getColumnModel().getColumn(1).setMaxWidth(80);
/*  592 */       this.jTable2.getColumnModel().getColumn(2).setMinWidth(80);
/*  593 */       this.jTable2.getColumnModel().getColumn(2).setMaxWidth(80);
/*      */     } 
/*      */     
/*  596 */     this.jLabel17.setText("Cálculo Básico:");
/*      */     
/*  598 */     this.jLabel20.setText("- Descuentos");
/*      */     
/*  600 */     this.jLabel21.setFont(new Font("Tahoma", 1, 15));
/*  601 */     this.jLabel21.setHorizontalAlignment(4);
/*  602 */     this.jLabel21.setText("$0.0");
/*      */     
/*  604 */     this.jTable5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  612 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  617 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  620 */     this.jScrollPane5.setViewportView(this.jTable5);
/*  621 */     if (this.jTable5.getColumnModel().getColumnCount() > 0) {
/*  622 */       this.jTable5.getColumnModel().getColumn(0).setMinWidth(60);
/*  623 */       this.jTable5.getColumnModel().getColumn(0).setMaxWidth(60);
/*  624 */       this.jTable5.getColumnModel().getColumn(2).setMinWidth(100);
/*  625 */       this.jTable5.getColumnModel().getColumn(2).setMaxWidth(100);
/*      */     } 
/*      */     
/*  628 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/eliminar.png")));
/*  629 */     this.jButton10.setToolTipText("Eliminar");
/*  630 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  632 */             Vacaciones.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  636 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/agregar (2).png")));
/*  637 */     this.jButton11.setToolTipText("Agregar");
/*  638 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  640 */             Vacaciones.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  644 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  645 */     this.jPanel9.setLayout(jPanel9Layout);
/*  646 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  647 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  648 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  649 */           .addContainerGap()
/*  650 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  651 */             .addComponent(this.jScrollPane5, GroupLayout.Alignment.LEADING, -1, 826, 32767)
/*  652 */             .addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 842, 32767)
/*  653 */             .addComponent(this.jLabel21, -2, 140, -2)
/*  654 */             .addComponent(this.jLabel17, GroupLayout.Alignment.LEADING, -2, 152, -2)
/*  655 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  656 */               .addComponent(this.jLabel20, -2, 152, -2)
/*  657 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 568, 32767)
/*  658 */               .addComponent(this.jButton11, -2, 58, -2)
/*  659 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  660 */               .addComponent(this.jButton10, -2, 58, -2)))
/*  661 */           .addContainerGap()));
/*      */     
/*  663 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  664 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  665 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  666 */           .addComponent(this.jLabel17)
/*  667 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  668 */           .addComponent(this.jScrollPane2, -2, 83, -2)
/*  669 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  670 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  671 */             .addComponent(this.jLabel20)
/*  672 */             .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  673 */               .addComponent(this.jButton10)
/*  674 */               .addComponent(this.jButton11)))
/*  675 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  676 */           .addComponent(this.jScrollPane5, -1, 121, 32767)
/*  677 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  678 */           .addComponent(this.jLabel21)
/*  679 */           .addGap(11, 11, 11)));
/*      */ 
/*      */     
/*  682 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  683 */     this.jPanel7.setLayout(jPanel7Layout);
/*  684 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  685 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  686 */         .addGap(0, 846, 32767)
/*  687 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  688 */           .addComponent(this.jPanel9, -1, -1, 32767)));
/*      */     
/*  690 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  691 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  692 */         .addGap(0, 297, 32767)
/*  693 */         .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  694 */           .addComponent(this.jPanel9, -1, -1, 32767)));
/*      */ 
/*      */     
/*  697 */     this.jTabbedPane1.addTab("Imss", this.jPanel7);
/*      */     
/*  699 */     this.jLabel13.setFont(new Font("Tahoma", 1, 15));
/*  700 */     this.jLabel13.setHorizontalAlignment(4);
/*  701 */     this.jLabel13.setText("$0.0");
/*      */     
/*  703 */     this.jTextField3.setEditable(false);
/*  704 */     this.jTextField3.setFont(new Font("Tahoma", 1, 15));
/*  705 */     this.jTextField3.setText("Cero pesos  M.N.");
/*      */     
/*  707 */     this.jButton3.setText("Cerrar");
/*  708 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  710 */             Vacaciones.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  714 */     this.jButton4.setText("Guardar");
/*  715 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  717 */             Vacaciones.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  721 */     this.jDateChooser9.setDate(this.fechaActual);
/*  722 */     this.jDateChooser9.setDateFormatString("dd/MM/yyyy");
/*  723 */     this.jDateChooser9.setEnabled(false);
/*  724 */     this.jDateChooser9.setIcon(this.icon);
/*  725 */     this.jDateChooser9.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/*  727 */     this.jLabel14.setText("Fecha de Ingreso:");
/*      */     
/*  729 */     this.jTextField5.setEditable(false);
/*      */     
/*  731 */     this.jButton12.setMnemonic('B');
/*  732 */     this.jButton12.setText("Buscar");
/*  733 */     this.jButton12.setToolTipText("Buscar (Alt+B)");
/*  734 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  736 */             Vacaciones.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  740 */     this.jLabel22.setHorizontalAlignment(4);
/*  741 */     this.jLabel22.setText("Folio:");
/*      */     
/*  743 */     this.jTextField6.setFont(new Font("Tahoma", 1, 11));
/*  744 */     this.jTextField6.setEnabled(false);
/*      */     
/*  746 */     this.jLabel23.setHorizontalAlignment(4);
/*  747 */     this.jLabel23.setText("Fecha:");
/*      */     
/*  749 */     this.jDateChooser10.setDate(this.fechaActual);
/*  750 */     this.jDateChooser10.setDateFormatString("dd/MM/yyyy");
/*  751 */     this.jDateChooser10.setEnabled(false);
/*  752 */     this.jDateChooser10.setIcon(this.icon);
/*  753 */     this.jDateChooser10.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/*  755 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  756 */     this.jPanel3.setLayout(jPanel3Layout);
/*  757 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  758 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  759 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  760 */           .addContainerGap()
/*  761 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  762 */             .addComponent(this.jSeparator1)
/*  763 */             .addComponent(this.jPanel4, -1, -1, 32767)
/*  764 */             .addComponent(this.jTabbedPane1, 0, 0, 32767)
/*  765 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  766 */               .addGap(10, 10, 10)
/*  767 */               .addComponent(this.jRadioButton1, -2, 129, -2)
/*  768 */               .addGap(8, 8, 8)
/*  769 */               .addComponent(this.jRadioButton2, -2, 129, -2)
/*  770 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  771 */               .addComponent(this.jLabel8, -2, 72, -2)
/*  772 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  773 */               .addComponent(this.jTextField5, -2, 234, -2)
/*  774 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  775 */               .addComponent(this.jButton12)
/*  776 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  777 */               .addComponent(this.jLabel14, -1, -1, 32767)
/*  778 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  779 */               .addComponent((Component)this.jDateChooser9, -2, 92, -2))
/*  780 */             .addComponent(this.jSeparator2)
/*  781 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  782 */               .addComponent(this.jTextField3)
/*  783 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  784 */               .addComponent(this.jLabel13, -2, 127, -2)
/*  785 */               .addGap(13, 13, 13))
/*  786 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  787 */               .addComponent(this.jButton4, -2, 97, -2)
/*  788 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  789 */               .addComponent(this.jButton3, -2, 97, -2))
/*  790 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  791 */               .addComponent(this.jLabel22, -2, 54, -2)
/*  792 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  793 */               .addComponent(this.jTextField6, -2, 145, -2)
/*  794 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  795 */               .addComponent(this.jLabel3, -1, -1, 32767)
/*  796 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  797 */               .addComponent(this.jLabel23, -2, 57, -2)
/*  798 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  799 */               .addComponent((Component)this.jDateChooser10, -2, 92, -2)))
/*  800 */           .addContainerGap()));
/*      */     
/*  802 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  803 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  804 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  805 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  806 */             .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  807 */               .addComponent(this.jLabel3)
/*  808 */               .addComponent(this.jTextField6, -2, -1, -2)
/*  809 */               .addComponent(this.jLabel22)
/*  810 */               .addComponent(this.jLabel23))
/*  811 */             .addComponent((Component)this.jDateChooser10, -2, -1, -2))
/*  812 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  813 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  814 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  815 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  816 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  817 */               .addComponent(this.jRadioButton2, -1, 30, 32767)
/*  818 */               .addComponent(this.jLabel8)
/*  819 */               .addComponent(this.jLabel14)
/*  820 */               .addComponent(this.jTextField5, -2, -1, -2)
/*  821 */               .addComponent(this.jButton12)
/*  822 */               .addComponent(this.jRadioButton1, -2, 28, -2))
/*  823 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  824 */               .addGap(12, 12, 12)
/*  825 */               .addComponent((Component)this.jDateChooser9, -2, -1, -2)))
/*  826 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  827 */           .addComponent(this.jPanel4, -2, -1, -2)
/*  828 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  829 */           .addComponent(this.jTabbedPane1, -2, 325, -2)
/*  830 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  831 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  832 */             .addComponent(this.jLabel13, -1, 38, 32767)
/*  833 */             .addComponent(this.jTextField3, -2, -1, -2))
/*  834 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  835 */           .addComponent(this.jSeparator2, -2, 10, -2)
/*  836 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  837 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  838 */             .addComponent(this.jButton3)
/*  839 */             .addComponent(this.jButton4))
/*  840 */           .addContainerGap()));
/*      */ 
/*      */     
/*  843 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  844 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  845 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  846 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  847 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/*  849 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  850 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  851 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */ 
/*      */     
/*  854 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  855 */     this.jPanel8.setLayout(jPanel8Layout);
/*  856 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  857 */         .createParallelGroup(GroupLayout.Alignment.LEADING));
/*      */     
/*  859 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  860 */         .createParallelGroup(GroupLayout.Alignment.LEADING));
/*      */ 
/*      */     
/*  863 */     this.jDialog2.setTitle("Búsqueda de Operadores");
/*  864 */     this.jDialog2.setModal(true);
/*      */     
/*  866 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*      */     
/*  868 */     this.jLabel60.setFont(new Font("Tahoma", 1, 16));
/*  869 */     this.jLabel60.setForeground(new Color(0, 102, 102));
/*  870 */     this.jLabel60.setHorizontalAlignment(0);
/*  871 */     this.jLabel60.setText("Busqueda de Empleados");
/*      */     
/*  873 */     this.jPanel36.setBackground(new Color(146, 193, 134));
/*  874 */     this.jPanel36.setBorder(BorderFactory.createTitledBorder(null, "Listado de Empleados", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  876 */     this.jTable6.setFont(new Font("Tahoma", 0, 10));
/*  877 */     this.jTable6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Departamentos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  885 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  890 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  893 */     this.jTable6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  895 */             Vacaciones.this.jTable6MouseClicked(evt);
/*      */           }
/*      */         });
/*  898 */     this.jScrollPane6.setViewportView(this.jTable6);
/*      */     
/*  900 */     this.jButton20.setMnemonic('A');
/*  901 */     this.jButton20.setText("Asignar");
/*  902 */     this.jButton20.setToolTipText("Asignar (Alt+A)");
/*  903 */     this.jButton20.setEnabled(false);
/*  904 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  906 */             Vacaciones.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  910 */     this.jButton21.setMnemonic('C');
/*  911 */     this.jButton21.setText("Cerrar");
/*  912 */     this.jButton21.setToolTipText("Cerrar (Alt+C)");
/*  913 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  915 */             Vacaciones.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  919 */     this.jLabel61.setFont(new Font("Tahoma", 2, 11));
/*  920 */     this.jLabel61.setForeground(new Color(15, 87, 51));
/*  921 */     this.jLabel61.setHorizontalAlignment(4);
/*  922 */     this.jLabel61.setText("Clave");
/*      */     
/*  924 */     this.jTextField9.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  926 */             Vacaciones.this.jTextField9KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  930 */     this.jLabel62.setFont(new Font("Tahoma", 2, 11));
/*  931 */     this.jLabel62.setForeground(new Color(15, 87, 51));
/*  932 */     this.jLabel62.setHorizontalAlignment(4);
/*  933 */     this.jLabel62.setText("Nombre");
/*      */     
/*  935 */     this.jTextField10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  937 */             Vacaciones.this.jTextField10ActionPerformed(evt);
/*      */           }
/*      */         });
/*  940 */     this.jTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  942 */             Vacaciones.this.jTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  946 */     this.jLabel63.setFont(new Font("Tahoma", 2, 11));
/*  947 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/*  948 */     this.jLabel63.setHorizontalAlignment(4);
/*  949 */     this.jLabel63.setText("Tipo");
/*      */     
/*  951 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/*  952 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "TRABAJADOR", "FUNCIONARIO", "TODOS" }));
/*  953 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  955 */             Vacaciones.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  959 */     this.jLabel64.setFont(new Font("Tahoma", 2, 11));
/*  960 */     this.jLabel64.setForeground(new Color(15, 87, 51));
/*  961 */     this.jLabel64.setHorizontalAlignment(4);
/*  962 */     this.jLabel64.setText("Depto");
/*      */     
/*  964 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/*  965 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "TRABAJADOR", "FUNCIONARIO", "TODOS" }));
/*  966 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  968 */             Vacaciones.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  972 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/*  973 */     this.jPanel36.setLayout(jPanel36Layout);
/*  974 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/*  975 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  976 */         .addGroup(jPanel36Layout.createSequentialGroup()
/*  977 */           .addContainerGap()
/*  978 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  979 */             .addComponent(this.jScrollPane6, -1, 693, 32767)
/*  980 */             .addGroup(jPanel36Layout.createSequentialGroup()
/*  981 */               .addComponent(this.jLabel61, -2, 32, -2)
/*  982 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  983 */               .addComponent(this.jTextField9, -2, 46, -2)
/*  984 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  985 */               .addComponent(this.jLabel62, -2, 46, -2)
/*  986 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  987 */               .addComponent(this.jTextField10, -2, 148, -2)
/*  988 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  989 */               .addComponent(this.jLabel63, -2, 37, -2)
/*  990 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  991 */               .addComponent(this.jComboBox7, -2, 162, -2)
/*  992 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  993 */               .addComponent(this.jLabel64, -2, 38, -2)
/*  994 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  995 */               .addComponent(this.jComboBox8, -2, 156, -2))
/*  996 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/*  997 */               .addComponent(this.jButton20, -2, 92, -2)
/*  998 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  999 */               .addComponent(this.jButton21, -2, 83, -2)))
/* 1000 */           .addContainerGap()));
/*      */     
/* 1002 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 1003 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1004 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 1005 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1006 */             .addComponent(this.jLabel61)
/* 1007 */             .addComponent(this.jTextField9, -2, -1, -2)
/* 1008 */             .addComponent(this.jLabel62)
/* 1009 */             .addComponent(this.jTextField10, -2, -1, -2)
/* 1010 */             .addComponent(this.jLabel63)
/* 1011 */             .addComponent(this.jComboBox7, -2, -1, -2)
/* 1012 */             .addComponent(this.jLabel64)
/* 1013 */             .addComponent(this.jComboBox8, -2, -1, -2))
/* 1014 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1015 */           .addComponent(this.jScrollPane6, -1, 210, 32767)
/* 1016 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1017 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1018 */             .addComponent(this.jButton21)
/* 1019 */             .addComponent(this.jButton20))
/* 1020 */           .addGap(13, 13, 13)));
/*      */ 
/*      */     
/* 1023 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1024 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1025 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1026 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1027 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1028 */           .addContainerGap()
/* 1029 */           .addComponent(this.jSeparator8, -1, 723, 32767)
/* 1030 */           .addContainerGap())
/* 1031 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1032 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/* 1033 */             .addGap(8, 8, 8)
/* 1034 */             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1035 */               .addComponent(this.jPanel36, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1036 */               .addComponent(this.jLabel60, GroupLayout.Alignment.LEADING, -1, 725, 32767))
/* 1037 */             .addGap(10, 10, 10))));
/*      */     
/* 1039 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1040 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1041 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1042 */           .addGap(31, 31, 31)
/* 1043 */           .addComponent(this.jSeparator8, -2, 10, -2)
/* 1044 */           .addContainerGap(322, 32767))
/* 1045 */         .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1046 */           .addGroup(jPanel10Layout.createSequentialGroup()
/* 1047 */             .addContainerGap()
/* 1048 */             .addComponent(this.jLabel60)
/* 1049 */             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1050 */             .addComponent(this.jPanel36, -2, -1, -2)
/* 1051 */             .addContainerGap(-1, 32767))));
/*      */ 
/*      */     
/* 1054 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1055 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1056 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1057 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1058 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */     
/* 1060 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1061 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1062 */         .addComponent(this.jPanel10, -1, -1, 32767));
/*      */ 
/*      */     
/* 1065 */     this.cantidad.setText("jFormattedTextField1");
/*      */     
/* 1067 */     this.jDialog3.setTitle("Agrega conceptos");
/*      */     
/* 1069 */     this.jPanel31.setBackground(new Color(255, 255, 255));
/*      */     
/* 1071 */     this.jLabel116.setFont(new Font("Times New Roman", 1, 14));
/* 1072 */     this.jLabel116.setHorizontalAlignment(0);
/* 1073 */     this.jLabel116.setText("Coloca el descuento");
/*      */     
/* 1075 */     this.jLabel118.setFont(new Font("Tahoma", 1, 11));
/* 1076 */     this.jLabel118.setHorizontalAlignment(0);
/* 1077 */     this.jLabel118.setText("Concepto");
/*      */     
/* 1079 */     this.jLabel119.setFont(new Font("Tahoma", 1, 11));
/* 1080 */     this.jLabel119.setHorizontalAlignment(0);
/* 1081 */     this.jLabel119.setText("P Unitario");
/*      */     
/* 1083 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/*      */     
/* 1085 */     this.jButton33.setMnemonic('C');
/* 1086 */     this.jButton33.setText("Cerrar");
/* 1087 */     this.jButton33.setToolTipText("Cerrar (Alt+C)");
/* 1088 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1090 */             Vacaciones.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1094 */     this.jButton34.setMnemonic('A');
/* 1095 */     this.jButton34.setText("Agregar");
/* 1096 */     this.jButton34.setToolTipText("Agregar (Alt+A)");
/* 1097 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1099 */             Vacaciones.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1103 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 1104 */     this.jPanel31.setLayout(jPanel31Layout);
/* 1105 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 1106 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1107 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
/* 1108 */           .addContainerGap()
/* 1109 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1110 */             .addComponent(this.jLabel116, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1111 */             .addComponent(this.jSeparator24, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1112 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel31Layout.createSequentialGroup()
/* 1113 */               .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1114 */                 .addComponent(this.jTextField27, GroupLayout.Alignment.LEADING, -1, 432, 32767)
/* 1115 */                 .addComponent(this.jLabel118, GroupLayout.Alignment.LEADING, -1, 432, 32767))
/* 1116 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1117 */               .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1118 */                 .addComponent(this.jFormattedTextField3, 0, 0, 32767)
/* 1119 */                 .addComponent(this.jLabel119, -2, 97, -2)))
/* 1120 */             .addComponent(this.jSeparator25, -1, 535, 32767)
/* 1121 */             .addGroup(jPanel31Layout.createSequentialGroup()
/* 1122 */               .addComponent(this.jButton34, -2, 83, -2)
/* 1123 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1124 */               .addComponent(this.jButton33, -2, 83, -2)))
/* 1125 */           .addContainerGap()));
/*      */     
/* 1127 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 1128 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1129 */         .addGroup(jPanel31Layout.createSequentialGroup()
/* 1130 */           .addComponent(this.jLabel116)
/* 1131 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1132 */           .addComponent(this.jSeparator24, -2, 10, -2)
/* 1133 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1134 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1135 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
/* 1136 */               .addComponent(this.jLabel118)
/* 1137 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1138 */               .addComponent(this.jTextField27, -2, -1, -2))
/* 1139 */             .addGroup(jPanel31Layout.createSequentialGroup()
/* 1140 */               .addComponent(this.jLabel119)
/* 1141 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1142 */               .addComponent(this.jFormattedTextField3, -2, -1, -2)))
/* 1143 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1144 */           .addComponent(this.jSeparator25, -2, 10, -2)
/* 1145 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1146 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1147 */             .addComponent(this.jButton33)
/* 1148 */             .addComponent(this.jButton34))
/* 1149 */           .addContainerGap(22, 32767)));
/*      */ 
/*      */     
/* 1152 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1153 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1154 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1155 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1156 */         .addComponent(this.jPanel31, -2, -1, -2));
/*      */     
/* 1158 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1159 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1160 */         .addComponent(this.jPanel31, -2, -1, -2));
/*      */ 
/*      */     
/* 1163 */     this.jDialog4.setTitle("Agrega conceptos");
/*      */     
/* 1165 */     this.jPanel32.setBackground(new Color(255, 255, 255));
/*      */     
/* 1167 */     this.jLabel117.setFont(new Font("Times New Roman", 1, 14));
/* 1168 */     this.jLabel117.setHorizontalAlignment(0);
/* 1169 */     this.jLabel117.setText("Coloca el descuento");
/*      */     
/* 1171 */     this.jLabel120.setFont(new Font("Tahoma", 1, 11));
/* 1172 */     this.jLabel120.setHorizontalAlignment(0);
/* 1173 */     this.jLabel120.setText("Concepto");
/*      */     
/* 1175 */     this.jLabel121.setFont(new Font("Tahoma", 1, 11));
/* 1176 */     this.jLabel121.setHorizontalAlignment(0);
/* 1177 */     this.jLabel121.setText("P Unitario");
/*      */     
/* 1179 */     this.jFormattedTextField4.setHorizontalAlignment(4);
/*      */     
/* 1181 */     this.jButton35.setMnemonic('C');
/* 1182 */     this.jButton35.setText("Cerrar");
/* 1183 */     this.jButton35.setToolTipText("Cerrar (Alt+C)");
/* 1184 */     this.jButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1186 */             Vacaciones.this.jButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1190 */     this.jButton36.setMnemonic('A');
/* 1191 */     this.jButton36.setText("Agregar");
/* 1192 */     this.jButton36.setToolTipText("Agregar (Alt+A)");
/* 1193 */     this.jButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1195 */             Vacaciones.this.jButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1199 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/* 1200 */     this.jPanel32.setLayout(jPanel32Layout);
/* 1201 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/* 1202 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1203 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 1204 */           .addContainerGap()
/* 1205 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1206 */             .addComponent(this.jLabel117, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1207 */             .addComponent(this.jSeparator26, GroupLayout.Alignment.LEADING, -1, 535, 32767)
/* 1208 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel32Layout.createSequentialGroup()
/* 1209 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1210 */                 .addComponent(this.jTextField28, GroupLayout.Alignment.LEADING, -1, 432, 32767)
/* 1211 */                 .addComponent(this.jLabel120, GroupLayout.Alignment.LEADING, -1, 432, 32767))
/* 1212 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1213 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1214 */                 .addComponent(this.jFormattedTextField4, 0, 0, 32767)
/* 1215 */                 .addComponent(this.jLabel121, -2, 97, -2)))
/* 1216 */             .addComponent(this.jSeparator27, -1, 535, 32767)
/* 1217 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 1218 */               .addComponent(this.jButton36, -2, 83, -2)
/* 1219 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1220 */               .addComponent(this.jButton35, -2, 83, -2)))
/* 1221 */           .addContainerGap()));
/*      */     
/* 1223 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/* 1224 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1225 */         .addGroup(jPanel32Layout.createSequentialGroup()
/* 1226 */           .addComponent(this.jLabel117)
/* 1227 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1228 */           .addComponent(this.jSeparator26, -2, 10, -2)
/* 1229 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1230 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1231 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 1232 */               .addComponent(this.jLabel120)
/* 1233 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1234 */               .addComponent(this.jTextField28, -2, -1, -2))
/* 1235 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 1236 */               .addComponent(this.jLabel121)
/* 1237 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1238 */               .addComponent(this.jFormattedTextField4, -2, -1, -2)))
/* 1239 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1240 */           .addComponent(this.jSeparator27, -2, 10, -2)
/* 1241 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1242 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1243 */             .addComponent(this.jButton35)
/* 1244 */             .addComponent(this.jButton36))
/* 1245 */           .addContainerGap(22, 32767)));
/*      */ 
/*      */     
/* 1248 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1249 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1250 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1251 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1252 */         .addComponent(this.jPanel32, -2, -1, -2));
/*      */     
/* 1254 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1255 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1256 */         .addComponent(this.jPanel32, -2, -1, -2));
/*      */ 
/*      */     
/* 1259 */     this.jDialog5.setTitle("Cancelar Vacaciones");
/* 1260 */     this.jDialog5.setModal(true);
/*      */     
/* 1262 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*      */     
/* 1264 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/* 1265 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/* 1266 */     this.jLabel124.setHorizontalAlignment(0);
/* 1267 */     this.jLabel124.setText("Motivo de la Cancelación");
/*      */     
/* 1269 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/* 1270 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/* 1271 */     this.jLabel125.setHorizontalAlignment(4);
/* 1272 */     this.jLabel125.setText("Motivo");
/*      */     
/* 1274 */     this.jButton44.setMnemonic('A');
/* 1275 */     this.jButton44.setText("Cancelar Vacaciones");
/* 1276 */     this.jButton44.setToolTipText("Cancelar Vacaciones (Alt+A)");
/* 1277 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1279 */             Vacaciones.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1283 */     this.jButton45.setMnemonic('C');
/* 1284 */     this.jButton45.setText("Cerrar");
/* 1285 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 1286 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1288 */             Vacaciones.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1292 */     this.jTextArea5.setColumns(20);
/* 1293 */     this.jTextArea5.setLineWrap(true);
/* 1294 */     this.jTextArea5.setRows(5);
/* 1295 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 1297 */     this.jLabel126.setText("Ingresa el motivo por el cual deseas cancelar el pago de vacaciones");
/*      */     
/* 1299 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1300 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1301 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1302 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1303 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1304 */           .addContainerGap()
/* 1305 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1306 */             .addComponent(this.jLabel126, -1, 349, 32767)
/* 1307 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1308 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 1309 */                 .addComponent(this.jButton44, -2, 153, -2)
/* 1310 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1311 */                 .addComponent(this.jButton45, -2, 84, -2))
/* 1312 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 1313 */                 .addComponent(this.jLabel125, -2, 43, -2)
/* 1314 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1315 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/* 1316 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1317 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1318 */               .addComponent(this.jSeparator29, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/* 1319 */           .addContainerGap()));
/*      */     
/* 1321 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1322 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1323 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1324 */           .addComponent(this.jLabel124)
/* 1325 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1326 */           .addComponent(this.jSeparator29, -2, 10, -2)
/* 1327 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1328 */           .addComponent(this.jLabel126)
/* 1329 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1330 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1331 */             .addComponent(this.jLabel125)
/* 1332 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 1333 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1334 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1335 */             .addComponent(this.jButton45)
/* 1336 */             .addComponent(this.jButton44))
/* 1337 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1340 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1341 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1342 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1343 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1344 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */     
/* 1346 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1347 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1348 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */ 
/*      */     
/* 1351 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 1352 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1354 */     this.jLabel54.setFont(new Font("Times New Roman", 1, 24));
/* 1355 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 1356 */     this.jLabel54.setText("VACACIONES");
/*      */     
/* 1358 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 1359 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1361 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1362 */     this.jLabel48.setForeground(Color.red);
/* 1363 */     this.jLabel48.setHorizontalAlignment(0);
/* 1364 */     this.jLabel48.setText("t");
/* 1365 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1367 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 1368 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Cliente", "Equipo", "Plataforma", "Pozo", "Subtotal", "Iva", "Ret", "Total", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1376 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1378 */             Vacaciones.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1381 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1383 */             Vacaciones.this.jTable3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1386 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/* 1388 */     this.jButton23.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1389 */     this.jButton23.setMnemonic('V');
/* 1390 */     this.jButton23.setText("Ver");
/* 1391 */     this.jButton23.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 1392 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1394 */             Vacaciones.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1398 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1399 */     this.jButton24.setMnemonic('V');
/* 1400 */     this.jButton24.setText("Nueva");
/* 1401 */     this.jButton24.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 1402 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1404 */             Vacaciones.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1408 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1409 */     this.jButton25.setMnemonic('V');
/* 1410 */     this.jButton25.setText("Cancelar");
/* 1411 */     this.jButton25.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 1412 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1414 */             Vacaciones.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1418 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1419 */     this.jButton26.setMnemonic('V');
/* 1420 */     this.jButton26.setText("Guardar Reporte");
/* 1421 */     this.jButton26.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 1422 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1424 */             Vacaciones.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1428 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 1429 */     this.jButton2.setMnemonic('I');
/* 1430 */     this.jButton2.setText("Imprimir");
/* 1431 */     this.jButton2.setToolTipText("Imprimir (Alt+I)");
/* 1432 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1434 */             Vacaciones.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1438 */     this.jButton27.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1439 */     this.jButton27.setMnemonic('V');
/* 1440 */     this.jButton27.setText("Modificar");
/* 1441 */     this.jButton27.setToolTipText("Ver Significados de los Colores (Alt+V)");
/* 1442 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1444 */             Vacaciones.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1448 */     this.jButton28.setMnemonic('R');
/* 1449 */     this.jButton28.setText("Autorizar");
/* 1450 */     this.jButton28.setToolTipText("Autorizar (Alt+R)");
/* 1451 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1453 */             Vacaciones.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1457 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1458 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1459 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1460 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1461 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1462 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 1463 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1464 */           .addComponent(this.jButton24, -2, 119, -2)
/* 1465 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1466 */           .addComponent(this.jButton27, -2, 119, -2)
/* 1467 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1468 */           .addComponent(this.jButton23, -2, 119, -2)
/* 1469 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1470 */           .addComponent(this.jButton25, -2, 119, -2)
/* 1471 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1472 */           .addComponent(this.jButton28, -2, 119, -2)
/* 1473 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1474 */           .addComponent(this.jButton26)
/* 1475 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 139, 32767)
/* 1476 */           .addComponent(this.jButton2, -2, 124, -2))
/* 1477 */         .addComponent(this.jScrollPane3, -1, 1206, 32767));
/*      */     
/* 1479 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1480 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1481 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1482 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1483 */             .addComponent(this.jLabel48)
/* 1484 */             .addComponent(this.jButton24, -2, 28, -2)
/* 1485 */             .addComponent(this.jButton27, -2, 28, -2)
/* 1486 */             .addComponent(this.jButton23, -2, 28, -2)
/* 1487 */             .addComponent(this.jButton25, -2, 28, -2)
/* 1488 */             .addComponent(this.jButton28, -2, 28, -2)
/* 1489 */             .addComponent(this.jButton26, -2, 28, -2)
/* 1490 */             .addComponent(this.jButton2))
/* 1491 */           .addGap(7, 7, 7)
/* 1492 */           .addComponent(this.jScrollPane3, -1, 161, 32767)));
/*      */ 
/*      */     
/* 1495 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 1496 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Vacaciones", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1498 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1500 */             Vacaciones.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1504 */     this.jLabel15.setFont(new Font("Tahoma", 3, 11));
/* 1505 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 1506 */     this.jLabel15.setHorizontalAlignment(0);
/* 1507 */     this.jLabel15.setText("Folio");
/*      */     
/* 1509 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1510 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Pagar>", "<Autorizada>", "<Cancelada>" }));
/* 1511 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1513 */             Vacaciones.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1517 */     this.jLabel46.setFont(new Font("Tahoma", 3, 11));
/* 1518 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 1519 */     this.jLabel46.setHorizontalAlignment(0);
/* 1520 */     this.jLabel46.setText("Estatus");
/*      */     
/* 1522 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1524 */             Vacaciones.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1528 */     this.jLabel2.setFont(new Font("Tahoma", 3, 11));
/* 1529 */     this.jLabel2.setForeground(new Color(15, 87, 51));
/* 1530 */     this.jLabel2.setHorizontalAlignment(0);
/* 1531 */     this.jLabel2.setText("Nombre del Trabajador");
/*      */     
/* 1533 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 1534 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Pagar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 1535 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1537 */             Vacaciones.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1541 */     this.jLabel47.setFont(new Font("Tahoma", 3, 11));
/* 1542 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/* 1543 */     this.jLabel47.setHorizontalAlignment(0);
/* 1544 */     this.jLabel47.setText("Departamento");
/*      */     
/* 1546 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 1547 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Pagar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 1548 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1550 */             Vacaciones.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1554 */     this.jLabel49.setFont(new Font("Tahoma", 3, 11));
/* 1555 */     this.jLabel49.setForeground(new Color(15, 87, 51));
/* 1556 */     this.jLabel49.setHorizontalAlignment(0);
/* 1557 */     this.jLabel49.setText("Responsable");
/*      */     
/* 1559 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 1560 */     this.jPanel17.setLayout(jPanel17Layout);
/* 1561 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 1562 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1563 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1564 */           .addContainerGap()
/* 1565 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1566 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 1567 */             .addComponent(this.jTextField1, -2, 81, -2))
/* 1568 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1569 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1570 */             .addComponent(this.jLabel46, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1571 */             .addComponent(this.jComboBox1, GroupLayout.Alignment.TRAILING, 0, 104, 32767))
/* 1572 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1573 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1574 */             .addComponent(this.jLabel2, -1, -1, 32767)
/* 1575 */             .addComponent(this.jTextField2, -1, 212, 32767))
/* 1576 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1577 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1578 */             .addComponent(this.jLabel47, -1, -1, 32767)
/* 1579 */             .addComponent(this.jComboBox2, 0, 183, 32767))
/* 1580 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1581 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1582 */             .addComponent(this.jComboBox3, 0, -1, 32767)
/* 1583 */             .addComponent(this.jLabel49, -1, 143, 32767))
/* 1584 */           .addContainerGap(449, 32767)));
/*      */     
/* 1586 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 1587 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1588 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1589 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1590 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1591 */               .addComponent(this.jTextField1, -2, -1, -2)
/* 1592 */               .addGap(8, 8, 8)
/* 1593 */               .addComponent(this.jLabel15, -1, -1, 32767))
/* 1594 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1595 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1596 */                 .addComponent(this.jComboBox1, -2, -1, -2)
/* 1597 */                 .addComponent(this.jTextField2, -2, -1, -2))
/* 1598 */               .addGap(8, 8, 8)
/* 1599 */               .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1600 */                 .addComponent(this.jLabel46, -1, -1, 32767)
/* 1601 */                 .addComponent(this.jLabel2)))
/* 1602 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1603 */               .addComponent(this.jComboBox2, -2, -1, -2)
/* 1604 */               .addGap(8, 8, 8)
/* 1605 */               .addComponent(this.jLabel47, -1, -1, 32767))
/* 1606 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1607 */               .addComponent(this.jComboBox3, -2, -1, -2)
/* 1608 */               .addGap(8, 8, 8)
/* 1609 */               .addComponent(this.jLabel49, -1, -1, 32767)))
/* 1610 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1613 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 1614 */     this.jPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 1616 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1617 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 1618 */     this.jDateChooser4.setIcon(this.icon);
/* 1619 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 1620 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1622 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1623 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1624 */     this.jDateChooser5.setIcon(this.icon);
/* 1625 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1627 */     this.jLabel5.setFont(new Font("Tahoma", 2, 12));
/* 1628 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/* 1629 */     this.jLabel5.setText("<html><u>Todos </u></html>");
/* 1630 */     this.jLabel5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1632 */             Vacaciones.this.jLabel5MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1635 */             Vacaciones.this.jLabel5MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1638 */             Vacaciones.this.jLabel5MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1642 */     this.jLabel6.setFont(new Font("Tahoma", 2, 12));
/* 1643 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/* 1644 */     this.jLabel6.setHorizontalAlignment(0);
/* 1645 */     this.jLabel6.setText("<html><u>Hoy</u></html>");
/* 1646 */     this.jLabel6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1648 */             Vacaciones.this.jLabel6MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1651 */             Vacaciones.this.jLabel6MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1654 */             Vacaciones.this.jLabel6MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1658 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/* 1659 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/* 1660 */     this.jLabel7.setText("<html><u>Ayer</u></html>");
/* 1661 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1663 */             Vacaciones.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1666 */             Vacaciones.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1669 */             Vacaciones.this.jLabel7MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1673 */     this.jLabel1.setFont(new Font("Tahoma", 1, 15));
/* 1674 */     this.jLabel1.setForeground(Color.red);
/* 1675 */     this.jLabel1.setHorizontalAlignment(4);
/* 1676 */     this.jLabel1.setText("REPORTE DEL");
/*      */     
/* 1678 */     this.jLabel4.setFont(new Font("Tahoma", 1, 15));
/* 1679 */     this.jLabel4.setForeground(Color.red);
/* 1680 */     this.jLabel4.setHorizontalAlignment(0);
/* 1681 */     this.jLabel4.setText("AL");
/*      */     
/* 1683 */     this.jButton1.setMnemonic('F');
/* 1684 */     this.jButton1.setText("Filtrar");
/* 1685 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 1686 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1688 */             Vacaciones.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1692 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1693 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1694 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1695 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1696 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1697 */           .addContainerGap()
/* 1698 */           .addComponent(this.jLabel1, -2, 130, -2)
/* 1699 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1700 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 1701 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1702 */           .addComponent(this.jLabel4)
/* 1703 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1704 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 1705 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1706 */           .addComponent(this.jButton1)
/* 1707 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1708 */           .addComponent(this.jLabel5, -2, -1, -2)
/* 1709 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1710 */           .addComponent(this.jLabel6, -2, 31, -2)
/* 1711 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1712 */           .addComponent(this.jLabel7, -2, 31, -2)
/* 1713 */           .addContainerGap(21, 32767)));
/*      */     
/* 1715 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1716 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1717 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1718 */           .addContainerGap()
/* 1719 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1720 */             .addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1721 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 1722 */               .addGap(1, 1, 1)
/* 1723 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1724 */                 .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.TRAILING, -2, -1, -2)
/* 1725 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1726 */                   .addComponent(this.jLabel5, -2, 19, -2)
/* 1727 */                   .addComponent(this.jLabel6, -2, 15, -2)
/* 1728 */                   .addComponent(this.jLabel7, -2, -1, -2)
/* 1729 */                   .addComponent(this.jButton1))
/* 1730 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 1731 */                   .addComponent(this.jLabel4, -2, 19, -2)
/* 1732 */                   .addGap(1, 1, 1))
/* 1733 */                 .addComponent((Component)this.jDateChooser5, GroupLayout.Alignment.TRAILING, -2, -1, -2))))));
/*      */ 
/*      */     
/* 1736 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1737 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1738 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1739 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1740 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 1741 */           .addContainerGap()
/* 1742 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1743 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
/* 1744 */               .addComponent(this.jPanel2, -2, -1, -2)
/* 1745 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1746 */               .addComponent(this.jLabel54, -1, -1, 32767))
/* 1747 */             .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1748 */             .addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1749 */           .addContainerGap()));
/*      */     
/* 1751 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1752 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1753 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1754 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1755 */             .addComponent(this.jPanel2, -1, -1, 32767)
/* 1756 */             .addComponent(this.jLabel54, -1, -1, 32767))
/* 1757 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1758 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 1759 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1760 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 1761 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1764 */     GroupLayout layout = new GroupLayout(this);
/* 1765 */     setLayout(layout);
/* 1766 */     layout.setHorizontalGroup(layout
/* 1767 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1768 */         .addGap(0, 1262, 32767)
/* 1769 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1770 */           .addGroup(layout.createSequentialGroup()
/* 1771 */             .addGap(10, 10, 10)
/* 1772 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 1773 */             .addGap(10, 10, 10))));
/*      */     
/* 1775 */     layout.setVerticalGroup(layout
/* 1776 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1777 */         .addGap(0, 374, 32767)
/* 1778 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1779 */           .addGroup(layout.createSequentialGroup()
/* 1780 */             .addGap(9, 9, 9)
/* 1781 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 1782 */             .addGap(10, 10, 10))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 1787 */     if (evt.getClickCount() == 2) {
/* 1788 */       String tipo = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 5));
/* 1789 */       if (tipo.equals("OPERADOR")) {
/* 1790 */         this.jRadioButton2.setSelected(true);
/* 1791 */         this.jTabbedPane1.removeAll();
/* 1792 */         this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */       } else {
/*      */         
/* 1795 */         this.jRadioButton1.setSelected(true);
/* 1796 */         this.jTabbedPane1.removeAll();
/* 1797 */         this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 1798 */         this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */       } 
/* 1800 */       verVacaciones();
/* 1801 */       this.jButton4.setText("Imprimir");
/* 1802 */       this.jButton4.setMnemonic('I');
/* 1803 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTable3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 1815 */     int ind = this.jTable3.getSelectedRow();
/* 1816 */     if (ind < 0) {
/* 1817 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un valor para ver los datos", "Selecciona un formato", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 1820 */       String tipo = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 5));
/* 1821 */       if (tipo.equals("OPERADOR")) {
/* 1822 */         this.jRadioButton2.setSelected(true);
/* 1823 */         this.jTabbedPane1.removeAll();
/* 1824 */         this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */       } else {
/*      */         
/* 1827 */         this.jRadioButton1.setSelected(true);
/* 1828 */         this.jTabbedPane1.removeAll();
/* 1829 */         this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 1830 */         this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */       } 
/* 1832 */       verVacaciones();
/* 1833 */       this.jButton4.setText("Imprimir");
/* 1834 */       this.jButton4.setMnemonic('I');
/* 1835 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 1840 */     this.jRadioButton1.setSelected(true);
/* 1841 */     this.jTabbedPane1.removeAll();
/* 1842 */     this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 1843 */     this.jTabbedPane1.addTab("Imss", this.jPanel9);
/* 1844 */     sacarMayor();
/* 1845 */     deshabilitar();
/* 1846 */     this.jButton4.setText("Guardar");
/* 1847 */     this.jButton4.setMnemonic('G');
/* 1848 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 1852 */     this.jTextArea5.setText("");
/* 1853 */     int ind = this.jTable3.getSelectedRow();
/* 1854 */     if (ind < 0) {
/* 1855 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una valor para modificar los datos", "Selecciona una formato", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 1858 */       String estatus = String.valueOf(this.jTable3.getValueAt(ind, 7));
/* 1859 */       if (!estatus.contains("<Por Pagar>")) {
/* 1860 */         JOptionPane.showMessageDialog(this.padre, "No puedes cancelar el documento porque su estatus no es '<Por Pagar>'", "No se puede cancelar", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 1863 */         this.jDialog5.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 1869 */     String[] datos = { "NÚM", "FOLIO", "FECHA", "EMPLEADO", "PERIODO", "DEPARTAMENTO", "TOTAL", "ESTATUS", "DOCUMENTO" };
/* 1870 */     this.esc = new EscribirReporte("VACACIONES", this.jTable3, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 1874 */     ImprimirDatos imprimir = new ImprimirDatos();
/* 1875 */     imprimir.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1879 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1883 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseClicked(MouseEvent evt) {
/* 1887 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 1888 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1889 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseEntered(MouseEvent evt) {
/* 1893 */     this.jLabel5.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel5MouseExited(MouseEvent evt) {
/* 1897 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseClicked(MouseEvent evt) {
/* 1901 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1902 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1903 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jLabel6MouseEntered(MouseEvent evt) {
/* 1907 */     this.jLabel6.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseExited(MouseEvent evt) {
/* 1911 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 1915 */     Calendar ca = Calendar.getInstance();
/* 1916 */     Calendar fecha = Calendar.getInstance();
/* 1917 */     int aa = fecha.get(1);
/* 1918 */     int mm = fecha.get(2);
/* 1919 */     int dd = fecha.get(5);
/* 1920 */     if (dd == 1) {
/* 1921 */       if (mm == 0) {
/* 1922 */         mm = 11;
/* 1923 */         aa--;
/*      */       } else {
/* 1925 */         mm--;
/*      */       } 
/* 1927 */       int diasTotal = diasDelMes(mm, aa);
/* 1928 */       dd = diasTotal;
/*      */     } else {
/* 1930 */       dd--;
/*      */     } 
/* 1932 */     mm++;
/* 1933 */     String año = "" + aa;
/* 1934 */     String mes = "" + mm;
/* 1935 */     String dia = "" + dd;
/* 1936 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1937 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 1939 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 1940 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 1941 */     } catch (ParseException ex) {
/* 1942 */       ex.printStackTrace();
/*      */     } 
/* 1944 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 1948 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/* 1952 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1956 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 1960 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 1964 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1968 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 1972 */     this.jComboBox8.setEnabled(false);
/* 1973 */     this.jTabbedPane1.removeAll();
/* 1974 */     this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 1975 */     this.jTabbedPane1.addTab("Imss", this.jPanel9);
/* 1976 */     deshabilitar();
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 1980 */     this.jComboBox8.setSelectedIndex(0);
/* 1981 */     this.jComboBox8.setEnabled(false);
/* 1982 */     this.jTabbedPane1.removeAll();
/* 1983 */     this.jTabbedPane1.addTab("Imss", this.jPanel9);
/* 1984 */     deshabilitar();
/*      */   }
/*      */   
/*      */   private void jTable6MouseClicked(MouseEvent evt) {
/* 1988 */     if (evt.getClickCount() == 2) {
/* 1989 */       cargarTrabajador();
/*      */     } else {
/*      */       
/* 1992 */       int ind = this.jTable6.getSelectedRow();
/* 1993 */       String nombre = String.valueOf(this.jTable6.getValueAt(ind, 0));
/* 1994 */       this.jButton20.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 1999 */     cargarTrabajador();
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 2003 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTextField9KeyReleased(KeyEvent evt) {
/* 2007 */     consultar();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField10ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField10KeyReleased(KeyEvent evt) {
/* 2016 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2020 */     consultar();
/* 2021 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 2025 */     if (this.ACTIVO) {
/* 2026 */       contarDias();
/* 2027 */       calcularVaca();
/* 2028 */       sacarTotalComp();
/* 2029 */       sacarTotalImss();
/* 2030 */       sacarTotalNeto();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 2035 */     restarFechas();
/* 2036 */     calcularVaca();
/* 2037 */     sacarTotalComp();
/* 2038 */     sacarTotalImss();
/* 2039 */     sacarTotalNeto();
/*      */   }
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {
/* 2043 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 2047 */     String cant = this.jFormattedTextField3.getText();
/*      */     
/* 2049 */     boolean correcto = false;
/* 2050 */     String[] nombres = null;
/* 2051 */     int esp = 0;
/* 2052 */     String texto = this.jTextField27.getText(); int i;
/* 2053 */     for (i = 0; i < texto.length(); i++) {
/* 2054 */       if (texto.charAt(i) == ' ') {
/* 2055 */         esp++;
/*      */       }
/*      */     } 
/* 2058 */     nombres = new String[esp + 1];
/* 2059 */     for (i = 0; i <= esp; i++) {
/* 2060 */       nombres[i] = "";
/*      */     }
/* 2062 */     esp = 0;
/* 2063 */     for (i = 0; i < texto.length(); i++) {
/* 2064 */       if (texto.charAt(i) == ' ') {
/* 2065 */         esp++;
/*      */       } else {
/*      */         
/* 2068 */         nombres[esp] = nombres[esp] + nombres[esp];
/*      */       } 
/*      */     } 
/* 2071 */     for (i = 0; i < nombres.length; i++) {
/* 2072 */       if (nombres[i].length() == 0) {
/* 2073 */         this.jTextField27.setBackground(Color.RED);
/* 2074 */         JOptionPane.showMessageDialog(this.jDialog3, "Tienes un espacio de más en la descripción del concepto", "Error 031 - Espacio", 0, this.ERROR);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 2079 */     if (cant.equals("$0.00")) {
/* 2080 */       this.jFormattedTextField3.setBackground(Color.RED);
/* 2081 */       JOptionPane.showMessageDialog(this.jDialog3, "No puedes colocar cantidad menores a cero", "Cantidad pequeña", 0, this.ERROR);
/*      */     }
/* 2083 */     else if (this.jTextField27.getText().equals("")) {
/* 2084 */       this.jTextField27.setBackground(Color.RED);
/* 2085 */       JOptionPane.showMessageDialog(this.jDialog3, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/*      */     
/*      */     }
/* 2088 */     else if (this.jTextField27.getText().length() > 999) {
/* 2089 */       this.jTextField27.setBackground(Color.RED);
/* 2090 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes agregar más 999 caracteres en el concepto", "Concepto muy largo", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 2093 */       String desc = this.jTextField27.getText().toUpperCase();
/* 2094 */       String valor = String.valueOf(this.jFormattedTextField3.getValue());
/*      */       
/* 2096 */       String valorP = "";
/* 2097 */       for (int j = 0; j < valor.length(); j++) {
/* 2098 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',') {
/* 2099 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 2103 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Deseas agregar el nuevo concepto?", "Agregar concepto", 0, 3, this.PREG);
/* 2104 */       if (res == 0) {
/* 2105 */         DefaultTableModel temp = (DefaultTableModel)this.jTable4.getModel();
/* 2106 */         Object[] nuevo = { desc, this.jFormattedTextField3.getText() };
/* 2107 */         temp.addRow(nuevo);
/* 2108 */         this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 2109 */         this.jTextField27.setText("");
/* 2110 */         this.jTable4.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 2111 */         sacarTotalComp();
/* 2112 */         sacarTotalNeto();
/* 2113 */         this.jDialog3.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 2119 */     this.jTextField27.setText("");
/* 2120 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 2121 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 2125 */     if (this.jTable4.getSelectedRow() < 0) {
/* 2126 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un dato para quitar el descuento", "Selecciona un descuento", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 2129 */       DefaultTableModel temp = (DefaultTableModel)this.jTable4.getModel();
/* 2130 */       temp.removeRow(this.jTable4.getSelectedRow());
/* 2131 */       sacarTotalComp();
/* 2132 */       sacarTotalNeto();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2137 */     this.jTextField28.setText("");
/* 2138 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 2139 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton35ActionPerformed(ActionEvent evt) {
/* 2143 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton36ActionPerformed(ActionEvent evt) {
/* 2147 */     String cant = this.jFormattedTextField4.getText();
/*      */     
/* 2149 */     boolean correcto = false;
/* 2150 */     String[] nombres = null;
/* 2151 */     int esp = 0;
/* 2152 */     String texto = this.jTextField28.getText(); int i;
/* 2153 */     for (i = 0; i < texto.length(); i++) {
/* 2154 */       if (texto.charAt(i) == ' ') {
/* 2155 */         esp++;
/*      */       }
/*      */     } 
/* 2158 */     nombres = new String[esp + 1];
/* 2159 */     for (i = 0; i <= esp; i++) {
/* 2160 */       nombres[i] = "";
/*      */     }
/* 2162 */     esp = 0;
/* 2163 */     for (i = 0; i < texto.length(); i++) {
/* 2164 */       if (texto.charAt(i) == ' ') {
/* 2165 */         esp++;
/*      */       } else {
/*      */         
/* 2168 */         nombres[esp] = nombres[esp] + nombres[esp];
/*      */       } 
/*      */     } 
/* 2171 */     for (i = 0; i < nombres.length; i++) {
/* 2172 */       if (nombres[i].length() == 0) {
/* 2173 */         this.jTextField28.setBackground(Color.RED);
/* 2174 */         JOptionPane.showMessageDialog(this.jDialog3, "Tienes un espacio de más en la descripción del concepto", "Error 031 - Espacio", 0, this.ERROR);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 2179 */     if (cant.equals("$0.00")) {
/* 2180 */       this.jFormattedTextField4.setBackground(Color.RED);
/* 2181 */       JOptionPane.showMessageDialog(this.jDialog3, "No puedes colocar cantidad menores a cero", "Cantidad pequeña", 0, this.ERROR);
/*      */     }
/* 2183 */     else if (this.jTextField28.getText().equals("")) {
/* 2184 */       this.jTextField28.setBackground(Color.RED);
/* 2185 */       JOptionPane.showMessageDialog(this.jDialog3, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/*      */     
/*      */     }
/* 2188 */     else if (this.jTextField28.getText().length() > 999) {
/* 2189 */       this.jTextField28.setBackground(Color.RED);
/* 2190 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes agregar más 999 caracteres en el concepto", "Concepto muy largo", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 2193 */       String desc = this.jTextField28.getText().toUpperCase();
/* 2194 */       String valor = String.valueOf(this.jFormattedTextField4.getValue());
/*      */       
/* 2196 */       String valorP = "";
/* 2197 */       for (int j = 0; j < valor.length(); j++) {
/* 2198 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',') {
/* 2199 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 2203 */       int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Deseas agregar el nuevo concepto?", "Agregar concepto", 0, 3, this.PREG);
/* 2204 */       if (res == 0) {
/* 2205 */         DefaultTableModel temp = (DefaultTableModel)this.jTable5.getModel();
/* 2206 */         Object[] nuevo = { desc, this.jFormattedTextField4.getText() };
/* 2207 */         temp.addRow(nuevo);
/* 2208 */         this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 2209 */         this.jTextField28.setText("");
/* 2210 */         this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 2211 */         sacarTotalComp();
/* 2212 */         sacarTotalImss();
/* 2213 */         sacarTotalNeto();
/* 2214 */         this.jDialog4.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2220 */     if (this.jTable5.getSelectedRow() < 0) {
/* 2221 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un dato para quitar el descuento", "Selecciona un descuento", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 2224 */       DefaultTableModel temp = (DefaultTableModel)this.jTable5.getModel();
/* 2225 */       temp.removeRow(this.jTable5.getSelectedRow());
/* 2226 */       sacarTotalImss();
/* 2227 */       sacarTotalNeto();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 2232 */     if (this.jButton4.getText().equals("Imprimir")) {
/* 2233 */       if (this.jRadioButton1.isSelected()) {
/* 2234 */         ImprimirVacaciones imp = new ImprimirVacaciones();
/* 2235 */         imp.recibeDatos();
/*      */       } else {
/*      */         
/* 2238 */         ImprimirVacaciones2 imp = new ImprimirVacaciones2();
/* 2239 */         imp.recibeDatos();
/*      */       } 
/*      */     } else {
/*      */       
/* 2243 */       restarFechas();
/* 2244 */       calcularVaca();
/* 2245 */       sacarTotalComp();
/* 2246 */       sacarTotalImss();
/* 2247 */       sacarTotalNeto();
/* 2248 */       String tipoTrabajador = "";
/* 2249 */       if (this.jRadioButton1.isSelected()) {
/* 2250 */         tipoTrabajador = "ADMINISTRATIVO";
/*      */       } else {
/*      */         
/* 2253 */         tipoTrabajador = "OPERADOR";
/*      */       } 
/*      */       
/* 2256 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2257 */       String cadenaFecha1 = formato.format(this.jDateChooser9.getDate());
/* 2258 */       String año = cadenaFecha1.substring(0, 4);
/* 2259 */       String mes = cadenaFecha1.substring(4, 6);
/* 2260 */       String dia = cadenaFecha1.substring(6, 8);
/* 2261 */       String fechaIngreso = "'" + año + "-" + mes + "-" + dia + "'";
/*      */       
/* 2263 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 2264 */       cadenaFecha1 = formato.format(this.jDateChooser7.getDate());
/* 2265 */       año = cadenaFecha1.substring(0, 4);
/* 2266 */       mes = cadenaFecha1.substring(4, 6);
/* 2267 */       dia = cadenaFecha1.substring(6, 8);
/* 2268 */       String fecha1 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */       
/* 2270 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 2271 */       cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 2272 */       año = cadenaFecha1.substring(0, 4);
/* 2273 */       mes = cadenaFecha1.substring(4, 6);
/* 2274 */       dia = cadenaFecha1.substring(6, 8);
/* 2275 */       String fecha2 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */       
/* 2277 */       if (this.jButton4.getText().equals("Modificar")) {
/* 2278 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas modificar el documento?", "Modificar Vacaciones", 0, 3, this.PREG);
/* 2279 */         if (res == 0) {
/* 2280 */           this.con.eliminar2("vacaciones_complemento", "where folio_vaca='" + this.jTextField6.getText() + "'");
/* 2281 */           this.con.eliminar2("vacaciones_imss", "where folio_vaca='" + this.jTextField6.getText() + "'");
/* 2282 */           this.con.eliminar2("vacaciones_concep", "where folio_vaca='" + this.jTextField6.getText() + "'");
/* 2283 */           this.con.inserSinMsj("update vacaciones_regis set fecha=now(), fecha1=" + fecha1 + ", fecha2=" + fecha2 + ", tipoAnual='" + String.valueOf(this.jComboBox5.getSelectedItem()) + "', diasDerecho=" + this.jTextField4.getText() + ", total='" + this.jLabel13.getText() + "' where folio_vaca='" + this.jTextField6.getText() + "'"); int i;
/* 2284 */           for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2285 */             this.con.inserSinMsj("insert into vacaciones_complemento(concepto,diasLey,diasAnual,FactorDias,SubtotalDias,Salario,total,folio_vaca) values('" + String.valueOf(this.jTable1.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 6)) + "','" + this.jTextField6.getText() + "')");
/*      */           }
/* 2287 */           for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2288 */             this.con.inserSinMsj("insert into vacaciones_imss(concepto,diasLey,diasAnual,FactorDias,SubtotalDias,Salario,total,folio_vaca) values('" + String.valueOf(this.jTable2.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 6)) + "','" + this.jTextField6.getText() + "')");
/*      */           }
/* 2290 */           for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 2291 */             this.con.inserSinMsj("insert into vacaciones_concep(concepto,total,tipo,folio_vaca) values('" + String.valueOf(this.jTable4.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable4.getValueAt(i, 1)) + "',0,'" + this.jTextField6.getText() + "')");
/*      */           }
/*      */           
/* 2294 */           for (i = 0; i < this.jTable5.getRowCount(); i++) {
/* 2295 */             this.con.inserSinMsj("insert into vacaciones_concep(concepto,total,tipo,folio_vaca) values('" + String.valueOf(this.jTable5.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable5.getValueAt(i, 1)) + "',1,'" + this.jTextField6.getText() + "')");
/*      */           }
/* 2297 */           if (this.jRadioButton1.isSelected()) {
/* 2298 */             ImprimirVacaciones imp = new ImprimirVacaciones();
/* 2299 */             imp.recibeDatos();
/*      */           } else {
/*      */             
/* 2302 */             ImprimirVacaciones2 imp = new ImprimirVacaciones2();
/* 2303 */             imp.recibeDatos();
/*      */           } 
/* 2305 */           consultar2();
/* 2306 */           this.jDialog1.setVisible(false);
/*      */         }
/*      */       
/* 2309 */       } else if (this.jButton4.getText().equals("Guardar")) {
/* 2310 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas guardar el pago de vacaciones?", "Guardar Pago", 0, 3, this.PREG);
/* 2311 */         if (res == 0) {
/* 2312 */           sacarMayor();
/* 2313 */           this.con.inserSinMsj("insert into vacaciones_regis(folio_vaca,fecha,fecha_ingreso,fecha1,fecha2,tipoAnual,trabajador,clave,tipoTrabajador,departamento,diasDerecho,total,estatus,documento) values('" + this.jTextField6.getText() + "',now()," + fechaIngreso + "," + fecha1 + "," + fecha2 + ",'" + String.valueOf(this.jComboBox5.getSelectedItem()) + "','" + this.jTextField5.getText() + "','" + this.CLAVE + "','" + tipoTrabajador + "','" + String.valueOf(this.jComboBox6.getSelectedItem()) + "'," + this.jTextField4.getText() + ",'" + this.jLabel13.getText() + "','<Por Pagar>','" + this.USUARIO + "')"); int i;
/* 2314 */           for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2315 */             this.con.inserSinMsj("insert into vacaciones_complemento(concepto,diasLey,diasAnual,FactorDias,SubtotalDias,Salario,total,folio_vaca) values('" + String.valueOf(this.jTable1.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 6)) + "','" + this.jTextField6.getText() + "')");
/*      */           }
/* 2317 */           for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 2318 */             this.con.inserSinMsj("insert into vacaciones_imss(concepto,diasLey,diasAnual,FactorDias,SubtotalDias,Salario,total,folio_vaca) values('" + String.valueOf(this.jTable2.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 3)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 4)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 5)) + "','" + String.valueOf(this.jTable2.getValueAt(i, 6)) + "','" + this.jTextField6.getText() + "')");
/*      */           }
/*      */           
/* 2321 */           for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 2322 */             this.con.inserSinMsj("insert into vacaciones_concep(concepto,total,tipo,folio_vaca) values('" + String.valueOf(this.jTable4.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable4.getValueAt(i, 1)) + "',0,'" + this.jTextField6.getText() + "')");
/*      */           }
/*      */           
/* 2325 */           for (i = 0; i < this.jTable5.getRowCount(); i++) {
/* 2326 */             this.con.inserSinMsj("insert into vacaciones_concep(concepto,total,tipo,folio_vaca) values('" + String.valueOf(this.jTable5.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable5.getValueAt(i, 1)) + "',1,'" + this.jTextField6.getText() + "')");
/*      */           }
/* 2328 */           if (this.jRadioButton1.isSelected()) {
/* 2329 */             ImprimirVacaciones imp = new ImprimirVacaciones();
/* 2330 */             imp.recibeDatos();
/*      */           } else {
/*      */             
/* 2333 */             ImprimirVacaciones2 imp = new ImprimirVacaciones2();
/* 2334 */             imp.recibeDatos();
/*      */           } 
/* 2336 */           consultar2();
/* 2337 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 2344 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 2348 */     int ind = this.jTable3.getSelectedRow();
/* 2349 */     if (ind < 0) {
/* 2350 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una valor para modificar los datos", "Selecciona una formato", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 2353 */       String estatus = String.valueOf(this.jTable3.getValueAt(ind, 7));
/* 2354 */       if (!estatus.contains("<Por Pagar>")) {
/* 2355 */         JOptionPane.showMessageDialog(this.padre, "No puedes modificar el documento porque su estatus no es '<Por Pagar>'", "No se puede modificar", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 2358 */         String tipo = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 5));
/* 2359 */         if (tipo.equals("OPERADOR")) {
/* 2360 */           this.jRadioButton2.setSelected(true);
/* 2361 */           this.jTabbedPane1.removeAll();
/* 2362 */           this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */         } else {
/*      */           
/* 2365 */           this.jRadioButton1.setSelected(true);
/* 2366 */           this.jTabbedPane1.removeAll();
/* 2367 */           this.jTabbedPane1.addTab("Complemento", this.jPanel6);
/* 2368 */           this.jTabbedPane1.addTab("Imss", this.jPanel9);
/*      */         } 
/* 2370 */         verVacaciones();
/* 2371 */         this.jDateChooser10.setDate(new Date());
/* 2372 */         this.jButton4.setText("Modificar");
/* 2373 */         this.jButton4.setMnemonic('M');
/* 2374 */         this.jRadioButton1.setEnabled(false);
/* 2375 */         this.jRadioButton2.setEnabled(false);
/* 2376 */         this.jButton12.setEnabled(false);
/* 2377 */         this.jButton4.setEnabled(true);
/* 2378 */         this.jButton12.setEnabled(false);
/*      */         
/* 2380 */         this.jButton8.setEnabled(true);
/* 2381 */         this.jButton7.setEnabled(true);
/* 2382 */         this.jButton11.setEnabled(true);
/* 2383 */         this.jButton10.setEnabled(true);
/*      */         
/* 2385 */         this.jComboBox5.setEnabled(true);
/* 2386 */         this.jButton13.setEnabled(true);
/* 2387 */         this.jDateChooser7.setEnabled(true);
/* 2388 */         this.jDateChooser8.setEnabled(true);
/* 2389 */         this.jDialog1.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 2395 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 2399 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 2403 */     int ind = this.jTable3.getSelectedRow();
/* 2404 */     String estatus = String.valueOf(this.jTable3.getValueAt(ind, 7));
/* 2405 */     if (ind < 0) {
/* 2406 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un valor para ver los datos", "Selecciona un formato", 0, this.ADVER);
/*      */     }
/* 2408 */     else if (!estatus.contains("<Por Pagar>")) {
/* 2409 */       JOptionPane.showMessageDialog(this.padre, "No puedes autorizar el documento porque su estatus no es '<Por Pagar>'", "Vacaciones autorizadas", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 2412 */       int res = JOptionPane.showConfirmDialog(this.jDialog5, "¿Estás seguro que deseas autorizar el pago de vacaciones?", "Autorizar Vacaciones", 0, 3, this.PREG);
/* 2413 */       if (res == 0) {
/* 2414 */         this.con.inserSinMsj("update vacaciones_regis set estatus='<Autorizada: " + this.USUARIO + " " + cargarFechaHoy() + ">' where folio_vaca='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "'");
/* 2415 */         consultar2();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 2421 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 2425 */     consultar();
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 2429 */     Calendar ahoraCal = Calendar.getInstance();
/* 2430 */     ahoraCal.setTime(this.fecha);
/* 2431 */     String mesesito = "";
/* 2432 */     String hoy = "";
/* 2433 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 2434 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 2436 */     if (ahoraCal.get(2) + 1 < 10) {
/* 2437 */       mesesito = "0" + mesesito;
/*      */     }
/* 2439 */     if (ahoraCal.get(5) < 10) {
/* 2440 */       hoy = "0" + hoy;
/*      */     }
/* 2442 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   public void cancelar() {
/* 2445 */     String motivo = this.jTextArea5.getText();
/* 2446 */     if (motivo.equals("")) {
/* 2447 */       this.jTextArea5.setBackground(Color.RED);
/* 2448 */       JOptionPane.showMessageDialog(this.jDialog5, "Necesitas colocar el motivo por el cual se cancela el pago de vacaciones", "Coloca un comentario", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 2451 */       int res = JOptionPane.showConfirmDialog(this.jDialog5, "¿Estás seguro que deseas cancelar el pago de vacaciones que seleccionaste?", "Cancelar Vacaciones", 0, 3, this.PREG);
/* 2452 */       if (res == 0) {
/* 2453 */         String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/* 2454 */         this.con.inserSinMsj("update vacaciones_regis set estatus='<Cancelada: " + this.USUARIO + " " + cargarFechaHoy() + "-" + this.jTextArea5.getText().toUpperCase() + "' where folio_vaca='" + num + "'");
/* 2455 */         consultar2();
/* 2456 */         this.jDialog5.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public void verVacaciones() {
/* 2461 */     this.jButton4.setText("Guardar");
/* 2462 */     this.jButton4.setMnemonic('G');
/* 2463 */     this.jRadioButton1.setEnabled(false);
/* 2464 */     this.jRadioButton2.setEnabled(false);
/* 2465 */     this.jButton12.setEnabled(false);
/* 2466 */     this.jButton13.setEnabled(false);
/* 2467 */     this.jButton8.setEnabled(false);
/* 2468 */     this.jButton7.setEnabled(false);
/* 2469 */     this.jButton11.setEnabled(false);
/* 2470 */     this.jButton10.setEnabled(false);
/* 2471 */     this.jDateChooser7.setEnabled(false);
/* 2472 */     this.jDateChooser8.setEnabled(false);
/* 2473 */     this.jComboBox5.setEnabled(false);
/* 2474 */     this.jTextField6.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)));
/* 2475 */     this.jTextField5.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3)));
/* 2476 */     this.jComboBox5.setSelectedItem(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4)));
/* 2477 */     this.jComboBox6.removeAllItems();
/* 2478 */     this.jComboBox6.addItem(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 5)));
/* 2479 */     this.jLabel13.setText(String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6)));
/*      */ 
/*      */ 
/*      */     
/* 2483 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2484 */           .buscarDatos(7, "concepto,diasLey,diasAnual,FactorDias,subtotalDias,salario,total", "vacaciones_complemento", "where folio_vaca='" + this.jTextField6.getText() + "' order by num asc"), (Object[])new String[] { "Concepto", "Dias Ley", "Dias del Año", "Factor en Días", "Subtotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */           
/* 2488 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2492 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2495 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 2496 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(100);
/* 2497 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
/* 2498 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(100);
/* 2499 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
/* 2500 */     this.jTable1.getColumnModel().getColumn(3).setMinWidth(100);
/* 2501 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
/* 2502 */     this.jTable1.getColumnModel().getColumn(4).setMinWidth(100);
/* 2503 */     this.jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
/* 2504 */     this.jTable1.getColumnModel().getColumn(5).setMinWidth(100);
/* 2505 */     this.jTable1.getColumnModel().getColumn(5).setMaxWidth(100);
/* 2506 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 2507 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 2508 */     this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 2509 */     this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 2510 */     this.jTable1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 2511 */     this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/*      */ 
/*      */ 
/*      */     
/* 2515 */     this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 2516 */           .buscarDatos(7, "concepto,diasLey,diasAnual,FactorDias,subtotalDias,salario,total", "vacaciones_imss", "where folio_vaca='" + this.jTextField6.getText() + "' order by num asc"), (Object[])new String[] { "Concepto", "Dias Ley", "Dias del Año", "Factor en Días", "Subtotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */           
/* 2520 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2524 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2527 */     this.jScrollPane2.setViewportView(this.jTable2);
/* 2528 */     this.jTable2.getColumnModel().getColumn(1).setMinWidth(100);
/* 2529 */     this.jTable2.getColumnModel().getColumn(1).setMaxWidth(100);
/* 2530 */     this.jTable2.getColumnModel().getColumn(2).setMinWidth(100);
/* 2531 */     this.jTable2.getColumnModel().getColumn(2).setMaxWidth(100);
/* 2532 */     this.jTable2.getColumnModel().getColumn(3).setMinWidth(100);
/* 2533 */     this.jTable2.getColumnModel().getColumn(3).setMaxWidth(100);
/* 2534 */     this.jTable2.getColumnModel().getColumn(4).setMinWidth(100);
/* 2535 */     this.jTable2.getColumnModel().getColumn(4).setMaxWidth(100);
/* 2536 */     this.jTable2.getColumnModel().getColumn(5).setMinWidth(100);
/* 2537 */     this.jTable2.getColumnModel().getColumn(5).setMaxWidth(100);
/* 2538 */     this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 2539 */     this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 2540 */     this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 2541 */     this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 2542 */     this.jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 2543 */     this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/*      */ 
/*      */ 
/*      */     
/* 2547 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 2548 */           .buscarDatos(2, "concepto,total", "vacaciones_concep", "where folio_vaca='" + this.jTextField6.getText() + "' and tipo=0"), (Object[])new String[] { "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */           
/* 2552 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2556 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2559 */     this.jScrollPane4.setViewportView(this.jTable4);
/* 2560 */     this.jTable4.getColumnModel().getColumn(1).setMinWidth(180);
/* 2561 */     this.jTable4.getColumnModel().getColumn(1).setMaxWidth(180);
/* 2562 */     this.jTable4.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */ 
/*      */ 
/*      */     
/* 2566 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/* 2567 */           .buscarDatos(2, "concepto,total", "vacaciones_concep", "where folio_vaca='" + this.jTextField6.getText() + "' and tipo=1"), (Object[])new String[] { "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */           
/* 2571 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2575 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2578 */     this.jScrollPane5.setViewportView(this.jTable5);
/* 2579 */     this.jTable5.getColumnModel().getColumn(1).setMinWidth(180);
/* 2580 */     this.jTable5.getColumnModel().getColumn(1).setMaxWidth(180);
/* 2581 */     this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*      */     
/* 2583 */     String[] regis = this.con.regresaReg("fecha_Ingreso,fecha1,fecha2,diasDerecho", "vacaciones_regis", "where folio_vaca = '" + this.jTextField6.getText() + "'", 4);
/* 2584 */     this.jTextField4.setText(regis[3]);
/*      */ 
/*      */     
/* 2587 */     String fecha = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2));
/* 2588 */     String fechaCorta = fecha.substring(0, 10);
/* 2589 */     String año = fechaCorta.substring(0, 4);
/* 2590 */     String mes = fechaCorta.substring(5, 7);
/* 2591 */     String dia = fechaCorta.substring(8, 10);
/* 2592 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2593 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 2595 */       Date fechaT = formatoDelTexto.parse(strFecha);
/* 2596 */       this.jDateChooser10.setDate(fechaT);
/*      */     }
/* 2598 */     catch (ParseException ex) {
/* 2599 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 2602 */     fecha = regis[0];
/* 2603 */     fechaCorta = fecha.substring(0, 10);
/* 2604 */     año = fechaCorta.substring(0, 4);
/* 2605 */     mes = fechaCorta.substring(5, 7);
/* 2606 */     dia = fechaCorta.substring(8, 10);
/* 2607 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2608 */     strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 2610 */       Date fechaT = formatoDelTexto.parse(strFecha);
/* 2611 */       this.jDateChooser9.setDate(fechaT);
/*      */     }
/* 2613 */     catch (ParseException ex) {
/* 2614 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 2617 */     fecha = regis[1];
/* 2618 */     fechaCorta = fecha.substring(0, 10);
/* 2619 */     año = fechaCorta.substring(0, 4);
/* 2620 */     mes = fechaCorta.substring(5, 7);
/* 2621 */     dia = fechaCorta.substring(8, 10);
/* 2622 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2623 */     strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 2625 */       Date fechaT = formatoDelTexto.parse(strFecha);
/* 2626 */       this.jDateChooser7.setDate(fechaT);
/*      */     }
/* 2628 */     catch (ParseException ex) {
/* 2629 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 2632 */     fecha = regis[2];
/* 2633 */     fechaCorta = fecha.substring(0, 10);
/* 2634 */     año = fechaCorta.substring(0, 4);
/* 2635 */     mes = fechaCorta.substring(5, 7);
/* 2636 */     dia = fechaCorta.substring(8, 10);
/* 2637 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2638 */     strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 2640 */       Date fechaT = formatoDelTexto.parse(strFecha);
/* 2641 */       this.jDateChooser8.setDate(fechaT);
/*      */     }
/* 2643 */     catch (ParseException ex) {
/* 2644 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 2647 */     this.con.consultar("clave", "vacaciones_regis", "where folio_vaca='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "'");
/* 2648 */     this.CLAVE = this.con.Campo;
/* 2649 */     if (this.jRadioButton1.isSelected()) {
/* 2650 */       this.DATOS = this.con.regresaReg("ultimoIngreso,SalarioReal,salarioimss", "empleados", "where clave_emp=" + this.con.Campo, 3);
/*      */     } else {
/*      */       
/* 2653 */       this.jComboBox6.addItem("OPERADOR");
/* 2654 */       this.DATOS = new String[] { "", "", "" };
/* 2655 */       String[] AUX = this.con.regresaReg("ultimaFechaIngreso,SalarioImssLetra", "operadores", "where num_ope=" + this.con.Campo, 2);
/* 2656 */       this.DATOS[0] = AUX[0];
/* 2657 */       this.DATOS[1] = "0";
/* 2658 */       this.DATOS[2] = AUX[1];
/*      */     } 
/* 2660 */     this.DIAS = Integer.parseInt(String.valueOf(this.jTable1.getValueAt(0, 1)));
/* 2661 */     sacarTotalComp();
/* 2662 */     sacarTotalImss();
/* 2663 */     sacarTotalNeto();
/* 2664 */     this.ACTIVO = true;
/*      */   }
/*      */   
/*      */   public void consultar2() {
/* 2668 */     Date fecha1 = this.jDateChooser4.getDate();
/* 2669 */     Date fecha2 = this.jDateChooser5.getDate();
/*      */     
/* 2671 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2672 */     String cadenaFecha = "";
/* 2673 */     cadenaFecha = formato.format(fecha1);
/* 2674 */     String AÑO = cadenaFecha.substring(0, 4);
/* 2675 */     String MES = cadenaFecha.substring(4, 6);
/* 2676 */     String DIA = cadenaFecha.substring(6, 8);
/* 2677 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + " 00:00:00'";
/*      */     
/* 2679 */     cadenaFecha = formato.format(fecha2);
/* 2680 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 2681 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 2682 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/*      */     
/* 2684 */     String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59'";
/*      */ 
/*      */     
/* 2687 */     String estatus = "";
/* 2688 */     String departamento = "";
/* 2689 */     String usuario = "";
/*      */     
/* 2691 */     if (this.jComboBox1.getSelectedIndex() == 0) {
/* 2692 */       estatus = " estatus='<Por Pagar>' || estatus like '%<Pagada%' || estatus like '%<Abono%' || estatus like '%<Autorizada%'";
/*      */     }
/* 2694 */     else if (this.jComboBox1.getSelectedIndex() == 1) {
/* 2695 */       estatus = " estatus like '%%'";
/*      */     }
/* 2697 */     else if (this.jComboBox1.getSelectedIndex() == 2) {
/* 2698 */       estatus = " estatus ='<Por Pagar>'";
/*      */     }
/* 2700 */     else if (this.jComboBox1.getSelectedIndex() == 3) {
/* 2701 */       estatus = " estatus like '%<Autorizada%'";
/*      */     }
/* 2703 */     else if (this.jComboBox1.getSelectedIndex() == 4) {
/* 2704 */       estatus = " estatus like '%<Cancelada%'";
/*      */     } 
/*      */     
/* 2707 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 2708 */       departamento = String.valueOf(this.jComboBox2.getSelectedItem());
/*      */     }
/* 2710 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 2711 */       usuario = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2716 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 2717 */           .buscarDatos(9, "num_vaca,folio_vaca,fecha,Trabajador,tipoAnual,departamento,total,estatus,documento", "vacaciones_regis", "where folio_vaca like '%" + this.jTextField1.getText() + "%' and trabajador like '%" + this.jTextField2.getText() + "%' and departamento like '%" + departamento + "%' and documento like '%" + usuario + "%' and (" + estatus + ") and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by num_vaca desc"), (Object[])new String[] { "Núm", "Folio", "Fecha", "Empleado", "Periodo", "Departamento", "Total", "Estatus", "Documento" })
/*      */         {
/*      */ 
/*      */           
/* 2721 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2725 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2728 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable3.getRowCount() + "</HTML>");
/*      */ 
/*      */ 
/*      */     
/* 2732 */     this.celda3.pasarInd3(this.con.revisarCol(this.jTable3, "<Por Pagar>", 1, 7, 0));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2741 */     this.celda3.pasarInd5(this.con.revisarCol(this.jTable3, "<Cancelada", 1, 7, 2));
/*      */     
/* 2743 */     this.jTable3.setSelectionMode(0);
/* 2744 */     this.jTable3.setAutoCreateRowSorter(true);
/* 2745 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 2747 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 2748 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(50);
/* 2749 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 2750 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(80);
/* 2751 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(120);
/* 2752 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(120);
/* 2753 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(100);
/* 2754 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(100);
/*      */     
/* 2756 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 2757 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 2758 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda3);
/* 2759 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda3);
/* 2760 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda3);
/* 2761 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda3);
/* 2762 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda3);
/* 2763 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda3);
/* 2764 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda3);
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 2768 */     this.con.consultar("max(num_vaca)", "vacaciones_regis", "");
/* 2769 */     String mayor = this.con.Campo;
/* 2770 */     int MAYOR = 0;
/*      */     try {
/* 2772 */       MAYOR = Integer.parseInt(mayor);
/*      */     }
/* 2774 */     catch (NumberFormatException e) {
/* 2775 */       MAYOR = 0;
/*      */     } 
/* 2777 */     MAYOR++;
/* 2778 */     if (MAYOR < 10) {
/* 2779 */       this.jTextField6.setText(this.DIRECTIVA + "-0000" + this.DIRECTIVA);
/*      */     }
/* 2781 */     else if (MAYOR < 100) {
/* 2782 */       this.jTextField6.setText(this.DIRECTIVA + "-000" + this.DIRECTIVA);
/*      */     }
/* 2784 */     else if (MAYOR < 1000) {
/* 2785 */       this.jTextField6.setText(this.DIRECTIVA + "-00" + this.DIRECTIVA);
/*      */     }
/* 2787 */     else if (MAYOR < 10000) {
/* 2788 */       this.jTextField6.setText(this.DIRECTIVA + "-0" + this.DIRECTIVA);
/*      */     } else {
/*      */       
/* 2791 */       this.jTextField6.setText(this.DIRECTIVA + "-" + this.DIRECTIVA);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void contarDias() {
/* 2834 */     if (this.jComboBox5.getSelectedIndex() == 0) {
/* 2835 */       this.DIAS = 12;
/*      */       
/* 2837 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2838 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2839 */       cal1.add(1, 0);
/* 2840 */       cal2.add(1, 1);
/* 2841 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2842 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2844 */     else if (this.jComboBox5.getSelectedIndex() == 1) {
/* 2845 */       this.DIAS = 14;
/* 2846 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2847 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2848 */       cal1.add(1, 1);
/* 2849 */       cal2.add(1, 2);
/* 2850 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2851 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2853 */     else if (this.jComboBox5.getSelectedIndex() == 2) {
/* 2854 */       this.DIAS = 16;
/*      */       
/* 2856 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2857 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2858 */       cal1.add(1, 2);
/* 2859 */       cal2.add(1, 3);
/* 2860 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2861 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     
/*      */     }
/* 2864 */     else if (this.jComboBox5.getSelectedIndex() == 3) {
/* 2865 */       this.DIAS = 18;
/*      */       
/* 2867 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2868 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2869 */       cal1.add(1, 3);
/* 2870 */       cal2.add(1, 4);
/* 2871 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2872 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2874 */     else if (this.jComboBox5.getSelectedIndex() == 4) {
/* 2875 */       this.DIAS = 20;
/*      */       
/* 2877 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2878 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2879 */       cal1.add(1, 4);
/* 2880 */       cal2.add(1, 5);
/* 2881 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2882 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2884 */     else if (this.jComboBox5.getSelectedIndex() == 5) {
/* 2885 */       this.DIAS = 22;
/*      */       
/* 2887 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2888 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2889 */       cal1.add(1, 5);
/* 2890 */       cal2.add(1, 6);
/* 2891 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2892 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2894 */     else if (this.jComboBox5.getSelectedIndex() == 6) {
/* 2895 */       this.DIAS = 22;
/*      */       
/* 2897 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2898 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2899 */       cal1.add(1, 6);
/* 2900 */       cal2.add(1, 7);
/* 2901 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2902 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2904 */     else if (this.jComboBox5.getSelectedIndex() == 7) {
/* 2905 */       this.DIAS = 22;
/*      */       
/* 2907 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2908 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2909 */       cal1.add(1, 7);
/* 2910 */       cal2.add(1, 8);
/* 2911 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2912 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2914 */     else if (this.jComboBox5.getSelectedIndex() == 8) {
/* 2915 */       this.DIAS = 22;
/*      */       
/* 2917 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2918 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2919 */       cal1.add(1, 8);
/* 2920 */       cal2.add(1, 9);
/* 2921 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2922 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2924 */     else if (this.jComboBox5.getSelectedIndex() == 9) {
/* 2925 */       this.DIAS = 22;
/*      */       
/* 2927 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2928 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2929 */       cal1.add(1, 9);
/* 2930 */       cal2.add(1, 10);
/* 2931 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2932 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2934 */     else if (this.jComboBox5.getSelectedIndex() == 10) {
/* 2935 */       this.DIAS = 24;
/*      */       
/* 2937 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2938 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2939 */       cal1.add(1, 10);
/* 2940 */       cal2.add(1, 11);
/* 2941 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2942 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2944 */     else if (this.jComboBox5.getSelectedIndex() == 11) {
/* 2945 */       this.DIAS = 24;
/*      */       
/* 2947 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2948 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2949 */       cal1.add(1, 11);
/* 2950 */       cal2.add(1, 12);
/* 2951 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2952 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2954 */     else if (this.jComboBox5.getSelectedIndex() == 12) {
/* 2955 */       this.DIAS = 24;
/*      */       
/* 2957 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2958 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2959 */       cal1.add(1, 12);
/* 2960 */       cal2.add(1, 13);
/* 2961 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2962 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2964 */     else if (this.jComboBox5.getSelectedIndex() == 13) {
/* 2965 */       this.DIAS = 24;
/*      */       
/* 2967 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2968 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2969 */       cal1.add(1, 13);
/* 2970 */       cal2.add(1, 14);
/* 2971 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2972 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2974 */     else if (this.jComboBox5.getSelectedIndex() == 14) {
/* 2975 */       this.DIAS = 24;
/*      */       
/* 2977 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2978 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2979 */       cal1.add(1, 14);
/* 2980 */       cal2.add(1, 15);
/* 2981 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2982 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2984 */     else if (this.jComboBox5.getSelectedIndex() == 15) {
/* 2985 */       this.DIAS = 26;
/*      */       
/* 2987 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2988 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2989 */       cal1.add(1, 15);
/* 2990 */       cal2.add(1, 16);
/* 2991 */       this.jDateChooser7.setDate(cal1.getTime());
/* 2992 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 2994 */     else if (this.jComboBox5.getSelectedIndex() == 16) {
/* 2995 */       this.DIAS = 26;
/*      */       
/* 2997 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 2998 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 2999 */       cal1.add(1, 16);
/* 3000 */       cal2.add(1, 17);
/* 3001 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3002 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3004 */     else if (this.jComboBox5.getSelectedIndex() == 17) {
/* 3005 */       this.DIAS = 26;
/*      */       
/* 3007 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3008 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3009 */       cal1.add(1, 17);
/* 3010 */       cal2.add(1, 18);
/* 3011 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3012 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3014 */     else if (this.jComboBox5.getSelectedIndex() == 18) {
/* 3015 */       this.DIAS = 26;
/*      */       
/* 3017 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3018 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3019 */       cal1.add(1, 18);
/* 3020 */       cal2.add(1, 19);
/* 3021 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3022 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3024 */     else if (this.jComboBox5.getSelectedIndex() == 19) {
/* 3025 */       this.DIAS = 26;
/*      */       
/* 3027 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3028 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3029 */       cal1.add(1, 19);
/* 3030 */       cal2.add(1, 20);
/* 3031 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3032 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3034 */     else if (this.jComboBox5.getSelectedIndex() == 20) {
/* 3035 */       this.DIAS = 28;
/*      */       
/* 3037 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3038 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3039 */       cal1.add(1, 20);
/* 3040 */       cal2.add(1, 21);
/* 3041 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3042 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3044 */     else if (this.jComboBox5.getSelectedIndex() == 21) {
/* 3045 */       this.DIAS = 28;
/*      */       
/* 3047 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3048 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3049 */       cal1.add(1, 21);
/* 3050 */       cal2.add(1, 22);
/* 3051 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3052 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3054 */     else if (this.jComboBox5.getSelectedIndex() == 22) {
/* 3055 */       this.DIAS = 28;
/*      */       
/* 3057 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3058 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3059 */       cal1.add(1, 22);
/* 3060 */       cal2.add(1, 23);
/* 3061 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3062 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3064 */     else if (this.jComboBox5.getSelectedIndex() == 23) {
/* 3065 */       this.DIAS = 28;
/*      */       
/* 3067 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3068 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3069 */       cal1.add(1, 23);
/* 3070 */       cal2.add(1, 24);
/* 3071 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3072 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3074 */     else if (this.jComboBox5.getSelectedIndex() == 24) {
/* 3075 */       this.DIAS = 28;
/*      */       
/* 3077 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3078 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3079 */       cal1.add(1, 24);
/* 3080 */       cal2.add(1, 25);
/* 3081 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3082 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3084 */     else if (this.jComboBox5.getSelectedIndex() == 25) {
/* 3085 */       this.DIAS = 30;
/*      */       
/* 3087 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3088 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3089 */       cal1.add(1, 25);
/* 3090 */       cal2.add(1, 26);
/* 3091 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3092 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3094 */     else if (this.jComboBox5.getSelectedIndex() == 26) {
/* 3095 */       this.DIAS = 30;
/*      */       
/* 3097 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3098 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3099 */       cal1.add(1, 26);
/* 3100 */       cal2.add(1, 27);
/* 3101 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3102 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3104 */     else if (this.jComboBox5.getSelectedIndex() == 27) {
/* 3105 */       this.DIAS = 30;
/*      */       
/* 3107 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3108 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3109 */       cal1.add(1, 27);
/* 3110 */       cal2.add(1, 28);
/* 3111 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3112 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3114 */     else if (this.jComboBox5.getSelectedIndex() == 28) {
/* 3115 */       this.DIAS = 30;
/*      */       
/* 3117 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3118 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3119 */       cal1.add(1, 28);
/* 3120 */       cal2.add(1, 29);
/* 3121 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3122 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3124 */     else if (this.jComboBox5.getSelectedIndex() == 29) {
/* 3125 */       this.DIAS = 30;
/*      */       
/* 3127 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3128 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3129 */       cal1.add(1, 29);
/* 3130 */       cal2.add(1, 30);
/* 3131 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3132 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3134 */     else if (this.jComboBox5.getSelectedIndex() == 30) {
/* 3135 */       this.DIAS = 32;
/*      */       
/* 3137 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3138 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3139 */       cal1.add(1, 30);
/* 3140 */       cal2.add(1, 31);
/* 3141 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3142 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3144 */     else if (this.jComboBox5.getSelectedIndex() == 31) {
/* 3145 */       this.DIAS = 32;
/*      */       
/* 3147 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3148 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3149 */       cal1.add(1, 31);
/* 3150 */       cal2.add(1, 32);
/* 3151 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3152 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3154 */     else if (this.jComboBox5.getSelectedIndex() == 32) {
/* 3155 */       this.DIAS = 32;
/*      */       
/* 3157 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3158 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3159 */       cal1.add(1, 32);
/* 3160 */       cal2.add(1, 33);
/* 3161 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3162 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3164 */     else if (this.jComboBox5.getSelectedIndex() == 33) {
/* 3165 */       this.DIAS = 32;
/*      */       
/* 3167 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3168 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3169 */       cal1.add(1, 33);
/* 3170 */       cal2.add(1, 34);
/* 3171 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3172 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3174 */     else if (this.jComboBox5.getSelectedIndex() == 34) {
/* 3175 */       this.DIAS = 32;
/*      */       
/* 3177 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3178 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3179 */       cal1.add(1, 34);
/* 3180 */       cal2.add(1, 35);
/* 3181 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3182 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3184 */     else if (this.jComboBox5.getSelectedIndex() == 35) {
/* 3185 */       this.DIAS = 34;
/*      */       
/* 3187 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3188 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3189 */       cal1.add(1, 35);
/* 3190 */       cal2.add(1, 36);
/* 3191 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3192 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3194 */     else if (this.jComboBox5.getSelectedIndex() == 36) {
/* 3195 */       this.DIAS = 34;
/*      */       
/* 3197 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3198 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3199 */       cal1.add(1, 36);
/* 3200 */       cal2.add(1, 37);
/* 3201 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3202 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3204 */     else if (this.jComboBox5.getSelectedIndex() == 37) {
/* 3205 */       this.DIAS = 34;
/*      */       
/* 3207 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3208 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3209 */       cal1.add(1, 37);
/* 3210 */       cal2.add(1, 38);
/* 3211 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3212 */       this.jDateChooser8.setDate(cal2.getTime());
/*      */     }
/* 3214 */     else if (this.jComboBox5.getSelectedIndex() == 38) {
/* 3215 */       this.DIAS = 34;
/*      */       
/* 3217 */       Calendar cal1 = this.jDateChooser9.getCalendar();
/* 3218 */       Calendar cal2 = this.jDateChooser9.getCalendar();
/* 3219 */       cal1.add(1, 38);
/* 3220 */       cal2.add(1, 39);
/* 3221 */       this.jDateChooser7.setDate(cal1.getTime());
/* 3222 */       this.jDateChooser8.setDate(cal2.getTime());
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sacarTotalNeto() {
/* 3247 */     double valor1 = 0.0D;
/* 3248 */     String canti = this.jLabel19.getText();
/* 3249 */     String valorP = "";
/* 3250 */     for (int j = 0; j < canti.length(); j++) {
/* 3251 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3252 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3255 */     valor1 += Double.parseDouble(valorP);
/*      */     
/* 3257 */     double valor2 = 0.0D;
/* 3258 */     canti = this.jLabel21.getText();
/* 3259 */     valorP = "";
/* 3260 */     for (int i = 0; i < canti.length(); i++) {
/* 3261 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 3262 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3265 */     valor2 += Double.parseDouble(valorP);
/* 3266 */     valor1 += valor2;
/* 3267 */     this.cantidad.setValue(Double.valueOf(valor1));
/* 3268 */     this.jLabel13.setText(this.cantidad.getText());
/*      */     
/* 3270 */     this.numLetra = new NumerosALetras(valor1, "MXN");
/* 3271 */     this.jTextField3.setText(this.numLetra.regresaNumero());
/*      */   }
/*      */   public void restarFechas() {
/* 3274 */     int dias = 0;
/* 3275 */     int rangoAnyos = 0;
/* 3276 */     int diasAnyo = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3295 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3296 */     String cadenaFecha1 = formato.format(this.jDateChooser8.getDate());
/* 3297 */     String año = cadenaFecha1.substring(0, 4);
/* 3298 */     String mes = cadenaFecha1.substring(4, 6);
/* 3299 */     String dia = cadenaFecha1.substring(6, 8);
/*      */     
/* 3301 */     Date fecha1 = this.jDateChooser7.getDate();
/* 3302 */     Date fecha2 = this.jDateChooser8.getDate();
/*      */     
/* 3304 */     long fechaInicialMs = fecha1.getTime();
/* 3305 */     long fechaFinalMs = fecha2.getTime();
/* 3306 */     long diferencia = fechaFinalMs - fechaInicialMs;
/* 3307 */     dias = (int)Math.floor((diferencia / 86400000L));
/*      */ 
/*      */     
/* 3310 */     int mesI = Integer.parseInt(mes);
/* 3311 */     int diaI = Integer.parseInt(dia);
/*      */     
/* 3313 */     Date fechaC = null;
/* 3314 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*      */     try {
/* 3316 */       fechaC = formatoDelTexto.parse("28-02-" + año);
/*      */     }
/* 3318 */     catch (ParseException ex) {
/* 3319 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 3322 */     if (fecha2.after(fechaC) && 
/* 3323 */       Integer.parseInt(año) % 4 == 0) {
/* 3324 */       dias--;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3350 */     this.jTextField4.setText("" + dias);
/*      */   }
/*      */   public void Vacaciones(String usu) {
/* 3353 */     this.ACTIVO = false;
/* 3354 */     this.USUARIO = usu;
/* 3355 */     this.panel.setViewportView(this);
/* 3356 */     deshabilitar();
/* 3357 */     consultar2();
/*      */   }
/*      */   public void cargarTrabajador() {
/* 3360 */     this.CLAVE = String.valueOf(this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 0));
/* 3361 */     deshabilitar();
/* 3362 */     contarDias();
/* 3363 */     String clave = String.valueOf(this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 0));
/* 3364 */     this.jComboBox5.setSelectedIndex(0);
/*      */     
/* 3366 */     this.jTextField5.setText(String.valueOf(this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 1)));
/* 3367 */     String fecha = String.valueOf(this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 2));
/* 3368 */     this.jComboBox5.setEnabled(true);
/* 3369 */     this.jDateChooser7.setEnabled(true);
/* 3370 */     this.jDateChooser8.setEnabled(true);
/* 3371 */     this.jButton4.setEnabled(true);
/* 3372 */     this.ACTIVO = true;
/* 3373 */     this.jComboBox6.removeAllItems();
/* 3374 */     if (this.jRadioButton1.isSelected()) {
/* 3375 */       this.con.consultar("departamentos.nombre", "empleados,departamentos", "where empleados.clave_depa = departamentos.clave_depa and clave_emp = " + clave);
/* 3376 */       this.jComboBox6.addItem(this.con.Campo);
/* 3377 */       this.DATOS = this.con.regresaReg("ultimoIngreso,SalarioReal,salarioimss", "empleados", "where clave_emp=" + clave, 3);
/*      */     } else {
/*      */       
/* 3380 */       this.jComboBox6.addItem("OPERADOR");
/* 3381 */       this.DATOS = new String[] { "", "", "" };
/* 3382 */       String[] AUX = this.con.regresaReg("ultimaFechaIngreso,SalarioImssLetra", "operadores", "where num_ope=" + clave, 2);
/* 3383 */       this.DATOS[0] = AUX[0];
/* 3384 */       this.DATOS[1] = "0";
/* 3385 */       this.DATOS[2] = AUX[1];
/*      */     } 
/*      */     
/* 3388 */     String año = this.DATOS[0].substring(0, 4);
/* 3389 */     String mes = this.DATOS[0].substring(5, 7);
/* 3390 */     String dia = this.DATOS[0].substring(8, 10);
/*      */     
/* 3392 */     int añito = Integer.parseInt(año);
/* 3393 */     añito++;
/* 3394 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 3395 */     String strFecha = dia + "-" + dia + "-" + mes;
/* 3396 */     String strFecha2 = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 3398 */       Date fechaT = formatoDelTexto.parse(strFecha);
/* 3399 */       this.jDateChooser9.setDate(fechaT);
/* 3400 */       this.jDateChooser7.setDate(fechaT);
/* 3401 */       fechaT = formatoDelTexto.parse(strFecha2);
/* 3402 */       this.jDateChooser8.setDate(fechaT);
/*      */     }
/* 3404 */     catch (ParseException ex) {
/* 3405 */       ex.printStackTrace();
/*      */     } 
/* 3407 */     this.jButton13.setEnabled(true);
/*      */     
/* 3409 */     this.jTextField4.setText("365");
/* 3410 */     this.jButton7.setEnabled(true);
/* 3411 */     this.jButton8.setEnabled(true);
/*      */     
/* 3413 */     this.jButton10.setEnabled(true);
/* 3414 */     this.jButton11.setEnabled(true);
/*      */     
/* 3416 */     calcularVaca();
/* 3417 */     sacarTotalComp();
/* 3418 */     sacarTotalImss();
/* 3419 */     sacarTotalNeto();
/* 3420 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   public void sacarTotalImss() {
/* 3424 */     double complemento = 0.0D;
/* 3425 */     double descuentos = 0.0D; int i;
/* 3426 */     for (i = 0; i < this.jTable2.getRowCount(); i++) {
/* 3427 */       String canti = String.valueOf(this.jTable2.getValueAt(i, 6));
/* 3428 */       String valorP = "";
/* 3429 */       for (int j = 0; j < canti.length(); j++) {
/* 3430 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3431 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3434 */       complemento += Double.parseDouble(valorP);
/*      */     } 
/*      */     
/* 3437 */     for (i = 0; i < this.jTable5.getRowCount(); i++) {
/* 3438 */       String canti = String.valueOf(this.jTable5.getValueAt(i, 1));
/* 3439 */       String valorP = "";
/* 3440 */       for (int j = 0; j < canti.length(); j++) {
/* 3441 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3442 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3445 */       descuentos += Double.parseDouble(valorP);
/*      */     } 
/* 3447 */     complemento -= descuentos;
/* 3448 */     this.TOTAL2 = complemento;
/* 3449 */     this.cantidad.setValue(Double.valueOf(complemento));
/* 3450 */     this.jLabel21.setText(this.cantidad.getText());
/*      */   }
/*      */   
/*      */   public void sacarTotalComp() {
/* 3454 */     double complemento = 0.0D;
/* 3455 */     double descuentos = 0.0D; int i;
/* 3456 */     for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 3457 */       String canti = String.valueOf(this.jTable1.getValueAt(i, 6));
/* 3458 */       String valorP = "";
/* 3459 */       for (int j = 0; j < canti.length(); j++) {
/* 3460 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3461 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3464 */       complemento += Double.parseDouble(valorP);
/*      */     } 
/*      */     
/* 3467 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 3468 */       String canti = String.valueOf(this.jTable4.getValueAt(i, 1));
/* 3469 */       String valorP = "";
/* 3470 */       for (int j = 0; j < canti.length(); j++) {
/* 3471 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3472 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3475 */       descuentos += Double.parseDouble(valorP);
/*      */     } 
/* 3477 */     complemento -= descuentos;
/* 3478 */     this.TOTAL1 = complemento;
/* 3479 */     this.cantidad.setValue(Double.valueOf(complemento));
/* 3480 */     this.jLabel19.setText(this.cantidad.getText());
/*      */   }
/*      */   public void calcularVaca() {
/* 3483 */     String canti = this.DATOS[1];
/* 3484 */     String valorP = "";
/* 3485 */     for (int j = 0; j < canti.length(); j++) {
/* 3486 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3487 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3490 */     double salarioReal = Double.parseDouble(valorP);
/* 3491 */     double diario = salarioReal / 7.0D;
/*      */     
/* 3493 */     canti = this.DATOS[2];
/* 3494 */     valorP = "";
/* 3495 */     for (int i = 0; i < canti.length(); i++) {
/* 3496 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 3497 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3500 */     double salarioImss = Double.parseDouble(valorP);
/* 3501 */     double complemento = 0.0D;
/*      */     
/* 3503 */     if (this.jRadioButton1.isSelected()) {
/* 3504 */       complemento = diario - salarioImss;
/*      */     }
/* 3506 */     this.cantidad.setValue(Double.valueOf(complemento));
/* 3507 */     String diarioL = this.cantidad.getText();
/*      */     
/* 3509 */     restarFechas();
/* 3510 */     double FACTORDIAS = Double.parseDouble("" + this.DIAS) / Double.parseDouble("365");
/* 3511 */     double SUBTOTALDIAS = FACTORDIAS * Integer.parseInt(this.jTextField4.getText());
/* 3512 */     double SUBTOTAL1 = SUBTOTALDIAS * complemento;
/* 3513 */     this.cantidad.setValue(Double.valueOf(SUBTOTAL1));
/*      */     
/* 3515 */     String s1 = "" + FACTORDIAS;
/* 3516 */     String s2 = "" + SUBTOTALDIAS + "0000000";
/*      */     
/* 3518 */     this.jTable1.setValueAt("VACACIONES", 0, 0);
/* 3519 */     this.jTable1.setValueAt(Integer.valueOf(this.DIAS), 0, 1);
/* 3520 */     this.jTable1.setValueAt("365", 0, 2);
/* 3521 */     this.jTable1.setValueAt(s1.substring(0, 6), 0, 3);
/* 3522 */     this.jTable1.setValueAt(s2.substring(0, 6), 0, 4);
/* 3523 */     this.jTable1.setValueAt(diarioL, 0, 5);
/* 3524 */     this.jTable1.setValueAt(this.cantidad.getText(), 0, 6);
/*      */     
/* 3526 */     double PRIMA = SUBTOTAL1 * 0.25D;
/* 3527 */     this.cantidad.setValue(Double.valueOf(PRIMA));
/* 3528 */     this.jTable1.setValueAt("PRIMA VACACIONAL (25%)", 1, 0);
/* 3529 */     this.jTable1.setValueAt(this.cantidad.getText(), 1, 6);
/*      */ 
/*      */     
/* 3532 */     FACTORDIAS = Double.parseDouble("" + this.DIAS) / Double.parseDouble("365");
/* 3533 */     SUBTOTALDIAS = FACTORDIAS * Integer.parseInt(this.jTextField4.getText());
/* 3534 */     SUBTOTAL1 = SUBTOTALDIAS * salarioImss;
/* 3535 */     this.cantidad.setValue(Double.valueOf(SUBTOTAL1));
/*      */     
/* 3537 */     s1 = "" + FACTORDIAS;
/* 3538 */     s2 = "" + SUBTOTALDIAS + "0000000";
/* 3539 */     this.jTable2.setValueAt("VACACIONES", 0, 0);
/* 3540 */     this.jTable2.setValueAt(Integer.valueOf(this.DIAS), 0, 1);
/* 3541 */     this.jTable2.setValueAt("365", 0, 2);
/* 3542 */     this.jTable2.setValueAt(s1.substring(0, 6), 0, 3);
/* 3543 */     this.jTable2.setValueAt(s2.substring(0, 6), 0, 4);
/* 3544 */     this.jTable2.setValueAt(this.DATOS[2], 0, 5);
/* 3545 */     this.jTable2.setValueAt(this.cantidad.getText(), 0, 6);
/*      */     
/* 3547 */     PRIMA = SUBTOTAL1 * 0.25D;
/* 3548 */     this.cantidad.setValue(Double.valueOf(PRIMA));
/* 3549 */     this.jTable2.setValueAt("PRIMA VACACIONAL (25%)", 1, 0);
/* 3550 */     this.jTable2.setValueAt(this.cantidad.getText(), 1, 6);
/*      */   }
/*      */   public int diasDelMes(int mes, int año) {
/* 3553 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 3561 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 3567 */         return 30;
/*      */       
/*      */       case 1:
/* 3570 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 3572 */           return 29;
/*      */         }
/* 3574 */         return 28;
/*      */     } 
/*      */     
/* 3577 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void colorear() {
/* 3582 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3584 */             Vacaciones.this.jTextGanado(Vacaciones.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3587 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 3590 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3592 */             Vacaciones.this.jTextGanado(Vacaciones.this.jTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3595 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 3598 */     this.jTextField28.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3600 */             Vacaciones.this.jTextGanado(Vacaciones.this.jTextField28, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3603 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jTextField28, evt);
/*      */           }
/*      */         });
/* 3606 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3608 */             Vacaciones.this.jTextGanado(Vacaciones.this.jTextField9, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3611 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jTextField9, evt);
/*      */           }
/*      */         });
/* 3614 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3616 */             Vacaciones.this.jTextGanado(Vacaciones.this.jTextField10, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3619 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jTextField10, evt);
/*      */           }
/*      */         });
/*      */     
/* 3623 */     this.jTextField27.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3625 */             Vacaciones.this.jTextGanado(Vacaciones.this.jTextField27, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3628 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jTextField27, evt);
/*      */           }
/*      */         });
/*      */     
/* 3632 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3634 */             Vacaciones.this.jTextGanado(Vacaciones.this.jComboBox1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3637 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jComboBox1, evt);
/*      */           }
/*      */         });
/*      */     
/* 3641 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3643 */             Vacaciones.this.jTextGanado(Vacaciones.this.jComboBox2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3646 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jComboBox2, evt);
/*      */           }
/*      */         });
/*      */     
/* 3650 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3652 */             Vacaciones.this.jTextGanado(Vacaciones.this.jComboBox3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3655 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jComboBox3, evt);
/*      */           }
/*      */         });
/*      */     
/* 3659 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3661 */             Vacaciones.this.jTextGanado(Vacaciones.this.jComboBox5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3664 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jComboBox5, evt);
/*      */           }
/*      */         });
/*      */     
/* 3668 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3670 */             Vacaciones.this.jTextGanado(Vacaciones.this.jComboBox7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3673 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jComboBox7, evt);
/*      */           }
/*      */         });
/*      */     
/* 3677 */     this.jComboBox8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3679 */             Vacaciones.this.jTextGanado(Vacaciones.this.jComboBox8, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3682 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jComboBox8, evt);
/*      */           }
/*      */         });
/*      */     
/* 3686 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3688 */             Vacaciones.this.jTextGanado(Vacaciones.this.jFormattedTextField3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3691 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jFormattedTextField3, evt);
/*      */           }
/*      */         });
/* 3694 */     this.jFormattedTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3696 */             Vacaciones.this.jTextGanado(Vacaciones.this.jFormattedTextField4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3699 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jFormattedTextField4, evt);
/*      */           }
/*      */         });
/* 3702 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3704 */             Vacaciones.this.jTextGanado(Vacaciones.this.jTextArea5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3707 */             Vacaciones.this.jTextPerdido(Vacaciones.this.jTextArea5, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   public int alinearDer(int x, int letras) {
/* 3712 */     int quitar = 4 * letras;
/* 3713 */     x -= quitar;
/* 3714 */     return x;
/*      */   }
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 3717 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 3720 */     campo.setBackground(Color.white);
/*      */   }
/*      */   public void deshabilitar() {
/* 3723 */     this.ACTIVO = false;
/* 3724 */     this.jComboBox5.setEnabled(false);
/* 3725 */     this.jComboBox6.setEnabled(false);
/* 3726 */     this.jDateChooser7.setEnabled(false);
/* 3727 */     this.jDateChooser8.setEnabled(false);
/* 3728 */     this.jTextField4.setEnabled(false);
/* 3729 */     this.jComboBox6.removeAllItems();
/* 3730 */     this.jTextField5.setText("");
/* 3731 */     this.jButton13.setEnabled(false);
/* 3732 */     this.jComboBox5.setSelectedIndex(0);
/* 3733 */     this.jRadioButton1.setEnabled(true);
/* 3734 */     this.jRadioButton2.setEnabled(true);
/* 3735 */     this.jButton12.setEnabled(true);
/*      */     
/* 3737 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { "VACACIONES", "", "", "", "", "", "" }, , { "PRIMA VACACIONAL (25%)", "", "", "", "", "", "" },  }, (Object[])new String[] { "Concepto", "Días Ley", "Días del Año", "Factor en Días", "SubTotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3746 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3751 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3754 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 3755 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(100);
/* 3756 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
/* 3757 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(100);
/* 3758 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
/* 3759 */     this.jTable1.getColumnModel().getColumn(3).setMinWidth(100);
/* 3760 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
/* 3761 */     this.jTable1.getColumnModel().getColumn(4).setMinWidth(100);
/* 3762 */     this.jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
/* 3763 */     this.jTable1.getColumnModel().getColumn(5).setMinWidth(100);
/* 3764 */     this.jTable1.getColumnModel().getColumn(5).setMaxWidth(100);
/* 3765 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3766 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3767 */     this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3768 */     this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 3769 */     this.jTable1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 3770 */     this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/*      */     
/* 3772 */     this.jTable4 = new JTable();
/* 3773 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3780 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3785 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3788 */     this.jScrollPane4.setViewportView(this.jTable4);
/* 3789 */     this.jTable4.getColumnModel().getColumn(1).setMinWidth(180);
/* 3790 */     this.jTable4.getColumnModel().getColumn(1).setMaxWidth(180);
/*      */     
/* 3792 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { "VACACIONES", "", "", "", "", "", "" }, , { "PRIMA VACACIONAL (25%)", "", "", "", "", "", "" },  }, (Object[])new String[] { "Concepto", "Días Ley", "Días del Año", "Factor en Días", "SubTotal-Días", "Salario Diario", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3801 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3806 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3809 */     this.jScrollPane2.setViewportView(this.jTable2);
/* 3810 */     this.jTable2.getColumnModel().getColumn(1).setMinWidth(100);
/* 3811 */     this.jTable2.getColumnModel().getColumn(1).setMaxWidth(100);
/* 3812 */     this.jTable2.getColumnModel().getColumn(2).setMinWidth(100);
/* 3813 */     this.jTable2.getColumnModel().getColumn(2).setMaxWidth(100);
/* 3814 */     this.jTable2.getColumnModel().getColumn(3).setMinWidth(100);
/* 3815 */     this.jTable2.getColumnModel().getColumn(3).setMaxWidth(100);
/* 3816 */     this.jTable2.getColumnModel().getColumn(4).setMinWidth(100);
/* 3817 */     this.jTable2.getColumnModel().getColumn(4).setMaxWidth(100);
/* 3818 */     this.jTable2.getColumnModel().getColumn(5).setMinWidth(100);
/* 3819 */     this.jTable2.getColumnModel().getColumn(5).setMaxWidth(100);
/* 3820 */     this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3821 */     this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3822 */     this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3823 */     this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 3824 */     this.jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 3825 */     this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/*      */     
/* 3827 */     this.jTable5 = new JTable();
/* 3828 */     this.jTable5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Concepto", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3836 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3841 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3844 */     this.jScrollPane5.setViewportView(this.jTable5);
/* 3845 */     this.jTable5.getColumnModel().getColumn(1).setMinWidth(180);
/* 3846 */     this.jTable5.getColumnModel().getColumn(1).setMaxWidth(180);
/*      */     
/* 3848 */     this.jLabel21.setText("$0.00");
/* 3849 */     this.jLabel13.setText("$0.00");
/* 3850 */     this.jLabel19.setText("$0.00");
/*      */     
/* 3852 */     this.jButton7.setEnabled(false);
/* 3853 */     this.jButton8.setEnabled(false);
/* 3854 */     this.jButton10.setEnabled(false);
/* 3855 */     this.jButton11.setEnabled(false);
/*      */   }
/*      */   
/*      */   public void llenarCombos() {
/* 3859 */     String[] datos = this.con.regresaColIndex("nombre", "departamentos", "order by nombre");
/* 3860 */     this.jComboBox2.removeAllItems();
/* 3861 */     this.jComboBox8.removeAllItems();
/* 3862 */     this.jComboBox2.addItem("<GENERAL>");
/* 3863 */     this.jComboBox8.addItem("<GENERAL>"); int i;
/* 3864 */     for (i = 0; i < datos.length; i++) {
/* 3865 */       this.jComboBox2.addItem(datos[i]);
/* 3866 */       this.jComboBox8.addItem(datos[i]);
/*      */     } 
/*      */ 
/*      */     
/* 3870 */     datos = this.con.regresaColIndex("nombre_usu", "usuarios", "order by nombre_usu");
/* 3871 */     this.jComboBox3.removeAllItems();
/* 3872 */     this.jComboBox3.addItem("<GENERAL>");
/* 3873 */     for (i = 0; i < datos.length; i++) {
/* 3874 */       this.jComboBox3.addItem(datos[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public synchronized void eliminarColumna(int origen, int destino, String nombreCol) {
/* 3879 */     int cont = this.jTable6.getRowCount();
/* 3880 */     String[] registros = new String[cont]; int i;
/* 3881 */     for (i = 0; i < cont; i++) {
/* 3882 */       registros[i] = this.jTable6.getValueAt(i, destino).toString();
/*      */     }
/* 3884 */     for (i = 0; i < cont; i++) {
/* 3885 */       registros[i] = registros[i] + " " + registros[i];
/* 3886 */       this.jTable6.setValueAt(registros[i], i, destino);
/*      */     } 
/* 3888 */     TableColumn columna = this.jTable6.getColumn(nombreCol);
/* 3889 */     this.jTable6.removeColumn(columna);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 3893 */     String consulta = "";
/* 3894 */     String campos = "";
/* 3895 */     String tabla = "";
/* 3896 */     String num_ope = this.jTextField9.getText();
/* 3897 */     int nCampos = 0;
/* 3898 */     String[] visualizar = null;
/* 3899 */     this.jButton20.setEnabled(false);
/* 3900 */     String tipo = "";
/* 3901 */     String depa = "";
/* 3902 */     if (this.jRadioButton1.isSelected()) {
/* 3903 */       if (this.jComboBox7.getSelectedIndex() == 0) {
/* 3904 */         tipo = "EMPLEADO";
/*      */       }
/* 3906 */       else if (this.jComboBox7.getSelectedIndex() == 1) {
/* 3907 */         tipo = "FUNCIONARIO";
/*      */       } else {
/*      */         
/* 3910 */         tipo = "";
/*      */       } 
/*      */       
/* 3913 */       if (this.jComboBox8.getSelectedIndex() != 0) {
/* 3914 */         depa = String.valueOf(this.jComboBox8.getSelectedItem());
/*      */       }
/*      */       
/* 3917 */       nCampos = 6;
/* 3918 */       consulta = "where empleados.clave_depa = departamentos.clave_depa and tipoEmp like '%" + tipo + "%' and departamentos.nombre like '%" + depa + "%' and clave_emp like '%" + num_ope + "%' and empleados.nombre like '%" + this.jTextField10.getText() + "%' and actual=0 and clave_emp<>0 order by empleados.nombre";
/* 3919 */       campos = "clave_emp,empleados.nombre,ap_pat,ap_mat,Ultimoingreso,departamentos.nombre";
/* 3920 */       tabla = "empleados,departamentos";
/* 3921 */       visualizar = new String[] { "Clave", "Nombre Completo", "Paterno", "Materno", "Fecha de Ingreso", "Departamento" };
/*      */     } else {
/*      */       
/* 3924 */       nCampos = 5;
/* 3925 */       this.jComboBox8.setSelectedIndex(0);
/* 3926 */       this.jComboBox8.setEnabled(true);
/*      */       
/* 3928 */       if (this.jComboBox7.getSelectedIndex() == 0) {
/* 3929 */         tipo = "OPERADOR";
/*      */       }
/* 3931 */       else if (this.jComboBox7.getSelectedIndex() == 1) {
/* 3932 */         tipo = "FUNCIONARIO";
/*      */       } else {
/*      */         
/* 3935 */         tipo = "";
/*      */       } 
/*      */       
/* 3938 */       consulta = "where tipoTrabajador like '%" + tipo + "%' and num_ope like '%" + num_ope + "%' and nombre like '%" + this.jTextField10.getText() + "%' and actual=0 and num_ope<>0 order by nombre";
/* 3939 */       campos = "num_ope,nombre,ap_pat,ap_mat,UltimaFechaIngreso";
/* 3940 */       tabla = "operadores";
/* 3941 */       System.out.println("Consulta ---> " + campos + " " + tabla + " " + consulta);
/* 3942 */       visualizar = new String[] { "Clave", "Nombre Completo", "Paterno", "Materno", "Fecha de Ingreso" };
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 3947 */     this.jTable6.setModel(new DefaultTableModel((Object[][])this.con
/* 3948 */           .buscarDatos(nCampos, campos, tabla, consulta), (Object[])visualizar)
/*      */         {
/*      */           
/* 3951 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3955 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3958 */     eliminarColumna(2, 1, "Paterno");
/* 3959 */     eliminarColumna(2, 1, "Materno");
/*      */     
/* 3961 */     this.jTable6.setShowVerticalLines(false);
/* 3962 */     this.jScrollPane6.setViewportView(this.jTable6);
/* 3963 */     this.jTable6.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 3964 */     this.jTable6.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     
/* 3966 */     this.jTable6.setSelectionMode(0);
/* 3967 */     this.jTable6.setAutoCreateRowSorter(true);
/* 3968 */     this.jTable6.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 3970 */     this.jTable6.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 3971 */     this.jTable6.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 3972 */     this.jTable6.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 3973 */     if (this.jRadioButton1.isSelected())
/* 3974 */       this.jTable6.getColumnModel().getColumn(3).setCellRenderer(this.celda); 
/*      */   }
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3980 */       setEnabled((table == null || table.isEnabled()));
/* 3981 */       if (row % 2 == 0) {
/* 3982 */         setBackground(new Color(194, 213, 151));
/* 3983 */         setForeground(Color.black);
/*      */       } else {
/*      */         
/* 3986 */         setForeground(Color.black);
/* 3987 */         setBackground((Color)null);
/*      */       } 
/* 3989 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3990 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer {
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 3996 */       setEnabled((table == null || table.isEnabled()));
/* 3997 */       setHorizontalAlignment(4);
/* 3998 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 3999 */       return this;
/*      */     } }
/*      */   public class CeldaRender3 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2; String[] indices3; String[] indices4; String[] indices5;
/*      */     
/*      */     public CeldaRender3() {
/* 4004 */       this.otro = -1;
/* 4005 */       this.indices = new String[0];
/* 4006 */       this.indices2 = new String[0];
/* 4007 */       this.indices3 = new String[0];
/* 4008 */       this.indices4 = new String[0];
/* 4009 */       this.indices5 = new String[0];
/*      */     } public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4011 */       setEnabled((table == null || table.isEnabled()));
/* 4012 */       String comp = String.valueOf(table.getValueAt(row, 1));
/* 4013 */       if (comparar2(comp)) {
/* 4014 */         setBackground(new Color(153, 102, 0));
/* 4015 */         setForeground(Color.WHITE);
/*      */       }
/* 4017 */       else if (comparar3(comp)) {
/* 4018 */         setBackground(new Color(102, 153, 255));
/* 4019 */         setForeground(Color.BLUE);
/*      */       }
/* 4021 */       else if (comparar4(comp)) {
/* 4022 */         setBackground(Color.LIGHT_GRAY);
/* 4023 */         setForeground(Color.RED);
/*      */       }
/* 4025 */       else if (comparar5(comp)) {
/* 4026 */         setBackground(Color.RED);
/* 4027 */         setForeground(Color.WHITE);
/*      */       } else {
/*      */         
/* 4030 */         setBackground((Color)null);
/* 4031 */         setForeground(Color.black);
/*      */       } 
/* 4033 */       if (column == 6) {
/* 4034 */         setHorizontalAlignment(4);
/*      */       } else {
/*      */         
/* 4037 */         setHorizontalAlignment(10);
/*      */       } 
/*      */       
/* 4040 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4041 */       return this;
/*      */     }
/*      */     public void pasarInd(String[] ind) {
/* 4044 */       this.indices = ind;
/*      */     }
/*      */     public void pasarInd2(String[] ind) {
/* 4047 */       this.indices2 = ind;
/*      */     }
/*      */     public void pasarInd3(String[] ind) {
/* 4050 */       this.indices3 = ind;
/*      */     }
/*      */     public void pasarInd4(String[] ind) {
/* 4053 */       this.indices4 = ind;
/*      */     }
/*      */     public void pasarInd5(String[] ind) {
/* 4056 */       this.indices5 = ind;
/*      */     }
/*      */     public boolean comparar(String reg) {
/* 4059 */       for (int i = 0; i < this.indices.length; i++) {
/* 4060 */         if (this.indices[i].equals(reg)) {
/* 4061 */           return true;
/*      */         }
/*      */       } 
/* 4064 */       return false;
/*      */     }
/*      */     public boolean comparar2(String reg) {
/* 4067 */       for (int i = 0; i < this.indices2.length; i++) {
/* 4068 */         if (this.indices2[i].equals(reg)) {
/* 4069 */           return true;
/*      */         }
/*      */       } 
/* 4072 */       return false;
/*      */     }
/*      */     public boolean comparar3(String reg) {
/* 4075 */       for (int i = 0; i < this.indices3.length; i++) {
/* 4076 */         if (this.indices3[i].equals(reg)) {
/* 4077 */           return true;
/*      */         }
/*      */       } 
/* 4080 */       return false;
/*      */     }
/*      */     public boolean comparar4(String reg) {
/* 4083 */       for (int i = 0; i < this.indices4.length; i++) {
/* 4084 */         if (this.indices4[i].equals(reg)) {
/* 4085 */           return true;
/*      */         }
/*      */       } 
/* 4088 */       return false;
/*      */     }
/*      */     public boolean comparar5(String reg) {
/* 4091 */       for (int i = 0; i < this.indices5.length; i++) {
/* 4092 */         if (this.indices5[i].equals(reg)) {
/* 4093 */           return true;
/*      */         }
/*      */       } 
/* 4096 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   public class ImprimirVacaciones implements Printable {
/* 4101 */     String[] DATOS = new String[] { "Datos1", "Datos2", "Datos3", "Datos4", "Datos5", "Datos6", "Datos7", "Datos8", "Datos9", "Datos10", "Datos11", "Datos12", "Datos13" };
/* 4102 */     int opc = 0;
/* 4103 */     Graphics2D g2 = null;
/* 4104 */     NumerosALetras letras = null;
/*      */     public void titulo() {
/* 4106 */       Font fuente = new Font("Dialog", 1, 11);
/* 4107 */       this.g2.setFont(fuente);
/*      */     }
/*      */     public void subtitulo() {
/* 4110 */       Font fuente = new Font("Dialog", 1, 9);
/* 4111 */       this.g2.setFont(fuente);
/*      */     }
/*      */     public void contenido() {
/* 4114 */       Font fuente = new Font("Dialog", 0, 9);
/* 4115 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/* 4118 */     public String dameMes(String mes) { String mesLetra = "";
/* 4119 */       if (mes.equals("01")) {
/* 4120 */         mesLetra = "Enero";
/*      */       }
/* 4122 */       else if (mes.equals("02")) {
/* 4123 */         mesLetra = "Febrero";
/*      */       }
/* 4125 */       else if (mes.equals("03")) {
/* 4126 */         mesLetra = "Marzo";
/*      */       }
/* 4128 */       else if (mes.equals("04")) {
/* 4129 */         mesLetra = "Abril";
/*      */       }
/* 4131 */       else if (mes.equals("05")) {
/* 4132 */         mesLetra = "Mayo";
/*      */       }
/* 4134 */       else if (mes.equals("06")) {
/* 4135 */         mesLetra = "Junio";
/*      */       }
/* 4137 */       else if (mes.equals("07")) {
/* 4138 */         mesLetra = "Julio";
/*      */       }
/* 4140 */       else if (mes.equals("08")) {
/* 4141 */         mesLetra = "Agosto";
/*      */       }
/* 4143 */       else if (mes.equals("09")) {
/* 4144 */         mesLetra = "Septiembre";
/*      */       }
/* 4146 */       else if (mes.equals("10")) {
/* 4147 */         mesLetra = "Octubre";
/*      */       }
/* 4149 */       else if (mes.equals("11")) {
/* 4150 */         mesLetra = "Noviembre";
/*      */       }
/* 4152 */       else if (mes.equals("12")) {
/* 4153 */         mesLetra = "Diciembre";
/*      */       } 
/* 4155 */       return mesLetra; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen; Image img; SimpleDateFormat formato; String cadenaFecha1, año, mes, dia, mesLetra; ImageIcon tmpIcon; int y; double sumas, TOTAL; int i; boolean entra;
/*      */       String totalL;
/*      */       int j;
/* 4158 */       this.g2 = (Graphics2D)g;
/* 4159 */       f.setOrientation(0);
/* 4160 */       switch (pageIndex) {
/*      */         case 0:
/* 4162 */           fuente = new Font("Dialog", 0, 8);
/* 4163 */           this.g2.setFont(fuente);
/* 4164 */           this.g2.setColor(Color.BLACK);
/* 4165 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 4166 */           img = imagen.getImage();
/* 4167 */           this.g2.drawImage(img, 690, 17, 60, 60, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4173 */           fuente = new Font("Times New Roman", 1, 16);
/* 4174 */           this.g2.setFont(fuente);
/* 4175 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 225, 50);
/* 4176 */           fuente = new Font("Dialog", 0, 13);
/* 4177 */           this.g2.setFont(fuente);
/* 4178 */           this.g2.drawString("PAGO DE VACACIONES", 325, 65);
/* 4179 */           this.g2.drawLine(25, 78, 760, 78);
/*      */           
/* 4181 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4182 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser10.getDate());
/*      */           
/* 4184 */           año = cadenaFecha1.substring(0, 4);
/* 4185 */           mes = cadenaFecha1.substring(4, 6);
/* 4186 */           dia = cadenaFecha1.substring(6, 8);
/* 4187 */           mesLetra = dameMes(mes);
/*      */           
/* 4189 */           fuente = new Font("Dialog", 0, 11);
/* 4190 */           this.g2.setFont(fuente);
/* 4191 */           this.g2.drawString("FECHA:", 80, 76);
/* 4192 */           this.g2.drawString("BASE:", 585, 76);
/*      */           
/* 4194 */           fuente = new Font("Dialog", 1, 11);
/* 4195 */           this.g2.setFont(fuente);
/* 4196 */           this.g2.drawString(dia + "/" + dia + "/" + mesLetra, 125, 76);
/*      */           
/* 4198 */           this.g2.drawString(Vacaciones.this.base, 630, 76);
/*      */ 
/*      */           
/* 4201 */           this.g2.setColor(new Color(56, 93, 138));
/* 4202 */           this.g2.drawRoundRect(25, 84, 57, 71, 10, 10);
/*      */           
/* 4204 */           tmpIcon = null;
/* 4205 */           if (Vacaciones.this.jRadioButton1.isSelected()) {
/* 4206 */             tmpIcon = new ImageIcon(Vacaciones.this.CONFIG[0] + "/" + Vacaciones.this.CONFIG[0] + ".png");
/*      */           } else {
/*      */             
/* 4209 */             tmpIcon = new ImageIcon(Vacaciones.this.CONFIG[1] + "/" + Vacaciones.this.CONFIG[1] + ".png");
/*      */           } 
/*      */           
/* 4212 */           img = tmpIcon.getImage();
/* 4213 */           this.g2.drawImage(img, 27, 87, 53, 65, null);
/*      */           
/* 4215 */           this.g2.setColor(Color.BLACK);
/* 4216 */           contenido();
/* 4217 */           this.g2.drawString("CVE EMP: ", 95, 102);
/* 4218 */           this.g2.drawString("NOMBRE: ", 220, 102);
/* 4219 */           this.g2.drawString("DEPTO   :", 585, 102);
/*      */           
/* 4221 */           subtitulo();
/* 4222 */           this.g2.drawString(Vacaciones.this.CLAVE, 145, 102);
/* 4223 */           this.g2.drawString(Vacaciones.this.jTextField5.getText(), 314, 102);
/* 4224 */           this.g2.drawString(String.valueOf(Vacaciones.this.jComboBox6.getSelectedItem()), 630, 102);
/*      */           
/* 4226 */           contenido();
/* 4227 */           this.g2.drawString("INGRESO: ", 95, 117);
/* 4228 */           this.g2.drawString("BASE VACACIONES: ", 220, 117);
/* 4229 */           this.g2.drawString("PERIODO: ", 584, 117);
/* 4230 */           this.g2.drawString("_________", 314, 118);
/* 4231 */           this.g2.drawString("_________", 370, 118);
/* 4232 */           this.g2.drawString("__________", 426, 118);
/*      */           
/* 4234 */           subtitulo();
/* 4235 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4236 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser9.getDate());
/* 4237 */           año = cadenaFecha1.substring(0, 4);
/* 4238 */           mes = cadenaFecha1.substring(4, 6);
/* 4239 */           dia = cadenaFecha1.substring(6, 8);
/* 4240 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 145, 117);
/*      */           
/* 4242 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4243 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser7.getDate());
/* 4244 */           año = cadenaFecha1.substring(0, 4);
/* 4245 */           mes = cadenaFecha1.substring(4, 6);
/* 4246 */           dia = cadenaFecha1.substring(6, 8);
/* 4247 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 314, 117);
/*      */           
/* 4249 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4250 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser8.getDate());
/* 4251 */           año = cadenaFecha1.substring(0, 4);
/* 4252 */           mes = cadenaFecha1.substring(4, 6);
/* 4253 */           dia = cadenaFecha1.substring(6, 8);
/* 4254 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 370, 117);
/* 4255 */           this.g2.drawString(Vacaciones.this.jTextField4.getText(), 442, 117);
/* 4256 */           this.g2.drawString(String.valueOf(Vacaciones.this.jComboBox5.getSelectedItem()), 630, 117);
/*      */           
/* 4258 */           fuente = new Font("Dialog", 2, 8);
/* 4259 */           this.g2.setFont(fuente);
/* 4260 */           this.g2.drawString("Inicio", 328, 127);
/* 4261 */           this.g2.drawString("Fin", 387, 127);
/* 4262 */           this.g2.drawString("Días Derecho", 425, 127);
/*      */           
/* 4264 */           this.g2.setColor(new Color(204, 0, 0));
/* 4265 */           this.g2.fillRect(25, 160, 735, 10);
/* 4266 */           this.g2.drawRect(25, 170, 734, 25);
/* 4267 */           this.g2.drawLine(165, 161, 165, 195);
/* 4268 */           this.g2.drawLine(255, 161, 255, 195);
/* 4269 */           this.g2.drawLine(345, 161, 345, 195);
/* 4270 */           this.g2.drawLine(435, 161, 435, 195);
/* 4271 */           this.g2.drawLine(525, 161, 525, 195);
/* 4272 */           this.g2.drawLine(615, 161, 615, 195);
/* 4273 */           this.g2.setColor(Color.BLACK);
/* 4274 */           fuente = new Font("Dialog", 2, 9);
/* 4275 */           this.g2.drawString("CONCEPTO", 70, 186);
/* 4276 */           this.g2.drawString("DÍAS POR LEY", 185, 186);
/* 4277 */           this.g2.drawString("DÍAS DEL AÑO", 273, 186);
/* 4278 */           this.g2.drawString("FACTOR EN DÍAS", 358, 186);
/* 4279 */           this.g2.drawString("SUBTOTAL EN DÍAS", 441, 186);
/* 4280 */           this.g2.drawString("SALARIO DIARIO", 538, 186);
/* 4281 */           this.g2.drawString("IMPORTE", 672, 186);
/*      */           
/* 4283 */           subtitulo();
/* 4284 */           y = 207;
/* 4285 */           sumas = 0.0D;
/* 4286 */           TOTAL = 0.0D;
/* 4287 */           for (i = 0; i < Vacaciones.this.jTable1.getRowCount(); i++) {
/* 4288 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable1.getValueAt(i, 0)), 27, y);
/* 4289 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable1.getValueAt(i, 1)), 210, y);
/* 4290 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable1.getValueAt(i, 2)), 293, y);
/* 4291 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable1.getValueAt(i, 3)), 375, y);
/* 4292 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable1.getValueAt(i, 4)), 465, y);
/* 4293 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable1.getValueAt(i, 5)), 552, y);
/* 4294 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable1.getValueAt(i, 6)), Vacaciones.this.alinearDer(720, Vacaciones.this.jTable1.getValueAt(i, 6).toString().length()), y);
/*      */             
/* 4296 */             String canti = String.valueOf(Vacaciones.this.jTable1.getValueAt(i, 6));
/* 4297 */             String valorP = "";
/* 4298 */             for (int k = 0; k < canti.length(); k++) {
/* 4299 */               if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 4300 */                 valorP = valorP + valorP;
/*      */               }
/*      */             } 
/* 4303 */             sumas += Double.parseDouble(valorP);
/* 4304 */             y += 14;
/*      */           } 
/* 4306 */           TOTAL = sumas;
/* 4307 */           this.g2.setColor(Color.WHITE);
/* 4308 */           fuente = new Font("Dialog", 1, 8);
/* 4309 */           this.g2.setFont(fuente);
/* 4310 */           this.g2.drawString("CÁLCULO VACACIONAL", 350, 168);
/*      */           
/* 4312 */           this.g2.setColor(Color.BLACK);
/* 4313 */           subtitulo();
/* 4314 */           Vacaciones.this.cantidad.setValue(Double.valueOf(sumas));
/* 4315 */           this.g2.drawString(Vacaciones.this.cantidad.getText(), Vacaciones.this.alinearDer(720, Vacaciones.this.cantidad.getText().length()), 234);
/*      */           
/* 4317 */           contenido();
/* 4318 */           this.g2.drawString("__________________", 640, 223);
/* 4319 */           this.g2.drawString("__________________", 640, 224);
/* 4320 */           this.g2.drawString("SUBTOTAL VACACIONES", 515, 234);
/*      */           
/* 4322 */           this.g2.setColor(new Color(204, 0, 0));
/* 4323 */           this.g2.fillRect(25, 265, 735, 10);
/* 4324 */           this.g2.drawRect(25, 275, 734, 25);
/* 4325 */           this.g2.drawLine(70, 266, 70, 300);
/* 4326 */           this.g2.drawLine(615, 266, 615, 300);
/*      */           
/* 4328 */           this.g2.setColor(Color.BLACK);
/* 4329 */           fuente = new Font("Dialog", 2, 9);
/* 4330 */           this.g2.setFont(fuente);
/* 4331 */           this.g2.drawString("NÚM", 35, 291);
/* 4332 */           this.g2.drawString("CONCEPTO", 340, 291);
/* 4333 */           this.g2.drawString("IMPORTE", 672, 291);
/*      */           
/* 4335 */           this.g2.setColor(Color.WHITE);
/* 4336 */           fuente = new Font("Dialog", 1, 8);
/* 4337 */           this.g2.setFont(fuente);
/* 4338 */           this.g2.drawString("DESCUENTOS", 368, 273);
/* 4339 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 4341 */           subtitulo();
/* 4342 */           y = 312;
/* 4343 */           sumas = 0.0D;
/* 4344 */           entra = false;
/* 4345 */           if (Vacaciones.this.jTable4.getRowCount() > 0) {
/* 4346 */             for (int k = 0; k < Vacaciones.this.jTable4.getRowCount(); k++) {
/* 4347 */               this.g2.drawString("" + k + 1, 45, y);
/* 4348 */               this.g2.drawString(String.valueOf(Vacaciones.this.jTable4.getValueAt(k, 0)), 75, y);
/* 4349 */               this.g2.drawString(String.valueOf(Vacaciones.this.jTable4.getValueAt(k, 1)), Vacaciones.this.alinearDer(720, Vacaciones.this.jTable4.getValueAt(k, 1).toString().length()), y);
/*      */               
/* 4351 */               String canti = String.valueOf(Vacaciones.this.jTable4.getValueAt(k, 1));
/* 4352 */               String valorP = "";
/* 4353 */               for (int m = 0; m < canti.length(); m++) {
/* 4354 */                 if (canti.charAt(m) != '$' && canti.charAt(m) != ',') {
/* 4355 */                   valorP = valorP + valorP;
/*      */                 }
/*      */               } 
/* 4358 */               sumas += Double.parseDouble(valorP);
/* 4359 */               y += 14;
/* 4360 */               entra = true;
/*      */             } 
/*      */           } else {
/*      */             
/* 4364 */             this.g2.drawString("NO SE REGISTRARON DESCUENTOS PARA ESTE CÁLCULO...", 30, y);
/*      */           } 
/* 4366 */           if (entra) {
/* 4367 */             y -= 14;
/*      */           }
/* 4369 */           TOTAL -= sumas;
/* 4370 */           contenido();
/* 4371 */           Vacaciones.this.cantidad.setValue(Double.valueOf(sumas));
/* 4372 */           this.g2.drawString("__________________", 640, y + 2);
/* 4373 */           this.g2.drawString("__________________", 640, y + 3);
/* 4374 */           this.g2.drawString("SUBTOTAL DESCUENTOS", 515, y + 13);
/*      */           
/* 4376 */           subtitulo();
/* 4377 */           this.g2.drawString(Vacaciones.this.cantidad.getText(), Vacaciones.this.alinearDer(720, Vacaciones.this.cantidad.getText().length()), y + 13);
/*      */           
/* 4379 */           this.g2.setColor(new Color(204, 0, 0));
/* 4380 */           this.g2.fillRect(690, 450, 70, 10);
/* 4381 */           this.g2.drawRect(25, 460, 734, 35);
/*      */           
/* 4383 */           this.g2.setColor(Color.WHITE);
/* 4384 */           fuente = new Font("Dialog", 0, 7);
/* 4385 */           this.g2.setFont(fuente);
/* 4386 */           this.g2.drawString("TOTAL EN LETRA", 695, 458);
/*      */           
/* 4388 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 4390 */           Vacaciones.this.numLetra = new NumerosALetras(TOTAL, "MXN");
/* 4391 */           subtitulo();
/* 4392 */           totalL = "  (" + Vacaciones.this.numLetra.regresaNumero() + ")";
/* 4393 */           this.g2.drawString(totalL, Vacaciones.this.alinearDer(680, totalL.length()), 490);
/* 4394 */           this.g2.drawString(Vacaciones.this.jLabel19.getText(), Vacaciones.this.alinearDer(720, Vacaciones.this.jLabel19.getText().length()), 475);
/*      */           
/* 4396 */           this.g2.drawRect(25, 500, 734, 10);
/* 4397 */           this.g2.drawRect(25, 510, 734, 50);
/* 4398 */           this.g2.drawLine(460, 500, 460, 560);
/* 4399 */           this.g2.drawLine(610, 500, 610, 560);
/*      */           
/* 4401 */           fuente = new Font("Dialog", 1, 9);
/* 4402 */           this.g2.setFont(fuente);
/* 4403 */           this.g2.drawString("Firma y Huellas del Trabajador", 175, 508);
/* 4404 */           this.g2.drawString("Firma de Testigos", 494, 508);
/* 4405 */           this.g2.drawString("Firma de Autorizado", 642, 508);
/*      */           
/* 4407 */           fuente = new Font("Dialog", 0, 7);
/* 4408 */           this.g2.setFont(fuente);
/* 4409 */           this.g2.drawString("COMPLEMENTO", 25, 570);
/* 4410 */           this.g2.drawString(Vacaciones.this.jTextField6.getText(), 727, 570);
/*      */           
/* 4412 */           return 0;
/*      */         case 1:
/* 4414 */           fuente = new Font("Dialog", 0, 8);
/* 4415 */           this.g2.setFont(fuente);
/* 4416 */           this.g2.setColor(Color.BLACK);
/* 4417 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 4418 */           img = imagen.getImage();
/* 4419 */           this.g2.drawImage(img, 690, 17, 60, 60, null);
/*      */           
/* 4421 */           fuente = new Font("Times New Roman", 1, 16);
/* 4422 */           this.g2.setFont(fuente);
/* 4423 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 225, 40);
/* 4424 */           fuente = new Font("Dialog", 0, 13);
/* 4425 */           this.g2.setFont(fuente);
/* 4426 */           this.g2.drawString("PAGO DE VACACIONES", 325, 55);
/* 4427 */           this.g2.drawLine(25, 78, 760, 78);
/*      */           
/* 4429 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4430 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser10.getDate());
/*      */           
/* 4432 */           año = cadenaFecha1.substring(0, 4);
/* 4433 */           mes = cadenaFecha1.substring(4, 6);
/* 4434 */           dia = cadenaFecha1.substring(6, 8);
/* 4435 */           mesLetra = dameMes(mes);
/*      */           
/* 4437 */           fuente = new Font("Dialog", 0, 11);
/* 4438 */           this.g2.setFont(fuente);
/* 4439 */           this.g2.drawString("FECHA:", 80, 76);
/* 4440 */           this.g2.drawString("BASE:", 585, 76);
/*      */           
/* 4442 */           fuente = new Font("Dialog", 1, 11);
/* 4443 */           this.g2.setFont(fuente);
/* 4444 */           this.g2.drawString(dia + "/" + dia + "/" + mesLetra, 125, 76);
/*      */           
/* 4446 */           this.g2.drawString(Vacaciones.this.base, 630, 76);
/*      */ 
/*      */           
/* 4449 */           this.g2.setColor(new Color(56, 93, 138));
/* 4450 */           this.g2.drawRoundRect(25, 84, 57, 71, 10, 10);
/*      */           
/* 4452 */           tmpIcon = null;
/* 4453 */           if (Vacaciones.this.jRadioButton1.isSelected()) {
/* 4454 */             tmpIcon = new ImageIcon(Vacaciones.this.CONFIG[0] + "/" + Vacaciones.this.CONFIG[0] + ".png");
/*      */           } else {
/*      */             
/* 4457 */             tmpIcon = new ImageIcon(Vacaciones.this.CONFIG[1] + "/" + Vacaciones.this.CONFIG[1] + ".png");
/*      */           } 
/*      */           
/* 4460 */           img = tmpIcon.getImage();
/* 4461 */           this.g2.drawImage(img, 27, 87, 53, 65, null);
/*      */           
/* 4463 */           this.g2.setColor(Color.BLACK);
/* 4464 */           contenido();
/* 4465 */           this.g2.drawString("CVE EMP: ", 95, 102);
/* 4466 */           this.g2.drawString("NOMBRE: ", 220, 102);
/* 4467 */           this.g2.drawString("DEPTO   :", 585, 102);
/*      */           
/* 4469 */           subtitulo();
/* 4470 */           this.g2.drawString(Vacaciones.this.CLAVE, 145, 102);
/* 4471 */           this.g2.drawString(Vacaciones.this.jTextField5.getText(), 314, 102);
/* 4472 */           this.g2.drawString(String.valueOf(Vacaciones.this.jComboBox6.getSelectedItem()), 630, 102);
/*      */           
/* 4474 */           contenido();
/* 4475 */           this.g2.drawString("INGRESO: ", 95, 117);
/* 4476 */           this.g2.drawString("BASE VACACIONES: ", 220, 117);
/* 4477 */           this.g2.drawString("PERIODO: ", 584, 117);
/* 4478 */           this.g2.drawString("_________", 314, 118);
/* 4479 */           this.g2.drawString("_________", 370, 118);
/* 4480 */           this.g2.drawString("__________", 426, 118);
/*      */           
/* 4482 */           subtitulo();
/* 4483 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4484 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser9.getDate());
/* 4485 */           año = cadenaFecha1.substring(0, 4);
/* 4486 */           mes = cadenaFecha1.substring(4, 6);
/* 4487 */           dia = cadenaFecha1.substring(6, 8);
/* 4488 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 145, 117);
/*      */           
/* 4490 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4491 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser7.getDate());
/* 4492 */           año = cadenaFecha1.substring(0, 4);
/* 4493 */           mes = cadenaFecha1.substring(4, 6);
/* 4494 */           dia = cadenaFecha1.substring(6, 8);
/* 4495 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 314, 117);
/*      */           
/* 4497 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4498 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser8.getDate());
/* 4499 */           año = cadenaFecha1.substring(0, 4);
/* 4500 */           mes = cadenaFecha1.substring(4, 6);
/* 4501 */           dia = cadenaFecha1.substring(6, 8);
/* 4502 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 370, 117);
/* 4503 */           this.g2.drawString(Vacaciones.this.jTextField4.getText(), 442, 117);
/* 4504 */           this.g2.drawString(String.valueOf(Vacaciones.this.jComboBox5.getSelectedItem()), 630, 117);
/*      */           
/* 4506 */           fuente = new Font("Dialog", 2, 8);
/* 4507 */           this.g2.setFont(fuente);
/* 4508 */           this.g2.drawString("Inicio", 328, 127);
/* 4509 */           this.g2.drawString("Fin", 387, 127);
/* 4510 */           this.g2.drawString("Días Derecho", 425, 127);
/*      */           
/* 4512 */           this.g2.setColor(new Color(204, 0, 0));
/* 4513 */           this.g2.fillRect(25, 160, 735, 10);
/* 4514 */           this.g2.drawRect(25, 170, 734, 25);
/* 4515 */           this.g2.drawLine(165, 161, 165, 195);
/* 4516 */           this.g2.drawLine(255, 161, 255, 195);
/* 4517 */           this.g2.drawLine(345, 161, 345, 195);
/* 4518 */           this.g2.drawLine(435, 161, 435, 195);
/* 4519 */           this.g2.drawLine(525, 161, 525, 195);
/* 4520 */           this.g2.drawLine(615, 161, 615, 195);
/* 4521 */           this.g2.setColor(Color.BLACK);
/* 4522 */           fuente = new Font("Dialog", 2, 9);
/* 4523 */           this.g2.drawString("CONCEPTO", 70, 186);
/* 4524 */           this.g2.drawString("DÍAS POR LEY", 185, 186);
/* 4525 */           this.g2.drawString("DÍAS DEL AÑO", 273, 186);
/* 4526 */           this.g2.drawString("FACTOR EN DÍAS", 358, 186);
/* 4527 */           this.g2.drawString("SUBTOTAL EN DÍAS", 441, 186);
/* 4528 */           this.g2.drawString("SALARIO DIARIO", 538, 186);
/* 4529 */           this.g2.drawString("IMPORTE", 672, 186);
/*      */           
/* 4531 */           subtitulo();
/* 4532 */           y = 207;
/* 4533 */           sumas = 0.0D;
/* 4534 */           TOTAL = 0.0D;
/* 4535 */           for (j = 0; j < Vacaciones.this.jTable2.getRowCount(); j++) {
/* 4536 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(j, 0)), 27, y);
/* 4537 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(j, 1)), 210, y);
/* 4538 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(j, 2)), 293, y);
/* 4539 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(j, 3)), 375, y);
/* 4540 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(j, 4)), 465, y);
/* 4541 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(j, 5)), 552, y);
/* 4542 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(j, 6)), Vacaciones.this.alinearDer(720, Vacaciones.this.jTable2.getValueAt(j, 6).toString().length()), y);
/*      */             
/* 4544 */             String canti = String.valueOf(Vacaciones.this.jTable2.getValueAt(j, 6));
/* 4545 */             String valorP = "";
/* 4546 */             for (int k = 0; k < canti.length(); k++) {
/* 4547 */               if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 4548 */                 valorP = valorP + valorP;
/*      */               }
/*      */             } 
/* 4551 */             sumas += Double.parseDouble(valorP);
/* 4552 */             y += 14;
/*      */           } 
/* 4554 */           TOTAL = sumas;
/* 4555 */           this.g2.setColor(Color.WHITE);
/* 4556 */           fuente = new Font("Dialog", 1, 8);
/* 4557 */           this.g2.setFont(fuente);
/* 4558 */           this.g2.drawString("CÁLCULO VACACIONAL", 350, 168);
/*      */           
/* 4560 */           this.g2.setColor(Color.BLACK);
/* 4561 */           subtitulo();
/* 4562 */           Vacaciones.this.cantidad.setValue(Double.valueOf(sumas));
/* 4563 */           this.g2.drawString(Vacaciones.this.cantidad.getText(), Vacaciones.this.alinearDer(720, Vacaciones.this.cantidad.getText().length()), 234);
/*      */           
/* 4565 */           contenido();
/* 4566 */           this.g2.drawString("__________________", 640, 223);
/* 4567 */           this.g2.drawString("__________________", 640, 224);
/* 4568 */           this.g2.drawString("SUBTOTAL VACACIONES", 515, 234);
/*      */           
/* 4570 */           this.g2.setColor(new Color(204, 0, 0));
/* 4571 */           this.g2.fillRect(25, 265, 735, 10);
/* 4572 */           this.g2.drawRect(25, 275, 734, 25);
/* 4573 */           this.g2.drawLine(70, 266, 70, 300);
/* 4574 */           this.g2.drawLine(615, 266, 615, 300);
/*      */           
/* 4576 */           this.g2.setColor(Color.BLACK);
/* 4577 */           fuente = new Font("Dialog", 2, 9);
/* 4578 */           this.g2.setFont(fuente);
/* 4579 */           this.g2.drawString("NÚM", 35, 291);
/* 4580 */           this.g2.drawString("CONCEPTO", 340, 291);
/* 4581 */           this.g2.drawString("IMPORTE", 672, 291);
/*      */           
/* 4583 */           this.g2.setColor(Color.WHITE);
/* 4584 */           fuente = new Font("Dialog", 1, 8);
/* 4585 */           this.g2.setFont(fuente);
/* 4586 */           this.g2.drawString("DESCUENTOS", 368, 273);
/* 4587 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 4589 */           subtitulo();
/* 4590 */           y = 312;
/* 4591 */           sumas = 0.0D;
/* 4592 */           entra = false;
/* 4593 */           if (Vacaciones.this.jTable5.getRowCount() > 0) {
/* 4594 */             for (j = 0; j < Vacaciones.this.jTable5.getRowCount(); j++) {
/* 4595 */               this.g2.drawString("" + j + 1, 45, y);
/* 4596 */               this.g2.drawString(String.valueOf(Vacaciones.this.jTable5.getValueAt(j, 0)), 75, y);
/* 4597 */               this.g2.drawString(String.valueOf(Vacaciones.this.jTable5.getValueAt(j, 1)), Vacaciones.this.alinearDer(720, Vacaciones.this.jTable5.getValueAt(j, 1).toString().length()), y);
/*      */               
/* 4599 */               String canti = String.valueOf(Vacaciones.this.jTable5.getValueAt(j, 1));
/* 4600 */               String valorP = "";
/* 4601 */               for (int k = 0; k < canti.length(); k++) {
/* 4602 */                 if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 4603 */                   valorP = valorP + valorP;
/*      */                 }
/*      */               } 
/* 4606 */               sumas += Double.parseDouble(valorP);
/* 4607 */               y += 14;
/* 4608 */               entra = true;
/*      */             } 
/*      */           } else {
/*      */             
/* 4612 */             this.g2.drawString("NO SE REGISTRARON DESCUENTOS PARA ESTE CÁLCULO...", 30, y);
/*      */           } 
/* 4614 */           if (entra) {
/* 4615 */             y -= 14;
/*      */           }
/* 4617 */           TOTAL -= sumas;
/* 4618 */           contenido();
/* 4619 */           Vacaciones.this.cantidad.setValue(Double.valueOf(sumas));
/* 4620 */           this.g2.drawString("__________________", 640, y + 2);
/* 4621 */           this.g2.drawString("__________________", 640, y + 3);
/* 4622 */           this.g2.drawString("SUBTOTAL DESCUENTOS", 515, y + 13);
/*      */           
/* 4624 */           subtitulo();
/* 4625 */           this.g2.drawString(Vacaciones.this.cantidad.getText(), Vacaciones.this.alinearDer(720, Vacaciones.this.cantidad.getText().length()), y + 13);
/*      */           
/* 4627 */           this.g2.setColor(new Color(204, 0, 0));
/* 4628 */           this.g2.fillRect(690, 450, 70, 10);
/* 4629 */           this.g2.drawRect(25, 460, 734, 35);
/*      */           
/* 4631 */           this.g2.setColor(Color.WHITE);
/* 4632 */           fuente = new Font("Dialog", 0, 7);
/* 4633 */           this.g2.setFont(fuente);
/* 4634 */           this.g2.drawString("TOTAL EN LETRA", 695, 458);
/*      */           
/* 4636 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 4638 */           Vacaciones.this.numLetra = new NumerosALetras(TOTAL, "MXN");
/* 4639 */           subtitulo();
/* 4640 */           totalL = "  (" + Vacaciones.this.numLetra.regresaNumero() + ")";
/* 4641 */           this.g2.drawString(totalL, Vacaciones.this.alinearDer(680, totalL.length()), 490);
/* 4642 */           this.g2.drawString(Vacaciones.this.jLabel21.getText(), Vacaciones.this.alinearDer(720, Vacaciones.this.jLabel21.getText().length()), 475);
/*      */           
/* 4644 */           this.g2.drawRect(25, 500, 734, 10);
/* 4645 */           this.g2.drawRect(25, 510, 734, 50);
/* 4646 */           this.g2.drawLine(460, 500, 460, 560);
/* 4647 */           this.g2.drawLine(610, 500, 610, 560);
/*      */           
/* 4649 */           fuente = new Font("Dialog", 1, 9);
/* 4650 */           this.g2.setFont(fuente);
/* 4651 */           this.g2.drawString("Firma y Huellas del Trabajador", 175, 508);
/* 4652 */           this.g2.drawString("Firma de Testigos", 494, 508);
/* 4653 */           this.g2.drawString("Firma de Autorizado", 642, 508);
/*      */           
/* 4655 */           fuente = new Font("Dialog", 0, 7);
/* 4656 */           this.g2.setFont(fuente);
/*      */           
/* 4658 */           this.g2.drawString(Vacaciones.this.jTextField6.getText(), 727, 570);
/* 4659 */           return 0;
/* 4660 */       }  return 1; }
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 4664 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 4665 */       job.setPrintable(this);
/*      */       
/* 4667 */       PageFormat pf = job.defaultPage();
/* 4668 */       Paper papel = pf.getPaper();
/* 4669 */       papel.setSize(612.0D, 792.0D);
/* 4670 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 4671 */       pf.setPaper(papel);
/* 4672 */       pf.setOrientation(0);
/* 4673 */       ImprimirVacaciones im = new ImprimirVacaciones();
/* 4674 */       job.setPrintable(im, pf);
/* 4675 */       job.defaultPage(pf);
/*      */       
/* 4677 */       boolean ok = job.printDialog();
/* 4678 */       if (ok)
/*      */         try {
/* 4680 */           job.print();
/*      */         }
/* 4682 */         catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirVacaciones2 implements Printable { String[] DATOS;
/*      */     int opc;
/*      */     Graphics2D g2;
/*      */     NumerosALetras letras;
/*      */     
/*      */     public ImprimirVacaciones2() {
/* 4690 */       this.DATOS = new String[] { "Datos1", "Datos2", "Datos3", "Datos4", "Datos5", "Datos6", "Datos7", "Datos8", "Datos9", "Datos10", "Datos11", "Datos12", "Datos13" };
/* 4691 */       this.opc = 0;
/* 4692 */       this.g2 = null;
/* 4693 */       this.letras = null;
/*      */     } public void titulo() {
/* 4695 */       Font fuente = new Font("Dialog", 1, 11);
/* 4696 */       this.g2.setFont(fuente);
/*      */     }
/*      */     public void subtitulo() {
/* 4699 */       Font fuente = new Font("Dialog", 1, 9);
/* 4700 */       this.g2.setFont(fuente);
/*      */     }
/*      */     public void contenido() {
/* 4703 */       Font fuente = new Font("Dialog", 0, 9);
/* 4704 */       this.g2.setFont(fuente);
/*      */     }
/*      */     
/* 4707 */     public String dameMes(String mes) { String mesLetra = "";
/* 4708 */       if (mes.equals("01")) {
/* 4709 */         mesLetra = "Enero";
/*      */       }
/* 4711 */       else if (mes.equals("02")) {
/* 4712 */         mesLetra = "Febrero";
/*      */       }
/* 4714 */       else if (mes.equals("03")) {
/* 4715 */         mesLetra = "Marzo";
/*      */       }
/* 4717 */       else if (mes.equals("04")) {
/* 4718 */         mesLetra = "Abril";
/*      */       }
/* 4720 */       else if (mes.equals("05")) {
/* 4721 */         mesLetra = "Mayo";
/*      */       }
/* 4723 */       else if (mes.equals("06")) {
/* 4724 */         mesLetra = "Junio";
/*      */       }
/* 4726 */       else if (mes.equals("07")) {
/* 4727 */         mesLetra = "Julio";
/*      */       }
/* 4729 */       else if (mes.equals("08")) {
/* 4730 */         mesLetra = "Agosto";
/*      */       }
/* 4732 */       else if (mes.equals("09")) {
/* 4733 */         mesLetra = "Septiembre";
/*      */       }
/* 4735 */       else if (mes.equals("10")) {
/* 4736 */         mesLetra = "Octubre";
/*      */       }
/* 4738 */       else if (mes.equals("11")) {
/* 4739 */         mesLetra = "Noviembre";
/*      */       }
/* 4741 */       else if (mes.equals("12")) {
/* 4742 */         mesLetra = "Diciembre";
/*      */       } 
/* 4744 */       return mesLetra; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; ImageIcon imagen; Image img; SimpleDateFormat formato; String cadenaFecha1, año, mes, dia, mesLetra; ImageIcon tmpIcon; int y; double sumas, TOTAL; int i;
/*      */       boolean entra;
/*      */       String totalL;
/* 4747 */       this.g2 = (Graphics2D)g;
/* 4748 */       f.setOrientation(0);
/* 4749 */       switch (pageIndex) {
/*      */         case 0:
/* 4751 */           fuente = new Font("Dialog", 0, 8);
/* 4752 */           this.g2.setFont(fuente);
/* 4753 */           this.g2.setColor(Color.BLACK);
/* 4754 */           imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 4755 */           img = imagen.getImage();
/* 4756 */           this.g2.drawImage(img, 690, 17, 60, 60, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4762 */           fuente = new Font("Times New Roman", 1, 16);
/* 4763 */           this.g2.setFont(fuente);
/* 4764 */           this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 225, 50);
/* 4765 */           fuente = new Font("Dialog", 0, 13);
/* 4766 */           this.g2.setFont(fuente);
/* 4767 */           this.g2.drawString("PAGO DE VACACIONES", 325, 65);
/* 4768 */           this.g2.drawLine(25, 78, 760, 78);
/*      */           
/* 4770 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4771 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser10.getDate());
/*      */           
/* 4773 */           año = cadenaFecha1.substring(0, 4);
/* 4774 */           mes = cadenaFecha1.substring(4, 6);
/* 4775 */           dia = cadenaFecha1.substring(6, 8);
/* 4776 */           mesLetra = dameMes(mes);
/*      */           
/* 4778 */           fuente = new Font("Dialog", 0, 11);
/* 4779 */           this.g2.setFont(fuente);
/* 4780 */           this.g2.drawString("FECHA:", 80, 76);
/* 4781 */           this.g2.drawString("BASE:", 585, 76);
/*      */           
/* 4783 */           fuente = new Font("Dialog", 1, 11);
/* 4784 */           this.g2.setFont(fuente);
/* 4785 */           this.g2.drawString(dia + "/" + dia + "/" + mesLetra, 125, 76);
/*      */           
/* 4787 */           this.g2.drawString(Vacaciones.this.base, 630, 76);
/*      */ 
/*      */           
/* 4790 */           this.g2.setColor(new Color(56, 93, 138));
/* 4791 */           this.g2.drawRoundRect(25, 84, 57, 71, 10, 10);
/*      */           
/* 4793 */           tmpIcon = null;
/* 4794 */           if (Vacaciones.this.jRadioButton1.isSelected()) {
/* 4795 */             tmpIcon = new ImageIcon(Vacaciones.this.CONFIG[0] + "/" + Vacaciones.this.CONFIG[0] + ".png");
/*      */           } else {
/*      */             
/* 4798 */             tmpIcon = new ImageIcon(Vacaciones.this.CONFIG[1] + "/" + Vacaciones.this.CONFIG[1] + ".png");
/*      */           } 
/*      */           
/* 4801 */           img = tmpIcon.getImage();
/* 4802 */           this.g2.drawImage(img, 27, 87, 53, 65, null);
/*      */           
/* 4804 */           this.g2.setColor(Color.BLACK);
/* 4805 */           contenido();
/* 4806 */           this.g2.drawString("CVE EMP: ", 95, 102);
/* 4807 */           this.g2.drawString("NOMBRE: ", 220, 102);
/* 4808 */           this.g2.drawString("DEPTO   :", 585, 102);
/*      */           
/* 4810 */           subtitulo();
/* 4811 */           this.g2.drawString(Vacaciones.this.CLAVE, 145, 102);
/* 4812 */           this.g2.drawString(Vacaciones.this.jTextField5.getText(), 314, 102);
/* 4813 */           this.g2.drawString(String.valueOf(Vacaciones.this.jComboBox6.getSelectedItem()), 630, 102);
/*      */           
/* 4815 */           contenido();
/* 4816 */           this.g2.drawString("INGRESO: ", 95, 117);
/* 4817 */           this.g2.drawString("BASE VACACIONES: ", 220, 117);
/* 4818 */           this.g2.drawString("PERIODO: ", 584, 117);
/* 4819 */           this.g2.drawString("_________", 314, 118);
/* 4820 */           this.g2.drawString("_________", 370, 118);
/* 4821 */           this.g2.drawString("__________", 426, 118);
/*      */           
/* 4823 */           subtitulo();
/* 4824 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4825 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser9.getDate());
/* 4826 */           año = cadenaFecha1.substring(0, 4);
/* 4827 */           mes = cadenaFecha1.substring(4, 6);
/* 4828 */           dia = cadenaFecha1.substring(6, 8);
/* 4829 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 145, 117);
/*      */           
/* 4831 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4832 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser7.getDate());
/* 4833 */           año = cadenaFecha1.substring(0, 4);
/* 4834 */           mes = cadenaFecha1.substring(4, 6);
/* 4835 */           dia = cadenaFecha1.substring(6, 8);
/* 4836 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 314, 117);
/*      */           
/* 4838 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4839 */           cadenaFecha1 = formato.format(Vacaciones.this.jDateChooser8.getDate());
/* 4840 */           año = cadenaFecha1.substring(0, 4);
/* 4841 */           mes = cadenaFecha1.substring(4, 6);
/* 4842 */           dia = cadenaFecha1.substring(6, 8);
/* 4843 */           this.g2.drawString(dia + "/" + dia + "/" + mes, 370, 117);
/* 4844 */           this.g2.drawString(Vacaciones.this.jTextField4.getText(), 442, 117);
/* 4845 */           this.g2.drawString(String.valueOf(Vacaciones.this.jComboBox5.getSelectedItem()), 630, 117);
/*      */           
/* 4847 */           fuente = new Font("Dialog", 2, 8);
/* 4848 */           this.g2.setFont(fuente);
/* 4849 */           this.g2.drawString("Inicio", 328, 127);
/* 4850 */           this.g2.drawString("Fin", 387, 127);
/* 4851 */           this.g2.drawString("Días Derecho", 425, 127);
/*      */           
/* 4853 */           this.g2.setColor(new Color(204, 0, 0));
/* 4854 */           this.g2.fillRect(25, 160, 735, 10);
/* 4855 */           this.g2.drawRect(25, 170, 734, 25);
/* 4856 */           this.g2.drawLine(165, 161, 165, 195);
/* 4857 */           this.g2.drawLine(255, 161, 255, 195);
/* 4858 */           this.g2.drawLine(345, 161, 345, 195);
/* 4859 */           this.g2.drawLine(435, 161, 435, 195);
/* 4860 */           this.g2.drawLine(525, 161, 525, 195);
/* 4861 */           this.g2.drawLine(615, 161, 615, 195);
/* 4862 */           this.g2.setColor(Color.BLACK);
/* 4863 */           fuente = new Font("Dialog", 2, 9);
/* 4864 */           this.g2.drawString("CONCEPTO", 70, 186);
/* 4865 */           this.g2.drawString("DÍAS POR LEY", 185, 186);
/* 4866 */           this.g2.drawString("DÍAS DEL AÑO", 273, 186);
/* 4867 */           this.g2.drawString("FACTOR EN DÍAS", 358, 186);
/* 4868 */           this.g2.drawString("SUBTOTAL EN DÍAS", 441, 186);
/* 4869 */           this.g2.drawString("SALARIO DIARIO", 538, 186);
/* 4870 */           this.g2.drawString("IMPORTE", 672, 186);
/*      */           
/* 4872 */           subtitulo();
/* 4873 */           y = 207;
/* 4874 */           sumas = 0.0D;
/* 4875 */           TOTAL = 0.0D;
/* 4876 */           for (i = 0; i < Vacaciones.this.jTable2.getRowCount(); i++) {
/* 4877 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(i, 0)), 27, y);
/* 4878 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(i, 1)), 210, y);
/* 4879 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(i, 2)), 293, y);
/* 4880 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(i, 3)), 375, y);
/* 4881 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(i, 4)), 465, y);
/* 4882 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(i, 5)), 552, y);
/* 4883 */             this.g2.drawString(String.valueOf(Vacaciones.this.jTable2.getValueAt(i, 6)), Vacaciones.this.alinearDer(720, Vacaciones.this.jTable2.getValueAt(i, 6).toString().length()), y);
/*      */             
/* 4885 */             String canti = String.valueOf(Vacaciones.this.jTable2.getValueAt(i, 6));
/* 4886 */             String valorP = "";
/* 4887 */             for (int j = 0; j < canti.length(); j++) {
/* 4888 */               if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4889 */                 valorP = valorP + valorP;
/*      */               }
/*      */             } 
/* 4892 */             sumas += Double.parseDouble(valorP);
/* 4893 */             y += 14;
/*      */           } 
/* 4895 */           TOTAL = sumas;
/* 4896 */           this.g2.setColor(Color.WHITE);
/* 4897 */           fuente = new Font("Dialog", 1, 8);
/* 4898 */           this.g2.setFont(fuente);
/* 4899 */           this.g2.drawString("CÁLCULO VACACIONAL", 350, 168);
/*      */           
/* 4901 */           this.g2.setColor(Color.BLACK);
/* 4902 */           subtitulo();
/* 4903 */           Vacaciones.this.cantidad.setValue(Double.valueOf(sumas));
/* 4904 */           this.g2.drawString(Vacaciones.this.cantidad.getText(), Vacaciones.this.alinearDer(720, Vacaciones.this.cantidad.getText().length()), 234);
/*      */           
/* 4906 */           contenido();
/* 4907 */           this.g2.drawString("__________________", 640, 223);
/* 4908 */           this.g2.drawString("__________________", 640, 224);
/* 4909 */           this.g2.drawString("SUBTOTAL VACACIONES", 515, 234);
/*      */           
/* 4911 */           this.g2.setColor(new Color(204, 0, 0));
/* 4912 */           this.g2.fillRect(25, 265, 735, 10);
/* 4913 */           this.g2.drawRect(25, 275, 734, 25);
/* 4914 */           this.g2.drawLine(70, 266, 70, 300);
/* 4915 */           this.g2.drawLine(615, 266, 615, 300);
/*      */           
/* 4917 */           this.g2.setColor(Color.BLACK);
/* 4918 */           fuente = new Font("Dialog", 2, 9);
/* 4919 */           this.g2.setFont(fuente);
/* 4920 */           this.g2.drawString("NÚM", 35, 291);
/* 4921 */           this.g2.drawString("CONCEPTO", 340, 291);
/* 4922 */           this.g2.drawString("IMPORTE", 672, 291);
/*      */           
/* 4924 */           this.g2.setColor(Color.WHITE);
/* 4925 */           fuente = new Font("Dialog", 1, 8);
/* 4926 */           this.g2.setFont(fuente);
/* 4927 */           this.g2.drawString("DESCUENTOS", 368, 273);
/* 4928 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 4930 */           subtitulo();
/* 4931 */           y = 312;
/* 4932 */           sumas = 0.0D;
/* 4933 */           entra = false;
/* 4934 */           if (Vacaciones.this.jTable5.getRowCount() > 0) {
/* 4935 */             for (int j = 0; j < Vacaciones.this.jTable5.getRowCount(); j++) {
/* 4936 */               this.g2.drawString("" + j + 1, 45, y);
/* 4937 */               this.g2.drawString(String.valueOf(Vacaciones.this.jTable5.getValueAt(j, 0)), 75, y);
/* 4938 */               this.g2.drawString(String.valueOf(Vacaciones.this.jTable5.getValueAt(j, 1)), Vacaciones.this.alinearDer(720, Vacaciones.this.jTable5.getValueAt(j, 1).toString().length()), y);
/*      */               
/* 4940 */               String canti = String.valueOf(Vacaciones.this.jTable5.getValueAt(j, 1));
/* 4941 */               String valorP = "";
/* 4942 */               for (int k = 0; k < canti.length(); k++) {
/* 4943 */                 if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 4944 */                   valorP = valorP + valorP;
/*      */                 }
/*      */               } 
/* 4947 */               sumas += Double.parseDouble(valorP);
/* 4948 */               y += 14;
/* 4949 */               entra = true;
/*      */             } 
/*      */           } else {
/*      */             
/* 4953 */             this.g2.drawString("NO SE REGISTRARON DESCUENTOS PARA ESTE CÁLCULO...", 30, y);
/*      */           } 
/* 4955 */           if (entra) {
/* 4956 */             y -= 14;
/*      */           }
/* 4958 */           TOTAL -= sumas;
/* 4959 */           contenido();
/* 4960 */           Vacaciones.this.cantidad.setValue(Double.valueOf(sumas));
/* 4961 */           this.g2.drawString("__________________", 640, y + 2);
/* 4962 */           this.g2.drawString("__________________", 640, y + 3);
/* 4963 */           this.g2.drawString("SUBTOTAL DESCUENTOS", 515, y + 13);
/*      */           
/* 4965 */           subtitulo();
/* 4966 */           this.g2.drawString(Vacaciones.this.cantidad.getText(), Vacaciones.this.alinearDer(720, Vacaciones.this.cantidad.getText().length()), y + 13);
/*      */           
/* 4968 */           this.g2.setColor(new Color(204, 0, 0));
/* 4969 */           this.g2.fillRect(690, 450, 70, 10);
/* 4970 */           this.g2.drawRect(25, 460, 734, 35);
/*      */           
/* 4972 */           this.g2.setColor(Color.WHITE);
/* 4973 */           fuente = new Font("Dialog", 0, 7);
/* 4974 */           this.g2.setFont(fuente);
/* 4975 */           this.g2.drawString("TOTAL EN LETRA", 695, 458);
/*      */           
/* 4977 */           this.g2.setColor(Color.BLACK);
/*      */           
/* 4979 */           Vacaciones.this.numLetra = new NumerosALetras(TOTAL, "MXN");
/* 4980 */           subtitulo();
/* 4981 */           totalL = "  (" + Vacaciones.this.numLetra.regresaNumero() + ")";
/* 4982 */           this.g2.drawString(totalL, Vacaciones.this.alinearDer(680, totalL.length()), 490);
/* 4983 */           this.g2.drawString(Vacaciones.this.jLabel13.getText(), Vacaciones.this.alinearDer(720, Vacaciones.this.jLabel13.getText().length()), 475);
/*      */           
/* 4985 */           this.g2.drawRect(25, 500, 734, 10);
/* 4986 */           this.g2.drawRect(25, 510, 734, 50);
/* 4987 */           this.g2.drawLine(460, 500, 460, 560);
/* 4988 */           this.g2.drawLine(610, 500, 610, 560);
/*      */           
/* 4990 */           fuente = new Font("Dialog", 1, 9);
/* 4991 */           this.g2.setFont(fuente);
/* 4992 */           this.g2.drawString("Firma y Huellas del Trabajador", 175, 508);
/* 4993 */           this.g2.drawString("Firma de Testigos", 494, 508);
/* 4994 */           this.g2.drawString("Firma de Autorizado", 642, 508);
/*      */           
/* 4996 */           fuente = new Font("Dialog", 0, 7);
/* 4997 */           this.g2.setFont(fuente);
/*      */           
/* 4999 */           this.g2.drawString(Vacaciones.this.jTextField6.getText(), 727, 570);
/*      */           
/* 5001 */           return 0;
/* 5002 */       }  return 1; }
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 5006 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 5007 */       job.setPrintable(this);
/*      */       
/* 5009 */       PageFormat pf = job.defaultPage();
/* 5010 */       Paper papel = pf.getPaper();
/* 5011 */       papel.setSize(612.0D, 792.0D);
/* 5012 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 5013 */       pf.setPaper(papel);
/* 5014 */       pf.setOrientation(0);
/* 5015 */       ImprimirVacaciones2 im = new ImprimirVacaciones2();
/* 5016 */       job.setPrintable(im, pf);
/* 5017 */       job.defaultPage(pf);
/*      */       
/* 5019 */       boolean ok = job.printDialog();
/* 5020 */       if (ok)
/*      */         try {
/* 5022 */           job.print();
/*      */         }
/* 5024 */         catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirDatos implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirDatos() {
/* 5034 */       this.g2 = null;
/* 5035 */       this.Pag = 0;
/*      */       
/* 5037 */       this.linesPerPage = 50;
/* 5038 */       this.orientacion = 0;
/* 5039 */       this.X = 0.0D;
/* 5040 */       this.Y = 0.0D;
/* 5041 */       this.YINICIA = 75;
/* 5042 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 5043 */       this.NumLineas = 0;
/* 5044 */       this.numBreaks = 0;
/*      */     }
/*      */     
/*      */     private void initTextLines() {
/* 5048 */       if (this.textLines == null) {
/*      */ 
/*      */         
/* 5051 */         int numLines = Vacaciones.this.jTable3.getRowCount();
/*      */         
/* 5053 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 5057 */       Font font = new Font("Serif", 0, 8);
/* 5058 */       FontMetrics metrics = g.getFontMetrics(font);
/* 5059 */       int lineHeight = metrics.getHeight();
/* 5060 */       if (this.pageBreaks == null) {
/* 5061 */         initTextLines();
/* 5062 */         this.orientacion = pf.getOrientation();
/* 5063 */         if (pf.getOrientation() == 1) {
/* 5064 */           this.linesPerPage = 44;
/* 5065 */           this.X = pf.getWidth();
/* 5066 */           this.Y = pf.getHeight();
/*      */         } else {
/*      */           
/* 5069 */           this.linesPerPage = 38;
/* 5070 */           this.X = pf.getWidth();
/* 5071 */           this.Y = pf.getHeight();
/*      */         } 
/* 5073 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 5074 */         this.Pag = this.numBreaks;
/* 5075 */         this.pageBreaks = new int[this.numBreaks];
/* 5076 */         for (int b = 0; b < this.numBreaks; b++) {
/* 5077 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 5080 */       if (pageIndex > this.pageBreaks.length) {
/* 5081 */         return 1;
/*      */       }
/* 5083 */       Graphics2D g2d = (Graphics2D)g;
/* 5084 */       this.g2 = g;
/* 5085 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 5086 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 5087 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 5088 */       encabezado();
/* 5089 */       int y = this.YINICIA;
/* 5090 */       int lineas = 0;
/*      */       
/* 5092 */       this.g2.drawRect(25, 160, 550, 12);
/* 5093 */       this.g2.setColor(new Color(204, 0, 0));
/* 5094 */       this.g2.fillRect(25, 161, 550, 10);
/*      */       
/* 5096 */       Font fuente = new Font("Dialog", 0, 7);
/* 5097 */       this.g2.setFont(fuente);
/* 5098 */       this.g2.setColor(Color.WHITE);
/* 5099 */       int[] valores = { 29, 70, 120, 290, 200, 270, 340, 390, 430, 480, 530 };
/* 5100 */       this.g2.drawString("FOLIO", valores[0], 169);
/* 5101 */       this.g2.drawString("FECHA", valores[1], 169);
/* 5102 */       this.g2.drawString("EMPLEADO", valores[2], 169);
/* 5103 */       this.g2.drawString("PERIODO", valores[3], 169);
/* 5104 */       this.g2.drawString("DEPARTAMENTO", valores[4], 169);
/* 5105 */       this.g2.drawString("TOTAL", valores[5], 169);
/* 5106 */       this.g2.drawString("ESTATUS", valores[6] + 20, 169);
/* 5107 */       this.g2.drawString("DOCUMENTÓ", valores[7] + 20, 169);
/*      */       
/* 5109 */       this.g2.setColor(Color.BLACK);
/* 5110 */       y = 170;
/* 5111 */       for (int line = start; line < end; line++) {
/* 5112 */         y += 12;
/*      */         
/* 5114 */         String valor = "";
/* 5115 */         if (line < 9) {
/* 5116 */           valor = "0" + line + 1;
/*      */         } else {
/*      */           
/* 5119 */           valor = "" + line + 1;
/*      */         } 
/* 5121 */         fuente = new Font("Dialog", 1, 7);
/* 5122 */         this.g2.setFont(fuente);
/* 5123 */         this.g2.drawString(valor, Vacaciones.this.alinearDer(20, valor.length()), y - 2);
/*      */         
/* 5125 */         fuente = new Font("Dialog", 0, 6);
/* 5126 */         this.g2.setFont(fuente);
/*      */         
/* 5128 */         this.g2.drawString(String.valueOf(Vacaciones.this.jTable3.getValueAt(line, 1)), valores[0], y - 2);
/* 5129 */         String fecha = String.valueOf(Vacaciones.this.jTable3.getValueAt(line, 2));
/* 5130 */         String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 5131 */         this.g2.drawString(col, valores[1], y - 2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 5138 */         this.g2.drawString(String.valueOf(Vacaciones.this.jTable3.getValueAt(line, 2)), valores[2], y - 2);
/* 5139 */         this.g2.drawString(String.valueOf(Vacaciones.this.jTable3.getValueAt(line, 3)), valores[3], y - 2);
/* 5140 */         this.g2.drawString(String.valueOf(Vacaciones.this.jTable3.getValueAt(line, 4)), Vacaciones.this.alinearDer(valores[4] + 40, Vacaciones.this.jTable3.getValueAt(line, 8).toString().length()), y - 2);
/* 5141 */         this.g2.drawString(String.valueOf(Vacaciones.this.jTable3.getValueAt(line, 5)), valores[5], y - 2);
/* 5142 */         this.g2.drawString(String.valueOf(Vacaciones.this.jTable3.getValueAt(line, 6)), valores[6], y - 2);
/* 5143 */         this.g2.drawString(String.valueOf(Vacaciones.this.jTable3.getValueAt(line, 7)), valores[7], y - 2);
/* 5144 */         this.g2.drawString(String.valueOf(Vacaciones.this.jTable3.getValueAt(line, 8)), valores[8], y - 2);
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
/* 5155 */       g.drawString("Página " + pageIndex + 1, 540, 749);
/* 5156 */       if (this.Pag == pageIndex) {
/* 5157 */         this.g2.drawLine(20, y, 90, y);
/* 5158 */         this.g2.drawLine(350, y, 390, y);
/* 5159 */         this.g2.drawLine(395, y, 435, y);
/* 5160 */         this.g2.drawLine(440, y, 480, y);
/* 5161 */         this.g2.drawLine(485, y, 525, y);
/*      */         
/* 5163 */         fuente = new Font("Dialog", 1, 6);
/* 5164 */         this.g2.setFont(fuente);
/* 5165 */         g.drawString("SUMAS", 41, y + 10);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 5171 */         fuente = new Font("Dialog", 1, 7);
/* 5172 */         this.g2.setFont(fuente);
/* 5173 */         this.g2.drawString("ELABORÓ", 190, 720);
/* 5174 */         this.g2.drawString("_____________________________________", 140, 752);
/* 5175 */         this.g2.drawString("NOMBRE Y FIRMA", 178, 765);
/*      */         
/* 5177 */         this.g2.drawString("RECIBE", 390, 720);
/* 5178 */         this.g2.drawString("_____________________________________", 340, 752);
/* 5179 */         this.g2.drawString("NOMBRE Y FIRMA", 378, 765);
/*      */       } 
/* 5181 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 5185 */       Font fuente = new Font("Dialog", 0, 8);
/* 5186 */       this.g2.setFont(fuente);
/* 5187 */       this.g2.setColor(Color.BLACK);
/* 5188 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 5189 */       Image img = imagen.getImage();
/* 5190 */       this.g2.drawImage(img, 518, 1, 57, 57, null);
/*      */       
/* 5192 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 5193 */       img = imagen.getImage();
/* 5194 */       this.g2.drawImage(img, 27, 8, 60, 50, null);
/*      */       
/* 5196 */       fuente = new Font("Times New Roman", 1, 16);
/* 5197 */       this.g2.setFont(fuente);
/* 5198 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 20);
/*      */ 
/*      */       
/* 5201 */       fuente = new Font("Dialog", 0, 12);
/* 5202 */       this.g2.setFont(fuente);
/* 5203 */       this.g2.drawString("IMPRESIÓN DE FACTURAS", 220, 37);
/* 5204 */       this.g2.drawLine(25, 60, 575, 60);
/*      */       
/* 5206 */       this.g2.setColor(Color.BLACK);
/* 5207 */       this.g2.drawLine(25, 83, 220, 83);
/* 5208 */       this.g2.drawLine(25, 143, 220, 143);
/*      */       
/* 5210 */       fuente = new Font("Dialog", 1, 8);
/* 5211 */       this.g2.setFont(fuente);
/* 5212 */       this.g2.setColor(Color.BLACK);
/* 5213 */       this.g2.drawString("INFORMACIÓN DEL REPORTE", 25, 80);
/*      */       
/* 5215 */       fuente = new Font("Dialog", 1, 7);
/* 5216 */       this.g2.setFont(fuente);
/* 5217 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 5219 */       this.g2.drawString("Cliente: ", 27, 93);
/* 5220 */       this.g2.drawString("Equipo: ", 27, 104);
/* 5221 */       this.g2.drawString("Plataforma: ", 27, 115);
/* 5222 */       this.g2.drawString("Pozo: ", 27, 126);
/* 5223 */       this.g2.drawString("Periodo: ", 27, 137);
/*      */       
/* 5225 */       fuente = new Font("Dialog", 0, 7);
/* 5226 */       this.g2.setFont(fuente);
/* 5227 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 5229 */       this.g2.drawString(String.valueOf(Vacaciones.this.jComboBox3.getSelectedItem()), 85, 93);
/* 5230 */       this.g2.drawString(String.valueOf(Vacaciones.this.jComboBox5.getSelectedItem()), 85, 104);
/* 5231 */       this.g2.drawString(String.valueOf(Vacaciones.this.jComboBox6.getSelectedItem()), 85, 115);
/*      */ 
/*      */       
/* 5234 */       Date fecha1 = Vacaciones.this.jDateChooser4.getDate();
/* 5235 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5236 */       String cadenaFecha = "";
/* 5237 */       cadenaFecha = formato.format(fecha1);
/* 5238 */       String AÑO = cadenaFecha.substring(0, 4);
/* 5239 */       String MES = cadenaFecha.substring(4, 6);
/* 5240 */       String DIA = cadenaFecha.substring(6, 8);
/*      */       
/* 5242 */       fecha1 = Vacaciones.this.jDateChooser5.getDate();
/* 5243 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 5244 */       cadenaFecha = "";
/* 5245 */       cadenaFecha = formato.format(fecha1);
/* 5246 */       String AA = cadenaFecha.substring(0, 4);
/* 5247 */       String MM = cadenaFecha.substring(4, 6);
/* 5248 */       String DD = cadenaFecha.substring(6, 8);
/* 5249 */       this.g2.drawString("Del " + DIA + "/" + MES + "/" + AÑO + " AL " + DD + "/" + MM + "/" + AA, 85, 137);
/*      */       
/* 5251 */       fecha1 = new Date();
/* 5252 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 5253 */       cadenaFecha = "";
/* 5254 */       cadenaFecha = formato.format(fecha1);
/* 5255 */       AÑO = cadenaFecha.substring(0, 4);
/* 5256 */       MES = cadenaFecha.substring(4, 6);
/* 5257 */       DIA = cadenaFecha.substring(6, 8);
/* 5258 */       this.g2.drawString(DIA + "/" + DIA + "/" + MES, 540, 70);
/*      */       
/* 5260 */       fuente = new Font("Dialog", 0, 7);
/* 5261 */       this.g2.setFont(fuente);
/* 5262 */       this.g2.drawString("A continuación se enlistan todas las facturas en este periodo:", 25, 158);
/*      */     }
/*      */     public void recibeDatos() {
/* 5265 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 5266 */       job.setPrintable(this);
/*      */       
/* 5268 */       PageFormat pf = job.defaultPage();
/* 5269 */       Paper papel = pf.getPaper();
/* 5270 */       papel.setSize(612.0D, 792.0D);
/* 5271 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 5272 */       pf.setPaper(papel);
/* 5273 */       pf.setOrientation(1);
/* 5274 */       job.setPrintable(new ImprimirDatos(), pf);
/* 5275 */       job.defaultPage(pf);
/*      */       
/* 5277 */       boolean ok = job.printDialog();
/* 5278 */       if (ok)
/*      */         try {
/* 5280 */           job.print();
/*      */         }
/* 5282 */         catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Vacaciones.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */