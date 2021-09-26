package Lab06

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class Exercise04Test extends FreeSpec with ChiselScalatestTester{
   
    "Exercise 04 Test" in {

        test(new Exercise04) { c =>

            c.io.in.valid.poke(true.B)
            c.io.in.bits.poke(2.U)  
            c.io.out.ready.poke(true.B)
            
            c.clock.step(10)

        }
    }
}