

package napplelabs.sbtgrowlplugin

import sbt._

object SbtGrowl  {
	import Process._
	
	val passIconPath = this.getClass.getClassLoader.getResource("check.png").getPath
	
	def testReportListener = Seq(new TestsListener {
			var passed = 0
			var failed = 0
			var errored = 0
		
		      def startGroup(name: String) = {
				
		}
		      /** called for each test method or equivalent */
		      def testEvent(event: TestEvent) = {}
		      /** called if there was an error during test */
		      def endGroup(name: String, t: Throwable) = """growlnotify -m "%s" Test ERROR""".format(name) !
		      /** called if test completed */
		      def endGroup(name: String, result: Result.Value) = {
				result match {
					case Result.Passed => passed = passed + 1
					case _ => failed = failed + 1
					
				}
		}
		
			def doInit = {
				passed = 0
				failed = 0
				errored = 0
			}
			def doComplete(finalResult: Result.Value) = {
				val resultStr = "Passed: %d   Failed: %d".format(passed, failed)
				val title = finalResult match {
					case Result.Passed => "Passed"
					case _ => "FAILING TESTS"
				}
				
				"""growlnotify -m "%s" %s""".format(resultStr, title) !				
			}

		  })	
		
		//
	

}