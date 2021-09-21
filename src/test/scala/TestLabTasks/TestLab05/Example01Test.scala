package Lab05

import org.scalatest._
import chiseltest._
import chisel3._

class Example01Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 01 Test" in {
    
        test(new Example01(32)) { c =>

        c.io.arg_x.poke(1.U)
        c.io.arg_y.poke(1.U)

        c.io.alu_oper.poke(2.U)
     
        c.clock.step(10)

        c.io.alu_out.expect(2.U)


   
        }
    }
}