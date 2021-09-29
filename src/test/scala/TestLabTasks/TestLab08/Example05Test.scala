package Lab08

import chisel3._
import org.scalatest._
import chiseltest._

class Example05Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 05 Test" in {
        
        test(new MaskedReadWriteSmem) {c =>
        
        c.io.mask(0).poke(true.B)
        c.io.mask(1).poke(true.B)
        c.io.mask(2).poke(true.B)
        c.io.mask(3).poke(true.B)

        c.io.dataIn(0).poke(2.U)
        c.io.dataIn(1).poke(3.U)
        c.io.dataIn(2).poke(4.U)
        c.io.dataIn(3).poke(5.U)

        c.io.addr.poke(1.U)
        c.io.enable.poke(true.B)
        c.io.write.poke(true.B)

        c.clock.step(5)

        c.io.dataOut(0).expect(2.U)
        c.io.dataOut(1).expect(3.U)
        c.io.dataOut(2).expect(4.U)
        c.io.dataOut(3).expect(5.U)

    }
  }
}