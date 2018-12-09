package shahir;




import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import zubair.Compress;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;



public class Watermark_Function extends javax.swing.JFrame {
    private Component File;
    private javax.swing.JFileChooser ImageFileChoose;
    private javax.swing.JButton btn_Browse_button;
    private javax.swing.JButton btn_Browse_Button_02;
    private javax.swing.JButton btn_Browse_3;
    private javax.swing.JButton btn_Choose_for_Text_File;
    private javax.swing.JButton btn_Hide_Mark;
    private javax.swing.JButton btn_Embed;
    private javax.swing.JButton btn_Retrieve_Mark;
    private javax.swing.JButton btn_Save;
    private javax.swing.JScrollPane j_Retrieved_Text_Pane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea j_Retrieved_Data;
    private javax.swing.JLabel lblCustTxt;
    private javax.swing.JLabel lbl_Suggestion;
    private javax.swing.JLabel lblInfo2;
    private javax.swing.JLabel lbl_Msg;
    private javax.swing.JLabel lbl_Retrieve_Watermark;
    private javax.swing.JLabel lbl_Select_text_File;
    private javax.swing.JLabel lblSelectImage;
    private javax.swing.JLabel lbl_Select_Image_File_2;
    private javax.swing.JLabel lbl_Select_Image_for_Retrieving;
    private javax.swing.JLabel lbl_information_3;
    private javax.swing.JPanel pnl_Invisible_Watermark;
    private javax.swing.JPanel pnl_Visible_Watermark;
    private javax.swing.JPanel pnl_Retrieve;
    private javax.swing.JTextField txt_Image_Loc2;
    private javax.swing.JTextField txt_Image_loc;
    private javax.swing.JTextField txt_Imageloc_4;
    private javax.swing.JTextField txt_Select_File;
    private javax.swing.JTextField txt_Target_Image_Loc;
    private javax.swing.JTextField txt_for_Visible_WaterMark;
    private JTextField text_Select_Compress_Image_loc;
    private JTextField text_Compressed_loc;
    

    
    public Watermark_Function() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\pictures\\home-icon.png"));
        initComponents();
        lbl_Msg.setText("Please choose image file and text file (*.txt)");
        lbl_Suggestion.setText("Use : c:/ <filename>.<jpg>");
        txt_Image_loc.setText("");
        txt_Target_Image_Loc.setText("");
        txt_for_Visible_WaterMark.setText("");
    
        
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        ImageFileChoose = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnl_Visible_Watermark = new javax.swing.JPanel();
        txt_Image_loc = new javax.swing.JTextField();
        btn_Browse_button = new javax.swing.JButton();
        txt_for_Visible_WaterMark = new javax.swing.JTextField();
        btn_Embed = new javax.swing.JButton();
        btn_Embed.setText("Embed");
        lbl_Suggestion = new javax.swing.JLabel();
        txt_Target_Image_Loc = new javax.swing.JTextField();
        lblInfo2 = new javax.swing.JLabel();
        lblCustTxt = new javax.swing.JLabel();
        lblSelectImage = new javax.swing.JLabel();
        pnl_Invisible_Watermark = new javax.swing.JPanel();
        lbl_Select_Image_File_2 = new javax.swing.JLabel();
        txt_Image_Loc2 = new javax.swing.JTextField();
        btn_Browse_Button_02 = new javax.swing.JButton();
        lbl_Select_text_File = new javax.swing.JLabel();
        txt_Select_File = new javax.swing.JTextField();
        btn_Choose_for_Text_File = new javax.swing.JButton();
        btn_Hide_Mark = new javax.swing.JButton();
        lbl_Msg = new javax.swing.JLabel();
        pnl_Retrieve = new javax.swing.JPanel();
        lbl_Select_Image_for_Retrieving = new javax.swing.JLabel();
        txt_Imageloc_4 = new javax.swing.JTextField();
        btn_Browse_3 = new javax.swing.JButton();
        lbl_Retrieve_Watermark = new javax.swing.JLabel();
        j_Retrieved_Text_Pane1 = new javax.swing.JScrollPane();
        j_Retrieved_Data = new javax.swing.JTextArea();
        btn_Retrieve_Mark = new javax.swing.JButton();
        lbl_information_3 = new javax.swing.JLabel();
        btn_Save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Compressor / Digital Watermark");
        
        
        
        
        
        //===============================================    Visible Watermarking area    ===================================================

