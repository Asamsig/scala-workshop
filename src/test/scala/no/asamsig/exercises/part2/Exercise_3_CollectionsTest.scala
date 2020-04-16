package no.asamsig.exercises.part2

import no.asamsig.data.{AppInfo, Category, ContentRating, Genre}
import no.asamsig.exercises.part2.Exercise_3_Collections.AppStats
import no.asamsig.service.playstore
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers


class Exercise_3_CollectionsTest extends AnyFreeSpec with Matchers {

  val appInfoList: List[AppInfo] = playstore.parseCsv("src/main/resources/googleplaystore.csv")

  "1. Return an implementation of AppStats" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    appStats shouldBe a[AppStats]
  }

  "2. number of rated apps" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    appStats.ratedApps() shouldBe 9366
  }

  "3. average rating" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    appStats.averageRating() shouldBe 4.19 +- 0.01
  }


  "4. average rating in art and design" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    appStats.averageRatingForCategory(Category.ART_AND_DESIGN) shouldBe 4.35 +- 0.01
  }

  "5. The most expensive app in store" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    appStats.mostExpensiveApp().name shouldBe "I'm Rich - Trump Edition"
  }

  "6. total number of reviews" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    appStats.totalReviews() shouldBe 4817617393L
  }

  "7. Categories sorted by average rating in the category" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    val categoriesByRating = appStats.categoriesOrderedByRating()
    categoriesByRating.head shouldBe Category.EVENTS
    categoriesByRating.last shouldBe Category.DATING
  }

  "8. Categories sorted by number of apps in the category" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    val categoriesByNumberOfApps = appStats.categoriesOrderedByNumberOfApps()
    categoriesByNumberOfApps.head shouldBe(Category.FAMILY, 1972)
    categoriesByNumberOfApps.last shouldBe(Category.BEAUTY, 53)
  }

  "9. Average rating for TRIVIA" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    appStats.averageRatingForGenre(Genre.TRIVIA) shouldBe 4.039 +- 0.01
  }

  "10. Highest rated genre" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    appStats.highestRatedGenre() shouldBe Genre.EVENTS
  }

  "11. Implement CategoryStats" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    val categoryStat = appStats.categoryStats(Category.EVENTS)
    categoryStat.name shouldBe Category.EVENTS.toString
    categoryStat.averagePrice shouldBe 1.718 +- 0.01
    categoryStat.size shouldBe 64
    categoryStat.averageRating shouldBe 4.435 +- 0.01
  }

  "12. ContentRating map" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    val groups = appStats.groupByContentRating()
    groups.size shouldBe 6
    groups.get(ContentRating.Everyone).map(_.size) shouldBe Some(8714)
    val Some(appInfo) = appInfoList.find(_.contentRating.contains(ContentRating.Teen))
    groups(ContentRating.Teen) should contain(appInfo)
  }

  "13. ContentRating Average" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    val contentRatingMap = appStats.averageRatingByContentRating()
    contentRatingMap.size shouldBe 6
    contentRatingMap(ContentRating.Adults18) shouldBe 4.3 +- 0.01
    contentRatingMap(ContentRating.Unrated) shouldBe 4.1 +- 0.01
  }

  "14. Top rated apps" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    val topRated = appStats.topRated(10)
    topRated(0) shouldBe("Ríos de Fe", 5.0, 141)
    topRated(4) shouldBe("Master E.K", 5.0, 90)
    topRated(9) shouldBe("Ek Vote", 5.0, 43)
  }

  "15. Find apps" in {
    val appStats: AppStats = AppStats.getAppStatsService(appInfoList)
    appStats.findApps(minRating = 4.0, maxPrice = 10.0).head.name shouldBe "Facebook"
    appStats.findApps(minRating = 4.5, maxPrice = 10.0, category = Some(Category.BEAUTY))
      .head.name shouldBe "ipsy: Makeup, Beauty, and Tips"
    appStats.findApps(minRating = 3.5, maxPrice = 1.0, genre = Some(Genre.BRAIN_GAMES))
      .head.name shouldBe "Where's My Water? Free"
  }
}