/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Image;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.SimpleDateFormat;
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
/*      */ public class Archivo extends JPanel {
/*      */   JScrollPane panel;
/*   32 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   33 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   34 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   35 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   36 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   37 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   38 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   39 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   40 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   String USUARIO;
/*   42 */   Validaciones val = new Validaciones();
/*   43 */   Consultas con = new Consultas();
/*   44 */   Errores error = new Errores(false);
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   JFrame padre;
/*      */   EscribirReporte esc;
/*   49 */   Date fechaActual = new Date();
/*   50 */   Date fechaInicio = null;
/*   51 */   Date fecha = new Date();
/*   52 */   String[] LINEAS = null;
/*   53 */   int VIAJESTOT = 0;
/*   54 */   Double TONS = Double.valueOf(0.0D);
/*   55 */   String[] NOMBRECOL = null;
/*   56 */   int[] CANTTOTALES = new int[16];
/*   57 */   String[][] REGIS = null;
/*   58 */   int[] LETRASMAX = null;
/*   59 */   String[] SERVICIOS = null;
/*   60 */   int OTROSRESIDUOS = 0;
/*   61 */   int OTROSSERVICIOS = 0;
/*   62 */   double[] TONSRESIDUO = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/*   63 */   String[] GUIASAMPARADAS = new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "" };
/*   64 */   AddGuias[] addGuias = null;
/*   65 */   int TIPOREPOR = 0;
/*   66 */   DefaultTableModel MODELOPREFACTURA = new DefaultTableModel();
/*   67 */   String[] IDCLIENTE = null;
/*   68 */   String PREFAC = "";
/*      */   boolean PRESIONADO = false;
/*   70 */   Presionado presionado = null;
/*   71 */   CeldaRender celda = new CeldaRender();
/*   72 */   CeldaRender2 celda2 = new CeldaRender2();
/*   73 */   double TONELADAS = 0.0D;
/*   74 */   String base = "";
/*      */   boolean PRIMERA = false;
/*      */   boolean PRIMERAGUIAS = false;
/*   77 */   int contador = 0;
/*   78 */   MensajePop mensajeTry = null; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton3; private JButton jButton34; private JButton jButton4; private JButton jButton44; private JButton jButton45; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JComboBox jComboBox10; private JComboBox jComboBox2; private JComboBox jComboBox20; private JComboBox jComboBox21; private JComboBox jComboBox22; private JComboBox jComboBox23; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JComboBox jComboBox9; private JDateChooser jDateChooser1; private JDateChooser jDateChooser11; private JDateChooser jDateChooser12; private JDateChooser jDateChooser2; private JDateChooser jDateChooser4; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JFrame jFrame1; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel2; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39;
/*      */   
/*      */   public Archivo(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*   81 */     this.mensajeTry = mensajeTry;
/*   82 */     String año = "2010";
/*   83 */     String mes = "10";
/*   84 */     String dia = "10";
/*   85 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   86 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   88 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   89 */     } catch (ParseException ex) {
/*   90 */       ex.printStackTrace();
/*      */     } 
/*   92 */     this.padre = padre;
/*   93 */     this.fichas = fichas;
/*   94 */     initComponents();
/*      */     
/*   96 */     Image icono = this.tk.getImage(getClass().getResource("LOGO.png"));
/*   97 */     icono = this.tk.getImage(getClass().getResource("/entrada/Imagenes/cash_register.png"));
/*   98 */     this.jFrame1.setIconImage(icono);
/*      */     
/*  100 */     this.USUARIO = USUARIO;
/*  101 */     panelito.setViewportView(this);
/*  102 */     this.panel = panelito;
/*  103 */     llenarCombos();
/*      */ 
/*      */     
/*  106 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  107 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  108 */     this.jFrame1.setCursor(micursor);
/*  109 */     this.jDialog1.setCursor(micursor);
/*      */     
/*  111 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  112 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  113 */     this.jLabel37.setCursor(micursor);
/*  114 */     this.jLabel38.setCursor(micursor);
/*  115 */     this.jLabel39.setCursor(micursor);
/*      */     
/*  117 */     this.jFrame1.setExtendedState(6);
/*  118 */     this.jFrame1.setSize(750, 650);
/*  119 */     int w = this.tama.width;
/*  120 */     int h = this.tama.height;
/*  121 */     int rw = (w - 900) / 2;
/*  122 */     int rh = (h - 535) / 2;
/*  123 */     this.jDialog1.setSize(900, 535);
/*  124 */     this.jDialog1.setLocation(rw, rh);
/*  125 */     this.jDialog1.setResizable(false);
/*      */     
/*  127 */     rw = (w - 390) / 2;
/*  128 */     rh = (h - 253) / 2;
/*  129 */     this.jDialog4.setSize(390, 253);
/*  130 */     this.jDialog4.setLocation(rw, rh);
/*  131 */     this.jDialog4.setResizable(false);
/*      */     
/*  133 */     rw = (w - 425) / 2;
/*  134 */     rh = (h - 461) / 2;
/*  135 */     this.jDialog5.setSize(425, 461);
/*  136 */     this.jDialog5.setLocation(rw, rh);
/*  137 */     this.jDialog5.setResizable(false);
/*      */     
/*  139 */     rw = (w - 390) / 2;
/*  140 */     rh = (h - 230) / 2;
/*  141 */     this.jDialog6.setSize(390, 230);
/*  142 */     this.jDialog6.setLocation(rw, rh);
/*  143 */     this.jDialog6.setResizable(false);
/*      */     
/*  145 */     rw = (w - 500) / 2;
/*  146 */     rh = (h - 630) / 2;
/*  147 */     this.jDialog2.setSize(750, 600);
/*  148 */     this.jDialog2.setLocation(rw, rh);
/*  149 */     this.jDialog2.setResizable(false);
/*      */     
/*  151 */     rw = (w - 250) / 2;
/*  152 */     rh = (h - 200) / 2;
/*  153 */     this.jDialog7.setSize(280, 170);
/*  154 */     this.jDialog7.setLocation(rw, rh);
/*  155 */     this.jDialog7.setResizable(false);
/*      */     
/*  157 */     privilegios();
/*  158 */     colorear();
/*  159 */     desactivarTabla();
/*  160 */     consultar();
/*      */     
/*  162 */     this.con.consultar("sucursal", "configuraciones", "");
/*  163 */     this.base = this.con.Campo;
/*      */   }
/*      */   private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel9; private JMenuItem jMenuItem1; private JMenuItem jMenuItem2; private JMenuItem jMenuItem3; private JMenuItem jMenuItem4; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JPopupMenu jPopupMenu1; private JScrollPane jScrollPane1; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JSeparator jSeparator1; private JSeparator jSeparator10; private JSeparator jSeparator2; private JSeparator jSeparator27; private JSeparator jSeparator3; private JSeparator jSeparator6; private JPopupMenu.Separator jSeparator7; private JSeparator jSeparator8; private JSeparator jSeparator9; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTable jTable4; private JTextArea jTextArea2; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField12; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7;
/*      */   
/*      */   private void initComponents() {
/*  168 */     this.jFrame1 = new JFrame();
/*  169 */     this.jPanel1 = new JPanel();
/*  170 */     this.jLabel1 = new JLabel();
/*  171 */     this.jLabel30 = new JLabel();
/*  172 */     this.jSeparator1 = new JSeparator();
/*  173 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  174 */     this.jLabel2 = new JLabel();
/*  175 */     this.jTextField2 = new JTextField();
/*  176 */     this.jScrollPane1 = new JScrollPane();
/*  177 */     this.jTable1 = new JTable();
/*  178 */     this.jPanel2 = new JPanel();
/*  179 */     this.jLabel29 = new JLabel();
/*  180 */     this.jComboBox4 = new JComboBox();
/*  181 */     this.jButton1 = new JButton();
/*  182 */     this.jButton2 = new JButton();
/*  183 */     this.jLabel12 = new JLabel();
/*  184 */     this.jLabel33 = new JLabel();
/*  185 */     this.jComboBox21 = new JComboBox();
/*  186 */     this.jLabel34 = new JLabel();
/*  187 */     this.jComboBox22 = new JComboBox();
/*  188 */     this.jLabel35 = new JLabel();
/*  189 */     this.jComboBox23 = new JComboBox();
/*  190 */     this.jButton8 = new JButton();
/*  191 */     this.jLabel52 = new JLabel();
/*  192 */     this.jButton10 = new JButton();
/*  193 */     this.jButton14 = new JButton();
/*  194 */     this.jButton17 = new JButton();
/*  195 */     this.jLabel60 = new JLabel();
/*  196 */     this.jLabel51 = new JLabel();
/*  197 */     this.jLabel11 = new JLabel();
/*  198 */     this.jTextField4 = new JTextField();
/*  199 */     this.jCheckBox1 = new JCheckBox();
/*  200 */     this.jDialog1 = new CerrarVentana(this.jFrame1);
/*  201 */     this.jPanel14 = new JPanel();
/*  202 */     this.jPanel15 = new JPanel();
/*  203 */     this.jPanel16 = new JPanel();
/*  204 */     this.jLabel63 = new JLabel();
/*  205 */     this.jDateChooser1 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  206 */     this.jLabel66 = new JLabel();
/*  207 */     this.jDateChooser2 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  208 */     this.jButton13 = new JButton();
/*  209 */     this.jPanel20 = new JPanel();
/*  210 */     this.jPanel19 = new JPanel();
/*  211 */     this.jLabel5 = new JLabel();
/*  212 */     this.jTextField3 = new JTextField();
/*  213 */     this.jLabel32 = new JLabel();
/*  214 */     this.jComboBox20 = new JComboBox();
/*  215 */     this.jLabel17 = new JLabel();
/*  216 */     this.jComboBox10 = new JComboBox();
/*  217 */     this.jLabel6 = new JLabel();
/*  218 */     this.jComboBox5 = new JComboBox();
/*  219 */     this.jLabel7 = new JLabel();
/*  220 */     this.jComboBox6 = new JComboBox();
/*  221 */     this.jLabel8 = new JLabel();
/*  222 */     this.jComboBox7 = new JComboBox();
/*  223 */     this.jLabel9 = new JLabel();
/*  224 */     this.jComboBox8 = new JComboBox();
/*  225 */     this.jLabel10 = new JLabel();
/*  226 */     this.jComboBox9 = new JComboBox();
/*  227 */     this.jLabel18 = new JLabel();
/*  228 */     this.jTextField7 = new JTextField();
/*  229 */     this.jScrollPane3 = new JScrollPane();
/*  230 */     this.jTable3 = new JTable();
/*  231 */     this.jLabel50 = new JLabel();
/*  232 */     this.jButton7 = new JButton();
/*  233 */     this.jButton6 = new JButton();
/*  234 */     this.jTextField12 = new JTextField();
/*  235 */     this.jDialog4 = new CerrarVentana(this.jFrame1);
/*  236 */     this.jPanel11 = new JPanel();
/*  237 */     this.jLabel58 = new JLabel();
/*  238 */     this.jSeparator6 = new JSeparator();
/*  239 */     this.jLabel59 = new JLabel();
/*  240 */     this.jScrollPane5 = new JScrollPane();
/*  241 */     this.jTextArea2 = new JTextArea();
/*  242 */     this.jButton18 = new JButton();
/*  243 */     this.jButton19 = new JButton();
/*  244 */     this.jPopupMenu1 = new JPopupMenu();
/*  245 */     this.jMenuItem1 = new JMenuItem();
/*  246 */     this.jMenuItem2 = new JMenuItem();
/*  247 */     this.jSeparator7 = new JPopupMenu.Separator();
/*  248 */     this.jMenuItem3 = new JMenuItem();
/*  249 */     this.jMenuItem4 = new JMenuItem();
/*  250 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  251 */     this.jPanel12 = new JPanel();
/*  252 */     this.jLabel61 = new JLabel();
/*  253 */     this.jSeparator8 = new JSeparator();
/*  254 */     this.jButton20 = new JButton();
/*  255 */     this.jButton21 = new JButton();
/*  256 */     this.jButton22 = new JButton();
/*  257 */     this.jSeparator9 = new JSeparator();
/*  258 */     this.jLabel62 = new JLabel();
/*  259 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  260 */     this.jPanel29 = new JPanel();
/*  261 */     this.jLabel124 = new JLabel();
/*  262 */     this.jSeparator27 = new JSeparator();
/*  263 */     this.jLabel125 = new JLabel();
/*  264 */     this.jButton44 = new JButton();
/*  265 */     this.jButton45 = new JButton();
/*  266 */     this.jScrollPane18 = new JScrollPane();
/*  267 */     this.jTextArea5 = new JTextArea();
/*  268 */     this.jLabel126 = new JLabel();
/*  269 */     this.jDialog2 = new CerrarVentana(this.jFrame1);
/*  270 */     this.jPanel4 = new JPanel();
/*  271 */     this.jLabel13 = new JLabel();
/*  272 */     this.jSeparator3 = new JSeparator();
/*  273 */     this.jLabel14 = new JLabel();
/*  274 */     this.jScrollPane4 = new JScrollPane();
/*  275 */     this.jTable4 = new JTable();
/*  276 */     this.jButton3 = new JButton();
/*  277 */     this.jButton9 = new JButton();
/*  278 */     this.jDialog7 = new CerrarVentana(this.jFrame1);
/*  279 */     this.jPanel13 = new JPanel();
/*  280 */     this.jLabel64 = new JLabel();
/*  281 */     this.jSeparator10 = new JSeparator();
/*  282 */     this.jLabel65 = new JLabel();
/*  283 */     this.jButton23 = new JButton();
/*  284 */     this.jButton24 = new JButton();
/*  285 */     this.jTextField5 = new JTextField();
/*  286 */     this.jPanel3 = new JPanel();
/*  287 */     this.jSeparator2 = new JSeparator();
/*  288 */     this.jPanel5 = new JPanel();
/*  289 */     this.jPanel7 = new JPanel();
/*  290 */     this.jPanel9 = new JPanel();
/*  291 */     this.jPanel10 = new JPanel();
/*  292 */     this.jPanel6 = new JPanel();
/*  293 */     this.jLabel3 = new JLabel();
/*  294 */     this.jPanel17 = new JPanel();
/*  295 */     this.jTextField1 = new JTextField();
/*  296 */     this.jLabel15 = new JLabel();
/*  297 */     this.jComboBox1 = new JComboBox();
/*  298 */     this.jLabel46 = new JLabel();
/*  299 */     this.jComboBox2 = new JComboBox();
/*  300 */     this.jLabel47 = new JLabel();
/*  301 */     this.jComboBox3 = new JComboBox();
/*  302 */     this.jLabel49 = new JLabel();
/*  303 */     this.jTextField6 = new JTextField();
/*  304 */     this.jLabel16 = new JLabel();
/*  305 */     this.jPanel18 = new JPanel();
/*  306 */     this.jScrollPane2 = new JScrollPane();
/*  307 */     this.jTable2 = new JTable();
/*  308 */     this.jLabel48 = new JLabel();
/*  309 */     this.jButton4 = new JButton();
/*  310 */     this.jButton5 = new JButton();
/*  311 */     this.jButton11 = new JButton();
/*  312 */     this.jButton34 = new JButton();
/*  313 */     this.jButton12 = new JButton();
/*  314 */     this.jPanel8 = new JPanel();
/*  315 */     this.jDateChooser11 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  316 */     this.jDateChooser12 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  317 */     this.jLabel37 = new JLabel();
/*  318 */     this.jLabel38 = new JLabel();
/*  319 */     this.jLabel39 = new JLabel();
/*  320 */     this.jLabel40 = new JLabel();
/*  321 */     this.jLabel41 = new JLabel();
/*  322 */     this.jButton15 = new JButton();
/*      */     
/*  324 */     this.jFrame1.setDefaultCloseOperation(0);
/*  325 */     this.jFrame1.setTitle("Crear reporte interno");
/*  326 */     this.jFrame1.addWindowListener(new WindowAdapter() {
/*      */           public void windowClosing(WindowEvent evt) {
/*  328 */             Archivo.this.jFrame1WindowClosing(evt);
/*      */           }
/*      */         });
/*      */     
/*  332 */     this.jPanel1.setBackground(Color.white);
/*      */     
/*  334 */     this.jLabel1.setFont(new Font("Times New Roman", 1, 21));
/*  335 */     this.jLabel1.setHorizontalAlignment(0);
/*  336 */     this.jLabel1.setText("<HTML><CENTER>FLETES Y MATERIALES FORSIS S.A. DE C.V.</CENTER></HTML>");
/*      */     
/*  338 */     this.jLabel30.setHorizontalAlignment(0);
/*  339 */     this.jLabel30.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis75.png")));
/*      */     
/*  341 */     this.jDateChooser4.setDate(this.fechaActual);
/*  342 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/*  343 */     this.jDateChooser4.setIcon(this.icon);
/*  344 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/*  345 */     this.jDateChooser4.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/*  347 */     this.jLabel2.setText("Folio o Ref");
/*      */     
/*  349 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/*  350 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, "7539", "FPR-2590", "25909", "41.24", "SIN PO", "FPR-AG-3247", "LBAG", "VICTORIANO MARICHE TRUJILLO", "07/09/2010", "PA 1631", "11", "284", "534", "ADT PETROSERVICIOS", "$ 825.00", "$34,023.00" }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null },  }, (Object[])new String[] { "Núm", "Guías", "Folio Inter", "Ticket", "Peso", "Pedido", "Manif", "TM", "Operador", "Sale", "Pozo", "Eq", "T", "R", "Destino", "$ x Tons.", "Importe" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  360 */           boolean[] canEdit = new boolean[] { 
/*      */               false, true, true, true, true, true, true, true, true, true, 
/*      */               true, true, true, true, true, true, true };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  365 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  368 */     this.jTable1.setShowVerticalLines(false);
/*  369 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  371 */             Archivo.this.jTable1MouseClicked(evt);
/*      */           }
/*      */         });
/*  374 */     this.jScrollPane1.setViewportView(this.jTable1);
/*  375 */     if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/*  376 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/*  377 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(42);
/*  378 */       this.jTable1.getColumnModel().getColumn(2).setMaxWidth(85);
/*  379 */       this.jTable1.getColumnModel().getColumn(3).setMaxWidth(45);
/*  380 */       this.jTable1.getColumnModel().getColumn(4).setMaxWidth(50);
/*  381 */       this.jTable1.getColumnModel().getColumn(5).setMaxWidth(50);
/*  382 */       this.jTable1.getColumnModel().getColumn(6).setMaxWidth(100);
/*  383 */       this.jTable1.getColumnModel().getColumn(7).setMaxWidth(60);
/*  384 */       this.jTable1.getColumnModel().getColumn(9).setMaxWidth(90);
/*  385 */       this.jTable1.getColumnModel().getColumn(10).setMaxWidth(100);
/*  386 */       this.jTable1.getColumnModel().getColumn(11).setMaxWidth(50);
/*  387 */       this.jTable1.getColumnModel().getColumn(12).setMaxWidth(40);
/*  388 */       this.jTable1.getColumnModel().getColumn(13).setMaxWidth(40);
/*  389 */       this.jTable1.getColumnModel().getColumn(15).setMaxWidth(100);
/*  390 */       this.jTable1.getColumnModel().getColumn(16).setMaxWidth(100);
/*      */     } 
/*      */     
/*  393 */     this.jPanel2.setBackground(Color.white);
/*      */     
/*  395 */     this.jLabel29.setForeground(new Color(153, 153, 153));
/*  396 */     this.jLabel29.setHorizontalAlignment(0);
/*      */     
/*  398 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  399 */     this.jPanel2.setLayout(jPanel2Layout);
/*  400 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  401 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  402 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  403 */           .addComponent(this.jLabel29, -2, 278, -2)
/*  404 */           .addContainerGap(-1, 32767)));
/*      */     
/*  406 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  407 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  408 */         .addComponent(this.jLabel29, -1, 66, 32767));
/*      */ 
/*      */     
/*  411 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  412 */     this.jComboBox4.setFont(new Font("Tahoma", 1, 11));
/*  413 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  414 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  416 */             Archivo.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  420 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Search.png")));
/*  421 */     this.jButton1.setMnemonic('B');
/*  422 */     this.jButton1.setText("Buscar Guías");
/*  423 */     this.jButton1.setToolTipText("Buscar Guías (Alt+B)");
/*  424 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  426 */             Archivo.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  430 */     this.jButton2.setMnemonic('Q');
/*  431 */     this.jButton2.setText("Quitar");
/*  432 */     this.jButton2.setToolTipText("Quitar Viajes (Alt+Q)");
/*  433 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  435 */             Archivo.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  439 */     this.jLabel12.setText("Cliente");
/*      */     
/*  441 */     this.jLabel33.setText("Equipo");
/*      */     
/*  443 */     this.jComboBox21.setBackground(new Color(244, 244, 244));
/*  444 */     this.jComboBox21.setFont(new Font("Tahoma", 1, 11));
/*  445 */     this.jComboBox21.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  446 */     this.jComboBox21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  448 */             Archivo.this.jComboBox21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  452 */     this.jLabel34.setText("Plataforma");
/*      */     
/*  454 */     this.jComboBox22.setBackground(new Color(244, 244, 244));
/*  455 */     this.jComboBox22.setFont(new Font("Tahoma", 1, 11));
/*  456 */     this.jComboBox22.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  457 */     this.jComboBox22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  459 */             Archivo.this.jComboBox22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  463 */     this.jLabel35.setHorizontalAlignment(4);
/*  464 */     this.jLabel35.setText("Pozo");
/*      */     
/*  466 */     this.jComboBox23.setBackground(new Color(244, 244, 244));
/*  467 */     this.jComboBox23.setFont(new Font("Tahoma", 1, 11));
/*  468 */     this.jComboBox23.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  469 */     this.jComboBox23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  471 */             Archivo.this.jComboBox23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  475 */     this.jButton8.setMnemonic('C');
/*  476 */     this.jButton8.setText("Cerrar");
/*  477 */     this.jButton8.setToolTipText("Cerrar Ventana (alt+C)");
/*  478 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  480 */             Archivo.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  484 */     this.jLabel52.setFont(new Font("Tahoma", 1, 11));
/*  485 */     this.jLabel52.setForeground(Color.red);
/*  486 */     this.jLabel52.setHorizontalAlignment(0);
/*  487 */     this.jLabel52.setText("t");
/*  488 */     this.jLabel52.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  490 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/*  491 */     this.jButton10.setMnemonic('G');
/*  492 */     this.jButton10.setText("Guardar Reporte");
/*  493 */     this.jButton10.setToolTipText("Guardar Archivo (Alt+G)");
/*  494 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  496 */             Archivo.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  500 */     this.jButton14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/*  501 */     this.jButton14.setMnemonic('G');
/*  502 */     this.jButton14.setText("Guardar");
/*  503 */     this.jButton14.setToolTipText("Guarda la prefactura (Alt+G)");
/*  504 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  506 */             Archivo.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  510 */     this.jButton17.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Comment.png")));
/*  511 */     this.jButton17.setMnemonic('O');
/*  512 */     this.jButton17.setText("Comentario");
/*  513 */     this.jButton17.setToolTipText("Organizar Comentario (Alt+O)");
/*  514 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  516 */             Archivo.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  520 */     this.jLabel60.setForeground(Color.darkGray);
/*  521 */     this.jLabel60.setText("<html>NOTA: Para ordenar los datos puedes dar clic en el encabezado de las columnas</html>");
/*      */     
/*  523 */     this.jLabel51.setFont(new Font("Tahoma", 1, 11));
/*  524 */     this.jLabel51.setForeground(Color.red);
/*  525 */     this.jLabel51.setHorizontalAlignment(0);
/*  526 */     this.jLabel51.setText("t");
/*  527 */     this.jLabel51.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  529 */     this.jLabel11.setText("Columna Pedido");
/*      */     
/*  531 */     this.jCheckBox1.setText("Aplicar a Todos los viajes");
/*  532 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  534 */             Archivo.this.jCheckBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  538 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  539 */     this.jPanel1.setLayout(jPanel1Layout);
/*  540 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  541 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  542 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  543 */           .addContainerGap()
/*  544 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  545 */             .addComponent(this.jSeparator1, -1, 1218, 32767)
/*  546 */             .addComponent(this.jScrollPane1, -1, 1218, 32767)
/*  547 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  548 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  549 */                 .addComponent(this.jPanel2, -2, -1, -2)
/*  550 */                 .addGroup(jPanel1Layout.createSequentialGroup()
/*  551 */                   .addComponent(this.jLabel12, -2, 65, -2)
/*  552 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  553 */                   .addComponent(this.jComboBox4, -2, 200, -2)))
/*  554 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  555 */                 .addGroup(jPanel1Layout.createSequentialGroup()
/*  556 */                   .addGap(119, 119, 119)
/*  557 */                   .addComponent(this.jLabel30, -2, 84, -2)
/*  558 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  559 */                   .addComponent(this.jLabel1, -2, 298, -2))
/*  560 */                 .addGroup(jPanel1Layout.createSequentialGroup()
/*  561 */                   .addGap(49, 49, 49)
/*  562 */                   .addComponent(this.jLabel33, -2, 51, -2)
/*  563 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  564 */                   .addComponent(this.jComboBox21, -2, 122, -2)
/*  565 */                   .addGap(47, 47, 47)
/*  566 */                   .addComponent(this.jLabel34, -2, 66, -2)
/*  567 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  568 */                   .addComponent(this.jComboBox22, -2, 155, -2)))
/*  569 */               .addGap(42, 42, 42)
/*  570 */               .addComponent(this.jLabel35, -2, 44, -2)
/*  571 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  572 */               .addComponent(this.jComboBox23, -2, 160, -2)
/*  573 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 65, 32767)
/*  574 */               .addComponent((Component)this.jDateChooser4, -2, 108, -2))
/*  575 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/*  576 */               .addComponent(this.jLabel60, -2, 316, -2)
/*  577 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 94, 32767)
/*  578 */               .addComponent(this.jButton17)
/*  579 */               .addGap(35, 35, 35)
/*  580 */               .addComponent(this.jButton1)
/*  581 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  582 */               .addComponent(this.jButton2, -2, 112, -2)
/*  583 */               .addGap(32, 32, 32)
/*  584 */               .addComponent(this.jButton14, -2, 112, -2)
/*  585 */               .addGap(18, 18, 18)
/*  586 */               .addComponent(this.jButton10)
/*  587 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  588 */               .addComponent(this.jButton8, -2, 112, -2))
/*  589 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  590 */               .addComponent(this.jLabel2, -2, 66, -2)
/*  591 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  592 */               .addComponent(this.jTextField2, -2, 160, -2)
/*  593 */               .addGap(54, 54, 54)
/*  594 */               .addComponent(this.jLabel52, -2, 187, -2)
/*  595 */               .addGap(61, 61, 61)
/*  596 */               .addComponent(this.jLabel51, -2, 242, -2)
/*  597 */               .addGap(33, 33, 33)
/*  598 */               .addComponent(this.jLabel11, -2, 99, -2)
/*  599 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  600 */               .addComponent(this.jTextField4, -2, 113, -2)
/*  601 */               .addGap(18, 18, 18)
/*  602 */               .addComponent(this.jCheckBox1, -2, 177, 32767)))
/*  603 */           .addContainerGap()));
/*      */     
/*  605 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  606 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  607 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  608 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  609 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  610 */               .addComponent(this.jPanel2, -2, -1, -2)
/*  611 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  612 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  613 */                 .addComponent(this.jComboBox4, -2, -1, -2)
/*  614 */                 .addComponent(this.jLabel12)))
/*  615 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  616 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  617 */                 .addComponent(this.jLabel30, GroupLayout.Alignment.LEADING)
/*  618 */                 .addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -2, -1, -2))
/*  619 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  620 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  621 */                 .addComponent(this.jLabel33)
/*  622 */                 .addComponent(this.jComboBox21, -2, -1, -2)
/*  623 */                 .addComponent(this.jLabel34)
/*  624 */                 .addComponent(this.jComboBox22, -2, -1, -2)
/*  625 */                 .addComponent(this.jLabel35)
/*  626 */                 .addComponent(this.jComboBox23, -2, -1, -2)))
/*  627 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  628 */               .addContainerGap()
/*  629 */               .addComponent((Component)this.jDateChooser4, -2, -1, -2)))
/*  630 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  631 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  632 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  633 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  634 */             .addComponent(this.jLabel2)
/*  635 */             .addComponent(this.jTextField2, -2, -1, -2)
/*  636 */             .addComponent(this.jLabel52)
/*  637 */             .addComponent(this.jLabel51)
/*  638 */             .addComponent(this.jLabel11)
/*  639 */             .addComponent(this.jTextField4, -2, -1, -2)
/*  640 */             .addComponent(this.jCheckBox1))
/*  641 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  642 */           .addComponent(this.jScrollPane1, -1, 394, 32767)
/*  643 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  644 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  645 */             .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  646 */               .addComponent(this.jButton8, -2, 28, -2)
/*  647 */               .addComponent(this.jButton10)
/*  648 */               .addComponent(this.jButton17)
/*  649 */               .addComponent(this.jButton2, -2, 28, -2)
/*  650 */               .addComponent(this.jButton1)
/*  651 */               .addComponent(this.jButton14))
/*  652 */             .addComponent(this.jLabel60, -2, 46, -2))
/*  653 */           .addContainerGap()));
/*      */ 
/*      */     
/*  656 */     GroupLayout jFrame1Layout = new GroupLayout(this.jFrame1.getContentPane());
/*  657 */     this.jFrame1.getContentPane().setLayout(jFrame1Layout);
/*  658 */     jFrame1Layout.setHorizontalGroup(jFrame1Layout
/*  659 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  660 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */     
/*  662 */     jFrame1Layout.setVerticalGroup(jFrame1Layout
/*  663 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  664 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */ 
/*      */     
/*  667 */     this.jDialog1.setTitle("Agregar guías a la prefactura");
/*  668 */     this.jDialog1.setModal(true);
/*      */     
/*  670 */     this.jPanel15.setBorder(BorderFactory.createTitledBorder("Selecciona el periodo que deseas buscar"));
/*  671 */     this.jPanel15.setMaximumSize(new Dimension(500, 22));
/*  672 */     this.jPanel15.setMinimumSize(new Dimension(500, 22));
/*  673 */     this.jPanel15.setPreferredSize(new Dimension(500, 22));
/*  674 */     this.jPanel15.setLayout(new GridLayout(1, 0));
/*      */     
/*  676 */     this.jPanel16.setLayout(new GridLayout(1, 6, 10, 0));
/*      */     
/*  678 */     this.jLabel63.setText("Fecha");
/*  679 */     this.jPanel16.add(this.jLabel63);
/*      */     
/*  681 */     this.jDateChooser1.setDate(this.fecha);
/*  682 */     this.jDateChooser1.setIcon(this.icon);
/*  683 */     this.jDateChooser1.setMaxSelectableDate(this.fecha);
/*  684 */     this.jDateChooser1.setMinSelectableDate(new Date(1283320867000L));
/*  685 */     this.jPanel16.add((Component)this.jDateChooser1);
/*      */     
/*  687 */     this.jLabel66.setText("hasta");
/*  688 */     this.jPanel16.add(this.jLabel66);
/*      */     
/*  690 */     this.jDateChooser2.setDate(this.fecha);
/*  691 */     this.jDateChooser2.setIcon(this.icon);
/*  692 */     this.jDateChooser2.setMaxSelectableDate(this.fecha);
/*  693 */     this.jDateChooser2.setMinSelectableDate(new Date(1283320867000L));
/*  694 */     this.jPanel16.add((Component)this.jDateChooser2);
/*      */     
/*  696 */     this.jButton13.setText("Clic para buscar");
/*  697 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  699 */             Archivo.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*  702 */     this.jPanel16.add(this.jButton13);
/*      */     
/*  704 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/*  705 */     this.jPanel20.setLayout(jPanel20Layout);
/*  706 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/*  707 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  708 */         .addGap(0, 97, 32767));
/*      */     
/*  710 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/*  711 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  712 */         .addGap(0, 27, 32767));
/*      */ 
/*      */     
/*  715 */     this.jPanel16.add(this.jPanel20);
/*      */     
/*  717 */     this.jPanel15.add(this.jPanel16);
/*      */     
/*  719 */     this.jPanel19.setBorder(BorderFactory.createTitledBorder("Filtra la búsqueda, con algún campo"));
/*  720 */     this.jPanel19.setLayout(new GridLayout(3, 3, 10, 6));
/*      */     
/*  722 */     this.jLabel5.setText("Guía");
/*  723 */     this.jPanel19.add(this.jLabel5);
/*      */     
/*  725 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  727 */             Archivo.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  730 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  732 */             Archivo.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*  735 */     this.jPanel19.add(this.jTextField3);
/*      */     
/*  737 */     this.jLabel32.setText("Cliente");
/*  738 */     this.jPanel19.add(this.jLabel32);
/*      */     
/*  740 */     this.jComboBox20.setBackground(new Color(244, 244, 244));
/*  741 */     this.jComboBox20.setFont(new Font("Tahoma", 0, 10));
/*  742 */     this.jComboBox20.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  743 */     this.jComboBox20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  745 */             Archivo.this.jComboBox20ActionPerformed(evt);
/*      */           }
/*      */         });
/*  748 */     this.jPanel19.add(this.jComboBox20);
/*      */     
/*  750 */     this.jLabel17.setText("Servicio");
/*  751 */     this.jPanel19.add(this.jLabel17);
/*      */     
/*  753 */     this.jComboBox10.setBackground(new Color(244, 244, 244));
/*  754 */     this.jComboBox10.setFont(new Font("Tahoma", 0, 10));
/*  755 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "FLETE", "MOVIMIENTO EN FALSO", "MOVIMIENTO INTERNO", "MOVIMIENTO LATERAL", "SERVICIO INTEGRAL", "SERVICIO DE RETRO", "RENTA" }));
/*  756 */     this.jComboBox10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  758 */             Archivo.this.jComboBox10ActionPerformed(evt);
/*      */           }
/*      */         });
/*  761 */     this.jPanel19.add(this.jComboBox10);
/*      */     
/*  763 */     this.jLabel6.setText("Residuo");
/*  764 */     this.jPanel19.add(this.jLabel6);
/*      */     
/*  766 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  767 */     this.jComboBox5.setFont(new Font("Tahoma", 0, 10));
/*  768 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  770 */             Archivo.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*  773 */     this.jPanel19.add(this.jComboBox5);
/*      */     
/*  775 */     this.jLabel7.setText("Tipo");
/*  776 */     this.jPanel19.add(this.jLabel7);
/*      */     
/*  778 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*  779 */     this.jComboBox6.setFont(new Font("Tahoma", 0, 10));
/*  780 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "Bulldozer", "Cama Baja", "Contenedor Marino", "Cuello de Ganzo", "Excavadora Oruga", "Góndola", "Hiab", "LowBoy", "Pipa", "Plana", "Plataforma", "Presas Metálicas", "Presión y Vacío", "Porta Contenedores", "Retroexcavadora", "Tiro Directo", "Tolva Granelera", "Tolva De Alumnio", "Tolva De Acero Inoxidable", "Tolva Presurizada", "Otro" }));
/*  781 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  783 */             Archivo.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*  786 */     this.jPanel19.add(this.jComboBox6);
/*      */     
/*  788 */     this.jLabel8.setText("Equipo");
/*  789 */     this.jPanel19.add(this.jLabel8);
/*      */     
/*  791 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/*  792 */     this.jComboBox7.setFont(new Font("Tahoma", 0, 10));
/*  793 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  795 */             Archivo.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/*  798 */     this.jPanel19.add(this.jComboBox7);
/*      */     
/*  800 */     this.jLabel9.setText("Plat");
/*  801 */     this.jPanel19.add(this.jLabel9);
/*      */     
/*  803 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/*  804 */     this.jComboBox8.setFont(new Font("Tahoma", 0, 10));
/*  805 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  807 */             Archivo.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/*  810 */     this.jPanel19.add(this.jComboBox8);
/*      */     
/*  812 */     this.jLabel10.setText("Pozo");
/*  813 */     this.jPanel19.add(this.jLabel10);
/*      */     
/*  815 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/*  816 */     this.jComboBox9.setFont(new Font("Tahoma", 0, 10));
/*  817 */     this.jComboBox9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  819 */             Archivo.this.jComboBox9ActionPerformed(evt);
/*      */           }
/*      */         });
/*  822 */     this.jPanel19.add(this.jComboBox9);
/*      */     
/*  824 */     this.jLabel18.setText("Eco");
/*  825 */     this.jPanel19.add(this.jLabel18);
/*      */     
/*  827 */     this.jTextField7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  829 */             Archivo.this.jTextField7ActionPerformed(evt);
/*      */           }
/*      */         });
/*  832 */     this.jTextField7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  834 */             Archivo.this.jTextField7KeyReleased(evt);
/*      */           }
/*      */         });
/*  837 */     this.jPanel19.add(this.jTextField7);
/*      */     
/*  839 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/*  840 */     this.jTable3.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  851 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  853 */             Archivo.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/*  856 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/*  858 */     this.jLabel50.setFont(new Font("Tahoma", 1, 11));
/*  859 */     this.jLabel50.setForeground(Color.red);
/*  860 */     this.jLabel50.setHorizontalAlignment(0);
/*  861 */     this.jLabel50.setText("t");
/*  862 */     this.jLabel50.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  864 */     this.jButton7.setMnemonic('A');
/*  865 */     this.jButton7.setText("Agregar Guía");
/*  866 */     this.jButton7.setToolTipText("Agregar Guía (Alt+A)");
/*  867 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  869 */             Archivo.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  873 */     this.jButton6.setMnemonic('T');
/*  874 */     this.jButton6.setText("Agregar Todos");
/*  875 */     this.jButton6.setToolTipText("Agregar Todas las Guías (Alt+T)");
/*  876 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  878 */             Archivo.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  882 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/*  883 */     this.jPanel14.setLayout(jPanel14Layout);
/*  884 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/*  885 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  886 */         .addComponent(this.jPanel15, -1, 642, 32767)
/*  887 */         .addComponent(this.jPanel19, GroupLayout.Alignment.TRAILING, -2, 0, 32767)
/*  888 */         .addComponent(this.jScrollPane3)
/*  889 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/*  890 */           .addComponent(this.jLabel50, -2, 135, -2)
/*  891 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  892 */           .addComponent(this.jButton7, -2, 116, -2)
/*  893 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  894 */           .addComponent(this.jButton6, -2, 116, -2)));
/*      */     
/*  896 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/*  897 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  898 */         .addGroup(jPanel14Layout.createSequentialGroup()
/*  899 */           .addComponent(this.jPanel15, -2, 49, -2)
/*  900 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  901 */           .addComponent(this.jPanel19, -2, -1, -2)
/*  902 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  903 */           .addComponent(this.jScrollPane3, -1, 155, 32767)
/*  904 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  905 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  906 */             .addComponent(this.jLabel50)
/*  907 */             .addComponent(this.jButton6)
/*  908 */             .addComponent(this.jButton7))
/*  909 */           .addContainerGap()));
/*      */ 
/*      */     
/*  912 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  913 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  914 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  915 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  916 */         .addComponent(this.jPanel14, -1, -1, 32767));
/*      */     
/*  918 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  919 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  920 */         .addComponent(this.jPanel14, -1, -1, 32767));
/*      */ 
/*      */     
/*  923 */     this.jDialog4.setTitle("Agregar Comentario a Guía");
/*  924 */     this.jDialog4.setModal(true);
/*      */     
/*  926 */     this.jPanel11.setBackground(Color.white);
/*      */     
/*  928 */     this.jLabel58.setFont(new Font("Times New Roman", 1, 18));
/*  929 */     this.jLabel58.setHorizontalAlignment(0);
/*  930 */     this.jLabel58.setText("ORGANIZAR COMENTARIOS");
/*      */     
/*  932 */     this.jLabel59.setText("Comentario:");
/*      */     
/*  934 */     this.jTextArea2.setColumns(20);
/*  935 */     this.jTextArea2.setLineWrap(true);
/*  936 */     this.jTextArea2.setRows(5);
/*  937 */     this.jScrollPane5.setViewportView(this.jTextArea2);
/*      */     
/*  939 */     this.jButton18.setMnemonic('C');
/*  940 */     this.jButton18.setText("Cerrar");
/*  941 */     this.jButton18.setToolTipText("Cerrar (Alt+C)");
/*  942 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  944 */             Archivo.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  948 */     this.jButton19.setMnemonic('A');
/*  949 */     this.jButton19.setText("Aceptar");
/*  950 */     this.jButton19.setToolTipText("Aceptar (Alt+A)");
/*  951 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  953 */             Archivo.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  957 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/*  958 */     this.jPanel11.setLayout(jPanel11Layout);
/*  959 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/*  960 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  961 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  962 */           .addContainerGap()
/*  963 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  964 */             .addComponent(this.jLabel59, -2, 102, -2)
/*  965 */             .addComponent(this.jSeparator6)
/*  966 */             .addComponent(this.jLabel58, -2, 356, -2)
/*  967 */             .addComponent(this.jScrollPane5, -2, 360, -2)
/*  968 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/*  969 */               .addGap(0, 0, 32767)
/*  970 */               .addComponent(this.jButton19, -2, 92, -2)
/*  971 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  972 */               .addComponent(this.jButton18, -2, 92, -2)))
/*  973 */           .addContainerGap()));
/*      */     
/*  975 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/*  976 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  977 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  978 */           .addComponent(this.jLabel58, -2, 25, -2)
/*  979 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  980 */           .addComponent(this.jSeparator6, -2, 10, -2)
/*  981 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  982 */           .addComponent(this.jLabel59)
/*  983 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  984 */           .addComponent(this.jScrollPane5, -2, 110, -2)
/*  985 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  986 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  987 */             .addComponent(this.jButton18)
/*  988 */             .addComponent(this.jButton19))
/*  989 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  992 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/*  993 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/*  994 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/*  995 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  996 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */     
/*  998 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/*  999 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1000 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */ 
/*      */     
/* 1003 */     this.jMenuItem1.setText("Agregar Columna");
/* 1004 */     this.jMenuItem1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1006 */             Archivo.this.jMenuItem1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1009 */     this.jPopupMenu1.add(this.jMenuItem1);
/*      */     
/* 1011 */     this.jMenuItem2.setText("Quitar Columna RSP");
/* 1012 */     this.jMenuItem2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1014 */             Archivo.this.jMenuItem2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1017 */     this.jPopupMenu1.add(this.jMenuItem2);
/* 1018 */     this.jPopupMenu1.add(this.jSeparator7);
/*      */     
/* 1020 */     this.jMenuItem3.setText("Imprimir");
/* 1021 */     this.jMenuItem3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1023 */             Archivo.this.jMenuItem3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1026 */     this.jPopupMenu1.add(this.jMenuItem3);
/*      */     
/* 1028 */     this.jMenuItem4.setText("Guardar Reporte");
/* 1029 */     this.jMenuItem4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1031 */             Archivo.this.jMenuItem4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1034 */     this.jPopupMenu1.add(this.jMenuItem4);
/*      */     
/* 1036 */     this.jDialog5.setTitle("Selecciona el tipo de reporte");
/* 1037 */     this.jDialog5.setModal(true);
/*      */     
/* 1039 */     this.jPanel12.setBackground(new Color(255, 255, 255));
/*      */     
/* 1041 */     this.jLabel61.setFont(new Font("Times New Roman", 1, 21));
/* 1042 */     this.jLabel61.setHorizontalAlignment(0);
/* 1043 */     this.jLabel61.setText("Selecciona el tipo de Reporte");
/*      */     
/* 1045 */     this.jButton20.setText("<html>SCHLUMBERGER / MI SWACO</html>");
/* 1046 */     this.jButton20.setToolTipText("Crea un reporte tipo SLB ó MI con una columna de PEDIDO");
/* 1047 */     this.jButton20.setActionCommand("<html><center>SCHLUMBERGER / MI SWACO</center></html>");
/* 1048 */     this.jButton20.setHorizontalTextPosition(0);
/* 1049 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1051 */             Archivo.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1055 */     this.jButton21.setText("WEATHERFORD");
/* 1056 */     this.jButton21.setToolTipText("Crea un reporte tipo WTF con la columna RSP");
/* 1057 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1059 */             Archivo.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1063 */     this.jButton22.setText("GENERAL");
/* 1064 */     this.jButton22.setToolTipText("Crea reportes generales con la columna especificando el cliente.");
/* 1065 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1067 */             Archivo.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1071 */     this.jLabel62.setFont(new Font("Tahoma", 2, 11));
/* 1072 */     this.jLabel62.setForeground(Color.darkGray);
/* 1073 */     this.jLabel62.setText("Selecciona algún tipo de reporte para crear los datos necesarios.");
/*      */     
/* 1075 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1076 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1077 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1078 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1079 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1080 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1081 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1082 */               .addContainerGap()
/* 1083 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1084 */                 .addComponent(this.jLabel61, -1, -1, 32767)
/* 1085 */                 .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1086 */                   .addComponent(this.jSeparator8, GroupLayout.Alignment.LEADING)
/* 1087 */                   .addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
/* 1088 */                     .addComponent(this.jButton20, -2, 179, -2)
/* 1089 */                     .addGap(37, 37, 37)
/* 1090 */                     .addComponent(this.jButton21, -2, 179, -2)))
/* 1091 */                 .addComponent(this.jSeparator9)
/* 1092 */                 .addComponent(this.jLabel62, -2, 364, -2)))
/* 1093 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1094 */               .addGap(116, 116, 116)
/* 1095 */               .addComponent(this.jButton22, -2, 179, -2)))
/* 1096 */           .addContainerGap()));
/*      */     
/* 1098 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1099 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1100 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1101 */           .addComponent(this.jLabel61)
/* 1102 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1103 */           .addComponent(this.jSeparator8, -2, 10, -2)
/* 1104 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1105 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1106 */             .addComponent(this.jButton20, -2, 146, -2)
/* 1107 */             .addComponent(this.jButton21, -2, 146, -2))
/* 1108 */           .addGap(18, 18, 18)
/* 1109 */           .addComponent(this.jButton22, -2, 146, -2)
/* 1110 */           .addGap(33, 33, 33)
/* 1111 */           .addComponent(this.jSeparator9, -2, 10, -2)
/* 1112 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1113 */           .addComponent(this.jLabel62)
/* 1114 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1117 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1118 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1119 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1120 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1121 */         .addComponent(this.jPanel12, -2, -1, -2));
/*      */     
/* 1123 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1124 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1125 */         .addComponent(this.jPanel12, -2, -1, -2));
/*      */ 
/*      */     
/* 1128 */     this.jDialog6.setTitle("Cancelar Prefacturación");
/* 1129 */     this.jDialog6.setModal(true);
/*      */     
/* 1131 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*      */     
/* 1133 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/* 1134 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/* 1135 */     this.jLabel124.setHorizontalAlignment(0);
/* 1136 */     this.jLabel124.setText("Motivo de la Cancelación");
/*      */     
/* 1138 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/* 1139 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/* 1140 */     this.jLabel125.setHorizontalAlignment(4);
/* 1141 */     this.jLabel125.setText("Motivo ");
/*      */     
/* 1143 */     this.jButton44.setMnemonic('A');
/* 1144 */     this.jButton44.setText("Cancelar Reporte");
/* 1145 */     this.jButton44.setToolTipText("Cancelar Movimiento (Alt+A)");
/* 1146 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1148 */             Archivo.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1152 */     this.jButton45.setMnemonic('C');
/* 1153 */     this.jButton45.setText("Cerrar");
/* 1154 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 1155 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1157 */             Archivo.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1161 */     this.jTextArea5.setColumns(20);
/* 1162 */     this.jTextArea5.setLineWrap(true);
/* 1163 */     this.jTextArea5.setRows(5);
/* 1164 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 1166 */     this.jLabel126.setText("Ingresa el motivo por el cual deseas cancelar el movimiento");
/*      */     
/* 1168 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1169 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1170 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1171 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1172 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1173 */           .addContainerGap()
/* 1174 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1175 */             .addComponent(this.jLabel126, -1, -1, 32767)
/* 1176 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1177 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 1178 */                 .addComponent(this.jButton44)
/* 1179 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1180 */                 .addComponent(this.jButton45, -2, 84, -2))
/* 1181 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 1182 */                 .addComponent(this.jLabel125, -2, 43, -2)
/* 1183 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1184 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/* 1185 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1186 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1187 */               .addComponent(this.jSeparator27, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/* 1188 */           .addContainerGap()));
/*      */     
/* 1190 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1191 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1192 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1193 */           .addComponent(this.jLabel124)
/* 1194 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1195 */           .addComponent(this.jSeparator27, -2, 10, -2)
/* 1196 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1197 */           .addComponent(this.jLabel126)
/* 1198 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1199 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1200 */             .addComponent(this.jLabel125)
/* 1201 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 1202 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1203 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1204 */             .addComponent(this.jButton45)
/* 1205 */             .addComponent(this.jButton44))
/* 1206 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1209 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1210 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1211 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1212 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1213 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */     
/* 1215 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1216 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1217 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */ 
/*      */     
/* 1220 */     this.jDialog2.setTitle("Prefactura con Precios");
/* 1221 */     this.jDialog2.setModal(true);
/*      */     
/* 1223 */     this.jPanel4.setBackground(Color.white);
/*      */     
/* 1225 */     this.jLabel13.setFont(new Font("Times New Roman", 1, 24));
/* 1226 */     this.jLabel13.setHorizontalAlignment(0);
/* 1227 */     this.jLabel13.setText("PREFACTURA CON PRECIOS");
/*      */     
/* 1229 */     this.jLabel14.setText("<html>A continuación se muestran los viajes con precio para el cliente. Si deseas cambiar la tarifa necesitas autorización</html>");
/*      */     
/* 1231 */     this.jTable4.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null }, , { null, null, null, null, null, null, null, null, null },  }, (Object[])new String[] { "Guía", "Fecha", "Residuo", "Pozo", "Ticket", "Tons", "Destino", "Precio U", "Total" })
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
/* 1242 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, true, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1247 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1250 */     this.jScrollPane4.setViewportView(this.jTable4);
/*      */     
/* 1252 */     this.jButton3.setMnemonic('C');
/* 1253 */     this.jButton3.setText("Cancelar");
/* 1254 */     this.jButton3.setToolTipText("Cancelar (Alt+C)");
/* 1255 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1257 */             Archivo.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1261 */     this.jButton9.setMnemonic('A');
/* 1262 */     this.jButton9.setText("Autorizar");
/* 1263 */     this.jButton9.setToolTipText("Autorizar Prefactura con Precios (Alt+A)");
/*      */     
/* 1265 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1266 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1267 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 1268 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1269 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1270 */           .addContainerGap()
/* 1271 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1272 */             .addComponent(this.jScrollPane4, -1, 614, 32767)
/* 1273 */             .addComponent(this.jSeparator3, -1, 614, 32767)
/* 1274 */             .addComponent(this.jLabel13, -1, 614, 32767)
/* 1275 */             .addComponent(this.jLabel14, -1, 614, 32767)
/* 1276 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 1277 */               .addComponent(this.jButton9, -2, 109, -2)
/* 1278 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1279 */               .addComponent(this.jButton3, -2, 109, -2)))
/* 1280 */           .addContainerGap()));
/*      */     
/* 1282 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 1283 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1284 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1285 */           .addComponent(this.jLabel13)
/* 1286 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1287 */           .addComponent(this.jSeparator3, -2, 10, -2)
/* 1288 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1289 */           .addComponent(this.jLabel14, -2, -1, -2)
/* 1290 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1291 */           .addComponent(this.jScrollPane4, -1, 372, 32767)
/* 1292 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1293 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1294 */             .addComponent(this.jButton3)
/* 1295 */             .addComponent(this.jButton9))
/* 1296 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1299 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1300 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1301 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1302 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1303 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*      */     
/* 1305 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1306 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1307 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*      */ 
/*      */     
/* 1310 */     this.jDialog7.setTitle("Agregar Pedido");
/* 1311 */     this.jDialog7.setModal(true);
/*      */     
/* 1313 */     this.jPanel13.setBackground(Color.white);
/*      */     
/* 1315 */     this.jLabel64.setFont(new Font("Times New Roman", 1, 18));
/* 1316 */     this.jLabel64.setHorizontalAlignment(0);
/* 1317 */     this.jLabel64.setText("INGRESA EL PEDIDO");
/*      */     
/* 1319 */     this.jLabel65.setText("Pedido:");
/*      */     
/* 1321 */     this.jButton23.setMnemonic('C');
/* 1322 */     this.jButton23.setText("Cerrar");
/* 1323 */     this.jButton23.setToolTipText("Cerrar (Alt+C)");
/* 1324 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1326 */             Archivo.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1330 */     this.jButton24.setMnemonic('A');
/* 1331 */     this.jButton24.setText("Aceptar");
/* 1332 */     this.jButton24.setToolTipText("Aceptar (Alt+A)");
/* 1333 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1335 */             Archivo.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1339 */     this.jTextField5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1341 */             Archivo.this.jTextField5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1345 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 1346 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1347 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 1348 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1349 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1350 */           .addContainerGap()
/* 1351 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1352 */             .addComponent(this.jLabel65, -2, 102, -2)
/* 1353 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/* 1354 */               .addComponent(this.jButton24, -2, 92, -2)
/* 1355 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1356 */               .addComponent(this.jButton23, -2, 92, -2))
/* 1357 */             .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1358 */               .addComponent(this.jLabel64, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1359 */               .addComponent(this.jSeparator10, GroupLayout.Alignment.LEADING)
/* 1360 */               .addComponent(this.jTextField5, GroupLayout.Alignment.LEADING, -1, 254, 32767)))
/* 1361 */           .addContainerGap()));
/*      */     
/* 1363 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 1364 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1365 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 1366 */           .addComponent(this.jLabel64, -2, 25, -2)
/* 1367 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1368 */           .addComponent(this.jSeparator10, -2, 10, -2)
/* 1369 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1370 */           .addComponent(this.jLabel65)
/* 1371 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1372 */           .addComponent(this.jTextField5, -2, -1, -2)
/* 1373 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1374 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1375 */             .addComponent(this.jButton23)
/* 1376 */             .addComponent(this.jButton24))
/* 1377 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1380 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 1381 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 1382 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 1383 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1384 */         .addComponent(this.jPanel13, -2, -1, -2));
/*      */     
/* 1386 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 1387 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1388 */         .addComponent(this.jPanel13, -2, -1, -2));
/*      */ 
/*      */     
/* 1391 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*      */     
/* 1393 */     this.jPanel5.setBackground(new Color(255, 255, 255));
/*      */     
/* 1395 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1396 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1397 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1398 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1399 */         .addGap(0, 559, 32767));
/*      */     
/* 1401 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1402 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1403 */         .addGap(0, 50, 32767));
/*      */ 
/*      */     
/* 1406 */     this.jPanel7.setBackground(new Color(255, 255, 255));
/*      */     
/* 1408 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1409 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1410 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1411 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1412 */         .addGap(0, 236, 32767));
/*      */     
/* 1414 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1415 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1416 */         .addGap(0, 0, 32767));
/*      */ 
/*      */     
/* 1419 */     this.jPanel9.setBackground(new Color(255, 255, 255));
/*      */     
/* 1421 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1422 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1423 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1424 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1425 */         .addGap(0, 256, 32767));
/*      */     
/* 1427 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1428 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1429 */         .addGap(0, 103, 32767));
/*      */ 
/*      */     
/* 1432 */     this.jPanel10.setBackground(new Color(255, 255, 255));
/*      */     
/* 1434 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1435 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1436 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1437 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1438 */         .addGap(0, 269, 32767));
/*      */     
/* 1440 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1441 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1442 */         .addGap(0, 0, 32767));
/*      */ 
/*      */     
/* 1445 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1446 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1447 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 1448 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1449 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1450 */           .addContainerGap()
/* 1451 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1452 */             .addComponent(this.jPanel5, -2, -1, -2)
/* 1453 */             .addGroup(jPanel3Layout.createSequentialGroup()
/* 1454 */               .addComponent(this.jPanel9, -2, -1, -2)
/* 1455 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1456 */               .addComponent(this.jPanel10, -2, -1, -2)
/* 1457 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1458 */               .addComponent(this.jPanel7, -2, -1, -2))
/* 1459 */             .addComponent(this.jSeparator2, -2, 799, -2))
/* 1460 */           .addContainerGap(172, 32767)));
/*      */     
/* 1462 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 1463 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1464 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1465 */           .addComponent(this.jPanel5, -2, -1, -2)
/* 1466 */           .addGap(41, 41, 41)
/* 1467 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 1468 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1469 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1470 */             .addComponent(this.jPanel7, -1, -1, 32767)
/* 1471 */             .addComponent(this.jPanel10, -1, -1, 32767)
/* 1472 */             .addComponent(this.jPanel9, -1, -1, 32767))
/* 1473 */           .addGap(314, 314, 314)));
/*      */ 
/*      */     
/* 1476 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/* 1477 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1479 */     this.jLabel3.setFont(new Font("Tahoma", 1, 18));
/* 1480 */     this.jLabel3.setForeground(new Color(10, 126, 68));
/* 1481 */     this.jLabel3.setText("ARCHIVO");
/*      */     
/* 1483 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 1484 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Reporte Interno", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1486 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1488 */             Archivo.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1492 */     this.jLabel15.setFont(new Font("Tahoma", 3, 12));
/* 1493 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 1494 */     this.jLabel15.setHorizontalAlignment(0);
/* 1495 */     this.jLabel15.setText("Folio ó Referencia");
/*      */     
/* 1497 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1498 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 1499 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVA", "CANCELADA", "TODAS" }));
/* 1500 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1502 */             Archivo.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1506 */     this.jLabel46.setFont(new Font("Tahoma", 3, 12));
/* 1507 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 1508 */     this.jLabel46.setHorizontalAlignment(0);
/* 1509 */     this.jLabel46.setText("Estado - Archivo");
/*      */     
/* 1511 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 1512 */     this.jComboBox2.setFont(new Font("Tahoma", 1, 11));
/* 1513 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "TODOS" }));
/* 1514 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1516 */             Archivo.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1520 */     this.jLabel47.setFont(new Font("Tahoma", 3, 12));
/* 1521 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/* 1522 */     this.jLabel47.setHorizontalAlignment(0);
/* 1523 */     this.jLabel47.setText("Responsable");
/*      */     
/* 1525 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 1526 */     this.jComboBox3.setFont(new Font("Tahoma", 1, 11));
/* 1527 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "TODOS" }));
/* 1528 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1530 */             Archivo.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1534 */     this.jLabel49.setFont(new Font("Tahoma", 3, 12));
/* 1535 */     this.jLabel49.setForeground(new Color(15, 87, 51));
/* 1536 */     this.jLabel49.setHorizontalAlignment(0);
/* 1537 */     this.jLabel49.setText("Cliente");
/*      */     
/* 1539 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1541 */             Archivo.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1545 */     this.jLabel16.setFont(new Font("Tahoma", 3, 12));
/* 1546 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/* 1547 */     this.jLabel16.setHorizontalAlignment(0);
/* 1548 */     this.jLabel16.setText("Núm");
/*      */     
/* 1550 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 1551 */     this.jPanel17.setLayout(jPanel17Layout);
/* 1552 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 1553 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1554 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1555 */           .addContainerGap()
/* 1556 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1557 */             .addComponent(this.jLabel46, -1, -1, 32767)
/* 1558 */             .addComponent(this.jComboBox1, -2, 134, -2))
/* 1559 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1560 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1561 */             .addComponent(this.jLabel47, -1, -1, 32767)
/* 1562 */             .addComponent(this.jComboBox2, -2, 163, -2))
/* 1563 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1564 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1565 */             .addComponent(this.jLabel49, -1, -1, 32767)
/* 1566 */             .addComponent(this.jComboBox3, -2, 213, -2))
/* 1567 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1568 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1569 */             .addComponent(this.jLabel16, -1, -1, 32767)
/* 1570 */             .addComponent(this.jTextField6, -2, 128, -2))
/* 1571 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1572 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1573 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 1574 */             .addComponent(this.jTextField1, -2, 128, -2))
/* 1575 */           .addContainerGap(274, 32767)));
/*      */     
/* 1577 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 1578 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1579 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1580 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1581 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1582 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 1583 */                 .addComponent(this.jTextField6, -2, -1, -2)
/* 1584 */                 .addGap(8, 8, 8)
/* 1585 */                 .addComponent(this.jLabel16))
/* 1586 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 1587 */                 .addComponent(this.jTextField1, -2, -1, -2)
/* 1588 */                 .addGap(8, 8, 8)
/* 1589 */                 .addComponent(this.jLabel15)))
/* 1590 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1591 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 1592 */                 .addComponent(this.jComboBox1, -2, -1, -2)
/* 1593 */                 .addGap(8, 8, 8)
/* 1594 */                 .addComponent(this.jLabel46))
/* 1595 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 1596 */                 .addComponent(this.jComboBox2, -2, -1, -2)
/* 1597 */                 .addGap(8, 8, 8)
/* 1598 */                 .addComponent(this.jLabel47))
/* 1599 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 1600 */                 .addComponent(this.jComboBox3, -2, -1, -2)
/* 1601 */                 .addGap(8, 8, 8)
/* 1602 */                 .addComponent(this.jLabel49))))
/* 1603 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1606 */     this.jPanel18.setBackground(new Color(146, 193, 134));
/* 1607 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder(null, "Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1609 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/* 1610 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Ruta", "Operador", "Eco", "Guías", "Autorizó" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1618 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1623 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1626 */     this.jTable2.setShowVerticalLines(false);
/* 1627 */     this.jTable2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1629 */             Archivo.this.jTable2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1632 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/* 1634 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1635 */     this.jLabel48.setForeground(Color.red);
/* 1636 */     this.jLabel48.setHorizontalAlignment(0);
/* 1637 */     this.jLabel48.setText("t");
/* 1638 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1640 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1641 */     this.jButton4.setMnemonic('N');
/* 1642 */     this.jButton4.setText("Nuevo");
/* 1643 */     this.jButton4.setToolTipText("Nueva Archivo (Alt+N)");
/* 1644 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1646 */             Archivo.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1650 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1651 */     this.jButton5.setMnemonic('M');
/* 1652 */     this.jButton5.setText("Modificar");
/* 1653 */     this.jButton5.setToolTipText("Modificar Archivo (Alt+M)");
/* 1654 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1656 */             Archivo.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1660 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1661 */     this.jButton11.setMnemonic('C');
/* 1662 */     this.jButton11.setText("Cancelar");
/* 1663 */     this.jButton11.setToolTipText("Cancelar (Alt+C)");
/* 1664 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1666 */             Archivo.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1670 */     this.jButton34.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1671 */     this.jButton34.setMnemonic('G');
/* 1672 */     this.jButton34.setText("Guardar Reporte");
/* 1673 */     this.jButton34.setToolTipText("Guardar Reporte (Alt+G)");
/* 1674 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1676 */             Archivo.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1680 */     this.jButton12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1681 */     this.jButton12.setMnemonic('V');
/* 1682 */     this.jButton12.setText("Ver");
/* 1683 */     this.jButton12.setToolTipText("Ver Archivo (Alt+V)");
/* 1684 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1686 */             Archivo.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1690 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 1691 */     this.jPanel18.setLayout(jPanel18Layout);
/* 1692 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 1693 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1694 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1695 */           .addContainerGap()
/* 1696 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1697 */             .addComponent(this.jScrollPane2, -1, 1076, 32767)
/* 1698 */             .addGroup(jPanel18Layout.createSequentialGroup()
/* 1699 */               .addComponent(this.jLabel48, -2, 163, -2)
/* 1700 */               .addGap(18, 18, 18)
/* 1701 */               .addComponent(this.jButton4, -2, 110, -2)
/* 1702 */               .addGap(18, 18, 18)
/* 1703 */               .addComponent(this.jButton5, -2, 107, -2)
/* 1704 */               .addGap(18, 18, 18)
/* 1705 */               .addComponent(this.jButton11, -2, 114, -2)
/* 1706 */               .addGap(18, 18, 18)
/* 1707 */               .addComponent(this.jButton12, -2, 114, -2)
/* 1708 */               .addGap(89, 89, 89)
/* 1709 */               .addComponent(this.jButton34, -2, 154, -2)
/* 1710 */               .addGap(0, 0, 32767)))
/* 1711 */           .addContainerGap()));
/*      */     
/* 1713 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 1714 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1715 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1716 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1717 */             .addComponent(this.jLabel48)
/* 1718 */             .addComponent(this.jButton4)
/* 1719 */             .addComponent(this.jButton5)
/* 1720 */             .addComponent(this.jButton11)
/* 1721 */             .addComponent(this.jButton12)
/* 1722 */             .addComponent(this.jButton34))
/* 1723 */           .addGap(4, 4, 4)
/* 1724 */           .addComponent(this.jScrollPane2, -1, 173, 32767)));
/*      */ 
/*      */     
/* 1727 */     this.jPanel8.setBackground(new Color(255, 255, 255));
/* 1728 */     this.jPanel8.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 1730 */     this.jDateChooser11.setDate(this.fechaActual);
/* 1731 */     this.jDateChooser11.setDateFormatString("dd/MM/yyyy");
/* 1732 */     this.jDateChooser11.setIcon(this.icon);
/* 1733 */     this.jDateChooser11.setMaxSelectableDate(this.fecha);
/* 1734 */     this.jDateChooser11.setMinSelectableDate(new Date(1286690512000L));
/*      */     
/* 1736 */     this.jDateChooser12.setDate(this.fechaActual);
/* 1737 */     this.jDateChooser12.setDateFormatString("dd/MM/yyyy");
/* 1738 */     this.jDateChooser12.setIcon(this.icon);
/* 1739 */     this.jDateChooser12.setMaxSelectableDate(this.fechaActual);
/* 1740 */     this.jDateChooser12.setMinSelectableDate(new Date(1286690512000L));
/*      */     
/* 1742 */     this.jLabel37.setFont(new Font("Tahoma", 2, 12));
/* 1743 */     this.jLabel37.setForeground(new Color(15, 87, 51));
/* 1744 */     this.jLabel37.setText("<html><u>Todos </u></html>");
/* 1745 */     this.jLabel37.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1747 */             Archivo.this.jLabel37MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1750 */             Archivo.this.jLabel37MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1753 */             Archivo.this.jLabel37MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1757 */     this.jLabel38.setFont(new Font("Tahoma", 2, 12));
/* 1758 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/* 1759 */     this.jLabel38.setHorizontalAlignment(0);
/* 1760 */     this.jLabel38.setText("<html><u>Hoy</u></html>");
/* 1761 */     this.jLabel38.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1763 */             Archivo.this.jLabel38MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1766 */             Archivo.this.jLabel38MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1769 */             Archivo.this.jLabel38MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1773 */     this.jLabel39.setFont(new Font("Tahoma", 2, 12));
/* 1774 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 1775 */     this.jLabel39.setText("<html><u>Ayer</u></html>");
/* 1776 */     this.jLabel39.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1778 */             Archivo.this.jLabel39MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1781 */             Archivo.this.jLabel39MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1784 */             Archivo.this.jLabel39MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1788 */     this.jLabel40.setFont(new Font("Tahoma", 1, 15));
/* 1789 */     this.jLabel40.setForeground(Color.red);
/* 1790 */     this.jLabel40.setHorizontalAlignment(4);
/* 1791 */     this.jLabel40.setText("REPORTE DEL");
/*      */     
/* 1793 */     this.jLabel41.setFont(new Font("Tahoma", 1, 15));
/* 1794 */     this.jLabel41.setForeground(Color.red);
/* 1795 */     this.jLabel41.setHorizontalAlignment(0);
/* 1796 */     this.jLabel41.setText("AL");
/*      */     
/* 1798 */     this.jButton15.setMnemonic('F');
/* 1799 */     this.jButton15.setText("Filtrar");
/* 1800 */     this.jButton15.setToolTipText("Filtrar información (Alt+F)");
/* 1801 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1803 */             Archivo.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1807 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1808 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1809 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1810 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1811 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1812 */           .addContainerGap()
/* 1813 */           .addComponent(this.jLabel40, -2, 130, -2)
/* 1814 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1815 */           .addComponent((Component)this.jDateChooser11, -2, 108, -2)
/* 1816 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1817 */           .addComponent(this.jLabel41)
/* 1818 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1819 */           .addComponent((Component)this.jDateChooser12, -2, 108, -2)
/* 1820 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1821 */           .addComponent(this.jButton15)
/* 1822 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1823 */           .addComponent(this.jLabel37, -2, -1, -2)
/* 1824 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1825 */           .addComponent(this.jLabel38, -2, 31, -2)
/* 1826 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1827 */           .addComponent(this.jLabel39, -2, 31, -2)
/* 1828 */           .addContainerGap(43, 32767)));
/*      */     
/* 1830 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1831 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1832 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1833 */           .addContainerGap()
/* 1834 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1835 */             .addComponent(this.jLabel40, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1836 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 1837 */               .addGap(1, 1, 1)
/* 1838 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1839 */                 .addComponent((Component)this.jDateChooser11, GroupLayout.Alignment.TRAILING, -2, -1, -2)
/* 1840 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1841 */                   .addComponent(this.jLabel37, -2, 19, -2)
/* 1842 */                   .addComponent(this.jLabel38, -2, 15, -2)
/* 1843 */                   .addComponent(this.jLabel39, -2, -1, -2)
/* 1844 */                   .addComponent(this.jButton15))
/* 1845 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 1846 */                   .addComponent(this.jLabel41, -2, 19, -2)
/* 1847 */                   .addGap(1, 1, 1))
/* 1848 */                 .addComponent((Component)this.jDateChooser12, GroupLayout.Alignment.TRAILING, -2, -1, -2))))));
/*      */ 
/*      */     
/* 1851 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1852 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1853 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1854 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1855 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1856 */           .addContainerGap()
/* 1857 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1858 */             .addComponent(this.jPanel18, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1859 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 1860 */               .addComponent(this.jPanel8, -2, -1, -2)
/* 1861 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767)
/* 1862 */               .addComponent(this.jLabel3, -2, 428, -2))
/* 1863 */             .addComponent(this.jPanel17, -1, -1, 32767))
/* 1864 */           .addContainerGap()));
/*      */     
/* 1866 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1867 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1868 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1869 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1870 */             .addComponent(this.jLabel3)
/* 1871 */             .addComponent(this.jPanel8, -2, -1, -2))
/* 1872 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1873 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 1874 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1875 */           .addComponent(this.jPanel18, -1, -1, 32767)
/* 1876 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1879 */     GroupLayout layout = new GroupLayout(this);
/* 1880 */     setLayout(layout);
/* 1881 */     layout.setHorizontalGroup(layout
/* 1882 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1883 */         .addGap(0, 1130, 32767)
/* 1884 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1885 */           .addGroup(layout.createSequentialGroup()
/* 1886 */             .addContainerGap()
/* 1887 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 1888 */             .addContainerGap())));
/*      */     
/* 1890 */     layout.setVerticalGroup(layout
/* 1891 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1892 */         .addGap(0, 386, 32767)
/* 1893 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1894 */           .addGroup(layout.createSequentialGroup()
/* 1895 */             .addGap(11, 11, 11)
/* 1896 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 1897 */             .addGap(11, 11, 11))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1902 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1906 */     if (this.jComboBox1.getItemCount() > 0 && this.PRIMERA == true) {
/* 1907 */       consultar();
/* 1908 */       if (this.jComboBox1.getSelectedIndex() == 1 || this.jComboBox1.getSelectedIndex() == 2) {
/* 1909 */         this.jButton5.setEnabled(false);
/* 1910 */         this.jButton11.setEnabled(false);
/*      */       } else {
/*      */         
/* 1913 */         this.jButton5.setEnabled(true);
/* 1914 */         this.jButton11.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable2MouseClicked(MouseEvent evt) {
/* 1920 */     if (evt.getClickCount() == 2) {
/* 1921 */       verFactura();
/*      */     } else {
/*      */       
/* 1924 */       this.jButton5.setEnabled(true);
/* 1925 */       this.jButton11.setEnabled(true);
/* 1926 */       this.jButton12.setEnabled(true);
/* 1927 */       if (this.jComboBox1.getSelectedIndex() == 1 || this.jComboBox1.getSelectedIndex() == 2) {
/* 1928 */         this.jButton5.setEnabled(false);
/* 1929 */         this.jButton11.setEnabled(false);
/*      */       } else {
/*      */         
/* 1932 */         this.jButton5.setEnabled(true);
/* 1933 */         this.jButton11.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1939 */     this.jComboBox21.setSelectedIndex(0);
/* 1940 */     this.jComboBox22.setSelectedIndex(0);
/* 1941 */     this.jComboBox23.setSelectedIndex(0);
/* 1942 */     this.jDateChooser4.setDate(new Date());
/* 1943 */     this.jTextField2.setText("");
/* 1944 */     this.PRESIONADO = false;
/* 1945 */     this.jFrame1.setTitle("Crear reporte interno");
/* 1946 */     this.jButton14.setText("Guardar");
/* 1947 */     this.jLabel60.setText("<html>NOTA: Para ordenar los datos puedes dar clic en el encabezado de las columnas</html>");
/* 1948 */     this.jLabel60.setToolTipText("<html>NOTA: Para ordenar los datos puedes dar clic en el encabezado de las columnas</html>");
/* 1949 */     this.jComboBox4.setEnabled(true);
/* 1950 */     this.jComboBox21.setEnabled(true);
/* 1951 */     this.jComboBox22.setEnabled(true);
/* 1952 */     this.jComboBox23.setEnabled(true);
/* 1953 */     this.jDateChooser4.setEnabled(true);
/* 1954 */     this.jTextField2.setEnabled(true);
/* 1955 */     this.jButton17.setVisible(true);
/* 1956 */     this.jButton1.setVisible(true);
/* 1957 */     this.jButton2.setVisible(true);
/* 1958 */     this.jButton14.setVisible(true);
/* 1959 */     this.jButton10.setVisible(true);
/* 1960 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1964 */     String estatus = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 12));
/* 1965 */     if (estatus.equals("<Cerrada>")) {
/* 1966 */       JOptionPane.showMessageDialog(this.padre, "El archivo que seleccionaste ya se encuentra cerrado, selecciona otra archivo", "Archivo Cerrado", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1969 */       this.PRESIONADO = false;
/* 1970 */       this.jFrame1.setTitle("Modificar Factura");
/* 1971 */       this.jButton14.setText("Modificar");
/* 1972 */       this.jButton14.setToolTipText("Guarda la prefactura (Alt+G)");
/* 1973 */       this.jButton14.setMnemonic('G');
/* 1974 */       this.jLabel60.setText("<html>NOTA: Para ordenar los datos puedes dar clic en el encabezado de las columnas</html>");
/* 1975 */       this.jLabel60.setToolTipText("<html>NOTA: Para ordenar los datos puedes dar clic en el encabezado de las columnas</html>");
/* 1976 */       this.jComboBox4.setEnabled(true);
/* 1977 */       this.jComboBox21.setEnabled(true);
/* 1978 */       this.jComboBox22.setEnabled(true);
/* 1979 */       this.jComboBox23.setEnabled(true);
/* 1980 */       this.jDateChooser4.setEnabled(true);
/* 1981 */       this.jTextField2.setEnabled(true);
/* 1982 */       this.jButton17.setVisible(true);
/* 1983 */       this.jButton1.setVisible(true);
/* 1984 */       this.jButton2.setVisible(true);
/* 1985 */       this.jButton14.setVisible(true);
/* 1986 */       this.jButton10.setVisible(true);
/* 1987 */       this.jTextField4.setEnabled(true);
/* 1988 */       this.jCheckBox1.setEnabled(true);
/* 1989 */       int ind = this.jTable2.getSelectedRow();
/*      */       
/* 1991 */       String[] datos = { String.valueOf(this.jTable2.getValueAt(ind, 0)), String.valueOf(this.jTable2.getValueAt(ind, 1)), String.valueOf(this.jTable2.getValueAt(ind, 2)), String.valueOf(this.jTable2.getValueAt(ind, 3)), String.valueOf(this.jTable2.getValueAt(ind, 4)), String.valueOf(this.jTable2.getValueAt(ind, 5)), String.valueOf(this.jTable2.getValueAt(ind, 6)), String.valueOf(this.jTable2.getValueAt(ind, 7)), String.valueOf(this.jTable2.getValueAt(ind, 8)), String.valueOf(this.jTable2.getValueAt(ind, 9)), String.valueOf(this.jTable2.getValueAt(ind, 10)), String.valueOf(this.jTable2.getValueAt(ind, 11)) };
/* 1992 */       this.PREFAC = datos[0];
/*      */       
/* 1994 */       String año = datos[2].substring(0, 4);
/* 1995 */       String mes = datos[2].substring(5, 7);
/* 1996 */       String dia = datos[2].substring(8, 10);
/* 1997 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 1998 */       String strFecha = dia + "-" + dia + "-" + mes;
/* 1999 */       Date fechaG = null;
/*      */       try {
/* 2001 */         fechaG = formatoDelTexto.parse(strFecha);
/* 2002 */         this.jDateChooser4.setDate(fechaG);
/* 2003 */       } catch (ParseException ex) {
/* 2004 */         ex.printStackTrace();
/*      */       } 
/* 2006 */       if (datos[3].equals("<GENERAL>")) {
/* 2007 */         this.jComboBox4.setSelectedIndex(0);
/*      */       } else {
/* 2009 */         this.jComboBox4.setSelectedItem(datos[3]);
/*      */       } 
/*      */       
/* 2012 */       if (datos[4].equals("<GENERAL>")) {
/* 2013 */         this.jComboBox21.setSelectedIndex(0);
/*      */       } else {
/* 2015 */         this.jComboBox21.setSelectedItem(datos[4]);
/*      */       } 
/*      */       
/* 2018 */       if (datos[5].equals("<GENERAL>")) {
/* 2019 */         this.jComboBox22.setSelectedIndex(0);
/*      */       } else {
/* 2021 */         this.jComboBox22.setSelectedItem(datos[5]);
/*      */       } 
/* 2023 */       if (datos[6].equals("<GENERAL>")) {
/* 2024 */         this.jComboBox23.setSelectedIndex(0);
/*      */       } else {
/* 2026 */         this.jComboBox23.setSelectedItem(datos[6]);
/*      */       } 
/* 2028 */       this.jTextField2.setText(datos[1]);
/* 2029 */       String[] campos = this.con.regresaReg("tipo,tons,pedido", "prefacturas", "where numInterPre = " + datos[0], 3);
/* 2030 */       this.jTextField4.setText("");
/* 2031 */       this.jCheckBox1.setSelected(false);
/* 2032 */       if (!campos[2].equals("")) {
/* 2033 */         this.jTextField4.setText(campos[2]);
/* 2034 */         this.jCheckBox1.setSelected(true);
/*      */       } 
/* 2036 */       this.TIPOREPOR = Integer.parseInt(campos[0]);
/*      */       
/* 2038 */       if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2044 */         if (this.TIPOREPOR == 0) {
/* 2045 */           this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2046 */                 .buscarDatos(14, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,pedido,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Folio", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ped", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */               {
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 2052 */                 boolean[] canEdit = new boolean[] { 
/*      */                     false, false, false, false, false, false, false, false, false, false, 
/*      */                     false, false, false, false, false, false, false, false };
/*      */                 public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2056 */                   return this.canEdit[columnIndex];
/*      */                 }
/*      */               });
/*      */           
/* 2060 */           this.VIAJESTOT = this.jTable1.getRowCount();
/* 2061 */           this.TONS = Double.valueOf(Double.parseDouble(campos[1]));
/* 2062 */           this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable1.getRowCount() + "</HTML>");
/* 2063 */           this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + campos[1] + "</HTML>");
/* 2064 */           this.jTable1.moveColumn(13, 14);
/*      */         } else {
/* 2066 */           this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2067 */                 .buscarDatos(14, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,rsp,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Folio", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "R.S.P.", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */               {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 2074 */                 boolean[] canEdit = new boolean[] { 
/*      */                     false, false, false, false, false, false, false, false, false, false, 
/*      */                     false, false, false, false, false, false, false, false };
/*      */                 
/*      */                 public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2079 */                   return this.canEdit[columnIndex];
/*      */                 }
/*      */               });
/* 2082 */           this.jTable1.moveColumn(13, 14);
/*      */         } 
/* 2084 */         for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2085 */           String col = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 2086 */           String resi = String.valueOf(this.jTable1.getValueAt(i, 2));
/* 2087 */           if (resi.equals("SERVICIO INTEGRAL")) {
/* 2088 */             this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + col + "'");
/* 2089 */             if (this.encontrado) {
/* 2090 */               this.jTable1.setValueAt(this.con.Campo, i, 13);
/*      */             } else {
/* 2092 */               this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + col + "'");
/* 2093 */               if (this.encontrado) {
/* 2094 */                 this.jTable1.setValueAt(this.con.Campo, i, 13);
/*      */               } else {
/* 2096 */                 this.jTable1.setValueAt("", i, 13);
/*      */               } 
/*      */             } 
/*      */           } else {
/* 2100 */             this.jTable1.setValueAt("", i, 13);
/*      */           } 
/*      */         } 
/* 2103 */         this.jTable1.setSelectionMode(0);
/* 2104 */         this.jTable1.setAutoCreateRowSorter(true);
/* 2105 */         this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */       } 
/* 2107 */       if (this.TIPOREPOR == 2) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2112 */         this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2113 */               .buscarDatos(13, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Guía", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2120 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false, false, false, false, false, false, false, false };
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2125 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/*      */         
/* 2129 */         this.VIAJESTOT = this.jTable1.getRowCount();
/* 2130 */         this.TONS = Double.valueOf(Double.parseDouble(campos[1]));
/* 2131 */         this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable1.getRowCount() + "</HTML>");
/* 2132 */         this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + campos[1] + "</HTML>");
/* 2133 */         this.jTable1.moveColumn(13, 12);
/* 2134 */         for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2135 */           String col = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 2136 */           String resi = String.valueOf(this.jTable1.getValueAt(i, 2));
/* 2137 */           if (resi.equals("SERVICIO INTEGRAL")) {
/* 2138 */             this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + col + "'");
/* 2139 */             if (this.encontrado) {
/* 2140 */               this.jTable1.setValueAt(this.con.Campo, i, 12);
/*      */             } else {
/* 2142 */               this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + col + "'");
/* 2143 */               if (this.encontrado) {
/* 2144 */                 this.jTable1.setValueAt(this.con.Campo, i, 12);
/*      */               } else {
/* 2146 */                 this.jTable1.setValueAt("", i, 12);
/*      */               } 
/*      */             } 
/*      */           } else {
/* 2150 */             this.jTable1.setValueAt("", i, 12);
/*      */           } 
/*      */         } 
/*      */       } 
/* 2154 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(60);
/* 2155 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
/* 2156 */       this.jTable1.getColumnModel().getColumn(1).setMinWidth(110);
/* 2157 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(110);
/* 2158 */       this.jTable1.getColumnModel().getColumn(2).setMinWidth(110);
/* 2159 */       this.jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
/* 2160 */       this.jTable1.getColumnModel().getColumn(9).setMinWidth(50);
/* 2161 */       this.jTable1.getColumnModel().getColumn(9).setMaxWidth(50);
/* 2162 */       this.jTable1.getColumnModel().getColumn(10).setMinWidth(50);
/* 2163 */       this.jTable1.getColumnModel().getColumn(10).setMaxWidth(50);
/* 2164 */       this.jTable1.getColumnModel().getColumn(11).setMinWidth(60);
/* 2165 */       this.jTable1.getColumnModel().getColumn(11).setMaxWidth(60);
/* 2166 */       this.jTable1.getColumnModel().getColumn(12).setMinWidth(60);
/* 2167 */       this.jTable1.getColumnModel().getColumn(12).setMaxWidth(60);
/*      */       
/* 2169 */       if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 2170 */         this.jTable1.getColumnModel().getColumn(13).setMinWidth(95);
/* 2171 */         this.jTable1.getColumnModel().getColumn(13).setMaxWidth(95);
/* 2172 */         this.jTable1.getColumnModel().getColumn(14).setMinWidth(200);
/* 2173 */         this.jTable1.getColumnModel().getColumn(14).setMaxWidth(200);
/*      */       } else {
/* 2175 */         this.jTable1.getColumnModel().getColumn(12).setMinWidth(120);
/* 2176 */         this.jTable1.getColumnModel().getColumn(12).setMaxWidth(120);
/* 2177 */         this.jTable1.getColumnModel().getColumn(13).setMinWidth(150);
/* 2178 */         this.jTable1.getColumnModel().getColumn(13).setMaxWidth(150);
/*      */       } 
/* 2180 */       this.jFrame1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2185 */     this.jTextArea5.setText("");
/* 2186 */     int ind = this.jTable2.getSelectedRow();
/* 2187 */     String valor = String.valueOf(this.jTable2.getValueAt(ind, 11));
/* 2188 */     if (!valor.equals("ACTIVA")) {
/* 2189 */       JOptionPane.showMessageDialog(this.padre, "La prefactura que seleccionaste ya se encuentra cancelada\nPor favor selecciona otros datos.", "Prefactura Cancelada", 0, this.ERROR);
/*      */     }
/* 2191 */     else if (ind < 0) {
/* 2192 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar una prefactura para poder cancelar los datos", "Selecciona un aPrefactura", 0, this.ERROR);
/*      */     } else {
/* 2194 */       this.jDialog6.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 2200 */     String[] datos = { "PREFACTURA", "FOLIO", "FECHA", "CLIENTE", "EQUIPO", "PLATAFORMA", "POZO", "PEDIDO", "TONS", "NÚM VIAJES", "ESTATUS", "RESPONSABLE", "COMENTARIO" };
/* 2201 */     this.esc = new EscribirReporte("ARCHIVO", this.jTable2, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 2205 */     if (this.jComboBox1.getItemCount() > 0 && this.PRIMERA == true) {
/* 2206 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 2211 */     if (this.jComboBox1.getItemCount() > 0 && this.PRIMERA == true) {
/* 2212 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2217 */     verFactura();
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2221 */     this.PRIMERAGUIAS = false;
/* 2222 */     String cliente = String.valueOf(this.jComboBox4.getSelectedItem());
/* 2223 */     String equipo = String.valueOf(this.jComboBox21.getSelectedItem());
/* 2224 */     String plat = String.valueOf(this.jComboBox22.getSelectedItem());
/* 2225 */     String pozo = String.valueOf(this.jComboBox23.getSelectedItem());
/* 2226 */     if (!cliente.equals("SELECCIONA UN CLIENTE...")) {
/* 2227 */       this.jComboBox20.setSelectedItem(cliente);
/*      */     } else {
/* 2229 */       this.jComboBox20.setSelectedIndex(0);
/*      */     } 
/* 2231 */     if (!equipo.equals("GENERAL")) {
/* 2232 */       this.jComboBox7.setSelectedItem(equipo);
/*      */     } else {
/* 2234 */       this.jComboBox7.setSelectedIndex(0);
/*      */     } 
/* 2236 */     if (!plat.equals("GENERAL")) {
/* 2237 */       this.jComboBox8.setSelectedItem(plat);
/*      */     } else {
/* 2239 */       this.jComboBox8.setSelectedIndex(0);
/*      */     } 
/* 2241 */     if (!pozo.equals("GENERAL")) {
/* 2242 */       this.jComboBox9.setSelectedItem(pozo);
/*      */     } else {
/* 2244 */       this.jComboBox9.setSelectedIndex(0);
/*      */     } 
/* 2246 */     consultarGuias();
/* 2247 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 2250 */     String archivo = String.valueOf(this.jComboBox4.getSelectedItem());
/* 2251 */     Icon cliente = new ImageIcon(this.tk.getImage("Formatos/" + archivo + ".jpg"));
/* 2252 */     this.jLabel29.setIcon(cliente);
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 2256 */     String cadena = this.jTextField3.getText();
/* 2257 */     if (!cadena.equals("")) {
/* 2258 */       if (this.presionado == null) {
/* 2259 */         this.presionado = new Presionado();
/* 2260 */         this.presionado.start();
/*      */       } else {
/*      */         
/* 2263 */         this.presionado.detenerFuera();
/* 2264 */         this.presionado = new Presionado();
/* 2265 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/*      */       
/* 2269 */       this.jTextField3.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 2274 */     if (this.jComboBox10.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2275 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 2280 */     if (this.jComboBox10.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2281 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 2286 */     if (this.jComboBox8.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2287 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox9ActionPerformed(ActionEvent evt) {
/* 2292 */     if (this.jComboBox9.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2293 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 2298 */     if (this.jComboBox6.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2299 */       consultarGuias();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox21ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox22ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox23ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 2316 */     if (evt.getClickCount() == 2) {
/* 2317 */       pasarGuia();
/*      */     } else {
/*      */       
/* 2320 */       this.jButton7.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 2325 */     int indice = this.jTable3.getSelectedRow();
/* 2326 */     if (indice < 0) {
/* 2327 */       JOptionPane.showMessageDialog(this.jDialog1, "Debes seleccionar un viaje para poder agregarlo a la prefactura", "Agregar Viaje", 0, this.ADVER);
/*      */     } else {
/* 2329 */       pasarGuia();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 2334 */     int ind = this.jTable1.getSelectedRow();
/* 2335 */     if (ind < 0) {
/* 2336 */       JOptionPane.showMessageDialog(this.jFrame1, "Necesitas seleccionar un viaje para poder quitarlo", "Selecciona un viaje", 0, this.ERROR);
/*      */     } else {
/* 2338 */       quitarViaje();
/*      */     } 
/*      */   }
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 2342 */     if (this.jTextField2.isEnabled()) {
/* 2343 */       salir();
/*      */     } else {
/* 2345 */       this.jFrame1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   private void jFrame1WindowClosing(WindowEvent evt) {
/* 2349 */     if (this.jTextField2.isEnabled()) {
/* 2350 */       salir();
/*      */     } else {
/* 2352 */       this.jFrame1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 2357 */     int reg = this.jTable3.getRowCount();
/* 2358 */     if (reg < 1) {
/* 2359 */       JOptionPane.showMessageDialog(this.jFrame1, "No hay guías para agregar, verifica tu información", "No hay Guías", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 2362 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas agregar todos los viajes a la prefactura?", "Agregar Viajes a Prefactura", 0, 3, this.PREG);
/* 2363 */       if (res == 0) {
/* 2364 */         pasarTodos();
/* 2365 */         this.jDialog1.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2370 */     String[] datos = new String[this.jTable1.getColumnCount()];
/* 2371 */     for (int i = 0; i < this.jTable1.getColumnCount(); i++) {
/* 2372 */       datos[i] = "";
/* 2373 */       datos[i] = this.jTable1.getColumnName(i);
/*      */     } 
/* 2375 */     this.esc = new EscribirReporte("ARCHIVO", this.jTable1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 2379 */     int reg = this.jTable1.getRowCount();
/* 2380 */     if (reg < 1) {
/* 2381 */       JOptionPane.showMessageDialog(this.jFrame1, "No puedes imprimir el reporte ya que no has agregado viajes a la prefactura", "Sin Viajes", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 2384 */       String texto = "";
/* 2385 */       String titulo = "";
/* 2386 */       if (this.jButton14.getText().equals("Modificar")) {
/* 2387 */         texto = "¿Estás seguro que deseas modificar el archivo?";
/* 2388 */         titulo = "Modificar Archivo";
/*      */       
/*      */       }
/* 2391 */       else if (!this.jTextField2.isEnabled()) {
/* 2392 */         texto = "Deseas imprimir los datos del archivo";
/* 2393 */         titulo = "Imprimir Archivo";
/*      */       } else {
/*      */         
/* 2396 */         texto = "¿Deseas crear un nuevo archivo y guardar los datos?";
/* 2397 */         titulo = "Guardar Archivo";
/*      */       } 
/*      */ 
/*      */       
/* 2401 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, texto, titulo, 0, 3, this.PREG);
/* 2402 */       if (res == 0) {
/* 2403 */         if (this.jButton14.getText().equals("Modificar")) {
/* 2404 */           this.con.inserSinMsj("update guias set estatus='<Pagada Al Operador>', pedido='', factura=0 where factura=" + this.PREFAC);
/*      */         }
/* 2406 */         if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 2407 */           imprimir1();
/*      */         } else {
/* 2409 */           imprimir2();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 2416 */     int ind = this.jTable1.getSelectedRow();
/* 2417 */     if (ind < 0) {
/* 2418 */       JOptionPane.showMessageDialog(this.jFrame1, "Necesitas seleccionar un viaje para agregar comentarios", "Selecciona un viaje", 0, this.ERROR);
/*      */     } else {
/* 2420 */       String valor = "";
/* 2421 */       if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 2422 */         valor = String.valueOf(this.jTable1.getValueAt(ind, 14));
/*      */       } else {
/* 2424 */         valor = String.valueOf(this.jTable1.getValueAt(ind, 13));
/*      */       } 
/* 2426 */       this.jTextArea2.setText(valor);
/* 2427 */       if (this.jTextField2.isEnabled()) {
/* 2428 */         this.jDialog4.setVisible(true);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 2434 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 2438 */     String comen = this.jTextArea2.getText().toUpperCase();
/* 2439 */     String guia = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/*      */     
/* 2441 */     if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 2442 */       this.jTable1.setValueAt(comen, this.jTable1.getSelectedRow(), 14);
/*      */     } else {
/* 2444 */       this.jTable1.setValueAt(comen, this.jTable1.getSelectedRow(), 13);
/*      */     } 
/* 2446 */     this.jDialog4.setVisible(false);
/* 2447 */     this.PRESIONADO = true;
/* 2448 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   private void jTable1MouseClicked(MouseEvent evt) {
/* 2452 */     if (evt.getClickCount() == 2) {
/* 2453 */       int col = this.jTable1.getSelectedColumn();
/* 2454 */       String columna = this.jTable1.getColumnName(col);
/* 2455 */       if (columna.equals("Comentario")) {
/* 2456 */         int ind = this.jTable1.getSelectedRow();
/* 2457 */         if (ind < 0) {
/* 2458 */           JOptionPane.showMessageDialog(this.jFrame1, "Necesitas seleccionar un viaje para agregar comentarios", "Selecciona un viaje", 0, this.ERROR);
/*      */         } else {
/*      */           
/* 2461 */           String valor = "";
/*      */           
/* 2463 */           if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 2464 */             Object val = this.jTable1.getValueAt(ind, 14);
/* 2465 */             if (val == null) {
/* 2466 */               valor = "";
/*      */             } else {
/*      */               
/* 2469 */               valor = String.valueOf(this.jTable1.getValueAt(ind, 14));
/*      */             } 
/*      */           } else {
/*      */             
/* 2473 */             Object val = this.jTable1.getValueAt(ind, 13);
/* 2474 */             if (val == null) {
/* 2475 */               valor = "";
/*      */             } else {
/*      */               
/* 2478 */               valor = String.valueOf(this.jTable1.getValueAt(ind, 13));
/*      */             } 
/*      */           } 
/* 2481 */           this.jTextArea2.setText(valor);
/* 2482 */           if (this.jTextField2.isEnabled()) {
/* 2483 */             this.jDialog4.setVisible(true);
/*      */           }
/*      */         }
/*      */       
/* 2487 */       } else if (columna.equals("Ped")) {
/* 2488 */         Object valor = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 8);
/* 2489 */         if (valor != null) {
/* 2490 */           this.jTextField5.setText(String.valueOf(valor));
/*      */         } else {
/* 2492 */           this.jTextField5.setText("");
/*      */         } 
/* 2494 */         if (this.jTextField2.isEnabled()) {
/* 2495 */           this.jDialog7.setVisible(true);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jMenuItem3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jMenuItem1ActionPerformed(ActionEvent evt) {
/* 2506 */     String nombre = JOptionPane.showInputDialog(this.jFrame1, "Coloca el nombre de la columna", "Nombre Columna", 1);
/* 2507 */     int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas insertar la nueva columna: " + nombre.toUpperCase() + "?", "Agregar Columna", 0, 3, this.PREG);
/* 2508 */     if (res == 0) {
/* 2509 */       this.MODELOPREFACTURA.addColumn(nombre);
/* 2510 */       TableModel nuevo = null;
/*      */       
/* 2512 */       this.jTable1.getColumnModel();
/* 2513 */       bloquearTabla();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jMenuItem2ActionPerformed(ActionEvent evt) {
/* 2518 */     int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas quitar la columna de R.S.P.?", "Quitar Columna R.S.P.", 0, 3, this.PREG);
/* 2519 */     if (res == 0) {
/*      */       try {
/* 2521 */         this.jTable1.removeColumn(this.jTable1.getColumn("R.S.P."));
/* 2522 */       } catch (Exception e) {
/* 2523 */         JOptionPane.showMessageDialog(this.jFrame1, "La columna de RSP no se pudo eliminar, verifica que exista esa columna", "No se Eliminó", 0, this.ERROR);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMenuItem4ActionPerformed(ActionEvent evt) {
/* 2529 */     String[] datos = new String[this.jTable1.getColumnCount()];
/* 2530 */     for (int i = 0; i < this.jTable1.getColumnCount(); i++) {
/* 2531 */       datos[i] = "";
/* 2532 */       datos[i] = this.jTable1.getColumnName(i);
/*      */     } 
/* 2534 */     this.esc = new EscribirReporte("PREFACTURAS", this.jTable1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 2538 */     this.jLabel11.setVisible(false);
/* 2539 */     this.jTextField4.setVisible(false);
/* 2540 */     this.jCheckBox1.setVisible(false);
/* 2541 */     this.TIPOREPOR = 2;
/* 2542 */     cargarValores();
/* 2543 */     desactivarTabla();
/* 2544 */     this.jDialog5.setVisible(false);
/* 2545 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 2549 */     this.jTextField5.setText("");
/* 2550 */     this.jCheckBox1.setSelected(true);
/* 2551 */     this.jLabel11.setVisible(true);
/* 2552 */     this.jTextField4.setVisible(true);
/* 2553 */     this.jCheckBox1.setVisible(true);
/* 2554 */     this.jCheckBox1.setSelected(false);
/* 2555 */     this.TIPOREPOR = 0;
/* 2556 */     desactivarTabla();
/* 2557 */     cargarValores();
/* 2558 */     this.jDialog5.setVisible(false);
/* 2559 */     this.jComboBox4.setSelectedIndex(0);
/* 2560 */     this.jTextField4.setEnabled(true);
/* 2561 */     this.jCheckBox1.setEnabled(true);
/* 2562 */     this.jCheckBox1.setSelected(false);
/* 2563 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 2567 */     this.jLabel11.setVisible(false);
/* 2568 */     this.jTextField4.setVisible(false);
/* 2569 */     this.jCheckBox1.setVisible(false);
/* 2570 */     this.TIPOREPOR = 1;
/* 2571 */     desactivarTabla();
/* 2572 */     cargarValores();
/* 2573 */     this.jDialog5.setVisible(false);
/* 2574 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 2578 */     int ind = this.jTable2.getSelectedRow();
/* 2579 */     String prefa = String.valueOf(this.jTable2.getValueAt(ind, 0));
/* 2580 */     if (this.jTextArea5.getText().equals("")) {
/* 2581 */       JOptionPane.showMessageDialog(this.jDialog6, "Debes colocar un comentario sobre el motivo de cancelación de la prefactura", "Falta Comentario", 0, this.ERROR);
/*      */     } else {
/* 2583 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas cancelar la prefactura y activar todas los viajes correspondientes?", "Cancelar Prefactura", 0, 3, this.PREG);
/* 2584 */       if (res == 0) {
/* 2585 */         this.con.inserSinMsj("update guias set estatus='<Pagada Al Operador>', factura=0 where factura=" + prefa);
/* 2586 */         this.con.inserSinMsj("update prefacturas set estatus='CANCELADA/ " + this.jTextArea5.getText().toUpperCase() + "',actual='<Cancelada>' where numInterPre=" + prefa);
/*      */         
/* 2588 */         this.jDialog6.setVisible(false);
/* 2589 */         consultar();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 2595 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel37MouseClicked(MouseEvent evt) {
/* 2599 */     this.jDateChooser11.setDate(this.fechaInicio);
/* 2600 */     this.jDateChooser12.setDate(this.fechaActual);
/* 2601 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel37MouseEntered(MouseEvent evt) {
/* 2605 */     this.jLabel37.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel37MouseExited(MouseEvent evt) {
/* 2609 */     this.jLabel37.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel38MouseClicked(MouseEvent evt) {
/* 2613 */     this.jDateChooser11.setDate(this.fechaActual);
/* 2614 */     this.jDateChooser12.setDate(this.fechaActual);
/* 2615 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel38MouseEntered(MouseEvent evt) {
/* 2619 */     this.jLabel38.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel38MouseExited(MouseEvent evt) {
/* 2623 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel39MouseClicked(MouseEvent evt) {
/* 2627 */     Calendar ca = Calendar.getInstance();
/* 2628 */     Calendar fecha = Calendar.getInstance();
/* 2629 */     int aa = fecha.get(1);
/* 2630 */     int mm = fecha.get(2);
/* 2631 */     int dd = fecha.get(5);
/* 2632 */     if (dd == 1) {
/* 2633 */       if (mm == 0) {
/* 2634 */         mm = 11;
/* 2635 */         aa--;
/*      */       } else {
/* 2637 */         mm--;
/*      */       } 
/* 2639 */       int diasTotal = diasDelMes(mm, aa);
/* 2640 */       dd = diasTotal;
/*      */     } else {
/* 2642 */       dd--;
/*      */     } 
/* 2644 */     mm++;
/* 2645 */     String año = "" + aa;
/* 2646 */     String mes = "" + mm;
/* 2647 */     String dia = "" + dd;
/* 2648 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2649 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 2651 */       this.jDateChooser11.setDate(formatoDelTexto.parse(strFecha));
/* 2652 */       this.jDateChooser12.setDate(formatoDelTexto.parse(strFecha));
/* 2653 */     } catch (ParseException ex) {
/* 2654 */       ex.printStackTrace();
/*      */     } 
/* 2656 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel39MouseEntered(MouseEvent evt) {
/* 2660 */     this.jLabel39.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel39MouseExited(MouseEvent evt) {
/* 2664 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 2668 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 2672 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 2676 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 2680 */     this.jTable1.setValueAt(this.jTextField5.getText().toUpperCase(), this.jTable1.getSelectedRow(), 8);
/* 2681 */     this.jDialog7.setVisible(false);
/* 2682 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   private void jTextField5ActionPerformed(ActionEvent evt) {
/* 2686 */     this.jTable1.setValueAt(this.jTextField5.getText().toUpperCase(), this.jTable1.getSelectedRow(), 8);
/* 2687 */     this.jDialog7.setVisible(false);
/* 2688 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 2692 */     if (!this.jCheckBox1.isSelected()) {
/* 2693 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas quitar el número de pedido para todos los viajes?", "Quitar Pedidos", 0, 3, this.PREG);
/* 2694 */       if (res == 0) {
/* 2695 */         for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2696 */           this.jTable1.setValueAt("", i, 8);
/* 2697 */           this.jTextField4.setText("");
/*      */         } 
/* 2699 */         bloquearTabla();
/*      */       } else {
/*      */         
/* 2702 */         this.jCheckBox1.setSelected(true);
/*      */       } 
/*      */     } else {
/*      */       
/* 2706 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas asignar el número de pedido a todos los viajes?", "Asignar Pedidos", 0, 3, this.PREG);
/* 2707 */       if (res == 0) {
/* 2708 */         for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2709 */           this.jTable1.setValueAt(this.jTextField4.getText().toUpperCase(), i, 8);
/*      */         }
/* 2711 */         bloquearTabla();
/*      */       } else {
/*      */         
/* 2714 */         this.jCheckBox1.setSelected(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 2720 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox10ActionPerformed(ActionEvent evt) {
/* 2724 */     if (this.jComboBox10.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2725 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {
/* 2730 */     consultarGuias();
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 2734 */     consultarGuias();
/*      */   }
/*      */   
/*      */   private void jComboBox20ActionPerformed(ActionEvent evt) {
/* 2738 */     if (this.jComboBox20.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2739 */       consultarGuias();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField7ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField7KeyReleased(KeyEvent evt) {
/* 2748 */     String cadena = this.jTextField7.getText();
/* 2749 */     if (!cadena.equals("")) {
/* 2750 */       if (this.presionado == null) {
/* 2751 */         this.presionado = new Presionado();
/* 2752 */         this.presionado.start();
/*      */       } else {
/*      */         
/* 2755 */         this.presionado.detenerFuera();
/* 2756 */         this.presionado = new Presionado();
/* 2757 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/*      */       
/* 2761 */       this.jTextField7.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   public int diasDelMes(int mes, int año) {
/* 2765 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 2773 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 2779 */         return 30;
/*      */       
/*      */       case 1:
/* 2782 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 2784 */           return 29;
/*      */         }
/* 2786 */         return 28;
/*      */     } 
/*      */ 
/*      */     
/* 2790 */     return 0;
/*      */   }
/*      */   
/*      */   public void verFactura() {
/* 2794 */     this.jFrame1.setTitle("Ver reporte interno a detalle");
/* 2795 */     this.jButton14.setText("Imprimir");
/* 2796 */     this.jButton14.setToolTipText("Imprimir (Alt+I)");
/* 2797 */     this.jButton14.setMnemonic('I');
/* 2798 */     int ind = this.jTable2.getSelectedRow();
/* 2799 */     this.jLabel60.setText(String.valueOf(this.jTable2.getValueAt(ind, 10)));
/* 2800 */     this.jLabel60.setToolTipText(String.valueOf(this.jTable2.getValueAt(ind, 10)));
/* 2801 */     String[] datos = { String.valueOf(this.jTable2.getValueAt(ind, 0)), String.valueOf(this.jTable2.getValueAt(ind, 1)), String.valueOf(this.jTable2.getValueAt(ind, 2)), String.valueOf(this.jTable2.getValueAt(ind, 3)), String.valueOf(this.jTable2.getValueAt(ind, 4)), String.valueOf(this.jTable2.getValueAt(ind, 5)), String.valueOf(this.jTable2.getValueAt(ind, 6)), String.valueOf(this.jTable2.getValueAt(ind, 7)), String.valueOf(this.jTable2.getValueAt(ind, 8)), String.valueOf(this.jTable2.getValueAt(ind, 9)), String.valueOf(this.jTable2.getValueAt(ind, 10)), String.valueOf(this.jTable2.getValueAt(ind, 11)) };
/* 2802 */     this.jTextField2.setText(datos[1]);
/* 2803 */     this.jComboBox4.setEnabled(false);
/* 2804 */     this.jComboBox21.setEnabled(false);
/* 2805 */     this.jComboBox22.setEnabled(false);
/* 2806 */     this.jComboBox23.setEnabled(false);
/* 2807 */     this.jDateChooser4.setEnabled(false);
/* 2808 */     this.jTextField2.setEnabled(false);
/* 2809 */     this.jButton17.setVisible(false);
/* 2810 */     this.jButton1.setVisible(false);
/* 2811 */     this.jButton2.setVisible(false);
/* 2812 */     this.jButton10.setVisible(false);
/* 2813 */     this.jTextField4.setEnabled(false);
/* 2814 */     this.jCheckBox1.setEnabled(false);
/*      */ 
/*      */     
/* 2817 */     String año = datos[2].substring(0, 4);
/* 2818 */     String mes = datos[2].substring(5, 7);
/* 2819 */     String dia = datos[2].substring(8, 10);
/* 2820 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2821 */     String strFecha = dia + "-" + dia + "-" + mes;
/* 2822 */     Date fechaG = null;
/*      */     try {
/* 2824 */       fechaG = formatoDelTexto.parse(strFecha);
/* 2825 */       this.jDateChooser4.setDate(fechaG);
/* 2826 */     } catch (ParseException ex) {
/* 2827 */       ex.printStackTrace();
/*      */     } 
/* 2829 */     if (datos[3].equals("<GENERAL>")) {
/* 2830 */       this.jComboBox4.setSelectedIndex(0);
/*      */     } else {
/* 2832 */       this.jComboBox4.setSelectedItem(datos[3]);
/*      */     } 
/*      */     
/* 2835 */     if (datos[4].equals("<GENERAL>")) {
/* 2836 */       this.jComboBox21.setSelectedIndex(0);
/*      */     } else {
/* 2838 */       this.jComboBox21.setSelectedItem(datos[4]);
/*      */     } 
/*      */     
/* 2841 */     if (datos[5].equals("<GENERAL>")) {
/* 2842 */       this.jComboBox22.setSelectedIndex(0);
/*      */     } else {
/* 2844 */       this.jComboBox22.setSelectedItem(datos[5]);
/*      */     } 
/* 2846 */     if (datos[6].equals("<GENERAL>")) {
/* 2847 */       this.jComboBox23.setSelectedIndex(0);
/*      */     } else {
/* 2849 */       this.jComboBox23.setSelectedItem(datos[6]);
/*      */     } 
/* 2851 */     String[] campos = this.con.regresaReg("tipo,tons,pedido", "prefacturas", "where numInterPre = " + datos[0], 3);
/* 2852 */     this.TIPOREPOR = Integer.parseInt(campos[0]);
/* 2853 */     this.jTextField4.setText("");
/* 2854 */     this.jCheckBox1.setSelected(false);
/* 2855 */     if (!campos[2].equals("")) {
/* 2856 */       this.jTextField4.setText(campos[2]);
/* 2857 */       this.jCheckBox1.setSelected(true);
/*      */     } 
/*      */     
/* 2860 */     if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2865 */       if (this.TIPOREPOR == 0) {
/* 2866 */         this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2867 */               .buscarDatos(14, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,pedido,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Folio", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ped", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2875 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false, false, false, false, false, false, false, false };
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2880 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/*      */         
/* 2884 */         this.VIAJESTOT = this.jTable1.getRowCount();
/* 2885 */         this.TONS = Double.valueOf(Double.parseDouble(campos[1]));
/* 2886 */         this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable1.getRowCount() + "</HTML>");
/* 2887 */         this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + campos[1] + "</HTML>");
/* 2888 */         this.jTable1.moveColumn(13, 14);
/*      */       }
/*      */       else {
/*      */         
/* 2892 */         this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2893 */               .buscarDatos(14, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,rsp,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Folio", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "R.S.P.", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2899 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false, false, false, false, false, false, false, false };
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2903 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 2906 */         for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 2907 */           System.out.println("ejempl " + j + " " + String.valueOf(this.jTable1.getValueAt(j, 13)));
/*      */         }
/* 2909 */         this.jTable1.moveColumn(13, 14);
/*      */       } 
/* 2911 */       for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2912 */         String col = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 2913 */         String resi = String.valueOf(this.jTable1.getValueAt(i, 2));
/* 2914 */         if (resi.equals("SERVICIO INTEGRAL")) {
/* 2915 */           this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + col + "'");
/* 2916 */           if (this.encontrado) {
/* 2917 */             this.jTable1.setValueAt(this.con.Campo, i, 13);
/*      */           } else {
/* 2919 */             this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + col + "'");
/* 2920 */             if (this.encontrado) {
/* 2921 */               this.jTable1.setValueAt(this.con.Campo, i, 13);
/*      */             } else {
/* 2923 */               this.jTable1.setValueAt("", i, 13);
/*      */             } 
/*      */           } 
/*      */         } else {
/*      */           
/* 2928 */           this.jTable1.setValueAt("", i, 13);
/*      */         } 
/*      */       } 
/* 2931 */       this.jTable1.setSelectionMode(0);
/* 2932 */       this.jTable1.setAutoCreateRowSorter(true);
/* 2933 */       this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     } 
/* 2935 */     if (this.TIPOREPOR == 2) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2940 */       this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2941 */             .buscarDatos(13, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Guía", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2947 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false };
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2952 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/*      */       
/* 2956 */       this.VIAJESTOT = this.jTable1.getRowCount();
/* 2957 */       this.TONS = Double.valueOf(Double.parseDouble(campos[1]));
/* 2958 */       this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable1.getRowCount() + "</HTML>");
/* 2959 */       this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + campos[1] + "</HTML>");
/* 2960 */       this.jTable1.moveColumn(13, 12); int i;
/* 2961 */       for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2962 */         String col = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 2963 */         String resi = String.valueOf(this.jTable1.getValueAt(i, 2));
/* 2964 */         if (resi.equals("SERVICIO INTEGRAL")) {
/* 2965 */           this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + col + "'");
/* 2966 */           if (this.encontrado) {
/* 2967 */             this.jTable1.setValueAt(this.con.Campo, i, 12);
/*      */           } else {
/*      */             
/* 2970 */             this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + col + "'");
/* 2971 */             if (this.encontrado) {
/* 2972 */               this.jTable1.setValueAt(this.con.Campo, i, 12);
/*      */             } else {
/*      */               
/* 2975 */               this.jTable1.setValueAt("", i, 12);
/*      */             } 
/*      */           } 
/*      */         } else {
/*      */           
/* 2980 */           this.jTable1.setValueAt("", i, 12);
/*      */         } 
/*      */       } 
/* 2983 */       for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2984 */         this.TONELADAS += Double.parseDouble(String.valueOf(this.jTable1.getValueAt(i, 9)));
/*      */       }
/*      */       
/* 2987 */       System.out.println("TONELADAS TOTALES " + this.TONELADAS);
/*      */     } 
/* 2989 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(60);
/* 2990 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
/* 2991 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(110);
/* 2992 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(110);
/* 2993 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(110);
/* 2994 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
/* 2995 */     this.jTable1.getColumnModel().getColumn(9).setMinWidth(50);
/* 2996 */     this.jTable1.getColumnModel().getColumn(9).setMaxWidth(50);
/* 2997 */     this.jTable1.getColumnModel().getColumn(10).setMinWidth(50);
/* 2998 */     this.jTable1.getColumnModel().getColumn(10).setMaxWidth(50);
/* 2999 */     this.jTable1.getColumnModel().getColumn(11).setMinWidth(60);
/* 3000 */     this.jTable1.getColumnModel().getColumn(11).setMaxWidth(60);
/* 3001 */     this.jTable1.getColumnModel().getColumn(12).setMinWidth(60);
/* 3002 */     this.jTable1.getColumnModel().getColumn(12).setMaxWidth(60);
/*      */     
/* 3004 */     if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 3005 */       this.jTable1.getColumnModel().getColumn(13).setMinWidth(95);
/* 3006 */       this.jTable1.getColumnModel().getColumn(13).setMaxWidth(95);
/* 3007 */       this.jTable1.getColumnModel().getColumn(14).setMinWidth(200);
/* 3008 */       this.jTable1.getColumnModel().getColumn(14).setMaxWidth(200);
/*      */     } else {
/*      */       
/* 3011 */       this.jTable1.getColumnModel().getColumn(12).setMinWidth(95);
/* 3012 */       this.jTable1.getColumnModel().getColumn(12).setMaxWidth(95);
/* 3013 */       this.jTable1.getColumnModel().getColumn(13).setMinWidth(200);
/* 3014 */       this.jTable1.getColumnModel().getColumn(13).setMaxWidth(200);
/*      */     } 
/* 3016 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cargarValores() {
/* 3025 */     if (this.TIPOREPOR == 1) {
/* 3026 */       this.jComboBox4.setSelectedItem("WEATHERFORD");
/* 3027 */       this.jComboBox20.setSelectedItem("WEATHERFORD");
/* 3028 */       this.jComboBox4.setEnabled(false);
/* 3029 */       this.jComboBox20.setEnabled(false);
/* 3030 */     } else if (this.TIPOREPOR == 2) {
/* 3031 */       this.jComboBox4.setSelectedIndex(0);
/* 3032 */       this.jComboBox20.setSelectedIndex(0);
/* 3033 */       this.jComboBox4.setEnabled(true);
/* 3034 */       this.jComboBox20.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void imprimir1() {
/* 3039 */     this.OTROSRESIDUOS = 0;
/* 3040 */     this.addGuias = new AddGuias[11];
/* 3041 */     for (int i = 0; i < this.addGuias.length; i++) {
/* 3042 */       this.addGuias[i] = new AddGuias();
/*      */     }
/* 3044 */     this.TONSRESIDUO = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/* 3045 */     this.GUIASAMPARADAS = new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "" };
/*      */     
/* 3047 */     String COL = "";
/* 3048 */     if (this.TIPOREPOR == 0) {
/* 3049 */       COL = "PED";
/*      */     } else {
/* 3051 */       COL = "RSP";
/*      */     } 
/* 3053 */     this.NOMBRECOL = new String[] { "GUÍA", "FECHA", "RESIDUO", "EQUIPO", COL, "TICK", "TONS", "TRAC", "REM", "MANIF", "COMENTARIO" };
/* 3054 */     this.LINEAS = new String[this.jTable1.getRowCount()];
/* 3055 */     this.LETRASMAX = new int[this.NOMBRECOL.length];
/* 3056 */     this.REGIS = new String[this.jTable1.getRowCount()][this.NOMBRECOL.length];
/* 3057 */     this.SERVICIOS = new String[] { "FLETE", "MOV FALSO", "MOV INTER", "RENTA", "SERV RETRO", "SERV INT" };
/* 3058 */     this.OTROSSERVICIOS = 0;
/* 3059 */     this.OTROSRESIDUOS = 0; int j;
/* 3060 */     for (j = 0; j < this.CANTTOTALES.length; j++) {
/* 3061 */       this.CANTTOTALES[j] = 0;
/*      */     }
/* 3063 */     for (j = 0; j < this.jTable1.getRowCount(); j++) {
/* 3064 */       String guiaSola = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3065 */       String fecha = String.valueOf(this.jTable1.getValueAt(j, 1));
/* 3066 */       String fechaCorta = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3067 */       String serv = String.valueOf(this.jTable1.getValueAt(j, 2));
/* 3068 */       String residuo = String.valueOf(this.jTable1.getValueAt(j, 3));
/* 3069 */       String cliente = String.valueOf(this.jTable1.getValueAt(j, 4));
/*      */       
/* 3071 */       String toneladas = String.valueOf(this.jTable1.getValueAt(j, 10));
/* 3072 */       double tonsInd = Double.parseDouble(toneladas);
/* 3073 */       int indice = 0;
/* 3074 */       if (cliente.equals("WEATHERFORD")) {
/* 3075 */         cliente = "WTF";
/* 3076 */       } else if (cliente.equals("SCHLUMBERGER")) {
/* 3077 */         cliente = "SLB";
/*      */       } 
/* 3079 */       if (residuo.equals("AGUA DE FRACTURA")) {
/* 3080 */         this.CANTTOTALES[6] = this.CANTTOTALES[6] + 1;
/* 3081 */         this.TONSRESIDUO[0] = this.TONSRESIDUO[0] + tonsInd;
/*      */         
/* 3083 */         if (this.GUIASAMPARADAS[0].equals("")) {
/* 3084 */           this.GUIASAMPARADAS[0] = guiaSola;
/*      */         } else {
/* 3086 */           this.GUIASAMPARADAS[0] = this.GUIASAMPARADAS[0] + ", " + this.GUIASAMPARADAS[0];
/*      */         } 
/* 3088 */         residuo = "AG DE FRAC";
/* 3089 */       } else if (residuo.equals("LODO BASE AGUA")) {
/* 3090 */         residuo = "L AGUA";
/* 3091 */         this.CANTTOTALES[9] = this.CANTTOTALES[9] + 1;
/* 3092 */         this.TONSRESIDUO[3] = this.TONSRESIDUO[3] + tonsInd;
/*      */         
/* 3094 */         if (this.GUIASAMPARADAS[3].equals("")) {
/* 3095 */           this.GUIASAMPARADAS[3] = guiaSola;
/*      */         } else {
/* 3097 */           this.GUIASAMPARADAS[3] = this.GUIASAMPARADAS[3] + ", " + this.GUIASAMPARADAS[3];
/*      */         } 
/* 3099 */       } else if (residuo.equals("RECORTE BASE ACEITE")) {
/* 3100 */         residuo = "R ACEITE";
/* 3101 */         this.CANTTOTALES[10] = this.CANTTOTALES[10] + 1;
/* 3102 */         this.TONSRESIDUO[4] = this.TONSRESIDUO[4] + tonsInd;
/*      */         
/* 3104 */         if (this.GUIASAMPARADAS[4].equals("")) {
/* 3105 */           this.GUIASAMPARADAS[4] = guiaSola;
/*      */         } else {
/* 3107 */           this.GUIASAMPARADAS[4] = this.GUIASAMPARADAS[4] + ", " + this.GUIASAMPARADAS[4];
/*      */         } 
/* 3109 */       } else if (residuo.equals("RECORTE BASE AGUA")) {
/* 3110 */         residuo = "R AGUA";
/* 3111 */         this.CANTTOTALES[11] = this.CANTTOTALES[11] + 1;
/* 3112 */         this.TONSRESIDUO[5] = this.TONSRESIDUO[5] + tonsInd;
/* 3113 */         if (this.GUIASAMPARADAS[5].equals("")) {
/* 3114 */           this.GUIASAMPARADAS[5] = guiaSola;
/*      */         } else {
/* 3116 */           this.GUIASAMPARADAS[5] = this.GUIASAMPARADAS[5] + ", " + this.GUIASAMPARADAS[5];
/*      */         }
/*      */       
/* 3119 */       } else if (residuo.equals("FLETES - VARIOS")) {
/* 3120 */         residuo = "FLET VAR";
/* 3121 */         this.CANTTOTALES[15] = this.CANTTOTALES[15] + 1;
/* 3122 */         this.TONSRESIDUO[9] = this.TONSRESIDUO[9] + tonsInd;
/* 3123 */         if (this.GUIASAMPARADAS[9].equals("")) {
/* 3124 */           this.GUIASAMPARADAS[9] = guiaSola;
/*      */         } else {
/* 3126 */           this.GUIASAMPARADAS[9] = this.GUIASAMPARADAS[9] + ", " + this.GUIASAMPARADAS[9];
/*      */         }
/*      */       
/* 3129 */       } else if (residuo.equals("AGUA RESIDUAL")) {
/* 3130 */         this.TONSRESIDUO[1] = this.TONSRESIDUO[1] + tonsInd;
/* 3131 */         if (this.GUIASAMPARADAS[1].equals("")) {
/* 3132 */           this.GUIASAMPARADAS[1] = guiaSola;
/*      */         } else {
/* 3134 */           this.GUIASAMPARADAS[1] = this.GUIASAMPARADAS[1] + ", " + this.GUIASAMPARADAS[1];
/*      */         } 
/*      */         
/* 3137 */         residuo = "AG RESID";
/* 3138 */         this.CANTTOTALES[7] = this.CANTTOTALES[7] + 1;
/* 3139 */       } else if (residuo.equals("LODO BASE ACEITE")) {
/* 3140 */         residuo = "L ACEITE";
/* 3141 */         this.CANTTOTALES[8] = this.CANTTOTALES[8] + 1;
/* 3142 */         if (this.GUIASAMPARADAS[2].equals("")) {
/* 3143 */           this.GUIASAMPARADAS[2] = guiaSola;
/*      */         } else {
/* 3145 */           this.GUIASAMPARADAS[2] = this.GUIASAMPARADAS[2] + ", " + this.GUIASAMPARADAS[2];
/*      */         }
/*      */       
/* 3148 */       } else if (residuo.equals("SALMUERA")) {
/* 3149 */         this.CANTTOTALES[12] = this.CANTTOTALES[12] + 1;
/* 3150 */         this.TONSRESIDUO[6] = this.TONSRESIDUO[6] + tonsInd;
/* 3151 */         if (this.GUIASAMPARADAS[6].equals("")) {
/* 3152 */           this.GUIASAMPARADAS[6] = guiaSola;
/*      */         } else {
/* 3154 */           this.GUIASAMPARADAS[6] = this.GUIASAMPARADAS[6] + ", " + this.GUIASAMPARADAS[6];
/*      */         }
/*      */       
/* 3157 */       } else if (residuo.equals("SANEAMIENTO")) {
/* 3158 */         residuo = "SANEAM";
/* 3159 */         this.CANTTOTALES[13] = this.CANTTOTALES[13] + 1;
/* 3160 */         this.TONSRESIDUO[7] = this.TONSRESIDUO[7] + tonsInd;
/* 3161 */         if (this.GUIASAMPARADAS[7].equals("")) {
/* 3162 */           this.GUIASAMPARADAS[7] = guiaSola;
/*      */         } else {
/* 3164 */           this.GUIASAMPARADAS[7] = this.GUIASAMPARADAS[7] + ", " + this.GUIASAMPARADAS[7];
/*      */         }
/*      */       
/* 3167 */       } else if (residuo.equals("SEDIMENTO")) {
/* 3168 */         residuo = "SEDIMEN";
/* 3169 */         this.CANTTOTALES[14] = this.CANTTOTALES[14] + 1;
/* 3170 */         this.TONSRESIDUO[8] = this.TONSRESIDUO[8] + tonsInd;
/* 3171 */         if (this.GUIASAMPARADAS[8].equals("")) {
/* 3172 */           this.GUIASAMPARADAS[8] = guiaSola;
/*      */         } else {
/* 3174 */           this.GUIASAMPARADAS[8] = this.GUIASAMPARADAS[8] + ", " + this.GUIASAMPARADAS[8];
/*      */         } 
/*      */       } else {
/*      */         
/* 3178 */         this.OTROSRESIDUOS++;
/* 3179 */         this.TONSRESIDUO[10] = this.TONSRESIDUO[10] + tonsInd;
/* 3180 */         if (this.GUIASAMPARADAS[10].equals("")) {
/* 3181 */           this.GUIASAMPARADAS[10] = guiaSola;
/*      */         } else {
/* 3183 */           this.GUIASAMPARADAS[10] = this.GUIASAMPARADAS[10] + ", " + this.GUIASAMPARADAS[10];
/*      */         } 
/*      */       } 
/* 3186 */       if (residuo.equals("FLUIDO RECUPERADO C/TRAZAS DE ACEITE")) {
/* 3187 */         residuo = "F RECUP/TRAZAS";
/*      */       }
/* 3189 */       else if (residuo.equals("FLUIDO RECUPERADO")) {
/* 3190 */         residuo = "F RECUP";
/*      */       } 
/* 3192 */       this.REGIS[j][0] = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3193 */       this.REGIS[j][1] = fechaCorta;
/* 3194 */       this.REGIS[j][2] = residuo;
/* 3195 */       this.REGIS[j][3] = String.valueOf(this.jTable1.getValueAt(j, 5));
/* 3196 */       this.REGIS[j][3] = String.valueOf(this.jTable1.getValueAt(j, 5));
/* 3197 */       if (this.jTable1.getValueAt(j, 8) == null) {
/* 3198 */         this.REGIS[j][4] = "";
/*      */       } else {
/* 3200 */         this.REGIS[j][4] = String.valueOf(this.jTable1.getValueAt(j, 8));
/*      */       } 
/* 3202 */       this.REGIS[j][5] = String.valueOf(this.jTable1.getValueAt(j, 9));
/* 3203 */       this.REGIS[j][6] = String.valueOf(this.jTable1.getValueAt(j, 10));
/* 3204 */       this.REGIS[j][7] = String.valueOf(this.jTable1.getValueAt(j, 11));
/* 3205 */       this.REGIS[j][8] = String.valueOf(this.jTable1.getValueAt(j, 12));
/* 3206 */       this.REGIS[j][9] = String.valueOf(this.jTable1.getValueAt(j, 13));
/*      */       
/* 3208 */       if (this.jTable1.getValueAt(j, 14) == null) {
/* 3209 */         this.REGIS[j][10] = "";
/*      */       } else {
/* 3211 */         this.REGIS[j][10] = String.valueOf(this.jTable1.getValueAt(j, 14));
/*      */       } 
/*      */     } 
/* 3214 */     if (this.jTextField2.isEnabled()) {
/* 3215 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3216 */       String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 3217 */       String año = cadenaFecha1.substring(0, 4);
/* 3218 */       String mes = cadenaFecha1.substring(4, 6);
/* 3219 */       String dia = cadenaFecha1.substring(6, 8);
/* 3220 */       String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 3221 */       String cliente = "<GENERAL>";
/* 3222 */       String equipo = "<GENERAL>";
/* 3223 */       String plat = "<GENERAL>";
/* 3224 */       String pozo = "<GENERAL>";
/* 3225 */       String valorCliente = "0";
/*      */       
/* 3227 */       if (this.jComboBox4.getSelectedIndex() != 0) {
/* 3228 */         cliente = String.valueOf(this.jComboBox4.getSelectedItem());
/* 3229 */         valorCliente = this.IDCLIENTE[this.jComboBox4.getSelectedIndex() - 1];
/*      */       } 
/* 3231 */       if (this.jComboBox21.getSelectedIndex() != 0) {
/* 3232 */         equipo = String.valueOf(this.jComboBox21.getSelectedItem());
/*      */       }
/* 3234 */       if (this.jComboBox22.getSelectedIndex() != 0) {
/* 3235 */         plat = String.valueOf(this.jComboBox22.getSelectedItem());
/*      */       }
/* 3237 */       if (this.jComboBox23.getSelectedIndex() != 0) {
/* 3238 */         pozo = String.valueOf(this.jComboBox23.getSelectedItem());
/*      */       }
/* 3240 */       if (this.jButton14.getText().equals("Guardar")) {
/* 3241 */         this.con.inserSinMsj("insert into prefacturas(folio,fecha,cliente,equipo,plat,pozo,tons,numViajes,tipo,actual,estatus,clave_gene,nombre_usu,PEDIDO)values('" + this.jTextField2.getText().toUpperCase() + "'," + fechaCompleta + ",'" + cliente + "','" + equipo + "','" + plat + "','" + pozo + "'," + this.TONS + "," + this.jTable1.getRowCount() + "," + this.TIPOREPOR + ",'<Prefactura Ingresada>','ACTIVA'," + valorCliente + ",'" + this.USUARIO + "','" + this.jTextField4.getText().toUpperCase() + "')");
/* 3242 */         this.con.consultar("max(numInterPre)", "prefacturas", "");
/* 3243 */         this.PREFAC = this.con.Campo;
/* 3244 */         this.mensajeTry.guardarConf("Se ha creado un nuevo reporte interno, USUARIO: " + this.USUARIO, "Nuevo Reporte Interno (" + this.PREFAC + ")", "INFO", "Facturacion");
/*      */       } else {
/*      */         
/* 3247 */         this.con.inserSinMsj("update prefacturas set folio='" + this.jTextField2.getText().toUpperCase() + "',fecha=" + fechaCompleta + ", cliente='" + cliente + "', equipo='" + equipo + "', plat='" + plat + "', pozo='" + pozo + "', tons=" + this.TONS + ", numViajes=" + this.jTable1.getRowCount() + ", tipo=" + this.TIPOREPOR + ", nombre_usu='" + this.USUARIO + "',pedido='" + this.jTextField4.getText().toUpperCase() + "' where numInterPre=" + this.PREFAC);
/*      */       } 
/*      */       
/* 3250 */       for (int k = 0; k < this.jTable1.getRowCount(); k++) {
/* 3251 */         this.con.inserSinMsj("update guias set comen_pre='" + String.valueOf(this.jTable1.getValueAt(k, 14)) + "',factura=" + this.PREFAC + ", pedido='" + String.valueOf(this.jTable1.getValueAt(k, 8)) + "' where num_guia = '" + String.valueOf(this.jTable1.getValueAt(k, 0)) + "'");
/*      */       }
/*      */     } 
/*      */     
/* 3255 */     if (this.jButton14.getText().equals("Imprimir")) {
/* 3256 */       if (this.TIPOREPOR == 0) {
/* 3257 */         ImprimirFacturas imp = new ImprimirFacturas();
/* 3258 */         imp.recibeDatos();
/* 3259 */       } else if (this.TIPOREPOR == 1) {
/* 3260 */         ImprimirFacturas2 imp = new ImprimirFacturas2();
/* 3261 */         imp.recibeDatos();
/*      */       } 
/*      */     } else {
/*      */       
/* 3265 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "Los datos han sido guardados satisfactoriamente\n¿Deseas imprimir los datos de la prefactura?", "Imprimir Prefactura", 0, 3, this.PREG);
/* 3266 */       if (res == 0) {
/* 3267 */         if (this.TIPOREPOR == 0) {
/* 3268 */           ImprimirFacturas imp = new ImprimirFacturas();
/* 3269 */           imp.recibeDatos();
/* 3270 */         } else if (this.TIPOREPOR == 1) {
/* 3271 */           ImprimirFacturas2 imp = new ImprimirFacturas2();
/* 3272 */           imp.recibeDatos();
/*      */         } 
/*      */       }
/*      */     } 
/* 3276 */     consultar();
/* 3277 */     this.jFrame1.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void imprimir2() {
/* 3282 */     this.addGuias = new AddGuias[11];
/* 3283 */     for (int i = 0; i < this.addGuias.length; i++) {
/* 3284 */       this.addGuias[i] = new AddGuias();
/*      */     }
/* 3286 */     this.TONSRESIDUO = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/* 3287 */     this.GUIASAMPARADAS = new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "" };
/* 3288 */     String COL = "";
/* 3289 */     if (this.TIPOREPOR == 0) {
/* 3290 */       COL = "PED";
/*      */     } else {
/* 3292 */       COL = "RSP";
/*      */     } 
/* 3294 */     this.NOMBRECOL = new String[] { "GUÍA", "FECHA", "SERVICIO", "RESIDUO", "EQUIPO", "TICK", "TONS", "TRAC", "REM", "MANIF", "COMENTARIO" };
/* 3295 */     this.LINEAS = new String[this.jTable1.getRowCount()];
/* 3296 */     this.LETRASMAX = new int[this.NOMBRECOL.length];
/* 3297 */     this.REGIS = new String[this.jTable1.getRowCount()][this.NOMBRECOL.length];
/* 3298 */     this.SERVICIOS = new String[] { "FLETE", "MOV FALSO", "MOV INTER", "RENTA", "SERV RETRO", "SERV INT" };
/* 3299 */     this.OTROSSERVICIOS = 0;
/* 3300 */     this.OTROSRESIDUOS = 0; int j;
/* 3301 */     for (j = 0; j < this.CANTTOTALES.length; j++) {
/* 3302 */       this.CANTTOTALES[j] = 0;
/*      */     }
/* 3304 */     for (j = 0; j < this.jTable1.getRowCount(); j++) {
/* 3305 */       String guiaSola = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3306 */       String fecha = String.valueOf(this.jTable1.getValueAt(j, 1));
/* 3307 */       String fechaCorta = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3308 */       String serv = String.valueOf(this.jTable1.getValueAt(j, 2));
/* 3309 */       String residuo = String.valueOf(this.jTable1.getValueAt(j, 3));
/* 3310 */       String cliente = String.valueOf(this.jTable1.getValueAt(j, 4));
/*      */       
/* 3312 */       String toneladas = String.valueOf(this.jTable1.getValueAt(j, 9));
/* 3313 */       double tonsInd = Double.parseDouble(toneladas);
/* 3314 */       int indice = 0;
/* 3315 */       if (cliente.equals("WEATHERFORD")) {
/* 3316 */         cliente = "WTF";
/* 3317 */       } else if (cliente.equals("SCHLUMBERGER")) {
/* 3318 */         cliente = "SLB";
/*      */       } 
/* 3320 */       if (serv.equals("SERVICIO INTEGRAL")) {
/* 3321 */         serv = "SERV INT";
/* 3322 */         this.CANTTOTALES[5] = this.CANTTOTALES[5] + 1;
/* 3323 */       } else if (serv.equals("MOVIMIENTO EN FALSO")) {
/* 3324 */         serv = "MOV FALSO";
/* 3325 */         this.CANTTOTALES[1] = this.CANTTOTALES[1] + 1;
/* 3326 */       } else if (serv.equals("MOVIMIENTO INTERNO")) {
/* 3327 */         serv = "MOV INTER";
/* 3328 */         this.CANTTOTALES[2] = this.CANTTOTALES[2] + 1;
/* 3329 */       } else if (serv.equals("SERVICIO DE RETRO")) {
/* 3330 */         this.CANTTOTALES[4] = this.CANTTOTALES[4] + 1;
/* 3331 */         serv = "SERV RET";
/* 3332 */       } else if (serv.equals("FLETE")) {
/* 3333 */         this.CANTTOTALES[0] = this.CANTTOTALES[0] + 1;
/* 3334 */       } else if (serv.equals("RENTA")) {
/* 3335 */         this.CANTTOTALES[3] = this.CANTTOTALES[3] + 1;
/*      */       } else {
/* 3337 */         this.OTROSSERVICIOS++;
/*      */       } 
/* 3339 */       if (residuo.equals("AGUA DE FRACTURA")) {
/* 3340 */         this.CANTTOTALES[6] = this.CANTTOTALES[6] + 1;
/* 3341 */         this.TONSRESIDUO[0] = this.TONSRESIDUO[0] + tonsInd;
/*      */         
/* 3343 */         if (this.GUIASAMPARADAS[0].equals("")) {
/* 3344 */           this.GUIASAMPARADAS[0] = guiaSola;
/*      */         } else {
/* 3346 */           this.GUIASAMPARADAS[0] = this.GUIASAMPARADAS[0] + ", " + this.GUIASAMPARADAS[0];
/*      */         } 
/* 3348 */         residuo = "AG DE FRAC";
/* 3349 */       } else if (residuo.equals("LODO BASE AGUA")) {
/* 3350 */         residuo = "L AGUA";
/* 3351 */         this.CANTTOTALES[9] = this.CANTTOTALES[9] + 1;
/* 3352 */         this.TONSRESIDUO[3] = this.TONSRESIDUO[3] + tonsInd;
/*      */         
/* 3354 */         if (this.GUIASAMPARADAS[3].equals("")) {
/* 3355 */           this.GUIASAMPARADAS[3] = guiaSola;
/*      */         } else {
/* 3357 */           this.GUIASAMPARADAS[3] = this.GUIASAMPARADAS[3] + ", " + this.GUIASAMPARADAS[3];
/*      */         } 
/* 3359 */       } else if (residuo.equals("RECORTE BASE ACEITE")) {
/* 3360 */         residuo = "R ACEITE";
/* 3361 */         this.CANTTOTALES[10] = this.CANTTOTALES[10] + 1;
/* 3362 */         this.TONSRESIDUO[4] = this.TONSRESIDUO[4] + tonsInd;
/*      */         
/* 3364 */         if (this.GUIASAMPARADAS[4].equals("")) {
/* 3365 */           this.GUIASAMPARADAS[4] = guiaSola;
/*      */         } else {
/* 3367 */           this.GUIASAMPARADAS[4] = this.GUIASAMPARADAS[4] + ", " + this.GUIASAMPARADAS[4];
/*      */         } 
/* 3369 */       } else if (residuo.equals("RECORTE BASE AGUA")) {
/* 3370 */         residuo = "R AGUA";
/* 3371 */         this.CANTTOTALES[11] = this.CANTTOTALES[11] + 1;
/* 3372 */         this.TONSRESIDUO[5] = this.TONSRESIDUO[5] + tonsInd;
/* 3373 */         if (this.GUIASAMPARADAS[5].equals("")) {
/* 3374 */           this.GUIASAMPARADAS[5] = guiaSola;
/*      */         } else {
/* 3376 */           this.GUIASAMPARADAS[5] = this.GUIASAMPARADAS[5] + ", " + this.GUIASAMPARADAS[5];
/*      */         }
/*      */       
/* 3379 */       } else if (residuo.equals("FLETES - VARIOS")) {
/* 3380 */         residuo = "FLET VAR";
/* 3381 */         this.CANTTOTALES[15] = this.CANTTOTALES[15] + 1;
/* 3382 */         this.TONSRESIDUO[9] = this.TONSRESIDUO[9] + tonsInd;
/* 3383 */         if (this.GUIASAMPARADAS[9].equals("")) {
/* 3384 */           this.GUIASAMPARADAS[9] = guiaSola;
/*      */         } else {
/* 3386 */           this.GUIASAMPARADAS[9] = this.GUIASAMPARADAS[9] + ", " + this.GUIASAMPARADAS[9];
/*      */         }
/*      */       
/* 3389 */       } else if (residuo.equals("AGUA RESIDUAL")) {
/* 3390 */         this.TONSRESIDUO[1] = this.TONSRESIDUO[1] + tonsInd;
/* 3391 */         if (this.GUIASAMPARADAS[1].equals("")) {
/* 3392 */           this.GUIASAMPARADAS[1] = guiaSola;
/*      */         } else {
/* 3394 */           this.GUIASAMPARADAS[1] = this.GUIASAMPARADAS[1] + ", " + this.GUIASAMPARADAS[1];
/*      */         } 
/*      */         
/* 3397 */         residuo = "AG RESID";
/* 3398 */         this.CANTTOTALES[7] = this.CANTTOTALES[7] + 1;
/* 3399 */       } else if (residuo.equals("LODO BASE ACEITE")) {
/* 3400 */         residuo = "L ACEITE";
/* 3401 */         this.CANTTOTALES[8] = this.CANTTOTALES[8] + 1;
/* 3402 */         if (this.GUIASAMPARADAS[2].equals("")) {
/* 3403 */           this.GUIASAMPARADAS[2] = guiaSola;
/*      */         } else {
/* 3405 */           this.GUIASAMPARADAS[2] = this.GUIASAMPARADAS[2] + ", " + this.GUIASAMPARADAS[2];
/*      */         }
/*      */       
/* 3408 */       } else if (residuo.equals("SALMUERA")) {
/* 3409 */         this.CANTTOTALES[12] = this.CANTTOTALES[12] + 1;
/* 3410 */         this.TONSRESIDUO[6] = this.TONSRESIDUO[6] + tonsInd;
/* 3411 */         if (this.GUIASAMPARADAS[6].equals("")) {
/* 3412 */           this.GUIASAMPARADAS[6] = guiaSola;
/*      */         } else {
/* 3414 */           this.GUIASAMPARADAS[6] = this.GUIASAMPARADAS[6] + ", " + this.GUIASAMPARADAS[6];
/*      */         }
/*      */       
/* 3417 */       } else if (residuo.equals("SANEAMIENTO")) {
/* 3418 */         residuo = "SANEAM";
/* 3419 */         this.CANTTOTALES[13] = this.CANTTOTALES[13] + 1;
/* 3420 */         this.TONSRESIDUO[7] = this.TONSRESIDUO[7] + tonsInd;
/* 3421 */         if (this.GUIASAMPARADAS[7].equals("")) {
/* 3422 */           this.GUIASAMPARADAS[7] = guiaSola;
/*      */         } else {
/* 3424 */           this.GUIASAMPARADAS[7] = this.GUIASAMPARADAS[7] + ", " + this.GUIASAMPARADAS[7];
/*      */         }
/*      */       
/* 3427 */       } else if (residuo.equals("SEDIMENTO")) {
/* 3428 */         residuo = "SEDIMEN";
/* 3429 */         this.CANTTOTALES[14] = this.CANTTOTALES[14] + 1;
/* 3430 */         this.TONSRESIDUO[8] = this.TONSRESIDUO[8] + tonsInd;
/* 3431 */         if (this.GUIASAMPARADAS[8].equals("")) {
/* 3432 */           this.GUIASAMPARADAS[8] = guiaSola;
/*      */         } else {
/* 3434 */           this.GUIASAMPARADAS[8] = this.GUIASAMPARADAS[8] + ", " + this.GUIASAMPARADAS[8];
/*      */         } 
/*      */       } else {
/*      */         
/* 3438 */         this.OTROSRESIDUOS++;
/* 3439 */         this.TONSRESIDUO[10] = this.TONSRESIDUO[10] + tonsInd;
/* 3440 */         if (this.GUIASAMPARADAS[10].equals("")) {
/* 3441 */           this.GUIASAMPARADAS[10] = guiaSola;
/*      */         } else {
/* 3443 */           this.GUIASAMPARADAS[10] = this.GUIASAMPARADAS[10] + ", " + this.GUIASAMPARADAS[10];
/*      */         } 
/*      */       } 
/* 3446 */       if (residuo.equals("FLUIDO RECUPERADO C/TRAZAS DE ACEITE")) {
/* 3447 */         residuo = "F RECUP/TRAZAS";
/*      */       }
/* 3449 */       else if (residuo.equals("FLUIDO RECUPERADO")) {
/* 3450 */         residuo = "F RECUP";
/*      */       } 
/* 3452 */       this.REGIS[j][0] = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3453 */       this.REGIS[j][1] = fechaCorta;
/* 3454 */       this.REGIS[j][2] = serv;
/* 3455 */       this.REGIS[j][3] = residuo;
/* 3456 */       this.REGIS[j][4] = String.valueOf(this.jTable1.getValueAt(j, 5));
/* 3457 */       this.REGIS[j][5] = String.valueOf(this.jTable1.getValueAt(j, 8));
/* 3458 */       this.REGIS[j][6] = String.valueOf(this.jTable1.getValueAt(j, 9));
/* 3459 */       this.REGIS[j][7] = String.valueOf(this.jTable1.getValueAt(j, 10));
/* 3460 */       this.REGIS[j][8] = String.valueOf(this.jTable1.getValueAt(j, 11));
/* 3461 */       this.REGIS[j][9] = String.valueOf(this.jTable1.getValueAt(j, 12));
/* 3462 */       this.REGIS[j][10] = String.valueOf(this.jTable1.getValueAt(j, 13));
/*      */     } 
/*      */     
/* 3465 */     if (this.jTextField2.isEnabled()) {
/* 3466 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3467 */       String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 3468 */       String año = cadenaFecha1.substring(0, 4);
/* 3469 */       String mes = cadenaFecha1.substring(4, 6);
/* 3470 */       String dia = cadenaFecha1.substring(6, 8);
/* 3471 */       String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 3472 */       String cliente = "<GENERAL>";
/* 3473 */       String equipo = "<GENERAL>";
/* 3474 */       String plat = "<GENERAL>";
/* 3475 */       String pozo = "<GENERAL>";
/* 3476 */       String valorCliente = "0";
/*      */       
/* 3478 */       if (this.jComboBox4.getSelectedIndex() != 0) {
/* 3479 */         cliente = String.valueOf(this.jComboBox4.getSelectedItem());
/* 3480 */         valorCliente = this.IDCLIENTE[this.jComboBox4.getSelectedIndex() - 1];
/*      */       } 
/* 3482 */       if (this.jComboBox21.getSelectedIndex() != 0) {
/* 3483 */         equipo = String.valueOf(this.jComboBox21.getSelectedItem());
/*      */       }
/* 3485 */       if (this.jComboBox22.getSelectedIndex() != 0) {
/* 3486 */         plat = String.valueOf(this.jComboBox22.getSelectedItem());
/*      */       }
/* 3488 */       if (this.jComboBox23.getSelectedIndex() != 0) {
/* 3489 */         pozo = String.valueOf(this.jComboBox23.getSelectedItem());
/*      */       }
/* 3491 */       if (this.jButton14.getText().equals("Guardar")) {
/* 3492 */         this.con.inserSinMsj("insert into prefacturas(folio,fecha,cliente,equipo,plat,pozo,tons,numViajes,tipo,actual,estatus,clave_gene,nombre_usu,pedido)values('" + this.jTextField2.getText().toUpperCase() + "'," + fechaCompleta + ",'" + cliente + "','" + equipo + "','" + plat + "','" + pozo + "'," + this.TONS + "," + this.jTable1.getRowCount() + "," + this.TIPOREPOR + ",'<Prefactura Ingresada>','ACTIVA'," + valorCliente + ",'" + this.USUARIO + "','" + this.jTextField4.getText() + "')");
/* 3493 */         this.con.consultar("max(numInterPre)", "prefacturas", "");
/* 3494 */         this.PREFAC = this.con.Campo;
/* 3495 */         this.mensajeTry.guardarConf("Se ha creado un nuevo reporte interno, USUARIO: " + this.USUARIO, "Nuevo Reporte Interno (" + this.PREFAC + ")", "INFO", "Facturacion");
/*      */       } else {
/*      */         
/* 3498 */         this.con.inserSinMsj("update prefacturas set folio='" + this.jTextField2.getText() + "',fecha=" + fechaCompleta + ", cliente='" + cliente + "', equipo='" + equipo + "', plat='" + plat + "', pozo='" + pozo + "', tons=" + this.TONS + ", numViajes=" + this.jTable1.getRowCount() + ", tipo=" + this.TIPOREPOR + ", nombre_usu='" + this.USUARIO + "',pedido='" + this.jTextField4.getText() + "' where numInterPre=" + this.PREFAC);
/*      */       } 
/* 3500 */       for (int k = 0; k < this.jTable1.getRowCount(); k++) {
/* 3501 */         this.con.inserSinMsj("update guias set comen_pre='" + String.valueOf(this.jTable1.getValueAt(k, 13)) + "',factura=" + this.PREFAC + ",pedido='' where num_guia = '" + String.valueOf(this.jTable1.getValueAt(k, 0)) + "'");
/*      */       }
/*      */       
/* 3504 */       consultar();
/*      */     } 
/* 3506 */     if (this.jButton14.getText().equals("Imprimir")) {
/* 3507 */       ImprimirFacturas3 imp = new ImprimirFacturas3();
/* 3508 */       imp.recibeDatos();
/*      */     } else {
/*      */       
/* 3511 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "Los datos han sido guardados satisfactoriamente\n¿Deseas imprimir los datos de la prefactura?", "Imprimir Prefactura", 0, 3, this.PREG);
/* 3512 */       if (res == 0) {
/* 3513 */         ImprimirFacturas3 imp = new ImprimirFacturas3();
/* 3514 */         imp.recibeDatos();
/*      */       } 
/*      */     } 
/* 3517 */     this.jFrame1.setVisible(false);
/*      */   }
/*      */   
/*      */   public void pasarTodos() {
/* 3521 */     dameModelo();
/* 3522 */     for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 3523 */       boolean esta = false;
/* 3524 */       String guia = String.valueOf(this.jTable3.getValueAt(i, 0));
/* 3525 */       String serv = String.valueOf(this.jTable3.getValueAt(i, 2));
/* 3526 */       String mani = "";
/*      */       
/* 3528 */       for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 3529 */         String valor = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3530 */         if (valor.equals(guia)) {
/* 3531 */           esta = true;
/*      */         }
/*      */       } 
/* 3534 */       if (!esta) {
/* 3535 */         if (serv.equals("SERVICIO INTEGRAL")) {
/* 3536 */           this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + guia + "'");
/* 3537 */           if (this.encontrado) {
/* 3538 */             mani = this.con.Campo;
/*      */           } else {
/* 3540 */             this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + guia + "'");
/* 3541 */             if (this.encontrado) {
/* 3542 */               mani = this.con.Campo;
/*      */             }
/*      */           } 
/*      */         } 
/* 3546 */         Object[] reg = null;
/* 3547 */         if (this.TIPOREPOR == 0) {
/* 3548 */           if (this.jButton14.getText().equals("Modificar")) {
/* 3549 */             reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), "", mani };
/*      */           } else {
/*      */             
/* 3552 */             reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), "", this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), mani, "" };
/*      */           }
/*      */         
/* 3555 */         } else if (this.TIPOREPOR == 1) {
/* 3556 */           if (this.jButton14.getText().equals("Modificar")) {
/* 3557 */             reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), this.jTable3.getValueAt(i, 9), this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), "", mani };
/*      */           } else {
/*      */             
/* 3560 */             reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), this.jTable3.getValueAt(i, 9), this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), mani, "" };
/*      */           }
/*      */         
/*      */         }
/* 3564 */         else if (this.jButton14.getText().equals("Modificar")) {
/* 3565 */           reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), "", mani };
/*      */         } else {
/*      */           
/* 3568 */           reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), mani, "" };
/*      */         } 
/*      */         
/* 3571 */         this.MODELOPREFACTURA.addRow(reg);
/* 3572 */         this.jTable1.setModel(this.MODELOPREFACTURA);
/* 3573 */         this.VIAJESTOT++;
/* 3574 */         String ton = String.valueOf(this.jTable3.getValueAt(i, 11));
/* 3575 */         this.TONS = Double.valueOf(this.TONS.doubleValue() + Double.parseDouble(ton));
/*      */       } 
/*      */     } 
/* 3578 */     this.PRESIONADO = true;
/* 3579 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   public void salir() {
/* 3583 */     String msj = "Has agregado viajes a una nueva prefactura, si cierras la ventana se perderán los datos";
/* 3584 */     if (this.jButton14.getText().equals("Modificar")) {
/* 3585 */       msj = "Los datos de la prefactura han sido modificado, si cierras la prefactura se perderá la información";
/*      */     }
/* 3587 */     if ((this.jButton14.getText().equals("Imprimir") || this.jButton14.getText().equals("Modificar")) && this.PRESIONADO) {
/* 3588 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "<html><font color='RED'><b>" + msj + "</b></font><br>¿Deseas guardar la informacion?</html>", "Cerrar Prefactura", 1, 3, this.PREG);
/* 3589 */       if (res == 0) {
/* 3590 */         if (this.jButton14.getText().equals("Modificar")) {
/* 3591 */           this.con.inserSinMsj("update guias set estatus='<Pagada Al Operador>', factura=0 where factura=" + this.PREFAC);
/* 3592 */           if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 3593 */             imprimir1();
/*      */           } else {
/* 3595 */             imprimir2();
/*      */           }
/*      */         
/*      */         }
/* 3599 */         else if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 3600 */           imprimir1();
/*      */         } else {
/* 3602 */           imprimir2();
/*      */         } 
/*      */         
/* 3605 */         this.jFrame1.setVisible(false);
/*      */       }
/* 3607 */       else if (res == 1) {
/* 3608 */         this.jFrame1.setVisible(false);
/*      */       } 
/*      */     } else {
/*      */       
/* 3612 */       this.jFrame1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void quitarViaje() {
/* 3617 */     this.PRESIONADO = true;
/* 3618 */     this.VIAJESTOT--;
/* 3619 */     String ton = "";
/* 3620 */     if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 3621 */       ton = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 10));
/*      */     } else {
/*      */       
/* 3624 */       ton = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 9));
/*      */     } 
/* 3626 */     this.TONS = Double.valueOf(this.TONS.doubleValue() - Double.parseDouble(ton));
/* 3627 */     dameModelo();
/* 3628 */     this.MODELOPREFACTURA.removeRow(this.jTable1.getSelectedRow());
/* 3629 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   public void pasarGuia() {
/* 3633 */     dameModelo();
/* 3634 */     String guia = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 3635 */     String serv = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2));
/* 3636 */     String mani = "";
/* 3637 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 3638 */       String valor = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 3639 */       if (valor.equals(guia)) {
/* 3640 */         JOptionPane.showMessageDialog(this.jDialog1, "La guía que deseas insertar ya se encuentra agregada a la prefactura", "Guía Duplicada", 0, this.ADVER);
/*      */         return;
/*      */       } 
/*      */     } 
/* 3644 */     if (serv.equals("SERVICIO INTEGRAL")) {
/* 3645 */       this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + guia + "'");
/* 3646 */       if (this.encontrado) {
/* 3647 */         mani = this.con.Campo;
/*      */       } else {
/* 3649 */         this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + guia + "'");
/* 3650 */         if (this.encontrado) {
/* 3651 */           mani = this.con.Campo;
/*      */         }
/*      */       } 
/*      */     } 
/* 3655 */     Object[] reg = null;
/* 3656 */     if (this.TIPOREPOR == 0) {
/* 3657 */       if (this.jButton14.getText().equals("Modificar")) {
/* 3658 */         reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), "", this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), "", mani };
/*      */       } else {
/*      */         
/* 3661 */         reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), "", this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), mani, "" };
/*      */       }
/*      */     
/* 3664 */     } else if (this.TIPOREPOR == 1) {
/* 3665 */       if (this.jButton14.getText().equals("Modificar")) {
/* 3666 */         reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 9), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), "", mani };
/*      */       } else {
/*      */         
/* 3669 */         reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 9), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), mani, "" };
/*      */       }
/*      */     
/*      */     }
/* 3673 */     else if (this.jButton14.getText().equals("Modificar")) {
/* 3674 */       reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), "", mani };
/*      */     } else {
/*      */       
/* 3677 */       reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), mani, "" };
/*      */     } 
/*      */     
/* 3680 */     this.MODELOPREFACTURA.addRow(reg);
/* 3681 */     this.jTable1.setModel(this.MODELOPREFACTURA);
/* 3682 */     this.VIAJESTOT++;
/* 3683 */     String ton = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11));
/* 3684 */     this.TONS = Double.valueOf(this.TONS.doubleValue() + Double.parseDouble(ton));
/* 3685 */     this.PRESIONADO = true;
/*      */     
/* 3687 */     this.TONS = Double.valueOf(Math.rint(this.TONS.doubleValue() * 1000.0D) / 1000.0D);
/* 3688 */     this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.VIAJESTOT + "</HTML>");
/* 3689 */     this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.TONS + "</HTML>");
/*      */   }
/*      */   public void dameModelo() {
/* 3692 */     this.MODELOPREFACTURA = (DefaultTableModel)this.jTable1.getModel();
/*      */   }
/*      */   public void bloquearTabla() {
/* 3695 */     String[] COLUMNAS = null;
/* 3696 */     if (this.TIPOREPOR == 0) {
/* 3697 */       COLUMNAS = new String[] { "Guía", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ped", "Ticket", "Tons.", "Eco/Trac", "Eco/Rem", "Manifiesto", "Comentario" };
/* 3698 */     } else if (this.TIPOREPOR == 1) {
/* 3699 */       COLUMNAS = new String[] { "Guía", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "RSP", "Ticket", "Tons.", "Eco/Trac", "Eco/Rem", "Manifiesto", "Comentario" };
/*      */     } else {
/* 3701 */       COLUMNAS = new String[] { "Guía", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ticket", "Tons.", "Eco/Trac", "Eco/Rem", "Manifiesto", "Comentario" };
/*      */     } 
/* 3703 */     String[][] registros = new String[this.jTable1.getRowCount()][this.jTable1.getColumnCount()];
/* 3704 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 3705 */       for (int j = 0; j < this.jTable1.getColumnCount(); j++) {
/* 3706 */         if (this.jTable1.getValueAt(i, j) == null) {
/* 3707 */           registros[i][j] = "";
/*      */         } else {
/* 3709 */           registros[i][j] = String.valueOf(this.jTable1.getValueAt(i, j));
/*      */         } 
/*      */       } 
/*      */     } 
/* 3713 */     this.jTable1.setModel(new DefaultTableModel((Object[][])registros, (Object[])COLUMNAS)
/*      */         {
/*      */           
/* 3716 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3720 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3723 */     this.jTable1.setSelectionMode(0);
/* 3724 */     this.jTable1.setAutoCreateRowSorter(true);
/* 3725 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 3727 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(60);
/* 3728 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
/* 3729 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(110);
/* 3730 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(110);
/* 3731 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(110);
/* 3732 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
/*      */ 
/*      */     
/* 3735 */     this.jTable1.getColumnModel().getColumn(9).setMinWidth(50);
/* 3736 */     this.jTable1.getColumnModel().getColumn(9).setMaxWidth(50);
/* 3737 */     this.jTable1.getColumnModel().getColumn(10).setMinWidth(50);
/* 3738 */     this.jTable1.getColumnModel().getColumn(10).setMaxWidth(50);
/* 3739 */     this.jTable1.getColumnModel().getColumn(11).setMinWidth(60);
/* 3740 */     this.jTable1.getColumnModel().getColumn(11).setMaxWidth(60);
/* 3741 */     this.jTable1.getColumnModel().getColumn(12).setMinWidth(60);
/* 3742 */     this.jTable1.getColumnModel().getColumn(12).setMaxWidth(60);
/* 3743 */     if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 3744 */       this.jTable1.getColumnModel().getColumn(13).setMinWidth(95);
/* 3745 */       this.jTable1.getColumnModel().getColumn(13).setMaxWidth(95);
/* 3746 */       this.jTable1.getColumnModel().getColumn(14).setMinWidth(200);
/* 3747 */       this.jTable1.getColumnModel().getColumn(14).setMaxWidth(200);
/*      */     } else {
/* 3749 */       this.jTable1.getColumnModel().getColumn(12).setMinWidth(120);
/* 3750 */       this.jTable1.getColumnModel().getColumn(12).setMaxWidth(120);
/* 3751 */       this.jTable1.getColumnModel().getColumn(13).setMinWidth(150);
/* 3752 */       this.jTable1.getColumnModel().getColumn(13).setMaxWidth(150);
/*      */     } 
/* 3754 */     this.TONS = Double.valueOf(Math.rint(this.TONS.doubleValue() * 1000.0D) / 1000.0D);
/* 3755 */     this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.VIAJESTOT + "</HTML>");
/* 3756 */     this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.TONS + "</HTML>");
/*      */   }
/*      */   
/*      */   public void prefacturas(String usu) {
/* 3760 */     this.jDateChooser1.setDate(this.fecha);
/* 3761 */     desactivarTabla();
/* 3762 */     this.USUARIO = usu;
/* 3763 */     this.panel.setViewportView(this);
/* 3764 */     privilegios();
/* 3765 */     consultar();
/*      */   }
/*      */   
/*      */   public void llenarCombos() {
/* 3769 */     String[] datos = this.con.regresaColIndex("nombre_usu", "usuarios", "where (priv='SUPER USUARIO' || priv='FACTURACION') && nombre_usu !='USUARIOADMIN1' order by nombre_usu");
/* 3770 */     this.jComboBox2.removeAllItems();
/* 3771 */     this.jComboBox2.addItem("TODOS"); int i;
/* 3772 */     for (i = 0; i < datos.length; i++) {
/* 3773 */       this.jComboBox2.addItem(datos[i]);
/*      */     }
/*      */     
/* 3776 */     datos = this.con.regresaColIndex("nombre_corto", "emp_generadora", "where clave_gene<>0 order by nombre_corto");
/* 3777 */     this.jComboBox3.removeAllItems();
/* 3778 */     this.jComboBox3.addItem("TODOS");
/* 3779 */     for (i = 0; i < datos.length; i++) {
/* 3780 */       this.jComboBox3.addItem(datos[i]);
/*      */     }
/*      */     
/* 3783 */     datos = this.con.regresaColIndex("nombre_corto", "emp_generadora", "where clave_gene<>0 and activo = 'Activado' order by nombre_corto");
/* 3784 */     this.IDCLIENTE = this.con.regresaColIndex("clave_gene", "emp_generadora", "where clave_gene<>0 and activo = 'Activado' order by nombre_corto");
/* 3785 */     this.jComboBox4.removeAllItems();
/* 3786 */     this.jComboBox20.removeAllItems();
/*      */     
/* 3788 */     this.jComboBox4.addItem("SELECCIONA UN CLIENTE...");
/* 3789 */     this.jComboBox20.addItem("SELECCIONA UN CLIENTE...");
/* 3790 */     for (i = 0; i < datos.length; i++) {
/* 3791 */       this.jComboBox4.addItem(datos[i]);
/* 3792 */       this.jComboBox20.addItem(datos[i]);
/*      */     } 
/*      */     
/* 3795 */     datos = this.con.regresaColIndex("distinct(residuo)", "llamadas_historicas", "order by residuo");
/* 3796 */     this.jComboBox5.removeAllItems();
/* 3797 */     this.jComboBox5.addItem("TODOS");
/* 3798 */     for (i = 0; i < datos.length; i++) {
/* 3799 */       this.jComboBox5.addItem(datos[i].toUpperCase());
/*      */     }
/*      */ 
/*      */     
/* 3803 */     datos = this.con.regresaColIndex("plataforma", "plataformas", "order by plataforma");
/* 3804 */     this.jComboBox8.removeAllItems();
/* 3805 */     this.jComboBox22.removeAllItems();
/* 3806 */     this.jComboBox8.addItem("TODOS");
/* 3807 */     this.jComboBox22.addItem("GENERAL");
/* 3808 */     for (i = 0; i < datos.length; i++) {
/* 3809 */       this.jComboBox8.addItem(datos[i]);
/* 3810 */       this.jComboBox22.addItem(datos[i]);
/*      */     } 
/*      */ 
/*      */     
/* 3814 */     datos = this.con.regresaColIndex("equipo", "equipos", "where clave_gene<>0  order by equipo");
/* 3815 */     this.jComboBox7.removeAllItems();
/* 3816 */     this.jComboBox21.removeAllItems();
/* 3817 */     this.jComboBox7.addItem("TODOS");
/* 3818 */     this.jComboBox21.addItem("GENERAL");
/* 3819 */     for (i = 0; i < datos.length; i++) {
/* 3820 */       this.jComboBox7.addItem(datos[i]);
/* 3821 */       this.jComboBox21.addItem(datos[i]);
/*      */     } 
/*      */ 
/*      */     
/* 3825 */     datos = this.con.regresaColIndex("nombre", "pozos", "where num_pozo<>0 order by nombre");
/* 3826 */     this.jComboBox9.removeAllItems();
/* 3827 */     this.jComboBox23.removeAllItems();
/* 3828 */     this.jComboBox9.addItem("TODOS");
/* 3829 */     this.jComboBox23.addItem("GENERAL");
/* 3830 */     for (i = 0; i < datos.length; i++) {
/* 3831 */       this.jComboBox9.addItem(datos[i]);
/* 3832 */       this.jComboBox23.addItem(datos[i]);
/*      */     } 
/*      */     
/* 3835 */     datos = this.con.regresaColIndex("distinct(tipo)", "guias", "where tipo<>'' order by tipo");
/* 3836 */     this.jComboBox6.removeAllItems();
/* 3837 */     this.jComboBox6.addItem("TODOS");
/* 3838 */     for (i = 0; i < datos.length; i++) {
/* 3839 */       this.jComboBox6.addItem(datos[i].toUpperCase());
/*      */     }
/*      */     
/* 3842 */     datos = this.con.regresaColIndex("distinct(servicio)", "guias", "where servicio<>'' order by servicio");
/* 3843 */     this.jComboBox10.removeAllItems();
/* 3844 */     this.jComboBox10.addItem("TODOS");
/* 3845 */     for (i = 0; i < datos.length; i++) {
/* 3846 */       this.jComboBox10.addItem(datos[i].toUpperCase());
/*      */     }
/*      */   }
/*      */   
/*      */   public void desactivarTabla() {
/* 3851 */     this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>0</HTML>");
/* 3852 */     this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>0.0</HTML>");
/* 3853 */     this.MODELOPREFACTURA = new DefaultTableModel();
/* 3854 */     this.MODELOPREFACTURA.addColumn("Guía");
/* 3855 */     this.MODELOPREFACTURA.addColumn("Fecha");
/* 3856 */     this.MODELOPREFACTURA.addColumn("Servicio");
/* 3857 */     this.MODELOPREFACTURA.addColumn("Residuo");
/* 3858 */     this.MODELOPREFACTURA.addColumn("Cliente");
/* 3859 */     this.MODELOPREFACTURA.addColumn("Equipo");
/* 3860 */     this.MODELOPREFACTURA.addColumn("Plataforma");
/* 3861 */     this.MODELOPREFACTURA.addColumn("Pozo");
/* 3862 */     if (this.TIPOREPOR == 0) {
/* 3863 */       this.MODELOPREFACTURA.addColumn("PED");
/* 3864 */     } else if (this.TIPOREPOR == 1) {
/* 3865 */       this.MODELOPREFACTURA.addColumn("RSP");
/*      */     } 
/* 3867 */     this.MODELOPREFACTURA.addColumn("Ticket");
/* 3868 */     this.MODELOPREFACTURA.addColumn("Tons.");
/* 3869 */     this.MODELOPREFACTURA.addColumn("Tons.");
/* 3870 */     this.MODELOPREFACTURA.addColumn("Tons.");
/* 3871 */     this.MODELOPREFACTURA.addColumn("Eco/Trac");
/* 3872 */     this.MODELOPREFACTURA.addColumn("Eco/Rem");
/* 3873 */     this.MODELOPREFACTURA.addColumn("Manifiesto");
/* 3874 */     this.MODELOPREFACTURA.addColumn("Comentario");
/* 3875 */     this.TONS = Double.valueOf(0.0D);
/* 3876 */     this.VIAJESTOT = 0;
/* 3877 */     this.jTable1.setModel(this.MODELOPREFACTURA);
/* 3878 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 3882 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3884 */             Archivo.this.jTextGanado(Archivo.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3888 */             Archivo.this.jTextPerdido(Archivo.this.jTextField1, evt);
/*      */           }
/*      */         });
/*      */     
/* 3892 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3894 */             Archivo.this.jTextGanado(Archivo.this.jTextField7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3897 */             Archivo.this.jTextPerdido(Archivo.this.jTextField7, evt);
/*      */           }
/*      */         });
/*      */     
/* 3901 */     this.jTextField2.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3904 */             Archivo.this.jTextGanado(Archivo.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3908 */             Archivo.this.jTextPerdido(Archivo.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 3911 */     this.jTextField3.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3914 */             Archivo.this.jTextGanado(Archivo.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3918 */             Archivo.this.jTextPerdido(Archivo.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 3921 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3923 */             Archivo.this.jTextGanado(Archivo.this.jTextField6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3926 */             Archivo.this.jTextPerdido(Archivo.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 3929 */     this.jComboBox1.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3932 */             Archivo.this.jTextGanado(Archivo.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3936 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 3939 */     this.jComboBox2.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3942 */             Archivo.this.jTextGanado(Archivo.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3946 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 3949 */     this.jComboBox3.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3952 */             Archivo.this.jTextGanado(Archivo.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3956 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 3959 */     this.jComboBox3.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3962 */             Archivo.this.jTextGanado(Archivo.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3966 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 3969 */     this.jComboBox4.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3972 */             Archivo.this.jTextGanado(Archivo.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3976 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 3979 */     this.jComboBox5.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3982 */             Archivo.this.jTextGanado(Archivo.this.jComboBox5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3986 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox5, evt);
/*      */           }
/*      */         });
/* 3989 */     this.jComboBox6.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3992 */             Archivo.this.jTextGanado(Archivo.this.jComboBox6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3996 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox6, evt);
/*      */           }
/*      */         });
/* 3999 */     this.jComboBox7.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4002 */             Archivo.this.jTextGanado(Archivo.this.jComboBox7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4006 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox7, evt);
/*      */           }
/*      */         });
/* 4009 */     this.jComboBox8.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4012 */             Archivo.this.jTextGanado(Archivo.this.jComboBox8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4016 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox8, evt);
/*      */           }
/*      */         });
/* 4019 */     this.jComboBox9.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4022 */             Archivo.this.jTextGanado(Archivo.this.jComboBox9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4026 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox9, evt);
/*      */           }
/*      */         });
/* 4029 */     this.jComboBox10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4031 */             Archivo.this.jTextGanado(Archivo.this.jComboBox10, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4034 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox10, evt);
/*      */           }
/*      */         });
/* 4037 */     this.jComboBox20.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4040 */             Archivo.this.jTextGanado(Archivo.this.jComboBox20, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4044 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox20, evt);
/*      */           }
/*      */         });
/* 4047 */     this.jComboBox21.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4050 */             Archivo.this.jTextGanado(Archivo.this.jComboBox21, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4054 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox21, evt);
/*      */           }
/*      */         });
/* 4057 */     this.jComboBox22.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4060 */             Archivo.this.jTextGanado(Archivo.this.jComboBox22, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4064 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox22, evt);
/*      */           }
/*      */         });
/* 4067 */     this.jComboBox23.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4070 */             Archivo.this.jTextGanado(Archivo.this.jComboBox23, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4074 */             Archivo.this.jTextPerdido(Archivo.this.jComboBox23, evt);
/*      */           }
/*      */         });
/* 4077 */     this.jTextArea5.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4080 */             Archivo.this.jTextGanado(Archivo.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4084 */             Archivo.this.jTextPerdido(Archivo.this.jTextArea5, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 4090 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 4094 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 4098 */     this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 4099 */     if (this.con.Campo.equals("ADMINISTRADOR") || this.con.Campo.equals("FACTURACIÓN")) {
/* 4100 */       this.jComboBox2.setSelectedItem(this.USUARIO);
/* 4101 */       this.jComboBox2.setEnabled(false);
/*      */     } else {
/* 4103 */       this.jComboBox2.setEnabled(true);
/* 4104 */       this.jComboBox2.setSelectedIndex(0);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 4109 */     this.PRIMERA = true;
/* 4110 */     boolean correcto = true;
/* 4111 */     if (this.jDateChooser11.getDate() == null) {
/* 4112 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 4113 */       if (res == 0) {
/* 4114 */         this.jDateChooser11.setDate(this.fechaActual);
/* 4115 */         correcto = true;
/*      */       } else {
/* 4117 */         correcto = false;
/*      */       } 
/* 4119 */     } else if (this.jDateChooser12.getDate() == null) {
/* 4120 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 4121 */       if (res == 0) {
/* 4122 */         this.jDateChooser12.setDate(this.fechaActual);
/* 4123 */         correcto = true;
/*      */       } else {
/* 4125 */         correcto = false;
/*      */       } 
/* 4127 */     } else if (correcto) {
/* 4128 */       Date fecha1 = this.jDateChooser11.getDate();
/* 4129 */       Date fecha2 = this.jDateChooser12.getDate();
/*      */       
/* 4131 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4132 */       String cadenaFecha = "";
/* 4133 */       cadenaFecha = formato.format(fecha1);
/* 4134 */       String AÑO = cadenaFecha.substring(0, 4);
/* 4135 */       String MES = cadenaFecha.substring(4, 6);
/* 4136 */       String DIA = cadenaFecha.substring(6, 8);
/* 4137 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 4139 */       cadenaFecha = formato.format(fecha2);
/* 4140 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 4141 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 4142 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 4143 */       int diasTotal = diasDelMes(mm - 1, aa);
/* 4144 */       String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + "'";
/*      */       
/* 4146 */       this.jButton5.setEnabled(false);
/* 4147 */       this.jButton11.setEnabled(false);
/* 4148 */       this.jButton12.setEnabled(false);
/* 4149 */       String estatus = "";
/* 4150 */       String usuario = "";
/* 4151 */       String cliente = "";
/*      */       
/* 4153 */       if (this.jComboBox1.getSelectedIndex() != 2) {
/* 4154 */         estatus = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */       }
/* 4156 */       if (this.jComboBox2.getSelectedIndex() != 0) {
/* 4157 */         usuario = String.valueOf(this.jComboBox2.getSelectedItem());
/*      */       }
/* 4159 */       if (this.jComboBox3.getSelectedIndex() != 0) {
/* 4160 */         cliente = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */       }
/*      */ 
/*      */       
/* 4164 */       this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 4165 */             .buscarDatos(13, "NumInterPre,folio,fecha,cliente,equipo,plat,pozo,pedido,tons,numViajes,nombre_usu,estatus,actual", "prefacturas", "where estatus like '%" + estatus + "%' and nombre_usu like '%" + usuario + "%' and cliente like '%" + cliente + "%' and folio like '%" + this.jTextField1.getText() + "%' and numInterpre like'%" + this.jTextField6.getText() + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by numInterPre desc"), (Object[])new String[] { "Núm", "Folio", "Fecha", "Cliente", "Equipo", "Plataforma", "Pozo", "Pedido", "Tons", "Núm Viajes", "Responsable", "Estado", "Actual" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 4170 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false };
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4175 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 4178 */       this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable2.getRowCount() + "</HTML>");
/* 4179 */       if (this.jComboBox1.getSelectedIndex() == 2) {
/*      */ 
/*      */ 
/*      */         
/* 4183 */         this.celda.pasarInd(this.con.revisarCol(this.jTable2, "<Cancelada", 0, 12, 2));
/*      */       } else {
/*      */         
/* 4186 */         String[] arre = new String[0];
/* 4187 */         this.celda.pasarInd(arre);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 4192 */       this.celda.pasarInd2(this.con.revisarCol(this.jTable2, "<Prefactura Ingresada>", 0, 12, 0));
/*      */       
/* 4194 */       this.jTable2.setSelectionMode(0);
/* 4195 */       this.jTable2.setAutoCreateRowSorter(true);
/* 4196 */       this.jTable2.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 4198 */       this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 4199 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 4200 */       this.jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
/* 4201 */       this.jTable2.getColumnModel().getColumn(1).setMaxWidth(100);
/* 4202 */       this.jTable2.getColumnModel().getColumn(2).setPreferredWidth(70);
/* 4203 */       this.jTable2.getColumnModel().getColumn(2).setMaxWidth(70);
/* 4204 */       this.jTable2.getColumnModel().getColumn(8).setPreferredWidth(50);
/* 4205 */       this.jTable2.getColumnModel().getColumn(8).setMaxWidth(50);
/* 4206 */       this.jTable2.getColumnModel().getColumn(9).setPreferredWidth(70);
/* 4207 */       this.jTable2.getColumnModel().getColumn(9).setMaxWidth(70);
/* 4208 */       this.jTable2.getColumnModel().getColumn(12).setPreferredWidth(160);
/* 4209 */       this.jTable2.getColumnModel().getColumn(12).setMaxWidth(160);
/*      */       
/* 4211 */       this.jTable2.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 4212 */       this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 4213 */       this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 4214 */       this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 4215 */       this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 4216 */       this.jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 4217 */       this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 4218 */       this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 4219 */       this.jTable2.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 4220 */       this.jTable2.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 4221 */       this.jTable2.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 4222 */       this.jTable2.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 4223 */       this.jTable2.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarGuias() {
/* 4228 */     System.out.println("contador ---> " + this.contador);
/* 4229 */     this.contador++;
/* 4230 */     this.PRIMERAGUIAS = true;
/* 4231 */     Date fecha1 = this.jDateChooser1.getDate();
/* 4232 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4233 */     String cadenaFecha = "";
/* 4234 */     cadenaFecha = formato.format(fecha1);
/* 4235 */     String AÑO = cadenaFecha.substring(0, 4);
/* 4236 */     String MES = cadenaFecha.substring(4, 6);
/* 4237 */     String DIA = cadenaFecha.substring(6, 8);
/* 4238 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/* 4240 */     fecha1 = this.jDateChooser2.getDate();
/* 4241 */     formato = new SimpleDateFormat("yyyyMMdd");
/* 4242 */     cadenaFecha = "";
/* 4243 */     cadenaFecha = formato.format(fecha1);
/* 4244 */     AÑO = cadenaFecha.substring(0, 4);
/* 4245 */     MES = cadenaFecha.substring(4, 6);
/* 4246 */     DIA = cadenaFecha.substring(6, 8);
/* 4247 */     String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + " 23:59:59'";
/*      */     
/* 4249 */     String residuo = "";
/* 4250 */     String tipo = "";
/* 4251 */     String equipo = "";
/* 4252 */     String plat = "";
/* 4253 */     String pozo = "";
/* 4254 */     String cliente = "";
/* 4255 */     String servicio = "";
/*      */     
/* 4257 */     if (this.jComboBox5.getSelectedIndex() != 0) {
/* 4258 */       residuo = String.valueOf(this.jComboBox5.getSelectedItem());
/*      */     }
/* 4260 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 4261 */       tipo = String.valueOf(this.jComboBox6.getSelectedItem());
/*      */     }
/* 4263 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/* 4264 */       equipo = String.valueOf(this.jComboBox7.getSelectedItem());
/*      */     }
/* 4266 */     if (this.jComboBox8.getSelectedIndex() != 0) {
/* 4267 */       plat = String.valueOf(this.jComboBox8.getSelectedItem());
/*      */     }
/* 4269 */     if (this.jComboBox9.getSelectedIndex() != 0) {
/* 4270 */       pozo = String.valueOf(this.jComboBox9.getSelectedItem());
/*      */     }
/* 4272 */     if (this.jComboBox20.getSelectedIndex() != 0) {
/* 4273 */       cliente = String.valueOf(this.jComboBox20.getSelectedItem());
/*      */     }
/* 4275 */     if (this.jComboBox10.getSelectedIndex() != 0) {
/* 4276 */       servicio = String.valueOf(this.jComboBox10.getSelectedItem());
/*      */     }
/* 4278 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 4279 */           .buscarDatos(15, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,guias.tipo,equipo,plataforma,pozos.nombre,rsp,ticket,peso,num_tracto,num_rem,guias.estatus", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale = vales.num_vale and guias.num_guia like '%" + this.jTextField3
/*      */ 
/*      */ 
/*      */             
/* 4283 */             .getText() + "%' and residuo like '%" + residuo + "%' and emp_generadora.nombre_corto like '%" + cliente + "%' and equipo like '%" + equipo + "%' and plataforma like '%" + plat + "%' and pozos.nombre like '%" + pozo + "%' and guias.estado ='Activa' and guias.tipo like '%" + tipo + "%' and (estatus like '%<Pagada Al Operador%' || estatus like '%<Asignada Al Operador%' || estatus like '%Sólo Cargada: En Patio%') and guias.servicio like '%" + servicio + "%' and num_tracto like '%" + this.jTextField7
/*      */             
/* 4285 */             .getText() + "%' order by guias.num_guia desc"), (Object[])new String[] { 
/*      */             "Folio", "Fecha", "Servicio", "Residuo", "Cliente", "Tipo", "Equipo", "Plataforma", "Pozo", "R.S.P.", 
/*      */             "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Estatus" })
/*      */         {
/*      */           
/* 4290 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4295 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4298 */     this.jLabel50.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable3.getRowCount() + "</HTML>");
/* 4299 */     this.celda2.pasarInd(this.con.revisarCol(this.jTable3, "<Asignada Al Operador", 0, 14, 2));
/*      */     
/* 4301 */     this.jTable3.setSelectionMode(0);
/* 4302 */     this.jTable3.setAutoCreateRowSorter(true);
/* 4303 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 4305 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 4306 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 4307 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 4308 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 4309 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 4310 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 4311 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 4312 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 4313 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 4314 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 4315 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 4316 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 4317 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 4318 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda2);
/* 4319 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda2);
/*      */   }
/*      */   public class ImprimirFacturas implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA; int renglonGuias;
/*      */     int[] PXCOL;
/*      */     
/*      */     public ImprimirFacturas() {
/* 4325 */       this.g2 = null;
/* 4326 */       this.Pag = 0;
/*      */       
/* 4328 */       this.linesPerPage = 50;
/* 4329 */       this.orientacion = 0;
/* 4330 */       this.X = 0.0D;
/* 4331 */       this.Y = 0.0D;
/* 4332 */       this.YINICIA = 100;
/* 4333 */       this.renglonGuias = 0;
/*      */       
/* 4335 */       this.PXCOL = new int[] { 36, 77, 120, 190, 255, 317, 349, 380, 412, 442, 498 };
/*      */     }
/*      */     private void initTextLines() {
/* 4338 */       if (this.textLines == null) {
/* 4339 */         this.Lineas = Archivo.this.LINEAS;
/* 4340 */         int numLines = this.Lineas.length;
/* 4341 */         this.textLines = new String[numLines];
/* 4342 */         for (int i = 0; i < numLines; i++) {
/* 4343 */           this.textLines[i] = this.Lineas[i];
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 4349 */       Font font = new Font("Serif", 0, 8);
/* 4350 */       FontMetrics metrics = g.getFontMetrics(font);
/* 4351 */       int lineHeight = metrics.getHeight();
/* 4352 */       if (this.pageBreaks == null) {
/* 4353 */         initTextLines();
/* 4354 */         this.orientacion = pf.getOrientation();
/* 4355 */         if (pf.getOrientation() == 1) {
/* 4356 */           this.renglonGuias = 12;
/* 4357 */           this.linesPerPage = 35;
/* 4358 */           this.X = pf.getWidth();
/* 4359 */           this.Y = pf.getHeight();
/*      */         } else {
/* 4361 */           this.renglonGuias = 17;
/* 4362 */           this.linesPerPage = 22;
/* 4363 */           this.X = pf.getWidth();
/* 4364 */           this.Y = pf.getHeight();
/*      */         } 
/* 4366 */         int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 4367 */         this.Pag = numBreaks;
/* 4368 */         this.pageBreaks = new int[numBreaks];
/* 4369 */         for (int b = 0; b < numBreaks; b++) {
/* 4370 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 4373 */       if (pageIndex > this.pageBreaks.length) {
/* 4374 */         return 1;
/*      */       }
/* 4376 */       Graphics2D g2d = (Graphics2D)g;
/* 4377 */       this.g2 = g;
/* 4378 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 4379 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 4380 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 4381 */       encabezado();
/* 4382 */       int y = this.YINICIA + 5;
/* 4383 */       int lineas = 0;
/*      */       
/* 4385 */       for (int line = start; line < end; line++) {
/* 4386 */         y += 16;
/* 4387 */         int Xempe = 35;
/* 4388 */         String valor = "";
/* 4389 */         if (line < 9) {
/* 4390 */           valor = "0" + line + 1;
/*      */         } else {
/* 4392 */           valor = "" + line + 1;
/*      */         } 
/* 4394 */         g.drawString(valor, 20, y);
/* 4395 */         this.g2.drawString(Archivo.this.REGIS[line][0], this.PXCOL[0], y);
/* 4396 */         this.g2.drawString(Archivo.this.REGIS[line][1], this.PXCOL[1], y);
/* 4397 */         this.g2.drawString(Archivo.this.REGIS[line][2], this.PXCOL[2], y);
/* 4398 */         this.g2.drawString(Archivo.this.REGIS[line][3], this.PXCOL[3], y);
/* 4399 */         this.g2.drawString(Archivo.this.REGIS[line][4], this.PXCOL[4], y);
/* 4400 */         this.g2.drawString(Archivo.this.REGIS[line][5], this.PXCOL[5], y);
/* 4401 */         this.g2.drawString(Archivo.this.REGIS[line][6], this.PXCOL[6], y);
/* 4402 */         this.g2.drawString(Archivo.this.REGIS[line][7], this.PXCOL[7], y);
/* 4403 */         this.g2.drawString(Archivo.this.REGIS[line][8], this.PXCOL[8], y);
/* 4404 */         this.g2.drawString(Archivo.this.REGIS[line][9], this.PXCOL[9], y);
/* 4405 */         this.g2.drawString(Archivo.this.REGIS[line][10], this.PXCOL[10], y);
/* 4406 */         y += 2;
/* 4407 */         lineas = y;
/* 4408 */         this.g2.drawLine(18, y, (int)this.X - 47, y);
/* 4409 */         this.g2.drawLine(this.PXCOL[1] - 3, 106, this.PXCOL[1] - 3, y);
/* 4410 */         this.g2.drawLine(this.PXCOL[2] - 3, 106, this.PXCOL[2] - 3, y);
/* 4411 */         this.g2.drawLine(this.PXCOL[3] - 3, 106, this.PXCOL[3] - 3, y);
/* 4412 */         this.g2.drawLine(this.PXCOL[4] - 3, 106, this.PXCOL[4] - 3, y);
/* 4413 */         this.g2.drawLine(this.PXCOL[5] - 3, 106, this.PXCOL[5] - 3, y);
/* 4414 */         this.g2.drawLine(this.PXCOL[6] - 3, 106, this.PXCOL[6] - 3, y);
/* 4415 */         this.g2.drawLine(this.PXCOL[7] - 3, 106, this.PXCOL[7] - 3, y);
/* 4416 */         this.g2.drawLine(this.PXCOL[8] - 3, 106, this.PXCOL[8] - 3, y);
/* 4417 */         this.g2.drawLine(this.PXCOL[9] - 3, 106, this.PXCOL[9] - 3, y);
/* 4418 */         this.g2.drawLine(this.PXCOL[10] - 3, 106, this.PXCOL[10] - 3, y);
/*      */       } 
/* 4420 */       this.g2.drawLine(34, this.YINICIA + 5, 34, lineas);
/* 4421 */       this.g2.drawLine(18, this.YINICIA + 5, 18, lineas);
/* 4422 */       this.g2.drawLine((int)this.X - 47, this.YINICIA + 5, (int)this.X - 47, lineas);
/* 4423 */       if (this.orientacion == 1) {
/* 4424 */         g.drawString("Página " + pageIndex + 1, 538, 760);
/*      */       } else {
/* 4426 */         g.drawString("Página " + pageIndex + 1, 715, 570);
/*      */       } 
/* 4428 */       Font fuente = new Font("Dialog", 0, 7);
/* 4429 */       this.g2.setFont(fuente);
/* 4430 */       if (this.Pag == pageIndex) {
/* 4431 */         this.g2.drawLine(18, lineas + 17, (int)this.X - 47, lineas + 17);
/* 4432 */         this.g2.drawLine(18, lineas + 19, (int)this.X - 47, lineas + 19);
/* 4433 */         lineas += 30;
/* 4434 */         if (Archivo.this.CANTTOTALES[6] != 0) {
/* 4435 */           fuente = new Font("Dialog", 1, 7);
/* 4436 */           this.g2.setFont(fuente);
/* 4437 */           this.g2.drawString("A de Fractura: " + Math.rint(Archivo.this.TONSRESIDUO[0] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4438 */           fuente = new Font("Dialog", 0, 7);
/* 4439 */           this.g2.setFont(fuente);
/* 4440 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[0] + "}", 110, lineas);
/* 4441 */           lineas += 15;
/*      */         } 
/* 4443 */         if (Archivo.this.CANTTOTALES[7] != 0) {
/* 4444 */           fuente = new Font("Dialog", 1, 7);
/* 4445 */           this.g2.setFont(fuente);
/* 4446 */           this.g2.drawString("A Residual: " + Math.rint(Archivo.this.TONSRESIDUO[1] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4447 */           fuente = new Font("Dialog", 0, 7);
/* 4448 */           this.g2.setFont(fuente);
/* 4449 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[1] + "}", 100, lineas);
/* 4450 */           lineas += 15;
/*      */         } 
/* 4452 */         if (Archivo.this.CANTTOTALES[8] != 0) {
/* 4453 */           fuente = new Font("Dialog", 1, 7);
/* 4454 */           this.g2.setFont(fuente);
/* 4455 */           this.g2.drawString("Lodo B Aceite: " + Math.rint(Archivo.this.TONSRESIDUO[2] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4456 */           fuente = new Font("Dialog", 0, 7);
/* 4457 */           this.g2.setFont(fuente);
/* 4458 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[2] + "}", 115, lineas);
/* 4459 */           lineas += 15;
/*      */         } 
/* 4461 */         if (Archivo.this.CANTTOTALES[9] != 0) {
/* 4462 */           fuente = new Font("Dialog", 1, 7);
/* 4463 */           this.g2.setFont(fuente);
/* 4464 */           this.g2.drawString("Lodo B Agua: " + Math.rint(Archivo.this.TONSRESIDUO[3] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4465 */           fuente = new Font("Dialog", 0, 7);
/* 4466 */           this.g2.setFont(fuente);
/* 4467 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[3] + "}", 115, lineas);
/* 4468 */           lineas += 15;
/*      */         } 
/* 4470 */         if (Archivo.this.CANTTOTALES[10] != 0) {
/* 4471 */           fuente = new Font("Dialog", 1, 7);
/* 4472 */           this.g2.setFont(fuente);
/* 4473 */           this.g2.drawString("Recorte B Aceite: " + Math.rint(Archivo.this.TONSRESIDUO[4] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4474 */           fuente = new Font("Dialog", 0, 7);
/* 4475 */           this.g2.setFont(fuente);
/* 4476 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[4] + "}", 125, lineas);
/* 4477 */           lineas += 15;
/*      */         } 
/* 4479 */         if (Archivo.this.CANTTOTALES[11] != 0) {
/* 4480 */           fuente = new Font("Dialog", 1, 7);
/* 4481 */           this.g2.setFont(fuente);
/* 4482 */           this.g2.drawString("Recorte B Agua: " + Math.rint(Archivo.this.TONSRESIDUO[5] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4483 */           fuente = new Font("Dialog", 0, 7);
/* 4484 */           this.g2.setFont(fuente);
/* 4485 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[5] + "}", 120, lineas);
/* 4486 */           lineas += 15;
/*      */         } 
/* 4488 */         if (Archivo.this.CANTTOTALES[12] != 0) {
/* 4489 */           fuente = new Font("Dialog", 1, 7);
/* 4490 */           this.g2.setFont(fuente);
/* 4491 */           this.g2.drawString("Salmuera: " + Math.rint(Archivo.this.TONSRESIDUO[6] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4492 */           fuente = new Font("Dialog", 0, 7);
/* 4493 */           this.g2.setFont(fuente);
/* 4494 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[6] + "}", 105, lineas);
/* 4495 */           lineas += 15;
/*      */         } 
/* 4497 */         if (Archivo.this.CANTTOTALES[13] != 0) {
/* 4498 */           fuente = new Font("Dialog", 1, 7);
/* 4499 */           this.g2.setFont(fuente);
/* 4500 */           this.g2.drawString("Saneamiento: " + Math.rint(Archivo.this.TONSRESIDUO[7] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4501 */           fuente = new Font("Dialog", 0, 7);
/* 4502 */           this.g2.setFont(fuente);
/* 4503 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[7] + "}", 110, lineas);
/* 4504 */           lineas += 15;
/*      */         } 
/* 4506 */         if (Archivo.this.CANTTOTALES[14] != 0) {
/* 4507 */           fuente = new Font("Dialog", 1, 7);
/* 4508 */           this.g2.setFont(fuente);
/* 4509 */           this.g2.drawString("Sedimento: " + Math.rint(Archivo.this.TONSRESIDUO[8] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4510 */           fuente = new Font("Dialog", 0, 7);
/* 4511 */           this.g2.setFont(fuente);
/* 4512 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[8] + "}", 105, lineas);
/* 4513 */           lineas += 15;
/*      */         } 
/* 4515 */         if (Archivo.this.CANTTOTALES[15] != 0) {
/* 4516 */           fuente = new Font("Dialog", 1, 7);
/* 4517 */           this.g2.setFont(fuente);
/* 4518 */           this.g2.drawString("Fletes - Varios: " + Math.rint(Archivo.this.TONSRESIDUO[9] * 1000.0D) / 1000.0D + " Tons ", 20, lineas);
/* 4519 */           fuente = new Font("Dialog", 0, 7);
/* 4520 */           this.g2.setFont(fuente);
/* 4521 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[9] + "}", 100, lineas);
/* 4522 */           lineas += 15;
/*      */         } 
/* 4524 */         if (Archivo.this.OTROSRESIDUOS != 0) {
/* 4525 */           fuente = new Font("Dialog", 1, 7);
/* 4526 */           this.g2.setFont(fuente);
/* 4527 */           this.g2.drawString("Otros: " + Math.rint(Archivo.this.TONSRESIDUO[10] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4528 */           fuente = new Font("Dialog", 0, 7);
/* 4529 */           this.g2.setFont(fuente);
/* 4530 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[10] + "}", 95, lineas);
/* 4531 */           lineas += 15;
/*      */         } 
/*      */       } 
/* 4534 */       this.g2.setColor(Color.WHITE);
/* 4535 */       this.g2.fillRect((int)this.X - 46, 12, (int)this.X - 46, lineas);
/* 4536 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 4540 */       Font fuente = new Font("Dialog", 0, 8);
/* 4541 */       this.g2.setFont(fuente);
/* 4542 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 4543 */       Image img = imagen.getImage();
/* 4544 */       this.g2.drawImage(img, 16, 6, 45, 45, null);
/* 4545 */       fuente = new Font("Times New Roman", 1, 19);
/* 4546 */       this.g2.setFont(fuente);
/* 4547 */       this.g2.drawString("GRUPO FORSIS - " + Archivo.this.base, 220, 20);
/* 4548 */       fuente = new Font("Dialog", 0, 16);
/* 4549 */       this.g2.setFont(fuente);
/* 4550 */       this.g2.drawString("REPORTE INTERNO DE PREFACTURA", 205, 39);
/*      */       
/* 4552 */       fuente = new Font("Dialog", 2, 9);
/* 4553 */       this.g2.setFont(fuente);
/* 4554 */       this.g2.drawString("FOLIO Ó REF: " + Archivo.this.jTextField2.getText().toUpperCase(), 65, 51);
/*      */       
/* 4556 */       fuente = new Font("Dialog", 0, 8);
/* 4557 */       this.g2.setFont(fuente);
/*      */       
/* 4559 */       this.g2.drawLine(25, 53, (int)this.X - 47, 53);
/* 4560 */       this.g2.drawLine(25, 56, (int)this.X - 47, 56);
/*      */       
/* 4562 */       this.g2.drawLine(25, this.YINICIA - 15, (int)this.X - 47, this.YINICIA - 15);
/* 4563 */       this.g2.drawLine(25, this.YINICIA - 18, (int)this.X - 47, this.YINICIA - 18);
/*      */       
/* 4565 */       Date fecha1 = Archivo.this.jDateChooser4.getDate();
/* 4566 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4567 */       String cadenaFecha = "";
/* 4568 */       cadenaFecha = formato.format(fecha1);
/* 4569 */       String AÑO = cadenaFecha.substring(0, 4);
/* 4570 */       String MES = cadenaFecha.substring(4, 6);
/* 4571 */       String DIA = cadenaFecha.substring(6, 8);
/* 4572 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/* 4573 */       this.g2.drawString(fechaCompleta1, (int)this.X - 100, 45);
/* 4574 */       this.g2.drawString("CLIENTE:                                                             PEDIDO:", 35, 66);
/* 4575 */       this.g2.drawString("EQUIPO:                                                              PLATAFORMA:                                                        POZO:                                                    TONELADAS: ", 35, 78);
/* 4576 */       String cliente = "GENERAL";
/* 4577 */       String equipo = "GENERAL";
/* 4578 */       String plat = "GENERAL";
/* 4579 */       String pozo = "GENERAL";
/* 4580 */       if (Archivo.this.jComboBox4.getSelectedIndex() != 0) {
/* 4581 */         cliente = String.valueOf(Archivo.this.jComboBox4.getSelectedItem());
/*      */       }
/* 4583 */       if (Archivo.this.jComboBox21.getSelectedIndex() != 0) {
/* 4584 */         equipo = String.valueOf(Archivo.this.jComboBox21.getSelectedItem());
/*      */       }
/* 4586 */       if (Archivo.this.jComboBox22.getSelectedIndex() != 0) {
/* 4587 */         plat = String.valueOf(Archivo.this.jComboBox22.getSelectedItem());
/*      */       }
/* 4589 */       if (Archivo.this.jComboBox23.getSelectedIndex() != 0) {
/* 4590 */         pozo = String.valueOf(Archivo.this.jComboBox23.getSelectedItem());
/*      */       }
/* 4592 */       fuente = new Font("Dialog", 1, 8);
/* 4593 */       this.g2.setFont(fuente);
/* 4594 */       this.g2.drawString(cliente, 85, 66);
/* 4595 */       this.g2.drawString(pozo, 430, 78);
/* 4596 */       this.g2.drawString(Archivo.this.jTextField4.getText().toUpperCase(), 275, 66);
/*      */       
/* 4598 */       fuente = new Font("Dialog", 1, 8);
/* 4599 */       this.g2.setFont(fuente);
/* 4600 */       this.g2.drawString("" + Archivo.this.TONS, 600, 78);
/* 4601 */       fuente = new Font("Dialog", 0, 8);
/* 4602 */       this.g2.setFont(fuente);
/* 4603 */       this.g2.drawString(equipo, 85, 78);
/* 4604 */       this.g2.drawString(plat, 275, 78);
/*      */       
/* 4606 */       this.g2.setColor(Color.LIGHT_GRAY);
/* 4607 */       this.g2.fillRect(18, this.YINICIA - 8, 54, 10);
/* 4608 */       this.g2.fillRect(this.PXCOL[1] - 2, this.YINICIA - 8, 40, 10);
/* 4609 */       this.g2.fillRect(this.PXCOL[2] - 2, this.YINICIA - 8, 67, 10);
/* 4610 */       this.g2.fillRect(this.PXCOL[3] - 2, this.YINICIA - 8, 62, 10);
/* 4611 */       this.g2.fillRect(this.PXCOL[4] - 2, this.YINICIA - 8, 59, 10);
/* 4612 */       this.g2.fillRect(this.PXCOL[5] - 2, this.YINICIA - 8, 29, 10);
/* 4613 */       this.g2.fillRect(this.PXCOL[6] - 2, this.YINICIA - 8, 28, 10);
/* 4614 */       this.g2.fillRect(this.PXCOL[7] - 2, this.YINICIA - 8, 29, 10);
/* 4615 */       this.g2.fillRect(this.PXCOL[8] - 2, this.YINICIA - 8, 27, 10);
/* 4616 */       this.g2.fillRect(this.PXCOL[9] - 2, this.YINICIA - 8, 53, 10);
/* 4617 */       this.g2.fillRect(this.PXCOL[10] - 2, this.YINICIA - 8, 255, 10);
/*      */       
/* 4619 */       this.g2.setColor(Color.BLACK);
/* 4620 */       fuente = new Font("Dialog", 1, 8);
/* 4621 */       this.g2.setFont(fuente);
/* 4622 */       this.g2.drawString(Archivo.this.NOMBRECOL[0], this.PXCOL[0] + 3, this.YINICIA);
/* 4623 */       this.g2.drawString(Archivo.this.NOMBRECOL[1], this.PXCOL[1] + 3, this.YINICIA);
/* 4624 */       this.g2.drawString(Archivo.this.NOMBRECOL[2], this.PXCOL[2] + 3, this.YINICIA);
/* 4625 */       this.g2.drawString(Archivo.this.NOMBRECOL[3], this.PXCOL[3] + 3, this.YINICIA);
/* 4626 */       this.g2.drawString(Archivo.this.NOMBRECOL[4], this.PXCOL[4] + 3, this.YINICIA);
/* 4627 */       this.g2.drawString(Archivo.this.NOMBRECOL[5], this.PXCOL[5] + 3, this.YINICIA);
/* 4628 */       this.g2.drawString(Archivo.this.NOMBRECOL[6], this.PXCOL[6] + 3, this.YINICIA);
/* 4629 */       this.g2.drawString(Archivo.this.NOMBRECOL[7], this.PXCOL[7] + 3, this.YINICIA);
/* 4630 */       this.g2.drawString(Archivo.this.NOMBRECOL[8], this.PXCOL[8] + 3, this.YINICIA);
/* 4631 */       this.g2.drawString(Archivo.this.NOMBRECOL[9], this.PXCOL[9] + 3, this.YINICIA);
/* 4632 */       this.g2.drawString(Archivo.this.NOMBRECOL[10], this.PXCOL[10] + 3, this.YINICIA);
/*      */       
/* 4634 */       fuente = new Font("Dialog", 0, 7);
/* 4635 */       this.g2.setFont(fuente);
/*      */       
/* 4637 */       this.g2.drawLine(18, this.YINICIA + 3, (int)this.X - 47, this.YINICIA + 3);
/* 4638 */       this.g2.drawLine(18, this.YINICIA + 5, (int)this.X - 47, this.YINICIA + 5);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 4642 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 4643 */       job.setPrintable(this);
/*      */       
/* 4645 */       PageFormat pf = job.defaultPage();
/* 4646 */       Paper papel = pf.getPaper();
/* 4647 */       papel.setSize(612.0D, 792.0D);
/* 4648 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 4649 */       pf.setPaper(papel);
/* 4650 */       pf.setOrientation(0);
/* 4651 */       job.setPrintable(new ImprimirFacturas(), pf);
/* 4652 */       job.defaultPage(pf);
/*      */       
/* 4654 */       boolean ok = job.printDialog();
/* 4655 */       if (ok)
/*      */         try {
/* 4657 */           job.print();
/* 4658 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   class ImprimirFacturas2 implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int renglonGuias;
/*      */     int[] PXCOL;
/*      */     
/*      */     ImprimirFacturas2() {
/* 4667 */       this.g2 = null;
/* 4668 */       this.Pag = 0;
/*      */       
/* 4670 */       this.linesPerPage = 50;
/* 4671 */       this.orientacion = 0;
/* 4672 */       this.X = 0.0D;
/* 4673 */       this.Y = 0.0D;
/* 4674 */       this.YINICIA = 100;
/* 4675 */       this.renglonGuias = 0;
/*      */       
/* 4677 */       this.PXCOL = new int[] { 36, 77, 120, 175, 250, 297, 329, 360, 392, 422, 478 };
/*      */     }
/*      */     private void initTextLines() {
/* 4680 */       if (this.textLines == null) {
/* 4681 */         this.Lineas = Archivo.this.LINEAS;
/* 4682 */         int numLines = this.Lineas.length;
/* 4683 */         this.textLines = new String[numLines];
/* 4684 */         for (int i = 0; i < numLines; i++) {
/* 4685 */           this.textLines[i] = this.Lineas[i];
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 4691 */       Font font = new Font("Serif", 0, 8);
/* 4692 */       FontMetrics metrics = g.getFontMetrics(font);
/* 4693 */       int lineHeight = metrics.getHeight();
/* 4694 */       if (this.pageBreaks == null) {
/* 4695 */         initTextLines();
/* 4696 */         this.orientacion = pf.getOrientation();
/* 4697 */         if (pf.getOrientation() == 1) {
/* 4698 */           this.renglonGuias = 12;
/* 4699 */           this.linesPerPage = 35;
/* 4700 */           this.X = pf.getWidth();
/* 4701 */           this.Y = pf.getHeight();
/*      */         } else {
/* 4703 */           this.renglonGuias = 17;
/* 4704 */           this.linesPerPage = 22;
/* 4705 */           this.X = pf.getWidth();
/* 4706 */           this.Y = pf.getHeight();
/*      */         } 
/* 4708 */         int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 4709 */         this.Pag = numBreaks;
/* 4710 */         this.pageBreaks = new int[numBreaks];
/* 4711 */         for (int b = 0; b < numBreaks; b++) {
/* 4712 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 4715 */       if (pageIndex > this.pageBreaks.length) {
/* 4716 */         return 1;
/*      */       }
/* 4718 */       Graphics2D g2d = (Graphics2D)g;
/* 4719 */       this.g2 = g;
/* 4720 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 4721 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 4722 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 4723 */       encabezado();
/* 4724 */       int y = this.YINICIA + 5;
/* 4725 */       int lineas = 0;
/*      */       
/* 4727 */       for (int line = start; line < end; line++) {
/* 4728 */         y += 16;
/* 4729 */         int Xempe = 35;
/* 4730 */         String valor = "";
/* 4731 */         if (line < 9) {
/* 4732 */           valor = "0" + line + 1;
/*      */         } else {
/* 4734 */           valor = "" + line + 1;
/*      */         } 
/* 4736 */         g.drawString(valor, 20, y);
/* 4737 */         this.g2.drawString(Archivo.this.REGIS[line][0], this.PXCOL[0], y);
/* 4738 */         this.g2.drawString(Archivo.this.REGIS[line][1], this.PXCOL[1], y);
/* 4739 */         this.g2.drawString(Archivo.this.REGIS[line][2], this.PXCOL[2], y);
/* 4740 */         this.g2.drawString(Archivo.this.REGIS[line][3], this.PXCOL[3], y);
/* 4741 */         this.g2.drawString(Archivo.this.REGIS[line][4], this.PXCOL[4], y);
/* 4742 */         this.g2.drawString(Archivo.this.REGIS[line][5], this.PXCOL[5], y);
/* 4743 */         this.g2.drawString(Archivo.this.REGIS[line][6], this.PXCOL[6], y);
/* 4744 */         this.g2.drawString(Archivo.this.REGIS[line][7], this.PXCOL[7], y);
/* 4745 */         this.g2.drawString(Archivo.this.REGIS[line][8], this.PXCOL[8], y);
/* 4746 */         this.g2.drawString(Archivo.this.REGIS[line][9], this.PXCOL[9], y);
/* 4747 */         this.g2.drawString(Archivo.this.REGIS[line][10], this.PXCOL[10], y);
/* 4748 */         y += 2;
/* 4749 */         lineas = y;
/* 4750 */         this.g2.drawLine(18, y, (int)this.X - 47, y);
/* 4751 */         this.g2.drawLine(this.PXCOL[1] - 3, 106, this.PXCOL[1] - 3, y);
/* 4752 */         this.g2.drawLine(this.PXCOL[2] - 3, 106, this.PXCOL[2] - 3, y);
/* 4753 */         this.g2.drawLine(this.PXCOL[3] - 3, 106, this.PXCOL[3] - 3, y);
/* 4754 */         this.g2.drawLine(this.PXCOL[4] - 3, 106, this.PXCOL[4] - 3, y);
/* 4755 */         this.g2.drawLine(this.PXCOL[5] - 3, 106, this.PXCOL[5] - 3, y);
/* 4756 */         this.g2.drawLine(this.PXCOL[6] - 3, 106, this.PXCOL[6] - 3, y);
/* 4757 */         this.g2.drawLine(this.PXCOL[7] - 3, 106, this.PXCOL[7] - 3, y);
/* 4758 */         this.g2.drawLine(this.PXCOL[8] - 3, 106, this.PXCOL[8] - 3, y);
/* 4759 */         this.g2.drawLine(this.PXCOL[9] - 3, 106, this.PXCOL[9] - 3, y);
/* 4760 */         this.g2.drawLine(this.PXCOL[10] - 3, 106, this.PXCOL[10] - 3, y);
/*      */       } 
/* 4762 */       this.g2.drawLine(34, this.YINICIA + 5, 34, lineas);
/* 4763 */       this.g2.drawLine(18, this.YINICIA + 5, 18, lineas);
/* 4764 */       this.g2.drawLine((int)this.X - 47, this.YINICIA + 5, (int)this.X - 47, lineas);
/* 4765 */       if (this.orientacion == 1) {
/* 4766 */         g.drawString("Página " + pageIndex + 1, 538, 760);
/*      */       } else {
/* 4768 */         g.drawString("Página " + pageIndex + 1, 717, 570);
/*      */       } 
/* 4770 */       Font fuente = new Font("Dialog", 0, 7);
/* 4771 */       this.g2.setFont(fuente);
/* 4772 */       if (this.Pag == pageIndex) {
/* 4773 */         this.g2.drawLine(18, lineas + 17, (int)this.X - 47, lineas + 17);
/* 4774 */         this.g2.drawLine(18, lineas + 19, (int)this.X - 47, lineas + 19);
/* 4775 */         lineas += 30;
/* 4776 */         if (Archivo.this.CANTTOTALES[6] != 0) {
/* 4777 */           fuente = new Font("Dialog", 1, 7);
/* 4778 */           this.g2.setFont(fuente);
/* 4779 */           this.g2.drawString("A de Fractura: " + Math.rint(Archivo.this.TONSRESIDUO[0] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4780 */           fuente = new Font("Dialog", 0, 7);
/* 4781 */           this.g2.setFont(fuente);
/* 4782 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[0] + "}", 110, lineas);
/* 4783 */           lineas += 15;
/*      */         } 
/* 4785 */         if (Archivo.this.CANTTOTALES[7] != 0) {
/* 4786 */           fuente = new Font("Dialog", 1, 7);
/* 4787 */           this.g2.setFont(fuente);
/* 4788 */           this.g2.drawString("A Residual: " + Math.rint(Archivo.this.TONSRESIDUO[1] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4789 */           fuente = new Font("Dialog", 0, 7);
/* 4790 */           this.g2.setFont(fuente);
/* 4791 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[1] + "}", 100, lineas);
/* 4792 */           lineas += 15;
/*      */         } 
/* 4794 */         if (Archivo.this.CANTTOTALES[8] != 0) {
/* 4795 */           fuente = new Font("Dialog", 1, 7);
/* 4796 */           this.g2.setFont(fuente);
/* 4797 */           this.g2.drawString("Lodo B Aceite: " + Math.rint(Archivo.this.TONSRESIDUO[2] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4798 */           fuente = new Font("Dialog", 0, 7);
/* 4799 */           this.g2.setFont(fuente);
/* 4800 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[2] + "}", 115, lineas);
/* 4801 */           lineas += 15;
/*      */         } 
/* 4803 */         if (Archivo.this.CANTTOTALES[9] != 0) {
/* 4804 */           fuente = new Font("Dialog", 1, 7);
/* 4805 */           this.g2.setFont(fuente);
/* 4806 */           this.g2.drawString("Lodo B Agua: " + Math.rint(Archivo.this.TONSRESIDUO[3] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4807 */           fuente = new Font("Dialog", 0, 7);
/* 4808 */           this.g2.setFont(fuente);
/* 4809 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[3] + "}", 115, lineas);
/* 4810 */           lineas += 15;
/*      */         } 
/* 4812 */         if (Archivo.this.CANTTOTALES[10] != 0) {
/* 4813 */           fuente = new Font("Dialog", 1, 7);
/* 4814 */           this.g2.setFont(fuente);
/* 4815 */           this.g2.drawString("Recorte B Aceite: " + Math.rint(Archivo.this.TONSRESIDUO[4] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4816 */           fuente = new Font("Dialog", 0, 7);
/* 4817 */           this.g2.setFont(fuente);
/* 4818 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[4] + "}", 125, lineas);
/* 4819 */           lineas += 15;
/*      */         } 
/* 4821 */         if (Archivo.this.CANTTOTALES[11] != 0) {
/* 4822 */           fuente = new Font("Dialog", 1, 7);
/* 4823 */           this.g2.setFont(fuente);
/* 4824 */           this.g2.drawString("Recorte B Agua: " + Math.rint(Archivo.this.TONSRESIDUO[5] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4825 */           fuente = new Font("Dialog", 0, 7);
/* 4826 */           this.g2.setFont(fuente);
/* 4827 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[5] + "}", 120, lineas);
/* 4828 */           lineas += 15;
/*      */         } 
/* 4830 */         if (Archivo.this.CANTTOTALES[12] != 0) {
/* 4831 */           fuente = new Font("Dialog", 1, 7);
/* 4832 */           this.g2.setFont(fuente);
/* 4833 */           this.g2.drawString("Salmuera: " + Math.rint(Archivo.this.TONSRESIDUO[6] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4834 */           fuente = new Font("Dialog", 0, 7);
/* 4835 */           this.g2.setFont(fuente);
/* 4836 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[6] + "}", 105, lineas);
/* 4837 */           lineas += 15;
/*      */         } 
/* 4839 */         if (Archivo.this.CANTTOTALES[13] != 0) {
/* 4840 */           fuente = new Font("Dialog", 1, 7);
/* 4841 */           this.g2.setFont(fuente);
/* 4842 */           this.g2.drawString("Saneamiento: " + Math.rint(Archivo.this.TONSRESIDUO[7] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4843 */           fuente = new Font("Dialog", 0, 7);
/* 4844 */           this.g2.setFont(fuente);
/* 4845 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[7] + "}", 110, lineas);
/* 4846 */           lineas += 15;
/*      */         } 
/* 4848 */         if (Archivo.this.CANTTOTALES[14] != 0) {
/* 4849 */           fuente = new Font("Dialog", 1, 7);
/* 4850 */           this.g2.setFont(fuente);
/* 4851 */           this.g2.drawString("Sedimento: " + Math.rint(Archivo.this.TONSRESIDUO[8] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4852 */           fuente = new Font("Dialog", 0, 7);
/* 4853 */           this.g2.setFont(fuente);
/* 4854 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[8] + "}", 105, lineas);
/* 4855 */           lineas += 15;
/*      */         } 
/* 4857 */         if (Archivo.this.CANTTOTALES[15] != 0) {
/* 4858 */           fuente = new Font("Dialog", 1, 7);
/* 4859 */           this.g2.setFont(fuente);
/* 4860 */           this.g2.drawString("Fletes - Varios: " + Math.rint(Archivo.this.TONSRESIDUO[9] * 1000.0D) / 1000.0D + " Tons ", 20, lineas);
/* 4861 */           fuente = new Font("Dialog", 0, 7);
/* 4862 */           this.g2.setFont(fuente);
/* 4863 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[9] + "}", 105, lineas);
/* 4864 */           lineas += 15;
/*      */         } 
/* 4866 */         if (Archivo.this.OTROSRESIDUOS != 0) {
/* 4867 */           fuente = new Font("Dialog", 1, 7);
/* 4868 */           this.g2.setFont(fuente);
/* 4869 */           this.g2.drawString("Otros: " + Math.rint(Archivo.this.TONSRESIDUO[10] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4870 */           fuente = new Font("Dialog", 0, 7);
/* 4871 */           this.g2.setFont(fuente);
/* 4872 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[10] + "}", 95, lineas);
/* 4873 */           lineas += 15;
/*      */         } 
/*      */       } 
/* 4876 */       this.g2.setColor(Color.WHITE);
/* 4877 */       this.g2.fillRect((int)this.X - 46, 12, (int)this.X - 46, lineas);
/* 4878 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 4882 */       Font fuente = new Font("Dialog", 0, 8);
/* 4883 */       this.g2.setFont(fuente);
/* 4884 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 4885 */       Image img = imagen.getImage();
/* 4886 */       this.g2.drawImage(img, 16, 6, 45, 45, null);
/* 4887 */       fuente = new Font("Times New Roman", 1, 19);
/* 4888 */       this.g2.setFont(fuente);
/* 4889 */       this.g2.drawString("GRUPO FORSIS - " + Archivo.this.base, 220, 20);
/* 4890 */       fuente = new Font("Dialog", 0, 16);
/* 4891 */       this.g2.setFont(fuente);
/* 4892 */       this.g2.drawString("REPORTE INTERNO DE PREFACTURA", 205, 39);
/*      */       
/* 4894 */       fuente = new Font("Dialog", 2, 9);
/* 4895 */       this.g2.setFont(fuente);
/* 4896 */       this.g2.drawString("FOLIO O REF: " + Archivo.this.jTextField2.getText().toUpperCase(), 65, 51);
/*      */       
/* 4898 */       fuente = new Font("Dialog", 0, 8);
/* 4899 */       this.g2.setFont(fuente);
/*      */       
/* 4901 */       this.g2.drawLine(25, 53, (int)this.X - 47, 53);
/* 4902 */       this.g2.drawLine(25, 56, (int)this.X - 47, 56);
/*      */       
/* 4904 */       this.g2.drawLine(25, this.YINICIA - 15, (int)this.X - 47, this.YINICIA - 15);
/* 4905 */       this.g2.drawLine(25, this.YINICIA - 18, (int)this.X - 47, this.YINICIA - 18);
/*      */       
/* 4907 */       Date fecha1 = Archivo.this.jDateChooser4.getDate();
/* 4908 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4909 */       String cadenaFecha = "";
/* 4910 */       cadenaFecha = formato.format(fecha1);
/* 4911 */       String AÑO = cadenaFecha.substring(0, 4);
/* 4912 */       String MES = cadenaFecha.substring(4, 6);
/* 4913 */       String DIA = cadenaFecha.substring(6, 8);
/* 4914 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/* 4915 */       this.g2.drawString(fechaCompleta1, (int)this.X - 100, 45);
/* 4916 */       this.g2.drawString("CLIENTE:", 35, 66);
/* 4917 */       this.g2.drawString("EQUIPO:                                                              PLATAFORMA:                                                        POZO:                                                    TONELADAS: ", 35, 78);
/* 4918 */       String cliente = "GENERAL";
/* 4919 */       String equipo = "GENERAL";
/* 4920 */       String plat = "GENERAL";
/* 4921 */       String pozo = "GENERAL";
/* 4922 */       if (Archivo.this.jComboBox4.getSelectedIndex() != 0) {
/* 4923 */         cliente = String.valueOf(Archivo.this.jComboBox4.getSelectedItem());
/*      */       }
/* 4925 */       if (Archivo.this.jComboBox21.getSelectedIndex() != 0) {
/* 4926 */         equipo = String.valueOf(Archivo.this.jComboBox21.getSelectedItem());
/*      */       }
/* 4928 */       if (Archivo.this.jComboBox22.getSelectedIndex() != 0) {
/* 4929 */         plat = String.valueOf(Archivo.this.jComboBox22.getSelectedItem());
/*      */       }
/* 4931 */       if (Archivo.this.jComboBox23.getSelectedIndex() != 0) {
/* 4932 */         pozo = String.valueOf(Archivo.this.jComboBox23.getSelectedItem());
/*      */       }
/* 4934 */       fuente = new Font("Dialog", 1, 8);
/* 4935 */       this.g2.setFont(fuente);
/* 4936 */       this.g2.drawString(cliente, 85, 66);
/* 4937 */       this.g2.drawString(pozo, 430, 78);
/*      */       
/* 4939 */       fuente = new Font("Dialog", 1, 8);
/* 4940 */       this.g2.setFont(fuente);
/* 4941 */       this.g2.drawString("" + Archivo.this.TONS, 600, 78);
/* 4942 */       fuente = new Font("Dialog", 0, 8);
/* 4943 */       this.g2.setFont(fuente);
/* 4944 */       this.g2.drawString(equipo, 85, 78);
/* 4945 */       this.g2.drawString(plat, 275, 78);
/*      */       
/* 4947 */       this.g2.setColor(Color.LIGHT_GRAY);
/* 4948 */       this.g2.fillRect(18, this.YINICIA - 8, 54, 10);
/* 4949 */       this.g2.fillRect(this.PXCOL[1] - 2, this.YINICIA - 8, 40, 10);
/* 4950 */       this.g2.fillRect(this.PXCOL[2] - 2, this.YINICIA - 8, 52, 10);
/* 4951 */       this.g2.fillRect(this.PXCOL[3] - 2, this.YINICIA - 8, 71, 10);
/* 4952 */       this.g2.fillRect(this.PXCOL[4] - 2, this.YINICIA - 8, 43, 10);
/* 4953 */       this.g2.fillRect(this.PXCOL[5] - 2, this.YINICIA - 8, 29, 10);
/* 4954 */       this.g2.fillRect(this.PXCOL[6] - 2, this.YINICIA - 8, 28, 10);
/* 4955 */       this.g2.fillRect(this.PXCOL[7] - 2, this.YINICIA - 8, 29, 10);
/* 4956 */       this.g2.fillRect(this.PXCOL[8] - 2, this.YINICIA - 8, 27, 10);
/* 4957 */       this.g2.fillRect(this.PXCOL[9] - 2, this.YINICIA - 8, 53, 10);
/* 4958 */       this.g2.fillRect(this.PXCOL[10] - 2, this.YINICIA - 8, 275, 10);
/*      */       
/* 4960 */       this.g2.setColor(Color.BLACK);
/* 4961 */       fuente = new Font("Dialog", 1, 8);
/* 4962 */       this.g2.setFont(fuente);
/* 4963 */       this.g2.drawString(Archivo.this.NOMBRECOL[0], this.PXCOL[0] + 3, this.YINICIA);
/* 4964 */       this.g2.drawString(Archivo.this.NOMBRECOL[1], this.PXCOL[1] + 3, this.YINICIA);
/* 4965 */       this.g2.drawString(Archivo.this.NOMBRECOL[2], this.PXCOL[2] + 3, this.YINICIA);
/* 4966 */       this.g2.drawString(Archivo.this.NOMBRECOL[3], this.PXCOL[3] + 3, this.YINICIA);
/* 4967 */       this.g2.drawString(Archivo.this.NOMBRECOL[4], this.PXCOL[4] + 3, this.YINICIA);
/* 4968 */       this.g2.drawString(Archivo.this.NOMBRECOL[5], this.PXCOL[5] + 3, this.YINICIA);
/* 4969 */       this.g2.drawString(Archivo.this.NOMBRECOL[6], this.PXCOL[6] + 3, this.YINICIA);
/* 4970 */       this.g2.drawString(Archivo.this.NOMBRECOL[7], this.PXCOL[7] + 3, this.YINICIA);
/* 4971 */       this.g2.drawString(Archivo.this.NOMBRECOL[8], this.PXCOL[8] + 3, this.YINICIA);
/* 4972 */       this.g2.drawString(Archivo.this.NOMBRECOL[9], this.PXCOL[9] + 3, this.YINICIA);
/* 4973 */       this.g2.drawString(Archivo.this.NOMBRECOL[10], this.PXCOL[10] + 3, this.YINICIA);
/*      */       
/* 4975 */       fuente = new Font("Dialog", 0, 7);
/* 4976 */       this.g2.setFont(fuente);
/*      */       
/* 4978 */       this.g2.drawLine(18, this.YINICIA + 3, (int)this.X - 47, this.YINICIA + 3);
/* 4979 */       this.g2.drawLine(18, this.YINICIA + 5, (int)this.X - 47, this.YINICIA + 5);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 4983 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 4984 */       job.setPrintable(this);
/*      */       
/* 4986 */       PageFormat pf = job.defaultPage();
/* 4987 */       Paper papel = pf.getPaper();
/* 4988 */       papel.setSize(612.0D, 792.0D);
/* 4989 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 4990 */       pf.setPaper(papel);
/* 4991 */       pf.setOrientation(0);
/* 4992 */       job.setPrintable(new ImprimirFacturas2(), pf);
/* 4993 */       job.defaultPage(pf);
/*      */       
/* 4995 */       boolean ok = job.printDialog();
/* 4996 */       if (ok)
/*      */         try {
/* 4998 */           job.print();
/* 4999 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirFacturas3 implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int renglonGuias;
/*      */     int[] PXCOL;
/*      */     
/*      */     public ImprimirFacturas3() {
/* 5008 */       this.g2 = null;
/* 5009 */       this.Pag = 0;
/*      */       
/* 5011 */       this.linesPerPage = 50;
/* 5012 */       this.orientacion = 0;
/* 5013 */       this.X = 0.0D;
/* 5014 */       this.Y = 0.0D;
/* 5015 */       this.YINICIA = 100;
/* 5016 */       this.renglonGuias = 0;
/*      */       
/* 5018 */       this.PXCOL = new int[] { 36, 77, 120, 168, 230, 297, 329, 360, 392, 422, 478 };
/*      */     } private void initTextLines() {
/* 5020 */       if (this.textLines == null) {
/* 5021 */         this.Lineas = Archivo.this.LINEAS;
/* 5022 */         int numLines = this.Lineas.length;
/* 5023 */         this.textLines = new String[numLines];
/* 5024 */         for (int i = 0; i < numLines; i++) {
/* 5025 */           this.textLines[i] = this.Lineas[i];
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 5031 */       Font font = new Font("Serif", 0, 8);
/* 5032 */       FontMetrics metrics = g.getFontMetrics(font);
/* 5033 */       int lineHeight = metrics.getHeight();
/* 5034 */       if (this.pageBreaks == null) {
/* 5035 */         initTextLines();
/* 5036 */         this.orientacion = pf.getOrientation();
/* 5037 */         if (pf.getOrientation() == 1) {
/* 5038 */           this.renglonGuias = 12;
/* 5039 */           this.linesPerPage = 35;
/* 5040 */           this.X = pf.getWidth();
/* 5041 */           this.Y = pf.getHeight();
/*      */         } else {
/* 5043 */           this.renglonGuias = 17;
/* 5044 */           this.linesPerPage = 22;
/* 5045 */           this.X = pf.getWidth();
/* 5046 */           this.Y = pf.getHeight();
/*      */         } 
/* 5048 */         int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 5049 */         this.Pag = numBreaks;
/* 5050 */         this.pageBreaks = new int[numBreaks];
/* 5051 */         for (int b = 0; b < numBreaks; b++) {
/* 5052 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 5055 */       if (pageIndex > this.pageBreaks.length) {
/* 5056 */         return 1;
/*      */       }
/* 5058 */       Graphics2D g2d = (Graphics2D)g;
/* 5059 */       this.g2 = g;
/* 5060 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 5061 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 5062 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 5063 */       encabezado();
/* 5064 */       int y = this.YINICIA + 5;
/* 5065 */       int lineas = 0;
/*      */       
/* 5067 */       for (int line = start; line < end; line++) {
/* 5068 */         y += 16;
/* 5069 */         int Xempe = 35;
/* 5070 */         String valor = "";
/* 5071 */         if (line < 9) {
/* 5072 */           valor = "0" + line + 1;
/*      */         } else {
/* 5074 */           valor = "" + line + 1;
/*      */         } 
/* 5076 */         g.drawString(valor, 20, y);
/* 5077 */         this.g2.drawString(Archivo.this.REGIS[line][0], this.PXCOL[0], y);
/* 5078 */         this.g2.drawString(Archivo.this.REGIS[line][1], this.PXCOL[1], y);
/* 5079 */         this.g2.drawString(Archivo.this.REGIS[line][2], this.PXCOL[2], y);
/* 5080 */         this.g2.drawString(Archivo.this.REGIS[line][3], this.PXCOL[3], y);
/* 5081 */         this.g2.drawString(Archivo.this.REGIS[line][4], this.PXCOL[4], y);
/* 5082 */         this.g2.drawString(Archivo.this.REGIS[line][5], this.PXCOL[5], y);
/* 5083 */         this.g2.drawString(Archivo.this.REGIS[line][6], this.PXCOL[6], y);
/* 5084 */         this.g2.drawString(Archivo.this.REGIS[line][7], this.PXCOL[7], y);
/* 5085 */         this.g2.drawString(Archivo.this.REGIS[line][8], this.PXCOL[8], y);
/* 5086 */         this.g2.drawString(Archivo.this.REGIS[line][9], this.PXCOL[9], y);
/* 5087 */         this.g2.drawString(Archivo.this.REGIS[line][10], this.PXCOL[10], y);
/* 5088 */         y += 2;
/* 5089 */         lineas = y;
/* 5090 */         this.g2.drawLine(18, y, (int)this.X - 47, y);
/* 5091 */         this.g2.drawLine(this.PXCOL[1] - 3, 106, this.PXCOL[1] - 3, y);
/* 5092 */         this.g2.drawLine(this.PXCOL[2] - 3, 106, this.PXCOL[2] - 3, y);
/* 5093 */         this.g2.drawLine(this.PXCOL[3] - 3, 106, this.PXCOL[3] - 3, y);
/* 5094 */         this.g2.drawLine(this.PXCOL[4] - 3, 106, this.PXCOL[4] - 3, y);
/* 5095 */         this.g2.drawLine(this.PXCOL[5] - 3, 106, this.PXCOL[5] - 3, y);
/* 5096 */         this.g2.drawLine(this.PXCOL[6] - 3, 106, this.PXCOL[6] - 3, y);
/* 5097 */         this.g2.drawLine(this.PXCOL[7] - 3, 106, this.PXCOL[7] - 3, y);
/* 5098 */         this.g2.drawLine(this.PXCOL[8] - 3, 106, this.PXCOL[8] - 3, y);
/* 5099 */         this.g2.drawLine(this.PXCOL[9] - 3, 106, this.PXCOL[9] - 3, y);
/* 5100 */         this.g2.drawLine(this.PXCOL[10] - 3, 106, this.PXCOL[10] - 3, y);
/*      */       } 
/* 5102 */       this.g2.drawLine(34, this.YINICIA + 5, 34, lineas);
/* 5103 */       this.g2.drawLine(18, this.YINICIA + 5, 18, lineas);
/* 5104 */       this.g2.drawLine((int)this.X - 47, this.YINICIA + 5, (int)this.X - 47, lineas);
/* 5105 */       if (this.orientacion == 1) {
/* 5106 */         g.drawString("Página " + pageIndex + 1, 538, 760);
/*      */       } else {
/* 5108 */         g.drawString("Página " + pageIndex + 1, 717, 570);
/*      */       } 
/* 5110 */       Font fuente = new Font("Dialog", 0, 7);
/* 5111 */       this.g2.setFont(fuente);
/* 5112 */       if (this.Pag == pageIndex) {
/* 5113 */         this.g2.drawLine(18, lineas + 17, (int)this.X - 47, lineas + 17);
/* 5114 */         this.g2.drawLine(18, lineas + 19, (int)this.X - 47, lineas + 19);
/* 5115 */         lineas += 30;
/* 5116 */         if (Archivo.this.CANTTOTALES[6] != 0) {
/* 5117 */           fuente = new Font("Dialog", 1, 7);
/* 5118 */           this.g2.setFont(fuente);
/* 5119 */           this.g2.drawString("A de Fractura: " + Math.rint(Archivo.this.TONSRESIDUO[0] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5120 */           fuente = new Font("Dialog", 0, 7);
/* 5121 */           this.g2.setFont(fuente);
/* 5122 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[0] + "}", 110, lineas);
/* 5123 */           lineas += 15;
/*      */         } 
/* 5125 */         if (Archivo.this.CANTTOTALES[7] != 0) {
/* 5126 */           fuente = new Font("Dialog", 1, 7);
/* 5127 */           this.g2.setFont(fuente);
/* 5128 */           this.g2.drawString("A Residual: " + Math.rint(Archivo.this.TONSRESIDUO[1] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5129 */           fuente = new Font("Dialog", 0, 7);
/* 5130 */           this.g2.setFont(fuente);
/* 5131 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[1] + "}", 100, lineas);
/* 5132 */           lineas += 15;
/*      */         } 
/* 5134 */         if (Archivo.this.CANTTOTALES[8] != 0) {
/* 5135 */           fuente = new Font("Dialog", 1, 7);
/* 5136 */           this.g2.setFont(fuente);
/* 5137 */           this.g2.drawString("Lodo B Aceite: " + Math.rint(Archivo.this.TONSRESIDUO[2] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5138 */           fuente = new Font("Dialog", 0, 7);
/* 5139 */           this.g2.setFont(fuente);
/* 5140 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[2] + "}", 115, lineas);
/* 5141 */           lineas += 15;
/*      */         } 
/* 5143 */         if (Archivo.this.CANTTOTALES[9] != 0) {
/* 5144 */           fuente = new Font("Dialog", 1, 7);
/* 5145 */           this.g2.setFont(fuente);
/* 5146 */           this.g2.drawString("Lodo B Agua: " + Math.rint(Archivo.this.TONSRESIDUO[3] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5147 */           fuente = new Font("Dialog", 0, 7);
/* 5148 */           this.g2.setFont(fuente);
/* 5149 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[3] + "}", 115, lineas);
/* 5150 */           lineas += 15;
/*      */         } 
/* 5152 */         if (Archivo.this.CANTTOTALES[10] != 0) {
/* 5153 */           fuente = new Font("Dialog", 1, 7);
/* 5154 */           this.g2.setFont(fuente);
/* 5155 */           this.g2.drawString("Recorte B Aceite: " + Math.rint(Archivo.this.TONSRESIDUO[4] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5156 */           fuente = new Font("Dialog", 0, 7);
/* 5157 */           this.g2.setFont(fuente);
/* 5158 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[4] + "}", 125, lineas);
/* 5159 */           lineas += 15;
/*      */         } 
/* 5161 */         if (Archivo.this.CANTTOTALES[11] != 0) {
/* 5162 */           fuente = new Font("Dialog", 1, 7);
/* 5163 */           this.g2.setFont(fuente);
/* 5164 */           this.g2.drawString("Recorte B Agua: " + Math.rint(Archivo.this.TONSRESIDUO[5] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5165 */           fuente = new Font("Dialog", 0, 7);
/* 5166 */           this.g2.setFont(fuente);
/* 5167 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[5] + "}", 120, lineas);
/* 5168 */           lineas += 15;
/*      */         } 
/* 5170 */         if (Archivo.this.CANTTOTALES[12] != 0) {
/* 5171 */           fuente = new Font("Dialog", 1, 7);
/* 5172 */           this.g2.setFont(fuente);
/* 5173 */           this.g2.drawString("Salmuera: " + Math.rint(Archivo.this.TONSRESIDUO[6] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5174 */           fuente = new Font("Dialog", 0, 7);
/* 5175 */           this.g2.setFont(fuente);
/* 5176 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[6] + "}", 105, lineas);
/* 5177 */           lineas += 15;
/*      */         } 
/* 5179 */         if (Archivo.this.CANTTOTALES[13] != 0) {
/* 5180 */           fuente = new Font("Dialog", 1, 7);
/* 5181 */           this.g2.setFont(fuente);
/* 5182 */           this.g2.drawString("Saneamiento: " + Math.rint(Archivo.this.TONSRESIDUO[7] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5183 */           fuente = new Font("Dialog", 0, 7);
/* 5184 */           this.g2.setFont(fuente);
/* 5185 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[7] + "}", 110, lineas);
/* 5186 */           lineas += 15;
/*      */         } 
/* 5188 */         if (Archivo.this.CANTTOTALES[14] != 0) {
/* 5189 */           fuente = new Font("Dialog", 1, 7);
/* 5190 */           this.g2.setFont(fuente);
/* 5191 */           this.g2.drawString("Sedimento: " + Math.rint(Archivo.this.TONSRESIDUO[8] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5192 */           fuente = new Font("Dialog", 0, 7);
/* 5193 */           this.g2.setFont(fuente);
/* 5194 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[8] + "}", 105, lineas);
/* 5195 */           lineas += 15;
/*      */         } 
/* 5197 */         if (Archivo.this.CANTTOTALES[15] != 0) {
/* 5198 */           fuente = new Font("Dialog", 1, 7);
/* 5199 */           this.g2.setFont(fuente);
/* 5200 */           this.g2.drawString("Fletes - Varios: " + Math.rint(Archivo.this.TONSRESIDUO[9] * 1000.0D) / 1000.0D + " Tons ", 20, lineas);
/* 5201 */           fuente = new Font("Dialog", 0, 7);
/* 5202 */           this.g2.setFont(fuente);
/* 5203 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[9] + "}", 105, lineas);
/* 5204 */           lineas += 15;
/*      */         } 
/* 5206 */         if (Archivo.this.OTROSRESIDUOS != 0) {
/* 5207 */           fuente = new Font("Dialog", 1, 7);
/* 5208 */           this.g2.setFont(fuente);
/* 5209 */           this.g2.drawString("Otros: " + Math.rint(Archivo.this.TONSRESIDUO[10] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5210 */           fuente = new Font("Dialog", 0, 7);
/* 5211 */           this.g2.setFont(fuente);
/* 5212 */           this.g2.drawString("Guías {" + Archivo.this.GUIASAMPARADAS[10] + "}", 95, lineas);
/* 5213 */           lineas += 15;
/*      */         } 
/*      */       } 
/* 5216 */       this.g2.setColor(Color.WHITE);
/* 5217 */       this.g2.fillRect((int)this.X - 46, 12, (int)this.X - 46, lineas);
/* 5218 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 5222 */       Font fuente = new Font("Dialog", 0, 8);
/* 5223 */       this.g2.setFont(fuente);
/* 5224 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 5225 */       Image img = imagen.getImage();
/* 5226 */       this.g2.drawImage(img, 16, 6, 45, 45, null);
/* 5227 */       fuente = new Font("Times New Roman", 1, 19);
/* 5228 */       this.g2.setFont(fuente);
/* 5229 */       this.g2.drawString("GRUPO FORSIS - " + Archivo.this.base, 230, 20);
/* 5230 */       fuente = new Font("Dialog", 0, 16);
/* 5231 */       this.g2.setFont(fuente);
/* 5232 */       this.g2.drawString("REPORTE INTERNO DE PREFACTURA", 215, 39);
/*      */       
/* 5234 */       fuente = new Font("Dialog", 2, 9);
/* 5235 */       this.g2.setFont(fuente);
/* 5236 */       this.g2.drawString("FOLIO Ó REF: " + Archivo.this.jTextField2.getText().toUpperCase(), 65, 51);
/*      */       
/* 5238 */       fuente = new Font("Dialog", 0, 8);
/* 5239 */       this.g2.setFont(fuente);
/*      */       
/* 5241 */       this.g2.drawLine(25, 53, (int)this.X - 47, 53);
/* 5242 */       this.g2.drawLine(25, 56, (int)this.X - 47, 56);
/*      */       
/* 5244 */       this.g2.drawLine(25, this.YINICIA - 15, (int)this.X - 47, this.YINICIA - 15);
/* 5245 */       this.g2.drawLine(25, this.YINICIA - 18, (int)this.X - 47, this.YINICIA - 18);
/*      */       
/* 5247 */       Date fecha1 = Archivo.this.jDateChooser4.getDate();
/* 5248 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5249 */       String cadenaFecha = "";
/* 5250 */       cadenaFecha = formato.format(fecha1);
/* 5251 */       String AÑO = cadenaFecha.substring(0, 4);
/* 5252 */       String MES = cadenaFecha.substring(4, 6);
/* 5253 */       String DIA = cadenaFecha.substring(6, 8);
/* 5254 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/* 5255 */       this.g2.drawString(fechaCompleta1, (int)this.X - 100, 45);
/* 5256 */       this.g2.drawString("CLIENTE:", 35, 66);
/* 5257 */       this.g2.drawString("EQUIPO:                                                              PLATAFORMA:                                                        POZO:                                                    TONELADAS: ", 35, 78);
/* 5258 */       String cliente = "GENERAL";
/* 5259 */       String equipo = "GENERAL";
/* 5260 */       String plat = "GENERAL";
/* 5261 */       String pozo = "GENERAL";
/* 5262 */       if (Archivo.this.jComboBox4.getSelectedIndex() != 0) {
/* 5263 */         cliente = String.valueOf(Archivo.this.jComboBox4.getSelectedItem());
/*      */       }
/* 5265 */       if (Archivo.this.jComboBox21.getSelectedIndex() != 0) {
/* 5266 */         equipo = String.valueOf(Archivo.this.jComboBox21.getSelectedItem());
/*      */       }
/* 5268 */       if (Archivo.this.jComboBox22.getSelectedIndex() != 0) {
/* 5269 */         plat = String.valueOf(Archivo.this.jComboBox22.getSelectedItem());
/*      */       }
/* 5271 */       if (Archivo.this.jComboBox23.getSelectedIndex() != 0) {
/* 5272 */         pozo = String.valueOf(Archivo.this.jComboBox23.getSelectedItem());
/*      */       }
/* 5274 */       fuente = new Font("Dialog", 1, 8);
/* 5275 */       this.g2.setFont(fuente);
/* 5276 */       this.g2.drawString(cliente, 85, 66);
/* 5277 */       this.g2.drawString(pozo, 430, 78);
/*      */       
/* 5279 */       fuente = new Font("Dialog", 1, 8);
/* 5280 */       this.g2.setFont(fuente);
/* 5281 */       this.g2.drawString("" + Archivo.this.TONS, 600, 78);
/* 5282 */       fuente = new Font("Dialog", 0, 8);
/* 5283 */       this.g2.setFont(fuente);
/* 5284 */       this.g2.drawString(equipo, 85, 78);
/* 5285 */       this.g2.drawString(plat, 275, 78);
/*      */       
/* 5287 */       this.g2.setColor(Color.LIGHT_GRAY);
/* 5288 */       this.g2.fillRect(18, this.YINICIA - 8, 54, 10);
/* 5289 */       this.g2.fillRect(this.PXCOL[1] - 2, this.YINICIA - 8, 40, 10);
/* 5290 */       this.g2.fillRect(this.PXCOL[2] - 2, this.YINICIA - 8, 45, 10);
/* 5291 */       this.g2.fillRect(this.PXCOL[3] - 2, this.YINICIA - 8, 59, 10);
/* 5292 */       this.g2.fillRect(this.PXCOL[4] - 2, this.YINICIA - 8, 64, 10);
/* 5293 */       this.g2.fillRect(this.PXCOL[5] - 2, this.YINICIA - 8, 29, 10);
/* 5294 */       this.g2.fillRect(this.PXCOL[6] - 2, this.YINICIA - 8, 28, 10);
/* 5295 */       this.g2.fillRect(this.PXCOL[7] - 2, this.YINICIA - 8, 29, 10);
/* 5296 */       this.g2.fillRect(this.PXCOL[8] - 2, this.YINICIA - 8, 27, 10);
/* 5297 */       this.g2.fillRect(this.PXCOL[9] - 2, this.YINICIA - 8, 53, 10);
/* 5298 */       this.g2.fillRect(this.PXCOL[10] - 2, this.YINICIA - 8, 275, 10);
/*      */       
/* 5300 */       this.g2.setColor(Color.BLACK);
/* 5301 */       fuente = new Font("Dialog", 1, 8);
/* 5302 */       this.g2.setFont(fuente);
/* 5303 */       this.g2.drawString(Archivo.this.NOMBRECOL[0], this.PXCOL[0] + 3, this.YINICIA);
/* 5304 */       this.g2.drawString(Archivo.this.NOMBRECOL[1], this.PXCOL[1] + 3, this.YINICIA);
/* 5305 */       this.g2.drawString(Archivo.this.NOMBRECOL[2], this.PXCOL[2] + 3, this.YINICIA);
/* 5306 */       this.g2.drawString(Archivo.this.NOMBRECOL[3], this.PXCOL[3] + 3, this.YINICIA);
/* 5307 */       this.g2.drawString(Archivo.this.NOMBRECOL[4], this.PXCOL[4] + 3, this.YINICIA);
/* 5308 */       this.g2.drawString(Archivo.this.NOMBRECOL[5], this.PXCOL[5] + 3, this.YINICIA);
/* 5309 */       this.g2.drawString(Archivo.this.NOMBRECOL[6], this.PXCOL[6] + 3, this.YINICIA);
/* 5310 */       this.g2.drawString(Archivo.this.NOMBRECOL[7], this.PXCOL[7] + 3, this.YINICIA);
/* 5311 */       this.g2.drawString(Archivo.this.NOMBRECOL[8], this.PXCOL[8] + 3, this.YINICIA);
/* 5312 */       this.g2.drawString(Archivo.this.NOMBRECOL[9], this.PXCOL[9] + 3, this.YINICIA);
/* 5313 */       this.g2.drawString(Archivo.this.NOMBRECOL[10], this.PXCOL[10] + 3, this.YINICIA);
/*      */       
/* 5315 */       fuente = new Font("Dialog", 0, 7);
/* 5316 */       this.g2.setFont(fuente);
/*      */       
/* 5318 */       this.g2.drawLine(18, this.YINICIA + 3, (int)this.X - 47, this.YINICIA + 3);
/* 5319 */       this.g2.drawLine(18, this.YINICIA + 5, (int)this.X - 47, this.YINICIA + 5);
/*      */     }
/*      */     public void recibeDatos() {
/* 5322 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 5323 */       job.setPrintable(this);
/*      */       
/* 5325 */       PageFormat pf = job.defaultPage();
/* 5326 */       Paper papel = pf.getPaper();
/* 5327 */       papel.setSize(612.0D, 792.0D);
/* 5328 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 5329 */       pf.setPaper(papel);
/* 5330 */       pf.setOrientation(0);
/* 5331 */       job.setPrintable(new ImprimirFacturas3(), pf);
/* 5332 */       job.defaultPage(pf);
/*      */       
/* 5334 */       boolean ok = job.printDialog();
/* 5335 */       if (ok)
/*      */         try {
/* 5337 */           job.print();
/* 5338 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer
/*      */   {
/* 5345 */     int otro = -1;
/* 5346 */     String[] indices = new String[0];
/* 5347 */     String[] indices2 = new String[0];
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5349 */       setEnabled((table == null || table.isEnabled()));
/* 5350 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 5351 */       if (comparar(comp)) {
/* 5352 */         setBackground(Color.red);
/* 5353 */         setForeground(Color.white);
/*      */       }
/* 5355 */       else if (comparar2(comp)) {
/* 5356 */         setBackground(new Color(102, 153, 255));
/* 5357 */         setForeground(Color.BLUE);
/*      */       } else {
/*      */         
/* 5360 */         setBackground((Color)null);
/* 5361 */         setForeground(Color.BLACK);
/*      */       } 
/* 5363 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5364 */       return this;
/*      */     }
/*      */     public void pasarInd(String[] ind) {
/* 5367 */       this.indices = ind;
/*      */     }
/*      */     public void pasarInd2(String[] ind) {
/* 5370 */       this.indices2 = ind;
/*      */     }
/*      */     public boolean comparar(String reg) {
/* 5373 */       for (int i = 0; i < this.indices.length; i++) {
/* 5374 */         if (this.indices[i].equals(reg)) {
/* 5375 */           return true;
/*      */         }
/*      */       } 
/* 5378 */       return false;
/*      */     }
/*      */     public boolean comparar2(String reg) {
/* 5381 */       for (int i = 0; i < this.indices2.length; i++) {
/* 5382 */         if (this.indices2[i].equals(reg)) {
/* 5383 */           return true;
/*      */         }
/*      */       } 
/* 5386 */       return false;
/*      */     } }
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices;
/*      */     
/*      */     public CeldaRender2() {
/* 5391 */       this.otro = -1;
/* 5392 */       this.indices = new String[0];
/*      */     } public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5394 */       setEnabled((table == null || table.isEnabled()));
/* 5395 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 5396 */       if (comparar(comp)) {
/* 5397 */         setBackground(new Color(102, 153, 255));
/* 5398 */         setForeground(Color.BLUE);
/*      */       } else {
/*      */         
/* 5401 */         setBackground((Color)null);
/* 5402 */         setForeground(Color.BLACK);
/*      */       } 
/* 5404 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5405 */       return this;
/*      */     }
/*      */     public void pasarInd(String[] ind) {
/* 5408 */       this.indices = ind;
/*      */     }
/*      */     public boolean comparar(String reg) {
/* 5411 */       for (int i = 0; i < this.indices.length; i++) {
/* 5412 */         if (this.indices[i].equals(reg)) {
/* 5413 */           return true;
/*      */         }
/*      */       } 
/* 5416 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   class AddGuias {
/* 5421 */     String[] GUIAS = new String[1000];
/* 5422 */     int indice = 0;
/*      */     public AddGuias() {
/* 5424 */       for (int i = 0; i < this.GUIAS.length; i++)
/* 5425 */         this.GUIAS[i] = ""; 
/*      */     }
/*      */     
/*      */     public void agregarGuia(String pGuia) {
/* 5429 */       this.GUIAS[this.indice] = pGuia;
/* 5430 */       this.indice++;
/*      */     }
/*      */     public int dameInd() {
/* 5433 */       return this.indice;
/*      */     }
/*      */     public String dameGuia(int numGuia) {
/* 5436 */       return this.GUIAS[numGuia];
/*      */     }
/*      */   }
/*      */   
/*      */   public class Presionado implements Runnable {
/*      */     Thread t;
/* 5442 */     int cont = 0;
/*      */     public Presionado() {
/* 5444 */       this.t = new Thread(this);
/* 5445 */       this.t.start();
/*      */     }
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 5451 */         Thread.currentThread(); Thread.sleep(1000L);
/* 5452 */         detener();
/*      */       }
/* 5454 */       catch (InterruptedException interruptedException) {}
/*      */     }
/*      */     
/*      */     public void detener() {
/* 5458 */       Archivo.this.consultarGuias();
/* 5459 */       this.t.stop();
/*      */     }
/*      */     public void detenerFuera() {
/* 5462 */       this.t.stop();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Archivo.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */