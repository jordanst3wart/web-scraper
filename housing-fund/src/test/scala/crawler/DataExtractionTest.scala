package crawler


import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File

import parser.Parser
import org.scalatest.FunSuite

import org.scalatest.junit.AssertionsForJUnit

import org.junit

/**
  * Created by jordan on 17/06/17.
  */
class ParserTest extends FunSuite {


  // internal method tests, I might need to test stuff

  test("dollar value string to int"){
    val parser = new Parser()
    assert(parser.dollarToInt("$1,000") === 1000)
    assert(parser.dollarToInt("") === 0)
    assert(parser.dollarToInt("$1,000,000") === 1000000)
  }


  // test page
  test("full page") {
    assert(true)
  }

  test("price") {
    val parser = new Parser()
    val input = new File("/home/jordan/Documents/scala/housing-fund/housing-fund/src/test/scala/crawler/price.html")
    val doc = Jsoup.parse(input, "UTF-8", "http://example.com/")
    val prices = parser.getPrices(doc)

    assert(prices.head === 1330)
  }

  test("feature"){
    val feature: String = ""
    val amount: Int = 0
    assert(feature === "beds")
    assert(amount === 2)
  }

  test("listing"){


  }

  test("address"){

    val postcode: String  = ""
    val state: String = ""
    val locality: String = ""
    val streetAddress: String = ""

    assert(postcode === "2000")
    assert(state === "NSW")
    assert(locality === "Sydney")
    assert(streetAddress === "5609/93 Liverpool Street")
  }

  test("geocoordinates"){
    val latitude: Double = 0
    val longitude: Double = 0
    assert(latitude === -33.8642921)
    assert(longitude === 151.201553)
  }

}
