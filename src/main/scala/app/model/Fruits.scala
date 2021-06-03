package app.model

sealed class Fruits(val fruit: String, val price: BigDecimal)
case class Apple() extends Fruits("Apple", BigDecimal("0.60"))
case class Orange() extends Fruits("Orange", BigDecimal("0.25"))
