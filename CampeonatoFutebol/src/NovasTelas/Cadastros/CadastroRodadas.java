/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NovasTelas.Cadastros;

import campeonatofutebol.Campeonato;
import classesDAO.CampeonatoDAO;
import classesDAO.RodadaDAO;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Stwuart
 */
public class CadastroRodadas extends javax.swing.JInternalFrame {
    private final JDesktopPane telaAnterior;
    private Campeonato campeonato;

    /**
     * Creates new form CadastroRodadas
     * @param jDPPrincipal
     */
    public CadastroRodadas(JDesktopPane jDPPrincipal) {
        initComponents();
        this.telaAnterior = jDPPrincipal;
        this.campeonato = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCodigoCampeonato = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jNomeCampeonato = new javax.swing.JTextField();
        GerarRodadas = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("Código Campeonato:");

        jButton1.setText("buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jNomeCampeonato.setEnabled(false);

        GerarRodadas.setText("Gerar Rodadas");
        GerarRodadas.setEnabled(false);
        GerarRodadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarRodadasActionPerformed(evt);
            }
        });

        jButton3.setText("cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jCodigoCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jNomeCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(GerarRodadas, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCodigoCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jNomeCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GerarRodadas)
                    .addComponent(jButton3))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        try {
            Integer codigoBusca = Integer.parseInt(jCodigoCampeonato.getText());
            this.campeonato = new CampeonatoDAO().selectCodigo(codigoBusca);
            this.jNomeCampeonato.setText(campeonato.getNomeCamp());
            this.GerarRodadas.setEnabled(true);
        }catch (IllegalAccessException | ClassNotFoundException | SQLException ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void GerarRodadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarRodadasActionPerformed
        RodadaDAO rodadaDAO = new RodadaDAO();
        try {
            rodadaDAO.GerarRodadas(this.campeonato);
            JOptionPane.showMessageDialog(this, "Rodadas geradas com sucesso!");
        } catch (IllegalAccessException | ClassNotFoundException | SQLException ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }finally{
            this.dispose();
        }
    }//GEN-LAST:event_GerarRodadasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GerarRodadas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jCodigoCampeonato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jNomeCampeonato;
    // End of variables declaration//GEN-END:variables
}
