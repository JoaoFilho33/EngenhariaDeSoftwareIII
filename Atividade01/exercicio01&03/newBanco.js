"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Banco = void 0;
class Conta {
    constructor(numero, saldo, titular) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
    }
    get Numero() {
        return this.numero;
    }
    get Saldo() {
        return this.saldo;
    }
    get Titular() {
        return this.titular;
    }
    sacar(valor) {
        // Verificação de valor de saque inválido
        if (valor <= 0) {
            throw new Error("Valor de saque inválido");
        }
        // Verificação de saldo suficiente para saque
        if (this.saldo < valor) {
            return false;
        }
        this.saldo -= valor;
        return true;
    }
    depositar(valor) {
        // Verificação de valor de depósito inválido
        if (valor <= 0) {
            throw new Error("Valor de depósito inválido");
        }
        this.saldo += valor;
    }
    transferir(contaDestino, valor) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }
}
class Banco {
    constructor(contas = []) {
        this.contas = contas;
    }
    inserir(conta) {
        // Verificação para evitar inserção duplicada de contas
        if (!this.contas.some(c => c.Numero === conta.Numero)) {
            this.contas.push(conta);
        }
    }
    consultarSaldo(numero) {
        // Utilização do método Array.find() para procurar conta
        return this.contas.find(c => c.Numero === numero);
    }
    sacar(numero, valor) {
        const conta = this.consultarSaldo(numero);
        // Verificação de conta existente
        if (!conta) {
            throw new Error("Conta não encontrada");
        }
        conta.sacar(valor);
    }
    depositar(numero, valor) {
        const conta = this.consultarSaldo(numero);
        // Verificação de conta existente
        if (!conta) {
            throw new Error("Conta não encontrada");
        }
        conta.depositar(valor);
    }
    transferir(numCredito, numDebito, valor) {
        const contaCredito = this.consultarSaldo(numCredito);
        const contaDebito = this.consultarSaldo(numDebito);
        // Verificação de contas existentes
        if (!contaCredito || !contaDebito) {
            throw new Error("Conta(s) não encontrada(s)");
        }
        contaDebito.transferir(contaCredito, valor);
    }
    // Métodos de quantidadeContas(), depositoTotal() e excluir() permanecem inalterados.
    mediaTotal() {
        const totalDepositos = this.contas.reduce((total, conta) => total + conta.Saldo, 0);
        return totalDepositos / this.contas.length;
    }
}
exports.Banco = Banco;
