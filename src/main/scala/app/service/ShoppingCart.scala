package app.service

import app.model._

case class ShoppingCart(fruits: List[Fruits] = List.empty) {
  def addFruits(fruit: Fruits) : ShoppingCart = {
    ShoppingCart(fruit :: fruits)
  }

  def totalPrice: BigDecimal = {
    fruits.map(fruit => fruit.price).sum
  }

  def offerPrice: BigDecimal = {
    val offerPriceOnApples = calculateOfferPrice(fruits.filter(_.isInstanceOf[Apple]), 2)
    val offerPriceOnOranges = calculateOfferPrice(fruits.filter(_.isInstanceOf[Orange]), 3)
    totalPrice - offerPriceOnApples - offerPriceOnOranges
  }

  def calculateOfferPrice(fruits: Seq[Fruits], volume: Int) : BigDecimal = {
    fruits.take(fruits.size / volume).map(_.price).sum
  }
}
