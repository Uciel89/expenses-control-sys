export class Saldo {
    value: number;

    constructor(value: number) {
        this.value = value;
        this.constatarSaldo();
    }

    private constatarSaldo() {
        if (this.value == 0) {
            throw new Error("El saldo no puede ser 0");
        }
    }
}