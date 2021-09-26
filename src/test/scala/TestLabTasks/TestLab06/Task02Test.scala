package Lab06

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class Task02Test extends FreeSpec with ChiselScalatestTester {

    "Task 02 Test" in {

        test(new Task02(4)) {c =>

            c.io.in.poke(10.U)
            c.clock.step(14)            
        }
    }
}