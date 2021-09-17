package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class TestTask01 extends FreeSpec with ChiselScalatestTester {
"Task 01 Test" in {
    
    test(new Task01) { c =>
    
    c.io.in_A.poke(89.U)
    c.io.in_B.poke(10.U)
    c.io.select.poke(0.B)

    c.clock.step(10)

    c.io.out.expect(89.U)

    }
}
}

