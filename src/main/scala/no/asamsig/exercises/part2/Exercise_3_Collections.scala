package no.asamsig.exercises.part2

import no.asamsig.data.Category.Category
import no.asamsig.data.ContentRating.ContentRating
import no.asamsig.data.Genre.Genre
import no.asamsig.data._

/**
 *
 * Scala Workshop Exercise 3
 *
 */
object Exercise_3_Collections {

  /**
   *
   * These exercises use the case classes and enums defines in [AppInfo]
   *
   * The main case class keeps information on Android Play Store apps, and looks like this:
   *
   * case class AppInfo(
   * name: String,
   * reviews: Int,
   * price: Price = Price(0.0),
   * genres: Set[Genre] = Set.empty,
   * category: Option[Category] = Option.empty,
   * rating: Option[Rating] = Option.empty,
   * size: Option[Size] = Option.empty,
   * installs: Option[InstallBase] = Option.empty,
   * `type`: Option[Type] = Option.empty,
   * contentRating: Option[ContentRating] = Option.empty
   * )
   *
   * the data which is loaded from "src/main/resources/googleplaystore.csv" has some missing or bad values,
   * which is why many of the [AppInfo] properties are nullable.
   *
   */
  trait AppStats {

      /**
       * 2. Number of apps with Rating
       *
       * Return the number of apps with a rating != null
       */
      def ratedApps(): Int

      /**
       * 3. Average Rating
       *
       * Calculate the average rating for all apps in the list (excluding apps where rating == null)
       */
      def averageRating(): Double

      /**
       * 4. Average Rating for Category
       *
       * The average rating for all apps in a single category
       * (excluding apps without rating)
       */
    def averageRatingForCategory(category: Category): Double

      /**
       * 5. Most Expensive
       *
       * Return the most expensive app
       */
      def mostExpensiveApp(): AppInfo

      /**
       * 6. Total reviews
       *
       * Return the total number of reviews for all apps
       */
      def totalReviews(): Long

      /**
       * 7. Categories ordered by rating
       *
       * Return a list of categories, ordered by average rating for the category from highest to lowest
       * (excluding apps without rating when calculating average rating)
       */
      def categoriesOrderedByRating(): List[Category]

      /**
       * 8. Categories ordered by apps
       *
       * Return a list of categories and number of apps in the category as a list of pairs, ordered from most to least
       */
      def categoriesOrderedByNumberOfApps(): List[(Category, Int)]

      /**
       * 9. Average rating for Genre
       *
       * Return the average rating for a single Genre
       */
      def averageRatingForGenre(genre: Genre): Double

      /**
       * 10. Highest rated Genre
       *
       * Find the Genre with the highest average rating
       */
      def highestRatedGenre(): Genre

      /**
       * 11. CategoryStats interface
       *
       * Return your own implementation of the [CategoryStats] interface for the specified Category
       * (See at the bottom of this file for the interface)
       */
      def categoryStats(category: Category): CategoryStats

      /**
       * 12. ContentRating map
       *
       * Separate apps into groups according to ContentRating, and return as a Map from ContentRating => List of Apps
       */
      def groupByContentRating(): Map[ContentRating, List[AppInfo]]

      /**
       * 13. Return a Map from ContentRating => Average Rating
       */
      def averageRatingByContentRating(): Map[ContentRating, Double]

      /**
       * 14. Top rated list
       *
       * Return a list of the Top [n] highest rated apps. If some apps have the same rating, order them by number of reviews
       * The return value is a [List] of [Triple]'s with app name, rating and number of reviews
       */
      def topRated(n: Int): List[(String, Double, Int)]

      /**
       * 15. Find Apps by criteria
       *
       * Return a list with all apps that satisfy the given criteria. Order the list by number of reviews for each app
       * (with regards to minRating a missing rating should be considered as 0 stars)
       */
      def findApps(minRating: Double, maxPrice: Double, category: Option[Category] = Option.empty, genre: Option[Genre] = Option.empty): List[AppInfo]
  }

  /**
   * 1. Make a class
   *
   * Make a class that implements the [AppStats] interface, and return an
   * instance of your class here.
   *
   * (you need to keep a reference to the given 'appInfoList' in your Class,
   * as the rest of the exercises will work on the data in that List)
   */
  object AppStats {
    def getAppStatsService(appInfoList: List[AppInfo]): AppStats = {
      ???
    }
  }

  trait CategoryStats {
      val name: String
      val size: Int
      val averageRating: Double
      val averagePrice: Double
  }

}