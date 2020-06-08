/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gos.visao;

import br.com.gos.controle.UsuariosControle;
import br.com.gos.modelo.UsuariosModelo;
import br.com.gos.util.GerenteFecha;
import static br.com.gos.visao.FrmPrincipal.tipoUsuario;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author dv22p
 */
public class FrmUsuarios extends javax.swing.JInternalFrame
{
    UsuariosModelo um = new UsuariosModelo();
    UsuariosControle uc = new UsuariosControle();
    int ne=0;
    private static FrmUsuarios frmUsuarios;
    public static FrmUsuarios mostrar()
    {
        if (frmUsuarios==null) 
        {
            frmUsuarios = new FrmUsuarios();
        }
        return frmUsuarios;
    }
  
    public FrmUsuarios() 
    {
        initComponents();
    }
    
    public void controlesVisuais(boolean A, boolean B)
    {
        btPesquisar.setVisible(A);
        btNovo.setVisible(A);
        btSalva.setVisible(B);
        btEdita.setVisible(A);
        btExclui.setVisible(A);
        btCancela.setVisible(B);
        txtNome.setEnabled(B);
        txtLogin.setEnabled(B);
        txtSenha.setEnabled(B);
        cbxPerfil.setEnabled(B);
    }
    
    public void limpaCampos()
    {
        txtNome.setText(null);
        txtLogin.setText(null);
        txtSenha.setText(null);
    }
    
    public void carregaUltimoUsuario()
    {
        uc.retornaUltimoRegistro(um);
        txtCodigo.setText(um.getId());
    }
    
    public void carregaUsuarioId()
    {
        if (! txtCodigo.getText().isEmpty()) 
        {
            um.setId(txtCodigo.getText());
            uc.buscaUsuarioId(um);
            txtNome.setText(um.getNome());
            txtLogin.setText(um.getLogin());
            txtSenha.setText(um.getSenha());
            cbxPerfil.setSelectedItem(um.getPerfil());
            txtAlterado.setText(um.getAlterado());
            txtResponsavel.setText(um.getResponsavel());
        }
    }
    
    public void selecionaLoja()
    {
        int nLoja = 0;
        String nLojaS;
        try 
        {
            while (nLoja<=0)
            {
                nLojaS=JOptionPane.showInputDialog("Informe o código da loja");
                nLoja=Integer.parseInt(nLojaS);
                if (nLoja>0) 
                {
                    um.setLoja(nLojaS);
                    uc.atualizaLoja(um);
                }
            }
        }
        catch (HeadlessException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Código da loja inválido!");
            selecionaLoja();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxPerfil = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtAlterado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtResponsavel = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        btSalva = new javax.swing.JButton();
        btEdita = new javax.swing.JButton();
        btExclui = new javax.swing.JButton();
        btCancela = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Código");

        txtCodigo.setEnabled(false);

        jLabel3.setText("Nome");

        txtNome.setEnabled(false);
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        jLabel4.setText("Login");

        txtLogin.setEnabled(false);
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });

        jLabel5.setText("Senha");

        txtSenha.setEnabled(false);
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        jLabel6.setText("Perfil");

        cbxPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USER", "ADMIN" }));
        cbxPerfil.setEnabled(false);

        jLabel7.setText("Alterado");

