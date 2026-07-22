/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.Paper;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.DefaultComboBoxModel;
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
/*      */ import javax.swing.JToolBar;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ 
/*      */ public class ampararFacturas extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   44 */   Date fechaActual = new Date();
/*   45 */   Date fechaInicio = null;
/*   46 */   Date fecha = new Date();
/*   47 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   48 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   49 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   50 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   51 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   52 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   53 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   54 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   55 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   56 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   57 */   JFrame padre = null;
/*   58 */   JTabbedPane fichas = null;
/*   59 */   String[] CLAVES = null;
/*   60 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*      */   EscribirReporte esc;
/*   63 */   String MONTO = "";
/*   64 */   double CANTIDAD = 0.0D;
/*   65 */   DefaultTableModel modelo = new DefaultTableModel();
/*   66 */   CeldaRender celda = new CeldaRender();
/*   67 */   CeldaRender2 celda2 = new CeldaRender2();
/*   68 */   String[] DATOS = null;
/*   69 */   String ENTREGA = "";
/*   70 */   String RECIBE = "";
/*   71 */   MensajePop mensajeTry = null; private ButtonGroup buttonGroup1; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton3; private JButton jButton30; private JButton jButton31; private JButton jButton32; private JButton jButton33; private JButton jButton34; private JButton jButton35; private JButton jButton36; private JButton jButton4; private JButton jButton44; private JButton jButton45; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JComboBox jComboBox14; private JComboBox jComboBox17; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JComboBox jComboBox9; private JComboBoxMultiCol jComboBoxMultiCol1; private JDateChooser jDateChooser12; private JDateChooser jDateChooser13; private JDateChooser jDateChooser14; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser6; private JDateChooser jDateChooser7; private JDateChooser jDateChooser8; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog8; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField5; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel127; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel43; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel54; private JLabel jLabel6;
/*      */   private JLabel jLabel7;
/*      */   private JLabel jLabel72;
/*      */   private JLabel jLabel75;
/*      */   private JLabel jLabel76;
/*      */   
/*      */   public ampararFacturas(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*   78 */     this.mensajeTry = mensajeTry;
/*   79 */     initComponents();
/*   80 */     String año = "2011";
/*   81 */     String mes = "01";
/*   82 */     String dia = "01";
/*   83 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   84 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   86 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   87 */     } catch (ParseException ex) {
/*   88 */       ex.printStackTrace();
/*      */     } 
/*   90 */     this.padre = padre;
/*   91 */     fichas = fichas;
/*   92 */     initComponents();
/*   93 */     llenarCombo();
/*   94 */     this.USUARIO = USUARIO;
/*   95 */     panelito.setViewportView(this);
/*   96 */     this.panel = panelito;
/*   97 */     colorear();
/*      */     
/*   99 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  100 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  101 */     this.jLabel5.setCursor(micursor);
/*  102 */     this.jLabel6.setCursor(micursor);
/*  103 */     this.jLabel7.setCursor(micursor);
/*      */     
/*  105 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  106 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  107 */     this.jDialog1.setCursor(micursor);
/*  108 */     this.jDialog2.setCursor(micursor);
/*      */     
/*  110 */     int w = this.tama.width;
/*  111 */     int h = this.tama.height;
/*  112 */     int rw = (w - 750) / 2;
/*  113 */     int rh = (h - 680) / 2;
/*  114 */     this.jDialog1.setLocation(rw, rh);
/*  115 */     this.jDialog1.setSize(750, 680);
/*  116 */     this.jDialog1.setVisible(false);
/*  117 */     this.jDialog1.setResizable(false);
/*      */     
/*  119 */     rw = (w - 650) / 2;
/*  120 */     rh = (h - 175) / 2;
/*  121 */     this.jDialog2.setLocation(rw, rh);
/*  122 */     this.jDialog2.setSize(650, 175);
/*  123 */     this.jDialog2.setVisible(false);
/*  124 */     this.jDialog2.setResizable(false);
/*      */     
/*  126 */     rw = (w - 390) / 2;
/*  127 */     rh = (h - 230) / 2;
/*  128 */     this.jDialog3.setLocation(rw, rh);
/*  129 */     this.jDialog3.setSize(390, 230);
/*  130 */     this.jDialog3.setVisible(false);
/*  131 */     this.jDialog3.setResizable(false);
/*      */     
/*  133 */     rw = (w - 390) / 2;
/*  134 */     rh = (h - 250) / 2;
/*  135 */     this.jDialog4.setLocation(rw, rh);
/*  136 */     this.jDialog4.setSize(390, 250);
/*  137 */     this.jDialog4.setVisible(false);
/*  138 */     this.jDialog4.setResizable(false);
/*      */     
/*  140 */     rw = (w - 630) / 2;
/*  141 */     rh = (h - 175) / 2;
/*  142 */     this.jDialog5.setLocation(rw, rh);
/*  143 */     this.jDialog5.setSize(630, 175);
/*  144 */     this.jDialog5.setVisible(false);
/*  145 */     this.jDialog5.setResizable(false);
/*      */     
/*  147 */     rw = (w - 340) / 2;
/*  148 */     rh = (h - 160) / 2;
/*  149 */     this.jDialog6.setLocation(rw, rh);
/*  150 */     this.jDialog6.setSize(340, 160);
/*  151 */     this.jDialog6.setVisible(false);
/*  152 */     this.jDialog6.setResizable(false);
/*      */     
/*  154 */     rw = (w - 750) / 2;
/*  155 */     rh = (h - 680) / 2;
/*  156 */     this.jDialog8.setLocation(rw, rh);
/*  157 */     this.jDialog8.setSize(750, 680);
/*  158 */     this.jDialog8.setVisible(false);
/*  159 */     this.jDialog8.setResizable(false);
/*      */     
/*  161 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  162 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  163 */     editFormat.setGroupingUsed(false);
/*  164 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  165 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  166 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  167 */     enFormat.setAllowsInvalid(true);
/*  168 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  169 */     this.jFormattedTextField2.setFormatterFactory(currFactory);
/*  170 */     this.jFormattedTextField3.setFormatterFactory(currFactory);
/*  171 */     this.jFormattedTextField5.setFormatterFactory(currFactory);
/*  172 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*  173 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*  174 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*  175 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*      */     
/*  177 */     this.jTable1.setModel(this.modelo);
/*  178 */     this.modelo.addColumn("Factura");
/*  179 */     this.modelo.addColumn("Monto Original");
/*  180 */     this.modelo.addColumn("Monto a Saldar");
/*  181 */     this.modelo.addColumn("Tipo");
/*      */     
/*  183 */     desplazarFecha();
/*      */     
/*  185 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/*  186 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/*      */     
/*  188 */     this.DATOS = this.con.regresaReg("directiva,contraloria,sucursal", "configuraciones", "", 3);
/*  189 */     sacarMayor();
/*  190 */     consultar();
/*  191 */     sacarUsuarios();
/*      */     
/*  193 */     this.jTable1.setAutoCreateRowSorter(true);
/*  194 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     
/*  196 */     this.jLabel17.setText("Total " + this.DATOS[2] + ": ");
/*  197 */     this.jLabel93.setText("Total " + this.DATOS[2] + ": ");
/*  198 */     this.buttonGroup1.add(this.jRadioButton1);
/*  199 */     this.buttonGroup1.add(this.jRadioButton2);
/*      */     
/*  201 */     JTable tabla = new JTable();
/*  202 */     tabla.setModel(new DefaultTableModel((Object[][])this.con
/*  203 */           .buscarDatos(5, "clave_gene,iniciales,nombre_corto,calle,num", "emp_generadora", "order by iniciales"), (Object[])new String[] { "Clave", "Iniciales", "Empresa", "Calle", "#" })
/*      */         {
/*      */ 
/*      */           
/*  207 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  212 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     try {
/*  216 */       this.jComboBoxMultiCol1.Config(tabla, 2, 1);
/*  217 */       this.jComboBoxMultiCol1.SetFilter(true);
/*  218 */     } catch (Exception ex) {
/*  219 */       Logger.getLogger(ampararFacturas.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*  221 */     this.jComboBoxMultiCol1.SetEditable(true);
/*      */     
/*  223 */     this.jComboBoxMultiCol1.setVisible(false);
/*      */   } private JLabel jLabel77; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel17; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44;
/*      */   private JPanel jPanel45;
/*      */   private JPanel jPanel46;
/*      */   
/*      */   private void initComponents() {
/*  229 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  230 */     this.jToolBar1 = new JToolBar();
/*  231 */     this.jLabel10 = new JLabel();
/*  232 */     this.jLabel13 = new JLabel();
/*  233 */     this.jSeparator3 = new JToolBar.Separator();
/*  234 */     this.jLabel14 = new JLabel();
/*  235 */     this.jLabel16 = new JLabel();
/*  236 */     this.jSeparator4 = new JToolBar.Separator();
/*  237 */     this.jLabel17 = new JLabel();
/*  238 */     this.jLabel40 = new JLabel();
/*  239 */     this.jSeparator2 = new JToolBar.Separator();
/*  240 */     this.jLabel20 = new JLabel();
/*  241 */     this.jLabel18 = new JLabel();
/*  242 */     this.jPanel12 = new JPanel();
/*  243 */     this.jPanel13 = new JPanel();
/*  244 */     this.jLabel26 = new JLabel();
/*  245 */     this.jTextField5 = new JTextField();
/*  246 */     this.jLabel2 = new JLabel();
/*  247 */     this.jSeparator1 = new JSeparator();
/*  248 */     this.jPanel19 = new JPanel();
/*  249 */     this.jPanel20 = new JPanel();
/*  250 */     this.jLabel28 = new JLabel();
/*  251 */     this.jComboBox8 = new JComboBox();
/*  252 */     this.jLabel15 = new JLabel();
/*  253 */     this.jComboBox7 = new JComboBox();
/*  254 */     this.jLabel29 = new JLabel();
/*  255 */     this.jTextField8 = new JTextField();
/*  256 */     this.jPanel21 = new JPanel();
/*  257 */     this.jLabel19 = new JLabel();
/*  258 */     this.jDateChooser8 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  259 */     this.jLabel11 = new JLabel();
/*  260 */     this.jDateChooser7 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  261 */     this.jLabel12 = new JLabel();
/*  262 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  263 */     this.jPanel6 = new JPanel();
/*  264 */     this.jPanel37 = new JPanel();
/*  265 */     this.jLabel8 = new JLabel();
/*  266 */     this.jDateChooser6 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  267 */     this.jPanel38 = new JPanel();
/*  268 */     this.jButton7 = new JButton();
/*  269 */     this.jLabel3 = new JLabel();
/*  270 */     this.jComboBox4 = new JComboBox();
/*  271 */     this.jPanel22 = new JPanel();
/*  272 */     this.jPanel23 = new JPanel();
/*  273 */     this.jLabel9 = new JLabel();
/*  274 */     this.jPanel15 = new JPanel();
/*  275 */     this.jComboBox5 = new JComboBox();
/*  276 */     this.jLabel36 = new JLabel();
/*  277 */     this.jTextField11 = new JTextField();
/*  278 */     this.jLabel37 = new JLabel();
/*  279 */     this.jTextField12 = new JTextField();
/*  280 */     this.jPanel14 = new JPanel();
/*  281 */     this.jPanel33 = new JPanel();
/*  282 */     this.jButton2 = new JButton();
/*  283 */     this.jPanel39 = new JPanel();
/*  284 */     this.jPanel40 = new JPanel();
/*  285 */     this.jPanel34 = new JPanel();
/*  286 */     this.jPanel35 = new JPanel();
/*  287 */     this.jLabel38 = new JLabel();
/*  288 */     this.jTextField13 = new JTextField();
/*  289 */     this.jPanel36 = new JPanel();
/*  290 */     this.jScrollPane1 = new JScrollPane();
/*  291 */     this.jTable1 = new JTable();
/*  292 */     this.jButton3 = new JButton();
/*  293 */     this.jButton4 = new JButton();
/*  294 */     this.jButton5 = new JButton();
/*  295 */     this.jButton6 = new JButton();
/*  296 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  297 */     this.jPanel4 = new JPanel();
/*  298 */     this.jLabel21 = new JLabel();
/*  299 */     this.jSeparator5 = new JSeparator();
/*  300 */     this.jLabel22 = new JLabel();
/*  301 */     this.jTextField2 = new JTextField();
/*  302 */     this.jLabel23 = new JLabel();
/*  303 */     this.jLabel24 = new JLabel();
/*  304 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  305 */     this.jLabel25 = new JLabel();
/*  306 */     this.jTextField3 = new JTextField();
/*  307 */     this.jSeparator6 = new JSeparator();
/*  308 */     this.jButton8 = new JButton();
/*  309 */     this.jButton9 = new JButton();
/*  310 */     this.jTextField4 = new JTextField();
/*  311 */     this.jLabel30 = new JLabel();
/*  312 */     this.jTextField9 = new JTextField();
/*  313 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  314 */     this.jPanel29 = new JPanel();
/*  315 */     this.jLabel124 = new JLabel();
/*  316 */     this.jSeparator29 = new JSeparator();
/*  317 */     this.jLabel125 = new JLabel();
/*  318 */     this.jButton44 = new JButton();
/*  319 */     this.jButton45 = new JButton();
/*  320 */     this.jScrollPane18 = new JScrollPane();
/*  321 */     this.jTextArea5 = new JTextArea();
/*  322 */     this.jLabel126 = new JLabel();
/*  323 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  324 */     this.jPanel30 = new JPanel();
/*  325 */     this.jLabel127 = new JLabel();
/*  326 */     this.jSeparator28 = new JSeparator();
/*  327 */     this.jLabel27 = new JLabel();
/*  328 */     this.jScrollPane7 = new JScrollPane();
/*  329 */     this.jTextArea3 = new JTextArea();
/*  330 */     this.jButton11 = new JButton();
/*  331 */     this.jButton12 = new JButton();
/*  332 */     this.jPanel9 = new JPanel();
/*  333 */     this.jTextField6 = new JTextField();
/*  334 */     this.jTextField7 = new JTextField();
/*  335 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  336 */     this.jPanel10 = new JPanel();
/*  337 */     this.jLabel34 = new JLabel();
/*  338 */     this.jSeparator7 = new JSeparator();
/*  339 */     this.jLabel39 = new JLabel();
/*  340 */     this.jLabel41 = new JLabel();
/*  341 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  342 */     this.jSeparator8 = new JSeparator();
/*  343 */     this.jButton10 = new JButton();
/*  344 */     this.jButton13 = new JButton();
/*  345 */     this.jLabel43 = new JLabel();
/*  346 */     this.jComboBox9 = new JComboBox();
/*  347 */     this.jTextField10 = new JTextField();
/*  348 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  349 */     this.jPanel11 = new JPanel();
/*  350 */     this.jLabel92 = new JLabel();
/*  351 */     this.jSeparator11 = new JSeparator();
/*  352 */     this.jButton30 = new JButton();
/*  353 */     this.jButton31 = new JButton();
/*  354 */     this.jRadioButton1 = new JRadioButton();
/*  355 */     this.jRadioButton2 = new JRadioButton();
/*  356 */     this.buttonGroup1 = new ButtonGroup();
/*  357 */     this.jDialog8 = new CerrarVentana(this.padre);
/*  358 */     this.jToolBar3 = new JToolBar();
/*  359 */     this.jLabel88 = new JLabel();
/*  360 */     this.jLabel89 = new JLabel();
/*  361 */     this.jSeparator15 = new JToolBar.Separator();
/*  362 */     this.jLabel90 = new JLabel();
/*  363 */     this.jLabel91 = new JLabel();
/*  364 */     this.jSeparator16 = new JToolBar.Separator();
/*  365 */     this.jLabel93 = new JLabel();
/*  366 */     this.jLabel94 = new JLabel();
/*  367 */     this.jSeparator17 = new JToolBar.Separator();
/*  368 */     this.jLabel95 = new JLabel();
/*  369 */     this.jLabel96 = new JLabel();
/*  370 */     this.jPanel41 = new JPanel();
/*  371 */     this.jLabel75 = new JLabel();
/*  372 */     this.jTextField19 = new JTextField();
/*  373 */     this.jLabel72 = new JLabel();
/*  374 */     this.jSeparator14 = new JSeparator();
/*  375 */     this.jPanel26 = new JPanel();
/*  376 */     this.jPanel27 = new JPanel();
/*  377 */     this.jLabel80 = new JLabel();
/*  378 */     this.jTextField20 = new JTextField();
/*  379 */     this.jLabel83 = new JLabel();
/*  380 */     this.jFormattedTextField5 = new JFormattedTextField();
/*  381 */     this.jLabel81 = new JLabel();
/*  382 */     this.jDateChooser13 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  383 */     this.jPanel28 = new JPanel();
/*  384 */     this.jPanel3 = new JPanel();
/*  385 */     this.jLabel82 = new JLabel();
/*  386 */     this.jDateChooser14 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  387 */     this.jPanel42 = new JPanel();
/*  388 */     this.jPanel43 = new JPanel();
/*  389 */     this.jPanel25 = new JPanel();
/*  390 */     this.jPanel44 = new JPanel();
/*  391 */     this.jLabel76 = new JLabel();
/*  392 */     this.jDateChooser12 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  393 */     this.jPanel45 = new JPanel();
/*  394 */     this.jButton34 = new JButton();
/*  395 */     this.jLabel77 = new JLabel();
/*  396 */     this.jComboBox14 = new JComboBox();
/*  397 */     this.jPanel31 = new JPanel();
/*  398 */     this.jPanel32 = new JPanel();
/*  399 */     this.jLabel84 = new JLabel();
/*  400 */     this.jComboBox17 = new JComboBox();
/*  401 */     this.jLabel85 = new JLabel();
/*  402 */     this.jTextField21 = new JTextField();
/*  403 */     this.jLabel86 = new JLabel();
/*  404 */     this.jTextField22 = new JTextField();
/*  405 */     this.jPanel46 = new JPanel();
/*  406 */     this.jPanel47 = new JPanel();
/*  407 */     this.jButton36 = new JButton();
/*  408 */     this.jPanel50 = new JPanel();
/*  409 */     this.jPanel51 = new JPanel();
/*  410 */     this.jPanel48 = new JPanel();
/*  411 */     this.jPanel49 = new JPanel();
/*  412 */     this.jLabel87 = new JLabel();
/*  413 */     this.jTextField23 = new JTextField();
/*  414 */     this.jPanel52 = new JPanel();
/*  415 */     this.jScrollPane4 = new JScrollPane();
/*  416 */     this.jTable4 = new JTable();
/*  417 */     this.jButton21 = new JButton();
/*  418 */     this.jButton32 = new JButton();
/*  419 */     this.jButton33 = new JButton();
/*  420 */     this.jButton35 = new JButton();
/*  421 */     this.jScrollPane2 = new JScrollPane();
/*  422 */     this.jTable2 = new JTable();
/*  423 */     this.jPanel1 = new JPanel();
/*  424 */     this.jLabel54 = new JLabel();
/*  425 */     this.jPanel5 = new JPanel();
/*  426 */     this.jLabel48 = new JLabel();
/*  427 */     this.jScrollPane3 = new JScrollPane();
/*  428 */     this.jTable3 = new JTable();
/*  429 */     this.jButton23 = new JButton();
/*  430 */     this.jButton20 = new JButton();
/*  431 */     this.jButton24 = new JButton();
/*  432 */     this.jButton26 = new JButton();
/*  433 */     this.jButton27 = new JButton();
/*  434 */     this.jButton25 = new JButton();
/*  435 */     this.jLabel31 = new JLabel();
/*  436 */     this.jLabel32 = new JLabel();
/*  437 */     this.jLabel33 = new JLabel();
/*  438 */     this.jLabel35 = new JLabel();
/*  439 */     this.jPanel17 = new JPanel();
/*  440 */     this.jTextField1 = new JTextField();
/*  441 */     this.jLabel45 = new JLabel();
/*  442 */     this.jComboBox1 = new JComboBox();
/*  443 */     this.jLabel46 = new JLabel();
/*  444 */     this.jComboBox2 = new JComboBox();
/*  445 */     this.jComboBox3 = new JComboBox();
/*  446 */     this.jLabel47 = new JLabel();
/*  447 */     this.jComboBox6 = new JComboBox();
/*  448 */     this.jLabel49 = new JLabel();
/*  449 */     this.jLabel50 = new JLabel();
/*  450 */     this.jComboBoxMultiCol1 = new JComboBoxMultiCol();
/*  451 */     this.jPanel2 = new JPanel();
/*  452 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  453 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  454 */     this.jLabel5 = new JLabel();
/*  455 */     this.jLabel6 = new JLabel();
/*  456 */     this.jLabel7 = new JLabel();
/*  457 */     this.jLabel1 = new JLabel();
/*  458 */     this.jLabel4 = new JLabel();
/*  459 */     this.jButton1 = new JButton();
/*      */     
/*  461 */     this.jDialog1.setTitle("Crear Nuevo");
/*  462 */     this.jDialog1.setModal(true);
/*      */     
/*  464 */     this.jToolBar1.setFloatable(false);
/*      */     
/*  466 */     this.jLabel10.setText("Facturas Abonadas:   ");
/*  467 */     this.jToolBar1.add(this.jLabel10);
/*      */     
/*  469 */     this.jLabel13.setFont(new Font("Tahoma", 1, 11));
/*  470 */     this.jLabel13.setForeground(Color.blue);
/*  471 */     this.jLabel13.setText(" jLabel13 ");
/*  472 */     this.jToolBar1.add(this.jLabel13);
/*      */     
/*  474 */     this.jSeparator3.setForeground(new Color(255, 153, 0));
/*  475 */     this.jToolBar1.add(this.jSeparator3);
/*      */     
/*  477 */     this.jLabel14.setText(" Facturas Saldadas:   ");
/*  478 */     this.jToolBar1.add(this.jLabel14);
/*      */     
/*  480 */     this.jLabel16.setFont(new Font("Tahoma", 1, 11));
/*  481 */     this.jLabel16.setForeground(Color.blue);
/*  482 */     this.jLabel16.setText(" jLabel16 ");
/*  483 */     this.jToolBar1.add(this.jLabel16);
/*      */     
/*  485 */     this.jSeparator4.setForeground(new Color(255, 153, 0));
/*  486 */     this.jToolBar1.add(this.jSeparator4);
/*      */     
/*  488 */     this.jLabel17.setText("Tota Parcial: ");
/*  489 */     this.jToolBar1.add(this.jLabel17);
/*      */     
/*  491 */     this.jLabel40.setFont(new Font("Tahoma", 1, 11));
/*  492 */     this.jLabel40.setForeground(Color.blue);
/*  493 */     this.jLabel40.setText("0");
/*  494 */     this.jToolBar1.add(this.jLabel40);
/*  495 */     this.jToolBar1.add(this.jSeparator2);
/*      */     
/*  497 */     this.jLabel20.setText("Total General: ");
/*  498 */     this.jToolBar1.add(this.jLabel20);
/*      */     
/*  500 */     this.jLabel18.setFont(new Font("Tahoma", 1, 11));
/*  501 */     this.jLabel18.setForeground(Color.blue);
/*  502 */     this.jLabel18.setText("    jLabel18");
/*  503 */     this.jToolBar1.add(this.jLabel18);
/*      */     
/*  505 */     this.jPanel12.setBackground(new Color(146, 193, 134));
/*      */     
/*  507 */     this.jPanel13.setBackground(new Color(146, 193, 134));
/*      */     
/*  509 */     this.jLabel26.setFont(new Font("Tahoma", 1, 11));
/*  510 */     this.jLabel26.setText("Folio:");
/*      */     
/*  512 */     this.jTextField5.setEditable(false);
/*  513 */     this.jTextField5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  515 */             ampararFacturas.this.jTextField5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  519 */     this.jLabel2.setFont(new Font("Tahoma", 1, 14));
/*  520 */     this.jLabel2.setHorizontalAlignment(0);
/*  521 */     this.jLabel2.setText("Saldar facturas por Depósito Bancario");
/*      */     
/*  523 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/*  524 */     this.jPanel13.setLayout(jPanel13Layout);
/*  525 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/*  526 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  527 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  528 */           .addComponent(this.jLabel26, -2, 44, -2)
/*  529 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  530 */           .addComponent(this.jTextField5, -2, 141, -2)
/*  531 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  532 */           .addComponent(this.jLabel2, -2, 486, -2)));
/*      */     
/*  534 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/*  535 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  536 */         .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  537 */           .addComponent(this.jTextField5, -2, -1, -2)
/*  538 */           .addComponent(this.jLabel26)
/*  539 */           .addComponent(this.jLabel2)));
/*      */ 
/*      */     
/*  542 */     this.jPanel19.setBackground(new Color(146, 193, 134));
/*  543 */     this.jPanel19.setBorder(BorderFactory.createTitledBorder("Información del depósito"));
/*  544 */     this.jPanel19.setLayout(new GridLayout(1, 2, 18, 0));
/*      */     
/*  546 */     this.jPanel20.setBackground(new Color(146, 193, 134));
/*  547 */     this.jPanel20.setLayout(new GridLayout(3, 2, 6, 6));
/*      */     
/*  549 */     this.jLabel28.setFont(new Font("Tahoma", 1, 11));
/*  550 */     this.jLabel28.setText("Banco");
/*  551 */     this.jPanel20.add(this.jLabel28);
/*      */     
/*  553 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/*  554 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "Banco" }));
/*  555 */     this.jComboBox8.setEnabled(false);
/*  556 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  558 */             ampararFacturas.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/*  561 */     this.jPanel20.add(this.jComboBox8);
/*      */     
/*  563 */     this.jLabel15.setFont(new Font("Tahoma", 1, 11));
/*  564 */     this.jLabel15.setText("Cuenta");
/*  565 */     this.jPanel20.add(this.jLabel15);
/*      */     
/*  567 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/*  568 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "Cuenta" }));
/*  569 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  571 */             ampararFacturas.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/*  574 */     this.jPanel20.add(this.jComboBox7);
/*      */     
/*  576 */     this.jLabel29.setText("Referencia");
/*  577 */     this.jPanel20.add(this.jLabel29);
/*      */     
/*  579 */     this.jTextField8.setText("Ref");
/*  580 */     this.jPanel20.add(this.jTextField8);
/*      */     
/*  582 */     this.jPanel19.add(this.jPanel20);
/*      */     
/*  584 */     this.jPanel21.setBackground(new Color(146, 193, 134));
/*  585 */     this.jPanel21.setLayout(new GridLayout(3, 3, 6, 6));
/*      */     
/*  587 */     this.jLabel19.setFont(new Font("Tahoma", 1, 11));
/*  588 */     this.jLabel19.setHorizontalAlignment(2);
/*  589 */     this.jLabel19.setText("Fecha Actual");
/*  590 */     this.jPanel21.add(this.jLabel19);
/*      */     
/*  592 */     this.jDateChooser8.setDate(this.fechaActual);
/*  593 */     this.jDateChooser8.setDateFormatString("dd/MM/yyyy");
/*  594 */     this.jDateChooser8.setEnabled(false);
/*  595 */     this.jDateChooser8.setIcon(this.icon);
/*  596 */     this.jDateChooser8.setMaxSelectableDate(this.fecha);
/*  597 */     this.jDateChooser8.setMinSelectableDate(this.fechaInicio);
/*  598 */     this.jPanel21.add((Component)this.jDateChooser8);
/*      */     
/*  600 */     this.jLabel11.setFont(new Font("Tahoma", 1, 11));
/*  601 */     this.jLabel11.setText("Fecha del depósito:");
/*  602 */     this.jPanel21.add(this.jLabel11);
/*      */     
/*  604 */     this.jDateChooser7.setDate(this.fechaActual);
/*  605 */     this.jDateChooser7.setDateFormatString("dd/MM/yyyy");
/*  606 */     this.jDateChooser7.setIcon(this.icon);
/*  607 */     this.jDateChooser7.setMaxSelectableDate(this.fecha);
/*  608 */     this.jDateChooser7.setMinSelectableDate(this.fechaInicio);
/*  609 */     this.jPanel21.add((Component)this.jDateChooser7);
/*      */     
/*  611 */     this.jLabel12.setFont(new Font("Tahoma", 1, 11));
/*  612 */     this.jLabel12.setHorizontalAlignment(2);
/*  613 */     this.jLabel12.setText("Monto:");
/*  614 */     this.jPanel21.add(this.jLabel12);
/*      */     
/*  616 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/*  617 */     this.jFormattedTextField1.setText("Monto");
/*  618 */     this.jPanel21.add(this.jFormattedTextField1);
/*      */     
/*  620 */     this.jPanel19.add(this.jPanel21);
/*      */     
/*  622 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/*  623 */     this.jPanel6.setBorder(BorderFactory.createTitledBorder("Búsqueda de facturas"));
/*  624 */     this.jPanel6.setLayout(new GridLayout(1, 5, 18, 0));
/*      */     
/*  626 */     this.jPanel37.setBackground(new Color(146, 193, 134));
/*  627 */     this.jPanel37.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  629 */     this.jLabel8.setText("A partir de:");
/*  630 */     this.jPanel37.add(this.jLabel8);
/*      */     
/*  632 */     this.jDateChooser6.setDate(this.fechaActual);
/*  633 */     this.jDateChooser6.setDateFormatString("dd/MM/yyyy");
/*  634 */     this.jDateChooser6.setIcon(this.icon);
/*  635 */     this.jDateChooser6.setMaxSelectableDate(this.fecha);
/*  636 */     this.jDateChooser6.setMinSelectableDate(this.fechaInicio);
/*  637 */     this.jPanel37.add((Component)this.jDateChooser6);
/*      */     
/*  639 */     this.jPanel6.add(this.jPanel37);
/*      */     
/*  641 */     this.jPanel38.setBackground(new Color(146, 193, 134));
/*  642 */     this.jPanel38.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/*  644 */     this.jButton7.setMnemonic('B');
/*  645 */     this.jButton7.setText("Buscar");
/*  646 */     this.jButton7.setToolTipText("Buscar Facturas (Alt+B)");
/*  647 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  649 */             ampararFacturas.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*  652 */     this.jPanel38.add(this.jButton7);
/*      */     
/*  654 */     this.jLabel3.setFont(new Font("Tahoma", 1, 11));
/*  655 */     this.jLabel3.setHorizontalAlignment(4);
/*  656 */     this.jLabel3.setText("Cliente:");
/*  657 */     this.jPanel38.add(this.jLabel3);
/*      */     
/*  659 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  660 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  662 */             ampararFacturas.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*  665 */     this.jPanel38.add(this.jComboBox4);
/*      */     
/*  667 */     this.jPanel6.add(this.jPanel38);
/*      */     
/*  669 */     this.jPanel22.setBackground(new Color(146, 193, 134));
/*  670 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder("Resultado de la búsqueda"));
/*  671 */     this.jPanel22.setLayout(new GridLayout(1, 2, 18, 0));
/*      */     
/*  673 */     this.jPanel23.setBackground(new Color(146, 193, 134));
/*  674 */     this.jPanel23.setLayout(new GridLayout(3, 2, 6, 6));
/*      */     
/*  676 */     this.jLabel9.setFont(new Font("Tahoma", 1, 11));
/*  677 */     this.jLabel9.setText("Factura:");
/*  678 */     this.jPanel23.add(this.jLabel9);
/*      */     
/*  680 */     this.jPanel15.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  682 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  683 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  685 */             ampararFacturas.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*  688 */     this.jPanel15.add(this.jComboBox5);
/*      */     
/*  690 */     this.jPanel23.add(this.jPanel15);
/*      */     
/*  692 */     this.jLabel36.setText("Fecha");
/*  693 */     this.jPanel23.add(this.jLabel36);
/*      */     
/*  695 */     this.jTextField11.setEnabled(false);
/*  696 */     this.jPanel23.add(this.jTextField11);
/*      */     
/*  698 */     this.jLabel37.setText("Importe Original");
/*  699 */     this.jPanel23.add(this.jLabel37);
/*      */     
/*  701 */     this.jTextField12.setHorizontalAlignment(4);
/*  702 */     this.jTextField12.setEnabled(false);
/*  703 */     this.jPanel23.add(this.jTextField12);
/*      */     
/*  705 */     this.jPanel22.add(this.jPanel23);
/*      */     
/*  707 */     this.jPanel14.setBackground(new Color(146, 193, 134));
/*  708 */     this.jPanel14.setLayout(new GridLayout(3, 0, 0, 6));
/*      */     
/*  710 */     this.jPanel33.setBackground(new Color(146, 193, 134));
/*  711 */     this.jPanel33.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/*  713 */     this.jButton2.setMnemonic('A');
/*  714 */     this.jButton2.setText("Amparar");
/*  715 */     this.jButton2.setToolTipText("Amparar Factura (Alt+A)");
/*  716 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  718 */             ampararFacturas.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*  721 */     this.jPanel33.add(this.jButton2);
/*      */     
/*  723 */     this.jPanel39.setBackground(new Color(146, 193, 134));
/*      */     
/*  725 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/*  726 */     this.jPanel39.setLayout(jPanel39Layout);
/*  727 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/*  728 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  729 */         .addGap(0, 107, 32767));
/*      */     
/*  731 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/*  732 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  733 */         .addGap(0, 26, 32767));
/*      */ 
/*      */     
/*  736 */     this.jPanel33.add(this.jPanel39);
/*      */     
/*  738 */     this.jPanel40.setBackground(new Color(146, 193, 134));
/*      */     
/*  740 */     GroupLayout jPanel40Layout = new GroupLayout(this.jPanel40);
/*  741 */     this.jPanel40.setLayout(jPanel40Layout);
/*  742 */     jPanel40Layout.setHorizontalGroup(jPanel40Layout
/*  743 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  744 */         .addGap(0, 107, 32767));
/*      */     
/*  746 */     jPanel40Layout.setVerticalGroup(jPanel40Layout
/*  747 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  748 */         .addGap(0, 26, 32767));
/*      */ 
/*      */     
/*  751 */     this.jPanel33.add(this.jPanel40);
/*      */     
/*  753 */     this.jPanel14.add(this.jPanel33);
/*      */     
/*  755 */     this.jPanel34.setBackground(new Color(146, 193, 134));
/*      */     
/*  757 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/*  758 */     this.jPanel34.setLayout(jPanel34Layout);
/*  759 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/*  760 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  761 */         .addGap(0, 333, 32767));
/*      */     
/*  763 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/*  764 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  765 */         .addGap(0, 26, 32767));
/*      */ 
/*      */     
/*  768 */     this.jPanel14.add(this.jPanel34);
/*      */     
/*  770 */     this.jPanel35.setBackground(new Color(146, 193, 134));
/*  771 */     this.jPanel35.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/*  773 */     this.jLabel38.setText("Importe Restante");
/*  774 */     this.jPanel35.add(this.jLabel38);
/*      */     
/*  776 */     this.jTextField13.setHorizontalAlignment(4);
/*  777 */     this.jTextField13.setEnabled(false);
/*  778 */     this.jTextField13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  780 */             ampararFacturas.this.jTextField13ActionPerformed(evt);
/*      */           }
/*      */         });
/*  783 */     this.jPanel35.add(this.jTextField13);
/*      */     
/*  785 */     this.jPanel14.add(this.jPanel35);
/*      */     
/*  787 */     this.jPanel22.add(this.jPanel14);
/*      */     
/*  789 */     this.jPanel36.setBackground(new Color(146, 193, 134));
/*      */     
/*  791 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Factura", "Monto Original", "Monto a Saldar", "Tipo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  799 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  804 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  807 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  809 */     this.jButton3.setMnemonic('C');
/*  810 */     this.jButton3.setText("Cerrar");
/*  811 */     this.jButton3.setToolTipText("Cerrar (Alt+C)");
/*  812 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  814 */             ampararFacturas.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  818 */     this.jButton4.setMnemonic('I');
/*  819 */     this.jButton4.setText("Imprimir");
/*  820 */     this.jButton4.setToolTipText("Imprimir (Alt+I)");
/*  821 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  823 */             ampararFacturas.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  827 */     this.jButton5.setMnemonic('Q');
/*  828 */     this.jButton5.setText("Quitar");
/*  829 */     this.jButton5.setToolTipText("Quitar Factura (Alt+Q)");
/*  830 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  832 */             ampararFacturas.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  836 */     this.jButton6.setText("Ingresar otra cantidad");
/*  837 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  839 */             ampararFacturas.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  843 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/*  844 */     this.jPanel36.setLayout(jPanel36Layout);
/*  845 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/*  846 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  847 */         .addComponent(this.jScrollPane1)
/*  848 */         .addGroup(jPanel36Layout.createSequentialGroup()
/*  849 */           .addComponent(this.jButton6, -2, 170, -2)
/*  850 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  851 */           .addComponent(this.jButton5, -2, 95, -2)
/*  852 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  853 */           .addComponent(this.jButton4, -2, 95, -2)
/*  854 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  855 */           .addComponent(this.jButton3, -2, 95, -2)));
/*      */     
/*  857 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/*  858 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  859 */         .addGroup(jPanel36Layout.createSequentialGroup()
/*  860 */           .addComponent(this.jScrollPane1, -1, 141, 32767)
/*  861 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  862 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  863 */             .addComponent(this.jButton3)
/*  864 */             .addComponent(this.jButton4)
/*  865 */             .addComponent(this.jButton5)
/*  866 */             .addComponent(this.jButton6))));
/*      */ 
/*      */     
/*  869 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/*  870 */     this.jPanel12.setLayout(jPanel12Layout);
/*  871 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/*  872 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  873 */         .addComponent(this.jPanel13, -1, -1, 32767)
/*  874 */         .addComponent(this.jSeparator1)
/*  875 */         .addComponent(this.jPanel19, -2, 0, 32767)
/*  876 */         .addComponent(this.jPanel6, -2, 0, 32767)
/*  877 */         .addComponent(this.jPanel22, -2, 0, 32767)
/*  878 */         .addComponent(this.jPanel36, -1, -1, 32767));
/*      */     
/*  880 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/*  881 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  882 */         .addGroup(jPanel12Layout.createSequentialGroup()
/*  883 */           .addComponent(this.jPanel13, -2, -1, -2)
/*  884 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  885 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  886 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  887 */           .addComponent(this.jPanel19, -2, -1, -2)
/*  888 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  889 */           .addComponent(this.jPanel6, -2, 47, -2)
/*  890 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  891 */           .addComponent(this.jPanel22, -2, 113, -2)
/*  892 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  893 */           .addComponent(this.jPanel36, -1, -1, 32767)));
/*      */ 
/*      */     
/*  896 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  897 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  898 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  899 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  900 */         .addComponent(this.jToolBar1, -1, -1, 32767)
/*  901 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/*  903 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  904 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  905 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  906 */           .addComponent(this.jPanel12, -1, -1, 32767)
/*  907 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  908 */           .addComponent(this.jToolBar1, -2, 25, -2)));
/*      */ 
/*      */     
/*  911 */     this.jDialog2.setTitle("Cantidad a saldar");
/*  912 */     this.jDialog2.setModal(true);
/*      */     
/*  914 */     this.jPanel4.setBackground(new Color(146, 193, 134));
/*      */     
/*  916 */     this.jLabel21.setFont(new Font("Tahoma", 1, 14));
/*  917 */     this.jLabel21.setHorizontalAlignment(0);
/*  918 */     this.jLabel21.setText("Coloca los datos del monto a saldar");
/*      */     
/*  920 */     this.jLabel22.setHorizontalAlignment(0);
/*  921 */     this.jLabel22.setText("Factura:");
/*      */     
/*  923 */     this.jTextField2.setEnabled(false);
/*      */     
/*  925 */     this.jLabel23.setHorizontalAlignment(0);
/*  926 */     this.jLabel23.setText("Importe Original");
/*      */     
/*  928 */     this.jLabel24.setHorizontalAlignment(0);
/*  929 */     this.jLabel24.setText("Importe a Saldar");
/*      */     
/*  931 */     this.jFormattedTextField2.setHorizontalAlignment(4);
/*      */     
/*  933 */     this.jLabel25.setHorizontalAlignment(0);
/*  934 */     this.jLabel25.setText("Tipo");
/*      */     
/*  936 */     this.jTextField3.setHorizontalAlignment(4);
/*  937 */     this.jTextField3.setEnabled(false);
/*      */     
/*  939 */     this.jButton8.setMnemonic('C');
/*  940 */     this.jButton8.setText("Cerrar");
/*  941 */     this.jButton8.setToolTipText("Cerrar (Alt+C)");
/*  942 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  944 */             ampararFacturas.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  948 */     this.jButton9.setMnemonic('A');
/*  949 */     this.jButton9.setText("Aceptar");
/*  950 */     this.jButton9.setToolTipText("Aceptar (Alt+A)");
/*  951 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  953 */             ampararFacturas.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  957 */     this.jTextField4.setHorizontalAlignment(4);
/*  958 */     this.jTextField4.setEnabled(false);
/*      */     
/*  960 */     this.jLabel30.setHorizontalAlignment(0);
/*  961 */     this.jLabel30.setText("Importe Restante");
/*      */     
/*  963 */     this.jTextField9.setHorizontalAlignment(4);
/*  964 */     this.jTextField9.setEnabled(false);
/*      */     
/*  966 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  967 */     this.jPanel4.setLayout(jPanel4Layout);
/*  968 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  969 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  970 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  971 */           .addContainerGap()
/*  972 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  973 */             .addComponent(this.jSeparator6)
/*  974 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  975 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  976 */                 .addComponent(this.jLabel22, GroupLayout.Alignment.LEADING, -2, 113, -2)
/*  977 */                 .addComponent(this.jTextField2, GroupLayout.Alignment.LEADING, -2, 113, -2))
/*  978 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  979 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  980 */                 .addComponent(this.jTextField4)
/*  981 */                 .addComponent(this.jLabel23, -1, 113, 32767))
/*  982 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  983 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  984 */                 .addComponent(this.jTextField9)
/*  985 */                 .addComponent(this.jLabel30, -2, 113, -2))
/*  986 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  987 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  988 */                 .addComponent(this.jLabel24, -2, 117, -2)
/*  989 */                 .addComponent(this.jFormattedTextField2, -2, 117, -2))
/*  990 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  991 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  992 */                 .addComponent(this.jLabel25, GroupLayout.Alignment.LEADING, -2, 113, -2)
/*  993 */                 .addComponent(this.jTextField3, GroupLayout.Alignment.LEADING, -2, 113, -2))
/*  994 */               .addGap(0, 3, 32767))
/*  995 */             .addComponent(this.jLabel21, -1, -1, 32767)
/*  996 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/*  997 */               .addGap(0, 0, 32767)
/*  998 */               .addComponent(this.jButton9, -2, 88, -2)
/*  999 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1000 */               .addComponent(this.jButton8, -2, 88, -2))
/* 1001 */             .addComponent(this.jSeparator5))
/* 1002 */           .addContainerGap()));
/*      */     
/* 1004 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 1005 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1006 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1007 */           .addComponent(this.jLabel21)
/* 1008 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1009 */           .addComponent(this.jSeparator5, -2, 10, -2)
/* 1010 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1011 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1012 */             .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1013 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1014 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 1015 */                   .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1016 */                     .addComponent(this.jLabel22)
/* 1017 */                     .addComponent(this.jLabel23))
/* 1018 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1019 */                   .addComponent(this.jTextField2, -2, -1, -2))
/* 1020 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 1021 */                   .addGap(20, 20, 20)
/* 1022 */                   .addComponent(this.jTextField4, -2, -1, -2)))
/* 1023 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1024 */                 .addComponent(this.jLabel30)
/* 1025 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/* 1026 */                   .addGap(20, 20, 20)
/* 1027 */                   .addComponent(this.jTextField9, -2, -1, -2))))
/* 1028 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 1029 */               .addComponent(this.jLabel24)
/* 1030 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1031 */               .addComponent(this.jFormattedTextField2, -2, -1, -2))
/* 1032 */             .addGroup(jPanel4Layout.createSequentialGroup()
/* 1033 */               .addComponent(this.jLabel25)
/* 1034 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1035 */               .addComponent(this.jTextField3, -2, -1, -2)))
/* 1036 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1037 */           .addComponent(this.jSeparator6, -2, 10, -2)
/* 1038 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1039 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1040 */             .addComponent(this.jButton8)
/* 1041 */             .addComponent(this.jButton9))
/* 1042 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1045 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1046 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1047 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1048 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1049 */         .addGroup(jDialog2Layout.createSequentialGroup()
/* 1050 */           .addComponent(this.jPanel4, -2, -1, -2)
/* 1051 */           .addGap(0, 0, 32767)));
/*      */     
/* 1053 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1054 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1055 */         .addComponent(this.jPanel4, -2, -1, -2));
/*      */ 
/*      */     
/* 1058 */     this.jDialog3.setTitle("Cancelar Documento");
/* 1059 */     this.jDialog3.setModal(true);
/*      */     
/* 1061 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*      */     
/* 1063 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/* 1064 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/* 1065 */     this.jLabel124.setHorizontalAlignment(0);
/* 1066 */     this.jLabel124.setText("Motivo de la Cancelación");
/*      */     
/* 1068 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/* 1069 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/* 1070 */     this.jLabel125.setHorizontalAlignment(4);
/* 1071 */     this.jLabel125.setText("Motivo");
/*      */     
/* 1073 */     this.jButton44.setMnemonic('A');
/* 1074 */     this.jButton44.setText("Cancelar Documento");
/* 1075 */     this.jButton44.setToolTipText("Cancelar Documento (Alt+A)");
/* 1076 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1078 */             ampararFacturas.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1082 */     this.jButton45.setMnemonic('C');
/* 1083 */     this.jButton45.setText("Cerrar");
/* 1084 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 1085 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1087 */             ampararFacturas.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1091 */     this.jTextArea5.setColumns(20);
/* 1092 */     this.jTextArea5.setLineWrap(true);
/* 1093 */     this.jTextArea5.setRows(5);
/* 1094 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 1096 */     this.jLabel126.setText("Ingresa el motivo por el cual deseas cancelar el documento");
/*      */     
/* 1098 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1099 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1100 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1101 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1102 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1103 */           .addContainerGap()
/* 1104 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1105 */             .addComponent(this.jLabel126, -1, -1, 32767)
/* 1106 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1107 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 1108 */                 .addComponent(this.jButton44, -2, 151, -2)
/* 1109 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1110 */                 .addComponent(this.jButton45, -2, 84, -2))
/* 1111 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 1112 */                 .addComponent(this.jLabel125, -2, 43, -2)
/* 1113 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1114 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/* 1115 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1116 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1117 */               .addComponent(this.jSeparator29, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/* 1118 */           .addContainerGap()));
/*      */     
/* 1120 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1121 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1122 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1123 */           .addComponent(this.jLabel124)
/* 1124 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1125 */           .addComponent(this.jSeparator29, -2, 10, -2)
/* 1126 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1127 */           .addComponent(this.jLabel126)
/* 1128 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1129 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1130 */             .addComponent(this.jLabel125)
/* 1131 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 1132 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1133 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1134 */             .addComponent(this.jButton45)
/* 1135 */             .addComponent(this.jButton44))
/* 1136 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1139 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1140 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1141 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1142 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1143 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */     
/* 1145 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1146 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1147 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */ 
/*      */     
/* 1150 */     this.jDialog4.setTitle("Recibir Recepción");
/* 1151 */     this.jDialog4.setModal(true);
/*      */     
/* 1153 */     this.jPanel30.setBackground(new Color(146, 193, 134));
/*      */     
/* 1155 */     this.jLabel127.setFont(new Font("Tahoma", 1, 14));
/* 1156 */     this.jLabel127.setForeground(new Color(0, 102, 102));
/* 1157 */     this.jLabel127.setHorizontalAlignment(0);
/* 1158 */     this.jLabel127.setText("Recibir Recepción");
/*      */     
/* 1160 */     this.jLabel27.setText("¿Deseas agregar algún comentario?");
/*      */     
/* 1162 */     this.jTextArea3.setColumns(20);
/* 1163 */     this.jTextArea3.setLineWrap(true);
/* 1164 */     this.jTextArea3.setRows(5);
/* 1165 */     this.jScrollPane7.setViewportView(this.jTextArea3);
/*      */     
/* 1167 */     this.jButton11.setMnemonic('C');
/* 1168 */     this.jButton11.setText("Cancelar");
/* 1169 */     this.jButton11.setToolTipText("Cerrar (Alt+C)");
/* 1170 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1172 */             ampararFacturas.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1176 */     this.jButton12.setMnemonic('A');
/* 1177 */     this.jButton12.setText("Aceptar");
/* 1178 */     this.jButton12.setToolTipText("Aceptar (Alt+A)");
/* 1179 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1181 */             ampararFacturas.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1185 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 1186 */     this.jPanel30.setLayout(jPanel30Layout);
/* 1187 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 1188 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1189 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 1190 */           .addContainerGap()
/* 1191 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1192 */             .addComponent(this.jSeparator28, -1, 359, 32767)
/* 1193 */             .addComponent(this.jLabel127, -1, 359, 32767)
/* 1194 */             .addComponent(this.jLabel27, -2, 261, -2)
/* 1195 */             .addComponent(this.jScrollPane7, -1, 359, 32767)
/* 1196 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
/* 1197 */               .addComponent(this.jButton12, -2, 93, -2)
/* 1198 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1199 */               .addComponent(this.jButton11, -2, 93, -2)))
/* 1200 */           .addContainerGap()));
/*      */     
/* 1202 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 1203 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1204 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 1205 */           .addComponent(this.jLabel127)
/* 1206 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1207 */           .addComponent(this.jSeparator28, -2, 10, -2)
/* 1208 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1209 */           .addComponent(this.jLabel27)
/* 1210 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1211 */           .addComponent(this.jScrollPane7, -2, 113, -2)
/* 1212 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1213 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1214 */             .addComponent(this.jButton11)
/* 1215 */             .addComponent(this.jButton12))
/* 1216 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1219 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1220 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1221 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1222 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1223 */         .addComponent(this.jPanel30, -1, -1, 32767));
/*      */     
/* 1225 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1226 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1227 */         .addComponent(this.jPanel30, -2, -1, -2));
/*      */ 
/*      */     
/* 1230 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1231 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1232 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1233 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1234 */         .addGap(0, 600, 32767)
/* 1235 */         .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1236 */           .addGroup(jPanel9Layout.createSequentialGroup()
/* 1237 */             .addGap(213, 213, 213)
/* 1238 */             .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1239 */               .addComponent(this.jTextField6, -2, 173, -2)
/* 1240 */               .addComponent(this.jTextField7, -2, 173, -2))
/* 1241 */             .addContainerGap(214, 32767))));
/*      */     
/* 1243 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1244 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1245 */         .addGap(0, 320, 32767)
/* 1246 */         .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1247 */           .addGroup(jPanel9Layout.createSequentialGroup()
/* 1248 */             .addGap(136, 136, 136)
/* 1249 */             .addComponent(this.jTextField6)
/* 1250 */             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1251 */             .addComponent(this.jTextField7, -2, -1, -2)
/* 1252 */             .addGap(136, 136, 136))));
/*      */ 
/*      */     
/* 1255 */     this.jDialog5.setTitle("Ingresar otra cantidad");
/* 1256 */     this.jDialog5.setModal(true);
/*      */     
/* 1258 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*      */     
/* 1260 */     this.jLabel34.setFont(new Font("Tahoma", 1, 14));
/* 1261 */     this.jLabel34.setHorizontalAlignment(0);
/* 1262 */     this.jLabel34.setText("Coloca los datos del complemento del deposito");
/*      */     
/* 1264 */     this.jLabel39.setHorizontalAlignment(0);
/* 1265 */     this.jLabel39.setText("Sucursal:");
/*      */     
/* 1267 */     this.jLabel41.setHorizontalAlignment(0);
/* 1268 */     this.jLabel41.setText("Importe a Saldar");
/*      */     
/* 1270 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/*      */     
/* 1272 */     this.jButton10.setMnemonic('C');
/* 1273 */     this.jButton10.setText("Cerrar");
/* 1274 */     this.jButton10.setToolTipText("Cerrar (Alt+C)");
/* 1275 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1277 */             ampararFacturas.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1281 */     this.jButton13.setMnemonic('A');
/* 1282 */     this.jButton13.setText("Aceptar");
/* 1283 */     this.jButton13.setToolTipText("Aceptar (Alt+A)");
/* 1284 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1286 */             ampararFacturas.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1290 */     this.jLabel43.setHorizontalAlignment(0);
/* 1291 */     this.jLabel43.setText("Ingresa algún otro dato como facturas:");
/*      */     
/* 1293 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 1294 */     this.jComboBox9.setEditable(true);
/* 1295 */     this.jComboBox9.setModel(new DefaultComboBoxModel<>(new String[] { "CADEREYTA", "CÁRDENAS", "POZA RICA", "VERACRUZ" }));
/*      */     
/* 1297 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1298 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1299 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1300 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1301 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1302 */           .addContainerGap()
/* 1303 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1304 */             .addComponent(this.jSeparator8)
/* 1305 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 1306 */               .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1307 */                 .addComponent(this.jTextField10)
/* 1308 */                 .addComponent(this.jLabel43, -1, -1, 32767))
/* 1309 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1310 */               .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1311 */                 .addComponent(this.jLabel41, -2, 117, -2)
/* 1312 */                 .addComponent(this.jFormattedTextField3, -2, 117, -2))
/* 1313 */               .addGap(8, 8, 8)
/* 1314 */               .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1315 */                 .addComponent(this.jLabel39, -1, -1, 32767)
/* 1316 */                 .addComponent(this.jComboBox9, -2, 165, -2)))
/* 1317 */             .addComponent(this.jLabel34, -1, 596, 32767)
/* 1318 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/* 1319 */               .addGap(0, 0, 32767)
/* 1320 */               .addComponent(this.jButton13, -2, 88, -2)
/* 1321 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1322 */               .addComponent(this.jButton10, -2, 88, -2))
/* 1323 */             .addComponent(this.jSeparator7))
/* 1324 */           .addContainerGap()));
/*      */     
/* 1326 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1327 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1328 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1329 */           .addComponent(this.jLabel34)
/* 1330 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1331 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 1332 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1333 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1334 */             .addComponent(this.jLabel43)
/* 1335 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 1336 */               .addComponent(this.jLabel41)
/* 1337 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1338 */               .addComponent(this.jFormattedTextField3, -2, -1, -2))
/* 1339 */             .addComponent(this.jLabel39)
/* 1340 */             .addGroup(jPanel10Layout.createSequentialGroup()
/* 1341 */               .addGap(20, 20, 20)
/* 1342 */               .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1343 */                 .addComponent(this.jTextField10, -2, -1, -2)
/* 1344 */                 .addComponent(this.jComboBox9, -2, -1, -2))))
/* 1345 */           .addGap(11, 11, 11)
/* 1346 */           .addComponent(this.jSeparator8, -2, 10, -2)
/* 1347 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1348 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1349 */             .addComponent(this.jButton10)
/* 1350 */             .addComponent(this.jButton13))
/* 1351 */           .addContainerGap(28, 32767)));
/*      */ 
/*      */     
/* 1354 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1355 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1356 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1357 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1358 */         .addGroup(jDialog5Layout.createSequentialGroup()
/* 1359 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 1360 */           .addGap(0, 0, 32767)));
/*      */     
/* 1362 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1363 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1364 */         .addComponent(this.jPanel10, -2, -1, -2));
/*      */ 
/*      */     
/* 1367 */     this.jDialog6.setTitle("Tipo de Reporte");
/* 1368 */     this.jDialog6.setModal(true);
/*      */     
/* 1370 */     this.jPanel11.setBackground(new Color(146, 193, 134));
/*      */     
/* 1372 */     this.jLabel92.setFont(new Font("Tahoma", 2, 11));
/* 1373 */     this.jLabel92.setForeground(new Color(0, 102, 102));
/* 1374 */     this.jLabel92.setHorizontalAlignment(0);
/* 1375 */     this.jLabel92.setText("Selecciona el tipo de reporte que deseas generar:");
/*      */     
/* 1377 */     this.jButton30.setMnemonic('I');
/* 1378 */     this.jButton30.setText("Aceptar");
/* 1379 */     this.jButton30.setToolTipText("Ir a Tarjetas (Alt+I)");
/* 1380 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1382 */             ampararFacturas.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1386 */     this.jButton31.setMnemonic('C');
/* 1387 */     this.jButton31.setText("Cancelar");
/* 1388 */     this.jButton31.setToolTipText("Cerrar (Alt+C)");
/* 1389 */     this.jButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1391 */             ampararFacturas.this.jButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1395 */     this.jRadioButton1.setSelected(true);
/* 1396 */     this.jRadioButton1.setText("Depósito bancario");
/*      */     
/* 1398 */     this.jRadioButton2.setText("Nota de crédito");
/*      */     
/* 1400 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1401 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1402 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1403 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1404 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1405 */           .addContainerGap()
/* 1406 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1407 */             .addComponent(this.jLabel92, -1, -1, 32767)
/* 1408 */             .addComponent(this.jSeparator11)
/* 1409 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 1410 */               .addComponent(this.jRadioButton1, -2, 143, -2)
/* 1411 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767)
/* 1412 */               .addComponent(this.jRadioButton2, -2, 143, -2))
/* 1413 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 1414 */               .addGap(0, 0, 32767)
/* 1415 */               .addComponent(this.jButton30, -2, 92, -2)
/* 1416 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1417 */               .addComponent(this.jButton31, -2, 91, -2)
/* 1418 */               .addGap(8, 8, 8)))
/* 1419 */           .addContainerGap()));
/*      */     
/* 1421 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1422 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1423 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1424 */           .addComponent(this.jLabel92)
/* 1425 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1426 */           .addComponent(this.jSeparator11, -2, 10, -2)
/* 1427 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1428 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1429 */             .addComponent(this.jRadioButton1)
/* 1430 */             .addComponent(this.jRadioButton2))
/* 1431 */           .addGap(18, 18, 18)
/* 1432 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1433 */             .addComponent(this.jButton31)
/* 1434 */             .addComponent(this.jButton30))
/* 1435 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1438 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1439 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1440 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1441 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1442 */         .addGroup(jDialog6Layout.createSequentialGroup()
/* 1443 */           .addComponent(this.jPanel11, -2, -1, -2)
/* 1444 */           .addGap(0, 0, 32767)));
/*      */     
/* 1446 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1447 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1448 */         .addGroup(jDialog6Layout.createSequentialGroup()
/* 1449 */           .addComponent(this.jPanel11, -1, -1, 32767)
/* 1450 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1453 */     this.jDialog8.setTitle("Crear Nuevo");
/* 1454 */     this.jDialog8.setModal(true);
/*      */     
/* 1456 */     this.jToolBar3.setFloatable(false);
/*      */     
/* 1458 */     this.jLabel88.setText("Facturas Abonadas:   ");
/* 1459 */     this.jToolBar3.add(this.jLabel88);
/*      */     
/* 1461 */     this.jLabel89.setFont(new Font("Tahoma", 1, 11));
/* 1462 */     this.jLabel89.setForeground(Color.blue);
/* 1463 */     this.jLabel89.setText(" jLabel13 ");
/* 1464 */     this.jToolBar3.add(this.jLabel89);
/*      */     
/* 1466 */     this.jSeparator15.setForeground(new Color(255, 153, 0));
/* 1467 */     this.jToolBar3.add(this.jSeparator15);
/*      */     
/* 1469 */     this.jLabel90.setText(" Facturas Saldadas:   ");
/* 1470 */     this.jToolBar3.add(this.jLabel90);
/*      */     
/* 1472 */     this.jLabel91.setFont(new Font("Tahoma", 1, 11));
/* 1473 */     this.jLabel91.setForeground(Color.blue);
/* 1474 */     this.jLabel91.setText(" jLabel16 ");
/* 1475 */     this.jToolBar3.add(this.jLabel91);
/*      */     
/* 1477 */     this.jSeparator16.setForeground(new Color(255, 153, 0));
/* 1478 */     this.jToolBar3.add(this.jSeparator16);
/*      */     
/* 1480 */     this.jLabel93.setText("Total Parcial: ");
/* 1481 */     this.jToolBar3.add(this.jLabel93);
/*      */     
/* 1483 */     this.jLabel94.setFont(new Font("Tahoma", 1, 11));
/* 1484 */     this.jLabel94.setForeground(Color.blue);
/* 1485 */     this.jLabel94.setText("0");
/* 1486 */     this.jToolBar3.add(this.jLabel94);
/* 1487 */     this.jToolBar3.add(this.jSeparator17);
/*      */     
/* 1489 */     this.jLabel95.setText("Total General: ");
/* 1490 */     this.jToolBar3.add(this.jLabel95);
/*      */     
/* 1492 */     this.jLabel96.setFont(new Font("Tahoma", 1, 11));
/* 1493 */     this.jLabel96.setForeground(Color.blue);
/* 1494 */     this.jLabel96.setText("    jLabel18");
/* 1495 */     this.jToolBar3.add(this.jLabel96);
/*      */     
/* 1497 */     this.jPanel41.setBackground(new Color(146, 193, 134));
/*      */     
/* 1499 */     this.jLabel75.setFont(new Font("Tahoma", 1, 11));
/* 1500 */     this.jLabel75.setText("Folio:");
/*      */     
/* 1502 */     this.jTextField19.setEditable(false);
/* 1503 */     this.jTextField19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1505 */             ampararFacturas.this.jTextField19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1509 */     this.jLabel72.setFont(new Font("Tahoma", 1, 14));
/* 1510 */     this.jLabel72.setHorizontalAlignment(0);
/* 1511 */     this.jLabel72.setText("Saldar facturas por Nota de Crédito");
/*      */     
/* 1513 */     this.jPanel26.setBackground(new Color(146, 193, 134));
/* 1514 */     this.jPanel26.setBorder(BorderFactory.createTitledBorder("Información del depósito"));
/* 1515 */     this.jPanel26.setLayout(new GridLayout(1, 2, 18, 0));
/*      */     
/* 1517 */     this.jPanel27.setBackground(new Color(146, 193, 134));
/* 1518 */     this.jPanel27.setLayout(new GridLayout(3, 2, 6, 6));
/*      */     
/* 1520 */     this.jLabel80.setFont(new Font("Tahoma", 1, 11));
/* 1521 */     this.jLabel80.setText("Nota de Crédito");
/* 1522 */     this.jPanel27.add(this.jLabel80);
/* 1523 */     this.jPanel27.add(this.jTextField20);
/*      */     
/* 1525 */     this.jLabel83.setFont(new Font("Tahoma", 1, 11));
/* 1526 */     this.jLabel83.setHorizontalAlignment(2);
/* 1527 */     this.jLabel83.setText("Monto:");
/* 1528 */     this.jPanel27.add(this.jLabel83);
/*      */     
/* 1530 */     this.jFormattedTextField5.setHorizontalAlignment(4);
/* 1531 */     this.jPanel27.add(this.jFormattedTextField5);
/*      */     
/* 1533 */     this.jLabel81.setFont(new Font("Tahoma", 1, 11));
/* 1534 */     this.jLabel81.setHorizontalAlignment(2);
/* 1535 */     this.jLabel81.setText("Fecha de la nota");
/* 1536 */     this.jPanel27.add(this.jLabel81);
/*      */     
/* 1538 */     this.jDateChooser13.setDate(this.fechaActual);
/* 1539 */     this.jDateChooser13.setDateFormatString("dd/MM/yyyy");
/* 1540 */     this.jDateChooser13.setIcon(this.icon);
/* 1541 */     this.jDateChooser13.setMaxSelectableDate(this.fecha);
/* 1542 */     this.jDateChooser13.setMinSelectableDate(this.fechaInicio);
/* 1543 */     this.jPanel27.add((Component)this.jDateChooser13);
/*      */     
/* 1545 */     this.jPanel26.add(this.jPanel27);
/*      */     
/* 1547 */     this.jPanel28.setBackground(new Color(146, 193, 134));
/* 1548 */     this.jPanel28.setLayout(new GridLayout(3, 0, 0, 6));
/*      */     
/* 1550 */     this.jPanel3.setBackground(new Color(146, 193, 134));
/* 1551 */     this.jPanel3.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1553 */     this.jLabel82.setFont(new Font("Tahoma", 1, 11));
/* 1554 */     this.jLabel82.setText("Fecha de creación");
/* 1555 */     this.jPanel3.add(this.jLabel82);
/*      */     
/* 1557 */     this.jDateChooser14.setDate(this.fechaActual);
/* 1558 */     this.jDateChooser14.setDateFormatString("dd/MM/yyyy");
/* 1559 */     this.jDateChooser14.setEnabled(false);
/* 1560 */     this.jDateChooser14.setIcon(this.icon);
/* 1561 */     this.jDateChooser14.setMaxSelectableDate(this.fecha);
/* 1562 */     this.jDateChooser14.setMinSelectableDate(this.fechaInicio);
/* 1563 */     this.jPanel3.add((Component)this.jDateChooser14);
/*      */     
/* 1565 */     this.jPanel28.add(this.jPanel3);
/*      */     
/* 1567 */     this.jPanel42.setBackground(new Color(146, 193, 134));
/*      */     
/* 1569 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/* 1570 */     this.jPanel42.setLayout(jPanel42Layout);
/* 1571 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/* 1572 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1573 */         .addGap(0, 342, 32767));
/*      */     
/* 1575 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/* 1576 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1577 */         .addGap(0, 27, 32767));
/*      */ 
/*      */     
/* 1580 */     this.jPanel28.add(this.jPanel42);
/*      */     
/* 1582 */     this.jPanel43.setBackground(new Color(146, 193, 134));
/*      */     
/* 1584 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 1585 */     this.jPanel43.setLayout(jPanel43Layout);
/* 1586 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 1587 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1588 */         .addGap(0, 342, 32767));
/*      */     
/* 1590 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 1591 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1592 */         .addGap(0, 27, 32767));
/*      */ 
/*      */     
/* 1595 */     this.jPanel28.add(this.jPanel43);
/*      */     
/* 1597 */     this.jPanel26.add(this.jPanel28);
/*      */     
/* 1599 */     this.jPanel25.setBackground(new Color(146, 193, 134));
/* 1600 */     this.jPanel25.setBorder(BorderFactory.createTitledBorder("Búsqueda de facturas"));
/* 1601 */     this.jPanel25.setLayout(new GridLayout(1, 2, 18, 0));
/*      */     
/* 1603 */     this.jPanel44.setBackground(new Color(146, 193, 134));
/* 1604 */     this.jPanel44.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1606 */     this.jLabel76.setText("A partir de:");
/* 1607 */     this.jPanel44.add(this.jLabel76);
/*      */     
/* 1609 */     this.jDateChooser12.setDate(this.fechaActual);
/* 1610 */     this.jDateChooser12.setDateFormatString("dd/MM/yyyy");
/* 1611 */     this.jDateChooser12.setIcon(this.icon);
/* 1612 */     this.jDateChooser12.setMaxSelectableDate(this.fecha);
/* 1613 */     this.jDateChooser12.setMinSelectableDate(this.fechaInicio);
/* 1614 */     this.jPanel44.add((Component)this.jDateChooser12);
/*      */     
/* 1616 */     this.jPanel25.add(this.jPanel44);
/*      */     
/* 1618 */     this.jPanel45.setBackground(new Color(146, 193, 134));
/* 1619 */     this.jPanel45.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/* 1621 */     this.jButton34.setMnemonic('B');
/* 1622 */     this.jButton34.setText("Buscar");
/* 1623 */     this.jButton34.setToolTipText("Buscar Facturas (Alt+B)");
/* 1624 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1626 */             ampararFacturas.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1629 */     this.jPanel45.add(this.jButton34);
/*      */     
/* 1631 */     this.jLabel77.setFont(new Font("Tahoma", 1, 11));
/* 1632 */     this.jLabel77.setHorizontalAlignment(4);
/* 1633 */     this.jLabel77.setText("Cliente:");
/* 1634 */     this.jPanel45.add(this.jLabel77);
/*      */     
/* 1636 */     this.jComboBox14.setBackground(new Color(244, 244, 244));
/* 1637 */     this.jComboBox14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1639 */             ampararFacturas.this.jComboBox14ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1642 */     this.jPanel45.add(this.jComboBox14);
/*      */     
/* 1644 */     this.jPanel25.add(this.jPanel45);
/*      */     
/* 1646 */     this.jPanel31.setBackground(new Color(146, 193, 134));
/* 1647 */     this.jPanel31.setBorder(BorderFactory.createTitledBorder("Resultado de la búsqueda"));
/* 1648 */     this.jPanel31.setLayout(new GridLayout(1, 2, 18, 0));
/*      */     
/* 1650 */     this.jPanel32.setBackground(new Color(146, 193, 134));
/* 1651 */     this.jPanel32.setLayout(new GridLayout(3, 2, 6, 6));
/*      */     
/* 1653 */     this.jLabel84.setFont(new Font("Tahoma", 1, 11));
/* 1654 */     this.jLabel84.setText("Factura:");
/* 1655 */     this.jPanel32.add(this.jLabel84);
/*      */     
/* 1657 */     this.jComboBox17.setBackground(new Color(244, 244, 244));
/* 1658 */     this.jComboBox17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1660 */             ampararFacturas.this.jComboBox17ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1663 */     this.jPanel32.add(this.jComboBox17);
/*      */     
/* 1665 */     this.jLabel85.setText("Fecha");
/* 1666 */     this.jPanel32.add(this.jLabel85);
/*      */     
/* 1668 */     this.jTextField21.setEnabled(false);
/* 1669 */     this.jPanel32.add(this.jTextField21);
/*      */     
/* 1671 */     this.jLabel86.setText("Importe Original");
/* 1672 */     this.jPanel32.add(this.jLabel86);
/*      */     
/* 1674 */     this.jTextField22.setHorizontalAlignment(4);
/* 1675 */     this.jTextField22.setEnabled(false);
/* 1676 */     this.jPanel32.add(this.jTextField22);
/*      */     
/* 1678 */     this.jPanel31.add(this.jPanel32);
/*      */     
/* 1680 */     this.jPanel46.setBackground(new Color(146, 193, 134));
/* 1681 */     this.jPanel46.setLayout(new GridLayout(3, 0, 0, 6));
/*      */     
/* 1683 */     this.jPanel47.setBackground(new Color(146, 193, 134));
/* 1684 */     this.jPanel47.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/* 1686 */     this.jButton36.setMnemonic('A');
/* 1687 */     this.jButton36.setText("Amparar");
/* 1688 */     this.jButton36.setToolTipText("Amparar Factura (Alt+A)");
/* 1689 */     this.jButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1691 */             ampararFacturas.this.jButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1694 */     this.jPanel47.add(this.jButton36);
/*      */     
/* 1696 */     this.jPanel50.setBackground(new Color(146, 193, 134));
/*      */     
/* 1698 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/* 1699 */     this.jPanel50.setLayout(jPanel50Layout);
/* 1700 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/* 1701 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1702 */         .addGap(0, 110, 32767));
/*      */     
/* 1704 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/* 1705 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1706 */         .addGap(0, 26, 32767));
/*      */ 
/*      */     
/* 1709 */     this.jPanel47.add(this.jPanel50);
/*      */     
/* 1711 */     this.jPanel51.setBackground(new Color(146, 193, 134));
/*      */     
/* 1713 */     GroupLayout jPanel51Layout = new GroupLayout(this.jPanel51);
/* 1714 */     this.jPanel51.setLayout(jPanel51Layout);
/* 1715 */     jPanel51Layout.setHorizontalGroup(jPanel51Layout
/* 1716 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1717 */         .addGap(0, 110, 32767));
/*      */     
/* 1719 */     jPanel51Layout.setVerticalGroup(jPanel51Layout
/* 1720 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1721 */         .addGap(0, 26, 32767));
/*      */ 
/*      */     
/* 1724 */     this.jPanel47.add(this.jPanel51);
/*      */     
/* 1726 */     this.jPanel46.add(this.jPanel47);
/*      */     
/* 1728 */     this.jPanel48.setBackground(new Color(146, 193, 134));
/*      */     
/* 1730 */     GroupLayout jPanel48Layout = new GroupLayout(this.jPanel48);
/* 1731 */     this.jPanel48.setLayout(jPanel48Layout);
/* 1732 */     jPanel48Layout.setHorizontalGroup(jPanel48Layout
/* 1733 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1734 */         .addGap(0, 342, 32767));
/*      */     
/* 1736 */     jPanel48Layout.setVerticalGroup(jPanel48Layout
/* 1737 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1738 */         .addGap(0, 26, 32767));
/*      */ 
/*      */     
/* 1741 */     this.jPanel46.add(this.jPanel48);
/*      */     
/* 1743 */     this.jPanel49.setBackground(new Color(146, 193, 134));
/* 1744 */     this.jPanel49.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1746 */     this.jLabel87.setText("Importe Restante");
/* 1747 */     this.jPanel49.add(this.jLabel87);
/*      */     
/* 1749 */     this.jTextField23.setHorizontalAlignment(4);
/* 1750 */     this.jTextField23.setEnabled(false);
/* 1751 */     this.jTextField23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1753 */             ampararFacturas.this.jTextField23ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1756 */     this.jPanel49.add(this.jTextField23);
/*      */     
/* 1758 */     this.jPanel46.add(this.jPanel49);
/*      */     
/* 1760 */     this.jPanel31.add(this.jPanel46);
/*      */     
/* 1762 */     this.jPanel52.setBackground(new Color(146, 193, 134));
/*      */     
/* 1764 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Factura", "Monto Original", "Monto a Saldar", "Tipo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1772 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1777 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1780 */     this.jScrollPane4.setViewportView(this.jTable4);
/*      */     
/* 1782 */     this.jButton21.setMnemonic('C');
/* 1783 */     this.jButton21.setText("Cerrar");
/* 1784 */     this.jButton21.setToolTipText("Cerrar (Alt+C)");
/* 1785 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1787 */             ampararFacturas.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1791 */     this.jButton32.setMnemonic('I');
/* 1792 */     this.jButton32.setText("Imprimir");
/* 1793 */     this.jButton32.setToolTipText("Imprimir (Alt+I)");
/* 1794 */     this.jButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1796 */             ampararFacturas.this.jButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1800 */     this.jButton33.setMnemonic('Q');
/* 1801 */     this.jButton33.setText("Quitar");
/* 1802 */     this.jButton33.setToolTipText("Quitar Factura (Alt+Q)");
/* 1803 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1805 */             ampararFacturas.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1809 */     this.jButton35.setText("Ingresar otra cantidad");
/* 1810 */     this.jButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1812 */             ampararFacturas.this.jButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1816 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/* 1817 */     this.jPanel52.setLayout(jPanel52Layout);
/* 1818 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/* 1819 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1820 */         .addComponent(this.jScrollPane4)
/* 1821 */         .addGroup(jPanel52Layout.createSequentialGroup()
/* 1822 */           .addComponent(this.jButton35, -2, 170, -2)
/* 1823 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1824 */           .addComponent(this.jButton33, -2, 95, -2)
/* 1825 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1826 */           .addComponent(this.jButton32, -2, 95, -2)
/* 1827 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1828 */           .addComponent(this.jButton21, -2, 95, -2)));
/*      */     
/* 1830 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/* 1831 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1832 */         .addGroup(jPanel52Layout.createSequentialGroup()
/* 1833 */           .addComponent(this.jScrollPane4, -1, 199, 32767)
/* 1834 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1835 */           .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1836 */             .addComponent(this.jButton21)
/* 1837 */             .addComponent(this.jButton32)
/* 1838 */             .addComponent(this.jButton33)
/* 1839 */             .addComponent(this.jButton35))));
/*      */ 
/*      */     
/* 1842 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/* 1843 */     this.jPanel41.setLayout(jPanel41Layout);
/* 1844 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/* 1845 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1846 */         .addGroup(jPanel41Layout.createSequentialGroup()
/* 1847 */           .addComponent(this.jLabel75, -2, 44, -2)
/* 1848 */           .addGap(24, 24, 24)
/* 1849 */           .addComponent(this.jTextField19, -2, 141, -2)
/* 1850 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1851 */           .addComponent(this.jLabel72, -1, -1, 32767))
/* 1852 */         .addComponent(this.jSeparator14)
/* 1853 */         .addComponent(this.jPanel26, -1, -1, 32767)
/* 1854 */         .addComponent(this.jPanel25, -2, 0, 32767)
/* 1855 */         .addComponent(this.jPanel31, -2, 0, 32767)
/* 1856 */         .addComponent(this.jPanel52, -1, -1, 32767));
/*      */     
/* 1858 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/* 1859 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1860 */         .addGroup(jPanel41Layout.createSequentialGroup()
/* 1861 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1862 */             .addComponent(this.jTextField19, -2, -1, -2)
/* 1863 */             .addComponent(this.jLabel75)
/* 1864 */             .addComponent(this.jLabel72))
/* 1865 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1866 */           .addComponent(this.jSeparator14, -2, 10, -2)
/* 1867 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1868 */           .addComponent(this.jPanel26, -2, 115, -2)
/* 1869 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1870 */           .addComponent(this.jPanel25, -2, 47, -2)
/* 1871 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1872 */           .addComponent(this.jPanel31, -2, 113, -2)
/* 1873 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1874 */           .addComponent(this.jPanel52, -1, -1, 32767)));
/*      */ 
/*      */     
/* 1877 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 1878 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 1879 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 1880 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1881 */         .addComponent(this.jToolBar3, -1, -1, 32767)
/* 1882 */         .addComponent(this.jPanel41, -1, -1, 32767));
/*      */     
/* 1884 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 1885 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1886 */         .addGroup(jDialog8Layout.createSequentialGroup()
/* 1887 */           .addComponent(this.jPanel41, -1, -1, 32767)
/* 1888 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1889 */           .addComponent(this.jToolBar3, -2, 25, -2)));
/*      */ 
/*      */     
/* 1892 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { { "valor1", "nuevo", "asd", "asd" }, , { "valor1.1", "asd", "sdf", "asddf" }, , { "sfsdf", "nuevo valor", "sdf", "asd" }, , { "34334", "nsjkd", "sdfsdf", "sdfsdf" },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1903 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/* 1905 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 1906 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1908 */     this.jLabel54.setFont(new Font("Times New Roman", 1, 24));
/* 1909 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 1910 */     this.jLabel54.setText("ENTREGAR DEPOSITOS");
/*      */     
/* 1912 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 1913 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1915 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1916 */     this.jLabel48.setForeground(Color.red);
/* 1917 */     this.jLabel48.setHorizontalAlignment(0);
/* 1918 */     this.jLabel48.setText("t");
/* 1919 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1921 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 1922 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Cliente", "Equipo", "Plataforma", "Pozo", "Subtotal", "Iva", "Ret", "Total", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1930 */     this.jTable3.setShowVerticalLines(false);
/* 1931 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1933 */             ampararFacturas.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1936 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1938 */             ampararFacturas.this.jTable3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1941 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/* 1943 */     this.jButton23.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 1944 */     this.jButton23.setMnemonic('V');
/* 1945 */     this.jButton23.setText("Ver");
/* 1946 */     this.jButton23.setToolTipText("Ver Documento(Alt+V)");
/* 1947 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1949 */             ampararFacturas.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1953 */     this.jButton20.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1954 */     this.jButton20.setMnemonic('G');
/* 1955 */     this.jButton20.setText("Guardar Reporte");
/* 1956 */     this.jButton20.setToolTipText("Guardar Reporte (Alt+G)");
/* 1957 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1959 */             ampararFacturas.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1963 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1964 */     this.jButton24.setMnemonic('N');
/* 1965 */     this.jButton24.setText("Nuevo");
/* 1966 */     this.jButton24.setToolTipText("Nuevo Documento (Alt+N)");
/* 1967 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1969 */             ampararFacturas.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1973 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1974 */     this.jButton26.setMnemonic('C');
/* 1975 */     this.jButton26.setText("Cancelar");
/* 1976 */     this.jButton26.setToolTipText("Cancelar Documentos (Alt+C)");
/* 1977 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1979 */             ampararFacturas.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1983 */     this.jButton27.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Refresh.png")));
/* 1984 */     this.jButton27.setMnemonic('C');
/* 1985 */     this.jButton27.setText("Recibir");
/* 1986 */     this.jButton27.setToolTipText("Cancelar Documentos (Alt+C)");
/* 1987 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1989 */             ampararFacturas.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1993 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/* 1994 */     this.jButton25.setMnemonic('N');
/* 1995 */     this.jButton25.setText("Modificar");
/* 1996 */     this.jButton25.setToolTipText("Nuevo Documento (Alt+N)");
/* 1997 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1999 */             ampararFacturas.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2003 */     this.jLabel31.setFont(new Font("Tahoma", 0, 10));
/* 2004 */     this.jLabel31.setHorizontalAlignment(4);
/* 2005 */     this.jLabel31.setText("jLabel31");
/*      */     
/* 2007 */     this.jLabel32.setFont(new Font("Tahoma", 0, 10));
/* 2008 */     this.jLabel32.setHorizontalAlignment(4);
/* 2009 */     this.jLabel32.setText("jLabel31");
/*      */     
/* 2011 */     this.jLabel33.setFont(new Font("Tahoma", 0, 10));
/* 2012 */     this.jLabel33.setHorizontalAlignment(4);
/* 2013 */     this.jLabel33.setText("jLabel31");
/*      */     
/* 2015 */     this.jLabel35.setFont(new Font("Tahoma", 1, 11));
/* 2016 */     this.jLabel35.setHorizontalAlignment(4);
/* 2017 */     this.jLabel35.setText("SUMAS:");
/*      */     
/* 2019 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 2020 */     this.jPanel5.setLayout(jPanel5Layout);
/* 2021 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 2022 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2023 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2024 */           .addComponent(this.jScrollPane3, -1, 1253, 32767)
/* 2025 */           .addContainerGap())
/* 2026 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2027 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 2028 */           .addGap(18, 18, 18)
/* 2029 */           .addComponent(this.jButton24, -2, 119, -2)
/* 2030 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2031 */           .addComponent(this.jButton25, -2, 119, -2)
/* 2032 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2033 */           .addComponent(this.jButton27, -2, 119, -2)
/* 2034 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2035 */           .addComponent(this.jButton26, -2, 119, -2)
/* 2036 */           .addGap(60, 60, 60)
/* 2037 */           .addComponent(this.jButton23, -2, 119, -2)
/* 2038 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2039 */           .addComponent(this.jButton20, -2, 150, -2)
/* 2040 */           .addGap(112, 112, 112))
/* 2041 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
/* 2042 */           .addGap(0, 0, 32767)
/* 2043 */           .addComponent(this.jLabel35, -2, 68, -2)
/* 2044 */           .addGap(26, 26, 26)
/* 2045 */           .addComponent(this.jLabel33, -2, 55, -2)
/* 2046 */           .addGap(53, 53, 53)
/* 2047 */           .addComponent(this.jLabel32, -2, 56, -2)
/* 2048 */           .addGap(18, 18, 18)
/* 2049 */           .addComponent(this.jLabel31, -2, 90, -2)
/* 2050 */           .addGap(136, 136, 136)));
/*      */     
/* 2052 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 2053 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2054 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 2055 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2056 */             .addComponent(this.jLabel48)
/* 2057 */             .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2058 */               .addComponent(this.jButton24, -2, 28, -2)
/* 2059 */               .addComponent(this.jButton25, -2, 28, -2)
/* 2060 */               .addComponent(this.jButton26, -2, 28, -2)
/* 2061 */               .addComponent(this.jButton27, -2, 28, -2)
/* 2062 */               .addComponent(this.jButton20)
/* 2063 */               .addComponent(this.jButton23, -2, 28, -2)))
/* 2064 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2065 */           .addComponent(this.jScrollPane3, -1, 157, 32767)
/* 2066 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2067 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2068 */             .addComponent(this.jLabel31)
/* 2069 */             .addComponent(this.jLabel32)
/* 2070 */             .addComponent(this.jLabel33)
/* 2071 */             .addComponent(this.jLabel35))));
/*      */ 
/*      */     
/* 2074 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 2075 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de depósitos", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2077 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2079 */             ampararFacturas.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2083 */     this.jLabel45.setFont(new Font("Tahoma", 3, 12));
/* 2084 */     this.jLabel45.setForeground(new Color(15, 87, 51));
/* 2085 */     this.jLabel45.setHorizontalAlignment(0);
/* 2086 */     this.jLabel45.setText("Estatus");
/*      */     
/* 2088 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 2089 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 2090 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2092 */             ampararFacturas.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2096 */     this.jLabel46.setFont(new Font("Tahoma", 3, 12));
/* 2097 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 2098 */     this.jLabel46.setHorizontalAlignment(0);
/* 2099 */     this.jLabel46.setText("Entrega");
/*      */     
/* 2101 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 2102 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 2103 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2105 */             ampararFacturas.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2109 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 2110 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 2111 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2113 */             ampararFacturas.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2117 */     this.jLabel47.setFont(new Font("Tahoma", 3, 12));
/* 2118 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/* 2119 */     this.jLabel47.setHorizontalAlignment(0);
/* 2120 */     this.jLabel47.setText("Recibe");
/*      */     
/* 2122 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 2123 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVOS", "<Cancelado>", "<Por Recibir>", "<Recibido>" }));
/* 2124 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2126 */             ampararFacturas.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2130 */     this.jLabel49.setFont(new Font("Tahoma", 3, 12));
/* 2131 */     this.jLabel49.setForeground(new Color(15, 87, 51));
/* 2132 */     this.jLabel49.setHorizontalAlignment(0);
/* 2133 */     this.jLabel49.setText("Cliente");
/*      */     
/* 2135 */     this.jLabel50.setFont(new Font("Tahoma", 3, 12));
/* 2136 */     this.jLabel50.setForeground(new Color(15, 87, 51));
/* 2137 */     this.jLabel50.setHorizontalAlignment(0);
/* 2138 */     this.jLabel50.setText("Folio");
/*      */     
/* 2140 */     this.jComboBoxMultiCol1.setOpaque(false);
/*      */     
/* 2142 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 2143 */     this.jPanel17.setLayout(jPanel17Layout);
/* 2144 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 2145 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2146 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2147 */           .addContainerGap()
/* 2148 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2149 */             .addComponent(this.jTextField1, -2, 81, -2)
/* 2150 */             .addComponent(this.jLabel50, -2, 77, -2))
/* 2151 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2152 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2153 */             .addComponent(this.jLabel45, -1, 190, 32767)
/* 2154 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2155 */               .addComponent(this.jComboBox6, 0, 186, 32767)
/* 2156 */               .addGap(4, 4, 4)))
/* 2157 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2158 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2159 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2160 */               .addComponent(this.jLabel49, -1, 227, 32767)
/* 2161 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2162 */               .addComponent(this.jLabel46, -2, 187, -2)
/* 2163 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2164 */               .addComponent(this.jLabel47, -2, 187, -2)
/* 2165 */               .addGap(346, 346, 346))
/* 2166 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2167 */               .addComponent(this.jComboBox1, -2, 219, -2)
/* 2168 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2169 */               .addComponent(this.jComboBox2, -2, 187, -2)
/* 2170 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2171 */               .addComponent(this.jComboBox3, -2, 187, -2)
/* 2172 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2173 */               .addComponent((Component)this.jComboBoxMultiCol1, -2, 196, -2)
/* 2174 */               .addContainerGap(-1, 32767)))));
/*      */     
/* 2176 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 2177 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2178 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2179 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2180 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2181 */               .addComponent(this.jTextField1, -2, -1, -2)
/* 2182 */               .addComponent(this.jComboBox6, -2, -1, -2))
/* 2183 */             .addComponent(this.jComboBox1, -2, -1, -2)
/* 2184 */             .addComponent(this.jComboBox2, -2, -1, -2)
/* 2185 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2186 */               .addComponent((Component)this.jComboBoxMultiCol1, -1, -1, 32767)
/* 2187 */               .addComponent(this.jComboBox3, -2, -1, -2)))
/* 2188 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2189 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2190 */               .addComponent(this.jLabel45)
/* 2191 */               .addComponent(this.jLabel50)
/* 2192 */               .addComponent(this.jLabel49))
/* 2193 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2194 */               .addGap(8, 8, 8)
/* 2195 */               .addComponent(this.jLabel46))
/* 2196 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 2197 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2198 */               .addComponent(this.jLabel47)))
/* 2199 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2202 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 2203 */     this.jPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 2205 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2206 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 2207 */     this.jDateChooser4.setIcon(this.icon);
/* 2208 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 2209 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2211 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2212 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 2213 */     this.jDateChooser5.setIcon(this.icon);
/* 2214 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 2215 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2217 */     this.jLabel5.setFont(new Font("Tahoma", 2, 12));
/* 2218 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/* 2219 */     this.jLabel5.setText("<html><u>Todos </u></html>");
/* 2220 */     this.jLabel5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2222 */             ampararFacturas.this.jLabel5MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2225 */             ampararFacturas.this.jLabel5MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2228 */             ampararFacturas.this.jLabel5MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2232 */     this.jLabel6.setFont(new Font("Tahoma", 2, 12));
/* 2233 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/* 2234 */     this.jLabel6.setHorizontalAlignment(0);
/* 2235 */     this.jLabel6.setText("<html><u>Hoy</u></html>");
/* 2236 */     this.jLabel6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2238 */             ampararFacturas.this.jLabel6MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2241 */             ampararFacturas.this.jLabel6MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2244 */             ampararFacturas.this.jLabel6MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2248 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/* 2249 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/* 2250 */     this.jLabel7.setText("<html><u>Ayer</u></html>");
/* 2251 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2253 */             ampararFacturas.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2256 */             ampararFacturas.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2259 */             ampararFacturas.this.jLabel7MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2263 */     this.jLabel1.setFont(new Font("Tahoma", 1, 15));
/* 2264 */     this.jLabel1.setForeground(Color.red);
/* 2265 */     this.jLabel1.setHorizontalAlignment(4);
/* 2266 */     this.jLabel1.setText("REPORTE DEL");
/*      */     
/* 2268 */     this.jLabel4.setFont(new Font("Tahoma", 1, 15));
/* 2269 */     this.jLabel4.setForeground(Color.red);
/* 2270 */     this.jLabel4.setHorizontalAlignment(0);
/* 2271 */     this.jLabel4.setText("AL");
/*      */     
/* 2273 */     this.jButton1.setMnemonic('F');
/* 2274 */     this.jButton1.setText("Filtrar");
/* 2275 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 2276 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2278 */             ampararFacturas.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2282 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 2283 */     this.jPanel2.setLayout(jPanel2Layout);
/* 2284 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 2285 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2286 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 2287 */           .addContainerGap()
/* 2288 */           .addComponent(this.jLabel1, -2, 130, -2)
/* 2289 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2290 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 2291 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2292 */           .addComponent(this.jLabel4)
/* 2293 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2294 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 2295 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2296 */           .addComponent(this.jButton1)
/* 2297 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2298 */           .addComponent(this.jLabel5, -2, -1, -2)
/* 2299 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2300 */           .addComponent(this.jLabel6, -2, 31, -2)
/* 2301 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2302 */           .addComponent(this.jLabel7, -2, 31, -2)
/* 2303 */           .addContainerGap(21, 32767)));
/*      */     
/* 2305 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 2306 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2307 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 2308 */           .addContainerGap()
/* 2309 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2310 */             .addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2311 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 2312 */               .addGap(1, 1, 1)
/* 2313 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2314 */                 .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.TRAILING, -2, -1, -2)
/* 2315 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2316 */                   .addComponent(this.jLabel5, -2, 19, -2)
/* 2317 */                   .addComponent(this.jLabel6, -2, 15, -2)
/* 2318 */                   .addComponent(this.jLabel7, -2, -1, -2)
/* 2319 */                   .addComponent(this.jButton1))
/* 2320 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 2321 */                   .addComponent(this.jLabel4, -2, 19, -2)
/* 2322 */                   .addGap(1, 1, 1))
/* 2323 */                 .addComponent((Component)this.jDateChooser5, GroupLayout.Alignment.TRAILING, -2, -1, -2))))));
/*      */ 
/*      */     
/* 2326 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 2327 */     this.jPanel1.setLayout(jPanel1Layout);
/* 2328 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 2329 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2330 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 2331 */           .addContainerGap()
/* 2332 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2333 */             .addComponent(this.jPanel17, -1, -1, 32767)
/* 2334 */             .addComponent(this.jPanel5, -1, -1, 32767)
/* 2335 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 2336 */               .addComponent(this.jPanel2, -2, -1, -2)
/* 2337 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2338 */               .addComponent(this.jLabel54, -1, 641, 32767)))
/* 2339 */           .addContainerGap()));
/*      */     
/* 2341 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 2342 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2343 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 2344 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2345 */             .addComponent(this.jLabel54, -1, -1, 32767)
/* 2346 */             .addComponent(this.jPanel2, -1, -1, 32767))
/* 2347 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2348 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 2349 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2350 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 2351 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2354 */     GroupLayout layout = new GroupLayout(this);
/* 2355 */     setLayout(layout);
/* 2356 */     layout.setHorizontalGroup(layout
/* 2357 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2358 */         .addGap(0, 1327, 32767)
/* 2359 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2360 */           .addGroup(layout.createSequentialGroup()
/* 2361 */             .addContainerGap()
/* 2362 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 2363 */             .addContainerGap())));
/*      */     
/* 2365 */     layout.setVerticalGroup(layout
/* 2366 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2367 */         .addGap(0, 402, 32767)
/* 2368 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2369 */           .addGroup(layout.createSequentialGroup()
/* 2370 */             .addContainerGap()
/* 2371 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 2372 */             .addContainerGap())));
/*      */   }
/*      */   private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel6; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JScrollPane jScrollPane1; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane7; private JSeparator jSeparator1; private JSeparator jSeparator11; private JSeparator jSeparator14; private JToolBar.Separator jSeparator15; private JToolBar.Separator jSeparator16; private JToolBar.Separator jSeparator17; private JToolBar.Separator jSeparator2; private JSeparator jSeparator28; private JSeparator jSeparator29; private JToolBar.Separator jSeparator3; private JToolBar.Separator jSeparator4; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator7; private JSeparator jSeparator8; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTable jTable4; private JTextArea jTextArea3; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private JToolBar jToolBar1; private JToolBar jToolBar3;
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 2377 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 2381 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseClicked(MouseEvent evt) {
/* 2385 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 2386 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2387 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseEntered(MouseEvent evt) {
/* 2391 */     this.jLabel5.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel5MouseExited(MouseEvent evt) {
/* 2395 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseClicked(MouseEvent evt) {
/* 2399 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2400 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2401 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel6MouseEntered(MouseEvent evt) {
/* 2405 */     this.jLabel6.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseExited(MouseEvent evt) {
/* 2409 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 2413 */     Calendar ca = Calendar.getInstance();
/* 2414 */     Calendar fecha = Calendar.getInstance();
/* 2415 */     int aa = fecha.get(1);
/* 2416 */     int mm = fecha.get(2);
/* 2417 */     int dd = fecha.get(5);
/* 2418 */     if (dd == 1) {
/* 2419 */       if (mm == 0) {
/* 2420 */         mm = 11;
/* 2421 */         aa--;
/*      */       } else {
/* 2423 */         mm--;
/*      */       } 
/* 2425 */       int diasTotal = diasDelMes(mm, aa);
/* 2426 */       dd = diasTotal;
/*      */     } else {
/* 2428 */       dd--;
/*      */     } 
/* 2430 */     mm++;
/* 2431 */     String año = "" + aa;
/* 2432 */     String mes = "" + mm;
/* 2433 */     String dia = "" + dd;
/* 2434 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 2435 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 2437 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 2438 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 2439 */     } catch (ParseException ex) {
/* 2440 */       ex.printStackTrace();
/*      */     } 
/* 2442 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 2446 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/* 2450 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 2454 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 2458 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 2462 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 2466 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/* 2470 */     buscarGuias();
/*      */   }
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 2474 */     if (this.jComboBox5.getItemCount() > 0) {
/* 2475 */       String[] datos = this.con.regresaReg("fecha,importeRestanteLetra,importeLetra,importe", "tarjeta_contenido_cliente", "where factura = '" + String.valueOf(this.jComboBox5.getSelectedItem()) + "'", 4);
/* 2476 */       this.MONTO = datos[1];
/* 2477 */       if (this.jDialog8.isVisible()) {
/* 2478 */         this.jTextField2.setText(String.valueOf(this.jComboBox5.getSelectedItem()));
/*      */       } else {
/* 2480 */         this.jTextField2.setText(String.valueOf(this.jComboBox5.getSelectedItem()));
/*      */       } 
/*      */       
/* 2483 */       this.jTextField4.setText(datos[2]);
/* 2484 */       this.jTextField9.setText(datos[1]);
/*      */       
/* 2486 */       this.jTextField11.setText(datos[0]);
/* 2487 */       this.jTextField12.setText(datos[2]);
/* 2488 */       this.jTextField13.setText(datos[1]);
/*      */       
/* 2490 */       String canti = this.MONTO;
/* 2491 */       String valorP = "";
/* 2492 */       for (int i = 0; i < canti.length(); i++) {
/* 2493 */         if (canti.charAt(i) != '$' && canti.charAt(i) != ',' && canti.charAt(i) != '-') {
/* 2494 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 2497 */       this.CANTIDAD = Double.parseDouble(valorP);
/* 2498 */       this.encontrado = true;
/*      */     } else {
/* 2500 */       this.jTextField11.setText("");
/* 2501 */       this.jTextField12.setText("");
/* 2502 */       this.jTextField13.setText("");
/* 2503 */       this.encontrado = false;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 2508 */     buscarGuias();
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 2512 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 2516 */     if (this.encontrado) {
/* 2517 */       String compa = String.valueOf(this.jComboBox5.getSelectedItem());
/* 2518 */       for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2519 */         String fect = String.valueOf(this.jTable1.getValueAt(i, 0));
/* 2520 */         if (fect.equals(compa)) {
/* 2521 */           JOptionPane.showMessageDialog(this.jDialog2, "La factura que deseas agregar ya se encuentra almacenada", "Factura Almacenada", 0, this.ERROR);
/*      */           return;
/*      */         } 
/*      */       } 
/* 2525 */       this.jTextField3.setText("");
/* 2526 */       this.jFormattedTextField2.setValue(Double.valueOf(this.CANTIDAD));
/* 2527 */       this.jDialog2.setVisible(true);
/*      */     } else {
/* 2529 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar la factura para registrar los datos", "Coloca la factura", 0, this.ADVER);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 2534 */     String valor1 = this.jFormattedTextField2.getText();
/* 2535 */     String valor2 = this.jTextField4.getText();
/*      */     
/* 2537 */     String canti = valor1;
/* 2538 */     String valorP = "";
/* 2539 */     for (int i = 0; i < canti.length(); i++) {
/* 2540 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',' && canti.charAt(i) != '-') {
/* 2541 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 2544 */     double CANT = Double.parseDouble(valorP);
/*      */     
/* 2546 */     if (CANT > this.CANTIDAD) {
/* 2547 */       this.jTextField3.setText("");
/* 2548 */       this.jFormattedTextField2.setBackground(Color.RED);
/* 2549 */       JOptionPane.showMessageDialog(this.jDialog2, "La cantidad que tecleaste es mayor al monto de la factura\nPor favor verifica tus saldos.", "Las cantidades no coinciden", 0, this.ERROR);
/*      */     } else {
/* 2551 */       if (CANT == this.CANTIDAD) {
/* 2552 */         this.jTextField3.setText("<PAGADA>");
/* 2553 */       } else if (CANT < this.CANTIDAD) {
/* 2554 */         this.jTextField3.setText("<ABONO>");
/*      */       } 
/* 2556 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro agregar la factura al documento?", "Agregar Factura", 0, 3, this.PREG);
/* 2557 */       if (res == 0) {
/* 2558 */         pasarFact();
/* 2559 */         contar();
/* 2560 */         this.jDialog2.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 2566 */     int ind = this.jTable1.getSelectedRow();
/* 2567 */     if (ind < 0) {
/* 2568 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder quitarlo", "Selecciona una factura", 0, this.ADVER);
/*      */     } else {
/* 2570 */       DefaultTableModel temp = (DefaultTableModel)this.jTable1.getModel();
/* 2571 */       temp.removeRow(ind);
/* 2572 */       contar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 2577 */     if (!this.jFormattedTextField1.isEnabled()) {
/* 2578 */       String[] datos = this.con.regresaReg("ap_pat,ap_mat,nombre", "empleados,usuarios", "where num_emp = clave_emp and nombre_usu ='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7)) + "'", 3);
/* 2579 */       this.RECIBE = datos[0] + " " + datos[0] + " " + datos[1];
/* 2580 */       ImprimirDocumento impAbono = new ImprimirDocumento();
/* 2581 */       impAbono.recibeDatos();
/*      */     } else {
/* 2583 */       String monto = this.jFormattedTextField1.getText();
/* 2584 */       if (this.jComboBox7.getSelectedIndex() == 0) {
/* 2585 */         this.jComboBox7.setBackground(Color.RED);
/* 2586 */         JOptionPane.showMessageDialog(this.jDialog1, "El campo esperaba algún tipo de información", "El campo está vacío", 0, this.ADVER);
/* 2587 */       } else if (this.jDateChooser7.getDate() == null) {
/* 2588 */         JOptionPane.showMessageDialog(this.jDialog1, "El campo esperaba algún tipo de dato en la fecha\nVerifica tu información", "El campo está vacío", 0, this.ADVER);
/* 2589 */       } else if (!monto.equals(this.jLabel18.getText())) {
/* 2590 */         this.jFormattedTextField1.setBackground(Color.RED);
/* 2591 */         JOptionPane.showMessageDialog(this.jDialog1, "Las cantidades no coinciden verifica tus saldos", "Cantidades son diferentes", 0, this.ERROR);
/* 2592 */       } else if (this.jButton4.getText().equals("Modificar")) {
/* 2593 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas modificar el depósito para este cliente?", "Modificar Documento", 0, 3, this.PREG);
/* 2594 */         if (res == 0) {
/* 2595 */           SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2596 */           String cadenaFecha1 = formato.format(this.jDateChooser7.getDate());
/* 2597 */           String año = cadenaFecha1.substring(0, 4);
/* 2598 */           String mes = cadenaFecha1.substring(4, 6);
/* 2599 */           String dia = cadenaFecha1.substring(6, 8);
/* 2600 */           String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */           
/* 2602 */           this.con.eliminar2("facturas_abonadas", "where folio_ent='" + this.jTextField5.getText() + "'");
/* 2603 */           this.con.inserSinMsj("update entregar_facturas set cliente='" + String.valueOf(this.jComboBox4.getSelectedItem()) + "', usuario_entrega='" + this.USUARIO + "', banco = '" + String.valueOf(this.jComboBox8.getSelectedItem()) + "', cuenta ='" + String.valueOf(this.jComboBox7.getSelectedItem()) + "', ref='" + this.jTextField8.getText().toUpperCase() + "', fechaActual = now(),fecha=" + fechaCompleta + ",montoParcial='" + this.jLabel40.getText() + "', monto ='" + this.jFormattedTextField1.getText() + "',abonadas=" + this.jLabel13.getText() + ", facturadas=" + this.jLabel16.getText() + " where folio_ent='" + this.jTextField5.getText() + "'");
/* 2604 */           String values = "";
/* 2605 */           for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2606 */             values = values + "('" + values + "','" + String.valueOf(this.jTable1.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 3)) + "')";
/* 2607 */             if (i + 1 < this.jTable1.getRowCount()) {
/* 2608 */               values = values + ",";
/*      */             }
/*      */           } 
/* 2611 */           this.con.inserSinMsj("insert into facturas_abonadas(factura,montoOriginal,montoabonado,tipo,folio_ent)values " + values);
/*      */           
/* 2613 */           this.mensajeTry.guardarConf("Se ha modificado un reporte de depositos, usuario: " + this.USUARIO, "Modificacion de Reporte de Deposito (" + this.jTextField5.getText() + ")", "INFO", "Facturacion");
/* 2614 */           ImprimirDocumento impAbono = new ImprimirDocumento();
/* 2615 */           impAbono.recibeDatos();
/* 2616 */           consultar();
/* 2617 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } else {
/*      */         
/* 2621 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro imprimir el documento amparando las facturas?", "Imprimir Documento", 0, 3, this.PREG);
/* 2622 */         if (res == 0) {
/* 2623 */           sacarMayor();
/* 2624 */           SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2625 */           String cadenaFecha1 = formato.format(this.jDateChooser7.getDate());
/* 2626 */           String año = cadenaFecha1.substring(0, 4);
/* 2627 */           String mes = cadenaFecha1.substring(4, 6);
/* 2628 */           String dia = cadenaFecha1.substring(6, 8);
/* 2629 */           String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */           
/* 2631 */           this.con.inserSinMsj("insert into entregar_facturas(folio_ent,usuario_entrega,usuario_recibe,banco,cuenta,ref,fechaActual,fecha,monto,cliente,abonadas,facturadas,estatus,montoParcial,tipo) values('" + this.jTextField5.getText() + "','" + this.USUARIO + "','" + this.DATOS[1] + "','" + String.valueOf(this.jComboBox8.getSelectedItem()) + "','" + String.valueOf(this.jComboBox7.getSelectedItem()) + "','" + this.jTextField8.getText().toUpperCase() + "',now()," + fechaCompleta + ",'" + this.jLabel18.getText() + "','" + String.valueOf(this.jComboBox4.getSelectedItem()) + "'," + this.jLabel13.getText() + "," + this.jLabel16.getText() + ",'<Por Recibir>','" + this.jLabel40.getText() + "','DB')");
/* 2632 */           String values = "";
/* 2633 */           for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 2634 */             values = values + "('" + values + "','" + String.valueOf(this.jTable1.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 3)) + "')";
/* 2635 */             if (i + 1 < this.jTable1.getRowCount()) {
/* 2636 */               values = values + ",";
/*      */             }
/*      */           } 
/* 2639 */           this.con.inserSinMsj("insert into facturas_abonadas(factura,montoOriginal,montoabonado,tipo,folio_ent)values " + values);
/* 2640 */           this.mensajeTry.guardarConf("Se ha creado un nuevo reporte de depositos, usuario: " + this.USUARIO, "Reporte de Deposito (" + this.jTextField5.getText() + ")", "INFO", "Facturación");
/*      */           
/* 2642 */           ImprimirDocumento impAbono = new ImprimirDocumento();
/* 2643 */           impAbono.recibeDatos();
/* 2644 */           consultar();
/* 2645 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 2652 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 2656 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 2660 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 2664 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 2668 */     int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas recibir el documento?", "Recibir documento", 0, 3, this.PREG);
/* 2669 */     if (res == 0) {
/* 2670 */       this.con.inserSinMsj("update entregar_facturas set estatus = '<Recibido " + cargarFechaHoy() + ": " + this.jTextArea3.getText().toUpperCase() + ">' where num = '" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)) + "'");
/* 2671 */       consultar();
/* 2672 */       this.jDialog4.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 2677 */     this.jComboBox8.setSelectedIndex(this.jComboBox7.getSelectedIndex());
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2685 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 2689 */     if (this.jDialog1.isVisible()) {
/* 2690 */       String valor1 = this.jFormattedTextField3.getText();
/*      */       
/* 2692 */       String canti = valor1;
/* 2693 */       String valorP = "";
/* 2694 */       for (int i = 0; i < canti.length(); i++) {
/* 2695 */         if (canti.charAt(i) != '$' && canti.charAt(i) != ',' && canti.charAt(i) != '-') {
/* 2696 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 2699 */       String suc = String.valueOf(this.jComboBox9.getSelectedItem());
/* 2700 */       if (suc.equals("")) {
/* 2701 */         JOptionPane.showMessageDialog(this.jDialog5, "El campo 'SUCURSAL' esperaba algún tipo de información", "El campo está vacío", 0, this.ADVER);
/* 2702 */       } else if (valor1.equals("$0.00")) {
/* 2703 */         this.jFormattedTextField3.setBackground(Color.RED);
/* 2704 */         JOptionPane.showMessageDialog(this.jDialog5, "El campo 'IMPORTE' esperaba algún tipo de información", "El campo está vacío", 0, this.ADVER);
/*      */       } else {
/* 2706 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro agregar la factura al documento?", "Agregar Factura", 0, 3, this.PREG);
/* 2707 */         if (res == 0) {
/* 2708 */           pasarFact2();
/* 2709 */           contar();
/* 2710 */           this.jDialog5.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } else {
/* 2714 */       String valor1 = this.jFormattedTextField3.getText();
/*      */       
/* 2716 */       String canti = valor1;
/* 2717 */       String valorP = "";
/* 2718 */       for (int i = 0; i < canti.length(); i++) {
/* 2719 */         if (canti.charAt(i) != '$' && canti.charAt(i) != ',' && canti.charAt(i) != '-') {
/* 2720 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 2723 */       String suc = String.valueOf(this.jComboBox9.getSelectedItem());
/* 2724 */       if (suc.equals("")) {
/* 2725 */         JOptionPane.showMessageDialog(this.jDialog5, "El campo 'SUCURSAL' esperaba algún tipo de información", "El campo está vacío", 0, this.ADVER);
/* 2726 */       } else if (valor1.equals("$0.00")) {
/* 2727 */         this.jFormattedTextField3.setBackground(Color.RED);
/* 2728 */         JOptionPane.showMessageDialog(this.jDialog5, "El campo 'IMPORTE' esperaba algún tipo de información", "El campo está vacío", 0, this.ADVER);
/*      */       } else {
/* 2730 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro agregar la factura al documento?", "Agregar Factura", 0, 3, this.PREG);
/* 2731 */         if (res == 0) {
/* 2732 */           pasarFact2();
/* 2733 */           contar();
/* 2734 */           this.jDialog5.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 2741 */     this.jComboBox9.setSelectedIndex(0);
/* 2742 */     this.jTextField10.setText("");
/* 2743 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 2744 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {
/* 2748 */     if (this.jRadioButton1.isSelected()) {
/* 2749 */       this.jDialog6.setVisible(false);
/* 2750 */       this.jDateChooser6.setEnabled(true);
/* 2751 */       this.jButton7.setEnabled(true);
/* 2752 */       this.jComboBox4.setEnabled(true);
/* 2753 */       this.jComboBox5.setEnabled(true);
/* 2754 */       this.jComboBox7.setEnabled(true);
/* 2755 */       this.jButton2.setEnabled(true);
/* 2756 */       this.jDateChooser7.setEnabled(true);
/* 2757 */       this.jFormattedTextField1.setEnabled(true);
/* 2758 */       this.jButton5.setEnabled(true);
/* 2759 */       this.jComboBox7.setSelectedIndex(0);
/* 2760 */       this.jButton6.setEnabled(true);
/*      */       
/* 2762 */       this.jTextField6.setEnabled(true);
/* 2763 */       this.jTextField7.setEnabled(true);
/* 2764 */       this.jTextField8.setEnabled(true);
/*      */       
/* 2766 */       this.jTextField6.setText("");
/* 2767 */       this.jTextField7.setText("");
/* 2768 */       this.jTextField8.setText("");
/*      */       
/* 2770 */       this.jButton4.setText("Imprimir");
/* 2771 */       this.jButton4.setToolTipText("Imprimir (Alt+I)");
/* 2772 */       this.jButton4.setMnemonic('I');
/*      */       
/* 2774 */       sacarMayor();
/* 2775 */       this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 2776 */       this.jDateChooser7.setDate(new Date());
/* 2777 */       this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Factura", "Monto Original", "Monto a Saldar", "Tipo" })
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2783 */             boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2788 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 2791 */       this.jScrollPane1.setViewportView(this.jTable1);
/* 2792 */       this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 2793 */       this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 2794 */       this.jLabel13.setText("0");
/* 2795 */       this.jLabel16.setText("0");
/* 2796 */       this.jLabel18.setText("0");
/* 2797 */       this.jLabel40.setText("0");
/* 2798 */       this.jDialog1.setVisible(true);
/*      */     } else {
/* 2800 */       this.jDialog6.setVisible(false);
/*      */       
/* 2802 */       this.jFormattedTextField1.setEnabled(true);
/* 2803 */       this.jTextField20.setEnabled(true);
/* 2804 */       this.jTextField7.setEnabled(true);
/* 2805 */       this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 2806 */       this.jDateChooser13.setEnabled(true);
/* 2807 */       this.jDateChooser13.setDate(new Date());
/*      */       
/* 2809 */       this.jDateChooser7.setEnabled(true);
/* 2810 */       this.jButton34.setEnabled(true);
/* 2811 */       this.jComboBox14.setSelectedIndex(0);
/* 2812 */       this.jComboBox14.setEnabled(true);
/*      */       
/* 2814 */       this.jComboBox17.setEnabled(true);
/* 2815 */       this.jButton36.setEnabled(true);
/*      */       
/* 2817 */       this.jTextField20.setText("");
/*      */       
/* 2819 */       this.jButton32.setText("Imprimir");
/* 2820 */       this.jButton32.setToolTipText("Imprimir (Alt+I)");
/* 2821 */       this.jButton32.setMnemonic('I');
/*      */       
/* 2823 */       sacarMayor();
/* 2824 */       this.jDateChooser13.setDate(new Date());
/* 2825 */       this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Factura", "Monto Original", "Monto a Saldar", "Tipo" })
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2831 */             boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2836 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 2839 */       this.jScrollPane4.setViewportView(this.jTable4);
/* 2840 */       this.jTable4.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 2841 */       this.jTable4.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 2842 */       this.jLabel89.setText("0");
/* 2843 */       this.jLabel91.setText("0");
/* 2844 */       this.jLabel94.setText("$0.0");
/* 2845 */       this.jLabel96.setText("$0.0");
/*      */       
/* 2847 */       this.jDialog8.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton31ActionPerformed(ActionEvent evt) {
/* 2852 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 2856 */     int ind = this.jTable3.getSelectedRow();
/* 2857 */     if (ind < 0) {
/* 2858 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un documento para poder modificar la información", "Selecciona un documento", 0, this.ADVER);
/*      */     } else {
/* 2860 */       String texto = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13));
/* 2861 */       if (!texto.equals("<Por Recibir>")) {
/* 2862 */         JOptionPane.showMessageDialog(this.padre, "No puedes modificar este reporte ya que se encuentra firmado", "Documento Recibido", 0, this.ERROR);
/*      */       } else {
/* 2864 */         String tipo = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/* 2865 */         if (tipo.equals("DB")) {
/* 2866 */           verFacturas();
/*      */           
/* 2868 */           this.jButton4.setText("Modificar");
/* 2869 */           this.jButton4.setToolTipText("Modificar (Alt+M)");
/* 2870 */           this.jButton4.setMnemonic('M');
/*      */           
/* 2872 */           this.jDateChooser6.setEnabled(true);
/* 2873 */           this.jButton7.setEnabled(true);
/* 2874 */           this.jComboBox4.setEnabled(true);
/* 2875 */           this.jComboBox5.setEnabled(true);
/* 2876 */           this.jComboBox7.setEnabled(true);
/* 2877 */           this.jButton2.setEnabled(true);
/* 2878 */           this.jDateChooser7.setEnabled(true);
/* 2879 */           this.jFormattedTextField1.setEnabled(true);
/* 2880 */           this.jButton5.setEnabled(true);
/* 2881 */           this.jButton6.setEnabled(true);
/*      */           
/* 2883 */           this.jTextField6.setEnabled(true);
/* 2884 */           this.jTextField7.setEnabled(true);
/* 2885 */           this.jTextField8.setEnabled(true);
/* 2886 */           buscarGuias();
/*      */           
/* 2888 */           this.jDialog1.setVisible(true);
/*      */         } else {
/* 2890 */           verFacturas2();
/*      */           
/* 2892 */           this.jButton32.setText("Modificar");
/* 2893 */           this.jButton32.setToolTipText("Modificar (Alt+M)");
/* 2894 */           this.jButton32.setMnemonic('M');
/*      */           
/* 2896 */           this.jDateChooser12.setEnabled(true);
/* 2897 */           this.jButton34.setEnabled(true);
/* 2898 */           this.jComboBox17.setEnabled(true);
/* 2899 */           this.jComboBox14.setEnabled(true);
/* 2900 */           this.jButton36.setEnabled(true);
/* 2901 */           this.jDateChooser13.setEnabled(true);
/* 2902 */           this.jFormattedTextField5.setEnabled(true);
/* 2903 */           this.jButton33.setEnabled(true);
/* 2904 */           this.jButton35.setEnabled(true);
/*      */           
/* 2906 */           this.jTextField20.setEnabled(true);
/* 2907 */           if (this.jComboBox14.getItemCount() > 0) {
/* 2908 */             this.jComboBox17.removeAllItems();
/*      */             
/* 2910 */             Date fecha = this.jDateChooser12.getDate();
/* 2911 */             SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2912 */             String cadenaFecha = "";
/* 2913 */             cadenaFecha = formato.format(fecha);
/* 2914 */             String AÑO = cadenaFecha.substring(0, 4);
/* 2915 */             String MES = cadenaFecha.substring(4, 6);
/* 2916 */             String DIA = cadenaFecha.substring(6, 8);
/* 2917 */             String fechaCompleta = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */             
/* 2919 */             String[] DATOS = this.con.regresaColIndex("folio", "facturas", "where tarjeta=" + this.CLAVES[this.jComboBox14.getSelectedIndex()] + " and fecha>=" + fechaCompleta + " and (estatus like '%<Por Pagar%' || estatus like '%<Abono%') order by folio asc");
/* 2920 */             for (int i = 0; i < DATOS.length; i++) {
/* 2921 */               this.jComboBox17.addItem(DATOS[i]);
/*      */             }
/*      */           } 
/*      */           
/* 2925 */           if (this.jComboBox17.getItemCount() > 0) {
/* 2926 */             String[] datos = this.con.regresaReg("fecha,importeRestanteLetra,importeLetra", "tarjeta_contenido_cliente", "where factura = '" + String.valueOf(this.jComboBox17.getSelectedItem()) + "'", 3);
/* 2927 */             this.jTextField21.setText(datos[0]);
/* 2928 */             this.jTextField22.setText(datos[2]);
/*      */           } else {
/* 2930 */             this.jTextField21.setText("");
/* 2931 */             this.jTextField22.setText("");
/* 2932 */             this.jTextField13.setText("");
/*      */           } 
/*      */           
/* 2935 */           this.jDialog8.setVisible(true);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 2942 */     int ind = this.jTable3.getSelectedRow();
/* 2943 */     if (ind < 0) {
/* 2944 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un documento para poder recibir los datos", "Selecciona un documento", 0, this.ADVER);
/*      */     } else {
/* 2946 */       String valor = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 8));
/* 2947 */       if (!this.USUARIO.equals(valor)) {
/* 2948 */         JOptionPane.showMessageDialog(this.padre, "No eres la persona que recibirá este documento", "No se puede recibir", 0, this.ADVER);
/*      */       } else {
/* 2950 */         this.jDialog4.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 2956 */     int ind = this.jTable3.getSelectedRow();
/* 2957 */     String valor = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 13));
/* 2958 */     if (ind < 0) {
/* 2959 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un documento para poder cancelar los datos", "Selecciona un documento", 0, this.ADVER);
/* 2960 */     } else if (!valor.equals("<Por Recibir>")) {
/* 2961 */       JOptionPane.showMessageDialog(this.padre, "Para cancelar un documento, debe estar en estatus ='<Por Recibir>'", "No se puede cancelar", 0, this.ADVER);
/*      */     } else {
/* 2963 */       this.jTextArea5.setText("");
/* 2964 */       this.jDialog3.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 2969 */     this.jRadioButton1.setSelected(true);
/* 2970 */     this.jDialog6.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 2974 */     String[] datos = { "NÚM", "TIPO", "FOLIO", "FECHA DE CREACIÓN", "CLIENTE", "BANCO", "CUENTA", "ENTREGA", "RECIBE", "F. DEPÓSITO", "ABONADAS", "SALDADAS", "CANTIDAD", "ESTATUS" };
/* 2975 */     this.esc = new EscribirReporte("DEPÓSITOS", this.jTable3, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 2979 */     int ind = this.jTable3.getSelectedRow();
/* 2980 */     if (ind < 0) {
/* 2981 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un documento para poder ver los datos", "Selecciona un documento", 0, this.ADVER);
/*      */     } else {
/* 2983 */       verFacturas();
/* 2984 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTable3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 2993 */     if (evt.getClickCount() == 2) {
/* 2994 */       String valor = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/* 2995 */       if (valor.equals("DB")) {
/* 2996 */         verFacturas();
/* 2997 */         this.jDialog1.setVisible(true);
/*      */       } else {
/* 2999 */         verFacturas2();
/* 3000 */         this.jDialog8.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField5ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField13ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 3014 */     this.jDialog8.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton32ActionPerformed(ActionEvent evt) {
/* 3018 */     if (!this.jFormattedTextField5.isEnabled()) {
/* 3019 */       String[] datos = this.con.regresaReg("ap_pat,ap_mat,nombre", "empleados,usuarios", "where num_emp = clave_emp and nombre_usu ='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7)) + "'", 3);
/* 3020 */       this.RECIBE = datos[0] + " " + datos[0] + " " + datos[1];
/*      */       
/* 3022 */       ImprimirNotadeCredito impAbono = new ImprimirNotadeCredito();
/* 3023 */       impAbono.recibeDatos();
/*      */     } else {
/* 3025 */       String monto = this.jFormattedTextField5.getText();
/* 3026 */       if (this.jTextField20.getText().equals("")) {
/* 3027 */         this.jTextField20.setBackground(Color.RED);
/* 3028 */         JOptionPane.showMessageDialog(this.jDialog1, "El campo esperaba algún tipo de informacion", "El campo está vacío", 0, this.ADVER);
/* 3029 */       } else if (this.jDateChooser13.getDate() == null) {
/* 3030 */         JOptionPane.showMessageDialog(this.jDialog8, "El campo esperaba algún tipo de dato en la fecha\nVerifica tu información", "El campo está vacío", 0, this.ADVER);
/* 3031 */       } else if (!monto.equals(this.jLabel96.getText())) {
/* 3032 */         this.jFormattedTextField5.setBackground(Color.RED);
/* 3033 */         JOptionPane.showMessageDialog(this.jDialog8, "Las cantidades no coinciden verifica tus saldos", "Cantidades son diferentes", 0, this.ERROR);
/* 3034 */       } else if (this.jButton32.getText().equals("Modificar")) {
/* 3035 */         int res = JOptionPane.showConfirmDialog(this.jDialog8, "¿Estás seguro que deseas modificar el depósito para este cliente?", "Modificar Documento", 0, 3, this.PREG);
/* 3036 */         if (res == 0) {
/* 3037 */           SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3038 */           String cadenaFecha1 = formato.format(this.jDateChooser13.getDate());
/* 3039 */           String año = cadenaFecha1.substring(0, 4);
/* 3040 */           String mes = cadenaFecha1.substring(4, 6);
/* 3041 */           String dia = cadenaFecha1.substring(6, 8);
/* 3042 */           String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */           
/* 3044 */           this.con.eliminar2("facturas_abonadas", "where folio_ent='" + this.jTextField19.getText() + "'");
/* 3045 */           this.con.inserSinMsj("update entregar_facturas set usuario_entrega='" + this.USUARIO + "', banco = '" + this.jTextField20.getText().toUpperCase() + "', cuenta ='', ref='', fechaActual = now(),fecha=" + fechaCompleta + ",montoParcial='" + this.jLabel94.getText() + "', monto ='" + this.jFormattedTextField5.getText() + "',abonadas=" + this.jLabel89.getText() + ", facturadas=" + this.jLabel91.getText() + ", cliente='" + String.valueOf(this.jComboBox14.getSelectedItem()) + "' where folio_ent='" + this.jTextField19.getText() + "'");
/* 3046 */           String values = "";
/* 3047 */           for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 3048 */             values = values + "('" + values + "','" + String.valueOf(this.jTable4.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable4.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable4.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable4.getValueAt(i, 3)) + "')";
/* 3049 */             if (i + 1 < this.jTable4.getRowCount()) {
/* 3050 */               values = values + ",";
/*      */             }
/*      */           } 
/* 3053 */           this.con.inserSinMsj("insert into facturas_abonadas(factura,montoOriginal,montoabonado,tipo,folio_ent)values " + values);
/*      */           
/* 3055 */           this.mensajeTry.guardarConf("Se ha modificado un reporte de depositos, usuario: " + this.USUARIO, "Modificacion de Reporte de Deposito (" + this.jTextField19.getText() + ")", "INFO", "Facturacion");
/* 3056 */           ImprimirNotadeCredito impAbono = new ImprimirNotadeCredito();
/* 3057 */           impAbono.recibeDatos();
/* 3058 */           consultar();
/* 3059 */           this.jDialog8.setVisible(false);
/*      */         } 
/*      */       } else {
/* 3062 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro imprimir el documento amparando las facturas?", "Imprimir Documento", 0, 3, this.PREG);
/* 3063 */         if (res == 0) {
/* 3064 */           sacarMayor();
/* 3065 */           SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3066 */           String cadenaFecha1 = formato.format(this.jDateChooser13.getDate());
/* 3067 */           String año = cadenaFecha1.substring(0, 4);
/* 3068 */           String mes = cadenaFecha1.substring(4, 6);
/* 3069 */           String dia = cadenaFecha1.substring(6, 8);
/* 3070 */           String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */           
/* 3072 */           this.con.inserSinMsj("insert into entregar_facturas(folio_ent,usuario_entrega,usuario_recibe,banco,cuenta,ref,fechaActual,fecha,monto,cliente,abonadas,facturadas,estatus,montoParcial,tipo) values('" + this.jTextField19.getText() + "','" + this.USUARIO + "','" + this.DATOS[1] + "','" + this.jTextField20.getText().toUpperCase() + "','','',now()," + fechaCompleta + ",'" + this.jLabel96.getText() + "','" + String.valueOf(this.jComboBox14.getSelectedItem()) + "'," + this.jLabel89.getText() + "," + this.jLabel91.getText() + ",'<Por Recibir>','" + this.jLabel94.getText() + "','NC')");
/* 3073 */           String values = "";
/* 3074 */           for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 3075 */             values = values + "('" + values + "','" + String.valueOf(this.jTable4.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable4.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable4.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable4.getValueAt(i, 3)) + "')";
/* 3076 */             if (i + 1 < this.jTable4.getRowCount()) {
/* 3077 */               values = values + ",";
/*      */             }
/*      */           } 
/* 3080 */           this.con.inserSinMsj("insert into facturas_abonadas(factura,montoOriginal,montoabonado,tipo,folio_ent)values " + values);
/* 3081 */           this.mensajeTry.guardarConf("Se ha creado un nuevo reporte de depositos, usuario: " + this.USUARIO, "Reporte de Deposito (" + this.jTextField19.getText() + ")", "INFO", "Facturación");
/*      */           
/* 3083 */           ImprimirNotadeCredito impAbono = new ImprimirNotadeCredito();
/* 3084 */           impAbono.recibeDatos();
/* 3085 */           consultar();
/* 3086 */           this.jDialog8.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {
/* 3093 */     int ind = this.jTable4.getSelectedRow();
/* 3094 */     if (ind < 0) {
/* 3095 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder quitarlo", "Selecciona una factura", 0, this.ADVER);
/*      */     } else {
/* 3097 */       DefaultTableModel temp = (DefaultTableModel)this.jTable4.getModel();
/* 3098 */       temp.removeRow(ind);
/* 3099 */       contar();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField19ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 3108 */     if (this.jComboBox14.getItemCount() > 0) {
/* 3109 */       this.jComboBox17.removeAllItems();
/*      */       
/* 3111 */       Date fecha = this.jDateChooser12.getDate();
/* 3112 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3113 */       String cadenaFecha = "";
/* 3114 */       cadenaFecha = formato.format(fecha);
/* 3115 */       String AÑO = cadenaFecha.substring(0, 4);
/* 3116 */       String MES = cadenaFecha.substring(4, 6);
/* 3117 */       String DIA = cadenaFecha.substring(6, 8);
/* 3118 */       String fechaCompleta = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 3120 */       String[] DATOS = this.con.regresaColIndex("folio", "facturas", "where tarjeta=" + this.CLAVES[this.jComboBox14.getSelectedIndex()] + " and fecha>=" + fechaCompleta + " and (estatus like '%<Por Pagar%' || estatus like '%<Abono%') order by folio asc");
/* 3121 */       for (int i = 0; i < DATOS.length; i++) {
/* 3122 */         this.jComboBox17.addItem(DATOS[i]);
/*      */       }
/*      */     } 
/*      */     
/* 3126 */     if (this.jComboBox17.getItemCount() > 0) {
/* 3127 */       String[] datos = this.con.regresaReg("fecha,importeRestanteLetra,importeLetra", "tarjeta_contenido_cliente", "where factura = '" + String.valueOf(this.jComboBox17.getSelectedItem()) + "'", 3);
/* 3128 */       this.jTextField21.setText(datos[0]);
/* 3129 */       this.jTextField22.setText(datos[2]);
/*      */     } else {
/* 3131 */       this.jTextField21.setText("");
/* 3132 */       this.jTextField22.setText("");
/* 3133 */       this.jTextField13.setText("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox14ActionPerformed(ActionEvent evt) {
/* 3138 */     if (this.jComboBox14.getItemCount() > 0) {
/* 3139 */       this.jComboBox17.removeAllItems();
/*      */       
/* 3141 */       Date fecha = this.jDateChooser12.getDate();
/* 3142 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3143 */       String cadenaFecha = "";
/* 3144 */       cadenaFecha = formato.format(fecha);
/* 3145 */       String AÑO = cadenaFecha.substring(0, 4);
/* 3146 */       String MES = cadenaFecha.substring(4, 6);
/* 3147 */       String DIA = cadenaFecha.substring(6, 8);
/* 3148 */       String fechaCompleta = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 3150 */       String[] DATOS = this.con.regresaColIndex("folio", "facturas", "where tarjeta=" + this.CLAVES[this.jComboBox14.getSelectedIndex()] + " and fecha>=" + fechaCompleta + " and (estatus like '%<Por Pagar%' || estatus like '%<Abono%') order by folio asc");
/* 3151 */       for (int i = 0; i < DATOS.length; i++) {
/* 3152 */         this.jComboBox17.addItem(DATOS[i]);
/*      */       }
/*      */     } 
/*      */     
/* 3156 */     if (this.jComboBox17.getItemCount() > 0) {
/* 3157 */       String[] datos = this.con.regresaReg("fecha,importeRestanteLetra,importeLetra", "tarjeta_contenido_cliente", "where factura = '" + String.valueOf(this.jComboBox17.getSelectedItem()) + "'", 3);
/* 3158 */       this.jTextField21.setText(datos[0]);
/* 3159 */       this.jTextField22.setText(datos[2]);
/*      */     } else {
/* 3161 */       this.jTextField21.setText("");
/* 3162 */       this.jTextField22.setText("");
/* 3163 */       this.jTextField13.setText("");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton35ActionPerformed(ActionEvent evt) {
/* 3168 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jComboBox17ActionPerformed(ActionEvent evt) {
/* 3172 */     if (this.jComboBox17.getItemCount() > 0) {
/* 3173 */       String[] datos = this.con.regresaReg("fecha,importeRestanteLetra,importeLetra,importe", "tarjeta_contenido_cliente", "where factura = '" + String.valueOf(this.jComboBox17.getSelectedItem()) + "'", 4);
/* 3174 */       this.MONTO = datos[1];
/* 3175 */       this.jTextField2.setText(String.valueOf(this.jComboBox17.getSelectedItem()));
/* 3176 */       this.jTextField4.setText(datos[2]);
/* 3177 */       this.jTextField9.setText(datos[1]);
/*      */       
/* 3179 */       this.jTextField21.setText(datos[0]);
/* 3180 */       this.jTextField22.setText(datos[2]);
/* 3181 */       this.jTextField23.setText(datos[1]);
/*      */       
/* 3183 */       String canti = this.MONTO;
/* 3184 */       String valorP = "";
/* 3185 */       for (int i = 0; i < canti.length(); i++) {
/* 3186 */         if (canti.charAt(i) != '$' && canti.charAt(i) != ',' && canti.charAt(i) != '-') {
/* 3187 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3190 */       this.CANTIDAD = Double.parseDouble(valorP);
/* 3191 */       this.encontrado = true;
/*      */     } else {
/* 3193 */       this.jTextField21.setText("");
/* 3194 */       this.jTextField22.setText("");
/* 3195 */       this.jTextField23.setText("");
/* 3196 */       this.encontrado = false;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton36ActionPerformed(ActionEvent evt) {
/* 3201 */     if (this.encontrado) {
/* 3202 */       String compa = String.valueOf(this.jComboBox17.getSelectedItem());
/* 3203 */       for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 3204 */         String fect = String.valueOf(this.jTable4.getValueAt(i, 0));
/* 3205 */         if (fect.equals(compa)) {
/* 3206 */           JOptionPane.showMessageDialog(this.jDialog8, "La factura que deseas agregar ya se encuentra almacenada", "Factura Almacenada", 0, this.ERROR);
/*      */           return;
/*      */         } 
/*      */       } 
/* 3210 */       this.jTextField3.setText("");
/* 3211 */       this.jFormattedTextField2.setValue(Double.valueOf(this.CANTIDAD));
/* 3212 */       this.jDialog2.setVisible(true);
/*      */     } else {
/* 3214 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar la factura para registrar los datos", "Coloca la factura", 0, this.ADVER);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField23ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   public String cargarFechaHoy() {
/* 3223 */     Calendar ahoraCal = Calendar.getInstance();
/* 3224 */     ahoraCal.setTime(this.fecha);
/* 3225 */     String mesesito = "";
/* 3226 */     String hoy = "";
/* 3227 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 3228 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 3230 */     if (ahoraCal.get(2) + 1 < 10) {
/* 3231 */       mesesito = "0" + mesesito;
/*      */     }
/* 3233 */     if (ahoraCal.get(5) < 10) {
/* 3234 */       hoy = "0" + hoy;
/*      */     }
/* 3236 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 3240 */     String motivo = this.jTextArea5.getText();
/* 3241 */     if (motivo.equals("")) {
/* 3242 */       this.jTextArea5.setBackground(Color.RED);
/* 3243 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas colocar el motivo por el cual se cancela el documento", "Coloca un comentario", 0, this.ERROR);
/*      */     } else {
/* 3245 */       int res = JOptionPane.showConfirmDialog(this.jDialog3, "¿Estás seguro que deseas cancelar el documento que seleccionaste?", "Cancelar Documento", 0, 3, this.PREG);
/* 3246 */       if (res == 0) {
/* 3247 */         this.con.inserSinMsj("update entregar_facturas set estatus='<Cancelado " + cargarFechaHoy() + ": " + this.jTextArea5.getText().toUpperCase() + "' where num =" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)));
/* 3248 */         consultar();
/* 3249 */         this.jDialog3.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarUsuarios() {
/* 3256 */     String[] datos = this.con.regresaReg("ap_pat,ap_mat,nombre", "empleados,usuarios", "where num_emp = clave_emp and nombre_usu ='" + this.USUARIO + "'", 3);
/* 3257 */     this.ENTREGA = datos[0] + " " + datos[0] + " " + datos[1];
/*      */     
/* 3259 */     datos = this.con.regresaReg("ap_pat,ap_mat,nombre", "empleados,usuarios", "where num_emp = clave_emp and nombre_usu ='" + this.DATOS[1] + "'", 3);
/* 3260 */     this.RECIBE = datos[0] + " " + datos[0] + " " + datos[1];
/*      */   }
/*      */   
/*      */   public void contar() {
/* 3264 */     if (this.jDialog1.isVisible()) {
/* 3265 */       int abonos = 0;
/* 3266 */       int saldos = 0;
/* 3267 */       double SALDO = 0.0D;
/* 3268 */       double subtotal = 0.0D;
/* 3269 */       for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 3270 */         String monto = String.valueOf(this.jTable1.getValueAt(i, 2));
/* 3271 */         String tipo = String.valueOf(this.jTable1.getValueAt(i, 3));
/* 3272 */         if (tipo.equals("<ABONO>")) {
/* 3273 */           abonos++;
/* 3274 */         } else if (tipo.equals("<PAGADA>")) {
/* 3275 */           saldos++;
/*      */         } 
/*      */         
/* 3278 */         String canti = monto;
/* 3279 */         String valorP = "";
/*      */         
/* 3281 */         for (int j = 0; j < canti.length(); j++) {
/* 3282 */           if (canti.charAt(j) != '$' && canti.charAt(j) != ',' && canti.charAt(j) != '-') {
/* 3283 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 3286 */         if (!tipo.contains("*")) {
/* 3287 */           subtotal += Double.parseDouble(valorP);
/*      */         }
/*      */         
/* 3290 */         SALDO += Double.parseDouble(valorP);
/*      */       } 
/*      */       
/* 3293 */       this.jFormattedTextField2.setValue(Double.valueOf(SALDO));
/* 3294 */       this.jLabel13.setText("   " + abonos);
/* 3295 */       this.jLabel16.setText("   " + saldos);
/* 3296 */       this.jLabel18.setText(this.jFormattedTextField2.getText());
/*      */       
/* 3298 */       this.jFormattedTextField2.setValue(Double.valueOf(subtotal));
/* 3299 */       this.jLabel40.setText(this.jFormattedTextField2.getText());
/*      */     } else {
/* 3301 */       int abonos = 0;
/* 3302 */       int saldos = 0;
/* 3303 */       double SALDO = 0.0D;
/* 3304 */       double subtotal = 0.0D;
/* 3305 */       for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 3306 */         String monto = String.valueOf(this.jTable4.getValueAt(i, 2));
/* 3307 */         String tipo = String.valueOf(this.jTable4.getValueAt(i, 3));
/* 3308 */         if (tipo.equals("<ABONO>")) {
/* 3309 */           abonos++;
/* 3310 */         } else if (tipo.equals("<PAGADA>")) {
/* 3311 */           saldos++;
/*      */         } 
/*      */         
/* 3314 */         String canti = monto;
/* 3315 */         String valorP = "";
/*      */         
/* 3317 */         for (int j = 0; j < canti.length(); j++) {
/* 3318 */           if (canti.charAt(j) != '$' && canti.charAt(j) != ',' && canti.charAt(j) != '-') {
/* 3319 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 3322 */         if (!tipo.contains("*")) {
/* 3323 */           subtotal += Double.parseDouble(valorP);
/*      */         }
/*      */         
/* 3326 */         SALDO += Double.parseDouble(valorP);
/*      */       } 
/*      */       
/* 3329 */       this.jFormattedTextField2.setValue(Double.valueOf(SALDO));
/* 3330 */       this.jLabel89.setText("   " + abonos);
/* 3331 */       this.jLabel91.setText("   " + saldos);
/* 3332 */       this.jLabel96.setText(this.jFormattedTextField2.getText());
/*      */       
/* 3334 */       this.jFormattedTextField2.setValue(Double.valueOf(subtotal));
/* 3335 */       this.jLabel94.setText(this.jFormattedTextField2.getText());
/*      */     } 
/*      */   }
/*      */   
/*      */   public void pasarFact() {
/* 3340 */     if (this.jDialog1.isVisible()) {
/* 3341 */       DefaultTableModel temp = (DefaultTableModel)this.jTable1.getModel();
/* 3342 */       String[] arrayOfString = new String[5];
/* 3343 */       arrayOfString[0] = this.jTextField2.getText();
/* 3344 */       arrayOfString[1] = this.jTextField4.getText();
/* 3345 */       arrayOfString[2] = this.jFormattedTextField2.getText();
/* 3346 */       arrayOfString[3] = this.jTextField3.getText();
/* 3347 */       temp.addRow((Object[])arrayOfString);
/*      */       
/* 3349 */       temp = (DefaultTableModel)this.jTable3.getModel();
/* 3350 */       this.jTable1.setAutoCreateRowSorter(true);
/* 3351 */       this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     } else {
/* 3353 */       DefaultTableModel temp = (DefaultTableModel)this.jTable4.getModel();
/* 3354 */       String[] arrayOfString = new String[5];
/* 3355 */       arrayOfString[0] = this.jTextField2.getText();
/* 3356 */       arrayOfString[1] = this.jTextField4.getText();
/* 3357 */       arrayOfString[2] = this.jFormattedTextField2.getText();
/* 3358 */       arrayOfString[3] = this.jTextField3.getText();
/* 3359 */       temp.addRow((Object[])arrayOfString);
/*      */       
/* 3361 */       temp = (DefaultTableModel)this.jTable4.getModel();
/* 3362 */       this.jTable4.setAutoCreateRowSorter(true);
/* 3363 */       this.jTable4.getTableHeader().setReorderingAllowed(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void pasarFact2() {
/* 3368 */     if (this.jDialog1.isVisible()) {
/* 3369 */       String suc = "*" + String.valueOf(this.jComboBox9.getSelectedItem());
/* 3370 */       DefaultTableModel temp = (DefaultTableModel)this.jTable1.getModel();
/* 3371 */       String[] arrayOfString = new String[5];
/* 3372 */       arrayOfString[0] = this.jTextField10.getText().toUpperCase();
/* 3373 */       arrayOfString[1] = "";
/* 3374 */       arrayOfString[2] = this.jFormattedTextField3.getText();
/* 3375 */       arrayOfString[3] = suc.toUpperCase();
/* 3376 */       temp.addRow((Object[])arrayOfString);
/* 3377 */       this.jTable1.setAutoCreateRowSorter(true);
/* 3378 */       this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     } else {
/* 3380 */       String suc = "*" + String.valueOf(this.jComboBox9.getSelectedItem());
/* 3381 */       DefaultTableModel temp = (DefaultTableModel)this.jTable4.getModel();
/* 3382 */       String[] arrayOfString = new String[5];
/* 3383 */       arrayOfString[0] = this.jTextField10.getText().toUpperCase();
/* 3384 */       arrayOfString[1] = "";
/* 3385 */       arrayOfString[2] = this.jFormattedTextField3.getText();
/* 3386 */       arrayOfString[3] = suc.toUpperCase();
/* 3387 */       temp.addRow((Object[])arrayOfString);
/* 3388 */       this.jTable4.setAutoCreateRowSorter(true);
/* 3389 */       this.jTable4.getTableHeader().setReorderingAllowed(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void buscarGuias() {
/* 3394 */     if (this.jComboBox4.getItemCount() > 0) {
/* 3395 */       this.jComboBox5.removeAllItems();
/*      */       
/* 3397 */       Date fecha = this.jDateChooser6.getDate();
/*      */       
/* 3399 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3400 */       String cadenaFecha = "";
/* 3401 */       cadenaFecha = formato.format(fecha);
/* 3402 */       String AÑO = cadenaFecha.substring(0, 4);
/* 3403 */       String MES = cadenaFecha.substring(4, 6);
/* 3404 */       String DIA = cadenaFecha.substring(6, 8);
/* 3405 */       String fechaCompleta = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 3407 */       String[] DATOS = this.con.regresaColIndex("folio", "facturas", "where tarjeta=" + this.CLAVES[this.jComboBox4.getSelectedIndex()] + " and fecha>=" + fechaCompleta + " and (estatus like '%<Por Pagar%' || estatus like '%<Abono%') order by folio asc");
/* 3408 */       for (int i = 0; i < DATOS.length; i++) {
/* 3409 */         this.jComboBox5.addItem(DATOS[i]);
/*      */       }
/*      */     } 
/*      */     
/* 3413 */     if (this.jComboBox5.getItemCount() > 0) {
/* 3414 */       String[] datos = this.con.regresaReg("fecha,importeRestanteLetra,importeLetra", "tarjeta_contenido_cliente", "where factura = '" + String.valueOf(this.jComboBox5.getSelectedItem()) + "'", 3);
/* 3415 */       this.jTextField11.setText(datos[0]);
/* 3416 */       this.jTextField12.setText(datos[2]);
/*      */     } else {
/* 3418 */       this.jTextField11.setText("");
/* 3419 */       this.jTextField12.setText("");
/* 3420 */       this.jTextField13.setText("");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 3426 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 3430 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 3434 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3436 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3440 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 3443 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3445 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3449 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 3452 */     this.jTextField20.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3454 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jTextField20, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3458 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jTextField20, evt);
/*      */           }
/*      */         });
/* 3461 */     this.jFormattedTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3463 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jFormattedTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3467 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jFormattedTextField5, evt);
/*      */           }
/*      */         });
/* 3470 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3472 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3476 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 3479 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3481 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3485 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jTextField8, evt);
/*      */           }
/*      */         });
/* 3488 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3490 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jTextField10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3494 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jTextField10, evt);
/*      */           }
/*      */         });
/* 3497 */     this.jTextArea3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3499 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jTextArea3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3503 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jTextArea3, evt);
/*      */           }
/*      */         });
/* 3506 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3508 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3512 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jTextArea5, evt);
/*      */           }
/*      */         });
/* 3515 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3517 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3521 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 3524 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3526 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3530 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 3533 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3535 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3539 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 3542 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3544 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3548 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 3551 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3553 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jComboBox5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3557 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jComboBox5, evt);
/*      */           }
/*      */         });
/* 3560 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3562 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jComboBox6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3566 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jComboBox6, evt);
/*      */           }
/*      */         });
/* 3569 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3571 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jComboBox7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3575 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jComboBox7, evt);
/*      */           }
/*      */         });
/* 3578 */     this.jComboBox8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3580 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jComboBox8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3584 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jComboBox8, evt);
/*      */           }
/*      */         });
/* 3587 */     this.jComboBox9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3589 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jComboBox9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3593 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jComboBox9, evt);
/*      */           }
/*      */         });
/* 3596 */     this.jComboBox14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3598 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jComboBox14, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3602 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jComboBox14, evt);
/*      */           }
/*      */         });
/* 3605 */     this.jComboBox17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3607 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jComboBox17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3611 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jComboBox17, evt);
/*      */           }
/*      */         });
/* 3614 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3616 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3620 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 3623 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3625 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jFormattedTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3629 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/* 3632 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 3634 */             ampararFacturas.this.jTextGanado(ampararFacturas.this.jFormattedTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 3638 */             ampararFacturas.this.jTextPerdido(ampararFacturas.this.jFormattedTextField3, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 3644 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 3652 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 3658 */         return 30;
/*      */       
/*      */       case 1:
/* 3661 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 3663 */           return 29;
/*      */         }
/* 3665 */         return 28;
/*      */     } 
/*      */     
/* 3668 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void AmpararFacturas(String usu) {
/* 3673 */     this.USUARIO = usu;
/* 3674 */     this.panel.setViewportView(this);
/* 3675 */     consultar();
/* 3676 */     sacarUsuarios();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void llenarCombo() {
/* 3682 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONE LA CUENTA", "0067021576", "0144652592", "0240902100", "0288761", "1037487", "4053262770", "686743", "8530040", "9001832" }));
/* 3683 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "BANCO", "BANORTE MN", "BANCOMER MN", "BANORTE USD", "BANAMEX MN", "BANAMEX", "HSBC MN", "BANAMEX MN", "BANAMEX MN", "BANAMEX USD" }));
/*      */     
/* 3685 */     this.CLAVES = this.con.regresaColIndex("tarjeta", "tarjeta_deudor_cliente", "order by nombre_corto");
/*      */     
/* 3687 */     String[] datos = this.con.regresaColIndex("distinct(nombre_corto)", "tarjeta_deudor_cliente", "order by nombre_corto");
/*      */     
/* 3689 */     this.jComboBox1.removeAllItems();
/* 3690 */     this.jComboBox1.addItem("TODOS");
/* 3691 */     this.jComboBox14.removeAllItems(); int i;
/* 3692 */     for (i = 0; i < datos.length; i++) {
/* 3693 */       this.jComboBox1.addItem(datos[i]);
/* 3694 */       this.jComboBox4.addItem(datos[i]);
/* 3695 */       this.jComboBox14.addItem(datos[i]);
/*      */     } 
/*      */     
/* 3698 */     datos = this.con.regresaColIndex("distinct(nombre_usu)", "usuarios", "order by nombre_usu");
/* 3699 */     this.jComboBox2.removeAllItems();
/* 3700 */     this.jComboBox3.removeAllItems();
/* 3701 */     this.jComboBox2.addItem("TODOS");
/* 3702 */     this.jComboBox3.addItem("TODOS");
/* 3703 */     for (i = 0; i < datos.length; i++) {
/* 3704 */       this.jComboBox2.addItem(datos[i]);
/* 3705 */       this.jComboBox3.addItem(datos[i]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 3710 */     Date fecha1 = this.jDateChooser4.getDate();
/* 3711 */     Date fecha2 = this.jDateChooser5.getDate();
/*      */     
/* 3713 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3714 */     String cadenaFecha = "";
/* 3715 */     cadenaFecha = formato.format(fecha1);
/* 3716 */     String AÑO = cadenaFecha.substring(0, 4);
/* 3717 */     String MES = cadenaFecha.substring(4, 6);
/* 3718 */     String DIA = cadenaFecha.substring(6, 8);
/* 3719 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/* 3721 */     cadenaFecha = formato.format(fecha2);
/* 3722 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 3723 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 3724 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 3725 */     int diasTotal = diasDelMes(mm - 1, aa);
/* 3726 */     String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59'";
/*      */     
/* 3728 */     String cliente = "";
/* 3729 */     String entrega = "";
/* 3730 */     String recibe = "";
/* 3731 */     String estatus = "";
/*      */     
/* 3733 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 3734 */       cliente = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     }
/* 3736 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 3737 */       entrega = String.valueOf(this.jComboBox2.getSelectedItem());
/*      */     }
/* 3739 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 3740 */       recibe = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/*      */     
/* 3743 */     if (this.jComboBox6.getSelectedIndex() == 0) {
/* 3744 */       estatus = " and (estatus ='<Por Recibir>' || estatus like '%<Recibido%')";
/*      */     }
/* 3746 */     if (this.jComboBox6.getSelectedIndex() == 1) {
/* 3747 */       estatus = " and estatus like '%<Cancelado%'";
/* 3748 */     } else if (this.jComboBox6.getSelectedIndex() == 2) {
/* 3749 */       estatus = " and estatus like '<Por Recibir>'";
/* 3750 */     } else if (this.jComboBox6.getSelectedIndex() == 3) {
/* 3751 */       estatus = " and estatus like '%<Recibido%'";
/*      */     } 
/*      */     
/* 3754 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 3755 */           .buscarDatos(14, "num,tipo,folio_ent,fechaActual,cliente,banco,cuenta,usuario_entrega,usuario_recibe,fecha,abonadas,facturadas,monto,estatus", "entregar_facturas", "where folio_ent like '%" + this.jTextField1.getText() + "%' and cliente like '%" + cliente + "%' and usuario_entrega like '%" + entrega + "%' and usuario_recibe like '%" + recibe + "%' " + estatus + " and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by num desc"), (Object[])new String[] { "Núm", "Tipo", "Folio", "Creación", "Cliente", "Banco", "Cuenta", "Entrega", "Recibe", "F Depósito", "Abonadas", "Saldadas", "Cantidad", "Estatus" })
/*      */         {
/*      */ 
/*      */           
/* 3759 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3764 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 3768 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable3.getRowCount() + "</HTML>");
/* 3769 */     this.jLabel31.setText("$0.00");
/* 3770 */     this.jLabel32.setText("0");
/* 3771 */     this.jLabel33.setText("0");
/* 3772 */     double valor1 = 0.0D;
/* 3773 */     int valor2 = 0;
/* 3774 */     int valor3 = 0;
/* 3775 */     for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 3776 */       String canti = String.valueOf(this.jTable3.getValueAt(i, 12));
/* 3777 */       String valorP = "";
/* 3778 */       for (int j = 0; j < canti.length(); j++) {
/* 3779 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 3780 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/*      */       
/* 3784 */       valor1 += Double.parseDouble(valorP);
/* 3785 */       this.jFormattedTextField2.setValue(Double.valueOf(valor1));
/* 3786 */       this.jLabel31.setText(this.jFormattedTextField2.getText());
/*      */       
/* 3788 */       canti = String.valueOf(this.jTable3.getValueAt(i, 11));
/* 3789 */       valor2 += Integer.parseInt(canti);
/*      */       
/* 3791 */       canti = String.valueOf(this.jTable3.getValueAt(i, 10));
/* 3792 */       valor3 += Integer.parseInt(canti);
/*      */     } 
/*      */     
/* 3795 */     this.jLabel32.setText("" + valor2);
/* 3796 */     this.jLabel33.setText("" + valor3);
/* 3797 */     this.celda2.pasarInd(this.con.revisarCol(this.jTable3, "<Por Recibir", 2, 13, 2));
/* 3798 */     this.celda2.pasarInd5(this.con.revisarCol(this.jTable3, "<Cancelado", 2, 13, 2));
/*      */     
/* 3800 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 3801 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 3802 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 3803 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 3804 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 3805 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 3806 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 3807 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 3808 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 3809 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 3810 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 3811 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 3812 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 3813 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda2);
/*      */     
/* 3815 */     this.jTable3.setShowVerticalLines(false);
/* 3816 */     this.jTable3.setSelectionMode(0);
/* 3817 */     this.jTable3.setAutoCreateRowSorter(true);
/* 3818 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/* 3819 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 3820 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(50);
/* 3821 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(50);
/* 3822 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(50);
/* 3823 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(70);
/* 3824 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(70);
/* 3825 */     this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(70);
/* 3826 */     this.jTable3.getColumnModel().getColumn(10).setMaxWidth(70);
/*      */   }
/*      */   
/*      */   public void desplazarFecha() {
/* 3830 */     Calendar ca = Calendar.getInstance();
/* 3831 */     Calendar fecha = Calendar.getInstance();
/* 3832 */     fecha.add(2, -3);
/*      */     
/* 3834 */     this.jDateChooser6.setDate(fecha.getTime());
/* 3835 */     this.jDateChooser12.setDate(fecha.getTime());
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 3839 */     this.con.consultar("max(num)", "ENTREGAR_FACTURAS", "");
/* 3840 */     String mayor = this.con.Campo;
/* 3841 */     int MAYOR = 0;
/* 3842 */     if (mayor != null) {
/* 3843 */       MAYOR = Integer.parseInt(mayor);
/*      */     }
/* 3845 */     MAYOR++;
/* 3846 */     if (MAYOR < 100) {
/* 3847 */       this.jTextField5.setText(this.DATOS[0] + "-000" + this.DATOS[0]);
/* 3848 */       this.jTextField19.setText(this.DATOS[0] + "-000" + this.DATOS[0]);
/* 3849 */     } else if (MAYOR < 1000) {
/* 3850 */       this.jTextField5.setText(this.DATOS[0] + "-00" + this.DATOS[0]);
/* 3851 */       this.jTextField19.setText(this.DATOS[0] + "-00" + this.DATOS[0]);
/* 3852 */     } else if (MAYOR < 10000) {
/* 3853 */       this.jTextField5.setText(this.DATOS[0] + "-0" + this.DATOS[0]);
/* 3854 */       this.jTextField19.setText(this.DATOS[0] + "-0" + this.DATOS[0]);
/*      */     } else {
/* 3856 */       this.jTextField5.setText(this.DATOS[0] + "-" + this.DATOS[0]);
/* 3857 */       this.jTextField19.setText(this.DATOS[0] + "-" + this.DATOS[0]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verFacturas() {
/* 3862 */     this.jButton4.setText("Imprimir");
/* 3863 */     this.jButton4.setToolTipText("Imprimir (Alt+I)");
/* 3864 */     this.jButton4.setMnemonic('I');
/* 3865 */     this.jDateChooser6.setEnabled(false);
/* 3866 */     this.jButton7.setEnabled(false);
/* 3867 */     this.jComboBox4.setEnabled(false);
/* 3868 */     this.jComboBox5.setEnabled(false);
/* 3869 */     this.jComboBox7.setEnabled(false);
/* 3870 */     this.jComboBox8.setEnabled(false);
/* 3871 */     this.jButton2.setEnabled(false);
/* 3872 */     this.jDateChooser7.setEnabled(false);
/* 3873 */     this.jFormattedTextField1.setEnabled(false);
/* 3874 */     this.jButton5.setEnabled(false);
/* 3875 */     this.jButton6.setEnabled(false);
/*      */     
/* 3877 */     this.jTextField6.setEnabled(false);
/* 3878 */     this.jTextField7.setEnabled(false);
/* 3879 */     this.jTextField8.setEnabled(false);
/*      */     
/* 3881 */     String[] datos = this.con.regresaReg("folio_ent,usuario_entrega,usuario_recibe,fechaActual,fecha,monto,cliente,abonadas,facturadas,banco,cuenta,ref", "entregar_facturas", "where num=" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)), 12);
/*      */     
/* 3883 */     this.jTextField5.setText(datos[0]);
/* 3884 */     this.jComboBox4.setSelectedItem(datos[6]);
/* 3885 */     this.jComboBox5.removeAllItems();
/* 3886 */     this.jLabel18.setText(datos[5]);
/* 3887 */     this.jLabel13.setText(datos[7]);
/* 3888 */     this.jLabel16.setText(datos[8]);
/*      */     
/* 3890 */     String FECHA = datos[3];
/* 3891 */     String año = FECHA.substring(0, 4);
/* 3892 */     String mes = FECHA.substring(5, 7);
/* 3893 */     String dia = FECHA.substring(8, 10);
/* 3894 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3895 */     String strFecha = año + "-" + año + "-" + mes;
/* 3896 */     Date fecha = null;
/*      */     try {
/* 3898 */       fecha = formatoDelTexto.parse(strFecha);
/* 3899 */     } catch (ParseException ex) {
/* 3900 */       ex.printStackTrace();
/*      */     } 
/* 3902 */     this.jDateChooser8.setDate(fecha);
/*      */     
/* 3904 */     FECHA = datos[4];
/* 3905 */     año = FECHA.substring(0, 4);
/* 3906 */     mes = FECHA.substring(5, 7);
/* 3907 */     dia = FECHA.substring(8, 10);
/* 3908 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 3909 */     strFecha = año + "-" + año + "-" + mes;
/* 3910 */     fecha = null;
/*      */     try {
/* 3912 */       fecha = formatoDelTexto.parse(strFecha);
/* 3913 */     } catch (ParseException ex) {
/* 3914 */       ex.printStackTrace();
/*      */     } 
/* 3916 */     this.jDateChooser7.setDate(fecha);
/*      */     
/* 3918 */     this.jComboBox8.setSelectedItem(datos[9]);
/* 3919 */     this.jComboBox7.setSelectedItem(datos[10]);
/* 3920 */     this.jTextField8.setText(datos[11]);
/*      */     
/* 3922 */     String canti = datos[5];
/* 3923 */     String valorP = "";
/* 3924 */     for (int j = 0; j < canti.length(); j++) {
/* 3925 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',' && canti.charAt(j) != '-') {
/* 3926 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 3929 */     double monto = Double.parseDouble(valorP);
/* 3930 */     this.jFormattedTextField1.setValue(Double.valueOf(monto));
/*      */     
/* 3932 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 3933 */           .buscarDatos(4, "factura,montoOriginal,montoAbonado,tipo", "facturas_abonadas", "where folio_ent ='" + this.jTextField5.getText() + "' order by num"), (Object[])new String[] { "Factura", "Monto Original", "Monto Abonado", "Tipo" })
/*      */         {
/*      */ 
/*      */           
/* 3937 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3942 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 3946 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 3947 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/*      */     
/* 3949 */     Double subtotal = Double.valueOf(0.0D);
/* 3950 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 3951 */       canti = String.valueOf(this.jTable1.getValueAt(i, 2));
/* 3952 */       String tipo = String.valueOf(this.jTable1.getValueAt(i, 3));
/* 3953 */       valorP = "";
/* 3954 */       for (int k = 0; k < canti.length(); k++) {
/* 3955 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',' && canti.charAt(k) != '-') {
/* 3956 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 3959 */       if (!tipo.contains("*")) {
/* 3960 */         subtotal = Double.valueOf(subtotal.doubleValue() + Double.parseDouble(valorP));
/*      */       }
/*      */     } 
/*      */     
/* 3964 */     this.jFormattedTextField2.setValue(subtotal);
/* 3965 */     this.jLabel40.setText(this.jFormattedTextField2.getText());
/*      */   }
/*      */   
/*      */   public void verFacturas2() {
/* 3969 */     this.jButton32.setText("Imprimir");
/* 3970 */     this.jButton32.setToolTipText("Imprimir (Alt+I)");
/* 3971 */     this.jButton32.setMnemonic('I');
/* 3972 */     this.jDateChooser12.setEnabled(false);
/* 3973 */     this.jButton34.setEnabled(false);
/* 3974 */     this.jComboBox14.setEnabled(false);
/* 3975 */     this.jComboBox5.setEnabled(false);
/* 3976 */     this.jComboBox17.setEnabled(false);
/*      */     
/* 3978 */     this.jButton36.setEnabled(false);
/* 3979 */     this.jDateChooser13.setEnabled(false);
/* 3980 */     this.jFormattedTextField5.setEnabled(false);
/* 3981 */     this.jButton33.setEnabled(false);
/* 3982 */     this.jButton35.setEnabled(false);
/* 3983 */     this.jTextField20.setEnabled(false);
/*      */     
/* 3985 */     this.jTextField6.setEnabled(false);
/* 3986 */     this.jTextField7.setEnabled(false);
/* 3987 */     this.jTextField8.setEnabled(false);
/*      */     
/* 3989 */     String[] datos = this.con.regresaReg("folio_ent,usuario_entrega,usuario_recibe,fechaActual,fecha,monto,cliente,abonadas,facturadas,banco,cuenta,ref", "entregar_facturas", "where num=" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)), 12);
/*      */     
/* 3991 */     this.jTextField19.setText(datos[0]);
/* 3992 */     this.jComboBox14.setSelectedItem(datos[6]);
/* 3993 */     this.jComboBox17.removeAllItems();
/* 3994 */     this.jLabel96.setText(datos[5]);
/* 3995 */     this.jLabel89.setText(datos[7]);
/* 3996 */     this.jLabel91.setText(datos[8]);
/*      */     
/* 3998 */     String FECHA = datos[3];
/* 3999 */     String año = FECHA.substring(0, 4);
/* 4000 */     String mes = FECHA.substring(5, 7);
/* 4001 */     String dia = FECHA.substring(8, 10);
/* 4002 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4003 */     String strFecha = año + "-" + año + "-" + mes;
/* 4004 */     Date fecha = null;
/*      */     try {
/* 4006 */       fecha = formatoDelTexto.parse(strFecha);
/* 4007 */     } catch (ParseException ex) {
/* 4008 */       ex.printStackTrace();
/*      */     } 
/* 4010 */     this.jDateChooser14.setDate(fecha);
/*      */     
/* 4012 */     FECHA = datos[4];
/* 4013 */     año = FECHA.substring(0, 4);
/* 4014 */     mes = FECHA.substring(5, 7);
/* 4015 */     dia = FECHA.substring(8, 10);
/* 4016 */     formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4017 */     strFecha = año + "-" + año + "-" + mes;
/* 4018 */     fecha = null;
/*      */     try {
/* 4020 */       fecha = formatoDelTexto.parse(strFecha);
/* 4021 */     } catch (ParseException ex) {
/* 4022 */       ex.printStackTrace();
/*      */     } 
/* 4024 */     this.jDateChooser13.setDate(fecha);
/* 4025 */     this.jTextField20.setText(datos[9]);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4030 */     String canti = datos[5];
/* 4031 */     String valorP = "";
/* 4032 */     for (int j = 0; j < canti.length(); j++) {
/* 4033 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',' && canti.charAt(j) != '-') {
/* 4034 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4037 */     double monto = Double.parseDouble(valorP);
/* 4038 */     this.jFormattedTextField5.setValue(Double.valueOf(monto));
/*      */     
/* 4040 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 4041 */           .buscarDatos(4, "factura,montoOriginal,montoAbonado,tipo", "facturas_abonadas", "where folio_ent ='" + this.jTextField19.getText() + "' order by num"), (Object[])new String[] { "Factura", "Monto Original", "Monto Abonado", "Tipo" })
/*      */         {
/*      */ 
/*      */           
/* 4045 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4050 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 4054 */     this.jTable4.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 4055 */     this.jTable4.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/*      */     
/* 4057 */     Double subtotal = Double.valueOf(0.0D);
/* 4058 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 4059 */       canti = String.valueOf(this.jTable4.getValueAt(i, 2));
/* 4060 */       String tipo = String.valueOf(this.jTable4.getValueAt(i, 3));
/* 4061 */       valorP = "";
/* 4062 */       for (int k = 0; k < canti.length(); k++) {
/* 4063 */         if (canti.charAt(k) != '$' && canti.charAt(k) != ',' && canti.charAt(k) != '-') {
/* 4064 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 4067 */       if (!tipo.contains("*")) {
/* 4068 */         subtotal = Double.valueOf(subtotal.doubleValue() + Double.parseDouble(valorP));
/*      */       }
/*      */     } 
/*      */     
/* 4072 */     this.jFormattedTextField2.setValue(subtotal);
/* 4073 */     this.jLabel94.setText(this.jFormattedTextField2.getText());
/*      */   }
/*      */   
/*      */   public int alinearDer(int x, int letras) {
/* 4077 */     int quitar = 4 * letras;
/* 4078 */     x -= quitar;
/* 4079 */     return x;
/*      */   }
/*      */   
/*      */   public class CeldaRender2
/*      */     extends DefaultTableCellRenderer {
/* 4084 */     int otro = -1;
/* 4085 */     String[] indices = new String[0];
/* 4086 */     String[] indices3 = new String[0];
/* 4087 */     String[] indices5 = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4090 */       setEnabled((table == null || table.isEnabled()));
/* 4091 */       String comp = String.valueOf(table.getValueAt(row, 2));
/* 4092 */       if (comparar(comp)) {
/* 4093 */         setBackground(new Color(102, 153, 255));
/* 4094 */         setForeground(Color.BLUE);
/* 4095 */       } else if (comparar3(comp)) {
/* 4096 */         setBackground(new Color(153, 153, 153));
/* 4097 */         setForeground(Color.BLACK);
/* 4098 */       } else if (comparar5(comp)) {
/* 4099 */         setBackground(Color.RED);
/* 4100 */         setForeground(Color.WHITE);
/*      */       } else {
/* 4102 */         setBackground((Color)null);
/* 4103 */         setForeground(Color.black);
/*      */       } 
/* 4105 */       if (column == 10 || column == 11 || column == 12) {
/* 4106 */         setHorizontalAlignment(4);
/*      */       } else {
/* 4108 */         setHorizontalAlignment(2);
/*      */       } 
/* 4110 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4111 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 4115 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 4119 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd5(String[] ind) {
/* 4123 */       this.indices5 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 4127 */       for (int i = 0; i < this.indices.length; i++) {
/* 4128 */         if (this.indices[i].equals(reg)) {
/* 4129 */           return true;
/*      */         }
/*      */       } 
/* 4132 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 4136 */       for (int i = 0; i < this.indices3.length; i++) {
/* 4137 */         if (this.indices3[i].equals(reg)) {
/* 4138 */           return true;
/*      */         }
/*      */       } 
/* 4141 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar5(String reg) {
/* 4145 */       for (int i = 0; i < this.indices5.length; i++) {
/* 4146 */         if (this.indices5[i].equals(reg)) {
/* 4147 */           return true;
/*      */         }
/*      */       } 
/* 4150 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 4156 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4159 */       setEnabled((table == null || table.isEnabled()));
/* 4160 */       setHorizontalAlignment(4);
/* 4161 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4162 */       return this;
/*      */     } }
/*      */   public class ImprimirDocumento implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirDocumento() {
/* 4170 */       this.g2 = null;
/* 4171 */       this.Pag = 0;
/*      */       
/* 4173 */       this.linesPerPage = 50;
/* 4174 */       this.orientacion = 0;
/* 4175 */       this.X = 0.0D;
/* 4176 */       this.Y = 0.0D;
/* 4177 */       this.YINICIA = 75;
/* 4178 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 4179 */       this.NumLineas = 0;
/* 4180 */       this.numBreaks = 0;
/*      */     }
/*      */     private void initTextLines() {
/* 4183 */       if (this.textLines == null) {
/* 4184 */         int numLines = ampararFacturas.this.jTable1.getRowCount();
/* 4185 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 4190 */       Font font = new Font("Serif", 0, 8);
/* 4191 */       FontMetrics metrics = g.getFontMetrics(font);
/* 4192 */       int lineHeight = metrics.getHeight();
/* 4193 */       if (this.pageBreaks == null) {
/* 4194 */         initTextLines();
/* 4195 */         this.orientacion = pf.getOrientation();
/* 4196 */         if (pf.getOrientation() == 1) {
/* 4197 */           this.linesPerPage = 45;
/* 4198 */           this.X = pf.getWidth();
/* 4199 */           this.Y = pf.getHeight();
/*      */         } else {
/* 4201 */           this.linesPerPage = 38;
/* 4202 */           this.X = pf.getWidth();
/* 4203 */           this.Y = pf.getHeight();
/*      */         } 
/* 4205 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 4206 */         this.Pag = this.numBreaks;
/* 4207 */         this.pageBreaks = new int[this.numBreaks];
/* 4208 */         for (int b = 0; b < this.numBreaks; b++) {
/* 4209 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 4212 */       if (pageIndex > this.pageBreaks.length) {
/* 4213 */         return 1;
/*      */       }
/* 4215 */       Graphics2D g2d = (Graphics2D)g;
/* 4216 */       this.g2 = g;
/* 4217 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 4218 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 4219 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 4220 */       encabezado();
/* 4221 */       int y = this.YINICIA;
/* 4222 */       int lineas = 0;
/*      */       
/* 4224 */       this.g2.drawRect(25, 180, 550, 12);
/* 4225 */       this.g2.setColor(new Color(204, 0, 0));
/* 4226 */       this.g2.fillRect(25, 181, 550, 10);
/*      */       
/* 4228 */       Font fuente = new Font("Dialog", 0, 7);
/* 4229 */       this.g2.setFont(fuente);
/* 4230 */       this.g2.setColor(Color.WHITE);
/* 4231 */       this.g2.drawString("NÚM", 29, 189);
/* 4232 */       this.g2.drawString("CARGO", 105, 189);
/* 4233 */       this.g2.drawString("IMPORTE ORIGINAL", 217, 189);
/* 4234 */       this.g2.drawString("IMPORTE SALDADO", 360, 189);
/* 4235 */       this.g2.drawString("TIPO", 505, 189);
/*      */       
/* 4237 */       this.g2.setColor(Color.BLACK);
/* 4238 */       y = 191;
/* 4239 */       for (int line = start; line < end; line++) {
/* 4240 */         y += 12;
/* 4241 */         this.g2.drawLine(25, y, 575, y);
/*      */         
/* 4243 */         String valor = "";
/* 4244 */         if (line < 9) {
/* 4245 */           valor = "0" + line + 1;
/*      */         } else {
/* 4247 */           valor = "" + line + 1;
/*      */         } 
/* 4249 */         fuente = new Font("Dialog", 1, 7);
/* 4250 */         this.g2.setFont(fuente);
/* 4251 */         this.g2.drawString(valor, 27, y - 2);
/*      */         
/* 4253 */         fuente = new Font("Dialog", 0, 7);
/* 4254 */         this.g2.setFont(fuente);
/*      */         
/* 4256 */         this.g2.drawString(String.valueOf(ampararFacturas.this.jTable1.getValueAt(line, 0)), 105, y - 2);
/* 4257 */         this.g2.drawString(String.valueOf(ampararFacturas.this.jTable1.getValueAt(line, 1)), ampararFacturas.this.alinearDer(275, ampararFacturas.this.jTable1.getValueAt(line, 1).toString().length()), y - 2);
/* 4258 */         this.g2.drawString(String.valueOf(ampararFacturas.this.jTable1.getValueAt(line, 2)), ampararFacturas.this.alinearDer(420, ampararFacturas.this.jTable1.getValueAt(line, 2).toString().length()), y - 2);
/* 4259 */         this.g2.drawString(String.valueOf(ampararFacturas.this.jTable1.getValueAt(line, 3)), 495, y - 2);
/*      */       } 
/* 4261 */       this.g2.drawLine(25, 181, 25, y);
/* 4262 */       this.g2.drawLine(575, 181, 575, y);
/* 4263 */       fuente = new Font("Dialog", 0, 7);
/* 4264 */       this.g2.setFont(fuente);
/* 4265 */       g.drawString("Página " + pageIndex + 1, 548, 755);
/* 4266 */       this.g2.setColor(Color.WHITE);
/* 4267 */       this.g2.fillRect((int)this.X - 46, 0, (int)this.X - 46, lineas);
/*      */       
/* 4269 */       if (this.Pag == pageIndex) {
/* 4270 */         fuente = new Font("Dialog", 1, 7);
/* 4271 */         this.g2.setFont(fuente);
/* 4272 */         this.g2.setColor(Color.BLACK);
/* 4273 */         this.g2.drawString("ELABORÓ", 190, 720);
/* 4274 */         this.g2.drawString("_____________________________________", 140, 752);
/* 4275 */         this.g2.drawString("NOMBRE Y FIRMA", 178, 765);
/*      */         
/* 4277 */         this.g2.drawString("REVISÓ", 390, 720);
/* 4278 */         this.g2.drawString("_____________________________________", 340, 752);
/* 4279 */         this.g2.drawString("NOMBRE Y FIRMA", 378, 765);
/*      */       } 
/* 4281 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 4285 */       Font fuente = new Font("Dialog", 0, 8);
/* 4286 */       this.g2.setFont(fuente);
/* 4287 */       this.g2.setColor(Color.BLACK);
/* 4288 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 4289 */       Image img = imagen.getImage();
/* 4290 */       this.g2.drawImage(img, 518, 15, 60, 60, null);
/*      */       
/* 4292 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 4293 */       img = imagen.getImage();
/* 4294 */       this.g2.drawImage(img, 27, 15, 60, 50, null);
/*      */       
/* 4296 */       fuente = new Font("Times New Roman", 1, 16);
/* 4297 */       this.g2.setFont(fuente);
/* 4298 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 40);
/* 4299 */       fuente = new Font("Dialog", 0, 12);
/* 4300 */       this.g2.setFont(fuente);
/* 4301 */       this.g2.drawString("SALDAR FACTURAS: " + ampararFacturas.this.jTextField5.getText(), 200, 57);
/*      */       
/* 4303 */       this.g2.drawRect(25, 85, 550, 80);
/*      */       
/* 4305 */       this.g2.setColor(new Color(204, 0, 0));
/* 4306 */       this.g2.fillRect(25, 86, 550, 12);
/*      */       
/* 4308 */       this.g2.setColor(Color.BLACK);
/* 4309 */       this.g2.drawLine(25, 98, 575, 98);
/*      */       
/* 4311 */       this.g2.drawLine(287, 98, 287, 164);
/*      */       
/* 4313 */       fuente = new Font("Dialog", 0, 8);
/* 4314 */       this.g2.setFont(fuente);
/* 4315 */       this.g2.setColor(Color.WHITE);
/* 4316 */       this.g2.drawString("INFORMACIÓN", 260, 95);
/*      */       
/* 4318 */       fuente = new Font("Dialog", 0, 7);
/* 4319 */       this.g2.setFont(fuente);
/* 4320 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 4322 */       this.g2.drawString("CLIENTE: ", 27, 108);
/* 4323 */       this.g2.drawString("ENTREGA: ", 27, 119);
/* 4324 */       this.g2.drawString("RECIBE: ", 27, 130);
/* 4325 */       this.g2.drawString("F DE DEPÓSITO: ", 27, 141);
/* 4326 */       this.g2.drawString("F DE CREACIÓN: ", 27, 152);
/*      */       
/* 4328 */       this.g2.drawString("BANCO: ", 292, 108);
/* 4329 */       this.g2.drawString("CUENTA: ", 292, 119);
/* 4330 */       this.g2.drawString("REF: ", 292, 130);
/* 4331 */       this.g2.drawString("TOTAL " + ampararFacturas.this.DATOS[2] + ": ", 292, 141);
/* 4332 */       this.g2.drawString("TOTAL GENERAL: ", 445, 141);
/* 4333 */       this.g2.drawString("FACT ABONADAS: ", 292, 152);
/* 4334 */       this.g2.drawString("FACT SALDADAS: ", 292, 163);
/*      */       
/* 4336 */       fuente = new Font("Dialog", 1, 7);
/* 4337 */       this.g2.setFont(fuente);
/* 4338 */       this.g2.drawString(String.valueOf(ampararFacturas.this.jComboBox4.getSelectedItem()), 110, 108);
/* 4339 */       this.g2.drawString(ampararFacturas.this.ENTREGA, 110, 119);
/* 4340 */       this.g2.drawString(ampararFacturas.this.RECIBE, 110, 130);
/*      */       
/* 4342 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4343 */       String cadenaFecha1 = formato.format(ampararFacturas.this.jDateChooser7.getDate());
/* 4344 */       String año = cadenaFecha1.substring(0, 4);
/* 4345 */       String mes = cadenaFecha1.substring(4, 6);
/* 4346 */       String dia = cadenaFecha1.substring(6, 8);
/* 4347 */       this.g2.drawString(dia + "/" + dia + "/" + mes, 110, 141);
/*      */       
/* 4349 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 4350 */       cadenaFecha1 = formato.format(ampararFacturas.this.jDateChooser8.getDate());
/* 4351 */       año = cadenaFecha1.substring(0, 4);
/* 4352 */       mes = cadenaFecha1.substring(4, 6);
/* 4353 */       dia = cadenaFecha1.substring(6, 8);
/* 4354 */       this.g2.drawString(dia + "/" + dia + "/" + mes, 110, 152);
/*      */ 
/*      */       
/* 4357 */       this.g2.drawString(String.valueOf(ampararFacturas.this.jComboBox8.getSelectedItem()), 380, 108);
/* 4358 */       this.g2.drawString(String.valueOf(ampararFacturas.this.jComboBox7.getSelectedItem()), 380, 119);
/* 4359 */       this.g2.drawString(ampararFacturas.this.jTextField8.getText().toUpperCase(), 380, 130);
/* 4360 */       this.g2.drawString(ampararFacturas.this.jLabel40.getText(), 380, 141);
/* 4361 */       this.g2.drawString(ampararFacturas.this.jLabel18.getText(), 515, 141);
/* 4362 */       this.g2.drawString(ampararFacturas.this.jLabel13.getText(), 380, 152);
/* 4363 */       this.g2.drawString(ampararFacturas.this.jLabel16.getText(), 380, 163);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 4367 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 4368 */       job.setPrintable(this);
/*      */       
/* 4370 */       PageFormat pf = job.defaultPage();
/* 4371 */       Paper papel = pf.getPaper();
/* 4372 */       papel.setSize(612.0D, 792.0D);
/* 4373 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 4374 */       pf.setPaper(papel);
/* 4375 */       pf.setOrientation(1);
/* 4376 */       job.setPrintable(new ImprimirDocumento(), pf);
/* 4377 */       job.defaultPage(pf);
/*      */       
/* 4379 */       boolean ok = job.printDialog();
/* 4380 */       if (ok)
/*      */         try {
/* 4382 */           job.print();
/* 4383 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirNotadeCredito implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirNotadeCredito() {
/* 4393 */       this.g2 = null;
/* 4394 */       this.Pag = 0;
/*      */       
/* 4396 */       this.linesPerPage = 50;
/* 4397 */       this.orientacion = 0;
/* 4398 */       this.X = 0.0D;
/* 4399 */       this.Y = 0.0D;
/* 4400 */       this.YINICIA = 75;
/* 4401 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 4402 */       this.NumLineas = 0;
/* 4403 */       this.numBreaks = 0;
/*      */     }
/*      */     private void initTextLines() {
/* 4406 */       if (this.textLines == null) {
/* 4407 */         int numLines = ampararFacturas.this.jTable4.getRowCount();
/* 4408 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 4413 */       Font font = new Font("Serif", 0, 8);
/* 4414 */       FontMetrics metrics = g.getFontMetrics(font);
/* 4415 */       int lineHeight = metrics.getHeight();
/* 4416 */       if (this.pageBreaks == null) {
/* 4417 */         initTextLines();
/* 4418 */         this.orientacion = pf.getOrientation();
/* 4419 */         if (pf.getOrientation() == 1) {
/* 4420 */           this.linesPerPage = 45;
/* 4421 */           this.X = pf.getWidth();
/* 4422 */           this.Y = pf.getHeight();
/*      */         } else {
/* 4424 */           this.linesPerPage = 38;
/* 4425 */           this.X = pf.getWidth();
/* 4426 */           this.Y = pf.getHeight();
/*      */         } 
/* 4428 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 4429 */         this.Pag = this.numBreaks;
/* 4430 */         this.pageBreaks = new int[this.numBreaks];
/* 4431 */         for (int b = 0; b < this.numBreaks; b++) {
/* 4432 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 4435 */       if (pageIndex > this.pageBreaks.length) {
/* 4436 */         return 1;
/*      */       }
/* 4438 */       Graphics2D g2d = (Graphics2D)g;
/* 4439 */       this.g2 = g;
/* 4440 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 4441 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 4442 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 4443 */       encabezado();
/* 4444 */       int y = this.YINICIA;
/* 4445 */       int lineas = 0;
/*      */       
/* 4447 */       this.g2.drawRect(25, 180, 550, 12);
/* 4448 */       this.g2.setColor(new Color(204, 0, 0));
/* 4449 */       this.g2.fillRect(25, 181, 550, 10);
/*      */       
/* 4451 */       Font fuente = new Font("Dialog", 0, 7);
/* 4452 */       this.g2.setFont(fuente);
/* 4453 */       this.g2.setColor(Color.WHITE);
/* 4454 */       this.g2.drawString("NÚM", 29, 189);
/* 4455 */       this.g2.drawString("CARGO", 105, 189);
/* 4456 */       this.g2.drawString("IMPORTE ORIGINAL", 217, 189);
/* 4457 */       this.g2.drawString("IMPORTE SALDADO", 360, 189);
/* 4458 */       this.g2.drawString("TIPO", 505, 189);
/*      */       
/* 4460 */       this.g2.setColor(Color.BLACK);
/* 4461 */       y = 191;
/* 4462 */       for (int line = start; line < end; line++) {
/* 4463 */         y += 12;
/* 4464 */         this.g2.drawLine(25, y, 575, y);
/*      */         
/* 4466 */         String valor = "";
/* 4467 */         if (line < 9) {
/* 4468 */           valor = "0" + line + 1;
/*      */         } else {
/* 4470 */           valor = "" + line + 1;
/*      */         } 
/* 4472 */         fuente = new Font("Dialog", 1, 7);
/* 4473 */         this.g2.setFont(fuente);
/* 4474 */         this.g2.drawString(valor, 27, y - 2);
/*      */         
/* 4476 */         fuente = new Font("Dialog", 0, 7);
/* 4477 */         this.g2.setFont(fuente);
/*      */         
/* 4479 */         this.g2.drawString(String.valueOf(ampararFacturas.this.jTable4.getValueAt(line, 0)), 105, y - 2);
/* 4480 */         this.g2.drawString(String.valueOf(ampararFacturas.this.jTable4.getValueAt(line, 1)), ampararFacturas.this.alinearDer(275, ampararFacturas.this.jTable4.getValueAt(line, 1).toString().length()), y - 2);
/* 4481 */         this.g2.drawString(String.valueOf(ampararFacturas.this.jTable4.getValueAt(line, 2)), ampararFacturas.this.alinearDer(420, ampararFacturas.this.jTable4.getValueAt(line, 2).toString().length()), y - 2);
/* 4482 */         this.g2.drawString(String.valueOf(ampararFacturas.this.jTable4.getValueAt(line, 3)), 495, y - 2);
/*      */       } 
/* 4484 */       this.g2.drawLine(25, 181, 25, y);
/* 4485 */       this.g2.drawLine(575, 181, 575, y);
/* 4486 */       fuente = new Font("Dialog", 0, 7);
/* 4487 */       this.g2.setFont(fuente);
/* 4488 */       g.drawString("Página " + pageIndex + 1, 548, 755);
/* 4489 */       this.g2.setColor(Color.WHITE);
/* 4490 */       this.g2.fillRect((int)this.X - 46, 0, (int)this.X - 46, lineas);
/*      */       
/* 4492 */       if (this.Pag == pageIndex) {
/* 4493 */         fuente = new Font("Dialog", 1, 7);
/* 4494 */         this.g2.setFont(fuente);
/* 4495 */         this.g2.setColor(Color.BLACK);
/* 4496 */         this.g2.drawString("ELABORÓ", 190, 720);
/* 4497 */         this.g2.drawString("_____________________________________", 140, 752);
/* 4498 */         this.g2.drawString("NOMBRE Y FIRMA", 178, 765);
/*      */         
/* 4500 */         this.g2.drawString("REVISÓ", 390, 720);
/* 4501 */         this.g2.drawString("_____________________________________", 340, 752);
/* 4502 */         this.g2.drawString("NOMBRE Y FIRMA", 378, 765);
/*      */       } 
/* 4504 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 4508 */       Font fuente = new Font("Dialog", 0, 8);
/* 4509 */       this.g2.setFont(fuente);
/* 4510 */       this.g2.setColor(Color.BLACK);
/* 4511 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 4512 */       Image img = imagen.getImage();
/* 4513 */       this.g2.drawImage(img, 518, 15, 60, 60, null);
/*      */       
/* 4515 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 4516 */       img = imagen.getImage();
/* 4517 */       this.g2.drawImage(img, 27, 15, 60, 50, null);
/*      */       
/* 4519 */       fuente = new Font("Times New Roman", 1, 16);
/* 4520 */       this.g2.setFont(fuente);
/*      */       
/* 4522 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 40);
/* 4523 */       fuente = new Font("Dialog", 0, 12);
/* 4524 */       this.g2.setFont(fuente);
/* 4525 */       this.g2.drawString("SALDAR FACTURAS POR NOTA DE CRÉDITO: " + ampararFacturas.this.jTextField19.getText(), 145, 57);
/* 4526 */       fuente = new Font("Dialog", 1, 12);
/* 4527 */       this.g2.setFont(fuente);
/* 4528 */       this.g2.drawString("NOTA DE CRÉDITO: " + ampararFacturas.this.jTextField20.getText(), 230, 74);
/*      */       
/* 4530 */       this.g2.drawRect(25, 85, 550, 80);
/* 4531 */       this.g2.setColor(new Color(204, 0, 0));
/* 4532 */       this.g2.fillRect(25, 86, 550, 12);
/*      */       
/* 4534 */       this.g2.setColor(Color.BLACK);
/* 4535 */       this.g2.drawLine(25, 98, 575, 98);
/*      */       
/* 4537 */       this.g2.drawLine(287, 98, 287, 164);
/*      */       
/* 4539 */       fuente = new Font("Dialog", 0, 8);
/* 4540 */       this.g2.setFont(fuente);
/* 4541 */       this.g2.setColor(Color.WHITE);
/* 4542 */       this.g2.drawString("INFORMACIÓN", 260, 95);
/*      */       
/* 4544 */       fuente = new Font("Dialog", 0, 7);
/* 4545 */       this.g2.setFont(fuente);
/* 4546 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 4548 */       this.g2.drawString("CLIENTE: ", 27, 108);
/* 4549 */       this.g2.drawString("ENTREGA: ", 27, 119);
/* 4550 */       this.g2.drawString("RECIBE: ", 27, 130);
/* 4551 */       this.g2.drawString("F DE LA N.C.: ", 27, 141);
/* 4552 */       this.g2.drawString("F DE CREACIÓN: ", 27, 152);
/*      */       
/* 4554 */       this.g2.drawString("BANCO: ", 292, 108);
/* 4555 */       this.g2.drawString("CUENTA: ", 292, 119);
/* 4556 */       this.g2.drawString("REF: ", 292, 130);
/* 4557 */       this.g2.drawString("TOTAL " + ampararFacturas.this.DATOS[2] + ": ", 292, 141);
/* 4558 */       this.g2.drawString("TOTAL GENERAL: ", 445, 141);
/* 4559 */       this.g2.drawString("FACT ABONADAS: ", 292, 152);
/* 4560 */       this.g2.drawString("FACT SALDADAS: ", 292, 163);
/*      */       
/* 4562 */       fuente = new Font("Dialog", 1, 7);
/* 4563 */       this.g2.setFont(fuente);
/* 4564 */       this.g2.drawString(String.valueOf(ampararFacturas.this.jComboBox14.getSelectedItem()), 110, 108);
/* 4565 */       this.g2.drawString(ampararFacturas.this.ENTREGA, 110, 119);
/* 4566 */       this.g2.drawString(ampararFacturas.this.RECIBE, 110, 130);
/*      */       
/* 4568 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4569 */       String cadenaFecha1 = formato.format(ampararFacturas.this.jDateChooser13.getDate());
/* 4570 */       String año = cadenaFecha1.substring(0, 4);
/* 4571 */       String mes = cadenaFecha1.substring(4, 6);
/* 4572 */       String dia = cadenaFecha1.substring(6, 8);
/* 4573 */       this.g2.drawString(dia + "/" + dia + "/" + mes, 110, 141);
/*      */       
/* 4575 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 4576 */       cadenaFecha1 = formato.format(ampararFacturas.this.jDateChooser14.getDate());
/* 4577 */       año = cadenaFecha1.substring(0, 4);
/* 4578 */       mes = cadenaFecha1.substring(4, 6);
/* 4579 */       dia = cadenaFecha1.substring(6, 8);
/* 4580 */       this.g2.drawString(dia + "/" + dia + "/" + mes, 110, 152);
/*      */ 
/*      */       
/* 4583 */       this.g2.drawString("--", 380, 108);
/* 4584 */       this.g2.drawString("--", 380, 119);
/* 4585 */       this.g2.drawString("--", 380, 130);
/* 4586 */       this.g2.drawString(ampararFacturas.this.jLabel94.getText(), 380, 141);
/* 4587 */       this.g2.drawString(ampararFacturas.this.jLabel96.getText(), 515, 141);
/* 4588 */       this.g2.drawString(ampararFacturas.this.jLabel89.getText(), 380, 152);
/* 4589 */       this.g2.drawString(ampararFacturas.this.jLabel91.getText(), 380, 163);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 4593 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 4594 */       job.setPrintable(this);
/*      */       
/* 4596 */       PageFormat pf = job.defaultPage();
/* 4597 */       Paper papel = pf.getPaper();
/* 4598 */       papel.setSize(612.0D, 792.0D);
/* 4599 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 4600 */       pf.setPaper(papel);
/* 4601 */       pf.setOrientation(1);
/* 4602 */       job.setPrintable(new ImprimirNotadeCredito(), pf);
/* 4603 */       job.defaultPage(pf);
/*      */       
/* 4605 */       boolean ok = job.printDialog();
/* 4606 */       if (ok)
/*      */         try {
/* 4608 */           job.print();
/* 4609 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ampararFacturas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */