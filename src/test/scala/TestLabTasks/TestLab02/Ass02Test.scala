package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class TestAss02 extends FreeSpec with ChiselScalatestTester {
"Test Ass 02" in {
    
    test(new Ass02) { c =>
    
    c.io.in(0).poke(true.B)
    c.io.in(1).poke(false.B)
    c.io.in(2).poke(false.B)
    c.io.in(3).poke(true.B)

    c.io.shift_type.poke(false.B)

    c.io.sel(0).poke(true.B)
    c.io.sel(1).poke(true.B)       

    c.clock.step(10)
    c.io.out(0).expect(1.B)
    c.io.out(1).expect(1.B)
    c.io.out(2).expect(0.B)
    c.io.out(3).expect(0.B)
    }
}
}