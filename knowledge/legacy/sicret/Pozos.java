/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ 
/*      */ public class Pozos extends JPanel {
/*   24 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   25 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   26 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   27 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   28 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   29 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   33 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   34 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   35 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   36 */   Date fechaActual = new Date();
/*   37 */   private MaskFormatter formaTel = null; private MaskFormatter formaTel2 = null;
/*   38 */   String USUARIO = "";
/*   39 */   Validaciones val = new Validaciones();
/*   40 */   Consultas con = new Consultas();
/*   41 */   Errores error = new Errores(false);
/*      */   String id;
/*      */   String[] inf;
/*      */   JTabbedPane fichas;
/*      */   int INDICE;
/*      */   JTable jTable3;
/*      */   JFrame padre;
/*   48 */   cargarDatos datos = new cargarDatos("Equipos"); Color fondo; boolean encontrado = false; private JButton jButton1; private JButton jButton11; private JButton jButton12; private JButton jButton2; private JButton jButton29; private JButton jButton3; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9;
/*      */   private JComboBox jComboBox1;
/*      */   private JComboBox jComboBox2;
/*   51 */   CeldaRender celda = new CeldaRender(); private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JLabel jLabel1; private JLabel jLabel20; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37;
/*      */   public Pozos(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre) {
/*   53 */     initComponents();
/*   54 */     this.USUARIO = usua;
/*   55 */     this.padre = padre;
/*   56 */     this.id = num;
/*   57 */     this.fichas = fichas;
/*   58 */     initComponents();
/*   59 */     panelito.setViewportView(this);
/*   60 */     this.panel = panelito;
/*   61 */     colorear();
/*   62 */     llenarCombo();
/*      */     
/*   64 */     int w = this.tama.width;
/*   65 */     int h = this.tama.height;
/*   66 */     int rw = (w - 425) / 2;
/*   67 */     int rh = (h - 380) / 2;
/*   68 */     this.jDialog1.setVisible(false);
/*   69 */     this.jDialog1.setLocation(rw, rh);
/*   70 */     this.jDialog1.setSize(330, 180);
/*   71 */     this.jDialog1.setResizable(false);
/*   72 */     consultar();
/*      */     
/*   74 */     rw = (w - 300) / 2;
/*   75 */     rh = (h - 135) / 2;
/*   76 */     this.jDialog2.setLocation(rw, rh);
/*   77 */     this.jDialog2.setSize(300, 135);
/*   78 */     this.jDialog2.setVisible(false);
/*   79 */     this.jDialog2.setResizable(false);
/*      */     
/*   81 */     rw = (w - 430) / 2;
/*   82 */     rh = (h - 395) / 2;
/*   83 */     this.jDialog3.setLocation(rw, rh);
/*   84 */     this.jDialog3.setSize(430, 395);
/*   85 */     this.jDialog3.setVisible(false);
/*   86 */     this.jDialog3.setResizable(false);
/*      */   }
/*      */   private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel48; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel8; private JPanel jPanel2; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel24; private JPanel jPanel3; private JPanel jPanel6; private JPanel jPanel8; private JScrollPane jScrollPane1; private JScrollPane jScrollPane6; private JSeparator jSeparator1; private JSeparator jSeparator10; private JSeparator jSeparator2; private JSeparator jSeparator3; private JTable jTable1; private JTable jTable5; private JTextField jTextField1; private JTextField jTextField14; private JTextField jTextField2; private JTextField jTextField28; private JTextField jTextField3;
/*      */   private JTextField jTextField4;
/*      */   
/*      */   private void initComponents() {
/*   92 */     this.jDialog1 = new CerrarVentana(this.padre);
/*   93 */     this.jPanel2 = new JPanel();
/*   94 */     this.jLabel38 = new JLabel();
/*   95 */     this.jComboBox5 = new JComboBox();
/*   96 */     this.jLabel39 = new JLabel();
/*   97 */     this.jTextField3 = new JTextField();
/*   98 */     this.jSeparator2 = new JSeparator();
/*   99 */     this.jLabel8 = new JLabel();
/*  100 */     this.jButton3 = new JButton();
/*  101 */     this.jButton4 = new JButton();
/*  102 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  103 */     this.jPanel8 = new JPanel();
/*  104 */     this.jLabel62 = new JLabel();
/*  105 */     this.jSeparator3 = new JSeparator();
/*  106 */     this.jLabel63 = new JLabel();
/*  107 */     this.jTextField14 = new JTextField();
/*  108 */     this.jButton11 = new JButton();
/*  109 */     this.jButton12 = new JButton();
/*  110 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  111 */     this.jPanel3 = new JPanel();
/*  112 */     this.jLabel20 = new JLabel();
/*  113 */     this.jSeparator10 = new JSeparator();
/*  114 */     this.jPanel24 = new JPanel();
/*  115 */     this.jScrollPane6 = new JScrollPane();
/*  116 */     this.jTable5 = new JTable();
/*  117 */     this.jLabel41 = new JLabel();
/*  118 */     this.jTextField28 = new JTextField();
/*  119 */     this.jButton9 = new JButton();
/*  120 */     this.jButton29 = new JButton();
/*  121 */     this.jPanel6 = new JPanel();
/*  122 */     this.jLabel1 = new JLabel();
/*  123 */     this.jPanel21 = new JPanel();
/*  124 */     this.jTextField1 = new JTextField();
/*  125 */     this.jLabel32 = new JLabel();
/*  126 */     this.jButton6 = new JButton();
/*  127 */     this.jLabel34 = new JLabel();
/*  128 */     this.jComboBox1 = new JComboBox();
/*  129 */     this.jLabel35 = new JLabel();
/*  130 */     this.jComboBox2 = new JComboBox();
/*  131 */     this.jLabel40 = new JLabel();
/*  132 */     this.jTextField4 = new JTextField();
/*  133 */     this.jPanel22 = new JPanel();
/*  134 */     this.jScrollPane1 = new JScrollPane();
/*  135 */     this.jTable1 = new JTable();
/*  136 */     this.jLabel33 = new JLabel();
/*  137 */     this.jTextField2 = new JTextField();
/*  138 */     this.jSeparator1 = new JSeparator();
/*  139 */     this.jButton8 = new JButton();
/*  140 */     this.jLabel48 = new JLabel();
/*  141 */     this.jButton1 = new JButton();
/*  142 */     this.jButton2 = new JButton();
/*  143 */     this.jLabel36 = new JLabel();
/*  144 */     this.jComboBox3 = new JComboBox();
/*  145 */     this.jComboBox4 = new JComboBox();
/*  146 */     this.jLabel37 = new JLabel();
/*  147 */     this.jButton5 = new JButton();
/*  148 */     this.jButton7 = new JButton();
/*      */     
/*  150 */     this.jDialog1.setTitle("Desactivar Pozos");
/*  151 */     this.jDialog1.setModal(true);
/*      */     
/*  153 */     this.jPanel2.setBackground(new Color(146, 193, 134));
/*      */     
/*  155 */     this.jLabel38.setFont(new Font("Tahoma", 3, 11));
/*  156 */     this.jLabel38.setForeground(new Color(15, 87, 51));
/*  157 */     this.jLabel38.setHorizontalAlignment(4);
/*  158 */     this.jLabel38.setText("Selecciona el Equipo");
/*      */     
/*  160 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  161 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "No Perforado", "Pendiente Terminación", "Terminado" }));
/*      */     
/*  163 */     this.jLabel39.setFont(new Font("Tahoma", 2, 11));
/*  164 */     this.jLabel39.setForeground(new Color(15, 87, 51));
/*  165 */     this.jLabel39.setHorizontalAlignment(4);
/*  166 */     this.jLabel39.setText("Comentario");
/*      */     
/*  168 */     this.jTextField3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  170 */             Pozos.this.jTextField3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  174 */     this.jLabel8.setFont(new Font("Tahoma", 1, 14));
/*  175 */     this.jLabel8.setForeground(new Color(0, 102, 102));
/*  176 */     this.jLabel8.setHorizontalAlignment(0);
/*  177 */     this.jLabel8.setText("Desactivar Pozos");
/*      */     
/*  179 */     this.jButton3.setMnemonic('C');
/*  180 */     this.jButton3.setText("Cerrar");
/*  181 */     this.jButton3.setToolTipText("Cerrar (Alt+C)");
/*  182 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  184 */             Pozos.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  188 */     this.jButton4.setMnemonic('G');
/*  189 */     this.jButton4.setText("Guardar");
/*  190 */     this.jButton4.setToolTipText("Guardar (Alt+G)");
/*  191 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  193 */             Pozos.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  197 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  198 */     this.jPanel2.setLayout(jPanel2Layout);
/*  199 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  200 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  201 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  202 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  203 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  204 */               .addGroup(jPanel2Layout.createSequentialGroup()
/*  205 */                 .addContainerGap()
/*  206 */                 .addComponent(this.jSeparator2, -2, 289, -2))
/*  207 */               .addComponent(this.jLabel8, -1, -1, 32767))
/*  208 */             .addGroup(jPanel2Layout.createSequentialGroup()
/*  209 */               .addContainerGap()
/*  210 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  211 */                 .addGroup(jPanel2Layout.createSequentialGroup()
/*  212 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  213 */                   .addComponent(this.jLabel39, -2, 81, -2))
/*  214 */                 .addComponent(this.jLabel38, GroupLayout.Alignment.LEADING, -2, 121, -2))
/*  215 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  216 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  217 */                 .addComponent(this.jTextField3)
/*  218 */                 .addComponent(this.jComboBox5, -2, 163, -2)
/*  219 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/*  220 */                   .addComponent(this.jButton4)
/*  221 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  222 */                   .addComponent(this.jButton3, -2, 72, -2)))))
/*  223 */           .addContainerGap(20, 32767)));
/*      */     
/*  225 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  226 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  227 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  228 */           .addContainerGap()
/*  229 */           .addComponent(this.jLabel8)
/*  230 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  231 */           .addComponent(this.jSeparator2, -2, 10, -2)
/*  232 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  233 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  234 */             .addComponent(this.jLabel38)
/*  235 */             .addComponent(this.jComboBox5, -2, -1, -2))
/*  236 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  237 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  238 */             .addComponent(this.jLabel39)
/*  239 */             .addComponent(this.jTextField3, -2, -1, -2))
/*  240 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  241 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  242 */             .addComponent(this.jButton3)
/*  243 */             .addComponent(this.jButton4))
/*  244 */           .addContainerGap(22, 32767)));
/*      */ 
/*      */     
/*  247 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  248 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  249 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  250 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  251 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */     
/*  253 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  254 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  255 */         .addComponent(this.jPanel2, -1, -1, 32767));
/*      */ 
/*      */     
/*  258 */     this.jDialog2.setTitle("Bitácora");
/*  259 */     this.jDialog2.setModal(true);
/*      */     
/*  261 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*      */     
/*  263 */     this.jLabel62.setFont(new Font("Tahoma", 1, 14));
/*  264 */     this.jLabel62.setForeground(new Color(0, 102, 102));
/*  265 */     this.jLabel62.setHorizontalAlignment(0);
/*  266 */     this.jLabel62.setText("Número de Bitácora");
/*      */     
/*  268 */     this.jLabel63.setFont(new Font("Tahoma", 3, 11));
/*  269 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/*  270 */     this.jLabel63.setHorizontalAlignment(4);
/*  271 */     this.jLabel63.setText("Bitácora");
/*      */     
/*  273 */     this.jTextField14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  275 */             Pozos.this.jTextField14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  279 */     this.jButton11.setMnemonic('G');
/*  280 */     this.jButton11.setText("Guardar");
/*  281 */     this.jButton11.setToolTipText("Guardar Bitacora(Alt+G)");
/*  282 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  284 */             Pozos.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  288 */     this.jButton12.setMnemonic('C');
/*  289 */     this.jButton12.setText("Cerrar");
/*  290 */     this.jButton12.setToolTipText("Cerrar (Alt+C)");
/*  291 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  293 */             Pozos.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  297 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  298 */     this.jPanel8.setLayout(jPanel8Layout);
/*  299 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  300 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  301 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  302 */           .addContainerGap()
/*  303 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  304 */             .addComponent(this.jLabel62, -1, 279, 32767)
/*  305 */             .addComponent(this.jSeparator3, -1, 279, 32767)
/*  306 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  307 */               .addComponent(this.jLabel63, -2, 57, -2)
/*  308 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  309 */               .addComponent(this.jTextField14, -1, 218, 32767))
/*  310 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/*  311 */               .addComponent(this.jButton11)
/*  312 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  313 */               .addComponent(this.jButton12, -2, 73, -2)))
/*  314 */           .addContainerGap()));
/*      */     
/*  316 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  317 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  318 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  319 */           .addComponent(this.jLabel62)
/*  320 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  321 */           .addComponent(this.jSeparator3, -2, 10, -2)
/*  322 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  323 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  324 */             .addComponent(this.jLabel63)
/*  325 */             .addComponent(this.jTextField14, -2, -1, -2))
/*  326 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  327 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  328 */             .addComponent(this.jButton12)
/*  329 */             .addComponent(this.jButton11))
/*  330 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  333 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  334 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  335 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  336 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  337 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*      */     
/*  339 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  340 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  341 */         .addComponent(this.jPanel8, -2, -1, -2));
/*      */ 
/*      */     
/*  344 */     this.jDialog3.setTitle("Equipos - Plataformas");
/*  345 */     this.jDialog3.setModal(true);
/*  346 */     this.jDialog3.setResizable(false);
/*      */     
/*  348 */     this.jPanel3.setBackground(new Color(146, 193, 134));
/*      */     
/*  350 */     this.jLabel20.setFont(new Font("Tahoma", 1, 15));
/*  351 */     this.jLabel20.setForeground(new Color(0, 102, 102));
/*  352 */     this.jLabel20.setHorizontalAlignment(0);
/*  353 */     this.jLabel20.setText("BUSCAR EQUIPOS");
/*      */     
/*  355 */     this.jPanel24.setBackground(new Color(146, 193, 134));
/*  356 */     this.jPanel24.setBorder(BorderFactory.createTitledBorder(null, "Buscar Guías", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  358 */     this.jTable5.setFont(new Font("Tahoma", 0, 10));
/*  359 */     this.jTable5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Guia", "Operador" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  367 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  372 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  375 */     this.jTable5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  377 */             Pozos.this.jTable5MouseClicked(evt);
/*      */           }
/*      */         });
/*  380 */     this.jScrollPane6.setViewportView(this.jTable5);
/*      */     
/*  382 */     this.jLabel41.setFont(new Font("Tahoma", 3, 11));
/*  383 */     this.jLabel41.setForeground(new Color(15, 87, 51));
/*  384 */     this.jLabel41.setHorizontalAlignment(2);
/*  385 */     this.jLabel41.setText("Equipo");
/*      */     
/*  387 */     this.jTextField28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  389 */             Pozos.this.jTextField28ActionPerformed(evt);
/*      */           }
/*      */         });
/*  392 */     this.jTextField28.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  394 */             Pozos.this.jTextField28KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  398 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/*  399 */     this.jPanel24.setLayout(jPanel24Layout);
/*  400 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/*  401 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  402 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
/*  403 */           .addContainerGap()
/*  404 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  405 */             .addComponent(this.jScrollPane6, GroupLayout.Alignment.LEADING, -1, 357, 32767)
/*  406 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
/*  407 */               .addComponent(this.jLabel41, -2, 71, -2)
/*  408 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  409 */               .addComponent(this.jTextField28, -2, 197, -2)))
/*  410 */           .addContainerGap()));
/*      */     
/*  412 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/*  413 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  414 */         .addGroup(jPanel24Layout.createSequentialGroup()
/*  415 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  416 */             .addComponent(this.jLabel41)
/*  417 */             .addComponent(this.jTextField28, -2, -1, -2))
/*  418 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  419 */           .addComponent(this.jScrollPane6, -1, 205, 32767)
/*  420 */           .addContainerGap()));
/*      */ 
/*      */     
/*  423 */     this.jButton9.setMnemonic('C');
/*  424 */     this.jButton9.setText("Cerrar");
/*  425 */     this.jButton9.setToolTipText("Cerrar (Alt+C)");
/*  426 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  428 */             Pozos.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  432 */     this.jButton29.setMnemonic('A');
/*  433 */     this.jButton29.setText("Asignar");
/*  434 */     this.jButton29.setToolTipText("Agregar (Alt+A)");
/*  435 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  437 */             Pozos.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  441 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  442 */     this.jPanel3.setLayout(jPanel3Layout);
/*  443 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  444 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  445 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  446 */           .addContainerGap()
/*  447 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  448 */             .addComponent(this.jPanel24, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  449 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  450 */               .addComponent(this.jButton29, -2, 102, -2)
/*  451 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  452 */               .addComponent(this.jButton9, -2, 100, -2))
/*  453 */             .addComponent(this.jLabel20, GroupLayout.Alignment.LEADING, -2, 381, -2)
/*  454 */             .addComponent(this.jSeparator10, GroupLayout.Alignment.LEADING, -1, 389, 32767))
/*  455 */           .addContainerGap(20, 32767)));
/*      */     
/*  457 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  458 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  459 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  460 */           .addContainerGap()
/*  461 */           .addComponent(this.jLabel20)
/*  462 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  463 */           .addComponent(this.jSeparator10, -2, 10, -2)
/*  464 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  465 */           .addComponent(this.jPanel24, -2, -1, -2)
/*  466 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  467 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  468 */             .addComponent(this.jButton9)
/*  469 */             .addComponent(this.jButton29))
/*  470 */           .addContainerGap(15, 32767)));
/*      */ 
/*      */     
/*  473 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/*  474 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/*  475 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/*  476 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  477 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/*  479 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/*  480 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  481 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */ 
/*      */     
/*  484 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/*  485 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  487 */     this.jLabel1.setFont(new Font("Tahoma", 1, 18));
/*  488 */     this.jLabel1.setForeground(new Color(10, 126, 68));
/*  489 */     this.jLabel1.setHorizontalAlignment(0);
/*  490 */     this.jLabel1.setText("Agregar Pozos");
/*      */     
/*  492 */     this.jPanel21.setBackground(new Color(146, 193, 134));
/*  493 */     this.jPanel21.setBorder(BorderFactory.createTitledBorder(null, " Agregar Pozos ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  495 */     this.jTextField1.setEnabled(false);
/*  496 */     this.jTextField1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  498 */             Pozos.this.jTextField1MouseClicked(evt);
/*      */           }
/*      */         });
/*  501 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  503 */             Pozos.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  507 */     this.jLabel32.setFont(new Font("Tahoma", 3, 11));
/*  508 */     this.jLabel32.setForeground(new Color(15, 87, 51));
/*  509 */     this.jLabel32.setHorizontalAlignment(4);
/*  510 */     this.jLabel32.setText("Nombre del Pozo");
/*  511 */     this.jLabel32.setEnabled(false);
/*      */     
/*  513 */     this.jButton6.setMnemonic('A');
/*  514 */     this.jButton6.setText("Agregar");
/*  515 */     this.jButton6.setToolTipText("Agregar (Alt+A)");
/*  516 */     this.jButton6.setEnabled(false);
/*  517 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  519 */             Pozos.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  523 */     this.jLabel34.setFont(new Font("Tahoma", 3, 11));
/*  524 */     this.jLabel34.setForeground(new Color(15, 87, 51));
/*  525 */     this.jLabel34.setHorizontalAlignment(4);
/*  526 */     this.jLabel34.setText("Plataforma");
/*      */     
/*  528 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  529 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  531 */             Pozos.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  535 */     this.jLabel35.setFont(new Font("Tahoma", 3, 11));
/*  536 */     this.jLabel35.setForeground(new Color(15, 87, 51));
/*  537 */     this.jLabel35.setHorizontalAlignment(4);
/*  538 */     this.jLabel35.setText("Equipos");
/*  539 */     this.jLabel35.setEnabled(false);
/*      */     
/*  541 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/*  542 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona un equipo" }));
/*  543 */     this.jComboBox2.setEnabled(false);
/*  544 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  546 */             Pozos.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  550 */     this.jLabel40.setFont(new Font("Tahoma", 3, 11));
/*  551 */     this.jLabel40.setForeground(new Color(15, 87, 51));
/*  552 */     this.jLabel40.setHorizontalAlignment(4);
/*  553 */     this.jLabel40.setText("Número de Bitácora");
/*  554 */     this.jLabel40.setEnabled(false);
/*      */     
/*  556 */     this.jTextField4.setEnabled(false);
/*  557 */     this.jTextField4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  559 */             Pozos.this.jTextField4MouseClicked(evt);
/*      */           }
/*      */         });
/*  562 */     this.jTextField4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  564 */             Pozos.this.jTextField4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  568 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/*  569 */     this.jPanel21.setLayout(jPanel21Layout);
/*  570 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/*  571 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  572 */         .addGroup(jPanel21Layout.createSequentialGroup()
/*  573 */           .addContainerGap()
/*  574 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  575 */             .addComponent(this.jLabel32, -1, -1, 32767)
/*  576 */             .addComponent(this.jLabel34, -1, -1, 32767))
/*  577 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  578 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  579 */             .addComponent(this.jTextField1)
/*  580 */             .addComponent(this.jComboBox1, 0, 196, 32767))
/*  581 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  582 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  583 */             .addComponent(this.jLabel40, -2, 121, -2)
/*  584 */             .addGroup(jPanel21Layout.createSequentialGroup()
/*  585 */               .addGap(37, 37, 37)
/*  586 */               .addComponent(this.jLabel35, -2, 83, -2)))
/*  587 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  588 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  589 */             .addComponent(this.jTextField4, GroupLayout.Alignment.TRAILING)
/*  590 */             .addComponent(this.jComboBox2, GroupLayout.Alignment.TRAILING, 0, 191, 32767))
/*  591 */           .addGap(28, 28, 28)
/*  592 */           .addComponent(this.jButton6, -2, 114, -2)
/*  593 */           .addGap(112, 112, 112)));
/*      */     
/*  595 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/*  596 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  597 */         .addGroup(jPanel21Layout.createSequentialGroup()
/*  598 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  599 */             .addGroup(jPanel21Layout.createSequentialGroup()
/*  600 */               .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  601 */                 .addComponent(this.jLabel34)
/*  602 */                 .addComponent(this.jComboBox1, -2, -1, -2))
/*  603 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  604 */               .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  605 */                 .addComponent(this.jLabel32)
/*  606 */                 .addComponent(this.jTextField1, -2, -1, -2)))
/*  607 */             .addGroup(jPanel21Layout.createSequentialGroup()
/*  608 */               .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  609 */                 .addComponent(this.jLabel35)
/*  610 */                 .addComponent(this.jComboBox2, -2, -1, -2))
/*  611 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  612 */               .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  613 */                 .addComponent(this.jLabel40)
/*  614 */                 .addComponent(this.jTextField4, -2, -1, -2)
/*  615 */                 .addComponent(this.jButton6))))
/*  616 */           .addGap(11, 11, 11)));
/*      */ 
/*      */     
/*  619 */     this.jPanel22.setBackground(new Color(146, 193, 134));
/*  620 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder(null, "Organizar Pozos ", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  622 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/*  623 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre de la PLataforma", "Equipo", "Estado", "Pozos" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  631 */           boolean[] canEdit = new boolean[] { false, false, true, true, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  636 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  639 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  641 */             Pozos.this.jTable1MouseClicked(evt);
/*      */           }
/*      */         });
/*  644 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/*  646 */     this.jLabel33.setFont(new Font("Tahoma", 3, 11));
/*  647 */     this.jLabel33.setForeground(new Color(15, 87, 51));
/*  648 */     this.jLabel33.setHorizontalAlignment(4);
/*  649 */     this.jLabel33.setText("Plataforma");
/*      */     
/*  651 */     this.jTextField2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  653 */             Pozos.this.jTextField2MouseClicked(evt);
/*      */           }
/*      */         });
/*  656 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  658 */             Pozos.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  662 */     this.jButton8.setMnemonic('E');
/*  663 */     this.jButton8.setText("Eliminar");
/*  664 */     this.jButton8.setToolTipText("Eliminar (Alt+E)");
/*  665 */     this.jButton8.setEnabled(false);
/*  666 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  668 */             Pozos.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  672 */     this.jLabel48.setFont(new Font("Tahoma", 2, 11));
/*  673 */     this.jLabel48.setForeground(new Color(204, 0, 0));
/*  674 */     this.jLabel48.setHorizontalAlignment(2);
/*  675 */     this.jLabel48.setText("Registros encontrados 3 de 122");
/*      */     
/*  677 */     this.jButton1.setMnemonic('A');
/*  678 */     this.jButton1.setText("Activar");
/*  679 */     this.jButton1.setToolTipText("Activar (Alt+A)");
/*  680 */     this.jButton1.setEnabled(false);
/*  681 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  683 */             Pozos.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  687 */     this.jButton2.setMnemonic('D');
/*  688 */     this.jButton2.setText("Desactivar");
/*  689 */     this.jButton2.setToolTipText("Desactivar (Alt+D)");
/*  690 */     this.jButton2.setEnabled(false);
/*  691 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  693 */             Pozos.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  697 */     this.jLabel36.setFont(new Font("Tahoma", 2, 11));
/*  698 */     this.jLabel36.setForeground(new Color(15, 87, 51));
/*  699 */     this.jLabel36.setHorizontalAlignment(4);
/*  700 */     this.jLabel36.setText("Estado");
/*      */     
/*  702 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/*  703 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  705 */             Pozos.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  709 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  710 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "No Perforado", "En Perforación", "Pendiente Terminación", "Terminado" }));
/*  711 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  713 */             Pozos.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  717 */     this.jLabel37.setFont(new Font("Tahoma", 2, 11));
/*  718 */     this.jLabel37.setForeground(new Color(15, 87, 51));
/*  719 */     this.jLabel37.setHorizontalAlignment(4);
/*  720 */     this.jLabel37.setText("Buscar");
/*      */     
/*  722 */     this.jButton5.setMnemonic('D');
/*  723 */     this.jButton5.setText("Bitácora");
/*  724 */     this.jButton5.setToolTipText("Desactivar (Alt+D)");
/*  725 */     this.jButton5.setEnabled(false);
/*  726 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  728 */             Pozos.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  732 */     this.jButton7.setMnemonic('A');
/*  733 */     this.jButton7.setText("Asignar EQ-PLAT");
/*  734 */     this.jButton7.setToolTipText("Asignar Equipo-Plataforma(Alt+A)");
/*  735 */     this.jButton7.setEnabled(false);
/*  736 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  738 */             Pozos.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  742 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/*  743 */     this.jPanel22.setLayout(jPanel22Layout);
/*  744 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/*  745 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  746 */         .addGroup(jPanel22Layout.createSequentialGroup()
/*  747 */           .addContainerGap()
/*  748 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  749 */             .addComponent(this.jScrollPane1, -1, 882, 32767)
/*  750 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  751 */               .addComponent(this.jLabel33, -2, 107, -2)
/*  752 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  753 */               .addComponent(this.jComboBox3, -2, 163, -2)
/*  754 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  755 */               .addComponent(this.jLabel36, -2, 60, -2)
/*  756 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  757 */               .addComponent(this.jComboBox4, -2, 163, -2)
/*  758 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  759 */               .addComponent(this.jLabel37, -2, 60, -2)
/*  760 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  761 */               .addComponent(this.jTextField2, -2, 161, -2))
/*  762 */             .addComponent(this.jSeparator1, -1, 882, 32767)
/*  763 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  764 */               .addComponent(this.jLabel48, -2, 178, -2)
/*  765 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 134, 32767)
/*  766 */               .addComponent(this.jButton2, -2, 102, -2)
/*  767 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  768 */               .addComponent(this.jButton1, -2, 81, -2)
/*  769 */               .addGap(55, 55, 55)
/*  770 */               .addComponent(this.jButton7, -2, 132, -2)
/*  771 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  772 */               .addComponent(this.jButton5, -2, 102, -2)
/*  773 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  774 */               .addComponent(this.jButton8, -2, 85, -2)))
/*  775 */           .addContainerGap()));
/*      */     
/*  777 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/*  778 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  779 */         .addGroup(jPanel22Layout.createSequentialGroup()
/*  780 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  781 */             .addComponent(this.jLabel33)
/*  782 */             .addComponent(this.jComboBox3, -2, -1, -2)
/*  783 */             .addComponent(this.jLabel36)
/*  784 */             .addComponent(this.jComboBox4, -2, -1, -2)
/*  785 */             .addComponent(this.jTextField2, -2, -1, -2)
/*  786 */             .addComponent(this.jLabel37))
/*  787 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  788 */           .addComponent(this.jSeparator1, -2, 10, -2)
/*  789 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  790 */           .addComponent(this.jScrollPane1, -1, 151, 32767)
/*  791 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  792 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  793 */             .addComponent(this.jLabel48)
/*  794 */             .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  795 */               .addComponent(this.jButton8)
/*  796 */               .addComponent(this.jButton5)
/*  797 */               .addComponent(this.jButton7)
/*  798 */               .addComponent(this.jButton1)
/*  799 */               .addComponent(this.jButton2)))
/*  800 */           .addContainerGap()));
/*      */ 
/*      */     
/*  803 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  804 */     this.jPanel6.setLayout(jPanel6Layout);
/*  805 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  806 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  807 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/*  808 */           .addContainerGap()
/*  809 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  810 */             .addComponent(this.jPanel22, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  811 */             .addComponent(this.jPanel21, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  812 */             .addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, 914, 32767))
/*  813 */           .addContainerGap()));
/*      */     
/*  815 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  816 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  817 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  818 */           .addComponent(this.jLabel1)
/*  819 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  820 */           .addComponent(this.jPanel21, -2, -1, -2)
/*  821 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  822 */           .addComponent(this.jPanel22, -1, -1, 32767)
/*  823 */           .addContainerGap()));
/*      */ 
/*      */     
/*  826 */     GroupLayout layout = new GroupLayout(this);
/*  827 */     setLayout(layout);
/*  828 */     layout.setHorizontalGroup(layout
/*  829 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  830 */         .addGap(0, 958, 32767)
/*  831 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  832 */           .addGroup(layout.createSequentialGroup()
/*  833 */             .addGap(0, 10, 32767)
/*  834 */             .addComponent(this.jPanel6, -2, -1, -2)
/*  835 */             .addGap(0, 10, 32767))));
/*      */     
/*  837 */     layout.setVerticalGroup(layout
/*  838 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  839 */         .addGap(0, 415, 32767)
/*  840 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  841 */           .addGroup(layout.createSequentialGroup()
/*  842 */             .addGap(9, 9, 9)
/*  843 */             .addComponent(this.jPanel6, -1, -1, 32767)
/*  844 */             .addGap(10, 10, 10))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {
/*  849 */     guardarPozos();
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/*  853 */     guardarPozos();
/*      */   }
/*      */   
/*      */   private void jTable1MouseClicked(MouseEvent evt) {
/*  857 */     this.jButton1.setEnabled(true);
/*  858 */     this.jButton2.setEnabled(true);
/*  859 */     this.jButton5.setEnabled(true);
/*  860 */     this.jButton7.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/*  864 */     consultar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/*  872 */     int indice = this.jComboBox1.getSelectedIndex();
/*  873 */     if (indice != 0) {
/*  874 */       this.jComboBox2.setEnabled(true);
/*  875 */       this.jComboBox2.removeAllItems();
/*  876 */       this.jLabel35.setEnabled(true);
/*  877 */       String plataforma = String.valueOf(this.jComboBox1.getSelectedItem());
/*  878 */       this.con.consultar("num_plata", "plataformas", "where plataforma = '" + plataforma + "'");
/*  879 */       String num_plata = this.con.Campo;
/*  880 */       this.con.consultar("count(num_plata)", "equipo_plataforma", "where num_equipo<>0 and num_plata = " + num_plata);
/*  881 */       int totE = Integer.parseInt(this.con.Campo);
/*  882 */       if (totE == 0) {
/*  883 */         this.jComboBox2.setEnabled(false);
/*  884 */         this.jComboBox2.removeAllItems();
/*  885 */         this.jComboBox2.addItem("Selecciona un equipo");
/*  886 */         this.jLabel35.setEnabled(false);
/*      */       } else {
/*      */         
/*  889 */         String[] num_equipos = this.con.regresaCol("num_equipo", "equipo_plataforma", "where num_equipo<>0 and num_plata=" + num_plata, totE);
/*  890 */         this.jComboBox2.addItem("Selecciona uno...");
/*  891 */         for (int i = 0; i < totE; i++) {
/*  892 */           this.con.consultar("equipo", "equipos", "where num_equipo = " + num_equipos[i]);
/*  893 */           this.jComboBox2.addItem(this.con.Campo);
/*      */         } 
/*      */       } 
/*      */     } else {
/*      */       
/*  898 */       this.jComboBox2.setEnabled(false);
/*  899 */       this.jComboBox2.removeAllItems();
/*  900 */       this.jComboBox2.addItem("Selecciona un equipo");
/*  901 */       this.jLabel35.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/*  906 */     int indice = this.jComboBox2.getSelectedIndex();
/*  907 */     if (indice != 0) {
/*  908 */       this.jLabel32.setEnabled(true);
/*  909 */       this.jButton6.setEnabled(true);
/*  910 */       this.jTextField1.setEnabled(true);
/*  911 */       this.jTextField4.setEnabled(true);
/*  912 */       this.jLabel40.setEnabled(true);
/*      */     } else {
/*      */       
/*  915 */       this.jLabel32.setEnabled(false);
/*  916 */       this.jButton6.setEnabled(false);
/*  917 */       this.jTextField1.setEnabled(false);
/*  918 */       this.jTextField4.setEnabled(false);
/*  919 */       this.jLabel40.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField2MouseClicked(MouseEvent evt) {
/*  924 */     this.jButton1.setEnabled(false);
/*  925 */     this.jButton2.setEnabled(false);
/*  926 */     this.jButton5.setEnabled(false);
/*      */   }
/*      */   
/*      */   private void jTextField1MouseClicked(MouseEvent evt) {
/*  930 */     this.jButton1.setEnabled(false);
/*  931 */     this.jButton2.setEnabled(false);
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/*  935 */     if (this.jComboBox3.getItemCount() > 0) {
/*  936 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/*  941 */     String num_pozo = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/*  942 */     this.con.consultar("num", "pozos", "where num_pozo = " + num_pozo);
/*  943 */     String num = this.con.Campo;
/*      */ 
/*      */     
/*  946 */     String[] estado = this.con.regresaColIndex("estado", "pozos", "where num = " + num);
/*  947 */     for (int i = 0; i < estado.length; i++) {
/*  948 */       if (estado[i].equals("EN PERFORACIÓN")) {
/*  949 */         JOptionPane.showMessageDialog(this.padre, "No puedes activar esta perforación porque ya ha está activado un pozo", "Ya Existe Pozo en Perforación", 0, this.ERROR);
/*      */         return;
/*      */       } 
/*      */     } 
/*  953 */     int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas activar el pozo que seleccionaste?", "Confirma Activación", 0, 3, this.PREG);
/*  954 */     if (res == 0) {
/*  955 */       this.con.inserSinMsj("UPDATE pozos set estado ='EN PERFORACIÓN' WHERE NUM_pozo = " + num_pozo);
/*  956 */       this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Activó un pozo.','Activó el pozo: " + num_pozo + "')");
/*  957 */       JOptionPane.showMessageDialog(this.padre, "El pozo ha sido activado satisfactoriamente", "Pozo Activado", 0, this.INFO);
/*  958 */       consultar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/*  963 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/*  967 */     String num_pozo = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/*  968 */     this.con.consultar("estado", "pozos", "where num_pozo = " + num_pozo);
/*  969 */     String estado = this.con.Campo;
/*  970 */     if (!estado.equals("EN PERFORACIÓN")) {
/*  971 */       JOptionPane.showMessageDialog(this.padre, "No puedes desactivar este pozo porque en su estado actual no está En Perforación", "No se puede Desactivar", 0, this.ERROR);
/*      */     } else {
/*      */       
/*  974 */       this.jDialog1.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/*  979 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/*  983 */     desactivar();
/*      */   }
/*      */   
/*      */   private void jTextField3ActionPerformed(ActionEvent evt) {
/*  987 */     desactivar();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField4MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField4ActionPerformed(ActionEvent evt) {
/*  995 */     guardarPozos();
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/*  999 */     this.jTextField14.setText(String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3)));
/* 1000 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField14ActionPerformed(ActionEvent evt) {
/* 1004 */     bitacora();
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 1008 */     bitacora();
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 1012 */     this.jTextField14.setText("");
/* 1013 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 1017 */     String valor = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5));
/* 1018 */     System.out.println(valor + " asdff");
/* 1019 */     if (!valor.equals("")) {
/* 1020 */       JOptionPane.showMessageDialog(this.padre, "No puedes agregar un equipo directo porque éste ya tiene uno asignado\nNecesitas seleccionar un pozo que no tenga equipo", "Pozo con Equipo", 0, this.ADVER);
/*      */     } else {
/*      */       
/* 1023 */       consultar2();
/* 1024 */       this.jDialog3.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable5MouseClicked(MouseEvent evt) {
/* 1029 */     if (evt.getClickCount() == 2) {
/* 1030 */       asignar();
/*      */     } else {
/*      */       
/* 1033 */       this.jButton29.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTextField28ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField28KeyReleased(KeyEvent evt) {
/* 1042 */     consultar2();
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 1046 */     asignar();
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 1050 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   public void colorear() {
/* 1053 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1055 */             Pozos.this.jTextGanado(Pozos.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1058 */             Pozos.this.jTextPerdido(Pozos.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 1061 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1063 */             Pozos.this.jTextGanado(Pozos.this.jTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1066 */             Pozos.this.jTextPerdido(Pozos.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 1069 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1071 */             Pozos.this.jTextGanado(Pozos.this.jTextField3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1074 */             Pozos.this.jTextPerdido(Pozos.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 1077 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1079 */             Pozos.this.jTextGanado(Pozos.this.jTextField4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1082 */             Pozos.this.jTextPerdido(Pozos.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 1085 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1087 */             Pozos.this.jTextGanado(Pozos.this.jTextField14, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1090 */             Pozos.this.jTextPerdido(Pozos.this.jTextField14, evt);
/*      */           }
/*      */         });
/* 1093 */     this.jTextField28.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1095 */             Pozos.this.jTextGanado(Pozos.this.jTextField28, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1098 */             Pozos.this.jTextPerdido(Pozos.this.jTextField28, evt);
/*      */           }
/*      */         });
/* 1101 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1103 */             Pozos.this.jTextGanado(Pozos.this.jComboBox1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1106 */             Pozos.this.jTextPerdido(Pozos.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 1109 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1111 */             Pozos.this.jTextGanado(Pozos.this.jComboBox2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1114 */             Pozos.this.jTextPerdido(Pozos.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 1117 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1119 */             Pozos.this.jTextGanado(Pozos.this.jComboBox3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1122 */             Pozos.this.jTextPerdido(Pozos.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 1125 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1127 */             Pozos.this.jTextGanado(Pozos.this.jComboBox4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1130 */             Pozos.this.jTextPerdido(Pozos.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 1133 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1135 */             Pozos.this.jTextGanado(Pozos.this.jComboBox5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1138 */             Pozos.this.jTextPerdido(Pozos.this.jComboBox5, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 1143 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 1146 */     campo.setBackground(Color.white);
/*      */   }
/*      */   public void consultar() {
/* 1149 */     this.jButton1.setEnabled(false);
/* 1150 */     this.jButton2.setEnabled(false);
/* 1151 */     this.jButton7.setEnabled(false);
/* 1152 */     String pozo = this.jTextField2.getText();
/* 1153 */     String num = "";
/* 1154 */     String num_plata = "";
/* 1155 */     String estado = "";
/* 1156 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 1157 */       String plataforma = String.valueOf(this.jComboBox3.getSelectedItem());
/* 1158 */       if (plataforma.equals(null)) {
/* 1159 */         plataforma = "";
/*      */       }
/* 1161 */       this.encontrado = this.con.consultar("num_plata", "plataformas", "where plataforma = '" + plataforma + "'");
/* 1162 */       num_plata = this.con.Campo;
/* 1163 */       if (this.encontrado) {
/* 1164 */         this.con.consultar("num", "equipo_plataforma", "where num_plata = " + num_plata);
/* 1165 */         num = this.con.Campo;
/*      */       } else {
/*      */         
/* 1168 */         num = "0";
/*      */       } 
/*      */     } 
/* 1171 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 1172 */       estado = String.valueOf(this.jComboBox4.getSelectedItem());
/*      */     }
/* 1174 */     this.encontrado = this.con.consultar("count(num_pozo)", "pozos,equipo_plataforma,plataformas", "where equipo_plataforma.num_plata = plataformas.num_plata and pozos.num = equipo_plataforma.num and equipo_plataforma.num_plata like '%" + num_plata + "%' and nombre like '%" + pozo + "%' and estado like '%" + estado + "%' order by num_pozo");
/* 1175 */     int totreg = Integer.parseInt(this.con.Campo);
/* 1176 */     this.encontrado = this.con.consultar("count(num_pozo)", "pozos,equipo_plataforma,plataformas", "where equipo_plataforma.num_plata = plataformas.num_plata and pozos.num = equipo_plataforma.num");
/* 1177 */     String tot = this.con.Campo;
/* 1178 */     this.jLabel48.setText("Registros encontrados " + totreg + " de " + tot);
/* 1179 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 1180 */           .buscarReg(7, totreg, "num_pozo,nombre,estado,bitacora,plataforma,equipo,comen", "equipos,pozos,equipo_plataforma,plataformas", "where equipo_plataforma.num_equipo = equipos.num_equipo and equipo_plataforma.num_plata = plataformas.num_plata and pozos.num = equipo_plataforma.num and equipo_plataforma.num_plata like '%" + num_plata + "%' and nombre like '%" + pozo + "%' and estado like '%" + estado + "%' order by equipo"), (Object[])new String[] { "Clave", "Pozos", "Estado", "Bitácora", "Plataforma", "Equipo", "Comentario" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1185 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1189 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1192 */     this.jTable1.setShowVerticalLines(false);
/* 1193 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 1194 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 1195 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 1196 */     this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
/* 1197 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
/* 1198 */     this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(140);
/* 1199 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(140);
/* 1200 */     this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
/* 1201 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
/* 1202 */     this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(140);
/* 1203 */     this.jTable1.getColumnModel().getColumn(4).setMaxWidth(140);
/* 1204 */     this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(140);
/* 1205 */     this.jTable1.getColumnModel().getColumn(5).setMaxWidth(140);
/*      */     
/* 1207 */     this.jTable1.setSelectionMode(0);
/* 1208 */     this.jTable1.setAutoCreateRowSorter(true);
/* 1209 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 1211 */     this.jTable1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 1212 */     this.jTable1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 1213 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 1214 */     this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 1215 */     this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 1216 */     this.jTable1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 1217 */     this.jTable1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/*      */   }
/*      */   public void consultar2() {
/* 1220 */     this.jButton29.setEnabled(false);
/*      */ 
/*      */     
/* 1223 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/* 1224 */           .buscarDatos(3, "equipo_plataforma.num,equipo,plataforma", "equipo_plataforma,equipos,plataformas", "where equipo_plataforma.num_plata = plataformas.num_plata and equipo_plataforma.num_equipo = equipos.num_equipo and equipos.num_equipo<>0 and equipo like '%" + this.jTextField28.getText() + "%' order by equipo"), (Object[])new String[] { "Clave", "Equipo", "Plataforma" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1229 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1233 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1236 */     this.jTable5.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 1237 */     this.jTable5.getColumnModel().getColumn(0).setMaxWidth(40);
/* 1238 */     this.jTable5.setSelectionMode(0);
/* 1239 */     this.jTable5.setAutoCreateRowSorter(true);
/* 1240 */     this.jTable5.getTableHeader().setReorderingAllowed(false);
/* 1241 */     this.jTable5.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 1242 */     this.jTable5.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 1243 */     this.jTable5.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/*      */   }
/*      */   public void asignar() {
/* 1246 */     String valor = String.valueOf(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 0));
/* 1247 */     int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas activar el pozo que seleccionaste con el equipo y plataforma?", "Confirma Activación", 0, 3, this.PREG);
/* 1248 */     if (res == 0) {
/* 1249 */       this.con.inserSinMsj("update pozos set num = " + valor + " where num_pozo = " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 1250 */       consultar();
/* 1251 */       this.jTextField28.setText("");
/* 1252 */       this.jDialog3.setVisible(false);
/*      */     } 
/*      */   }
/*      */   public void guardarPozos() {
/* 1256 */     this.error.pasarModal(false);
/* 1257 */     this.val.pasarModal(Boolean.valueOf(false));
/* 1258 */     String plataforma = String.valueOf(this.jComboBox3.getSelectedItem());
/* 1259 */     String pozo = this.jTextField1.getText().toUpperCase();
/* 1260 */     if (pozo.equals("")) {
/* 1261 */       this.error.cargarError(this.jTextField1, "050");
/*      */     }
/* 1263 */     else if (this.jTextField4.getText().equals("")) {
/* 1264 */       this.error.cargarError(this.jTextField4, "050");
/*      */     }
/* 1266 */     else if (!this.val.validarApostrofe(this.jTextField1, pozo, "020") && 
/* 1267 */       !this.val.validarApostrofe(this.jTextField4, this.jTextField4.getText(), "020")) {
/* 1268 */       this.encontrado = this.con.consultar("nombre", "pozos", "where nombre = '" + this.jTextField1.getText() + "'");
/* 1269 */       if (this.encontrado) {
/* 1270 */         this.jTextField1.setBackground(Color.red);
/* 1271 */         JOptionPane.showMessageDialog(this.padre, "El pozo que deseas insertar ya se encuentra registrado en la base de datos", "Pozo ya Existe", 0, this.ERROR);
/*      */       } else {
/*      */         
/* 1274 */         int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas crear una nuevo pozo?", "Crear Pozos", 0, 1, this.PREG);
/* 1275 */         if (res == 0) {
/* 1276 */           this.con.consultar("num_equipo", "equipos", "where equipo = '" + String.valueOf(this.jComboBox2.getSelectedItem()) + "'");
/* 1277 */           String num_equipo = this.con.Campo;
/* 1278 */           this.con.consultar("num_plata", "plataformas", "where plataforma = '" + String.valueOf(this.jComboBox1.getSelectedItem()) + "'");
/* 1279 */           String num_plata = this.con.Campo;
/* 1280 */           this.con.consultar("num", "equipo_plataforma", "where num_equipo = " + num_equipo + " and num_plata = " + num_plata);
/* 1281 */           String num = this.con.Campo;
/* 1282 */           this.con.insertar("insert into pozos(nombre,num,estado,comen,bitacora)values('" + pozo + "'," + num + ",'NO PERFORADO','','" + this.jTextField4.getText().toUpperCase() + "')");
/* 1283 */           this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Almacenó un nuevo pozo.','Nombre: " + this.jTextField1.getText() + "')");
/* 1284 */           consultar();
/* 1285 */           this.jTextField1.setText("");
/* 1286 */           this.jTextField4.setText("");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void pozos(String usu) {
/* 1293 */     this.USUARIO = usu;
/* 1294 */     llenarCombo();
/* 1295 */     consultar();
/* 1296 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 1300 */     String[] plataformas = this.con.regresaColIndex("plataforma", "plataformas", "order by plataforma");
/* 1301 */     this.jComboBox1.removeAllItems();
/* 1302 */     this.jComboBox3.removeAllItems();
/* 1303 */     this.jComboBox1.addItem("Selecciona uno...");
/* 1304 */     this.jComboBox3.addItem("Selecciona uno...");
/* 1305 */     for (int i = 0; i < plataformas.length; i++) {
/* 1306 */       this.jComboBox1.addItem(plataformas[i]);
/* 1307 */       this.jComboBox3.addItem(plataformas[i]);
/*      */     } 
/*      */   }
/*      */   public void desactivar() {
/* 1311 */     this.error.pasarModal(true);
/* 1312 */     this.val.pasarModal(Boolean.valueOf(true));
/* 1313 */     String num_pozo = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/* 1314 */     String estado = String.valueOf(this.jComboBox5.getSelectedItem());
/* 1315 */     String comen = this.jTextField3.getText().toUpperCase();
/* 1316 */     if (this.jComboBox5.getSelectedIndex() == 0) {
/* 1317 */       this.error.cargarError(this.jComboBox5, "050");
/*      */     }
/* 1319 */     else if (!this.val.validarApostrofe(this.jTextField3, comen, "020")) {
/* 1320 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que desactivar el pozo que seleccionaste?", "Desactivar Pozo", 0, 1, this.PREG);
/* 1321 */       if (res == 0) {
/* 1322 */         this.jDialog1.setVisible(false);
/* 1323 */         this.con.insertar("update pozos set estado = '" + estado.toUpperCase() + "',comen = '" + comen + "' where num_pozo = " + num_pozo);
/*      */         
/* 1325 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Desactivó un pozo.','El pozo: " + num_pozo + "\nEstado: " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2)) + "\nComentario: " + comen + "')");
/* 1326 */         consultar();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public void bitacora() {
/* 1331 */     this.error.pasarModal(true);
/* 1332 */     this.val.pasarModal(Boolean.valueOf(true));
/* 1333 */     String motivo = this.jTextField14.getText();
/* 1334 */     if (motivo.equals("")) {
/* 1335 */       this.error.cargarError(this.jTextField14, "050");
/*      */     }
/* 1337 */     else if (!this.val.validarApostrofe(this.jTextField14, motivo, "020")) {
/* 1338 */       int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que actualizar la bitácora para este pozo?", "Actualizar Bitácora", 0, 3, this.PREG);
/* 1339 */       if (res == 0) {
/* 1340 */         this.con.inserSinMsj("update pozos set bitacora = '" + this.jTextField14.getText().toUpperCase() + "' where num_pozo = " + String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0)));
/* 1341 */         consultar();
/* 1342 */         this.jDialog2.setVisible(false);
/* 1343 */         this.jTextField14.setText("");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/* 1348 */   class CeldaRender extends DefaultTableCellRenderer { int otro = -1;
/* 1349 */     int[] indices = new int[0];
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1351 */       setEnabled((table == null || table.isEnabled()));
/* 1352 */       if (row % 2 == 0) {
/* 1353 */         setBackground(new Color(194, 213, 151));
/*      */       } else {
/* 1355 */         setBackground((Color)null);
/* 1356 */       }  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1357 */       return this;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Pozos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */