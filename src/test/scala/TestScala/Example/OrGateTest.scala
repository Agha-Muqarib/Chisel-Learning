package Example

import org.scalatest._
import chiseltest._
import chisel3._

class OrGateTest extends FreeSpec with ChiselScalatestTester {
"Or Gate Test" in {
    
    test(new OrGate()) { c =>

    c.io.a.poke(0.U)
    c.io.b.poke(0.U)
    c.clock.step(1)
    c.io.c.expect(0.U)

    }
}
}