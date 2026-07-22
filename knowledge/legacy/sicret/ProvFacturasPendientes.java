/*     */ package sicret;
/*     */ import Fuentes.Fuentes;
/*     */ import com.placeholder.PlaceHolder;
/*     */ import com.toedter.calendar.JDateChooser;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Image;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.text.NumberFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableCellRenderer;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.text.DefaultFormatterFactory;
/*     */ import javax.swing.text.NumberFormatter;
/*     */ import net.sf.jasperreports.engine.JRException;
/*     */ import principal.MaterialButton;
/*     */ import rojerusan.RSTableMetro;
/*     */ import utilerias.Utilerias;
/*     */ import utilerias.pintarComponentes;
/*     */ 
/*     */ public class ProvFacturasPendientes extends JDialog {
/*     */   private int xx;
/*     */   private int xy;
/*     */   JScrollPane panel;
/*  58 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  59 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*  60 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*  61 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*  62 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*  63 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*  64 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*  65 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*  66 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*  67 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*  68 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*  69 */   JFrame padre = null;
/*  70 */   JTabbedPane fichas = null;
/*     */   Map<String, String> CAMPOSGENERALES;
/*  72 */   MensajePop mensajeTry = null;
/*     */   String USUARIO;
/*  74 */   SColores lc = new SColores();
/*  75 */   Fuentes fuentes = new Fuentes();
/*  76 */   PlaceHolder placeHolder = null;
/*  77 */   Date fechaActual = new Date();
/*  78 */   Date fechaInicio = null;
/*  79 */   List<String> lista = null;
/*  80 */   String holderCliente = "INGRESA EL PROVEEDOR";
/*  81 */   pintarComponentes pintar = new pintarComponentes();
/*  82 */   Consultas2 con = new Consultas2();
/*  83 */   CeldaRender3 celda3 = new CeldaRender3();
/*  84 */   Utilerias utilerias = new Utilerias(); private JFormattedTextField cantidad; private JButton jButton1; private JComboBox<String> jComboBox1; private JDateChooser jDateChooser1; private JLabel jLabel128; private JLabel jLabel20; private JLabel jLabel27; private JLabel jLabel58;
/*     */   private JLabel jLabel59;
/*     */   private JLabel jLabel60;
/*     */   private JLabel jLabel61;
/*     */   private JLabel jLabel62;
/*     */   
/*     */   public ProvFacturasPendientes(String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES, List<String> lista) {
/*  91 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  92 */     this.mensajeTry = this.mensajeTry;
/*  93 */     this.padre = padre;
/*  94 */     this.fichas = this.fichas;
/*  95 */     this.USUARIO = USUARIO;
/*  96 */     this.lista = lista;
/*  97 */     this.con.setBaseDatos("sicre2PR");
/*  98 */     this.con.cambiarServidor();
/*     */     
/* 100 */     initComponents();
/* 101 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderCliente, false, "Century Gothic", 11);
/*     */     
/* 103 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/* 104 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/* 105 */     editFormat.setGroupingUsed(false);
/* 106 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/* 107 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/* 108 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/* 109 */     enFormat.setAllowsInvalid(true);
/* 110 */     this.cantidad.setFormatterFactory(currFactory);
/*     */     
/* 112 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 113 */     Cursor micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/* 114 */     this.rSTableMetro1.setCursor(micursor);
/* 115 */     setCursor(micursor);
/*     */     
/* 117 */     Iterator<String> it = lista.iterator();
/* 118 */     this.jComboBox1.addItem("GENERAL");
/* 119 */     while (it.hasNext()) {
/* 120 */       String v = it.next();
/* 121 */       this.jComboBox1.addItem(v);
/*     */     } 
/* 123 */     this.jComboBox1.removeItemAt(2);
/*     */     
/* 125 */     colorear();
/* 126 */     consultar();
/*     */     
/* 128 */     int w = this.tama.width;
/* 129 */     int h = this.tama.height;
/* 130 */     int rw = (w - 890) / 2;
/* 131 */     int rh = (h - 475) / 2;
/* 132 */     setLocation(rw, rh);
/* 133 */     setSize(890, 475);
/* 134 */     setVisible(true);
/* 135 */     setResizable(true);
/*     */   }
/*     */   private JLabel jLabel64; private JPanel jPanel1; private JPanel jPanel12; private JPanel jPanel2; private JPanel jPanel50;
/*     */   private JPanel jPanel79;
/*     */   
/*     */   private void initComponents() {
/* 141 */     this.cantidad = new JFormattedTextField();
/* 142 */     this.jPanel12 = new JPanel();
/* 143 */     this.jPanel50 = new JPanel();
/* 144 */     this.jLabel20 = new JLabel();
/* 145 */     this.jPanel80 = new JPanel();
/* 146 */     this.jLabel128 = new JLabel();
/* 147 */     this.jLabel27 = new JLabel();
/* 148 */     this.jPanel79 = new JPanel();
/* 149 */     this.materialButton38 = new MaterialButton();
/* 150 */     this.materialButton39 = new MaterialButton();
/* 151 */     this.materialButton40 = new MaterialButton();
/* 152 */     this.jComboBox1 = new JComboBox<>();
/* 153 */     this.jLabel60 = new JLabel();
/* 154 */     this.jLabel61 = new JLabel();
/* 155 */     this.jLabel62 = new JLabel();
/* 156 */     this.jLabel64 = new JLabel();
/* 157 */     this.jPanel1 = new JPanel();
/* 158 */     this.jPanel2 = new JPanel();
/* 159 */     this.jLabel58 = new JLabel();
/* 160 */     this.jTextField1 = new JTextField();
/* 161 */     this.jLabel59 = new JLabel();
/* 162 */     this.jDateChooser1 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/* 163 */     this.jButton1 = new JButton();
/* 164 */     this.jScrollPane33 = new JScrollPane();
/* 165 */     this.rSTableMetro1 = new RSTableMetro();
/*     */     
/* 167 */     this.cantidad.setText("jFormattedTextField1");
/*     */     
/* 169 */     setDefaultCloseOperation(2);
/* 170 */     setModal(true);
/* 171 */     setUndecorated(true);
/*     */     
/* 173 */     this.jPanel12.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*     */     
/* 175 */     this.jPanel50.setBackground(this.lc.SECUNDARIO1);
/*     */     
/* 177 */     this.jLabel20.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/* 178 */     this.jLabel20.setForeground(new Color(255, 255, 255));
/* 179 */     this.jLabel20.setHorizontalAlignment(0);
/* 180 */     this.jLabel20.setText("Facturas Vencidas");
/* 181 */     this.jLabel20.addMouseMotionListener(new MouseMotionAdapter() {
/*     */           public void mouseDragged(MouseEvent evt) {
/* 183 */             ProvFacturasPendientes.this.jLabel20MouseDragged(evt);
/*     */           }
/*     */         });
/* 186 */     this.jLabel20.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 188 */             ProvFacturasPendientes.this.jLabel20MouseClicked(evt);
/*     */           }
/*     */         });
/*     */     
/* 192 */     this.jPanel80.setBackground(this.lc.PRIMARIO1);
/* 193 */     this.jPanel80.setLayout(new GridLayout());
/*     */     
/* 195 */     this.jLabel128.setHorizontalAlignment(0);
/* 196 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/* 197 */     this.jLabel128.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 199 */             ProvFacturasPendientes.this.jLabel128MouseClicked(evt);
/*     */           }
/*     */           public void mouseEntered(MouseEvent evt) {
/* 202 */             ProvFacturasPendientes.this.jLabel128MouseEntered(evt);
/*     */           }
/*     */           public void mouseExited(MouseEvent evt) {
/* 205 */             ProvFacturasPendientes.this.jLabel128MouseExited(evt);
/*     */           }
/*     */         });
/* 208 */     this.jPanel80.add(this.jLabel128);
/*     */     
/* 210 */     this.jLabel27.setHorizontalAlignment(0);
/* 211 */     this.jLabel27.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/placeholder-on-map-paper-in-perspective-2.png")));
/*     */     
/* 213 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/* 214 */     this.jPanel50.setLayout(jPanel50Layout);
/* 215 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/* 216 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 217 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 218 */           .addGap(1, 1, 1)
/* 219 */           .addComponent(this.jLabel27, -2, 36, -2)
/* 220 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 221 */           .addComponent(this.jLabel20, -1, -1, 32767)
/* 222 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 223 */           .addComponent(this.jPanel80, -2, 34, -2)));
/*     */     
/* 225 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/* 226 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 227 */         .addComponent(this.jPanel80, -1, -1, 32767)
/* 228 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 229 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 230 */             .addComponent(this.jLabel27, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 231 */             .addComponent(this.jLabel20, -2, 30, -2))
/* 232 */           .addGap(0, 0, 32767)));
/*     */ 
/*     */     
/* 235 */     this.jPanel79.setBackground(this.lc.SECUNDARIO2);
/*     */     
/* 237 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/* 238 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/* 239 */     this.materialButton38.setMnemonic('R');
/* 240 */     this.materialButton38.setText("Cerrar");
/* 241 */     this.materialButton38.setToolTipText("Cerrar (Alt+R)");
/* 242 */     this.materialButton38.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/* 243 */     this.materialButton38.setHorizontalTextPosition(0);
/* 244 */     this.materialButton38.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 246 */             ProvFacturasPendientes.this.materialButton38ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 250 */     this.materialButton39.setBackground(this.lc.PRIMARIO1);
/* 251 */     this.materialButton39.setForeground(new Color(255, 255, 255));
/* 252 */     this.materialButton39.setMnemonic('I');
/* 253 */     this.materialButton39.setText("Imprimir");
/* 254 */     this.materialButton39.setToolTipText("Imprimir (Alt+L)");
/* 255 */     this.materialButton39.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/* 256 */     this.materialButton39.setHorizontalTextPosition(0);
/* 257 */     this.materialButton39.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 259 */             ProvFacturasPendientes.this.materialButton39ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 263 */     this.materialButton40.setBackground(this.lc.PRIMARIO1);
/* 264 */     this.materialButton40.setForeground(new Color(255, 255, 255));
/* 265 */     this.materialButton40.setMnemonic('G');
/* 266 */     this.materialButton40.setText("Guardar");
/* 267 */     this.materialButton40.setToolTipText("Guardar (Alt+G)");
/* 268 */     this.materialButton40.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/* 269 */     this.materialButton40.setHorizontalTextPosition(0);
/* 270 */     this.materialButton40.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 272 */             ProvFacturasPendientes.this.materialButton40ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 276 */     this.jComboBox1.setBackground(new Color(255, 255, 255));
/*     */     
/* 278 */     this.jLabel60.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 279 */     this.jLabel60.setForeground(this.lc.SECUNDARIO1);
/* 280 */     this.jLabel60.setHorizontalAlignment(4);
/* 281 */     this.jLabel60.setText("Facturas:");
/*     */     
/* 283 */     this.jLabel61.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 284 */     this.jLabel61.setForeground(this.lc.PRIMARIO1);
/* 285 */     this.jLabel61.setHorizontalAlignment(2);
/* 286 */     this.jLabel61.setText("0");
/*     */     
/* 288 */     this.jLabel62.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 289 */     this.jLabel62.setForeground(this.lc.SECUNDARIO1);
/* 290 */     this.jLabel62.setHorizontalAlignment(4);
/* 291 */     this.jLabel62.setText("Debe:");
/*     */     
/* 293 */     this.jLabel64.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 294 */     this.jLabel64.setForeground(this.lc.PRIMARIO1);
/* 295 */     this.jLabel64.setHorizontalAlignment(2);
/* 296 */     this.jLabel64.setText("0");
/*     */     
/* 298 */     GroupLayout jPanel79Layout = new GroupLayout(this.jPanel79);
/* 299 */     this.jPanel79.setLayout(jPanel79Layout);
/* 300 */     jPanel79Layout.setHorizontalGroup(jPanel79Layout
/* 301 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 302 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
/* 303 */           .addComponent(this.jComboBox1, 0, -1, 32767)
/* 304 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 305 */           .addComponent(this.jLabel60, -2, 86, -2)
/* 306 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 307 */           .addComponent(this.jLabel61, -2, 36, -2)
/* 308 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 309 */           .addComponent(this.jLabel62, -2, 60, -2)
/* 310 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 311 */           .addComponent(this.jLabel64, -1, -1, 32767)
/* 312 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 313 */           .addComponent((Component)this.materialButton40, -2, 150, -2)
/* 314 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 315 */           .addComponent((Component)this.materialButton39, -2, 150, -2)
/* 316 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 317 */           .addComponent((Component)this.materialButton38, -2, 105, -2)
/* 318 */           .addContainerGap()));
/*     */     
/* 320 */     jPanel79Layout.setVerticalGroup(jPanel79Layout
/* 321 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 322 */         .addGroup(jPanel79Layout.createSequentialGroup()
/* 323 */           .addGroup(jPanel79Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 324 */             .addGroup(jPanel79Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 325 */               .addComponent((Component)this.materialButton39, -2, 38, -2)
/* 326 */               .addComponent((Component)this.materialButton40, -2, 38, -2)
/* 327 */               .addComponent(this.jComboBox1, -2, -1, -2)
/* 328 */               .addComponent(this.jLabel60)
/* 329 */               .addComponent(this.jLabel61)
/* 330 */               .addComponent(this.jLabel62)
/* 331 */               .addComponent(this.jLabel64))
/* 332 */             .addComponent((Component)this.materialButton38, -1, -1, 32767))
/* 333 */           .addGap(0, 2, 32767)));
/*     */ 
/*     */     
/* 336 */     this.jLabel58.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 337 */     this.jLabel58.setForeground(this.lc.SECUNDARIO1);
/* 338 */     this.jLabel58.setHorizontalAlignment(4);
/* 339 */     this.jLabel58.setText("Proveedor:");
/*     */     
/* 341 */     this.jTextField1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 343 */             ProvFacturasPendientes.this.jTextField1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 347 */     this.jLabel59.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 348 */     this.jLabel59.setForeground(this.lc.SECUNDARIO1);
/* 349 */     this.jLabel59.setHorizontalAlignment(4);
/* 350 */     this.jLabel59.setText("Fecha de Corte:");
/*     */     
/* 352 */     this.jDateChooser1.setDate(this.fechaActual);
/* 353 */     this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
/* 354 */     this.jDateChooser1.setIcon(this.icon);
/* 355 */     this.jDateChooser1.setMinSelectableDate(this.fechaInicio);
/*     */     
/* 357 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/* 358 */     this.jButton1.setMnemonic('F');
/* 359 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 360 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 362 */             ProvFacturasPendientes.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 366 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 367 */     this.jPanel2.setLayout(jPanel2Layout);
/* 368 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 369 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 370 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 371 */           .addComponent(this.jLabel58, -2, 80, -2)
/* 372 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 373 */           .addComponent(this.jTextField1, -2, 197, -2)
/* 374 */           .addGap(56, 56, 56)
/* 375 */           .addComponent(this.jLabel59, -2, 143, -2)
/* 376 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 377 */           .addComponent((Component)this.jDateChooser1, -2, 162, -2)
/* 378 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 379 */           .addComponent(this.jButton1, -2, 28, -2)
/* 380 */           .addContainerGap(73, 32767)));
/*     */     
/* 382 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 383 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 384 */         .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 385 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 386 */             .addComponent(this.jTextField1, -2, -1, -2)
/* 387 */             .addComponent(this.jLabel59, -1, -1, 32767))
/* 388 */           .addComponent(this.jLabel58, -1, -1, 32767))
/* 389 */         .addComponent((Component)this.jDateChooser1, -2, -1, -2)
/* 390 */         .addComponent(this.jButton1));
/*     */ 
/*     */     
/* 393 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 401 */           boolean[] canEdit = new boolean[] { false, false };
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 406 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 409 */     this.rSTableMetro1.setAltoHead(25);
/* 410 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 411 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/* 412 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 413 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/* 414 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 415 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 416 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 417 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 418 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 419 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 420 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 421 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 422 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 423 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 424 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 425 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 426 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 428 */             ProvFacturasPendientes.this.rSTableMetro1MouseClicked(evt);
/*     */           }
/*     */         });
/* 431 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*     */           public void keyReleased(KeyEvent evt) {
/* 433 */             ProvFacturasPendientes.this.rSTableMetro1KeyReleased(evt);
/*     */           }
/*     */         });
/* 436 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro1);
/*     */     
/* 438 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 439 */     this.jPanel1.setLayout(jPanel1Layout);
/* 440 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 441 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 442 */         .addComponent(this.jPanel2, -1, -1, 32767)
/* 443 */         .addComponent(this.jScrollPane33));
/*     */     
/* 445 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 446 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 447 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 448 */           .addContainerGap()
/* 449 */           .addComponent(this.jPanel2, -2, -1, -2)
/* 450 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 451 */           .addComponent(this.jScrollPane33, -1, 276, 32767)));
/*     */ 
/*     */     
/* 454 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 455 */     this.jPanel12.setLayout(jPanel12Layout);
/* 456 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 457 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 458 */         .addComponent(this.jPanel79, -1, -1, 32767)
/* 459 */         .addComponent(this.jPanel50, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 460 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/* 462 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 463 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 464 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 465 */           .addComponent(this.jPanel50, -2, -1, -2)
/* 466 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 467 */           .addComponent(this.jPanel1, -1, -1, 32767)
/* 468 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 469 */           .addComponent(this.jPanel79, -2, -1, -2)));
/*     */ 
/*     */     
/* 472 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 473 */     getContentPane().setLayout(layout);
/* 474 */     layout.setHorizontalGroup(layout
/* 475 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 476 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*     */     
/* 478 */     layout.setVerticalGroup(layout
/* 479 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 480 */         .addGroup(layout.createSequentialGroup()
/* 481 */           .addComponent(this.jPanel12, -1, -1, 32767)
/* 482 */           .addGap(0, 0, 0)));
/*     */ 
/*     */     
/* 485 */     pack();
/*     */   }
/*     */   private JPanel jPanel80; private JScrollPane jScrollPane33; private JTextField jTextField1; private MaterialButton materialButton38; private MaterialButton materialButton39; private MaterialButton materialButton40; private RSTableMetro rSTableMetro1;
/*     */   private void jLabel20MouseDragged(MouseEvent evt) {
/* 489 */     int x = evt.getXOnScreen();
/* 490 */     int y = evt.getYOnScreen();
/* 491 */     setLocation(x - this.xx, y - this.xy);
/*     */   }
/*     */   
/*     */   private void jLabel20MouseClicked(MouseEvent evt) {
/* 495 */     this.xx = evt.getX();
/* 496 */     this.xy = evt.getY();
/*     */   }
/*     */   
/*     */   private void jLabel128MouseClicked(MouseEvent evt) {
/* 500 */     setVisible(false);
/*     */   }
/*     */   
/*     */   private void jLabel128MouseEntered(MouseEvent evt) {
/* 504 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*     */   }
/*     */   
/*     */   private void jLabel128MouseExited(MouseEvent evt) {
/* 508 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*     */   }
/*     */   
/*     */   private void materialButton38ActionPerformed(ActionEvent evt) {
/* 512 */     setVisible(false);
/*     */   }
/*     */   
/*     */   private void materialButton39ActionPerformed(ActionEvent evt) {
/* 516 */     String fechaCompleta = this.utilerias.convertirFechaDateStringBarras(this.jDateChooser1.getDate());
/* 517 */     JTable aux = crearTablaAuxPendientes((JTable)this.rSTableMetro1, new Object[] { "cont", "FRecepcion", "FPago", "Proveedor", "Factura", "FFactura", "Condiciones", "Total", "Debe" });
/* 518 */     Map<Object, Object> datos = new HashMap<>();
/* 519 */     datos.put("sucursal", ((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/* 520 */     datos.put("corte", fechaCompleta);
/* 521 */     datos.put("usuario", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/* 522 */     datos.put("TDebe", this.jLabel64.getText());
/* 523 */     this.utilerias.cargarImagenesAReporte(datos);
/*     */     try {
/* 525 */       this.utilerias.verImpresion("/Reportes/Proveedores/Prov_FacturasPendientes.jasper", aux, datos, "Reporte de fatcuras pendientes al " + fechaCompleta);
/* 526 */     } catch (JRException ex) {
/* 527 */       Logger.getLogger(ProvFacturasPendientes.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void materialButton40ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 536 */     consultar();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void rSTableMetro1MouseClicked(MouseEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 551 */     consultar();
/*     */   }
/*     */   
/*     */   public void colorear() {
/* 555 */     this.pintar.colorear(this.jTextField1);
/* 556 */     this.pintar.colorear(this.jComboBox1);
/*     */   }
/*     */   
/*     */   public String getConsultaSuc() {
/* 560 */     String consulta = " and sucOp like '%" + getPrivilegiosSuc() + "%' ";
/* 561 */     return consulta;
/*     */   }
/*     */   
/*     */   public JTable crearTablaAuxPendientes(JTable Original, Object[] columnas) {
/* 565 */     Object[] Columnas = columnas;
/* 566 */     Object[][] registros = new Object[Original.getRowCount()][Original.getColumnCount() + 1];
/* 567 */     System.out.println("reg " + Original.getRowCount() + " " + Original.getColumnCount() + " " + columnas.length);
/* 568 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 569 */       registros[i][0] = Integer.valueOf(i + 1);
/* 570 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 571 */         if (j == 0) {
/* 572 */           registros[i][1] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*     */         }
/* 574 */         if (j == 1) {
/* 575 */           registros[i][2] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*     */         }
/* 577 */         if (j == 2) {
/* 578 */           registros[i][3] = Original.getValueAt(i, j);
/*     */         }
/* 580 */         if (j == 3) {
/* 581 */           registros[i][4] = Original.getValueAt(i, j).toString();
/*     */         }
/* 583 */         if (j == 4) {
/* 584 */           registros[i][5] = convertirFechaATexto(Original.getValueAt(i, j).toString());
/*     */         }
/* 586 */         if (j == 5) {
/* 587 */           registros[i][6] = Original.getValueAt(i, j).toString();
/*     */         }
/* 589 */         if (j == 6) {
/* 590 */           registros[i][7] = Original.getValueAt(i, j).toString();
/*     */         }
/* 592 */         if (j == 7) {
/* 593 */           registros[i][8] = Original.getValueAt(i, j).toString();
/*     */         }
/*     */       } 
/*     */     } 
/* 597 */     JTable aux = new JTable(registros, Columnas);
/* 598 */     return aux;
/*     */   }
/*     */   
/*     */   public String convertirFechaATexto(String fecha) {
/* 602 */     String fechaCorta = fecha.substring(0, 10);
/* 603 */     String año = fechaCorta.substring(0, 4);
/* 604 */     String mes = fechaCorta.substring(5, 7);
/* 605 */     String dia = fechaCorta.substring(8, 10);
/* 606 */     String strFecha = dia + "/" + dia + "/" + mes;
/* 607 */     return strFecha;
/*     */   }
/*     */   
/*     */   public String getPrivilegiosSuc() {
/* 611 */     String priv = "";
/* 612 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO")) {
/* 613 */       priv = "";
/*     */     } else {
/* 615 */       priv = this.CAMPOSGENERALES.get("sucursal");
/*     */     } 
/* 617 */     return priv;
/*     */   }
/*     */   
/*     */   public double convertirCantTexto(String cant) {
/* 621 */     String canti = cant;
/* 622 */     String valorP = "";
/* 623 */     for (int j = 0; j < canti.length(); j++) {
/* 624 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 625 */         valorP = valorP + valorP;
/*     */       }
/*     */     } 
/* 628 */     return Double.parseDouble(valorP);
/*     */   }
/*     */   
/*     */   public void consultar() {
/* 632 */     Date fecha1 = this.jDateChooser1.getDate();
/* 633 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 634 */     String cadenaFecha = "";
/* 635 */     cadenaFecha = formato.format(fecha1);
/* 636 */     String AÑO = cadenaFecha.substring(0, 4);
/* 637 */     String MES = cadenaFecha.substring(4, 6);
/* 638 */     String DIA = cadenaFecha.substring(6, 8);
/* 639 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 640 */     String v = this.jComboBox1.getSelectedItem().toString();
/*     */     
/* 642 */     String proveedor = "";
/* 643 */     if (!this.jTextField1.getText().equals(this.holderCliente)) {
/* 644 */       proveedor = this.jTextField1.getText();
/*     */     }
/*     */     
/* 647 */     if (v.equals("GENERAL")) {
/* 648 */       v = "";
/*     */     }
/*     */     
/* 651 */     (new String[9])[0] = "Recepción"; (new String[9])[1] = "Pago"; (new String[9])[2] = "Proveedor"; (new String[9])[3] = "Factura"; (new String[9])[4] = "Fecha Factura"; (new String[9])[5] = "Condiciones"; (new String[9])[6] = "Total"; (new String[9])[7] = "Debe"; (new String[9])[8] = "Sucursal"; this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(9, "fechaRecepcion, fechaPago, proveedor, folioComp, fechaFactura, condiciones, total, totalDebe, sucOp", "prov_facturas", "where ( estado ='<Por Pagar>' || estado like '%Abono:%') and fechaPago<=" + fechaCompleta1 + 
/* 652 */             getConsultaSuc() + " and sucOp like '%" + v + "%' and proveedor like '%" + proveedor + "%' order by proveedor, fechaPago asc"), (Object[])new String[9])
/*     */         {
/* 654 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 657 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/* 660 */     if (this.rSTableMetro1.getRowCount() > 0) {
/* 661 */       this.jLabel61.setText("" + this.rSTableMetro1.getRowCount());
/* 662 */       this.jLabel64.setText("$0.00");
/* 663 */       double valorT = 0.0D;
/* 664 */       for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 665 */         valorT += convertirCantTexto(this.rSTableMetro1.getValueAt(i, 7).toString());
/* 666 */         this.cantidad.setValue(Double.valueOf(valorT));
/* 667 */         this.jLabel64.setText(this.cantidad.getText());
/*     */       } 
/* 669 */       this.rSTableMetro1.setSelectionMode(0);
/* 670 */       this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 671 */       this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 672 */       this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(200);
/* 673 */       this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(200);
/* 674 */       this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(65);
/* 675 */       this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(65);
/* 676 */       this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(65);
/* 677 */       this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(65);
/* 678 */       this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 679 */       this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 680 */       this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda3);
/* 681 */       this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda3);
/* 682 */       this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda3);
/* 683 */       this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda3);
/* 684 */       this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda3);
/* 685 */       this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda3);
/* 686 */       this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda3);
/* 687 */       this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/*     */     } 
/*     */   }
/*     */   
/*     */   class CeldaRender3
/*     */     extends DefaultTableCellRenderer {
/* 693 */     int otro = -1;
/*     */     
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 696 */       setEnabled((table == null || table.isEnabled()));
/* 697 */       if (row % 2 == 0) {
/* 698 */         setBackground(ProvFacturasPendientes.this.lc.FONDOTABLA);
/*     */       } else {
/* 700 */         setBackground((Color)null);
/*     */       } 
/* 702 */       if (column == 6 || column == 7) {
/* 703 */         setHorizontalAlignment(4);
/*     */       } else {
/* 705 */         setHorizontalAlignment(2);
/*     */       } 
/* 707 */       if (column == 1) {
/* 708 */         setBackground(ProvFacturasPendientes.this.lc.SECUNDARIO2);
/*     */       }
/* 710 */       setForeground(ProvFacturasPendientes.this.lc.SECUNDARIO1);
/* 711 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 712 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ProvFacturasPendientes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */