package Example

import org.scalatest._
import chiseltest._
import chisel3._

class HalfAdderTest extends FreeSpec with ChiselScalatestTester {
"Half Adder Test" in {
    
    test(new HalfAdder()) { obj =>

    obj.io.a.poke(1.U)
    obj.io.b.poke(1.U)
    obj.clock.step(1)
    obj.io.c.expect(0.U)
    obj.io.d.expect(1.U)

    }
}
}