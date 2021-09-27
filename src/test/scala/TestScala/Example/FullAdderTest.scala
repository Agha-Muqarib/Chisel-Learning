package Example

import org.scalatest._
import chiseltest._
import chisel3._

class FullAdderTest extends FreeSpec with ChiselScalatestTester {
    
    "Full Adder Test" in {
    
        test(new FullAdder) { obj =>

        obj.io.inputA.poke(1.U)
        obj.io.inputB.poke(1.U)
        obj.clock.step(1)
        obj.io.sum.expect(0.U)
        obj.io.c_out.expect(1.U)

    }
}
}