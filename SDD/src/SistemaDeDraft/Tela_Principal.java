/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDeDraft;

/**
 *
 * @author Gaspe
 */
public class Tela_Principal extends javax.swing.JFrame {


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Tela_Inicial = new javax.swing.JPanel();
        Label_Inicio = new javax.swing.JLabel();
        Botao_Vermelho = new javax.swing.JButton();
        Botao_Azul = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Label_Inicio.setText("Quem começa banindo?");

        Botao_Vermelho.setText("Vermelho");
        Botao_Vermelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botao_VermelhoActionPerformed(evt);
            }
        });

        Botao_Azul.setText("Azul");

        javax.swing.GroupLayout Panel_Tela_InicialLayout = new javax.swing.GroupLayout(Panel_Tela_Inicial);
        Panel_Tela_Inicial.setLayout(Panel_Tela_InicialLayout);
        Panel_Tela_InicialLayout.setHorizontalGroup(
            Panel_Tela_InicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Tela_InicialLayout.createSequentialGroup()
                .addGroup(Panel_Tela_InicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_Tela_InicialLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(Label_Inicio))
                    .addGroup(Panel_Tela_InicialLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(Panel_Tela_InicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Botao_Vermelho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Botao_Azul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        Panel_Tela_InicialLayout.setVerticalGroup(
            Panel_Tela_InicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Tela_InicialLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(Label_Inicio)
                .addGap(18, 18, 18)
                .addComponent(Botao_Vermelho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Botao_Azul)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Tela_Inicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Tela_Inicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Botao_VermelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botao_VermelhoActionPerformed
        
    }//GEN-LAST:event_Botao_VermelhoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void init() {
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
            java.util.logging.Logger.getLogger(Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                SistemaDeDraft SisDraft = new SistemaDeDraft();
               // SisDraft.init();
                new Tela_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Botao_Azul;
    private javax.swing.JButton Botao_Vermelho;
    private javax.swing.JLabel Label_Inicio;
    private javax.swing.JPanel Panel_Tela_Inicial;
    // End of variables declaration//GEN-END:variables
}
