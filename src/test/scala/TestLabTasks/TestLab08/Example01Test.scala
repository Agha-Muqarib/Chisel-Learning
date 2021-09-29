package Lab08

import chisel3._
import org.scalatest._
import chiseltest._

class Example01Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 01" in {
        
        test(new Asynch_Mem) {c =>
        
        c.io.data_in(0).poke(4.U)
        c.io.data_in(1).poke(3.U)
        c.io.data_in(2).poke(8.U)
        c.io.data_in(3).poke(9.U)
        c.io.data_selector.poke(2.U)
        c.io.addr.poke(4.U)
        c.io.wr_en.poke(true.B)

        c.clock.step(5)
        c.io.addr.poke(4.U)
        c.io.wr_en.poke(false.B)

        c.clock.step(100)

    }
  }
}