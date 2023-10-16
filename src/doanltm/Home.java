
package doanltm;

import CLIENT.MyConnection;
import Thi.Thi;
import java.util.List;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import taodethi.ExamInfo;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import taodethi.Taodethi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.ResultSet;
import java.util.Collections;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Home extends javax.swing.JFrame {
    private ExamInfo examInfo;
   private DefaultTableModel tableModel;
   private DefaultTableModel tableMode2;
   private List<ExamInfo> examList; // Danh sách các bài đăng
   
     private String currentUsername; // Biến lưu trữ tên người dùng hiện tại
    private String currentEmail; // Biến lưu trữ địa chỉ email hiện tại
    private String currentGender; // Biến lưu trữ giới tính hiện tại
    private String currentBirthdate; // Biến lưu trữ ngày sinh hiện tại
    private int newGender;
    private int userId;

    
    
    
    public int getSelectedQuestionQuantity() {
        // Lấy số lượng câu hỏi mà người dùng đã chọn từ combobox
        return Integer.parseInt(Soluongcauhoi.getSelectedItem().toString());
    }

   private static Home instance;
   public void initializeExam() {
    // ...

    // Đặt giá trị mặc định cho các JTextField
    monhoc.setText("");
    maphongthi.setText("");
    NguoiTao.setText("");
    Soluongcauhoi.setSelectedIndex(0); // Đặt giá trị mặc định cho combobox

    // ...
}
   
   
   public void setUserInfo(String username, String email, String gender, String birthdate) {
    currentUsername = username;
    currentEmail = email;
    currentGender = gender;
    currentBirthdate = birthdate;
}
   private ButtonGroup genderButtonGroup;
public void displayUserInfo(String username, String email, String gender, String birthdate) {
   nguoidung.setText(username);
    gmail.setText(email);
    genderButtonGroup = new ButtonGroup();
genderButtonGroup.add(jRadioButton1);
genderButtonGroup.add(jRadioButton2);
   if (gender != null) {
    if (gender.equals("Nam")) {
        jRadioButton1.setSelected(true);
        jRadioButton2.setSelected(false);
    } else if (gender.equals("Nữ")) {
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(true);
    } else {
        genderButtonGroup.clearSelection();
    }
} else {
    genderButtonGroup.clearSelection();
}

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    if (birthdate != null) {
        try {
            Date dateOfBirth = sdf.parse(birthdate);
            ngaysinh.setDate(dateOfBirth);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
}
public void refreshUserInfo() {
    displayUserInfo(currentUsername, currentEmail, currentGender, currentBirthdate);
}

public String getCurrentUsername() {
    return currentUsername;
}

public String getCurrentGender() {
    return currentGender;
}



public Home() {
        initComponents();
        
         // Tạo bảng và đặt mô hình dữ liệu
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Môn học");
        tableModel.addColumn("Mã phòng thi");
        tableModel.addColumn("Thời gian thi");
        tableModel.addColumn("Số lượng câu hỏi");
        tableModel.addColumn("Người tạo");
        jTable1.setModel(tableModel);
         // Tạo mô hình dữ liệu cho jTable2
        DefaultTableModel tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("ID");
        tableModel2.addColumn("Câu hỏi");
        tableModel2.addColumn("Đáp án A");
        tableModel2.addColumn("Đáp án B");
        tableModel2.addColumn("Đáp án C");
        tableModel2.addColumn("Đáp án D");
        tableModel2.addColumn("Đáp án đúng");
        jTable2.setModel(tableModel2);
       
        
        examList = new ArrayList<>(); // Khởi tạo danh sách các bài đăng
    }

 public static Home getInstance() {
        if (instance == null) {
            instance = new Home();
        }
        return instance;
    }
    
    public void addExamInfoToTable(ExamInfo examInfo) {
    // Thêm đối tượng examInfo vào mô hình bảng
    Object[] rowData = { examInfo.getMonHoc(), examInfo.getMaPhongThi(), examInfo.getThoiGian(),
                         examInfo.getSoLuongCauHoi(), examInfo.getNguoiTaoDe() };
    tableModel.addRow(rowData);
}


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jp1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Soluongcauhoi = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        monhoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        maphongthi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Thoigian = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        NguoiTao = new javax.swing.JTextField();
        jButton_Taodethi = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        capnhat = new javax.swing.JButton();
        xoadethi = new javax.swing.JButton();
        jb4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bang4 = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        songuoithi = new javax.swing.JLabel();
        diemcaonhat = new javax.swing.JLabel();
        diemthapnhat = new javax.swing.JLabel();
        diemtrungbinh = new javax.swing.JLabel();
        jp3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        gmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        ngaysinh = new com.toedter.calendar.JDateChooser();
        update = new javax.swing.JButton();
        nguoidung = new javax.swing.JTextField();
        jp2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bang3 = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(51, 77, 94));

        tab1.setBackground(new java.awt.Color(0, 92, 153));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quản Lý Đề Thi");

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tab2.setBackground(new java.awt.Color(79, 106, 127));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thi");

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tab3.setBackground(new java.awt.Color(79, 106, 127));
        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quản Lý Người Dùng");

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tab4.setBackground(new java.awt.Color(79, 106, 127));
        tab4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab4MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Thống Kê");

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanltm/4021693.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.CardLayout());

        jp1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Danh Sách Đề Thi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(418, 418, 418)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        Soluongcauhoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Soluongcauhoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", " ", " ", " ", " ", " ", " ", " " }));
        Soluongcauhoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoluongcauhoiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Số Lượng Câu Hỏi");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Môn Học");

        monhoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        monhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monhocActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Mã Phòng Thi");

        maphongthi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        maphongthi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maphongthiActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Thời Gian");

        Thoigian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Thoigian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3\t", "6", "9", "12", "15", "18", "21", "24", "27", "30", "33", "36", "39", "42", "45", "48", "51", "54", "57", "60" }));
        Thoigian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThoigianActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Phút");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel16.setPreferredSize(new java.awt.Dimension(35, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Người Tạo");

        NguoiTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NguoiTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NguoiTaoActionPerformed(evt);
            }
        });

        jButton_Taodethi.setBackground(new java.awt.Color(0, 204, 51));
        jButton_Taodethi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton_Taodethi.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Taodethi.setText("TẠO ĐỀ THI");
        jButton_Taodethi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TaodethiActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tiêu Đề", "Phòng", "Title 4", "Thời Gian", "Người Tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setText("Danh Sách Bài Thi");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Câu Hỏi", "A", "B", "C", "D", "Ans"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setText("Danh Sách Câu Hỏi");

        capnhat.setBackground(new java.awt.Color(255, 102, 51));
        capnhat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        capnhat.setForeground(new java.awt.Color(255, 255, 255));
        capnhat.setText("CẬP NHẬT");
        capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatActionPerformed(evt);
            }
        });

        xoadethi.setBackground(new java.awt.Color(255, 51, 0));
        xoadethi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        xoadethi.setForeground(new java.awt.Color(255, 255, 255));
        xoadethi.setText("XÓA");
        xoadethi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoadethiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Soluongcauhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(monhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel17)
                            .addComponent(maphongthi, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp1Layout.createSequentialGroup()
                                .addComponent(Thoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15)))
                    .addComponent(NguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 124, Short.MAX_VALUE)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Taodethi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xoadethi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(capnhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(137, 137, 137))
            .addComponent(jSeparator2)
            .addGroup(jp1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addContainerGap())))
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maphongthi)
                            .addComponent(monhoc)
                            .addComponent(Thoigian)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Soluongcauhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NguoiTao)))
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addComponent(jButton_Taodethi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xoadethi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(11, 11, 11)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
        );

        jPanel3.add(jp1, "card2");

        jb4.setBackground(new java.awt.Color(0, 0, 0));

        jPanel8.setBackground(new java.awt.Color(255, 51, 51));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("THỐNG KÊ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(469, 469, 469))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel26)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        bang4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Môn Học", "Mã Phòng Thi", "Thời Gian Thi", "Số Lượng Câu Hỏi", "Người Tạo"
            }
        ));
        bang4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bang4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(bang4);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 0));
        jLabel27.setText("Số Người Thi:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 0));
        jLabel28.setText("Điểm Cao Nhất:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 0));
        jLabel29.setText("Điểm Thấp Nhất:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 0));
        jLabel30.setText("Điểm Trung Bình:");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanltm/6032316 (1).png"))); // NOI18N
        jLabel31.setText("jLabel31");

        songuoithi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        songuoithi.setForeground(new java.awt.Color(255, 255, 255));

        diemcaonhat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        diemcaonhat.setForeground(new java.awt.Color(255, 255, 255));

        diemthapnhat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        diemthapnhat.setForeground(new java.awt.Color(255, 255, 255));

        diemtrungbinh.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        diemtrungbinh.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jb4Layout = new javax.swing.GroupLayout(jb4);
        jb4.setLayout(jb4Layout);
        jb4Layout.setHorizontalGroup(
            jb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jb4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jb4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(songuoithi, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(diemtrungbinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(diemthapnhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(diemcaonhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jb4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jb4Layout.setVerticalGroup(
            jb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jb4Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jb4Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(jb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(songuoithi))
                        .addGap(18, 18, 18)
                        .addGroup(jb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(diemcaonhat))
                        .addGap(18, 18, 18)
                        .addGroup(jb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(diemthapnhat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jb4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(diemtrungbinh))
                        .addGap(52, 52, 52)
                        .addComponent(jLabel31))
                    .addGroup(jb4Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 149, Short.MAX_VALUE))
        );

        jPanel3.add(jb4, "card3");

        jp3.setBackground(new java.awt.Color(255, 255, 255));
        jp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp3MouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanltm/147142.png"))); // NOI18N
        jLabel10.setText("jLabel10");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Tên Người Dùng:");

        gmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        gmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gmailActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Email:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Giới Tính:");

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jRadioButton1.setText("Nam");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jRadioButton2.setText("Nữ");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Ngày Sinh");

        ngaysinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ngaysinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ngaysinhMouseClicked(evt);
            }
        });

        update.setBackground(new java.awt.Color(204, 204, 204));
        update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon("C:\\Users\\letra\\OneDrive\\Documents\\vinh.png")); // NOI18N
        update.setText("Cập Nhật Thông Tin Cá Nhân");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        nguoidung.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        nguoidung.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nguoidung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nguoidungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp3Layout = new javax.swing.GroupLayout(jp3);
        jp3.setLayout(jp3Layout);
        jp3Layout.setHorizontalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jp3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp3Layout.createSequentialGroup()
                        .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp3Layout.createSequentialGroup()
                                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70))
                            .addGroup(jp3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)))
                        .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jp3Layout.createSequentialGroup()
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gmail, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nguoidung)))
                    .addComponent(update))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jp3Layout.setVerticalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp3Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel10))
                    .addGroup(jp3Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(nguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(45, 45, 45)
                        .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(29, 29, 29)
                        .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addComponent(update)
                .addGap(0, 259, Short.MAX_VALUE))
        );

        jPanel3.add(jp3, "card4");

        jp2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("DANH SÁCH ĐỀ THI");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(431, 431, 431))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(26, 26, 26))
        );

        jPanel7.setBackground(new java.awt.Color(255, 153, 0));
        jPanel7.setForeground(new java.awt.Color(0, 255, 255));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Hướng Dẫn:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("- Chọn vào đề thi muốn thi ở bảng bên dưới.");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("- Hệ thống sẽ chuyển đến phần thi dành cho bạn.");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanltm/4305432 (3).png"))); // NOI18N

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanltm/multiple-cjoice.png"))); // NOI18N

        bang3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bang3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Môn Học", "Mã Phòng Thi", "Thời Gian Thi", "Số Lượng Câu Hỏi Hỏi", "Người Tạo"
            }
        ));
        bang3.setShowVerticalLines(true);
        bang3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bang3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(bang3);

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp2Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel24)
                .addGap(118, 118, 118)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addGroup(jp2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel24))
                    .addGroup(jp2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
        );

        jPanel3.add(jp2, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
       jp1.setVisible(true);
       jp2.setVisible(false);
       jp3.setVisible(false);
       jb4.setVisible(false);
       tab1.setBackground(new Color(0, 92, 153));
       tab2.setBackground(new Color(150, 180, 200));
       tab3.setBackground(new Color(150, 180, 200));
       tab4.setBackground(new Color(150, 180, 200));
    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
       jp2.setVisible(true);
       jp1.setVisible(false);
       jp3.setVisible(false);
       jb4.setVisible(false);
       tab2.setBackground(new Color(0, 92, 153));
       tab1.setBackground(new Color(150, 180, 200));
       tab3.setBackground(new Color(150, 180, 200));
       tab4.setBackground(new Color(150, 180, 200));
    }//GEN-LAST:event_tab2MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
      jp3.setVisible(true);
    jp1.setVisible(false);
    jp2.setVisible(false);
    jb4.setVisible(false);
    tab3.setBackground(new Color(0, 92, 153));
    tab1.setBackground(new Color(150, 180, 200));
    tab2.setBackground(new Color(150, 180, 200));
    tab4.setBackground(new Color(150, 180, 200));

    
    }//GEN-LAST:event_tab3MouseClicked

    private void tab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4MouseClicked
       jb4.setVisible(true);
       jp1.setVisible(false);
       jp3.setVisible(false);
       jp2.setVisible(false);
       tab4.setBackground(new Color(0, 92, 153));
       tab1.setBackground(new Color(150, 180, 200));
       tab2.setBackground(new Color(150, 180, 200));
       tab3.setBackground(new Color(150, 180, 200));
    }//GEN-LAST:event_tab4MouseClicked

    private void xoadethiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoadethiActionPerformed
    int selectedRow = jTable1.getSelectedRow();

    // Kiểm tra xem người dùng đã chọn hàng nào chưa
    if (selectedRow != -1) {
        // Lấy thông tin đề thi từ hàng được chọn
        String monHoc = jTable1.getValueAt(selectedRow, 0).toString();
        String maPhongThi = jTable1.getValueAt(selectedRow, 1).toString();

        // Hiển thị hộp thoại xác nhận xóa đề thi
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa đề thi này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
           try {
                Connection conn = MyConnection.getConnection();

                // Lấy danh sách các câu hỏi thuộc đề thi từ bảng exam
                String queryGetQuestions = "SELECT id FROM exam WHERE monhoc = ? AND maphongthi = ?";
                PreparedStatement statementGetQuestions = conn.prepareStatement(queryGetQuestions);
                statementGetQuestions.setString(1, monHoc);
                statementGetQuestions.setString(2, maPhongThi);
                ResultSet rs = statementGetQuestions.executeQuery();

                List<Integer> questionIds = new ArrayList<>();
                // Lưu danh sách các ID câu hỏi liên quan vào một danh sách
                while (rs.next()) {
                    int questionId = rs.getInt("id");
                    // Thêm questionId, questionId + 1 và questionId - 1 vào danh sách
                    questionIds.add(questionId);
                     questionIds.add(questionId + 1);
                    questionIds.add(questionId + 2);
                    questionIds.add(questionId + 3);
                    questionIds.add(questionId - 1);
                }

                // Thực hiện xóa tất cả các câu hỏi có ID trùng, ID + 1 và ID - 1 với danh sách các ID đề thi
                String queryDeleteQuestions = "DELETE FROM question WHERE id IN (" + String.join(",", Collections.nCopies(questionIds.size(), "?")) + ")";
                PreparedStatement statementDeleteQuestions = conn.prepareStatement(queryDeleteQuestions);
                for (int i = 0; i < questionIds.size(); i++) {
                    statementDeleteQuestions.setInt(i + 1, questionIds.get(i));
                }
                statementDeleteQuestions.executeUpdate();

                // Thực hiện xóa đề thi từ bảng exam
                String queryDeleteExam = "DELETE FROM exam WHERE monhoc = ? AND maphongthi = ?";
                PreparedStatement statementDeleteExam = conn.prepareStatement(queryDeleteExam);
                statementDeleteExam.setString(1, monHoc);
                statementDeleteExam.setString(2, maPhongThi);
                int rowsDeletedExam = statementDeleteExam.executeUpdate();

                if (rowsDeletedExam > 0) {
                    // Xóa hàng khỏi mô hình bảng jTable1
                    DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                    model1.removeRow(selectedRow);
                    
                      DefaultTableModel model3 = (DefaultTableModel) bang3.getModel();
                    model3.removeRow(selectedRow);

                    DefaultTableModel model4 = (DefaultTableModel) bang4.getModel();
                    model4.removeRow(selectedRow);

                    // Cập nhật lại dữ liệu trong bảng jTable2 (bảng câu hỏi)
                    loadQuestionsToTable();

                    JOptionPane.showMessageDialog(this, "Xóa đề thi và câu hỏi liên quan thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa đề thi và câu hỏi liên quan thất bại!");
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    }//GEN-LAST:event_xoadethiActionPerformed
private boolean validateForm() {
    String newSubject = monhoc.getText();
    String newClassRoom = maphongthi.getText();
    
    String newNguoiTaoDe = NguoiTao.getText();

    

   
    
    if (newNguoiTaoDe.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập tên người tạo đề!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    if (!newNguoiTaoDe.matches("[a-zA-Z\\s]+")) {
        JOptionPane.showMessageDialog(this, "Tên người tạo đề không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Thêm các kiểm tra khác tùy theo yêu cầu của bạn

    return true;
}


    private void capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatActionPerformed
     int selectedRow = jTable1.getSelectedRow();

    // Kiểm tra xem người dùng đã chọn dòng nào trong JTable chưa
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một đề thi để sửa", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Lấy thông tin đề thi đã chọn từ JTable
    String monHoc = jTable1.getValueAt(selectedRow, 0).toString();
    String maPhongThi = jTable1.getValueAt(selectedRow, 1).toString();
    String thoiGian = jTable1.getValueAt(selectedRow, 2).toString();
    String soLuongCauHoi = jTable1.getValueAt(selectedRow, 3).toString();
    String nguoiTaoDe = jTable1.getValueAt(selectedRow, 4).toString();

    // Hiển thị giao diện sửa thông tin đề thi và xử lý sự kiện sau khi sửa xong
    JTextField monHocField = new JTextField(monHoc);
    JTextField maPhongThiField = new JTextField(maPhongThi);
    JTextField thoiGianField = new JTextField(thoiGian);
    JTextField soLuongCauHoiField = new JTextField(soLuongCauHoi);
    JTextField nguoiTaoDeField = new JTextField(nguoiTaoDe);

    JPanel panel = new JPanel(new GridLayout(5, 2));
    panel.add(new JLabel("Môn học:"));
    panel.add(monHocField);
    panel.add(new JLabel("Mã phòng thi:"));
    panel.add(maPhongThiField);
    panel.add(new JLabel("Thời gian:"));
    panel.add(thoiGianField);
    panel.add(new JLabel("Số lượng câu hỏi:"));
    panel.add(soLuongCauHoiField);
    panel.add(new JLabel("Người tạo đề:"));
    panel.add(nguoiTaoDeField);

    int result = JOptionPane.showConfirmDialog(this, panel, "Sửa thông tin đề thi", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
        // Lấy thông tin đã sửa từ các trường dữ liệu
        String newMonHoc = monHocField.getText();
        String newMaPhongThi = maPhongThiField.getText();
        String newThoiGian = thoiGianField.getText();
        String newSoLuongCauHoi = soLuongCauHoiField.getText();
        String newNguoiTaoDe = nguoiTaoDeField.getText();

        // Kết nối cơ sở dữ liệu và thực hiện cập nhật
        try {
            java.sql.Connection conn = MyConnection.getConnection();
            if (conn != null) {
                String query = "UPDATE exam SET monhoc = ?, maphongthi = ?, thoigianthi = ?, soluongcauhoi = ?, nguoitao = ? WHERE monhoc = ? AND maphongthi = ?";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, newMonHoc);
                statement.setString(2, newMaPhongThi);
                statement.setString(3, newThoiGian);
                statement.setString(4, newSoLuongCauHoi);
                statement.setString(5, newNguoiTaoDe);
                statement.setString(6, monHoc); // Điều kiện WHERE
                statement.setString(7, maPhongThi); // Điều kiện WHERE

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    // Cập nhật lại dữ liệu trên giao diện JTable
                    jTable1.setValueAt(newMonHoc, selectedRow, 0);
                    jTable1.setValueAt(newMaPhongThi, selectedRow, 1);
                    jTable1.setValueAt(newThoiGian, selectedRow, 2);
                    jTable1.setValueAt(newSoLuongCauHoi, selectedRow, 3);
                    jTable1.setValueAt(newNguoiTaoDe, selectedRow, 4);

                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin đề thi thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Không có bản ghi nào được cập nhật", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }

                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật thông tin đề thi: " + e.getMessage(), "Thông Báo Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_capnhatActionPerformed


    private ExamInfo examInfoTemp;
    private void jButton_TaodethiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TaodethiActionPerformed
    String monHoc = monhoc.getText();
    String maPhongThi = maphongthi.getText();
    String thoiGian = Thoigian.getSelectedItem().toString();
    String soLuongCauHoi = Soluongcauhoi.getSelectedItem().toString();
    String nguoiTaoDe = NguoiTao.getText();

    // Kiểm tra nếu có trường nào đó không được nhập
    if (monHoc.isEmpty() || maPhongThi.isEmpty() || thoiGian.isEmpty() || soLuongCauHoi.isEmpty() || nguoiTaoDe.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
    } else {
        // Lưu thông tin vào cơ sở dữ liệu
        java.sql.Connection conn = MyConnection.getConnection();
        if (conn != null) {
            try {
                String query = "INSERT INTO exam (monhoc, maphongthi, thoigianthi, soluongcauhoi, nguoitao) VALUES (?, ?, ?, ?, ?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, monHoc);
                statement.setString(2, maPhongThi);
                statement.setString(3, thoiGian);
                statement.setString(4, soLuongCauHoi);
                statement.setString(5, nguoiTaoDe);
                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    examInfo = new ExamInfo("10");
                    examInfo.setMonHoc(monHoc);
                    examInfo.setMaPhongThi(maPhongThi);
                    examInfo.setThoiGian(thoiGian);
                    examInfo.setSoLuongCauHoi(soLuongCauHoi);
                    examInfo.setNguoiTaoDe(nguoiTaoDe);

                    // Lưu thông tin vào biến tạm
                    examInfoTemp = new ExamInfo("10");
                    examInfoTemp.setMonHoc(monHoc);
                    examInfoTemp.setMaPhongThi(maPhongThi);
                    examInfoTemp.setThoiGian(thoiGian);
                    examInfoTemp.setSoLuongCauHoi(soLuongCauHoi);
                    examInfoTemp.setNguoiTaoDe(nguoiTaoDe);

                    // Thêm thông tin bài đăng vào bảng jTable1
                    DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                    Object[] rowData1 = {monHoc, maPhongThi, thoiGian, soLuongCauHoi, nguoiTaoDe};
                    model1.addRow(rowData1);
                    // Thêm thông tin bài đăng vào bảng jTable3
                    addExamToTable3(monHoc, maPhongThi, thoiGian, soLuongCauHoi, nguoiTaoDe);
                  
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    }//GEN-LAST:event_jButton_TaodethiActionPerformed

    private void NguoiTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NguoiTaoActionPerformed
        String nguoiTaoDe = NguoiTao.getText();
    }//GEN-LAST:event_NguoiTaoActionPerformed

    private void ThoigianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThoigianActionPerformed
        String thoiGian = Thoigian.getSelectedItem().toString();
    }//GEN-LAST:event_ThoigianActionPerformed

    private void maphongthiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maphongthiActionPerformed
        String maPhongThi = maphongthi.getText();
    }//GEN-LAST:event_maphongthiActionPerformed

    private void monhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monhocActionPerformed
        String subject = monhoc.getText();
        createExam(subject);
    }//GEN-LAST:event_monhocActionPerformed

    private void SoluongcauhoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoluongcauhoiActionPerformed
         // Xử lý sự kiện thay đổi số lượng câu hỏi từ combobox "soluongcauhoi"
        String selectedValue = Soluongcauhoi.getSelectedItem().toString();
        int total = Integer.parseInt(selectedValue);
        Taodethi.getInstance().setTotalQuestions(total);
    }//GEN-LAST:event_SoluongcauhoiActionPerformed
   
    
    private void displayExamQuestions(ExamInfo examInfo) {
    // Hiển thị thông tin đề thi (nếu cần)
    // ...

    // Chuyển đến trang "Taodethi" và truyền examInfo
    taodethi.Taodethi taoDeThiPage = new taodethi.Taodethi();
    taoDeThiPage.setExamInfo(examInfo);
    taoDeThiPage.displayCreatedQuestions();
    taoDeThiPage.setVisible(true);
    this.dispose();
}
    
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     int selectedRow = jTable1.getSelectedRow();

    if (selectedRow != -1) {
        String monHoc = jTable1.getValueAt(selectedRow, 0).toString();
        String maPhongThi = jTable1.getValueAt(selectedRow, 1).toString();
        String thoiGian = jTable1.getValueAt(selectedRow, 2).toString();
        String soLuongCauHoi = jTable1.getValueAt(selectedRow, 3).toString();
        String nguoiTaoDe = jTable1.getValueAt(selectedRow, 4).toString();

        JOptionPane.showMessageDialog(this, "Môn học: " + monHoc + "\nMã phòng thi: " + maPhongThi + "\nThời gian: " + thoiGian + "\nSố lượng câu hỏi: " + soLuongCauHoi + "\nNgười tạo: " + nguoiTaoDe);

        // Kiểm tra trạng thái của trang "Taodethi" trước khi tạo đề thi
        taodethi.Taodethi taoDeThiPage = taodethi.Taodethi.getInstance();
        if (!taoDeThiPage.isVisible()) {
            ExamInfo examInfo = new ExamInfo();
            examInfo.setMonHoc(monHoc);
            examInfo.setMaPhongThi(maPhongThi);
            examInfo.setThoiGian(thoiGian);
            examInfo.setSoLuongCauHoi(soLuongCauHoi);
            examInfo.setNguoiTaoDe(nguoiTaoDe);
            taoDeThiPage.setExamInfo(examInfo);
            taoDeThiPage.setVisible(true);
            this.dispose();
            taoDeThiPage.displayCreatedQuestions();

            // Chọn câu hỏi đầu tiên trong jTable1
            if (jTable1.getRowCount() > 0) {
                jTable1.setRowSelectionInterval(0, 0);
            }
        }
    }
    }//GEN-LAST:event_jTable1MouseClicked
    private void addExamToTable3(String monHoc, String maPhongThi, String thoiGian, String soLuongCauHoi, String nguoiTaoDe) {
    DefaultTableModel model3 = (DefaultTableModel) bang3.getModel();
    Object[] rowData3 = {monHoc, maPhongThi, thoiGian, soLuongCauHoi, nguoiTaoDe};
    model3.insertRow(0, rowData3);
}
    public void displayCreatedQuestions(String[] questions, String[][] options) {
      // Xóa dữ liệu hiện tại trong bảng jTable1
    DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
    model1.setRowCount(0);

    // Xóa dữ liệu hiện tại trong bảng bang3
    DefaultTableModel model3 = (DefaultTableModel) bang3.getModel();
    model3.setRowCount(0);
    // Xóa dữ liệu hiện tại trong bảng bang4
    DefaultTableModel model4 = (DefaultTableModel) bang4.getModel();
    model4.setRowCount(0);

    try {
        // Kết nối đến cơ sở dữ liệu và truy vấn thông tin đề thi
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        Statement stmt = conn.createStatement();
        String sql = "SELECT monhoc, maphongthi, thoigianthi, soluongcauhoi, nguoitao FROM exam";
        java.sql.ResultSet rs = stmt.executeQuery(sql);

        // Hiển thị thông tin đề thi trong bảng jTable1
       
        while (rs.next()) {
            String monHoc = rs.getString("monhoc");
            String maPhongThi = rs.getString("maphongthi");
            String thoiGian = rs.getString("thoigianthi");
            String soLuongCauHoi = rs.getString("soluongcauhoi");
            String nguoiTaoDe = rs.getString("nguoitao");

            Object[] rowData = { monHoc, maPhongThi, thoiGian, soLuongCauHoi, nguoiTaoDe};
            model1.addRow(rowData);

            // Thêm thông tin đề thi vào bảng bang3
            Object[] rowData3 = {monHoc, maPhongThi, thoiGian, soLuongCauHoi, nguoiTaoDe};
            model3.addRow(rowData3);

           // Thêm thông tin đề thi vào bảng bang4
            Object[] rowData4 = { monHoc, maPhongThi, thoiGian, soLuongCauHoi, nguoiTaoDe};
            model4.addRow(rowData4);
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    
    
    private void nguoidungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nguoidungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nguoidungActionPerformed

    private void gmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gmailActionPerformed

    private void ngaysinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngaysinhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ngaysinhMouseClicked
private int getUserIdFromDatabase(String email) {
   int userId = -1; // Giá trị mặc định khi không tìm thấy người dùng

    String url = "jdbc:mysql://localhost:3306/database_db";
    String username = "root";
    String password = "";

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        // Chuẩn bị câu truy vấn để lấy userId dựa trên email của người dùng
        String query = "SELECT id FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);

            // Thực hiện truy vấn và lấy kết quả
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    userId = resultSet.getInt("id");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return userId;
}
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
  // Lấy thông tin người dùng mới từ giao diện
    String newUsername = nguoidung.getText();
    String newEmail = gmail.getText();
    String newGender = (jRadioButton1.isSelected()) ? "Nam" : "Nữ";
    Date newBirthdate = ngaysinh.getDate();

   String userEmail = gmail.getText(); // Lấy địa chỉ email từ thành phần giao diện
UserInfo previousUserInfo = getUserInfoFromDatabase(userEmail);


    // Kiểm tra xem thông tin mới có khác thông tin trước đó từ cơ sở dữ liệu hay không
    boolean isInfoChanged = !newUsername.equals(previousUserInfo.getUsername()) ||
                            !newEmail.equals(previousUserInfo.getEmail()) ||
                            !newGender.equals(previousUserInfo.getGender()) ||
                            !newBirthdate.equals(previousUserInfo.getBirthdate());

    if (!isInfoChanged) {
        JOptionPane.showMessageDialog(this, "Bạn chưa thay đổi thông tin cá nhân. Vui lòng thay đổi để cập nhật!", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
        return; // Dừng việc cập nhật
    }

    // Lấy userId từ cơ sở dữ liệu dựa trên email của người dùng
    int userId = getUserIdFromDatabase(newEmail);

    // Sau khi cập nhật thông tin người dùng thành công
boolean updateSuccess = updateUserInfo(userId, newUsername, newEmail, newGender, newBirthdate);

if (updateSuccess) {
    // Cập nhật lại các thành phần giao diện với thông tin mới
    nguoidung.setText(newUsername);
    gmail.setText(newEmail);
    
    if (newGender.equals("Nam")) {
        jRadioButton1.setSelected(true);
    } else {
        jRadioButton2.setSelected(true);
    }
    
    ngaysinh.setDate(newBirthdate);

    JOptionPane.showMessageDialog(this, "Cập nhật thông tin người dùng thành công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
} else {
    JOptionPane.showMessageDialog(this, "Cập nhật thông tin người dùng thất bại!", "Thông Báo Lỗi", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_updateActionPerformed
public class UserInfo {
    private String username;
    private String email;
    private String gender;
    private Date birthdate;

    public UserInfo(String username, String email, String gender, Date birthdate) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }
}
   private UserInfo getUserInfoFromDatabase(String email) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = MyConnection.getConnection();
            String query = "SELECT full_name, gender, date_of_birth FROM users WHERE email = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String fullName = rs.getString("full_name");
                String gender = rs.getString("gender");
                Date birthdate = rs.getDate("date_of_birth");

                return new UserInfo(fullName, email, gender, birthdate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null; // Trả về null nếu không tìm thấy thông tin người dùng
    }

    // ... Các phương thức và thuộc tính khác ...

//...

// Phương thức để cập nhật thông tin người dùng trong bảng "user" của cơ sở dữ liệu

private boolean updateUserInfo(int userId, String newUsername, String newEmail, String newGender, Date newBirthdate) {
    String url = "jdbc:mysql://localhost:3306/database_db";
    String username = "root";
    String password = "";

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        // Chuẩn bị câu truy vấn cập nhật thông tin người dùng
        String updateQuery = "UPDATE users SET full_name = ?, email = ?, gender = ?, date_of_birth = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, newUsername);
            statement.setString(2, newEmail);
            statement.setString(3, newGender);
            statement.setDate(4, new java.sql.Date(newBirthdate.getTime()));
            statement.setInt(5, userId);

            // Thực hiện cập nhật thông tin người dùng
            int rowsUpdated = statement.executeUpdate();

            // Kiểm tra xem cập nhật thành công hay không
            return rowsUpdated > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false; // Trả về false nếu có lỗi xảy ra trong quá trình cập nhật hoặc không có bản ghi nào được cập nhật
}
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       
    }//GEN-LAST:event_formMouseClicked

    private void jp3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp3MouseClicked
     
    }//GEN-LAST:event_jp3MouseClicked

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed


public void loadQuestionsToTable() {
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0); // Xóa dữ liệu hiện tại trong bảng

    try {
        // Kết nối đến cơ sở dữ liệu và truy vấn dữ liệu từ bảng question
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        Statement stmt = conn.createStatement();
      String sql = "SELECT id, cau_hoi, dap_an_a, dap_an_b, dap_an_c, dap_an_d, dap_an_dung FROM question";

        java.sql.ResultSet rs = stmt.executeQuery(sql);

     while (rs.next()) {
    int id = rs.getInt("id");
    String cauHoi = rs.getString("cau_hoi");
    String dapAnA = rs.getString("dap_an_a");
    String dapAnB = rs.getString("dap_an_b");
    String dapAnC = rs.getString("dap_an_c");
    String dapAnD = rs.getString("dap_an_d");
    String dapAnDung = rs.getString("dap_an_dung");

    // Thêm hàng vào bảng jTable2
    model.addRow(new Object[]{id, cauHoi, dapAnA, dapAnB, dapAnC, dapAnD, dapAnDung});
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
     
    }//GEN-LAST:event_jTable2MouseClicked

    private void bang3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bang3MouseClicked
   int row = bang3.getSelectedRow();
    if (row != -1) {
        String monHoc = bang3.getValueAt(row, 0).toString();
        String maPhongThi = bang3.getValueAt(row, 1).toString();
        String thoiGian = bang3.getValueAt(row, 2).toString().trim(); // Loại bỏ khoảng trắng
        String soLuongCauHoi = bang3.getValueAt(row, 3).toString();
        String nguoiTaoDe = bang3.getValueAt(row, 4).toString();

        // Hiển thị thông báo
        JOptionPane.showMessageDialog(this, "Môn học: " + monHoc + "\nMã phòng thi: " + maPhongThi + "\nThời gian: " + thoiGian + "\nSố lượng câu hỏi: " + soLuongCauHoi + "\nNgười tạo: " + nguoiTaoDe);

        // Lấy thời gian đã chọn từ ComboBox và chuyển đổi thành số phút
        int selectedMinutes = Integer.parseInt(thoiGian);

        // Chuyển đến trang Thi.java
        Thi thi = new Thi();
        thi.setExamInfo(monHoc, maPhongThi, thoiGian, soLuongCauHoi, nguoiTaoDe);
        thi.setUserInfo(Home.getInstance().getCurrentUsername(), Home.getInstance().getCurrentGender());

        // Cập nhật thời gian đếm ngược trong trang Thi.java
        thi.setCountdownTime(selectedMinutes);

        thi.setVisible(true);
        this.dispose();
    }
    }//GEN-LAST:event_bang3MouseClicked

    private void bang4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bang4MouseClicked
        int selectedRow = bang4.getSelectedRow();

    if (selectedRow != -1) {
        String monHoc = bang4.getValueAt(selectedRow, 0).toString();

        // Gọi các hàm truy vấn để lấy thông tin
        int soNguoiThi = tinhSoNguoiThi();
        float diemTrungBinh = tinhDiemTrungBinh();
        float diemCaoNhat = tinhDiemCaoNhat();
        float diemThapNhat = tinhDiemThapNhat();

        // Hiển thị thông tin lên các JLabel
        songuoithi.setText("Số người thi: " + soNguoiThi);
        diemtrungbinh.setText("Điểm trung bình: " + diemTrungBinh);
        diemcaonhat.setText("Điểm cao nhất: " + diemCaoNhat);
        diemthapnhat.setText("Điểm thấp nhất: " + diemThapNhat);
    }
    }//GEN-LAST:event_bang4MouseClicked
public int tinhSoNguoiThi() {
    int soNguoiThi = 0;

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        String query = "SELECT COUNT(DISTINCT ten_nguoi_dung) FROM result";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            soNguoiThi = rs.getInt(1);
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return soNguoiThi;
}
public float tinhDiemTrungBinh() {
    float diemTrungBinh = 0;

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        String query = "SELECT ROUND(AVG(diem), 1) FROM result";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            diemTrungBinh = rs.getFloat(1);
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return diemTrungBinh;
}

public float tinhDiemCaoNhat() {
    float diemCaoNhat = 0;

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        String query = "SELECT MAX(diem) FROM result";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            diemCaoNhat = rs.getFloat(1);
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return diemCaoNhat;
}

public float tinhDiemThapNhat() {
    float diemThapNhat = 0;

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        String query = "SELECT MIN(diem) FROM result";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            diemThapNhat = rs.getFloat(1);
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return diemThapNhat;
}

    
    
    
    public void displayCreatedQuestionss() {
    // Xóa dữ liệu hiện tại trong bảng jTable2
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0);

    try {
        // Kết nối đến cơ sở dữ liệu và truy vấn thông tin câu hỏi từ bảng question
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        Statement stmt = conn.createStatement();
        String sql = "SELECT cau_hoi, dap_an_a, dap_an_b, dap_an_c, dap_an_d, dap_an_dung FROM question";
        ResultSet rs = (ResultSet) stmt.executeQuery(sql);

        // Duyệt qua từng hàng kết quả
        while (rs.next()) {
            String cauHoi = rs.getString("cau_hoi");
            String dapAnA = rs.getString("dap_an_a");
            String dapAnB = rs.getString("dap_an_b");
            String dapAnC = rs.getString("dap_an_c");
            String dapAnD = rs.getString("dap_an_d");
            String dapAnDung = rs.getString("dap_an_dung");

            // Thêm hàng vào bảng jTable2
            model.addRow(new Object[]{cauHoi, dapAnA, dapAnB, dapAnC, dapAnD, dapAnDung});
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private void createExam(String subject) {
   java.sql.Connection conn = MyConnection.getConnection();
    if (conn != null) {
        try {
            String query = "INSERT INTO exam (subject) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, subject);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Đã tạo đề thi thành công!");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NguoiTao;
    private javax.swing.JComboBox<String> Soluongcauhoi;
    private javax.swing.JComboBox<String> Thoigian;
    private javax.swing.JTable bang3;
    private javax.swing.JTable bang4;
    private javax.swing.JButton capnhat;
    private javax.swing.JLabel diemcaonhat;
    private javax.swing.JLabel diemthapnhat;
    private javax.swing.JLabel diemtrungbinh;
    private javax.swing.JTextField gmail;
    private javax.swing.JButton jButton_Taodethi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel jb4;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp3;
    private javax.swing.JTextField maphongthi;
    private javax.swing.JTextField monhoc;
    private com.toedter.calendar.JDateChooser ngaysinh;
    private javax.swing.JTextField nguoidung;
    private javax.swing.JLabel songuoithi;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JButton update;
    private javax.swing.JButton xoadethi;
    // End of variables declaration//GEN-END:variables

    private List<ExamInfo> loadExamInfoFromDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

   
}
