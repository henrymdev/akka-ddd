package pl.newicom.dddd.test.support

import com.typesafe.config.{Config, ConfigFactory}
import akka.actor.ActorSystem

object TestConfig {
  val config = ConfigFactory.parseString(
    """akka.loggers = ["akka.testkit.TestEventListener"]
      |akka.loglevel = DEBUG
      |akka.actor.debug.autoreceive = "on"
      |akka.persistence.journal.plugin = "akka.persistence.journal.inmem"
      |akka.persistence.snapshot-store.plugin = "akka.persistence.snapshot-store.local"
    """.stripMargin)

  implicit def testSystem: ActorSystem = testSystem(TestConfig.config)

  def testSystem(config: Config) = {
    ActorSystem("Tests", config)
  }

}
