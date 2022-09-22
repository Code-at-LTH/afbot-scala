import org.json4s._
import org.json4s.native.JsonMethods._

def isGood(area: String, rent: Int, typ: String): Boolean =
	if  typ == "Lägenhet" then
		if rent > 7000 then
			return false
	else if rent > 5000 then
			return false
	area != "Delphi"

def downloadJSON(): String =
	scala.io.Source.fromURL("https://api.afbostader.se:442/redimo/rest/vacantproducts").mkString

@main def main: Unit =
	val data = downloadJSON()
	val JArray(products) = parse(data) \ "product"
	println(products.length)
	for product <- products do
		val JString(description) = product \ "description"
		val JString(area) = product \ "area"
		val JString(rent) = product \ "rent"
		val JString(typ) = product \ "type"
		val JString(id) = product \ "productId"
		if isGood(area, rent.toInt, typ) then
			println(area + " " + rent + " " + description)
			println(" url= https://www.afbostader.se/lediga-bostader/bostadsdetalj/?obj=" + id)

