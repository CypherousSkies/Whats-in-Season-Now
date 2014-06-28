package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import seasonality.Seasonality;

/**
 *
 * @author Torri
 */
public class StartupOptions extends javax.swing.JPanel {

    BufferedImage back;

    /**
     * Creates new form Options
     */
    public StartupOptions() {
        initComponents();
        done.addActionListener(Seasonality.bi);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crop = new javax.swing.JComboBox();
        inseason = new javax.swing.JComboBox();
        monthDefault = new javax.swing.JButton();
        useThis = new javax.swing.JButton();
        done = new javax.swing.JButton();
        lastSetting = new javax.swing.JButton();

        crop.setModel(new javax.swing.DefaultComboBoxModel(seasonality.Crops.values()));
        crop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cropActionPerformed(evt);
            }
        });

        inseason.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "In Season", "Out Of Season" }));

        monthDefault.setText("Use This Month's Default");

        useThis.setText("Use this Property");

        done.setText("Done/Continue To Game");

        lastSetting.setText("Use Last Settings");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(useThis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(crop, 0, 251, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inseason, 0, 134, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monthDefault, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(done, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(monthDefault, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(crop)
                    .addComponent(inseason, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(useThis, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(done, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(327, 327, 327))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cropActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cropActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox crop;
    private javax.swing.JButton done;
    private javax.swing.JComboBox inseason;
    private javax.swing.JButton lastSetting;
    private javax.swing.JButton monthDefault;
    private javax.swing.JButton useThis;
    // End of variables declaration//GEN-END:variables

}
