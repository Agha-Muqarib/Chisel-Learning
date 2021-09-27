package Example

import org.scalatest._
import chiseltest._
import chisel3._

class HalfAdderTest extends FreeSpec with ChiselScalatestTester {
    
    "Half Adder Test" in {
    
        test(new HalfAdder) { obj =>
    
        obj.io.inputA.poke(1.U)
        obj.io.inputB.poke(1.U)
        obj.clock.step(1)
        obj.io.sum.expect(0.U)
        obj.io.c_out.expect(1.U)

    }
}
}