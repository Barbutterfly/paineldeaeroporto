package projetoA3;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class InterfaceGafica {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JButton btnTabela;
    private JButton btnSalvar;

    // Adicione uma instância da sua classe Filas aqui
    private Filas filas = new Filas(); // Certifique-se de ajustar conforme sua implementação
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                	InterfaceGafica window = new InterfaceGafica();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InterfaceGafica() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Restante do código ...

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ao clicar no botão salvar, cria um novo voo com os dados da interface
                int horario = Integer.parseInt(textField.getText());
                int id = Integer.parseInt(textField_1.getText());
                String empresa = textField_2.getText();
                String destino = textField_3.getText();
                String portao = textField_4.getText();

                // Adiciona o voo à instância da classe Filas
                filas.adicionarVoo(id, horario, empresa.charAt(0), destino.charAt(0), portao.charAt(0));

                JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso","Sucesso", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Voo salvo na fila.");
            }
        });
        btnSalvar.setBounds(316, 195, 89, 23);
        frame.getContentPane().add(btnSalvar);

        btnTabela = new JButton("Tabela");
        btnTabela.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnTabela.setBounds(316, 229, 89, 23);
        frame.getContentPane().add(btnTabela);
        
        lblNewLabel = new JLabel("Painel de controle de voo");
        lblNewLabel.setBounds(139, 11, 143, 15);
        frame.getContentPane().add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("Digite o horario do voo: ");
        lblNewLabel_1.setBounds(10, 40, 151, 14);
        frame.getContentPane().add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Digite o ID do voo: ");
        lblNewLabel_2.setBounds(10, 65, 105, 14);
        frame.getContentPane().add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("Digite a empresa aérea: ");
        lblNewLabel_3.setBounds(10, 94, 131, 14);
        frame.getContentPane().add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("Digite o destino do voo: ");
        lblNewLabel_4.setBounds(10, 125, 131, 14);
        frame.getContentPane().add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Digite o portão do voo: ");
        lblNewLabel_5.setBounds(10, 150, 131, 14);
        frame.getContentPane().add(lblNewLabel_5);
        
        textField_5 = new JTextField();
        textField_5.setBounds(171, 37, 234, 20);
        frame.getContentPane().add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(171, 62, 234, 20);
        frame.getContentPane().add(textField_6);
        
        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(171, 91, 234, 20);
        frame.getContentPane().add(textField_7);
        
        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(171, 122, 234, 20);
        frame.getContentPane().add(textField_8);
        
        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(171, 147, 234, 20);
        frame.getContentPane().add(textField_9);
    }

    
   
    // Aqui é implementada a fila na interface no cadastro 
    //E também aqui recupera od dados da filas para mostrar e aramazenar no botão de tabela

private class Filas {
    private Queue<Character> empString = new LinkedList<>();  
    private Queue<Character> destString = new LinkedList<>();
    private Queue<Character> portString = new LinkedList<>();
    private Queue<Integer> horarioInt = new LinkedList<>();
    private Queue<Integer> idInt = new LinkedList<>();

    public void adicionarVoo(int id, int horario, char empresa, char destino, char portao) {
        horarioInt.add(horario);
        idInt.add(id);
        empString.add(empresa);
        destString.add(destino);
        portString.add(portao);
    }

    public void exibirTabela() { 
        // Cria uma mensagem formatada com os dados da tabela
        StringBuilder tabela = new StringBuilder("Tabela de Voos:\n");
        tabela.append("ID\tHorário\tEmpresa\tDestino\tPortão\n");
        
        while (!idInt.isEmpty()) {
            tabela.append(idInt.poll()).append("\t").append(horarioInt.poll()).append("\t")
                    .append(empString.poll()).append("\t").append(destString.poll()).append("\t")
                    .append(portString.poll()).append("\n");
        }
     // Exibe a tabela usando JOptionPane
     JOptionPane.showMessageDialog(null, tabela.toString(), "Tabela de Voos", JOptionPane.INFORMATION_MESSAGE);


    }
}
}