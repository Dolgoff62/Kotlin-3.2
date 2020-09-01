package ru.netology

fun main() {

    val card = "VkPay"
    val transferAmount = 15_000
    val amountOfTransfersInCurrentMonth = 0

    validationCheck(card, transferAmount, amountOfTransfersInCurrentMonth)
}

private fun validationCheck(
    card: String,
    transferAmount: Int,
    amountOfTransfersInCurrentMonth: Int
) {
    if (card == "VkPay" && (transferAmount > 15_000 || amountOfTransfersInCurrentMonth > 40_000)) {
        println("Перевод невозможен! Превышен лимит!")
    } else if (transferAmount < 150_000 && amountOfTransfersInCurrentMonth < 600_000) {
        val commission = calculateCommission(card, transferAmount, amountOfTransfersInCurrentMonth)
        println("Комиссия с вашего перевода составит: $commission коп.")
    }
}

private fun calculateCommission(card: String, transferAmount: Int, amountOfTransfersInCurrentMonth: Int): Int =

    when (card) {
        "VkPay" -> 0
        "Mastercard", "Maestro" -> {
            if (amountOfTransfersInCurrentMonth <= 75_000) 0 else ((transferAmount * 0.06 + 20) * 100).toInt()
        }
        "Visa", "Mir" -> {
            ((transferAmount * 0.075) * 100).toInt()
        }
        else -> 0
    }