package Lab05

import org.scalatest._
import chiseltest._
import chisel3._

class Example05Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 05 Test" in {
    
        test(new Example05(18, 30, 32)) { c =>

        c.io.in.poke(4.U)     
        c.clock.step(10)
        c.io.out.expect(8.U)
        
        }
    }
}