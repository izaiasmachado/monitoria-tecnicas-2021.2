// Disciplina      : ECO0015 - Técnicas de Programação
// Professor       : Wendley Souza da Silva
// Descrição       : (Classe de Telas) - Trabalho - Java
// Autor(a)        : Izaias Machado Pessoa Neto
// Data de Entrega : 12/03/2021

package trabalho;

import javax.swing.*;
import java.awt.*;

/**
 * Aqui temos as diversas telas requisitadas, temos validação dos dados entrados do usuário e também verificamos se as 
 * operações foram ou não realizadas.  
 */

public class Telas {
    public String formatarReal(Double valor) {
        String texto = String.format("%.2f", valor);
        return "R$ " + texto;
    }

    /*** 
     * Inicialmente temos a tela de bem-vindo.
     */
    public void mostrarMensagemDeBoasVindas() {
        JOptionPane.showMessageDialog(null, "Boas-vindas!");
    }

    /** 
     * A função gerarPainel gera o template do painel baseado no tipo da conta.
     */
    public static JPanel gerarPainel(String tipoConta) {
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel(tipoConta);
        JLabel label2 = new JLabel("Digite os dados da sua conta:");

        Font font1 = label1.getFont().deriveFont(Font.BOLD, 24f);
        label1.setFont(font1);

        Font font2 = label1.getFont().deriveFont(Font.BOLD, 12f);
        label2.setFont(font2);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label1, gbc);
        panel.add(label2, gbc);

