"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Banco = exports.Conta = void 0;
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
        if (this.saldo - valor < 0) {
            return false;
        }
        else {
            this.saldo = this.saldo - valor;
            return true;
        }
    }
    depositar(valor) {
        this.saldo = this.saldo + valor;
    }
    consultarSaldo() {
        return this.saldo;
    }
    transferir(contaDestino, valor) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        else {
            return false;
        }
    }
}
exports.Conta = Conta;
class Banco {
    constructor(contas = []) {
        this.contas = contas;
    }
    inserir(conta) {
        if (this.consultarIndice(conta.Numero) == -1) {
            this.contas.push(conta);
        }
    }
    consultarSaldo(numero) {
        let contaProcurada;
        for (let c of this.contas) {
            if (c.Numero == numero) {
                contaProcurada = c;
                break;
            }
        }
        return contaProcurada;
    }
    consultarIndice(numero) {
        let indice = -1;
        for (let i = 0; i < this.contas.length; i++) {
            if (this.contas[i].Numero == numero) {
                indice = i;
                break;
            }
        }
        return indice;
    }
    sacar(numero, valor) {
        let conta = this.consultarSaldo(numero);
        if (conta != null) {
            conta.sacar(valor);
        }
    }
    depositar(numero, valor) {
        let conta = this.consultarSaldo(numero);
        if (conta != null) {
            conta.depositar(valor);
        }
    }
    transferir(numCredito, numDebito, valor) {
        let conta1 = this.consultarSaldo(numCredito);
        let conta2 = this.consultarSaldo(numDebito);
        if (conta1 != null && conta2 != null) {
            conta2.transferir(conta1, valor);
        }
    }
    quantidadeContas() {
        return this.contas.length;
    }
    depositoTotal() {
        let soma = 0;
        for (let i = 0; i < this.contas.length; i++) {
            soma += this.contas[i].Saldo;
        }
        return soma;
    }
    mediaTotal() {
        let media = this.depositoTotal() / this.quantidadeContas();
        return media;
    }
    excluir(numero) {
        for (let i = 0; i < this.contas.length; i++) {
            if (this.contas[i].Numero == numero) {
                this.contas.splice(i, 1);
                break;
            }
        }
    }
}
exports.Banco = Banco;