        txt_Image_loc.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        txt_Image_loc.setToolTipText(" Image path for Watermarking ");
        btn_Browse_button.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        btn_Browse_button.setText("Browse...");
        btn_Browse_button.setToolTipText("Click to choose Image file");
        btn_Browse_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 btn_Browse_ActionPerformed(evt);
            }
        });

        txt_for_Visible_WaterMark.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        txt_for_Visible_WaterMark.setToolTipText("Write whatever you want to hide");
        btn_Embed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btn_Embed_ActionPerformed(evt);
            }
        });

        lbl_Suggestion.setText("Use : c:/ <filename>.<jpg>");

        txt_Target_Image_Loc.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        txt_Target_Image_Loc.setToolTipText("Targeted folder path for the Watermarked Image");

        lblInfo2.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        lblInfo2.setText(" Destination Path");
        

        lblCustTxt.setFont(new java.awt.Font("Ubuntu", 0, 12));
        lblCustTxt.setText("Text for Visible Watermarking");
        

        lblSelectImage.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        lblSelectImage.setText("Select Image");

        javax.swing.GroupLayout gl_pnl_Visible_Watermark = new javax.swing.GroupLayout(pnl_Visible_Watermark);
        pnl_Visible_Watermark.setLayout(gl_pnl_Visible_Watermark);
        gl_pnl_Visible_Watermark.setHorizontalGroup(
            gl_pnl_Visible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_pnl_Visible_Watermark.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_pnl_Visible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_for_Visible_WaterMark)
                    .addGroup(gl_pnl_Visible_Watermark.createSequentialGroup()
                        .addComponent(lbl_Suggestion, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
                        .addComponent(btn_Embed))
                    .addComponent(txt_Target_Image_Loc)
                    .addGroup(gl_pnl_Visible_Watermark.createSequentialGroup()
                        .addComponent(txt_Image_loc)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Browse_button))
                    .addGroup(gl_pnl_Visible_Watermark.createSequentialGroup()
                        .addGroup(gl_pnl_Visible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInfo2)
                            .addComponent(lblCustTxt)
                            .addComponent(lblSelectImage))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        gl_pnl_Visible_Watermark.setVerticalGroup(
            gl_pnl_Visible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_pnl_Visible_Watermark.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSelectImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_pnl_Visible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Image_loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Browse_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCustTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_for_Visible_WaterMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Target_Image_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_pnl_Visible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Embed)
                    .addComponent(lbl_Suggestion))
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("Visible Watermark", pnl_Visible_Watermark);
        
        
        
        //===============================================   Invisible Watermarking area   ===================================================

        lbl_Select_Image_File_2.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        lbl_Select_Image_File_2.setText("Select Image");
        lbl_Select_Image_File_2.setToolTipText("Image for hidding any text");

        txt_Image_Loc2.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        txt_Image_Loc2.setToolTipText("Text file for hidding");

        btn_Browse_Button_02.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        btn_Browse_Button_02.setText("Browse..");
        btn_Browse_Button_02.setToolTipText("Browse for image file");
        btn_Browse_Button_02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btn_Browse_for_invisibleWaterMarking_ActionPerformed(evt);
            }
        });

        lbl_Select_text_File.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        lbl_Select_text_File.setText("Select a Text File");
        lbl_Select_text_File.setToolTipText("Text file for Hidding");
        txt_Select_File.setFont(new java.awt.Font("Ubuntu", 0, 12)); 

        btn_Choose_for_Text_File.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        btn_Choose_for_Text_File.setToolTipText("Search the Desired Text file");
        btn_Choose_for_Text_File.setText("Choose File");
        btn_Choose_for_Text_File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btn_Text_File_for_Hidding_ActionPerformed(evt);
            }
        });

        btn_Hide_Mark.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        btn_Hide_Mark.setText("Hide Text");
        
        btn_Hide_Mark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btn_Invisible_WaterMarking_ActionPerformed(evt);
            }
        });

        lbl_Msg.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        lbl_Msg.setText("Select an Image file and a Text file (*.txt)");

        javax.swing.GroupLayout gl_pnl_Invisible_Watermark = new javax.swing.GroupLayout(pnl_Invisible_Watermark);
        pnl_Invisible_Watermark.setLayout(gl_pnl_Invisible_Watermark);
        gl_pnl_Invisible_Watermark.setHorizontalGroup(
            gl_pnl_Invisible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_pnl_Invisible_Watermark.createSequentialGroup()
                .addGroup(gl_pnl_Invisible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gl_pnl_Invisible_Watermark.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gl_pnl_Invisible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Select_text_File)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_pnl_Invisible_Watermark.createSequentialGroup()
                                .addComponent(lbl_Select_Image_File_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Image_Loc2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Browse_Button_02))
                            .addGroup(gl_pnl_Invisible_Watermark.createSequentialGroup()
                                .addComponent(txt_Select_File, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Choose_for_Text_File))))
                    .addGroup(gl_pnl_Invisible_Watermark.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(btn_Hide_Mark)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(gl_pnl_Invisible_Watermark.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(lbl_Msg, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pnl_Invisible_Watermark.setVerticalGroup(
            gl_pnl_Invisible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_pnl_Invisible_Watermark.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_pnl_Invisible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Select_Image_File_2)
                    .addComponent(txt_Image_Loc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Browse_Button_02))
                .addGap(18, 18, 18)
                .addComponent(lbl_Select_text_File)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_pnl_Invisible_Watermark.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Select_File, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Choose_for_Text_File))
                .addGap(48, 48, 48)
                .addComponent(btn_Hide_Mark)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Msg)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Invisible Watermark", pnl_Invisible_Watermark);

        lbl_Select_Image_for_Retrieving.setFont(new java.awt.Font("Ubuntu", 0, 12));
        lbl_Select_Image_for_Retrieving.setText("Select Image");
        
        
        //===============================================   Retrieving Area   ===================================================
        
        txt_Imageloc_4.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        txt_Imageloc_4.setToolTipText("The Watermarked Image");
        btn_Browse_3.setFont(new java.awt.Font("Ubuntu", 0, 12));
        btn_Browse_3.setText("Browse");
        btn_Browse_3.setToolTipText("Browse the Watermarked Image");
        btn_Browse_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btn_Browse_for_Retrieving_Watermark_ActionPerformed(evt);
            }
        });

        lbl_Retrieve_Watermark.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        lbl_Retrieve_Watermark.setText("Retreive WaterMark");

        j_Retrieved_Data.setColumns(20);
        j_Retrieved_Data.setRows(5);
        j_Retrieved_Text_Pane1.setViewportView(j_Retrieved_Data);

        btn_Retrieve_Mark.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        btn_Retrieve_Mark.setText("Retrieve");
        btn_Retrieve_Mark.setToolTipText("Click to extract hidden data");
        btn_Retrieve_Mark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btn_Retrieve_Text_Data_from_WaterMarked_Image_ActionPerformed(evt);
            }
        });

        lbl_information_3.setFont(new java.awt.Font("Ubuntu", 0, 12)); 

        btn_Save.setFont(new java.awt.Font("Ubuntu", 0, 12)); 
        btn_Save.setText("Save ");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btn_Save_as_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gl_pnl_Retrieve = new javax.swing.GroupLayout(pnl_Retrieve);
        pnl_Retrieve.setLayout(gl_pnl_Retrieve);
        gl_pnl_Retrieve.setHorizontalGroup(
            gl_pnl_Retrieve.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_pnl_Retrieve.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_pnl_Retrieve.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_pnl_Retrieve.createSequentialGroup()
                        .addGroup(gl_pnl_Retrieve.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gl_pnl_Retrieve.createSequentialGroup()
                                .addComponent(lbl_Select_Image_for_Retrieving)
                                .addGap(18, 18, 18)
                                .addComponent(txt_Imageloc_4, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(j_Retrieved_Text_Pane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(gl_pnl_Retrieve.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gl_pnl_Retrieve.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_Browse_3))
                            .addGroup(gl_pnl_Retrieve.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btn_Save))))
                    .addGroup(gl_pnl_Retrieve.createSequentialGroup()
                        .addComponent(lbl_Retrieve_Watermark)
                        .addGap(101, 101, 101)
                        .addComponent(lbl_information_3, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Retrieve_Mark)))
                .addContainerGap())
        );
        gl_pnl_Retrieve.setVerticalGroup(
            gl_pnl_Retrieve.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_pnl_Retrieve.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_pnl_Retrieve.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Select_Image_for_Retrieving)
                    .addComponent(txt_Imageloc_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Browse_3))
                .addGroup(gl_pnl_Retrieve.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gl_pnl_Retrieve.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(gl_pnl_Retrieve.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Retrieve_Watermark)
                            .addComponent(lbl_information_3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(gl_pnl_Retrieve.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Retrieve_Mark)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_pnl_Retrieve.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Save)
                    .addComponent(j_Retrieved_Text_Pane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Retrieve", pnl_Retrieve);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        
        
//===============================================   Compression Area   ==============================================================
        
        
        JPanel pnl_Compression = new JPanel();
        jTabbedPane1.addTab("Compress", null, pnl_Compression, null);
        
        JLabel lblSelectImage01 = new JLabel("Select Image");
        
        text_Select_Compress_Image_loc = new JTextField();
        text_Select_Compress_Image_loc.setColumns(10);
        text_Select_Compress_Image_loc.setToolTipText("Desired Image Path");
        
        JLabel lbl_Compressed_Image_Destination = new JLabel("Destination Path");
        
        text_Compressed_loc = new JTextField();
        text_Compressed_loc.setColumns(10);
        text_Compressed_loc.setToolTipText("Compressed Image Path");
        
        JButton btn_Browse_button_Compress = new JButton("Browse");
        btn_Browse_button_Compress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btn_Browse_for_Compress_ActionPerformed(evt);
            }
        });
        
        
        
        
        JButton btn_Compress_Image = new JButton("Compress");
        btn_Compress_Image.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		btn_Compress_Imagae_ActionPerformed(evt);
        	}
        });
        
        GroupLayout gl_pnl_Compression = new GroupLayout(pnl_Compression);
        gl_pnl_Compression.setHorizontalGroup(
        	gl_pnl_Compression.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnl_Compression.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pnl_Compression.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblSelectImage01)
        				.addGroup(gl_pnl_Compression.createSequentialGroup()
        					.addComponent(text_Select_Compress_Image_loc, GroupLayout.PREFERRED_SIZE, 661, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(btn_Browse_button_Compress))
        				.addGroup(Alignment.TRAILING, gl_pnl_Compression.createSequentialGroup()
        					.addGroup(gl_pnl_Compression.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbl_Compressed_Image_Destination)
        						.addComponent(text_Compressed_loc))
        					.addGap(96))
        				.addComponent(btn_Compress_Image, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        gl_pnl_Compression.setVerticalGroup(
        	gl_pnl_Compression.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnl_Compression.createSequentialGroup()
        			.addGap(24)
        			.addComponent(lblSelectImage01)
        			.addGap(18)
        			.addGroup(gl_pnl_Compression.createParallelGroup(Alignment.BASELINE)
        				.addComponent(text_Select_Compress_Image_loc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_Browse_button_Compress))
        			.addGap(27)
        			.addComponent(lbl_Compressed_Image_Destination)
        			.addGap(18)
        			.addComponent(text_Compressed_loc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(27)
        			.addComponent(btn_Compress_Image, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addGap(27))
        );
        pnl_Compression.setLayout(gl_pnl_Compression);
        
    }
    
    // =============================================   initComponents Ends   ==================================================

    private void btn_Browse_ActionPerformed(java.awt.event.ActionEvent evt) {// event_ btn_Browse_ActionPerformed
        lbl_Suggestion.setText("Use : c:/ <filename>.<jpg>");
        int retVal = ImageFileChoose.showOpenDialog(File);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg", "PNG file", "png");
         if (retVal== JFileChooser.APPROVE_OPTION) {
            ImageFileChoose.setFileFilter(filter);
            txt_Image_loc.setText(ImageFileChoose.getSelectedFile().getAbsolutePath());
         }
         txt_Target_Image_Loc.setText(txt_Image_loc.getText());
    }

    private void btn_Embed_ActionPerformed(java.awt.event.ActionEvent evt) {// event_btn_Embed_ActionPerformed
        System.out.println(txt_Image_loc.getText());
        
              
        try {
                File file = new File(txt_Image_loc.getText());
                if (!file.exists()) {
                        JOptionPane.showMessageDialog(this, "Please select Image", "Warning", JOptionPane.ERROR_MESSAGE);
                }
                    
            ImageIcon icon = new ImageIcon(file.getPath());
            BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) bufferedImage.getGraphics();
            g2d.drawImage(icon.getImage(), 0, 0, null);
            AlphaComposite alpha = AlphaComposite.getInstance(
            AlphaComposite.SRC_OVER, 0.5f);
            g2d.setComposite(alpha);
            g2d.setColor(Color.white);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setFont(new Font("Arial", Font.BOLD, 30));
            String watermark = txt_for_Visible_WaterMark.getText();
            FontMetrics fontMetrics = g2d.getFontMetrics();
            Rectangle2D rect = fontMetrics.getStringBounds(watermark, g2d);
            g2d.drawString(watermark, (icon.getIconWidth() - (int) rect
            .getWidth()) / 2, (icon.getIconHeight() - (int) rect
            .getHeight()) / 2);
            g2d.dispose();
            File fileout = new File(txt_Target_Image_Loc.getText());
            ImageIO.write(bufferedImage, "jpg", fileout);
            lbl_Suggestion.setText("Water Marking Successful");
        } catch (IOException ioe) {
            }
    }

    private void btn_Browse_for_invisibleWaterMarking_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Browse_for_invisibleWaterMarking_ActionPerformed
         lbl_Msg.setText("Please choose image file and text file (*.txt)");
        int retVal = ImageFileChoose.showOpenDialog(File);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg", "PNG file", "png");
         if (retVal== JFileChooser.APPROVE_OPTION) {
            ImageFileChoose.setFileFilter(filter);
            txt_Image_Loc2.setText(ImageFileChoose.getSelectedFile().getAbsolutePath());
         }
         
    }
    private void btn_Text_File_for_Hidding_ActionPerformed(java.awt.event.ActionEvent evt) {//event_btn_Text_File_for_Hidding_ActionPerformed
         lbl_Msg.setText("Please choose image file and text file (*.txt)");
        int retVal = ImageFileChoose.showOpenDialog(File);
        if (retVal== JFileChooser.APPROVE_OPTION) {        
            txt_Select_File.setText(ImageFileChoose.getSelectedFile().getAbsolutePath());
         }
         
    }

    private void btn_Invisible_WaterMarking_ActionPerformed(java.awt.event.ActionEvent evt) {//event_btn_Invisible_WaterMarking_ActionPerformed
        String Image_Address = txt_Image_Loc2.getText();
        String File_Address = txt_Select_File.getText();
        
        Watermark  steg = new Watermark ();
        steg.invisible_Watermark(File_Address, Image_Address);
        lbl_Msg.setText("File Processed Successful");
    }

    private void btn_Browse_for_Retrieving_Watermark_ActionPerformed(java.awt.event.ActionEvent evt) {//event_btn_Browse_for_Retrieving_Watermark_ActionPerformed
       lbl_information_3.setText("");
        int retVal = ImageFileChoose.showOpenDialog(File);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg", "PNG file", "png");
         if (retVal== JFileChooser.APPROVE_OPTION) {
            ImageFileChoose.setFileFilter(filter);
            txt_Imageloc_4.setText(ImageFileChoose.getSelectedFile().getAbsolutePath());
         }
    }

    private void btn_Retrieve_Text_Data_from_WaterMarked_Image_ActionPerformed(java.awt.event.ActionEvent evt) {//event_btn_Retrieve_Text_Data_from_WaterMarked_Image_ActionPerformed
        String Image_Address = txt_Imageloc_4.getText();
        Watermark  steg = new Watermark ();
        String retrieved_Msg = steg.reveal(Image_Address);
        j_Retrieved_Data.setText(retrieved_Msg);
        lbl_information_3.setText("File Processed Successful");
    }

    private void btn_Save_as_ActionPerformed(java.awt.event.ActionEvent evt) {//event_btn_Save_as_ActionPerformed
    	Watermark  steg = new Watermark ();
        String end_Msg = steg.save();
        lbl_information_3.setText("File saved with a name " + end_Msg);
    }

    private void btn_Browse_for_Compress_ActionPerformed(java.awt.event.ActionEvent evt) {// event_btn_Browse_for_Compress_ActionPerformed
        lbl_Suggestion.setText("Use : c:/ <filename>.<jpg>");
        int retVal = ImageFileChoose.showOpenDialog(File);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG file", "png", "bmp", "BMP");
         if (retVal== JFileChooser.APPROVE_OPTION) {
            ImageFileChoose.setFileFilter(filter);
            text_Select_Compress_Image_loc.setText(ImageFileChoose.getSelectedFile().getAbsolutePath());
         }
         text_Compressed_loc.setText(text_Select_Compress_Image_loc.getText());
    }
    
    
    private void btn_Compress_Imagae_ActionPerformed(java.awt.event.ActionEvent evt) {
    	String imgLoc = text_Select_Compress_Image_loc.getText();
    	String comImg = text_Compressed_loc.getText();
    	Compress cImg = new Compress();
    	cImg.Compress_Image(imgLoc, comImg);
    	
    }
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Watermark_Function.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Watermark_Function.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Watermark_Function.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Watermark_Function.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Watermark_Function().setVisible(true);
            }
        });
    }  
}