        txtAlterado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlterado.setEnabled(false);
        txtAlterado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlteradoActionPerformed(evt);
            }
        });

        jLabel8.setText("Responsável");

        txtResponsavel.setEnabled(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gos/icones/novo.png"))); // NOI18N
        btNovo.setToolTipText("Novo");
        btNovo.setFocusable(false);
        btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btNovo);

        btSalva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gos/icones/salvar.png"))); // NOI18N
        btSalva.setToolTipText("Salva");
        btSalva.setFocusable(false);
        btSalva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvaActionPerformed(evt);
            }
        });
        jToolBar1.add(btSalva);

        btEdita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gos/icones/editar.png"))); // NOI18N
        btEdita.setToolTipText("Editar");
        btEdita.setFocusable(false);
        btEdita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEdita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditaActionPerformed(evt);
            }
        });
        jToolBar1.add(btEdita);

        btExclui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gos/icones/excluir.png"))); // NOI18N
        btExclui.setToolTipText("Excluir");
        btExclui.setFocusable(false);
        btExclui.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExclui.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluiActionPerformed(evt);
            }
        });
        jToolBar1.add(btExclui);

        btCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gos/icones/cancelar.png"))); // NOI18N
        btCancela.setToolTipText("Cancelar");
        btCancela.setFocusable(false);
        btCancela.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancela.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelaActionPerformed(evt);
            }
        });
        jToolBar1.add(btCancela);

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gos/icones/pesquisar.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.setFocusable(false);
        btPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        jToolBar1.add(btPesquisar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResponsavel)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlterado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlterado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditaActionPerformed
        ne=1;
        controlesVisuais(false, true);
    }//GEN-LAST:event_btEditaActionPerformed

    private void btSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvaActionPerformed
        if ((txtNome.getText().isEmpty()) || (txtLogin.getText().isEmpty()) || (txtSenha.getText().isEmpty())) 
        {
            JOptionPane.showMessageDialog(null,"Todos os campos são obrigatórios!");
        }
        else
        {
            int ok = JOptionPane.showConfirmDialog(null,"Confirma os dados?","Atenção",JOptionPane.YES_NO_OPTION);
            if (ok==JOptionPane.YES_OPTION)
            {
                um.setNome(txtNome.getText().toUpperCase().trim());
                um.setLogin(txtLogin.getText().toUpperCase().trim());
                um.setSenha(txtSenha.getText().toUpperCase().trim());
                um.setPerfil(cbxPerfil.getSelectedItem().toString());
                um.setResponsavel(FrmPrincipal.lblUsuario.getText());
                if (ne==0)
                {
                    String i = txtCodigo.getText();
                    uc.addUsuario(um);
                    carregaUltimoUsuario();
                    carregaUsuarioId();
                    if (tipoUsuario.equals("MASTER"))
                    {
                        if(! txtCodigo.getText().equals(i)) selecionaLoja();
                    }
                }
                else
                {
                    um.setId(txtCodigo.getText());
                    uc.altUsuario(um);
                    carregaUsuarioId();
                }
                controlesVisuais(true, false);
            }
        }
    }//GEN-LAST:event_btSalvaActionPerformed

    private void btExcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluiActionPerformed
        int exc = JOptionPane.showConfirmDialog(null,"Deseja remover?","Atenção",JOptionPane.YES_NO_OPTION);
        if (exc==JOptionPane.YES_OPTION)
        {
            um.setId(txtCodigo.getText());
            uc.excUsuario(um);
            txtCodigo.setText(um.getId());
            carregaUltimoUsuario();
            carregaUsuarioId();
        }
    }//GEN-LAST:event_btExcluiActionPerformed

    private void btCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelaActionPerformed
        carregaUsuarioId();
        controlesVisuais(true, false);
    }//GEN-LAST:event_btCancelaActionPerformed

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        GerenteFecha.dialogoFechaJanela(frmUsuarios, txtNome, btCancela);
    }//GEN-LAST:event_formInternalFrameClosing

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ne=0;
        controlesVisuais(false, true);
        limpaCampos();
        txtNome.requestFocus();
    }//GEN-LAST:event_btNovoActionPerformed

    private void txtAlteradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlteradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlteradoActionPerformed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if (evt.getKeyCode()==10)
        {
            txtLogin.requestFocus();
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed
        if (evt.getKeyCode()==10)
        {
            txtSenha.requestFocus();
        }
    }//GEN-LAST:event_txtLoginKeyPressed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        if (evt.getKeyCode()==10)
        {
            cbxPerfil.requestFocus();
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        btSalva.setVisible(false);
        btCancela.setVisible(false); 
        carregaUltimoUsuario();
        carregaUsuarioId();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        String i = txtCodigo.getText();
        FrmPesqUsuarios frmPesqUsuarios = new FrmPesqUsuarios(new javax.swing.JFrame(),true);
        frmPesqUsuarios.setVisible(true);
        if (! i.equals(txtCodigo.getText())) 
        {
            carregaUsuarioId(); 
        }
    }//GEN-LAST:event_btPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancela;
    private javax.swing.JButton btEdita;
    private javax.swing.JButton btExclui;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalva;
    private javax.swing.JComboBox<String> cbxPerfil;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtAlterado;
    public static javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtResponsavel;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}