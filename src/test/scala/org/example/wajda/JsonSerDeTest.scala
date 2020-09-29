package org.example.wajda

import java.util.UUID

import org.example.wajda.JsonSerDeTest.{Bar, Foo}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import za.co.absa.commons.json.DefaultJacksonJsonSerDe
import za.co.absa.commons.json.format.JavaTypesSupport

class JsonSerDeTest extends AnyFlatSpec with Matchers {

  it should "render a JSON" in new DefaultJacksonJsonSerDe {
    Foo(42, Bar("Ahoj!")).toJson should equal("""{"x":42,"bar":{"s":"Ahoj!"}}""")
  }

  it should "parse a JSON" in new DefaultJacksonJsonSerDe {
    """{"x":42,"bar":{"s":"Ahoj!"}}""".fromJson[Foo] should equal(Foo(42, Bar("Ahoj!")))
  }

  it should "support extensions" in new DefaultJacksonJsonSerDe with JavaTypesSupport {
    private val uuid = "9923c32b-6810-4477-bd53-64ec31fdc573"
    UUID.fromString(uuid).toJson should equal("\"%s\"" format uuid)
  }
}

object JsonSerDeTest {

  case class Foo(x: Int, bar: Bar)

  case class Bar(s: String)

}
