package Lab05

import org.scalatest._
import chiseltest._
import chisel3._

class Ass01Test extends FreeSpec with ChiselScalatestTester {
    
    "Ass 01 Test" in {
    
        test(new adder(32)) { c =>

        c.io.in0.poke(3.U)
        c.io.in1.poke(3.U)

        c.clock.step(10)

        c.io.sum.expect(6.U)
        
        }
    }
}