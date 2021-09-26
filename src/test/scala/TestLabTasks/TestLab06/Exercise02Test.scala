package Lab06

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class Exercise02Test extends FreeSpec with ChiselScalatestTester {

    "Exercise 02 Test" in {

        test(new Exercise02(2)) { c =>

            c.clock.step(1)
            c.io.out.expect(1.U)
            
        }
    }
}