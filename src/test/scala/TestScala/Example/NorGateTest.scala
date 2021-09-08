package Example

import org.scalatest._
import chiseltest._
import chisel3._

class NorGateTest extends FreeSpec with ChiselScalatestTester {
"Nor Gate Test" in {
    
    test(new NorGate()) { c =>

    c.io.a.poke(0.U)
    c.io.b.poke(0.U)
    c.clock.step(1)
    c.io.c.expect(1.U)

    }
}
}