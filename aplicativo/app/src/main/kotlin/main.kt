fun main() {

    val contaAlex = Conta(titular = "Alex", numero = 1000)
    contaAlex.depositar(200.0)

    val contaFran = Conta(numero = 1001, titular = "Fran")
    contaFran.depositar(300.0)

    println("")
    println("-----------------------Bem vindo ao ByteBank----------------------------")
    println("")

    println("Nome: ${contaAlex.titular}")
    println("Número da Conta: ${contaAlex.numero}")
    println("Seu saldo: ${contaAlex.saldo}")

    println("")

    println("Nome: ${contaFran.titular}")
    println("Número da Conta: ${contaFran.numero}")
    println("Seu saldo: ${contaFran.saldo}")

    println("")

    println("Depositando na conta do Alex...")
    contaAlex.depositar(100.0)
    println(contaAlex.saldo)

    println("")

    println("Depositando na conta da Fran...")
    contaFran.depositar(100.0)
    println(contaFran.saldo)

    println("")
    println("-----------------------Bem vindo ao ByteBank - Transferência----------------------------")
    println("")

    contaAlex.sacar(25.0)
    println("Nome: ${contaAlex.titular}")
    println("Número da Conta: ${contaAlex.numero}")
    println("Seu saldo: ${contaAlex.saldo}")

    println("")

    contaFran.sacar(500.0)
    println("Nome: ${contaFran.titular}")
    println("Número da Conta: ${contaFran.numero}")
    println("Seu saldo: ${contaFran.saldo}")

    println("")
    println("Trannsferência Fran para o Alex")

    if (contaFran.transferir(100.0, contaAlex)) {
        println("Transferência Sucedida")
    } else {
        println("Falha na Transferência")
    }

    println("Saldo do Alex: ${contaAlex.saldo}")

    println("Saldo da Fran: ${contaFran.saldo}")

}


class Conta(
    val titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set


//    O "PRIVATE SET" deixa a variável privada. Colocar sempre em baixo
//    O This significa que você está mexendo dentro do mesmo Objeto ou Classe

    fun depositar(valor: Double) {
        if (valor >= 0) {
            this.saldo += valor
        }
    }

    fun sacar(valor: Double) {

        /*if (this.saldo >= valor) {
            this.saldo -= valor
            println("Saque sendo processado...")
        } else {
            println("Erro! Saldo insuficiente para esta transação.")
        }*/

        when {
            this.saldo >= valor -> {
                this.saldo -= valor
                println("Saque sendo processado...!!!!!")
            }

            else -> println("Erro! Saldo insuficiente para esta transação.!!!")
            // Usar o When deixa o código mais limpo e dá o mesmo resultado
        }
    }

    fun transferir(valor: Double, destino: Conta): Boolean {

        /*if (this.saldo >= valor) {
            this.saldo -= valor
            destino.saldo += valor
            return true
        } else {
            return false
        }*/

        when {
            this.saldo >= valor -> {
                this.saldo -= valor
                destino.depositar(valor)
                return true
            }

            else -> return false
        }
    }

//    fun getSaldo(): Double {
//        return this.saldo
//    }
//
//    fun setSaldo(valor: Double) {
//        if (valor >= 0)
//        this.saldo = valor
//    }
}
