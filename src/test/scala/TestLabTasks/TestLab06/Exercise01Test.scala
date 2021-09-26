package Lab06

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class Exercise01Test extends FreeSpec with ChiselScalatestTester{
    
    "Exercise 01 Test" in {

        test(new Exercise01(4)) {c =>
           
            c.io.in.poke(13.U)
            c.clock.step(5)
            c.io.out.expect(0.B)
            
        }
    }
}