        return panel;
    }

    /**
     * A seguir temos três funções para pedir os dados das contas.
     * Perceba que são feitas diversas validações do input.
     * 
     * - Validação se o usuário deixou algum campo vazio.
     * - Validação de se o input está no formato válido.
     * - Verificação de se o número da conta já está sendo utilizado.  
     */
    public void pergutarInformacoes(Contas conta) {
        Banco banco = new Banco();
        String tipoConta = conta.getTipoConta();
        JPanel panel = gerarPainel(tipoConta);

        JLabel nome = new JLabel("Nome do Titular");
        JTextField campoNome = new JTextField("");

        JLabel numero = new JLabel("Numero da Conta");
        JTextField campoNumero = new JTextField("");

        JLabel saldo = new JLabel("Saldo Inicial");
        JTextField campoSaldo = new JTextField("");

        panel.add(nome);
        panel.add(campoNome);

        panel.add(numero);
        panel.add(campoNumero);

        panel.add(saldo);
        panel.add(campoSaldo);

        Object[] opcoes = { "Salvar", "Pular" };
        int resultado = JOptionPane.showOptionDialog(
            null, 
            panel, 
            tipoConta,
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, 
            opcoes, 
            opcoes[1]);

        String textoCampoNome = campoNome.getText();
        String textoCampoNumero = campoNumero.getText();
        String textoCampoSaldo = campoSaldo.getText();
        boolean deixouCampoEmBranco = (textoCampoNome.length() == 0 || textoCampoNumero.length() == 0 || textoCampoSaldo.length() == 0); 

        if (resultado == 0) {
            if (deixouCampoEmBranco) {
                mostrarMensagemDeErroPorFaltaDeDados();
                pergutarInformacoes(conta);
            } else {
                try {
                    int valorNumero = Integer.parseInt(textoCampoNumero);
                    double valorSaldo = Double.parseDouble(textoCampoSaldo);
                    Contas buscarConta = banco.getContaByNumero(valorNumero);
                    boolean contaEncontrada = (buscarConta.getNumero() == valorNumero);

                    if (!contaEncontrada) {
                        conta.setNome(textoCampoNome);
                        conta.setNumero(valorNumero);
                        conta.setSaldo(valorSaldo);
                    } else {
                        mostrarMensagemDeErroContasComNumerosIguais();
                        pergutarInformacoes(conta);
                    }

                } catch (NumberFormatException e) {
                    mostrarMensagemDeErroPorDadosInconsistentes();
                    pergutarInformacoes(conta);
                }
            }
        }
    }

    public void pergutarInformacoes(ContaPoupanca conta) {
        Banco banco = new Banco();
        String tipoConta = conta.getTipoConta();
        JPanel panel = gerarPainel(tipoConta);

        JLabel nome = new JLabel("Nome do Titular");
        JTextField campoNome = new JTextField("");

        JLabel numero = new JLabel("Numero da Conta");
        JTextField campoNumero = new JTextField("");

        JLabel saldo = new JLabel("Saldo Inicial");
        JTextField campoSaldo = new JTextField("");

        JLabel taxa = new JLabel("Taxa de Reajuste (%)");
        JTextField campoTaxa = new JTextField("");

        panel.add(nome);
        panel.add(campoNome);

        panel.add(numero);
        panel.add(campoNumero);

        panel.add(saldo);
        panel.add(campoSaldo);

        panel.add(taxa);
        panel.add(campoTaxa);

        Object[] opcoes = { "Salvar", "Pular" };
        int resultado = JOptionPane.showOptionDialog(
            null, 
            panel, 
            tipoConta,
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, 
            opcoes, 
            opcoes[1]);

        String textoCampoNome = campoNome.getText();
        String textoCampoNumero = campoNumero.getText();
        String textoCampoSaldo = campoSaldo.getText();
        String textoCampoTaxa = campoTaxa.getText();
        boolean deixouCampoEmBranco = (textoCampoNome.length() == 0 || textoCampoNumero.length() == 0 || textoCampoSaldo.length() == 0 || textoCampoTaxa.length() == 0);

        if (resultado == 0) {
            if (deixouCampoEmBranco) {
                mostrarMensagemDeErroPorFaltaDeDados();
                pergutarInformacoes(conta);
            } else {
                try {
                    int valorNumero = Integer.parseInt(textoCampoNumero);
                    double valorSaldo = Double.parseDouble(textoCampoSaldo);
                    double valorTaxa = Double.parseDouble(textoCampoTaxa);
                    Contas buscarConta = banco.getContaByNumero(valorNumero);
                    boolean contaEncontrada = (buscarConta.getNumero() == valorNumero);

                    if (!contaEncontrada) {                    
                        conta.setNome(textoCampoNome);
                        conta.setNumero(valorNumero);
                        conta.setSaldo(valorSaldo);
                        conta.setTaxa(valorTaxa);
                    } else {
                        mostrarMensagemDeErroContasComNumerosIguais();
                        pergutarInformacoes(conta);
                    }

                } catch (NumberFormatException e) {
                    mostrarMensagemDeErroPorDadosInconsistentes();
                    pergutarInformacoes(conta);
                }
            }
        }
    }

    public void pergutarInformacoes(ContaEspecial conta) {
        Banco banco = new Banco();
        String tipoConta = conta.getTipoConta();
        JPanel panel = gerarPainel(tipoConta);

        JLabel nome = new JLabel("Nome do Titular");
        JTextField campoNome = new JTextField("");

        JLabel numero = new JLabel("Numero da Conta");
        JTextField campoNumero = new JTextField("");

        JLabel saldo = new JLabel("Saldo Inicial");
        JTextField campoSaldo = new JTextField("");

        JLabel limite = new JLabel("Limite");
        JTextField campoLimite = new JTextField("");

        JLabel multa = new JLabel("Multa (%)");
        JTextField campoMulta = new JTextField("");

        panel.add(nome);
        panel.add(campoNome);

        panel.add(numero);
        panel.add(campoNumero);

        panel.add(saldo);
        panel.add(campoSaldo);

        panel.add(limite);
        panel.add(campoLimite);

        panel.add(multa);
        panel.add(campoMulta);

        Object[] opcoes = { "Salvar", "Pular" };
        int resultado = JOptionPane.showOptionDialog(
            null, 
            panel,
            tipoConta,
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, 
            opcoes, 
            opcoes[1]);

        String textoCampoNome = campoNome.getText();
        String textoCampoNumero = campoNumero.getText();
        String textoCampoSaldo = campoSaldo.getText();
        String textoCampoLimite = campoLimite.getText();
        String textoCampoMulta = campoMulta.getText();
        boolean deixouCampoEmBranco = (textoCampoNome.length() == 0 || textoCampoNumero.length() == 0 || textoCampoSaldo.length() == 0 || textoCampoLimite.length() == 0 || textoCampoMulta.length() == 0);

        if (resultado == 0) {
            if (deixouCampoEmBranco) {
                mostrarMensagemDeErroPorFaltaDeDados();
                pergutarInformacoes(conta);
            } else {
                try {
                    int valorNumero = Integer.parseInt(textoCampoNumero);
                    double valorSaldo = Double.parseDouble(textoCampoSaldo);
                    int valorLimite = Integer.parseInt(textoCampoLimite);
                    double valorMulta = Double.parseDouble(textoCampoMulta);
                    Contas buscarConta = banco.getContaByNumero(valorNumero);
                    boolean contaEncontrada = (buscarConta.getNumero() == valorNumero);

                    if (!contaEncontrada) {
                        conta.setNome(textoCampoNome);
                        conta.setNumero(valorNumero);
                        conta.setSaldo(valorSaldo);
                        conta.setLimite(valorLimite);
                        conta.setMulta(valorMulta);
                    } else {
                        mostrarMensagemDeErroContasComNumerosIguais();
                        pergutarInformacoes(conta);
                    }
                } catch (NumberFormatException e) {
                    mostrarMensagemDeErroPorDadosInconsistentes();
                    pergutarInformacoes(conta);
                }
            }

        }
    }

    /**
     * Aqui temos o menu principal e temos os botões para as funções e de saida.
     */
    public void mostrarMenu() {
        Object[] options = { "Saque", "Deposito", "Transferencia", "Reajustar", "Ver Saldos", "Sair" };

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JButton botaoSaque = new JButton("Saque");
        botaoSaque.setVisible(true);
        panel.add(botaoSaque);

        JButton botaoDeposito = new JButton("Deposito");
        panel.add(botaoDeposito);

        JButton botaoTransferencia = new JButton("Transferencia");
        panel.add(botaoTransferencia);

        JButton botaoReajustar = new JButton("Reajustar");
        panel.add(botaoReajustar);

        JButton botaoVerSaldos = new JButton("Ver Saldos");
        panel.add(botaoVerSaldos);

        JButton botaoSair = new JButton("Sair");
        panel.add(botaoSair);

        int resultado = JOptionPane.showOptionDialog(panel, "Selecione a operacao desejada", "Contas", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[5]);
        if (resultado == 0)
            mostrarTelaDeSaque();
        if (resultado == 1)
            mostrarTelaDeDeposito();
        if (resultado == 2)
            mostrarTelaDeTransferencia();
        if (resultado == 3)
            mostrarTelaDeReajuste();
        if (resultado == 4)
            mostrarTelaSaldos();
        if (resultado == 5 || resultado == -1)
            mostrarTelaDeSaida();
    }

    /**
     * A tela de saque, tem uma diferença das outras telas de função, isso é, é necessário buscar as contas na memória e
     * dependendo do tipo da conta a mensagem é diferente. Se os dados forem digitados, consistentes e a conta for encontrada,
     * é, aparece uma mensagem de confirmação com o nome do titular da conta e o valor de saque. 
     * 
     * Depois disso, o programa deve dizer se o saque foi possível de ser realizado ou não, ou se o saque foi cancelado
     * pelo próprio usuário.
     * 
     * Se a conta for do tipo Conta Especial e houver sucesso no saque, deve aparecer 
     * "Saque efetuado utilizando cheque especial"  se não, "Saque efetuado com sucesso".
     */
    public void mostrarTelaDeSaque() {
        Banco banco = new Banco();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JLabel numero = new JLabel("Digite o numero da conta: ");
        JTextField campoNumero = new JTextField("");

        JLabel valor = new JLabel("Digite o valor para saque: ");
        JTextField campoValor = new JTextField("");

        panel.add(numero);
        panel.add(campoNumero);

        panel.add(valor);
        panel.add(campoValor);

        Object[] opcoes = { "Sacar", "Voltar" };
        int resultado = JOptionPane.showOptionDialog(
            null, 
            panel, 
            "Saque",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, 
            opcoes, 
            opcoes[1]);
        
        String textoNumero = campoNumero.getText();
        String textoValor = campoValor.getText();
        boolean deixouCampoEmBranco = (textoNumero.length() == 0 || textoValor.length() == 0);

        if (resultado == 0) {
            if (deixouCampoEmBranco) {
                mostrarMensagemDeErroPorFaltaDeDados();
                mostrarTelaDeSaque();
            } else {
                try {
                    int numeroContaInteiro = Integer.parseInt(textoNumero);
                    double valorMonetario = Double.parseDouble(textoValor);
                    Contas conta = banco.getContaByNumero(numeroContaInteiro);
                    boolean contaEncontrada = (conta.getNumero() == numeroContaInteiro);
                    boolean ehContaEspecial = (conta.getTipoConta() == "Conta-Especial");
                    String mensagemSaqueComSucesso = (ehContaEspecial)
                            ? "Saque efetuado utilizando cheque especial."
                            : "Saque efetuado com sucesso.";
    
                    if (contaEncontrada) {
                        int resultadoConfirmacao = JOptionPane.showConfirmDialog(null, conta.getNome() + " confirme que deseja sacar " + formatarReal(valorMonetario), "Confirmacao", JOptionPane.CANCEL_OPTION);
                        if (resultadoConfirmacao == JOptionPane.OK_OPTION) {
                            boolean saqueSucedido = conta.sacar(valorMonetario);
                            String mensagemSaque = (saqueSucedido) ? mensagemSaqueComSucesso : "Saldo insuficiente para saque.";
                            JOptionPane.showMessageDialog(null, mensagemSaque);
                        } else if (resultadoConfirmacao == JOptionPane.OK_CANCEL_OPTION) {
                            JOptionPane.showMessageDialog(null, "Saque cancelado.");
                        }
                    } else mostrarMensagemDeErroPorDadosInconsistentes();
                    mostrarMenu();
                } catch (NumberFormatException e) {
                    mostrarMensagemDeErroPorDadosInconsistentes();
                    mostrarTelaDeSaque();
                }
            }
        } else mostrarMenu();
    }

    /**
     * Na tela de depósito temos o número da conta e o valor. Então, é feita a validação dos dados e a conta é procurada
     * na memória. Se a conta existir e, é feita uma confirmação de depósito e independente da resposta, uma mensagem
     * aparece mensagem dizendo qual opção foi escolhida.
     */
    public void mostrarTelaDeDeposito() {
        Banco banco = new Banco();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JLabel numero = new JLabel("Digite o numero da conta: ");
        JTextField campoNumero = new JTextField("");

        JLabel valor = new JLabel("Digite o valor para depósito: ");
        JTextField campoValor = new JTextField("");

        panel.add(numero);
        panel.add(campoNumero);

        panel.add(valor);
        panel.add(campoValor);
        
        Object[] opcoes = { "Depositar", "Voltar" };
        int resultado = JOptionPane.showOptionDialog(
            null, 
            panel, 
            "Deposito",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, 
            opcoes, 
            opcoes[1]);

        String textoNumero = campoNumero.getText();
        String textoValor = campoValor.getText();
        boolean deixouCampoEmBranco = (textoNumero.length() == 0 || textoValor.length() == 0);

        if (resultado == JOptionPane.OK_OPTION) {
            if (deixouCampoEmBranco) {
                mostrarMensagemDeErroPorFaltaDeDados();
                mostrarTelaDeDeposito();
            } else {
                try {
                    int numeroContaInteiro = Integer.parseInt(textoNumero);
                    double valorMonetario = Double.parseDouble(textoValor);
                    Contas conta = banco.getContaByNumero(numeroContaInteiro);
                    boolean contaEncontrada = (conta.getNumero() == numeroContaInteiro);
                    
                    if (contaEncontrada) {
                        int resultadoConfirmacao = JOptionPane.showConfirmDialog(null, conta.getNome() + " confirme que deseja depositar " + formatarReal(valorMonetario), "Confirmacao", JOptionPane.CANCEL_OPTION);
                        if (resultadoConfirmacao == JOptionPane.OK_OPTION) {
                            conta.depositar(valorMonetario);
                            JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");
                        } else if (resultadoConfirmacao == JOptionPane.OK_CANCEL_OPTION) {
                            JOptionPane.showMessageDialog(null, "Deposito cancelado.");
                        }
                    } else mostrarMensagemDeErroPorDadosInconsistentes();
                    
                    mostrarMenu();
                } catch (NumberFormatException e) {
                    mostrarMensagemDeErroPorDadosInconsistentes();
                    mostrarTelaDeDeposito();
                }
            }
        } else mostrarMenu();
    }

    /**
     * Nessa função, são entrados os números de duas contas e um valor. Então, as contas são procuradas
     * no nosso armazenamento de memória e então é dado procedência. Se as contas existirem e tudo for válido,
     * é mostrado uma tela de confirmação de ação e independente da resposta aparece uma mensagem informando a
     * opção escolhida. Se as contas não existirem, é mostrado erro por dados inconsistentes.
     */
    public void mostrarTelaDeTransferencia() {
        Banco banco = new Banco();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JLabel contaRemetente = new JLabel("Digite o valor da conta remetente: ");
        JTextField campoContaRemetente = new JTextField("");

        JLabel contaDestino = new JLabel("Digite o valor da conta destinataria: ");
        JTextField campoContaDestino = new JTextField("");

        JLabel valor = new JLabel("Digite o valor de transferencia: ");
        JTextField campoValor = new JTextField("");

        panel.add(contaRemetente);
        panel.add(campoContaRemetente);

        panel.add(contaDestino);
        panel.add(campoContaDestino);

        panel.add(valor);
        panel.add(campoValor);

        Object[] opcoes = { "Transferir", "Voltar" };
        int resultado = JOptionPane.showOptionDialog(
            null, 
            panel, 
            "Transferencia",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, 
            opcoes,
            opcoes[1]);
        
        String textoContaRemetente = campoContaRemetente.getText();
        String textoContaDestinatario = campoContaDestino.getText();
        String textoValor = campoValor.getText();
        boolean deixouCampoEmBranco = (textoContaRemetente.length() == 0 || textoContaRemetente.length() == 0 || textoValor.length() == 0);

        if (resultado == 0) {
            if (deixouCampoEmBranco) {
                mostrarMensagemDeErroPorFaltaDeDados();
                mostrarTelaDeTransferencia();
            } else {
                try {
                    int numeroContaRemetente = Integer.parseInt(textoContaRemetente);
                    int numeroContaDestinatario = Integer.parseInt(textoContaDestinatario);
                    double valorDeTransferencia = Double.parseDouble(textoValor);
        
                    Contas remetente = banco.getContaByNumero(numeroContaRemetente);
                    Contas destinatario = banco.getContaByNumero(numeroContaDestinatario);
                    boolean todasAsContasForamEncontradas = (remetente.getNumero() == numeroContaRemetente && destinatario.getNumero() == numeroContaDestinatario);
        
                    if (todasAsContasForamEncontradas) {
                        int resultadoConfirmacao = JOptionPane.showConfirmDialog(null, remetente.getNome() + " confirme que deseja transferir " + formatarReal(valorDeTransferencia) + " para " + destinatario.getNome(), "Confirmacao", JOptionPane.CANCEL_OPTION);
                        if (resultadoConfirmacao == 0) {
                            boolean resultadoTransferencia = banco.transferir(remetente, destinatario, valorDeTransferencia);
                            String mensagemAposConfirmacao = (resultadoTransferencia) ? "Transferencia feita com sucesso." : "Transferencia cancelada por falta de fundos.";
                            JOptionPane.showMessageDialog(null, mensagemAposConfirmacao);
                        } else if (resultadoConfirmacao == 2) {
                            JOptionPane.showMessageDialog(null, "Transferencia cancelada.");
                        }
                        mostrarMenu();
                    } else  {
                        mostrarMensagemDeErroPorDadosInconsistentes();
                        mostrarTelaDeTransferencia();
                    }
    
                } catch (NumberFormatException e) {
                    mostrarMensagemDeErroPorDadosInconsistentes();
                    mostrarTelaDeTransferencia();
                }
            }
        } else mostrarMenu();
    }

    /**
     * Tela para reajuste da poupança. Caso o usuário não digite, se assume uma taxa padrão constante de 10%.
     * Após isso, mostra uma mensagem com a confirmação de acordo com o que foi digitado, ou não.
     * 
     * Nesse caso, não é obrigatório preencher o campo, porém existe uma validação da formatação do input.
     */
    public void mostrarTelaDeReajuste() {
        ContaPoupanca conta = Principal.contaPoupanca;
        boolean contaEncontrada = (conta.getNome() != null);
        double TAXA_DE_REAJUSTE_PADRAO = 10.0; 

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JLabel taxa = new JLabel("Digite a taxa percentual para reajuste (%): ");
        JTextField campoTaxa = new JTextField("");
        
        panel.add(taxa);
        panel.add(campoTaxa);
        
        Object[] opcoes = { "Reajustar", "Voltar" };
        int resultado = JOptionPane.showOptionDialog(
            null, 
            panel, 
            "Reajuste da Poupanca",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, 
            opcoes, 
            opcoes[1]);
        
        String textoTaxa = campoTaxa.getText();
        boolean deixouCampoEmBranco = (textoTaxa.length() == 0);
                    
        if (resultado == 0) {
            if (contaEncontrada) {
                try {
                    double novaTaxa = (deixouCampoEmBranco) ? TAXA_DE_REAJUSTE_PADRAO : Double.parseDouble(textoTaxa);
                    conta.reajustar(novaTaxa);
                    JOptionPane.showMessageDialog(null, "Poupanca reajustada com taxa de " + novaTaxa + "%");
                    mostrarMenu();
                } catch (NumberFormatException e) {
                    mostrarMensagemDeErroPorDadosInconsistentes();
                    mostrarTelaDeReajuste();
                }
            } else {
                mostrarMensagemDeErroPorDadosInconsistentes();
                mostrarTelaDeReajuste();
            }
        } else mostrarMenu();
    }

    /**
     * Uma tela que mostra os números e o saldos de todas as contas registradas. Não modifica nenhum dado, só mostra.
     */
    public void mostrarTelaSaldos() {
        Contas contas[] = Principal.contas;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JLabel info = new JLabel("Numero das Contas e Saldo: ");
        panel.add(info);

        for (Contas conta : contas) {
            int numero = conta.getNumero();
            double saldo = conta.getSaldo();
            JLabel informacaoesConta = new JLabel(numero + ": " + formatarReal(saldo));
            panel.add(informacaoesConta);
        }

        Object[] opcoes = { "Ok" };
        JOptionPane.showOptionDialog(
            null, 
            panel, 
            "Saldos",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null, 
            opcoes, 
            opcoes[0]);

        mostrarMenu();
    }

    /**
     * Tela que aparece quando é clicado no botão sair. Aparece uma confirmação de saída, se aceitar aparece uma mensagem
     * confirmando a saída. Se não, volta para o menu principal.
     */
    public void mostrarTelaDeSaida() {
        Object[] opcoes = { "Sair", "Voltar" };
        JPanel panel = new JPanel();
        int resultado = JOptionPane.showOptionDialog(
            panel, 
            "Tem certeza que deseja sair do programa?", 
            "Confirmacao de Saida", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcoes,
            opcoes[1]);
        if (resultado == 0) JOptionPane.showMessageDialog(null, "Programa finalizado!");
        else mostrarMenu();
    }

    /**
     * Mostra a mensagem de erro que aparece quando o usuário esquece de digitar algum dado.  
     */
    public static void mostrarMensagemDeErroPorFaltaDeDados() {
        JOptionPane.showMessageDialog(null, "Voce esqueceu de preencher algum campo, por favor preencha todos os campos e tente novamente.");
    }

    /**
     * Mostra a mensagem de uando não conseguimos achar a conta do usuário ou também quando os dados digitados estão no
     * formato diferente do digitado.
     * 
     * Ex: Foi pedido um número inteiro e o usuário digita uma String.
     */
    public static void mostrarMensagemDeErroPorDadosInconsistentes() {
        JOptionPane.showMessageDialog(null, "Os dados digitados sao inconsistentes, verifique os dados e tente novamente.");
    }

    /**
     * Esse erro acontece quando o usuário entra um número de outra conta na hora do cadastro.
     */
    public static void mostrarMensagemDeErroContasComNumerosIguais() {
        JOptionPane.showMessageDialog(null, "Ja existe uma conta com esse numero, verifique os dados e tente novamente.");
    }
}