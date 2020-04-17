package no.asamsig.service

import java.io.FileReader

import com.opencsv.CSVReaderHeaderAware
import no.asamsig.data.Category.Category
import no.asamsig.data.ContentRating.ContentRating
import no.asamsig.data.Genre.Genre
import no.asamsig.data._

import scala.util.Try

package object playstore {

  private def parseCategory(s: String): Option[Category] =
    Category.values.find(_.toString == s.trim())

  private def parseContentRating(s: String): Option[ContentRating] =
    ContentRating.values.find(_.toString == s)

  private def parseRating(s: String): Option[Rating] =
    s.toDoubleOption.filter(rating => rating >= 0.0 && rating <= 5.0).map(Rating)

  private def parseSize(s: String): Option[Size] = {
    import scala.language.postfixOps
    s.lastOption.map(_.toUpper) match {
      case Some('K') => s.dropRight(1).toDoubleOption.map(_ * 1000 toLong).map(Size)
      case Some('M') => s.dropRight(1).toDoubleOption.map(_ * 1000000 toLong).map(Size)
      case _ => s.toLongOption.map(Size)
    }
  }

  private def parseInstalls(s: String): Option[InstallBase] =
    s.replace(",", "").replace("+", "").toLongOption.map(InstallBase(_, s))

  private def parseType(s: String): Option[Type] =
    s match {
      case "Paid" => Some(Paid)
      case "Free" => Some(Free)
      case _ => Option.empty
    }

  private def parsePrice(s: String): Price =
    Price(s.replace("$", "").toDoubleOption.getOrElse(0.0))

  private def parseGenres(s: String): Set[Genre] = {
    s.split(";").toList.flatMap(g => Genre.values.find(_.toString == g).toList).toSet
  }

  def appInfoFromArray(values: Array[String]): AppInfo = {
    AppInfo(
      name = values(0),
      category = parseCategory(values(1)),
      rating = parseRating(values(2)),
      reviews = parseReviews(values(3)),
      size = parseSize(values(4)),
      installs = parseInstalls(values(5)),
      `type` = parseType(values(6)),
      price = parsePrice(values(7)),
      contentRating = parseContentRating(values(8)),
      genres = parseGenres(values(9))
    )
  }

  def parseReviews(s: String): Int =
    s.last match {
      case 'M' => Math.round(s.dropRight(1).toDouble * 1000000).toInt
      case 'K' => Math.round(s.dropRight(1).toDouble * 1000).toInt
      case _ => s.toInt
    }


  def parseCsv(filename: String): List[AppInfo] = {
    import scala.jdk.CollectionConverters._
    new CSVReaderHeaderAware(new FileReader(filename)).asScala.flatMap { row =>
      val triedInfo = Try(appInfoFromArray(row))
      triedInfo.failed.foreach(error => println(s"Error: $error\n${row.toList}"))
      triedInfo.toOption
    }.toList
  }

}