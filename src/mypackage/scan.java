
package mypackage;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class scan extends javax.swing.JFrame {
   Connection cn;
   Statement st;
   ResultSet rs;
   
   public void connect2database()
   {
       try
       {
           Class.forName("oracle.jdbc.OracleDriver");
           cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","Dell@123");
           st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
       }
       catch(ClassNotFoundException | SQLException e)
       {
           JOptionPane.showMessageDialog(null,"error:" +e);
       }
   }
   
   
    /**
     * Creates new form scan
     */
    public scan() {
        initComponents();
        connect2database();
    }
    
    
  

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:oracle:thin:@localhost:1521:XEPU").createEntityManager();
        vehicleEntryQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT v FROM VehicleEntry v");
        vehicleEntryList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : vehicleEntryQuery.getResultList();
        Barcode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(746, 543));
        getContentPane().setLayout(null);

        Barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BarcodeKeyPressed(evt);
            }
        });
        getContentPane().add(Barcode);
        Barcode.setBounds(10, 200, 340, 40);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("VERIFY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 280, 170, 40);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, vehicleEntryList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vehicleNo}"));
        columnBinding.setColumnName("Vehicle No");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(373, 10, 370, 530);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(0, 446, 90, 30);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setText("EXIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(100, 338, 170, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mypackage/vpp_bg.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 740, 540);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarcodeKeyPressed
    if(evt.getKeyCode()==KeyEvent.VK_ENTER)
    {
        DefaultTableModel table = new DefaultTableModel();
        
        table.addColumn("No");
        table.addColumn("Name");
        table.addColumn("Phone Number");
        table.addColumn("Department");
        table.addColumn("Vehicle Number");
        
        
        try
        {
            String sql = "select *from add_vehicle where vehicle_no='"+Barcode.getText()+"'";
            rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                table.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    
                });
            }
           
        }
        catch(Exception e){
            
        }
    }
    }//GEN-LAST:event_BarcodeKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try
        {
        String n,sql;
        n = Barcode.getText();
        
        sql = "select * from add_vehicle where vehicle_no='"+n+"'";
        rs = st.executeQuery(sql);
        if(rs.next()==true)
        {
            JOptionPane.showMessageDialog(null,"User can park vehicle");
            sql = "INSERT INTO VEHICLE_ENTRY VALUES('"+n+"')";
            int c = st.executeUpdate(sql);
            cn.close();
            connect2database();
            new scan().setVisible(true);
        this.setVisible(false);
        }
        else    
        {
            JOptionPane.showMessageDialog(null,"User cannot park vehicle");
        }        
        }
        
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"error"+e);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       new secondpage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     try
        {
        String n,sql;
        n = Barcode.getText();
        
        sql = "delete from vehicle_entry where vehicle_no='"+n+"'";
        rs = st.executeQuery(sql);
            JOptionPane.showMessageDialog(null,"Vehicle can exit");
            cn.close();
            connect2database();
            new scan().setVisible(true);
        this.setVisible(false);
         
    }//GEN-LAST:event_jButton3ActionPerformed
   catch(Exception e){
       
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
            java.util.logging.Logger.getLogger(scan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Barcode;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<mypackage.VehicleEntry> vehicleEntryList;
    private javax.persistence.Query vehicleEntryQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
