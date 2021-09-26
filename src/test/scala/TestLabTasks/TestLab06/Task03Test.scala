package Lab06

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class Task03Test extends FreeSpec with ChiselScalatestTester {
    
    "Task 03 Test" in {

        test(new Task03(1)) { c =>

            c.io.load_in(0).poke(1.B)
            c.io.load.poke(0.B)  

            c.clock.step(20)

            c.io.out(0).expect(1.B)
            
        }
    }
}