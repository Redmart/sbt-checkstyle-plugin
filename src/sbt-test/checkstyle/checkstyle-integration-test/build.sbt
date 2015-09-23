
name := "checkstyle-test"
version := "0.1"
organization := "com.etsy"

lazy val root = (project in file("."))
  .configs(IntegrationTest)

Defaults.itSettings

import com.etsy.sbt._
com.etsy.sbt.Checkstyle.checkstyleSettings ++ Seq(
  Checkstyle.CheckstyleTasks.checkstyleConfig                     := scala.xml.XML.loadFile(file("my-checkstyle-config.xml")),
  Checkstyle.CheckstyleTasks.checkstyleConfig in Test             := scala.xml.XML.loadFile(file("test-checkstyle-config.xml")),

  Checkstyle.CheckstyleTasks.checkstyle       in IntegrationTest <<= Checkstyle.checkstyleTask(IntegrationTest),
  Checkstyle.CheckstyleTasks.checkstyleCheck  in IntegrationTest <<= Checkstyle.checkstyleCheckTask(IntegrationTest),
  Checkstyle.CheckstyleTasks.checkstyleTarget in IntegrationTest <<= target(_ / "checkstyle-integration-test-report.xml")
)
