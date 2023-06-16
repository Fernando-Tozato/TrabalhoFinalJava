package my.gui;

import my.app.API;

// Essa é a classe principal do Front-end, ela mostra a tabela "materias" ao usuário
// e dá a escolha de quais ações podem ser efetuadas
public class MainInterface extends javax.swing.JFrame {

    private API api;

    public MainInterface() {
        initComponents();
    }

    public void setApi(API api) {
        this.api = api;
    }

    // Esse método define a janela a ser criada
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("App");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Primeiro, faça login no botão a cima. Após isso a tabela será criada automaticamente e exibida abaixo.");

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Código", "AV1", "AVA1", "AV2", "AVA2", "NF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Adicionar matéria");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarMateria(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Adicionar nota");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarNota(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Calcular CR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularCR(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("Deletar Tabela");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarTabela(evt);
            }
        });

        jMenu1.setText("Login");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jMenuItem1.setText("Entrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrar(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sair(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenuItem2.setVisible(false);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton4))))
                .addGap(10, 10, 10))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Esse método é chamado quando o usuário aciona o item "Entrar" no menu "Login"
    // que fica na barra na parte superior da janela. Ele instancia a classe Login
    // que faz a verificação do login
    private void entrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrar
        Login login = new Login();
        login.setApi(api);
        login.setMain(this);
        login.setVisible(true);
    }//GEN-LAST:event_entrar

    // Esse método é chamado quando o usuário aciona o item "Sair" no menu com o 
    // nome do usuário que fica na barra na parte superior da janela. Ele troca
    // o nome do menu para "Login", troca a visualização dos itens e define os dados
    // de conexão como ""
    private void sair(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sair
        jMenu1.setText("Login");
        jMenuItem1.setVisible(true);
        jMenuItem2.setVisible(false);
        api.setUsuario("");
        api.setBd("");
        api.setSenha("");
    }//GEN-LAST:event_sair

    // Esse método é chamado quando o usuário aciona o botão "Adicionar Matéria" 
    // no lado direito da janela. Primeiro, ele verifica se o usuário não fez login,
    // caso não tenha feito, ele instancia a classe Erro e define sua visualização 
    // como true. Caso tenha feito, ele instancia a classe Materia e define sua 
    // visualização como true
    private void adicionarMateria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarMateria
        if ("Login".equals(jMenu1.getText())) {
            Erro erro = new Erro();
            erro.setVisible(true);
            return;
        }
        Materia materia = new Materia();
        materia.setApi(api);
        materia.setMain(this);
        materia.setVisible(true);
    }//GEN-LAST:event_adicionarMateria

    // Esse método é chamado quando o usuário aciona o botão "Adicionar Nota" no 
    // lado direito da janela. Primeiro, ele verifica se o usuário não fez login,
    // caso não tenha feito, ele instancia a classe Erro e define sua visualização 
    // como true. Caso tenha feito, ele instancia a classe Nota e define sua 
    // visualização como true
    private void adicionarNota(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarNota
        if ("Login".equals(jMenu1.getText())) {
            Erro erro = new Erro();
            erro.setVisible(true);
            return;
        }
        Nota nota = new Nota();
        nota.setApi(api);
        nota.setMain(this);
        nota.setVisible(true);
    }//GEN-LAST:event_adicionarNota

    // Esse método é chamado quando o usuário aciona o botão "Calcular CR" no 
    // lado direito da janela. Primeiro, ele verifica se o usuário não fez login,
    // caso não tenha feito, ele instancia a classe Erro e define sua visualização 
    // como true. Caso tenha feito, ele chama o método API.calcularCR e atribui
    // seu retorno à variável nota, depois ele instancia a classe CR e define sua
    // visualização como true
    private void calcularCR(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularCR
        if ("Login".equals(jMenu1.getText())) {
            Erro erro = new Erro();
            erro.setVisible(true);
            return;
        }
        double nota = api.calcularCR();
        CR cr = new CR();
        cr.setCR(nota);
        cr.setVisible(true);
    }//GEN-LAST:event_calcularCR

    // Esse método é chamado quando o usuário aciona o botão "Deletar Tabela" no 
    // lado direito da janela. Primeiro, ele verifica se o usuário não fez login,
    // caso não tenha feito, ele instancia a classe Erro e define sua visualização 
    // como true. Caso tenha feito, ele chama os métodos API.deletarTabela e limparTabela
    private void deletarTabela(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarTabela
        if ("Login".equals(jMenu1.getText())) {
            Erro erro = new Erro();
            erro.setVisible(true);
            return;
        }
        api.deletarTabela();
        limparTabela();
    }//GEN-LAST:event_deletarTabela

    // Esse método é chamado quando o login do usuário é validado e define o texto
    // do menu na barra superior como o nome de usuário utilizado no login, troca
    // a visualização dos itens, chama os métodos API.criarTabela e escreverTabela
    public void loginDone(String usuario) {
        jMenu1.setText(usuario);
        jMenuItem1.setVisible(false);
        jMenuItem2.setVisible(true);
        api.criarTabela();
        escreverTabela();
    }

    // Esse método define o modelo de jTable1 com os dados da tabela materias
    public void escreverTabela() {
        Object obj = api.lerTabela();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                (Object[][]) obj,
                new String[]{
                    "ID", "Nome", "Código", "AV1", "AVA1", "AV2", "AVA2", "NF"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    // Esse método limpa o modelo de jTable1 apagando os dados
    public void limparTabela() {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Nome", "Código", "AV1", "AVA1", "AV2", "AVA2", "NF"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
