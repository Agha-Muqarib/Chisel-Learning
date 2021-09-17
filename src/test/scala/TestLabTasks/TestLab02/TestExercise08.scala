package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class Exercise08Test extends FreeSpec with ChiselScalatestTester {
"Exercise 08 Test" in {
    
    test(new Exercise08) { c =>
    
    c.io.data_in(0).poke(1.U)
    c.io.data_in(1).poke(0.U)
    c.io.data_in(2).poke(0.U)
    c.io.data_in(3).poke(1.U)
    
    c.io.data_selector.poke(1.U)
    c.io.addr.poke(1.U)       
    c.io.wr_en.poke(true.B)        

    c.clock.step(10)

    c.io.data_out.expect(0.U)

    }
}
}