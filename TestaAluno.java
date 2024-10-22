// Nome: Matheus Angelo de Souza Santos | CB3025489
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TestaAluno extends Frame implements ActionListener {
    // Componentes
    private TextField nomeField, idadeField, enderecoField;
    private Button okButton, limparButton, mostrarButton, sairButton;
    private List<Aluno> listaAlunos; // Lista para armazenar alunos

    public TestaAluno() {
        // Inicializar a lista de alunos
        listaAlunos = new ArrayList<>();

        // Configurar janela principal
        Frame f = new Frame("Cadastro de Alunos");
        f.setSize(400, 180);
        f.setLayout(new BorderLayout());
        f.addWindowListener(new FechaJanela());

        // Painel para campos de entrada (labels e textboxes)
        Panel camposPanel = new Panel();
        camposPanel.setLayout(new GridLayout(3, 2, 10, 10)); // 3 linhas, 2 colunas

        // Campos de entrada
        nomeField = new TextField(20);
        idadeField = new TextField(20);
        enderecoField = new TextField(20);

        camposPanel.add(new Label("Nome: ", Label.LEFT));
        camposPanel.add(nomeField);

        camposPanel.add(new Label("Idade: ", Label.LEFT));
        camposPanel.add(idadeField);

        camposPanel.add(new Label("Endereço: ", Label.LEFT));
        camposPanel.add(enderecoField);

        // Adicionar o painel de campos à parte superior da janela
        f.add(camposPanel, BorderLayout.CENTER);

        // Painel para os botões
        Panel botoesPanel = new Panel();
        botoesPanel.setLayout(new GridLayout(1, 4, 10, 10)); // 1 linha, 4 colunas

        // Botões
        okButton = new Button("Ok");
        limparButton = new Button("Limpar");
        mostrarButton = new Button("Mostrar");
        sairButton = new Button("Sair");

        // Adicionando botões ao painel
        botoesPanel.add(okButton);
        botoesPanel.add(limparButton);
        botoesPanel.add(mostrarButton);
        botoesPanel.add(sairButton);

        // Adicionar o painel de botões à parte inferior da janela
        f.add(botoesPanel, BorderLayout.SOUTH);

        // Adicionar ActionListener aos botões
        okButton.addActionListener(this);
        limparButton.addActionListener(this);
        mostrarButton.addActionListener(this);
        sairButton.addActionListener(this);

        // Exibir a janela
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            // Adicionar aluno à lista
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            String endereco = enderecoField.getText();

            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setIdade(idade);
            aluno.setEndereco(endereco);

            listaAlunos.add(aluno);

            // Mensagem de confirmação
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!\nUUID: " + aluno.getUuid());
        } else if (e.getSource() == limparButton) {
            // Limpar os campos de texto
            nomeField.setText("");
            idadeField.setText("");
            enderecoField.setText("");
        } else if (e.getSource() == mostrarButton) {
            // Exibir lista de alunos cadastrados
            StringBuilder alunosCadastrados = new StringBuilder();
            for (Aluno aluno : listaAlunos) {
                alunosCadastrados.append("UUID: ").append(aluno.getUuid()).append("\n")
                                 .append("Nome: ").append(aluno.getNome()).append("\n")
                                 .append("Idade: ").append(aluno.getIdade()).append("\n")
                                 .append("Endereço: ").append(aluno.getEndereco()).append("\n\n");
            }

            JOptionPane.showMessageDialog(null, alunosCadastrados.length() > 0 ? alunosCadastrados.toString() : "Nenhum aluno cadastrado.");
        } else if (e.getSource() == sairButton) {
            // Fechar a aplicação
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TestaAluno();
    }
}

// Classe para fechar a janela
class FechaJanela extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
