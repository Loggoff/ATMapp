package ATM

fun main() {
    //заглушка создания списка аккаунтов
    val acc1 = Account(12345, 1111)
    val acc2 = Account(123456, 2222)
    val acc3 = Account(1234567, 3333)
    val data = listOf<Account>(acc1, acc2, acc3)

    //Запуск
    AtmApp(data).start()
}