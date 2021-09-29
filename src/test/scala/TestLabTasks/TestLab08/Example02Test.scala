package Lab08

import chisel3._
import org.scalatest._
import chiseltest._

class Example02Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 02 Test" in {
        
        test(new Parameterized_Mem(32,32)) {c =>
        
        c.io.dataIn.poke(4.U)
        c.io.addr.poke(1.U)
        c.io.wr_enable.poke(true.B)
        c.io.rd_enable.poke(true.B)

        c.clock.step(5)

        c.io.dataOut.expect(4.U)

    }
  }
}