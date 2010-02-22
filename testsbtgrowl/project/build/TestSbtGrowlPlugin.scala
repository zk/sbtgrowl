import sbt._
import napplelabs.sbtgrowlplugin._

class TestSbtGrowlPlugin(info: ProjectInfo) extends DefaultProject(info) {	
	
	val junit = "org.scalatest" % "scalatest" % "1.0"
	
	override def testListeners : Seq[TestReportListener] = super.testListeners ++ SbtGrowl.testReportListener
}