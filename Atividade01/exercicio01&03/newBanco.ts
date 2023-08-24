//https://github.com/JoaoFilho33/P.O.O.---ADS/blob/main/atividade06/banco.ts

class Conta {
    constructor(private numero: string, private saldo: number, private titular: string) {}

    public get Numero(): string {
        return this.numero;
    }

    public get Saldo(): number {
        return this.saldo;
    }

    public get Titular(): string {
        return this.titular;
    }

    public sacar(valor: number): boolean {
        if (valor <= 0) {
            throw new Error("Valor de saque inválido");
        }

        if (this.saldo < valor) {
            return false;
        }

        this.saldo -= valor;
        return true;
    }

    public depositar(valor: number): void {
        if (valor <= 0) {
            throw new Error("Valor de depósito inválido");
        }

        this.saldo += valor;
    }

    public transferir(contaDestino: Conta, valor: number): boolean {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }
}

export class Banco {
   constructor(private contas: Conta[] = []) {}

    public inserir(conta: Conta): void {
        // Verificação para evitar inserção duplicada de contas
        if (!this.contas.some(c => c.Numero === conta.Numero)) {
            this.contas.push(conta);
        }
    }

    public consultarSaldo(numero: string): Conta | undefined {
        // Utilização do método Array.find() para procurar conta
        return this.contas.find(c => c.Numero === numero);
    }

    public sacar(numero: string, valor: number): void {
        const conta = this.consultarSaldo(numero);
        // Verificação de conta existente
        if (!conta) {
            throw new Error("Conta não encontrada");
        }
        conta.sacar(valor);
    }

    public depositar(numero: string, valor: number): void {
        const conta = this.consultarSaldo(numero);
        if (!conta) {
            throw new Error("Conta não encontrada");
        }
        conta.depositar(valor);
    }

    public transferir(numCredito: string, numDebito: string, valor: number): void {
        const contaCredito = this.consultarSaldo(numCredito);
        const contaDebito = this.consultarSaldo(numDebito);

        // Verificação de contas existentes
        if (!contaCredito || !contaDebito) {
            throw new Error("Conta(s) não encontrada(s)");
        }

        contaDebito.transferir(contaCredito, valor);
    }

    public mediaTotal(): number {
        const totalDepositos = this.contas.reduce((total, conta) => total + conta.Saldo, 0);
        return totalDepositos / this.contas.length;
    }
}