import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppMain extends JFrame {
    private int pontos = 0;

    public AppMain() {
        setTitle("Aplicativo de Coleta Seletiva");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Botão para acessar Educação Ambiental
        JButton btnEducacao = new JButton("Educação Ambiental");
        btnEducacao.setBounds(100, 30, 300, 30);
        panel.add(btnEducacao);
        btnEducacao.addActionListener(e -> mostrarEducacaoAmbiental());

        // Botão para acessar Pontos de Coleta
        JButton btnPontosDeColeta = new JButton("Pontos de Coleta");
        btnPontosDeColeta.setBounds(100, 80, 300, 30);
        panel.add(btnPontosDeColeta);
        btnPontosDeColeta.addActionListener(e -> mostrarPontosDeColeta());

        // Botão para Classificação de Lixo
        JButton btnClassificacao = new JButton("Classificação de Lixo");
        btnClassificacao.setBounds(100, 130, 300, 30);
        panel.add(btnClassificacao);
        btnClassificacao.addActionListener(e -> mostrarClassificacaoDeLixo());

        // Botão para visualizar Relatório
        JButton btnRelatorio = new JButton("Relatório Estatístico");
        btnRelatorio.setBounds(100, 180, 300, 30);
        panel.add(btnRelatorio);
        btnRelatorio.addActionListener(e -> mostrarRelatorio());

        // Botão para ver Pontuação
        JButton btnPontuacao = new JButton("Ver Pontuação");
        btnPontuacao.setBounds(100, 230, 300, 30);
        panel.add(btnPontuacao);
        btnPontuacao.addActionListener(e -> verPontuacao());

        add(panel);
        setVisible(true);
    }

    // Método para exibir informações de Educação Ambiental
    private void mostrarEducacaoAmbiental() {
        JOptionPane.showMessageDialog(this,
                "Tipos de Lixo:\n1. Orgânico\n2. Reciclável\n3. Eletrônico\n4. Perigoso\n\n" +
                        "Dicas:\n- Separe o lixo corretamente.\n- Reduza o uso de plásticos.");
    }

    // Método para mostrar Pontos de Coleta
    private void mostrarPontosDeColeta() {
        JOptionPane.showMessageDialog(this, "Ponto de Coleta: Biblioteca\nTipo de Lixo: Reciclável\n\n" +
                "Ponto de Coleta: Bloco A\nTipo de Lixo: Orgânico");
    }

    // Método para Classificação de Lixo
    private void mostrarClassificacaoDeLixo() {
        String descricao = JOptionPane.showInputDialog(this, "Digite a descrição do lixo:");
        String tipoLixo = classificarLixo(descricao);
        JOptionPane.showMessageDialog(this, "Classificação: " + tipoLixo);
    }

    // Método de classificação de lixo
    private String classificarLixo(String descricao) {
        if (descricao.toLowerCase().contains("plástico")) {
            adicionarPontos(10);
            return "Reciclável - Plástico";
        } else if (descricao.toLowerCase().contains("papel")) {
            adicionarPontos(10);
            return "Reciclável - Papel";
        } else if (descricao.toLowerCase().contains("orgânico")) {
            adicionarPontos(5);
            return "Orgânico";
        } else {
            return "Tipo de lixo desconhecido. Verifique as informações.";
        }
    }

    // Método para adicionar pontos de incentivo
    private void adicionarPontos(int valor) {
        pontos += valor;
        JOptionPane.showMessageDialog(this, "Pontos adicionados! Total de pontos: " + pontos);
    }

    // Método para ver pontuação
    private void verPontuacao() {
        JOptionPane.showMessageDialog(this, "Pontuação atual: " + pontos);
    }

    // Método para exibir Relatório Estatístico
    private void mostrarRelatorio() {
        JOptionPane.showMessageDialog(this, "Relatório de Resíduos Coletados:\n" +
                "- Orgânico: 50kg\n- Reciclável: 120kg\n- Eletrônico: 30kg");
    }

    public static void main(String[] args) {
        new AppMain();
    }
}
