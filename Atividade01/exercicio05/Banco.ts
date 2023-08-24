interface IConta {
    Numero: string;
    Saldo: number;
    Titular: string;
    sacar(valor: number): boolean;
    depositar(valor: number): void;
    consultarSaldo(): number;
    transferir(contaDestino: IConta, valor: number): boolean;
}

abstract class ContaBase implements IConta {
    constructor(protected numero: string, protected saldo: number, protected titular: string) {}

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
        if (this.saldo - valor < 0) {
            return false;
        }
        
        this.saldo -= valor;
        return true;
    }
    

    public depositar(valor: number): void {
        this.saldo += valor;
    }

    public consultarSaldo() {
        return this.saldo;
    }

    public transferir(contaDestino: IConta, valor: number): boolean {
        if (!this.sacar(valor)) {
            return false;
        }
    
        contaDestino.depositar(valor);
        return true;
    }
    
}

class ContaCorrente extends ContaBase {
    constructor(numero: string, saldo: number, titular: string) {
        super(numero, saldo, titular);
    }
}

class ContaPoupanca extends ContaBase {
    constructor(numero: string, saldo: number, titular: string) {
        super(numero, saldo, titular);
    }
}

export class Banco {
    constructor(private contas: IConta[] = []) {}

    public inserir(conta: IConta): void {
        if (this.contas.some(c => c.Numero === conta.Numero)) {
            return;
        }
        
        this.contas.push(conta);
    }
    


    public consultarSaldo(numero: string): IConta | undefined {
        return this.contas.find(c => c.Numero === numero);
    }

    public sacar(numero: string, valor: number): void {
        const conta = this.consultarSaldo(numero);
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
