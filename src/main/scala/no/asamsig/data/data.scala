package no.asamsig

import no.asamsig.data.Category.Category
import no.asamsig.data.ContentRating.ContentRating
import no.asamsig.data.Genre.Genre

package object data {

  case class AppInfo(
                      name: String,
                      reviews: Int,
                      price: Price = Price(0.0),
                      genres: Set[Genre] = Set.empty,
                      category: Option[Category] = Option.empty,
                      rating: Option[Rating] = Option.empty,
                      size: Option[Size] = Option.empty,
                      installs: Option[InstallBase] = Option.empty,
                      `type`: Option[Type] = Option.empty,
                      contentRating: Option[ContentRating] = Option.empty
                    )

  case class Rating(stars: Double)

  case class Size(bytes: Long)

  case class InstallBase(moreThan: Long, description: String)

  case class Price(dollars: Double)

  object ContentRating extends Enumeration {
    type ContentRating = Value
    val Unrated = Value("Unrated")
    val Adults18 = Value("Adults only 18+")
    val Everyone10 = Value("Everyone 10+")
    val Mature17 = Value("Mature 17+")
    val Teen = Value("Teen")
    val Everyone = Value("Everyone")
  }

  object Genre extends Enumeration {
    type Genre = Value
    val MUSIC_AND_AUDIO = Value("Music & Audio")
    val MUSIC = Value("Music")
    val WORK = Value("Word")
    val CREATIVITY = Value("Creativity")
    val TRIVIA = Value("Trivia")
    val CASINO = Value("Casino")
    val MUSIC_AND_VIDEO = Value("Music & Video")
    val CARD = Value("Card")
    val BEAUTY = Value("Beauty")
    val COMICS = Value("Comics")
    val PARENTING = Value("Parenting")
    val BOARD = Value("Board")
    val EVENTS = Value("Events")
    val ART_AND_DESIGN = Value("Art & Design")
    val BRAIN_GAMES = Value("Brain Games")
    val WEATHER = Value("Weather")
    val AUTO_AND_VEHICLES = Value("Auto & Vehicles")
    val LIBRARIES_AND_DEMO = Value("Libraries & Demo")
    val HOUSE_AND_HOME = Value("House & Home")
    val PRETEND_PLAY = Value("Pretend Play")
    val ADVENTURE = Value("Adventure")
    val STRATEGY = Value("Strategy")
    val EDUCATIONAL = Value("Educational")
    val RACING = Value("Racing")
    val ROLE_PLAYING = Value("Role Playing")
    val FOOD_AND_DRINK = Value("Food & Drink")
    val MAPS_AND_NAVIGATION = Value("Maps & Navigation")
    val ACTION_AND_ADVENTURE = Value("Action & Adventure")
    val PUZZLE = Value("Puzzle")
    val VIDEO_PLAYERS_AND_EDITORS = Value("Video Players & Editors")
    val SIMULATION = Value("Simulation")
    val BOOKS_AND_REFERENCE = Value("Books & Reference")
    val DATING = Value("Dating")
    val ARCADE = Value("Arcade")
    val TRAVEL_AND_LOCAL = Value("Travel & Local")
    val SHOPPING = Value("Shopping")
    val CASUAL = Value("Casual")
    val NEWS_AND_MAGAZINES = Value("News & Magazines")
    val SOCIAL = Value("Social")
    val PHOTOGRAPHY = Value("Photography")
    val HEALTH_AND_FITNESS = Value("Health & Fitness")
    val FINANCE = Value("Finance")
    val ACTION = Value("Action")
    val LIFESTYLE = Value("Lifestyle")
    val COMMUNICATION = Value("Communication")
    val PERSONALIZATION = Value("Personalization")
    val SPORTS = Value("Sports")
    val PRODUCTIVITY = Value("Productivity")
    val BUSINESS = Value("Business")
    val MEDICAL = Value("Medical")
    val ENTERTAINMENT = Value("Entertainment")
    val EDUCATION = Value("Education")
    val TOOLS = Value("Tools")
  }

  sealed trait Type
  case object Free extends Type
  case object Paid extends Type

  object Category extends Enumeration {
    type Category = Value
    val BEAUTY,
    COMICS,
    PARENTING,
    EVENTS,
    ART_AND_DESIGN,
    WEATHER,
    AUTO_AND_VEHICLES,
    LIBRARIES_AND_DEMO,
    HOUSE_AND_HOME,
    FOOD_AND_DRINK,
    MAPS_AND_NAVIGATION,
    ENTERTAINMENT,
    EDUCATION,
    VIDEO_PLAYERS,
    BOOKS_AND_REFERENCE,
    DATING,
    TRAVEL_AND_LOCAL,
    SHOPPING,
    NEWS_AND_MAGAZINES,
    SOCIAL,
    PHOTOGRAPHY,
    HEALTH_AND_FITNESS,
    FINANCE,
    LIFESTYLE,
    SPORTS,
    COMMUNICATION,
    PERSONALIZATION,
    PRODUCTIVITY,
    BUSINESS,
    MEDICAL,
    TOOLS,
    GAME,
    FAMILY = Value
  }

}
