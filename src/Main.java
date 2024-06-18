import java.util.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Cliente joao = new PessoaFisica("João", "Av. Antonio Carlos, 6627",
                new Date(), "111.111.111-11", 36, 'm');

        Cliente icaro = new PessoaFisica("Icaro", "Rua Carlos torrezani, 367",
                new Date(), "147.477.926-35", 16, 'm');

        Cliente lojinha = new PessoaJuridica("Loja R$1,99", "Av. Afonso Pena, 3000",
                new Date(), "000.00000.0000/0001", 25, "Comércio");

        Cliente mercado = new PessoaJuridica("Mercadão do seu zé", "Av. Antonio Carlos, 1997",
                new Date(), "111.11111.1111/1115", 5, "Comércio");


        Conta conta1 = new ContaUniversitaria(1234, joao, 20000);
        Conta conta2 = new ContaCorrente(1235, lojinha, 10000);
        Conta conta3 = new ContaPoupanca(1236, icaro, 100000);
        Conta conta4 = new ContaCorrente(1237, mercado, 250000);

        System.out.println("=========CONTAS=========\n========================\n");

        System.out.println(conta1.getNumero() + " = " + joao.getNome());
        System.out.println(conta2.getNumero() + " = " + lojinha.getNome());
        System.out.println(conta3.getNumero() + " = " + icaro.getNome());
        System.out.println(conta4.getNumero() + " = " + mercado.getNome() + "\n");

            boolean contas = true;

            while(contas) {

                System.out.println("Qual conta quer acessar? ");
                System.out.println(joao.getNome());
                System.out.println(icaro.getNome());
                System.out.println(lojinha.getNome());
                System.out.println(mercado.getNome() + "\n");
                System.out.println("Digite sair para finalizar:");

                String escolha = entrada.nextLine();
                if(escolha.equalsIgnoreCase("sair")){
                    contas = false;
                    System.out.println("Encerrando programa...");
                }
                else if (escolha.equals(joao.getNome())) {
                    System.out.println("Chave JOÂO: ");
                    String chave = entrada.nextLine();
                    if (joao.autenticar(chave)) {
                        System.out.println("Autenticado!! Bem vindo Cliente João");
                        conta1.depositar(3000);
                        conta1.depositar(2000);
                        conta1.sacar(500);
                        conta1.setLimite(550);
                        System.out.println(joao.toString());
                        conta1.imprimirExtrato();
                        System.out.println("Saldo João: " + conta1.getSaldo());
                        System.out.println("Limite João: " + conta1.getLimite());
                    } else {
                        System.out.println("Nao esta autenticado!");
                    }
                } else if (escolha.equals(lojinha.getNome())) {

                    System.out.println("Chave R$Loja 1,99: ");
                    String chave2 = entrada.nextLine();
                    if (lojinha.autenticar(chave2)) {
                        System.out.println("Autenticado!! Bem vindo Cliente lojinha");
                        conta2.depositar(1500);
                        conta2.depositar(2100);
                        conta2.sacar(600);
                        conta2.transferir(conta1, 777);
                        conta2.depositar(234);
                        conta2.setLimite(700);
                        System.out.println(lojinha.toString());
                        conta2.imprimirExtrato();
                        System.out.println("Saldo Loja R$1,99: " + conta2.getSaldo());
                        System.out.println("Limite Loja R$1,99: " + conta2.getLimite());
                    } else {
                        System.out.println(lojinha.getNome() + " Nao esta autenticado!" + "\n");
                    }
                } else if (escolha.equals(icaro.getNome())) {

                    System.out.println("Chave ICARO: ");
                    String chave3 = entrada.nextLine();
                    if (icaro.autenticar(chave3)) {
                        System.out.println("Autenticado!! Bem vindo Cliente Icaro");
                        conta3.depositar(1800);
                        conta3.depositar(1000);
                        conta3.sacar(2000);
                        conta3.setLimite(1260);
                        System.out.println(icaro.toString());
                        conta3.imprimirExtrato();
                        System.out.println("Saldo Icaro: " + conta3.getSaldo());
                        System.out.println("Limite Icaro: " + conta3.getLimite());
                    } else {
                        System.out.println(icaro.getNome() + " Nao esta autenticado!");
                    }
                } else if (escolha.equals(mercado.getNome())) {
                    System.out.println("Chave Mercadão do seu zé: ");
                    String chave4 = entrada.nextLine();
                    if (mercado.autenticar(chave4)) {
                        System.out.println("Autenticado!! Bem vindo Cliente Mercadão do seu zé");
                        conta4.depositar(1500);
                        conta4.depositar(2100);
                        conta4.sacar(600);
                        conta4.transferir(conta1, 777);
                        conta4.depositar(234);
                        conta4.setLimite(1000);
                        System.out.println(mercado.toString());
                        conta4.imprimirExtrato();
                        System.out.println("Saldo Mercadão do seu zé: " + conta4.getSaldo());
                        System.out.println("Limite Mercadão do seu zé: " + conta4.getLimite());
                    } else {
                        System.out.println(mercado.getNome() + " Nao esta autenticado!" + "\n");
                    }
                } else {
                    System.out.println("Conta invalida!!!");
                }

                int media = Operacao.getTotalOperacoes() / Conta.getTotalContas();
                System.out.println("Média de operações por conta aberta: " + media + "\n");
            }




        //teste para ver se sao as mesmas contas
        /*
        System.out.println("Sobre as contas:");

        if (conta1.equals(conta2)) {
            System.out.println("É a mesma conta, pois é o mesmo número identificador!\n");
        } else {
            System.out.println("É uma conta diferente, o número identificador é diferente!\n");
        }

        System.out.println("Sobre as pessoas físicas:");
        if (joao.equals(icaro)) {
            System.out.println("É o mesmo cliente, pois o CPF é igual para ambos clientes!\n");
        } else {
            System.out.println("São clientes diferentes, os CPFs são diferentes!\n");
        }

        System.out.println("Sobre as pessoas jurídicas:");
        if (lojinha.equals(mercado)) {
            System.out.println("É o mesmo cliente, pois o CNPJ é igual para ambos clientes!\n");
        } else {
            System.out.println("São clientes diferentes, os CNPJs são diferentes!\n");
        }
    }*/
    }
}