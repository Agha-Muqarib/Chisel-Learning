package Lab06

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class Task04Test extends FreeSpec with ChiselScalatestTester{
    
    "Task 04 Test" in {
        
        test(new Task04(10)) { c =>

            c.io.up_down.poke(false.B)  
            c.clock.step(20)

            c.io.up_down.poke(true.B)
            c.clock.step(20)
            
        }
    }
}