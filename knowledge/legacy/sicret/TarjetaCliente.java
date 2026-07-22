/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridLayout;
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
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.Map;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JComponent;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import net.sf.jasperreports.engine.JasperPrint;
/*      */ import net.sf.jasperreports.engine.data.JRTableModelDataSource;
/*      */ import net.sf.jasperreports.view.JasperViewer;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ 
/*      */ public class TarjetaCliente extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   61 */   Date fechaActual = new Date();
/*   62 */   Date fechaInicio = null;
/*   63 */   Date fecha = new Date();
/*   64 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   65 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   66 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   67 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   68 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   69 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   70 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   71 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   72 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   73 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*   74 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   75 */   JFrame padre = null;
/*   76 */   JTabbedPane fichas = null;
/*   77 */   DefaultTableModel modelo = new DefaultTableModel();
/*      */   boolean encontrado = false;
/*   79 */   Consultas2 con = new Consultas2();
/*   80 */   String CLAVECLIENTE = "";
/*   81 */   CeldaRender celda = new CeldaRender();
/*   82 */   CeldaRender2 celda2 = new CeldaRender2();
/*   83 */   CeldaRender3 celda3 = new CeldaRender3();
/*   84 */   String TARJETA = "";
/*      */   String DIRECTIVAS;
/*   86 */   Errores error = new Errores(false);
/*   87 */   Validaciones val = new Validaciones();
/*   88 */   String MAXABONO = "";
/*      */   EscribirReporte esc;
/*   90 */   String TIPOCANCEL = "";
/*   91 */   double SALDAR = 0.0D;
/*   92 */   double AUXLIARSALDO = 0.0D;
/*   93 */   double SALDOACUMULADO = 0.0D;
/*   94 */   String[] IMPGUIAS = null;
/*   95 */   String[] IMPORTES = null;
/*   96 */   String[] RESTAS = null;
/*   97 */   String[] TIPOS = null;
/*   98 */   String[] DATOS = new String[18];
/*   99 */   String DEPARTAMENTO = "";
/*  100 */   double VALOR1 = 0.0D;
/*  101 */   double VALOR2 = 0.0D;
/*  102 */   String[] COL1 = null;
/*  103 */   int TOTALDATOS = 0;
/*      */   boolean ACTIVARCONSULTA = false;
/*  105 */   MensajePop mensajeTry = null;
/*  106 */   Presionado presionado = null;
/*  107 */   SColores lc = new SColores();
/*      */   String[] CONFIGURACIONES;
/*      */   Map<String, String> CAMPOSGENERALES;
/*  110 */   Utilerias utilerias = new Utilerias(); private JTable TablaAux; private JTable TablaAux1; private JTable TablaGral; private JTable TablaGral1; private JTable TablaGral2; private JTable TablaGral3; private JFormattedTextField auxiliar; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private ButtonGroup buttonGroup3; private ButtonGroup buttonGroup4; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton3; private JButton jButton4; private JButton jButton44; private JButton jButton45; private JButton jButton47; private JButton jButton48; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox<String> jComboBox1; private JComboBox jComboBox12; private JComboBox<String> jComboBox2; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JDateChooser jDateChooser1; private JDateChooser jDateChooser4; private JDateChooser jDateChooser7; private JDateChooser jDateChooser8; private JDateChooser jDateChooser9; private JDialog jDialog1; private JDialog jDialog10; private JDialog jDialog11; private JDialog jDialog12; private JDialog jDialog13; private JDialog jDialog14; private JDialog jDialog15; private JDialog jDialog16; private JDialog jDialog17; private JDialog jDialog18; private JDialog jDialog19; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102;
/*  111 */   pintarComponentes pintar = new pintarComponentes(); private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel127; private JLabel jLabel128; private JLabel jLabel129; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74;
/*      */   
/*      */   public TarjetaCliente(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES) {
/*  114 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  115 */     this.mensajeTry = this.mensajeTry;
/*  116 */     this.padre = padre;
/*  117 */     this.fichas = fichas;
/*  118 */     initComponents();
/*  119 */     this.USUARIO = USUARIO;
/*  120 */     panelito.setViewportView(this);
/*      */     
/*  122 */     this.panel = panelito;
/*  123 */     initComponents();
/*  124 */     this.jScrollPane13.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*      */     
/*  126 */     int w = this.tama.width;
/*  127 */     int h = this.tama.height;
/*  128 */     int rw = (w - 820) / 2;
/*  129 */     int rh = (h - 320) / 2;
/*  130 */     this.jDialog1.setLocation(30, 30);
/*  131 */     this.jDialog1.setSize(820, 320);
/*  132 */     this.jDialog1.setVisible(false);
/*  133 */     this.jDialog1.setResizable(false);
/*      */     
/*  135 */     rw = (w - 1035) / 2;
/*  136 */     rh = (h - 597) / 2;
/*      */     
/*  138 */     this.jDialog2.setSize(this.tama.width - 200, this.tama.height - 150);
/*  139 */     this.jDialog2.setLocation(30, 30);
/*  140 */     this.jDialog2.setVisible(false);
/*  141 */     this.jDialog2.setResizable(false);
/*      */     
/*  143 */     rw = (w - 440) / 2;
/*  144 */     rh = (h - 715) / 2;
/*  145 */     this.jDialog3.setLocation(rw, 10);
/*  146 */     this.jDialog3.setSize(440, 715);
/*  147 */     this.jDialog3.setVisible(false);
/*  148 */     this.jDialog3.setResizable(false);
/*      */     
/*  150 */     rw = (w - 345) / 2;
/*  151 */     rh = (h - 460) / 2;
/*  152 */     this.jDialog4.setLocation(rw, rh);
/*  153 */     this.jDialog4.setSize(345, 450);
/*  154 */     this.jDialog4.setVisible(false);
/*  155 */     this.jDialog4.setResizable(false);
/*      */     
/*  157 */     rw = (w - 340) / 2;
/*  158 */     rh = (h - 440) / 2;
/*  159 */     this.jDialog5.setLocation(rw, rh);
/*  160 */     this.jDialog5.setSize(340, 440);
/*  161 */     this.jDialog5.setVisible(false);
/*  162 */     this.jDialog5.setResizable(false);
/*      */     
/*  164 */     rw = (w - 360) / 2;
/*  165 */     rh = (h - 515) / 2;
/*  166 */     this.jDialog6.setLocation(rw, rh);
/*  167 */     this.jDialog6.setSize(360, 515);
/*  168 */     this.jDialog6.setVisible(false);
/*  169 */     this.jDialog6.setResizable(false);
/*      */     
/*  171 */     rw = (w - 390) / 2;
/*  172 */     rh = (h - 230) / 2;
/*  173 */     this.jDialog7.setLocation(rw, rh);
/*  174 */     this.jDialog7.setSize(390, 230);
/*  175 */     this.jDialog7.setVisible(false);
/*  176 */     this.jDialog7.setResizable(false);
/*      */     
/*  178 */     rw = (w - 300) / 2;
/*  179 */     rh = (h - 190) / 2;
/*  180 */     this.jDialog8.setLocation(rw, rh);
/*  181 */     this.jDialog8.setSize(300, 185);
/*  182 */     this.jDialog8.setVisible(false);
/*  183 */     this.jDialog8.setResizable(false);
/*      */     
/*  185 */     rw = (w - 430) / 2;
/*  186 */     rh = (h - 200) / 2;
/*  187 */     this.jDialog9.setLocation(rw, rh);
/*  188 */     this.jDialog9.setSize(430, 200);
/*  189 */     this.jDialog9.setVisible(false);
/*  190 */     this.jDialog9.setResizable(false);
/*      */     
/*  192 */     rw = (w - 420) / 2;
/*  193 */     rh = (h - 135) / 2;
/*  194 */     this.jDialog10.setLocation(rw, rh);
/*  195 */     this.jDialog10.setSize(420, 135);
/*  196 */     this.jDialog10.setVisible(false);
/*  197 */     this.jDialog10.setResizable(false);
/*      */     
/*  199 */     this.jDialog11.setLocationRelativeTo(null);
/*  200 */     this.jDialog11.setSize(300, 300);
/*      */     
/*  202 */     this.jDialog12.setLocationRelativeTo(null);
/*  203 */     this.jDialog12.setSize(300, 300);
/*      */     
/*  205 */     this.jDialog15.setLocationRelativeTo(null);
/*  206 */     this.jDialog15.setSize(300, 300);
/*      */     
/*  208 */     this.jDialog16.setLocationRelativeTo(null);
/*  209 */     this.jDialog16.setSize(300, 300);
/*      */     
/*  211 */     rw = (w - 420) / 2;
/*  212 */     rh = (h - 150) / 2;
/*  213 */     this.jDialog17.setLocation(rw, rh);
/*  214 */     this.jDialog17.setSize(370, 130);
/*  215 */     this.jDialog17.setVisible(false);
/*  216 */     this.jDialog17.setResizable(false);
/*      */     
/*  218 */     rw = (w - 420) / 2;
/*  219 */     rh = (h - 150) / 2;
/*  220 */     this.jDialog18.setLocation(rw, rh);
/*  221 */     this.jDialog18.setSize(350, 150);
/*  222 */     this.jDialog18.setVisible(false);
/*  223 */     this.jDialog18.setResizable(false);
/*      */     
/*  225 */     LocalDateTime ahora = LocalDateTime.now();
/*  226 */     int year = ahora.getYear();
/*  227 */     List<String> añitos = new ArrayList<>();
/*  228 */     for (int i = 2012; i <= year; i++) {
/*  229 */       añitos.add("" + i);
/*      */     }
/*  231 */     this.jSpinner1.setModel(new SpinnerListModel(añitos));
/*  232 */     this.jSpinner1.setValue("" + añoActual());
/*      */     
/*  234 */     this.rSTableMetro4.setModel(this.modelo);
/*  235 */     this.modelo.addColumn("Clave");
/*  236 */     this.modelo.addColumn("Nombre Completo");
/*  237 */     this.modelo.addColumn("Nombre Comercial");
/*  238 */     colorear();
/*  239 */     this.rSTableMetro4.setSelectionMode(0);
/*  240 */     this.rSTableMetro4.setAutoCreateRowSorter(true);
/*  241 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/*  242 */     this.rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(60);
/*  243 */     this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(60);
/*  244 */     this.buttonGroup1.add(this.jRadioButton5);
/*  245 */     this.buttonGroup1.add(this.jRadioButton9);
/*  246 */     this.buttonGroup1.add(this.jRadioButton10);
/*      */     
/*  248 */     this.buttonGroup2.add(this.jRadioButton3);
/*  249 */     this.buttonGroup2.add(this.jRadioButton4);
/*      */     
/*  251 */     this.buttonGroup3.add(this.jRadioButton1);
/*  252 */     this.buttonGroup3.add(this.jRadioButton2);
/*      */     
/*  254 */     this.buttonGroup4.add(this.jRadioButton6);
/*  255 */     this.buttonGroup4.add(this.jRadioButton7);
/*      */     
/*  257 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  258 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  259 */     editFormat.setGroupingUsed(false);
/*  260 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  261 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  262 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  263 */     enFormat.setAllowsInvalid(true);
/*  264 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  265 */     this.cantidad.setFormatterFactory(currFactory);
/*  266 */     this.auxiliar.setFormatterFactory(currFactory);
/*  267 */     this.jFormattedTextField2.setFormatterFactory(currFactory);
/*  268 */     this.jFormattedTextField3.setFormatterFactory(currFactory);
/*  269 */     this.jFormattedTextField4.setFormatterFactory(currFactory);
/*      */     
/*  271 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*  272 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*  273 */     this.cantidad.setValue(Integer.valueOf(0));
/*  274 */     this.auxiliar.setValue(Integer.valueOf(0));
/*  275 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*  276 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/*      */     
/*  278 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  279 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  280 */     this.jDialog1.setCursor(micursor);
/*  281 */     this.jDialog2.setCursor(micursor);
/*  282 */     this.jDialog3.setCursor(micursor);
/*  283 */     this.jDialog4.setCursor(micursor);
/*  284 */     this.jDialog5.setCursor(micursor);
/*  285 */     this.jDialog6.setCursor(micursor);
/*  286 */     this.jDialog7.setCursor(micursor);
/*  287 */     this.jDialog8.setCursor(micursor);
/*  288 */     this.jDialog9.setCursor(micursor);
/*  289 */     this.jDialog10.setCursor(micursor);
/*  290 */     this.jDialog17.setCursor(micursor);
/*      */     
/*  292 */     this.rSTableMetro1.setCursor(micursor);
/*  293 */     this.rSTableMetro3.setCursor(micursor);
/*  294 */     this.rSTableMetro4.setCursor(micursor);
/*  295 */     this.rSTableMetro5.setCursor(micursor);
/*  296 */     this.rSTableMetro6.setCursor(micursor);
/*  297 */     this.rSTableMetro7.setCursor(micursor);
/*      */     
/*  299 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  300 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  301 */     this.jLabel19.setCursor(micursor);
/*  302 */     this.jLabel32.setCursor(micursor);
/*      */     
/*  304 */     consultar();
/*      */     
/*  306 */     this.CONFIGURACIONES = new String[] { CAMPOSGENERALES.get("directiva").toString(), CAMPOSGENERALES.get("sucursal").toString() };
/*  307 */     this.DIRECTIVAS = this.CONFIGURACIONES[0];
/*  308 */     cargarFechaHoy();
/*      */     
/*  310 */     privilegios();
/*      */     
/*  312 */     String[] datos = this.con.regresaColIndex("distinct(moneda)", "facturas33", " order by moneda");
/*      */     
/*  314 */     this.jComboBox12.removeAllItems();
/*  315 */     this.jComboBox12.addItem("MONEDA");
/*  316 */     for (int j = 0; j < datos.length; j++) {
/*  317 */       this.jComboBox12.addItem(datos[j]);
/*      */     }
/*  319 */     this.jRadioButton6.setSelected(true);
/*      */   }
/*      */   private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JRadioButton jRadioButton1; private JRadioButton jRadioButton10; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButton jRadioButton5; private JRadioButton jRadioButton6; private JRadioButton jRadioButton7; private JRadioButton jRadioButton9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane12; private JScrollPane jScrollPane13; private JScrollPane jScrollPane14; private JScrollPane jScrollPane15; private JScrollPane jScrollPane16; private JScrollPane jScrollPane17; private JScrollPane jScrollPane18; private JScrollPane jScrollPane19; private JScrollPane jScrollPane2; private JScrollPane jScrollPane20; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JSeparator jSeparator1; private JSeparator jSeparator2; private JSeparator jSeparator29; private JSeparator jSeparator30; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator8; private JSpinner jSpinner1; private JTable jTable3; private JTable jTable7; private JTextArea jTextArea1; private JTextArea jTextArea2; private JTextArea jTextArea3; private JTextArea jTextArea5; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private MaterialButton materialButton17; private MaterialButton materialButton18; private MaterialButton materialButton19; private MaterialButton materialButton20; private MaterialButton materialButton21; private MaterialButton materialButton22; private MaterialButton materialButton23; private MaterialButton materialButton24; private MaterialButton materialButton36; private MaterialButton materialButton37; private MaterialButton materialButton38; private MaterialButton materialButton39; private MetroTextBox metroTextBox1; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro2; private RSTableMetro rSTableMetro3; private RSTableMetro rSTableMetro4; private RSTableMetro rSTableMetro5;
/*      */   private RSTableMetro rSTableMetro6;
/*      */   private RSTableMetro rSTableMetro7;
/*      */   
/*      */   private void initComponents() {
/*  326 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  327 */     this.jPanel9 = new JPanel();
/*  328 */     this.jButton11 = new JButton();
/*  329 */     this.jButton12 = new JButton();
/*  330 */     this.jButton13 = new JButton();
/*  331 */     this.jButton14 = new JButton();
/*  332 */     this.jButton15 = new JButton();
/*  333 */     this.jLabel78 = new JLabel();
/*  334 */     this.jLabel79 = new JLabel();
/*  335 */     this.jButton16 = new JButton();
/*  336 */     this.jLabel17 = new JLabel();
/*  337 */     this.jTextField3 = new JTextField();
/*  338 */     this.jLabel18 = new JLabel();
/*  339 */     this.jTextField4 = new JTextField();
/*  340 */     this.jScrollPane14 = new JScrollPane();
/*  341 */     this.rSTableMetro3 = new RSTableMetro();
/*  342 */     this.jScrollPane15 = new JScrollPane();
/*  343 */     this.rSTableMetro4 = new RSTableMetro();
/*  344 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  345 */     this.jPanel25 = new JPanel();
/*  346 */     this.jLabel62 = new JLabel();
/*  347 */     this.jScrollPane1 = new JScrollPane();
/*  348 */     this.jPanel26 = new JPanel();
/*  349 */     this.jScrollPane16 = new JScrollPane();
/*  350 */     this.rSTableMetro5 = new RSTableMetro();
/*  351 */     this.jPanel27 = new JPanel();
/*  352 */     this.jButton20 = new JButton();
/*  353 */     this.jTextField2 = new JTextField();
/*  354 */     this.jLabel56 = new JLabel();
/*  355 */     this.jButton23 = new JButton();
/*  356 */     this.jButton22 = new JButton();
/*  357 */     this.jPanel1 = new JPanel();
/*  358 */     this.jPanel23 = new JPanel();
/*  359 */     this.jLabel44 = new JLabel();
/*  360 */     this.jDateChooser7 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  361 */     this.jLabel45 = new JLabel();
/*  362 */     this.jDateChooser8 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  363 */     this.jLabel46 = new JLabel();
/*  364 */     this.jComboBox4 = new JComboBox();
/*  365 */     this.jLabel47 = new JLabel();
/*  366 */     this.jComboBox5 = new JComboBox();
/*  367 */     this.jLabel50 = new JLabel();
/*  368 */     this.jComboBox6 = new JComboBox();
/*  369 */     this.jButton8 = new JButton();
/*  370 */     this.jPanel24 = new JPanel();
/*  371 */     this.jButton17 = new JButton();
/*  372 */     this.jLabel51 = new JLabel();
/*  373 */     this.jLabel52 = new JLabel();
/*  374 */     this.jButton5 = new JButton();
/*  375 */     this.jLabel53 = new JLabel();
/*  376 */     this.jButton6 = new JButton();
/*  377 */     this.jLabel54 = new JLabel();
/*  378 */     this.jButton7 = new JButton();
/*  379 */     this.jLabel55 = new JLabel();
/*  380 */     this.jButton19 = new JButton();
/*  381 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  382 */     this.jPanel21 = new JPanel();
/*  383 */     this.jPanel28 = new JPanel();
/*  384 */     this.jLabel86 = new JLabel();
/*  385 */     this.jTextField14 = new JTextField();
/*  386 */     this.jLabel81 = new JLabel();
/*  387 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  388 */     this.jPanel2 = new JPanel();
/*  389 */     this.jLabel90 = new JLabel();
/*  390 */     this.jTextField13 = new JTextField();
/*  391 */     this.jButton26 = new JButton();
/*  392 */     this.jPanel3 = new JPanel();
/*  393 */     this.jRadioButton5 = new JRadioButton();
/*  394 */     this.jRadioButton9 = new JRadioButton();
/*  395 */     this.jTextField12 = new JTextField();
/*  396 */     this.jRadioButton10 = new JRadioButton();
/*  397 */     this.jPanel8 = new JPanel();
/*  398 */     this.jPanel32 = new JPanel();
/*  399 */     this.jLabel87 = new JLabel();
/*  400 */     this.jLabel89 = new JLabel();
/*  401 */     this.jLabel88 = new JLabel();
/*  402 */     this.jTextField16 = new JTextField();
/*  403 */     this.jTextField17 = new JTextField();
/*  404 */     this.jTextField15 = new JTextField();
/*  405 */     this.jPanel33 = new JPanel();
/*  406 */     this.jLabel84 = new JLabel();
/*  407 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  408 */     this.jPanel34 = new JPanel();
/*  409 */     this.jLabel2 = new JLabel();
/*  410 */     this.jTextField11 = new JTextField();
/*  411 */     this.jLabel57 = new JLabel();
/*  412 */     this.jScrollPane17 = new JScrollPane();
/*  413 */     this.rSTableMetro6 = new RSTableMetro();
/*  414 */     this.jPanel35 = new JPanel();
/*  415 */     this.jPanel37 = new JPanel();
/*  416 */     this.jButton1 = new JButton();
/*  417 */     this.jButton3 = new JButton();
/*  418 */     this.jButton25 = new JButton();
/*  419 */     this.jScrollPane19 = new JScrollPane();
/*  420 */     this.rSTableMetro7 = new RSTableMetro();
/*  421 */     this.jPanel36 = new JPanel();
/*  422 */     this.jPanel38 = new JPanel();
/*  423 */     this.jLabel38 = new JLabel();
/*  424 */     this.jLabel39 = new JLabel();
/*  425 */     this.jLabel36 = new JLabel();
/*  426 */     this.jLabel37 = new JLabel();
/*  427 */     this.jPanel39 = new JPanel();
/*  428 */     this.jPanel40 = new JPanel();
/*  429 */     this.jPanel41 = new JPanel();
/*  430 */     this.materialButton37 = new MaterialButton();
/*  431 */     this.materialButton38 = new MaterialButton();
/*  432 */     this.buttonGroup1 = new ButtonGroup();
/*  433 */     this.cantidad = new JFormattedTextField();
/*  434 */     this.auxiliar = new JFormattedTextField();
/*  435 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  436 */     this.jPanel7 = new JPanel();
/*  437 */     this.jPanel10 = new JPanel();
/*  438 */     this.jLabel4 = new JLabel();
/*  439 */     this.jTextField5 = new JTextField();
/*  440 */     this.jLabel5 = new JLabel();
/*  441 */     this.jTextField6 = new JTextField();
/*  442 */     this.jSeparator2 = new JSeparator();
/*  443 */     this.jPanel5 = new JPanel();
/*  444 */     this.jLabel6 = new JLabel();
/*  445 */     this.jLabel7 = new JLabel();
/*  446 */     this.jLabel8 = new JLabel();
/*  447 */     this.jLabel9 = new JLabel();
/*  448 */     this.jLabel10 = new JLabel();
/*  449 */     this.jLabel11 = new JLabel();
/*  450 */     this.jLabel12 = new JLabel();
/*  451 */     this.jLabel13 = new JLabel();
/*  452 */     this.jPanel11 = new JPanel();
/*  453 */     this.jLabel14 = new JLabel();
/*  454 */     this.jScrollPane9 = new JScrollPane();
/*  455 */     this.jTable7 = new JTable();
/*  456 */     this.jLabel16 = new JLabel();
/*  457 */     this.jLabel19 = new JLabel();
/*  458 */     this.materialButton36 = new MaterialButton();
/*  459 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  460 */     this.jPanel12 = new JPanel();
/*  461 */     this.jPanel14 = new JPanel();
/*  462 */     this.jLabel20 = new JLabel();
/*  463 */     this.jTextField7 = new JTextField();
/*  464 */     this.jLabel21 = new JLabel();
/*  465 */     this.jTextField8 = new JTextField();
/*  466 */     this.jSeparator5 = new JSeparator();
/*  467 */     this.jPanel15 = new JPanel();
/*  468 */     this.jPanel17 = new JPanel();
/*  469 */     this.jLabel23 = new JLabel();
/*  470 */     this.jLabel22 = new JLabel();
/*  471 */     this.jLabel33 = new JLabel();
/*  472 */     this.jLabel34 = new JLabel();
/*  473 */     this.jPanel18 = new JPanel();
/*  474 */     this.jLabel24 = new JLabel();
/*  475 */     this.jLabel25 = new JLabel();
/*  476 */     this.jPanel4 = new JPanel();
/*  477 */     this.jLabel28 = new JLabel();
/*  478 */     this.jLabel29 = new JLabel();
/*  479 */     this.jLabel26 = new JLabel();
/*  480 */     this.jLabel27 = new JLabel();
/*  481 */     this.jPanel16 = new JPanel();
/*  482 */     this.jLabel30 = new JLabel();
/*  483 */     this.jScrollPane10 = new JScrollPane();
/*  484 */     this.jTextArea1 = new JTextArea();
/*  485 */     this.jLabel31 = new JLabel();
/*  486 */     this.jLabel32 = new JLabel();
/*  487 */     this.materialButton39 = new MaterialButton();
/*  488 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  489 */     this.jPanel19 = new JPanel();
/*  490 */     this.jLabel71 = new JLabel();
/*  491 */     this.jSeparator6 = new JSeparator();
/*  492 */     this.jLabel73 = new JLabel();
/*  493 */     this.jTextField9 = new JTextField();
/*  494 */     this.jButton21 = new JButton();
/*  495 */     this.jLabel74 = new JLabel();
/*  496 */     this.jLabel35 = new JLabel();
/*  497 */     this.jPanel20 = new JPanel();
/*  498 */     this.jRadioButton3 = new JRadioButton();
/*  499 */     this.jRadioButton4 = new JRadioButton();
/*  500 */     this.jTextField10 = new JTextField();
/*  501 */     this.jLabel75 = new JLabel();
/*  502 */     this.jTextField18 = new JTextField();
/*  503 */     this.jLabel76 = new JLabel();
/*  504 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  505 */     this.jLabel77 = new JLabel();
/*  506 */     this.jScrollPane11 = new JScrollPane();
/*  507 */     this.jTextArea2 = new JTextArea();
/*  508 */     this.jButton24 = new JButton();
/*  509 */     this.jLabel80 = new JLabel();
/*  510 */     this.jTextField19 = new JTextField();
/*  511 */     this.buttonGroup2 = new ButtonGroup();
/*  512 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  513 */     this.jPanel29 = new JPanel();
/*  514 */     this.jLabel124 = new JLabel();
/*  515 */     this.jSeparator29 = new JSeparator();
/*  516 */     this.jLabel125 = new JLabel();
/*  517 */     this.jButton44 = new JButton();
/*  518 */     this.jButton45 = new JButton();
/*  519 */     this.jScrollPane18 = new JScrollPane();
/*  520 */     this.jTextArea5 = new JTextArea();
/*  521 */     this.jLabel126 = new JLabel();
/*  522 */     this.jDialog8 = new CerrarVentana(this.padre);
/*  523 */     this.jPanel30 = new JPanel();
/*  524 */     this.jLabel127 = new JLabel();
/*  525 */     this.jSeparator30 = new JSeparator();
/*  526 */     this.jLabel128 = new JLabel();
/*  527 */     this.jButton47 = new JButton();
/*  528 */     this.jLabel129 = new JLabel();
/*  529 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  530 */     this.jSeparator8 = new JSeparator();
/*  531 */     this.jButton48 = new JButton();
/*  532 */     this.jPanel22 = new JPanel();
/*  533 */     this.jScrollPane7 = new JScrollPane();
/*  534 */     this.jTextArea3 = new JTextArea();
/*  535 */     this.jLabel40 = new JLabel();
/*  536 */     this.jLabel41 = new JLabel();
/*  537 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  538 */     this.jDialog9 = new CerrarVentana(this.padre);
/*  539 */     this.jPanel31 = new JPanel();
/*  540 */     this.jRadioButton1 = new JRadioButton();
/*  541 */     this.jRadioButton2 = new JRadioButton();
/*  542 */     this.jLabel85 = new JLabel();
/*  543 */     this.jLabel94 = new JLabel();
/*  544 */     this.jDateChooser1 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  545 */     this.jLabel42 = new JLabel();
/*  546 */     this.materialButton21 = new MaterialButton();
/*  547 */     this.materialButton19 = new MaterialButton();
/*  548 */     this.buttonGroup3 = new ButtonGroup();
/*  549 */     this.jPanel6 = new JPanel();
/*  550 */     this.jSeparator1 = new JSeparator();
/*  551 */     this.jScrollPane20 = new JScrollPane();
/*  552 */     this.rSTableMetro2 = new RSTableMetro();
/*  553 */     this.jDialog10 = new CerrarVentana(this.padre);
/*  554 */     this.jLabel1 = new JLabel();
/*  555 */     this.jDateChooser9 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  556 */     this.materialButton18 = new MaterialButton();
/*  557 */     this.materialButton17 = new MaterialButton();
/*  558 */     this.jDialog11 = new JDialog();
/*  559 */     this.jScrollPane2 = new JScrollPane();
/*  560 */     this.TablaGral = new JTable();
/*  561 */     this.jLabel59 = new JLabel();
/*  562 */     this.jLabel61 = new JLabel();
/*  563 */     this.jDialog12 = new JDialog();
/*  564 */     this.jScrollPane3 = new JScrollPane();
/*  565 */     this.TablaGral1 = new JTable();
/*  566 */     this.jLabel60 = new JLabel();
/*  567 */     this.jLabel63 = new JLabel();
/*  568 */     this.jDialog13 = new JDialog();
/*  569 */     this.jScrollPane4 = new JScrollPane();
/*  570 */     this.TablaGral2 = new JTable();
/*  571 */     this.jLabel64 = new JLabel();
/*  572 */     this.jLabel65 = new JLabel();
/*  573 */     this.jDialog14 = new JDialog();
/*  574 */     this.jScrollPane5 = new JScrollPane();
/*  575 */     this.TablaGral3 = new JTable();
/*  576 */     this.jLabel66 = new JLabel();
/*  577 */     this.jLabel67 = new JLabel();
/*  578 */     this.jDialog15 = new JDialog();
/*  579 */     this.jScrollPane6 = new JScrollPane();
/*  580 */     this.TablaAux = new JTable();
/*  581 */     this.jLabel68 = new JLabel();
/*  582 */     this.jLabel69 = new JLabel();
/*  583 */     this.jLabel72 = new JLabel();
/*  584 */     this.jLabel82 = new JLabel();
/*  585 */     this.jLabel83 = new JLabel();
/*  586 */     this.jDialog16 = new JDialog();
/*  587 */     this.jScrollPane8 = new JScrollPane();
/*  588 */     this.TablaAux1 = new JTable();
/*  589 */     this.jLabel91 = new JLabel();
/*  590 */     this.jPanel48 = new JPanel();
/*  591 */     this.jLabel92 = new JLabel();
/*  592 */     this.jLabel93 = new JLabel();
/*  593 */     this.jLabel95 = new JLabel();
/*  594 */     this.jLabel96 = new JLabel();
/*  595 */     this.jLabel97 = new JLabel();
/*  596 */     this.jLabel98 = new JLabel();
/*  597 */     this.jDialog17 = new CerrarVentana(this.padre);
/*  598 */     this.materialButton22 = new MaterialButton();
/*  599 */     this.materialButton20 = new MaterialButton();
/*  600 */     this.jPanel49 = new JPanel();
/*  601 */     this.jRadioButton6 = new JRadioButton();
/*  602 */     this.jRadioButton7 = new JRadioButton();
/*  603 */     this.buttonGroup4 = new ButtonGroup();
/*  604 */     this.jLabel43 = new JLabel();
/*  605 */     this.jComboBox12 = new JComboBox();
/*  606 */     this.jDialog18 = new CerrarVentana(this.padre);
/*  607 */     this.materialButton23 = new MaterialButton();
/*  608 */     this.materialButton24 = new MaterialButton();
/*  609 */     this.jPanel50 = new JPanel();
/*  610 */     this.jLabel99 = new JLabel();
/*  611 */     this.jComboBox2 = new JComboBox<>();
/*  612 */     this.jLabel100 = new JLabel();
/*  613 */     this.jSpinner1 = new JSpinner();
/*  614 */     this.jDialog19 = new CerrarVentana(this.padre);
/*  615 */     this.jLabel101 = new JLabel();
/*  616 */     this.jScrollPane12 = new JScrollPane();
/*  617 */     this.jTable3 = new JTable();
/*  618 */     this.jLabel102 = new JLabel();
/*  619 */     this.jLabel103 = new JLabel();
/*  620 */     this.jLabel104 = new JLabel();
/*  621 */     this.jLabel105 = new JLabel();
/*  622 */     this.jPanel51 = new JPanel();
/*  623 */     this.jPanel52 = new JPanel();
/*  624 */     this.jPanel13 = new JPanel();
/*  625 */     this.jPanel42 = new JPanel();
/*  626 */     this.jLabel3 = new JLabel();
/*  627 */     this.jLabel15 = new JLabel();
/*  628 */     this.jPanel44 = new JPanel();
/*  629 */     this.jPanel43 = new JPanel();
/*  630 */     this.jPanel45 = new JPanel();
/*  631 */     this.jLabel49 = new JLabel();
/*  632 */     this.jPanel46 = new JPanel();
/*  633 */     this.jButton2 = new JButton();
/*  634 */     this.jButton10 = new JButton();
/*  635 */     this.jButton9 = new JButton();
/*  636 */     this.jButton4 = new JButton();
/*  637 */     this.jPanel47 = new JPanel();
/*  638 */     this.jLabel58 = new JLabel();
/*  639 */     this.jLabel48 = new JLabel();
/*  640 */     this.jScrollPane13 = new JScrollPane();
/*  641 */     this.rSTableMetro1 = new RSTableMetro();
/*  642 */     this.jLabel70 = new JLabel();
/*  643 */     this.metroTextBox1 = new MetroTextBox();
/*  644 */     this.jComboBox1 = new JComboBox<>();
/*      */     
/*  646 */     this.jDialog1.setTitle("Administrar Tarjetas de Deudor");
/*  647 */     this.jDialog1.setModal(true);
/*      */     
/*  649 */     this.jButton11.setText(">>");
/*  650 */     this.jButton11.setToolTipText("Mover Todos");
/*  651 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  653 */             TarjetaCliente.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  657 */     this.jButton12.setText(">");
/*  658 */     this.jButton12.setToolTipText("Mover Seleccionado");
/*  659 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  661 */             TarjetaCliente.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  665 */     this.jButton13.setText("<");
/*  666 */     this.jButton13.setToolTipText("Quitar Seleccionado");
/*  667 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  669 */             TarjetaCliente.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  673 */     this.jButton14.setText("<<");
/*  674 */     this.jButton14.setToolTipText("Quitar Todos");
/*  675 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  677 */             TarjetaCliente.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  681 */     this.jButton15.setMnemonic('C');
/*  682 */     this.jButton15.setText("Cerrar");
/*  683 */     this.jButton15.setToolTipText("Cerrar Ventana (Alt+C)");
/*  684 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  686 */             TarjetaCliente.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  690 */     this.jLabel78.setFont(new Font("Cantarell", 0, 11));
/*  691 */     this.jLabel78.setForeground(Color.darkGray);
/*  692 */     this.jLabel78.setHorizontalAlignment(0);
/*  693 */     this.jLabel78.setText("Lista de Clientes");
/*  694 */     this.jLabel78.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  696 */     this.jLabel79.setFont(new Font("Cantarell", 0, 11));
/*  697 */     this.jLabel79.setForeground(Color.darkGray);
/*  698 */     this.jLabel79.setHorizontalAlignment(0);
/*  699 */     this.jLabel79.setText("Crear Nueva Tarjeta Deudor");
/*  700 */     this.jLabel79.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/*  702 */     this.jButton16.setMnemonic('G');
/*  703 */     this.jButton16.setText("Guardar");
/*  704 */     this.jButton16.setToolTipText("Guardar Tarjetas(Alt+G)");
/*  705 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  707 */             TarjetaCliente.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  711 */     this.jLabel17.setFont(new Font("Cantarell", 0, 11));
/*  712 */     this.jLabel17.setHorizontalAlignment(4);
/*  713 */     this.jLabel17.setText("Clave");
/*      */     
/*  715 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  717 */             TarjetaCliente.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  721 */     this.jLabel18.setFont(new Font("Cantarell", 0, 11));
/*  722 */     this.jLabel18.setHorizontalAlignment(4);
/*  723 */     this.jLabel18.setText("Nombre Corto");
/*      */     
/*  725 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  727 */             TarjetaCliente.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  731 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  739 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  744 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  747 */     this.rSTableMetro3.setAltoHead(25);
/*  748 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  749 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/*  750 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/*  751 */     this.rSTableMetro3.setColorFilasBackgound2(this.lc.FONDOTABLA);
/*  752 */     this.rSTableMetro3.setColorFilasForeground1(this.lc.SECUNDARIO1);
/*  753 */     this.rSTableMetro3.setColorFilasForeground2(this.lc.SECUNDARIO1);
/*  754 */     this.rSTableMetro3.setColorSelBackgound(this.lc.PRIMARIO2);
/*  755 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 10));
/*  756 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 10));
/*  757 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/*  758 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/*  759 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/*  760 */     this.rSTableMetro3.setRowHeight(18);
/*  761 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/*  762 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/*  763 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*  764 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  766 */             TarjetaCliente.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/*  769 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  771 */             TarjetaCliente.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/*  774 */     this.jScrollPane14.setViewportView((Component)this.rSTableMetro3);
/*      */     
/*  776 */     this.rSTableMetro4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  784 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  789 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  792 */     this.rSTableMetro4.setAltoHead(25);
/*  793 */     this.rSTableMetro4.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  794 */     this.rSTableMetro4.setColorBordeFilas(new Color(200, 200, 200));
/*  795 */     this.rSTableMetro4.setColorBordeHead(this.lc.PRIMARIO1);
/*  796 */     this.rSTableMetro4.setColorFilasBackgound2(this.lc.FONDOTABLA);
/*  797 */     this.rSTableMetro4.setColorFilasForeground1(this.lc.SECUNDARIO1);
/*  798 */     this.rSTableMetro4.setColorFilasForeground2(this.lc.SECUNDARIO1);
/*  799 */     this.rSTableMetro4.setColorSelBackgound(this.lc.PRIMARIO2);
/*  800 */     this.rSTableMetro4.setFont(new Font("Cantarell", 0, 10));
/*  801 */     this.rSTableMetro4.setFuenteFilas(new Font("Cantarell", 0, 10));
/*  802 */     this.rSTableMetro4.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/*  803 */     this.rSTableMetro4.setFuenteHead(new Font("Cantarell", 1, 12));
/*  804 */     this.rSTableMetro4.setGrosorBordeFilas(0);
/*  805 */     this.rSTableMetro4.setRowHeight(18);
/*  806 */     this.rSTableMetro4.setSelectionBackground(new Color(237, 107, 107));
/*  807 */     this.rSTableMetro4.getTableHeader().setResizingAllowed(false);
/*  808 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/*  809 */     this.rSTableMetro4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  811 */             TarjetaCliente.this.rSTableMetro4MouseClicked(evt);
/*      */           }
/*      */         });
/*  814 */     this.rSTableMetro4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  816 */             TarjetaCliente.this.rSTableMetro4KeyReleased(evt);
/*      */           }
/*      */         });
/*  819 */     this.jScrollPane15.setViewportView((Component)this.rSTableMetro4);
/*      */     
/*  821 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  822 */     this.jPanel9.setLayout(jPanel9Layout);
/*  823 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  824 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  825 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  826 */           .addContainerGap()
/*  827 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  828 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  829 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  830 */                 .addGroup(jPanel9Layout.createSequentialGroup()
/*  831 */                   .addComponent(this.jLabel17, -2, 44, -2)
/*  832 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  833 */                   .addComponent(this.jTextField3, -2, 55, -2)
/*  834 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  835 */                   .addComponent(this.jLabel18, -2, 80, -2)
/*  836 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  837 */                   .addComponent(this.jTextField4, -1, 144, 32767))
/*  838 */                 .addComponent(this.jScrollPane14, -2, 0, 32767))
/*  839 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  840 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  841 */                 .addComponent(this.jButton16, -2, 87, -2)
/*  842 */                 .addComponent(this.jButton15, -2, 87, -2)
/*  843 */                 .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  844 */                   .addComponent(this.jButton11, -2, 87, -2)
/*  845 */                   .addComponent(this.jButton14, -2, 87, -2)
/*  846 */                   .addComponent(this.jButton13, -2, 87, -2)
/*  847 */                   .addComponent(this.jButton12, -2, 87, -2)))
/*  848 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
/*  849 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  850 */               .addComponent(this.jLabel78, -1, 344, 32767)
/*  851 */               .addGap(108, 108, 108)))
/*  852 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  853 */             .addComponent(this.jLabel79, -1, -1, 32767)
/*  854 */             .addComponent(this.jScrollPane15, -1, 351, 32767))
/*  855 */           .addContainerGap()));
/*      */     
/*  857 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  858 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  859 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  860 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  861 */             .addComponent(this.jLabel17)
/*  862 */             .addComponent(this.jTextField3, -2, -1, -2)
/*  863 */             .addComponent(this.jLabel18)
/*  864 */             .addComponent(this.jTextField4, -2, -1, -2))
/*  865 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  866 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  867 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  868 */               .addComponent(this.jButton11)
/*  869 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  870 */               .addComponent(this.jButton12)
/*  871 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  872 */               .addComponent(this.jButton13)
/*  873 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  874 */               .addComponent(this.jButton14)
/*  875 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, 32767)
/*  876 */               .addComponent(this.jButton16)
/*  877 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  878 */               .addComponent(this.jButton15))
/*  879 */             .addComponent(this.jScrollPane14, -2, 0, 32767)
/*  880 */             .addComponent(this.jScrollPane15, -2, 0, 32767))
/*  881 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  882 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  883 */             .addComponent(this.jLabel79)
/*  884 */             .addComponent(this.jLabel78))
/*  885 */           .addContainerGap()));
/*      */ 
/*      */     
/*  888 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  889 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  890 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  891 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  892 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/*  894 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  895 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  896 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */ 
/*      */     
/*  899 */     this.jDialog2.setTitle("Administrar Tarjetas de Deudor");
/*  900 */     this.jDialog2.setModal(true);
/*      */     
/*  902 */     this.jLabel62.setFont(new Font("Cantarell", 1, 22));
/*  903 */     this.jLabel62.setForeground(this.lc.PRIMARIO1);
/*  904 */     this.jLabel62.setHorizontalAlignment(0);
/*  905 */     this.jLabel62.setText("Tarjeta de ");
/*      */     
/*  907 */     this.jScrollPane1.setHorizontalScrollBarPolicy(32);
/*      */     
/*  909 */     this.rSTableMetro5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  917 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  922 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  925 */     this.rSTableMetro5.setAltoHead(25);
/*  926 */     this.rSTableMetro5.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  927 */     this.rSTableMetro5.setColorBordeFilas(this.lc.REJILLATABLA);
/*  928 */     this.rSTableMetro5.setColorBordeHead(this.lc.PRIMARIO1);
/*  929 */     this.rSTableMetro5.setColorFilasBackgound2(new Color(239, 239, 239));
/*  930 */     this.rSTableMetro5.setColorFilasForeground1(new Color(102, 102, 102));
/*  931 */     this.rSTableMetro5.setColorFilasForeground2(new Color(102, 102, 102));
/*  932 */     this.rSTableMetro5.setColorSelBackgound(new Color(237, 107, 107));
/*  933 */     this.rSTableMetro5.setFont(new Font("Cantarell", 0, 10));
/*  934 */     this.rSTableMetro5.setFuenteFilas(new Font("Cantarell", 0, 10));
/*  935 */     this.rSTableMetro5.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/*  936 */     this.rSTableMetro5.setFuenteHead(new Font("Cantarell", 1, 12));
/*  937 */     this.rSTableMetro5.setGridColor(this.lc.FONDOTABLA);
/*  938 */     this.rSTableMetro5.setRowHeight(18);
/*  939 */     this.rSTableMetro5.setSelectionBackground(this.lc.PRIMARIO2);
/*  940 */     this.rSTableMetro5.getTableHeader().setResizingAllowed(false);
/*  941 */     this.rSTableMetro5.getTableHeader().setReorderingAllowed(false);
/*  942 */     this.rSTableMetro5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  944 */             TarjetaCliente.this.rSTableMetro5MouseClicked(evt);
/*      */           }
/*      */         });
/*  947 */     this.rSTableMetro5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  949 */             TarjetaCliente.this.rSTableMetro5KeyReleased(evt);
/*      */           }
/*      */         });
/*  952 */     this.jScrollPane16.setViewportView((Component)this.rSTableMetro5);
/*      */     
/*  954 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/*  955 */     this.jPanel26.setLayout(jPanel26Layout);
/*  956 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/*  957 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  958 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  959 */           .addComponent(this.jScrollPane16, -2, 1800, -2)
/*  960 */           .addGap(0, 0, 32767)));
/*      */     
/*  962 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/*  963 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  964 */         .addComponent(this.jScrollPane16, GroupLayout.Alignment.TRAILING, -1, 191, 32767));
/*      */ 
/*      */     
/*  967 */     this.jScrollPane1.setViewportView(this.jPanel26);
/*      */     
/*  969 */     this.jButton20.setMnemonic('C');
/*  970 */     this.jButton20.setText("Cerrar");
/*  971 */     this.jButton20.setToolTipText("Cerrar (Alt+C)");
/*  972 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  974 */             TarjetaCliente.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  978 */     this.jTextField2.setEditable(false);
/*  979 */     this.jTextField2.setFont(new Font("Cantarell", 1, 13));
/*  980 */     this.jTextField2.setForeground(this.lc.PRIMARIO1);
/*  981 */     this.jTextField2.setHorizontalAlignment(4);
/*  982 */     this.jTextField2.setText("$ 10000.00");
/*  983 */     this.jTextField2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  985 */             TarjetaCliente.this.jTextField2MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  989 */     this.jLabel56.setFont(new Font("Cantarell", 0, 11));
/*  990 */     this.jLabel56.setForeground(this.lc.PRIMARIO1);
/*  991 */     this.jLabel56.setText("jLabel56");
/*      */     
/*  993 */     this.jButton23.setMnemonic('C');
/*  994 */     this.jButton23.setText("Abonar cancela");
/*  995 */     this.jButton23.setToolTipText("Cerrar (Alt+C)");
/*  996 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  998 */             TarjetaCliente.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1002 */     this.jButton22.setMnemonic('C');
/* 1003 */     this.jButton22.setText("insertar");
/* 1004 */     this.jButton22.setToolTipText("Cerrar (Alt+C)");
/* 1005 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1007 */             TarjetaCliente.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1011 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/* 1012 */     this.jPanel27.setLayout(jPanel27Layout);
/* 1013 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/* 1014 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1015 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
/* 1016 */           .addComponent(this.jLabel56, -1, -1, 32767)
/* 1017 */           .addGap(49, 49, 49)
/* 1018 */           .addComponent(this.jButton23, -2, 162, -2)
/* 1019 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1020 */           .addComponent(this.jButton22, -2, 162, -2)
/* 1021 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1022 */           .addComponent(this.jTextField2, -2, 162, -2)
/* 1023 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1024 */           .addComponent(this.jButton20, -2, 89, -2)
/* 1025 */           .addContainerGap()));
/*      */     
/* 1027 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/* 1028 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1029 */         .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1030 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1031 */             .addComponent(this.jButton22, -1, -1, 32767)
/* 1032 */             .addComponent(this.jButton23))
/* 1033 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1034 */             .addComponent(this.jButton20, -1, -1, 32767)
/* 1035 */             .addComponent(this.jTextField2, -2, -1, -2)
/* 1036 */             .addComponent(this.jLabel56))));
/*      */ 
/*      */     
/* 1039 */     this.jPanel1.setLayout(new GridLayout(1, 2, 20, 0));
/*      */     
/* 1041 */     this.jPanel23.setBorder(BorderFactory.createTitledBorder("Búsqueda"));
/*      */     
/* 1043 */     this.jLabel44.setFont(new Font("Cantarell", 0, 11));
/* 1044 */     this.jLabel44.setText("Fecha:");
/*      */     
/* 1046 */     this.jDateChooser7.setDate(this.fechaActual);
/* 1047 */     this.jDateChooser7.setDateFormatString("dd/MM/yyyy");
/* 1048 */     this.jDateChooser7.setIcon(this.icon);
/* 1049 */     this.jDateChooser7.setMaxSelectableDate(this.fecha);
/* 1050 */     this.jDateChooser7.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1052 */     this.jLabel45.setFont(new Font("Cantarell", 0, 11));
/* 1053 */     this.jLabel45.setText("Hasta");
/*      */     
/* 1055 */     this.jDateChooser8.setDate(this.fechaActual);
/* 1056 */     this.jDateChooser8.setDateFormatString("dd/MM/yyyy");
/* 1057 */     this.jDateChooser8.setIcon(this.icon);
/* 1058 */     this.jDateChooser8.setMaxSelectableDate(this.fecha);
/* 1059 */     this.jDateChooser8.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1061 */     this.jLabel46.setFont(new Font("Cantarell", 0, 11));
/* 1062 */     this.jLabel46.setText("Concepto");
/*      */     
/* 1064 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 1065 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "CARGO", "ABONO" }));
/* 1066 */     this.jComboBox4.setToolTipText("Enter para establecer la consulta");
/* 1067 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1069 */             TarjetaCliente.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1073 */     this.jLabel47.setFont(new Font("Cantarell", 0, 11));
/* 1074 */     this.jLabel47.setText("Referencia");
/*      */     
/* 1076 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 1077 */     this.jComboBox5.setEditable(true);
/* 1078 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS" }));
/* 1079 */     this.jComboBox5.setToolTipText("Enter para establecer la consulta");
/* 1080 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1082 */             TarjetaCliente.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1086 */     this.jLabel50.setFont(new Font("Cantarell", 0, 11));
/* 1087 */     this.jLabel50.setText("Estatus:");
/*      */     
/* 1089 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 1090 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "<Por Pagar>", "<Pagada>", "<Abonada>", "<Cancelada>" }));
/* 1091 */     this.jComboBox6.setToolTipText("Enter para establecer la consulta");
/* 1092 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1094 */             TarjetaCliente.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1098 */     this.jButton8.setText("Buscar");
/* 1099 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1101 */             TarjetaCliente.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1105 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/* 1106 */     this.jPanel23.setLayout(jPanel23Layout);
/* 1107 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/* 1108 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1109 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 1110 */           .addContainerGap()
/* 1111 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1112 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 1113 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1114 */                 .addComponent(this.jLabel44, -2, 63, -2)
/* 1115 */                 .addComponent(this.jLabel46, -2, 65, -2))
/* 1116 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1117 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1118 */                 .addGroup(jPanel23Layout.createSequentialGroup()
/* 1119 */                   .addComponent((Component)this.jDateChooser7, -2, 97, -2)
/* 1120 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1121 */                   .addComponent(this.jLabel45)
/* 1122 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1123 */                   .addComponent((Component)this.jDateChooser8, -2, 97, -2))
/* 1124 */                 .addComponent(this.jComboBox4, -2, 133, -2)))
/* 1125 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 1126 */               .addComponent(this.jLabel50, -2, 65, -2)
/* 1127 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1128 */               .addComponent(this.jComboBox6, -2, 133, -2))
/* 1129 */             .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1130 */               .addComponent(this.jButton8, -2, 91, -2)
/* 1131 */               .addGroup(jPanel23Layout.createSequentialGroup()
/* 1132 */                 .addComponent(this.jLabel47, -2, 66, -2)
/* 1133 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1134 */                 .addComponent(this.jComboBox5, -2, 133, -2))))
/* 1135 */           .addContainerGap(74, 32767)));
/*      */     
/* 1137 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/* 1138 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1139 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 1140 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1141 */             .addComponent(this.jLabel44, -2, 23, -2)
/* 1142 */             .addComponent((Component)this.jDateChooser7, -1, -1, 32767)
/* 1143 */             .addComponent((Component)this.jDateChooser8, -1, -1, 32767)
/* 1144 */             .addComponent(this.jLabel45, -1, -1, 32767))
/* 1145 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1146 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1147 */             .addComponent(this.jLabel46, -1, -1, 32767)
/* 1148 */             .addComponent(this.jComboBox4, -2, -1, -2))
/* 1149 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1150 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1151 */             .addComponent(this.jLabel50, -1, -1, 32767)
/* 1152 */             .addComponent(this.jComboBox6, -2, -1, -2))
/* 1153 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1154 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1155 */             .addComponent(this.jLabel47, -1, -1, 32767)
/* 1156 */             .addComponent(this.jComboBox5, -2, -1, -2))
/* 1157 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1158 */           .addComponent(this.jButton8)
/* 1159 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1162 */     this.jPanel1.add(this.jPanel23);
/*      */     
/* 1164 */     this.jPanel24.setBorder(BorderFactory.createTitledBorder("Administración"));
/*      */     
/* 1166 */     this.jButton17.setMnemonic('G');
/* 1167 */     this.jButton17.setText("Guardar");
/* 1168 */     this.jButton17.setToolTipText("Guardar Reporte (Alt+G)");
/* 1169 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1171 */             TarjetaCliente.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1175 */     this.jLabel51.setFont(new Font("Cantarell", 0, 11));
/* 1176 */     this.jLabel51.setText("Generar un Reporte");
/*      */     
/* 1178 */     this.jLabel52.setFont(new Font("Cantarell", 0, 11));
/* 1179 */     this.jLabel52.setText("Realizar un cargo");
/*      */     
/* 1181 */     this.jButton5.setMnemonic('R');
/* 1182 */     this.jButton5.setText("Cargo");
/* 1183 */     this.jButton5.setToolTipText("Cargo Directo (Alt+R)");
/* 1184 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1186 */             TarjetaCliente.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1190 */     this.jLabel53.setFont(new Font("Cantarell", 0, 11));
/* 1191 */     this.jLabel53.setText("Realizar un abono");
/*      */     
/* 1193 */     this.jButton6.setMnemonic('A');
/* 1194 */     this.jButton6.setText("Abono");
/* 1195 */     this.jButton6.setToolTipText("Nuevo Abono (Alt+A)");
/* 1196 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1198 */             TarjetaCliente.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1202 */     this.jLabel54.setFont(new Font("Cantarell", 0, 11));
/* 1203 */     this.jLabel54.setText("Cancelar un movimiento");
/*      */     
/* 1205 */     this.jButton7.setMnemonic('L');
/* 1206 */     this.jButton7.setText("Cancelar");
/* 1207 */     this.jButton7.setToolTipText("Cancelar (Alt+L)");
/* 1208 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1210 */             TarjetaCliente.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1214 */     this.jLabel55.setFont(new Font("Cantarell", 0, 11));
/* 1215 */     this.jLabel55.setText("Imprimir estado de cuenta");
/*      */     
/* 1217 */     this.jButton19.setText("Imprimir");
/* 1218 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1220 */             TarjetaCliente.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1224 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/* 1225 */     this.jPanel24.setLayout(jPanel24Layout);
/* 1226 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/* 1227 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1228 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 1229 */           .addContainerGap()
/* 1230 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1231 */             .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1232 */               .addComponent(this.jLabel53, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1233 */               .addComponent(this.jLabel52, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1234 */               .addComponent(this.jLabel51, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1235 */             .addComponent(this.jLabel55, -2, 220, -2)
/* 1236 */             .addComponent(this.jLabel54, -2, 183, -2))
/* 1237 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767)
/* 1238 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1239 */             .addComponent(this.jButton19, -1, 120, 32767)
/* 1240 */             .addComponent(this.jButton5, -1, -1, 32767)
/* 1241 */             .addComponent(this.jButton6, -1, -1, 32767)
/* 1242 */             .addComponent(this.jButton7, -1, 120, 32767)
/* 1243 */             .addComponent(this.jButton17, -1, -1, 32767))
/* 1244 */           .addContainerGap()));
/*      */     
/* 1246 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/* 1247 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1248 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 1249 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1250 */             .addComponent(this.jButton17)
/* 1251 */             .addComponent(this.jLabel51))
/* 1252 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1253 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1254 */             .addComponent(this.jLabel52)
/* 1255 */             .addComponent(this.jButton5))
/* 1256 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1257 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1258 */             .addComponent(this.jLabel53)
/* 1259 */             .addComponent(this.jButton6))
/* 1260 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1261 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1262 */             .addComponent(this.jLabel54)
/* 1263 */             .addComponent(this.jButton7))
/* 1264 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1265 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1266 */             .addComponent(this.jLabel55)
/* 1267 */             .addComponent(this.jButton19))
/* 1268 */           .addContainerGap(25, 32767)));
/*      */ 
/*      */     
/* 1271 */     this.jPanel1.add(this.jPanel24);
/*      */     
/* 1273 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/* 1274 */     this.jPanel25.setLayout(jPanel25Layout);
/* 1275 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/* 1276 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1277 */         .addComponent(this.jLabel62, -2, 809, -2)
/* 1278 */         .addComponent(this.jScrollPane1, -2, 0, 32767)
/* 1279 */         .addComponent(this.jPanel27, -1, -1, 32767)
/* 1280 */         .addComponent(this.jPanel1, -2, 0, 32767));
/*      */     
/* 1282 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/* 1283 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1284 */         .addGroup(jPanel25Layout.createSequentialGroup()
/* 1285 */           .addComponent(this.jLabel62, -2, 20, -2)
/* 1286 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1287 */           .addComponent(this.jScrollPane1, -1, 206, 32767)
/* 1288 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1289 */           .addComponent(this.jPanel27, -2, -1, -2)
/* 1290 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1291 */           .addComponent(this.jPanel1, -2, 226, -2)));
/*      */ 
/*      */     
/* 1294 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1295 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1296 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1297 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1298 */         .addComponent(this.jPanel25, -1, -1, 32767));
/*      */     
/* 1300 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1301 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1302 */         .addComponent(this.jPanel25, -1, -1, 32767));
/*      */ 
/*      */     
/* 1305 */     this.jDialog3.setTitle("Nuevo Abono");
/* 1306 */     this.jDialog3.setModal(true);
/*      */     
/* 1308 */     this.jPanel28.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/* 1310 */     this.jLabel86.setFont(new Font("Cantarell", 0, 11));
/* 1311 */     this.jLabel86.setHorizontalAlignment(4);
/* 1312 */     this.jLabel86.setText("Abono:");
/* 1313 */     this.jPanel28.add(this.jLabel86);
/*      */     
/* 1315 */     this.jTextField14.setEditable(false);
/* 1316 */     this.jTextField14.setFont(new Font("Tahoma", 1, 11));
/* 1317 */     this.jTextField14.setForeground(this.lc.PRIMARIO1);
/* 1318 */     this.jTextField14.setText("PR-00001");
/* 1319 */     this.jPanel28.add(this.jTextField14);
/*      */     
/* 1321 */     this.jLabel81.setFont(new Font("Cantarell", 0, 11));
/* 1322 */     this.jLabel81.setHorizontalAlignment(4);
/* 1323 */     this.jLabel81.setText("Fecha de depósito");
/* 1324 */     this.jPanel28.add(this.jLabel81);
/*      */     
/* 1326 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1327 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 1328 */     this.jDateChooser4.setIcon(this.icon);
/* 1329 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 1330 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/* 1331 */     this.jPanel28.add((Component)this.jDateChooser4);
/*      */     
/* 1333 */     this.jLabel90.setFont(new Font("Cantarell", 0, 11));
/* 1334 */     this.jLabel90.setText("Folio: ");
/*      */     
/* 1336 */     this.jTextField13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1338 */             TarjetaCliente.this.jTextField13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1342 */     this.jButton26.setMnemonic('C');
/* 1343 */     this.jButton26.setText("Capturar");
/* 1344 */     this.jButton26.setToolTipText("Capturar complemento de pago o nota de crédito");
/* 1345 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1347 */             TarjetaCliente.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1351 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1352 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1353 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1355 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1356 */           .addGap(6, 6, 6)
/* 1357 */           .addComponent(this.jLabel90, -2, 111, -2)
/* 1358 */           .addGap(11, 11, 11)
/* 1359 */           .addComponent(this.jTextField13)
/* 1360 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1361 */           .addComponent(this.jButton26)
/* 1362 */           .addGap(11, 11, 11)));
/*      */     
/* 1364 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1365 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1366 */         .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1367 */           .addComponent(this.jButton26)
/* 1368 */           .addComponent(this.jTextField13, -2, -1, -2)
/* 1369 */           .addComponent(this.jLabel90)));
/*      */ 
/*      */     
/* 1372 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Tipo de abono", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1374 */     this.jRadioButton5.setFont(new Font("Cantarell", 0, 11));
/* 1375 */     this.jRadioButton5.setSelected(true);
/* 1376 */     this.jRadioButton5.setText("Complemento de pago");
/* 1377 */     this.jRadioButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1379 */             TarjetaCliente.this.jRadioButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1383 */     this.jRadioButton9.setFont(new Font("Cantarell", 0, 11));
/* 1384 */     this.jRadioButton9.setText("Otro Concepto");
/* 1385 */     this.jRadioButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1387 */             TarjetaCliente.this.jRadioButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1391 */     this.jRadioButton10.setFont(new Font("Cantarell", 0, 11));
/* 1392 */     this.jRadioButton10.setSelected(true);
/* 1393 */     this.jRadioButton10.setText("Nota de crédito");
/* 1394 */     this.jRadioButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1396 */             TarjetaCliente.this.jRadioButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1400 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1401 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1402 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 1403 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1404 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1405 */           .addContainerGap()
/* 1406 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1407 */             .addComponent(this.jRadioButton10, -1, -1, 32767)
/* 1408 */             .addComponent(this.jRadioButton5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1409 */             .addComponent(this.jRadioButton9, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1410 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
/* 1411 */               .addGap(21, 21, 21)
/* 1412 */               .addComponent(this.jTextField12, -2, 228, -2)))
/* 1413 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1415 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 1416 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1417 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1418 */           .addComponent(this.jRadioButton5)
/* 1419 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1420 */           .addComponent(this.jRadioButton10)
/* 1421 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1422 */           .addComponent(this.jRadioButton9)
/* 1423 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1424 */           .addComponent(this.jTextField12, -2, -1, -2)
/* 1425 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1428 */     this.jPanel8.setLayout(new GridLayout(2, 0, 0, 10));
/*      */     
/* 1430 */     this.jPanel32.setLayout(new GridLayout(2, 3, 6, 6));
/*      */     
/* 1432 */     this.jLabel87.setFont(new Font("Cantarell", 0, 11));
/* 1433 */     this.jLabel87.setText("Banco");
/* 1434 */     this.jPanel32.add(this.jLabel87);
/*      */     
/* 1436 */     this.jLabel89.setFont(new Font("Cantarell", 0, 11));
/* 1437 */     this.jLabel89.setText("Cuenta");
/* 1438 */     this.jPanel32.add(this.jLabel89);
/*      */     
/* 1440 */     this.jLabel88.setFont(new Font("Cantarell", 0, 11));
/* 1441 */     this.jLabel88.setText("Referencia o cheque");
/* 1442 */     this.jPanel32.add(this.jLabel88);
/*      */     
/* 1444 */     this.jTextField16.setFont(new Font("Tahoma", 1, 11));
/* 1445 */     this.jTextField16.setText("banco");
/* 1446 */     this.jPanel32.add(this.jTextField16);
/*      */     
/* 1448 */     this.jTextField17.setFont(new Font("Tahoma", 1, 11));
/* 1449 */     this.jTextField17.setText("cta");
/* 1450 */     this.jTextField17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1452 */             TarjetaCliente.this.jTextField17ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1455 */     this.jPanel32.add(this.jTextField17);
/*      */     
/* 1457 */     this.jTextField15.setText("ref");
/* 1458 */     this.jPanel32.add(this.jTextField15);
/*      */     
/* 1460 */     this.jPanel8.add(this.jPanel32);
/*      */     
/* 1462 */     this.jPanel33.setLayout(new GridLayout(2, 3, 6, 6));
/*      */     
/* 1464 */     this.jLabel84.setFont(new Font("Cantarell", 0, 11));
/* 1465 */     this.jLabel84.setText("Cantidad ");
/* 1466 */     this.jLabel84.setVerticalAlignment(3);
/* 1467 */     this.jPanel33.add(this.jLabel84);
/*      */     
/* 1469 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/* 1470 */     this.jFormattedTextField1.setText("$0.0");
/* 1471 */     this.jFormattedTextField1.setFont(new Font("Tahoma", 1, 11));
/* 1472 */     this.jFormattedTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1474 */             TarjetaCliente.this.jFormattedTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1477 */     this.jPanel33.add(this.jFormattedTextField1);
/*      */     
/* 1479 */     this.jPanel8.add(this.jPanel33);
/*      */     
/* 1481 */     this.jPanel34.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/* 1483 */     this.jLabel2.setFont(new Font("Cantarell", 0, 11));
/* 1484 */     this.jLabel2.setText("Buscar Facturas:");
/* 1485 */     this.jPanel34.add(this.jLabel2);
/*      */     
/* 1487 */     this.jTextField11.setHorizontalAlignment(4);
/* 1488 */     this.jTextField11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1490 */             TarjetaCliente.this.jTextField11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1493 */     this.jTextField11.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1495 */             TarjetaCliente.this.jTextField11KeyReleased(evt);
/*      */           }
/*      */         });
/* 1498 */     this.jPanel34.add(this.jTextField11);
/*      */     
/* 1500 */     this.jLabel57.setFont(new Font("Cantarell", 0, 11));
/* 1501 */     this.jLabel57.setForeground(this.lc.PRIMARIO1);
/* 1502 */     this.jLabel57.setHorizontalAlignment(2);
/* 1503 */     this.jLabel57.setText("Buscando...");
/* 1504 */     this.jPanel34.add(this.jLabel57);
/*      */     
/* 1506 */     this.rSTableMetro6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1514 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1519 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1522 */     this.rSTableMetro6.setAltoHead(25);
/* 1523 */     this.rSTableMetro6.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1524 */     this.rSTableMetro6.setColorBordeFilas(new Color(200, 200, 200));
/* 1525 */     this.rSTableMetro6.setColorBordeHead(this.lc.PRIMARIO1);
/* 1526 */     this.rSTableMetro6.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1527 */     this.rSTableMetro6.setColorFilasForeground1(new Color(102, 102, 102));
/* 1528 */     this.rSTableMetro6.setColorFilasForeground2(new Color(102, 102, 102));
/* 1529 */     this.rSTableMetro6.setColorSelBackgound(new Color(237, 107, 107));
/* 1530 */     this.rSTableMetro6.setFont(new Font("Cantarell", 0, 10));
/* 1531 */     this.rSTableMetro6.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 1532 */     this.rSTableMetro6.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 1533 */     this.rSTableMetro6.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1534 */     this.rSTableMetro6.setGrosorBordeFilas(0);
/* 1535 */     this.rSTableMetro6.setRowHeight(18);
/* 1536 */     this.rSTableMetro6.setSelectionBackground(this.lc.PRIMARIO2);
/* 1537 */     this.rSTableMetro6.getTableHeader().setResizingAllowed(false);
/* 1538 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/* 1539 */     this.rSTableMetro6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1541 */             TarjetaCliente.this.rSTableMetro6MouseClicked(evt);
/*      */           }
/*      */         });
/* 1544 */     this.rSTableMetro6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1546 */             TarjetaCliente.this.rSTableMetro6KeyReleased(evt);
/*      */           }
/*      */         });
/* 1549 */     this.jScrollPane17.setViewportView((Component)this.rSTableMetro6);
/*      */     
/* 1551 */     this.jPanel35.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1553 */     this.jPanel37.setLayout(new GridLayout(1, 3, 6, 0));
/*      */     
/* 1555 */     this.jButton1.setText("Amparar");
/* 1556 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1558 */             TarjetaCliente.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1561 */     this.jPanel37.add(this.jButton1);
/*      */     
/* 1563 */     this.jButton3.setText("Quitar");
/* 1564 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1566 */             TarjetaCliente.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1569 */     this.jPanel37.add(this.jButton3);
/*      */     
/* 1571 */     this.jButton25.setText("Importe");
/* 1572 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1574 */             TarjetaCliente.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1577 */     this.jPanel37.add(this.jButton25);
/*      */     
/* 1579 */     this.jPanel35.add(this.jPanel37);
/*      */     
/* 1581 */     this.rSTableMetro7.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1589 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1594 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1597 */     this.rSTableMetro7.setAltoHead(25);
/* 1598 */     this.rSTableMetro7.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1599 */     this.rSTableMetro7.setColorBordeFilas(new Color(200, 200, 200));
/* 1600 */     this.rSTableMetro7.setColorBordeHead(this.lc.PRIMARIO1);
/* 1601 */     this.rSTableMetro7.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1602 */     this.rSTableMetro7.setColorFilasForeground1(new Color(102, 102, 102));
/* 1603 */     this.rSTableMetro7.setColorFilasForeground2(new Color(102, 102, 102));
/* 1604 */     this.rSTableMetro7.setColorSelBackgound(new Color(237, 107, 107));
/* 1605 */     this.rSTableMetro7.setFont(new Font("Cantarell", 0, 10));
/* 1606 */     this.rSTableMetro7.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 1607 */     this.rSTableMetro7.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 1608 */     this.rSTableMetro7.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1609 */     this.rSTableMetro7.setGrosorBordeFilas(0);
/* 1610 */     this.rSTableMetro7.setRowHeight(18);
/* 1611 */     this.rSTableMetro7.setSelectionBackground(this.lc.PRIMARIO2);
/* 1612 */     this.rSTableMetro7.getTableHeader().setResizingAllowed(false);
/* 1613 */     this.rSTableMetro7.getTableHeader().setReorderingAllowed(false);
/* 1614 */     this.rSTableMetro7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1616 */             TarjetaCliente.this.rSTableMetro7MouseClicked(evt);
/*      */           }
/*      */         });
/* 1619 */     this.rSTableMetro7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1621 */             TarjetaCliente.this.rSTableMetro7KeyReleased(evt);
/*      */           }
/*      */         });
/* 1624 */     this.jScrollPane19.setViewportView((Component)this.rSTableMetro7);
/*      */     
/* 1626 */     this.jPanel36.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1628 */     this.jPanel38.setLayout(new GridLayout(2, 2, 6, 0));
/*      */     
/* 1630 */     this.jLabel38.setFont(new Font("Cantarell", 0, 11));
/* 1631 */     this.jLabel38.setText(" Total:");
/* 1632 */     this.jLabel38.setVerticalAlignment(3);
/* 1633 */     this.jPanel38.add(this.jLabel38);
/*      */     
/* 1635 */     this.jLabel39.setFont(new Font("Cantarell", 1, 13));
/* 1636 */     this.jLabel39.setForeground(this.lc.PRIMARIO1);
/* 1637 */     this.jLabel39.setText("0");
/* 1638 */     this.jLabel39.setVerticalAlignment(3);
/* 1639 */     this.jPanel38.add(this.jLabel39);
/*      */     
/* 1641 */     this.jLabel36.setFont(new Font("Cantarell", 0, 11));
/* 1642 */     this.jLabel36.setText(" Sumas:");
/* 1643 */     this.jPanel38.add(this.jLabel36);
/*      */     
/* 1645 */     this.jLabel37.setFont(new Font("Cantarell", 1, 13));
/* 1646 */     this.jLabel37.setForeground(this.lc.PRIMARIO1);
/* 1647 */     this.jLabel37.setText("$0.0");
/* 1648 */     this.jPanel38.add(this.jLabel37);
/*      */     
/* 1650 */     this.jPanel36.add(this.jPanel38);
/*      */     
/* 1652 */     this.jPanel39.setLayout(new GridLayout(2, 2, 6, 6));
/*      */     
/* 1654 */     GroupLayout jPanel40Layout = new GroupLayout(this.jPanel40);
/* 1655 */     this.jPanel40.setLayout(jPanel40Layout);
/* 1656 */     jPanel40Layout.setHorizontalGroup(jPanel40Layout
/* 1657 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1658 */         .addGap(0, 194, 32767));
/*      */     
/* 1660 */     jPanel40Layout.setVerticalGroup(jPanel40Layout
/* 1661 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1662 */         .addGap(0, 32, 32767));
/*      */ 
/*      */     
/* 1665 */     this.jPanel39.add(this.jPanel40);
/*      */     
/* 1667 */     this.jPanel41.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 1669 */     this.materialButton37.setBackground(this.lc.PRIMARIO1);
/* 1670 */     this.materialButton37.setForeground(new Color(255, 255, 255));
/* 1671 */     this.materialButton37.setMnemonic('A');
/* 1672 */     this.materialButton37.setText("Abonar");
/* 1673 */     this.materialButton37.setToolTipText("Abonar (Alt+A)");
/* 1674 */     this.materialButton37.setFont(new Font("Cantarell", 0, 12));
/* 1675 */     this.materialButton37.setHorizontalTextPosition(0);
/* 1676 */     this.materialButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1678 */             TarjetaCliente.this.materialButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1681 */     this.jPanel41.add((Component)this.materialButton37);
/*      */     
/* 1683 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/* 1684 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/* 1685 */     this.materialButton38.setMnemonic('C');
/* 1686 */     this.materialButton38.setText("Cerrar");
/* 1687 */     this.materialButton38.setToolTipText("Cerrar (Alt+C)");
/* 1688 */     this.materialButton38.setFont(new Font("Cantarell", 0, 12));
/* 1689 */     this.materialButton38.setHorizontalTextPosition(0);
/* 1690 */     this.materialButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1692 */             TarjetaCliente.this.materialButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1695 */     this.jPanel41.add((Component)this.materialButton38);
/*      */     
/* 1697 */     this.jPanel39.add(this.jPanel41);
/*      */     
/* 1699 */     this.jPanel36.add(this.jPanel39);
/*      */     
/* 1701 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 1702 */     this.jPanel21.setLayout(jPanel21Layout);
/* 1703 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 1704 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1705 */         .addComponent(this.jPanel35, -1, -1, 32767)
/* 1706 */         .addComponent(this.jScrollPane17, -2, 0, 32767)
/* 1707 */         .addComponent(this.jPanel34, -1, -1, 32767)
/* 1708 */         .addComponent(this.jPanel8, -1, -1, 32767)
/* 1709 */         .addComponent(this.jPanel3, -1, -1, 32767)
/* 1710 */         .addComponent(this.jPanel2, -1, -1, 32767)
/* 1711 */         .addComponent(this.jPanel28, -2, 0, 32767)
/* 1712 */         .addComponent(this.jScrollPane19, -2, 0, 32767)
/* 1713 */         .addComponent(this.jPanel36, -1, 395, 32767));
/*      */     
/* 1715 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 1716 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1717 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 1718 */           .addComponent(this.jPanel28, -2, -1, -2)
/* 1719 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1720 */           .addComponent(this.jPanel2, -2, -1, -2)
/* 1721 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1722 */           .addComponent(this.jPanel3, -2, -1, -2)
/* 1723 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1724 */           .addComponent(this.jPanel8, -2, 125, -2)
/* 1725 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1726 */           .addComponent(this.jPanel34, -2, -1, -2)
/* 1727 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1728 */           .addComponent(this.jScrollPane17, -2, 96, -2)
/* 1729 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1730 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 1731 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1732 */           .addComponent(this.jScrollPane19, -2, 98, -2)
/* 1733 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1734 */           .addComponent(this.jPanel36, -2, 70, -2)
/* 1735 */           .addGap(0, 6, 32767)));
/*      */ 
/*      */     
/* 1738 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1739 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1740 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1741 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1742 */         .addComponent(this.jPanel21, -1, -1, 32767));
/*      */     
/* 1744 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1745 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1746 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1747 */           .addComponent(this.jPanel21, -1, -1, 32767)
/* 1748 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 1751 */     this.cantidad.setText("jFormattedTextField2");
/*      */     
/* 1753 */     this.auxiliar.setText("jFormattedTextField2");
/*      */     
/* 1755 */     this.jDialog4.setTitle("Información del cargo");
/* 1756 */     this.jDialog4.setModal(true);
/*      */     
/* 1758 */     this.jLabel4.setText("Mov");
/*      */     
/* 1760 */     this.jTextField5.setEnabled(false);
/*      */     
/* 1762 */     this.jLabel5.setHorizontalAlignment(4);
/* 1763 */     this.jLabel5.setText("Fecha");
/*      */     
/* 1765 */     this.jTextField6.setEnabled(false);
/*      */     
/* 1767 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1768 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1769 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1770 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1771 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1772 */           .addComponent(this.jLabel4, -2, 33, -2)
/* 1773 */           .addGap(2, 2, 2)
/* 1774 */           .addComponent(this.jTextField5, -2, 87, -2)
/* 1775 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1776 */           .addComponent(this.jLabel5, -2, 51, -2)
/* 1777 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1778 */           .addComponent(this.jTextField6, -2, 92, -2))
/* 1779 */         .addComponent(this.jSeparator2, -2, 305, -2));
/*      */     
/* 1781 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1782 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1783 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1784 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1785 */             .addComponent(this.jLabel4)
/* 1786 */             .addComponent(this.jTextField5, -2, -1, -2)
/* 1787 */             .addComponent(this.jTextField6, -2, -1, -2)
/* 1788 */             .addComponent(this.jLabel5))
/* 1789 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1790 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 1791 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1794 */     this.jPanel5.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1796 */     this.jLabel6.setText("Tipo");
/*      */     
/* 1798 */     this.jLabel7.setFont(new Font("Tahoma", 1, 11));
/* 1799 */     this.jLabel7.setText("jLabel7");
/*      */     
/* 1801 */     this.jLabel8.setText("Concepto");
/*      */     
/* 1803 */     this.jLabel9.setFont(new Font("Tahoma", 1, 11));
/* 1804 */     this.jLabel9.setText("jLabel7");
/*      */     
/* 1806 */     this.jLabel10.setText("Referencia");
/*      */     
/* 1808 */     this.jLabel11.setFont(new Font("Tahoma", 1, 11));
/* 1809 */     this.jLabel11.setText("jLabel7");
/*      */     
/* 1811 */     this.jLabel12.setHorizontalAlignment(4);
/* 1812 */     this.jLabel12.setText("Importe");
/*      */     
/* 1814 */     this.jLabel13.setFont(new Font("Tahoma", 1, 11));
/* 1815 */     this.jLabel13.setHorizontalAlignment(4);
/* 1816 */     this.jLabel13.setText("jLabel7");
/*      */     
/* 1818 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1819 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1820 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1821 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1822 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1823 */           .addContainerGap()
/* 1824 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1825 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1826 */               .addComponent(this.jLabel8, -1, -1, 32767)
/* 1827 */               .addGap(380, 380, 380))
/* 1828 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1829 */               .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1830 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
/* 1831 */                   .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1832 */                     .addComponent(this.jLabel10, -2, 107, -2)
/* 1833 */                     .addComponent(this.jLabel11, -2, 162, -2))
/* 1834 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1835 */                   .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1836 */                     .addComponent(this.jLabel12, -1, -1, 32767)
/* 1837 */                     .addComponent(this.jLabel13, -2, 96, -2)))
/* 1838 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
/* 1839 */                   .addComponent(this.jLabel6, -2, 38, -2)
/* 1840 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1841 */                   .addComponent(this.jLabel7, -2, 231, -2))
/* 1842 */                 .addComponent(this.jLabel9, GroupLayout.Alignment.LEADING, -2, 242, -2))
/* 1843 */               .addContainerGap()))));
/*      */     
/* 1845 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1846 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1847 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1848 */           .addContainerGap()
/* 1849 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1850 */             .addComponent(this.jLabel6)
/* 1851 */             .addComponent(this.jLabel7))
/* 1852 */           .addGap(18, 18, 18)
/* 1853 */           .addComponent(this.jLabel8)
/* 1854 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1855 */           .addComponent(this.jLabel9)
/* 1856 */           .addGap(18, 18, 18)
/* 1857 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1858 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1859 */               .addComponent(this.jLabel10)
/* 1860 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1861 */               .addComponent(this.jLabel11, -1, -1, 32767))
/* 1862 */             .addGroup(jPanel5Layout.createSequentialGroup()
/* 1863 */               .addComponent(this.jLabel12)
/* 1864 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1865 */               .addComponent(this.jLabel13)))
/* 1866 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1869 */     this.jLabel14.setHorizontalAlignment(0);
/* 1870 */     this.jLabel14.setText("Pagos para este abono");
/* 1871 */     this.jLabel14.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1873 */     this.jTable7.setFont(new Font("Tahoma", 0, 10));
/* 1874 */     this.jTable7.setModel(new DefaultTableModel(new Object[][] { { "Pago 1 ", null }, , { "Pago 2", null }, , { "Pago 3", null }, , { "Pago 4", null },  }, (Object[])new String[] { "Pagos", "Descripción" })
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
/* 1885 */           boolean[] canEdit = new boolean[] { true, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1890 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1893 */     this.jTable7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1895 */             TarjetaCliente.this.jTable7MouseClicked(evt);
/*      */           }
/*      */         });
/* 1898 */     this.jScrollPane9.setViewportView(this.jTable7);
/* 1899 */     if (this.jTable7.getColumnModel().getColumnCount() > 0) {
/* 1900 */       this.jTable7.getColumnModel().getColumn(0).setMinWidth(50);
/* 1901 */       this.jTable7.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     } 
/*      */     
/* 1904 */     this.jLabel16.setHorizontalAlignment(0);
/* 1905 */     this.jLabel16.setText(" ");
/* 1906 */     this.jLabel16.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1908 */     this.jLabel19.setText("<html><u>Ver comentario<u><html>");
/* 1909 */     this.jLabel19.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1911 */             TarjetaCliente.this.jLabel19MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1914 */             TarjetaCliente.this.jLabel19MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1917 */             TarjetaCliente.this.jLabel19MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1921 */     this.materialButton36.setBackground(this.lc.SECUNDARIO1);
/* 1922 */     this.materialButton36.setForeground(new Color(255, 255, 255));
/* 1923 */     this.materialButton36.setMnemonic('C');
/* 1924 */     this.materialButton36.setText("Cerrar");
/* 1925 */     this.materialButton36.setToolTipText("Cerrar (Alt+C)");
/* 1926 */     this.materialButton36.setFont(new Font("Cantarell", 0, 12));
/* 1927 */     this.materialButton36.setHorizontalTextPosition(0);
/* 1928 */     this.materialButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1930 */             TarjetaCliente.this.materialButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1934 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1935 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1936 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1937 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1938 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 1939 */           .addComponent(this.jLabel19, -2, 90, -2)
/* 1940 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1941 */           .addComponent((Component)this.materialButton36, -2, 105, -2))
/* 1942 */         .addComponent(this.jScrollPane9, -2, 0, 32767)
/* 1943 */         .addComponent(this.jLabel14, -1, -1, 32767)
/* 1944 */         .addComponent(this.jLabel16, -1, -1, 32767));
/*      */     
/* 1946 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1947 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1948 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1949 */           .addComponent(this.jLabel14)
/* 1950 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1951 */           .addComponent(this.jScrollPane9, -2, 107, -2)
/* 1952 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1953 */           .addComponent(this.jLabel16)
/* 1954 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1955 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1956 */             .addComponent(this.jLabel19, -2, -1, -2)
/* 1957 */             .addComponent((Component)this.materialButton36, -2, 38, -2))
/* 1958 */           .addContainerGap(21, 32767)));
/*      */ 
/*      */     
/* 1961 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1962 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1963 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1964 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1965 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 1966 */           .addContainerGap()
/* 1967 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1968 */             .addComponent(this.jPanel10, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1969 */             .addComponent(this.jPanel11, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1970 */             .addComponent(this.jPanel5, 0, 0, 32767))
/* 1971 */           .addContainerGap()));
/*      */     
/* 1973 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1974 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1975 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 1976 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 1977 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1978 */           .addComponent(this.jPanel5, -2, -1, -2)
/* 1979 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1980 */           .addComponent(this.jPanel11, -2, -1, -2)));
/*      */ 
/*      */     
/* 1983 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1984 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1985 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1986 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1987 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */     
/* 1989 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1990 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1991 */         .addComponent(this.jPanel7, -1, -1, 32767));
/*      */ 
/*      */     
/* 1994 */     this.jDialog5.setTitle("Información del abono");
/* 1995 */     this.jDialog5.setModal(true);
/*      */     
/* 1997 */     this.jLabel20.setText("Mov");
/*      */     
/* 1999 */     this.jTextField7.setEnabled(false);
/*      */     
/* 2001 */     this.jLabel21.setHorizontalAlignment(4);
/* 2002 */     this.jLabel21.setText("Fecha");
/*      */     
/* 2004 */     this.jTextField8.setEnabled(false);
/*      */     
/* 2006 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 2007 */     this.jPanel14.setLayout(jPanel14Layout);
/* 2008 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 2009 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2010 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 2011 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2012 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
/* 2013 */               .addComponent(this.jLabel20, -2, 33, -2)
/* 2014 */               .addGap(2, 2, 2)
/* 2015 */               .addComponent(this.jTextField7, -2, 87, -2)
/* 2016 */               .addGap(18, 18, 18)
/* 2017 */               .addComponent(this.jLabel21, -2, 51, -2)
/* 2018 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2019 */               .addComponent(this.jTextField8, -2, 92, -2))
/* 2020 */             .addComponent(this.jSeparator5, GroupLayout.Alignment.LEADING, -2, 305, -2))
/* 2021 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2023 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 2024 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2025 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 2026 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2027 */             .addComponent(this.jLabel20)
/* 2028 */             .addComponent(this.jTextField7, -2, -1, -2)
/* 2029 */             .addComponent(this.jTextField8, -2, -1, -2)
/* 2030 */             .addComponent(this.jLabel21))
/* 2031 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2032 */           .addComponent(this.jSeparator5, -2, 10, -2)
/* 2033 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2036 */     this.jPanel15.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 2038 */     this.jLabel23.setFont(new Font("Tahoma", 1, 11));
/* 2039 */     this.jLabel23.setText("jLabel7");
/*      */     
/* 2041 */     this.jLabel22.setText("Tipo");
/*      */     
/* 2043 */     this.jLabel33.setHorizontalAlignment(4);
/* 2044 */     this.jLabel33.setText("Abono:");
/*      */     
/* 2046 */     this.jLabel34.setFont(new Font("Tahoma", 1, 11));
/* 2047 */     this.jLabel34.setHorizontalAlignment(4);
/* 2048 */     this.jLabel34.setText("pr-00005");
/*      */     
/* 2050 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 2051 */     this.jPanel17.setLayout(jPanel17Layout);
/* 2052 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 2053 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2054 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2055 */           .addComponent(this.jLabel22, -2, 38, -2)
/* 2056 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2057 */           .addComponent(this.jLabel23, -2, 72, -2)
/* 2058 */           .addGap(41, 41, 41)
/* 2059 */           .addComponent(this.jLabel33, -2, 42, -2)
/* 2060 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2061 */           .addComponent(this.jLabel34, -1, 76, 32767)));
/*      */     
/* 2063 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 2064 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2065 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2066 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2067 */             .addComponent(this.jLabel22)
/* 2068 */             .addComponent(this.jLabel23)
/* 2069 */             .addComponent(this.jLabel34)
/* 2070 */             .addComponent(this.jLabel33))
/* 2071 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2074 */     this.jLabel24.setText("Concepto");
/*      */     
/* 2076 */     this.jLabel25.setFont(new Font("Tahoma", 1, 11));
/* 2077 */     this.jLabel25.setText("jLabel7");
/*      */     
/* 2079 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 2080 */     this.jPanel18.setLayout(jPanel18Layout);
/* 2081 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 2082 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2083 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 2084 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2085 */             .addComponent(this.jLabel24, -2, 67, -2)
/* 2086 */             .addComponent(this.jLabel25, -1, 250, 32767))
/* 2087 */           .addGap(31, 31, 31)));
/*      */     
/* 2089 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 2090 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2091 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 2092 */           .addComponent(this.jLabel24)
/* 2093 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2094 */           .addComponent(this.jLabel25)));
/*      */ 
/*      */     
/* 2097 */     this.jLabel28.setHorizontalAlignment(4);
/* 2098 */     this.jLabel28.setText("Importe");
/*      */     
/* 2100 */     this.jLabel29.setFont(new Font("Tahoma", 1, 11));
/* 2101 */     this.jLabel29.setHorizontalAlignment(4);
/* 2102 */     this.jLabel29.setText("jLabel7");
/*      */     
/* 2104 */     this.jLabel26.setText("Referencia");
/*      */     
/* 2106 */     this.jLabel27.setFont(new Font("Tahoma", 1, 11));
/* 2107 */     this.jLabel27.setText("jLabel7");
/*      */     
/* 2109 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 2110 */     this.jPanel4.setLayout(jPanel4Layout);
/* 2111 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 2112 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2113 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 2114 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2115 */             .addComponent(this.jLabel27, -1, 165, 32767)
/* 2116 */             .addComponent(this.jLabel26, -2, 107, -2))
/* 2117 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2118 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2119 */             .addComponent(this.jLabel28, -1, -1, 32767)
/* 2120 */             .addComponent(this.jLabel29, -2, 96, -2))
/* 2121 */           .addContainerGap()));
/*      */     
/* 2123 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 2124 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2125 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 2126 */           .addComponent(this.jLabel26)
/* 2127 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2128 */           .addComponent(this.jLabel27))
/* 2129 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 2130 */           .addComponent(this.jLabel28)
/* 2131 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2132 */           .addComponent(this.jLabel29)));
/*      */ 
/*      */     
/* 2135 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 2136 */     this.jPanel15.setLayout(jPanel15Layout);
/* 2137 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/* 2138 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2139 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 2140 */           .addContainerGap()
/* 2141 */           .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2142 */             .addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2143 */             .addComponent(this.jPanel18, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2144 */             .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2145 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2147 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/* 2148 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2149 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 2150 */           .addContainerGap()
/* 2151 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 2152 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2153 */           .addComponent(this.jPanel18, -2, -1, -2)
/* 2154 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2155 */           .addComponent(this.jPanel4, -1, -1, 32767)
/* 2156 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2159 */     this.jPanel16.setBackground(new Color(146, 193, 134));
/*      */     
/* 2161 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 2162 */     this.jPanel16.setLayout(jPanel16Layout);
/* 2163 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 2164 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2165 */         .addGap(0, 0, 32767));
/*      */     
/* 2167 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 2168 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2169 */         .addGap(0, 204, 32767));
/*      */ 
/*      */     
/* 2172 */     this.jLabel30.setHorizontalAlignment(0);
/* 2173 */     this.jLabel30.setText("Observaciones para este movimiento");
/* 2174 */     this.jLabel30.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 2176 */     this.jTextArea1.setColumns(20);
/* 2177 */     this.jTextArea1.setEditable(false);
/* 2178 */     this.jTextArea1.setFont(new Font("Monospaced", 0, 12));
/* 2179 */     this.jTextArea1.setLineWrap(true);
/* 2180 */     this.jTextArea1.setRows(5);
/* 2181 */     this.jScrollPane10.setViewportView(this.jTextArea1);
/*      */     
/* 2183 */     this.jLabel31.setFont(new Font("Tahoma", 1, 11));
/* 2184 */     this.jLabel31.setHorizontalAlignment(0);
/* 2185 */     this.jLabel31.setText(" ");
/* 2186 */     this.jLabel31.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 2188 */     this.jLabel32.setText("<html><u>Ver comentario<u><html>");
/* 2189 */     this.jLabel32.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2191 */             TarjetaCliente.this.jLabel32MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2194 */             TarjetaCliente.this.jLabel32MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 2197 */             TarjetaCliente.this.jLabel32MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 2201 */     this.materialButton39.setBackground(this.lc.SECUNDARIO1);
/* 2202 */     this.materialButton39.setForeground(new Color(255, 255, 255));
/* 2203 */     this.materialButton39.setMnemonic('C');
/* 2204 */     this.materialButton39.setText("Cerrar");
/* 2205 */     this.materialButton39.setToolTipText("Cerrar (Alt+C)");
/* 2206 */     this.materialButton39.setFont(new Font("Cantarell", 0, 12));
/* 2207 */     this.materialButton39.setHorizontalTextPosition(0);
/* 2208 */     this.materialButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2210 */             TarjetaCliente.this.materialButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2214 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 2215 */     this.jPanel12.setLayout(jPanel12Layout);
/* 2216 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 2217 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2218 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 2219 */           .addContainerGap()
/* 2220 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2221 */             .addComponent(this.jPanel14, 0, 305, 32767)
/* 2222 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 2223 */               .addComponent(this.jLabel32, -2, 92, -2)
/* 2224 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2225 */               .addComponent((Component)this.materialButton39, -2, 105, -2))
/* 2226 */             .addComponent(this.jLabel31, -1, 305, 32767)
/* 2227 */             .addComponent(this.jScrollPane10, -1, 305, 32767)
/* 2228 */             .addComponent(this.jLabel30, -1, 305, 32767)
/* 2229 */             .addComponent(this.jPanel15, -1, -1, 32767))
/* 2230 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2231 */           .addComponent(this.jPanel16, -1, -1, 32767)
/* 2232 */           .addContainerGap()));
/*      */     
/* 2234 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 2235 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2236 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 2237 */           .addComponent(this.jPanel14, -2, -1, -2)
/* 2238 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2239 */           .addComponent(this.jPanel15, -2, -1, -2)
/* 2240 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2241 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2242 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 2243 */               .addGap(109, 109, 109)
/* 2244 */               .addComponent(this.jPanel16, -2, -1, -2))
/* 2245 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 2246 */               .addComponent(this.jLabel30)
/* 2247 */               .addGap(5, 5, 5)
/* 2248 */               .addComponent(this.jScrollPane10, -2, 108, -2)
/* 2249 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2250 */               .addComponent(this.jLabel31)
/* 2251 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2252 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2253 */                 .addComponent(this.jLabel32, -2, -1, -2)
/* 2254 */                 .addComponent((Component)this.materialButton39, -2, 38, -2))))
/* 2255 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2258 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 2259 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 2260 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 2261 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2262 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/* 2264 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 2265 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2266 */         .addComponent(this.jPanel12, -1, 401, 32767));
/*      */ 
/*      */     
/* 2269 */     this.jDialog6.setTitle("Nuevo Cargo Directo");
/* 2270 */     this.jDialog6.setModal(true);
/*      */     
/* 2272 */     this.jLabel71.setFont(new Font("Cantarell", 1, 13));
/* 2273 */     this.jLabel71.setForeground(this.lc.SECUNDARIO1);
/* 2274 */     this.jLabel71.setHorizontalAlignment(0);
/* 2275 */     this.jLabel71.setText("CARGO DIRECTO");
/*      */     
/* 2277 */     this.jLabel73.setFont(new Font("Cantarell", 0, 11));
/* 2278 */     this.jLabel73.setHorizontalAlignment(4);
/* 2279 */     this.jLabel73.setText("Fecha ");
/*      */     
/* 2281 */     this.jTextField9.setEditable(false);
/* 2282 */     this.jTextField9.setFont(new Font("Tahoma", 1, 11));
/* 2283 */     this.jTextField9.setForeground(this.lc.PRIMARIO1);
/* 2284 */     this.jTextField9.setText("26/04/2010");
/*      */     
/* 2286 */     this.jButton21.setMnemonic('C');
/* 2287 */     this.jButton21.setText("Cerrar");
/* 2288 */     this.jButton21.setToolTipText("Cerrar (Alt+C)");
/* 2289 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2291 */             TarjetaCliente.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2295 */     this.jLabel74.setFont(new Font("Cantarell", 0, 11));
/* 2296 */     this.jLabel74.setHorizontalAlignment(4);
/* 2297 */     this.jLabel74.setText("A cargo de ");
/*      */     
/* 2299 */     this.jLabel35.setFont(new Font("Cantarell", 1, 11));
/* 2300 */     this.jLabel35.setText("jLabel7");
/*      */     
/* 2302 */     this.jPanel20.setBorder(BorderFactory.createTitledBorder(null, "Concepto del Cargo", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 2304 */     this.jRadioButton3.setFont(new Font("Cantarell", 0, 11));
/* 2305 */     this.jRadioButton3.setSelected(true);
/* 2306 */     this.jRadioButton3.setText("CARGO POR FACTURA");
/* 2307 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2309 */             TarjetaCliente.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2313 */     this.jRadioButton4.setFont(new Font("Cantarell", 0, 11));
/* 2314 */     this.jRadioButton4.setText("OTRO");
/* 2315 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2317 */             TarjetaCliente.this.jRadioButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2321 */     this.jTextField10.setEnabled(false);
/*      */     
/* 2323 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 2324 */     this.jPanel20.setLayout(jPanel20Layout);
/* 2325 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 2326 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2327 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2328 */           .addContainerGap()
/* 2329 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2330 */             .addComponent(this.jRadioButton4, GroupLayout.Alignment.LEADING, -1, 275, 32767)
/* 2331 */             .addComponent(this.jRadioButton3, -1, 275, 32767))
/* 2332 */           .addGap(19, 19, 19))
/* 2333 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2334 */           .addGap(27, 27, 27)
/* 2335 */           .addComponent(this.jTextField10, -1, 263, 32767)
/* 2336 */           .addContainerGap()));
/*      */     
/* 2338 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 2339 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2340 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 2341 */           .addComponent(this.jRadioButton3)
/* 2342 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2343 */           .addComponent(this.jRadioButton4)
/* 2344 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2345 */           .addComponent(this.jTextField10, -2, -1, -2)
/* 2346 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2349 */     this.jLabel75.setFont(new Font("Cantarell", 0, 11));
/* 2350 */     this.jLabel75.setText("No. ó Referencia ");
/*      */     
/* 2352 */     this.jTextField18.setFont(new Font("Tahoma", 1, 11));
/*      */     
/* 2354 */     this.jLabel76.setFont(new Font("Cantarell", 0, 11));
/* 2355 */     this.jLabel76.setHorizontalAlignment(0);
/* 2356 */     this.jLabel76.setText("Cantidad ");
/*      */     
/* 2358 */     this.jFormattedTextField2.setHorizontalAlignment(4);
/* 2359 */     this.jFormattedTextField2.setText("$0.0");
/* 2360 */     this.jFormattedTextField2.setFont(new Font("Tahoma", 1, 11));
/* 2361 */     this.jFormattedTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2363 */             TarjetaCliente.this.jFormattedTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2367 */     this.jLabel77.setFont(new Font("Cantarell", 0, 11));
/* 2368 */     this.jLabel77.setText("Comentarios");
/*      */     
/* 2370 */     this.jTextArea2.setColumns(20);
/* 2371 */     this.jTextArea2.setFont(new Font("Tahoma", 0, 11));
/* 2372 */     this.jTextArea2.setLineWrap(true);
/* 2373 */     this.jTextArea2.setRows(5);
/* 2374 */     this.jScrollPane11.setViewportView(this.jTextArea2);
/*      */     
/* 2376 */     this.jButton24.setMnemonic('I');
/* 2377 */     this.jButton24.setText("Imprimir");
/* 2378 */     this.jButton24.setToolTipText("Imprimir (Alt+I)");
/* 2379 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2381 */             TarjetaCliente.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2385 */     this.jLabel80.setFont(new Font("Cantarell", 0, 11));
/* 2386 */     this.jLabel80.setHorizontalAlignment(4);
/* 2387 */     this.jLabel80.setText("MOV ");
/*      */     
/* 2389 */     this.jTextField19.setEditable(false);
/* 2390 */     this.jTextField19.setFont(new Font("Tahoma", 1, 11));
/* 2391 */     this.jTextField19.setForeground(this.lc.PRIMARIO1);
/* 2392 */     this.jTextField19.setText("PR-00001");
/*      */     
/* 2394 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/* 2395 */     this.jPanel19.setLayout(jPanel19Layout);
/* 2396 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/* 2397 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2398 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
/* 2399 */           .addContainerGap()
/* 2400 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2401 */             .addComponent(this.jScrollPane11, GroupLayout.Alignment.LEADING, -1, 312, 32767)
/* 2402 */             .addComponent(this.jPanel20, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2403 */             .addComponent(this.jLabel71, GroupLayout.Alignment.LEADING, -1, 312, 32767)
/* 2404 */             .addComponent(this.jLabel74, GroupLayout.Alignment.LEADING, -2, 70, -2)
/* 2405 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
/* 2406 */               .addGap(31, 31, 31)
/* 2407 */               .addComponent(this.jLabel35, -2, 271, -2))
/* 2408 */             .addComponent(this.jSeparator6, GroupLayout.Alignment.LEADING, -1, 312, 32767)
/* 2409 */             .addGroup(jPanel19Layout.createSequentialGroup()
/* 2410 */               .addComponent(this.jButton24, -2, 81, -2)
/* 2411 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2412 */               .addComponent(this.jButton21, -2, 81, -2))
/* 2413 */             .addGroup(jPanel19Layout.createSequentialGroup()
/* 2414 */               .addComponent(this.jLabel80, -2, 42, -2)
/* 2415 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2416 */               .addComponent(this.jTextField19, -2, 93, -2)
/* 2417 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, 32767)
/* 2418 */               .addComponent(this.jLabel73, -2, 42, -2)
/* 2419 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2420 */               .addComponent(this.jTextField9, -2, 82, -2))
/* 2421 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
/* 2422 */               .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2423 */                 .addComponent(this.jTextField18, -2, 190, -2)
/* 2424 */                 .addComponent(this.jLabel75, -2, 158, -2))
/* 2425 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, 32767)
/* 2426 */               .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2427 */                 .addComponent(this.jFormattedTextField2)
/* 2428 */                 .addComponent(this.jLabel76, -2, 105, -2)))
/* 2429 */             .addComponent(this.jLabel77, GroupLayout.Alignment.LEADING, -2, 96, -2))
/* 2430 */           .addContainerGap()));
/*      */     
/* 2432 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/* 2433 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2434 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 2435 */           .addComponent(this.jLabel71)
/* 2436 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2437 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2438 */             .addComponent(this.jLabel73)
/* 2439 */             .addComponent(this.jTextField9, -2, -1, -2)
/* 2440 */             .addComponent(this.jLabel80)
/* 2441 */             .addComponent(this.jTextField19, -2, -1, -2))
/* 2442 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2443 */           .addComponent(this.jSeparator6, -2, 10, -2)
/* 2444 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2445 */           .addComponent(this.jLabel74)
/* 2446 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2447 */           .addComponent(this.jLabel35)
/* 2448 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2449 */           .addComponent(this.jPanel20, -2, -1, -2)
/* 2450 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2451 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2452 */             .addGroup(jPanel19Layout.createSequentialGroup()
/* 2453 */               .addComponent(this.jLabel75)
/* 2454 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2455 */               .addComponent(this.jTextField18, -2, -1, -2))
/* 2456 */             .addGroup(jPanel19Layout.createSequentialGroup()
/* 2457 */               .addComponent(this.jLabel76)
/* 2458 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2459 */               .addComponent(this.jFormattedTextField2, -2, -1, -2)))
/* 2460 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2461 */           .addComponent(this.jLabel77)
/* 2462 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2463 */           .addComponent(this.jScrollPane11, -1, 109, 32767)
/* 2464 */           .addGap(18, 18, 18)
/* 2465 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2466 */             .addComponent(this.jButton21)
/* 2467 */             .addComponent(this.jButton24))
/* 2468 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2471 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 2472 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 2473 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 2474 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2475 */         .addComponent(this.jPanel19, -1, -1, 32767));
/*      */     
/* 2477 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 2478 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2479 */         .addComponent(this.jPanel19, -1, -1, 32767));
/*      */ 
/*      */     
/* 2482 */     this.jDialog7.setTitle("Cancelar el cargo");
/* 2483 */     this.jDialog7.setModal(true);
/*      */     
/* 2485 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*      */     
/* 2487 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/* 2488 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/* 2489 */     this.jLabel124.setHorizontalAlignment(0);
/* 2490 */     this.jLabel124.setText("Motivo de la Cancelación");
/*      */     
/* 2492 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/* 2493 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/* 2494 */     this.jLabel125.setHorizontalAlignment(4);
/* 2495 */     this.jLabel125.setText("Motivo");
/*      */     
/* 2497 */     this.jButton44.setMnemonic('A');
/* 2498 */     this.jButton44.setText("Cancelar el cargo");
/* 2499 */     this.jButton44.setToolTipText("Cancelar el cargo(Alt+A)");
/* 2500 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2502 */             TarjetaCliente.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2506 */     this.jButton45.setMnemonic('C');
/* 2507 */     this.jButton45.setText("Cerrar");
/* 2508 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 2509 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2511 */             TarjetaCliente.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2515 */     this.jTextArea5.setColumns(20);
/* 2516 */     this.jTextArea5.setLineWrap(true);
/* 2517 */     this.jTextArea5.setRows(5);
/* 2518 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 2520 */     this.jLabel126.setText("Ingresa el motivo por el cual deseas cancelar la partida");
/*      */     
/* 2522 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 2523 */     this.jPanel29.setLayout(jPanel29Layout);
/* 2524 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 2525 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2526 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 2527 */           .addContainerGap()
/* 2528 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2529 */             .addComponent(this.jLabel126, -1, -1, 32767)
/* 2530 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2531 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 2532 */                 .addComponent(this.jButton44, -2, 137, -2)
/* 2533 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2534 */                 .addComponent(this.jButton45, -2, 84, -2))
/* 2535 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 2536 */                 .addComponent(this.jLabel125, -2, 43, -2)
/* 2537 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2538 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/* 2539 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2540 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2541 */               .addComponent(this.jSeparator29, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/* 2542 */           .addContainerGap()));
/*      */     
/* 2544 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 2545 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2546 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 2547 */           .addComponent(this.jLabel124)
/* 2548 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2549 */           .addComponent(this.jSeparator29, -2, 10, -2)
/* 2550 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2551 */           .addComponent(this.jLabel126)
/* 2552 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2553 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2554 */             .addComponent(this.jLabel125)
/* 2555 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 2556 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2557 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2558 */             .addComponent(this.jButton45)
/* 2559 */             .addComponent(this.jButton44))
/* 2560 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2563 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 2564 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 2565 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 2566 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2567 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */     
/* 2569 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 2570 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2571 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */ 
/*      */     
/* 2574 */     this.jDialog8.setTitle("Cantidad ");
/* 2575 */     this.jDialog8.setModal(true);
/*      */     
/* 2577 */     this.jPanel30.setBackground(new Color(146, 193, 134));
/*      */     
/* 2579 */     this.jLabel127.setFont(new Font("Tahoma", 1, 14));
/* 2580 */     this.jLabel127.setForeground(new Color(0, 102, 102));
/* 2581 */     this.jLabel127.setHorizontalAlignment(0);
/* 2582 */     this.jLabel127.setText("Cantidad para abonar");
/*      */     
/* 2584 */     this.jLabel128.setFont(new Font("Tahoma", 3, 11));
/* 2585 */     this.jLabel128.setForeground(new Color(15, 87, 51));
/* 2586 */     this.jLabel128.setHorizontalAlignment(4);
/* 2587 */     this.jLabel128.setText("Cantidad ");
/*      */     
/* 2589 */     this.jButton47.setMnemonic('C');
/* 2590 */     this.jButton47.setText("Cerrar");
/* 2591 */     this.jButton47.setToolTipText("Cerrar (Alt+C)");
/* 2592 */     this.jButton47.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2594 */             TarjetaCliente.this.jButton47ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2598 */     this.jLabel129.setText("Ingresa la cantidad que deseas abonar");
/*      */     
/* 2600 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/* 2601 */     this.jFormattedTextField3.setFont(new Font("Tahoma", 1, 14));
/*      */     
/* 2603 */     this.jButton48.setMnemonic('A');
/* 2604 */     this.jButton48.setText("Aceptar");
/* 2605 */     this.jButton48.setToolTipText("Aceptar (Alt+A)");
/* 2606 */     this.jButton48.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2608 */             TarjetaCliente.this.jButton48ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2612 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 2613 */     this.jPanel30.setLayout(jPanel30Layout);
/* 2614 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 2615 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2616 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 2617 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2618 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 2619 */               .addGap(83, 83, 83)
/* 2620 */               .addComponent(this.jButton48, -2, 94, -2)
/* 2621 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2622 */               .addComponent(this.jButton47, -2, 94, -2))
/* 2623 */             .addGroup(jPanel30Layout.createSequentialGroup()
/* 2624 */               .addContainerGap()
/* 2625 */               .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2626 */                 .addComponent(this.jSeparator8)
/* 2627 */                 .addComponent(this.jLabel129, -2, 0, 32767)
/* 2628 */                 .addGroup(jPanel30Layout.createSequentialGroup()
/* 2629 */                   .addComponent(this.jLabel128, -2, 72, -2)
/* 2630 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2631 */                   .addComponent(this.jFormattedTextField3, -2, 184, -2))
/* 2632 */                 .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2633 */                   .addComponent(this.jSeparator30, GroupLayout.Alignment.LEADING)
/* 2634 */                   .addComponent(this.jLabel127, GroupLayout.Alignment.LEADING, -1, 264, 32767)))))
/* 2635 */           .addContainerGap()));
/*      */     
/* 2637 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 2638 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2639 */         .addGroup(jPanel30Layout.createSequentialGroup()
/* 2640 */           .addComponent(this.jLabel127)
/* 2641 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2642 */           .addComponent(this.jSeparator30, -2, 10, -2)
/* 2643 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2644 */           .addComponent(this.jLabel129)
/* 2645 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2646 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2647 */             .addComponent(this.jLabel128)
/* 2648 */             .addComponent(this.jFormattedTextField3, -2, 33, -2))
/* 2649 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2650 */           .addComponent(this.jSeparator8, -2, 10, -2)
/* 2651 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2652 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2653 */             .addComponent(this.jButton47)
/* 2654 */             .addComponent(this.jButton48))
/* 2655 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2658 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 2659 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 2660 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 2661 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2662 */         .addComponent(this.jPanel30, -2, -1, -2));
/*      */     
/* 2664 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 2665 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2666 */         .addComponent(this.jPanel30, -2, -1, -2));
/*      */ 
/*      */     
/* 2669 */     this.jTextArea3.setColumns(20);
/* 2670 */     this.jTextArea3.setEditable(false);
/* 2671 */     this.jTextArea3.setFont(new Font("Monospaced", 0, 11));
/* 2672 */     this.jTextArea3.setLineWrap(true);
/* 2673 */     this.jTextArea3.setRows(5);
/* 2674 */     this.jScrollPane7.setViewportView(this.jTextArea3);
/*      */     
/* 2676 */     this.jLabel40.setText(" Los saldos quedarán de la siguiente manera:");
/*      */     
/* 2678 */     this.jLabel41.setText("Si los datos son correctos presiona el boton 'SI'");
/*      */     
/* 2680 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 2681 */     this.jPanel22.setLayout(jPanel22Layout);
/* 2682 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 2683 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2684 */         .addGroup(jPanel22Layout.createSequentialGroup()
/* 2685 */           .addContainerGap()
/* 2686 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2687 */             .addComponent(this.jScrollPane7, -1, 312, 32767)
/* 2688 */             .addComponent(this.jLabel40, -1, 312, 32767)
/* 2689 */             .addComponent(this.jLabel41, -1, 312, 32767))
/* 2690 */           .addContainerGap()));
/*      */     
/* 2692 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 2693 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2694 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
/* 2695 */           .addComponent(this.jLabel40)
/* 2696 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2697 */           .addComponent(this.jScrollPane7, -1, 107, 32767)
/* 2698 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2699 */           .addComponent(this.jLabel41)));
/*      */ 
/*      */     
/* 2702 */     this.jFormattedTextField4.setText("jFormattedTextField4");
/*      */     
/* 2704 */     this.jDialog9.setTitle("Imprimir estado de cuenta");
/* 2705 */     this.jDialog9.setModal(true);
/*      */     
/* 2707 */     GridBagLayout jPanel31Layout = new GridBagLayout();
/* 2708 */     jPanel31Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 2709 */     jPanel31Layout.rowHeights = new int[] { 0, 5, 0, 5, 0 };
/* 2710 */     this.jPanel31.setLayout(jPanel31Layout);
/*      */     
/* 2712 */     this.jRadioButton1.setFont(new Font("Cantarell", 0, 11));
/* 2713 */     this.jRadioButton1.setText("Todo");
/* 2714 */     this.jRadioButton1.setEnabled(false);
/* 2715 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2717 */             TarjetaCliente.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2720 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 2721 */     gridBagConstraints.gridx = 0;
/* 2722 */     gridBagConstraints.gridy = 4;
/* 2723 */     gridBagConstraints.anchor = 17;
/* 2724 */     gridBagConstraints.weightx = 1.0D;
/* 2725 */     this.jPanel31.add(this.jRadioButton1, gridBagConstraints);
/*      */     
/* 2727 */     this.jRadioButton2.setFont(new Font("Cantarell", 0, 11));
/* 2728 */     this.jRadioButton2.setText("Reporte de Saldos");
/* 2729 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2731 */             TarjetaCliente.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2734 */     gridBagConstraints = new GridBagConstraints();
/* 2735 */     gridBagConstraints.gridx = 0;
/* 2736 */     gridBagConstraints.gridy = 0;
/* 2737 */     gridBagConstraints.anchor = 17;
/* 2738 */     gridBagConstraints.weightx = 1.0D;
/* 2739 */     this.jPanel31.add(this.jRadioButton2, gridBagConstraints);
/*      */     
/* 2741 */     this.jLabel85.setFont(new Font("Cantarell", 0, 11));
/* 2742 */     this.jLabel85.setForeground(this.lc.PRIMARIO2);
/* 2743 */     this.jLabel85.setText("Imprime todo lo que se muestra en pantalla");
/* 2744 */     this.jLabel85.setEnabled(false);
/* 2745 */     gridBagConstraints = new GridBagConstraints();
/* 2746 */     gridBagConstraints.gridx = 2;
/* 2747 */     gridBagConstraints.gridy = 4;
/* 2748 */     gridBagConstraints.anchor = 17;
/* 2749 */     this.jPanel31.add(this.jLabel85, gridBagConstraints);
/*      */     
/* 2751 */     this.jLabel94.setFont(new Font("Cantarell", 0, 11));
/* 2752 */     this.jLabel94.setForeground(this.lc.PRIMARIO2);
/* 2753 */     this.jLabel94.setText("Genera un reporte separado por condiciones de pago");
/* 2754 */     gridBagConstraints = new GridBagConstraints();
/* 2755 */     gridBagConstraints.gridx = 2;
/* 2756 */     gridBagConstraints.gridy = 0;
/* 2757 */     gridBagConstraints.anchor = 17;
/* 2758 */     this.jPanel31.add(this.jLabel94, gridBagConstraints);
/*      */     
/* 2760 */     this.jDateChooser1.setDate(this.fechaActual);
/* 2761 */     this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
/* 2762 */     this.jDateChooser1.setIcon(this.icon);
/* 2763 */     this.jDateChooser1.setMaxSelectableDate(this.fechaActual);
/* 2764 */     gridBagConstraints = new GridBagConstraints();
/* 2765 */     gridBagConstraints.gridx = 0;
/* 2766 */     gridBagConstraints.gridy = 2;
/* 2767 */     gridBagConstraints.fill = 2;
/* 2768 */     gridBagConstraints.insets = new Insets(0, 26, 0, 14);
/* 2769 */     this.jPanel31.add((Component)this.jDateChooser1, gridBagConstraints);
/*      */     
/* 2771 */     this.jLabel42.setFont(new Font("Cantarell", 0, 11));
/* 2772 */     this.jLabel42.setForeground(this.lc.PRIMARIO2);
/* 2773 */     this.jLabel42.setText("Fecha de corte");
/* 2774 */     gridBagConstraints = new GridBagConstraints();
/* 2775 */     gridBagConstraints.gridx = 2;
/* 2776 */     gridBagConstraints.gridy = 2;
/* 2777 */     gridBagConstraints.fill = 2;
/* 2778 */     gridBagConstraints.anchor = 17;
/* 2779 */     this.jPanel31.add(this.jLabel42, gridBagConstraints);
/*      */     
/* 2781 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/* 2782 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/* 2783 */     this.materialButton21.setMnemonic('C');
/* 2784 */     this.materialButton21.setText("Cerrar");
/* 2785 */     this.materialButton21.setToolTipText("Cerrar (Alt+C)");
/* 2786 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/* 2787 */     this.materialButton21.setHorizontalTextPosition(0);
/* 2788 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2790 */             TarjetaCliente.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2794 */     this.materialButton19.setBackground(this.lc.PRIMARIO1);
/* 2795 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/* 2796 */     this.materialButton19.setMnemonic('A');
/* 2797 */     this.materialButton19.setText("Aceptar");
/* 2798 */     this.materialButton19.setToolTipText("Aceptar (Alt+A)");
/* 2799 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/* 2800 */     this.materialButton19.setHorizontalTextPosition(0);
/* 2801 */     this.materialButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2803 */             TarjetaCliente.this.materialButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2807 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 2808 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 2809 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 2810 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2811 */         .addComponent(this.jPanel31, -1, 508, 32767)
/* 2812 */         .addGroup(jDialog9Layout.createSequentialGroup()
/* 2813 */           .addGap(0, 0, 32767)
/* 2814 */           .addComponent((Component)this.materialButton19, -2, 150, -2)
/* 2815 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2816 */           .addComponent((Component)this.materialButton21, -2, 105, -2)));
/*      */     
/* 2818 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 2819 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2820 */         .addGroup(jDialog9Layout.createSequentialGroup()
/* 2821 */           .addComponent(this.jPanel31, -2, 119, -2)
/* 2822 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2823 */           .addGroup(jDialog9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2824 */             .addComponent((Component)this.materialButton21, -2, 38, -2)
/* 2825 */             .addComponent((Component)this.materialButton19, -2, 38, -2))
/* 2826 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2829 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 2830 */     this.jPanel6.setLayout(jPanel6Layout);
/* 2831 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 2832 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2833 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 2834 */           .addContainerGap()
/* 2835 */           .addComponent(this.jSeparator1)
/* 2836 */           .addContainerGap()));
/*      */     
/* 2838 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 2839 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2840 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 2841 */           .addGap(43, 43, 43)
/* 2842 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 2843 */           .addGap(258, 258, 258)));
/*      */ 
/*      */     
/* 2846 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2854 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2859 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2862 */     this.rSTableMetro2.setAltoHead(40);
/* 2863 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2864 */     this.rSTableMetro2.setColorBordeFilas(this.lc.REJILLATABLA);
/* 2865 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 2866 */     this.rSTableMetro2.setColorFilasBackgound2(this.lc.REJILLATABLA);
/* 2867 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 2868 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 2869 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 2870 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 2871 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2872 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2873 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/* 2874 */     this.rSTableMetro2.setRowHeight(18);
/* 2875 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 2876 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 2877 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 2878 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2880 */             TarjetaCliente.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 2883 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2885 */             TarjetaCliente.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 2888 */     this.jScrollPane20.setViewportView((Component)this.rSTableMetro2);
/*      */     
/* 2890 */     this.jDialog10.setTitle("Fecha de corte");
/* 2891 */     this.jDialog10.setModal(true);
/*      */     
/* 2893 */     this.jLabel1.setFont(new Font("Cantarell", 0, 11));
/* 2894 */     this.jLabel1.setText("Selecciona la fecha de corte");
/*      */     
/* 2896 */     this.jDateChooser9.setDate(this.fechaActual);
/* 2897 */     this.jDateChooser9.setDateFormatString("dd/MM/yyyy");
/* 2898 */     this.jDateChooser9.setIcon(this.icon);
/* 2899 */     this.jDateChooser9.setMaxSelectableDate(this.fecha);
/* 2900 */     this.jDateChooser9.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 2902 */     this.materialButton18.setBackground(this.lc.SECUNDARIO1);
/* 2903 */     this.materialButton18.setForeground(new Color(255, 255, 255));
/* 2904 */     this.materialButton18.setMnemonic('C');
/* 2905 */     this.materialButton18.setText("Cerrar");
/* 2906 */     this.materialButton18.setToolTipText("Cerrar (Alt+C)");
/* 2907 */     this.materialButton18.setFont(new Font("Cantarell", 0, 12));
/* 2908 */     this.materialButton18.setHorizontalTextPosition(0);
/* 2909 */     this.materialButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2911 */             TarjetaCliente.this.materialButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2915 */     this.materialButton17.setBackground(this.lc.PRIMARIO1);
/* 2916 */     this.materialButton17.setForeground(new Color(255, 255, 255));
/* 2917 */     this.materialButton17.setMnemonic('A');
/* 2918 */     this.materialButton17.setText("Aceptar");
/* 2919 */     this.materialButton17.setToolTipText("Aceptar (Alt+A)");
/* 2920 */     this.materialButton17.setFont(new Font("Cantarell", 0, 12));
/* 2921 */     this.materialButton17.setHorizontalTextPosition(0);
/* 2922 */     this.materialButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2924 */             TarjetaCliente.this.materialButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2928 */     GroupLayout jDialog10Layout = new GroupLayout(this.jDialog10.getContentPane());
/* 2929 */     this.jDialog10.getContentPane().setLayout(jDialog10Layout);
/* 2930 */     jDialog10Layout.setHorizontalGroup(jDialog10Layout
/* 2931 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2932 */         .addGroup(jDialog10Layout.createSequentialGroup()
/* 2933 */           .addContainerGap()
/* 2934 */           .addGroup(jDialog10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2935 */             .addGroup(jDialog10Layout.createSequentialGroup()
/* 2936 */               .addComponent((Component)this.materialButton17, -2, 150, -2)
/* 2937 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2938 */               .addComponent((Component)this.materialButton18, -2, 105, -2))
/* 2939 */             .addGroup(jDialog10Layout.createSequentialGroup()
/* 2940 */               .addComponent(this.jLabel1, -2, 140, -2)
/* 2941 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2942 */               .addComponent((Component)this.jDateChooser9, -2, 205, -2)))
/* 2943 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2945 */     jDialog10Layout.setVerticalGroup(jDialog10Layout
/* 2946 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2947 */         .addGroup(jDialog10Layout.createSequentialGroup()
/* 2948 */           .addContainerGap()
/* 2949 */           .addGroup(jDialog10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2950 */             .addComponent((Component)this.jDateChooser9, -1, -1, 32767)
/* 2951 */             .addComponent(this.jLabel1, -1, -1, 32767))
/* 2952 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2953 */           .addGroup(jDialog10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2954 */             .addComponent((Component)this.materialButton18, -2, 38, -2)
/* 2955 */             .addComponent((Component)this.materialButton17, -2, 38, -2))
/* 2956 */           .addContainerGap(45, 32767)));
/*      */ 
/*      */     
/* 2959 */     this.jDialog11.setTitle("Version 3.2 vencido");
/*      */     
/* 2961 */     this.TablaGral.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2972 */     this.jScrollPane2.setViewportView(this.TablaGral);
/*      */     
/* 2974 */     this.jLabel59.setText("Versión 3.2 - Vencido");
/*      */     
/* 2976 */     this.jLabel61.setText("jLabel61");
/*      */     
/* 2978 */     GroupLayout jDialog11Layout = new GroupLayout(this.jDialog11.getContentPane());
/* 2979 */     this.jDialog11.getContentPane().setLayout(jDialog11Layout);
/* 2980 */     jDialog11Layout.setHorizontalGroup(jDialog11Layout
/* 2981 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2982 */         .addGroup(jDialog11Layout.createSequentialGroup()
/* 2983 */           .addGroup(jDialog11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2984 */             .addGroup(jDialog11Layout.createSequentialGroup()
/* 2985 */               .addContainerGap()
/* 2986 */               .addComponent(this.jScrollPane2, -1, 819, 32767))
/* 2987 */             .addGroup(jDialog11Layout.createSequentialGroup()
/* 2988 */               .addGroup(jDialog11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2989 */                 .addGroup(jDialog11Layout.createSequentialGroup()
/* 2990 */                   .addGap(148, 148, 148)
/* 2991 */                   .addComponent(this.jLabel59, -2, 272, -2))
/* 2992 */                 .addGroup(jDialog11Layout.createSequentialGroup()
/* 2993 */                   .addContainerGap()
/* 2994 */                   .addComponent(this.jLabel61, -2, 219, -2)))
/* 2995 */               .addGap(0, 0, 32767)))
/* 2996 */           .addContainerGap()));
/*      */     
/* 2998 */     jDialog11Layout.setVerticalGroup(jDialog11Layout
/* 2999 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3000 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog11Layout.createSequentialGroup()
/* 3001 */           .addContainerGap()
/* 3002 */           .addComponent(this.jLabel59)
/* 3003 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3004 */           .addComponent(this.jScrollPane2, -1, 450, 32767)
/* 3005 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3006 */           .addComponent(this.jLabel61)
/* 3007 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3010 */     this.jDialog12.setTitle("Version 3.2 por vencer");
/*      */     
/* 3012 */     this.TablaGral1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3023 */     this.jScrollPane3.setViewportView(this.TablaGral1);
/*      */     
/* 3025 */     this.jLabel60.setText("Versión 3.2 por vencer");
/*      */     
/* 3027 */     this.jLabel63.setText("jLabel63");
/*      */     
/* 3029 */     GroupLayout jDialog12Layout = new GroupLayout(this.jDialog12.getContentPane());
/* 3030 */     this.jDialog12.getContentPane().setLayout(jDialog12Layout);
/* 3031 */     jDialog12Layout.setHorizontalGroup(jDialog12Layout
/* 3032 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3033 */         .addGroup(jDialog12Layout.createSequentialGroup()
/* 3034 */           .addGroup(jDialog12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3035 */             .addGroup(jDialog12Layout.createSequentialGroup()
/* 3036 */               .addContainerGap()
/* 3037 */               .addComponent(this.jScrollPane3, -1, 819, 32767))
/* 3038 */             .addGroup(jDialog12Layout.createSequentialGroup()
/* 3039 */               .addGroup(jDialog12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3040 */                 .addGroup(jDialog12Layout.createSequentialGroup()
/* 3041 */                   .addGap(148, 148, 148)
/* 3042 */                   .addComponent(this.jLabel60, -2, 272, -2))
/* 3043 */                 .addGroup(jDialog12Layout.createSequentialGroup()
/* 3044 */                   .addContainerGap()
/* 3045 */                   .addComponent(this.jLabel63, -2, 216, -2)))
/* 3046 */               .addGap(0, 0, 32767)))
/* 3047 */           .addContainerGap()));
/*      */     
/* 3049 */     jDialog12Layout.setVerticalGroup(jDialog12Layout
/* 3050 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3051 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog12Layout.createSequentialGroup()
/* 3052 */           .addContainerGap()
/* 3053 */           .addComponent(this.jLabel60)
/* 3054 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3055 */           .addComponent(this.jScrollPane3, -1, 450, 32767)
/* 3056 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3057 */           .addComponent(this.jLabel63)
/* 3058 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3061 */     this.jDialog13.setTitle("Version 3.3 vencido");
/*      */     
/* 3063 */     this.TablaGral2.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3074 */     this.jScrollPane4.setViewportView(this.TablaGral2);
/*      */     
/* 3076 */     this.jLabel64.setText("Versión 3.3 - Vencido");
/*      */     
/* 3078 */     this.jLabel65.setText("jLabel61");
/*      */     
/* 3080 */     GroupLayout jDialog13Layout = new GroupLayout(this.jDialog13.getContentPane());
/* 3081 */     this.jDialog13.getContentPane().setLayout(jDialog13Layout);
/* 3082 */     jDialog13Layout.setHorizontalGroup(jDialog13Layout
/* 3083 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3084 */         .addGroup(jDialog13Layout.createSequentialGroup()
/* 3085 */           .addGroup(jDialog13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3086 */             .addGroup(jDialog13Layout.createSequentialGroup()
/* 3087 */               .addContainerGap()
/* 3088 */               .addComponent(this.jScrollPane4, -1, 819, 32767))
/* 3089 */             .addGroup(jDialog13Layout.createSequentialGroup()
/* 3090 */               .addGroup(jDialog13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3091 */                 .addGroup(jDialog13Layout.createSequentialGroup()
/* 3092 */                   .addGap(148, 148, 148)
/* 3093 */                   .addComponent(this.jLabel64, -2, 272, -2))
/* 3094 */                 .addGroup(jDialog13Layout.createSequentialGroup()
/* 3095 */                   .addContainerGap()
/* 3096 */                   .addComponent(this.jLabel65, -2, 219, -2)))
/* 3097 */               .addGap(0, 0, 32767)))
/* 3098 */           .addContainerGap()));
/*      */     
/* 3100 */     jDialog13Layout.setVerticalGroup(jDialog13Layout
/* 3101 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3102 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog13Layout.createSequentialGroup()
/* 3103 */           .addContainerGap()
/* 3104 */           .addComponent(this.jLabel64)
/* 3105 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3106 */           .addComponent(this.jScrollPane4, -1, 450, 32767)
/* 3107 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3108 */           .addComponent(this.jLabel65)
/* 3109 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3112 */     this.jDialog14.setTitle("Version 3.3 por vencer");
/*      */     
/* 3114 */     this.TablaGral3.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3125 */     this.jScrollPane5.setViewportView(this.TablaGral3);
/*      */     
/* 3127 */     this.jLabel66.setText("Versión 3.3 - Por vencer");
/*      */     
/* 3129 */     this.jLabel67.setText("jLabel61");
/*      */     
/* 3131 */     GroupLayout jDialog14Layout = new GroupLayout(this.jDialog14.getContentPane());
/* 3132 */     this.jDialog14.getContentPane().setLayout(jDialog14Layout);
/* 3133 */     jDialog14Layout.setHorizontalGroup(jDialog14Layout
/* 3134 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3135 */         .addGroup(jDialog14Layout.createSequentialGroup()
/* 3136 */           .addGroup(jDialog14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3137 */             .addGroup(jDialog14Layout.createSequentialGroup()
/* 3138 */               .addContainerGap()
/* 3139 */               .addComponent(this.jScrollPane5, -1, 819, 32767))
/* 3140 */             .addGroup(jDialog14Layout.createSequentialGroup()
/* 3141 */               .addGroup(jDialog14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3142 */                 .addGroup(jDialog14Layout.createSequentialGroup()
/* 3143 */                   .addGap(148, 148, 148)
/* 3144 */                   .addComponent(this.jLabel66, -2, 272, -2))
/* 3145 */                 .addGroup(jDialog14Layout.createSequentialGroup()
/* 3146 */                   .addContainerGap()
/* 3147 */                   .addComponent(this.jLabel67, -2, 219, -2)))
/* 3148 */               .addGap(0, 0, 32767)))
/* 3149 */           .addContainerGap()));
/*      */     
/* 3151 */     jDialog14Layout.setVerticalGroup(jDialog14Layout
/* 3152 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3153 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog14Layout.createSequentialGroup()
/* 3154 */           .addContainerGap()
/* 3155 */           .addComponent(this.jLabel66)
/* 3156 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3157 */           .addComponent(this.jScrollPane5, -1, 450, 32767)
/* 3158 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3159 */           .addComponent(this.jLabel67)
/* 3160 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3163 */     this.jDialog15.setTitle("Resumen");
/*      */     
/* 3165 */     this.TablaAux.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3176 */     this.jScrollPane6.setViewportView(this.TablaAux);
/*      */     
/* 3178 */     this.jLabel68.setText("Todos");
/*      */     
/* 3180 */     this.jLabel69.setText("jLabel61");
/*      */     
/* 3182 */     this.jLabel72.setHorizontalAlignment(4);
/* 3183 */     this.jLabel72.setText("jLabel72");
/*      */     
/* 3185 */     this.jLabel82.setHorizontalAlignment(4);
/* 3186 */     this.jLabel82.setText("jLabel82");
/*      */     
/* 3188 */     this.jLabel83.setHorizontalAlignment(4);
/* 3189 */     this.jLabel83.setText("jLabel83");
/*      */     
/* 3191 */     GroupLayout jDialog15Layout = new GroupLayout(this.jDialog15.getContentPane());
/* 3192 */     this.jDialog15.getContentPane().setLayout(jDialog15Layout);
/* 3193 */     jDialog15Layout.setHorizontalGroup(jDialog15Layout
/* 3194 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3195 */         .addGroup(jDialog15Layout.createSequentialGroup()
/* 3196 */           .addGroup(jDialog15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3197 */             .addGroup(jDialog15Layout.createSequentialGroup()
/* 3198 */               .addGroup(jDialog15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3199 */                 .addGroup(jDialog15Layout.createSequentialGroup()
/* 3200 */                   .addGap(148, 148, 148)
/* 3201 */                   .addComponent(this.jLabel68, -2, 272, -2))
/* 3202 */                 .addGroup(jDialog15Layout.createSequentialGroup()
/* 3203 */                   .addContainerGap()
/* 3204 */                   .addComponent(this.jLabel69, -2, 130, -2)
/* 3205 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3206 */                   .addComponent(this.jLabel72, -2, 166, -2)
/* 3207 */                   .addGap(83, 83, 83)
/* 3208 */                   .addComponent(this.jLabel82, -2, 181, -2)))
/* 3209 */               .addGap(0, 0, 32767))
/* 3210 */             .addGroup(jDialog15Layout.createSequentialGroup()
/* 3211 */               .addContainerGap()
/* 3212 */               .addGroup(jDialog15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3213 */                 .addComponent(this.jScrollPane6, -1, 819, 32767)
/* 3214 */                 .addGroup(GroupLayout.Alignment.TRAILING, jDialog15Layout.createSequentialGroup()
/* 3215 */                   .addGap(0, 0, 32767)
/* 3216 */                   .addComponent(this.jLabel83, -2, 217, -2)))))
/* 3217 */           .addContainerGap()));
/*      */     
/* 3219 */     jDialog15Layout.setVerticalGroup(jDialog15Layout
/* 3220 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3221 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog15Layout.createSequentialGroup()
/* 3222 */           .addContainerGap()
/* 3223 */           .addComponent(this.jLabel68)
/* 3224 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3225 */           .addComponent(this.jScrollPane6, -1, 450, 32767)
/* 3226 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3227 */           .addGroup(jDialog15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3228 */             .addComponent(this.jLabel69)
/* 3229 */             .addComponent(this.jLabel72)
/* 3230 */             .addComponent(this.jLabel82)
/* 3231 */             .addComponent(this.jLabel83))
/* 3232 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3235 */     this.jDialog16.setTitle("Resumen Saldos");
/*      */     
/* 3237 */     this.TablaAux1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3248 */     this.jScrollPane8.setViewportView(this.TablaAux1);
/*      */     
/* 3250 */     this.jLabel91.setText("Todos");
/*      */     
/* 3252 */     this.jPanel48.setLayout(new GridLayout(1, 6, 30, 0));
/*      */     
/* 3254 */     this.jLabel92.setFont(new Font("Cantarell", 0, 10));
/* 3255 */     this.jLabel92.setText("jLabel92");
/* 3256 */     this.jPanel48.add(this.jLabel92);
/*      */     
/* 3258 */     this.jLabel93.setFont(new Font("Cantarell", 0, 10));
/* 3259 */     this.jLabel93.setHorizontalAlignment(4);
/* 3260 */     this.jLabel93.setText("jLabel93");
/* 3261 */     this.jPanel48.add(this.jLabel93);
/*      */     
/* 3263 */     this.jLabel95.setFont(new Font("Cantarell", 0, 10));
/* 3264 */     this.jLabel95.setHorizontalAlignment(4);
/* 3265 */     this.jLabel95.setText("jLabel95");
/* 3266 */     this.jPanel48.add(this.jLabel95);
/*      */     
/* 3268 */     this.jLabel96.setFont(new Font("Cantarell", 0, 10));
/* 3269 */     this.jLabel96.setHorizontalAlignment(4);
/* 3270 */     this.jLabel96.setText("jLabel96");
/* 3271 */     this.jPanel48.add(this.jLabel96);
/*      */     
/* 3273 */     this.jLabel97.setFont(new Font("Cantarell", 0, 10));
/* 3274 */     this.jLabel97.setHorizontalAlignment(4);
/* 3275 */     this.jLabel97.setText("jLabel97");
/* 3276 */     this.jPanel48.add(this.jLabel97);
/*      */     
/* 3278 */     this.jLabel98.setFont(new Font("Cantarell", 0, 10));
/* 3279 */     this.jLabel98.setHorizontalAlignment(4);
/* 3280 */     this.jLabel98.setText("jLabel98");
/* 3281 */     this.jPanel48.add(this.jLabel98);
/*      */     
/* 3283 */     GroupLayout jDialog16Layout = new GroupLayout(this.jDialog16.getContentPane());
/* 3284 */     this.jDialog16.getContentPane().setLayout(jDialog16Layout);
/* 3285 */     jDialog16Layout.setHorizontalGroup(jDialog16Layout
/* 3286 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3287 */         .addGroup(jDialog16Layout.createSequentialGroup()
/* 3288 */           .addGroup(jDialog16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3289 */             .addGroup(jDialog16Layout.createSequentialGroup()
/* 3290 */               .addGap(148, 148, 148)
/* 3291 */               .addComponent(this.jLabel91, -2, 272, -2)
/* 3292 */               .addGap(0, 405, 32767))
/* 3293 */             .addGroup(jDialog16Layout.createSequentialGroup()
/* 3294 */               .addContainerGap()
/* 3295 */               .addComponent(this.jScrollPane8, -1, 819, 32767))
/* 3296 */             .addComponent(this.jPanel48, GroupLayout.Alignment.TRAILING, -1, -1, 32767))
/* 3297 */           .addContainerGap()));
/*      */     
/* 3299 */     jDialog16Layout.setVerticalGroup(jDialog16Layout
/* 3300 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3301 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog16Layout.createSequentialGroup()
/* 3302 */           .addContainerGap()
/* 3303 */           .addComponent(this.jLabel91)
/* 3304 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3305 */           .addComponent(this.jScrollPane8, -1, 488, 32767)
/* 3306 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3307 */           .addComponent(this.jPanel48, -2, -1, -2)
/* 3308 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3311 */     this.jDialog17.setTitle("Tipo de reporte");
/* 3312 */     this.jDialog17.setModal(true);
/*      */     
/* 3314 */     this.materialButton22.setBackground(this.lc.SECUNDARIO1);
/* 3315 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/* 3316 */     this.materialButton22.setMnemonic('C');
/* 3317 */     this.materialButton22.setText("Cerrar");
/* 3318 */     this.materialButton22.setToolTipText("Cerrar (Alt+C)");
/* 3319 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/* 3320 */     this.materialButton22.setHorizontalTextPosition(0);
/* 3321 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3323 */             TarjetaCliente.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3327 */     this.materialButton20.setBackground(this.lc.PRIMARIO1);
/* 3328 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/* 3329 */     this.materialButton20.setMnemonic('A');
/* 3330 */     this.materialButton20.setText("Aceptar");
/* 3331 */     this.materialButton20.setToolTipText("Aceptar (Alt+A)");
/* 3332 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/* 3333 */     this.materialButton20.setHorizontalTextPosition(0);
/* 3334 */     this.materialButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3336 */             TarjetaCliente.this.materialButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3340 */     this.jPanel49.setLayout(new GridLayout(2, 0, 0, 6));
/*      */     
/* 3342 */     this.jRadioButton6.setText("Reporte de cuentas por cobrar (por Mes)");
/* 3343 */     this.jPanel49.add(this.jRadioButton6);
/*      */     
/* 3345 */     this.jRadioButton7.setText("Reporte de cuentas cobrar (por Año)");
/* 3346 */     this.jPanel49.add(this.jRadioButton7);
/*      */     
/* 3348 */     GroupLayout jDialog17Layout = new GroupLayout(this.jDialog17.getContentPane());
/* 3349 */     this.jDialog17.getContentPane().setLayout(jDialog17Layout);
/* 3350 */     jDialog17Layout.setHorizontalGroup(jDialog17Layout
/* 3351 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3352 */         .addGroup(jDialog17Layout.createSequentialGroup()
/* 3353 */           .addGap(0, 247, 32767)
/* 3354 */           .addComponent((Component)this.materialButton20, -2, 150, -2)
/* 3355 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3356 */           .addComponent((Component)this.materialButton22, -2, 105, -2))
/* 3357 */         .addComponent(this.jPanel49, -1, -1, 32767));
/*      */     
/* 3359 */     jDialog17Layout.setVerticalGroup(jDialog17Layout
/* 3360 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3361 */         .addGroup(jDialog17Layout.createSequentialGroup()
/* 3362 */           .addComponent(this.jPanel49, -1, -1, 32767)
/* 3363 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3364 */           .addGroup(jDialog17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3365 */             .addComponent((Component)this.materialButton22, -2, 38, -2)
/* 3366 */             .addComponent((Component)this.materialButton20, -2, 38, -2))
/* 3367 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3370 */     this.jLabel43.setFont(new Font("Cantarell", 0, 11));
/* 3371 */     this.jLabel43.setText("Selecciona el tipo de moneda");
/*      */     
/* 3373 */     this.jComboBox12.setBackground(new Color(244, 244, 244));
/* 3374 */     this.jComboBox12.setModel(new DefaultComboBoxModel<>(new String[] { "Moneda" }));
/* 3375 */     this.jComboBox12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3377 */             TarjetaCliente.this.jComboBox12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3381 */     this.jDialog18.setTitle("Selecciona el periodo");
/* 3382 */     this.jDialog18.setModal(true);
/*      */     
/* 3384 */     this.materialButton23.setBackground(this.lc.SECUNDARIO1);
/* 3385 */     this.materialButton23.setForeground(new Color(255, 255, 255));
/* 3386 */     this.materialButton23.setMnemonic('C');
/* 3387 */     this.materialButton23.setText("Cerrar");
/* 3388 */     this.materialButton23.setToolTipText("Cerrar (Alt+C)");
/* 3389 */     this.materialButton23.setFont(new Font("Cantarell", 0, 12));
/* 3390 */     this.materialButton23.setHorizontalTextPosition(0);
/* 3391 */     this.materialButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3393 */             TarjetaCliente.this.materialButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3397 */     this.materialButton24.setBackground(this.lc.PRIMARIO1);
/* 3398 */     this.materialButton24.setForeground(new Color(255, 255, 255));
/* 3399 */     this.materialButton24.setMnemonic('A');
/* 3400 */     this.materialButton24.setText("Aceptar");
/* 3401 */     this.materialButton24.setToolTipText("Aceptar (Alt+A)");
/* 3402 */     this.materialButton24.setFont(new Font("Cantarell", 0, 12));
/* 3403 */     this.materialButton24.setHorizontalTextPosition(0);
/* 3404 */     this.materialButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3406 */             TarjetaCliente.this.materialButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3410 */     this.jLabel99.setText("Periodo");
/*      */     
/* 3412 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "TODO EL AÑO", "ENERO - JUNIO", "JULIO - DICIEMBRE" }));
/*      */     
/* 3414 */     this.jLabel100.setText("Año");
/*      */     
/* 3416 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/* 3417 */     this.jPanel50.setLayout(jPanel50Layout);
/* 3418 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/* 3419 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3420 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 3421 */           .addContainerGap()
/* 3422 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 3423 */             .addComponent(this.jLabel100, -1, -1, 32767)
/* 3424 */             .addComponent(this.jLabel99, -1, 164, 32767))
/* 3425 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3426 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3427 */             .addComponent(this.jComboBox2, 0, 237, 32767)
/* 3428 */             .addComponent(this.jSpinner1))
/* 3429 */           .addContainerGap()));
/*      */     
/* 3431 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/* 3432 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3433 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 3434 */           .addContainerGap()
/* 3435 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3436 */             .addComponent(this.jLabel99)
/* 3437 */             .addComponent(this.jComboBox2, -2, -1, -2))
/* 3438 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3439 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3440 */             .addComponent(this.jLabel100)
/* 3441 */             .addComponent(this.jSpinner1, -2, -1, -2))
/* 3442 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3445 */     GroupLayout jDialog18Layout = new GroupLayout(this.jDialog18.getContentPane());
/* 3446 */     this.jDialog18.getContentPane().setLayout(jDialog18Layout);
/* 3447 */     jDialog18Layout.setHorizontalGroup(jDialog18Layout
/* 3448 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3449 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog18Layout.createSequentialGroup()
/* 3450 */           .addComponent((Component)this.materialButton24, -2, 150, -2)
/* 3451 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3452 */           .addComponent((Component)this.materialButton23, -2, 105, -2))
/* 3453 */         .addComponent(this.jPanel50, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/* 3455 */     jDialog18Layout.setVerticalGroup(jDialog18Layout
/* 3456 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3457 */         .addGroup(jDialog18Layout.createSequentialGroup()
/* 3458 */           .addComponent(this.jPanel50, -1, -1, 32767)
/* 3459 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3460 */           .addGroup(jDialog18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3461 */             .addComponent((Component)this.materialButton23, -2, 38, -2)
/* 3462 */             .addComponent((Component)this.materialButton24, -2, 38, -2))
/* 3463 */           .addGap(22, 22, 22)));
/*      */ 
/*      */     
/* 3466 */     this.jDialog19.setTitle("Selecciona el periodo");
/* 3467 */     this.jDialog19.setModal(true);
/*      */     
/* 3469 */     this.jLabel101.setText("REPORTE DE TARJETAS DEUDOR");
/*      */     
/* 3471 */     this.jTable3.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3482 */     this.jScrollPane12.setViewportView(this.jTable3);
/*      */     
/* 3484 */     this.jLabel102.setText("Registros encontrados");
/*      */     
/* 3486 */     this.jLabel103.setText("jLabel103");
/*      */     
/* 3488 */     this.jLabel104.setText("Año");
/*      */     
/* 3490 */     this.jLabel105.setText("2005");
/*      */     
/* 3492 */     GroupLayout jDialog19Layout = new GroupLayout(this.jDialog19.getContentPane());
/* 3493 */     this.jDialog19.getContentPane().setLayout(jDialog19Layout);
/* 3494 */     jDialog19Layout.setHorizontalGroup(jDialog19Layout
/* 3495 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3496 */         .addComponent(this.jLabel101, -1, -1, 32767)
/* 3497 */         .addComponent(this.jScrollPane12, -1, 674, 32767)
/* 3498 */         .addGroup(jDialog19Layout.createSequentialGroup()
/* 3499 */           .addComponent(this.jLabel102, -2, 221, -2)
/* 3500 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3501 */           .addComponent(this.jLabel103, -2, 95, -2)
/* 3502 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3503 */           .addComponent(this.jLabel104, -2, 73, -2)
/* 3504 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3505 */           .addComponent(this.jLabel105)
/* 3506 */           .addGap(0, 0, 32767)));
/*      */     
/* 3508 */     jDialog19Layout.setVerticalGroup(jDialog19Layout
/* 3509 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3510 */         .addGroup(jDialog19Layout.createSequentialGroup()
/* 3511 */           .addComponent(this.jLabel101)
/* 3512 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3513 */           .addComponent(this.jScrollPane12, -2, 369, -2)
/* 3514 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 85, 32767)
/* 3515 */           .addGroup(jDialog19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3516 */             .addComponent(this.jLabel102)
/* 3517 */             .addComponent(this.jLabel103)
/* 3518 */             .addComponent(this.jLabel104)
/* 3519 */             .addComponent(this.jLabel105))
/* 3520 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3523 */     GroupLayout jPanel51Layout = new GroupLayout(this.jPanel51);
/* 3524 */     this.jPanel51.setLayout(jPanel51Layout);
/* 3525 */     jPanel51Layout.setHorizontalGroup(jPanel51Layout
/* 3526 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3527 */         .addGap(0, 1021, 32767));
/*      */     
/* 3529 */     jPanel51Layout.setVerticalGroup(jPanel51Layout
/* 3530 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3531 */         .addGap(0, 615, 32767));
/*      */ 
/*      */     
/* 3534 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/* 3535 */     this.jPanel52.setLayout(jPanel52Layout);
/* 3536 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/* 3537 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3538 */         .addGap(0, 751, 32767));
/*      */     
/* 3540 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/* 3541 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3542 */         .addGap(0, 393, 32767));
/*      */ 
/*      */     
/* 3545 */     this.jPanel13.setBackground(new Color(255, 255, 255));
/*      */     
/* 3547 */     this.jPanel42.setBackground(this.lc.SECUNDARIO1);
/*      */     
/* 3549 */     this.jLabel3.setFont(new Font("Cantarell", 1, 22));
/* 3550 */     this.jLabel3.setForeground(this.lc.PRIMARIO2);
/* 3551 */     this.jLabel3.setHorizontalAlignment(0);
/* 3552 */     this.jLabel3.setText("Organizar Tarjetas Deudor");
/*      */     
/* 3554 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/* 3555 */     this.jPanel42.setLayout(jPanel42Layout);
/* 3556 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/* 3557 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3558 */         .addComponent(this.jLabel3, -1, -1, 32767));
/*      */     
/* 3560 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/* 3561 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3562 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 3563 */           .addContainerGap()
/* 3564 */           .addComponent(this.jLabel3)
/* 3565 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3568 */     this.jLabel15.setFont(new Font("Cantarell", 0, 11));
/* 3569 */     this.jLabel15.setText("Búsqueda por cliente");
/*      */     
/* 3571 */     this.jPanel44.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 3573 */     this.jPanel43.setBackground(this.lc.SECUNDARIO2);
/*      */     
/* 3575 */     this.jPanel45.setLayout(new GridLayout(1, 0));
/*      */     
/* 3577 */     this.jLabel49.setFont(new Font("Cantarell", 1, 22));
/* 3578 */     this.jLabel49.setForeground(this.lc.PRIMARIO1);
/* 3579 */     this.jLabel49.setHorizontalAlignment(4);
/* 3580 */     this.jLabel49.setText("t");
/* 3581 */     this.jLabel49.setBorder(BorderFactory.createEtchedBorder());
/* 3582 */     this.jPanel45.add(this.jLabel49);
/*      */     
/* 3584 */     this.jPanel46.setBackground(this.lc.SECUNDARIO2);
/* 3585 */     this.jPanel46.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/* 3587 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 3588 */     this.jButton2.setMnemonic('N');
/* 3589 */     this.jButton2.setText("Nueva");
/* 3590 */     this.jButton2.setToolTipText("Nueva Tarjeta (Alt+N)");
/* 3591 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3593 */             TarjetaCliente.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3596 */     this.jPanel46.add(this.jButton2);
/*      */     
/* 3598 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 3599 */     this.jButton10.setMnemonic('V');
/* 3600 */     this.jButton10.setText("Ver Detalle");
/* 3601 */     this.jButton10.setToolTipText("Ver Detalle (Alt+V)");
/* 3602 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3604 */             TarjetaCliente.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3607 */     this.jPanel46.add(this.jButton10);
/*      */     
/* 3609 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 3610 */     this.jButton9.setMnemonic('G');
/* 3611 */     this.jButton9.setText("Guardar Reporte");
/* 3612 */     this.jButton9.setToolTipText("Guardar Reporte (Alt+G)");
/* 3613 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3615 */             TarjetaCliente.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3618 */     this.jPanel46.add(this.jButton9);
/*      */     
/* 3620 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 3621 */     this.jButton4.setMnemonic('I');
/* 3622 */     this.jButton4.setText("Imprimir");
/* 3623 */     this.jButton4.setToolTipText("Imprimir");
/* 3624 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3626 */             TarjetaCliente.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3629 */     this.jPanel46.add(this.jButton4);
/*      */     
/* 3631 */     this.jPanel47.setBackground(this.lc.SECUNDARIO2);
/* 3632 */     this.jPanel47.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 3634 */     this.jLabel58.setFont(new Font("Cantarell", 0, 13));
/* 3635 */     this.jLabel58.setForeground(this.lc.SECUNDARIO1);
/* 3636 */     this.jLabel58.setHorizontalAlignment(4);
/* 3637 */     this.jLabel58.setText("Total: ");
/* 3638 */     this.jPanel47.add(this.jLabel58);
/*      */     
/* 3640 */     this.jLabel48.setFont(new Font("Cantarell", 1, 13));
/* 3641 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 3642 */     this.jLabel48.setHorizontalAlignment(2);
/* 3643 */     this.jLabel48.setText("t");
/* 3644 */     this.jPanel47.add(this.jLabel48);
/*      */     
/* 3646 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 3647 */     this.jPanel43.setLayout(jPanel43Layout);
/* 3648 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 3649 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3650 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
/* 3651 */           .addComponent(this.jPanel47, -2, 110, -2)
/* 3652 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, 32767)
/* 3653 */           .addComponent(this.jPanel46, -2, 550, -2)
/* 3654 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3655 */           .addComponent(this.jPanel45, -2, 211, -2)
/* 3656 */           .addGap(12, 12, 12)));
/*      */     
/* 3658 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 3659 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3660 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 3661 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3662 */             .addComponent(this.jPanel45, -1, -1, 32767)
/* 3663 */             .addComponent(this.jPanel46, -1, -1, 32767)
/* 3664 */             .addComponent(this.jPanel47, -2, 36, -2))
/* 3665 */           .addGap(0, 6, 32767)));
/*      */ 
/*      */     
/* 3668 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3676 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3681 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3684 */     this.rSTableMetro1.setAltoHead(40);
/* 3685 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 3686 */     this.rSTableMetro1.setColorBordeFilas(this.lc.REJILLATABLA);
/* 3687 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 3688 */     this.rSTableMetro1.setColorFilasBackgound2(this.lc.REJILLATABLA);
/* 3689 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 3690 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 3691 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 3692 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 3693 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 3694 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 3695 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 3696 */     this.rSTableMetro1.setRowHeight(18);
/* 3697 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 3698 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 3699 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 3700 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3702 */             TarjetaCliente.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 3705 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3707 */             TarjetaCliente.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 3710 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/*      */     
/* 3712 */     GroupLayout jPanel44Layout = new GroupLayout(this.jPanel44);
/* 3713 */     this.jPanel44.setLayout(jPanel44Layout);
/* 3714 */     jPanel44Layout.setHorizontalGroup(jPanel44Layout
/* 3715 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3716 */         .addComponent(this.jPanel43, -1, -1, 32767)
/* 3717 */         .addComponent(this.jScrollPane13));
/*      */     
/* 3719 */     jPanel44Layout.setVerticalGroup(jPanel44Layout
/* 3720 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3721 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
/* 3722 */           .addComponent(this.jScrollPane13, -1, 325, 32767)
/* 3723 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3724 */           .addComponent(this.jPanel43, -2, -1, -2)));
/*      */ 
/*      */     
/* 3727 */     this.jLabel70.setText("Activar Fechas");
/* 3728 */     this.jLabel70.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3730 */             TarjetaCliente.this.jLabel70MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/* 3734 */     this.metroTextBox1.setSelectionColor(new Color(237, 107, 107));
/* 3735 */     this.metroTextBox1.addCaretListener(new CaretListener() {
/*      */           public void caretUpdate(CaretEvent evt) {
/* 3737 */             TarjetaCliente.this.metroTextBox1CaretUpdate(evt);
/*      */           }
/*      */         });
/* 3740 */     this.metroTextBox1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3742 */             TarjetaCliente.this.metroTextBox1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 3746 */     this.jComboBox1.setBackground(new Color(255, 255, 255));
/* 3747 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "MONEDA", "TODO EN MXN", "USD CONVERTIDOS", "MXN", "USD" }));
/* 3748 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3750 */             TarjetaCliente.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3754 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 3755 */     this.jPanel13.setLayout(jPanel13Layout);
/* 3756 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 3757 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3758 */         .addComponent(this.jPanel42, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 3759 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 3760 */           .addContainerGap()
/* 3761 */           .addComponent(this.jLabel15, -2, 149, -2)
/* 3762 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3763 */           .addComponent((Component)this.metroTextBox1, -2, 300, -2)
/* 3764 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3765 */           .addComponent(this.jComboBox1, -2, 145, -2)
/* 3766 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3767 */           .addComponent(this.jLabel70, -2, 128, -2)
/* 3768 */           .addContainerGap())
/* 3769 */         .addComponent(this.jPanel44, -1, -1, 32767));
/*      */     
/* 3771 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 3772 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3773 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 3774 */           .addComponent(this.jPanel42, -2, -1, -2)
/* 3775 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3776 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3777 */             .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3778 */               .addComponent(this.jLabel15)
/* 3779 */               .addComponent((Component)this.metroTextBox1, -2, -1, -2)
/* 3780 */               .addComponent(this.jComboBox1, -2, -1, -2))
/* 3781 */             .addComponent(this.jLabel70))
/* 3782 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3783 */           .addComponent(this.jPanel44, -1, -1, 32767)));
/*      */ 
/*      */     
/* 3786 */     GroupLayout layout = new GroupLayout(this);
/* 3787 */     setLayout(layout);
/* 3788 */     layout.setHorizontalGroup(layout
/* 3789 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3790 */         .addGap(0, 949, 32767)
/* 3791 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3792 */           .addComponent(this.jPanel13, -1, -1, 32767)));
/*      */     
/* 3794 */     layout.setVerticalGroup(layout
/* 3795 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3796 */         .addGap(0, 449, 32767)
/* 3797 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3798 */           .addComponent(this.jPanel13, -1, -1, 32767)));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 3803 */     this.modelo = new DefaultTableModel();
/* 3804 */     this.rSTableMetro4.setModel(this.modelo);
/* 3805 */     this.modelo.addColumn("Clave");
/* 3806 */     this.modelo.addColumn("Nombre Completo");
/* 3807 */     this.modelo.addColumn("Nombre Comercial");
/* 3808 */     this.rSTableMetro4.setShowVerticalLines(false);
/* 3809 */     this.rSTableMetro4.setSelectionMode(0);
/* 3810 */     this.rSTableMetro4.setAutoCreateRowSorter(true);
/* 3811 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 3812 */     this.rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 3813 */     this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(60);
/* 3814 */     consultar2();
/* 3815 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 3819 */     verTarjeta();
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 3823 */     int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas mover todas las cuentas a la tabla de la derecha?", "Mover Todos", 0, 3, this.PREG);
/* 3824 */     if (res == 0) {
/* 3825 */       this.modelo = new DefaultTableModel();
/* 3826 */       this.rSTableMetro4.setModel(this.modelo);
/* 3827 */       this.modelo.addColumn("Clave");
/* 3828 */       this.modelo.addColumn("Nombre Completo");
/* 3829 */       this.rSTableMetro4.setShowVerticalLines(false);
/* 3830 */       this.rSTableMetro4.setSelectionMode(0);
/* 3831 */       this.rSTableMetro4.setAutoCreateRowSorter(true);
/* 3832 */       this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 3833 */       this.rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 3834 */       this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(60);
/* 3835 */       for (int i = 0; i < this.rSTableMetro3.getRowCount(); i++) {
/* 3836 */         Object[] reg = { this.rSTableMetro3.getValueAt(i, 0), this.rSTableMetro3.getValueAt(i, 1) };
/* 3837 */         this.modelo.addRow(reg);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 3843 */     String valor = String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0));
/* 3844 */     for (int i = 0; i < this.rSTableMetro4.getRowCount(); i++) {
/* 3845 */       String valor2 = String.valueOf(this.rSTableMetro4.getValueAt(i, 0));
/* 3846 */       if (valor2.equals(valor)) {
/* 3847 */         JOptionPane.showMessageDialog(this.jDialog1, "No puedes agregar el cliente porque ya se encuentra en la tabla de la derecha\n<html><b><font color = blue>" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "</font><b></html>", "Cliente Duplicado", 0, this.ADVER);
/*      */         return;
/*      */       } 
/*      */     } 
/* 3851 */     Object[] reg = { this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0), this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1), this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 2) };
/* 3852 */     this.modelo.addRow(reg);
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 3856 */     if (this.rSTableMetro4.getRowCount() > 0) {
/* 3857 */       this.modelo.removeRow(this.rSTableMetro4.getSelectedRow());
/*      */     } else {
/* 3859 */       JOptionPane.showMessageDialog(this.jDialog1, "No existe ningún registro para quitarlo", "No hay Registros", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 3864 */     if (this.rSTableMetro4.getRowCount() > 0) {
/* 3865 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas quitar todas las cuentas a la tabla de la derecha?", "Quitar Todos", 0, 3, this.PREG);
/* 3866 */       if (res == 0) {
/* 3867 */         this.modelo = new DefaultTableModel();
/* 3868 */         this.rSTableMetro4.setModel(this.modelo);
/* 3869 */         this.modelo.addColumn("Clave");
/* 3870 */         this.modelo.addColumn("Nombre Completo");
/* 3871 */         this.rSTableMetro4.setShowVerticalLines(false);
/* 3872 */         this.rSTableMetro4.setSelectionMode(0);
/* 3873 */         this.rSTableMetro4.setAutoCreateRowSorter(true);
/* 3874 */         this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/* 3875 */         this.rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 3876 */         this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(60);
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 3881 */       JOptionPane.showMessageDialog(this.jDialog1, "No existe ningún registro para quitarlo", "No hay Registros", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 3886 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 3890 */     if (this.rSTableMetro4.getRowCount() == 0) {
/* 3891 */       JOptionPane.showMessageDialog(this.jDialog1, "No existe ningun cliente para crear nuevas Tarjetas", "No hay clientes", 0, this.ERROR);
/*      */     } else {
/* 3893 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas crear las nuevas cuentas de tarjeta deudor?", "Agregar Tarjetas", 0, 3, this.PREG);
/* 3894 */       if (res == 0) {
/* 3895 */         for (int i = 0; i < this.rSTableMetro4.getRowCount(); i++) {
/* 3896 */           String clave = String.valueOf(this.rSTableMetro4.getValueAt(i, 0));
/* 3897 */           String nombre = String.valueOf(this.rSTableMetro4.getValueAt(i, 1));
/* 3898 */           this.encontrado = this.con.consultar("clave_gene", "tarjeta_deudor_cliente", "where clave_gene=" + clave);
/* 3899 */           if (this.encontrado) {
/* 3900 */             JOptionPane.showMessageDialog(this.jDialog1, "No se puede crear la tarjeta deudor para el cliente\n" + nombre, "Nombre Duplicado", 0, this.ERROR);
/*      */           } else {
/* 3902 */             String corto = String.valueOf(this.rSTableMetro4.getValueAt(i, 2));
/* 3903 */             this.con.inserSinMsj("insert into tarjeta_deudor_cliente(f_creacion,clave_gene,nombreCompleto,nombre_corto,usuario_creo,total) values(now()," + clave + ",'" + nombre + "','" + corto + "','" + this.USUARIO + "','$0.00')");
/*      */           } 
/*      */         } 
/*      */         
/* 3907 */         consultar();
/* 3908 */         this.jDialog1.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 3914 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 3918 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 3922 */     limpiar2();
/* 3923 */     sacarMayor();
/* 3924 */     this.jDialog6.setTitle("Nuevo cargo para el cliente [" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "]");
/* 3925 */     this.jDialog6.setVisible(true);
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
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 3970 */     this.jLabel57.setVisible(false);
/* 3971 */     this.jLabel37.setText("$0.0");
/* 3972 */     this.jLabel39.setText("0");
/* 3973 */     this.jTextField16.setEnabled(true);
/* 3974 */     limpiar();
/* 3975 */     sacarMayor();
/* 3976 */     this.jTextField11.setText("");
/* 3977 */     this.jDateChooser4.setDate(new Date());
/* 3978 */     this.jDialog3.setTitle("Nuevo abono para el cliente [" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "]");
/*      */     
/* 3980 */     this.rSTableMetro6.setModel(new DefaultTableModel((Object[][])this.con
/* 3981 */           .buscarDatos(4, "mov,referencia,importeLetra,importeRestanteLetra,estatus", "tarjeta_contenido_cliente", "where (estatus='<Por Pagar>' || estatus like '%Abono:%') and tarjeta=" + this.CLAVECLIENTE + " ORDER BY MOV desc"), (Object[])new String[] { "Mov", "Referencia", "Importe", "Resta" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 3986 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*      */ 
/*      */           
/* 3989 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3994 */             return this.canEdit[columnIndex];
/*      */           }
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 3998 */             return this.types[columnIndex];
/*      */           }
/*      */         });
/* 4001 */     this.jTextField13.requestFocus();
/*      */     
/* 4003 */     this.rSTableMetro6.setShowVerticalLines(false);
/* 4004 */     this.rSTableMetro6.setSelectionMode(0);
/* 4005 */     this.rSTableMetro6.setAutoCreateRowSorter(true);
/*      */     
/* 4007 */     this.rSTableMetro6.getColumnModel().getColumn(0).setPreferredWidth(45);
/* 4008 */     this.rSTableMetro6.getColumnModel().getColumn(0).setMaxWidth(45);
/*      */     
/* 4010 */     this.rSTableMetro6.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 4011 */     this.rSTableMetro6.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 4012 */     this.rSTableMetro6.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 4013 */     this.rSTableMetro6.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/*      */     
/* 4015 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 4019 */     this.jTextArea5.setText("");
/* 4020 */     int selec = this.rSTableMetro5.getSelectedRow();
/* 4021 */     if (selec < 0) {
/* 4022 */       JOptionPane.showMessageDialog(this.jDialog2, "Necesitas seleccionar una partida para poder cancelar los datos", "Selecciona una partida", 0, this.ERROR);
/*      */     } else {
/* 4024 */       this.con.consultar("tipoConcep", "tarjeta_contenido_cliente", "where mov=" + String.valueOf(this.rSTableMetro5.getValueAt(selec, 0)));
/* 4025 */       String estatus = String.valueOf(this.rSTableMetro5.getValueAt(selec, 8));
/* 4026 */       this.TIPOCANCEL = this.con.Campo;
/* 4027 */       if (this.TIPOCANCEL.equals("1")) {
/* 4028 */         if (!estatus.equals("<Por Pagar>")) {
/* 4029 */           JOptionPane.showMessageDialog(this.jDialog2, "No puedes cancelar esta partida ya que contiene abonos", "Contiene abonos", 0, this.ERROR);
/*      */         } else {
/* 4031 */           this.jDialog7.setVisible(true);
/*      */         } 
/*      */       } else {
/* 4034 */         JOptionPane.showMessageDialog(this.jDialog2, "No puedes cancelar la partida que seleccionaste porque es un abono y ya fue aplicado\nPara regular los saldos puedes generar un CARGO", "No se puede cancelar el abono", 0, this.ERROR);
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
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 4054 */     String[] datos = { "MOV", "FECHA", "CONCEPTO", "REFERENCIA", "IMPORTE", "ABONO", "IMPORTE RESTANTE", "SALDO", "ESTATUS", "PAGO 1", "PAGO 2", "PAGO 3", "PAGO 4" };
/* 4055 */     this.esc = new EscribirReporte(this.jLabel62.getText().toUpperCase(), (JTable)this.rSTableMetro5, datos, this.USUARIO);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jFormattedTextField1ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jRadioButton5ActionPerformed(ActionEvent evt) {
/* 4063 */     this.jButton26.setEnabled(true);
/* 4064 */     this.jTextField13.setEnabled(true);
/* 4065 */     this.jTextField16.setEnabled(true);
/* 4066 */     this.jTextField17.setEnabled(true);
/*      */     
/* 4068 */     this.jTextField12.setEditable(false);
/* 4069 */     this.jTextField12.setText("");
/* 4070 */     this.jTextField15.setText("");
/* 4071 */     this.jTextField16.setText("");
/* 4072 */     this.jTextField17.setText("");
/* 4073 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 4074 */     this.jTextField13.requestFocus();
/*      */   }
/*      */   
/*      */   private void jRadioButton9ActionPerformed(ActionEvent evt) {
/* 4078 */     this.jButton26.setEnabled(false);
/* 4079 */     this.jTextField13.setEnabled(false);
/* 4080 */     this.jTextField13.setText("");
/*      */     
/* 4082 */     this.jTextField12.setEditable(true);
/* 4083 */     this.jTextField16.setEnabled(true);
/* 4084 */     this.jTextField17.setEnabled(true);
/* 4085 */     this.jTextField15.setText("");
/* 4086 */     this.jTextField16.setText("");
/* 4087 */     this.jTextField17.setText("");
/* 4088 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 4089 */     this.jTextField12.requestFocus();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField17ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 4097 */     int ind = this.rSTableMetro6.getSelectedRow();
/* 4098 */     if (ind < 0) {
/* 4099 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas seleccionar una factura de la parte de arriba", "Selecciona una factura", 0, this.ERROR);
/* 4100 */     } else if (this.jFormattedTextField1.getText().equals("$0.00")) {
/* 4101 */       this.jFormattedTextField1.setBackground(Color.RED);
/* 4102 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas insertar la cantidad que deseas guardar para este abono", "Coloca la cantidad", 0, this.ERROR);
/*      */     } else {
/* 4104 */       String valor1 = String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1));
/* 4105 */       for (int i = 0; i < this.rSTableMetro7.getRowCount(); i++) {
/* 4106 */         String valor2 = String.valueOf(this.rSTableMetro7.getValueAt(i, 1));
/* 4107 */         if (valor1.equals(valor2)) {
/* 4108 */           JOptionPane.showMessageDialog(this.jDialog3, "La factura que seleccionaste ya se encuentra almacenada en la parte para saldar", "Factura Duplicada", 0, this.ERROR);
/*      */           return;
/*      */         } 
/*      */       } 
/* 4112 */       pasarAbajo();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 4117 */     int ind = this.rSTableMetro7.getSelectedRow();
/* 4118 */     if (ind < 0) {
/* 4119 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas seleccionar una factura de la parte de abajo", "Selecciona una factura", 0, this.ERROR);
/*      */     } else {
/* 4121 */       DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro6.getModel();
/* 4122 */       String[] arrayOfString = new String[5];
/* 4123 */       arrayOfString[0] = (String)this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 0);
/* 4124 */       arrayOfString[1] = (String)this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 1);
/* 4125 */       arrayOfString[2] = (String)this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 2);
/* 4126 */       arrayOfString[3] = (String)this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 3);
/* 4127 */       temp.addRow((Object[])arrayOfString);
/*      */       
/* 4129 */       temp = (DefaultTableModel)this.rSTableMetro7.getModel();
/* 4130 */       temp.removeRow(ind);
/* 4131 */       sumarFacturas();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable7MouseClicked(MouseEvent evt) {
/* 4136 */     this.jTable7.setToolTipText("Información: " + String.valueOf(this.jTable7.getValueAt(this.jTable7.getSelectedRow(), 1)));
/*      */   }
/*      */   
/*      */   private void jLabel19MouseEntered(MouseEvent evt) {
/* 4140 */     this.jLabel19.setBackground(Color.BLUE);
/*      */   }
/*      */   
/*      */   private void jLabel19MouseExited(MouseEvent evt) {
/* 4144 */     this.jLabel19.setBackground(Color.BLACK);
/*      */   }
/*      */   
/*      */   private void jLabel19MouseClicked(MouseEvent evt) {
/* 4148 */     this.con.consultar("comentario", "tarjeta_contenido_cliente", "where mov=" + this.jTextField5.getText());
/* 4149 */     JOptionPane.showMessageDialog(this.jDialog4, "<html>Este es el comentario para este movimiento:<hr><b>" + this.con.Campo + "</b></html>", "Comentario", 0, this.INFO);
/*      */   }
/*      */   
/*      */   private void jLabel32MouseClicked(MouseEvent evt) {
/* 4153 */     this.con.consultar("comentario", "tarjeta_contenido_cliente", "where mov=" + this.jTextField7.getText());
/* 4154 */     JOptionPane.showMessageDialog(this.jDialog5, "<html>Este es el comentario para este movimiento:<hr><b>" + this.con.Campo + "</b></html>", "Comentario", 0, this.INFO);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel32MouseEntered(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel32MouseExited(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 4166 */     String[] datos = { "TARJETA", "CLIENTE", "NOMBRE CORTO", "FECHA DE CREACIÓN", "DOCUMENTÓ", "SALDO" };
/* 4167 */     this.esc = new EscribirReporte("TAJETA DEUDOR POR CLIENTE", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 4171 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {
/* 4175 */     this.jTextField10.setText("");
/* 4176 */     this.jTextField10.setEnabled(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton4ActionPerformed(ActionEvent evt) {
/* 4180 */     this.jTextField10.setEnabled(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jFormattedTextField2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 4188 */     if (this.jRadioButton4.isSelected() && this.jTextField10.getText().equals("")) {
/* 4189 */       this.jTextField10.setBackground(Color.RED);
/* 4190 */       JOptionPane.showMessageDialog(this.jDialog6, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/* 4191 */     } else if (this.jTextField18.getText().equals("")) {
/* 4192 */       this.jTextField18.setBackground(Color.RED);
/* 4193 */       JOptionPane.showMessageDialog(this.jDialog6, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/* 4194 */     } else if (this.jFormattedTextField2.getText().equals("$0.00")) {
/* 4195 */       this.jFormattedTextField2.setBackground(Color.RED);
/* 4196 */       JOptionPane.showMessageDialog(this.jDialog6, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/*      */     } else {
/* 4198 */       String concep = "CARGO POR FACTURA";
/* 4199 */       String tipo = "1";
/* 4200 */       if (this.jRadioButton4.isSelected()) {
/* 4201 */         concep = this.jTextField10.getText().toUpperCase();
/* 4202 */         tipo = "2";
/*      */       } 
/* 4204 */       double total = 0.0D;
/* 4205 */       String cant = this.jFormattedTextField2.getValue().toString();
/* 4206 */       this.encontrado = this.con.consultar("saldoFinal", "tarjeta_contenido_cliente", "where tarjeta = " + this.CLAVECLIENTE);
/* 4207 */       if (this.encontrado) {
/* 4208 */         this.encontrado = this.con.consultar("sum(importeRestante)", "tarjeta_contenido_cliente", "where tarjeta = " + this.CLAVECLIENTE);
/* 4209 */         String saldoFinal = this.con.Campo;
/* 4210 */         total = Double.parseDouble(saldoFinal) + Double.parseDouble(cant);
/*      */       } else {
/* 4212 */         total = Double.parseDouble(cant);
/*      */       } 
/* 4214 */       total = redondear(total).doubleValue();
/* 4215 */       this.cantidad.setValue(Double.valueOf(total));
/* 4216 */       double cantAux = Double.parseDouble(String.valueOf(this.jFormattedTextField2.getValue()));
/* 4217 */       cantAux = redondear(cantAux).doubleValue();
/* 4218 */       this.jFormattedTextField2.setValue(Double.valueOf(cantAux));
/* 4219 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "<html>¿Estás seguro que deseas generar el siguiente cargo por <b>" + this.jFormattedTextField2.getText() + "</b>?</html>", "Generar Cargo", 0, 3, this.PREG);
/* 4220 */       if (res == 0) {
/* 4221 */         sacarMayor();
/*      */         
/* 4223 */         this.con.inserSinMsj("update tarjeta_deudor_cliente set total = '" + this.cantidad.getText() + "' where tarjeta=" + this.CLAVECLIENTE);
/* 4224 */         this.con.inserSinMsj("insert into tarjeta_contenido_cliente(fecha,tipoConcep,  tipo,   concepto,               referencia,                                    importe,                 importeLetra,                abono, abonoLetra, importeSaldado,                     importeRestante,              ImporteRestanteLetra,      estatus,                    comentario,         factura,    num_abono,    saldoFinal,   saldoFinalLetra,          TARJETA,    usuario,pago1,pago2,pago3,pago4, fechaPago) values(now(),1,       " + tipo + ",'" + concep + "','" + this.jTextField18
/* 4225 */             .getText().toUpperCase() + "'," + String.valueOf(this.jFormattedTextField2.getValue()) + ",'" + this.jFormattedTextField2.getText() + "',0,      '',            0,           " + String.valueOf(this.jFormattedTextField2.getValue()) + ",    '" + this.jFormattedTextField2.getText() + "','<Por Pagar>','" + this.jTextArea2.getText().toUpperCase() + "','',           '',        " + total + ",'" + this.cantidad.getText() + "'," + this.CLAVECLIENTE + ",'" + this.USUARIO + "','','','','',now())");
/*      */ 
/*      */         
/* 4228 */         consultar3();
/* 4229 */         this.jDialog6.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 4235 */     int selec = this.rSTableMetro5.getSelectedRow();
/* 4236 */     String motivo = this.jTextArea5.getText();
/* 4237 */     if (motivo.equals("")) {
/* 4238 */       this.jTextArea5.setBackground(Color.RED);
/* 4239 */       JOptionPane.showMessageDialog(this.jDialog5, "Necesitas colocar el motivo por el cual se cancela la factura", "Coloca un comentario", 0, this.ERROR);
/*      */     } else {
/* 4241 */       int res = JOptionPane.showConfirmDialog(this.jDialog5, "¿Estás seguro que deseas cancelar el cargo que seleccionaste?", "Cancelar el cargo", 0, 3, this.PREG);
/* 4242 */       if (res == 0) {
/*      */         
/* 4244 */         String mov = String.valueOf(this.rSTableMetro5.getValueAt(selec, 0));
/* 4245 */         this.con.consultar("factura", "tarjeta_contenido_cliente", "where mov=" + mov);
/* 4246 */         String factura = this.con.Campo;
/* 4247 */         if (!factura.equals("")) {
/* 4248 */           this.con.inserSinMsj("update facturas set estatus='<Cancelada: " + this.USUARIO + " " + cargarFechaHoy2() + ">', motivo ='" + this.jTextArea5.getText().toUpperCase() + "' where folio='" + factura + "'");
/* 4249 */           this.con.inserSinMsj("update prefacturacliente set estatus='<Por Facturar>',folio='' where folio='" + factura + "'");
/* 4250 */           this.con.inserSinMsj("update guias set estatus='<En Prefactura Interna>',factImpresa='' where factImpresa = '" + factura + "'");
/*      */         } 
/*      */         
/* 4253 */         double totalDebe = 0.0D;
/* 4254 */         String consul = "";
/*      */         
/* 4256 */         int indice = 0;
/* 4257 */         String txtSalda = "";
/*      */         
/* 4259 */         String[] datos = this.con.regresaReg("importe,importeLetra", "tarjeta_contenido_cliente", "where MOV = " + mov, 2);
/* 4260 */         double total = 0.0D;
/*      */         
/* 4262 */         this.con.inserSinMsj("update tarjeta_contenido_cliente set importeSaldado =" + datos[0] + ",importeRestante=0,comentario='" + this.jTextArea5.getText().toUpperCase() + "', estatus='<Cancelado: " + this.USUARIO + " " + cargarFechaHoy2() + ">' where mov='" + mov + "'");
/*      */         
/* 4264 */         this.con.consultar("sum(importeRestante)", "tarjeta_contenido_cliente", "where tarjeta = " + this.TARJETA);
/* 4265 */         total = Double.parseDouble(this.con.Campo);
/* 4266 */         total = redondear(total).doubleValue();
/* 4267 */         this.cantidad.setValue(Double.valueOf(total));
/*      */         
/* 4269 */         this.con.inserSinMsj("insert into tarjeta_contenido_cliente(fecha, tipoConcep, tipo,    concepto,            referencia,                 importe,importeLetra,abono,     abonoLetra,  importeSaldado,importeRestante,ImporteRestanteLetra,estatus,comentario,                                                                       factura,num_abono,saldoFinal,saldoFinalLetra,pago1,pago2,pago3,pago4,tarjeta,usuario)values(now(),    2,           2,'ABONO POR CANCELACIÓN','" + 
/* 4270 */             String.valueOf(this.rSTableMetro5.getValueAt(selec, 3)) + "',0,        '',  " + datos[0] + ",'" + datos[1] + "',0               ,0,              '$0.00'            ,'<Aplicado>','ESTE MOVIMIENTO SE ABONÓ AUTOMÁTICO DEBIDO A UNA CANCELACIÓN POR UNA PARTIDA','',        ''," + total + ",'" + this.cantidad.getText() + "','','','',''," + this.TARJETA + ",'" + this.USUARIO + "')");
/*      */         
/* 4272 */         this.con.inserSinMsj("update tarjeta_deudor_cliente set total='" + this.cantidad.getText() + "' where tarjeta=" + this.TARJETA);
/*      */ 
/*      */         
/* 4275 */         verTarjeta();
/* 4276 */         this.jDialog7.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 4283 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton47ActionPerformed(ActionEvent evt) {
/* 4287 */     this.SALDAR += this.AUXLIARSALDO;
/* 4288 */     this.jDialog8.setVisible(false);
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
/*      */   private void jButton48ActionPerformed(ActionEvent evt) {
/* 4315 */     int ind = this.rSTableMetro7.getSelectedRow();
/* 4316 */     double abono = Double.parseDouble(String.valueOf(this.jFormattedTextField3.getValue()));
/*      */     
/* 4318 */     String canti = String.valueOf(this.rSTableMetro7.getValueAt(ind, 3));
/* 4319 */     String valorP = "";
/* 4320 */     for (int j = 0; j < canti.length(); j++) {
/* 4321 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4322 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4325 */     double resta = Double.parseDouble(valorP);
/*      */     
/* 4327 */     if (abono < 0.0D) {
/* 4328 */       JOptionPane.showMessageDialog(this.jDialog8, "No puedes colocar cantidades negativas en el campo", "Cantidad negativa", 0, this.ERROR);
/* 4329 */     } else if (abono > resta) {
/* 4330 */       JOptionPane.showMessageDialog(this.jDialog8, "La cantidad que colocaste es mayor al resto de la factura\nVerfiica tus cantidades", "Cantidad mayor", 0, this.ERROR);
/*      */     } else {
/* 4332 */       this.rSTableMetro7.setValueAt(this.jFormattedTextField3.getText(), this.rSTableMetro7.getSelectedRow(), 4);
/* 4333 */       this.jDialog8.setVisible(false);
/* 4334 */       sumarFacturas();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 4339 */     int ind = this.rSTableMetro7.getSelectedRow();
/* 4340 */     if (ind < 0) {
/* 4341 */       JOptionPane.showMessageDialog(this.jDialog8, "Necesitas seleccionar una factura de la parte de abajo", "Selecciona una factura", 0, this.ERROR);
/*      */     } else {
/* 4343 */       String canti = String.valueOf(this.rSTableMetro7.getValueAt(ind, 4));
/* 4344 */       String valorP = "";
/* 4345 */       for (int j = 0; j < canti.length(); j++) {
/* 4346 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4347 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 4350 */       double abono = Double.parseDouble(valorP);
/* 4351 */       abono = redondear(abono).doubleValue();
/* 4352 */       this.AUXLIARSALDO = abono;
/* 4353 */       this.SALDAR -= abono;
/* 4354 */       this.jFormattedTextField3.setValue(Double.valueOf(abono));
/* 4355 */       this.jDialog8.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField11KeyReleased(KeyEvent evt) {
/* 4360 */     String cadena = this.jTextField11.getText();
/* 4361 */     if (!cadena.equals("")) {
/* 4362 */       if (this.presionado == null) {
/* 4363 */         this.presionado = new Presionado();
/* 4364 */         this.presionado.start();
/*      */       } else {
/* 4366 */         this.presionado.detenerFuera();
/* 4367 */         this.presionado = new Presionado();
/* 4368 */         this.presionado.start();
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField11ActionPerformed(ActionEvent evt) {
/* 4374 */     buscarFacturas();
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 4378 */     this.jRadioButton2.setSelected(true);
/* 4379 */     this.jDateChooser1.setEnabled(true);
/* 4380 */     this.jLabel42.setEnabled(true);
/* 4381 */     this.jDialog9.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 4385 */     this.jDateChooser1.setEnabled(false);
/* 4386 */     this.jLabel42.setEnabled(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 4404 */     this.jDialog2.setVisible(false);
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
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 4430 */     consultar3();
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 4434 */     if (this.jRadioButton5.isSelected()) {
/* 4435 */       capturarDocumento();
/* 4436 */     } else if (this.jRadioButton10.isSelected()) {
/* 4437 */       capturarNotaCredito();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField13ActionPerformed(ActionEvent evt) {
/* 4442 */     if (this.jRadioButton5.isSelected()) {
/* 4443 */       capturarDocumento();
/* 4444 */     } else if (this.jRadioButton10.isSelected()) {
/* 4445 */       capturarNotaCredito();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jRadioButton10ActionPerformed(ActionEvent evt) {
/* 4450 */     this.jButton26.setEnabled(true);
/* 4451 */     this.jTextField13.setEnabled(true);
/* 4452 */     this.jTextField13.setEnabled(true);
/* 4453 */     this.jTextField16.setEnabled(false);
/* 4454 */     this.jTextField17.setEnabled(false);
/* 4455 */     this.jTextField12.setText("");
/* 4456 */     this.jTextField15.setText("");
/* 4457 */     this.jTextField16.setText("");
/* 4458 */     this.jTextField17.setText("");
/* 4459 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 4460 */     this.jTextField13.requestFocus();
/*      */   }
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 4464 */     if (evt.getClickCount() == 2) {
/* 4465 */       this.TARJETA = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 4466 */       verTarjeta();
/*      */     } else {
/* 4468 */       this.jButton10.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 4477 */     if (evt.getClickCount() == 2) {
/* 4478 */       String valor = String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0));
/* 4479 */       for (int i = 0; i < this.rSTableMetro4.getRowCount(); i++) {
/* 4480 */         String valor2 = String.valueOf(this.rSTableMetro4.getValueAt(i, 0));
/* 4481 */         if (valor2.equals(valor)) {
/* 4482 */           JOptionPane.showMessageDialog(this.jDialog1, "No puedes agregar el siguiente cliente porque ya se encuentra en la tabla de la derecha\n<html><b><font color = blue>" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "</font><b></html>", "Cliente Duplicado", 0, this.ADVER);
/*      */           return;
/*      */         } 
/*      */       } 
/* 4486 */       Object[] reg = { this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0), this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1), this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 2) };
/* 4487 */       this.modelo.addRow(reg);
/*      */     } else {
/* 4489 */       this.jButton11.setEnabled(true);
/* 4490 */       this.jButton12.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro4MouseClicked(MouseEvent evt) {
/* 4499 */     if (evt.getClickCount() == 2) {
/* 4500 */       if (this.rSTableMetro4.getRowCount() > 0) {
/* 4501 */         this.modelo.removeRow(this.rSTableMetro4.getSelectedRow());
/*      */       }
/*      */     } else {
/* 4504 */       this.jButton13.setEnabled(true);
/* 4505 */       this.jButton14.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro4KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro5MouseClicked(MouseEvent evt) {
/* 4514 */     if (evt.getClickCount() == 2) {
/* 4515 */       this.con.consultar("tipoConcep", "tarjeta_contenido_cliente", "where mov=" + String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 0)));
/* 4516 */       if (this.con.Campo.equals("1")) {
/* 4517 */         cargarCargo();
/*      */       } else {
/* 4519 */         cargarAbono();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro5KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro6MouseClicked(MouseEvent evt) {
/* 4529 */     if (evt.getClickCount() == 2) {
/* 4530 */       if (this.jFormattedTextField1.getText().equals("$0.00")) {
/* 4531 */         this.jFormattedTextField1.setBackground(Color.RED);
/* 4532 */         JOptionPane.showMessageDialog(this.jDialog3, "Necesitas insertar la cantidad que deseas guardar para este abono", "Coloca la cantidad", 0, this.ERROR);
/*      */       } else {
/* 4534 */         String valor1 = String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1));
/* 4535 */         for (int i = 0; i < this.rSTableMetro7.getRowCount(); i++) {
/* 4536 */           String valor2 = String.valueOf(this.rSTableMetro7.getValueAt(i, 1));
/* 4537 */           if (valor1.equals(valor2)) {
/* 4538 */             JOptionPane.showMessageDialog(this.jDialog3, "La factura que seleccionaste ya se encuentra almacenada en la parte para saldar", "Factura Duplicada", 0, this.ERROR);
/*      */             return;
/*      */           } 
/*      */         } 
/* 4542 */         pasarAbajo();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro6KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void rSTableMetro7MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro7KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void materialButton38ActionPerformed(ActionEvent evt) {
/* 4560 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton37ActionPerformed(ActionEvent evt) {
/* 4564 */     if (this.jRadioButton5.isSelected()) {
/* 4565 */       abonarComplementoPago();
/* 4566 */     } else if (this.jRadioButton10.isSelected()) {
/* 4567 */       abonarNotaCredito();
/* 4568 */     } else if (this.jRadioButton9.isSelected()) {
/* 4569 */       abonarOtroConcepto();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton36ActionPerformed(ActionEvent evt) {
/* 4574 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton39ActionPerformed(ActionEvent evt) {
/* 4578 */     this.jDialog5.setVisible(false);
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
/*      */   private void materialButton18ActionPerformed(ActionEvent evt) {
/* 4590 */     this.jDialog10.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton17ActionPerformed(ActionEvent evt) {
/* 4594 */     boolean correcto = false;
/* 4595 */     if (this.jDateChooser9.getDate() == null) {
/* 4596 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de corte no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "Fecha de corte vacía", 0, 3, this.PREG);
/* 4597 */       if (res == 0) {
/* 4598 */         this.jDateChooser9.setDate(new Date());
/* 4599 */         correcto = true;
/*      */       } 
/* 4601 */     } else if (this.jDateChooser9.getDate().after(new Date())) {
/* 4602 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de corte no puede ser mayor a la fecha de HOY, por favor verifica tu información<br>¿Deseas insertar la fecha actual en el campo?</html>", "Fecha no Válida", 0, 3, this.PREG);
/* 4603 */       if (res == 0) {
/* 4604 */         this.jDateChooser9.setDate(new Date());
/* 4605 */         correcto = true;
/*      */       } 
/*      */     } else {
/* 4608 */       correcto = true;
/*      */     } 
/*      */     
/* 4611 */     if (correcto) {
/* 4612 */       consultar();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4626 */       boolean TODOPAGADO = false;
/*      */       
/* 4628 */       ArrayList<String> tarjetas = new ArrayList();
/* 4629 */       ArrayList<String> nombreCorto = new ArrayList();
/* 4630 */       Map<Integer, String> CLIENTES = new HashMap<>();
/*      */       
/* 4632 */       for (int i = 0; i < this.TablaAux1.getRowCount(); i++) {
/* 4633 */         if (!this.TablaAux1.getValueAt(i, 5).toString().equals("$0.00")) {
/* 4634 */           TODOPAGADO = true;
/* 4635 */           tarjetas.add(this.TablaAux1.getValueAt(i, 0).toString());
/* 4636 */           nombreCorto.add(this.TablaAux1.getValueAt(i, 2).toString());
/* 4637 */           CLIENTES.put(Integer.valueOf(Integer.parseInt(this.TablaAux1.getValueAt(i, 0).toString())), this.TablaAux1.getValueAt(i, 1).toString());
/*      */         } 
/*      */       } 
/* 4640 */       if (TODOPAGADO) {
/* 4641 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4642 */         String cadenaFecha = "";
/* 4643 */         cadenaFecha = formato.format(this.jDateChooser9.getDate());
/* 4644 */         String AÑO = cadenaFecha.substring(0, 4);
/* 4645 */         String MES = cadenaFecha.substring(4, 6);
/* 4646 */         String DIA = cadenaFecha.substring(6, 8);
/* 4647 */         String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 4648 */         String consulta = "";
/* 4649 */         String consulta2 = "";
/* 4650 */         for (int j = 0; j < tarjetas.size(); j++) {
/* 4651 */           consulta = consulta + " tarjeta_contenido_cliente.tarjeta = " + consulta + " and fechaPago <= " + String.valueOf(tarjetas.get(j)) + " and fecha<= " + fechaCompleta1;
/* 4652 */           consulta2 = consulta2 + " tarjeta_contenido_cliente.tarjeta =" + consulta2 + " and fechaPago > " + String.valueOf(tarjetas.get(j)) + " and fecha<= " + fechaCompleta1;
/* 4653 */           if (nombreCorto.size() - 1 > j) {
/* 4654 */             consulta = consulta + " or ";
/* 4655 */             consulta2 = consulta2 + " or ";
/*      */           } 
/*      */         } 
/*      */         
/* 4659 */         this.TablaGral.setModel(new DefaultTableModel((Object[][])this.con
/* 4660 */               .buscarDatos(7, "tarjeta_contenido_cliente.tarjeta,nombreCompleto,factura,fechaPago,importeLetra,importeRestanteLetra,estatus", "tarjeta_contenido_cliente,tarjeta_deudor_cliente", "where tarjeta_deudor_cliente.tarjeta=tarjeta_contenido_cliente.tarjeta and tipoConcep=1 and (estatus like '%<Por Pagar%' || estatus like '%<Abono%') and (" + consulta + ") order by nombreCompleto asc, fecha asc"), (Object[])new String[] { "Tarjeta", "Cliente", "Folio", "Fecha", "total", "Resta", "Estatus" })
/*      */             {
/*      */ 
/*      */ 
/*      */               
/* 4665 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false };
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4670 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 4673 */         this.jLabel61.setText("" + this.TablaGral.getRowCount());
/*      */         
/* 4675 */         this.TablaGral1.setModel(new DefaultTableModel((Object[][])this.con
/* 4676 */               .buscarDatos(7, "tarjeta_contenido_cliente.tarjeta,nombreCompleto,factura,fechaPago,importeLetra,importeRestanteLetra,estatus", "tarjeta_contenido_cliente,tarjeta_deudor_cliente", "where tarjeta_deudor_cliente.tarjeta=tarjeta_contenido_cliente.tarjeta and tipoConcep=1 and (estatus like '%<Por Pagar%' || estatus like '%<Abono%') and (" + consulta2 + ") order by nombreCompleto asc, fecha asc"), (Object[])new String[] { "Tarjeta", "Cliente", "Folio", "Fecha", "total", "Resta", "Estatus" })
/*      */             {
/*      */ 
/*      */ 
/*      */               
/* 4681 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false };
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4686 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/*      */         
/* 4690 */         this.jLabel63.setText("" + this.TablaGral1.getRowCount());
/* 4691 */         this.jLabel69.setText("" + tarjetas.size());
/*      */         
/* 4693 */         this.TablaAux = new JTable(tarjetas.size(), 6);
/* 4694 */         double importe = 0.0D;
/* 4695 */         for (int k = 0; k < tarjetas.size(); k++) {
/* 4696 */           this.TablaAux.setValueAt(Integer.valueOf(k + 1), k, 0);
/* 4697 */           this.TablaAux.setValueAt(tarjetas.get(k), k, 1);
/* 4698 */           this.TablaAux.setValueAt(nombreCorto.get(k), k, 2);
/*      */           int n;
/* 4700 */           for (n = 0; n < this.TablaGral.getRowCount(); n++) {
/* 4701 */             String cliente = this.TablaGral.getValueAt(n, 0).toString();
/* 4702 */             if (cliente.equals(tarjetas.get(k))) {
/* 4703 */               String cant = this.TablaGral.getValueAt(n, 5).toString();
/* 4704 */               importe += convertirCantTexto(cant);
/*      */             } 
/*      */           } 
/*      */           
/* 4708 */           this.cantidad.setValue(Double.valueOf(importe));
/* 4709 */           this.TablaAux.setValueAt(this.cantidad.getText(), k, 3);
/* 4710 */           importe = 0.0D;
/*      */           
/* 4712 */           for (n = 0; n < this.TablaGral1.getRowCount(); n++) {
/* 4713 */             String cliente = this.TablaGral1.getValueAt(n, 0).toString();
/* 4714 */             if (cliente.equals(tarjetas.get(k))) {
/* 4715 */               String cant = this.TablaGral1.getValueAt(n, 5).toString();
/* 4716 */               importe += convertirCantTexto(cant);
/*      */             } 
/*      */           } 
/*      */           
/* 4720 */           this.cantidad.setValue(Double.valueOf(importe));
/* 4721 */           this.TablaAux.setValueAt(this.cantidad.getText(), k, 4);
/* 4722 */           importe = 0.0D;
/*      */         } 
/*      */         
/* 4725 */         double TOTALVENCIDO = 0.0D;
/* 4726 */         double TOTALPORVENCER = 0.0D;
/* 4727 */         double TOTALGRAL = 0.0D;
/*      */         
/* 4729 */         for (int m = 0; m < this.TablaAux.getRowCount(); m++) {
/* 4730 */           String vencido = this.TablaAux.getValueAt(m, 3).toString();
/* 4731 */           String porvencer = this.TablaAux.getValueAt(m, 4).toString();
/* 4732 */           double total = convertirCantTexto(vencido) + convertirCantTexto(porvencer);
/* 4733 */           this.cantidad.setValue(Double.valueOf(total));
/* 4734 */           this.TablaAux.setValueAt(this.cantidad.getText(), m, 5);
/*      */           
/* 4736 */           TOTALVENCIDO += convertirCantTexto(vencido);
/* 4737 */           TOTALPORVENCER += convertirCantTexto(porvencer);
/*      */         } 
/*      */         
/* 4740 */         TOTALGRAL = TOTALVENCIDO + TOTALPORVENCER;
/* 4741 */         this.cantidad.setValue(Double.valueOf(TOTALVENCIDO));
/* 4742 */         this.jLabel72.setText(this.cantidad.getText());
/*      */         
/* 4744 */         this.cantidad.setValue(Double.valueOf(TOTALPORVENCER));
/* 4745 */         this.jLabel82.setText(this.cantidad.getText());
/*      */         
/* 4747 */         this.cantidad.setValue(Double.valueOf(TOTALGRAL));
/* 4748 */         this.jLabel83.setText(this.cantidad.getText());
/*      */         
/* 4750 */         this.jScrollPane6.setViewportView(this.TablaAux);
/*      */ 
/*      */ 
/*      */         
/* 4754 */         this.jDialog10.setVisible(false);
/*      */         
/*      */         try {
/* 4757 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 4758 */           String cadenaFecha1 = formato.format(this.jDateChooser9.getDate());
/* 4759 */           String año = cadenaFecha1.substring(0, 4);
/* 4760 */           String mes = cadenaFecha1.substring(4, 6);
/* 4761 */           String dia = cadenaFecha1.substring(6, 8);
/* 4762 */           String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */           
/* 4764 */           String sicret = "LOGO.jpg";
/* 4765 */           String forsis = "forsis100x.jpg";
/* 4766 */           Map<Object, Object> datos = new HashMap<>();
/* 4767 */           datos.put("sucursal", this.CONFIGURACIONES[1]);
/*      */           
/* 4769 */           datos.put("periodo", fechaCompleta);
/* 4770 */           datos.put("documento", iniciales(this.USUARIO).toUpperCase());
/* 4771 */           datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 4772 */           datos.put("forsis", getClass().getResourceAsStream(forsis));
/*      */           
/* 4774 */           datos.put("vencido", this.jLabel72.getText());
/* 4775 */           datos.put("porVencer", this.jLabel82.getText());
/* 4776 */           datos.put("totalGral", this.jLabel83.getText());
/*      */           
/* 4778 */           JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(this.TablaAux.getModel());
/* 4779 */           JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Facturacion/CuentasPorCobrar.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 4780 */           JasperViewer visor = new JasperViewer(print, false);
/* 4781 */           visor.setTitle("Reporte de cuentas por cobrar");
/* 4782 */           visor.setIconImage(this.iconoImprimir);
/* 4783 */           visor.setZoomRatio(0.59F);
/* 4784 */           visor.setExtendedState(6);
/* 4785 */           visor.setVisible(true);
/*      */         }
/* 4787 */         catch (JRException e) {
/* 4788 */           System.out.println(e.getMessage());
/* 4789 */           Logger.getLogger(TarjetaCliente.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */         } 
/*      */       } else {
/* 4792 */         JOptionPane.showMessageDialog(this.padre, "No hay deudores en la consulta, verifica tu información", "Sin deudores", 0, this.ADVER);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 4803 */     if (this.rSTableMetro1.getRowCount() > 0) {
/* 4804 */       this.jRadioButton6.setSelected(true);
/* 4805 */       this.jDialog17.setVisible(true);
/*      */     } else {
/* 4807 */       JOptionPane.showMessageDialog(this.padre, "No hay datos para generar el reporte", "Sin datos", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel70MouseClicked(MouseEvent evt) {
/* 4812 */     int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que activar la fecha de pago?", "Fechas", 0, 3, this.PREG);
/* 4813 */     if (res == 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4844 */       System.out.println("Version 3.3");
/* 4845 */       String[][] DATOS = this.con.buscarDatos(5, "folio,fecha,total,estatus,condiciones", "facturas33", "where (estatus like '%Por Pag%' or estatus like '%Abono%')");
/* 4846 */       for (int i = 0; i < DATOS.length; i++) {
/* 4847 */         String fecha = DATOS[i][1];
/* 4848 */         String diasCon = buscarNumero(DATOS[i][4]);
/*      */         
/* 4850 */         Date fechaPago = convierteTextoAFecha(fecha);
/* 4851 */         Date fechaOriginal = convierteTextoAFecha(fecha);
/*      */         
/* 4853 */         GregorianCalendar c = new GregorianCalendar();
/* 4854 */         c.setTime(fechaPago);
/* 4855 */         c.roll(6, Integer.parseInt(diasCon));
/* 4856 */         fechaPago = c.getTime();
/*      */         
/* 4858 */         if (fechaOriginal.after(fechaPago)) {
/* 4859 */           c.roll(1, 1);
/* 4860 */           fechaPago = c.getTime();
/*      */         } 
/*      */         
/* 4863 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4864 */         String cadenaFecha1 = formato.format(fechaPago);
/* 4865 */         String año = cadenaFecha1.substring(0, 4);
/* 4866 */         String mes = cadenaFecha1.substring(4, 6);
/* 4867 */         String dia = cadenaFecha1.substring(6, 8);
/* 4868 */         String FECHAGRAL = año + "-" + año + "-" + mes;
/*      */         
/* 4870 */         System.out.println(DATOS[i][0] + " " + DATOS[i][0] + " " + fecha + " " + diasCon);
/*      */         
/* 4872 */         this.con.inserSinMsj("update tarjeta_contenido_cliente set fechaPago='" + FECHAGRAL + "' where factura='" + DATOS[i][0] + "'");
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 4880 */     this.jDialog9.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton19ActionPerformed(ActionEvent evt) {
/* 4884 */     if (this.jRadioButton2.isSelected()) {
/* 4885 */       boolean correcto = false;
/* 4886 */       if (this.jDateChooser1.getDate() == null) {
/* 4887 */         int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de corte no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "Fecha de corte vacía", 0, 3, this.PREG);
/* 4888 */         if (res == 0) {
/* 4889 */           this.jDateChooser1.setDate(new Date());
/* 4890 */           correcto = true;
/*      */         } 
/* 4892 */       } else if (this.jDateChooser1.getDate().after(new Date())) {
/* 4893 */         int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de corte no puede ser mayor a la fecha de HOY, por favor verifica tu información<br>¿Deseas insertar la fecha actual en el campo?</html>", "Fecha no Válida", 0, 3, this.PREG);
/* 4894 */         if (res == 0) {
/* 4895 */           this.jDateChooser1.setDate(new Date());
/* 4896 */           correcto = true;
/*      */         } 
/*      */       } else {
/* 4899 */         correcto = true;
/*      */       } 
/* 4901 */       if (correcto) {
/* 4902 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4903 */         String cadenaFecha = "";
/* 4904 */         cadenaFecha = formato.format(this.jDateChooser1.getDate());
/* 4905 */         String AÑO = cadenaFecha.substring(0, 4);
/* 4906 */         String MES = cadenaFecha.substring(4, 6);
/* 4907 */         String DIA = cadenaFecha.substring(6, 8);
/* 4908 */         String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */         
/* 4910 */         this.TablaGral.setModel(new DefaultTableModel((Object[][])this.con
/* 4911 */               .buscarDatos(8, "tarjeta_contenido_cliente.tarjeta,nombreCompleto,factura,fecha,fechaPago,importeLetra,importeRestanteLetra,estatus", "tarjeta_contenido_cliente,tarjeta_deudor_cliente", "where tarjeta_deudor_cliente.tarjeta=tarjeta_contenido_cliente.tarjeta and tipoConcep=1 and (estatus like '%<Por Pagar%' || estatus like '%<Abono%') and (tarjeta_contenido_cliente.tarjeta = " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + " and fechaPago<=" + fechaCompleta1 + ") order by nombreCompleto asc, fecha asc"), (Object[])new String[] { "Tarjeta", "Cliente", "Folio", "Fecha", "Fecha de Pago", "total", "Resta", "Estatus" })
/*      */             {
/*      */ 
/*      */ 
/*      */               
/* 4916 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false };
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4921 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 4924 */         this.jLabel61.setText("" + this.TablaGral.getRowCount());
/* 4925 */         double TOTALNETO = 0.0D;
/* 4926 */         double TOTAL30 = 0.0D;
/* 4927 */         double TOTAL60 = 0.0D;
/* 4928 */         double TOTAL90 = 0.0D;
/* 4929 */         double TOTALMAS = 0.0D;
/* 4930 */         double TOTALDEBE = 0.0D;
/*      */ 
/*      */         
/* 4933 */         this.TablaAux1 = new JTable(this.TablaGral.getRowCount(), 10);
/* 4934 */         for (int i = 0; i < this.TablaGral.getRowCount(); i++) {
/* 4935 */           this.TablaAux1.setValueAt(Integer.valueOf(i + 1), i, 0);
/* 4936 */           this.TablaAux1.setValueAt(this.TablaGral.getValueAt(i, 2), i, 1);
/*      */           
/* 4938 */           String fecha = this.TablaGral.getValueAt(i, 3).toString();
/* 4939 */           String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4940 */           this.TablaAux1.setValueAt(col, i, 2);
/*      */           
/* 4942 */           fecha = this.TablaGral.getValueAt(i, 4).toString();
/* 4943 */           col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4944 */           this.TablaAux1.setValueAt(col, i, 3);
/*      */           
/* 4946 */           this.TablaAux1.setValueAt(this.TablaGral.getValueAt(i, 5), i, 4);
/* 4947 */           this.TablaAux1.setValueAt(this.TablaGral.getValueAt(i, 7), i, 5);
/*      */           
/* 4949 */           Date fechaInicial = this.jDateChooser1.getDate();
/* 4950 */           Date fechaFinal = convierteTextoAFecha(this.TablaGral.getValueAt(i, 4).toString());
/* 4951 */           long diferenciaDias = fechaInicial.getTime() - fechaFinal.getTime();
/* 4952 */           long dias = diferenciaDias / 86400000L;
/* 4953 */           if (dias <= 30L) {
/* 4954 */             this.TablaAux1.setValueAt(this.TablaGral.getValueAt(i, 6), i, 6);
/* 4955 */             TOTAL30 += convertirCantTexto(this.TablaGral.getValueAt(i, 6).toString());
/* 4956 */             this.TablaAux1.setValueAt("", i, 7);
/* 4957 */             this.TablaAux1.setValueAt("", i, 8);
/* 4958 */             this.TablaAux1.setValueAt("", i, 9);
/* 4959 */           } else if (dias > 30L && dias <= 60L) {
/* 4960 */             this.TablaAux1.setValueAt(this.TablaGral.getValueAt(i, 6), i, 7);
/* 4961 */             TOTAL60 += convertirCantTexto(this.TablaGral.getValueAt(i, 6).toString());
/* 4962 */             this.TablaAux1.setValueAt("", i, 6);
/* 4963 */             this.TablaAux1.setValueAt("", i, 8);
/* 4964 */             this.TablaAux1.setValueAt("", i, 9);
/* 4965 */           } else if (dias > 60L && dias <= 90L) {
/* 4966 */             this.TablaAux1.setValueAt(this.TablaGral.getValueAt(i, 6), i, 8);
/* 4967 */             TOTAL90 += convertirCantTexto(this.TablaGral.getValueAt(i, 6).toString());
/* 4968 */             this.TablaAux1.setValueAt("", i, 6);
/* 4969 */             this.TablaAux1.setValueAt("", i, 7);
/* 4970 */             this.TablaAux1.setValueAt("", i, 9);
/*      */           } else {
/* 4972 */             this.TablaAux1.setValueAt(this.TablaGral.getValueAt(i, 6), i, 9);
/* 4973 */             TOTALMAS += convertirCantTexto(this.TablaGral.getValueAt(i, 6).toString());
/* 4974 */             this.TablaAux1.setValueAt("", i, 6);
/* 4975 */             this.TablaAux1.setValueAt("", i, 7);
/* 4976 */             this.TablaAux1.setValueAt("", i, 8);
/*      */           } 
/* 4978 */           TOTALNETO += convertirCantTexto(this.TablaGral.getValueAt(i, 5).toString());
/*      */         } 
/* 4980 */         this.cantidad.setValue(Double.valueOf(TOTALNETO));
/* 4981 */         this.jLabel92.setText(this.cantidad.getText());
/*      */         
/* 4983 */         this.cantidad.setValue(Double.valueOf(TOTAL30));
/* 4984 */         this.jLabel93.setText(this.cantidad.getText());
/*      */         
/* 4986 */         this.cantidad.setValue(Double.valueOf(TOTAL60));
/* 4987 */         this.jLabel95.setText(this.cantidad.getText());
/*      */         
/* 4989 */         this.cantidad.setValue(Double.valueOf(TOTAL90));
/* 4990 */         this.jLabel96.setText(this.cantidad.getText());
/*      */         
/* 4992 */         this.cantidad.setValue(Double.valueOf(TOTALMAS));
/* 4993 */         this.jLabel97.setText(this.cantidad.getText());
/*      */         
/* 4995 */         TOTALDEBE = TOTAL30 + TOTAL60 + TOTAL90 + TOTALMAS;
/* 4996 */         this.cantidad.setValue(Double.valueOf(TOTALDEBE));
/* 4997 */         this.jLabel98.setText(this.cantidad.getText());
/*      */         
/*      */         try {
/* 5000 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 5001 */           String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/* 5002 */           String año = cadenaFecha1.substring(0, 4);
/* 5003 */           String mes = cadenaFecha1.substring(4, 6);
/* 5004 */           String dia = cadenaFecha1.substring(6, 8);
/* 5005 */           String fechaCompleta = dia + "/" + dia + "/" + mes;
/*      */           
/* 5007 */           String sicret = "LOGO.jpg";
/* 5008 */           String forsis = "forsis100x.jpg";
/* 5009 */           Map<Object, Object> datos = new HashMap<>();
/* 5010 */           datos.put("sucursal", this.CONFIGURACIONES[1]);
/*      */           
/* 5012 */           String[] DAT = this.con.regresaReg("calle,num,col,cp,ciudad,estado,rfc", "tarjeta_deudor_cliente,emp_generadora, estados", "where tarjeta_deudor_cliente.clave_gene = emp_generadora.clave_gene and emp_generadora.id_edo = estados.id_edo and tarjeta_deudor_cliente.tarjeta=" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)), 7);
/* 5013 */           datos.put("periodo", fechaCompleta);
/* 5014 */           datos.put("documento", iniciales(this.USUARIO).toUpperCase());
/* 5015 */           datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 5016 */           datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 5017 */           datos.put("cliente", this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/* 5018 */           datos.put("rfc", DAT[6]);
/* 5019 */           datos.put("direccion", DAT[0] + " " + DAT[0] + " " + DAT[1] + " " + DAT[2] + ", " + DAT[4] + ", " + DAT[3]);
/*      */           
/* 5021 */           datos.put("30Dias", this.jLabel93.getText());
/* 5022 */           datos.put("60Dias", this.jLabel95.getText());
/* 5023 */           datos.put("90Dias", this.jLabel96.getText());
/* 5024 */           datos.put("90Mas", this.jLabel97.getText());
/* 5025 */           datos.put("totalDebe", this.jLabel98.getText());
/*      */           
/* 5027 */           JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(this.TablaAux1.getModel());
/* 5028 */           JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Facturacion/ReporteSaldos.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 5029 */           JasperViewer visor = new JasperViewer(print, false);
/* 5030 */           visor.setTitle("Reporte de Saldos");
/* 5031 */           visor.setIconImage(this.iconoImprimir);
/* 5032 */           visor.setZoomRatio(0.59F);
/* 5033 */           visor.setExtendedState(6);
/* 5034 */           visor.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
/* 5035 */           visor.setVisible(true);
/*      */         }
/* 5037 */         catch (JRException e) {
/* 5038 */           System.out.println(e.getMessage());
/* 5039 */           Logger.getLogger(TarjetaCliente.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */         } 
/* 5041 */         this.jScrollPane8.setViewportView(this.TablaAux1);
/* 5042 */         this.jDialog9.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 5050 */     this.jDateChooser1.setEnabled(true);
/* 5051 */     this.jLabel42.setEnabled(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox12ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void metroTextBox1CaretUpdate(CaretEvent evt) {
/* 5059 */     consultar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void metroTextBox1KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 5067 */     consultar();
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 5071 */     this.jDialog17.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton20ActionPerformed(ActionEvent evt) {
/* 5075 */     this.jDialog17.setVisible(false);
/* 5076 */     if (this.jRadioButton6.isSelected()) {
/* 5077 */       this.jDialog10.setVisible(true);
/*      */     } else {
/* 5079 */       this.jDialog18.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton23ActionPerformed(ActionEvent evt) {
/* 5084 */     this.jDialog18.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton24ActionPerformed(ActionEvent evt) {
/* 5088 */     this.jDialog18.setVisible(false);
/* 5089 */     String[] campos = null;
/* 5090 */     double[] sumasM = null;
/* 5091 */     int vueltas = 0;
/* 5092 */     int cont = 0;
/* 5093 */     String[] Ttotales = null;
/* 5094 */     float FPROMEDIO = 0.0F;
/* 5095 */     String SPROMEDIO = "";
/* 5096 */     if (this.jComboBox2.getSelectedIndex() == 0) {
/* 5097 */       campos = new String[] { "Clave", "Nombre", "Actualizado", "Estatus", "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC", "PROM" };
/*      */       
/* 5099 */       Ttotales = new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/*      */       
/* 5101 */       sumasM = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/*      */       
/* 5103 */       vueltas = 12;
/* 5104 */     } else if (this.jComboBox2.getSelectedIndex() == 1) {
/* 5105 */       campos = new String[] { "Clave", "Nombre", "Actualizado", "Estatus", "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "PROM" };
/*      */       
/* 5107 */       Ttotales = new String[] { "", "", "", "", "", "", "", "", "", "", "" };
/*      */       
/* 5109 */       sumasM = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/* 5110 */       vueltas = 6;
/*      */     } else {
/* 5112 */       campos = new String[] { "Clave", "Nombre", "Actualizado", "Estatus", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC", "PROM" };
/*      */       
/* 5114 */       Ttotales = new String[] { "", "", "", "", "", "", "", "", "", "", "" };
/*      */       
/* 5116 */       sumasM = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/* 5117 */       vueltas = 6;
/* 5118 */       cont = 6;
/*      */     } 
/* 5120 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])campos));
/* 5121 */     this.jScrollPane12.setViewportView(this.jTable3);
/* 5122 */     DefaultTableModel temp = (DefaultTableModel)this.jTable3.getModel();
/* 5123 */     for (int i = 0; i < this.TablaAux1.getRowCount(); i++) {
/* 5124 */       String cantidad = this.TablaAux1.getValueAt(i, 5).toString();
/* 5125 */       if (!"$0.00".equals(cantidad)) {
/*      */         String[] arrayOfString;
/* 5127 */         Object[] nuevo = null;
/* 5128 */         if (this.jComboBox2.getSelectedIndex() == 0) {
/*      */           
/* 5130 */           arrayOfString = new String[] { this.TablaAux1.getValueAt(i, 0).toString(), this.TablaAux1.getValueAt(i, 2).toString(), this.TablaAux1.getValueAt(i, 3).toString(), "ACTIVA", "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0" };
/*      */         } else {
/*      */           
/* 5133 */           arrayOfString = new String[] { this.TablaAux1.getValueAt(i, 0).toString(), this.TablaAux1.getValueAt(i, 2).toString(), this.TablaAux1.getValueAt(i, 3).toString(), "ACTIVA", "$0", "$0", "$0", "$0", "$0", "$0", "$0" };
/*      */         } 
/* 5135 */         temp.addRow((Object[])arrayOfString);
/*      */       } 
/*      */     } 
/* 5138 */     this.jLabel103.setText("" + temp.getRowCount());
/* 5139 */     this.jLabel105.setText(this.jSpinner1.getValue().toString());
/* 5140 */     String añoSelec = this.jSpinner1.getValue().toString();
/* 5141 */     for (int j = 0; j < this.jTable3.getRowCount() - 2; j++) {
/* 5142 */       String llave = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 5143 */       String consulta = "";
/* 5144 */       boolean primera = true;
/* 5145 */       String and = "";
/* 5146 */       String numLetra = "";
/* 5147 */       for (int m = 1; m <= vueltas; m++) {
/* 5148 */         int otro = cont + m;
/* 5149 */         if (!primera) {
/* 5150 */           and = " or ";
/*      */         }
/* 5152 */         if (otro < 10) {
/* 5153 */           numLetra = "0" + otro;
/*      */         } else {
/* 5155 */           numLetra = "" + otro;
/*      */         } 
/* 5157 */         consulta = consulta + consulta + " mov=(select max(mov) from tarjeta_contenido_cliente where tarjeta =" + and + " and fecha like '" + llave + "-" + añoSelec + "-%%')";
/* 5158 */         primera = false;
/*      */       } 
/* 5160 */       String[][] registros = this.con.buscarDatos(3, "saldoFinalLetra,fecha,saldoFinal", "tarjeta_contenido_cliente", "where " + consulta);
/* 5161 */       float prom = 0.0F;
/* 5162 */       int n = 0;
/* 5163 */       for (int i1 = 0; i1 < registros.length; i1++) {
/* 5164 */         String mesesito = registros[i1][1].substring(5, 7);
/* 5165 */         int col = Integer.parseInt(mesesito) - cont;
/* 5166 */         this.jTable3.setValueAt(quitarDecimales(registros[i1][0]), j, 3 + col);
/* 5167 */         float cant = Float.parseFloat(registros[i1][2]);
/* 5168 */         sumasM[col - 1] = sumasM[col - 1] + cant;
/* 5169 */         if (cant > 0.0F) {
/* 5170 */           n++;
/* 5171 */           prom += cant;
/*      */         } 
/*      */       } 
/* 5174 */       prom /= n;
/* 5175 */       if (!Float.isNaN(prom)) {
/* 5176 */         this.cantidad.setValue(Float.valueOf(prom));
/* 5177 */         this.jTable3.setValueAt(quitarDecimales(this.cantidad.getText()), j, this.jTable3.getColumnCount() - 1);
/*      */       } 
/*      */     } 
/* 5180 */     int entraProm = 0;
/* 5181 */     for (int k = 0; k < sumasM.length; k++) {
/* 5182 */       this.cantidad.setValue(Double.valueOf(sumasM[k]));
/* 5183 */       Ttotales[k] = this.cantidad.getText();
/* 5184 */       if (sumasM[k] > 0.0D) {
/* 5185 */         FPROMEDIO = (float)(FPROMEDIO + sumasM[k]);
/* 5186 */         entraProm++;
/*      */       } 
/*      */     } 
/* 5189 */     FPROMEDIO /= entraProm;
/* 5190 */     this.cantidad.setValue(Float.valueOf(FPROMEDIO));
/* 5191 */     SPROMEDIO = quitarDecimales(this.cantidad.getText());
/*      */     try {
/* 5193 */       String sicret = "LOGO.jpg";
/* 5194 */       String forsis = "forsis100x.jpg";
/* 5195 */       Map<Object, Object> datos = new HashMap<>();
/* 5196 */       datos.put("sucursal", this.CAMPOSGENERALES.get("sucursal"));
/* 5197 */       datos.put("periodo", String.valueOf(this.jComboBox2.getSelectedItem()) + "/" + String.valueOf(this.jComboBox2.getSelectedItem()));
/* 5198 */       datos.put("usuario", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/* 5199 */       datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 5200 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 5201 */       datos.put("mes1", campos[4]);
/* 5202 */       datos.put("mes2", campos[5]);
/* 5203 */       datos.put("mes3", campos[6]);
/* 5204 */       datos.put("mes4", campos[7]);
/* 5205 */       datos.put("mes5", campos[8]);
/* 5206 */       datos.put("mes6", campos[9]);
/* 5207 */       datos.put("Tmes1", quitarDecimales(Ttotales[0]));
/* 5208 */       datos.put("Tmes2", quitarDecimales(Ttotales[1]));
/* 5209 */       datos.put("Tmes3", quitarDecimales(Ttotales[2]));
/* 5210 */       datos.put("Tmes4", quitarDecimales(Ttotales[3]));
/* 5211 */       datos.put("Tmes5", quitarDecimales(Ttotales[4]));
/* 5212 */       datos.put("Tmes6", quitarDecimales(Ttotales[5]));
/* 5213 */       datos.put("TProm", SPROMEDIO);
/* 5214 */       JasperPrint print = null;
/* 5215 */       if (this.jComboBox2.getSelectedIndex() == 0) {
/* 5216 */         datos.put("mes7", campos[10]);
/* 5217 */         datos.put("mes8", campos[11]);
/* 5218 */         datos.put("mes9", campos[12]);
/* 5219 */         datos.put("mes10", campos[13]);
/* 5220 */         datos.put("mes11", campos[14]);
/* 5221 */         datos.put("mes12", campos[15]);
/* 5222 */         datos.put("Tmes7", quitarDecimales(Ttotales[6]));
/* 5223 */         datos.put("Tmes8", quitarDecimales(Ttotales[7]));
/* 5224 */         datos.put("Tmes9", quitarDecimales(Ttotales[8]));
/* 5225 */         datos.put("Tmes10", quitarDecimales(Ttotales[9]));
/* 5226 */         datos.put("Tmes11", quitarDecimales(Ttotales[10]));
/* 5227 */         datos.put("Tmes12", quitarDecimales(Ttotales[11]));
/* 5228 */         JTable aux = crearTablaAux2(this.jTable3, new Object[] { "Cont", "Clave", "Proveedor", "Sucursal", "Estado", "Mes1", "Mes2", "Mes3", "Mes4", "Mes5", "Mes6", "Mes7", "Mes8", "Mes9", "Mes10", "Mes11", "Mes12", "Prom" });
/* 5229 */         JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 5230 */         print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Facturacion/FacturacionTarjetadeudor_Acumulado2.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/*      */       } else {
/* 5232 */         JTable aux = crearTablaAux1(this.jTable3, new Object[] { "Cont", "Clave", "Proveedor", "Sucursal", "Estado", "Mes1", "Mes2", "Mes3", "Mes4", "Mes5", "Mes6", "Prom" });
/* 5233 */         JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 5234 */         print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Facturacion/FacturacionTarjetadeudor_Acumulado1.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/*      */       } 
/* 5236 */       JasperViewer visor = new JasperViewer(print, false);
/* 5237 */       visor.setTitle("Reporte de saldos anual");
/* 5238 */       visor.setIconImage(this.iconoImprimir);
/* 5239 */       visor.setZoomRatio(0.59F);
/* 5240 */       visor.setExtendedState(6);
/* 5241 */       visor.setVisible(true);
/* 5242 */     } catch (JRException e) {
/* 5243 */       System.out.println(e.getMessage());
/* 5244 */       Logger.getLogger(TarjetaCliente.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 5249 */     for (int i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/* 5250 */       String cambio = this.rSTableMetro5.getValueAt(i, 14).toString();
/* 5251 */       String moneda = this.rSTableMetro5.getValueAt(i, 13).toString();
/* 5252 */       if (moneda.equals("USD") && (cambio.equals("1.0") || cambio.equals("1"))) {
/* 5253 */         String comp = this.rSTableMetro5.getValueAt(i, 16).toString();
/* 5254 */         if (!comp.equals("")) {
/* 5255 */           this.encontrado = this.con.consultar("fechaPago", "abonosfacturas, complementopagos", "where abonosfacturas.banco = complementopagos.folioPago and abonosfacturas.abono = '" + comp + "'");
/*      */           
/* 5257 */           if (this.encontrado) {
/* 5258 */             System.out.println("fecha = " + this.con.Campo);
/*      */             
/* 5260 */             Date fechita = this.utilerias.convertirFechaStringADate(this.con.Campo);
/* 5261 */             String fechaCorta = this.utilerias.convertirFechaDateString(fechita);
/* 5262 */             this.con.consultar("valor", "dolarhistoricoreal", "where fecha = '" + fechaCorta + "'");
/* 5263 */             this.con.inserSinMsj("update tarjeta_contenido_cliente set tipoCambio = '" + this.con.Campo + "' where mov = " + String.valueOf(this.rSTableMetro5.getValueAt(i, 0)));
/*      */           } 
/*      */         } else {
/*      */           
/* 5267 */           String fact = this.rSTableMetro5.getValueAt(i, 3).toString().substring(9, this.rSTableMetro5.getValueAt(i, 3).toString().length());
/*      */           
/* 5269 */           if (!fact.equals("")) {
/* 5270 */             this.con.consultar("fecha", "facturas33", "where folio = '" + fact + "'");
/* 5271 */             Date fechita = this.utilerias.convertirFechaStringADate(this.con.Campo);
/* 5272 */             String fechaCorta = this.utilerias.convertirFechaDateString(fechita);
/* 5273 */             this.con.consultar("valor", "dolarhistoricoreal", "where fecha = '" + fechaCorta + "'");
/* 5274 */             this.con.inserSinMsj("update tarjeta_contenido_cliente set tipoCambio = '" + this.con.Campo + "' where mov = " + String.valueOf(this.rSTableMetro5.getValueAt(i, 0)));
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 5282 */     for (int i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/* 5283 */       String cambio = this.rSTableMetro5.getValueAt(i, 14).toString();
/* 5284 */       String moneda = this.rSTableMetro5.getValueAt(i, 13).toString();
/* 5285 */       if (moneda.equals("USD") && (cambio.equals("1.0") || cambio.equals("1"))) {
/* 5286 */         String fact = this.rSTableMetro5.getValueAt(i, 3).toString().substring(9, this.rSTableMetro5.getValueAt(i, 3).toString().length());
/*      */         
/* 5288 */         if (!fact.equals("")) {
/* 5289 */           this.con.consultar("tipoCambio", "facturas33", "where folio = '" + fact + "'");
/* 5290 */           this.con.inserSinMsj("update tarjeta_contenido_cliente set tipoCambio = '" + this.con.Campo + "' where mov = " + String.valueOf(this.rSTableMetro5.getValueAt(i, 0)));
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
/*      */   private void jTextField2MouseClicked(MouseEvent evt) {
/* 5302 */     this.con.inserSinMsj("update tarjeta_deudor_cliente set totalMXN ='" + this.jTextField2.getText() + "' where tarjeta = " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux1(JTable Original, Object[] columnas) {
/* 5306 */     Object[] Columnas = columnas;
/* 5307 */     Object[][] registros = new Object[Original.getRowCount()][columnas.length];
/* 5308 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 5309 */       registros[i][0] = Integer.valueOf(i + 1);
/* 5310 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 5311 */         if (j == 0) {
/* 5312 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 5314 */         if (j == 1) {
/* 5315 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/* 5317 */         if (j == 2) {
/* 5318 */           registros[i][3] = Original.getValueAt(i, j);
/*      */         }
/* 5320 */         if (j == 3) {
/* 5321 */           registros[i][4] = Original.getValueAt(i, j);
/*      */         }
/* 5323 */         if (j == 4) {
/* 5324 */           registros[i][5] = Original.getValueAt(i, j);
/*      */         }
/* 5326 */         if (j == 5) {
/* 5327 */           registros[i][6] = Original.getValueAt(i, j);
/*      */         }
/* 5329 */         if (j == 6) {
/* 5330 */           registros[i][7] = Original.getValueAt(i, j);
/*      */         }
/* 5332 */         if (j == 7) {
/* 5333 */           registros[i][8] = Original.getValueAt(i, j);
/*      */         }
/* 5335 */         if (j == 8) {
/* 5336 */           registros[i][9] = Original.getValueAt(i, j);
/*      */         }
/* 5338 */         if (j == 9) {
/* 5339 */           registros[i][10] = Original.getValueAt(i, j);
/*      */         }
/* 5341 */         if (j == 10) {
/* 5342 */           registros[i][11] = Original.getValueAt(i, j);
/*      */         }
/*      */       } 
/*      */     } 
/* 5346 */     JTable aux = new JTable(registros, Columnas);
/* 5347 */     return aux;
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux2(JTable Original, Object[] columnas) {
/* 5351 */     Object[] Columnas = columnas;
/* 5352 */     Object[][] registros = new Object[Original.getRowCount()][columnas.length];
/* 5353 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 5354 */       registros[i][0] = Integer.valueOf(i + 1);
/* 5355 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 5356 */         if (j == 0) {
/* 5357 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 5359 */         if (j == 1) {
/* 5360 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/* 5362 */         if (j == 2) {
/* 5363 */           registros[i][3] = Original.getValueAt(i, j);
/*      */         }
/* 5365 */         if (j == 3) {
/* 5366 */           registros[i][4] = Original.getValueAt(i, j);
/*      */         }
/* 5368 */         if (j == 4) {
/* 5369 */           registros[i][5] = Original.getValueAt(i, j);
/*      */         }
/* 5371 */         if (j == 5) {
/* 5372 */           registros[i][6] = Original.getValueAt(i, j);
/*      */         }
/* 5374 */         if (j == 6) {
/* 5375 */           registros[i][7] = Original.getValueAt(i, j);
/*      */         }
/* 5377 */         if (j == 7) {
/* 5378 */           registros[i][8] = Original.getValueAt(i, j);
/*      */         }
/* 5380 */         if (j == 8) {
/* 5381 */           registros[i][9] = Original.getValueAt(i, j);
/*      */         }
/* 5383 */         if (j == 9) {
/* 5384 */           registros[i][10] = Original.getValueAt(i, j);
/*      */         }
/* 5386 */         if (j == 10) {
/* 5387 */           registros[i][11] = Original.getValueAt(i, j);
/*      */         }
/* 5389 */         if (j == 11) {
/* 5390 */           registros[i][12] = Original.getValueAt(i, j);
/*      */         }
/* 5392 */         if (j == 12) {
/* 5393 */           registros[i][13] = Original.getValueAt(i, j);
/*      */         }
/* 5395 */         if (j == 13) {
/* 5396 */           registros[i][14] = Original.getValueAt(i, j);
/*      */         }
/* 5398 */         if (j == 14) {
/* 5399 */           registros[i][15] = Original.getValueAt(i, j);
/*      */         }
/* 5401 */         if (j == 15) {
/* 5402 */           registros[i][16] = Original.getValueAt(i, j);
/*      */         }
/* 5404 */         if (j == 16) {
/* 5405 */           registros[i][17] = Original.getValueAt(i, j);
/*      */         }
/*      */       } 
/*      */     } 
/* 5409 */     JTable aux = new JTable(registros, Columnas);
/* 5410 */     return aux;
/*      */   }
/*      */   
/*      */   public Date convierteTextoAFecha(String fechaTexto) {
/* 5414 */     String fechaCorta = fechaTexto.substring(0, 10);
/* 5415 */     String año = fechaCorta.substring(0, 4);
/* 5416 */     String mes = fechaCorta.substring(5, 7);
/* 5417 */     String dia = fechaCorta.substring(8, 10);
/* 5418 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 5419 */     String strFecha = dia + "-" + dia + "-" + mes;
/* 5420 */     Date fechaT = null;
/*      */     try {
/* 5422 */       fechaT = formatoDelTexto.parse(strFecha);
/* 5423 */     } catch (ParseException ex) {
/* 5424 */       ex.printStackTrace();
/*      */     } 
/* 5426 */     return fechaT;
/*      */   }
/*      */   
/*      */   public String quitarDecimales(String cantidad) {
/* 5430 */     return cantidad.substring(0, cantidad.length() - 3);
/*      */   }
/*      */   
/*      */   public String iniciales(String usuario) {
/* 5434 */     String iniciales = "";
/* 5435 */     String[] nombres = this.con.regresaReg("nombre,ap_pat,ap_mat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + usuario + "'", 3);
/* 5436 */     iniciales = "" + nombres[0].charAt(0) + " " + nombres[0].charAt(0) + " " + nombres[1].charAt(0);
/* 5437 */     return iniciales;
/*      */   }
/*      */   
/*      */   public String buscarNumero(String cadena) {
/* 5441 */     boolean flag = false;
/* 5442 */     String numero = "";
/* 5443 */     char[] arreglo = cadena.toCharArray();
/* 5444 */     for (char caracter : arreglo) {
/* 5445 */       if (Character.isDigit(caracter)) {
/* 5446 */         numero = numero + numero;
/*      */       }
/*      */     } 
/* 5449 */     if (numero.equals("")) {
/* 5450 */       numero = "30";
/*      */     }
/*      */     
/* 5453 */     return numero;
/*      */   }
/*      */   
/*      */   public void abonarComplementoPago() {
/* 5457 */     int ind = this.rSTableMetro7.getRowCount();
/* 5458 */     if (this.jDateChooser4.getDate() == null) {
/* 5459 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas agregar la fecha del abono o depósito", "Falta fecha", 0, this.ERROR);
/* 5460 */     } else if (this.jTextField13.getText().equals("")) {
/* 5461 */       this.jTextField13.setBackground(Color.RED);
/* 5462 */       JOptionPane.showMessageDialog(this.jDialog3, "Te falta ingresar el folio del reporte que se autorizará con este abono", "Ingresa el reporte", 0, this.ERROR);
/* 5463 */     } else if (this.jRadioButton9.isSelected() && this.jTextField12.getText().equals("")) {
/* 5464 */       this.jTextField12.setBackground(Color.RED);
/* 5465 */       JOptionPane.showMessageDialog(this.jDialog3, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/* 5466 */     } else if (this.jTextField15.getText().equals("")) {
/* 5467 */       this.jTextField15.setBackground(Color.RED);
/* 5468 */       JOptionPane.showMessageDialog(this.jDialog3, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/* 5469 */     } else if (this.jTextField16.getText().equals("") && this.jTextField16.isEnabled()) {
/* 5470 */       this.jTextField16.setBackground(Color.RED);
/* 5471 */       JOptionPane.showMessageDialog(this.jDialog3, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/* 5472 */     } else if (this.jFormattedTextField1.getText().equals("$0.00")) {
/* 5473 */       this.jFormattedTextField1.setBackground(Color.RED);
/* 5474 */       JOptionPane.showMessageDialog(this.jDialog3, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/* 5475 */     } else if (ind == 0) {
/* 5476 */       JOptionPane.showMessageDialog(this.jDialog3, "Te falta agregar las facturas que serán amparadas para este abono", "Selecciona las facturas", 0, this.ERROR);
/*      */     } else {
/* 5478 */       sacarSaldosAcumulados();
/* 5479 */       if (this.SALDOACUMULADO > Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue()))) {
/* 5480 */         this.jFormattedTextField1.setBackground(Color.YELLOW);
/* 5481 */         JOptionPane.showMessageDialog(this.jDialog3, "El abono por todas las facturas es MAYOR al abono que colocaste\nVerifica tu información", "Abono Insuficiente", 0, this.ERROR);
/* 5482 */       } else if (this.SALDOACUMULADO < Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue()))) {
/* 5483 */         this.jFormattedTextField1.setBackground(Color.YELLOW);
/* 5484 */         JOptionPane.showMessageDialog(this.jDialog3, "El abono por todas las facturas es MENOR al abono que colocaste\nVerifica tu información", "Abonos no coinciden", 0, this.ERROR);
/*      */       } else {
/* 5486 */         String version = "";
/* 5487 */         this.encontrado = this.con.consultar("folio_ent", "entregar_facturas", "where folio_ent='" + this.jTextField13.getText() + "'");
/* 5488 */         if (!this.encontrado) {
/* 5489 */           this.encontrado = this.con.consultar("foliopago", "complementopagos", "where foliopago='" + this.jTextField13.getText() + "'");
/* 5490 */           if (this.encontrado) {
/* 5491 */             version = "3.3";
/* 5492 */             this.encontrado = this.con.consultar("monto", "complementopagos", "where foliopago = '" + this.jTextField13.getText() + "'");
/*      */           } else {
/* 5494 */             version = "";
/*      */           } 
/*      */         } else {
/* 5497 */           version = "3.2";
/* 5498 */           this.encontrado = this.con.consultar("montoParcial", "entregar_facturas", "where folio_ent = '" + this.jTextField13.getText() + "'");
/*      */         } 
/* 5500 */         if (this.encontrado) {
/* 5501 */           if (!this.con.Campo.equals(this.jFormattedTextField1.getText()) && !this.con.Campo.equals("")) {
/* 5502 */             this.jTextField13.setBackground(Color.RED);
/* 5503 */             this.jFormattedTextField1.setBackground(Color.RED);
/* 5504 */             JOptionPane.showMessageDialog(this.jDialog3, "Verifica tu información ya que los montos no corresponden al depósito del reporte con la cantidad ingresada", "Cantidades diferentes", 0, this.ERROR);
/*      */             return;
/*      */           } 
/*      */         } else {
/* 5508 */           this.jTextField13.setBackground(Color.RED);
/* 5509 */           JOptionPane.showMessageDialog(this.jDialog3, "Verifica tu información ya que el depósito no se encuentra en la base de datos", "Dato no encontrado", 0, this.ERROR);
/*      */           
/*      */           return;
/*      */         } 
/* 5513 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5514 */         String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 5515 */         String año = cadenaFecha1.substring(0, 4);
/* 5516 */         String mes = cadenaFecha1.substring(4, 6);
/* 5517 */         String dia = cadenaFecha1.substring(6, 8);
/* 5518 */         String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */         
/* 5520 */         this.encontrado = this.con.consultar("abono", "abonosFacturas", "where fecha = " + fechaCompleta + " and cuenta like '%" + this.jTextField16.getText() + "%' and montoLetra = '" + this.jFormattedTextField1.getText() + "'");
/* 5521 */         if (this.encontrado) {
/* 5522 */           this.jDateChooser4.setBackground(Color.YELLOW);
/* 5523 */           this.jTextField16.setBackground(Color.YELLOW);
/* 5524 */           this.jFormattedTextField1.setBackground(Color.YELLOW);
/* 5525 */           String[] datos = this.con.regresaReg("usuario_entrega,ref,fechaActual,cliente,folio_ent", "entregar_facturas", "where fecha = " + fechaCompleta + " and cuenta like '%" + this.jTextField16.getText() + "%' and monto = '" + this.jFormattedTextField1.getText() + "'", 5);
/* 5526 */           JOptionPane.showMessageDialog(this.jDialog3, "<html>Los datos que has ingresado son identicos al reporte de facturación  <b>" + datos[4] + ":</b><p><b>Cliente: </b>" + datos[3] + "<p><b>Usuario que creó: </b>" + datos[0] + "<p><b>Referencia: </b>" + datos[1] + "<p><b>Fecha de Captura: </b>" + datos[2] + "<p></b></html>", "Estos datos ya existen", 1, this.INFO);
/*      */         } 
/*      */         
/* 5529 */         String txtSalda = "";
/* 5530 */         double[] abonos = new double[this.rSTableMetro7.getRowCount()];
/* 5531 */         double[] saldado = new double[this.rSTableMetro7.getRowCount()];
/* 5532 */         double[] restante = new double[this.rSTableMetro7.getRowCount()];
/* 5533 */         this.COL1 = new String[this.rSTableMetro7.getRowCount()];
/* 5534 */         this.VALOR1 = 0.0D;
/* 5535 */         this.VALOR2 = 0.0D;
/*      */ 
/*      */         
/* 5538 */         String consulMov = "";
/* 5539 */         for (int i = 0; i < this.rSTableMetro7.getRowCount(); i++) {
/* 5540 */           consulMov = consulMov + " mov = " + consulMov;
/* 5541 */           if (i + 1 < this.rSTableMetro7.getRowCount()) {
/* 5542 */             consulMov = consulMov + " or ";
/*      */           }
/*      */         } 
/*      */         
/* 5546 */         String[] auxSaldado = this.con.regresaColIndex("importeSaldado", "tarjeta_contenido_cliente", "where " + consulMov);
/*      */         
/* 5548 */         for (int j = 0; j < this.rSTableMetro7.getRowCount(); j++) {
/* 5549 */           String factura = String.valueOf(this.rSTableMetro7.getValueAt(j, 1));
/* 5550 */           System.out.println("Factura " + factura.substring(0, 6));
/* 5551 */           String v1 = String.valueOf(this.rSTableMetro7.getValueAt(j, 3));
/* 5552 */           String v2 = String.valueOf(this.rSTableMetro7.getValueAt(j, 4));
/*      */           
/* 5554 */           if (!v1.equals(v2)) {
/* 5555 */             txtSalda = txtSalda + "\n" + txtSalda + "   <Abono>";
/*      */           } else {
/* 5557 */             txtSalda = txtSalda + "\n" + txtSalda + "   <Pagada>";
/*      */           } 
/* 5559 */           saldado[j] = Double.parseDouble(auxSaldado[j]);
/*      */           
/* 5561 */           String canti = v1;
/* 5562 */           String valorP = ""; int k;
/* 5563 */           for (k = 0; k < canti.length(); k++) {
/* 5564 */             if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 5565 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 5568 */           restante[j] = Double.parseDouble(valorP);
/*      */           
/* 5570 */           canti = v2;
/* 5571 */           valorP = "";
/* 5572 */           for (k = 0; k < canti.length(); k++) {
/* 5573 */             if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 5574 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 5577 */           abonos[j] = Double.parseDouble(valorP);
/*      */         } 
/*      */ 
/*      */         
/* 5581 */         System.out.println("Version " + version);
/* 5582 */         String[][] MovTabla = this.con.buscarDatos(4, "pago1,pago2,pago3,pago4", "tarjeta_contenido_cliente", " where" + consulMov);
/* 5583 */         this.jTextArea3.setText(txtSalda);
/* 5584 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, this.jPanel22, "Aplicar Saldos", 0, 3, this.PREG);
/* 5585 */         if (res == 0) {
/* 5586 */           int nAbono = 0;
/* 5587 */           int nPagada = 0;
/* 5588 */           this.TIPOS = new String[this.rSTableMetro7.getRowCount()];
/* 5589 */           sacarMayor();
/*      */           
/* 5591 */           String insertarFac = "";
/* 5592 */           String insertarGuias = "";
/*      */           
/* 5594 */           for (int k = 0; k < this.rSTableMetro7.getRowCount(); k++) {
/* 5595 */             String mov = String.valueOf(this.rSTableMetro7.getValueAt(k, 0));
/* 5596 */             String v1 = String.valueOf(this.rSTableMetro7.getValueAt(k, 3));
/* 5597 */             String v2 = String.valueOf(this.rSTableMetro7.getValueAt(k, 4));
/* 5598 */             String actRef = "pago4";
/*      */             
/* 5600 */             this.VALOR1 += regresaMonto(String.valueOf(this.rSTableMetro7.getValueAt(k, 2)));
/* 5601 */             if (MovTabla[k][0].equals("")) {
/* 5602 */               actRef = "pago1";
/* 5603 */             } else if (MovTabla[k][1].equals("")) {
/* 5604 */               actRef = "pago2";
/* 5605 */             } else if (MovTabla[k][2].equals("")) {
/* 5606 */               actRef = "pago3";
/* 5607 */             } else if (MovTabla[k][3].equals("")) {
/* 5608 */               actRef = "pago4";
/*      */             } 
/* 5610 */             if (!v1.equals(v2)) {
/* 5611 */               nAbono++;
/* 5612 */               double salda = saldado[k] + abonos[k];
/* 5613 */               salda = redondear(salda).doubleValue();
/* 5614 */               this.cantidad.setValue(Double.valueOf(salda));
/*      */               
/* 5616 */               restante[k] = restante[k] - abonos[k];
/* 5617 */               restante[k] = redondear(restante[k]).doubleValue();
/* 5618 */               this.auxiliar.setValue(Double.valueOf(restante[k]));
/*      */               
/* 5620 */               this.TIPOS[k] = "<ABONO>";
/* 5621 */               this.COL1[k] = this.auxiliar.getText();
/* 5622 */               this.VALOR2 += restante[k];
/*      */               
/* 5624 */               this.con.inserSinMsj("update tarjeta_contenido_cliente set " + actRef + "='" + this.jTextField15.getText().toUpperCase() + "-" + this.jTextField16.getText().toUpperCase() + "-" + this.jTextField17.getText().toUpperCase() + "-" + String.valueOf(this.rSTableMetro7.getValueAt(k, 4)) + "', importesaldado = " + salda + ", estatus='<Abono:" + this.cantidad.getText() + ">',importeRestante = " + restante[k] + ",importeRestanteLetra='" + this.auxiliar.getText() + "' where mov=" + mov);
/* 5625 */               if (version.equals("3.2")) {
/* 5626 */                 this.con.inserSinMsj("update facturas set estatus='<Abono: " + this.cantidad.getText() + ">' where folio ='" + dameFolioFactura(this.rSTableMetro7.getValueAt(k, 1).toString()) + "'");
/*      */               } else {
/* 5628 */                 String factura = dameFolioFactura(this.rSTableMetro7.getValueAt(k, 1).toString());
/* 5629 */                 int parcialidad = sacarParcialidad(factura);
/* 5630 */                 this.con.inserSinMsj("update facturas33 set estatus='<Abono: " + this.cantidad.getText() + ">', numParcialidad=" + parcialidad + ", totalDebe='" + this.auxiliar.getText() + "' where folio ='" + factura + "'");
/*      */               } 
/* 5632 */               insertarFac = insertarFac + " ('" + insertarFac + "','" + this.jTextField14.getText().toUpperCase() + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 1)) + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 2)) + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 4)) + "')";
/* 5633 */               insertarGuias = insertarGuias + " factImpresa='" + insertarGuias + "'";
/* 5634 */               if (k + 1 < this.rSTableMetro7.getRowCount()) {
/* 5635 */                 insertarFac = insertarFac + " , ";
/* 5636 */                 insertarGuias = insertarGuias + " or ";
/*      */               } 
/*      */             } else {
/* 5639 */               nPagada++;
/* 5640 */               this.TIPOS[k] = "<PAGADA>";
/* 5641 */               double salda = saldado[k] + abonos[k];
/* 5642 */               this.COL1[k] = "$0.00";
/* 5643 */               this.con.inserSinMsj("update tarjeta_contenido_cliente set " + actRef + "='" + this.jTextField15.getText().toUpperCase() + "-" + this.jTextField16.getText().toUpperCase() + "-" + this.jTextField17.getText().toUpperCase() + "-" + String.valueOf(this.rSTableMetro7.getValueAt(k, 4)) + "',estatus = '<Pagado:" + cargarFechaHoy3() + ">', importeSaldado = " + salda + ",importeRestante =0,importeRestanteLetra='$0.00' where mov=" + mov);
/* 5644 */               if (version.equals("3.2")) {
/* 5645 */                 this.con.inserSinMsj("update facturas set estatus='<Pagada: " + cargarFechaHoy3() + ">' where folio ='" + dameFolioFactura(this.rSTableMetro7.getValueAt(k, 1).toString()) + "'");
/*      */               } else {
/* 5647 */                 String factura = dameFolioFactura(this.rSTableMetro7.getValueAt(k, 1).toString());
/* 5648 */                 int parcialidad = sacarParcialidad(factura);
/* 5649 */                 this.con.inserSinMsj("update facturas33 set estatus='<Pagada: " + cargarFechaHoy3() + ">', numParcialidad=" + parcialidad + ", totalDebe='$0.00' where folio ='" + factura + "'");
/*      */               } 
/* 5651 */               insertarFac = insertarFac + "('" + insertarFac + "','" + this.jTextField14.getText().toUpperCase() + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 1)) + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 2)) + "','$0.00')";
/* 5652 */               insertarGuias = insertarGuias + " factImpresa='" + insertarGuias + "'";
/* 5653 */               if (k + 1 < this.rSTableMetro7.getRowCount()) {
/* 5654 */                 insertarFac = insertarFac + " , ";
/* 5655 */                 insertarGuias = insertarGuias + " or ";
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/* 5660 */           this.con.inserSinMsj("insert into facturastransferencias(num_abono,factura,importe,abono,saldo)values " + insertarFac);
/* 5661 */           if (!insertarGuias.equals("")) {
/* 5662 */             this.con.inserSinMsj("update guias set estatus='<Pagada: " + cargarFechaHoy3() + ">' where " + insertarGuias);
/*      */           }
/*      */           
/* 5665 */           int tipo = 1;
/* 5666 */           String concepto = "ABONO A FACTURAS";
/* 5667 */           if (this.jRadioButton9.isSelected()) {
/* 5668 */             tipo = 2;
/* 5669 */             concepto = this.jTextField12.getText().toUpperCase();
/*      */           } 
/*      */           
/* 5672 */           this.con.consultar("sum(importeRestante)", "tarjeta_contenido_cliente", "where tarjeta = " + this.CLAVECLIENTE);
/* 5673 */           double total = Double.parseDouble(this.con.Campo);
/* 5674 */           this.cantidad.setValue(Double.valueOf(total));
/* 5675 */           sacarMayor();
/* 5676 */           this.con.inserSinMsj("insert into abonosfacturas(abono,cliente,fecha,banco,cuenta,referencia,monto,montoLetra,TARJETA,USUARIO)values('" + this.jTextField14.getText().toUpperCase() + "','" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "'," + fechaCompleta + ",'" + this.jTextField15.getText().toUpperCase() + "','" + this.jTextField16.getText().toUpperCase() + "','" + this.jTextField17.getText().toUpperCase() + "'," + String.valueOf(this.jFormattedTextField1.getValue()) + ",'" + this.jFormattedTextField1.getText() + "'," + this.CLAVECLIENTE + ",'" + this.USUARIO + "')");
/* 5677 */           this.con.inserSinMsj("insert into tarjeta_contenido_cliente(fecha, tipoConcep,tipo,concepto,                  referencia,        importe,importeLetra,abono,                                abonoLetra,                  importeSaldado,importeRestante,importeRestanteLetra,estatus,comentario,factura,num_abono,saldoFinal,saldoFinalLetra,pago1,pago2,pago3,pago4,tarjeta,usuario, fechaPago)values(now(),    2," + tipo + ",'" + concepto + "','" + this.jTextField17
/* 5678 */               .getText().toUpperCase() + "',0,''," + String.valueOf(this.jFormattedTextField1.getValue()) + ",'" + this.jFormattedTextField1.getText() + "',0,             0,        '','<Aplicado>','','','" + this.jTextField14.getText() + "'," + total + ",'" + this.cantidad.getText() + "','','','',''," + this.CLAVECLIENTE + ",'" + this.USUARIO + "',now())");
/* 5679 */           this.con.inserSinMsj("update tarjeta_deudor_cliente set total='" + this.cantidad.getText() + "' where tarjeta=" + this.CLAVECLIENTE);
/* 5680 */           if (version.equals("3.2")) {
/* 5681 */             this.con.inserSinMsj("update entregar_facturas set estatus='<Recibido " + cargarFechaHoy2() + ">' where folio_ent='" + this.jTextField13.getText() + "'");
/*      */           } else {
/* 5683 */             this.con.inserSinMsj("update complementopagos set estatus='<Timbrado y Aplicado>' where folioPago='" + this.jTextField13.getText() + "'");
/*      */           } 
/*      */ 
/*      */           
/* 5687 */           String[] datos = this.con.regresaReg("abonosfacturas.tarjeta,empresa,calle,num,col,cp,ciudad,rfc", "tarjeta_deudor_cliente,abonosfacturas,emp_generadora", "where tarjeta_deudor_cliente.tarjeta = abonosfacturas.tarjeta and emp_generadora.clave_gene = tarjeta_deudor_cliente.clave_gene and tarjeta_deudor_cliente.Tarjeta=" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)), 8);
/* 5688 */           this.DATOS[0] = datos[1];
/* 5689 */           this.DATOS[1] = datos[2];
/* 5690 */           this.DATOS[2] = datos[3];
/* 5691 */           this.DATOS[3] = datos[4];
/* 5692 */           this.DATOS[4] = datos[5];
/* 5693 */           this.DATOS[5] = datos[6];
/* 5694 */           this.DATOS[6] = datos[7];
/*      */           
/* 5696 */           this.DATOS[8] = this.jTextField15.getText().toUpperCase();
/* 5697 */           this.DATOS[9] = this.jTextField16.getText().toUpperCase();
/* 5698 */           this.DATOS[10] = this.jTextField17.getText().toUpperCase();
/* 5699 */           this.DATOS[11] = dia + "/" + dia + "/" + mes;
/* 5700 */           this.DATOS[13] = "" + nAbono;
/* 5701 */           this.DATOS[14] = "" + nPagada;
/* 5702 */           this.DATOS[15] = "" + nAbono + nPagada;
/* 5703 */           this.DATOS[17] = this.jFormattedTextField1.getText();
/*      */           
/* 5705 */           ImprimirAbono impAbono = new ImprimirAbono();
/* 5706 */           impAbono.recibeDatos();
/* 5707 */           consultar3();
/* 5708 */           this.jDialog3.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public int añoActual() {
/* 5715 */     ZoneId defaultZoneId = ZoneId.systemDefault();
/* 5716 */     Instant instant = (new Date()).toInstant();
/* 5717 */     LocalDate fechaTrans = instant.atZone(defaultZoneId).toLocalDate();
/* 5718 */     return fechaTrans.getYear();
/*      */   }
/*      */   
/*      */   public void abonarNotaCredito() {
/* 5722 */     int ind = this.rSTableMetro7.getRowCount();
/* 5723 */     if (this.jDateChooser4.getDate() == null) {
/* 5724 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas agregar la fecha del abono o depósito", "Falta fecha", 0, this.ERROR);
/* 5725 */     } else if (this.jTextField13.getText().equals("")) {
/* 5726 */       this.jTextField13.setBackground(Color.RED);
/* 5727 */       JOptionPane.showMessageDialog(this.jDialog3, "Te falta ingresar el folio del reporte que se autorizará con este abono", "Ingresa el reporte", 0, this.ERROR);
/* 5728 */     } else if (this.jFormattedTextField1.getText().equals("$0.00")) {
/* 5729 */       this.jFormattedTextField1.setBackground(Color.RED);
/* 5730 */       JOptionPane.showMessageDialog(this.jDialog3, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/* 5731 */     } else if (ind == 0) {
/* 5732 */       JOptionPane.showMessageDialog(this.jDialog3, "Te falta agregar las facturas que serán amparadas para este abono", "Selecciona las facturas", 0, this.ERROR);
/*      */     } else {
/* 5734 */       sacarSaldosAcumulados();
/* 5735 */       if (this.SALDOACUMULADO > Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue()))) {
/* 5736 */         this.jFormattedTextField1.setBackground(Color.YELLOW);
/* 5737 */         JOptionPane.showMessageDialog(this.jDialog3, "El abono por todas las facturas es MAYOR al abono que colocaste\nVerifica tu información", "Abono Insuficiente", 0, this.ERROR);
/* 5738 */       } else if (this.SALDOACUMULADO < Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue()))) {
/* 5739 */         this.jFormattedTextField1.setBackground(Color.YELLOW);
/* 5740 */         JOptionPane.showMessageDialog(this.jDialog3, "El abono por todas las facturas es MENOR al abono que colocaste\nVerifica tu información", "Abonos no coinciden", 0, this.ERROR);
/*      */       } else {
/* 5742 */         this.encontrado = this.con.consultar("folio", "facturas33", "where folio='" + this.jTextField13.getText() + "'");
/* 5743 */         if (!this.encontrado) {
/* 5744 */           JOptionPane.showMessageDialog(this.jDialog3, "El folio que ingresaste no se encuentra activo, verifica el folio", "Folio no existe", 0, this.INFO);
/*      */         } else {
/* 5746 */           SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5747 */           String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 5748 */           String año = cadenaFecha1.substring(0, 4);
/* 5749 */           String mes = cadenaFecha1.substring(4, 6);
/* 5750 */           String dia = cadenaFecha1.substring(6, 8);
/* 5751 */           String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 5761 */           String txtSalda = "";
/* 5762 */           double[] abonos = new double[this.rSTableMetro7.getRowCount()];
/* 5763 */           double[] saldado = new double[this.rSTableMetro7.getRowCount()];
/* 5764 */           double[] restante = new double[this.rSTableMetro7.getRowCount()];
/* 5765 */           this.COL1 = new String[this.rSTableMetro7.getRowCount()];
/* 5766 */           this.VALOR1 = 0.0D;
/* 5767 */           this.VALOR2 = 0.0D;
/*      */ 
/*      */           
/* 5770 */           String consulMov = "";
/* 5771 */           for (int i = 0; i < this.rSTableMetro7.getRowCount(); i++) {
/* 5772 */             consulMov = consulMov + " mov = " + consulMov;
/* 5773 */             if (i + 1 < this.rSTableMetro7.getRowCount()) {
/* 5774 */               consulMov = consulMov + " or ";
/*      */             }
/*      */           } 
/*      */           
/* 5778 */           String[] auxSaldado = this.con.regresaColIndex("importeSaldado", "tarjeta_contenido_cliente", "where " + consulMov);
/*      */           
/* 5780 */           for (int j = 0; j < this.rSTableMetro7.getRowCount(); j++) {
/* 5781 */             String factura = String.valueOf(this.rSTableMetro7.getValueAt(j, 1));
/* 5782 */             System.out.println("Factura " + factura.substring(0, 6));
/* 5783 */             String v1 = String.valueOf(this.rSTableMetro7.getValueAt(j, 3));
/* 5784 */             String v2 = String.valueOf(this.rSTableMetro7.getValueAt(j, 4));
/*      */             
/* 5786 */             if (!v1.equals(v2)) {
/* 5787 */               txtSalda = txtSalda + "\n" + txtSalda + "   <Abono>";
/*      */             } else {
/* 5789 */               txtSalda = txtSalda + "\n" + txtSalda + "   <Pagada>";
/*      */             } 
/* 5791 */             saldado[j] = Double.parseDouble(auxSaldado[j]);
/*      */             
/* 5793 */             String canti = v1;
/* 5794 */             String valorP = ""; int k;
/* 5795 */             for (k = 0; k < canti.length(); k++) {
/* 5796 */               if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 5797 */                 valorP = valorP + valorP;
/*      */               }
/*      */             } 
/* 5800 */             restante[j] = Double.parseDouble(valorP);
/*      */             
/* 5802 */             canti = v2;
/* 5803 */             valorP = "";
/* 5804 */             for (k = 0; k < canti.length(); k++) {
/* 5805 */               if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 5806 */                 valorP = valorP + valorP;
/*      */               }
/*      */             } 
/* 5809 */             abonos[j] = Double.parseDouble(valorP);
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 5814 */           String[][] MovTabla = this.con.buscarDatos(4, "pago1,pago2,pago3,pago4", "tarjeta_contenido_cliente", " where" + consulMov);
/* 5815 */           this.jTextArea3.setText(txtSalda);
/* 5816 */           int res = JOptionPane.showConfirmDialog(this.jDialog3, this.jPanel22, "Aplicar Saldos", 0, 3, this.PREG);
/* 5817 */           if (res == 0) {
/* 5818 */             int nAbono = 0;
/* 5819 */             int nPagada = 0;
/* 5820 */             this.TIPOS = new String[this.rSTableMetro7.getRowCount()];
/* 5821 */             sacarMayor();
/*      */             
/* 5823 */             String insertarFac = "";
/* 5824 */             String insertarGuias = "";
/*      */             
/* 5826 */             for (int k = 0; k < this.rSTableMetro7.getRowCount(); k++) {
/* 5827 */               String mov = String.valueOf(this.rSTableMetro7.getValueAt(k, 0));
/* 5828 */               String v1 = String.valueOf(this.rSTableMetro7.getValueAt(k, 3));
/* 5829 */               String v2 = String.valueOf(this.rSTableMetro7.getValueAt(k, 4));
/* 5830 */               String actRef = "pago4";
/*      */               
/* 5832 */               this.VALOR1 += regresaMonto(String.valueOf(this.rSTableMetro7.getValueAt(k, 2)));
/* 5833 */               if (MovTabla[k][0].equals("")) {
/* 5834 */                 actRef = "pago1";
/* 5835 */               } else if (MovTabla[k][1].equals("")) {
/* 5836 */                 actRef = "pago2";
/* 5837 */               } else if (MovTabla[k][2].equals("")) {
/* 5838 */                 actRef = "pago3";
/* 5839 */               } else if (MovTabla[k][3].equals("")) {
/* 5840 */                 actRef = "pago4";
/*      */               } 
/* 5842 */               if (!v1.equals(v2)) {
/* 5843 */                 nAbono++;
/* 5844 */                 double salda = saldado[k] + abonos[k];
/* 5845 */                 salda = redondear(salda).doubleValue();
/* 5846 */                 this.cantidad.setValue(Double.valueOf(salda));
/*      */                 
/* 5848 */                 restante[k] = restante[k] - abonos[k];
/* 5849 */                 restante[k] = redondear(restante[k]).doubleValue();
/* 5850 */                 this.auxiliar.setValue(Double.valueOf(restante[k]));
/*      */                 
/* 5852 */                 this.TIPOS[k] = "<ABONO>";
/* 5853 */                 this.COL1[k] = this.auxiliar.getText();
/* 5854 */                 this.VALOR2 += restante[k];
/*      */                 
/* 5856 */                 this.con.inserSinMsj("update tarjeta_contenido_cliente set " + actRef + "='" + this.jTextField15.getText().toUpperCase() + "-" + this.jTextField16.getText().toUpperCase() + "-" + this.jTextField17.getText().toUpperCase() + "-" + String.valueOf(this.rSTableMetro7.getValueAt(k, 4)) + "', importesaldado = " + salda + ", estatus='<Abono:" + this.cantidad.getText() + ">',importeRestante = " + restante[k] + ",importeRestanteLetra='" + this.auxiliar.getText() + "' where mov=" + mov);
/*      */ 
/*      */ 
/*      */                 
/* 5860 */                 String factura = dameFolioFactura(this.rSTableMetro7.getValueAt(k, 1).toString());
/* 5861 */                 int parcialidad = sacarParcialidad(factura);
/* 5862 */                 this.con.inserSinMsj("update facturas33 set estatus='<Abono: " + this.cantidad.getText() + ">', numParcialidad=" + parcialidad + ", totalDebe='" + this.auxiliar.getText() + "' where folio ='" + factura + "'");
/*      */                 
/* 5864 */                 insertarFac = insertarFac + " ('" + insertarFac + "','" + this.jTextField14.getText().toUpperCase() + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 1)) + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 2)) + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 4)) + "')";
/* 5865 */                 insertarGuias = insertarGuias + " factImpresa='" + insertarGuias + "'";
/* 5866 */                 if (k + 1 < this.rSTableMetro7.getRowCount()) {
/* 5867 */                   insertarFac = insertarFac + " , ";
/* 5868 */                   insertarGuias = insertarGuias + " or ";
/*      */                 } 
/*      */               } else {
/* 5871 */                 nPagada++;
/* 5872 */                 this.TIPOS[k] = "<PAGADA>";
/* 5873 */                 double salda = saldado[k] + abonos[k];
/* 5874 */                 this.COL1[k] = "$0.00";
/* 5875 */                 this.con.inserSinMsj("update tarjeta_contenido_cliente set " + actRef + "='" + this.jTextField15.getText().toUpperCase() + "-" + this.jTextField16.getText().toUpperCase() + "-" + this.jTextField17.getText().toUpperCase() + "-" + String.valueOf(this.rSTableMetro7.getValueAt(k, 4)) + "',estatus = '<Pagado:" + cargarFechaHoy3() + ">', importeSaldado = " + salda + ",importeRestante =0,importeRestanteLetra='$0.00' where mov=" + mov);
/*      */ 
/*      */ 
/*      */                 
/* 5879 */                 String factura = dameFolioFactura(this.rSTableMetro7.getValueAt(k, 1).toString());
/* 5880 */                 int parcialidad = sacarParcialidad(factura);
/* 5881 */                 this.con.inserSinMsj("update facturas33 set estatus='<Pagada: " + cargarFechaHoy3() + ">', numParcialidad=" + parcialidad + ", totalDebe='$0.00' where folio ='" + factura + "'");
/*      */                 
/* 5883 */                 insertarFac = insertarFac + "('" + insertarFac + "','" + this.jTextField14.getText().toUpperCase() + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 1)) + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 2)) + "','$0.00')";
/* 5884 */                 insertarGuias = insertarGuias + " factImpresa='" + insertarGuias + "'";
/* 5885 */                 if (k + 1 < this.rSTableMetro7.getRowCount()) {
/* 5886 */                   insertarFac = insertarFac + " , ";
/* 5887 */                   insertarGuias = insertarGuias + " or ";
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             
/* 5892 */             this.con.inserSinMsj("insert into facturastransferencias(num_abono,factura,importe,abono,saldo)values " + insertarFac);
/* 5893 */             this.con.inserSinMsj("update facturas33 set estatus='<Aplicada>' where folio='" + this.jTextField13.getText() + "'");
/* 5894 */             if (!insertarGuias.equals("")) {
/* 5895 */               this.con.inserSinMsj("update guias set estatus='<Pagada: " + cargarFechaHoy3() + ">' where " + insertarGuias);
/*      */             }
/*      */             
/* 5898 */             int tipo = 1;
/* 5899 */             String concepto = "ABONO A FACTURAS";
/* 5900 */             if (this.jRadioButton9.isSelected()) {
/* 5901 */               tipo = 2;
/* 5902 */               concepto = this.jTextField12.getText().toUpperCase();
/*      */             } 
/*      */             
/* 5905 */             this.con.consultar("sum(importeRestante)", "tarjeta_contenido_cliente", "where tarjeta = " + this.CLAVECLIENTE);
/* 5906 */             double total = Double.parseDouble(this.con.Campo);
/* 5907 */             this.cantidad.setValue(Double.valueOf(total));
/* 5908 */             sacarMayor();
/* 5909 */             this.con.inserSinMsj("insert into abonosfacturas(abono,cliente,fecha,banco,cuenta,referencia,monto,montoLetra,TARJETA,USUARIO)values('" + this.jTextField14.getText().toUpperCase() + "','" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "'," + fechaCompleta + ",'" + this.jTextField15.getText().toUpperCase() + "','" + this.jTextField16.getText().toUpperCase() + "','" + this.jTextField17.getText().toUpperCase() + "'," + String.valueOf(this.jFormattedTextField1.getValue()) + ",'" + this.jFormattedTextField1.getText() + "'," + this.CLAVECLIENTE + ",'" + this.USUARIO + "')");
/* 5910 */             this.con.inserSinMsj("insert into tarjeta_contenido_cliente(fecha, tipoConcep,tipo,concepto,                  referencia,        importe,importeLetra,abono,                                abonoLetra,                  importeSaldado,importeRestante,importeRestanteLetra,estatus,comentario,factura,num_abono,saldoFinal,saldoFinalLetra,pago1,pago2,pago3,pago4,tarjeta,usuario,fechaPago)values(now(),    2," + tipo + ",'" + concepto + "','" + this.jTextField17
/* 5911 */                 .getText().toUpperCase() + "',0,''," + String.valueOf(this.jFormattedTextField1.getValue()) + ",'" + this.jFormattedTextField1.getText() + "',0,             0,        '','<Aplicado>','','','" + this.jTextField14.getText() + "'," + total + ",'" + this.cantidad.getText() + "','','','',''," + this.CLAVECLIENTE + ",'" + this.USUARIO + "',now())");
/* 5912 */             this.con.inserSinMsj("update tarjeta_deudor_cliente set total='" + this.cantidad.getText() + "' where tarjeta=" + this.CLAVECLIENTE);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 5920 */             String[] datos = this.con.regresaReg("abonosfacturas.tarjeta,empresa,calle,num,col,cp,ciudad,rfc", "tarjeta_deudor_cliente,abonosfacturas,emp_generadora", "where tarjeta_deudor_cliente.tarjeta = abonosfacturas.tarjeta and emp_generadora.clave_gene = tarjeta_deudor_cliente.clave_gene and tarjeta_deudor_cliente.Tarjeta=" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)), 8);
/* 5921 */             this.DATOS[0] = datos[1];
/* 5922 */             this.DATOS[1] = datos[2];
/* 5923 */             this.DATOS[2] = datos[3];
/* 5924 */             this.DATOS[3] = datos[4];
/* 5925 */             this.DATOS[4] = datos[5];
/* 5926 */             this.DATOS[5] = datos[6];
/* 5927 */             this.DATOS[6] = datos[7];
/*      */             
/* 5929 */             this.DATOS[8] = this.jTextField15.getText().toUpperCase();
/* 5930 */             this.DATOS[9] = this.jTextField16.getText().toUpperCase();
/* 5931 */             this.DATOS[10] = this.jTextField17.getText().toUpperCase();
/* 5932 */             this.DATOS[11] = dia + "/" + dia + "/" + mes;
/* 5933 */             this.DATOS[13] = "" + nAbono;
/* 5934 */             this.DATOS[14] = "" + nPagada;
/* 5935 */             this.DATOS[15] = "" + nAbono + nPagada;
/* 5936 */             this.DATOS[17] = this.jFormattedTextField1.getText();
/*      */             
/* 5938 */             ImprimirAbono impAbono = new ImprimirAbono();
/* 5939 */             impAbono.recibeDatos();
/* 5940 */             consultar3();
/* 5941 */             this.jDialog3.setVisible(false);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void abonarOtroConcepto() {
/* 5949 */     int ind = this.rSTableMetro7.getRowCount();
/* 5950 */     if (this.jDateChooser4.getDate() == null) {
/* 5951 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas agregar la fecha del abono o depósito", "Falta fecha", 0, this.ERROR);
/* 5952 */     } else if (this.jRadioButton9.isSelected() && this.jTextField12.getText().equals("")) {
/* 5953 */       this.jTextField12.setBackground(Color.RED);
/* 5954 */       JOptionPane.showMessageDialog(this.jDialog3, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/* 5955 */     } else if (this.jTextField15.getText().equals("")) {
/* 5956 */       this.jTextField15.setBackground(Color.RED);
/* 5957 */       JOptionPane.showMessageDialog(this.jDialog3, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/* 5958 */     } else if (this.jTextField16.getText().equals("") && this.jTextField16.isEnabled()) {
/* 5959 */       this.jTextField16.setBackground(Color.RED);
/* 5960 */       JOptionPane.showMessageDialog(this.jDialog3, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/* 5961 */     } else if (this.jFormattedTextField1.getText().equals("$0.00")) {
/* 5962 */       this.jFormattedTextField1.setBackground(Color.RED);
/* 5963 */       JOptionPane.showMessageDialog(this.jDialog3, "El campo esperaba algún un tipo de información", "Falta Información", 0, this.ERROR);
/* 5964 */     } else if (ind == 0) {
/* 5965 */       JOptionPane.showMessageDialog(this.jDialog3, "Te falta agregar las facturas que serán amparadas para este abono", "Selecciona las facturas", 0, this.ERROR);
/*      */     } else {
/* 5967 */       sacarSaldosAcumulados();
/* 5968 */       if (this.SALDOACUMULADO > Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue()))) {
/* 5969 */         this.jFormattedTextField1.setBackground(Color.YELLOW);
/* 5970 */         JOptionPane.showMessageDialog(this.jDialog3, "El abono por todas las facturas es MAYOR al abono que colocaste\nVerifica tu información", "Abono Insuficiente", 0, this.ERROR);
/* 5971 */       } else if (this.SALDOACUMULADO < Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue()))) {
/* 5972 */         this.jFormattedTextField1.setBackground(Color.YELLOW);
/* 5973 */         JOptionPane.showMessageDialog(this.jDialog3, "El abono por todas las facturas es MENOR al abono que colocaste\nVerifica tu información", "Abonos no coinciden", 0, this.ERROR);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6002 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 6003 */         String cadenaFecha1 = formato.format(this.jDateChooser4.getDate());
/* 6004 */         String año = cadenaFecha1.substring(0, 4);
/* 6005 */         String mes = cadenaFecha1.substring(4, 6);
/* 6006 */         String dia = cadenaFecha1.substring(6, 8);
/* 6007 */         String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6017 */         String txtSalda = "";
/* 6018 */         double[] abonos = new double[this.rSTableMetro7.getRowCount()];
/* 6019 */         double[] saldado = new double[this.rSTableMetro7.getRowCount()];
/* 6020 */         double[] restante = new double[this.rSTableMetro7.getRowCount()];
/* 6021 */         this.COL1 = new String[this.rSTableMetro7.getRowCount()];
/* 6022 */         this.VALOR1 = 0.0D;
/* 6023 */         this.VALOR2 = 0.0D;
/*      */ 
/*      */         
/* 6026 */         String consulMov = "";
/* 6027 */         for (int i = 0; i < this.rSTableMetro7.getRowCount(); i++) {
/* 6028 */           consulMov = consulMov + " mov = " + consulMov;
/* 6029 */           if (i + 1 < this.rSTableMetro7.getRowCount()) {
/* 6030 */             consulMov = consulMov + " or ";
/*      */           }
/*      */         } 
/*      */         
/* 6034 */         String[] auxSaldado = this.con.regresaColIndex("importeSaldado", "tarjeta_contenido_cliente", "where " + consulMov);
/*      */         
/* 6036 */         for (int j = 0; j < this.rSTableMetro7.getRowCount(); j++) {
/* 6037 */           String factura = String.valueOf(this.rSTableMetro7.getValueAt(j, 1));
/* 6038 */           System.out.println("Factura " + factura.substring(0, 6));
/* 6039 */           String v1 = String.valueOf(this.rSTableMetro7.getValueAt(j, 3));
/* 6040 */           String v2 = String.valueOf(this.rSTableMetro7.getValueAt(j, 4));
/*      */           
/* 6042 */           if (!v1.equals(v2)) {
/* 6043 */             txtSalda = txtSalda + "\n" + txtSalda + "   <Abono>";
/*      */           } else {
/* 6045 */             txtSalda = txtSalda + "\n" + txtSalda + "   <Pagada>";
/*      */           } 
/* 6047 */           saldado[j] = Double.parseDouble(auxSaldado[j]);
/*      */           
/* 6049 */           String canti = v1;
/* 6050 */           String valorP = ""; int k;
/* 6051 */           for (k = 0; k < canti.length(); k++) {
/* 6052 */             if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 6053 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 6056 */           restante[j] = Double.parseDouble(valorP);
/*      */           
/* 6058 */           canti = v2;
/* 6059 */           valorP = "";
/* 6060 */           for (k = 0; k < canti.length(); k++) {
/* 6061 */             if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 6062 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 6065 */           abonos[j] = Double.parseDouble(valorP);
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 6070 */         String[][] MovTabla = this.con.buscarDatos(4, "pago1,pago2,pago3,pago4", "tarjeta_contenido_cliente", " where" + consulMov);
/* 6071 */         this.jTextArea3.setText(txtSalda);
/* 6072 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, this.jPanel22, "Aplicar Saldos", 0, 3, this.PREG);
/* 6073 */         if (res == 0) {
/* 6074 */           int nAbono = 0;
/* 6075 */           int nPagada = 0;
/* 6076 */           this.TIPOS = new String[this.rSTableMetro7.getRowCount()];
/* 6077 */           sacarMayor();
/*      */           
/* 6079 */           String insertarFac = "";
/* 6080 */           String insertarGuias = "";
/*      */           
/* 6082 */           for (int k = 0; k < this.rSTableMetro7.getRowCount(); k++) {
/* 6083 */             String mov = String.valueOf(this.rSTableMetro7.getValueAt(k, 0));
/* 6084 */             String v1 = String.valueOf(this.rSTableMetro7.getValueAt(k, 3));
/* 6085 */             String v2 = String.valueOf(this.rSTableMetro7.getValueAt(k, 4));
/* 6086 */             String actRef = "pago4";
/*      */             
/* 6088 */             this.VALOR1 += regresaMonto(String.valueOf(this.rSTableMetro7.getValueAt(k, 2)));
/* 6089 */             if (MovTabla[k][0].equals("")) {
/* 6090 */               actRef = "pago1";
/* 6091 */             } else if (MovTabla[k][1].equals("")) {
/* 6092 */               actRef = "pago2";
/* 6093 */             } else if (MovTabla[k][2].equals("")) {
/* 6094 */               actRef = "pago3";
/* 6095 */             } else if (MovTabla[k][3].equals("")) {
/* 6096 */               actRef = "pago4";
/*      */             } 
/* 6098 */             if (!v1.equals(v2)) {
/* 6099 */               nAbono++;
/* 6100 */               double salda = saldado[k] + abonos[k];
/* 6101 */               salda = redondear(salda).doubleValue();
/* 6102 */               this.cantidad.setValue(Double.valueOf(salda));
/*      */               
/* 6104 */               restante[k] = restante[k] - abonos[k];
/* 6105 */               restante[k] = redondear(restante[k]).doubleValue();
/* 6106 */               this.auxiliar.setValue(Double.valueOf(restante[k]));
/*      */               
/* 6108 */               this.TIPOS[k] = "<ABONO>";
/* 6109 */               this.COL1[k] = this.auxiliar.getText();
/* 6110 */               this.VALOR2 += restante[k];
/*      */               
/* 6112 */               this.con.inserSinMsj("update tarjeta_contenido_cliente set " + actRef + "='" + this.jTextField15.getText().toUpperCase() + "-" + this.jTextField16.getText().toUpperCase() + "-" + this.jTextField17.getText().toUpperCase() + "-" + String.valueOf(this.rSTableMetro7.getValueAt(k, 4)) + "', importesaldado = " + salda + ", estatus='<Abono:" + this.cantidad.getText() + ">',importeRestante = " + restante[k] + ",importeRestanteLetra='" + this.auxiliar.getText() + "' where mov=" + mov);
/*      */ 
/*      */ 
/*      */               
/* 6116 */               String factura = dameFolioFactura(this.rSTableMetro7.getValueAt(k, 1).toString());
/* 6117 */               int parcialidad = sacarParcialidad(factura);
/* 6118 */               this.con.inserSinMsj("update facturas33 set estatus='<Abono: " + this.cantidad.getText() + ">', numParcialidad=" + parcialidad + ", totalDebe='" + this.auxiliar.getText() + "' where folio ='" + factura + "'");
/*      */               
/* 6120 */               this.con.inserSinMsj("update facturas set estatus='<Abono: " + this.cantidad.getText() + ">' where folio ='" + factura + "'");
/*      */               
/* 6122 */               insertarFac = insertarFac + " ('" + insertarFac + "','" + this.jTextField14.getText().toUpperCase() + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 1)) + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 2)) + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 4)) + "')";
/* 6123 */               insertarGuias = insertarGuias + " factImpresa='" + insertarGuias + "'";
/* 6124 */               if (k + 1 < this.rSTableMetro7.getRowCount()) {
/* 6125 */                 insertarFac = insertarFac + " , ";
/* 6126 */                 insertarGuias = insertarGuias + " or ";
/*      */               } 
/*      */             } else {
/* 6129 */               nPagada++;
/* 6130 */               this.TIPOS[k] = "<PAGADA>";
/* 6131 */               double salda = saldado[k] + abonos[k];
/* 6132 */               this.COL1[k] = "$0.00";
/* 6133 */               this.con.inserSinMsj("update tarjeta_contenido_cliente set " + actRef + "='" + this.jTextField15.getText().toUpperCase() + "-" + this.jTextField16.getText().toUpperCase() + "-" + this.jTextField17.getText().toUpperCase() + "-" + String.valueOf(this.rSTableMetro7.getValueAt(k, 4)) + "',estatus = '<Pagado:" + cargarFechaHoy3() + ">', importeSaldado = " + salda + ",importeRestante =0,importeRestanteLetra='$0.00' where mov=" + mov);
/*      */ 
/*      */ 
/*      */               
/* 6137 */               String factura = dameFolioFactura(this.rSTableMetro7.getValueAt(k, 1).toString());
/* 6138 */               int parcialidad = sacarParcialidad(factura);
/* 6139 */               this.con.inserSinMsj("update facturas33 set estatus='<Pagada: " + cargarFechaHoy3() + ">', numParcialidad=" + parcialidad + ", totalDebe='$0.00' where folio ='" + factura + "'");
/*      */               
/* 6141 */               this.con.inserSinMsj("update facturas set estatus='<Pagada: " + cargarFechaHoy3() + ">' where folio ='" + factura + "'");
/*      */               
/* 6143 */               insertarFac = insertarFac + "('" + insertarFac + "','" + this.jTextField14.getText().toUpperCase() + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 1)) + "','" + String.valueOf(this.rSTableMetro7.getValueAt(k, 2)) + "','$0.00')";
/* 6144 */               insertarGuias = insertarGuias + " factImpresa='" + insertarGuias + "'";
/* 6145 */               if (k + 1 < this.rSTableMetro7.getRowCount()) {
/* 6146 */                 insertarFac = insertarFac + " , ";
/* 6147 */                 insertarGuias = insertarGuias + " or ";
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/* 6152 */           this.con.inserSinMsj("insert into facturastransferencias(num_abono,factura,importe,abono,saldo)values " + insertarFac);
/* 6153 */           if (!insertarGuias.equals("")) {
/* 6154 */             this.con.inserSinMsj("update guias set estatus='<Pagada: " + cargarFechaHoy3() + ">' where " + insertarGuias);
/*      */           }
/*      */           
/* 6157 */           int tipo = 1;
/* 6158 */           String concepto = "ABONO A FACTURAS";
/* 6159 */           if (this.jRadioButton9.isSelected()) {
/* 6160 */             tipo = 2;
/* 6161 */             concepto = this.jTextField12.getText().toUpperCase();
/*      */           } 
/*      */           
/* 6164 */           this.con.consultar("sum(importeRestante)", "tarjeta_contenido_cliente", "where tarjeta = " + this.CLAVECLIENTE);
/* 6165 */           double total = Double.parseDouble(this.con.Campo);
/* 6166 */           this.cantidad.setValue(Double.valueOf(total));
/* 6167 */           sacarMayor();
/* 6168 */           this.con.inserSinMsj("insert into abonosfacturas(abono,cliente,fecha,banco,cuenta,referencia,monto,montoLetra,TARJETA,USUARIO)values('" + this.jTextField14.getText().toUpperCase() + "','" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2)) + "'," + fechaCompleta + ",'" + this.jTextField15.getText().toUpperCase() + "','" + this.jTextField16.getText().toUpperCase() + "','" + this.jTextField17.getText().toUpperCase() + "'," + String.valueOf(this.jFormattedTextField1.getValue()) + ",'" + this.jFormattedTextField1.getText() + "'," + this.CLAVECLIENTE + ",'" + this.USUARIO + "')");
/* 6169 */           this.con.inserSinMsj("insert into tarjeta_contenido_cliente(fecha, tipoConcep,tipo,concepto,                  referencia,        importe,importeLetra,abono,                                abonoLetra,                  importeSaldado,importeRestante,importeRestanteLetra,estatus,comentario,factura,num_abono,saldoFinal,saldoFinalLetra,pago1,pago2,pago3,pago4,tarjeta,usuario, fechaPago)values(now(),    2," + tipo + ",'" + concepto + "','" + this.jTextField17
/* 6170 */               .getText().toUpperCase() + "',0,''," + String.valueOf(this.jFormattedTextField1.getValue()) + ",'" + this.jFormattedTextField1.getText() + "',0,             0,        '','<Aplicado>','','','" + this.jTextField14.getText() + "'," + total + ",'" + this.cantidad.getText() + "','','','',''," + this.CLAVECLIENTE + ",'" + this.USUARIO + "',now())");
/* 6171 */           this.con.inserSinMsj("update tarjeta_deudor_cliente set total='" + this.cantidad.getText() + "' where tarjeta=" + this.CLAVECLIENTE);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 6179 */           String[] datos = this.con.regresaReg("abonosfacturas.tarjeta,empresa,calle,num,col,cp,ciudad,rfc", "tarjeta_deudor_cliente,abonosfacturas,emp_generadora", "where tarjeta_deudor_cliente.tarjeta = abonosfacturas.tarjeta and emp_generadora.clave_gene = tarjeta_deudor_cliente.clave_gene and tarjeta_deudor_cliente.Tarjeta=" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)), 8);
/* 6180 */           this.DATOS[0] = datos[1];
/* 6181 */           this.DATOS[1] = datos[2];
/* 6182 */           this.DATOS[2] = datos[3];
/* 6183 */           this.DATOS[3] = datos[4];
/* 6184 */           this.DATOS[4] = datos[5];
/* 6185 */           this.DATOS[5] = datos[6];
/* 6186 */           this.DATOS[6] = datos[7];
/*      */           
/* 6188 */           this.DATOS[8] = this.jTextField15.getText().toUpperCase();
/* 6189 */           this.DATOS[9] = this.jTextField16.getText().toUpperCase();
/* 6190 */           this.DATOS[10] = this.jTextField17.getText().toUpperCase();
/* 6191 */           this.DATOS[11] = dia + "/" + dia + "/" + mes;
/* 6192 */           this.DATOS[13] = "" + nAbono;
/* 6193 */           this.DATOS[14] = "" + nPagada;
/* 6194 */           this.DATOS[15] = "" + nAbono + nPagada;
/* 6195 */           this.DATOS[17] = this.jFormattedTextField1.getText();
/*      */           
/* 6197 */           ImprimirAbono impAbono = new ImprimirAbono();
/* 6198 */           impAbono.recibeDatos();
/* 6199 */           verTarjeta();
/* 6200 */           this.jDialog3.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String dameFolioFactura(String ref) {
/* 6207 */     String[] fact = ref.split(": ");
/* 6208 */     return fact[1];
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 6212 */     String canti = cant;
/* 6213 */     String valorP = "";
/* 6214 */     for (int j = 0; j < canti.length(); j++) {
/* 6215 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 6216 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 6219 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public int sacarParcialidad(String folio) {
/* 6223 */     this.con.consultar("numParcialidad", "facturas33", "where folio ='" + folio + "'");
/* 6224 */     int parcialidad = Integer.parseInt(this.con.Campo);
/* 6225 */     parcialidad++;
/* 6226 */     return parcialidad;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void buscarFacturas() {
/* 6232 */     this.rSTableMetro6.setModel(new DefaultTableModel((Object[][])this.con
/* 6233 */           .buscarDatos(4, "mov,referencia,importeLetra,importeRestanteLetra,estatus", "tarjeta_contenido_cliente", "where (estatus='<Por Pagar>' || estatus like '%Abono:%') and tarjeta=" + this.CLAVECLIENTE + " and factura like '%" + this.jTextField11.getText() + "%' ORDER BY MOV desc"), (Object[])new String[] { "Mov", "Referencia", "Importe", "Resta" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 6238 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 6248 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6253 */             return this.canEdit[columnIndex];
/*      */           }
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 6257 */             return this.types[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 6261 */     this.rSTableMetro6.setShowVerticalLines(false);
/* 6262 */     this.rSTableMetro6.setSelectionMode(0);
/* 6263 */     this.rSTableMetro6.setAutoCreateRowSorter(true);
/*      */     
/* 6265 */     this.rSTableMetro6.getColumnModel().getColumn(0).setPreferredWidth(45);
/* 6266 */     this.rSTableMetro6.getColumnModel().getColumn(0).setMaxWidth(45);
/*      */     
/* 6268 */     this.rSTableMetro6.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 6269 */     this.rSTableMetro6.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void capturarDocumento() {
/* 6273 */     if (this.jTextField13.getText().equals("")) {
/* 6274 */       this.jTextField13.setBackground(Color.RED);
/* 6275 */       JOptionPane.showMessageDialog(this.jDialog3, "El campo esperaba el número de reporte de deposito de facturación", "Falta Folio", 0, this.ERROR);
/*      */     } else {
/* 6277 */       boolean seguir = true;
/* 6278 */       String nombre = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2));
/* 6279 */       this.encontrado = this.con.consultar("folio_ent", "entregar_facturas", "where folio_ent='" + this.jTextField13.getText() + "'");
/* 6280 */       String version = "";
/* 6281 */       String[] datos = null;
/* 6282 */       if (!this.encontrado) {
/* 6283 */         this.encontrado = this.con.consultar("foliopago", "complementopagos", "where foliopago='" + this.jTextField13.getText() + "'");
/* 6284 */         if (this.encontrado) {
/* 6285 */           version = "3.3";
/* 6286 */           datos = this.con.regresaReg("bancoDestino, cuentaDestino, numeroOperacion, monto, cliente", "complementopagos", " where foliopago='" + this.jTextField13.getText() + "'", 5);
/* 6287 */           nombre = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/*      */         } else {
/* 6289 */           datos = this.con.regresaReg("bancoDestino, cuentaDestino, numeroOperacion, monto, cliente", "complementopagos", " where foliopago='" + this.jTextField13.getText() + "'", 5);
/* 6290 */           version = "";
/*      */         } 
/*      */       } else {
/* 6293 */         version = "3.2";
/* 6294 */         datos = this.con.regresaReg("banco, cuenta, ref, montoParcial, cliente", "entregar_facturas", " where folio_ent='" + this.jTextField13.getText() + "'", 5);
/* 6295 */         nombre = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2));
/*      */       } 
/* 6297 */       if (version.equals("")) {
/* 6298 */         JOptionPane.showMessageDialog(this.jDialog3, "El folio del comprobante de pago no se encuentra en la base de datos", "Folio no encontrado", 0, this.ADVER);
/*      */       } else {
/* 6300 */         if (!datos[4].equals(nombre)) {
/* 6301 */           int res = JOptionPane.showConfirmDialog(this.jDialog3, "El folio del reporte corresponde a otro cliente: " + datos[4] + "\n¿Deseas seguir?", "Otro cliente", 0, 3, this.PREG);
/* 6302 */           if (res == 0) {
/* 6303 */             seguir = true;
/*      */           } else {
/* 6305 */             seguir = false;
/*      */           } 
/*      */         } 
/* 6308 */         if (seguir) {
/* 6309 */           if (datos[1].equals("")) {
/* 6310 */             this.jTextField16.setEnabled(false);
/*      */           }
/* 6312 */           this.jTextField16.setText(datos[0]);
/* 6313 */           this.jTextField17.setText(datos[1]);
/* 6314 */           this.jTextField15.setText(datos[2]);
/*      */           
/* 6316 */           double total = 0.0D;
/*      */           
/* 6318 */           String canti = datos[3];
/* 6319 */           String valorP = "";
/* 6320 */           for (int i = 0; i < canti.length(); i++) {
/* 6321 */             if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 6322 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 6325 */           total = Double.parseDouble(valorP);
/* 6326 */           this.jFormattedTextField1.setValue(Double.valueOf(total));
/*      */           
/* 6328 */           String[][] datitos = this.con.buscarDatos(4, "folioInterno, importeOriginal, importeAnterior, importeSaldado", "complementopagosfacturas", "where folioPago = '" + this.jTextField13.getText() + "'");
/*      */           
/* 6330 */           for (int j = 0; j < datitos.length; j++) {
/* 6331 */             System.out.println("dat " + datitos[j][0]);
/* 6332 */             System.out.println("dat " + datitos[j][1]);
/* 6333 */             System.out.println("dat " + datitos[j][2]);
/*      */             
/* 6335 */             for (int k = 0; k < this.rSTableMetro6.getRowCount(); k++) {
/* 6336 */               String factura = String.valueOf(this.rSTableMetro6.getValueAt(k, 1));
/* 6337 */               if (factura.contains(datitos[j][0])) {
/*      */                 
/* 6339 */                 DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro7.getModel();
/* 6340 */                 String[] arrayOfString = new String[5];
/* 6341 */                 arrayOfString[0] = (String)this.rSTableMetro6.getValueAt(k, 0);
/* 6342 */                 arrayOfString[1] = (String)this.rSTableMetro6.getValueAt(k, 1);
/* 6343 */                 arrayOfString[2] = (String)this.rSTableMetro6.getValueAt(k, 2);
/* 6344 */                 arrayOfString[3] = (String)this.rSTableMetro6.getValueAt(k, 3);
/* 6345 */                 arrayOfString[4] = (String)this.rSTableMetro6.getValueAt(k, 3);
/* 6346 */                 temp.addRow((Object[])arrayOfString);
/*      */                 
/* 6348 */                 temp = (DefaultTableModel)this.rSTableMetro6.getModel();
/* 6349 */                 temp.removeRow(k);
/* 6350 */                 sumarFacturas();
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void capturarNotaCredito() {
/* 6362 */     if (this.jTextField13.getText().equals("")) {
/* 6363 */       this.jTextField13.setBackground(Color.RED);
/* 6364 */       JOptionPane.showMessageDialog(this.jDialog3, "El campo esperaba el número de reporte de deposito de facturación", "Falta Folio", 0, this.ERROR);
/*      */     } else {
/* 6366 */       boolean seguir = true;
/* 6367 */       String tarjeta = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 6368 */       this.encontrado = this.con.consultar("total", "facturas33", "where folio='" + this.jTextField13.getText() + "' and estatus='<Por Pagar>'");
/* 6369 */       String[] datos = null;
/* 6370 */       if (this.encontrado) {
/* 6371 */         this.jTextField15.setText(this.jTextField13.getText().toUpperCase());
/* 6372 */         this.jFormattedTextField1.setValue(Double.valueOf(convertirCantTexto(this.con.Campo)));
/*      */       } else {
/* 6374 */         JOptionPane.showMessageDialog(this.jDialog3, "El folio que ingresaste no se encuentra activo, verifica el folio", "Folio no existe", 0, this.INFO);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void pasarAbajo() {
/* 6380 */     int ind = this.rSTableMetro6.getSelectedRow();
/* 6381 */     DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro7.getModel();
/* 6382 */     String[] arrayOfString = new String[5];
/* 6383 */     arrayOfString[0] = (String)this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 0);
/* 6384 */     arrayOfString[1] = (String)this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1);
/* 6385 */     arrayOfString[2] = (String)this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 2);
/* 6386 */     arrayOfString[3] = (String)this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 3);
/* 6387 */     arrayOfString[4] = (String)this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 3);
/* 6388 */     temp.addRow((Object[])arrayOfString);
/*      */     
/* 6390 */     temp = (DefaultTableModel)this.rSTableMetro6.getModel();
/* 6391 */     temp.removeRow(ind);
/* 6392 */     sumarFacturas();
/*      */   }
/*      */   
/*      */   public void sumarFacturas() {
/* 6396 */     double TOTAL = 0.0D;
/* 6397 */     for (int j = 0; j < this.rSTableMetro7.getRowCount(); j++) {
/* 6398 */       String canti = String.valueOf(this.rSTableMetro7.getValueAt(j, 4));
/* 6399 */       String valorP = "";
/* 6400 */       for (int i = 0; i < canti.length(); i++) {
/* 6401 */         if (canti.charAt(i) != '$' && canti.charAt(i) != ',' && canti.charAt(i) != '-') {
/* 6402 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 6405 */       TOTAL += Double.parseDouble(valorP);
/*      */     } 
/* 6407 */     this.auxiliar.setValue(Double.valueOf(TOTAL));
/* 6408 */     this.jLabel37.setText(this.auxiliar.getText());
/* 6409 */     this.jLabel39.setText("" + this.rSTableMetro7.getRowCount());
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 6413 */     this.pintar.colorear(this.jComboBox1);
/* 6414 */     this.metroTextBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6416 */             TarjetaCliente.this.jTextGanado((JComponent)TarjetaCliente.this.metroTextBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6420 */             TarjetaCliente.this.jTextPerdido((JComponent)TarjetaCliente.this.metroTextBox1, evt);
/*      */           }
/*      */         });
/* 6423 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6425 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6429 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 6432 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6434 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextField11, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6438 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextField11, evt);
/*      */           }
/*      */         });
/* 6441 */     this.jTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6443 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextField13, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6447 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextField13, evt);
/*      */           }
/*      */         });
/* 6450 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6452 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6456 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextField4, evt);
/*      */           }
/*      */         });
/*      */     
/* 6460 */     this.jTextField12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6462 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextField12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6466 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextField12, evt);
/*      */           }
/*      */         });
/* 6469 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6471 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextField15, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6475 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextField15, evt);
/*      */           }
/*      */         });
/* 6478 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6480 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextField16, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6484 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextField16, evt);
/*      */           }
/*      */         });
/* 6487 */     this.jTextField17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6489 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextField17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6493 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextField17, evt);
/*      */           }
/*      */         });
/* 6496 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6498 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextField4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6502 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 6505 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6507 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextField10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6511 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextField10, evt);
/*      */           }
/*      */         });
/* 6514 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6516 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jComboBox6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6520 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jComboBox6, evt);
/*      */           }
/*      */         });
/* 6523 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6525 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6529 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 6532 */     this.jTextField18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6534 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextField18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6538 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextField18, evt);
/*      */           }
/*      */         });
/* 6541 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6543 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6547 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 6550 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6552 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jFormattedTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6556 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/* 6559 */     this.jTextArea2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6561 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextArea2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6565 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextArea2, evt);
/*      */           }
/*      */         });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6576 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6578 */             TarjetaCliente.this.jTextGanado(TarjetaCliente.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6582 */             TarjetaCliente.this.jTextPerdido(TarjetaCliente.this.jTextArea5, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 6588 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 6592 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void TarjetaCliente(String usu) {
/* 6596 */     this.USUARIO = usu;
/* 6597 */     this.panel.setViewportView(this);
/* 6598 */     privilegios();
/* 6599 */     consultar();
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 6603 */     String moneda = "";
/* 6604 */     String campo = "total";
/*      */     
/* 6606 */     if (this.jComboBox1.getSelectedIndex() == 2) {
/* 6607 */       moneda = "and nombre_corto like '%USD%'";
/* 6608 */       campo = "totalMXN";
/* 6609 */     } else if (this.jComboBox1.getSelectedIndex() == 3) {
/* 6610 */       moneda = "and nombre_corto not like '%USD%'";
/* 6611 */     } else if (this.jComboBox1.getSelectedIndex() == 4) {
/* 6612 */       moneda = "and nombre_corto like '%USD%'";
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6620 */     this.jButton10.setEnabled(false);
/* 6621 */     String nombre = "";
/* 6622 */     if (!this.metroTextBox1.getText().equals("")) {
/* 6623 */       nombre = this.metroTextBox1.getText();
/*      */     }
/* 6625 */     this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con
/* 6626 */           .buscarDatos(7, "tarjeta,nombreCompleto,nombre_corto,f_creacion,usuario_creo," + campo + ", totalMXN", "tarjeta_deudor_cliente", "where nombrecompleto like '%" + nombre + "%' " + moneda + " and tarjeta<>0 order by nombreCompleto"), (Object[])new String[] { "Folio", "Cliente", "Nombre Comercial", "Fecha", "Documentó", "Saldo", "SaldoMXN" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 6631 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6636 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 6640 */     this.TablaAux1.setModel(new DefaultTableModel((Object[][])this.con
/* 6641 */           .buscarDatos(7, "tarjeta,nombreCompleto,nombre_corto,f_creacion,usuario_creo,total, totalMXN", "tarjeta_deudor_cliente", "where nombrecompleto like '%" + nombre + "%' " + moneda + " and tarjeta<>0 order by nombre_corto"), (Object[])new String[] { "Folio", "Cliente", "Nombre Comercial", "Fecha", "Documentó", "Saldo", "SaldoMXN" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 6646 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6651 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 6655 */     if (this.jComboBox1.getSelectedIndex() == 1) {
/* 6656 */       for (int j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/* 6657 */         String usd = this.rSTableMetro1.getValueAt(j, 2).toString();
/* 6658 */         if (usd.contains("USD")) {
/* 6659 */           this.rSTableMetro1.setValueAt(this.rSTableMetro1.getValueAt(j, 6), j, 5);
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/* 6664 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 6665 */     this.rSTableMetro1.setSelectionMode(0);
/* 6666 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 6667 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 6668 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 6669 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     
/* 6671 */     this.rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(120);
/* 6672 */     this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(120);
/* 6673 */     this.rSTableMetro1.getColumnModel().getColumn(5).setPreferredWidth(150);
/* 6674 */     this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(150);
/*      */     
/* 6676 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 6677 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 6678 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 6679 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 6680 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 6681 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 6682 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/* 6683 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 6684 */     this.rSTableMetro1.setShowVerticalLines(false);
/*      */     
/* 6686 */     this.jLabel49.setText("$0.00");
/* 6687 */     double valorS = 0.0D;
/* 6688 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 6689 */       String canti = String.valueOf(this.rSTableMetro1.getValueAt(i, 5));
/* 6690 */       String valorP = "";
/* 6691 */       for (int j = 0; j < canti.length(); j++) {
/* 6692 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 6693 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 6696 */       valorS += Double.parseDouble(valorP);
/* 6697 */       this.cantidad.setValue(Double.valueOf(valorS));
/* 6698 */       this.jLabel49.setText(this.cantidad.getText());
/*      */     } 
/*      */     
/* 6701 */     this.rSTableMetro1.removeColumn(this.rSTableMetro1.getColumnModel().getColumn(6));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void consultar2() {
/* 6707 */     this.jButton12.setEnabled(false);
/* 6708 */     this.jButton13.setEnabled(false);
/* 6709 */     String nombre = "";
/* 6710 */     String clave = "";
/*      */     
/* 6712 */     if (!this.jTextField3.getText().equals("")) {
/* 6713 */       clave = this.jTextField3.getText();
/*      */     }
/* 6715 */     if (!this.jTextField4.getText().equals("")) {
/* 6716 */       nombre = this.jTextField4.getText();
/*      */     }
/*      */ 
/*      */     
/* 6720 */     this.rSTableMetro3.setModel(new DefaultTableModel((Object[][])this.con
/* 6721 */           .buscarDatos(4, "clave_gene,empresa,nombre_corto,ciudad", "emp_generadora", "where clave_gene<>0 and nombre_Corto like '%" + nombre + "%' order by nombre_corto"), (Object[])new String[] { "Clave", "Nombre Completo", "Nombre Comercial", "Ciduad" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 6726 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6731 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 6734 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 6735 */     this.rSTableMetro3.setSelectionMode(0);
/* 6736 */     this.rSTableMetro3.setAutoCreateRowSorter(true);
/* 6737 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 6738 */     this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 6739 */     this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(60);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int alinearDer(int x, int letras) {
/* 6746 */     int quitar = 4 * letras;
/* 6747 */     x -= quitar;
/* 6748 */     return x;
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
/*      */   public void verTarjeta() {
/* 6764 */     this.ACTIVARCONSULTA = false;
/* 6765 */     this.jComboBox5.setSelectedIndex(0);
/* 6766 */     this.jComboBox4.setSelectedIndex(0);
/* 6767 */     this.jComboBox6.setSelectedIndex(0);
/*      */     
/* 6769 */     this.CLAVECLIENTE = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 6770 */     this.jLabel62.setText("TARJETA DE " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)));
/* 6771 */     consultar3();
/*      */     
/* 6773 */     this.jRadioButton1.setSelected(true);
/*      */     
/* 6775 */     if (this.rSTableMetro5.getRowCount() > 0) {
/* 6776 */       String fecha = String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getRowCount() - 1, 1));
/*      */       
/* 6778 */       String fechaCorta = fecha.substring(0, 10);
/* 6779 */       String FechaNormal = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/*      */       
/* 6781 */       String año = fechaCorta.substring(0, 4);
/* 6782 */       String mes = fechaCorta.substring(5, 7);
/* 6783 */       String dia = fechaCorta.substring(8, 10);
/* 6784 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 6785 */       String strFecha = dia + "-" + dia + "-" + mes;
/* 6786 */       Date fechaT = null;
/*      */       try {
/* 6788 */         fechaT = formatoDelTexto.parse(strFecha);
/*      */       }
/* 6790 */       catch (ParseException ex) {
/* 6791 */         ex.printStackTrace();
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6798 */     this.jTextField13.setText("PPR00176");
/* 6799 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   public void consultar3() {
/* 6803 */     String consulta = "";
/*      */     
/* 6805 */     Date fechaI = this.jDateChooser7.getDate();
/* 6806 */     Date fechaT = this.jDateChooser8.getDate();
/*      */     
/* 6808 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 6809 */     String cadenaFecha = "";
/* 6810 */     cadenaFecha = formato.format(fechaI);
/* 6811 */     String AÑO = cadenaFecha.substring(0, 4);
/* 6812 */     String MES = cadenaFecha.substring(4, 6);
/* 6813 */     String DIA = cadenaFecha.substring(6, 8);
/* 6814 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/* 6816 */     formato = new SimpleDateFormat("yyyyMMdd");
/* 6817 */     cadenaFecha = formato.format(fechaT);
/* 6818 */     AÑO = cadenaFecha.substring(0, 4);
/* 6819 */     MES = cadenaFecha.substring(4, 6);
/* 6820 */     DIA = cadenaFecha.substring(6, 8);
/* 6821 */     String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + " 23:59:59'";
/*      */     
/* 6823 */     String concepto = String.valueOf(this.jComboBox4.getSelectedItem());
/* 6824 */     String estatus = "";
/* 6825 */     if (this.jComboBox4.getSelectedIndex() == 1) {
/* 6826 */       concepto = " and concepto like 'Cargo%'";
/* 6827 */     } else if (this.jComboBox4.getSelectedIndex() == 2) {
/* 6828 */       concepto = " and concepto like 'Abono%'";
/*      */     } else {
/* 6830 */       concepto = "";
/*      */     } 
/*      */     
/* 6833 */     if (this.jComboBox6.getSelectedIndex() == 1) {
/* 6834 */       estatus = " and estatus ='<Por Pagar>'";
/* 6835 */     } else if (this.jComboBox6.getSelectedIndex() == 2) {
/* 6836 */       estatus = " and estatus like '%<Pagado%'";
/* 6837 */     } else if (this.jComboBox6.getSelectedIndex() == 3) {
/* 6838 */       estatus = " and estatus like '%<Abono%'";
/* 6839 */     } else if (this.jComboBox6.getSelectedIndex() == 4) {
/* 6840 */       estatus = " and estatus like '%<Cancelado%'";
/*      */     } else {
/* 6842 */       estatus = "";
/*      */     } 
/*      */     
/* 6845 */     String ref = String.valueOf(this.jComboBox5.getSelectedItem());
/* 6846 */     if (!ref.equals("TODOS") && !ref.equals("todos")) {
/* 6847 */       ref = " and referencia like '%" + ref + "%'";
/*      */     } else {
/* 6849 */       ref = "";
/*      */     } 
/*      */     
/* 6852 */     if (this.ACTIVARCONSULTA) {
/* 6853 */       consulta = consulta + "and fecha between " + consulta + " and " + fechaCompleta1;
/*      */     }
/*      */     
/* 6856 */     this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro5, new String[] { "Mov.", "Fecha", "Concepto", "Referencia", "Importe", "Abono", "Importe Restante", "Saldo", "Estatus", "Pago #1", "Pago #2", "Pago #3", "Pago #4", "Moneda", "TipoCambio", "", "num_abono" }, "mov,fecha,concepto,referencia,importeLetra,abonoLetra,ImporteRestanteLetra,saldoFinalLetra,estatus,pago1,pago2,pago3,pago4, moneda, tipoCambio,saldoFinalLetra, num_abono", "tarjeta_contenido_cliente", "where tarjeta=" + this.CLAVECLIENTE + " " + consulta + " " + estatus + " " + concepto + " " + ref + " order by mov desc");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6876 */     this.jLabel56.setText(" " + this.rSTableMetro5.getRowCount() + " Conceptos encontrados.");
/* 6877 */     if (this.rSTableMetro5.getRowCount() > 0) {
/* 6878 */       this.jTextField2.setText(String.valueOf(this.rSTableMetro5.getValueAt(0, 7)));
/*      */     } else {
/* 6880 */       this.jTextField2.setText("$0.00");
/*      */     } 
/*      */     
/* 6883 */     String cliente = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2).toString();
/* 6884 */     if (cliente.contains("USD") && (
/* 6885 */       this.jComboBox1.getSelectedIndex() == 1 || this.jComboBox1.getSelectedIndex() == 2)) {
/* 6886 */       for (int i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/* 6887 */         String tipoMoneda = this.rSTableMetro5.getValueAt(i, 13).toString();
/* 6888 */         String tipoConcepto = this.rSTableMetro5.getValueAt(i, 2).toString();
/* 6889 */         if (tipoMoneda.equals("USD")) {
/* 6890 */           if (tipoConcepto.contains("CARGO")) {
/* 6891 */             System.out.println("dat CARGO " + this.rSTableMetro5.getValueAt(i, 0).toString() + " " + this.rSTableMetro5.getValueAt(i, 13).toString() + " " + this.rSTableMetro5.getValueAt(i, 14).toString() + " " + tipoConcepto);
/* 6892 */             double precioDolar = this.utilerias.convertirCantTexto(this.rSTableMetro5.getValueAt(i, 14).toString());
/* 6893 */             this.utilerias.convertirTodoDLS((JTable)this.rSTableMetro5, precioDolar, new int[] { 4, 6 }, i);
/*      */           } else {
/* 6895 */             System.out.println("dat ABONO " + this.rSTableMetro5.getValueAt(i, 0).toString() + " " + this.rSTableMetro5.getValueAt(i, 13).toString() + " " + this.rSTableMetro5.getValueAt(i, 14).toString() + " " + tipoConcepto);
/* 6896 */             double precioDolar = this.utilerias.convertirCantTexto(this.rSTableMetro5.getValueAt(i, 14).toString());
/* 6897 */             this.utilerias.convertirTodoDLS((JTable)this.rSTableMetro5, precioDolar, new int[] { 5 }, i);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 6904 */     if (this.jComboBox1.getSelectedIndex() == 1 || this.jComboBox1.getSelectedIndex() == 2) {
/* 6905 */       System.out.println("entra combo");
/* 6906 */       for (int i = this.rSTableMetro5.getRowCount() - 1; i >= 0; i--) {
/* 6907 */         String cargo = this.rSTableMetro5.getValueAt(i, 4).toString();
/* 6908 */         String abono = this.rSTableMetro5.getValueAt(i, 5).toString();
/* 6909 */         int aux = i;
/* 6910 */         if (i == this.rSTableMetro5.getRowCount() - 1) {
/* 6911 */           this.rSTableMetro5.setValueAt(cargo, i, 7);
/* 6912 */         } else if (!cargo.equals("")) {
/*      */           
/* 6914 */           String saldo = this.rSTableMetro5.getValueAt(aux + 1, 7).toString();
/*      */           
/* 6916 */           double res = this.utilerias.convertirCantTexto(saldo) + this.utilerias.convertirCantTexto(cargo);
/* 6917 */           this.rSTableMetro5.setValueAt(this.utilerias.convertirDoublePesos(res), i, 7);
/*      */         } else {
/* 6919 */           String saldo = this.rSTableMetro5.getValueAt(aux + 1, 7).toString();
/* 6920 */           double res = this.utilerias.convertirCantTexto(saldo) - this.utilerias.convertirCantTexto(abono);
/* 6921 */           this.rSTableMetro5.setValueAt(this.utilerias.convertirDoublePesos(res), i, 7);
/*      */         } 
/*      */       } 
/* 6924 */       this.jTextField2.setText(this.rSTableMetro5.getValueAt(0, 7).toString());
/* 6925 */       this.con.inserSinMsj("update tarjeta_deudor_cliente set totalMXN ='" + this.jTextField2.getText() + "' where tarjeta = " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 6926 */       this.rSTableMetro1.setValueAt(this.jTextField2.getText(), this.rSTableMetro1.getSelectedRow(), 5);
/*      */     } 
/*      */     
/* 6929 */     this.celda3.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro5, "<Por Pagar>", 0, 8, 0));
/* 6930 */     this.celda3.pasarInd2(this.con.revisarCol((JTable)this.rSTableMetro5, "<Cancelado", 0, 8, 2));
/* 6931 */     this.celda3.pasarInd3(this.con.revisarCol((JTable)this.rSTableMetro5, "<Abono", 0, 8, 2));
/*      */     
/* 6933 */     this.rSTableMetro5.setShowVerticalLines(false);
/* 6934 */     this.rSTableMetro5.setSelectionMode(0);
/*      */     
/* 6936 */     this.rSTableMetro5.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 6937 */     this.rSTableMetro5.getColumnModel().getColumn(0).setMaxWidth(50);
/* 6938 */     this.rSTableMetro5.getColumnModel().getColumn(1).setPreferredWidth(110);
/* 6939 */     this.rSTableMetro5.getColumnModel().getColumn(1).setMaxWidth(110);
/* 6940 */     this.rSTableMetro5.getColumnModel().getColumn(4).setPreferredWidth(90);
/* 6941 */     this.rSTableMetro5.getColumnModel().getColumn(4).setMaxWidth(90);
/* 6942 */     this.rSTableMetro5.getColumnModel().getColumn(11).setPreferredWidth(130);
/* 6943 */     this.rSTableMetro5.getColumnModel().getColumn(11).setMaxWidth(130);
/*      */     
/* 6945 */     this.rSTableMetro5.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 6946 */     this.rSTableMetro5.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 6947 */     this.rSTableMetro5.getColumnModel().getColumn(2).setCellRenderer(this.celda3);
/* 6948 */     this.rSTableMetro5.getColumnModel().getColumn(3).setCellRenderer(this.celda3);
/* 6949 */     this.rSTableMetro5.getColumnModel().getColumn(4).setCellRenderer(this.celda3);
/* 6950 */     this.rSTableMetro5.getColumnModel().getColumn(5).setCellRenderer(this.celda3);
/* 6951 */     this.rSTableMetro5.getColumnModel().getColumn(6).setCellRenderer(this.celda3);
/* 6952 */     this.rSTableMetro5.getColumnModel().getColumn(7).setCellRenderer(this.celda3);
/* 6953 */     this.rSTableMetro5.getColumnModel().getColumn(8).setCellRenderer(this.celda3);
/* 6954 */     this.rSTableMetro5.getColumnModel().getColumn(9).setCellRenderer(this.celda3);
/* 6955 */     this.rSTableMetro5.getColumnModel().getColumn(10).setCellRenderer(this.celda3);
/* 6956 */     this.rSTableMetro5.getColumnModel().getColumn(11).setCellRenderer(this.celda3);
/* 6957 */     this.rSTableMetro5.getColumnModel().getColumn(12).setCellRenderer(this.celda3);
/* 6958 */     this.rSTableMetro5.getColumnModel().getColumn(13).setCellRenderer(this.celda3);
/* 6959 */     this.rSTableMetro5.getColumnModel().getColumn(14).setCellRenderer(this.celda3);
/* 6960 */     this.rSTableMetro5.setFont(new Font("Cantarell", 0, 10));
/*      */     
/* 6962 */     if (!this.ACTIVARCONSULTA) {
/* 6963 */       String fecha1 = "";
/* 6964 */       String fecha2 = "";
/* 6965 */       if (this.rSTableMetro5.getRowCount() > 0) {
/* 6966 */         fecha1 = String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getRowCount() - 1, 1));
/* 6967 */         fecha2 = String.valueOf(this.rSTableMetro5.getValueAt(0, 1));
/*      */         
/* 6969 */         String año = fecha1.substring(0, 4);
/* 6970 */         String mes = fecha1.substring(5, 7);
/* 6971 */         String dia = fecha1.substring(8, 10);
/* 6972 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 6973 */         String strFecha = año + "-" + año + "-" + mes;
/* 6974 */         Date fecha = null;
/*      */         try {
/* 6976 */           fecha = formatoDelTexto.parse(strFecha);
/* 6977 */         } catch (ParseException ex) {
/* 6978 */           ex.printStackTrace();
/*      */         } 
/* 6980 */         this.jDateChooser7.setDate(fecha);
/*      */         
/* 6982 */         año = fecha2.substring(0, 4);
/* 6983 */         mes = fecha2.substring(5, 7);
/* 6984 */         dia = fecha2.substring(8, 10);
/* 6985 */         formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 6986 */         strFecha = año + "-" + año + "-" + mes;
/* 6987 */         fecha = null;
/*      */         try {
/* 6989 */           fecha = formatoDelTexto.parse(strFecha);
/* 6990 */         } catch (ParseException ex) {
/* 6991 */           ex.printStackTrace();
/*      */         } 
/* 6993 */         this.jDateChooser8.setDate(fecha);
/*      */       } else {
/* 6995 */         this.jDateChooser7.setDate(new Date());
/* 6996 */         this.jDateChooser8.setDate(new Date());
/*      */       } 
/* 6998 */       this.jComboBox4.setSelectedIndex(0);
/* 6999 */       this.ACTIVARCONSULTA = true;
/*      */     } 
/*      */   }
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 7007 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 7010 */       this.t = new Thread(this);
/* 7011 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 7019 */         TarjetaCliente.this.jLabel57.setVisible(true);
/* 7020 */         Thread.currentThread(); Thread.sleep(1000L);
/* 7021 */         detener();
/* 7022 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 7027 */       TarjetaCliente.this.buscarFacturas();
/* 7028 */       TarjetaCliente.this.jLabel57.setVisible(false);
/* 7029 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 7033 */       this.t.stop();
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 7039 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 7042 */       setEnabled((table == null || table.isEnabled()));
/* 7043 */       if (row % 2 == 0) {
/* 7044 */         setBackground(Color.WHITE);
/*      */       } else {
/* 7046 */         setBackground(TarjetaCliente.this.lc.FONDOTABLA);
/*      */       } 
/* 7048 */       if (column == 2 || column == 3 || column == 4) {
/* 7049 */         setHorizontalAlignment(4);
/*      */       } else {
/* 7051 */         setHorizontalAlignment(2);
/*      */       } 
/* 7053 */       setForeground(TarjetaCliente.this.lc.SECUNDARIO1);
/* 7054 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 7055 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CeldaRender3
/*      */     extends DefaultTableCellRenderer {
/* 7061 */     int otro = -1;
/* 7062 */     String[] indices = new String[0];
/* 7063 */     String[] indices2 = new String[0];
/* 7064 */     String[] indices3 = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 7067 */       setEnabled((table == null || table.isEnabled()));
/* 7068 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 7069 */       if (comparar(comp)) {
/* 7070 */         setBackground((Color)null);
/* 7071 */         setForeground(Color.BLUE);
/* 7072 */         setHorizontalAlignment(2);
/* 7073 */       } else if (comparar2(comp)) {
/* 7074 */         setBackground(Color.LIGHT_GRAY);
/* 7075 */         setForeground(Color.red);
/* 7076 */         setHorizontalAlignment(2);
/* 7077 */       } else if (comparar3(comp)) {
/* 7078 */         setBackground((Color)null);
/* 7079 */         setForeground(Color.RED);
/* 7080 */         setHorizontalAlignment(2);
/*      */       } else {
/* 7082 */         setBackground((Color)null);
/* 7083 */         setForeground(TarjetaCliente.this.lc.SECUNDARIO1);
/* 7084 */         setHorizontalAlignment(2);
/*      */       } 
/* 7086 */       if (column == 4 || column == 5 || column == 6 || column == 7 || column == 14) {
/* 7087 */         setHorizontalAlignment(4);
/*      */       }
/* 7089 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 7090 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 7094 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 7098 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 7102 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 7106 */       for (int i = 0; i < this.indices.length; i++) {
/* 7107 */         if (this.indices[i].equals(reg)) {
/* 7108 */           return true;
/*      */         }
/*      */       } 
/* 7111 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 7115 */       for (int i = 0; i < this.indices2.length; i++) {
/* 7116 */         if (this.indices2[i].equals(reg)) {
/* 7117 */           return true;
/*      */         }
/*      */       } 
/* 7120 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 7124 */       for (int i = 0; i < this.indices3.length; i++) {
/* 7125 */         if (this.indices3[i].equals(reg)) {
/* 7126 */           return true;
/*      */         }
/*      */       } 
/* 7129 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 7134 */     this.SALDAR = 0.0D;
/* 7135 */     this.jRadioButton5.setSelected(true);
/* 7136 */     this.jTextField12.setText("");
/* 7137 */     this.jTextField12.setEditable(false);
/* 7138 */     this.jTextField13.setText("");
/* 7139 */     this.jTextField15.setText("");
/* 7140 */     this.jTextField16.setText("");
/* 7141 */     this.jTextField17.setText("");
/* 7142 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*      */ 
/*      */     
/* 7145 */     this.rSTableMetro7.setFont(new Font("Tahoma", 0, 10));
/* 7146 */     this.rSTableMetro7.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Mov", "Referencia", "Importe", "Resta", "Abono" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 7151 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7156 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7159 */     this.rSTableMetro7.setColumnSelectionAllowed(true);
/*      */     
/* 7161 */     this.rSTableMetro6.setSelectionMode(0);
/* 7162 */     this.rSTableMetro6.setAutoCreateRowSorter(true);
/* 7163 */     this.rSTableMetro7.getTableHeader().setReorderingAllowed(false);
/* 7164 */     this.rSTableMetro7.getColumnModel().getSelectionModel().setSelectionMode(1);
/* 7165 */     this.rSTableMetro7.getColumnModel().getColumn(0).setPreferredWidth(45);
/* 7166 */     this.rSTableMetro7.getColumnModel().getColumn(0).setMaxWidth(45);
/* 7167 */     this.rSTableMetro7.getColumnModel().getColumn(2).setPreferredWidth(70);
/* 7168 */     this.rSTableMetro7.getColumnModel().getColumn(2).setMaxWidth(70);
/* 7169 */     this.rSTableMetro7.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 7170 */     this.rSTableMetro7.getColumnModel().getColumn(3).setMaxWidth(70);
/*      */     
/* 7172 */     this.rSTableMetro7.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 7173 */     this.rSTableMetro7.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 7174 */     this.rSTableMetro7.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 7175 */     this.rSTableMetro7.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 7176 */     this.rSTableMetro7.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void limpiar2() {
/* 7180 */     this.jRadioButton3.setSelected(true);
/* 7181 */     this.jTextField10.setText("");
/* 7182 */     this.jTextField10.setEnabled(false);
/* 7183 */     this.jTextField18.setText("");
/* 7184 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 7185 */     this.jTextArea2.setText("");
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 7189 */     this.con.consultar("max(num_abono)", "abonosFacturas", "");
/* 7190 */     String mayor = this.con.Campo;
/* 7191 */     int MAYOR = 0;
/*      */     try {
/* 7193 */       MAYOR = Integer.parseInt(mayor);
/* 7194 */     } catch (NumberFormatException e) {
/* 7195 */       MAYOR = 0;
/*      */     } 
/* 7197 */     MAYOR++;
/* 7198 */     if (MAYOR < 10) {
/* 7199 */       this.jTextField14.setText(this.DIRECTIVAS + "-C-0000" + this.DIRECTIVAS);
/* 7200 */       this.jTextField19.setText(this.DIRECTIVAS + "-0000" + this.DIRECTIVAS);
/* 7201 */     } else if (MAYOR < 100) {
/* 7202 */       this.jTextField14.setText(this.DIRECTIVAS + "-C-000" + this.DIRECTIVAS);
/* 7203 */       this.jTextField19.setText(this.DIRECTIVAS + "-000" + this.DIRECTIVAS);
/* 7204 */     } else if (MAYOR < 1000) {
/* 7205 */       this.jTextField14.setText(this.DIRECTIVAS + "-C-00" + this.DIRECTIVAS);
/* 7206 */       this.jTextField19.setText(this.DIRECTIVAS + "-00" + this.DIRECTIVAS);
/* 7207 */     } else if (MAYOR < 10000) {
/* 7208 */       this.jTextField14.setText(this.DIRECTIVAS + "-C-0" + this.DIRECTIVAS);
/* 7209 */       this.jTextField19.setText(this.DIRECTIVAS + "-0" + this.DIRECTIVAS);
/*      */     } else {
/* 7211 */       this.jTextField14.setText(this.DIRECTIVAS + "-C-" + this.DIRECTIVAS);
/* 7212 */       this.jTextField19.setText(this.DIRECTIVAS + "-" + this.DIRECTIVAS);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void cargarFechaHoy() {
/* 7217 */     Calendar ahoraCal = Calendar.getInstance();
/* 7218 */     ahoraCal.setTime(this.fecha);
/* 7219 */     String mesesito = "";
/* 7220 */     String hoy = "";
/* 7221 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 7222 */     hoy = "" + ahoraCal.get(5);
/* 7223 */     if (ahoraCal.get(2) + 1 < 10) {
/* 7224 */       mesesito = "0" + mesesito;
/*      */     }
/* 7226 */     if (ahoraCal.get(5) < 10) {
/* 7227 */       hoy = "0" + hoy;
/*      */     }
/* 7229 */     this.jTextField9.setText(hoy + "/" + hoy + "/" + mesesito);
/*      */   }
/*      */ 
/*      */   
/*      */   public double regresaMonto(String cantidad) {
/* 7234 */     double monto = 0.0D;
/* 7235 */     String valorP = "";
/* 7236 */     String canti = cantidad;
/* 7237 */     for (int k = 0; k < canti.length(); k++) {
/* 7238 */       if (canti.charAt(k) != '$' && canti.charAt(k) != ',') {
/* 7239 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 7242 */     monto = Double.parseDouble(valorP);
/* 7243 */     return monto;
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy2() {
/* 7247 */     Calendar ahoraCal = Calendar.getInstance();
/* 7248 */     ahoraCal.setTime(this.fecha);
/* 7249 */     String mesesito = "";
/* 7250 */     String hoy = "";
/* 7251 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 7252 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 7254 */     if (ahoraCal.get(2) + 1 < 10) {
/* 7255 */       mesesito = "0" + mesesito;
/*      */     }
/* 7257 */     if (ahoraCal.get(5) < 10) {
/* 7258 */       hoy = "0" + hoy;
/*      */     }
/* 7260 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy3() {
/* 7264 */     Calendar ahoraCal = this.jDateChooser4.getCalendar();
/* 7265 */     ahoraCal.setTime(this.jDateChooser4.getCalendar().getTime());
/* 7266 */     String mesesito = "";
/* 7267 */     String hoy = "";
/* 7268 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 7269 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 7271 */     if (ahoraCal.get(2) + 1 < 10) {
/* 7272 */       mesesito = "0" + mesesito;
/*      */     }
/* 7274 */     if (ahoraCal.get(5) < 10) {
/* 7275 */       hoy = "0" + hoy;
/*      */     }
/* 7277 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices;
/*      */     String[] indices2;
/*      */     
/*      */     public CeldaRender2() {
/* 7283 */       this.otro = -1;
/* 7284 */       this.indices = new String[0];
/* 7285 */       this.indices2 = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 7288 */       setEnabled((table == null || table.isEnabled()));
/* 7289 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 7290 */       if (row % 2 == 0) {
/* 7291 */         setBackground(TarjetaCliente.this.lc.FONDOTABLA);
/*      */       } else {
/* 7293 */         setBackground((Color)null);
/*      */       } 
/* 7295 */       if (column == 5) {
/* 7296 */         setHorizontalAlignment(4);
/*      */       } else {
/* 7298 */         setHorizontalAlignment(2);
/*      */       } 
/* 7300 */       setForeground(TarjetaCliente.this.lc.SECUNDARIO1);
/* 7301 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 7302 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 7306 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 7310 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 7314 */       for (int i = 0; i < this.indices.length; i++) {
/* 7315 */         if (this.indices[i].equals(reg)) {
/* 7316 */           return true;
/*      */         }
/*      */       } 
/* 7319 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 7323 */       for (int i = 0; i < this.indices2.length; i++) {
/* 7324 */         if (this.indices2[i].equals(reg)) {
/* 7325 */           return true;
/*      */         }
/*      */       } 
/* 7328 */       return false;
/*      */     } }
/*      */ 
/*      */   
/*      */   public void sacarSaldosAcumulados() {
/* 7333 */     this.SALDOACUMULADO = 0.0D;
/* 7334 */     for (int i = 0; i < this.rSTableMetro7.getRowCount(); i++) {
/* 7335 */       String canti = String.valueOf(this.rSTableMetro7.getValueAt(i, 4));
/* 7336 */       String valorP = "";
/* 7337 */       for (int j = 0; j < canti.length(); j++) {
/* 7338 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 7339 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 7342 */       this.SALDOACUMULADO += Double.parseDouble(valorP);
/* 7343 */       this.SALDOACUMULADO = redondear(this.SALDOACUMULADO).doubleValue();
/*      */     } 
/*      */   }
/*      */   
/*      */   public Double saldar(double valor, double res, double saldado, String mov) {
/* 7348 */     double restante = 0.0D;
/* 7349 */     this.con.consultar("factura", "tarjeta_contenido_cliente", "where mov=" + mov);
/* 7350 */     String factura = this.con.Campo;
/* 7351 */     String[] ref = this.con.regresaReg("pago1,pago2,pago3,pago4", "tarjeta_contenido_cliente", "where mov=" + mov, 4);
/* 7352 */     String actRef = "";
/* 7353 */     if (ref[0].equals("")) {
/* 7354 */       actRef = "pago1";
/* 7355 */     } else if (ref[1].equals("")) {
/* 7356 */       actRef = "pago2";
/* 7357 */     } else if (ref[2].equals("")) {
/* 7358 */       actRef = "pago3";
/* 7359 */     } else if (ref[3].equals("")) {
/* 7360 */       actRef = "pago4";
/*      */     } 
/* 7362 */     if (res > valor) {
/* 7363 */       res -= valor;
/* 7364 */       saldado += valor;
/*      */       
/* 7366 */       res = redondear(res).doubleValue();
/* 7367 */       saldado = redondear(saldado).doubleValue();
/* 7368 */       this.cantidad.setValue(Double.valueOf(saldado));
/* 7369 */       this.auxiliar.setValue(Double.valueOf(res));
/* 7370 */       this.con.inserSinMsj("update tarjeta_contenido_cliente set " + actRef + "='" + this.jTextField15.getText().toUpperCase() + "-" + this.jTextField16.getText().toUpperCase() + "-" + this.jTextField17.getText().toUpperCase() + "-" + this.cantidad.getText() + "', importesaldado = " + saldado + ", estatus='<Abono:" + this.cantidad.getText() + ">',importeRestante = " + res + ",importeRestanteLetra='" + this.auxiliar.getText() + "' where mov=" + mov);
/* 7371 */       this.con.inserSinMsj("update facturas set estatus='<Abono: " + this.cantidad.getText() + ">' where folio ='" + factura + "'");
/* 7372 */       restante = 0.0D;
/*      */     } else {
/* 7374 */       restante = valor - res;
/* 7375 */       saldado += res;
/* 7376 */       this.auxiliar.setValue(Double.valueOf(res));
/* 7377 */       this.cantidad.setValue(Double.valueOf(saldado));
/* 7378 */       Date fecha = new Date();
/* 7379 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 7380 */       String cadenaFecha = "";
/* 7381 */       cadenaFecha = formato.format(fecha);
/* 7382 */       String AÑO = cadenaFecha.substring(0, 4);
/* 7383 */       String MES = cadenaFecha.substring(4, 6);
/* 7384 */       String DIA = cadenaFecha.substring(6, 8);
/* 7385 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/* 7386 */       this.con.inserSinMsj("update tarjeta_contenido_cliente set " + actRef + "='" + this.jTextField15.getText().toUpperCase() + "-" + this.jTextField16.getText().toUpperCase() + "-" + this.jTextField17.getText().toUpperCase() + "-" + this.auxiliar.getText() + "',estatus = '<Pagado:" + fechaCompleta1 + ">', importeSaldado = " + saldado + ",importeRestante =0,importeRestanteLetra='$0.00' where mov=" + mov);
/* 7387 */       this.con.inserSinMsj("update guias set estatus='<Pagada: " + fechaCompleta1 + ">' where factImpresa='" + factura + "'");
/* 7388 */       this.con.inserSinMsj("update facturas set estatus='<Pagada: " + fechaCompleta1 + ">' where folio ='" + factura + "'");
/*      */     } 
/* 7390 */     return Double.valueOf(restante);
/*      */   }
/*      */   
/*      */   public Double redondear(double pasar) {
/* 7394 */     return Double.valueOf(Math.rint(pasar * 100.0D) / 100.0D);
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
/*      */   public void cargarCargo() {
/* 7412 */     int ind = this.rSTableMetro5.getSelectedRow();
/* 7413 */     this.jTextField5.setText(String.valueOf(this.rSTableMetro5.getValueAt(ind, 0)));
/* 7414 */     this.jLabel7.setText("CARGO");
/* 7415 */     this.jLabel9.setText(String.valueOf(this.rSTableMetro5.getValueAt(ind, 2)));
/* 7416 */     this.jLabel11.setText(String.valueOf(this.rSTableMetro5.getValueAt(ind, 3)));
/* 7417 */     this.jLabel13.setText(String.valueOf(this.rSTableMetro5.getValueAt(ind, 4)));
/* 7418 */     this.jTable7.setValueAt(this.rSTableMetro5.getValueAt(ind, 9), 0, 1);
/* 7419 */     this.jTable7.setValueAt(this.rSTableMetro5.getValueAt(ind, 10), 1, 1);
/* 7420 */     this.jTable7.setValueAt(this.rSTableMetro5.getValueAt(ind, 11), 2, 1);
/* 7421 */     this.jTable7.setValueAt(this.rSTableMetro5.getValueAt(ind, 12), 3, 1);
/*      */     
/* 7423 */     String fecha = String.valueOf(this.rSTableMetro5.getValueAt(ind, 1));
/* 7424 */     String fechaCorta = fecha.substring(0, 10);
/* 7425 */     String año = fechaCorta.substring(0, 4);
/* 7426 */     String mes = fechaCorta.substring(5, 7);
/* 7427 */     String dia = fechaCorta.substring(8, 10);
/* 7428 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 7429 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 7430 */     this.jTextField6.setText(strFecha);
/*      */     
/* 7432 */     this.con.consultar("usuario", "tarjeta_contenido_cliente", "where mov =" + String.valueOf(this.rSTableMetro5.getValueAt(ind, 0)));
/* 7433 */     this.jLabel16.setText(this.con.Campo + "           " + this.con.Campo);
/* 7434 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void privilegios() {
/* 7439 */     this.DEPARTAMENTO = this.CAMPOSGENERALES.get("priv");
/* 7440 */     if (this.DEPARTAMENTO.equals("SUPER USUARIO") || this.DEPARTAMENTO.equals("ADMINISTRADOR") || this.USUARIO.equals("PATRICIA") || this.USUARIO.equals("REPORTES")) {
/* 7441 */       this.jButton2.setEnabled(true);
/* 7442 */       this.jButton5.setEnabled(true);
/* 7443 */       this.jButton6.setEnabled(true);
/* 7444 */       this.jButton7.setEnabled(true);
/*      */     } else {
/*      */       
/* 7447 */       this.jButton2.setEnabled(false);
/* 7448 */       this.jButton5.setEnabled(false);
/* 7449 */       this.jButton6.setEnabled(false);
/* 7450 */       this.jButton7.setEnabled(false);
/*      */     } 
/*      */ 
/*      */     
/* 7454 */     if (this.USUARIO.equals("KOFUZ01")) {
/* 7455 */       this.jLabel70.setVisible(true);
/*      */     } else {
/* 7457 */       this.jLabel70.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void cargarAbono() {
/* 7462 */     int ind = this.rSTableMetro5.getSelectedRow();
/* 7463 */     this.jTextField7.setText(String.valueOf(this.rSTableMetro5.getValueAt(ind, 0)));
/* 7464 */     this.jLabel23.setText("ABONO");
/* 7465 */     this.jLabel25.setText(String.valueOf(this.rSTableMetro5.getValueAt(ind, 2)));
/* 7466 */     this.jLabel27.setText(String.valueOf(this.rSTableMetro5.getValueAt(ind, 3)));
/* 7467 */     this.jLabel29.setText(String.valueOf(this.rSTableMetro5.getValueAt(ind, 5)));
/*      */     
/* 7469 */     String fecha = String.valueOf(this.rSTableMetro5.getValueAt(ind, 1));
/* 7470 */     String fechaCorta = fecha.substring(0, 10);
/* 7471 */     String año = fechaCorta.substring(0, 4);
/* 7472 */     String mes = fechaCorta.substring(5, 7);
/* 7473 */     String dia = fechaCorta.substring(8, 10);
/* 7474 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 7475 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 7476 */     this.jTextField8.setText(strFecha);
/*      */     
/* 7478 */     String[] datos = this.con.regresaReg("abonosfacturas.usuario,abonosfacturas.abono", "tarjeta_contenido_cliente,abonosfacturas", "where tarjeta_contenido_cliente.num_abono =abonosfacturas.abono and mov =" + String.valueOf(this.rSTableMetro5.getValueAt(ind, 0)), 2);
/* 7479 */     if (datos[0] == null) {
/* 7480 */       this.jTextArea1.setText("");
/*      */     } else {
/*      */       
/* 7483 */       this.jTextArea1.setText("Documentó: " + datos[0]);
/*      */     } 
/*      */ 
/*      */     
/* 7487 */     this.jLabel34.setText(datos[1]);
/*      */ 
/*      */     
/* 7490 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   public class ImprimirAbono implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirAbono() {
/* 7498 */       this.g2 = null;
/* 7499 */       this.Pag = 0;
/*      */       
/* 7501 */       this.linesPerPage = 50;
/* 7502 */       this.orientacion = 0;
/* 7503 */       this.X = 0.0D;
/* 7504 */       this.Y = 0.0D;
/* 7505 */       this.YINICIA = 75;
/* 7506 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 7507 */       this.NumLineas = 0;
/* 7508 */       this.numBreaks = 0;
/*      */     }
/*      */     private void initTextLines() {
/* 7511 */       if (this.textLines == null) {
/* 7512 */         int numLines = TarjetaCliente.this.rSTableMetro7.getRowCount();
/* 7513 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 7518 */       Font font = new Font("Serif", 0, 8);
/* 7519 */       FontMetrics metrics = g.getFontMetrics(font);
/* 7520 */       int lineHeight = metrics.getHeight();
/* 7521 */       if (this.pageBreaks == null) {
/* 7522 */         initTextLines();
/* 7523 */         this.orientacion = pf.getOrientation();
/* 7524 */         if (pf.getOrientation() == 1) {
/* 7525 */           this.linesPerPage = 42;
/* 7526 */           this.X = pf.getWidth();
/* 7527 */           this.Y = pf.getHeight();
/*      */         } else {
/* 7529 */           this.linesPerPage = 38;
/* 7530 */           this.X = pf.getWidth();
/* 7531 */           this.Y = pf.getHeight();
/*      */         } 
/* 7533 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 7534 */         this.Pag = this.numBreaks;
/* 7535 */         this.pageBreaks = new int[this.numBreaks];
/* 7536 */         for (int b = 0; b < this.numBreaks; b++) {
/* 7537 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 7540 */       if (pageIndex > this.pageBreaks.length) {
/* 7541 */         return 1;
/*      */       }
/* 7543 */       Graphics2D g2d = (Graphics2D)g;
/* 7544 */       this.g2 = g;
/* 7545 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 7546 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 7547 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 7548 */       encabezado();
/* 7549 */       int y = this.YINICIA;
/* 7550 */       int lineas = 0;
/*      */       
/* 7552 */       this.g2.drawRect(25, 170, 550, 12);
/* 7553 */       this.g2.setColor(new Color(204, 0, 0));
/* 7554 */       this.g2.fillRect(25, 171, 550, 10);
/*      */       
/* 7556 */       Font fuente = new Font("Dialog", 0, 7);
/* 7557 */       this.g2.setFont(fuente);
/* 7558 */       this.g2.setColor(Color.WHITE);
/* 7559 */       this.g2.drawString("NÚM", 29, 179);
/* 7560 */       this.g2.drawString("NÚM DE FAC", 109, 179);
/* 7561 */       this.g2.drawString("IMPORTE", 245, 179);
/* 7562 */       this.g2.drawString("ABONO", 375, 179);
/* 7563 */       this.g2.drawString("SALDO", 510, 179);
/*      */       
/* 7565 */       this.g2.setColor(Color.BLACK);
/* 7566 */       y = 180;
/* 7567 */       for (int line = start; line < end; line++) {
/* 7568 */         y += 12;
/*      */         
/* 7570 */         String valor = "";
/* 7571 */         if (line < 9) {
/* 7572 */           valor = "0" + line + 1;
/*      */         } else {
/* 7574 */           valor = "" + line + 1;
/*      */         } 
/* 7576 */         fuente = new Font("Dialog", 1, 7);
/* 7577 */         this.g2.setFont(fuente);
/* 7578 */         this.g2.drawString(valor, 27, y - 2);
/*      */         
/* 7580 */         fuente = new Font("Dialog", 0, 7);
/* 7581 */         this.g2.setFont(fuente);
/*      */         
/* 7583 */         this.g2.drawString(String.valueOf(TarjetaCliente.this.rSTableMetro7.getValueAt(line, 1)), 102, y - 2);
/* 7584 */         this.g2.drawString(String.valueOf(TarjetaCliente.this.rSTableMetro7.getValueAt(line, 2)), TarjetaCliente.this.alinearDer(310, TarjetaCliente.this.rSTableMetro7.getValueAt(line, 2).toString().length()), y - 2);
/* 7585 */         this.g2.drawString(String.valueOf(TarjetaCliente.this.rSTableMetro7.getValueAt(line, 4)), TarjetaCliente.this.alinearDer(441, TarjetaCliente.this.rSTableMetro7.getValueAt(line, 4).toString().length()), y - 2);
/* 7586 */         this.g2.drawString(TarjetaCliente.this.COL1[line], TarjetaCliente.this.alinearDer(567, TarjetaCliente.this.COL1[line].length()), y - 2);
/*      */       } 
/* 7588 */       this.g2.drawLine(75, y, 185, y);
/* 7589 */       this.g2.drawLine(205, y, 315, y);
/* 7590 */       this.g2.drawLine(335, y, 445, y);
/* 7591 */       this.g2.drawLine(465, y, 575, y);
/*      */       
/* 7593 */       g.drawString("Página " + pageIndex + 1, 540, 749);
/* 7594 */       if (this.Pag == pageIndex) {
/* 7595 */         fuente = new Font("Dialog", 1, 7);
/* 7596 */         this.g2.setFont(fuente);
/* 7597 */         g.drawString("SUMAS", 119, y + 10);
/*      */         
/* 7599 */         TarjetaCliente.this.jFormattedTextField4.setValue(Double.valueOf(TarjetaCliente.this.VALOR1));
/* 7600 */         this.g2.drawString(TarjetaCliente.this.jFormattedTextField4.getText(), TarjetaCliente.this.alinearDer(310, TarjetaCliente.this.jFormattedTextField4.getText().length()), y + 10);
/*      */         
/* 7602 */         this.g2.drawString(TarjetaCliente.this.jLabel37.getText(), TarjetaCliente.this.alinearDer(441, TarjetaCliente.this.jLabel37.getText().length()), y + 10);
/*      */         
/* 7604 */         TarjetaCliente.this.jFormattedTextField4.setValue(Double.valueOf(TarjetaCliente.this.VALOR2));
/* 7605 */         this.g2.drawString(TarjetaCliente.this.jFormattedTextField4.getText(), TarjetaCliente.this.alinearDer(569, TarjetaCliente.this.jFormattedTextField4.getText().length()), y + 10);
/*      */         
/* 7607 */         fuente = new Font("Dialog", 1, 7);
/* 7608 */         this.g2.setFont(fuente);
/* 7609 */         this.g2.drawString("ELABORÓ", 290, 720);
/* 7610 */         this.g2.drawString("_____________________________________", 240, 752);
/* 7611 */         this.g2.drawString("NOMBRE Y FIRMA", 278, 765);
/*      */       } 
/* 7613 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 7617 */       Font fuente = new Font("Dialog", 0, 8);
/* 7618 */       this.g2.setFont(fuente);
/* 7619 */       this.g2.setColor(Color.BLACK);
/* 7620 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 7621 */       Image img = imagen.getImage();
/* 7622 */       this.g2.drawImage(img, 518, 9, 57, 57, null);
/*      */       
/* 7624 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 7625 */       img = imagen.getImage();
/* 7626 */       this.g2.drawImage(img, 27, 15, 60, 50, null);
/*      */       
/* 7628 */       fuente = new Font("Times New Roman", 1, 16);
/* 7629 */       this.g2.setFont(fuente);
/* 7630 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 20);
/* 7631 */       this.g2.drawString(TarjetaCliente.this.DATOS[0], 135, 65);
/*      */       
/* 7633 */       fuente = new Font("Dialog", 0, 12);
/* 7634 */       this.g2.setFont(fuente);
/* 7635 */       this.g2.drawString("DETALLES DEL DEPÓSITO " + TarjetaCliente.this.jTextField14.getText(), 200, 37);
/* 7636 */       this.g2.drawLine(25, 70, 575, 70);
/*      */       
/* 7638 */       this.g2.setColor(Color.BLACK);
/* 7639 */       this.g2.drawLine(25, 98, 220, 98);
/* 7640 */       this.g2.drawLine(25, 148, 220, 148);
/*      */       
/* 7642 */       fuente = new Font("Dialog", 1, 8);
/* 7643 */       this.g2.setFont(fuente);
/* 7644 */       this.g2.setColor(Color.BLACK);
/* 7645 */       this.g2.drawString("INFORMACIÓN DEL DEPÓSITO", 25, 95);
/*      */       
/* 7647 */       fuente = new Font("Dialog", 1, 7);
/* 7648 */       this.g2.setFont(fuente);
/* 7649 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 7651 */       this.g2.drawString("Banco: ", 27, 108);
/* 7652 */       this.g2.drawString("Cuenta: ", 27, 119);
/* 7653 */       this.g2.drawString("Ref: ", 27, 130);
/* 7654 */       this.g2.drawString("Depósito por: ", 27, 141);
/*      */       
/* 7656 */       fuente = new Font("Dialog", 0, 7);
/* 7657 */       this.g2.setFont(fuente);
/* 7658 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 7660 */       this.g2.drawString(TarjetaCliente.this.jTextField15.getText().toUpperCase(), 85, 108);
/* 7661 */       this.g2.drawString(TarjetaCliente.this.jTextField16.getText().toUpperCase(), 85, 119);
/* 7662 */       this.g2.drawString(TarjetaCliente.this.jTextField17.getText().toUpperCase(), 85, 130);
/* 7663 */       this.g2.drawString(TarjetaCliente.this.jFormattedTextField1.getText(), 85, 141);
/*      */       
/* 7665 */       this.g2.drawString(TarjetaCliente.this.DATOS[11], 540, 78);
/*      */       
/* 7667 */       fuente = new Font("Dialog", 0, 7);
/* 7668 */       this.g2.setFont(fuente);
/* 7669 */       this.g2.drawString("A continuación se enlistan todos los movimientos del depósito:", 25, 168);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 7673 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 7674 */       job.setPrintable(this);
/*      */       
/* 7676 */       PageFormat pf = job.defaultPage();
/* 7677 */       Paper papel = pf.getPaper();
/* 7678 */       papel.setSize(612.0D, 792.0D);
/* 7679 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 7680 */       pf.setPaper(papel);
/* 7681 */       pf.setOrientation(1);
/* 7682 */       job.setPrintable(new ImprimirAbono(), pf);
/* 7683 */       job.defaultPage(pf);
/*      */       
/* 7685 */       boolean ok = job.printDialog();
/* 7686 */       if (ok)
/*      */         try {
/* 7688 */           job.print();
/* 7689 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirEstado implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirEstado() {
/* 7699 */       this.g2 = null;
/* 7700 */       this.Pag = 0;
/*      */       
/* 7702 */       this.linesPerPage = 50;
/* 7703 */       this.orientacion = 0;
/* 7704 */       this.X = 0.0D;
/* 7705 */       this.Y = 0.0D;
/* 7706 */       this.YINICIA = 75;
/* 7707 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 7708 */       this.NumLineas = 0;
/* 7709 */       this.numBreaks = 0;
/*      */     }
/*      */     private void initTextLines() {
/* 7712 */       if (this.textLines == null) {
/*      */ 
/*      */         
/* 7715 */         int numLines = TarjetaCliente.this.rSTableMetro7.getRowCount();
/*      */         
/* 7717 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 7722 */       Font font = new Font("Serif", 0, 8);
/* 7723 */       FontMetrics metrics = g.getFontMetrics(font);
/* 7724 */       int lineHeight = metrics.getHeight();
/* 7725 */       if (this.pageBreaks == null) {
/* 7726 */         initTextLines();
/* 7727 */         this.orientacion = pf.getOrientation();
/* 7728 */         if (pf.getOrientation() == 1) {
/* 7729 */           this.linesPerPage = 42;
/* 7730 */           this.X = pf.getWidth();
/* 7731 */           this.Y = pf.getHeight();
/*      */         } else {
/* 7733 */           this.linesPerPage = 38;
/* 7734 */           this.X = pf.getWidth();
/* 7735 */           this.Y = pf.getHeight();
/*      */         } 
/* 7737 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 7738 */         this.Pag = this.numBreaks;
/* 7739 */         this.pageBreaks = new int[this.numBreaks];
/* 7740 */         for (int b = 0; b < this.numBreaks; b++) {
/* 7741 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 7744 */       if (pageIndex > this.pageBreaks.length) {
/* 7745 */         return 1;
/*      */       }
/* 7747 */       Graphics2D g2d = (Graphics2D)g;
/* 7748 */       this.g2 = g;
/* 7749 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 7750 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 7751 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 7752 */       encabezado();
/* 7753 */       int y = this.YINICIA;
/* 7754 */       int lineas = 0;
/*      */       
/* 7756 */       this.g2.drawRect(25, 170, 550, 12);
/* 7757 */       this.g2.setColor(new Color(204, 0, 0));
/* 7758 */       this.g2.fillRect(25, 171, 550, 10);
/*      */       
/* 7760 */       Font fuente = new Font("Dialog", 0, 7);
/* 7761 */       this.g2.setFont(fuente);
/* 7762 */       this.g2.setColor(Color.WHITE);
/* 7763 */       this.g2.drawString("NÚM", 29, 179);
/* 7764 */       this.g2.drawString("NÚM DE FAC", 109, 179);
/* 7765 */       this.g2.drawString("IMPORTE", 245, 179);
/* 7766 */       this.g2.drawString("ABONO", 375, 179);
/* 7767 */       this.g2.drawString("SALDO", 510, 179);
/*      */       
/* 7769 */       this.g2.setColor(Color.BLACK);
/* 7770 */       y = 180;
/* 7771 */       for (int line = start; line < end; line++) {
/* 7772 */         y += 12;
/*      */         
/* 7774 */         String valor = "";
/* 7775 */         if (line < 9) {
/* 7776 */           valor = "0" + line + 1;
/*      */         } else {
/* 7778 */           valor = "" + line + 1;
/*      */         } 
/* 7780 */         fuente = new Font("Dialog", 1, 7);
/* 7781 */         this.g2.setFont(fuente);
/* 7782 */         this.g2.drawString(valor, 27, y - 2);
/*      */         
/* 7784 */         fuente = new Font("Dialog", 0, 7);
/* 7785 */         this.g2.setFont(fuente);
/*      */         
/* 7787 */         this.g2.drawString(String.valueOf(TarjetaCliente.this.rSTableMetro7.getValueAt(line, 1)), 102, y - 2);
/* 7788 */         this.g2.drawString(String.valueOf(TarjetaCliente.this.rSTableMetro7.getValueAt(line, 2)), TarjetaCliente.this.alinearDer(310, TarjetaCliente.this.rSTableMetro7.getValueAt(line, 2).toString().length()), y - 2);
/* 7789 */         this.g2.drawString(String.valueOf(TarjetaCliente.this.rSTableMetro7.getValueAt(line, 4)), TarjetaCliente.this.alinearDer(441, TarjetaCliente.this.rSTableMetro7.getValueAt(line, 4).toString().length()), y - 2);
/* 7790 */         this.g2.drawString(TarjetaCliente.this.COL1[line], TarjetaCliente.this.alinearDer(567, TarjetaCliente.this.COL1[line].length()), y - 2);
/*      */       } 
/* 7792 */       this.g2.drawLine(75, y, 185, y);
/* 7793 */       this.g2.drawLine(205, y, 315, y);
/* 7794 */       this.g2.drawLine(335, y, 445, y);
/* 7795 */       this.g2.drawLine(465, y, 575, y);
/*      */       
/* 7797 */       g.drawString("Página " + pageIndex + 1, 540, 749);
/* 7798 */       if (this.Pag == pageIndex) {
/* 7799 */         fuente = new Font("Dialog", 1, 7);
/* 7800 */         this.g2.setFont(fuente);
/* 7801 */         g.drawString("SUMAS", 119, y + 10);
/*      */         
/* 7803 */         TarjetaCliente.this.jFormattedTextField4.setValue(Double.valueOf(TarjetaCliente.this.VALOR1));
/* 7804 */         this.g2.drawString(TarjetaCliente.this.jFormattedTextField4.getText(), TarjetaCliente.this.alinearDer(310, TarjetaCliente.this.jFormattedTextField4.getText().length()), y + 10);
/*      */         
/* 7806 */         this.g2.drawString(TarjetaCliente.this.jLabel37.getText(), TarjetaCliente.this.alinearDer(441, TarjetaCliente.this.jLabel37.getText().length()), y + 10);
/*      */         
/* 7808 */         TarjetaCliente.this.jFormattedTextField4.setValue(Double.valueOf(TarjetaCliente.this.VALOR2));
/* 7809 */         this.g2.drawString(TarjetaCliente.this.jFormattedTextField4.getText(), TarjetaCliente.this.alinearDer(569, TarjetaCliente.this.jFormattedTextField4.getText().length()), y + 10);
/*      */         
/* 7811 */         fuente = new Font("Dialog", 1, 7);
/* 7812 */         this.g2.setFont(fuente);
/* 7813 */         this.g2.drawString("ELABORÓ", 290, 720);
/* 7814 */         this.g2.drawString("_____________________________________", 240, 752);
/* 7815 */         this.g2.drawString("NOMBRE Y FIRMA", 278, 765);
/*      */       } 
/* 7817 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 7821 */       Font fuente = new Font("Dialog", 0, 8);
/* 7822 */       this.g2.setFont(fuente);
/* 7823 */       this.g2.setColor(Color.BLACK);
/* 7824 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 7825 */       Image img = imagen.getImage();
/* 7826 */       this.g2.drawImage(img, 518, 9, 57, 57, null);
/*      */       
/* 7828 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 7829 */       img = imagen.getImage();
/* 7830 */       this.g2.drawImage(img, 27, 15, 60, 50, null);
/*      */       
/* 7832 */       fuente = new Font("Times New Roman", 1, 16);
/* 7833 */       this.g2.setFont(fuente);
/* 7834 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 20);
/* 7835 */       this.g2.drawString(TarjetaCliente.this.DATOS[0], 135, 65);
/*      */       
/* 7837 */       fuente = new Font("Dialog", 0, 12);
/* 7838 */       this.g2.setFont(fuente);
/* 7839 */       this.g2.drawString("DETALLES DEL DEPÓSITO " + TarjetaCliente.this.jTextField14.getText(), 200, 37);
/* 7840 */       this.g2.drawLine(25, 70, 575, 70);
/*      */       
/* 7842 */       this.g2.setColor(Color.BLACK);
/* 7843 */       this.g2.drawLine(25, 98, 220, 98);
/* 7844 */       this.g2.drawLine(25, 148, 220, 148);
/*      */       
/* 7846 */       fuente = new Font("Dialog", 1, 8);
/* 7847 */       this.g2.setFont(fuente);
/* 7848 */       this.g2.setColor(Color.BLACK);
/* 7849 */       this.g2.drawString("INFORMACIÓN DEL DEPÓSITO", 25, 95);
/*      */       
/* 7851 */       fuente = new Font("Dialog", 1, 7);
/* 7852 */       this.g2.setFont(fuente);
/* 7853 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 7855 */       this.g2.drawString("Banco: ", 27, 108);
/* 7856 */       this.g2.drawString("Cuenta: ", 27, 119);
/* 7857 */       this.g2.drawString("Ref: ", 27, 130);
/* 7858 */       this.g2.drawString("Depósito por: ", 27, 141);
/*      */       
/* 7860 */       fuente = new Font("Dialog", 0, 7);
/* 7861 */       this.g2.setFont(fuente);
/* 7862 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 7864 */       this.g2.drawString(TarjetaCliente.this.jTextField15.getText().toUpperCase(), 85, 108);
/* 7865 */       this.g2.drawString(TarjetaCliente.this.jTextField16.getText().toUpperCase(), 85, 119);
/* 7866 */       this.g2.drawString(TarjetaCliente.this.jTextField17.getText().toUpperCase(), 85, 130);
/* 7867 */       this.g2.drawString(TarjetaCliente.this.jFormattedTextField1.getText(), 85, 141);
/*      */       
/* 7869 */       this.g2.drawString(TarjetaCliente.this.DATOS[11], 540, 78);
/*      */       
/* 7871 */       fuente = new Font("Dialog", 0, 7);
/* 7872 */       this.g2.setFont(fuente);
/* 7873 */       this.g2.drawString("A continuación se enlistan todos los movimientos del depósito:", 25, 168);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 7877 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 7878 */       job.setPrintable(this);
/*      */       
/* 7880 */       PageFormat pf = job.defaultPage();
/* 7881 */       Paper papel = pf.getPaper();
/* 7882 */       papel.setSize(612.0D, 792.0D);
/* 7883 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 7884 */       pf.setPaper(papel);
/* 7885 */       pf.setOrientation(1);
/* 7886 */       job.setPrintable(new ImprimirEstado(), pf);
/* 7887 */       job.defaultPage(pf);
/*      */       
/* 7889 */       boolean ok = job.printDialog();
/* 7890 */       if (ok)
/*      */         try {
/* 7892 */           job.print();
/* 7893 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/TarjetaCliente.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */