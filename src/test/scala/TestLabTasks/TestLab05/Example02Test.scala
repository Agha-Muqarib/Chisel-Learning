package Lab05

import org.scalatest._
import chiseltest._
import chisel3._

class Example02Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 02 Test" in {
    
        test(new Example02(SInt(32.W))) { c =>

        c.io.in1.poke(2.S)
        c.io.in2.poke(3.S)

        c.io.sel.poke(1.B)

        c.clock.step(10)

        c.io.out.expect(2.S)


   
        }
    }
}