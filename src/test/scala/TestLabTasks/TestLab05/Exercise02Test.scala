package Lab05

import org.scalatest._
import chiseltest._
import chisel3._

class Exercise02Test extends FreeSpec with ChiselScalatestTester {
    
    "Exercise 02 Test" in {
    
        test(new Exercise02(UInt(32.W))) { c =>

        c.io.in1.poke(2.U)
        c.io.in2.poke(3.U)

        c.io.sel.poke(0.B)

        c.clock.step(10)

        c.io.out.expect(3.U)

        }
    }
}