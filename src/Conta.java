public abstract class Conta {

    private int numero;

    private Cliente dono;

    protected double saldo;

    protected double limite;

    private Operacao[] operacoes;

    private int proximaOperacao;

    private static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;

        this.operacoes = new Operacao[1000];
        this.proximaOperacao = 0;

        totalContas++;
    }

    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.saldo -= valor;

            this.operacoes[proximaOperacao] = new OperacaoSaque(valor);
            this.proximaOperacao++;
            return true;
        }

        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        this.operacoes[proximaOperacao] = new OperacaoDeposito(valor);
        this.proximaOperacao++;
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = this.sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {

        String ContaString = "\n" + "Conta " + this.getNumero() + "\n" + this.getDono().toString() + "\n" + "Saldo: " + this.getSaldo()
                + "\n" + "Limite: " + this.getLimite() + "\n";

        return ContaString;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Conta conta = (Conta) obj;
            if (this.numero == (conta.numero)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void imprimirExtrato() {
        System.out.println("\n======= Extrato Conta " + this.numero + "======================");
        for (Operacao atual : this.operacoes) {
            if (atual != null) {
                atual.imprimir();
            }
        }
        System.out.println("================================================\n");
    }

    public abstract void setLimite(double limite);

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

}
