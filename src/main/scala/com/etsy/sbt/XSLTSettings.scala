package com.etsy.sbt

import java.io.File

/**
 * Configuration for a single XSLT transformation of the checkstyle output file
 *
 * @author Andrew Johnson
 */
case class XSLTSettings(xslt: File, output: File)
