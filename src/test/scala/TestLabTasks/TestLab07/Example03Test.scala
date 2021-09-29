package Lab07

import chisel3._
import org.scalatest._
import chiseltest._

class Example03Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 03" in {
        
        test(new UART_Tx(new UART_Params)) {c =>
        
        // c.io.data_in.poke(3.U)
        c.clock.step(20)
        // c.io.out.expect(true.B)

        c.io.en.poke(true.B)
        // c.io.in.ready.ex(true.B)
        c.io.in.valid.poke(true.B)        
        c.io.in.bits.poke("b101".U)
        c.io.div.poke(5.U)
        c.io.nstop.poke(2.U)

    }
  }
}