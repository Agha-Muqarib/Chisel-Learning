package Lab05

import org.scalatest._
import chiseltest._
import chisel3._

class Example03Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 03 Test" in {
    
        test(new Example03(UInt(32.W))) { c =>

        c.io.in1.poke(2.U)
        c.io.in2.poke(3.U)

        c.io.sel.poke(1.B)
     
        c.clock.step(10)

        c.io.out1.expect(3.U)
        c.io.out2.expect(2.U)
   
        }
    }
}