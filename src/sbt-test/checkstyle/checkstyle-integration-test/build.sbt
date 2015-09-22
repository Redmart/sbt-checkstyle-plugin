
name := "checkstyle-test"
version := "0.1"
organization := "com.etsy"

lazy val root = (project in file("."))
  .configs(IntegrationTest)

Defaults.itSettings

import com.etsy.sbt.Checkstyle._
com.etsy.sbt.Checkstyle.checkstyleSettings ++ Seq(
  CheckstyleTasks.checkstyle in IntegrationTest <<= checkstyleTask(IntegrationTest),
  CheckstyleTasks.checkstyleCheck in IntegrationTest <<= checkstyleCheckTask(IntegrationTest),
  CheckstyleTasks.checkstyleConfig in IntegrationTest <<= CheckstyleTasks.checkstyleConfig,
  CheckstyleTasks.checkstyleTarget in IntegrationTest <<= target(_ / "checkstyle-integration-test-report.xml")
)
