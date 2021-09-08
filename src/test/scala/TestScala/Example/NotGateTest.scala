package Example

import org.scalatest._
import chiseltest._
import chisel3._

class NotGateTest extends FreeSpec with ChiselScalatestTester {
"Not Gate Test" in {
    
    test(new NotGate()) { b =>

    b.io.a.poke(1.U)
    b.clock.step(1)
    b.io.b.expect(0.U)

    }
}
}