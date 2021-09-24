package Lab05

import org.scalatest._
import chiseltest._
import chisel3._

class Example07Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 07 Test" in {
    
        test(new Operator(4, UInt(32.W))(_ & _)) { c =>

        c.io.in(0).poke(2.U)
        c.io.in(1).poke(4.U)
        c.io.in(2).poke(3.U)
        c.io.in(3).poke(5.U)

        c.clock.step(10)

        c.io.out.expect(0.U)
   
        }
    }
}