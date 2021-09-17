package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class Ass01Test extends FreeSpec with ChiselScalatestTester {
"Ass 01 Test" in {
    
    test(new Ass01) { c =>
    
    // c.io.s0.poke(0.U)
    // c.io.s1.poke(8.U)
    // c.io.s2.poke(16.U)
    // c.io.s3.poke(24.U)    
    // c.io.s4.poke(32.U)

    c.io.sel0.poke("b0".U)
    c.io.sel1.poke("b1".U)
    c.io.sel2.poke("b1".U)    

    c.clock.step(10)

    c.io.out.expect(32.U)

    }
}
}