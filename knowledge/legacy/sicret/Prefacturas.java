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
/*      */ public class Prefacturas extends JPanel {
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
/*      */   public Prefacturas(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
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
/*  328 */             Prefacturas.this.jFrame1WindowClosing(evt);
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
/*  371 */             Prefacturas.this.jTable1MouseClicked(evt);
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
/*  416 */             Prefacturas.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  420 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Search.png")));
/*  421 */     this.jButton1.setMnemonic('B');
/*  422 */     this.jButton1.setText("Buscar Guías");
/*  423 */     this.jButton1.setToolTipText("Buscar Guías (Alt+B)");
/*  424 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  426 */             Prefacturas.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  430 */     this.jButton2.setMnemonic('Q');
/*  431 */     this.jButton2.setText("Quitar");
/*  432 */     this.jButton2.setToolTipText("Quitar Viajes (Alt+Q)");
/*  433 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  435 */             Prefacturas.this.jButton2ActionPerformed(evt);
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
/*  448 */             Prefacturas.this.jComboBox21ActionPerformed(evt);
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
/*  459 */             Prefacturas.this.jComboBox22ActionPerformed(evt);
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
/*  471 */             Prefacturas.this.jComboBox23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  475 */     this.jButton8.setMnemonic('C');
/*  476 */     this.jButton8.setText("Cerrar");
/*  477 */     this.jButton8.setToolTipText("Cerrar Ventana (alt+C)");
/*  478 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  480 */             Prefacturas.this.jButton8ActionPerformed(evt);
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
/*  496 */             Prefacturas.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  500 */     this.jButton14.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/*  501 */     this.jButton14.setMnemonic('G');
/*  502 */     this.jButton14.setText("Guardar");
/*  503 */     this.jButton14.setToolTipText("Guarda reporte (Alt+G)");
/*  504 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  506 */             Prefacturas.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  510 */     this.jButton17.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Comment.png")));
/*  511 */     this.jButton17.setMnemonic('O');
/*  512 */     this.jButton17.setText("Comentario");
/*  513 */     this.jButton17.setToolTipText("Organizar Comentario (Alt+O)");
/*  514 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  516 */             Prefacturas.this.jButton17ActionPerformed(evt);
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
/*  534 */             Prefacturas.this.jCheckBox1ActionPerformed(evt);
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
/*  699 */             Prefacturas.this.jButton13ActionPerformed(evt);
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
/*  727 */             Prefacturas.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/*  730 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  732 */             Prefacturas.this.jTextField3KeyReleased(evt);
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
/*  745 */             Prefacturas.this.jComboBox20ActionPerformed(evt);
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
/*  758 */             Prefacturas.this.jComboBox10ActionPerformed(evt);
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
/*  770 */             Prefacturas.this.jComboBox5ActionPerformed(evt);
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
/*  783 */             Prefacturas.this.jComboBox6ActionPerformed(evt);
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
/*  795 */             Prefacturas.this.jComboBox7ActionPerformed(evt);
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
/*  807 */             Prefacturas.this.jComboBox8ActionPerformed(evt);
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
/*  819 */             Prefacturas.this.jComboBox9ActionPerformed(evt);
/*      */           }
/*      */         });
/*  822 */     this.jPanel19.add(this.jComboBox9);
/*      */     
/*  824 */     this.jLabel18.setText("Eco");
/*  825 */     this.jPanel19.add(this.jLabel18);
/*      */     
/*  827 */     this.jTextField7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  829 */             Prefacturas.this.jTextField7ActionPerformed(evt);
/*      */           }
/*      */         });
/*  832 */     this.jTextField7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  834 */             Prefacturas.this.jTextField7KeyReleased(evt);
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
/*  853 */             Prefacturas.this.jTable3MouseClicked(evt);
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
/*  869 */             Prefacturas.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  873 */     this.jButton6.setMnemonic('T');
/*  874 */     this.jButton6.setText("Agregar Todos");
/*  875 */     this.jButton6.setToolTipText("Agregar Todas las Guías (Alt+T)");
/*  876 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  878 */             Prefacturas.this.jButton6ActionPerformed(evt);
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
/*  944 */             Prefacturas.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  948 */     this.jButton19.setMnemonic('A');
/*  949 */     this.jButton19.setText("Aceptar");
/*  950 */     this.jButton19.setToolTipText("Aceptar (Alt+A)");
/*  951 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  953 */             Prefacturas.this.jButton19ActionPerformed(evt);
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
/* 1006 */             Prefacturas.this.jMenuItem1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1009 */     this.jPopupMenu1.add(this.jMenuItem1);
/*      */     
/* 1011 */     this.jMenuItem2.setText("Quitar Columna RSP");
/* 1012 */     this.jMenuItem2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1014 */             Prefacturas.this.jMenuItem2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1017 */     this.jPopupMenu1.add(this.jMenuItem2);
/* 1018 */     this.jPopupMenu1.add(this.jSeparator7);
/*      */     
/* 1020 */     this.jMenuItem3.setText("Imprimir");
/* 1021 */     this.jMenuItem3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1023 */             Prefacturas.this.jMenuItem3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1026 */     this.jPopupMenu1.add(this.jMenuItem3);
/*      */     
/* 1028 */     this.jMenuItem4.setText("Guardar Reporte");
/* 1029 */     this.jMenuItem4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1031 */             Prefacturas.this.jMenuItem4ActionPerformed(evt);
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
/* 1051 */             Prefacturas.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1055 */     this.jButton21.setText("WEATHERFORD");
/* 1056 */     this.jButton21.setToolTipText("Crea un reporte tipo WTF con la columna RSP");
/* 1057 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1059 */             Prefacturas.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1063 */     this.jButton22.setText("GENERAL");
/* 1064 */     this.jButton22.setToolTipText("Crea reportes generales con la columna especificando el cliente.");
/* 1065 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1067 */             Prefacturas.this.jButton22ActionPerformed(evt);
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
/* 1148 */             Prefacturas.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1152 */     this.jButton45.setMnemonic('C');
/* 1153 */     this.jButton45.setText("Cerrar");
/* 1154 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 1155 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1157 */             Prefacturas.this.jButton45ActionPerformed(evt);
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
/* 1257 */             Prefacturas.this.jButton3ActionPerformed(evt);
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
/* 1326 */             Prefacturas.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1330 */     this.jButton24.setMnemonic('A');
/* 1331 */     this.jButton24.setText("Aceptar");
/* 1332 */     this.jButton24.setToolTipText("Aceptar (Alt+A)");
/* 1333 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1335 */             Prefacturas.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1339 */     this.jTextField5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1341 */             Prefacturas.this.jTextField5ActionPerformed(evt);
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
/* 1481 */     this.jLabel3.setHorizontalAlignment(0);
/* 1482 */     this.jLabel3.setText("REPORTES INTERNOS");
/*      */     
/* 1484 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 1485 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Reporte Interno", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1487 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1489 */             Prefacturas.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1493 */     this.jLabel15.setFont(new Font("Tahoma", 3, 12));
/* 1494 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 1495 */     this.jLabel15.setHorizontalAlignment(0);
/* 1496 */     this.jLabel15.setText("Folio ó Referencia");
/*      */     
/* 1498 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1499 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 1500 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVA", "CANCELADA", "TODAS" }));
/* 1501 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1503 */             Prefacturas.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1507 */     this.jLabel46.setFont(new Font("Tahoma", 3, 12));
/* 1508 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 1509 */     this.jLabel46.setHorizontalAlignment(0);
/* 1510 */     this.jLabel46.setText("Estado-Reporte");
/*      */     
/* 1512 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 1513 */     this.jComboBox2.setFont(new Font("Tahoma", 1, 11));
/* 1514 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "TODOS" }));
/* 1515 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1517 */             Prefacturas.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1521 */     this.jLabel47.setFont(new Font("Tahoma", 3, 12));
/* 1522 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/* 1523 */     this.jLabel47.setHorizontalAlignment(0);
/* 1524 */     this.jLabel47.setText("Responsable");
/*      */     
/* 1526 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 1527 */     this.jComboBox3.setFont(new Font("Tahoma", 1, 11));
/* 1528 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "TODOS" }));
/* 1529 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1531 */             Prefacturas.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1535 */     this.jLabel49.setFont(new Font("Tahoma", 3, 12));
/* 1536 */     this.jLabel49.setForeground(new Color(15, 87, 51));
/* 1537 */     this.jLabel49.setHorizontalAlignment(0);
/* 1538 */     this.jLabel49.setText("Cliente");
/*      */     
/* 1540 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1542 */             Prefacturas.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1546 */     this.jLabel16.setFont(new Font("Tahoma", 3, 12));
/* 1547 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/* 1548 */     this.jLabel16.setHorizontalAlignment(0);
/* 1549 */     this.jLabel16.setText("Núm");
/*      */     
/* 1551 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 1552 */     this.jPanel17.setLayout(jPanel17Layout);
/* 1553 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 1554 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1555 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1556 */           .addContainerGap()
/* 1557 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1558 */             .addComponent(this.jLabel46, -1, -1, 32767)
/* 1559 */             .addComponent(this.jComboBox1, -2, 134, -2))
/* 1560 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1561 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1562 */             .addComponent(this.jLabel47, -1, -1, 32767)
/* 1563 */             .addComponent(this.jComboBox2, -2, 163, -2))
/* 1564 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1565 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1566 */             .addComponent(this.jLabel49, -1, -1, 32767)
/* 1567 */             .addComponent(this.jComboBox3, -2, 213, -2))
/* 1568 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1569 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1570 */             .addComponent(this.jLabel16, -1, -1, 32767)
/* 1571 */             .addComponent(this.jTextField6, -2, 128, -2))
/* 1572 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1573 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1574 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 1575 */             .addComponent(this.jTextField1, -2, 128, -2))
/* 1576 */           .addContainerGap(274, 32767)));
/*      */     
/* 1578 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 1579 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1580 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1581 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1582 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1583 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 1584 */                 .addComponent(this.jTextField6, -2, -1, -2)
/* 1585 */                 .addGap(8, 8, 8)
/* 1586 */                 .addComponent(this.jLabel16))
/* 1587 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 1588 */                 .addComponent(this.jTextField1, -2, -1, -2)
/* 1589 */                 .addGap(8, 8, 8)
/* 1590 */                 .addComponent(this.jLabel15)))
/* 1591 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1592 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 1593 */                 .addComponent(this.jComboBox1, -2, -1, -2)
/* 1594 */                 .addGap(8, 8, 8)
/* 1595 */                 .addComponent(this.jLabel46))
/* 1596 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 1597 */                 .addComponent(this.jComboBox2, -2, -1, -2)
/* 1598 */                 .addGap(8, 8, 8)
/* 1599 */                 .addComponent(this.jLabel47))
/* 1600 */               .addGroup(jPanel17Layout.createSequentialGroup()
/* 1601 */                 .addComponent(this.jComboBox3, -2, -1, -2)
/* 1602 */                 .addGap(8, 8, 8)
/* 1603 */                 .addComponent(this.jLabel49))))
/* 1604 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1607 */     this.jPanel18.setBackground(new Color(146, 193, 134));
/* 1608 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder(null, "Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1610 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/* 1611 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Ruta", "Operador", "Eco", "Guías", "Autorizó" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1619 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1624 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1627 */     this.jTable2.setShowVerticalLines(false);
/* 1628 */     this.jTable2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1630 */             Prefacturas.this.jTable2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1633 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/* 1635 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1636 */     this.jLabel48.setForeground(Color.red);
/* 1637 */     this.jLabel48.setHorizontalAlignment(0);
/* 1638 */     this.jLabel48.setText("t");
/* 1639 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1641 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1642 */     this.jButton4.setMnemonic('N');
/* 1643 */     this.jButton4.setText("Nuevo");
/* 1644 */     this.jButton4.setToolTipText("Nueva Reporte Interno (Alt+N)");
/* 1645 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1647 */             Prefacturas.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1651 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1652 */     this.jButton5.setMnemonic('M');
/* 1653 */     this.jButton5.setText("Modificar");
/* 1654 */     this.jButton5.setToolTipText("Modificar Interno (Alt+M)");
/* 1655 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1657 */             Prefacturas.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1661 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1662 */     this.jButton11.setMnemonic('C');
/* 1663 */     this.jButton11.setText("Cancelar");
/* 1664 */     this.jButton11.setToolTipText("Cancelar (Alt+C)");
/* 1665 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1667 */             Prefacturas.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1671 */     this.jButton34.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1672 */     this.jButton34.setMnemonic('G');
/* 1673 */     this.jButton34.setText("Guardar Reporte");
/* 1674 */     this.jButton34.setToolTipText("Guardar Reporte (Alt+G)");
/* 1675 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1677 */             Prefacturas.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1681 */     this.jButton12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1682 */     this.jButton12.setMnemonic('V');
/* 1683 */     this.jButton12.setText("Ver");
/* 1684 */     this.jButton12.setToolTipText("Ver reporte interno (Alt+V)");
/* 1685 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1687 */             Prefacturas.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1691 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 1692 */     this.jPanel18.setLayout(jPanel18Layout);
/* 1693 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 1694 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1695 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1696 */           .addContainerGap()
/* 1697 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1698 */             .addComponent(this.jScrollPane2, -1, 1076, 32767)
/* 1699 */             .addGroup(jPanel18Layout.createSequentialGroup()
/* 1700 */               .addComponent(this.jLabel48, -2, 163, -2)
/* 1701 */               .addGap(18, 18, 18)
/* 1702 */               .addComponent(this.jButton4, -2, 110, -2)
/* 1703 */               .addGap(18, 18, 18)
/* 1704 */               .addComponent(this.jButton5, -2, 107, -2)
/* 1705 */               .addGap(18, 18, 18)
/* 1706 */               .addComponent(this.jButton11, -2, 114, -2)
/* 1707 */               .addGap(18, 18, 18)
/* 1708 */               .addComponent(this.jButton12, -2, 114, -2)
/* 1709 */               .addGap(89, 89, 89)
/* 1710 */               .addComponent(this.jButton34, -2, 154, -2)
/* 1711 */               .addGap(0, 0, 32767)))
/* 1712 */           .addContainerGap()));
/*      */     
/* 1714 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 1715 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1716 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1717 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1718 */             .addComponent(this.jLabel48)
/* 1719 */             .addComponent(this.jButton4)
/* 1720 */             .addComponent(this.jButton5)
/* 1721 */             .addComponent(this.jButton11)
/* 1722 */             .addComponent(this.jButton12)
/* 1723 */             .addComponent(this.jButton34))
/* 1724 */           .addGap(4, 4, 4)
/* 1725 */           .addComponent(this.jScrollPane2, -1, 173, 32767)));
/*      */ 
/*      */     
/* 1728 */     this.jPanel8.setBackground(new Color(255, 255, 255));
/* 1729 */     this.jPanel8.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 1731 */     this.jDateChooser11.setDate(this.fechaActual);
/* 1732 */     this.jDateChooser11.setDateFormatString("dd/MM/yyyy");
/* 1733 */     this.jDateChooser11.setIcon(this.icon);
/* 1734 */     this.jDateChooser11.setMaxSelectableDate(this.fecha);
/* 1735 */     this.jDateChooser11.setMinSelectableDate(new Date(1286690512000L));
/*      */     
/* 1737 */     this.jDateChooser12.setDate(this.fechaActual);
/* 1738 */     this.jDateChooser12.setDateFormatString("dd/MM/yyyy");
/* 1739 */     this.jDateChooser12.setIcon(this.icon);
/* 1740 */     this.jDateChooser12.setMaxSelectableDate(this.fechaActual);
/* 1741 */     this.jDateChooser12.setMinSelectableDate(new Date(1286690512000L));
/*      */     
/* 1743 */     this.jLabel37.setFont(new Font("Tahoma", 2, 12));
/* 1744 */     this.jLabel37.setForeground(new Color(15, 87, 51));
/* 1745 */     this.jLabel37.setText("<html><u>Todos </u></html>");
/* 1746 */     this.jLabel37.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1748 */             Prefacturas.this.jLabel37MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1751 */             Prefacturas.this.jLabel37MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1754 */             Prefacturas.this.jLabel37MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1758 */     this.jLabel38.setFont(new Font("Tahoma", 2, 12));
/* 1759 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/* 1760 */     this.jLabel38.setHorizontalAlignment(0);
/* 1761 */     this.jLabel38.setText("<html><u>Hoy</u></html>");
/* 1762 */     this.jLabel38.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1764 */             Prefacturas.this.jLabel38MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1767 */             Prefacturas.this.jLabel38MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1770 */             Prefacturas.this.jLabel38MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1774 */     this.jLabel39.setFont(new Font("Tahoma", 2, 12));
/* 1775 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/* 1776 */     this.jLabel39.setText("<html><u>Ayer</u></html>");
/* 1777 */     this.jLabel39.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1779 */             Prefacturas.this.jLabel39MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1782 */             Prefacturas.this.jLabel39MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1785 */             Prefacturas.this.jLabel39MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1789 */     this.jLabel40.setFont(new Font("Tahoma", 1, 15));
/* 1790 */     this.jLabel40.setForeground(Color.red);
/* 1791 */     this.jLabel40.setHorizontalAlignment(4);
/* 1792 */     this.jLabel40.setText("REPORTE DEL");
/*      */     
/* 1794 */     this.jLabel41.setFont(new Font("Tahoma", 1, 15));
/* 1795 */     this.jLabel41.setForeground(Color.red);
/* 1796 */     this.jLabel41.setHorizontalAlignment(0);
/* 1797 */     this.jLabel41.setText("AL");
/*      */     
/* 1799 */     this.jButton15.setMnemonic('F');
/* 1800 */     this.jButton15.setText("Filtrar");
/* 1801 */     this.jButton15.setToolTipText("Filtrar información (Alt+F)");
/* 1802 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1804 */             Prefacturas.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1808 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1809 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1810 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1811 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1812 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1813 */           .addContainerGap()
/* 1814 */           .addComponent(this.jLabel40, -2, 130, -2)
/* 1815 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1816 */           .addComponent((Component)this.jDateChooser11, -2, 108, -2)
/* 1817 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1818 */           .addComponent(this.jLabel41)
/* 1819 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1820 */           .addComponent((Component)this.jDateChooser12, -2, 108, -2)
/* 1821 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1822 */           .addComponent(this.jButton15)
/* 1823 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1824 */           .addComponent(this.jLabel37, -2, -1, -2)
/* 1825 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1826 */           .addComponent(this.jLabel38, -2, 31, -2)
/* 1827 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1828 */           .addComponent(this.jLabel39, -2, 31, -2)
/* 1829 */           .addContainerGap(43, 32767)));
/*      */     
/* 1831 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1832 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1833 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1834 */           .addContainerGap()
/* 1835 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1836 */             .addComponent(this.jLabel40, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1837 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 1838 */               .addGap(1, 1, 1)
/* 1839 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1840 */                 .addComponent((Component)this.jDateChooser11, GroupLayout.Alignment.TRAILING, -2, -1, -2)
/* 1841 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1842 */                   .addComponent(this.jLabel37, -2, 19, -2)
/* 1843 */                   .addComponent(this.jLabel38, -2, 15, -2)
/* 1844 */                   .addComponent(this.jLabel39, -2, -1, -2)
/* 1845 */                   .addComponent(this.jButton15))
/* 1846 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 1847 */                   .addComponent(this.jLabel41, -2, 19, -2)
/* 1848 */                   .addGap(1, 1, 1))
/* 1849 */                 .addComponent((Component)this.jDateChooser12, GroupLayout.Alignment.TRAILING, -2, -1, -2))))));
/*      */ 
/*      */     
/* 1852 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1853 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1854 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1855 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1856 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1857 */           .addContainerGap()
/* 1858 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1859 */             .addComponent(this.jPanel18, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1860 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 1861 */               .addComponent(this.jPanel8, -2, -1, -2)
/* 1862 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767)
/* 1863 */               .addComponent(this.jLabel3, -2, 428, -2))
/* 1864 */             .addComponent(this.jPanel17, -1, -1, 32767))
/* 1865 */           .addContainerGap()));
/*      */     
/* 1867 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1868 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1869 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1870 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1871 */             .addComponent(this.jLabel3)
/* 1872 */             .addComponent(this.jPanel8, -2, -1, -2))
/* 1873 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1874 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 1875 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1876 */           .addComponent(this.jPanel18, -1, -1, 32767)
/* 1877 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1880 */     GroupLayout layout = new GroupLayout(this);
/* 1881 */     setLayout(layout);
/* 1882 */     layout.setHorizontalGroup(layout
/* 1883 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1884 */         .addGap(0, 1130, 32767)
/* 1885 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1886 */           .addGroup(layout.createSequentialGroup()
/* 1887 */             .addContainerGap()
/* 1888 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 1889 */             .addContainerGap())));
/*      */     
/* 1891 */     layout.setVerticalGroup(layout
/* 1892 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1893 */         .addGap(0, 386, 32767)
/* 1894 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1895 */           .addGroup(layout.createSequentialGroup()
/* 1896 */             .addGap(11, 11, 11)
/* 1897 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 1898 */             .addGap(11, 11, 11))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1903 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1907 */     if (this.jComboBox1.getItemCount() > 0 && this.PRIMERA == true) {
/* 1908 */       consultar();
/* 1909 */       if (this.jComboBox1.getSelectedIndex() == 1 || this.jComboBox1.getSelectedIndex() == 2) {
/* 1910 */         this.jButton5.setEnabled(false);
/* 1911 */         this.jButton11.setEnabled(false);
/*      */       } else {
/*      */         
/* 1914 */         this.jButton5.setEnabled(true);
/* 1915 */         this.jButton11.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable2MouseClicked(MouseEvent evt) {
/* 1921 */     if (evt.getClickCount() == 2) {
/* 1922 */       verFactura();
/*      */     } else {
/*      */       
/* 1925 */       this.jButton5.setEnabled(true);
/* 1926 */       this.jButton11.setEnabled(true);
/* 1927 */       this.jButton12.setEnabled(true);
/* 1928 */       if (this.jComboBox1.getSelectedIndex() == 1 || this.jComboBox1.getSelectedIndex() == 2) {
/* 1929 */         this.jButton5.setEnabled(false);
/* 1930 */         this.jButton11.setEnabled(false);
/*      */       } else {
/*      */         
/* 1933 */         this.jButton5.setEnabled(true);
/* 1934 */         this.jButton11.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1940 */     this.jComboBox21.setSelectedIndex(0);
/* 1941 */     this.jComboBox22.setSelectedIndex(0);
/* 1942 */     this.jComboBox23.setSelectedIndex(0);
/* 1943 */     this.jDateChooser4.setDate(new Date());
/* 1944 */     this.jTextField2.setText("");
/* 1945 */     this.PRESIONADO = false;
/* 1946 */     this.jFrame1.setTitle("Crear reporte interno");
/* 1947 */     this.jButton14.setText("Guardar");
/* 1948 */     this.jLabel60.setText("<html>NOTA: Para ordenar los datos puedes dar clic en el encabezado de las columnas</html>");
/* 1949 */     this.jLabel60.setToolTipText("<html>NOTA: Para ordenar los datos puedes dar clic en el encabezado de las columnas</html>");
/* 1950 */     this.jComboBox4.setEnabled(true);
/* 1951 */     this.jComboBox21.setEnabled(true);
/* 1952 */     this.jComboBox22.setEnabled(true);
/* 1953 */     this.jComboBox23.setEnabled(true);
/* 1954 */     this.jDateChooser4.setEnabled(true);
/* 1955 */     this.jTextField2.setEnabled(true);
/* 1956 */     this.jButton17.setVisible(true);
/* 1957 */     this.jButton1.setVisible(true);
/* 1958 */     this.jButton2.setVisible(true);
/* 1959 */     this.jButton14.setVisible(true);
/* 1960 */     this.jButton10.setVisible(true);
/* 1961 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1965 */     String estatus = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 12));
/* 1966 */     if (estatus.equals("<Cerrada>")) {
/* 1967 */       JOptionPane.showMessageDialog(this.padre, "El reporte interno que seleccionaste ya se encuentra cerrado, selecciona otro reporte", "Reporte Cerrado", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1970 */       this.PRESIONADO = false;
/* 1971 */       this.jFrame1.setTitle("Modificar Factura");
/* 1972 */       this.jButton14.setText("Modificar");
/* 1973 */       this.jButton14.setToolTipText("Guarda la prefactura (Alt+G)");
/* 1974 */       this.jButton14.setMnemonic('G');
/* 1975 */       this.jLabel60.setText("<html>NOTA: Para ordenar los datos puedes dar clic en el encabezado de las columnas</html>");
/* 1976 */       this.jLabel60.setToolTipText("<html>NOTA: Para ordenar los datos puedes dar clic en el encabezado de las columnas</html>");
/* 1977 */       this.jComboBox4.setEnabled(true);
/* 1978 */       this.jComboBox21.setEnabled(true);
/* 1979 */       this.jComboBox22.setEnabled(true);
/* 1980 */       this.jComboBox23.setEnabled(true);
/* 1981 */       this.jDateChooser4.setEnabled(true);
/* 1982 */       this.jTextField2.setEnabled(true);
/* 1983 */       this.jButton17.setVisible(true);
/* 1984 */       this.jButton1.setVisible(true);
/* 1985 */       this.jButton2.setVisible(true);
/* 1986 */       this.jButton14.setVisible(true);
/* 1987 */       this.jButton10.setVisible(true);
/* 1988 */       this.jTextField4.setEnabled(true);
/* 1989 */       this.jCheckBox1.setEnabled(true);
/* 1990 */       int ind = this.jTable2.getSelectedRow();
/*      */       
/* 1992 */       String[] datos = { String.valueOf(this.jTable2.getValueAt(ind, 0)), String.valueOf(this.jTable2.getValueAt(ind, 1)), String.valueOf(this.jTable2.getValueAt(ind, 2)), String.valueOf(this.jTable2.getValueAt(ind, 3)), String.valueOf(this.jTable2.getValueAt(ind, 4)), String.valueOf(this.jTable2.getValueAt(ind, 5)), String.valueOf(this.jTable2.getValueAt(ind, 6)), String.valueOf(this.jTable2.getValueAt(ind, 7)), String.valueOf(this.jTable2.getValueAt(ind, 8)), String.valueOf(this.jTable2.getValueAt(ind, 9)), String.valueOf(this.jTable2.getValueAt(ind, 10)), String.valueOf(this.jTable2.getValueAt(ind, 11)) };
/* 1993 */       this.PREFAC = datos[0];
/*      */       
/* 1995 */       String año = datos[2].substring(0, 4);
/* 1996 */       String mes = datos[2].substring(5, 7);
/* 1997 */       String dia = datos[2].substring(8, 10);
/* 1998 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 1999 */       String strFecha = dia + "-" + dia + "-" + mes;
/* 2000 */       Date fechaG = null;
/*      */       try {
/* 2002 */         fechaG = formatoDelTexto.parse(strFecha);
/* 2003 */         this.jDateChooser4.setDate(fechaG);
/* 2004 */       } catch (ParseException ex) {
/* 2005 */         ex.printStackTrace();
/*      */       } 
/* 2007 */       if (datos[3].equals("<GENERAL>")) {
/* 2008 */         this.jComboBox4.setSelectedIndex(0);
/*      */       } else {
/* 2010 */         this.jComboBox4.setSelectedItem(datos[3]);
/*      */       } 
/*      */       
/* 2013 */       if (datos[4].equals("<GENERAL>")) {
/* 2014 */         this.jComboBox21.setSelectedIndex(0);
/*      */       } else {
/* 2016 */         this.jComboBox21.setSelectedItem(datos[4]);
/*      */       } 
/*      */       
/* 2019 */       if (datos[5].equals("<GENERAL>")) {
/* 2020 */         this.jComboBox22.setSelectedIndex(0);
/*      */       } else {
/* 2022 */         this.jComboBox22.setSelectedItem(datos[5]);
/*      */       } 
/* 2024 */       if (datos[6].equals("<GENERAL>")) {
/* 2025 */         this.jComboBox23.setSelectedIndex(0);
/*      */       } else {
/* 2027 */         this.jComboBox23.setSelectedItem(datos[6]);
/*      */       } 
/* 2029 */       this.jTextField2.setText(datos[1]);
/* 2030 */       String[] campos = this.con.regresaReg("tipo,tons,pedido", "prefacturas", "where numInterPre = " + datos[0], 3);
/* 2031 */       this.jTextField4.setText("");
/* 2032 */       this.jCheckBox1.setSelected(false);
/* 2033 */       if (!campos[2].equals("")) {
/* 2034 */         this.jTextField4.setText(campos[2]);
/* 2035 */         this.jCheckBox1.setSelected(true);
/*      */       } 
/* 2037 */       this.TIPOREPOR = Integer.parseInt(campos[0]);
/*      */       
/* 2039 */       if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2045 */         if (this.TIPOREPOR == 0) {
/* 2046 */           this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2047 */                 .buscarDatos(14, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,pedido,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Folio", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ped", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */               {
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 2053 */                 boolean[] canEdit = new boolean[] { 
/*      */                     false, false, false, false, false, false, false, false, false, false, 
/*      */                     false, false, false, false, false, false, false, false };
/*      */                 public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2057 */                   return this.canEdit[columnIndex];
/*      */                 }
/*      */               });
/*      */           
/* 2061 */           this.VIAJESTOT = this.jTable1.getRowCount();
/* 2062 */           this.TONS = Double.valueOf(Double.parseDouble(campos[1]));
/* 2063 */           this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable1.getRowCount() + "</HTML>");
/* 2064 */           this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + campos[1] + "</HTML>");
/* 2065 */           this.jTable1.moveColumn(13, 14);
/*      */         } else {
/* 2067 */           this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2068 */                 .buscarDatos(14, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,rsp,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Folio", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "R.S.P.", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */               {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 2075 */                 boolean[] canEdit = new boolean[] { 
/*      */                     false, false, false, false, false, false, false, false, false, false, 
/*      */                     false, false, false, false, false, false, false, false };
/*      */                 
/*      */                 public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2080 */                   return this.canEdit[columnIndex];
/*      */                 }
/*      */               });
/* 2083 */           this.jTable1.moveColumn(13, 14);
/*      */         } 
/* 2085 */         for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2086 */           String col = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 2087 */           String resi = String.valueOf(this.jTable1.getValueAt(i, 2));
/* 2088 */           if (resi.equals("SERVICIO INTEGRAL")) {
/* 2089 */             this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + col + "'");
/* 2090 */             if (this.encontrado) {
/* 2091 */               this.jTable1.setValueAt(this.con.Campo, i, 13);
/*      */             } else {
/* 2093 */               this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + col + "'");
/* 2094 */               if (this.encontrado) {
/* 2095 */                 this.jTable1.setValueAt(this.con.Campo, i, 13);
/*      */               } else {
/* 2097 */                 this.jTable1.setValueAt("", i, 13);
/*      */               } 
/*      */             } 
/*      */           } else {
/* 2101 */             this.jTable1.setValueAt("", i, 13);
/*      */           } 
/*      */         } 
/* 2104 */         this.jTable1.setSelectionMode(0);
/* 2105 */         this.jTable1.setAutoCreateRowSorter(true);
/* 2106 */         this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */       } 
/* 2108 */       if (this.TIPOREPOR == 2) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2113 */         this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2114 */               .buscarDatos(13, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Guía", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2121 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false, false, false, false, false, false, false, false };
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2126 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/*      */         
/* 2130 */         this.VIAJESTOT = this.jTable1.getRowCount();
/* 2131 */         this.TONS = Double.valueOf(Double.parseDouble(campos[1]));
/* 2132 */         this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable1.getRowCount() + "</HTML>");
/* 2133 */         this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + campos[1] + "</HTML>");
/* 2134 */         this.jTable1.moveColumn(13, 12);
/* 2135 */         for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2136 */           String col = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 2137 */           String resi = String.valueOf(this.jTable1.getValueAt(i, 2));
/* 2138 */           if (resi.equals("SERVICIO INTEGRAL")) {
/* 2139 */             this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + col + "'");
/* 2140 */             if (this.encontrado) {
/* 2141 */               this.jTable1.setValueAt(this.con.Campo, i, 12);
/*      */             } else {
/* 2143 */               this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + col + "'");
/* 2144 */               if (this.encontrado) {
/* 2145 */                 this.jTable1.setValueAt(this.con.Campo, i, 12);
/*      */               } else {
/* 2147 */                 this.jTable1.setValueAt("", i, 12);
/*      */               } 
/*      */             } 
/*      */           } else {
/* 2151 */             this.jTable1.setValueAt("", i, 12);
/*      */           } 
/*      */         } 
/*      */       } 
/* 2155 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(60);
/* 2156 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
/* 2157 */       this.jTable1.getColumnModel().getColumn(1).setMinWidth(110);
/* 2158 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(110);
/* 2159 */       this.jTable1.getColumnModel().getColumn(2).setMinWidth(110);
/* 2160 */       this.jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
/* 2161 */       this.jTable1.getColumnModel().getColumn(9).setMinWidth(50);
/* 2162 */       this.jTable1.getColumnModel().getColumn(9).setMaxWidth(50);
/* 2163 */       this.jTable1.getColumnModel().getColumn(10).setMinWidth(50);
/* 2164 */       this.jTable1.getColumnModel().getColumn(10).setMaxWidth(50);
/* 2165 */       this.jTable1.getColumnModel().getColumn(11).setMinWidth(60);
/* 2166 */       this.jTable1.getColumnModel().getColumn(11).setMaxWidth(60);
/* 2167 */       this.jTable1.getColumnModel().getColumn(12).setMinWidth(60);
/* 2168 */       this.jTable1.getColumnModel().getColumn(12).setMaxWidth(60);
/*      */       
/* 2170 */       if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 2171 */         this.jTable1.getColumnModel().getColumn(13).setMinWidth(95);
/* 2172 */         this.jTable1.getColumnModel().getColumn(13).setMaxWidth(95);
/* 2173 */         this.jTable1.getColumnModel().getColumn(14).setMinWidth(200);
/* 2174 */         this.jTable1.getColumnModel().getColumn(14).setMaxWidth(200);
/*      */       } else {
/* 2176 */         this.jTable1.getColumnModel().getColumn(12).setMinWidth(120);
/* 2177 */         this.jTable1.getColumnModel().getColumn(12).setMaxWidth(120);
/* 2178 */         this.jTable1.getColumnModel().getColumn(13).setMinWidth(150);
/* 2179 */         this.jTable1.getColumnModel().getColumn(13).setMaxWidth(150);
/*      */       } 
/* 2181 */       this.jFrame1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2186 */     this.jTextArea5.setText("");
/* 2187 */     int ind = this.jTable2.getSelectedRow();
/* 2188 */     String valor = String.valueOf(this.jTable2.getValueAt(ind, 11));
/* 2189 */     if (!valor.equals("ACTIVA")) {
/* 2190 */       JOptionPane.showMessageDialog(this.padre, "La prefactura que seleccionaste ya se encuentra cancelada\nPor favor selecciona otros datos.", "Prefactura Cancelada", 0, this.ERROR);
/*      */     }
/* 2192 */     else if (ind < 0) {
/* 2193 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar una prefactura para poder cancelar los datos", "Selecciona un aPrefactura", 0, this.ERROR);
/*      */     } else {
/* 2195 */       this.jDialog6.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 2201 */     String[] datos = { "PREFACTURA", "FOLIO", "FECHA", "CLIENTE", "EQUIPO", "PLATAFORMA", "POZO", "PEDIDO", "TONS", "NÚM VIAJES", "ESTATUS", "RESPONSABLE", "COMENTARIO" };
/* 2202 */     this.esc = new EscribirReporte("PREFACTURAS", this.jTable2, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 2206 */     if (this.jComboBox1.getItemCount() > 0 && this.PRIMERA == true) {
/* 2207 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 2212 */     if (this.jComboBox1.getItemCount() > 0 && this.PRIMERA == true) {
/* 2213 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2218 */     verFactura();
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2222 */     this.PRIMERAGUIAS = false;
/* 2223 */     String cliente = String.valueOf(this.jComboBox4.getSelectedItem());
/* 2224 */     String equipo = String.valueOf(this.jComboBox21.getSelectedItem());
/* 2225 */     String plat = String.valueOf(this.jComboBox22.getSelectedItem());
/* 2226 */     String pozo = String.valueOf(this.jComboBox23.getSelectedItem());
/* 2227 */     if (!cliente.equals("SELECCIONA UN CLIENTE...")) {
/* 2228 */       this.jComboBox20.setSelectedItem(cliente);
/*      */     } else {
/* 2230 */       this.jComboBox20.setSelectedIndex(0);
/*      */     } 
/* 2232 */     if (!equipo.equals("GENERAL")) {
/* 2233 */       this.jComboBox7.setSelectedItem(equipo);
/*      */     } else {
/* 2235 */       this.jComboBox7.setSelectedIndex(0);
/*      */     } 
/* 2237 */     if (!plat.equals("GENERAL")) {
/* 2238 */       this.jComboBox8.setSelectedItem(plat);
/*      */     } else {
/* 2240 */       this.jComboBox8.setSelectedIndex(0);
/*      */     } 
/* 2242 */     if (!pozo.equals("GENERAL")) {
/* 2243 */       this.jComboBox9.setSelectedItem(pozo);
/*      */     } else {
/* 2245 */       this.jComboBox9.setSelectedIndex(0);
/*      */     } 
/* 2247 */     consultarGuias();
/* 2248 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 2251 */     String archivo = String.valueOf(this.jComboBox4.getSelectedItem());
/* 2252 */     Icon cliente = new ImageIcon(this.tk.getImage("Formatos/" + archivo + ".jpg"));
/* 2253 */     this.jLabel29.setIcon(cliente);
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 2257 */     String cadena = this.jTextField3.getText();
/* 2258 */     if (!cadena.equals("")) {
/* 2259 */       if (this.presionado == null) {
/* 2260 */         this.presionado = new Presionado();
/* 2261 */         this.presionado.start();
/*      */       } else {
/*      */         
/* 2264 */         this.presionado.detenerFuera();
/* 2265 */         this.presionado = new Presionado();
/* 2266 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/*      */       
/* 2270 */       this.jTextField3.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 2275 */     if (this.jComboBox10.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2276 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 2281 */     if (this.jComboBox10.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2282 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 2287 */     if (this.jComboBox8.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2288 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox9ActionPerformed(ActionEvent evt) {
/* 2293 */     if (this.jComboBox9.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2294 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 2299 */     if (this.jComboBox6.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2300 */       consultarGuias();
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
/* 2317 */     if (evt.getClickCount() == 2) {
/* 2318 */       pasarGuia();
/*      */     } else {
/*      */       
/* 2321 */       this.jButton7.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 2326 */     int indice = this.jTable3.getSelectedRow();
/* 2327 */     if (indice < 0) {
/* 2328 */       JOptionPane.showMessageDialog(this.jDialog1, "Debes seleccionar un viaje para poder agregarlo a la prefactura", "Agregar Viaje", 0, this.ADVER);
/*      */     } else {
/* 2330 */       pasarGuia();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 2335 */     int ind = this.jTable1.getSelectedRow();
/* 2336 */     if (ind < 0) {
/* 2337 */       JOptionPane.showMessageDialog(this.jFrame1, "Necesitas seleccionar un viaje para poder quitarlo", "Selecciona un viaje", 0, this.ERROR);
/*      */     } else {
/* 2339 */       quitarViaje();
/*      */     } 
/*      */   }
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 2343 */     if (this.jTextField2.isEnabled()) {
/* 2344 */       salir();
/*      */     } else {
/* 2346 */       this.jFrame1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   private void jFrame1WindowClosing(WindowEvent evt) {
/* 2350 */     if (this.jTextField2.isEnabled()) {
/* 2351 */       salir();
/*      */     } else {
/* 2353 */       this.jFrame1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 2358 */     int reg = this.jTable3.getRowCount();
/* 2359 */     if (reg < 1) {
/* 2360 */       JOptionPane.showMessageDialog(this.jFrame1, "No hay guías para agregar, verifica tu información", "No hay Guías", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 2363 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas agregar todos los viajes a la prefactura?", "Agregar Viajes a Prefactura", 0, 3, this.PREG);
/* 2364 */       if (res == 0) {
/* 2365 */         pasarTodos();
/* 2366 */         this.jDialog1.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2371 */     String[] datos = new String[this.jTable1.getColumnCount()];
/* 2372 */     for (int i = 0; i < this.jTable1.getColumnCount(); i++) {
/* 2373 */       datos[i] = "";
/* 2374 */       datos[i] = this.jTable1.getColumnName(i);
/*      */     } 
/* 2376 */     this.esc = new EscribirReporte("PREFACTURAS", this.jTable1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 2380 */     int reg = this.jTable1.getRowCount();
/* 2381 */     if (reg < 1) {
/* 2382 */       JOptionPane.showMessageDialog(this.jFrame1, "No puedes imprimir el reporte, ya que no has agregado viajes en el reporte", "Sin Viajes", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 2385 */       String texto = "";
/* 2386 */       String titulo = "";
/* 2387 */       if (this.jButton14.getText().equals("Modificar")) {
/* 2388 */         texto = "¿Estás seguro que deseas modificar el reporte?";
/* 2389 */         titulo = "Modificar Reporte";
/*      */       
/*      */       }
/* 2392 */       else if (!this.jTextField2.isEnabled()) {
/* 2393 */         texto = "Deseas imprimir los datos del Reporte";
/* 2394 */         titulo = "Imprimir Reporte";
/*      */       } else {
/*      */         
/* 2397 */         texto = "¿Deseas crear un nuevo reporte y guardar los datos?";
/* 2398 */         titulo = "Guardar Reporte";
/*      */       } 
/*      */ 
/*      */       
/* 2402 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, texto, titulo, 0, 3, this.PREG);
/* 2403 */       if (res == 0) {
/* 2404 */         if (this.jButton14.getText().equals("Modificar")) {
/* 2405 */           this.con.inserSinMsj("update guias set estatus='<Pagada Al Operador>', pedido='', factura=0 where factura=" + this.PREFAC);
/*      */         }
/* 2407 */         if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 2408 */           imprimir1();
/*      */         } else {
/* 2410 */           imprimir2();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 2417 */     int ind = this.jTable1.getSelectedRow();
/* 2418 */     if (ind < 0) {
/* 2419 */       JOptionPane.showMessageDialog(this.jFrame1, "Necesitas seleccionar un viaje para agregar comentarios", "Selecciona un viaje", 0, this.ERROR);
/*      */     } else {
/* 2421 */       String valor = "";
/* 2422 */       if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 2423 */         valor = String.valueOf(this.jTable1.getValueAt(ind, 14));
/*      */       } else {
/* 2425 */         valor = String.valueOf(this.jTable1.getValueAt(ind, 13));
/*      */       } 
/* 2427 */       this.jTextArea2.setText(valor);
/* 2428 */       if (this.jTextField2.isEnabled()) {
/* 2429 */         this.jDialog4.setVisible(true);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 2435 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 2439 */     String comen = this.jTextArea2.getText().toUpperCase();
/* 2440 */     String guia = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/*      */     
/* 2442 */     if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 2443 */       this.jTable1.setValueAt(comen, this.jTable1.getSelectedRow(), 14);
/*      */     } else {
/* 2445 */       this.jTable1.setValueAt(comen, this.jTable1.getSelectedRow(), 13);
/*      */     } 
/* 2447 */     this.jDialog4.setVisible(false);
/* 2448 */     this.PRESIONADO = true;
/* 2449 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   private void jTable1MouseClicked(MouseEvent evt) {
/* 2453 */     if (evt.getClickCount() == 2) {
/* 2454 */       int col = this.jTable1.getSelectedColumn();
/* 2455 */       String columna = this.jTable1.getColumnName(col);
/* 2456 */       if (columna.equals("Comentario")) {
/* 2457 */         int ind = this.jTable1.getSelectedRow();
/* 2458 */         if (ind < 0) {
/* 2459 */           JOptionPane.showMessageDialog(this.jFrame1, "Necesitas seleccionar un viaje para agregar comentarios", "Selecciona un viaje", 0, this.ERROR);
/*      */         } else {
/*      */           
/* 2462 */           String valor = "";
/*      */           
/* 2464 */           if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 2465 */             Object val = this.jTable1.getValueAt(ind, 14);
/* 2466 */             if (val == null) {
/* 2467 */               valor = "";
/*      */             } else {
/*      */               
/* 2470 */               valor = String.valueOf(this.jTable1.getValueAt(ind, 14));
/*      */             } 
/*      */           } else {
/*      */             
/* 2474 */             Object val = this.jTable1.getValueAt(ind, 13);
/* 2475 */             if (val == null) {
/* 2476 */               valor = "";
/*      */             } else {
/*      */               
/* 2479 */               valor = String.valueOf(this.jTable1.getValueAt(ind, 13));
/*      */             } 
/*      */           } 
/* 2482 */           this.jTextArea2.setText(valor);
/* 2483 */           if (this.jTextField2.isEnabled()) {
/* 2484 */             this.jDialog4.setVisible(true);
/*      */           }
/*      */         }
/*      */       
/* 2488 */       } else if (columna.equals("Ped")) {
/* 2489 */         Object valor = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 8);
/* 2490 */         if (valor != null) {
/* 2491 */           this.jTextField5.setText(String.valueOf(valor));
/*      */         } else {
/* 2493 */           this.jTextField5.setText("");
/*      */         } 
/* 2495 */         if (this.jTextField2.isEnabled()) {
/* 2496 */           this.jDialog7.setVisible(true);
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
/* 2507 */     String nombre = JOptionPane.showInputDialog(this.jFrame1, "Coloca el nombre de la columna", "Nombre Columna", 1);
/* 2508 */     int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas insertar la nueva columna: " + nombre.toUpperCase() + "?", "Agregar Columna", 0, 3, this.PREG);
/* 2509 */     if (res == 0) {
/* 2510 */       this.MODELOPREFACTURA.addColumn(nombre);
/* 2511 */       TableModel nuevo = null;
/*      */       
/* 2513 */       this.jTable1.getColumnModel();
/* 2514 */       bloquearTabla();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jMenuItem2ActionPerformed(ActionEvent evt) {
/* 2519 */     int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas quitar la columna de R.S.P.?", "Quitar Columna R.S.P.", 0, 3, this.PREG);
/* 2520 */     if (res == 0) {
/*      */       try {
/* 2522 */         this.jTable1.removeColumn(this.jTable1.getColumn("R.S.P."));
/* 2523 */       } catch (Exception e) {
/* 2524 */         JOptionPane.showMessageDialog(this.jFrame1, "La columna de RSP no se pudo eliminar, verifica que exista esa columna", "No se Eliminó", 0, this.ERROR);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMenuItem4ActionPerformed(ActionEvent evt) {
/* 2530 */     String[] datos = new String[this.jTable1.getColumnCount()];
/* 2531 */     for (int i = 0; i < this.jTable1.getColumnCount(); i++) {
/* 2532 */       datos[i] = "";
/* 2533 */       datos[i] = this.jTable1.getColumnName(i);
/*      */     } 
/* 2535 */     this.esc = new EscribirReporte("PREFACTURAS", this.jTable1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 2539 */     this.jLabel11.setVisible(false);
/* 2540 */     this.jTextField4.setVisible(false);
/* 2541 */     this.jCheckBox1.setVisible(false);
/* 2542 */     this.TIPOREPOR = 2;
/* 2543 */     cargarValores();
/* 2544 */     desactivarTabla();
/* 2545 */     this.jDialog5.setVisible(false);
/* 2546 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 2550 */     this.jTextField5.setText("");
/* 2551 */     this.jCheckBox1.setSelected(true);
/* 2552 */     this.jLabel11.setVisible(true);
/* 2553 */     this.jTextField4.setVisible(true);
/* 2554 */     this.jCheckBox1.setVisible(true);
/* 2555 */     this.jCheckBox1.setSelected(false);
/* 2556 */     this.TIPOREPOR = 0;
/* 2557 */     desactivarTabla();
/* 2558 */     cargarValores();
/* 2559 */     this.jDialog5.setVisible(false);
/* 2560 */     this.jComboBox4.setSelectedIndex(0);
/* 2561 */     this.jTextField4.setEnabled(true);
/* 2562 */     this.jCheckBox1.setEnabled(true);
/* 2563 */     this.jCheckBox1.setSelected(false);
/* 2564 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 2568 */     this.jLabel11.setVisible(false);
/* 2569 */     this.jTextField4.setVisible(false);
/* 2570 */     this.jCheckBox1.setVisible(false);
/* 2571 */     this.TIPOREPOR = 1;
/* 2572 */     desactivarTabla();
/* 2573 */     cargarValores();
/* 2574 */     this.jDialog5.setVisible(false);
/* 2575 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 2579 */     int ind = this.jTable2.getSelectedRow();
/* 2580 */     String prefa = String.valueOf(this.jTable2.getValueAt(ind, 0));
/* 2581 */     if (this.jTextArea5.getText().equals("")) {
/* 2582 */       JOptionPane.showMessageDialog(this.jDialog6, "Debes colocar un comentario sobre el motivo de cancelación de la prefactura", "Falta Comentario", 0, this.ERROR);
/*      */     } else {
/* 2584 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas cancelar la prefactura y activar todas los viajes correspondientes?", "Cancelar Prefactura", 0, 3, this.PREG);
/* 2585 */       if (res == 0) {
/* 2586 */         this.con.inserSinMsj("update guias set estatus='<Pagada Al Operador>', factura=0 where factura=" + prefa);
/* 2587 */         this.con.inserSinMsj("update prefacturas set estatus='CANCELADA/ " + this.jTextArea5.getText().toUpperCase() + "',actual='<Cancelada>' where numInterPre=" + prefa);
/* 2588 */         this.mensajeTry.guardarConf("Se canceló un reporte interno, USUARIO: " + this.USUARIO, "Reporte Interno Cancelado (" + prefa + ")", "ERROR", "Facturacion");
/* 2589 */         this.jDialog6.setVisible(false);
/* 2590 */         consultar();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 2596 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel37MouseClicked(MouseEvent evt) {
/* 2600 */     this.jDateChooser11.setDate(this.fechaInicio);
/* 2601 */     this.jDateChooser12.setDate(this.fechaActual);
/* 2602 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel37MouseEntered(MouseEvent evt) {
/* 2606 */     this.jLabel37.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel37MouseExited(MouseEvent evt) {
/* 2610 */     this.jLabel37.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel38MouseClicked(MouseEvent evt) {
/* 2614 */     this.jDateChooser11.setDate(this.fechaActual);
/* 2615 */     this.jDateChooser12.setDate(this.fechaActual);
/* 2616 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel38MouseEntered(MouseEvent evt) {
/* 2620 */     this.jLabel38.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel38MouseExited(MouseEvent evt) {
/* 2624 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel39MouseClicked(MouseEvent evt) {
/* 2628 */     Calendar ca = Calendar.getInstance();
/* 2629 */     Calendar fecha = Calendar.getInstance();
/* 2630 */     int aa = fecha.get(1);
/* 2631 */     int mm = fecha.get(2);
/* 2632 */     int dd = fecha.get(5);
/* 2633 */     if (dd == 1) {
/* 2634 */       if (mm == 0) {
/* 2635 */         mm = 11;
/* 2636 */         aa--;
/*      */       } else {
/* 2638 */         mm--;
/*      */       } 
/* 2640 */       int diasTotal = diasDelMes(mm, aa);
/* 2641 */       dd = diasTotal;
/*      */     } else {
/* 2643 */       dd--;
/*      */     } 
/* 2645 */     mm++;
/* 2646 */     String año = "" + aa;
/* 2647 */     String mes = "" + mm;
/* 2648 */     String dia = "" + dd;
/* 2649 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2650 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 2652 */       this.jDateChooser11.setDate(formatoDelTexto.parse(strFecha));
/* 2653 */       this.jDateChooser12.setDate(formatoDelTexto.parse(strFecha));
/* 2654 */     } catch (ParseException ex) {
/* 2655 */       ex.printStackTrace();
/*      */     } 
/* 2657 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel39MouseEntered(MouseEvent evt) {
/* 2661 */     this.jLabel39.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel39MouseExited(MouseEvent evt) {
/* 2665 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 2669 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 2673 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 2677 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 2681 */     this.jTable1.setValueAt(this.jTextField5.getText().toUpperCase(), this.jTable1.getSelectedRow(), 8);
/* 2682 */     this.jDialog7.setVisible(false);
/* 2683 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   private void jTextField5ActionPerformed(ActionEvent evt) {
/* 2687 */     this.jTable1.setValueAt(this.jTextField5.getText().toUpperCase(), this.jTable1.getSelectedRow(), 8);
/* 2688 */     this.jDialog7.setVisible(false);
/* 2689 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 2693 */     if (!this.jCheckBox1.isSelected()) {
/* 2694 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas quitar el número de pedido para todos los viajes?", "Quitar Pedidos", 0, 3, this.PREG);
/* 2695 */       if (res == 0) {
/* 2696 */         for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2697 */           this.jTable1.setValueAt("", i, 8);
/* 2698 */           this.jTextField4.setText("");
/*      */         } 
/* 2700 */         bloquearTabla();
/*      */       } else {
/*      */         
/* 2703 */         this.jCheckBox1.setSelected(true);
/*      */       } 
/*      */     } else {
/*      */       
/* 2707 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "¿Estás seguro que deseas asignar el número de pedido a todos los viajes?", "Asignar Pedidos", 0, 3, this.PREG);
/* 2708 */       if (res == 0) {
/* 2709 */         for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2710 */           this.jTable1.setValueAt(this.jTextField4.getText().toUpperCase(), i, 8);
/*      */         }
/* 2712 */         bloquearTabla();
/*      */       } else {
/*      */         
/* 2715 */         this.jCheckBox1.setSelected(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 2721 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox10ActionPerformed(ActionEvent evt) {
/* 2725 */     if (this.jComboBox10.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2726 */       consultarGuias();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {
/* 2731 */     consultarGuias();
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 2735 */     consultarGuias();
/*      */   }
/*      */   
/*      */   private void jComboBox20ActionPerformed(ActionEvent evt) {
/* 2739 */     if (this.jComboBox20.getItemCount() > 0 && this.PRIMERAGUIAS == true) {
/* 2740 */       consultarGuias();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField7ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField7KeyReleased(KeyEvent evt) {
/* 2749 */     String cadena = this.jTextField7.getText();
/* 2750 */     if (!cadena.equals("")) {
/* 2751 */       if (this.presionado == null) {
/* 2752 */         this.presionado = new Presionado();
/* 2753 */         this.presionado.start();
/*      */       } else {
/*      */         
/* 2756 */         this.presionado.detenerFuera();
/* 2757 */         this.presionado = new Presionado();
/* 2758 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/*      */       
/* 2762 */       this.jTextField7.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   public int diasDelMes(int mes, int año) {
/* 2766 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 2774 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 2780 */         return 30;
/*      */       
/*      */       case 1:
/* 2783 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 2785 */           return 29;
/*      */         }
/* 2787 */         return 28;
/*      */     } 
/*      */ 
/*      */     
/* 2791 */     return 0;
/*      */   }
/*      */   
/*      */   public void verFactura() {
/* 2795 */     this.jFrame1.setTitle("Ver reporte interno a detalle");
/* 2796 */     this.jButton14.setText("Imprimir");
/* 2797 */     this.jButton14.setToolTipText("Imprimir (Alt+I)");
/* 2798 */     this.jButton14.setMnemonic('I');
/* 2799 */     int ind = this.jTable2.getSelectedRow();
/* 2800 */     this.jLabel60.setText(String.valueOf(this.jTable2.getValueAt(ind, 10)));
/* 2801 */     this.jLabel60.setToolTipText(String.valueOf(this.jTable2.getValueAt(ind, 10)));
/* 2802 */     String[] datos = { String.valueOf(this.jTable2.getValueAt(ind, 0)), String.valueOf(this.jTable2.getValueAt(ind, 1)), String.valueOf(this.jTable2.getValueAt(ind, 2)), String.valueOf(this.jTable2.getValueAt(ind, 3)), String.valueOf(this.jTable2.getValueAt(ind, 4)), String.valueOf(this.jTable2.getValueAt(ind, 5)), String.valueOf(this.jTable2.getValueAt(ind, 6)), String.valueOf(this.jTable2.getValueAt(ind, 7)), String.valueOf(this.jTable2.getValueAt(ind, 8)), String.valueOf(this.jTable2.getValueAt(ind, 9)), String.valueOf(this.jTable2.getValueAt(ind, 10)), String.valueOf(this.jTable2.getValueAt(ind, 11)) };
/* 2803 */     this.jTextField2.setText(datos[1]);
/* 2804 */     this.jComboBox4.setEnabled(false);
/* 2805 */     this.jComboBox21.setEnabled(false);
/* 2806 */     this.jComboBox22.setEnabled(false);
/* 2807 */     this.jComboBox23.setEnabled(false);
/* 2808 */     this.jDateChooser4.setEnabled(false);
/* 2809 */     this.jTextField2.setEnabled(false);
/* 2810 */     this.jButton17.setVisible(false);
/* 2811 */     this.jButton1.setVisible(false);
/* 2812 */     this.jButton2.setVisible(false);
/* 2813 */     this.jButton10.setVisible(false);
/* 2814 */     this.jTextField4.setEnabled(false);
/* 2815 */     this.jCheckBox1.setEnabled(false);
/*      */ 
/*      */     
/* 2818 */     String año = datos[2].substring(0, 4);
/* 2819 */     String mes = datos[2].substring(5, 7);
/* 2820 */     String dia = datos[2].substring(8, 10);
/* 2821 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2822 */     String strFecha = dia + "-" + dia + "-" + mes;
/* 2823 */     Date fechaG = null;
/*      */     try {
/* 2825 */       fechaG = formatoDelTexto.parse(strFecha);
/* 2826 */       this.jDateChooser4.setDate(fechaG);
/* 2827 */     } catch (ParseException ex) {
/* 2828 */       ex.printStackTrace();
/*      */     } 
/* 2830 */     if (datos[3].equals("<GENERAL>")) {
/* 2831 */       this.jComboBox4.setSelectedIndex(0);
/*      */     } else {
/* 2833 */       this.jComboBox4.setSelectedItem(datos[3]);
/*      */     } 
/*      */     
/* 2836 */     if (datos[4].equals("<GENERAL>")) {
/* 2837 */       this.jComboBox21.setSelectedIndex(0);
/*      */     } else {
/* 2839 */       this.jComboBox21.setSelectedItem(datos[4]);
/*      */     } 
/*      */     
/* 2842 */     if (datos[5].equals("<GENERAL>")) {
/* 2843 */       this.jComboBox22.setSelectedIndex(0);
/*      */     } else {
/* 2845 */       this.jComboBox22.setSelectedItem(datos[5]);
/*      */     } 
/* 2847 */     if (datos[6].equals("<GENERAL>")) {
/* 2848 */       this.jComboBox23.setSelectedIndex(0);
/*      */     } else {
/* 2850 */       this.jComboBox23.setSelectedItem(datos[6]);
/*      */     } 
/* 2852 */     String[] campos = this.con.regresaReg("tipo,tons,pedido", "prefacturas", "where numInterPre = " + datos[0], 3);
/* 2853 */     this.TIPOREPOR = Integer.parseInt(campos[0]);
/* 2854 */     this.jTextField4.setText("");
/* 2855 */     this.jCheckBox1.setSelected(false);
/* 2856 */     if (!campos[2].equals("")) {
/* 2857 */       this.jTextField4.setText(campos[2]);
/* 2858 */       this.jCheckBox1.setSelected(true);
/*      */     } 
/*      */     
/* 2861 */     if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2866 */       if (this.TIPOREPOR == 0) {
/* 2867 */         this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2868 */               .buscarDatos(14, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,pedido,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Folio", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ped", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2876 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false, false, false, false, false, false, false, false };
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2881 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/*      */         
/* 2885 */         this.VIAJESTOT = this.jTable1.getRowCount();
/* 2886 */         this.TONS = Double.valueOf(Double.parseDouble(campos[1]));
/* 2887 */         this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable1.getRowCount() + "</HTML>");
/* 2888 */         this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + campos[1] + "</HTML>");
/* 2889 */         this.jTable1.moveColumn(13, 14);
/*      */       }
/*      */       else {
/*      */         
/* 2893 */         this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2894 */               .buscarDatos(14, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,rsp,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Folio", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "R.S.P.", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2900 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false, false, false, false, false, false, false, false };
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2904 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 2907 */         for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 2908 */           System.out.println("ejempl " + j + " " + String.valueOf(this.jTable1.getValueAt(j, 13)));
/*      */         }
/* 2910 */         this.jTable1.moveColumn(13, 14);
/*      */       } 
/* 2912 */       for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2913 */         String col = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 2914 */         String resi = String.valueOf(this.jTable1.getValueAt(i, 2));
/* 2915 */         if (resi.equals("SERVICIO INTEGRAL")) {
/* 2916 */           this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + col + "'");
/* 2917 */           if (this.encontrado) {
/* 2918 */             this.jTable1.setValueAt(this.con.Campo, i, 13);
/*      */           } else {
/* 2920 */             this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + col + "'");
/* 2921 */             if (this.encontrado) {
/* 2922 */               this.jTable1.setValueAt(this.con.Campo, i, 13);
/*      */             } else {
/* 2924 */               this.jTable1.setValueAt("", i, 13);
/*      */             } 
/*      */           } 
/*      */         } else {
/*      */           
/* 2929 */           this.jTable1.setValueAt("", i, 13);
/*      */         } 
/*      */       } 
/* 2932 */       this.jTable1.setSelectionMode(0);
/* 2933 */       this.jTable1.setAutoCreateRowSorter(true);
/* 2934 */       this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     } 
/* 2936 */     if (this.TIPOREPOR == 2) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2941 */       this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2942 */             .buscarDatos(13, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,equipo,plataforma,pozos.nombre,ticket,peso,num_tracto,num_rem,comen_pre", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale=vales.num_vale and guias.factura =" + datos[0] + " order by guias.num_guia desc"), (Object[])new String[] { "Guía", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Comentario", "Manifiesto" })
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2948 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false };
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2953 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/*      */       
/* 2957 */       this.VIAJESTOT = this.jTable1.getRowCount();
/* 2958 */       this.TONS = Double.valueOf(Double.parseDouble(campos[1]));
/* 2959 */       this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable1.getRowCount() + "</HTML>");
/* 2960 */       this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + campos[1] + "</HTML>");
/* 2961 */       this.jTable1.moveColumn(13, 12); int i;
/* 2962 */       for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2963 */         String col = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 2964 */         String resi = String.valueOf(this.jTable1.getValueAt(i, 2));
/* 2965 */         if (resi.equals("SERVICIO INTEGRAL")) {
/* 2966 */           this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + col + "'");
/* 2967 */           if (this.encontrado) {
/* 2968 */             this.jTable1.setValueAt(this.con.Campo, i, 12);
/*      */           } else {
/*      */             
/* 2971 */             this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + col + "'");
/* 2972 */             if (this.encontrado) {
/* 2973 */               this.jTable1.setValueAt(this.con.Campo, i, 12);
/*      */             } else {
/*      */               
/* 2976 */               this.jTable1.setValueAt("", i, 12);
/*      */             } 
/*      */           } 
/*      */         } else {
/*      */           
/* 2981 */           this.jTable1.setValueAt("", i, 12);
/*      */         } 
/*      */       } 
/* 2984 */       for (i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2985 */         this.TONELADAS += Double.parseDouble(String.valueOf(this.jTable1.getValueAt(i, 9)));
/*      */       }
/*      */       
/* 2988 */       System.out.println("TONELADAS TOTALES " + this.TONELADAS);
/*      */     } 
/* 2990 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(60);
/* 2991 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
/* 2992 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(110);
/* 2993 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(110);
/* 2994 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(110);
/* 2995 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
/* 2996 */     this.jTable1.getColumnModel().getColumn(9).setMinWidth(50);
/* 2997 */     this.jTable1.getColumnModel().getColumn(9).setMaxWidth(50);
/* 2998 */     this.jTable1.getColumnModel().getColumn(10).setMinWidth(50);
/* 2999 */     this.jTable1.getColumnModel().getColumn(10).setMaxWidth(50);
/* 3000 */     this.jTable1.getColumnModel().getColumn(11).setMinWidth(60);
/* 3001 */     this.jTable1.getColumnModel().getColumn(11).setMaxWidth(60);
/* 3002 */     this.jTable1.getColumnModel().getColumn(12).setMinWidth(60);
/* 3003 */     this.jTable1.getColumnModel().getColumn(12).setMaxWidth(60);
/*      */     
/* 3005 */     if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 3006 */       this.jTable1.getColumnModel().getColumn(13).setMinWidth(95);
/* 3007 */       this.jTable1.getColumnModel().getColumn(13).setMaxWidth(95);
/* 3008 */       this.jTable1.getColumnModel().getColumn(14).setMinWidth(200);
/* 3009 */       this.jTable1.getColumnModel().getColumn(14).setMaxWidth(200);
/*      */     } else {
/*      */       
/* 3012 */       this.jTable1.getColumnModel().getColumn(12).setMinWidth(95);
/* 3013 */       this.jTable1.getColumnModel().getColumn(12).setMaxWidth(95);
/* 3014 */       this.jTable1.getColumnModel().getColumn(13).setMinWidth(200);
/* 3015 */       this.jTable1.getColumnModel().getColumn(13).setMaxWidth(200);
/*      */     } 
/* 3017 */     this.jFrame1.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cargarValores() {
/* 3026 */     if (this.TIPOREPOR == 1) {
/* 3027 */       this.jComboBox4.setSelectedItem("WEATHERFORD");
/* 3028 */       this.jComboBox20.setSelectedItem("WEATHERFORD");
/* 3029 */       this.jComboBox4.setEnabled(false);
/* 3030 */       this.jComboBox20.setEnabled(false);
/* 3031 */     } else if (this.TIPOREPOR == 2) {
/* 3032 */       this.jComboBox4.setSelectedIndex(0);
/* 3033 */       this.jComboBox20.setSelectedIndex(0);
/* 3034 */       this.jComboBox4.setEnabled(true);
/* 3035 */       this.jComboBox20.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void imprimir1() {
/* 3040 */     this.OTROSRESIDUOS = 0;
/* 3041 */     this.addGuias = new AddGuias[11];
/* 3042 */     for (int i = 0; i < this.addGuias.length; i++) {
/* 3043 */       this.addGuias[i] = new AddGuias();
/*      */     }
/* 3045 */     this.TONSRESIDUO = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/* 3046 */     this.GUIASAMPARADAS = new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "" };
/*      */     
/* 3048 */     String COL = "";
/* 3049 */     if (this.TIPOREPOR == 0) {
/* 3050 */       COL = "PED";
/*      */     } else {
/* 3052 */       COL = "RSP";
/*      */     } 
/* 3054 */     this.NOMBRECOL = new String[] { "GUÍA", "FECHA", "RESIDUO", "EQUIPO", COL, "TICK", "TONS", "TRAC", "REM", "MANIF", "COMENTARIO" };
/* 3055 */     this.LINEAS = new String[this.jTable1.getRowCount()];
/* 3056 */     this.LETRASMAX = new int[this.NOMBRECOL.length];
/* 3057 */     this.REGIS = new String[this.jTable1.getRowCount()][this.NOMBRECOL.length];
/* 3058 */     this.SERVICIOS = new String[] { "FLETE", "MOV FALSO", "MOV INTER", "RENTA", "SERV RETRO", "SERV INT" };
/* 3059 */     this.OTROSSERVICIOS = 0;
/* 3060 */     this.OTROSRESIDUOS = 0; int j;
/* 3061 */     for (j = 0; j < this.CANTTOTALES.length; j++) {
/* 3062 */       this.CANTTOTALES[j] = 0;
/*      */     }
/* 3064 */     for (j = 0; j < this.jTable1.getRowCount(); j++) {
/* 3065 */       String guiaSola = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3066 */       String fecha = String.valueOf(this.jTable1.getValueAt(j, 1));
/* 3067 */       String fechaCorta = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3068 */       String serv = String.valueOf(this.jTable1.getValueAt(j, 2));
/* 3069 */       String residuo = String.valueOf(this.jTable1.getValueAt(j, 3));
/* 3070 */       String cliente = String.valueOf(this.jTable1.getValueAt(j, 4));
/*      */       
/* 3072 */       String toneladas = String.valueOf(this.jTable1.getValueAt(j, 10));
/* 3073 */       double tonsInd = Double.parseDouble(toneladas);
/* 3074 */       int indice = 0;
/* 3075 */       if (cliente.equals("WEATHERFORD")) {
/* 3076 */         cliente = "WTF";
/* 3077 */       } else if (cliente.equals("SCHLUMBERGER")) {
/* 3078 */         cliente = "SLB";
/*      */       } 
/* 3080 */       if (residuo.equals("AGUA DE FRACTURA")) {
/* 3081 */         this.CANTTOTALES[6] = this.CANTTOTALES[6] + 1;
/* 3082 */         this.TONSRESIDUO[0] = this.TONSRESIDUO[0] + tonsInd;
/*      */         
/* 3084 */         if (this.GUIASAMPARADAS[0].equals("")) {
/* 3085 */           this.GUIASAMPARADAS[0] = guiaSola;
/*      */         } else {
/* 3087 */           this.GUIASAMPARADAS[0] = this.GUIASAMPARADAS[0] + ", " + this.GUIASAMPARADAS[0];
/*      */         } 
/* 3089 */         residuo = "AG DE FRAC";
/* 3090 */       } else if (residuo.equals("LODO BASE AGUA")) {
/* 3091 */         residuo = "L AGUA";
/* 3092 */         this.CANTTOTALES[9] = this.CANTTOTALES[9] + 1;
/* 3093 */         this.TONSRESIDUO[3] = this.TONSRESIDUO[3] + tonsInd;
/*      */         
/* 3095 */         if (this.GUIASAMPARADAS[3].equals("")) {
/* 3096 */           this.GUIASAMPARADAS[3] = guiaSola;
/*      */         } else {
/* 3098 */           this.GUIASAMPARADAS[3] = this.GUIASAMPARADAS[3] + ", " + this.GUIASAMPARADAS[3];
/*      */         } 
/* 3100 */       } else if (residuo.equals("RECORTE BASE ACEITE")) {
/* 3101 */         residuo = "R ACEITE";
/* 3102 */         this.CANTTOTALES[10] = this.CANTTOTALES[10] + 1;
/* 3103 */         this.TONSRESIDUO[4] = this.TONSRESIDUO[4] + tonsInd;
/*      */         
/* 3105 */         if (this.GUIASAMPARADAS[4].equals("")) {
/* 3106 */           this.GUIASAMPARADAS[4] = guiaSola;
/*      */         } else {
/* 3108 */           this.GUIASAMPARADAS[4] = this.GUIASAMPARADAS[4] + ", " + this.GUIASAMPARADAS[4];
/*      */         } 
/* 3110 */       } else if (residuo.equals("RECORTE BASE AGUA")) {
/* 3111 */         residuo = "R AGUA";
/* 3112 */         this.CANTTOTALES[11] = this.CANTTOTALES[11] + 1;
/* 3113 */         this.TONSRESIDUO[5] = this.TONSRESIDUO[5] + tonsInd;
/* 3114 */         if (this.GUIASAMPARADAS[5].equals("")) {
/* 3115 */           this.GUIASAMPARADAS[5] = guiaSola;
/*      */         } else {
/* 3117 */           this.GUIASAMPARADAS[5] = this.GUIASAMPARADAS[5] + ", " + this.GUIASAMPARADAS[5];
/*      */         }
/*      */       
/* 3120 */       } else if (residuo.equals("FLETES - VARIOS")) {
/* 3121 */         residuo = "FLET VAR";
/* 3122 */         this.CANTTOTALES[15] = this.CANTTOTALES[15] + 1;
/* 3123 */         this.TONSRESIDUO[9] = this.TONSRESIDUO[9] + tonsInd;
/* 3124 */         if (this.GUIASAMPARADAS[9].equals("")) {
/* 3125 */           this.GUIASAMPARADAS[9] = guiaSola;
/*      */         } else {
/* 3127 */           this.GUIASAMPARADAS[9] = this.GUIASAMPARADAS[9] + ", " + this.GUIASAMPARADAS[9];
/*      */         }
/*      */       
/* 3130 */       } else if (residuo.equals("AGUA RESIDUAL")) {
/* 3131 */         this.TONSRESIDUO[1] = this.TONSRESIDUO[1] + tonsInd;
/* 3132 */         if (this.GUIASAMPARADAS[1].equals("")) {
/* 3133 */           this.GUIASAMPARADAS[1] = guiaSola;
/*      */         } else {
/* 3135 */           this.GUIASAMPARADAS[1] = this.GUIASAMPARADAS[1] + ", " + this.GUIASAMPARADAS[1];
/*      */         } 
/*      */         
/* 3138 */         residuo = "AG RESID";
/* 3139 */         this.CANTTOTALES[7] = this.CANTTOTALES[7] + 1;
/* 3140 */       } else if (residuo.equals("LODO BASE ACEITE")) {
/* 3141 */         residuo = "L ACEITE";
/* 3142 */         this.CANTTOTALES[8] = this.CANTTOTALES[8] + 1;
/* 3143 */         if (this.GUIASAMPARADAS[2].equals("")) {
/* 3144 */           this.GUIASAMPARADAS[2] = guiaSola;
/*      */         } else {
/* 3146 */           this.GUIASAMPARADAS[2] = this.GUIASAMPARADAS[2] + ", " + this.GUIASAMPARADAS[2];
/*      */         }
/*      */       
/* 3149 */       } else if (residuo.equals("SALMUERA")) {
/* 3150 */         this.CANTTOTALES[12] = this.CANTTOTALES[12] + 1;
/* 3151 */         this.TONSRESIDUO[6] = this.TONSRESIDUO[6] + tonsInd;
/* 3152 */         if (this.GUIASAMPARADAS[6].equals("")) {
/* 3153 */           this.GUIASAMPARADAS[6] = guiaSola;
/*      */         } else {
/* 3155 */           this.GUIASAMPARADAS[6] = this.GUIASAMPARADAS[6] + ", " + this.GUIASAMPARADAS[6];
/*      */         }
/*      */       
/* 3158 */       } else if (residuo.equals("SANEAMIENTO")) {
/* 3159 */         residuo = "SANEAM";
/* 3160 */         this.CANTTOTALES[13] = this.CANTTOTALES[13] + 1;
/* 3161 */         this.TONSRESIDUO[7] = this.TONSRESIDUO[7] + tonsInd;
/* 3162 */         if (this.GUIASAMPARADAS[7].equals("")) {
/* 3163 */           this.GUIASAMPARADAS[7] = guiaSola;
/*      */         } else {
/* 3165 */           this.GUIASAMPARADAS[7] = this.GUIASAMPARADAS[7] + ", " + this.GUIASAMPARADAS[7];
/*      */         }
/*      */       
/* 3168 */       } else if (residuo.equals("SEDIMENTO")) {
/* 3169 */         residuo = "SEDIMEN";
/* 3170 */         this.CANTTOTALES[14] = this.CANTTOTALES[14] + 1;
/* 3171 */         this.TONSRESIDUO[8] = this.TONSRESIDUO[8] + tonsInd;
/* 3172 */         if (this.GUIASAMPARADAS[8].equals("")) {
/* 3173 */           this.GUIASAMPARADAS[8] = guiaSola;
/*      */         } else {
/* 3175 */           this.GUIASAMPARADAS[8] = this.GUIASAMPARADAS[8] + ", " + this.GUIASAMPARADAS[8];
/*      */         } 
/*      */       } else {
/*      */         
/* 3179 */         this.OTROSRESIDUOS++;
/* 3180 */         this.TONSRESIDUO[10] = this.TONSRESIDUO[10] + tonsInd;
/* 3181 */         if (this.GUIASAMPARADAS[10].equals("")) {
/* 3182 */           this.GUIASAMPARADAS[10] = guiaSola;
/*      */         } else {
/* 3184 */           this.GUIASAMPARADAS[10] = this.GUIASAMPARADAS[10] + ", " + this.GUIASAMPARADAS[10];
/*      */         } 
/*      */       } 
/* 3187 */       if (residuo.equals("FLUIDO RECUPERADO C/TRAZAS DE ACEITE")) {
/* 3188 */         residuo = "F RECUP/TRAZAS";
/*      */       }
/* 3190 */       else if (residuo.equals("FLUIDO RECUPERADO")) {
/* 3191 */         residuo = "F RECUP";
/*      */       } 
/* 3193 */       this.REGIS[j][0] = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3194 */       this.REGIS[j][1] = fechaCorta;
/* 3195 */       this.REGIS[j][2] = residuo;
/* 3196 */       this.REGIS[j][3] = String.valueOf(this.jTable1.getValueAt(j, 5));
/* 3197 */       this.REGIS[j][3] = String.valueOf(this.jTable1.getValueAt(j, 5));
/* 3198 */       if (this.jTable1.getValueAt(j, 8) == null) {
/* 3199 */         this.REGIS[j][4] = "";
/*      */       } else {
/* 3201 */         this.REGIS[j][4] = String.valueOf(this.jTable1.getValueAt(j, 8));
/*      */       } 
/* 3203 */       this.REGIS[j][5] = String.valueOf(this.jTable1.getValueAt(j, 9));
/* 3204 */       this.REGIS[j][6] = String.valueOf(this.jTable1.getValueAt(j, 10));
/* 3205 */       this.REGIS[j][7] = String.valueOf(this.jTable1.getValueAt(j, 11));
/* 3206 */       this.REGIS[j][8] = String.valueOf(this.jTable1.getValueAt(j, 12));
/* 3207 */       this.REGIS[j][9] = String.valueOf(this.jTable1.getValueAt(j, 13));
/*      */       
/* 3209 */       if (this.jTable1.getValueAt(j, 14) == null) {
/* 3210 */         this.REGIS[j][10] = "";
/*      */       } else {
/* 3212 */         this.REGIS[j][10] = String.valueOf(this.jTable1.getValueAt(j, 14));
/*      */       } 
/*      */     } 
/* 3215 */     if (this.jTextField2.isEnabled()) {
/* 3216 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3217 */       String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 3218 */       String año = cadenaFecha1.substring(0, 4);
/* 3219 */       String mes = cadenaFecha1.substring(4, 6);
/* 3220 */       String dia = cadenaFecha1.substring(6, 8);
/* 3221 */       String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 3222 */       String cliente = "<GENERAL>";
/* 3223 */       String equipo = "<GENERAL>";
/* 3224 */       String plat = "<GENERAL>";
/* 3225 */       String pozo = "<GENERAL>";
/* 3226 */       String valorCliente = "0";
/*      */       
/* 3228 */       if (this.jComboBox4.getSelectedIndex() != 0) {
/* 3229 */         cliente = String.valueOf(this.jComboBox4.getSelectedItem());
/* 3230 */         valorCliente = this.IDCLIENTE[this.jComboBox4.getSelectedIndex() - 1];
/*      */       } 
/* 3232 */       if (this.jComboBox21.getSelectedIndex() != 0) {
/* 3233 */         equipo = String.valueOf(this.jComboBox21.getSelectedItem());
/*      */       }
/* 3235 */       if (this.jComboBox22.getSelectedIndex() != 0) {
/* 3236 */         plat = String.valueOf(this.jComboBox22.getSelectedItem());
/*      */       }
/* 3238 */       if (this.jComboBox23.getSelectedIndex() != 0) {
/* 3239 */         pozo = String.valueOf(this.jComboBox23.getSelectedItem());
/*      */       }
/* 3241 */       if (this.jButton14.getText().equals("Guardar")) {
/* 3242 */         this.con.inserSinMsj("insert into prefacturas(folio,fecha,cliente,equipo,plat,pozo,tons,numViajes,tipo,actual,estatus,clave_gene,nombre_usu,PEDIDO)values('" + this.jTextField2.getText().toUpperCase() + "'," + fechaCompleta + ",'" + cliente + "','" + equipo + "','" + plat + "','" + pozo + "'," + this.TONS + "," + this.jTable1.getRowCount() + "," + this.TIPOREPOR + ",'<Prefactura Ingresada>','ACTIVA'," + valorCliente + ",'" + this.USUARIO + "','" + this.jTextField4.getText().toUpperCase() + "')");
/* 3243 */         this.con.consultar("max(numInterPre)", "prefacturas", "");
/* 3244 */         this.PREFAC = this.con.Campo;
/* 3245 */         this.mensajeTry.guardarConf("Se ha creado un nuevo reporte interno, USUARIO: " + this.USUARIO, "Nuevo Reporte Interno (" + this.PREFAC + ")", "INFO", "Facturacion");
/*      */       } else {
/*      */         
/* 3248 */         this.con.inserSinMsj("update prefacturas set folio='" + this.jTextField2.getText().toUpperCase() + "',fecha=" + fechaCompleta + ", cliente='" + cliente + "', equipo='" + equipo + "', plat='" + plat + "', pozo='" + pozo + "', tons=" + this.TONS + ", numViajes=" + this.jTable1.getRowCount() + ", tipo=" + this.TIPOREPOR + ", nombre_usu='" + this.USUARIO + "',pedido='" + this.jTextField4.getText().toUpperCase() + "' where numInterPre=" + this.PREFAC);
/* 3249 */         this.mensajeTry.guardarConf("Se ha modificado un reporte interno, USUARIO: " + this.USUARIO, "Reporte Interno Modificado (" + this.PREFAC + ")", "INFO", "Facturacion");
/*      */       } 
/* 3251 */       for (int k = 0; k < this.jTable1.getRowCount(); k++) {
/* 3252 */         this.con.inserSinMsj("update guias set comen_pre='" + String.valueOf(this.jTable1.getValueAt(k, 14)) + "',factura=" + this.PREFAC + ", pedido='" + String.valueOf(this.jTable1.getValueAt(k, 8)) + "' where num_guia = '" + String.valueOf(this.jTable1.getValueAt(k, 0)) + "'");
/*      */       }
/*      */     } 
/*      */     
/* 3256 */     if (this.jButton14.getText().equals("Imprimir")) {
/* 3257 */       if (this.TIPOREPOR == 0) {
/* 3258 */         ImprimirFacturas imp = new ImprimirFacturas();
/* 3259 */         imp.recibeDatos();
/* 3260 */       } else if (this.TIPOREPOR == 1) {
/* 3261 */         ImprimirFacturas2 imp = new ImprimirFacturas2();
/* 3262 */         imp.recibeDatos();
/*      */       } 
/*      */     } else {
/*      */       
/* 3266 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "Los datos han sido guardados satisfactoriamente\n¿Deseas imprimir los datos del reporte?", "Imprimir Reporte", 0, 3, this.PREG);
/* 3267 */       if (res == 0) {
/* 3268 */         if (this.TIPOREPOR == 0) {
/* 3269 */           ImprimirFacturas imp = new ImprimirFacturas();
/* 3270 */           imp.recibeDatos();
/* 3271 */         } else if (this.TIPOREPOR == 1) {
/* 3272 */           ImprimirFacturas2 imp = new ImprimirFacturas2();
/* 3273 */           imp.recibeDatos();
/*      */         } 
/*      */       }
/*      */     } 
/* 3277 */     consultar();
/* 3278 */     this.jFrame1.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void imprimir2() {
/* 3283 */     this.addGuias = new AddGuias[11];
/* 3284 */     for (int i = 0; i < this.addGuias.length; i++) {
/* 3285 */       this.addGuias[i] = new AddGuias();
/*      */     }
/* 3287 */     this.TONSRESIDUO = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/* 3288 */     this.GUIASAMPARADAS = new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "" };
/* 3289 */     String COL = "";
/* 3290 */     if (this.TIPOREPOR == 0) {
/* 3291 */       COL = "PED";
/*      */     } else {
/* 3293 */       COL = "RSP";
/*      */     } 
/* 3295 */     this.NOMBRECOL = new String[] { "GUÍA", "FECHA", "SERVICIO", "RESIDUO", "EQUIPO", "TICK", "TONS", "TRAC", "REM", "MANIF", "COMENTARIO" };
/* 3296 */     this.LINEAS = new String[this.jTable1.getRowCount()];
/* 3297 */     this.LETRASMAX = new int[this.NOMBRECOL.length];
/* 3298 */     this.REGIS = new String[this.jTable1.getRowCount()][this.NOMBRECOL.length];
/* 3299 */     this.SERVICIOS = new String[] { "FLETE", "MOV FALSO", "MOV INTER", "RENTA", "SERV RETRO", "SERV INT" };
/* 3300 */     this.OTROSSERVICIOS = 0;
/* 3301 */     this.OTROSRESIDUOS = 0; int j;
/* 3302 */     for (j = 0; j < this.CANTTOTALES.length; j++) {
/* 3303 */       this.CANTTOTALES[j] = 0;
/*      */     }
/* 3305 */     for (j = 0; j < this.jTable1.getRowCount(); j++) {
/* 3306 */       String guiaSola = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3307 */       String fecha = String.valueOf(this.jTable1.getValueAt(j, 1));
/* 3308 */       String fechaCorta = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3309 */       String serv = String.valueOf(this.jTable1.getValueAt(j, 2));
/* 3310 */       String residuo = String.valueOf(this.jTable1.getValueAt(j, 3));
/* 3311 */       String cliente = String.valueOf(this.jTable1.getValueAt(j, 4));
/*      */       
/* 3313 */       String toneladas = String.valueOf(this.jTable1.getValueAt(j, 9));
/* 3314 */       double tonsInd = Double.parseDouble(toneladas);
/* 3315 */       int indice = 0;
/* 3316 */       if (cliente.equals("WEATHERFORD")) {
/* 3317 */         cliente = "WTF";
/* 3318 */       } else if (cliente.equals("SCHLUMBERGER")) {
/* 3319 */         cliente = "SLB";
/*      */       } 
/* 3321 */       if (serv.equals("SERVICIO INTEGRAL")) {
/* 3322 */         serv = "SERV INT";
/* 3323 */         this.CANTTOTALES[5] = this.CANTTOTALES[5] + 1;
/* 3324 */       } else if (serv.equals("MOVIMIENTO EN FALSO")) {
/* 3325 */         serv = "MOV FALSO";
/* 3326 */         this.CANTTOTALES[1] = this.CANTTOTALES[1] + 1;
/* 3327 */       } else if (serv.equals("MOVIMIENTO INTERNO")) {
/* 3328 */         serv = "MOV INTER";
/* 3329 */         this.CANTTOTALES[2] = this.CANTTOTALES[2] + 1;
/* 3330 */       } else if (serv.equals("SERVICIO DE RETRO")) {
/* 3331 */         this.CANTTOTALES[4] = this.CANTTOTALES[4] + 1;
/* 3332 */         serv = "SERV RET";
/* 3333 */       } else if (serv.equals("FLETE")) {
/* 3334 */         this.CANTTOTALES[0] = this.CANTTOTALES[0] + 1;
/* 3335 */       } else if (serv.equals("RENTA")) {
/* 3336 */         this.CANTTOTALES[3] = this.CANTTOTALES[3] + 1;
/*      */       } else {
/* 3338 */         this.OTROSSERVICIOS++;
/*      */       } 
/* 3340 */       if (residuo.equals("AGUA DE FRACTURA")) {
/* 3341 */         this.CANTTOTALES[6] = this.CANTTOTALES[6] + 1;
/* 3342 */         this.TONSRESIDUO[0] = this.TONSRESIDUO[0] + tonsInd;
/*      */         
/* 3344 */         if (this.GUIASAMPARADAS[0].equals("")) {
/* 3345 */           this.GUIASAMPARADAS[0] = guiaSola;
/*      */         } else {
/* 3347 */           this.GUIASAMPARADAS[0] = this.GUIASAMPARADAS[0] + ", " + this.GUIASAMPARADAS[0];
/*      */         } 
/* 3349 */         residuo = "AG DE FRAC";
/* 3350 */       } else if (residuo.equals("LODO BASE AGUA")) {
/* 3351 */         residuo = "L AGUA";
/* 3352 */         this.CANTTOTALES[9] = this.CANTTOTALES[9] + 1;
/* 3353 */         this.TONSRESIDUO[3] = this.TONSRESIDUO[3] + tonsInd;
/*      */         
/* 3355 */         if (this.GUIASAMPARADAS[3].equals("")) {
/* 3356 */           this.GUIASAMPARADAS[3] = guiaSola;
/*      */         } else {
/* 3358 */           this.GUIASAMPARADAS[3] = this.GUIASAMPARADAS[3] + ", " + this.GUIASAMPARADAS[3];
/*      */         } 
/* 3360 */       } else if (residuo.equals("RECORTE BASE ACEITE")) {
/* 3361 */         residuo = "R ACEITE";
/* 3362 */         this.CANTTOTALES[10] = this.CANTTOTALES[10] + 1;
/* 3363 */         this.TONSRESIDUO[4] = this.TONSRESIDUO[4] + tonsInd;
/*      */         
/* 3365 */         if (this.GUIASAMPARADAS[4].equals("")) {
/* 3366 */           this.GUIASAMPARADAS[4] = guiaSola;
/*      */         } else {
/* 3368 */           this.GUIASAMPARADAS[4] = this.GUIASAMPARADAS[4] + ", " + this.GUIASAMPARADAS[4];
/*      */         } 
/* 3370 */       } else if (residuo.equals("RECORTE BASE AGUA")) {
/* 3371 */         residuo = "R AGUA";
/* 3372 */         this.CANTTOTALES[11] = this.CANTTOTALES[11] + 1;
/* 3373 */         this.TONSRESIDUO[5] = this.TONSRESIDUO[5] + tonsInd;
/* 3374 */         if (this.GUIASAMPARADAS[5].equals("")) {
/* 3375 */           this.GUIASAMPARADAS[5] = guiaSola;
/*      */         } else {
/* 3377 */           this.GUIASAMPARADAS[5] = this.GUIASAMPARADAS[5] + ", " + this.GUIASAMPARADAS[5];
/*      */         }
/*      */       
/* 3380 */       } else if (residuo.equals("FLETES - VARIOS")) {
/* 3381 */         residuo = "FLET VAR";
/* 3382 */         this.CANTTOTALES[15] = this.CANTTOTALES[15] + 1;
/* 3383 */         this.TONSRESIDUO[9] = this.TONSRESIDUO[9] + tonsInd;
/* 3384 */         if (this.GUIASAMPARADAS[9].equals("")) {
/* 3385 */           this.GUIASAMPARADAS[9] = guiaSola;
/*      */         } else {
/* 3387 */           this.GUIASAMPARADAS[9] = this.GUIASAMPARADAS[9] + ", " + this.GUIASAMPARADAS[9];
/*      */         }
/*      */       
/* 3390 */       } else if (residuo.equals("AGUA RESIDUAL")) {
/* 3391 */         this.TONSRESIDUO[1] = this.TONSRESIDUO[1] + tonsInd;
/* 3392 */         if (this.GUIASAMPARADAS[1].equals("")) {
/* 3393 */           this.GUIASAMPARADAS[1] = guiaSola;
/*      */         } else {
/* 3395 */           this.GUIASAMPARADAS[1] = this.GUIASAMPARADAS[1] + ", " + this.GUIASAMPARADAS[1];
/*      */         } 
/*      */         
/* 3398 */         residuo = "AG RESID";
/* 3399 */         this.CANTTOTALES[7] = this.CANTTOTALES[7] + 1;
/* 3400 */       } else if (residuo.equals("LODO BASE ACEITE")) {
/* 3401 */         residuo = "L ACEITE";
/* 3402 */         this.CANTTOTALES[8] = this.CANTTOTALES[8] + 1;
/* 3403 */         if (this.GUIASAMPARADAS[2].equals("")) {
/* 3404 */           this.GUIASAMPARADAS[2] = guiaSola;
/*      */         } else {
/* 3406 */           this.GUIASAMPARADAS[2] = this.GUIASAMPARADAS[2] + ", " + this.GUIASAMPARADAS[2];
/*      */         }
/*      */       
/* 3409 */       } else if (residuo.equals("SALMUERA")) {
/* 3410 */         this.CANTTOTALES[12] = this.CANTTOTALES[12] + 1;
/* 3411 */         this.TONSRESIDUO[6] = this.TONSRESIDUO[6] + tonsInd;
/* 3412 */         if (this.GUIASAMPARADAS[6].equals("")) {
/* 3413 */           this.GUIASAMPARADAS[6] = guiaSola;
/*      */         } else {
/* 3415 */           this.GUIASAMPARADAS[6] = this.GUIASAMPARADAS[6] + ", " + this.GUIASAMPARADAS[6];
/*      */         }
/*      */       
/* 3418 */       } else if (residuo.equals("SANEAMIENTO")) {
/* 3419 */         residuo = "SANEAM";
/* 3420 */         this.CANTTOTALES[13] = this.CANTTOTALES[13] + 1;
/* 3421 */         this.TONSRESIDUO[7] = this.TONSRESIDUO[7] + tonsInd;
/* 3422 */         if (this.GUIASAMPARADAS[7].equals("")) {
/* 3423 */           this.GUIASAMPARADAS[7] = guiaSola;
/*      */         } else {
/* 3425 */           this.GUIASAMPARADAS[7] = this.GUIASAMPARADAS[7] + ", " + this.GUIASAMPARADAS[7];
/*      */         }
/*      */       
/* 3428 */       } else if (residuo.equals("SEDIMENTO")) {
/* 3429 */         residuo = "SEDIMEN";
/* 3430 */         this.CANTTOTALES[14] = this.CANTTOTALES[14] + 1;
/* 3431 */         this.TONSRESIDUO[8] = this.TONSRESIDUO[8] + tonsInd;
/* 3432 */         if (this.GUIASAMPARADAS[8].equals("")) {
/* 3433 */           this.GUIASAMPARADAS[8] = guiaSola;
/*      */         } else {
/* 3435 */           this.GUIASAMPARADAS[8] = this.GUIASAMPARADAS[8] + ", " + this.GUIASAMPARADAS[8];
/*      */         } 
/*      */       } else {
/*      */         
/* 3439 */         this.OTROSRESIDUOS++;
/* 3440 */         this.TONSRESIDUO[10] = this.TONSRESIDUO[10] + tonsInd;
/* 3441 */         if (this.GUIASAMPARADAS[10].equals("")) {
/* 3442 */           this.GUIASAMPARADAS[10] = guiaSola;
/*      */         } else {
/* 3444 */           this.GUIASAMPARADAS[10] = this.GUIASAMPARADAS[10] + ", " + this.GUIASAMPARADAS[10];
/*      */         } 
/*      */       } 
/* 3447 */       if (residuo.equals("FLUIDO RECUPERADO C/TRAZAS DE ACEITE")) {
/* 3448 */         residuo = "F RECUP/TRAZAS";
/*      */       }
/* 3450 */       else if (residuo.equals("FLUIDO RECUPERADO")) {
/* 3451 */         residuo = "F RECUP";
/*      */       } 
/* 3453 */       this.REGIS[j][0] = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3454 */       this.REGIS[j][1] = fechaCorta;
/* 3455 */       this.REGIS[j][2] = serv;
/* 3456 */       this.REGIS[j][3] = residuo;
/* 3457 */       this.REGIS[j][4] = String.valueOf(this.jTable1.getValueAt(j, 5));
/* 3458 */       this.REGIS[j][5] = String.valueOf(this.jTable1.getValueAt(j, 8));
/* 3459 */       this.REGIS[j][6] = String.valueOf(this.jTable1.getValueAt(j, 9));
/* 3460 */       this.REGIS[j][7] = String.valueOf(this.jTable1.getValueAt(j, 10));
/* 3461 */       this.REGIS[j][8] = String.valueOf(this.jTable1.getValueAt(j, 11));
/* 3462 */       this.REGIS[j][9] = String.valueOf(this.jTable1.getValueAt(j, 12));
/* 3463 */       this.REGIS[j][10] = String.valueOf(this.jTable1.getValueAt(j, 13));
/*      */     } 
/*      */     
/* 3466 */     if (this.jTextField2.isEnabled()) {
/* 3467 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3468 */       String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 3469 */       String año = cadenaFecha1.substring(0, 4);
/* 3470 */       String mes = cadenaFecha1.substring(4, 6);
/* 3471 */       String dia = cadenaFecha1.substring(6, 8);
/* 3472 */       String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 3473 */       String cliente = "<GENERAL>";
/* 3474 */       String equipo = "<GENERAL>";
/* 3475 */       String plat = "<GENERAL>";
/* 3476 */       String pozo = "<GENERAL>";
/* 3477 */       String valorCliente = "0";
/*      */       
/* 3479 */       if (this.jComboBox4.getSelectedIndex() != 0) {
/* 3480 */         cliente = String.valueOf(this.jComboBox4.getSelectedItem());
/* 3481 */         valorCliente = this.IDCLIENTE[this.jComboBox4.getSelectedIndex() - 1];
/*      */       } 
/* 3483 */       if (this.jComboBox21.getSelectedIndex() != 0) {
/* 3484 */         equipo = String.valueOf(this.jComboBox21.getSelectedItem());
/*      */       }
/* 3486 */       if (this.jComboBox22.getSelectedIndex() != 0) {
/* 3487 */         plat = String.valueOf(this.jComboBox22.getSelectedItem());
/*      */       }
/* 3489 */       if (this.jComboBox23.getSelectedIndex() != 0) {
/* 3490 */         pozo = String.valueOf(this.jComboBox23.getSelectedItem());
/*      */       }
/* 3492 */       if (this.jButton14.getText().equals("Guardar")) {
/* 3493 */         this.con.inserSinMsj("insert into prefacturas(folio,fecha,cliente,equipo,plat,pozo,tons,numViajes,tipo,actual,estatus,clave_gene,nombre_usu,pedido)values('" + this.jTextField2.getText().toUpperCase() + "'," + fechaCompleta + ",'" + cliente + "','" + equipo + "','" + plat + "','" + pozo + "'," + this.TONS + "," + this.jTable1.getRowCount() + "," + this.TIPOREPOR + ",'<Prefactura Ingresada>','ACTIVA'," + valorCliente + ",'" + this.USUARIO + "','" + this.jTextField4.getText() + "')");
/* 3494 */         this.con.consultar("max(numInterPre)", "prefacturas", "");
/* 3495 */         this.PREFAC = this.con.Campo;
/* 3496 */         this.mensajeTry.guardarConf("Se ha creado un nuevo reporte interno, USUARIO: " + this.USUARIO, "Nuevo Reporte Interno (" + this.PREFAC + ")", "INFO", "Facturacion");
/*      */       } else {
/*      */         
/* 3499 */         this.con.inserSinMsj("update prefacturas set folio='" + this.jTextField2.getText() + "',fecha=" + fechaCompleta + ", cliente='" + cliente + "', equipo='" + equipo + "', plat='" + plat + "', pozo='" + pozo + "', tons=" + this.TONS + ", numViajes=" + this.jTable1.getRowCount() + ", tipo=" + this.TIPOREPOR + ", nombre_usu='" + this.USUARIO + "',pedido='" + this.jTextField4.getText() + "' where numInterPre=" + this.PREFAC);
/*      */       } 
/* 3501 */       for (int k = 0; k < this.jTable1.getRowCount(); k++) {
/* 3502 */         this.con.inserSinMsj("update guias set comen_pre='" + String.valueOf(this.jTable1.getValueAt(k, 13)) + "',factura=" + this.PREFAC + ",pedido='' where num_guia = '" + String.valueOf(this.jTable1.getValueAt(k, 0)) + "'");
/* 3503 */         this.mensajeTry.guardarConf("Se ha modificado un reporte interno, USUARIO: " + this.USUARIO, "Reporte Interno Modificado (" + this.PREFAC + ")", "INFO", "Facturacion");
/*      */       } 
/* 3505 */       consultar();
/*      */     } 
/* 3507 */     if (this.jButton14.getText().equals("Imprimir")) {
/* 3508 */       ImprimirFacturas3 imp = new ImprimirFacturas3();
/* 3509 */       imp.recibeDatos();
/*      */     } else {
/*      */       
/* 3512 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "Los datos han sido guardados satisfactoriamente\n¿Deseas imprimir los datos del reporte?", "Imprimir Reporte", 0, 3, this.PREG);
/* 3513 */       if (res == 0) {
/* 3514 */         ImprimirFacturas3 imp = new ImprimirFacturas3();
/* 3515 */         imp.recibeDatos();
/*      */       } 
/*      */     } 
/* 3518 */     this.jFrame1.setVisible(false);
/*      */   }
/*      */   
/*      */   public void pasarTodos() {
/* 3522 */     dameModelo();
/* 3523 */     for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 3524 */       boolean esta = false;
/* 3525 */       String guia = String.valueOf(this.jTable3.getValueAt(i, 0));
/* 3526 */       String serv = String.valueOf(this.jTable3.getValueAt(i, 2));
/* 3527 */       String mani = "";
/*      */       
/* 3529 */       for (int j = 0; j < this.jTable1.getRowCount(); j++) {
/* 3530 */         String valor = String.valueOf(this.jTable1.getValueAt(j, 0));
/* 3531 */         if (valor.equals(guia)) {
/* 3532 */           esta = true;
/*      */         }
/*      */       } 
/* 3535 */       if (!esta) {
/* 3536 */         if (serv.equals("SERVICIO INTEGRAL")) {
/* 3537 */           this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + guia + "'");
/* 3538 */           if (this.encontrado) {
/* 3539 */             mani = this.con.Campo;
/*      */           } else {
/* 3541 */             this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + guia + "'");
/* 3542 */             if (this.encontrado) {
/* 3543 */               mani = this.con.Campo;
/*      */             }
/*      */           } 
/*      */         } 
/* 3547 */         Object[] reg = null;
/* 3548 */         if (this.TIPOREPOR == 0) {
/* 3549 */           if (this.jButton14.getText().equals("Modificar")) {
/* 3550 */             reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), "", mani };
/*      */           } else {
/*      */             
/* 3553 */             reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), "", this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), mani, "" };
/*      */           }
/*      */         
/* 3556 */         } else if (this.TIPOREPOR == 1) {
/* 3557 */           if (this.jButton14.getText().equals("Modificar")) {
/* 3558 */             reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), this.jTable3.getValueAt(i, 9), this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), "", mani };
/*      */           } else {
/*      */             
/* 3561 */             reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), this.jTable3.getValueAt(i, 9), this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), mani, "" };
/*      */           }
/*      */         
/*      */         }
/* 3565 */         else if (this.jButton14.getText().equals("Modificar")) {
/* 3566 */           reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), "", mani };
/*      */         } else {
/*      */           
/* 3569 */           reg = new Object[] { this.jTable3.getValueAt(i, 0), this.jTable3.getValueAt(i, 1), this.jTable3.getValueAt(i, 2), this.jTable3.getValueAt(i, 3), this.jTable3.getValueAt(i, 4), this.jTable3.getValueAt(i, 6), this.jTable3.getValueAt(i, 7), this.jTable3.getValueAt(i, 8), this.jTable3.getValueAt(i, 10), this.jTable3.getValueAt(i, 11), this.jTable3.getValueAt(i, 12), this.jTable3.getValueAt(i, 13), mani, "" };
/*      */         } 
/*      */         
/* 3572 */         this.MODELOPREFACTURA.addRow(reg);
/* 3573 */         this.jTable1.setModel(this.MODELOPREFACTURA);
/* 3574 */         this.VIAJESTOT++;
/* 3575 */         String ton = String.valueOf(this.jTable3.getValueAt(i, 11));
/* 3576 */         this.TONS = Double.valueOf(this.TONS.doubleValue() + Double.parseDouble(ton));
/*      */       } 
/*      */     } 
/* 3579 */     this.PRESIONADO = true;
/* 3580 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   public void salir() {
/* 3584 */     String msj = "Has agregado viajes a un nuevo reporte, si cierras la ventana se perderán los datos";
/* 3585 */     if (this.jButton14.getText().equals("Modificar")) {
/* 3586 */       msj = "Los datos del reporte han sido modificado, si cierras el reporte se perderá la información";
/*      */     }
/* 3588 */     if ((this.jButton14.getText().equals("Imprimir") || this.jButton14.getText().equals("Modificar")) && this.PRESIONADO) {
/* 3589 */       int res = JOptionPane.showConfirmDialog(this.jFrame1, "<html><font color='RED'><b>" + msj + "</b></font><br>¿Deseas guardar la informacion?</html>", "Cerrar Reporte", 1, 3, this.PREG);
/* 3590 */       if (res == 0) {
/* 3591 */         if (this.jButton14.getText().equals("Modificar")) {
/* 3592 */           this.con.inserSinMsj("update guias set estatus='<Pagada Al Operador>', factura=0 where factura=" + this.PREFAC);
/* 3593 */           if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 3594 */             imprimir1();
/*      */           } else {
/* 3596 */             imprimir2();
/*      */           }
/*      */         
/*      */         }
/* 3600 */         else if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 3601 */           imprimir1();
/*      */         } else {
/* 3603 */           imprimir2();
/*      */         } 
/*      */         
/* 3606 */         this.jFrame1.setVisible(false);
/*      */       }
/* 3608 */       else if (res == 1) {
/* 3609 */         this.jFrame1.setVisible(false);
/*      */       } 
/*      */     } else {
/*      */       
/* 3613 */       this.jFrame1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void quitarViaje() {
/* 3618 */     this.PRESIONADO = true;
/* 3619 */     this.VIAJESTOT--;
/* 3620 */     String ton = "";
/* 3621 */     if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 3622 */       ton = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 10));
/*      */     } else {
/*      */       
/* 3625 */       ton = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 9));
/*      */     } 
/* 3627 */     this.TONS = Double.valueOf(this.TONS.doubleValue() - Double.parseDouble(ton));
/* 3628 */     dameModelo();
/* 3629 */     this.MODELOPREFACTURA.removeRow(this.jTable1.getSelectedRow());
/* 3630 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   public void pasarGuia() {
/* 3634 */     dameModelo();
/* 3635 */     String guia = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 3636 */     String serv = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2));
/* 3637 */     String mani = "";
/* 3638 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 3639 */       String valor = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 3640 */       if (valor.equals(guia)) {
/* 3641 */         JOptionPane.showMessageDialog(this.jDialog1, "La guía que deseas insertar ya se encuentra agregada a la prefactura", "Guía Duplicada", 0, this.ADVER);
/*      */         return;
/*      */       } 
/*      */     } 
/* 3645 */     if (serv.equals("SERVICIO INTEGRAL")) {
/* 3646 */       this.encontrado = this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + guia + "'");
/* 3647 */       if (this.encontrado) {
/* 3648 */         mani = this.con.Campo;
/*      */       } else {
/* 3650 */         this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + guia + "'");
/* 3651 */         if (this.encontrado) {
/* 3652 */           mani = this.con.Campo;
/*      */         }
/*      */       } 
/*      */     } 
/* 3656 */     Object[] reg = null;
/* 3657 */     if (this.TIPOREPOR == 0) {
/* 3658 */       if (this.jButton14.getText().equals("Modificar")) {
/* 3659 */         reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), "", this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), "", mani };
/*      */       } else {
/*      */         
/* 3662 */         reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), "", this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), mani, "" };
/*      */       }
/*      */     
/* 3665 */     } else if (this.TIPOREPOR == 1) {
/* 3666 */       if (this.jButton14.getText().equals("Modificar")) {
/* 3667 */         reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 9), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), "", mani };
/*      */       } else {
/*      */         
/* 3670 */         reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 9), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), mani, "" };
/*      */       }
/*      */     
/*      */     }
/* 3674 */     else if (this.jButton14.getText().equals("Modificar")) {
/* 3675 */       reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), "", mani };
/*      */     } else {
/*      */       
/* 3678 */       reg = new Object[] { this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 10), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 12), this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13), mani, "" };
/*      */     } 
/*      */     
/* 3681 */     this.MODELOPREFACTURA.addRow(reg);
/* 3682 */     this.jTable1.setModel(this.MODELOPREFACTURA);
/* 3683 */     this.VIAJESTOT++;
/* 3684 */     String ton = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 11));
/* 3685 */     this.TONS = Double.valueOf(this.TONS.doubleValue() + Double.parseDouble(ton));
/* 3686 */     this.PRESIONADO = true;
/*      */     
/* 3688 */     this.TONS = Double.valueOf(Math.rint(this.TONS.doubleValue() * 1000.0D) / 1000.0D);
/* 3689 */     this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.VIAJESTOT + "</HTML>");
/* 3690 */     this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.TONS + "</HTML>");
/*      */   }
/*      */   public void dameModelo() {
/* 3693 */     this.MODELOPREFACTURA = (DefaultTableModel)this.jTable1.getModel();
/*      */   }
/*      */   public void bloquearTabla() {
/* 3696 */     String[] COLUMNAS = null;
/* 3697 */     if (this.TIPOREPOR == 0) {
/* 3698 */       COLUMNAS = new String[] { "Guía", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ped", "Ticket", "Tons.", "Eco/Trac", "Eco/Rem", "Manifiesto", "Comentario" };
/* 3699 */     } else if (this.TIPOREPOR == 1) {
/* 3700 */       COLUMNAS = new String[] { "Guía", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "RSP", "Ticket", "Tons.", "Eco/Trac", "Eco/Rem", "Manifiesto", "Comentario" };
/*      */     } else {
/* 3702 */       COLUMNAS = new String[] { "Guía", "Fecha", "Servicio", "Residuo", "Cliente", "Equipo", "Plataforma", "Pozo", "Ticket", "Tons.", "Eco/Trac", "Eco/Rem", "Manifiesto", "Comentario" };
/*      */     } 
/* 3704 */     String[][] registros = new String[this.jTable1.getRowCount()][this.jTable1.getColumnCount()];
/* 3705 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 3706 */       for (int j = 0; j < this.jTable1.getColumnCount(); j++) {
/* 3707 */         if (this.jTable1.getValueAt(i, j) == null) {
/* 3708 */           registros[i][j] = "";
/*      */         } else {
/* 3710 */           registros[i][j] = String.valueOf(this.jTable1.getValueAt(i, j));
/*      */         } 
/*      */       } 
/*      */     } 
/* 3714 */     this.jTable1.setModel(new DefaultTableModel((Object[][])registros, (Object[])COLUMNAS)
/*      */         {
/*      */           
/* 3717 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3721 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3724 */     this.jTable1.setSelectionMode(0);
/* 3725 */     this.jTable1.setAutoCreateRowSorter(true);
/* 3726 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 3728 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(60);
/* 3729 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
/* 3730 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(110);
/* 3731 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(110);
/* 3732 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(110);
/* 3733 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
/*      */ 
/*      */     
/* 3736 */     this.jTable1.getColumnModel().getColumn(9).setMinWidth(50);
/* 3737 */     this.jTable1.getColumnModel().getColumn(9).setMaxWidth(50);
/* 3738 */     this.jTable1.getColumnModel().getColumn(10).setMinWidth(50);
/* 3739 */     this.jTable1.getColumnModel().getColumn(10).setMaxWidth(50);
/* 3740 */     this.jTable1.getColumnModel().getColumn(11).setMinWidth(60);
/* 3741 */     this.jTable1.getColumnModel().getColumn(11).setMaxWidth(60);
/* 3742 */     this.jTable1.getColumnModel().getColumn(12).setMinWidth(60);
/* 3743 */     this.jTable1.getColumnModel().getColumn(12).setMaxWidth(60);
/* 3744 */     if (this.TIPOREPOR == 0 || this.TIPOREPOR == 1) {
/* 3745 */       this.jTable1.getColumnModel().getColumn(13).setMinWidth(95);
/* 3746 */       this.jTable1.getColumnModel().getColumn(13).setMaxWidth(95);
/* 3747 */       this.jTable1.getColumnModel().getColumn(14).setMinWidth(200);
/* 3748 */       this.jTable1.getColumnModel().getColumn(14).setMaxWidth(200);
/*      */     } else {
/* 3750 */       this.jTable1.getColumnModel().getColumn(12).setMinWidth(120);
/* 3751 */       this.jTable1.getColumnModel().getColumn(12).setMaxWidth(120);
/* 3752 */       this.jTable1.getColumnModel().getColumn(13).setMinWidth(150);
/* 3753 */       this.jTable1.getColumnModel().getColumn(13).setMaxWidth(150);
/*      */     } 
/* 3755 */     this.TONS = Double.valueOf(Math.rint(this.TONS.doubleValue() * 1000.0D) / 1000.0D);
/* 3756 */     this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.VIAJESTOT + "</HTML>");
/* 3757 */     this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.TONS + "</HTML>");
/*      */   }
/*      */   
/*      */   public void prefacturas(String usu) {
/* 3761 */     this.jDateChooser1.setDate(this.fecha);
/* 3762 */     desactivarTabla();
/* 3763 */     this.USUARIO = usu;
/* 3764 */     this.panel.setViewportView(this);
/* 3765 */     privilegios();
/* 3766 */     consultar();
/*      */   }
/*      */   
/*      */   public void llenarCombos() {
/* 3770 */     String[] datos = this.con.regresaColIndex("nombre_usu", "usuarios", "where (priv='SUPER USUARIO' || priv='FACTURACION') && nombre_usu !='USUARIOADMIN1' order by nombre_usu");
/* 3771 */     this.jComboBox2.removeAllItems();
/* 3772 */     this.jComboBox2.addItem("TODOS"); int i;
/* 3773 */     for (i = 0; i < datos.length; i++) {
/* 3774 */       this.jComboBox2.addItem(datos[i]);
/*      */     }
/*      */     
/* 3777 */     datos = this.con.regresaColIndex("nombre_corto", "emp_generadora", "where clave_gene<>0 order by nombre_corto");
/* 3778 */     this.jComboBox3.removeAllItems();
/* 3779 */     this.jComboBox3.addItem("TODOS");
/* 3780 */     for (i = 0; i < datos.length; i++) {
/* 3781 */       this.jComboBox3.addItem(datos[i]);
/*      */     }
/*      */     
/* 3784 */     datos = this.con.regresaColIndex("nombre_corto", "emp_generadora", "where clave_gene<>0 and activo = 'Activado' order by nombre_corto");
/* 3785 */     this.IDCLIENTE = this.con.regresaColIndex("clave_gene", "emp_generadora", "where clave_gene<>0 and activo = 'Activado' order by nombre_corto");
/* 3786 */     this.jComboBox4.removeAllItems();
/* 3787 */     this.jComboBox20.removeAllItems();
/*      */     
/* 3789 */     this.jComboBox4.addItem("SELECCIONA UN CLIENTE...");
/* 3790 */     this.jComboBox20.addItem("SELECCIONA UN CLIENTE...");
/* 3791 */     for (i = 0; i < datos.length; i++) {
/* 3792 */       this.jComboBox4.addItem(datos[i]);
/* 3793 */       this.jComboBox20.addItem(datos[i]);
/*      */     } 
/*      */     
/* 3796 */     datos = this.con.regresaColIndex("distinct(residuo)", "llamadas_historicas", "order by residuo");
/* 3797 */     this.jComboBox5.removeAllItems();
/* 3798 */     this.jComboBox5.addItem("TODOS");
/* 3799 */     for (i = 0; i < datos.length; i++) {
/* 3800 */       this.jComboBox5.addItem(datos[i].toUpperCase());
/*      */     }
/*      */ 
/*      */     
/* 3804 */     datos = this.con.regresaColIndex("plataforma", "plataformas", "order by plataforma");
/* 3805 */     this.jComboBox8.removeAllItems();
/* 3806 */     this.jComboBox22.removeAllItems();
/* 3807 */     this.jComboBox8.addItem("TODOS");
/* 3808 */     this.jComboBox22.addItem("GENERAL");
/* 3809 */     for (i = 0; i < datos.length; i++) {
/* 3810 */       this.jComboBox8.addItem(datos[i]);
/* 3811 */       this.jComboBox22.addItem(datos[i]);
/*      */     } 
/*      */ 
/*      */     
/* 3815 */     datos = this.con.regresaColIndex("equipo", "equipos", "where clave_gene<>0  order by equipo");
/* 3816 */     this.jComboBox7.removeAllItems();
/* 3817 */     this.jComboBox21.removeAllItems();
/* 3818 */     this.jComboBox7.addItem("TODOS");
/* 3819 */     this.jComboBox21.addItem("GENERAL");
/* 3820 */     for (i = 0; i < datos.length; i++) {
/* 3821 */       this.jComboBox7.addItem(datos[i]);
/* 3822 */       this.jComboBox21.addItem(datos[i]);
/*      */     } 
/*      */ 
/*      */     
/* 3826 */     datos = this.con.regresaColIndex("nombre", "pozos", "where num_pozo<>0 order by nombre");
/* 3827 */     this.jComboBox9.removeAllItems();
/* 3828 */     this.jComboBox23.removeAllItems();
/* 3829 */     this.jComboBox9.addItem("TODOS");
/* 3830 */     this.jComboBox23.addItem("GENERAL");
/* 3831 */     for (i = 0; i < datos.length; i++) {
/* 3832 */       this.jComboBox9.addItem(datos[i]);
/* 3833 */       this.jComboBox23.addItem(datos[i]);
/*      */     } 
/*      */     
/* 3836 */     datos = this.con.regresaColIndex("distinct(tipo)", "guias", "where tipo<>'' order by tipo");
/* 3837 */     this.jComboBox6.removeAllItems();
/* 3838 */     this.jComboBox6.addItem("TODOS");
/* 3839 */     for (i = 0; i < datos.length; i++) {
/* 3840 */       this.jComboBox6.addItem(datos[i].toUpperCase());
/*      */     }
/*      */     
/* 3843 */     datos = this.con.regresaColIndex("distinct(servicio)", "guias", "where servicio<>'' order by servicio");
/* 3844 */     this.jComboBox10.removeAllItems();
/* 3845 */     this.jComboBox10.addItem("TODOS");
/* 3846 */     for (i = 0; i < datos.length; i++) {
/* 3847 */       this.jComboBox10.addItem(datos[i].toUpperCase());
/*      */     }
/*      */   }
/*      */   
/*      */   public void desactivarTabla() {
/* 3852 */     this.jLabel52.setText("<HTML><FONT COLOR=BLACK>TOTAL DE VIAJES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>0</HTML>");
/* 3853 */     this.jLabel51.setText("<HTML><FONT COLOR=BLACK>TOTAL DE TONELADAS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>0.0</HTML>");
/* 3854 */     this.MODELOPREFACTURA = new DefaultTableModel();
/* 3855 */     this.MODELOPREFACTURA.addColumn("Guía");
/* 3856 */     this.MODELOPREFACTURA.addColumn("Fecha");
/* 3857 */     this.MODELOPREFACTURA.addColumn("Servicio");
/* 3858 */     this.MODELOPREFACTURA.addColumn("Residuo");
/* 3859 */     this.MODELOPREFACTURA.addColumn("Cliente");
/* 3860 */     this.MODELOPREFACTURA.addColumn("Equipo");
/* 3861 */     this.MODELOPREFACTURA.addColumn("Plataforma");
/* 3862 */     this.MODELOPREFACTURA.addColumn("Pozo");
/* 3863 */     if (this.TIPOREPOR == 0) {
/* 3864 */       this.MODELOPREFACTURA.addColumn("PED");
/* 3865 */     } else if (this.TIPOREPOR == 1) {
/* 3866 */       this.MODELOPREFACTURA.addColumn("RSP");
/*      */     } 
/* 3868 */     this.MODELOPREFACTURA.addColumn("Ticket");
/* 3869 */     this.MODELOPREFACTURA.addColumn("Tons.");
/* 3870 */     this.MODELOPREFACTURA.addColumn("Tons.");
/* 3871 */     this.MODELOPREFACTURA.addColumn("Tons.");
/* 3872 */     this.MODELOPREFACTURA.addColumn("Eco/Trac");
/* 3873 */     this.MODELOPREFACTURA.addColumn("Eco/Rem");
/* 3874 */     this.MODELOPREFACTURA.addColumn("Manifiesto");
/* 3875 */     this.MODELOPREFACTURA.addColumn("Comentario");
/* 3876 */     this.TONS = Double.valueOf(0.0D);
/* 3877 */     this.VIAJESTOT = 0;
/* 3878 */     this.jTable1.setModel(this.MODELOPREFACTURA);
/* 3879 */     bloquearTabla();
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 3883 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3885 */             Prefacturas.this.jTextGanado(Prefacturas.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3889 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jTextField1, evt);
/*      */           }
/*      */         });
/*      */     
/* 3893 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3895 */             Prefacturas.this.jTextGanado(Prefacturas.this.jTextField7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3898 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jTextField7, evt);
/*      */           }
/*      */         });
/*      */     
/* 3902 */     this.jTextField2.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3905 */             Prefacturas.this.jTextGanado(Prefacturas.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3909 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 3912 */     this.jTextField3.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3915 */             Prefacturas.this.jTextGanado(Prefacturas.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3919 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 3922 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3924 */             Prefacturas.this.jTextGanado(Prefacturas.this.jTextField6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 3927 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 3930 */     this.jComboBox1.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3933 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3937 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 3940 */     this.jComboBox2.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3943 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3947 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 3950 */     this.jComboBox3.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3953 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3957 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 3960 */     this.jComboBox3.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3963 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3967 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 3970 */     this.jComboBox4.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3973 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3977 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 3980 */     this.jComboBox5.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3983 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3987 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox5, evt);
/*      */           }
/*      */         });
/* 3990 */     this.jComboBox6.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 3993 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3997 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox6, evt);
/*      */           }
/*      */         });
/* 4000 */     this.jComboBox7.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4003 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4007 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox7, evt);
/*      */           }
/*      */         });
/* 4010 */     this.jComboBox8.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4013 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4017 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox8, evt);
/*      */           }
/*      */         });
/* 4020 */     this.jComboBox9.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4023 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4027 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox9, evt);
/*      */           }
/*      */         });
/* 4030 */     this.jComboBox10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 4032 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox10, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 4035 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox10, evt);
/*      */           }
/*      */         });
/* 4038 */     this.jComboBox20.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4041 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox20, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4045 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox20, evt);
/*      */           }
/*      */         });
/* 4048 */     this.jComboBox21.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4051 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox21, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4055 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox21, evt);
/*      */           }
/*      */         });
/* 4058 */     this.jComboBox22.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4061 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox22, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4065 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox22, evt);
/*      */           }
/*      */         });
/* 4068 */     this.jComboBox23.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4071 */             Prefacturas.this.jTextGanado(Prefacturas.this.jComboBox23, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4075 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jComboBox23, evt);
/*      */           }
/*      */         });
/* 4078 */     this.jTextArea5.addFocusListener(new FocusAdapter()
/*      */         {
/*      */           public void focusGained(FocusEvent evt) {
/* 4081 */             Prefacturas.this.jTextGanado(Prefacturas.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 4085 */             Prefacturas.this.jTextPerdido(Prefacturas.this.jTextArea5, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 4091 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 4095 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 4099 */     this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 4100 */     if (this.con.Campo.equals("ADMINISTRADOR") || this.con.Campo.equals("FACTURACIÓN")) {
/* 4101 */       this.jComboBox2.setSelectedItem(this.USUARIO);
/* 4102 */       this.jComboBox2.setEnabled(false);
/*      */     } else {
/* 4104 */       this.jComboBox2.setEnabled(true);
/* 4105 */       this.jComboBox2.setSelectedIndex(0);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 4110 */     this.PRIMERA = true;
/* 4111 */     boolean correcto = true;
/* 4112 */     if (this.jDateChooser11.getDate() == null) {
/* 4113 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 4114 */       if (res == 0) {
/* 4115 */         this.jDateChooser11.setDate(this.fechaActual);
/* 4116 */         correcto = true;
/*      */       } else {
/* 4118 */         correcto = false;
/*      */       } 
/* 4120 */     } else if (this.jDateChooser12.getDate() == null) {
/* 4121 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 4122 */       if (res == 0) {
/* 4123 */         this.jDateChooser12.setDate(this.fechaActual);
/* 4124 */         correcto = true;
/*      */       } else {
/* 4126 */         correcto = false;
/*      */       } 
/* 4128 */     } else if (correcto) {
/* 4129 */       Date fecha1 = this.jDateChooser11.getDate();
/* 4130 */       Date fecha2 = this.jDateChooser12.getDate();
/*      */       
/* 4132 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4133 */       String cadenaFecha = "";
/* 4134 */       cadenaFecha = formato.format(fecha1);
/* 4135 */       String AÑO = cadenaFecha.substring(0, 4);
/* 4136 */       String MES = cadenaFecha.substring(4, 6);
/* 4137 */       String DIA = cadenaFecha.substring(6, 8);
/* 4138 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 4140 */       cadenaFecha = formato.format(fecha2);
/* 4141 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 4142 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 4143 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 4144 */       int diasTotal = diasDelMes(mm - 1, aa);
/* 4145 */       String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + "'";
/*      */       
/* 4147 */       this.jButton5.setEnabled(false);
/* 4148 */       this.jButton11.setEnabled(false);
/* 4149 */       this.jButton12.setEnabled(false);
/* 4150 */       String estatus = "";
/* 4151 */       String usuario = "";
/* 4152 */       String cliente = "";
/*      */       
/* 4154 */       if (this.jComboBox1.getSelectedIndex() != 2) {
/* 4155 */         estatus = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */       }
/* 4157 */       if (this.jComboBox2.getSelectedIndex() != 0) {
/* 4158 */         usuario = String.valueOf(this.jComboBox2.getSelectedItem());
/*      */       }
/* 4160 */       if (this.jComboBox3.getSelectedIndex() != 0) {
/* 4161 */         cliente = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */       }
/*      */ 
/*      */       
/* 4165 */       this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 4166 */             .buscarDatos(13, "NumInterPre,folio,fecha,cliente,equipo,plat,pozo,pedido,tons,numViajes,nombre_usu,estatus,actual", "prefacturas", "where estatus like '%" + estatus + "%' and nombre_usu like '%" + usuario + "%' and cliente like '%" + cliente + "%' and folio like '%" + this.jTextField1.getText() + "%' and numInterpre like'%" + this.jTextField6.getText() + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by numInterPre desc"), (Object[])new String[] { "Núm", "Folio", "Fecha", "Cliente", "Equipo", "Plataforma", "Pozo", "Pedido", "Tons", "Núm Viajes", "Responsable", "Estado", "Actual" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 4171 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false };
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4176 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 4179 */       this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable2.getRowCount() + "</HTML>");
/* 4180 */       if (this.jComboBox1.getSelectedIndex() == 2) {
/*      */ 
/*      */ 
/*      */         
/* 4184 */         this.celda.pasarInd(this.con.revisarCol(this.jTable2, "<Cancelada", 0, 12, 2));
/*      */       } else {
/*      */         
/* 4187 */         String[] arre = new String[0];
/* 4188 */         this.celda.pasarInd(arre);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 4193 */       this.celda.pasarInd2(this.con.revisarCol(this.jTable2, "<Prefactura Ingresada>", 0, 12, 0));
/*      */       
/* 4195 */       this.jTable2.setSelectionMode(0);
/* 4196 */       this.jTable2.setAutoCreateRowSorter(true);
/* 4197 */       this.jTable2.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 4199 */       this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 4200 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 4201 */       this.jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
/* 4202 */       this.jTable2.getColumnModel().getColumn(1).setMaxWidth(100);
/* 4203 */       this.jTable2.getColumnModel().getColumn(2).setPreferredWidth(70);
/* 4204 */       this.jTable2.getColumnModel().getColumn(2).setMaxWidth(70);
/* 4205 */       this.jTable2.getColumnModel().getColumn(8).setPreferredWidth(50);
/* 4206 */       this.jTable2.getColumnModel().getColumn(8).setMaxWidth(50);
/* 4207 */       this.jTable2.getColumnModel().getColumn(9).setPreferredWidth(70);
/* 4208 */       this.jTable2.getColumnModel().getColumn(9).setMaxWidth(70);
/* 4209 */       this.jTable2.getColumnModel().getColumn(12).setPreferredWidth(160);
/* 4210 */       this.jTable2.getColumnModel().getColumn(12).setMaxWidth(160);
/*      */       
/* 4212 */       this.jTable2.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 4213 */       this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 4214 */       this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 4215 */       this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 4216 */       this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 4217 */       this.jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 4218 */       this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 4219 */       this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 4220 */       this.jTable2.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 4221 */       this.jTable2.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 4222 */       this.jTable2.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 4223 */       this.jTable2.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 4224 */       this.jTable2.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarGuias() {
/* 4229 */     System.out.println("contador ---> " + this.contador);
/* 4230 */     this.contador++;
/* 4231 */     this.PRIMERAGUIAS = true;
/* 4232 */     Date fecha1 = this.jDateChooser1.getDate();
/* 4233 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4234 */     String cadenaFecha = "";
/* 4235 */     cadenaFecha = formato.format(fecha1);
/* 4236 */     String AÑO = cadenaFecha.substring(0, 4);
/* 4237 */     String MES = cadenaFecha.substring(4, 6);
/* 4238 */     String DIA = cadenaFecha.substring(6, 8);
/* 4239 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/* 4241 */     fecha1 = this.jDateChooser2.getDate();
/* 4242 */     formato = new SimpleDateFormat("yyyyMMdd");
/* 4243 */     cadenaFecha = "";
/* 4244 */     cadenaFecha = formato.format(fecha1);
/* 4245 */     AÑO = cadenaFecha.substring(0, 4);
/* 4246 */     MES = cadenaFecha.substring(4, 6);
/* 4247 */     DIA = cadenaFecha.substring(6, 8);
/* 4248 */     String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + " 23:59:59'";
/*      */     
/* 4250 */     String residuo = "";
/* 4251 */     String tipo = "";
/* 4252 */     String equipo = "";
/* 4253 */     String plat = "";
/* 4254 */     String pozo = "";
/* 4255 */     String cliente = "";
/* 4256 */     String servicio = "";
/*      */     
/* 4258 */     if (this.jComboBox5.getSelectedIndex() != 0) {
/* 4259 */       residuo = String.valueOf(this.jComboBox5.getSelectedItem());
/*      */     }
/* 4261 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 4262 */       tipo = String.valueOf(this.jComboBox6.getSelectedItem());
/*      */     }
/* 4264 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/* 4265 */       equipo = String.valueOf(this.jComboBox7.getSelectedItem());
/*      */     }
/* 4267 */     if (this.jComboBox8.getSelectedIndex() != 0) {
/* 4268 */       plat = String.valueOf(this.jComboBox8.getSelectedItem());
/*      */     }
/* 4270 */     if (this.jComboBox9.getSelectedIndex() != 0) {
/* 4271 */       pozo = String.valueOf(this.jComboBox9.getSelectedItem());
/*      */     }
/* 4273 */     if (this.jComboBox20.getSelectedIndex() != 0) {
/* 4274 */       cliente = String.valueOf(this.jComboBox20.getSelectedItem());
/*      */     }
/* 4276 */     if (this.jComboBox10.getSelectedIndex() != 0) {
/* 4277 */       servicio = String.valueOf(this.jComboBox10.getSelectedItem());
/*      */     }
/* 4279 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 4280 */           .buscarDatos(15, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,guias.tipo,equipo,plataforma,pozos.nombre,rsp,ticket,peso,num_tracto,num_rem,guias.estatus", "guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,vales", "where guias.fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_vale = vales.num_vale and guias.num_guia like '%" + this.jTextField3
/*      */ 
/*      */ 
/*      */             
/* 4284 */             .getText() + "%' and residuo like '%" + residuo + "%' and emp_generadora.nombre_corto like '%" + cliente + "%' and equipo like '%" + equipo + "%' and plataforma like '%" + plat + "%' and pozos.nombre like '%" + pozo + "%' and guias.estado ='Activa' and guias.tipo like '%" + tipo + "%' and (estatus like '%<Pagada Al Operador%' || estatus like '%<Asignada Al Operador%' || estatus like '%Sólo Cargada: En Patio%') and guias.servicio like '%" + servicio + "%' and num_tracto like '%" + this.jTextField7
/*      */             
/* 4286 */             .getText() + "%' order by guias.num_guia desc"), (Object[])new String[] { 
/*      */             "Folio", "Fecha", "Servicio", "Residuo", "Cliente", "Tipo", "Equipo", "Plataforma", "Pozo", "R.S.P.", 
/*      */             "Ticket", "Tons.", "Eco/Track", "Eco/Rem", "Estatus" })
/*      */         {
/*      */           
/* 4291 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4296 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4299 */     this.jLabel50.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable3.getRowCount() + "</HTML>");
/* 4300 */     this.celda2.pasarInd(this.con.revisarCol(this.jTable3, "<Asignada Al Operador", 0, 14, 2));
/*      */     
/* 4302 */     this.jTable3.setSelectionMode(0);
/* 4303 */     this.jTable3.setAutoCreateRowSorter(true);
/* 4304 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 4306 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 4307 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 4308 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 4309 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 4310 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 4311 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 4312 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 4313 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 4314 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 4315 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 4316 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 4317 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 4318 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 4319 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda2);
/* 4320 */     this.jTable3.getColumnModel().getColumn(14).setCellRenderer(this.celda2);
/*      */   }
/*      */   public class ImprimirFacturas implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA; int renglonGuias;
/*      */     int[] PXCOL;
/*      */     
/*      */     public ImprimirFacturas() {
/* 4326 */       this.g2 = null;
/* 4327 */       this.Pag = 0;
/*      */       
/* 4329 */       this.linesPerPage = 50;
/* 4330 */       this.orientacion = 0;
/* 4331 */       this.X = 0.0D;
/* 4332 */       this.Y = 0.0D;
/* 4333 */       this.YINICIA = 100;
/* 4334 */       this.renglonGuias = 0;
/*      */       
/* 4336 */       this.PXCOL = new int[] { 36, 77, 120, 190, 255, 317, 349, 380, 412, 442, 498 };
/*      */     }
/*      */     private void initTextLines() {
/* 4339 */       if (this.textLines == null) {
/* 4340 */         this.Lineas = Prefacturas.this.LINEAS;
/* 4341 */         int numLines = this.Lineas.length;
/* 4342 */         this.textLines = new String[numLines];
/* 4343 */         for (int i = 0; i < numLines; i++) {
/* 4344 */           this.textLines[i] = this.Lineas[i];
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 4350 */       Font font = new Font("Serif", 0, 8);
/* 4351 */       FontMetrics metrics = g.getFontMetrics(font);
/* 4352 */       int lineHeight = metrics.getHeight();
/* 4353 */       if (this.pageBreaks == null) {
/* 4354 */         initTextLines();
/* 4355 */         this.orientacion = pf.getOrientation();
/* 4356 */         if (pf.getOrientation() == 1) {
/* 4357 */           this.renglonGuias = 12;
/* 4358 */           this.linesPerPage = 35;
/* 4359 */           this.X = pf.getWidth();
/* 4360 */           this.Y = pf.getHeight();
/*      */         } else {
/* 4362 */           this.renglonGuias = 17;
/* 4363 */           this.linesPerPage = 22;
/* 4364 */           this.X = pf.getWidth();
/* 4365 */           this.Y = pf.getHeight();
/*      */         } 
/* 4367 */         int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 4368 */         this.Pag = numBreaks;
/* 4369 */         this.pageBreaks = new int[numBreaks];
/* 4370 */         for (int b = 0; b < numBreaks; b++) {
/* 4371 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 4374 */       if (pageIndex > this.pageBreaks.length) {
/* 4375 */         return 1;
/*      */       }
/* 4377 */       Graphics2D g2d = (Graphics2D)g;
/* 4378 */       this.g2 = g;
/* 4379 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 4380 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 4381 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 4382 */       encabezado();
/* 4383 */       int y = this.YINICIA + 5;
/* 4384 */       int lineas = 0;
/*      */       
/* 4386 */       for (int line = start; line < end; line++) {
/* 4387 */         y += 16;
/* 4388 */         int Xempe = 35;
/* 4389 */         String valor = "";
/* 4390 */         if (line < 9) {
/* 4391 */           valor = "0" + line + 1;
/*      */         } else {
/* 4393 */           valor = "" + line + 1;
/*      */         } 
/* 4395 */         g.drawString(valor, 20, y);
/* 4396 */         this.g2.drawString(Prefacturas.this.REGIS[line][0], this.PXCOL[0], y);
/* 4397 */         this.g2.drawString(Prefacturas.this.REGIS[line][1], this.PXCOL[1], y);
/* 4398 */         this.g2.drawString(Prefacturas.this.REGIS[line][2], this.PXCOL[2], y);
/* 4399 */         this.g2.drawString(Prefacturas.this.REGIS[line][3], this.PXCOL[3], y);
/* 4400 */         this.g2.drawString(Prefacturas.this.REGIS[line][4], this.PXCOL[4], y);
/* 4401 */         this.g2.drawString(Prefacturas.this.REGIS[line][5], this.PXCOL[5], y);
/* 4402 */         this.g2.drawString(Prefacturas.this.REGIS[line][6], this.PXCOL[6], y);
/* 4403 */         this.g2.drawString(Prefacturas.this.REGIS[line][7], this.PXCOL[7], y);
/* 4404 */         this.g2.drawString(Prefacturas.this.REGIS[line][8], this.PXCOL[8], y);
/* 4405 */         this.g2.drawString(Prefacturas.this.REGIS[line][9], this.PXCOL[9], y);
/* 4406 */         this.g2.drawString(Prefacturas.this.REGIS[line][10], this.PXCOL[10], y);
/* 4407 */         y += 2;
/* 4408 */         lineas = y;
/* 4409 */         this.g2.drawLine(18, y, (int)this.X - 47, y);
/* 4410 */         this.g2.drawLine(this.PXCOL[1] - 3, 106, this.PXCOL[1] - 3, y);
/* 4411 */         this.g2.drawLine(this.PXCOL[2] - 3, 106, this.PXCOL[2] - 3, y);
/* 4412 */         this.g2.drawLine(this.PXCOL[3] - 3, 106, this.PXCOL[3] - 3, y);
/* 4413 */         this.g2.drawLine(this.PXCOL[4] - 3, 106, this.PXCOL[4] - 3, y);
/* 4414 */         this.g2.drawLine(this.PXCOL[5] - 3, 106, this.PXCOL[5] - 3, y);
/* 4415 */         this.g2.drawLine(this.PXCOL[6] - 3, 106, this.PXCOL[6] - 3, y);
/* 4416 */         this.g2.drawLine(this.PXCOL[7] - 3, 106, this.PXCOL[7] - 3, y);
/* 4417 */         this.g2.drawLine(this.PXCOL[8] - 3, 106, this.PXCOL[8] - 3, y);
/* 4418 */         this.g2.drawLine(this.PXCOL[9] - 3, 106, this.PXCOL[9] - 3, y);
/* 4419 */         this.g2.drawLine(this.PXCOL[10] - 3, 106, this.PXCOL[10] - 3, y);
/*      */       } 
/* 4421 */       this.g2.drawLine(34, this.YINICIA + 5, 34, lineas);
/* 4422 */       this.g2.drawLine(18, this.YINICIA + 5, 18, lineas);
/* 4423 */       this.g2.drawLine((int)this.X - 47, this.YINICIA + 5, (int)this.X - 47, lineas);
/* 4424 */       if (this.orientacion == 1) {
/* 4425 */         g.drawString("Página " + pageIndex + 1, 538, 760);
/*      */       } else {
/* 4427 */         g.drawString("Página " + pageIndex + 1, 715, 570);
/*      */       } 
/* 4429 */       Font fuente = new Font("Dialog", 0, 7);
/* 4430 */       this.g2.setFont(fuente);
/* 4431 */       if (this.Pag == pageIndex) {
/* 4432 */         this.g2.drawLine(18, lineas + 17, (int)this.X - 47, lineas + 17);
/* 4433 */         this.g2.drawLine(18, lineas + 19, (int)this.X - 47, lineas + 19);
/* 4434 */         lineas += 30;
/* 4435 */         if (Prefacturas.this.CANTTOTALES[6] != 0) {
/* 4436 */           fuente = new Font("Dialog", 1, 7);
/* 4437 */           this.g2.setFont(fuente);
/* 4438 */           this.g2.drawString("A de Fractura: " + Math.rint(Prefacturas.this.TONSRESIDUO[0] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4439 */           fuente = new Font("Dialog", 0, 7);
/* 4440 */           this.g2.setFont(fuente);
/* 4441 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[0] + "}", 110, lineas);
/* 4442 */           lineas += 15;
/*      */         } 
/* 4444 */         if (Prefacturas.this.CANTTOTALES[7] != 0) {
/* 4445 */           fuente = new Font("Dialog", 1, 7);
/* 4446 */           this.g2.setFont(fuente);
/* 4447 */           this.g2.drawString("A Residual: " + Math.rint(Prefacturas.this.TONSRESIDUO[1] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4448 */           fuente = new Font("Dialog", 0, 7);
/* 4449 */           this.g2.setFont(fuente);
/* 4450 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[1] + "}", 100, lineas);
/* 4451 */           lineas += 15;
/*      */         } 
/* 4453 */         if (Prefacturas.this.CANTTOTALES[8] != 0) {
/* 4454 */           fuente = new Font("Dialog", 1, 7);
/* 4455 */           this.g2.setFont(fuente);
/* 4456 */           this.g2.drawString("Lodo B Aceite: " + Math.rint(Prefacturas.this.TONSRESIDUO[2] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4457 */           fuente = new Font("Dialog", 0, 7);
/* 4458 */           this.g2.setFont(fuente);
/* 4459 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[2] + "}", 115, lineas);
/* 4460 */           lineas += 15;
/*      */         } 
/* 4462 */         if (Prefacturas.this.CANTTOTALES[9] != 0) {
/* 4463 */           fuente = new Font("Dialog", 1, 7);
/* 4464 */           this.g2.setFont(fuente);
/* 4465 */           this.g2.drawString("Lodo B Agua: " + Math.rint(Prefacturas.this.TONSRESIDUO[3] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4466 */           fuente = new Font("Dialog", 0, 7);
/* 4467 */           this.g2.setFont(fuente);
/* 4468 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[3] + "}", 115, lineas);
/* 4469 */           lineas += 15;
/*      */         } 
/* 4471 */         if (Prefacturas.this.CANTTOTALES[10] != 0) {
/* 4472 */           fuente = new Font("Dialog", 1, 7);
/* 4473 */           this.g2.setFont(fuente);
/* 4474 */           this.g2.drawString("Recorte B Aceite: " + Math.rint(Prefacturas.this.TONSRESIDUO[4] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4475 */           fuente = new Font("Dialog", 0, 7);
/* 4476 */           this.g2.setFont(fuente);
/* 4477 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[4] + "}", 125, lineas);
/* 4478 */           lineas += 15;
/*      */         } 
/* 4480 */         if (Prefacturas.this.CANTTOTALES[11] != 0) {
/* 4481 */           fuente = new Font("Dialog", 1, 7);
/* 4482 */           this.g2.setFont(fuente);
/* 4483 */           this.g2.drawString("Recorte B Agua: " + Math.rint(Prefacturas.this.TONSRESIDUO[5] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4484 */           fuente = new Font("Dialog", 0, 7);
/* 4485 */           this.g2.setFont(fuente);
/* 4486 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[5] + "}", 120, lineas);
/* 4487 */           lineas += 15;
/*      */         } 
/* 4489 */         if (Prefacturas.this.CANTTOTALES[12] != 0) {
/* 4490 */           fuente = new Font("Dialog", 1, 7);
/* 4491 */           this.g2.setFont(fuente);
/* 4492 */           this.g2.drawString("Salmuera: " + Math.rint(Prefacturas.this.TONSRESIDUO[6] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4493 */           fuente = new Font("Dialog", 0, 7);
/* 4494 */           this.g2.setFont(fuente);
/* 4495 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[6] + "}", 105, lineas);
/* 4496 */           lineas += 15;
/*      */         } 
/* 4498 */         if (Prefacturas.this.CANTTOTALES[13] != 0) {
/* 4499 */           fuente = new Font("Dialog", 1, 7);
/* 4500 */           this.g2.setFont(fuente);
/* 4501 */           this.g2.drawString("Saneamiento: " + Math.rint(Prefacturas.this.TONSRESIDUO[7] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4502 */           fuente = new Font("Dialog", 0, 7);
/* 4503 */           this.g2.setFont(fuente);
/* 4504 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[7] + "}", 110, lineas);
/* 4505 */           lineas += 15;
/*      */         } 
/* 4507 */         if (Prefacturas.this.CANTTOTALES[14] != 0) {
/* 4508 */           fuente = new Font("Dialog", 1, 7);
/* 4509 */           this.g2.setFont(fuente);
/* 4510 */           this.g2.drawString("Sedimento: " + Math.rint(Prefacturas.this.TONSRESIDUO[8] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4511 */           fuente = new Font("Dialog", 0, 7);
/* 4512 */           this.g2.setFont(fuente);
/* 4513 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[8] + "}", 105, lineas);
/* 4514 */           lineas += 15;
/*      */         } 
/* 4516 */         if (Prefacturas.this.CANTTOTALES[15] != 0) {
/* 4517 */           fuente = new Font("Dialog", 1, 7);
/* 4518 */           this.g2.setFont(fuente);
/* 4519 */           this.g2.drawString("Fletes - Varios: " + Math.rint(Prefacturas.this.TONSRESIDUO[9] * 1000.0D) / 1000.0D + " Tons ", 20, lineas);
/* 4520 */           fuente = new Font("Dialog", 0, 7);
/* 4521 */           this.g2.setFont(fuente);
/* 4522 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[9] + "}", 100, lineas);
/* 4523 */           lineas += 15;
/*      */         } 
/* 4525 */         if (Prefacturas.this.OTROSRESIDUOS != 0) {
/* 4526 */           fuente = new Font("Dialog", 1, 7);
/* 4527 */           this.g2.setFont(fuente);
/* 4528 */           this.g2.drawString("Otros: " + Math.rint(Prefacturas.this.TONSRESIDUO[10] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4529 */           fuente = new Font("Dialog", 0, 7);
/* 4530 */           this.g2.setFont(fuente);
/* 4531 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[10] + "}", 95, lineas);
/* 4532 */           lineas += 15;
/*      */         } 
/*      */       } 
/* 4535 */       this.g2.setColor(Color.WHITE);
/* 4536 */       this.g2.fillRect((int)this.X - 46, 12, (int)this.X - 46, lineas);
/* 4537 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 4541 */       Font fuente = new Font("Dialog", 0, 8);
/* 4542 */       this.g2.setFont(fuente);
/* 4543 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 4544 */       Image img = imagen.getImage();
/* 4545 */       this.g2.drawImage(img, 16, 6, 45, 45, null);
/* 4546 */       fuente = new Font("Times New Roman", 1, 19);
/* 4547 */       this.g2.setFont(fuente);
/* 4548 */       this.g2.drawString("GRUPO FORSIS - " + Prefacturas.this.base, 220, 20);
/* 4549 */       fuente = new Font("Dialog", 0, 16);
/* 4550 */       this.g2.setFont(fuente);
/* 4551 */       this.g2.drawString("REPORTE INTERNO DE PREFACTURA", 205, 39);
/*      */       
/* 4553 */       fuente = new Font("Dialog", 2, 9);
/* 4554 */       this.g2.setFont(fuente);
/* 4555 */       this.g2.drawString("FOLIO Ó REF: " + Prefacturas.this.jTextField2.getText().toUpperCase(), 65, 51);
/*      */       
/* 4557 */       fuente = new Font("Dialog", 0, 8);
/* 4558 */       this.g2.setFont(fuente);
/*      */       
/* 4560 */       this.g2.drawLine(25, 53, (int)this.X - 47, 53);
/* 4561 */       this.g2.drawLine(25, 56, (int)this.X - 47, 56);
/*      */       
/* 4563 */       this.g2.drawLine(25, this.YINICIA - 15, (int)this.X - 47, this.YINICIA - 15);
/* 4564 */       this.g2.drawLine(25, this.YINICIA - 18, (int)this.X - 47, this.YINICIA - 18);
/*      */       
/* 4566 */       Date fecha1 = Prefacturas.this.jDateChooser4.getDate();
/* 4567 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4568 */       String cadenaFecha = "";
/* 4569 */       cadenaFecha = formato.format(fecha1);
/* 4570 */       String AÑO = cadenaFecha.substring(0, 4);
/* 4571 */       String MES = cadenaFecha.substring(4, 6);
/* 4572 */       String DIA = cadenaFecha.substring(6, 8);
/* 4573 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/* 4574 */       this.g2.drawString(fechaCompleta1, (int)this.X - 100, 45);
/* 4575 */       this.g2.drawString("CLIENTE:                                                             PEDIDO:", 35, 66);
/* 4576 */       this.g2.drawString("EQUIPO:                                                              PLATAFORMA:                                                        POZO:                                                    TONELADAS: ", 35, 78);
/* 4577 */       String cliente = "GENERAL";
/* 4578 */       String equipo = "GENERAL";
/* 4579 */       String plat = "GENERAL";
/* 4580 */       String pozo = "GENERAL";
/* 4581 */       if (Prefacturas.this.jComboBox4.getSelectedIndex() != 0) {
/* 4582 */         cliente = String.valueOf(Prefacturas.this.jComboBox4.getSelectedItem());
/*      */       }
/* 4584 */       if (Prefacturas.this.jComboBox21.getSelectedIndex() != 0) {
/* 4585 */         equipo = String.valueOf(Prefacturas.this.jComboBox21.getSelectedItem());
/*      */       }
/* 4587 */       if (Prefacturas.this.jComboBox22.getSelectedIndex() != 0) {
/* 4588 */         plat = String.valueOf(Prefacturas.this.jComboBox22.getSelectedItem());
/*      */       }
/* 4590 */       if (Prefacturas.this.jComboBox23.getSelectedIndex() != 0) {
/* 4591 */         pozo = String.valueOf(Prefacturas.this.jComboBox23.getSelectedItem());
/*      */       }
/* 4593 */       fuente = new Font("Dialog", 1, 8);
/* 4594 */       this.g2.setFont(fuente);
/* 4595 */       this.g2.drawString(cliente, 85, 66);
/* 4596 */       this.g2.drawString(pozo, 430, 78);
/* 4597 */       this.g2.drawString(Prefacturas.this.jTextField4.getText().toUpperCase(), 275, 66);
/*      */       
/* 4599 */       fuente = new Font("Dialog", 1, 8);
/* 4600 */       this.g2.setFont(fuente);
/* 4601 */       this.g2.drawString("" + Prefacturas.this.TONS, 600, 78);
/* 4602 */       fuente = new Font("Dialog", 0, 8);
/* 4603 */       this.g2.setFont(fuente);
/* 4604 */       this.g2.drawString(equipo, 85, 78);
/* 4605 */       this.g2.drawString(plat, 275, 78);
/*      */       
/* 4607 */       this.g2.setColor(Color.LIGHT_GRAY);
/* 4608 */       this.g2.fillRect(18, this.YINICIA - 8, 54, 10);
/* 4609 */       this.g2.fillRect(this.PXCOL[1] - 2, this.YINICIA - 8, 40, 10);
/* 4610 */       this.g2.fillRect(this.PXCOL[2] - 2, this.YINICIA - 8, 67, 10);
/* 4611 */       this.g2.fillRect(this.PXCOL[3] - 2, this.YINICIA - 8, 62, 10);
/* 4612 */       this.g2.fillRect(this.PXCOL[4] - 2, this.YINICIA - 8, 59, 10);
/* 4613 */       this.g2.fillRect(this.PXCOL[5] - 2, this.YINICIA - 8, 29, 10);
/* 4614 */       this.g2.fillRect(this.PXCOL[6] - 2, this.YINICIA - 8, 28, 10);
/* 4615 */       this.g2.fillRect(this.PXCOL[7] - 2, this.YINICIA - 8, 29, 10);
/* 4616 */       this.g2.fillRect(this.PXCOL[8] - 2, this.YINICIA - 8, 27, 10);
/* 4617 */       this.g2.fillRect(this.PXCOL[9] - 2, this.YINICIA - 8, 53, 10);
/* 4618 */       this.g2.fillRect(this.PXCOL[10] - 2, this.YINICIA - 8, 255, 10);
/*      */       
/* 4620 */       this.g2.setColor(Color.BLACK);
/* 4621 */       fuente = new Font("Dialog", 1, 8);
/* 4622 */       this.g2.setFont(fuente);
/* 4623 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[0], this.PXCOL[0] + 3, this.YINICIA);
/* 4624 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[1], this.PXCOL[1] + 3, this.YINICIA);
/* 4625 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[2], this.PXCOL[2] + 3, this.YINICIA);
/* 4626 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[3], this.PXCOL[3] + 3, this.YINICIA);
/* 4627 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[4], this.PXCOL[4] + 3, this.YINICIA);
/* 4628 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[5], this.PXCOL[5] + 3, this.YINICIA);
/* 4629 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[6], this.PXCOL[6] + 3, this.YINICIA);
/* 4630 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[7], this.PXCOL[7] + 3, this.YINICIA);
/* 4631 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[8], this.PXCOL[8] + 3, this.YINICIA);
/* 4632 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[9], this.PXCOL[9] + 3, this.YINICIA);
/* 4633 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[10], this.PXCOL[10] + 3, this.YINICIA);
/*      */       
/* 4635 */       fuente = new Font("Dialog", 0, 7);
/* 4636 */       this.g2.setFont(fuente);
/*      */       
/* 4638 */       this.g2.drawLine(18, this.YINICIA + 3, (int)this.X - 47, this.YINICIA + 3);
/* 4639 */       this.g2.drawLine(18, this.YINICIA + 5, (int)this.X - 47, this.YINICIA + 5);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 4643 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 4644 */       job.setPrintable(this);
/*      */       
/* 4646 */       PageFormat pf = job.defaultPage();
/* 4647 */       Paper papel = pf.getPaper();
/* 4648 */       papel.setSize(612.0D, 792.0D);
/* 4649 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 4650 */       pf.setPaper(papel);
/* 4651 */       pf.setOrientation(0);
/* 4652 */       job.setPrintable(new ImprimirFacturas(), pf);
/* 4653 */       job.defaultPage(pf);
/*      */       
/* 4655 */       boolean ok = job.printDialog();
/* 4656 */       if (ok)
/*      */         try {
/* 4658 */           job.print();
/* 4659 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   class ImprimirFacturas2 implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int renglonGuias;
/*      */     int[] PXCOL;
/*      */     
/*      */     ImprimirFacturas2() {
/* 4668 */       this.g2 = null;
/* 4669 */       this.Pag = 0;
/*      */       
/* 4671 */       this.linesPerPage = 50;
/* 4672 */       this.orientacion = 0;
/* 4673 */       this.X = 0.0D;
/* 4674 */       this.Y = 0.0D;
/* 4675 */       this.YINICIA = 100;
/* 4676 */       this.renglonGuias = 0;
/*      */       
/* 4678 */       this.PXCOL = new int[] { 36, 77, 120, 175, 250, 297, 329, 360, 392, 422, 478 };
/*      */     }
/*      */     private void initTextLines() {
/* 4681 */       if (this.textLines == null) {
/* 4682 */         this.Lineas = Prefacturas.this.LINEAS;
/* 4683 */         int numLines = this.Lineas.length;
/* 4684 */         this.textLines = new String[numLines];
/* 4685 */         for (int i = 0; i < numLines; i++) {
/* 4686 */           this.textLines[i] = this.Lineas[i];
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 4692 */       Font font = new Font("Serif", 0, 8);
/* 4693 */       FontMetrics metrics = g.getFontMetrics(font);
/* 4694 */       int lineHeight = metrics.getHeight();
/* 4695 */       if (this.pageBreaks == null) {
/* 4696 */         initTextLines();
/* 4697 */         this.orientacion = pf.getOrientation();
/* 4698 */         if (pf.getOrientation() == 1) {
/* 4699 */           this.renglonGuias = 12;
/* 4700 */           this.linesPerPage = 35;
/* 4701 */           this.X = pf.getWidth();
/* 4702 */           this.Y = pf.getHeight();
/*      */         } else {
/* 4704 */           this.renglonGuias = 17;
/* 4705 */           this.linesPerPage = 22;
/* 4706 */           this.X = pf.getWidth();
/* 4707 */           this.Y = pf.getHeight();
/*      */         } 
/* 4709 */         int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 4710 */         this.Pag = numBreaks;
/* 4711 */         this.pageBreaks = new int[numBreaks];
/* 4712 */         for (int b = 0; b < numBreaks; b++) {
/* 4713 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 4716 */       if (pageIndex > this.pageBreaks.length) {
/* 4717 */         return 1;
/*      */       }
/* 4719 */       Graphics2D g2d = (Graphics2D)g;
/* 4720 */       this.g2 = g;
/* 4721 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 4722 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 4723 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 4724 */       encabezado();
/* 4725 */       int y = this.YINICIA + 5;
/* 4726 */       int lineas = 0;
/*      */       
/* 4728 */       for (int line = start; line < end; line++) {
/* 4729 */         y += 16;
/* 4730 */         int Xempe = 35;
/* 4731 */         String valor = "";
/* 4732 */         if (line < 9) {
/* 4733 */           valor = "0" + line + 1;
/*      */         } else {
/* 4735 */           valor = "" + line + 1;
/*      */         } 
/* 4737 */         g.drawString(valor, 20, y);
/* 4738 */         this.g2.drawString(Prefacturas.this.REGIS[line][0], this.PXCOL[0], y);
/* 4739 */         this.g2.drawString(Prefacturas.this.REGIS[line][1], this.PXCOL[1], y);
/* 4740 */         this.g2.drawString(Prefacturas.this.REGIS[line][2], this.PXCOL[2], y);
/* 4741 */         this.g2.drawString(Prefacturas.this.REGIS[line][3], this.PXCOL[3], y);
/* 4742 */         this.g2.drawString(Prefacturas.this.REGIS[line][4], this.PXCOL[4], y);
/* 4743 */         this.g2.drawString(Prefacturas.this.REGIS[line][5], this.PXCOL[5], y);
/* 4744 */         this.g2.drawString(Prefacturas.this.REGIS[line][6], this.PXCOL[6], y);
/* 4745 */         this.g2.drawString(Prefacturas.this.REGIS[line][7], this.PXCOL[7], y);
/* 4746 */         this.g2.drawString(Prefacturas.this.REGIS[line][8], this.PXCOL[8], y);
/* 4747 */         this.g2.drawString(Prefacturas.this.REGIS[line][9], this.PXCOL[9], y);
/* 4748 */         this.g2.drawString(Prefacturas.this.REGIS[line][10], this.PXCOL[10], y);
/* 4749 */         y += 2;
/* 4750 */         lineas = y;
/* 4751 */         this.g2.drawLine(18, y, (int)this.X - 47, y);
/* 4752 */         this.g2.drawLine(this.PXCOL[1] - 3, 106, this.PXCOL[1] - 3, y);
/* 4753 */         this.g2.drawLine(this.PXCOL[2] - 3, 106, this.PXCOL[2] - 3, y);
/* 4754 */         this.g2.drawLine(this.PXCOL[3] - 3, 106, this.PXCOL[3] - 3, y);
/* 4755 */         this.g2.drawLine(this.PXCOL[4] - 3, 106, this.PXCOL[4] - 3, y);
/* 4756 */         this.g2.drawLine(this.PXCOL[5] - 3, 106, this.PXCOL[5] - 3, y);
/* 4757 */         this.g2.drawLine(this.PXCOL[6] - 3, 106, this.PXCOL[6] - 3, y);
/* 4758 */         this.g2.drawLine(this.PXCOL[7] - 3, 106, this.PXCOL[7] - 3, y);
/* 4759 */         this.g2.drawLine(this.PXCOL[8] - 3, 106, this.PXCOL[8] - 3, y);
/* 4760 */         this.g2.drawLine(this.PXCOL[9] - 3, 106, this.PXCOL[9] - 3, y);
/* 4761 */         this.g2.drawLine(this.PXCOL[10] - 3, 106, this.PXCOL[10] - 3, y);
/*      */       } 
/* 4763 */       this.g2.drawLine(34, this.YINICIA + 5, 34, lineas);
/* 4764 */       this.g2.drawLine(18, this.YINICIA + 5, 18, lineas);
/* 4765 */       this.g2.drawLine((int)this.X - 47, this.YINICIA + 5, (int)this.X - 47, lineas);
/* 4766 */       if (this.orientacion == 1) {
/* 4767 */         g.drawString("Página " + pageIndex + 1, 538, 760);
/*      */       } else {
/* 4769 */         g.drawString("Página " + pageIndex + 1, 717, 570);
/*      */       } 
/* 4771 */       Font fuente = new Font("Dialog", 0, 7);
/* 4772 */       this.g2.setFont(fuente);
/* 4773 */       if (this.Pag == pageIndex) {
/* 4774 */         this.g2.drawLine(18, lineas + 17, (int)this.X - 47, lineas + 17);
/* 4775 */         this.g2.drawLine(18, lineas + 19, (int)this.X - 47, lineas + 19);
/* 4776 */         lineas += 30;
/* 4777 */         if (Prefacturas.this.CANTTOTALES[6] != 0) {
/* 4778 */           fuente = new Font("Dialog", 1, 7);
/* 4779 */           this.g2.setFont(fuente);
/* 4780 */           this.g2.drawString("A de Fractura: " + Math.rint(Prefacturas.this.TONSRESIDUO[0] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4781 */           fuente = new Font("Dialog", 0, 7);
/* 4782 */           this.g2.setFont(fuente);
/* 4783 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[0] + "}", 110, lineas);
/* 4784 */           lineas += 15;
/*      */         } 
/* 4786 */         if (Prefacturas.this.CANTTOTALES[7] != 0) {
/* 4787 */           fuente = new Font("Dialog", 1, 7);
/* 4788 */           this.g2.setFont(fuente);
/* 4789 */           this.g2.drawString("A Residual: " + Math.rint(Prefacturas.this.TONSRESIDUO[1] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4790 */           fuente = new Font("Dialog", 0, 7);
/* 4791 */           this.g2.setFont(fuente);
/* 4792 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[1] + "}", 100, lineas);
/* 4793 */           lineas += 15;
/*      */         } 
/* 4795 */         if (Prefacturas.this.CANTTOTALES[8] != 0) {
/* 4796 */           fuente = new Font("Dialog", 1, 7);
/* 4797 */           this.g2.setFont(fuente);
/* 4798 */           this.g2.drawString("Lodo B Aceite: " + Math.rint(Prefacturas.this.TONSRESIDUO[2] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4799 */           fuente = new Font("Dialog", 0, 7);
/* 4800 */           this.g2.setFont(fuente);
/* 4801 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[2] + "}", 115, lineas);
/* 4802 */           lineas += 15;
/*      */         } 
/* 4804 */         if (Prefacturas.this.CANTTOTALES[9] != 0) {
/* 4805 */           fuente = new Font("Dialog", 1, 7);
/* 4806 */           this.g2.setFont(fuente);
/* 4807 */           this.g2.drawString("Lodo B Agua: " + Math.rint(Prefacturas.this.TONSRESIDUO[3] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4808 */           fuente = new Font("Dialog", 0, 7);
/* 4809 */           this.g2.setFont(fuente);
/* 4810 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[3] + "}", 115, lineas);
/* 4811 */           lineas += 15;
/*      */         } 
/* 4813 */         if (Prefacturas.this.CANTTOTALES[10] != 0) {
/* 4814 */           fuente = new Font("Dialog", 1, 7);
/* 4815 */           this.g2.setFont(fuente);
/* 4816 */           this.g2.drawString("Recorte B Aceite: " + Math.rint(Prefacturas.this.TONSRESIDUO[4] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4817 */           fuente = new Font("Dialog", 0, 7);
/* 4818 */           this.g2.setFont(fuente);
/* 4819 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[4] + "}", 125, lineas);
/* 4820 */           lineas += 15;
/*      */         } 
/* 4822 */         if (Prefacturas.this.CANTTOTALES[11] != 0) {
/* 4823 */           fuente = new Font("Dialog", 1, 7);
/* 4824 */           this.g2.setFont(fuente);
/* 4825 */           this.g2.drawString("Recorte B Agua: " + Math.rint(Prefacturas.this.TONSRESIDUO[5] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4826 */           fuente = new Font("Dialog", 0, 7);
/* 4827 */           this.g2.setFont(fuente);
/* 4828 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[5] + "}", 120, lineas);
/* 4829 */           lineas += 15;
/*      */         } 
/* 4831 */         if (Prefacturas.this.CANTTOTALES[12] != 0) {
/* 4832 */           fuente = new Font("Dialog", 1, 7);
/* 4833 */           this.g2.setFont(fuente);
/* 4834 */           this.g2.drawString("Salmuera: " + Math.rint(Prefacturas.this.TONSRESIDUO[6] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4835 */           fuente = new Font("Dialog", 0, 7);
/* 4836 */           this.g2.setFont(fuente);
/* 4837 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[6] + "}", 105, lineas);
/* 4838 */           lineas += 15;
/*      */         } 
/* 4840 */         if (Prefacturas.this.CANTTOTALES[13] != 0) {
/* 4841 */           fuente = new Font("Dialog", 1, 7);
/* 4842 */           this.g2.setFont(fuente);
/* 4843 */           this.g2.drawString("Saneamiento: " + Math.rint(Prefacturas.this.TONSRESIDUO[7] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4844 */           fuente = new Font("Dialog", 0, 7);
/* 4845 */           this.g2.setFont(fuente);
/* 4846 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[7] + "}", 110, lineas);
/* 4847 */           lineas += 15;
/*      */         } 
/* 4849 */         if (Prefacturas.this.CANTTOTALES[14] != 0) {
/* 4850 */           fuente = new Font("Dialog", 1, 7);
/* 4851 */           this.g2.setFont(fuente);
/* 4852 */           this.g2.drawString("Sedimento: " + Math.rint(Prefacturas.this.TONSRESIDUO[8] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4853 */           fuente = new Font("Dialog", 0, 7);
/* 4854 */           this.g2.setFont(fuente);
/* 4855 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[8] + "}", 105, lineas);
/* 4856 */           lineas += 15;
/*      */         } 
/* 4858 */         if (Prefacturas.this.CANTTOTALES[15] != 0) {
/* 4859 */           fuente = new Font("Dialog", 1, 7);
/* 4860 */           this.g2.setFont(fuente);
/* 4861 */           this.g2.drawString("Fletes - Varios: " + Math.rint(Prefacturas.this.TONSRESIDUO[9] * 1000.0D) / 1000.0D + " Tons ", 20, lineas);
/* 4862 */           fuente = new Font("Dialog", 0, 7);
/* 4863 */           this.g2.setFont(fuente);
/* 4864 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[9] + "}", 105, lineas);
/* 4865 */           lineas += 15;
/*      */         } 
/* 4867 */         if (Prefacturas.this.OTROSRESIDUOS != 0) {
/* 4868 */           fuente = new Font("Dialog", 1, 7);
/* 4869 */           this.g2.setFont(fuente);
/* 4870 */           this.g2.drawString("Otros: " + Math.rint(Prefacturas.this.TONSRESIDUO[10] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 4871 */           fuente = new Font("Dialog", 0, 7);
/* 4872 */           this.g2.setFont(fuente);
/* 4873 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[10] + "}", 95, lineas);
/* 4874 */           lineas += 15;
/*      */         } 
/*      */       } 
/* 4877 */       this.g2.setColor(Color.WHITE);
/* 4878 */       this.g2.fillRect((int)this.X - 46, 12, (int)this.X - 46, lineas);
/* 4879 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 4883 */       Font fuente = new Font("Dialog", 0, 8);
/* 4884 */       this.g2.setFont(fuente);
/* 4885 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 4886 */       Image img = imagen.getImage();
/* 4887 */       this.g2.drawImage(img, 16, 6, 45, 45, null);
/* 4888 */       fuente = new Font("Times New Roman", 1, 19);
/* 4889 */       this.g2.setFont(fuente);
/* 4890 */       this.g2.drawString("GRUPO FORSIS - " + Prefacturas.this.base, 220, 20);
/* 4891 */       fuente = new Font("Dialog", 0, 16);
/* 4892 */       this.g2.setFont(fuente);
/* 4893 */       this.g2.drawString("REPORTE INTERNO DE PREFACTURA", 205, 39);
/*      */       
/* 4895 */       fuente = new Font("Dialog", 2, 9);
/* 4896 */       this.g2.setFont(fuente);
/* 4897 */       this.g2.drawString("FOLIO O REF: " + Prefacturas.this.jTextField2.getText().toUpperCase(), 65, 51);
/*      */       
/* 4899 */       fuente = new Font("Dialog", 0, 8);
/* 4900 */       this.g2.setFont(fuente);
/*      */       
/* 4902 */       this.g2.drawLine(25, 53, (int)this.X - 47, 53);
/* 4903 */       this.g2.drawLine(25, 56, (int)this.X - 47, 56);
/*      */       
/* 4905 */       this.g2.drawLine(25, this.YINICIA - 15, (int)this.X - 47, this.YINICIA - 15);
/* 4906 */       this.g2.drawLine(25, this.YINICIA - 18, (int)this.X - 47, this.YINICIA - 18);
/*      */       
/* 4908 */       Date fecha1 = Prefacturas.this.jDateChooser4.getDate();
/* 4909 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4910 */       String cadenaFecha = "";
/* 4911 */       cadenaFecha = formato.format(fecha1);
/* 4912 */       String AÑO = cadenaFecha.substring(0, 4);
/* 4913 */       String MES = cadenaFecha.substring(4, 6);
/* 4914 */       String DIA = cadenaFecha.substring(6, 8);
/* 4915 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/* 4916 */       this.g2.drawString(fechaCompleta1, (int)this.X - 100, 45);
/* 4917 */       this.g2.drawString("CLIENTE:", 35, 66);
/* 4918 */       this.g2.drawString("EQUIPO:                                                              PLATAFORMA:                                                        POZO:                                                    TONELADAS: ", 35, 78);
/* 4919 */       String cliente = "GENERAL";
/* 4920 */       String equipo = "GENERAL";
/* 4921 */       String plat = "GENERAL";
/* 4922 */       String pozo = "GENERAL";
/* 4923 */       if (Prefacturas.this.jComboBox4.getSelectedIndex() != 0) {
/* 4924 */         cliente = String.valueOf(Prefacturas.this.jComboBox4.getSelectedItem());
/*      */       }
/* 4926 */       if (Prefacturas.this.jComboBox21.getSelectedIndex() != 0) {
/* 4927 */         equipo = String.valueOf(Prefacturas.this.jComboBox21.getSelectedItem());
/*      */       }
/* 4929 */       if (Prefacturas.this.jComboBox22.getSelectedIndex() != 0) {
/* 4930 */         plat = String.valueOf(Prefacturas.this.jComboBox22.getSelectedItem());
/*      */       }
/* 4932 */       if (Prefacturas.this.jComboBox23.getSelectedIndex() != 0) {
/* 4933 */         pozo = String.valueOf(Prefacturas.this.jComboBox23.getSelectedItem());
/*      */       }
/* 4935 */       fuente = new Font("Dialog", 1, 8);
/* 4936 */       this.g2.setFont(fuente);
/* 4937 */       this.g2.drawString(cliente, 85, 66);
/* 4938 */       this.g2.drawString(pozo, 430, 78);
/*      */       
/* 4940 */       fuente = new Font("Dialog", 1, 8);
/* 4941 */       this.g2.setFont(fuente);
/* 4942 */       this.g2.drawString("" + Prefacturas.this.TONS, 600, 78);
/* 4943 */       fuente = new Font("Dialog", 0, 8);
/* 4944 */       this.g2.setFont(fuente);
/* 4945 */       this.g2.drawString(equipo, 85, 78);
/* 4946 */       this.g2.drawString(plat, 275, 78);
/*      */       
/* 4948 */       this.g2.setColor(Color.LIGHT_GRAY);
/* 4949 */       this.g2.fillRect(18, this.YINICIA - 8, 54, 10);
/* 4950 */       this.g2.fillRect(this.PXCOL[1] - 2, this.YINICIA - 8, 40, 10);
/* 4951 */       this.g2.fillRect(this.PXCOL[2] - 2, this.YINICIA - 8, 52, 10);
/* 4952 */       this.g2.fillRect(this.PXCOL[3] - 2, this.YINICIA - 8, 71, 10);
/* 4953 */       this.g2.fillRect(this.PXCOL[4] - 2, this.YINICIA - 8, 43, 10);
/* 4954 */       this.g2.fillRect(this.PXCOL[5] - 2, this.YINICIA - 8, 29, 10);
/* 4955 */       this.g2.fillRect(this.PXCOL[6] - 2, this.YINICIA - 8, 28, 10);
/* 4956 */       this.g2.fillRect(this.PXCOL[7] - 2, this.YINICIA - 8, 29, 10);
/* 4957 */       this.g2.fillRect(this.PXCOL[8] - 2, this.YINICIA - 8, 27, 10);
/* 4958 */       this.g2.fillRect(this.PXCOL[9] - 2, this.YINICIA - 8, 53, 10);
/* 4959 */       this.g2.fillRect(this.PXCOL[10] - 2, this.YINICIA - 8, 275, 10);
/*      */       
/* 4961 */       this.g2.setColor(Color.BLACK);
/* 4962 */       fuente = new Font("Dialog", 1, 8);
/* 4963 */       this.g2.setFont(fuente);
/* 4964 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[0], this.PXCOL[0] + 3, this.YINICIA);
/* 4965 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[1], this.PXCOL[1] + 3, this.YINICIA);
/* 4966 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[2], this.PXCOL[2] + 3, this.YINICIA);
/* 4967 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[3], this.PXCOL[3] + 3, this.YINICIA);
/* 4968 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[4], this.PXCOL[4] + 3, this.YINICIA);
/* 4969 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[5], this.PXCOL[5] + 3, this.YINICIA);
/* 4970 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[6], this.PXCOL[6] + 3, this.YINICIA);
/* 4971 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[7], this.PXCOL[7] + 3, this.YINICIA);
/* 4972 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[8], this.PXCOL[8] + 3, this.YINICIA);
/* 4973 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[9], this.PXCOL[9] + 3, this.YINICIA);
/* 4974 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[10], this.PXCOL[10] + 3, this.YINICIA);
/*      */       
/* 4976 */       fuente = new Font("Dialog", 0, 7);
/* 4977 */       this.g2.setFont(fuente);
/*      */       
/* 4979 */       this.g2.drawLine(18, this.YINICIA + 3, (int)this.X - 47, this.YINICIA + 3);
/* 4980 */       this.g2.drawLine(18, this.YINICIA + 5, (int)this.X - 47, this.YINICIA + 5);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 4984 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 4985 */       job.setPrintable(this);
/*      */       
/* 4987 */       PageFormat pf = job.defaultPage();
/* 4988 */       Paper papel = pf.getPaper();
/* 4989 */       papel.setSize(612.0D, 792.0D);
/* 4990 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 4991 */       pf.setPaper(papel);
/* 4992 */       pf.setOrientation(0);
/* 4993 */       job.setPrintable(new ImprimirFacturas2(), pf);
/* 4994 */       job.defaultPage(pf);
/*      */       
/* 4996 */       boolean ok = job.printDialog();
/* 4997 */       if (ok)
/*      */         try {
/* 4999 */           job.print();
/* 5000 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirFacturas3 implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int renglonGuias;
/*      */     int[] PXCOL;
/*      */     
/*      */     public ImprimirFacturas3() {
/* 5009 */       this.g2 = null;
/* 5010 */       this.Pag = 0;
/*      */       
/* 5012 */       this.linesPerPage = 50;
/* 5013 */       this.orientacion = 0;
/* 5014 */       this.X = 0.0D;
/* 5015 */       this.Y = 0.0D;
/* 5016 */       this.YINICIA = 100;
/* 5017 */       this.renglonGuias = 0;
/*      */       
/* 5019 */       this.PXCOL = new int[] { 36, 77, 120, 168, 230, 297, 329, 360, 392, 422, 478 };
/*      */     } private void initTextLines() {
/* 5021 */       if (this.textLines == null) {
/* 5022 */         this.Lineas = Prefacturas.this.LINEAS;
/* 5023 */         int numLines = this.Lineas.length;
/* 5024 */         this.textLines = new String[numLines];
/* 5025 */         for (int i = 0; i < numLines; i++) {
/* 5026 */           this.textLines[i] = this.Lineas[i];
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 5032 */       Font font = new Font("Serif", 0, 8);
/* 5033 */       FontMetrics metrics = g.getFontMetrics(font);
/* 5034 */       int lineHeight = metrics.getHeight();
/* 5035 */       if (this.pageBreaks == null) {
/* 5036 */         initTextLines();
/* 5037 */         this.orientacion = pf.getOrientation();
/* 5038 */         if (pf.getOrientation() == 1) {
/* 5039 */           this.renglonGuias = 12;
/* 5040 */           this.linesPerPage = 35;
/* 5041 */           this.X = pf.getWidth();
/* 5042 */           this.Y = pf.getHeight();
/*      */         } else {
/* 5044 */           this.renglonGuias = 17;
/* 5045 */           this.linesPerPage = 22;
/* 5046 */           this.X = pf.getWidth();
/* 5047 */           this.Y = pf.getHeight();
/*      */         } 
/* 5049 */         int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 5050 */         this.Pag = numBreaks;
/* 5051 */         this.pageBreaks = new int[numBreaks];
/* 5052 */         for (int b = 0; b < numBreaks; b++) {
/* 5053 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 5056 */       if (pageIndex > this.pageBreaks.length) {
/* 5057 */         return 1;
/*      */       }
/* 5059 */       Graphics2D g2d = (Graphics2D)g;
/* 5060 */       this.g2 = g;
/* 5061 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 5062 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 5063 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 5064 */       encabezado();
/* 5065 */       int y = this.YINICIA + 5;
/* 5066 */       int lineas = 0;
/*      */       
/* 5068 */       for (int line = start; line < end; line++) {
/* 5069 */         y += 16;
/* 5070 */         int Xempe = 35;
/* 5071 */         String valor = "";
/* 5072 */         if (line < 9) {
/* 5073 */           valor = "0" + line + 1;
/*      */         } else {
/* 5075 */           valor = "" + line + 1;
/*      */         } 
/* 5077 */         g.drawString(valor, 20, y);
/* 5078 */         this.g2.drawString(Prefacturas.this.REGIS[line][0], this.PXCOL[0], y);
/* 5079 */         this.g2.drawString(Prefacturas.this.REGIS[line][1], this.PXCOL[1], y);
/* 5080 */         this.g2.drawString(Prefacturas.this.REGIS[line][2], this.PXCOL[2], y);
/* 5081 */         this.g2.drawString(Prefacturas.this.REGIS[line][3], this.PXCOL[3], y);
/* 5082 */         this.g2.drawString(Prefacturas.this.REGIS[line][4], this.PXCOL[4], y);
/* 5083 */         this.g2.drawString(Prefacturas.this.REGIS[line][5], this.PXCOL[5], y);
/* 5084 */         this.g2.drawString(Prefacturas.this.REGIS[line][6], this.PXCOL[6], y);
/* 5085 */         this.g2.drawString(Prefacturas.this.REGIS[line][7], this.PXCOL[7], y);
/* 5086 */         this.g2.drawString(Prefacturas.this.REGIS[line][8], this.PXCOL[8], y);
/* 5087 */         this.g2.drawString(Prefacturas.this.REGIS[line][9], this.PXCOL[9], y);
/* 5088 */         this.g2.drawString(Prefacturas.this.REGIS[line][10], this.PXCOL[10], y);
/* 5089 */         y += 2;
/* 5090 */         lineas = y;
/* 5091 */         this.g2.drawLine(18, y, (int)this.X - 47, y);
/* 5092 */         this.g2.drawLine(this.PXCOL[1] - 3, 106, this.PXCOL[1] - 3, y);
/* 5093 */         this.g2.drawLine(this.PXCOL[2] - 3, 106, this.PXCOL[2] - 3, y);
/* 5094 */         this.g2.drawLine(this.PXCOL[3] - 3, 106, this.PXCOL[3] - 3, y);
/* 5095 */         this.g2.drawLine(this.PXCOL[4] - 3, 106, this.PXCOL[4] - 3, y);
/* 5096 */         this.g2.drawLine(this.PXCOL[5] - 3, 106, this.PXCOL[5] - 3, y);
/* 5097 */         this.g2.drawLine(this.PXCOL[6] - 3, 106, this.PXCOL[6] - 3, y);
/* 5098 */         this.g2.drawLine(this.PXCOL[7] - 3, 106, this.PXCOL[7] - 3, y);
/* 5099 */         this.g2.drawLine(this.PXCOL[8] - 3, 106, this.PXCOL[8] - 3, y);
/* 5100 */         this.g2.drawLine(this.PXCOL[9] - 3, 106, this.PXCOL[9] - 3, y);
/* 5101 */         this.g2.drawLine(this.PXCOL[10] - 3, 106, this.PXCOL[10] - 3, y);
/*      */       } 
/* 5103 */       this.g2.drawLine(34, this.YINICIA + 5, 34, lineas);
/* 5104 */       this.g2.drawLine(18, this.YINICIA + 5, 18, lineas);
/* 5105 */       this.g2.drawLine((int)this.X - 47, this.YINICIA + 5, (int)this.X - 47, lineas);
/* 5106 */       if (this.orientacion == 1) {
/* 5107 */         g.drawString("Página " + pageIndex + 1, 538, 760);
/*      */       } else {
/* 5109 */         g.drawString("Página " + pageIndex + 1, 717, 570);
/*      */       } 
/* 5111 */       Font fuente = new Font("Dialog", 0, 7);
/* 5112 */       this.g2.setFont(fuente);
/* 5113 */       if (this.Pag == pageIndex) {
/* 5114 */         this.g2.drawLine(18, lineas + 17, (int)this.X - 47, lineas + 17);
/* 5115 */         this.g2.drawLine(18, lineas + 19, (int)this.X - 47, lineas + 19);
/* 5116 */         lineas += 30;
/* 5117 */         if (Prefacturas.this.CANTTOTALES[6] != 0) {
/* 5118 */           fuente = new Font("Dialog", 1, 7);
/* 5119 */           this.g2.setFont(fuente);
/* 5120 */           this.g2.drawString("A de Fractura: " + Math.rint(Prefacturas.this.TONSRESIDUO[0] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5121 */           fuente = new Font("Dialog", 0, 7);
/* 5122 */           this.g2.setFont(fuente);
/* 5123 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[0] + "}", 110, lineas);
/* 5124 */           lineas += 15;
/*      */         } 
/* 5126 */         if (Prefacturas.this.CANTTOTALES[7] != 0) {
/* 5127 */           fuente = new Font("Dialog", 1, 7);
/* 5128 */           this.g2.setFont(fuente);
/* 5129 */           this.g2.drawString("A Residual: " + Math.rint(Prefacturas.this.TONSRESIDUO[1] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5130 */           fuente = new Font("Dialog", 0, 7);
/* 5131 */           this.g2.setFont(fuente);
/* 5132 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[1] + "}", 100, lineas);
/* 5133 */           lineas += 15;
/*      */         } 
/* 5135 */         if (Prefacturas.this.CANTTOTALES[8] != 0) {
/* 5136 */           fuente = new Font("Dialog", 1, 7);
/* 5137 */           this.g2.setFont(fuente);
/* 5138 */           this.g2.drawString("Lodo B Aceite: " + Math.rint(Prefacturas.this.TONSRESIDUO[2] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5139 */           fuente = new Font("Dialog", 0, 7);
/* 5140 */           this.g2.setFont(fuente);
/* 5141 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[2] + "}", 115, lineas);
/* 5142 */           lineas += 15;
/*      */         } 
/* 5144 */         if (Prefacturas.this.CANTTOTALES[9] != 0) {
/* 5145 */           fuente = new Font("Dialog", 1, 7);
/* 5146 */           this.g2.setFont(fuente);
/* 5147 */           this.g2.drawString("Lodo B Agua: " + Math.rint(Prefacturas.this.TONSRESIDUO[3] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5148 */           fuente = new Font("Dialog", 0, 7);
/* 5149 */           this.g2.setFont(fuente);
/* 5150 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[3] + "}", 115, lineas);
/* 5151 */           lineas += 15;
/*      */         } 
/* 5153 */         if (Prefacturas.this.CANTTOTALES[10] != 0) {
/* 5154 */           fuente = new Font("Dialog", 1, 7);
/* 5155 */           this.g2.setFont(fuente);
/* 5156 */           this.g2.drawString("Recorte B Aceite: " + Math.rint(Prefacturas.this.TONSRESIDUO[4] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5157 */           fuente = new Font("Dialog", 0, 7);
/* 5158 */           this.g2.setFont(fuente);
/* 5159 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[4] + "}", 125, lineas);
/* 5160 */           lineas += 15;
/*      */         } 
/* 5162 */         if (Prefacturas.this.CANTTOTALES[11] != 0) {
/* 5163 */           fuente = new Font("Dialog", 1, 7);
/* 5164 */           this.g2.setFont(fuente);
/* 5165 */           this.g2.drawString("Recorte B Agua: " + Math.rint(Prefacturas.this.TONSRESIDUO[5] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5166 */           fuente = new Font("Dialog", 0, 7);
/* 5167 */           this.g2.setFont(fuente);
/* 5168 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[5] + "}", 120, lineas);
/* 5169 */           lineas += 15;
/*      */         } 
/* 5171 */         if (Prefacturas.this.CANTTOTALES[12] != 0) {
/* 5172 */           fuente = new Font("Dialog", 1, 7);
/* 5173 */           this.g2.setFont(fuente);
/* 5174 */           this.g2.drawString("Salmuera: " + Math.rint(Prefacturas.this.TONSRESIDUO[6] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5175 */           fuente = new Font("Dialog", 0, 7);
/* 5176 */           this.g2.setFont(fuente);
/* 5177 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[6] + "}", 105, lineas);
/* 5178 */           lineas += 15;
/*      */         } 
/* 5180 */         if (Prefacturas.this.CANTTOTALES[13] != 0) {
/* 5181 */           fuente = new Font("Dialog", 1, 7);
/* 5182 */           this.g2.setFont(fuente);
/* 5183 */           this.g2.drawString("Saneamiento: " + Math.rint(Prefacturas.this.TONSRESIDUO[7] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5184 */           fuente = new Font("Dialog", 0, 7);
/* 5185 */           this.g2.setFont(fuente);
/* 5186 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[7] + "}", 110, lineas);
/* 5187 */           lineas += 15;
/*      */         } 
/* 5189 */         if (Prefacturas.this.CANTTOTALES[14] != 0) {
/* 5190 */           fuente = new Font("Dialog", 1, 7);
/* 5191 */           this.g2.setFont(fuente);
/* 5192 */           this.g2.drawString("Sedimento: " + Math.rint(Prefacturas.this.TONSRESIDUO[8] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5193 */           fuente = new Font("Dialog", 0, 7);
/* 5194 */           this.g2.setFont(fuente);
/* 5195 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[8] + "}", 105, lineas);
/* 5196 */           lineas += 15;
/*      */         } 
/* 5198 */         if (Prefacturas.this.CANTTOTALES[15] != 0) {
/* 5199 */           fuente = new Font("Dialog", 1, 7);
/* 5200 */           this.g2.setFont(fuente);
/* 5201 */           this.g2.drawString("Fletes - Varios: " + Math.rint(Prefacturas.this.TONSRESIDUO[9] * 1000.0D) / 1000.0D + " Tons ", 20, lineas);
/* 5202 */           fuente = new Font("Dialog", 0, 7);
/* 5203 */           this.g2.setFont(fuente);
/* 5204 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[9] + "}", 105, lineas);
/* 5205 */           lineas += 15;
/*      */         } 
/* 5207 */         if (Prefacturas.this.OTROSRESIDUOS != 0) {
/* 5208 */           fuente = new Font("Dialog", 1, 7);
/* 5209 */           this.g2.setFont(fuente);
/* 5210 */           this.g2.drawString("Otros: " + Math.rint(Prefacturas.this.TONSRESIDUO[10] * 1000.0D) / 1000.0D + " Tons", 20, lineas);
/* 5211 */           fuente = new Font("Dialog", 0, 7);
/* 5212 */           this.g2.setFont(fuente);
/* 5213 */           this.g2.drawString("Guías {" + Prefacturas.this.GUIASAMPARADAS[10] + "}", 95, lineas);
/* 5214 */           lineas += 15;
/*      */         } 
/*      */       } 
/* 5217 */       this.g2.setColor(Color.WHITE);
/* 5218 */       this.g2.fillRect((int)this.X - 46, 12, (int)this.X - 46, lineas);
/* 5219 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 5223 */       Font fuente = new Font("Dialog", 0, 8);
/* 5224 */       this.g2.setFont(fuente);
/* 5225 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 5226 */       Image img = imagen.getImage();
/* 5227 */       this.g2.drawImage(img, 16, 6, 45, 45, null);
/* 5228 */       fuente = new Font("Times New Roman", 1, 19);
/* 5229 */       this.g2.setFont(fuente);
/* 5230 */       this.g2.drawString("GRUPO FORSIS - " + Prefacturas.this.base, 230, 20);
/* 5231 */       fuente = new Font("Dialog", 0, 16);
/* 5232 */       this.g2.setFont(fuente);
/* 5233 */       this.g2.drawString("REPORTE INTERNO DE PREFACTURA", 215, 39);
/*      */       
/* 5235 */       fuente = new Font("Dialog", 2, 9);
/* 5236 */       this.g2.setFont(fuente);
/* 5237 */       this.g2.drawString("FOLIO Ó REF: " + Prefacturas.this.jTextField2.getText().toUpperCase(), 65, 51);
/*      */       
/* 5239 */       fuente = new Font("Dialog", 0, 8);
/* 5240 */       this.g2.setFont(fuente);
/*      */       
/* 5242 */       this.g2.drawLine(25, 53, (int)this.X - 47, 53);
/* 5243 */       this.g2.drawLine(25, 56, (int)this.X - 47, 56);
/*      */       
/* 5245 */       this.g2.drawLine(25, this.YINICIA - 15, (int)this.X - 47, this.YINICIA - 15);
/* 5246 */       this.g2.drawLine(25, this.YINICIA - 18, (int)this.X - 47, this.YINICIA - 18);
/*      */       
/* 5248 */       Date fecha1 = Prefacturas.this.jDateChooser4.getDate();
/* 5249 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5250 */       String cadenaFecha = "";
/* 5251 */       cadenaFecha = formato.format(fecha1);
/* 5252 */       String AÑO = cadenaFecha.substring(0, 4);
/* 5253 */       String MES = cadenaFecha.substring(4, 6);
/* 5254 */       String DIA = cadenaFecha.substring(6, 8);
/* 5255 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/* 5256 */       this.g2.drawString(fechaCompleta1, (int)this.X - 100, 45);
/* 5257 */       this.g2.drawString("CLIENTE:", 35, 66);
/* 5258 */       this.g2.drawString("EQUIPO:                                                              PLATAFORMA:                                                        POZO:                                                    TONELADAS: ", 35, 78);
/* 5259 */       String cliente = "GENERAL";
/* 5260 */       String equipo = "GENERAL";
/* 5261 */       String plat = "GENERAL";
/* 5262 */       String pozo = "GENERAL";
/* 5263 */       if (Prefacturas.this.jComboBox4.getSelectedIndex() != 0) {
/* 5264 */         cliente = String.valueOf(Prefacturas.this.jComboBox4.getSelectedItem());
/*      */       }
/* 5266 */       if (Prefacturas.this.jComboBox21.getSelectedIndex() != 0) {
/* 5267 */         equipo = String.valueOf(Prefacturas.this.jComboBox21.getSelectedItem());
/*      */       }
/* 5269 */       if (Prefacturas.this.jComboBox22.getSelectedIndex() != 0) {
/* 5270 */         plat = String.valueOf(Prefacturas.this.jComboBox22.getSelectedItem());
/*      */       }
/* 5272 */       if (Prefacturas.this.jComboBox23.getSelectedIndex() != 0) {
/* 5273 */         pozo = String.valueOf(Prefacturas.this.jComboBox23.getSelectedItem());
/*      */       }
/* 5275 */       fuente = new Font("Dialog", 1, 8);
/* 5276 */       this.g2.setFont(fuente);
/* 5277 */       this.g2.drawString(cliente, 85, 66);
/* 5278 */       this.g2.drawString(pozo, 430, 78);
/*      */       
/* 5280 */       fuente = new Font("Dialog", 1, 8);
/* 5281 */       this.g2.setFont(fuente);
/* 5282 */       this.g2.drawString("" + Prefacturas.this.TONS, 600, 78);
/* 5283 */       fuente = new Font("Dialog", 0, 8);
/* 5284 */       this.g2.setFont(fuente);
/* 5285 */       this.g2.drawString(equipo, 85, 78);
/* 5286 */       this.g2.drawString(plat, 275, 78);
/*      */       
/* 5288 */       this.g2.setColor(Color.LIGHT_GRAY);
/* 5289 */       this.g2.fillRect(18, this.YINICIA - 8, 54, 10);
/* 5290 */       this.g2.fillRect(this.PXCOL[1] - 2, this.YINICIA - 8, 40, 10);
/* 5291 */       this.g2.fillRect(this.PXCOL[2] - 2, this.YINICIA - 8, 45, 10);
/* 5292 */       this.g2.fillRect(this.PXCOL[3] - 2, this.YINICIA - 8, 59, 10);
/* 5293 */       this.g2.fillRect(this.PXCOL[4] - 2, this.YINICIA - 8, 64, 10);
/* 5294 */       this.g2.fillRect(this.PXCOL[5] - 2, this.YINICIA - 8, 29, 10);
/* 5295 */       this.g2.fillRect(this.PXCOL[6] - 2, this.YINICIA - 8, 28, 10);
/* 5296 */       this.g2.fillRect(this.PXCOL[7] - 2, this.YINICIA - 8, 29, 10);
/* 5297 */       this.g2.fillRect(this.PXCOL[8] - 2, this.YINICIA - 8, 27, 10);
/* 5298 */       this.g2.fillRect(this.PXCOL[9] - 2, this.YINICIA - 8, 53, 10);
/* 5299 */       this.g2.fillRect(this.PXCOL[10] - 2, this.YINICIA - 8, 275, 10);
/*      */       
/* 5301 */       this.g2.setColor(Color.BLACK);
/* 5302 */       fuente = new Font("Dialog", 1, 8);
/* 5303 */       this.g2.setFont(fuente);
/* 5304 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[0], this.PXCOL[0] + 3, this.YINICIA);
/* 5305 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[1], this.PXCOL[1] + 3, this.YINICIA);
/* 5306 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[2], this.PXCOL[2] + 3, this.YINICIA);
/* 5307 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[3], this.PXCOL[3] + 3, this.YINICIA);
/* 5308 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[4], this.PXCOL[4] + 3, this.YINICIA);
/* 5309 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[5], this.PXCOL[5] + 3, this.YINICIA);
/* 5310 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[6], this.PXCOL[6] + 3, this.YINICIA);
/* 5311 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[7], this.PXCOL[7] + 3, this.YINICIA);
/* 5312 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[8], this.PXCOL[8] + 3, this.YINICIA);
/* 5313 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[9], this.PXCOL[9] + 3, this.YINICIA);
/* 5314 */       this.g2.drawString(Prefacturas.this.NOMBRECOL[10], this.PXCOL[10] + 3, this.YINICIA);
/*      */       
/* 5316 */       fuente = new Font("Dialog", 0, 7);
/* 5317 */       this.g2.setFont(fuente);
/*      */       
/* 5319 */       this.g2.drawLine(18, this.YINICIA + 3, (int)this.X - 47, this.YINICIA + 3);
/* 5320 */       this.g2.drawLine(18, this.YINICIA + 5, (int)this.X - 47, this.YINICIA + 5);
/*      */     }
/*      */     public void recibeDatos() {
/* 5323 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 5324 */       job.setPrintable(this);
/*      */       
/* 5326 */       PageFormat pf = job.defaultPage();
/* 5327 */       Paper papel = pf.getPaper();
/* 5328 */       papel.setSize(612.0D, 792.0D);
/* 5329 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 5330 */       pf.setPaper(papel);
/* 5331 */       pf.setOrientation(0);
/* 5332 */       job.setPrintable(new ImprimirFacturas3(), pf);
/* 5333 */       job.defaultPage(pf);
/*      */       
/* 5335 */       boolean ok = job.printDialog();
/* 5336 */       if (ok)
/*      */         try {
/* 5338 */           job.print();
/* 5339 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer
/*      */   {
/* 5346 */     int otro = -1;
/* 5347 */     String[] indices = new String[0];
/* 5348 */     String[] indices2 = new String[0];
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5350 */       setEnabled((table == null || table.isEnabled()));
/* 5351 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 5352 */       if (comparar(comp)) {
/* 5353 */         setBackground(Color.red);
/* 5354 */         setForeground(Color.white);
/*      */       }
/* 5356 */       else if (comparar2(comp)) {
/* 5357 */         setBackground(new Color(102, 153, 255));
/* 5358 */         setForeground(Color.BLUE);
/*      */       } else {
/*      */         
/* 5361 */         setBackground((Color)null);
/* 5362 */         setForeground(Color.BLACK);
/*      */       } 
/* 5364 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5365 */       return this;
/*      */     }
/*      */     public void pasarInd(String[] ind) {
/* 5368 */       this.indices = ind;
/*      */     }
/*      */     public void pasarInd2(String[] ind) {
/* 5371 */       this.indices2 = ind;
/*      */     }
/*      */     public boolean comparar(String reg) {
/* 5374 */       for (int i = 0; i < this.indices.length; i++) {
/* 5375 */         if (this.indices[i].equals(reg)) {
/* 5376 */           return true;
/*      */         }
/*      */       } 
/* 5379 */       return false;
/*      */     }
/*      */     public boolean comparar2(String reg) {
/* 5382 */       for (int i = 0; i < this.indices2.length; i++) {
/* 5383 */         if (this.indices2[i].equals(reg)) {
/* 5384 */           return true;
/*      */         }
/*      */       } 
/* 5387 */       return false;
/*      */     } }
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices;
/*      */     
/*      */     public CeldaRender2() {
/* 5392 */       this.otro = -1;
/* 5393 */       this.indices = new String[0];
/*      */     } public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 5395 */       setEnabled((table == null || table.isEnabled()));
/* 5396 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 5397 */       if (comparar(comp)) {
/* 5398 */         setBackground(new Color(102, 153, 255));
/* 5399 */         setForeground(Color.BLUE);
/*      */       } else {
/*      */         
/* 5402 */         setBackground((Color)null);
/* 5403 */         setForeground(Color.BLACK);
/*      */       } 
/* 5405 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 5406 */       return this;
/*      */     }
/*      */     public void pasarInd(String[] ind) {
/* 5409 */       this.indices = ind;
/*      */     }
/*      */     public boolean comparar(String reg) {
/* 5412 */       for (int i = 0; i < this.indices.length; i++) {
/* 5413 */         if (this.indices[i].equals(reg)) {
/* 5414 */           return true;
/*      */         }
/*      */       } 
/* 5417 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   class AddGuias {
/* 5422 */     String[] GUIAS = new String[1000];
/* 5423 */     int indice = 0;
/*      */     public AddGuias() {
/* 5425 */       for (int i = 0; i < this.GUIAS.length; i++)
/* 5426 */         this.GUIAS[i] = ""; 
/*      */     }
/*      */     
/*      */     public void agregarGuia(String pGuia) {
/* 5430 */       this.GUIAS[this.indice] = pGuia;
/* 5431 */       this.indice++;
/*      */     }
/*      */     public int dameInd() {
/* 5434 */       return this.indice;
/*      */     }
/*      */     public String dameGuia(int numGuia) {
/* 5437 */       return this.GUIAS[numGuia];
/*      */     }
/*      */   }
/*      */   
/*      */   public class Presionado implements Runnable {
/*      */     Thread t;
/* 5443 */     int cont = 0;
/*      */     public Presionado() {
/* 5445 */       this.t = new Thread(this);
/* 5446 */       this.t.start();
/*      */     }
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 5452 */         Thread.currentThread(); Thread.sleep(1000L);
/* 5453 */         detener();
/*      */       }
/* 5455 */       catch (InterruptedException interruptedException) {}
/*      */     }
/*      */     
/*      */     public void detener() {
/* 5459 */       Prefacturas.this.consultarGuias();
/* 5460 */       this.t.stop();
/*      */     }
/*      */     public void detenerFuera() {
/* 5463 */       this.t.stop();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Prefacturas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */