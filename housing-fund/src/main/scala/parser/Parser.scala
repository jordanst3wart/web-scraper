package parser

import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.text.NumberFormat

import scala.annotation.tailrec
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


  def dollarToInt(string: String): Int = {
    // removes '$' and ',' from the list of chars
    @tailrec
    def iter(list: List[Char], newList: List[Char]): List[Char] = {
      if(list.isEmpty){
        newList
      }
      else if (!(list.head == '$' || list.head == ',')){
        //newList.+:(list.head) // broken here
        newList.add(0,list.head)
        iter(list.tail, newList)
      }
      else {
        iter(list.tail,newList)
      }
    }

    val string2 = iter(string.toList,"".toList) // idk how to create List[Char] lol
      string.toString().
      toInt
  }


  // eg. <p class="listing-result__price">$1,330</p>
  def getPrices(doc: Document): List[Int] = {
    val elements: Elements = doc.getElementsByClass(HTMLclasses("price"))
    val prices: List[Int] = List()

    // i would like to use a map but... idk how
    elements.foreach { element =>
      println(element.html())
      println(dollarToInt(element.html()))

      // convert some dollar value to int
      prices.add(
        dollarToInt(element.html())
        // parse can throw, but...
        //numberFormat.parse(
        //  element.html()
        //).intValue()
      )
    }

    prices
  }

  def getFeatures = ???

  def getAddresses = ???

  def getGeoCoordinates = ???


}
