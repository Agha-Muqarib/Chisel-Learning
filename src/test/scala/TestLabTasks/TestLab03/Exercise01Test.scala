package Lab03

import org.scalatest._
import chiseltest._
import chisel3._

class Exercise01Test extends FreeSpec with ChiselScalatestTester {
    
    "Exercise 01 Test" in {
        
        test(new Encoder_Switch){c =>
        
        c.io.in.poke(2.U)
        
        c.clock.step(1)
        
        c.io.out.expect(1.U)
        
        }
    }
}

