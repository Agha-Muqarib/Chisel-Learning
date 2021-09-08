package Example

import org.scalatest._
import chiseltest._
import chisel3._

class XorGateTest extends FreeSpec with ChiselScalatestTester {
"Xor Gate Test" in {
    
    test(new XorGate()) { c =>

    c.io.a.poke(1.U)
    c.io.b.poke(1.U)
    c.clock.step(1)
    c.io.c.expect(0.U)

    }
}
}