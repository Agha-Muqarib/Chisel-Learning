package Lab06

import chisel3._
import org.scalatest._
import chiseltest._

class Example04Test extends FreeSpec with ChiselScalatestTester {
 
    "Example 04 Test" in {

        test(new RegFile) {c =>

        c.io.wen.poke(1.B)
        c.io.waddr.poke(3.U)
        c.io.wdata.poke(55.U)
        c.clock.step(1)
        c.io.wen.poke(0.B)
        c.io.raddr1.poke(3.U)
        
        // c.io.raddr1.poke(15.U)
        // c.io.raddr2.poke(15.U)
        // c.io.wen.poke(true.B)
        // c.io.waddr.poke(12.U)
        // c.io.wdata.poke(4.U)

        c.io.rdata1.expect(55.U)
        // c.io.rdata2.expect(4.U)

        c.clock.step(100)
        
    }
  }
}
         
    