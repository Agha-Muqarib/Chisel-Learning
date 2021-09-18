package Lab03

import org.scalatest._
import chiseltest._
import chisel3._

class Example04Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 04 Test" in {
        
        test(new ALU) { c =>
        c.io.in_A.poke(1.U)
        c.io.in_B.poke(1.U)
        c.io.alu_Op.poke(0.U)
    
        c.clock.step(1)
    
        c.io.out.expect(2.U)
        c.io.sum.expect(2.U)
   
        }
    }
}