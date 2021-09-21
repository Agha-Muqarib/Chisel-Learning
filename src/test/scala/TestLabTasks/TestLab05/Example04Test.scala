package Lab05

import org.scalatest._
import chiseltest._
import chisel3._

class Example04Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 04 Test" in {
    
        test(new Example04(UInt(32.W))) { c =>

        c.io.in1.poke(3.U)
        c.io.in2.poke(3.U)

        c.io.sel.poke(1.B)
     
        c.clock.step(10)

        c.io.out.expect(6.U)
        
        }
    }
}