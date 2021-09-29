package Lab08

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class Exercise03Test extends FreeSpec with ChiselScalatestTester {

    "Exercise 03 Test" in {

        test(new InsMem) { c =>
        c.io.input.poke(2.U)
        c.clock.step(10)      
    
        }
    }
}