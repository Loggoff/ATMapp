package ATM

//класс описывающий пользователя и действия с балансом счетов

data class Account(val cardNum: Int, val cardPin: Int) {

    var saveBalance: Double = 0.00
        private set

    var creditBalance: Double = 0.00
        private set

    fun withdrawSaveMoney(value: Double) {
        if (value <= 0) {
            println("Incorrect value")
        }
        if (value > saveBalance) {
            println("insufficient funds")
        } else {
            saveBalance -= value
        }
    }

    fun topUpSaveMoney(value: Double) {
        if (value <= 0) {
            println("Incorrect value")
        } else {
            saveBalance += value
        }
    }

    fun withdrawCreditMoney(value: Double) {
        if (value <= 0) {
            println("Incorrect value")
        }
        if (value > creditBalance) {
            println("insufficient funds")
        } else {
            creditBalance -= value
        }

    }

    fun topUpCreditMoney(value: Double) {
        if (value <= 0) {
            println("Incorrect value")
        } else {
            creditBalance += value
        }
    }
}
