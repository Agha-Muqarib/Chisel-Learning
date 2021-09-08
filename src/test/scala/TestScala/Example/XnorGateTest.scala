package Example

import org.scalatest._
import chiseltest._
import chisel3._

class XnorGateTest extends FreeSpec with ChiselScalatestTester {
"Xnor Gate Test" in {
    
    test(new XnorGate()) { c =>

    c.io.a.poke(1.U)
    c.io.b.poke(1.U)
    c.clock.step(1)
    c.io.c.expect(1.U)

    }
}
}