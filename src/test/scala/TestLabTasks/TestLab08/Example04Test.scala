package Lab08

import chisel3._
import org.scalatest._
import chiseltest._

class Example04Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 04 Test" in {
        
        test(new Forwarding) {c =>
        
        c.io.readAddress.poke(1.U)
        c.io.writeAddress.poke(1.U)
        c.io.wrData.poke(2.U)
        c.io.wr_en.poke(true.B)

        c.clock.step(5)

        c.io.out.expect(2.U)

    }
  }
}