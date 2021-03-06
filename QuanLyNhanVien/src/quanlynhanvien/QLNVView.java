/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author HUNG
 */
public class QLNVView extends javax.swing.JFrame {

    /**
     * Creates new form QLNVView
     */
    public QLNVView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();
        cbbSapXep = new javax.swing.JComboBox<>();
        txtKey = new javax.swing.JTextField();
        btnThem1 = new javax.swing.JButton();
        BtnSearch = new javax.swing.JButton();
        cboLocLoaiNhanVien = new javax.swing.JComboBox<>();
        chkCapNhapHeSo = new javax.swing.JCheckBox();
        cboLoaiNhanVienCapNhap = new javax.swing.JComboBox<>();
        lbThongSoStaticCapNhap = new javax.swing.JLabel();
        txtThongSoStaticCapNhap = new javax.swing.JTextField();
        lbCapNhapHeSo = new javax.swing.JLabel();
        btnCapNhapHeSo = new javax.swing.JButton();
        btnHuyCapNhapHeSo1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboLoaiNhanVien = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        lbThongSoNhanVien = new javax.swing.JLabel();
        txtThongSoNhanVien = new javax.swing.JTextField();
        lbThongSoStatic = new javax.swing.JLabel();
        txtThongSoStatic = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "M?? nh??n vi??n", "H??? t??n", "Ng??y sinh", "S??? CMND", "?????a ch???", "Lo???i NV", "H??? s??? th?????ng", "L????ng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableNhanVien);

        cbbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T??y ch???n s???p x???p", "S???p x???p theo m??", "S???p x???p theo t??n", "S???p x???p theo l????ng" }));

        btnThem1.setText("Th??m");

        BtnSearch.setText("T??m Ki???m");

        cboLocLoaiNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hi???n th??? t???t c??? nh??n vi??n", "Ch??? hi???n th??? Nh??n vi??n ch??nh th???c", "Ch??? hi???n th??? Nh??n vi??n h???p ?????ng", "Ch??? hi???n th??? Nh??n vi??n part time" }));

        chkCapNhapHeSo.setText("C???p nh???p h??? s???");

        cboLoaiNhanVienCapNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nh??n vi??n ch??nh th???c", "Nh??n vi??n h???p ?????ng", "Nh??n vi??n part time" }));

        lbThongSoStaticCapNhap.setText("Ti???n l????ng c??n b???n");

        txtThongSoStaticCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThongSoStaticCapNhapActionPerformed(evt);
            }
        });

        lbCapNhapHeSo.setBackground(new java.awt.Color(204, 255, 204));
        lbCapNhapHeSo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbCapNhapHeSo.setForeground(new java.awt.Color(255, 0, 0));
        lbCapNhapHeSo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCapNhapHeSo.setText("C???P NH???P H??? S???");
        lbCapNhapHeSo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnCapNhapHeSo.setText("C???p nh???p");

        btnHuyCapNhapHeSo1.setText("H???y");
        btnHuyCapNhapHeSo1.setActionCommand("H???y");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboLocLoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cboLoaiNhanVienCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(lbThongSoStaticCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtThongSoStaticCapNhap))
            .addComponent(lbCapNhapHeSo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(BtnSearch))
                    .addComponent(chkCapNhapHeSo))
                .addContainerGap(326, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCapNhapHeSo)
                .addGap(27, 27, 27)
                .addComponent(btnHuyCapNhapHeSo1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(309, 309, 309)
                    .addComponent(btnThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(310, 310, 310)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLocLoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSearch))
                .addGap(29, 29, 29)
                .addComponent(chkCapNhapHeSo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCapNhapHeSo)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtThongSoStaticCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbThongSoStaticCapNhap)
                    .addComponent(cboLoaiNhanVienCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhapHeSo)
                    .addComponent(btnHuyCapNhapHeSo1)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(269, 269, 269)
                    .addComponent(btnThem1)
                    .addContainerGap(270, Short.MAX_VALUE)))
        );

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TH??NG TIN NH??N VI??N");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("M?? nh??n vi??n");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("H??? t??n ");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Ng??y sinh (yyyy-MM-dd)");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("CMND");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("?????a ch???");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Lo???i nh??n vi??n");

        cboLoaiNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nh??n vi??n ch??nh th???c", "Nh??n vi??n h???p ?????ng", "Nh??n vi??n part time" }));

        btnThem.setText("Th??m");

        btnXoa.setText("X??a");

        btnSua.setText("S???a");

        lbThongSoNhanVien.setText("H??? s??? l????ng");

        txtThongSoNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThongSoNhanVienActionPerformed(evt);
            }
        });

        lbThongSoStatic.setText("L????ng c?? b???n");

        txtThongSoStatic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThongSoStaticActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbThongSoStatic)
                                    .addComponent(lbThongSoNhanVien))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtThongSoStatic)
                            .addComponent(txtThongSoNhanVien)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaNV)
                                    .addComponent(txtNgaySinh)
                                    .addComponent(txtCMND)
                                    .addComponent(txtHoTen)
                                    .addComponent(txtDiaChi)
                                    .addComponent(cboLoaiNhanVien, 0, 207, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jLabel5))
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboLoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtThongSoStatic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbThongSoStatic))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtThongSoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbThongSoNhanVien))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnXoa)
                            .addComponent(btnSua))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNhanVienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableNhanVienMouseClicked

    public JLabel getLbCapNhapHeSo() {
        return lbCapNhapHeSo;
    }

    public void setLbCapNhapHeSo(JLabel lbCapNhapHeSo) {
        this.lbCapNhapHeSo = lbCapNhapHeSo;
    }

    public JButton getBtnCapNhapHeSo() {
        return btnCapNhapHeSo;
    }

    public void setBtnCapNhapHeSo(JButton btnCapNhapHeSo) {
        this.btnCapNhapHeSo = btnCapNhapHeSo;
    }

    public JButton getBtnHuyCapNhapHeSo1() {
        return btnHuyCapNhapHeSo1;
    }

    public void setBtnHuyCapNhapHeSo1(JButton btnHuyCapNhapHeSo1) {
        this.btnHuyCapNhapHeSo1 = btnHuyCapNhapHeSo1;
    }

    public JComboBox<String> getCboLoaiNhanVienCapNhap() {
        return cboLoaiNhanVienCapNhap;
    }

    public void setCboLoaiNhanVienCapNhap(JComboBox<String> cboLoaiNhanVienCapNhap) {
        this.cboLoaiNhanVienCapNhap = cboLoaiNhanVienCapNhap;
    }

    public JCheckBox getChkCapNhapHeSo() {
        return chkCapNhapHeSo;
    }

    public void setChkCapNhapHeSo(JCheckBox chkCapNhapHeSo) {
        this.chkCapNhapHeSo = chkCapNhapHeSo;
    }

    public JLabel getLbThongSoStaticCapNhap() {
        return lbThongSoStaticCapNhap;
    }

    public void setLbThongSoStaticCapNhap(JLabel lbThongSoStaticCapNhap) {
        this.lbThongSoStaticCapNhap = lbThongSoStaticCapNhap;
    }

    public JTextField getTxtThongSoStaticCapNhap() {
        return txtThongSoStaticCapNhap;
    }

    public void setTxtThongSoStaticCapNhap(JTextField txtThongSoStaticCapNhap) {
        this.txtThongSoStaticCapNhap = txtThongSoStaticCapNhap;
    }

    public JLabel getLbThongSoStatic() {
        return lbThongSoStatic;
    }

    public void setLbThongSoStatic(JLabel lbThongSoStatic) {
        this.lbThongSoStatic = lbThongSoStatic;
    }

    public JTextField getTxtThongSoStatic() {
        return txtThongSoStatic;
    }

    public void setTxtThongSoStatic(JTextField txtThongSoStatic) {
        this.txtThongSoStatic = txtThongSoStatic;
    }

    public JComboBox<String> getCboLocLoaiNhanVien() {
        return cboLocLoaiNhanVien;
    }

    public void setCboLocLoaiNhanVien(JComboBox<String> cboLocLoaiNhanVien) {
        this.cboLocLoaiNhanVien = cboLocLoaiNhanVien;
    }

    public JButton getBtnSearch() {
        return BtnSearch;
    }

    public void setBtnSearch(JButton BtnSearch) {
        this.BtnSearch = BtnSearch;
    }

    public JTextField getTxtKey() {
        return txtKey;
    }

    public void setTxtKey(JTextField txtKey) {
        this.txtKey = txtKey;
    }

    private void txtThongSoNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThongSoNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThongSoNhanVienActionPerformed

    private void txtThongSoStaticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThongSoStaticActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThongSoStaticActionPerformed

    private void txtThongSoStaticCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThongSoStaticCapNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThongSoStaticCapNhapActionPerformed

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
            java.util.logging.Logger.getLogger(QLNVView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNVView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNVView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNVView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNVView().setVisible(true);
            }
        });
    }

    //Properties
    public JButton getBtnSua() {
        return btnSua;
    }

    public void setBtnSua(JButton btnSua) {
        this.btnSua = btnSua;
    }

    public JButton getBtnThem() {
        return btnThem;
    }

    public void setBtnThem(JButton btnThem) {
        this.btnThem = btnThem;
    }

    public JButton getBtnXoa() {
        return btnXoa;
    }

    public void setBtnXoa(JButton btnXoa) {
        this.btnXoa = btnXoa;
    }

    public JComboBox<String> getCboLoaiNhanVien() {
        return cboLoaiNhanVien;
    }

    public void setCboLoaiNhanVien(JComboBox<String> cboLoaiNhanVien) {
        this.cboLoaiNhanVien = cboLoaiNhanVien;
    }

    public JTable getTableNhanVien() {
        return tableNhanVien;
    }

    public void setTableNhanVien(JTable tableNhanVien) {
        this.tableNhanVien = tableNhanVien;
    }

    public JTextField getTxtCMND() {
        return txtCMND;
    }

    public void setTxtCMND(JTextField txtCMND) {
        this.txtCMND = txtCMND;
    }

    public JTextField getTxtDiaChi() {
        return txtDiaChi;
    }

    public void setTxtDiaChi(JTextField txtDiaChi) {
        this.txtDiaChi = txtDiaChi;
    }

    public JTextField getTxtHoTen() {
        return txtHoTen;
    }

    public void setTxtHoTen(JTextField txtHoTen) {
        this.txtHoTen = txtHoTen;
    }

    public JTextField getTxtMaNV() {
        return txtMaNV;
    }

    public void setTxtMaNV(JTextField txtMaNV) {
        this.txtMaNV = txtMaNV;
    }

    public JTextField getTxtNgaySinh() {
        return txtNgaySinh;
    }

    public void setTxtNgaySinh(JTextField txtNgaySinh) {
        this.txtNgaySinh = txtNgaySinh;
    }

    public JLabel getLbThongSoNhanVien() {
        return lbThongSoNhanVien;
    }

    public void setLbThongSoNhanVien(JLabel lbThongSoNhanVien) {
        this.lbThongSoNhanVien = lbThongSoNhanVien;
    }

    public JTextField getTxtThongSoNhanVien() {
        return txtThongSoNhanVien;
    }

    public void setTxtThongSoNhanVien(JTextField txtThongSoNhanVien) {
        this.txtThongSoNhanVien = txtThongSoNhanVien;
    }

    public JComboBox<String> getCbbSapXep() {
        return cbbSapXep;
    }

    public void setCbbSapXep(JComboBox<String> cbbSapXep) {
        this.cbbSapXep = cbbSapXep;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSearch;
    private javax.swing.JButton btnCapNhapHeSo;
    private javax.swing.JButton btnHuyCapNhapHeSo1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbSapXep;
    private javax.swing.JComboBox<String> cboLoaiNhanVien;
    private javax.swing.JComboBox<String> cboLoaiNhanVienCapNhap;
    private javax.swing.JComboBox<String> cboLocLoaiNhanVien;
    private javax.swing.JCheckBox chkCapNhapHeSo;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCapNhapHeSo;
    private javax.swing.JLabel lbThongSoNhanVien;
    private javax.swing.JLabel lbThongSoStatic;
    private javax.swing.JLabel lbThongSoStaticCapNhap;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtThongSoNhanVien;
    private javax.swing.JTextField txtThongSoStatic;
    private javax.swing.JTextField txtThongSoStaticCapNhap;
    // End of variables declaration//GEN-END:variables

}
