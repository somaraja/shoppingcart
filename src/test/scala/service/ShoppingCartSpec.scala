package service

import app.model._
import app.service.ShoppingCart
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class ShoppingCartSpec extends AnyFlatSpec with Matchers{

  "Apple's actual price" should "be £0.60p" in {
    val shoppingCart = ShoppingCart().addFruits(Apple())
    shoppingCart.totalPrice should be (BigDecimal("0.60"))
  }

  "Orange's actual price" should "be £0.25p" in {
    val shoppingCart = ShoppingCart().addFruits(Orange())
    shoppingCart.totalPrice should be (BigDecimal("0.25"))
  }

  "ShoppingCart with [Apple, Apple, Orange, Apple]" should "be price of £2.05" in {
    val shoppingCart = ShoppingCart().addFruits(Apple()).
      addFruits(Apple()).addFruits(Orange()).addFruits(Apple())
    shoppingCart.totalPrice should be (BigDecimal("2.05"))
  }

  "ShoppingCart with Apples" should "get a discount of 2 for 1" in {
    val shoppingCart = ShoppingCart().addFruits(Apple()).addFruits(Apple())
    shoppingCart.offerPrice should be (BigDecimal(0.60))
  }

  "ShoppingCart with Oranges" should "get a discount of 3 for 2" in {
    val shoppingCart = ShoppingCart().addFruits(Orange()).
      addFruits(Orange()).addFruits(Orange())
    shoppingCart.offerPrice should be (BigDecimal(0.50))
  }
}

