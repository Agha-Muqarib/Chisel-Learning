package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class Exercise01Test extends FreeSpec with ChiselScalatestTester {
"Exercise 01 Test" in {
    
    test(new Exercise01) { c =>

    c.io.x.poke(4.U)
    c.io.y.poke(2.U)
    c.clock.step(1)
    c.io.result.expect(6.U)
    c.io.result2.expect(6.U)
    c.io.result3.expect(6.U)
    c.io.result4.expect(2.U)
    c.io.result5.expect(2.U)
    c.io.result6.expect(2.U)

    }
}
}