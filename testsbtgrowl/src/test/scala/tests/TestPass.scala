package tests

import org.scalatest._
import org.scalatest.matchers._

class PassTest extends FlatSpec with ShouldMatchers {
	
}

class ErrorTest extends FlatSpec with ShouldMatchers {
	//fail()
}

class FailTest extends FlatSpec with ShouldMatchers {	
	"Something" should "fail" in {
		1 should be (0)
	}	
}