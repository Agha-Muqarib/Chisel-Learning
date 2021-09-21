package Lab05

import org.scalatest._
import chiseltest._
import chisel3._

class Example06Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 06 Test" in {
    
        test(new DataMem(new Parameters(32,32))) { c =>

        c.io.data_in.poke(32.U)
        c.io.wr_en.poke(true.B)

        c.io.addr.poke(32.U)

        c.clock.step(10)

        c.io.data_out.expect(0.U)
   
        }
    }
}