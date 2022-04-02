package ATM

import java.lang.Exception
import kotlin.system.exitProcess

class AtmApp(val accounts: List<Account>) {

    fun start() {
        var flag = true
        var userCrd=0
        var pinNum = 0
        //Приветствие пользователя
        println("Hello!!!\nWelcome to google ATM!")

       try {
           //Просим ввести номер карты
           println("Please enter your card number:")
            userCrd = readLine()!!.toInt()

           //просим ввести пин
           println("Please enter pin number:")
            pinNum = readLine()!!.toInt()

       }
       catch (e:Exception){
           println("WRONG VALUE!")
           start()
       }
        //производим проверку пользователя
        accounts.forEach {
            do {
                if (userCrd == it.cardNum && pinNum == it.cardPin) {
                    flag = false
                    val currAcc: Account = it
                    mainMenu(currAcc)
                } else {
                    println("ERROR!!\nPOLICE IS ON RUSH!")
                    stop()
                }
            } while (!flag)
        }
    }
}

fun mainMenu(currAcc: Account) {

    var actionPicker=0

    //Главное меню с выбором кредитного или сберегательного акккаунта
    println("\nChoose an action:\n1)Credit account\n2)Save account\n3)Exit")
    try {
         actionPicker = readLine()!!.toInt()
    }
    catch (e:Exception){
        println("WRONG VALUE!")
        mainMenu(currAcc)
    }
    when (actionPicker) {
        1 -> creditAccountMenu(currAcc)
        2 -> saveAccountMenu(currAcc)
        3 -> stop()
        else -> println("\nWrong, please choose again")
    }
}

fun saveAccountMenu(currAcc: Account) {
    var actionPicker=0

    //Меню сберегательного аккаунта
    println(
        "\nYours current save balanse is $${currAcc.saveBalance}\n" +
                "Please, choose an action:\n" +
                "1)Withdraw money from the account\n" +
                "2)Top up your account\n" +
                "3)Back"
    )
    try {
        actionPicker = readLine()!!.toInt()
    }
    catch (e:Exception){
        println("WRONG VALUE!")
        saveAccountMenu(currAcc)
    }
    when (actionPicker) {
        1 -> {
            println("Enter amount of money to withdraw from account")
            currAcc.withdrawSaveMoney(readLine()!!.toDouble())
            saveAccountMenu(currAcc)
        }
        2 -> {
            println("Enter amount of money to put into the account")
            currAcc.topUpSaveMoney(readLine()!!.toDouble())
            saveAccountMenu(currAcc)
        }
        3 -> mainMenu(currAcc)
        else -> {
            println("Wrong, please choose again")
            saveAccountMenu(currAcc)
        }
    }

}

fun creditAccountMenu(currAcc: Account) {
    var actionPicker = 0
    //Меню кредитного счета
    println(
        "\nYours current credit balanse is $${currAcc.creditBalance}\n" +
                "Please, choose an action:\n" +
                "1)Withdraw money from the account\n" +
                "2)Top up your account\n" +
                "3)Back"
    )
    try {
        actionPicker = readLine()!!.toInt()
    }
    catch (e:Exception){
        println("WRONG VALUE!")
        creditAccountMenu(currAcc)
    }

    when (actionPicker) {
        1 -> {
            println("Enter amount of money to withdraw from account")
            currAcc.withdrawCreditMoney(readLine()!!.toDouble())
            creditAccountMenu(currAcc)
        }
        2 -> {
            println("Enter amount of money to put into the account")
            currAcc.topUpCreditMoney(readLine()!!.toDouble())
            creditAccountMenu(currAcc)
        }
        3 -> mainMenu(currAcc)
        else -> {
            println("\nWrong, please choose again")
            creditAccountMenu(currAcc)
        }
    }
}

fun stop() {
    //завершение работы
    println("Have a nice day, bye!")
    exitProcess(0)
}

