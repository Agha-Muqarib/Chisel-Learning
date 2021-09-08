package Example

import org.scalatest._
import chiseltest._
import chisel3._

class TwoBitHalfAdderTest extends FreeSpec with ChiselScalatestTester {
"2-bit Half Adder Test" in {
    
    test(new TwoBitHalfAdder()) { obj =>

    obj.io.a.poke(1.U)
    obj.io.b.poke(1.U)
    obj.clock.step(1)
    obj.io.sum.expect(0.U)
    obj.io.c_out.expect(1.U)
    obj.io.finalSum.expect(0.U)
    obj.io.finalC_out.expect(1.U)

    }
}
}