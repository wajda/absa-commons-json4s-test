package org.example.wajda

import org.example.wajda.JsonSerDeTest.{Bar, Foo}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import za.co.absa.commons.json.DefaultJacksonJsonSerDe

class JsonSerDeTest extends AnyFlatSpec with Matchers {

  import DefaultJacksonJsonSerDe._

  it should "render a JSON" in {
    Foo(42, Bar("Ahoj!")).toJson should equal("""{"x":42,"bar":{"s":"Ahoj!"}}""")
  }
}

object JsonSerDeTest {

  case class Foo(x: Int, bar: Bar)

  case class Bar(s: String)

}
