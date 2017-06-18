package parser

import org.jsoup.nodes.Document
import org.jsoup.select.Elements

import java.text.NumberFormat

import scala.collection.JavaConversions._

/**
  * Created by jordan on 17/06/17.
  */
class Parser {

  private val fruit: List[String] = List("apples", "oranges", "pears")

  private val HTMLclasses: Map[String, String] = Map(
    "price" -> "listing-result__price",
    "" -> "",
    "pears" -> "hi"
  )

  private def dollarToInt(string: String): Int = {
    var newString: String = ""
    List[Char]
    

    //if (value.head.isNumeric) {
    //  newString.add() = ""
    //}

    0
  }


  // eg. <p class="listing-result__price">$1,330</p>
  def getPrices(doc: Document): List[Int] = {
    val elements: Elements = doc.getElementsByClass(HTMLclasses("price"))
    val prices: List[Int] = List()
    val numberFormat = NumberFormat.getCurrencyInstance




    // i would like to use a map but... idk how
    elements.foreach { element =>
      println(element.html())

      // convert some dollar value to int
      prices.add(
        // parse can throw, but...
        numberFormat.parse(
          element.html()
        ).intValue()
      )
    }

    prices
  }

  def getFeatures = ???

  def getAddresses = ???

  def getGeoCoordinates = ???


}
