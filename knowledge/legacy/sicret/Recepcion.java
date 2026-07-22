/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JComponent;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.SimpleAttributeSet;
/*      */ import javax.swing.text.StyleConstants;
/*      */ 
/*      */ public class Recepcion extends JPanel {
/*      */   JScrollPane panel;
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
/*      */   String USUARIO;
/*   54 */   Validaciones val = new Validaciones();
/*   55 */   Consultas con = new Consultas();
/*   56 */   Errores error = new Errores(false);
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   JFrame padre;
/*      */   EscribirReporte esc;
/*   61 */   Date fechaActual = new Date();
/*   62 */   Date fecha = new Date();
/*   63 */   String DIRECTIVA = "";
/*   64 */   String[] DATOS = null;
/*   65 */   CeldaRender celda = new CeldaRender();
/*   66 */   String TODOS = null;
/*   67 */   Date fechaInicio = null;
/*   68 */   String[] LINEAS = null;
/*   69 */   int LINEAS1 = 0;
/*   70 */   int LINEAS2 = 0;
/*   71 */   String base = "";
/*   72 */   MensajePop mensajeTry = null; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton2; private JButton jButton3; private JButton jButton4; private JButton jButton44; private JButton jButton45; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JDateChooser jDateChooser11; private JDateChooser jDateChooser12; private JDateChooser jDateChooser13; private JDateChooser jDateChooser14; private JDateChooser jDateChooser15; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel127; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26;
/*      */   private JLabel jLabel27;
/*      */   
/*      */   public Recepcion(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*   76 */     this.mensajeTry = mensajeTry;
/*   77 */     String año = "2010";
/*   78 */     String mes = "10";
/*   79 */     String dia = "10";
/*   80 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   81 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   83 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*      */     }
/*   85 */     catch (ParseException ex) {
/*   86 */       ex.printStackTrace();
/*      */     } 
/*   88 */     this.padre = padre;
/*   89 */     this.fichas = fichas;
/*   90 */     initComponents();
/*   91 */     this.USUARIO = USUARIO;
/*   92 */     panelito.setViewportView(this);
/*   93 */     this.panel = panelito;
/*   94 */     consultar();
/*      */     
/*   96 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*   97 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   98 */     this.jDialog1.setCursor(micursor);
/*   99 */     this.jDialog2.setCursor(micursor);
/*  100 */     this.jDialog3.setCursor(micursor);
/*      */     
/*  102 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  103 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  104 */     this.jLabel54.setCursor(micursor);
/*  105 */     this.jLabel51.setCursor(micursor);
/*  106 */     this.jLabel21.setCursor(micursor);
/*  107 */     this.jLabel26.setCursor(micursor);
/*  108 */     this.jLabel27.setCursor(micursor);
/*  109 */     this.jLabel57.setCursor(micursor);
/*      */     
/*  111 */     int w = this.tama.width;
/*  112 */     int h = this.tama.height;
/*  113 */     int rw = (w - 635) / 2;
/*  114 */     int rh = (h - 565) / 2;
/*  115 */     this.jDialog1.setSize(680, 565);
/*  116 */     this.jDialog1.setLocation(rw, rh);
/*  117 */     this.jDialog1.setResizable(false);
/*      */     
/*  119 */     this.jDialog2.setSize(450, 340);
/*  120 */     this.jDialog2.setResizable(false);
/*      */     
/*  122 */     rw = (w - 655) / 2;
/*  123 */     rh = (h - 565) / 2;
/*  124 */     this.jDialog3.setSize(655, 565);
/*  125 */     this.jDialog3.setLocation(rw, rh);
/*  126 */     this.jDialog3.setResizable(false);
/*      */     
/*  128 */     rw = (w - 390) / 2;
/*  129 */     rh = (h - 230) / 2;
/*  130 */     this.jDialog4.setLocation(rw, rh);
/*  131 */     this.jDialog4.setSize(390, 230);
/*  132 */     this.jDialog4.setVisible(false);
/*  133 */     this.jDialog4.setResizable(false);
/*      */     
/*  135 */     rw = (w - 390) / 2;
/*  136 */     rh = (h - 280) / 2;
/*  137 */     this.jDialog5.setLocation(rw, rh);
/*  138 */     this.jDialog5.setSize(390, 280);
/*  139 */     this.jDialog5.setVisible(false);
/*  140 */     this.jDialog5.setResizable(false);
/*      */     
/*  142 */     colorear();
/*  143 */     consultarDatos();
/*  144 */     llenarCombos();
/*      */     
/*  146 */     this.con.consultar("directiva", "configuraciones", "");
/*  147 */     this.DIRECTIVA = this.con.Campo;
/*      */     
/*  149 */     this.con.consultar("sucursal", "configuraciones", "");
/*  150 */     this.base = this.con.Campo;
/*      */   }
/*      */   private JLabel jLabel28; private JLabel jLabel3; private JLabel jLabel4; private JLabel jLabel5; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel6; private JLabel jLabel7; private JLabel jLabel8; private JLabel jLabel9; private JPanel jPanel1; private JPanel jPanel2; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel4; private JPanel jPanel7; private JScrollPane jScrollPane1; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JSeparator jSeparator1; private JSeparator jSeparator2; private JSeparator jSeparator27; private JSeparator jSeparator28; private JSeparator jSeparator4; private JSeparator jSeparator5; private JTable jTable1; private JTable jTable4; private JTextArea jTextArea1; private JTextArea jTextArea2; private JTextArea jTextArea3; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9; private JTextPane jTextPane1; private JTextPane jTextPane2;
/*      */   
/*      */   private void initComponents() {
/*  155 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  156 */     this.jPanel3 = new JPanel();
/*  157 */     this.jSeparator4 = new JSeparator();
/*  158 */     this.jTextField5 = new JTextField();
/*  159 */     this.jLabel11 = new JLabel();
/*  160 */     this.jTextField6 = new JTextField();
/*  161 */     this.jLabel12 = new JLabel();
/*  162 */     this.jDateChooser13 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  163 */     this.jLabel13 = new JLabel();
/*  164 */     this.jScrollPane3 = new JScrollPane();
/*  165 */     this.jTextArea1 = new JTextArea();
/*  166 */     this.jButton5 = new JButton();
/*  167 */     this.jLabel14 = new JLabel();
/*  168 */     this.jButton6 = new JButton();
/*  169 */     this.jButton7 = new JButton();
/*  170 */     this.jTextField7 = new JTextField();
/*  171 */     this.jScrollPane4 = new JScrollPane();
/*  172 */     this.jTextArea2 = new JTextArea();
/*  173 */     this.jLabel19 = new JLabel();
/*  174 */     this.jComboBox4 = new JComboBox();
/*  175 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  176 */     this.jPanel4 = new JPanel();
/*  177 */     this.jLabel15 = new JLabel();
/*  178 */     this.jSeparator5 = new JSeparator();
/*  179 */     this.jScrollPane5 = new JScrollPane();
/*  180 */     this.jTable4 = new JTable();
/*  181 */     this.jLabel1 = new JLabel();
/*  182 */     this.jComboBox3 = new JComboBox();
/*  183 */     this.jLabel16 = new JLabel();
/*  184 */     this.jDateChooser14 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  185 */     this.jLabel17 = new JLabel();
/*  186 */     this.jLabel18 = new JLabel();
/*  187 */     this.jTextField8 = new JTextField();
/*  188 */     this.jLabel52 = new JLabel();
/*  189 */     this.jLabel51 = new JLabel();
/*  190 */     this.jLabel53 = new JLabel();
/*  191 */     this.jLabel54 = new JLabel();
/*  192 */     this.jLabel55 = new JLabel();
/*  193 */     this.jDateChooser15 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  194 */     this.jButton8 = new JButton();
/*  195 */     this.jLabel28 = new JLabel();
/*  196 */     this.jComboBox6 = new JComboBox();
/*  197 */     this.jLabel56 = new JLabel();
/*  198 */     this.jLabel57 = new JLabel();
/*  199 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  200 */     this.jPanel2 = new JPanel();
/*  201 */     this.jLabel20 = new JLabel();
/*  202 */     this.jTextField9 = new JTextField();
/*  203 */     this.jSeparator2 = new JSeparator();
/*  204 */     this.jScrollPane6 = new JScrollPane();
/*  205 */     this.jTextPane2 = new JTextPane();
/*  206 */     this.jButton9 = new JButton();
/*  207 */     this.jButton10 = new JButton();
/*  208 */     this.jLabel22 = new JLabel();
/*  209 */     this.jTextField10 = new JTextField();
/*  210 */     this.jLabel23 = new JLabel();
/*  211 */     this.jTextField11 = new JTextField();
/*  212 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  213 */     this.jPanel29 = new JPanel();
/*  214 */     this.jLabel124 = new JLabel();
/*  215 */     this.jSeparator27 = new JSeparator();
/*  216 */     this.jLabel125 = new JLabel();
/*  217 */     this.jButton44 = new JButton();
/*  218 */     this.jButton45 = new JButton();
/*  219 */     this.jScrollPane18 = new JScrollPane();
/*  220 */     this.jTextArea5 = new JTextArea();
/*  221 */     this.jLabel126 = new JLabel();
/*  222 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  223 */     this.jPanel30 = new JPanel();
/*  224 */     this.jLabel127 = new JLabel();
/*  225 */     this.jSeparator28 = new JSeparator();
/*  226 */     this.jLabel24 = new JLabel();
/*  227 */     this.jScrollPane7 = new JScrollPane();
/*  228 */     this.jTextArea3 = new JTextArea();
/*  229 */     this.jLabel25 = new JLabel();
/*  230 */     this.jComboBox5 = new JComboBox();
/*  231 */     this.jButton11 = new JButton();
/*  232 */     this.jButton12 = new JButton();
/*  233 */     this.jPanel7 = new JPanel();
/*  234 */     this.jLabel4 = new JLabel();
/*  235 */     this.jSeparator1 = new JSeparator();
/*  236 */     this.jScrollPane1 = new JScrollPane();
/*  237 */     this.jTable1 = new JTable();
/*  238 */     this.jButton1 = new JButton();
/*  239 */     this.jButton2 = new JButton();
/*  240 */     this.jButton3 = new JButton();
/*  241 */     this.jButton4 = new JButton();
/*  242 */     this.jPanel1 = new JPanel();
/*  243 */     this.jLabel2 = new JLabel();
/*  244 */     this.jDateChooser11 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  245 */     this.jLabel3 = new JLabel();
/*  246 */     this.jDateChooser12 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  247 */     this.jLabel5 = new JLabel();
/*  248 */     this.jTextField1 = new JTextField();
/*  249 */     this.jLabel6 = new JLabel();
/*  250 */     this.jTextField2 = new JTextField();
/*  251 */     this.jLabel7 = new JLabel();
/*  252 */     this.jTextField3 = new JTextField();
/*  253 */     this.jLabel8 = new JLabel();
/*  254 */     this.jComboBox1 = new JComboBox();
/*  255 */     this.jLabel9 = new JLabel();
/*  256 */     this.jLabel10 = new JLabel();
/*  257 */     this.jTextField4 = new JTextField();
/*  258 */     this.jComboBox2 = new JComboBox();
/*  259 */     this.jLabel21 = new JLabel();
/*  260 */     this.jLabel26 = new JLabel();
/*  261 */     this.jLabel27 = new JLabel();
/*  262 */     this.jButton13 = new JButton();
/*  263 */     this.jScrollPane2 = new JScrollPane();
/*  264 */     this.jTextPane1 = new JTextPane();
/*      */     
/*  266 */     this.jDialog1.setTitle("Nueva Recepción");
/*      */     
/*  268 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/*      */     
/*  270 */     this.jTextField5.setFont(new Font("Times New Roman", 1, 15));
/*  271 */     this.jTextField5.setHorizontalAlignment(0);
/*  272 */     this.jTextField5.setText("TITULO DEL DOCUMENTO");
/*      */     
/*  274 */     this.jLabel11.setHorizontalAlignment(4);
/*  275 */     this.jLabel11.setText("Asunto");
/*      */     
/*  277 */     this.jLabel12.setFont(new Font("Tahoma", 1, 11));
/*  278 */     this.jLabel12.setHorizontalAlignment(4);
/*  279 */     this.jLabel12.setText("Fecha");
/*      */     
/*  281 */     this.jDateChooser13.setDate(this.fechaActual);
/*  282 */     this.jDateChooser13.setDateFormatString("dd/MM/yyyy");
/*  283 */     this.jDateChooser13.setIcon(this.icon);
/*      */     
/*  285 */     this.jLabel13.setFont(new Font("Tahoma", 1, 11));
/*  286 */     this.jLabel13.setText("Contenido del documento");
/*      */     
/*  288 */     this.jTextArea1.setColumns(20);
/*  289 */     this.jTextArea1.setFont(new Font("Verdana", 0, 9));
/*  290 */     this.jTextArea1.setLineWrap(true);
/*  291 */     this.jTextArea1.setRows(5);
/*  292 */     this.jScrollPane3.setViewportView(this.jTextArea1);
/*      */     
/*  294 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/agregar.png")));
/*  295 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  297 */             Recepcion.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  301 */     this.jLabel14.setText("Comentario");
/*      */     
/*  303 */     this.jButton6.setText("Cerrar");
/*  304 */     this.jButton6.setToolTipText("Cerrar (Alt+C)");
/*  305 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  307 */             Recepcion.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  311 */     this.jButton7.setMnemonic('G');
/*  312 */     this.jButton7.setText("Guardar");
/*  313 */     this.jButton7.setToolTipText("Guardar (Alt+G)");
/*  314 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  316 */             Recepcion.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  320 */     this.jTextField7.setEditable(false);
/*  321 */     this.jTextField7.setFont(new Font("Times New Roman", 1, 22));
/*  322 */     this.jTextField7.setForeground(Color.blue);
/*  323 */     this.jTextField7.setText("PR-REP-00001");
/*      */     
/*  325 */     this.jTextArea2.setColumns(20);
/*  326 */     this.jTextArea2.setFont(new Font("Verdana", 0, 9));
/*  327 */     this.jTextArea2.setLineWrap(true);
/*  328 */     this.jTextArea2.setRows(5);
/*  329 */     this.jScrollPane4.setViewportView(this.jTextArea2);
/*      */     
/*  331 */     this.jLabel19.setText("Usuario que recibirá");
/*      */     
/*  333 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  334 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*      */     
/*  336 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  337 */     this.jPanel3.setLayout(jPanel3Layout);
/*  338 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  339 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  340 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  341 */           .addContainerGap()
/*  342 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  343 */             .addComponent(this.jScrollPane4, -1, 656, 32767)
/*  344 */             .addComponent(this.jScrollPane3, -1, 656, 32767)
/*  345 */             .addComponent(this.jTextField5, GroupLayout.Alignment.TRAILING, -1, 656, 32767)
/*  346 */             .addComponent(this.jLabel14, -2, 466, -2)
/*  347 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  348 */               .addComponent(this.jLabel13, -2, 466, -2)
/*  349 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 157, 32767)
/*  350 */               .addComponent(this.jButton5, -2, 33, -2))
/*  351 */             .addComponent(this.jSeparator4, GroupLayout.Alignment.TRAILING, -1, 656, 32767)
/*  352 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  353 */               .addComponent(this.jTextField7, -2, 223, -2)
/*  354 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 144, 32767)
/*  355 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  356 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  357 */                   .addComponent(this.jLabel11, -2, 62, -2)
/*  358 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  359 */                   .addComponent(this.jTextField6, -2, 223, -2))
/*  360 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  361 */                   .addComponent(this.jLabel12)
/*  362 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  363 */                   .addComponent((Component)this.jDateChooser13, -2, 108, -2)
/*  364 */                   .addGap(115, 115, 115))))
/*  365 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/*  366 */               .addComponent(this.jLabel19, -2, 119, -2)
/*  367 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  368 */               .addComponent(this.jComboBox4, -2, 204, -2)
/*  369 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 127, 32767)
/*  370 */               .addComponent(this.jButton7, -2, 98, -2)
/*  371 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  372 */               .addComponent(this.jButton6, -2, 98, -2)))
/*  373 */           .addContainerGap()));
/*      */     
/*  375 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  376 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  377 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  378 */           .addContainerGap()
/*  379 */           .addComponent(this.jTextField5, -2, -1, -2)
/*  380 */           .addGap(8, 8, 8)
/*  381 */           .addComponent(this.jSeparator4, -2, 11, -2)
/*  382 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  383 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  384 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  385 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  386 */                 .addComponent(this.jLabel12, -1, -1, 32767)
/*  387 */                 .addComponent((Component)this.jDateChooser13, -1, -1, 32767))
/*  388 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  389 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  390 */                 .addComponent(this.jTextField6, -2, -1, -2)
/*  391 */                 .addComponent(this.jLabel11))
/*  392 */               .addGap(11, 11, 11))
/*  393 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  394 */               .addComponent(this.jTextField7, -2, 44, -2)
/*  395 */               .addGap(18, 18, 18)))
/*  396 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  397 */             .addComponent(this.jLabel13)
/*  398 */             .addComponent(this.jButton5, -2, 23, -2))
/*  399 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  400 */           .addComponent(this.jScrollPane4, -2, 181, -2)
/*  401 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  402 */           .addComponent(this.jLabel14)
/*  403 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  404 */           .addComponent(this.jScrollPane3, -2, 120, -2)
/*  405 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  406 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  407 */             .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  408 */               .addComponent(this.jButton6)
/*  409 */               .addComponent(this.jButton7))
/*  410 */             .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  411 */               .addComponent(this.jLabel19)
/*  412 */               .addComponent(this.jComboBox4, -2, -1, -2)))
/*  413 */           .addContainerGap(16, 32767)));
/*      */ 
/*      */     
/*  416 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  417 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  418 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  419 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  420 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/*  422 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  423 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  424 */         .addComponent(this.jPanel3, -2, -1, -2));
/*      */ 
/*      */     
/*  427 */     this.jDialog2.setTitle("Selecciona los datos a agregar");
/*      */     
/*  429 */     this.jPanel4.setBackground(new Color(255, 255, 255));
/*  430 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  432 */     this.jLabel15.setFont(new Font("Times New Roman", 1, 14));
/*  433 */     this.jLabel15.setHorizontalAlignment(0);
/*  434 */     this.jLabel15.setText("Agregar Datos");
/*      */     
/*  436 */     this.jTable4.setFont(new Font("Tahoma", 0, 10));
/*  437 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Title 1", "Title 2" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  445 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  450 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  453 */     this.jTable4.setShowVerticalLines(false);
/*  454 */     this.jTable4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  456 */             Recepcion.this.jTable4MouseClicked(evt);
/*      */           }
/*      */         });
/*  459 */     this.jScrollPane5.setViewportView(this.jTable4);
/*      */     
/*  461 */     this.jLabel1.setFont(new Font("Tahoma", 0, 10));
/*  462 */     this.jLabel1.setHorizontalAlignment(4);
/*  463 */     this.jLabel1.setText("Tipo de documento");
/*      */     
/*  465 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/*  466 */     this.jComboBox3.setFont(new Font("Tahoma", 0, 10));
/*  467 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Guía", "Hojas de Recepción", "Manifiestos de Aceite", "Manifiestos de Agua", "Liquidaciones", "Prefactura", "Vale de Diesel" }));
/*  468 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  470 */             Recepcion.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  474 */     this.jLabel16.setFont(new Font("Tahoma", 0, 10));
/*  475 */     this.jLabel16.setHorizontalAlignment(4);
/*  476 */     this.jLabel16.setText("Fecha de ");
/*      */     
/*  478 */     this.jDateChooser14.setDate(this.fechaActual);
/*  479 */     this.jDateChooser14.setDateFormatString("dd/MM/yyyy");
/*  480 */     this.jDateChooser14.setFont(new Font("Tahoma", 0, 10));
/*  481 */     this.jDateChooser14.setIcon(this.icon);
/*      */     
/*  483 */     this.jLabel17.setHorizontalAlignment(0);
/*  484 */     this.jLabel17.setText("al");
/*      */     
/*  486 */     this.jLabel18.setFont(new Font("Tahoma", 0, 10));
/*  487 */     this.jLabel18.setHorizontalAlignment(4);
/*  488 */     this.jLabel18.setText("Folio");
/*      */     
/*  490 */     this.jTextField8.setFont(new Font("Tahoma", 0, 10));
/*  491 */     this.jTextField8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  493 */             Recepcion.this.jTextField8KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  497 */     this.jLabel52.setFont(new Font("Tahoma", 1, 11));
/*  498 */     this.jLabel52.setText("|");
/*      */     
/*  500 */     this.jLabel51.setFont(new Font("Tahoma", 1, 11));
/*  501 */     this.jLabel51.setForeground(Color.red);
/*  502 */     this.jLabel51.setHorizontalAlignment(0);
/*  503 */     this.jLabel51.setText("<html><u>Agregar</u></html>");
/*  504 */     this.jLabel51.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  506 */             Recepcion.this.jLabel51MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  509 */             Recepcion.this.jLabel51MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  512 */             Recepcion.this.jLabel51MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  516 */     this.jLabel53.setFont(new Font("Tahoma", 1, 11));
/*  517 */     this.jLabel53.setText("|");
/*      */     
/*  519 */     this.jLabel54.setFont(new Font("Tahoma", 1, 11));
/*  520 */     this.jLabel54.setForeground(Color.red);
/*  521 */     this.jLabel54.setHorizontalAlignment(0);
/*  522 */     this.jLabel54.setText("<html><u>Cerrar</u></html>");
/*  523 */     this.jLabel54.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  525 */             Recepcion.this.jLabel54MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  528 */             Recepcion.this.jLabel54MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  531 */             Recepcion.this.jLabel54MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  535 */     this.jLabel55.setFont(new Font("Tahoma", 1, 11));
/*  536 */     this.jLabel55.setText("|");
/*      */     
/*  538 */     this.jDateChooser15.setDate(this.fechaActual);
/*  539 */     this.jDateChooser15.setDateFormatString("dd/MM/yyyy");
/*  540 */     this.jDateChooser15.setFont(new Font("Tahoma", 0, 10));
/*  541 */     this.jDateChooser15.setIcon(this.icon);
/*      */     
/*  543 */     this.jButton8.setMnemonic('B');
/*  544 */     this.jButton8.setText("Buscar");
/*  545 */     this.jButton8.setToolTipText("Buscar Datos (Alt+B)");
/*  546 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  548 */             Recepcion.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  552 */     this.jLabel28.setFont(new Font("Tahoma", 0, 10));
/*  553 */     this.jLabel28.setHorizontalAlignment(4);
/*  554 */     this.jLabel28.setText("Servicio");
/*  555 */     this.jLabel28.setEnabled(false);
/*      */     
/*  557 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*  558 */     this.jComboBox6.setFont(new Font("Tahoma", 0, 10));
/*  559 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "Flete", "Movimiento en Falso", "Movimiento Lateral", "Movimiento Interno", "Servicio Integral", "Servicio de Retro", "Renta" }));
/*  560 */     this.jComboBox6.setEnabled(false);
/*  561 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  563 */             Recepcion.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  567 */     this.jLabel56.setFont(new Font("Tahoma", 1, 11));
/*  568 */     this.jLabel56.setText("|");
/*      */     
/*  570 */     this.jLabel57.setFont(new Font("Tahoma", 1, 11));
/*  571 */     this.jLabel57.setForeground(Color.red);
/*  572 */     this.jLabel57.setHorizontalAlignment(0);
/*  573 */     this.jLabel57.setText("<html><u>Agregar Todos</u></html>");
/*  574 */     this.jLabel57.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  576 */             Recepcion.this.jLabel57MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  579 */             Recepcion.this.jLabel57MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  582 */             Recepcion.this.jLabel57MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  586 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  587 */     this.jPanel4.setLayout(jPanel4Layout);
/*  588 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  589 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  590 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  591 */           .addContainerGap()
/*  592 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  593 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  594 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  595 */                 .addComponent(this.jLabel28, -1, -1, 32767)
/*  596 */                 .addComponent(this.jLabel16, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  597 */                 .addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, 92, 32767))
/*  598 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  599 */               .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  600 */                 .addGroup(jPanel4Layout.createSequentialGroup()
/*  601 */                   .addComponent((Component)this.jDateChooser14, -2, 94, -2)
/*  602 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  603 */                   .addComponent(this.jLabel17)
/*  604 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  605 */                   .addComponent((Component)this.jDateChooser15, -2, 94, -2))
/*  606 */                 .addComponent(this.jComboBox3, 0, -1, 32767)
/*  607 */                 .addComponent(this.jComboBox6, 0, -1, 32767))
/*  608 */               .addGap(0, 118, 32767))
/*  609 */             .addComponent(this.jSeparator5, -1, 418, 32767)
/*  610 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  611 */               .addGap(10, 10, 10)
/*  612 */               .addComponent(this.jLabel18, -2, 82, -2)
/*  613 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  614 */               .addComponent(this.jTextField8, -2, 82, -2)
/*  615 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 165, 32767)
/*  616 */               .addComponent(this.jButton8, -2, 75, -2))
/*  617 */             .addComponent(this.jLabel15, -1, 418, 32767)
/*  618 */             .addComponent(this.jScrollPane5, -1, 418, 32767)
/*  619 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/*  620 */               .addGap(0, 0, 32767)
/*  621 */               .addComponent(this.jLabel56)
/*  622 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  623 */               .addComponent(this.jLabel57, -2, 95, -2)
/*  624 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  625 */               .addComponent(this.jLabel55)
/*  626 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  627 */               .addComponent(this.jLabel51, -2, -1, -2)
/*  628 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  629 */               .addComponent(this.jLabel52)
/*  630 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  631 */               .addComponent(this.jLabel54, -2, -1, -2)
/*  632 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  633 */               .addComponent(this.jLabel53)))
/*  634 */           .addContainerGap()));
/*      */     
/*  636 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  637 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  638 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  639 */           .addComponent(this.jLabel15)
/*  640 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  641 */           .addComponent(this.jSeparator5, -2, 5, -2)
/*  642 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  643 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  644 */             .addComponent(this.jLabel1)
/*  645 */             .addComponent(this.jComboBox3, -2, -1, -2))
/*  646 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  647 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  648 */             .addComponent(this.jLabel28)
/*  649 */             .addComponent(this.jComboBox6, -2, -1, -2))
/*  650 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  651 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  652 */             .addComponent(this.jLabel17, -1, -1, 32767)
/*  653 */             .addComponent((Component)this.jDateChooser14, -1, -1, 32767)
/*  654 */             .addComponent((Component)this.jDateChooser15, -1, -1, 32767)
/*  655 */             .addComponent(this.jLabel16, -1, -1, 32767))
/*  656 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  657 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  658 */             .addComponent(this.jTextField8, -2, 17, -2)
/*  659 */             .addComponent(this.jLabel18)
/*  660 */             .addComponent(this.jButton8))
/*  661 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  662 */           .addComponent(this.jScrollPane5, -2, 121, -2)
/*  663 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  664 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  665 */             .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  666 */               .addComponent(this.jLabel57, -2, -1, -2)
/*  667 */               .addComponent(this.jLabel56))
/*  668 */             .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  669 */               .addComponent(this.jLabel53)
/*  670 */               .addComponent(this.jLabel52)
/*  671 */               .addComponent(this.jLabel51, -2, -1, -2)
/*  672 */               .addComponent(this.jLabel54, -2, -1, -2)
/*  673 */               .addComponent(this.jLabel55)))
/*  674 */           .addContainerGap()));
/*      */ 
/*      */     
/*  677 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  678 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  679 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  680 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  681 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*      */     
/*  683 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  684 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  685 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  686 */           .addComponent(this.jPanel4, -2, -1, -2)
/*  687 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/*  690 */     this.jDialog3.setTitle("Nueva Recepción");
/*      */     
/*  692 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/*      */     
/*  694 */     this.jLabel20.setText("Folio:");
/*      */     
/*  696 */     this.jTextField9.setEditable(false);
/*  697 */     this.jTextField9.setFont(new Font("Tahoma", 1, 15));
/*  698 */     this.jTextField9.setText(" PR-REP-00001");
/*      */     
/*  700 */     this.jTextPane2.setEditable(false);
/*  701 */     this.jTextPane2.setFont(new Font("Tahoma", 0, 10));
/*  702 */     this.jScrollPane6.setViewportView(this.jTextPane2);
/*      */     
/*  704 */     this.jButton9.setMnemonic('C');
/*  705 */     this.jButton9.setText("Cerrar");
/*  706 */     this.jButton9.setToolTipText("Cerrar (Alt+C)");
/*  707 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  709 */             Recepcion.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  713 */     this.jButton10.setMnemonic('I');
/*  714 */     this.jButton10.setText("Imprimir");
/*  715 */     this.jButton10.setToolTipText("Imprimir (Alt+I)");
/*  716 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  718 */             Recepcion.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  722 */     this.jLabel22.setText("Creador");
/*      */     
/*  724 */     this.jTextField10.setEditable(false);
/*  725 */     this.jTextField10.setFont(new Font("Tahoma", 1, 15));
/*  726 */     this.jTextField10.setText(" PR-REP-00001");
/*      */     
/*  728 */     this.jLabel23.setText("Fecha");
/*      */     
/*  730 */     this.jTextField11.setEditable(false);
/*  731 */     this.jTextField11.setFont(new Font("Tahoma", 1, 15));
/*  732 */     this.jTextField11.setText(" PR-REP-00001");
/*      */     
/*  734 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  735 */     this.jPanel2.setLayout(jPanel2Layout);
/*  736 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  737 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  738 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/*  739 */           .addContainerGap()
/*  740 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  741 */             .addComponent(this.jScrollPane6, GroupLayout.Alignment.LEADING)
/*  742 */             .addComponent(this.jSeparator2, GroupLayout.Alignment.LEADING)
/*  743 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
/*  744 */               .addComponent(this.jLabel20, -2, 42, -2)
/*  745 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  746 */               .addComponent(this.jTextField9, -2, 133, -2)
/*  747 */               .addGap(18, 18, 18)
/*  748 */               .addComponent(this.jLabel22)
/*  749 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  750 */               .addComponent(this.jTextField10, -2, 187, -2)
/*  751 */               .addGap(18, 18, 18)
/*  752 */               .addComponent(this.jLabel23, -2, 39, -2)
/*  753 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  754 */               .addComponent(this.jTextField11, -2, -1, -2))
/*  755 */             .addGroup(jPanel2Layout.createSequentialGroup()
/*  756 */               .addComponent(this.jButton10, -2, 102, -2)
/*  757 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  758 */               .addComponent(this.jButton9, -2, 102, -2)))
/*  759 */           .addContainerGap()));
/*      */     
/*  761 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  762 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  763 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  764 */           .addContainerGap()
/*  765 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  766 */             .addComponent(this.jLabel20)
/*  767 */             .addComponent(this.jTextField9, -2, 40, -2)
/*  768 */             .addComponent(this.jLabel22)
/*  769 */             .addComponent(this.jTextField10, -2, 40, -2)
/*  770 */             .addComponent(this.jLabel23)
/*  771 */             .addComponent(this.jTextField11, -2, 40, -2))
/*  772 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  773 */           .addComponent(this.jSeparator2, -2, 10, -2)
/*  774 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  775 */           .addComponent(this.jScrollPane6, -1, 410, 32767)
/*  776 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  777 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  778 */             .addComponent(this.jButton9)
/*  779 */             .addComponent(this.jButton10))
/*  780 */           .addContainerGap()));
/*      */ 
/*      */     
/*  783 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/*  784 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/*  785 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/*  786 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  787 */         .addComponent(this.jPanel2, -2, -1, -2));
/*      */     
/*  789 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/*  790 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  791 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */ 
/*      */     
/*  794 */     this.jDialog4.setTitle("Cancelar Liquidación");
/*  795 */     this.jDialog4.setModal(true);
/*      */     
/*  797 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*      */     
/*  799 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/*  800 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/*  801 */     this.jLabel124.setHorizontalAlignment(0);
/*  802 */     this.jLabel124.setText("Motivo de la Cancelación");
/*      */     
/*  804 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/*  805 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/*  806 */     this.jLabel125.setHorizontalAlignment(4);
/*  807 */     this.jLabel125.setText("Motivo");
/*      */     
/*  809 */     this.jButton44.setMnemonic('A');
/*  810 */     this.jButton44.setText("Cancelar Recepción");
/*  811 */     this.jButton44.setToolTipText("Cancelar Recepción (Alt+A)");
/*  812 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  814 */             Recepcion.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  818 */     this.jButton45.setMnemonic('C');
/*  819 */     this.jButton45.setText("Cerrar");
/*  820 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/*  821 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  823 */             Recepcion.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  827 */     this.jTextArea5.setColumns(20);
/*  828 */     this.jTextArea5.setLineWrap(true);
/*  829 */     this.jTextArea5.setRows(5);
/*  830 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/*  832 */     this.jLabel126.setText("Ingresa el motivo por el cual deseas cancelar el movimiento");
/*      */     
/*  834 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/*  835 */     this.jPanel29.setLayout(jPanel29Layout);
/*  836 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/*  837 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  838 */         .addGroup(jPanel29Layout.createSequentialGroup()
/*  839 */           .addContainerGap()
/*  840 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  841 */             .addComponent(this.jLabel126, -1, -1, 32767)
/*  842 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  843 */               .addGroup(jPanel29Layout.createSequentialGroup()
/*  844 */                 .addComponent(this.jButton44)
/*  845 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  846 */                 .addComponent(this.jButton45, -2, 84, -2))
/*  847 */               .addGroup(jPanel29Layout.createSequentialGroup()
/*  848 */                 .addComponent(this.jLabel125, -2, 43, -2)
/*  849 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  850 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/*  851 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  852 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  853 */               .addComponent(this.jSeparator27, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/*  854 */           .addContainerGap()));
/*      */     
/*  856 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/*  857 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  858 */         .addGroup(jPanel29Layout.createSequentialGroup()
/*  859 */           .addComponent(this.jLabel124)
/*  860 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  861 */           .addComponent(this.jSeparator27, -2, 10, -2)
/*  862 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  863 */           .addComponent(this.jLabel126)
/*  864 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  865 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  866 */             .addComponent(this.jLabel125)
/*  867 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/*  868 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  869 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  870 */             .addComponent(this.jButton45)
/*  871 */             .addComponent(this.jButton44))
/*  872 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  875 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/*  876 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/*  877 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/*  878 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  879 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */     
/*  881 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/*  882 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  883 */         .addComponent(this.jPanel29, -2, -1, -2));
/*      */ 
/*      */     
/*  886 */     this.jDialog5.setTitle("Recibir Recepción");
/*  887 */     this.jDialog5.setModal(true);
/*      */     
/*  889 */     this.jPanel30.setBackground(new Color(146, 193, 134));
/*      */     
/*  891 */     this.jLabel127.setFont(new Font("Tahoma", 1, 14));
/*  892 */     this.jLabel127.setForeground(new Color(0, 102, 102));
/*  893 */     this.jLabel127.setHorizontalAlignment(0);
/*  894 */     this.jLabel127.setText("Recibir Recepción");
/*      */     
/*  896 */     this.jLabel24.setText("¿Deseas agregar algún comentario?");
/*      */     
/*  898 */     this.jTextArea3.setColumns(20);
/*  899 */     this.jTextArea3.setLineWrap(true);
/*  900 */     this.jTextArea3.setRows(5);
/*  901 */     this.jScrollPane7.setViewportView(this.jTextArea3);
/*      */     
/*  903 */     this.jLabel25.setText("Tipo de Recepción");
/*      */     
/*  905 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  906 */     this.jComboBox5.setFont(new Font("Tahoma", 0, 10));
/*  907 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "Recibido", "Rechazado", "Incompleto" }));
/*  908 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  910 */             Recepcion.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  914 */     this.jButton11.setMnemonic('C');
/*  915 */     this.jButton11.setText("Cancelar");
/*  916 */     this.jButton11.setToolTipText("Cerrar (Alt+C)");
/*  917 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  919 */             Recepcion.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  923 */     this.jButton12.setMnemonic('A');
/*  924 */     this.jButton12.setText("Aceptar");
/*  925 */     this.jButton12.setToolTipText("Aceptar (Alt+A)");
/*  926 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  928 */             Recepcion.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  932 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/*  933 */     this.jPanel30.setLayout(jPanel30Layout);
/*  934 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/*  935 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  936 */         .addGroup(jPanel30Layout.createSequentialGroup()
/*  937 */           .addContainerGap()
/*  938 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  939 */             .addComponent(this.jSeparator28, -1, 359, 32767)
/*  940 */             .addComponent(this.jLabel127, -1, 359, 32767)
/*  941 */             .addGroup(jPanel30Layout.createSequentialGroup()
/*  942 */               .addComponent(this.jLabel25, -2, 115, -2)
/*  943 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  944 */               .addComponent(this.jComboBox5, -2, 173, -2))
/*  945 */             .addComponent(this.jScrollPane7, -1, 359, 32767)
/*  946 */             .addComponent(this.jLabel24, -2, 271, -2)
/*  947 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
/*  948 */               .addComponent(this.jButton12, -2, 93, -2)
/*  949 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  950 */               .addComponent(this.jButton11, -2, 93, -2)))
/*  951 */           .addContainerGap()));
/*      */     
/*  953 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/*  954 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  955 */         .addGroup(jPanel30Layout.createSequentialGroup()
/*  956 */           .addComponent(this.jLabel127)
/*  957 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  958 */           .addComponent(this.jSeparator28, -2, 10, -2)
/*  959 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  960 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  961 */             .addComponent(this.jLabel25)
/*  962 */             .addComponent(this.jComboBox5, -2, -1, -2))
/*  963 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  964 */           .addComponent(this.jLabel24)
/*  965 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  966 */           .addComponent(this.jScrollPane7, -2, 113, -2)
/*  967 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  968 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  969 */             .addComponent(this.jButton11)
/*  970 */             .addComponent(this.jButton12))
/*  971 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  974 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/*  975 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/*  976 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/*  977 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  978 */         .addComponent(this.jPanel30, -1, -1, 32767));
/*      */     
/*  980 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/*  981 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  982 */         .addComponent(this.jPanel30, -2, -1, -2));
/*      */ 
/*      */     
/*  985 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/*  986 */     this.jPanel7.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  988 */     this.jLabel4.setFont(new Font("Times New Roman", 1, 22));
/*  989 */     this.jLabel4.setHorizontalAlignment(0);
/*  990 */     this.jLabel4.setText("RECEPCIÓN DE DOCUMENTOS");
/*      */     
/*  992 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/*  993 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1004 */     this.jTable1.setShowVerticalLines(false);
/* 1005 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1007 */             Recepcion.this.jTable1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1010 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/* 1012 */     this.jButton1.setMnemonic('C');
/* 1013 */     this.jButton1.setText("Cancelar");
/* 1014 */     this.jButton1.setToolTipText("Cancelar (Alt+C)");
/* 1015 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1017 */             Recepcion.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1021 */     this.jButton2.setMnemonic('V');
/* 1022 */     this.jButton2.setText("Ver");
/* 1023 */     this.jButton2.setToolTipText("Ver (Alt+V)");
/* 1024 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1026 */             Recepcion.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1030 */     this.jButton3.setMnemonic('N');
/* 1031 */     this.jButton3.setText("Nuevo");
/* 1032 */     this.jButton3.setToolTipText("Nuevo (Alt+N)");
/* 1033 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1035 */             Recepcion.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1039 */     this.jButton4.setMnemonic('R');
/* 1040 */     this.jButton4.setText("Recibir");
/* 1041 */     this.jButton4.setToolTipText("Recibir (Alt+R)");
/* 1042 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1044 */             Recepcion.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1048 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 1049 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder("Buscar"));
/*      */     
/* 1051 */     this.jLabel2.setText("Fecha de ");
/*      */     
/* 1053 */     this.jDateChooser11.setDate(this.fechaActual);
/* 1054 */     this.jDateChooser11.setDateFormatString("dd/MM/yyyy");
/* 1055 */     this.jDateChooser11.setIcon(this.icon);
/* 1056 */     this.jDateChooser11.setMaxSelectableDate(this.fecha);
/* 1057 */     this.jDateChooser11.setMinSelectableDate(new Date(1286690512000L));
/*      */     
/* 1059 */     this.jLabel3.setText("al");
/*      */     
/* 1061 */     this.jDateChooser12.setDate(this.fechaActual);
/* 1062 */     this.jDateChooser12.setDateFormatString("dd/MM/yyyy");
/* 1063 */     this.jDateChooser12.setIcon(this.icon);
/* 1064 */     this.jDateChooser12.setMaxSelectableDate(this.fecha);
/* 1065 */     this.jDateChooser12.setMinSelectableDate(new Date(1286690512000L));
/*      */     
/* 1067 */     this.jLabel5.setText("Folio");
/*      */     
/* 1069 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1071 */             Recepcion.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1075 */     this.jLabel6.setText("Titulo");
/*      */     
/* 1077 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1079 */             Recepcion.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1083 */     this.jLabel7.setText("Asunto");
/*      */     
/* 1085 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1087 */             Recepcion.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1091 */     this.jLabel8.setText("Usuario");
/*      */     
/* 1093 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1094 */     this.jComboBox1.setFont(new Font("Tahoma", 0, 10));
/* 1095 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "Pendiente de Aceptar", "Recibido", "Rechazado", "Incompleto", "Cancelado" }));
/* 1096 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1098 */             Recepcion.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1102 */     this.jLabel9.setText("Estatus");
/*      */     
/* 1104 */     this.jLabel10.setText("Contenido");
/*      */     
/* 1106 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1108 */             Recepcion.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1112 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 1113 */     this.jComboBox2.setFont(new Font("Tahoma", 0, 10));
/* 1114 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS" }));
/* 1115 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1117 */             Recepcion.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1121 */     this.jLabel21.setFont(new Font("Tahoma", 2, 12));
/* 1122 */     this.jLabel21.setForeground(new Color(15, 87, 51));
/* 1123 */     this.jLabel21.setText("<html><u>Todos </u></html>");
/* 1124 */     this.jLabel21.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1126 */             Recepcion.this.jLabel21MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1129 */             Recepcion.this.jLabel21MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1132 */             Recepcion.this.jLabel21MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1136 */     this.jLabel26.setFont(new Font("Tahoma", 2, 12));
/* 1137 */     this.jLabel26.setForeground(new Color(15, 87, 51));
/* 1138 */     this.jLabel26.setHorizontalAlignment(0);
/* 1139 */     this.jLabel26.setText("<html><u>Hoy</u></html>");
/* 1140 */     this.jLabel26.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1142 */             Recepcion.this.jLabel26MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1145 */             Recepcion.this.jLabel26MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1148 */             Recepcion.this.jLabel26MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1152 */     this.jLabel27.setFont(new Font("Tahoma", 2, 12));
/* 1153 */     this.jLabel27.setForeground(new Color(15, 87, 51));
/* 1154 */     this.jLabel27.setText("<html><u>Ayer</u></html>");
/* 1155 */     this.jLabel27.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1157 */             Recepcion.this.jLabel27MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1160 */             Recepcion.this.jLabel27MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1163 */             Recepcion.this.jLabel27MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1167 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1168 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1169 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1170 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1171 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1172 */           .addContainerGap()
/* 1173 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1174 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1175 */               .addComponent(this.jLabel2, -2, 59, -2)
/* 1176 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1177 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1178 */                 .addComponent((Component)this.jDateChooser12, -2, 108, -2)
/* 1179 */                 .addGroup(jPanel1Layout.createSequentialGroup()
/* 1180 */                   .addGap(112, 112, 112)
/* 1181 */                   .addComponent(this.jLabel3))
/* 1182 */                 .addComponent((Component)this.jDateChooser11, -2, 108, -2)))
/* 1183 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1184 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1185 */                 .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1186 */                   .addComponent(this.jLabel7, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1187 */                   .addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1188 */                   .addComponent(this.jLabel6, GroupLayout.Alignment.LEADING, -2, 50, -2))
/* 1189 */                 .addComponent(this.jLabel10, -2, 59, 32767)
/* 1190 */                 .addComponent(this.jLabel8, -1, 59, 32767)
/* 1191 */                 .addComponent(this.jLabel9, -1, 59, 32767))
/* 1192 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1193 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1194 */                 .addComponent(this.jComboBox2, 0, 126, 32767)
/* 1195 */                 .addComponent(this.jComboBox1, 0, 126, 32767)
/* 1196 */                 .addComponent(this.jTextField4, -1, 126, 32767)
/* 1197 */                 .addComponent(this.jTextField3, -1, 126, 32767)
/* 1198 */                 .addComponent(this.jTextField2, -1, 126, 32767)
/* 1199 */                 .addComponent(this.jTextField1, -1, 126, 32767)
/* 1200 */                 .addGroup(jPanel1Layout.createSequentialGroup()
/* 1201 */                   .addComponent(this.jLabel21, -2, -1, -2)
/* 1202 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1203 */                   .addComponent(this.jLabel26, -2, 31, -2)
/* 1204 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1205 */                   .addComponent(this.jLabel27, -2, 31, -2)))))
/* 1206 */           .addContainerGap()));
/*      */     
/* 1208 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1209 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1210 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1211 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1212 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 1213 */               .addContainerGap()
/* 1214 */               .addComponent(this.jLabel3))
/* 1215 */             .addComponent(this.jLabel2, GroupLayout.Alignment.LEADING)
/* 1216 */             .addComponent((Component)this.jDateChooser11, GroupLayout.Alignment.LEADING, -2, -1, -2))
/* 1217 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1218 */           .addComponent((Component)this.jDateChooser12, -2, -1, -2)
/* 1219 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1220 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1221 */             .addComponent(this.jLabel21, -2, 19, -2)
/* 1222 */             .addComponent(this.jLabel26, -2, 15, -2)
/* 1223 */             .addComponent(this.jLabel27, -2, -1, -2))
/* 1224 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, 32767)
/* 1225 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1226 */             .addComponent(this.jLabel5)
/* 1227 */             .addComponent(this.jTextField1, -2, -1, -2))
/* 1228 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1229 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1230 */             .addComponent(this.jLabel6)
/* 1231 */             .addComponent(this.jTextField2, -2, -1, -2))
/* 1232 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1233 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1234 */             .addComponent(this.jLabel7)
/* 1235 */             .addComponent(this.jTextField3, -2, -1, -2))
/* 1236 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1237 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1238 */             .addComponent(this.jLabel10)
/* 1239 */             .addComponent(this.jTextField4, -2, -1, -2))
/* 1240 */           .addGap(5, 5, 5)
/* 1241 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1242 */             .addComponent(this.jLabel9)
/* 1243 */             .addComponent(this.jComboBox1, -2, -1, -2))
/* 1244 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1245 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1246 */             .addComponent(this.jLabel8)
/* 1247 */             .addComponent(this.jComboBox2, -2, -1, -2))));
/*      */ 
/*      */     
/* 1250 */     this.jButton13.setMnemonic('M');
/* 1251 */     this.jButton13.setText("Modificar");
/* 1252 */     this.jButton13.setToolTipText("Ver (Alt+M)");
/* 1253 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1255 */             Recepcion.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1259 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1260 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1261 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1262 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1263 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 1264 */           .addContainerGap()
/* 1265 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1266 */             .addComponent(this.jSeparator1, -1, 882, 32767)
/* 1267 */             .addComponent(this.jLabel4, -1, 882, 32767)
/* 1268 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 1269 */               .addComponent(this.jPanel1, -2, -1, -2)
/* 1270 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1271 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1272 */                 .addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 653, 32767)
/* 1273 */                 .addGroup(jPanel7Layout.createSequentialGroup()
/* 1274 */                   .addComponent(this.jButton4, -2, 107, -2)
/* 1275 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1276 */                   .addComponent(this.jButton2, -2, 107, -2)
/* 1277 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1278 */                   .addComponent(this.jButton13, -2, 107, -2)
/* 1279 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1280 */                   .addComponent(this.jButton3, -2, 107, -2)
/* 1281 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1282 */                   .addComponent(this.jButton1, -2, 107, -2)))))
/* 1283 */           .addContainerGap()));
/*      */     
/* 1285 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1286 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1287 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 1288 */           .addComponent(this.jLabel4)
/* 1289 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1290 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 1291 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1292 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 1293 */               .addGap(27, 27, 27)
/* 1294 */               .addComponent(this.jScrollPane1, 0, 0, 32767)
/* 1295 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1296 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1297 */                 .addComponent(this.jButton1)
/* 1298 */                 .addComponent(this.jButton3)
/* 1299 */                 .addComponent(this.jButton13)
/* 1300 */                 .addComponent(this.jButton2)
/* 1301 */                 .addComponent(this.jButton4)))
/* 1302 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 1303 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1304 */               .addComponent(this.jPanel1, -1, -1, 32767)))
/* 1305 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1308 */     this.jTextPane1.setBackground(new Color(153, 255, 153));
/* 1309 */     this.jTextPane1.setEditable(false);
/* 1310 */     this.jTextPane1.setFont(new Font("Tahoma", 0, 9));
/* 1311 */     this.jScrollPane2.setViewportView(this.jTextPane1);
/*      */     
/* 1313 */     GroupLayout layout = new GroupLayout(this);
/* 1314 */     setLayout(layout);
/* 1315 */     layout.setHorizontalGroup(layout
/* 1316 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1317 */         .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/* 1318 */           .addContainerGap()
/* 1319 */           .addComponent(this.jPanel7, -1, -1, 32767)
/* 1320 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1321 */           .addComponent(this.jScrollPane2, -1, 264, 32767)
/* 1322 */           .addContainerGap()));
/*      */     
/* 1324 */     layout.setVerticalGroup(layout
/* 1325 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1326 */         .addGroup(layout.createSequentialGroup()
/* 1327 */           .addContainerGap()
/* 1328 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1329 */             .addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING)
/* 1330 */             .addComponent(this.jPanel7, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1331 */           .addContainerGap(41, 32767)));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1336 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 1340 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1344 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1348 */     limpiar();
/* 1349 */     this.jButton7.setText("Guardar");
/* 1350 */     this.jButton7.setToolTipText("Guardar Documento (Alt+G)");
/* 1351 */     this.jButton7.setMnemonic('G');
/* 1352 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTable4MouseClicked(MouseEvent evt) {
/* 1356 */     if (evt.getClickCount() == 2) {
/* 1357 */       agregarDatos();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1362 */     Point p = this.jButton5.getLocationOnScreen();
/* 1363 */     this.jDialog2.setLocation(p.x - 410, p.y + 28);
/* 1364 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel51MouseClicked(MouseEvent evt) {
/* 1368 */     if (this.jTable4.getSelectedRow() < 0) {
/* 1369 */       JOptionPane.showMessageDialog(this.jDialog2, "Necesitas seleccionar un registro para poder agregarlo", "Selecciona un Registro", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1372 */       agregarDatos();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel51MouseEntered(MouseEvent evt) {
/* 1377 */     this.jLabel51.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel51MouseExited(MouseEvent evt) {
/* 1381 */     this.jLabel51.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jLabel54MouseClicked(MouseEvent evt) {
/* 1385 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel54MouseEntered(MouseEvent evt) {
/* 1389 */     this.jLabel54.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel54MouseExited(MouseEvent evt) {
/* 1393 */     this.jLabel54.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jTextField8KeyReleased(KeyEvent evt) {
/* 1397 */     consultarDatos();
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 1401 */     consultarDatos();
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 1405 */     consultarDatos();
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 1409 */     this.error.pasarModal(true);
/* 1410 */     this.val.pasarModal(Boolean.valueOf(true));
/* 1411 */     if (this.jTextArea2.getText().equals("")) {
/* 1412 */       this.error.cargarError(this.jTextArea2, "050");
/*      */     }
/* 1414 */     else if (this.jTextArea2.getText().length() > 9999) {
/* 1415 */       this.jTextArea2.setBackground(Color.RED);
/* 1416 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes agregar más de 9999 caracteres en este campo\nTu información es de " + this.jTextArea2.getText().length(), "Demasiados Caracteres", 0, this.ERROR);
/*      */     }
/* 1418 */     else if (this.jTextArea1.getText().length() > 9999) {
/* 1419 */       this.jTextArea1.setBackground(Color.RED);
/* 1420 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes agregar más de 9999 caracteres en este campo\nTu información es de " + this.jTextArea2.getText().length(), "Demasiados Caracteres", 0, this.ERROR);
/*      */     }
/* 1422 */     else if (this.jDateChooser13.getDate() == null) {
/* 1423 */       JOptionPane.showMessageDialog(this.jDialog1, "No puedes dejar vacía la fecha del documento", "Falta Fecha", 0, this.ERROR);
/*      */     }
/* 1425 */     else if (this.jComboBox4.getSelectedIndex() == 0) {
/* 1426 */       this.jComboBox4.setBackground(Color.RED);
/* 1427 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionas la persona que recibirá el documento", "Selecciona el Destinatario", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1430 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 1431 */       String cadenaFecha1 = formato.format(this.jDateChooser13.getDate());
/* 1432 */       String año = cadenaFecha1.substring(0, 4);
/* 1433 */       String mes = cadenaFecha1.substring(4, 6);
/* 1434 */       String dia = cadenaFecha1.substring(6, 8);
/*      */       
/* 1436 */       int lineas = 0;
/* 1437 */       this.LINEAS1 = 0;
/* 1438 */       this.LINEAS2 = 0;
/* 1439 */       String conte = this.jTextArea2.getText(); int i;
/* 1440 */       for (i = 0; i < conte.length(); i++) {
/* 1441 */         if (conte.charAt(i) == '\n') {
/* 1442 */           lineas++;
/* 1443 */           this.LINEAS1++;
/*      */         } 
/*      */       } 
/* 1446 */       conte = this.jTextArea1.getText();
/* 1447 */       for (i = 0; i < conte.length(); i++) {
/* 1448 */         if (conte.charAt(i) == '\n') {
/* 1449 */           lineas++;
/* 1450 */           this.LINEAS2++;
/*      */         } 
/*      */       } 
/* 1453 */       lineas += 4;
/* 1454 */       this.LINEAS = new String[lineas];
/*      */       
/* 1456 */       for (i = 0; i < this.LINEAS.length; i++) {
/* 1457 */         this.LINEAS[i] = "";
/*      */       }
/* 1459 */       this.LINEAS[0] = "CONTENIDO DEL MENSAJE:";
/* 1460 */       conte = this.jTextArea2.getText();
/* 1461 */       lineas = 1;
/* 1462 */       for (i = 0; i < conte.length(); i++) {
/* 1463 */         if (conte.charAt(i) == '\n') {
/* 1464 */           lineas++;
/*      */         } else {
/*      */           
/* 1467 */           this.LINEAS[lineas] = this.LINEAS[lineas] + this.LINEAS[lineas];
/*      */         } 
/*      */       } 
/* 1470 */       lineas++;
/* 1471 */       this.LINEAS[lineas] = "COMENTARIOS";
/* 1472 */       lineas++;
/* 1473 */       conte = this.jTextArea1.getText();
/* 1474 */       for (i = 0; i < conte.length(); i++) {
/* 1475 */         if (conte.charAt(i) == '\n') {
/* 1476 */           lineas++;
/*      */         } else {
/*      */           
/* 1479 */           this.LINEAS[lineas] = this.LINEAS[lineas] + this.LINEAS[lineas];
/*      */         } 
/*      */       } 
/*      */       
/* 1483 */       if (this.jButton7.getText().equals("Modificar")) {
/* 1484 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas actualizar la información?", "Actualizar Documento", 0, 3, this.PREG);
/* 1485 */         if (res == 0) {
/* 1486 */           String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 1487 */           this.con.inserSinMsj("update recepcion set fecha = " + fechaCompleta + ", usuario_recibe ='" + String.valueOf(this.jComboBox4.getSelectedItem()) + "', documentos ='" + this.jTextArea2.getText() + "', titulo ='" + this.jTextField5.getText() + "', asunto='" + this.jTextField6.getText() + "', comentario='" + this.jTextArea1.getText() + "', estatus='<Pendiente de Aceptar>' where folio='" + this.jTextField7.getText() + "'");
/* 1488 */           this.DATOS = new String[] { this.jTextField7.getText(), dia + "/" + dia + "/" + mes, this.USUARIO.toUpperCase(), String.valueOf(this.jComboBox4.getSelectedItem()), this.jTextField5.getText(), this.jTextField6.getText(), this.jTextArea2.getText(), this.jTextArea1.getText(), "<Pendiente de Aceptar>" };
/*      */           
/* 1490 */           res = JOptionPane.showConfirmDialog(this.jDialog1, "Los datos han sido guardados satisfactoriamente\n¿Deseas imprimir el documento?", "Guardar Documento", 0, 3, this.PREG);
/* 1491 */           if (res == 0) {
/* 1492 */             ImprimirDocumento imprimir = new ImprimirDocumento();
/* 1493 */             imprimir.recibeDatos();
/*      */           } 
/* 1495 */           limpiar();
/* 1496 */           consultar();
/* 1497 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } else {
/*      */         
/* 1501 */         int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas guardar el nuevo documento de recepción?", "Guardar Documento", 0, 3, this.PREG);
/* 1502 */         if (res == 0) {
/* 1503 */           sacarMayor();
/* 1504 */           String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 1505 */           this.con.inserSinMsj("insert into recepcion (folio,fecha,usuario_entrega,usuario_recibe,documentos,titulo,asunto,comentario,estatus) values('" + this.jTextField7
/* 1506 */               .getText() + "'," + fechaCompleta + ",'" + this.USUARIO + "','" + String.valueOf(this.jComboBox4.getSelectedItem()) + "','" + this.jTextArea2.getText() + "','" + this.jTextField5.getText() + "','" + this.jTextField6.getText() + "','" + this.jTextArea1.getText() + "','<Pendiente de Aceptar>')");
/* 1507 */           this.DATOS = new String[] { this.jTextField7.getText(), dia + "/" + dia + "/" + mes, this.USUARIO.toUpperCase(), String.valueOf(this.jComboBox4.getSelectedItem()), this.jTextField5.getText(), this.jTextField6.getText(), this.jTextArea2.getText(), this.jTextArea1.getText(), "<Pendiente de Aceptar>" };
/* 1508 */           res = JOptionPane.showConfirmDialog(this.jDialog1, "Los datos han sido guardados satisfactoriamente\n¿Deseas imprimir el documento?", "Guardar Documento", 0, 3, this.PREG);
/*      */           
/* 1510 */           if (res == 0) {
/* 1511 */             ImprimirDocumento imprimir = new ImprimirDocumento();
/* 1512 */             imprimir.recibeDatos();
/*      */           } 
/* 1514 */           limpiar();
/* 1515 */           consultar();
/* 1516 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable1MouseClicked(MouseEvent evt) {
/* 1523 */     if (evt.getClickCount() == 2) {
/* 1524 */       verRecepcion();
/*      */     }
/* 1526 */     this.jTextPane1.setText("");
/*      */     try {
/* 1528 */       verDocumento();
/* 1529 */     } catch (BadLocationException ex) {
/* 1530 */       Logger.getLogger(Recepcion.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1535 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 1539 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 1543 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 1547 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 1551 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 1555 */     if (this.jTable1.getSelectedRow() < 0) {
/* 1556 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para poder ver los datos", "Selecciona un Registro", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1559 */       verRecepcion();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 1564 */     this.error.pasarModal(true);
/* 1565 */     this.val.pasarModal(Boolean.valueOf(true));
/* 1566 */     String motivo = this.jTextArea5.getText();
/* 1567 */     if (motivo.equals("")) {
/* 1568 */       this.error.cargarError(this.jTextArea5, "050");
/*      */     }
/* 1570 */     int res = JOptionPane.showConfirmDialog(this.jDialog4, "¿Estás seguro que deseas cancelar la el documento?", "Cancelar Documento", 0, 3, this.PREG);
/* 1571 */     if (res == 0) {
/* 1572 */       this.con.inserSinMsj("update recepcion set estatus = '<Cancelado: " + cargarFechaHoy() + " " + this.jTextArea5.getText().toUpperCase() + ">' where folio = '" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)) + "'");
/*      */       
/* 1574 */       consultar();
/* 1575 */       this.jDialog4.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 1580 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1584 */     if (this.jTable1.getSelectedRow() < 0) {
/* 1585 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para poder cancelar la información", "Selecciona un Registro", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1588 */       String usuario = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4));
/* 1589 */       String estatus = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6));
/* 1590 */       if (!this.USUARIO.equals(usuario)) {
/* 1591 */         JOptionPane.showMessageDialog(this.padre, "No puedes cancelar este documento debido a que no eres el usuario que creó esta información", "Otro Creador", 0, this.ERROR);
/*      */       }
/* 1593 */       else if (!estatus.equals("<Pendiente de Aceptar>")) {
/* 1594 */         JOptionPane.showMessageDialog(this.padre, "Sólo puedes cancelar los documentos que tengan estado de '<Pendiente de Aceptar>'", "No se puede Cancelar", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 1597 */         this.jTextArea5.setText("");
/* 1598 */         this.jDialog4.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1608 */     if (this.jTable1.getSelectedRow() < 0) {
/* 1609 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para poder recibir los datos", "Selecciona un Registro", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1612 */       String usuario = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5));
/* 1613 */       String estatus = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6));
/* 1614 */       if (!this.USUARIO.equals(usuario)) {
/* 1615 */         JOptionPane.showMessageDialog(this.padre, "No puedes completar este documento debido a que no eres el usuario que recibirá la información", "No te pertenece", 0, this.ERROR);
/*      */       }
/* 1617 */       else if (!estatus.equals("<Pendiente de Aceptar>")) {
/* 1618 */         JOptionPane.showMessageDialog(this.padre, "Sólo puedes completar los documentos que tengan estado de '<Pendiente de Aceptar>'", "No se puede Cancelar", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 1621 */         this.jComboBox5.setSelectedIndex(0);
/* 1622 */         this.jTextArea3.setText("");
/* 1623 */         this.jDialog5.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 1629 */     int res = JOptionPane.showConfirmDialog(this.jDialog5, "¿Estás seguro que deseas recibir la recepción?", "Recibir Recepción", 0, 3, this.PREG);
/* 1630 */     if (res == 0) {
/* 1631 */       this.con.inserSinMsj("update recepcion set estatus = '<" + String.valueOf(this.jComboBox5.getSelectedItem()) + ": " + cargarFechaHoy() + " " + this.jTextArea3.getText() + ">' where folio = '" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)) + "'");
/*      */       
/* 1633 */       consultar();
/* 1634 */       this.jDialog5.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 1639 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 1643 */     ImprimirDocumento imprimir = new ImprimirDocumento();
/* 1644 */     imprimir.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jLabel21MouseClicked(MouseEvent evt) {
/* 1648 */     this.jDateChooser11.setDate(this.fechaInicio);
/* 1649 */     this.jDateChooser12.setDate(this.fechaActual);
/* 1650 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel21MouseEntered(MouseEvent evt) {
/* 1654 */     this.jLabel21.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel21MouseExited(MouseEvent evt) {
/* 1658 */     this.jLabel21.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel26MouseClicked(MouseEvent evt) {
/* 1662 */     this.jDateChooser11.setDate(this.fechaActual);
/* 1663 */     this.jDateChooser12.setDate(this.fechaActual);
/* 1664 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel26MouseEntered(MouseEvent evt) {
/* 1668 */     this.jLabel26.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel26MouseExited(MouseEvent evt) {
/* 1672 */     this.jLabel26.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel27MouseClicked(MouseEvent evt) {
/* 1676 */     Calendar ca = Calendar.getInstance();
/* 1677 */     Calendar fecha = Calendar.getInstance();
/* 1678 */     int aa = fecha.get(1);
/* 1679 */     int mm = fecha.get(2);
/* 1680 */     int dd = fecha.get(5);
/* 1681 */     if (dd == 1) {
/* 1682 */       if (mm == 0) {
/* 1683 */         mm = 11;
/* 1684 */         aa--;
/*      */       } else {
/* 1686 */         mm--;
/*      */       } 
/* 1688 */       int diasTotal = diasDelMes(mm, aa);
/* 1689 */       dd = diasTotal;
/*      */     } else {
/* 1691 */       dd--;
/*      */     } 
/* 1693 */     mm++;
/* 1694 */     String año = "" + aa;
/* 1695 */     String mes = "" + mm;
/* 1696 */     String dia = "" + dd;
/* 1697 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1698 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 1700 */       this.jDateChooser11.setDate(formatoDelTexto.parse(strFecha));
/* 1701 */       this.jDateChooser12.setDate(formatoDelTexto.parse(strFecha));
/* 1702 */     } catch (ParseException ex) {
/* 1703 */       ex.printStackTrace();
/*      */     } 
/* 1705 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel27MouseEntered(MouseEvent evt) {
/* 1709 */     this.jLabel27.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel27MouseExited(MouseEvent evt) {
/* 1713 */     this.jLabel27.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 1717 */     if (this.jTable1.getSelectedRow() < 0) {
/* 1718 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para poder modificar la información", "Selecciona un registro", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1721 */       String estado = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6));
/* 1722 */       if (!estado.equals("<Pendiente de Aceptar>")) {
/* 1723 */         JOptionPane.showMessageDialog(this.padre, "El documento que deseas modificar no se encuentra en estado <Pendiente de Aceptar>\nConsulta tu información", "No se puede modificar", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 1726 */         String usuario = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4));
/* 1727 */         if (!this.USUARIO.equals(usuario)) {
/* 1728 */           JOptionPane.showMessageDialog(this.padre, "No puedes modificar la información ya que el documento no fue creado por tu usuario", "Otro usuario", 0, this.ERROR);
/*      */         } else {
/*      */           
/* 1731 */           String[] datos = this.con.regresaReg("folio,fecha,usuario_entrega,usuario_recibe,documentos,titulo,asunto,comentario,estatus", "recepcion", "where folio ='" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)) + "'", 9);
/* 1732 */           this.jTextField7.setText(datos[0]);
/* 1733 */           this.jTextField5.setText(datos[5]);
/* 1734 */           this.jTextField6.setText(datos[6]);
/* 1735 */           this.jTextArea2.setText(datos[4]);
/* 1736 */           this.jTextArea1.setText(datos[7]);
/* 1737 */           this.jComboBox4.setSelectedItem(datos[3]);
/*      */           
/* 1739 */           String FECHA = datos[1];
/*      */           
/* 1741 */           String año = FECHA.substring(0, 4);
/* 1742 */           String mes = FECHA.substring(5, 7);
/* 1743 */           String dia = FECHA.substring(8, 10);
/* 1744 */           SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1745 */           String strFecha = año + "-" + año + "-" + mes;
/* 1746 */           Date fecha = null;
/*      */           try {
/* 1748 */             fecha = formatoDelTexto.parse(strFecha);
/*      */           }
/* 1750 */           catch (ParseException ex) {
/* 1751 */             ex.printStackTrace();
/*      */           } 
/* 1753 */           this.jDateChooser13.setDate(fecha);
/*      */           
/* 1755 */           this.jButton7.setText("Modificar");
/* 1756 */           this.jButton7.setToolTipText("Modificar Documento (Alt+M)");
/* 1757 */           this.jButton7.setMnemonic('M');
/* 1758 */           this.jDialog1.setVisible(true);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 1765 */     consultarDatos();
/*      */   }
/*      */   
/*      */   private void jLabel57MouseClicked(MouseEvent evt) {
/* 1769 */     String tabla = String.valueOf(this.jComboBox3.getSelectedItem());
/* 1770 */     for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 1771 */       String folio = String.valueOf(this.jTable4.getValueAt(i, 0));
/* 1772 */       if (tabla.equals("Guía")) {
/* 1773 */         String[] guias = this.con.regresaReg("num_guia,fecha,estado,tipo,servicio", "guias", "where guias.num_guia = '" + folio + "'", 5);
/* 1774 */         this.jTextArea2.setText(this.jTextArea2.getText() + "\n Guía: " + this.jTextArea2.getText() + " con fecha " + guias[0] + " estando " + guias[1] + " tipo " + guias[2] + " y un servicio de " + guias[3]);
/*      */       }
/* 1776 */       else if (tabla.equals("Hojas de Recepción")) {
/* 1777 */         String[] guias = this.con.regresaReg("num_vale,f_expedicion1,peso,rsp,tipo,ope_carga,ope_tira", "vales", "where num_vale = '" + folio + "'", 7);
/* 1778 */         this.jTextArea2.setText(this.jTextArea2.getText() + "\n Ticket: " + this.jTextArea2.getText() + " con fecha " + guias[0] + " teniendo un peso de " + guias[1] + " hoja de recepción " + guias[2] + " tipo " + guias[3] + " cargada por " + guias[4] + " y tirada por " + guias[5]);
/*      */       }
/* 1780 */       else if (tabla.equals("Manifiestos de Aceite")) {
/* 1781 */         String[] guias = this.con.regresaReg("guias.Manifiesto,guias.num_guia,residuo, tipo, num_tracto, num_rem ", "manifiestos_recorteaceite,guias,llamadas_historicas", "where guias.num_guia = llamadas_historicas.num_guia and guias.num_guia = manifiestos_recorteaceite.num_guia and guias.manifiesto = '" + folio + "'", 6);
/* 1782 */         this.jTextArea2.setText(this.jTextArea2.getText() + "\n Manifiesto Aceite: " + this.jTextArea2.getText() + " referente a la guía " + guias[0] + " cargando " + guias[1] + " tipo " + guias[2] + " tractor " + guias[3] + " y remolque " + guias[4]);
/*      */       }
/* 1784 */       else if (tabla.equals("Manifiestos de Agua")) {
/* 1785 */         String[] guias = this.con.regresaReg("guias.Manifiesto,guias.num_guia,residuo, tipo, num_tracto, num_rem ", "manifiestos_lodoagua,guias,llamadas_historicas", "where guias.num_guia = llamadas_historicas.num_guia and guias.num_guia = manifiestos_lodoagua.num_guia and guias.manifiesto = '" + folio + "'", 6);
/* 1786 */         this.jTextArea2.setText(this.jTextArea2.getText() + "\n Manifiesto Agua: " + this.jTextArea2.getText() + " referente a la guía " + guias[0] + " cargando " + guias[1] + " tipo " + guias[2] + " tractor " + guias[3] + " y remolque " + guias[4]);
/*      */       }
/* 1788 */       else if (tabla.equals("Liquidaciones")) {
/* 1789 */         String[] guias = this.con.regresaReg("folio_liq,fecha,totalletra", "liquidaciones", "where folio_liq = '" + folio + "'", 3);
/* 1790 */         this.jTextArea2.setText(this.jTextArea2.getText() + "\n Liquidación: Folio " + this.jTextArea2.getText() + " con fecha " + guias[0] + " y un total de " + guias[1]);
/*      */       }
/* 1792 */       else if (tabla.equals("Prefactura")) {
/* 1793 */         String[] guias = this.con.regresaReg("numfac,ref,fecha,totalTexto,estado", "prefacturaCliente", "where numfac = '" + folio + "'", 5);
/* 1794 */         this.jTextArea2.setText(this.jTextArea2.getText() + "\n Prefactura: Folio " + this.jTextArea2.getText() + " con referencia " + guias[0] + " fecha " + guias[1] + " total de " + guias[2] + " y estatus de " + guias[3]);
/*      */       }
/* 1796 */       else if (tabla.equals("Vale de Diesel")) {
/* 1797 */         String[] guias = this.con.regresaReg("folio,fecha,guias", "vales_diesel", "where folio = '" + folio + "'", 3);
/* 1798 */         this.jTextArea2.setText(this.jTextArea2.getText() + "\n Vale de Diesel: Folio " + this.jTextArea2.getText() + " con fecha " + guias[0] + " amparando las siguientes guías " + guias[1]);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel57MouseEntered(MouseEvent evt) {
/* 1804 */     this.jLabel57.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel57MouseExited(MouseEvent evt) {
/* 1808 */     this.jLabel57.setForeground(Color.RED);
/*      */   }
/*      */   public int diasDelMes(int mes, int año) {
/* 1811 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 1819 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 1825 */         return 30;
/*      */       
/*      */       case 1:
/* 1828 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 1830 */           return 29;
/*      */         }
/* 1832 */         return 28;
/*      */     } 
/*      */     
/* 1835 */     return 0;
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 1839 */     Calendar ahoraCal = Calendar.getInstance();
/* 1840 */     ahoraCal.setTime(this.fecha);
/* 1841 */     String mesesito = "";
/* 1842 */     String hoy = "";
/* 1843 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 1844 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 1846 */     if (ahoraCal.get(2) + 1 < 10) {
/* 1847 */       mesesito = "0" + mesesito;
/*      */     }
/* 1849 */     if (ahoraCal.get(5) < 10) {
/* 1850 */       hoy = "0" + hoy;
/*      */     }
/* 1852 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   public void verRecepcion() {
/* 1855 */     this.jTextPane2.setText("");
/* 1856 */     this.jDialog3.setTitle("Folio de Recepción " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 1857 */     this.DATOS = this.con.regresaReg("folio,fecha,usuario_entrega,usuario_recibe,titulo,asunto,documentos,comentario,estatus", "recepcion", "where folio = '" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)) + "'", 9);
/*      */ 
/*      */     
/* 1860 */     int lineas = 0;
/* 1861 */     this.LINEAS1 = 0;
/* 1862 */     this.LINEAS2 = 0;
/* 1863 */     String conte = this.DATOS[6]; int i;
/* 1864 */     for (i = 0; i < conte.length(); i++) {
/* 1865 */       if (conte.charAt(i) == '\n') {
/* 1866 */         lineas++;
/* 1867 */         this.LINEAS1++;
/*      */       } 
/*      */     } 
/* 1870 */     conte = this.DATOS[7];
/* 1871 */     for (i = 0; i < conte.length(); i++) {
/* 1872 */       if (conte.charAt(i) == '\n') {
/* 1873 */         lineas++;
/* 1874 */         this.LINEAS2++;
/*      */       } 
/*      */     } 
/* 1877 */     lineas += 4;
/* 1878 */     this.LINEAS = new String[lineas];
/*      */     
/* 1880 */     for (i = 0; i < this.LINEAS.length; i++) {
/* 1881 */       this.LINEAS[i] = "";
/*      */     }
/* 1883 */     this.LINEAS[0] = "CONTENIDO DEL MENSAJE:";
/* 1884 */     conte = this.DATOS[6];
/* 1885 */     lineas = 1;
/* 1886 */     for (i = 0; i < conte.length(); i++) {
/* 1887 */       if (conte.charAt(i) == '\n') {
/* 1888 */         lineas++;
/*      */       } else {
/*      */         
/* 1891 */         this.LINEAS[lineas] = this.LINEAS[lineas] + this.LINEAS[lineas];
/*      */       } 
/*      */     } 
/* 1894 */     lineas++;
/* 1895 */     this.LINEAS[lineas] = "COMENTARIOS";
/* 1896 */     lineas++;
/* 1897 */     conte = this.DATOS[7];
/* 1898 */     for (i = 0; i < conte.length(); i++) {
/* 1899 */       if (conte.charAt(i) == '\n') {
/* 1900 */         lineas++;
/*      */       } else {
/*      */         
/* 1903 */         this.LINEAS[lineas] = this.LINEAS[lineas] + this.LINEAS[lineas];
/*      */       } 
/*      */     } 
/*      */     
/* 1907 */     this.jTextField9.setText(this.DATOS[0]);
/* 1908 */     this.jTextField10.setText(this.DATOS[2]);
/* 1909 */     String fechaCorta = this.DATOS[1].substring(0, 10);
/* 1910 */     String FechaNormal = this.DATOS[1].substring(8, 10) + "/" + this.DATOS[1].substring(8, 10) + "/" + this.DATOS[1].substring(5, 7);
/* 1911 */     this.jTextField11.setText(FechaNormal);
/*      */     
/* 1913 */     SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 1914 */     StyleConstants.setBold(attrs, true);
/* 1915 */     StyleConstants.setFontSize(attrs, 11);
/* 1916 */     StyleConstants.setAlignment(attrs, 0);
/*      */     try {
/* 1918 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), this.DATOS[4] + "\n", attrs);
/* 1919 */       attrs = new SimpleAttributeSet();
/* 1920 */       StyleConstants.setAlignment(attrs, 1);
/* 1921 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), this.DATOS[5] + "\n\n\n", attrs);
/* 1922 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), this.DATOS[6] + "\n\n", attrs);
/* 1923 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), this.DATOS[7] + "\n\n\n\n", attrs);
/* 1924 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "Recibe: " + this.DATOS[3] + "\n", attrs);
/* 1925 */       attrs = new SimpleAttributeSet();
/* 1926 */       StyleConstants.setBold(attrs, true);
/* 1927 */       StyleConstants.setFontSize(attrs, 11);
/* 1928 */       StyleConstants.setAlignment(attrs, 0);
/* 1929 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "Estatus: " + this.DATOS[8], attrs);
/*      */     }
/* 1931 */     catch (BadLocationException ex) {
/* 1932 */       Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/* 1934 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   public void limpiar() {
/* 1937 */     this.jTextField5.setText("Titulo del Documento");
/* 1938 */     this.jTextField6.setText("");
/* 1939 */     this.jDateChooser13.setDate(new Date());
/* 1940 */     sacarMayor();
/* 1941 */     this.jTextArea2.setText("");
/* 1942 */     this.jTextArea1.setText("");
/* 1943 */     this.jComboBox4.setSelectedIndex(0);
/*      */   }
/*      */   public void sacarMayor() {
/* 1946 */     this.encontrado = this.con.consultar("num", "recepcion", "");
/* 1947 */     String mayor = "";
/* 1948 */     int MAYOR = 0;
/* 1949 */     if (this.encontrado) {
/* 1950 */       this.con.consultar("max(num)", "recepcion", "");
/* 1951 */       mayor = this.con.Campo;
/* 1952 */       MAYOR = Integer.parseInt(mayor);
/*      */     } else {
/*      */       
/* 1955 */       MAYOR = 0;
/*      */     } 
/* 1957 */     MAYOR++;
/* 1958 */     if (MAYOR < 10) {
/* 1959 */       this.jTextField7.setText(this.DIRECTIVA + "-REC-0000" + this.DIRECTIVA);
/*      */     }
/* 1961 */     if (MAYOR < 100) {
/* 1962 */       this.jTextField7.setText(this.DIRECTIVA + "-REC-000" + this.DIRECTIVA);
/*      */     }
/* 1964 */     else if (MAYOR < 1000) {
/* 1965 */       this.jTextField7.setText(this.DIRECTIVA + "-REC-00" + this.DIRECTIVA);
/*      */     }
/* 1967 */     else if (MAYOR < 10000) {
/* 1968 */       this.jTextField7.setText(this.DIRECTIVA + "-REC-0" + this.DIRECTIVA);
/*      */     } else {
/*      */       
/* 1971 */       this.jTextField7.setText(this.DIRECTIVA + "-REC-" + this.DIRECTIVA);
/*      */     } 
/*      */   }
/*      */   public void verDocumento() throws BadLocationException {
/* 1975 */     String[] datos = this.con.regresaReg("titulo,asunto,documentos,comentario", "recepcion", "where folio = '" + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)) + "'", 4);
/* 1976 */     SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 1977 */     StyleConstants.setBold(attrs, true);
/* 1978 */     StyleConstants.setFontSize(attrs, 10);
/* 1979 */     StyleConstants.setAlignment(attrs, 0);
/*      */     
/* 1981 */     this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), datos[0] + "\n", attrs);
/* 1982 */     attrs = new SimpleAttributeSet();
/* 1983 */     StyleConstants.setAlignment(attrs, 1);
/* 1984 */     this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), datos[1] + "\n\n\n", attrs);
/* 1985 */     this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), datos[2] + "\n\n", attrs);
/* 1986 */     this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), datos[3], attrs);
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
/*      */   public void llenarCombos() {
/* 2011 */     String[] datos = this.con.regresaColIndex("nombre_usu", "usuarios", "where contrasena>'' order by nombre_usu");
/* 2012 */     this.jComboBox4.removeAllItems();
/* 2013 */     this.jComboBox4.addItem("Selecciona uno...");
/* 2014 */     for (int i = 0; i < datos.length; i++) {
/* 2015 */       this.jComboBox4.addItem(datos[i]);
/* 2016 */       this.jComboBox2.addItem(datos[i]);
/*      */     } 
/*      */   }
/*      */   public void agregarDatos() {
/* 2020 */     String tabla = String.valueOf(this.jComboBox3.getSelectedItem());
/* 2021 */     String folio = String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0));
/* 2022 */     if (tabla.equals("Guía")) {
/* 2023 */       String[] guias = this.con.regresaReg("num_guia,fecha,estado,tipo,servicio", "guias", "where guias.num_guia = '" + folio + "'", 5);
/* 2024 */       this.jTextArea2.setText(this.jTextArea2.getText() + "\n Guía: " + this.jTextArea2.getText() + " con fecha " + guias[0] + " estando " + guias[1] + " tipo " + guias[2] + " y un servicio de " + guias[3]);
/*      */     }
/* 2026 */     else if (tabla.equals("Hojas de Recepción")) {
/* 2027 */       String[] guias = this.con.regresaReg("num_vale,f_expedicion1,peso,rsp,tipo,ope_carga,ope_tira", "vales", "where num_vale = '" + folio + "'", 7);
/* 2028 */       this.jTextArea2.setText(this.jTextArea2.getText() + "\n Ticket: " + this.jTextArea2.getText() + " con fecha " + guias[0] + " teniendo un peso de " + guias[1] + " hoja de recepción " + guias[2] + " tipo " + guias[3] + " cargada por " + guias[4] + " y tirada por " + guias[5]);
/*      */     }
/* 2030 */     else if (tabla.equals("Manifiestos de Aceite")) {
/* 2031 */       String[] guias = this.con.regresaReg("guias.Manifiesto,guias.num_guia,residuo, tipo, num_tracto, num_rem ", "manifiestos_recorteaceite,guias,llamadas_historicas", "where guias.num_guia = llamadas_historicas.num_guia and guias.num_guia = manifiestos_recorteaceite.num_guia and guias.manifiesto = '" + folio + "'", 6);
/* 2032 */       this.jTextArea2.setText(this.jTextArea2.getText() + "\n Manifiesto Aceite: " + this.jTextArea2.getText() + " referente a la guía " + guias[0] + " cargando " + guias[1] + " tipo " + guias[2] + " tractor " + guias[3] + " y remolque " + guias[4]);
/*      */     }
/* 2034 */     else if (tabla.equals("Manifiestos de Agua")) {
/* 2035 */       String[] guias = this.con.regresaReg("guias.Manifiesto,guias.num_guia,residuo, tipo, num_tracto, num_rem ", "manifiestos_lodoagua,guias,llamadas_historicas", "where guias.num_guia = llamadas_historicas.num_guia and guias.num_guia = manifiestos_lodoagua.num_guia and guias.manifiesto = '" + folio + "'", 6);
/* 2036 */       this.jTextArea2.setText(this.jTextArea2.getText() + "\n Manifiesto Agua: " + this.jTextArea2.getText() + " referente a la guía " + guias[0] + " cargando " + guias[1] + " tipo " + guias[2] + " tractor " + guias[3] + " y remolque " + guias[4]);
/*      */     }
/* 2038 */     else if (tabla.equals("Liquidaciones")) {
/* 2039 */       String[] guias = this.con.regresaReg("folio_liq,fecha,totalletra", "liquidaciones", "where folio_liq = '" + folio + "'", 3);
/* 2040 */       this.jTextArea2.setText(this.jTextArea2.getText() + "\n Liquidación: Folio " + this.jTextArea2.getText() + " con fecha " + guias[0] + " y un total de " + guias[1]);
/*      */     }
/* 2042 */     else if (tabla.equals("Prefactura")) {
/* 2043 */       String[] guias = this.con.regresaReg("numfac,ref,fecha,totalTexto,estado", "prefacturaCliente", "where numfac = '" + folio + "'", 5);
/* 2044 */       this.jTextArea2.setText(this.jTextArea2.getText() + "\n Prefactura: Folio " + this.jTextArea2.getText() + " con referencia " + guias[0] + " fecha " + guias[1] + " total de " + guias[2] + " y estatus de " + guias[3]);
/*      */     }
/* 2046 */     else if (tabla.equals("Vale de Diesel")) {
/* 2047 */       String[] guias = this.con.regresaReg("folio,fecha,guias", "vales_diesel", "where folio = '" + folio + "'", 3);
/* 2048 */       this.jTextArea2.setText(this.jTextArea2.getText() + "\n Vale de Diesel: Folio " + this.jTextArea2.getText() + " con fecha " + guias[0] + " amparando las siguientes guías " + guias[1]);
/*      */     } 
/*      */   }
/*      */   public void recepcion(String usu) {
/* 2052 */     this.fechaActual = new Date();
/* 2053 */     this.USUARIO = usu;
/* 2054 */     this.panel.setViewportView(this);
/* 2055 */     consultar();
/*      */   }
/*      */   public void colorear() {
/* 2058 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2060 */             Recepcion.this.jTextGanado(Recepcion.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2063 */             Recepcion.this.jTextPerdido(Recepcion.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 2066 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2068 */             Recepcion.this.jTextGanado(Recepcion.this.jTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2071 */             Recepcion.this.jTextPerdido(Recepcion.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 2074 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2076 */             Recepcion.this.jTextGanado(Recepcion.this.jTextField3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2079 */             Recepcion.this.jTextPerdido(Recepcion.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 2082 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2084 */             Recepcion.this.jTextGanado(Recepcion.this.jTextField4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2087 */             Recepcion.this.jTextPerdido(Recepcion.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 2090 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2092 */             Recepcion.this.jTextGanado(Recepcion.this.jTextField5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2095 */             Recepcion.this.jTextPerdido(Recepcion.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 2098 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2100 */             Recepcion.this.jTextGanado(Recepcion.this.jTextField6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2103 */             Recepcion.this.jTextPerdido(Recepcion.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 2106 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2108 */             Recepcion.this.jTextGanado(Recepcion.this.jTextField8, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2111 */             Recepcion.this.jTextPerdido(Recepcion.this.jTextField8, evt);
/*      */           }
/*      */         });
/*      */     
/* 2115 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2117 */             Recepcion.this.jTextGanado(Recepcion.this.jComboBox1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2120 */             Recepcion.this.jTextPerdido(Recepcion.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 2123 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2125 */             Recepcion.this.jTextGanado(Recepcion.this.jComboBox2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2128 */             Recepcion.this.jTextPerdido(Recepcion.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 2131 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2133 */             Recepcion.this.jTextGanado(Recepcion.this.jComboBox3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2136 */             Recepcion.this.jTextPerdido(Recepcion.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 2139 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2141 */             Recepcion.this.jTextGanado(Recepcion.this.jComboBox4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2144 */             Recepcion.this.jTextPerdido(Recepcion.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 2147 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2149 */             Recepcion.this.jTextGanado(Recepcion.this.jComboBox5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2152 */             Recepcion.this.jTextPerdido(Recepcion.this.jComboBox5, evt);
/*      */           }
/*      */         });
/* 2155 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2157 */             Recepcion.this.jTextGanado(Recepcion.this.jComboBox6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2160 */             Recepcion.this.jTextPerdido(Recepcion.this.jComboBox6, evt);
/*      */           }
/*      */         });
/* 2163 */     this.jTextArea1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2165 */             Recepcion.this.jTextGanado(Recepcion.this.jTextArea1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2168 */             Recepcion.this.jTextPerdido(Recepcion.this.jTextArea1, evt);
/*      */           }
/*      */         });
/*      */     
/* 2172 */     this.jTextArea2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2174 */             Recepcion.this.jTextGanado(Recepcion.this.jTextArea2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2177 */             Recepcion.this.jTextPerdido(Recepcion.this.jTextArea2, evt);
/*      */           }
/*      */         });
/* 2180 */     this.jTextArea3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2182 */             Recepcion.this.jTextGanado(Recepcion.this.jTextArea3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2185 */             Recepcion.this.jTextPerdido(Recepcion.this.jTextArea3, evt);
/*      */           }
/*      */         });
/* 2188 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2190 */             Recepcion.this.jTextGanado(Recepcion.this.jTextArea5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 2193 */             Recepcion.this.jTextPerdido(Recepcion.this.jTextArea5, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 2198 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 2201 */     campo.setBackground(Color.white);
/*      */   }
/*      */   public void jPintarTexto(JComponent campo) {
/* 2204 */     campo.setBackground(Color.ORANGE);
/*      */   }
/*      */   public void consultar() {
/* 2207 */     boolean correcto = true;
/* 2208 */     if (this.jDateChooser11.getDate() == null) {
/* 2209 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 2210 */       if (res == 0) {
/* 2211 */         this.jDateChooser11.setDate(this.fechaActual);
/* 2212 */         correcto = true;
/*      */       } else {
/* 2214 */         correcto = false;
/*      */       } 
/* 2216 */     } else if (this.jDateChooser12.getDate() == null) {
/* 2217 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 2218 */       if (res == 0) {
/* 2219 */         this.jDateChooser12.setDate(this.fechaActual);
/* 2220 */         correcto = true;
/*      */       } else {
/* 2222 */         correcto = false;
/*      */       } 
/* 2224 */     } else if (correcto) {
/* 2225 */       Date fecha1 = this.jDateChooser11.getDate();
/* 2226 */       Date fecha2 = this.jDateChooser12.getDate();
/*      */       
/* 2228 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2229 */       String cadenaFecha = "";
/* 2230 */       cadenaFecha = formato.format(fecha1);
/* 2231 */       String AÑO = cadenaFecha.substring(0, 4);
/* 2232 */       String MES = cadenaFecha.substring(4, 6);
/* 2233 */       String DIA = cadenaFecha.substring(6, 8);
/* 2234 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 2236 */       cadenaFecha = formato.format(fecha2);
/* 2237 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 2238 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 2239 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 2240 */       String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59'";
/*      */       
/* 2242 */       String estatus = "";
/* 2243 */       String usuario = "";
/* 2244 */       if (this.jComboBox1.getSelectedIndex() != 0) {
/* 2245 */         estatus = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */       }
/* 2247 */       if (this.jComboBox2.getSelectedIndex() != 0) {
/* 2248 */         usuario = String.valueOf(this.jComboBox2.getSelectedItem());
/*      */       }
/*      */ 
/*      */       
/* 2252 */       this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 2253 */             .buscarDatos(7, "Folio,fecha,titulo,asunto,usuario_entrega,usuario_recibe,estatus", "recepcion", "where folio like '%" + this.jTextField1.getText() + "%' and titulo like '%" + this.jTextField2.getText() + "%' and asunto like '%" + this.jTextField3.getText() + "%' and documentos like '%" + this.jTextField4.getText() + "%' and estatus like '%<" + estatus + "%' and usuario_entrega like '%" + usuario + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by num desc"), (Object[])new String[] { "Folio", "Fecha", "Titulo", "Asunto", "Entrega", "Recibe", "Estatus" })
/*      */           {
/*      */ 
/*      */             
/* 2257 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2261 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/*      */ 
/*      */ 
/*      */       
/* 2267 */       this.celda.pasarInd(this.con.revisarCol(this.jTable1, "<Pendiente de Aceptar", 0, 6, 2));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2272 */       this.celda.pasarInd3(this.con.revisarCol(this.jTable1, "<Incompleto", 0, 6, 2));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2277 */       this.celda.pasarInd4(this.con.revisarCol(this.jTable1, "<Rechazado", 0, 6, 2));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2282 */       this.celda.pasarInd5(this.con.revisarCol(this.jTable1, "<Cancelado", 0, 6, 2));
/*      */       
/* 2284 */       this.jTable1.setSelectionMode(0);
/* 2285 */       this.jTable1.setAutoCreateRowSorter(true);
/* 2286 */       this.jTable1.getTableHeader().setReorderingAllowed(false);
/* 2287 */       this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 2288 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
/* 2289 */       this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
/* 2290 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(70);
/* 2291 */       this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
/* 2292 */       this.jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
/* 2293 */       this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
/* 2294 */       this.jTable1.getColumnModel().getColumn(5).setMaxWidth(70);
/*      */       
/* 2296 */       this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 2297 */       this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 2298 */       this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 2299 */       this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2300 */       this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2301 */       this.jTable1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 2302 */       this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/*      */     } 
/*      */   }
/*      */   public void consultarDatos() {
/* 2306 */     String tabla = String.valueOf(this.jComboBox3.getSelectedItem());
/* 2307 */     boolean correcto = true;
/* 2308 */     if (this.jDateChooser14.getDate() == null) {
/* 2309 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 2310 */       if (res == 0) {
/* 2311 */         this.jDateChooser14.setDate(this.fechaActual);
/* 2312 */         correcto = true;
/*      */       } else {
/* 2314 */         correcto = false;
/*      */       } 
/* 2316 */     } else if (this.jDateChooser15.getDate() == null) {
/* 2317 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 2318 */       if (res == 0) {
/* 2319 */         this.jDateChooser15.setDate(this.fechaActual);
/* 2320 */         correcto = true;
/*      */       } else {
/* 2322 */         correcto = false;
/*      */       } 
/* 2324 */     } else if (correcto) {
/* 2325 */       Date fecha1 = this.jDateChooser14.getDate();
/* 2326 */       Date fecha2 = this.jDateChooser15.getDate();
/*      */       
/* 2328 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2329 */       String cadenaFecha = "";
/* 2330 */       cadenaFecha = formato.format(fecha1);
/* 2331 */       String AÑO = cadenaFecha.substring(0, 4);
/* 2332 */       String MES = cadenaFecha.substring(4, 6);
/* 2333 */       String DIA = cadenaFecha.substring(6, 8);
/* 2334 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 2336 */       cadenaFecha = formato.format(fecha2);
/* 2337 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 2338 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 2339 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 2340 */       String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59'";
/*      */       
/* 2342 */       this.jLabel28.setEnabled(false);
/* 2343 */       this.jComboBox6.setEnabled(false);
/* 2344 */       if (tabla.equals("Guía")) {
/*      */         
/* 2346 */         this.jLabel28.setEnabled(true);
/* 2347 */         this.jComboBox6.setEnabled(true);
/*      */         
/* 2349 */         String servicio = "";
/*      */         
/* 2351 */         if (this.jComboBox6.getSelectedIndex() != 0) {
/* 2352 */           servicio = String.valueOf(this.jComboBox6.getSelectedItem());
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 2357 */         this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 2358 */               .buscarDatos(4, "guias.num_guia,guias.fecha,servicio,nombre_corto", "guias,llamadas_historicas,emp_generadora", "where guias.num_guia = llamadas_historicas.num_guia and llamadas_historicas.clave_gene = emp_generadora.clave_gene and guias.num_guia like '%" + this.jTextField8.getText() + "%' and servicio like '%" + servicio + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by guias.num_guia desc"), (Object[])new String[] { "Folio", "Fecha", "Servicio", "Cliente" })
/*      */             {
/*      */ 
/*      */               
/* 2362 */               boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2366 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 2369 */         this.jTable4.setSelectionMode(0);
/* 2370 */         this.jTable4.setAutoCreateRowSorter(true);
/* 2371 */         this.jTable4.getTableHeader().setReorderingAllowed(false);
/* 2372 */         this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(65);
/* 2373 */         this.jTable4.getColumnModel().getColumn(0).setMaxWidth(65);
/*      */       }
/* 2375 */       else if (tabla.equals("Hojas de Recepción")) {
/*      */ 
/*      */         
/* 2378 */         this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 2379 */               .buscarDatos(4, "num_vale,f_expedicion1,ope_carga,tipo", "vales", "where num_vale like '%" + this.jTextField8.getText() + "%' and f_expedicion1 between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by num_vale desc"), (Object[])new String[] { "Folio", "Fecha", "Operador", "Tipo" })
/*      */             {
/*      */ 
/*      */               
/* 2383 */               boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2387 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 2390 */         this.jTable4.setSelectionMode(0);
/* 2391 */         this.jTable4.setAutoCreateRowSorter(true);
/* 2392 */         this.jTable4.getTableHeader().setReorderingAllowed(false);
/* 2393 */         this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(65);
/* 2394 */         this.jTable4.getColumnModel().getColumn(0).setMaxWidth(65);
/*      */       }
/* 2396 */       else if (tabla.equals("Manifiestos de Aceite")) {
/*      */ 
/*      */         
/* 2399 */         this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 2400 */               .buscarDatos(4, "guias.manifiesto,guias.fecha,guias.num_guia,tipo", "guias,manifiestos_recorteaceite", "where guias.num_guia = manifiestos_recorteaceite.num_guia and guias.manifiesto like '%" + this.jTextField8.getText() + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by guias.manifiesto desc"), (Object[])new String[] { "Folio", "Fecha", "Guia", "Tipo" })
/*      */             {
/*      */ 
/*      */               
/* 2404 */               boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2408 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 2411 */         this.jTable4.setSelectionMode(0);
/* 2412 */         this.jTable4.setAutoCreateRowSorter(true);
/* 2413 */         this.jTable4.getTableHeader().setReorderingAllowed(false);
/* 2414 */         this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(75);
/* 2415 */         this.jTable4.getColumnModel().getColumn(0).setMaxWidth(75);
/*      */       }
/* 2417 */       else if (tabla.equals("Manifiestos de Agua")) {
/*      */ 
/*      */         
/* 2420 */         this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 2421 */               .buscarDatos(4, "guias.manifiesto,guias.fecha,guias.num_guia,tipo", "guias,manifiestos_lodoagua", "where guias.num_guia = manifiestos_lodoagua.num_guia and guias.manifiesto like '%" + this.jTextField8.getText() + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by guias.manifiesto desc"), (Object[])new String[] { "Folio", "Fecha", "Guia", "Tipo" })
/*      */             {
/*      */ 
/*      */               
/* 2425 */               boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2429 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 2432 */         this.jTable4.setSelectionMode(0);
/* 2433 */         this.jTable4.setAutoCreateRowSorter(true);
/* 2434 */         this.jTable4.getTableHeader().setReorderingAllowed(false);
/* 2435 */         this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(75);
/* 2436 */         this.jTable4.getColumnModel().getColumn(0).setMaxWidth(75);
/*      */       }
/* 2438 */       else if (tabla.equals("Liquidaciones")) {
/*      */ 
/*      */         
/* 2441 */         this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 2442 */               .buscarDatos(4, "folio_liq,fecha,totalLetra,usuario", "liquidaciones", "where folio_liq like '%" + this.jTextField8.getText() + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by folio_liq desc"), (Object[])new String[] { "Folio", "Fecha", "Total", "Autorizó" })
/*      */             {
/*      */ 
/*      */               
/* 2446 */               boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2450 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 2453 */         this.jTable4.setSelectionMode(0);
/* 2454 */         this.jTable4.setAutoCreateRowSorter(true);
/* 2455 */         this.jTable4.getTableHeader().setReorderingAllowed(false);
/* 2456 */         this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(75);
/* 2457 */         this.jTable4.getColumnModel().getColumn(0).setMaxWidth(75);
/* 2458 */         this.jTable4.getColumnModel().getColumn(2).setPreferredWidth(75);
/* 2459 */         this.jTable4.getColumnModel().getColumn(2).setMaxWidth(75);
/*      */       }
/* 2461 */       else if (tabla.equals("Prefactura")) {
/*      */ 
/*      */         
/* 2464 */         this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 2465 */               .buscarDatos(5, "numfac,ref,fecha,totalTexto,usuario", "PrefacturaCliente", "where ref like '%" + this.jTextField8.getText() + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by fecha desc"), (Object[])new String[] { "Núm", "Folio", "Fecha", "Total", "Autorizó" })
/*      */             {
/*      */ 
/*      */               
/* 2469 */               boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2473 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 2476 */         this.jTable4.setSelectionMode(0);
/* 2477 */         this.jTable4.setAutoCreateRowSorter(true);
/* 2478 */         this.jTable4.getTableHeader().setReorderingAllowed(false);
/* 2479 */         this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 2480 */         this.jTable4.getColumnModel().getColumn(0).setMaxWidth(40);
/* 2481 */         this.jTable4.getColumnModel().getColumn(1).setPreferredWidth(75);
/* 2482 */         this.jTable4.getColumnModel().getColumn(1).setMaxWidth(75);
/*      */       }
/* 2484 */       else if (tabla.equals("Vale de Diesel")) {
/*      */ 
/*      */         
/* 2487 */         this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 2488 */               .buscarDatos(4, "folio,fecha,eco,documento", "vales_diesel", "where folio like '%" + this.jTextField8.getText() + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by folio desc"), (Object[])new String[] { "Folio", "Fecha", "Eco", "Autorizó" })
/*      */             {
/*      */ 
/*      */               
/* 2492 */               boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2496 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 2499 */         this.jTable4.setSelectionMode(0);
/* 2500 */         this.jTable4.setAutoCreateRowSorter(true);
/* 2501 */         this.jTable4.getTableHeader().setReorderingAllowed(false);
/* 2502 */         this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(75);
/* 2503 */         this.jTable4.getColumnModel().getColumn(0).setMaxWidth(75);
/* 2504 */         this.jTable4.getColumnModel().getColumn(2).setPreferredWidth(35);
/* 2505 */         this.jTable4.getColumnModel().getColumn(2).setMaxWidth(35);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public String[] regresaLineas() {
/* 2510 */     String todos = this.DATOS[6] + " " + this.DATOS[6] + " " + this.DATOS[7];
/* 2511 */     String[] LINEAS = new String[todos.length() / 155 + 8];
/* 2512 */     String linea = "";
/* 2513 */     int cont = 1; int i;
/* 2514 */     for (i = 0; i < LINEAS.length; i++) {
/* 2515 */       LINEAS[i] = "";
/*      */     }
/* 2517 */     LINEAS[0] = "CONTENIDO DEL MENSAJE: ";
/* 2518 */     for (i = 0; i < this.DATOS[6].length(); i++) {
/* 2519 */       LINEAS[cont] = LINEAS[cont] + LINEAS[cont];
/* 2520 */       if (LINEAS[cont].length() == 155) {
/* 2521 */         cont++;
/*      */       }
/*      */     } 
/* 2524 */     cont++;
/* 2525 */     cont++;
/* 2526 */     LINEAS[cont] = "COMENTARIOS: ";
/* 2527 */     cont++;
/* 2528 */     for (i = 0; i < this.DATOS[7].length(); i++) {
/* 2529 */       LINEAS[cont] = LINEAS[cont] + LINEAS[cont];
/* 2530 */       if (LINEAS[cont].length() == 155) {
/* 2531 */         cont++;
/*      */       }
/*      */     } 
/* 2534 */     cont++;
/* 2535 */     cont++;
/*      */     
/* 2537 */     LINEAS[cont] = "ESTATUS: ";
/* 2538 */     cont++;
/* 2539 */     for (i = 0; i < this.DATOS[8].length(); i++) {
/* 2540 */       LINEAS[cont] = LINEAS[cont] + LINEAS[cont];
/* 2541 */       if (LINEAS[cont].length() == 155) {
/* 2542 */         cont++;
/*      */       }
/*      */     } 
/* 2545 */     cont++;
/* 2546 */     return LINEAS;
/*      */   }
/*      */   
/*      */   public String[] convierteLineas() {
/* 2550 */     String[] datos = null;
/* 2551 */     int lineas = 0; int i;
/* 2552 */     for (i = 0; i < this.LINEAS.length; i++) {
/* 2553 */       String l = this.LINEAS[i];
/* 2554 */       lineas = lineas + l.length() / 150 + 1;
/*      */     } 
/* 2556 */     lineas += 3;
/* 2557 */     datos = new String[lineas];
/* 2558 */     for (i = 0; i < datos.length; i++) {
/* 2559 */       datos[i] = "";
/*      */     }
/*      */     
/* 2562 */     lineas = 0;
/*      */     
/* 2564 */     for (i = 0; i < this.LINEAS.length; i++) {
/* 2565 */       String l = this.LINEAS[i];
/* 2566 */       int valor = 0;
/* 2567 */       for (int j = 0; j < l.length(); j++) {
/* 2568 */         if (valor < 150) {
/* 2569 */           datos[lineas] = datos[lineas] + datos[lineas];
/* 2570 */           valor++;
/*      */         } else {
/*      */           
/* 2573 */           datos[lineas] = datos[lineas] + datos[lineas];
/* 2574 */           valor = 0;
/* 2575 */           lineas++;
/*      */         } 
/*      */       } 
/* 2578 */       lineas++;
/*      */     } 
/*      */     
/* 2581 */     lineas++;
/* 2582 */     datos[lineas] = "ESTATUS";
/* 2583 */     for (i = 0; i < this.DATOS[8].length(); i++) {
/* 2584 */       datos[lineas] = datos[lineas] + datos[lineas];
/* 2585 */       if (datos[lineas].length() == 155) {
/* 2586 */         lineas++;
/*      */       }
/*      */     } 
/* 2589 */     lineas++;
/*      */     
/* 2591 */     for (i = 0; i < datos.length; i++) {
/* 2592 */       System.out.println("dat " + i + " " + datos[i]);
/*      */     }
/*      */     
/* 2595 */     return datos;
/*      */   }
/*      */   
/*      */   public class CeldaRender extends DefaultTableCellRenderer {
/* 2599 */     int otro = -1;
/* 2600 */     String[] indices = new String[0];
/* 2601 */     String[] indices2 = new String[0];
/* 2602 */     String[] indices3 = new String[0];
/* 2603 */     String[] indices4 = new String[0];
/* 2604 */     String[] indices5 = new String[0];
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2606 */       setEnabled((table == null || table.isEnabled()));
/* 2607 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 2608 */       if (comparar(comp)) {
/* 2609 */         setBackground(new Color(102, 153, 255));
/* 2610 */         setForeground(Color.BLUE);
/*      */       }
/* 2612 */       else if (comparar2(comp)) {
/* 2613 */         setBackground(new Color(102, 153, 255));
/* 2614 */         setForeground(Color.BLUE);
/*      */       }
/* 2616 */       else if (comparar3(comp)) {
/* 2617 */         setBackground(new Color(153, 153, 153));
/* 2618 */         setForeground(Color.BLACK);
/*      */       }
/* 2620 */       else if (comparar4(comp)) {
/* 2621 */         setBackground(Color.LIGHT_GRAY);
/* 2622 */         setForeground(Color.RED);
/*      */       }
/* 2624 */       else if (comparar5(comp)) {
/* 2625 */         setBackground(Color.RED);
/* 2626 */         setForeground(Color.WHITE);
/*      */       } else {
/*      */         
/* 2629 */         setBackground((Color)null);
/* 2630 */         setForeground(Color.black);
/*      */       } 
/* 2632 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2633 */       return this;
/*      */     }
/*      */     public void pasarInd(String[] ind) {
/* 2636 */       this.indices = ind;
/*      */     }
/*      */     public void pasarInd2(String[] ind) {
/* 2639 */       this.indices2 = ind;
/*      */     }
/*      */     public void pasarInd3(String[] ind) {
/* 2642 */       this.indices3 = ind;
/*      */     }
/*      */     public void pasarInd4(String[] ind) {
/* 2645 */       this.indices4 = ind;
/*      */     }
/*      */     public void pasarInd5(String[] ind) {
/* 2648 */       this.indices5 = ind;
/*      */     }
/*      */     public boolean comparar(String reg) {
/* 2651 */       for (int i = 0; i < this.indices.length; i++) {
/* 2652 */         if (this.indices[i].equals(reg)) {
/* 2653 */           return true;
/*      */         }
/*      */       } 
/* 2656 */       return false;
/*      */     }
/*      */     public boolean comparar2(String reg) {
/* 2659 */       for (int i = 0; i < this.indices2.length; i++) {
/* 2660 */         if (this.indices2[i].equals(reg)) {
/* 2661 */           return true;
/*      */         }
/*      */       } 
/* 2664 */       return false;
/*      */     }
/*      */     public boolean comparar3(String reg) {
/* 2667 */       for (int i = 0; i < this.indices3.length; i++) {
/* 2668 */         if (this.indices3[i].equals(reg)) {
/* 2669 */           return true;
/*      */         }
/*      */       } 
/* 2672 */       return false;
/*      */     }
/*      */     public boolean comparar4(String reg) {
/* 2675 */       for (int i = 0; i < this.indices4.length; i++) {
/* 2676 */         if (this.indices4[i].equals(reg)) {
/* 2677 */           return true;
/*      */         }
/*      */       } 
/* 2680 */       return false;
/*      */     }
/*      */     public boolean comparar5(String reg) {
/* 2683 */       for (int i = 0; i < this.indices5.length; i++) {
/* 2684 */         if (this.indices5[i].equals(reg)) {
/* 2685 */           return true;
/*      */         }
/*      */       } 
/* 2688 */       return false;
/*      */     } }
/*      */   public class ImprimirDocumento implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[] Lineas; int linesPerPage; int orientacion; double X; double Y;
/*      */     int YINICIA;
/*      */     int[] PXCOL;
/*      */     
/*      */     public ImprimirDocumento() {
/* 2695 */       this.g2 = null;
/* 2696 */       this.Pag = 0;
/*      */       
/* 2698 */       this.linesPerPage = 50;
/* 2699 */       this.orientacion = 0;
/* 2700 */       this.X = 0.0D;
/* 2701 */       this.Y = 0.0D;
/* 2702 */       this.YINICIA = 95;
/* 2703 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/*      */     } private void initTextLines() {
/* 2705 */       if (this.textLines == null) {
/* 2706 */         this.Lineas = Recepcion.this.convierteLineas();
/* 2707 */         int numLines = this.Lineas.length;
/* 2708 */         this.textLines = new String[numLines];
/* 2709 */         for (int i = 0; i < numLines; i++)
/* 2710 */           this.textLines[i] = this.Lineas[i]; 
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 2715 */       Font font = new Font("Serif", 0, 8);
/* 2716 */       FontMetrics metrics = g.getFontMetrics(font);
/* 2717 */       int lineHeight = metrics.getHeight();
/* 2718 */       if (this.pageBreaks == null) {
/* 2719 */         initTextLines();
/* 2720 */         this.orientacion = pf.getOrientation();
/* 2721 */         if (pf.getOrientation() == 1) {
/* 2722 */           this.linesPerPage = 55;
/* 2723 */           this.X = pf.getWidth();
/* 2724 */           this.Y = pf.getHeight();
/*      */         } else {
/*      */           
/* 2727 */           this.linesPerPage = 38;
/* 2728 */           this.X = pf.getWidth();
/* 2729 */           this.Y = pf.getHeight();
/*      */         } 
/* 2731 */         int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 2732 */         this.Pag = numBreaks;
/* 2733 */         this.pageBreaks = new int[numBreaks];
/* 2734 */         for (int b = 0; b < numBreaks; b++) {
/* 2735 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 2738 */       if (pageIndex > this.pageBreaks.length) {
/* 2739 */         return 1;
/*      */       }
/* 2741 */       Graphics2D g2d = (Graphics2D)g;
/*      */       
/* 2743 */       this.g2 = g;
/* 2744 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 2745 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 2746 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 2747 */       encabezado();
/* 2748 */       int y = this.YINICIA + 5;
/* 2749 */       int lineas = 0;
/*      */       
/* 2751 */       Font fuente = new Font("Dialog", 0, 7);
/* 2752 */       this.g2.setFont(fuente);
/* 2753 */       for (int line = start; line < end; line++) {
/* 2754 */         y += 9;
/* 2755 */         int Xempe = 35;
/* 2756 */         String valor = "";
/* 2757 */         if (line < 9) {
/* 2758 */           valor = "0" + line + 1;
/*      */         } else {
/*      */           
/* 2761 */           valor = "" + line + 1;
/*      */         } 
/* 2763 */         g.drawString(this.Lineas[line], 23, y);
/* 2764 */         y += 2;
/* 2765 */         lineas = y;
/*      */       } 
/* 2767 */       g.drawString("Página " + pageIndex + 1, 560, 740);
/* 2768 */       fuente = new Font("Dialog", 1, 9);
/* 2769 */       g.setFont(fuente);
/* 2770 */       this.g2.setColor(Color.WHITE);
/* 2771 */       this.g2.fillRect((int)this.X - 46, 0, (int)this.X - 46, lineas);
/* 2772 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 2776 */       Font fuente = new Font("Dialog", 0, 8);
/* 2777 */       this.g2.setFont(fuente);
/* 2778 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 2779 */       Image img = imagen.getImage();
/* 2780 */       this.g2.drawImage(img, 16, 9, 68, 68, null);
/* 2781 */       fuente = new Font("Times New Roman", 1, 18);
/* 2782 */       this.g2.setFont(fuente);
/* 2783 */       this.g2.drawString("GRUPO FORSIS - " + Recepcion.this.base, 190, 20);
/* 2784 */       fuente = new Font("Dialog", 0, 11);
/* 2785 */       this.g2.setFont(fuente);
/* 2786 */       this.g2.drawString("REPORTE DE RECEPCIÓN DE DOCUMENTOS", 196, 36);
/*      */       
/* 2788 */       fuente = new Font("Dialog", 1, 8);
/* 2789 */       this.g2.setFont(fuente);
/* 2790 */       this.g2.drawString("Titulo: " + Recepcion.this.DATOS[4], 90, 54);
/* 2791 */       this.g2.drawString("Asunto:  " + Recepcion.this.DATOS[5], 90, 66);
/*      */       
/* 2793 */       fuente = new Font("Dialog", 1, 10);
/* 2794 */       this.g2.setFont(fuente);
/* 2795 */       this.g2.drawString("FOLIO:  " + Recepcion.this.DATOS[0], 90, 82);
/*      */       
/* 2797 */       fuente = new Font("Dialog", 0, 7);
/* 2798 */       this.g2.setFont(fuente);
/* 2799 */       String[] usu = Recepcion.this.con.regresaReg("nombre,ap_pat,ap_mat", "usuarios,empleados", "where num_emp = clave_emp and nombre_usu = '" + Recepcion.this.DATOS[2] + "'", 3);
/* 2800 */       this.g2.drawString("Creado por: " + usu[1] + " " + usu[2] + " " + usu[0], 380, 54);
/* 2801 */       this.g2.drawString("Fecha: " + Recepcion.this.DATOS[1], 505, 17);
/* 2802 */       usu = Recepcion.this.con.regresaReg("nombre,ap_pat,ap_mat", "usuarios,empleados", "where num_emp = clave_emp and nombre_usu = '" + Recepcion.this.DATOS[3] + "'", 3);
/* 2803 */       this.g2.drawString("Entregar a:  " + usu[1] + " " + usu[2] + " " + usu[0], 380, 66);
/*      */       
/* 2805 */       this.g2.setColor(new Color(204, 0, 0));
/* 2806 */       this.g2.fillRect(18, this.YINICIA - 8, 750, 10);
/*      */       
/* 2808 */       this.g2.setColor(Color.WHITE);
/* 2809 */       fuente = new Font("Dialog", 0, 8);
/* 2810 */       this.g2.setFont(fuente);
/*      */       
/* 2812 */       this.g2.drawString("Este es el contenido del documento", 230, this.YINICIA);
/*      */       
/* 2814 */       this.g2.setColor(Color.BLACK);
/* 2815 */       fuente = new Font("Dialog", 0, 7);
/* 2816 */       this.g2.setFont(fuente);
/*      */     }
/*      */     public void recibeDatos() {
/* 2819 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 2820 */       job.setPrintable(this);
/*      */       
/* 2822 */       PageFormat pf = job.defaultPage();
/* 2823 */       Paper papel = pf.getPaper();
/* 2824 */       papel.setSize(612.0D, 792.0D);
/* 2825 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 2826 */       pf.setPaper(papel);
/* 2827 */       pf.setOrientation(1);
/* 2828 */       job.setPrintable(new ImprimirDocumento(), pf);
/* 2829 */       job.defaultPage(pf);
/*      */       
/* 2831 */       boolean ok = job.printDialog();
/* 2832 */       if (ok)
/*      */         try {
/* 2834 */           job.print();
/*      */         }
/* 2836 */         catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Recepcion.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */